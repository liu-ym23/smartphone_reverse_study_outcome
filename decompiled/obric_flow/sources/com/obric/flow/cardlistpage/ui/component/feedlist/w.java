package com.obric.flow.cardlistpage.ui.component.feedlist;

import com.obric.flow.cardlistpage.base.BaseCardModel;
import com.obric.flow.cardlistpage.data.FakeWidgetCardModel;
import com.obric.flow.cardlistpage.ui.component.overlayanimator.ControllerState;
import com.obric.flow.cardlistpage.ui.component.overlayanimator.OverlayTransitionMode;
import com.obric.flow.cardlistpage.ui.component.overlayanimator.c0;
import com.obric.flow.cardlistpage.ui.component.popupdialog.b0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
public final class w extends com.obric.flow.cardlistpage.mvi.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f11623b;

    public /* synthetic */ w(com.obric.flow.cardlistpage.mvi.k r5, int r10) {
        this.f11623b = r10;
        super(r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.obric.flow.cardlistpage.mvi.a
    public final com.obric.flow.cardlistpage.mvi.k c(com.obric.flow.cardlistpage.mvi.k r10, com.obric.flow.cardlistpage.mvi.j r11) {
        switch(this.f11623b) {
            case 0: goto L155;
            case 1: goto L153;
            case 2: goto L96;
            case 3: goto L17;
            case 4: goto L15;
            default: goto L4;
        };
    L4:
        com.obric.flow.cardlistpage.ui.component.topgradient.f r12 = (com.obric.flow.cardlistpage.ui.component.topgradient.f) r10;
        com.obric.flow.cardlistpage.ui.component.topgradient.e r13 = (com.obric.flow.cardlistpage.ui.component.topgradient.e) r11;
        Intrinsics.checkNotNullParameter(r12, "oldState");
        Intrinsics.checkNotNullParameter(r13, "intent");
        if ((r13 instanceof com.obric.flow.cardlistpage.ui.component.topgradient.d) == false) goto L10;
        if (((Boolean) r12.f11765a.getValue()).booleanValue() == true) goto L14;
        r12.f11765a.setValue(Boolean.TRUE);
    L14:
        return r12;
    L10:
        if ((r13 instanceof com.obric.flow.cardlistpage.ui.component.topgradient.c) == false) goto L14;
        if (((Boolean) r12.f11766b.getValue()).booleanValue() == true) goto L14;
        r12.f11766b.setValue(Boolean.TRUE);
        goto L14
    L15:
        com.obric.flow.cardlistpage.ui.component.search.j r14 = (com.obric.flow.cardlistpage.ui.component.search.j) r10;
        throw new ClassCastException();
    L17:
        com.obric.flow.cardlistpage.ui.component.popupdialog.x r15 = (com.obric.flow.cardlistpage.ui.component.popupdialog.x) r10;
        com.obric.flow.cardlistpage.ui.component.popupdialog.w r16 = (com.obric.flow.cardlistpage.ui.component.popupdialog.w) r11;
        Intrinsics.checkNotNullParameter(r15, "oldState");
        Intrinsics.checkNotNullParameter(r16, "intent");
        boolean r5 = r16 instanceof com.obric.flow.cardlistpage.ui.component.popupdialog.u;
        if (r5 == false) goto L20;
        boolean r17 = true;
    L21:
        Object r18 = com.obric.flow.cardlistpage.ui.component.popupdialog.z.f11751a;
        if (r17 == false) goto L46;
        if (r5 == false) goto L26;
        com.obric.flow.cardlistpage.ui.component.popupdialog.e r19 = ((com.obric.flow.cardlistpage.ui.component.popupdialog.u) r16).f11745a;
    L28:
        b0 r20 = r15.b();
        if (Intrinsics.areEqual(r20, r18) == false) goto L32;
        r20 = new com.obric.flow.cardlistpage.ui.component.popupdialog.a0(r19);
    L40:
        Intrinsics.checkNotNullParameter(r20, "<set-?>");
        r15.f11747a.setValue(r20);
    L95:
        return r15;
    L32:
        if ((r20 instanceof com.obric.flow.cardlistpage.ui.component.popupdialog.a0) == false) goto L38;
        com.obric.flow.cardlistpage.ui.component.popupdialog.a0 r21 = (com.obric.flow.cardlistpage.ui.component.popupdialog.a0) r20;
        if (Intrinsics.areEqual(r21.f11717a, r19) == true) goto L40;
        r20 = new com.obric.flow.cardlistpage.ui.component.popupdialog.y(r21.f11717a, r19, true);
        goto L40
    L38:
        if ((r20 instanceof com.obric.flow.cardlistpage.ui.component.popupdialog.y) == false) goto L42;
        r20 = com.obric.flow.cardlistpage.ui.component.popupdialog.y.a((com.obric.flow.cardlistpage.ui.component.popupdialog.y) r20, r19, false, 5);
        goto L40
    L42:
        throw new NoWhenBranchMatchedException();
    L26:
        if ((r16 instanceof com.obric.flow.cardlistpage.ui.component.popupdialog.v) == false) goto L44;
        r19 = ((com.obric.flow.cardlistpage.ui.component.popupdialog.v) r16).f11746a;
        goto L28
    L44:
        throw new IllegalStateException(("Unsupported popup show intent: " + r16).toString());
    L46:
        if ((r16 instanceof com.obric.flow.cardlistpage.ui.component.popupdialog.q) == false) goto L60;
        b0 r22 = r15.b();
        if (Intrinsics.areEqual(r22, r18) == false) goto L51;
    L56:
        Intrinsics.checkNotNullParameter(r18, "<set-?>");
        r15.f11747a.setValue(r18);
        goto L95
    L51:
        if ((r22 instanceof com.obric.flow.cardlistpage.ui.component.popupdialog.a0) == false) goto L54;
        r18 = new com.obric.flow.cardlistpage.ui.component.popupdialog.y(((com.obric.flow.cardlistpage.ui.component.popupdialog.a0) r22).f11717a, null, true);
        goto L56
    L54:
        if ((r22 instanceof com.obric.flow.cardlistpage.ui.component.popupdialog.y) == false) goto L58;
        r18 = com.obric.flow.cardlistpage.ui.component.popupdialog.y.a((com.obric.flow.cardlistpage.ui.component.popupdialog.y) r22, null, true, 1);
        goto L56
    L58:
        throw new NoWhenBranchMatchedException();
    L60:
        if ((r16 instanceof com.obric.flow.cardlistpage.ui.component.popupdialog.s) == false) goto L62;
        boolean r23 = true;
    L63:
        if (r23 == true) goto L95;
        if ((r16 instanceof com.obric.flow.cardlistpage.ui.component.popupdialog.p) == false) goto L80;
        b0 r24 = r15.b();
        if (Intrinsics.areEqual(r24, r18) == false) goto L71;
    L76:
        Intrinsics.checkNotNullParameter(r18, "<set-?>");
        r15.f11747a.setValue(r18);
        goto L95
    L71:
        if ((r24 instanceof com.obric.flow.cardlistpage.ui.component.popupdialog.a0) == false) goto L74;
        r18 = new com.obric.flow.cardlistpage.ui.component.popupdialog.y(((com.obric.flow.cardlistpage.ui.component.popupdialog.a0) r24).f11717a, null, ((com.obric.flow.cardlistpage.ui.component.popupdialog.p) r16).f11740a);
        goto L76
    L74:
        if ((r24 instanceof com.obric.flow.cardlistpage.ui.component.popupdialog.y) == false) goto L78;
        r18 = com.obric.flow.cardlistpage.ui.component.popupdialog.y.a((com.obric.flow.cardlistpage.ui.component.popupdialog.y) r24, null, ((com.obric.flow.cardlistpage.ui.component.popupdialog.p) r16).f11740a, 1);
        goto L76
    L78:
        throw new NoWhenBranchMatchedException();
    L80:
        if (Intrinsics.areEqual(r16, com.obric.flow.cardlistpage.ui.component.popupdialog.t.f11744a) == false) goto L95;
        b0 r25 = r15.b();
        if (Intrinsics.areEqual(r25, r18) == false) goto L85;
    L92:
        Intrinsics.checkNotNullParameter(r18, "<set-?>");
        r15.f11747a.setValue(r18);
        goto L95
    L85:
        if ((r25 instanceof com.obric.flow.cardlistpage.ui.component.popupdialog.a0) == true) goto L92;
        if ((r25 instanceof com.obric.flow.cardlistpage.ui.component.popupdialog.y) == false) goto L94;
        com.obric.flow.cardlistpage.ui.component.popupdialog.e r26 = ((com.obric.flow.cardlistpage.ui.component.popupdialog.y) r25).f11749b;
        if (r26 == null) goto L92;
        r18 = new com.obric.flow.cardlistpage.ui.component.popupdialog.a0(r26);
        goto L92
    L94:
        throw new NoWhenBranchMatchedException();
    L62:
        r23 = r16 instanceof com.obric.flow.cardlistpage.ui.component.popupdialog.r;
        goto L63
    L20:
        r17 = r16 instanceof com.obric.flow.cardlistpage.ui.component.popupdialog.v;
        goto L21
    L96:
        com.obric.flow.cardlistpage.ui.component.overlayanimator.u r27 = (com.obric.flow.cardlistpage.ui.component.overlayanimator.u) r10;
        c0 r28 = (c0) r11;
        Intrinsics.checkNotNullParameter(r27, "oldState");
        Intrinsics.checkNotNullParameter(r28, "intent");
        boolean r29 = r28 instanceof com.obric.flow.cardlistpage.ui.component.overlayanimator.b0;
        boolean r30 = true;
        if (r29 == true) goto L100;
        r27.f11709i.setValue(Integer.valueOf(((Number) r27.f11709i.getValue()).intValue() + 1));
    L100:
        if ((r28 instanceof com.obric.flow.cardlistpage.ui.component.overlayanimator.y) == false) goto L102;
        r27.e(ControllerState.SCROLLING);
        r27.e.setValue(Float.valueOf(1.0f));
        r27.f(OverlayTransitionMode.DRAG);
        r27.g(true);
    L152:
        return r27;
    L102:
        float r31 = 0.0f;
        if ((r28 instanceof com.obric.flow.cardlistpage.ui.component.overlayanimator.z) == false) goto L113;
        boolean r32 = ((com.obric.flow.cardlistpage.ui.component.overlayanimator.z) r28).f11715a;
        r27.f11705a.setValue(Boolean.valueOf(r32));
        if (r32 == false) goto L107;
        r31 = 1.0f;
    L107:
        r27.f11707c.setValue(Float.valueOf(r31));
        r27.d.setValue(Float.valueOf(r27.c()));
        if (r32 == false) goto L110;
        ControllerState r33 = ControllerState.OPENED;
    L111:
        r27.e(r33);
        r27.e.setValue(Float.valueOf(1.0f));
        r27.f(OverlayTransitionMode.SNAP);
        r27.g(r32);
        goto L152
    L110:
        r33 = ControllerState.HIDDEN;
        goto L111
    L113:
        if ((r28 instanceof com.obric.flow.cardlistpage.ui.component.overlayanimator.a0) == false) goto L116;
        com.obric.flow.cardlistpage.ui.component.overlayanimator.a0 r34 = (com.obric.flow.cardlistpage.ui.component.overlayanimator.a0) r28;
        r27.f11707c.setValue(Float.valueOf(RangesKt.coerceIn(r34.f11645a, 0.0f, 1.0f)));
        r27.d.setValue(Float.valueOf(r27.c()));
        r27.f.setValue(Boolean.valueOf(r34.f11646b));
        r27.e(ControllerState.SCROLLING);
        r27.f(OverlayTransitionMode.DRAG);
        r27.g(true);
        goto L152
    L116:
        if ((r28 instanceof com.obric.flow.cardlistpage.ui.component.overlayanimator.v) == false) goto L137;
        float r35 = r27.c();
        boolean r36 = ((com.obric.flow.cardlistpage.ui.component.overlayanimator.v) r28).f11710a;
        if (r36 == false) goto L120;
        float r37 = 1.0f;
    L122:
        if (r35 != r37) goto L124;
        boolean r38 = true;
    L125:
        r27.f11705a.setValue(Boolean.valueOf(r36));
        if (r36 == false) goto L128;
        r31 = 1.0f;
    L128:
        r27.f11707c.setValue(Float.valueOf(r31));
        r27.d.setValue(Float.valueOf(r27.c()));
        if (r36 == false) goto L131;
        ControllerState r39 = ControllerState.OPENED;
    L132:
        r27.e(r39);
        r27.e.setValue(Float.valueOf(1.0f));
        r27.f(OverlayTransitionMode.ANIMATE);
        if (r38 == false) goto L135;
        r30 = r36;
    L135:
        r27.g(r30);
        goto L152
    L131:
        r39 = ControllerState.HIDDEN;
        goto L132
    L124:
        r38 = false;
        goto L125
    L120:
        r37 = 0.0f;
        goto L122
    L137:
        if ((r28 instanceof com.obric.flow.cardlistpage.ui.component.overlayanimator.w) == false) goto L144;
        r27.e(ControllerState.ALPHA_HIDDEN);
        r27.e.setValue(Float.valueOf(0.0f));
        r27.d.setValue(Float.valueOf(0.0f));
        boolean r40 = ((com.obric.flow.cardlistpage.ui.component.overlayanimator.w) r28).f11712a;
        if (r40 == false) goto L141;
        OverlayTransitionMode r41 = OverlayTransitionMode.ANIMATE;
    L142:
        r27.f(r41);
        r27.g(r40);
        goto L152
    L141:
        r41 = OverlayTransitionMode.SNAP;
        goto L142
    L144:
        if ((r28 instanceof com.obric.flow.cardlistpage.ui.component.overlayanimator.x) == false) goto L150;
        r27.e(ControllerState.OPENED);
        r27.e.setValue(Float.valueOf(1.0f));
        r27.d.setValue(Float.valueOf(1.0f));
        if (((com.obric.flow.cardlistpage.ui.component.overlayanimator.x) r28).f11713a == false) goto L148;
        OverlayTransitionMode r42 = OverlayTransitionMode.ANIMATE;
    L149:
        r27.f(r42);
        r27.g(true);
        goto L152
    L148:
        r42 = OverlayTransitionMode.SNAP;
        goto L149
    L150:
        if (r29 == false) goto L152;
        r27.g(((com.obric.flow.cardlistpage.ui.component.overlayanimator.b0) r28).f11650a);
        goto L152
    L153:
        com.obric.flow.cardlistpage.ui.component.floatingbtn.k r43 = (com.obric.flow.cardlistpage.ui.component.floatingbtn.k) r10;
        throw new ClassCastException();
    L155:
        v r44 = (v) r10;
        a0 r45 = (a0) r11;
        Intrinsics.checkNotNullParameter(r44, "oldState");
        Intrinsics.checkNotNullParameter(r45, "intent");
        if ((r45 instanceof z) == false) goto L159;
        r44.getClass();
        List r46 = ((z) r45).f11630a;
        Intrinsics.checkNotNullParameter(r46, "<set-?>");
        r44.f11622a.setValue(r46);
    L186:
        return r44;
    L159:
        if ((r45 instanceof y) == false) goto L168;
        y r47 = (y) r45;
        FakeWidgetCardModel r48 = new FakeWidgetCardModel(r47.f11628b, r47.f11629c);
        List r49 = r44.b();
        ArrayList r50 = new ArrayList();
        Iterator r51 = r49.iterator();
    L162:
        if (r51.hasNext() == false) goto L166;
        Object r52 = r51.next();
        if ((((BaseCardModel) r52) instanceof FakeWidgetCardModel) == true) goto L162;
        r50.add(r52);
        goto L162
    L166:
        List r53 = CollectionsKt.toMutableList(r50);
        r53.add(RangesKt.coerceIn(r47.f11627a, 0, r53.size()), r48);
        Intrinsics.checkNotNullParameter(r53, "<set-?>");
        r44.f11622a.setValue(r53);
        goto L186
    L168:
        if ((r45 instanceof x) == false) goto L186;
        List r54 = r44.b();
        if (r54 != null) goto L172;
    L174:
        Iterator r55 = r54.iterator();
    L176:
        if (r55.hasNext() == false) goto L186;
        if ((((BaseCardModel) r55.next()) instanceof FakeWidgetCardModel) == false) goto L176;
        List r56 = r44.b();
        ArrayList r57 = new ArrayList();
        Iterator r58 = r56.iterator();
    L181:
        if (r58.hasNext() == false) goto L185;
        Object r59 = r58.next();
        if ((((BaseCardModel) r59) instanceof FakeWidgetCardModel) == true) goto L181;
        r57.add(r59);
        goto L181
    L185:
        Intrinsics.checkNotNullParameter(r57, "<set-?>");
        r44.f11622a.setValue(r57);
        goto L186
    L172:
        if (r54.isEmpty() == false) goto L174;
        goto L174
    }
}
