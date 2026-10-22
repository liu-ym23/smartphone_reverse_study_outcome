package kotlin.math;

import kotlin.Metadata;
import kotlin.jvm.JvmField;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0006\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0000X\u0081\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0000X\u0081\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00048\u0000X\u0081\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00048\u0000X\u0081\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\u00048\u0000X\u0081\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\u00048\u0000X\u0081\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lkotlin/math/Constants;", "", "()V", "LN2", "", "epsilon", "taylor_2_bound", "taylor_n_bound", "upper_taylor_2_bound", "upper_taylor_n_bound", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
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
        double r5 = Math.ulp(1.0d);
        epsilon = r5;
        double r10 = Math.sqrt(r5);
        taylor_2_bound = r10;
        double r11 = Math.sqrt(r10);
        taylor_n_bound = r11;
        double r12 = 1;
        upper_taylor_2_bound = r12 / r10;
        upper_taylor_n_bound = r12 / r11;
    }

    private Constants() {
    }
}
