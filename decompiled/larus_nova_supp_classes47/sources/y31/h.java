package y31;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.revlink.impl.pk.dialog.viewholder.PKBanViewHolder;
import com.bytedance.android.live.schema.api.WebcastRedirectException;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.link.model.u0;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import java.text.SimpleDateFormat;
import java.util.Date;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h extends me.drakeet.multitype.b<a, PKBanViewHolder> {
    public final int b;
    public final x31.s c;

    public static final class a {
        public u0 a;

        public a() {
        }
    }

    public final void g(RecyclerView.ViewHolder r2) {
        PKBanViewHolder r3 = (PKBanViewHolder) r2;
        Intrinsics.checkNotNullParameter(r3, "holder");
        r3.getClass();
    }

    public h(int r2, x31.s r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        this.b = r2;
        this.c = r3;
    }

    public final void b(RecyclerView.ViewHolder r12, Object r13) {
        PKBanViewHolder r14 = (PKBanViewHolder) r12;
        a r15 = (a) r13;
        Intrinsics.checkNotNullParameter(r14, "holder");
        Intrinsics.checkNotNullParameter(r15, "item");
        int r0 = this.b;
        r14.getClass();
        if (r15 == null) goto L33;
        u0 r1 = r15.a;
        if (r1 != null) goto L8;
        return;
    L8:
        if (r1.getAvatarThumb() == null) goto L10;
        a1.x((ImageView) ((RecyclerView.ViewHolder) r14).itemView.findViewById(2131374267), r1.getAvatarThumb(), ((RecyclerView.ViewHolder) r14).itemView.findViewById(2131374267).getWidth(), ((RecyclerView.ViewHolder) r14).itemView.findViewById(2131374267).getHeight(), 2131250965);
    L11:
        TextView r2 = (TextView) ((RecyclerView.ViewHolder) r14).itemView.findViewById(2131390993);
        u0 r16 = r15.a;
        if (r16 == null) goto L16;
        String r17 = r16.getNickName();
        if (r17 == null) goto L16;
    L17:
        r2.setText(r17);
        if (r0 != 2) goto L20;
        r1.getAutoRemoveTime();
        TextView r3 = (TextView) ((RecyclerView.ViewHolder) r14).itemView.findViewById(2131391115);
        long r5 = r1.getAutoRemoveTime() * ((long) WebcastRedirectException.UNKNOWN);
        r3.setText(new SimpleDateFormat("MM月dd日 HH:mm自动移出").format(new Date(r5)));
        ((TextView) ((RecyclerView.ViewHolder) r14).itemView.findViewById(2131391115)).setVisibility(0);
    L21:
        int r4 = r1.getGender();
        if (r4 == 1) goto L26;
        if (r4 == 2) goto L25;
        ((RecyclerView.ViewHolder) r14).itemView.findViewById(2131373623).setVisibility(8);
    L28:
        if (r1.getRivalLivingRoomId() == 0) goto L30;
        ((ImageView) ((RecyclerView.ViewHolder) r14).itemView.findViewById(2131365723)).setVisibility(0);
        ((RecyclerView.ViewHolder) r14).itemView.findViewById(2131378545).setVisibility(0);
        AbstractDraweeController r18 = Fresco.newDraweeControllerBuilder().setUri("https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/ttlive_item_rank_top_on_going_hd.webp").setAutoPlayAnimations(true).build();
        ((RecyclerView.ViewHolder) r14).itemView.findViewById(2131378545).setController(r18);
    L31:
        ((TextView) ((RecyclerView.ViewHolder) r14).itemView.findViewById(2131391282)).setOnClickListener(new com.bytedance.android.live.revlink.impl.pk.dialog.viewholder.h(r14, r1));
        return;
    L30:
        ((ImageView) ((RecyclerView.ViewHolder) r14).itemView.findViewById(2131365723)).setVisibility(8);
        ((RecyclerView.ViewHolder) r14).itemView.findViewById(2131378545).setVisibility(8);
        goto L31
    L25:
        ((RecyclerView.ViewHolder) r14).itemView.findViewById(2131373623).setImageResource(2131250687);
        ((RecyclerView.ViewHolder) r14).itemView.findViewById(2131373623).setVisibility(0);
        goto L28
    L26:
        ((RecyclerView.ViewHolder) r14).itemView.findViewById(2131373623).setImageResource(2131250688);
        ((RecyclerView.ViewHolder) r14).itemView.findViewById(2131373623).setVisibility(0);
        goto L28
    L20:
        ((TextView) ((RecyclerView.ViewHolder) r14).itemView.findViewById(2131391115)).setVisibility(8);
    L16:
        r17 = "";
        goto L17
    L10:
        ImageUtil.loadRoundResource((ImageView) ((RecyclerView.ViewHolder) r14).itemView.findViewById(2131374267), 2131250965, -1, -1);
        goto L11
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        Intrinsics.checkNotNullParameter(r5, "parent");
        return new PKBanViewHolder(r4.inflate(2131566349, r5, false), this.c);
    }
}
