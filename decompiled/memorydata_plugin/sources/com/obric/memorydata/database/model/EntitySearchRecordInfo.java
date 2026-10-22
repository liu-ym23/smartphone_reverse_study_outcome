package com.obric.memorydata.database.model;

import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.zetetic.database.sqlcipher.SQLiteDatabase;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\bo\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BÇ\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\f\u0012\b\b\u0002\u0010\u0012\u001a\u00020\f\u0012\b\b\u0002\u0010\u0013\u001a\u00020\f\u0012\b\b\u0002\u0010\u0014\u001a\u00020\f\u0012\b\b\u0002\u0010\u0015\u001a\u00020\f\u0012\b\b\u0002\u0010\u0016\u001a\u00020\f\u0012\b\b\u0002\u0010\u0017\u001a\u00020\f\u0012\b\b\u0002\u0010\u0018\u001a\u00020\f\u0012\b\b\u0002\u0010\u0019\u001a\u00020\f\u0012\b\b\u0002\u0010\u001a\u001a\u00020\f\u0012\b\b\u0002\u0010\u001b\u001a\u00020\f\u0012\b\b\u0002\u0010\u001c\u001a\u00020\f\u0012\b\b\u0002\u0010\u001d\u001a\u00020\f\u0012\b\b\u0002\u0010\u001e\u001a\u00020\f\u0012\b\b\u0002\u0010\u001f\u001a\u00020\f\u0012\b\b\u0002\u0010 \u001a\u00020\f\u0012\b\b\u0002\u0010!\u001a\u00020\f\u0012\b\b\u0002\u0010\"\u001a\u00020\f\u0012\b\b\u0002\u0010#\u001a\u00020$\u0012\b\b\u0002\u0010%\u001a\u00020&¢\u0006\u0004\b'\u0010(J\t\u0010r\u001a\u00020\u0003HÆ\u0003J\t\u0010s\u001a\u00020\u0003HÆ\u0003J\t\u0010t\u001a\u00020\u0003HÆ\u0003J\t\u0010u\u001a\u00020\u0007HÆ\u0003J\t\u0010v\u001a\u00020\u0003HÆ\u0003J\t\u0010w\u001a\u00020\u0007HÆ\u0003J\t\u0010x\u001a\u00020\u0007HÆ\u0003J\t\u0010y\u001a\u00020\fHÆ\u0003J\t\u0010z\u001a\u00020\fHÆ\u0003J\t\u0010{\u001a\u00020\fHÆ\u0003J\t\u0010|\u001a\u00020\fHÆ\u0003J\t\u0010}\u001a\u00020\fHÆ\u0003J\t\u0010~\u001a\u00020\fHÆ\u0003J\t\u0010\u007f\u001a\u00020\fHÆ\u0003J\n\u0010\u0080\u0001\u001a\u00020\fHÆ\u0003J\n\u0010\u0081\u0001\u001a\u00020\fHÆ\u0003J\n\u0010\u0082\u0001\u001a\u00020\fHÆ\u0003J\n\u0010\u0083\u0001\u001a\u00020\fHÆ\u0003J\n\u0010\u0084\u0001\u001a\u00020\fHÆ\u0003J\n\u0010\u0085\u0001\u001a\u00020\fHÆ\u0003J\n\u0010\u0086\u0001\u001a\u00020\fHÆ\u0003J\n\u0010\u0087\u0001\u001a\u00020\fHÆ\u0003J\n\u0010\u0088\u0001\u001a\u00020\fHÆ\u0003J\n\u0010\u0089\u0001\u001a\u00020\fHÆ\u0003J\n\u0010\u008a\u0001\u001a\u00020\fHÆ\u0003J\n\u0010\u008b\u0001\u001a\u00020\fHÆ\u0003J\n\u0010\u008c\u0001\u001a\u00020\fHÆ\u0003J\n\u0010\u008d\u0001\u001a\u00020\fHÆ\u0003J\n\u0010\u008e\u0001\u001a\u00020\fHÆ\u0003J\n\u0010\u008f\u0001\u001a\u00020\fHÆ\u0003J\n\u0010\u0090\u0001\u001a\u00020$HÆ\u0003J\n\u0010\u0091\u0001\u001a\u00020&HÆ\u0003JÊ\u0002\u0010\u0092\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\f2\b\b\u0002\u0010\u0011\u001a\u00020\f2\b\b\u0002\u0010\u0012\u001a\u00020\f2\b\b\u0002\u0010\u0013\u001a\u00020\f2\b\b\u0002\u0010\u0014\u001a\u00020\f2\b\b\u0002\u0010\u0015\u001a\u00020\f2\b\b\u0002\u0010\u0016\u001a\u00020\f2\b\b\u0002\u0010\u0017\u001a\u00020\f2\b\b\u0002\u0010\u0018\u001a\u00020\f2\b\b\u0002\u0010\u0019\u001a\u00020\f2\b\b\u0002\u0010\u001a\u001a\u00020\f2\b\b\u0002\u0010\u001b\u001a\u00020\f2\b\b\u0002\u0010\u001c\u001a\u00020\f2\b\b\u0002\u0010\u001d\u001a\u00020\f2\b\b\u0002\u0010\u001e\u001a\u00020\f2\b\b\u0002\u0010\u001f\u001a\u00020\f2\b\b\u0002\u0010 \u001a\u00020\f2\b\b\u0002\u0010!\u001a\u00020\f2\b\b\u0002\u0010\"\u001a\u00020\f2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&HÆ\u0001J\u0015\u0010\u0093\u0001\u001a\u00020$2\t\u0010\u0094\u0001\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u000b\u0010\u0095\u0001\u001a\u00030\u0096\u0001HÖ\u0001J\n\u0010\u0097\u0001\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010*\"\u0004\b.\u0010,R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010*\"\u0004\b0\u0010,R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010*\"\u0004\b6\u0010,R\u001a\u0010\t\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00102\"\u0004\b8\u00104R\u001a\u0010\n\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u00102\"\u0004\b:\u00104R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001a\u0010\r\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010<\"\u0004\b@\u0010>R\u001a\u0010\u000e\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010<\"\u0004\bB\u0010>R\u001a\u0010\u000f\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010<\"\u0004\bD\u0010>R\u001a\u0010\u0010\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010<\"\u0004\bF\u0010>R\u001a\u0010\u0011\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010<\"\u0004\bH\u0010>R\u001a\u0010\u0012\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010<\"\u0004\bJ\u0010>R\u001a\u0010\u0013\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010<\"\u0004\bL\u0010>R\u001a\u0010\u0014\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010<\"\u0004\bN\u0010>R\u001a\u0010\u0015\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010<\"\u0004\bP\u0010>R\u001a\u0010\u0016\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010<\"\u0004\bR\u0010>R\u001a\u0010\u0017\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010<\"\u0004\bT\u0010>R\u001a\u0010\u0018\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010<\"\u0004\bV\u0010>R\u001a\u0010\u0019\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010<\"\u0004\bX\u0010>R\u001a\u0010\u001a\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010<\"\u0004\bZ\u0010>R\u001a\u0010\u001b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010<\"\u0004\b\\\u0010>R\u001a\u0010\u001c\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010<\"\u0004\b^\u0010>R\u001a\u0010\u001d\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010<\"\u0004\b`\u0010>R\u001a\u0010\u001e\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\ba\u0010<\"\u0004\bb\u0010>R\u001a\u0010\u001f\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010<\"\u0004\bd\u0010>R\u001a\u0010 \u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010<\"\u0004\bf\u0010>R\u001a\u0010!\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bg\u0010<\"\u0004\bh\u0010>R\u001a\u0010\"\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bi\u0010<\"\u0004\bj\u0010>R\u001a\u0010#\u001a\u00020$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010k\"\u0004\bl\u0010mR\u001a\u0010%\u001a\u00020&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bn\u0010o\"\u0004\bp\u0010q¨\u0006\u0098\u0001"}, d2 = {"Lcom/obric/memorydata/database/model/EntitySearchRecordInfo;", "", "taskUUID", "", ObricMemoryConstants.KEY_PACKAGE_NAME, "type", "startTime", "", "searchCallType", "realPackageStartTime", "realPackageQueryStartTime", "stageQueryUnderstandingCost", "", "stageSearchParamPrepareCost", "stageTaskExecuteCost", "stageResultHandleCost", "queryUnderstandingCost", "sqlQueryCost", "keywordQueryCost", "packageExecuteCost", "packagePureExecuteCost", "packageQueryExecuteCost", "packageExecuteFinishCost", "textVectorQueryCost", "imageVectorQueryCost", "rankingCost", "taskExecuteCost", "loadResultCost", "kgQueryCost", "graphExecuteCost", "buildGraphCost", "sortAndFilterCost", "notifySearchResultCost", "firstBatchResultCost", "queryTotalCost", "isInAppOptimizedSearch", "", "jsonObject", "Lorg/json/JSONObject;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JJDDDDDDDDDDDDDDDDDDDDDDDZLorg/json/JSONObject;)V", "getTaskUUID", "()Ljava/lang/String;", "setTaskUUID", "(Ljava/lang/String;)V", "getPackageName", "setPackageName", "getType", "setType", "getStartTime", "()J", "setStartTime", "(J)V", "getSearchCallType", "setSearchCallType", "getRealPackageStartTime", "setRealPackageStartTime", "getRealPackageQueryStartTime", "setRealPackageQueryStartTime", "getStageQueryUnderstandingCost", "()D", "setStageQueryUnderstandingCost", "(D)V", "getStageSearchParamPrepareCost", "setStageSearchParamPrepareCost", "getStageTaskExecuteCost", "setStageTaskExecuteCost", "getStageResultHandleCost", "setStageResultHandleCost", "getQueryUnderstandingCost", "setQueryUnderstandingCost", "getSqlQueryCost", "setSqlQueryCost", "getKeywordQueryCost", "setKeywordQueryCost", "getPackageExecuteCost", "setPackageExecuteCost", "getPackagePureExecuteCost", "setPackagePureExecuteCost", "getPackageQueryExecuteCost", "setPackageQueryExecuteCost", "getPackageExecuteFinishCost", "setPackageExecuteFinishCost", "getTextVectorQueryCost", "setTextVectorQueryCost", "getImageVectorQueryCost", "setImageVectorQueryCost", "getRankingCost", "setRankingCost", "getTaskExecuteCost", "setTaskExecuteCost", "getLoadResultCost", "setLoadResultCost", "getKgQueryCost", "setKgQueryCost", "getGraphExecuteCost", "setGraphExecuteCost", "getBuildGraphCost", "setBuildGraphCost", "getSortAndFilterCost", "setSortAndFilterCost", "getNotifySearchResultCost", "setNotifySearchResultCost", "getFirstBatchResultCost", "setFirstBatchResultCost", "getQueryTotalCost", "setQueryTotalCost", "()Z", "setInAppOptimizedSearch", "(Z)V", "getJsonObject", "()Lorg/json/JSONObject;", "setJsonObject", "(Lorg/json/JSONObject;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "copy", "equals", "other", "hashCode", "", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class EntitySearchRecordInfo {
    private double buildGraphCost;
    private double firstBatchResultCost;
    private double graphExecuteCost;
    private double imageVectorQueryCost;
    private boolean isInAppOptimizedSearch;
    private JSONObject jsonObject;
    private double keywordQueryCost;
    private double kgQueryCost;
    private double loadResultCost;
    private double notifySearchResultCost;
    private double packageExecuteCost;
    private double packageExecuteFinishCost;
    private String packageName;
    private double packagePureExecuteCost;
    private double packageQueryExecuteCost;
    private double queryTotalCost;
    private double queryUnderstandingCost;
    private double rankingCost;
    private long realPackageQueryStartTime;
    private long realPackageStartTime;
    private String searchCallType;
    private double sortAndFilterCost;
    private double sqlQueryCost;
    private double stageQueryUnderstandingCost;
    private double stageResultHandleCost;
    private double stageSearchParamPrepareCost;
    private double stageTaskExecuteCost;
    private long startTime;
    private double taskExecuteCost;
    private String taskUUID;
    private double textVectorQueryCost;
    private String type;

    public EntitySearchRecordInfo() {
        this(null, null, null, 0, null, 0, 0, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, false, null, -1, null);
    }

    public EntitySearchRecordInfo(String r8, String r9, String r10, long r11, String r13, long r14, long r16, double r18, double r20, double r22, double r24, double r26, double r28, double r30, double r32, double r34, double r36, double r38, double r40, double r42, double r44, double r46, double r48, double r50, double r52, double r54, double r56, double r58, double r60, double r62, boolean r64, JSONObject r65) {
        Intrinsics.checkNotNullParameter(r8, "taskUUID");
        Intrinsics.checkNotNullParameter(r9, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r10, "type");
        Intrinsics.checkNotNullParameter(r13, "searchCallType");
        Intrinsics.checkNotNullParameter(r65, "jsonObject");
        this.taskUUID = r8;
        this.packageName = r9;
        this.type = r10;
        this.startTime = r11;
        this.searchCallType = r13;
        this.realPackageStartTime = r14;
        this.realPackageQueryStartTime = r16;
        this.stageQueryUnderstandingCost = r18;
        this.stageSearchParamPrepareCost = r20;
        this.stageTaskExecuteCost = r22;
        this.stageResultHandleCost = r24;
        this.queryUnderstandingCost = r26;
        this.sqlQueryCost = r28;
        this.keywordQueryCost = r30;
        this.packageExecuteCost = r32;
        this.packagePureExecuteCost = r34;
        this.packageQueryExecuteCost = r36;
        this.packageExecuteFinishCost = r38;
        this.textVectorQueryCost = r40;
        this.imageVectorQueryCost = r42;
        this.rankingCost = r44;
        this.taskExecuteCost = r46;
        this.loadResultCost = r48;
        this.kgQueryCost = r50;
        this.graphExecuteCost = r52;
        this.buildGraphCost = r54;
        this.sortAndFilterCost = r56;
        this.notifySearchResultCost = r58;
        this.firstBatchResultCost = r60;
        this.queryTotalCost = r62;
        this.isInAppOptimizedSearch = r64;
        this.jsonObject = r65;
    }

    public /* synthetic */ EntitySearchRecordInfo(String r60, String r61, String r62, long r63, String r65, long r66, long r68, double r70, double r72, double r74, double r76, double r78, double r80, double r82, double r84, double r86, double r88, double r90, double r92, double r94, double r96, double r98, double r100, double r102, double r104, double r106, double r108, double r110, double r112, double r114, boolean r116, JSONObject r117, int r118, DefaultConstructorMarker r119) {
        String r2 = "";
        if ((r118 & 1) == 0) goto L5;
        String r1 = "";
    L7:
        if ((r118 & 2) == 0) goto L9;
        String r3 = "";
    L11:
        if ((r118 & 4) == 0) goto L13;
        String r4 = "";
    L15:
        if ((r118 & 8) == 0) goto L17;
        long r5 = System.currentTimeMillis();
    L19:
        if ((r118 & 16) != 0) goto L22;
        r2 = r65;
    L22:
        long r8 = 0;
        if ((r118 & 32) == 0) goto L25;
        long r10 = 0;
    L27:
        if ((r118 & 64) != 0) goto L30;
        r8 = r68;
    L30:
        double r12 = 0.0d;
        if ((r118 & 128) == 0) goto L33;
        double r14 = 0.0d;
    L35:
        if ((r118 & 256) == 0) goto L37;
        double r16 = 0.0d;
    L39:
        if ((r118 & 512) == 0) goto L41;
        double r18 = 0.0d;
    L43:
        if ((r118 & 1024) == 0) goto L45;
        double r20 = 0.0d;
    L47:
        if ((r118 & 2048) == 0) goto L49;
        double r22 = 0.0d;
    L51:
        if ((r118 & 4096) == 0) goto L53;
        double r24 = 0.0d;
    L55:
        if ((r118 & 8192) == 0) goto L57;
        double r26 = 0.0d;
    L59:
        if ((r118 & 16384) == 0) goto L61;
        double r28 = 0.0d;
    L63:
        if ((32768 & r118) == 0) goto L65;
        double r30 = 0.0d;
    L67:
        if ((65536 & r118) == 0) goto L69;
        double r32 = 0.0d;
    L71:
        if ((131072 & r118) == 0) goto L73;
        double r34 = 0.0d;
    L75:
        if ((262144 & r118) == 0) goto L77;
        double r36 = 0.0d;
    L79:
        if ((524288 & r118) == 0) goto L81;
        double r38 = 0.0d;
    L83:
        if ((1048576 & r118) == 0) goto L85;
        double r40 = 0.0d;
    L87:
        if ((2097152 & r118) == 0) goto L89;
        double r42 = 0.0d;
    L91:
        if ((4194304 & r118) == 0) goto L93;
        double r44 = 0.0d;
    L95:
        if ((8388608 & r118) == 0) goto L97;
        double r46 = 0.0d;
    L99:
        if ((16777216 & r118) == 0) goto L101;
        double r48 = 0.0d;
    L103:
        if ((33554432 & r118) == 0) goto L105;
        double r50 = 0.0d;
    L107:
        if ((67108864 & r118) == 0) goto L109;
        double r52 = 0.0d;
    L111:
        if ((134217728 & r118) == 0) goto L113;
        double r54 = 0.0d;
    L115:
        if ((268435456 & r118) == 0) goto L117;
        double r56 = 0.0d;
    L119:
        if ((536870912 & r118) != 0) goto L123;
        r12 = r114;
    L123:
        if ((1073741824 & r118) == 0) goto L125;
        boolean r7 = false;
    L127:
        if ((r118 & Integer.MIN_VALUE) == 0) goto L129;
        JSONObject r0 = new JSONObject();
    L130:
        this(r1, r3, r4, r5, r2, r10, r8, r14, r16, r18, r20, r22, r24, r26, r28, r30, r32, r34, r36, r38, r40, r42, r44, r46, r48, r50, r52, r54, r56, r12, r7, r0);
        return;
    L129:
        r0 = r117;
        goto L130
    L125:
        r7 = r116;
        goto L127
    L117:
        r56 = r112;
        goto L119
    L113:
        r54 = r110;
        goto L115
    L109:
        r52 = r108;
        goto L111
    L105:
        r50 = r106;
        goto L107
    L101:
        r48 = r104;
        goto L103
    L97:
        r46 = r102;
        goto L99
    L93:
        r44 = r100;
        goto L95
    L89:
        r42 = r98;
        goto L91
    L85:
        r40 = r96;
        goto L87
    L81:
        r38 = r94;
        goto L83
    L77:
        r36 = r92;
        goto L79
    L73:
        r34 = r90;
        goto L75
    L69:
        r32 = r88;
        goto L71
    L65:
        r30 = r86;
        goto L67
    L61:
        r28 = r84;
        goto L63
    L57:
        r26 = r82;
        goto L59
    L53:
        r24 = r80;
        goto L55
    L49:
        r22 = r78;
        goto L51
    L45:
        r20 = r76;
        goto L47
    L41:
        r18 = r74;
        goto L43
    L37:
        r16 = r72;
        goto L39
    L33:
        r14 = r70;
        goto L35
    L25:
        r10 = r66;
        goto L27
    L17:
        r5 = r63;
        goto L19
    L13:
        r4 = r62;
        goto L15
    L9:
        r3 = r61;
        goto L11
    L5:
        r1 = r60;
        goto L7
    }

    public static /* synthetic */ EntitySearchRecordInfo copy$default(EntitySearchRecordInfo r17, String r18, String r19, String r20, long r21, String r23, long r24, long r26, double r28, double r30, double r32, double r34, double r36, double r38, double r40, double r42, double r44, double r46, double r48, double r50, double r52, double r54, double r56, double r58, double r60, double r62, double r64, double r66, double r68, double r70, double r72, boolean r74, JSONObject r75, int r76, Object r77) {
        if ((r76 & 1) == 0) goto L5;
        String r2 = r17.taskUUID;
    L7:
        if ((r76 & 2) == 0) goto L9;
        String r3 = r17.packageName;
    L11:
        if ((r76 & 4) == 0) goto L13;
        String r4 = r17.type;
    L15:
        if ((r76 & 8) == 0) goto L17;
        long r5 = r17.startTime;
    L19:
        if ((r76 & 16) == 0) goto L21;
        String r7 = r17.searchCallType;
    L23:
        if ((r76 & 32) == 0) goto L25;
        long r8 = r17.realPackageStartTime;
    L27:
        if ((r76 & 64) == 0) goto L29;
        long r10 = r17.realPackageQueryStartTime;
    L31:
        if ((r76 & 128) == 0) goto L33;
        double r12 = r17.stageQueryUnderstandingCost;
    L35:
        if ((r76 & 256) == 0) goto L37;
        double r14 = r17.stageSearchParamPrepareCost;
    L38:
        double r31 = r14;
        if ((r76 & 512) == 0) goto L41;
        double r15 = r17.stageTaskExecuteCost;
    L42:
        double r33 = r15;
        if ((r76 & 1024) == 0) goto L45;
        double r16 = r17.stageResultHandleCost;
    L46:
        double r35 = r16;
        if ((r76 & 2048) == 0) goto L49;
        double r110 = r17.queryUnderstandingCost;
    L50:
        double r37 = r110;
        if ((r76 & 4096) == 0) goto L53;
        double r111 = r17.sqlQueryCost;
    L54:
        double r39 = r111;
        if ((r76 & 8192) == 0) goto L57;
        double r112 = r17.keywordQueryCost;
    L58:
        double r41 = r112;
        if ((r76 & 16384) == 0) goto L61;
        double r113 = r17.packageExecuteCost;
    L62:
        double r43 = r113;
        if ((r76 & 32768) == 0) goto L65;
        double r114 = r17.packagePureExecuteCost;
    L66:
        double r45 = r114;
        if ((r76 & 65536) == 0) goto L69;
        double r115 = r17.packageQueryExecuteCost;
    L70:
        double r47 = r115;
        if ((r76 & 131072) == 0) goto L73;
        double r116 = r17.packageExecuteFinishCost;
    L74:
        double r49 = r116;
        if ((r76 & 262144) == 0) goto L77;
        double r117 = r17.textVectorQueryCost;
    L78:
        double r51 = r117;
        if ((r76 & 524288) == 0) goto L81;
        double r118 = r17.imageVectorQueryCost;
    L82:
        double r53 = r118;
        if ((r76 & 1048576) == 0) goto L85;
        double r119 = r17.rankingCost;
    L86:
        double r55 = r119;
        if ((r76 & 2097152) == 0) goto L89;
        double r120 = r17.taskExecuteCost;
    L90:
        double r57 = r120;
        if ((r76 & 4194304) == 0) goto L93;
        double r121 = r17.loadResultCost;
    L94:
        double r59 = r121;
        if ((r76 & 8388608) == 0) goto L97;
        double r122 = r17.kgQueryCost;
    L98:
        double r61 = r122;
        if ((r76 & 16777216) == 0) goto L101;
        double r123 = r17.graphExecuteCost;
    L102:
        double r63 = r123;
        if ((r76 & 33554432) == 0) goto L105;
        double r124 = r17.buildGraphCost;
    L106:
        double r65 = r124;
        if ((r76 & AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) == 0) goto L109;
        double r125 = r17.sortAndFilterCost;
    L110:
        double r67 = r125;
        if ((r76 & 134217728) == 0) goto L113;
        double r126 = r17.notifySearchResultCost;
    L114:
        double r69 = r126;
        if ((r76 & SQLiteDatabase.CREATE_IF_NECESSARY) == 0) goto L117;
        double r127 = r17.firstBatchResultCost;
    L118:
        double r71 = r127;
        if ((r76 & SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING) == 0) goto L121;
        double r128 = r17.queryTotalCost;
    L122:
        double r73 = r128;
        if ((r76 & 1073741824) == 0) goto L125;
        boolean r129 = r17.isInAppOptimizedSearch;
    L127:
        if ((r76 & Integer.MIN_VALUE) == 0) goto L129;
        JSONObject r1 = r17.jsonObject;
    L131:
        return r17.copy(r2, r3, r4, r5, r7, r8, r10, r12, r31, r33, r35, r37, r39, r41, r43, r45, r47, r49, r51, r53, r55, r57, r59, r61, r63, r65, r67, r69, r71, r73, r129, r1);
    L129:
        r1 = r75;
        goto L131
    L125:
        r129 = r74;
        goto L127
    L121:
        r128 = r72;
        goto L122
    L117:
        r127 = r70;
        goto L118
    L113:
        r126 = r68;
        goto L114
    L109:
        r125 = r66;
        goto L110
    L105:
        r124 = r64;
        goto L106
    L101:
        r123 = r62;
        goto L102
    L97:
        r122 = r60;
        goto L98
    L93:
        r121 = r58;
        goto L94
    L89:
        r120 = r56;
        goto L90
    L85:
        r119 = r54;
        goto L86
    L81:
        r118 = r52;
        goto L82
    L77:
        r117 = r50;
        goto L78
    L73:
        r116 = r48;
        goto L74
    L69:
        r115 = r46;
        goto L70
    L65:
        r114 = r44;
        goto L66
    L61:
        r113 = r42;
        goto L62
    L57:
        r112 = r40;
        goto L58
    L53:
        r111 = r38;
        goto L54
    L49:
        r110 = r36;
        goto L50
    L45:
        r16 = r34;
        goto L46
    L41:
        r15 = r32;
        goto L42
    L37:
        r14 = r30;
        goto L38
    L33:
        r12 = r28;
        goto L35
    L29:
        r10 = r26;
        goto L31
    L25:
        r8 = r24;
        goto L27
    L21:
        r7 = r23;
        goto L23
    L17:
        r5 = r21;
        goto L19
    L13:
        r4 = r20;
        goto L15
    L9:
        r3 = r19;
        goto L11
    L5:
        r2 = r18;
        goto L7
    }

    public final String component1() {
        return this.taskUUID;
    }

    public final double component10() {
        return this.stageTaskExecuteCost;
    }

    public final double component11() {
        return this.stageResultHandleCost;
    }

    public final double component12() {
        return this.queryUnderstandingCost;
    }

    public final double component13() {
        return this.sqlQueryCost;
    }

    public final double component14() {
        return this.keywordQueryCost;
    }

    public final double component15() {
        return this.packageExecuteCost;
    }

    public final double component16() {
        return this.packagePureExecuteCost;
    }

    public final double component17() {
        return this.packageQueryExecuteCost;
    }

    public final double component18() {
        return this.packageExecuteFinishCost;
    }

    public final double component19() {
        return this.textVectorQueryCost;
    }

    public final String component2() {
        return this.packageName;
    }

    public final double component20() {
        return this.imageVectorQueryCost;
    }

    public final double component21() {
        return this.rankingCost;
    }

    public final double component22() {
        return this.taskExecuteCost;
    }

    public final double component23() {
        return this.loadResultCost;
    }

    public final double component24() {
        return this.kgQueryCost;
    }

    public final double component25() {
        return this.graphExecuteCost;
    }

    public final double component26() {
        return this.buildGraphCost;
    }

    public final double component27() {
        return this.sortAndFilterCost;
    }

    public final double component28() {
        return this.notifySearchResultCost;
    }

    public final double component29() {
        return this.firstBatchResultCost;
    }

    public final String component3() {
        return this.type;
    }

    public final double component30() {
        return this.queryTotalCost;
    }

    public final boolean component31() {
        return this.isInAppOptimizedSearch;
    }

    public final JSONObject component32() {
        return this.jsonObject;
    }

    public final long component4() {
        return this.startTime;
    }

    public final String component5() {
        return this.searchCallType;
    }

    public final long component6() {
        return this.realPackageStartTime;
    }

    public final long component7() {
        return this.realPackageQueryStartTime;
    }

    public final double component8() {
        return this.stageQueryUnderstandingCost;
    }

    public final double component9() {
        return this.stageSearchParamPrepareCost;
    }

    public final EntitySearchRecordInfo copy(String r61, String r62, String r63, long r64, String r66, long r67, long r69, double r71, double r73, double r75, double r77, double r79, double r81, double r83, double r85, double r87, double r89, double r91, double r93, double r95, double r97, double r99, double r101, double r103, double r105, double r107, double r109, double r111, double r113, double r115, boolean r117, JSONObject r118) {
        Intrinsics.checkNotNullParameter(r61, "taskUUID");
        Intrinsics.checkNotNullParameter(r62, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r63, "type");
        Intrinsics.checkNotNullParameter(r66, "searchCallType");
        Intrinsics.checkNotNullParameter(r118, "jsonObject");
        return new EntitySearchRecordInfo(r61, r62, r63, r64, r66, r67, r69, r71, r73, r75, r77, r79, r81, r83, r85, r87, r89, r91, r93, r95, r97, r99, r101, r103, r105, r107, r109, r111, r113, r115, r117, r118);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, EntitySearchRecordInfo.class) == true) goto L8;
        return false;
    L8:
        EntitySearchRecordInfo r10 = (EntitySearchRecordInfo) ZeusTransformUtils.preCheckCast(r9, EntitySearchRecordInfo.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.taskUUID, r10.taskUUID) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.packageName, r10.packageName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.type, r10.type) == true) goto L18;
        return false;
    L18:
        if (this.startTime == r10.startTime) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.searchCallType, r10.searchCallType) == true) goto L24;
        return false;
    L24:
        if (this.realPackageStartTime == r10.realPackageStartTime) goto L27;
        return false;
    L27:
        if (this.realPackageQueryStartTime == r10.realPackageQueryStartTime) goto L30;
        return false;
    L30:
        if (Double.compare(this.stageQueryUnderstandingCost, r10.stageQueryUnderstandingCost) == 0) goto L33;
        return false;
    L33:
        if (Double.compare(this.stageSearchParamPrepareCost, r10.stageSearchParamPrepareCost) == 0) goto L36;
        return false;
    L36:
        if (Double.compare(this.stageTaskExecuteCost, r10.stageTaskExecuteCost) == 0) goto L39;
        return false;
    L39:
        if (Double.compare(this.stageResultHandleCost, r10.stageResultHandleCost) == 0) goto L42;
        return false;
    L42:
        if (Double.compare(this.queryUnderstandingCost, r10.queryUnderstandingCost) == 0) goto L45;
        return false;
    L45:
        if (Double.compare(this.sqlQueryCost, r10.sqlQueryCost) == 0) goto L48;
        return false;
    L48:
        if (Double.compare(this.keywordQueryCost, r10.keywordQueryCost) == 0) goto L51;
        return false;
    L51:
        if (Double.compare(this.packageExecuteCost, r10.packageExecuteCost) == 0) goto L54;
        return false;
    L54:
        if (Double.compare(this.packagePureExecuteCost, r10.packagePureExecuteCost) == 0) goto L57;
        return false;
    L57:
        if (Double.compare(this.packageQueryExecuteCost, r10.packageQueryExecuteCost) == 0) goto L60;
        return false;
    L60:
        if (Double.compare(this.packageExecuteFinishCost, r10.packageExecuteFinishCost) == 0) goto L63;
        return false;
    L63:
        if (Double.compare(this.textVectorQueryCost, r10.textVectorQueryCost) == 0) goto L66;
        return false;
    L66:
        if (Double.compare(this.imageVectorQueryCost, r10.imageVectorQueryCost) == 0) goto L69;
        return false;
    L69:
        if (Double.compare(this.rankingCost, r10.rankingCost) == 0) goto L72;
        return false;
    L72:
        if (Double.compare(this.taskExecuteCost, r10.taskExecuteCost) == 0) goto L75;
        return false;
    L75:
        if (Double.compare(this.loadResultCost, r10.loadResultCost) == 0) goto L78;
        return false;
    L78:
        if (Double.compare(this.kgQueryCost, r10.kgQueryCost) == 0) goto L81;
        return false;
    L81:
        if (Double.compare(this.graphExecuteCost, r10.graphExecuteCost) == 0) goto L84;
        return false;
    L84:
        if (Double.compare(this.buildGraphCost, r10.buildGraphCost) == 0) goto L87;
        return false;
    L87:
        if (Double.compare(this.sortAndFilterCost, r10.sortAndFilterCost) == 0) goto L90;
        return false;
    L90:
        if (Double.compare(this.notifySearchResultCost, r10.notifySearchResultCost) == 0) goto L93;
        return false;
    L93:
        if (Double.compare(this.firstBatchResultCost, r10.firstBatchResultCost) == 0) goto L96;
        return false;
    L96:
        if (Double.compare(this.queryTotalCost, r10.queryTotalCost) == 0) goto L99;
        return false;
    L99:
        if (this.isInAppOptimizedSearch == r10.isInAppOptimizedSearch) goto L102;
        return false;
    L102:
        if (Intrinsics.areEqual(this.jsonObject, r10.jsonObject) == true) goto L104;
        return false;
    L104:
        return true;
    }

    public final double getBuildGraphCost() {
        return this.buildGraphCost;
    }

    public final double getFirstBatchResultCost() {
        return this.firstBatchResultCost;
    }

    public final double getGraphExecuteCost() {
        return this.graphExecuteCost;
    }

    public final double getImageVectorQueryCost() {
        return this.imageVectorQueryCost;
    }

    public final JSONObject getJsonObject() {
        return this.jsonObject;
    }

    public final double getKeywordQueryCost() {
        return this.keywordQueryCost;
    }

    public final double getKgQueryCost() {
        return this.kgQueryCost;
    }

    public final double getLoadResultCost() {
        return this.loadResultCost;
    }

    public final double getNotifySearchResultCost() {
        return this.notifySearchResultCost;
    }

    public final double getPackageExecuteCost() {
        return this.packageExecuteCost;
    }

    public final double getPackageExecuteFinishCost() {
        return this.packageExecuteFinishCost;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final double getPackagePureExecuteCost() {
        return this.packagePureExecuteCost;
    }

    public final double getPackageQueryExecuteCost() {
        return this.packageQueryExecuteCost;
    }

    public final double getQueryTotalCost() {
        return this.queryTotalCost;
    }

    public final double getQueryUnderstandingCost() {
        return this.queryUnderstandingCost;
    }

    public final double getRankingCost() {
        return this.rankingCost;
    }

    public final long getRealPackageQueryStartTime() {
        return this.realPackageQueryStartTime;
    }

    public final long getRealPackageStartTime() {
        return this.realPackageStartTime;
    }

    public final String getSearchCallType() {
        return this.searchCallType;
    }

    public final double getSortAndFilterCost() {
        return this.sortAndFilterCost;
    }

    public final double getSqlQueryCost() {
        return this.sqlQueryCost;
    }

    public final double getStageQueryUnderstandingCost() {
        return this.stageQueryUnderstandingCost;
    }

    public final double getStageResultHandleCost() {
        return this.stageResultHandleCost;
    }

    public final double getStageSearchParamPrepareCost() {
        return this.stageSearchParamPrepareCost;
    }

    public final double getStageTaskExecuteCost() {
        return this.stageTaskExecuteCost;
    }

    public final long getStartTime() {
        return this.startTime;
    }

    public final double getTaskExecuteCost() {
        return this.taskExecuteCost;
    }

    public final String getTaskUUID() {
        return this.taskUUID;
    }

    public final double getTextVectorQueryCost() {
        return this.textVectorQueryCost;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((this.taskUUID.hashCode() * 31) + this.packageName.hashCode()) * 31) + this.type.hashCode()) * 31) + Long.hashCode(this.startTime)) * 31) + this.searchCallType.hashCode()) * 31) + Long.hashCode(this.realPackageStartTime)) * 31) + Long.hashCode(this.realPackageQueryStartTime)) * 31) + Double.hashCode(this.stageQueryUnderstandingCost)) * 31) + Double.hashCode(this.stageSearchParamPrepareCost)) * 31) + Double.hashCode(this.stageTaskExecuteCost)) * 31) + Double.hashCode(this.stageResultHandleCost)) * 31) + Double.hashCode(this.queryUnderstandingCost)) * 31) + Double.hashCode(this.sqlQueryCost)) * 31) + Double.hashCode(this.keywordQueryCost)) * 31) + Double.hashCode(this.packageExecuteCost)) * 31) + Double.hashCode(this.packagePureExecuteCost)) * 31) + Double.hashCode(this.packageQueryExecuteCost)) * 31) + Double.hashCode(this.packageExecuteFinishCost)) * 31) + Double.hashCode(this.textVectorQueryCost)) * 31) + Double.hashCode(this.imageVectorQueryCost)) * 31) + Double.hashCode(this.rankingCost)) * 31) + Double.hashCode(this.taskExecuteCost)) * 31) + Double.hashCode(this.loadResultCost)) * 31) + Double.hashCode(this.kgQueryCost)) * 31) + Double.hashCode(this.graphExecuteCost)) * 31) + Double.hashCode(this.buildGraphCost)) * 31) + Double.hashCode(this.sortAndFilterCost)) * 31) + Double.hashCode(this.notifySearchResultCost)) * 31) + Double.hashCode(this.firstBatchResultCost)) * 31) + Double.hashCode(this.queryTotalCost)) * 31) + Boolean.hashCode(this.isInAppOptimizedSearch)) * 31) + this.jsonObject.hashCode();
    }

    public final boolean isInAppOptimizedSearch() {
        return this.isInAppOptimizedSearch;
    }

    public final void setBuildGraphCost(double r1) {
        this.buildGraphCost = r1;
    }

    public final void setFirstBatchResultCost(double r1) {
        this.firstBatchResultCost = r1;
    }

    public final void setGraphExecuteCost(double r1) {
        this.graphExecuteCost = r1;
    }

    public final void setImageVectorQueryCost(double r1) {
        this.imageVectorQueryCost = r1;
    }

    public final void setInAppOptimizedSearch(boolean r1) {
        this.isInAppOptimizedSearch = r1;
    }

    public final void setJsonObject(JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.jsonObject = r2;
    }

    public final void setKeywordQueryCost(double r1) {
        this.keywordQueryCost = r1;
    }

    public final void setKgQueryCost(double r1) {
        this.kgQueryCost = r1;
    }

    public final void setLoadResultCost(double r1) {
        this.loadResultCost = r1;
    }

    public final void setNotifySearchResultCost(double r1) {
        this.notifySearchResultCost = r1;
    }

    public final void setPackageExecuteCost(double r1) {
        this.packageExecuteCost = r1;
    }

    public final void setPackageExecuteFinishCost(double r1) {
        this.packageExecuteFinishCost = r1;
    }

    public final void setPackageName(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.packageName = r2;
    }

    public final void setPackagePureExecuteCost(double r1) {
        this.packagePureExecuteCost = r1;
    }

    public final void setPackageQueryExecuteCost(double r1) {
        this.packageQueryExecuteCost = r1;
    }

    public final void setQueryTotalCost(double r1) {
        this.queryTotalCost = r1;
    }

    public final void setQueryUnderstandingCost(double r1) {
        this.queryUnderstandingCost = r1;
    }

    public final void setRankingCost(double r1) {
        this.rankingCost = r1;
    }

    public final void setRealPackageQueryStartTime(long r1) {
        this.realPackageQueryStartTime = r1;
    }

    public final void setRealPackageStartTime(long r1) {
        this.realPackageStartTime = r1;
    }

    public final void setSearchCallType(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.searchCallType = r2;
    }

    public final void setSortAndFilterCost(double r1) {
        this.sortAndFilterCost = r1;
    }

    public final void setSqlQueryCost(double r1) {
        this.sqlQueryCost = r1;
    }

    public final void setStageQueryUnderstandingCost(double r1) {
        this.stageQueryUnderstandingCost = r1;
    }

    public final void setStageResultHandleCost(double r1) {
        this.stageResultHandleCost = r1;
    }

    public final void setStageSearchParamPrepareCost(double r1) {
        this.stageSearchParamPrepareCost = r1;
    }

    public final void setStageTaskExecuteCost(double r1) {
        this.stageTaskExecuteCost = r1;
    }

    public final void setStartTime(long r1) {
        this.startTime = r1;
    }

    public final void setTaskExecuteCost(double r1) {
        this.taskExecuteCost = r1;
    }

    public final void setTaskUUID(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.taskUUID = r2;
    }

    public final void setTextVectorQueryCost(double r1) {
        this.textVectorQueryCost = r1;
    }

    public final void setType(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.type = r2;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("EntitySearchRecordInfo(taskUUID=").append(this.taskUUID).append(", packageName=").append(this.packageName).append(", type=").append(this.type).append(", startTime=").append(this.startTime).append(", searchCallType=").append(this.searchCallType).append(", realPackageStartTime=").append(this.realPackageStartTime).append(", realPackageQueryStartTime=").append(this.realPackageQueryStartTime).append(", stageQueryUnderstandingCost=").append(this.stageQueryUnderstandingCost).append(", stageSearchParamPrepareCost=").append(this.stageSearchParamPrepareCost).append(", stageTaskExecuteCost=").append(this.stageTaskExecuteCost).append(", stageResultHandleCost=").append(this.stageResultHandleCost).append(", queryUnderstandingCost=");
        r0.append(this.queryUnderstandingCost).append(", sqlQueryCost=").append(this.sqlQueryCost).append(", keywordQueryCost=").append(this.keywordQueryCost).append(", packageExecuteCost=").append(this.packageExecuteCost).append(", packagePureExecuteCost=").append(this.packagePureExecuteCost).append(", packageQueryExecuteCost=").append(this.packageQueryExecuteCost).append(", packageExecuteFinishCost=").append(this.packageExecuteFinishCost).append(", textVectorQueryCost=").append(this.textVectorQueryCost).append(", imageVectorQueryCost=").append(this.imageVectorQueryCost).append(", rankingCost=").append(this.rankingCost).append(", taskExecuteCost=").append(this.taskExecuteCost).append(", loadResultCost=").append(this.loadResultCost);
        r0.append(", kgQueryCost=").append(this.kgQueryCost).append(", graphExecuteCost=").append(this.graphExecuteCost).append(", buildGraphCost=").append(this.buildGraphCost).append(", sortAndFilterCost=").append(this.sortAndFilterCost).append(", notifySearchResultCost=").append(this.notifySearchResultCost).append(", firstBatchResultCost=").append(this.firstBatchResultCost).append(", queryTotalCost=").append(this.queryTotalCost).append(", isInAppOptimizedSearch=").append(this.isInAppOptimizedSearch).append(", jsonObject=").append(this.jsonObject).append(')');
        return r0.toString();
    }
}
