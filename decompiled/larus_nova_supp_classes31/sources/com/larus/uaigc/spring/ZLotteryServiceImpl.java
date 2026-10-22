package com.larus.uaigc.spring;

import com.bytedance.keva.Keva;
import com.larus.common.apphost.AppHost;
import com.larus.common.pollingconfig.api.PollingConfigService;
import com.larus.im.bean.message.Message;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.o;
import com.larus.platform.service.z2;
import com.larus.uaigc.lynx.LotteryPollingConfigProvider;
import com.larus.uaigc.service.IZLotteryService;
import com.larus.uaigc.spring.lottery.ZLotteryGuideCell;
import com.larus.uaigc.spring.lottery.ZLotteryMobHelper;
import com.larus.uaigc.spring.lottery.e;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import hy9.b;
import hy9.g;
import hy9.i;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 72\u00020\u0001:\u00017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00112\u0006\u0010\t\u001a\u00020\nH\u0016J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\t\u001a\u00020\nH\u0016J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0015\u001a\u00020\rH\u0016J\b\u0010\u0016\u001a\u00020\nH\u0016J\b\u0010\u0017\u001a\u00020\nH\u0016J\b\u0010\u0018\u001a\u00020\nH\u0016J\u0010\u0010\u0019\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u001a\u001a\u00020\u000fH\u0016J\u0010\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0018\u0010\u001f\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0018\u0010 \u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0018\u0010!\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\"\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010#\u001a\u00020\u000fH\u0016J\b\u0010$\u001a\u00020\u000fH\u0016J\b\u0010%\u001a\u00020\nH\u0016J\b\u0010&\u001a\u00020\nH\u0016J\b\u0010'\u001a\u00020\nH\u0016JI\u0010(\u001a\u00020\u000f2\u0006\u0010)\u001a\u00020\u001d2\u0006\u0010*\u001a\u00020\n2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u001d2\u0006\u0010.\u001a\u00020\r2\b\u0010/\u001a\u0004\u0018\u00010\u001d2\b\u00100\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0002\u00101J\u0012\u00102\u001a\u0004\u0018\u0001032\u0006\u00104\u001a\u000205H\u0016J\u0010\u00106\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005H\u0016¨\u00068"}, d2 = {"Lcom/larus/uaigc/spring/ZLotteryServiceImpl;", "Lcom/larus/uaigc/service/IZLotteryService;", "<init>", "()V", "guidePollingConfigFlow", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/larus/uaigc/bean/GuidePullingConfigData;", "getCurHostReadState", "Lcom/larus/uaigc/bean/HostReadState;", "useCache", "", "isZLotteryGuideCardDisabled", "roundNum", "", "onEnterZMainPage", "", "getRoundList", "", "Lcom/larus/uaigc/bean/LotteryRoundInfo;", "getCurRound", "getCurRoundWithFront", "front", "isInLotteryRound", "isInNoPreheatingLotteryRound", "getCurRoundLotteryState", "getRoundLotteryState", "storeCurRoundLotteryState", "getNonLotteryShuffleTimes", "segmentId", "", "appendNonLotteryShuffleTimes", "getRoundBeginShuffleTimes", "appendBeginShuffleTimes", "getRoundShuffleTimes", "appendShuffleTimes", "storeShowLoadingButtonState", "storeSendNewYearAvatarMessageStatus", "getSendNewYearAvatarMessageStatus", "getShowLoadingButtonState", "disableOnboardingAndWcbNow", "reportPocketMessageCardShowed", "messageId", "lynxViewLoadSuccess", "createToLynxDuration", "", "cardType", "errorCode", "errorMsg", "isStream", "(Ljava/lang/String;ZJLjava/lang/String;ILjava/lang/String;Ljava/lang/Boolean;)V", "createZLotteryGuideCellState", "Lcom/larus/bmhome/chat/cell/BaseMessageCellState;", "msg", "Lcom/larus/im/bean/message/Message;", "zLotteryGuideMsgShowFlow", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class ZLotteryServiceImpl implements IZLotteryService {

    public static final class a {
    }

    static {
    }

    public ZLotteryServiceImpl() {
    }

    @Override // com.larus.uaigc.service.IZLotteryService
    public final List e() {
        return LotteryPollingConfigProvider.b(true);
    }

    @Override // com.larus.uaigc.service.IZLotteryService
    public final g n() {
        return LotteryPollingConfigProvider.a(true).d;
    }

    @Override // com.larus.uaigc.service.IZLotteryService
    public final void q() {
    }

    @Override // com.larus.uaigc.service.IZLotteryService
    public final void b() {
        Keva r0 = com.larus.uaigc.spring.lottery.g.a;
        String r1 = "show_loading_button_".concat(o.a.getDeviceId());
        com.larus.uaigc.spring.lottery.g.a.storeBoolean(r1, true);
    }

    @Override // com.larus.uaigc.service.IZLotteryService
    public final boolean d() {
        Keva r0 = com.larus.uaigc.spring.lottery.g.a;
        String r1 = "show_loading_button_".concat(o.a.getDeviceId());
        return com.larus.uaigc.spring.lottery.g.a.getBoolean(r1, false);
    }

    @Override // com.larus.uaigc.service.IZLotteryService
    public final boolean f() {
        Lazy r0 = LotteryPollingConfigProvider.a;
        if (z2.a.K3() == false) goto L15;
        i r1 = (i) ((i1) LotteryPollingConfigProvider.f.getValue()).getValue();
        if (r1 == null) goto L12;
        Integer r2 = r1.b();
        if (r2 == null) goto L12;
        if (r2.intValue() != 1) goto L12;
        boolean r3 = true;
    L13:
        if (r3 == true) goto L15;
        boolean r4 = true;
    L17:
        if (r4 == false) goto L19;
        FLogger.a.i("LotteryPollingConfigProvider", "[disableOnboardingAndWcbNow] return false for zShowGuideReverse");
        return false;
    L19:
        i r5 = (i) ((i1) LotteryPollingConfigProvider.f.getValue()).getValue();
        if (r5 == null) goto L22;
        List<Long> r6 = r5.c();
    L23:
        FLogger r7 = FLogger.a;
        r7.i("LotteryPollingConfigProvider", "disableOnboardingAndWcbNow trigger, onboardingTimeMsList: " + r6);
        if (r6 != null) goto L27;
        return false;
    L27:
        if (r6.size() < 2) goto L53;
        Long r8 = PollingConfigService.a.c();
        if (r8 != null) goto L32;
        r7.e("LotteryPollingConfigProvider", "disableOnboardingAndWcbNow failed, curTimeMs is null");
        return false;
    L32:
        int r9 = ProgressionUtilKt.getProgressionLastElement(0, r6.size() - 2, 2);
        if (r9 < 0) goto L50;
        int r10 = 0;
    L35:
        Long r11 = (Long) CollectionsKt.getOrNull(r6, r10);
        Long r12 = (Long) CollectionsKt.getOrNull(r6, r10 + 1);
        if (r11 == null) goto L44;
        if (r12 == null) goto L44;
        if (r8.longValue() < r11.longValue()) goto L44;
        if (r8.longValue() >= r12.longValue()) goto L44;
        FLogger.a.i("LotteryPollingConfigProvider", "disableOnboardingAndWcbNow return true");
        return true;
    L44:
        if (r10 == r9) goto L54;
        r10 = r10 + 2;
        goto L35
    L54:
        return false;
    L50:
        return false;
    L53:
        return false;
    L22:
        r6 = null;
    L12:
        r3 = false;
    L15:
        r4 = false;
        goto L17
    }

    @Override // com.larus.uaigc.service.IZLotteryService
    public final void r() {
        Keva r0 = com.larus.uaigc.spring.lottery.g.a;
        String r1 = "send_new_year_msg_".concat(o.a.getDeviceId());
        com.larus.uaigc.spring.lottery.g.a.storeBoolean(r1, true);
    }

    @Override // com.larus.uaigc.service.IZLotteryService
    public final boolean v() {
        Keva r0 = com.larus.uaigc.spring.lottery.g.a;
        String r1 = "send_new_year_msg_".concat(o.a.getDeviceId());
        return com.larus.uaigc.spring.lottery.g.a.getBoolean(r1, false);
    }

    @Override // com.larus.uaigc.service.IZLotteryService
    public final void a() {
        g r0 = n();
        if (r0 == null) goto L5;
        Integer r1 = r0.d();
    L6:
        if (r1 == null) goto L8;
        com.larus.uaigc.spring.lottery.g.a.storeBoolean(com.larus.uaigc.spring.lottery.g.a(r1.intValue()), true);
    L8:
        FLogger.a.i("ZLotteryServiceImpl", "[storeCurRoundLotteryState] roundNum = " + r1);
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.larus.uaigc.service.IZLotteryService
    public final boolean k() {
        g r0 = n();
        List r2 = LotteryPollingConfigProvider.b(true);
        if (r0 != null) goto L5;
    L20:
        return false;
    L5:
        if (r0.d() == null) goto L20;
        if (r2 != null) goto L8;
    L10:
        boolean r4 = false;
    L11:
        if (r4 == false) goto L20;
        Iterator r3 = r2.iterator();
    L14:
        if (r3.hasNext() == false) goto L20;
        g r5 = (g) r3.next();
        FLogger.a.i("ZLotteryServiceImpl", "[isInLotteryRound] curRound start = " + r0.a() + ", end = " + r0.b() + ", roundNum = " + r0.d() + ", forEach roundNum = " + r5.d());
        if (r5.d() == null) goto L14;
        if (Intrinsics.areEqual(r5.d(), r0.d()) == false) goto L14;
        return true;
    L8:
        if ((!r2.isEmpty()) != true) goto L10;
        r4 = true;
        goto L11
    }

    @Override // com.larus.uaigc.service.IZLotteryService
    public final boolean o() {
        g r0 = n();
        List r2 = LotteryPollingConfigProvider.b(true);
        if (r0 != null) goto L5;
    L25:
        return false;
    L5:
        if (r0.d() == null) goto L25;
        if (r2 != null) goto L8;
    L10:
        boolean r4 = false;
    L11:
        if (r4 == false) goto L25;
        Iterator r3 = r2.iterator();
    L14:
        if (r3.hasNext() == false) goto L25;
        g r5 = (g) r3.next();
        FLogger.a.i("ZLotteryServiceImpl", "[isInNoPreheatingLotteryRound] curRound start = " + r0.a() + ", end = " + r0.b() + ", roundNum = " + r0.d() + ", forEach roundNum = " + r5.d());
        if (r5.d() == null) goto L14;
        if (Intrinsics.areEqual(r5.d(), r0.d()) == false) goto L14;
        Integer r6 = r5.e();
        if (r6 == null) goto L14;
        if (r6.intValue() != 1) goto L14;
        return true;
    L8:
        if ((!r2.isEmpty()) != true) goto L10;
        r4 = true;
        goto L11
    }

    @Override // com.larus.uaigc.service.IZLotteryService
    public final boolean t() {
        g r0 = n();
        if (r0 == null) goto L5;
        Integer r1 = r0.d();
    L6:
        boolean r2 = false;
        if (r1 == null) goto L9;
        r2 = com.larus.uaigc.spring.lottery.g.a.getBoolean(com.larus.uaigc.spring.lottery.g.a(r1.intValue()), false);
    L9:
        FLogger.a.i("ZLotteryServiceImpl", "[getCurRoundLotteryState] roundNum = " + r1 + ", state = " + r2);
        return r2;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.larus.uaigc.service.IZLotteryService
    public final i1<Boolean> E() {
        return ZLotteryGuideCell.m;
    }

    @Override // com.larus.uaigc.service.IZLotteryService
    public final g c(int r18) {
        List r2 = LotteryPollingConfigProvider.b(true);
        Long r3 = PollingConfigService.a.c();
        if (r3 == null) goto L5;
        long r4 = r3.longValue();
    L6:
        Iterator r5 = r2.iterator();
        int r7 = 0;
    L8:
        if (r5.hasNext() == false) goto L25;
        g r8 = (g) r5.next();
        long r11 = ((long) r18) + r4;
        FLogger.a.i("LotteryPollingConfigProvider", "[getCurHostReadStateWithFront] beginMs = " + r8.a() + ", endMs = " + r8.b() + ", front = " + r18 + ", realTimeMs = " + r4 + ", curTimeMs = " + r11);
        if (r8.a() != null) goto L12;
    L21:
        boolean r9 = false;
    L22:
        if (r9 == true) goto L26;
        r7 = r7 + 1;
    L26:
        g r15 = (g) CollectionsKt.getOrNull(r2, r7);
        FLogger.a.i("LotteryPollingConfigProvider", "[getCurHostReadStateWithFront] roundList = " + r2.size() + ", realTimeMs = " + r4 + ", index = " + r7);
        if (r15 != null) goto L29;
        b r0 = new b(Long.valueOf(r4), 15);
    L43:
        return r0.d;
    L29:
        Integer r6 = r15.d();
        if (r6 == null) goto L32;
        int r13 = r6.intValue();
    L33:
        Long r10 = r15.c();
        if (r10 == null) goto L36;
        long r12 = r10.longValue();
    L38:
        if (r4 < r12) goto L40;
        boolean r14 = true;
    L41:
        r0 = new b(true, r13, r14, r15, Long.valueOf(r4));
        goto L43
    L40:
        r14 = false;
        goto L41
    L36:
        r12 = 0;
        goto L38
    L32:
        r13 = r7 + 1;
        goto L33
    L12:
        if (r8.b() == null) goto L21;
        Long r16 = r8.a();
        Intrinsics.checkNotNull(r16);
        long r17 = r16.longValue();
        Long r19 = r8.b();
        Intrinsics.checkNotNull(r19);
        if (r11 < r19.longValue()) goto L16;
    L18:
        boolean r20 = false;
    L19:
        if (r20 == false) goto L21;
        r9 = true;
        goto L22
    L16:
        if (r17 > r11) goto L18;
        r20 = true;
        goto L19
    L25:
        r7 = -1;
        goto L26
    L5:
        r4 = AppHost.a.getAppClock().currentTimeMillis();
        goto L6
    }

    @Override // com.larus.uaigc.service.IZLotteryService
    public final void g(String r9) {
        Intrinsics.checkNotNullParameter(r9, "segmentId");
        g r1 = n();
        if (r1 == null) goto L5;
        Integer r2 = r1.d();
    L7:
        if (r2 == null) goto L9;
        int r3 = r2.intValue();
        Keva r4 = com.larus.uaigc.spring.lottery.g.a;
        Intrinsics.checkNotNullParameter(r9, "segmentId");
        String r0 = "shuffle_p_" + r9 + '_' + r3;
        Keva r5 = com.larus.uaigc.spring.lottery.g.a;
        int r6 = r5.getInt(r0, 0);
        FLogger.a.i("ZLotteryStateRecoder", "[appendShuffleTimes] currShuffleTimes = " + r6 + ", segmentId = " + r9);
        r5.storeInt(r0, r6 + 1);
    L9:
        FLogger.a.i("ZLotteryServiceImpl", "[appendShuffleTimes] roundNum = " + r2 + ", segmentId = " + r9);
        return;
    L5:
        r2 = null;
        goto L7
    }

    @Override // com.larus.uaigc.service.IZLotteryService
    public final b h(boolean r1) {
        return LotteryPollingConfigProvider.a(r1);
    }

    @Override // com.larus.uaigc.service.IZLotteryService
    public final boolean j(int r3) {
        String r4 = com.larus.uaigc.spring.lottery.g.a(r3);
        return com.larus.uaigc.spring.lottery.g.a.getBoolean(r4, false);
    }

    @Override // com.larus.uaigc.service.IZLotteryService
    public final void l(String r7) {
        Intrinsics.checkNotNullParameter(r7, "segmentId");
        Keva r1 = com.larus.uaigc.spring.lottery.g.a;
        Intrinsics.checkNotNullParameter(r7, "segmentId");
        String r0 = "n_lottery_shuffle_p_".concat(r7);
        Keva r2 = com.larus.uaigc.spring.lottery.g.a;
        int r3 = r2.getInt(r0, 0);
        FLogger r4 = FLogger.a;
        r4.i("ZLotteryStateRecoder", "[appendNonLotteryShuffleTimes] currShuffleTimes = " + r3 + ", segmentId = " + r7);
        r2.storeInt(r0, r3 + 1);
        r4.i("ZLotteryServiceImpl", "[appendNonLotteryShuffleTimes] segmentId = ".concat(r7));
    }

    @Override // com.larus.uaigc.service.IZLotteryService
    public final xc8.b s(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
        return new e(r2);
    }

    @Override // com.larus.uaigc.service.IZLotteryService
    public final boolean w(int r4) {
        com.larus.uaigc.spring.lottery.b.a.getClass();
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        Object r5 = Result.constructor-impl(Boolean.valueOf(((Keva) com.larus.uaigc.spring.lottery.b.b.getValue()).getBoolean("disable_guide_card_" + r4 + '_' + AccountService.a.getUserId(), false)));     // Catch: Throwable -> L5
    L8:
        if (Result.exceptionOrNull-impl(r5) == null) goto L12;
        r5 = Boolean.FALSE;
    L12:
        return ((Boolean) r5).booleanValue();
    L5:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }

    @Override // com.larus.uaigc.service.IZLotteryService
    public final int x(String r3) {
        Intrinsics.checkNotNullParameter(r3, "segmentId");
        Keva r1 = com.larus.uaigc.spring.lottery.g.a;
        Intrinsics.checkNotNullParameter(r3, "segmentId");
        String r4 = "n_lottery_shuffle_p_".concat(r3);
        return com.larus.uaigc.spring.lottery.g.a.getInt(r4, 0);
    }

    @Override // com.larus.uaigc.service.IZLotteryService
    public final int m(int r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "segmentId");
        Keva r1 = com.larus.uaigc.spring.lottery.g.a;
        Intrinsics.checkNotNullParameter(r4, "segmentId");
        return com.larus.uaigc.spring.lottery.g.a.getInt("b_shuffle_p_" + r4 + '_' + r3, 0);
    }

    @Override // com.larus.uaigc.service.IZLotteryService
    public final void p(int r8, String r9) {
        Intrinsics.checkNotNullParameter(r9, "segmentId");
        Keva r1 = com.larus.uaigc.spring.lottery.g.a;
        Intrinsics.checkNotNullParameter(r9, "segmentId");
        String r0 = "b_shuffle_p_" + r9 + '_' + r8;
        Keva r2 = com.larus.uaigc.spring.lottery.g.a;
        int r3 = r2.getInt(r0, 0);
        FLogger r4 = FLogger.a;
        r4.i("ZLotteryStateRecoder", "[appendBeginShuffleTimes] currShuffleTimes = " + r3 + ", segmentId = " + r9);
        r2.storeInt(r0, r3 + 1);
        r4.i("ZLotteryServiceImpl", "[appendBeginShuffleTimes] roundNum = " + r8 + ", segmentId = " + r9);
    }

    @Override // com.larus.uaigc.service.IZLotteryService
    public final int u(int r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "segmentId");
        Keva r1 = com.larus.uaigc.spring.lottery.g.a;
        Intrinsics.checkNotNullParameter(r4, "segmentId");
        return com.larus.uaigc.spring.lottery.g.a.getInt("shuffle_p_" + r4 + '_' + r3, 0);
    }

    @Override // com.larus.uaigc.service.IZLotteryService
    public final void i(String r2, boolean r3, long r4, String r6, int r7, String r8, Boolean r9) {
        Intrinsics.checkNotNullParameter(r2, "messageId");
        Intrinsics.checkNotNullParameter(r6, "cardType");
        ZLotteryMobHelper.a(r2, r3, r4, r6, r7, r8, r9);
    }
}
