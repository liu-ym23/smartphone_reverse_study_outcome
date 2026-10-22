package com.obric.memorydata.union.build.storage;

import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.bytedance.bdinstall.Api;
import com.google.gson.reflect.TypeToken;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.database.entity.ip;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.utils.GsonUtil;
import com.ttnet.org.chromium.net.NetError;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import net.zetetic.database.sqlcipher.SQLiteDatabase;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b5\n\u0002\u0018\u0002\n\u0002\b(\b\u0087\b\u0018\u0000 w2\u00020\u0001:\u0001wBï\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b%\u0010&J\u0006\u0010N\u001a\u00020\u0014J\u0018\u0010O\u001a\u00020P2\b\u0010Q\u001a\u0004\u0018\u00010P2\u0006\u0010R\u001a\u00020\u0005J\u000b\u0010S\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010T\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010*J\u0010\u0010U\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010*J\u0010\u0010V\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010.J\u0010\u0010W\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010*J\u000b\u0010X\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010Y\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010.J\u000b\u0010Z\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010[\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\\\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010]\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010^\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010_\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010`\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010a\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0002\u0010;J\u0010\u0010b\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010.J\u0010\u0010c\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010.J\u0010\u0010d\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0002\u0010;J\u0010\u0010e\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0002\u0010;J\u0010\u0010f\u001a\u0004\u0018\u00010\u001aHÆ\u0003¢\u0006\u0002\u0010BJ\u000b\u0010g\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010h\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010i\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010j\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010k\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010l\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010m\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010.J\u000b\u0010n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010o\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010p\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010*Jö\u0002\u0010q\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010rJ\u0013\u0010s\u001a\u00020\u00142\b\u0010t\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010u\u001a\u00020\bHÖ\u0001J\t\u0010v\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010+\u001a\u0004\b)\u0010*R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010+\u001a\u0004\b,\u0010*R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010/\u001a\u0004\b-\u0010.R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010+\u001a\u0004\b0\u0010*R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u0010(R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010/\u001a\u0004\b2\u0010.R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b3\u0010(R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b4\u0010(R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b5\u0010(R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b6\u0010(R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b7\u0010(R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b8\u0010(R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b9\u0010(R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\n\n\u0002\u0010<\u001a\u0004\b:\u0010;R\u0015\u0010\u0015\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010/\u001a\u0004\b=\u0010.R\u0015\u0010\u0016\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010/\u001a\u0004\b>\u0010.R\u0015\u0010\u0017\u001a\u0004\u0018\u00010\u0014¢\u0006\n\n\u0002\u0010<\u001a\u0004\b?\u0010;R\u0015\u0010\u0018\u001a\u0004\u0018\u00010\u0014¢\u0006\n\n\u0002\u0010<\u001a\u0004\b@\u0010;R\u0015\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\n\n\u0002\u0010C\u001a\u0004\bA\u0010BR\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bD\u0010(R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bE\u0010(R\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bF\u0010(R\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bG\u0010(R\u0013\u0010\u001f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bH\u0010(R\u0013\u0010 \u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bI\u0010(R\u0015\u0010!\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010/\u001a\u0004\bJ\u0010.R\u0013\u0010\"\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bK\u0010(R\u0013\u0010#\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bL\u0010(R\u0015\u0010$\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010+\u001a\u0004\bM\u0010*¨\u0006x"}, d2 = {"Lcom/obric/memorydata/union/build/storage/SemanticBatchEntityPayload;", "", "entityId", "", "createTime", "", "modifyTime", "type", "", "timestamp", ObricMemoryConstants.KEY_PACKAGE_NAME, "hashCodeValue", Api.KEY_UUID, "semanticType", "tagPath", "keyPhrase", "description", "embeddingContent", "sources", "userEdit", "", "evidenceCount", "productType", "useForInsight", "useForPersona", "confidence", "", "logId", "importantRawRefIds", "sourceRawRefIds", "sceneIds", "sourcePackageName", "confirmationState", "migrationVersion", "evidenceIds", "conflictEntityIds", "lastUserAssertAt", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "getEntityId", "()Ljava/lang/String;", "getCreateTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getModifyTime", "getType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTimestamp", "getPackageName", "getHashCodeValue", "getUuid", "getSemanticType", "getTagPath", "getKeyPhrase", "getDescription", "getEmbeddingContent", "getSources", "getUserEdit", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getEvidenceCount", "getProductType", "getUseForInsight", "getUseForPersona", "getConfidence", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getLogId", "getImportantRawRefIds", "getSourceRawRefIds", "getSceneIds", "getSourcePackageName", "getConfirmationState", "getMigrationVersion", "getEvidenceIds", "getConflictEntityIds", "getLastUserAssertAt", "hasInsertFields", "toEntity", "Lcom/obric/memorydata/database/entity/UnionSemanticMemoryEntity;", "existing", "changeSeq", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)Lcom/obric/memorydata/union/build/storage/SemanticBatchEntityPayload;", "equals", "other", "hashCode", "toString", "Companion", "memory_build_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SemanticBatchEntityPayload {
    public static final a Companion = null;
    private final Float confidence;
    private final String confirmationState;
    private final String conflictEntityIds;
    private final Long createTime;
    private final String description;
    private final String embeddingContent;
    private final String entityId;
    private final Integer evidenceCount;
    private final String evidenceIds;
    private final Integer hashCodeValue;
    private final String importantRawRefIds;
    private final String keyPhrase;
    private final Long lastUserAssertAt;
    private final String logId;
    private final Integer migrationVersion;
    private final Long modifyTime;
    private final String packageName;
    private final Integer productType;
    private final String sceneIds;
    private final String semanticType;
    private final String sourcePackageName;
    private final String sourceRawRefIds;
    private final String sources;
    private final String tagPath;
    private final Long timestamp;
    private final Integer type;
    private final Boolean useForInsight;
    private final Boolean useForPersona;
    private final Boolean userEdit;
    private final String uuid;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/union/build/storage/SemanticBatchEntityPayload$Companion;", "", "<init>", "()V", "fromEntity", "Lcom/obric/memorydata/union/build/storage/SemanticBatchEntityPayload;", "entity", "Lcom/obric/memorydata/database/entity/UnionSemanticMemoryEntity;", "memory_build_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final SemanticBatchEntityPayload a(ip r35) {
            Intrinsics.checkNotNullParameter(r35, "entity");
            return new SemanticBatchEntityPayload(r35.getEntityId(), Long.valueOf(r35.getCreateTime()), Long.valueOf(r35.getModifyTime()), Integer.valueOf(r35.getType()), Long.valueOf(r35.getTimestamp()), r35.getPackageName(), Integer.valueOf(r35.getHashCodeValue()), r35.getUuid(), r35.a(), r35.b(), r35.c(), r35.d(), r35.e(), r35.f(), Boolean.valueOf(r35.g()), Integer.valueOf(r35.h()), Integer.valueOf(r35.i()), Boolean.valueOf(r35.j()), Boolean.valueOf(r35.k()), Float.valueOf(r35.l()), r35.m(), r35.n(), r35.o(), r35.p(), r35.q(), r35.s(), Integer.valueOf(r35.t()), r35.u(), r35.v(), Long.valueOf(r35.w()));
        }
    }

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001¨\u0006\u0003¸\u0006\u0000"}, d2 = {"com/obric/memorydata/utils/GsonUtil$fromJsonArray$2$1", "Lcom/google/gson/reflect/TypeToken;", "", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b extends TypeToken<List<? extends String>> {
        public b() {
        }
    }

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001¨\u0006\u0003¸\u0006\u0000"}, d2 = {"com/obric/memorydata/utils/GsonUtil$fromJsonArray$2$1", "Lcom/google/gson/reflect/TypeToken;", "", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c extends TypeToken<List<? extends String>> {
        public c() {
        }
    }

    static {
        Companion = new a(null);
    }

    public SemanticBatchEntityPayload() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 1073741823, null);
    }

    public SemanticBatchEntityPayload(String r3, Long r4, Long r5, Integer r6, Long r7, String r8, Integer r9, String r10, String r11, String r12, String r13, String r14, String r15, String r16, Boolean r17, Integer r18, Integer r19, Boolean r20, Boolean r21, Float r22, String r23, String r24, String r25, String r26, String r27, String r28, Integer r29, String r30, String r31, Long r32) {
        this.entityId = r3;
        this.createTime = r4;
        this.modifyTime = r5;
        this.type = r6;
        this.timestamp = r7;
        this.packageName = r8;
        this.hashCodeValue = r9;
        this.uuid = r10;
        this.semanticType = r11;
        this.tagPath = r12;
        this.keyPhrase = r13;
        this.description = r14;
        this.embeddingContent = r15;
        this.sources = r16;
        this.userEdit = r17;
        this.evidenceCount = r18;
        this.productType = r19;
        this.useForInsight = r20;
        this.useForPersona = r21;
        this.confidence = r22;
        this.logId = r23;
        this.importantRawRefIds = r24;
        this.sourceRawRefIds = r25;
        this.sceneIds = r26;
        this.sourcePackageName = r27;
        this.confirmationState = r28;
        this.migrationVersion = r29;
        this.evidenceIds = r30;
        this.conflictEntityIds = r31;
        this.lastUserAssertAt = r32;
    }

    public /* synthetic */ SemanticBatchEntityPayload(String r32, Long r33, Long r34, Integer r35, Long r36, String r37, Integer r38, String r39, String r40, String r41, String r42, String r43, String r44, String r45, Boolean r46, Integer r47, Integer r48, Boolean r49, Boolean r50, Float r51, String r52, String r53, String r54, String r55, String r56, String r57, Integer r58, String r59, String r60, Long r61, int r62, DefaultConstructorMarker r63) {
        if ((r62 & 1) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r62 & 2) == 0) goto L9;
        Long r3 = null;
    L11:
        if ((r62 & 4) == 0) goto L13;
        Long r4 = null;
    L15:
        if ((r62 & 8) == 0) goto L17;
        Integer r5 = null;
    L19:
        if ((r62 & 16) == 0) goto L21;
        Long r6 = null;
    L23:
        if ((r62 & 32) == 0) goto L25;
        String r7 = null;
    L27:
        if ((r62 & 64) == 0) goto L29;
        Integer r8 = null;
    L31:
        if ((r62 & 128) == 0) goto L33;
        String r9 = null;
    L35:
        if ((r62 & 256) == 0) goto L37;
        String r10 = null;
    L39:
        if ((r62 & 512) == 0) goto L41;
        String r11 = null;
    L43:
        if ((r62 & 1024) == 0) goto L45;
        String r12 = null;
    L47:
        if ((r62 & 2048) == 0) goto L49;
        String r13 = null;
    L51:
        if ((r62 & 4096) == 0) goto L53;
        String r14 = null;
    L55:
        if ((r62 & 8192) == 0) goto L57;
        String r15 = null;
    L59:
        if ((r62 & 16384) == 0) goto L61;
        Boolean r2 = null;
    L63:
        if ((r62 & 32768) == 0) goto L65;
        Integer r16 = null;
    L67:
        if ((r62 & 65536) == 0) goto L69;
        Integer r17 = null;
    L71:
        if ((r62 & 131072) == 0) goto L73;
        Boolean r18 = null;
    L75:
        if ((r62 & 262144) == 0) goto L77;
        Boolean r19 = null;
    L79:
        if ((r62 & 524288) == 0) goto L81;
        Float r20 = null;
    L83:
        if ((r62 & 1048576) == 0) goto L85;
        String r21 = null;
    L87:
        if ((r62 & 2097152) == 0) goto L89;
        String r22 = null;
    L91:
        if ((r62 & 4194304) == 0) goto L93;
        String r23 = null;
    L95:
        if ((r62 & 8388608) == 0) goto L97;
        String r24 = null;
    L99:
        if ((r62 & 16777216) == 0) goto L101;
        String r25 = null;
    L103:
        if ((r62 & 33554432) == 0) goto L105;
        String r26 = null;
    L107:
        if ((r62 & AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) == 0) goto L109;
        Integer r27 = null;
    L111:
        if ((r62 & 134217728) == 0) goto L113;
        String r28 = null;
    L115:
        if ((r62 & SQLiteDatabase.CREATE_IF_NECESSARY) == 0) goto L117;
        String r29 = null;
    L119:
        if ((r62 & SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING) == 0) goto L121;
        Long r0 = null;
    L122:
        this(r1, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r2, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r0);
        return;
    L121:
        r0 = r61;
        goto L122
    L117:
        r29 = r60;
        goto L119
    L113:
        r28 = r59;
        goto L115
    L109:
        r27 = r58;
        goto L111
    L105:
        r26 = r57;
        goto L107
    L101:
        r25 = r56;
        goto L103
    L97:
        r24 = r55;
        goto L99
    L93:
        r23 = r54;
        goto L95
    L89:
        r22 = r53;
        goto L91
    L85:
        r21 = r52;
        goto L87
    L81:
        r20 = r51;
        goto L83
    L77:
        r19 = r50;
        goto L79
    L73:
        r18 = r49;
        goto L75
    L69:
        r17 = r48;
        goto L71
    L65:
        r16 = r47;
        goto L67
    L61:
        r2 = r46;
        goto L63
    L57:
        r15 = r45;
        goto L59
    L53:
        r14 = r44;
        goto L55
    L49:
        r13 = r43;
        goto L51
    L45:
        r12 = r42;
        goto L47
    L41:
        r11 = r41;
        goto L43
    L37:
        r10 = r40;
        goto L39
    L33:
        r9 = r39;
        goto L35
    L29:
        r8 = r38;
        goto L31
    L25:
        r7 = r37;
        goto L27
    L21:
        r6 = r36;
        goto L23
    L17:
        r5 = r35;
        goto L19
    L13:
        r4 = r34;
        goto L15
    L9:
        r3 = r33;
        goto L11
    L5:
        r1 = r32;
        goto L7
    }

    public static /* synthetic */ SemanticBatchEntityPayload copy$default(SemanticBatchEntityPayload r17, String r18, Long r19, Long r20, Integer r21, Long r22, String r23, Integer r24, String r25, String r26, String r27, String r28, String r29, String r30, String r31, Boolean r32, Integer r33, Integer r34, Boolean r35, Boolean r36, Float r37, String r38, String r39, String r40, String r41, String r42, String r43, Integer r44, String r45, String r46, Long r47, int r48, Object r49) {
        if ((r48 & 1) == 0) goto L5;
        String r2 = r17.entityId;
    L7:
        if ((r48 & 2) == 0) goto L9;
        Long r3 = r17.createTime;
    L11:
        if ((r48 & 4) == 0) goto L13;
        Long r4 = r17.modifyTime;
    L15:
        if ((r48 & 8) == 0) goto L17;
        Integer r5 = r17.type;
    L19:
        if ((r48 & 16) == 0) goto L21;
        Long r6 = r17.timestamp;
    L23:
        if ((r48 & 32) == 0) goto L25;
        String r7 = r17.packageName;
    L27:
        if ((r48 & 64) == 0) goto L29;
        Integer r8 = r17.hashCodeValue;
    L31:
        if ((r48 & 128) == 0) goto L33;
        String r9 = r17.uuid;
    L35:
        if ((r48 & 256) == 0) goto L37;
        String r10 = r17.semanticType;
    L39:
        if ((r48 & 512) == 0) goto L41;
        String r11 = r17.tagPath;
    L43:
        if ((r48 & 1024) == 0) goto L45;
        String r12 = r17.keyPhrase;
    L47:
        if ((r48 & 2048) == 0) goto L49;
        String r13 = r17.description;
    L51:
        if ((r48 & 4096) == 0) goto L53;
        String r14 = r17.embeddingContent;
    L55:
        if ((r48 & 8192) == 0) goto L57;
        String r15 = r17.sources;
    L58:
        String r310 = r15;
        if ((r48 & 16384) == 0) goto L61;
        Boolean r16 = r17.userEdit;
    L62:
        Boolean r311 = r16;
        if ((r48 & 32768) == 0) goto L65;
        Integer r110 = r17.evidenceCount;
    L66:
        Integer r312 = r110;
        if ((r48 & 65536) == 0) goto L69;
        Integer r111 = r17.productType;
    L70:
        Integer r313 = r111;
        if ((r48 & 131072) == 0) goto L73;
        Boolean r112 = r17.useForInsight;
    L74:
        Boolean r314 = r112;
        if ((r48 & 262144) == 0) goto L77;
        Boolean r113 = r17.useForPersona;
    L78:
        Boolean r315 = r113;
        if ((r48 & 524288) == 0) goto L81;
        Float r114 = r17.confidence;
    L82:
        Float r316 = r114;
        if ((r48 & 1048576) == 0) goto L85;
        String r115 = r17.logId;
    L86:
        String r317 = r115;
        if ((r48 & 2097152) == 0) goto L89;
        String r116 = r17.importantRawRefIds;
    L90:
        String r318 = r116;
        if ((r48 & 4194304) == 0) goto L93;
        String r117 = r17.sourceRawRefIds;
    L94:
        String r410 = r117;
        if ((r48 & 8388608) == 0) goto L97;
        String r118 = r17.sceneIds;
    L98:
        String r411 = r118;
        if ((r48 & 16777216) == 0) goto L101;
        String r119 = r17.sourcePackageName;
    L102:
        String r412 = r119;
        if ((r48 & 33554432) == 0) goto L105;
        String r120 = r17.confirmationState;
    L106:
        String r413 = r120;
        if ((r48 & AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) == 0) goto L109;
        Integer r121 = r17.migrationVersion;
    L110:
        Integer r414 = r121;
        if ((r48 & 134217728) == 0) goto L113;
        String r122 = r17.evidenceIds;
    L114:
        String r415 = r122;
        if ((r48 & SQLiteDatabase.CREATE_IF_NECESSARY) == 0) goto L117;
        String r123 = r17.conflictEntityIds;
    L119:
        if ((r48 & SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING) == 0) goto L121;
        Long r1 = r17.lastUserAssertAt;
    L123:
        return r17.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r310, r311, r312, r313, r314, r315, r316, r317, r318, r410, r411, r412, r413, r414, r415, r123, r1);
    L121:
        r1 = r47;
        goto L123
    L117:
        r123 = r46;
        goto L119
    L113:
        r122 = r45;
        goto L114
    L109:
        r121 = r44;
        goto L110
    L105:
        r120 = r43;
        goto L106
    L101:
        r119 = r42;
        goto L102
    L97:
        r118 = r41;
        goto L98
    L93:
        r117 = r40;
        goto L94
    L89:
        r116 = r39;
        goto L90
    L85:
        r115 = r38;
        goto L86
    L81:
        r114 = r37;
        goto L82
    L77:
        r113 = r36;
        goto L78
    L73:
        r112 = r35;
        goto L74
    L69:
        r111 = r34;
        goto L70
    L65:
        r110 = r33;
        goto L66
    L61:
        r16 = r32;
        goto L62
    L57:
        r15 = r31;
        goto L58
    L53:
        r14 = r30;
        goto L55
    L49:
        r13 = r29;
        goto L51
    L45:
        r12 = r28;
        goto L47
    L41:
        r11 = r27;
        goto L43
    L37:
        r10 = r26;
        goto L39
    L33:
        r9 = r25;
        goto L35
    L29:
        r8 = r24;
        goto L31
    L25:
        r7 = r23;
        goto L27
    L21:
        r6 = r22;
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
        return this.entityId;
    }

    public final String component10() {
        return this.tagPath;
    }

    public final String component11() {
        return this.keyPhrase;
    }

    public final String component12() {
        return this.description;
    }

    public final String component13() {
        return this.embeddingContent;
    }

    public final String component14() {
        return this.sources;
    }

    public final Boolean component15() {
        return this.userEdit;
    }

    public final Integer component16() {
        return this.evidenceCount;
    }

    public final Integer component17() {
        return this.productType;
    }

    public final Boolean component18() {
        return this.useForInsight;
    }

    public final Boolean component19() {
        return this.useForPersona;
    }

    public final Long component2() {
        return this.createTime;
    }

    public final Float component20() {
        return this.confidence;
    }

    public final String component21() {
        return this.logId;
    }

    public final String component22() {
        return this.importantRawRefIds;
    }

    public final String component23() {
        return this.sourceRawRefIds;
    }

    public final String component24() {
        return this.sceneIds;
    }

    public final String component25() {
        return this.sourcePackageName;
    }

    public final String component26() {
        return this.confirmationState;
    }

    public final Integer component27() {
        return this.migrationVersion;
    }

    public final String component28() {
        return this.evidenceIds;
    }

    public final String component29() {
        return this.conflictEntityIds;
    }

    public final Long component3() {
        return this.modifyTime;
    }

    public final Long component30() {
        return this.lastUserAssertAt;
    }

    public final Integer component4() {
        return this.type;
    }

    public final Long component5() {
        return this.timestamp;
    }

    public final String component6() {
        return this.packageName;
    }

    public final Integer component7() {
        return this.hashCodeValue;
    }

    public final String component8() {
        return this.uuid;
    }

    public final String component9() {
        return this.semanticType;
    }

    public final SemanticBatchEntityPayload copy(String r33, Long r34, Long r35, Integer r36, Long r37, String r38, Integer r39, String r40, String r41, String r42, String r43, String r44, String r45, String r46, Boolean r47, Integer r48, Integer r49, Boolean r50, Boolean r51, Float r52, String r53, String r54, String r55, String r56, String r57, String r58, Integer r59, String r60, String r61, Long r62) {
        return new SemanticBatchEntityPayload(r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, SemanticBatchEntityPayload.class) == true) goto L8;
        return false;
    L8:
        SemanticBatchEntityPayload r6 = (SemanticBatchEntityPayload) ZeusTransformUtils.preCheckCast(r5, SemanticBatchEntityPayload.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.entityId, r6.entityId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.createTime, r6.createTime) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.modifyTime, r6.modifyTime) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.type, r6.type) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.timestamp, r6.timestamp) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.packageName, r6.packageName) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.hashCodeValue, r6.hashCodeValue) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.uuid, r6.uuid) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.semanticType, r6.semanticType) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.tagPath, r6.tagPath) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.keyPhrase, r6.keyPhrase) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.description, r6.description) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.embeddingContent, r6.embeddingContent) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.sources, r6.sources) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.userEdit, r6.userEdit) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.evidenceCount, r6.evidenceCount) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.productType, r6.productType) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.useForInsight, r6.useForInsight) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.useForPersona, r6.useForPersona) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.confidence, r6.confidence) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.logId, r6.logId) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.importantRawRefIds, r6.importantRawRefIds) == true) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.sourceRawRefIds, r6.sourceRawRefIds) == true) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.sceneIds, r6.sceneIds) == true) goto L81;
        return false;
    L81:
        if (Intrinsics.areEqual(this.sourcePackageName, r6.sourcePackageName) == true) goto L84;
        return false;
    L84:
        if (Intrinsics.areEqual(this.confirmationState, r6.confirmationState) == true) goto L87;
        return false;
    L87:
        if (Intrinsics.areEqual(this.migrationVersion, r6.migrationVersion) == true) goto L90;
        return false;
    L90:
        if (Intrinsics.areEqual(this.evidenceIds, r6.evidenceIds) == true) goto L93;
        return false;
    L93:
        if (Intrinsics.areEqual(this.conflictEntityIds, r6.conflictEntityIds) == true) goto L96;
        return false;
    L96:
        if (Intrinsics.areEqual(this.lastUserAssertAt, r6.lastUserAssertAt) == true) goto L98;
        return false;
    L98:
        return true;
    }

    public final Float getConfidence() {
        return this.confidence;
    }

    public final String getConfirmationState() {
        return this.confirmationState;
    }

    public final String getConflictEntityIds() {
        return this.conflictEntityIds;
    }

    public final Long getCreateTime() {
        return this.createTime;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getEmbeddingContent() {
        return this.embeddingContent;
    }

    public final String getEntityId() {
        return this.entityId;
    }

    public final Integer getEvidenceCount() {
        return this.evidenceCount;
    }

    public final String getEvidenceIds() {
        return this.evidenceIds;
    }

    public final Integer getHashCodeValue() {
        return this.hashCodeValue;
    }

    public final String getImportantRawRefIds() {
        return this.importantRawRefIds;
    }

    public final String getKeyPhrase() {
        return this.keyPhrase;
    }

    public final Long getLastUserAssertAt() {
        return this.lastUserAssertAt;
    }

    public final String getLogId() {
        return this.logId;
    }

    public final Integer getMigrationVersion() {
        return this.migrationVersion;
    }

    public final Long getModifyTime() {
        return this.modifyTime;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final Integer getProductType() {
        return this.productType;
    }

    public final String getSceneIds() {
        return this.sceneIds;
    }

    public final String getSemanticType() {
        return this.semanticType;
    }

    public final String getSourcePackageName() {
        return this.sourcePackageName;
    }

    public final String getSourceRawRefIds() {
        return this.sourceRawRefIds;
    }

    public final String getSources() {
        return this.sources;
    }

    public final String getTagPath() {
        return this.tagPath;
    }

    public final Long getTimestamp() {
        return this.timestamp;
    }

    public final Integer getType() {
        return this.type;
    }

    public final Boolean getUseForInsight() {
        return this.useForInsight;
    }

    public final Boolean getUseForPersona() {
        return this.useForPersona;
    }

    public final Boolean getUserEdit() {
        return this.userEdit;
    }

    public final String getUuid() {
        return this.uuid;
    }

    public final boolean hasInsertFields() {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(this.semanticType, CharSequence.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L30;
        CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast(this.tagPath, CharSequence.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L13;
    L16:
        boolean r3 = true;
    L17:
        if (r3 == true) goto L31;
        CharSequence r4 = (CharSequence) ZeusTransformUtils.preCheckCast(this.keyPhrase, CharSequence.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L21;
    L24:
        boolean r5 = true;
    L25:
        if (r5 == false) goto L27;
        return false;
    L27:
        if (this.productType != null) goto L29;
        return false;
    L29:
        return true;
    L21:
        if (StringsKt.isBlank(r4) == true) goto L24;
        r5 = false;
        goto L25
    L31:
        return false;
    L13:
        if (StringsKt.isBlank(r2) == true) goto L16;
        r3 = false;
        goto L17
    L30:
        return false;
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r1 = false;
        goto L9
    }

    public int hashCode() {
        String r0 = this.entityId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Long r4 = this.createTime;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Long r7 = this.modifyTime;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Integer r10 = this.type;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Long r13 = this.timestamp;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.packageName;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        Integer r19 = this.hashCodeValue;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        String r22 = this.uuid;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        String r25 = this.semanticType;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        String r28 = this.tagPath;
        if (r28 != null) goto L41;
        int r29 = 0;
    L42:
        int r30 = (r27 + r29) * 31;
        String r31 = this.keyPhrase;
        if (r31 != null) goto L45;
        int r32 = 0;
    L46:
        int r33 = (r30 + r32) * 31;
        String r34 = this.description;
        if (r34 != null) goto L49;
        int r35 = 0;
    L50:
        int r36 = (r33 + r35) * 31;
        String r37 = this.embeddingContent;
        if (r37 != null) goto L53;
        int r38 = 0;
    L54:
        int r39 = (r36 + r38) * 31;
        String r40 = this.sources;
        if (r40 != null) goto L57;
        int r41 = 0;
    L58:
        int r42 = (r39 + r41) * 31;
        Boolean r43 = this.userEdit;
        if (r43 != null) goto L61;
        int r44 = 0;
    L62:
        int r45 = (r42 + r44) * 31;
        Integer r46 = this.evidenceCount;
        if (r46 != null) goto L65;
        int r47 = 0;
    L66:
        int r48 = (r45 + r47) * 31;
        Integer r49 = this.productType;
        if (r49 != null) goto L69;
        int r50 = 0;
    L70:
        int r51 = (r48 + r50) * 31;
        Boolean r52 = this.useForInsight;
        if (r52 != null) goto L73;
        int r53 = 0;
    L74:
        int r54 = (r51 + r53) * 31;
        Boolean r55 = this.useForPersona;
        if (r55 != null) goto L77;
        int r56 = 0;
    L78:
        int r57 = (r54 + r56) * 31;
        Float r58 = this.confidence;
        if (r58 != null) goto L81;
        int r59 = 0;
    L82:
        int r60 = (r57 + r59) * 31;
        String r61 = this.logId;
        if (r61 != null) goto L85;
        int r62 = 0;
    L86:
        int r63 = (r60 + r62) * 31;
        String r64 = this.importantRawRefIds;
        if (r64 != null) goto L89;
        int r65 = 0;
    L90:
        int r66 = (r63 + r65) * 31;
        String r67 = this.sourceRawRefIds;
        if (r67 != null) goto L93;
        int r68 = 0;
    L94:
        int r69 = (r66 + r68) * 31;
        String r70 = this.sceneIds;
        if (r70 != null) goto L97;
        int r71 = 0;
    L98:
        int r72 = (r69 + r71) * 31;
        String r73 = this.sourcePackageName;
        if (r73 != null) goto L101;
        int r74 = 0;
    L102:
        int r75 = (r72 + r74) * 31;
        String r76 = this.confirmationState;
        if (r76 != null) goto L105;
        int r77 = 0;
    L106:
        int r78 = (r75 + r77) * 31;
        Integer r79 = this.migrationVersion;
        if (r79 != null) goto L109;
        int r80 = 0;
    L110:
        int r81 = (r78 + r80) * 31;
        String r82 = this.evidenceIds;
        if (r82 != null) goto L113;
        int r83 = 0;
    L114:
        int r84 = (r81 + r83) * 31;
        String r85 = this.conflictEntityIds;
        if (r85 != null) goto L117;
        int r86 = 0;
    L118:
        int r87 = (r84 + r86) * 31;
        Long r88 = this.lastUserAssertAt;
        if (r88 == null) goto L123;
        r1 = r88.hashCode();
    L123:
        return r87 + r1;
    L117:
        r86 = r85.hashCode();
        goto L118
    L113:
        r83 = r82.hashCode();
        goto L114
    L109:
        r80 = r79.hashCode();
        goto L110
    L105:
        r77 = r76.hashCode();
        goto L106
    L101:
        r74 = r73.hashCode();
        goto L102
    L97:
        r71 = r70.hashCode();
        goto L98
    L93:
        r68 = r67.hashCode();
        goto L94
    L89:
        r65 = r64.hashCode();
        goto L90
    L85:
        r62 = r61.hashCode();
        goto L86
    L81:
        r59 = r58.hashCode();
        goto L82
    L77:
        r56 = r55.hashCode();
        goto L78
    L73:
        r53 = r52.hashCode();
        goto L74
    L69:
        r50 = r49.hashCode();
        goto L70
    L65:
        r47 = r46.hashCode();
        goto L66
    L61:
        r44 = r43.hashCode();
        goto L62
    L57:
        r41 = r40.hashCode();
        goto L58
    L53:
        r38 = r37.hashCode();
        goto L54
    L49:
        r35 = r34.hashCode();
        goto L50
    L45:
        r32 = r31.hashCode();
        goto L46
    L41:
        r29 = r28.hashCode();
        goto L42
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

    public final ip toEntity(ip r49, long r50) {
        long r1 = System.currentTimeMillis();
        Long r6 = null;
        if (r49 == null) goto L8;
        String r7 = r49.getEntityId();
        if (r7 == null) goto L8;
    L7:
        String r11 = r7;
        if (r49 == null) goto L22;
        Integer r8 = Integer.valueOf(r49.i());
    L23:
        int r9 = com.obric.memorydata.union.build.i.a(r8, this.productType, 0, 4, null);
        if (this.keyPhrase == null) goto L26;
    L33:
        boolean r10 = true;
    L34:
        Long r12 = this.modifyTime;
        if (r12 == null) goto L38;
        long r13 = r12.longValue();
    L37:
        long r14 = r13;
    L42:
        String r15 = this.description;
        if (r15 != null) goto L49;
        if (r49 == null) goto L46;
        r15 = r49.d();
    L47:
        if (r15 != null) goto L49;
        r15 = "";
        goto L49
    L46:
        r15 = null;
    L49:
        Float r16 = this.confidence;
        if (r16 == null) goto L52;
    L51:
        float r17 = r16.floatValue();
    L58:
        r r18 = i.a(r9, r15, r17);
        String r19 = this.keyPhrase;
        if (r19 != null) goto L65;
        if (r49 == null) goto L62;
        r19 = r49.c();
    L63:
        if (r19 != null) goto L65;
        String r110 = "";
    L66:
        String r111 = this.embeddingContent;
        if (r111 != null) goto L76;
        if (r49 != null) goto L70;
    L75:
        r111 = i.a(r110, r18.a());
        goto L76
    L70:
        if (this.keyPhrase != null) goto L75;
        if (this.description != null) goto L75;
        r111 = r49.e();
    L76:
        String r26 = r111;
        if (r49 == null) goto L79;
        long r112 = r49.getId();
    L80:
        if (r49 == null) goto L82;
        long r20 = r49.getCreateTime();
    L86:
        if (r49 == null) goto L89;
        int r113 = r49.getType();
    L88:
        int r22 = r113;
        Long r114 = this.timestamp;
        if (r114 == null) goto L96;
    L95:
        r1 = r114.longValue();
    L101:
        if (r49 == null) goto L104;
        String r115 = r49.getPackageName();
        if (r115 == null) goto L104;
    L107:
        String r23 = r115;
        if (r49 == null) goto L111;
        int r116 = r49.getHashCodeValue();
    L110:
        int r24 = r116;
    L115:
        if (r49 == null) goto L118;
        String r117 = r49.getUuid();
        if (r117 == null) goto L118;
    L121:
        String r25 = r117;
        String r118 = this.semanticType;
        if (r118 != null) goto L128;
        if (r49 == null) goto L125;
        r118 = r49.a();
    L126:
        if (r118 != null) goto L128;
        String r27 = "";
    L129:
        String r119 = this.tagPath;
        if (r119 != null) goto L136;
        if (r49 == null) goto L133;
        r119 = r49.b();
    L134:
        if (r119 != null) goto L136;
        String r28 = "";
    L137:
        String r29 = r18.a();
        String r120 = this.sources;
        if (r120 != null) goto L144;
        if (r49 == null) goto L141;
        r120 = r49.f();
    L142:
        if (r120 != null) goto L144;
        String r30 = "";
    L145:
        Boolean r21 = this.userEdit;
        if (r21 == null) goto L148;
    L147:
        boolean r31 = r21.booleanValue();
    L154:
        Integer r32 = this.evidenceCount;
        if (r32 == null) goto L157;
    L156:
        int r33 = r32.intValue();
    L163:
        Boolean r34 = this.useForInsight;
        if (r34 == null) goto L166;
    L165:
        boolean r35 = r34.booleanValue();
    L172:
        Boolean r36 = this.useForPersona;
        if (r36 == null) goto L175;
    L174:
        boolean r37 = r36.booleanValue();
    L181:
        float r38 = r18.b();
        String r39 = this.logId;
        if (r39 != null) goto L186;
        if (r49 == null) goto L185;
        r39 = r49.m();
        goto L186
    L185:
        String r310 = null;
    L187:
        String r40 = this.importantRawRefIds;
        if (r40 != null) goto L194;
        if (r49 == null) goto L191;
        r40 = r49.n();
    L192:
        if (r40 != null) goto L194;
        String r311 = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
    L195:
        String r41 = this.sourceRawRefIds;
        if (r41 != null) goto L202;
        if (r49 == null) goto L199;
        r41 = r49.o();
    L200:
        if (r41 != null) goto L202;
        String r312 = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
    L203:
        String r42 = this.sceneIds;
        if (r42 != null) goto L210;
        if (r49 == null) goto L207;
        r42 = r49.p();
    L208:
        if (r42 != null) goto L210;
        String r313 = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
    L211:
        String r43 = this.sourcePackageName;
        if (r43 != null) goto L218;
        if (r49 == null) goto L215;
        r43 = r49.q();
    L216:
        if (r43 != null) goto L218;
        String r44 = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
    L219:
        String r45 = this.confirmationState;
        if (r45 != null) goto L226;
        if (r49 == null) goto L223;
        r45 = r49.s();
    L224:
        if (r45 != null) goto L226;
        r45 = "none";
        goto L226
    L223:
        r45 = null;
    L226:
        String r46 = r45;
        Integer r47 = this.migrationVersion;
        if (r49 == null) goto L229;
        Integer r121 = Integer.valueOf(r49.t());
    L230:
        int r48 = i.a(r9, r47, r121);
        GsonUtil r51 = GsonUtil.INSTANCE;
        GsonUtil r122 = GsonUtil.INSTANCE;
        if (r49 == null) goto L233;
        String r123 = r49.u();
    L234:
        if (r123 != null) goto L236;
    L244:
        List r3 = null;
    L245:
        if (r3 != null) goto L247;
        r3 = CollectionsKt.emptyList();
    L247:
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.memorydata.plugin");
        GsonUtil r124 = GsonUtil.INSTANCE;
        String r125 = this.evidenceIds;
        if (r125 != null) goto L250;
    L258:
        List r5 = null;
    L259:
        if (r5 != null) goto L261;
        r5 = CollectionsKt.emptyList();
    L261:
        String r410 = r51.toJson(CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.plus(r4, (Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin")));
        String r52 = this.conflictEntityIds;
        if (r52 != null) goto L268;
        if (r49 == null) goto L265;
        r52 = r49.v();
    L266:
        if (r52 != null) goto L268;
        String r411 = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
    L269:
        Long r0 = this.lastUserAssertAt;
        if (r0 == null) goto L273;
        long r53 = r0.longValue();
    L272:
        long r412 = r53;
    L279:
        return new ip(r112, r11, r20, r14, r22, r1, r23, r24, r25, r27, r28, r110, r29, r26, r30, r31, r33, r9, r35, r37, r38, r310, r311, r312, r313, r44, r50, r46, r48, r410, r411, r412);
    L273:
        if (r49 == null) goto L275;
        r6 = Long.valueOf(r49.w());
    L275:
        if (r6 == null) goto L277;
        r53 = r6.longValue();
        goto L272
    L277:
        r412 = 0;
        goto L279
    L265:
        r52 = null;
    L268:
        r411 = r52;
        goto L269
    L250:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r125, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L252;
        boolean r413 = true;
    L253:
        if (r413 == true) goto L256;
        r125 = null;
    L256:
        if (r125 == null) goto L258;
        r5 = (List) ZeusTransformUtils.preCheckCast(GsonUtil.INSTANCE.getGSON().fromJson(r125, new c().getType()), List.class, "com.obric.memorydata.plugin");
        goto L259
    L252:
        r413 = false;
        goto L253
    L236:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r123, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L238;
        boolean r126 = true;
    L239:
        if (r126 == true) goto L242;
        r123 = null;
    L242:
        if (r123 == null) goto L244;
        r3 = (List) ZeusTransformUtils.preCheckCast(GsonUtil.INSTANCE.getGSON().fromJson(r123, new b().getType()), List.class, "com.obric.memorydata.plugin");
        goto L245
    L238:
        r126 = false;
        goto L239
    L233:
        r123 = null;
        goto L234
    L229:
        r121 = null;
        goto L230
    L215:
        r43 = null;
    L218:
        r44 = r43;
        goto L219
    L207:
        r42 = null;
    L210:
        r313 = r42;
        goto L211
    L199:
        r41 = null;
    L202:
        r312 = r41;
        goto L203
    L191:
        r40 = null;
    L194:
        r311 = r40;
    L186:
        r310 = r39;
        goto L187
    L175:
        if (r49 == null) goto L177;
        r36 = Boolean.valueOf(r49.k());
    L178:
        if (r36 != null) goto L174;
        r37 = false;
        goto L181
    L177:
        r36 = null;
        goto L178
    L166:
        if (r49 == null) goto L168;
        r34 = Boolean.valueOf(r49.j());
    L169:
        if (r34 != null) goto L165;
        r35 = false;
        goto L172
    L168:
        r34 = null;
        goto L169
    L157:
        if (r49 == null) goto L159;
        r32 = Integer.valueOf(r49.h());
    L160:
        if (r32 != null) goto L156;
        r33 = 1;
        goto L163
    L159:
        r32 = null;
        goto L160
    L148:
        if (r49 == null) goto L150;
        r21 = Boolean.valueOf(r49.g());
    L151:
        if (r21 != null) goto L147;
        r31 = false;
        goto L154
    L150:
        r21 = null;
        goto L151
    L141:
        r120 = null;
    L144:
        r30 = r120;
        goto L145
    L133:
        r119 = null;
    L136:
        r28 = r119;
        goto L137
    L125:
        r118 = null;
    L128:
        r27 = r118;
    L118:
        r117 = this.uuid;
        if (r117 != null) goto L121;
        r117 = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(r117, "toString(...)");
        goto L121
    L111:
        Integer r127 = this.hashCodeValue;
        if (r127 == null) goto L114;
        r116 = r127.intValue();
        goto L110
    L114:
        r24 = 0;
    L104:
        r115 = this.packageName;
        if (r115 != null) goto L107;
        r115 = AppContext.INSTANCE.getPackageName();
        goto L107
    L96:
        if (r49 == null) goto L98;
        r114 = Long.valueOf(r49.getTimestamp());
    L99:
        if (r114 == null) goto L101;
    L98:
        r114 = null;
        goto L99
    L89:
        Integer r128 = this.type;
        if (r128 == null) goto L92;
        r113 = r128.intValue();
        goto L88
    L92:
        r113 = NetError.ERR_CACHE_READ_FAILURE;
        goto L88
    L82:
        Long r129 = this.createTime;
        if (r129 == null) goto L85;
        r20 = r129.longValue();
        goto L86
    L85:
        r20 = r1;
        goto L86
    L79:
        r112 = 0;
        goto L80
    L62:
        r19 = null;
    L65:
        r110 = r19;
        goto L66
    L52:
        if (r49 == null) goto L54;
        r16 = Float.valueOf(r49.l());
    L55:
        if (r16 != null) goto L51;
        r17 = 0.0f;
        goto L58
    L54:
        r16 = null;
        goto L55
    L38:
        if (r49 == null) goto L41;
        if (r10 == true) goto L41;
        r13 = r49.getModifyTime();
    L41:
        r14 = r1;
        goto L42
    L26:
        if (this.description != null) goto L33;
        if (this.semanticType != null) goto L33;
        if (this.tagPath != null) goto L33;
        r10 = false;
        goto L34
    L22:
        r8 = null;
    L8:
        r7 = this.entityId;
        if (r7 != null) goto L11;
    L13:
        r7 = null;
    L14:
        if (r7 != null) goto L7;
        com.obric.memorydata.union.build.a r54 = com.obric.memorydata.union.build.a.f13066a;
        Integer r55 = this.productType;
        if (r55 == null) goto L18;
        int r56 = r55.intValue();
    L19:
        r7 = r54.a(String.valueOf(r56));
        goto L7
    L18:
        r56 = 0;
        goto L19
    L11:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L13;
        goto L13
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("SemanticBatchEntityPayload(entityId=").append(this.entityId).append(", createTime=").append(this.createTime).append(", modifyTime=").append(this.modifyTime).append(", type=").append(this.type).append(", timestamp=").append(this.timestamp).append(", packageName=").append(this.packageName).append(", hashCodeValue=").append(this.hashCodeValue).append(", uuid=").append(this.uuid).append(", semanticType=").append(this.semanticType).append(", tagPath=").append(this.tagPath).append(", keyPhrase=").append(this.keyPhrase).append(", description=");
        r0.append(this.description).append(", embeddingContent=").append(this.embeddingContent).append(", sources=").append(this.sources).append(", userEdit=").append(this.userEdit).append(", evidenceCount=").append(this.evidenceCount).append(", productType=").append(this.productType).append(", useForInsight=").append(this.useForInsight).append(", useForPersona=").append(this.useForPersona).append(", confidence=").append(this.confidence).append(", logId=").append(this.logId).append(", importantRawRefIds=").append(this.importantRawRefIds).append(", sourceRawRefIds=").append(this.sourceRawRefIds);
        r0.append(", sceneIds=").append(this.sceneIds).append(", sourcePackageName=").append(this.sourcePackageName).append(", confirmationState=").append(this.confirmationState).append(", migrationVersion=").append(this.migrationVersion).append(", evidenceIds=").append(this.evidenceIds).append(", conflictEntityIds=").append(this.conflictEntityIds).append(", lastUserAssertAt=").append(this.lastUserAssertAt).append(')');
        return r0.toString();
    }
}
