package com.bytedance.lynx.service.monitor;

import a5.c;
import android.app.Application;
import android.os.Build;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.bytedance.ai.event.MessageIndication;
import com.bytedance.android.monitorV2.h;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.Npth;
import com.bytedance.ies.web.jsbridge2.l;
import com.bytedance.lynx.service.model.b;
import com.lynx.base.log.LynxLog;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.base.TraceEvent;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import ko.d;
import ko.e;
import ko.k;
import ko.r;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u0015\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0010\u0010\u000fJ=\u0010\u0015\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J1\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u0017\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010 \u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b \u0010!R\u0014\u0010\"\u001a\u00020\n8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020\n8\u0006X\u0086T¢\u0006\u0006\n\u0004\b$\u0010#R\u0014\u0010%\u001a\u00020\n8\u0006X\u0086T¢\u0006\u0006\n\u0004\b%\u0010#R\u0014\u0010&\u001a\u00020\n8\u0006X\u0086T¢\u0006\u0006\n\u0004\b&\u0010#R\u0014\u0010'\u001a\u00020\n8\u0006X\u0086T¢\u0006\u0006\n\u0004\b'\u0010#R\u0014\u0010(\u001a\u00020\n8\u0006X\u0086T¢\u0006\u0006\n\u0004\b(\u0010#R\u0014\u0010)\u001a\u00020\n8\u0006X\u0086T¢\u0006\u0006\n\u0004\b)\u0010#R\u0014\u0010*\u001a\u00020\n8\u0006X\u0086T¢\u0006\u0006\n\u0004\b*\u0010#R\u0014\u0010+\u001a\u00020\n8\u0006X\u0086T¢\u0006\u0006\n\u0004\b+\u0010#R\u0014\u0010,\u001a\u00020\n8\u0006X\u0086T¢\u0006\u0006\n\u0004\b,\u0010#R\u0014\u0010-\u001a\u00020\n8\u0006X\u0086T¢\u0006\u0006\n\u0004\b-\u0010#R\u0014\u0010.\u001a\u00020\n8\u0006X\u0086T¢\u0006\u0006\n\u0004\b.\u0010#R\u0014\u0010/\u001a\u00020\n8\u0006X\u0086T¢\u0006\u0006\n\u0004\b/\u0010#R\u0014\u00100\u001a\u00020\n8\u0006X\u0086T¢\u0006\u0006\n\u0004\b0\u0010#R\u0014\u00101\u001a\u00020\n8\u0006X\u0086T¢\u0006\u0006\n\u0004\b1\u0010#R\u0014\u00102\u001a\u00020\n8\u0006X\u0086T¢\u0006\u0006\n\u0004\b2\u0010#R\u0014\u00103\u001a\u00020\n8\u0006X\u0086T¢\u0006\u0006\n\u0004\b3\u0010#R\u0014\u00104\u001a\u00020\n8\u0006X\u0086T¢\u0006\u0006\n\u0004\b4\u0010#R\u0014\u00105\u001a\u00020\n8\u0006X\u0086T¢\u0006\u0006\n\u0004\b5\u0010#R\u0014\u00106\u001a\u00020\n8\u0006X\u0086T¢\u0006\u0006\n\u0004\b6\u0010#R\u0014\u00107\u001a\u00020\n8\u0006X\u0086T¢\u0006\u0006\n\u0004\b7\u0010#R\u0014\u00108\u001a\u00020\n8\u0006X\u0086T¢\u0006\u0006\n\u0004\b8\u0010#R\u0014\u00109\u001a\u00020\n8\u0006X\u0086T¢\u0006\u0006\n\u0004\b9\u0010#R\u0014\u0010;\u001a\u00020:8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010=\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0014\u0010@\u001a\u00020?8\u0002X\u0082T¢\u0006\u0006\n\u0004\b@\u0010AR\u0014\u0010B\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\bB\u0010#R\u001b\u0010G\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010FR\u0016\u0010I\u001a\u00020H8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010J¨\u0006K"}, d2 = {"Lcom/bytedance/lynx/service/monitor/LynxMonitorService;", "Lko/d;", "<init>", "()V", "", "ensureInitialize", "Lcom/bytedance/lynx/service/model/b;", "lynxConfig", "initialize", "(Lcom/bytedance/lynx/service/model/b;)V", "", "eventName", "Lorg/json/JSONObject;", "data", "reportTrailEvent", "(Ljava/lang/String;Lorg/json/JSONObject;)V", "reportImageStatus", "Lcom/lynx/tasm/LynxView;", "view", LynxMonitorService.KEY_METRICS, "category", "formatEventReporter", "(Lcom/lynx/tasm/LynxView;Ljava/lang/String;Lorg/json/JSONObject;Lorg/json/JSONObject;Lorg/json/JSONObject;)V", "extra", "reportResourceStatus", "(Lcom/lynx/tasm/LynxView;Ljava/lang/String;Lorg/json/JSONObject;Lorg/json/JSONObject;)V", "tagName", "tagValue", "reportCrashGlobalContextTag", "(Ljava/lang/String;Ljava/lang/String;)V", "Lko/k;", "imageInfo", "reportImageInfo", "(Lko/k;)V", "TAG", "Ljava/lang/String;", "DEFAULT_BID", "DEFAULT_PID", "KEY_URL", "KEY_METRIC", "KEY_METRICS", "KEY_BID", "KEY_CHANNEL", "KEY_EXTRA", "KEY_PAGE_CONFIG", "KEY_SETUP_TIMING", "KEY_EXTRA_TIMING", "KEY_UPDATE_TIMING", "KEY_MEMORY", "KEY_TIME_METRICS", "KEY_IMAGE_LOAD_SUCCESS_RATE", "KEY_SUCCESS_RATE", "KEY_MEMORY_COST", "KEY_IMAGE_URL", "KEY_MEMORY_COST_FROM", "KEY_PID", "KEY_TYPE", "KEY_TRIGGER", "Ljava/util/concurrent/atomic/AtomicBoolean;", "initLock", "Ljava/util/concurrent/atomic/AtomicBoolean;", "lynxServiceConfig", "Lcom/bytedance/lynx/service/model/b;", "", "LYNX_SID", "I", "LYNX_SDK_VERSION_TAG", "lynxSdkVersion$delegate", "Lkotlin/Lazy;", "getLynxSdkVersion", "()Ljava/lang/String;", "lynxSdkVersion", "", "SDK_VERSION_REPORTED", "Z", "LynxService_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LynxMonitorService implements d {
    public static final String DEFAULT_BID = "LynxInspector";
    public static final String DEFAULT_PID = "Lynx";
    public static final LynxMonitorService INSTANCE = null;
    public static final String KEY_BID = "bid";
    public static final String KEY_CHANNEL = "channel";
    public static final String KEY_EXTRA = "extra";
    public static final String KEY_EXTRA_TIMING = "extra_timing";
    public static final String KEY_IMAGE_LOAD_SUCCESS_RATE = "image_load_success_rate";
    public static final String KEY_IMAGE_URL = "image_url";
    public static final String KEY_MEMORY = "memory";
    public static final String KEY_MEMORY_COST = "memory_cost";
    public static final String KEY_MEMORY_COST_FROM = "memoryCost";
    public static final String KEY_METRIC = "metric";
    public static final String KEY_METRICS = "metrics";
    public static final String KEY_PAGE_CONFIG = "page_config";
    public static final String KEY_PID = "pid";
    public static final String KEY_SETUP_TIMING = "setup_timing";
    public static final String KEY_SUCCESS_RATE = "successRate";
    public static final String KEY_TIME_METRICS = "timeMetrics";
    public static final String KEY_TRIGGER = "trigger";
    public static final String KEY_TYPE = "type";
    public static final String KEY_UPDATE_TIMING = "update_timings";
    public static final String KEY_URL = "url";
    private static final String LYNX_SDK_VERSION_TAG = "lynx_sdk_version";
    private static final int LYNX_SID = 2951;
    private static volatile boolean SDK_VERSION_REPORTED = false;
    public static final String TAG = "LynxMonitorService";
    private static final AtomicBoolean initLock = null;
    private static final Lazy lynxSdkVersion$delegate = null;
    private static b lynxServiceConfig;

    static {
        INSTANCE = new LynxMonitorService();
        initLock = new AtomicBoolean(false);
        lynxSdkVersion$delegate = LazyKt.lazy(LynxMonitorService$lynxSdkVersion$2.f6836a);
    }

    private LynxMonitorService() {
    }

    public static /* synthetic */ Map a(String r5, String r10, CrashType r11) {
        return m88reportCrashGlobalContextTag$lambda22(r5, r10, r11);
    }

    private final void ensureInitialize() {
        boolean r5 = false;
        if (initLock.compareAndSet(false, true) == false) goto L56;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L11
        Field r11 = h.class.getDeclaredField("b");     // Catch: Throwable -> L11
        if (r11 == null) goto L9;
        r11.setAccessible(true);     // Catch: Throwable -> L11
    L9:
        if (r11 == null) goto L13;
        r5 = r11.getBoolean(h.e());     // Catch: Throwable -> L11
    L13:
        if (r5 == true) goto L47;
        b r12 = lynxServiceConfig;     // Catch: Throwable -> L11
        if (r12 == null) goto L47;
        Application r13 = r12.f6833a;     // Catch: Throwable -> L11
        if (r13 == null) goto L47;
        h.e().c(r13);     // Catch: Throwable -> L11
        b r14 = lynxServiceConfig;     // Catch: Throwable -> L11
        if (r14 == null) goto L22;
        String r15 = "";
    L23:
        if (r14 == null) goto L25;
        String r16 = "";
    L26:
        if (r14 == null) goto L28;
        String r17 = r14.f6834b;     // Catch: Throwable -> L11
    L29:
        if (r14 == null) goto L31;
        String r18 = r14.e;     // Catch: Throwable -> L11
    L32:
        if (r14 == null) goto L34;
        String r19 = r14.f6835c;     // Catch: Throwable -> L11
    L35:
        if (r14 == null) goto L37;
        String r20 = r14.d;     // Catch: Throwable -> L11
    L38:
        if (r14 == null) goto L40;
        String r21 = "";
    L41:
        if (r15 == null) goto L46;
        if ("".equals(r15) == true) goto L46;
        c r22 = new c();     // Catch: Throwable -> L11
        r22.f98a = r17;     // Catch: Throwable -> L11
        r22.f99b = r15;     // Catch: Throwable -> L11
        r22.f100c = "Android";     // Catch: Throwable -> L11
        r22.d = String.valueOf(Build.VERSION.RELEASE);     // Catch: Throwable -> L11
        r22.e = r18;     // Catch: Throwable -> L11
        r22.f = r16;     // Catch: Throwable -> L11
        r22.g = r19;     // Catch: Throwable -> L11
        r22.f101h = r20;     // Catch: Throwable -> L11
        r22.f102i = r21;     // Catch: Throwable -> L11
        r22.f103j = null;     // Catch: Throwable -> L11
        r22.f104k = null;     // Catch: Throwable -> L11
        r22.f105l = null;     // Catch: Throwable -> L11
        h.e().b(r22);     // Catch: Throwable -> L11
    L46:
        throw new RuntimeException("host is undefined");     // Catch: Throwable -> L11
    L40:
        r21 = null;
        goto L41
    L37:
        r20 = null;
        goto L38
    L34:
        r19 = null;
        goto L35
    L31:
        r18 = null;
        goto L32
    L28:
        r17 = null;
        goto L29
    L25:
        r16 = null;
        goto L26
    L22:
        r15 = null;
    L47:
        Object r23 = Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L50:
        Throwable r24 = Result.m127exceptionOrNullimpl(r23);
        if (r24 == null) goto L55;
        LynxLog.b(4, TAG, "LynxMonitorService ensureInitialize:" + r24.getMessage());
        return;
    L55:
        return;
    L11:
        th = move-exception;
        Result.Companion r25 = Result.Companion;
        r23 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L50
    }

    private final String getLynxSdkVersion() {
        return (String) lynxSdkVersion$delegate.getValue();
    }

    /* JADX INFO: renamed from: reportCrashGlobalContextTag$lambda-22, reason: not valid java name */
    private static final Map m88reportCrashGlobalContextTag$lambda22(String r5, String r10, CrashType r11) {
        Intrinsics.checkNotNullParameter(r5, "$tagName");
        Intrinsics.checkNotNullParameter(r10, "$tagValue");
        HashMap r12 = new HashMap();
        r12.put("lynx_sdk_version", INSTANCE.getLynxSdkVersion());
        r12.put(r5, r10);
        return r12;
    }

    public void formatEventReporter(LynxView r10, String r11, JSONObject r12, JSONObject r13, JSONObject r14) {
        Intrinsics.checkNotNullParameter(r11, "eventName");
        Intrinsics.checkNotNullParameter(r12, "data");
        TraceEvent.c("LynxMonitorServiceProxy.formatEventReporter");
        ensureInitialize();
        JSONObject r15 = r12.optJSONObject(KEY_METRIC);
        if (r15 != null) goto L5;
        r15 = new JSONObject();
    L5:
        JSONObject r5 = new JSONObject();
        r5.put("url", r15.optString("url", ""));
        r5.put("bid", DEFAULT_BID);
        r5.put(KEY_PID, DEFAULT_PID);
        if (r14 == null) goto L8;
        r14.put("type", DEFAULT_PID);
        r14.put(KEY_TRIGGER, r11);
        r14.put(KEY_CHANNEL, r12.optString(KEY_CHANNEL, ""));
        r14.put("url", r15.optString("url", ""));
    L8:
        JSONObject r16 = r12.optJSONObject("extra");
        if (r16 != null) goto L11;
        r16 = new JSONObject();
    L11:
        l r17 = new l(r11, 1);
        r17.f6291c = DEFAULT_BID;
        r17.f6292h = r14;
        r17.f6293i = r13;
        r17.f6296l = r5;
        r17.f6294j = r16;
        r17.b(0);
        b r18 = lynxServiceConfig;
        if (r18 == null) goto L14;
        String r19 = r18.f6834b;
    L15:
        r17.f = r19;
        x4.c r20 = r17.a();
        if (r10 == null) goto L18;
        com.bytedance.android.monitorV2.lynx.d.f3638a.getClass();
        com.bytedance.android.monitorV2.lynx.d.g(r10, r20);
    L19:
        TraceEvent.a(0, "LynxMonitorServiceProxy.formatEventReporter");
        return;
    L18:
        h.e().getClass();
        h.d(r20);
        goto L19
    L14:
        r19 = null;
        goto L15
    }

    @Override // com.lynx.tasm.service.IServiceProvider
    @NonNull
    public /* bridge */ /* synthetic */ Class getServiceClass() {
        return d.class;
    }

    public final void initialize(b r5) {
        Intrinsics.checkNotNullParameter(r5, "lynxConfig");
        lynxServiceConfig = r5;
    }

    @Override // ko.d
    public void reportCrashGlobalContextTag(final String r10, final String r11) {
        /*  JADX ERROR: Simple mode code generation failed
            java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
            	at java.base/java.util.Objects.checkIndex(Objects.java:365)
            	at java.base/java.util.ArrayList.get(ArrayList.java:428)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            this = this;
            java.lang.String r0 = "LynxMonitorService reportCrashGlobalContextTag:"
            java.lang.String r1 = "LynxMonitorService"
            java.lang.String r2 = "tagName"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r2)
            java.lang.String r2 = "tagValue"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r2)
            java.lang.String r2 = "LynxMonitorServiceProxy.reportCrashGlobalContextTag"
            com.lynx.tasm.base.TraceEvent.c(r2)
            r3 = 4
            boolean r4 = com.bytedance.lynx.service.monitor.LynxMonitorService.SDK_VERSION_REPORTED     // Catch: java.lang.NullPointerException -> L30 java.lang.ClassCastException -> L32 java.lang.IllegalArgumentException -> L34 java.lang.UnsupportedOperationException -> L36
            java.lang.String r5 = "lynx_sdk_version"
            if (r4 != 0) goto L38
            java.lang.String r4 = r7.getLynxSdkVersion()     // Catch: java.lang.NullPointerException -> L30 java.lang.ClassCastException -> L32 java.lang.IllegalArgumentException -> L34 java.lang.UnsupportedOperationException -> L36
            r6 = 2951(0xb87, float:4.135E-42)
            com.bytedance.crash.Npth.registerSdk(r6, r4)     // Catch: java.lang.NullPointerException -> L30 java.lang.ClassCastException -> L32 java.lang.IllegalArgumentException -> L34 java.lang.UnsupportedOperationException -> L36
            java.lang.String r4 = r7.getLynxSdkVersion()     // Catch: java.lang.NullPointerException -> L30 java.lang.ClassCastException -> L32 java.lang.IllegalArgumentException -> L34 java.lang.UnsupportedOperationException -> L36
            com.bytedance.crash.Npth.addTag(r5, r4)     // Catch: java.lang.NullPointerException -> L30 java.lang.ClassCastException -> L32 java.lang.IllegalArgumentException -> L34 java.lang.UnsupportedOperationException -> L36
            r4 = 1
            com.bytedance.lynx.service.monitor.LynxMonitorService.SDK_VERSION_REPORTED = r4     // Catch: java.lang.NullPointerException -> L30 java.lang.ClassCastException -> L32 java.lang.IllegalArgumentException -> L34 java.lang.UnsupportedOperationException -> L36
            goto L38
        L30:
            r7 = move-exception
            goto L4d
        L32:
            r7 = move-exception
            goto L61
        L34:
            r7 = move-exception
            goto L75
        L36:
            r7 = move-exception
            goto L89
        L38:
            java.lang.String r7 = r7.getLynxSdkVersion()     // Catch: java.lang.NullPointerException -> L30 java.lang.ClassCastException -> L32 java.lang.IllegalArgumentException -> L34 java.lang.UnsupportedOperationException -> L36
            com.bytedance.crash.Npth.addTag(r5, r7)     // Catch: java.lang.NullPointerException -> L30 java.lang.ClassCastException -> L32 java.lang.IllegalArgumentException -> L34 java.lang.UnsupportedOperationException -> L36
            com.bytedance.crash.Npth.addTag(r8, r9)     // Catch: java.lang.NullPointerException -> L30 java.lang.ClassCastException -> L32 java.lang.IllegalArgumentException -> L34 java.lang.UnsupportedOperationException -> L36
            com.bytedance.lynx.service.monitor.a r7 = new com.bytedance.lynx.service.monitor.a     // Catch: java.lang.NullPointerException -> L30 java.lang.ClassCastException -> L32 java.lang.IllegalArgumentException -> L34 java.lang.UnsupportedOperationException -> L36
            r7.<init>(r8, r9)     // Catch: java.lang.NullPointerException -> L30 java.lang.ClassCastException -> L32 java.lang.IllegalArgumentException -> L34 java.lang.UnsupportedOperationException -> L36
            com.bytedance.crash.CrashType r8 = com.bytedance.crash.CrashType.ALL     // Catch: java.lang.NullPointerException -> L30 java.lang.ClassCastException -> L32 java.lang.IllegalArgumentException -> L34 java.lang.UnsupportedOperationException -> L36
            com.bytedance.crash.Npth.addAttachUserData(r7, r8)     // Catch: java.lang.NullPointerException -> L30 java.lang.ClassCastException -> L32 java.lang.IllegalArgumentException -> L34 java.lang.UnsupportedOperationException -> L36
            goto L9c
        L4d:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>(r0)
            java.lang.String r7 = r7.getMessage()
            r8.append(r7)
            java.lang.String r7 = r8.toString()
            com.lynx.base.log.LynxLog.b(r3, r1, r7)
            goto L9c
        L61:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>(r0)
            java.lang.String r7 = r7.getMessage()
            r8.append(r7)
            java.lang.String r7 = r8.toString()
            com.lynx.base.log.LynxLog.b(r3, r1, r7)
            goto L9c
        L75:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>(r0)
            java.lang.String r7 = r7.getMessage()
            r8.append(r7)
            java.lang.String r7 = r8.toString()
            com.lynx.base.log.LynxLog.b(r3, r1, r7)
            goto L9c
        L89:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>(r0)
            java.lang.String r7 = r7.getMessage()
            r8.append(r7)
            java.lang.String r7 = r8.toString()
            com.lynx.base.log.LynxLog.b(r3, r1, r7)
        L9c:
            r7 = 0
            com.lynx.tasm.base.TraceEvent.a(r7, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.lynx.service.monitor.LynxMonitorService.reportCrashGlobalContextTag(java.lang.String, java.lang.String):void");
    }

    @Override // ko.d
    public void reportImageInfo(k r10) {
        Intrinsics.checkNotNullParameter(r10, "imageInfo");
        TraceEvent.c("LynxMonitorServiceProxy.reportImageInfo");
        JSONObject r5 = new JSONObject().put("res_load_start", r10.g).put("res_load_finish", r10.f18698h);     // Catch: JSONException -> L7
        boolean r11 = r10.f18697c;
        if (r11 == false) goto L9;
        String r12 = "success";
    L10:
        String r13 = "missing";
        e r14 = (e) r.g().e(e.class);     // Catch: JSONException -> L7
        String r15 = r10.f18695a;
        if (r14 == null) goto L20;
        int r16 = r14.isLocalResource(r15);     // Catch: JSONException -> L7
        if (r16 != 0) goto L16;
        r13 = "cdn";
        goto L20
    L16:
        if (r16 != 1) goto L20;
        r13 = "gecko";
    L20:
        JSONObject r17 = new JSONObject().put("res_src", r15).put("res_state", r12).put("res_scene", "lynx_image").put("res_from", r13).put("res_size", Float.valueOf(r10.f)).put("is_memory", r10.e);     // Catch: JSONException -> L7
        JSONObject r18 = new JSONObject().put("res_load_perf", r5).put("res_info", r17).put("res_loader_info", new JSONObject().put("res_loader_name", DEFAULT_PID).put("res_loader_version", LynxEnv.inst().getLynxVersion()));     // Catch: JSONException -> L7
        int r19 = r10.d;
        if (r19 == 0) goto L25;
        if (r11 == true) goto L25;
        r18.put("res_load_error", new JSONObject().put("net_library_error_code", r19).put("res_loader_error_code", mh.e.a(r19)));     // Catch: JSONException -> L7
    L25:
        reportResourceStatus((LynxView) r10.f18696b.get(), "res_loader_perf", r18, null);     // Catch: JSONException -> L7
    L28:
        TraceEvent.a(0, "LynxMonitorServiceProxy.reportImageInfo");
        return;
    L9:
        r12 = MessageIndication.STATUS_FAILED;
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L28
    }

    @Override // ko.d
    public void reportImageStatus(String r10, JSONObject r11) {
        Intrinsics.checkNotNullParameter(r10, "eventName");
        Intrinsics.checkNotNullParameter(r11, "data");
        TraceEvent.c("LynxMonitorServiceProxy.reportImageStatus");
        JSONObject r5 = new JSONObject();
        JSONObject r12 = r11.optJSONObject(KEY_TIME_METRICS);
        if (r12 == null) goto L8;
        Iterator<String> r13 = r12.keys();
    L6:
        if (r13.hasNext() == false) goto L8;
        String r14 = r13.next();
        r5.put(r14, r12.get(r14));
    L8:
        r5.put(KEY_IMAGE_LOAD_SUCCESS_RATE, r11.optInt(KEY_SUCCESS_RATE, -1));
        r5.put(KEY_MEMORY_COST, r11.optLong(KEY_MEMORY_COST_FROM, -1));
        JSONObject r15 = new JSONObject();
        r15.put(KEY_IMAGE_URL, r11.optString(KEY_IMAGE_URL, ""));
        formatEventReporter(null, r10, r11, r5, r15);
        TraceEvent.a(0, "LynxMonitorServiceProxy.reportImageStatus");
    }

    public void reportResourceStatus(LynxView r5, String r10, JSONObject r11, JSONObject r12) {
        Intrinsics.checkNotNullParameter(r5, "view");
        Intrinsics.checkNotNullParameter(r10, "eventName");
        Intrinsics.checkNotNullParameter(r11, "data");
        TraceEvent.c("LynxMonitorServiceProxy.reportResourceStatus");
        com.bytedance.android.monitorV2.lynx.d.f3638a.getClass();
        com.bytedance.android.monitorV2.lynx.d.f(r5, r10, r11);
        TraceEvent.a(0, "LynxMonitorServiceProxy.reportResourceStatus");
    }

    public void reportTrailEvent(String r10, JSONObject r11) {
        Intrinsics.checkNotNullParameter(r10, "eventName");
        Intrinsics.checkNotNullParameter(r11, "data");
        TraceEvent.c("LynxMonitorServiceProxy.reportImageStatus");
        JSONObject r12 = new JSONObject();
        JSONObject r5 = r11.optJSONObject(KEY_PAGE_CONFIG);
        if (r5 == null) goto L8;
        Iterator<String> r13 = r5.keys();
    L6:
        if (r13.hasNext() == false) goto L8;
        String r14 = r13.next();
        r12.put(r14, r5.get(r14));
    L8:
        JSONObject r15 = new JSONObject();
        JSONObject r16 = r11.optJSONObject(KEY_METRIC);
        if (r16 == null) goto L40;
        JSONObject r17 = r16.optJSONObject(KEY_METRICS);
        if (r17 == null) goto L16;
        Iterator<String> r18 = r17.keys();
    L14:
        if (r18.hasNext() == false) goto L16;
        String r19 = r18.next();
        r15.put(r19, r17.get(r19));
    L16:
        JSONObject r20 = r16.optJSONObject(KEY_SETUP_TIMING);
        if (r20 == null) goto L22;
        Iterator<String> r21 = r20.keys();
    L20:
        if (r21.hasNext() == false) goto L22;
        String r22 = r21.next();
        r15.put(r22, r20.get(r22));
    L22:
        JSONObject r23 = r16.optJSONObject(KEY_EXTRA_TIMING);
        if (r23 == null) goto L28;
        Iterator<String> r24 = r23.keys();
    L26:
        if (r24.hasNext() == false) goto L28;
        String r25 = r24.next();
        r15.put(r25, r23.get(r25));
    L28:
        JSONObject r26 = r16.optJSONObject(KEY_UPDATE_TIMING);
        if (r26 == null) goto L34;
        Iterator<String> r27 = r26.keys();
    L32:
        if (r27.hasNext() == false) goto L34;
        String r28 = r27.next();
        r15.put(r28, r26.get(r28));
    L34:
        JSONObject r29 = r16.optJSONObject(KEY_MEMORY);
        if (r29 == null) goto L40;
        Iterator<String> r30 = r29.keys();
    L38:
        if (r30.hasNext() == false) goto L40;
        String r31 = r30.next();
        r15.put(r31, r29.get(r31));
    L40:
        formatEventReporter(null, r10, r11, r15, r12);
        TraceEvent.a(0, "LynxMonitorServiceProxy.reportImageStatus");
    }
}
