package com.obric.flow.cardlistpage.ui;

import android.view.View;
import android.view.ViewParent;
import com.obric.flow.cardlistpage.ui.component.feedlist.s;
import com.obric.flow.cardlistpage.ui.component.popupdialog.o;
import com.obric.flow.cardlistpage.ui.component.popupdialog.p;
import com.obric.flow.cardlistpage.ui.component.popupdialog.v;
import com.obric.flow.cardlistpage.ui.view.WidgetBox;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.i2;

/* JADX INFO: loaded from: classes3.dex */
public final class g implements kotlinx.coroutines.flow.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11775a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CardFeedLayout f11776b;

    public /* synthetic */ g(CardFeedLayout r5, int r10) {
        this.f11775a = r10;
        this.f11776b = r5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.flow.h
    public final Object emit(Object r5, Continuation r10) {
        s r11 = null;
        o r12 = null;
        s r13 = null;
        o r14 = null;
        CardFeedLayout r15 = this.f11776b;
        switch(this.f11775a) {
            case 0: goto L25;
            default: goto L4;
        };
    L4:
        obric.flow.externalcard.h r16 = (obric.flow.externalcard.h) r5;
        if ((r16 instanceof obric.flow.externalcard.g) == false) goto L24;
        obric.flow.externalcard.g r17 = (obric.flow.externalcard.g) r16;
        View r18 = r17.f20448a;
        int r19 = CardFeedLayout.f11536c0;
        r15.getClass();
        View r20 = r18;
    L7:
        if (r20 == null) goto L15;
        if ((r20 instanceof WidgetBox) == true) goto L10;
        ViewParent r21 = r20.getParent();
        if ((r21 instanceof View) == true) goto L13;
        r20 = null;
        goto L7
    L13:
        r20 = (View) r21;
        goto L7
    L10:
        WidgetBox r22 = (WidgetBox) r20;
    L16:
        if (r22 == null) goto L24;
        o r23 = r15.D;
        if (r23 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("popupDialogComponent");
    L22:
        r12.k(new v(new com.obric.flow.cardlistpage.ui.component.popupdialog.d(new com.obric.flow.cardlistpage.ui.component.popupdialog.a(r22), r18, r17.f20449b)));
        goto L24
    L21:
        r12 = r23;
        goto L22
    L15:
        r22 = null;
    L24:
        return Unit.INSTANCE;
    L25:
        obric.flow.g r24 = (obric.flow.g) r5;
        if ((r24 instanceof obric.flow.d) == false) goto L33;
        s r25 = r15.C;
        if (r25 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("feedListComponent");
    L31:
        r13.f(new com.obric.flow.cardlistpage.ui.component.feedlist.j(((obric.flow.d) r24).f20435a));
    L57:
        return Unit.INSTANCE;
    L30:
        r13 = r25;
        goto L31
    L33:
        if ((r24 instanceof obric.flow.e) == false) goto L45;
        i2 r26 = obric.flow.externalcard.a.f20437a;
        obric.flow.e r27 = (obric.flow.e) r24;
        obric.flow.externalcard.a.d(r27.f20436a);
        if (r27.f20436a == false) goto L39;
        int r28 = CardFeedLayout.f11536c0;
        if (r15.i() == false) goto L57;
        r15.o();
        r15.l();
        goto L57
    L39:
        r15.p();
        o r29 = r15.D;
        if (r29 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("popupDialogComponent");
    L43:
        r14.k(new p(false));
        r15.m();
        goto L57
    L42:
        r14 = r29;
        goto L43
    L45:
        if ((r24 instanceof obric.flow.c) == false) goto L48;
        i2 r30 = obric.flow.externalcard.a.f20437a;
        obric.flow.externalcard.a.c(((obric.flow.c) r24).f20434a);
        goto L57
    L48:
        if ((r24 instanceof obric.flow.f) == false) goto L57;
        obric.flow.f r31 = (obric.flow.f) r24;
        if (r31.f20453a == 0) goto L57;
        s r32 = r15.C;
        if (r32 != null) goto L54;
        Intrinsics.throwUninitializedPropertyAccessException("feedListComponent");
    L55:
        r11.z(r31.f20453a);
        goto L57
    L54:
        r11 = r32;
        goto L55
    }
}
