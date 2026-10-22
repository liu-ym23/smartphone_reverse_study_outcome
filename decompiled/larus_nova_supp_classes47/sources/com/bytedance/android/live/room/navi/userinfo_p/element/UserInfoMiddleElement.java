package com.bytedance.android.live.room.navi.userinfo_p.element;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.s4;
import com.bytedance.android.live.core.utils.JsonUtil;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.x;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.room.navi.userinfo_p.element.base.BaseElement;
import com.bytedance.android.live.room.navi.userinfo_p.presenter.UserInfoNamePresenter;
import com.bytedance.android.live.room.navi.userinfo_p.presenter.UserInfoTabPresenter;
import com.bytedance.android.live.room.navi.userinfo_p.viewmodel.ElementMiddleVM;
import com.bytedance.android.livesdk.b1;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.o0;
import com.bytedance.android.livesdk.config.UserInfoWidgetDebugConfig;
import com.bytedance.android.livesdk.interactivity.api.settings.config.u;
import com.bytedance.android.livesdk.j1;
import com.bytedance.android.livesdk.popup.manager.LivePopupWindow;
import com.bytedance.android.livesdk.utils.w0;
import com.bytedance.android.livesdk.widget.r;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.AnchorTabLabel;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.RoomAvator;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.LiveMemLeakConfig;
import com.bytedance.android.logsdk.format.Spm;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.utility.SharedPrefHelper;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.ss.alog.middleware.ALogService;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
import r52.b4;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/room/navi/userinfo_p/element/UserInfoMiddleElement;", "Lcom/bytedance/android/live/room/navi/userinfo_p/element/base/BaseElement;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "a", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UserInfoMiddleElement extends BaseElement implements Observer<KVData> {
    public static final /* synthetic */ int r = 0;
    public final String d;
    public boolean e;
    public com.bytedance.android.livesdk.user.e f;
    public Disposable g;
    public UserInfoNamePresenter h;
    public UserInfoTabPresenter i;
    public ValueAnimator j;
    public TextView k;
    public TextView l;
    public final CompositeDisposable m;
    public LivePopupWindow n;
    public final ViewGroup o;
    public final ViewGroup p;
    public final TextView q;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.element.base.BaseElement
    public final void f() {
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.element.base.BaseElement
    public final void h() {
        super.h();
        UserInfoNamePresenter r0 = new UserInfoNamePresenter(this.c, this.o);
        if (r0.d() == true) goto L5;
    L7:
        r0.f = (TextView) r0.n.findViewById(2131392049);
    L9:
        if (UIUtils.getScreenWidth(r0.e.getContext()) >= r0.i) goto L14;
        TextView r1 = r0.f;
        if (r1 == null) goto L14;
        r1.setMaxWidth(r0.j);
    L14:
        if (r.b() == false) goto L18;
        TextView r2 = r0.f;
        if (r2 == null) goto L21;
        r2.setMinWidth(s1.f(26.0f));
    L21:
        Unit r3 = Unit.INSTANCE;
        this.h = r0;
        UserInfoTabPresenter r4 = new UserInfoTabPresenter(this.c, this.o, this.q);
        vlc.d r5 = r4.b;
        if (r5 == null) goto L25;
        r5.addMessageListener(MessageType.UPDATE_FAN_TICKET_MESSAGE.getIntType(), r4);
    L25:
        if (((Boolean) com.bytedance.android.live.misc.e.a.getValue()).booleanValue() == false) goto L29;
        vlc.d r6 = r4.b;
        if (r6 == null) goto L29;
        r6.addMessageListener(MessageType.LIKE_MESSAGE.getIntType(), r4);
    L29:
        boolean r7 = true;
        if (r4.c == true) goto L32;
    L52:
        r4.k = (ViewGroup) r4.C.findViewById(2131372828);
        r4.g = r4.C.findViewById(2131388645);
        r4.h = (TextView) r4.C.findViewById(2131388644);
        r4.i = (TextView) r4.C.findViewById(2131388646);
        r4.j = (TextView) r4.C.findViewById(2131388643);
        r4.l = (TextView) r4.C.findViewById(2131372119);
        this.i = r4;
        this.k = (TextView) this.p.findViewById(2131362273);
        this.l = (TextView) this.p.findViewById(2131362272);
        if (((Boolean) com.bytedance.android.live.misc.c.a.getValue()).booleanValue() == true) goto L55;
        return;
    L55:
        if (this.c.isAnchor() == true) goto L57;
        return;
    L57:
        if (a0.g(this.c.getDataCenter()) == true) goto L83;
        ViewGroup r8 = this.o;
        if (r8 == null) goto L61;
        r8.setOnClickListener(new w0(UserInfoMiddleElement$onInit$3.INSTANCE, 1000));
    L61:
        xs1.a r9 = (xs1.a) com.bytedance.android.live.misc.d.a.getValue();
        if (r9 != null) goto L64;
    L68:
        r7 = false;
    L69:
        if (r7 == false) goto L84;
        SharedPrefHelper r10 = SharedPrefHelper.b(this.c.getContext());
        if (r10.f("live.pred.PREF_ANCHOR_BIZ_PABEL_POPUP", false) == false) goto L73;
        return;
    L73:
        if (this.c.a() == false) goto L86;
        ViewGroup r12 = this.o;
        if (r12 == null) goto L77;
        r12.postDelayed(new l(this, r10), 15000);
    L77:
        ViewGroup r13 = this.o;
        if (r13 == null) goto L87;
        r13.postDelayed(new m(this), 22000);
        return;
    L87:
        return;
    L86:
        return;
    L84:
        return;
    L64:
        if (r9.a() == true) goto L68;
        if (r9.c() == false) goto L68;
    L83:
        return;
    L32:
        if (((u) b4.a.getValue()).a() == false) goto L52;
        MiddlewareRoomContext.a r14 = MiddlewareRoomContext.Companion;
        MiddlewareRoomContext r15 = MiddlewareRoomContext.a.c(r14, r4.a(), 0, 2);
        Disposable r16 = null;
        if (r15 == null) goto L36;
        r16 = o0.b(r15, "WebcastLikeMessage", r4.z, null);
    L36:
        r4.x = r16;
        MiddlewareRoomContext r17 = MiddlewareRoomContext.a.c(r14, r4.a(), 0, 2);
        if (r17 == null) goto L52;
        com.bytedance.live.datacontext.n r18 = r17.getRtcRoomInfo();
        if (r18 == null) goto L52;
        dh1.a r19 = (dh1.a) r18.getValue();
        if (r19 == null) goto L43;
        long r20 = r19.a;
    L45:
        if (r20 <= 0) goto L47;
        boolean r22 = true;
    L48:
        r4.y = r22;
        if (r22 == false) goto L51;
        r4.n();
        com.ss.ugc.live.sdk.platform.a.f.d("WebcastUpdateFanTicketMessage", r4.A);
    L51:
        r4.w = r18.a().subscribe(new com.bytedance.android.live.room.navi.userinfo_p.presenter.g(r18, r4));
        goto L52
    L47:
        r22 = false;
        goto L48
    L43:
        r20 = 0;
        goto L45
    L18:
        TextView r23 = r0.f;
        if (r23 == null) goto L21;
        r23.setMinWidth(r0.k);
        goto L21
    L5:
        if (r.b() == false) goto L7;
        UIUtils.setViewVisibility(r0.n.findViewById(2131392049), 8);
        UIUtils.setViewVisibility(r0.n.findViewById(2131392056), 0);
        r0.f = (TextView) r0.n.findViewById(2131392053);
        r0.g = r0.n.findViewById(2131392073);
        goto L9
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.element.base.BaseElement
    public final void i() {
        super.i();
        if (isAnchor() == false) goto L5;
    L7:
        boolean r0 = false;
    L8:
        this.e = r0;
        this.f = (com.bytedance.android.livesdk.user.e) getDataCenter().get("data_user_center");
        this.c.getDataCenter().observe("data_xt_followed_change", this).observe("cmd_user_info_sub_title_anim", this).observe("data_top_left_label", this);
        if (isAnchor() == true) goto L26;
        com.bytedance.android.livesdk.user.e r1 = this.f;
        if (r1 == null) goto L26;
        IRoom r2 = getRoom();
        if (r2 == null) goto L16;
        String r3 = r2.getOwnerUserIdString();
        if (r3 == null) goto L16;
    L17:
        Observable r4 = r1.u0(r3);
        if (r4 == null) goto L26;
        Observable r5 = r4.subscribeOn(Schedulers.io());
        if (r5 == null) goto L26;
        Observable r6 = r5.observeOn(AndroidSchedulers.mainThread());
        if (r6 == null) goto L26;
        Disposable r7 = r6.subscribe(new i(this), RxUtil.getNoOpThrowable());
        if (r7 == null) goto L26;
        this.m.add(r7);
    L16:
        r3 = DataType.FALSE;
    L26:
        ElementMiddleVM r8 = b().getMiddleVm();
        m(r8.getUserNameLayoutMaxWidthPx().a(), new UserInfoMiddleElement$initVm$$inlined$run$lambda$1(this));
        m(r8.getUserNameLayoutCurWidthPx().a(), new UserInfoMiddleElement$initVm$$inlined$run$lambda$2(this));
        m(r8.getOnFollowCanceled().onEvent(), new UserInfoMiddleElement$initVm$$inlined$run$lambda$3(this));
        m(r8.getOnFollowSuccess().onEvent(), new UserInfoMiddleElement$initVm$$inlined$run$lambda$4(this));
        m(r8.getUserNameViewVisibility().a(), new UserInfoMiddleElement$initVm$$inlined$run$lambda$5(this));
        m(r8.getUserNameLayoutRightMarginDP().a(), new UserInfoMiddleElement$initVm$$inlined$run$lambda$6(this));
        m(r8.getRenderEmpty().onEvent(), new UserInfoMiddleElement$initVm$$inlined$run$lambda$7(this));
        m(r8.getShowProfileViewAnim().onEvent(), new UserInfoMiddleElement$initVm$$inlined$run$lambda$8(this));
        Disposable r9 = r8.getAppointmentMessage().a().observeOn(AndroidSchedulers.mainThread()).subscribe(new j(this), k.a);
        if (r9 == null) goto L30;
        this.m.add(r9);
        return;
    L30:
        return;
    L5:
        if (isPortrait() == false) goto L7;
        r0 = true;
        goto L8
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.element.base.BaseElement
    public final void j() {
        super.j();
        UserInfoTabPresenter r0 = this.i;
        if (r0 == null) goto L8;
        com.bytedance.android.live.room.navi.userinfo.cert.d<?> r2 = r0.n;
        if (r2 == null) goto L7;
        r2.b();
    L7:
        r0.n = null;
    L8:
        UserInfoTabPresenter r1 = this.i;
        if (r1 == null) goto L14;
        u32.d r3 = r1.m;
        if (r3 == null) goto L13;
        r3.c();
    L13:
        r1.m = null;
    L14:
        this.m.clear();
        ValueAnimator r4 = this.j;
        if (r4 == null) goto L17;
        r4.cancel();
    L17:
        this.j = null;
        this.o.setVisibility(0);
        this.o.setAlpha(1.0f);
        Disposable r5 = this.g;
        if (r5 == null) goto L20;
        r5.dispose();
    L20:
        UserInfoNamePresenter r6 = this.h;
        if (r6 == null) goto L23;
        r6.e();
    L23:
        UserInfoTabPresenter r7 = this.i;
        if (r7 == null) goto L27;
        r7.e();
    L27:
        if (((LiveMemLeakConfig) j1.a.getValue()).getFixUserInfo() == false) goto L30;
        this.c.getDataCenter().removeObserver(this);
        return;
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.element.base.BaseElement
    public final void k() {
        super.k();
        if (isAnchor() == false) goto L7;
        UserInfoNamePresenter r0 = this.h;
        if (r0 == null) goto L7;
        r0.h((int) UIUtils.dip2Px(getContext(), 4.0f));
    L7:
        UserInfoTabPresenter r1 = this.i;
        Integer r2 = null;
        if (r1 == null) goto L32;
        vlc.d r3 = r1.b;
        if (r3 == null) goto L13;
        r3.addMessageListener(MessageType.UPDATE_FAN_TICKET_MESSAGE.getIntType(), r1);
    L13:
        if (((Boolean) com.bytedance.android.live.misc.e.a.getValue()).booleanValue() == false) goto L17;
        vlc.d r4 = r1.b;
        if (r4 == null) goto L17;
        r4.addMessageListener(MessageType.LIKE_MESSAGE.getIntType(), r1);
    L17:
        IRoom r5 = r1.b();
        if (r5 == null) goto L24;
        IBaseUser r6 = r5.getOwner();
        if (r6 == null) goto L24;
        py.j r7 = r6.getFollowInfo();
        if (r7 == null) goto L24;
        long r8 = r7.getFollowerCount();
    L25:
        r1.o = r8;
        TextView r9 = r1.l;
        if (r9 == null) goto L32;
        Context r10 = r1.e.getContext();
        if (r10 == null) goto L30;
        String r12 = r10.getString(2131911612, new Object[]{x.b(r1.o)});
    L31:
        r9.setText(r12);
        goto L32
    L30:
        r12 = null;
    L24:
        r8 = 0;
    L32:
        UserInfoNamePresenter r13 = this.h;
        if (r13 == null) goto L36;
        r13.i(Boolean.FALSE);
    L36:
        if (isPortrait() == false) goto L54;
        UserInfoNamePresenter r14 = this.h;
        if (r14 == null) goto L54;
        Context r15 = r14.e.getContext();
        if (r15 == null) goto L49;
        Resources r16 = r15.getResources();
        if (r16 == null) goto L49;
        if (r14.c == false) goto L47;
        int r17 = 2131167728;
    L48:
        int r18 = r16.getDimensionPixelSize(r17);
    L50:
        ViewGroup r19 = r14.n;
        r19.setPadding(r19.getPaddingLeft(), r14.n.getPaddingTop(), 0, r14.n.getPaddingBottom());
        if (((Boolean) s4.a.getValue()).booleanValue() == false) goto L53;
        r14.e.b().getMiddleVm().getUserNameLayoutCurWidthPx().setValue(Integer.valueOf(r18));
        goto L54
    L53:
        r14.n.getLayoutParams().width = r18;
        ViewGroup r20 = r14.n;
        r20.setLayoutParams(r20.getLayoutParams());
        goto L54
    L47:
        r17 = 2131167727;
    L49:
        r18 = 0;
    L54:
        UserInfoTabPresenter r22 = this.i;
        if (r22 != null) goto L57;
    L98:
        UserInfoNamePresenter r23 = this.h;
        if (r23 == null) goto L101;
        UIUtils.setViewVisibility(r23.f, 0);
    L101:
        UserInfoTabPresenter r24 = this.i;
        if (r24 == null) goto L116;
        int r25 = com.bytedance.android.live.room.navi.userinfo.util.a.a;
        g81.g r26 = g81.g.a;
        if (((UserInfoWidgetDebugConfig) r26.getValue()).isDebug() == false) goto L106;
        int r27 = ((UserInfoWidgetDebugConfig) r26.getValue()).getAnchorTabType();
    L109:
        Integer r28 = Integer.valueOf(r27);
    L111:
        int r29 = r24.k(r28);
        String r30 = r24.f;
        StringBuilder r32 = new StringBuilder("filter server anchor tab type; server_value=");
        IRoom r33 = r24.b();
        if (r33 == null) goto L114;
        r2 = Integer.valueOf(r33.getAnchorTabType());
    L114:
        r32.append(r2);
        r32.append(", local_value=");
        r32.append(r29);
        ALogService.iSafely(r30, r32.toString());
        r24.p(Integer.valueOf(r29));
        return;
    L106:
        IRoom r34 = r24.b();
        if (r34 == null) goto L110;
        r27 = r34.getAnchorTabType();
        goto L109
    L110:
        r28 = null;
        goto L111
    L116:
        return;
    L57:
        if (r22.b() != null) goto L59;
    L86:
        Spm.Companion.getClass();
        Spm r35 = Spm.a.a("a100.c100.d100");
        IRoom r36 = r22.b();
        String r37 = "";
        if (r36 == null) goto L90;
        String r38 = r36.getOwnerUserIdString();
        if (r38 == null) goto L90;
    L91:
        Spm r39 = r35.anchorId(r38);
        IRoom r40 = r22.b();
        if (r40 == null) goto L97;
        String r42 = r40.getIdStr();
        if (r42 == null) goto L97;
        r37 = r42;
    L97:
        sw2.a.b(r39.roomId(r37).aliasAppend("init_user_info_canceled").reason("room or datacenter is null").e(), r22.f);
    L90:
        r38 = "";
        goto L91
    L59:
        if (r22.a() == null) goto L86;
        boolean r43 = r22.c();
        TextView r44 = r22.h;
        int r45 = 8;
        if (r43 == false) goto L64;
        int r46 = 0;
    L65:
        UIUtils.setViewVisibility(r44, r46);
        TextView r47 = r22.i;
        if (r43 == false) goto L68;
        int r48 = 0;
    L69:
        UIUtils.setViewVisibility(r47, r48);
        TextView r49 = r22.j;
        if (r43 == false) goto L72;
        int r50 = 8;
    L73:
        UIUtils.setViewVisibility(r49, r50);
        View r52 = r22.g;
        if (r43 == false) goto L76;
        r45 = 0;
    L76:
        UIUtils.setViewVisibility(r52, r45);
        if (r43 == false) goto L98;
        if (r22.c == true) goto L98;
        TextView r53 = r22.h;
        if (r53 == null) goto L83;
        r53.setTextColor(ColorProtector.parseColor("#b3ffffff"));
    L83:
        TextView r54 = r22.i;
        if (r54 == null) goto L98;
        r54.setTextColor(ColorProtector.parseColor("#b3ffffff"));
        goto L98
    L72:
        r50 = 0;
        goto L73
    L68:
        r48 = 8;
        goto L69
    L64:
        r46 = 8;
        goto L65
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.element.base.BaseElement
    public final String g() {
        return this.d;
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.element.base.BaseElement
    public final void l(IRoom r2) {
        super.l(r2);
        UserInfoNamePresenter r3 = this.h;
        if (r3 == null) goto L6;
        r3.i(Boolean.TRUE);
        return;
    }

    public final void onChanged(Object r9) {
        KVData r10 = (KVData) r9;
        if (this.c.a() == false) goto L110;
        if (r10 != null) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r10.getKey()) == true) goto L122;
        String r0 = r10.getKey();
        int r1 = r0.hashCode();
        String r2 = null;
        if (r1 == (-777370727)) goto L93;
        if (r1 == 598143771) goto L33;
        if (r1 == 1102839345) goto L16;
        return;
    L16:
        if (r0.equals("data_xt_followed_change") == false) goto L112;
        Long r12 = (Long) r10.getData();
        if (r12 == null) goto L124;
        long r3 = r12.longValue();
        UserInfoTabPresenter r13 = this.i;
        if (r13 == null) goto L23;
        r13.o = r3;
    L23:
        if (r13 == null) goto L113;
        Context r4 = getContext();
        if (r4 == null) goto L27;
        r2 = r4.getString(2131911612, new Object[]{x.b(r3)});
    L27:
        if (r2 == null) goto L125;
        TextView r14 = r13.l;
        if (r14 == null) goto L114;
        r14.setText(r2);
        return;
    L114:
        return;
    L125:
        return;
    L113:
        return;
    L124:
        return;
    L112:
        return;
    L33:
        if (r0.equals("data_top_left_label") == false) goto L116;
        String r15 = (String) r10.getData();
        if (r15 == null) goto L126;
        ALogger.i(this.d, "label change content: ".concat(r15));
        Integer r5 = 9;
        JSONObject r6 = new JSONObject(r15);     // Catch: JSONException -> L90
        String r16 = r6.optString("after_poi_name");     // Catch: JSONException -> L90
        long r7 = r6.optLong("after_poi_id");     // Catch: JSONException -> L90
        if (r7 > 0) goto L41;
    L43:
        if (r7 > 0) goto L45;
        int r17 = com.bytedance.android.live.room.navi.userinfo_p.utils.a.a;     // Catch: JSONException -> L90
        int r18 = com.bytedance.android.live.room.navi.userinfo_p.utils.a.b(r6, getRoom());     // Catch: JSONException -> L90
        UserInfoTabPresenter r8 = this.i;     // Catch: JSONException -> L90
        if (r8 == null) goto L67;
        r5 = Integer.valueOf(r8.k(Integer.valueOf(r18)));     // Catch: JSONException -> L90
    L68:
        IRoom r19 = getRoom();     // Catch: JSONException -> L90
        if (r19 == null) goto L71;
        r19.setAnchorTabType(r18);     // Catch: JSONException -> L90
    L71:
        IRoom r20 = getRoom();     // Catch: JSONException -> L90
        if (r20 == null) goto L74;
        Intrinsics.checkNotNullParameter(r6, "contentJson");     // Catch: JSONException -> L90
        r20.setAnchorTabLabel((AnchorTabLabel) JsonUtil.parse(r6.optString("anchor_tab_label"), AnchorTabLabel.class));     // Catch: JSONException -> L90
    L74:
        UserInfoTabPresenter r22 = this.i;     // Catch: JSONException -> L90
        if (r22 == null) goto L80;
        com.bytedance.android.live.room.navi.userinfo.cert.d<?> r23 = r22.n;     // Catch: JSONException -> L90
        if (r23 == null) goto L79;
        r23.b();     // Catch: JSONException -> L90
    L79:
        r22.n = null;     // Catch: JSONException -> L90
    L80:
        UserInfoTabPresenter r24 = this.i;     // Catch: JSONException -> L90
        if (r24 == null) goto L86;
        u32.d r25 = r24.m;     // Catch: JSONException -> L90
        if (r25 == null) goto L85;
        r25.c();     // Catch: JSONException -> L90
    L85:
        r24.m = null;     // Catch: JSONException -> L90
    L86:
        UserInfoTabPresenter r26 = this.i;     // Catch: JSONException -> L90
        if (r26 == null) goto L118;
        r26.p(r5);     // Catch: JSONException -> L90
        return;
    L118:
        return;
    L67:
        r5 = null;
        goto L68
    L45:
        if (((Boolean) com.bytedance.android.live.misc.g.a.getValue()).booleanValue() == false) goto L51;
        IRoom r27 = getRoom();     // Catch: JSONException -> L90
        if (r27 == null) goto L54;
        RoomAvator r28 = gb2.b.c(r27);     // Catch: JSONException -> L90
        if (r28 == null) goto L54;
        r28.getSecondTabLabel();     // Catch: JSONException -> L90
    L54:
        IRoom r29 = getRoom();     // Catch: JSONException -> L90
        if (r29 == null) goto L59;
        RoomAvator r30 = gb2.b.c(r29);     // Catch: JSONException -> L90
        if (r30 == null) goto L59;
        AnchorTabLabel r32 = r30.getSecondTabLabel();     // Catch: JSONException -> L90
    L60:
        if (r32 == null) goto L62;
        r32.setContent(r16);     // Catch: JSONException -> L90
    L62:
        if (r32 == null) goto L74;
        r32.setKey(String.valueOf(r7));     // Catch: JSONException -> L90
    L59:
        r32 = null;
        goto L60
    L51:
        IRoom r33 = getRoom();     // Catch: JSONException -> L90
        if (r33 == null) goto L54;
        r33.getAnchorTabLabel();     // Catch: JSONException -> L90
        goto L54
    L41:
        if (((Boolean) b1.a.getValue()).booleanValue() == false) goto L43;
        ALogger.i(this.d, "block poi update");     // Catch: JSONException -> L90
        return;
    L90:
        e = move-exception;
        ALogger.e(this.d, e);
        return;
    L126:
        return;
    L116:
        return;
    L93:
        if (r0.equals("cmd_user_info_sub_title_anim") == false) goto L120;
        com.bytedance.android.livesdk.model.b1 r34 = (com.bytedance.android.livesdk.model.b1) r10.getData();
        if (r34 == null) goto L121;
        Disposable r35 = this.g;
        if (r35 != null) goto L99;
    L104:
        UserInfoTabPresenter r36 = this.i;
        if (r36 == null) goto L107;
        r2 = r36.w(r34.a, r34.b, r34.c);
    L107:
        this.g = r2;
        return;
    L99:
        if ((!r35.isDisposed()) == true) goto L102;
        r35 = null;
    L102:
        if (r35 == null) goto L104;
        r35.dispose();
        goto L104
    L121:
        return;
    L120:
        return;
    L122:
        return;
    }

    public UserInfoMiddleElement(m91.d r2, ViewGroup r3, ViewGroup r4, TextView r5) {
        Intrinsics.checkNotNullParameter(r2, "userInfoAbility");
        Intrinsics.checkNotNullParameter(r3, "mUserNameLayout");
        Intrinsics.checkNotNullParameter(r4, "mAddTicketLayout");
        Intrinsics.checkNotNullParameter(r5, "mNameAreaTempAnimSubTitleView");
        super(r2);
        this.o = r3;
        this.p = r4;
        this.q = r5;
        this.d = "UserInfoMiddleElement";
        this.m = new CompositeDisposable();
    }
}
