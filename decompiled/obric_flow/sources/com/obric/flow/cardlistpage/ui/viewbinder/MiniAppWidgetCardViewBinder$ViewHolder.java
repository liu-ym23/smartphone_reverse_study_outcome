package com.obric.flow.cardlistpage.ui.viewbinder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.obric.flow.cardlistpage.R$id;
import com.obric.flow.cardlistpage.data.MiniAppWidgetCardModel;
import com.obric.flow.cardlistpage.ui.view.WidgetBox;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/obric/flow/cardlistpage/ui/viewbinder/MiniAppWidgetCardViewBinder$ViewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "CardListPage_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nMiniAppWidgetCardViewBinder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MiniAppWidgetCardViewBinder.kt\ncom/obric/flow/cardlistpage/ui/viewbinder/MiniAppWidgetCardViewBinder$ViewHolder\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,429:1\n256#2,2:430\n256#2,2:432\n326#2,4:434\n326#2,4:438\n256#2,2:442\n256#2,2:444\n326#2,4:446\n326#2,4:450\n256#2,2:454\n256#2,2:456\n256#2,2:458\n256#2,2:460\n*S KotlinDebug\n*F\n+ 1 MiniAppWidgetCardViewBinder.kt\ncom/obric/flow/cardlistpage/ui/viewbinder/MiniAppWidgetCardViewBinder$ViewHolder\n*L\n221#1:430,2\n222#1:432,2\n224#1:434,4\n227#1:438,4\n234#1:442,2\n235#1:444,2\n237#1:446,4\n316#1:450,4\n319#1:454,2\n320#1:456,2\n325#1:458,2\n326#1:460,2\n*E\n"})
public final class MiniAppWidgetCardViewBinder$ViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f11859i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f11860a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ProgressBar f11861b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f11862c;
    public Job d;
    public String e;
    public View f;
    public d g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ f f11863h;

    public MiniAppWidgetCardViewBinder$ViewHolder(f r5, View r10) {
        Intrinsics.checkNotNullParameter(r10, "itemView");
        this.f11863h = r5;
        super(r10);
        this.f11860a = (LinearLayout) r10.findViewById(R$id.widget_content_container);
        this.f11861b = (ProgressBar) r10.findViewById(R$id.widget_loading_indicator);
        this.f11862c = (TextView) r10.findViewById(R$id.widget_error_text);
    }

    public static final void a(MiniAppWidgetCardViewBinder$ViewHolder r10, MiniAppWidgetCardModel r11, View r12) {
        r10.f11861b.setVisibility(8);
        r10.f11862c.setVisibility(8);
        f r5 = r10.f11863h;
        int r13 = wn.f.d(r11, r5.f11874c);
        LinearLayout r14 = r10.f11860a;
        ViewGroup.LayoutParams r15 = r14.getLayoutParams();
        if (r15 == null) goto L18;
        r15.height = r13;
        r14.setLayoutParams(r15);
        r14.removeAllViews();
        com.lynx.tasm.utils.d.w(r12);
        r14.addView(r12, -1, r13);
        View r16 = r10.itemView;
        if ((r16 instanceof WidgetBox) == false) goto L7;
        WidgetBox r17 = (WidgetBox) r16;
    L8:
        if (r17 == null) goto L11;
        r17.setWidgetView(r12);
    L11:
        String r18 = r5.d.f20491a;
        String r19 = r11.getId();
        String r20 = r11.getInstanceId();
        String r21 = r11.getAppletId();
        String r22 = r11.getWidgetId();
        int r23 = r11.getSpanX();
        int r110 = r11.getSpanY();
        StringBuilder r24 = androidx.constraintlayout.motion.widget.a.y("attach mini app widget view hostId=", r18, " cardId=", r19, " instanceId=");
        androidx.constraintlayout.motion.widget.a.C(r24, r20, " appletId=", r21, " widgetId=");
        r24.append(r22);
        r24.append(" span=");
        r24.append(r23);
        r24.append("x");
        r24.append(r110);
        r24.append(" height=");
        r24.append(r13);
        String r25 = r24.toString();
        Intrinsics.checkNotNullParameter("MiniAppWidgetCardViewBinder", "tag");
        Intrinsics.checkNotNullParameter(r25, "msg");
        org.koin.core.a r111 = su.a.f22013b;
        if (r111 == null) goto L16;
        ((ju.b) r111.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).i("MiniAppWidgetCardViewBinder", r25);
        return;
    L16:
        throw new IllegalStateException("KoinApplication has not been started");
    L7:
        r17 = null;
        goto L8
    L18:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    public static final void b(MiniAppWidgetCardViewBinder$ViewHolder r5) {
        r5.f11860a.removeAllViews();
        r5.f11861b.setVisibility(8);
        r5.f11862c.setVisibility(0);
        View r10 = r5.itemView;
        if ((r10 instanceof WidgetBox) == false) goto L5;
        WidgetBox r11 = (WidgetBox) r10;
    L6:
        if (r11 == null) goto L10;
        r11.setWidgetView(null);
        return;
    L10:
        return;
    L5:
        r11 = null;
        goto L6
    }

    public static boolean c(View r10) {
        ViewGroup.LayoutParams r5 = r10.getLayoutParams();
        if (r5 != null) goto L5;
        ViewGroup.LayoutParams r11 = new ViewGroup.LayoutParams(-1, -1);
    L7:
        if (r5 != null) goto L9;
    L14:
        r11.width = -1;
        r11.height = -1;
        r10.setLayoutParams(r11);
        boolean r12 = true;
    L15:
        String r13 = r10.getClass().getName();
        Intrinsics.checkNotNull(r13);
        if (StringsKt.k(r13, ".LynxRenderView") == false) goto L18;
    L34:
        return r12;
    L18:
        if (StringsKt.k(r13, ".LynxView") == true) goto L34;
        if ((r10 instanceof ViewGroup) == false) goto L23;
        ViewGroup r14 = (ViewGroup) r10;
    L24:
        if (r14 == null) goto L34;
        int r15 = r14.getChildCount();
        int r16 = 0;
    L26:
        if (r16 >= r15) goto L34;
        if (c(r14.getChildAt(r16)) == true) goto L32;
        if (r12 == true) goto L32;
        r12 = false;
    L33:
        r16 = r16 + 1;
    L32:
        r12 = true;
        goto L33
    L23:
        r14 = null;
        goto L24
    L9:
        if (r11.width != (-1)) goto L14;
        if (r11.height != (-1)) goto L14;
        r12 = false;
        goto L15
    L5:
        r11 = r5;
        goto L7
    }

    public final void d() {
        View r5 = this.f;
        d r10 = this.g;
        if (r5 == null) goto L8;
        if (r10 == null) goto L8;
        if (r5.getViewTreeObserver().isAlive() == false) goto L8;
        r5.getViewTreeObserver().removeOnGlobalLayoutListener(r10);
    L8:
        this.f = null;
        this.g = null;
    }

    public final void e(MiniAppWidgetCardModel r5, boolean r10) {
        View r11 = this.itemView;
        if ((r11 instanceof WidgetBox) == false) goto L5;
        WidgetBox r12 = (WidgetBox) r11;
    L6:
        if (r12 == null) goto L9;
        r12.setWidgetView(null);
    L9:
        LinearLayout r13 = this.f11860a;
        r13.removeAllViews();
        ViewGroup.LayoutParams r14 = r13.getLayoutParams();
        if (r14 == null) goto L21;
        if (r5 == null) goto L13;
        int r15 = wn.f.d(r5, this.f11863h.f11874c);
    L14:
        r14.height = r15;
        r13.setLayoutParams(r14);
        if (r10 == false) goto L17;
        int r16 = 0;
    L18:
        this.f11861b.setVisibility(r16);
        this.f11862c.setVisibility(8);
        return;
    L17:
        r16 = 8;
        goto L18
    L13:
        r15 = -2;
        goto L14
    L21:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L5:
        r12 = null;
        goto L6
    }
}
