package com.bytedance.android.livesdk.chatroom.vs.report;

import am2.x;
import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.base.model.user.o;
import com.bytedance.android.live.base.service.IVSReportService;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.room.api.ILiveShareService;
import com.bytedance.android.live.room.api.IReportService;
import com.bytedance.android.live.room.api.share.model.LiveShareType;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.business.depend.share.ShareParams;
import com.bytedance.android.livesdk.TTLiveSDKContext;
import com.bytedance.android.livesdk.chatroom.VSDataContext;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.config.nl;
import com.bytedance.android.livesdk.config.oc;
import com.bytedance.android.livesdk.config.ui1;
import com.bytedance.android.livesdk.log.filter.n0;
import com.bytedance.android.livesdk.log.filter.s0;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdk.user.f;
import com.bytedance.android.livesdk.user.h;
import com.bytedance.android.livesdk.user.l;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.abs.EpisodeCompatDelegate;
import com.bytedance.android.livesdkapi.depend.model.live.abs.IRoomData;
import com.bytedance.android.livesdkapi.depend.model.live.abs.RoomCompatDelegate;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeExtraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeMod;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IBaseEpisodeMod;
import com.bytedance.android.livesdkapi.eventbus.HorizontalPlayEvent;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import com.ss.android.videoshop.context.VideoContext;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import ita.i;
import java.util.LinkedHashMap;
import java.util.Map;
import jc1.k;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import xs2.b;
import zg1.j3;
import zg1.r2;
import zg1.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002JD\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u000bH\u0016JV\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u0013J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0018\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0006H\u0016JP\u0010\u0019\u001a\u00020\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/vs/report/VSReportServiceImpl;", "Lcom/bytedance/android/live/base/service/IVSReportService;", "()V", "mCompositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "mIsFetchingReasons", "", "logReport", "", "isLive", "toUserId", "", "toCommentId", "reportType", "requestPage", "dataCenter", "Landroidx/lifecycle/ViewModel;", "toCommentType", "mLogParams", "", "login", "context", "Landroid/content/Context;", "loginCheck", "isPortrait", "report", "room", "Lcom/bytedance/android/livesdkapi/depend/model/live/abs/IRoomData;", "userId", "isAnchor", "userProfileEvent", "Lcom/bytedance/android/livesdk/chatroom/event/UserProfileEvent;", "user", "Lcom/bytedance/android/live/base/model/user/User;", "isVertical", "vsmain-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class VSReportServiceImpl implements IVSReportService {
    private final CompositeDisposable mCompositeDisposable;
    private boolean mIsFetchingReasons;

    public static final class a extends h<IBaseUser> {
        public final /* synthetic */ VSReportServiceImpl a;

        public a(VSReportServiceImpl r1) {
            this.a = r1;
        }

        public final void onSubscribe(Disposable r2) {
            Intrinsics.checkNotNullParameter(r2, "d");
            VSReportServiceImpl.access$getMCompositeDisposable$p(this.a).add(r2);
        }
    }

    public VSReportServiceImpl() {
        this.mCompositeDisposable = new CompositeDisposable();
    }

    public static final /* synthetic */ CompositeDisposable access$getMCompositeDisposable$p(VSReportServiceImpl r0) {
        return r0.mCompositeDisposable;
    }

    private final boolean login(Context r4) {
        if (TTLiveSDKContext.getHostService().h().isLogin() == true) goto L6;
        f r0 = TTLiveSDKContext.getHostService().h();
        l.a r1 = new l.a();
        r1.a = s1.B(2131915990);
        r1.c = -1;
        r1.e = "live_detail";
        r1.g = "user_report";
        r1.d = "popup";
        r0.login(r4, new l(r1)).subscribe(new a(this));
        return false;
    L6:
        return true;
    }

    public boolean loginCheck(Context r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        if (r5 == true) goto L9;
        VideoContext r6 = VideoContext.n0(r4);
        if (r6 == null) goto L7;
        r6.l0();
    L7:
        b.a().post(new HorizontalPlayEvent(1, "report"));
    L9:
        return login(r4);
    }

    public void logReport(boolean r11, String r12, String r13, String r14, String r15, ViewModel r16, String r17) {
        Intrinsics.checkNotNullParameter(r12, "toUserId");
        Intrinsics.checkNotNullParameter(r13, "toCommentId");
        Intrinsics.checkNotNullParameter(r14, "reportType");
        Intrinsics.checkNotNullParameter(r15, "requestPage");
        logReport(r11, r12, r13, r14, r15, r16, r17, new LinkedHashMap());
    }

    public final void logReport(boolean r1, String r2, String r3, String r4, String r5, ViewModel r6, String r7, Map<String, String> r8) {
        Intrinsics.checkNotNullParameter(r2, "toUserId");
        Intrinsics.checkNotNullParameter(r3, "toCommentId");
        Intrinsics.checkNotNullParameter(r4, "reportType");
        Intrinsics.checkNotNullParameter(r5, "requestPage");
        Intrinsics.checkNotNullParameter(r8, "mLogParams");
        r8.put("to_user_id", r2);
        r8.put("to_comment_id", r3);
        r8.put("report_type", r4);
        r8.put("request_page", r5);
        if (r7 == null) goto L5;
        r8.put("to_comment_type", r7);
    L5:
        if (r6 != null) goto L7;
        return;
    L7:
        if ((r6 instanceof DataCenter) == false) goto L21;
        DataCenter r9 = (DataCenter) r6;
        VSDataContext r10 = VSDataContext.a.c(VSDataContext.Companion, r9);
        if (r10 == null) goto L15;
        m r11 = r10.isVSVideo();
        if (r11 == null) goto L15;
        boolean r12 = true;
        if (((Boolean) r11.getValue()).booleanValue() != true) goto L15;
    L16:
        if (r12 == false) goto L18;
        com.bytedance.android.livesdk.vs.f.a(r9).c("user_report", r8, new Object[0]);
        return;
    L18:
        com.bytedance.android.livesdk.vs.f.a(r9).c("live_user_report", r8, new Object[0]);
        return;
    L15:
        r12 = false;
        goto L16
    }

    public boolean report(IRoomData r31, Context r32, String r33, boolean r34, UserProfileEvent r35, User r36, boolean r37, ViewModel r38) {
        Intrinsics.checkNotNullParameter(r33, "userId");
        String r0 = "user";
        Intrinsics.checkNotNullParameter(r36, "user");
        Boolean r24 = Boolean.FALSE;
        if (r31 != null) goto L5;
        return false;
    L5:
        if ((r32 instanceof Activity) == true) goto L8;
        return false;
    L8:
        if (this.mIsFetchingReasons == false) goto L11;
        return false;
    L11:
        if (r35 == null) goto L18;
        if (r35.forceNoRotate != true) goto L18;
        if (login(r32) == true) goto L20;
        return false;
    L20:
        int r1 = i.a;
        if (NetworkUtils.isNetworkAvailable(r32) == true) goto L24;
        f2.b(2131916005, 0);
        return true;
    L24:
        com.bytedance.android.livesdk.service.f r2 = TTLiveSDKContext.getHostService();
        if (r2.c != null) goto L28;
        r2.c = new com.bytedance.android.livesdk.share.h(r2.a.share());
    L28:
        if (r2.c != null) goto L30;
        return false;
    L30:
        if (r34 == false) goto L32;
        Object r7 = Long.valueOf(r31.getRoomId());
        r0 = "live";
    L33:
        boolean r3 = r31 instanceof RoomCompatDelegate;
        if (r3 == false) goto L37;
        ((RoomCompatDelegate) r31).getLiveRoom();
    L39:
        if (r35 == null) goto L41;
        String r4 = r35.mReportSource;
    L43:
        if (TextUtils.equals("personal_profile", r4) == false) goto L45;
        r0 = "live_comment";
    L45:
        String r23 = r0;
        if (r35 == null) goto L48;
        String r5 = r35.mSource;
    L50:
        if (TextUtils.equals(r5, "discussion_official_profile_card") == true) goto L58;
        if (r35 == null) goto L53;
        String r6 = r35.mSource;
    L55:
        if (TextUtils.equals(r6, "vs_record_video") == true) goto L58;
        boolean r8 = false;
    L60:
        if (r8 == true) goto L62;
    L124:
        boolean r9 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.a.a;
        if (r9 == false) goto L216;
        if (r35 == null) goto L128;
        String r10 = r35.mReportSource;
    L130:
        if (r2.a(r10) == false) goto L216;
        if (TextUtils.isEmpty(oc.a.getValue()) == true) goto L216;
        String r11 = r31.getOwner().getCastSecUid();
        long r12 = r31.getRoomId();
        String r13 = o.a(k.n(IUserService.class).user().b());
        if (r35 == null) goto L136;
        String r14 = r35.mReportSource;
    L138:
        if (Intrinsics.areEqual("pk", r14) == true) goto L162;
        if (r35 == null) goto L141;
        String r15 = r35.mReportSource;
    L143:
        if (Intrinsics.areEqual("anchor_linkmic", r15) == true) goto L162;
        if (r35 == null) goto L147;
        String r16 = r35.mReportSource;
    L149:
        if (Intrinsics.areEqual("audience_audio", r16) == true) goto L157;
        if (r35 == null) goto L152;
        String r17 = r35.mReportSource;
    L154:
        if (Intrinsics.areEqual("audience_linkmic", r17) == true) goto L157;
        String r18 = "";
    L163:
        String r19 = r11;
        long r110 = r12;
        String r21 = r13;
        String r25 = "";
        String r26 = r25;
    L165:
        if (r18 != null) goto L167;
        String r22 = "";
    L168:
        if (r35 == null) goto L170;
        String r27 = r35.mReportTypeForLog;
    L171:
        j3 r20 = new j3(r19, r110, r21, r22, r25, r26, r27, r36.isVcdContentAuthorized());
        if (r35 == null) goto L174;
        String r28 = r35.mSource;
    L176:
        if (TextUtils.equals("personal_profile", r28) == true) goto L184;
        if (r35 == null) goto L179;
        String r29 = r35.mSource;
    L181:
        if (TextUtils.equals("live_barrage", r29) == true) goto L184;
        boolean r111 = false;
    L185:
        IReportService r30 = k.f(IReportService.class);
        if (r30 == null) goto L194;
        if (r35 == null) goto L189;
        String r39 = r35.mSource;
    L190:
        if (r35 == null) goto L192;
        String r40 = r35.mReportTypeForLog;
    L193:
        String r41 = r30.getReportType(r39, r40, r111);
    L195:
        ((r2) r20).g = r41;
        IReportService r42 = k.f(IReportService.class);
        if (r42 == null) goto L204;
        if (r35 == null) goto L199;
        String r43 = r35.mSource;
    L200:
        if (r35 == null) goto L202;
        String r44 = r35.mReportTypeForLog;
    L203:
        String r45 = r42.getRequestPage(r43, r44);
    L205:
        ((r2) r20).i = r45;
        b.a().post(r20);
        if (r3 == false) goto L214;
        EpisodeExtraInfo r46 = ((RoomCompatDelegate) r31).getLiveRoom().getEpisodeExtra2();
        if (r46 == null) goto L214;
        IBaseEpisodeMod r47 = r46.getEpisodeMod();
        if (r47 == null) goto L214;
        if (r47.getEpisodeStage() != EpisodeMod.EpisodeStageType.LIVE) goto L214;
        IVSReportService.b.a(this, true, r7.toString(), "report_official_account", "data_card_anchor", r38);
    L215:
        return true;
    L214:
        IVSReportService.b.a(this, false, r7.toString(), "report_official_account", "data_card_anchor", r38);
        goto L215
    L202:
        r44 = "";
        goto L203
    L199:
        r43 = null;
        goto L200
    L204:
        r45 = null;
        goto L205
    L192:
        r40 = "";
        goto L193
    L189:
        r39 = null;
        goto L190
    L194:
        r41 = null;
        goto L195
    L179:
        r29 = null;
    L184:
        r111 = true;
        goto L185
    L174:
        r28 = null;
        goto L176
    L170:
        r27 = null;
        goto L171
    L167:
        r22 = r18;
        goto L168
    L152:
        r17 = null;
    L157:
        String r112 = r36.getCastSecUid();
        if (TextUtils.isEmpty(r112) == false) goto L160;
        String r113 = r36.getIdString();
    L161:
        r18 = r35.mReportSource;
        r19 = r11;
        r110 = r12;
        r21 = r13;
        r25 = r112;
        r26 = r113;
        goto L165
    L160:
        r113 = "";
        goto L161
    L147:
        r16 = null;
        goto L149
    L141:
        r15 = null;
    L162:
        r11 = r36.getCastSecUid();
        r13 = r36.getCastSecUid();
        r12 = r36.getLiveRoomId();
        r18 = r35.mReportSource;
        goto L163
    L136:
        r14 = null;
        goto L138
    L128:
        r10 = null;
    L216:
        if (r34 == false) goto L271;
        if (r9 == false) goto L271;
        if (TextUtils.isEmpty(oc.a.getValue()) == true) goto L271;
        if (ui1.a.getValue().booleanValue() == false) goto L271;
        j3 r48 = new j3(r31.getOwner().getCastSecUid(), r31.getRoomId(), o.a(k.n(IUserService.class).user().b()));
        if (r35 == null) goto L225;
        String r49 = r35.mReportTypeForLog;
    L226:
        ((r2) r48).g = r49;
        if (r35 == null) goto L229;
        String r50 = r35.mSource;
    L231:
        if (TextUtils.equals("personal_profile", r50) == true) goto L239;
        if (r35 == null) goto L234;
        String r51 = r35.mSource;
    L236:
        if (TextUtils.equals("live_barrage", r51) == true) goto L239;
        boolean r114 = false;
    L240:
        IReportService r52 = k.f(IReportService.class);
        if (r52 == null) goto L249;
        if (r35 == null) goto L244;
        String r53 = r35.mSource;
    L245:
        if (r35 == null) goto L247;
        String r54 = r35.mReportTypeForLog;
    L248:
        String r55 = r52.getReportType(r53, r54, r114);
    L250:
        ((r2) r48).g = r55;
        IReportService r56 = k.f(IReportService.class);
        if (r56 == null) goto L259;
        if (r35 == null) goto L254;
        String r57 = r35.mSource;
    L255:
        if (r35 == null) goto L257;
        String r58 = r35.mReportTypeForLog;
    L258:
        String r59 = r56.getRequestPage(r57, r58);
    L260:
        ((r2) r48).i = r59;
        b.a().post(r48);
        if (r3 == false) goto L269;
        EpisodeExtraInfo r60 = ((RoomCompatDelegate) r31).getLiveRoom().getEpisodeExtra2();
        if (r60 == null) goto L269;
        IBaseEpisodeMod r61 = r60.getEpisodeMod();
        if (r61 == null) goto L269;
        if (r61.getEpisodeStage() != EpisodeMod.EpisodeStageType.LIVE) goto L269;
        IVSReportService.b.a(this, true, r7.toString(), "report_official_account", "data_card_anchor", r38);
    L270:
        return true;
    L269:
        IVSReportService.b.a(this, false, r7.toString(), "report_official_account", "data_card_anchor", r38);
        goto L270
    L257:
        r58 = "";
        goto L258
    L254:
        r57 = null;
        goto L255
    L259:
        r59 = null;
        goto L260
    L247:
        r54 = "";
        goto L248
    L244:
        r53 = null;
        goto L245
    L249:
        r55 = null;
        goto L250
    L234:
        r51 = null;
    L239:
        r114 = true;
        goto L240
    L229:
        r50 = null;
        goto L231
    L225:
        r49 = null;
    L271:
        if (r3 == false) goto L279;
        EpisodeExtraInfo r62 = ((RoomCompatDelegate) r31).getLiveRoom().getEpisodeExtra2();
        if (r62 == null) goto L279;
        IBaseEpisodeMod r63 = r62.getEpisodeMod();
        if (r63 == null) goto L279;
        if (r63.getEpisodeStage() != EpisodeMod.EpisodeStageType.LIVE) goto L279;
        IVSReportService.b.a(this, true, r7.toString(), "report_user", "data_card_sendgiftinfo", r38);
    L280:
        ShareParams.Builder r64 = ShareParams.buildUponParams(r7.toString(), r33);
        r64.setRoomId(r31.getRoomId());
        k.n(ILiveShareService.class).share(new i81.a(null, (Activity) r32, null, r64.build(), null, null, null, null, null, null, r23, r24, null, null, null, null, false), "VSReportServiceImpl", LiveShareType.REPORT_DIALOG, null);
        return false;
    L279:
        IVSReportService.b.a(this, false, r7.toString(), "report_user", "data_card_sendgiftinfo", r38);
        goto L280
    L62:
        if (com.bytedance.android.livesdk.chatroom.vs_base.base.util.a.a == false) goto L64;
    L65:
        if (r35 == null) goto L123;
        u r65 = r35.mCommentReportModel;
        if (r65 == null) goto L123;
        if ((!Intrinsics.areEqual(r35.mSource, "vs_record_video")) == false) goto L72;
        String r66 = r7.toString();
        String r67 = r35.getUserIdStr();
        String r68 = r35.reportType;
        String r69 = r35.requestPage;
        LinkedHashMap r70 = new LinkedHashMap();
        r70.put("to_comment_category", r35.toCommentCategory);
        r70.put("is_from_at_user_nickname", String.valueOf(r35.isFromUserNickname));
        r70.put("to_discussion_board_comment_id", r35.toDiscussionBoardCommentId);
        Unit r71 = Unit.INSTANCE;
        logReport(true, r66, r67, r68, r69, r38, "", r70);
    L72:
        Activity r72 = (Activity) r32;
        int r73 = xp1.b.a;
        Intrinsics.checkNotNullParameter(r72, "activity");
        Intrinsics.checkNotNullParameter(r36, "mUser");
        Intrinsics.checkNotNullParameter(r31, "mRoom");
        Intrinsics.checkNotNullParameter(r65, "commentReportModel");
        String r75 = r35.mReportTypeForLog;
        if (r75 != null) goto L75;
        r75 = "";
    L75:
        String r76 = nl.a.getValue();
        ita.l r77 = new ita.l(r76);
        r77.c("comment", Uri.encode(r65.b()));
        r77.c("sec_reported_user_id", r65.c());
        r77.c("reported_user_id", String.valueOf(r65.d()));
        r77.b("msg_id", r65.a());
        r77.a("chat_type", r65.getType());
        r77.b("room_id", r31.getId());
        r77.c("show_type", r75);
        String r78 = r35.reportType;
        if (r78 != null) goto L78;
        r78 = "report_message";
    L78:
        r77.c("report_type", r78);
        String r79 = r35.requestPage;
        if (r79 != null) goto L81;
        r79 = "";
    L81:
        r77.c("request_page", r79);
        n0 r80 = com.bytedance.android.livesdk.log.u.l().c(x.class);
        if ((r80 instanceof n0) == false) goto L92;
        n0 r81 = r80;
        if (((com.bytedance.android.livesdk.log.filter.a) r81).b.containsKey("enter_from_merge") == false) goto L87;
        r77.c("enter_from_merge", (String) ((com.bytedance.android.livesdk.log.filter.a) r81).b.get("enter_from_merge"));
    L87:
        if (((com.bytedance.android.livesdk.log.filter.a) r81).b.containsKey("enter_method") == false) goto L90;
        r77.c("enter_method", (String) ((com.bytedance.android.livesdk.log.filter.a) r81).b.get("enter_method"));
    L90:
        if (((com.bytedance.android.livesdk.log.filter.a) r81).b.containsKey("action_type") == false) goto L92;
        r77.c("action_type", (String) ((com.bytedance.android.livesdk.log.filter.a) r81).b.get("action_type"));
    L92:
        s0 r82 = com.bytedance.android.livesdk.log.u.l().c(Room.class);
        if ((r82 instanceof s0) == false) goto L104;
        s0 r83 = r82;
        if (((com.bytedance.android.livesdk.log.filter.a) r83).b.containsKey("anchor_id") == false) goto L98;
        r77.c("anchor_id", (String) ((com.bytedance.android.livesdk.log.filter.a) r83).b.get("anchor_id"));
    L98:
        if (((com.bytedance.android.livesdk.log.filter.a) r83).b.containsKey("log_pb") == false) goto L101;
        r77.c("log_pb", (String) ((com.bytedance.android.livesdk.log.filter.a) r83).b.get("log_pb"));
    L101:
        if (((com.bytedance.android.livesdk.log.filter.a) r83).b.containsKey("request_id") == false) goto L104;
        r77.c("request_id", (String) ((com.bytedance.android.livesdk.log.filter.a) r83).b.get("request_id"));
    L104:
        if (r36.isVcdContentAuthorized() == false) goto L106;
        String r84 = "1";
    L107:
        r77.c("is_reported_user_authorized", r84);
        r77.c("room_layout", "normal");
        int r85 = xp1.a.a[r31.getStreamType().ordinal()];
        String r86 = "video_live";
        if (r85 == 1) goto L112;
        if (r85 == 2) goto L111;
        String r87 = "video_live";
    L114:
        if (Intrinsics.areEqual(r35.reportType, "report_discussion_message_user") == false) goto L116;
        r77.c("report_scene", "vs");
    L117:
        r77.c("live_type", r86);
        r77.c("is_sale", "0");
        r77.c("livesdk_profile_hide_confirm", "0");
        if (StringsKt.startsWith$default(r76, "sslocal", false, 2, null) == false) goto L122;
        IBaseLiveActionHandler r88 = k.f(IBaseLiveActionHandler.class);
        if (r88 == null) goto L123;
        r88.handle(com.bytedance.android.live.core.utils.a.d(), r77.d());
        goto L123
    L122:
        TTLiveSDKContext.getHostService().a().openLiveBrowser(r77.d(), new Bundle(), r72);
        goto L123
    L116:
        r86 = r87;
        goto L117
    L111:
        r87 = "third_party";
        goto L114
    L112:
        r87 = "voice_live";
        goto L114
    L106:
        r84 = "0";
    L123:
        return true;
    L64:
        if (com.bytedance.android.livesdk.chatroom.vs_base.base.util.a.c == false) goto L124;
    L53:
        r6 = null;
    L58:
        r8 = true;
        goto L60
    L48:
        r5 = null;
        goto L50
    L41:
        r4 = null;
        goto L43
    L37:
        if ((r31 instanceof EpisodeCompatDelegate) == false) goto L39;
        ((EpisodeCompatDelegate) r31).getEpisode();
        goto L39
    L32:
        r7 = r33;
    L18:
        if (loginCheck(r32, r37) == true) goto L20;
        return false;
    }
}
