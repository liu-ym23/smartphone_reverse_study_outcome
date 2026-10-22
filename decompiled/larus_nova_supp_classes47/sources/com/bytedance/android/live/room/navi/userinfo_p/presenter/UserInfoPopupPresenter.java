package com.bytedance.android.live.room.navi.userinfo_p.presenter;

import android.graphics.drawable.NinePatchDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.ListUtils;
import com.bytedance.android.live.room.navi.userinfo_p.viewmodel.ElementMiddleVM;
import com.bytedance.android.live.room.navi.userinfo_p.viewmodel.UserInfoVM;
import com.bytedance.android.live.schema.api.WebcastRedirectException;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.utils.a3;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.message.model.RankListAwardMessage;
import com.bytedance.android.livesdk.message.model.hm;
import com.bytedance.android.livesdk.message.model.ii;
import com.bytedance.android.livesdk.message.model.o0;
import com.bytedance.android.livesdk.message.model.s5;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.message.CommonBubbleConfig;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/room/navi/userinfo_p/presenter/UserInfoPopupPresenter;", "Lcom/bytedance/android/live/room/navi/userinfo_p/presenter/BaseElementPresenter;", "Lvlc/l;", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UserInfoPopupPresenter extends BaseElementPresenter {
    public final CompositeDisposable f;
    public yo2.e g;
    public final int h;
    public final int i;
    public final int j;
    public final int k;
    public final View l;

    public static final class a implements a3.b {
        public final /* synthetic */ UserInfoPopupPresenter a;
        public final /* synthetic */ TextView b;
        public final /* synthetic */ CommonBubbleConfig c;
        public final /* synthetic */ ImageView d;
        public final /* synthetic */ View e;

        /* JADX INFO: renamed from: com.bytedance.android.live.room.navi.userinfo_p.presenter.UserInfoPopupPresenter$a$a, reason: collision with other inner class name */
        public static final class C0215a implements yo2.e.a {
            public final /* synthetic */ a a;

            /* JADX INFO: renamed from: com.bytedance.android.live.room.navi.userinfo_p.presenter.UserInfoPopupPresenter$a$a$a, reason: collision with other inner class name */
            public static final class ViewOnClickListenerC0216a implements View.OnClickListener {
                public final /* synthetic */ C0215a a;
                public final /* synthetic */ yo2.e b;

                public ViewOnClickListenerC0216a(C0215a r1, yo2.e r2) {
                    this.a = r1;
                    this.b = r2;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View r3) {
                    if (StringUtils.isEmpty(this.a.a.c.schemeUrl) == true) goto L5;
                    k.n(IBaseLiveActionHandler.class).handle(this.a.a.a.e.getContext(), this.a.a.c.schemeUrl);
                L5:
                    a r4 = this.a.a;
                    UserInfoPopupPresenter r0 = r4.a;
                    if (StringUtils.isEmpty(r4.c.eventName) == false) goto L8;
                    String r5 = "livesdk_top_bubble_guide_click";
                L9:
                    Map r1 = this.a.a.c.extra;
                    r0.getClass();
                    UserInfoPopupPresenter.h(r5, r1);
                    this.b.d();
                    return;
                L8:
                    r5 = this.a.a.c.eventName;
                    goto L9
                }
            }

            public C0215a(a r1) {
                this.a = r1;
            }

            public final void a(View r2, yo2.e r3) {
                Intrinsics.checkNotNullParameter(r2, "view");
                Intrinsics.checkNotNullParameter(r3, "popup");
                r2.setOnClickListener(new ViewOnClickListenerC0216a(this, r3));
            }
        }

        public final void onFail() {
        }

        public final void a(NinePatchDrawable r7) {
            Intrinsics.checkNotNullParameter(r7, "ninePatchDrawable");
            this.b.setText(sb2.a.f(this.c.richText, null).a);
            ImageUtil.loadImage(this.d, this.c.arrowImage, 0);
            ViewGroup.LayoutParams r8 = this.d.getLayoutParams();
            if (r8 == null) goto L10;
            FrameLayout.LayoutParams r9 = (FrameLayout.LayoutParams) r8;
            r9.leftMargin = CommonBubbleConfig.getPositionDip(this.c.arrowPosition, this.a.e.getContext());
            r9.setMarginStart(CommonBubbleConfig.getPositionDip(this.c.arrowPosition, this.a.e.getContext()));
            this.d.setLayoutParams(r9);
            UserInfoPopupPresenter r10 = this.a;
            yo2.e r2 = new yo2.e(r10.e.getContext());
            ((yo2.d) r2).d = this.e;
            ((yo2.d) r2).e = 0;
            ((yo2.d) r2).m = this.c.duration;
            r2.x = new C0215a(this);
            ((yo2.d) r2).l = true;
            r2.a();
            r10.g = r2;
            UserInfoPopupPresenter r12 = this.a;
            yo2.e r0 = r12.g;
            if (r0 == null) goto L7;
            r0.i(r12.l, 2, 0, 0, 0);
        L7:
            UserInfoPopupPresenter r13 = this.a;
            Map r1 = this.c.extra;
            r13.getClass();
            UserInfoPopupPresenter.h("livesdk_top_bubble_guide_show", r1);
            return;
        L10:
            throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        }

        public a(UserInfoPopupPresenter r1, TextView r2, CommonBubbleConfig r3, ImageView r4, View r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }
    }

    public static final class b implements yo2.e.a {
        public final /* synthetic */ UserInfoPopupPresenter a;
        public final /* synthetic */ CommonBubbleConfig b;

        public static final class a implements View.OnClickListener {
            public final /* synthetic */ b a;
            public final /* synthetic */ yo2.e b;

            public a(b r1, yo2.e r2) {
                this.a = r1;
                this.b = r2;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r3) {
                if (StringUtils.isEmpty(this.a.b.schemeUrl) == true) goto L5;
                k.n(IBaseLiveActionHandler.class).handle(this.a.a.e.getContext(), this.a.b.schemeUrl);
            L5:
                b r4 = this.a;
                UserInfoPopupPresenter r0 = r4.a;
                if (StringUtils.isEmpty(r4.b.eventName) == false) goto L8;
                String r5 = "livesdk_top_bubble_guide_click";
            L9:
                Map r1 = this.a.b.extra;
                r0.getClass();
                UserInfoPopupPresenter.h(r5, r1);
                this.b.d();
                return;
            L8:
                r5 = this.a.b.eventName;
                goto L9
            }
        }

        public b(UserInfoPopupPresenter r1, CommonBubbleConfig r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a(View r2, yo2.e r3) {
            Intrinsics.checkNotNullParameter(r2, "view");
            Intrinsics.checkNotNullParameter(r3, "popup");
            r2.setOnClickListener(new a(this, r3));
        }
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.presenter.BaseElementPresenter
    public final void e() {
        super.e();
        Disposable r0 = this.f;
        if ((!r0.isDisposed()) == true) goto L6;
        r0 = null;
    L6:
        if (r0 == null) goto L8;
        r0.dispose();
    L8:
        yo2.e r1 = this.g;
        if (r1 != null) goto L11;
        return;
    L11:
        if (r1.h() != true) goto L18;
        yo2.e r2 = this.g;
        if (r2 == null) goto L15;
        r2.d();
    L15:
        this.g = null;
        return;
    }

    public final void i(CommonBubbleConfig r10) {
        if (this.e.a() == true) goto L5;
        return;
    L5:
        if (this.e.getContext() == null) goto L11;
        if (r10 == null) goto L12;
        View r8 = LayoutInflater.from(this.e.getContext()).inflate(2131567565, null);
        TextView r0 = (TextView) r8.findViewById(2131382789);
        ImageView r7 = (ImageView) r8.findViewById(2131382770);
        int r1 = a3.d;
        a3.a.a(r0, r10.getBackgroundImageModel(), new a(this, r0, r10, r7, r8), 0.0f);
        return;
    L12:
        return;
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.presenter.BaseElementPresenter
    public final void onMessage(tlc.d r10) {
        Disposable r1 = null;
        if ((r10 instanceof o0) == true) goto L5;
        tlc.d r0 = null;
    L6:
        o0 r2 = (o0) r0;
        if (r2 != null) goto L9;
        return;
    L9:
        MessageType r3 = r2.getMessageType();
        if (r3 != MessageType.GRADE_BUFF_ANCHOR_SHARE_MESSAGE) goto L52;
        if (r10 == null) goto L50;
        s5 r12 = (s5) r10;
        if (r12.E() != null) goto L16;
        return;
    L16:
        if (this.e.a() == true) goto L18;
        return;
    L18:
        if (this.c == false) goto L172;
        Disposable r4 = this.f;
        if ((!r4.isDisposed()) == false) goto L23;
        r1 = r4;
    L23:
        if (r1 == null) goto L25;
        r1.dispose();
    L25:
        yo2.e r5 = this.g;
        if (r5 != null) goto L28;
    L32:
        a5 r6 = r12.E();
        if (r6 != null) goto L36;
        r6 = (a5) vh7.f.c(a5.class);
    L36:
        j(2131567149, new CommonBubbleConfig(r6, r12.getSchemeUrl(), this.h, "livesdk_privilege_buff_moneysplit_click"));
        int r13 = r12.getScore();
        if (r13 > 0) goto L39;
        return;
    L39:
        if (r13 < 10000) goto L41;
        String r14 = "+" + new BigDecimal((((double) r13) * 1.0d) / ((double) this.i)).setScale(2, RoundingMode.DOWN).toString() + "万";
    L42:
        a5 r7 = vh7.f.c(a5.class);
        r7.setDefaultPattern(r14);
        UserInfoVM.Companion.getClass();
        aa1.a r15 = UserInfoVM.b.b();
        if (r15 == null) goto L152;
        ElementMiddleVM r16 = r15.getMiddleVm();
        if (r16 == null) goto L153;
        com.bytedance.live.datacontext.k<y91.a> r17 = r16.getShowProfileViewAnim();
        if (r17 == null) goto L154;
        r17.post(new y91.a(this.j, this.k, r7, null));
        return;
    L154:
        return;
    L153:
        return;
    L152:
        return;
    L41:
        r14 = "+ " + r13;
        goto L42
    L28:
        if (r5.h() != true) goto L32;
        yo2.e r8 = this.g;
        if (r8 == null) goto L32;
        r8.d();
        goto L32
    L172:
        return;
    L50:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.message.model.GradeBuffAnchorShareMessage");
    L52:
        if (r3 != MessageType.TOP_LEFT_BUBBLE_MESSAGE) goto L97;
        if (r10 == null) goto L95;
        hm r18 = (hm) r10;
        if (r18.G() != null) goto L57;
        return;
    L57:
        if (this.e.a() == false) goto L173;
        CommonBubbleConfig r9 = r18.G();
        if (r9 == null) goto L69;
        if (r9.messageType != 1) goto L69;
        yo2.e r19 = this.g;
        if (r19 == null) goto L69;
        if (r19.h() != true) goto L69;
        return;
    L69:
        if (this.f.isDisposed() == true) goto L71;
        this.f.dispose();
    L71:
        yo2.e r20 = this.g;
        if (r20 != null) goto L74;
    L78:
        CommonBubbleConfig r22 = r18.G();
        if (r22 == null) goto L82;
        r22.extra = r18.getExtra();
    L82:
        if (r18.E() == false) goto L93;
        CommonBubbleConfig r23 = r18.G();
        if (r23 == null) goto L87;
        r1 = r23.richText;
    L87:
        if (ListUtils.isEmpty(sb2.a.d(r1)) == true) goto L92;
        CommonBubbleConfig r110 = r18.G();
        if (r110 == null) goto L175;
        new com.bytedance.android.live.core.utils.o0().a(sb2.a.d(r110.richText), new com.bytedance.android.live.room.navi.userinfo_p.presenter.a(this, r110));
        return;
    L175:
        return;
    L92:
        i(r18.G());
        return;
    L93:
        j(2131567565, r18.G());
        return;
    L74:
        if (r20.h() != true) goto L78;
        yo2.e r24 = this.g;
        if (r24 == null) goto L78;
        r24.d();
        goto L78
    L173:
        return;
    L95:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.message.model.TopLeftBubbleMessage");
    L97:
        if (r3 != MessageType.PROFILE_VIEW_MESSAGE) goto L127;
        if (r10 == null) goto L125;
        ii r111 = (ii) r10;
        if (this.e.a() == false) goto L105;
        if (r111.getSource() != 2) goto L105;
        this.e.b().getMiddleVm().getAppointmentMessage().setValue(r111);
        return;
    L105:
        if (r111.G() != null) goto L107;
        return;
    L107:
        if (this.e.a() == false) goto L176;
        UserInfoVM.Companion.getClass();
        aa1.a r25 = UserInfoVM.b.b();
        if (r25 == null) goto L120;
        ElementMiddleVM r26 = r25.getMiddleVm();
        if (r26 == null) goto L120;
        com.bytedance.live.datacontext.k<y91.a> r27 = r26.getShowProfileViewAnim();
        if (r27 == null) goto L120;
        long r28 = this.j;
        if (r111.getDuration() != null) goto L118;
        long r29 = 0;
    L119:
        r27.post(new y91.a(r28, r29, r111.G(), r111.E()));
        goto L120
    L118:
        r29 = r111.getDuration().longValue() * ((long) WebcastRedirectException.UNKNOWN);
    L120:
        DataCenter r30 = a();
        if (r30 == null) goto L123;
        r30.put("fans_rank_list_lottie", Boolean.TRUE);
    L123:
        Disposable r112 = Observable.timer(r111.getDuration().longValue(), TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.live.room.navi.userinfo_p.presenter.b(this));
        Intrinsics.checkNotNullParameter(r112, "disposables");
        this.a.add(r112);
        return;
    L176:
        return;
    L125:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.message.model.ProfileViewMessage");
    L127:
        if (r3 != MessageType.DAILY_RANK_AWARD) goto L163;
        if (r10 == null) goto L149;
        RankListAwardMessage r113 = (RankListAwardMessage) r10;
        if (r113.getRankType() == 100) goto L134;
        if (r113.getRankType() == 101) goto L134;
        return;
    L134:
        if (this.e.a() == true) goto L136;
        return;
    L136:
        if (this.d == true) goto L139;
        return;
    L139:
        if (r113.getRankType() != 100) goto L144;
        DataCenter r32 = a();
        if (r32 == null) goto L166;
        r32.put("fans_rank_list_award_anim", r113);
        return;
    L166:
        return;
    L144:
        if (r113.getRankType() != 101) goto L168;
        DataCenter r33 = a();
        if (r33 == null) goto L169;
        r33.put("pk_activity_award_anim", r113);
        return;
    L169:
        return;
    L168:
        return;
    L149:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.message.model.RankListAwardMessage");
    L163:
        return;
    L5:
        r0 = r10;
        goto L6
    }

    public UserInfoPopupPresenter(m91.c r2, View r3) {
        Intrinsics.checkNotNullParameter(r2, "userInfoAbility");
        Intrinsics.checkNotNullParameter(r3, "mUserHead");
        super(r2);
        this.l = r3;
        this.f = new CompositeDisposable();
        this.h = 5;
        this.i = 10000;
        this.j = 700;
        this.k = 3100;
    }

    public static void h(String r4, Map r5) {
        if (r5 != null) goto L4;
        r5 = new HashMap();
    L4:
        r5.put("user_id", k.n(IMiddlewareUserService.class).user().n().toString());
        j0.l().sendLog(r4, r5, new Object[]{IRoom.class});
    }

    public final void j(int r8, CommonBubbleConfig r9) {
        if (this.e.a() == true) goto L5;
        return;
    L5:
        if (this.e.getContext() == null) goto L11;
        if (r9 == null) goto L12;
        View r10 = LayoutInflater.from(this.e.getContext()).inflate(r8, null);
        ((TextView) r10.findViewById(2131382789)).setText(sb2.a.f(r9.richText, null).a);
        yo2.e r1 = new yo2.e(this.e.getContext());
        ((yo2.d) r1).d = r10;
        ((yo2.d) r1).e = 0;
        ((yo2.d) r1).m = r9.duration;
        r1.x = new b(this, r9);
        ((yo2.d) r1).l = true;
        r1.a();
        this.g = r1;
        r1.i(this.l, 2, 0, 0, 0);
        h("livesdk_top_bubble_guide_show", r9.extra);
        return;
    L12:
        return;
    }
}
