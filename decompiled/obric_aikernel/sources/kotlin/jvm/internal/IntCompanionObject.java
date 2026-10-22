package kotlin.jvm.internal;

import kotlin.SinceKotlin;

/* JADX INFO: loaded from: classes2.dex */
public final class IntCompanionObject {
    public static final IntCompanionObject INSTANCE = null;
    public static final int MAX_VALUE = Integer.MAX_VALUE;
    public static final int MIN_VALUE = Integer.MIN_VALUE;
    public static final int SIZE_BITS = 32;
    public static final int SIZE_BYTES = 4;

    static {
        INSTANCE = new IntCompanionObject();
    }

    private IntCompanionObject() {
    }

    @SinceKotlin(version = "1.3")
    public static /* synthetic */ void getSIZE_BITS$annotations() {
    }

    @SinceKotlin(version = "1.3")
    public static /* synthetic */ void getSIZE_BYTES$annotations() {
    }
}
