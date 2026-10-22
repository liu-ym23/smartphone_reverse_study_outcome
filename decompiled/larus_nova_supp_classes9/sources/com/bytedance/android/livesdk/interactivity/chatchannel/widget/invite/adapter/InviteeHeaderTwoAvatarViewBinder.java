package com.bytedance.android.livesdk.interactivity.chatchannel.widget.invite.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.livesdk.widget.TransparentCircleIconView;
import com.bytedance.android.livesdk.widget.roundcorner.RoundCornerImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class InviteeHeaderTwoAvatarViewBinder extends me.drakeet.multitype.b<a, ItemViewHolder> {

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/chatchannel/widget/invite/adapter/InviteeHeaderTwoAvatarViewBinder$ItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ItemViewHolder extends RecyclerView.ViewHolder {
        public final RoundCornerImageView a;
        public final TransparentCircleIconView b;

        public ItemViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
            this.a = r2.findViewById(2131385869);
            this.b = r2.findViewById(2131384539);
        }
    }

    public static final class a {
        public final ImageModel a;
        public final ImageModel b;

        public a(ImageModel r2, ImageModel r3) {
            Intrinsics.checkNotNullParameter(r2, "selfAvatar");
            Intrinsics.checkNotNullParameter(r3, "rightAvatar");
            this.a = r2;
            this.b = r3;
        }
    }

    public InviteeHeaderTwoAvatarViewBinder() {
    }

    public final void b(RecyclerView.ViewHolder r3, Object r4) {
        ItemViewHolder r5 = (ItemViewHolder) r3;
        a r6 = (a) r4;
        Intrinsics.checkNotNullParameter(r5, "holder");
        Intrinsics.checkNotNullParameter(r6, "item");
        r5.getClass();
        Intrinsics.checkNotNullParameter(r6, "item");
        ImageLoader.bindImage(r5.a, r6.a);
        ImageLoader.bindImage(r5.b, r6.b);
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        Intrinsics.checkNotNullParameter(r4, "parent");
        return new ItemViewHolder(r3.inflate(2131566300, r4, false));
    }
}
