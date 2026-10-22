package com.bytedance.android.live.liveinteract.interact.audience;

import am2.x;
import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.ui.KtvSeatAnimationView;
import com.bytedance.android.live.liveinteract.interact.audience.dialog.InteractAudienceAnchorKickOutDialog;
import com.bytedance.android.live.liveinteract.interact.audience.dialog.InteractAudienceGuestApplyDialog;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.room.IMiddlewareRoomService;
import com.bytedance.android.live.ui.LinkGuestSendGiftView;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.message.model.b8;
import com.bytedance.android.livesdk.message.model.n8;
import com.bytedance.android.livesdk.message.model.za;
import com.bytedance.android.livesdk.utils.p6;
import com.bytedance.android.livesdk.utils.r3;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IStreamUrlExtraKt;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import fd2.z;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f extends FrameLayout implements ge0.c {
    public View a;
    public View b;
    public TextView c;
    public TextView d;
    public View e;
    public View f;
    public View g;
    public HSImageView h;
    public TextView i;
    public final DataCenter j;
    public boolean k;
    public LinkGuestSendGiftView l;
    public boolean m;
    public boolean n;
    public boolean o;
    public long p;
    public long q;
    public KtvSeatAnimationView r;
    public final ge0.b s;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ f a;

        public b(f r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            this.a.d(((z) r2).a);
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ f a;

        public c(f r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r17) {
            IBaseUser r5 = this.a.getPresenter().e();
            if (r5 != null) goto L5;
            return;
        L5:
            if (jc1.k.n(IMiddlewareRoomService.class).isRecording() == true) goto L7;
        L9:
            com.bytedance.android.live.liveinteract.plantform.base.e.l0.getClass();
            com.bytedance.android.live.liveinteract.plantform.base.e r1 = com.bytedance.android.live.liveinteract.plantform.base.e.a.a();
            if (r1 == null) goto L24;
            if (r1.isEngineOn() == true) goto L24;
            com.bytedance.android.livesdk.chatroom.o r2 = com.bytedance.android.live.liveinteract.api.utils.m.l(this.a.j, 0L);
            if (r2 == null) goto L24;
            com.bytedance.live.datacontext.m r3 = r2.getCleanMode();
            if (r3 == null) goto L24;
            if (((Number) r3.getValue()).intValue() != 2) goto L24;
            if (vm2.e.h() == false) goto L24;
            ALogger.w("InteractAudienceGuestWindow", "rejected guest stub click for pure clean mode");
            return;
        L24:
            if (this.a.getPresenter().d().isHost() == false) goto L29;
            DataCenter r4 = this.a.j;
            if (r4 == null) goto L81;
            r4.put("cmd_show_user_profile", new UserProfileEvent(r5).setReportSource("audience_linkmic").setReportType("data_card_linked_audience").setClickUserPosition("pk_linked_audience").setShowSendGift(true));
            return;
        L81:
            return;
        L29:
            f r6 = this.a;
            DataCenter r11 = r6.j;
            if (r11 == null) goto L32;
            Boolean r12 = (Boolean) r11.get("data_is_anchor", Boolean.FALSE);
        L33:
            Intrinsics.checkNotNull(r12);
            r6.k = r12.booleanValue();
            f r7 = this.a;
            if (r7.k == false) goto L40;
            InteractAudienceAnchorKickOutDialog r8 = new InteractAudienceAnchorKickOutDialog(this.a.getContext(), true, r5, this.a.p);
            if (DialogLancet.shouldBlockDialogShow(r8) == false) goto L79;
            DialogLancet.handleBlockedDialogShow(r8);
            return;
        L79:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L72
        L39:
            DialogLancet.beforeDialogShow(r8);
            r8.show();
            DialogLancet.afterDialogShow(r8);
            return;
        L40:
            long r13 = com.bytedance.android.live.liveinteract.plantform.model.n.b(r7.getPresenter().d());
            com.bytedance.android.live.liveinteract.utils.d r9 = jf0.c.a;
            if (this.a.getPresenter().g() == false) goto L43;
            String r10 = "oneself";
        L44:
            String r14 = r5.getIdString();
            Intrinsics.checkNotNullParameter(r10, "userType");
            Intrinsics.checkNotNullParameter(r14, "uid");
            HashMap r15 = new HashMap();
            r15.put("function_type", "audience");
            r15.put("user_type", r10);
            r15.put("user_id", r14.toString());
            if (r13 <= 0) goto L47;
            r15.put("tag_type", String.valueOf(r13));
        L47:
            Integer r16 = (Integer) ((ge1.a) hd0.c.f()).b;
            if (r16 != null) goto L51;
        L53:
            String r18 = "0";
        L54:
            r15.put("is_user_guest", r18);
            j0.l().sendLog("livesdk_seat_head_click", r15, new Object[]{IRoom.class, x.class});
            if (this.a.getPresenter().g() == false) goto L62;
            tc0.c.h().G = "seat";
            InteractAudienceGuestApplyDialog r19 = new InteractAudienceGuestApplyDialog(this.a.getContext(), this.a.j);
            if (DialogLancet.shouldBlockDialogShow(r19) == false) goto L75;
            DialogLancet.handleBlockedDialogShow(r19);
            return;
        L75:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L73
        L60:
            DialogLancet.beforeDialogShow(r19);
            r19.show();
            DialogLancet.afterDialogShow(r19);
            return;
        L62:
            if (jc1.k.n(IMiddlewareUserService.class).user().c() == false) goto L68;
            InteractAudienceAnchorKickOutDialog r20 = new InteractAudienceAnchorKickOutDialog(this.a.getContext(), false, r5, this.a.p);
            if (DialogLancet.shouldBlockDialogShow(r20) == false) goto L77;
            DialogLancet.handleBlockedDialogShow(r20);
            return;
        L77:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L74
        L67:
            DialogLancet.beforeDialogShow(r20);
            r20.show();
            DialogLancet.afterDialogShow(r20);
            return;
        L68:
            DataCenter r21 = this.a.j;
            if (r21 == null) goto L89;
            r21.put("cmd_show_user_profile", new UserProfileEvent(r5).setReportSource("audience_linkmic").setReportType("data_card_linked_audience").setClickUserPosition("pk_linked_audience").setShowSendGift(true));
            return;
        L89:
            return;
        L51:
            if (r16.intValue() != 2) goto L53;
            r18 = "1";
            goto L54
        L43:
            r10 = "audience";
            goto L44
        L32:
            r12 = null;
            goto L33
        L7:
            if (jc1.k.n(IMiddlewareRoomService.class).isClearRecord() == false) goto L9;
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ f a;

        public d(f r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r9) {
            this.a.getClass();
            DataCenter r10 = this.a.j;
            IRoom r0 = null;
            if (r10 == null) goto L5;
            r0 = (IRoom) r10.get("data_room", null);
        L5:
            IRoom r5 = r0;
            IBaseUser r4 = this.a.getPresenter().e();
            com.bytedance.android.live.liveinteract.plantform.base.e.l0.getClass();
            com.bytedance.android.live.liveinteract.plantform.base.e r11 = com.bytedance.android.live.liveinteract.plantform.base.e.a.a();
            if (r11 != null) goto L8;
        L29:
            if (r5 == null) goto L33;
            if (r4 == null) goto L34;
            hi0.a.c(hi0.a.a, this.a.getContext(), this.a.j, r4, r5, false, 48);
            return;
        L34:
            return;
        L33:
            return;
        L8:
            if (r11.isEngineOn() == true) goto L29;
            if (vm2.e.h() == false) goto L29;
            com.bytedance.android.livesdk.chatroom.o r12 = com.bytedance.android.live.liveinteract.api.utils.m.l(this.a.j, 0L);
            if (r12 == null) goto L29;
            com.bytedance.live.datacontext.m r13 = r12.getCleanMode();
            if (r13 == null) goto L29;
            Integer r14 = (Integer) r13.getValue();
            if (r14 == null) goto L29;
            int r15 = r14.intValue();
            if (r15 != 2) goto L20;
        L25:
            boolean r16 = true;
        L26:
            if (r16 != true) goto L29;
            ALogger.w("InteractAudienceGuestWindow", "rejected guest rank click for new clean mode");
            return;
        L20:
            if (r15 == 3) goto L25;
            if (r15 == 13) goto L25;
            r16 = false;
            goto L26
        }
    }

    public static final class e implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ f a;

        public e(f r1) {
            this.a = r1;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            Object r3 = r2.getAnimatedValue();
            if (r3 == null) goto L7;
            float r4 = ((Float) r3).floatValue();
            this.a.setAlpha(r4);
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    static {
    }

    public final void c() {
        if (this.o == false) goto L5;
        return;
    L5:
        this.o = true;
        ValueAnimator r0 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration(300);
        r0.addUpdateListener(new e(this));
        r0.setInterpolator(new com.bytedance.android.live.core.widget.e(0.0f, 0.0f, 0.58f, 1.0f));
        r0.start();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        this.s.b();
        this.p = 0;
        this.q = 0;
        super.onDetachedFromWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        View.inflate(getContext(), 2131567725, this);
        TextView r0 = (TextView) findViewById(2131378000);
        if (r0 == null) goto L5;
        r0.setText(s1.C(2131917540, new Object[]{r3.c()}));
    L5:
        setOnClickListener(new c(this));
        this.b = findViewById(2131381411);
        this.c = (TextView) findViewById(2131381483);
        this.d = (TextView) findViewById(2131368015);
        this.p = 0;
        this.q = 0;
        LinkGuestSendGiftView r1 = findViewById(2131381478);
        this.l = r1;
        if (r1 != null) goto L8;
    L12:
        LinkGuestSendGiftView r2 = this.l;
        if (r2 == null) goto L15;
        r2.setOnClickListener(new d(this));
    L15:
        DataCenter r3 = this.j;
        if (r3 == null) goto L30;
        IRoom r4 = (IRoom) r3.get("data_room", vh7.f.c(IRoom.class));
        if (r4 == null) goto L30;
        if (r4.isThirdParty() == false) goto L30;
        if (((Boolean) this.j.get("data_is_portrait", Boolean.FALSE)).booleanValue() == false) goto L30;
        TextView r5 = this.c;
        if (r5 == null) goto L26;
        r5.setTextSize(9.0f);
    L26:
        LinkGuestSendGiftView r6 = this.l;
        if (r6 == null) goto L29;
        r6.c(UtilityKotlinExtentionsKt.i(8));
    L29:
        UIUtils.updateLayout(this.l, -3, UtilityKotlinExtentionsKt.i(9));
        UIUtils.updateLayoutMargin(this.l, 0, -3, -3, -3);
        UIUtils.updateLayoutMargin(findViewById(2131375516), UtilityKotlinExtentionsKt.i(2), -3, UtilityKotlinExtentionsKt.i(2), -3);
    L30:
        this.f = findViewById(2131381476);
        this.e = findViewById(2131390752);
        this.g = findViewById(2131377999);
        this.i = (TextView) findViewById(2131377998);
        this.h = findViewById(2131377997);
        this.s.a(this);
        B3(true);
        IKtvService r7 = jc1.k.f(IKtvService.class);
        if (r7 == null) goto L35;
        com.bytedance.live.datacontext.k r8 = r7.ktvComponentSingerChangedEvent();
        if (r8 == null) goto L35;
        ((ObservableSubscribeProxy) r8.onEvent().as(AutoDispose.bind(this))).subscribe(new b(this));
    L35:
        IKtvService r9 = jc1.k.f(IKtvService.class);
        if (r9 == null) goto L38;
        za r10 = r9.ktvCurrentSingerOrderInfo();
    L39:
        d(r10);
        return;
    L38:
        r10 = null;
        goto L39
    L8:
        if (this.m == false) goto L10;
        int r11 = 0;
    L11:
        r1.setVisibility(r11);
        goto L12
    L10:
        r11 = 8;
        goto L11
    }

    public final ge0.b getPresenter() {
        return this.s;
    }

    @Override // ge0.c
    public final void B3(boolean r2) {
        View r0 = this.b;
        if (r0 == null) goto L9;
        if (r2 == false) goto L6;
        int r3 = 4;
    L7:
        r0.setVisibility(r3);
        return;
    L6:
        r3 = 0;
        goto L7
    }

    public final void a(View r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        removeView(this.a);
        r3.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        Unit r0 = Unit.INSTANCE;
        this.a = r3;
        ViewParent r4 = r3.getParent();
        if (r4 != null) goto L7;
    L9:
        addView(this.a, 0);
        return;
    L7:
        if ((r4 instanceof ViewGroup) == false) goto L9;
        ((ViewGroup) r4).removeView(this.a);
        goto L9
    }

    public final void d(za r5) {
        IBaseUser r0 = this.s.e();
        if (r0 == null) goto L5;
        String r1 = r0.getIdString();
    L6:
        if (r5 == null) goto L10;
        Intrinsics.checkNotNullParameter(r5, "$this$topUserFlex");
        b8 r6 = r5.getTopUser();
        if (r6 == null) goto L10;
        String r7 = n8.b(r6);
    L11:
        boolean r8 = Intrinsics.areEqual(r1, r7);
        KtvSeatAnimationView r2 = this.r;
        int r3 = 0;
        if (r2 == null) goto L17;
        if (r8 == true) goto L16;
        r3 = 8;
    L16:
        r2.setVisibility(r3);
        return;
    L17:
        if (r8 == false) goto L23;
        KtvSeatAnimationView r9 = new KtvSeatAnimationView(getContext(), null, 6, 0);
        this.r = r9;
        addView(r9, new FrameLayout.LayoutParams(-1, -1));
        KtvSeatAnimationView r10 = this.r;
        if (r10 == null) goto L24;
        r10.setVisibility(0);
        return;
    L24:
        return;
    L23:
        return;
    L10:
        r7 = null;
        goto L11
    L5:
        r1 = null;
        goto L6
    }

    @Override // ge0.c
    public final void i4(String r2) {
        LinkGuestSendGiftView r0 = this.l;
        if (r0 == null) goto L9;
        r0.b(r2);
        if (r0.f == false) goto L10;
        r0.setVisibility(0);
        return;
    L10:
        return;
    }

    @Override // ge0.c
    public final void mN(ILinkPlayerInfoBridge r11) {
        if (r11 == null) goto L65;
        IBaseUser r0 = r11.getUser();
        za r1 = null;
        if (r0 == null) goto L6;
        String r2 = r0.getRealNickName();
    L8:
        if (r2 == null) goto L10;
        int r3 = r2.length();
    L12:
        if (r3 < 5) goto L17;
        if (r2 == null) goto L15;
        CharSequence r4 = r2.subSequence(0, 5);
    L16:
        r2 = Intrinsics.stringPlus((String) r4, "...");
        goto L17
    L15:
        r4 = null;
    L17:
        TextView r5 = this.c;
        if (r5 == null) goto L21;
        r5.setText(r2);
    L21:
        if (r11.isHost() == false) goto L25;
        View r6 = this.e;
        if (r6 == null) goto L28;
        r6.setVisibility(0);
    L28:
        this.n = r11.isHost();
        DataCenter r7 = this.j;
        boolean r8 = true;
        if (r7 == null) goto L33;
        Boolean r9 = (Boolean) r7.get("data_support_send_gift_to_official_channel_host", Boolean.TRUE);
        if (r9 == null) goto L33;
        boolean r10 = r9.booleanValue();
    L35:
        if (this.n == false) goto L37;
        setIsOpenSendGift(r10);
    L37:
        com.bytedance.live.datacontext.m r12 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r12 == null) goto L40;
        IRoom r13 = (IRoom) r12.getValue();
    L41:
        if (r13 != null) goto L43;
    L55:
        r8 = false;
    L56:
        if (r8 == true) goto L58;
    L60:
        IKtvService r14 = jc1.k.f(IKtvService.class);
        if (r14 == null) goto L63;
        r1 = r14.ktvCurrentSingerOrderInfo();
    L63:
        d(r1);
        return;
    L58:
        if ((getChildAt(0) instanceof com.bytedance.android.live.liveinteract.widget.widget.f) == true) goto L60;
        Context r15 = getContext();
        IBaseUser r16 = r11.getUser();
        Intrinsics.checkNotNull(r16);
        a(new com.bytedance.android.live.liveinteract.widget.widget.f(r15, r16));
        goto L60
    L43:
        if (r13.getStreamType() != LiveMode.THIRD_PARTY) goto L45;
        boolean r17 = true;
    L47:
        if (IStreamUrlExtraKt.getHeightFlex(r13.getStreamUrlExtraSafely()) >= IStreamUrlExtraKt.getWidthFlex(r13.getStreamUrlExtraSafely())) goto L49;
        boolean r18 = true;
    L50:
        boolean r19 = TextUtils.equals(r13.getAnchorAbValue("live_pc_helper_new_layout"), "1");
        if (r17 == false) goto L55;
        if (r18 == false) goto L55;
        if (r19 == false) goto L55;
    L49:
        r18 = false;
        goto L50
    L45:
        r17 = false;
        goto L47
    L40:
        r13 = null;
    L33:
        r10 = true;
        goto L35
    L25:
        View r20 = this.e;
        if (r20 == null) goto L28;
        r20.setVisibility(8);
        goto L28
    L10:
        r3 = 0;
        goto L12
    L6:
        r2 = null;
        goto L8
    }

    public final void setIsOpenSendGift(boolean r3) {
        if (this.n == false) goto L10;
        DataCenter r4 = this.j;
        if (r4 == null) goto L9;
        Boolean r5 = (Boolean) r4.get("data_support_send_gift_to_official_channel_host", Boolean.TRUE);
        if (r5 == null) goto L9;
        r3 = r5.booleanValue();
    L9:
        r3 = true;
    L10:
        LinkGuestSendGiftView r0 = this.l;
        if (r0 != null) goto L13;
        this.m = r3;
        return;
    L13:
        if (r0 == null) goto L17;
        r0.setAllowSendGift(r3);
        return;
    }

    public final void setMicRoomHost(boolean r1) {
        this.n = r1;
    }

    @Override // ge0.c
    public void setVisibility(boolean r1) {
        if (r1 == false) goto L4;
        int r2 = 0;
    L5:
        setVisibility(r2);
        return;
    L4:
        r2 = 4;
        goto L5
    }

    @Override // ge0.c
    public final void Rr(long r6, long r8) {
        if (this.s.g() == true) goto L5;
    L13:
        this.p = r6;
        if (r6 != 0) goto L22;
        TextView r7 = this.d;
        if (r7 == null) goto L18;
        r7.setText("");
    L18:
        TextView r9 = this.d;
        if (r9 == null) goto L34;
        r9.setVisibility(8);
        return;
    L34:
        return;
    L22:
        long r0 = r6 - r8;
        this.q = r0;
        if (r0 >= 0) goto L25;
        this.q = 0;
    L25:
        b(false, Long.valueOf(r8));
        TextView r1 = this.d;
        if (r1 == null) goto L28;
        r1.setText(p6.a(this.q));
    L28:
        TextView r2 = this.d;
        if (r2 == null) goto L31;
        r2.setVisibility(0);
    L31:
        this.s.h(this.q);
        ALogger.i("ttlive_link_paid", "updateCountDown remaining=" + this.q + " expectLeave=" + r6 + " current=" + r8);
        return;
    L5:
        if (hd0.c.f().h() == true) goto L13;
        TextView r10 = this.d;
        if (r10 == null) goto L9;
        r10.setText("");
    L9:
        TextView r11 = this.d;
        if (r11 == null) goto L33;
        r11.setVisibility(8);
        return;
    }

    public final void b(boolean r6, Long r7) {
        if (this.s.g() == true) goto L5;
        return;
    L5:
        if (hd0.c.f().h() == false) goto L16;
        long r0 = this.q;
        if (r0 != 1) goto L17;
        if (r6 == false) goto L10;
        int r8 = fj0.d.a;
        fj0.d.b(r0, this.p);
    L11:
        com.bytedance.android.live.liveinteract.plantform.base.e.l0.getClass();
        com.bytedance.android.live.liveinteract.plantform.base.e r9 = com.bytedance.android.live.liveinteract.plantform.base.e.a.a();
        if (r9 == null) goto L18;
        r9.F3("limit_time_up");
        return;
    L18:
        return;
    L10:
        int r10 = fj0.d.a;
        fj0.d.a(r0, this.p, r7);
        goto L11
    L17:
        return;
    }

    public f(FragmentActivity r2, ge0.b r3, DataCenter r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "presenter");
        super(r2);
        this.s = r3;
        this.j = r4;
        this.m = true;
    }
}
