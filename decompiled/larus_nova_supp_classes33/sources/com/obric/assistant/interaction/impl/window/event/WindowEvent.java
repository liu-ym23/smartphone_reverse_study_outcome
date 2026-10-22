package com.obric.assistant.interaction.impl.window.event;

import android.os.Bundle;
import android.os.SystemClock;
import com.larus.applog.api.IApplog;
import com.larus.common.apphost.AppHost;
import com.larus.im.FlowRuntime;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.api.IAssistantInteractionServiceKt;
import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import com.obric.assistant.interaction.base.interact.KeyguardLockedState;
import com.obric.assistant.reporter.IObricReporter;
import java.util.Set;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n*\u0001\u0010\bÀ\u0002\u0018\u00002\u00020\u0001:\u0005CDEFGB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\f2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\u001a\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00052\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\"\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u001b2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\"\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00052\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\u0006\u0010\u001e\u001a\u00020\u0013J\u0006\u0010\u001f\u001a\u00020\u0013J\u0006\u0010 \u001a\u00020\u0013J\u0006\u0010!\u001a\u00020\u0013J\u0006\u0010\"\u001a\u00020\u0013J\u0006\u0010#\u001a\u00020\u0013J\u000e\u0010$\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0005J\u0012\u0010%\u001a\u00020\u00132\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0005J\u0012\u0010'\u001a\u00020\u00132\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0005J\u0012\u0010(\u001a\u00020\u00132\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0005J\u000e\u0010)\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u001bJ\u0010\u0010*\u001a\u00020\u00132\b\u0010+\u001a\u0004\u0018\u00010,J\u0010\u0010-\u001a\u00020\u00132\u0006\u0010&\u001a\u00020\u0005H\u0002J0\u0010.\u001a\u00020\u00132\u0006\u0010/\u001a\u00020\n2\u0006\u00100\u001a\u00020\u00052\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0002J1\u00101\u001a\u00020\u00132\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u00052\b\u00105\u001a\u0004\u0018\u00010\u00072\b\u00106\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0002\u00107J?\u00108\u001a\u00020\u00132\u0006\u00109\u001a\u00020\u00052\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010;\u001a\u00020\f2\u0017\u0010<\u001a\u0013\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020\u00130=¢\u0006\u0002\b>H\u0002J\u0014\u0010?\u001a\u0002032\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u0005H\u0002J\u001c\u0010@\u001a\u00020\u00052\b\u0010A\u001a\u0004\u0018\u00010\u00052\b\u0010B\u001a\u0004\u0018\u00010\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011¨\u0006H"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/event/WindowEvent;", "", "<init>", "()V", "TAG", "", "openStartElapsedMs", "", "Ljava/lang/Long;", "openPerfTrace", "Lcom/obric/assistant/interaction/impl/window/event/WindowEvent$WindowOpenPerfTrace;", "lastOpenColdStart", "", "Ljava/lang/Boolean;", "lastAppBackgroundUptimeMillis", "appBackGroundListener", "com/obric/assistant/interaction/impl/window/event/WindowEvent$appBackGroundListener$1", "Lcom/obric/assistant/interaction/impl/window/event/WindowEvent$appBackGroundListener$1;", "onWindowOpenStart", "", Params.TRIGGER, "isColdStart", "extra", "Lcom/obric/assistant/interaction/impl/window/event/WindowEvent$BundleParams;", "onWindowOpenSuccess", "onWindowOpenFail", "throwable", "", "beginWindowOpenPerf", "startElapsedMs", "markWindowOpenPerfHostEnter", "markWindowOpenPerfCreateStart", "markWindowOpenPerfCreateEnd", "markWindowOpenPerfShowStart", "markWindowOpenPerfShowEnd", "markWindowOpenPerfFirstFrame", "onWindowShow", "onWindowHide", Params.REASON, "onWindowStash", "onWindowPop", "onWindowFallbackToActivity", "reportActivateMainView", "params", "Landroid/os/Bundle;", "cancelWindowOpenPerf", "reportWindowOpenPerf", "trace", Params.RESULT, "safePutDuration", "json", "Lorg/json/JSONObject;", "key", "startMs", "endMs", "(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;)V", "report", "event", "sessionId", "includeBaseParams", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "buildBaseParams", "getAdjustedWindowMode", "launchMethod", "launchService", "Events", "Params", "WindowOpenPerfResult", "WindowOpenPerfTrace", "BundleParams", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WindowEvent {
    public static final WindowEvent INSTANCE = null;
    private static final String TAG = "WindowEvent";
    private static final WindowEvent$appBackGroundListener$1 appBackGroundListener = null;
    private static volatile long lastAppBackgroundUptimeMillis;
    private static Boolean lastOpenColdStart;
    private static WindowOpenPerfTrace openPerfTrace;
    private static Long openStartElapsedMs;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/event/WindowEvent$BundleParams;", "", "bundle", "Landroid/os/Bundle;", "<init>", "(Landroid/os/Bundle;)V", "applyTo", "", "json", "Lorg/json/JSONObject;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class BundleParams {
        private final Bundle bundle;

        public BundleParams(Bundle r1) {
            this.bundle = r1;
        }

        public final void applyTo(JSONObject r4) {
            Intrinsics.checkNotNullParameter(r4, "json");
            Bundle r0 = this.bundle;
            if (r0 != null) goto L6;
            return;
        L6:
            if (r0.containsKey("obric_window_height") == false) goto L9;
            r4.put("obric_window_height", r0.get("obric_window_height"));
            return;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/event/WindowEvent$Events;", "", "<init>", "()V", "WINDOW_OPEN_START", "", "WINDOW_OPEN_SUCCESS", "WINDOW_OPEN_FAIL", "WINDOW_OPEN_PERF", "WINDOW_SHOW", "WINDOW_HIDE", "WINDOW_STASH", "WINDOW_POP", "WINDOW_FALLBACK_TO_ACTIVITY", "ACTIVATE_MAIN_VIEW", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Events {
        public static final String ACTIVATE_MAIN_VIEW = "activate_to_mainview";
        public static final Events INSTANCE = null;
        public static final String WINDOW_FALLBACK_TO_ACTIVITY = "obric_window_fallback_to_activity";
        public static final String WINDOW_HIDE = "obric_window_hide";
        public static final String WINDOW_OPEN_FAIL = "obric_window_open_fail";
        public static final String WINDOW_OPEN_PERF = "obric_window_open_perf";
        public static final String WINDOW_OPEN_START = "obric_window_open_start";
        public static final String WINDOW_OPEN_SUCCESS = "obric_window_open_success";
        public static final String WINDOW_POP = "obric_window_pop";
        public static final String WINDOW_SHOW = "obric_window_show";
        public static final String WINDOW_STASH = "obric_window_stash";

        static {
            INSTANCE = new Events();
        }

        private Events() {
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0011\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/event/WindowEvent$Params;", "", "<init>", "()V", "TRIGGER", "", "REASON", "ERROR_TYPE", "ERROR_MSG", "RESULT", "LAUNCH_ID", "TOTAL_COST_MS", "CREATE_COST_MS", "SHOW_COST_MS", "FIRST_FRAME_COST_MS", "IS_COLD_START", "LAUNCH_METHOD", "LAUNCH_POSITION_LEVEL1", "LAUNCH_POSITION_LEVEL2", "LAUNCH_SERVICE", "LAUNCH_WAKEUP", "LAUNCH_SESSION_ID", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Params {
        public static final String CREATE_COST_MS = "create_cost_ms";
        public static final String ERROR_MSG = "error_msg";
        public static final String ERROR_TYPE = "error_type";
        public static final String FIRST_FRAME_COST_MS = "first_frame_cost_ms";
        public static final Params INSTANCE = null;
        public static final String IS_COLD_START = "is_window_cold_start";
        public static final String LAUNCH_ID = "launch_id";
        public static final String LAUNCH_METHOD = "launch_method";
        public static final String LAUNCH_POSITION_LEVEL1 = "launch_position_level1";
        public static final String LAUNCH_POSITION_LEVEL2 = "launch_position_level2";
        public static final String LAUNCH_SERVICE = "launch_service";
        public static final String LAUNCH_SESSION_ID = "launch_session_id";
        public static final String LAUNCH_WAKEUP = "launch_wakeup";
        public static final String REASON = "reason";
        public static final String RESULT = "result";
        public static final String SHOW_COST_MS = "show_cost_ms";
        public static final String TOTAL_COST_MS = "total_cost_ms";
        public static final String TRIGGER = "trigger";

        static {
            INSTANCE = new Params();
        }

        private Params() {
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/event/WindowEvent$WindowOpenPerfResult;", "", "<init>", "()V", "SUCCESS", "", "FAIL", "CANCEL", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class WindowOpenPerfResult {
        public static final String CANCEL = "cancel";
        public static final String FAIL = "fail";
        public static final WindowOpenPerfResult INSTANCE = null;
        public static final String SUCCESS = "success";

        static {
            INSTANCE = new WindowOpenPerfResult();
        }

        private WindowOpenPerfResult() {
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010!\u001a\u00020\"J\u0006\u0010#\u001a\u00020\"J\u0006\u0010$\u001a\u00020\"J\u0006\u0010%\u001a\u00020\"J\u0006\u0010&\u001a\u00020\"J\u0006\u0010'\u001a\u00020\"J\r\u0010(\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R$\u0010\u0013\u001a\u0004\u0018\u00010\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0006@BX\u0086\u000e¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R$\u0010\u0017\u001a\u0004\u0018\u00010\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0006@BX\u0086\u000e¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0018\u0010\u0015R$\u0010\u0019\u001a\u0004\u0018\u00010\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0006@BX\u0086\u000e¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u001a\u0010\u0015R$\u0010\u001b\u001a\u0004\u0018\u00010\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0006@BX\u0086\u000e¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u001c\u0010\u0015R$\u0010\u001d\u001a\u0004\u0018\u00010\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0006@BX\u0086\u000e¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u001e\u0010\u0015R$\u0010\u001f\u001a\u0004\u0018\u00010\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0006@BX\u0086\u000e¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b \u0010\u0015¨\u0006)"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/event/WindowEvent$WindowOpenPerfTrace;", "", "launchId", "", Params.TRIGGER, "startElapsedMs", "", "extra", "Lcom/obric/assistant/interaction/impl/window/event/WindowEvent$BundleParams;", "<init>", "(Ljava/lang/String;Ljava/lang/String;JLcom/obric/assistant/interaction/impl/window/event/WindowEvent$BundleParams;)V", "getLaunchId", "()Ljava/lang/String;", "getTrigger", "getStartElapsedMs", "()J", "getExtra", "()Lcom/obric/assistant/interaction/impl/window/event/WindowEvent$BundleParams;", "value", "hostEnterElapsedMs", "getHostEnterElapsedMs", "()Ljava/lang/Long;", "Ljava/lang/Long;", "createStartElapsedMs", "getCreateStartElapsedMs", "createEndElapsedMs", "getCreateEndElapsedMs", "showStartElapsedMs", "getShowStartElapsedMs", "showEndElapsedMs", "getShowEndElapsedMs", "firstFrameElapsedMs", "getFirstFrameElapsedMs", "markHostEnter", "", "markCreateStart", "markCreateEnd", "markShowStart", "markShowEnd", "markFirstFrame", "endElapsedMs", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class WindowOpenPerfTrace {
        private Long createEndElapsedMs;
        private Long createStartElapsedMs;
        private final BundleParams extra;
        private Long firstFrameElapsedMs;
        private Long hostEnterElapsedMs;
        private final String launchId;
        private Long showEndElapsedMs;
        private Long showStartElapsedMs;
        private final long startElapsedMs;
        private final String trigger;

        public final Long endElapsedMs() {
            Long r0 = this.firstFrameElapsedMs;
            if (r0 != null) goto L10;
            Long r1 = this.showEndElapsedMs;
            if (r1 != null) goto L11;
            Long r2 = this.createEndElapsedMs;
            if (r2 == null) goto L9;
            return r2;
        L9:
            return this.hostEnterElapsedMs;
        L11:
            return r1;
        L10:
            return r0;
        }

        public final void markCreateEnd() {
            if (this.createEndElapsedMs != null) goto L6;
            this.createEndElapsedMs = Long.valueOf(SystemClock.elapsedRealtime());
            return;
        }

        public final void markCreateStart() {
            if (this.createStartElapsedMs != null) goto L6;
            this.createStartElapsedMs = Long.valueOf(SystemClock.elapsedRealtime());
            return;
        }

        public final void markFirstFrame() {
            if (this.firstFrameElapsedMs != null) goto L6;
            this.firstFrameElapsedMs = Long.valueOf(SystemClock.elapsedRealtime());
            return;
        }

        public final void markHostEnter() {
            if (this.hostEnterElapsedMs != null) goto L6;
            this.hostEnterElapsedMs = Long.valueOf(SystemClock.elapsedRealtime());
            return;
        }

        public final void markShowEnd() {
            if (this.showEndElapsedMs != null) goto L6;
            this.showEndElapsedMs = Long.valueOf(SystemClock.elapsedRealtime());
            return;
        }

        public final void markShowStart() {
            if (this.showStartElapsedMs != null) goto L6;
            this.showStartElapsedMs = Long.valueOf(SystemClock.elapsedRealtime());
            return;
        }

        public final Long getCreateEndElapsedMs() {
            return this.createEndElapsedMs;
        }

        public final Long getCreateStartElapsedMs() {
            return this.createStartElapsedMs;
        }

        public final BundleParams getExtra() {
            return this.extra;
        }

        public final Long getFirstFrameElapsedMs() {
            return this.firstFrameElapsedMs;
        }

        public final Long getHostEnterElapsedMs() {
            return this.hostEnterElapsedMs;
        }

        public final String getLaunchId() {
            return this.launchId;
        }

        public final Long getShowEndElapsedMs() {
            return this.showEndElapsedMs;
        }

        public final Long getShowStartElapsedMs() {
            return this.showStartElapsedMs;
        }

        public final long getStartElapsedMs() {
            return this.startElapsedMs;
        }

        public final String getTrigger() {
            return this.trigger;
        }

        public WindowOpenPerfTrace(String r2, String r3, long r4, BundleParams r6) {
            Intrinsics.checkNotNullParameter(r2, "launchId");
            Intrinsics.checkNotNullParameter(r3, Params.TRIGGER);
            this.launchId = r2;
            this.trigger = r3;
            this.startElapsedMs = r4;
            this.extra = r6;
        }
    }

    private WindowEvent() {
    }

    public static /* synthetic */ Unit a(String r0, Throwable r1, BundleParams r2, JSONObject r3) {
        return onWindowOpenFail$lambda$3(r0, r1, r2, r3);
    }

    public static /* synthetic */ Unit b(String r0, Long r1, BundleParams r2, JSONObject r3) {
        return onWindowOpenSuccess$lambda$1(r0, r1, r2, r3);
    }

    public static /* synthetic */ Unit c(String r0, BundleParams r1, JSONObject r2) {
        return onWindowOpenStart$lambda$0(r0, r1, r2);
    }

    public static /* synthetic */ Unit d(String r0, JSONObject r1) {
        return onWindowHide$lambda$6(r0, r1);
    }

    public static /* synthetic */ Unit e(String r0, JSONObject r1) {
        return onWindowShow$lambda$4(r0, r1);
    }

    public static /* synthetic */ Unit f(String r0, JSONObject r1) {
        return onWindowStash$lambda$8(r0, r1);
    }

    public static /* synthetic */ Unit g(String r0, JSONObject r1) {
        return onWindowPop$lambda$10(r0, r1);
    }

    public static /* synthetic */ Unit h(WindowOpenPerfTrace r0, String r1, String r2, Throwable r3, JSONObject r4) {
        return reportWindowOpenPerf$lambda$18(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ Unit i(Throwable r0, JSONObject r1) {
        return onWindowFallbackToActivity$lambda$12(r0, r1);
    }

    public static /* synthetic */ Unit j(Bundle r0, long r1, long r3, JSONObject r5) {
        return reportActivateMainView$lambda$14(r0, r1, r3, r5);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.obric.assistant.interaction.impl.window.event.WindowEvent$appBackGroundListener$1, f09.a$b] */
    static {
        INSTANCE = new WindowEvent();
        ?? r0 = new WindowEvent$appBackGroundListener$1();
        appBackGroundListener = r0;
        AppHost.a.a().j(r0);
    }

    public final void markWindowOpenPerfCreateEnd() {
        WindowOpenPerfTrace r0 = openPerfTrace;
        if (r0 == null) goto L6;
        r0.markCreateEnd();
        return;
    }

    public final void markWindowOpenPerfCreateStart() {
        WindowOpenPerfTrace r0 = openPerfTrace;
        if (r0 == null) goto L6;
        r0.markCreateStart();
        return;
    }

    public final void markWindowOpenPerfFirstFrame() {
        WindowOpenPerfTrace r1 = openPerfTrace;
        if (r1 != null) goto L5;
        return;
    L5:
        r1.markFirstFrame();
        reportWindowOpenPerf$default(this, r1, WindowOpenPerfResult.SUCCESS, null, null, 12, null);
        openPerfTrace = null;
    }

    public final void markWindowOpenPerfHostEnter() {
        WindowOpenPerfTrace r0 = openPerfTrace;
        if (r0 == null) goto L6;
        r0.markHostEnter();
        return;
    }

    public final void markWindowOpenPerfShowEnd() {
        WindowOpenPerfTrace r0 = openPerfTrace;
        if (r0 == null) goto L6;
        r0.markShowEnd();
        return;
    }

    public final void markWindowOpenPerfShowStart() {
        WindowOpenPerfTrace r0 = openPerfTrace;
        if (r0 == null) goto L6;
        r0.markShowStart();
        return;
    }

    public static final /* synthetic */ void access$setLastAppBackgroundUptimeMillis$p(long r0) {
        lastAppBackgroundUptimeMillis = r0;
    }

    private final JSONObject buildBaseParams(String r7) {
        IObricReporter.a.getClass();
        IObricReporter r0 = IObricReporter.a.a();
        String r1 = null;
        if (r0 == null) goto L5;
        String r2 = r0.a();
    L6:
        if (r0 == null) goto L8;
        String r3 = r0.l();
    L9:
        if (r0 == null) goto L12;
        r1 = r0.getWakeupSource();
    L12:
        if (IAssistantInteractionServiceKt.getInteractionStateService().getInteractionKeyguardLockedState() != KeyguardLockedState.UNLOCKED) goto L14;
        String r4 = "unlocked_screen";
    L15:
        JSONObject r5 = new JSONObject();
        if (r2 == null) goto L18;
        r5.put(Params.LAUNCH_METHOD, r2);
    L18:
        if (r3 == null) goto L20;
        r5.put(Params.LAUNCH_SERVICE, r3);
    L20:
        if (r1 == null) goto L22;
        r5.put(Params.LAUNCH_WAKEUP, r1);
    L22:
        r5.put(Params.LAUNCH_POSITION_LEVEL1, r4);
        String r6 = IAssistantInteractionServiceKt.getInteractionStateService().getWakeUpAppPkg();
        if (r6 != null) goto L25;
    L28:
        boolean r8 = true;
    L29:
        if (r8 == true) goto L31;
        r5.put(Params.LAUNCH_POSITION_LEVEL2, r6);
    L31:
        if (r7 == null) goto L33;
        r5.put(Params.LAUNCH_SESSION_ID, r7);
    L33:
        Boolean r9 = lastOpenColdStart;
        if (r9 == null) goto L36;
        r5.put(Params.IS_COLD_START, r9.booleanValue());
    L36:
        r5.put("obric_window_mode", INSTANCE.getAdjustedWindowMode(r2, r3));
        return r5;
    L25:
        if (r6.length() == 0) goto L28;
        r8 = false;
        goto L29
    L14:
        r4 = "lock_screen";
        goto L15
    L8:
        r3 = null;
        goto L9
    L5:
        r2 = null;
        goto L6
    }

    private final void cancelWindowOpenPerf(String r8) {
        WindowOpenPerfTrace r1 = openPerfTrace;
        if (r1 != null) goto L5;
        return;
    L5:
        reportWindowOpenPerf$default(this, r1, WindowOpenPerfResult.CANCEL, r8, null, 8, null);
        openPerfTrace = null;
    }

    public final void onWindowFallbackToActivity(final Throwable r9) {
        Intrinsics.checkNotNullParameter(r9, "throwable");
        report$default(this, Events.WINDOW_FALLBACK_TO_ACTIVITY, null, false, new i(r9), 6, null);
    }

    public final void onWindowHide(final String r9) {
        if (r9 != null) goto L4;
        String r0 = "hide";
    L5:
        cancelWindowOpenPerf(r0);
        report$default(this, Events.WINDOW_HIDE, null, false, new f(r9), 6, null);
        return;
    L4:
        r0 = r9;
        goto L5
    }

    public final void onWindowPop(final String r8) {
        report$default(this, Events.WINDOW_POP, null, false, new j(r8), 6, null);
    }

    public final void onWindowShow(final String r9) {
        Intrinsics.checkNotNullParameter(r9, Params.TRIGGER);
        report$default(this, Events.WINDOW_SHOW, null, false, new c(r9), 6, null);
    }

    public final void onWindowStash(final String r9) {
        if (r9 != null) goto L4;
        String r0 = "stash";
    L5:
        cancelWindowOpenPerf(r0);
        report$default(this, Events.WINDOW_STASH, null, false, new b(r9), 6, null);
        return;
    L4:
        r0 = r9;
        goto L5
    }

    public final void reportActivateMainView(final Bundle r11) {
        if (r11 == null) goto L17;
        Long r0 = Long.valueOf(r11.getLong("o_dispatch_to_main_process_time", -1));
        if (r0.longValue() <= 0) goto L6;
        boolean r1 = true;
    L7:
        if (r1 == true) goto L10;
        r0 = null;
    L10:
        if (r0 == null) goto L18;
        final long r5 = r0.longValue();
        final long r3 = SystemClock.uptimeMillis();
        if (r3 >= r5) goto L15;
        FLogger.a.w(TAG, "skip activate_to_mainview report: dispatchToMainProcessTime=" + r5 + ", animationStartTime=" + r3);
        return;
    L15:
        report$default(this, Events.ACTIVATE_MAIN_VIEW, null, false, new g(r11, r3, r5), 2, null);
        return;
    L18:
        return;
    L6:
        r1 = false;
        goto L7
    }

    private final String getAdjustedWindowMode(String r14, String r15) {
        boolean r0 = false;
        if (r14 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == true) goto L23;
        if (r15 != null) goto L12;
    L13:
        r0 = true;
    L14:
        if (r0 == true) goto L26;
        Set r1 = SetsKt.setOf(new String[]{"dora_call", "dora_radio", "third_party_gesture", "audio", "long_press_power_button", "long_press_ai_button", "single_click_ai_button", "single_click_power_button", "oauto_input_icon", "mcp_input_icon", "dynamic_island", "notification_center"});
        Set r3 = SetsKt.setOf(new String[]{"open_video_call", "open_voice_call", "open_doubao_camera", "open_share_screen_call", "open_doubao"});
        if (r1.contains(r14) == true) goto L19;
    L21:
        return "full_screen";
    L19:
        if (r3.contains(r15) == true) goto L21;
        return "global_small_window";
    L26:
        return "unknown";
    L12:
        if (r15.length() != 0) goto L14;
    L23:
        return "unknown";
    L5:
        if (r14.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    private static final Unit onWindowFallbackToActivity$lambda$12(Throwable r2, JSONObject r3) {
        Intrinsics.checkNotNullParameter(r3, "$this$report");
        r3.put(Params.ERROR_TYPE, r2.getClass().getSimpleName());
        String r4 = r2.getMessage();
        if (r4 == null) goto L6;
        r3.put(Params.ERROR_MSG, r4);
    L6:
        return Unit.INSTANCE;
    }

    private static final Unit onWindowHide$lambda$6(String r1, JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$report");
        if (r1 == null) goto L6;
        r2.put(Params.REASON, r1);
    L6:
        return Unit.INSTANCE;
    }

    private static final Unit onWindowPop$lambda$10(String r1, JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$report");
        if (r1 == null) goto L6;
        r2.put(Params.REASON, r1);
    L6:
        return Unit.INSTANCE;
    }

    private static final Unit onWindowShow$lambda$4(String r1, JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$report");
        r2.put(Params.TRIGGER, r1);
        return Unit.INSTANCE;
    }

    private static final Unit onWindowStash$lambda$8(String r1, JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$report");
        if (r1 == null) goto L6;
        r2.put(Params.REASON, r1);
    L6:
        return Unit.INSTANCE;
    }

    public final void onWindowOpenSuccess(final String r10, final BundleParams r11) {
        Intrinsics.checkNotNullParameter(r10, Params.TRIGGER);
        final Long r0 = openStartElapsedMs;
        openStartElapsedMs = null;
        report$default(this, Events.WINDOW_OPEN_SUCCESS, null, false, new e(r10, r0, r11), 6, null);
    }

    private static final Unit onWindowOpenStart$lambda$0(String r1, BundleParams r2, JSONObject r3) {
        Intrinsics.checkNotNullParameter(r3, "$this$report");
        r3.put(Params.TRIGGER, r1);
        if (r2 == null) goto L6;
        r2.applyTo(r3);
    L6:
        return Unit.INSTANCE;
    }

    public final void beginWindowOpenPerf(long r8, String r10, BundleParams r11) {
        Intrinsics.checkNotNullParameter(r10, Params.TRIGGER);
        openPerfTrace = new WindowOpenPerfTrace(UUID.randomUUID().toString(), r10, r8, r11);
    }

    public final void onWindowOpenFail(final String r16, final Throwable r17, final BundleParams r18) {
        Intrinsics.checkNotNullParameter(r16, Params.TRIGGER);
        Intrinsics.checkNotNullParameter(r17, "throwable");
        openStartElapsedMs = null;
        report$default(this, Events.WINDOW_OPEN_FAIL, null, false, new d(r16, r17, r18), 6, null);
        WindowOpenPerfTrace r1 = openPerfTrace;
        if (r1 == null) goto L6;
        reportWindowOpenPerf$default(this, r1, WindowOpenPerfResult.FAIL, null, r17, 4, null);
        openPerfTrace = null;
        return;
    }

    public final void onWindowOpenStart(final String r8, boolean r9, final BundleParams r10) {
        Intrinsics.checkNotNullParameter(r8, Params.TRIGGER);
        lastOpenColdStart = Boolean.valueOf(r9);
        openStartElapsedMs = Long.valueOf(SystemClock.elapsedRealtime());
        report$default(this, Events.WINDOW_OPEN_START, null, false, new h(r8, r10), 6, null);
    }

    public static /* synthetic */ JSONObject buildBaseParams$default(WindowEvent r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = null;
    L6:
        return r0.buildBaseParams(r1);
    }

    public static /* synthetic */ void onWindowHide$default(WindowEvent r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        r0.onWindowHide(r1);
    }

    private static final Unit onWindowOpenFail$lambda$3(String r1, Throwable r2, BundleParams r3, JSONObject r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$report");
        r4.put(Params.TRIGGER, r1);
        r4.put(Params.ERROR_TYPE, r2.getClass().getSimpleName());
        String r5 = r2.getMessage();
        if (r5 == null) goto L5;
        r4.put(Params.ERROR_MSG, r5);
    L5:
        if (r3 == null) goto L8;
        r3.applyTo(r4);
    L8:
        return Unit.INSTANCE;
    }

    private static final Unit onWindowOpenSuccess$lambda$1(String r2, Long r3, BundleParams r4, JSONObject r5) {
        Intrinsics.checkNotNullParameter(r5, "$this$report");
        r5.put(Params.TRIGGER, r2);
        if (r3 == null) goto L5;
        r5.put("duration_ms", SystemClock.elapsedRealtime() - r3.longValue());
    L5:
        if (r4 == null) goto L8;
        r4.applyTo(r5);
    L8:
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void onWindowPop$default(WindowEvent r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        r0.onWindowPop(r1);
    }

    public static /* synthetic */ void onWindowStash$default(WindowEvent r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        r0.onWindowStash(r1);
    }

    private final void report(String r3, String r4, boolean r5, Function1<? super JSONObject, Unit> r6) {
        if (r5 == false) goto L5;
        JSONObject r7 = buildBaseParams(r4);     // Catch: Exception -> L8
    L6:
        r6.invoke(r7);     // Catch: Exception -> L8
        FLogger.a.i(TAG, "report event: " + r3 + ", params: " + r7);     // Catch: Exception -> L8
        IApplog.a.reportEvent(r3, r7);     // Catch: Exception -> L8
        return;
    L5:
        r7 = new JSONObject();     // Catch: Exception -> L8
    L8:
        e = move-exception;
        FLogger.a.w(TAG, "report failed: " + r3, e);
    }

    private static final Unit reportActivateMainView$lambda$14(Bundle r5, long r6, long r8, JSONObject r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$report");
        String r1 = r5.getString("obric_launch_method");
        if (r1 != null) goto L5;
        r1 = IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER;
    L5:
        r10.put("obric_launch_method", r1);
        r10.put("duration_ms", r6 - r8);
        long r0 = -1;
        if (lastAppBackgroundUptimeMillis <= 0) goto L8;
        long r7 = RangesKt.coerceAtLeast(r6 - lastAppBackgroundUptimeMillis, 0);
    L9:
        r10.put("last_activate_elapsed_ms", r7);
        r10.put("main_process_ready", r5.getBoolean("o_main_process_ready"));
        long r9 = iba.a.a(FlowRuntime.a().getApplication());
        if (r9 <= 0) goto L12;
        r0 = RangesKt.coerceAtLeast(SystemClock.elapsedRealtime() - r9, 0);
    L12:
        r10.put("user_unlock_elapsed_ms", r0);
        return Unit.INSTANCE;
    L8:
        r7 = -1;
        goto L9
    }

    private final void reportWindowOpenPerf(final WindowOpenPerfTrace r8, final String r9, final String r10, final Throwable r11) {
        report$default(this, Events.WINDOW_OPEN_PERF, null, false, new a(r8, r9, r10, r11), 6, null);
    }

    private final void safePutDuration(JSONObject r3, String r4, Long r5, Long r6) {
        if (r5 == null) goto L7;
        if (r6 == null) goto L8;
        r3.put(r4, Math.max(0, r6.longValue() - r5.longValue()));
        return;
    L8:
        return;
    }

    public static /* synthetic */ void onWindowOpenSuccess$default(WindowEvent r0, String r1, BundleParams r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        r0.onWindowOpenSuccess(r1, r2);
    }

    private static final Unit reportWindowOpenPerf$lambda$18(WindowOpenPerfTrace r4, String r5, String r6, Throwable r7, JSONObject r8) {
        Intrinsics.checkNotNullParameter(r8, "$this$report");
        r8.put(Params.LAUNCH_ID, r4.getLaunchId());
        r8.put(Params.TRIGGER, r4.getTrigger());
        r8.put(Params.RESULT, r5);
        Long r9 = r4.endElapsedMs();
        if (r9 == null) goto L5;
        long r0 = r9.longValue();
    L6:
        WindowEvent r10 = INSTANCE;
        r10.safePutDuration(r8, Params.TOTAL_COST_MS, Long.valueOf(r4.getStartElapsedMs()), Long.valueOf(r0));
        r10.safePutDuration(r8, Params.CREATE_COST_MS, r4.getCreateStartElapsedMs(), r4.getCreateEndElapsedMs());
        r10.safePutDuration(r8, Params.SHOW_COST_MS, r4.getShowStartElapsedMs(), r4.getShowEndElapsedMs());
        r10.safePutDuration(r8, Params.FIRST_FRAME_COST_MS, r4.getShowEndElapsedMs(), r4.getFirstFrameElapsedMs());
        if (r6 == null) goto L9;
        r8.put(Params.REASON, r6);
    L9:
        if (r7 == null) goto L13;
        r8.put(Params.ERROR_TYPE, r7.getClass().getSimpleName());
        String r11 = r7.getMessage();
        if (r11 == null) goto L13;
        r8.put(Params.ERROR_MSG, r11);
    L13:
        BundleParams r12 = r4.getExtra();
        if (r12 == null) goto L17;
        r12.applyTo(r8);
    L17:
        return Unit.INSTANCE;
    L5:
        r0 = SystemClock.elapsedRealtime();
        goto L6
    }

    public static /* synthetic */ void beginWindowOpenPerf$default(WindowEvent r0, long r1, String r3, BundleParams r4, int r5, Object r6) {
        if ((r5 & 4) == 0) goto L5;
        r4 = null;
    L5:
        r0.beginWindowOpenPerf(r1, r3, r4);
    }

    public static /* synthetic */ void onWindowOpenFail$default(WindowEvent r0, String r1, Throwable r2, BundleParams r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
    L5:
        r0.onWindowOpenFail(r1, r2, r3);
    }

    public static /* synthetic */ void onWindowOpenStart$default(WindowEvent r0, String r1, boolean r2, BundleParams r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
    L5:
        r0.onWindowOpenStart(r1, r2, r3);
    }

    public static /* synthetic */ void report$default(WindowEvent r0, String r1, String r2, boolean r3, Function1 r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r3 = true;
    L8:
        r0.report(r1, r2, r3, r4);
    }

    public static /* synthetic */ void reportWindowOpenPerf$default(WindowEvent r1, WindowOpenPerfTrace r2, String r3, String r4, Throwable r5, int r6, Object r7) {
        if ((r6 & 4) == 0) goto L6;
        r4 = null;
    L6:
        if ((r6 & 8) == 0) goto L8;
        r5 = null;
    L8:
        r1.reportWindowOpenPerf(r2, r3, r4, r5);
    }
}
