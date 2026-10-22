package com.larus.avlink.activeSummary;

import android.os.SystemClock;
import com.larus.applog.api.IApplog;
import com.larus.audio.AudioServiceDelegate;
import com.larus.audio.IFlowTtsClientService;
import com.larus.avlink.api.IDoraAVLinkService;
import com.larus.avlink.model.ProactiveSummaryScene;
import com.larus.avlink.n1;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.dora.impl.serviceimpl.SessionService;
import com.larus.platform.service.AccountService;
import com.larus.voicecall.impl.util.RealtimeCallUtil;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class ProactiveSummaryModel {
    public static final /* synthetic */ int g = 0;
    public int a;
    public volatile boolean b;
    public volatile long c;
    public volatile boolean d;
    public final d e;
    public final ReentrantLock f;

    public static final class a {
    }

    public static final class b {
        public final boolean a;
        public final boolean b;
        public final FailReason c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r1 = 1231;
            if (this.a == false) goto L5;
            int r0 = 1231;
        L6:
            int r2 = r0 * 31;
            if (this.b == true) goto L11;
            r1 = 1237;
        L11:
            return ((r2 + r1) * 31) + this.c.hashCode();
        L5:
            r0 = 1237;
            goto L6
        }

        public final String toString() {
            return "SystemNotifyValidationResult(canBroadcast=" + this.a + ", shouldDelay=" + this.b + ", failReason=" + this.c + ')';
        }

        public /* synthetic */ b() {
            this(true, false, FailReason.UNKNOWN);
        }

        public b(boolean r2, boolean r3, FailReason r4) {
            Intrinsics.checkNotNullParameter(r4, "failReason");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ProactiveSummarySource.values().length];
            r0[ProactiveSummarySource.PUSH.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[ProactiveSummarySource.SSE_FRONTIER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[ProactiveSummarySource.IM_FRONTIER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public static final class d extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
        public final /* synthetic */ ProactiveSummaryModel a;

        public d(CoroutineExceptionHandler.Key r1, ProactiveSummaryModel r2) {
            this.a = r2;
            super(r1);
        }

        public final void handleException(CoroutineContext r2, Throwable r3) {
            this.a.b = false;
            n1.b("ProactiveSummaryRecords", "[NotificationTracer] CoroutineExceptionHandler throwable: " + r3);
        }
    }

    static {
    }

    public ProactiveSummaryModel() {
        this.e = new d(CoroutineExceptionHandler.Key, this);
        this.f = new ReentrantLock();
    }

    public static String c(ProactiveSummarySource r1) {
        int r2 = c.a[r1.ordinal()];
        if (r2 == 1) goto L12;
        if (r2 == 2) goto L15;
        if (r2 == 3) goto L14;
        return ProactiveSummarySource.UNKNOWN.getValue();
    L14:
        return ProactiveSummarySource.IM_FRONTIER_CACHE.getValue();
    L15:
        return ProactiveSummarySource.SSE_FRONTIER_CACHE.getValue();
    L12:
        return ProactiveSummarySource.PUSH_CACHE.getValue();
    }

    public static Unit g(f r20, ProactiveSummarySource r21) {
        IDoraService r2 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        Integer r3 = null;
        if (r2 == null) goto L5;
        DeviceService r4 = r2.device();
    L6:
        boolean r5 = true;
        if (r4 != null) goto L9;
    L11:
        boolean r6 = false;
    L12:
        if (r4 == null) goto L16;
        Integer r7 = r4.r();
        if (r7 == null) goto L16;
        int r8 = r7.intValue();
    L18:
        if (r4 == null) goto L22;
        Integer r9 = r4.q();
        if (r9 == null) goto L22;
        int r10 = r9.intValue();
    L24:
        if ((r8 & 2) == 0) goto L26;
        boolean r11 = true;
    L27:
        IDoraService r12 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r12 == null) goto L34;
        SessionService r13 = r12.d();
        if (r13 == null) goto L34;
        if (r13.a != true) goto L34;
        boolean r14 = true;
    L35:
        if (r14 == false) goto L37;
    L40:
        boolean r15 = true;
    L41:
        com.larus.avlink.activeSummary.b r16 = r20.d;
        if (r16 == null) goto L44;
        int r17 = r16.a;
    L45:
        if (r17 <= 0) goto L47;
        boolean r19 = true;
    L49:
        if (r6 == false) goto L100;
        if (r11 == true) goto L100;
        if (r15 == true) goto L100;
        if ((r8 & 1) == 0) goto L56;
        boolean r22 = true;
    L57:
        if (r22 == true) goto L59;
        b r23 = new b();
    L113:
        if (r23.a == false) goto L116;
        return null;
    L116:
        if (r23.b == false) goto L122;
        StringBuilder r24 = new StringBuilder("Delay system notify summary due to client state. summaryId=");
        r24.append(r20.a);
        r24.append(", scene=");
        r24.append(r20.b);
        r24.append(", subScene=");
        r24.append(r20.c);
        r24.append(", source=");
        r24.append(r21);
        r24.append(", avoidTimestamp=");
        com.larus.avlink.activeSummary.b r25 = r20.d;
        if (r25 == null) goto L120;
        r3 = Integer.valueOf(r25.a);
    L120:
        r24.append(r3);
        r24.append(", reason=");
        r24.append(r23.c.getValue());
        n1.d("ProactiveSummaryRecords", r24.toString());
        k<f> r26 = n.a;
        n.a(c(r21), r20);
        return Unit.INSTANCE;
    L122:
        k<f> r27 = n.a;
        n.h(r20.a, String.valueOf(r20.b), r20.c, r21.getValue(), ProactiveSummaryStartVuiStatus.FAIL, r23.c, r20.b());
        n1.d("ProactiveSummaryRecords", "Abandon system notify summary due to client state. summaryId=" + r20.a + ", scene=" + r20.b + ", subScene=" + r20.c + ", source=" + r21 + ", reason=" + r23.c.getValue());
        return Unit.INSTANCE;
    L59:
        String r29 = r20.i;
        if (r29 != null) goto L65;
        Map<String, String> r30 = r20.j;
        if (r30 == null) goto L64;
        r29 = r30.get("priority_broadcast_switch");
        goto L65
    L64:
        r29 = null;
    L65:
        if (r29 == null) goto L67;
        Boolean r31 = Boolean.valueOf(Intrinsics.areEqual(r29, "1"));
    L68:
        if (r31 != null) goto L75;
        IDoraService r32 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r32 == null) goto L73;
        r31 = Boolean.valueOf(r32.Q(AccountService.a.getUserId()));
    L74:
        if (r31 != null) goto L75;
        boolean r33 = true;
    L77:
        if (r10 == (-1)) goto L79;
        boolean r34 = true;
    L81:
        if ((r10 & 1) != 0) goto L84;
        r5 = false;
    L84:
        if (r33 == true) goto L86;
        FailReason r35 = FailReason.PRIORITY_SWITCH_OFF;
    L92:
        if (r35 != FailReason.PRIORITY_SWITCH_OFF) goto L94;
        n1.d("ProactiveSummaryRecords", "[NotificationTracer][SystemNotify] dora curr-status not meet. subScene=" + r20.c + " [a2dp:" + r22 + "] [pbs:" + r33 + ']');
        b r36 = new b(false, r19, r35);
    L111:
        r23 = r36;
        goto L113
    L94:
        if (r34 == true) goto L96;
        r23 = new b();
        goto L113
    L96:
        boolean r37 = !r5;
        if (r35 != FailReason.PRIORITY_OTHER_DEVICE_A2DP_OCCUPIED) goto L99;
        n1.d("ProactiveSummaryRecords", "[NotificationTracer][SystemNotify] dora curr-status not meet. subScene=" + r20.c + " [a2dp:" + r22 + "] [pbs:" + r33 + "] [curr device a2dp:" + r5 + "] [other a2dp:" + r37 + ']');
        r36 = new b(false, r19, r35);
        goto L111
    L99:
        r23 = new b();
        goto L113
    L86:
        if (r34 == false) goto L90;
        if (r5 == true) goto L90;
        r35 = FailReason.PRIORITY_OTHER_DEVICE_A2DP_OCCUPIED;
    L90:
        r35 = null;
        goto L92
    L79:
        r34 = false;
        goto L81
    L73:
        r31 = null;
    L75:
        r33 = r31.booleanValue();
        goto L77
    L67:
        r31 = null;
        goto L68
    L56:
        r22 = false;
    L100:
        StringBuilder r38 = new StringBuilder("[NotificationTracer][SystemNotify] dora curr-status not meet. subScene=");
        r38.append(r20.c);
        r38.append(" [cs:");
        r38.append(r6);
        r38.append("] [a2dp:");
        if ((r8 & 1) != 0) goto L104;
        r5 = false;
    L104:
        r38.append(r5);
        r38.append("] [hfp:");
        r38.append(r11);
        r38.append("] [mo:");
        r38.append(r15);
        r38.append(']');
        n1.d("ProactiveSummaryRecords", r38.toString());
        if (r11 == false) goto L107;
        FailReason r39 = FailReason.HFP_OCCUPIED;
    L110:
        r36 = new b(false, r19, r39);
        goto L111
    L107:
        if (r15 == false) goto L109;
        r39 = FailReason.VUI_DISABLED;
        goto L110
    L109:
        r39 = FailReason.AUDIO_CONFLICTS;
        goto L110
    L47:
        r19 = false;
        goto L49
    L44:
        r17 = 0;
        goto L45
    L37:
        if (AudioServiceDelegate.a.P().isRecording() == true) goto L40;
        r15 = false;
    L34:
        r14 = false;
        goto L35
    L26:
        r11 = false;
    L22:
        r10 = -1;
    L16:
        r8 = 0;
        goto L18
    L9:
        if (r4.J() != true) goto L11;
        r6 = true;
        goto L12
    L5:
        r4 = null;
        goto L6
    }

    public final void d(String r9, ProactiveSummarySource r10) {
        Intrinsics.checkNotNullParameter(r9, "summaryId");
        Intrinsics.checkNotNullParameter(r10, "source");
        n1.d("ProactiveSummaryRecords", "receive proactive summary from " + r10.getValue() + ", summaryId is " + r9);
        if (c98.c.a() == false) goto L6;
        n1.d("ProactiveSummaryRecords", "Abandon this fetch because of isDoraCallDegrade");
        return;
    L6:
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), Dispatchers.getIO(), null, new ProactiveSummaryModel$fetchInfoFromId$1(r9, r10, this, null), 2, null);
    }

    public final void e(String r9, String r10) {
        Intrinsics.checkNotNullParameter(r9, "title");
        Intrinsics.checkNotNullParameter(r10, "content");
        n1.d("ProactiveSummaryRecords", "receive DouBao push title is " + r9 + ", content is " + r10);
        if (c98.c.a() == false) goto L6;
        n1.d("ProactiveSummaryRecords", "Abandon this fetch because of isDoraCallDegrade");
        return;
    L6:
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), Dispatchers.getIO(), null, new ProactiveSummaryModel$fetchInfoFromPush$1(r9, r10, this, null), 2, null);
    }

    public final void h(String r9, boolean r10) {
        if (SystemClock.elapsedRealtime() < this.c) goto L7;
        n1.a("ProactiveSummaryRecords", "[NotificationTracer] receiveStreamForNotificationSummary trigger:" + r9 + ": exceed sseCloseTimestamp, return....");
        return;
    L7:
        if (this.b == false) goto L12;
        if (r10 == true) goto L10;
        this.d = true;
        n1.a("ProactiveSummaryRecords", "[NotificationTracer] receiveStreamForNotificationSummary trigger:" + r9 + ": isSSEConnecting, mark reconnect after done....");
        return;
    L10:
        n1.a("ProactiveSummaryRecords", "[NotificationTracer] receiveStreamForNotificationSummary trigger:" + r9 + ": isSSEConnecting, return....");
        return;
    L12:
        this.b = true;
        if (r10 == true) goto L15;
        this.a = 0;
    L15:
        JSONObject r11 = new JSONObject();
        IApplog.Companion r0 = IApplog.a;
        r11.put("device_id", r0.getDeviceId());
        r11.put("user_id", r0.getUserID());
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), Dispatchers.getIO().plus(this.e), null, new ProactiveSummaryModel$receiveStreamForProactiveNotificationSummary$1(r9, r11, this, null), 2, null);
    }

    public static final void a(ProactiveSummaryModel r29, f r30, ProactiveSummarySource r31) {
        ReentrantLock r7 = r29.f;
        r7.lock();
        IDoraService r8 = (IDoraService) ServiceManager.get().getService(IDoraService.class);     // Catch: Throwable -> L231
        if (r8 == null) goto L10;
        SessionService r9 = r8.d();     // Catch: Throwable -> L231
        if (r9 == null) goto L10;
        if (r9.a != true) goto L10;
        boolean r10 = true;
    L11:
        IDoraService r11 = (IDoraService) ServiceManager.get().getService(IDoraService.class);     // Catch: Throwable -> L231
        if (r11 == null) goto L19;
        DeviceService r12 = r11.device();     // Catch: Throwable -> L231
        if (r12 == null) goto L19;
        Integer r13 = r12.r();     // Catch: Throwable -> L231
        if (r13 == null) goto L19;
        int r14 = r13.intValue();     // Catch: Throwable -> L231
    L20:
        IFlowTtsClientService.a.getClass();     // Catch: Throwable -> L231
        boolean r15 = IFlowTtsClientService.a.a().a();     // Catch: Throwable -> L231
        IDoraAVLinkService r16 = (IDoraAVLinkService) ServiceManager.get().getService(IDoraAVLinkService.class);     // Catch: Throwable -> L231
        if (r16 != null) goto L23;
    L25:
        boolean r17 = false;
    L26:
        Integer r19 = r30.b;     // Catch: Throwable -> L231
        int r20 = ProactiveSummaryScene.Remind.getValue();     // Catch: Throwable -> L231
        ReentrantLock r21 = r7;
        Object r22 = null;
        if (r19 != null) goto L235;
    L75:
        int r3 = ProactiveSummaryScene.News.getValue();     // Catch: Throwable -> L54
        if (r19 != null) goto L80;
    L124:
        Integer r2 = r30.b;     // Catch: Throwable -> L54
        int r4 = ProactiveSummaryScene.SystemNotify.getValue();     // Catch: Throwable -> L54
        if (r2 != null) goto L128;
    L147:
        Integer r5 = r30.b;     // Catch: Throwable -> L54
        int r6 = ProactiveSummaryScene.Music.getValue();     // Catch: Throwable -> L54
        if (r5 != null) goto L151;
    L152:
        Integer r23 = r30.b;     // Catch: Throwable -> L54
        int r24 = ProactiveSummaryScene.ProactiveMsg.getValue();     // Catch: Throwable -> L54
        if (r23 != null) goto L156;
    L177:
        if (r30.f() == true) goto L183;
        if (r30.g() == true) goto L183;
        if (r30.e() == true) goto L183;
    L185:
        if (r10 == false) goto L187;
    L194:
        k<f> r25 = n.a;     // Catch: Throwable -> L54
        n.h(r30.a, String.valueOf(r30.b), r30.c, r31.getValue(), ProactiveSummaryStartVuiStatus.FAIL, FailReason.AUDIO_CONFLICTS, r30.b());     // Catch: Throwable -> L54
        n1.d("ProactiveSummaryRecords", "Abandon this push because in handleAudioConflicts due to switch status: isRealTimeCall: " + r10 + ", isTtsPlayer: " + r15 + ", isDoraCall: " + r17 + ", idleState is " + r14 + " summaryId is " + r30.a + ", scene is " + r30.b + ", source is " + r31);     // Catch: Throwable -> L54
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L54
    L195:
        r21.unlock();
        return;
    L187:
        if (r14 == 2) goto L194;
        if (r15 == true) goto L194;
        if (r17 == true) goto L194;
        if (AudioServiceDelegate.a.P().isRecording() == true) goto L194;
        k<f> r1 = n.a;     // Catch: Throwable -> L54
        n.d(r30.a, String.valueOf(r30.b), r30.c, r31.getValue(), r30.f, false, r30.b(), r30.d(), r30.a());     // Catch: Throwable -> L54
    L183:
        if (g(r30, r31) == null) goto L185;
        r21.unlock();
        return;
    L156:
        if (r23.intValue() != r24) goto L177;
    L157:
        IDoraService r26 = (IDoraService) ServiceManager.get().getService(IDoraService.class);     // Catch: Throwable -> L54
        if (r26 != null) goto L160;
    L164:
        boolean r27 = false;
    L165:
        if (r27 == false) goto L196;
        IDoraService r32 = (IDoraService) ServiceManager.get().getService(IDoraService.class);     // Catch: Throwable -> L54
        if (r32 == null) goto L173;
        DeviceService r33 = r32.device();     // Catch: Throwable -> L54
        if (r33 == null) goto L173;
        if (r33.D() != true) goto L173;
        boolean r34 = true;
    L174:
        if (r34 == true) goto L177;
    L173:
        r34 = false;
    L196:
        k<f> r35 = n.a;     // Catch: Throwable -> L54
        n.h(r30.a, r30.b.toString(), r30.c, r31.getValue(), ProactiveSummaryStartVuiStatus.FAIL, FailReason.EXPERIMENT_OR_SWITCH_OFF, r30.b());     // Catch: Throwable -> L54
        StringBuilder r36 = new StringBuilder("Abandon this push because in handleAudioConflicts due to switch status: isNLFeatureEnabled: ");     // Catch: Throwable -> L54
        IDoraService r37 = (IDoraService) ServiceManager.get().getService(IDoraService.class);     // Catch: Throwable -> L54
        if (r37 != null) goto L199;
    L203:
        boolean r38 = false;
    L204:
        r36.append(r38);     // Catch: Throwable -> L54
        r36.append(", isNLFeatureUserOpened: ");     // Catch: Throwable -> L54
        IDoraService r39 = (IDoraService) ServiceManager.get().getService(IDoraService.class);     // Catch: Throwable -> L54
        if (r39 != null) goto L207;
    L211:
        boolean r40 = false;
    L212:
        r36.append(r40);     // Catch: Throwable -> L54
        r36.append(", isAIPushFeatureEnabled: ");     // Catch: Throwable -> L54
        IDoraService r41 = (IDoraService) ServiceManager.get().getService(IDoraService.class);     // Catch: Throwable -> L54
        if (r41 != null) goto L215;
    L219:
        boolean r42 = false;
    L220:
        r36.append(r42);     // Catch: Throwable -> L54
        r36.append(", isAIPushFeatureUserOpened: ");     // Catch: Throwable -> L54
        IDoraService r43 = (IDoraService) ServiceManager.get().getService(IDoraService.class);     // Catch: Throwable -> L54
        if (r43 == null) goto L227;
        DeviceService r44 = r43.device();     // Catch: Throwable -> L54
        if (r44 == null) goto L227;
        if (r44.D() != true) goto L227;
        boolean r45 = true;
    L228:
        r36.append(r45);     // Catch: Throwable -> L54
        r36.append(", summaryId is ");     // Catch: Throwable -> L54
        r36.append(r30.a);     // Catch: Throwable -> L54
        r36.append(", scene is ");     // Catch: Throwable -> L54
        r36.append(r30.b);     // Catch: Throwable -> L54
        r36.append(", source is ");     // Catch: Throwable -> L54
        r36.append(r31);     // Catch: Throwable -> L54
        n1.d("ProactiveSummaryRecords", r36.toString());     // Catch: Throwable -> L54
        r21.unlock();
        return;
    L227:
        r45 = false;
        goto L228
    L215:
        if (r41.device() == null) goto L219;
        if (com.larus.dora.impl.nl.n.a() != true) goto L219;
        r42 = true;
        goto L220
    L207:
        if (r39.device() == null) goto L211;
        if (com.larus.dora.impl.nl.n.c() != true) goto L211;
        r40 = true;
        goto L212
    L199:
        if (r37.device() == null) goto L203;
        if (com.larus.dora.impl.nl.n.b() != true) goto L203;
        r38 = true;
        goto L204
    L160:
        if (r26.device() == null) goto L164;
        if (com.larus.dora.impl.nl.n.a() != true) goto L164;
        r27 = true;
        goto L165
    L151:
        if (r5.intValue() == r6) goto L157;
    L128:
        if (r2.intValue() != r4) goto L147;
        IDoraService r46 = (IDoraService) ServiceManager.get().getService(IDoraService.class);     // Catch: Throwable -> L54
        if (r46 != null) goto L132;
    L136:
        boolean r47 = false;
    L137:
        if (r47 == false) goto L196;
        IDoraService r48 = (IDoraService) ServiceManager.get().getService(IDoraService.class);     // Catch: Throwable -> L54
        if (r48 != null) goto L141;
    L145:
        boolean r49 = false;
    L146:
        if (r49 == false) goto L196;
    L141:
        if (r48.device() == null) goto L145;
        if (com.larus.dora.impl.nl.n.c() != true) goto L145;
        r49 = true;
        goto L146
    L132:
        if (r46.device() == null) goto L136;
        if (com.larus.dora.impl.nl.n.b() != true) goto L136;
        r47 = true;
        goto L137
    L80:
        if (r19.intValue() != r3) goto L124;
        IDoraService r50 = (IDoraService) ServiceManager.get().getService(IDoraService.class);     // Catch: Throwable -> L54
        if (r50 == null) goto L88;
        DeviceService r51 = r50.device();     // Catch: Throwable -> L54
        if (r51 == null) goto L88;
        if (r51.D() != true) goto L88;
        boolean r52 = true;
    L89:
        if (r52 == false) goto L111;
        IDoraService r53 = (IDoraService) ServiceManager.get().getService(IDoraService.class);     // Catch: Throwable -> L54
        if (r53 != null) goto L93;
    L97:
        boolean r110 = false;
    L98:
        if (r110 == false) goto L111;
        if (r10 == false) goto L102;
    L107:
        StringBuilder r54 = new StringBuilder("currently not available for playback, temporarily cached. summaryId is ");     // Catch: Throwable -> L54
        r54.append(r30.a);     // Catch: Throwable -> L54
        r54.append(", scene is ");     // Catch: Throwable -> L54
        r54.append(r30.b);     // Catch: Throwable -> L54
        r54.append(", avoidTimestamp is ");     // Catch: Throwable -> L54
        com.larus.avlink.activeSummary.b r55 = r30.d;     // Catch: Throwable -> L54
        if (r55 == null) goto L110;
        r22 = Integer.valueOf(r55.a);     // Catch: Throwable -> L54
    L110:
        r54.append(r22);     // Catch: Throwable -> L54
        r54.append(", isRealTimeCall is ");     // Catch: Throwable -> L54
        r54.append(r10);     // Catch: Throwable -> L54
        r54.append(", isDoraCall is ");     // Catch: Throwable -> L54
        r54.append(r17);     // Catch: Throwable -> L54
        r54.append(", isTtsPlayer is ");     // Catch: Throwable -> L54
        r54.append(r15);     // Catch: Throwable -> L54
        r54.append(" idleState is ");     // Catch: Throwable -> L54
        r54.append(r14);     // Catch: Throwable -> L54
        r54.append(", source is ");     // Catch: Throwable -> L54
        r54.append(r31);     // Catch: Throwable -> L54
        r54.append(' ');     // Catch: Throwable -> L54
        n1.d("ProactiveSummaryRecords", r54.toString());     // Catch: Throwable -> L54
        k<f> r56 = n.a;     // Catch: Throwable -> L54
        n.a(c(r31), r30);     // Catch: Throwable -> L54
        Unit r57 = Unit.INSTANCE;     // Catch: Throwable -> L54
        goto L195
    L102:
        if (r14 == 2) goto L107;
        if (r15 == true) goto L107;
        if (r17 == true) goto L107;
        k<f> r59 = n.a;     // Catch: Throwable -> L54
        n.d(r30.a, r30.b.toString(), r30.c, r31.getValue(), r30.f, false, r30.b(), r30.d(), r30.a());     // Catch: Throwable -> L54
        goto L195
    L93:
        if (r53.device() == null) goto L97;
        if (com.larus.dora.impl.nl.n.a() != true) goto L97;
        r110 = true;
    L111:
        k<f> r60 = n.a;     // Catch: Throwable -> L54
        n.h(r30.a, r30.b.toString(), r30.c, r31.getValue(), ProactiveSummaryStartVuiStatus.FAIL, FailReason.EXPERIMENT_OR_SWITCH_OFF, r30.b());     // Catch: Throwable -> L54
        StringBuilder r61 = new StringBuilder("Abandon this push because in handleAudioConflicts due to switch status: isAIPushFeatureUserOpened: ");     // Catch: Throwable -> L54
        IDoraService r62 = (IDoraService) ServiceManager.get().getService(IDoraService.class);     // Catch: Throwable -> L54
        if (r62 == null) goto L116;
        DeviceService r63 = r62.device();     // Catch: Throwable -> L54
        if (r63 == null) goto L116;
        Boolean r64 = Boolean.valueOf(r63.D());     // Catch: Throwable -> L54
    L117:
        r61.append(r64);     // Catch: Throwable -> L54
        r61.append(", isAIPushFeatureEnabled: ");     // Catch: Throwable -> L54
        IDoraService r65 = (IDoraService) ServiceManager.get().getService(IDoraService.class);     // Catch: Throwable -> L54
        if (r65 != null) goto L120;
    L122:
        r61.append(r22);     // Catch: Throwable -> L54
        r61.append(", summaryId is ");     // Catch: Throwable -> L54
        r61.append(r30.a);     // Catch: Throwable -> L54
        r61.append(", scene is ");     // Catch: Throwable -> L54
        r61.append(r30.b);     // Catch: Throwable -> L54
        r61.append(", source is ");     // Catch: Throwable -> L54
        r61.append(r31);     // Catch: Throwable -> L54
        n1.d("ProactiveSummaryRecords", r61.toString());     // Catch: Throwable -> L54
        r21.unlock();
        return;
    L120:
        if (r65.device() == null) goto L122;
        r22 = Boolean.valueOf(com.larus.dora.impl.nl.n.a());     // Catch: Throwable -> L54
    L116:
        r64 = null;
    L88:
        r52 = false;
        goto L89
    L235:
    L54:
        th = th;
    L233:
        r21.unlock();
        throw th;
    L32:
        if (r19.intValue() != r20) goto L75;
        IDoraService r66 = (IDoraService) ServiceManager.get().getService(IDoraService.class);     // Catch: Throwable -> L54
        if (r66 == null) goto L40;
        DeviceService r67 = r66.device();     // Catch: Throwable -> L54
        if (r67 == null) goto L40;
        if (r67.a() != true) goto L40;
        boolean r68 = true;
    L41:
        if (r68 == false) goto L64;
        if (r17 == false) goto L49;
        IDoraAVLinkService r69 = (IDoraAVLinkService) ServiceManager.get().getService(IDoraAVLinkService.class);     // Catch: Throwable -> L54
        if (r69 == null) goto L46;
        Integer r70 = r69.c();     // Catch: Throwable -> L54
    L48:
        if (v88.a.f(r70) == false) goto L49;
    L56:
        StringBuilder r71 = new StringBuilder("Lite: currently not available for playback, temporarily cached. summaryId is ");     // Catch: Throwable -> L54
        r71.append(r30.a);     // Catch: Throwable -> L54
        r71.append(", scene is ");     // Catch: Throwable -> L54
        r71.append(r30.b);     // Catch: Throwable -> L54
        r71.append(", isDora is ");     // Catch: Throwable -> L54
        r71.append(r17);     // Catch: Throwable -> L54
        r71.append(", doraMode is ");     // Catch: Throwable -> L54
        IDoraAVLinkService r72 = (IDoraAVLinkService) ServiceManager.get().getService(IDoraAVLinkService.class);     // Catch: Throwable -> L54
        if (r72 == null) goto L59;
        Integer r73 = r72.c();     // Catch: Throwable -> L54
    L60:
        r71.append(r73);     // Catch: Throwable -> L54
        r71.append("avoidTimestamp is ");     // Catch: Throwable -> L54
        com.larus.avlink.activeSummary.b r74 = r30.d;     // Catch: Throwable -> L54
        if (r74 == null) goto L63;
        r22 = Integer.valueOf(r74.a);     // Catch: Throwable -> L54
    L63:
        r71.append(r22);     // Catch: Throwable -> L54
        r71.append(", isRealTimeCall is ");     // Catch: Throwable -> L54
        r71.append(r10);     // Catch: Throwable -> L54
        r71.append(", idleState is ");     // Catch: Throwable -> L54
        r71.append(r14);     // Catch: Throwable -> L54
        r71.append(", source is ");     // Catch: Throwable -> L54
        r71.append(r31);     // Catch: Throwable -> L54
        r71.append(' ');     // Catch: Throwable -> L54
        n1.d("ProactiveSummaryRecords", r71.toString());     // Catch: Throwable -> L54
        k<f> r75 = n.a;     // Catch: Throwable -> L54
        n.a(c(r31), r30);     // Catch: Throwable -> L54
        Unit r76 = Unit.INSTANCE;     // Catch: Throwable -> L54
        goto L195
    L59:
        r73 = null;
        goto L60
    L46:
        r70 = null;
    L49:
        if (r10 == true) goto L56;
        if (r14 == 2) goto L56;
        k<f> r77 = n.a;     // Catch: Throwable -> L54
        n.d(r30.a, r30.b.toString(), r30.c, r31.getValue(), r30.f, false, r30.b(), r30.d(), r30.a());     // Catch: Throwable -> L54
        goto L195
    L64:
        IDoraService r79 = (IDoraService) ServiceManager.get().getService(IDoraService.class);     // Catch: Throwable -> L54
        if (r79 == null) goto L71;
        DeviceService r80 = r79.device();     // Catch: Throwable -> L54
        if (r80 == null) goto L71;
        if (r80.M() != true) goto L71;
        boolean r81 = true;
    L72:
        if (r81 == false) goto L74;
        f(r10, r14, r15, r17, r30, r31);     // Catch: Throwable -> L54
        Unit r82 = Unit.INSTANCE;     // Catch: Throwable -> L54
        goto L195
    L74:
        n1.d("ProactiveSummaryRecords", "No Proactive Remind in other device");     // Catch: Throwable -> L54
        Unit r83 = Unit.INSTANCE;     // Catch: Throwable -> L54
    L71:
        r81 = false;
    L40:
        r68 = false;
        goto L41
    L23:
        if (r16.L() != true) goto L25;
        r17 = true;
    L19:
        n1.d("ProactiveSummaryRecords", "Exceptional case , DoraAdapter.getInstance().current() is null, so result is false.");     // Catch: Throwable -> L231
        r14 = 0;
    L10:
        r10 = false;
    L231:
        th = th;
        r21 = r7;
        goto L233
    }

    public static final boolean b(ProactiveSummaryModel r7, f r8, ProactiveSummarySource r9) {
        r7.getClass();
        Integer r10 = r8.b;
        int r0 = ProactiveSummaryScene.SystemNotify.getValue();
        if (r10 != null) goto L6;
    L13:
        return false;
    L6:
        if (r10.intValue() != r0) goto L13;
        if (r8.a() != null) goto L11;
        n1.d("ProactiveSummaryRecords", "Skip unlock drop for system notify because original_system_notification_list is empty. summaryId=" + r8.a + ", subScene=" + r8.c + ", source=" + r9.getValue());
        goto L13
    L11:
        com.larus.avlink.notification.a r11 = com.larus.avlink.notification.a.a;
        Long r3 = r8.a();
        r11.getClass();
        if (com.larus.avlink.notification.a.b(r3) == false) goto L13;
        n1.d("ProactiveSummaryRecords", "Discard system notify summary after device unlock. summaryId=" + r8.a + ", subScene=" + r8.c + ", earliestClientReceiveTimestampMs=" + r8.a() + ", source=" + r9.getValue());
        k<f> r12 = n.a;
        n.h(r8.a, r8.b.toString(), r8.c, r9.getValue(), ProactiveSummaryStartVuiStatus.FAIL, FailReason.DEVICE_UNLOCKED, r8.b());
        return true;
    }

    public static void f(boolean r23, int r24, boolean r25, boolean r26, f r27, ProactiveSummarySource r29) {
        IDoraAVLinkService r4 = (IDoraAVLinkService) ServiceManager.get().getService(IDoraAVLinkService.class);
        if (r4 == null) goto L5;
        Integer r5 = r4.c();
    L6:
        boolean r6 = false;
        if (r5 == null) goto L9;
        int r7 = r5.intValue();
    L10:
        boolean r8 = ia8.e.a().isRecording();
        if (v88.a.b(Integer.valueOf(r7)) == false) goto L15;
        RealtimeCallUtil.a.getClass();
        if (RealtimeCallUtil.G == true) goto L15;
        boolean r14 = true;
    L16:
        if (r23 == true) goto L18;
        if (r26 == true) goto L18;
    L20:
        boolean r9 = false;
    L21:
        IDoraService r10 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r10 == null) goto L28;
        DeviceService r11 = r10.device();
        if (r11 == null) goto L28;
        if (r11.r0() != true) goto L28;
        boolean r12 = true;
    L29:
        IDoraService r13 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r13 == null) goto L36;
        DeviceService r15 = r13.device();
        if (r15 == null) goto L36;
        if (r15.W() != true) goto L36;
        boolean r16 = true;
    L37:
        IDoraService r17 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r17 == null) goto L40;
        int r19 = r17.d0();
    L41:
        if (r9 == true) goto L48;
        if (r12 == true) goto L48;
        if (r16 == true) goto L48;
        if (r19 == 0) goto L48;
        if (r24 == 2) goto L48;
        if (r8 == true) goto L48;
    L49:
        if (r6 == false) goto L51;
        k<f> r20 = n.a;
        n.i(r27.a, String.valueOf(r27.b), r27.c, r29.getValue(), ProactiveSummaryStartVuiStatus.FAIL, FailReason.AUDIO_CONFLICTS, null, 64);
        n1.d("ProactiveSummaryRecords", "G:Abandon this remind because in handleAudioConflicts due to switch status: isRealTimeCall: " + r23 + ",  isTtsPlayer: " + r25 + ", isRecording: " + r8 + ", isDoraCall: " + r26 + ",  doraMode is " + r5 + ",  idleState is " + r24 + ", headphoneMode: " + r16 + ",  videoRecord: " + r12 + ",  wearCount: " + r19 + ", envObserveNonConversation: " + r14 + ",idleState is " + r24 + ", summaryId is " + r27.a + ", scene is " + r27.b + ", source is " + r29);
        return;
    L51:
        k<f> r1 = n.a;
        n.d(r27.a, String.valueOf(r27.b), r27.c, r29.getValue(), r27.f, r14, null, null, null);
        return;
    L48:
        r6 = true;
        goto L49
    L40:
        r19 = 0;
    L36:
        r16 = false;
    L28:
        r12 = false;
    L18:
        if (r14 == true) goto L20;
        r9 = true;
    L15:
        r14 = false;
        goto L16
    L9:
        r7 = 0;
        goto L10
    L5:
        r5 = null;
        goto L6
    }
}
