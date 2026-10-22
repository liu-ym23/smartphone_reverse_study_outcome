package com.bytedance.android.live.liveinteract.linkpanel.contract;

import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import java.util.List;
import kotlin.Metadata;
import yf0.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"com/bytedance/android/live/liveinteract/linkpanel/contract/BaseTalkApplyListWidgetContract$View", "Lcom/bytedance/android/live/liveinteract/linkpanel/contract/InteractDialogWidgetBaseContract$View;", "Lyf0/a;", "<init>", "()V", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public abstract class BaseTalkApplyListWidgetContract$View extends InteractDialogWidgetBaseContract$View<a> {
    public abstract void Aq(Throwable r1);

    public abstract void Bq(List<? extends ILinkPlayerInfoBridge> r1, long r2, boolean r4, String r5, String r6, boolean r7, int r8, boolean r9, boolean r10);

    public abstract void Cq(com.bytedance.android.live.liveinteract.linkpanel.model.a r1);

    public abstract void wq(boolean r1);

    public abstract void xq(boolean r1);

    public abstract void yq(List<? extends ILinkPlayerInfoBridge> r1);

    public abstract void zq(List<? extends ILinkPlayerInfoBridge> r1);

    public BaseTalkApplyListWidgetContract$View() {
    }
}
