package com.larus.audio.asr;

import android.app.Application;
import android.os.Build;
import android.os.SystemClock;
import com.bytedance.keva.Keva;
import com.larus.audio.IFlowAsrClientService;
import com.larus.audio.asr.sami.bean.AsrExtraInfo;
import com.larus.audio.asr.sami.bean.AsrTaskItem;
import com.larus.audio.audiov3.report.IAudioEventCommonParams;
import com.larus.audio.audiov3.task.asr.AsrEventEnum;
import com.larus.audio.audiov3.util.IAudioDeviceHelper;
import com.larus.audio.b;
import com.larus.audio.report.IAsrTracerFactory;
import com.larus.bmhome.chat.api.AppreciableTraceDelegate;
import com.larus.bmhome.chat.api.IAppreciableTraceService;
import com.larus.bmhome.chat.model.repo.IRepoDispatcherService;
import com.larus.bmhome.chat.model.repo.ISettingRepoService;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Message;
import com.larus.media.MediaResourceManager;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.api.VoiceCallServiceDelegate;
import com.obric.assistant.spi.audio.ObricAsrDelegate;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class AsrGlobals implements com.larus.audio.o0 {
    public static final AsrGlobals a = null;
    public static Function1<? super byte[], Unit> b;
    public static Function1<? super String, Unit> c;
    public static Function1<? super b, Unit> d;
    public static Function4<? super String, ? super String, ? super Long, ? super Integer, Unit> e;
    public static Function1<? super String, Unit> f;
    public static a0 g;
    public static final Lazy h = null;
    public static long i;
    public static String j;
    public static final ConcurrentHashMap<String, z> k = null;

    public AsrGlobals() {
    }

    static {
        a = new AsrGlobals();
        h = LazyKt.lazy(new s());
        i = -1;
        k = new ConcurrentHashMap();
    }

    @Override // com.larus.audio.o0
    public final void b() {
        k.clear();
        IFlowAsrClientService.a.getClass();
        List<String> r0 = IFlowAsrClientService.a.a().o();
        if ((!r0.isEmpty()) == false) goto L5;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AsrGlobals$cleanupRunningAsrTask$1(r0, null), 3, null);
        return;
    L5:
        f2a.c r1 = com.larus.audio.utils.c.a.b("nothing to clean up");
        r1.c.d = "AsrGlobals.cleanupRunningAsrTask";
        f2a.c.c(r1, null, 15);
    }

    @Override // com.larus.audio.o0
    public final String d() {
        w78.a r0 = (w78.a) ((w78.f) h.getValue()).b.getValue();
        if (r0 != null) goto L5;
    L9:
        r0 = (w78.a) BuildersKt.runBlocking(Dispatchers.getIO(), new AsrGlobals$getAsrToken$1(null));
    L11:
        return r0.b;
    L5:
        if (r0.a.length() != 0) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == false) goto L11;
    L7:
        r1 = false;
        goto L8
    }

    @Override // com.larus.audio.o0
    public final void f() {
        j r0 = j.a;
        IFlowAsrClientService.a.getClass();
        IFlowAsrClientService.a.a().m();
    }

    @Override // com.larus.audio.o0
    public final String h() {
        w78.a r0 = (w78.a) ((w78.f) h.getValue()).b.getValue();
        if (r0 != null) goto L5;
    L9:
        r0 = (w78.a) BuildersKt.runBlocking(Dispatchers.getIO(), new AsrGlobals$getAsrKey$1(null));
    L11:
        return r0.a;
    L5:
        if (r0.a.length() != 0) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == false) goto L11;
    L7:
        r1 = false;
        goto L8
    }

    @Override // com.larus.audio.o0
    public final void c() {
        i = SystemClock.elapsedRealtime();
    }

    @Override // com.larus.audio.o0
    public final String getTaskId() {
        return j;
    }

    public static void i(String r12, String r13, int r14) {
        if (z2.a.enableAsrFailedBeforeACKTraceAsync() == false) goto L6;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AsrGlobals$reportAsrFailedBeforeACK$1(r12, r13, r14, null), 3, null);
        return;
    L6:
        IAppreciableTraceService.a.a(AppreciableTraceDelegate.b, r12, "speak", 0, r13, r14, 4);
    }

    public static void j(Message r13, String r14, String r15, long r16, int r19, c0 r110) {
        Intrinsics.checkNotNullParameter(r14, "taskId");
        Intrinsics.checkNotNullParameter(r15, "path");
        Intrinsics.checkNotNullParameter(r110, "traceInfo");
        ConcurrentHashMap<String, z> r10 = k;
        z r2 = r10.get(r14);
        if (r2 == null) goto L15;
        if (r19 == AsrEventEnum.ASR_RESEND_FILE_NOT_EXIST.getCode()) goto L15;
        f2a.c r5 = com.larus.audio.utils.c.a.b("trigger [onFail] callback");
        LinkedHashMap r6 = new LinkedHashMap();
        r6.put(new f2a.f("path"), r15);
        r6.put(new f2a.f("audio_duration"), String.valueOf(r16));
        r6.put(new f2a.f("error_code"), String.valueOf(r19));
        f2a.f r8 = new f2a.f("local_message_id");
        if (r13 == null) goto L10;
        String r12 = r13.getLocalMessageId();
        if (r12 == null) goto L10;
    L11:
        r6.put(r8, r12);
        r6.put(new f2a.f("callback_map_size"), String.valueOf(r10.size()));
        r6.put(f2a.f.c, r14);
        r5.d(r6);
        List r7 = CollectionsKt.listOf(r110.a);
        f2a.g r9 = r5.c;
        r9.b = r7;
        r9.e = r110.b;
        r9.d = "AsrGlobals.triggerFail";
        f2a.c.c(r5, null, 15);
        Intrinsics.checkNotNullParameter(r14, "taskId");
        Intrinsics.checkNotNullParameter(r15, "path");
        Function4<String, String, Long, Integer, Unit> r0 = r2.b;
        if (r0 == null) goto L16;
        r0.invoke(r14, r15, Long.valueOf(r16), Integer.valueOf(r19));
    L16:
        r10.remove(r14);
        VoiceCallServiceDelegate.a.w("asr_error");
        return;
    L10:
        r12 = "";
    L15:
        AsrGlobals$triggerFail$asrFailedTask$1 r17 = new AsrGlobals$triggerFail$asrFailedTask$1(r14, r13, r110, r15, r16, r19, null);
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AsrGlobals$triggerFail$2(r17, null), 3, null);
        goto L16
    }

    @Override // com.larus.audio.o0
    public final void a(String r3, Function1<? super byte[], Unit> r4, Function1<? super String, Unit> r5, Function1<? super b, Unit> r6, Function4<? super String, ? super String, ? super Long, ? super Integer, Unit> r7, Function1<? super String, Unit> r8, a0 r9) {
        if (r3 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == true) goto L10;
        k.put(r3, new z(r6, r7));
    L10:
        b = r4;
        c = r5;
        d = r6;
        e = r7;
        f = r8;
        g = r9;
        return;
    L4:
        if (r3.length() == 0) goto L7;
        r0 = false;
        goto L8
    }

    @Override // com.larus.audio.o0
    public final void g(String r24, String r25, String r26, String r27, y r29, boolean r210, String r30, boolean r31, Long r32, n58.b r33, long r34, Function0 r36, h68.d r37) {
        Intrinsics.checkNotNullParameter(r24, "taskId");
        Intrinsics.checkNotNullParameter(r25, "conversationId");
        Intrinsics.checkNotNullParameter(r29, "config");
        Intrinsics.checkNotNullParameter("ai_doc", "bizScene");
        Intrinsics.checkNotNullParameter(r36, "onRealStart");
        IRepoDispatcherService r2 = (IRepoDispatcherService) ServiceManager.get().getService(IRepoDispatcherService.class);
        if (r2 == null) goto L5;
        ISettingRepoService r3 = r2.c();
    L6:
        JSONObject r6 = new JSONObject();
        r6.put("uid", AccountService.a.getSecUserId());
        r6.put("did", com.larus.platform.service.o.a.getDeviceId());
        r6.put("app_version", String.valueOf(AppHost.a.getUpdateVersionCode()));
        r6.put("local_message_id", r29.a);
        r6.put("os", "Android");
        r6.put("item_id", r29.b);
        Boolean r5 = r29.c;
        if (r5 == null) goto L9;
        r6.put("enable_asr_twopass", r5.booleanValue());
    L9:
        Boolean r7 = r29.d;
        if (r7 == null) goto L12;
        r6.put("single_return", r7.booleanValue());
    L12:
        Object r8 = r29.e;
        if (r8 == null) goto L15;
        r6.put("asr_text_post_process_type", r8);
    L15:
        k r0 = r29.g;
        if (r0 == null) goto L24;
        JSONObject r9 = new JSONObject();
        String r10 = r0.a;
        if (r10 == null) goto L20;
        r9.put("text", r10);
    L20:
        String r1 = r0.b;
        if (r1 == null) goto L23;
        r9.put("audio_context", r1);
    L23:
        Unit r4 = Unit.INSTANCE;
        r6.put("asr_context", r9);
    L24:
        if (r3 == null) goto L26;
        r6.put("speech_language", r3.Q0());
        r6.put("asr_language", r3.S0());
        r6.put("model", r3.Z(r3.r0()));
        r6.put("dumpRate", r3.B() ? 1 : 0);
        r6.put("send_mq", r3.B());
    L26:
        com.larus.audio.o0.a.b(this, null, r24, r25, r26, r27, r6, r210, r30, r31, r32, r33, "ai_doc", r34, null, null, r37, r36, 0, null, 417792);
        return;
    L5:
        r3 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.larus.audio.o0
    public final void e(Message r62, String r63, String r64, String r65, String r66, JSONObject r67, boolean r68, String r69, boolean r70, Long r71, n58.b r72, String r73, long r74, Integer r76, Long r77, final h68.d r79, final Function0<Unit> r710, long r80, final c0 r82) {
        Intrinsics.checkNotNullParameter(r63, "taskId");
        Intrinsics.checkNotNullParameter(r64, "conversationId");
        Intrinsics.checkNotNullParameter(r67, "extraConfig");
        Intrinsics.checkNotNullParameter(r710, "onRealStart");
        Intrinsics.checkNotNullParameter(r82, "traceInfo");
        IRepoDispatcherService r2 = (IRepoDispatcherService) ServiceManager.get().getService(IRepoDispatcherService.class);
        if (r2 == null) goto L5;
        ISettingRepoService r3 = r2.c();
    L6:
        f2a.d r13 = com.larus.audio.utils.c.a;
        f2a.c r4 = r13.b("try start ASR");
        LinkedHashMap r5 = new LinkedHashMap();
        f2a.f r6 = new f2a.f("asr_language");
        if (r66 != null) goto L9;
        String r7 = "";
    L10:
        r5.put(r6, r7);
        f2a.f r8 = new f2a.f("biz_scene");
        if (r73 != null) goto L13;
        String r9 = "";
    L14:
        r5.put(r8, r9);
        r5.put(new f2a.f("is_social"), String.valueOf(r68));
        f2a.f r10 = f2a.f.h;
        r5.put(r10, r64);
        f2a.f r11 = f2a.f.e;
        if (r69 != null) goto L17;
        String r12 = "";
    L18:
        r5.put(r11, r12);
        f2a.f r14 = f2a.f.c;
        r5.put(r14, r63);
        r4.d(r5);
        List r15 = CollectionsKt.listOf(r82.a);
        f2a.g r16 = r4.c;
        r16.b = r15;
        r16.e = r82.b;
        r16.d = "AsrGlobals.start";
        f2a.c.c(r4, null, 15);
        w78.a r17 = (w78.a) ((w78.f) h.getValue()).b.getValue();
        if (r17 != null) goto L21;
    L27:
        Application r19 = null;
        r17 = (w78.a) BuildersKt.runBlocking(Dispatchers.getIO(), new AsrGlobals$start$2(null));
    L28:
        IAudioEventCommonParams r20 = (IAudioEventCommonParams) ServiceManager.get().getService(IAudioEventCommonParams.class);
        if (r20 == null) goto L35;
        m58.b r21 = m58.h.k;
        if (r21 == null) goto L33;
        Application r22 = r21.getApplication();
    L34:
        r20.b(r22);
        goto L35
    L33:
        r22 = r19;
    L35:
        IAudioEventCommonParams r23 = (IAudioEventCommonParams) ServiceManager.get().getService(IAudioEventCommonParams.class);
        if (r23 == null) goto L38;
        IAudioDeviceHelper.a r24 = r23.a();
    L39:
        r67.put("device_model", Build.MODEL);
        if (r24 == 0) goto L43;
        String r25 = r24.a;
        if (r25 == null) goto L43;
    L44:
        r67.put("input_device", r25);
        if (r24 == 0) goto L48;
        String r26 = r24.b;
        if (r26 == null) goto L48;
    L49:
        r67.put("output_device", r26);
        if (r24 == 0) goto L53;
        String r27 = r24.c;
        if (r27 == null) goto L53;
    L54:
        r67.put("bluetooth_device_name", r27);
        String r110 = r17.a;
        String r29 = r17.b;
        if (r3 == null) goto L57;
        String r30 = r3.Z(r66);
    L58:
        if (r30 != null) goto L60;
        r30 = "";
    L60:
        if (r65 != null) goto L62;
        String r210 = "";
    L63:
        String r211 = r67.toString();
        IRepoDispatcherService r0 = (IRepoDispatcherService) ServiceManager.get().getService(IRepoDispatcherService.class);
        if (r0 == null) goto L68;
        ISettingRepoService r1 = r0.c();
        if (r1 == null) goto L68;
        String r31 = r1.S0();
    L69:
        if (r68 == false) goto L71;
        r31 = com.larus.bmhome.bot.n.a.getString(AccountService.a.getSecUserId().concat("_asr_main_bot_language"), "");
    L71:
        String r212 = r31;
        j = r63;
        j r32 = j.a;
        Intrinsics.checkNotNullParameter(r30, "mode");
        Function1 r33 = new t();
        Intrinsics.checkNotNullParameter(r33, "callback");
        j.c = r33;
        j.d = g;
        String r111 = r30;
        w r34 = new w(r72, r82, r62, r64, r69);
        IFlowAsrClientService.a.getClass();
        IFlowAsrClientService.a.a().u(r34);
        if (i != (-1)) goto L74;
        i = r74;
    L74:
        n58.a r35 = new u();
        Intrinsics.checkNotNullParameter(r35, "listener");
        IFlowAsrClientService.a.a().d(r35);
        IAsrTracerFactory r36 = (IAsrTracerFactory) ServiceManager.get().getService(IAsrTracerFactory.class);
        long r37 = i;
        if (r69 != null) goto L77;
        String r38 = "";
    L78:
        k78.b r39 = r36.a(r37, r63, r64, r38, new v(r82));
        i = -1;
        Keva r40 = c78.a.g;
        int r112 = 25000;
        if (r40.getInt("key_asr_timeout_duration", -1) == (-1)) goto L81;
        int r41 = r40.getInt("key_asr_timeout_duration", -1);
    L91:
        int r213 = r41;
    L94:
        if (r40.getInt("key_asr_retry_times", -1) == (-1)) goto L97;
        int r42 = r40.getInt("key_asr_retry_times", -1);
    L107:
        int r214 = r42;
    L109:
        final AsrTaskItem r113 = new AsrTaskItem(r63, r64, r210, new AsrExtraInfo(r111, r110, r29, r212, r211, r214, r213), r69, r70, r71, r73, r76, r77, r82, r80);
        Intrinsics.checkNotNullParameter(r113, "asrTaskItem");
        Intrinsics.checkNotNullParameter(r39, "tracer");
        Intrinsics.checkNotNullParameter(r710, "onRealStart");
        final String r43 = r113.getTaskId();
        if (r43 == null) goto L250;
        String r44 = r113.getAsrFilePath();
        if (r44 != null) goto L115;
    L118:
        boolean r45 = true;
    L119:
        IFlowAsrClientService.a.a().i(r43, r39);
        r39.b(!r45);
        FLogger.a.d("AsrClientManager", "start asr " + r45);
        if (r45 == false) goto L146;
        String r46 = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        b68.b r47 = b68.b.a;
        Intrinsics.checkNotNull(r46);
        r47.getClass();
        String r114 = b68.b.c("/record/asr/pcm/", r46);
        if (r114 != null) goto L124;
        r114 = "";
    L124:
        final AsrTaskItem r48 = AsrTaskItem.copy$default(r113, null, null, r114, null, null, false, null, null, null, null, null, 0, 4091, null);
        f2a.c r49 = r13.b("try start ASR before requestMedia");
        LinkedHashMap r50 = new LinkedHashMap();
        r50.put(r14, r43);
        String r115 = r48.getConversationId();
        if (r115 != null) goto L127;
        r115 = "";
    L127:
        r50.put(r10, r115);
        String r116 = r48.getBotId();
        if (r116 != null) goto L130;
        r116 = "";
    L130:
        r50.put(r11, r116);
        f2a.f r51 = new f2a.f("biz_scene");
        String r117 = r48.getBizScene();
        if (r117 != null) goto L133;
        r117 = "";
    L133:
        r50.put(r51, r117);
        f2a.f r52 = new f2a.f("asr_file_path");
        String r118 = r48.getAsrFilePath();
        if (r118 != null) goto L136;
        r118 = "";
    L136:
        r50.put(r52, r118);
        r49.d(r50);
        c0 r53 = r48.getTraceInfo();
        if (r53 == null) goto L140;
        String r119 = r53.a;
        if (r119 == null) goto L140;
    L141:
        List r54 = CollectionsKt.listOf(r119);
        f2a.g r55 = r49.c;
        r55.b = r54;
        r55.d = "AsrClientManager.start";
        c0 r56 = r48.getTraceInfo();
        if (r56 == null) goto L144;
        String r120 = r56.b;
    L145:
        r49.c.e = r120;
        f2a.c.c(r49, null, 15);
        Lazy r57 = MediaResourceManager.a;
        MediaResourceManager.l(j.i, j.h, new c(r48, r43, r113, r710, r79), new d(r48, r43, r113), 48);
        return;
    L144:
        r120 = null;
    L140:
        r119 = "";
        goto L141
    L146:
        String r121 = null;
        f2a.c r59 = r13.b("try start ASR with File");
        LinkedHashMap r60 = new LinkedHashMap();
        r60.put(r14, r43);
        String r61 = r113.getConversationId();
        if (r61 != null) goto L149;
        r61 = "";
    L149:
        r60.put(r10, r61);
        String r75 = r113.getBotId();
        if (r75 != null) goto L152;
        r75 = "";
    L152:
        r60.put(r11, r75);
        f2a.f r81 = new f2a.f("biz_scene");
        String r122 = r113.getBizScene();
        if (r122 != null) goto L155;
        r122 = "";
    L155:
        r60.put(r81, r122);
        r60.put(new f2a.f("asr_file_path"), r113.getAsrFilePath());
        r60.put(new f2a.f("audio_duration"), String.valueOf(r113.getDuration()));
        r59.d(r60);
        c0 r83 = r113.getTraceInfo();
        if (r83 == null) goto L159;
        String r123 = r83.a;
        if (r123 == null) goto L159;
    L160:
        List r84 = CollectionsKt.listOf(r123);
        f2a.g r85 = r59.c;
        r85.b = r84;
        r85.d = "AsrClientManager.start";
        c0 r86 = r113.getTraceInfo();
        if (r86 == null) goto L163;
        String r87 = r86.b;
    L164:
        r59.c.e = r87;
        f2a.c.c(r59, null, 15);
        IFlowAsrClientService r88 = IFlowAsrClientService.a.a();
        AsrExtraInfo r89 = r113.getAsrExtraInfo();
        if (r89 == null) goto L167;
        int r90 = r89.getMaxRetryTime();
    L168:
        int[] r91 = new int[1];
        AsrExtraInfo r92 = r113.getAsrExtraInfo();
        if (r92 == null) goto L171;
        r112 = r92.getMaxTimeOutDuration();
    L171:
        r91[0] = r112;
        r88.h(new o58.b(r90, r91));
        IFlowAsrClientService r93 = IFlowAsrClientService.a.a();
        AsrExtraInfo r94 = r113.getAsrExtraInfo();
        if (r94 == null) goto L174;
        String r95 = r94.getAsrMode();
    L175:
        AsrExtraInfo r96 = r113.getAsrExtraInfo();
        if (r96 == null) goto L178;
        r121 = r96.getLanguage();
    L178:
        boolean r97 = r113.getSaveAudioFile();
        r93.s(r43, r95, r121, r97 ? 1 : 0, r113.getBotId());
        ObricAsrDelegate r98 = ObricAsrDelegate.b;
        if (r98.a() == true) goto L181;
    L188:
        boolean r510 = false;
    L189:
        m58.b r99 = m58.h.k;
        if (r99 != null) goto L192;
    L194:
        boolean r100 = false;
    L195:
        if (r100 == true) goto L197;
    L206:
        boolean r101 = false;
    L207:
        IFlowAsrClientService r102 = IFlowAsrClientService.a.a();
        String r410 = r113.getAsrFilePath();
        String r124 = r113.getConversationId();
        if (r124 != null) goto L210;
        String r310 = "";
    L211:
        AsrExtraInfo r103 = r113.getAsrExtraInfo();
        if (r103 == null) goto L217;
        String r125 = r103.getAsrMode();
        if (r125 == null) goto L217;
        String r311 = r125;
    L218:
        AsrExtraInfo r104 = r113.getAsrExtraInfo();
        if (r104 == null) goto L224;
        String r126 = r104.getLanguage();
        if (r126 == null) goto L224;
        String r312 = r126;
    L225:
        boolean r411 = j.b;
        AsrExtraInfo r105 = r113.getAsrExtraInfo();
        if (r105 == null) goto L229;
        String r106 = r105.getExtraConfig();
        if (r106 == null) goto L229;
    L230:
        String r511 = r106;
        String r512 = r113.getBotId();
        Integer r107 = r113.getVuiId();
        if (r107 == null) goto L233;
        int r412 = r107.intValue();
    L234:
        if (r101 == false) goto L236;
        int r513 = 2;
    L237:
        int r413 = r98.getBusinessType();
        boolean r414 = r113.getSaveAudioFile();
        Long r415 = r113.getDuration();
        long r514 = r113.getMinRecordDurationMs();
        c0 r108 = r113.getTraceInfo();
        if (r108 == null) goto L241;
        String r127 = r108.a;
        if (r127 == null) goto L241;
    L242:
        c0 r109 = r113.getTraceInfo();
        if (r109 == null) goto L246;
        String r128 = r109.b;
        if (r128 == null) goto L246;
    L247:
        r102.b(r43, new y58.a(r311, r43, r310, r312, r410, r411, r414, r415, null, 0, 0, null, r413, r412, r510, 0, r513, null, r511, r512, new y58.d(r127, r128), r514, null, 139590816));
        return;
    L246:
        r128 = "";
    L241:
        r127 = "";
        goto L242
    L236:
        r513 = 1;
        goto L237
    L233:
        r412 = 0;
    L229:
        r106 = "{}";
    L224:
        r312 = "";
    L217:
        r311 = "";
        goto L218
    L210:
        r310 = r124;
        goto L211
    L197:
        if (r98.m() == false) goto L206;
        if (r98.a() == false) goto L206;
        Integer r129 = r113.getVuiId();
        if (r129 == null) goto L203;
        int r130 = r129.intValue();
    L204:
        if (r130 != 0) goto L206;
        r101 = true;
        goto L207
    L203:
        r130 = 0;
        goto L204
    L192:
        if (r99.a() != true) goto L194;
        r100 = true;
        goto L195
    L181:
        if (r113.getVuiId() == null) goto L188;
        Integer r131 = r113.getVuiId();
        if (r131 != null) goto L186;
    L187:
        r510 = true;
        goto L189
    L186:
        if (r131.intValue() == 0) goto L188;
    L174:
        r95 = null;
        goto L175
    L167:
        r90 = 1;
        goto L168
    L163:
        r87 = null;
    L159:
        r123 = "";
        goto L160
    L115:
        if (r44.length() == 0) goto L118;
        r45 = false;
        goto L119
    L250:
        return;
    L97:
        z2 r132 = z2.a;
        lq9.h r133 = r132.U0().c();
        if (r133 != null) goto L100;
    L102:
        boolean r134 = false;
    L103:
        if (r134 == false) goto L108;
        lq9.h r135 = r132.U0().c();
        if (r135 == null) goto L108;
        r42 = r135.c();
    L108:
        r214 = 1;
        goto L109
    L100:
        if (r133.a() != true) goto L102;
        r134 = true;
        goto L103
    L81:
        z2 r136 = z2.a;
        lq9.h r137 = r136.U0().c();
        if (r137 != null) goto L84;
    L86:
        boolean r138 = false;
    L87:
        if (r138 == false) goto L92;
        lq9.h r139 = r136.U0().c();
        if (r139 == null) goto L92;
        r41 = r139.b();
    L92:
        r213 = 25000;
        goto L94
    L84:
        if (r137.a() != true) goto L86;
        r138 = true;
        goto L87
    L77:
        r38 = r69;
    L68:
        r31 = null;
        goto L69
    L62:
        r210 = r65;
        goto L63
    L57:
        r30 = null;
    L53:
        r27 = "";
    L48:
        r26 = "";
    L43:
        r25 = "";
        goto L44
    L38:
        r24 = r19;
        goto L39
    L21:
        if (r17.a.length() != 0) goto L23;
        boolean r140 = true;
    L24:
        if (r140 == true) goto L27;
        r19 = null;
        goto L28
    L23:
        r140 = false;
        goto L24
    L17:
        r12 = r69;
        goto L18
    L13:
        r9 = r73;
        goto L14
    L9:
        r7 = r66;
        goto L10
    L5:
        r3 = null;
        goto L6
    }
}
