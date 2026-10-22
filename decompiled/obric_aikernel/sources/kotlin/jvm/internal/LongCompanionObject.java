package kotlin.jvm.internal;

import kotlin.SinceKotlin;

/* JADX INFO: loaded from: classes2.dex */
public final class LongCompanionObject {
    public static final LongCompanionObject INSTANCE = null;
    public static final long MAX_VALUE = Long.MAX_VALUE;
    public static final long MIN_VALUE = Long.MIN_VALUE;
    public static final int SIZE_BITS = 64;
    public static final int SIZE_BYTES = 8;

    static {
        INSTANCE = new LongCompanionObject();
    }

    private LongCompanionObject() {
    }

    @SinceKotlin(version = "1.3")
    public static /* synthetic */ void getSIZE_BITS$annotations() {
    }

    @SinceKotlin(version = "1.3")
    public static /* synthetic */ void getSIZE_BYTES$annotations() {
    }
}
