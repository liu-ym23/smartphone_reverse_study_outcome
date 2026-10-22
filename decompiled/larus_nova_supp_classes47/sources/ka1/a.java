package ka1;

import com.bytedance.android.live.schema.convert.HybridType;
import com.bytedance.android.live.schema.convert.HybridUiType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final /* synthetic */ class a {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;
    public static final /* synthetic */ int[] c = null;
    public static final /* synthetic */ int[] d = null;

    static {
        int[] r0 = new int[HybridType.values().length];
        a = r0;
        r0[HybridType.H5.ordinal()] = 1;
        r0[HybridType.Lynx.ordinal()] = 2;
        r0[HybridType.COMMON.ordinal()] = 3;
        int[] r1 = new int[HybridUiType.values().length];
        b = r1;
        HybridUiType r2 = HybridUiType.FULLSCREEN;
        r1[r2.ordinal()] = 1;
        HybridUiType r4 = HybridUiType.POPUP;
        r1[r4.ordinal()] = 2;
        int[] r3 = new int[HybridUiType.values().length];
        c = r3;
        r3[r2.ordinal()] = 1;
        r3[r4.ordinal()] = 2;
        int[] r5 = new int[HybridUiType.values().length];
        d = r5;
        r5[r2.ordinal()] = 1;
        r5[r4.ordinal()] = 2;
    }
}
