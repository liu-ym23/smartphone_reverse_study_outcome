package y60;

import com.bytedance.android.live.core.setting.v2.cache.ICacheManger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final /* synthetic */ class c {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;

    static {
        int[] r0 = new int[ICacheManger.Operation.values().length];
        a = r0;
        ICacheManger.Operation r1 = ICacheManger.Operation.PLUS;
        r0[r1.ordinal()] = 1;
        ICacheManger.Operation r2 = ICacheManger.Operation.MINUS;
        r0[r2.ordinal()] = 2;
        int[] r3 = new int[ICacheManger.Operation.values().length];
        b = r3;
        r3[r1.ordinal()] = 1;
        r3[r2.ordinal()] = 2;
    }
}
