package com.bytedance.android.live.livepkaudience.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.model.LinkPlayerInfo;
import com.bytedance.android.livesdk.config.a8;
import com.bytedance.android.livesdk.utils.d5;
import com.bytedance.android.livesdk.utils.p6;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class PkFriendsItemBinder extends me.drakeet.multitype.b<g, ViewHolder> {
    public final boolean b;
    public final Function1<LinkPlayerInfo, Unit> c;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/livepkaudience/list/PkFriendsItemBinder$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "livepkaudience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        public final HSImageView a;
        public final View b;
        public final TextView c;
        public final TextView d;
        public final LinearLayout e;
        public final SimpleDraweeView f;

        public ViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
            this.a = r2.findViewById(2131375128);
            this.b = r2.findViewById(2131392173);
            this.c = (TextView) r2.findViewById(2131390995);
            this.d = (TextView) r2.findViewById(2131364745);
            this.e = (LinearLayout) r2.findViewById(2131362937);
            this.f = r2.findViewById(2131365089);
        }
    }

    public static boolean h(LinkPlayerInfo r6) {
        Integer r0 = (Integer) a8.a.getValue();
        if (r6.lastInvitedTimeMillis >= 0) goto L5;
    L8:
        return true;
    L5:
        if ((p6.b() - r6.lastInvitedTimeMillis) > (r0.intValue() * 1000)) goto L8;
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PkFriendsItemBinder(boolean r2, Function1<? super LinkPlayerInfo, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "onInvite");
        this.b = r2;
        this.c = r3;
    }

    public final void b(RecyclerView.ViewHolder r12, Object r13) {
        final ViewHolder r14 = (ViewHolder) r12;
        g r15 = (g) r13;
        Intrinsics.checkNotNullParameter(r14, "holder");
        Intrinsics.checkNotNullParameter(r15, "item");
        final LinkPlayerInfo r16 = r15.a;
        HSImageView r0 = r14.a;
        IBaseUser r1 = r16.getUser();
        String r2 = null;
        if (r1 == null) goto L5;
        py.k r3 = r1.getAvatarThumbKt();
    L6:
        ImageUtil.loadRoundImage(r0, r3);
        View r4 = r14.b;
        if (r16.isActive == false) goto L9;
        int r5 = 0;
    L10:
        r4.setVisibility(r5);
        TextView r6 = r14.c;
        IBaseUser r7 = r16.getUser();
        if (r7 == null) goto L13;
        String r8 = r7.getRealNickName();
    L14:
        r6.setText(r8);
        if (r16.isInviting == false) goto L17;
        r14.e.setVisibility(0);
        r14.d.setVisibility(8);
        r14.f.setController(Fresco.newDraweeControllerBuilder().setUri("https://" + LiveCommonConstants.INSTANCE.getObjectTosPath() + "/obj/live-android/ttlive_invite_list_calling.webp").setAutoPlayAnimations(true).build());
        r14.f.postDelayed(new h(r14), 30000);
        r16.isInviting = false;
    L17:
        TextView r9 = r14.d;
        boolean r10 = h(r16);
        if (r10 == false) goto L20;
        r9.setOnClickListener(x0.a(new PkFriendsItemBinder$onBindViewHolder$$inlined$apply$lambda$1(this, r16, r14)));
    L21:
        if (r10 == false) goto L23;
        String r17 = s1.B(2131919316);
    L24:
        r9.setText(r17);
        if (r10 == false) goto L27;
        int r18 = 2131249467;
    L28:
        r9.setBackgroundResource(r18);
        if (r16.mHasExposed == true) goto L58;
        int r19 = al0.d.a;
        boolean r11 = this.b;
        IBaseUser r110 = r16.getUser();
        if (r110 == null) goto L33;
        String r111 = r110.getIdString();
    L34:
        long r20 = d5.c(r111);
        boolean r21 = r16.isActive;
        boolean r22 = h(r16);
        IBaseUser r112 = r16.getUser();
        if (r112 == null) goto L37;
        boolean r113 = r112.isSubscriber();
    L38:
        al0.d.c(r11, r20, r21, r22, r113);
        boolean r114 = this.b;
        IBaseUser r23 = r16.getUser();
        if (r23 == null) goto L41;
        r2 = r23.getIdString();
    L41:
        long r24 = d5.c(r2);
        boolean r25 = r16.isActive;
        boolean r26 = h(r16);
        if (al0.d.b() == true) goto L56;
        HashMap r27 = new HashMap();
        if (r114 == false) goto L46;
        String r115 = "voice_live";
    L47:
        r27.put("live_type", r115);
        el0.j.j(r27, Integer.valueOf(((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene()));
        el0.j.n(r27, Integer.valueOf(((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene()));
        r27.put("invitee_id", String.valueOf(r24));
        if (r25 == false) goto L50;
        String r116 = "online";
    L51:
        r27.put("online_status", r116);
        if (r26 == false) goto L54;
        String r117 = "1";
    L55:
        r27.put("icon_type", r117);
        al0.d.g("livesdk_audience_invitee_show", r27, new Object[0]);
        goto L56
    L54:
        r117 = "0";
        goto L55
    L50:
        r116 = "offline";
        goto L51
    L46:
        r115 = "video_live";
    L56:
        r16.mHasExposed = true;
        return;
    L37:
        r113 = false;
        goto L38
    L33:
        r111 = null;
        goto L34
    L58:
        return;
    L27:
        r18 = 2131249430;
        goto L28
    L23:
        r17 = s1.B(2131919321);
        goto L24
    L20:
        r9.setOnClickListener(null);
        goto L21
    L13:
        r8 = null;
        goto L14
    L9:
        r5 = 8;
        goto L10
    L5:
        r3 = null;
        goto L6
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        Intrinsics.checkNotNullParameter(r5, "parent");
        return new ViewHolder(r4.inflate(2131566352, r5, false));
    }
}
