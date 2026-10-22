package com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.banner.BannerWidget;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.ui.LiveAvatarCircleView;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.ui.LiveAvatarViewAnimManager;
import com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.MultiLinkVoiceBaseGuestLinkWidget;
import com.bytedance.android.live.liveinteract.utils.c1;
import com.bytedance.android.live.liveinteract.videotalk.MultiLinkVideoTalkRoomGuestWidget;
import com.bytedance.android.live.liveinteract.view.MarqueeTextView;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.revenue.platform.network.api.INetworkService;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.chatroom.model.AudienceLeaveSourceEnum;
import com.bytedance.android.livesdk.chatroom.model.IAudienceLeaveInfoResponse;
import com.bytedance.android.livesdk.chatroom.model.LinkmicAudienceRecommendItem;
import com.bytedance.android.livesdk.chatroom.model.g1;
import com.bytedance.android.livesdk.chatroom.model.u1;
import com.bytedance.android.livesdk.config.d60;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdk.utils.u6;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerKickOutContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerSysKickOutContent;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.TypesJVMKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/liveinteract/chatroom/chatroom/dialog/LinkResultDialogFragmentV2;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "<init>", "()V", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LinkResultDialogFragmentV2 extends LiveDialogFragment {
    public static final String r = null;
    public static final long s = 0;
    public static final long t = 0;
    public static final a u = null;
    public Map<Integer, View> d;
    public final CompositeDisposable e;
    public long f;
    public long g;
    public String h;
    public String i;
    public int j;
    public BannerWidget.a k;
    public int l;
    public LinkmicAudienceRecommendItem m;
    public ExtraResponse<IAudienceLeaveInfoResponse, Extra> n;
    public final LiveAvatarViewAnimManager o;
    public Boolean p;
    public BannerWidget q;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static LinkResultDialogFragmentV2 a(g1 r7, AudienceLeaveSourceEnum r8, BannerWidget.a r9) {
            Intrinsics.checkNotNullParameter(r7, "leaveChannelRsp");
            Intrinsics.checkNotNullParameter(r8, "liveSource");
            String r0 = LinkResultDialogFragmentV2.r;
            StringCompanionObject r1 = StringCompanionObject.INSTANCE;
            ALogger.d(r0, String.format("newInstance, leaveChannelRsp: %s", Arrays.copyOf(new Object[]{r7}, 1)));
            LinkResultDialogFragmentV2 r2 = new LinkResultDialogFragmentV2();
            Bundle r3 = new Bundle();
            r3.putLong("KEY_LINK_DURATION", r7.getLink_duration());
            u1 r4 = r7.getUserInfoDuringLinkmic();
            long r5 = 0;
            if (r4 == null) goto L5;
            long r6 = r4.getAddFollowerCount();
        L6:
            r3.putLong("KEY_ADD_FOLLOWER_COUNT", r6);
            u1 r10 = r7.getUserInfoDuringLinkmic();
            if (r10 == null) goto L9;
            r5 = r10.getScoreBeyond();
        L9:
            r3.putLong("KEY_SCORE_BEYOND", r5);
            u1 r11 = r7.getUserInfoDuringLinkmic();
            if (r11 == null) goto L13;
            String r12 = r11.getFanTicket();
            if (r12 == null) goto L13;
        L14:
            r3.putString("KEY_FAN_TICKET", r12);
            r3.putString("KEY_LINK_LINKMIC_UNIQUE_ID", tc0.c.h().w);
            r3.putInt("KEY_LINK_LEAVE_SOURCE", r8.getValue());
            r2.setArguments(r3);
            r2.k = r9;
            return r2;
        L13:
            r12 = "0";
            goto L14
        L5:
            r6 = 0;
            goto L6
        }

        @JvmStatic
        public static LinkResultDialogFragmentV2 b(ILinkerKickOutContent r5, AudienceLeaveSourceEnum r6, MultiLinkVideoTalkRoomGuestWidget.a0 r7) {
            Intrinsics.checkNotNullParameter(r5, "kickOutContent");
            Intrinsics.checkNotNullParameter(r6, "liveSource");
            String r0 = LinkResultDialogFragmentV2.r;
            StringCompanionObject r1 = StringCompanionObject.INSTANCE;
            ALogger.d(r0, String.format("newInstance, kickOutContent: %s", Arrays.copyOf(new Object[]{r5}, 1)));
            LinkResultDialogFragmentV2 r2 = new LinkResultDialogFragmentV2();
            Bundle r3 = new Bundle();
            r3.putLong("KEY_LINK_DURATION", r5.getLink_duration());
            r3.putString("KEY_LINK_LINKMIC_UNIQUE_ID", tc0.c.h().w);
            r3.putInt("KEY_LINK_LEAVE_SOURCE", r6.getValue());
            r2.setArguments(r3);
            r2.k = r7;
            r2.l = r5.getKickOutSource();
            return r2;
        }

        @JvmStatic
        public static LinkResultDialogFragmentV2 c(LinkerSysKickOutContent r4, AudienceLeaveSourceEnum r5, MultiLinkVoiceBaseGuestLinkWidget.g r6) {
            Intrinsics.checkNotNullParameter(r4, "sysKickOutContent");
            Intrinsics.checkNotNullParameter(r5, "liveSource");
            String r0 = LinkResultDialogFragmentV2.r;
            StringCompanionObject r1 = StringCompanionObject.INSTANCE;
            ALogger.d(r0, String.format("newInstance, sysKickOutContent: %s", Arrays.copyOf(new Object[]{r4}, 1)));
            LinkResultDialogFragmentV2 r2 = new LinkResultDialogFragmentV2();
            Bundle r3 = new Bundle();
            r3.putString("KEY_LINK_LINKMIC_UNIQUE_ID", tc0.c.h().w);
            r3.putInt("KEY_LINK_LEAVE_SOURCE", r5.getValue());
            r2.setArguments(r3);
            r2.k = r6;
            r2.l = r4.getKickOutSource();
            return r2;
        }
    }

    static {
        u = new a();
        r = "LinkResultDialogFragment";
        String r0 = (String) vm2.e.g().get("fetch_delay");
        long r1 = 1000;
        if (r0 == null) goto L5;
        long r3 = CastLongProtector.parseLong(r0);
    L6:
        s = r3;
        String r2 = (String) vm2.e.g().get("recover_delay");
        if (r2 == null) goto L9;
        r1 = CastLongProtector.parseLong(r2);
    L9:
        t = r1;
        return;
    L5:
        r3 = 1000;
        goto L6
    }

    public final void V90() {
        long r2 = 60;
        if (this.f >= r2) goto L5;
        ((TextView) S90(2131390876)).setText(String.valueOf(this.f) + " 秒");
    L10:
        ((TextView) S90(2131390601)).setText(this.h);
        ((TextView) S90(2131390110)).setText(String.valueOf(this.g));
        if (((Boolean) vm2.h.H5.getValue(null, vm2.h.a[344(0x158, float:4.82E-43)])).booleanValue() == false) goto L13;
        ((TextView) S90(2131364737)).setText(s1.B(2131918729));
        return;
    L13:
        ((TextView) S90(2131364737)).setText(s1.B(2131918728));
        return;
    L5:
        TextView r0 = (TextView) S90(2131390876);
        StringBuilder r1 = new StringBuilder();
        long r4 = this.f;
        long r6 = r4 / r2;
        if ((r4 % r2) <= 0) goto L8;
        int r3 = 1;
    L9:
        r1.append(String.valueOf(r6 + ((long) r3)));
        r1.append(" 分");
        r0.setText(r1.toString());
        goto L10
    L8:
        r3 = 0;
        goto L9
    }

    public LinkResultDialogFragmentV2() {
        this.d = new LinkedHashMap();
        this.e = new CompositeDisposable();
        this.h = "0";
        this.j = AudienceLeaveSourceEnum.AudienceLeave_Unknown.getValue();
        this.o = new LiveAvatarViewAnimManager();
    }

    public final void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        this.e.clear();
    }

    public final void onDestroyView() {
        super.onDestroyView();
        this.d.clear();
    }

    public final View S90(int r3) {
        if (this.d != null) goto L5;
        this.d = new LinkedHashMap();
    L5:
        View r0 = this.d.get(Integer.valueOf(r3));
        if (r0 != null) goto L14;
        View r1 = getView();
        if (r1 == null) goto L12;
        View r2 = r1.findViewById(r3);
        if (r2 == null) goto L12;
        this.d.put(Integer.valueOf(r3), r2);
        return r2;
    L12:
        return null;
    L14:
        return r0;
    }

    public final void onActivityCreated(Bundle r5) {
        super.onActivityCreated(r5);
        Dialog r6 = getDialog();
        if (r6 == null) goto L13;
        Window r7 = r6.getWindow();
        if (r7 == null) goto L14;
        View r0 = r7.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L11;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r1 = ThreadMethodProxy.currentThread();
        if (r1 == com.larus.home.impl.utils.c.a) goto L11;
        com.larus.home.impl.utils.c.a(r1, "getDecorView");
    L11:
        r0.setPadding(0, 0, 0, 0);
        r7.setLayout(-1, -1);
        r7.setGravity(80);
        r7.setBackgroundDrawable(new ColorDrawable(0));
        r7.setSoftInputMode(48);
        c1.b(r7, 0, 14);
        return;
    L14:
        return;
    }

    public final void onCreate(Bundle r5) {
        super.onCreate(r5);
        setStyle(1, 2131954719);
        Bundle r6 = getArguments();
        if (r6 == null) goto L5;
        long r2 = r6.getLong("KEY_LINK_DURATION", 0);
    L6:
        this.f = r2;
        Bundle r7 = getArguments();
        if (r7 == null) goto L9;
        long r3 = r7.getLong("KEY_ADD_FOLLOWER_COUNT", 0);
    L10:
        this.g = r3;
        Bundle r8 = getArguments();
        if (r8 == null) goto L13;
        r8.getLong("KEY_SCORE_BEYOND", 0);
    L13:
        Bundle r9 = getArguments();
        String r0 = "0";
        if (r9 == null) goto L19;
        String r10 = r9.getString("KEY_FAN_TICKET", "0");
        if (r10 == null) goto L19;
        r0 = r10;
    L19:
        this.h = r0;
        Bundle r11 = getArguments();
        if (r11 == null) goto L22;
        String r12 = r11.getString("KEY_LINK_LINKMIC_UNIQUE_ID");
    L23:
        this.i = r12;
        Bundle r13 = getArguments();
        if (r13 == null) goto L26;
        int r14 = r13.getInt("KEY_LINK_LEAVE_SOURCE", AudienceLeaveSourceEnum.AudienceLeave_Unknown.getValue());
    L27:
        this.j = r14;
        return;
    L26:
        r14 = AudienceLeaveSourceEnum.AudienceLeave_Unknown.getValue();
        goto L27
    L22:
        r12 = null;
        goto L23
    L9:
        r3 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public static final void T90(LinkResultDialogFragmentV2 r8, int r9) {
        r8.getClass();
        int r0 = com.bytedance.android.live.liveinteract.e.a;
        Context r1 = r8.getContext();
        int r2 = d0.a;
        String r3 = d0.a(r8.j);
        String r4 = r8.i;
        String r10 = d0.b(Integer.valueOf(r8.l), r8.j);
        String r5 = String.valueOf(je0.d.a0());
        Intrinsics.checkNotNullParameter(r3, "connectionOverType");
        Intrinsics.checkNotNullParameter(r10, "connectionOverTypeDetail");
        Intrinsics.checkNotNullParameter(r5, "roomId");
        if (r1 == null) goto L28;
        Map r6 = vm2.e.g();
        Boolean r7 = (Boolean) d60.a.getValue();
        String r11 = (String) r6.get("schema");
        if (r7.booleanValue() == true) goto L8;
        String r12 = (String) r6.get("url");
        ALogger.i("LynxUtil", "showLinkResultContributionListDialog configSchema=" + r11 + ", configUrl=" + r12);
        if (r11 != null) goto L21;
        String r13 = "sslocal://webcast_lynxview?type=popup&gravity=bottom&radius=12&height=484&web_bg_color=#FFFFFF";
    L22:
        u6 r14 = new u6(r13);
        if (r12 != null) goto L25;
        r12 = "https://lf-webcast-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/webcast/mono/lynx/revenue_guest_honor_douyin/pages/guest_contributor_rank_list/template.js?initialProps=[\"current_user\",\"current_room\",\"linkmic\"]";
    L25:
        r14.b("url", r12);
        u6 r15 = r14.d("url");
        r15.b("connection_over_type", r3);
        r15.b("connection_over_type_detail", r10);
        r15.b("linkmic_unique_id", r4);
        u6 r16 = r14;
    L26:
        ALogger.i("LynxUtil", "LinkResult# configSchema:" + r11 + ", scheme:" + r16.c());
        jc1.k.n(IBaseLiveActionHandler.class).handle(r1, r16.c());
        return;
    L21:
        r13 = r11;
        goto L22
    L8:
        if (r9 != 1) goto L10;
        String r17 = "breakpage_more_icon";
    L11:
        if (r9 != 1) goto L13;
        String r18 = "data_performance";
    L14:
        if (r11 != null) goto L16;
        String r19 = "sslocal://webcast_redirect?entry=anchor_review_v4&gravity=bottom&height_percent=66&type=popup";
    L17:
        r16 = new u6(r19 + "&url_query=" + URLEncoder.encode("menu=after&role_type=2&tab=" + r18 + "&room_id=" + r5 + "&link_id=" + r4 + "&enter_from=" + r17, "UTF-8"));
        goto L26
    L16:
        r19 = r11;
        goto L17
    L13:
        r18 = "audience_analysis_area";
        goto L14
    L10:
        r17 = "breakpage_giftuser_icon";
        goto L11
    }

    public static final void U90(LinkResultDialogFragmentV2 r7, LinkmicAudienceRecommendItem r8) {
        ExtraResponse<IAudienceLeaveInfoResponse, Extra> r0 = r7.n;
        if (r0 == null) goto L7;
        IAudienceLeaveInfoResponse r1 = r0.data;
        if (r1 == null) goto L7;
        r1.setLinkmicAudienceRecommendItem(r8);
    L7:
        r7.m = r8;
        String r2 = null;
        if (r8 == null) goto L12;
        IBaseUser r3 = r8.getAnchor();
        if (r3 == null) goto L12;
        String r4 = r3.getRealNickName();
    L13:
        if (r4 == null) goto L60;
        UtilityKotlinExtentionsKt.w(r7.S90(2131374202));
        UtilityKotlinExtentionsKt.t(r7.S90(2131380958));
        UtilityKotlinExtentionsKt.t(r7.S90(2131374705));
        ImageView r5 = (ImageView) r7.S90(2131376540);
        if (r8 == null) goto L19;
        IBaseUser r6 = r8.getAnchor();
        if (r6 == null) goto L19;
        py.k r9 = r6.getAvatarThumbKt();
    L20:
        ImageUtil.loadRoundImage(r5, r9);
        TextView r10 = (TextView) r7.S90(2131391324);
        if (r10 == null) goto L27;
        if (r8 == null) goto L26;
        IBaseUser r11 = r8.getAnchor();
        if (r11 == null) goto L26;
        r2 = r11.getRealNickName();
    L26:
        r10.setText(r2);
    L27:
        MarqueeTextView r12 = (MarqueeTextView) r7.S90(2131391325);
        if (r12 == null) goto L30;
        r12.setFadingEdge(true);
    L30:
        MarqueeTextView r13 = (MarqueeTextView) r7.S90(2131391325);
        if (r13 == null) goto L33;
        r13.setInfinite(true);
    L33:
        MarqueeTextView r14 = (MarqueeTextView) r7.S90(2131391325);
        String r15 = "";
        if (r14 == null) goto L40;
        if (r8 == null) goto L38;
        String r16 = r8.getText();
        if (r16 == null) goto L38;
    L39:
        r14.setOriginText(r16);
    L38:
        r16 = "";
    L40:
        ((MarqueeTextView) r7.S90(2131391325)).y();
        int r17 = d0.a;
        LinkmicAudienceRecommendItem r18 = r7.m;
        if (r18 == null) goto L45;
        Long r19 = r18.getRoomId();
        if (r19 == null) goto L45;
        long r20 = r19.longValue();
    L46:
        LinkmicAudienceRecommendItem r21 = r7.m;
        if (r21 == null) goto L52;
        IBaseUser r22 = r21.getAnchor();
        if (r22 == null) goto L52;
        String r23 = r22.getIdString();
        if (r23 == null) goto L52;
    L53:
        if (r8 == null) goto L58;
        String r24 = r8.getText();
        if (r24 == null) goto L58;
        r15 = r24;
    L58:
        int r25 = r7.j;
        int r26 = r7.l;
        Intrinsics.checkNotNullParameter(r23, "toAnchorId");
        Intrinsics.checkNotNullParameter(r15, "recommond");
        HashMap r27 = new HashMap();
        r27.put("to_room_id", String.valueOf(r20));
        r27.put("to_anchor_id", r23);
        r27.put("recommend", r15);
        r27.put("connection_over_type", d0.a(r25));
        r27.put("connection_over_type_detail", d0.b(Integer.valueOf(r26), r25));
        r27.put("user_id", jc1.k.n(IMiddlewareUserService.class).user().n());
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_chatroom_audience_breakpage_room_show", r27, new Object[]{IRoom.class, am2.x.class});
        return;
    L52:
        r23 = "";
    L45:
        r20 = 0;
    L19:
        r9 = null;
        goto L20
    L60:
        return;
    L12:
        r4 = null;
        goto L13
    }

    public final void onViewCreated(View r20, Bundle r21) {
        Intrinsics.checkNotNullParameter(r20, "view");
        super.onViewCreated(r20, r21);
        V90();
        com.bytedance.live.datacontext.m r2 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r2 == null) goto L5;
        IRoom r3 = (IRoom) r2.getValue();
    L6:
        this.q = new BannerWidget(r3, 25, "chat_effect_feedback_panel", null, new v(this));
        WidgetManager.of(this, getView()).load(2131372686, this.q);
        int r1 = wb6.b.a;
        long r4 = je0.d.a0();
        String r5 = this.i;
        String r6 = "";
        if (r5 != null) goto L9;
        r5 = "";
    L9:
        int r7 = this.j;
        Intrinsics.checkNotNullParameter(r5, "linkmicUniqueId");
        an0.b r8 = an0.b.a;
        uz0.e r9 = new uz0.e();
        r8.getClass();
        Intrinsics.checkNotNullParameter(r9, "$this$beforeConfigureRequest");
        Map r10 = r9.e;
        Intrinsics.checkNotNullParameter(r10, "fieldsMap");
        String r11 = Long.valueOf(r4).toString();
        Intrinsics.checkNotNullParameter("room_id", "$this$setTo");
        if (r11 == null) goto L12;
        r10.put("room_id", r11);
    L12:
        Intrinsics.checkNotNullParameter("linkmic_unique_id", "$this$setTo");
        r10.put("linkmic_unique_id", r5);
        String r12 = Integer.valueOf(r7).toString();
        Intrinsics.checkNotNullParameter("source", "$this$setTo");
        if (r12 == null) goto L15;
        r10.put("source", r12);
    L15:
        Intrinsics.checkNotNullParameter(r9, "$this$afterConfigureRequest");
        Observable r13 = com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class).L4(INetworkService.Biz.MultiLink, "/webcast/linkmic_audience/audience_leave_info/", TypesJVMKt.getJavaType(Reflection.typeOf(IAudienceLeaveInfoResponse.class)), Extra.class, ((uz0.a) r9).d, ((uz0.a) r9).a, ((uz0.a) r9).b, ((uz0.a) r9).c, r9.e, r9.f, r9.g);
        int r14 = com.bytedance.revenue.platform.api.core.rx.p.a;
        Disposable r15 = r13.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new y(this), new z(this));
        if (r15 == null) goto L18;
        RxUtilKt.c(r15, this.e);
    L18:
        TextView r16 = (TextView) S90(2131364737);
        if (r16 == null) goto L21;
        r16.setOnClickListener(new a0(this));
    L21:
        TextView r17 = (TextView) S90(2131390868);
        if (r17 == null) goto L24;
        r17.setOnClickListener(new b0(this));
    L24:
        ((TextView) S90(2131390608)).setOnClickListener(new c0(this));
        LiveAvatarViewAnimManager r18 = this.o;
        View r19 = S90(2131376540);
        View r22 = S90(2131363712);
        ((ArrayList) r18.a).add(new LiveAvatarViewAnimManager.a((LiveAvatarCircleView) S90(2131365719), r22, r19));
        if ((!((ArrayList) r18.a).isEmpty()) == false) goto L32;
        AnimatorSet r23 = (AnimatorSet) r18.d.getValue();
        if (r23 == null) goto L29;
        r23.play((ValueAnimator) r18.e.getValue());
    L29:
        AnimatorSet r24 = (AnimatorSet) r18.d.getValue();
        if (r24 == null) goto L32;
        r24.start();
    L32:
        int r25 = d0.a;
        LinkmicAudienceRecommendItem r26 = this.m;
        if (r26 == null) goto L37;
        Long r27 = r26.getRoomId();
        if (r27 == null) goto L37;
        long r28 = r27.longValue();
    L38:
        LinkmicAudienceRecommendItem r29 = this.m;
        if (r29 == null) goto L44;
        IBaseUser r30 = r29.getAnchor();
        if (r30 == null) goto L44;
        String r31 = r30.getIdString();
        if (r31 == null) goto L44;
    L45:
        LinkmicAudienceRecommendItem r32 = this.m;
        if (r32 == null) goto L51;
        String r33 = r32.getText();
        if (r33 == null) goto L51;
        r6 = r33;
    L51:
        int r34 = this.j;
        int r35 = this.l;
        Intrinsics.checkNotNullParameter(r31, "toAnchorId");
        Intrinsics.checkNotNullParameter(r6, "recommond");
        HashMap r36 = new HashMap();
        r36.put("to_room_id", String.valueOf(r28));
        r36.put("to_anchor_id", r31);
        r36.put("recommend", r6);
        r36.put("connection_over_type", d0.a(r34));
        r36.put("connection_over_type_detail", d0.b(Integer.valueOf(r35), r34));
        r36.put("user_type", "audience");
        r36.put("user_id", jc1.k.n(IMiddlewareUserService.class).user().n());
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_chatroom_audience_breakpage_show", r36, new Object[]{IRoom.class, am2.x.class});
        RxUtilKt.c(xs2.b.a().b(hk0.b.class).subscribe(new t(this), u.a), this.e);
        return;
    L44:
        r31 = "";
    L37:
        r28 = 0;
        goto L38
    L5:
        r3 = null;
        goto L6
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return LayoutInflater.from(getContext()).inflate(2131565589, r3, false);
    }
}
