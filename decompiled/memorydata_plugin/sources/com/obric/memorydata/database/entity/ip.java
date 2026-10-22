package com.obric.memorydata.database.entity;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.memorydata.database.backup.appentity.AbstractFakeAppEntity;
import com.obric.memorydata.database.backup.appentity.FakeUnionSemanticMemoryAppEntity;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.zetetic.database.sqlcipher.SQLiteDatabase;
import okhttp3.HttpUrl;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\bS\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 £\u00012\u00020\u0001:\u0002£\u0001B\u00ad\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\t\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\u0006\u0010\u0013\u001a\u00020\u0005\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\t\u0012\u0006\u0010\u0017\u001a\u00020\t\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u001b\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0005\u0012\b\b\u0002\u0010 \u001a\u00020\u0005\u0012\b\b\u0002\u0010!\u001a\u00020\u0003\u0012\b\b\u0002\u0010\"\u001a\u00020\u0005\u0012\b\b\u0002\u0010#\u001a\u00020\t\u0012\b\b\u0002\u0010$\u001a\u00020\u0005\u0012\b\b\u0002\u0010%\u001a\u00020\u0005\u0012\b\b\u0002\u0010&\u001a\u00020\u0003¢\u0006\u0004\b'\u0010(J\u0006\u0010n\u001a\u00020oJ\n\u0010p\u001a\u0004\u0018\u00010qH\u0014J\n\u0010r\u001a\u0004\u0018\u00010sH\u0016J\u001a\u0010t\u001a\u0004\u0018\u00010u2\u0006\u0010v\u001a\u00020\u00052\u0006\u0010w\u001a\u00020\u0005H\u0016J\u0012\u0010x\u001a\u0004\u0018\u00010u2\u0006\u0010v\u001a\u00020\u0005H\u0016J\n\u0010y\u001a\u0004\u0018\u00010zH\u0016J\u0010\u0010{\u001a\u00020\u00152\u0006\u0010|\u001a\u00020\u0015H\u0016J\t\u0010}\u001a\u00020\u0003HÆ\u0003J\t\u0010~\u001a\u00020\u0005HÆ\u0003J\t\u0010\u007f\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0080\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0081\u0001\u001a\u00020\tHÆ\u0003J\n\u0010\u0082\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0083\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010\u0084\u0001\u001a\u00020\tHÆ\u0003J\f\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\n\u0010\u0086\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010\u0087\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010\u0088\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010\u0089\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010\u008a\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010\u008b\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010\u008c\u0001\u001a\u00020\u0015HÆ\u0003J\n\u0010\u008d\u0001\u001a\u00020\tHÆ\u0003J\n\u0010\u008e\u0001\u001a\u00020\tHÆ\u0003J\n\u0010\u008f\u0001\u001a\u00020\u0015HÆ\u0003J\n\u0010\u0090\u0001\u001a\u00020\u0015HÆ\u0003J\n\u0010\u0091\u0001\u001a\u00020\u001bHÆ\u0003J\f\u0010\u0092\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\n\u0010\u0093\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010\u0094\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010\u0095\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010\u0096\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010\u0097\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0098\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010\u0099\u0001\u001a\u00020\tHÆ\u0003J\n\u0010\u009a\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010\u009b\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010\u009c\u0001\u001a\u00020\u0003HÆ\u0003JÎ\u0002\u0010\u009d\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\t2\b\b\u0002\u0010\u0017\u001a\u00020\t2\b\b\u0002\u0010\u0018\u001a\u00020\u00152\b\b\u0002\u0010\u0019\u001a\u00020\u00152\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u001d\u001a\u00020\u00052\b\b\u0002\u0010\u001e\u001a\u00020\u00052\b\b\u0002\u0010\u001f\u001a\u00020\u00052\b\b\u0002\u0010 \u001a\u00020\u00052\b\b\u0002\u0010!\u001a\u00020\u00032\b\b\u0002\u0010\"\u001a\u00020\u00052\b\b\u0002\u0010#\u001a\u00020\t2\b\b\u0002\u0010$\u001a\u00020\u00052\b\b\u0002\u0010%\u001a\u00020\u00052\b\b\u0002\u0010&\u001a\u00020\u0003HÆ\u0001J\u0016\u0010\u009e\u0001\u001a\u00020\u00152\n\u0010\u009f\u0001\u001a\u0005\u0018\u00010 \u0001HÖ\u0003J\n\u0010¡\u0001\u001a\u00020\tHÖ\u0001J\n\u0010¢\u0001\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0016\u0010\u0004\u001a\u00020\u00058\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0014\u0010\u0006\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010*R\u001a\u0010\u0007\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010*\"\u0004\b1\u0010,R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u001a\u0010\n\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010*\"\u0004\b5\u0010,R\u0014\u0010\u000b\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u0010.R\u0014\u0010\f\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u00103R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010.\"\u0004\b9\u0010:R\u001e\u0010\u000e\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010.\"\u0004\b<\u0010:R\u001e\u0010\u000f\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010.\"\u0004\b>\u0010:R\u001e\u0010\u0010\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010.\"\u0004\b@\u0010:R\u001e\u0010\u0011\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010.\"\u0004\bB\u0010:R\u001e\u0010\u0012\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010.\"\u0004\bD\u0010:R\u001e\u0010\u0013\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010.\"\u0004\bF\u0010:R\u001e\u0010\u0014\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u001e\u0010\u0016\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u00103\"\u0004\bL\u0010MR\u001e\u0010\u0017\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u00103\"\u0004\bO\u0010MR\u001e\u0010\u0018\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010H\"\u0004\bQ\u0010JR\u001e\u0010\u0019\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010H\"\u0004\bS\u0010JR\u001e\u0010\u001a\u001a\u00020\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR \u0010\u001c\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010.\"\u0004\bY\u0010:R\u001e\u0010\u001d\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010.\"\u0004\b[\u0010:R\u001e\u0010\u001e\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010.\"\u0004\b]\u0010:R\u001e\u0010\u001f\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010.\"\u0004\b_\u0010:R\u001e\u0010 \u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010.\"\u0004\ba\u0010:R\u001e\u0010!\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010*\"\u0004\bc\u0010,R\u001e\u0010\"\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010.\"\u0004\be\u0010:R\u001e\u0010#\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u00103\"\u0004\bg\u0010MR\u001e\u0010$\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u0010.\"\u0004\bi\u0010:R\u001e\u0010%\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bj\u0010.\"\u0004\bk\u0010:R\u001e\u0010&\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bl\u0010*\"\u0004\bm\u0010,¨\u0006¤\u0001"}, d2 = {"Lcom/obric/memorydata/database/entity/UnionSemanticMemoryEntity;", "Lcom/obric/memorydata/database/entity/AbstractRawDbEntity;", OaidModel.KEY_ID, "", "entityId", "", "createTime", "modifyTime", "type", "", "timestamp", ObricMemoryConstants.KEY_PACKAGE_NAME, "hashCodeValue", Api.KEY_UUID, "semanticType", "tagPath", "keyPhrase", "description", "embeddingContent", "sources", "userEdit", "", "evidenceCount", "productType", "useForInsight", "useForPersona", "confidence", "", "logId", "importantRawRefIds", "sourceRawRefIds", "sceneIds", "sourcePackageName", "changeSeq", "confirmationState", "migrationVersion", "evidenceIds", "conflictEntityIds", "lastUserAssertAt", "<init>", "(JLjava/lang/String;JJIJLjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZIIZZFLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;ILjava/lang/String;Ljava/lang/String;J)V", "getId", "()J", "setId", "(J)V", "getEntityId", "()Ljava/lang/String;", "getCreateTime", "getModifyTime", "setModifyTime", "getType", "()I", "getTimestamp", "setTimestamp", "getPackageName", "getHashCodeValue", "getUuid", "setUuid", "(Ljava/lang/String;)V", "getSemanticType", "setSemanticType", "getTagPath", "setTagPath", "getKeyPhrase", "setKeyPhrase", "getDescription", "setDescription", "getEmbeddingContent", "setEmbeddingContent", "getSources", "setSources", "getUserEdit", "()Z", "setUserEdit", "(Z)V", "getEvidenceCount", "setEvidenceCount", "(I)V", "getProductType", "setProductType", "getUseForInsight", "setUseForInsight", "getUseForPersona", "setUseForPersona", "getConfidence", "()F", "setConfidence", "(F)V", "getLogId", "setLogId", "getImportantRawRefIds", "setImportantRawRefIds", "getSourceRawRefIds", "setSourceRawRefIds", "getSceneIds", "setSceneIds", "getSourcePackageName", "setSourcePackageName", "getChangeSeq", "setChangeSeq", "getConfirmationState", "setConfirmationState", "getMigrationVersion", "setMigrationVersion", "getEvidenceIds", "setEvidenceIds", "getConflictEntityIds", "setConflictEntityIds", "getLastUserAssertAt", "setLastUserAssertAt", "toJsonObject", "Lorg/json/JSONObject;", "convertToAppEntityInternal", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "convertToFakeAppEntity", "Lcom/obric/memorydata/database/backup/appentity/AbstractFakeAppEntity;", "convertToTextVectorCopilotEntity", "Lcom/obric/memorydata/database/entity/AbstractVectorCopilotEntity;", "column", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "convertToImageVectorCopilotEntity", "convertToRawHistoryEntity", "Lcom/obric/memorydata/database/entity/AbstractHistoryEntity;", "index", "isForceLazy", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "copy", "equals", "other", "", "hashCode", "toString", "Companion", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ip extends d {
    private static final Lazy<Map<String, List<String>>> H = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f9231a = null;
    private String A;
    private long B;
    private String C;
    private int D;
    private String E;
    private String F;
    private long G;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f9232b;
    private final String c;
    private final long d;
    private long e;
    private final int f;
    private long g;
    private final String h;
    private final int i;
    private String j;
    private String k;
    private String l;
    private String m;
    private String n;
    private String o;
    private String p;
    private boolean q;
    private int r;
    private int s;
    private boolean t;
    private boolean u;
    private float v;
    private String w;
    private String x;
    private String y;
    private String z;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b2\u0006\u0010\u0014\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R-\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000b0\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\r¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/database/entity/UnionSemanticMemoryEntity$Companion;", "", "<init>", "()V", "SEMANTIC_TYPE_USERINFO", "", "SEMANTIC_TYPE_RELATIONSHIP", "SEMANTIC_TYPE_INTERESTS", "SEMANTIC_TYPE_PREFERENCE", "ORDER_MAP", "", "", "getORDER_MAP", "()Ljava/util/Map;", "ORDER_MAP$delegate", "Lkotlin/Lazy;", "getStr", "resId", "", "getOrderedTags", "type", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        private final String a(int r1) {
            return com.obric.memorydata.utils.at.a(r1);
        }

        public static final /* synthetic */ String a(a r0, int r1) {
            return r0.a(r1);
        }

        private final Map<String, List<String>> a() {
            return (Map) ZeusTransformUtils.preCheckCast(ip.y().getValue(), Map.class, "com.obric.memorydata.plugin");
        }

        public final List<String> a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "type");
            List<String> r1 = (List) ZeusTransformUtils.preCheckCast(a().get(r2), List.class, "com.obric.memorydata.plugin");
            if (r1 == null) goto L5;
            return r1;
        L5:
            return CollectionsKt.emptyList();
        }
    }

    static {
        f9231a = new a(null);
        H = LazyKt.lazy($$Lambda$ip$KU3egmFHXxyWDEMxDuuXchnk0k.INSTANCE);
    }

    public ip(long r33, String r35, long r36, long r38, int r40, long r41, String r43, int r44, String r45, String r46, String r47, String r48, String r49, String r50, String r51, boolean r52, int r53, int r54, boolean r55, boolean r56, float r57, String r58, String r59, String r60, String r61, String r62, long r63, String r65, int r66, String r67, String r68, long r69) {
        Intrinsics.checkNotNullParameter(r35, "entityId");
        Intrinsics.checkNotNullParameter(r43, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r46, "semanticType");
        Intrinsics.checkNotNullParameter(r47, "tagPath");
        Intrinsics.checkNotNullParameter(r48, "keyPhrase");
        Intrinsics.checkNotNullParameter(r49, "description");
        Intrinsics.checkNotNullParameter(r50, "embeddingContent");
        Intrinsics.checkNotNullParameter(r51, "sources");
        Intrinsics.checkNotNullParameter(r59, "importantRawRefIds");
        Intrinsics.checkNotNullParameter(r60, "sourceRawRefIds");
        Intrinsics.checkNotNullParameter(r61, "sceneIds");
        Intrinsics.checkNotNullParameter(r62, "sourcePackageName");
        Intrinsics.checkNotNullParameter(r65, "confirmationState");
        Intrinsics.checkNotNullParameter(r67, "evidenceIds");
        Intrinsics.checkNotNullParameter(r68, "conflictEntityIds");
        Integer r12 = null;
        super(r33, r35, r36, r38, r40, r41, r43, r44, r45, r12, r12, null, 3584, null);
        this.f9232b = r33;
        this.c = r35;
        this.d = r36;
        this.e = r38;
        this.f = r40;
        this.g = r41;
        this.h = r43;
        this.i = r44;
        this.j = r45;
        this.k = r46;
        this.l = r47;
        this.m = r48;
        this.n = r49;
        this.o = r50;
        this.p = r51;
        this.q = r52;
        this.r = r53;
        this.s = r54;
        this.t = r55;
        this.u = r56;
        this.v = r57;
        this.w = r58;
        this.x = r59;
        this.y = r60;
        this.z = r61;
        this.A = r62;
        this.B = r63;
        this.C = r65;
        this.D = r66;
        this.E = r67;
        this.F = r68;
        this.G = r69;
    }

    public /* synthetic */ ip(long r44, String r46, long r47, long r49, int r51, long r52, String r54, int r55, String r56, String r57, String r58, String r59, String r60, String r61, String r62, boolean r63, int r64, int r65, boolean r66, boolean r67, float r68, String r69, String r70, String r71, String r72, String r73, long r74, String r76, int r77, String r78, String r79, long r80, int r82, DefaultConstructorMarker r83) {
        if ((r82 & 1) == 0) goto L5;
        long r5 = 0;
    L7:
        if ((r82 & 32) == 0) goto L9;
        long r13 = System.currentTimeMillis();
    L11:
        if ((r82 & 256) == 0) goto L13;
        String r17 = UUID.randomUUID().toString();
    L15:
        if ((262144 & r82) == 0) goto L17;
        boolean r27 = false;
    L19:
        if ((524288 & r82) == 0) goto L21;
        boolean r28 = false;
    L23:
        if ((1048576 & r82) == 0) goto L25;
        float r29 = 0.0f;
    L27:
        if ((2097152 & r82) == 0) goto L29;
        String r30 = null;
    L31:
        if ((4194304 & r82) == 0) goto L33;
        String r31 = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
    L35:
        if ((8388608 & r82) == 0) goto L37;
        String r32 = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
    L39:
        if ((16777216 & r82) == 0) goto L41;
        String r33 = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
    L43:
        if ((33554432 & r82) == 0) goto L45;
        String r34 = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
    L47:
        if ((67108864 & r82) == 0) goto L49;
        long r35 = 0;
    L51:
        if ((134217728 & r82) == 0) goto L53;
        String r37 = "none";
    L55:
        if ((268435456 & r82) == 0) goto L57;
        int r38 = 0;
    L59:
        if ((536870912 & r82) == 0) goto L61;
        String r39 = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
    L63:
        if ((1073741824 & r82) == 0) goto L65;
        String r40 = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
    L67:
        if ((r82 & Integer.MIN_VALUE) == 0) goto L69;
        long r41 = 0;
    L70:
        this(r5, r46, r47, r49, r51, r13, r54, r55, r17, r57, r58, r59, r60, r61, r62, r63, r64, r65, r27, r28, r29, r30, r31, r32, r33, r34, r35, r37, r38, r39, r40, r41);
        return;
    L69:
        r41 = r80;
        goto L70
    L65:
        r40 = r79;
        goto L67
    L61:
        r39 = r78;
        goto L63
    L57:
        r38 = r77;
        goto L59
    L53:
        r37 = r76;
        goto L55
    L49:
        r35 = r74;
        goto L51
    L45:
        r34 = r73;
        goto L47
    L41:
        r33 = r72;
        goto L43
    L37:
        r32 = r71;
        goto L39
    L33:
        r31 = r70;
        goto L35
    L29:
        r30 = r69;
        goto L31
    L25:
        r29 = r68;
        goto L27
    L21:
        r28 = r67;
        goto L23
    L17:
        r27 = r66;
        goto L19
    L13:
        r17 = r56;
        goto L15
    L9:
        r13 = r52;
        goto L11
    L5:
        r5 = r44;
        goto L7
    }

    public static /* synthetic */ ip a(ip r17, long r18, String r20, long r21, long r23, int r25, long r26, String r28, int r29, String r30, String r31, String r32, String r33, String r34, String r35, String r36, boolean r37, int r38, int r39, boolean r40, boolean r41, float r42, String r43, String r44, String r45, String r46, String r47, long r48, String r50, int r51, String r52, String r53, long r54, int r56, Object r57) {
        if ((r56 & 1) == 0) goto L5;
        long r2 = r17.f9232b;
    L7:
        if ((r56 & 2) == 0) goto L9;
        String r4 = r17.c;
    L11:
        if ((r56 & 4) == 0) goto L13;
        long r5 = r17.d;
    L15:
        if ((r56 & 8) == 0) goto L17;
        long r7 = r17.e;
    L19:
        if ((r56 & 16) == 0) goto L21;
        int r9 = r17.f;
    L23:
        if ((r56 & 32) == 0) goto L25;
        long r10 = r17.g;
    L27:
        if ((r56 & 64) == 0) goto L29;
        String r12 = r17.h;
    L31:
        if ((r56 & 128) == 0) goto L33;
        int r13 = r17.i;
    L35:
        if ((r56 & 256) == 0) goto L37;
        String r14 = r17.j;
    L39:
        if ((r56 & 512) == 0) goto L41;
        String r15 = r17.k;
    L42:
        String r310 = r15;
        if ((r56 & 1024) == 0) goto L45;
        String r16 = r17.l;
    L46:
        String r311 = r16;
        if ((r56 & 2048) == 0) goto L49;
        String r19 = r17.m;
    L50:
        String r312 = r19;
        if ((r56 & 4096) == 0) goto L53;
        String r110 = r17.n;
    L54:
        String r313 = r110;
        if ((r56 & 8192) == 0) goto L57;
        String r111 = r17.o;
    L58:
        String r314 = r111;
        if ((r56 & 16384) == 0) goto L61;
        String r112 = r17.p;
    L62:
        String r315 = r112;
        if ((r56 & 32768) == 0) goto L65;
        boolean r113 = r17.q;
    L66:
        boolean r316 = r113;
        if ((r56 & 65536) == 0) goto L69;
        int r114 = r17.r;
    L70:
        int r317 = r114;
        if ((r56 & 131072) == 0) goto L73;
        int r115 = r17.s;
    L74:
        int r318 = r115;
        if ((r56 & 262144) == 0) goto L77;
        boolean r116 = r17.t;
    L78:
        boolean r49 = r116;
        if ((r56 & 524288) == 0) goto L81;
        boolean r117 = r17.u;
    L82:
        boolean r410 = r117;
        if ((r56 & 1048576) == 0) goto L85;
        float r118 = r17.v;
    L86:
        float r411 = r118;
        if ((r56 & 2097152) == 0) goto L89;
        String r119 = r17.w;
    L90:
        String r412 = r119;
        if ((r56 & 4194304) == 0) goto L93;
        String r120 = r17.x;
    L94:
        String r413 = r120;
        if ((r56 & 8388608) == 0) goto L97;
        String r121 = r17.y;
    L98:
        String r414 = r121;
        if ((r56 & 16777216) == 0) goto L101;
        String r122 = r17.z;
    L102:
        String r415 = r122;
        if ((r56 & 33554432) == 0) goto L105;
        String r123 = r17.A;
    L106:
        String r319 = r14;
        String r416 = r123;
        if ((r56 & AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) == 0) goto L109;
        long r124 = r17.B;
    L110:
        long r417 = r124;
        if ((r56 & 134217728) == 0) goto L113;
        String r125 = r17.C;
    L115:
        if ((268435456 & r56) == 0) goto L117;
        int r126 = r17.D;
    L118:
        int r55 = r126;
        if ((r56 & SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING) == 0) goto L121;
        String r127 = r17.E;
    L122:
        String r58 = r127;
        if ((r56 & 1073741824) == 0) goto L125;
        String r128 = r17.F;
    L126:
        String r59 = r125;
        String r510 = r128;
        if ((r56 & Integer.MIN_VALUE) == 0) goto L129;
        long r129 = r17.G;
    L131:
        return r17.a(r2, r4, r5, r7, r9, r10, r12, r13, r319, r310, r311, r312, r313, r314, r315, r316, r317, r318, r49, r410, r411, r412, r413, r414, r415, r416, r417, r59, r55, r58, r510, r129);
    L129:
        r129 = r54;
        goto L131
    L125:
        r128 = r53;
        goto L126
    L121:
        r127 = r52;
        goto L122
    L117:
        r126 = r51;
        goto L118
    L113:
        r125 = r50;
        goto L115
    L109:
        r124 = r48;
        goto L110
    L105:
        r123 = r47;
        goto L106
    L101:
        r122 = r46;
        goto L102
    L97:
        r121 = r45;
        goto L98
    L93:
        r120 = r44;
        goto L94
    L89:
        r119 = r43;
        goto L90
    L85:
        r118 = r42;
        goto L86
    L81:
        r117 = r41;
        goto L82
    L77:
        r116 = r40;
        goto L78
    L73:
        r115 = r39;
        goto L74
    L69:
        r114 = r38;
        goto L70
    L65:
        r113 = r37;
        goto L66
    L61:
        r112 = r36;
        goto L62
    L57:
        r111 = r35;
        goto L58
    L53:
        r110 = r34;
        goto L54
    L49:
        r19 = r33;
        goto L50
    L45:
        r16 = r32;
        goto L46
    L41:
        r15 = r31;
        goto L42
    L37:
        r14 = r30;
        goto L39
    L33:
        r13 = r29;
        goto L35
    L29:
        r12 = r28;
        goto L31
    L25:
        r10 = r26;
        goto L27
    L21:
        r9 = r25;
        goto L23
    L17:
        r7 = r23;
        goto L19
    L13:
        r5 = r21;
        goto L15
    L9:
        r4 = r20;
        goto L11
    L5:
        r2 = r18;
        goto L7
    }

    /* JADX INFO: renamed from: lambda$KU3egmFHXxyWDEMxDuuXchn-k0k, reason: not valid java name */
    public static /* synthetic */ Map m555lambda$KU3egmFHXxyWDEMxDuuXchnk0k() {
        return z();
    }

    public static final /* synthetic */ Lazy y() {
        return H;
    }

    private static final Map z() {
        a r4 = f9231a;
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("userinfo", CollectionsKt.listOf(new String[]{a.a(r4, ZeusTransformUtils.mapRes(R.string.tag_path_userinfo_basic, TypedValues.Custom.S_STRING, "tag_path_userinfo_basic")), a.a(r4, ZeusTransformUtils.mapRes(R.string.tag_path_userinfo_location, TypedValues.Custom.S_STRING, "tag_path_userinfo_location")), a.a(r4, ZeusTransformUtils.mapRes(R.string.tag_path_userinfo_career, TypedValues.Custom.S_STRING, "tag_path_userinfo_career")), a.a(r4, ZeusTransformUtils.mapRes(R.string.tag_path_userinfo_phone, TypedValues.Custom.S_STRING, "tag_path_userinfo_phone")), a.a(r4, ZeusTransformUtils.mapRes(R.string.tag_path_other, TypedValues.Custom.S_STRING, "tag_path_other"))})), TuplesKt.to("relationship", CollectionsKt.listOf(new String[]{a.a(r4, ZeusTransformUtils.mapRes(R.string.tag_path_relationship_family, TypedValues.Custom.S_STRING, "tag_path_relationship_family")), a.a(r4, ZeusTransformUtils.mapRes(R.string.tag_path_relationship_colleague, TypedValues.Custom.S_STRING, "tag_path_relationship_colleague")), a.a(r4, ZeusTransformUtils.mapRes(R.string.tag_path_relationship_school, TypedValues.Custom.S_STRING, "tag_path_relationship_school")), a.a(r4, ZeusTransformUtils.mapRes(R.string.tag_path_relationship_friend, TypedValues.Custom.S_STRING, "tag_path_relationship_friend")), a.a(r4, ZeusTransformUtils.mapRes(R.string.tag_path_relationship_pet, TypedValues.Custom.S_STRING, "tag_path_relationship_pet")), a.a(r4, ZeusTransformUtils.mapRes(R.string.tag_path_other, TypedValues.Custom.S_STRING, "tag_path_other"))})), TuplesKt.to("interests", CollectionsKt.listOf(new String[]{a.a(r4, ZeusTransformUtils.mapRes(R.string.tag_path_interests_music, TypedValues.Custom.S_STRING, "tag_path_interests_music")), a.a(r4, ZeusTransformUtils.mapRes(R.string.tag_path_interests_movie, TypedValues.Custom.S_STRING, "tag_path_interests_movie")), a.a(r4, ZeusTransformUtils.mapRes(R.string.tag_path_interests_reading, TypedValues.Custom.S_STRING, "tag_path_interests_reading")), a.a(r4, ZeusTransformUtils.mapRes(R.string.tag_path_interests_game, TypedValues.Custom.S_STRING, "tag_path_interests_game")), a.a(r4, ZeusTransformUtils.mapRes(R.string.tag_path_interests_sports, TypedValues.Custom.S_STRING, "tag_path_interests_sports")), a.a(r4, ZeusTransformUtils.mapRes(R.string.tag_path_interests_outdoor, TypedValues.Custom.S_STRING, "tag_path_interests_outdoor")), a.a(r4, ZeusTransformUtils.mapRes(R.string.tag_path_interests_travel, TypedValues.Custom.S_STRING, "tag_path_interests_travel")), a.a(r4, ZeusTransformUtils.mapRes(R.string.tag_path_interests_food, TypedValues.Custom.S_STRING, "tag_path_interests_food")), a.a(r4, ZeusTransformUtils.mapRes(R.string.tag_path_interests_art, TypedValues.Custom.S_STRING, "tag_path_interests_art")), a.a(r4, ZeusTransformUtils.mapRes(R.string.tag_path_interests_craft, TypedValues.Custom.S_STRING, "tag_path_interests_craft")), a.a(r4, ZeusTransformUtils.mapRes(R.string.tag_path_interests_collection, TypedValues.Custom.S_STRING, "tag_path_interests_collection")), a.a(r4, ZeusTransformUtils.mapRes(R.string.tag_path_interests_tech, TypedValues.Custom.S_STRING, "tag_path_interests_tech")), a.a(r4, ZeusTransformUtils.mapRes(R.string.tag_path_interests_learning, TypedValues.Custom.S_STRING, "tag_path_interests_learning")), a.a(r4, ZeusTransformUtils.mapRes(R.string.tag_path_interests_social, TypedValues.Custom.S_STRING, "tag_path_interests_social")), a.a(r4, ZeusTransformUtils.mapRes(R.string.tag_path_interests_volunteer, TypedValues.Custom.S_STRING, "tag_path_interests_volunteer")), a.a(r4, ZeusTransformUtils.mapRes(R.string.tag_path_interests_pet, TypedValues.Custom.S_STRING, "tag_path_interests_pet")), a.a(r4, ZeusTransformUtils.mapRes(R.string.tag_path_other, TypedValues.Custom.S_STRING, "tag_path_other"))})), TuplesKt.to("preference", CollectionsKt.listOf(new String[]{a.a(r4, ZeusTransformUtils.mapRes(R.string.tag_path_preference_taste, TypedValues.Custom.S_STRING, "tag_path_preference_taste")), a.a(r4, ZeusTransformUtils.mapRes(R.string.tag_path_preference_takeout, TypedValues.Custom.S_STRING, "tag_path_preference_takeout")), a.a(r4, ZeusTransformUtils.mapRes(R.string.tag_path_preference_restaurant, TypedValues.Custom.S_STRING, "tag_path_preference_restaurant")), a.a(r4, ZeusTransformUtils.mapRes(R.string.tag_path_preference_taxi, TypedValues.Custom.S_STRING, "tag_path_preference_taxi")), a.a(r4, ZeusTransformUtils.mapRes(R.string.tag_path_preference_long_trip, TypedValues.Custom.S_STRING, "tag_path_preference_long_trip")), a.a(r4, ZeusTransformUtils.mapRes(R.string.tag_path_preference_shopping, TypedValues.Custom.S_STRING, "tag_path_preference_shopping")), a.a(r4, ZeusTransformUtils.mapRes(R.string.tag_path_preference_accommodation, TypedValues.Custom.S_STRING, "tag_path_preference_accommodation")), a.a(r4, ZeusTransformUtils.mapRes(R.string.tag_path_preference_work_style, TypedValues.Custom.S_STRING, "tag_path_preference_work_style")), a.a(r4, ZeusTransformUtils.mapRes(R.string.tag_path_preference_communication, TypedValues.Custom.S_STRING, "tag_path_preference_communication")), a.a(r4, ZeusTransformUtils.mapRes(R.string.tag_path_preference_schedule, TypedValues.Custom.S_STRING, "tag_path_preference_schedule")), a.a(r4, ZeusTransformUtils.mapRes(R.string.tag_path_preference_exercise, TypedValues.Custom.S_STRING, "tag_path_preference_exercise")), a.a(r4, ZeusTransformUtils.mapRes(R.string.tag_path_preference_medical, TypedValues.Custom.S_STRING, "tag_path_preference_medical")), a.a(r4, ZeusTransformUtils.mapRes(R.string.tag_path_preference_content, TypedValues.Custom.S_STRING, "tag_path_preference_content")), a.a(r4, ZeusTransformUtils.mapRes(R.string.tag_path_preference_creation, TypedValues.Custom.S_STRING, "tag_path_preference_creation")), a.a(r4, ZeusTransformUtils.mapRes(R.string.tag_path_preference_dialogue, TypedValues.Custom.S_STRING, "tag_path_preference_dialogue")), a.a(r4, ZeusTransformUtils.mapRes(R.string.tag_path_preference_device, TypedValues.Custom.S_STRING, "tag_path_preference_device")), a.a(r4, ZeusTransformUtils.mapRes(R.string.tag_path_other, TypedValues.Custom.S_STRING, "tag_path_other"))}))});
    }

    public final ip a(long r41, String r43, long r44, long r46, int r48, long r49, String r51, int r52, String r53, String r54, String r55, String r56, String r57, String r58, String r59, boolean r60, int r61, int r62, boolean r63, boolean r64, float r65, String r66, String r67, String r68, String r69, String r70, long r71, String r73, int r74, String r75, String r76, long r77) {
        Intrinsics.checkNotNullParameter(r43, "entityId");
        Intrinsics.checkNotNullParameter(r51, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r54, "semanticType");
        Intrinsics.checkNotNullParameter(r55, "tagPath");
        Intrinsics.checkNotNullParameter(r56, "keyPhrase");
        Intrinsics.checkNotNullParameter(r57, "description");
        Intrinsics.checkNotNullParameter(r58, "embeddingContent");
        Intrinsics.checkNotNullParameter(r59, "sources");
        Intrinsics.checkNotNullParameter(r67, "importantRawRefIds");
        Intrinsics.checkNotNullParameter(r68, "sourceRawRefIds");
        Intrinsics.checkNotNullParameter(r69, "sceneIds");
        Intrinsics.checkNotNullParameter(r70, "sourcePackageName");
        Intrinsics.checkNotNullParameter(r73, "confirmationState");
        Intrinsics.checkNotNullParameter(r75, "evidenceIds");
        Intrinsics.checkNotNullParameter(r76, "conflictEntityIds");
        return new ip(r41, r43, r44, r46, r48, r49, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62, r63, r64, r65, r66, r67, r68, r69, r70, r71, r73, r74, r75, r76, r77);
    }

    public final String a() {
        return this.k;
    }

    public final void a(float r1) {
        this.v = r1;
    }

    public final void a(int r1) {
        this.r = r1;
    }

    public void a(long r1) {
        this.e = r1;
    }

    public final void a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.k = r2;
    }

    public final void a(boolean r1) {
        this.q = r1;
    }

    public final String b() {
        return this.l;
    }

    public final void b(int r1) {
        this.s = r1;
    }

    public final void b(long r1) {
        this.B = r1;
    }

    public final void b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.l = r2;
    }

    public final void b(boolean r1) {
        this.t = r1;
    }

    public final String c() {
        return this.m;
    }

    public final void c(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.m = r2;
    }

    public final void c(boolean r1) {
        this.u = r1;
    }

    @Override // com.obric.memorydata.database.entity.d
    public AppEntity convertToAppEntityInternal() {
        return (AppEntity) ZeusTransformUtils.preCheckCast(iq.a(this), AppEntity.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.database.entity.d
    public AbstractFakeAppEntity convertToFakeAppEntity() {
        return (AbstractFakeAppEntity) ZeusTransformUtils.preCheckCast(new FakeUnionSemanticMemoryAppEntity(this), AbstractFakeAppEntity.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.database.entity.d
    public i convertToImageVectorCopilotEntity(String r1) {
        Intrinsics.checkNotNullParameter(r1, "column");
        return null;
    }

    @Override // com.obric.memorydata.database.entity.d
    public c convertToRawHistoryEntity() {
        return (c) ZeusTransformUtils.preCheckCast(new is(0, this, 1, null), c.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.database.entity.d
    public i convertToTextVectorCopilotEntity(String r11, String r12) {
        Intrinsics.checkNotNullParameter(r11, "column");
        Intrinsics.checkNotNullParameter(r12, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        return (i) ZeusTransformUtils.preCheckCast(new il(0, getId(), r11, r12, 1, null), i.class, "com.obric.memorydata.plugin");
    }

    public final String d() {
        return this.n;
    }

    public final void d(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.n = r2;
    }

    public final String e() {
        return this.o;
    }

    public final void e(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.o = r2;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, ip.class) == true) goto L8;
        return false;
    L8:
        ip r10 = (ip) ZeusTransformUtils.preCheckCast(r9, ip.class, "com.obric.memorydata.plugin");
        if (this.f9232b == r10.f9232b) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.c, r10.c) == true) goto L15;
        return false;
    L15:
        if (this.d == r10.d) goto L18;
        return false;
    L18:
        if (this.e == r10.e) goto L21;
        return false;
    L21:
        if (this.f == r10.f) goto L24;
        return false;
    L24:
        if (this.g == r10.g) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.h, r10.h) == true) goto L30;
        return false;
    L30:
        if (this.i == r10.i) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.j, r10.j) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.k, r10.k) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.l, r10.l) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.m, r10.m) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.n, r10.n) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.o, r10.o) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.p, r10.p) == true) goto L54;
        return false;
    L54:
        if (this.q == r10.q) goto L57;
        return false;
    L57:
        if (this.r == r10.r) goto L60;
        return false;
    L60:
        if (this.s == r10.s) goto L63;
        return false;
    L63:
        if (this.t == r10.t) goto L66;
        return false;
    L66:
        if (this.u == r10.u) goto L69;
        return false;
    L69:
        if (Float.compare(this.v, r10.v) == 0) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.w, r10.w) == true) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.x, r10.x) == true) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.y, r10.y) == true) goto L81;
        return false;
    L81:
        if (Intrinsics.areEqual(this.z, r10.z) == true) goto L84;
        return false;
    L84:
        if (Intrinsics.areEqual(this.A, r10.A) == true) goto L87;
        return false;
    L87:
        if (this.B == r10.B) goto L90;
        return false;
    L90:
        if (Intrinsics.areEqual(this.C, r10.C) == true) goto L93;
        return false;
    L93:
        if (this.D == r10.D) goto L96;
        return false;
    L96:
        if (Intrinsics.areEqual(this.E, r10.E) == true) goto L99;
        return false;
    L99:
        if (Intrinsics.areEqual(this.F, r10.F) == true) goto L102;
        return false;
    L102:
        if (this.G == r10.G) goto L104;
        return false;
    L104:
        return true;
    }

    public final String f() {
        return this.p;
    }

    public final void f(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.p = r2;
    }

    public final void g(String r1) {
        this.w = r1;
    }

    public final boolean g() {
        return this.q;
    }

    @Override // com.obric.memorydata.database.entity.d
    public long getCreateTime() {
        return this.d;
    }

    @Override // com.obric.memorydata.database.entity.d
    public String getEntityId() {
        return this.c;
    }

    @Override // com.obric.memorydata.database.entity.d
    public int getHashCodeValue() {
        return this.i;
    }

    @Override // com.obric.memorydata.database.entity.d
    public long getId() {
        return this.f9232b;
    }

    @Override // com.obric.memorydata.database.entity.d
    public long getModifyTime() {
        return this.e;
    }

    @Override // com.obric.memorydata.database.entity.d
    public String getPackageName() {
        return this.h;
    }

    @Override // com.obric.memorydata.database.entity.d
    public long getTimestamp() {
        return this.g;
    }

    @Override // com.obric.memorydata.database.entity.d
    public int getType() {
        return this.f;
    }

    @Override // com.obric.memorydata.database.entity.d
    public String getUuid() {
        return this.j;
    }

    public final int h() {
        return this.r;
    }

    public final void h(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.x = r2;
    }

    public int hashCode() {
        int r0 = ((((((((((((((Long.hashCode(this.f9232b) * 31) + this.c.hashCode()) * 31) + Long.hashCode(this.d)) * 31) + Long.hashCode(this.e)) * 31) + Integer.hashCode(this.f)) * 31) + Long.hashCode(this.g)) * 31) + this.h.hashCode()) * 31) + Integer.hashCode(this.i)) * 31;
        String r1 = this.j;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((((((((((((((((((((((((r0 + r3) * 31) + this.k.hashCode()) * 31) + this.l.hashCode()) * 31) + this.m.hashCode()) * 31) + this.n.hashCode()) * 31) + this.o.hashCode()) * 31) + this.p.hashCode()) * 31) + Boolean.hashCode(this.q)) * 31) + Integer.hashCode(this.r)) * 31) + Integer.hashCode(this.s)) * 31) + Boolean.hashCode(this.t)) * 31) + Boolean.hashCode(this.u)) * 31) + Float.hashCode(this.v)) * 31;
        String r5 = this.w;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return ((((((((((((((((((((r4 + r2) * 31) + this.x.hashCode()) * 31) + this.y.hashCode()) * 31) + this.z.hashCode()) * 31) + this.A.hashCode()) * 31) + Long.hashCode(this.B)) * 31) + this.C.hashCode()) * 31) + Integer.hashCode(this.D)) * 31) + this.E.hashCode()) * 31) + this.F.hashCode()) * 31) + Long.hashCode(this.G);
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final int i() {
        return this.s;
    }

    public final void i(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.y = r2;
    }

    @Override // com.obric.memorydata.database.entity.d, com.obric.memorydata.database.a
    public boolean index(boolean r10) {
        boolean r11 = super.index(r10);
        if (r11 == false) goto L7;
        MemoryDbEngine.INSTANCE.getPersonalDbEngine().getUnionSemanticMemoryExtDao().insertOrReplace(new ir(0, getEntityId(), false, 1, null));
        if (com.obric.memorydata.database.util.a.f9622a.a() == false) goto L7;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "UnionSemanticMemoryEntity", "skip semantic_memory_extract: data import in progress, entityId=" + getEntityId(), false, 4, null);
    L7:
        return r11;
    }

    public final void j(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.z = r2;
    }

    public final boolean j() {
        return this.t;
    }

    public final void k(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.A = r2;
    }

    public final boolean k() {
        return this.u;
    }

    public final float l() {
        return this.v;
    }

    public final void l(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.C = r2;
    }

    public final String m() {
        return this.w;
    }

    public final void m(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.E = r2;
    }

    public final String n() {
        return this.x;
    }

    public final void n(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.F = r2;
    }

    public final String o() {
        return this.y;
    }

    public final String p() {
        return this.z;
    }

    public final String q() {
        return this.A;
    }

    public final long r() {
        return this.B;
    }

    public final String s() {
        return this.C;
    }

    @Override // com.obric.memorydata.database.entity.d
    public void setId(long r1) {
        this.f9232b = r1;
    }

    @Override // com.obric.memorydata.database.entity.d
    public void setTimestamp(long r1) {
        this.g = r1;
    }

    @Override // com.obric.memorydata.database.entity.d
    public void setUuid(String r1) {
        this.j = r1;
    }

    public final int t() {
        return this.D;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("UnionSemanticMemoryEntity(id=").append(this.f9232b).append(", entityId=").append(this.c).append(", createTime=").append(this.d).append(", modifyTime=").append(this.e).append(", type=").append(this.f).append(", timestamp=").append(this.g).append(", packageName=").append(this.h).append(", hashCodeValue=").append(this.i).append(", uuid=").append(this.j).append(", semanticType=").append(this.k).append(", tagPath=").append(this.l).append(", keyPhrase=");
        r0.append(this.m).append(", description=").append(this.n).append(", embeddingContent=").append(this.o).append(", sources=").append(this.p).append(", userEdit=").append(this.q).append(", evidenceCount=").append(this.r).append(", productType=").append(this.s).append(", useForInsight=").append(this.t).append(", useForPersona=").append(this.u).append(", confidence=").append(this.v).append(", logId=").append(this.w).append(", importantRawRefIds=").append(this.x);
        r0.append(", sourceRawRefIds=").append(this.y).append(", sceneIds=").append(this.z).append(", sourcePackageName=").append(this.A).append(", changeSeq=").append(this.B).append(", confirmationState=").append(this.C).append(", migrationVersion=").append(this.D).append(", evidenceIds=").append(this.E).append(", conflictEntityIds=").append(this.F).append(", lastUserAssertAt=").append(this.G).append(')');
        return r0.toString();
    }

    public final String u() {
        return this.E;
    }

    public final String v() {
        return this.F;
    }

    public final long w() {
        return this.G;
    }

    public final JSONObject x() {
        JSONObject r0 = new JSONObject();
        r0.put(OaidModel.KEY_ID, getId());
        r0.put("entityId", getEntityId());
        r0.put("createTime", getCreateTime());
        r0.put("modifyTime", getModifyTime());
        r0.put("type", getType());
        r0.put("timestamp", getTimestamp());
        r0.put(ObricMemoryConstants.KEY_PACKAGE_NAME, getPackageName());
        r0.put("hashCodeValue", getHashCodeValue());
        r0.put(Api.KEY_UUID, getUuid());
        r0.put("semanticType", this.k);
        r0.put("tagPath", this.l);
        r0.put("keyPhrase", this.m);
        r0.put("description", this.n);
        r0.put("embeddingContent", this.o);
        r0.put("sources", this.p);
        r0.put("userEdit", this.q);
        r0.put("evidenceCount", this.r);
        r0.put("productType", this.s);
        r0.put("useForInsight", this.t);
        r0.put("useForPersona", this.u);
        r0.put("confidence", Float.valueOf(this.v));
        r0.put("logId", this.w);
        r0.put("importantRawRefIds", this.x);
        r0.put("sourceRawRefIds", this.y);
        r0.put("sceneIds", this.z);
        r0.put("sourcePackageName", this.A);
        return r0;
    }
}
