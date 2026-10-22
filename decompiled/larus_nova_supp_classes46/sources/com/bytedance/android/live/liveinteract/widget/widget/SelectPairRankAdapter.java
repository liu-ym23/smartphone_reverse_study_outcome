package com.bytedance.android.live.liveinteract.widget.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.chatroom.utils.a3;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bR\"\u0010\n\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/liveinteract/widget/widget/SelectPairRankAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/content/Context;", "b", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "context", "SelectPairRankItemViewHolder", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class SelectPairRankAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public final ArrayList<com.bytedance.android.livesdk.rank.model.c.a> a;
    public final Context b;
    public final SelectPairRankItemViewHolder.a c;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/liveinteract/widget/widget/SelectPairRankAdapter$SelectPairRankItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "a", "b", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class SelectPairRankItemViewHolder extends RecyclerView.ViewHolder {
        public static final /* synthetic */ int j = 0;
        public final TextView a;
        public final ImageView b;
        public final TextView c;
        public final ImageView d;
        public final LinearLayout e;
        public final TextView f;
        public final TextView g;
        public final HSImageView h;
        public final a i;

        public interface a {
            void a0(IBaseUser r1);
        }

        public static final class b {
        }

        static {
        }

        public SelectPairRankItemViewHolder(View r2, a r3) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            Intrinsics.checkNotNullParameter(r3, "callback");
            super(r2);
            this.i = r3;
            this.a = (TextView) r2.findViewById(2131383678);
            this.b = (ImageView) r2.findViewById(2131391990);
            this.c = (TextView) r2.findViewById(2131392049);
            this.d = (ImageView) r2.findViewById(2131374498);
            this.e = (LinearLayout) r2.findViewById(2131372112);
            this.f = (TextView) r2.findViewById(2131372109);
            this.g = (TextView) r2.findViewById(2131388634);
            this.h = r2.findViewById(2131376022);
        }
    }

    public final int getItemCount() {
        return this.a.size();
    }

    public final Context getContext() {
        return this.b;
    }

    public SelectPairRankAdapter(Context r2, SelectPairRankItemViewHolder.a r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "callback");
        this.b = r2;
        this.c = r3;
        this.a = new ArrayList();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r12, int r13) {
        Intrinsics.checkNotNullParameter(r12, "viewHolder");
        if ((r12 instanceof SelectPairRankItemViewHolder) == false) goto L134;
        SelectPairRankItemViewHolder r14 = (SelectPairRankItemViewHolder) r12;
        com.bytedance.android.livesdk.rank.model.c.a r15 = (com.bytedance.android.livesdk.rank.model.c.a) ListProtector.get(this.a, r13);
        r14.getClass();
        Intrinsics.checkNotNullParameter(r15, "item");
        IBaseUser r0 = r15.user;
        TextView r1 = r14.a;
        boolean r2 = true;
        if (r1 == null) goto L18;
        int r3 = r15.rank;
        if (r3 != 1) goto L9;
        int r4 = ((RecyclerView.ViewHolder) r14).itemView.getResources().getColor(2131107264);
    L16:
        r1.setTextColor(r4);
        r1.setText(String.valueOf(r15.rank));
        goto L18
    L9:
        if (r3 != 2) goto L11;
        r4 = ((RecyclerView.ViewHolder) r14).itemView.getResources().getColor(2131107265);
        goto L16
    L11:
        if (r3 == 3) goto L13;
        r4 = ((RecyclerView.ViewHolder) r14).itemView.getResources().getColor(2131107267);
        goto L16
    L13:
        r4 = ((RecyclerView.ViewHolder) r14).itemView.getResources().getColor(2131107266);
    L18:
        if (r0 == null) goto L20;
        boolean r5 = r0.isFollowing();
    L21:
        String r6 = "";
        if (r5 == true) goto L37;
        if (r0 == null) goto L26;
        String r7 = r0.getIdString();
        if (r7 == null) goto L26;
    L27:
        IMiddlewareUserService r8 = jc1.k.f(IMiddlewareUserService.class);
        if (r8 == null) goto L33;
        com.bytedance.android.livesdk.user.e r9 = r8.user();
        if (r9 == null) goto L33;
        String r10 = r9.n();
        if (r10 == null) goto L33;
    L35:
        if ((!Intrinsics.areEqual(r7, r10)) == false) goto L37;
        boolean r11 = true;
    L38:
        ImageView r16 = r14.b;
        py.k r17 = null;
        if (r16 == null) goto L44;
        if (r0 == null) goto L42;
        py.k r18 = r0.getAvatarThumbKt();
    L43:
        a1.x(r16, r18, r16.getWidth(), r16.getHeight(), 2131251677);
        r16.setVisibility(0);
        r16.setOnClickListener(new y(r14, r0, r11));
        goto L44
    L42:
        r18 = null;
    L44:
        zt0.e r19 = yt0.c.a();
        if (r0 == null) goto L49;
        py.f r20 = r0.getBorder();
        if (r20 == null) goto L49;
        String r21 = r20.getDressId();
    L50:
        com.bytedance.android.live.profit.dress.a r22 = r19.getDressData(r21, 1, "SelectPairRankAdapter: bind");
        if (r22 == null) goto L54;
        py.k r23 = r22.a;
        if (r23 == null) goto L54;
    L60:
        if (r23 == null) goto L64;
        HSImageView r24 = r14.h;
        if (r24 == null) goto L67;
        r24.setVisibility(0);
        ImageLoader.bindImage(r24, r23);
    L67:
        TextView r25 = r14.c;
        if (r25 == null) goto L74;
        if (r0 == null) goto L73;
        String r26 = r0.getNickName();
        if (r26 == null) goto L73;
        r6 = r26;
    L73:
        r25.setText(r6);
    L74:
        if (r0 == null) goto L129;
        ImageView r27 = r14.d;
        if (r27 == null) goto L89;
        if (r0.getUserHonor() == null) goto L82;
        py.d r28 = r0.getUserHonor();
        if (r28 == null) goto L82;
        py.k r29 = r28.getNewImIconWithLevel();
    L83:
        if (r29 != null) goto L85;
    L87:
        r27.setVisibility(8);
        goto L89
    L85:
        if (CollectionUtils.isEmpty(r29.getUrls()) == true) goto L87;
        ImageUtil.loadImage(r14.d, r29, new b0(r27));
        r27.setVisibility(0);
    L82:
        r29 = null;
    L89:
        if (r0.getFansClub() != null) goto L96;
        LinearLayout r30 = r14.e;
        if (r30 == null) goto L93;
        r30.setVisibility(8);
    L93:
        TextView r31 = r14.f;
        if (r31 == null) goto L129;
        r31.setVisibility(8);
        goto L129
    L96:
        com.bytedance.android.live.base.model.user.t r32 = r0.getFansClub();
        if (r32 == null) goto L99;
        py.h r33 = r32.getData();
    L100:
        if (r33 == null) goto L104;
        py.u r34 = r33.getBadge();
        if (r34 == null) goto L104;
        r17 = r34.getToShowIcon();
    L104:
        py.h.Companion.getClass();
        if (r33 == null) goto L114;
        String r35 = r33.getClubName();
        if (r35 == null) goto L114;
        if (r35.length() <= 0) goto L111;
        boolean r36 = true;
    L112:
        if (r36 != true) goto L114;
    L115:
        if (r2 == false) goto L123;
        if (r17 == null) goto L123;
        int r37 = a3.d;
        a3.a.a(r14.e, r17, new a0(r14, r33), 0.0f);
        LinearLayout r38 = r14.e;
        if (r38 == null) goto L120;
        r38.setVisibility(0);
    L120:
        TextView r39 = r14.f;
        if (r39 == null) goto L129;
        r39.setVisibility(0);
    L123:
        LinearLayout r40 = r14.e;
        if (r40 == null) goto L126;
        r40.setVisibility(8);
    L126:
        TextView r41 = r14.f;
        if (r41 == null) goto L129;
        r41.setVisibility(8);
        goto L129
    L111:
        r36 = false;
    L114:
        r2 = false;
        goto L115
    L99:
        r33 = null;
    L129:
        TextView r42 = r14.g;
        if (r42 == null) goto L132;
        r42.setText(com.bytedance.android.live.core.utils.x.c(r15.score));
    L132:
        ((RecyclerView.ViewHolder) r14).itemView.setOnClickListener(new z(r14, r0));
        return;
    L64:
        HSImageView r43 = r14.h;
        if (r43 == null) goto L67;
        r43.setVisibility(8);
    L54:
        if (r0 == null) goto L58;
        py.f r44 = r0.getBorder();
        if (r44 == null) goto L58;
        r23 = r44.getIcon();
    L58:
        r23 = null;
    L49:
        r21 = null;
    L33:
        r10 = "";
    L26:
        r7 = "";
    L37:
        r11 = false;
        goto L38
    L20:
        r5 = false;
        goto L21
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        return new SelectPairRankItemViewHolder(LayoutInflater.from(this.b).inflate(2131566430, r4, false), this.c);
    }
}
