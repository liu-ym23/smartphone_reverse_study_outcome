package com.bytedance.android.live.liveinteract.linkpanel.widget;

import com.bytedance.android.live.liveinteract.linkpanel.vm.GuestApplyViewModel;
import com.bytedance.android.live.liveinteract.plantform.model.WaitingListType;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class j<T> implements Consumer {
    public final /* synthetic */ GuestApplyContentWidget a;

    public j(GuestApplyContentWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r10) {
        Boolean r11 = (Boolean) r10;
        GuestApplyContentWidget r12 = this.a;
        GuestApplyViewModel r0 = r12.q;
        if (r0 == null) goto L6;
        GuestApplyViewModel.fetchList$default(r0, true, r12.r, null, WaitingListType.UNKNOWN.ordinal(), 0, false, 52, null);
        return;
    }
}
