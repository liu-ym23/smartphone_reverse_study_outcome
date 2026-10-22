package com.obric.memorydata.memory.llm;

import android.content.Context;
import android.database.SQLException;
import android.os.SystemClock;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm6.hub.config.internal.SlardarSettingsConstants;
import com.bytedance.bdinstall.dtrait.constant.DTraitConstant;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.crash.entity.EventBody;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.EntityType;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.obric.memorydata.BuildConfig;
import com.obric.memorydata.database.entity.ChatMessage;
import com.obric.memorydata.database.entity.EpisodicMemoryEntity;
import com.obric.memorydata.database.entity.fj;
import com.obric.memorydata.database.entity.ip;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.memory.memoryentity.MemoryEntityManager;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.logging.o;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.task.impl.TaskResult;
import com.obric.memorydata.utils.at;
import com.ttnet.org.chromium.net.NetError;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.bx;
import kotlinx.coroutines.ca;
import kotlinx.coroutines.da;
import kotlinx.coroutines.n;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003UVWB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Jj\u0010*\u001a\"\u0012\f\u0012\n\u0012\u0004\u0012\u00020-\u0018\u00010,\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010.0+2\b\u0010/\u001a\u0004\u0018\u0001002\u0006\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u0001042\b\u00105\u001a\u0004\u0018\u0001062\n\b\u0002\u00107\u001a\u0004\u0018\u0001082\b\b\u0002\u00109\u001a\u00020:H\u0086@¢\u0006\u0002\u0010;Jj\u0010<\u001a\"\u0012\f\u0012\n\u0012\u0004\u0012\u00020-\u0018\u00010,\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010.0+2\b\u0010/\u001a\u0004\u0018\u0001002\u0006\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u0001042\b\u00105\u001a\u0004\u0018\u0001062\n\b\u0002\u00107\u001a\u0004\u0018\u0001082\b\b\u0002\u00109\u001a\u00020:H\u0082@¢\u0006\u0002\u0010;J\u0018\u0010=\u001a\u00020>2\u0006\u00101\u001a\u0002022\u0006\u0010?\u001a\u00020\u0007H\u0002JF\u0010@\u001a\u00020A2\b\u0010B\u001a\u0004\u0018\u00010C2\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020G2\u000e\u0010H\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010,2\u0012\u0010I\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010.H\u0002J$\u0010J\u001a\u00020A2\u0006\u0010K\u001a\u00020>2\u0012\u0010I\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010LH\u0002J\u0016\u0010M\u001a\b\u0012\u0004\u0012\u00020-0,2\u0006\u0010N\u001a\u00020>H\u0002J&\u0010O\u001a\u00020A2\u0006\u0010P\u001a\u00020Q2\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020EH\u0082@¢\u0006\u0002\u0010RJ\f\u0010S\u001a\u0004\u0018\u00010T*\u00020-R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0016X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006X"}, d2 = {"Lcom/obric/memorydata/memory/llm/MemoryLLMBuildHelperV2;", "", "<init>", "()V", "TIMEOUT_TASK", "", "KEY_OUT_STAGE", "", "KEY_OUT_CONTENT", "KEY_OUT_TITLE", "KEY_OUT_DELTA", "KEY_OUT_ENTITY_ID", "KEY_OUT_ENTITY_LIST", "KEY_OUT_ENTITY_TYPE", "KEY_OUT_OPERATE_TYPE", "KEY_OUT_STATUS", "KEY_OUT_ANSWER", "KEY_OUT_PURPOSE", "KEY_TASK_RESULT", "KEY_OUT_RESULT_STR_ASSISTANT", "KEY_OUT_RESULT_STR_MEMORY", "STAGE_SNAPSHOT", "", "STAGE_CONTENT", "STAGE_COMPLETE", "KEY_ERROR_CODE", "KEY_ERROR_MSG", "KEY_EXTRA_RESULT_TYPE", "KEY_EXTRA_ANSWER", "KEY_EXTRA_RESULT_SUBTYPE", "KEY_EXTRA_DELETE_RAW_JSON", "KEY_EXTRA_METRICS", "KEY_EXTRA_LOG_ID", "KEY_EXTRA_RESULT_STR_ASSISTANT", "KEY_EXTRA_RESULT_STR_MEMORY", "VALUE_EXTRA_RESULT_TYPE_INSERT", "VALUE_EXTRA_RESULT_TYPE_UPDATE", "VALUE_EXTRA_RESULT_TYPE_CALL_USER", "VALUE_EXTRA_RESULT_TYPE_ILLEGAL", "VALUE_EXTRA_RESULT_TYPE_EXCEPTION", "VALUE_EXTRA_RESULT_TYPE_SUCCESS", "VALUE_EXTRA_RESULT_SUBTYPE_DELETE_CONFIRM", "executeMemoryBuildByLLM", "Lkotlin/Pair;", "", "Lcom/obric/memorydata/memory/llm/MemoryLLMBuildHelperV2$ResultEntity;", "", "trackingEvent", "Lcom/obric/memorydata/memory/tracker/MobileMemBuildTracker$Event;", "inputData", "Lcom/obric/memorydata/memory/llm/MemoryLLMBuildInputData;", "memorySourceInfo", "Lcom/obric/memorydata/memory/memoryentity/MemorySourceInfo;", "pageContextHandle", "Lcom/obric/memorydata/dc/PageContextHandle;", "retryEntity", "Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "eval", "", "(Lcom/obric/memorydata/memory/tracker/MobileMemBuildTracker$Event;Lcom/obric/memorydata/memory/llm/MemoryLLMBuildInputData;Lcom/obric/memorydata/memory/memoryentity/MemorySourceInfo;Lcom/obric/memorydata/dc/PageContextHandle;Lcom/obric/capabilitykit/entity/memory/MemoryEntity;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "execute", "buildMobileMemBuildInput", "Lorg/json/JSONObject;", ObricMemoryConstants.KEY_SESSION_ID, "reportBuildTerminal", "", "logger", "Lcom/obric/memorydata/middleware/api/logging/ModuleLogger;", "context", "Lcom/obric/memorydata/middleware/api/logging/LogContext;", "taskResult", "Lcom/obric/memorydata/task/impl/TaskResult;", "resultEntities", "extraMap", "fillResultStrFromOutput", "output", "", "parseResultEntities", "json", "removeRejectedMemories", SlardarSettingsConstants.SETTING_GENERAL_CLEANUP, "Lcom/obric/memorydata/memory/llm/RejectedMemoryCleanup;", "(Lcom/obric/memorydata/memory/llm/RejectedMemoryCleanup;Lcom/obric/memorydata/middleware/api/logging/ModuleLogger;Lcom/obric/memorydata/middleware/api/logging/LogContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "queryMemoryEntity", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "ResultEntityType", "ResultOperateType", "ResultEntity", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MemoryLLMBuildHelperV2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MemoryLLMBuildHelperV2 f10255a = null;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/memory/llm/MemoryLLMBuildHelperV2$ResultEntityType;", "", EventBody.KEY_VALUE, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "EPISODIC", "SEMANTIC", "AUDIO", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final enum ResultEntityType extends Enum<ResultEntityType> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ ResultEntityType[] $VALUES = null;
        public static final ResultEntityType AUDIO = null;
        public static final a Companion = null;
        public static final ResultEntityType EPISODIC = null;
        public static final ResultEntityType SEMANTIC = null;
        private final String value;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/memory/llm/MemoryLLMBuildHelperV2$ResultEntityType$Companion;", "", "<init>", "()V", "fromValue", "Lcom/obric/memorydata/memory/llm/MemoryLLMBuildHelperV2$ResultEntityType;", EventBody.KEY_VALUE, "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker r1) {
                this();
            }

            public final ResultEntityType a(String r5) {
                Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast(ResultEntityType.getEntries(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
            L4:
                if (r4.hasNext() == false) goto L8;
                Object r0 = r4.next();
                if (StringsKt.equals(((ResultEntityType) ZeusTransformUtils.preCheckCast(r0, ResultEntityType.class, "com.obric.memorydata.plugin")).getValue(), r5, true) == false) goto L4;
            L10:
                return (ResultEntityType) ZeusTransformUtils.preCheckCast(r0, ResultEntityType.class, "com.obric.memorydata.plugin");
            L8:
                r0 = null;
                goto L10
            }
        }

        private static final /* synthetic */ ResultEntityType[] $values() {
            return new ResultEntityType[]{EPISODIC, SEMANTIC, AUDIO};
        }

        static {
            EPISODIC = new ResultEntityType("EPISODIC", 0, "episodic");
            SEMANTIC = new ResultEntityType("SEMANTIC", 1, "semantic");
            AUDIO = new ResultEntityType("AUDIO", 2, "audio");
            ResultEntityType[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
            Companion = new a(null);
        }

        private ResultEntityType(String r1, int r2, String r3) {
            super(r1, r2);
            this.value = r3;
        }

        public static EnumEntries<ResultEntityType> getEntries() {
            return $ENTRIES;
        }

        public static ResultEntityType valueOf(String r2) {
            return (ResultEntityType) ZeusTransformUtils.preCheckCast(Enum.valueOf(ResultEntityType.class, r2), ResultEntityType.class, "com.obric.memorydata.plugin");
        }

        public static ResultEntityType[] values() {
            return (ResultEntityType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ResultEntityType[].class, "com.obric.memorydata.plugin");
        }

        public final String getValue() {
            return this.value;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/memory/llm/MemoryLLMBuildHelperV2$ResultOperateType;", "", EventBody.KEY_VALUE, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "INSERT", "UPDATE", "DELETE_CONFIRM", "UNKNOWN", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final enum ResultOperateType extends Enum<ResultOperateType> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ ResultOperateType[] $VALUES = null;
        public static final a Companion = null;
        public static final ResultOperateType DELETE_CONFIRM = null;
        public static final ResultOperateType INSERT = null;
        public static final ResultOperateType UNKNOWN = null;
        public static final ResultOperateType UPDATE = null;
        private final String value;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/memory/llm/MemoryLLMBuildHelperV2$ResultOperateType$Companion;", "", "<init>", "()V", "fromValue", "Lcom/obric/memorydata/memory/llm/MemoryLLMBuildHelperV2$ResultOperateType;", EventBody.KEY_VALUE, "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker r1) {
                this();
            }

            public final ResultOperateType a(String r5) {
                Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast(ResultOperateType.getEntries(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
            L4:
                if (r4.hasNext() == false) goto L8;
                Object r0 = r4.next();
                if (StringsKt.equals(((ResultOperateType) ZeusTransformUtils.preCheckCast(r0, ResultOperateType.class, "com.obric.memorydata.plugin")).getValue(), r5, true) == false) goto L4;
            L10:
                return (ResultOperateType) ZeusTransformUtils.preCheckCast(r0, ResultOperateType.class, "com.obric.memorydata.plugin");
            L8:
                r0 = null;
                goto L10
            }
        }

        private static final /* synthetic */ ResultOperateType[] $values() {
            return new ResultOperateType[]{INSERT, UPDATE, DELETE_CONFIRM, UNKNOWN};
        }

        static {
            INSERT = new ResultOperateType("INSERT", 0, "insert");
            UPDATE = new ResultOperateType("UPDATE", 1, BuildConfig.CHANNEL);
            DELETE_CONFIRM = new ResultOperateType("DELETE_CONFIRM", 2, "delete_confirm");
            UNKNOWN = new ResultOperateType("UNKNOWN", 3, "unknown");
            ResultOperateType[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
            Companion = new a(null);
        }

        private ResultOperateType(String r1, int r2, String r3) {
            super(r1, r2);
            this.value = r3;
        }

        public static EnumEntries<ResultOperateType> getEntries() {
            return $ENTRIES;
        }

        public static ResultOperateType valueOf(String r2) {
            return (ResultOperateType) ZeusTransformUtils.preCheckCast(Enum.valueOf(ResultOperateType.class, r2), ResultOperateType.class, "com.obric.memorydata.plugin");
        }

        public static ResultOperateType[] values() {
            return (ResultOperateType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ResultOperateType[].class, "com.obric.memorydata.plugin");
        }

        public final String getValue() {
            return this.value;
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J'\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/obric/memorydata/memory/llm/MemoryLLMBuildHelperV2$ResultEntity;", "", "entityId", "", "entityType", "Lcom/obric/memorydata/memory/llm/MemoryLLMBuildHelperV2$ResultEntityType;", "operateType", "Lcom/obric/memorydata/memory/llm/MemoryLLMBuildHelperV2$ResultOperateType;", "<init>", "(Ljava/lang/String;Lcom/obric/memorydata/memory/llm/MemoryLLMBuildHelperV2$ResultEntityType;Lcom/obric/memorydata/memory/llm/MemoryLLMBuildHelperV2$ResultOperateType;)V", "getEntityId", "()Ljava/lang/String;", "getEntityType", "()Lcom/obric/memorydata/memory/llm/MemoryLLMBuildHelperV2$ResultEntityType;", "getOperateType", "()Lcom/obric/memorydata/memory/llm/MemoryLLMBuildHelperV2$ResultOperateType;", "toMemoryEntity", "Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f10256a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ResultEntityType f10257b;
        private final ResultOperateType c;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.llm.MemoryLLMBuildHelperV2$a$a, reason: collision with other inner class name */
        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        public /* synthetic */ class C0504a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f10258a = null;

            static {
                int[] r0 = new int[ResultEntityType.values().length];
                r0[ResultEntityType.EPISODIC.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r0[ResultEntityType.SEMANTIC.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                f10258a = r0;
            }
        }

        public a(String r2, ResultEntityType r3, ResultOperateType r4) {
            Intrinsics.checkNotNullParameter(r2, "entityId");
            Intrinsics.checkNotNullParameter(r3, "entityType");
            Intrinsics.checkNotNullParameter(r4, "operateType");
            this.f10256a = r2;
            this.f10257b = r3;
            this.c = r4;
        }

        public final String a() {
            return this.f10256a;
        }

        public final ResultEntityType b() {
            return this.f10257b;
        }

        public final ResultOperateType c() {
            return this.c;
        }

        public final MemoryEntity d() {
            ResultEntityType r0 = this.f10257b;
            int r1 = C0504a.f10258a[r0.ordinal()];
            if (r1 == 1) goto L8;
            if (r1 == 2) goto L9;
            return null;
        L9:
            return com.obric.memorydata.memory.utils.f.f11537a.a(this.f10256a, Integer.valueOf(EntityType.MEMORY_INFO_COMMON));
        L8:
            return com.obric.memorydata.memory.utils.f.a(com.obric.memorydata.memory.utils.f.f11537a, this.f10256a, null, 2, null);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f10256a, r6.f10256a) == true) goto L12;
            return false;
        L12:
            if (this.f10257b == r6.f10257b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.f10256a.hashCode() * 31) + this.f10257b.hashCode()) * 31) + this.c.hashCode();
        }

        public String toString() {
            return "ResultEntity(entityId=" + this.f10256a + ", entityType=" + this.f10257b + ", operateType=" + this.c + ')';
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f10259a = null;

        static {
            int[] r0 = new int[ResultEntityType.values().length];
            r0[ResultEntityType.EPISODIC.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[ResultEntityType.SEMANTIC.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[ResultEntityType.AUDIO.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f10259a = r0;
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    static final class c implements Function1<com.obric.memorydata.middleware.api.logging.g, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.obric.memorydata.memory.llm.e f10260a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ MemoryEntity f10261b;
        final /* synthetic */ com.obric.memorydata.memory.memoryentity.f c;

        c(com.obric.memorydata.memory.llm.e r1, MemoryEntity r2, com.obric.memorydata.memory.memoryentity.f r3) {
            this.f10260a = r1;
            this.f10261b = r2;
            this.c = r3;
        }

        public final void a(com.obric.memorydata.middleware.api.logging.g r5) {
            Intrinsics.checkNotNullParameter(r5, "$this$mainTrace");
            r5.a("enable_stream", Boolean.valueOf(this.f10260a.n()));
            boolean r1 = true;
            if (this.f10261b == null) goto L5;
            boolean r0 = true;
        L6:
            r5.a("retry", Boolean.valueOf(r0));
            com.obric.memorydata.memory.memoryentity.f r4 = this.c;
            if (r4 == null) goto L9;
            com.obric.memorydata.memory.memoryentity.e r6 = r4.s();
        L10:
            if (r6 != null) goto L13;
            r1 = false;
        L13:
            r5.a("has_source_image", Boolean.valueOf(r1));
            return;
        L9:
            r6 = null;
            goto L10
        L5:
            r0 = false;
            goto L6
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ Unit invoke(com.obric.memorydata.middleware.api.logging.g r3) {
            a((com.obric.memorydata.middleware.api.logging.g) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.middleware.api.logging.g.class, "com.obric.memorydata.plugin"));
            return Unit.INSTANCE;
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    static final class d implements Function1<Throwable, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ o f10262a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.obric.memorydata.middleware.api.logging.e f10263b;
        final /* synthetic */ bx c;
        final /* synthetic */ com.obric.memorydata.memory.llm.c d;
        final /* synthetic */ String e;
        final /* synthetic */ com.obric.memorydata.memory.tracker.g.b f;
        final /* synthetic */ com.obric.memorydata.memory.llm.e g;
        final /* synthetic */ long h;

        d(o r3, com.obric.memorydata.middleware.api.logging.e r4, bx r5, com.obric.memorydata.memory.llm.c r6, String r7, com.obric.memorydata.memory.tracker.g.b r8, com.obric.memorydata.memory.llm.e r9, long r10) {
            bx r11 = (bx) ZeusTransformUtils.wrapperContextForParams(r5, bx.class, "com.obric.memorydata.plugin");
            this.f10262a = r3;
            this.f10263b = r4;
            this.c = r11;
            this.d = r6;
            this.e = r7;
            this.f = r8;
            this.g = r9;
            this.h = r10;
        }

        public final void a(Throwable r15) {
            o r0 = this.f10262a;
            com.obric.memorydata.middleware.api.logging.e r5 = this.f10263b;
            final String r7 = this.e;
            final com.obric.memorydata.memory.llm.e r8 = this.g;
            final bx r9 = this.c;
            final long r10 = this.h;
            o.a(r0, "记忆构建任务已取消", "build_cancelled", "task_cancelled", null, r5, (Function1) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r7, r8, r9, r10), Function1.class, "com.obric.memorydata.plugin"), 8, null);
            bx.a.a(this.c, null, 1, null);
            com.obric.memorydata.memory.llm.c r1 = this.d;
            if (r1 == null) goto L5;
            r1.d();
        L5:
            g.f10287a.b(this.e);
            k.a(k.f10296a, this.e, SessionStatus.FAILED, null, 4, null);
            com.obric.memorydata.memory.tracker.g.b r11 = this.f;
            if (r11 != null) goto L8;
            return;
        L8:
            if (ZeusTransformUtils.instanceOf(r15, TimeoutCancellationException.class) == false) goto L10;
            int r14 = NetError.ERR_CERT_DATE_INVALID;
        L11:
            int r12 = r14;
            if (ZeusTransformUtils.instanceOf(r15, TimeoutCancellationException.class) == false) goto L14;
            String r16 = "memory build result wait timed out";
        L15:
            com.obric.memorydata.memory.tracker.g.b.a(r11, r12, r16, null, 4, null);
            return;
        L14:
            r16 = "cancelled";
            goto L15
        L10:
            r14 = NetError.ERR_CERT_AUTHORITY_INVALID;
            goto L11
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ Unit invoke(Throwable r3) {
            a((Throwable) ZeusTransformUtils.preCheckCast(r3, Throwable.class, "com.obric.memorydata.plugin"));
            return Unit.INSTANCE;
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    static final class e implements Function1<a, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f10266a = null;

        static {
            f10266a = new e();
        }

        e() {
        }

        public final Boolean a(a r7) {
            Intrinsics.checkNotNullParameter(r7, "result");
            boolean r6 = false;
            AppEntity r8 = MemoryLLMBuildHelperV2.f10255a.a(r7);     // Catch: SQLException -> L14
            if (ZeusTransformUtils.instanceOf(r8, MemoryEntity.class) == false) goto L6;
            MemoryEntity r9 = (MemoryEntity) ZeusTransformUtils.preCheckCast(r8, MemoryEntity.class, "com.obric.memorydata.plugin");     // Catch: SQLException -> L14
        L7:
            MemoryEntity r1 = r9;
            if (r1 == null) goto L11;
            if (MemoryEntityManager.deleteDirectly$default(MemoryEntityManager.INSTANCE, r1, null, null, 4, null) == false) goto L13;
        L11:
            r6 = true;
            goto L13
        L6:
            r9 = null;
        L13:
            return Boolean.valueOf(r6);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ Boolean invoke(a r3) {
            return a((a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        f10255a = new MemoryLLMBuildHelperV2();
    }

    private MemoryLLMBuildHelperV2() {
    }

    public static final /* synthetic */ Object a(MemoryLLMBuildHelperV2 r2, i r3, o r4, com.obric.memorydata.middleware.api.logging.e r5, Continuation r6) {
        return r2.a(r3, r4, r5, (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ Object a(MemoryLLMBuildHelperV2 r8, com.obric.memorydata.memory.tracker.g.b r9, com.obric.memorydata.memory.llm.e r10, com.obric.memorydata.memory.memoryentity.f r11, com.obric.memorydata.dc.a r12, MemoryEntity r13, boolean r14, Continuation r15) {
        return r8.b(r9, r10, r11, r12, r13, r14, (Continuation) ZeusTransformUtils.wrapperContextForParams(r15, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static /* synthetic */ Object a(MemoryLLMBuildHelperV2 r9, com.obric.memorydata.memory.tracker.g.b r10, com.obric.memorydata.memory.llm.e r11, com.obric.memorydata.memory.memoryentity.f r12, com.obric.memorydata.dc.a r13, MemoryEntity r14, boolean r15, Continuation r16, int r17, Object r18) {
        Continuation<? super Pair<? extends List<a>, ? extends Map<String, ? extends Object>>> r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r16, Continuation.class, "com.obric.memorydata.plugin");
        if ((r17 & 16) == 0) goto L5;
        MemoryEntity r6 = null;
    L7:
        if ((r17 & 32) == 0) goto L9;
        boolean r7 = false;
    L11:
        return r9.a(r10, r11, r12, r13, r6, r7, r8);
    L9:
        r7 = r15;
        goto L11
    L5:
        r6 = r14;
        goto L7
    }

    private final Object a(i r12, o r13, com.obric.memorydata.middleware.api.logging.e r14, Continuation<? super Unit> r15) {
        Continuation r16 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r15, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r16, MemoryLLMBuildHelperV2$removeRejectedMemories$1.class) == false) goto L7;
        MemoryLLMBuildHelperV2$removeRejectedMemories$1 r0 = (MemoryLLMBuildHelperV2$removeRejectedMemories$1) ZeusTransformUtils.preCheckCast(r16, MemoryLLMBuildHelperV2$removeRejectedMemories$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        Object r17 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        r14 = (com.obric.memorydata.middleware.api.logging.e) ZeusTransformUtils.preCheckCast(r0.L$1, com.obric.memorydata.middleware.api.logging.e.class, "com.obric.memorydata.plugin");
        r13 = (o) ZeusTransformUtils.preCheckCast(r0.L$0, o.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r11);
    L17:
        o r3 = r13;
        final int r18 = ((Number) ZeusTransformUtils.preCheckCast(r11, Number.class, "com.obric.memorydata.plugin")).intValue();
        if (r18 <= 0) goto L20;
        o.a(r3, "安审拦截后的记忆清理失败", "rejected_memory_cleanup_failed", "delete_failed", null, r14, new $$Lambda$MemoryLLMBuildHelperV2$oPhm9ChXr51DQH8XOmyAgMkr_tU(r18), 8, null);
    L22:
        return Unit.INSTANCE;
    L20:
        o.a(r3, "安审拦截后的记忆已清理", "rejected_memory_cleanup_completed", r14, null, null, 24, null);
        goto L22
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r11);
        r0.L$0 = r13;
        r0.L$1 = r14;
        r0.label = 1;
        r11 = r12.a(r0);
        if (r11 != r17) goto L17;
        return r17;
    L7:
        r0 = new MemoryLLMBuildHelperV2$removeRejectedMemories$1(this, r16);
        goto L8
    }

    public static final /* synthetic */ List a(MemoryLLMBuildHelperV2 r0, JSONObject r1) {
        return r0.a(r1);
    }

    private final List<a> a(JSONObject r9) {
        JSONArray r8 = r9.optJSONArray("entityList");
        if (r8 == null) goto L5;
        List r10 = CollectionsKt.createListBuilder();
        int r0 = r8.length();
        int r2 = 0;
    L7:
        if (r2 >= r0) goto L25;
        JSONObject r3 = r8.optJSONObject(r2);
        if (r3 == null) goto L23;
        String r4 = r3.optString("entityId");
        ResultEntityType r5 = ResultEntityType.Companion.a(r3.optString("entityType"));
        if (r5 == null) goto L23;
        ResultOperateType r6 = ResultOperateType.Companion.a(r3.optString("operateType"));
        if (r6 != null) goto L17;
        r6 = ResultOperateType.UNKNOWN;
    L17:
        Intrinsics.checkNotNull(r4);
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L20;
        boolean r7 = true;
    L21:
        if (r7 == false) goto L23;
        r10.add(new a(r4, r5, r6));
        goto L23
    L20:
        r7 = false;
    L23:
        r2 = r2 + 1;
        goto L7
    L25:
        return CollectionsKt.build(r10);
    L5:
        return CollectionsKt.emptyList();
    }

    private static final Unit a(int r1, com.obric.memorydata.middleware.api.logging.g r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$errorTrace");
        r2.a("failed_count", Integer.valueOf(r1));
        return Unit.INSTANCE;
    }

    private static final Unit a(String r2, int r3, TaskResult r4, Map r5, com.obric.memorydata.middleware.api.logging.e r6, com.obric.memorydata.middleware.api.logging.g r7) {
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "<this>");
        r7.a("result_type", r2);
        r7.a("entity_count", Integer.valueOf(r3));
        Object r0 = null;
        if (r4.getCode() != 0) goto L16;
        JSONObject r9 = r4.getOutput().optJSONObject("result");
        if (r9 == null) goto L7;
        String r10 = r9.optString("answer");
    L8:
        CharSequence r11 = (CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin");
        if (r11 != null) goto L11;
    L14:
        boolean r12 = true;
    L15:
        Object r13 = Boolean.valueOf(!r12);
        String r14 = "has_answer";
    L17:
        r7.a(r14, r13);
        Object r15 = r8.get("logId");
        if (r15 != null) goto L20;
    L22:
        r7.a("algorithm_log_id", r0);
        if (Intrinsics.areEqual(r2, "call_user") == false) goto L26;
        r7.a("purpose", r8.get("resultSubType"));
    L26:
        return Unit.INSTANCE;
    L20:
        if (Intrinsics.areEqual(r15, r6.c()) == true) goto L22;
        r0 = r15;
        goto L22
    L11:
        if (r11.length() == 0) goto L14;
        r12 = false;
        goto L15
    L7:
        r10 = null;
        goto L8
    L16:
        r13 = Integer.valueOf(r4.getCode());
        r14 = "task_result_code";
        goto L17
    }

    private static final Unit a(List r2, Map r3, com.obric.memorydata.middleware.api.logging.g r4) {
        Object r5 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "$this$mainTrace");
        if (r5 != null) goto L5;
        r5 = "null";
    L5:
        r4.a("result_entities", r5);
        r4.a("extra_map", r6);
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ JSONObject a(MemoryLLMBuildHelperV2 r0, com.obric.memorydata.memory.llm.e r1, String r2) {
        return r0.a(r1, r2);
    }

    private final JSONObject a(com.obric.memorydata.memory.llm.e r5, String r6) {
        JSONObject r4 = new JSONObject();
        r4.put("appName", r5.d());
        r4.put(ChatMessage.TYPE_QUERY, r5.a());
        r4.put("imagePath", new JSONArray((Collection) ZeusTransformUtils.preCheckCast(CollectionsKt.listOf(r5.b()), Collection.class, "com.obric.memorydata.plugin")));
        r4.put("imageTosKey", new JSONArray((Collection) ZeusTransformUtils.preCheckCast(CollectionsKt.listOf(r5.i()), Collection.class, "com.obric.memorydata.plugin")));
        r4.put(IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, r5.c());
        r4.put("chatHistory", r5.g());
        r4.put(ObricMemoryConstants.KEY_SESSION_ID, r6);
        r4.put("logId", r5.l());
        r4.put("enableStream", r5.n());
        r4.put("currentTimeMillis", r5.o());
        r4.put("screenshotType", r5.j());
        r4.put("memoryProductType", r5.k());
        return r4;
    }

    public static final /* synthetic */ void a(MemoryLLMBuildHelperV2 r8, o r9, com.obric.memorydata.middleware.api.logging.e r10, TaskResult r11, List r12, Map r13) {
        r8.a(r9, r10, r11, (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin"), (Map) ZeusTransformUtils.wrapperContextForParams(r13, Map.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ void a(MemoryLLMBuildHelperV2 r2, JSONObject r3, Map r4) {
        r2.a(r3, (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin"));
    }

    private final void a(o r14, final com.obric.memorydata.middleware.api.logging.e r15, final TaskResult r16, List<a> r17, Map<String, ? extends Object> r18) {
        final List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r17, List.class, "com.obric.memorydata.plugin");
        final Map r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r18, Map.class, "com.obric.memorydata.plugin");
        if (r14 != null) goto L5;
        return;
    L5:
        Object r3 = r2.get("errorCode");
        String r5 = null;
        if (ZeusTransformUtils.instanceOf(r3, Integer.class) == false) goto L8;
        Integer r4 = (Integer) ZeusTransformUtils.preCheckCast(r3, Integer.class, "com.obric.memorydata.plugin");
    L9:
        boolean r9 = false;
        if (r4 == null) goto L12;
        int r10 = r4.intValue();
    L13:
        Object r6 = r2.get("resultType");
        if (ZeusTransformUtils.instanceOf(r6, String.class) == false) goto L16;
        r5 = (String) ZeusTransformUtils.preCheckCast(r6, String.class, "com.obric.memorydata.plugin");
    L16:
        if (r5 != null) goto L18;
        r5 = "unknown";
    L18:
        final String r11 = r5;
        if (r0 == null) goto L21;
        final int r7 = r0.size();
    L22:
        Function1<? super com.obric.memorydata.middleware.api.logging.g, Unit> r12 = new $$Lambda$MemoryLLMBuildHelperV2$fnAX2mp6CRkqp4nJvzgfPla9zFg(r11, r7, r16, r2, r15);
        if (r10 != (-7)) goto L25;
    L65:
        o.a(r14, "记忆构建内容未通过校验", "build_rejected", r15, r12, null, 16, null);
        return;
    L25:
        if (r10 == (-103)) goto L65;
        if (r10 == (-106)) goto L65;
        if (Intrinsics.areEqual(r11, "illegal") == true) goto L65;
        if (r16.getCode() != 0) goto L63;
        if (r10 != 0) goto L63;
        if (Intrinsics.areEqual(r11, "call_user") == false) goto L39;
        o.a(r14, "记忆构建等待用户确认", "build_waiting_user", r15, r12, null, 16, null);
        return;
    L39:
        if (r0 != null) goto L41;
        List r8 = CollectionsKt.emptyList();
    L42:
        Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r13, Collection.class) == true) goto L45;
    L47:
        Iterator r19 = r13.iterator();
    L49:
        if (r19.hasNext() == false) goto L59;
        a r20 = (a) ZeusTransformUtils.preCheckCast(r19.next(), a.class, "com.obric.memorydata.plugin");
        if (r20.c() != ResultOperateType.INSERT) goto L53;
    L56:
        boolean r21 = true;
    L57:
        if (r21 == false) goto L49;
        r9 = true;
        goto L59
    L53:
        if (r20.c() == ResultOperateType.UPDATE) goto L56;
        r21 = false;
    L59:
        if (r9 == false) goto L61;
        r14.a("记忆构建完成", "build_success", r15, r12, new $$Lambda$MemoryLLMBuildHelperV2$Yk_bnJA9F5UHxqdGpp18vssC6NM(r0, r2));
        return;
    L61:
        o.a(r14, "记忆构建未产生有效记忆", "build_failed", "no_memory_output", null, r15, r12, 8, null);
        return;
    L45:
        if (((Collection) ZeusTransformUtils.preCheckCast(r13, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L47;
    L41:
        r8 = r0;
    L63:
        o.a(r14, "记忆构建失败", "build_failed", String.valueOf(r10), null, r15, r12, 8, null);
        return;
    L21:
        r7 = 0;
        goto L22
    L12:
        r10 = 0;
        goto L13
    L8:
        r4 = null;
        goto L9
    }

    private final void a(JSONObject r7, Map<String, Object> r8) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.memorydata.plugin");
        JSONObject r9 = r7.optJSONObject("result");
        if (r9 != null) goto L5;
        return;
    L5:
        String r1 = r9.optString("resultStrAssistant");
        String r2 = "";
        if (r1 != null) goto L8;
        r1 = "";
    L8:
        String r10 = r9.optString("resultStrMemory");
        if (r10 == null) goto L12;
        r2 = r10;
    L12:
        boolean r4 = true;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L15;
        boolean r11 = true;
    L16:
        if (r11 == false) goto L19;
        r6.put("resultStrAssistant", r1);
    L19:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin")).length() > 0) goto L22;
        r4 = false;
    L22:
        if (r4 == false) goto L25;
        r6.put("resultStrMemory", r2);
        return;
    L25:
        return;
    L15:
        r11 = false;
        goto L16
    }

    private final Object b(com.obric.memorydata.memory.tracker.g.b r33, com.obric.memorydata.memory.llm.e r34, com.obric.memorydata.memory.memoryentity.f r35, com.obric.memorydata.dc.a r36, MemoryEntity r37, boolean r38, Continuation<? super Pair<? extends List<a>, ? extends Map<String, ? extends Object>>> r39) {
        Continuation r2 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r39, Continuation.class, "com.obric.memorydata.plugin");
        if (r35 == null) goto L6;
        int r5 = r35.a();
    L5:
        Integer r6 = Boxing.boxInt(r5);
    L9:
        o r7 = com.obric.memorydata.memory.llm.b.a(r6);
        com.obric.memorydata.middleware.api.logging.e r22 = com.obric.memorydata.middleware.api.logging.e.a(r34.m(), r7.a(), null, "build", 2, null);
        String r15 = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(r15, "toString(...)");
        if (r37 != null) goto L16;
        if (r35 != null) goto L16;
        Throwable r10 = null;
        Function1 r12 = null;
        int r13 = 40;
        Object r14 = null;
        String r8 = "记忆构建来源缺失";
        String r9 = "build_failed";
        String r11 = "memory_source_missing";
    L13:
        o.a(r7, r8, r9, r11, r10, r22, r12, r13, r14);
        return TuplesKt.to(null, MapsKt.emptyMap());
    L16:
        if (NetworkUtils.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) == true) goto L18;
        r10 = null;
        r12 = null;
        r13 = 40;
        r14 = null;
        r8 = "记忆构建因网络不可用而失败";
        r9 = "build_failed";
        r11 = "network_unavailable";
        goto L13
    L18:
        Map r16 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        if (r35 == null) goto L21;
        com.obric.memorydata.memory.llm.c r17 = r35.q();
    L22:
        if (r17 == null) goto L24;
        r17.a(r15);
    L24:
        kotlinx.coroutines.o r18 = new kotlinx.coroutines.o(IntrinsicsKt.intercepted(r2), 1);
        r18.e();
        n r19 = (n) ZeusTransformUtils.preCheckCast(r18, n.class, "com.obric.memorydata.plugin");
        long r23 = SystemClock.elapsedRealtime();
        Ref.ObjectRef r110 = new Ref.ObjectRef();
        Ref.BooleanRef r111 = new Ref.BooleanRef();
        i r112 = new i((Function1) ZeusTransformUtils.preCheckCast(e.f10266a, Function1.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new MemoryLLMBuildHelperV2$execute$2$rejectedMemoryCleanup$2(f.f10283a), Function2.class, "com.obric.memorydata.plugin"));
        if (r35 == null) goto L27;
        g.f10287a.a(r15, r35);
        h.f10289a.a(r15, r36, r35.b());
    L27:
        al r25 = am.a(ba.c().plus((CoroutineContext) ZeusTransformUtils.preCheckCast(ca.a(null, 1, null), CoroutineContext.class, "com.obric.memorydata.plugin")));
        com.obric.memorydata.memory.llm.c r4 = r17;
        o.a(r7, "记忆构建Task准备启动", "task_start", r22, (Function1) ZeusTransformUtils.preCheckCast(new c(r34, r37, r35), Function1.class, "com.obric.memorydata.plugin"), null, 16, null);
        r19.a((Function1) ZeusTransformUtils.preCheckCast(new d(r7, r22, kotlinx.coroutines.i.a(r25, null, null, (Function2) ZeusTransformUtils.preCheckCast(new MemoryLLMBuildHelperV2$execute$2$taskJob$1(r34, r15, r22, r7, r110, r16, r38, r112, r111, r33, r19, r4, r23, null), Function2.class, "com.obric.memorydata.plugin"), 3, null), r4, r15, r33, r34, r23), Function1.class, "com.obric.memorydata.plugin"));
        Object r0 = r18.h();
        if (r0 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L30;
        DebugProbesKt.probeCoroutineSuspended(r2);
    L30:
        return r0;
    L21:
        r17 = null;
        goto L22
    L6:
        if (r37 == null) goto L8;
        r5 = r37.getProductType();
        goto L5
    L8:
        r6 = null;
        goto L9
    }

    public static /* synthetic */ Unit lambda$Yk_bnJA9F5UHxqdGpp18vssC6NM(List r0, Map r1, com.obric.memorydata.middleware.api.logging.g r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ Unit lambda$fnAX2mp6CRkqp4nJvzgfPla9zFg(String r0, int r1, TaskResult r2, Map r3, com.obric.memorydata.middleware.api.logging.e r4, com.obric.memorydata.middleware.api.logging.g r5) {
        return a(r0, r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ Unit lambda$oPhm9ChXr51DQH8XOmyAgMkr_tU(int r0, com.obric.memorydata.middleware.api.logging.g r1) {
        return a(r0, r1);
    }

    public final AppEntity a(a r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        ResultEntityType r2 = r3.b();
        int r4 = b.f10259a[r2.ordinal()];
        if (r4 != 1) goto L5;
        EpisodicMemoryEntity r5 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getEpisodicMemoryDao().queryByEntityId(r3.a());
        if (r5 != null) goto L19;
        return null;
    L19:
        return r5.convertToAppEntity();
    L5:
        if (r4 != 2) goto L7;
        ip r6 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getSemanticMemoryDao().queryByEntityId(r3.a());
        if (r6 != null) goto L23;
        return null;
    L23:
        return r6.convertToAppEntity();
    L7:
        if (r4 != 3) goto L12;
        fj r7 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getAuditoryRecordingRawDbDao().queryByEntityId(r3.a());
        if (r7 != null) goto L21;
        return null;
    L21:
        return r7.convertToAppEntity();
    L12:
        throw new NoWhenBranchMatchedException();
    }

    public final Object a(com.obric.memorydata.memory.tracker.g.b r17, com.obric.memorydata.memory.llm.e r18, com.obric.memorydata.memory.memoryentity.f r19, com.obric.memorydata.dc.a r20, MemoryEntity r21, boolean r22, Continuation<? super Pair<? extends List<a>, ? extends Map<String, ? extends Object>>> r23) {
        Continuation r0 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r23, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r0, MemoryLLMBuildHelperV2$executeMemoryBuildByLLM$1.class) == false) goto L7;
        MemoryLLMBuildHelperV2$executeMemoryBuildByLLM$1 r2 = (MemoryLLMBuildHelperV2$executeMemoryBuildByLLM$1) ZeusTransformUtils.preCheckCast(r0, MemoryLLMBuildHelperV2$executeMemoryBuildByLLM$1.class, "com.obric.memorydata.plugin");
        if ((r2.label & Integer.MIN_VALUE) == 0) goto L7;
        r2.label -= Integer.MIN_VALUE;
    L8:
        Object r1 = r2.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r2.label;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        ResultKt.throwOnFailure(r1);
    L17:
        Pair r5 = (Pair) ZeusTransformUtils.preCheckCast(r1, Pair.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L20;
        return r5;
    L20:
        return TuplesKt.to(null, MapsKt.mapOf(new Pair[]{TuplesKt.to("errorCode", Boxing.boxInt(NetError.ERR_CERT_DATE_INVALID)), TuplesKt.to(DTraitConstant.ERROR, "memory build result wait timed out"), TuplesKt.to("resultStrMemory", at.a(ZeusTransformUtils.mapRes(R.string.memory_card_memory_large_model_failed_title, TypedValues.Custom.S_STRING, "memory_card_memory_large_model_failed_title")))}));
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r1);
        Function2 r6 = (Function2) ZeusTransformUtils.preCheckCast(new MemoryLLMBuildHelperV2$executeMemoryBuildByLLM$2(r17, r18, r19, r20, r21, r22, null), Function2.class, "com.obric.memorydata.plugin");
        r2.label = 1;
        r1 = da.b(30000, r6, r2);
        if (r1 != r3) goto L17;
        return r3;
    L7:
        r2 = new MemoryLLMBuildHelperV2$executeMemoryBuildByLLM$1(this, r0);
        goto L8
    }
}
