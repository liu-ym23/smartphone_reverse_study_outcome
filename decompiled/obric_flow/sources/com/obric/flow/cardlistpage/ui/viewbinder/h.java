package com.obric.flow.cardlistpage.ui.viewbinder;

import android.appwidget.AppWidgetHostView;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProviderInfo;
import android.content.Context;
import android.os.DeadObjectException;
import android.os.TransactionTooLargeException;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RemoteViews;
import androidx.recyclerview.widget.RecyclerView;
import com.obric.flow.cardlistpage.R$layout;
import com.obric.flow.cardlistpage.data.WidgetCardModel;
import com.obric.flow.cardlistpage.ui.view.WidgetBox;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.h0;
import obric.flow.appwidget.FlowAppWidgetProviderInfo;

/* JADX INFO: loaded from: classes3.dex */
public final class h extends um.a implements c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f11876c;
    public final gu.d d;
    public final AppWidgetManager e;
    public final RecyclerView f;
    public final Function3 g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Function1 f11877h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Function1 f11878i;

    public h(Context r5, gu.d r10, AppWidgetManager r11, RecyclerView r12, Function3 r13, Function1 r14, Function1 r15) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r10, "appWidgetHost");
        Intrinsics.checkNotNullParameter(r11, "appWidgetManager");
        Intrinsics.checkNotNullParameter(r12, "recyclerView");
        super(3);
        this.f11876c = r5;
        this.d = r10;
        this.e = r11;
        this.f = r12;
        this.g = r13;
        this.f11877h = r14;
        this.f11878i = r15;
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
        BuildersKt.launch$default(h0.a(Dispatchers.getIO()), null, null, new WidgetCardViewBinder$onEndDrag$1(r11, null), 3, null);
        this.f11878i.invoke(r10);
        return;
    L8:
        r11 = null;
        goto L9
    }

    @Override // com.obric.flow.cardlistpage.ui.viewbinder.c
    public final void c(RecyclerView.ViewHolder r5) {
        Intrinsics.checkNotNullParameter(r5, "viewHolder");
        com.obric.flow.cardlistpage.b.b();
        com.obric.flow.cardlistpage.util.g.c(this.f11876c);
    }

    @Override // um.a
    public final void u(RecyclerView.ViewHolder r18, Object r19) {
        WidgetCardViewBinder$ViewHolder r5 = (WidgetCardViewBinder$ViewHolder) r18;
        WidgetCardModel r10 = (WidgetCardModel) r19;
        Intrinsics.checkNotNullParameter(r5, "holder");
        Intrinsics.checkNotNullParameter(r10, "item");
        String r11 = androidx.constraintlayout.motion.widget.a.p("onBindViewHolder: item=", r10.getTitle(), ", widgetId=", r10.getOriginalId());
        Intrinsics.checkNotNullParameter("NLWidgetCardViewBinder", "tag");
        Intrinsics.checkNotNullParameter(r11, "msg");
        org.koin.core.a r12 = su.a.f22013b;
        if (r12 == null) goto L91;
        ((ju.b) r12.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).i("NLWidgetCardViewBinder", r11);
        View r13 = r5.itemView;
        if ((r13 instanceof WidgetBox) == false) goto L7;
        WidgetBox r14 = (WidgetBox) r13;
    L8:
        if (r14 == null) goto L10;
        r14.b();
    L10:
        Function3 r15 = this.g;
        LinearLayout r16 = r5.f11867a;
        Intrinsics.checkNotNullParameter(r10, "item");
        gu.d r17 = this.d;
        Intrinsics.checkNotNullParameter(r17, "appWidgetHost");
        AppWidgetManager r110 = this.e;
        Intrinsics.checkNotNullParameter(r110, "appWidgetManager");
        RecyclerView r111 = this.f;
        Intrinsics.checkNotNullParameter(r111, "recyclerView");
        View r20 = r5.itemView;     // Catch: Exception -> L14
        if ((r20 instanceof WidgetBox) == false) goto L16;
        WidgetBox r21 = (WidgetBox) r20;     // Catch: Exception -> L14
    L17:
        if (r21 == null) goto L19;
        r21.setWidgetView(null);     // Catch: Exception -> L14
    L19:
        r16.removeAllViews();     // Catch: Exception -> L14
        r16.getLayoutParams().height = -2;     // Catch: Exception -> L14
        int r22 = Integer.parseInt(r10.getOriginalId());     // Catch: Exception -> L14
        Integer r23 = Integer.valueOf(r22);     // Catch: Exception -> L14
        if (r22 != 0) goto L103;
        String r24 = "Invalid widgetId: " + r23;     // Catch: Exception -> L27
        Intrinsics.checkNotNullParameter("NLWidgetCardViewBinder", "tag");     // Catch: Exception -> L27
        Intrinsics.checkNotNullParameter(r24, "msg");     // Catch: Exception -> L27
        org.koin.core.a r25 = su.a.f22013b;     // Catch: Exception -> L27
        if (r25 == null) goto L25;
        ((ju.b) r25.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).e("NLWidgetCardViewBinder", r24);     // Catch: Exception -> L27
        return;
    L25:
        throw new IllegalStateException("KoinApplication has not been started");     // Catch: Exception -> L27
    L103:
        AppWidgetProviderInfo r112 = r110.getAppWidgetInfo(r22);     // Catch: Exception -> L82
        if (r112 != null) goto L36;
        String r26 = "Failed to get AppWidgetInfo for widgetId: " + r23;     // Catch: Exception -> L27
        Intrinsics.checkNotNullParameter("NLWidgetCardViewBinder", "tag");     // Catch: Exception -> L27
        Intrinsics.checkNotNullParameter(r26, "msg");     // Catch: Exception -> L27
        org.koin.core.a r27 = su.a.f22013b;     // Catch: Exception -> L27
        if (r27 == null) goto L35;
        ((ju.b) r27.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).e("NLWidgetCardViewBinder", r26);     // Catch: Exception -> L27
        return;
    L35:
        throw new IllegalStateException("KoinApplication has not been started");     // Catch: Exception -> L27
    L36:
        gu.f r28 = (gu.f) r17.f17230b.get(r22);     // Catch: Exception -> L82
        if (r28 == null) goto L99;
        r23 = r23;
    L58:
        gu.f r113 = r28;
        View r29 = r5.itemView;     // Catch: Exception -> L80
        if ((r29 instanceof WidgetBox) == false) goto L70;
        WidgetBox r30 = (WidgetBox) r29;     // Catch: Exception -> L59
    L71:
        if (r30 == null) goto L74;
        r30.setWidgetView(r113);     // Catch: Exception -> L80
    L74:
        r113.f17241n = r111;     // Catch: Exception -> L80
        r16.removeAllViews();     // Catch: Exception -> L80
        com.lynx.tasm.utils.d.w(r113);     // Catch: Exception -> L80
        r16.addView(r113, -1, -2);     // Catch: Exception -> L80
        Integer r114 = r23;
        r113.setOnLongClickListener(new e(r5.f11868b, r5, r10, r15, r112, 1));     // Catch: Exception -> L78
        return;
    L78:
        e = e;
    L79:
        Integer r31 = r114;
    L84:
        String r32 = "Error creating widget view for widgetId: " + r31;
        Intrinsics.checkNotNullParameter("NLWidgetCardViewBinder", "tag");
        Intrinsics.checkNotNullParameter(r32, "msg");
        Intrinsics.checkNotNullParameter(e, "t");
        org.koin.core.a r33 = su.a.f22013b;
        if (r33 == null) goto L89;
        ((ju.b) r33.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).e("NLWidgetCardViewBinder", r32, e);
        return;
    L89:
        throw new IllegalStateException("KoinApplication has not been started");
    L70:
        r30 = null;
    L80:
        e = e;
        r114 = r23;
        goto L79
    L99:
        Context r34 = com.obric.flow.cardlistpage.util.g.a(r5.itemView.getContext());     // Catch: Exception -> L63
        r5.itemView.getContext().getApplicationContext();     // Catch: Exception -> L63
        FlowAppWidgetProviderInfo r35 = FlowAppWidgetProviderInfo.c(r112);     // Catch: Exception -> L63
        AppWidgetHostView r36 = r17.createView(r34, r22, r35);     // Catch: Exception -> L41
    L57:
        Intrinsics.checkNotNull(r36, "null cannot be cast to non-null type obric.flow.appwidget.FlowAppWidgetHostView");     // Catch: Exception -> L59
        r28 = (gu.f) r36;     // Catch: Exception -> L59
    L41:
        e = move-exception;
        if ((e.getCause() instanceof TransactionTooLargeException) == false) goto L47;
    L50:
        boolean r37 = true;
    L51:
        if (r37 == false) goto L62;
        SparseArray r38 = r17.f17230b;
        gu.f r115 = (gu.f) r38.get(r22);     // Catch: Exception -> L59
        if (r115 != null) goto L56;
        r115 = new gu.f(r17.f17231c);     // Catch: Exception -> L59
        r38.put(r22, r115);     // Catch: Exception -> L59
    L56:
        r36 = r115;
        r36.setAppWidget(r22, r35);     // Catch: Exception -> L59
        r36.updateAppWidget(new RemoteViews(r36.getAppWidgetInfo().provider.getPackageName(), 0));     // Catch: Exception -> L59
        goto L57
    L62:
        throw new RuntimeException(e);     // Catch: Exception -> L59
    L47:
        if ((e.getCause() instanceof DeadObjectException) == true) goto L50;
        r37 = false;
    L59:
        e = e;
    L60:
        r31 = r23;
    L63:
        e = e;
    L82:
        e = e;
        r114 = r23;
    L27:
        e = e;
        r31 = r23;
        goto L84
    L16:
        r21 = null;
    L14:
        e = e;
        r31 = null;
        goto L84
    L7:
        r14 = null;
        goto L8
    L91:
        throw new IllegalStateException("KoinApplication has not been started");
    }

    @Override // um.a
    public final RecyclerView.ViewHolder v(LayoutInflater r10, ViewGroup r11) {
        Intrinsics.checkNotNullParameter(r10, "inflater");
        Intrinsics.checkNotNullParameter(r11, "parent");
        Intrinsics.checkNotNullParameter("NLWidgetCardViewBinder", "tag");
        Intrinsics.checkNotNullParameter("onCreateViewHolder", "msg");
        org.koin.core.a r5 = su.a.f22013b;
        if (r5 == null) goto L7;
        ((ju.b) r5.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).i("NLWidgetCardViewBinder", "onCreateViewHolder");
        return new WidgetCardViewBinder$ViewHolder(this, r10.inflate(R$layout.item_remote_view, r11, false));
    L7:
        throw new IllegalStateException("KoinApplication has not been started");
    }

    @Override // um.a
    public final void x(RecyclerView.ViewHolder r5) {
        WidgetCardViewBinder$ViewHolder r10 = (WidgetCardViewBinder$ViewHolder) r5;
        Intrinsics.checkNotNullParameter(r10, "holder");
        View r11 = r10.itemView;
        r11.animate().cancel();
        r11.clearAnimation();
        if ((r11 instanceof WidgetBox) == false) goto L5;
        WidgetBox r12 = (WidgetBox) r11;
    L6:
        if (r12 == null) goto L9;
        r12.setWidgetView(null);
    L9:
        r11.setAlpha(1.0f);
        r11.setTranslationX(0.0f);
        r11.setTranslationY(0.0f);
        r11.setScaleX(1.0f);
        r11.setScaleY(1.0f);
        r11.setRotation(0.0f);
        Intrinsics.checkNotNullParameter(r10, "holder");
        return;
    L5:
        r12 = null;
        goto L6
    }
}
