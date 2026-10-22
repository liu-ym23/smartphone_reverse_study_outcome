package com.bytedance.android.live.livepkaudience.dialog;

import com.bytedance.android.live.liveinteract.plantform.model.LinkPlayerInfo;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"com/bytedance/android/live/livepkaudience/dialog/BasePkAudienceApplyListContract$View", "Lcom/bytedance/android/live/livepkaudience/dialog/RevInteractDialogFragmentBaseContract$View;", "Lcom/bytedance/android/live/livepkaudience/dialog/a;", "<init>", "()V", "livepkaudience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class BasePkAudienceApplyListContract$View extends RevInteractDialogFragmentBaseContract$View<a> {
    public abstract void V90(boolean r1);

    public abstract void W90(boolean r1);

    public abstract void X90(List<? extends LinkPlayerInfo> r1);

    public abstract void Y90(List<? extends LinkPlayerInfo> r1);

    public abstract void Z90(Throwable r1);

    public abstract void aa0(List<? extends LinkPlayerInfo> r1, int r2, boolean r3, String r4, String r5, int r6);

    public abstract void ba0(bl0.b r1);

    public BasePkAudienceApplyListContract$View() {
    }
}
