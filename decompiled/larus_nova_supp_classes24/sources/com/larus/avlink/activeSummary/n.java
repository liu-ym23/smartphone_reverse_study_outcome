package com.larus.avlink.activeSummary;

import android.app.NotificationManager;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.os.Build;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.avlink.api.IDoraAVLinkService;
import com.larus.avlink.model.ProactiveSummaryScene;
import com.larus.avlink.n1;
import com.larus.common.apphost.AppHost;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.dora.impl.serviceimpl.SessionService;
import com.larus.platform.service.z2;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.a1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class n {
    public static final k<f> a = null;
    public static final Lazy b = null;
    public static final Lazy c = null;
    public static int d;
    public static final MutableSharedFlow<Unit> e = null;
    public static final a1 f = null;

    public n() {
    }

    static {
        a = new k();
        b = LazyKt.lazy(new l());
        c = LazyKt.lazy(new m());
        d = 70;
        MutableSharedFlow<Unit> r0 = SharedFlowKt.MutableSharedFlow$default(0, 10, BufferOverflow.DROP_OLDEST, 1, null);
        e = r0;
        f = kotlinx.coroutines.flow.e.a(r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void b() {
        ReentrantLock r0 = (ReentrantLock) c.getValue();
        r0.lock();
        k<f> r1 = a;     // Catch: Throwable -> L28
        List<k.c<f>> r2 = r1.b(System.currentTimeMillis());     // Catch: Throwable -> L28
        k.c r3 = (k.c) CollectionsKt.firstOrNull(r1.a);     // Catch: Throwable -> L28
        Intrinsics.checkNotNullParameter(r2, "expired");     // Catch: Throwable -> L28
        Iterator r4 = ((ArrayList) r2).iterator();     // Catch: Throwable -> L28
    L5:
        if (r4.hasNext() == false) goto L9;
        e((k.c) r4.next(), FailReason.TIMEOUT);     // Catch: Throwable -> L28
        goto L5
    L9:
        if (r3 != null) goto L13;
        n1.d("ProactiveSummaryRecords", "current proactive summary cache is empty");     // Catch: Throwable -> L28
        r0.unlock();
        return;
    L13:
        f r5 = (f) r3.b;     // Catch: Throwable -> L28
        String r6 = r5.a;     // Catch: Throwable -> L28
        Integer r7 = r5.b;     // Catch: Throwable -> L28
        if (r7 == null) goto L16;
        String r8 = r7.toString();     // Catch: Throwable -> L28
    L19:
        if (d(r6, r8, r5.c, r3.a, r5.f, false, r5.h, r5.d(), r5.a()) == false) goto L24;
        k<f> r9 = a;     // Catch: Throwable -> L28
        if (Intrinsics.areEqual(CollectionsKt.firstOrNull(r9.a), r3) == false) goto L23;
        ListProtector.remove(r9.a, 0);     // Catch: Throwable -> L28
    L23:
        n1.d("ProactiveSummaryRecords", "consume proactive summary cache head success, remain=" + CollectionsKt.toList(r9.a).size() + ", summaryId=" + r5.a + ", scene=" + r5.b + ", source=" + r3.a);     // Catch: Throwable -> L28
    L25:
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L28
        r0.unlock();
        return;
    L24:
        n1.d("ProactiveSummaryRecords", "consume proactive summary cache head failed, keep waiting. summaryId=" + r5.a + ", scene=" + r5.b + ", source=" + r3.a);     // Catch: Throwable -> L28
        goto L25
    L16:
        r8 = null;
    L28:
        th = move-exception;
        r0.unlock();
        throw th;
    }

    public static boolean c() {
        int r4 = 3;
        if (Build.VERSION.SDK_INT < 23) goto L21;
        Object r0 = AppHost.a.getApplication().getSystemService("notification");
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.app.NotificationManager");
        int r1 = ((NotificationManager) r0).getCurrentInterruptionFilter();
        if (r1 == 0) goto L15;
        if (r1 == 1) goto L14;
        if (r1 == 2) goto L13;
        if (r1 == 3) goto L12;
        int r2 = 4;
        if (r1 == 4) goto L16;
        r2 = 5;
    L16:
        n1.d("ProactiveSummaryRecords", "currentNotificationManagerStatus is " + r2);
        if (r2 == 2) goto L19;
        if (r2 == 3) goto L19;
        return false;
    L19:
        return true;
    L12:
        r2 = 3;
        goto L16
    L13:
        r2 = 2;
        goto L16
    L14:
        r2 = 1;
        goto L16
    L15:
        r2 = 0;
        goto L16
    L21:
        Object r3 = AppHost.a.getApplication().getSystemService("audio");
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.media.AudioManager");
        int r5 = ((AudioManager) r3).getRingerMode();
        if (r5 == 0) goto L28;
        if (r5 == 1) goto L27;
        if (r5 != 2) goto L29;
        r4 = 2;
    L29:
        n1.d("ProactiveSummaryRecords", "currentAudioManagerStatus is " + r4);
        if (r4 == 0) goto L32;
        if (r4 == 1) goto L32;
        return false;
    L32:
        return true;
    L27:
        r4 = 1;
        goto L29
    L28:
        r4 = 0;
        goto L29
    }

    public static void a(String r8, f r9) {
        Intrinsics.checkNotNullParameter(r8, "source");
        Intrinsics.checkNotNullParameter(r9, "response");
        ReentrantLock r0 = (ReentrantLock) c.getValue();
        r0.lock();
        k<f> r1 = a;     // Catch: Throwable -> L22
        long r4 = System.currentTimeMillis();     // Catch: Throwable -> L22
        b r2 = r9.d;     // Catch: Throwable -> L22
        if (r2 == null) goto L6;
        Integer r6 = Integer.valueOf(r2.a);     // Catch: Throwable -> L22
    L7:
        b r3 = r9.d;     // Catch: Throwable -> L22
        if (r3 == null) goto L10;
        Integer r7 = r3.b;     // Catch: Throwable -> L22
    L11:
        k.b<f> r5 = r1.a(r8, r9, r4, r6, r7);     // Catch: Throwable -> L22
        Iterator<T> r10 = r5.a.iterator();     // Catch: Throwable -> L22
    L13:
        if (r10.hasNext() == false) goto L15;
        e((k.c) r10.next(), FailReason.TIMEOUT);     // Catch: Throwable -> L22
        goto L13
    L15:
        Iterator<T> r11 = r5.b.iterator();     // Catch: Throwable -> L22
    L17:
        if (r11.hasNext() == false) goto L19;
        e((k.c) r11.next(), FailReason.OVERWRITTEN);     // Catch: Throwable -> L22
        goto L17
    L19:
        n1.d("ProactiveSummaryRecords", "save proactive summary to waiting queue, count=" + CollectionsKt.toList(a.a).size() + ", summaryId=" + r9.a + ", scene=" + r9.b + ", source=" + r8);     // Catch: Throwable -> L22
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L22
        r0.unlock();
        return;
    L10:
        r7 = null;
        goto L11
    L6:
        r6 = null;
    L22:
        th = move-exception;
        r0.unlock();
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void e(k.c r8, FailReason r9) {
        n1.d("ProactiveSummaryRecords", "Abandon this proactive summary due to " + r9.getValue() + " in cache. summaryId is " + ((f) r8.b).a + ", scene is " + ((f) r8.b).b);
        f r0 = (f) r8.b;
        String r1 = r0.a;
        Integer r2 = r0.b;
        if (r2 == null) goto L5;
        String r3 = r2.toString();
    L6:
        String r4 = r3;
        f r5 = (f) r8.b;
        h(r1, r4, r5.c, r8.a, ProactiveSummaryStartVuiStatus.FAIL, r9, r5.h);
        return;
    L5:
        r3 = null;
        goto L6
    }

    public static String j(String r1, String r2) {
        if (Intrinsics.areEqual(r1, String.valueOf(ProactiveSummaryScene.SystemNotify.getValue())) == true) goto L6;
        return null;
    L6:
        if (Intrinsics.areEqual(r2, "system_notify_v3") == false) goto L9;
        return "v3";
    L9:
        if (Intrinsics.areEqual(r2, "system_notify_v2") == false) goto L11;
        return "v2";
    L11:
        return "v1";
    }

    public static /* synthetic */ void g(String r9, ProactiveSummarySource r10, int r11) {
        if ((r11 & 1) == 0) goto L5;
        r9 = null;
    L5:
        String r0 = r9;
        if ((r11 & 8) == 0) goto L8;
        r10 = ProactiveSummarySource.UNKNOWN;
    L8:
        f(r0, null, null, r10, "fail", null, null, null, null);
    }

    public static void h(String r4, String r5, String r6, String r7, ProactiveSummaryStartVuiStatus r8, FailReason r9, String r10) {
        Intrinsics.checkNotNullParameter(r7, "source");
        Intrinsics.checkNotNullParameter(r8, "status");
        Intrinsics.checkNotNullParameter(r9, "reason");
        LinkedHashMap r1 = new LinkedHashMap();
        String r2 = "";
        if (r4 != null) goto L5;
        r4 = "";
    L5:
        r1.put("dora_proactive_id", r4);
        if (r5 == null) goto L9;
        String r11 = ia8.n.a(r5);
        if (r11 == null) goto L9;
    L10:
        r1.put("dora_proactive_type", r11);
        if (r6 == null) goto L14;
        r2 = r6;
    L14:
        r1.put("dora_proactive_sub_type", r2);
        r1.put("start_from", r7);
        r1.put("status", Integer.valueOf(r8.getCode()));
        if (r10 != null) goto L17;
        r10 = j(r5, r6);
    L17:
        if (r10 == null) goto L20;
        r1.put("system_notify_version", r10);
    L20:
        if (r8 != ProactiveSummaryStartVuiStatus.FAIL) goto L22;
        r1.put("fail_reason", r9.getValue());
    L22:
        IDoraService r12 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r12 == null) goto L26;
        r12.A0("dora_proactive_client_start_vui", r1);
        return;
    L26:
        return;
    L9:
        r11 = "";
        goto L10
    }

    public static /* synthetic */ void i(String r9, String r10, String r11, String r12, ProactiveSummaryStartVuiStatus r13, FailReason r14, String r15, int r16) {
        if ((r16 & 1) == 0) goto L5;
        String r2 = null;
    L7:
        if ((r16 & 2) == 0) goto L9;
        String r3 = null;
    L11:
        if ((r16 & 4) == 0) goto L13;
        String r4 = null;
    L15:
        if ((r16 & 8) == 0) goto L17;
        String r5 = "unknown";
    L19:
        if ((r16 & 32) == 0) goto L21;
        FailReason r7 = FailReason.UNKNOWN;
    L23:
        if ((r16 & 64) == 0) goto L25;
        String r8 = null;
    L26:
        h(r2, r3, r4, r5, r13, r7, r8);
        return;
    L25:
        r8 = r15;
        goto L26
    L21:
        r7 = r14;
        goto L23
    L17:
        r5 = r12;
        goto L19
    L13:
        r4 = r11;
        goto L15
    L9:
        r3 = r10;
        goto L11
    L5:
        r2 = r9;
        goto L7
    }

    public static boolean d(String r16, String r17, String r19, String r110, Boolean r20, boolean r21, String r22, String r23, Long r24) {
        Intrinsics.checkNotNullParameter(r110, "source");
        if (r22 != null) goto L5;
        String r7 = j(r17, r19);
    L6:
        AppHost.Companion r5 = AppHost.a;
        Object r6 = r5.getApplication().getSystemService("audio");
        if ((r6 instanceof AudioManager) == false) goto L9;
        AudioManager r8 = (AudioManager) r6;
    L11:
        if (r8 != null) goto L14;
        n1.d("ProactiveSummaryRecords", "isAudioOutputThroughPhoneSpeaker: audioManager is null");
        boolean r9 = false;
    L24:
        if (r9 == false) goto L27;
        t19.s.a.g(r5.getApplication(), 2131902180, false);
        n1.d("ProactiveSummaryRecords", "onProActiveSummaryGenerated: audio output is through phone speaker, skip. summaryId is " + r16);
        h(r16, r17, r19, r110, ProactiveSummaryStartVuiStatus.FAIL, FailReason.PHONE_SPEAKER, r7);
        return false;
    L27:
        Object r10 = r5.getApplication().getSystemService("audio");
        if ((r10 instanceof AudioManager) == false) goto L30;
        AudioManager r11 = (AudioManager) r10;
    L31:
        if (r11 != null) goto L33;
        n1.d("ProactiveSummaryRecords", "isCurrentAudioOutputDoraDevice: audioManager is null");
    L52:
        boolean r12 = false;
    L79:
        if (r12 == true) goto L81;
        t19.s.a.g(AppHost.a.getApplication(), 2131902180, false);
        n1.d("ProactiveSummaryRecords", "onProActiveSummaryGenerated: audio output is not Dora, skip. summaryId is " + r16);
        h(r16, r17, r19, r110, ProactiveSummaryStartVuiStatus.FAIL, FailReason.AUDIO_OUTPUT_NOT_DORA, r7);
    L118:
        return false;
    L81:
        IDoraService r13 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r13 == null) goto L88;
        DeviceService r14 = r13.device();
        if (r14 == null) goto L88;
        if (r14.f() != true) goto L88;
        boolean r15 = true;
    L89:
        if (r15 == false) goto L119;
        IDoraService r25 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r25 == null) goto L97;
        DeviceService r26 = r25.device();
        if (r26 == null) goto L97;
        Integer r27 = r26.q();
        if (r27 == null) goto L97;
        int r29 = r27.intValue();
    L98:
        IDoraService r30 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r30 == null) goto L105;
        DeviceService r31 = r30.device();
        if (r31 == null) goto L105;
        Integer r32 = r31.r();
        if (r32 == null) goto L105;
        int r33 = r32.intValue();
    L107:
        if ((r33 & 1) == 0) goto L109;
        boolean r34 = true;
    L110:
        if (r29 != (-1)) goto L112;
    L114:
        boolean r35 = false;
    L115:
        if (r35 == true) goto L119;
        if (r34 == false) goto L119;
        n1.d("ProactiveSummaryRecords", "onProActiveSummaryGenerated: curA2dp is false, skip. summaryId is " + r16);
        h(r16, r17, r19, r110, ProactiveSummaryStartVuiStatus.FAIL, FailReason.OTHER_DEVICE_A2DP_OCCUPIED, r7);
        goto L118
    L112:
        if ((r29 & 32) == 0) goto L114;
        r35 = true;
        goto L115
    L109:
        r34 = false;
    L105:
        r33 = 0;
    L97:
        r29 = -1;
    L119:
        com.larus.avlink.notification.a.a.getClass();
        com.larus.avlink.notification.a.b = r16;
        com.larus.avlink.notification.a.c = r17;
        com.larus.avlink.notification.a.d = r19;
        com.larus.avlink.notification.a.e = r23;
        com.larus.avlink.notification.a.f = r24;
        com.larus.avlink.notification.a.g = r20;
        com.larus.avlink.notification.a.h = r7;
        n1.d("ProactiveSummaryRecords", "start vui success summaryId is " + r16 + ", scene is " + r17 + ", subScene is " + r19 + ", source is " + r110 + ", skipWakeUp is " + r20 + ", systemNotifyVersion is " + r7 + ", trackingNotificationId is " + r23);
        String r3 = "";
        if (r16 != null) goto L122;
        String r36 = "";
    L123:
        if (r17 != null) goto L125;
        String r37 = "";
    L126:
        if (r19 == null) goto L129;
        r3 = r19;
    L129:
        i(r36, r37, r3, r110, ProactiveSummaryStartVuiStatus.SUCCESS, null, r7, 32);
        if (r21 == false) goto L133;
        n1.d("ProactiveSummaryRecords", "skipCreateNewSession, notify send trigger, summaryId is " + r16);
        e.tryEmit(Unit.INSTANCE);
    L147:
        return true;
    L133:
        if (Intrinsics.areEqual(r20, Boolean.TRUE) == true) goto L135;
        IDoraService r0 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r0 == null) goto L147;
        SessionService r1 = r0.d();
        if (r1 == null) goto L147;
        r1.l(18, true);
        goto L147
    L135:
        if (z2.a.isDoraSummaryQuicEnabled() == false) goto L139;
        IDoraAVLinkService r2 = (IDoraAVLinkService) ServiceManager.get().getService(IDoraAVLinkService.class);
        if (r2 == null) goto L147;
        w88.r.a.a(r2, 2, "dora_half_duplex", AppHost.a.getApplication().getString(2131902072));
        goto L147
    L139:
        IDoraAVLinkService r4 = (IDoraAVLinkService) ServiceManager.get().getService(IDoraAVLinkService.class);
        if (r4 == null) goto L147;
        w88.r.a.a(r4, 1, "dora_full_duplex", AppHost.a.getApplication().getString(2131902072));
        goto L147
    L125:
        r37 = r17;
        goto L126
    L122:
        r36 = r16;
    L88:
        r15 = false;
        goto L89
    L33:
        Set r38 = ja8.e.a(r11, r5.getApplication(), "ProactiveSummaryRecords");
        if (r38.isEmpty() == false) goto L36;
        n1.d("ProactiveSummaryRecords", "isCurrentAudioOutputDoraDevice: active A2DP device is empty");
        goto L52
    L36:
        IDoraService r39 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r39 == null) goto L48;
        DeviceService r40 = r39.device();
        if (r40 == null) goto L48;
        if (r40.J() == true) goto L44;
        Set r41 = SetsKt.emptySet();
    L50:
        if (r41.isEmpty() == false) goto L53;
        n1.d("ProactiveSummaryRecords", "isCurrentAudioOutputDoraDevice: connected Dora device is empty");
        goto L52
    L53:
        Set r42 = r38;
        if ((r42 instanceof Collection) == true) goto L56;
    L58:
        Iterator r43 = r42.iterator();
    L60:
        if (r43.hasNext() == false) goto L76;
        String r111 = (String) r43.next();
        Set r112 = r41;
        if ((r112 instanceof Collection) == true) goto L64;
    L66:
        Iterator r113 = r112.iterator();
    L68:
        if (r113.hasNext() == false) goto L72;
        if (StringsKt.equals((String) r113.next(), r111, true) == false) goto L68;
        boolean r114 = true;
    L73:
        if (r114 == false) goto L60;
        r12 = true;
    L77:
        if (r12 == true) goto L79;
        n1.d("ProactiveSummaryRecords", "isCurrentAudioOutputDoraDevice: active A2DP is not Dora. activeA2dpAddressSet=" + r38 + ", connectedDoraAddressSet=" + r41);
    L72:
        r114 = false;
        goto L73
    L64:
        if (r112.isEmpty() == false) goto L66;
    L76:
        r12 = false;
        goto L77
    L56:
        if (r42.isEmpty() == false) goto L58;
    L44:
        String r44 = r40.n();
        if (StringsKt.isBlank(r44) == false) goto L47;
        r41 = SetsKt.emptySet();
        goto L50
    L47:
        r41 = SetsKt.setOf(r44);
    L48:
        r41 = SetsKt.emptySet();
        goto L50
    L30:
        r11 = null;
        goto L31
    L14:
        if (Build.VERSION.SDK_INT < 31) goto L22;
        AudioDeviceInfo r115 = r8.getCommunicationDevice();
        if (r115 == null) goto L22;
        if (r115.getType() != 2) goto L20;
        r9 = true;
    L21:
        n1.d("ProactiveSummaryRecords", "isAudioOutputThroughPhoneSpeaker: communicationDeviceType=" + r115.getType() + ", result=" + r9);
        goto L24
    L20:
        r9 = false;
    L22:
        boolean r116 = r8.isSpeakerphoneOn();
        n1.d("ProactiveSummaryRecords", "isAudioOutputThroughPhoneSpeaker: mode=" + r8.getMode() + ", speakerphoneOn=" + r116);
        r9 = r116;
        goto L24
    L9:
        r8 = null;
        goto L11
    L5:
        r7 = r22;
        goto L6
    }

    public static void f(String r3, String r4, String r5, ProactiveSummarySource r6, String r7, String r8, String r9, Long r10, Long r11) {
        Intrinsics.checkNotNullParameter(r6, "source");
        Intrinsics.checkNotNullParameter(r7, "requestStatus");
        LinkedHashMap r0 = new LinkedHashMap();
        String r1 = "";
        if (r3 != null) goto L5;
        r3 = "";
    L5:
        r0.put("dora_proactive_id", r3);
        if (r4 == null) goto L9;
        String r12 = ia8.n.a(r4);
        if (r12 == null) goto L9;
    L10:
        r0.put("dora_proactive_type", r12);
        if (r5 == null) goto L14;
        r1 = r5;
    L14:
        r0.put("dora_proactive_sub_type", r1);
        r0.put("receive_from", r6.getValue());
        r0.put("request_status", r7);
        if (r8 != null) goto L17;
        r8 = j(r4, r5);
    L17:
        if (r8 == null) goto L19;
        r0.put("system_notify_version", r8);
    L19:
        boolean r13 = true;
        if (r9 != null) goto L22;
    L25:
        boolean r14 = true;
    L26:
        if (r14 == true) goto L41;
        r0.put("notification_id", r9);
        long r15 = System.currentTimeMillis();
        r0.put("client_summary_receive_timestamp", Long.valueOf(r15));
        com.larus.avlink.notification.a.a.getClass();
        if (r9 != null) goto L30;
    L33:
        if (r13 == false) goto L35;
        Long r16 = null;
    L36:
        if (r16 == null) goto L39;
        r11 = r16;
    L39:
        if (r11 == null) goto L41;
        long r17 = r11.longValue();
        r0.put("client_notification_receive_timestamp", Long.valueOf(r17));
        r0.put("summary_e2e_latency_ms", Long.valueOf(r15 - r17));
        goto L41
    L35:
        r16 = (Long) com.larus.avlink.notification.a.j.remove(r9);
        goto L36
    L30:
        if (StringsKt.isBlank(r9) == true) goto L33;
        r13 = false;
    L41:
        if (r10 == null) goto L43;
        r0.put("notification_timestamp", Long.valueOf(r10.longValue()));
    L43:
        IDoraService r19 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r19 == null) goto L47;
        r19.A0("dora_proactive_client_receive", r0);
        return;
    L47:
        return;
    L22:
        if (StringsKt.isBlank(r9) == true) goto L25;
        r14 = false;
    L9:
        r12 = "";
        goto L10
    }
}
