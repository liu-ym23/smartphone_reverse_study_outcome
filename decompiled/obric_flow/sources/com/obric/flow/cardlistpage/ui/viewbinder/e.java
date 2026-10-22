package com.obric.flow.cardlistpage.ui.viewbinder;

import android.appwidget.AppWidgetProviderInfo;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.lynx.tasm.utils.k;
import com.obric.flow.cardlistpage.data.MiniAppWidgetCardModel;
import com.obric.flow.cardlistpage.data.WidgetCardModel;
import com.obric.flow.cardlistpage.ui.view.WidgetBox;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class e implements View.OnLongClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11871a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ um.a f11872b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ RecyclerView.ViewHolder f11873c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ Object e;
    public final /* synthetic */ Object f;

    public /* synthetic */ e(um.a r5, RecyclerView.ViewHolder r10, Object r11, Object r12, Object r13, int r14) {
        this.f11871a = r14;
        this.f11872b = r5;
        this.f11873c = r10;
        this.d = r11;
        this.e = r12;
        this.f = r13;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r11) {
        Object r5 = this.f;
        Object r10 = this.e;
        Object r12 = this.d;
        RecyclerView.ViewHolder r13 = this.f11873c;
        um.a r14 = this.f11872b;
        switch(this.f11871a) {
            case 0: goto L11;
            default: goto L4;
        };
    L4:
        int r15 = WidgetCardViewBinder$ViewHolder.f11866c;
        h r16 = (h) r14;
        Intrinsics.checkNotNullParameter(r16, "this$0");
        WidgetCardViewBinder$ViewHolder r17 = (WidgetCardViewBinder$ViewHolder) r13;
        Intrinsics.checkNotNullParameter(r17, "this$1");
        WidgetCardModel r18 = (WidgetCardModel) r12;
        Intrinsics.checkNotNullParameter(r18, "$item");
        eq.b r19 = k.r();
        JSONObject r20 = new JSONObject();
        r20.put("widget_name", r18.getTitle());
        Unit r21 = Unit.INSTANCE;
        r19.a("long_click_widget", r20);
        r16.f11877h.invoke(r17);
        View r110 = r17.itemView;
        if ((r110 instanceof WidgetBox) == false) goto L7;
        WidgetBox r111 = (WidgetBox) r110;
    L8:
        if (r111 == null) goto L10;
        AppWidgetProviderInfo r22 = (AppWidgetProviderInfo) r5;
        Intrinsics.checkNotNull(r22);
        ((Function3) r10).invoke(r111, r18, r22);
    L10:
        return true;
    L7:
        r111 = null;
        goto L8
    L11:
        int r112 = MiniAppWidgetCardViewBinder$ViewHolder.f11859i;
        f r23 = (f) r14;
        Intrinsics.checkNotNullParameter(r23, "this$0");
        MiniAppWidgetCardViewBinder$ViewHolder r24 = (MiniAppWidgetCardViewBinder$ViewHolder) r13;
        Intrinsics.checkNotNullParameter(r24, "this$1");
        WidgetBox r25 = (WidgetBox) r10;
        Intrinsics.checkNotNullParameter(r25, "$widgetBox");
        MiniAppWidgetCardModel r26 = (MiniAppWidgetCardModel) r5;
        Intrinsics.checkNotNullParameter(r26, "$item");
        eq.b r113 = k.r();
        JSONObject r27 = new JSONObject();
        r27.put("widget_name", r26.getTitle());
        Unit r28 = Unit.INSTANCE;
        r113.a("long_click_widget", r27);
        r23.g.invoke(r24);
        ((Function2) r12).mo2invoke(r25, r26);
        return true;
    }
}
