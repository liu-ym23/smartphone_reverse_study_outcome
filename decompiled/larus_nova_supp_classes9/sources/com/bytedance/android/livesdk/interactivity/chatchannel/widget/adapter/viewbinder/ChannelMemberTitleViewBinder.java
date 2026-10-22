package com.bytedance.android.livesdk.interactivity.chatchannel.widget.adapter.viewbinder;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.interactivity.chatchannel.widget.ChannelMemberManagerDialog;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class ChannelMemberTitleViewBinder extends me.drakeet.multitype.b<b, ItemViewHolder> {
    public final a b;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/chatchannel/widget/adapter/viewbinder/ChannelMemberTitleViewBinder$ItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ItemViewHolder extends RecyclerView.ViewHolder {
        public b a;
        public final TextView b;
        public final TextView c;
        public final LinearLayout d;
        public final ImageView e;
        public final TextView f;
        public final LinearLayout g;
        public final ImageView h;
        public final TextView i;

        public final void T3(b r8) {
            Intrinsics.checkNotNullParameter(r8, "item");
            this.a = r8;
            this.b.setText(r8.a);
            r3.a(this.b, r8.a);
            r3.a(this.d, s1.B(2131915752));
            r3.a(this.d, s1.B(2131915742));
            r3.a(this.g, s1.B(2131915731));
            if (r8.f == false) goto L5;
            UtilityKotlinExtentionsKt.w(this.g);
        L6:
            long r0 = r8.b;
            long r2 = r8.c;
            b r4 = this.a;
            if (r4 != null) goto L9;
            Intrinsics.throwUninitializedPropertyAccessException("data");
        L9:
            r4.b = r0;
            b r5 = this.a;
            if (r5 != null) goto L12;
            Intrinsics.throwUninitializedPropertyAccessException("data");
        L12:
            r5.c = r2;
            b r6 = this.a;
            if (r6 != null) goto L16;
            Intrinsics.throwUninitializedPropertyAccessException("data");
        L16:
            if (r6.f == false) goto L18;
            String r1 = s1.C(2131922268, new Object[]{String.valueOf(r0), String.valueOf(r2)});
        L19:
            this.c.setText(r1);
            r3.a(this.c, r1);
            if (r8.d == false) goto L22;
            this.e.setAlpha(1.0f);
            this.f.setTextColor(s1.h(2131107010));
        L24:
            if (r8.e == false) goto L26;
            this.h.setAlpha(1.0f);
            this.i.setTextColor(s1.h(2131107010));
            return;
        L26:
            this.h.setAlpha(0.3f);
            this.i.setTextColor(s1.h(2131107020));
            return;
        L22:
            this.e.setAlpha(0.3f);
            this.f.setTextColor(s1.h(2131107020));
            goto L24
        L18:
            r1 = s1.C(2131922267, new Object[]{String.valueOf(r0)});
            goto L19
        L5:
            UtilityKotlinExtentionsKt.t(this.g);
            goto L6
        }

        public ItemViewHolder(View r5, final a r6) {
            Intrinsics.checkNotNullParameter(r5, "itemView");
            Intrinsics.checkNotNullParameter(r6, "clickListener");
            super(r5);
            this.b = (TextView) r5.findViewById(2131388924);
            this.c = (TextView) r5.findViewById(2131368026);
            LinearLayout r0 = (LinearLayout) r5.findViewById(2131386016);
            this.d = r0;
            LinearLayout r1 = (LinearLayout) r5.findViewById(2131375619);
            this.e = (ImageView) r5.findViewById(2131376329);
            this.f = (TextView) r5.findViewById(2131390818);
            LinearLayout r2 = (LinearLayout) r5.findViewById(2131381031);
            this.g = r2;
            this.h = (ImageView) r5.findViewById(2131376447);
            this.i = (TextView) r5.findViewById(2131391016);
            r0.setOnClickListener(x0.a(new AnonymousClass1(r6)));
            r1.setOnClickListener(x0.a(new AnonymousClass2(r6)));
            r2.setOnClickListener(x0.a(new AnonymousClass3(r6)));
        }
    }

    public interface a {
        void a();

        void b();

        void c();
    }

    public static final class b {
        public final String a;
        public long b;
        public long c;
        public final boolean d;
        public final boolean e;
        public final boolean f;

        public b(String r2, long r3, long r5, boolean r7, boolean r8, boolean r9) {
            Intrinsics.checkNotNullParameter(r2, "channelName");
            this.a = r2;
            this.b = r3;
            this.c = r5;
            this.d = r7;
            this.e = r8;
            this.f = r9;
        }
    }

    public ChannelMemberTitleViewBinder(ChannelMemberManagerDialog.e r2) {
        Intrinsics.checkNotNullParameter(r2, "clickListener");
        this.b = r2;
    }

    public final void b(RecyclerView.ViewHolder r2, Object r3) {
        ItemViewHolder r4 = (ItemViewHolder) r2;
        b r5 = (b) r3;
        Intrinsics.checkNotNullParameter(r4, "holder");
        Intrinsics.checkNotNullParameter(r5, "item");
        r4.T3(r5);
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        Intrinsics.checkNotNullParameter(r4, "parent");
        return new ItemViewHolder(r3.inflate(2131566392, r4, false), this.b);
    }

    public final void c(RecyclerView.ViewHolder r4, Object r5, List r6) {
        ItemViewHolder r7 = (ItemViewHolder) r4;
        b r8 = (b) r5;
        Intrinsics.checkNotNullParameter(r7, "holder");
        Intrinsics.checkNotNullParameter(r8, "item");
        Intrinsics.checkNotNullParameter(r6, "payloads");
        if (r6.size() != 0) goto L5;
        Intrinsics.checkNotNullParameter(r7, "holder");
        Intrinsics.checkNotNullParameter(r8, "item");
        r7.T3(r8);
        return;
    L5:
        Object r9 = ListProtector.get(r6, r6.size() - 1);
        if (r9 == null) goto L21;
        Iterator<String> r10 = ((Bundle) r9).keySet().iterator();
    L9:
        if (r10.hasNext() == false) goto L31;
        String r0 = r10.next();
        if (r0 == null) goto L9;
        if (r0.hashCode() != 278336971) goto L9;
        if (r0.equals("payload_key_channel_title") == false) goto L9;
        r7.T3(r8);
        goto L9
    L31:
        return;
    L21:
        throw new NullPointerException("null cannot be cast to non-null type android.os.Bundle");
    }
}
