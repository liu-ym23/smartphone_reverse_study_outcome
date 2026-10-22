package com.bytedance.ai.widget.contianer;

import android.animation.AnimatorSet;
import android.view.View;
import com.google.android.material.carousel.CarouselLayoutManager;
import com.obric.flow.cardlistpage.ui.component.feedlist.s;
import com.obric.flow.cardlistpage.ui.view.i;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.swipeaction.OSwipeLayout;
import com.obric.oui.swipeaction.l;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class c implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3042a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3043b;

    public /* synthetic */ c(Object r5, int r10) {
        this.f3042a = r10;
        this.f3043b = r5;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r14, int r15, int r16, int r17, int r18, int r19, int r20, int r21, int r22) {
        Object r5 = this.f3043b;
        switch(this.f3042a) {
            case 0: goto L37;
            case 1: goto L35;
            case 2: goto L33;
            case 3: goto L31;
            case 4: goto L27;
            default: goto L4;
        };
    L4:
        l r10 = (l) r5;
        Intrinsics.checkNotNullParameter(r10, "this$0");
        if (r14.getWidth() > 0) goto L7;
        return;
    L7:
        if (r10.f14628j != 0) goto L9;
        r10.e();
        return;
    L9:
        OSwipeLayout r11 = r10.f14623a;
        boolean r12 = false;
        if (r11.getIsBeingDragged() == false) goto L12;
    L16:
        boolean r13 = false;
    L17:
        AnimatorSet r23 = r10.f14636r;
        if (r23 != null) goto L21;
    L23:
        if (r13 == false) goto L55;
        if (r12 == true) goto L56;
        r10.e();
        return;
    L56:
        return;
    L55:
        return;
    L21:
        if (r23.isRunning() != true) goto L23;
        r12 = true;
        goto L23
    L12:
        if (r11.getOpenStatus() != OSwipeLayout.Status.Close) goto L14;
    L15:
        r13 = true;
        goto L17
    L14:
        if (r11.getOpenStatus() != OSwipeLayout.Status.Open) goto L16;
    L27:
        int r24 = OCardListItem.I;
        OCardListItem r25 = (OCardListItem) r5;
        Intrinsics.checkNotNullParameter(r25, "this$0");
        if (r25.f13556u.getVisibility() != 0) goto L57;
        r25.m();
        return;
    L57:
        return;
    L31:
        i r26 = (i) r5;
        Intrinsics.checkNotNullParameter(r26, "this$0");
        r26.post(new androidx.fragment.app.d(r26, 26));
        return;
    L33:
        s r27 = (s) r5;
        Intrinsics.checkNotNullParameter(r27, "this$0");
        r27.y();
        return;
    L35:
        CarouselLayoutManager.b((CarouselLayoutManager) r5, r14, r15, r16, r17, r18, r19, r20, r21, r22);
        return;
    L37:
        int r28 = r18 - r16;
        if (r28 <= 0) goto L58;
        AppletWidgetContainer r29 = (AppletWidgetContainer) r5;
        if (r29.A == r28) goto L59;
        StringBuilder r30 = new StringBuilder("OnLayoutChange: msgId=");
        h r31 = r29.f;
        String r32 = null;
        if (r31 == null) goto L44;
        String r33 = r31.e;
    L45:
        r30.append(r33);
        r30.append(" cardId=");
        h r34 = r29.f;
        if (r34 == null) goto L48;
        r32 = r34.a();
    L48:
        r30.append(r32);
        r30.append(" store height ");
        r30.append(r28);
        String r35 = r30.toString();
        Intrinsics.checkNotNullParameter("AppletWidgetContainer", "tag");
        t0.d r36 = com.bytedance.ai.utils.c.f2846a;
        if (r36 == null) goto L51;
        r36.d("AppletWidgetContainer", r35);
    L51:
        r29.A = r28;
        r29.f3021h.storeInt(r29.v(), r28);
        return;
    L44:
        r33 = null;
        goto L45
    L59:
        return;
    }
}
