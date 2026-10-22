package com.obric.cae.location.util;

import android.location.Location;
import com.obric.cae.libs.location.CoordinateTransformUtils;
import ha.m;
import ha.p;
import ha.r;
import ha.s;
import ha.u;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class AoiBoardUtil {
    private static final Map<String, List<Point>> AOI_POINTS_CACHE = null;
    private static final double CONTAINS_TOLERANCE_METERS = 0.01d;
    private static final double EARTH_RADIUS_METERS = 6378137.0d;
    private static final double EPSILON = 1.0E-7d;

    /* JADX INFO: renamed from: com.obric.cae.location.util.AoiBoardUtil$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class AoiGeometry {
        private final Point center;
        private final int pointCount;
        private final double radiusMeters;

        public AoiGeometry(Point r8, double r10, int r11) {
            this.center = r8;
            this.radiusMeters = r10;
            this.pointCount = r11;
        }

        public boolean contains(Point r8) {
            return contains(r8, AoiBoardUtil.CONTAINS_TOLERANCE_METERS);
        }

        public Point getCenter() {
            return this.center;
        }

        public double getCenterLatitude() {
            return this.center.getLatitude();
        }

        public double getCenterLongitude() {
            return this.center.getLongitude();
        }

        public int getPointCount() {
            return this.pointCount;
        }

        public double getRadiusMeters() {
            return this.radiusMeters;
        }

        public boolean contains(Point r8, double r10) {
            double r11 = AoiBoardUtil.calculateDistanceMeters(this.center, r8);
            double r12 = this.radiusMeters;
            if (r11 > (Math.max(r10, 0.0d) + r12)) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public static final class Point {
        private final double latitude;
        private final double longitude;

        public Point(double r8, double r10) {
            this.longitude = r8;
            this.latitude = r10;
        }

        public static /* synthetic */ boolean access$500(Point r8, Point r10) {
            return r8.sameCoordinate(r10);
        }

        private boolean sameCoordinate(Point r8) {
            if (Double.compare(this.longitude, r8.longitude) == 0) goto L5;
        L7:
            return false;
        L5:
            if (Double.compare(this.latitude, r8.latitude) != 0) goto L7;
            return true;
        }

        public double getLatitude() {
            return this.latitude;
        }

        public double getLongitude() {
            return this.longitude;
        }
    }

    public static final class ProjectedCircle {
        private final double centerX;
        private final double centerY;
        private final double radiusMeters;

        private ProjectedCircle(double r8, double r10, double r11) {
            this.centerX = r8;
            this.centerY = r10;
            this.radiusMeters = r11;
        }

        public static /* synthetic */ double access$000(ProjectedCircle r8) {
            return r8.centerX;
        }

        public static /* synthetic */ double access$100(ProjectedCircle r8) {
            return r8.centerY;
        }

        public static /* synthetic */ double access$200(ProjectedCircle r8) {
            return r8.radiusMeters;
        }

        public static /* synthetic */ boolean access$600(ProjectedCircle r8, ProjectedPoint r10) {
            return r8.contains(r10);
        }

        private boolean contains(ProjectedPoint r10) {
            if (AoiBoardUtil.access$900(this.centerX, this.centerY, ProjectedPoint.access$400(r10), ProjectedPoint.access$300(r10)) > (this.radiusMeters + AoiBoardUtil.EPSILON)) goto L5;
            return true;
        L5:
            return false;
        }

        public /* synthetic */ ProjectedCircle(double r8, double r10, double r11, AnonymousClass1 r12) {
            this(r8, r10, r11);
        }
    }

    public static final class ProjectedPoint {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        private final double f5696x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        private final double f5697y;

        private ProjectedPoint(double r8, double r10) {
            this.f5696x = r8;
            this.f5697y = r10;
        }

        public static /* synthetic */ double access$300(ProjectedPoint r8) {
            return r8.f5697y;
        }

        public static /* synthetic */ double access$400(ProjectedPoint r8) {
            return r8.f5696x;
        }

        public /* synthetic */ ProjectedPoint(double r8, double r10, AnonymousClass1 r11) {
            this(r8, r10);
        }
    }

    public static final class Projection {
        private final double cosReferenceLatitude;
        private final double originLatitude;
        private final double originLongitude;

        private Projection(double r8, double r10, double r11) {
            this.originLongitude = r8;
            this.originLatitude = r10;
            this.cosReferenceLatitude = r11;
        }

        public static Projection from(List<Point> r14) {
            Iterator<Point> r8 = r14.iterator();
            double r10 = 0.0d;
            double r11 = 0.0d;
        L4:
            if (r8.hasNext() == false) goto L6;
            Point r12 = r8.next();
            r10 = r10 + r12.getLongitude();
            r11 = r11 + r12.getLatitude();
            goto L4
        L6:
            double r13 = r10 / ((double) r14.size());
            double r15 = r11 / ((double) r14.size());
            double r16 = Math.cos(Math.toRadians(r15));
            if (Math.abs(r16) > AoiBoardUtil.EPSILON) goto L9;
            double r17 = 1.0E-7d;
        L11:
            return new Projection(r13, r15, r17);
        L9:
            r17 = r16;
            goto L11
        }

        public ProjectedPoint project(Point r13) {
            double r8 = this.cosReferenceLatitude * AoiBoardUtil.EARTH_RADIUS_METERS;
            return new ProjectedPoint(Math.toRadians(r13.getLongitude() - this.originLongitude) * r8, Math.toRadians(r13.getLatitude() - this.originLatitude) * AoiBoardUtil.EARTH_RADIUS_METERS, null);
        }

        public Point unproject(double r8, double r10) {
            double r11 = this.originLongitude;
            double r12 = Math.toDegrees(r8 / (this.cosReferenceLatitude * AoiBoardUtil.EARTH_RADIUS_METERS)) + r11;
            double r13 = this.originLatitude;
            return new Point(r12, Math.toDegrees(r10 / AoiBoardUtil.EARTH_RADIUS_METERS) + r13);
        }
    }

    static {
        AOI_POINTS_CACHE = new ConcurrentHashMap();
    }

    private AoiBoardUtil() {
    }

    public static /* synthetic */ List a(String r8) {
        return parsePointsInternal(r8);
    }

    public static /* synthetic */ double access$900(double r8, double r10, double r11, double r12) {
        return distance(r8, r10, r11, r12);
    }

    private static void appendAoiCoordinates(m r8, StringBuilder r10) {
        if (r8 != null) goto L4;
        return;
    L4:
        if (r8.isEmpty() == true) goto L50;
        p r11 = r8.o(0);
        if (r11 != null) goto L9;
        return;
    L9:
        if ((r11 instanceof r) == false) goto L11;
        return;
    L11:
        if ((r11 instanceof m) == false) goto L51;
        m r12 = r11.e();
        if (r12.isEmpty() == true) goto L16;
        p r13 = r12.o(0);
    L17:
        if (r13 != null) goto L19;
    L27:
        Iterator<p> r14 = r8.iterator();
    L29:
        if (r14.hasNext() == false) goto L52;
        p r15 = r14.next();
        if (r15 == null) goto L29;
        if ((r15 instanceof r) == true) goto L29;
        if ((r15 instanceof m) == false) goto L29;
        appendAoiCoordinates(r15.e(), r10);
        goto L29
    L52:
        return;
    L19:
        if ((r13 instanceof u) == false) goto L27;
        if ((r13.g().f8004a instanceof Number) == false) goto L27;
        Iterator<p> r16 = r8.iterator();
    L24:
        if (r16.hasNext() == false) goto L26;
        appendConvertedAoiPoint(r16.next(), r10);
        goto L24
    L26:
        return;
    L16:
        r13 = null;
        goto L17
    L51:
        return;
    }

    private static void appendConvertedAoiPoint(p r8, StringBuilder r10) {
        if (r8 != null) goto L4;
        return;
    L4:
        if ((r8 instanceof r) == false) goto L6;
        return;
    L6:
        if ((r8 instanceof m) == false) goto L29;
        m r11 = r8.e();
        if (r11.size() >= 2) goto L11;
        return;
    L11:
        p r12 = r11.o(0);
        p r13 = r11.o(1);
        if (r12 == null) goto L26;
        if (r13 != null) goto L15;
        return;
    L15:
        if ((r12 instanceof u) == true) goto L17;
        return;
    L17:
        if ((r13 instanceof u) == false) goto L30;
        Location r14 = new Location("");
        r14.setLongitude(r12.c());
        r14.setLatitude(r13.c());
        Location r15 = CoordinateTransformUtils.convertLocation(CoordinateTransformUtils.CoordinateSystem.GCJ02, CoordinateTransformUtils.CoordinateSystem.WGS84, r14);
        if (r15 != null) goto L22;
        return;
    L22:
        r10.append(r15.getLongitude());
        r10.append(",");
        r10.append(r15.getLatitude());
        r10.append(";");
        return;
    L30:
        return;
    L26:
        return;
    }

    private static List<Point> buildProjectionSeed(List<Point> r8, Point r10) {
        ArrayList r11 = new ArrayList(r8.size() + 1);
        r11.addAll(r8);
        r11.add(r10);
        return r11;
    }

    private static double calculateDistanceMeters(double r37, double r39, double r41, double r43) {
        double r8 = Math.toRadians(r37);
        double r10 = Math.toRadians(r41);
        double r11 = Math.toRadians(r43 - r39);
        double r12 = Math.atan(Math.tan(r8) * 0.996647189328169d);
        double r13 = Math.atan(Math.tan(r10) * 0.996647189328169d);
        double r14 = Math.sin(r12);
        double r15 = Math.cos(r12);
        double r16 = Math.sin(r13);
        double r17 = Math.cos(r13);
        int r18 = 0;
        double r19 = r11;
        double r110 = 0.0d;
        double r111 = 0.0d;
        double r112 = 0.0d;
        double r21 = 0.0d;
        double r23 = 0.0d;
    L4:
        if (r18 >= 20) goto L16;
        double r113 = Math.sin(r19);
        double r114 = Math.cos(r19);
        int r310 = r18;
        double r40 = r19;
        double r42 = r11;
        double r20 = Math.hypot(r17 * r113, (r15 * r16) - ((r14 * r17) * r114));
        if (r20 <= EPSILON) goto L7;
        double r115 = r15 * r17;
        double r116 = (r114 * r115) + (r14 * r16);
        double r117 = Math.atan2(r20, r116);
        double r118 = (r115 * r113) / r20;
        r21 = 1.0d - (r118 * r118);
        double r119 = (r14 * 2.0d) * r16;
        if (r21 > EPSILON) goto L11;
        double r120 = 1.0d;
    L12:
        r23 = r116 - (r119 / r120);
        double r121 = (((4.0d - (3.0d * r21)) * 0.0033528106718309896d) + 4.0d) * (2.0955066698943685E-4d * r21);
        double r35 = ((((((((r23 * 2.0d) * r23) - 1.0d) * (r121 * r116)) + r23) * (r121 * r20)) + r117) * (((1.0d - r121) * 0.0033528106718309896d) * r118)) + r42;
        if (Math.abs(r35 - r40) < 1.0E-12d) goto L14;
        r18 = r310 + 1;
        r112 = r117;
        r111 = r116;
        r19 = r35;
        r110 = r20;
        r11 = r42;
        goto L4
    L14:
        r112 = r117;
        r111 = r116;
        r110 = r20;
        goto L16
    L11:
        r120 = r21;
        goto L12
    L7:
        return 0.0d;
    L16:
        double r22 = (r21 * 2.723316066819453E11d) / 4.0408299984087055E13d;
        double r24 = (((((74.0d - (47.0d * r22)) * r22) - 128.0d) * r22) + 256.0d) * (r22 / 1024.0d);
        double r31 = ((4.0d * r23) * r23) - 3.0d;
        return (r112 - ((((((((2.0d * r23) * r23) - 1.0d) * r111) - (r31 * ((((r110 * 4.0d) * r110) - 3.0d) * ((r24 / 6.0d) * r23)))) * (r24 / 4.0d)) + r23) * (r24 * r110))) * ((((((((320.0d - (175.0d * r22)) * r22) - 768.0d) * r22) + 4096.0d) * (r22 / 16384.0d)) + 1.0d) * 6356752.3142d);
    }

    private static double calculateDistanceToBoundaryMeters(List<Point> r10, Point r11) {
        int r8 = 0;
        if (r10.size() == 1) goto L5;
        Projection r12 = Projection.from(buildProjectionSeed(r10, r11));
        ArrayList r13 = new ArrayList(r10.size());
        Iterator<Point> r14 = r10.iterator();
    L8:
        if (r14.hasNext() == false) goto L10;
        r13.add(r12.project(r14.next()));
        goto L8
    L10:
        ProjectedPoint r15 = r12.project(r11);
        if (r10.size() == 2) goto L13;
        int r16 = r13.size() - 1;
        double r17 = Double.MAX_VALUE;
    L16:
        if (r8 >= r13.size()) goto L18;
        r17 = Math.min(r17, distanceToSegmentMeters(r15, (ProjectedPoint) r13.get(r16), (ProjectedPoint) r13.get(r8)));
        int r18 = r8;
        r8 = r8 + 1;
        r16 = r18;
        goto L16
    L18:
        return r17;
    L13:
        return distanceToSegmentMeters(r15, (ProjectedPoint) r13.get(0), (ProjectedPoint) r13.get(1));
    L5:
        return calculateDistanceMeters(r10.get(0), r11);
    }

    public static AoiGeometry calculateGeometry(String r8) {
        List<Point> r10 = parsePoints(r8);
        if (r10.isEmpty() == false) goto L7;
        return null;
    L7:
        return calculateGeometry(r10);
    }

    public static float calculateShortestDistanceToAoiBoard(String r8, double r10, double r11) {
        if (isValidCoordinate(r10, r11) == true) goto L5;
        return Float.MAX_VALUE;
    L5:
        List<Point> r12 = parsePoints(r8);
        if (r12.isEmpty() == false) goto L8;
        return Float.MAX_VALUE;
    L8:
        Point r13 = new Point(r11, r10);
        if (containsPoint(r12, r13) == false) goto L13;
        return 0.0f;
    L13:
        return (float) calculateDistanceToBoundaryMeters(r12, r13);
    }

    private static boolean containsAll(ProjectedCircle r8, List<ProjectedPoint> r10) {
        Iterator<ProjectedPoint> r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L9;
        if (ProjectedCircle.access$600(r8, r11.next()) == true) goto L4;
        return false;
    L9:
        return true;
    }

    private static boolean containsPoint(List<Point> r19, Point r20) {
        if (r19.size() == 1) goto L5;
        Projection r8 = Projection.from(buildProjectionSeed(r19, r20));
        ArrayList r10 = new ArrayList(r19.size());
        Iterator<Point> r11 = r19.iterator();
    L10:
        if (r11.hasNext() == false) goto L12;
        r10.add(r8.project(r11.next()));
        goto L10
    L12:
        ProjectedPoint r12 = r8.project(r20);
        if (r19.size() == 2) goto L15;
        int r13 = r10.size() - 1;
        int r14 = 0;
        boolean r15 = false;
    L20:
        if (r14 >= r10.size()) goto L40;
        ProjectedPoint r16 = (ProjectedPoint) r10.get(r14);
        ProjectedPoint r17 = (ProjectedPoint) r10.get(r13);
        if (distanceToSegmentMeters(r12, r17, r16) <= CONTAINS_TOLERANCE_METERS) goto L23;
        if (ProjectedPoint.access$300(r16) <= ProjectedPoint.access$300(r12)) goto L27;
        boolean r18 = true;
    L29:
        if (ProjectedPoint.access$300(r17) <= ProjectedPoint.access$300(r12)) goto L31;
        boolean r110 = true;
    L32:
        if (r18 != r110) goto L34;
    L36:
        boolean r21 = false;
    L37:
        if (r21 == false) goto L39;
        r15 = !r15;
    L39:
        r13 = r14;
        r14 = r14 + 1;
        goto L20
    L34:
        if (ProjectedPoint.access$400(r12) >= ((((ProjectedPoint.access$300(r12) - ProjectedPoint.access$300(r16)) * (ProjectedPoint.access$400(r17) - ProjectedPoint.access$400(r16))) / (ProjectedPoint.access$300(r17) - ProjectedPoint.access$300(r16))) + ProjectedPoint.access$400(r16))) goto L36;
        r21 = true;
        goto L37
    L31:
        r110 = false;
        goto L32
    L27:
        r18 = false;
        goto L29
    L23:
        return true;
    L40:
        return r15;
    L15:
        if (distanceToSegmentMeters(r12, (ProjectedPoint) r10.get(0), (ProjectedPoint) r10.get(1)) <= CONTAINS_TOLERANCE_METERS) goto L17;
        return false;
    L17:
        return true;
    L5:
        if (calculateDistanceMeters(r19.get(0), r20) <= CONTAINS_TOLERANCE_METERS) goto L7;
        return false;
    L7:
        return true;
    }

    private static double cross(ProjectedPoint r8, ProjectedPoint r10, double r11, double r12) {
        double r13 = ProjectedPoint.access$400(r10) - ProjectedPoint.access$400(r8);
        double r14 = (r12 - ProjectedPoint.access$300(r8)) * r13;
        double r15 = ProjectedPoint.access$300(r10) - ProjectedPoint.access$300(r8);
        return r14 - ((r11 - ProjectedPoint.access$400(r8)) * r15);
    }

    private static double distance(double r8, double r10, double r11, double r12) {
        return Math.hypot(r8 - r11, r10 - r12);
    }

    private static double distanceToSegmentMeters(ProjectedPoint r16, ProjectedPoint r17, ProjectedPoint r18) {
        double r8 = ProjectedPoint.access$400(r18) - ProjectedPoint.access$400(r17);
        double r10 = ProjectedPoint.access$300(r18) - ProjectedPoint.access$300(r17);
        if (Math.abs(r8) <= EPSILON) goto L5;
    L8:
        double r11 = (ProjectedPoint.access$400(r16) - ProjectedPoint.access$400(r17)) * r8;
        double r12 = ((ProjectedPoint.access$300(r16) - ProjectedPoint.access$300(r17)) * r10) + r11;
        double r13 = r10 * r10;
        double r14 = Math.max(0.0d, Math.min(1.0d, r12 / (r13 + (r8 * r8))));
        double r15 = r8 * r14;
        double r19 = r15 + ProjectedPoint.access$400(r17);
        double r20 = r14 * r10;
        double r110 = r20 + ProjectedPoint.access$300(r17);
        return distance(ProjectedPoint.access$400(r16), ProjectedPoint.access$300(r16), r19, r110);
    L5:
        if (Math.abs(r10) > EPSILON) goto L8;
        return distance(ProjectedPoint.access$400(r16), ProjectedPoint.access$300(r16), ProjectedPoint.access$400(r17), ProjectedPoint.access$300(r17));
    }

    public static boolean isAoiBoardCoveredByCircle(String r8, double r10, double r11, double r12) {
        if (isValidCoordinate(r10, r11) == true) goto L5;
    L18:
        return false;
    L5:
        if (r12 < 0.0d) goto L18;
        List<Point> r13 = parsePoints(r8);
        if (r13.isEmpty() == false) goto L10;
        return false;
    L10:
        Point r14 = new Point(r11, r10);
        Iterator<Point> r15 = r13.iterator();
    L12:
        if (r15.hasNext() == false) goto L16;
        if (calculateDistanceMeters(r14, r15.next()) <= (CONTAINS_TOLERANCE_METERS + r12)) goto L12;
        return false;
    L16:
        return true;
    }

    public static boolean isInAoiBoard(String r8, double r10, double r11) {
        if (isValidCoordinate(r10, r11) == true) goto L5;
        return false;
    L5:
        List<Point> r12 = parsePoints(r8);
        if (r12.isEmpty() == false) goto L9;
        return false;
    L9:
        return containsPoint(r12, new Point(r11, r10));
    }

    private static boolean isValidCoordinate(double r8, double r10) {
        if (Double.isNaN(r8) == false) goto L5;
    L15:
        return false;
    L5:
        if (Double.isNaN(r10) == true) goto L15;
        if (r8 < (-90.0d)) goto L15;
        if (r8 > 90.0d) goto L15;
        if (r10 < (-180.0d)) goto L15;
        if (r10 > 180.0d) goto L15;
        return true;
    }

    private static ProjectedCircle makeCircleWithOneBoundaryPoint(List<ProjectedPoint> r10, ProjectedPoint r11) {
        ProjectedCircle r8 = new ProjectedCircle(ProjectedPoint.access$400(r11), ProjectedPoint.access$300(r11), 0.0d, null);
        int r12 = 0;
    L4:
        if (r12 >= r10.size()) goto L13;
        ProjectedPoint r13 = r10.get(r12);
        if (ProjectedCircle.access$600(r8, r13) == true) goto L12;
        if (ProjectedCircle.access$200(r8) > EPSILON) goto L10;
        ProjectedCircle r14 = makeDiameterCircle(r11, r13);
    L11:
        r8 = r14;
        goto L12
    L10:
        r14 = makeCircleWithTwoBoundaryPoints(r10.subList(0, r12 + 1), r11, r13);
    L12:
        r12 = r12 + 1;
        goto L4
    L13:
        return r8;
    }

    private static ProjectedCircle makeCircleWithTwoBoundaryPoints(List<ProjectedPoint> r12, ProjectedPoint r13, ProjectedPoint r14) {
        ProjectedCircle r8 = makeDiameterCircle(r13, r14);
        if (containsAll(r8, r12) == false) goto L5;
        return r8;
    L5:
        Iterator<ProjectedPoint> r15 = r12.iterator();
        ProjectedCircle r10 = null;
        ProjectedCircle r11 = null;
    L7:
        if (r15.hasNext() == false) goto L24;
        ProjectedPoint r16 = r15.next();
        double r17 = cross(r13, r14, r16);
        if (Math.abs(r17) <= EPSILON) goto L7;
        ProjectedCircle r18 = makeCircumcircle(r13, r14, r16);
        if (r18 == null) goto L7;
        if (r17 > 0.0d) goto L16;
        if (r11 == null) goto L23;
        if (cross(r13, r14, ProjectedCircle.access$000(r18), ProjectedCircle.access$100(r18)) >= cross(r13, r14, ProjectedCircle.access$000(r11), ProjectedCircle.access$100(r11))) goto L7;
    L23:
        r11 = r18;
        goto L7
    L16:
        if (r10 == null) goto L19;
        if (cross(r13, r14, ProjectedCircle.access$000(r18), ProjectedCircle.access$100(r18)) <= cross(r13, r14, ProjectedCircle.access$000(r10), ProjectedCircle.access$100(r10))) goto L7;
    L19:
        r10 = r18;
        goto L7
    L24:
        if (r10 != null) goto L27;
        if (r11 != null) goto L27;
        return r8;
    L27:
        if (r10 != null) goto L29;
        return r11;
    L29:
        if (r11 != null) goto L32;
        return r10;
    L32:
        if (ProjectedCircle.access$200(r10) > ProjectedCircle.access$200(r11)) goto L35;
        return r10;
    L35:
        return r11;
    }

    private static ProjectedCircle makeCircumcircle(ProjectedPoint r32, ProjectedPoint r33, ProjectedPoint r34) {
        double r8 = ProjectedPoint.access$400(r32);
        double r10 = ProjectedPoint.access$300(r32);
        double r11 = ProjectedPoint.access$400(r33);
        double r12 = ProjectedPoint.access$300(r33);
        double r13 = ProjectedPoint.access$400(r34);
        double r14 = ProjectedPoint.access$300(r34);
        double r15 = r12 - r14;
        double r16 = r14 - r10;
        double r18 = r11 * r16;
        double r19 = r18 + (r8 * r15);
        double r17 = r10 - r12;
        double r20 = ((r13 * r17) + r19) * 2.0d;
        if (Math.abs(r20) > EPSILON) goto L6;
        return null;
    L6:
        double r22 = r10 * r10;
        double r23 = r22 + (r8 * r8);
        double r21 = r12 * r12;
        double r24 = r21 + (r11 * r11);
        double r110 = r14 * r14;
        double r111 = r110 + (r13 * r13);
        double r112 = r16 * r24;
        double r113 = r17 * r111;
        double r25 = (r113 + (r112 + (r15 * r23))) / r20;
        double r114 = (r13 - r11) * r23;
        double r26 = (r11 - r8) * r111;
        double r27 = (r26 + (((r8 - r13) * r24) + r114)) / r20;
        return new ProjectedCircle(r25, r27, distance(r25, r27, r8, r10), null);
    }

    private static ProjectedCircle makeDiameterCircle(ProjectedPoint r12, ProjectedPoint r13) {
        double r8 = (ProjectedPoint.access$400(r12) + ProjectedPoint.access$400(r13)) / 2.0d;
        double r10 = (ProjectedPoint.access$300(r12) + ProjectedPoint.access$300(r13)) / 2.0d;
        return new ProjectedCircle(r8, r10, distance(r8, r10, ProjectedPoint.access$400(r12), ProjectedPoint.access$300(r12)), null);
    }

    private static ProjectedCircle makeMinimumEnclosingCircle(List<ProjectedPoint> r8) {
        ProjectedCircle r10 = null;
        if (r8.isEmpty() == false) goto L5;
        return null;
    L5:
        ArrayList r11 = new ArrayList(r8);
        Collections.shuffle(r11, new Random(0));
        int r12 = 0;
    L7:
        if (r12 >= r11.size()) goto L14;
        ProjectedPoint r13 = (ProjectedPoint) r11.get(r12);
        if (r10 != null) goto L11;
    L12:
        r10 = makeCircleWithOneBoundaryPoint(r11.subList(0, r12 + 1), r13);
    L13:
        r12 = r12 + 1;
        goto L7
    L11:
        if (ProjectedCircle.access$600(r10, r13) == true) goto L13;
    L14:
        return r10;
    }

    public static String parseAndConvertGeoJsonAoiBoard(p r8) {
        s r10 = resolveGeometryObject(r8);
        if (r10 != null) goto L5;
    L19:
        return "";
    L5:
        if (r10.t("coordinates") == false) goto L19;
        p r11 = r10.p("coordinates");
        if (r11 == null) goto L19;
        if ((r11 instanceof m) == false) goto L19;
        StringBuilder r12 = new StringBuilder();
        appendAoiCoordinates(r11.e(), r12);
        if (r12.length() <= 0) goto L18;
        if (r12.charAt(r12.length() - 1) != ';') goto L18;
        r12.deleteCharAt(r12.length() - 1);
    L18:
        return r12.toString();
    }

    private static Double parseDouble(String r8) {
        if (r8 != null) goto L10;
        return null;
    L10:
        double r10 = Double.parseDouble(r8.trim());     // Catch: NumberFormatException -> L9
        if (Double.isFinite(r10) == false) goto L12;
        return Double.valueOf(r10);
    L12:
        return null;
    L13:
        return null;
    }

    private static p parseJsonElementLenient(String r8) {
        if (r8 != null) goto L5;
    L9:
        return null;
    L5:
        if (r8.trim().isEmpty() == true) goto L9;
        pa.a r10 = new pa.a(new StringReader(r8));     // Catch: Exception -> L10
        r10.f9952b = true;     // Catch: Exception -> L10
        return l6.a.y0(r10);
    }

    public static List<Point> parsePoints(String r8) {
        if (r8 == null) goto L9;
        if (r8.trim().isEmpty() == true) goto L9;
        String r10 = r8.trim();
        return AOI_POINTS_CACHE.computeIfAbsent(r10, new com.google.protobuf.d(6));
    L9:
        return Collections.emptyList();
    }

    private static List<Point> parsePointsInternal(String r10) {
        ArrayList r8 = new ArrayList();
        String[] r11 = r10.split(";");
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L21;
        String r14 = r11[r13];
        if (r14 == null) goto L20;
        String r15 = r14.trim();
        if (r15.isEmpty() == true) goto L20;
        String[] r16 = r15.split(",");
        if (r16.length != 2) goto L20;
        Double r17 = parseDouble(r16[0]);
        Double r18 = parseDouble(r16[1]);
        if (r17 == null) goto L20;
        if (r18 == null) goto L20;
        if (isValidCoordinate(r18.doubleValue(), r17.doubleValue()) == false) goto L20;
        r8.add(new Point(r17.doubleValue(), r18.doubleValue()));
    L20:
        r13 = r13 + 1;
        goto L3
    L21:
        removeDuplicatedClosingPoint(r8);
        if (r8.isEmpty() == false) goto L26;
        return Collections.emptyList();
    L26:
        return Collections.unmodifiableList(r8);
    }

    private static void removeDuplicatedClosingPoint(List<Point> r8) {
        if (r8.size() >= 2) goto L6;
        return;
    L6:
        if (Point.access$500(r8.get(0), r8.get(r8.size() - 1)) == false) goto L9;
        r8.remove(r8.size() - 1);
        return;
    }

    private static s resolveGeometryObject(p r8) {
        if (r8 != null) goto L5;
    L16:
        return null;
    L5:
        if ((r8 instanceof r) == true) goto L16;
        if ((r8 instanceof u) == false) goto L10;
        r8 = parseJsonElementLenient(r8.j());
    L10:
        if (r8 == null) goto L16;
        if ((r8 instanceof s) == false) goto L16;
        return r8.f();
    }

    public static double calculateDistanceMeters(Point r8, Point r10) {
        return calculateDistanceMeters(r8.getLatitude(), r8.getLongitude(), r10.getLatitude(), r10.getLongitude());
    }

    public static AoiGeometry calculateGeometry(List<Point> r8) {
        if (r8.isEmpty() == false) goto L5;
        return null;
    L5:
        Projection r10 = Projection.from(r8);
        ArrayList r11 = new ArrayList(r8.size());
        Iterator<Point> r12 = r8.iterator();
    L7:
        if (r12.hasNext() == false) goto L9;
        r11.add(r10.project(r12.next()));
        goto L7
    L9:
        ProjectedCircle r13 = makeMinimumEnclosingCircle(r11);
        if (r13 != null) goto L13;
        return null;
    L13:
        return new AoiGeometry(r10.unproject(ProjectedCircle.access$000(r13), ProjectedCircle.access$100(r13)), Math.max(ProjectedCircle.access$200(r13), 0.0d), r8.size());
    }

    private static double cross(ProjectedPoint r8, ProjectedPoint r10, ProjectedPoint r11) {
        return cross(r8, r10, ProjectedPoint.access$400(r11), ProjectedPoint.access$300(r11));
    }

    public static String parseAndConvertGeoJsonAoiBoard(String r8) {
        if (r8 != null) goto L4;
        return "";
    L4:
        if (r8.trim().isEmpty() == false) goto L7;
        return "";
    L7:
        return parseAndConvertGeoJsonAoiBoard(parseJsonElementLenient(r8));
    }
}
