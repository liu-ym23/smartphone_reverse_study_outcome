package i50;

import com.bytedance.android.live.core.gl.camera.BaseCamera;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final /* synthetic */ class a {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;

    static {
        int[] r0 = new int[BaseCamera.ClampType.values().length];
        a = r0;
        BaseCamera.ClampType r1 = BaseCamera.ClampType.HORIZONTAL;
        r0[r1.ordinal()] = 1;
        BaseCamera.ClampType r2 = BaseCamera.ClampType.VERTICAL;
        r0[r2.ordinal()] = 2;
        BaseCamera.ClampType r4 = BaseCamera.ClampType.INNER_BORDER;
        r0[r4.ordinal()] = 3;
        BaseCamera.ClampType r6 = BaseCamera.ClampType.OUTER_BORDER;
        r0[r6.ordinal()] = 4;
        int[] r3 = new int[BaseCamera.ClampType.values().length];
        b = r3;
        r3[r1.ordinal()] = 1;
        r3[r2.ordinal()] = 2;
        r3[r4.ordinal()] = 3;
        r3[r6.ordinal()] = 4;
    }
}
