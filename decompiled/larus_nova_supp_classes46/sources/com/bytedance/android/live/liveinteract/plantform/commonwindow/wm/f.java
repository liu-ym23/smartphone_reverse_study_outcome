package com.bytedance.android.live.liveinteract.plantform.commonwindow.wm;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.LinkMicRecyclerView;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.layoutmanager.PCLandscapeLinkSeatRecyclerLayoutManager;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ BaseMultiLinkWindowManager a;

    public f(BaseMultiLinkWindowManager r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        m81.a r4 = (m81.a) r3;
        if (((IInteractService) jc1.k.n(IInteractService.class)).isPCLandscape(this.a.z.m(), this.a.z.getUiLayout()) == false) goto L19;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r5 = this.a.d;
        RecyclerView.LayoutManager r0 = null;
        if (r5 == null) goto L9;
        LinkMicRecyclerView r6 = r5.getRecyclerView();
        if (r6 == null) goto L9;
        RecyclerView.LayoutManager r7 = r6.getLayoutManager();
    L11:
        if ((r7 instanceof PCLandscapeLinkSeatRecyclerLayoutManager) == false) goto L14;
        r0 = r7;
    L14:
        PCLandscapeLinkSeatRecyclerLayoutManager r1 = (PCLandscapeLinkSeatRecyclerLayoutManager) r0;
        if (r1 == null) goto L17;
        r1.d = true;
    L17:
        this.a.y.post(new e(this));
        return;
    L9:
        r7 = null;
        goto L11
    }
}
