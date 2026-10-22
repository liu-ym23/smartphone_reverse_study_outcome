package com.obric.memorydata.middleware.impl.playground;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Base64;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.crash.entity.EventBody;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.capabilitykit.common.Ext;
import com.obric.capabilitykit.common.execution.IntentExecutionRecord;
import com.obric.capabilitykit.common.execution.JobResult;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import okhttp3.HttpUrl;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0000\u0018\u0000 V2\u00020\u0001:\u0004STUVB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u000b\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\tJ$\u0010\u0013\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J(\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u0014\u001a\u0004\u0018\u00010\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002J\u0010\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u0019H\u0002J6\u0010\u001c\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\b2\f\u0010\u0015\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0010\u0010 \u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010!J8\u0010\"\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00032\f\u0010\u0015\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0010\u0010 \u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010!J+\u0010#\u001a\u0004\u0018\u0001H$\"\u0004\b\u0000\u0010$2\u0006\u0010\u0012\u001a\u00020\t2\f\u0010%\u001a\b\u0012\u0004\u0012\u0002H$0&H\u0002¢\u0006\u0002\u0010'J\u001c\u0010(\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\t2\n\u0010)\u001a\u00060*j\u0002`+H\u0002J \u0010,\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\b2\u0006\u0010-\u001a\u00020.2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J;\u0010/\u001a\u00020.2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u001d2\u0010\u00100\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010!H\u0000¢\u0006\u0002\b1J>\u00102\u001a\u00020.2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u00103\u001a\u00020\b2\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u001d2\u0010\u00100\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010!H\u0002J\u001a\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u001c\u00107\u001a\u0002052\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u001d2\u0006\u0010\f\u001a\u00020\bH\u0002J\u0014\u00108\u001a\u0004\u0018\u0001052\b\u00106\u001a\u0004\u0018\u00010\u0003H\u0002J\u001a\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010\u00032\u0006\u0010\f\u001a\u00020\bH\u0002J\u001a\u0010<\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010\u00032\u0006\u0010\f\u001a\u00020\bH\u0002J\u0019\u0010=\u001a\u0004\u0018\u00010\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0002\u0010>J\f\u0010?\u001a\u00020\u001f*\u000205H\u0002J\u001a\u0010@\u001a\u0004\u0018\u00010A2\u0006\u00100\u001a\u0002052\u0006\u0010B\u001a\u000205H\u0002J\u0010\u0010C\u001a\u0004\u0018\u00010\u0003*\u0004\u0018\u00010\u0001H\u0002J\u000e\u0010D\u001a\u000205*\u0004\u0018\u00010\u0001H\u0002J\u0010\u0010E\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u0001H\u0002J\u0014\u0010F\u001a\u0004\u0018\u00010\u00012\b\u0010G\u001a\u0004\u0018\u00010\u0001H\u0002J\u0014\u0010H\u001a\u000205*\u0002052\u0006\u0010I\u001a\u00020\u0003H\u0002J$\u0010J\u001a\u0004\u0018\u00010\u00032\u0006\u00100\u001a\u0002052\u0006\u0010B\u001a\u0002052\b\u0010K\u001a\u0004\u0018\u00010\u0001H\u0002J \u0010L\u001a\u00020\u001f2\u0006\u00100\u001a\u0002052\u0006\u0010B\u001a\u0002052\u0006\u0010M\u001a\u00020\u001fH\u0002J\f\u0010N\u001a\u00020\u001f*\u000205H\u0002J\u001b\u0010O\u001a\u0004\u0018\u00010\b*\u0002052\u0006\u0010P\u001a\u00020\u0003H\u0002¢\u0006\u0002\u0010QJ\u0016\u0010R\u001a\u0004\u0018\u000105*\u0002052\u0006\u0010P\u001a\u00020\u0003H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006W"}, d2 = {"Lcom/obric/memorydata/middleware/impl/playground/ResultPendingRegistry;", "", LocationMonitorConst.TAG, "", "<init>", "(Ljava/lang/String;)V", "pendingRequests", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/obric/memorydata/middleware/impl/playground/PendingRequest;", "questionToMessage", "register", "messageId", "questionId", "resultMode", "Lcom/obric/memorydata/middleware/impl/playground/AppIntentResultMode;", "forget", "", "pending", "onJobResultRecv", Ext.KEY_REQUEST, "result", "jobResult", "Lcom/obric/capabilitykit/common/execution/JobResult;", "parseJobFeedback", "Lcom/obric/memorydata/middleware/impl/playground/ResultPendingRegistry$JobFeedback;", "completeFromJobFeedback", "feedback", "onUpdateIntentResult", "Lcom/obric/capabilitykit/common/intent/IntentResult;", "isStatusChange", "", "ext", "", "onUpdateIntentResultWithRequest", "buildCallbackResult", ExifInterface.GPS_DIRECTION_TRUE, "build", "Lkotlin/Function0;", "(Lcom/obric/memorydata/middleware/impl/playground/PendingRequest;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "completeCallbackFailure", "error", "Ljava/lang/Exception;", "Lkotlin/Exception;", "routeIntentFinal", "final", "Lcom/obric/memorydata/middleware/impl/playground/DispatchIntentResult;", "buildMobileUseFinal", "callbackExt", "buildMobileUseFinal$middleware_impl_obricRelease", "buildAsyncFinal", "resultId", "buildJobActionResult", "Lorg/json/JSONObject;", "rawResult", "buildIntentActionResult", "extractActionResultContent", "extractResultEnvelope", "Lcom/obric/memorydata/middleware/impl/playground/ResultPendingRegistry$ResultEnvelope;", "rawJson", "extractRequestEnvelope", "extractMessageId", "(Ljava/lang/String;)Ljava/lang/Long;", "hasNonEmptyEntityData", "extractRawResult", "Lcom/obric/memorydata/middleware/impl/playground/ResultPendingRegistry$RawResult;", "intentResultExt", "toActionResultString", "toSafeJsonObject", "toSafeJsonValue", "toSafeJsonElement", EventBody.KEY_VALUE, "without", "keyToRemove", "encodeBitmapFallback", "entity", "shouldEncodeBitmapFallback", "hasBitmapEntity", "hasScreenshotField", "optLongValue", "key", "(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/Long;", "optJSONObjectOrString", "ResultEnvelope", "RawResult", "JobFeedback", "Companion", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f11828a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f11829b;
    private final ConcurrentHashMap<Long, g> c;
    private final ConcurrentHashMap<Long, Long> d;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0006\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0015X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/obric/memorydata/middleware/impl/playground/ResultPendingRegistry$Companion;", "", "<init>", "()V", "MESSAGE_ID", "", "ID", "QUESTION_ID", "CONTENT", "CODE", "MSG", "ENTITY_DATA", "EXT", "RESULT_KEY", "REPLY_FOR", "UI_TYPE", "SCREENSHOT", "SCREEN_SHOT", "RAW_RESULT_SOURCE_CALLBACK_EXT", "RAW_RESULT_SOURCE_INTENT_RESULT_EXT", "SCREENSHOT_JPEG_QUALITY", "", "CODE_SUCCESS", "CODE_JOB_ERROR", "LOG_CODE_DUPLICATE_QUESTION_ID", "CODE_FEEDBACK_JOB_MISSING", "CODE_FEEDBACK_QUESTION_ID_PARSE_MISS", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0082\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\t\u0010'\u001a\u00020\u0007HÆ\u0003J\t\u0010(\u001a\u00020\tHÆ\u0003J1\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010*\u001a\u00020\u001d2\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020\u0015HÖ\u0001J\t\u0010-\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\u001d¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010 \u001a\u00020\u001d¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001f¨\u0006."}, d2 = {"Lcom/obric/memorydata/middleware/impl/playground/ResultPendingRegistry$JobFeedback;", "", "pending", "Lcom/obric/memorydata/middleware/impl/playground/PendingRequest;", "job", "Lcom/obric/capabilitykit/common/execution/JobResult;", "actionResult", "Lorg/json/JSONObject;", "envelope", "Lcom/obric/memorydata/middleware/impl/playground/ResultPendingRegistry$ResultEnvelope;", "<init>", "(Lcom/obric/memorydata/middleware/impl/playground/PendingRequest;Lcom/obric/capabilitykit/common/execution/JobResult;Lorg/json/JSONObject;Lcom/obric/memorydata/middleware/impl/playground/ResultPendingRegistry$ResultEnvelope;)V", "getPending", "()Lcom/obric/memorydata/middleware/impl/playground/PendingRequest;", "getJob", "()Lcom/obric/capabilitykit/common/execution/JobResult;", "getActionResult", "()Lorg/json/JSONObject;", "getEnvelope", "()Lcom/obric/memorydata/middleware/impl/playground/ResultPendingRegistry$ResultEnvelope;", "ackRet", "", "getAckRet", "()I", "ackDetails", "", "getAckDetails", "()Ljava/lang/String;", "hasNonFinalRecord", "", "getHasNonFinalRecord", "()Z", "allRecordsFinal", "getAllRecordsFinal", "toDispatchResult", "Lcom/obric/memorydata/middleware/impl/playground/DispatchIntentResult;", "entity", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final g f11830a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final JobResult f11831b;
        private final JSONObject c;
        private final d d;
        private final int e;
        private final String f;
        private final boolean g;
        private final boolean h;

        public b(g r3, JobResult r4, JSONObject r5, d r6) {
            Intrinsics.checkNotNullParameter(r3, "pending");
            Intrinsics.checkNotNullParameter(r4, "job");
            Intrinsics.checkNotNullParameter(r5, "actionResult");
            Intrinsics.checkNotNullParameter(r6, "envelope");
            this.f11830a = r3;
            this.f11831b = r4;
            this.c = r5;
            this.d = r6;
            boolean r7 = false;
            if (r4.getHasError() == false) goto L5;
            int r8 = -1;
        L6:
            this.e = r5.optInt("code", r8);
            String r9 = r5.optString(NotificationCompat.CATEGORY_MESSAGE);
            if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L10;
            r9 = null;
        L10:
            if (r9 != null) goto L12;
            r9 = r4.getMessage();
        L12:
            this.f = r9;
            Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(r4.getExecRecords(), Iterable.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r10, Collection.class) == true) goto L15;
        L17:
            Iterator r11 = r10.iterator();
        L19:
            if (r11.hasNext() == false) goto L16;
            if ((!((IntentExecutionRecord) ZeusTransformUtils.preCheckCast(r11.next(), IntentExecutionRecord.class, "com.obric.memorydata.plugin")).getResult().isFinal()) == false) goto L19;
            boolean r12 = true;
        L23:
            this.g = r12;
            if ((!((Collection) ZeusTransformUtils.preCheckCast(this.f11831b.getExecRecords(), Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L38;
            Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast(this.f11831b.getExecRecords(), Iterable.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r13, Collection.class) == true) goto L28;
        L30:
            Iterator r14 = r13.iterator();
        L32:
            if (r14.hasNext() == false) goto L29;
            if (((IntentExecutionRecord) ZeusTransformUtils.preCheckCast(r14.next(), IntentExecutionRecord.class, "com.obric.memorydata.plugin")).getResult().isFinal() == true) goto L32;
            boolean r15 = false;
        L36:
            if (r15 == false) goto L38;
            r7 = true;
        L29:
            r15 = true;
            goto L36
        L28:
            if (((Collection) ZeusTransformUtils.preCheckCast(r13, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L30;
        L38:
            this.h = r7;
            return;
        L16:
            r12 = false;
            goto L23
        L15:
            if (((Collection) ZeusTransformUtils.preCheckCast(r10, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L17;
        L5:
            r8 = 0;
            goto L6
        }

        public final com.obric.memorydata.middleware.impl.playground.b a(Object r26) {
            return new com.obric.memorydata.middleware.impl.playground.b(this.f11831b.getQuestionId(), this.e, this.f, r26, null, this.c.toString(), this.d.a(), this.d.b(), this.d.c(), null, false, null, null, 0, null, false, null, 130576, null);
        }

        public final g a() {
            return this.f11830a;
        }

        public final JobResult b() {
            return this.f11831b;
        }

        public final int c() {
            return this.e;
        }

        public final boolean d() {
            return this.g;
        }

        public final boolean e() {
            return this.h;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f11830a, r6.f11830a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f11831b, r6.f11831b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            return (((((this.f11830a.hashCode() * 31) + this.f11831b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
        }

        public String toString() {
            return "JobFeedback(pending=" + this.f11830a + ", job=" + this.f11831b + ", actionResult=" + this.c + ", envelope=" + this.d + ')';
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\t\u0010\f\u001a\u00020\u0004HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0004HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/obric/memorydata/middleware/impl/playground/ResultPendingRegistry$RawResult;", "", EventBody.KEY_VALUE, AILabCheckPermissionTask.KEY_SOURCE, "", "<init>", "(Ljava/lang/Object;Ljava/lang/String;)V", "getValue", "()Ljava/lang/Object;", "getSource", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object f11832a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f11833b;

        public c(Object r2, String r3) {
            Intrinsics.checkNotNullParameter(r3, AILabCheckPermissionTask.KEY_SOURCE);
            this.f11832a = r2;
            this.f11833b = r3;
        }

        public final Object a() {
            return this.f11832a;
        }

        public final String b() {
            return this.f11833b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
            return false;
        L8:
            c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f11832a, r6.f11832a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f11833b, r6.f11833b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            Object r0 = this.f11832a;
            if (r0 != null) goto L5;
            int r1 = 0;
        L7:
            return (r1 * 31) + this.f11833b.hashCode();
        L5:
            r1 = r0.hashCode();
            goto L7
        }

        public String toString() {
            return "RawResult(value=" + this.f11832a + ", source=" + this.f11833b + ')';
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/obric/memorydata/middleware/impl/playground/ResultPendingRegistry$ResultEnvelope;", "", OaidModel.KEY_ID, "", "questionId", "ext", "Lorg/json/JSONObject;", "<init>", "(JJLorg/json/JSONObject;)V", "getId", "()J", "getQuestionId", "getExt", "()Lorg/json/JSONObject;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f11834a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f11835b;
        private final JSONObject c;

        public d(long r2, long r4, JSONObject r6) {
            Intrinsics.checkNotNullParameter(r6, "ext");
            this.f11834a = r2;
            this.f11835b = r4;
            this.c = r6;
        }

        public final long a() {
            return this.f11834a;
        }

        public final long b() {
            return this.f11835b;
        }

        public final JSONObject c() {
            return this.c;
        }

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, d.class) == true) goto L8;
            return false;
        L8:
            d r10 = (d) ZeusTransformUtils.preCheckCast(r9, d.class, "com.obric.memorydata.plugin");
            if (this.f11834a == r10.f11834a) goto L12;
            return false;
        L12:
            if (this.f11835b == r10.f11835b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r10.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((Long.hashCode(this.f11834a) * 31) + Long.hashCode(this.f11835b)) * 31) + this.c.hashCode();
        }

        public String toString() {
            return "ResultEnvelope(id=" + this.f11834a + ", questionId=" + this.f11835b + ", ext=" + this.c + ')';
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11836a = null;

        static {
            int[] r0 = new int[AppIntentResultMode.values().length];
            r0[AppIntentResultMode.JOB_RESULT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[AppIntentResultMode.ASYNC_APP_INTENT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[AppIntentResultMode.MOBILE_USE_CALLBACK.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f11836a = r0;
        }
    }

    static {
        f11828a = new a(null);
    }

    public j(String r2) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TAG);
        this.f11829b = r2;
        this.c = new ConcurrentHashMap();
        this.d = new ConcurrentHashMap();
    }

    private final com.obric.memorydata.middleware.impl.playground.b a(long r28, long r30, long r32, IntentResult<?> r34, Map<?, ?> r35) {
        JSONObject r7 = b((Map) ZeusTransformUtils.wrapperContextForParams(r35, Map.class, "com.obric.memorydata.plugin"));
        JSONObject r14 = b(r34.getExt());
        return new com.obric.memorydata.middleware.impl.playground.b(r30, r34.getRet(), r34.getDetails(), r34.getEntity(), null, a(r34, r28).toString(), r32, r30, r14, null, false, null, null, 0, a(r7, r14, r34.getEntity()), false, null, 114192, null);
    }

    private static final com.obric.memorydata.middleware.impl.playground.b a(g r9, j r10, long r11, d r13, IntentResult r14, Map r15) {
        Map<?, ?> r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r15, Map.class, "com.obric.memorydata.plugin");
        AppIntentResultMode r12 = r9.b();
        AppIntentResultMode r16 = AppIntentResultMode.MOBILE_USE_CALLBACK;
        long r3 = r13.b();
        if (r12 != r16) goto L6;
        return r10.a(r11, r3, r14, r8);
    L6:
        return r10.a(r11, r3, r13.a(), r14, r8);
    }

    private static final com.obric.memorydata.middleware.impl.playground.b a(j r7, long r8, long r10, IntentResult r12, Map r13) {
        return r7.a(r8, r10, r12, (Map) ZeusTransformUtils.wrapperContextForParams(r13, Map.class, "com.obric.memorydata.plugin"));
    }

    private final c a(JSONObject r2, JSONObject r3) {
        if (r2.has("result") == false) goto L7;
        return new c(r2.opt("result"), "callback_ext");
    L7:
        if (r3.has("result") == true) goto L9;
        return null;
    L9:
        return new c(r3.opt("result"), "intent_result_ext");
    }

    private final d a(String r11, long r12) {
        JSONObject r1 = null;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L9
        j r3 = (j) ZeusTransformUtils.preCheckCast(this, j.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        if (r11 != null) goto L6;
        JSONObject r4 = null;
    L7:
        Object r13 = Result.m1421constructorimpl(r4);     // Catch: Throwable -> L9
    L12:
        if (Result.m1427isFailureimpl(r13) == false) goto L14;
        r13 = null;
    L14:
        JSONObject r14 = (JSONObject) ZeusTransformUtils.preCheckCast(r13, JSONObject.class, "com.obric.memorydata.plugin");
        if (r14 == null) goto L19;
        Long r5 = b(r14, OaidModel.KEY_ID);
        if (r5 == null) goto L19;
        long r6 = r5.longValue();
    L20:
        long r7 = r6;
        if (r14 == null) goto L33;
        Long r8 = b(r14, "question_id");
        if (r8 == null) goto L33;
        if (((Number) ZeusTransformUtils.preCheckCast(r8, Number.class, "com.obric.memorydata.plugin")).longValue() <= 0) goto L27;
        boolean r0 = true;
    L28:
        if (r0 == true) goto L31;
        r8 = null;
    L31:
        if (r8 == null) goto L33;
        r12 = r8.longValue();
        goto L33
    L27:
        r0 = false;
    L33:
        long r9 = r12;
        if (r14 == null) goto L37;
        r1 = c(r14, "ext");
    L37:
        return new d(r7, r9, b(r1));
    L19:
        r6 = -1;
        goto L20
    L6:
        r4 = new JSONObject(r11);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r13 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L12
    }

    private final <T> T a(g r4, Function0<? extends T> r5) {
        return (T) ((Function0) ZeusTransformUtils.wrapperContextForParams(r5, Function0.class, "com.obric.memorydata.plugin")).invoke();
    L5:
        e = move-exception;
        a(r4, (Exception) ZeusTransformUtils.preCheckCast(e, Exception.class, "com.obric.memorydata.plugin"));
        return null;
    }

    private final String a(Object r4) {
        if (r4 != null) goto L5;
        return null;
    L5:
        if (Intrinsics.areEqual(r4, JSONObject.NULL) == false) goto L8;
        return null;
    L8:
        if (ZeusTransformUtils.instanceOf(r4, String.class) == false) goto L15;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L25;
        r4 = null;
    L25:
        return (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.memorydata.plugin");
    L15:
        if (ZeusTransformUtils.instanceOf(r4, JSONObject.class) == true) goto L23;
        if (ZeusTransformUtils.instanceOf(r4, JSONArray.class) == true) goto L23;
        if (ZeusTransformUtils.instanceOf(r4, Number.class) == true) goto L23;
        if (ZeusTransformUtils.instanceOf(r4, Boolean.class) == true) goto L23;
        return null;
    L23:
        return r4.toString();
    }

    private final String a(JSONObject r5, JSONObject r6, Object r7) {
        boolean r8 = a(r5, r6, ZeusTransformUtils.instanceOf(r7, Bitmap.class));
        Object r9 = null;
        if (r8 == true) goto L6;
        return null;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, Bitmap.class) == false) goto L8;
        Bitmap r10 = (Bitmap) ZeusTransformUtils.preCheckCast(r7, Bitmap.class, "com.obric.memorydata.plugin");
    L9:
        if (r10 != null) goto L32;
        return null;
    L32:
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L20
        j r4 = (j) ZeusTransformUtils.preCheckCast(this, j.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
        Closeable r12 = (Closeable) ZeusTransformUtils.preCheckCast(new ByteArrayOutputStream(), Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
        ByteArrayOutputStream r13 = (ByteArrayOutputStream) ZeusTransformUtils.preCheckCast(r12, ByteArrayOutputStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
        r10.compress(Bitmap.CompressFormat.JPEG, 85, (OutputStream) ZeusTransformUtils.preCheckCast(r13, OutputStream.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L15
        String r14 = Base64.encodeToString(r13.toByteArray(), 2);     // Catch: Throwable -> L15
        CloseableKt.closeFinally(r12, null);     // Catch: Throwable -> L20
        Object r15 = Result.m1421constructorimpl(r14);     // Catch: Throwable -> L20
    L23:
        if (Result.m1427isFailureimpl(r15) == true) goto L27;
        r9 = r15;
    L27:
        return (String) ZeusTransformUtils.preCheckCast(r9, String.class, "com.obric.memorydata.plugin");
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        CloseableKt.closeFinally(r12, th);     // Catch: Throwable -> L20
        throw th;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r15 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L23
    L8:
        r10 = null;
        goto L9
    }

    private static final Pair a(Object r2, String r3) {
        return TuplesKt.to(r3, ((JSONObject) ZeusTransformUtils.preCheckCast(r2, JSONObject.class, "com.obric.memorydata.plugin")).opt(r3));
    }

    private static final Pair a(Map.Entry r4) {
        Map.Entry r5 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r4, Map.Entry.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "<destruct>");
        Object r0 = r5.getKey();
        Object r6 = r5.getValue();
        if (ZeusTransformUtils.instanceOf(r0, String.class) == false) goto L5;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin");
    L6:
        if (r1 != null) goto L8;
        return null;
    L8:
        return TuplesKt.to(r1, r6);
    L5:
        r1 = null;
        goto L6
    }

    private final JSONObject a(IntentResult<?> r3, long r4) {
        JSONObject r2 = new JSONObject().put("code", r3.getRet());
        String r0 = r3.getDetails();
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        JSONObject r5 = r2.put(NotificationCompat.CATEGORY_MESSAGE, r0).put("replyFor", String.valueOf(r4)).put("uiType", r3.getUiType());
        List<JSONObject> r6 = l.a(r3.getEntity());
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L8;
        r5.put("entity_data", new JSONArray((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.memorydata.plugin")).toString());
    L8:
        Intrinsics.checkNotNullExpressionValue(r5, "apply(...)");
        return r5;
    }

    private static final JSONObject a(j r0, String r1, JobResult r2) {
        return r0.a(r1, r2);
    }

    private final JSONObject a(String r6) {
        Object r2 = null;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L8
        j r4 = (j) ZeusTransformUtils.preCheckCast(this, j.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L8
        if (r6 != null) goto L6;
        return null;
    L6:
        Object r7 = Result.m1421constructorimpl(new JSONObject(r6));     // Catch: Throwable -> L8
    L11:
        if (Result.m1427isFailureimpl(r7) == false) goto L13;
        r7 = null;
    L13:
        JSONObject r8 = (JSONObject) ZeusTransformUtils.preCheckCast(r7, JSONObject.class, "com.obric.memorydata.plugin");
        if (r8 != null) goto L16;
        return null;
    L16:
        Object r5 = r8.opt(Params.CONTENT);
        if (ZeusTransformUtils.instanceOf(r5, JSONObject.class) == false) goto L21;
        Object r9 = ZeusTransformUtils.preCheckCast(r5, JSONObject.class, "com.obric.memorydata.plugin");
    L47:
        return (JSONObject) r9;
    L21:
        if (ZeusTransformUtils.instanceOf(r5, String.class) == false) goto L32;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L24
        j r11 = (j) ZeusTransformUtils.preCheckCast(this, j.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L24
        Object r12 = Result.m1421constructorimpl(new JSONObject((String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.memorydata.plugin")));     // Catch: Throwable -> L24
    L27:
        if (Result.m1427isFailureimpl(r12) == true) goto L30;
        r2 = r12;
    L30:
        r9 = ZeusTransformUtils.preCheckCast(r2, JSONObject.class, "com.obric.memorydata.plugin");
    L24:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r12 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L27
    L32:
        if (r8.has("code") == false) goto L34;
    L39:
        boolean r14 = true;
    L40:
        if (r14 == true) goto L42;
        return null;
    L42:
        return r8;
    L34:
        if (r8.has(NotificationCompat.CATEGORY_MESSAGE) == true) goto L39;
        if (r8.has("entity_data") == true) goto L39;
        r14 = false;
    L8:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r7 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    private final JSONObject a(String r5, JobResult r6) {
        IntentExecutionRecord r0 = (IntentExecutionRecord) ZeusTransformUtils.preCheckCast(CollectionsKt.lastOrNull(r6.getExecRecords()), IntentExecutionRecord.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L5;
        IntentResult<?> r1 = r0.getResult();
    L6:
        JSONObject r7 = a(r5);
        if (r7 != null) goto L23;
        JSONObject r8 = new JSONObject();
        if (r1 == null) goto L12;
        int r2 = r1.getRet();
    L15:
        JSONObject r9 = r8.put("code", r2);
        if (r1 == null) goto L19;
        String r3 = r1.getDetails();
        if (r3 == null) goto L19;
    L22:
        r7 = r9.put(NotificationCompat.CATEGORY_MESSAGE, r3);
    L19:
        r3 = r6.getMessage();
        if (r3 != null) goto L22;
        r3 = "";
        goto L22
    L12:
        if (r6.getHasError() == false) goto L14;
        r2 = -1;
        goto L15
    L14:
        r2 = 0;
    L23:
        Intrinsics.checkNotNull(r7);
        if (a(r7) == true) goto L32;
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(r6.getExecRecords(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r10 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r11 = r4.iterator();
    L27:
        if (r11.hasNext() == false) goto L29;
        CollectionsKt.addAll(r10, (Iterable) ZeusTransformUtils.preCheckCast(l.a(((IntentExecutionRecord) ZeusTransformUtils.preCheckCast(r11.next(), IntentExecutionRecord.class, "com.obric.memorydata.plugin")).getResult().getEntity()), Iterable.class, "com.obric.memorydata.plugin"));
        goto L27
    L29:
        List r12 = (List) ZeusTransformUtils.preCheckCast(r10, List.class, "com.obric.memorydata.plugin");
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r12, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L32;
        r7.put("entity_data", new JSONArray((Collection) ZeusTransformUtils.preCheckCast(r12, Collection.class, "com.obric.memorydata.plugin")).toString());
    L32:
        return r7;
    L5:
        r1 = null;
        goto L6
    }

    private final JSONObject a(JSONObject r5, String r6) {
        JSONObject r4 = new JSONObject();
        Iterator<String> r0 = r5.keys();
        Intrinsics.checkNotNullExpressionValue(r0, "keys(...)");
    L4:
        if (r0.hasNext() == false) goto L8;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r1, r6) == true) goto L4;
        r4.put(r1, r5.opt(r1));
        goto L4
    L8:
        return r4;
    }

    private final void a(long r5, com.obric.memorydata.middleware.impl.playground.b r7, boolean r8) {
        g r0 = (g) ZeusTransformUtils.preCheckCast(this.c.get(Long.valueOf(r5)), g.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L6;
        RunLog.INSTANCE.debug(((j) ZeusTransformUtils.preCheckCast(this, j.class, "com.obric.memorydata.plugin")).f11829b, "intent feedback dropped without pending messageId=" + r5);
        return;
    L6:
        RunLog.INSTANCE.debug(this.f11829b, "final intent feedback received messageId=" + r5 + " ret=" + r7.b() + " statusChange=" + r8 + " resultMode=" + r0.b());
        int r4 = e.f11836a[r0.b().ordinal()];
        if (r4 != 1) goto L9;
        r0.a(r7);
        return;
    L9:
        if (r4 != 2) goto L11;
    L15:
        r0.b(r7);
        return;
    L11:
        if (r4 == 3) goto L15;
        throw new NoWhenBranchMatchedException();
    }

    private final void a(g r31, Exception r32) {
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), this.f11829b, "[code=playground_callback_result_parse_failed] callback result parse failed error=" + r32.getClass().getSimpleName(), null, 4, null);
        r31.b(new com.obric.memorydata.middleware.impl.playground.b(r31.a(), -3, null, null, "intent callback result parse failed", null, 0, 0, null, null, false, null, null, 0, null, true, r31.b(), 32736, null));
    }

    private final void a(b r5) {
        Object r1 = null;
        if (r5.a().b() != AppIntentResultMode.MOBILE_USE_CALLBACK) goto L9;
        if (r5.c() == 0) goto L9;
        r5.a().b(r5.a(null));
        return;
    L9:
        if (r5.a().b() != AppIntentResultMode.ASYNC_APP_INTENT) goto L12;
        return;
    L12:
        if (r5.a().b() != AppIntentResultMode.JOB_RESULT) goto L20;
        if (r5.d() == false) goto L20;
        r5.a().c();
        com.obric.memorydata.middleware.impl.playground.b r4 = r5.a().d();
        if (r4 == null) goto L30;
        r5.a().b(r4);
        return;
    L30:
        return;
    L20:
        if (r5.a().b() != AppIntentResultMode.JOB_RESULT) goto L22;
    L23:
        g r6 = r5.a();
        IntentExecutionRecord r0 = (IntentExecutionRecord) ZeusTransformUtils.preCheckCast(CollectionsKt.lastOrNull(r5.b().getExecRecords()), IntentExecutionRecord.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L28;
        IntentResult<?> r2 = r0.getResult();
        if (r2 == null) goto L28;
        r1 = r2.getEntity();
    L28:
        r6.b(r5.a(r1));
        return;
    L22:
        if (r5.e() == true) goto L23;
    }

    private final boolean a(JSONObject r4) {
        Object r3 = r4.opt("entity_data");
        if (r3 != null) goto L6;
        return false;
    L6:
        if (ZeusTransformUtils.instanceOf(r3, JSONArray.class) == false) goto L11;
        if (((JSONArray) ZeusTransformUtils.preCheckCast(r3, JSONArray.class, "com.obric.memorydata.plugin")).length() > 0) goto L21;
        return false;
    L21:
        return true;
    L11:
        if (ZeusTransformUtils.instanceOf(r3, String.class) == false) goto L18;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin")).toString(), HttpUrl.PATH_SEGMENT_ENCODE_SET_URI) == false) goto L21;
        return false;
    L18:
        if (Intrinsics.areEqual(r3, JSONObject.NULL) == false) goto L21;
        return false;
    }

    private final boolean a(JSONObject r1, JSONObject r2, boolean r3) {
        if (r3 == true) goto L4;
    L8:
        return false;
    L4:
        if (b(r1) == true) goto L8;
        if (b(r2) == true) goto L8;
        return true;
    }

    private final b b(String r13, final String r14, final JobResult r15) {
        if (r15 != null) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), ((j) ZeusTransformUtils.preCheckCast(this, j.class, "com.obric.memorydata.plugin")).f11829b, "[code=playground_feedback_job_missing] feedback is missing job result", null, 4, null);
        return null;
    L6:
        Long r3 = (Long) ZeusTransformUtils.preCheckCast(this.d.get(Long.valueOf(r15.getQuestionId())), Long.class, "com.obric.memorydata.plugin");
        Long r16 = b(r13);
        if (r3 == null) goto L9;
        long r4 = r3.longValue();
    L12:
        g r17 = (g) ZeusTransformUtils.preCheckCast(this.c.get(Long.valueOf(r4)), g.class, "com.obric.memorydata.plugin");
        if (r17 != null) goto L16;
        RunLog.INSTANCE.debug(((j) ZeusTransformUtils.preCheckCast(this, j.class, "com.obric.memorydata.plugin")).f11829b, "job feedback dropped without pending messageId=" + r4);
        return null;
    L16:
        JSONObject r0 = (JSONObject) ZeusTransformUtils.preCheckCast(a(r17, new $$Lambda$j$vBbSpEwj3eYILTF82eYOWJYvwY(this, r14, r15)), JSONObject.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L19;
        return null;
    L19:
        RunLog r1 = RunLog.INSTANCE;
        String r5 = this.f11829b;
        StringBuilder r6 = new StringBuilder().append("job feedback received messageId=").append(r4).append(" questionId=").append(r15.getQuestionId()).append(" recordCount=").append(r15.getExecRecords().size()).append(" nonFinal=");
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(r15.getExecRecords(), Iterable.class, "com.obric.memorydata.plugin");
        boolean r9 = true;
        int r10 = 0;
        if (ZeusTransformUtils.instanceOf(r7, Collection.class) == true) goto L22;
    L24:
        Iterator r8 = r7.iterator();
    L26:
        if (r8.hasNext() == false) goto L23;
        if ((!((IntentExecutionRecord) ZeusTransformUtils.preCheckCast(r8.next(), IntentExecutionRecord.class, "com.obric.memorydata.plugin")).getResult().isFinal()) == false) goto L26;
    L29:
        StringBuilder r2 = r6.append(r9).append(" ret=");
        if (r15.getHasError() == false) goto L32;
        r10 = -1;
    L32:
        r1.debug(r5, r2.append(r0.optInt("code", r10)).toString());
        return new b(r17, r15, r0, a(r14, r4));
    L23:
        r9 = false;
        goto L29
    L22:
        if (((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L24;
    L9:
        if (r16 == null) goto L11;
        r4 = r16.longValue();
        goto L12
    L11:
        r4 = r15.getQuestionId();
        goto L12
    }

    private final d b(String r11, long r12) {
        Long r1 = null;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L9
        j r3 = (j) ZeusTransformUtils.preCheckCast(this, j.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        if (r11 != null) goto L6;
        JSONObject r4 = null;
    L7:
        Object r13 = Result.m1421constructorimpl(r4);     // Catch: Throwable -> L9
    L12:
        if (Result.m1427isFailureimpl(r13) == false) goto L14;
        r13 = null;
    L14:
        JSONObject r14 = (JSONObject) ZeusTransformUtils.preCheckCast(r13, JSONObject.class, "com.obric.memorydata.plugin");
        if (r14 == null) goto L19;
        Long r5 = b(r14, OaidModel.KEY_ID);
        if (r5 == null) goto L19;
        long r6 = r5.longValue();
    L20:
        long r7 = r6;
        if (r14 == null) goto L33;
        Long r10 = b(r14, "question_id");
        if (r10 == null) goto L33;
        if (((Number) ZeusTransformUtils.preCheckCast(r10, Number.class, "com.obric.memorydata.plugin")).longValue() <= 0) goto L27;
        boolean r15 = true;
    L28:
        if (r15 == false) goto L30;
        r1 = r10;
    L30:
        if (r1 == null) goto L33;
        r12 = r1.longValue();
        goto L33
    L27:
        r15 = false;
    L33:
        return new d(r7, r12, new JSONObject());
    L19:
        r6 = -1;
        goto L20
    L6:
        r4 = new JSONObject(r11);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r13 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L12
    }

    private final Long b(String r8) {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin");
        boolean r2 = false;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L10:
        if (r1 == false) goto L32;
        return null;
    L32:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L19
        j r7 = (j) ZeusTransformUtils.preCheckCast(this, j.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
        JSONObject r4 = new JSONObject(r8);     // Catch: Throwable -> L19
        Long r9 = r7.b(r4, "message_id");     // Catch: Throwable -> L19
        if (r9 != null) goto L17;
        r9 = r7.b(r4, OaidModel.KEY_ID);     // Catch: Throwable -> L19
        if (r9 != null) goto L17;
        r9 = r7.b(r4, "question_id");     // Catch: Throwable -> L19
    L17:
        Object r10 = Result.m1421constructorimpl(r9);     // Catch: Throwable -> L19
    L22:
        if (Result.m1427isFailureimpl(r10) == false) goto L24;
        r10 = null;
    L24:
        Long r11 = (Long) ZeusTransformUtils.preCheckCast(r10, Long.class, "com.obric.memorydata.plugin");
        if (r11 != null) goto L27;
        return null;
    L27:
        if (((Number) ZeusTransformUtils.preCheckCast(r11, Number.class, "com.obric.memorydata.plugin")).longValue() <= 0) goto L29;
        r2 = true;
    L29:
        if (r2 == true) goto L31;
        return null;
    L31:
        return r11;
    L19:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r10 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L22
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r1 = false;
        goto L10
    }

    private final Long b(JSONObject r2, String r3) {
        if (r2.has(r3) == true) goto L5;
        return null;
    L5:
        if (r2.isNull(r3) == true) goto L17;
        Object r1 = r2.opt(r3);
        if (ZeusTransformUtils.instanceOf(r1, Number.class) == false) goto L11;
        return Long.valueOf(((Number) ZeusTransformUtils.preCheckCast(r1, Number.class, "com.obric.memorydata.plugin")).longValue());
    L11:
        if (ZeusTransformUtils.instanceOf(r1, String.class) == true) goto L13;
        return null;
    L13:
        return StringsKt.toLongOrNull((String) ZeusTransformUtils.preCheckCast(r1, String.class, "com.obric.memorydata.plugin"));
    L17:
        return null;
    }

    private static final Pair b(Object r2, String r3) {
        return TuplesKt.to(r3, ((Bundle) ZeusTransformUtils.preCheckCast(r2, Bundle.class, "com.obric.memorydata.plugin")).get(r3));
    }

    private final JSONObject b(final Object r6) {
        if (ZeusTransformUtils.instanceOf(r6, JSONObject.class) == false) goto L7;
        Iterator<String> r0 = ((JSONObject) ZeusTransformUtils.preCheckCast(r6, JSONObject.class, "com.obric.memorydata.plugin")).keys();
        Intrinsics.checkNotNullExpressionValue(r0, "keys(...)");
        Sequence r1 = SequencesKt.asSequence(r0);
        Function1 r2 = new $$Lambda$j$wVu7KFMnSsX_vux3WaK8Zjjd1a4(r6);
    L5:
        Sequence r7 = SequencesKt.map(r1, r2);
    L12:
        JSONObject r3 = new JSONObject();
        Iterator r8 = r7.iterator();
    L14:
        if (r8.hasNext() == false) goto L18;
        Pair r4 = (Pair) ZeusTransformUtils.preCheckCast(r8.next(), Pair.class, "com.obric.memorydata.plugin");
        String r5 = (String) ZeusTransformUtils.preCheckCast(r4.component1(), String.class, "com.obric.memorydata.plugin");
        Object r9 = c(r4.component2());
        if (r9 == null) goto L14;
        r3.put(r5, r9);
        goto L14
    L18:
        return r3;
    L7:
        if (ZeusTransformUtils.instanceOf(r6, Bundle.class) == false) goto L10;
        Set<String> r10 = ((Bundle) ZeusTransformUtils.preCheckCast(r6, Bundle.class, "com.obric.memorydata.plugin")).keySet();
        Intrinsics.checkNotNullExpressionValue(r10, "keySet(...)");
        r1 = CollectionsKt.asSequence((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin"));
        r2 = new $$Lambda$j$5MLglN3vijGiBoB7ZnvHbUgCSOg(r6);
        goto L5
    L10:
        if (ZeusTransformUtils.instanceOf(r6, Map.class) == false) goto L20;
        r7 = SequencesKt.mapNotNull(CollectionsKt.asSequence((Iterable) ZeusTransformUtils.preCheckCast(((Map) ZeusTransformUtils.preCheckCast(r6, Map.class, "com.obric.memorydata.plugin")).entrySet(), Iterable.class, "com.obric.memorydata.plugin")), $$Lambda$j$IpXdQQkjUhv9PMk2DNcDoIKWhfA.INSTANCE);
        goto L12
    L20:
        return new JSONObject();
    }

    private final boolean b(JSONObject r1) {
        if (r1.has("screenshot") == false) goto L5;
    L8:
        return true;
    L5:
        if (r1.has("screen_shot") == true) goto L8;
        return false;
    }

    private final Object c(Object r6) {
        if (r6 == null) goto L48;
        if (Intrinsics.areEqual(r6, JSONObject.NULL) == true) goto L48;
        if (ZeusTransformUtils.instanceOf(r6, String.class) == false) goto L9;
        return r6;
    L9:
        if (ZeusTransformUtils.instanceOf(r6, Number.class) == false) goto L11;
        return r6;
    L11:
        if (ZeusTransformUtils.instanceOf(r6, Boolean.class) == false) goto L14;
        return r6;
    L14:
        if (ZeusTransformUtils.instanceOf(r6, JSONObject.class) == true) goto L64;
        if (ZeusTransformUtils.instanceOf(r6, Bundle.class) == true) goto L64;
        if (ZeusTransformUtils.instanceOf(r6, Map.class) == true) goto L64;
        int r1 = 0;
        if (ZeusTransformUtils.instanceOf(r6, JSONArray.class) == false) goto L30;
        JSONArray r0 = new JSONArray();
        int r3 = ((JSONArray) ZeusTransformUtils.preCheckCast(r6, JSONArray.class, "com.obric.memorydata.plugin")).length();
    L23:
        if (r1 >= r3) goto L62;
        Object r4 = d(((JSONArray) ZeusTransformUtils.preCheckCast(r6, JSONArray.class, "com.obric.memorydata.plugin")).opt(r1));
        if (r4 == null) goto L27;
        r0.put(r4);
    L27:
        r1 = r1 + 1;
    L62:
        return r0;
    L30:
        if (ZeusTransformUtils.instanceOf(r6, Iterable.class) == false) goto L38;
        r0 = new JSONArray();
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L33:
        if (r7.hasNext() == false) goto L62;
        Object r2 = d(r7.next());
        if (r2 == null) goto L33;
        r0.put(r2);
        goto L33
    L38:
        if ((r6 instanceof Object[]) == false) goto L45;
        r0 = new JSONArray();
        Object[] r8 = (Object[]) ZeusTransformUtils.preCheckCast(r6, Object[].class, "com.obric.memorydata.plugin");
        int r5 = r8.length;
    L40:
        if (r1 >= r5) goto L62;
        Object r9 = d(r8[r1]);
        if (r9 == null) goto L44;
        r0.put(r9);
    L44:
        r1 = r1 + 1;
        goto L40
    L45:
        return null;
    L64:
        return b(r6);
    L48:
        return JSONObject.NULL;
    }

    private final JSONObject c(JSONObject r3, String r4) {
        Object r2 = r3.opt(r4);
        Object r5 = null;
        if (ZeusTransformUtils.instanceOf(r2, JSONObject.class) == false) goto L7;
        Object r6 = ZeusTransformUtils.preCheckCast(r2, JSONObject.class, "com.obric.memorydata.plugin");
    L17:
        return (JSONObject) r6;
    L7:
        if (ZeusTransformUtils.instanceOf(r2, String.class) == false) goto L20;
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L10
        Object r8 = Result.m1421constructorimpl(new JSONObject((String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.memorydata.plugin")));     // Catch: Throwable -> L10
    L13:
        if (Result.m1427isFailureimpl(r8) == true) goto L16;
        r5 = r8;
    L16:
        r6 = ZeusTransformUtils.preCheckCast(r5, JSONObject.class, "com.obric.memorydata.plugin");
    L10:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r8 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L13
    L20:
        return null;
    }

    private final Object d(Object r1) {
        return c(r1);
    }

    public static /* synthetic */ com.obric.memorydata.middleware.impl.playground.b lambda$1xQmDsscAPW25ySrXL9jrQgmjC4(j r0, long r1, long r3, IntentResult r5, Map r6) {
        return a(r0, r1, r3, r5, r6);
    }

    public static /* synthetic */ Pair lambda$5MLglN3vijGiBoB7ZnvHbUgCSOg(Object r0, String r1) {
        return b(r0, r1);
    }

    public static /* synthetic */ com.obric.memorydata.middleware.impl.playground.b lambda$5RqA9Dn1ht7cR6fsf4gt1RKHd6Y(g r0, j r1, long r2, d r4, IntentResult r5, Map r6) {
        return a(r0, r1, r2, r4, r5, r6);
    }

    public static /* synthetic */ Pair lambda$IpXdQQkjUhv9PMk2DNcDoIKWhfA(Map.Entry r0) {
        return a(r0);
    }

    /* JADX INFO: renamed from: lambda$vB-bSpEwj3eYILTF82eYOWJYvwY, reason: not valid java name */
    public static /* synthetic */ JSONObject m1034lambda$vBbSpEwj3eYILTF82eYOWJYvwY(j r0, String r1, JobResult r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ Pair lambda$wVu7KFMnSsX_vux3WaK8Zjjd1a4(Object r0, String r1) {
        return a(r0, r1);
    }

    public final com.obric.memorydata.middleware.impl.playground.b a(long r29, long r31, IntentResult<?> r33, Map<?, ?> r34) {
        Map r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r34, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r33, "result");
        JSONObject r3 = b(r2);
        JSONObject r4 = b(r33.getExt());
        c r5 = a(r3, r4);
        if (r5 == null) goto L5;
        Object r7 = r5.a();
    L6:
        String r8 = a(r7);
        if (r8 != null) goto L9;
        r8 = a(r33, r29).toString();
        Intrinsics.checkNotNullExpressionValue(r8, "toString(...)");
    L9:
        String r11 = r8;
        int r9 = r33.getRet();
        String r10 = r33.getDetails();
        Object r12 = r33.getEntity();
        if (r5 == null) goto L12;
        Object r17 = r5.a();
    L13:
        if (r5 == null) goto L15;
        boolean r14 = true;
    L16:
        boolean r18 = r14;
        if (r5 == null) goto L19;
        String r19 = r5.b();
    L21:
        return new com.obric.memorydata.middleware.impl.playground.b(r31, r9, r10, r12, null, r11, -1, r31, r3, r17, r18, r19, a(r4, "result"), r33.getUiType(), a(r3, r4, r33.getEntity()), false, null, 98320, null);
    L19:
        r19 = null;
        goto L21
    L15:
        r14 = false;
        goto L16
    L12:
        r17 = null;
        goto L13
    L5:
        r7 = null;
        goto L6
    }

    public final g a(long r9, long r11, AppIntentResultMode r13) {
        Intrinsics.checkNotNullParameter(r13, "resultMode");
        g r0 = new g(r9, r11, r13);
        Long r14 = (Long) ZeusTransformUtils.preCheckCast(this.d.putIfAbsent(Long.valueOf(r11), Long.valueOf(r9)), Long.class, "com.obric.memorydata.plugin");
        if (r14 == null) goto L5;
    L7:
        if (r14 != null) goto L9;
        this.d.remove(Long.valueOf(r11), Long.valueOf(r9));
    L9:
        r0 = null;
    L10:
        RunLog r1 = RunLog.INSTANCE;
        if (r0 != null) goto L13;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(r1, IRunLog.class, "com.obric.memorydata.plugin"), this.f11829b, "[code=playground_duplicate_question_id] request registration rejected messageId=" + r9 + " questionId=" + r11, null, 4, null);
    L14:
        return r0;
    L13:
        r1.debug(this.f11829b, "request registered messageId=" + r9 + " questionId=" + r11);
        goto L14
    L5:
        if (this.c.putIfAbsent(Long.valueOf(r9), r0) != null) goto L7;
        goto L7
    }

    public final void a(final long r15, IntentResult<?> r17, boolean r18, Map<?, ?> r19) {
        final Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r19, Map.class, "com.obric.memorydata.plugin");
        if (r17 != null) goto L5;
    L22:
        RunLog.INSTANCE.debug(((j) ZeusTransformUtils.preCheckCast(this, j.class, "com.obric.memorydata.plugin")).f11829b, "non-final intent feedback ignored questionId=" + r15);
        return;
    L5:
        if (r17.isFinal() == false) goto L7;
        final IntentResult<?> r6 = r17;
    L8:
        if (r6 == null) goto L22;
        Long r0 = (Long) ZeusTransformUtils.preCheckCast(this.d.get(Long.valueOf(r15)), Long.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L13;
        long r10 = r0.longValue();
    L14:
        g r12 = (g) ZeusTransformUtils.preCheckCast(this.c.get(Long.valueOf(r10)), g.class, "com.obric.memorydata.plugin");
        if (r12 != null) goto L17;
        return;
    L17:
        final long r2 = r10;
        com.obric.memorydata.middleware.impl.playground.b r1 = (com.obric.memorydata.middleware.impl.playground.b) ZeusTransformUtils.preCheckCast(a(r12, new $$Lambda$j$1xQmDsscAPW25ySrXL9jrQgmjC4(this, r2, r15, r6, r7)), com.obric.memorydata.middleware.impl.playground.b.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L20;
        return;
    L20:
        a(r10, r1, r18);
        return;
    L13:
        r10 = r15;
        goto L14
    L7:
        r6 = null;
        goto L8
    }

    public final void a(long r5, g r7) {
        Intrinsics.checkNotNullParameter(r7, "pending");
        boolean r0 = this.c.remove(Long.valueOf(r5), r7);
        if (r0 == false) goto L5;
        this.d.remove(Long.valueOf(r7.a()), Long.valueOf(r5));
    L5:
        RunLog.INSTANCE.debug(this.f11829b, "request forgotten messageId=" + r5 + " removed=" + r0 + " remaining=" + this.c.size());
    }

    public final void a(String r15, IntentResult<?> r16, boolean r17, Map<?, ?> r18) {
        final Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r18, Map.class, "com.obric.memorydata.plugin");
        Long r1 = b(r15);
        if (r1 == null) goto L22;
        final long r10 = r1.longValue();
        if (r16 != null) goto L7;
    L20:
        RunLog.INSTANCE.debug(((j) ZeusTransformUtils.preCheckCast(this, j.class, "com.obric.memorydata.plugin")).f11829b, "non-final intent feedback ignored messageId=" + r10);
        return;
    L7:
        if (r16.isFinal() == false) goto L9;
        final IntentResult<?> r6 = r16;
    L10:
        if (r6 == null) goto L20;
        final d r5 = b(r15, r10);
        final g r12 = (g) ZeusTransformUtils.preCheckCast(this.c.get(Long.valueOf(r10)), g.class, "com.obric.memorydata.plugin");
        if (r12 != null) goto L15;
        return;
    L15:
        com.obric.memorydata.middleware.impl.playground.b r0 = (com.obric.memorydata.middleware.impl.playground.b) ZeusTransformUtils.preCheckCast(a(r12, new $$Lambda$j$5RqA9Dn1ht7cR6fsf4gt1RKHd6Y(r12, this, r10, r5, r6, r7)), com.obric.memorydata.middleware.impl.playground.b.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L18;
        return;
    L18:
        a(r10, r0, r17);
        return;
    L9:
        r6 = null;
        goto L10
    L22:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), ((j) ZeusTransformUtils.preCheckCast(this, j.class, "com.obric.memorydata.plugin")).f11829b, "[code=playground_feedback_question_id_parse_miss] feedback message id parse missed", null, 4, null);
    }

    public final void a(String r1, String r2, JobResult r3) {
        b r4 = b(r1, r2, r3);
        if (r4 != null) goto L5;
        return;
    L5:
        a(r4);
    }
}
