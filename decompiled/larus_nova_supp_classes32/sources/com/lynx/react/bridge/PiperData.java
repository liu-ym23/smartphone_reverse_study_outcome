package com.lynx.react.bridge;

import java.nio.ByteBuffer;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class PiperData {
    public ByteBuffer a;
    public DataType b;
    public final boolean c;
    public final Object d;

    public static final enum DataType extends Enum<DataType> {
        public static final DataType Empty = null;
        public static final DataType Map = null;
        public static final DataType String = null;
        public static final /* synthetic */ DataType[] a = null;

        static {
            DataType r0 = new DataType("Empty", 0);
            Empty = r0;
            DataType r1 = new DataType("String", 1);
            String = r1;
            DataType r3 = new DataType("Map", 2);
            Map = r3;
            a = new DataType[]{r0, r1, r3};
        }

        public static DataType[] values() {
            return (DataType[]) a.clone();
        }

        public static DataType valueOf(String r1) {
            return (DataType) a.a(DataType.class, r1);
        }

        public DataType(String r1, int r2) {
            super(r1, r2);
        }
    }

    private static native long nativeParseStringData(String r0);

    private static native void nativeReleaseData(long r0);

    public long getNativePtr() {
        return 0;
    }

    private boolean recycleIfIsDisposable() {
        if (this.c == false) goto L8;
        if (this.b == DataType.Empty) goto L8;
        a();
    L8:
        return this.c;
    }

    public final void a() {
        this.b = DataType.Empty;
        this.a = null;
    }

    public int getBufferPosition() {
        ByteBuffer r0 = this.a;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.position();
    }

    public int getDataType() {
        return this.b.ordinal();
    }

    public PiperData() {
        this.a = null;
        this.b = DataType.Empty;
        this.c = false;
    }

    public final void finalize() throws Throwable {
        super.finalize();
        if (this.b == DataType.Empty) goto L6;
        a();
        return;
    }

    public ByteBuffer getBuffer() {
        return this.a;
    }

    public PiperData(Object r2, boolean r3) {
        this.a = null;
        this.b = DataType.Empty;
        this.c = false;
        this.b = DataType.Map;
        j7a.a.a.getClass();
        this.a = j7a.a.b(r2);
        this.c = r3;
        this.d = r2;
    }
}
