package com.bytedance.android.livesdk.chatroom.ui;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.adapter.binding.SwitchSettingItemBinder;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.base.model.user.UserAttr;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.room.api.IReportService;
import com.bytedance.android.live.room.api.userinfo.event.ReportConstant;
import com.bytedance.android.livesdk.TTLiveSDKContext;
import com.bytedance.android.livesdk.chatroom.LiveRoomPermission;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.RoomPermissionContext;
import com.bytedance.android.livesdk.chatroom.api.RoomRetrofitApi;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.chatroom.roommanage.LiveRoomManageAppLogger;
import com.bytedance.android.livesdk.chatroom.roommanage.blockword.BlockWordFlowController;
import com.bytedance.android.livesdk.chatroom.ui.setting.AllowAudienceRequestExplainingProducts;
import com.bytedance.android.livesdk.chatroom.ui.setting.AllowAudienceShareSettingItem;
import com.bytedance.android.livesdk.chatroom.ui.setting.BroadcastVideoWindowSettingItem;
import com.bytedance.android.livesdk.chatroom.ui.setting.BroadcastWindowSettingItem;
import com.bytedance.android.livesdk.chatroom.ui.setting.LiveRealTimePlaybackSettingItem;
import com.bytedance.android.livesdk.chatroom.ui.setting.LiveRoomCommentSettingItem;
import com.bytedance.android.livesdk.chatroom.ui.setting.ParticipateHourRankSettingItem;
import com.bytedance.android.livesdk.chatroom.ui.setting.SyncCommerceExplainingToProductDetailPage;
import com.bytedance.android.livesdk.config.ed;
import com.bytedance.android.livesdk.config.wk0;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdkapi.TTLiveService;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.pay.ITicketData;
import com.bytedance.android.livesdkapi.depend.model.live.pay.PaidLiveData;
import com.bytedance.android.livesdkapi.interfaces.ListDialogAbility;
import com.bytedance.android.livesdkapi.service.ILiveService;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class t7 extends FrameLayout implements View.OnClickListener, bf1.f, wd1.a, ListDialogAbility, re1.a {
    public final com.bytedance.android.live.core.utils.rxutils.x a;
    public boolean b;
    public final bf1.e c;
    public final ud1.a d;
    public final Room e;
    public final qe1.e f;
    public View g;
    public LiveProfileManageDialogV2.b h;
    public View i;
    public View j;
    public TextView k;
    public View l;
    public BlockWordFlowController m;
    public RecyclerView n;
    public MultiTypeAdapter o;
    public final com.bytedance.android.livesdk.chatroom.ui.setting.r p;
    public final boolean q;
    public final User r;
    public boolean s;
    public boolean t;
    public final UserProfileEvent u;
    public final Bundle v;

    public static final class a {
        public a() {
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ t7 a;

        public b(t7 r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            zg1.i1 r3 = (zg1.i1) r2;
            if (r3 == null) goto L8;
            boolean r4 = r3.b;
            t7 r0 = this.a;
            r0.getClass();
            RecyclerView r1 = r0.n;
            if (r1 == null) goto L9;
            UtilityKotlinExtentionsKt.z(r1, !r4);
            return;
        L9:
            return;
        }
    }

    static {
        new a();
    }

    public final void b() {
        com.bytedance.android.live.core.utils.f2.b(2131918822, 0);
        LiveProfileManageDialogV2.b r0 = this.h;
        if (r0 == null) goto L6;
        r0.dismissDialog();
        return;
    }

    public final void y0(td1.e r2, Exception r3) {
        Intrinsics.checkNotNullParameter(r2, "userBean");
        Intrinsics.checkNotNullParameter(r3, "exception");
    }

    private final boolean getChangeDefaultUIStyleForSaas() {
        return this.v.getBoolean("new_anchor_setting_page", false);
    }

    public final boolean d() {
        Room r0 = this.e;
        String r1 = null;
        if (r0 == null) goto L5;
        String r2 = r0.getOwnerUserIdString();
    L6:
        com.bytedance.android.livesdk.user.f r3 = TTLiveSDKContext.getHostService().h();
        if (r3 == null) goto L10;
        r1 = r3.n();
    L10:
        return Intrinsics.areEqual(r2, r1);
    L5:
        r2 = null;
        goto L6
    }

    public final void dismissDialog() {
        LiveProfileManageDialogV2.b r0 = this.h;
        if (r0 == null) goto L6;
        r0.dismissDialog();
        return;
    }

    public final MultiTypeAdapter listAdapter() {
        if (this.o != null) goto L6;
        int r0 = x8.a.a;
        x8.a.c("live_setting_items", new IllegalStateException(), false);
    L6:
        return this.o;
    }

    public final void refreshSettingItems() {
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L19;
        com.bytedance.live.datacontext.n r1 = r0.getDataCenter();
        if (r1 == null) goto L20;
        DataCenter r2 = (DataCenter) r1.getValue();
        if (r2 == null) goto L22;
        Context r3 = getContext();
        if (r3 != null) goto L12;
        return;
    L12:
        MultiTypeAdapter r4 = this.o;
        if (r4 == null) goto L15;
        r4.a = f(r3, r2);
    L15:
        MultiTypeAdapter r5 = this.o;
        if (r5 == null) goto L21;
        r5.notifyDataSetChanged();
        return;
    L21:
        return;
    L22:
        return;
    L20:
        return;
    }

    private final boolean getChangeDefaultUIStyle() {
        if (d() == true) goto L5;
    L9:
        return false;
    L5:
        if (this.q == false) goto L9;
        if (getChangeDefaultUIStyleForSaas() == false) goto L9;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.b = true;
        BlockWordFlowController r0 = this.m;
        if (r0 == null) goto L5;
        r0.k();
    L5:
        this.a.b(xs2.b.a().b(zg1.i1.class).subscribe(new b(this)));
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        if (com.bytedance.android.livesdk.chatroom.utils.b0.d() == false) goto L5;
        int r0 = LiveRoomManageAppLogger.b;
        LiveRoomManageAppLogger.d(com.bytedance.android.livesdk.chatroom.utils.b0.b(), true);
    L5:
        MultiTypeAdapter r1 = this.o;
        if (r1 == null) goto L17;
        List r2 = r1.a;
        if (r2 == null) goto L17;
        Iterator r3 = r2.iterator();
    L11:
        if (r3.hasNext() == false) goto L17;
        Object r4 = r3.next();
        if ((r4 instanceof mx.l) == false) goto L11;
        Disposable r5 = ((mx.l) r4).m;
        if (r5 == null) goto L11;
        r5.dispose();
    L17:
        this.b = false;
        bf1.e r6 = this.c;
        r6.a = null;
        r6.b.clear();
        this.f.a.clear();
        this.a.dispose();
        super.onDetachedFromWindow();
        BlockWordFlowController r7 = this.m;
        if (r7 == null) goto L28;
        r7.l();
        return;
    }

    public final void a() {
        refreshSettingItems();
    }

    public final LiveProfileManageDialogV2.b getClickCallback() {
        return this.h;
    }

    public final void N1(Exception r3) {
        Intrinsics.checkNotNullParameter(r3, "e");
        if (this.b == true) goto L5;
        return;
    L5:
        ExceptionUtils.handleException(getContext(), r3, 2131919727);
    }

    public final void c(Exception r3) {
        ExceptionUtils.handleException(getContext(), r3, 2131919727);
    }

    public final void e(String r5) {
        com.bytedance.android.livesdk.log.g r0 = com.bytedance.android.livesdk.log.u.l();
        HashMap r1 = new HashMap();
        r1.put("EVENT_ORIGIN_FEATURE", "TEMAI");
        User r2 = this.r;
        if (r2 == null) goto L5;
        String r3 = r2.getIdStr();
    L6:
        r1.put("to_user_id", String.valueOf(r3));
        r1.put("popup_title", "管理用户");
        r1.put("button_name", r5);
        Unit r6 = Unit.INSTANCE;
        r0.sendLog("livesdk_click_feedback_popup", r1, new Object[]{Room.class, am2.x.class});
        return;
    L5:
        r3 = null;
        goto L6
    }

    public final void jumpSubpage(int r2) {
        LiveProfileManageDialogV2.b r0 = this.h;
        if (r0 == null) goto L6;
        r0.onClick(r2);
        return;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r19) {
        Intrinsics.checkNotNullParameter(r19, "v");
        int r1 = r19.getId();
        String r4 = "set";
        String r5 = "cancel";
        String r6 = "0";
        User r7 = null;
        boolean r8 = true;
        if (r1 != 2131379516) goto L80;
        e(com.bytedance.android.live.core.utils.s1.B(2131919768));
        User r2 = this.r;
        Intrinsics.checkNotNull(r2);
        if (r2.getUserAttr() == null) goto L14;
        py.t r3 = this.r.getUserAttr();
        if (r3 == null) goto L9;
        Boolean r9 = Boolean.valueOf(r3.isAdmin());
    L11:
        if (r9.booleanValue() == false) goto L14;
        boolean r10 = false;
    L15:
        if (r10 == false) goto L17;
        ud1.a r11 = this.d;
        String r12 = this.r.getIdStr();
        String r13 = this.r.getCastSecUid();
        Room r14 = this.e;
        if (r14 == null) goto L57;
        User r15 = r14.getOwner();
        if (r15 == null) goto L57;
        String r16 = r15.getIdStr();
        if (r16 == null) goto L57;
        String r17 = r16;
    L58:
        Room r18 = this.e;
        long r20 = 0;
        if (r18 == null) goto L61;
        long r110 = r18.id;
    L62:
        r11.a(r10, r12, r13, r17, r110, "profile_card");
        boolean r21 = d();
        String r22 = this.r.getIdStr();
        if (r10 == true) goto L66;
        r4 = "cancel";
    L66:
        LiveRoomManageAppLogger.e(r21, r22, r4);
        Room r23 = this.e;
        if (r23 == null) goto L72;
        String r24 = r23.getOwnerUserIdString();
        if (r24 == null) goto L72;
        r6 = r24;
    L72:
        Room r25 = this.e;
        if (r25 == null) goto L75;
        r20 = r25.id;
    L75:
        if (r10 == false) goto L77;
        String r26 = "add";
    L78:
        LiveRoomManageAppLogger.x(r6, r20, r26);
        return;
    L77:
        r26 = "delete";
        goto L78
    L61:
        r110 = 0;
    L57:
        r17 = "0";
        goto L58
    L17:
        if (ed.a.getValue().booleanValue() == false) goto L38;
        Uri r27 = UriProtector.parse(wk0.a.getValue());
        String r28 = UriProtector.getQueryParameter(r27, "url");
        if (r28 != null) goto L21;
    L37:
        com.bytedance.android.live.core.utils.f2.c("操作失败", 0);
        Unit r29 = Unit.INSTANCE;
    L46:
        LiveProfileManageDialogV2.b r30 = this.h;
        if (r30 == null) goto L191;
        r30.dismissDialog();
        return;
    L191:
        return;
    L21:
        if (r28.length() > 0) goto L24;
        r8 = false;
    L24:
        if (r8 == true) goto L27;
        r28 = null;
    L27:
        if (r28 == null) goto L37;
        r7 = com.bytedance.android.live.schema.helper.h.b(UriProtector.parse(r28), "single_user_id", this.r.getIdString()).toString();     // Catch: Exception -> L30
    L31:
        if (r7 == null) goto L37;
        Uri r31 = com.bytedance.android.live.schema.helper.h.b(r27, "url", r7);
        if (r31 == null) goto L37;
        ILiveService r32 = TTLiveService.getLiveService();
        if (r32 == null) goto L46;
        r32.handleSchema(r19.getContext(), r31);
        goto L46
    L38:
        Context r33 = getContext();
        Room r34 = this.e;
        if (r34 == null) goto L41;
        r7 = r34.getOwner();
    L41:
        Bundle r111 = new Bundle();
        r111.putBoolean("new_anchor_admin_page", true);
        r111.putBoolean("new_anchor_setting_page", false);
        r111.putBoolean("is_from_live_room", true);
        LiveProfileManageDialogV2 r35 = new LiveProfileManageDialogV2(r33, r34, r7, true, true, false, null, r111, true, this.r, 96);
        if (DialogLancet.shouldBlockDialogShow(r35) == false) goto L185;
        DialogLancet.handleBlockedDialogShow(r35);
        goto L46
    L185:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L183
    L45:
        DialogLancet.beforeDialogShow(r35);
        r35.show();
        DialogLancet.afterDialogShow(r35);
        goto L46
    L9:
        r9 = null;
    L14:
        r10 = true;
        goto L15
    L80:
        if (r1 != 2131376850) goto L93;
        e(com.bytedance.android.live.core.utils.s1.B(2131915677));
        if (this.e != null) goto L84;
        return;
    L84:
        Context r36 = getContext();
        Room r37 = this.e;
        long r38 = r37.id;
        String r39 = r37.getOwnerUserIdString();
        User r40 = this.r;
        Intrinsics.checkNotNull(r40);
        hp2.a r41 = new hp2.a(r36, r38, r39, r40.getIdStr(), this.r.getCastSecUid());
        if (DialogLancet.shouldBlockDialogShow(r41) == false) goto L187;
        DialogLancet.handleBlockedDialogShow(r41);
    L89:
        LiveRoomManageAppLogger.s(d(), this.r.getIdStr());
        LiveRoomManageAppLogger.y(this.e.getOwnerUserIdString(), this.e.getRoomId(), this.r.getIdStr(), "block", "block");
        LiveProfileManageDialogV2.b r42 = this.h;
        if (r42 == null) goto L194;
        r42.dismissDialog();
        return;
    L194:
        return;
    L187:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L184
    L88:
        DialogLancet.beforeDialogShow(r41);
        r41.show();
        DialogLancet.afterDialogShow(r41);
        goto L89
    L93:
        if (r1 != 2131380529) goto L116;
        e(com.bytedance.android.live.core.utils.s1.B(2131919766));
        if (this.e != null) goto L97;
        return;
    L97:
        User r43 = this.r;
        Intrinsics.checkNotNull(r43);
        if (r43.getUserAttr() == null) goto L106;
        py.t r44 = this.r.getUserAttr();
        if (r44 == null) goto L103;
        r7 = Boolean.valueOf(r44.isMuted());
    L103:
        if (r7.booleanValue() == false) goto L106;
        r8 = false;
    L106:
        this.c.a(r8, this.e.id, this.r.getIdStr(), this.r.getCastSecUid());
        boolean r45 = d();
        String r46 = this.r.getIdStr();
        if (r8 == true) goto L110;
        r4 = "cancel";
    L110:
        LiveRoomManageAppLogger.w(r45, r46, r4);
        String r47 = this.e.getOwnerUserIdString();
        long r112 = this.e.getRoomId();
        String r113 = this.r.getIdStr();
        if (r8 == true) goto L114;
        r5 = "move";
    L114:
        LiveRoomManageAppLogger.y(r47, r112, r113, "mute", r5);
        return;
    L116:
        if (r1 != 2131365114) goto L122;
        e(com.bytedance.android.live.core.utils.s1.B(2131915442));
        LiveProfileManageDialogV2.b r48 = this.h;
        if (r48 == null) goto L120;
        r48.dismissDialog();
    L120:
        getContext();
        return;
    L122:
        if (r1 != 2131384367) goto L168;
        e(com.bytedance.android.live.core.utils.s1.B(2131922176));
        LiveProfileManageDialogV2.b r49 = this.h;
        if (r49 == null) goto L126;
        r49.onClick(8);
    L126:
        User r50 = this.r;
        if (r50 != null) goto L129;
        return;
    L129:
        Room r51 = this.e;
        if (r51 != null) goto L132;
        return;
    L132:
        UserProfileEvent r52 = this.u;
        if (r52 != null) goto L135;
        return;
    L135:
        IReportService r53 = jc1.k.f(IReportService.class);
        if (r53 == null) goto L138;
        y71.a r54 = new y71.a(ReportConstant.BusinessSource.ManagePanel);
        r54.a = r50;
        r54.b = r51;
        r54.c = r52.mSource;
        r54.d = r52.mReportSource;
        r54.e = r52.mReportTypeForLog;
        r54.f = r52.mCommentReportModel;
        r54.a(r52.getReportObject());
        r53.report(r54);
    L138:
        int r55 = LiveRoomManageAppLogger.b;
        Intrinsics.checkNotNullParameter(r50, "mUser");
        String r56 = r52.mSource;
        String r57 = "";
        if (r56 != null) goto L141;
        r56 = "";
    L141:
        String r58 = r50.getIdStr();
        zg1.u r59 = r52.mCommentReportModel;
        if (TextUtils.equals("personal_profile", r56) == false) goto L144;
    L147:
        boolean r114 = true;
    L148:
        HashMap r115 = new HashMap();
        r115.put("report_type", jc1.k.n(IReportService.class).getReportType(r56, r52.mReportTypeForLog, r114));
        r115.put("request_page", jc1.k.n(IReportService.class).getRequestPage(r56, r52.mReportTypeForLog));
        r115.put("to_user_id", r58.toString());
        IInteractService r60 = jc1.k.f(IInteractService.class);
        if (r60 != null) goto L151;
    L153:
        IInteractService r61 = jc1.k.f(IInteractService.class);
        if (r61 == null) goto L160;
        rj0.m r62 = r61.getVideoTalkService();
        if (r62 == null) goto L160;
        if (r62.z() != true) goto L160;
        r115.put("play_type", "video_friend");
    L160:
        if (r59 == null) goto L166;
        r115.put("to_comment_id", String.valueOf(r59.a()));
        String r63 = r59.f();
        if (r63 == null) goto L165;
        r57 = r63;
    L165:
        r115.put("to_comment_type", r57);
    L166:
        lc0.c r64 = jc1.k.n(ILinkServiceExternal.class).getMultiDataHolderExternal();
        com.bytedance.android.livesdk.log.g r65 = com.bytedance.android.livesdk.log.u.l();
        int r66 = am2.c0.b;
        r65.sendLog("livesdk_live_user_report", r115, new Object[]{Room.class, new am2.x(), am2.n.f(), am2.c0.a.a(r64.v())});
        return;
    L151:
        if (r60.getCurrentScene() != 12) goto L153;
        r115.put("function_type", "party");
        goto L153
    L144:
        if (TextUtils.equals("live_barrage", r56) == true) goto L147;
        r114 = false;
        goto L148
    L168:
        if (r1 != 2131362228) goto L199;
        Room r67 = this.e;
        if (r67 == null) goto L200;
        User r68 = this.r;
        if (r68 == null) goto L201;
        int r69 = LiveRoomManageAppLogger.b;
        String r70 = r68.getIdStr();
        Intrinsics.checkNotNullParameter(r70, "addUserId");
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_profile_card_receive_click", MapsKt.mapOf(new Pair[]{TuplesKt.to("room_id", r67.getIdStr()), TuplesKt.to("anchor_id", r67.getOwnerUserIdString()), TuplesKt.to("add_user_id", r70.toString())}), new Object[]{new am2.x(), Room.class});
        qe1.e r71 = this.f;
        String r116 = this.r.getIdStr();
        User r72 = this.e.getOwner();
        if (r72 == null) goto L180;
        String r73 = r72.getIdStr();
        if (r73 == null) goto L180;
        String r117 = r73;
    L181:
        long r75 = this.e.getRoomId();
        r71.getClass();
        Intrinsics.checkNotNullParameter(r116, "audienceId");
        Intrinsics.checkNotNullParameter(r117, "anchorId");
        com.bytedance.android.livesdk.service.l.d().getClass();
        r71.a.add(RxUtilKt.h(((RoomRetrofitApi) com.bytedance.android.live.network.c.b().e(RoomRetrofitApi.class)).addAudienceGiftReceiver(r75, r117, r116).subscribeOn(Schedulers.io())).subscribe(new qe1.a(r71, r75, r117, r116), new qe1.b(r71)));
        return;
    L180:
        r117 = "0";
        goto L181
    L201:
        return;
    L200:
        return;
    }

    public final void setClickCallback(LiveProfileManageDialogV2.b r1) {
        this.h = r1;
    }

    public final void v3(boolean r3) {
        if (this.b == false) goto L20;
        User r0 = this.r;
        if (r0 != null) goto L8;
        return;
    L8:
        if (r0.getUserAttr() != null) goto L10;
        this.r.setUserAttr(new UserAttr());
    L10:
        py.t r1 = this.r.getUserAttr();
        if (r1 == null) goto L13;
        r1.setMuted(r3);
    L13:
        TextView r2 = (TextView) findViewById(2131380529);
        if (r2 == null) goto L21;
        if (r3 == false) goto L17;
        int r4 = 2131919762;
    L18:
        r2.setText(r4);
        return;
    L17:
        r4 = 2131919766;
        goto L18
    L21:
        return;
    }

    public final void U1(boolean r2, Exception r3) {
        Intrinsics.checkNotNullParameter(r3, "exception");
        if (this.b == true) goto L5;
        return;
    L5:
        ExceptionUtils.handleException(getContext(), r3, 2131919727);
    }

    public final List<Object> f(Context r19, DataCenter r20) {
        boolean r5 = false;
        long r6 = 0;
        if (this.v.getBoolean("new_anchor_setting_page", false) == false) goto L47;
        com.bytedance.android.livesdk.chatroom.ui.setting.r r12 = this.p;
        r12.getClass();
        Intrinsics.checkNotNullParameter(r19, "context");
        Intrinsics.checkNotNullParameter(r20, "dataCenter");
        r12.a = com.bytedance.android.live.core.utils.z.o(r20);
        r12.d = com.bytedance.android.live.core.utils.z.c(r20);
        r12.b = r20;
        r12.c = r19;
        ArrayList r10 = new ArrayList();
        int r2 = r10.size();
        r12.a(r10, com.bytedance.android.livesdk.chatroom.ui.setting.t.class);
        r12.a(r10, com.bytedance.android.livesdk.chatroom.ui.setting.k.class);
        r12.a(r10, com.bytedance.android.livesdk.chatroom.ui.setting.j.class);
        r12.a(r10, com.bytedance.android.livesdk.chatroom.ui.setting.x.class);
        r12.a(r10, com.bytedance.android.livesdk.chatroom.ui.setting.v.class);
        r12.a(r10, LiveRealTimePlaybackSettingItem.class);
        r12.a(r10, com.bytedance.android.livesdk.chatroom.ui.setting.m.class);
        r12.a(r10, com.bytedance.android.livesdk.chatroom.ui.setting.n.class);
        r12.a(r10, com.bytedance.android.livesdk.chatroom.ui.setting.d.class);
        r12.a(r10, BroadcastVideoWindowSettingItem.class);
        r12.a(r10, com.bytedance.android.livesdk.chatroom.ui.setting.l.class);
        r12.a(r10, com.bytedance.android.livesdk.chatroom.ui.setting.y.class);
        r12.a(r10, BroadcastWindowSettingItem.class);
        r12.a(r10, ParticipateHourRankSettingItem.class);
        if (r10.size() <= r2) goto L7;
        ListProtector.add(r10, r2, com.bytedance.android.livesdk.chatroom.ui.setting.r.d(com.bytedance.android.live.core.utils.s1.B(2131922824)));
    L7:
        int r11 = r10.size();
        r12.a(r10, com.bytedance.android.livesdk.chatroom.ui.setting.g.class);
        r12.a(r10, com.bytedance.android.livesdk.chatroom.ui.setting.f.class);
        r12.a(r10, LiveRoomCommentSettingItem.class);
        r12.a(r10, AllowAudienceShareSettingItem.class);
        if (r12.c(com.bytedance.android.livesdk.chatroom.ui.setting.q.class) == true) goto L10;
    L36:
        r12.a(r10, com.bytedance.android.livesdk.chatroom.ui.setting.a.class);
        r12.a(r10, com.bytedance.android.livesdk.chatroom.ui.setting.e.class);
        if (r10.size() <= r11) goto L39;
        ListProtector.add(r10, r11, com.bytedance.android.livesdk.chatroom.ui.setting.r.d(com.bytedance.android.live.core.utils.s1.B(2131922825)));
    L39:
        int r3 = r10.size();
        if (ContextUtil.contextToFragmentActivity(r19) != null) goto L42;
        r19.getClass();
    L45:
        return r10;
    L42:
        r12.a(r10, SyncCommerceExplainingToProductDetailPage.class);
        r12.a(r10, AllowAudienceRequestExplainingProducts.class);
        if (r10.size() <= r3) goto L45;
        ListProtector.add(r10, r3, com.bytedance.android.livesdk.chatroom.ui.setting.r.d(com.bytedance.android.live.core.utils.s1.B(2131922829)));
        goto L45
    L10:
        if (com.bytedance.android.live.core.utils.z.c(r20) != LiveMode.MEDIA) goto L12;
        r5 = true;
    L12:
        ListDialogAbility r9 = r12.e;
        Room r4 = r12.a;
        if (r4 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("room");
    L15:
        boolean r14 = r4.isPaidRoom();
        Room r7 = r12.a;
        if (r7 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("room");
    L18:
        PaidLiveData r8 = r7.getPaidLiveData();
        if (r8 == null) goto L23;
        ITicketData r13 = r8.getTicketSession();
        if (r13 == null) goto L23;
        r6 = r13.getTicketId();
    L23:
        long r15 = r6;
        Room r16 = r12.a;
        if (r16 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("room");
    L26:
        PaidLiveData r17 = r16.getPaidLiveData();
        if (r17 == null) goto L34;
        ITicketData r18 = r17.getTicketSession();
        if (r18 == null) goto L34;
        String r21 = r18.getTitle();
        if (r21 == null) goto L34;
        String r110 = r21;
    L35:
        r10.add(new com.bytedance.android.livesdk.chatroom.ui.setting.q(r5, r20, r9, r14, r15, r110));
    L34:
        r110 = "";
        goto L35
    L47:
        if (this.v.getBoolean("new_anchor_admin_page", false) == true) goto L49;
        com.bytedance.android.livesdk.chatroom.ui.setting.r r22 = this.p;
        r22.getClass();
        Intrinsics.checkNotNullParameter(r19, "context");
        Intrinsics.checkNotNullParameter(r20, "dataCenter");
        r22.a = com.bytedance.android.live.core.utils.z.o(r20);
        r22.d = com.bytedance.android.live.core.utils.z.c(r20);
        r22.b = r20;
        r22.c = r19;
        ArrayList r111 = new ArrayList();
        r111.addAll(r22.b());
        r22.a(r111, com.bytedance.android.livesdk.chatroom.ui.setting.f.class);
        r22.a(r111, com.bytedance.android.livesdk.chatroom.ui.setting.g.class);
        r22.a(r111, BroadcastWindowSettingItem.class);
        r22.a(r111, com.bytedance.android.livesdk.chatroom.ui.setting.k.class);
        r22.a(r111, ParticipateHourRankSettingItem.class);
        r22.a(r111, com.bytedance.android.livesdk.chatroom.ui.setting.j.class);
        r22.a(r111, com.bytedance.android.livesdk.chatroom.ui.setting.x.class);
        r22.a(r111, com.bytedance.android.livesdk.chatroom.ui.setting.v.class);
        r22.a(r111, com.bytedance.android.livesdk.chatroom.ui.setting.m.class);
        r22.a(r111, com.bytedance.android.livesdk.chatroom.ui.setting.n.class);
        r111.add(new com.bytedance.android.livesdk.chatroom.ui.setting.d());
        r22.a(r111, LiveRoomCommentSettingItem.class);
        r22.a(r111, AllowAudienceShareSettingItem.class);
        r22.a(r111, SyncCommerceExplainingToProductDetailPage.class);
        r22.a(r111, AllowAudienceRequestExplainingProducts.class);
        r22.a(r111, com.bytedance.android.livesdk.chatroom.ui.setting.a.class);
        r22.a(r111, com.bytedance.android.livesdk.chatroom.ui.setting.e.class);
        if (r22.c(com.bytedance.android.livesdk.chatroom.ui.setting.q.class) == true) goto L53;
    L79:
        return r111;
    L53:
        if (com.bytedance.android.live.core.utils.z.c(r20) != LiveMode.MEDIA) goto L55;
        r5 = true;
    L55:
        ListDialogAbility r23 = r22.e;
        Room r1 = r22.a;
        if (r1 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("room");
    L58:
        boolean r112 = r1.isPaidRoom();
        Room r24 = r22.a;
        if (r24 != null) goto L61;
        Intrinsics.throwUninitializedPropertyAccessException("room");
    L61:
        PaidLiveData r25 = r24.getPaidLiveData();
        if (r25 == null) goto L66;
        ITicketData r26 = r25.getTicketSession();
        if (r26 == null) goto L66;
        r6 = r26.getTicketId();
    L66:
        Room r27 = r22.a;
        if (r27 != null) goto L69;
        Intrinsics.throwUninitializedPropertyAccessException("room");
    L69:
        PaidLiveData r28 = r27.getPaidLiveData();
        if (r28 == null) goto L77;
        ITicketData r29 = r28.getTicketSession();
        if (r29 == null) goto L77;
        String r30 = r29.getTitle();
        if (r30 == null) goto L77;
        String r31 = r30;
    L78:
        r111.add(new com.bytedance.android.livesdk.chatroom.ui.setting.q(r5, r20, r23, r112, r6, r31));
    L77:
        r31 = "";
        goto L78
    L49:
        return this.p.b();
    }

    public final void y1(boolean r2, User r3) {
        Intrinsics.checkNotNullParameter(r3, "user");
        if (this.b == true) goto L5;
        return;
    L5:
        User r4 = this.r;
        Intrinsics.checkNotNull(r4);
        if (r4.getUserAttr() != null) goto L8;
        this.r.setUserAttr(new UserAttr());
    L8:
        User r5 = this.r;
        if (r5 == null) goto L13;
        py.t r6 = r5.getUserAttr();
        if (r6 == null) goto L13;
        r6.setAdmin(r2);
    L13:
        TextView r7 = this.k;
        if (r7 == null) goto L20;
        if (r2 == false) goto L17;
        int r0 = 2131919760;
    L18:
        r7.setText(r0);
        goto L20
    L17:
        r0 = 2131919768;
    L20:
        if (tb1.c.a == true) goto L26;
        if (r2 == false) goto L23;
        int r8 = 2131919769;
    L24:
        com.bytedance.android.live.core.utils.f2.b(r8, 0);
        return;
    L23:
        r8 = 2131919761;
        goto L24
    }

    public t7(boolean r17, Context r18, User r19, boolean r20, boolean r21, UserProfileEvent r22, Bundle r23) {
        Intrinsics.checkNotNullParameter(r18, "context");
        Intrinsics.checkNotNullParameter(r23, "bundle");
        super(r18);
        this.q = r17;
        this.r = r19;
        this.s = r20;
        this.t = r21;
        this.u = r22;
        this.v = r23;
        this.a = new com.bytedance.android.live.core.utils.rxutils.x();
        bf1.e r2 = new bf1.e();
        this.c = r2;
        RoomContext.a r6 = RoomContext.Companion;
        RoomContext r11 = RoomContext.a.c(r6, null, 0, 3);
        if (r11 == null) goto L7;
        com.bytedance.live.datacontext.m r12 = r11.getRoom();
        if (r12 == null) goto L7;
        Room r13 = (Room) r12.getValue();
    L8:
        this.e = r13;
        com.bytedance.android.livesdk.chatroom.ui.setting.r r14 = new com.bytedance.android.livesdk.chatroom.ui.setting.r(this);
        this.p = r14;
        r2.a = this;
        this.d = new ud1.a(this);
        qe1.e r3 = new qe1.e(this);
        this.f = r3;
        if (r13 == null) goto L11;
        long r15 = r13.id;
    L12:
        RoomContext r16 = RoomContext.a.a(null, r15);
        if (r16 == null) goto L15;
        boolean r110 = r16.isBroadcastMedia();
    L16:
        if (r110 == false) goto L19;
        this.s = false;
        this.t = false;
    L19:
        if (PadConfigUtils.c() == false) goto L21;
        LayoutInflater.from(getContext()).inflate(2131565612, this, true);
    L28:
        this.l = findViewById(2131364286);
        this.j = findViewById(2131362289);
        this.k = (TextView) findViewById(2131379516);
        View r1 = findViewById(2131365114);
        this.i = r1;
        if (r1 == null) goto L31;
        r1.setOnClickListener(this);
    L31:
        this.g = findViewById(2131385223);
        if (this.s == true) goto L144;
        if (r19 == null) goto L144;
        if (r13 == null) goto L38;
        User r4 = r13.getOwner();
        if (r4 == null) goto L38;
        String r5 = r4.getIdStr();
    L40:
        if (Intrinsics.areEqual(r5, r19.getIdStr()) == true) goto L144;
        View r7 = this.l;
        if (r7 == null) goto L45;
        r7.setVisibility(8);
    L45:
        View r8 = findViewById(2131388881);
        if (r8 == null) goto L48;
        UtilityKotlinExtentionsKt.t(r8);
    L48:
        View r9 = this.j;
        if (r9 == null) goto L52;
        UtilityKotlinExtentionsKt.w(r9);
    L52:
        if (d() == true) goto L54;
    L58:
        TextView r10 = this.k;
        if (r10 == null) goto L61;
        UtilityKotlinExtentionsKt.t(r10);
    L61:
        View r24 = findViewById(2131379521);
        if (r24 == null) goto L64;
        UtilityKotlinExtentionsKt.t(r24);
    L64:
        RecyclerView r25 = this.n;
        if (r25 == null) goto L67;
        UtilityKotlinExtentionsKt.t(r25);
    L67:
        if (r13 == null) goto L69;
        long r26 = r13.getRoomId();
    L70:
        RoomPermissionContext.Companion.getClass();
        boolean r27 = RoomPermissionContext.a.a(r26);
        TextView r28 = this.k;
        if (r28 == null) goto L73;
        r28.setOnClickListener(this);
    L73:
        View r29 = findViewById(2131376850);
        if (r29 == null) goto L87;
        r29.setOnClickListener(this);
        if (d() == true) goto L82;
        if (r27 == false) goto L82;
        LiveRoomPermission.D.getClass();
        if (RoomPermissionContext.a.d(r26, LiveRoomPermission.i) == true) goto L82;
        UtilityKotlinExtentionsKt.t(r29);
    L82:
        if (r19.isMysteryMan() != true) goto L87;
        if (((Boolean) rs0.k.a.getValue()).booleanValue() == true) goto L87;
        UtilityKotlinExtentionsKt.t(r29);
    L87:
        if (r19.isMysteryMan() != true) goto L95;
        View r30 = this.j;
        if (r30 == null) goto L95;
        float r31 = UtilityKotlinExtentionsKt.i(8);
        float r32 = UtilityKotlinExtentionsKt.i(8);
        float[] r33 = {r31, r31, r32, r32, 0.0f, 0.0f, 0.0f, 0.0f};
        GradientDrawable r34 = new GradientDrawable();
        r34.setShape(0);
        r34.setCornerRadii(r33);
        Drawable r35 = r30.getBackground();
        if ((r35 instanceof ColorDrawable) == false) goto L93;
        int r36 = ((ColorDrawable) r35).getColor();
    L94:
        r34.setColor(r36);
        int r37 = com.bytedance.android.livesdk.utils.u5.a;
        r30.setBackground(r34);
        goto L95
    L93:
        r36 = -1;
    L95:
        View r38 = findViewById(2131380529);
        if (r38 == null) goto L103;
        r38.setOnClickListener(this);
        if (d() == true) goto L103;
        if (r27 == false) goto L103;
        LiveRoomPermission.D.getClass();
        if (RoomPermissionContext.a.d(r26, LiveRoomPermission.h) == true) goto L103;
        UtilityKotlinExtentionsKt.t(r38);
    L103:
        View r39 = findViewById(2131384367);
        if (r39 == null) goto L115;
        if (r22 == null) goto L107;
        boolean r40 = true;
    L108:
        UtilityKotlinExtentionsKt.z(r39, r40);
        View r41 = findViewById(2131384370);
        if (r41 == null) goto L111;
        UtilityKotlinExtentionsKt.z(r41, r40);
    L111:
        if (r40 == false) goto L113;
        t7 r42 = this;
    L114:
        r39.setOnClickListener(r42);
        goto L115
    L113:
        r42 = null;
        goto L114
    L107:
        r40 = false;
    L115:
        py.t r43 = r19.getUserAttr();
        if (r43 == null) goto L131;
        TextView r44 = this.k;
        if (r44 != null) goto L120;
    L124:
        TextView r45 = (TextView) findViewById(2131380529);
        if (r45 == null) goto L131;
        if (r43.isMuted() == false) goto L129;
        int r46 = 2131919762;
    L130:
        r45.setText(r46);
        goto L131
    L129:
        r46 = 2131919766;
        goto L130
    L120:
        if (r43.isAdmin() == false) goto L122;
        int r47 = 2131919760;
    L123:
        r44.setText(r47);
        goto L124
    L122:
        r47 = 2131919768;
    L131:
        View r48 = findViewById(2131362228);
        if (r48 == null) goto L143;
        r48.setOnClickListener(this);
        if (d() == true) goto L136;
    L142:
        UtilityKotlinExtentionsKt.t(r48);
        goto L143
    L136:
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.b.c3.getValue()).booleanValue() == false) goto L142;
        Long r49 = (Long) com.bytedance.android.livesdk.sharedpref.b.d3.getValue();
        if (r49 == null) goto L143;
        if (r49.longValue() == 2) goto L142;
    L143:
        String r50 = null;
    L202:
        if (com.bytedance.android.livesdk.interactivity.api.asr.utils.a.a() == false) goto L204;
    L231:
        com.bytedance.android.livesdk.log.g r51 = com.bytedance.android.livesdk.log.u.l();
        HashMap r52 = new HashMap();
        r52.put("EVENT_ORIGIN_FEATURE", "TEMAI");
        if (r19 == null) goto L234;
        String r53 = r19.getIdStr();
    L235:
        r52.put("to_user_id", String.valueOf(r53));
        r52.put("popup_title", "管理用户");
        Unit r54 = Unit.INSTANCE;
        r51.sendLog("livesdk_show_feedback_popup", r52, new Object[]{Room.class, am2.x.class});
        return;
    L234:
        r53 = r50;
        goto L235
    L204:
        if (r14.c(com.bytedance.android.livesdk.chatroom.ui.setting.q.class) == false) goto L231;
        com.bytedance.android.livesdk.log.g r55 = com.bytedance.android.livesdk.log.u.l();
        HashMap r56 = new HashMap();
        r56.put("enter_from_merge", "direct_shoot");
        if (r13 != null) goto L208;
    L210:
        String r57 = "0";
    L211:
        r56.put("is_paidlive", r57);
        String r58 = "";
        if (r13 == null) goto L219;
        PaidLiveData r59 = r13.getPaidLiveData();
        if (r59 == null) goto L219;
        ITicketData r60 = r59.getTicketSession();
        if (r60 == null) goto L219;
        String r61 = String.valueOf(r60.getTicketId());
        if (r61 == null) goto L219;
    L220:
        r56.put("ticket_id", r61);
        if (r13 == null) goto L230;
        PaidLiveData r62 = r13.getPaidLiveData();
        if (r62 == null) goto L230;
        ITicketData r63 = r62.getTicketSession();
        if (r63 == null) goto L230;
        String r64 = r63.getTitle();
        if (r64 == null) goto L230;
        r58 = r64;
    L230:
        r56.put("ticket_name", r58);
        Unit r65 = Unit.INSTANCE;
        r55.sendLog("livesdk_anchor_interact_right_show", r56, new Object[]{Room.class, am2.x.class});
    L219:
        r61 = "";
        goto L220
    L208:
        if (r13.isPaidRoom() != true) goto L210;
        r57 = "1";
        goto L211
    L69:
        r26 = 0;
        goto L70
    L54:
        if (r19.isMysteryMan() == true) goto L58;
        if (r22 == null) goto L64;
        if (r22.isFromOtherIntercomRoom() != true) goto L64;
    L38:
        r5 = null;
    L144:
        this.n = findViewById(2131385006);
        TextView r66 = (TextView) findViewById(2131390020);
        View r67 = this.j;
        if (r67 == null) goto L148;
        UtilityKotlinExtentionsKt.t(r67);
    L148:
        if (r23.getBoolean("new_anchor_admin_page", false) == false) goto L152;
        if (r66 == null) goto L152;
        r66.setText("直播管理");
    L152:
        if (r23.getBoolean("new_anchor_setting_page", false) == false) goto L159;
        View r68 = this.l;
        if (r68 == null) goto L156;
        UtilityKotlinExtentionsKt.t(r68);
    L156:
        DataCenter r69 = null;
        this.l = null;
        if (r66 == null) goto L160;
        r66.setText("功能设置");
    L160:
        View r70 = this.l;
        if (r70 == null) goto L176;
        if (r70.getVisibility() != 0) goto L176;
        RoomContext r71 = RoomContext.a.c(r6, r69, 0, 3);
        if (r71 == null) goto L171;
        com.bytedance.live.datacontext.m r72 = r71.isPortraitInteraction();
        if (r72 == null) goto L171;
        Boolean r73 = (Boolean) r72.getValue();
        if (r73 == null) goto L171;
        boolean r75 = r73.booleanValue();
    L172:
        BlockWordFlowController r76 = new BlockWordFlowController(this, r13, r75, false);
        this.m = r76;
        r76.j();
        BlockWordFlowController r77 = this.m;
        if (r77 == null) goto L176;
        r77.i();
    L171:
        r75 = true;
    L176:
        if (d() == false) goto L143;
        View r78 = findViewById(2131367862);
        if (r78 == null) goto L183;
        if (getChangeDefaultUIStyle() == false) goto L183;
        r78.setBackground(com.bytedance.android.live.core.utils.s1.m(2131250337));
    L183:
        if (getChangeDefaultUIStyle() == false) goto L187;
        TextView r79 = (TextView) findViewById(2131390020);
        if (r79 == null) goto L187;
        r79.setTextColor(com.bytedance.android.live.core.utils.s1.h(2131107294));
        r79.setTextSize(0, com.bytedance.android.live.core.utils.s1.j(2131168556));
    L187:
        RecyclerView r80 = this.n;
        if (r80 == null) goto L143;
        MultiTypeAdapter r81 = new MultiTypeAdapter();
        r81.z2(mx.o.class, new mx.m(getChangeDefaultUIStyle()));
        r81.z2(mx.l.class, new SwitchSettingItemBinder(getChangeDefaultUIStyle()));
        r81.z2(mx.j.class, new mx.k(getChangeDefaultUIStyle()));
        r81.z2(com.bytedance.android.livesdk.chatroom.ui.setting.j.class, new mx.c(getChangeDefaultUIStyle()));
        r81.z2(com.bytedance.android.livesdk.chatroom.ui.setting.n.class, new mx.i(getChangeDefaultUIStyle()));
        this.o = r81;
        r50 = null;
        RoomContext r82 = RoomContext.a.c(r6, null, 0, 3);
        if (r82 == null) goto L202;
        com.bytedance.live.datacontext.n r83 = r82.getDataCenter();
        if (r83 == null) goto L202;
        DataCenter r84 = (DataCenter) r83.getValue();
        if (r84 == null) goto L202;
        r81.a = f(getContext(), r84);
        r80.setAdapter(r81);
        if (r13 == null) goto L202;
        r3.a.add(((RoomRetrofitApi) com.bytedance.android.live.network.c.b().e(RoomRetrofitApi.class)).getAudienceGiftAuthInfo(r13.getId(), r13.getOwnerUserIdString()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new qe1.c(r3), new qe1.d(r3)));
        goto L202
    L159:
        r69 = null;
        goto L160
    L21:
        if (r17 == false) goto L23;
    L27:
        LayoutInflater.from(getContext()).inflate(2131565611, this, true);
        goto L28
    L23:
        if (this.s == true) goto L27;
        if (this.t == false) goto L27;
        LayoutInflater.from(getContext()).inflate(2131565610, this, true);
        goto L28
    L15:
        r110 = false;
        goto L16
    L11:
        r15 = 0;
    L7:
        r13 = null;
        goto L8
    }
}
