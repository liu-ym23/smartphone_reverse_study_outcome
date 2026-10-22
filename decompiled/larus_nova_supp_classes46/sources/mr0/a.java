package mr0;

import com.bytedance.android.live.openplatform.api.constant.MountedMiniGameSource;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final /* synthetic */ class a {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;

    static {
        int[] r0 = new int[MountedMiniGameSource.values().length];
        a = r0;
        MountedMiniGameSource r1 = MountedMiniGameSource.Toolbar;
        r0[r1.ordinal()] = 1;
        MountedMiniGameSource r2 = MountedMiniGameSource.ExplainCard;
        r0[r2.ordinal()] = 2;
        MountedMiniGameSource r4 = MountedMiniGameSource.GameLiveBtn;
        r0[r4.ordinal()] = 3;
        MountedMiniGameSource r6 = MountedMiniGameSource.InteractPanel;
        r0[r6.ordinal()] = 4;
        int[] r3 = new int[MountedMiniGameSource.values().length];
        b = r3;
        r3[r1.ordinal()] = 1;
        r3[r2.ordinal()] = 2;
        r3[r4.ordinal()] = 3;
        r3[r6.ordinal()] = 4;
        r3[MountedMiniGameSource.Lottery.ordinal()] = 5;
    }
}
