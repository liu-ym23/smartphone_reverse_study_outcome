package com.obric.memorydata.database.legacy.entity;

import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.entity.EventBody;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.zetetic.database.sqlcipher.SQLiteDatabase;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\bM\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b+\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001Bù\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\r\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0015\u0012\u0006\u0010\u001b\u001a\u00020\u0007\u0012\u0006\u0010\u001c\u001a\u00020\u0003\u0012\u0006\u0010\u001d\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0003\u0012\b\b\u0002\u0010 \u001a\u00020\u0007\u0012\b\b\u0002\u0010!\u001a\u00020\u000f\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0015\u0012\u0006\u0010$\u001a\u00020\u000f\u0012\b\b\u0002\u0010%\u001a\u00020\u0007\u0012\b\b\u0002\u0010&\u001a\u00020\u0007\u0012\b\b\u0002\u0010'\u001a\u00020\u0007\u0012\b\b\u0002\u0010(\u001a\u00020\u0007\u0012\b\b\u0002\u0010)\u001a\u00020\u0015¢\u0006\u0004\b*\u0010+J\n\u0010b\u001a\u0004\u0018\u00010cH\u0014J\u001a\u0010d\u001a\u0004\u0018\u00010e2\u0006\u0010f\u001a\u00020\u00072\u0006\u0010g\u001a\u00020\u0007H\u0016J\u0012\u0010h\u001a\u0004\u0018\u00010e2\u0006\u0010f\u001a\u00020\u0007H\u0016J\t\u0010i\u001a\u00020\u0003HÆ\u0003J\t\u0010j\u001a\u00020\u0003HÆ\u0003J\t\u0010k\u001a\u00020\u0003HÆ\u0003J\t\u0010l\u001a\u00020\u0007HÆ\u0003J\t\u0010m\u001a\u00020\u0007HÆ\u0003J\u000b\u0010n\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010o\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010p\u001a\u00020\u0007HÆ\u0003J\t\u0010q\u001a\u00020\u0007HÆ\u0003J\t\u0010r\u001a\u00020\u0007HÆ\u0003J\u0010\u0010s\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010=J\u0010\u0010t\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010=J\u000b\u0010u\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010v\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010w\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010x\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0002\u0010DJ\u0010\u0010y\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0002\u0010DJ\t\u0010z\u001a\u00020\u0015HÆ\u0003J\t\u0010{\u001a\u00020\u0003HÆ\u0003J\t\u0010|\u001a\u00020\u0003HÆ\u0003J\u0010\u0010}\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0002\u0010DJ\t\u0010~\u001a\u00020\u0007HÆ\u0003J\t\u0010\u007f\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0080\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0081\u0001\u001a\u00020\u000fHÆ\u0003J\n\u0010\u0082\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0083\u0001\u001a\u00020\u0007HÆ\u0003J\n\u0010\u0084\u0001\u001a\u00020\u000fHÆ\u0003J\f\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0011\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0002\u0010DJ\n\u0010\u0087\u0001\u001a\u00020\u000fHÆ\u0003J\n\u0010\u0088\u0001\u001a\u00020\u0007HÆ\u0003J\n\u0010\u0089\u0001\u001a\u00020\u0007HÆ\u0003J\n\u0010\u008a\u0001\u001a\u00020\u0007HÆ\u0003J\n\u0010\u008b\u0001\u001a\u00020\u0007HÆ\u0003J\n\u0010\u008c\u0001\u001a\u00020\u0015HÆ\u0003J\u0090\u0003\u0010\u008d\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u00072\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00152\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00032\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u001b\u001a\u00020\u00072\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u000f2\b\b\u0002\u0010\u001f\u001a\u00020\u00032\b\b\u0002\u0010 \u001a\u00020\u00072\b\b\u0002\u0010!\u001a\u00020\u000f2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010$\u001a\u00020\u000f2\b\b\u0002\u0010%\u001a\u00020\u00072\b\b\u0002\u0010&\u001a\u00020\u00072\b\b\u0002\u0010'\u001a\u00020\u00072\b\b\u0002\u0010(\u001a\u00020\u00072\b\b\u0002\u0010)\u001a\u00020\u0015HÆ\u0001¢\u0006\u0003\u0010\u008e\u0001J\u0016\u0010\u008f\u0001\u001a\u00020\u00152\n\u0010\u0090\u0001\u001a\u0005\u0018\u00010\u0091\u0001HÖ\u0003J\n\u0010\u0092\u0001\u001a\u00020\u000fHÖ\u0001J\n\u0010\u0093\u0001\u001a\u00020\u0007HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u0010-R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u0010-R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b4\u00103R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00103\"\u0004\b6\u00107R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b8\u00103R\u0011\u0010\u000b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b9\u00103R\u0011\u0010\f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b:\u00103R\u0011\u0010\r\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b;\u00103R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010>\u001a\u0004\b<\u0010=R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010>\u001a\u0004\b?\u0010=R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b@\u00103R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\bA\u00103R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\bB\u00103R\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\n\n\u0002\u0010E\u001a\u0004\bC\u0010DR\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u0015¢\u0006\n\n\u0002\u0010E\u001a\u0004\bF\u0010DR\u0016\u0010\u0017\u001a\u00020\u00158\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bG\u0010HR\u0016\u0010\u0018\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bI\u0010-R\u0016\u0010\u0019\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010-R\u0015\u0010\u001a\u001a\u0004\u0018\u00010\u0015¢\u0006\n\n\u0002\u0010E\u001a\u0004\bK\u0010DR\u0014\u0010\u001b\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bL\u00103R\u0014\u0010\u001c\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bM\u0010-R\u0014\u0010\u001d\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bN\u0010-R\u0014\u0010\u001e\u001a\u00020\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bO\u0010PR\u001a\u0010\u001f\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010-\"\u0004\bR\u0010/R\u0014\u0010 \u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bS\u00103R\u0014\u0010!\u001a\u00020\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bT\u0010PR\u001c\u0010\"\u001a\u0004\u0018\u00010\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u00103\"\u0004\bV\u00107R\"\u0010#\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010E\u001a\u0004\bW\u0010D\"\u0004\bX\u0010YR\u001e\u0010$\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010P\"\u0004\b[\u0010\\R\u0016\u0010%\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b]\u00103R\u0016\u0010&\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b^\u00103R\u0016\u0010'\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b_\u00103R\u0016\u0010(\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b`\u00103R\u0016\u0010)\u001a\u00020\u00158\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\ba\u0010H¨\u0006\u0094\u0001"}, d2 = {"Lcom/obric/memorydata/database/legacy/entity/EpisodicMemoryEntityOld;", "Lcom/obric/memorydata/database/entity/AbstractRawDbEntity;", OaidModel.KEY_ID, "", "actionTimestamp", "uid", "title", "", Params.CONTENT, "contentWithTime", "fullContent", "observation", "location", "appNames", EventBody.KEY_CATEGORY, "", "profileType", "profileTag", "tagOther", "logId", "usedForPortrait", "", "useLocation", "useForUserKeyword", "startTimestamp", "endTimestamp", "useForTopic", "entityId", "createTime", "modifyTime", "type", "timestamp", ObricMemoryConstants.KEY_PACKAGE_NAME, "hashCodeValue", Api.KEY_UUID, "userEdit", "productType", "importantRawRefIds", "sourceRawRefIds", "sceneIds", "sourcePackageName", "personalDbSplitMigrated", "<init>", "(JJJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;ZJJLjava/lang/Boolean;Ljava/lang/String;JJIJLjava/lang/String;ILjava/lang/String;Ljava/lang/Boolean;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getId", "()J", "setId", "(J)V", "getActionTimestamp", "getUid", "getTitle", "()Ljava/lang/String;", "getContent", "getContentWithTime", "setContentWithTime", "(Ljava/lang/String;)V", "getFullContent", "getObservation", "getLocation", "getAppNames", "getCategory", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getProfileType", "getProfileTag", "getTagOther", "getLogId", "getUsedForPortrait", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getUseLocation", "getUseForUserKeyword", "()Z", "getStartTimestamp", "getEndTimestamp", "getUseForTopic", "getEntityId", "getCreateTime", "getModifyTime", "getType", "()I", "getTimestamp", "setTimestamp", "getPackageName", "getHashCodeValue", "getUuid", "setUuid", "getUserEdit", "setUserEdit", "(Ljava/lang/Boolean;)V", "getProductType", "setProductType", "(I)V", "getImportantRawRefIds", "getSourceRawRefIds", "getSceneIds", "getSourcePackageName", "getPersonalDbSplitMigrated", "convertToAppEntityInternal", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "convertToTextVectorCopilotEntity", "Lcom/obric/memorydata/database/entity/AbstractVectorCopilotEntity;", "column", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "convertToImageVectorCopilotEntity", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "copy", "(JJJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;ZJJLjava/lang/Boolean;Ljava/lang/String;JJIJLjava/lang/String;ILjava/lang/String;Ljava/lang/Boolean;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Lcom/obric/memorydata/database/legacy/entity/EpisodicMemoryEntityOld;", "equals", "other", "", "hashCode", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class EpisodicMemoryEntityOld extends com.obric.memorydata.database.entity.d {
    private final long actionTimestamp;
    private final String appNames;
    private final Integer category;
    private final String content;
    private String contentWithTime;
    private final long createTime;
    private final long endTimestamp;
    private final String entityId;
    private final String fullContent;
    private final int hashCodeValue;
    private long id;
    private final String importantRawRefIds;
    private final String location;
    private final String logId;
    private final long modifyTime;
    private final String observation;
    private final String packageName;
    private final boolean personalDbSplitMigrated;
    private int productType;
    private final String profileTag;
    private final Integer profileType;
    private final String sceneIds;
    private final String sourcePackageName;
    private final String sourceRawRefIds;
    private final long startTimestamp;
    private final String tagOther;
    private long timestamp;
    private final String title;
    private final int type;
    private final long uid;
    private final Boolean useForTopic;
    private final boolean useForUserKeyword;
    private final Boolean useLocation;
    private final Boolean usedForPortrait;
    private Boolean userEdit;
    private String uuid;

    public EpisodicMemoryEntityOld(long r31, long r33, long r35, String r37, String r38, String r39, String r40, String r41, String r42, String r43, Integer r44, Integer r45, String r46, String r47, String r48, Boolean r49, Boolean r50, boolean r51, long r52, long r54, Boolean r56, String r57, long r58, long r60, int r62, long r63, String r65, int r66, String r67, Boolean r68, int r69, String r70, String r71, String r72, String r73, boolean r74) {
        Intrinsics.checkNotNullParameter(r37, "title");
        Intrinsics.checkNotNullParameter(r38, Params.CONTENT);
        Intrinsics.checkNotNullParameter(r41, "observation");
        Intrinsics.checkNotNullParameter(r42, "location");
        Intrinsics.checkNotNullParameter(r43, "appNames");
        Intrinsics.checkNotNullParameter(r57, "entityId");
        Intrinsics.checkNotNullParameter(r65, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r70, "importantRawRefIds");
        Intrinsics.checkNotNullParameter(r71, "sourceRawRefIds");
        Intrinsics.checkNotNullParameter(r72, "sceneIds");
        Intrinsics.checkNotNullParameter(r73, "sourcePackageName");
        Integer r9 = null;
        super(r31, r57, r58, r60, r62, r63, r65, r66, r67, r9, r9, null, 3584, null);
        this.id = r31;
        this.actionTimestamp = r33;
        this.uid = r35;
        this.title = r37;
        this.content = r38;
        this.contentWithTime = r39;
        this.fullContent = r40;
        this.observation = r41;
        this.location = r42;
        this.appNames = r43;
        this.category = r44;
        this.profileType = r45;
        this.profileTag = r46;
        this.tagOther = r47;
        this.logId = r48;
        this.usedForPortrait = r49;
        this.useLocation = r50;
        this.useForUserKeyword = r51;
        this.startTimestamp = r52;
        this.endTimestamp = r54;
        this.useForTopic = r56;
        this.entityId = r57;
        this.createTime = r58;
        this.modifyTime = r60;
        this.type = r62;
        this.timestamp = r63;
        this.packageName = r65;
        this.hashCodeValue = r66;
        this.uuid = r67;
        this.userEdit = r68;
        this.productType = r69;
        this.importantRawRefIds = r70;
        this.sourceRawRefIds = r71;
        this.sceneIds = r72;
        this.sourcePackageName = r73;
        this.personalDbSplitMigrated = r74;
    }

    public /* synthetic */ EpisodicMemoryEntityOld(long r50, long r52, long r54, String r56, String r57, String r58, String r59, String r60, String r61, String r62, Integer r63, Integer r64, String r65, String r66, String r67, Boolean r68, Boolean r69, boolean r70, long r71, long r73, Boolean r75, String r76, long r77, long r79, int r81, long r82, String r84, int r85, String r86, Boolean r87, int r88, String r89, String r90, String r91, String r92, boolean r93, int r94, int r95, DefaultConstructorMarker r96) {
        if ((r94 & 1) == 0) goto L5;
        long r5 = 0;
    L7:
        if ((r94 & 2) == 0) goto L9;
        long r7 = 0;
    L11:
        if ((r94 & 4) == 0) goto L13;
        long r9 = 0;
    L15:
        if ((r94 & 32) == 0) goto L17;
        String r13 = null;
    L19:
        if ((r94 & 64) == 0) goto L21;
        String r14 = "";
    L23:
        if ((r94 & 256) == 0) goto L25;
        String r16 = "";
    L27:
        if ((r94 & 512) == 0) goto L29;
        String r17 = "";
    L31:
        if ((r94 & 1024) == 0) goto L33;
        Integer r18 = 0;
    L35:
        if ((r94 & 2048) == 0) goto L37;
        Integer r19 = null;
    L39:
        if ((r94 & 4096) == 0) goto L41;
        String r20 = null;
    L43:
        if ((r94 & 8192) == 0) goto L45;
        String r21 = null;
    L47:
        if ((r94 & 16384) == 0) goto L49;
        String r22 = null;
    L51:
        if ((32768 & r94) == 0) goto L53;
        Boolean r23 = null;
    L55:
        if ((65536 & r94) == 0) goto L57;
        Boolean r24 = null;
    L59:
        if ((131072 & r94) == 0) goto L61;
        boolean r25 = false;
    L63:
        if ((262144 & r94) == 0) goto L65;
        long r26 = 0;
    L67:
        if ((524288 & r94) == 0) goto L69;
        long r28 = 0;
    L71:
        if ((1048576 & r94) == 0) goto L73;
        Boolean r30 = null;
    L75:
        if ((16777216 & r94) == 0) goto L77;
        int r36 = -306;
    L79:
        if ((33554432 & r94) == 0) goto L81;
        long r37 = System.currentTimeMillis();
    L83:
        if ((67108864 & r94) == 0) goto L85;
        String r39 = AppContext.INSTANCE.getPackageName();
    L87:
        if ((134217728 & r94) == 0) goto L89;
        int r40 = 0;
    L91:
        if ((268435456 & r94) == 0) goto L93;
        String r41 = UUID.randomUUID().toString();
    L95:
        if ((536870912 & r94) == 0) goto L97;
        Boolean r42 = null;
    L99:
        if ((r94 & Integer.MIN_VALUE) == 0) goto L101;
        String r44 = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
    L103:
        if ((r95 & 1) == 0) goto L105;
        String r45 = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
    L107:
        if ((r95 & 2) == 0) goto L109;
        String r46 = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
    L111:
        if ((r95 & 4) == 0) goto L113;
        String r47 = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
    L115:
        if ((r95 & 8) == 0) goto L117;
        boolean r48 = false;
    L118:
        this(r5, r7, r9, r56, r57, r13, r14, r60, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r28, r30, r76, r77, r79, r36, r37, r39, r40, r41, r42, r88, r44, r45, r46, r47, r48);
        return;
    L117:
        r48 = r93;
        goto L118
    L113:
        r47 = r92;
        goto L115
    L109:
        r46 = r91;
        goto L111
    L105:
        r45 = r90;
        goto L107
    L101:
        r44 = r89;
        goto L103
    L97:
        r42 = r87;
        goto L99
    L93:
        r41 = r86;
        goto L95
    L89:
        r40 = r85;
        goto L91
    L85:
        r39 = r84;
        goto L87
    L81:
        r37 = r82;
        goto L83
    L77:
        r36 = r81;
        goto L79
    L73:
        r30 = r75;
        goto L75
    L69:
        r28 = r73;
        goto L71
    L65:
        r26 = r71;
        goto L67
    L61:
        r25 = r70;
        goto L63
    L57:
        r24 = r69;
        goto L59
    L53:
        r23 = r68;
        goto L55
    L49:
        r22 = r67;
        goto L51
    L45:
        r21 = r66;
        goto L47
    L41:
        r20 = r65;
        goto L43
    L37:
        r19 = r64;
        goto L39
    L33:
        r18 = r63;
        goto L35
    L29:
        r17 = r62;
        goto L31
    L25:
        r16 = r61;
        goto L27
    L21:
        r14 = r59;
        goto L23
    L17:
        r13 = r58;
        goto L19
    L13:
        r9 = r54;
        goto L15
    L9:
        r7 = r52;
        goto L11
    L5:
        r5 = r50;
        goto L7
    }

    public static /* synthetic */ EpisodicMemoryEntityOld copy$default(EpisodicMemoryEntityOld r17, long r18, long r20, long r22, String r24, String r25, String r26, String r27, String r28, String r29, String r30, Integer r31, Integer r32, String r33, String r34, String r35, Boolean r36, Boolean r37, boolean r38, long r39, long r41, Boolean r43, String r44, long r45, long r47, int r49, long r50, String r52, int r53, String r54, Boolean r55, int r56, String r57, String r58, String r59, String r60, boolean r61, int r62, int r63, Object r64) {
        if ((r62 & 1) == 0) goto L5;
        long r2 = r17.id;
    L7:
        if ((r62 & 2) == 0) goto L9;
        long r4 = r17.actionTimestamp;
    L11:
        if ((r62 & 4) == 0) goto L13;
        long r6 = r17.uid;
    L15:
        if ((r62 & 8) == 0) goto L17;
        String r8 = r17.title;
    L19:
        if ((r62 & 16) == 0) goto L21;
        String r9 = r17.content;
    L23:
        if ((r62 & 32) == 0) goto L25;
        String r10 = r17.contentWithTime;
    L27:
        if ((r62 & 64) == 0) goto L29;
        String r11 = r17.fullContent;
    L31:
        if ((r62 & 128) == 0) goto L33;
        String r12 = r17.observation;
    L35:
        if ((r62 & 256) == 0) goto L37;
        String r13 = r17.location;
    L39:
        if ((r62 & 512) == 0) goto L41;
        String r14 = r17.appNames;
    L43:
        if ((r62 & 1024) == 0) goto L45;
        Integer r15 = r17.category;
    L46:
        Integer r310 = r15;
        if ((r62 & 2048) == 0) goto L49;
        Integer r16 = r17.profileType;
    L50:
        Integer r311 = r16;
        if ((r62 & 4096) == 0) goto L53;
        String r19 = r17.profileTag;
    L54:
        String r312 = r19;
        if ((r62 & 8192) == 0) goto L57;
        String r110 = r17.tagOther;
    L58:
        String r313 = r110;
        if ((r62 & 16384) == 0) goto L61;
        String r111 = r17.logId;
    L62:
        String r314 = r111;
        if ((r62 & 32768) == 0) goto L65;
        Boolean r112 = r17.usedForPortrait;
    L66:
        Boolean r315 = r112;
        if ((r62 & 65536) == 0) goto L69;
        Boolean r113 = r17.useLocation;
    L70:
        Boolean r316 = r113;
        if ((r62 & 131072) == 0) goto L73;
        boolean r114 = r17.useForUserKeyword;
    L74:
        String r317 = r14;
        boolean r318 = r114;
        if ((r62 & 262144) == 0) goto L77;
        long r115 = r17.startTimestamp;
    L78:
        long r319 = r115;
        if ((r62 & 524288) == 0) goto L81;
        long r116 = r17.endTimestamp;
    L82:
        long r42 = r116;
        if ((r62 & 1048576) == 0) goto L85;
        Boolean r117 = r17.useForTopic;
    L87:
        if ((2097152 & r62) == 0) goto L89;
        String r118 = r17.entityId;
    L90:
        Boolean r46 = r117;
        String r48 = r118;
        if ((r62 & 4194304) == 0) goto L93;
        long r119 = r17.createTime;
    L94:
        long r410 = r119;
        if ((r62 & 8388608) == 0) goto L97;
        long r120 = r17.modifyTime;
    L98:
        long r411 = r120;
        if ((r62 & 16777216) == 0) goto L101;
        int r121 = r17.type;
    L102:
        int r412 = r121;
        if ((33554432 & r62) == 0) goto L105;
        long r122 = r17.timestamp;
    L106:
        long r51 = r122;
        if ((r62 & AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) == 0) goto L109;
        String r123 = r17.packageName;
    L111:
        if ((134217728 & r62) == 0) goto L113;
        int r124 = r17.hashCodeValue;
    L114:
        int r510 = r124;
        if ((r62 & SQLiteDatabase.CREATE_IF_NECESSARY) == 0) goto L117;
        String r125 = r17.uuid;
    L118:
        String r511 = r125;
        if ((r62 & SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING) == 0) goto L121;
        Boolean r126 = r17.userEdit;
    L122:
        Boolean r512 = r126;
        if ((r62 & 1073741824) == 0) goto L125;
        int r127 = r17.productType;
    L127:
        if ((r62 & Integer.MIN_VALUE) == 0) goto L129;
        String r1 = r17.importantRawRefIds;
    L130:
        String r513 = r1;
        if ((r63 & 1) == 0) goto L133;
        String r3 = r17.sourceRawRefIds;
    L134:
        String r514 = r3;
        if ((r63 & 2) == 0) goto L137;
        String r5 = r17.sceneIds;
    L138:
        String r515 = r5;
        if ((r63 & 4) == 0) goto L141;
        String r7 = r17.sourcePackageName;
    L142:
        String r65 = r7;
        if ((r63 & 8) == 0) goto L145;
        boolean r21 = r17.personalDbSplitMigrated;
    L147:
        return r17.copy(r2, r4, r6, r8, r9, r10, r11, r12, r13, r317, r310, r311, r312, r313, r314, r315, r316, r318, r319, r42, r46, r48, r410, r411, r412, r51, r123, r510, r511, r512, r127, r513, r514, r515, r65, r21);
    L145:
        r21 = r61;
        goto L147
    L141:
        r7 = r60;
        goto L142
    L137:
        r5 = r59;
        goto L138
    L133:
        r3 = r58;
        goto L134
    L129:
        r1 = r57;
        goto L130
    L125:
        r127 = r56;
        goto L127
    L121:
        r126 = r55;
        goto L122
    L117:
        r125 = r54;
        goto L118
    L113:
        r124 = r53;
        goto L114
    L109:
        r123 = r52;
        goto L111
    L105:
        r122 = r50;
        goto L106
    L101:
        r121 = r49;
        goto L102
    L97:
        r120 = r47;
        goto L98
    L93:
        r119 = r45;
        goto L94
    L89:
        r118 = r44;
        goto L90
    L85:
        r117 = r43;
        goto L87
    L81:
        r116 = r41;
        goto L82
    L77:
        r115 = r39;
        goto L78
    L73:
        r114 = r38;
        goto L74
    L69:
        r113 = r37;
        goto L70
    L65:
        r112 = r36;
        goto L66
    L61:
        r111 = r35;
        goto L62
    L57:
        r110 = r34;
        goto L58
    L53:
        r19 = r33;
        goto L54
    L49:
        r16 = r32;
        goto L50
    L45:
        r15 = r31;
        goto L46
    L41:
        r14 = r30;
        goto L43
    L37:
        r13 = r29;
        goto L39
    L33:
        r12 = r28;
        goto L35
    L29:
        r11 = r27;
        goto L31
    L25:
        r10 = r26;
        goto L27
    L21:
        r9 = r25;
        goto L23
    L17:
        r8 = r24;
        goto L19
    L13:
        r6 = r22;
        goto L15
    L9:
        r4 = r20;
        goto L11
    L5:
        r2 = r18;
        goto L7
    }

    public final long component1() {
        return this.id;
    }

    public final String component10() {
        return this.appNames;
    }

    public final Integer component11() {
        return this.category;
    }

    public final Integer component12() {
        return this.profileType;
    }

    public final String component13() {
        return this.profileTag;
    }

    public final String component14() {
        return this.tagOther;
    }

    public final String component15() {
        return this.logId;
    }

    public final Boolean component16() {
        return this.usedForPortrait;
    }

    public final Boolean component17() {
        return this.useLocation;
    }

    public final boolean component18() {
        return this.useForUserKeyword;
    }

    public final long component19() {
        return this.startTimestamp;
    }

    public final long component2() {
        return this.actionTimestamp;
    }

    public final long component20() {
        return this.endTimestamp;
    }

    public final Boolean component21() {
        return this.useForTopic;
    }

    public final String component22() {
        return this.entityId;
    }

    public final long component23() {
        return this.createTime;
    }

    public final long component24() {
        return this.modifyTime;
    }

    public final int component25() {
        return this.type;
    }

    public final long component26() {
        return this.timestamp;
    }

    public final String component27() {
        return this.packageName;
    }

    public final int component28() {
        return this.hashCodeValue;
    }

    public final String component29() {
        return this.uuid;
    }

    public final long component3() {
        return this.uid;
    }

    public final Boolean component30() {
        return this.userEdit;
    }

    public final int component31() {
        return this.productType;
    }

    public final String component32() {
        return this.importantRawRefIds;
    }

    public final String component33() {
        return this.sourceRawRefIds;
    }

    public final String component34() {
        return this.sceneIds;
    }

    public final String component35() {
        return this.sourcePackageName;
    }

    public final boolean component36() {
        return this.personalDbSplitMigrated;
    }

    public final String component4() {
        return this.title;
    }

    public final String component5() {
        return this.content;
    }

    public final String component6() {
        return this.contentWithTime;
    }

    public final String component7() {
        return this.fullContent;
    }

    public final String component8() {
        return this.observation;
    }

    public final String component9() {
        return this.location;
    }

    @Override // com.obric.memorydata.database.entity.d
    public AppEntity convertToAppEntityInternal() {
        return null;
    }

    @Override // com.obric.memorydata.database.entity.d
    public com.obric.memorydata.database.entity.i convertToImageVectorCopilotEntity(String r1) {
        Intrinsics.checkNotNullParameter(r1, "column");
        return null;
    }

    @Override // com.obric.memorydata.database.entity.d
    public com.obric.memorydata.database.entity.i convertToTextVectorCopilotEntity(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "column");
        Intrinsics.checkNotNullParameter(r2, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        return null;
    }

    public final EpisodicMemoryEntityOld copy(long r47, long r49, long r51, String r53, String r54, String r55, String r56, String r57, String r58, String r59, Integer r60, Integer r61, String r62, String r63, String r64, Boolean r65, Boolean r66, boolean r67, long r68, long r70, Boolean r72, String r73, long r74, long r76, int r78, long r79, String r81, int r82, String r83, Boolean r84, int r85, String r86, String r87, String r88, String r89, boolean r90) {
        Intrinsics.checkNotNullParameter(r53, "title");
        Intrinsics.checkNotNullParameter(r54, Params.CONTENT);
        Intrinsics.checkNotNullParameter(r57, "observation");
        Intrinsics.checkNotNullParameter(r58, "location");
        Intrinsics.checkNotNullParameter(r59, "appNames");
        Intrinsics.checkNotNullParameter(r73, "entityId");
        Intrinsics.checkNotNullParameter(r81, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r86, "importantRawRefIds");
        Intrinsics.checkNotNullParameter(r87, "sourceRawRefIds");
        Intrinsics.checkNotNullParameter(r88, "sceneIds");
        Intrinsics.checkNotNullParameter(r89, "sourcePackageName");
        return new EpisodicMemoryEntityOld(r47, r49, r51, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62, r63, r64, r65, r66, r67, r68, r70, r72, r73, r74, r76, r78, r79, r81, r82, r83, r84, r85, r86, r87, r88, r89, r90);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, EpisodicMemoryEntityOld.class) == true) goto L8;
        return false;
    L8:
        EpisodicMemoryEntityOld r10 = (EpisodicMemoryEntityOld) ZeusTransformUtils.preCheckCast(r9, EpisodicMemoryEntityOld.class, "com.obric.memorydata.plugin");
        if (this.id == r10.id) goto L12;
        return false;
    L12:
        if (this.actionTimestamp == r10.actionTimestamp) goto L15;
        return false;
    L15:
        if (this.uid == r10.uid) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.title, r10.title) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.content, r10.content) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.contentWithTime, r10.contentWithTime) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.fullContent, r10.fullContent) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.observation, r10.observation) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.location, r10.location) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.appNames, r10.appNames) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.category, r10.category) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.profileType, r10.profileType) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.profileTag, r10.profileTag) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.tagOther, r10.tagOther) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.logId, r10.logId) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.usedForPortrait, r10.usedForPortrait) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.useLocation, r10.useLocation) == true) goto L60;
        return false;
    L60:
        if (this.useForUserKeyword == r10.useForUserKeyword) goto L63;
        return false;
    L63:
        if (this.startTimestamp == r10.startTimestamp) goto L66;
        return false;
    L66:
        if (this.endTimestamp == r10.endTimestamp) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.useForTopic, r10.useForTopic) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.entityId, r10.entityId) == true) goto L75;
        return false;
    L75:
        if (this.createTime == r10.createTime) goto L78;
        return false;
    L78:
        if (this.modifyTime == r10.modifyTime) goto L81;
        return false;
    L81:
        if (this.type == r10.type) goto L84;
        return false;
    L84:
        if (this.timestamp == r10.timestamp) goto L87;
        return false;
    L87:
        if (Intrinsics.areEqual(this.packageName, r10.packageName) == true) goto L90;
        return false;
    L90:
        if (this.hashCodeValue == r10.hashCodeValue) goto L93;
        return false;
    L93:
        if (Intrinsics.areEqual(this.uuid, r10.uuid) == true) goto L96;
        return false;
    L96:
        if (Intrinsics.areEqual(this.userEdit, r10.userEdit) == true) goto L99;
        return false;
    L99:
        if (this.productType == r10.productType) goto L102;
        return false;
    L102:
        if (Intrinsics.areEqual(this.importantRawRefIds, r10.importantRawRefIds) == true) goto L105;
        return false;
    L105:
        if (Intrinsics.areEqual(this.sourceRawRefIds, r10.sourceRawRefIds) == true) goto L108;
        return false;
    L108:
        if (Intrinsics.areEqual(this.sceneIds, r10.sceneIds) == true) goto L111;
        return false;
    L111:
        if (Intrinsics.areEqual(this.sourcePackageName, r10.sourcePackageName) == true) goto L114;
        return false;
    L114:
        if (this.personalDbSplitMigrated == r10.personalDbSplitMigrated) goto L116;
        return false;
    L116:
        return true;
    }

    public final long getActionTimestamp() {
        return this.actionTimestamp;
    }

    public final String getAppNames() {
        return this.appNames;
    }

    public final Integer getCategory() {
        return this.category;
    }

    public final String getContent() {
        return this.content;
    }

    public final String getContentWithTime() {
        return this.contentWithTime;
    }

    @Override // com.obric.memorydata.database.entity.d
    public long getCreateTime() {
        return this.createTime;
    }

    public final long getEndTimestamp() {
        return this.endTimestamp;
    }

    @Override // com.obric.memorydata.database.entity.d
    public String getEntityId() {
        return this.entityId;
    }

    public final String getFullContent() {
        return this.fullContent;
    }

    @Override // com.obric.memorydata.database.entity.d
    public int getHashCodeValue() {
        return this.hashCodeValue;
    }

    @Override // com.obric.memorydata.database.entity.d
    public long getId() {
        return this.id;
    }

    public final String getImportantRawRefIds() {
        return this.importantRawRefIds;
    }

    public final String getLocation() {
        return this.location;
    }

    public final String getLogId() {
        return this.logId;
    }

    @Override // com.obric.memorydata.database.entity.d
    public long getModifyTime() {
        return this.modifyTime;
    }

    public final String getObservation() {
        return this.observation;
    }

    @Override // com.obric.memorydata.database.entity.d
    public String getPackageName() {
        return this.packageName;
    }

    public final boolean getPersonalDbSplitMigrated() {
        return this.personalDbSplitMigrated;
    }

    public final int getProductType() {
        return this.productType;
    }

    public final String getProfileTag() {
        return this.profileTag;
    }

    public final Integer getProfileType() {
        return this.profileType;
    }

    public final String getSceneIds() {
        return this.sceneIds;
    }

    public final String getSourcePackageName() {
        return this.sourcePackageName;
    }

    public final String getSourceRawRefIds() {
        return this.sourceRawRefIds;
    }

    public final long getStartTimestamp() {
        return this.startTimestamp;
    }

    public final String getTagOther() {
        return this.tagOther;
    }

    @Override // com.obric.memorydata.database.entity.d
    public long getTimestamp() {
        return this.timestamp;
    }

    public final String getTitle() {
        return this.title;
    }

    @Override // com.obric.memorydata.database.entity.d
    public int getType() {
        return this.type;
    }

    public final long getUid() {
        return this.uid;
    }

    public final Boolean getUseForTopic() {
        return this.useForTopic;
    }

    public final boolean getUseForUserKeyword() {
        return this.useForUserKeyword;
    }

    public final Boolean getUseLocation() {
        return this.useLocation;
    }

    public final Boolean getUsedForPortrait() {
        return this.usedForPortrait;
    }

    public final Boolean getUserEdit() {
        return this.userEdit;
    }

    @Override // com.obric.memorydata.database.entity.d
    public String getUuid() {
        return this.uuid;
    }

    public int hashCode() {
        int r0 = ((((((((Long.hashCode(this.id) * 31) + Long.hashCode(this.actionTimestamp)) * 31) + Long.hashCode(this.uid)) * 31) + this.title.hashCode()) * 31) + this.content.hashCode()) * 31;
        String r1 = this.contentWithTime;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.fullContent;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (((((((r4 + r6) * 31) + this.observation.hashCode()) * 31) + this.location.hashCode()) * 31) + this.appNames.hashCode()) * 31;
        Integer r8 = this.category;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        Integer r11 = this.profileType;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        String r14 = this.profileTag;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (r13 + r15) * 31;
        String r17 = this.tagOther;
        if (r17 != null) goto L25;
        int r18 = 0;
    L26:
        int r19 = (r16 + r18) * 31;
        String r20 = this.logId;
        if (r20 != null) goto L29;
        int r21 = 0;
    L30:
        int r22 = (r19 + r21) * 31;
        Boolean r23 = this.usedForPortrait;
        if (r23 != null) goto L33;
        int r24 = 0;
    L34:
        int r25 = (r22 + r24) * 31;
        Boolean r26 = this.useLocation;
        if (r26 != null) goto L37;
        int r27 = 0;
    L38:
        int r28 = (((((((r25 + r27) * 31) + Boolean.hashCode(this.useForUserKeyword)) * 31) + Long.hashCode(this.startTimestamp)) * 31) + Long.hashCode(this.endTimestamp)) * 31;
        Boolean r29 = this.useForTopic;
        if (r29 != null) goto L41;
        int r30 = 0;
    L42:
        int r31 = (((((((((((((((r28 + r30) * 31) + this.entityId.hashCode()) * 31) + Long.hashCode(this.createTime)) * 31) + Long.hashCode(this.modifyTime)) * 31) + Integer.hashCode(this.type)) * 31) + Long.hashCode(this.timestamp)) * 31) + this.packageName.hashCode()) * 31) + Integer.hashCode(this.hashCodeValue)) * 31;
        String r32 = this.uuid;
        if (r32 != null) goto L45;
        int r33 = 0;
    L46:
        int r34 = (r31 + r33) * 31;
        Boolean r35 = this.userEdit;
        if (r35 == null) goto L51;
        r2 = r35.hashCode();
    L51:
        return ((((((((((((r34 + r2) * 31) + Integer.hashCode(this.productType)) * 31) + this.importantRawRefIds.hashCode()) * 31) + this.sourceRawRefIds.hashCode()) * 31) + this.sceneIds.hashCode()) * 31) + this.sourcePackageName.hashCode()) * 31) + Boolean.hashCode(this.personalDbSplitMigrated);
    L45:
        r33 = r32.hashCode();
        goto L46
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

    public final void setContentWithTime(String r1) {
        this.contentWithTime = r1;
    }

    @Override // com.obric.memorydata.database.entity.d
    public void setId(long r1) {
        this.id = r1;
    }

    public final void setProductType(int r1) {
        this.productType = r1;
    }

    @Override // com.obric.memorydata.database.entity.d
    public void setTimestamp(long r1) {
        this.timestamp = r1;
    }

    public final void setUserEdit(Boolean r1) {
        this.userEdit = r1;
    }

    @Override // com.obric.memorydata.database.entity.d
    public void setUuid(String r1) {
        this.uuid = r1;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("EpisodicMemoryEntityOld(id=").append(this.id).append(", actionTimestamp=").append(this.actionTimestamp).append(", uid=").append(this.uid).append(", title=").append(this.title).append(", content=").append(this.content).append(", contentWithTime=").append(this.contentWithTime).append(", fullContent=").append(this.fullContent).append(", observation=").append(this.observation).append(", location=").append(this.location).append(", appNames=").append(this.appNames).append(", category=").append(this.category).append(", profileType=");
        r0.append(this.profileType).append(", profileTag=").append(this.profileTag).append(", tagOther=").append(this.tagOther).append(", logId=").append(this.logId).append(", usedForPortrait=").append(this.usedForPortrait).append(", useLocation=").append(this.useLocation).append(", useForUserKeyword=").append(this.useForUserKeyword).append(", startTimestamp=").append(this.startTimestamp).append(", endTimestamp=").append(this.endTimestamp).append(", useForTopic=").append(this.useForTopic).append(", entityId=").append(this.entityId).append(", createTime=").append(this.createTime);
        r0.append(", modifyTime=").append(this.modifyTime).append(", type=").append(this.type).append(", timestamp=").append(this.timestamp).append(", packageName=").append(this.packageName).append(", hashCodeValue=").append(this.hashCodeValue).append(", uuid=").append(this.uuid).append(", userEdit=").append(this.userEdit).append(", productType=").append(this.productType).append(", importantRawRefIds=").append(this.importantRawRefIds).append(", sourceRawRefIds=").append(this.sourceRawRefIds).append(", sceneIds=").append(this.sceneIds).append(", sourcePackageName=");
        r0.append(this.sourcePackageName).append(", personalDbSplitMigrated=").append(this.personalDbSplitMigrated).append(')');
        return r0.toString();
    }
}
