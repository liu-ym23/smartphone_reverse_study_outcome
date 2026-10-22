package com.bytedance.android.livesdk.interactivity.chatchannel.messagelist.viewholder;

import ak6.g;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.u;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import wb2.d;
import wb2.e;
import wb2.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/chatchannel/messagelist/viewholder/ChatChannelTipViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "a", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ChatChannelTipViewHolder extends RecyclerView.ViewHolder {
    public static final /* synthetic */ int d = 0;
    public final TextView a;
    public View.OnClickListener b;
    public d.a c;

    public static final class a {
        @JvmStatic
        public static ChatChannelTipViewHolder a(LayoutInflater r3, ViewGroup r4) {
            Intrinsics.checkNotNullParameter(r3, "inflater");
            Intrinsics.checkNotNullParameter(r4, "parent");
            return new ChatChannelTipViewHolder(r3.inflate(2131566242, r4, false));
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ ChatChannelTipViewHolder a;

        public b(ChatChannelTipViewHolder r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            if (e.a(r2) == true) goto L8;
            View.OnClickListener r0 = this.a.b;
            if (r0 == null) goto L9;
            r0.onClick(r2);
            return;
        L9:
            return;
        }
    }

    public static final class c implements qb2.e {
        public final /* synthetic */ ChatChannelTipViewHolder a;

        public c(ChatChannelTipViewHolder r1) {
            this.a = r1;
        }

        @Override // qb2.e
        public final void a(g r2) {
            Intrinsics.checkNotNullParameter(r2, "rendResult");
            Intrinsics.checkNotNullParameter(r2, "rendResult");
        }

        @Override // qb2.e
        public final void b(g r7) {
            Intrinsics.checkNotNullParameter(r7, "rendResult");
            TextView r0 = this.a.a;
            if (r0 == null) goto L10;
            SpannableString r8 = r7.a;
            int r3 = 0;
            Object[] r1 = r8.getSpans(0, r8.length(), h.class);
            int r2 = r1.length;
        L5:
            if (r3 >= r2) goto L7;
            h r4 = (h) r1[r3];
            r4.a = this.a.c;
            r3 = r3 + 1;
            goto L5
        L7:
            Unit r5 = Unit.INSTANCE;
            r0.setText(r8);
            return;
        }
    }

    static {
    }

    public ChatChannelTipViewHolder(View r4) {
        Intrinsics.checkNotNullParameter(r4, "itemView");
        super(r4);
        TextView r5 = (TextView) r4.findViewById(2131367794);
        this.a = r5;
        b r0 = new b(this);
        if (r5 == null) goto L5;
        r5.setMovementMethod(u.a());
    L5:
        if (r5 == null) goto L8;
        r5.setOnClickListener(r0);
    L8:
        if (o62.d.a.booleanValue() == false) goto L12;
        if (r5 == null) goto L13;
        r5.setShadowLayer(o62.d.c, 0.0f, 0.0f, o62.d.b);
        return;
    L13:
        return;
    }

    public final void T3(tb2.d r4) {
        Intrinsics.checkNotNullParameter(r4, "renderText");
        qb2.c.b(r4, new c(this), null, 28);
    }
}
