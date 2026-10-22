package com.larus.asr.session;

import com.bytedance.keva.Keva;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.asr.VoiceInputType;
import com.larus.asr.session.component.AsrEngineRoute;
import com.larus.asr.session.component.AsrSessionComponentUtils;
import com.larus.audio.AudioServiceDelegate;
import com.larus.audio.IFlowAsrClientService;
import com.larus.audio.audiov3.tts.PlayStateEnum;
import com.larus.im.bean.message.Message;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class QuicInterpretAsrSessionV2 extends ComponentAsrSession {
    public static final /* synthetic */ int n = 0;
    public final Function0<xa8.d> j;
    public volatile QuicInterpretTransportRoute k;
    public final Lazy l;
    public final s1 m;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/asr/session/QuicInterpretAsrSessionV2$QuicInterpretTransportRoute;", "", "<init>", "(Ljava/lang/String;I)V", "NONE", "LEGACY", "FLOW_ASR_CLIENT", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum QuicInterpretTransportRoute extends Enum<QuicInterpretTransportRoute> {
        public static final QuicInterpretTransportRoute FLOW_ASR_CLIENT = null;
        public static final QuicInterpretTransportRoute LEGACY = null;
        public static final QuicInterpretTransportRoute NONE = null;
        public static final /* synthetic */ QuicInterpretTransportRoute[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<QuicInterpretTransportRoute> getEntries() {
            return b;
        }

        static {
            QuicInterpretTransportRoute r0 = new QuicInterpretTransportRoute("NONE", 0);
            NONE = r0;
            QuicInterpretTransportRoute r1 = new QuicInterpretTransportRoute("LEGACY", 1);
            LEGACY = r1;
            QuicInterpretTransportRoute r3 = new QuicInterpretTransportRoute("FLOW_ASR_CLIENT", 2);
            FLOW_ASR_CLIENT = r3;
            QuicInterpretTransportRoute[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static QuicInterpretTransportRoute[] values() {
            return (QuicInterpretTransportRoute[]) a.clone();
        }

        public static QuicInterpretTransportRoute valueOf(String r1) {
            return (QuicInterpretTransportRoute) r27.a.a(QuicInterpretTransportRoute.class, r1);
        }

        public QuicInterpretTransportRoute(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[QuicInterpretTransportRoute.values().length];
            r0[QuicInterpretTransportRoute.FLOW_ASR_CLIENT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[QuicInterpretTransportRoute.LEGACY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[QuicInterpretTransportRoute.NONE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    static {
    }

    @Override // com.larus.asr.session.ComponentAsrSession, com.larus.asr.session.o
    public final boolean m0() {
        return false;
    }

    @Override // com.larus.asr.session.ComponentAsrSession
    public final com.larus.asr.session.component.d0 b() {
        return new com.larus.asr.session.component.d0(CollectionsKt.listOf(new com.larus.asr.session.component.p0[]{new com.larus.asr.session.component.h0(this.a, new n1()), new com.larus.asr.session.component.z(this.a, new o1(), new QuicInterpretAsrSessionV2$createComponents$3(this), 10)}), CollectionsKt.emptyList());
    }

    public final int m() {
        String r0 = AccountService.a.getUserId().concat("-selected_translator_mode");
        return Intrinsics.areEqual(((Keva) this.l.getValue()).getString(r0, "1"), "1") ? 1 : 0;
    }

    public final xa8.d n() {
        return (xa8.d) this.j.invoke();
    }

    @Override // com.larus.asr.session.ComponentAsrSession, com.larus.asr.session.o
    public final void clear() {
        super.clear();
        this.f.d();
        if (this.k != QuicInterpretTransportRoute.FLOW_ASR_CLIENT) goto L9;
        IFlowAsrClientService.a.getClass();
        IFlowAsrClientService r0 = IFlowAsrClientService.a.a();
        String r1 = this.f.m;
        if (r1 != null) goto L7;
        r1 = "";
    L7:
        r0.j(r1);
        this.k = QuicInterpretTransportRoute.NONE;
        return;
    }

    @Override // com.larus.asr.session.ComponentAsrSession
    public final void i(com.larus.asr.session.component.f0 r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this.k = QuicInterpretTransportRoute.NONE;
        String r0 = this.b;
        AsrEngineRoute r1 = r5.o;
        Intrinsics.checkNotNullParameter(r0, "taskId");
        Intrinsics.checkNotNullParameter(r1, "route");
        r5.m = r0;
        r5.n = 0;
        r5.o = r1;
    }

    @Override // com.larus.asr.session.ComponentAsrSession, com.larus.asr.session.o
    public final void qa(String r5, Message r6) {
        Intrinsics.checkNotNullParameter(r5, "taskId");
        super.qa(r5, r6);
        QuicInterpretTransportRoute r7 = this.k;
        int r8 = b.a[r7.ordinal()];
        if (r8 != 1) goto L5;
        IFlowAsrClientService.a.getClass();
        IFlowAsrClientService r9 = IFlowAsrClientService.a.a();
        r9.f(r5);
        r9.j(r5);
        this.k = QuicInterpretTransportRoute.NONE;
    L20:
        int r10 = AsrSessionComponentUtils.a;
        AsrSessionComponentUtils.b(this.a, r5, null, "onCancel:".concat(r5), 12);
        FLogger.a.i("QuicInterpretAsrSessionV2", "onCancel setSpeakerViewVisible: false");
        return;
    L5:
        if (r8 != 2) goto L7;
        xa8.d r11 = n();
        if (r11 == null) goto L20;
        if (r11.K70() == false) goto L20;
        if (r11.Ig() == true) goto L20;
        FLogger.a.i("QuicInterpretAsrSessionV2", "speaker cancel");
        r11.gq(0);
        goto L20
    L7:
        if (r8 == 3) goto L20;
        throw new NoWhenBranchMatchedException();
    }

    public static final void l(QuicInterpretAsrSessionV2 r4, byte[] r5, JSONObject r6) {
        r4.getClass();
        boolean r0 = com.larus.platform.service.z2.a.A2().getForcePlay();
        FLogger r1 = FLogger.a;
        r1.i("QuicInterpretAsrSessionV2", "onReceiveAudioData forcePlay=" + r0 + ", ttsEnabled=" + r4.a.I9());
        if (r0 == false) goto L5;
    L7:
        AudioServiceDelegate.a.r0().n(PlayStateEnum.PLAY_STATE_PLAYING);
        r1.i("QuicInterpretAsrSessionV2", "simultaneousTranslator onReceiveAudioData " + r5.length + ", extraJson=" + r6);
        if (r6 == null) goto L10;
        String r7 = r6.optString("status");
    L12:
        if (Intrinsics.areEqual(r7, "1") == false) goto L16;
        r1.i("QuicInterpretAsrSessionV2", "simultaneousTranslator onReceiveAudioData end");
        return;
    L16:
        return;
    L10:
        r7 = null;
        goto L12
    L5:
        if (r4.a.I9() == true) goto L7;
        r1.i("QuicInterpretAsrSessionV2", "tts switch off, stopPlayAudioData");
        AudioServiceDelegate.a.r0().n(PlayStateEnum.PLAY_STATE_STOPPED);
    }

    @Override // com.larus.asr.session.ComponentAsrSession, com.larus.asr.session.o
    public final void ma(String r3, Message r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r3, "taskId");
        super.ma(r3, r4, r5);
        QuicInterpretTransportRoute r6 = this.k;
        int r7 = b.a[r6.ordinal()];
        if (r7 != 1) goto L5;
        IFlowAsrClientService.a.getClass();
        IFlowAsrClientService.a.a().r(r3);
    L15:
        int r8 = AsrSessionComponentUtils.a;
        AsrSessionComponentUtils.b(this.a, r3, null, "onCancel:".concat(r3), 12);
        FLogger.a.i("QuicInterpretAsrSessionV2", "onSubmit setSpeakerViewVisible: false");
        return;
    L5:
        if (r7 != 2) goto L7;
        xa8.d r9 = n();
        if (r9 == null) goto L15;
        r9.JX();
        goto L15
    L7:
        if (r7 == 3) goto L15;
        throw new NoWhenBranchMatchedException();
    }

    public QuicInterpretAsrSessionV2(p r2, String r3, com.larus.asr.x0 r4, d r5) {
        Intrinsics.checkNotNullParameter(r2, "sessionContext");
        Intrinsics.checkNotNullParameter(r3, "taskId");
        Intrinsics.checkNotNullParameter(r4, "abilityGetter");
        Intrinsics.checkNotNullParameter(r5, "isCurrentSession");
        super(r2, r3, VoiceInputType.TouchSpeaker, r5);
        this.j = r4;
        this.k = QuicInterpretTransportRoute.NONE;
        this.l = LazyKt.lazy(new r1());
        this.m = new s1(this, r2, r3);
    }
}
