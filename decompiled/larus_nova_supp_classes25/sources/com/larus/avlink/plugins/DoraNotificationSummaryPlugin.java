package com.larus.avlink.plugins;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import com.larus.avlink.activeSummary.SoundPlayManager;
import com.larus.avlink.model.ProactiveSummaryScene;
import com.larus.common.apphost.AppHost;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.dora.impl.serviceimpl.SessionService;
import com.larus.im.service.audio.cmd.TriggerMode;
import com.larus.im.service.audio.event.FlowLLMAiProactiveEvent;
import com.larus.utils.l;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class DoraNotificationSummaryPlugin extends com.larus.audio.call.arch.a<n4> implements r2 {
    public static final a m = null;
    public static boolean n;
    public boolean f;
    public boolean g;
    public boolean h;
    public Job i;
    public final Lazy j;
    public final String k;
    public Map<String, String> l;

    public static final class a {
        public a() {
        }
    }

    public static final class b extends com.larus.im.service.audio.z0 {
        public final String a;
        public final /* synthetic */ DoraNotificationSummaryPlugin b;

        public final String g() {
            return this.a;
        }

        public b(DoraNotificationSummaryPlugin r1) {
            this.b = r1;
            this.a = r1.k;
        }

        public final void n(com.larus.im.service.audio.z0.a r19) {
            Intrinsics.checkNotNullParameter(r19, "event");
            if ((r19 instanceof pf9.o) == false) goto L5;
            com.larus.avlink.n1.d(this.b.k, "event is FlowLLMCallStartedEvent");
            DoraNotificationSummaryPlugin.j3(this.b);
            return;
        L5:
            boolean r4 = true;
            if ((r19 instanceof pf9.q) == false) goto L137;
            com.larus.avlink.n1.d(this.b.k, "event is FlowLLMCommandReplyEvent");
            DoraNotificationSummaryPlugin r2 = this.b;
            r2.getClass();
            List r0 = ((pf9.q) r19).a;
            ArrayList r6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
            Iterator r1 = r0.iterator();
        L9:
            if (r1.hasNext() == false) goto L213;
            pf9.p r7 = (pf9.p) r1.next();
            Long r8 = r7.a;
            if (r8 == null) goto L133;
            int r9 = (int) r8.longValue();
            if (r9 != 15) goto L15;
            com.larus.avlink.n1.d(r2.k, "CommandStatus is DORA_NOTIFICATION_SUMMARY_NEED_ACK");
            Map r5 = r7.b;
            if (r5 == null) goto L88;
            String r10 = (String) r5.get("ack_remind_type");
        L89:
            Map r11 = r7.b;
            if (r11 == null) goto L92;
            String r12 = (String) r11.get("need_conform_notification");
        L93:
            Map r13 = r7.b;
            if (r13 == null) goto L96;
            String r14 = (String) r13.get("summary_id");
        L97:
            Map r15 = r7.b;
            if (r15 == null) goto L100;
            String r16 = (String) r15.get("summary_scene");
        L101:
            Map r17 = r7.b;
            if (r17 == null) goto L104;
            String r18 = (String) r17.get("active_push_round");
        L105:
            com.larus.avlink.n1.d(r2.k, "[NotificationTracer] playNotifyMusicAndUpdateUIContext, type=" + r10 + ", needConfirm=" + r12 + ", msgId=" + r14);
            q2 r3 = new q2(r2);
            String r20 = ((n4) r2.getContext()).params().o.d;
            if (StringsKt.contains$default(r20, "female", false, 2, null) == false) goto L109;
        L111:
            boolean r21 = true;
        L112:
            com.larus.avlink.n1.d(r2.k, "styleName is " + r20 + ", isFemaleTimbre is " + r21);
            if (Intrinsics.areEqual(r10, "1") == false) goto L116;
            com.larus.audio.call.arch.b.a(r2.getContext()).e0().pause("summary start");
            SoundPlayManager.e((SoundPlayManager) r2.j.getValue(), AppHost.a.getApplication(), "summary_noti_music.mp3", false, r3);
            ((n4) r2.getContext()).k().b0(((n4) r2.getContext()).params());
        L122:
            LinkedHashMap r22 = new LinkedHashMap();
            if (r14 == null) goto L125;
            r22.put("summary_id", r14);
        L125:
            if (r16 == null) goto L127;
            r22.put("summary_scene", r16);
        L127:
            if (r12 == null) goto L129;
            r22.put("need_conform_notification", r12);
        L129:
            if (r18 == null) goto L131;
            r22.put("active_push_round", r18);
        L131:
            r2.l = r22;
            d3a.a.a(r2.getContext()).r1(r2.k + "15", r22);
        L132:
            r7 = r7;
        L134:
            r6.add(r7);
            r6 = r6;
            r4 = true;
            r1 = r1;
            goto L9
        L116:
            if (Intrinsics.areEqual(r10, "3") == false) goto L122;
            if (r21 == false) goto L119;
            String r23 = "summary_notify_voice_female.mp3";
        L120:
            com.larus.audio.call.arch.b.a(r2.getContext()).e0().pause("summary start");
            SoundPlayManager.e((SoundPlayManager) r2.j.getValue(), AppHost.a.getApplication(), r23, false, r3);
            ((n4) r2.getContext()).k().b0(((n4) r2.getContext()).params());
            goto L122
        L119:
            r23 = "summary_notify_voice_male.mp3";
            goto L120
        L109:
            if (StringsKt.contains$default(r20, "male", false, 2, null) == false) goto L111;
            r21 = false;
            goto L112
        L104:
            r18 = null;
            goto L105
        L100:
            r16 = null;
            goto L101
        L96:
            r14 = null;
            goto L97
        L92:
            r12 = null;
            goto L93
        L88:
            r10 = null;
            goto L89
        L15:
            if (r9 != 20) goto L17;
            com.larus.avlink.n1.d(r2.k, "CommandStatus is LLM_FIRST_PACK");
            Map r24 = r7.b;
            if (r24 == null) goto L132;
            String r25 = (String) r24.get("active_push_round");
            if (r25 == null) goto L132;
            com.larus.avlink.n1.d(r2.k, "[NotificationTracer] updatePayloadByNotify, pushRound=".concat(r25));
            Map r26 = r2.l;
            if (r26 != null) goto L83;
            r26 = new LinkedHashMap();
        L83:
            r26.put("active_push_round", r25);
            d3a.a.a(r2.getContext()).r1(r2.k + "20", r26);
            goto L132
        L17:
            if (r9 != 35) goto L19;
            com.larus.avlink.n1.d(r2.k, "CommandStatus is DORA_NOTIFICATION_SUMMARY_NEED_REPLY");
            Map r27 = r7.b;
            if (r27 == null) goto L59;
            String r28 = (String) r27.get("proactive_id");
        L60:
            Map r110 = r7.b;
            if (r110 == null) goto L63;
            String r111 = (String) r110.get("proactive_scene");
        L64:
            Map r112 = r7.b;
            if (r112 == null) goto L67;
            String r113 = (String) r112.get("active_push_round");
        L68:
            com.larus.avlink.n1.d(r2.k, "[NotificationTracer] updatePayloadByNotify, proactiveId=" + r28 + ", proactiveScene=" + r111 + ", pushRound=" + r113);
            LinkedHashMap r29 = new LinkedHashMap();
            if (r28 == null) goto L71;
            r29.put("proactive_id", r28);
        L71:
            if (r111 == null) goto L73;
            r29.put("proactive_scene", r111);
        L73:
            if (r113 == null) goto L75;
            r29.put("active_push_round", r113);
        L75:
            r2.l = r29;
            d3a.a.a(r2.getContext()).r1(r2.k + "35", r29);
            goto L132
        L67:
            r113 = null;
            goto L68
        L63:
            r111 = null;
            goto L64
        L59:
            r28 = null;
            goto L60
        L19:
            if (r9 == 55) goto L55;
            a r30 = DoraNotificationSummaryPlugin.m;
            switch(r9) {
                case 50: goto L29;
                case 51: goto L24;
                case 52: goto L23;
                default: goto L132;
            };
        L23:
            l.d(r30, "next_dora_call_inherit_data");
            goto L132
        L24:
            Map r31 = r7.b;
            if (r31 == null) goto L27;
            String r32 = (String) r31.get("next_dora_call_inherit_data");
        L28:
            l.c(r30, "next_dora_call_inherit_data", r32);
            goto L132
        L27:
            r32 = null;
            goto L28
        L29:
            com.larus.avlink.n1.d(r2.k, "CommandStatus is DORA_NOTIFICATION_DEEP_RESEARCH, origin commandParams is " + r7.b);
            Map r33 = r7.b;
            if (r33 != null) goto L32;
        L35:
            boolean r34 = true;
        L37:
            if ((r34 ^ r4) == true) goto L40;
            r33 = null;
        L40:
            if (r33 == null) goto L132;
            LinkedHashMap r35 = new LinkedHashMap();
            Iterator r36 = r33.entrySet().iterator();
        L43:
            if (r36.hasNext() == false) goto L50;
            Map.Entry r114 = (Map.Entry) r36.next();
            if (r114.getValue() == null) goto L47;
            boolean r115 = true;
        L48:
            if (r115 == false) goto L43;
            r35.put(r114.getKey(), r114.getValue());
            goto L43
        L47:
            r115 = false;
            goto L48
        L50:
            LinkedHashMap r37 = new LinkedHashMap(MapsKt.mapCapacity(r35.size()));
            Iterator r38 = r35.entrySet().iterator();
        L52:
            if (r38.hasNext() == false) goto L54;
            Map.Entry r116 = (Map.Entry) r38.next();
            Object r117 = r116.getKey();
            Object r118 = r116.getValue();
            Intrinsics.checkNotNull(r118, "null cannot be cast to non-null type kotlin.String");
            r37.put(r117, (String) r118);
            goto L52
        L54:
            com.larus.avlink.n1.d(r2.k, "[NotificationTracer] updatePayloadByNotify, deepResearchAppletPayload is " + r37);
            d3a.a.a(r2.getContext()).r1(r2.k + "50", r37);
            goto L132
        L32:
            if (r33.isEmpty() == true) goto L35;
            r34 = false;
            goto L37
        L55:
            r2.h = r4;
            goto L132
        L133:
            r1 = r1;
            goto L134
        L213:
            return;
        L137:
            if ((r19 instanceof pf9.z) == false) goto L140;
            this.b.g = true;
            return;
        L140:
            if ((r19 instanceof FlowLLMAiProactiveEvent) == false) goto L215;
            String r39 = this.b.k;
            StringBuilder r40 = new StringBuilder("event is FlowLLMAiProactiveEvent, eventBody=");
            FlowLLMAiProactiveEvent r41 = (FlowLLMAiProactiveEvent) r19;
            r40.append(r41.getEventBody());
            com.larus.avlink.n1.d(r39, r40.toString());
            DoraNotificationSummaryPlugin r42 = this.b;
            String r43 = r41.getEventBody();
            com.larus.avlink.n1.d(r42.k, "receive AI_PROACTIVE_NOTIFY, extra=" + r43);
            Result.Companion r44 = Result.Companion;     // Catch: Throwable -> L154
            if (r43 != null) goto L145;
        L148:
            boolean r45 = true;
        L149:
            if (r45 == false) goto L151;
            String r46 = null;
        L152:
            Object r47 = Result.constructor-impl(r46);     // Catch: Throwable -> L154
        L156:
            Throwable r48 = Result.exceptionOrNull-impl(r47);
            if (r48 == null) goto L160;
            com.larus.avlink.n1.b(r42.k, "parse AI_PROACTIVE_NOTIFY extra err: " + r48.getMessage());
            r47 = null;
        L160:
            String r49 = (String) r47;
            com.larus.avlink.n1.d(r42.k, "AI_PROACTIVE_NOTIFY parsed content=" + r49);
            com.larus.avlink.activeSummary.j.a r50 = com.larus.avlink.activeSummary.j.c;
            com.larus.avlink.activeSummary.j r51 = com.larus.avlink.activeSummary.j.d;
            if (r51 != null) goto L172;
            monitor-enter(r50);
            r51 = com.larus.avlink.activeSummary.j.d;     // Catch: Throwable -> L168
            if (r51 != null) goto L166;
            r51 = new com.larus.avlink.activeSummary.j();     // Catch: Throwable -> L168
            com.larus.avlink.activeSummary.j.d = r51;     // Catch: Throwable -> L168
        L166:
            monitor-exit(r50);
        L168:
            th = move-exception;
            throw th;
        L172:
            if (r49 != null) goto L174;
        L195:
            com.larus.avlink.n1.d("ProactiveSummaryNotificationManager", "showSummaryNotification skip: empty content");
            return;
        L174:
            if ((!StringsKt.isBlank(r49)) == true) goto L177;
            r49 = null;
        L177:
            if (r49 == null) goto L195;
            AppHost.Companion r52 = AppHost.a;
            if (NotificationManagerCompat.from(r52.getApplication()).areNotificationsEnabled() == true) goto L182;
            com.larus.avlink.n1.d("ProactiveSummaryNotificationManager", "showSummaryNotification skip: notification disabled");
            return;
        L182:
            int r53 = r51.b.incrementAndGet();
            String r54 = r52.getAppStringName();
            Application r55 = r52.getApplication();
            NotificationManagerCompat r56 = NotificationManagerCompat.from(r55);
            if (Build.VERSION.SDK_INT < 26) goto L201;
            NotificationChannel r57 = new NotificationChannel("proactive_summary_notification", "主动提醒通知", 4);
            Object r119 = r55.getSystemService("notification");
            if ((r119 instanceof NotificationManager) == false) goto L187;
            NotificationManager r120 = (NotificationManager) r119;
        L188:
            if (r120 == null) goto L201;
            r120.createNotificationChannel(r57);
            goto L201
        L187:
            r120 = null;
        L201:
            r56.notify(r53, new NotificationCompat.Builder(r55, "proactive_summary_notification").setSmallIcon(r52.b()).setContentTitle(r54).setContentText(r49).setAutoCancel(true).setPriority(1).setDefaults(-1).build());     // Catch: Exception -> L193
            r51.a.postDelayed(new com.larus.avlink.activeSummary.i(r51, r53), 86400000);     // Catch: Exception -> L193
            return;
        L193:
            e = move-exception;
            com.larus.avlink.n1.b("ProactiveSummaryNotificationManager", "showNotification failed: " + e);
            return;
        L151:
            r46 = new JSONObject(r43).optString("ai_proactive_notify_content");     // Catch: Throwable -> L154
            goto L152
        L145:
            if (r43.length() == 0) goto L148;
            r45 = false;
        L154:
            th = move-exception;
            Result.Companion r58 = Result.Companion;
            r47 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L156
        }
    }

    public static final class c implements z4 {
        public final /* synthetic */ DoraNotificationSummaryPlugin a;

        @Override // com.larus.avlink.plugins.z4
        public final boolean needCancel() {
            DoraNotificationSummaryPlugin r0 = this.a;
            if (r0.g == false) goto L5;
        L7:
            boolean r1 = false;
        L8:
            if (r1 == false) goto L13;
            r0.h = false;
            JSONObject r2 = new JSONObject();
            r2.put("notice_key", "dora_greet_first_no_reply_close_prompt");
            ((n4) this.a.getContext()).params();
            id9.d r3 = ((n4) this.a.getContext()).j();
            if (r3 == null) goto L12;
            r3.p(TriggerMode.CLIENT_SUMMON_NOTICE, r2.toString());
        L12:
            com.larus.avlink.n1.d(this.a.k, "Timer stop intercepted: hasAsr=" + this.a.g + ", needGreetNoticeTrigger=" + this.a.h);
        L13:
            return r1;
        L5:
            if (r0.h == false) goto L7;
            r1 = true;
            goto L8
        }

        public c(DoraNotificationSummaryPlugin r1) {
            this.a = r1;
        }
    }

    static {
        m = new a();
    }

    @Override // com.larus.avlink.plugins.r2
    public final void J0() {
        this.f = false;
    }

    public final com.larus.im.service.audio.z0 S2() {
        return new b(this);
    }

    public final void V2() {
        this.i = kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(com.larus.avlink.activeSummary.n.f, new DoraNotificationSummaryPlugin$onAfterStart$1(this, null)), CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()));
        x3 r0 = (x3) getContext().c(Reflection.getOrCreateKotlinClass(x3.class), null);
        if (r0 == null) goto L6;
        r0.q1(new c(this));
        return;
    }

    public final void g3() {
        super.g3();
        Job r0 = this.i;
        boolean r1 = true;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.i = null;
        com.larus.avlink.n1.d("ProactiveSummaryRecords", "consume proactive summary cache in dora call is stop");
        n = false;
        com.larus.avlink.notification.a.a.getClass();
        com.larus.avlink.notification.a.h = null;
        IDoraService r2 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r2 == null) goto L12;
        DeviceService r3 = r2.device();
        if (r3 == null) goto L12;
        if (r3.n0("conversation") != true) goto L12;
    L13:
        if (r1 == false) goto L19;
        IDoraService r4 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r4 == null) goto L19;
        SessionService r5 = r4.d();
        if (r5 == null) goto L19;
        r5.p(0);
    L19:
        com.larus.avlink.activeSummary.k r6 = com.larus.avlink.activeSummary.n.a;
        com.larus.avlink.activeSummary.n.b();
        return;
    L12:
        r1 = false;
        goto L13
    }

    public final String T2() {
        return this.k;
    }

    @Override // com.larus.avlink.plugins.r2
    public final boolean j0() {
        return this.f;
    }

    public DoraNotificationSummaryPlugin(n4 r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.j = LazyKt.lazy(new p2());
        this.k = "DoraNotificationSummaryPlugin";
    }

    public static final void j3(DoraNotificationSummaryPlugin r7) {
        r7.getClass();
        com.larus.avlink.notification.a.a.getClass();
        String r0 = com.larus.avlink.notification.a.b;
        if (r0 == null) goto L38;
        boolean r1 = true;
        r7.f = true;
        if (Intrinsics.areEqual(com.larus.avlink.notification.a.c, String.valueOf(ProactiveSummaryScene.SystemNotify.getValue())) == false) goto L21;
        n = true;
        IDoraService r2 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r2 == null) goto L14;
        DeviceService r3 = r2.device();
        if (r3 == null) goto L14;
        if (r3.n0("conversation") != true) goto L14;
        boolean r4 = true;
    L15:
        if (r4 == false) goto L21;
        IDoraService r5 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r5 == null) goto L21;
        SessionService r6 = r5.d();
        if (r6 == null) goto L21;
        r6.m(0);
    L14:
        r4 = false;
    L21:
        JSONObject r8 = new JSONObject();
        r8.put("summary_id", r0);
        com.larus.avlink.n1.d(r7.k, "[NotificationTracer] sendNotificationSummaryTrigger: " + r8);
        ((n4) r7.getContext()).params();
        id9.d r9 = ((n4) r7.getContext()).j();
        if (r9 == null) goto L24;
        r9.p(TriggerMode.ANCS_SUMMARY, r8.toString());
    L24:
        com.larus.avlink.n1.d(r7.k, "[NotificationTracer] summary session started with summaryId=".concat(r0));
        IDoraService r10 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r10 == null) goto L31;
        DeviceService r11 = r10.device();
        if (r11 == null) goto L31;
        if (r11.M() != true) goto L31;
    L32:
        if (r1 == false) goto L36;
        com.larus.avlink.activeSummary.k r12 = com.larus.avlink.activeSummary.n.a;
        Intrinsics.checkNotNullParameter(r0, "summaryId");
        LinkedHashMap r13 = new LinkedHashMap();
        r13.put("dora_proactive_id", r0);
        IDoraService r14 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r14 == null) goto L36;
        r14.A0("dora_voice_reminder_start", r13);
    L36:
        com.larus.avlink.notification.a.b = null;
        com.larus.avlink.notification.a.c = null;
        com.larus.avlink.notification.a.d = null;
        com.larus.avlink.notification.a.e = null;
        com.larus.avlink.notification.a.f = null;
        com.larus.avlink.notification.a.g = null;
        com.larus.avlink.notification.a.h = null;
        return;
    L31:
        r1 = false;
        goto L32
    }
}
