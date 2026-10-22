package kotlin;

import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes2.dex */
final class KotlinVersionCurrentValue {
    public static final KotlinVersionCurrentValue INSTANCE = null;

    static {
        INSTANCE = new KotlinVersionCurrentValue();
    }

    private KotlinVersionCurrentValue() {
    }

    @JvmStatic
    public static final KotlinVersion get() {
        return new KotlinVersion(1, 9, 10);
    }
}
