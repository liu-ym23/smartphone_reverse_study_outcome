package com.obric.memorydata.datatransport.excel;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.entity.EventBody;
import com.google.gson.JsonArray;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.capabilitykit.common.Ext;
import com.obric.memorydata.database.entity.ChatMessage;
import com.obric.memorydata.database.model.EntitySearchRecordInfo;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\r\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\t\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019¨\u0006\u001a"}, d2 = {"Lcom/obric/memorydata/datatransport/excel/ExcelExtra;", "", "<init>", "()V", "Evaluation", "FineTune", "Accessibility", "PersonalContext", "CommonDataEntity", "MemoryGroundTruth", "EvaluationCriteriaEntity", "PcQueryList", "PcQuery", "PcQueryResults", "PcEvaluationResultEntry", "SearchControlParams", "PcEvaluationResult", "Lcom/obric/memorydata/datatransport/excel/ExcelExtra$Accessibility;", "Lcom/obric/memorydata/datatransport/excel/ExcelExtra$CommonDataEntity;", "Lcom/obric/memorydata/datatransport/excel/ExcelExtra$Evaluation;", "Lcom/obric/memorydata/datatransport/excel/ExcelExtra$EvaluationCriteriaEntity;", "Lcom/obric/memorydata/datatransport/excel/ExcelExtra$FineTune;", "Lcom/obric/memorydata/datatransport/excel/ExcelExtra$PcEvaluationResult;", "Lcom/obric/memorydata/datatransport/excel/ExcelExtra$PcQueryList;", "Lcom/obric/memorydata/datatransport/excel/ExcelExtra$PcQueryResults;", "Lcom/obric/memorydata/datatransport/excel/ExcelExtra$PersonalContext;", "data_transport_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class b {

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b.\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u007f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\u0095\u0001\u00100\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u0003HÆ\u0001J\u0013\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u000104HÖ\u0003J\t\u00105\u001a\u000206HÖ\u0001J\t\u00107\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0014R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0014R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0014R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0014R\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0014¨\u00068"}, d2 = {"Lcom/obric/memorydata/datatransport/excel/ExcelExtra$Accessibility;", "Lcom/obric/memorydata/datatransport/excel/ExcelExtra;", "activityName", "", "eventName", "className", "allTextInfo", "allTextInfo2", "allTextInfo3", "allTextInfo4", "allTextInfo5", "eventInfo", "viewTreeInfo", "description", ObricMemoryConstants.KEY_PACKAGE_NAME, "hasScreenshot", "operateNodeInfo", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getActivityName", "()Ljava/lang/String;", "getEventName", "getClassName", "getAllTextInfo", "getAllTextInfo2", "getAllTextInfo3", "getAllTextInfo4", "getAllTextInfo5", "getEventInfo", "getViewTreeInfo", "getDescription", "getPackageName", "getHasScreenshot", "getOperateNodeInfo", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "copy", "equals", "", "other", "", "hashCode", "", "toString", "data_transport_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f9730a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f9731b;
        private final String c;
        private final String d;
        private final String e;
        private final String f;
        private final String g;
        private final String h;
        private final String i;
        private final String j;
        private final String k;
        private final String l;
        private final String m;
        private final String n;

        public final String a() {
            return this.f9730a;
        }

        public final String b() {
            return this.f9731b;
        }

        public final String c() {
            return this.c;
        }

        public final String d() {
            return this.d;
        }

        public final String e() {
            return this.e;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f9730a, r6.f9730a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f9731b, r6.f9731b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
            return false;
        L33:
            if (Intrinsics.areEqual(this.i, r6.i) == true) goto L36;
            return false;
        L36:
            if (Intrinsics.areEqual(this.j, r6.j) == true) goto L39;
            return false;
        L39:
            if (Intrinsics.areEqual(this.k, r6.k) == true) goto L42;
            return false;
        L42:
            if (Intrinsics.areEqual(this.l, r6.l) == true) goto L45;
            return false;
        L45:
            if (Intrinsics.areEqual(this.m, r6.m) == true) goto L48;
            return false;
        L48:
            if (Intrinsics.areEqual(this.n, r6.n) == true) goto L50;
            return false;
        L50:
            return true;
        }

        public final String f() {
            return this.f;
        }

        public final String g() {
            return this.g;
        }

        public final String h() {
            return this.h;
        }

        public int hashCode() {
            return (((((((((((((((((((((((((this.f9730a.hashCode() * 31) + this.f9731b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + this.h.hashCode()) * 31) + this.i.hashCode()) * 31) + this.j.hashCode()) * 31) + this.k.hashCode()) * 31) + this.l.hashCode()) * 31) + this.m.hashCode()) * 31) + this.n.hashCode();
        }

        public final String i() {
            return this.i;
        }

        public final String j() {
            return this.j;
        }

        public final String k() {
            return this.k;
        }

        public final String l() {
            return this.l;
        }

        public final String m() {
            return this.m;
        }

        public final String n() {
            return this.n;
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder();
            r0.append("Accessibility(activityName=").append(this.f9730a).append(", eventName=").append(this.f9731b).append(", className=").append(this.c).append(", allTextInfo=").append(this.d).append(", allTextInfo2=").append(this.e).append(", allTextInfo3=").append(this.f).append(", allTextInfo4=").append(this.g).append(", allTextInfo5=").append(this.h).append(", eventInfo=").append(this.i).append(", viewTreeInfo=").append(this.j).append(", description=").append(this.k).append(", packageName=");
            r0.append(this.l).append(", hasScreenshot=").append(this.m).append(", operateNodeInfo=").append(this.n).append(')');
            return r0.toString();
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.datatransport.excel.b$b, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/obric/memorydata/datatransport/excel/ExcelExtra$Evaluation;", "Lcom/obric/memorydata/datatransport/excel/ExcelExtra;", "responseWithMemory", "", "responseWithoutMemory", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getResponseWithMemory", "()Ljava/lang/String;", "getResponseWithoutMemory", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "data_transport_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C0472b extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f9732a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f9733b;

        public final String a() {
            return this.f9732a;
        }

        public final String b() {
            return this.f9733b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, C0472b.class) == true) goto L8;
            return false;
        L8:
            C0472b r6 = (C0472b) ZeusTransformUtils.preCheckCast(r5, C0472b.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f9732a, r6.f9732a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f9733b, r6.f9733b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f9732a.hashCode() * 31) + this.f9733b.hashCode();
        }

        public String toString() {
            return "Evaluation(responseWithMemory=" + this.f9732a + ", responseWithoutMemory=" + this.f9733b + ')';
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/obric/memorydata/datatransport/excel/ExcelExtra$FineTune;", "Lcom/obric/memorydata/datatransport/excel/ExcelExtra;", "botId", "", Ext.KEY_REQUEST, ChatMessage.TYPE_RESPONSE, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBotId", "()Ljava/lang/String;", "getRequest", "getResponse", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "data_transport_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f9734a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f9735b;
        private final String c;

        public final String a() {
            return this.f9734a;
        }

        public final String b() {
            return this.f9735b;
        }

        public final String c() {
            return this.c;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
            return false;
        L8:
            c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f9734a, r6.f9734a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f9735b, r6.f9735b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.f9734a.hashCode() * 31) + this.f9735b.hashCode()) * 31) + this.c.hashCode();
        }

        public String toString() {
            return "FineTune(botId=" + this.f9734a + ", request=" + this.f9735b + ", response=" + this.c + ')';
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bHÆ\u0003JG\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006 "}, d2 = {"Lcom/obric/memorydata/datatransport/excel/ExcelExtra$PcEvaluationResult;", "Lcom/obric/memorydata/datatransport/excel/ExcelExtra;", "precision", "", LocationMonitorConst.ACCURACY, "recall", "f1Score", WsConstants.KEY_EXTRA, "", "", "<init>", "(DDDDLjava/util/Map;)V", "getPrecision", "()D", "getAccuracy", "getRecall", "getF1Score", "getExtra", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "data_transport_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class d extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final double f9736a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final double f9737b;
        private final double c;
        private final double d;
        private final Map<String, String> e;

        public d() {
            this(0.0d, 0.0d, 0.0d, 0.0d, null, 31, null);
        }

        public d(double r3, double r5, double r7, double r9, Map<String, String> r11) {
            Map<String, String> r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r12, WsConstants.KEY_EXTRA);
            super(null);
            this.f9736a = r3;
            this.f9737b = r5;
            this.c = r7;
            this.d = r9;
            this.e = r12;
        }

        public /* synthetic */ d(double r11, double r13, double r15, double r17, Map r19, int r20, DefaultConstructorMarker r21) {
            Map r0 = (Map) ZeusTransformUtils.wrapperContextForParams(r19, Map.class, "com.obric.memorydata.plugin");
            double r2 = 0.0d;
            if ((r20 & 1) == 0) goto L5;
            double r4 = 0.0d;
        L7:
            if ((r20 & 2) == 0) goto L9;
            double r6 = 0.0d;
        L11:
            if ((r20 & 4) == 0) goto L13;
            double r8 = 0.0d;
        L15:
            if ((r20 & 8) != 0) goto L19;
            r2 = r17;
        L19:
            if ((r20 & 16) == 0) goto L21;
            r0 = MapsKt.emptyMap();
        L21:
            this(r4, r6, r8, r2, r0);
            return;
        L13:
            r8 = r15;
            goto L15
        L9:
            r6 = r13;
            goto L11
        L5:
            r4 = r11;
            goto L7
        }

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, d.class) == true) goto L8;
            return false;
        L8:
            d r10 = (d) ZeusTransformUtils.preCheckCast(r9, d.class, "com.obric.memorydata.plugin");
            if (Double.compare(this.f9736a, r10.f9736a) == 0) goto L12;
            return false;
        L12:
            if (Double.compare(this.f9737b, r10.f9737b) == 0) goto L15;
            return false;
        L15:
            if (Double.compare(this.c, r10.c) == 0) goto L18;
            return false;
        L18:
            if (Double.compare(this.d, r10.d) == 0) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r10.e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public int hashCode() {
            return (((((((Double.hashCode(this.f9736a) * 31) + Double.hashCode(this.f9737b)) * 31) + Double.hashCode(this.c)) * 31) + Double.hashCode(this.d)) * 31) + this.e.hashCode();
        }

        public String toString() {
            return "PcEvaluationResult(precision=" + this.f9736a + ", accuracy=" + this.f9737b + ", recall=" + this.c + ", f1Score=" + this.d + ", extra=" + this.e + ')';
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J7\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/obric/memorydata/datatransport/excel/ExcelExtra$PcQuery;", "", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "", "targetEvaluationIds", "", "evaluationSetId", "targetScore", "", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;D)V", "getText", "()Ljava/lang/String;", "getTargetEvaluationIds", "()Ljava/util/List;", "getEvaluationSetId", "getTargetScore", "()D", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "data_transport_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f9738a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List<String> f9739b;
        private final String c;
        private final double d;

        public e(String r3, List<String> r4, String r5, double r6) {
            List<String> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
            Intrinsics.checkNotNullParameter(r7, "targetEvaluationIds");
            Intrinsics.checkNotNullParameter(r5, "evaluationSetId");
            this.f9738a = r3;
            this.f9739b = r7;
            this.c = r5;
            this.d = r6;
        }

        public /* synthetic */ e(String r7, List r8, String r9, double r10, int r12, DefaultConstructorMarker r13) {
            List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
            if ((r12 & 2) == 0) goto L5;
            r11 = CollectionsKt.emptyList();
        L5:
            List r2 = r11;
            if ((r12 & 4) == 0) goto L8;
            r9 = "0";
        L8:
            String r3 = r9;
            if ((r12 & 8) == 0) goto L11;
            r10 = 0.0d;
        L11:
            this(r7, r2, r3, r10);
        }

        public final String a() {
            return this.f9738a;
        }

        public final List<String> b() {
            return this.f9739b;
        }

        public boolean equals(Object r7) {
            if (this != r7) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r7, e.class) == true) goto L8;
            return false;
        L8:
            e r8 = (e) ZeusTransformUtils.preCheckCast(r7, e.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f9738a, r8.f9738a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f9739b, r8.f9739b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r8.c) == true) goto L18;
            return false;
        L18:
            if (Double.compare(this.d, r8.d) == 0) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            return (((((this.f9738a.hashCode() * 31) + this.f9739b.hashCode()) * 31) + this.c.hashCode()) * 31) + Double.hashCode(this.d);
        }

        public String toString() {
            return "PcQuery(text=" + this.f9738a + ", targetEvaluationIds=" + this.f9739b + ", evaluationSetId=" + this.c + ", targetScore=" + this.d + ')';
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J#\u0010\u0013\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/obric/memorydata/datatransport/excel/ExcelExtra$PcQueryList;", "Lcom/obric/memorydata/datatransport/excel/ExcelExtra;", "queries", "", "Lcom/obric/memorydata/datatransport/excel/ExcelExtra$PcQuery;", "searchControlParams", "Lcom/obric/memorydata/datatransport/excel/ExcelExtra$SearchControlParams;", "<init>", "(Ljava/util/List;Lcom/obric/memorydata/datatransport/excel/ExcelExtra$SearchControlParams;)V", "getQueries", "()Ljava/util/List;", "setQueries", "(Ljava/util/List;)V", "getSearchControlParams", "()Lcom/obric/memorydata/datatransport/excel/ExcelExtra$SearchControlParams;", "setSearchControlParams", "(Lcom/obric/memorydata/datatransport/excel/ExcelExtra$SearchControlParams;)V", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "data_transport_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class f extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private List<e> f9740a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private i f9741b;

        public final List<e> a() {
            return this.f9740a;
        }

        public final i b() {
            return this.f9741b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, f.class) == true) goto L8;
            return false;
        L8:
            f r6 = (f) ZeusTransformUtils.preCheckCast(r5, f.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f9740a, r6.f9740a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f9741b, r6.f9741b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f9740a.hashCode() * 31) + this.f9741b.hashCode();
        }

        public String toString() {
            return "PcQueryList(queries=" + this.f9740a + ", searchControlParams=" + this.f9741b + ')';
        }
    }

    @Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\b>\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BÍ\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0015\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\u0014\b\u0002\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u001c¢\u0006\u0004\b\u001d\u0010\u001eJ\u000b\u0010H\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010L\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\t\u0010R\u001a\u00020\u0015HÆ\u0003J\t\u0010S\u001a\u00020\u0015HÆ\u0003J\t\u0010T\u001a\u00020\u0015HÆ\u0003J\t\u0010U\u001a\u00020\u0015HÆ\u0003J\u0010\u0010V\u001a\u0004\u0018\u00010\u001aHÆ\u0003¢\u0006\u0002\u0010BJ\u0015\u0010W\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u001cHÆ\u0003JÔ\u0001\u0010X\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00152\b\b\u0002\u0010\u0018\u001a\u00020\u00152\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0014\b\u0002\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u001cHÆ\u0001¢\u0006\u0002\u0010YJ\u0013\u0010Z\u001a\u00020[2\b\u0010\\\u001a\u0004\u0018\u00010]HÖ\u0003J\t\u0010^\u001a\u00020\u001aHÖ\u0001J\t\u0010_\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010 R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010 R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010 \"\u0004\b.\u0010/R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u0011\u0010\u0016\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b>\u0010=R\u0011\u0010\u0017\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b?\u0010=R\u0011\u0010\u0018\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b@\u0010=R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u0010\n\u0002\u0010E\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u001d\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u001c¢\u0006\b\n\u0000\u001a\u0004\bF\u0010G¨\u0006`"}, d2 = {"Lcom/obric/memorydata/datatransport/excel/ExcelExtra$PcQueryResults;", "Lcom/obric/memorydata/datatransport/excel/ExcelExtra;", ChatMessage.TYPE_QUERY, "", "targetEvaluationIds", "pcQuery", "Lcom/obric/memorydata/datatransport/excel/ExcelExtra$PcQuery;", "resultEvaluationIds", "resultList", "", "Lcom/obric/memorydata/datatransport/excel/ExcelExtra$PcEvaluationResultEntry;", "resultEntities", "Lcom/google/gson/JsonArray;", "quResult", "queryTimeCost", "Lcom/obric/memorydata/database/model/EntitySearchRecordInfo;", "searchControlParams", "Lcom/obric/memorydata/datatransport/excel/ExcelExtra$SearchControlParams;", "evaluationResult", "Lcom/obric/memorydata/datatransport/excel/ExcelExtra$PcEvaluationResult;", "precision", "", LocationMonitorConst.ACCURACY, "recall", "f1Score", "resultCode", "", WsConstants.KEY_EXTRA, "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/obric/memorydata/datatransport/excel/ExcelExtra$PcQuery;Ljava/lang/String;Ljava/util/List;Lcom/google/gson/JsonArray;Ljava/lang/String;Lcom/obric/memorydata/database/model/EntitySearchRecordInfo;Lcom/obric/memorydata/datatransport/excel/ExcelExtra$SearchControlParams;Lcom/obric/memorydata/datatransport/excel/ExcelExtra$PcEvaluationResult;DDDDLjava/lang/Integer;Ljava/util/Map;)V", "getQuery", "()Ljava/lang/String;", "getTargetEvaluationIds", "getPcQuery", "()Lcom/obric/memorydata/datatransport/excel/ExcelExtra$PcQuery;", "getResultEvaluationIds", "getResultList", "()Ljava/util/List;", "setResultList", "(Ljava/util/List;)V", "getResultEntities", "()Lcom/google/gson/JsonArray;", "setResultEntities", "(Lcom/google/gson/JsonArray;)V", "getQuResult", "setQuResult", "(Ljava/lang/String;)V", "getQueryTimeCost", "()Lcom/obric/memorydata/database/model/EntitySearchRecordInfo;", "setQueryTimeCost", "(Lcom/obric/memorydata/database/model/EntitySearchRecordInfo;)V", "getSearchControlParams", "()Lcom/obric/memorydata/datatransport/excel/ExcelExtra$SearchControlParams;", "setSearchControlParams", "(Lcom/obric/memorydata/datatransport/excel/ExcelExtra$SearchControlParams;)V", "getEvaluationResult", "()Lcom/obric/memorydata/datatransport/excel/ExcelExtra$PcEvaluationResult;", "setEvaluationResult", "(Lcom/obric/memorydata/datatransport/excel/ExcelExtra$PcEvaluationResult;)V", "getPrecision", "()D", "getAccuracy", "getRecall", "getF1Score", "getResultCode", "()Ljava/lang/Integer;", "setResultCode", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getExtra", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/obric/memorydata/datatransport/excel/ExcelExtra$PcQuery;Ljava/lang/String;Ljava/util/List;Lcom/google/gson/JsonArray;Ljava/lang/String;Lcom/obric/memorydata/database/model/EntitySearchRecordInfo;Lcom/obric/memorydata/datatransport/excel/ExcelExtra$SearchControlParams;Lcom/obric/memorydata/datatransport/excel/ExcelExtra$PcEvaluationResult;DDDDLjava/lang/Integer;Ljava/util/Map;)Lcom/obric/memorydata/datatransport/excel/ExcelExtra$PcQueryResults;", "equals", "", "other", "", "hashCode", "toString", "data_transport_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class g extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f9742a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f9743b;
        private final e c;
        private final String d;
        private List<Object> e;
        private JsonArray f;
        private String g;
        private EntitySearchRecordInfo h;
        private i i;
        private d j;
        private final double k;
        private final double l;
        private final double m;
        private final double n;
        private Integer o;
        private final Map<String, String> p;

        public g() {
            this(null, null, null, null, null, null, null, null, null, null, 0.0d, 0.0d, 0.0d, 0.0d, null, null, 65535, null);
        }

        public g(String r6, String r7, e r8, String r9, List<Object> r10, JsonArray r11, String r12, EntitySearchRecordInfo r13, i r14, d r15, double r16, double r18, double r20, double r22, Integer r24, Map<String, String> r25) {
            List<Object> r1 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
            Map<String, String> r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r25, Map.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r1, "resultList");
            Intrinsics.checkNotNullParameter(r2, WsConstants.KEY_EXTRA);
            super(null);
            this.f9742a = r6;
            this.f9743b = r7;
            this.c = r8;
            this.d = r9;
            this.e = r1;
            this.f = r11;
            this.g = r12;
            this.h = r13;
            this.i = r14;
            this.j = r15;
            this.k = r16;
            this.l = r18;
            this.m = r20;
            this.n = r22;
            this.o = r24;
            this.p = r2;
        }

        public /* synthetic */ g(String r23, String r24, e r25, String r26, List r27, JsonArray r28, String r29, EntitySearchRecordInfo r30, i r31, d r32, double r33, double r35, double r37, double r39, Integer r41, Map r42, int r43, DefaultConstructorMarker r44) {
            List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r27, List.class, "com.obric.memorydata.plugin");
            Map r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r42, Map.class, "com.obric.memorydata.plugin");
            Integer r4 = null;
            if ((r43 & 1) == 0) goto L5;
            String r3 = null;
        L7:
            if ((r43 & 2) == 0) goto L9;
            String r5 = null;
        L11:
            if ((r43 & 4) == 0) goto L13;
            e r6 = null;
        L15:
            if ((r43 & 8) == 0) goto L17;
            String r7 = null;
        L19:
            if ((r43 & 16) == 0) goto L22;
            r1 = CollectionsKt.emptyList();
        L22:
            if ((r43 & 32) == 0) goto L24;
            JsonArray r8 = null;
        L26:
            if ((r43 & 64) == 0) goto L28;
            String r9 = null;
        L30:
            if ((r43 & 128) == 0) goto L32;
            EntitySearchRecordInfo r10 = null;
        L34:
            if ((r43 & 256) == 0) goto L36;
            i r11 = null;
        L38:
            if ((r43 & 512) == 0) goto L40;
            d r12 = null;
        L41:
            double r14 = 0.0d;
            if ((r43 & 1024) == 0) goto L44;
            double r16 = 0.0d;
        L46:
            if ((r43 & 2048) == 0) goto L48;
            double r18 = 0.0d;
        L50:
            if ((r43 & 4096) == 0) goto L52;
            double r20 = 0.0d;
        L54:
            if ((r43 & 8192) != 0) goto L58;
            r14 = r39;
        L58:
            if ((r43 & 16384) != 0) goto L62;
            r4 = r41;
        L62:
            if ((r43 & 32768) == 0) goto L64;
            r2 = MapsKt.emptyMap();
        L64:
            this(r3, r5, r6, r7, r1, r8, r9, r10, r11, r12, r16, r18, r20, r14, r4, r2);
            return;
        L52:
            r20 = r37;
            goto L54
        L48:
            r18 = r35;
            goto L50
        L44:
            r16 = r33;
            goto L46
        L40:
            r12 = r32;
            goto L41
        L36:
            r11 = r31;
            goto L38
        L32:
            r10 = r30;
            goto L34
        L28:
            r9 = r29;
            goto L30
        L24:
            r8 = r28;
            goto L26
        L17:
            r7 = r26;
            goto L19
        L13:
            r6 = r25;
            goto L15
        L9:
            r5 = r24;
            goto L11
        L5:
            r3 = r23;
            goto L7
        }

        public final e a() {
            return this.c;
        }

        public final String b() {
            return this.d;
        }

        public final List<Object> c() {
            return this.e;
        }

        public final JsonArray d() {
            return this.f;
        }

        public final String e() {
            return this.g;
        }

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, g.class) == true) goto L8;
            return false;
        L8:
            g r10 = (g) ZeusTransformUtils.preCheckCast(r9, g.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f9742a, r10.f9742a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f9743b, r10.f9743b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r10.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r10.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r10.e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r10.f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.g, r10.g) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.h, r10.h) == true) goto L33;
            return false;
        L33:
            if (Intrinsics.areEqual(this.i, r10.i) == true) goto L36;
            return false;
        L36:
            if (Intrinsics.areEqual(this.j, r10.j) == true) goto L39;
            return false;
        L39:
            if (Double.compare(this.k, r10.k) == 0) goto L42;
            return false;
        L42:
            if (Double.compare(this.l, r10.l) == 0) goto L45;
            return false;
        L45:
            if (Double.compare(this.m, r10.m) == 0) goto L48;
            return false;
        L48:
            if (Double.compare(this.n, r10.n) == 0) goto L51;
            return false;
        L51:
            if (Intrinsics.areEqual(this.o, r10.o) == true) goto L54;
            return false;
        L54:
            if (Intrinsics.areEqual(this.p, r10.p) == true) goto L56;
            return false;
        L56:
            return true;
        }

        public final EntitySearchRecordInfo f() {
            return this.h;
        }

        public final i g() {
            return this.i;
        }

        public final d h() {
            return this.j;
        }

        public int hashCode() {
            String r0 = this.f9742a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            String r4 = this.f9743b;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            e r7 = this.c;
            if (r7 != null) goto L13;
            int r8 = 0;
        L14:
            int r9 = (r6 + r8) * 31;
            String r10 = this.d;
            if (r10 != null) goto L17;
            int r11 = 0;
        L18:
            int r12 = (((r9 + r11) * 31) + this.e.hashCode()) * 31;
            JsonArray r13 = this.f;
            if (r13 != null) goto L21;
            int r14 = 0;
        L22:
            int r15 = (r12 + r14) * 31;
            String r16 = this.g;
            if (r16 != null) goto L25;
            int r17 = 0;
        L26:
            int r18 = (r15 + r17) * 31;
            EntitySearchRecordInfo r19 = this.h;
            if (r19 != null) goto L29;
            int r20 = 0;
        L30:
            int r21 = (r18 + r20) * 31;
            i r22 = this.i;
            if (r22 != null) goto L33;
            int r23 = 0;
        L34:
            int r24 = (r21 + r23) * 31;
            d r25 = this.j;
            if (r25 != null) goto L37;
            int r26 = 0;
        L38:
            int r27 = (((((((((r24 + r26) * 31) + Double.hashCode(this.k)) * 31) + Double.hashCode(this.l)) * 31) + Double.hashCode(this.m)) * 31) + Double.hashCode(this.n)) * 31;
            Integer r28 = this.o;
            if (r28 == null) goto L43;
            r1 = r28.hashCode();
        L43:
            return ((r27 + r1) * 31) + this.p.hashCode();
        L37:
            r26 = r25.hashCode();
            goto L38
        L33:
            r23 = r22.hashCode();
            goto L34
        L29:
            r20 = r19.hashCode();
            goto L30
        L25:
            r17 = r16.hashCode();
            goto L26
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

        public final double i() {
            return this.k;
        }

        public final double j() {
            return this.l;
        }

        public final double k() {
            return this.m;
        }

        public final double l() {
            return this.n;
        }

        public final Integer m() {
            return this.o;
        }

        public final Map<String, String> n() {
            return this.p;
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder();
            r0.append("PcQueryResults(query=").append(this.f9742a).append(", targetEvaluationIds=").append(this.f9743b).append(", pcQuery=").append(this.c).append(", resultEvaluationIds=").append(this.d).append(", resultList=").append(this.e).append(", resultEntities=").append(this.f).append(", quResult=").append(this.g).append(", queryTimeCost=").append(this.h).append(", searchControlParams=").append(this.i).append(", evaluationResult=").append(this.j).append(", precision=").append(this.k).append(", accuracy=");
            r0.append(this.l).append(", recall=").append(this.m).append(", f1Score=").append(this.n).append(", resultCode=").append(this.o).append(", extra=").append(this.p).append(')');
            return r0.toString();
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b#\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001By\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\bHÆ\u0003J{\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.HÖ\u0003J\t\u0010/\u001a\u00020\u0003HÖ\u0001J\t\u00100\u001a\u00020\bHÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0013\u0010\n\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019R\u0013\u0010\f\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019R\u0013\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0019R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0019¨\u00061"}, d2 = {"Lcom/obric/memorydata/datatransport/excel/ExcelExtra$PersonalContext;", "Lcom/obric/memorydata/datatransport/excel/ExcelExtra;", "type", "", "createTime", "", "lastModifiedTime", "data", "", "typeDesc", "dependencies", ChatMessage.TYPE_QUERY, "evaluationId", TypedValues.AttributesType.S_TARGET, EventBody.KEY_CATEGORY, "<init>", "(IJJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getType", "()I", "setType", "(I)V", "getCreateTime", "()J", "getLastModifiedTime", "getData", "()Ljava/lang/String;", "getTypeDesc", "getDependencies", "getQuery", "getEvaluationId", "getTarget", "getCategory", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "", "other", "", "hashCode", "toString", "data_transport_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class h extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f9744a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f9745b;
        private final long c;
        private final String d;
        private final String e;
        private final String f;
        private final String g;
        private final String h;
        private final String i;
        private final String j;

        public h() {
            this(0, 0, 0, null, null, null, null, null, null, null, 1023, null);
        }

        public h(int r2, long r3, long r5, String r7, String r8, String r9, String r10, String r11, String r12, String r13) {
            super(null);
            this.f9744a = r2;
            this.f9745b = r3;
            this.c = r5;
            this.d = r7;
            this.e = r8;
            this.f = r9;
            this.g = r10;
            this.h = r11;
            this.i = r12;
            this.j = r13;
        }

        public /* synthetic */ h(int r14, long r15, long r17, String r19, String r20, String r21, String r22, String r23, String r24, String r25, int r26, DefaultConstructorMarker r27) {
            if ((r26 & 1) == 0) goto L5;
            int r1 = 0;
        L6:
            long r3 = 0;
            if ((r26 & 2) == 0) goto L9;
            long r5 = 0;
        L11:
            if ((r26 & 4) != 0) goto L14;
            r3 = r17;
        L14:
            String r7 = null;
            if ((r26 & 8) == 0) goto L17;
            String r2 = null;
        L19:
            if ((r26 & 16) == 0) goto L21;
            String r8 = null;
        L23:
            if ((r26 & 32) == 0) goto L25;
            String r9 = null;
        L27:
            if ((r26 & 64) == 0) goto L29;
            String r10 = null;
        L31:
            if ((r26 & 128) == 0) goto L33;
            String r11 = null;
        L35:
            if ((r26 & 256) == 0) goto L37;
            String r12 = null;
        L39:
            if ((r26 & 512) != 0) goto L42;
            r7 = r25;
        L42:
            this(r1, r5, r3, r2, r8, r9, r10, r11, r12, r7);
            return;
        L37:
            r12 = r24;
            goto L39
        L33:
            r11 = r23;
            goto L35
        L29:
            r10 = r22;
            goto L31
        L25:
            r9 = r21;
            goto L27
        L21:
            r8 = r20;
            goto L23
        L17:
            r2 = r19;
            goto L19
        L9:
            r5 = r15;
            goto L11
        L5:
            r1 = r14;
            goto L6
        }

        public static /* synthetic */ h a(h r13, int r14, long r15, long r17, String r19, String r20, String r21, String r22, String r23, String r24, String r25, int r26, Object r27) {
            if ((r26 & 1) == 0) goto L5;
            int r2 = r13.f9744a;
        L7:
            if ((r26 & 2) == 0) goto L9;
            long r3 = r13.f9745b;
        L11:
            if ((r26 & 4) == 0) goto L13;
            long r5 = r13.c;
        L15:
            if ((r26 & 8) == 0) goto L17;
            String r7 = r13.d;
        L19:
            if ((r26 & 16) == 0) goto L21;
            String r8 = r13.e;
        L23:
            if ((r26 & 32) == 0) goto L25;
            String r9 = r13.f;
        L27:
            if ((r26 & 64) == 0) goto L29;
            String r10 = r13.g;
        L31:
            if ((r26 & 128) == 0) goto L33;
            String r11 = r13.h;
        L35:
            if ((r26 & 256) == 0) goto L37;
            String r12 = r13.i;
        L39:
            if ((r26 & 512) == 0) goto L41;
            String r1 = r13.j;
        L43:
            return r13.a(r2, r3, r5, r7, r8, r9, r10, r11, r12, r1);
        L41:
            r1 = r25;
            goto L43
        L37:
            r12 = r24;
            goto L39
        L33:
            r11 = r23;
            goto L35
        L29:
            r10 = r22;
            goto L31
        L25:
            r9 = r21;
            goto L27
        L21:
            r8 = r20;
            goto L23
        L17:
            r7 = r19;
            goto L19
        L13:
            r5 = r17;
            goto L15
        L9:
            r3 = r15;
            goto L11
        L5:
            r2 = r14;
            goto L7
        }

        public final long a() {
            return this.f9745b;
        }

        public final h a(int r15, long r16, long r18, String r20, String r21, String r22, String r23, String r24, String r25, String r26) {
            return new h(r15, r16, r18, r20, r21, r22, r23, r24, r25, r26);
        }

        public final void a(int r1) {
            this.f9744a = r1;
        }

        public final long b() {
            return this.c;
        }

        public final String c() {
            return this.d;
        }

        public final String d() {
            return this.e;
        }

        public final String e() {
            return this.f;
        }

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, h.class) == true) goto L8;
            return false;
        L8:
            h r10 = (h) ZeusTransformUtils.preCheckCast(r9, h.class, "com.obric.memorydata.plugin");
            if (this.f9744a == r10.f9744a) goto L12;
            return false;
        L12:
            if (this.f9745b == r10.f9745b) goto L15;
            return false;
        L15:
            if (this.c == r10.c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r10.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r10.e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r10.f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.g, r10.g) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.h, r10.h) == true) goto L33;
            return false;
        L33:
            if (Intrinsics.areEqual(this.i, r10.i) == true) goto L36;
            return false;
        L36:
            if (Intrinsics.areEqual(this.j, r10.j) == true) goto L38;
            return false;
        L38:
            return true;
        }

        public final String f() {
            return this.g;
        }

        public final String g() {
            return this.h;
        }

        public final int getType() {
            return this.f9744a;
        }

        public final String h() {
            return this.i;
        }

        public int hashCode() {
            int r0 = ((((Integer.hashCode(this.f9744a) * 31) + Long.hashCode(this.f9745b)) * 31) + Long.hashCode(this.c)) * 31;
            String r1 = this.d;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            String r5 = this.e;
            if (r5 != null) goto L9;
            int r6 = 0;
        L10:
            int r7 = (r4 + r6) * 31;
            String r8 = this.f;
            if (r8 != null) goto L13;
            int r9 = 0;
        L14:
            int r10 = (r7 + r9) * 31;
            String r11 = this.g;
            if (r11 != null) goto L17;
            int r12 = 0;
        L18:
            int r13 = (r10 + r12) * 31;
            String r14 = this.h;
            if (r14 != null) goto L21;
            int r15 = 0;
        L22:
            int r16 = (r13 + r15) * 31;
            String r17 = this.i;
            if (r17 != null) goto L25;
            int r18 = 0;
        L26:
            int r19 = (r16 + r18) * 31;
            String r20 = this.j;
            if (r20 == null) goto L31;
            r2 = r20.hashCode();
        L31:
            return r19 + r2;
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

        public final String i() {
            return this.j;
        }

        public String toString() {
            return "PersonalContext(type=" + this.f9744a + ", createTime=" + this.f9745b + ", lastModifiedTime=" + this.c + ", data=" + this.d + ", typeDesc=" + this.e + ", dependencies=" + this.f + ", query=" + this.g + ", evaluationId=" + this.h + ", target=" + this.i + ", category=" + this.j + ')';
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b*\b\u0086\b\u0018\u00002\u00020\u0001B\u009d\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\n\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0007HÆ\u0003J\t\u0010.\u001a\u00020\u0007HÆ\u0003J\t\u0010/\u001a\u00020\nHÆ\u0003J\t\u00100\u001a\u00020\nHÆ\u0003J\t\u00101\u001a\u00020\nHÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0014HÆ\u0003J\u009f\u0001\u00109\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u0014HÆ\u0001J\u0013\u0010:\u001a\u00020\u00032\b\u0010;\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010<\u001a\u00020\u0007HÖ\u0001J\t\u0010=\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001fR\u0011\u0010\f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001fR\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0018R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0018R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0018R\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0018R\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0018R\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0018R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)¨\u0006>"}, d2 = {"Lcom/obric/memorydata/datatransport/excel/ExcelExtra$SearchControlParams;", "", "performRanking", "", "useSemantic", "getInAppSearchParams", "limit", "", "semanticLimit", "minTextDistance", "", "minImageDistance", "minRankScore", "searchTag", "searchByClip", "searchCaption", "searchOcr", "searchName", "searchAlbum", "embeddingType", "", "<init>", "(ZZZIIDDDZZZZZZLjava/lang/String;)V", "getPerformRanking", "()Z", "getUseSemantic", "getGetInAppSearchParams", "getLimit", "()I", "getSemanticLimit", "getMinTextDistance", "()D", "getMinImageDistance", "getMinRankScore", "getSearchTag", "getSearchByClip", "getSearchCaption", "getSearchOcr", "getSearchName", "getSearchAlbum", "getEmbeddingType", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "copy", "equals", "other", "hashCode", "toString", "data_transport_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f9746a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f9747b;
        private final boolean c;
        private final int d;
        private final int e;
        private final double f;
        private final double g;
        private final double h;
        private final boolean i;
        private final boolean j;
        private final boolean k;
        private final boolean l;
        private final boolean m;
        private final boolean n;
        private final String o;

        public i() {
            this(false, false, false, 0, 0, 0.0d, 0.0d, 0.0d, false, false, false, false, false, false, null, 32767, null);
        }

        public i(boolean r5, boolean r6, boolean r7, int r8, int r9, double r10, double r12, double r14, boolean r16, boolean r17, boolean r18, boolean r19, boolean r20, boolean r21, String r22) {
            Intrinsics.checkNotNullParameter(r22, "embeddingType");
            this.f9746a = r5;
            this.f9747b = r6;
            this.c = r7;
            this.d = r8;
            this.e = r9;
            this.f = r10;
            this.g = r12;
            this.h = r14;
            this.i = r16;
            this.j = r17;
            this.k = r18;
            this.l = r19;
            this.m = r20;
            this.n = r21;
            this.o = r22;
        }

        public /* synthetic */ i(boolean r17, boolean r18, boolean r19, int r20, int r21, double r22, double r24, double r26, boolean r28, boolean r29, boolean r30, boolean r31, boolean r32, boolean r33, String r34, int r35, DefaultConstructorMarker r36) {
            if ((r35 & 1) == 0) goto L5;
            boolean r1 = true;
        L7:
            if ((r35 & 2) == 0) goto L9;
            boolean r3 = true;
        L11:
            if ((r35 & 4) == 0) goto L13;
            boolean r4 = false;
        L15:
            if ((r35 & 8) == 0) goto L17;
            int r5 = 5;
        L19:
            if ((r35 & 16) == 0) goto L21;
            int r6 = 15;
        L23:
            if ((r35 & 32) == 0) goto L25;
            double r7 = 0.5d;
        L26:
            double r10 = 0.4d;
            if ((r35 & 64) == 0) goto L29;
            double r12 = 0.4d;
        L31:
            if ((r35 & 128) != 0) goto L35;
            r10 = r26;
        L35:
            if ((r35 & 256) == 0) goto L37;
            boolean r9 = true;
        L39:
            if ((r35 & 512) == 0) goto L41;
            boolean r14 = true;
        L43:
            if ((r35 & 1024) == 0) goto L45;
            boolean r15 = true;
        L47:
            if ((r35 & 2048) == 0) goto L49;
            boolean r2 = true;
        L50:
            boolean r37 = r2;
            if ((r35 & 4096) == 0) goto L53;
            boolean r8 = true;
        L54:
            boolean r38 = r8;
            if ((r35 & 8192) == 0) goto L57;
            boolean r11 = true;
        L59:
            if ((r35 & 16384) == 0) goto L61;
            String r0 = "vlm";
        L62:
            this(r1, r3, r4, r5, r6, r7, r12, r10, r9, r14, r15, r37, r38, r11, r0);
            return;
        L61:
            r0 = r34;
            goto L62
        L57:
            r11 = r33;
            goto L59
        L53:
            r8 = r32;
            goto L54
        L49:
            r2 = r31;
            goto L50
        L45:
            r15 = r30;
            goto L47
        L41:
            r14 = r29;
            goto L43
        L37:
            r9 = r28;
            goto L39
        L29:
            r12 = r24;
            goto L31
        L25:
            r7 = r22;
            goto L26
        L21:
            r6 = r21;
            goto L23
        L17:
            r5 = r20;
            goto L19
        L13:
            r4 = r19;
            goto L15
        L9:
            r3 = r18;
            goto L11
        L5:
            r1 = r17;
            goto L7
        }

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, i.class) == true) goto L8;
            return false;
        L8:
            i r10 = (i) ZeusTransformUtils.preCheckCast(r9, i.class, "com.obric.memorydata.plugin");
            if (this.f9746a == r10.f9746a) goto L12;
            return false;
        L12:
            if (this.f9747b == r10.f9747b) goto L15;
            return false;
        L15:
            if (this.c == r10.c) goto L18;
            return false;
        L18:
            if (this.d == r10.d) goto L21;
            return false;
        L21:
            if (this.e == r10.e) goto L24;
            return false;
        L24:
            if (Double.compare(this.f, r10.f) == 0) goto L27;
            return false;
        L27:
            if (Double.compare(this.g, r10.g) == 0) goto L30;
            return false;
        L30:
            if (Double.compare(this.h, r10.h) == 0) goto L33;
            return false;
        L33:
            if (this.i == r10.i) goto L36;
            return false;
        L36:
            if (this.j == r10.j) goto L39;
            return false;
        L39:
            if (this.k == r10.k) goto L42;
            return false;
        L42:
            if (this.l == r10.l) goto L45;
            return false;
        L45:
            if (this.m == r10.m) goto L48;
            return false;
        L48:
            if (this.n == r10.n) goto L51;
            return false;
        L51:
            if (Intrinsics.areEqual(this.o, r10.o) == true) goto L53;
            return false;
        L53:
            return true;
        }

        public int hashCode() {
            return (((((((((((((((((((((((((((Boolean.hashCode(this.f9746a) * 31) + Boolean.hashCode(this.f9747b)) * 31) + Boolean.hashCode(this.c)) * 31) + Integer.hashCode(this.d)) * 31) + Integer.hashCode(this.e)) * 31) + Double.hashCode(this.f)) * 31) + Double.hashCode(this.g)) * 31) + Double.hashCode(this.h)) * 31) + Boolean.hashCode(this.i)) * 31) + Boolean.hashCode(this.j)) * 31) + Boolean.hashCode(this.k)) * 31) + Boolean.hashCode(this.l)) * 31) + Boolean.hashCode(this.m)) * 31) + Boolean.hashCode(this.n)) * 31) + this.o.hashCode();
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder();
            r0.append("SearchControlParams(performRanking=").append(this.f9746a).append(", useSemantic=").append(this.f9747b).append(", getInAppSearchParams=").append(this.c).append(", limit=").append(this.d).append(", semanticLimit=").append(this.e).append(", minTextDistance=").append(this.f).append(", minImageDistance=").append(this.g).append(", minRankScore=").append(this.h).append(", searchTag=").append(this.i).append(", searchByClip=").append(this.j).append(", searchCaption=").append(this.k).append(", searchOcr=");
            r0.append(this.l).append(", searchName=").append(this.m).append(", searchAlbum=").append(this.n).append(", embeddingType=").append(this.o).append(')');
            return r0.toString();
        }
    }

    private b() {
    }

    public /* synthetic */ b(DefaultConstructorMarker r1) {
        this();
    }
}
