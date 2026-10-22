package org.apache.commons.math3.stat.descriptive.rank;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.apache.commons.math3.analysis.interpolation.LinearInterpolator;
import org.apache.commons.math3.analysis.interpolation.NevilleInterpolator;
import org.apache.commons.math3.analysis.interpolation.UnivariateInterpolator;
import org.apache.commons.math3.exception.InsufficientDataException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic;
import org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic;
import org.apache.commons.math3.stat.descriptive.UnivariateStatistic;
import org.apache.commons.math3.util.MathArrays;
import org.apache.commons.math3.util.MathUtils;
import org.apache.commons.math3.util.Precision;

/* JADX INFO: loaded from: classes6.dex */
public class PSquarePercentile extends AbstractStorelessUnivariateStatistic implements Serializable, StorelessUnivariateStatistic {
    private static final DecimalFormat DECIMAL_FORMAT = null;
    private static final double DEFAULT_QUANTILE_DESIRED = 50.0d;
    private static final int PSQUARE_CONSTANT = 5;
    private static final long serialVersionUID = 2283912083175715479L;
    private long countOfObservations;
    private final List<Double> initialFive;
    private transient double lastObservation;
    private PSquareMarkers markers;
    private double pValue;
    private final double quantile;

    /* JADX INFO: renamed from: org.apache.commons.math3.stat.descriptive.rank.PSquarePercentile$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class FixedCapacityList<E> extends ArrayList<E> implements Serializable {
        private static final long serialVersionUID = 2283952083075725479L;
        private final int capacity;

        FixedCapacityList(int r1) {
            super(r1);
            this.capacity = r1;
        }

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean add(E r3) {
            if (size() < this.capacity) goto L7;
            return false;
        L7:
            return super.add(r3);
        }

        @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean addAll(Collection<? extends E> r4) {
            Collection<? extends E> r5 = (Collection) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.memorydata.plugin");
            if (r5 != null) goto L5;
        L7:
            boolean r1 = false;
        L8:
            if (r1 == true) goto L10;
            return false;
        L10:
            return super.addAll(r5);
        L5:
            if ((r5.size() + size()) > this.capacity) goto L7;
            r1 = true;
            goto L8
        }
    }

    private static class Marker implements Serializable, Cloneable {
        private static final long serialVersionUID = -3575879478288538431L;
        private double desiredMarkerIncrement;
        private double desiredMarkerPosition;
        private int index;
        private double intMarkerPosition;
        private transient UnivariateInterpolator linear;
        private double markerHeight;
        private transient Marker next;
        private final UnivariateInterpolator nonLinear;
        private transient Marker previous;

        private Marker() {
            this.nonLinear = new NevilleInterpolator();
            this.linear = new LinearInterpolator();
            this.previous = this;
            this.next = this;
        }

        private Marker(double r1, double r3, double r5, double r7) {
            this();
            this.markerHeight = r1;
            this.desiredMarkerPosition = r3;
            this.desiredMarkerIncrement = r5;
            this.intMarkerPosition = r7;
        }

        /* synthetic */ Marker(double r1, double r3, double r5, double r7, AnonymousClass1 r9) {
            this(r1, r3, r5, r7);
        }

        /* synthetic */ Marker(AnonymousClass1 r1) {
            this();
        }

        static /* synthetic */ Marker access$000(Marker r0, Marker r1) {
            return r0.previous(r1);
        }

        static /* synthetic */ Marker access$100(Marker r0, Marker r1) {
            return r0.next(r1);
        }

        static /* synthetic */ Marker access$200(Marker r0, int r1) {
            return r0.index(r1);
        }

        static /* synthetic */ double access$500(Marker r2) {
            return r2.markerHeight;
        }

        static /* synthetic */ double access$502(Marker r0, double r1) {
            r0.markerHeight = r1;
            return r1;
        }

        static /* synthetic */ double access$600(Marker r2) {
            return r2.estimate();
        }

        static /* synthetic */ void access$700(Marker r0, int r1) {
            r0.incrementPosition(r1);
        }

        static /* synthetic */ void access$800(Marker r0) {
            r0.updateDesiredPosition();
        }

        private double difference() {
            return this.desiredMarkerPosition - this.intMarkerPosition;
        }

        private double estimate() {
            double r1 = difference();
            Marker r3 = this.next;
            double r4 = r3.intMarkerPosition;
            double r6 = this.intMarkerPosition;
            if ((r4 - r6) <= 1.0d) goto L5;
            boolean r8 = true;
        L6:
            Marker r13 = this.previous;
            double r14 = r13.intMarkerPosition;
            if ((r14 - r6) >= (-1.0d)) goto L9;
            boolean r16 = true;
        L11:
            if (r1 < 1.0d) goto L14;
            if (r8 == false) goto L14;
        L17:
            if (r1 < 0.0d) goto L19;
            int r2 = 1;
        L20:
            double[] r5 = {r14, r6, r4};
            double[] r7 = {r13.markerHeight, this.markerHeight, r3.markerHeight};
            double r9 = r6 + ((double) r2);
            double r10 = this.nonLinear.interpolate(r5, r7).value(r9);
            this.markerHeight = r10;
            if (isEstimateBad(r7, r10) == true) goto L23;
        L27:
            incrementPosition(r2);
        L29:
            return this.markerHeight;
        L23:
            if ((r9 - r5[1]) <= 0.0d) goto L25;
            int r17 = 1;
        L26:
            int r18 = r17 + 1;
            double[] r11 = {r5[1], r5[r18]};
            double[] r12 = {r7[1], r7[r18]};
            MathArrays.sortInPlace(r11, new double[][]{r12});
            this.markerHeight = this.linear.interpolate(r11, r12).value(r9);
            goto L27
        L25:
            r17 = -1;
            goto L26
        L19:
            r2 = -1;
        L14:
            if (r1 > (-1.0d)) goto L29;
            if (r16 == false) goto L29;
        L9:
            r16 = false;
            goto L11
        L5:
            r8 = false;
            goto L6
        }

        private void incrementPosition(int r5) {
            this.intMarkerPosition += (double) r5;
        }

        private Marker index(int r1) {
            this.index = r1;
            return this;
        }

        private boolean isEstimateBad(double[] r3, double r4) {
            if (r4 > r3[0]) goto L5;
        L6:
            return true;
        L5:
            if (r4 >= r3[2]) goto L6;
            return false;
        }

        private Marker next(Marker r1) {
            MathUtils.checkNotNull(r1);
            this.next = r1;
            return this;
        }

        private Marker previous(Marker r1) {
            MathUtils.checkNotNull(r1);
            this.previous = r1;
            return this;
        }

        private void readObject(ObjectInputStream r1) {
            r1.defaultReadObject();
            this.next = this;
            this.previous = this;
            this.linear = new LinearInterpolator();
        }

        private void updateDesiredPosition() {
            this.desiredMarkerPosition += this.desiredMarkerIncrement;
        }

        public Object clone() {
            return new Marker(this.markerHeight, this.desiredMarkerPosition, this.desiredMarkerIncrement, this.intMarkerPosition);
        }

        public boolean equals(Object r8) {
            if (this == r8) goto L38;
            if (r8 == null) goto L37;
            if (ZeusTransformUtils.instanceOf(r8, Marker.class) == false) goto L37;
            Marker r9 = (Marker) ZeusTransformUtils.preCheckCast(r8, Marker.class, "com.obric.memorydata.plugin");
            if (Double.compare(this.markerHeight, r9.markerHeight) != 0) goto L11;
            boolean r0 = true;
        L12:
            if (r0 == true) goto L14;
        L16:
            boolean r1 = false;
        L17:
            if (r1 == true) goto L19;
        L21:
            boolean r2 = false;
        L22:
            if (r2 == true) goto L24;
        L26:
            boolean r3 = false;
        L27:
            if (r3 == true) goto L29;
        L31:
            boolean r4 = false;
        L32:
            if (r4 == false) goto L37;
            if (this.previous.index != r9.previous.index) goto L37;
            return true;
        L29:
            if (this.next.index != r9.next.index) goto L31;
            r4 = true;
            goto L32
        L24:
            if (Double.compare(this.desiredMarkerIncrement, r9.desiredMarkerIncrement) != 0) goto L26;
            r3 = true;
            goto L27
        L19:
            if (Double.compare(this.desiredMarkerPosition, r9.desiredMarkerPosition) != 0) goto L21;
            r2 = true;
            goto L22
        L14:
            if (Double.compare(this.intMarkerPosition, r9.intMarkerPosition) != 0) goto L16;
            r1 = true;
            goto L17
        L11:
            r0 = false;
        L37:
            return false;
        L38:
            return true;
        }

        public int hashCode() {
            return Arrays.hashCode(new double[]{this.markerHeight, this.intMarkerPosition, this.desiredMarkerIncrement, this.desiredMarkerPosition, this.previous.index, this.next.index});
        }

        public String toString() {
            return String.format("index=%.0f,n=%.0f,np=%.2f,q=%.2f,dn=%.2f,prev=%d,next=%d", new Object[]{Double.valueOf(this.index), Double.valueOf(Precision.round(this.intMarkerPosition, 0)), Double.valueOf(Precision.round(this.desiredMarkerPosition, 2)), Double.valueOf(Precision.round(this.markerHeight, 2)), Double.valueOf(Precision.round(this.desiredMarkerIncrement, 2)), Integer.valueOf(this.previous.index), Integer.valueOf(this.next.index)});
        }
    }

    private static class Markers implements Serializable, PSquareMarkers {
        private static final int HIGH = 4;
        private static final int LOW = 2;
        private static final long serialVersionUID = 1;
        private transient int k;
        private final Marker[] markerArray;

        private Markers(List<Double> r3, double r4) {
            this(createMarkerArray((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4));
        }

        /* synthetic */ Markers(List r2, double r3, AnonymousClass1 r5) {
            this((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin"), r3);
        }

        private Markers(Marker[] r5) {
            this.k = -1;
            MathUtils.checkNotNull(r5);
            this.markerArray = r5;
            int r0 = 1;
        L4:
            if (r0 >= 5) goto L6;
            Marker[] r1 = this.markerArray;
            int r3 = r0 + 1;
            Marker.access$200(Marker.access$100(Marker.access$000(r1[r0], r1[r0 - 1]), this.markerArray[r3]), r0);
            r0 = r3;
            goto L4
        L6:
            Marker[] r2 = this.markerArray;
            Marker.access$200(Marker.access$100(Marker.access$000(r2[0], r2[0]), this.markerArray[1]), 0);
            Marker[] r6 = this.markerArray;
            Marker.access$200(Marker.access$100(Marker.access$000(r6[5], r6[4]), this.markerArray[5]), 5);
        }

        private void adjustHeightsOfMarkers() {
            int r0 = 2;
        L4:
            if (r0 > 4) goto L6;
            estimate(r0);
            r0 = r0 + 1;
            goto L4
        }

        private static Marker[] createMarkerArray(List<Double> r34, double r35) {
            List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r34, List.class, "com.obric.memorydata.plugin");
            if (r11 != null) goto L5;
            int r0 = -1;
        L7:
            if (r0 < 5) goto L11;
            Collections.sort(r11);
            double r16 = r35 * 2.0d;
            return new Marker[]{new Marker(null), new Marker(((Double) ZeusTransformUtils.preCheckCast(r11.get(0), Double.class, "com.obric.memorydata.plugin")).doubleValue(), 1.0d, 0.0d, 1.0d, null), new Marker(((Double) ZeusTransformUtils.preCheckCast(r11.get(1), Double.class, "com.obric.memorydata.plugin")).doubleValue(), r16 + 1.0d, r35 / 2.0d, 2.0d, null), new Marker(((Double) ZeusTransformUtils.preCheckCast(r11.get(2), Double.class, "com.obric.memorydata.plugin")).doubleValue(), (4.0d * r35) + 1.0d, r35, 3.0d, null), new Marker(((Double) ZeusTransformUtils.preCheckCast(r11.get(3), Double.class, "com.obric.memorydata.plugin")).doubleValue(), r16 + 3.0d, (r35 + 1.0d) / 2.0d, 4.0d, null), new Marker(((Double) ZeusTransformUtils.preCheckCast(r11.get(4), Double.class, "com.obric.memorydata.plugin")).doubleValue(), 5.0d, 1.0d, 5.0d, null)};
        L11:
            throw new InsufficientDataException(LocalizedFormats.INSUFFICIENT_OBSERVED_POINTS_IN_SAMPLE, new Object[]{Integer.valueOf(r0), 5});
        L5:
            r0 = r11.size();
            goto L7
        }

        private int findCellAndUpdateMinMax(double r5) {
            this.k = -1;
            int r0 = 1;
            if (r5 >= height(1)) goto L6;
            Marker.access$502(this.markerArray[1], r5);
        L5:
            this.k = r0;
        L20:
            return this.k;
        L6:
            int r1 = 2;
            if (r5 < height(2)) goto L5;
            r0 = 3;
            if (r5 >= height(3)) goto L12;
        L11:
            this.k = r1;
            goto L20
        L12:
            r1 = 4;
            if (r5 < height(4)) goto L5;
            if (r5 <= height(5)) goto L11;
            Marker.access$502(this.markerArray[5], r5);
            goto L11
        }

        private void incrementPositions(int r2, int r3, int r4) {
        L2:
            if (r3 > r4) goto L4;
            Marker.access$700(this.markerArray[r3], r2);
            r3 = r3 + 1;
            goto L2
        }

        private void readObject(ObjectInputStream r5) {
            r5.defaultReadObject();
            int r0 = 1;
        L4:
            if (r0 >= 5) goto L6;
            Marker[] r1 = this.markerArray;
            int r3 = r0 + 1;
            Marker.access$200(Marker.access$100(Marker.access$000(r1[r0], r1[r0 - 1]), this.markerArray[r3]), r0);
            r0 = r3;
            goto L4
        L6:
            Marker[] r2 = this.markerArray;
            Marker.access$200(Marker.access$100(Marker.access$000(r2[0], r2[0]), this.markerArray[1]), 0);
            Marker[] r6 = this.markerArray;
            Marker.access$200(Marker.access$100(Marker.access$000(r6[5], r6[4]), this.markerArray[5]), 5);
        }

        private void updateDesiredPositions() {
            int r0 = 1;
        L3:
            Marker[] r1 = this.markerArray;
            if (r0 >= r1.length) goto L6;
            Marker.access$800(r1[r0]);
            r0 = r0 + 1;
            goto L3
        }

        @Override // org.apache.commons.math3.stat.descriptive.rank.PSquarePercentile.PSquareMarkers
        public Object clone() {
            return new Markers(new Marker[]{new Marker(null), (Marker) ZeusTransformUtils.preCheckCast(this.markerArray[1].clone(), Marker.class, "com.obric.memorydata.plugin"), (Marker) ZeusTransformUtils.preCheckCast(this.markerArray[2].clone(), Marker.class, "com.obric.memorydata.plugin"), (Marker) ZeusTransformUtils.preCheckCast(this.markerArray[3].clone(), Marker.class, "com.obric.memorydata.plugin"), (Marker) ZeusTransformUtils.preCheckCast(this.markerArray[4].clone(), Marker.class, "com.obric.memorydata.plugin"), (Marker) ZeusTransformUtils.preCheckCast(this.markerArray[5].clone(), Marker.class, "com.obric.memorydata.plugin")});
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L5;
            return true;
        L5:
            if (r3 != null) goto L7;
        L9:
            return false;
        L7:
            if (ZeusTransformUtils.instanceOf(r3, Markers.class) == false) goto L9;
            Markers r4 = (Markers) ZeusTransformUtils.preCheckCast(r3, Markers.class, "com.obric.memorydata.plugin");
            return Arrays.deepEquals(this.markerArray, r4.markerArray);
        }

        public double estimate(int r3) {
            if (r3 < 2) goto L8;
            if (r3 > 4) goto L8;
            return Marker.access$600(this.markerArray[r3]);
        L8:
            throw new OutOfRangeException(Integer.valueOf(r3), 2, 4);
        }

        public double getPercentileValue() {
            return height(3);
        }

        public int hashCode() {
            return Arrays.deepHashCode(this.markerArray);
        }

        @Override // org.apache.commons.math3.stat.descriptive.rank.PSquarePercentile.PSquareMarkers
        public double height(int r3) {
            Marker[] r0 = this.markerArray;
            if (r3 >= r0.length) goto L8;
            if (r3 <= 0) goto L8;
            return Marker.access$500(r0[r3]);
        L8:
            throw new OutOfRangeException(Integer.valueOf(r3), 1, Integer.valueOf(this.markerArray.length));
        }

        @Override // org.apache.commons.math3.stat.descriptive.rank.PSquarePercentile.PSquareMarkers
        public double processDataPoint(double r2) {
            incrementPositions(1, findCellAndUpdateMinMax(r2) + 1, 5);
            updateDesiredPositions();
            adjustHeightsOfMarkers();
            return getPercentileValue();
        }

        public String toString() {
            return String.format("m1=[%s],m2=[%s],m3=[%s],m4=[%s],m5=[%s]", new Object[]{this.markerArray[1].toString(), this.markerArray[2].toString(), this.markerArray[3].toString(), this.markerArray[4].toString(), this.markerArray[5].toString()});
        }
    }

    protected interface PSquareMarkers extends Cloneable {
        Object clone();

        double height(int r1);

        double processDataPoint(double r1);
    }

    static {
        DECIMAL_FORMAT = new DecimalFormat("00.00");
    }

    PSquarePercentile() {
        this(DEFAULT_QUANTILE_DESIRED);
    }

    public PSquarePercentile(double r5) {
        this.initialFive = new FixedCapacityList(5);
        this.markers = null;
        this.pValue = Double.NaN;
        if (r5 > 100.0d) goto L9;
        if (r5 < 0.0d) goto L9;
        this.quantile = r5 / 100.0d;
        return;
    L9:
        throw new OutOfRangeException(LocalizedFormats.OUT_OF_RANGE, Double.valueOf(r5), 0, 100);
    }

    private double maximum() {
        PSquareMarkers r0 = this.markers;
        if (r0 == null) goto L6;
        return r0.height(5);
    L6:
        if (this.initialFive.isEmpty() == true) goto L8;
        List<Double> r2 = this.initialFive;
        return ((Double) ZeusTransformUtils.preCheckCast(r2.get(r2.size() - 1), Double.class, "com.obric.memorydata.plugin")).doubleValue();
    L8:
        return Double.NaN;
    }

    private double minimum() {
        PSquareMarkers r0 = this.markers;
        if (r0 == null) goto L6;
        return r0.height(1);
    L6:
        if (this.initialFive.isEmpty() == false) goto L11;
        return Double.NaN;
    L11:
        return ((Double) ZeusTransformUtils.preCheckCast(this.initialFive.get(0), Double.class, "com.obric.memorydata.plugin")).doubleValue();
    }

    public static PSquareMarkers newMarkers(List<Double> r2, double r3) {
        return new Markers((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin"), r3, null);
    }

    @Override // org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic, org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public void clear() {
        this.markers = null;
        this.initialFive.clear();
        this.countOfObservations = 0;
        this.pValue = Double.NaN;
    }

    @Override // org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic, org.apache.commons.math3.stat.descriptive.AbstractUnivariateStatistic, org.apache.commons.math3.stat.descriptive.UnivariateStatistic, org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public StorelessUnivariateStatistic copy() {
        PSquarePercentile r0 = new PSquarePercentile(this.quantile * 100.0d);
        PSquareMarkers r1 = this.markers;
        if (r1 == null) goto L5;
        r0.markers = (PSquareMarkers) ZeusTransformUtils.preCheckCast(r1.clone(), PSquareMarkers.class, "com.obric.memorydata.plugin");
    L5:
        r0.countOfObservations = this.countOfObservations;
        r0.pValue = this.pValue;
        r0.initialFive.clear();
        r0.initialFive.addAll(this.initialFive);
        return r0;
    }

    @Override // org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic, org.apache.commons.math3.stat.descriptive.AbstractUnivariateStatistic, org.apache.commons.math3.stat.descriptive.UnivariateStatistic, org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public /* bridge */ /* synthetic */ UnivariateStatistic copy() {
        return copy();
    }

    @Override // org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic
    public boolean equals(Object r6) {
        if (this == r6) goto L27;
        if (r6 == null) goto L26;
        if (ZeusTransformUtils.instanceOf(r6, PSquarePercentile.class) == false) goto L26;
        PSquarePercentile r7 = (PSquarePercentile) ZeusTransformUtils.preCheckCast(r6, PSquarePercentile.class, "com.obric.memorydata.plugin");
        PSquareMarkers r0 = this.markers;
        if (r0 != null) goto L11;
    L13:
        boolean r3 = false;
    L14:
        if (r0 == null) goto L16;
    L18:
        boolean r4 = false;
    L19:
        if (r3 == false) goto L21;
        r4 = r0.equals(r7.markers);
    L21:
        if (r4 == false) goto L26;
        if (getN() != r7.getN()) goto L26;
        return true;
    L16:
        if (r7.markers != null) goto L18;
        r4 = true;
        goto L19
    L11:
        if (r7.markers == null) goto L13;
        r3 = true;
    L26:
        return false;
    L27:
        return true;
    }

    @Override // org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public long getN() {
        return this.countOfObservations;
    }

    @Override // org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic, org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public double getResult() {
        if (Double.compare(this.quantile, 1.0d) != 0) goto L7;
        double r0 = maximum();
    L5:
        this.pValue = r0;
    L10:
        return this.pValue;
    L7:
        if (Double.compare(this.quantile, 0.0d) != 0) goto L10;
        r0 = minimum();
        goto L5
    }

    @Override // org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic
    public int hashCode() {
        double r0 = getResult();
        if (Double.isNaN(r0) == false) goto L5;
        r0 = 37.0d;
    L5:
        PSquareMarkers r2 = this.markers;
        if (r2 != null) goto L8;
        double r3 = 0.0d;
    L10:
        return Arrays.hashCode(new double[]{r0, this.quantile, r3, this.countOfObservations});
    L8:
        r3 = r2.hashCode();
        goto L10
    }

    @Override // org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic, org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public void increment(double r5) {
        this.countOfObservations++;
        this.lastObservation = r5;
        if (this.markers == null) goto L5;
    L10:
        double r6 = this.markers.processDataPoint(r5);
    L7:
        this.pValue = r6;
        return;
    L5:
        if (this.initialFive.add(Double.valueOf(r5)) == false) goto L9;
        Collections.sort(this.initialFive);
        List<Double> r7 = this.initialFive;
        r6 = ((Double) ZeusTransformUtils.preCheckCast(r7.get((int) (this.quantile * ((double) (r7.size() - 1)))), Double.class, "com.obric.memorydata.plugin")).doubleValue();
        goto L7
    L9:
        this.markers = newMarkers(this.initialFive, this.quantile);
        goto L10
    }

    public double quantile() {
        return this.quantile;
    }

    public String toString() {
        if (this.markers != null) goto L7;
        DecimalFormat r3 = DECIMAL_FORMAT;
        return String.format("obs=%s pValue=%s", new Object[]{r3.format(this.lastObservation), r3.format(this.pValue)});
    L7:
        return String.format("obs=%s markers=%s", new Object[]{DECIMAL_FORMAT.format(this.lastObservation), this.markers.toString()});
    }
}
