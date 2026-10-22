package com.bytedance.android.live.liveinteract.revenue.paid.profilecard;

import am2.x;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.ui.h;
import com.bytedance.android.live.liveinteract.plantform.base.e;
import com.bytedance.android.live.liveinteract.plantform.base.f;
import com.bytedance.android.live.liveinteract.plantform.base.g;
import com.bytedance.android.live.liveinteract.plantform.base.j;
import com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.n;
import hd0.c;
import java.util.HashMap;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import lf0.d;
import rj0.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/liveinteract/revenue/paid/profilecard/PaidProfileCardWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomWidget;", "<init>", "()V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PaidProfileCardWidget extends MiddlewareRoomWidget {
    public final com.bytedance.android.live.liveinteract.api.data.b a;
    public d b;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ PaidProfileCardWidget a;

        public a(PaidProfileCardWidget r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r5) {
            PaidProfileCardWidget r6 = this.a;
            r6.getClass();
            HashMap r0 = new HashMap();
            r0.put("function_type", ((IInteractService) k.n(IInteractService.class)).getCurrentFunctionType());
            r0.put("action_type", "close");
            if (Intrinsics.areEqual(m.j(r6).isAnchor(), Boolean.TRUE) == false) goto L5;
            String r7 = "anchor";
        L12:
            r0.put("user_type", r7);
            j0.l().sendLog("livesdk_anchor_audience_connection_rechargeable_card_click", r0, new Object[]{IRoom.class, x.class});
            PaidProfileCardContext.a r8 = PaidProfileCardContext.Companion;
            j r1 = r8.a();
            if (r1 != null) goto L15;
            return;
        L15:
            if (r1.Ie() != true) goto L21;
            j r9 = r8.a();
            if (r9 == null) goto L22;
            r9.n7();
            return;
        L22:
            return;
        L21:
            return;
        L5:
            Integer r10 = (Integer) ((ge1.a) c.f()).b;
            if (r10 != null) goto L9;
        L10:
            r7 = "guest";
            goto L12
        L9:
            if (r10.intValue() != 0) goto L10;
            r7 = "user";
            goto L12
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ PaidProfileCardWidget a;

        public b(PaidProfileCardWidget r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r7) {
            PaidProfileCardWidget r8 = this.a;
            r8.getClass();
            HashMap r0 = new HashMap();
            r0.put("function_type", ((IInteractService) k.n(IInteractService.class)).getCurrentFunctionType());
            r0.put("action_type", "link");
            if (Intrinsics.areEqual(m.j(r8).isAnchor(), Boolean.TRUE) == false) goto L5;
            String r1 = "anchor";
        L12:
            r0.put("user_type", r1);
            j0.l().sendLog("livesdk_anchor_audience_connection_rechargeable_card_click", r0, new Object[]{IRoom.class, x.class});
            com.bytedance.android.live.liveinteract.api.data.b r9 = r8.a;
            if (r9 == null) goto L15;
            boolean r10 = r9.a;
        L16:
            if (r10 == true) goto L18;
            xs2.b.a().post(new h());
        L18:
            g r2 = f.a();
            if (r2.j7() == false) goto L29;
            if (r10 == false) goto L24;
            com.bytedance.android.live.liveinteract.plantform.base.d.j0.getClass();
            com.bytedance.android.live.liveinteract.plantform.base.d r11 = com.bytedance.android.live.liveinteract.plantform.base.d.a.a();
            if (r11 == null) goto L48;
            r11.showInviteAndPermitDialog();
            return;
        L48:
            return;
        L24:
            if (r10 == true) goto L50;
            e.l0.getClass();
            e r12 = e.a.a();
            if (r12 == null) goto L51;
            r12.Dn();
            return;
        L51:
            return;
        L50:
            return;
        L29:
            if (r2.nd() == false) goto L39;
            if (r10 == false) goto L34;
            rj0.k.m2.getClass();
            rj0.k r13 = rj0.k.a.a();
            if (r13 == null) goto L53;
            r13.pm();
            return;
        L53:
            return;
        L34:
            if (r10 == true) goto L55;
            l.n2.getClass();
            l r14 = l.a.a();
            if (r14 == null) goto L56;
            r14.onProfileCardClick("card", 113, "video_talk_room_guest_widget_profile_confirm");
            return;
        L56:
            return;
        L55:
            return;
        L39:
            if (r2.s8() == false) goto L58;
            if (r10 == false) goto L44;
            com.bytedance.android.live.liveinteract.voicechat.d.s0.getClass();
            com.bytedance.android.live.liveinteract.voicechat.d r15 = com.bytedance.android.live.liveinteract.voicechat.d.a.a();
            if (r15 == null) goto L59;
            r15.showInviteAndPermitDialog(false, "card", -1);
            return;
        L59:
            return;
        L44:
            IVoiceChatGuestService.Companion.getClass();
            IVoiceChatGuestService r16 = IVoiceChatGuestService.a.a();
            if (r16 == null) goto L61;
            r16.onProfileCardClick("card", 113, "audio_talk_room_guest_widget_profile_confirm");
            return;
        L61:
            return;
        L58:
            return;
        L15:
            r10 = false;
            goto L16
        L5:
            Integer r3 = (Integer) ((ge1.a) c.f()).b;
            if (r3 != null) goto L9;
        L10:
            r1 = "guest";
            goto L12
        L9:
            if (r3.intValue() != 0) goto L10;
            r1 = "user";
            goto L12
        }
    }

    public PaidProfileCardWidget() {
        PaidProfileCardContext r0 = PaidProfileCardContext.Companion.getContext();
        if (r0 == null) goto L7;
        n<com.bytedance.android.live.liveinteract.api.data.b> r1 = r0.getPaidProfileCardData();
        if (r1 == null) goto L7;
        com.bytedance.android.live.liveinteract.api.data.b r2 = (com.bytedance.android.live.liveinteract.api.data.b) r1.getValue();
    L8:
        this.a = r2;
        return;
    L7:
        r2 = null;
        goto L8
    }

    public final void onCreate() {
        super.onCreate();
        PaidProfileCardContext r0 = PaidProfileCardContext.Companion.getContext();
        if (r0 == null) goto L8;
        n<PaidProfileCardContext.b> r1 = r0.getPaidProfileCardPosition();
        if (r1 == null) goto L8;
        PaidProfileCardContext.b r2 = (PaidProfileCardContext.b) r1.getValue();
        if (r2 == null) goto L8;
    L9:
        com.bytedance.android.live.liveinteract.api.data.b r3 = this.a;
        if (r3 != null) goto L12;
        return;
    L12:
        d r4 = new d(getContext());
        r4.setAnchor(r3.a);
        r4.setLabel(r3.b);
        r4.setAvatar(r3.c);
        r4.setNumOfLink(r3.d);
        r4.setScore(r3.e);
        r4.setOnCloseClickListener(new a(this));
        r4.setOnConfirmClickListener(new b(this));
        FrameLayout.LayoutParams r5 = new FrameLayout.LayoutParams((int) getContext().getResources().getDimension(2131169028), (int) getContext().getResources().getDimension(2131169025));
        r5.leftMargin = r2.a;
        r5.topMargin = r2.b;
        r5.rightMargin = r2.c;
        r5.bottomMargin = r2.d;
        r5.gravity = r2.e;
        ((Widget) this).containerView.addView(r4, r5);
        this.b = r4;
        HashMap r6 = new HashMap();
        r6.put("function_type", ((IInteractService) k.n(IInteractService.class)).getCurrentFunctionType());
        if (Intrinsics.areEqual(m.j(this).isAnchor(), Boolean.TRUE) == false) goto L15;
        String r7 = "anchor";
    L22:
        r6.put("user_type", r7);
        j0.l().sendLog("livesdk_anchor_audience_connection_rechargeable_card_show", r6, new Object[]{IRoom.class, x.class});
        return;
    L15:
        Integer r8 = (Integer) ((ge1.a) c.f()).b;
        if (r8 != null) goto L19;
    L20:
        r7 = "guest";
        goto L22
    L19:
        if (r8.intValue() != 0) goto L20;
        r7 = "user";
    L8:
        r2 = new PaidProfileCardContext.b(0, (int) ((Widget) this).context.getResources().getDimension(2131169027), (int) ((Widget) this).context.getResources().getDimension(2131169026), 8388693);
        goto L9
    }

    public final void onDestroy() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onDestroy();
        d r0 = this.b;
        if (r0 == null) goto L6;
        ((Widget) this).containerView.removeView(r0);
        this.b = null;
        return;
    }
}
