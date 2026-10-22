package com.bytedance.android.livesdk.interactivity.chatchannel.widget.invite.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.livesdk.widget.roundcorner.RoundCornerImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class InviteeHeaderOneAvatarViewBinder extends me.drakeet.multitype.b<a, ItemViewHolder> {

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/chatchannel/widget/invite/adapter/InviteeHeaderOneAvatarViewBinder$ItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ItemViewHolder extends RecyclerView.ViewHolder {
        public final RoundCornerImageView a;

        public ItemViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
            this.a = r2.findViewById(2131385867);
        }
    }

    public static final class a {
        public final ImageModel a;

        public a(ImageModel r2) {
            Intrinsics.checkNotNullParameter(r2, "selfAvatar");
            this.a = r2;
        }
    }

    public InviteeHeaderOneAvatarViewBinder() {
    }

    public final void b(RecyclerView.ViewHolder r2, Object r3) {
        ItemViewHolder r4 = (ItemViewHolder) r2;
        a r5 = (a) r3;
        Intrinsics.checkNotNullParameter(r4, "holder");
        Intrinsics.checkNotNullParameter(r5, "item");
        r4.getClass();
        Intrinsics.checkNotNullParameter(r5, "item");
        ImageLoader.bindImage(r4.a, r5.a);
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        Intrinsics.checkNotNullParameter(r4, "parent");
        return new ItemViewHolder(r3.inflate(2131566298, r4, false));
    }
}
