package com.bytedance.android.live.revlink.impl.pk.flexactivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class FlexActivityTitleViewBinder extends me.drakeet.multitype.b<a, FlexTitleViewHolder> {

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/flexactivity/FlexActivityTitleViewBinder$FlexTitleViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class FlexTitleViewHolder extends RecyclerView.ViewHolder {
        public final View a;

        public FlexTitleViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
            this.a = r2;
        }
    }

    public static final class a {
        public String a;
        public String b;

        public a() {
            this.b = "";
        }
    }

    public FlexActivityTitleViewBinder() {
    }

    public final void b(RecyclerView.ViewHolder r5, Object r6) {
        FlexTitleViewHolder r7 = (FlexTitleViewHolder) r5;
        a r8 = (a) r6;
        Intrinsics.checkNotNullParameter(r7, "holder");
        Intrinsics.checkNotNullParameter(r8, "item");
        r7.getClass();
        Intrinsics.checkNotNullParameter(r8, "itemData");
        boolean r2 = false;
        ((TextView) r7.a.findViewById(2131388772)).setVisibility(0);
        ((TextView) r7.a.findViewById(2131388772)).setText(r8.a);
        String r9 = r8.b;
        if (r9 != null) goto L5;
        return;
    L5:
        if (r9.length() <= 0) goto L7;
        r2 = true;
    L7:
        if (r2 == true) goto L10;
        r9 = null;
    L10:
        if (r9 == null) goto L14;
        ((TextView) r7.a.findViewById(2131388772)).setTextColor(ColorProtector.parseColor(r9));
        return;
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        Intrinsics.checkNotNullParameter(r5, "parent");
        return new FlexTitleViewHolder(r4.inflate(2131566264, r5, false));
    }
}
