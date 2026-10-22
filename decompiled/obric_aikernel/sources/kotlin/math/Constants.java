package kotlin.math;

import kotlin.jvm.JvmField;

/* JADX INFO: loaded from: classes2.dex */
final class Constants {
    public static final Constants INSTANCE = null;

    @JvmField
    public static final double LN2 = 0.0d;

    @JvmField
    public static final double epsilon = 0.0d;

    @JvmField
    public static final double taylor_2_bound = 0.0d;

    @JvmField
    public static final double taylor_n_bound = 0.0d;

    @JvmField
    public static final double upper_taylor_2_bound = 0.0d;

    @JvmField
    public static final double upper_taylor_n_bound = 0.0d;

    static {
        INSTANCE = new Constants();
        LN2 = Math.log(2.0d);
        double r10 = Math.ulp(1.0d);
        epsilon = r10;
        double r11 = Math.sqrt(r10);
        taylor_2_bound = r11;
        double r12 = Math.sqrt(r11);
        taylor_n_bound = r12;
        double r13 = 1;
        upper_taylor_2_bound = r13 / r11;
        upper_taylor_n_bound = r13 / r12;
    }

    private Constants() {
    }
}
