package com.bytedance.android.livesdk.interactivity.chatchannel.widget.adapter.viewbinder;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.r3;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.multitype.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class ChannelMemberSubTitleViewBinder extends b<a, TitleViewHolder> {

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/chatchannel/widget/adapter/viewbinder/ChannelMemberSubTitleViewBinder$TitleViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class TitleViewHolder extends RecyclerView.ViewHolder {
        public final TextView a;

        public TitleViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
            this.a = (TextView) r2.findViewById(2131387559);
        }
    }

    public static final class a {
        public final String a;

        public final boolean equals(Object r2) {
            if (this != r2) goto L4;
            return true;
        L4:
            if ((r2 instanceof a) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.a, ((a) r2).a) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            String r0 = this.a;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.hashCode();
        }

        public final String toString() {
            return "SubTitle(title=" + this.a + ")";
        }

        public a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "title");
            this.a = r2;
        }
    }

    public ChannelMemberSubTitleViewBinder() {
    }

    public final void b(RecyclerView.ViewHolder r3, Object r4) {
        TitleViewHolder r5 = (TitleViewHolder) r3;
        a r6 = (a) r4;
        Intrinsics.checkNotNullParameter(r5, "holder");
        Intrinsics.checkNotNullParameter(r6, "item");
        r5.getClass();
        Intrinsics.checkNotNullParameter(r6, "title");
        r5.a.setText(r6.a);
        r3.a(r5.a, r6.a);
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        Intrinsics.checkNotNullParameter(r4, "parent");
        return new TitleViewHolder(r3.inflate(2131566391, r4, false));
    }

    public final void c(RecyclerView.ViewHolder r5, Object r6, List r7) {
        TitleViewHolder r8 = (TitleViewHolder) r5;
        a r9 = (a) r6;
        Intrinsics.checkNotNullParameter(r8, "holder");
        Intrinsics.checkNotNullParameter(r9, "item");
        Intrinsics.checkNotNullParameter(r7, "payloads");
        if (r7.size() != 0) goto L5;
        Intrinsics.checkNotNullParameter(r8, "holder");
        Intrinsics.checkNotNullParameter(r9, "item");
        r8.getClass();
        Intrinsics.checkNotNullParameter(r9, "title");
        r8.a.setText(r9.a);
        r3.a(r8.a, r9.a);
        return;
    L5:
        Object r10 = ListProtector.get(r7, r7.size() - 1);
        if (r10 == null) goto L21;
        Iterator<String> r11 = ((Bundle) r10).keySet().iterator();
    L9:
        if (r11.hasNext() == false) goto L31;
        String r0 = r11.next();
        if (r0 == null) goto L9;
        if (r0.hashCode() != (-2047941432)) goto L9;
        if (r0.equals("payload_key_sub_title") == false) goto L9;
        r8.getClass();
        Intrinsics.checkNotNullParameter(r9, "title");
        r8.a.setText(r9.a);
        r3.a(r8.a, r9.a);
        goto L9
    L31:
        return;
    L21:
        throw new NullPointerException("null cannot be cast to non-null type android.os.Bundle");
    }
}
