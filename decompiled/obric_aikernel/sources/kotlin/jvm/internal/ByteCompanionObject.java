package kotlin.jvm.internal;

import kotlin.SinceKotlin;

/* JADX INFO: loaded from: classes2.dex */
public final class ByteCompanionObject {
    public static final ByteCompanionObject INSTANCE = null;
    public static final byte MAX_VALUE = 127;
    public static final byte MIN_VALUE = -128;
    public static final int SIZE_BITS = 8;
    public static final int SIZE_BYTES = 1;

    static {
        INSTANCE = new ByteCompanionObject();
    }

    private ByteCompanionObject() {
    }

    @SinceKotlin(version = "1.3")
    public static /* synthetic */ void getSIZE_BITS$annotations() {
    }

    @SinceKotlin(version = "1.3")
    public static /* synthetic */ void getSIZE_BYTES$annotations() {
    }
}
