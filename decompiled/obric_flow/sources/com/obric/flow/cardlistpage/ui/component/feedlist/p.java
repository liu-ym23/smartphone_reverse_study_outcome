package com.obric.flow.cardlistpage.ui.component.feedlist;

import android.util.Log;
import com.obric.oui.button.OIconButtonFloating;
import com.obric.oui.searchbar.v2.OSearchBar;
import com.zte.miboard.cards.express.ExpressCard;
import com.zte.miboard.cards.travel.TravelCard;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import obric.flow.externalcard.express.ExpressWidgetView;
import obric.flow.externalcard.travel.TravelWidgetView;

/* JADX INFO: loaded from: classes3.dex */
public final class p implements kotlinx.coroutines.flow.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11594a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f11595b;

    public /* synthetic */ p(Object r5, int r10) {
        this.f11594a = r10;
        this.f11595b = r5;
    }

    @Override // kotlinx.coroutines.flow.h
    public final Object emit(Object r5, Continuation r10) {
        switch(this.f11594a) {
            case 0: goto L126;
            case 1: goto L114;
            case 2: goto L108;
            case 3: goto L60;
            default: goto L4;
        };
    L4:
        obric.flow.externalcard.h r11 = (obric.flow.externalcard.h) r5;
        if ((r11 instanceof obric.flow.externalcard.f) == false) goto L7;
        boolean r12 = ((obric.flow.externalcard.f) r11).f20447a;
    L59:
        return Unit.INSTANCE;
    L7:
        boolean r13 = r11 instanceof obric.flow.externalcard.d;
        TravelCard r14 = null;
        TravelWidgetView r15 = (TravelWidgetView) this.f11595b;
        if (r13 == false) goto L28;
        if (((obric.flow.externalcard.d) r11).f20441a == false) goto L20;
        if (r15.f20452c == false) goto L131;
        r15.f20452c = false;
        TravelCard r16 = r15.f20451b;
        if (r16 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("travelView");
    L18:
        r14.onSlideOut();
        goto L59
    L17:
        r14 = r16;
        goto L18
    L131:
        return Unit.INSTANCE;
    L20:
        if (r15.f20452c == true) goto L132;
        r15.f20452c = true;
        TravelCard r17 = r15.f20451b;
        if (r17 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("travelView");
    L26:
        r14.onSlideIn();
        goto L59
    L25:
        r14 = r17;
        goto L26
    L132:
        return Unit.INSTANCE;
    L28:
        if ((r11 instanceof obric.flow.externalcard.e) == false) goto L42;
        if (((obric.flow.externalcard.e) r11).f20442a == false) goto L36;
        TravelCard r18 = r15.f20451b;
        if (r18 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("travelView");
    L35:
        r14.onResume(r15.f20452c);
        goto L59
    L34:
        r14 = r18;
        goto L35
    L36:
        TravelCard r19 = r15.f20451b;
        if (r19 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("travelView");
    L40:
        r14.onPause(r15.f20452c);
        goto L59
    L39:
        r14 = r19;
        goto L40
    L42:
        if ((r11 instanceof obric.flow.externalcard.c) == false) goto L49;
        TravelCard r20 = r15.f20451b;
        if (r20 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("travelView");
    L47:
        obric.flow.externalcard.c r21 = (obric.flow.externalcard.c) r11;
        r14.onParentPopupMenuItemClick(r21.f20439a, r21.f20440b);
        goto L59
    L46:
        r14 = r20;
        goto L47
    L49:
        if ((r11 instanceof obric.flow.externalcard.b) == false) goto L59;
        if (((obric.flow.externalcard.b) r11).f20438a == true) goto L59;
        TravelCard r22 = r15.f20451b;
        if (r22 != null) goto L55;
        Intrinsics.throwUninitializedPropertyAccessException("travelView");
        r22 = null;
    L55:
        r22.onDestroy();
        if (Intrinsics.areEqual(r15, k5.d.f18603h) == false) goto L59;
        k5.d.f18603h = null;
        goto L59
    L60:
        obric.flow.externalcard.h r23 = (obric.flow.externalcard.h) r5;
        if ((r23 instanceof obric.flow.externalcard.f) == false) goto L63;
        boolean r24 = ((obric.flow.externalcard.f) r23).f20447a;
    L107:
        return Unit.INSTANCE;
    L63:
        boolean r25 = r23 instanceof obric.flow.externalcard.d;
        ExpressCard r26 = null;
        ExpressWidgetView r27 = (ExpressWidgetView) this.f11595b;
        if (r25 == false) goto L84;
        if (((obric.flow.externalcard.d) r23).f20441a == false) goto L75;
        Log.i("ExpressWidgetView", "minusOneExit");
        if (r27.f20446c == false) goto L133;
        r27.f20446c = false;
        ExpressCard r28 = r27.f20445b;
        if (r28 != null) goto L73;
        Intrinsics.throwUninitializedPropertyAccessException("travelView");
    L74:
        r26.onSlideOut();
        goto L107
    L73:
        r26 = r28;
        goto L74
    L133:
        return Unit.INSTANCE;
    L75:
        Log.i("ExpressWidgetView", "minusOneEnter");
        if (r27.f20446c == true) goto L134;
        r27.f20446c = true;
        ExpressCard r29 = r27.f20445b;
        if (r29 != null) goto L81;
        Intrinsics.throwUninitializedPropertyAccessException("travelView");
    L82:
        r26.onSlideIn();
        goto L107
    L81:
        r26 = r29;
        goto L82
    L134:
        return Unit.INSTANCE;
    L84:
        if ((r23 instanceof obric.flow.externalcard.e) == false) goto L98;
        if (((obric.flow.externalcard.e) r23).f20442a == false) goto L92;
        Log.i("ExpressWidgetView", "resume");
        ExpressCard r30 = r27.f20445b;
        if (r30 != null) goto L90;
        Intrinsics.throwUninitializedPropertyAccessException("travelView");
    L91:
        r26.onResume(r27.f20446c);
        goto L107
    L90:
        r26 = r30;
        goto L91
    L92:
        Log.i("ExpressWidgetView", "pause");
        ExpressCard r31 = r27.f20445b;
        if (r31 != null) goto L95;
        Intrinsics.throwUninitializedPropertyAccessException("travelView");
    L96:
        r26.onPause(r27.f20446c);
        goto L107
    L95:
        r26 = r31;
        goto L96
    L98:
        if ((r23 instanceof obric.flow.externalcard.b) == false) goto L107;
        if (((obric.flow.externalcard.b) r23).f20438a == true) goto L107;
        ExpressCard r32 = r27.f20445b;
        if (r32 != null) goto L104;
        Intrinsics.throwUninitializedPropertyAccessException("travelView");
    L105:
        r26.onDestroy();
        goto L107
    L104:
        r26 = r32;
        goto L105
    L108:
        boolean r33 = ((Boolean) r5).booleanValue();
        OSearchBar r34 = ((com.obric.flow.cardlistpage.ui.component.search.i) this.f11595b).d;
        if (r33 == false) goto L111;
        int r35 = 0;
    L112:
        r34.setVisibility(r35);
        return Unit.INSTANCE;
    L111:
        r35 = 8;
        goto L112
    L114:
        boolean r36 = ((Boolean) r5).booleanValue();
        com.obric.flow.cardlistpage.ui.component.floatingbtn.j r37 = (com.obric.flow.cardlistpage.ui.component.floatingbtn.j) this.f11595b;
        OIconButtonFloating r38 = r37.d;
        int r39 = 8;
        if (r36 == false) goto L117;
        int r40 = 0;
    L118:
        r38.setVisibility(r40);
        OIconButtonFloating r41 = r37.e;
        if (r41 == null) goto L125;
        if (r36 == false) goto L123;
        r39 = 0;
    L123:
        r41.setVisibility(r39);
    L125:
        return Unit.INSTANCE;
    L117:
        r40 = 8;
        goto L118
    L126:
        Object r42 = s.n((List) r5, (s) this.f11595b, r10);
        if (r42 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L130;
        return r42;
    L130:
        return Unit.INSTANCE;
    }
}
