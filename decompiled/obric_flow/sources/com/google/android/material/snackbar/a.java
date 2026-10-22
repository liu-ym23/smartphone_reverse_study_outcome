package com.google.android.material.snackbar;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import bf.d;
import c.m0;
import cn.nubia.neopush.commons.Constant;
import com.bytedance.ai.bridge.method.router.OpenPageMethod;
import com.bytedance.ies.xelement.viewpager.LynxTabBarView;
import com.google.android.material.tabs.TabLayout;
import com.lynx.tasm.utils.g;
import com.obric.common.oui.R$string;
import com.obric.flow.cardlistpage.data.MiniAppWidgetCardModel;
import com.obric.flow.cardlistpage.ui.viewbinder.MiniAppWidgetCardViewBinder$ViewHolder;
import com.obric.oui.calendar.OMonthPickerView;
import com.obric.oui.calendar.PickerSelectionMode;
import com.obric.oui.calendar.u;
import com.obric.oui.filter.OFilter;
import com.obric.oui.filterpanel.OFilterGroupView;
import com.obric.oui.indicator.OCarouselIndicator;
import com.obric.oui.indicator.l;
import com.obric.oui.indicator.p;
import com.obric.oui.indicator.r;
import com.obric.oui.indicator.s;
import com.obric.oui.searchbar.OSearchBar;
import com.zte.miboard.cards.travel.TravelSettingsAty;
import java.util.ArrayList;
import java.util.Iterator;
import ju.b;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import xe.f;
import xe.i;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8595a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f8596b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f8597c;

    public /* synthetic */ a(int r5, Object r10, Object r11) {
        this.f8595a = r5;
        this.f8596b = r10;
        this.f8597c = r11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public final void onClick(View r11) {
        Object r5 = this.f8597c;
        Object r10 = this.f8596b;
        switch(this.f8595a) {
            case 0: goto L101;
            case 1: goto L80;
            case 2: goto L72;
            case 3: goto L61;
            case 4: goto L59;
            case 5: goto L57;
            case 6: goto L46;
            case 7: goto L12;
            case 8: goto L8;
            default: goto L4;
        };
    L4:
        i r12 = (i) r10;
        Intrinsics.checkNotNullParameter(r12, "this$0");
        TabLayout.Tab r13 = (TabLayout.Tab) r5;
        Intrinsics.checkNotNullParameter(r13, "$tabView");
        f r14 = r12.f23126r;
        if (r14 == null) goto L117;
        Intrinsics.checkNotNullParameter(r13, "tab");
        ((d) r14).f911a.getClass();
        return;
    L117:
        return;
    L8:
        int r15 = LynxTabBarView.f6512k;
        LynxTabBarView r16 = (LynxTabBarView) r10;
        Intrinsics.checkNotNullParameter(r16, "this$0");
        Ref.ObjectRef r17 = (Ref.ObjectRef) r5;
        Intrinsics.checkNotNullParameter(r17, "$tabAti");
        ym.d r18 = r16.d;
        if (r18 == null) goto L118;
        T r19 = r17.element;
        Intrinsics.checkNotNull(r19);
        TabLayout.Tab r110 = (TabLayout.Tab) r19;
        Intrinsics.checkNotNullParameter(r110, "tab");
        ((LynxTabBarView) r18.f23297a).e = r110;
        return;
    L118:
        return;
    L12:
        int r111 = OFilterGroupView.f13211r;
        OFilterGroupView r20 = (OFilterGroupView) r10;
        Intrinsics.checkNotNullParameter(r20, "this$0");
        OFilter r21 = (OFilter) r5;
        Intrinsics.checkNotNullParameter(r21, "$oFilter");
        if (r11.isSelected() == true) goto L15;
    L19:
        OFilter r112 = (OFilter) r11;
        r20.getClass();
        Intrinsics.checkNotNullParameter(r112, "filter");
        if (r112.isSelected() == true) goto L44;
        ArrayList r113 = r20.f13220p;
        if (r113 != null) goto L25;
    L27:
        Iterator r22 = r113.iterator();
        int r23 = 0;
    L29:
        if (r22.hasNext() == false) goto L36;
        if (((OFilter) r22.next()).isSelected() == false) goto L29;
        r23 = r23 + 1;
        if (r23 >= 0) goto L29;
        CollectionsKt.throwCountOverflow();
    L36:
        if (r23 < r20.f13215k) goto L43;
        Log.d(r20.g, "unSelectAll() called");
        Iterator r114 = r113.iterator();
    L39:
        if (r114.hasNext() == false) goto L43;
        OFilter r24 = (OFilter) r114.next();
        if (r24.isSelected() == false) goto L39;
        r24.setSelected(false);
    L43:
        r112.setSelected(true);
        goto L44
    L25:
        if (r113.isEmpty() == false) goto L27;
        r23 = 0;
    L44:
        r20.getClass();
        return;
    L15:
        if (r20.f13215k == 1) goto L17;
    L18:
        r21.setSelected(false);
        goto L44
    L17:
        if (r20.f13221q == false) goto L19;
    L46:
        int r115 = OFilterGroupView.f13211r;
        OFilterGroupView r25 = (OFilterGroupView) r10;
        Intrinsics.checkNotNullParameter(r25, "this$0");
        Context r26 = (Context) r5;
        Intrinsics.checkNotNullParameter(r26, "$context");
        r25.f13214j.removeAllViews();
        boolean r116 = r25.f13217m;
        int r117 = r25.f13216l;
        TextView r27 = r25.f13213i;
        if (r116 == false) goto L52;
        if (r27 == null) goto L51;
        r27.setText(r26.getResources().getString(R$string.oui_show_more));
    L51:
        r25.e(r25.f13218n, r117);
        r25.f13217m = false;
        return;
    L52:
        if (r27 == null) goto L55;
        r27.setText(r26.getResources().getString(R$string.oui_show_less));
    L55:
        r25.e(r25.f13219o, r117);
        r25.f13217m = true;
        return;
    L57:
        TravelSettingsAty.j((TravelSettingsAty) r10, (m0) r5, r11);
        return;
    L59:
        int r118 = OSearchBar.f14267k;
        OSearchBar r28 = (OSearchBar) r10;
        Intrinsics.checkNotNullParameter(r28, "this$0");
        View.OnClickListener r29 = (View.OnClickListener) r5;
        Intrinsics.checkNotNullParameter(r29, "$click");
        g.p(1, r28.getContext());
        r29.onClick(r11);
        return;
    L61:
        int r119 = OCarouselIndicator.J;
        p r30 = (p) r10;
        Intrinsics.checkNotNullParameter(r30, "$slot");
        OCarouselIndicator r31 = (OCarouselIndicator) r5;
        Intrinsics.checkNotNullParameter(r31, "this$0");
        s r120 = r30.f13502a;
        if ((r120 instanceof r) == true) goto L64;
        return;
    L64:
        if (r31.getDotsClickable() == false) goto L121;
        r r121 = (r) r120;
        if (r121.f13507a >= r31.g()) goto L122;
        l r122 = r31.getPager();
        if (r122 == null) goto L123;
        r122.c(r121.f13507a);
        return;
    L123:
        return;
    L122:
        return;
    L121:
        return;
    L72:
        int r123 = OMonthPickerView.f12217o;
        OMonthPickerView r32 = (OMonthPickerView) r10;
        Intrinsics.checkNotNullParameter(r32, "this$0");
        u r33 = (u) r5;
        Intrinsics.checkNotNullParameter(r33, "$this_apply");
        if (r32.f12220c != PickerSelectionMode.SINGLE) goto L78;
        Iterator r124 = r32.f12227n.iterator();
    L76:
        if (r124.hasNext() == false) goto L124;
        u r125 = (u) r124.next();
        r125.setChecked(Intrinsics.areEqual(r125, r33));
        goto L76
    L124:
        return;
    L78:
        r33.toggle();
        return;
    L80:
        int r126 = MiniAppWidgetCardViewBinder$ViewHolder.f11859i;
        com.obric.flow.cardlistpage.ui.viewbinder.f r34 = (com.obric.flow.cardlistpage.ui.viewbinder.f) r10;
        Intrinsics.checkNotNullParameter(r34, "this$0");
        MiniAppWidgetCardModel r35 = (MiniAppWidgetCardModel) r5;
        Intrinsics.checkNotNullParameter(r35, "$item");
        String r127 = r34.d.f20491a;
        String r128 = r35.getId();
        String r36 = r35.getInstanceId();
        String r37 = r35.getAppletId();
        String r38 = r35.getWidgetId();
        StringBuilder r129 = androidx.constraintlayout.motion.widget.a.y("click mini app widget hostId=", r127, " cardId=", r128, " instanceId=");
        androidx.constraintlayout.motion.widget.a.C(r129, r36, " appletId=", r37, " widgetId=");
        String r130 = androidx.room.jarjarred.org.antlr.runtime.a.w(r129, r38, "MiniAppWidgetCardViewBinder", "tag", "msg");
        org.koin.core.a r39 = su.a.f22013b;
        if (r39 == null) goto L100;
        ((b) r39.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(b.class), null)).i("MiniAppWidgetCardViewBinder", r130);
        Bundle r131 = new Bundle();
        r131.putString("appletId", r35.getAppletId());
        r131.putString(Constant.APPID, r35.getAppletId());
        r131.putString("appletPageId", "index");
        r131.putString("pageId", "index");
        r131.putString("pageType", OpenPageMethod.APP_FULL);
        r131.putString("widgetId", r35.getWidgetId());
        Integer r132 = StringsKt.toIntOrNull(r35.getInstanceId());
        if (r132 == null) goto L85;
        r131.putInt("widgetInstanceId", r132.intValue());
    L85:
        obric.flow.miniappwidget.l r133 = r34.d;
        String r40 = r133.f20491a;
        Intrinsics.checkNotNullParameter(r131, "args");
        String r41 = "openPage hostId=" + r40 + " args=" + r131;     // Catch: Throwable -> L89
        Intrinsics.checkNotNullParameter("MiniAppWidgetHost", "tag");     // Catch: Throwable -> L89
        Intrinsics.checkNotNullParameter(r41, "msg");     // Catch: Throwable -> L89
        org.koin.core.a r42 = su.a.f22013b;     // Catch: Throwable -> L89
        if (r42 == null) goto L92;
        ((b) r42.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(b.class), null)).i("MiniAppWidgetHost", r41);     // Catch: Throwable -> L89
        r133.f20501o.openPage(r131);     // Catch: Throwable -> L89
        return;
    L92:
        throw new IllegalStateException("KoinApplication has not been started");     // Catch: Throwable -> L89
    L89:
        th = move-exception;
        String r134 = "openPage failed hostId=" + r40;
        Intrinsics.checkNotNullParameter("MiniAppWidgetHost", "tag");
        Intrinsics.checkNotNullParameter(r134, "msg");
        Intrinsics.checkNotNullParameter(th, "t");
        org.koin.core.a r43 = su.a.f22013b;
        if (r43 == null) goto L98;
        ((b) r43.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(b.class), null)).e("MiniAppWidgetHost", r134, th);
        return;
    L98:
        throw new IllegalStateException("KoinApplication has not been started");
    L100:
        throw new IllegalStateException("KoinApplication has not been started");
    L101:
        Snackbar.a((Snackbar) r10, (View.OnClickListener) r5, r11);
    }
}
