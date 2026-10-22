package w60;

import com.bytedance.android.live.core.setting.v2.cache.ICacheManger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final /* synthetic */ class a {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;
    public static final /* synthetic */ int[] c = null;
    public static final /* synthetic */ int[] d = null;
    public static final /* synthetic */ int[] e = null;
    public static final /* synthetic */ int[] f = null;
    public static final /* synthetic */ int[] g = null;

    static {
        int[] r0 = new int[ICacheManger.CacheType.values().length];
        a = r0;
        ICacheManger.CacheType r1 = ICacheManger.CacheType.LOCAL_CACHE;
        r0[r1.ordinal()] = 1;
        ICacheManger.CacheType r2 = ICacheManger.CacheType.TRANSIENT;
        r0[r2.ordinal()] = 2;
        ICacheManger.CacheType r4 = ICacheManger.CacheType.STICKY;
        r0[r4.ordinal()] = 3;
        ICacheManger.CacheType r6 = ICacheManger.CacheType.OBJECT;
        r0[r6.ordinal()] = 4;
        ICacheManger.CacheType r8 = ICacheManger.CacheType.PRELOAD_CACHE;
        r0[r8.ordinal()] = 5;
        int[] r3 = new int[ICacheManger.CacheType.values().length];
        b = r3;
        r3[r1.ordinal()] = 1;
        r3[r2.ordinal()] = 2;
        r3[r4.ordinal()] = 3;
        r3[r6.ordinal()] = 4;
        r3[r8.ordinal()] = 5;
        int[] r5 = new int[ICacheManger.CacheType.values().length];
        c = r5;
        r5[r4.ordinal()] = 1;
        r5[r2.ordinal()] = 2;
        r5[r6.ordinal()] = 3;
        r5[r8.ordinal()] = 4;
        int[] r7 = new int[ICacheManger.Operation.values().length];
        d = r7;
        ICacheManger.Operation r9 = ICacheManger.Operation.MINUS;
        r7[r9.ordinal()] = 1;
        ICacheManger.Operation r11 = ICacheManger.Operation.PLUS;
        r7[r11.ordinal()] = 2;
        int[] r12 = new int[ICacheManger.Operation.values().length];
        e = r12;
        r12[r9.ordinal()] = 1;
        r12[r11.ordinal()] = 2;
        int[] r13 = new int[ICacheManger.Operation.values().length];
        f = r13;
        r13[r9.ordinal()] = 1;
        r13[r11.ordinal()] = 2;
        int[] r14 = new int[ICacheManger.Operation.values().length];
        g = r14;
        r14[r9.ordinal()] = 1;
        r14[r11.ordinal()] = 2;
    }
}
