package com.obric.memorydata.memory.provider;

import android.os.Bundle;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import com.bytedance.apm6.consumer.slardar.Constants;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.bytedance.news.common.service.manager.IService;
import com.bytedance.news.common.service.manager.ext.ServiceManagerExtKt;
import com.obric.aiproactive.api.IProactiveService;
import com.obric.aiproactive.api.ProactiveAllPageSnapshot;
import com.obric.aiproactive.api.ProactiveDayHeaderDto;
import com.obric.aiproactive.api.ProactiveDayPageResult;
import com.obric.aiproactive.api.ProactiveInspirationDto;
import com.obric.aiproactive.api.ProactiveRecommendationDto;
import com.obric.aiproactive.api.o;
import com.obric.aiproactive.api.r;
import com.obric.aiproactive.api.s;
import com.obric.aiproactive.api.u;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\bÀ\u0002\u0018\u00002\u00020\u0001:\u0002@AB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0005J\"\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u0005J\n\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002J\u001a\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001a2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0005H\u0002J\u001a\u0010\u001f\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001a2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0005H\u0002J\u0014\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010\u0005H\u0002J\u0014\u0010#\u001a\u0004\u0018\u00010$2\b\u0010\"\u001a\u0004\u0018\u00010\u0005H\u0002J\u000e\u0010%\u001a\u0004\u0018\u00010&*\u00020!H\u0002J\u000e\u0010'\u001a\u0004\u0018\u00010(*\u00020!H\u0002J\u0014\u0010)\u001a\u0004\u0018\u00010*2\b\u0010\"\u001a\u0004\u0018\u00010\u0005H\u0002J\u0013\u0010+\u001a\u0004\u0018\u00010,*\u00020\u001cH\u0002¢\u0006\u0002\u0010-J\u0012\u0010.\u001a\u0004\u0018\u00010\u00052\u0006\u0010/\u001a\u000200H\u0002J\u0010\u00101\u001a\u0004\u0018\u00010\u0005*\u0004\u0018\u00010\u0005H\u0002J\f\u00102\u001a\u00020\u001c*\u000203H\u0002J\f\u00102\u001a\u00020\u001c*\u000204H\u0002J\f\u00102\u001a\u00020\u001c*\u000205H\u0002J\f\u00102\u001a\u00020\u001c*\u000206H\u0002J\f\u00102\u001a\u00020\u001c*\u000207H\u0002J\u000e\u00108\u001a\u0004\u0018\u00010\u0005*\u000207H\u0002J\u0010\u00109\u001a\u0004\u0018\u00010\u0005*\u0004\u0018\u00010\u0005H\u0002J\u0016\u0010:\u001a\u0004\u0018\u00010\u0005*\u00020\u001c2\u0006\u0010;\u001a\u00020\u0005H\u0002J\u0018\u0010<\u001a\u00020\u001c2\u0006\u0010=\u001a\u00020\u00132\u0006\u0010>\u001a\u00020\u0005H\u0002J\u0010\u0010?\u001a\u00020\u00052\u0006\u0010>\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006B"}, d2 = {"Lcom/obric/memorydata/memory/provider/AiProactiveLabelingProviderBridge;", "", "<init>", "()V", "TAG", "", "METHOD_GET_LABELING_FEEDBACK_CONFIG", "METHOD_LOAD_ALL_RECOMMENDATIONS_SNAPSHOT", "METHOD_LOAD_RECOMMENDATIONS_SNAPSHOT", "METHOD_LOAD_DAY_RECOMMENDATIONS_PAGE", "METHOD_LOAD_RECOMMENDATIONS_PAGE", "METHOD_SUBMIT_ANNOTATION", "METHOD_SUBMIT_DIRECT_FEEDBACK", "KEY_REQUEST_JSON", "KEY_FEEDBACK_JSON", "KEY_RESULT_JSON", "KEY_FEEDBACK_VALUE", "WINDOW_PAGE_KEY", "supports", "", "method", NotificationCompat.CATEGORY_CALL, "Landroid/os/Bundle;", "extras", "arg", "proactiveServiceOrNull", "Lcom/obric/aiproactive/api/IProactiveService;", "submitAnnotation", "Lorg/json/JSONObject;", "service", "requestJson", "submitDirectFeedback", "parseHostAnnotationRequest", "Lcom/obric/memorydata/memory/provider/AiProactiveLabelingProviderBridge$HostAnnotationRequest;", "raw", "parseHostDirectFeedbackRequest", "Lcom/obric/aiproactive/api/AiProactiveDirectFeedbackRequest;", "toProactiveInspirationDto", "Lcom/obric/aiproactive/api/ProactiveInspirationDto;", "toAiProactiveRecommendationFeedbackRequest", "Lcom/obric/aiproactive/api/AiProactiveRecommendationFeedbackRequest;", "parseHostFeedbackPayload", "Lcom/obric/memorydata/memory/provider/AiProactiveLabelingProviderBridge$HostFeedbackPayload;", "optFeedbackValue", "", "(Lorg/json/JSONObject;)Ljava/lang/Integer;", "toJsonArrayStringOrNull", "array", "Lorg/json/JSONArray;", "toAiProactiveFeedbackType", "toJson", "Lcom/obric/aiproactive/api/AiProactiveLabelingFeedbackConfigDto;", "Lcom/obric/aiproactive/api/ProactiveAllPageSnapshot;", "Lcom/obric/aiproactive/api/ProactiveDayPageResult;", "Lcom/obric/aiproactive/api/ProactiveDayHeaderDto;", "Lcom/obric/aiproactive/api/ProactiveRecommendationDto;", "toHostFeedbackPayload", "toHostVoteRaw", "optNullableString", ActivityLifecycle.NAME, "submitResult", "accepted", "message", "errorJson", "HostAnnotationRequest", "HostFeedbackPayload", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f10354a = null;

    /* JADX INFO: renamed from: com.obric.memorydata.memory.provider.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u000bHÆ\u0003JQ\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u0007HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006%"}, d2 = {"Lcom/obric/memorydata/memory/provider/AiProactiveLabelingProviderBridge$HostAnnotationRequest;", "", "inspirationId", "", "taskId", "recommendId", "recommendStatus", "", "feedbackAction", "userFeedback", "created", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;J)V", "getInspirationId", "()Ljava/lang/String;", "getTaskId", "getRecommendId", "getRecommendStatus", "()I", "getFeedbackAction", "getUserFeedback", "getCreated", "()J", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class C0510a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f10355a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f10356b;
        private final String c;
        private final int d;
        private final String e;
        private final String f;
        private final long g;

        public C0510a(String r2, String r3, String r4, int r5, String r6, String r7, long r8) {
            Intrinsics.checkNotNullParameter(r2, "inspirationId");
            Intrinsics.checkNotNullParameter(r3, "taskId");
            Intrinsics.checkNotNullParameter(r4, "recommendId");
            Intrinsics.checkNotNullParameter(r6, "feedbackAction");
            this.f10355a = r2;
            this.f10356b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
            this.g = r8;
        }

        public final String a() {
            return this.f10355a;
        }

        public final String b() {
            return this.f10356b;
        }

        public final String c() {
            return this.c;
        }

        public final int d() {
            return this.d;
        }

        public final String e() {
            return this.e;
        }

        public boolean equals(Object r7) {
            if (this != r7) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r7, C0510a.class) == true) goto L8;
            return false;
        L8:
            C0510a r8 = (C0510a) ZeusTransformUtils.preCheckCast(r7, C0510a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f10355a, r8.f10355a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f10356b, r8.f10356b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r8.c) == true) goto L18;
            return false;
        L18:
            if (this.d == r8.d) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r8.e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r8.f) == true) goto L27;
            return false;
        L27:
            if (this.g == r8.g) goto L29;
            return false;
        L29:
            return true;
        }

        public final String f() {
            return this.f;
        }

        public final long g() {
            return this.g;
        }

        public int hashCode() {
            int r0 = ((((((((this.f10355a.hashCode() * 31) + this.f10356b.hashCode()) * 31) + this.c.hashCode()) * 31) + Integer.hashCode(this.d)) * 31) + this.e.hashCode()) * 31;
            String r1 = this.f;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return ((r0 + r2) * 31) + Long.hashCode(this.g);
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public String toString() {
            return "HostAnnotationRequest(inspirationId=" + this.f10355a + ", taskId=" + this.f10356b + ", recommendId=" + this.c + ", recommendStatus=" + this.d + ", feedbackAction=" + this.e + ", userFeedback=" + this.f + ", created=" + this.g + ')';
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001B;\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0011JJ\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\bHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001f"}, d2 = {"Lcom/obric/memorydata/memory/provider/AiProactiveLabelingProviderBridge$HostFeedbackPayload;", "", "vote", "", InfoRequestQPSOptTraceLogger.REASON, "comment", AILabCheckPermissionTask.KEY_SOURCE, EventBody.KEY_VALUE, "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getVote", "()Ljava/lang/String;", "getReason", "getComment", "getSource", "getValue", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/obric/memorydata/memory/provider/AiProactiveLabelingProviderBridge$HostFeedbackPayload;", "equals", "", "other", "hashCode", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f10357a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f10358b;
        private final String c;
        private final String d;
        private final Integer e;

        public b(String r1, String r2, String r3, String r4, Integer r5) {
            this.f10357a = r1;
            this.f10358b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        public final String a() {
            return this.f10357a;
        }

        public final String b() {
            return this.f10358b;
        }

        public final String c() {
            return this.c;
        }

        public final String d() {
            return this.d;
        }

        public final Integer e() {
            return this.e;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f10357a, r6.f10357a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f10358b, r6.f10358b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public int hashCode() {
            String r0 = this.f10357a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            String r4 = this.f10358b;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            String r7 = this.c;
            if (r7 != null) goto L13;
            int r8 = 0;
        L14:
            int r9 = (r6 + r8) * 31;
            String r10 = this.d;
            if (r10 != null) goto L17;
            int r11 = 0;
        L18:
            int r12 = (r9 + r11) * 31;
            Integer r13 = this.e;
            if (r13 == null) goto L23;
            r1 = r13.hashCode();
        L23:
            return r12 + r1;
        L17:
            r11 = r10.hashCode();
            goto L18
        L13:
            r8 = r7.hashCode();
            goto L14
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public String toString() {
            return "HostFeedbackPayload(vote=" + this.f10357a + ", reason=" + this.f10358b + ", comment=" + this.c + ", source=" + this.d + ", value=" + this.e + ')';
        }
    }

    static {
        f10354a = new a();
    }

    private a() {
    }

    private final IProactiveService a() {
        IService r8 = ServiceManagerExtKt.impl(Reflection.getOrCreateKotlinClass(IProactiveService.class));
        if (((IProactiveService) ZeusTransformUtils.preCheckCast(r8, IProactiveService.class, "com.obric.memorydata.plugin")) != null) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AiProactiveLabelingProviderBridge", "ai proactive provider ignored: proactive service not ready", null, 4, null);
    L6:
        return (IProactiveService) ZeusTransformUtils.preCheckCast(r8, IProactiveService.class, "com.obric.memorydata.plugin");
    }

    private final ProactiveInspirationDto a(C0510a r12) {
        String r3 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r12.a(), CharSequence.class, "com.obric.memorydata.plugin")).toString();
        String r4 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r12.b(), CharSequence.class, "com.obric.memorydata.plugin")).toString();
        CharSequence r11 = (CharSequence) ZeusTransformUtils.preCheckCast(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r12.c(), CharSequence.class, "com.obric.memorydata.plugin")).toString(), CharSequence.class, "com.obric.memorydata.plugin");
        if (StringsKt.isBlank(r11) == false) goto L5;
        r11 = r3;
    L5:
        String r5 = (String) ZeusTransformUtils.preCheckCast(r11, String.class, "com.obric.memorydata.plugin");
        String r7 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r12.e(), CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L10;
        return null;
    L10:
        return new ProactiveInspirationDto(r3, r4, r5, r12.d(), r7, r12.f(), r12.g());
    }

    private final Integer a(JSONObject r7) {
        if (r7.has("feedbackValue") == true) goto L5;
    L27:
        return null;
    L5:
        if (r7.isNull("feedbackValue") == true) goto L27;
        Object r0 = r7.opt("feedbackValue");
        boolean r2 = true;
        if (r0 != null) goto L10;
    L19:
        String r6 = r7.optString("feedbackValue");
        Intrinsics.checkNotNullExpressionValue(r6, "optString(...)");
        String r8 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin")).length() == 0) goto L23;
        r2 = false;
    L23:
        if (r2 == false) goto L26;
        return null;
    L26:
        return StringsKt.toIntOrNull(r8);
    L10:
        if (ZeusTransformUtils.instanceOf(r0, Number.class) == false) goto L19;
        double r9 = ((Number) ZeusTransformUtils.preCheckCast(r0, Number.class, "com.obric.memorydata.plugin")).doubleValue();
        if (r9 == Math.floor(r9)) goto L15;
        r2 = false;
    L15:
        if (r2 == true) goto L18;
        return null;
    L18:
        return Integer.valueOf((int) r9);
    }

    private final String a(JSONArray r7) {
        List r6 = CollectionsKt.createListBuilder();
        int r0 = r7.length();
        int r1 = 0;
    L3:
        String r2 = null;
        if (r1 >= r0) goto L15;
        String r4 = r7.optString(r1);
        if (r4 == null) goto L14;
        String r5 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (r5 == null) goto L14;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L12;
        r2 = r5;
    L12:
        if (r2 == null) goto L14;
        r6.add(r2);
    L14:
        r1 = r1 + 1;
        goto L3
    L15:
        List r8 = CollectionsKt.build(r6);
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r8, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == true) goto L19;
        r8 = null;
    L19:
        if (r8 != null) goto L21;
        return null;
    L21:
        return new JSONArray((Collection) ZeusTransformUtils.preCheckCast(r8, Collection.class, "com.obric.memorydata.plugin")).toString();
    }

    private final String a(JSONObject r2, String r3) {
        if (r2.has(r3) == true) goto L5;
        return null;
    L5:
        if (r2.isNull(r3) == true) goto L13;
        String r1 = r2.optString(r3);
        Intrinsics.checkNotNull(r1);
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L10;
        return null;
    L10:
        return r1;
    L13:
        return null;
    }

    private final JSONObject a(IProactiveService r3, String r4) {
        IProactiveService r5 = (IProactiveService) ZeusTransformUtils.wrapperContextForParams(r3, IProactiveService.class, "com.obric.memorydata.plugin");
        C0510a r6 = b(r4);
        if (r6 == null) goto L5;
        ProactiveInspirationDto r1 = a(r6);
        if (r1 == null) goto L9;
        u r7 = b(r6);
        r5.updateInspiration(r1);
        if (r7 == null) goto L14;
        r5.updateAiProactiveRecommendationFeedback(r7);
    L14:
        return a(true, "ok");
    L9:
        return a(false, "invalid inspiration id");
    L5:
        return a(false, "invalid request");
    }

    private final JSONObject a(ProactiveAllPageSnapshot r7) {
        JSONObject r6 = new JSONObject().put("batchId", r7.getBatchId());
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(r7.getDayHeaders(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        ProactiveDayHeaderDto r4 = (ProactiveDayHeaderDto) ZeusTransformUtils.preCheckCast(r2.next(), ProactiveDayHeaderDto.class, "com.obric.memorydata.plugin");
        r1.add(f10354a.a(r4));
        goto L4
    L6:
        JSONObject r8 = r6.put("dayHeaders", new JSONArray((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin")));
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(r7.getTodayFirstPage(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r9 = r3.iterator();
    L8:
        if (r9.hasNext() == false) goto L10;
        ProactiveRecommendationDto r10 = (ProactiveRecommendationDto) ZeusTransformUtils.preCheckCast(r9.next(), ProactiveRecommendationDto.class, "com.obric.memorydata.plugin");
        r5.add(f10354a.a(r10));
        goto L8
    L10:
        JSONObject r11 = r8.put("todayFirstPage", new JSONArray((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin"))).put("todayHasNext", r7.getTodayHasNext());
        Intrinsics.checkNotNullExpressionValue(r11, "put(...)");
        return r11;
    }

    private final JSONObject a(ProactiveDayHeaderDto r4) {
        JSONObject r3 = new JSONObject().put("dayKey", r4.getDayKey()).put("dayStartMillis", r4.getDayStartMillis()).put(CommonConsts.COUNT_TYPE, r4.getCount());
        Intrinsics.checkNotNullExpressionValue(r3, "put(...)");
        return r3;
    }

    private final JSONObject a(ProactiveDayPageResult r5) {
        JSONObject r4 = new JSONObject().put("batchId", r5.getBatchId()).put("dayKey", r5.getDayKey()).put("hasNext", r5.getHasNext());
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(r5.getList(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        ProactiveRecommendationDto r2 = (ProactiveRecommendationDto) ZeusTransformUtils.preCheckCast(r7.next(), ProactiveRecommendationDto.class, "com.obric.memorydata.plugin");
        r0.add(f10354a.a(r2));
        goto L4
    L6:
        JSONObject r8 = r4.put(Constants.KEY_LIST, new JSONArray((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin")));
        Intrinsics.checkNotNullExpressionValue(r8, "put(...)");
        return r8;
    }

    private final JSONObject a(ProactiveRecommendationDto r6) {
        JSONObject r0 = new JSONObject().put("recommendId", r6.getRecommendId()).put("taskId", r6.getTaskId()).put("subscriptionId", r6.getSubscriptionId()).put("recommendText", r6.getRecommendText()).put("emoji", r6.getEmoji());
        Object r1 = r6.getActionCondition();
        if (r1 != null) goto L5;
        r1 = JSONObject.NULL;
    L5:
        JSONObject r2 = r0.put("actionCondition", r1);
        Object r3 = r6.getActionExecuteInstruction();
        if (r3 != null) goto L8;
        r3 = JSONObject.NULL;
    L8:
        JSONObject r4 = r2.put("actionExecuteInstruction", r3);
        Object r5 = r6.getActionContext();
        if (r5 != null) goto L11;
        r5 = JSONObject.NULL;
    L11:
        JSONObject r7 = r4.put("actionContext", r5).put("sourcePackages", new JSONArray((Collection) ZeusTransformUtils.preCheckCast(r6.getSourcePackages(), Collection.class, "com.obric.memorydata.plugin"))).put("created", r6.getCreated()).put("score", r6.getScore()).put(InfoRequestQPSOptTraceLogger.REASON, r6.getReason());
        Object r8 = r6.getEvidence();
        if (r8 != null) goto L14;
        r8 = JSONObject.NULL;
    L14:
        JSONObject r9 = r7.put("evidence", r8).put("recommendStatus", r6.getRecommendStatus()).put("status", r6.getStatus()).put("type", r6.getType());
        Object r10 = r6.getExpireAtMs();
        if (r10 != null) goto L17;
        r10 = JSONObject.NULL;
    L17:
        JSONObject r11 = r9.put("expireAtMs", r10).put("inspirationId", r6.getInspirationId());
        Object r12 = r6.getInspirationFeedbackAction();
        if (r12 != null) goto L20;
        r12 = JSONObject.NULL;
    L20:
        JSONObject r13 = r11.put("inspirationFeedbackAction", r12);
        Object r14 = b(r6);
        if (r14 != null) goto L23;
        r14 = JSONObject.NULL;
    L23:
        JSONObject r15 = r13.put("inspirationUserFeedback", r14).put("inspirationUpdated", r6.getInspirationUpdated()).put("inspirationTimestamp", r6.getInspirationTimestamp());
        Intrinsics.checkNotNullExpressionValue(r15, "put(...)");
        return r15;
    }

    private final JSONObject a(s r5) {
        JSONObject r4 = new JSONObject().put("positiveReasons", new JSONArray((Collection) ZeusTransformUtils.preCheckCast(r5.a(), Collection.class, "com.obric.memorydata.plugin"))).put("negativeReasons", new JSONArray((Collection) ZeusTransformUtils.preCheckCast(r5.b(), Collection.class, "com.obric.memorydata.plugin"))).put("feedbackPlaceholder", r5.c());
        Intrinsics.checkNotNullExpressionValue(r4, "put(...)");
        return r4;
    }

    private final JSONObject a(boolean r2, String r3) {
        JSONObject r1 = new JSONObject().put("accepted", r2).put("message", r3);
        Intrinsics.checkNotNullExpressionValue(r1, "put(...)");
        return r1;
    }

    private final u b(C0510a r15) {
        Long r0 = StringsKt.toLongOrNull(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r15.c(), CharSequence.class, "com.obric.memorydata.plugin")).toString());
        Integer r1 = null;
        if (r0 == null) goto L31;
        long r4 = r0.longValue();
        b r2 = d(r15.f());
        if (r2 == null) goto L7;
        String r3 = r2.a();
    L8:
        String r14 = e(r3);
        if (r14 != null) goto L14;
        r14 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r15.e(), CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L14;
        String r6 = null;
    L15:
        if (r2 == null) goto L17;
        String r7 = r2.b();
    L18:
        if (r2 == null) goto L20;
        String r8 = r2.c();
    L22:
        if (r2 == null) goto L25;
        String r16 = r2.d();
        if (r16 == null) goto L25;
    L26:
        String r10 = r16;
        if (r2 == null) goto L30;
        r1 = r2.e();
    L30:
        return new u(r4, r6, r7, r8, null, r10, r1, 16, null);
    L25:
        r16 = "label_app";
        goto L26
    L20:
        r8 = null;
        goto L22
    L17:
        r7 = null;
    L14:
        r6 = r14;
        goto L15
    L7:
        r3 = null;
        goto L8
    L31:
        return null;
    }

    private final C0510a b(String r14) {
        Object r1 = null;
        if (r14 == null) goto L22;
        String r15 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (r15 == null) goto L22;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L10;
        r15 = null;
    L10:
        if (r15 == null) goto L22;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L14
        a r13 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        JSONObject r3 = new JSONObject(r15);     // Catch: Throwable -> L14
        String r5 = r3.optString("inspirationId");     // Catch: Throwable -> L14
        Intrinsics.checkNotNullExpressionValue(r5, "optString(...)");     // Catch: Throwable -> L14
        String r6 = r3.optString("taskId");     // Catch: Throwable -> L14
        Intrinsics.checkNotNullExpressionValue(r6, "optString(...)");     // Catch: Throwable -> L14
        String r7 = r3.optString("recommendId");     // Catch: Throwable -> L14
        Intrinsics.checkNotNullExpressionValue(r7, "optString(...)");     // Catch: Throwable -> L14
        int r8 = r3.optInt("recommendStatus");     // Catch: Throwable -> L14
        String r9 = r3.optString("feedbackAction");     // Catch: Throwable -> L14
        Intrinsics.checkNotNullExpressionValue(r9, "optString(...)");     // Catch: Throwable -> L14
        Object r16 = Result.m1421constructorimpl(new C0510a(r5, r6, r7, r8, r9, r13.a(r3, "userFeedback"), r3.optLong("created")));     // Catch: Throwable -> L14
    L17:
        if (Result.m1427isFailureimpl(r16) == true) goto L21;
        r1 = r16;
    L21:
        return (C0510a) ZeusTransformUtils.preCheckCast(r1, C0510a.class, "com.obric.memorydata.plugin");
    L14:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r16 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L22:
        return null;
    }

    private final String b(ProactiveRecommendationDto r6) {
        String r5 = f(r6.getInspirationFeedbackAction());
        JSONArray r0 = new JSONArray();
        String r1 = r6.getInspirationFeedbackReason();
        if (r1 != null) goto L5;
    L10:
        String r2 = r6.getInspirationFeedbackText();
        if (r2 != null) goto L13;
        r2 = "";
    L13:
        Object r7 = r.f6271a.a(r6.getInspirationFeedbackValue());
        if (r5 == null) goto L16;
    L21:
        JSONObject r8 = new JSONObject().put("vote", r5).put("reasons", r0).put("comment", r2);
        if (r7 != null) goto L25;
        r7 = JSONObject.NULL;
    L25:
        return r8.put("feedbackValue", r7).toString();
    L16:
        if (r0.length() != 0) goto L21;
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L21;
        if (r7 != null) goto L21;
        return null;
    L5:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L8;
        r1 = null;
    L8:
        if (r1 == null) goto L10;
        r0.put(r1);
        goto L10
    }

    private final JSONObject b(IProactiveService r3, String r4) {
        IProactiveService r5 = (IProactiveService) ZeusTransformUtils.wrapperContextForParams(r3, IProactiveService.class, "com.obric.memorydata.plugin");
        o r6 = c(r4);
        if (r6 != null) goto L7;
        boolean r7 = false;
        String r8 = "invalid request";
    L6:
        return a(r7, r8);
    L7:
        r5.submitAiProactiveDirectFeedback(r6);
        r7 = true;
        r8 = "ok";
        goto L6
    }

    private final o c(String r10) {
        Object r0 = null;
        if (r10 == null) goto L28;
        String r11 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (r11 == null) goto L28;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L10;
        r11 = null;
    L10:
        if (r11 == null) goto L28;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L20
        a r9 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
        JSONObject r2 = new JSONObject(r11);     // Catch: Throwable -> L20
        String r3 = r9.a(r2, "feedbackType");     // Catch: Throwable -> L20
        if (r3 != null) goto L15;
        r3 = "OVERALL";
    L15:
        String r4 = r3;
        String r5 = r9.a(r2, "feedbackReason");     // Catch: Throwable -> L20
        String r6 = r9.a(r2, "feedbackText");     // Catch: Throwable -> L20
        String r7 = r9.a(r2, "relatedInfo");     // Catch: Throwable -> L20
        String r12 = r9.a(r2, "feedbackSource");     // Catch: Throwable -> L20
        if (r12 != null) goto L18;
        r12 = "label_app";
    L18:
        Object r13 = Result.m1421constructorimpl(new o(r4, r5, r6, r7, r12));     // Catch: Throwable -> L20
    L23:
        if (Result.m1427isFailureimpl(r13) == true) goto L27;
        r0 = r13;
    L27:
        return (o) ZeusTransformUtils.preCheckCast(r0, o.class, "com.obric.memorydata.plugin");
    L20:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r13 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L28:
        return null;
    }

    private final b d(String r12) {
        Object r0 = null;
        if (r12 == null) goto L48;
        String r13 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (r13 == null) goto L48;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L10;
        r13 = null;
    L10:
        if (r13 == null) goto L48;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L40
        a r11 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L40
        JSONObject r2 = new JSONObject(r13);     // Catch: Throwable -> L40
        JSONArray r14 = r2.optJSONArray("reasons");     // Catch: Throwable -> L40
        String r3 = r2.optString("vote");     // Catch: Throwable -> L40
        Intrinsics.checkNotNull(r3);     // Catch: Throwable -> L40
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L15;
        String r6 = r3;
    L16:
        if (r14 == null) goto L20;
        String r15 = r11.a(r14);     // Catch: Throwable -> L40
        if (r15 == null) goto L20;
    L19:
        String r7 = r15;
    L24:
        String r16 = r2.optString("comment");     // Catch: Throwable -> L40
        Intrinsics.checkNotNull(r16);     // Catch: Throwable -> L40
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r16, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L27;
        String r8 = r16;
    L28:
        String r17 = r2.optString(AILabCheckPermissionTask.KEY_SOURCE);     // Catch: Throwable -> L40
        Intrinsics.checkNotNull(r17);     // Catch: Throwable -> L40
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r17, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L32;
        r17 = null;
    L32:
        if (r17 != null) goto L37;
        r17 = r2.optString("sourceType");     // Catch: Throwable -> L40
        Intrinsics.checkNotNull(r17);     // Catch: Throwable -> L40
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r17, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L37;
        String r9 = null;
    L38:
        Object r18 = Result.m1421constructorimpl(new b(r6, r7, r8, r9, r11.a(r2)));     // Catch: Throwable -> L40
    L43:
        if (Result.m1427isFailureimpl(r18) == true) goto L47;
        r0 = r18;
    L47:
        return (b) ZeusTransformUtils.preCheckCast(r0, b.class, "com.obric.memorydata.plugin");
    L37:
        r9 = r17;
        goto L38
    L27:
        r8 = null;
    L20:
        r15 = r2.optString(InfoRequestQPSOptTraceLogger.REASON);     // Catch: Throwable -> L40
        Intrinsics.checkNotNull(r15);     // Catch: Throwable -> L40
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L19;
        r7 = null;
        goto L24
    L15:
        r6 = null;
    L40:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r18 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L48:
        return null;
    }

    private final String e(String r3) {
        if (r3 == null) goto L7;
        String r4 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (r4 == null) goto L7;
        String r5 = r4.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(r5, "toLowerCase(...)");
    L9:
        if (Intrinsics.areEqual(r5, "up") == false) goto L12;
        return "LIKE";
    L12:
        if (Intrinsics.areEqual(r5, "down") == false) goto L16;
        return "DISLIKE";
    L16:
        return null;
    L7:
        r5 = null;
        goto L9
    }

    private final String f(String r3) {
        if (r3 == null) goto L7;
        String r4 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (r4 == null) goto L7;
        String r5 = r4.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(r5, "toUpperCase(...)");
    L8:
        if (r5 == null) goto L33;
        int r0 = r5.hashCode();
        if (r0 == (-1905342203)) goto L29;
        if (r0 == 2715) goto L25;
        if (r0 == 2104482) goto L22;
        if (r0 == 2336663) goto L19;
        return null;
    L19:
        if (r5.equals("LIKE") == false) goto L36;
    L27:
        return "up";
    L36:
        return null;
    L22:
        if (r5.equals("DOWN") == false) goto L37;
    L31:
        return "down";
    L37:
        return null;
    L25:
        if (r5.equals("UP") == true) goto L27;
        return null;
    L29:
        if (r5.equals("DISLIKE") == true) goto L31;
        return null;
    L33:
        return null;
    L7:
        r5 = null;
        goto L8
    }

    private final String g(String r5) {
        String r4 = new JSONObject().put("accepted", false).put("message", r5).put("batchId", 0).put("dayHeaders", new JSONArray()).put("todayFirstPage", new JSONArray()).put("todayHasNext", false).put("dayKey", "window").put("hasNext", false).put(Constants.KEY_LIST, new JSONArray()).put("positiveReasons", new JSONArray()).put("negativeReasons", new JSONArray()).put("feedbackPlaceholder", "").toString();
        Intrinsics.checkNotNullExpressionValue(r4, "toString(...)");
        return r4;
    }

    public final boolean a(String r8) {
        Intrinsics.checkNotNullParameter(r8, "method");
        return SetsKt.setOf(new String[]{"getAiProactiveLabelingFeedbackConfig", "loadAiProactiveAllRecommendationsSnapshot", "loadAiProactiveRecommendationsSnapshot", "loadAiProactiveDayRecommendationsPage", "loadAiProactiveRecommendationsPage", "submitAiProactiveAnnotation", "submitAiProactiveDirectFeedback"}).contains(r8);
    }

    public final Bundle call(String r18, Bundle r19, String r20) {
        Intrinsics.checkNotNullParameter(r18, "method");
        if (r19 == null) goto L8;
        String r4 = r19.getString("requestJson");
        if (r4 == null) goto L8;
        String r0 = r4;
    L77:
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L66
        a r6 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L66
        IProactiveService r7 = r6.a();     // Catch: Throwable -> L66
        if (r7 != null) goto L18;
        String r1 = r6.g("ai proactive service not ready");     // Catch: Throwable -> L66
    L64:
        Object r2 = Result.m1421constructorimpl(r1);     // Catch: Throwable -> L66
    L68:
        Throwable r3 = Result.m1424exceptionOrNullimpl(r2);
        if (r3 == null) goto L75;
        RunLog.INSTANCE.warn("AiProactiveLabelingProviderBridge", "call failed method=" + r18, r3);
        a r8 = f10354a;
        String r9 = r3.getMessage();
        if (r9 != null) goto L74;
        r9 = "ai proactive provider call failed";
    L74:
        r2 = r8.g(r9);
    L75:
        String r10 = (String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.memorydata.plugin");
        Bundle r11 = new Bundle();
        r11.putString("resultJson", r10);
        return r11;
    L18:
        switch(r18.hashCode()) {
            case -1626122998: goto L59;
            case -1501316862: goto L55;
            case -763508380: goto L48;
            case 1071303193: goto L41;
            case 1117543586: goto L37;
            case 1605541601: goto L33;
            case 1982762642: goto L21;
            default: goto L62;
        };
    L62:
        r1 = r6.g("unsupported method=" + r18);     // Catch: Throwable -> L66
    L63:
        Intrinsics.checkNotNull(r1);     // Catch: Throwable -> L66
        goto L64
    L21:
        if (r18.equals("loadAiProactiveDayRecommendationsPage") == false) goto L62;
        if (r0 != null) goto L26;
        r0 = "";
    L26:
        JSONObject r12 = new JSONObject(r0);     // Catch: Throwable -> L66
        long r13 = r12.optLong("batchId");     // Catch: Throwable -> L66
        String r14 = r12.optString("dayKey");     // Catch: Throwable -> L66
        Intrinsics.checkNotNull(r14);     // Catch: Throwable -> L66
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L30;
        r14 = null;
    L30:
        JSONObject r15 = r6.a(r7.loadDayRecommendationsPage(r13, r14, r12.optInt(TypedValues.CycleType.S_WAVE_OFFSET), r12.optInt("limit")));     // Catch: Throwable -> L66
    L31:
        r1 = r15.toString();     // Catch: Throwable -> L66
        goto L63
    L33:
        if (r18.equals("submitAiProactiveDirectFeedback") == false) goto L62;
        r15 = r6.b(r7, r0);     // Catch: Throwable -> L66
        goto L31
    L37:
        if (r18.equals("loadAiProactiveAllRecommendationsSnapshot") == false) goto L62;
        r15 = r6.a(r7.loadAllRecommendationsSnapshot());     // Catch: Throwable -> L66
        goto L31
    L41:
        if (r18.equals("loadAiProactiveRecommendationsSnapshot") == false) goto L62;
        if (r0 != null) goto L46;
        r0 = "";
    L46:
        JSONObject r16 = new JSONObject(r0);     // Catch: Throwable -> L66
        r15 = r6.a(r7.loadRecommendationsSnapshot(r16.optLong("earliestTimeMillis"), r16.optLong("latestTimeMillis")));     // Catch: Throwable -> L66
        goto L31
    L48:
        if (r18.equals("loadAiProactiveRecommendationsPage") == false) goto L62;
        if (r0 != null) goto L53;
        r0 = "";
    L53:
        JSONObject r17 = new JSONObject(r0);     // Catch: Throwable -> L66
        r15 = r6.a(r7.loadRecommendationsPage(r17.optLong("batchId"), r17.optLong("earliestTimeMillis"), r17.optLong("latestTimeMillis"), r17.optInt(TypedValues.CycleType.S_WAVE_OFFSET), r17.optInt("limit")));     // Catch: Throwable -> L66
        goto L31
    L55:
        if (r18.equals("submitAiProactiveAnnotation") == false) goto L62;
        r15 = r6.a(r7, r0);     // Catch: Throwable -> L66
        goto L31
    L59:
        if (r18.equals("getAiProactiveLabelingFeedbackConfig") == false) goto L62;
        r15 = r6.a(r7.getAiProactiveLabelingFeedbackConfig());     // Catch: Throwable -> L66
    L66:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r2 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L8:
        if (r19 == null) goto L10;
        r0 = r19.getString("feedbackJson");
    L11:
        if (r0 != null) goto L77;
        r0 = r20;
        goto L77
    L10:
        r0 = null;
        goto L11
    }
}
