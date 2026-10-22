package com.bytedance.android.live.revlink.impl.multianchor.dialog.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/dialog/viewholder/AnchorLinkExpandViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "b", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class AnchorLinkExpandViewHolder extends RecyclerView.ViewHolder {
    public final TextView a;
    public final ImageView b;
    public boolean c;
    public final b d;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ AnchorLinkExpandViewHolder a;
        public final /* synthetic */ boolean b;

        public a(AnchorLinkExpandViewHolder r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            if (this.b == false) goto L5;
            AnchorLinkExpandViewHolder r3 = this.a;
            r3.c = !r3.c;
        L5:
            AnchorLinkExpandViewHolder r4 = this.a;
            r4.d.P40(r4.c);
        }
    }

    public interface b {
        void P40(boolean r1);
    }

    public AnchorLinkExpandViewHolder(View r2, b r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        Intrinsics.checkNotNullParameter(r3, "listener");
        super(r2);
        this.d = r3;
        this.a = (TextView) r2.findViewById(2131390581);
        this.b = (ImageView) r2.findViewById(2131376221);
        r2.setOnClickListener(new a(this, r4));
    }
}
