package com.obric.flow.cardlistpage.ui.viewbinder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.obric.flow.cardlistpage.R$layout;
import com.obric.flow.cardlistpage.data.MiniAppWidgetCardModel;
import com.obric.flow.cardlistpage.ui.view.WidgetBox;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.h0;
import obric.flow.miniappwidget.l;

/* JADX INFO: loaded from: classes3.dex */
public final class f extends um.a implements c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f11874c;
    public final l d;
    public final CoroutineScope e;
    public final Function2 f;
    public final Function1 g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Function1 f11875h;

    public f(Context r5, l r10, CoroutineScope r11, RecyclerView r12, Function2 r13, Function1 r14, Function1 r15) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r10, "miniAppWidgetHost");
        Intrinsics.checkNotNullParameter(r11, "coroutineScope");
        Intrinsics.checkNotNullParameter(r12, "recyclerView");
        super(3);
        this.f11874c = r5;
        this.d = r10;
        this.e = r11;
        this.f = r13;
        this.g = r14;
        this.f11875h = r15;
    }

    @Override // com.obric.flow.cardlistpage.ui.viewbinder.c
    public final void a(RecyclerView.ViewHolder r5, float r10, float r11) {
        Intrinsics.checkNotNullParameter(r5, "viewHolder");
    }

    @Override // com.obric.flow.cardlistpage.ui.viewbinder.c
    public final void b(RecyclerView.ViewHolder r10) {
        Intrinsics.checkNotNullParameter(r10, "viewHolder");
        com.obric.flow.cardlistpage.b.a();
        List r5 = q().f7569a;
        if (r5 != null) goto L6;
        r5 = null;
    L6:
        if (r5 == null) goto L8;
        List r11 = CollectionsKt.toList(r5);
    L9:
        BuildersKt.launch$default(h0.a(Dispatchers.getIO()), null, null, new MiniAppWidgetCardViewBinder$onEndDrag$1(r11, null), 3, null);
        this.f11875h.invoke(r10);
        return;
    L8:
        r11 = null;
        goto L9
    }

    @Override // com.obric.flow.cardlistpage.ui.viewbinder.c
    public final void c(RecyclerView.ViewHolder r5) {
        Intrinsics.checkNotNullParameter(r5, "viewHolder");
        com.obric.flow.cardlistpage.b.b();
        com.obric.flow.cardlistpage.util.g.c(this.f11874c);
    }

    @Override // um.a
    public final void u(RecyclerView.ViewHolder r19, Object r20) {
        MiniAppWidgetCardViewBinder$ViewHolder r10 = (MiniAppWidgetCardViewBinder$ViewHolder) r19;
        MiniAppWidgetCardModel r11 = (MiniAppWidgetCardModel) r20;
        Intrinsics.checkNotNullParameter(r10, "holder");
        Intrinsics.checkNotNullParameter(r11, "item");
        View r5 = r10.itemView;
        if ((r5 instanceof WidgetBox) == false) goto L5;
        WidgetBox r12 = (WidgetBox) r5;
    L6:
        if (r12 == null) goto L8;
        r12.b();
    L8:
        Intrinsics.checkNotNullParameter(r11, "item");
        View r13 = r10.itemView;
        if ((r13 instanceof WidgetBox) == false) goto L11;
        WidgetBox r14 = (WidgetBox) r13;
    L12:
        if (r14 == null) goto L14;
        Function2 r15 = this.f;
        WidgetBox r16 = r14;
        r14.setOnLongClickListener(new e(r10.f11863h, r10, r15, r16, r11, 0));
    L14:
        f r17 = r10.f11863h;
        l r18 = r17.d;
        String r21 = r11.getInstanceId();
        r18.getClass();
        Intrinsics.checkNotNullParameter(r21, "instanceId");
        obric.flow.miniappwidget.a r22 = (obric.flow.miniappwidget.a) r18.f.get(r21);
        if (r22 == null) goto L17;
        View r23 = r22.f.getView();
    L18:
        boolean r24 = Intrinsics.areEqual(r10.e, r11.getInstanceId());
        l r25 = r17.d;
        if (r24 == false) goto L24;
        if (r23 == null) goto L24;
        ViewParent r26 = r23.getParent();
        LinearLayout r27 = r10.f11860a;
        if (r26 != r27) goto L24;
        if (r27.getChildCount() == 1) goto L28;
    L61:
        String r28 = "KoinApplication has not been started";
    L62:
        r10.e = r11.getInstanceId();
        Job r29 = r10.d;
        if (r29 == null) goto L65;
        r29.cancel(null);
    L65:
        String r30 = r25.f20491a;
        String r31 = r11.getId();
        String r32 = r11.getInstanceId();
        String r33 = r11.getAppletId();
        String r110 = r28;
        String r34 = r11.getWidgetId();
        StringBuilder r35 = androidx.constraintlayout.motion.widget.a.y("bind mini app widget start hostId=", r30, " cardId=", r31, " instanceId=");
        androidx.constraintlayout.motion.widget.a.C(r35, r32, " appletId=", r33, " widgetId=");
        String r36 = androidx.room.jarjarred.org.antlr.runtime.a.w(r35, r34, "MiniAppWidgetCardViewBinder", "tag", "msg");
        org.koin.core.a r37 = su.a.f22013b;
        if (r37 == null) goto L70;
        ((ju.b) r37.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).i("MiniAppWidgetCardViewBinder", r36);
        r10.e(r11, true);
        MiniAppWidgetCardViewBinder$ViewHolder$bindData$1 r38 = new MiniAppWidgetCardViewBinder$ViewHolder$bindData$1(r22, r17, r11, r10, null);
        r10.d = BuildersKt.launch$default(r17.e, null, null, r38, 3, null);
        return;
    L70:
        throw new IllegalStateException(r110);
    L28:
        if (r27.getChildAt(0) != r23) goto L61;
        View r39 = r10.itemView;
        if ((r39 instanceof WidgetBox) == false) goto L33;
        WidgetBox r40 = (WidgetBox) r39;
    L34:
        if (r40 == null) goto L36;
        View r41 = r40.getWidgetView();
    L37:
        if (r41 != r23) goto L61;
        r10.e = r11.getInstanceId();
        Job r42 = r10.d;
        if (r42 == null) goto L41;
        r42.cancel(null);
    L41:
        r10.d = null;
        r10.d();
        MiniAppWidgetCardViewBinder$ViewHolder.c(r23);
        d r43 = new d(r10, r23);
        r10.f = r23;
        r10.g = r43;
        r23.getViewTreeObserver().addOnGlobalLayoutListener(r43);
        r23.setOnClickListener(new com.google.android.material.snackbar.a(1, r17, r11));
        r10.f11861b.setVisibility(8);
        r10.f11862c.setVisibility(8);
        int r44 = wn.f.d(r11, r17.f11874c);
        ViewGroup.LayoutParams r45 = r27.getLayoutParams();
        if (r45 == null) goto L60;
        r45.height = r44;
        r27.setLayoutParams(r45);
        ViewGroup.LayoutParams r46 = r23.getLayoutParams();
        if (r46 == null) goto L58;
        r46.height = r44;
        r23.setLayoutParams(r46);
        View r47 = r10.itemView;
        if ((r47 instanceof WidgetBox) == false) goto L48;
        WidgetBox r48 = (WidgetBox) r47;
    L49:
        if (r48 == null) goto L52;
        r48.setWidgetView(r23);
    L52:
        String r49 = r25.f20491a;
        String r50 = r11.getId();
        String r51 = r11.getInstanceId();
        String r52 = r11.getAppletId();
        String r53 = r11.getWidgetId();
        StringBuilder r54 = androidx.constraintlayout.motion.widget.a.y("reuse mini app widget binding hostId=", r49, " cardId=", r50, " instanceId=");
        androidx.constraintlayout.motion.widget.a.C(r54, r51, " appletId=", r52, " widgetId=");
        String r55 = androidx.room.jarjarred.org.antlr.runtime.a.w(r54, r53, "MiniAppWidgetCardViewBinder", "tag", "msg");
        org.koin.core.a r56 = su.a.f22013b;
        if (r56 == null) goto L56;
        ((ju.b) r56.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).i("MiniAppWidgetCardViewBinder", r55);
        return;
    L56:
        throw new IllegalStateException("KoinApplication has not been started");
    L48:
        r48 = null;
        goto L49
    L58:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L60:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L36:
        r41 = null;
        goto L37
    L33:
        r40 = null;
    L24:
        r28 = "KoinApplication has not been started";
        goto L62
    L17:
        r23 = null;
        goto L18
    L11:
        r14 = null;
        goto L12
    L5:
        r12 = null;
        goto L6
    }

    @Override // um.a
    public final RecyclerView.ViewHolder v(LayoutInflater r5, ViewGroup r10) {
        Intrinsics.checkNotNullParameter(r5, "inflater");
        Intrinsics.checkNotNullParameter(r10, "parent");
        return new MiniAppWidgetCardViewBinder$ViewHolder(this, r5.inflate(R$layout.item_remote_view, r10, false));
    }

    @Override // um.a
    public final void x(RecyclerView.ViewHolder r5) {
        MiniAppWidgetCardViewBinder$ViewHolder r10 = (MiniAppWidgetCardViewBinder$ViewHolder) r5;
        Intrinsics.checkNotNullParameter(r10, "holder");
        Job r11 = r10.d;
        if (r11 == null) goto L5;
        r11.cancel(null);
    L5:
        r10.d = null;
        r10.e = null;
        r10.d();
        r10.itemView.animate().cancel();
        r10.itemView.clearAnimation();
        r10.e(null, false);
        r10.itemView.setAlpha(1.0f);
        r10.itemView.setTranslationX(0.0f);
        r10.itemView.setTranslationY(0.0f);
        r10.itemView.setScaleX(1.0f);
        r10.itemView.setScaleY(1.0f);
        r10.itemView.setRotation(0.0f);
        Intrinsics.checkNotNullParameter(r10, "holder");
    }
}
