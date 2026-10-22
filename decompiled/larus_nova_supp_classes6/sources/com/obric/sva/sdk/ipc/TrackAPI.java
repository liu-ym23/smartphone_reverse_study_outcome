package com.obric.sva.sdk.ipc;

import android.os.Bundle;
import com.obric.capabilitykit.entity.app.EntityType;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.obric.sva.sdk.config.ConfigManager;
import com.obric.sva.sdk.controller.Global;
import com.obric.sva.sdk.effectplatform.UpdateTrackerType;
import com.obric.sva.sdk.session.OpaqueDataHelper;
import com.obric.sva.sdk.session.SessionType;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;
import t9a.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J.\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0005J\u001a\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001dJ*\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u00132\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010!2\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\"\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u001bJ\u001a\u0010#\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020%2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'J\u001a\u0010(\u001a\u00020\u00052\u0012\u0010)\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u000f0*J.\u0010+\u001a\u00020\u000f2\b\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010.\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\u00052\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u0005H\u0007J0\u0010+\u001a\u00020\u000f2\u0006\u0010.\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\u00052\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0005H\u0007JE\u00101\u001a\u00020\u000f2\u0006\u0010.\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\u00052\b\u00100\u001a\u0004\u0018\u00010\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u00052\b\u00102\u001a\u0004\u0018\u00010\u00052\b\u00103\u001a\u0004\u0018\u000104H\u0002¢\u0006\u0002\u00105J\u001c\u00106\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0007J\u0010\u00107\u001a\u00020\u000f2\u0006\u00108\u001a\u00020\u0005H\u0007J$\u00109\u001a\u00020\u000f2\u0006\u00108\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u0005H\u0007J\u001c\u0010;\u001a\u00020\u000f2\u0006\u00108\u001a\u00020\u00052\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u0005H\u0007J\u0010\u0010<\u001a\u00020\u000f2\u0006\u0010=\u001a\u00020\u0005H\u0007J\b\u0010>\u001a\u00020'H\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000b¨\u0006?"}, d2 = {"Lcom/obric/sva/sdk/ipc/TrackAPI;", "", "<init>", "()V", "KEY_SESSION_TYPE", "", "KEY_STAGE", "KEY_ERROR_MESSAGE", "yMdHmsSdf", "Ljava/text/SimpleDateFormat;", "getYMdHmsSdf", "()Ljava/text/SimpleDateFormat;", "yMdHmsSdf$delegate", "Lkotlin/Lazy;", "trackVoicePrintEnroll", "", "success", "", "statusCode", "", "trackVoicePrintSentence", "errorCode", "index", "sentence", "asr", "trackStage1", "sessionType", "Lcom/obric/sva/sdk/session/SessionType;", "breathArgs", "Lcom/obric/sva/sdk/session/OpaqueDataHelper$BreathStatistics;", "trackStage2", "status", "args", "", "trackerStage3", "trackerModelUpdate", "type", "Lcom/obric/sva/sdk/effectplatform/UpdateTrackerType;", "jsonObject", "Lorg/json/JSONObject;", "fillJson", "block", "Lkotlin/Function1;", "trackWakeupInterrupted", "bundle", "Landroid/os/Bundle;", "stage", "errorMessage", "extra", "trackWakeupInterruptedInternal", "startupAttemptId", "startupStartWallTimeMs", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "trackBreathScore", "trackBackTraceRecorderStart", "scene", "trackBackTraceRecorderStartResult", "errorReason", "trackBackTraceRecordError", "trackBackTraceDuration", "payloadJson", "json", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class TrackAPI {
    public static final TrackAPI INSTANCE = null;
    private static final String KEY_ERROR_MESSAGE = "error_message";
    private static final String KEY_SESSION_TYPE = "session_type";
    private static final String KEY_STAGE = "event_stage";
    private static final Lazy yMdHmsSdf$delegate = null;

    private TrackAPI() {
    }

    public static /* synthetic */ Unit a(JSONObject r0) {
        return trackVoicePrintEnroll$lambda$1(r0);
    }

    public static /* synthetic */ Unit b(int r0, JSONObject r1) {
        return trackVoicePrintEnroll$lambda$2(r0, r1);
    }

    public static /* synthetic */ SimpleDateFormat c() {
        return yMdHmsSdf_delegate$lambda$0();
    }

    @JvmStatic
    public static final void trackBackTraceRecordError(String r2) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        trackBackTraceRecordError$default(r2, null, 2, null);
    }

    @JvmStatic
    public static final void trackBackTraceRecorderStartResult(String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        trackBackTraceRecorderStartResult$default(r2, r3, null, 4, null);
    }

    @JvmStatic
    public static final void trackBreathScore(SessionType r2) {
        Intrinsics.checkNotNullParameter(r2, "sessionType");
        trackBreathScore$default(r2, null, 2, null);
    }

    @JvmStatic
    public static final void trackWakeupInterrupted(Bundle r7, String r8, String r9) {
        Intrinsics.checkNotNullParameter(r8, "stage");
        Intrinsics.checkNotNullParameter(r9, "errorMessage");
        trackWakeupInterrupted$default(r7, r8, r9, null, 8, null);
    }

    @JvmStatic
    public static final void trackWakeupInterrupted(String r7, String r8) {
        Intrinsics.checkNotNullParameter(r7, "stage");
        Intrinsics.checkNotNullParameter(r8, "errorMessage");
        trackWakeupInterrupted$default(r7, r8, null, null, 12, null);
    }

    @JvmStatic
    public static final void trackWakeupInterrupted(String r7, String r8, String r9) {
        Intrinsics.checkNotNullParameter(r7, "stage");
        Intrinsics.checkNotNullParameter(r8, "errorMessage");
        trackWakeupInterrupted$default(r7, r8, r9, null, 8, null);
    }

    static {
        INSTANCE = new TrackAPI();
        yMdHmsSdf$delegate = LazyKt.lazy(new s());
    }

    private final SimpleDateFormat getYMdHmsSdf() {
        return (SimpleDateFormat) yMdHmsSdf$delegate.getValue();
    }

    @JvmStatic
    private static final JSONObject json() {
        JSONObject r0 = new JSONObject();
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L8
        String r2 = b.b().b().a();     // Catch: Throwable -> L8
        if (r2 != null) goto L6;
        r2 = "";
    L6:
        Result.constructor-impl(r0.put("os_device_id", r2));     // Catch: Throwable -> L8
    L10:
        return r0;
    L8:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }

    private static final SimpleDateFormat yMdHmsSdf_delegate$lambda$0() {
        return new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss", Locale.getDefault());
    }

    @JvmStatic
    public static final void trackBackTraceDuration(String r2) {
        Intrinsics.checkNotNullParameter(r2, "payloadJson");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        TrackerManager.INSTANCE.onTrackEvent(EntityType.AUDITORY_RECORDING, r2);     // Catch: Throwable -> L5
        Object r3 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r4 = Result.exceptionOrNull-impl(r3);
        if (r4 == null) goto L13;
        r4.printStackTrace();
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    @JvmStatic
    public static final void trackBackTraceRecorderStart(String r2) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        JSONObject r3 = json();     // Catch: Throwable -> L5
        r3.put("scene", r2);     // Catch: Throwable -> L5
        TrackerManager.INSTANCE.onTrackEvent(500, r3.toString());     // Catch: Throwable -> L5
        Object r4 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r5 = Result.exceptionOrNull-impl(r4);
        if (r5 == null) goto L13;
        r5.printStackTrace();
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    private static final Unit trackVoicePrintEnroll$lambda$1(JSONObject r1) {
        Intrinsics.checkNotNullParameter(r1, "it");
        return Unit.INSTANCE;
    }

    public final String fillJson(Function1<? super JSONObject, Unit> r5) {
        Intrinsics.checkNotNullParameter(r5, "block");
        JSONObject r0 = json();
        r0.put("timestamp", System.currentTimeMillis());     // Catch: JSONException -> L5
        r5.invoke(r0);     // Catch: JSONException -> L5
    L8:
        return r0.toString();
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L8
    }

    public final void trackerStage3(SessionType r5) {
        Intrinsics.checkNotNullParameter(r5, "sessionType");
        JSONObject r0 = json();
        r0.put("timestamp", System.currentTimeMillis());
        r0.put(KEY_SESSION_TYPE, r5.getTag());
        TrackerManager.INSTANCE.onTrackEvent(300, r0.toString());
    }

    @JvmStatic
    public static final void trackBackTraceRecordError(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L8
        JSONObject r4 = json();     // Catch: Throwable -> L8
        r4.put("scene", r2);     // Catch: Throwable -> L8
        if (r3 != null) goto L6;
        r3 = "";
    L6:
        r4.put("error_reason", r3);     // Catch: Throwable -> L8
        TrackerManager.INSTANCE.onTrackEvent(503, r4.toString());     // Catch: Throwable -> L8
        Object r5 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r6 = Result.exceptionOrNull-impl(r5);
        if (r6 == null) goto L16;
        r6.printStackTrace();
        return;
    L16:
        return;
    L8:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }

    @JvmStatic
    public static final void trackBreathScore(SessionType r4, OpaqueDataHelper.BreathStatistics r5) {
        Intrinsics.checkNotNullParameter(r4, "sessionType");
        JSONObject r0 = json();
        r0.put("timestamp", System.currentTimeMillis());
        r0.put(KEY_SESSION_TYPE, r4.getTag());
        if (r4 != SessionType.BREATH) goto L12;
        if (r5 == null) goto L12;
        if (r5.valid() == false) goto L12;
        float[] r6 = OpaqueDataHelper.calculateAverageScores(r5.payload);
        r0.put("trace_back", r5.traceBack);
        r0.put("credibility", r5.credibility);
        r0.put("engine_version", r5.engineVersion);
        if (r6 == null) goto L12;
        if (r6.length < 3) goto L12;
        r0.put("imu_score", Float.valueOf(r6[0]));
        r0.put("near_score", Float.valueOf(r6[1]));
        r0.put("vad_score", Float.valueOf(r6[2]));
    L12:
        TrackerManager.INSTANCE.onTrackEvent(104, r0.toString());
    }

    private static final Unit trackVoicePrintEnroll$lambda$2(int r1, JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        r2.put("code", r1);
        return Unit.INSTANCE;
    }

    public final void trackStage1(SessionType r5, OpaqueDataHelper.BreathStatistics r6) {
        Intrinsics.checkNotNullParameter(r5, "sessionType");
        JSONObject r0 = json();
        r0.put("timestamp", System.currentTimeMillis());
        r0.put(KEY_SESSION_TYPE, r5.getTag());
        if (r5 != SessionType.BREATH) goto L15;
        if (r6 == null) goto L15;
        if (r6.valid() == false) goto L15;
        r0.put("trace_back", r6.traceBack);
        r0.put("cur_time", r6.curTime);
        r0.put("imu_start_time", r6.imuStartTime);
        r0.put("vad_start_time", r6.vadStartTime);
        r0.put("near_start_time", r6.nearStartTime);
        r0.put("credibility", r6.credibility);
        r0.put("millis_to_read", r6.millisToRead);
        r0.put("engine_version", r6.engineVersion);
        r0.put("upload_algo_info_size", r6.uploadAlgoInfoSize);
        r0.put("upload_algo_result_num", r6.uploadAlgoResultNum);
        r0.put("user_flag", r6.userFlag);
        r0.put("born", r6.born);
        int[] r7 = r6.payload;
        if (r7 == null) goto L10;
        Integer r8 = Integer.valueOf(r7.length);
    L11:
        r0.put("payload_size", r8);
        Iterator r9 = r6.userData.entrySet().iterator();
    L13:
        if (r9.hasNext() == false) goto L15;
        Map.Entry r10 = (Map.Entry) r9.next();
        r0.put((String) r10.getKey(), r10.getValue());
        goto L13
    L10:
        r8 = null;
    L15:
        TrackerManager.INSTANCE.onTrackEvent(100, r0.toString());
    }

    public final void trackVoicePrintEnroll(boolean r2, int r3) {
        if (r2 == false) goto L4;
        TrackerManager.INSTANCE.onTrackEvent(11, fillJson(new q()));
        return;
    L4:
        TrackerManager.INSTANCE.onTrackEvent(12, fillJson(new r(r3)));
    }

    public final void trackerModelUpdate(UpdateTrackerType r4, JSONObject r5) {
        Intrinsics.checkNotNullParameter(r4, "type");
        if (r5 != null) goto L5;
        r5 = json();
    L5:
        r5.put("timestamp", System.currentTimeMillis());
        r5.put("date", INSTANCE.getYMdHmsSdf().format(new Date()));
        ConfigManager r0 = ConfigManager.INSTANCE;
        String r1 = r0.getModelConfig().getOwner();
        if (r1 != null) goto L8;
        r1 = "";
    L8:
        r5.put("model_config_owner", r1);
        r5.put("model_config_version", r0.getStage2Config().getVersion());
        r5.put("voiceprint_model_version", r0.getStage2Config().getVoiceprint_modelVersion());
        r5.put("kws_model_version", r0.getStage2Config().getKwsmodelVersion());
        TrackerManager.INSTANCE.onTrackEvent(r4.getI(), r5.toString());
    }

    @JvmStatic
    public static final void trackBackTraceRecorderStartResult(String r2, boolean r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L8
        JSONObject r5 = json();     // Catch: Throwable -> L8
        r5.put("scene", r2);     // Catch: Throwable -> L8
        r5.put("success", r3);     // Catch: Throwable -> L8
        if (r4 != null) goto L6;
        r4 = "";
    L6:
        r5.put("error_reason", r4);     // Catch: Throwable -> L8
        TrackerManager.INSTANCE.onTrackEvent(EntityType.RECORDING, r5.toString());     // Catch: Throwable -> L8
        Object r6 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r7 = Result.exceptionOrNull-impl(r6);
        if (r7 == null) goto L16;
        r7.printStackTrace();
        return;
    L16:
        return;
    L8:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }

    public final void trackStage2(int r19, Map<String, ? extends Object> r20, SessionType r21) {
        Intrinsics.checkNotNullParameter(r20, "args");
        Intrinsics.checkNotNullParameter(r21, "sessionType");
        JSONObject r15 = json();
        r15.put("timestamp", System.currentTimeMillis());     // Catch: JSONException -> L15
        r15.put(KEY_SESSION_TYPE, r21.getTag());     // Catch: JSONException -> L15
        if (r21 != SessionType.VOICE) goto L7;
        r15.put("dump_audio_file_id", r20.get("fileId"));     // Catch: JSONException -> L15
        r15.put("rejectType", r20.get("rejectType"));     // Catch: JSONException -> L15
        r15.put("stage1_kw_confidence_level", "" + r20.get("stage1_kw_confidence_level"));     // Catch: JSONException -> L15
        r15.put("stage1_usr_confidence_level", "" + r20.get("stage1_usr_confidence_level"));     // Catch: JSONException -> L15
        r15.put("kws_score", r20.get("kws_score"));     // Catch: JSONException -> L15
        r15.put("kws_frame", "" + r20.get("kws_frame"));     // Catch: JSONException -> L15
        r15.put("kws_word", "" + r20.get("kws_word"));     // Catch: JSONException -> L15
        r15.put("kws_threshold", r20.get("kws_threshold"));     // Catch: JSONException -> L15
        r15.put("kws_result", "" + r20.get("kws_result"));     // Catch: JSONException -> L15
        r15.put("sid_threshold", r20.get("sid_threshold"));     // Catch: JSONException -> L15
        r15.put("sid_score", r20.get("sid_score"));     // Catch: JSONException -> L15
        r15.put("sid_result", "" + r20.get("sid_result"));     // Catch: JSONException -> L15
        r15.put("sid_error", "" + r20.get("sid_error"));     // Catch: JSONException -> L15
    L7:
        r15.put("sid_switch", "" + Global.sWakeupSid);     // Catch: JSONException -> L15
        r15.put("wakeup_switch", "" + Global.sWakeupStatus);     // Catch: JSONException -> L15
        r15.put("breath_switch", "" + Global.getBreathStatus());     // Catch: JSONException -> L15
        r15.put("sva_framework_version", "0.0.3.repo");     // Catch: JSONException -> L15
        r15.put("audio_sdk_version", "com.bytedance:audiosdk:0.0.1");     // Catch: JSONException -> L15
        ConfigManager r1 = ConfigManager.INSTANCE;     // Catch: JSONException -> L15
        r15.put("model_config_version", r1.getStage2Config().getVersion());     // Catch: JSONException -> L15
        r15.put("voiceprint_model_version", r1.getStage2Config().getVoiceprint_modelVersion());     // Catch: JSONException -> L15
        r15.put("kws_model_version", r1.getStage2Config().getKwsmodelVersion());     // Catch: JSONException -> L15
        r15.put("manifest_content", r1.getModelConfig().toString());     // Catch: JSONException -> L15
        r15.put("model_config_content", r1.getStage2Config().toString());     // Catch: JSONException -> L15
        if (r19 != 0) goto L11;
    L13:
        TrackerManager.INSTANCE.onTrackEvent(200, r15.toString());
        return;
    L11:
        if (r19 == 1) goto L13;
        TrackerManager.INSTANCE.onTrackEvent(EntityType.CONTACT, r15.toString());
        return;
    L15:
        e = move-exception;
        e.printStackTrace();
    }

    public static /* synthetic */ void trackBackTraceRecordError$default(String r0, String r1, int r2, Object r3) {
        if ((r2 & 2) == 0) goto L5;
        r1 = null;
    L5:
        trackBackTraceRecordError(r0, r1);
    }

    public static /* synthetic */ void trackBreathScore$default(SessionType r0, OpaqueDataHelper.BreathStatistics r1, int r2, Object r3) {
        if ((r2 & 2) == 0) goto L5;
        r1 = new OpaqueDataHelper.BreathStatistics();
    L5:
        trackBreathScore(r0, r1);
    }

    @JvmStatic
    public static final void trackWakeupInterrupted(Bundle r10, String r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r11, "stage");
        Intrinsics.checkNotNullParameter(r12, "errorMessage");
        if (r10 == null) goto L5;
        String r6 = r10.getString("sessionName", "");
    L6:
        TrackAPI r2 = INSTANCE;
        boolean r1 = true;
        if (r10 == null) goto L13;
        String r3 = r10.getString("obric_startup_attempt_id");
        if (r3 == null) goto L13;
        if ((!StringsKt.isBlank(r3)) == false) goto L13;
        String r7 = r3;
    L14:
        if (r10 == null) goto L21;
        Long r14 = Long.valueOf(r10.getLong("REQUEST_TIME", 0));
        if (r14.longValue() > 0) goto L19;
        r1 = false;
    L19:
        if (r1 == false) goto L21;
        Long r8 = r14;
    L22:
        r2.trackWakeupInterruptedInternal(r11, r12, r13, r6, r7, r8);
        return;
    L21:
        r8 = null;
    L13:
        r7 = null;
        goto L14
    L5:
        r6 = null;
        goto L6
    }

    @JvmStatic
    public static final void trackWakeupInterrupted(String r8, String r9, String r10, String r11) {
        Intrinsics.checkNotNullParameter(r8, "stage");
        Intrinsics.checkNotNullParameter(r9, "errorMessage");
        INSTANCE.trackWakeupInterruptedInternal(r8, r9, r10, r11, null, null);
    }

    public static /* synthetic */ void trackBackTraceRecorderStartResult$default(String r0, boolean r1, String r2, int r3, Object r4) {
        if ((r3 & 4) == 0) goto L5;
        r2 = null;
    L5:
        trackBackTraceRecorderStartResult(r0, r1, r2);
    }

    public static /* synthetic */ void trackStage1$default(TrackAPI r0, SessionType r1, OpaqueDataHelper.BreathStatistics r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = new OpaqueDataHelper.BreathStatistics();
    L5:
        r0.trackStage1(r1, r2);
    }

    public static /* synthetic */ void trackerModelUpdate$default(TrackAPI r0, UpdateTrackerType r1, JSONObject r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        r0.trackerModelUpdate(r1, r2);
    }

    public final void trackVoicePrintSentence(boolean r5, int r6, int r7, String r8, String r9) {
        Intrinsics.checkNotNullParameter(r8, "sentence");
        Intrinsics.checkNotNullParameter(r9, "asr");
        JSONObject r2 = json();
        r2.put("success", r5);     // Catch: Exception -> L6
        r2.put("error", r6);     // Catch: Exception -> L6
        r2.put("index", r7);     // Catch: Exception -> L6
        r2.put("sentence", r8);     // Catch: Exception -> L6
        r2.put("asr", r9);     // Catch: Exception -> L6
    L4:
        TrackerManager.INSTANCE.onTrackEvent(13, r2.toString());
    }

    public static /* synthetic */ void trackWakeupInterrupted$default(String r0, String r1, String r2, String r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r2 = "";
    L6:
        if ((r4 & 8) == 0) goto L8;
        r3 = SessionType.VOICE.getTag();
    L8:
        trackWakeupInterrupted(r0, r1, r2, r3);
    }

    private final void trackWakeupInterruptedInternal(String r3, String r4, String r5, String r6, String r7, Long r8) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L12
        JSONObject r1 = json();     // Catch: Throwable -> L12
        r1.put(KEY_STAGE, r3);     // Catch: Throwable -> L12
        if (r6 != null) goto L5;
        r6 = "";
    L5:
        r1.put(KEY_SESSION_TYPE, r6);     // Catch: Throwable -> L12
        r1.put(KEY_ERROR_MESSAGE, r4);     // Catch: Throwable -> L12
        r1.put("extra", r5);     // Catch: Throwable -> L12
        r1.put("obric_startup_failure_wall_ms", System.currentTimeMillis());     // Catch: Throwable -> L12
        if (r7 == null) goto L8;
        r1.put("obric_startup_attempt_id", r7);     // Catch: Throwable -> L12
    L8:
        if (r8 == null) goto L10;
        r1.put("REQUEST_TIME", r8.longValue());     // Catch: Throwable -> L12
    L10:
        TrackerManager.INSTANCE.onTrackEvent(400, r1.toString());     // Catch: Throwable -> L12
        Object r9 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L12
    L14:
        Throwable r10 = Result.exceptionOrNull-impl(r9);
        if (r10 == null) goto L20;
        r10.printStackTrace();
        return;
    L20:
        return;
    L12:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    }

    public static /* synthetic */ void trackWakeupInterrupted$default(Bundle r0, String r1, String r2, String r3, int r4, Object r5) {
        if ((r4 & 8) == 0) goto L5;
        r3 = "";
    L5:
        trackWakeupInterrupted(r0, r1, r2, r3);
    }
}
