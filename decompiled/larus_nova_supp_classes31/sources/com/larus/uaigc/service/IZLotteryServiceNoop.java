package com.larus.uaigc.service;

import com.larus.im.bean.message.Message;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00112\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0015\u001a\u00020\u000fH\u0016J\b\u0010\u0016\u001a\u00020\fH\u0016J\b\u0010\u0017\u001a\u00020\fH\u0016J\b\u0010\u0018\u001a\u00020\fH\u0016J\u0010\u0010\u0019\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u001a\u001a\u00020\bH\u0016J\u0010\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0018\u0010\u001f\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0018\u0010 \u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0018\u0010!\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\"\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010#\u001a\u00020\bH\u0016J\b\u0010$\u001a\u00020\bH\u0016J\b\u0010%\u001a\u00020\fH\u0016J\b\u0010&\u001a\u00020\fH\u0016J\b\u0010'\u001a\u00020\fH\u0016JI\u0010(\u001a\u00020\b2\u0006\u0010)\u001a\u00020\u001d2\u0006\u0010*\u001a\u00020\f2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u001d2\u0006\u0010.\u001a\u00020\u000f2\b\u0010/\u001a\u0004\u0018\u00010\u001d2\b\u00100\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0002\u00101J\u0012\u00102\u001a\u0004\u0018\u0001032\u0006\u00104\u001a\u000205H\u0016J\u0010\u00106\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0005H\u0016¨\u00067"}, d2 = {"Lcom/larus/uaigc/service/IZLotteryServiceNoop;", "Lcom/larus/uaigc/service/IZLotteryService;", "<init>", "()V", "guidePollingConfigFlow", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/larus/uaigc/bean/GuidePullingConfigData;", "onEnterZMainPage", "", "getCurHostReadState", "Lcom/larus/uaigc/bean/HostReadState;", "useCache", "", "isZLotteryGuideCardDisabled", "roundNum", "", "getRoundList", "", "Lcom/larus/uaigc/bean/LotteryRoundInfo;", "getCurRound", "getCurRoundWithFront", "front", "isInLotteryRound", "isInNoPreheatingLotteryRound", "getCurRoundLotteryState", "getRoundLotteryState", "storeCurRoundLotteryState", "getNonLotteryShuffleTimes", "segmentId", "", "appendNonLotteryShuffleTimes", "getRoundBeginShuffleTimes", "appendBeginShuffleTimes", "getRoundShuffleTimes", "appendShuffleTimes", "storeShowLoadingButtonState", "storeSendNewYearAvatarMessageStatus", "getSendNewYearAvatarMessageStatus", "getShowLoadingButtonState", "disableOnboardingAndWcbNow", "reportPocketMessageCardShowed", "messageId", "lynxViewLoadSuccess", "createToLynxDuration", "", "cardType", "errorCode", "errorMsg", "isStream", "(Ljava/lang/String;ZJLjava/lang/String;ILjava/lang/String;Ljava/lang/Boolean;)V", "createZLotteryGuideCellState", "Lcom/larus/bmhome/chat/cell/BaseMessageCellState;", "msg", "Lcom/larus/im/bean/message/Message;", "zLotteryGuideMsgShowFlow", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class IZLotteryServiceNoop implements IZLotteryService {
    public IZLotteryServiceNoop() {
    }

    @Override // com.larus.uaigc.service.IZLotteryService
    public final i1<Boolean> E() {
        return null;
    }

    @Override // com.larus.uaigc.service.IZLotteryService
    public final void a() {
    }

    @Override // com.larus.uaigc.service.IZLotteryService
    public final void b() {
    }

    @Override // com.larus.uaigc.service.IZLotteryService
    public final hy9.g c(int r1) {
        return null;
    }

    @Override // com.larus.uaigc.service.IZLotteryService
    public final boolean d() {
        return false;
    }

    @Override // com.larus.uaigc.service.IZLotteryService
    public final List e() {
        return null;
    }

    @Override // com.larus.uaigc.service.IZLotteryService
    public final boolean f() {
        return false;
    }

    @Override // com.larus.uaigc.service.IZLotteryService
    public final void g(String r2) {
        Intrinsics.checkNotNullParameter(r2, "segmentId");
    }

    @Override // com.larus.uaigc.service.IZLotteryService
    public final void i(String r1, boolean r2, long r3, String r5, int r6, String r7, Boolean r8) {
        Intrinsics.checkNotNullParameter(r1, "messageId");
        Intrinsics.checkNotNullParameter(r5, "cardType");
    }

    @Override // com.larus.uaigc.service.IZLotteryService
    public final boolean j(int r1) {
        return false;
    }

    @Override // com.larus.uaigc.service.IZLotteryService
    public final boolean k() {
        return false;
    }

    @Override // com.larus.uaigc.service.IZLotteryService
    public final void l(String r2) {
        Intrinsics.checkNotNullParameter(r2, "segmentId");
    }

    @Override // com.larus.uaigc.service.IZLotteryService
    public final int m(int r1, String r2) {
        Intrinsics.checkNotNullParameter(r2, "segmentId");
        return 0;
    }

    @Override // com.larus.uaigc.service.IZLotteryService
    public final hy9.g n() {
        return null;
    }

    @Override // com.larus.uaigc.service.IZLotteryService
    public final boolean o() {
        return false;
    }

    @Override // com.larus.uaigc.service.IZLotteryService
    public final void p(int r1, String r2) {
        Intrinsics.checkNotNullParameter(r2, "segmentId");
    }

    @Override // com.larus.uaigc.service.IZLotteryService
    public final void q() {
    }

    @Override // com.larus.uaigc.service.IZLotteryService
    public final void r() {
    }

    @Override // com.larus.uaigc.service.IZLotteryService
    public final xc8.b s(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
        return null;
    }

    @Override // com.larus.uaigc.service.IZLotteryService
    public final boolean t() {
        return false;
    }

    @Override // com.larus.uaigc.service.IZLotteryService
    public final int u(int r1, String r2) {
        Intrinsics.checkNotNullParameter(r2, "segmentId");
        return 0;
    }

    @Override // com.larus.uaigc.service.IZLotteryService
    public final boolean v() {
        return false;
    }

    @Override // com.larus.uaigc.service.IZLotteryService
    public final boolean w(int r1) {
        return false;
    }

    @Override // com.larus.uaigc.service.IZLotteryService
    public final int x(String r2) {
        Intrinsics.checkNotNullParameter(r2, "segmentId");
        return 0;
    }

    @Override // com.larus.uaigc.service.IZLotteryService
    public final hy9.b h(boolean r3) {
        return new hy9.b(null, 31);
    }
}
