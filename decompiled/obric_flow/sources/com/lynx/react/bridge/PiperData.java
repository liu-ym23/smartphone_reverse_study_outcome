package com.lynx.react.bridge;

import com.lynx.tasm.base.CalledByNative;
import java.nio.ByteBuffer;
import kn.b;

/* JADX INFO: loaded from: classes2.dex */
public final class PiperData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ByteBuffer f9942a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public DataType f9943b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f9944c;
    public final Object d;

    public static final enum DataType extends Enum<DataType> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final DataType f9945a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final DataType f9946b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ DataType[] f9947c = null;

        static {
            DataType r5 = new DataType("Empty", 0);
            f9945a = r5;
            DataType r10 = new DataType("String", 1);
            DataType r11 = new DataType("Map", 2);
            f9946b = r11;
            f9947c = new DataType[]{r5, r10, r11};
        }

        public DataType(String r5, int r10) {
            super(r5, r10);
        }

        public static DataType valueOf(String r5) {
            return (DataType) Enum.valueOf(DataType.class, r5);
        }

        public static DataType[] values() {
            return (DataType[]) f9947c.clone();
        }
    }

    public PiperData(Object r5) {
        this.f9942a = null;
        this.f9944c = false;
        this.f9943b = DataType.f9946b;
        this.f9942a = b.b(r5);
        this.f9944c = true;
        this.d = r5;
    }

    private static native long nativeParseStringData(String r5);

    private static native void nativeReleaseData(long r5);

    @CalledByNative
    private boolean recycleIfIsDisposable() {
        boolean r5 = this.f9944c;
        if (r5 == false) goto L7;
        DataType r10 = this.f9943b;
        DataType r11 = DataType.f9945a;
        if (r10 == r11) goto L7;
        this.f9943b = r11;
        this.f9942a = null;
    L7:
        return r5;
    }

    public final void finalize() {
        super.finalize();
        DataType r5 = this.f9943b;
        DataType r10 = DataType.f9945a;
        if (r5 == r10) goto L6;
        this.f9943b = r10;
        this.f9942a = null;
        return;
    }

    @CalledByNative
    public ByteBuffer getBuffer() {
        return this.f9942a;
    }

    @CalledByNative
    public int getBufferPosition() {
        ByteBuffer r5 = this.f9942a;
        if (r5 != null) goto L7;
        return 0;
    L7:
        return r5.position();
    }

    @CalledByNative
    public int getDataType() {
        return this.f9943b.ordinal();
    }

    @CalledByNative
    public long getNativePtr() {
        return 0;
    }
}
