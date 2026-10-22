package com.larus.bmhome.view.actionbar.gaokao.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.view.actionbar.gaokao.a;
import com.larus.bmhome.view.actionbar.gaokao.model.GaokaoProvince;
import com.larus.common.apphost.AppHost;
import ct8.b;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001eB?\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005J\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\tJ\u0018\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0014H\u0016J\u0018\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u0014H\u0016J\b\u0010\u001d\u001a\u00020\u0014H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/larus/bmhome/view/actionbar/gaokao/adapter/GaokaoProvinceAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/larus/bmhome/view/actionbar/gaokao/adapter/GaokaoProvinceAdapter$GaokaoProvinceViewHolder;", "dataList", "", "Lcom/larus/bmhome/view/actionbar/gaokao/model/GaokaoProvince;", "currentProvinceKey", "", "noDefaultProvinceProvided", "", "selectCallback", "Lkotlin/Function1;", "", "<init>", "(Ljava/util/List;Ljava/lang/String;ZLkotlin/jvm/functions/Function1;)V", "defaultCityKey", "currentSelectedViewHolder", "currentProvince", "getCurrentProvince", "getCurrentSelectedPosition", "", "isLatestOneSelected", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "getItemCount", "GaokaoProvinceViewHolder", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GaokaoProvinceAdapter extends RecyclerView.Adapter<GaokaoProvinceViewHolder> {
    public final List<GaokaoProvince> a;
    public String b;
    public final boolean c;
    public final Function1<GaokaoProvince, Unit> d;
    public final String e;
    public GaokaoProvinceViewHolder f;
    public GaokaoProvince g;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\r\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/larus/bmhome/view/actionbar/gaokao/adapter/GaokaoProvinceAdapter$GaokaoProvinceViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "rootView", "getRootView", "()Landroid/view/View;", "textView", "Landroid/widget/TextView;", "getTextView", "()Landroid/widget/TextView;", "textViewPostfix", "getTextViewPostfix", "selectedView", "getSelectedView", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class GaokaoProvinceViewHolder extends RecyclerView.ViewHolder {
        public final View a;
        public final TextView b;
        public final TextView c;
        public final View d;

        public GaokaoProvinceViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
            this.a = r2.findViewById(2131375835);
            this.b = (TextView) r2.findViewById(2131375863);
            this.c = (TextView) r2.findViewById(2131375866);
            this.d = r2.findViewById(2131375840);
        }
    }

    public final int getItemCount() {
        return this.a.size();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r6, int r7) {
        final GaokaoProvinceViewHolder r8 = (GaokaoProvinceViewHolder) r6;
        Intrinsics.checkNotNullParameter(r8, "holder");
        final GaokaoProvince r9 = (GaokaoProvince) ListProtector.get(this.a, r7);
        View r0 = r8.d;
        int r1 = 4;
        if (r0 != null) goto L5;
    L9:
        TextView r2 = r8.c;
        if (r2 != null) goto L12;
    L20:
        TextView r3 = r8.b;
        if (r3 == null) goto L23;
        r3.setText(r9.getProvince());
    L23:
        View r4 = r8.a;
        if (r4 == null) goto L27;
        r4.setOnClickListener(new b(r9, this, r8));
        return;
    L27:
        return;
    L12:
        if (Intrinsics.areEqual(r9.getKey(), this.e) == true) goto L14;
    L19:
        r2.setVisibility(r1);
        goto L20
    L14:
        if (this.c == true) goto L19;
        String r5 = "（" + AppHost.a.getApplication().getString(2131898444) + 65289;
        TextView r10 = r8.c;
        if (r10 == null) goto L18;
        r10.setText(r5);
    L18:
        r1 = 0;
        goto L19
    L5:
        if (Intrinsics.areEqual(r9.getKey(), this.b) == false) goto L7;
        this.f = r8;
        int r11 = 0;
    L8:
        r0.setVisibility(r11);
        goto L9
    L7:
        r11 = 4;
        goto L8
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        View r5 = LayoutInflater.from(r3.getContext()).inflate(2131562574, r3, false);
        Intrinsics.checkNotNull(r5);
        return new GaokaoProvinceViewHolder(r5);
    }

    public GaokaoProvinceAdapter(List r2, String r3, boolean r4, a r5) {
        Intrinsics.checkNotNullParameter(r2, "dataList");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r3;
        Iterator r6 = r2.iterator();
    L4:
        if (r6.hasNext() == false) goto L8;
        Object r7 = r6.next();
        if (Intrinsics.areEqual(((GaokaoProvince) r7).getKey(), this.b) == false) goto L4;
    L9:
        this.g = (GaokaoProvince) r7;
        return;
    L8:
        r7 = null;
        goto L9
    }
}
