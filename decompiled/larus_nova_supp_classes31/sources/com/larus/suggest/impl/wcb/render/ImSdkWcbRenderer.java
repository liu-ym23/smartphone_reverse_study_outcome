package com.larus.suggest.impl.wcb.render;

import android.os.SystemClock;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.larus.bmhome.chat.bean.NexPulseCandidate;
import com.larus.bmhome.chat.bean.NexPulseConf;
import com.larus.bmhome.chat.bean.NexPulseResponseData;
import com.larus.bmhome.chat.bean.SuggestItemType;
import com.larus.im.bean.message.Message;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.im.internal.delegate.y0;
import com.larus.network.http.HttpExtKt;
import com.larus.utils.logger.FLogger;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class ImSdkWcbRenderer implements r {
    public static final /* synthetic */ int c = 0;
    public final kx9.a a;
    public final j b;

    public final class Transaction implements q {
        public final k a;
        public boolean b;
        public final /* synthetic */ ImSdkWcbRenderer c;

        @Override // com.larus.suggest.impl.wcb.render.q
        public final void c() {
        }

        @Override // com.larus.suggest.impl.wcb.render.q
        public final void cancel() {
            FLogger.a.i("WcbLog", "[render] transaction.cancel chat=" + this.a.a.d + " exec=" + this.a.a.e);
            this.b = false;
        }

        @Override // com.larus.suggest.impl.wcb.render.q
        public final boolean isActive() {
            return this.b;
        }

        @Override // com.larus.suggest.impl.wcb.render.q
        public final Object b(Continuation<? super Unit> r4) {
            FLogger.a.i("WcbLog", "[render] im.transaction.finish chat=" + this.a.a.d + " exec=" + this.a.a.e);
            this.b = false;
            return Unit.INSTANCE;
        }

        public Transaction(ImSdkWcbRenderer r2, k r3) {
            Intrinsics.checkNotNullParameter(r3, "context");
            this.c = r2;
            this.a = r3;
            this.b = true;
        }

        @Override // com.larus.suggest.impl.wcb.render.q
        public final Object a(l r18, Continuation<? super n> r19) {
            if ((r19 instanceof ImSdkWcbRenderer$Transaction$render$1) == false) goto L7;
            ImSdkWcbRenderer$Transaction$render$1 r2 = (ImSdkWcbRenderer$Transaction$render$1) r19;
            int r3 = r2.label;
            if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
            r2.label = r3 - Integer.MIN_VALUE;
        L8:
            ImSdkWcbRenderer$Transaction$render$1 r8 = r2;
            Object r1 = r8.result;
            Object r9 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r4 = r8.label;
            if (r4 == 0) goto L14;
            if (r4 != 1) goto L13;
            l r5 = (l) r8.L$0;
            ResultKt.throwOnFailure(r1);
            String r110 = " active=";
        L32:
            FLogger.a.i("WcbLog", "[render] im.result chat=" + this.a.a.d + " exec=" + this.a.a.e + " plan=" + r5.getClass().getSimpleName() + " result=" + ((n) r1).getClass().getSimpleName() + r110 + this.b);
            return r1;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r1);
            FLogger r6 = FLogger.a;
            r6.i("WcbLog", "[render] im.render chat=" + this.a.a.d + " exec=" + this.a.a.e + " plan=" + r18.getClass().getSimpleName() + " active=" + this.b);
            if (this.b == false) goto L17;
            ImSdkWcbRenderer r14 = this.c;
            k r7 = this.a;
            com.larus.suggest.impl.wcb.request.f r10 = r7.a;
            jx9.a r11 = r7.b;
            r8.L$0 = r18;
            r8.label = 1;
            r14.getClass();
            if ((r18 instanceof l.a) == false) goto L21;
            r110 = " active=";
            r1 = r14.d(((l.a) r18).a, new ImSdkWcbRenderer$renderPlan$2(r14, r10, r18, r11, null), r8);
        L29:
            if (r1 != r9) goto L31;
            return r9;
        L31:
            r5 = r18;
            goto L32
        L21:
            r110 = " active=";
            if ((r18 instanceof l.c) == false) goto L25;
            r1 = r14.d(((l.c) r18).b, new ImSdkWcbRenderer$renderPlan$3(r14, r18, r11, null), r8);
            goto L29
        L25:
            if ((r18 instanceof l.b) == false) goto L35;
            p r12 = ((l.b) r18).a;
            kotlinx.coroutines.j r13 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r8), 1);
            r13.C();
            r6.i("WcbLog", "[render] im.deprecate target=" + r12.a);
            AtomicBoolean r15 = new AtomicBoolean(false);
            r13.i(new d(r15));
            com.larus.im.d.e().x(StringsKt.removeSuffix(r12.a, ":fake_message:1"), new e(r14), new f(r13, r15, r14, r12));
            r1 = r13.B();
            if (r1 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L29;
            DebugProbesKt.probeCoroutineSuspended(r8);
            goto L29
        L35:
            throw new NoWhenBranchMatchedException();
        L17:
            return new n.a("wcb render transaction inactive");
        L7:
            r2 = new ImSdkWcbRenderer$Transaction$render$1(this, r19);
            goto L8
        }
    }

    public static final class a {
    }

    public static final class b implements Function1<Throwable, Unit> {
        public final /* synthetic */ AtomicBoolean a;

        public b(AtomicBoolean r1) {
            this.a = r1;
        }

        public final Object invoke(Object r2) {
            Throwable r3 = (Throwable) r2;
            this.a.set(true);
            return Unit.INSTANCE;
        }
    }

    public static final class c implements IIMCallback<Message> {
        public final /* synthetic */ String a;
        public final /* synthetic */ kotlinx.coroutines.i<n> b;
        public final /* synthetic */ AtomicBoolean c;
        public final /* synthetic */ ImSdkWcbRenderer d;
        public final /* synthetic */ jx9.a e;

        public final boolean mustInMain() {
            return !y0.a();
        }

        public final void onFailure(IIMError r6) {
            Intrinsics.checkNotNullParameter(r6, "error");
            FLogger.a.e("WcbLog", "[render] im.callback onFailure operation=" + this.a + " success=false cancelled=" + this.b.isCancelled());
            if (this.c.compareAndSet(false, true) == true) goto L5;
            return;
        L5:
            kx9.a r0 = this.d.a;
            jx9.a r1 = this.e;
            r0.getClass();
            Intrinsics.checkNotNullParameter(r1, "traceData");
            r1.g = SystemClock.elapsedRealtime();
            kx9.a.d(this.d.a, this.e, r6.toString(), false, 12);
            kotlinx.coroutines.i<n> r2 = this.b;
            Result.Companion r3 = Result.Companion;
            r2.resumeWith(Result.constructor-impl(new n.a(this.a + " failed: " + r6)));
        }

        public final void onSuccess(Object r5) {
            Message r6 = (Message) r5;
            Intrinsics.checkNotNullParameter(r6, "result");
            FLogger.a.i("WcbLog", "[render] im.callback onSuccess operation=" + this.a + " success=true promptKeyInfo=" + gx9.p.b(r6) + " cancelled=" + this.b.isCancelled());
            if (this.c.compareAndSet(false, true) == false) goto L7;
            kx9.a r0 = this.d.a;
            jx9.a r1 = this.e;
            r0.getClass();
            Intrinsics.checkNotNullParameter(r1, "traceData");
            r1.g = SystemClock.elapsedRealtime();
            kx9.a r2 = this.d.a;
            jx9.a r3 = this.e;
            r2.getClass();
            Intrinsics.checkNotNullParameter(r3, "traceData");
            JSONObject r4 = new JSONObject();
            r4.put("success", "1");
            kx9.a.b(r4, r3);
            kx9.a.a(r4, r3);
            com.larus.platform.service.o.a.reportEvent("dev_wcb_monitor_event", r4);
            kotlinx.coroutines.i<n> r7 = this.b;
            Result.Companion r8 = Result.Companion;
            r7.resumeWith(Result.constructor-impl(ImSdkWcbRenderer.b(this.d, r6)));
            return;
        }

        public c(String r1, kotlinx.coroutines.j r2, AtomicBoolean r3, ImSdkWcbRenderer r4, jx9.a r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }
    }

    static {
    }

    public ImSdkWcbRenderer(kx9.a r3) {
        j r0 = new j();
        Intrinsics.checkNotNullParameter(r3, "monitor");
        Intrinsics.checkNotNullParameter(r0, "extMapper");
        this.a = r3;
        this.b = r0;
    }

    @Override // com.larus.suggest.impl.wcb.render.r
    public final q a(k r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return new Transaction(this, r2);
    }

    public static final n b(ImSdkWcbRenderer r1, Message r2) {
        r1.getClass();
        String r3 = r2.getLocalMessageId();
        if (r3 == null) goto L18;
        if (r3.length() <= 0) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == true) goto L11;
        r3 = null;
    L11:
        if (r3 == null) goto L18;
        Map r4 = r2.getExt();
        if (r4 != null) goto L19;
        r4 = MapsKt.emptyMap();
    L19:
        return new n.b(r3, MapsKt.toMap(r4));
    L7:
        r0 = false;
    L18:
        return new n.a("submitted wcb has no localMessageId");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.util.ArrayList] */
    public final Object d(i r22, Function2<? super Map<String, String>, ? super Continuation<? super n>, ? extends Object> r23, Continuation<? super n> r24) {
        this.b.getClass();
        Intrinsics.checkNotNullParameter(r22, "presentation");
        NexPulseResponseData r2 = r22.b;
        Integer r3 = r2.getNexPulseType();
        String r19 = null;
        if (r3 != null) goto L6;
    L74:
        if (r3 != null) goto L77;
    L113:
        if (r3 != null) goto L116;
    L146:
        Map r0 = MapsKt.emptyMap();
    L148:
        if (r0.isEmpty() == false) goto L152;
        return new n.a("create wcb extra failed");
    L152:
        return r23.invoke(r0, r24);
    L116:
        if (r3.intValue() != 4) goto L146;
        Type r1 = gx9.p.a;
        Intrinsics.checkNotNullParameter(r2, "resp");
        List r4 = r2.getCandidateList();
        if (r4 == null) goto L122;
        NexPulseCandidate r5 = (NexPulseCandidate) CollectionsKt.firstOrNull(r4);
        if (r5 == null) goto L122;
        r19 = r5.getLogId();
    L122:
        if (r19 != null) goto L124;
        String r6 = "";
    L125:
        List r7 = r2.getCandidateList();
        if (r7 == null) goto L131;
        List r8 = r7;
        Object r9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
        Iterator r10 = r8.iterator();
    L129:
        if (r10.hasNext() == false) goto L132;
        r9.add(((NexPulseCandidate) r10.next()).toOnboardingSugItem());
    L132:
        String r11 = GsonProtectorUtils.toJson(HttpExtKt.f, r9);
        Pair[] r12 = new Pair[8];
        r12[0] = TuplesKt.to("onboarding_sug", r11);
        r12[1] = TuplesKt.to("onboarding_display_style", "vertical");
        r12[2] = TuplesKt.to("onboarding_sug_type", String.valueOf(SuggestItemType.VideoRichMediaWelcomeBack.getValue()));
        r12[3] = TuplesKt.to("wcb_message_hidden", "true");
        NexPulseConf r13 = r2.getConf();
        if (r13 == null) goto L138;
        Long r14 = r13.getExpireTime();
        if (r14 == null) goto L138;
        String r15 = r14.toString();
        if (r15 == null) goto L138;
    L139:
        r12[4] = TuplesKt.to("onboarding_sug_expiration_time", r15);
        r12[5] = TuplesKt.to("inner_log_id", r6);
        r12[6] = TuplesKt.to("log_id", r6);
        r12[7] = TuplesKt.to("next_pulse_type", String.valueOf(r2.getNexPulseType()));
        r0 = MapsKt.mutableMapOf(r12);
        List r16 = r2.getCandidateList();
        if (r16 == null) goto L148;
        NexPulseCandidate r17 = (NexPulseCandidate) CollectionsKt.firstOrNull(r16);
        if (r17 == null) goto L148;
        String r18 = r17.getClickClearContext();
        if (r18 == null) goto L148;
        r0.put("click_clear_context", r18);
    L138:
        r15 = "0";
        goto L139
    L131:
        r9 = CollectionsKt.emptyList();
        goto L132
    L124:
        r6 = r19;
        goto L125
    L77:
        if (r3.intValue() != 2) goto L113;
        Type r20 = gx9.p.a;
        Intrinsics.checkNotNullParameter(r2, "resp");
        String r21 = GsonProtectorUtils.toJson(HttpExtKt.f, r2);
        List r25 = r2.getCandidateList();
        if (r25 == null) goto L83;
        NexPulseCandidate r26 = (NexPulseCandidate) CollectionsKt.firstOrNull(r25);
        if (r26 == null) goto L83;
        String r27 = r26.getLogId();
    L84:
        if (r27 != null) goto L86;
        r27 = "";
    L86:
        Pair[] r28 = new Pair[7];
        r28[0] = TuplesKt.to("wcb_message_hidden", "true");
        NexPulseConf r29 = r2.getConf();
        if (r29 == null) goto L92;
        Long r30 = r29.getExpireTime();
        if (r30 == null) goto L92;
        String r31 = r30.toString();
        if (r31 == null) goto L92;
    L93:
        r28[1] = TuplesKt.to("onboarding_sug_expiration_time", r31);
        r28[2] = TuplesKt.to("inner_log_id", r27);
        r28[3] = TuplesKt.to("log_id", r27);
        NexPulseConf r32 = r2.getConf();
        if (r32 == null) goto L96;
        r19 = r32.getWcbTitle();
    L96:
        if (r19 != null) goto L98;
        String r33 = "";
    L99:
        r28[4] = TuplesKt.to("wcb_title", r33);
        r28[5] = TuplesKt.to("next_pulse_resp_data", r21);
        r28[6] = TuplesKt.to("next_pulse_type", String.valueOf(r2.getNexPulseType()));
        r0 = MapsKt.mutableMapOf(r28);
        List r34 = r2.getCandidateList();
        if (r34 == null) goto L106;
        NexPulseCandidate r35 = (NexPulseCandidate) CollectionsKt.firstOrNull(r34);
        if (r35 == null) goto L106;
        String r36 = r35.getClickClearContext();
        if (r36 == null) goto L106;
        String r37 = (String) r0.put("click_clear_context", r36);
    L106:
        List r38 = r2.getCandidateList();
        if (r38 == null) goto L148;
        NexPulseCandidate r39 = (NexPulseCandidate) CollectionsKt.firstOrNull(r38);
        if (r39 == null) goto L148;
        String r40 = r39.getCardName();
        if (r40 == null) goto L148;
        r0.put("next_pulse_card_name", r40);
        goto L148
    L98:
        r33 = r19;
    L92:
        r31 = "0";
    L83:
        r27 = null;
        goto L84
    L6:
        if (r3.intValue() != 1) goto L74;
        int r41 = r22.a;
        String r42 = r22.c;
        if (r42 == null) goto L10;
        Map r43 = MapsKt.mapOf(TuplesKt.to("wcb_render_status", r42));
    L11:
        boolean r44 = r22.d;
        Type r210 = gx9.p.a;
        Intrinsics.checkNotNullParameter(r2, "resp");
        List r45 = r2.toSuggestItems(Boolean.valueOf(r44));
        Result.Companion r46 = Result.Companion;     // Catch: Throwable -> L18
        Object r211 = "click_clear_context";
        Object r47 = Result.constructor-impl(HttpExtKt.f.toJson(r45, gx9.p.a));     // Catch: Throwable -> L16
    L22:
        if (Result.isFailure-impl(r47) == false) goto L24;
        r47 = null;
    L24:
        String r48 = (String) r47;
        if (r48 != null) goto L28;
        r0 = MapsKt.emptyMap();
        goto L148
    L28:
        if (r45.isEmpty() == false) goto L35;
        if (r43 == null) goto L31;
        String r49 = (String) r43.get("wcb_render_status");
    L33:
        if (Intrinsics.areEqual(r49, "DEPRECATED") == true) goto L35;
        r0 = MapsKt.emptyMap();
        goto L148
    L31:
        r49 = null;
    L35:
        List r50 = r2.getCategoryCandidateList();
        if (r50 == null) goto L39;
        NexPulseCandidate r51 = (NexPulseCandidate) CollectionsKt.firstOrNull(r50);
        if (r51 == null) goto L39;
    L43:
        if (r51 == null) goto L45;
        String r52 = r51.getLogId();
    L46:
        if (r52 != null) goto L48;
        r52 = "";
    L48:
        Pair[] r110 = new Pair[10];
        Map r111 = r43;
        r110[0] = TuplesKt.to("suggest_items", r48);
        r110[1] = TuplesKt.to("onboarding_display_style", "vertical");
        r110[2] = TuplesKt.to("wcb_message_hidden", "true");
        NexPulseConf r53 = r2.getConf();
        if (r53 == null) goto L54;
        Long r54 = r53.getExpireTime();
        if (r54 == null) goto L54;
        String r55 = r54.toString();
        if (r55 == null) goto L54;
    L55:
        r110[3] = TuplesKt.to("onboarding_sug_expiration_time", r55);
        r110[4] = TuplesKt.to("inner_log_id", r52);
        r110[5] = TuplesKt.to("log_id", r52);
        NexPulseConf r56 = r2.getConf();
        if (r56 == null) goto L58;
        r19 = r56.getWcbTitle();
    L58:
        if (r19 != null) goto L60;
        String r57 = "";
    L61:
        r110[6] = TuplesKt.to("wcb_title", r57);
        NexPulseConf r58 = r2.getConf();
        if (r58 == null) goto L66;
        Integer r59 = r58.getWcbTitleStyle();
        if (r59 == null) goto L66;
        int r112 = r59.intValue();
    L67:
        r110[7] = TuplesKt.to("wcb_title_style", String.valueOf(r112));
        r110[8] = TuplesKt.to("next_pulse_type", String.valueOf(r2.getNexPulseType()));
        r110[9] = TuplesKt.to("next_pulse_scene", String.valueOf(r41));
        r0 = MapsKt.mutableMapOf(r110);
        if (r51 == null) goto L72;
        String r60 = r51.getClickClearContext();
        if (r60 == null) goto L72;
        String r61 = (String) r0.put(r211, r60);
    L72:
        if (r111 == null) goto L148;
        r0.putAll(r111);
    L66:
        r112 = 0;
        goto L67
    L60:
        r57 = r19;
    L54:
        r55 = "0";
        goto L55
    L45:
        r52 = null;
    L39:
        List r62 = r2.getCandidateList();
        if (r62 == null) goto L42;
        r51 = (NexPulseCandidate) CollectionsKt.firstOrNull(r62);
        goto L43
    L42:
        r51 = null;
    L16:
        th = th;
    L20:
        Result.Companion r63 = Result.Companion;
        r47 = Result.constructor-impl(ResultKt.createFailure(th));
    L18:
        th = th;
        r211 = "click_clear_context";
        goto L20
    L10:
        r43 = null;
        goto L11
    }

    private final Object update(p r2, final Map<String, String> r3, jx9.a r4, Continuation<? super n> r5) {
        final String r6 = StringsKt.removeSuffix(r2.a, ":fake_message:1");
        return e("updateLocalMessage", r4, new com.larus.suggest.impl.wcb.render.a(r6, this, r3), r5);
    }

    public final Object e(String r9, jx9.a r10, Function1<? super IIMCallback<Message>, Unit> r11, Continuation<? super n> r12) {
        kotlinx.coroutines.j r6 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r12), 1);
        r6.C();
        AtomicBoolean r3 = new AtomicBoolean(false);
        r6.i(new b(r3));
        r11.invoke(new c(r9, r6, r3, this, r10));
        Object r13 = r6.B();
        if (r13 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r12);
    L5:
        return r13;
    }

    public static final /* synthetic */ Object c(ImSdkWcbRenderer r0, p r1, Map r2, jx9.a r3, Continuation r4) {
        return r0.update(r1, r2, r3, r4);
    }
}
