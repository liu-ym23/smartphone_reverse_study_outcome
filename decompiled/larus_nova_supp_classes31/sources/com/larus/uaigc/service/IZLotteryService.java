package com.larus.uaigc.service;

import com.larus.im.bean.message.Message;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u0000 52\u00020\u0001:\u00015J\u0012\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003H&J\b\u0010\u0005\u001a\u00020\u0006H&J\u0012\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nH&J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH&J\u001a\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f2\b\b\u0002\u0010\t\u001a\u00020\nH&J\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\t\u001a\u00020\nH&J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0013\u001a\u00020\rH&J\b\u0010\u0014\u001a\u00020\nH&J\b\u0010\u0015\u001a\u00020\nH&J\b\u0010\u0016\u001a\u00020\nH&J\u0010\u0010\u0017\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH&J\b\u0010\u0018\u001a\u00020\u0006H&J\u0010\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u001bH&J\u0010\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u001bH&J\u0018\u0010\u001d\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u001bH&J\u0018\u0010\u001e\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u001bH&J\u0018\u0010\u001f\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u001bH&J\u0010\u0010 \u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u001bH&J\b\u0010!\u001a\u00020\u0006H&J\b\u0010\"\u001a\u00020\u0006H&J\b\u0010#\u001a\u00020\nH&J\b\u0010$\u001a\u00020\nH&J\b\u0010%\u001a\u00020\nH&JO\u0010&\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u001b2\u0006\u0010(\u001a\u00020\n2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u001b2\b\b\u0002\u0010,\u001a\u00020\r2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\nH&¢\u0006\u0002\u0010/J\u0012\u00100\u001a\u0004\u0018\u0001012\u0006\u00102\u001a\u000203H&J\u0010\u00104\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0003H&¨\u00066"}, d2 = {"Lcom/larus/uaigc/service/IZLotteryService;", "", "guidePollingConfigFlow", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/larus/uaigc/bean/GuidePullingConfigData;", "onEnterZMainPage", "", "getCurHostReadState", "Lcom/larus/uaigc/bean/HostReadState;", "useCache", "", "isZLotteryGuideCardDisabled", "roundNum", "", "getRoundList", "", "Lcom/larus/uaigc/bean/LotteryRoundInfo;", "getCurRound", "getCurRoundWithFront", "front", "isInLotteryRound", "isInNoPreheatingLotteryRound", "getCurRoundLotteryState", "getRoundLotteryState", "storeCurRoundLotteryState", "getNonLotteryShuffleTimes", "segmentId", "", "appendNonLotteryShuffleTimes", "getRoundBeginShuffleTimes", "appendBeginShuffleTimes", "getRoundShuffleTimes", "appendShuffleTimes", "storeShowLoadingButtonState", "storeSendNewYearAvatarMessageStatus", "getSendNewYearAvatarMessageStatus", "getShowLoadingButtonState", "disableOnboardingAndWcbNow", "reportPocketMessageCardShowed", "messageId", "lynxViewLoadSuccess", "createToLynxDuration", "", "cardType", "errorCode", "errorMsg", "isStream", "(Ljava/lang/String;ZJLjava/lang/String;ILjava/lang/String;Ljava/lang/Boolean;)V", "createZLotteryGuideCellState", "Lcom/larus/bmhome/chat/cell/BaseMessageCellState;", "msg", "Lcom/larus/im/bean/message/Message;", "zLotteryGuideMsgShowFlow", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public interface IZLotteryService {
    public static final Companion a = null;

    @Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0096\u0001J\u0011\u0010\n\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0096\u0001J\u0011\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0096\u0001J\u0013\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0096\u0001J\t\u0010\u0010\u001a\u00020\u0011H\u0096\u0001J\u0011\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0011H\u0096\u0001J\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0014\u001a\u00020\u0011H\u0096\u0001J\t\u0010\u0017\u001a\u00020\u0011H\u0096\u0001J\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0019\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010\u001a\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0096\u0001J\u0019\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0096\u0001J\u0019\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u001d2\u0006\u0010\u0014\u001a\u00020\u0011H\u0096\u0001J\u0011\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0019\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0096\u0001J\t\u0010 \u001a\u00020\u0011H\u0096\u0001J\t\u0010!\u001a\u00020\u0011H\u0096\u0001J\u0013\u0010\"\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010$\u0018\u00010#H\u0096\u0001J\t\u0010%\u001a\u00020\u0011H\u0096\u0001J\t\u0010&\u001a\u00020\u0011H\u0096\u0001J\u0011\u0010'\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\t\u0010(\u001a\u00020\u0005H\u0096\u0001JJ\u0010)\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\t2\u0006\u0010+\u001a\u00020\u00112\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\t2\u0006\u0010/\u001a\u00020\u00072\b\u00100\u001a\u0004\u0018\u00010\t2\b\u00101\u001a\u0004\u0018\u00010\u0011H\u0096\u0001¢\u0006\u0002\u00102J\t\u00103\u001a\u00020\u0005H\u0096\u0001J\t\u00104\u001a\u00020\u0005H\u0096\u0001J\t\u00105\u001a\u00020\u0005H\u0096\u0001J\u0011\u00106\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010#H\u0096\u0001¨\u00067"}, d2 = {"Lcom/larus/uaigc/service/IZLotteryService$Companion;", "Lcom/larus/uaigc/service/IZLotteryService;", "<init>", "()V", "appendBeginShuffleTimes", "", "roundNum", "", "segmentId", "", "appendNonLotteryShuffleTimes", "appendShuffleTimes", "createZLotteryGuideCellState", "Lcom/larus/bmhome/chat/cell/BaseMessageCellState;", "msg", "Lcom/larus/im/bean/message/Message;", "disableOnboardingAndWcbNow", "", "getCurHostReadState", "Lcom/larus/uaigc/bean/HostReadState;", "useCache", "getCurRound", "Lcom/larus/uaigc/bean/LotteryRoundInfo;", "getCurRoundLotteryState", "getCurRoundWithFront", "front", "getNonLotteryShuffleTimes", "getRoundBeginShuffleTimes", "getRoundList", "", "getRoundLotteryState", "getRoundShuffleTimes", "getSendNewYearAvatarMessageStatus", "getShowLoadingButtonState", "guidePollingConfigFlow", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/larus/uaigc/bean/GuidePullingConfigData;", "isInLotteryRound", "isInNoPreheatingLotteryRound", "isZLotteryGuideCardDisabled", "onEnterZMainPage", "reportPocketMessageCardShowed", "messageId", "lynxViewLoadSuccess", "createToLynxDuration", "", "cardType", "errorCode", "errorMsg", "isStream", "(Ljava/lang/String;ZJLjava/lang/String;ILjava/lang/String;Ljava/lang/Boolean;)V", "storeCurRoundLotteryState", "storeSendNewYearAvatarMessageStatus", "storeShowLoadingButtonState", "zLotteryGuideMsgShowFlow", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public static final class Companion implements IZLotteryService {
        public static final /* synthetic */ Companion c = null;
        public final /* synthetic */ IZLotteryService b;

        static {
            c = new Companion();
        }

        @Override // com.larus.uaigc.service.IZLotteryService
        public final i1<Boolean> E() {
            return this.b.E();
        }

        @Override // com.larus.uaigc.service.IZLotteryService
        public final void a() {
            this.b.a();
        }

        @Override // com.larus.uaigc.service.IZLotteryService
        public final void b() {
            this.b.b();
        }

        @Override // com.larus.uaigc.service.IZLotteryService
        public final hy9.g c(int r2) {
            return this.b.c(r2);
        }

        @Override // com.larus.uaigc.service.IZLotteryService
        public final boolean d() {
            return this.b.d();
        }

        @Override // com.larus.uaigc.service.IZLotteryService
        public final List e() {
            return this.b.e();
        }

        @Override // com.larus.uaigc.service.IZLotteryService
        public final boolean f() {
            return this.b.f();
        }

        @Override // com.larus.uaigc.service.IZLotteryService
        public final void g(String r2) {
            Intrinsics.checkNotNullParameter(r2, "segmentId");
            this.b.g(r2);
        }

        @Override // com.larus.uaigc.service.IZLotteryService
        public final hy9.b h(boolean r2) {
            return this.b.h(r2);
        }

        @Override // com.larus.uaigc.service.IZLotteryService
        public final void i(String r11, boolean r12, long r13, String r15, int r16, String r17, Boolean r18) {
            Intrinsics.checkNotNullParameter(r11, "messageId");
            Intrinsics.checkNotNullParameter(r15, "cardType");
            this.b.i(r11, r12, r13, r15, r16, r17, r18);
        }

        @Override // com.larus.uaigc.service.IZLotteryService
        public final boolean j(int r2) {
            return this.b.j(r2);
        }

        @Override // com.larus.uaigc.service.IZLotteryService
        public final boolean k() {
            return this.b.k();
        }

        @Override // com.larus.uaigc.service.IZLotteryService
        public final void l(String r2) {
            Intrinsics.checkNotNullParameter(r2, "segmentId");
            this.b.l(r2);
        }

        @Override // com.larus.uaigc.service.IZLotteryService
        public final int m(int r2, String r3) {
            Intrinsics.checkNotNullParameter(r3, "segmentId");
            return this.b.m(r2, r3);
        }

        @Override // com.larus.uaigc.service.IZLotteryService
        public final hy9.g n() {
            return this.b.n();
        }

        @Override // com.larus.uaigc.service.IZLotteryService
        public final boolean o() {
            return this.b.o();
        }

        @Override // com.larus.uaigc.service.IZLotteryService
        public final void p(int r2, String r3) {
            Intrinsics.checkNotNullParameter(r3, "segmentId");
            this.b.p(r2, r3);
        }

        @Override // com.larus.uaigc.service.IZLotteryService
        public final void q() {
            this.b.q();
        }

        @Override // com.larus.uaigc.service.IZLotteryService
        public final void r() {
            this.b.r();
        }

        @Override // com.larus.uaigc.service.IZLotteryService
        public final xc8.b s(Message r2) {
            Intrinsics.checkNotNullParameter(r2, "msg");
            return this.b.s(r2);
        }

        @Override // com.larus.uaigc.service.IZLotteryService
        public final boolean t() {
            return this.b.t();
        }

        @Override // com.larus.uaigc.service.IZLotteryService
        public final int u(int r2, String r3) {
            Intrinsics.checkNotNullParameter(r3, "segmentId");
            return this.b.u(r2, r3);
        }

        @Override // com.larus.uaigc.service.IZLotteryService
        public final boolean v() {
            return this.b.v();
        }

        @Override // com.larus.uaigc.service.IZLotteryService
        public final boolean w(int r2) {
            return this.b.w(r2);
        }

        @Override // com.larus.uaigc.service.IZLotteryService
        public final int x(String r2) {
            Intrinsics.checkNotNullParameter(r2, "segmentId");
            return this.b.x(r2);
        }

        private Companion() {
            IZLotteryService r0 = (IZLotteryService) ServiceManager.get().getService(IZLotteryService.class);
            if (r0 != null) goto L5;
            r0 = new IZLotteryServiceNoop();
        L5:
            this.b = r0;
        }
    }

    public static final class a {
        public static /* synthetic */ void a(Companion r10, String r11, boolean r12, long r13, String r15, int r16, String r17, Boolean r18, int r19) {
            if ((r19 & 16) == 0) goto L5;
            int r7 = 0;
        L7:
            if ((r19 & 32) == 0) goto L9;
            String r8 = null;
        L11:
            if ((r19 & 64) == 0) goto L13;
            Boolean r9 = Boolean.FALSE;
        L14:
            r10.i(r11, r12, r13, r15, r7, r8, r9);
            return;
        L13:
            r9 = r18;
            goto L14
        L9:
            r8 = r17;
            goto L11
        L5:
            r7 = r16;
            goto L7
        }
    }

    static {
        a = Companion.c;
    }

    i1<Boolean> E();

    void a();

    void b();

    hy9.g c(int r1);

    boolean d();

    List e();

    boolean f();

    void g(String r1);

    hy9.b h(boolean r1);

    void i(String r1, boolean r2, long r3, String r5, int r6, String r7, Boolean r8);

    boolean j(int r1);

    boolean k();

    void l(String r1);

    int m(int r1, String r2);

    hy9.g n();

    boolean o();

    void p(int r1, String r2);

    void q();

    void r();

    xc8.b s(Message r1);

    boolean t();

    int u(int r1, String r2);

    boolean v();

    boolean w(int r1);

    int x(String r1);
}
