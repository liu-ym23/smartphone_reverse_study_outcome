package com.bytedance.android.live.liveinteract.linkpanel.list;

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
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.livesdk.utils.p6;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class FriendsItemBinder extends me.drakeet.multitype.b<f, ViewHolder> {
    public final boolean b;
    public final Function1<ILinkPlayerInfoBridge, Unit> c;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/liveinteract/linkpanel/list/FriendsItemBinder$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
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

    public final boolean h(ILinkPlayerInfoBridge r7) {
        int r0 = vm2.d.i();
        if (r7.getLastInvitedTimeMillis() >= 0) goto L5;
    L8:
        return true;
    L5:
        if ((p6.b() - r7.getLastInvitedTimeMillis()) > (r0 * 1000)) goto L8;
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FriendsItemBinder(boolean r2, Function1<? super ILinkPlayerInfoBridge, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "onInvite");
        this.b = r2;
        this.c = r3;
    }

    public final void b(RecyclerView.ViewHolder r12, Object r13) {
        ViewHolder r14 = (ViewHolder) r12;
        f r15 = (f) r13;
        Intrinsics.checkNotNullParameter(r14, "holder");
        Intrinsics.checkNotNullParameter(r15, "item");
        ILinkPlayerInfoBridge r16 = r15.a;
        HSImageView r0 = r14.a;
        IBaseUser r1 = r16.getUser();
        if (r1 == null) goto L5;
        py.k r2 = r1.getAvatarThumbKt();
    L6:
        ImageUtil.loadRoundImage(r0, r2);
        View r3 = r14.b;
        if (r16.isActive() == false) goto L9;
        int r4 = 0;
    L10:
        r3.setVisibility(r4);
        TextView r5 = r14.c;
        IBaseUser r6 = r16.getUser();
        if (r6 == null) goto L13;
        String r7 = r6.getRealNickName();
    L14:
        r5.setText(r7);
        if (r16.isInviting() == false) goto L17;
        r14.e.setVisibility(0);
        r14.d.setVisibility(8);
        r14.f.setController(Fresco.newDraweeControllerBuilder().setUri("https://" + LiveCommonConstants.INSTANCE.getObjectTosPath() + "/obj/live-android/ttlive_invite_list_calling.webp").setAutoPlayAnimations(true).build());
        r14.f.postDelayed(new j(r14), 30000);
        r16.setInviting(false);
    L17:
        TextView r8 = r14.d;
        boolean r9 = h(r16);
        if (r9 == false) goto L20;
        r8.setOnClickListener(new i(r14, this, r16));
    L21:
        if (r9 == false) goto L23;
        String r17 = s1.B(2131919316);
    L24:
        r8.setText(r17);
        if (r9 == false) goto L27;
        int r18 = 2131249467;
    L28:
        r8.setBackgroundResource(r18);
        if (r16.isHasExposed() == true) goto L47;
        boolean r10 = this.b;
        IBaseUser r19 = r16.getUser();
        Intrinsics.checkNotNull(r19);
        String r11 = r19.getIdString();
        boolean r20 = r16.isActive();
        boolean r21 = h(r16);
        IBaseUser r110 = r16.getUser();
        Intrinsics.checkNotNull(r110);
        com.bytedance.android.live.liveinteract.linkpanel.util.m.i(r10, r11, r20, r21, r110.isSubscriber(), "mutual");
        boolean r111 = this.b;
        IBaseUser r22 = r16.getUser();
        Intrinsics.checkNotNull(r22);
        String r23 = r22.getIdString();
        boolean r24 = r16.isActive();
        boolean r25 = h(r16);
        Intrinsics.checkNotNullParameter(r23, "inviteeId");
        if (com.bytedance.android.live.liveinteract.linkpanel.util.m.h() == true) goto L45;
        HashMap r26 = new HashMap();
        if (r111 == false) goto L35;
        String r112 = "voice_live";
    L36:
        r26.put("live_type", r112);
        com.bytedance.android.live.liveinteract.linkpanel.util.m.B(r26, Integer.valueOf(((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene()), 4);
        com.bytedance.android.live.liveinteract.linkpanel.util.m.H(r26, Integer.valueOf(((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene()));
        r26.put("invitee_id", r23.toString());
        if (r24 == false) goto L39;
        String r113 = "online";
    L40:
        r26.put("online_status", r113);
        if (r25 == false) goto L43;
        String r114 = "1";
    L44:
        r26.put("icon_type", r114);
        com.bytedance.android.live.liveinteract.linkpanel.util.m.L("livesdk_audience_invitee_show", r26, new Object[0]);
        goto L45
    L43:
        r114 = "0";
        goto L44
    L39:
        r113 = "offline";
        goto L40
    L35:
        r112 = "video_live";
    L45:
        r16.setHasExposed(true);
        return;
    L47:
        return;
    L27:
        r18 = 2131249430;
        goto L28
    L23:
        r17 = s1.B(2131919321);
        goto L24
    L20:
        r8.setOnClickListener(null);
        goto L21
    L13:
        r7 = null;
        goto L14
    L9:
        r4 = 8;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        Intrinsics.checkNotNullParameter(r5, "parent");
        return new ViewHolder(r4.inflate(2131566408, r5, false));
    }
}
