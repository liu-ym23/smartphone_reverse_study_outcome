package com.obric.clockwidgets.ui;

import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.lynx.tasm.base.h;
import com.obric.clockwidgets.ClockWidgetConfigActivity;
import com.obric.clockwidgets.R$array;
import com.obric.clockwidgets.R$color;
import com.obric.clockwidgets.R$drawable;
import com.obric.clockwidgets.R$string;
import com.obric.clockwidgets.data.WidgetClockCity;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.text.OTextView;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/clockwidgets/ui/WidgetClockCityAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/obric/clockwidgets/ui/WidgetClockCityAdapter$WidgetClockCityHolder;", "WidgetClockCityHolder", "clockwidgets_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class WidgetClockCityAdapter extends RecyclerView.Adapter<WidgetClockCityHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ClockWidgetConfigActivity f11290a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f11291b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function2 f11292c;
    public final int d;
    public final int e;
    public final int f;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/obric/clockwidgets/ui/WidgetClockCityAdapter$WidgetClockCityHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "clockwidgets_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class WidgetClockCityHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final OCardListItem f11293a;

        public WidgetClockCityHolder(OCardListItem r5) {
            Intrinsics.checkNotNullParameter(r5, "cardContainer");
            super(r5);
            this.f11293a = r5;
        }
    }

    public WidgetClockCityAdapter(ClockWidgetConfigActivity r5, ArrayList r10, Function2 r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r10, "dataList");
        Intrinsics.checkNotNullParameter(r11, "onItemClick");
        this.f11290a = r5;
        this.f11291b = r10;
        this.f11292c = r11;
        this.d = 1;
        this.e = 2;
        this.f = 3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f11291b.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r10, int r11) {
        WidgetClockCityHolder r12 = (WidgetClockCityHolder) r10;
        Intrinsics.checkNotNullParameter(r12, "holder");
        ArrayList r5 = this.f11291b;
        WidgetClockCity r13 = (WidgetClockCity) r5.get(r11);
        OCardListItem r14 = r12.f11293a;
        if (r5.size() != 1) goto L5;
        int r15 = 0;
    L11:
        r14.setCardPosition(r15);
        String r16 = r13.f11257a;
        ClockWidgetConfigActivity r17 = this.f11290a;
        Intrinsics.checkNotNullParameter(r17, "context");
        int r18 = h.g(r17, r16);
        String r19 = null;
        if (r18 >= 0) goto L14;
    L13:
        String r20 = null;
    L18:
        if (r20 != null) goto L20;
        r20 = r13.f11258b;
    L20:
        Intrinsics.checkNotNullParameter(r17, "context");
        int r21 = h.g(r17, r13.f11257a);
        if (r21 < 0) goto L27;
        String[] r22 = r17.getResources().getStringArray(R$array.cities_country);
        if (r21 >= r22.length) goto L27;
        r19 = r22[r21];
    L27:
        if (r19 != null) goto L30;
        r19 = r13.f;
    L30:
        if (TextUtils.isEmpty(r19) == true) goto L33;
        r20 = r17.getString(R$string.clock_widget_city_name, new Object[]{r20, r19});
    L33:
        r14.setTitle(r20);
        r14.setOnContentClickListener(new b(this, r11, r13, 0));
        return;
    L14:
        String[] r23 = r17.getResources().getStringArray(R$array.cities_names);
        if (r18 >= r23.length) goto L13;
        r20 = r23[r18];
        goto L18
    L5:
        if (r11 != 0) goto L8;
        r15 = this.d;
        goto L11
    L8:
        if (r11 != (r5.size() - 1)) goto L10;
        r15 = this.f;
        goto L11
    L10:
        r15 = this.e;
        goto L11
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "parent");
        OCardListItem r11 = new OCardListItem(r5.getContext(), null, 6, 0);
        r11.setShowCardBg(false);
        OTextView r12 = r11.getTitleView();
        r12.setTextColor(this.f11290a.getColor(R$color.oui_accent_7_fg));
        r12.setTextSize(2, 16.0f);
        r11.setTailIcon(R$drawable.icon_drag);
        r11.l(true);
        return new WidgetClockCityHolder(r11);
    }
}
