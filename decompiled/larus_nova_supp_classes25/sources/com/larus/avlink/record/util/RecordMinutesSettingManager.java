package com.larus.avlink.record.util;

import com.bytedance.common.utility.NetworkUtils;
import com.larus.audio.AudioServiceDelegate;
import com.larus.avlink.model.DoraCallStateCode;
import com.larus.avlink.n1;
import com.larus.avlink.record.page.Action;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.model.repo.u1;
import com.larus.bmhome.chat.model.repo.u1$a;
import com.larus.common.apphost.AppHost;
import com.larus.dora.api.DoraConfig;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.dora.impl.serviceimpl.SessionService;
import com.larus.im.bean.message.Message;
import com.larus.network.NetQualityManager;
import com.larus.utils.j0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.sync.MutexImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class RecordMinutesSettingManager {
    public static final RecordMinutesSettingManager a = null;
    public static q b;
    public static Job c;
    public static final CoroutineScope d = null;
    public static final MutexImpl e = null;
    public static final CopyOnWriteArrayList<Function1<Integer, Unit>> f = null;
    public static final CopyOnWriteArrayList<Function1<Action, Unit>> g = null;
    public static final CopyOnWriteArrayList<Function1<Boolean, Unit>> h = null;
    public static String i;
    public static long j;
    public static final Map<String, String> k = null;

    public static final class a extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
        public a(CoroutineExceptionHandler.Key r1) {
            super(r1);
        }

        public final void handleException(CoroutineContext r2, Throwable r3) {
            n1.b("RecordMinutesSettingManager", "GRecord Coroutine Exception: " + r3.getMessage());
        }
    }

    public RecordMinutesSettingManager() {
    }

    static {
        a = new RecordMinutesSettingManager();
        a r1 = new a(CoroutineExceptionHandler.Key);
        d = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain()).plus(r1));
        e = kotlinx.coroutines.sync.b.a();
        f = new CopyOnWriteArrayList();
        g = new CopyOnWriteArrayList();
        h = new CopyOnWriteArrayList();
        k = new LinkedHashMap();
    }

    public static String c() {
        wc9.e r0 = (wc9.e) AuthModelDelegate.b.y().getValue();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a;
    }

    public static void e(q r6) {
        Job r0 = c;
        DeviceService r1 = null;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        c = null;
        b = null;
        k.put(r6.a, r6.c);
        final String r2 = r6.a;
        final String r3 = r6.c;
        final int r4 = r6.d;
        final Ref.ObjectRef r5 = new Ref.ObjectRef();
        p68.c r7 = new RecordMinutesSettingManager$getListener$1(r2, r4, r3, r5);
        r5.element = r7;
        AudioServiceDelegate.a.P().j(r7);
        n1.d("RecordMinutesSettingManager", "GRecord addRecordingStatusListener for msg.messageId is " + r6.a + " listener is " + r7);
        IDoraService r8 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r8 == null) goto L8;
        r1 = r8.device();
    L8:
        if (r1 == null) goto L10;
        r1.z();
    L10:
        if (r1 == null) goto L12;
        r1.M();
    L12:
        ia8.e.a().i(r6.a, DoraConfig.g());
    }

    public static void f(int r8) {
        n1.d("RecordMinutesSettingManager", "GRecord start timeout count down in " + r8);
        Job r9 = c;
        if (r9 == null) goto L5;
        Job.DefaultImpls.cancel$default(r9, null, 1, null);
    L5:
        c = BuildersKt.launch$default(d, null, null, new RecordMinutesSettingManager$startTimeoutCountDown$1(null), 3, null);
    }

    public static void g(String r9) {
        Intrinsics.checkNotNullParameter(r9, "endSource");
        if (ia8.e.a().isRecording() == false) goto L17;
        String r0 = i;
        if (r0 != null) goto L7;
        r0 = "";
    L7:
        LinkedHashMap r2 = new LinkedHashMap();
        r2.put("end_type", r9);
        String r3 = k.remove(r0);
        if (r3 == null) goto L10;
        r2.put("start_type", r3);
    L10:
        r2.put("message_id", r0);
        if (j != 0) goto L13;
        n1.d("RecordMinutesSettingManager", "GRecord Unexpected circumstances, ending before it officially begins, endType is " + r9 + ", messageId is " + r0);
        r2.put("duration", 0);
    L14:
        IDoraService r1 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r1 == null) goto L18;
        r1.A0("dora_recording_end", r2);
    L18:
        b = null;
        i = null;
        ia8.e.a().a(r9);
        return;
    L13:
        r2.put("duration", Long.valueOf(System.currentTimeMillis() - j));
        goto L14
    L17:
        n1.e("RecordMinutesSettingManager", "GRecord stopRecord but not recording, currentPendingSession is " + b);
        goto L18
    }

    public static final void a(RecordMinutesSettingManager r10, Message r11) {
        r10.getClass();
        q r12 = b;
        String r0 = "";
        if (r12 != null) goto L5;
    L13:
        if (r12 == null) goto L15;
        n1.b("RecordMinutesSettingManager", "GRecord Overwriting old session: " + r12 + " with new Wake: " + r11.getMessageId());
    L15:
        n1.d("RecordMinutesSettingManager", "GRecord receive " + r11.getMessageId() + ", waiting wakeup!!!");
        Map r13 = r11.getExt();
        if (r13 == null) goto L18;
        String r14 = (String) r13.get("record_scene");
    L20:
        if (r14 == null) goto L67;
        int r4 = r14.hashCode();
        if (r4 == 1367036197) goto L55;
        if (r4 == 1497145978) goto L42;
        if (r4 != 1647489190) goto L67;
        if (r14.equals("vui_record") == false) goto L67;
        String r15 = r11.getMessageId();
        if (r15 != null) goto L34;
        String r5 = "";
    L35:
        b = new q(r5, 0, "voice_control", 0, 26);
        n1.d("RecordMinutesSettingManager", "GRecord startVUI in vui_record");
        IDoraService r16 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r16 == null) goto L40;
        SessionService r17 = r16.d();
        if (r17 == null) goto L40;
        r17.o(5, 14);
    L40:
        f(14);
        return;
    L34:
        r5 = r15;
        goto L35
    L42:
        if (r14.equals("action_record") == false) goto L67;
        String r18 = r11.getMessageId();
        if (r18 != null) goto L47;
        String r6 = "";
    L48:
        b = new q(r6, 0, "click_action_bar", 0, 26);
        n1.d("RecordMinutesSettingManager", "GRecord startVUI in action_record");
        IDoraService r19 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r19 == null) goto L53;
        SessionService r110 = r19.d();
        if (r110 == null) goto L53;
        r110.o(5, 13);
    L53:
        f(13);
        return;
    L47:
        r6 = r18;
        goto L48
    L55:
        if (r14.equals("common_record") == false) goto L67;
        String r111 = r11.getMessageId();
        if (r111 != null) goto L60;
        String r7 = "";
    L61:
        b = new q(r7, 0, "im_message", 0, 26);
        n1.d("RecordMinutesSettingManager", "GRecord startVUI in common_record");
        IDoraService r112 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r112 == null) goto L66;
        SessionService r113 = r112.d();
        if (r113 == null) goto L66;
        r113.o(5, 13);
    L66:
        f(13);
        return;
    L60:
        r7 = r111;
    L67:
        String r114 = r11.getMessageId();
        if (r114 != null) goto L70;
        String r8 = "";
    L71:
        b = new q(r8, 0, "unknown", 0, 26);
        n1.e("RecordMinutesSettingManager", "GRecord startVUI in unknown");
        IDoraService r115 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r115 == null) goto L76;
        SessionService r116 = r115.d();
        if (r116 == null) goto L76;
        r116.o(5, 13);
    L76:
        f(13);
        return;
    L70:
        r8 = r114;
        goto L71
    L18:
        r14 = null;
        goto L20
    L5:
        if (r12.b == 0) goto L13;
        if (Intrinsics.areEqual(r12.a, "") == false) goto L13;
        n1.d("RecordMinutesSettingManager", "GRecord Match Success, " + r12.b + " wait " + r11.getMessageId());
        String r117 = r11.getMessageId();
        if (r117 == null) goto L12;
        r0 = r117;
    L12:
        e(q.a(r12, r0, 0, 0, 30));
    }

    public static void d(String r18, String r19) {
        Intrinsics.checkNotNullParameter(r18, "scene");
        Intrinsics.checkNotNullParameter(r19, "sendFuncChannel");
        LinkedHashMap r6 = new LinkedHashMap();
        r6.put("create_time_ms", String.valueOf(System.currentTimeMillis()));
        if (ia8.e.a().isRecording() == false) goto L5;
        Object r1 = "2";
    L6:
        r6.put("record_status", r1);
        r6.put("wiki", "2");
        r6.put("search_engine_type", "4");
        r6.put("media_search_type", "1");
        r6.put("answer_with_suggest", "1");
        r6.put("system_language", "zh");
        String r4 = c();
        if (r4 == null) goto L9;
        n1.d("RecordMinutesSettingManager", "GRecord sendTextNew in DoraG record, scene is " + r18);
        u1 r2 = zh8.a.a.getSender();
        int r0 = j0.a;
        u1$a.f(r2, j0.d(2131903323), r4, "doraGRecordMinutes", r6, null, null, UUID.randomUUID().toString(), false, null, r19, null, null, null, false, 27496);
        return;
    L9:
        n1.d("RecordMinutesSettingManager", "GRecord sendTextNew in DoraG record failed due to cvsId is null");
        IDoraService r3 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r3 == null) goto L16;
        SessionService r5 = r3.d();
        if (r5 == null) goto L17;
        r5.y(3, DoraCallStateCode.DOUBAO_STOP_RECORD_BY_EXCEPTION, false);
        return;
    L17:
        return;
    L16:
        return;
    L5:
        r1 = "1";
        goto L6
    }

    public static final void b(RecordMinutesSettingManager r8, int r9, int r10, int r11, int r12, String r13) {
        r8.getClass();
        n1.d("RecordMinutesSettingManager", "GRecord handleRecordWakeUp in DoraG record state:" + r9 + ", mode:" + r10 + ", query:" + r11 + ", vuiId:" + r12 + ", kw:" + r13);
        int r14 = 0;
        if (ia8.e.a().isRecording() == false) goto L11;
        if (r10 != 17) goto L6;
        n1.d("RecordMinutesSettingManager", "GRecord call is coming stop current recording");
        g("hfp_calling");
        goto L11
    L6:
        n1.d("RecordMinutesSettingManager", "GRecord ignore wakeup in recording, mode is " + r10);
        IDoraService r15 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r15 == null) goto L39;
        SessionService r16 = r15.d();
        if (r16 == null) goto L40;
        r16.y(4, DoraCallStateCode.DOUBAO_STOP_RECORD_BY_EXCEPTION, false);
        return;
    L40:
        return;
    L39:
        return;
    L11:
        q r17 = b;
        boolean r1 = true;
        if (r17 != null) goto L14;
    L21:
        if (r17 == null) goto L23;
        n1.b("RecordMinutesSettingManager", "GRecord Overwriting old session: " + r17 + " with new Wake: " + r12);
    L23:
        n1.d("RecordMinutesSettingManager", "GRecord receive " + TuplesKt.to(Integer.valueOf(r12), Integer.valueOf(r10)) + ", waiting message!!!");
        if (NetworkUtils.isNetworkAvailable(AppHost.a.getApplication()) == true) goto L26;
    L25:
        r1 = false;
    L28:
        if (r1 == false) goto L32;
        if (r10 != 17) goto L31;
        b = new q(null, r12, "auto_enter_on_call_start", 1, 17);
        d(String.valueOf(r10), String.valueOf(r10));
        f(r10);
        return;
    L31:
        b = new q(null, r12, "gesture_control", 0, 17);
        d(String.valueOf(r10), String.valueOf(r10));
        f(r10);
        return;
    L32:
        IDoraService r18 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r18 == null) goto L37;
        SessionService r19 = r18.d();
        if (r19 == null) goto L37;
        r19.y(3, DoraCallStateCode.DOUBAO_STOP_RECORD_BY_EXCEPTION, false);
    L37:
        n1.e("RecordMinutesSettingManager", "GRecord current network is not work, not send message");
        return;
    L26:
        NetQualityManager.NetworkStatus r20 = NetQualityManager.a;
        n1.d("RecordMinutesSettingManager", "network status is " + r20);
        if (r20.compareTo(NetQualityManager.NetworkStatus.POOR_4G) < 0) goto L25;
    L14:
        if (Intrinsics.areEqual(r17.a, "") == true) goto L21;
        if (r17.b != 0) goto L21;
        n1.d("RecordMinutesSettingManager", "GRecord Match Success, " + r17.a + " wait " + r12);
        if (r10 != 17) goto L20;
        r14 = 1;
    L20:
        e(q.a(r17, null, r12, r14, 21));
    }
}
