package com.bytedance.android.live.room.report;

import am2.n;
import am2.x;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.room.api.IReportService;
import com.bytedance.android.live.room.api.report.ReportObject;
import com.bytedance.android.live.room.api.userinfo.event.ReportConstant$BusinessSource;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.config.oc;
import com.bytedance.android.livesdk.config.pc;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.schema.interfaces.ILiveActionHandler;
import com.bytedance.android.livesdkapi.ILiveOntologyInfoManager;
import com.bytedance.android.livesdkapi.TTLiveService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.service.ILiveService;
import com.bytedance.live.datacontext.i;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import jc1.k;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zg1.r2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b3\u00104J\f\u0010\u0003\u001a\u00020\u0002*\u00020\u0002H\u0002J\u001e\u0010\u0007\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0002J.\u0010\u0011\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0017J\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0016JL\u0010\u0014\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J$\u0010\u001d\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\r\u001a\u0004\u0018\u00010\u0015H\u0016J8\u0010#\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010 \u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\u00152\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016J$\u0010'\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u00042\b\u0010$\u001a\u0004\u0018\u00010\u00042\u0006\u0010&\u001a\u00020%H\u0016J\u0012\u0010'\u001a\u0004\u0018\u00010)2\u0006\u0010(\u001a\u00020\u0012H\u0016J\u001c\u0010*\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u00042\b\u0010$\u001a\u0004\u0018\u00010\u0004H\u0016R\u0014\u0010+\u001a\u00020\u00048\u0002X\u0082D¢\u0006\u0006\n\u0004\b+\u0010,R\u001b\u00102\u001a\u00020-8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101¨\u00065"}, d2 = {"Lcom/bytedance/android/live/room/report/ReportService;", "Lcom/bytedance/android/live/room/api/IReportService;", "Landroid/net/Uri$Builder;", "appendExtraParam", "", "key", "value", "appendQueryParameterIfNoNull", "Lcom/bytedance/android/live/room/api/userinfo/event/ReportConstant$BusinessSource;", "businessSource", "Lcom/bytedance/android/live/base/model/user/User;", "targetUser", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "room", "Lcom/bytedance/android/livesdk/chatroom/event/UserProfileEvent;", "userProfileEvent", "", "reportWithUserProfileEvent", "Ly71/a;", "reportParamsWrapper", "report", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "fromSource", "reportSource", "reportTypeForLog", "Lzg1/u;", "commentReportModel", "Lzg1/r2;", "reportAnchorEvent", "reportWithReportAnchorEvent", "Landroid/content/Context;", "context", "anchor", "Landroid/content/DialogInterface$OnDismissListener;", "dismissCallback", "screenShotReport", "reportType", "", "isReportMessage", "getReportType", "params", "Lcom/bytedance/android/live/room/api/report/ReportObject;", "getRequestPage", "TAG", "Ljava/lang/String;", "Lcom/bytedance/android/live/room/report/LiveReportManager;", "reportManager$delegate", "Lkotlin/Lazy;", "getReportManager", "()Lcom/bytedance/android/live/room/report/LiveReportManager;", "reportManager", "<init>", "()V", "experience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ReportService implements IReportService {
    private final String TAG;
    private final Lazy reportManager$delegate;

    private final LiveReportManager getReportManager() {
        return (LiveReportManager) this.reportManager$delegate.getValue();
    }

    public ReportService() {
        this.TAG = "ReportService";
        this.reportManager$delegate = LazyKt.lazy(ReportService$reportManager$2.INSTANCE);
    }

    private final Uri.Builder appendExtraParam(Uri.Builder r4) {
        Map r0 = (Map) pc.a.getValue();
        if (r0 == null) goto L8;
        Iterator r1 = r0.entrySet().iterator();
    L6:
        if (r1.hasNext() == false) goto L8;
        Map.Entry r2 = (Map.Entry) r1.next();
        r4.appendQueryParameter((String) r2.getKey(), (String) r2.getValue());
    L8:
        return r4;
    }

    @Override // com.bytedance.android.live.room.api.report.IMiddlewareReportService
    public ReportObject getReportType(y71.a r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
        int r0 = g.k;
        g r3 = g.a.a(r2);
        if (r3 != null) goto L7;
        return null;
    L7:
        return f.a(r3);
    }

    @Override // com.bytedance.android.live.room.api.IReportService, com.bytedance.android.live.room.api.report.IMiddlewareReportService
    public void report(y71.a r4) {
        Intrinsics.checkNotNullParameter(r4, "reportParamsWrapper");
        Map<String, String> r0 = ReportTracer.a;
        ReportTracer.h(r4.i, r4.a, r4.b);
        int r1 = c.a;
        if (c.c(r4.i, r4.a, r4.b) == true) goto L5;
        return;
    L5:
        int r2 = g.k;
        g r5 = g.a.a(r4);
        if (r5 != null) goto L8;
        return;
    L8:
        getReportManager().c(r5);
    }

    @Override // com.bytedance.android.live.room.api.IReportService, com.bytedance.android.live.room.api.report.IMiddlewareReportService
    public String getRequestPage(String r2, String r3) {
        e.a.getClass();
        return e.a.a(r2, r3);
    }

    private final Uri.Builder appendQueryParameterIfNoNull(Uri.Builder r2, String r3, String r4) {
        if (r4 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == true) goto L10;
        r2.appendQueryParameter(r3, r4);
    L10:
        return r2;
    L4:
        if (r4.length() == 0) goto L7;
        r0 = false;
        goto L8
    }

    @Override // com.bytedance.android.live.room.api.IReportService, com.bytedance.android.live.room.api.report.IMiddlewareReportService
    public String getReportType(String r2, String r3, boolean r4) {
        return e.a.getType(r2, r3, r4);
    }

    @Override // com.bytedance.android.live.room.api.IReportService
    public void reportWithReportAnchorEvent(ReportConstant$BusinessSource r12, r2 r13, Room r14) {
        Intrinsics.checkNotNullParameter(r12, "businessSource");
        Map<String, String> r1 = ReportTracer.a;
        Intrinsics.checkNotNullParameter(r12, "businessSource");
        Map<String, String> r2 = ReportTracer.a;
        if (r2 == null) goto L5;
        ((LinkedHashMap) r2).clear();
    L5:
        ReportTracer.a = null;
        LinkedHashMap r3 = new LinkedHashMap();
        ReportTracer.a = r3;
        String r4 = (String) r3.put("business_source", r12.getBusinessType());
        Map<String, String> r5 = ReportTracer.a;
        if (r5 == null) goto L16;
        IUserService r6 = k.f(IUserService.class);
        if (r6 == null) goto L14;
        com.bytedance.android.livesdk.user.f r7 = r6.user();
        if (r7 == null) goto L14;
        IUser r8 = r7.b();
        if (r8 == null) goto L14;
        String r9 = r8.getIdString();
    L15:
        String r10 = r5.put("current_user_id", String.valueOf(r9));
    L14:
        r9 = null;
    L16:
        Map<String, String> r15 = ReportTracer.a;
        if (r15 == null) goto L27;
        IUserService r16 = k.f(IUserService.class);
        if (r16 == null) goto L25;
        com.bytedance.android.livesdk.user.f r17 = r16.user();
        if (r17 == null) goto L25;
        IUser r18 = r17.b();
        if (r18 == null) goto L25;
        Intrinsics.checkNotNullParameter(r18, "$this$secUidExt");
        String r19 = r18.getCastSecUid();
    L26:
        String r20 = r15.put("sec_current_user_id", String.valueOf(r19));
    L25:
        r19 = null;
    L27:
        Map<String, String> r22 = ReportTracer.a;
        if (r22 == null) goto L33;
        if (r14 == null) goto L31;
        Long r23 = Long.valueOf(r14.getId());
    L32:
        String r24 = r22.put("room_id", String.valueOf(r23));
        goto L33
    L31:
        r23 = null;
    L33:
        Map<String, String> r25 = ReportTracer.a;
        if (r25 == null) goto L39;
        if (r14 == null) goto L37;
        String r26 = r14.getOwnerUserIdString();
    L38:
        String r27 = r25.put("anchor_id", String.valueOf(r26));
        goto L39
    L37:
        r26 = null;
    L39:
        Map<String, String> r28 = ReportTracer.a;
        if (r28 == null) goto L48;
        if (r14 == null) goto L45;
        IBaseUser r29 = r14.getOwner();
        if (r29 == null) goto L45;
        Intrinsics.checkNotNullParameter(r29, "$this$secUidExt");
        String r30 = r29.getCastSecUid();
    L46:
        String r32 = r28.put("sec_anchor_id", String.valueOf(r30));
    L45:
        r30 = null;
    L48:
        if (r13 == null) goto L64;
        Map<String, String> r33 = ReportTracer.a;
        if (r33 == null) goto L55;
        String r34 = r13.a;
        if (r34 != null) goto L54;
        r34 = "";
    L54:
        String r35 = r33.put("sec_anchor_id", r34);
    L55:
        Map<String, String> r36 = ReportTracer.a;
        if (r36 == null) goto L58;
        String r37 = r36.put("room_id", String.valueOf(r13.b));
    L58:
        Map<String, String> r38 = ReportTracer.a;
        if (r38 == null) goto L64;
        String r39 = r13.c;
        if (r39 != null) goto L63;
        r39 = "";
    L63:
        String r40 = r38.put("sec_user_id", r39);
    L64:
        Map<String, String> r42 = ReportTracer.a;
        if (r42 == null) goto L71;
        o r43 = u.l().c(x.class);
        o r44 = u.l().c(Room.class);
        if (r43 == null) goto L69;
        r43.a(r42);
    L69:
        if (r44 == null) goto L71;
        r44.a(r42);
    L71:
        ReportTracer.b(ReportTracer.EventName.call_start);
        ReportTracer.c(ReportTracer.EventName.call_function, ReportTracer.CallFunction.reportWithReportAnchorEvent);
        int r45 = c.a;
        Intrinsics.checkNotNullParameter(r12, "businessSource");
        ReportTracer.b(ReportTracer.EventName.params_check);
        boolean r46 = false;
        if (c.f() == true) goto L74;
    L92:
        if (r46 == true) goto L94;
        return;
    L94:
        if (r14 != null) goto L96;
        return;
    L96:
        if (r13 != null) goto L98;
        return;
    L98:
        LiveReportManager r47 = getReportManager();
        r47.getClass();
        Intrinsics.checkNotNullParameter(r12, "businessSource");
        Intrinsics.checkNotNullParameter(r14, "room");
        Intrinsics.checkNotNullParameter(r13, "event");
        ReportTracer.b(ReportTracer.EventName.direct_report_anchor);
        xs2.b.a().post(new r2("", 0, ""));
        RoomContext r110 = RoomContext.a.c(RoomContext.Companion, null, r14.getRoomId(), 1);
        if (r110 == null) goto L105;
        i r111 = r110.isAnchor();
        if (r111 == null) goto L105;
        if (((Boolean) r111.getValue()).booleanValue() != true) goto L105;
        LiveReportManager.d(r14, r13, null);
        return;
    L105:
        r47.e(r14, r13, null);
        return;
    L74:
        if (c.e() == false) goto L92;
        if (r13 != null) goto L79;
        d.a("reportAnchorEvent is null");
        ReportTracer.f("reportAnchorEvent is null");
    L87:
        boolean r48 = false;
    L88:
        if (r48 == false) goto L92;
        if (c.b(r14) == false) goto L92;
        r46 = true;
        goto L92
    L79:
        if (c.d(r13.a) == false) goto L81;
    L86:
        d.a("reportAnchorEvent's secAnchorId or secUserId is empty, or roomId is 0L");
        ReportTracer.f("reportAnchorEvent's secAnchorId or secUserId is empty, or roomId is 0L");
        goto L87
    L81:
        if (r13.b == 0) goto L86;
        if (c.d(r13.c) == true) goto L86;
        r48 = true;
        goto L88
    }

    @Override // com.bytedance.android.live.room.api.IReportService
    @Deprecated(message = "不要用这个方法！！！！，这是方法是为了兼容资料卡的旧逻辑")
    public void reportWithUserProfileEvent(ReportConstant$BusinessSource r12, User r13, IRoom r14, UserProfileEvent r15) {
        Intrinsics.checkNotNullParameter(r12, "businessSource");
        ReportTracer.h(r12, r13, r14);
        ReportTracer.c(ReportTracer.EventName.call_function, ReportTracer.CallFunction.reportWithUserProfileEvent);
        int r3 = c.a;
        Intrinsics.checkNotNullParameter(r12, "businessSource");
        ReportTracer.b(ReportTracer.EventName.params_check);
        boolean r4 = false;
        if (c.f() == true) goto L5;
    L17:
        if (r4 == true) goto L19;
        return;
    L19:
        int r5 = g.k;
        Intrinsics.checkNotNullParameter(r12, "businessSource");
        ReportTracer.b(ReportTracer.EventName.generate_report_params);
        g r2 = null;
        if (r15 == null) goto L22;
        String r6 = r15.mSource;
    L23:
        if (r15 == null) goto L25;
        String r7 = r15.mReportSource;
    L26:
        if (r15 == null) goto L28;
        String r8 = r15.mReportTypeForLog;
    L29:
        if (r15 == null) goto L31;
        zg1.u r9 = r15.mCommentReportModel;
    L32:
        ReportTracer.a(r6, r7, r8, r9);
        if (r13 == null) goto L50;
        if (r14 == null) goto L50;
        if (r15 == null) goto L50;
        String r10 = r15.mSource;
        if (r10 != null) goto L40;
        String r16 = "";
    L41:
        String r17 = r15.mReportSource;
        if (r17 != null) goto L44;
        String r18 = "";
    L45:
        String r19 = r15.mReportTypeForLog;
        if (r19 != null) goto L48;
        String r20 = "";
    L49:
        r2 = new g(r12, r13, r14, r16, r18, r20, r15.mCommentReportModel, Intrinsics.areEqual(r13.getIdString(), r14.getOwnerUserIdString()));
        goto L50
    L48:
        r20 = r19;
        goto L49
    L44:
        r18 = r17;
        goto L45
    L40:
        r16 = r10;
    L50:
        if (r2 != null) goto L52;
        return;
    L52:
        getReportManager().c(r2);
        return;
    L31:
        r9 = null;
        goto L32
    L28:
        r8 = null;
        goto L29
    L25:
        r7 = null;
        goto L26
    L22:
        r6 = null;
        goto L23
    L5:
        if (c.e() == false) goto L17;
        if (c.a(r13) == false) goto L17;
        if (c.b(r14) == false) goto L17;
        if (r15 != null) goto L14;
        d.a("userProfileEvent is null");
        ReportTracer.f("userProfileEvent is null");
        boolean r22 = false;
    L15:
        if (r22 == false) goto L17;
        r4 = true;
        goto L17
    L14:
        r22 = true;
        goto L15
    }

    @Override // com.bytedance.android.live.room.api.IReportService, com.bytedance.android.live.room.api.report.IMiddlewareReportService
    public void reportWithUserProfileEvent(ReportConstant$BusinessSource r3, IBaseUser r4, IRoom r5, UserProfileEvent r6) {
        Intrinsics.checkNotNullParameter(r3, "businessSource");
        Intrinsics.checkNotNullParameter(r3, "businessSource");
        if ((r4 instanceof User) == true) goto L5;
        r4 = null;
    L5:
        User r7 = (User) r4;
        if (r7 != null) goto L9;
        return;
    L9:
        if ((r5 instanceof Room) == true) goto L11;
        r5 = null;
    L11:
        Room r8 = (Room) r5;
        if (r8 == null) goto L17;
        reportWithUserProfileEvent(r3, r7, r8, r6);
        return;
    }

    @Override // com.bytedance.android.live.room.api.IReportService
    public void screenShotReport(ReportConstant$BusinessSource r7, Context r8, User r9, Room r10, DialogInterface.OnDismissListener r12) {
        Intrinsics.checkNotNullParameter(r7, "businessSource");
        ReportTracer.h(r7, r9, r10);
        ReportTracer.c(ReportTracer.EventName.call_function, ReportTracer.CallFunction.screenShotReport);
        String r13 = null;
        if (r9 == null) goto L5;
        String r14 = r9.getCastSecUid();
    L7:
        if (r14 != null) goto L9;
    L12:
        boolean r15 = true;
    L13:
        if (r15 == false) goto L16;
        d.a("anchor secUid is empty");
        ReportTracer.f("anchor secUid is empty");
        return;
    L16:
        ReportTracer.b(ReportTracer.EventName.generate_screen_shot_report_url);
        String r16 = (String) oc.a.getValue();
        if (r16 != null) goto L19;
        return;
    L19:
        Uri.Builder r17 = UriProtector.parse(r16).buildUpon().appendQueryParameter("request_page", "live_screenshot").appendQueryParameter("sec_target_anchor_id", r9.getCastSecUid()).appendQueryParameter("type", "popup").appendQueryParameter("gravity", "bottom");
        o r4 = u.l().c(x.class);
        if (r4 == null) goto L24;
        Map r5 = r4.getMap();
        if (r5 == null) goto L24;
        String r6 = (String) r5.get("enter_from_merge");
    L25:
        Uri.Builder r18 = appendQueryParameterIfNoNull(r17, "enter_from_merge", r6);
        ILiveService r19 = TTLiveService.getLiveService();
        if (r19 == null) goto L30;
        ILiveOntologyInfoManager r20 = r19.getLiveOntologyRecord();
        if (r20 == null) goto L30;
        String r22 = r20.getEnterFromMerge();
    L31:
        Uri.Builder r23 = appendQueryParameterIfNoNull(r18, "drawer_page", r22);
        o r24 = u.l().c(n.class);
        if (r24 == null) goto L36;
        Map r25 = r24.getMap();
        if (r25 == null) goto L36;
        r13 = (String) r25.get("is_other_channel");
    L36:
        Uri r26 = appendQueryParameterIfNoNull(r23, "is_other_channel", r13).build();
        if ((!Intrinsics.areEqual("webcast_webview", r26.getHost())) == false) goto L39;
        r26 = appendExtraParam(UriProtector.parse("sslocal://webcast_webview").buildUpon().appendQueryParameter("url", r26.toString()).appendQueryParameter("type", "popup").appendQueryParameter("gravity", "bottom")).build();
    L39:
        ReportTracer.b(ReportTracer.EventName.open_screen_shot_report_page);
        if (r12 == null) goto L44;
        ILiveActionHandler r27 = k.f(ILiveActionHandler.class);
        if (r27 == null) goto L47;
        r27.handleWithCallback(r8, r26, r12);
    L47:
        ReportTracer.g();
        return;
    L44:
        ILiveActionHandler r28 = k.f(ILiveActionHandler.class);
        if (r28 == null) goto L47;
        r28.handle(r8, r26);
    L30:
        r22 = null;
    L24:
        r6 = null;
        goto L25
    L9:
        if (r14.length() == 0) goto L12;
        r15 = false;
        goto L13
    L5:
        r14 = null;
        goto L7
    }

    @Override // com.bytedance.android.live.room.api.IReportService
    public void report(ReportConstant$BusinessSource r12, User r13, Room r14, String r15, String r16, String r17, zg1.u r18) {
        Intrinsics.checkNotNullParameter(r12, "businessSource");
        ReportTracer.h(r12, r13, r14);
        ReportTracer.c(ReportTracer.EventName.call_function, ReportTracer.CallFunction.report);
        if (c.c(r12, r13, r14) == true) goto L5;
        return;
    L5:
        int r2 = g.k;
        Intrinsics.checkNotNullParameter(r12, "businessSource");
        ReportTracer.b(ReportTracer.EventName.generate_report_params);
        ReportTracer.a(r15, r16, r17, r18);
        if (r13 == null) goto L20;
        if (r14 == null) goto L20;
        if (r15 != null) goto L12;
        String r4 = "";
    L13:
        if (r16 != null) goto L15;
        String r5 = "";
    L16:
        if (r17 != null) goto L18;
        String r6 = "";
    L19:
        g r9 = new g(r12, r13, r14, r4, r5, r6, r18, Intrinsics.areEqual(r13.getIdString(), r14.getOwnerUserIdString()));
    L21:
        if (r9 != null) goto L23;
        return;
    L23:
        getReportManager().c(r9);
        return;
    L18:
        r6 = r17;
        goto L19
    L15:
        r5 = r16;
        goto L16
    L12:
        r4 = r15;
    L20:
        r9 = null;
        goto L21
    }
}
