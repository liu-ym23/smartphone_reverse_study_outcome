package com.bytedance.ies.bullet.service.popup.ui;

import com.bytedance.ai.bridge.method.router.OpenPageMethod;
import com.bytedance.ies.bullet.core.container.e;
import com.bytedance.ies.bullet.service.base.h;
import com.bytedance.ies.bullet.ui.common.BulletContainerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6094a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AbsPopupFragment f6095b;

    public /* synthetic */ a(AbsPopupFragment r5, int r10) {
        this.f6094a = r10;
        this.f6095b = r5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AbsPopupFragment r5 = this.f6095b;
        switch(this.f6094a) {
            case 0: goto L27;
            default: goto L4;
        };
    L4:
        BulletContainerView r10 = r5.f6066h;
        if (r10 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("popupContentView");
        r10 = null;
    L8:
        if (r10 != null) goto L11;
        r10 = null;
    L11:
        if (r10 == null) goto L24;
        ArrayList r11 = r10.f6171i;
        ArrayList r12 = new ArrayList();
        Iterator r13 = r11.iterator();
        if (r13.hasNext() == true) goto L23;
        Iterator r14 = r12.iterator();
        if (r14.hasNext() == true) goto L21;
        r11.clear();
        h r15 = r10.g;
        if (r15 == null) goto L19;
        r15.destroy();
    L19:
        r10.g = null;
        r10.f6187z.d = null;
        r10.release();
        goto L24
    L21:
        throw mn.h.c(r14);
    L23:
        throw mn.h.c(r13);
    L24:
        ArrayList r16 = md.b.f;
        Intrinsics.checkNotNullParameter(r5, OpenPageMethod.APP_POPUP);
        md.b.g.remove(r5);
        return;
    L27:
        if (r5.f6071m == false) goto L32;
        e r17 = r5.f6070l;
        if (r17 == null) goto L31;
        r17.d();
    L31:
        int r18 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        Map r19 = MapsKt.mapOf(TuplesKt.to("popup url", String.valueOf(r5.i().f20066c)));
        com.bytedance.ies.bullet.base.utils.logger.b r20 = r5.f;
        Intrinsics.checkNotNullParameter("XPopup", "moduleTag");
        Intrinsics.checkNotNullParameter("AbsPopupFragment.onFeJsRuntimeReady: call onEnterForeground", "msg");
        com.bytedance.ies.bullet.base.utils.logger.a.i(true, "XPopup", "AbsPopupFragment.onFeJsRuntimeReady: call onEnterForeground", r19, r20);
    L32:
        r5.f6072n = true;
    }
}
