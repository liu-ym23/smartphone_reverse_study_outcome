package com.bytedance.android.livesdk.interactivity.chatchannel.widget.invite.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.utils.q4;
import com.bytedance.android.livesdk.utils.u4;
import com.bytedance.android.livesdk.widget.roundcorner.RoundCornerImageView;
import com.bytedance.android.uicomponent.compoundbutton.TranslucentCheckBox;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class InviteeUserRecommendItemViewBinder extends me.drakeet.multitype.b<a, ItemViewHolder> {

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/chatchannel/widget/invite/adapter/InviteeUserRecommendItemViewBinder$ItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ItemViewHolder extends RecyclerView.ViewHolder {
        public final RoundCornerImageView a;
        public final TextView b;
        public final TextView c;
        public final TextView d;
        public final TranslucentCheckBox e;
        public a f;
        public q4.b g;

        public static final class a implements View.OnClickListener {
            public final /* synthetic */ ItemViewHolder a;

            public a(ItemViewHolder r1) {
                this.a = r1;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r3) {
                ItemViewHolder r4 = this.a;
                a r0 = r4.f;
                if (r0 != null) goto L5;
                return;
            L5:
                if (r0.d != true) goto L9;
                TranslucentCheckBox r5 = r4.e;
                r5.setChecked(!r5.isChecked());
                return;
            }
        }

        public static final class b implements CompoundButton.OnCheckedChangeListener {
            public final /* synthetic */ ItemViewHolder a;

            public b(ItemViewHolder r1) {
                this.a = r1;
            }

            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton r2, boolean r3) {
                a r4 = this.a.f;
                if (r4 == null) goto L8;
                r4.b = r3;
                com.bytedance.android.livesdk.interactivity.chatchannel.widget.invite.adapter.c r0 = r4.c;
                if (r0 == null) goto L9;
                r0.bl(r4, r3);
                return;
            L9:
                return;
            }
        }

        public static final class c implements View.OnClickListener {
            public final /* synthetic */ ItemViewHolder a;

            public c(ItemViewHolder r1) {
                this.a = r1;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r3) {
                ItemViewHolder r4 = this.a;
                a r0 = r4.f;
                if (r0 == null) goto L5;
                r0.d = true;
            L5:
                r4.e.setChecked(true);
                ItemViewHolder r5 = this.a;
                TextView r1 = r5.c;
                r1.setPivotX(r1.getWidth());
                q4.b r2 = u4.c(new InviteeUserRecommendItemViewBinder$ItemViewHolder$runFollowAnimation$1(r5));
                r5.g = r2;
                r2.c();
            }
        }

        public ItemViewHolder(View r4) {
            Intrinsics.checkNotNullParameter(r4, "itemView");
            super(r4);
            this.a = r4.findViewById(2131367709);
            this.b = (TextView) r4.findViewById(2131367719);
            TextView r0 = (TextView) r4.findViewById(2131367715);
            this.c = r0;
            this.d = (TextView) r4.findViewById(2131383956);
            TranslucentCheckBox r1 = r4.findViewById(2131367712);
            this.e = r1;
            r4.setOnClickListener(new a(this));
            r1.setOnCheckedChangeListener(new b(this));
            r0.setOnClickListener(new c(this));
            r3.c(r0, "关注", true);
        }
    }

    public static final class a extends b {
        public boolean d;
        public boolean e;

        public a() {
            throw null;
        }
    }

    public InviteeUserRecommendItemViewBinder() {
    }

    public final void e(RecyclerView.ViewHolder r3) {
        ItemViewHolder r4 = (ItemViewHolder) r3;
        Intrinsics.checkNotNullParameter(r4, "holder");
        a r5 = r4.f;
        if (r5 != null) goto L5;
        return;
    L5:
        if ((!r5.e) == true) goto L8;
        r5 = null;
    L8:
        if (r5 == null) goto L12;
        r5.e = true;
        return;
    }

    public final void b(RecyclerView.ViewHolder r4, Object r5) {
        final ItemViewHolder r6 = (ItemViewHolder) r4;
        final a r7 = (a) r5;
        Intrinsics.checkNotNullParameter(r6, "holder");
        Intrinsics.checkNotNullParameter(r7, "item");
        r6.getClass();
        Intrinsics.checkNotNullParameter(r7, "item");
        q4.b r0 = r6.g;
        if (r0 != null) goto L5;
    L10:
        r6.g = null;
        r6.f = r7;
        RoundCornerImageView r1 = r6.a;
        r7.a.getClass();
        ImageLoader.bindImage(r1, null);
        TextView r2 = r6.b;
        r7.a.getClass();
        r2.setText(null);
        TextView r3 = r6.d;
        r7.a.getClass();
        r3.setText(null);
        r6.e.setChecked(r7.b);
        if (r7.d == false) goto L13;
        r6.c.setVisibility(8);
        r6.e.setVisibility(0);
    L14:
        r3.e(((RecyclerView.ViewHolder) r6).itemView, new InviteeUserRecommendItemViewBinder$ItemViewHolder$bindItem$2(r6, r7));
        return;
    L13:
        r6.c.setVisibility(0);
        r6.e.setVisibility(8);
        goto L14
    L5:
        if (r0.b() == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L10;
        r0.a();
        goto L10
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        Intrinsics.checkNotNullParameter(r4, "parent");
        return new ItemViewHolder(r3.inflate(2131566304, r4, false));
    }
}
