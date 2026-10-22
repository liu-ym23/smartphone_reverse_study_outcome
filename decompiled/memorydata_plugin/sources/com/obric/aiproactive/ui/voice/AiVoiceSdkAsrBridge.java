package com.obric.aiproactive.ui.voice;

import android.content.Context;
import android.media.AudioRecord;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.security.obric.guard.ObricSecurityGuardStub;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.aivoice.sdk.AIVoiceTask;
import com.obric.cae.userAware.SubwayFusionAware.SubwayUtils;
import com.obric.capabilitykit.common.ErrorCode;
import com.obric.memorydata.database.entity.ChatMessage;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0006\u0018\u0000 M2\u00020\u0001:\u0002MNB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010#\u001a\u00020\u0017JR\u0010$\u001a\u00020!2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00170&2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u00170\u00162\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00170\u00162\u0014\u0010\u0018\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0012\u0004\u0012\u00020\u00170\u0016J\u0006\u0010)\u001a\u00020\u0017J\u0006\u0010*\u001a\u00020\u0017J2\u0010+\u001a\u00020\u00172\u0006\u0010,\u001a\u00020\u00102\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00170&2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u00170\u0016H\u0002J4\u0010-\u001a\u00020\u00172\u0006\u0010,\u001a\u00020\u00102\u0006\u0010.\u001a\u00020\u00142\u0006\u0010/\u001a\u00020(2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u00170\u0016H\u0002J\u0010\u00100\u001a\u00020\u00172\u0006\u0010,\u001a\u00020\u0010H\u0002J\u0018\u00101\u001a\u00020\u00172\u0006\u0010,\u001a\u00020\u00102\u0006\u00102\u001a\u00020\u0010H\u0002J\u0018\u00103\u001a\u00020\u00172\u0006\u0010,\u001a\u00020\u00102\u0006\u00104\u001a\u00020\u0010H\u0002J\u001f\u00105\u001a\u00020\u00172\u0006\u0010,\u001a\u00020\u00102\b\u00106\u001a\u0004\u0018\u00010\u0019H\u0002¢\u0006\u0002\u00107J\u0010\u00108\u001a\u00020\u00172\u0006\u0010,\u001a\u00020\u0010H\u0002J\u0010\u00109\u001a\u00020\u00172\u0006\u0010,\u001a\u00020\u0010H\u0002J\b\u0010:\u001a\u00020\u0017H\u0002J\b\u0010;\u001a\u00020\u0017H\u0002J\u0010\u0010<\u001a\u00020\u00172\u0006\u0010.\u001a\u00020\u0014H\u0002J\u0018\u0010=\u001a\u00020!2\u0006\u0010,\u001a\u00020\u00102\u0006\u0010>\u001a\u00020\u0012H\u0002J\u0010\u0010?\u001a\u00020\u00122\u0006\u0010,\u001a\u00020\u0010H\u0002J\u0010\u0010@\u001a\u00020\u001f2\u0006\u0010,\u001a\u00020\u0010H\u0002J\b\u0010A\u001a\u00020\u001fH\u0002J\u0010\u0010B\u001a\u00020\u00102\u0006\u0010,\u001a\u00020\u0010H\u0002J \u0010C\u001a\u00020\u00102\u0006\u0010,\u001a\u00020\u00102\u0006\u0010D\u001a\u00020\u00192\u0006\u0010E\u001a\u00020!H\u0002J'\u0010F\u001a\u0004\u0018\u00010\u0010*\u00020G2\u0012\u0010H\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00100I\"\u00020\u0010H\u0002¢\u0006\u0002\u0010JJ\u0014\u0010K\u001a\u00020!*\u00020G2\u0006\u0010L\u001a\u00020\u0010H\u0002R\u0018\u0010\u0006\u001a\n \u0007*\u0004\u0018\u00010\u00030\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u000b\u001a\n \u0007*\u0004\u0018\u00010\f0\fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u000e\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0018\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010 \u001a\u00020!8F¢\u0006\u0006\u001a\u0004\b \u0010\"¨\u0006O"}, d2 = {"Lcom/obric/aiproactive/ui/voice/AiVoiceSdkAsrBridge;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "applicationContext", "kotlin.jvm.PlatformType", "Landroid/content/Context;", "mainHandler", "Landroid/os/Handler;", "worker", "Ljava/util/concurrent/ExecutorService;", "Ljava/util/concurrent/ExecutorService;", "stateLock", "activeTaskId", "", "finishAction", "Lcom/obric/aiproactive/ui/voice/AiVoiceSdkAsrBridge$FinishAction;", "recorder", "Landroid/media/AudioRecord;", "onSuccess", "Lkotlin/Function1;", "", "onFailure", "", "historyText", "currentText", "timeoutRunnable", "Ljava/lang/Runnable;", "transcriptionStartedAtMs", "", "isRunning", "", "()Z", "warmUp", CommonConsts.APM_INNER_EVENT_COST_START, "onRealStart", "Lkotlin/Function0;", "onAudioData", "", "stop", ObricSecurityGuardStub.SettingsEventConst.EVENT_RESULT_CANCEL, "startCapture", "taskId", "captureLoop", "audioRecord", "buffer", "finishPcmStream", "handleAsrResponse", ChatMessage.TYPE_RESPONSE, "finishSuccess", "transcript", "finishFailure", "errorCode", "(Ljava/lang/String;Ljava/lang/Integer;)V", "cleanupCancelledStart", "clearActiveState", "clearActiveStateLocked", "clearTimeout", "stopAndRelease", "isActive", "requiredAction", "finishActionFor", "transcriptionLatencyMs", "transcriptionLatencyMsLocked", "buildAsrConfig", "buildAsrData", "size", "writeEnd", "stringIgnoringCase", "Lorg/json/JSONObject;", "expectedKeys", "", "(Lorg/json/JSONObject;[Ljava/lang/String;)Ljava/lang/String;", "booleanIgnoringCase", "expectedKey", "Companion", "FinishAction", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AiVoiceSdkAsrBridge {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f6900a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f6901b;
    private final Handler c;
    private final ExecutorService d;
    private final Object e;
    private volatile String f;
    private FinishAction g;
    private AudioRecord h;
    private Function1<? super String, Unit> i;
    private Function1<? super Integer, Unit> j;
    private String k;
    private String l;
    private Runnable m;
    private long n;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/aiproactive/ui/voice/AiVoiceSdkAsrBridge$FinishAction;", "", "<init>", "(Ljava/lang/String;I)V", "NONE", "SEND", "CANCEL", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final enum FinishAction extends Enum<FinishAction> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ FinishAction[] $VALUES = null;
        public static final FinishAction CANCEL = null;
        public static final FinishAction NONE = null;
        public static final FinishAction SEND = null;

        private static final /* synthetic */ FinishAction[] $values() {
            return new FinishAction[]{NONE, SEND, CANCEL};
        }

        static {
            NONE = new FinishAction("NONE", 0);
            SEND = new FinishAction("SEND", 1);
            CANCEL = new FinishAction("CANCEL", 2);
            FinishAction[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
        }

        private FinishAction(String r1, int r2) {
            super(r1, r2);
        }

        public static EnumEntries<FinishAction> getEntries() {
            return $ENTRIES;
        }

        public static FinishAction valueOf(String r2) {
            return (FinishAction) ZeusTransformUtils.preCheckCast(Enum.valueOf(FinishAction.class, r2), FinishAction.class, "com.obric.memorydata.plugin");
        }

        public static FinishAction[] values() {
            return (FinishAction[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), FinishAction[].class, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/aiproactive/ui/voice/AiVoiceSdkAsrBridge$Companion;", "", "<init>", "()V", "TAG", "", "SAMPLE_RATE_HZ", "", "PCM_BUFFER_BYTES", "SERVICE_CONNECT_TIMEOUT_MS", "", "RESULT_TIMEOUT_MS", "ASR_TYPE_RECOMMENDED", "SDK_FAILURE", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6902a = null;

        static {
            int[] r0 = new int[FinishAction.values().length];
            r0[FinishAction.CANCEL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[FinishAction.NONE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[FinishAction.SEND.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f6902a = r0;
        }
    }

    static {
        f6900a = new a(null);
    }

    public AiVoiceSdkAsrBridge(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        this.f6901b = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        this.c = new Handler(Looper.getMainLooper());
        this.d = Executors.newSingleThreadExecutor($$Lambda$AiVoiceSdkAsrBridge$dU8CbkAjttWVttwUP7LtC_EGnQ.INSTANCE);
        this.e = new Object();
        this.g = FinishAction.NONE;
        this.k = "";
        this.l = "";
    }

    private final String a(String r2, int r3, boolean r4) {
        JSONObject r1 = new JSONObject();
        r1.put("taskId", r2);
        r1.put("size", r3);
        r1.put("writeEnd", r4);
        String r5 = r1.toString();
        Intrinsics.checkNotNullExpressionValue(r5, "toString(...)");
        return r5;
    }

    private final String a(JSONObject r10, String... r11) {
        Iterator<String> r9 = r10.keys();
        Intrinsics.checkNotNullExpressionValue(r9, "keys(...)");
        Iterator r12 = SequencesKt.asSequence(r9).iterator();
    L3:
        boolean r1 = false;
        if (r12.hasNext() == false) goto L14;
        Object r0 = r12.next();
        String r5 = (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin");
        int r6 = r11.length;
        int r7 = 0;
    L6:
        if (r7 >= r6) goto L11;
        if (StringsKt.equals(r5, r11[r7], true) == true) goto L9;
        r7 = r7 + 1;
        goto L6
    L9:
        boolean r8 = true;
    L12:
        if (r8 == false) goto L3;
    L15:
        String r13 = (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin");
        if (r13 != null) goto L18;
        return null;
    L18:
        String r14 = r10.optString(r13);
        Intrinsics.checkNotNull(r14);
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L21;
        r1 = true;
    L21:
        if (r1 == true) goto L23;
        return null;
    L23:
        return r14;
    L11:
        r8 = false;
        goto L12
    L14:
        r0 = null;
        goto L15
    }

    private static final Thread a(Runnable r2) {
        Thread r0 = new Thread((Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.memorydata.plugin"), "AiProactiveAIVoiceAsr");
        r0.setDaemon(true);
        return r0;
    }

    private static final Unit a(AiVoiceSdkAsrBridge r1, String r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, ChatMessage.TYPE_RESPONSE);
        r1.a(r2, r3);
        return Unit.INSTANCE;
    }

    private final void a(AudioRecord r6) {
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
            int r5 = r6.getRecordingState()     // Catch: java.lang.Throwable -> Le java.lang.IllegalStateException -> L10
            r0 = 3
            if (r5 != r0) goto La
            r6.stop()     // Catch: java.lang.Throwable -> Le java.lang.IllegalStateException -> L10
        La:
            r6.release()
            goto L25
        Le:
            r5 = move-exception
            goto L26
        L10:
            r5 = move-exception
            com.obric.memorydata.middleware.api.log.RunLog r0 = com.obric.memorydata.middleware.api.log.RunLog.INSTANCE     // Catch: java.lang.Throwable -> Le
            java.lang.String r1 = "AiVoiceSdkAsr"
            java.lang.String r2 = "AudioRecord stop state failure"
            java.lang.Class<java.lang.Throwable> r3 = java.lang.Throwable.class
            java.lang.String r4 = "com.obric.memorydata.plugin"
            java.lang.Object r5 = com.volcengine.zeus.transform.ZeusTransformUtils.preCheckCast(r5, r3, r4)     // Catch: java.lang.Throwable -> Le
            java.lang.Throwable r5 = (java.lang.Throwable) r5     // Catch: java.lang.Throwable -> Le
            r0.warn(r1, r2, r5)     // Catch: java.lang.Throwable -> Le
            goto La
        L25:
            return
        L26:
            r6.release()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.obric.aiproactive.ui.voice.AiVoiceSdkAsrBridge.a(android.media.AudioRecord):void");
    }

    private static final void a(AiVoiceSdkAsrBridge r2) {
        com.obric.aiproactive.ui.voice.a r0 = com.obric.aiproactive.ui.voice.a.f6903a;
        Context r3 = r2.f6901b;
        Intrinsics.checkNotNullExpressionValue(r3, "applicationContext");
        r0.a(r3);
    }

    private static final void a(AiVoiceSdkAsrBridge r7, String r8) {
        if (Intrinsics.areEqual(r7.f, r8) == false) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AiVoiceSdkAsr", "AIVoice final result timeout", null, 4, null);
        AIVoiceTask.INSTANCE.removeAsrTask(r8);
        r7.a(r8, null);
        return;
    }

    private static final void a(AiVoiceSdkAsrBridge r2, String r3, Function0 r4) {
        Function0 r5 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r2.f, r3) == false) goto L6;
        r5.invoke();
        return;
    }

    private static final void a(AiVoiceSdkAsrBridge r6, String r7, Function0 r8, Function1 r9) {
        Function0<Unit> r10 = (Function0) ZeusTransformUtils.wrapperContextForParams(r8, Function0.class, "com.obric.memorydata.plugin");
        Function1<? super byte[], Unit> r11 = (Function1) ZeusTransformUtils.wrapperContextForParams(r9, Function1.class, "com.obric.memorydata.plugin");
        com.obric.aiproactive.ui.voice.a r0 = com.obric.aiproactive.ui.voice.a.f6903a;
        Context r2 = r6.f6901b;
        Intrinsics.checkNotNullExpressionValue(r2, "applicationContext");
        r0.a(r2);
        if (com.obric.aiproactive.ui.voice.a.f6903a.a(5000) == true) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AiVoiceSdkAsr", "AIVoice service connection timeout", null, 4, null);
        r6.a(r7, null);
        return;
    L6:
        r6.a(r7, r10, r11);
    }

    private static final void a(AiVoiceSdkAsrBridge r2, String r3, Function1 r4, byte[] r5) {
        Function1 r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r2.f, r3) == false) goto L6;
        r6.invoke(r5);
        return;
    }

    private final void a(final String r5) {
        int r0 = AIVoiceTask.INSTANCE.writeAsrData(new byte[0], a(r5, 0, true));
        if (r0 != (-1)) goto L6;
        AIVoiceTask.INSTANCE.removeAsrTask(r5);
        a(r5, Integer.valueOf(r0));
        return;
    L6:
        Runnable r1 = new $$Lambda$AiVoiceSdkAsrBridge$SsxnvEYQ3jilrmjz8S7T7VgK0I(this, r5);
        Object r2 = this.e;
        monitor-enter(r2);
    L16:
        th = move-exception;
        throw th;
    L9:
        if (Intrinsics.areEqual(this.f, r5) == true) goto L12;
        monitor-exit(r2);
        return;
    L12:
        this.m = r1;     // Catch: Throwable -> L16
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L16
        monitor-exit(r2);
        this.c.postDelayed(r1, SubwayUtils.OUTDOOR_PUNISH_DELAY_TIME);
    }

    private final void a(final String r9, AudioRecord r10, byte[] r11, Function1<? super byte[], Unit> r12) {
        final Function1 r13 = (Function1) ZeusTransformUtils.wrapperContextForParams(r12, Function1.class, "com.obric.memorydata.plugin");
    L3:
        boolean r2 = false;
        if (a(r9, FinishAction.NONE) == false) goto L13;
        int r0 = r10.read(r11, 0, r11.length);
        if (r0 <= 0) goto L7;
        final byte[] r3 = Arrays.copyOf(r11, r0);
        Intrinsics.checkNotNullExpressionValue(r3, "copyOf(...)");
        if (AIVoiceTask.INSTANCE.writeAsrData(r3, a(r9, r0, false)) == (-1)) goto L11;
        this.c.post(new $$Lambda$AiVoiceSdkAsrBridge$D08WijgQndvuLObhmaclZm4odcU(this, r9, r13, r3));
        goto L3
    L11:
        IRunLog r4 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        String r5 = "AiVoiceSdkAsr";
        String r6 = "AIVoice PCM write failed";
    L8:
        IRunLog.a.a(r4, r5, r6, null, 4, null);
        r2 = true;
        goto L13
    L7:
        r4 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r5 = "AiVoiceSdkAsr";
        r6 = "AudioRecord read failed code=" + r0;
    L13:
        a(r10);
        Object r14 = this.e;
        monitor-enter(r14);
    L34:
        th = move-exception;
        throw th;
    L16:
        if (Intrinsics.areEqual(this.f, r9) == false) goto L18;
        this.h = null;     // Catch: Throwable -> L34
    L18:
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L34
        monitor-exit(r14);
        if (r2 == false) goto L23;
        AIVoiceTask.INSTANCE.removeAsrTask(r9);
        a(r9, null);
        return;
    L23:
        int r16 = b.f6902a[d(r9).ordinal()];
        if (r16 != 1) goto L26;
    L32:
        AIVoiceTask.INSTANCE.removeAsrTask(r9);
        c(r9);
        return;
    L26:
        if (r16 == 2) goto L32;
        if (r16 != 3) goto L31;
        a(r9);
        return;
    L31:
        throw new NoWhenBranchMatchedException();
    }

    private final void a(String r13, final Integer r14) {
        Object r0 = this.e;
        monitor-enter(r0);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (Intrinsics.areEqual(this.f, r13) == true) goto L8;
        monitor-exit(r0);
        return;
    L8:
        Function1<? super Integer, Unit> r1 = this.j;     // Catch: Throwable -> L15
        Runnable r2 = this.m;     // Catch: Throwable -> L15
        long r3 = f();     // Catch: Throwable -> L15
        d();     // Catch: Throwable -> L15
        final Triple r5 = new Triple(r1, r2, Long.valueOf(r3));     // Catch: Throwable -> L15
        monitor-exit(r0);
        Runnable r4 = (Runnable) ZeusTransformUtils.preCheckCast(r5.getSecond(), Runnable.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L13;
        this.c.removeCallbacks(r4);
    L13:
        com.obric.aiproactive.ui.voice.a.f6903a.a(r13);
        AIVoiceTask.INSTANCE.removeAsrTask(r13);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AiVoiceSdkAsr", "AIVoice transcription failed latencyMs=" + ((Number) ZeusTransformUtils.preCheckCast(r5.getThird(), Number.class, "com.obric.memorydata.plugin")).longValue(), null, 4, null);
        this.c.post(new $$Lambda$AiVoiceSdkAsrBridge$pWlptmJvcIVSgUbX6a8y_7kFw(r5, r14));
    }

    private final void a(String r9, String r10) {
        if (Intrinsics.areEqual(this.f, r9) == true) goto L59;
        return;
    L59:
        JSONObject r0 = new JSONObject(r10);     // Catch: JSONException -> L56
        String r11 = a(r0, new String[]{"errorCode", "code"});
        CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin");
        boolean r2 = false;
        if (r1 != null) goto L9;
    L12:
        boolean r3 = true;
    L13:
        if (r3 == false) goto L15;
    L18:
        String r12 = a(r0, new String[]{IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT});
        boolean r4 = a(r0, "vadEnd");
        boolean r5 = a(r0, "asrEnd");
        String r6 = a(r0, new String[]{"asrState", "state"});
        Object r7 = this.e;
        monitor-enter(r7);
    L53:
        th = move-exception;
        throw th;
    L21:
        if (Intrinsics.areEqual(this.f, r9) == true) goto L24;
        monitor-exit(r7);
        return;
    L24:
        CharSequence r8 = (CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L53
        if (r8 != null) goto L27;
    L30:
        boolean r13 = true;
    L31:
        if (r13 == true) goto L33;
        this.l = r12;     // Catch: Throwable -> L53
    L33:
        if (r4 == true) goto L35;
    L39:
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L53
        monitor-exit(r7);
        if (r5 == false) goto L43;
    L44:
        Object r15 = this.e;
        monitor-enter(r15);
        String r16 = this.k + this.l;     // Catch: Throwable -> L50
        monitor-exit(r15);
        b(r9, r16);
        return;
    L50:
        th = move-exception;
        throw th;
    L43:
        if (StringsKt.equals(r6, "Finished", true) == true) goto L44;
        return;
    L35:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(this.l, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L37;
        r2 = true;
    L37:
        if (r2 == false) goto L39;
        this.k += this.l;     // Catch: Throwable -> L53
        this.l = "";     // Catch: Throwable -> L53
        goto L39
    L27:
        if (r8.length() == 0) goto L30;
        r13 = false;
        goto L31
    L15:
        if (Intrinsics.areEqual(r11, "0") == true) goto L18;
        a(r9, StringsKt.toIntOrNull(r11));
        return;
    L9:
        if (StringsKt.isBlank(r1) == true) goto L12;
        r3 = false;
    L56:
        e = move-exception;
        RunLog.INSTANCE.warn("AiVoiceSdkAsr", "invalid ASR response", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }

    private final void a(final String r10, Function0<Unit> r11, Function1<? super byte[], Unit> r12) {
        final Function0 r13 = (Function0) ZeusTransformUtils.wrapperContextForParams(r11, Function0.class, "com.obric.memorydata.plugin");
        Function1<? super byte[], Unit> r14 = (Function1) ZeusTransformUtils.wrapperContextForParams(r12, Function1.class, "com.obric.memorydata.plugin");
        if (a(r10, FinishAction.NONE) == false) goto L5;
        int r0 = AIVoiceTask.INSTANCE.createAsrTask(e(r10));
        if (r0 != (-1)) goto L55;
        a(r10, Integer.valueOf(r0));
        return;
    L55:
        AudioRecord r1 = new AudioRecord(6, 16000, 16, 2, Math.max(ErrorCode.Memory.ERROR_UPDATE_BUT_TYPE_NOT_SUPPORT, RangesKt.coerceAtLeast(AudioRecord.getMinBufferSize(16000, 16, 2), 0)));     // Catch: SecurityException -> L48 IllegalArgumentException -> L51
    L16:
        if (r1.getState() == 1) goto L19;
        r1.release();
        AIVoiceTask.INSTANCE.removeAsrTask(r10);
        a(r10, null);
        return;
    L19:
        Object r3 = this.e;
        monitor-enter(r3);
    L45:
        th = move-exception;
        throw th;
    L22:
        if (Intrinsics.areEqual(this.f, r10) == true) goto L24;
    L27:
        FinishAction r4 = d(r10);     // Catch: Throwable -> L45
    L28:
        monitor-exit(r3);
        if (r4 == FinishAction.NONE) goto L57;
        r1.release();
        if (r4 != FinishAction.SEND) goto L34;
        a(r10, null);
        return;
    L34:
        AIVoiceTask.INSTANCE.removeAsrTask(r10);
        c(r10);
        return;
    L57:
        r1.startRecording();     // Catch: SecurityException -> L39 IllegalStateException -> L42
        this.c.post(new $$Lambda$AiVoiceSdkAsrBridge$34nPE2Sfu8gOaAHqPPGVZbZr0fk(this, r10, r13));
        a(r10, r1, new byte[ErrorCode.Memory.ERROR_UPDATE_BUT_TYPE_NOT_SUPPORT], r14);
        return;
    L42:
        e = move-exception;
        RunLog.INSTANCE.error("AiVoiceSdkAsr", "AudioRecord start state failure", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        r1.release();
        AIVoiceTask.INSTANCE.removeAsrTask(r10);
        a(r10, null);
        return;
    L39:
        e = move-exception;
        RunLog.INSTANCE.error("AiVoiceSdkAsr", "AudioRecord start permission failure", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        r1.release();
        AIVoiceTask.INSTANCE.removeAsrTask(r10);
        a(r10, null);
        return;
    L24:
        if (this.g != FinishAction.NONE) goto L27;
        this.h = r1;     // Catch: Throwable -> L45
        r4 = FinishAction.NONE;     // Catch: Throwable -> L45
    L51:
        e = move-exception;
        RunLog.INSTANCE.error("AiVoiceSdkAsr", "AudioRecord configuration failure", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        AIVoiceTask.INSTANCE.removeAsrTask(r10);
        a(r10, null);
        return;
    L48:
        e = move-exception;
        RunLog.INSTANCE.error("AiVoiceSdkAsr", "AudioRecord permission failure", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        AIVoiceTask.INSTANCE.removeAsrTask(r10);
        a(r10, null);
        return;
    L5:
        if (d(r10) != FinishAction.SEND) goto L7;
        a(r10, null);
        return;
    L7:
        b(r10);
    }

    private static final void a(Triple r2, Integer r3) {
        Function1 r4 = (Function1) ZeusTransformUtils.preCheckCast(r2.getFirst(), Function1.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L6;
        r4.invoke(r3);
        return;
    }

    private static final void a(Triple r2, String r3) {
        Function1 r4 = (Function1) ZeusTransformUtils.preCheckCast(r2.getFirst(), Function1.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L6;
        r4.invoke(r3);
        return;
    }

    private final boolean a(String r3, FinishAction r4) {
        Object r0 = this.e;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (Intrinsics.areEqual(this.f, r3) == false) goto L9;
        if (this.g != r4) goto L9;
        boolean r2 = true;
    L10:
        monitor-exit(r0);
        return r2;
    L9:
        r2 = false;
        goto L10
    }

    private final boolean a(JSONObject r5, String r6) {
        Iterator<String> r4 = r5.keys();
        Intrinsics.checkNotNullExpressionValue(r4, "keys(...)");
        Iterator r7 = SequencesKt.asSequence(r4).iterator();
    L4:
        if (r7.hasNext() == false) goto L8;
        Object r0 = r7.next();
        if (StringsKt.equals((String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin"), r6, true) == false) goto L4;
    L9:
        String r8 = (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin");
        if (r8 != null) goto L13;
        return false;
    L13:
        return r5.optBoolean(r8, false);
    L8:
        r0 = null;
        goto L9
    }

    private final void b(String r2) {
        if (Intrinsics.areEqual(this.f, r2) == false) goto L6;
        c(r2);
        return;
    }

    private final void b(String r13, final String r14) {
        Object r0 = this.e;
        monitor-enter(r0);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (Intrinsics.areEqual(this.f, r13) == true) goto L8;
        monitor-exit(r0);
        return;
    L8:
        Function1<? super String, Unit> r1 = this.i;     // Catch: Throwable -> L15
        Runnable r2 = this.m;     // Catch: Throwable -> L15
        long r3 = f();     // Catch: Throwable -> L15
        d();     // Catch: Throwable -> L15
        final Triple r5 = new Triple(r1, r2, Long.valueOf(r3));     // Catch: Throwable -> L15
        monitor-exit(r0);
        Runnable r4 = (Runnable) ZeusTransformUtils.preCheckCast(r5.getSecond(), Runnable.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L13;
        this.c.removeCallbacks(r4);
    L13:
        com.obric.aiproactive.ui.voice.a.f6903a.a(r13);
        AIVoiceTask.INSTANCE.removeAsrTask(r13);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AiVoiceSdkAsr", "AIVoice transcription completed latencyMs=" + ((Number) ZeusTransformUtils.preCheckCast(r5.getThird(), Number.class, "com.obric.memorydata.plugin")).longValue(), false, 4, null);
        this.c.post(new $$Lambda$AiVoiceSdkAsrBridge$D58b1e__6C4n0zF6UHhHt53UvjM(r5, r14));
    }

    private final void c(String r3) {
        Object r0 = this.e;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (Intrinsics.areEqual(this.f, r3) == false) goto L7;
        d();     // Catch: Throwable -> L11
    L7:
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r0);
        com.obric.aiproactive.ui.voice.a.f6903a.a(r3);
    }

    private final FinishAction d(String r3) {
        Object r0 = this.e;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (Intrinsics.areEqual(this.f, r3) == false) goto L7;
        FinishAction r2 = this.g;     // Catch: Throwable -> L10
    L8:
        monitor-exit(r0);
        return r2;
    L7:
        r2 = FinishAction.CANCEL;     // Catch: Throwable -> L10
        goto L8
    }

    private final void d() {
        this.f = null;
        this.g = FinishAction.NONE;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = "";
        this.l = "";
        this.m = null;
        this.n = 0;
    }

    private final String e(String r3) {
        JSONObject r0 = new JSONObject();
        r0.put("taskId", r3);
        r0.put("format", "pcm");
        r0.put("samplRate", "16000");
        r0.put("bits", "16");
        r0.put("channel", "1");
        r0.put(ObricMemoryConstants.KEY_PACKAGE_NAME, this.f6901b.getPackageName());
        r0.put("asrType", 3);
        r0.put("endByClient", true);
        String r2 = r0.toString();
        Intrinsics.checkNotNullExpressionValue(r2, "toString(...)");
        return r2;
    }

    private final void e() {
        Object r0 = this.e;
        monitor-enter(r0);
        Runnable r1 = this.m;     // Catch: Throwable -> L9
        this.m = null;     // Catch: Throwable -> L9
        monitor-exit(r0);
        if (r1 == null) goto L14;
        this.c.removeCallbacks(r1);
        return;
    L14:
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private final long f() {
        Long r6 = Long.valueOf(this.n);
        if (((Number) ZeusTransformUtils.preCheckCast(r6, Number.class, "com.obric.memorydata.plugin")).longValue() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L9;
        r6 = null;
    L9:
        if (r6 == null) goto L12;
        long r1 = ((Number) ZeusTransformUtils.preCheckCast(r6, Number.class, "com.obric.memorydata.plugin")).longValue();
        return SystemClock.elapsedRealtime() - r1;
    L12:
        return 0;
    L5:
        r0 = false;
        goto L6
    }

    private static final void f(String r1) {
        AIVoiceTask.INSTANCE.removeAsrTask(r1);
    }

    public static /* synthetic */ void lambda$34nPE2Sfu8gOaAHqPPGVZbZr0fk(AiVoiceSdkAsrBridge r0, String r1, Function0 r2) {
        a(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$D08WijgQndvuLObhmaclZm4odcU(AiVoiceSdkAsrBridge r0, String r1, Function1 r2, byte[] r3) {
        a(r0, r1, r2, r3);
    }

    public static /* synthetic */ void lambda$D58b1e__6C4n0zF6UHhHt53UvjM(Triple r0, String r1) {
        a(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$H8nrfvMvzdC4xGsLI-BgpPJEYXI, reason: not valid java name */
    public static /* synthetic */ Unit m354lambda$H8nrfvMvzdC4xGsLIBgpPJEYXI(AiVoiceSdkAsrBridge r0, String r1, String r2) {
        return a(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$SsxnvEY-Q3jilrmjz8S7T7VgK0I, reason: not valid java name */
    public static /* synthetic */ void m355lambda$SsxnvEYQ3jilrmjz8S7T7VgK0I(AiVoiceSdkAsrBridge r0, String r1) {
        a(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$dU8CbkAjttWVttwUP-7LtC_EGnQ, reason: not valid java name */
    public static /* synthetic */ Thread m356lambda$dU8CbkAjttWVttwUP7LtC_EGnQ(Runnable r0) {
        return a(r0);
    }

    public static /* synthetic */ void lambda$jt4l996n4UTJWmzGU8pmukQwpFY(AiVoiceSdkAsrBridge r0, String r1, Function0 r2, Function1 r3) {
        a(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: lambda$p-WlptmJvcIVSgUbX6-a8y_7kFw, reason: not valid java name */
    public static /* synthetic */ void m357lambda$pWlptmJvcIVSgUbX6a8y_7kFw(Triple r0, Integer r1) {
        a(r0, r1);
    }

    public static /* synthetic */ void lambda$rzX4dLPlyhnmtMw6jNpXuuAxQ8w(String r0) {
        f(r0);
    }

    public static /* synthetic */ void lambda$vB03uoJ8DFrY3r82clAfhjob1v0(AiVoiceSdkAsrBridge r0) {
        a(r0);
    }

    public final void a() {
        this.d.execute(new $$Lambda$AiVoiceSdkAsrBridge$vB03uoJ8DFrY3r82clAfhjob1v0(this));
    }

    public final boolean a(Function0<Unit> r4, Function1<? super byte[], Unit> r5, Function1<? super String, Unit> r6, Function1<? super Integer, Unit> r7) {
        final Function0 r8 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
        final Function1 r9 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        Function1<? super String, Unit> r10 = (Function1) ZeusTransformUtils.wrapperContextForParams(r6, Function1.class, "com.obric.memorydata.plugin");
        Function1<? super Integer, Unit> r11 = (Function1) ZeusTransformUtils.wrapperContextForParams(r7, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "onRealStart");
        Intrinsics.checkNotNullParameter(r9, "onAudioData");
        Intrinsics.checkNotNullParameter(r10, "onSuccess");
        Intrinsics.checkNotNullParameter(r11, "onFailure");
        c();
        final String r0 = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(r0, "toString(...)");
        Object r1 = this.e;
        monitor-enter(r1);
        this.f = r0;     // Catch: Throwable -> L8
        this.g = FinishAction.NONE;     // Catch: Throwable -> L8
        this.i = r10;     // Catch: Throwable -> L8
        this.j = r11;     // Catch: Throwable -> L8
        this.k = "";     // Catch: Throwable -> L8
        this.l = "";     // Catch: Throwable -> L8
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L8
        monitor-exit(r1);
        com.obric.aiproactive.ui.voice.a.f6903a.a(r0, new $$Lambda$AiVoiceSdkAsrBridge$H8nrfvMvzdC4xGsLIBgpPJEYXI(this, r0));
        this.d.execute(new $$Lambda$AiVoiceSdkAsrBridge$jt4l996n4UTJWmzGU8pmukQwpFY(this, r0, r8, r9));
        return true;
    L8:
        th = move-exception;
        throw th;
    }

    public final void b() {
        Object r0 = this.e;
        monitor-enter(r0);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (this.f != null) goto L7;
    L12:
        monitor-exit(r0);
        return;
    L7:
        if (this.g != FinishAction.NONE) goto L12;
        this.g = FinishAction.SEND;     // Catch: Throwable -> L14
        this.n = SystemClock.elapsedRealtime();     // Catch: Throwable -> L14
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L14
        monitor-exit(r0);
    }

    public final void c() {
        Object r0 = this.e;
        monitor-enter(r0);
        String r1 = this.f;     // Catch: Throwable -> L23
        if (r1 != null) goto L8;
        monitor-exit(r0);
        return;
    L8:
        this.g = FinishAction.CANCEL;     // Catch: Throwable -> L23
        boolean r3 = true;
        if (this.h != null) goto L11;
        boolean r2 = true;
    L12:
        Pair r4 = TuplesKt.to(r1, Boolean.valueOf(r2));     // Catch: Throwable -> L23
        monitor-exit(r0);
        e();
        final String r5 = (String) ZeusTransformUtils.preCheckCast(r4.component1(), String.class, "com.obric.memorydata.plugin");
        if (((Boolean) ZeusTransformUtils.preCheckCast(r4.component2(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L17;
        c(r5);
        com.obric.aiproactive.ui.voice.a.f6903a.a(r5);
        this.d.execute(new $$Lambda$AiVoiceSdkAsrBridge$rzX4dLPlyhnmtMw6jNpXuuAxQ8w(r5));
    L17:
        IRunLog r6 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r11 = new StringBuilder().append("cancel requested taskActive=");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")).length() > 0) goto L21;
        r3 = false;
    L21:
        IRunLog.a.a(r6, "AiVoiceSdkAsr", r11.append(r3).toString(), false, 4, null);
        return;
    L11:
        r2 = false;
    L23:
        th = move-exception;
        throw th;
    }
}
