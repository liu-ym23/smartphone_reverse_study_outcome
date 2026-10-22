package com.ss.android.lark.location.dto;

import android.location.Location;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class LarkLocation extends Location {
    public static final /* synthetic */ int k = 0;
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public int g;
    public int h;
    public String i;
    public CoordinateSystem j;

    public static final enum CoordinateSystem extends Enum<CoordinateSystem> {
        public static final CoordinateSystem DEFAULT = null;
        public static final CoordinateSystem GCJ = null;
        public static final CoordinateSystem WGS = null;
        public static final /* synthetic */ CoordinateSystem[] a = null;
        private final int value;

        static {
            CoordinateSystem r0 = new CoordinateSystem("DEFAULT", 0, 0);
            DEFAULT = r0;
            CoordinateSystem r1 = new CoordinateSystem("WGS", 1, 1);
            WGS = r1;
            CoordinateSystem r3 = new CoordinateSystem("GCJ", 2, 2);
            GCJ = r3;
            a = new CoordinateSystem[]{r0, r1, r3};
        }

        public static CoordinateSystem[] values() {
            return (CoordinateSystem[]) a.clone();
        }

        public final int getNumber() {
            return this.value;
        }

        public static CoordinateSystem forNumber(int r1) {
            if (r1 == 0) goto L14;
            if (r1 == 1) goto L12;
            if (r1 == 2) goto L10;
            return DEFAULT;
        L10:
            return GCJ;
        L12:
            return WGS;
        L14:
            return DEFAULT;
        }

        public static CoordinateSystem valueOf(String r1) {
            return (CoordinateSystem) a.a(CoordinateSystem.class, r1);
        }

        public CoordinateSystem(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Override // android.location.Location
    public final String toString() {
        return "LarkLocation{errorCode=" + this.g + ", errorMsg='" + this.i + "', coordinateSystem=" + this.j + '}';
    }

    public LarkLocation(Location r1) {
        super(r1);
        this.h = -1;
        this.j = CoordinateSystem.WGS;
    }
}
