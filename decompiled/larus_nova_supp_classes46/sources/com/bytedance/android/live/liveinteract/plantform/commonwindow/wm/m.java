package com.bytedance.android.live.liveinteract.plantform.commonwindow.wm;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.lynx.tasm.LynxView;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class m<T> implements Consumer {
    public final /* synthetic */ CommonMultiLinkWindowManager a;

    public m(CommonMultiLinkWindowManager r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        com.bytedance.android.livesdk.event.d r5 = (com.bytedance.android.livesdk.event.d) r4;
        ALogger.i("BaseMultiLinkWindowManager", "received BarrageCleanScreenEvent， isClear： " + r5.a);
        if (this.a.z.getUiLayout() != 7) goto L5;
    L7:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r0 = this.a.d;
        if (r0 == null) goto L12;
        ViewGroup r1 = r0.td();
        if (r1 == null) goto L12;
        r1.post(new l(this));
    L12:
        View r2 = null;
        int r3 = 0;
        if (com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.j(null, 0, 7) == false) goto L46;
        IInteractService r6 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r6 == null) goto L19;
        ih0.b r7 = r6.dynamicService(this.a.C);
        if (r7 == null) goto L19;
        ih0.c r8 = r7.Z9();
    L21:
        if (r5.a == false) goto L34;
        if (r8 == null) goto L24;
        View r9 = r8.getHybridView();
    L26:
        if ((r9 instanceof LynxView) == false) goto L29;
        r2 = r9;
    L29:
        LynxView r10 = (LynxView) r2;
        if (r10 == null) goto L55;
        View r11 = r10.findViewByName("seat_list_container");
        if (r11 == null) goto L56;
        UtilityKotlinExtentionsKt.u(r11);
        return;
    L56:
        return;
    L55:
        return;
    L24:
        r9 = null;
        goto L26
    L34:
        if (r8 == null) goto L36;
        View r12 = r8.getHybridView();
    L38:
        if ((r12 instanceof LynxView) == false) goto L41;
        r2 = r12;
    L41:
        LynxView r13 = (LynxView) r2;
        if (r13 == null) goto L58;
        View r14 = r13.findViewByName("seat_list_container");
        if (r14 == null) goto L59;
        UtilityKotlinExtentionsKt.w(r14);
        return;
    L59:
        return;
    L58:
        return;
    L36:
        r12 = null;
    L19:
        r8 = null;
        goto L21
    L46:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r15 = this.a.d;
        if (r15 == null) goto L61;
        ug0.a r16 = r15.getRvLayoutManager();
        if (r16 != null) goto L51;
        return;
    L51:
        if (r5.a == false) goto L53;
        r3 = 4;
    L53:
        r16.e(r3);
        return;
    L61:
        return;
    L5:
        if (this.a.z.getUiLayout() == 15) goto L7;
    }
}
