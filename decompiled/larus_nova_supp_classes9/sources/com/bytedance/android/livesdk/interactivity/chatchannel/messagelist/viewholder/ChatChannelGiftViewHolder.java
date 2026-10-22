package com.bytedance.android.livesdk.interactivity.chatchannel.messagelist.viewholder;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.u;
import com.bytedance.android.livesdk.widget.roundcorner.RoundCornerImageView;
import i62.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/chatchannel/messagelist/viewholder/ChatChannelGiftViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "a", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ChatChannelGiftViewHolder extends RecyclerView.ViewHolder {
    public final RoundCornerImageView a;
    public final TextView b;
    public e c;
    public e d;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ ChatChannelGiftViewHolder a;

        public b(ChatChannelGiftViewHolder r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            if (wb2.e.a(r2) == true) goto L8;
            e r0 = this.a.c;
            if (r0 == null) goto L9;
            r0.onClick(r2);
            return;
        L9:
            return;
        }
    }

    static {
    }

    public ChatChannelGiftViewHolder(View r4) {
        Intrinsics.checkNotNullParameter(r4, "itemView");
        super(r4);
        LinearLayout r0 = (LinearLayout) r4.findViewById(2131367728);
        RoundCornerImageView r1 = r4.findViewById(2131363623);
        this.a = r1;
        TextView r5 = (TextView) r4.findViewById(2131367794);
        this.b = r5;
        b r2 = new b(this);
        r5.setMovementMethod(u.a());
        r5.setOnClickListener(r2);
        r1.setOnClickListener(r2);
    }
}
