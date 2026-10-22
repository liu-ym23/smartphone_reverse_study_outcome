package com.obric.aiproactive.api;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0010\u0002\n\u0002\b \n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000 s2\u00020\u0001:\u0001sB\u009d\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u000e\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u000e\u0012\u000e\b\u0002\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\f¢\u0006\u0004\b#\u0010$B\u0011\b\u0016\u0012\u0006\u0010%\u001a\u00020&¢\u0006\u0004\b#\u0010'J\u0018\u0010L\u001a\u00020M2\u0006\u0010%\u001a\u00020&2\u0006\u0010N\u001a\u00020\u0014H\u0016J\b\u0010O\u001a\u00020\u0014H\u0016J\t\u0010P\u001a\u00020\u0003HÆ\u0003J\t\u0010Q\u001a\u00020\u0003HÆ\u0003J\t\u0010R\u001a\u00020\u0003HÆ\u0003J\t\u0010S\u001a\u00020\u0003HÆ\u0003J\t\u0010T\u001a\u00020\u0003HÆ\u0003J\u000b\u0010U\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010X\u001a\b\u0012\u0004\u0012\u00020\u00030\fHÆ\u0003J\t\u0010Y\u001a\u00020\u000eHÆ\u0003J\t\u0010Z\u001a\u00020\u0010HÆ\u0003J\t\u0010[\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\\\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010]\u001a\u00020\u0014HÆ\u0003J\t\u0010^\u001a\u00020\u0003HÆ\u0003J\t\u0010_\u001a\u00020\u0003HÆ\u0003J\u0010\u0010`\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010>J\t\u0010a\u001a\u00020\u0003HÆ\u0003J\u000b\u0010b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010f\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0002\u0010FJ\t\u0010g\u001a\u00020\u000eHÆ\u0003J\t\u0010h\u001a\u00020\u000eHÆ\u0003J\u0010\u0010i\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010>J\u000f\u0010j\u001a\b\u0012\u0004\u0012\u00020\"0\fHÆ\u0003J¾\u0002\u0010k\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u0018\u001a\u00020\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u001e\u001a\u00020\u000e2\b\b\u0002\u0010\u001f\u001a\u00020\u000e2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u000e2\u000e\b\u0002\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\fHÆ\u0001¢\u0006\u0002\u0010lJ\u0013\u0010m\u001a\u00020n2\b\u0010o\u001a\u0004\u0018\u00010pHÖ\u0003J\t\u0010q\u001a\u00020\u0014HÖ\u0001J\t\u0010r\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010)R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010)R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010)R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010)R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010)R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010)R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u0010)R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\f¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b7\u0010)R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b8\u0010)R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u0011\u0010\u0015\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b;\u0010)R\u0011\u0010\u0016\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b<\u0010)R\u0015\u0010\u0017\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010?\u001a\u0004\b=\u0010>R\u0011\u0010\u0018\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b@\u0010)R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bA\u0010)R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bB\u0010)R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bC\u0010)R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bD\u0010)R\u0015\u0010\u001d\u001a\u0004\u0018\u00010\u0014¢\u0006\n\n\u0002\u0010G\u001a\u0004\bE\u0010FR\u0011\u0010\u001e\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bH\u00104R\u0011\u0010\u001f\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bI\u00104R\u0015\u0010 \u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010?\u001a\u0004\bJ\u0010>R\u0017\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\f¢\u0006\b\n\u0000\u001a\u0004\bK\u00102¨\u0006t"}, d2 = {"Lcom/obric/aiproactive/api/ProactiveRecommendationDto;", "Landroid/os/Parcelable;", "recommendId", "", "taskId", "subscriptionId", "recommendText", "emoji", "actionCondition", "actionExecuteInstruction", "actionContext", "sourcePackages", "", "created", "", "score", "", InfoRequestQPSOptTraceLogger.REASON, "evidence", "recommendStatus", "", "status", "type", "expireAtMs", "inspirationId", "inspirationFeedbackAction", "inspirationUserFeedback", "inspirationFeedbackReason", "inspirationFeedbackText", "inspirationFeedbackValue", "inspirationUpdated", "inspirationTimestamp", "traceId", "artifacts", "Lcom/obric/aiproactive/api/AiProactiveArtifact;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;JDLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;JJLjava/lang/Long;Ljava/util/List;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getRecommendId", "()Ljava/lang/String;", "getTaskId", "getSubscriptionId", "getRecommendText", "getEmoji", "getActionCondition", "getActionExecuteInstruction", "getActionContext", "getSourcePackages", "()Ljava/util/List;", "getCreated", "()J", "getScore", "()D", "getReason", "getEvidence", "getRecommendStatus", "()I", "getStatus", "getType", "getExpireAtMs", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getInspirationId", "getInspirationFeedbackAction", "getInspirationUserFeedback", "getInspirationFeedbackReason", "getInspirationFeedbackText", "getInspirationFeedbackValue", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getInspirationUpdated", "getInspirationTimestamp", "getTraceId", "getArtifacts", "writeToParcel", "", "flags", "describeContents", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;JDLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;JJLjava/lang/Long;Ljava/util/List;)Lcom/obric/aiproactive/api/ProactiveRecommendationDto;", "equals", "", "other", "", "hashCode", "toString", "CREATOR", "ai_proactive_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ProactiveRecommendationDto implements Parcelable {
    public static final a CREATOR = null;
    private static final long PROACTIVE_EXPIRE_AT_MS_VERSION_CODE = 1130200201;
    private static final String TAG = "ProactiveRecommendationDto";
    private final String actionCondition;
    private final String actionContext;
    private final String actionExecuteInstruction;
    private final List<j> artifacts;
    private final long created;
    private final String emoji;
    private final String evidence;
    private final Long expireAtMs;
    private final String inspirationFeedbackAction;
    private final String inspirationFeedbackReason;
    private final String inspirationFeedbackText;
    private final Integer inspirationFeedbackValue;
    private final String inspirationId;
    private final long inspirationTimestamp;
    private final long inspirationUpdated;
    private final String inspirationUserFeedback;
    private final String reason;
    private final String recommendId;
    private final int recommendStatus;
    private final String recommendText;
    private final double score;
    private final List<String> sourcePackages;
    private final String status;
    private final String subscriptionId;
    private final String taskId;
    private final Long traceId;
    private final String type;

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u001d\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¢\u0006\u0002\u0010\u0010J\u0015\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\bH\u0000¢\u0006\u0002\b\u0014J\u0015\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\bH\u0000¢\u0006\u0002\b\u0016J#\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\u00182\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0018H\u0000¢\u0006\u0002\b\u001aJ\u0017\u0010\u001b\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010\u001cJ\u001f\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u001f\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0002\u0010 J\u000f\u0010!\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0002\u0010\"J\b\u0010#\u001a\u00020\u0012H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/obric/aiproactive/api/ProactiveRecommendationDto$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/aiproactive/api/ProactiveRecommendationDto;", "<init>", "()V", "TAG", "", "PROACTIVE_EXPIRE_AT_MS_VERSION_CODE", "", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/obric/aiproactive/api/ProactiveRecommendationDto;", "supportsExpireAtMs", "", "versionCode", "supportsExpireAtMs$ai_proactive_api_obricRelease", "supportsFeedbackRestoreFields", "supportsFeedbackRestoreFields$ai_proactive_api_obricRelease", "safeSourcePackagesForParcel", "", "sourcePackages", "safeSourcePackagesForParcel$ai_proactive_api_obricRelease", "readNullableLong", "(Landroid/os/Parcel;)Ljava/lang/Long;", "writeNullableLong", "", EventBody.KEY_VALUE, "(Landroid/os/Parcel;Ljava/lang/Long;)V", "installedProactiveVersionCode", "()Ljava/lang/Long;", "isAiProactiveExpireAtMsVersion", "ai_proactive_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements Parcelable.Creator<ProactiveRecommendationDto> {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        private final Long a() {
            Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
            a r4 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
            Object r5 = Result.m1421constructorimpl(Long.valueOf(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getPackageManager().getPackageInfo(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getPackageName(), 0).versionCode));     // Catch: Throwable -> L5
        L7:
            Throwable r2 = Result.m1424exceptionOrNullimpl(r5);
            if (r2 == null) goto L12;
            RunLog.INSTANCE.warn(ProactiveRecommendationDto.TAG, "[ParcelWrite] resolve proactive versionCode failed", r2);
            r5 = null;
        L12:
            return (Long) ZeusTransformUtils.preCheckCast(r5, Long.class, "com.obric.memorydata.plugin");
        L5:
            th = move-exception;
            Result.Companion r3 = Result.Companion;
            r5 = Result.m1421constructorimpl(ResultKt.createFailure(th));
            goto L7
        }

        public static final /* synthetic */ Long a(a r0, Parcel r1) {
            return r0.b(r1);
        }

        private final void a(Parcel r3, Long r4) {
            if (r4 != null) goto L4;
            r3.writeInt(0);
            return;
        L4:
            r3.writeInt(1);
            r3.writeLong(r4.longValue());
        }

        public static final /* synthetic */ void a(a r0, Parcel r1, Long r2) {
            r0.a(r1, r2);
        }

        public static final /* synthetic */ boolean a(a r0) {
            return r0.b();
        }

        private final Long b(Parcel r1) {
            if (r1.readInt() != 0) goto L6;
            return null;
        L6:
            return Long.valueOf(r1.readLong());
        }

        public static final /* synthetic */ Long b(a r0) {
            return r0.a();
        }

        private final boolean b() {
            Long r0 = a();
            if (r0 != null) goto L7;
            return false;
        L7:
            return a(((Number) ZeusTransformUtils.preCheckCast(r0, Number.class, "com.obric.memorydata.plugin")).longValue());
        }

        public ProactiveRecommendationDto a(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new ProactiveRecommendationDto(r1);
        }

        public final List<String> a(List<String> r2) {
            List<String> r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
            if (r1 == null) goto L5;
            return r1;
        L5:
            return CollectionsKt.emptyList();
        }

        public final boolean a(long r3) {
            if (r3 < ProactiveRecommendationDto.PROACTIVE_EXPIRE_AT_MS_VERSION_CODE) goto L5;
            return true;
        L5:
            return false;
        }

        public ProactiveRecommendationDto[] a(int r1) {
            return new ProactiveRecommendationDto[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ ProactiveRecommendationDto createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ ProactiveRecommendationDto[] newArray(int r1) {
            return a(r1);
        }
    }

    static {
        CREATOR = new a(null);
    }

    public ProactiveRecommendationDto(Parcel r38) {
        Intrinsics.checkNotNullParameter(r38, "parcel");
        String r1 = r38.readString();
        if (r1 != null) goto L5;
        String r4 = "";
    L6:
        String r2 = r38.readString();
        if (r2 != null) goto L9;
        String r5 = "";
    L10:
        String r3 = r38.readString();
        if (r3 != null) goto L13;
        String r6 = "";
    L14:
        String r7 = r38.readString();
        if (r7 != null) goto L17;
        String r8 = "";
    L18:
        String r9 = r38.readString();
        if (r9 != null) goto L21;
        String r10 = "";
    L22:
        String r11 = r38.readString();
        String r12 = r38.readString();
        String r13 = r38.readString();
        ArrayList<String> r14 = r38.createStringArrayList();
        if (r14 == null) goto L25;
        List r15 = (List) ZeusTransformUtils.preCheckCast(r14, List.class, "com.obric.memorydata.plugin");
    L26:
        List r16 = r15;
        long r17 = r38.readLong();
        double r18 = r38.readDouble();
        String r19 = r38.readString();
        if (r19 != null) goto L29;
        String r110 = "";
    L30:
        String r111 = r38.readString();
        int r112 = r38.readInt();
        String r20 = r38.readString();
        if (r20 != null) goto L33;
        String r21 = "";
    L34:
        String r22 = r38.readString();
        if (r22 != null) goto L37;
        String r23 = "";
    L38:
        a r24 = CREATOR;
        if (a.a(r24) == false) goto L41;
        Long r25 = a.a(r24, r38);
    L42:
        Long r26 = r25;
        String r27 = r38.readString();
        if (r27 != null) goto L45;
        String r28 = "";
    L46:
        this(r4, r5, r6, r8, r10, r11, r12, r13, r16, r17, r18, r110, r111, r112, r21, r23, r26, r28, r38.readString(), r38.readString(), null, null, null, r38.readLong(), r38.readLong(), null, null, 100663296, null);
        return;
    L45:
        r28 = r27;
        goto L46
    L41:
        r25 = null;
        goto L42
    L37:
        r23 = r22;
        goto L38
    L33:
        r21 = r20;
        goto L34
    L29:
        r110 = r19;
        goto L30
    L25:
        r15 = CollectionsKt.emptyList();
        goto L26
    L21:
        r10 = r9;
        goto L22
    L17:
        r8 = r7;
        goto L18
    L13:
        r6 = r3;
        goto L14
    L9:
        r5 = r2;
        goto L10
    L5:
        r4 = r1;
        goto L6
    }

    public ProactiveRecommendationDto(String r15, String r16, String r17, String r18, String r19, String r20, String r21, String r22, List<String> r23, long r24, double r26, String r28, String r29, int r30, String r31, String r32, Long r33, String r34, String r35, String r36, String r37, String r38, Integer r39, long r40, long r42, Long r44, List<j> r45) {
        List<String> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r23, List.class, "com.obric.memorydata.plugin");
        List<j> r11 = (List) ZeusTransformUtils.wrapperContextForParams(r45, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r15, "recommendId");
        Intrinsics.checkNotNullParameter(r16, "taskId");
        Intrinsics.checkNotNullParameter(r17, "subscriptionId");
        Intrinsics.checkNotNullParameter(r18, "recommendText");
        Intrinsics.checkNotNullParameter(r19, "emoji");
        Intrinsics.checkNotNullParameter(r10, "sourcePackages");
        Intrinsics.checkNotNullParameter(r28, InfoRequestQPSOptTraceLogger.REASON);
        Intrinsics.checkNotNullParameter(r31, "status");
        Intrinsics.checkNotNullParameter(r32, "type");
        Intrinsics.checkNotNullParameter(r34, "inspirationId");
        Intrinsics.checkNotNullParameter(r11, "artifacts");
        this.recommendId = r15;
        this.taskId = r16;
        this.subscriptionId = r17;
        this.recommendText = r18;
        this.emoji = r19;
        this.actionCondition = r20;
        this.actionExecuteInstruction = r21;
        this.actionContext = r22;
        this.sourcePackages = r10;
        this.created = r24;
        this.score = r26;
        this.reason = r28;
        this.evidence = r29;
        this.recommendStatus = r30;
        this.status = r31;
        this.type = r32;
        this.expireAtMs = r33;
        this.inspirationId = r34;
        this.inspirationFeedbackAction = r35;
        this.inspirationUserFeedback = r36;
        this.inspirationFeedbackReason = r37;
        this.inspirationFeedbackText = r38;
        this.inspirationFeedbackValue = r39;
        this.inspirationUpdated = r40;
        this.inspirationTimestamp = r42;
        this.traceId = r44;
        this.artifacts = r11;
    }

    public /* synthetic */ ProactiveRecommendationDto(String r36, String r37, String r38, String r39, String r40, String r41, String r42, String r43, List r44, long r45, double r47, String r49, String r50, int r51, String r52, String r53, Long r54, String r55, String r56, String r57, String r58, String r59, Integer r60, long r61, long r63, Long r65, List r66, int r67, DefaultConstructorMarker r68) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r44, List.class, "com.obric.memorydata.plugin");
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r66, List.class, "com.obric.memorydata.plugin");
        if ((r67 & 256) == 0) goto L5;
        r1 = CollectionsKt.emptyList();
    L5:
        List r12 = r1;
        if ((r67 & 4096) == 0) goto L8;
        String r18 = null;
    L10:
        if ((r67 & 8192) == 0) goto L12;
        int r19 = 1;
    L14:
        if ((65536 & r67) == 0) goto L16;
        Long r22 = null;
    L18:
        if ((131072 & r67) == 0) goto L20;
        String r23 = "";
    L22:
        if ((262144 & r67) == 0) goto L24;
        String r24 = null;
    L26:
        if ((524288 & r67) == 0) goto L28;
        String r25 = null;
    L30:
        if ((1048576 & r67) == 0) goto L32;
        String r26 = null;
    L34:
        if ((2097152 & r67) == 0) goto L36;
        String r27 = null;
    L38:
        if ((4194304 & r67) == 0) goto L40;
        Integer r28 = null;
    L42:
        if ((8388608 & r67) == 0) goto L44;
        long r29 = 0;
    L46:
        if ((16777216 & r67) == 0) goto L48;
        long r31 = 0;
    L50:
        if ((33554432 & r67) == 0) goto L52;
        Long r33 = null;
    L54:
        if ((r67 & AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) == 0) goto L56;
        r2 = CollectionsKt.emptyList();
    L56:
        this(r36, r37, r38, r39, r40, r41, r42, r43, r12, r45, r47, r49, r18, r19, r52, r53, r22, r23, r24, r25, r26, r27, r28, r29, r31, r33, r2);
        return;
    L52:
        r33 = r65;
        goto L54
    L48:
        r31 = r63;
        goto L50
    L44:
        r29 = r61;
        goto L46
    L40:
        r28 = r60;
        goto L42
    L36:
        r27 = r59;
        goto L38
    L32:
        r26 = r58;
        goto L34
    L28:
        r25 = r57;
        goto L30
    L24:
        r24 = r56;
        goto L26
    L20:
        r23 = r55;
        goto L22
    L16:
        r22 = r54;
        goto L18
    L12:
        r19 = r51;
        goto L14
    L8:
        r18 = r50;
        goto L10
    }

    public static /* synthetic */ ProactiveRecommendationDto copy$default(ProactiveRecommendationDto r17, String r18, String r19, String r20, String r21, String r22, String r23, String r24, String r25, List r26, long r27, double r29, String r31, String r32, int r33, String r34, String r35, Long r36, String r37, String r38, String r39, String r40, String r41, Integer r42, long r43, long r45, Long r47, List r48, int r49, Object r50) {
        List<String> r2 = (List) ZeusTransformUtils.wrapperContextForParams(r26, List.class, "com.obric.memorydata.plugin");
        List<j> r3 = (List) ZeusTransformUtils.wrapperContextForParams(r48, List.class, "com.obric.memorydata.plugin");
        if ((r49 & 1) == 0) goto L5;
        String r4 = r17.recommendId;
    L7:
        if ((r49 & 2) == 0) goto L9;
        String r5 = r17.taskId;
    L11:
        if ((r49 & 4) == 0) goto L13;
        String r6 = r17.subscriptionId;
    L15:
        if ((r49 & 8) == 0) goto L17;
        String r7 = r17.recommendText;
    L19:
        if ((r49 & 16) == 0) goto L21;
        String r8 = r17.emoji;
    L23:
        if ((r49 & 32) == 0) goto L25;
        String r9 = r17.actionCondition;
    L27:
        if ((r49 & 64) == 0) goto L29;
        String r10 = r17.actionExecuteInstruction;
    L31:
        if ((r49 & 128) == 0) goto L33;
        String r11 = r17.actionContext;
    L35:
        if ((r49 & 256) == 0) goto L38;
        r2 = r17.sourcePackages;
    L38:
        if ((r49 & 512) == 0) goto L40;
        long r12 = r17.created;
    L42:
        if ((r49 & 1024) == 0) goto L44;
        double r14 = r17.score;
    L46:
        if ((r49 & 2048) == 0) goto L48;
        String r13 = r17.reason;
    L49:
        String r310 = r13;
        if ((r49 & 4096) == 0) goto L52;
        String r15 = r17.evidence;
    L53:
        String r311 = r15;
        if ((r49 & 8192) == 0) goto L56;
        int r16 = r17.recommendStatus;
    L57:
        int r312 = r16;
        if ((r49 & 16384) == 0) goto L60;
        String r28 = r17.status;
    L61:
        String r313 = r28;
        if ((r49 & 32768) == 0) goto L64;
        String r30 = r17.type;
    L65:
        String r314 = r30;
        if ((r49 & 65536) == 0) goto L68;
        Long r44 = r17.expireAtMs;
    L69:
        Long r315 = r44;
        if ((r49 & 131072) == 0) goto L72;
        String r46 = r17.inspirationId;
    L73:
        String r316 = r46;
        if ((r49 & 262144) == 0) goto L76;
        String r51 = r17.inspirationFeedbackAction;
    L77:
        String r317 = r51;
        if ((r49 & 524288) == 0) goto L80;
        String r52 = r17.inspirationUserFeedback;
    L81:
        String r318 = r52;
        if ((r49 & 1048576) == 0) goto L84;
        String r53 = r17.inspirationFeedbackReason;
    L85:
        String r410 = r53;
        if ((r49 & 2097152) == 0) goto L88;
        String r54 = r17.inspirationFeedbackText;
    L89:
        String r411 = r54;
        if ((r49 & 4194304) == 0) goto L92;
        Integer r55 = r17.inspirationFeedbackValue;
    L93:
        double r210 = r14;
        if ((r49 & 8388608) == 0) goto L96;
        long r110 = r17.inspirationUpdated;
    L97:
        long r412 = r110;
        if ((r49 & 16777216) == 0) goto L100;
        long r111 = r17.inspirationTimestamp;
    L101:
        long r413 = r111;
        if ((r49 & 33554432) == 0) goto L104;
        Long r112 = r17.traceId;
    L106:
        if ((r49 & AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) == 0) goto L108;
        List<j> r1 = r17.artifacts;
    L110:
        return r17.copy(r4, r5, r6, r7, r8, r9, r10, r11, r2, r12, r210, r310, r311, r312, r313, r314, r315, r316, r317, r318, r410, r411, r55, r412, r413, r112, r1);
    L108:
        r1 = r3;
        goto L110
    L104:
        r112 = r47;
        goto L106
    L100:
        r111 = r45;
        goto L101
    L96:
        r110 = r43;
        goto L97
    L92:
        r55 = r42;
        goto L93
    L88:
        r54 = r41;
        goto L89
    L84:
        r53 = r40;
        goto L85
    L80:
        r52 = r39;
        goto L81
    L76:
        r51 = r38;
        goto L77
    L72:
        r46 = r37;
        goto L73
    L68:
        r44 = r36;
        goto L69
    L64:
        r30 = r35;
        goto L65
    L60:
        r28 = r34;
        goto L61
    L56:
        r16 = r33;
        goto L57
    L52:
        r15 = r32;
        goto L53
    L48:
        r13 = r31;
        goto L49
    L44:
        r14 = r29;
        goto L46
    L40:
        r12 = r27;
        goto L42
    L33:
        r11 = r25;
        goto L35
    L29:
        r10 = r24;
        goto L31
    L25:
        r9 = r23;
        goto L27
    L21:
        r8 = r22;
        goto L23
    L17:
        r7 = r21;
        goto L19
    L13:
        r6 = r20;
        goto L15
    L9:
        r5 = r19;
        goto L11
    L5:
        r4 = r18;
        goto L7
    }

    public final String component1() {
        return this.recommendId;
    }

    public final long component10() {
        return this.created;
    }

    public final double component11() {
        return this.score;
    }

    public final String component12() {
        return this.reason;
    }

    public final String component13() {
        return this.evidence;
    }

    public final int component14() {
        return this.recommendStatus;
    }

    public final String component15() {
        return this.status;
    }

    public final String component16() {
        return this.type;
    }

    public final Long component17() {
        return this.expireAtMs;
    }

    public final String component18() {
        return this.inspirationId;
    }

    public final String component19() {
        return this.inspirationFeedbackAction;
    }

    public final String component2() {
        return this.taskId;
    }

    public final String component20() {
        return this.inspirationUserFeedback;
    }

    public final String component21() {
        return this.inspirationFeedbackReason;
    }

    public final String component22() {
        return this.inspirationFeedbackText;
    }

    public final Integer component23() {
        return this.inspirationFeedbackValue;
    }

    public final long component24() {
        return this.inspirationUpdated;
    }

    public final long component25() {
        return this.inspirationTimestamp;
    }

    public final Long component26() {
        return this.traceId;
    }

    public final List<j> component27() {
        return this.artifacts;
    }

    public final String component3() {
        return this.subscriptionId;
    }

    public final String component4() {
        return this.recommendText;
    }

    public final String component5() {
        return this.emoji;
    }

    public final String component6() {
        return this.actionCondition;
    }

    public final String component7() {
        return this.actionExecuteInstruction;
    }

    public final String component8() {
        return this.actionContext;
    }

    public final List<String> component9() {
        return this.sourcePackages;
    }

    public final ProactiveRecommendationDto copy(String r36, String r37, String r38, String r39, String r40, String r41, String r42, String r43, List<String> r44, long r45, double r47, String r49, String r50, int r51, String r52, String r53, Long r54, String r55, String r56, String r57, String r58, String r59, Integer r60, long r61, long r63, Long r65, List<j> r66) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r44, List.class, "com.obric.memorydata.plugin");
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r66, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r36, "recommendId");
        Intrinsics.checkNotNullParameter(r37, "taskId");
        Intrinsics.checkNotNullParameter(r38, "subscriptionId");
        Intrinsics.checkNotNullParameter(r39, "recommendText");
        Intrinsics.checkNotNullParameter(r40, "emoji");
        Intrinsics.checkNotNullParameter(r0, "sourcePackages");
        Intrinsics.checkNotNullParameter(r49, InfoRequestQPSOptTraceLogger.REASON);
        Intrinsics.checkNotNullParameter(r52, "status");
        Intrinsics.checkNotNullParameter(r53, "type");
        Intrinsics.checkNotNullParameter(r55, "inspirationId");
        Intrinsics.checkNotNullParameter(r1, "artifacts");
        return new ProactiveRecommendationDto(r36, r37, r38, r39, r40, r41, r42, r43, r0, r45, r47, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r63, r65, r1);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, ProactiveRecommendationDto.class) == true) goto L8;
        return false;
    L8:
        ProactiveRecommendationDto r10 = (ProactiveRecommendationDto) ZeusTransformUtils.preCheckCast(r9, ProactiveRecommendationDto.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.recommendId, r10.recommendId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.taskId, r10.taskId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.subscriptionId, r10.subscriptionId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.recommendText, r10.recommendText) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.emoji, r10.emoji) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.actionCondition, r10.actionCondition) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.actionExecuteInstruction, r10.actionExecuteInstruction) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.actionContext, r10.actionContext) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.sourcePackages, r10.sourcePackages) == true) goto L36;
        return false;
    L36:
        if (this.created == r10.created) goto L39;
        return false;
    L39:
        if (Double.compare(this.score, r10.score) == 0) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.reason, r10.reason) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.evidence, r10.evidence) == true) goto L48;
        return false;
    L48:
        if (this.recommendStatus == r10.recommendStatus) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.status, r10.status) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.type, r10.type) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.expireAtMs, r10.expireAtMs) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.inspirationId, r10.inspirationId) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.inspirationFeedbackAction, r10.inspirationFeedbackAction) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.inspirationUserFeedback, r10.inspirationUserFeedback) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.inspirationFeedbackReason, r10.inspirationFeedbackReason) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.inspirationFeedbackText, r10.inspirationFeedbackText) == true) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.inspirationFeedbackValue, r10.inspirationFeedbackValue) == true) goto L78;
        return false;
    L78:
        if (this.inspirationUpdated == r10.inspirationUpdated) goto L81;
        return false;
    L81:
        if (this.inspirationTimestamp == r10.inspirationTimestamp) goto L84;
        return false;
    L84:
        if (Intrinsics.areEqual(this.traceId, r10.traceId) == true) goto L87;
        return false;
    L87:
        if (Intrinsics.areEqual(this.artifacts, r10.artifacts) == true) goto L89;
        return false;
    L89:
        return true;
    }

    public final String getActionCondition() {
        return this.actionCondition;
    }

    public final String getActionContext() {
        return this.actionContext;
    }

    public final String getActionExecuteInstruction() {
        return this.actionExecuteInstruction;
    }

    public final List<j> getArtifacts() {
        return this.artifacts;
    }

    public final long getCreated() {
        return this.created;
    }

    public final String getEmoji() {
        return this.emoji;
    }

    public final String getEvidence() {
        return this.evidence;
    }

    public final Long getExpireAtMs() {
        return this.expireAtMs;
    }

    public final String getInspirationFeedbackAction() {
        return this.inspirationFeedbackAction;
    }

    public final String getInspirationFeedbackReason() {
        return this.inspirationFeedbackReason;
    }

    public final String getInspirationFeedbackText() {
        return this.inspirationFeedbackText;
    }

    public final Integer getInspirationFeedbackValue() {
        return this.inspirationFeedbackValue;
    }

    public final String getInspirationId() {
        return this.inspirationId;
    }

    public final long getInspirationTimestamp() {
        return this.inspirationTimestamp;
    }

    public final long getInspirationUpdated() {
        return this.inspirationUpdated;
    }

    public final String getInspirationUserFeedback() {
        return this.inspirationUserFeedback;
    }

    public final String getReason() {
        return this.reason;
    }

    public final String getRecommendId() {
        return this.recommendId;
    }

    public final int getRecommendStatus() {
        return this.recommendStatus;
    }

    public final String getRecommendText() {
        return this.recommendText;
    }

    public final double getScore() {
        return this.score;
    }

    public final List<String> getSourcePackages() {
        return this.sourcePackages;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getSubscriptionId() {
        return this.subscriptionId;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final Long getTraceId() {
        return this.traceId;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        int r0 = ((((((((this.recommendId.hashCode() * 31) + this.taskId.hashCode()) * 31) + this.subscriptionId.hashCode()) * 31) + this.recommendText.hashCode()) * 31) + this.emoji.hashCode()) * 31;
        String r1 = this.actionCondition;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.actionExecuteInstruction;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.actionContext;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (((((((((r7 + r9) * 31) + this.sourcePackages.hashCode()) * 31) + Long.hashCode(this.created)) * 31) + Double.hashCode(this.score)) * 31) + this.reason.hashCode()) * 31;
        String r11 = this.evidence;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (((((((r10 + r12) * 31) + Integer.hashCode(this.recommendStatus)) * 31) + this.status.hashCode()) * 31) + this.type.hashCode()) * 31;
        Long r14 = this.expireAtMs;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (((r13 + r15) * 31) + this.inspirationId.hashCode()) * 31;
        String r17 = this.inspirationFeedbackAction;
        if (r17 != null) goto L25;
        int r18 = 0;
    L26:
        int r19 = (r16 + r18) * 31;
        String r20 = this.inspirationUserFeedback;
        if (r20 != null) goto L29;
        int r21 = 0;
    L30:
        int r22 = (r19 + r21) * 31;
        String r23 = this.inspirationFeedbackReason;
        if (r23 != null) goto L33;
        int r24 = 0;
    L34:
        int r25 = (r22 + r24) * 31;
        String r26 = this.inspirationFeedbackText;
        if (r26 != null) goto L37;
        int r27 = 0;
    L38:
        int r28 = (r25 + r27) * 31;
        Integer r29 = this.inspirationFeedbackValue;
        if (r29 != null) goto L41;
        int r30 = 0;
    L42:
        int r31 = (((((r28 + r30) * 31) + Long.hashCode(this.inspirationUpdated)) * 31) + Long.hashCode(this.inspirationTimestamp)) * 31;
        Long r32 = this.traceId;
        if (r32 == null) goto L47;
        r2 = r32.hashCode();
    L47:
        return ((r31 + r2) * 31) + this.artifacts.hashCode();
    L41:
        r30 = r29.hashCode();
        goto L42
    L37:
        r27 = r26.hashCode();
        goto L38
    L33:
        r24 = r23.hashCode();
        goto L34
    L29:
        r21 = r20.hashCode();
        goto L30
    L25:
        r18 = r17.hashCode();
        goto L26
    L21:
        r15 = r14.hashCode();
        goto L22
    L17:
        r12 = r11.hashCode();
        goto L18
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("ProactiveRecommendationDto(recommendId=").append(this.recommendId).append(", taskId=").append(this.taskId).append(", subscriptionId=").append(this.subscriptionId).append(", recommendText=").append(this.recommendText).append(", emoji=").append(this.emoji).append(", actionCondition=").append(this.actionCondition).append(", actionExecuteInstruction=").append(this.actionExecuteInstruction).append(", actionContext=").append(this.actionContext).append(", sourcePackages=").append(this.sourcePackages).append(", created=").append(this.created).append(", score=").append(this.score).append(", reason=");
        r0.append(this.reason).append(", evidence=").append(this.evidence).append(", recommendStatus=").append(this.recommendStatus).append(", status=").append(this.status).append(", type=").append(this.type).append(", expireAtMs=").append(this.expireAtMs).append(", inspirationId=").append(this.inspirationId).append(", inspirationFeedbackAction=").append(this.inspirationFeedbackAction).append(", inspirationUserFeedback=").append(this.inspirationUserFeedback).append(", inspirationFeedbackReason=").append(this.inspirationFeedbackReason).append(", inspirationFeedbackText=").append(this.inspirationFeedbackText).append(", inspirationFeedbackValue=").append(this.inspirationFeedbackValue);
        r0.append(", inspirationUpdated=").append(this.inspirationUpdated).append(", inspirationTimestamp=").append(this.inspirationTimestamp).append(", traceId=").append(this.traceId).append(", artifacts=").append(this.artifacts).append(')');
        return r0.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parcel");
        a r6 = CREATOR;
        Long r0 = a.b(r6);
        if (r0 == null) goto L5;
        boolean r1 = r6.a(((Number) ZeusTransformUtils.preCheckCast(r0, Number.class, "com.obric.memorydata.plugin")).longValue());
    L6:
        r4.writeString(this.recommendId);
        r4.writeString(this.taskId);
        r4.writeString(this.subscriptionId);
        r4.writeString(this.recommendText);
        r4.writeString(this.emoji);
        r4.writeString(this.actionCondition);
        r4.writeString(this.actionExecuteInstruction);
        r4.writeString(this.actionContext);
        r4.writeStringList(r6.a(this.sourcePackages));
        r4.writeLong(this.created);
        r4.writeDouble(this.score);
        r4.writeString(this.reason);
        r4.writeString(this.evidence);
        r4.writeInt(this.recommendStatus);
        r4.writeString(this.status);
        r4.writeString(this.type);
        if (r1 == false) goto L9;
        a.a(r6, r4, this.expireAtMs);
    L9:
        r4.writeString(this.inspirationId);
        r4.writeString(this.inspirationFeedbackAction);
        r4.writeString(this.inspirationUserFeedback);
        r4.writeLong(this.inspirationUpdated);
        r4.writeLong(this.inspirationTimestamp);
        return;
    L5:
        r1 = false;
        goto L6
    }
}
