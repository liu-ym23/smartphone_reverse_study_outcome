package y31;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.revlink.impl.pk.dialog.viewholder.PkReserveViewHolder;
import com.bytedance.android.live.revlink.impl.pk.dialog.viewholder.PkReserveViewHolder$onBindViewHolder$$inlined$let$lambda$2;
import com.bytedance.android.live.revlink.impl.pk.ui.PkTagsContainerView;
import com.bytedance.android.livesdk.link.model.ButtonStatus;
import com.bytedance.android.livesdk.link.model.IBattleRivalTag;
import com.bytedance.android.livesdk.link.model.o3;
import com.bytedance.android.livesdk.link.model.o8;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class t extends me.drakeet.multitype.b<a, PkReserveViewHolder> {

    public static final class a {
        public IBaseUser a;
        public IRoom b;
        public List<? extends IBattleRivalTag> c;
        public o3 d;
        public o3 e;
        public String f;
        public String g;
        public int h;
        public Function3<? super IRoom, ? super IBaseUser, ? super String, Unit> i;
        public Function2<? super o8, ? super Function1<? super Integer, Unit>, Unit> j;
        public o8 k;

        public a() {
            this.f = "";
            this.g = "";
        }
    }

    public t() {
    }

    public final void g(RecyclerView.ViewHolder r2) {
        Intrinsics.checkNotNullParameter((PkReserveViewHolder) r2, "holder");
    }

    public final void b(RecyclerView.ViewHolder r10, Object r12) {
        final PkReserveViewHolder r13 = (PkReserveViewHolder) r10;
        a r14 = (a) r12;
        Intrinsics.checkNotNullParameter(r13, "holder");
        Intrinsics.checkNotNullParameter(r14, Constants.Keys.DATA);
        if (r14 != null) goto L5;
        r13.getClass();
        return;
    L5:
        r13.a = r14;
        ImageView r15 = (ImageView) ((RecyclerView.ViewHolder) r13).itemView.findViewById(2131374211);
        a r0 = r13.a;
        List<? extends IBattleRivalTag> r1 = null;
        if (r0 == null) goto L10;
        IBaseUser r2 = r0.a;
        if (r2 == null) goto L10;
        py.k r3 = r2.getAvatarThumbKt();
    L11:
        ImageUtil.loadRoundImage(r15, r3);
        TextView r16 = (TextView) ((RecyclerView.ViewHolder) r13).itemView.findViewById(2131390993);
        a r4 = r13.a;
        if (r4 == null) goto L16;
        IBaseUser r5 = r4.a;
        if (r5 == null) goto L16;
        String r6 = r5.getNickName();
    L17:
        r16.setText(r6);
        a r17 = r13.a;
        if (r17 == null) goto L22;
        IBaseUser r18 = r17.a;
        if (r18 == null) goto L22;
        Integer r19 = Integer.valueOf(r18.getGender());
    L24:
        if (r19 != null) goto L27;
    L31:
        if (r19 != null) goto L34;
    L38:
        View r110 = ((RecyclerView.ViewHolder) r13).itemView.findViewById(2131373620);
        if (r110 == null) goto L41;
        r110.setVisibility(8);
    L41:
        TextView r111 = (TextView) ((RecyclerView.ViewHolder) r13).itemView.findViewById(2131384413);
        a r7 = r13.a;
        String r8 = "";
        if (r7 == null) goto L46;
        String r9 = r7.f;
        if (r9 == null) goto L46;
    L47:
        r111.setText(r9);
        a r112 = r13.a;
        if (r112 == null) goto L62;
        o3 r113 = r112.e;
        if (r113 == null) goto L62;
        if (r113.getButtonStatus() != ButtonStatus.Normal.ordinal()) goto L62;
        TextView r114 = (TextView) ((RecyclerView.ViewHolder) r13).itemView.findViewById(2131375596);
        r114.setTextColor(s1.h(2131107773));
        r114.setOnClickListener(new com.bytedance.android.live.revlink.impl.pk.dialog.viewholder.t(r13));
        a r20 = r13.a;
        if (r20 == null) goto L60;
        o3 r22 = r20.e;
        if (r22 == null) goto L60;
        String r23 = r22.getText();
        if (r23 == null) goto L60;
    L61:
        r114.setText(r23);
    L80:
        TextView r115 = (TextView) ((RecyclerView.ViewHolder) r13).itemView.findViewById(2131384340);
        a r24 = r13.a;
        if (r24 == null) goto L87;
        o3 r25 = r24.d;
        if (r25 == null) goto L87;
        String r26 = r25.getText();
        if (r26 == null) goto L87;
        r8 = r26;
    L87:
        r115.setText(r8);
        a r27 = r13.a;
        if (r27 == null) goto L94;
        o3 r28 = r27.d;
        if (r28 == null) goto L94;
        if (r28.getButtonStatus() != ButtonStatus.Normal.ordinal()) goto L94;
        r115.setTextColor(s1.h(2131107368));
        r115.setTextSize(13.0f);
        r115.setBackground(s1.m(2131249725));
        r115.setOnClickListener(new PkReserveViewHolder$onBindViewHolder$$inlined$let$lambda$2(r13));
    L108:
        a r116 = r13.a;
        if (r116 == null) goto L113;
        IRoom r117 = r116.b;
        if (r117 == null) goto L113;
        IBaseUser r118 = r117.getOwner();
    L114:
        if (r118 == null) goto L116;
        ((RecyclerView.ViewHolder) r13).itemView.findViewById(2131365723).setVisibility(0);
        AbstractDraweeController r119 = Fresco.newDraweeControllerBuilder().setUri("https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/ttlive_item_rank_top_on_going_hd.webp").setAutoPlayAnimations(true).build();
        HSImageView r29 = ((RecyclerView.ViewHolder) r13).itemView.findViewById(2131378545);
        r29.setVisibility(0);
        r29.setController(r119);
    L116:
        a r120 = r13.a;
        if (r120 == null) goto L119;
        o3 r121 = r120.e;
    L120:
        if (r121 != null) goto L122;
        ((TextView) ((RecyclerView.ViewHolder) r13).itemView.findViewById(2131375596)).setVisibility(8);
    L122:
        a r122 = r13.a;
        if (r122 == null) goto L125;
        o3 r123 = r122.d;
    L126:
        if (r123 != null) goto L128;
        ((TextView) ((RecyclerView.ViewHolder) r13).itemView.findViewById(2131384340)).setVisibility(8);
    L128:
        PkTagsContainerView r30 = (PkTagsContainerView) ((RecyclerView.ViewHolder) r13).itemView.findViewById(2131388160);
        a r124 = r13.a;
        if (r124 == null) goto L131;
        r1 = r124.c;
    L131:
        PkTagsContainerView.f(r30, r1, false, null, 0, null, 56);
        return;
    L125:
        r123 = null;
        goto L126
    L119:
        r121 = null;
    L113:
        r118 = null;
    L94:
        r115.setTextColor(s1.h(2131107369));
        r115.setTextSize(11.0f);
        a r32 = r13.a;
        if (r32 != null) goto L97;
    L99:
        r115.setText("已拒绝");
    L100:
        a r33 = r13.a;
        if (r33 == null) goto L107;
        o3 r34 = r33.d;
        if (r34 == null) goto L107;
        String r35 = r34.getText();
        if (r35 == null) goto L107;
        r115.setText(r35);
    L107:
        r115.setBackground(null);
        r115.setOnClickListener(null);
        goto L108
    L97:
        if (r32.h != 1) goto L99;
        r115.setText("已回复");
    L60:
        r23 = "发起邀请";
    L62:
        TextView r125 = (TextView) ((RecyclerView.ViewHolder) r13).itemView.findViewById(2131375596);
        r125.setTextColor(s1.h(2131107328));
        r125.setOnClickListener(null);
        a r126 = r13.a;
        if (r126 == null) goto L79;
        o3 r127 = r126.e;
        if (r127 == null) goto L79;
        String r128 = r127.getText();
        if (r128 == null) goto L79;
        if (r2.a(r128) != true) goto L79;
        TextView r129 = (TextView) ((RecyclerView.ViewHolder) r13).itemView.findViewById(2131375596);
        if (r129 == null) goto L79;
        a r36 = r13.a;
        if (r36 == null) goto L77;
        o3 r37 = r36.e;
        if (r37 == null) goto L77;
        String r38 = r37.getText();
    L78:
        r129.setText(r38);
    L77:
        r38 = null;
    L79:
        ((RecyclerView.ViewHolder) r13).itemView.findViewById(2131365723).setVisibility(8);
        ((RecyclerView.ViewHolder) r13).itemView.findViewById(2131378545).setVisibility(8);
    L46:
        r9 = "";
        goto L47
    L34:
        if (r19.intValue() != 2) goto L38;
        ImageView r130 = (ImageView) ((RecyclerView.ViewHolder) r13).itemView.findViewById(2131373620);
        if (r130 == null) goto L41;
        r130.setBackground(s1.m(2131250687));
        goto L41
    L27:
        if (r19.intValue() != 1) goto L31;
        ImageView r131 = (ImageView) ((RecyclerView.ViewHolder) r13).itemView.findViewById(2131373620);
        if (r131 == null) goto L41;
        r131.setBackground(s1.m(2131250688));
    L22:
        r19 = null;
    L16:
        r6 = null;
    L10:
        r3 = null;
        goto L11
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        Intrinsics.checkNotNullParameter(r5, "parent");
        return new PkReserveViewHolder(r4.inflate(2131566363, r5, false));
    }
}
