package com.bytedance.android.live.liveinteract.linkpanel.viewbinder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class TalkRoomSearchFootViewBinder extends me.drakeet.multitype.b<b, FootViewHolder> {

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/liveinteract/linkpanel/viewbinder/TalkRoomSearchFootViewBinder$FootViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class FootViewHolder extends RecyclerView.ViewHolder {
        public final TextView a;

        public FootViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
            this.a = (TextView) r2.findViewById(2131391594);
        }
    }

    public static final class a {
    }

    public static final class b {
        public final int a;

        public final boolean equals(Object r2) {
            if (this != r2) goto L4;
            return true;
        L4:
            if ((r2 instanceof b) == true) goto L6;
            return false;
        L6:
            if (this.a == ((b) r2).a) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            return this.a;
        }

        public final String toString() {
            return "FootViewBinderData(type=" + this.a + ")";
        }

        public final int getType() {
            return this.a;
        }

        public b(int r1) {
            this.a = r1;
        }
    }

    static {
    }

    public TalkRoomSearchFootViewBinder() {
    }

    public final void b(RecyclerView.ViewHolder r2, Object r3) {
        FootViewHolder r4 = (FootViewHolder) r2;
        b r5 = (b) r3;
        Intrinsics.checkNotNullParameter(r4, "holder");
        Intrinsics.checkNotNullParameter(r5, "item");
        int r6 = r5.getType();
        if (r6 != 0) goto L6;
        r4.a.setText(2131918763);
        return;
    L6:
        if (r6 != 1) goto L8;
        r4.a.setText(2131918767);
        return;
    L8:
        r4.getClass();
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        Intrinsics.checkNotNullParameter(r5, "parent");
        return new FootViewHolder(r4.inflate(2131566417, r5, false));
    }
}
