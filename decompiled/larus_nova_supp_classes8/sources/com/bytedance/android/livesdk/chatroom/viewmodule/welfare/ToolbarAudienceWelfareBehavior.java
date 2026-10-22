package com.bytedance.android.livesdk.chatroom.viewmodule.welfare;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.room.api.messagewindow.service.IMsgWindowService;
import com.bytedance.android.livesdk.TTLiveSDKContext;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.utils.SkinLoadResultType;
import com.bytedance.android.livesdk.chatroom.utils.SkinLoader;
import com.bytedance.android.livesdk.chatroom.utils.a4;
import com.bytedance.android.livesdk.chatroom.utils.y2;
import com.bytedance.android.livesdk.chatroom.viewmodel.IAnimationScheduler;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.g2;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.chatroom.viewmodule.welfare.utils.WelfareAppLogger;
import com.bytedance.android.livesdk.config.py0;
import com.bytedance.android.livesdk.config.qy0;
import com.bytedance.android.livesdk.config.ty0;
import com.bytedance.android.livesdk.message.model.e3;
import com.bytedance.android.livesdk.message.model.tn;
import com.bytedance.android.livesdk.schema.interfaces.ILiveActionHandler;
import com.bytedance.android.livesdk.utils.f1;
import com.bytedance.android.livesdk.vscore_api.paid.PaidSceneEnum;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.WelfareProjectInfo;
import com.bytedance.android.livesdkapi.room.handler.toolbar.ResKeyEnum;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.interfaces.DraweeController;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/welfare/ToolbarAudienceWelfareBehavior;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/c0$b;", "Lvlc/l;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ToolbarAudienceWelfareBehavior implements c0.b, vlc.l, Observer<KVData> {
    public View a;
    public DataCenter b;
    public RoomContext c;
    public Disposable d;
    public Disposable e;
    public View f;
    public HSImageView g;
    public HSImageView h;
    public View i;
    public Disposable j;
    public CompositeDisposable k;
    public ToolbarAudienceWelfareBehavior$registerAnimation$1 l;
    public v m;
    public SkinLoader n;
    public boolean o;
    public com.bytedance.android.live.room.api.messagewindow.builder.card.c p;
    public final int q;
    public final int r;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ DraweeController a;

        public a(AbstractDraweeController r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            Long r2 = (Long) r1;
            DraweeController r3 = this.a;
            if (r3 == null) goto L8;
            Animatable r4 = r3.getAnimatable();
            if (r4 == null) goto L9;
            r4.start();
            return;
        L9:
            return;
        }
    }

    public static final class b implements a4 {
        public final /* synthetic */ ToolbarAudienceWelfareBehavior a;

        public b(ToolbarAudienceWelfareBehavior r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.livesdk.chatroom.utils.a4
        public final void a(Disposable r2) {
            RxUtilKt.c(r2, this.a.k);
        }

        @Override // com.bytedance.android.livesdk.chatroom.utils.a4
        public final void b(SkinLoadResultType r1, String r2) {
            Intrinsics.checkNotNullParameter(r1, "result");
            Intrinsics.checkNotNullParameter(r1, "result");
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ ToolbarAudienceWelfareBehavior a;
        public final /* synthetic */ boolean b;

        public c(ToolbarAudienceWelfareBehavior r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            v r0 = this.a.m;
            boolean r1 = false;
            if (r0 == null) goto L5;
            yt2.b.b("landscape resetAndShowWelfareProjectCard: dismissWithAnim: false");
            WelfareLandscapeCardWindow r2 = r0.a;
            r2.n = false;
            r2.dismiss();
        L5:
            v r3 = this.a.m;
            if (r3 == null) goto L20;
            boolean r4 = this.b;
            yt2.b.b("landscape resetAndShowWelfareProjectCard: showWithAnim: " + r4);
            if (yt2.b.a().booleanValue() == true) goto L10;
        L16:
            if (r1 == true) goto L18;
            yt2.b.b("can not show");
            return;
        L18:
            WelfareLandscapeCardWindow r5 = r3.a;
            r5.n = r4;
            r5.show();
            return;
        L10:
            if (z.e(r3.b, false) == true) goto L16;
            if (qy0.a.getValue().j() == false) goto L16;
            if (com.bytedance.android.livesdk.vscore_api.paidlive.c.a.b(com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(r3.b), PaidSceneEnum.PAID_ROOM, 2) == false) goto L16;
            r1 = true;
            goto L16
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ ToolbarAudienceWelfareBehavior a;
        public final /* synthetic */ View b;

        public d(ToolbarAudienceWelfareBehavior r1, View r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r2) {
            IBaseUser r3 = (IBaseUser) r2;
            this.a.d(this.b);
        }
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Bh(ToolbarButton r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Mr(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Y6() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void dv(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ com.bytedance.android.livesdk.reddot.a h7() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void setAlpha(float r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ boolean showRedDot() {
        return false;
    }

    public final String a() {
        int r0 = g2.a;
        if (g2.b(Boolean.valueOf(z.e(this.b, false))) == false) goto L5;
        String r1 = LiveCommonConstants.assembleTosObjectUrl("obj/live-ios-resource/welfare_normal_new.webp");
    L7:
        if (((Boolean) ev1.q.d.getValue()).booleanValue() == false) goto L10;
        r1 = "https://p3-webcast.douyinpic.com/obj/webcast/live_toolbar_ic_v2_welfare_effect_guide_3.webp";
    L10:
        if (this.o == true) goto L12;
        return r1;
    L12:
        SkinLoader r2 = this.n;
        if (r2 != null) goto L17;
        return null;
    L17:
        return r2.b(y2.a(ResKeyEnum.GUIDE_ANIM_ICON, r1));
    L5:
        r1 = qy0.a.getValue().c();
        goto L7
    }

    public final void b() {
        if (Intrinsics.areEqual(ty0.a.getValue(), Boolean.TRUE) == false) goto L8;
        com.bytedance.android.live.room.api.messagewindow.builder.card.c r0 = this.p;
        if (r0 == null) goto L31;
        r0.b();
        return;
    L31:
        return;
    L8:
        DataCenter r1 = this.b;
        if (r1 == null) goto L11;
        boolean r2 = z.m(r1, true);
    L12:
        DataCenter r3 = this.b;
        if (r3 == null) goto L15;
        boolean r4 = z.e(r3, false);
    L16:
        if (r2 == true) goto L22;
        if (r4 == true) goto L22;
        v r5 = this.m;
        if (r5 == null) goto L32;
        yt2.b.b("landscape resetAndShowWelfareProjectCard: dismissWithAnim: false");
        WelfareLandscapeCardWindow r6 = r5.a;
        r6.n = false;
        r6.dismiss();
        return;
    L32:
        return;
    L22:
        yt2.b.b("hideWelfareProjectCard");
        xs2.b r7 = xs2.b.a();
        int[] r8 = new int[2];
        View r9 = this.a;
        if (r9 == null) goto L25;
        r9.getLocationOnScreen(r8);
    L25:
        View r10 = this.a;
        if (r10 == null) goto L28;
        int r11 = r10.getWidth();
    L29:
        r7.post(new w(false, true, r8, r11));
        return;
    L28:
        r11 = 0;
        goto L29
    L15:
        r4 = false;
        goto L16
    L11:
        r2 = true;
        goto L12
    }

    public final void c() {
        HSImageView r0 = this.g;
        if (r0 == null) goto L5;
        DraweeController r1 = r0.getController();
    L6:
        if (r1 == null) goto L8;
        return;
    L8:
        AbstractDraweeController r2 = g(a(), this.g, ToolbarAudienceWelfareBehavior$initAnimatedIcon$controller$1.INSTANCE, ToolbarAudienceWelfareBehavior$initAnimatedIcon$controller$2.INSTANCE);
        HSImageView r3 = this.g;
        if (r3 == null) goto L11;
        r3.setVisibility(0);
    L11:
        View r4 = this.f;
        if (r4 == null) goto L14;
        r4.setVisibility(8);
    L14:
        IAnimationScheduler.M0.getClass();
        if (IAnimationScheduler.Companion.b() == false) goto L17;
        return;
    L17:
        qy0 r5 = qy0.a;
        if (r5.getValue().a() <= 0) goto L21;
        com.bytedance.android.live.core.utils.rxutils.j.a r6 = com.bytedance.android.live.core.utils.rxutils.j.a;
        this.j = com.bytedance.android.live.core.utils.rxutils.j.a(r5.getValue().a(), r5.getValue().a(), TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(r2));
        return;
    L21:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void e() {
        DataCenter r0 = this.b;
        Object r2 = null;
        if (r0 == null) goto L9;
        Object r1 = r0.get("key_welfare_report_icon_show", null);
        if ((r1 instanceof Boolean) == false) goto L8;
        r2 = r1;
    L8:
        r2 = (Boolean) r2;
    L9:
        Boolean r3 = Boolean.TRUE;
        if ((!Intrinsics.areEqual(r2, r3)) == false) goto L16;
        DataCenter r4 = this.b;
        if (r4 == null) goto L14;
        r4.put("key_welfare_report_icon_show", r3);
    L14:
        com.bytedance.android.livesdk.log.u.l().d("livesdk_user_welfare_show", new Object[]{am2.x.class, Room.class});
        return;
    }

    public final void i() {
        yt2.b.b("showAudienceWelfareToolbar");
        if (com.bytedance.android.livesdk.config.setting.s.b() == false) goto L5;
        return;
    L5:
        y3.m(this.b).c(ToolbarButton.WELFARE.extended());
        e();
    }

    public ToolbarAudienceWelfareBehavior() {
        this.q = 1;
        this.r = 4;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void SY(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r6) {
        Boolean r1 = null;
        if (r6 == null) goto L22;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L6
        Object r3 = Result.constructor-impl(GsonHelper.get().fromJson(r6.d, WelfareProjectInfo.class));     // Catch: Throwable -> L6
    L9:
        if (Result.isFailure-impl(r3) == false) goto L11;
        r3 = null;
    L11:
        WelfareProjectInfo r4 = (WelfareProjectInfo) r3;
        if (r4 == null) goto L22;
        if (r4.isValid() == false) goto L22;
        e();
        RoomContext r5 = this.c;
        if (r5 == null) goto L20;
        com.bytedance.live.datacontext.n r7 = r5.getWelfareProjectInfo();
        if (r7 == null) goto L20;
        r7.setValue(r4);
    L20:
        f(true);
    L6:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
    L22:
        if (this.o == false) goto L58;
        SkinLoader.c.getClass();
        SkinLoader r9 = SkinLoader.a.e(r6);
        this.n = r9;
        View r10 = this.f;
        if (r10 == null) goto L26;
        r9.c(y2.a(ResKeyEnum.STATIC_ICON, 2131251201), r10, new b(this));
    L26:
        RoomContext r11 = this.c;
        if (r11 == null) goto L33;
        com.bytedance.live.datacontext.m r12 = r11.getRoom();
        if (r12 == null) goto L33;
        Room r13 = (Room) r12.getValue();
        if (r13 == null) goto L33;
        WelfareProjectInfo r14 = r13.welfareProjectInfo;
    L34:
        qy0 r15 = qy0.a;
        if (r15.getValue().h() == true) goto L37;
        View r16 = this.f;
        if (r16 == null) goto L62;
        r16.setVisibility(0);
        return;
    L62:
        return;
    L37:
        if (r15.getValue().j() == true) goto L39;
        c();
        return;
    L39:
        if (r14 != null) goto L41;
    L42:
        c();
    L43:
        DataCenter r17 = this.b;
        if (r17 == null) goto L46;
        r17.observe("data_live_welfare_component_show", this);
    L46:
        DataCenter r18 = this.b;
        if (r18 == null) goto L50;
        r1 = (Boolean) r18.get("data_live_welfare_component_show", Boolean.FALSE);
    L50:
        if (Intrinsics.areEqual(r1, Boolean.TRUE) == false) goto L60;
        h(true);
        return;
    L60:
        return;
    L41:
        if (r14.isValid() == true) goto L43;
    L33:
        r14 = null;
        goto L34
    }

    public final void d(View r6) {
        long r3 = 0;
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, this.b, 0, 2);
        if (r0 == null) goto L27;
        com.bytedance.live.datacontext.n r1 = r0.getWelfareProjectInfo();
        if (r1 == null) goto L28;
        WelfareProjectInfo r2 = (WelfareProjectInfo) r1.getValue();
        if (r2 == null) goto L30;
        yt2.b.b("AudienceWelfareBehavior Open: url: " + r2.get_welfareDetailPageUrl());
        if (TextUtils.isEmpty(r2.get_welfareDetailPageUrl()) == true) goto L18;
        Uri r4 = UriProtector.parse(WelfareAppLogger.b(r2.get_welfareDetailPageUrl()));
        ILiveActionHandler r5 = jc1.k.f(ILiveActionHandler.class);
        if (r5 == null) goto L14;
        r5.handle(r6.getContext(), r4);
    L14:
        DataCenter r7 = this.b;
        boolean r8 = true;
        if (r7 == null) goto L17;
        r8 = z.m(r7, true);
    L17:
        WelfareAppLogger.i(r8);
    L18:
        DataCenter r9 = this.b;
        if (r9 == null) goto L23;
        Long r10 = (Long) r9.get("data_live_welfare_donation_click_count", 0L);
        if (r10 == null) goto L23;
        r3 = r10.longValue();
    L23:
        DataCenter r11 = this.b;
        if (r11 == null) goto L29;
        r11.put("data_live_welfare_donation_click_count", Long.valueOf(r3 + 1));
        return;
    L29:
        return;
    L30:
        return;
    L28:
        return;
    }

    public final void f(boolean r8) {
        if (Intrinsics.areEqual(ty0.a.getValue(), Boolean.TRUE) == false) goto L5;
        return;
    L5:
        DataCenter r0 = this.b;
        if (r0 == null) goto L8;
        boolean r1 = z.m(r0, true);
    L9:
        DataCenter r2 = this.b;
        int r3 = 0;
        if (r2 == null) goto L12;
        boolean r4 = z.e(r2, false);
    L13:
        if (r1 == true) goto L19;
        if (r4 == true) goto L19;
        View r5 = this.a;
        if (r5 == null) goto L44;
        r5.post(new c(this, r8));
        return;
    L44:
        return;
    L19:
        yt2.b.b("resetAndShowWelfareProjectCard: showWithAnim: " + r8);
        xs2.b r6 = xs2.b.a();
        int[] r7 = new int[2];
        View r9 = this.a;
        if (r9 == null) goto L22;
        r9.getLocationOnScreen(r7);
    L22:
        View r10 = this.a;
        if (r10 == null) goto L25;
        int r11 = r10.getWidth();
    L26:
        r6.post(new w(false, false, r7, r11));
        xs2.b r12 = xs2.b.a();
        int[] r13 = new int[2];
        View r14 = this.a;
        if (r14 == null) goto L29;
        r14.getLocationOnScreen(r13);
    L29:
        View r15 = this.a;
        if (r15 == null) goto L32;
        r3 = r15.getWidth();
    L32:
        r12.post(new w(true, r8, r13, r3));
        RoomContext r16 = this.c;
        if (r16 == null) goto L45;
        com.bytedance.live.datacontext.n r17 = r16.getWelfareProjectInfo();
        if (r17 == null) goto L46;
        WelfareProjectInfo r18 = (WelfareProjectInfo) r17.getValue();
        if (r18 == null) goto L47;
        Disposable r19 = this.d;
        if (r19 == null) goto L42;
        r19.dispose();
    L42:
        this.d = Observable.timer(Math.max(r18.get_showFrequency(), 1), TimeUnit.MINUTES).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.livesdk.chatroom.viewmodule.welfare.c(this));
        return;
    L47:
        return;
    L46:
        return;
    L45:
        return;
    L25:
        r11 = 0;
        goto L26
    L12:
        r4 = false;
        goto L13
    L8:
        r1 = true;
        goto L9
    }

    public final void h(final boolean r5) {
        HSImageView r0 = this.g;
        if (r0 == null) goto L5;
        r0.setVisibility(8);
    L5:
        HSImageView r1 = this.h;
        if (r1 == null) goto L8;
        r1.setVisibility(0);
    L8:
        if (r5 == false) goto L22;
        int r2 = g2.a;
        if (g2.b(Boolean.valueOf(z.e(this.b, false))) == false) goto L12;
        String r3 = LiveCommonConstants.assembleTosObjectUrl("obj/live-ios-resource/welfare_card_out_new.webp");
    L14:
        if (((Boolean) ev1.q.d.getValue()).booleanValue() == false) goto L17;
        r3 = "https://p3-webcast.douyinpic.com/obj/webcast/live_toolbar_ic_v2_welfare_effect_link_card_out_2.webp";
    L17:
        if (this.o == false) goto L36;
        SkinLoader r4 = this.n;
        if (r4 == null) goto L35;
        r3 = r4.b(y2.a(ResKeyEnum.INTRO_CARD_SHOW_ANIM, r3));
    L35:
        r3 = null;
    L36:
        g(r3, this.h, new ToolbarAudienceWelfareBehavior$setOutOrInAnimated$1(this), new ToolbarAudienceWelfareBehavior$setOutOrInAnimated$2(r5));
        return;
    L12:
        r3 = qy0.a.getValue().d();
        goto L14
    L22:
        int r6 = g2.a;
        if (g2.b(Boolean.valueOf(z.e(this.b, false))) == false) goto L25;
        r3 = LiveCommonConstants.assembleTosObjectUrl("obj/live-ios-resource/welfare_card_back_new.webp");
    L27:
        if (((Boolean) ev1.q.d.getValue()).booleanValue() == false) goto L30;
        r3 = "https://p3-webcast.douyinpic.com/obj/webcast/live_toolbar_ic_v2_welfare_effect_link_card_in_2.webp";
    L30:
        if (this.o == false) goto L36;
        SkinLoader r7 = this.n;
        if (r7 == null) goto L35;
        r3 = r7.b(y2.a(ResKeyEnum.INTRO_CARD_HIDE_ANIM, r3));
        goto L36
    L25:
        r3 = qy0.a.getValue().b();
        goto L27
    }

    public final void j(View r5) {
        if (TTLiveSDKContext.getHostService().h().isLogin() == true) goto L6;
        com.bytedance.android.livesdk.user.f r0 = TTLiveSDKContext.getHostService().h();
        Context r1 = r5.getContext();
        com.bytedance.android.livesdk.user.l.a r2 = new com.bytedance.android.livesdk.user.l.a();
        r2.a = s1.B(2131915990);
        r2.d = "welfare_live";
        r2.c = -1;
        this.e = r0.login(r1, new com.bytedance.android.livesdk.user.l(r2)).subscribe(new d(this, r5));
        return;
    L6:
        d(r5);
    }

    public final void onChanged(Object r4) {
        KVData r5 = (KVData) r4;
        if (r5 == null) goto L5;
        String r0 = r5.getKey();
    L6:
        if (r0 != null) goto L9;
        return;
    L9:
        if (r0.hashCode() == 2147375792) goto L12;
        return;
    L12:
        if (r0.equals("data_live_welfare_component_show") == false) goto L15;
        h(Intrinsics.areEqual((Boolean) r5.getData(), Boolean.TRUE));
        return;
    L15:
        return;
    L5:
        r0 = null;
        goto L6
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (py0.a.getValue().booleanValue() == true) goto L7;
        j(r2);
        return;
    L7:
        if (f1.a(r2.getId()) == false) goto L9;
        return;
    L9:
        j(r2);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void onHide(boolean r2) {
        RoomContext r3 = this.c;
        if (r3 == null) goto L7;
        com.bytedance.live.datacontext.n r4 = r3.getWelfareProjectInfo();
        if (r4 == null) goto L7;
        r4.setValue(null);
    L7:
        b();
    }

    public final void onMessage(tlc.d r4) {
        if (r4 != null) goto L5;
        return;
    L5:
        if ((r4 instanceof tn) == false) goto L45;
        tn r5 = (tn) r4;
        int r0 = r5.getOpType();
        if (r0 == 1) goto L32;
        if (r0 != 2) goto L11;
        RoomContext r1 = this.c;
        if (r1 == null) goto L30;
        com.bytedance.live.datacontext.n r2 = r1.getWelfareProjectInfo();
        if (r2 == null) goto L30;
        r2.setValue(r5.E());
    L30:
        f(false);
        return;
    L11:
        if (r0 == 3) goto L14;
        return;
    L14:
        if (com.bytedance.android.livesdk.config.setting.s.b() == true) goto L51;
        RoomContext r6 = this.c;
        if (r6 == null) goto L21;
        com.bytedance.live.datacontext.n r7 = r6.getWelfareProjectInfo();
        if (r7 == null) goto L21;
        r7.setValue(null);
    L21:
        b();
        yt2.b.b("hideAudienceWelfareToolbar");
        if (com.bytedance.android.livesdk.config.setting.s.b() == true) goto L52;
        y3.m(this.b).i(ToolbarButton.WELFARE.extended());
        return;
    L52:
        return;
    L51:
        return;
    L32:
        if (com.bytedance.android.livesdk.config.setting.s.b() == true) goto L53;
        RoomContext r3 = this.c;
        if (r3 == null) goto L39;
        com.bytedance.live.datacontext.n r8 = r3.getWelfareProjectInfo();
        if (r8 == null) goto L39;
        r8.setValue(r5.E());
    L39:
        WelfareProjectInfo r9 = r5.E();
        if (r9 != null) goto L42;
        return;
    L42:
        if (r9.isValid() != true) goto L49;
        f(true);
        i();
        return;
    L49:
        return;
    L53:
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void R9(View r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        IAnimationScheduler.M0.getClass();
        if (IAnimationScheduler.Companion.b() == false) goto L10;
        ToolbarAudienceWelfareBehavior$registerAnimation$1 r4 = this.l;
        if (r4 == null) goto L9;
        IAnimationScheduler r0 = IAnimationScheduler.Companion.a(this.b);
        if (r0 == null) goto L9;
        r0.unRegisterListener(r4);
    L9:
        this.l = null;
    L10:
        r3.removeObserver("data_live_welfare_component_show", this);
        Disposable r5 = this.d;
        if (r5 == null) goto L13;
        r5.dispose();
    L13:
        Disposable r6 = this.e;
        if (r6 == null) goto L16;
        r6.dispose();
    L16:
        Disposable r7 = this.j;
        if (r7 == null) goto L19;
        r7.dispose();
    L19:
        v r8 = this.m;
        if (r8 == null) goto L22;
        r8.a.dismiss();
    L22:
        com.bytedance.android.live.room.api.messagewindow.builder.card.c r9 = this.p;
        if (r9 == null) goto L25;
        r9.b();
    L25:
        com.bytedance.android.live.room.api.messagewindow.builder.card.c r10 = this.p;
        if (r10 == null) goto L28;
        r10.a.a();
    L28:
        CompositeDisposable r11 = this.k;
        if (r11 == null) goto L32;
        r11.clear();
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void p4(View r7, DataCenter r8) {
        Intrinsics.checkNotNullParameter(r7, "view");
        Intrinsics.checkNotNullParameter(r8, "dataCenter");
        this.k = new CompositeDisposable();
        SkinLoader.c.getClass();
        this.o = SkinLoader.a.b();
        this.a = r7;
        this.b = r8;
        this.c = RoomContext.a.c(RoomContext.Companion, r8, 0, 2);
        DataCenter r0 = this.b;
        if (r0 != null) goto L5;
    L9:
        this.f = r7.findViewById(2131387276);
        this.g = r7.findViewById(2131362952);
        this.h = r7.findViewById(2131362954);
        this.i = r7.findViewById(2131392581);
        int r1 = g2.a;
        if (g2.b(Boolean.valueOf(z.e(r8, false))) == false) goto L15;
        g2.a(this.a);
        g2.a(r7.findViewById(2131393165));
        g2.a(this.f);
        View r9 = this.f;
        if (r9 == null) goto L15;
        r9.setBackgroundResource(2131251201);
    L15:
        if (z.e(r8, false) == false) goto L17;
    L21:
        RoomContext r10 = this.c;
        if (r10 == null) goto L26;
        com.bytedance.live.datacontext.j r11 = r10.getMessageManager();
        if (r11 == null) goto L26;
        r11.c(new ToolbarAudienceWelfareBehavior$onLoad$2(this));
    L26:
        RoomContext r12 = this.c;
        if (r12 == null) goto L33;
        com.bytedance.live.datacontext.m r13 = r12.getRoom();
        if (r13 == null) goto L33;
        Room r14 = (Room) r13.getValue();
        if (r14 == null) goto L33;
        WelfareProjectInfo r15 = r14.welfareProjectInfo;
    L34:
        StringBuilder r2 = new StringBuilder("ToolbarAudienceWelfareBehavior onLoad, has valid project: ");
        if (r15 != null) goto L37;
    L39:
        boolean r4 = false;
    L40:
        r2.append(r4);
        yt2.b.b(r2.toString());
        if (r15 != null) goto L43;
    L56:
        yt2.b.b("hideAudienceWelfareToolbar");
        if (com.bytedance.android.livesdk.config.setting.s.b() == true) goto L61;
        y3.m(this.b).i(ToolbarButton.WELFARE.extended());
    L61:
        if (this.o == true) goto L78;
        qy0 r3 = qy0.a;
        if (r3.getValue().h() == true) goto L65;
        View r16 = this.f;
        if (r16 == null) goto L78;
        r16.setVisibility(0);
        goto L78
    L65:
        if (r3.getValue().j() == true) goto L67;
        c();
        goto L78
    L67:
        if (r15 != null) goto L69;
    L70:
        c();
    L71:
        r8.observe("data_live_welfare_component_show", this);
        if (((Boolean) r8.get("data_live_welfare_component_show", Boolean.FALSE)).booleanValue() == false) goto L78;
        h(true);
        goto L78
    L69:
        if (r15.isValid() == true) goto L71;
    L78:
        if ((!Intrinsics.areEqual(ty0.a.getValue(), Boolean.TRUE)) == true) goto L92;
        q71.a r17 = jc1.k.n(IMsgWindowService.class).cardStateDispatcher(this.b);
        e3 r18 = new e3();
        r18.areaType = Integer.valueOf(this.q);
        r18.areaSubType = Integer.valueOf(this.r);
        Unit r5 = Unit.INSTANCE;
        q71.d r19 = q71.a.a.a(r17, r18);
        if (r19 == null) goto L87;
        Observable r20 = r19.a();
        if (r20 == null) goto L87;
        Disposable r21 = r20.subscribe(new com.bytedance.android.livesdk.chatroom.viewmodule.welfare.a(this));
        if (r21 == null) goto L87;
        RxUtilKt.c(r21, this.k);
    L87:
        Disposable r22 = xs2.b.a().b(u71.a.class).subscribe(new com.bytedance.android.livesdk.chatroom.viewmodule.welfare.b(this));
        if (r22 == null) goto L91;
        RxUtilKt.c(r22, this.k);
        return;
    L91:
        return;
    L92:
        return;
    L43:
        if (r15.isValid() != true) goto L56;
        if (com.bytedance.android.livesdk.config.setting.s.b() == true) goto L55;
        xs2.b r6 = xs2.b.a();
        int[] r23 = new int[2];
        View r24 = this.a;
        if (r24 == null) goto L50;
        r24.getLocationOnScreen(r23);
    L50:
        View r25 = this.a;
        if (r25 == null) goto L53;
        int r26 = r25.getWidth();
    L54:
        r6.post(new w(true, true, r23, r26));
        goto L55
    L53:
        r26 = 0;
    L55:
        i();
        goto L61
    L37:
        if (r15.isValid() != true) goto L39;
        r4 = true;
    L33:
        r15 = null;
        goto L34
    L17:
        if (((Boolean) ev1.q.d.getValue()).booleanValue() == false) goto L21;
        View r27 = this.f;
        if (r27 == null) goto L21;
        r27.setBackgroundResource(2131243773);
        goto L21
    L5:
        if (z.m(r0, true) == true) goto L9;
        if (z.e(r0, false) == true) goto L9;
        this.m = new v(r8);
        goto L9
    }

    public static AbstractDraweeController g(String r1, HSImageView r2, Function0 r3, Function2 r4) {
        if (r2 != null) goto L4;
        return null;
    L4:
        if (TextUtils.isEmpty(r1) == true) goto L10;
        AbstractDraweeController r5 = Fresco.newDraweeControllerBuilder().setUri(r1).setControllerListener(new com.bytedance.android.livesdk.chatroom.viewmodule.welfare.d(r3, r4)).setAutoPlayAnimations(true).build();
        r2.setController(r5);
        return r5;
    L10:
        return null;
    }
}
