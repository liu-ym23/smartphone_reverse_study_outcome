package com.obric.memorydata.memory.intent;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Parcelable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.intent.BaseMemoryOperateIntent;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.common.intent.MemoryOperateParams;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.AuditoryRecordingEntity;
import com.obric.capabilitykit.entity.app.ProactiveMemoryEntity;
import com.obric.capabilitykit.entity.memory.CommonTextMemoryEntity;
import com.obric.capabilitykit.entity.memory.InfoCommonMemoryEntity;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.obric.memorydata.constants.AppInfo;
import com.obric.memorydata.database.entity.EpisodicMemoryEntity;
import com.obric.memorydata.database.entity.fj;
import com.obric.memorydata.database.entity.ip;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.memory.e.b;
import com.obric.memorydata.memory.llm.MemoryLLMBuildHelperV2;
import com.obric.memorydata.memory.memoryentity.f;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.logging.e;
import com.obric.memorydata.middleware.api.logging.g;
import com.obric.memorydata.middleware.api.logging.o;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.utils.GsonUtil;
import com.obric.memorydata.utils.at;
import com.obric.memorydata.utils.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.da;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated(message = "OperateMemoryIntent 已废弃，目前使用的是 OperateMemoryNewIntent")
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0003-./B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J*\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0096@¢\u0006\u0002\u0010\u000eJ&\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\t0\u0015H\u0002J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0018H\u0002J\u0018\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u0018H\u0002J?\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00072\u0006\u0010\u001f\u001a\u00020 2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0018H\u0002¢\u0006\u0002\u0010\"J\u001c\u0010#\u001a\b\u0012\u0004\u0012\u00020\t0\u00152\f\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u0015H\u0002J\"\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\t0'2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u0015H\u0002J\"\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\t0'2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u0015H\u0002J\"\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\t0'2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u0015H\u0002J\u0012\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u0018H\u0002¨\u00060"}, d2 = {"Lcom/obric/memorydata/memory/intent/OperateMemoryIntent;", "Lcom/obric/capabilitykit/common/intent/BaseMemoryOperateIntent;", "<init>", "()V", "isBlock", "", "doAction", "Lcom/obric/capabilitykit/common/intent/IntentResult;", "", "Lcom/obric/capabilitykit/entity/app/AppEntity;", TrackerImpl.PARAMS, "Lcom/obric/capabilitykit/common/intent/MemoryOperateParams;", "dispatchContext", "Lcom/obric/capabilitykit/common/DispatchContext;", "(Lcom/obric/capabilitykit/common/intent/MemoryOperateParams;Lcom/obric/capabilitykit/common/DispatchContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processIntent", "parsedContext", "Lcom/obric/memorydata/memory/intent/OperateMemoryIntent$OperateMemoryContext;", "logContext", "Lcom/obric/memorydata/middleware/api/logging/LogContext;", "simplifyMemoryEntities", "", "entities", "buildDetailsJson", "", "result", "answer", "buildDetailsResult", "resultType", "subType", "buildIntentResult", "ret", "", "entity", "(I[Lcom/obric/capabilitykit/entity/app/AppEntity;Ljava/lang/String;Ljava/lang/String;)Lcom/obric/capabilitykit/common/intent/IntentResult;", "queryMemoryEntities", "resultEntities", "Lcom/obric/memorydata/memory/llm/MemoryLLMBuildHelperV2$ResultEntity;", "queryEpisodicEntities", "", "querySemanticEntities", "queryAuditoryEntities", "parseContext", "Lcom/obric/memorydata/memory/intent/OperateMemoryIntent$ContextParseResult;", "context", "OperateMemoryDetails", "OperateMemoryContext", "ContextParseResult", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class OperateMemoryIntent extends BaseMemoryOperateIntent {

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003JQ\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/obric/memorydata/memory/intent/OperateMemoryIntent$OperateMemoryContext;", "", "screenshot", "", "rawChatHistory", "chatHistory", "appName", ObricMemoryConstants.KEY_PACKAGE_NAME, "logId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getScreenshot", "()Ljava/lang/String;", "getRawChatHistory", "getChatHistory", "getAppName", "getPackageName", "getLogId", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class OperateMemoryContext {
        private final String appName;
        private final String chatHistory;
        private final String logId;
        private final String packageName;
        private final String rawChatHistory;
        private final String screenshot;

        public OperateMemoryContext() {
            this(null, null, null, null, null, null, 63, null);
        }

        public OperateMemoryContext(String r1, String r2, String r3, String r4, String r5, String r6) {
            this.screenshot = r1;
            this.rawChatHistory = r2;
            this.chatHistory = r3;
            this.appName = r4;
            this.packageName = r5;
            this.logId = r6;
        }

        public /* synthetic */ OperateMemoryContext(String r2, String r3, String r4, String r5, String r6, String r7, int r8, DefaultConstructorMarker r9) {
            if ((r8 & 1) == 0) goto L6;
            r2 = null;
        L6:
            if ((r8 & 2) == 0) goto L9;
            r3 = null;
        L9:
            if ((r8 & 4) == 0) goto L12;
            r4 = null;
        L12:
            if ((r8 & 8) == 0) goto L15;
            r5 = null;
        L15:
            if ((r8 & 16) == 0) goto L18;
            r6 = null;
        L18:
            if ((r8 & 32) == 0) goto L20;
            r7 = null;
        L20:
            this(r2, r3, r4, r5, r6, r7);
        }

        public static /* synthetic */ OperateMemoryContext copy$default(OperateMemoryContext r4, String r5, String r6, String r7, String r8, String r9, String r10, int r11, Object r12) {
            if ((r11 & 1) == 0) goto L6;
            r5 = r4.screenshot;
        L6:
            if ((r11 & 2) == 0) goto L8;
            r6 = r4.rawChatHistory;
        L8:
            String r13 = r6;
            if ((r11 & 4) == 0) goto L11;
            r7 = r4.chatHistory;
        L11:
            String r0 = r7;
            if ((r11 & 8) == 0) goto L14;
            r8 = r4.appName;
        L14:
            String r1 = r8;
            if ((r11 & 16) == 0) goto L17;
            r9 = r4.packageName;
        L17:
            String r2 = r9;
            if ((r11 & 32) == 0) goto L20;
            r10 = r4.logId;
        L20:
            String r14 = r5;
            return r4.copy(r14, r13, r0, r1, r2, r10);
        }

        public final String component1() {
            return this.screenshot;
        }

        public final String component2() {
            return this.rawChatHistory;
        }

        public final String component3() {
            return this.chatHistory;
        }

        public final String component4() {
            return this.appName;
        }

        public final String component5() {
            return this.packageName;
        }

        public final String component6() {
            return this.logId;
        }

        public final OperateMemoryContext copy(String r8, String r9, String r10, String r11, String r12, String r13) {
            return new OperateMemoryContext(r8, r9, r10, r11, r12, r13);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, OperateMemoryContext.class) == true) goto L8;
            return false;
        L8:
            OperateMemoryContext r6 = (OperateMemoryContext) ZeusTransformUtils.preCheckCast(r5, OperateMemoryContext.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.screenshot, r6.screenshot) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.rawChatHistory, r6.rawChatHistory) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.chatHistory, r6.chatHistory) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.appName, r6.appName) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.packageName, r6.packageName) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.logId, r6.logId) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final String getAppName() {
            return this.appName;
        }

        public final String getChatHistory() {
            return this.chatHistory;
        }

        public final String getLogId() {
            return this.logId;
        }

        public final String getPackageName() {
            return this.packageName;
        }

        public final String getRawChatHistory() {
            return this.rawChatHistory;
        }

        public final String getScreenshot() {
            return this.screenshot;
        }

        public int hashCode() {
            String r0 = this.screenshot;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            String r4 = this.rawChatHistory;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            String r7 = this.chatHistory;
            if (r7 != null) goto L13;
            int r8 = 0;
        L14:
            int r9 = (r6 + r8) * 31;
            String r10 = this.appName;
            if (r10 != null) goto L17;
            int r11 = 0;
        L18:
            int r12 = (r9 + r11) * 31;
            String r13 = this.packageName;
            if (r13 != null) goto L21;
            int r14 = 0;
        L22:
            int r15 = (r12 + r14) * 31;
            String r16 = this.logId;
            if (r16 == null) goto L27;
            r1 = r16.hashCode();
        L27:
            return r15 + r1;
        L21:
            r14 = r13.hashCode();
            goto L22
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
            return "OperateMemoryContext(screenshot=" + this.screenshot + ", rawChatHistory=" + this.rawChatHistory + ", chatHistory=" + this.chatHistory + ", appName=" + this.appName + ", packageName=" + this.packageName + ", logId=" + this.logId + ')';
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/obric/memorydata/memory/intent/OperateMemoryIntent$OperateMemoryDetails;", "", "result", "", "answer", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getResult", "()Ljava/lang/String;", "getAnswer", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class OperateMemoryDetails {
        private final String answer;
        private final String result;

        public OperateMemoryDetails(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "result");
            Intrinsics.checkNotNullParameter(r3, "answer");
            this.result = r2;
            this.answer = r3;
        }

        public static /* synthetic */ OperateMemoryDetails copy$default(OperateMemoryDetails r0, String r1, String r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.result;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.answer;
        L9:
            return r0.copy(r1, r2);
        }

        public final String component1() {
            return this.result;
        }

        public final String component2() {
            return this.answer;
        }

        public final OperateMemoryDetails copy(String r1, String r2) {
            Intrinsics.checkNotNullParameter(r1, "result");
            Intrinsics.checkNotNullParameter(r2, "answer");
            return new OperateMemoryDetails(r1, r2);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, OperateMemoryDetails.class) == true) goto L8;
            return false;
        L8:
            OperateMemoryDetails r6 = (OperateMemoryDetails) ZeusTransformUtils.preCheckCast(r5, OperateMemoryDetails.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.result, r6.result) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.answer, r6.answer) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final String getAnswer() {
            return this.answer;
        }

        public final String getResult() {
            return this.result;
        }

        public int hashCode() {
            return (this.result.hashCode() * 31) + this.answer.hashCode();
        }

        public String toString() {
            return "OperateMemoryDetails(result=" + this.result + ", answer=" + this.answer + ')';
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001d\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/memory/intent/OperateMemoryIntent$ContextParseResult;", "", "context", "Lcom/obric/memorydata/memory/intent/OperateMemoryIntent$OperateMemoryContext;", "error", "", "<init>", "(Lcom/obric/memorydata/memory/intent/OperateMemoryIntent$OperateMemoryContext;Ljava/lang/Throwable;)V", "getContext", "()Lcom/obric/memorydata/memory/intent/OperateMemoryIntent$OperateMemoryContext;", "getError", "()Ljava/lang/Throwable;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final OperateMemoryContext f10181a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Throwable f10182b;

        public a(OperateMemoryContext r1, Throwable r2) {
            this.f10181a = r1;
            this.f10182b = r2;
        }

        public /* synthetic */ a(OperateMemoryContext r1, Throwable r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = null;
        L5:
            this(r1, r2);
        }

        public final Throwable a() {
            return this.f10182b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f10181a, r6.f10181a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f10182b, r6.f10182b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final OperateMemoryContext getContext() {
            return this.f10181a;
        }

        public int hashCode() {
            OperateMemoryContext r0 = this.f10181a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            Throwable r4 = this.f10182b;
            if (r4 == null) goto L11;
            r1 = r4.hashCode();
        L11:
            return r3 + r1;
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public String toString() {
            return "ContextParseResult(context=" + this.f10181a + ", error=" + this.f10182b + ')';
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.intent.OperateMemoryIntent$doAction$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.intent.OperateMemoryIntent", f = "OperateMemoryIntent.kt", i = {0, 0, 0}, l = {107}, m = "doAction", n = {"this", "parsedContext", "logContext"}, s = {"L$0", "L$1", "L$2"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ OperateMemoryIntent this$0;

        AnonymousClass1(OperateMemoryIntent r3, Continuation<? super AnonymousClass1> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.doAction(null, null, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
        }
    }

    public OperateMemoryIntent() {
    }

    private final String buildDetailsJson(String r2, String r3) {
        return GsonUtil.INSTANCE.toJson(new OperateMemoryDetails(r2, r3));
    }

    private final String buildDetailsResult(String r2, String r3) {
        if (Intrinsics.areEqual(r2, "call_user") == true) goto L5;
    L8:
        return r2;
    L5:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L8;
        return r2 + '_' + r3;
    }

    private final IntentResult<AppEntity[]> buildIntentResult(int r15, AppEntity[] r16, String r17, String r18) {
        return new IntentResult(r15, r16, null, buildDetailsJson(r17, r18), false, false, 0, null, null, null, 1012, null);
    }

    private static final Unit doAction$lambda$2(Boolean r1, g r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$errorTrace");
        Object r3 = r1;
        if (r1 != null) goto L5;
        r3 = LocationMonitorConst.TIMEOUT;
    L5:
        r2.a("agree_result", r3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: lambda$4rxADaW8z5RXH-h1uxBMdrf76IU, reason: not valid java name */
    public static /* synthetic */ Unit m712lambda$4rxADaW8z5RXHh1uxBMdrf76IU(Ref.ObjectRef r0, boolean r1, boolean r2, Ref.ObjectRef r3, OperateMemoryContext r4, g r5) {
        return processIntent$lambda$3(r0, r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ Unit lambda$UHHPJ_WqnskpW1wNmkHytjmkhds(Boolean r0, g r1) {
        return doAction$lambda$2(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$g-NOCMq23B3GE5HgrxBMMV1l98Y, reason: not valid java name */
    public static /* synthetic */ Unit m713lambda$gNOCMq23B3GE5HgrxBMMV1l98Y(String r0, List r1, List r2, Map r3, IntentResult r4, g r5) {
        return processIntent$lambda$6(r0, r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ Unit lambda$q58MhJaqgU5iLGpb39OVf8oXSwk(IntentResult r0, Ref.ObjectRef r1, String r2, AppEntity[] r3, String r4, List r5, g r6) {
        return processIntent$lambda$5(r0, r1, r2, r3, r4, r5, r6);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final a parseContext(String r10) {
        CharSequence r9 = (CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin");
        if (r9 != null) goto L5;
    L8:
        boolean r11 = true;
    L9:
        int r1 = 2;
        OperateMemoryContext r2 = null;
        Object[] r3 = 0;
        Object[] r4 = 0;
        Object[] r5 = 0;
        Object[] r6 = 0;
        if (r11 == true) goto L12;
    L20:
        th = move-exception;
        return new a(null, th);
    L23:
        Object r12 = GsonUtil.INSTANCE.getGSON().fromJson(r10, OperateMemoryContext.class);     // Catch: Exception -> L16 Throwable -> L20
    L18:
        return new a((OperateMemoryContext) ZeusTransformUtils.preCheckCast(r12, OperateMemoryContext.class, "com.obric.memorydata.plugin"), r4 == true ? 1 : 0, r1, r3 == true ? 1 : 0);
    L16:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), GsonUtil.TAG, "json error ：" + e, null, 4, null);     // Catch: Throwable -> L20
        r12 = null;
        goto L18
    L12:
        return new a(r2, r6 == true ? 1 : 0, r1, r5 == true ? 1 : 0);
    L5:
        if (StringsKt.isBlank(r9) == true) goto L8;
        r11 = false;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v12, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v25, types: [T, android.graphics.Bitmap] */
    private final IntentResult<AppEntity[]> processIntent(final OperateMemoryContext r42, e r43) {
        final boolean r3 = com.obric.memorydata.utils.g.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        final boolean r4 = com.obric.memorydata.sdk.server.assistant.a.f12858a.b();
        com.obric.memorydata.sdk.server.assistant.a.f12858a.c();
        final Ref.ObjectRef r8 = new Ref.ObjectRef();
        String r9 = null;
        if (r42 == null) goto L5;
        T r1 = r42.getPackageName();
    L6:
        r8.element = r1;
        if (r42 == null) goto L9;
        String r2 = r42.getAppName();
    L10:
        final Ref.ObjectRef r10 = new Ref.ObjectRef();
        CharSequence r5 = (CharSequence) ZeusTransformUtils.preCheckCast(r8.element, CharSequence.class, "com.obric.memorydata.plugin");
        boolean r11 = true;
        if (r5 != null) goto L13;
    L16:
        boolean r6 = true;
    L17:
        if (r6 == true) goto L37;
        CharSequence r7 = (CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L21;
    L24:
        boolean r12 = true;
    L25:
        if (r12 == true) goto L37;
        if (at.a(r42.getScreenshot()) == true) goto L33;
        if (r3 == true) goto L35;
        if (r4 == false) goto L35;
        if (Intrinsics.areEqual(r8.element, AppInfo.Launcher.getPackageName()) == false) goto L33;
    L35:
        if (Intrinsics.areEqual(r8.element, AppInfo.AppletApp.getPackageName()) == false) goto L38;
        r2 = c.f13193a.a((String) ZeusTransformUtils.preCheckCast(r8.element, String.class, "com.obric.memorydata.plugin"), r2);
    L38:
        String r16 = r2;
        o.a((o) ZeusTransformUtils.preCheckCast(com.obric.memorydata.middleware.api.logging.a.f11610a, o.class, "com.obric.memorydata.plugin"), "助手主动记忆 processIntent", "route_selected", e.a(r43, null, null, "route", 3, null), new $$Lambda$OperateMemoryIntent$4rxADaW8z5RXHh1uxBMdrf76IU(r8, r3, r4, r10, r42), null, 16, null);
        String r15 = (String) ZeusTransformUtils.preCheckCast(r8.element, String.class, "com.obric.memorydata.plugin");
        Bitmap r17 = (Bitmap) ZeusTransformUtils.preCheckCast(r10.element, Bitmap.class, "com.obric.memorydata.plugin");
        if (r42 == null) goto L41;
        String r24 = r42.getChatHistory();
    L43:
        if (r42 == null) goto L45;
        String r27 = r42.getRawChatHistory();
    L46:
        if (r42 == null) goto L48;
        String r28 = r42.getScreenshot();
    L49:
        if (r42 == null) goto L51;
        String r29 = r42.getLogId();
    L52:
        Pair r13 = com.obric.memorydata.memory.e.a.b.a(com.obric.memorydata.memory.e.a.f10116b.a(0), (b) ZeusTransformUtils.preCheckCast(new com.obric.memorydata.memory.tracker.g.b(3, false, com.obric.memorydata.memory.tracker.e.f10540a.a()), b.class, "com.obric.memorydata.plugin"), new f(3, r15, r16, r17, null, null, null, null, null, false, r24, null, null, r27, r28, r29, r43, false, null, null, null, null, 0.0f, 0, 16653056, null), false, 4, null);
        final List<MemoryLLMBuildHelperV2.a> r14 = (List) ZeusTransformUtils.preCheckCast(r13.component1(), List.class, "com.obric.memorydata.plugin");
        final Map r18 = (Map) ZeusTransformUtils.preCheckCast(r13.component2(), Map.class, "com.obric.memorydata.plugin");
        final Ref.ObjectRef r19 = new Ref.ObjectRef();
        Object r20 = r18.get("resultType");
        if (ZeusTransformUtils.instanceOf(r20, String.class) == false) goto L55;
        String r21 = (String) ZeusTransformUtils.preCheckCast(r20, String.class, "com.obric.memorydata.plugin");
    L56:
        String r22 = CommonConsts.LOG_REPORT_TYPE_EXCEPTION;
        T r23 = r21;
        if (r21 != null) goto L59;
        r23 = CommonConsts.LOG_REPORT_TYPE_EXCEPTION;
    L59:
        r19.element = r23;
        Object r25 = r18.get("resultSubType");
        if (ZeusTransformUtils.instanceOf(r25, String.class) == false) goto L62;
        String r26 = (String) ZeusTransformUtils.preCheckCast(r25, String.class, "com.obric.memorydata.plugin");
    L63:
        String r30 = "";
        if (r26 != null) goto L67;
        r26 = "";
    L67:
        if (Intrinsics.areEqual(r19.element, CommonConsts.LOG_REPORT_TYPE_EXCEPTION) == false) goto L82;
        Object r31 = r18.get("resultStrAssistant");
        if (ZeusTransformUtils.instanceOf(r31, String.class) == false) goto L71;
        String r32 = (String) ZeusTransformUtils.preCheckCast(r31, String.class, "com.obric.memorydata.plugin");
    L72:
        CharSequence r33 = (CharSequence) ZeusTransformUtils.preCheckCast(r32, CharSequence.class, "com.obric.memorydata.plugin");
        if (r33 != null) goto L75;
    L78:
        if (r11 == true) goto L80;
        r9 = r32;
    L80:
        if (r9 != null) goto L87;
        r30 = at.a(ZeusTransformUtils.mapRes(R.string.memory_build_exception_text, TypedValues.Custom.S_STRING, "memory_build_exception_text"));
    L88:
        T r34 = r22;
        if (Intrinsics.areEqual(r19.element, "success") == true) goto L92;
        r34 = (String) ZeusTransformUtils.preCheckCast(r19.element, String.class, "com.obric.memorydata.plugin");
    L92:
        r19.element = r34;
        if (r14 != null) goto L95;
        List<MemoryLLMBuildHelperV2.a> r35 = CollectionsKt.emptyList();
    L96:
        final List<AppEntity> r36 = queryMemoryEntities(r35);
        final AppEntity[] r37 = (AppEntity[]) ZeusTransformUtils.preCheckCast(((Collection) ZeusTransformUtils.preCheckCast(simplifyMemoryEntities(r36), Collection.class, "com.obric.memorydata.plugin")).toArray(new AppEntity[0]), AppEntity[].class, "com.obric.memorydata.plugin");
        final IntentResult<AppEntity[]> r0 = buildIntentResult(0, r37, buildDetailsResult((String) ZeusTransformUtils.preCheckCast(r19.element, String.class, "com.obric.memorydata.plugin"), r26), r30);
        final String r110 = r26;
        final String r111 = r30;
        final String r112 = r30;
        com.obric.memorydata.middleware.api.logging.a.f11610a.a("助手主动记忆结果已返回", "intent_result_returned", e.a(r43, null, null, "result", 3, null), new $$Lambda$OperateMemoryIntent$q58MhJaqgU5iLGpb39OVf8oXSwk(r0, r19, r110, r37, r111, r14), new $$Lambda$OperateMemoryIntent$gNOCMq23B3GE5HgrxBMMV1l98Y(r112, r14, r36, r18, r0));
        return r0;
    L95:
        r35 = r14;
    L87:
        r30 = r9;
        goto L88
    L75:
        if (r33.length() == 0) goto L78;
        r11 = false;
        goto L78
    L71:
        r32 = null;
        goto L72
    L82:
        Object r38 = r18.get("answer");
        if (ZeusTransformUtils.instanceOf(r38, String.class) == false) goto L85;
        r9 = (String) ZeusTransformUtils.preCheckCast(r38, String.class, "com.obric.memorydata.plugin");
    L85:
        if (r9 != null) goto L87;
    L62:
        r26 = null;
        goto L63
    L55:
        r21 = null;
        goto L56
    L51:
        r29 = null;
        goto L52
    L48:
        r28 = null;
        goto L49
    L45:
        r27 = null;
        goto L46
    L41:
        r24 = null;
    L33:
        r10.element = com.obric.memorydata.utils.e.c.a(com.obric.memorydata.utils.e.c.f13216a, (String) ZeusTransformUtils.preCheckCast(r8.element, String.class, "com.obric.memorydata.plugin"), null, 2, null);
        goto L35
    L21:
        if (r7.length() == 0) goto L24;
        r12 = false;
    L37:
        r8.element = AppInfo.OAssistant.getPackageName();
        r2 = AppInfo.OAssistant.getAppName();
        goto L38
    L13:
        if (r5.length() == 0) goto L16;
        r6 = false;
        goto L17
    L9:
        r2 = null;
        goto L10
    L5:
        r1 = 0;
        goto L6
    }

    private static final Unit processIntent$lambda$3(Ref.ObjectRef r1, boolean r2, boolean r3, Ref.ObjectRef r4, OperateMemoryContext r5, g r6) {
        Intrinsics.checkNotNullParameter(r6, "$this$mainTrace");
        if (Intrinsics.areEqual(r1.element, AppInfo.OAssistant.getPackageName()) == false) goto L5;
        String r7 = "assistant";
    L6:
        r6.a("route", r7);
        r6.a("screen_locked", Boolean.valueOf(r2));
        r6.a("query_in_bar_window", Boolean.valueOf(r3));
        boolean r8 = false;
        if (r4.element != 0) goto L19;
        if (r5 == null) goto L10;
        String r9 = r5.getScreenshot();
    L11:
        CharSequence r10 = (CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin");
        if (r10 != null) goto L14;
    L17:
        boolean r11 = true;
    L18:
        if (r11 == false) goto L19;
    L20:
        r6.a("has_screenshot", Boolean.valueOf(r8));
        return Unit.INSTANCE;
    L14:
        if (r10.length() == 0) goto L17;
        r11 = false;
        goto L18
    L10:
        r9 = null;
    L19:
        r8 = true;
        goto L20
    L5:
        r7 = "foreground_app";
        goto L6
    }

    private static final Unit processIntent$lambda$5(IntentResult r2, Ref.ObjectRef r3, String r4, AppEntity[] r5, String r6, List r7, g r8) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "$this$mainTrace");
        r8.a("ret", Integer.valueOf(r2.getRet()));
        r8.a("result_type", r3.element);
        r8.a("result_subtype", r4);
        r8.a("entity_count", Integer.valueOf(r5.length));
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L5;
        boolean r10 = true;
    L6:
        r8.a("has_answer", Boolean.valueOf(r10));
        if (r9 == null) goto L9;
        Object r11 = Integer.valueOf(r9.size());
    L10:
        r8.a("result_entity_count", r11);
        return Unit.INSTANCE;
    L9:
        r11 = "null";
        goto L10
    L5:
        r10 = false;
        goto L6
    }

    private static final Unit processIntent$lambda$6(String r2, List r3, List r4, Map r5, IntentResult r6, g r7) {
        Object r8 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Map r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "$this$mainTrace");
        r7.a("answer", r2);
        if (r8 != null) goto L5;
        r8 = "null";
    L5:
        r7.a("result_entities", r8);
        r7.a("real_entities", r9);
        r7.a("extra_map", r10);
        r7.a("details", r6.getDetails());
        return Unit.INSTANCE;
    }

    private final Map<String, AppEntity> queryAuditoryEntities(List<MemoryLLMBuildHelperV2.a> r5) {
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r6 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r7 = r4.iterator();
    L4:
        if (r7.hasNext() == false) goto L11;
        Object r1 = r7.next();
        if (((MemoryLLMBuildHelperV2.a) ZeusTransformUtils.preCheckCast(r1, MemoryLLMBuildHelperV2.a.class, "com.obric.memorydata.plugin")).b() != MemoryLLMBuildHelperV2.ResultEntityType.AUDIO) goto L8;
        boolean r2 = true;
    L9:
        if (r2 == false) goto L4;
        r6.add(r1);
        goto L4
    L8:
        r2 = false;
        goto L9
    L11:
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r9 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r10 = r8.iterator();
    L13:
        if (r10.hasNext() == false) goto L15;
        r9.add(((MemoryLLMBuildHelperV2.a) ZeusTransformUtils.preCheckCast(r10.next(), MemoryLLMBuildHelperV2.a.class, "com.obric.memorydata.plugin")).a());
        goto L13
    L15:
        List<String> r11 = CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
        if (r11.isEmpty() == true) goto L18;
        Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getAuditoryRecordingRawDbDao().queryByEntityIdList(r11), Iterable.class, "com.obric.memorydata.plugin");
        Collection r13 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r14 = r12.iterator();
    L21:
        if (r14.hasNext() == false) goto L29;
        fj r3 = (fj) ZeusTransformUtils.preCheckCast(r14.next(), fj.class, "com.obric.memorydata.plugin");
        AppEntity r15 = r3.convertToAppEntity();
        if (r15 == null) goto L25;
        Pair r16 = TuplesKt.to(r3.getEntityId(), r15);
    L26:
        if (r16 == null) goto L21;
        r13.add(r16);
        goto L21
    L25:
        r16 = null;
        goto L26
    L29:
        return MapsKt.toMap((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r13, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
    L18:
        return MapsKt.emptyMap();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Map<String, AppEntity> queryEpisodicEntities(List<MemoryLLMBuildHelperV2.a> r7) {
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r9 = r6.iterator();
    L3:
        boolean r2 = true;
        if (r9.hasNext() == false) goto L11;
        Object r1 = r9.next();
        if (((MemoryLLMBuildHelperV2.a) ZeusTransformUtils.preCheckCast(r1, MemoryLLMBuildHelperV2.a.class, "com.obric.memorydata.plugin")).b() == MemoryLLMBuildHelperV2.ResultEntityType.EPISODIC) goto L9;
        r2 = false;
    L9:
        if (r2 == false) goto L3;
        r8.add(r1);
        goto L3
    L11:
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r11 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r12 = r10.iterator();
    L13:
        if (r12.hasNext() == false) goto L15;
        r11.add(((MemoryLLMBuildHelperV2.a) ZeusTransformUtils.preCheckCast(r12.next(), MemoryLLMBuildHelperV2.a.class, "com.obric.memorydata.plugin")).a());
        goto L13
    L15:
        List<String> r13 = CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r11, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
        if (r13.isEmpty() == true) goto L18;
        Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getPersonalDbEngine().getEpisodicMemoryDao().queryByEntityIds(r13), Iterable.class, "com.obric.memorydata.plugin");
        Map r15 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r14, 10)), 16)), Map.class, "com.obric.memorydata.plugin");
        Iterator r16 = r14.iterator();
    L21:
        if (r16.hasNext() == false) goto L23;
        EpisodicMemoryEntity r3 = (EpisodicMemoryEntity) ZeusTransformUtils.preCheckCast(r16.next(), EpisodicMemoryEntity.class, "com.obric.memorydata.plugin");
        Pair r4 = TuplesKt.to(r3.getEntityId(), r3.convertToAppEntity());
        r15.put(r4.getFirst(), r4.getSecond());
        goto L21
    L23:
        LinkedHashMap r17 = new LinkedHashMap();
        Iterator r18 = r15.entrySet().iterator();
    L25:
        if (r18.hasNext() == false) goto L32;
        Map.Entry r5 = (Map.Entry) ZeusTransformUtils.preCheckCast(r18.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (((AppEntity) ZeusTransformUtils.preCheckCast(r5.getValue(), AppEntity.class, "com.obric.memorydata.plugin")) == null) goto L29;
        boolean r19 = true;
    L30:
        if (r19 == false) goto L25;
        r17.put(r5.getKey(), r5.getValue());
        goto L25
    L29:
        r19 = false;
        goto L30
    L32:
        Map r20 = (Map) ZeusTransformUtils.preCheckCast(r17, Map.class, "com.obric.memorydata.plugin");
        Map<String, AppEntity> r21 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(MapsKt.mapCapacity(r20.size())), Map.class, "com.obric.memorydata.plugin");
        Iterator r22 = ((Iterable) ZeusTransformUtils.preCheckCast(r20.entrySet(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L34:
        if (r22.hasNext() == false) goto L36;
        Object r23 = r22.next();
        Object r24 = ((Map.Entry) ZeusTransformUtils.preCheckCast(r23, Map.Entry.class, "com.obric.memorydata.plugin")).getKey();
        Object r25 = ((Map.Entry) ZeusTransformUtils.preCheckCast(r23, Map.Entry.class, "com.obric.memorydata.plugin")).getValue();
        Intrinsics.checkNotNull(r25);
        r21.put(r24, (AppEntity) ZeusTransformUtils.preCheckCast(r25, AppEntity.class, "com.obric.memorydata.plugin"));
        goto L34
    L36:
        return r21;
    L18:
        return MapsKt.emptyMap();
    }

    private final List<AppEntity> queryMemoryEntities(List<MemoryLLMBuildHelperV2.a> r7) {
        List<MemoryLLMBuildHelperV2.a> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        if (r8.isEmpty() == true) goto L5;
        Map r0 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Iterator<Map.Entry<String, AppEntity>> r2 = queryEpisodicEntities(r8).entrySet().iterator();
    L8:
        if (r2.hasNext() == false) goto L10;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r2.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r0.put((String) ZeusTransformUtils.preCheckCast(r3.getKey(), String.class, "com.obric.memorydata.plugin"), (AppEntity) ZeusTransformUtils.preCheckCast(r3.getValue(), AppEntity.class, "com.obric.memorydata.plugin"));
        goto L8
    L10:
        Iterator<Map.Entry<String, AppEntity>> r4 = querySemanticEntities(r8).entrySet().iterator();
    L12:
        if (r4.hasNext() == false) goto L14;
        Map.Entry r5 = (Map.Entry) ZeusTransformUtils.preCheckCast(r4.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r0.put((String) ZeusTransformUtils.preCheckCast(r5.getKey(), String.class, "com.obric.memorydata.plugin"), (AppEntity) ZeusTransformUtils.preCheckCast(r5.getValue(), AppEntity.class, "com.obric.memorydata.plugin"));
        goto L12
    L14:
        Iterator<Map.Entry<String, AppEntity>> r6 = queryAuditoryEntities(r8).entrySet().iterator();
    L16:
        if (r6.hasNext() == false) goto L18;
        Map.Entry r9 = (Map.Entry) ZeusTransformUtils.preCheckCast(r6.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r0.put((String) ZeusTransformUtils.preCheckCast(r9.getKey(), String.class, "com.obric.memorydata.plugin"), (AppEntity) ZeusTransformUtils.preCheckCast(r9.getValue(), AppEntity.class, "com.obric.memorydata.plugin"));
        goto L16
    L18:
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin");
        Collection r11 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r12 = r10.iterator();
    L20:
        if (r12.hasNext() == false) goto L25;
        AppEntity r13 = (AppEntity) ZeusTransformUtils.preCheckCast(r0.get(((MemoryLLMBuildHelperV2.a) ZeusTransformUtils.preCheckCast(r12.next(), MemoryLLMBuildHelperV2.a.class, "com.obric.memorydata.plugin")).a()), AppEntity.class, "com.obric.memorydata.plugin");
        if (r13 == null) goto L20;
        r11.add(r13);
        goto L20
    L25:
        return (List) ZeusTransformUtils.preCheckCast(r11, List.class, "com.obric.memorydata.plugin");
    L5:
        return CollectionsKt.emptyList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Map<String, AppEntity> querySemanticEntities(List<MemoryLLMBuildHelperV2.a> r7) {
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r9 = r6.iterator();
    L3:
        boolean r2 = true;
        if (r9.hasNext() == false) goto L11;
        Object r1 = r9.next();
        if (((MemoryLLMBuildHelperV2.a) ZeusTransformUtils.preCheckCast(r1, MemoryLLMBuildHelperV2.a.class, "com.obric.memorydata.plugin")).b() == MemoryLLMBuildHelperV2.ResultEntityType.SEMANTIC) goto L9;
        r2 = false;
    L9:
        if (r2 == false) goto L3;
        r8.add(r1);
        goto L3
    L11:
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r11 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r12 = r10.iterator();
    L13:
        if (r12.hasNext() == false) goto L15;
        r11.add(((MemoryLLMBuildHelperV2.a) ZeusTransformUtils.preCheckCast(r12.next(), MemoryLLMBuildHelperV2.a.class, "com.obric.memorydata.plugin")).a());
        goto L13
    L15:
        List<String> r13 = CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r11, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
        if (r13.isEmpty() == true) goto L18;
        Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getPersonalDbEngine().getSemanticMemoryDao().queryByEntityIds(r13), Iterable.class, "com.obric.memorydata.plugin");
        Map r15 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r14, 10)), 16)), Map.class, "com.obric.memorydata.plugin");
        Iterator r16 = r14.iterator();
    L21:
        if (r16.hasNext() == false) goto L23;
        ip r3 = (ip) ZeusTransformUtils.preCheckCast(r16.next(), ip.class, "com.obric.memorydata.plugin");
        Pair r4 = TuplesKt.to(r3.getEntityId(), r3.convertToAppEntity());
        r15.put(r4.getFirst(), r4.getSecond());
        goto L21
    L23:
        LinkedHashMap r17 = new LinkedHashMap();
        Iterator r18 = r15.entrySet().iterator();
    L25:
        if (r18.hasNext() == false) goto L32;
        Map.Entry r5 = (Map.Entry) ZeusTransformUtils.preCheckCast(r18.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (((AppEntity) ZeusTransformUtils.preCheckCast(r5.getValue(), AppEntity.class, "com.obric.memorydata.plugin")) == null) goto L29;
        boolean r19 = true;
    L30:
        if (r19 == false) goto L25;
        r17.put(r5.getKey(), r5.getValue());
        goto L25
    L29:
        r19 = false;
        goto L30
    L32:
        Map r20 = (Map) ZeusTransformUtils.preCheckCast(r17, Map.class, "com.obric.memorydata.plugin");
        Map<String, AppEntity> r21 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(MapsKt.mapCapacity(r20.size())), Map.class, "com.obric.memorydata.plugin");
        Iterator r22 = ((Iterable) ZeusTransformUtils.preCheckCast(r20.entrySet(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L34:
        if (r22.hasNext() == false) goto L36;
        Object r23 = r22.next();
        Object r24 = ((Map.Entry) ZeusTransformUtils.preCheckCast(r23, Map.Entry.class, "com.obric.memorydata.plugin")).getKey();
        Object r25 = ((Map.Entry) ZeusTransformUtils.preCheckCast(r23, Map.Entry.class, "com.obric.memorydata.plugin")).getValue();
        Intrinsics.checkNotNull(r25);
        r21.put(r24, (AppEntity) ZeusTransformUtils.preCheckCast(r25, AppEntity.class, "com.obric.memorydata.plugin"));
        goto L34
    L36:
        return r21;
    L18:
        return MapsKt.emptyMap();
    }

    private final List<AppEntity> simplifyMemoryEntities(List<? extends AppEntity> r6) {
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r7 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r8 = r5.iterator();
    L4:
        if (r8.hasNext() == false) goto L21;
        AppEntity r1 = (AppEntity) ZeusTransformUtils.preCheckCast(r8.next(), AppEntity.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, MemoryEntity.class) == false) goto L14;
        ((MemoryEntity) ZeusTransformUtils.preCheckCast(r1, MemoryEntity.class, "com.obric.memorydata.plugin")).setSourceLinkType(null);
        ((MemoryEntity) ZeusTransformUtils.preCheckCast(r1, MemoryEntity.class, "com.obric.memorydata.plugin")).setSourceLink(null);
        ((MemoryEntity) ZeusTransformUtils.preCheckCast(r1, MemoryEntity.class, "com.obric.memorydata.plugin")).setScreenshot(null);
        ((MemoryEntity) ZeusTransformUtils.preCheckCast(r1, MemoryEntity.class, "com.obric.memorydata.plugin")).setSourceText(null);
        ((MemoryEntity) ZeusTransformUtils.preCheckCast(r1, MemoryEntity.class, "com.obric.memorydata.plugin")).setSourcePackageName(null);
        ((MemoryEntity) ZeusTransformUtils.preCheckCast(r1, MemoryEntity.class, "com.obric.memorydata.plugin")).setSourceAppName(null);
        ((MemoryEntity) ZeusTransformUtils.preCheckCast(r1, MemoryEntity.class, "com.obric.memorydata.plugin")).setLogId(null);
        ((MemoryEntity) ZeusTransformUtils.preCheckCast(r1, MemoryEntity.class, "com.obric.memorydata.plugin")).setSourceQuery(null);
        ((MemoryEntity) ZeusTransformUtils.preCheckCast(r1, MemoryEntity.class, "com.obric.memorydata.plugin")).setDetail(null);
        r1.setExtra(null);
        r1.setExtraData(null);
        r1.setUuid(null);
        MemoryEntity r2 = (MemoryEntity) ZeusTransformUtils.preCheckCast(r1, MemoryEntity.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r2, InfoCommonMemoryEntity.class) == false) goto L11;
        ((InfoCommonMemoryEntity) ZeusTransformUtils.preCheckCast(r1, InfoCommonMemoryEntity.class, "com.obric.memorydata.plugin")).setObservation(null);
        ((InfoCommonMemoryEntity) ZeusTransformUtils.preCheckCast(r1, InfoCommonMemoryEntity.class, "com.obric.memorydata.plugin")).setRelatedMemoryids(null);
        ((InfoCommonMemoryEntity) ZeusTransformUtils.preCheckCast(r1, InfoCommonMemoryEntity.class, "com.obric.memorydata.plugin")).setTag(null);
    L19:
        r7.add(r1);
        goto L4
    L11:
        if (ZeusTransformUtils.instanceOf(r2, CommonTextMemoryEntity.class) == false) goto L19;
        ((CommonTextMemoryEntity) ZeusTransformUtils.preCheckCast(r1, CommonTextMemoryEntity.class, "com.obric.memorydata.plugin")).setSummary("");
        ((CommonTextMemoryEntity) ZeusTransformUtils.preCheckCast(r1, CommonTextMemoryEntity.class, "com.obric.memorydata.plugin")).setMemoryCreateTime(null);
        ((CommonTextMemoryEntity) ZeusTransformUtils.preCheckCast(r1, CommonTextMemoryEntity.class, "com.obric.memorydata.plugin")).setTagList(null);
        ((CommonTextMemoryEntity) ZeusTransformUtils.preCheckCast(r1, CommonTextMemoryEntity.class, "com.obric.memorydata.plugin")).setCategory(null);
        goto L19
    L14:
        if (ZeusTransformUtils.instanceOf(r1, ProactiveMemoryEntity.class) == false) goto L17;
        r1.setExtra(null);
        r1.setExtraData(null);
        r1.setUuid(null);
        goto L19
    L17:
        if (ZeusTransformUtils.instanceOf(r1, AuditoryRecordingEntity.class) == false) goto L19;
        r1.setExtras(null);
        r1.setExtra(null);
        r1.setExtraData(null);
        r1.setUuid(null);
        ((AuditoryRecordingEntity) ZeusTransformUtils.preCheckCast(r1, AuditoryRecordingEntity.class, "com.obric.memorydata.plugin")).setTranscript(null);
        ((AuditoryRecordingEntity) ZeusTransformUtils.preCheckCast(r1, AuditoryRecordingEntity.class, "com.obric.memorydata.plugin")).setTodoList(null);
        ((AuditoryRecordingEntity) ZeusTransformUtils.preCheckCast(r1, AuditoryRecordingEntity.class, "com.obric.memorydata.plugin")).setMarkers(null);
        ((AuditoryRecordingEntity) ZeusTransformUtils.preCheckCast(r1, AuditoryRecordingEntity.class, "com.obric.memorydata.plugin")).setSourceAppName(null);
        ((AuditoryRecordingEntity) ZeusTransformUtils.preCheckCast(r1, AuditoryRecordingEntity.class, "com.obric.memorydata.plugin")).setSourceAppPackage(null);
        goto L19
    L21:
        return (List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.capabilitykit.common.intent.BaseMemoryOperateIntent, com.obric.capabilitykit.common.intent.IntentFunction
    public /* synthetic */ Object doAction(Parcelable r3, DispatchContext r4, Continuation<? super IntentResult<AppEntity[]>> r5) {
        Parcelable r6 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.memorydata.plugin");
        Continuation<? super IntentResult<AppEntity[]>> r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        return doAction((MemoryOperateParams) ZeusTransformUtils.preCheckCast(r6, MemoryOperateParams.class, "com.obric.memorydata.plugin"), r4, r7);
    }

    @Override // com.obric.capabilitykit.common.intent.BaseMemoryOperateIntent
    public Object doAction(MemoryOperateParams r31, DispatchContext r32, Continuation<? super IntentResult<AppEntity[]>> r33) {
        OperateMemoryIntent r0 = this;
        Continuation r1 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r33, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, AnonymousClass1.class) == false) goto L7;
        AnonymousClass1 r3 = (AnonymousClass1) ZeusTransformUtils.preCheckCast(r1, AnonymousClass1.class, "com.obric.memorydata.plugin");
        if ((r3.label & Integer.MIN_VALUE) == 0) goto L7;
        r3.label -= Integer.MIN_VALUE;
    L8:
        Object r2 = r3.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r3.label;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        e r6 = (e) ZeusTransformUtils.preCheckCast(r3.L$2, e.class, "com.obric.memorydata.plugin");
        OperateMemoryContext r7 = (OperateMemoryContext) ZeusTransformUtils.preCheckCast(r3.L$1, OperateMemoryContext.class, "com.obric.memorydata.plugin");
        OperateMemoryIntent r8 = (OperateMemoryIntent) ZeusTransformUtils.preCheckCast(r3.L$0, OperateMemoryIntent.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r2);
        boolean r9 = true;
        e r10 = r6;
        r0 = r8;
        Object r11 = r2;
    L38:
        final Boolean r12 = (Boolean) ZeusTransformUtils.preCheckCast(r11, Boolean.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r12, Boxing.boxBoolean(r9)) == false) goto L41;
        o.a((o) ZeusTransformUtils.preCheckCast(com.obric.memorydata.middleware.api.logging.a.f11610a, o.class, "com.obric.memorydata.plugin"), "助手主动记忆隐私授权已通过", "privacy_confirmation_accepted", r10, null, null, 24, null);
        return r0.processIntent(r7, r10);
    L41:
        o r13 = (o) ZeusTransformUtils.preCheckCast(com.obric.memorydata.middleware.api.logging.a.f11610a, o.class, "com.obric.memorydata.plugin");
        if (r12 != null) goto L44;
        String r14 = "privacy_confirmation_timeout";
    L45:
        o.a(r13, "助手主动记忆因隐私授权未通过而终止", "build_blocked", r14, null, r10, new $$Lambda$OperateMemoryIntent$UHHPJ_WqnskpW1wNmkHytjmkhds(r12), 8, null);
        return new IntentResult(201, new AppEntity[0], null, null, false, false, 256, null, null, null, 956, null);
    L44:
        r14 = "privacy_not_agreed";
        goto L45
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r2);
        a r15 = r0.parseContext(r31.getContext());
        OperateMemoryContext r16 = r15.getContext();
        if (r16 == null) goto L17;
        String r17 = r16.getLogId();
    L18:
        e r18 = new e(null, r17, "trigger", 1, null);
        o.a((o) ZeusTransformUtils.preCheckCast(com.obric.memorydata.middleware.api.logging.a.f11610a, o.class, "com.obric.memorydata.plugin"), "助手主动记忆操作已触发", "operation_received", r18, null, null, 24, null);
        CharSequence r19 = (CharSequence) ZeusTransformUtils.preCheckCast(r31.getContext(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r19 != null) goto L21;
    L24:
        boolean r20 = true;
    L25:
        if (r20 == true) goto L33;
        if (r16 != null) goto L33;
        o r21 = (o) ZeusTransformUtils.preCheckCast(com.obric.memorydata.middleware.api.logging.a.f11610a, o.class, "com.obric.memorydata.plugin");
        g r22 = new g();
        Throwable r23 = r15.a();
        if (r23 == null) goto L30;
        String r110 = r23.getMessage();
    L31:
        r22.a(CommonConsts.LOG_REPORT_TYPE_EXCEPTION, r110);
        r21.a("context_parse_failed", "助手主动记忆上下文解析失败，使用默认输入", r18, r22.a());
        goto L33
    L30:
        r110 = null;
    L33:
        if (UserSettings.INSTANCE.hasAgreePrivacyAndLogin() == true) goto L48;
        o.a((o) ZeusTransformUtils.preCheckCast(com.obric.memorydata.middleware.api.logging.a.f11610a, o.class, "com.obric.memorydata.plugin"), "助手主动记忆等待隐私授权", "privacy_confirmation_required", r18, null, null, 24, null);
        Function2 r24 = (Function2) ZeusTransformUtils.preCheckCast(new OperateMemoryIntent$doAction$agree$1(null), Function2.class, "com.obric.memorydata.plugin");
        r3.L$0 = r0;
        r3.L$1 = r16;
        r3.L$2 = r18;
        r9 = true;
        r3.label = 1;
        Object r25 = da.b(10000, r24, r3);
        if (r25 != r4) goto L37;
        return r4;
    L37:
        r11 = r25;
        r7 = r16;
        r10 = r18;
        goto L38
    L48:
        return r0.processIntent(r16, r18);
    L21:
        if (StringsKt.isBlank(r19) == true) goto L24;
        r20 = false;
        goto L25
    L17:
        r17 = null;
    L7:
        r3 = new AnonymousClass1(r0, r1);
        goto L8
    }

    @Override // com.obric.capabilitykit.common.intent.BaseMemoryOperateIntent, com.obric.capabilitykit.common.intent.IntentFunction
    public boolean isBlock() {
        return true;
    }
}
