package qe;

import com.bytedance.android.ec.model.hybrid.IECBridgeMethod;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final /* synthetic */ class c {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;

    static {
        int[] r0 = new int[IECBridgeMethod.Access.values().length];
        a = r0;
        IECBridgeMethod.Access r1 = IECBridgeMethod.Access.PUBLIC;
        r0[r1.ordinal()] = 1;
        IECBridgeMethod.Access r10 = IECBridgeMethod.Access.PROTECT;
        r0[r10.ordinal()] = 2;
        IECBridgeMethod.Access r11 = IECBridgeMethod.Access.PRIVATE;
        r0[r11.ordinal()] = 3;
        int[] r12 = new int[IECBridgeMethod.Access.values().length];
        b = r12;
        r12[r1.ordinal()] = 1;
        r12[r10.ordinal()] = 2;
        r12[r11.ordinal()] = 3;
    }
}
