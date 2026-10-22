package com.obric.memorydata.aikernelcore.debug;

import android.content.Context;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditActivity;
import com.obric.memorydata.memory.ui.list.MemoryListActivity;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.bridge.IHarnessDebugBridgeAPI;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.FilesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0016\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0017\u001a\u00020\u0000H\u0007J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u0005H\u0002J\u0010\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0005H\u0002J\u0012\u0010\u001c\u001a\u00020\u000f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0019H\u0002J\u0010\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u0005H\u0002J\u0018\u0010 \u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u000fH\u0002J2\u0010\"\u001a\u00020#2\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010%\u001a\u00020#2\b\b\u0002\u0010!\u001a\u00020\u000fH\u0002J\u0018\u0010&\u001a\u00020'2\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u0005H\u0002J\u0018\u0010(\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u0005H\u0002J'\u0010)\u001a\u0004\u0018\u00010\u00052\u0006\u0010*\u001a\u00020\u00192\u0006\u0010+\u001a\u00020\u00192\u0006\u0010$\u001a\u00020\u0005H\u0000¢\u0006\u0002\b,J\u0018\u0010-\u001a\u00020'2\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u0005H\u0002J\u0018\u0010/\u001a\u00020'2\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u0019H\u0002J\u0010\u00100\u001a\u00020'2\u0006\u0010\u001a\u001a\u00020\u0005H\u0016J\u0010\u00101\u001a\u00020\u00052\u0006\u00102\u001a\u00020\u0005H\u0016J\u0010\u00103\u001a\u00020'2\u0006\u0010\u001a\u001a\u00020\u0005H\u0016J\u0010\u00104\u001a\u00020#2\u0006\u0010\u001a\u001a\u00020\u0005H\u0016J\u0010\u00105\u001a\u00020#2\u0006\u0010\u001a\u001a\u00020\u0005H\u0016J\u0010\u00106\u001a\u00020#2\u0006\u0010\u001a\u001a\u00020\u0005H\u0016J\u0010\u00107\u001a\u00020#2\u0006\u0010\u001a\u001a\u00020\u0005H\u0016J\u0010\u00108\u001a\u00020#2\u0006\u0010\u001a\u001a\u00020\u0005H\u0016J\u0010\u00109\u001a\u00020#2\u0006\u0010\u001a\u001a\u00020\u0005H\u0016J\u0010\u0010:\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0005H\u0016J\u0010\u0010;\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0005H\u0016J\u0010\u0010<\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0005H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014¨\u0006="}, d2 = {"Lcom/obric/memorydata/aikernelcore/debug/HarnessDebugBridgeAPIImpl;", "Lcom/obric/memorydata/middleware/api/bridge/IHarnessDebugBridgeAPI;", "<init>", "()V", "TAG", "", "FILE_MANIFEST", "FILE_INPUT_ARGS", "FILE_BRIDGE_CALLS", "FILE_LLM_CALLS", "FILE_EVENTS", "FILE_EXECUTION_LOG", "FILE_RESULT", "TURNS_DIRNAME", "SCHEMA_VERSION", "", "ERROR_REPLAY_MISMATCH", "baseDir", "Ljava/io/File;", "getBaseDir", "()Ljava/io/File;", "baseDir$delegate", "Lkotlin/Lazy;", "getInst", "parsePayload", "Lorg/json/JSONObject;", "data", "extractTraceId", "extractTurnIndex", "payload", "getTraceDir", "traceId", "getTurnDir", "turnIndex", "writeTraceFile", "", "fileName", "append", "ensureTraceFile", "", "findReplayRecord", "checkReplayConsistency", "expected", "recorded", "checkReplayConsistency$aikernel_core_obricRelease", "updateManifestStatus", "status", "appendOrUpdateTurn", "saveTrace", "getLLMMock", Params.PROMPT, "collectLog", "prepareCase", "saveCaseInput", "saveCaseResult", "saveBridgeCall", "saveLLMCall", "saveEvent", "getBridgeReplay", "getLLMReplay", "getEventReplay", "aikernel_core_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class HarnessDebugBridgeAPIImpl implements IHarnessDebugBridgeAPI {
    private static final String ERROR_REPLAY_MISMATCH = "HARNESS_REPLAY_MISMATCH";
    private static final String FILE_BRIDGE_CALLS = "bridge_calls.jsonl";
    private static final String FILE_EVENTS = "events.jsonl";
    private static final String FILE_EXECUTION_LOG = "execution.log";
    private static final String FILE_INPUT_ARGS = "input_args.json";
    private static final String FILE_LLM_CALLS = "llm_calls.jsonl";
    private static final String FILE_MANIFEST = "manifest.json";
    private static final String FILE_RESULT = "result.json";
    public static final HarnessDebugBridgeAPIImpl INSTANCE = null;
    private static final int SCHEMA_VERSION = 2;
    private static final String TAG = "HarnessDebugBridgeAPI";
    private static final String TURNS_DIRNAME = "turns";
    private static final Lazy baseDir$delegate = null;

    static {
        INSTANCE = new HarnessDebugBridgeAPIImpl();
        baseDir$delegate = LazyKt.lazy($$Lambda$HarnessDebugBridgeAPIImpl$jxD_xPUfG1wdFW1GRfUVtxDaP4A.INSTANCE);
    }

    private HarnessDebugBridgeAPIImpl() {
    }

    private final synchronized void appendOrUpdateTurn(String r13, JSONObject r14) {
        monitor-enter(this);
        File r0 = new File(getTraceDir(r13), FILE_MANIFEST);     // Catch: Throwable -> L63 Exception -> L65
        boolean r3 = true;
        if (r0.exists() == false) goto L6;
        JSONObject r15 = new JSONObject(FilesKt.readText$default(r0, null, 1, null));     // Catch: Throwable -> L63 Exception -> L65
    L7:
        JSONArray r1 = r15.optJSONArray(TURNS_DIRNAME);     // Catch: Throwable -> L63 Exception -> L65
        if (r1 != null) goto L10;
        r1 = new JSONArray();     // Catch: Throwable -> L63 Exception -> L65
        r15.put(TURNS_DIRNAME, r1);     // Catch: Throwable -> L63 Exception -> L65
    L10:
        int r5 = r14.optInt("turn_index", -1);     // Catch: Throwable -> L63 Exception -> L65
        if (r5 >= 0) goto L14;
        monitor-exit(this);
        return;
    L14:
        int r7 = r1.length();     // Catch: Throwable -> L63 Exception -> L65
        int r9 = 0;
    L15:
        if (r9 >= r7) goto L22;
        JSONObject r10 = r1.optJSONObject(r9);     // Catch: Throwable -> L63 Exception -> L65
        if (r10 == null) goto L21;
        if (r10.optInt("turn_index", -1) != r5) goto L21;
    L23:
        if (r10 != null) goto L25;
        r10 = new JSONObject().put("turn_index", r5);     // Catch: Throwable -> L63 Exception -> L65
        r1.put(r10);     // Catch: Throwable -> L63 Exception -> L65
    L25:
        String r2 = r14.optString("trigger");     // Catch: Throwable -> L63 Exception -> L65
        Intrinsics.checkNotNull(r2);     // Catch: Throwable -> L63 Exception -> L65
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L28;
        boolean r6 = true;
    L29:
        if (r6 == true) goto L32;
        r2 = null;
    L32:
        if (r2 == null) goto L34;
        r10.put("trigger", r2);     // Catch: Throwable -> L63 Exception -> L65
    L34:
        String r4 = r14.optString("started_at");     // Catch: Throwable -> L63 Exception -> L65
        Intrinsics.checkNotNull(r4);     // Catch: Throwable -> L63 Exception -> L65
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L37;
        boolean r8 = true;
    L38:
        if (r8 == true) goto L41;
        r4 = null;
    L41:
        if (r4 == null) goto L43;
        r10.put("started_at", r4);     // Catch: Throwable -> L63 Exception -> L65
    L43:
        String r11 = r14.optString("finished_at");     // Catch: Throwable -> L63 Exception -> L65
        Intrinsics.checkNotNull(r11);     // Catch: Throwable -> L63 Exception -> L65
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L46;
        boolean r12 = true;
    L47:
        if (r12 == true) goto L50;
        r11 = null;
    L50:
        if (r11 == null) goto L52;
        r10.put("finished_at", r11);     // Catch: Throwable -> L63 Exception -> L65
    L52:
        String r16 = r14.optString("status");     // Catch: Throwable -> L63 Exception -> L65
        Intrinsics.checkNotNull(r16);     // Catch: Throwable -> L63 Exception -> L65
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r16, CharSequence.class, "com.obric.memorydata.plugin")).length() > 0) goto L56;
        r3 = false;
    L56:
        if (r3 == true) goto L59;
        r16 = null;
    L59:
        if (r16 == null) goto L61;
        r10.put("status", r16);     // Catch: Throwable -> L63 Exception -> L65
    L61:
        String r17 = r15.toString();     // Catch: Throwable -> L63 Exception -> L65
        Intrinsics.checkNotNullExpressionValue(r17, "toString(...)");     // Catch: Throwable -> L63 Exception -> L65
        FilesKt.writeText$default(r0, r17, null, 2, null);     // Catch: Throwable -> L63 Exception -> L65
    L67:
        monitor-exit(this);
        return;
    L46:
        r12 = false;
        goto L47
    L37:
        r8 = false;
        goto L38
    L28:
        r6 = false;
    L21:
        r9 = r9 + 1;     // Catch: Throwable -> L63 Exception -> L65
        goto L15
    L22:
        r10 = null;
        goto L23
    L6:
        r15 = new JSONObject().put("schema_version", 2).put("trace_id", r13);     // Catch: Throwable -> L63 Exception -> L65
    L65:
        e = move-exception;
        RunLog.INSTANCE.error(TAG, "Failed to append turn", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L63
    L63:
        th = move-exception;
        throw th;
    }

    private static final File baseDir_delegate$lambda$1() {
        File r0 = new File(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getExternalFilesDir(null), "harness_traces");
        if (r0.exists() == true) goto L5;
        r0.mkdirs();
    L5:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "Harness baseDir=" + r0.getAbsolutePath(), false, 4, null);
        return r0;
    }

    private final void ensureTraceFile(String r5, String r6) {
        File r1 = new File(getTraceDir(r5), r6);     // Catch: Exception -> L7
        if (r1.exists() == true) goto L12;
        FilesKt.writeText$default(r1, "", null, 2, null);     // Catch: Exception -> L7
        RunLog.INSTANCE.debug(TAG, "ensureTraceFile created traceId=" + r5 + " file=" + r1.getAbsolutePath());     // Catch: Exception -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        RunLog.INSTANCE.error(TAG, "Failed to ensure trace file: " + r6, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }

    private final String extractTraceId(String r3) {
        JSONObject r2 = parsePayload(r3);
        String r4 = null;
        if (r2 == null) goto L5;
        String r5 = r2.optString("trace_id");
    L6:
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L9;
    L12:
        boolean r1 = true;
    L13:
        if (r1 == true) goto L15;
        r4 = r5;
    L15:
        if (r4 != null) goto L18;
        return "unknown_trace";
    L18:
        return r4;
    L9:
        if (StringsKt.isBlank(r0) == true) goto L12;
        r1 = false;
        goto L13
    L5:
        r5 = null;
        goto L6
    }

    private final int extractTurnIndex(JSONObject r3) {
        if (r3 != null) goto L6;
        return -1;
    L6:
        if (r3.has("turn_index") == true) goto L8;
        return -1;
    L8:
        if (r3.isNull("turn_index") == false) goto L10;
        return -1;
    L10:
        return r3.optInt("turn_index", -1);
    }

    private final String findReplayRecord(String r24, String r25) {
        JSONObject r2 = parsePayload(r24);
        if (r2 != null) goto L5;
        return "";
    L5:
        String r5 = r2.optString("trace_id");
        final int r7 = -1;
        final int r8 = r2.optInt("call_index", -1);
        if (r2.has("sub_call_index") == false) goto L8;
        r7 = r2.optInt("sub_call_index", -1);
    L8:
        final int r10 = extractTurnIndex(r2);
        if (r10 >= 0) goto L11;
        r10 = 0;
    L11:
        Intrinsics.checkNotNull(r5);
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L14;
        return "";
    L14:
        File r12 = new File(getTraceDir(r5), r25);
        if (r12.exists() == true) goto L32;
        return "";
    L32:
        final Ref.ObjectRef r14 = new Ref.ObjectRef();     // Catch: Exception -> L29
        r14.element = "";     // Catch: Exception -> L29
        boolean r11 = true;
        FilesKt.forEachLine$default(r12, null, new $$Lambda$HarnessDebugBridgeAPIImpl$w450U9L8L2kUTSMZrWJU6VqFOtk(r14, r10, r7, r8), 1, null);     // Catch: Exception -> L29
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r14.element, CharSequence.class, "com.obric.memorydata.plugin")).length() == 0) goto L21;
        r11 = false;
    L21:
        if (r11 == false) goto L23;
        return "";
    L23:
        String r0 = checkReplayConsistency$aikernel_core_obricRelease(r2, new JSONObject((String) ZeusTransformUtils.preCheckCast(r14.element, String.class, "com.obric.memorydata.plugin")), r25);     // Catch: Exception -> L29
        if (r0 == null) goto L33;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "Replay mismatch traceId=" + r5 + " turn=" + r10 + " sub=" + r7 + ": " + r0, null, 4, null);     // Catch: Exception -> L29
        JSONObject r3 = new JSONObject();     // Catch: Exception -> L29
        r3.put("error", ERROR_REPLAY_MISMATCH);     // Catch: Exception -> L29
        r3.put("trace_id", r5);     // Catch: Exception -> L29
        r3.put("turn_index", r10);     // Catch: Exception -> L29
        r3.put("sub_call_index", r7);     // Catch: Exception -> L29
        r3.put("call_index", r8);     // Catch: Exception -> L29
        r3.put(MemoryListActivity.JUMP_FROM_DETAIL, r0);     // Catch: Exception -> L29
        String r1 = r3.toString();     // Catch: Exception -> L29
        Intrinsics.checkNotNullExpressionValue(r1, "toString(...)");     // Catch: Exception -> L29
        return r1;
    L33:
        return (String) ZeusTransformUtils.preCheckCast(r14.element, String.class, "com.obric.memorydata.plugin");
    L29:
        e = move-exception;
        RunLog.INSTANCE.error(TAG, "Failed to find replay record: " + r25, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final Unit findReplayRecord$lambda$5(Ref.ObjectRef r5, int r6, int r7, int r8, String r9) {
        Intrinsics.checkNotNullParameter(r9, "line");
        boolean r1 = true;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r5.element, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L33;
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L33;
        JSONObject r2 = new JSONObject(r9);
        if (r2.has("turn_index") == false) goto L13;
        int r3 = r2.optInt("turn_index", 0);
    L14:
        if (r3 == r6) goto L18;
        return Unit.INSTANCE;
    L18:
        if (r7 < 0) goto L25;
        if (r2.has("sub_call_index") == false) goto L25;
        if (r2.optInt("sub_call_index", -1) == r7) goto L28;
    L27:
        r1 = false;
    L28:
        if (r1 == false) goto L31;
        r5.element = r9;
    L31:
        return Unit.INSTANCE;
    L25:
        if (r2.optInt("call_index", -1) != r8) goto L27;
    L13:
        r3 = 0;
    L33:
        return Unit.INSTANCE;
    L5:
        r0 = false;
        goto L6
    }

    private final File getBaseDir() {
        return (File) ZeusTransformUtils.preCheckCast(baseDir$delegate.getValue(), File.class, "com.obric.memorydata.plugin");
    }

    @JvmStatic
    public static final HarnessDebugBridgeAPIImpl getInst() {
        return INSTANCE;
    }

    private final File getTraceDir(String r8) {
        File r0 = new File(getBaseDir(), r8);
        if (r0.exists() == true) goto L5;
        r0.mkdirs();
    L5:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "Harness traceDir traceId=" + r8 + " path=" + r0.getAbsolutePath(), false, 4, null);
        return r0;
    }

    private final File getTurnDir(String r3, int r4) {
        File r2 = getTraceDir(r3);
        if (r4 >= 0) goto L5;
        return r2;
    L5:
        File r5 = new File(new File(r2, TURNS_DIRNAME), String.valueOf(r4));
        if (r5.exists() == true) goto L8;
        r5.mkdirs();
    L8:
        return r5;
    }

    public static /* synthetic */ File lambda$jxD_xPUfG1wdFW1GRfUVtxDaP4A() {
        return baseDir_delegate$lambda$1();
    }

    public static /* synthetic */ Unit lambda$w450U9L8L2kUTSMZrWJU6VqFOtk(Ref.ObjectRef r0, int r1, int r2, int r3, String r4) {
        return findReplayRecord$lambda$5(r0, r1, r2, r3, r4);
    }

    private final JSONObject parsePayload(String r3) {
        return new JSONObject(r3);
    L4:
        e = move-exception;
        RunLog.INSTANCE.error(TAG, "Failed to parse payload", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return null;
    }

    private final void updateManifestStatus(String r3, String r4) {
        File r0 = new File(getTraceDir(r3), FILE_MANIFEST);     // Catch: Exception -> L7
        if (r0.exists() == true) goto L5;
        return;
    L5:
        JSONObject r2 = new JSONObject(FilesKt.readText$default(r0, null, 1, null));     // Catch: Exception -> L7
        r2.put("status", r4);     // Catch: Exception -> L7
        String r5 = r2.toString();     // Catch: Exception -> L7
        Intrinsics.checkNotNullExpressionValue(r5, "toString(...)");     // Catch: Exception -> L7
        FilesKt.writeText$default(r0, r5, null, 2, null);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        RunLog.INSTANCE.error(TAG, "Failed to update manifest status", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }

    private final boolean writeTraceFile(String r9, String r10, String r11, boolean r12, int r13) {
        if (r13 < 0) goto L5;
        File r8 = getTurnDir(r9, r13);     // Catch: Exception -> L12
    L6:
        File r1 = new File(r8, r10);     // Catch: Exception -> L12
        if (r12 == false) goto L9;
        FilesKt.appendText$default(r1, r11 + '\n', null, 2, null);     // Catch: Exception -> L12
    L10:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "writeTraceFile success traceId=" + r9 + " turn=" + r13 + " file=" + r1.getAbsolutePath() + " append=" + r12 + " size=" + r11.length(), false, 4, null);     // Catch: Exception -> L12
        return true;
    L9:
        FilesKt.writeText$default(r1, r11, null, 2, null);     // Catch: Exception -> L12
        goto L10
    L5:
        r8 = getTraceDir(r9);     // Catch: Exception -> L12
    L12:
        e = move-exception;
        RunLog.INSTANCE.error(TAG, "Failed to write trace file: " + r10, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return false;
    }

    static /* synthetic */ boolean writeTraceFile$default(HarnessDebugBridgeAPIImpl r6, String r7, String r8, String r9, boolean r10, int r11, int r12, Object r13) {
        if ((r12 & 16) == 0) goto L6;
        r11 = -1;
    L6:
        return r6.writeTraceFile(r7, r8, r9, r10, r11);
    }

    public final String checkReplayConsistency$aikernel_core_obricRelease(JSONObject r8, JSONObject r9, String r10) {
        Intrinsics.checkNotNullParameter(r8, "expected");
        Intrinsics.checkNotNullParameter(r9, "recorded");
        Intrinsics.checkNotNullParameter(r10, "fileName");
        int r7 = r10.hashCode();
        boolean r2 = true;
        if (r7 == (-354318481)) goto L85;
        if (r7 == 921829593) goto L56;
        if (r7 == 989525877) goto L10;
        return null;
    L10:
        if (r10.equals(FILE_BRIDGE_CALLS) == false) goto L126;
        String r11 = r8.optString("module");
        String r5 = r8.optString("api");
        String r12 = r9.optString("module");
        String r0 = r9.optString("api");
        Intrinsics.checkNotNull(r11);
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L14;
        boolean r6 = true;
    L15:
        if (r6 == false) goto L28;
        Intrinsics.checkNotNull(r12);
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L19;
        boolean r13 = true;
    L20:
        if (r13 == false) goto L28;
        if (Intrinsics.areEqual(r11, r12) == true) goto L28;
        StringBuilder r14 = new StringBuilder();
        String r15 = "module mismatch: expected=";
    L24:
        StringBuilder r16 = r14.append(r15).append(r11);
    L25:
        StringBuilder r17 = r16.append(" recorded=").append(r12);
    L27:
        return r17.toString();
    L19:
        r13 = false;
    L28:
        Intrinsics.checkNotNull(r5);
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L31;
        boolean r18 = true;
    L32:
        if (r18 == false) goto L41;
        Intrinsics.checkNotNull(r0);
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L36;
        boolean r19 = true;
    L37:
        if (r19 == false) goto L41;
        if (Intrinsics.areEqual(r5, r0) == true) goto L41;
        r17 = new StringBuilder().append("api mismatch: expected=").append(r5).append(" recorded=").append(r0);
        goto L27
    L36:
        r19 = false;
    L41:
        String r20 = r8.optString("params_hash");
        r12 = r9.optString("params_hash");
        Intrinsics.checkNotNull(r20);
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r20, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L44;
        boolean r21 = true;
    L45:
        if (r21 == false) goto L128;
        Intrinsics.checkNotNull(r12);
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin")).length() > 0) goto L50;
        r2 = false;
    L50:
        if (r2 == true) goto L52;
        return null;
    L52:
        if (Intrinsics.areEqual(r20, r12) == true) goto L130;
        StringBuilder r22 = new StringBuilder();
        String r110 = "params_hash mismatch: expected=";
    L54:
        r16 = r22.append(r110).append(r20);
        goto L25
    L130:
        return null;
    L128:
        return null;
    L44:
        r21 = false;
        goto L45
    L31:
        r18 = false;
        goto L32
    L14:
        r6 = false;
        goto L15
    L126:
        return null;
    L56:
        if (r10.equals(FILE_LLM_CALLS) == false) goto L138;
        r11 = r8.optString("client_method");
        r12 = r9.optString("client_method");
        Intrinsics.checkNotNull(r11);
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L61;
        boolean r1 = true;
    L62:
        if (r1 == false) goto L71;
        Intrinsics.checkNotNull(r12);
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L66;
        boolean r3 = true;
    L67:
        if (r3 == false) goto L71;
        if (Intrinsics.areEqual(r11, r12) == true) goto L71;
        r14 = new StringBuilder();
        r15 = "client_method mismatch: expected=";
        goto L24
    L66:
        r3 = false;
    L71:
        r20 = r8.optString("prompt_hash");
        r12 = r9.optString("prompt_hash");
        Intrinsics.checkNotNull(r20);
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r20, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L74;
        boolean r23 = true;
    L75:
        if (r23 == false) goto L131;
        Intrinsics.checkNotNull(r12);
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin")).length() > 0) goto L80;
        r2 = false;
    L80:
        if (r2 == true) goto L82;
        return null;
    L82:
        if (Intrinsics.areEqual(r20, r12) == true) goto L133;
        r22 = new StringBuilder();
        r110 = "prompt_hash mismatch: expected=";
        goto L54
    L133:
        return null;
    L131:
        return null;
    L74:
        r23 = false;
        goto L75
    L61:
        r1 = false;
        goto L62
    L138:
        return null;
    L85:
        if (r10.equals(FILE_EVENTS) == false) goto L139;
        r11 = r8.optString(MemoryInfoSectionEditActivity.EXTRA_KIND);
        r12 = r9.optString(MemoryInfoSectionEditActivity.EXTRA_KIND);
        Intrinsics.checkNotNull(r11);
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L90;
        boolean r4 = true;
    L91:
        if (r4 == false) goto L100;
        Intrinsics.checkNotNull(r12);
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L95;
        boolean r24 = true;
    L96:
        if (r24 == false) goto L100;
        if (Intrinsics.areEqual(r11, r12) == true) goto L100;
        r14 = new StringBuilder();
        r15 = "event kind mismatch: expected=";
        goto L24
    L95:
        r24 = false;
    L100:
        r11 = r8.optString("event_name");
        r12 = r9.optString("event_name");
        Intrinsics.checkNotNull(r11);
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L103;
        boolean r25 = true;
    L104:
        if (r25 == false) goto L113;
        Intrinsics.checkNotNull(r12);
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L108;
        boolean r26 = true;
    L109:
        if (r26 == false) goto L113;
        if (Intrinsics.areEqual(r11, r12) == true) goto L113;
        r14 = new StringBuilder();
        r15 = "event_name mismatch: expected=";
        goto L24
    L108:
        r26 = false;
    L113:
        r20 = r8.optString("payload_hash");
        r12 = r9.optString("payload_hash");
        Intrinsics.checkNotNull(r20);
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r20, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L116;
        boolean r27 = true;
    L117:
        if (r27 == false) goto L134;
        Intrinsics.checkNotNull(r12);
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin")).length() > 0) goto L122;
        r2 = false;
    L122:
        if (r2 == true) goto L124;
        return null;
    L124:
        if (Intrinsics.areEqual(r20, r12) == true) goto L136;
        r22 = new StringBuilder();
        r110 = "payload_hash mismatch: expected=";
        goto L54
    L136:
        return null;
    L134:
        return null;
    L116:
        r27 = false;
        goto L117
    L103:
        r25 = false;
        goto L104
    L90:
        r4 = false;
        goto L91
    L139:
        return null;
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IHarnessDebugBridgeAPI
    public synchronized void collectLog(String r6) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r6, "data");     // Catch: Throwable -> L10
        String r0 = extractTraceId(r6);     // Catch: Exception -> L6 Throwable -> L10
        File r2 = new File(getTraceDir(r0), FILE_EXECUTION_LOG);     // Catch: Exception -> L6 Throwable -> L10
        FilesKt.appendText$default(r2, r6 + '\n', null, 2, null);     // Catch: Exception -> L6 Throwable -> L10
        RunLog.INSTANCE.debug(TAG, "collectLog success traceId=" + r0 + " file=" + r2.getAbsolutePath());     // Catch: Exception -> L6 Throwable -> L10
    L8:
        monitor-exit(this);
        return;
    L6:
        e = move-exception;
        RunLog.INSTANCE.error(TAG, "Failed to collect log", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IHarnessDebugBridgeAPI
    public String getBridgeReplay(String r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        return findReplayRecord(r2, FILE_BRIDGE_CALLS);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IHarnessDebugBridgeAPI
    public String getEventReplay(String r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        return findReplayRecord(r2, FILE_EVENTS);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IHarnessDebugBridgeAPI
    public String getLLMMock(String r4) {
        Intrinsics.checkNotNullParameter(r4, Params.PROMPT);
        RunLog.INSTANCE.debug(TAG, "getLLMMock called");
        File r5 = new File(getBaseDir(), "llm_mocks.json");     // Catch: Exception -> L7
        if (r5.exists() == false) goto L13;
        return FilesKt.readText$default(r5, null, 1, null);
    L13:
        return "";
    L7:
        e = move-exception;
        RunLog.INSTANCE.error(TAG, "Failed to read mock", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return "";
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IHarnessDebugBridgeAPI
    public String getLLMReplay(String r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        return findReplayRecord(r2, FILE_LLM_CALLS);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IHarnessDebugBridgeAPI
    public synchronized boolean prepareCase(String r14) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r14, "data");     // Catch: Throwable -> L39
        JSONObject r0 = parsePayload(r14);     // Catch: Throwable -> L39
        boolean r1 = false;
        if (r0 != null) goto L8;
        monitor-exit(this);
        return false;
    L8:
        String r2 = r0.optString("trace_id");     // Catch: Throwable -> L39
        Intrinsics.checkNotNull(r2);     // Catch: Throwable -> L39
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L13;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "prepareCase failed: traceId blank", null, 4, null);     // Catch: Throwable -> L39
        monitor-exit(this);
        return false;
    L13:
        String r3 = r0.optString("mode");     // Catch: Throwable -> L39
        int r4 = extractTurnIndex(r0);     // Catch: Throwable -> L39
        File r5 = new File(getTraceDir(r2), FILE_MANIFEST);     // Catch: Throwable -> L39
    L35:
        e = move-exception;
        RunLog.INSTANCE.error(TAG, "Failed to prepare case", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L39
    L37:
        monitor-exit(this);
        return r1;
    L16:
        if (r5.exists() == true) goto L18;
    L22:
        boolean r7 = true;
    L23:
        if (r7 == false) goto L31;
        JSONObject r8 = new JSONObject(r14);     // Catch: Exception -> L35 Throwable -> L39
        if (r8.has("schema_version") == true) goto L28;
        r8.put("schema_version", 2);     // Catch: Exception -> L35 Throwable -> L39
    L28:
        if (r8.has(TURNS_DIRNAME) == true) goto L30;
        r8.put(TURNS_DIRNAME, new JSONArray());     // Catch: Exception -> L35 Throwable -> L39
    L30:
        String r15 = r8.toString();     // Catch: Exception -> L35 Throwable -> L39
        Intrinsics.checkNotNullExpressionValue(r15, "toString(...)");     // Catch: Exception -> L35 Throwable -> L39
        FilesKt.writeText$default(r5, r15, null, 2, null);     // Catch: Exception -> L35 Throwable -> L39
    L31:
        if (r4 < 0) goto L33;
        appendOrUpdateTurn(r2, r0);     // Catch: Exception -> L35 Throwable -> L39
        getTurnDir(r2, r4);     // Catch: Exception -> L35 Throwable -> L39
    L33:
        ensureTraceFile(r2, FILE_BRIDGE_CALLS);     // Catch: Exception -> L35 Throwable -> L39
        ensureTraceFile(r2, FILE_LLM_CALLS);     // Catch: Exception -> L35 Throwable -> L39
        ensureTraceFile(r2, FILE_EVENTS);     // Catch: Exception -> L35 Throwable -> L39
        ensureTraceFile(r2, FILE_EXECUTION_LOG);     // Catch: Exception -> L35 Throwable -> L39
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "prepareCase success traceId=" + r2 + " mode=" + r3 + " turn=" + r4 + " manifest=" + r5.getAbsolutePath(), false, 4, null);     // Catch: Exception -> L35 Throwable -> L39
        r1 = true;
        goto L37
    L18:
        if (Intrinsics.areEqual(r3, "record") == false) goto L21;
        if (r4 <= 0) goto L22;
    L21:
        r7 = false;
    L39:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IHarnessDebugBridgeAPI
    public synchronized boolean saveBridgeCall(String r12) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r12, "data");     // Catch: Throwable -> L6
        RunLog.INSTANCE.debug(TAG, "saveBridgeCall called traceId=" + extractTraceId(r12));     // Catch: Throwable -> L6
        boolean r13 = writeTraceFile$default(this, extractTraceId(r12), FILE_BRIDGE_CALLS, r12, true, 0, 16, null);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r13;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IHarnessDebugBridgeAPI
    public synchronized boolean saveCaseInput(String r14) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r14, "data");     // Catch: Throwable -> L6
        JSONObject r0 = parsePayload(r14);     // Catch: Throwable -> L6
        String r2 = extractTraceId(r14);     // Catch: Throwable -> L6
        int r6 = extractTurnIndex(r0);     // Catch: Throwable -> L6
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "saveCaseInput called traceId=" + r2 + " turn=" + r6, false, 4, null);     // Catch: Throwable -> L6
        boolean r15 = writeTraceFile(r2, FILE_INPUT_ARGS, r14, false, r6);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r15;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IHarnessDebugBridgeAPI
    public synchronized boolean saveCaseResult(String r17) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r17, "data");     // Catch: Throwable -> L35
        JSONObject r0 = parsePayload(r17);     // Catch: Throwable -> L35
        String r8 = extractTraceId(r17);     // Catch: Throwable -> L35
        int r9 = extractTurnIndex(r0);     // Catch: Throwable -> L35
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "saveCaseResult called traceId=" + r8 + " turn=" + r9, false, 4, null);     // Catch: Throwable -> L35
        boolean r1 = writeTraceFile(r8, FILE_RESULT, r17, false, r9);     // Catch: Throwable -> L35
        if (r1 == false) goto L33;
        String r2 = null;
        if (r9 < 0) goto L25;
        if (r0 == null) goto L25;
        JSONObject r3 = new JSONObject();     // Catch: Throwable -> L35
        r3.put("turn_index", r9);     // Catch: Throwable -> L35
        CharSequence r5 = (CharSequence) ZeusTransformUtils.preCheckCast(r0.optString("status"), CharSequence.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L35
        boolean r10 = true;
        if (r5.length() != 0) goto L12;
        boolean r6 = true;
    L13:
        if (r6 == false) goto L15;
        r5 = "completed";
    L15:
        r3.put("status", r5);     // Catch: Throwable -> L35
        Object r4 = r0.optString("finished_at");     // Catch: Throwable -> L35
        Intrinsics.checkNotNull(r4);     // Catch: Throwable -> L35
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")).length() > 0) goto L19;
        r10 = false;
    L19:
        if (r10 == true) goto L22;
        r4 = null;
    L22:
        if (r4 == null) goto L24;
        r3.put("finished_at", r4);     // Catch: Throwable -> L35
    L24:
        appendOrUpdateTurn(r8, r3);     // Catch: Throwable -> L35
        goto L25
    L12:
        r6 = false;
    L25:
        if (r0 == null) goto L27;
        r2 = r0.optString("final_status");     // Catch: Throwable -> L35
    L27:
        if (r2 != null) goto L29;
        r2 = "";
    L29:
        if (r9 >= 0) goto L31;
    L32:
        updateManifestStatus(r8, "completed");     // Catch: Throwable -> L35
        goto L33
    L31:
        if (Intrinsics.areEqual(r2, "completed") == true) goto L32;
    L33:
        monitor-exit(this);
        return r1;
    L35:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IHarnessDebugBridgeAPI
    public synchronized boolean saveEvent(String r12) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r12, "data");     // Catch: Throwable -> L6
        RunLog.INSTANCE.debug(TAG, "saveEvent called traceId=" + extractTraceId(r12));     // Catch: Throwable -> L6
        boolean r13 = writeTraceFile$default(this, extractTraceId(r12), FILE_EVENTS, r12, true, 0, 16, null);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r13;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IHarnessDebugBridgeAPI
    public synchronized boolean saveLLMCall(String r12) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r12, "data");     // Catch: Throwable -> L6
        RunLog.INSTANCE.debug(TAG, "saveLLMCall called traceId=" + extractTraceId(r12));     // Catch: Throwable -> L6
        boolean r13 = writeTraceFile$default(this, extractTraceId(r12), FILE_LLM_CALLS, r12, true, 0, 16, null);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r13;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IHarnessDebugBridgeAPI
    public synchronized void saveTrace(String r4) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r4, "data");     // Catch: Throwable -> L15
        RunLog.INSTANCE.debug(TAG, "saveTrace called");     // Catch: Throwable -> L15
        JSONObject r0 = parsePayload(r4);     // Catch: Throwable -> L15
        if (r0 == null) goto L6;
        String r1 = r0.optString("module");     // Catch: Throwable -> L15
    L7:
        if (r1 != null) goto L10;
        r1 = "";
    L10:
        if (Intrinsics.areEqual(r1, "llm") == false) goto L12;
        saveLLMCall(r4);     // Catch: Throwable -> L15
    L13:
        monitor-exit(this);
        return;
    L12:
        saveBridgeCall(r4);     // Catch: Throwable -> L15
        goto L13
    L6:
        r1 = null;
    L15:
        th = move-exception;
        throw th;
    }
}
