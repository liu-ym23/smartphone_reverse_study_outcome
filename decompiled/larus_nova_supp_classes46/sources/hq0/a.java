package hq0;

import com.bytedance.android.live.openplatform.api.constant.MountedMiniAppSource;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final /* synthetic */ class a {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;
    public static final /* synthetic */ int[] c = null;

    static {
        int[] r0 = new int[MountedMiniAppSource.values().length];
        a = r0;
        MountedMiniAppSource r1 = MountedMiniAppSource.ConnectionPanel;
        r0[r1.ordinal()] = 1;
        MountedMiniAppSource r2 = MountedMiniAppSource.ExplainCard;
        r0[r2.ordinal()] = 2;
        MountedMiniAppSource r4 = MountedMiniAppSource.ExplainCardButton;
        r0[r4.ordinal()] = 3;
        MountedMiniAppSource r6 = MountedMiniAppSource.ToolbarDirectMicroApp;
        r0[r6.ordinal()] = 4;
        int[] r3 = new int[MountedMiniAppSource.values().length];
        b = r3;
        r3[r1.ordinal()] = 1;
        r3[r2.ordinal()] = 2;
        r3[r4.ordinal()] = 3;
        r3[r6.ordinal()] = 4;
        int[] r5 = new int[MountedMiniAppSource.values().length];
        c = r5;
        r5[r2.ordinal()] = 1;
        r5[r4.ordinal()] = 2;
    }
}
