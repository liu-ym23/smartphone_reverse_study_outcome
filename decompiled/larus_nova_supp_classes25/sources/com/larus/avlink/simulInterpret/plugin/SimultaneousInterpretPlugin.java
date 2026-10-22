package com.larus.avlink.simulInterpret.plugin;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.media.AudioTrack;
import android.os.Build;
import androidx.core.app.NotificationManagerCompat;
import com.google.gson.Gson;
import com.larus.audio.call.tracer.IRealtimeCallTracer;
import com.larus.avlink.model.DoraCallStateCode;
import com.larus.avlink.n1;
import com.larus.avlink.plugins.n4;
import com.larus.avlink.plugins.u4;
import com.larus.avlink.plugins.v4;
import com.larus.avlink.simulInterpret.page.model.TextType;
import com.larus.avlink.u0;
import com.larus.common.apphost.AppHost;
import com.larus.dora.api.DoraConfig;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.dora.impl.serviceimpl.SessionService;
import com.larus.im.service.audio.z0;
import com.larus.utils.j0;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.api.bean.ChatParam;
import com.larus.voicecall.api.bean.VisionModeIntention;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import ea8.w;
import ea8.x;
import fa8.e;
import fa8.f;
import fna.g;
import ha8.d;
import ia8.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.ExceptionsKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import org.json.JSONObject;
import pf9.c0;
import pf9.e0;
import pf9.f0;
import pf9.h0;
import pf9.k0;
import pf9.p;
import pf9.q;
import zd9.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class SimultaneousInterpretPlugin extends com.larus.audio.call.arch.a<n4> implements com.larus.avlink.simulInterpret.plugin.a {
    public final String f;
    public f g;
    public Job h;
    public Job i;
    public final boolean j;
    public final boolean k;

    public static final class a {
    }

    public static final class b extends z0 {
        public final String a;
        public final /* synthetic */ SimultaneousInterpretPlugin b;

        public final String g() {
            return this.a;
        }

        public b(SimultaneousInterpretPlugin r1) {
            this.b = r1;
            this.a = r1.f;
        }

        public final void n(z0.a r14) {
            Intrinsics.checkNotNullParameter(r14, "event");
            String r5 = null;
            boolean r7 = false;
            if ((r14 instanceof c0) == false) goto L43;
            SimultaneousInterpretPlugin r0 = this.b;
            c0 r15 = (c0) r14;
            if (Intrinsics.areEqual(((n4) r0.getContext()).params().k.o, "dora_si") == false) goto L293;
            pf9.a r6 = r15.a;
            if (r6 == null) goto L11;
            Map r8 = r6.d;
            if (r8 == null) goto L11;
            String r2 = (String) r8.get("src_channel");
        L12:
            pf9.a r9 = r15.a;
            if (r9 == null) goto L17;
            Map r10 = r9.d;
            if (r10 == null) goto L17;
            String r1 = (String) r10.get("ast_seq_id");
        L18:
            pf9.a r16 = r15.a;
            if (r16 == null) goto L21;
            r5 = r16.a;
        L21:
            if (r2 == null) goto L294;
            if (r1 == null) goto L295;
            if (r5 != null) goto L25;
            return;
        L25:
            if (r5.length() <= 0) goto L27;
            r7 = true;
        L27:
            if (r7 == true) goto L29;
            return;
        L29:
            if (r0.j == false) goto L37;
            if (Intrinsics.areEqual(r2, "0") == false) goto L34;
            boolean r17 = d.a;
            d.f(new x(TextType.ORIGINAL, r1, r5));
            r0.m3();
            return;
        L34:
            if (Intrinsics.areEqual(r2, "1") == false) goto L299;
            boolean r18 = d.a;
            d.g(new x(TextType.ORIGINAL, r1, r5));
            r0.m3();
            return;
        L299:
            return;
        L37:
            if (Intrinsics.areEqual(r2, "0") == false) goto L40;
            boolean r19 = d.a;
            d.g(new x(TextType.ORIGINAL, r1, r5));
            n1.d(r0.f, "resetTimer in handleQueryUpdateEvent, taskId: " + ((n4) r0.getContext()).params().l.a);
            r0.m3();
            return;
        L40:
            if (Intrinsics.areEqual(r2, "1") == false) goto L302;
            boolean r110 = d.a;
            d.f(new x(TextType.ORIGINAL, r1, r5));
            n1.d(r0.f, "resetTimer in handleQueryUpdateEvent, taskId: " + ((n4) r0.getContext()).params().l.a);
            r0.m3();
            return;
        L302:
            return;
        L295:
            return;
        L294:
            return;
        L17:
            r1 = null;
        L11:
            r2 = null;
            goto L12
        L293:
            return;
        L43:
            if ((r14 instanceof f0) == false) goto L83;
            SimultaneousInterpretPlugin r3 = this.b;
            f0 r111 = (f0) r14;
            if (Intrinsics.areEqual(((n4) r3.getContext()).params().k.o, "dora_si") == false) goto L304;
            k0 r11 = r111.b;
            if (r11 == null) goto L51;
            Map r12 = r11.n;
            if (r12 == null) goto L51;
            String r4 = (String) r12.get("src_channel");
        L52:
            k0 r13 = r111.b;
            if (r13 == null) goto L57;
            Map r20 = r13.n;
            if (r20 == null) goto L57;
            String r21 = (String) r20.get("ast_seq_id");
        L58:
            k0 r112 = r111.b;
            if (r112 == null) goto L61;
            r5 = r112.a;
        L61:
            if (r4 == null) goto L305;
            if (r21 == null) goto L306;
            if (r5 != null) goto L65;
            return;
        L65:
            if (r5.length() <= 0) goto L67;
            r7 = true;
        L67:
            if (r7 == true) goto L69;
            return;
        L69:
            if (r3.j == false) goto L77;
            if (Intrinsics.areEqual(r4, "0") == false) goto L74;
            boolean r113 = d.a;
            d.f(new x(TextType.TRANSLATION, r21, r5));
            r3.m3();
            return;
        L74:
            if (Intrinsics.areEqual(r4, "1") == false) goto L310;
            boolean r114 = d.a;
            d.g(new x(TextType.TRANSLATION, r21, r5));
            da8.a r115 = da8.a.a;
            Application r22 = AppHost.a.getApplication();
            r115.getClass();
            da8.a.c(r22, r21, r5);
            r3.m3();
            return;
        L310:
            return;
        L77:
            if (Intrinsics.areEqual(r4, "0") == false) goto L80;
            boolean r116 = d.a;
            d.g(new x(TextType.TRANSLATION, r21, r5));
            da8.a r117 = da8.a.a;
            Application r23 = AppHost.a.getApplication();
            r117.getClass();
            da8.a.c(r23, r21, r5);
            r3.m3();
            return;
        L80:
            if (Intrinsics.areEqual(r4, "1") == false) goto L313;
            boolean r118 = d.a;
            d.f(new x(TextType.TRANSLATION, r21, r5));
            r3.m3();
            return;
        L313:
            return;
        L306:
            return;
        L305:
            return;
        L57:
            r21 = null;
        L51:
            r4 = null;
            goto L52
        L304:
            return;
        L83:
            if ((r14 instanceof e0) == false) goto L98;
            SimultaneousInterpretPlugin r24 = this.b;
            e0 r119 = (e0) r14;
            n1.d(r24.f, "Receive FlowLLMReplyEndEvent.");
            if (Intrinsics.areEqual(((n4) r24.getContext()).params().k.o, "dora_si") == false) goto L315;
            f r120 = r24.g;
            if (r120 != null) goto L89;
            return;
        L89:
            if (r120.g == false) goto L328;
            ReentrantLock r25 = r120.h;
            r25.lock();
            r120.n = true;     // Catch: Throwable -> L94
            n1.d("StereoAudioPlayer", "Receive FlowLLMReplyEndEvent. " + r120.b());     // Catch: Throwable -> L94
            r120.i.signalAll();     // Catch: Throwable -> L94
            Unit r121 = Unit.INSTANCE;     // Catch: Throwable -> L94
            r25.unlock();
            return;
        L94:
            th = move-exception;
            r25.unlock();
            throw th;
        L328:
            return;
        L315:
            return;
        L98:
            if ((r14 instanceof q) == false) goto L225;
            SimultaneousInterpretPlugin r26 = this.b;
            r26.getClass();
            List r122 = ((q) r14).a;
            ArrayList r27 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r122, 10));
            Iterator r123 = r122.iterator();
        L101:
            if (r123.hasNext() == false) goto L329;
            p r28 = (p) r123.next();
            Long r29 = r28.a;
            if (r29 == null) goto L223;
            int r30 = (int) r29.longValue();
            JSONObject r31 = new JSONObject();
            Map r32 = r28.b;
            if (r32 == null) goto L266;
            Iterator r33 = r32.entrySet().iterator();
        L108:
            if (r33.hasNext() == false) goto L266;
            Map.Entry r34 = (Map.Entry) r33.next();
            r31.putOpt((String) r34.getKey(), r34.getValue());
        L266:
            Result.Companion r35 = Result.Companion;     // Catch: Throwable -> L131
            h r36 = h.a;     // Catch: Throwable -> L131
            String r37 = r31.toString();     // Catch: Throwable -> L131
            if (r37 != null) goto L113;
        L116:
            boolean r38 = true;
        L117:
            if (r38 == false) goto L264;
        L128:
            Object r39 = null;
        L129:
            Object r40 = Result.constructor-impl((ChatParam) r39);     // Catch: Throwable -> L131
        L134:
            if (Result.isFailure-impl(r40) == false) goto L136;
            r40 = null;
        L136:
            ChatParam r41 = (ChatParam) r40;
            if (r30 != 24) goto L223;
            n1.d(r26.f, "CommandStatus is DORA_VISION_MODE_INTENTION");
            Gson r42 = new Gson();     // Catch: Exception -> L145
            if (r41 == null) goto L142;
            String r43 = r41.getVisionModeIntention();     // Catch: Exception -> L145
        L143:
            VisionModeIntention r44 = (VisionModeIntention) r42.fromJson(r43, VisionModeIntention.class);     // Catch: Exception -> L145
        L147:
            if (r44 == null) goto L149;
            Integer r45 = r44.getDoraSpecialMode();
        L150:
            if (r44 == null) goto L152;
            Integer r46 = r44.getVisionEventType();
        L153:
            FLogger.a.i(r26.f, "handleChatResponseResult: DORA_VISION_MODE_INTENTION. mode:" + r45 + ", status:" + r46);
            if (r45 == null) goto L223;
            if (r45.intValue() != 3) goto L223;
            if (r46 != null) goto L161;
        L214:
            if (r46 == null) goto L223;
            if (r46.intValue() != 2) goto L223;
            n1.d(r26.f, "stop si in vui");
            IDoraService r47 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
            if (r47 == null) goto L223;
            SessionService r48 = r47.d();
            if (r48 == null) goto L223;
            r48.y(3, DoraCallStateCode.DOUBAO_STOP_SI_BY_VUI, false);
            goto L223
        L161:
            if (r46.intValue() != 1) goto L214;
            if (r26.j == false) goto L183;
            IDoraService r49 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
            if (r49 == null) goto L171;
            DeviceService r50 = r49.device();
            if (r50 == null) goto L171;
            if (r50.G() != true) goto L171;
            boolean r51 = true;
        L172:
            if (r51 == false) goto L178;
            n1.d(r26.f, "start si in VUI in lite");
            IDoraService r52 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
            if (r52 == null) goto L223;
            SessionService r53 = r52.d();
            if (r53 == null) goto L223;
            r53.o(5, 9);
            goto L223
        L178:
            n1.d(r26.f, "not start si in VUI due to buds disconnected");
            boolean r54 = d.a;
            d.e(AppHost.a.getApplication(), ((n4) r26.getContext()).params().o.d);
            IDoraService r55 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
            if (r55 == null) goto L223;
            SessionService r56 = r55.d();
            if (r56 == null) goto L223;
            r56.y(4, DoraCallStateCode.DOUBAO_STOP_SI_BY_EXCEPTION, false);
        L171:
            r51 = false;
            goto L172
        L183:
            IDoraService r57 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
            if (r57 != null) goto L186;
        L188:
            boolean r58 = false;
        L189:
            if (r58 == true) goto L209;
            IDoraService r59 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
            if (r59 == null) goto L197;
            DeviceService r60 = r59.device();
            if (r60 == null) goto L197;
            if (r60.W() != true) goto L197;
            boolean r61 = true;
        L198:
            if (r61 == true) goto L204;
            n1.d(r26.f, "start si in VUI in g");
            IDoraService r62 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
            if (r62 == null) goto L223;
            SessionService r63 = r62.d();
            if (r63 == null) goto L223;
            r63.o(5, 9);
            goto L223
        L204:
            n1.d(r26.f, "not start si in VUI due to head phone mode");
            IDoraService r64 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
            if (r64 == null) goto L223;
            SessionService r65 = r64.d();
            if (r65 == null) goto L223;
            r65.y(4, DoraCallStateCode.DOUBAO_STOP_SI_BY_EXCEPTION, false);
        L197:
            r61 = false;
            goto L198
        L209:
            n1.d(r26.f, "not start si in VUI due to wear count is 0");
            boolean r66 = d.a;
            int r67 = u0.a;
            u0.a(j0.d(2131902703));
            IDoraService r68 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
            if (r68 == null) goto L223;
            SessionService r69 = r68.d();
            if (r69 == null) goto L223;
            r69.y(4, DoraCallStateCode.DOUBAO_STOP_SI_BY_EXCEPTION, false);
            goto L223
        L186:
            if (r57.d0() != 0) goto L188;
            r58 = true;
            goto L189
        L152:
            r46 = null;
            goto L153
        L149:
            r45 = null;
            goto L150
        L142:
            r43 = null;
        L145:
            e = move-exception;
            FLogger.a.e(r26.f, "handleChatResponseResult: intentionItems.", e);
            r44 = null;
            goto L147
        L264:
            r36.getClass();     // Catch: Throwable -> L121
            r39 = Result.constructor-impl(h.b.fromJson(r37, new c().getType()));     // Catch: Throwable -> L121
        L123:
            Throwable r70 = Result.exceptionOrNull-impl(r39);     // Catch: Throwable -> L131
            if (r70 == null) goto L127;
            com.larus.im.internal.delegate.c0 r71 = com.larus.im.internal.delegate.c0.b;     // Catch: Throwable -> L131
            StringBuilder r124 = new StringBuilder();     // Catch: Throwable -> L131
            r124.append("fromJson failed, stack: ");     // Catch: Throwable -> L131
            Intrinsics.checkNotNullParameter(r70, "<this>");     // Catch: Throwable -> L131
            r124.append(ExceptionsKt.stackTraceToString(r70));     // Catch: Throwable -> L131
            r71.e("GsonHolder", r124.toString());     // Catch: Throwable -> L131
        L127:
            if (Result.isFailure-impl(r39) == false) goto L129;
        L121:
            th = move-exception;
            Result.Companion r72 = Result.Companion;     // Catch: Throwable -> L131
            r39 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L131
            goto L123
        L113:
            if (StringsKt.isBlank(r37) == true) goto L116;
            r38 = false;
        L131:
            th = move-exception;
            Result.Companion r73 = Result.Companion;
            r40 = Result.constructor-impl(ResultKt.createFailure(th));
        L223:
            r27.add(r28);
            goto L101
        L329:
            return;
        L225:
            if ((r14 instanceof h0) == false) goto L318;
            SimultaneousInterpretPlugin r74 = this.b;
            h0 r125 = (h0) r14;
            n1.d(r74.f, "receive security check event, " + r125);
            if (r125.d.length() <= 0) goto L229;
            boolean r75 = true;
        L230:
            if (r75 == true) goto L232;
            return;
        L232:
            if (r125.a.length() <= 0) goto L234;
            boolean r76 = true;
        L235:
            if (r76 == true) goto L237;
            return;
        L237:
            if (r125.b.length() <= 0) goto L239;
            boolean r77 = true;
        L240:
            if (r77 == true) goto L242;
            return;
        L242:
            if (r125.c.length() <= 0) goto L244;
            r7 = true;
        L244:
            if (r7 == false) goto L322;
            w r78 = new w(r125.a, r125.b, r125.c);
            if (r74.j == false) goto L253;
            String r126 = r125.d;
            if (Intrinsics.areEqual(r126, "0") == false) goto L251;
            d.a(r78);
            r74.m3();
            return;
        L251:
            if (Intrinsics.areEqual(r126, "1") == false) goto L324;
            d.b(r78);
            r74.m3();
            return;
        L324:
            return;
        L253:
            String r127 = r125.d;
            if (Intrinsics.areEqual(r127, "0") == false) goto L257;
            d.b(r78);
            r74.m3();
            return;
        L257:
            if (Intrinsics.areEqual(r127, "1") == false) goto L327;
            d.a(r78);
            r74.m3();
            return;
        L327:
            return;
        L322:
            return;
        L239:
            r77 = false;
            goto L240
        L234:
            r76 = false;
            goto L235
        L229:
            r75 = false;
            goto L230
        }
    }

    static {
    }

    public final z0 S2() {
        return new b(this);
    }

    @Override // com.larus.avlink.simulInterpret.plugin.a
    public final f f2() {
        f r0 = this.g;
        if (r0 != null) goto L7;
        f r1 = j3();
        this.g = r1;
        return r1;
    L7:
        return r0;
    }

    public final f j3() {
        f r0 = new f(com.larus.audio.call.arch.b.b(getContext()));
        v4 r1 = (v4) getContext().c(Reflection.getOrCreateKotlinClass(v4.class), null);
        if (r1 == null) goto L7;
        u68.a.b r2 = r1.D();
        if (r2 == null) goto L7;
        Intrinsics.checkNotNullParameter(r2, "callback");
        r0.j.h(r2);
    L7:
        u4 r3 = (u4) getContext().c(Reflection.getOrCreateKotlinClass(u4.class), null);
        if (r3 == null) goto L12;
        u68.a.b r4 = r3.D();
        if (r4 == null) goto L12;
        Intrinsics.checkNotNullParameter(r4, "callback");
        r0.j.h(r4);
    L12:
        return r0;
    }

    public final void m3() {
        Job r0 = this.h;
        Job r1 = null;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        CoroutineScope r2 = ((n4) getContext()).r();
        if (r2 == null) goto L8;
        r1 = BuildersKt.launch$default(r2, null, null, new SimultaneousInterpretPlugin$startTimer$1(this, null), 3, null);
    L8:
        this.h = r1;
    }

    public final void V2() {
        if (v88.a.e(Integer.valueOf(((n4) getContext()).q())) == false) goto L6;
        b98.b.f(6, 1);
        return;
    }

    public final void W2() {
        if (v88.a.e(Integer.valueOf(((n4) getContext()).q())) == false) goto L6;
        b98.b.f(6, 2);
        return;
    }

    public final void a3() {
        if (Intrinsics.areEqual(((n4) getContext()).params().k.o, "dora_si") == false) goto L6;
        da8.a r0 = da8.a.a;
        Application r1 = AppHost.a.getApplication();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "context");
        da8.a.a(r1, null);
        return;
    }

    public final void e3() {
        super.e3();
        if (Intrinsics.areEqual(((n4) getContext()).params().k.o, "dora_si") == true) goto L5;
    L58:
        n1.d(this.f, "start si taskId is " + ((n4) getContext()).params().l.a);
        return;
    L5:
        if (this.j == false) goto L30;
        final f r0 = j3();
        this.g = r0;
        if (r0.g == false) goto L10;
        n1.e("StereoAudioPlayer", "Player is already running.");
        goto L30
    L10:
        if (r0.b == null) goto L60;
        n1.d("StereoAudioPlayer", "Engine already created.");
    L21:
        if (r0.b != null) goto L23;
        n1.b("StereoAudioPlayer", "Start failed, AudioTrack not created.");
        goto L30
    L23:
        r0.g = true;
        PthreadThreadV2 r2 = new PthreadThreadV2(new e(r0), "SimultaneousInterpretAudioPlayManager");
        ThreadMethodProxy.setName(r2, "AudioConsumerThread");
        ThreadMethodProxy.setPriority(r2, 10);
        ThreadMethodProxy.start(r2);
        r0.f = r2;
        AudioTrack r1 = r0.b;
        if (r1 != null) goto L26;
    L29:
        n1.d("StereoAudioPlayer", "Player started.");
        goto L30
    L26:
        if (g.d() == true) goto L28;
        r1.play();
        goto L29
    L28:
        r1.play();
        gna.a.c(r1.hashCode());
        goto L29
    L60:
        r0.c = AudioTrack.getMinBufferSize(24000, 12, 2);     // Catch: Exception -> L18
        if (r0.c > 0) goto L16;
        r0.c = 2560;     // Catch: Exception -> L18
        n1.e("StereoAudioPlayer", "Using fallback minBufferSize: " + r0.c);     // Catch: Exception -> L18
    L16:
        r0.b = new AudioTrack(3, 24000, 12, 2, r0.c, 1, 0);     // Catch: Exception -> L18
    L18:
        e = move-exception;
        n1.c("StereoAudioPlayer", "Failed to create AudioTrack.", e);
        r0.d();
    L30:
        d.h(true);
        n1.d(this.f, "startTimer in taskId: " + ((n4) getContext()).params().l.a);
        String r3 = ((n4) getContext()).params().l.a;
        Intrinsics.checkNotNullParameter(r3, "value");
        if (Intrinsics.areEqual(r3, d.b) == true) goto L33;
        d.b = r3;
        n1.d("SimultaneousInterpretSettingManager", "siTaskId changed to " + r3);
    L33:
        m3();
        if (this.j == false) goto L48;
        Job r4 = this.i;
        Job r5 = null;
        if (r4 == null) goto L38;
        Job.DefaultImpls.cancel$default(r4, null, 1, null);
    L38:
        IDoraService r6 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r6 == null) goto L43;
        SessionService r7 = r6.d();
        if (r7 == null) goto L43;
        r7.m(5);
    L43:
        CoroutineScope r8 = ((n4) getContext()).r();
        if (r8 == null) goto L46;
        r5 = BuildersKt.launch$default(r8, null, null, new SimultaneousInterpretPlugin$startConversationModeKeepAlive$1(null), 3, null);
    L46:
        this.i = r5;
        ((n4) getContext()).k().b(l3(), ((n4) getContext()).params().l.a, ((n4) getContext()).params().n.h, ((n4) getContext()).params().n.g, ((n4) getContext()).params().n.g, ((n4) getContext()).params().n.h, "");
    L48:
        if (this.k == false) goto L58;
        int r9 = ha8.e.b;
        ha8.e.a = System.currentTimeMillis();
        if (((n4) getContext()).params().k.p == false) goto L52;
        int r10 = u0.a;
        int r11 = j0.a;
        u0.a(j0.d(2131902700));
    L53:
        IRealtimeCallTracer r12 = ((n4) getContext()).k();
        String r13 = l3();
        String r14 = ((n4) getContext()).params().l.a;
        String r15 = ((n4) getContext()).params().n.g;
        String r16 = ((n4) getContext()).params().n.h;
        String r17 = ((n4) getContext()).params().n.h;
        String r18 = ((n4) getContext()).params().n.g;
        if (DoraConfig.f() == false) goto L56;
        String r19 = "conference_room";
    L57:
        r12.b(r13, r14, r15, r16, r17, r18, r19);
        goto L58
    L56:
        r19 = "face_to_face";
        goto L57
    L52:
        int r20 = u0.a;
        int r21 = j0.a;
        u0.a(j0.d(2131902702));
        goto L53
    }

    public final void f3() {
        if (Intrinsics.areEqual(((n4) getContext()).params().k.o, "dora_si") == false) goto L6;
        da8.a r0 = da8.a.a;
        Application r1 = AppHost.a.getApplication();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "context");
        NotificationManagerCompat.from(r1).cancel(12345);
        da8.a.b = "";
        da8.a.c = "";
        return;
    }

    public final void g3() {
        super.g3();
        if (Intrinsics.areEqual(((n4) getContext()).params().k.o, "dora_si") == false) goto L64;
        f r0 = this.g;
        boolean r1 = false;
        if (r0 != null) goto L7;
    L25:
        da8.a r2 = da8.a.a;
        Application r3 = AppHost.a.getApplication();
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "context");
        NotificationManagerCompat.from(r3).cancel(12345);
        da8.a.b = "";
        da8.a.c = "";
        d.h(false);
        if (o.a == true) goto L28;
    L37:
        o.a = true;
        n1.d(this.f, "cancelTimer in taskId: " + ((n4) getContext()).params().l.a);
        Job r4 = this.h;
        if (r4 == null) goto L40;
        Job.DefaultImpls.cancel$default(r4, null, 1, null);
    L40:
        this.h = null;
        Job r5 = this.i;
        if (r5 == null) goto L43;
        Job.DefaultImpls.cancel$default(r5, null, 1, null);
    L43:
        this.i = null;
        IDoraService r6 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r6 == null) goto L48;
        SessionService r7 = r6.d();
        if (r7 == null) goto L48;
        r7.p(5);
    L48:
        CoroutineScope r8 = ((n4) getContext()).r();
        if (r8 == null) goto L52;
        BuildersKt.launch$default(r8, null, null, new SimultaneousInterpretPlugin$reportAstEnd$1(this, null), 3, null);
    L52:
        if (this.j == false) goto L54;
        ((n4) getContext()).k().u(k3(), ((n4) getContext()).params().l.a, System.currentTimeMillis() - ((n4) getContext()).params().n.j, ((n4) getContext()).params().n.h, ((n4) getContext()).params().n.g, ((n4) getContext()).params().n.g, ((n4) getContext()).params().n.h, "", 0);
        return;
    L54:
        IRealtimeCallTracer r9 = ((n4) getContext()).k();
        String r10 = k3();
        long r11 = System.currentTimeMillis() - ((n4) getContext()).params().n.j;
        String r12 = ((n4) getContext()).params().l.a;
        String r13 = ((n4) getContext()).params().n.g;
        String r14 = ((n4) getContext()).params().n.h;
        String r15 = ((n4) getContext()).params().n.h;
        String r16 = ((n4) getContext()).params().n.g;
        int r17 = ha8.e.b;
        if (DoraConfig.f() == false) goto L57;
        String r18 = "conference_room";
    L58:
        r9.u(r10, r12, r11, r13, r14, r15, r16, r18, System.currentTimeMillis() - ha8.e.a);
        return;
    L57:
        r18 = "face_to_face";
        goto L58
    L28:
        if (this.k == false) goto L35;
        Integer r19 = ((n4) getContext()).params().n.a;
        if (r19 == null) goto L35;
        if (r19.intValue() != 42) goto L35;
        r1 = true;
    L35:
        if (r1 == true) goto L37;
        int r20 = u0.a;
        int r21 = j0.a;
        u0.a(j0.d(2131902704));
        goto L37
    L7:
        if (r0.g == false) goto L25;
        n1.d("StereoAudioPlayer", "Stopping player...");
        r0.g = false;
        ReentrantLock r22 = r0.h;
        r22.lock();
        n1.d("StereoAudioPlayer", "stop() invoked. " + r0.b());     // Catch: Throwable -> L22
        boolean r23 = r0.c("stop()");     // Catch: Throwable -> L22
        r0.i.signalAll();     // Catch: Throwable -> L22
        Unit r24 = Unit.INSTANCE;     // Catch: Throwable -> L22
        r22.unlock();
        PthreadThreadV2 r25 = r0.f;
        if (r25 == null) goto L62;
        r25.interrupt();
    L62:
        PthreadThreadV2 r26 = r0.f;     // Catch: InterruptedException -> L18
        if (r26 == null) goto L19;
        ThreadMethodProxy.join(r26, 500);     // Catch: InterruptedException -> L18
    L19:
        r0.f = null;
        r0.d();
        n1.d("StereoAudioPlayer", "Player stopped and released.");
        if (r23 == false) goto L25;
        n1.d("StereoAudioPlayer", "Dispatch onPlayEnd from stop() after consumer thread exits.");
        u68.a.b.a.a(r0.j);
    L18:
        ThreadMethodProxy.currentThread().interrupt();
    L22:
        th = move-exception;
        r22.unlock();
        throw th;
    }

    public final String k3() {
        Integer r0 = ((n4) getContext()).params().n.a;
        if (r0 != null) goto L6;
    L8:
        if (r0 != null) goto L11;
    L12:
        if (r0 != null) goto L15;
    L17:
        if (r0 != null) goto L20;
    L21:
        if (r0 != null) goto L24;
    L26:
        if (r0 != null) goto L29;
    L31:
        if (r0 != null) goto L34;
    L36:
        if (r0 == null) goto L49;
        if (r0.intValue() != 169) goto L49;
        return "exception";
    L49:
        return String.valueOf(((n4) getContext()).params().n.a);
    L34:
        if (r0.intValue() != 167) goto L36;
        return "live_activity";
    L29:
        if (r0.intValue() != 166) goto L31;
        return "out_of_time";
    L24:
        if (r0.intValue() != 32) goto L26;
    L42:
        return "gesture_control";
    L20:
        if (r0.intValue() == 6) goto L42;
    L15:
        if (r0.intValue() != 41) goto L17;
    L43:
        return "voice_control";
    L11:
        if (r0.intValue() == 2) goto L43;
    L6:
        if (r0.intValue() != 164) goto L8;
        return "click_end_icon";
    }

    public final String l3() {
        switch(((n4) getContext()).params().k.s) {
            case 8: goto L7;
            case 9: goto L6;
            case 10: goto L5;
            default: goto L4;
        };
    L4:
        return "";
    L5:
        return "gesture_control";
    L6:
        return "voice_control";
    L7:
        return "click_start_icon";
    }

    public final String T2() {
        return this.f;
    }

    public SimultaneousInterpretPlugin(n4 r6) {
        Intrinsics.checkNotNullParameter(r6, "context");
        super(r6);
        this.f = "SimultaneousInterpretPlugin";
        da8.a r7 = da8.a.a;
        Application r1 = AppHost.a.getApplication();
        r7.getClass();
        Intrinsics.checkNotNullParameter(r1, "context");
        boolean r2 = false;
        if (Build.VERSION.SDK_INT < 26) goto L5;
        NotificationChannel r8 = new NotificationChannel("translation_channel", "translation_name", 4);
        r8.setSound(null, null);
        r8.enableVibration(false);
        Object r0 = r1.getSystemService("notification");
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.app.NotificationManager");
        ((NotificationManager) r0).createNotificationChannel(r8);
    L5:
        IDoraService r9 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r9 == null) goto L12;
        DeviceService r10 = r9.device();
        if (r10 == null) goto L12;
        if (r10.b0() != true) goto L12;
        boolean r11 = true;
    L13:
        this.j = r11;
        IDoraService r12 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r12 == null) goto L20;
        DeviceService r13 = r12.device();
        if (r13 == null) goto L20;
        if (r13.M() != true) goto L20;
        r2 = true;
    L20:
        this.k = r2;
        return;
    L12:
        r11 = false;
        goto L13
    }
}
