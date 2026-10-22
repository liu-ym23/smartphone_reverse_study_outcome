package com.bytedance.android.livesdk.interactivity.publicscreen.highlight;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.AbsPSHighlightComp;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.FailReason;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.IPSHighlightCompLifecycle$State;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.InterruptReason;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.j;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.k;
import com.bytedance.android.livesdk.interactivity.api.settings.config.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class PSHighLightContainer implements j {
    public final Lazy a;
    public final ViewGroup b;
    public final k c;

    public final PriorityQueue<AbsPSHighlightComp> d() {
        return (PriorityQueue) this.a.getValue();
    }

    public final void e() {
        this.c.mo774getLaunchManager().b();
        List r0 = CollectionsKt.toList(d());
        ArrayList r1 = new ArrayList();
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        Object r3 = r2.next();
        if ((!Intrinsics.areEqual((Boolean) ((AbsPSHighlightComp) r3).c("extra_key_keep_show_when_rotation"), Boolean.TRUE)) == false) goto L4;
        r1.add(r3);
        goto L4
    L8:
        Iterator r4 = r1.iterator();
    L10:
        if (r4.hasNext() == false) goto L12;
        ((AbsPSHighlightComp) r4.next()).b();
        goto L10
    L12:
        d().clear();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.j
    public final void a(AbsPSHighlightComp r2) {
        Intrinsics.checkNotNullParameter(r2, "comp");
        d().remove(r2);
        r2.h(IPSHighlightCompLifecycle$State.Hidden);
        ViewGroup r0 = this.b;
        if (r0 == null) goto L6;
        r0.removeView(r2.getView());
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r1v11, types: [android.view.ViewGroup$LayoutParams] */
    /* JADX WARN: Type inference failed for: r1v12, types: [android.view.ViewGroup$LayoutParams] */
    /* JADX WARN: Type inference failed for: r1v13, types: [android.view.ViewGroup] */
    /* JADX WARN: Type inference failed for: r1v14, types: [android.view.ViewGroup$MarginLayoutParams] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v5 */
    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.j
    public final void b(AbsPSHighlightComp r13) {
        Intrinsics.checkNotNullParameter(r13, "comp");
        if (d().contains(r13) == true) goto L95;
        PriorityQueue<AbsPSHighlightComp> r0 = d();
        int r3 = 0;
        if ((r0 instanceof Collection) == true) goto L7;
    L9:
        Iterator r1 = r0.iterator();
    L11:
        if (r1.hasNext() == false) goto L15;
        if (Intrinsics.areEqual(((AbsPSHighlightComp) r1.next()).e(), r13.e()) == false) goto L11;
        boolean r2 = true;
    L16:
        if (r2 == true) goto L95;
        PriorityQueue<AbsPSHighlightComp> r4 = d();
        ArrayList r5 = new ArrayList();
        Iterator r6 = r4.iterator();
    L20:
        if (r6.hasNext() == false) goto L24;
        Object r7 = r6.next();
        if (((AbsPSHighlightComp) r7).getType().c(r13.getType()) == false) goto L20;
        r5.add(r7);
        goto L20
    L24:
        Iterator r8 = r5.iterator();
    L26:
        if (r8.hasNext() == false) goto L28;
        AbsPSHighlightComp r9 = (AbsPSHighlightComp) r8.next();
        r9.n(InterruptReason.TheSameTypeCompWannaShow);
        r9.b();
        goto L26
    L28:
        z.a.getClass();
        ?? r10 = 0;
        if (d().size() != z.a.b().h()) goto L44;
        Iterator r11 = d().iterator();
        Object r14 = null;
    L32:
        if (r11.hasNext() == false) goto L39;
        Object r15 = r11.next();
        if (((AbsPSHighlightComp) r15).getType().a() > r13.getType().a()) goto L36;
        boolean r16 = true;
    L37:
        if (r16 == false) goto L32;
        r14 = r15;
        goto L32
    L36:
        r16 = false;
        goto L37
    L39:
        AbsPSHighlightComp r17 = (AbsPSHighlightComp) r14;
        if (r17 == null) goto L42;
        r17.n(InterruptReason.OtherHighPriorityCompShow);
        r17.b();
    L45:
        ?? r18 = r13.getView();
        r18.setTag(2131389888, r13);
        d().add(r13);
        r13.p("comp_load_time", Long.valueOf(System.currentTimeMillis()));
        if ((true ^ Intrinsics.areEqual(r18.getParent(), this.b)) == false) goto L93;
        UtilityKotlinExtentionsKt.q(r18);
        long r19 = r13.getType().b();
        ArrayList r20 = new ArrayList();
        ViewGroup r21 = this.b;
        if (r21 == null) goto L50;
        int r23 = r21.getChildCount();
    L51:
        int r24 = 0;
    L52:
        if (r24 >= r23) goto L59;
        ViewGroup r25 = this.b;
        if (r25 == null) goto L58;
        View r26 = r25.getChildAt(r24);
        if (r26 == null) goto L58;
        r20.add(r26);
    L58:
        r24 = r24 + 1;
        goto L52
    L59:
        Iterator r27 = r20.iterator();
        int r28 = 0;
    L61:
        if (r27.hasNext() == false) goto L79;
        Object r29 = r27.next();
        int r30 = r3 + 1;
        if (r3 >= 0) goto L65;
        CollectionsKt.throwIndexOverflow();
    L65:
        Object r31 = ((View) r29).getTag(2131389888);
        if (r31 != null) goto L68;
    L73:
        long r33 = -1;
    L75:
        if (r19 < r33) goto L77;
        r28 = r3;
    L78:
        r3 = r30;
        goto L61
    L77:
        r28 = r30;
        goto L78
    L68:
        if ((r31 instanceof AbsPSHighlightComp) == true) goto L70;
        r31 = null;
    L70:
        AbsPSHighlightComp r34 = (AbsPSHighlightComp) r31;
        if (r34 == null) goto L73;
        r33 = r34.getType().b();
        goto L75
    L79:
        ?? r35 = r18.getLayoutParams();
        if (r35 != 0) goto L82;
    L88:
        if (r35 != 0) goto L90;
        r35 = new ViewGroup.MarginLayoutParams(-2, -2);
        ((ViewGroup.MarginLayoutParams) r35).topMargin = UtilityKotlinExtentionsKt.i(3);
    L90:
        r18.setLayoutParams(r35);
        ?? r36 = this.b;
        if (r36 == 0) goto L93;
        r36.addView(r18, r28);
        goto L93
    L82:
        if ((r35 instanceof ViewGroup.MarginLayoutParams) == false) goto L85;
        r10 = r35;
    L85:
        ViewGroup.MarginLayoutParams r37 = (ViewGroup.MarginLayoutParams) r10;
        if (r37 == null) goto L88;
        r37.topMargin = UtilityKotlinExtentionsKt.i(3);
        goto L88
    L50:
        r23 = 0;
    L93:
        r13.h(IPSHighlightCompLifecycle$State.Showed);
        return;
    L42:
        r13.m(FailReason.PriorityLower);
        return;
    L44:
        d().size();
    L15:
        r2 = false;
        goto L16
    L7:
        if (r0.isEmpty() == false) goto L9;
    L95:
        r13.m(FailReason.AlreadyShowing);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.j
    public final boolean c(Function1<? super AbsPSHighlightComp, Boolean> r3) {
        Intrinsics.checkNotNullParameter(r3, "predicate");
        PriorityQueue<AbsPSHighlightComp> r0 = d();
        if ((r0 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L13;
        if (((Boolean) r3.invoke(r1.next())).booleanValue() == false) goto L9;
        return true;
    L13:
        return false;
    L5:
        if (r0.isEmpty() == false) goto L7;
        goto L7
    }

    public PSHighLightContainer(ViewGroup r2, k r3) {
        Intrinsics.checkNotNullParameter(r3, "highlightContext");
        this.b = r2;
        this.c = r3;
        this.a = LazyKt.lazy(new PSHighLightContainer$showings$2(this));
    }
}
