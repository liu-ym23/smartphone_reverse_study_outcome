package fv0;

import com.bytedance.android.live.profit.taskcenter.panel.model.PanelInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final /* synthetic */ class b {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[PanelInfo.State.values().length];
        a = r0;
        r0[PanelInfo.State.WAITING.ordinal()] = 1;
        r0[PanelInfo.State.READY.ordinal()] = 2;
        r0[PanelInfo.State.SHOWING.ordinal()] = 3;
        r0[PanelInfo.State.DISMISSED.ordinal()] = 4;
    }
}
