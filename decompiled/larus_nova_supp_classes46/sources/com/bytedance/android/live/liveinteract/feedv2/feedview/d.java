package com.bytedance.android.live.liveinteract.feedv2.feedview;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.BaseLinkSeatWindowView;
import com.bytedance.android.livesdkapi.feed.data.IPreviewMultiLinkOuterConfigProvider;
import com.bytedance.android.livesdkapi.multilink.CommonMultiLinkLayoutEvent;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d implements Runnable {
    public final /* synthetic */ MultiLinkCommonVideoFeedPreview a;

    public d(MultiLinkCommonVideoFeedPreview r1) {
        this.a = r1;
    }

    public final void a() {
        MultiLinkCommonVideoFeedPreview r0 = this.a;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r1 = r0.e;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.getUiLayout();
    L6:
        IInteractService r4 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r4 == null) goto L11;
        if (r4.isFixFloatWindowLayout(0, r3) != true) goto L11;
    L18:
        boolean r5 = true;
    L19:
        if (r5 == false) goto L37;
        BaseLinkSeatWindowView r6 = r0.g;
        if (r6 == null) goto L26;
        ug0.a r7 = r6.getRvLayoutManager();
        if (r7 == null) goto L26;
        Pair<Integer, Integer> r8 = r7.c(1);
        if (r8 == null) goto L26;
    L30:
        int[] r9 = new int[2];
        BaseLinkSeatWindowView r10 = r0.g;
        if (r10 == null) goto L35;
        RecyclerView r11 = r10.getRecyclerView();
        if (r11 == null) goto L35;
        r11.getLocationInWindow(r9);
    L35:
        if (r8 == null) goto L37;
        r2 = r9[0] + ((Number) r8.getFirst()).intValue();
    L26:
        BaseLinkSeatWindowView r12 = r0.g;
        if (r12 == null) goto L29;
        r8 = r12.vn(1, null);
        goto L30
    L29:
        r8 = null;
    L37:
        xs2.b r13 = xs2.b.a();
        IPreviewMultiLinkOuterConfigProvider r14 = r0.b;
        if (r14 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L40:
        r13.post(new CommonMultiLinkLayoutEvent(r14.getRoom().getIdStr(), r5, r2));
        IPreviewMultiLinkOuterConfigProvider r15 = r0.b;
        if (r15 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L43:
        IPreviewMultiLinkOuterConfigProvider.DefaultImpls.printALogger$default(r15, "CommonVideoFeedPreview", r0.hashCode(), "updateCommonMultiLinkLayoutEvent, isFloatWindow=" + r5 + ", xPosition=" + r2, false, 8, null);
        return;
    L11:
        if (r3 == 7) goto L18;
        IInteractService r16 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r16 != null) goto L15;
    L17:
        r5 = false;
        goto L19
    L15:
        if (r16.isVideoEqualCenterNewLayout(0, r3) != true) goto L17;
    L5:
        r3 = 0;
        goto L6
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
