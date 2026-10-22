package com.obric.memorydata.database.index;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.Ensure;
import com.bytedance.crash.entity.EventBody;
import com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype;
import com.google.gson.JsonParseException;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.cae.userAware.WifiScanStateMachine;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.capabilitykit.entity.app.VideoFrame;
import com.obric.memorydata.annotation.ChunkType;
import com.obric.memorydata.database.dao.AbstractVideoFrameRawDbDao;
import com.obric.memorydata.database.dao.IAppEntityContentTimeDao;
import com.obric.memorydata.database.dao.IAppEntityRawDbDao;
import com.obric.memorydata.database.dao.IAppEntityVectorCopilotDao;
import com.obric.memorydata.database.entity.ChatMessage;
import com.obric.memorydata.database.entity.RawMemoryEntity;
import com.obric.memorydata.database.entity.b;
import com.obric.memorydata.database.entity.cd;
import com.obric.memorydata.database.entity.d;
import com.obric.memorydata.database.entity.fv;
import com.obric.memorydata.database.entity.gi;
import com.obric.memorydata.database.entity.gq;
import com.obric.memorydata.database.entity.hb;
import com.obric.memorydata.database.entity.hr;
import com.obric.memorydata.database.entity.i;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.database.model.CommonTextSearchDocument;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.bdtracker.Tracker;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.obric.memorydata.personalcontext.api.EntityManager;
import com.obric.memorydata.personalcontext.api.EntityVideoExtractHelper;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.obric.memorydata.personalcontext.api.PersonalContextAPI;
import com.obric.memorydata.personalcontext.util.EmbeddingState;
import com.obric.memorydata.task.condition.Condition;
import com.obric.memorydata.task.impl.TaskRequest;
import com.obric.memorydata.task.impl.TaskResult;
import com.obric.memorydata.utils.GsonUtil;
import com.obric.search.api.schema.impl.FullTextSearchSchema;
import com.ttnet.org.chromium.net.NetError;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.ehcache.impl.internal.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0014\n\u0002\b\r\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u008a\u0001*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u0004*\b\b\u0002\u0010\u0005*\u00020\u00062\u00020\u0007:\u0002\u008a\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJT\u0010!\u001a\u00020\"2\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\u00102\u0010\b\u0002\u0010$\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000b2\u0010\b\u0002\u0010%\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000b2\u0010\b\u0002\u0010&\u001a\n\u0012\u0004\u0012\u00028\u0002\u0018\u00010\u000e2\b\b\u0002\u0010'\u001a\u00020\u0018J\"\u0010(\u001a\u00020\u00182\u0006\u0010)\u001a\u00020*2\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001e0,J\"\u0010-\u001a\u00020\u00182\u0006\u0010)\u001a\u00020*2\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001e0,J\u001e\u0010.\u001a\u00020\u00182\u0006\u0010/\u001a\u00020\u00022\u0006\u00100\u001a\u00020\u001e2\u0006\u00101\u001a\u00020\u001eJ*\u00102\u001a\u0004\u0018\u00010\u001e2\u0006\u0010/\u001a\u00020\u00022\u0006\u00103\u001a\u00020\u001e2\u0006\u00100\u001a\u00020\u001e2\b\u00104\u001a\u0004\u0018\u00010\u001eJ*\u00105\u001a\u00020\u00182\u0006\u0010/\u001a\u00020\u00022\u0006\u00100\u001a\u00020\u001e2\u0006\u00101\u001a\u00020\u001e2\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u001eJ4\u00107\u001a\u00020\u00182\u0006\u0010/\u001a\u00020\u00022\u0006\u00100\u001a\u00020\u001e2\u0006\u00108\u001a\u0002092\b\b\u0002\u0010:\u001a\u00020\u00182\b\b\u0002\u0010;\u001a\u00020\u0018H\u0002J \u0010<\u001a\u00020\u00182\u0006\u0010/\u001a\u00020\u00022\u0006\u00100\u001a\u00020\u001e2\u0006\u0010=\u001a\u000209H\u0002J&\u0010>\u001a\u00020\u00182\u0006\u0010/\u001a\u00020\u00022\u0006\u00100\u001a\u00020\u001e2\u0006\u0010?\u001a\u00020*2\u0006\u0010@\u001a\u00020*J,\u0010A\u001a\b\u0012\u0004\u0012\u00020C0B2\u0006\u0010/\u001a\u00020\u00022\u0006\u0010D\u001a\u00020\u001e2\u0006\u0010E\u001a\u00020\u001e2\u0006\u0010F\u001a\u00020\u0018J,\u0010G\u001a\b\u0012\u0004\u0012\u00020C0B2\u0006\u0010/\u001a\u00020\u00022\u0006\u0010D\u001a\u00020\u001e2\u0006\u0010E\u001a\u00020\u001e2\u0006\u0010F\u001a\u00020\u0018J$\u0010H\u001a\b\u0012\u0004\u0012\u00020C0B2\u0006\u0010/\u001a\u00020\u00022\u0006\u0010D\u001a\u00020\u001e2\u0006\u0010I\u001a\u00020\u001eJ,\u0010J\u001a\u00020\u00182\u0006\u0010/\u001a\u00020\u00022\u0006\u00100\u001a\u00020\u001e2\b\u00101\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u001eJ,\u0010K\u001a\u00020\u00182\u0006\u0010/\u001a\u00020\u00022\u0006\u00100\u001a\u00020\u001e2\b\u00101\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u001eJ&\u0010L\u001a\u00020\u00182\u0006\u0010/\u001a\u00020\u00022\u0006\u00100\u001a\u00020\u001e2\u0006\u0010M\u001a\u00020\u001e2\u0006\u0010F\u001a\u00020\u0018J>\u0010N\u001a\u00020\u00182\u0006\u0010/\u001a\u00020\u00022\u0006\u00100\u001a\u00020\u001e2\b\u0010M\u001a\u0004\u0018\u00010\u001e2\b\b\u0002\u0010O\u001a\u00020\u001e2\u0012\u0010P\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\"0QJ\u001e\u0010R\u001a\u00020\"2\u0006\u0010/\u001a\u00020\u00022\u0006\u00100\u001a\u00020\u001e2\u0006\u0010?\u001a\u00020*JH\u0010S\u001a\u00020\u00182\u0006\u0010/\u001a\u00020\u00022\u0006\u00100\u001a\u00020\u001e2\u0006\u0010T\u001a\u0002092\b\b\u0002\u0010O\u001a\u00020\u001e2\b\b\u0002\u0010U\u001a\u00020\u00182\u0012\u0010P\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\"0QH\u0002J>\u0010V\u001a\u00020\u00182\u0006\u0010/\u001a\u00020\u00022\u0006\u00100\u001a\u00020\u001e2\b\u0010M\u001a\u0004\u0018\u00010\u001e2\b\b\u0002\u0010O\u001a\u00020\u001e2\u0012\u0010W\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\"0QJ\u0016\u0010X\u001a\u00020\u00182\u0006\u0010I\u001a\u00020\u001e2\u0006\u0010/\u001a\u00020\u0002J\u0018\u0010Y\u001a\u00020\u001e2\b\u0010Z\u001a\u0004\u0018\u00010\u001e2\u0006\u0010[\u001a\u00020\u001eJH\u0010\\\u001a\u00020\u00182\u0006\u0010/\u001a\u00020\u00022\u0006\u00100\u001a\u00020\u001e2\u0006\u0010T\u001a\u0002092\b\b\u0002\u0010O\u001a\u00020\u001e2\b\b\u0002\u0010U\u001a\u00020\u00182\u0012\u0010W\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\"0QH\u0002J,\u0010]\u001a\u00020\u00182\u0006\u0010/\u001a\u00020^2\u0006\u00100\u001a\u00020\u001e2\u0012\u0010P\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\"0QH\u0002J,\u0010_\u001a\u00020\u00182\u0006\u0010/\u001a\u00020^2\u0006\u00100\u001a\u00020\u001e2\u0012\u0010W\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\"0QH\u0002J$\u0010`\u001a\u00020\"2\u0006\u0010a\u001a\u00020\u001e2\u0012\u0010b\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\"0QH\u0002J*\u0010c\u001a\u00020\u00182\u0006\u0010/\u001a\u00020\u00022\u0006\u00100\u001a\u00020\u001e2\u0006\u00101\u001a\u00020\u001e2\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u001eJ,\u0010d\u001a\u00020\u00182\u0006\u0010/\u001a\u00020\u00022\u0006\u00100\u001a\u00020\u001e2\u0006\u0010e\u001a\u00020\u001e2\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u001eH\u0002J2\u0010f\u001a\u00020\u00182\u0006\u0010/\u001a\u00020\u00022\u0006\u00100\u001a\u00020\u001e2\u0006\u0010e\u001a\u00020\u001e2\u0006\u0010g\u001a\u00020\u001e2\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u001eJ&\u0010h\u001a\u00020\u00182\u0006\u0010/\u001a\u00020\u00022\u0006\u00100\u001a\u00020\u001e2\u0006\u0010e\u001a\u00020\u001e2\u0006\u0010F\u001a\u00020\u0018J\"\u0010i\u001a\u00020\u00182\u0006\u0010/\u001a\u00020j2\u0012\u0010k\u001a\u000e\u0012\u0004\u0012\u00020l\u0012\u0004\u0012\u00020\u00180QJ2\u0010m\u001a\u00020\u00182\u0006\u0010/\u001a\u00020\u00022\b\u0010M\u001a\u0004\u0018\u00010\u001e2\u0018\u0010n\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0B\u0012\u0004\u0012\u00020\"0QJ*\u0010o\u001a\u00020\u00182\u0006\u0010/\u001a\u00020^2\u0018\u0010n\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0B\u0012\u0004\u0012\u00020\"0QH\u0002J\"\u0010p\u001a\u0004\u0018\u00010q2\u0006\u0010r\u001a\u00020\u001e2\u0006\u0010s\u001a\u0002092\u0006\u0010t\u001a\u00020\u0018H\u0002J\"\u0010u\u001a\u0004\u0018\u00010q2\u0006\u0010r\u001a\u00020\u001e2\u0006\u0010s\u001a\u0002092\u0006\u0010t\u001a\u00020\u0018H\u0002J\u001a\u0010v\u001a\u0004\u0018\u00010\u001e2\u0006\u0010r\u001a\u00020\u001e2\u0006\u0010s\u001a\u000209H\u0002J<\u0010w\u001a\u00020\u00182\u0006\u0010/\u001a\u00020\u00022\u0006\u0010T\u001a\u0002092\b\b\u0002\u0010U\u001a\u00020\u00182\u0018\u0010n\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0B\u0012\u0004\u0012\u00020\"0QH\u0002J \u0010x\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010B2\u0006\u0010r\u001a\u00020\u001e2\u0006\u0010s\u001a\u000209H\u0002J\u0018\u0010y\u001a\u00020\u001e2\u0006\u0010r\u001a\u00020\u001e2\u0006\u0010s\u001a\u000209H\u0002J\u0010\u0010z\u001a\u00020\u001e2\u0006\u0010{\u001a\u000209H\u0002J4\u0010|\u001a\u0004\u0018\u00010\u001e2\b\u0010{\u001a\u0004\u0018\u0001092\b\u0010}\u001a\u0004\u0018\u00010\u001e2\u000e\u0010~\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u007fH\u0002¢\u0006\u0003\u0010\u0080\u0001J\u0019\u0010\u0081\u0001\u001a\u00020\u001e2\b\u00103\u001a\u0004\u0018\u00010\u001e2\u0006\u0010a\u001a\u00020\u001eJK\u0010\u0082\u0001\u001a\u00020\u00182\u0007\u0010/\u001a\u00030\u0083\u00012\u0006\u0010E\u001a\u00020\u001e2\u0007\u0010\u0084\u0001\u001a\u00020\u00182\b\u0010\u0085\u0001\u001a\u00030\u0086\u00012\u0007\u0010\u0087\u0001\u001a\u00020\u001e2\u000f\b\u0002\u0010\u0088\u0001\u001a\b\u0012\u0004\u0012\u00020\u001e0\u007f¢\u0006\u0003\u0010\u0089\u0001R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00028\u0002\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u001eX\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u00020\u001eX\u0082D¢\u0006\u0004\n\u0002\b ¨\u0006\u008b\u0001"}, d2 = {"Lcom/obric/memorydata/database/index/EntityIndexHelper;", ExifInterface.LONGITUDE_WEST, "Lcom/obric/memorydata/database/entity/AbstractRawDbEntity;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/obric/memorydata/database/entity/AbstractVectorCopilotEntity;", "C", "Lcom/obric/memorydata/database/entity/AbstractContentTimeEntity;", "", "<init>", "()V", "entityTextVectorCopilotDao", "Lcom/obric/memorydata/database/dao/IAppEntityVectorCopilotDao;", "entityImageVectorCopilotDao", "entityContentTimeDao", "Lcom/obric/memorydata/database/dao/IAppEntityContentTimeDao;", "entityRawDao", "Lcom/obric/memorydata/database/dao/IAppEntityRawDbDao;", "schema", "Lcom/obric/search/api/schema/impl/FullTextSearchSchema;", "getSchema", "()Lcom/obric/search/api/schema/impl/FullTextSearchSchema;", "setSchema", "(Lcom/obric/search/api/schema/impl/FullTextSearchSchema;)V", "hasKeywordSchema", "", "getHasKeywordSchema", "()Z", "setHasKeywordSchema", "(Z)V", "FULL_CONTENT_BUILD_TASK", "", "PARSE_ICS_PROTOCOL_TASK", "PARSE_ICS_PROTOCOL_TASK$1", CommonConsts.APM_INNER_EVENT_COST_INIT, "", "rawDao", "textVectorCopilotDao", "imageVectorCopilotDao", "contentTimeDao", "hasKeywordIndex", "deleteKeywordIndex", "rawEntityId", "", "values", "", "insertKeywordIndex", "buildFileIndex", "entity", "column", EventBody.KEY_VALUE, "insertContentTimeIndex", Params.CONTENT, WsConstants.KEY_EXTRA, "embeddingText", "chunkType", "embeddingPicture", "imageUri", "Landroid/net/Uri;", "isReportTracker", "useCLIP4ClipModel", "embeddingVideo", "video", "embeddingVideoFrame", "photoEntityDbId", "frameTimeStamp", "generateFilePendingTask", "", "Lcom/obric/memorydata/database/entity/IndexPendingEntity;", "columnName", "fileString", "isIgnoreVideoFileEntity", "generateFilePendingTaskFromArray", "generateTextPendingTask", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "embeddingFullContent", "embeddingFullContentWithoutSensitiveLog", "embeddingFileEntity", "fileEntityJson", "embeddingOcr", "keywordColumn", "fillOcr", "Lkotlin/Function1;", "generateCLIP4ClipFusionVector", "embeddingPhotoOcr", "imgUri", "isFromVideo", "embeddingCaption", "fillCaption", "isLongTextEmbedding", "getFieldValue", "json", "key", "embeddingPhotoCaption", "embeddingVideoFrameOcr", "Lcom/obric/memorydata/database/entity/AbstractVideoFrameEntity;", "embeddingVideoFrameCaption", "groupContentToFillKeywordIndex", "newValue", "fillFunc", "embeddingTextOrTextArray", "embeddingTextFromArrayNoNeedField", "arrayContent", "embeddingTextFromArray", "field", "embeddingFileEntityFromArray", "buildPhotoLocation", "Lcom/obric/memorydata/database/entity/RawPhotoEntity;", "fillLocation", "Lcom/obric/memorydata/database/entity/RawMetaLocationEntity;", "buildPhotoTag", "fillTags", "buildVideoFrameTag", "pictureToVector", "", ObricMemoryConstants.KEY_PACKAGE_NAME, "image", "useVlm", "pictureToVectorByCLIP4Clip", "pictureToCaption", "buildPhotoTagInner", "pictureToTags", "pictureToOCR", "getFileAbsolutePath", "uri", "getDataColumn", "selection", "selectionArgs", "", "(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;", "addNewValueToContent", "processFileIndex", "Lcom/obric/memorydata/database/entity/AbstractRawFileDbEntity;", "isFileEntityJson", "fileTextEntityType", "", "fileExtension", "ignoreExtensionList", "(Lcom/obric/memorydata/database/entity/AbstractRawFileDbEntity;Ljava/lang/String;ZILjava/lang/String;[Ljava/lang/String;)Z", "Companion", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class t<W extends com.obric.memorydata.database.entity.d, T extends com.obric.memorydata.database.entity.i, C extends com.obric.memorydata.database.entity.b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f9438a = null;
    private static long j;
    private static final ConcurrentHashMap<Integer, Long> k = null;
    private static final AtomicBoolean l = null;
    private static final List<String> m = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private IAppEntityVectorCopilotDao<T> f9439b;
    private IAppEntityVectorCopilotDao<T> c;
    private IAppEntityContentTimeDao<C> d;
    private IAppEntityRawDbDao<W> e;
    private FullTextSearchSchema f;
    private boolean g;
    private final String h;
    private final String i;

    @Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u000e\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010$\u001a\u00020%J\u0006\u0010&\u001a\u00020%J\u0006\u0010'\u001a\u00020(J\u000e\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020%J\u0006\u0010+\u001a\u00020(J\u0006\u0010,\u001a\u00020%J\u0012\u0010-\u001a\u0004\u0018\u00010\u00052\u0006\u0010.\u001a\u00020\u000eH\u0002J\u0006\u0010/\u001a\u00020(J\"\u00100\u001a\u00020%2\b\u00101\u001a\u0004\u0018\u0001022\b\u00103\u001a\u0004\u0018\u0001022\u0006\u00104\u001a\u00020%J\u0018\u00105\u001a\u00020%2\u0006\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u00010\u0005J\b\u00109\u001a\u00020:H\u0002J \u0010;\u001a\u0004\u0018\u00010<2\u0006\u0010=\u001a\u00020\u00052\u0006\u0010>\u001a\u00020%2\u0006\u0010?\u001a\u00020%J0\u0010;\u001a\u0004\u0018\u00010<2\u0006\u0010.\u001a\u00020\u000e2\u0006\u0010@\u001a\u00020\u001b2\u0006\u0010=\u001a\u00020\u00052\u0006\u0010>\u001a\u00020%2\u0006\u0010?\u001a\u00020%J\"\u0010A\u001a\u0004\u0018\u00010<2\u0006\u0010=\u001a\u00020\u00052\u0006\u0010>\u001a\u00020%2\u0006\u0010?\u001a\u00020%H\u0002J&\u0010B\u001a\u00020%2\u0006\u0010C\u001a\u00020\u00052\u0006\u0010D\u001a\u00020\u001b2\u0006\u0010E\u001a\u00020<2\u0006\u0010?\u001a\u00020%J*\u0010F\u001a\u00020%2\u0006\u0010G\u001a\u00020\u00052\u0006\u0010H\u001a\u00020\u00052\u0012\u0010I\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020(0JJ*\u0010K\u001a\u00020%2\u0006\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020\u001b2\u0012\u0010O\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050PJ\u001c\u0010Q\u001a\u00020%2\u0006\u0010L\u001a\u00020M2\f\u0010R\u001a\b\u0012\u0004\u0012\u00020\u001b0SJ&\u0010T\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050P2\u0012\u0010O\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050PJ\u0010\u0010U\u001a\u00020\u00052\b\u0010V\u001a\u0004\u0018\u00010\u0005J\b\u0010W\u001a\u00020(H\u0002J\b\u0010X\u001a\u00020(H\u0002J\u0010\u0010Y\u001a\u00020\u000e2\u0006\u0010.\u001a\u00020\u000eH\u0002J\u000e\u0010Z\u001a\u00020%2\u0006\u00106\u001a\u000202J\u000e\u0010[\u001a\u00020%2\u0006\u00106\u001a\u000202J*\u0010\\\u001a\b\u0012\u0004\u0012\u00020\u00050S2\u0006\u0010]\u001a\u00020\u00052\b\b\u0002\u0010^\u001a\u00020\u000e2\n\b\u0002\u0010_\u001a\u0004\u0018\u00010\u0005J \u0010`\u001a\b\u0012\u0004\u0012\u00020\u00050S2\u0006\u0010]\u001a\u00020\u00052\b\b\u0002\u0010^\u001a\u00020\u000eH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u001b0\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00050!¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#¨\u0006a"}, d2 = {"Lcom/obric/memorydata/database/index/EntityIndexHelper$Companion;", "", "<init>", "()V", "TAG", "", "INSERT_KEYWORD_TASK", "INSERT_CONTENT_TIME_TASK", "PARSE_ICS_PROTOCOL_TASK", "META_FULL_CONTENT_TASK", "LAZY_INDEX_TASK", "VLM_EMBEDDING_UPDATE_TEXT_TASK", "VLM_EMBEDDING_UPDATE_IMAGE_TASK", "LONG_TEXT_EMBEDDING_LENGTH", "", "LONG_TEXT_EMBEDDING_MEMORY_LENGTH", "KEY_INVALIDATE_ENTITY_INDEX", "KEY_INVALIDATE_ENTITY_TYPE_TOTAL_COUNT_SUFFIX", "KEY_INVALIDATE_ENTITY_TYPE_INVALID_RATE_SUFFIX", "KEY_EXISTING_DATA_EMBEDDING_VECTOR_UPDATE_PREFIX", "KEY_CHECK_EXISTING_DATA_EMBEDDING_VECTOR_UPDATE_TASK", "KEY_EXISTING_DATA_EMBEDDING_VECTOR_UPDATE_DONE", "KEY_REPORT_EXISTING_DATA_EMBEDDING_VECTOR_COUNT_TIME", "EVENT_EXISTING_DATA_EMBEDDING_VECTOR_UPDATE_COUNT", "META_FULL_CONTENT_BUILD_TASK", "FULL_CONTENT_BUILD_TYPE", "lastReportInvalidateIndexTimeStamp", "", "invalidateEntityIndexData", "Lorg/ehcache/impl/internal/concurrent/ConcurrentHashMap;", "isReportingInvalidateIndex", "Ljava/util/concurrent/atomic/AtomicBoolean;", "personalFullTextSearchSchemaList", "", "getPersonalFullTextSearchSchemaList", "()Ljava/util/List;", "isDisableRefreshVlmVectorUpdateState", "", "isExistingDataEmbeddingVectorUpdateTaskDone", "setExistingDataEmbeddingVectorUpdateTaskDone", "", "refreshExistingEmbeddingVectorUpdateTaskDone", "noNeedReport", "checkExistingEmbeddingVectorUpdateTaskOnStartUp", "isInstantEntityIndexSwitchOn", "existingDataMetaInfoFullContentDoneKey", "entityType", "insertExistingDataMetaInfoFullContentTask", "checkInvalidateIndex", "oldEntity", "Lcom/obric/memorydata/database/entity/AbstractRawDbEntity;", "newEntity", "reportEventIfInvalidate", "parseIcsProtocol", "entity", "Lcom/obric/memorydata/database/entity/RawICSProtocolEntity;", "icsProtocol", "indexModelTaskInfoCallback", "Lcom/obric/memorydata/task/scheduler/OnTaskInfoCallBack;", "textEmbeddingToVector", "", ChatMessage.TYPE_QUERY, "throwThermalStatusError", "useVlm", "rawDbId", "runTextEmbedding", "insertVectorData", "tableName", OaidModel.KEY_ID, "vectorArray", "extractFieldsValue", EventBody.KEY_VALUE, "fields", "fillField", "Lkotlin/Function1;", "deleteKeywordIndexWithSchema", "schema", "Lcom/obric/search/api/schema/impl/FullTextSearchSchema;", "rawEntityId", "values", "", "deleteKeywordIndexListWithSchema", "rawEntityIdList", "", "buildKeywordIndexColumn", "mimeTypeToDescription", "mimeType", "reportInvalidateIndexAsync", "reportInvalidateIndex", "getEntityTypeTotalCount", "buildMetaFullContent", "buildMetaFullContentWithoutSensitiveLog", "splitStringByChunkType", "input", XSDatatype.FACET_LENGTH, "chunkType", "splitStringByLength", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: com.obric.memorydata.database.index.t$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003H\u0016¨\u0006\t"}, d2 = {"com/obric/memorydata/database/index/EntityIndexHelper$Companion$checkExistingEmbeddingVectorUpdateTaskOnStartUp$1", "Lcom/obric/memorydata/database/entity/utils/ExistingDataPendingTaskBuilder;", "generatePendingTasks", "", "Lcom/obric/memorydata/database/entity/IndexPendingEntity;", "type", "", "existingData", "Lcom/obric/memorydata/database/SimpleEntityData;", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class C0458a implements com.obric.memorydata.database.entity.a.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ IAppEntityVectorCopilotDao<com.obric.memorydata.database.entity.i> f9440a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ int f9441b;
            final /* synthetic */ IAppEntityVectorCopilotDao<com.obric.memorydata.database.entity.i> c;

            C0458a(IAppEntityVectorCopilotDao<com.obric.memorydata.database.entity.i> r3, int r4, IAppEntityVectorCopilotDao<com.obric.memorydata.database.entity.i> r5) {
                IAppEntityVectorCopilotDao<com.obric.memorydata.database.entity.i> r6 = (IAppEntityVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r3, IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin");
                IAppEntityVectorCopilotDao<com.obric.memorydata.database.entity.i> r7 = (IAppEntityVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r5, IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin");
                this.f9440a = r6;
                this.f9441b = r4;
                this.c = r7;
            }

            @Override // com.obric.memorydata.database.entity.a.a
            public List<cd> a(int r34, List<com.obric.memorydata.database.b> r35) {
                List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r35, List.class, "com.obric.memorydata.plugin");
                Intrinsics.checkNotNullParameter(r1, "existingData");
                Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin");
                IAppEntityVectorCopilotDao<com.obric.memorydata.database.entity.i> r3 = this.f9440a;
                int r9 = this.f9441b;
                IAppEntityVectorCopilotDao<com.obric.memorydata.database.entity.i> r0 = this.c;
                Collection r15 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
                Iterator r4 = r2.iterator();
            L4:
                if (r4.hasNext() == false) goto L14;
                com.obric.memorydata.database.b r27 = (com.obric.memorydata.database.b) ZeusTransformUtils.preCheckCast(r4.next(), com.obric.memorydata.database.b.class, "com.obric.memorydata.plugin");
                List r14 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
                if (r3 == null) goto L8;
                cd r12 = new cd(0, r27.a(), r9, r27.b(), r27.c(), 0, 0, "vlm_embedding_update_text_task", "vlm_embedding_update_text_task", 0, 0, null, true, 0, 0, 28257, null);
                List r10 = r14;
                r10.add(r12);
            L9:
                if (r0 == null) goto L11;
                List r5 = r10;
                int r11 = r9;
                r5.add(new cd(0, r27.a(), r11, r27.b(), r27.c(), 0, 0, "vlm_embedding_update_image_task", "vlm_embedding_update_image_task", 0, 0, null, true, 0, 0, 28257, null));
            L12:
                Collection r6 = r15;
                CollectionsKt.addAll(r6, (Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin"));
                r15 = r6;
                r0 = r0;
                r9 = r9;
                goto L4
            L11:
                r5 = r10;
                goto L12
            L8:
                r10 = r14;
                goto L9
            L14:
                return (List) ZeusTransformUtils.preCheckCast(r15, List.class, "com.obric.memorydata.plugin");
            }
        }

        @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003H\u0016¨\u0006\t"}, d2 = {"com/obric/memorydata/database/index/EntityIndexHelper$Companion$insertExistingDataMetaInfoFullContentTask$1", "Lcom/obric/memorydata/database/entity/utils/ExistingDataPendingTaskBuilder;", "generatePendingTasks", "", "Lcom/obric/memorydata/database/entity/IndexPendingEntity;", "type", "", "existingData", "Lcom/obric/memorydata/database/SimpleEntityData;", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class b implements com.obric.memorydata.database.entity.a.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f9442a;

            b(int r1) {
                this.f9442a = r1;
            }

            @Override // com.obric.memorydata.database.entity.a.a
            public List<cd> a(int r29, List<com.obric.memorydata.database.b> r30) {
                List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r30, List.class, "com.obric.memorydata.plugin");
                Intrinsics.checkNotNullParameter(r0, "existingData");
                Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");
                int r7 = this.f9442a;
                Collection r15 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10)), Collection.class, "com.obric.memorydata.plugin");
                Iterator r2 = r1.iterator();
            L4:
                if (r2.hasNext() == false) goto L7;
                com.obric.memorydata.database.b r10 = (com.obric.memorydata.database.b) ZeusTransformUtils.preCheckCast(r2.next(), com.obric.memorydata.database.b.class, "com.obric.memorydata.plugin");
                Collection r27 = r15;
                r27.add(new cd(0, r10.a(), r7, r10.b(), r10.c(), 0, 0, "meta_full_content", "meta_full_content", 0, 0, null, true, 0, 0, 28257, null));
                r15 = r27;
                goto L4
            L7:
                return (List) ZeusTransformUtils.preCheckCast(r15, List.class, "com.obric.memorydata.plugin");
            }
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        private final String a(int r13) {
            String r12 = "existing_data_build_meta_info_full_content_" + r13;
            if (Intrinsics.areEqual(com.obric.memorydata.database.manager.c.f9561a.a(r13), "USER") == true) goto L5;
            return r12;
        L5:
            String r0 = AppContext.INSTANCE.getUserId();
            boolean r2 = false;
            if (AppContext.INSTANCE.isLogin() == true) goto L8;
        L12:
            boolean r1 = false;
        L14:
            if (r1 == true) goto L17;
            r0 = null;
        L17:
            CharSequence r3 = (CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin");
            if (r3 != null) goto L20;
        L21:
            r2 = true;
        L22:
            if (r2 == false) goto L26;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityIndexHelper", "insertExistingDataMetaInfoFullContentTask skip, user is not login, type: " + r13, false, 4, null);
            return null;
        L26:
            return r12 + '_' + r0;
        L20:
            if (r3.length() != 0) goto L22;
        L8:
            if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L12;
            if (Intrinsics.areEqual(r0, "0") == true) goto L12;
            r1 = true;
            goto L14
        }

        static /* synthetic */ List a(a r0, String r1, int r2, int r3, Object r4) {
            if ((r3 & 2) == 0) goto L6;
            r2 = 240;
        L6:
            return r0.a(r1, r2);
        }

        public static /* synthetic */ List a(a r0, String r1, int r2, String r3, int r4, Object r5) {
            if ((r4 & 2) == 0) goto L6;
            r2 = 240;
        L6:
            if ((r4 & 4) == 0) goto L9;
            r3 = null;
        L9:
            return r0.a(r1, r2, r3);
        }

        private final List<String> a(String r2, int r3) {
            return StringsKt.chunked((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin"), r3);
        }

        public static final /* synthetic */ void a(a r0) {
            r0.j();
        }

        private final int b(int r5) {
            IAppEntityRawDbDao<com.obric.memorydata.database.entity.d> r0 = s.a().getRawDaoByEntityType(r5);     // Catch: Exception -> L7
            if (r0 == null) goto L12;
            return r0.queryAllCount();
        L12:
            return -1;
        L7:
            e = move-exception;
            RunLog.INSTANCE.error("EntityIndexHelper", "getEntityTypeTotalCount error, entityType: " + r5, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
            return -1;
        }

        public static final /* synthetic */ com.obric.memorydata.task.scheduler.c b(a r0) {
            return r0.h();
        }

        private final float[] b(String r2, boolean r3, boolean r4) {
            return (float[]) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.i.a(null, (Function2) ZeusTransformUtils.preCheckCast(new EntityIndexHelper$Companion$runTextEmbedding$1(r2, r3, r4, null), Function2.class, "com.obric.memorydata.plugin"), 1, null), float[].class, "com.obric.memorydata.plugin");
        }

        private static final float[] c(String r1, boolean r2, boolean r3) {
            return t.f9438a.b(r1, r2, r3);
        }

        private static final float[] d(String r1, boolean r2, boolean r3) {
            return t.f9438a.b(r1, r2, r3);
        }

        private final com.obric.memorydata.task.scheduler.c h() {
            return ao.f9372a.a(ao.f9372a.a());
        }

        private final void i() {
            if (t.f().compareAndSet(false, true) == true) goto L5;
            return;
        L5:
            kotlinx.coroutines.i.a(kotlinx.coroutines.am.a((CoroutineContext) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin")), null, null, (Function2) ZeusTransformUtils.preCheckCast(new EntityIndexHelper$Companion$reportInvalidateIndexAsync$1(null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        }

        private final synchronized void j() {
            monitor-enter(this);
            long r0 = System.currentTimeMillis();     // Catch: Throwable -> L27
            long r2 = t.e();     // Catch: Throwable -> L27
            t.a(r0);     // Catch: Throwable -> L27
            if (t.d().isEmpty() == false) goto L7;
            monitor-exit(this);
            return;
        L7:
            JSONObject r4 = new JSONObject();     // Catch: Throwable -> L27
            Iterator r5 = ((Map) ZeusTransformUtils.preCheckCast(t.d(), Map.class, "com.obric.memorydata.plugin")).entrySet().iterator();     // Catch: Throwable -> L27
        L9:
            if (r5.hasNext() == false) goto L18;
            Map.Entry r6 = (Map.Entry) ZeusTransformUtils.preCheckCast(r5.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L27
            Integer r7 = (Integer) ZeusTransformUtils.preCheckCast(r6.getKey(), Integer.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L27
            Long r8 = (Long) ZeusTransformUtils.preCheckCast(r6.getValue(), Long.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L27
            if (r8.longValue() <= 0) goto L9;
            String r9 = r7.toString();     // Catch: Throwable -> L27
            Intrinsics.checkNotNull(r7);     // Catch: Throwable -> L27
            int r10 = b(r7.intValue());     // Catch: Throwable -> L27
            Intrinsics.checkNotNull(r8);     // Catch: Throwable -> L27
            r4.put(r9, r8.longValue());     // Catch: Throwable -> L27
            r4.put(r9 + "_totalCount", r10);     // Catch: Throwable -> L27
            String r11 = r9 + "_invalidRate";     // Catch: Throwable -> L27
            if (r10 <= 0) goto L15;
            double r12 = r8.longValue() / ((double) r10);     // Catch: Throwable -> L27
        L16:
            r4.put(r11, r12);     // Catch: Throwable -> L27
            goto L9
        L15:
            r12 = -1.0d;
            goto L16
        L18:
            if (r4.length() != 0) goto L23;
            monitor-exit(this);
            return;
        L23:
            if (Math.abs(r0 - r2) < WifiScanStateMachine.WAKE_LOCK_TIMEOUT_1_DATE_MS) goto L25;
            Tracker.INSTANCE.reportEvent("invalidate_entity_index_event", r4);     // Catch: Throwable -> L27
            t.d().clear();     // Catch: Throwable -> L27
        L25:
            monitor-exit(this);
            return;
        L27:
            th = move-exception;
            throw th;
        }

        public static /* synthetic */ float[] lambda$1UdDp8GpjkvmE6e7VbkJ4Wvqwqw(String r0, boolean r1, boolean r2) {
            return c(r0, r1, r2);
        }

        public static /* synthetic */ float[] lambda$8ErnSW5G2xOwHDGqy9bFDfCAjBg(String r0, boolean r1, boolean r2) {
            return d(r0, r1, r2);
        }

        public final String a(String r8) {
            if (r8 == null) goto L7;
            List r7 = StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin"), new String[]{"/"}, false, 0, 6, null);
            if (r7 == null) goto L7;
            String r9 = (String) ZeusTransformUtils.preCheckCast(r7.get(0), String.class, "com.obric.memorydata.plugin");
            if (r9 == null) goto L7;
            return r9;
        L7:
            return "";
        }

        public final List<String> a() {
            return t.c();
        }

        public final List<String> a(String r8, int r9, String r10) {
            Intrinsics.checkNotNullParameter(r8, "input");
            if (Intrinsics.areEqual(r10, ChunkType.PROACTIVE_MEMORY.toString()) == false) goto L18;
            Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin"), new String[]{"\n- "}, false, 0, 6, null), Iterable.class, "com.obric.memorydata.plugin");
            Collection r11 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
            Iterator r12 = r7.iterator();
        L6:
            if (r12.hasNext() == false) goto L13;
            Object r1 = r12.next();
            if (((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r1, String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L10;
            boolean r2 = true;
        L11:
            if (r2 == false) goto L6;
            r11.add(r1);
            goto L6
        L10:
            r2 = false;
            goto L11
        L13:
            List r13 = (List) ZeusTransformUtils.preCheckCast(r11, List.class, "com.obric.memorydata.plugin");
            List<String> r14 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
            Iterator r15 = ((Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        L15:
            if (r15.hasNext() == false) goto L25;
            r14.addAll((Collection) ZeusTransformUtils.preCheckCast(StringsKt.chunked((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r15.next(), String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin"), r9), Collection.class, "com.obric.memorydata.plugin"));
            goto L15
        L25:
            return r14;
        L18:
            return a(this, r8, 0, 2, null);
        }

        public final Map<String, String> a(Map<String, String> r7) {
            Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "values");
            Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(com.obric.memorydata.database.a.a.a(), Iterable.class, "com.obric.memorydata.plugin");
            LinkedHashMap r1 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r8, 10)), 16));
            Iterator r9 = r8.iterator();
        L4:
            if (r9.hasNext() == false) goto L10;
            Object r2 = r9.next();
            Map r3 = (Map) ZeusTransformUtils.preCheckCast(r1, Map.class, "com.obric.memorydata.plugin");
            String r4 = (String) ZeusTransformUtils.preCheckCast(r6.get((String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.memorydata.plugin")), String.class, "com.obric.memorydata.plugin");
            if (r4 != null) goto L8;
            r4 = "";
        L8:
            r3.put(r2, r4);
            goto L4
        L10:
            return (Map) ZeusTransformUtils.preCheckCast(r1, Map.class, "com.obric.memorydata.plugin");
        }

        public final void a(boolean r20) {
            if (b() == false) goto L7;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityIndexHelper", "isDisableRefreshVlmVectorUpdateState is true, refreshExistingEmbeddingVectorUpdateTaskDone end", false, 4, null);
            return;
        L7:
            if (IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).getBoolean("check_existing_data_embedding_vector_update_task", false) == true) goto L9;
            return;
        L9:
            if (c() == false) goto L11;
            return;
        L11:
            Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(com.obric.memorydata.database.manager.c.f9561a.a(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
            long r8 = 0;
        L13:
            if (r0.hasNext() == false) goto L16;
            r8 = r8 + com.obric.memorydata.database.manager.c.f9561a.a((String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.memorydata.plugin")).getCountByBuildTypeList(CollectionsKt.listOf(new String[]{"vlm_embedding_update_text_task", "vlm_embedding_update_image_task"}));
            goto L13
        L16:
            if (r8 > 0) goto L18;
            d();
            return;
        L18:
            if (r20 == true) goto L26;
            long r10 = System.currentTimeMillis();
            if ((!com.obric.memorydata.utils.h.a(IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).getLong("report_existing_data_embedding_vector_count_time", 0), r10)) == false) goto L27;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityIndexHelper", "report existing pending count with count " + r8, false, 4, null);
            IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).save("report_existing_data_embedding_vector_count_time", r10);
            Tracker r1 = Tracker.INSTANCE;
            JSONObject r2 = new JSONObject();
            r2.put(CommonConsts.COUNT_TYPE, r8);
            Unit r3 = Unit.INSTANCE;
            r1.reportEvent("existing_data_embedding_vector_update_count", r2);
            return;
        L27:
            return;
        }

        public final boolean a(com.obric.memorydata.database.entity.d r10) {
            Intrinsics.checkNotNullParameter(r10, "entity");
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityIndexHelper", "buildMetaFullContent id: " + r10.getEntityId() + " type: " + r10.getType() + ", lang=" + com.obric.memorydata.utils.ac.f13156a.a(), false, 4, null);
            TaskRequest.Builder r0 = new TaskRequest.Builder("build_meta_full_content");
            JSONObject r1 = new JSONObject();
            r1.put("rawDbId", r10.getId());
            r1.put("entityType", r10.getType());
            if (r10.getType() == (-303)) goto L5;
        L7:
            r1.put("lang", com.obric.memorydata.utils.ac.f13156a.a());
            if (((TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(r0.setInputParam(r1), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setTaskInfoCallback(h()), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin")).execute().getCode() != 0) goto L10;
            return true;
        L10:
            return false;
        L5:
            if (ZeusTransformUtils.instanceOf(r10, RawMemoryEntity.class) == false) goto L7;
            r1.put("memoryType", ((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r10, RawMemoryEntity.class, "com.obric.memorydata.plugin")).getMemoryType());
            goto L7
        }

        public final boolean a(com.obric.memorydata.database.entity.d r8, com.obric.memorydata.database.entity.d r9, boolean r10) {
            if (r8 == null) goto L19;
            if (r9 == null) goto L19;
            if (r9.getType() != 1301) goto L10;
            return false;
        L10:
            if (r8.getHashCodeValue() != r9.getHashCodeValue()) goto L19;
            if (r9.getHashCodeValue() == 0) goto L19;
            ((Map) ZeusTransformUtils.preCheckCast(t.d(), Map.class, "com.obric.memorydata.plugin")).put(Integer.valueOf(r9.getType()), Long.valueOf(((Long) ZeusTransformUtils.preCheckCast(t.d().getOrDefault(Integer.valueOf(r9.getType()), 0L), Long.class, "com.obric.memorydata.plugin")).longValue() + 1));
            if (Math.abs(System.currentTimeMillis() - t.e()) < WifiScanStateMachine.WAKE_LOCK_TIMEOUT_1_DATE_MS) goto L17;
            i();
        L17:
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityIndexHelper", "checkInvalidateIndex id: " + r9.getEntityId() + ", type: " + r9.getType() + ", hashCode: " + r8.getHashCodeValue() + "(old) " + r9.getHashCodeValue() + "(new)", false, 4, null);
            return true;
        L19:
            return false;
        }

        public final boolean a(gi r12, String r13) {
            Intrinsics.checkNotNullParameter(r12, "entity");
            CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.memorydata.plugin");
            if (r0 != null) goto L5;
        L8:
            boolean r1 = true;
        L10:
            if (r1 == false) goto L13;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityIndexHelper", "parseIcsProtocol id: " + r12.getEntityId() + ", icsProtocol is empty", false, 4, null);
            return true;
        L13:
            RunLog.INSTANCE.debug("EntityIndexHelper", "parseIcsProtocol id: " + r12.getEntityId());
            TaskRequest.Builder r2 = new TaskRequest.Builder("parse_ics_protocol_task");
            JSONObject r4 = new JSONObject();
            r4.put("entityId", r12.getEntityId());
            r4.put("icsProtocol", r13);
            r4.put("createTime", r12.getCreateTime());
            r4.put("modifyTime", r12.getModifyTime());
            r4.put(ObricMemoryConstants.KEY_PACKAGE_NAME, r12.getPackageName());
            if (((TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(r2.setInputParam(r4), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setTaskInfoCallback(h()), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin")).execute().getCode() == 0) goto L16;
            return false;
        L16:
            return true;
        L5:
            if (r0.length() == 0) goto L8;
            r1 = false;
            goto L10
        }

        public final boolean a(FullTextSearchSchema r7, long r8, Map<String, String> r10) {
            Map<String, String> r11 = (Map) ZeusTransformUtils.wrapperContextForParams(r10, Map.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r7, "schema");
            Intrinsics.checkNotNullParameter(r11, "values");
            boolean r6 = com.obric.memorydata.database.util.d.delete(r7, CollectionsKt.listOf(new CommonTextSearchDocument(r8, r7.a(), a(r11))));
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityIndexHelper", "deleteKeywordIndex result " + r6 + ", " + r7.a() + " id: " + r8, false, 4, null);
            return r6;
        }

        public final boolean a(FullTextSearchSchema r8, List<Long> r9) {
            List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r8, "schema");
            Intrinsics.checkNotNullParameter(r7, "rawEntityIdList");
            Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin");
            Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10)), Collection.class, "com.obric.memorydata.plugin");
            Iterator r11 = r10.iterator();
        L4:
            if (r11.hasNext() == false) goto L6;
            r1.add(new CommonTextSearchDocument(((Number) ZeusTransformUtils.preCheckCast(r11.next(), Number.class, "com.obric.memorydata.plugin")).longValue(), r8.a(), MapsKt.emptyMap()));
            goto L4
        L6:
            boolean r12 = com.obric.memorydata.database.util.d.delete(r8, (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin"));
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityIndexHelper", "deleteKeywordIndexListWithSchema  result " + r12 + ", " + r8.a() + " id: " + r7, false, 4, null);
            return r12;
        }

        public final boolean a(String r7, long r8, float[] r10, boolean r11) {
            Intrinsics.checkNotNullParameter(r7, "tableName");
            Intrinsics.checkNotNullParameter(r10, "vectorArray");
            boolean r6 = PersonalContextAPI.INSTANCE.insertVectorCopilotItem(r7, r8, r10, r11);
            if (r6 == true) goto L5;
            IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityIndexHelper", "insertVectorData failed for table " + r7 + ", id: " + r8, null, 4, null);
        L5:
            return r6;
        }

        public final boolean a(String r12, String r13, Function1<? super String, Unit> r14) {
            Function1 r11 = (Function1) ZeusTransformUtils.wrapperContextForParams(r14, Function1.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r12, EventBody.KEY_VALUE);
            Intrinsics.checkNotNullParameter(r13, "fields");
            Intrinsics.checkNotNullParameter(r11, "fillField");
            List r15 = StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.memorydata.plugin"), new String[]{","}, false, 0, 6, null);
            new JSONArray(r12);     // Catch: JSONException -> L5
            boolean r3 = true;
        L6:
            StringBuilder r4 = new StringBuilder();
            if (r3 == false) goto L22;
            JSONArray r5 = new JSONArray(r12);     // Catch: Exception -> L34
            int r16 = r5.length();     // Catch: Exception -> L34
            int r6 = 0;
        L9:
            if (r6 >= r16) goto L20;
            JSONObject r7 = new JSONObject(r5.get(r6).toString());     // Catch: Exception -> L34
            Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Exception -> L34
        L12:
            if (r8.hasNext() == false) goto L19;
            String r9 = r7.optString((String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L34
            Intrinsics.checkNotNull(r9);     // Catch: Exception -> L34
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L16;
            boolean r10 = true;
        L17:
            if (r10 == false) goto L12;
            r4.append(r9);     // Catch: Exception -> L34
            goto L12
        L16:
            r10 = false;
            goto L17
        L19:
            r4.append(",");     // Catch: Exception -> L34
            r6 = r6 + 1;     // Catch: Exception -> L34
            goto L9
        L20:
            String r17 = r4.toString();     // Catch: Exception -> L34
        L21:
            Intrinsics.checkNotNullExpressionValue(r17, "toString(...)");     // Catch: Exception -> L34
            r11.invoke(r17);     // Catch: Exception -> L34
            return true;
        L22:
            JSONObject r18 = new JSONObject(r12);     // Catch: Exception -> L34
            Iterator r19 = ((Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Exception -> L34
        L24:
            if (r19.hasNext() == false) goto L31;
            String r20 = r18.optString((String) ZeusTransformUtils.preCheckCast(r19.next(), String.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L34
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L28;
            boolean r21 = true;
        L29:
            if (r21 == false) goto L24;
            r4.append(r20);     // Catch: Exception -> L34
            goto L24
        L28:
            r21 = false;
            goto L29
        L31:
            r17 = r4.toString();     // Catch: Exception -> L34
        L34:
            return false;
        L5:
            r3 = false;
            goto L6
        }

        public final float[] a(int r7, long r8, final String r10, final boolean r11, final boolean r12) {
            Intrinsics.checkNotNullParameter(r10, ChatMessage.TYPE_QUERY);
            return (float[]) ZeusTransformUtils.preCheckCast(ao.f9372a.a(r7, r8, "full_content", new $$Lambda$t$a$8ErnSW5G2xOwHDGqy9bFDfCAjBg(r10, r11, r12)), float[].class, "com.obric.memorydata.plugin");
        }

        public final float[] a(final String r2, final boolean r3, final boolean r4) {
            Intrinsics.checkNotNullParameter(r2, ChatMessage.TYPE_QUERY);
            return (float[]) ZeusTransformUtils.preCheckCast(ao.f9372a.a(new $$Lambda$t$a$1UdDp8GpjkvmE6e7VbkJ4Wvqwqw(r2, r3, r4)), float[].class, "com.obric.memorydata.plugin");
        }

        public final boolean b() {
            return false;
        }

        public final boolean b(com.obric.memorydata.database.entity.d r9) {
            Intrinsics.checkNotNullParameter(r9, "entity");
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityIndexHelper", "buildMetaFullContentForMigration type=" + r9.getType() + ", lang=" + com.obric.memorydata.utils.ac.f13156a.a(), false, 4, null);
            TaskRequest.Builder r8 = new TaskRequest.Builder("build_meta_full_content");
            JSONObject r0 = new JSONObject();
            r0.put("rawDbId", r9.getId());
            r0.put("entityType", r9.getType());
            if (r9.getType() == (-303)) goto L5;
        L7:
            r0.put("lang", com.obric.memorydata.utils.ac.f13156a.a());
            if (((TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(r8.setInputParam(r0), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin")).execute().getCode() != 0) goto L10;
            return true;
        L10:
            return false;
        L5:
            if (ZeusTransformUtils.instanceOf(r9, RawMemoryEntity.class) == false) goto L7;
            r0.put("memoryType", ((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r9, RawMemoryEntity.class, "com.obric.memorydata.plugin")).getMemoryType());
            goto L7
        }

        public final boolean c() {
            return IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).getBoolean("existing_data_embedding_vector_update_task_done", false);
        }

        public final void d() {
            if (b() == false) goto L6;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityIndexHelper", "isDisableRefreshVlmVectorUpdateState is true, setExistingDataEmbeddingVectorUpdateTaskDone end", false, 4, null);
            return;
        L6:
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityIndexHelper", "setExistingDataEmbeddingVectorUpdateTaskDone", false, 4, null);
            IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).save("existing_data_embedding_vector_update_task_done", true);
        }

        public final void e() {
            if (b() == false) goto L6;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityIndexHelper", "isDisableRefreshVlmVectorUpdateState is true, checkExistingEmbeddingVectorUpdateTaskOnStartUp end", false, 4, null);
            return;
        L6:
            Object r4 = null;
            boolean r7 = true;
            if (PersonalContextAPI.INSTANCE.canUseVlmEmbedding() == true) goto L10;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityIndexHelper", "VLMSupported is false, insertExistingDataMetaInfoFullContentTask end", false, 4, null);
            IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).save("check_existing_data_embedding_vector_update_task", true);
            d();
            return;
        L10:
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityIndexHelper", "insertExistingEmbeddingVectorUpdateTask start", false, 4, null);
            if (IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).getBoolean("check_existing_data_embedding_vector_update_task", false) == false) goto L18;
            if (c() == true) goto L15;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityIndexHelper", "register refreshExistingEmbeddingVectorUpdateTaskDoneTask", false, 4, null);
            a(true);
            ((TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(new TaskRequest.Builder(RefreshVectorDataUpdateStatusTask.TASK_NAME).setInputParam(new JSONObject()), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setConditions(new Condition[]{Condition.SCREEN_ON_OR_CHARGE}), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setInterval((com.obric.memorydata.task.impl.g) ZeusTransformUtils.preCheckCast(new com.obric.memorydata.task.impl.a(1), com.obric.memorydata.task.impl.g.class, "com.obric.memorydata.plugin")), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin")).enqueue();
            return;
        L15:
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityIndexHelper", "insertExistingEmbeddingVectorUpdateTask has done", false, 4, null);
            return;
        L18:
            if (c() == false) goto L21;
            IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).save("check_existing_data_embedding_vector_update_task", true);
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityIndexHelper", "checkExistingEmbeddingVectorUpdateTaskOnStartUp has done, return", false, 4, null);
            return;
        L21:
            Set<Integer> r1 = s.a().getEntityIndexImplMap().keySet();
            Intrinsics.checkNotNullExpressionValue(r1, "<get-keys>(...)");
            Iterator<Integer> r2 = r1.iterator();
        L23:
            if (r2.hasNext() == false) goto L33;
            int r9 = ((Number) ZeusTransformUtils.preCheckCast(r2.next(), Number.class, "com.obric.memorydata.plugin")).intValue();
            String r10 = "existing_data_embedding_vector_update_task_" + r9;
            if (IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, r4).getBoolean(r10, false) == true) goto L26;
            long r13 = System.currentTimeMillis();
            IAppEntityVectorCopilotDao<com.obric.memorydata.database.entity.i> r11 = s.a().getImageVectorCopilotDao(r9);
            IAppEntityVectorCopilotDao<com.obric.memorydata.database.entity.i> r15 = s.a().getTextVectorCopilotDao(r9);
            if (r11 != null) goto L32;
            if (r15 != null) goto L32;
            IRunLog r14 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
            StringBuilder r12 = new StringBuilder();
            String r16 = "insertExistingEmbeddingVectorUpdateTask not support, type: ";
        L27:
            IRunLog.a.a(r14, "EntityIndexHelper", r12.append(r16).append(r9).append(", continue").toString(), false, 4, null);
        L32:
            com.obric.memorydata.database.entity.a.b.f8862a.a(r9, "insertExistingEmbeddingVectorUpdateTask", CollectionsKt.listOf(new String[]{"vlm_embedding_update_text_task", "vlm_embedding_update_image_task"}), (com.obric.memorydata.database.entity.a.a) ZeusTransformUtils.preCheckCast(new C0458a(r15, r9, r11), com.obric.memorydata.database.entity.a.a.class, "com.obric.memorydata.plugin"));
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityIndexHelper", "insertExistingDataMetaInfoFullContentTask end, type: " + r9 + ", cost: " + (System.currentTimeMillis() - r13) + "ms", false, 4, null);
            IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).save(r10, true);
            r4 = null;
            r7 = true;
            goto L23
        L26:
            r14 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
            r12 = new StringBuilder();
            r16 = "insertExistingEmbeddingVectorUpdateTask has done, type: ";
            goto L27
        L33:
            boolean r17 = r7;
            IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, r4).save("check_existing_data_embedding_vector_update_task", r17);
            a(r17);
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityIndexHelper", "insertExistingEmbeddingVectorUpdateTask end", false, 4, null);
        }

        public final boolean f() {
            if (AppContext.INSTANCE.isDebug() == true) goto L5;
        L8:
            return false;
        L5:
            if (IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).getBoolean("is_instant_entity_index_switch_on", false) == false) goto L8;
            return true;
        }

        public final void g() {
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityIndexHelper", "insertExistingDataMetaInfoFullContentTask start", false, 4, null);
            Set<Integer> r0 = s.a().getEntityIndexImplMap().keySet();
            Intrinsics.checkNotNullExpressionValue(r0, "<get-keys>(...)");
            Iterator<Integer> r1 = r0.iterator();
        L4:
            if (r1.hasNext() == false) goto L15;
            int r2 = ((Number) ZeusTransformUtils.preCheckCast(r1.next(), Number.class, "com.obric.memorydata.plugin")).intValue();
            if (s.a().isBuildMetaInfoFullContent(r2) == false) goto L4;
            String r4 = a(r2);
            if (r4 == null) goto L4;
            boolean r5 = IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).getBoolean(r4, false);
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityIndexHelper", "insertExistingDataMetaInfoFullContentTask start, type: " + r2 + ", isBuildSuccess: " + r5, false, 4, null);
            if (r5 == true) goto L4;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityIndexHelper", "insertExistingDataMetaInfoFullContentTask start, type: " + r2, false, 4, null);
            long r10 = System.currentTimeMillis();
            com.obric.memorydata.database.entity.a.b.f8862a.a(r2, "meta_full_content", (com.obric.memorydata.database.entity.a.a) ZeusTransformUtils.preCheckCast(new b(r2), com.obric.memorydata.database.entity.a.a.class, "com.obric.memorydata.plugin"), "meta_full_content");
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityIndexHelper", "insertExistingDataMetaInfoFullContentTask end, type: " + r2 + ", cost: " + (System.currentTimeMillis() - r10) + "ms", false, 4, null);
            IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).save(r4, true);
            goto L4
        L15:
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityIndexHelper", "insertExistingDataMetaInfoFullContentTask end", false, 4, null);
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f9443a = null;

        static {
            int[] r0 = new int[EmbeddingState.values().length];
            r0[EmbeddingState.USE_VLM.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[EmbeddingState.USE_LITTLE_MODEL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f9443a = r0;
        }
    }

    static {
        f9438a = new a(null);
        j = System.currentTimeMillis();
        k = new ConcurrentHashMap();
        l = new AtomicBoolean(false);
        m = CollectionsKt.toMutableList((Collection) ZeusTransformUtils.preCheckCast(z.f9451a.a(), Collection.class, "com.obric.memorydata.plugin"));
    }

    public t() {
        this.h = "build_entity_full_content";
        this.i = "parse_ics_protocol";
    }

    private final String a(Uri r5) {
        String r0 = r5.getScheme();
        if (r0 == null) goto L22;
        int r2 = r0.hashCode();
        if (r2 == 3143036) goto L15;
        if (r2 == 951530617) goto L10;
        return "";
    L10:
        if (r0.equals(Params.CONTENT) == false) goto L23;
        String r4 = a(r5, null, null);
        if (r4 != null) goto L21;
        return "";
    L21:
        return r4;
    L23:
        return "";
    L15:
        if (r0.equals("file") == false) goto L26;
        r4 = r5.getPath();
        if (r4 != null) goto L21;
        return "";
    L26:
        return "";
    L22:
        return "";
    }

    private static final String a(Uri r2, String r3) {
        return (String) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.i.a(null, (Function2) ZeusTransformUtils.preCheckCast(new EntityIndexHelper$pictureToOCR$1$1(r2, r3, null), Function2.class, "com.obric.memorydata.plugin"), 1, null), String.class, "com.obric.memorydata.plugin");
    }

    private final String a(Uri r10, String r11, String[] r12) {
        String[] r3 = {"_data"};
        Cursor r8 = null;
        if (r10 != null) goto L26;
        Cursor r9 = null;
    L9:
        if (r9 != null) goto L24;
    L21:
        if (r9 == null) goto L23;
        r9.close();
    L23:
        return null;
    L24:
    L16:
        th = move-exception;
        r8 = r9;
        th = th;
    L18:
        if (r8 == null) goto L20;
        r8.close();
    L20:
        throw th;
    L11:
        if (r9.moveToFirst() == false) goto L21;
        String r13 = r9.getString(r9.getColumnIndexOrThrow("_data"));     // Catch: Throwable -> L16
        if (r9 == null) goto L15;
        r9.close();
    L15:
        return r13;
    L26:
        r9 = ZeusProviderTransform.query(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver(), r10, r3, r11, r12, null, "com.obric.memorydata.plugin");     // Catch: Throwable -> L6
    L6:
        th = th;
        goto L18
    }

    private final String a(final String r2, final Uri r3) {
        return (String) ZeusTransformUtils.preCheckCast(ao.f9372a.a(new $$Lambda$t$ImgoVO8PEay_edMwnw9Q0V3s_RQ(r2, r3)), String.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ void a(long r0) {
        j = r0;
    }

    private final boolean a(com.obric.memorydata.database.entity.d r7, Uri r8, boolean r9, Function1<? super List<String>, Unit> r10) {
        Function1 r11 = (Function1) ZeusTransformUtils.wrapperContextForParams(r10, Function1.class, "com.obric.memorydata.plugin");
        RunLog.INSTANCE.debug("EntityIndexHelper", "Starting buildPhotoTag for entity: " + r7.getEntityId());
        if (r9 == false) goto L5;
        String r12 = "";
    L6:
        List<String> r6 = b(r12, r8);
        RunLog.INSTANCE.debug("EntityIndexHelper", "Generated tagsList: " + r6);
        if (r6 != null) goto L10;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityIndexHelper", "Generated tagsList failed", null, 4, null);
        return false;
    L10:
        r11.invoke(r6);
        RunLog.INSTANCE.debug("EntityIndexHelper", "Finished buildPhotoTag for entity: " + r7.getEntityId());
        return true;
    L5:
        r12 = r7.getPackageName();
        goto L6
    }

    private final boolean a(com.obric.memorydata.database.entity.d r41, String r42, Uri r43) {
        RunLog.INSTANCE.debug("EntityIndexHelper", "embeddingVideo id: " + r41.getEntityId() + " type: " + r41.getType() + " column: " + r42);
        if (ZeusTransformUtils.instanceOf(r41, hb.class) == false) goto L8;
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getVideoFrameRawDbDao().queryByPhotoEntityDbId(((hb) ZeusTransformUtils.preCheckCast(r41, hb.class, "com.obric.memorydata.plugin")).getId()), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L6:
        if (r1.hasNext() == false) goto L12;
        hr r6 = (hr) ZeusTransformUtils.preCheckCast(r1.next(), hr.class, "com.obric.memorydata.plugin");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityIndexHelper", "delete old video frame, entityType = " + ((hb) ZeusTransformUtils.preCheckCast(r41, hb.class, "com.obric.memorydata.plugin")).getType() + " entityId = " + ((hb) ZeusTransformUtils.preCheckCast(r41, hb.class, "com.obric.memorydata.plugin")).getId(), false, 4, null);
        r6.delete();
    L12:
        List r2 = (List) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.i.a(null, (Function2) ZeusTransformUtils.preCheckCast(new EntityIndexHelper$embeddingVideo$extractResult$1(r43, null), Function2.class, "com.obric.memorydata.plugin"), 1, null), List.class, "com.obric.memorydata.plugin");
        RunLog.INSTANCE.debug("EntityIndexHelper", "extractVideoFrame finish, entityType = " + r41.getType() + " entityId = " + r41.getId());
        if (r2 != null) goto L17;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityIndexHelper", "extractVideoFrame failed, entityType = " + r41.getType() + " entityId = " + r41.getId(), null, 4, null);
        return false;
    L17:
        if (r2.isEmpty() == false) goto L20;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityIndexHelper", "extractVideoFrameResult is empty, entityType = " + r41.getType() + " entityId = " + r41.getId(), false, 4, null);
        return true;
    L20:
        long r7 = System.currentTimeMillis();
        int r4 = r2.size();
        int r9 = 0;
    L21:
        if (r9 >= r4) goto L27;
        VideoFrame r10 = (VideoFrame) ZeusTransformUtils.preCheckCast(r2.get(r9), VideoFrame.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r41, hb.class) == false) goto L25;
        Object r3 = ZeusTransformUtils.preCheckCast(new hr(0, ((hb) ZeusTransformUtils.preCheckCast(r41, hb.class, "com.obric.memorydata.plugin")).getEntityId() + "_index" + r9, ((hb) ZeusTransformUtils.preCheckCast(r41, hb.class, "com.obric.memorydata.plugin")).getCreateTime(), ((hb) ZeusTransformUtils.preCheckCast(r41, hb.class, "com.obric.memorydata.plugin")).getModifyTime(), -304, r7, ((hb) ZeusTransformUtils.preCheckCast(r41, hb.class, "com.obric.memorydata.plugin")).getPackageName(), 0, r10.getStartTime(), r10.getEndTime(), r10.getFrameTime(), null, null, null, null, ((hb) ZeusTransformUtils.preCheckCast(r41, hb.class, "com.obric.memorydata.plugin")).getId(), 30721, null), com.obric.memorydata.database.a.class, "com.obric.memorydata.plugin");
    L26:
        com.obric.memorydata.database.a.C0451a.a((com.obric.memorydata.database.a) r3, false, 1, null);
        r9 = r9 + 1;
        goto L21
    L25:
        r3 = ZeusTransformUtils.preCheckCast(new fv(0, r41.getEntityId() + "_index" + r9, r41.getCreateTime(), r41.getModifyTime(), NetError.ERR_UNSAFE_PORT, r7, r41.getPackageName(), 0, r10.getStartTime(), r10.getEndTime(), r10.getFrameTime(), null, null, r41.getId(), 6145, null), com.obric.memorydata.database.a.class, "com.obric.memorydata.plugin");
        goto L26
    L27:
        EntityManager.INSTANCE.launchIndexTask();
        return true;
    L8:
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getCommonVideoFrameRawDbDao().queryByPhotoEntityDbId(r41.getId()), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L10:
        if (r5.hasNext() == false) goto L12;
        fv r8 = (fv) ZeusTransformUtils.preCheckCast(r5.next(), fv.class, "com.obric.memorydata.plugin");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityIndexHelper", "delete old video frame, entityType = " + r41.getType() + " entityId = " + r41.getId(), false, 4, null);
        r8.delete();
        goto L10
    }

    private final boolean a(com.obric.memorydata.database.entity.d r23, String r24, Uri r25, String r26, boolean r27, Function1<? super String, Unit> r28) {
        Function1 r2 = (Function1) ZeusTransformUtils.wrapperContextForParams(r28, Function1.class, "com.obric.memorydata.plugin");
        IAppEntityVectorCopilotDao<T> r4 = this.f9439b;
        boolean r5 = false;
        if (r4 != null) goto L7;
        IRunLog r0 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        Throwable r1 = null;
        int r3 = 4;
        Object r6 = null;
        String r7 = "EntityIndexHelper";
        String r8 = "textDao is null";
    L5:
        IRunLog.a.b(r0, r7, r8, r1, r3, r6);
        return r5;
    L7:
        RunLog.INSTANCE.debug("EntityIndexHelper", "Starting embeddingPhotoOcr for entity: " + r23.getEntityId());
        if (r27 == false) goto L10;
        String r9 = "";
    L11:
        String r10 = c(r9, r25);
        RunLog.INSTANCE.debug("EntityIndexHelper", "Generated OCR text: " + r10);
        int r11 = 1;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L14;
        boolean r12 = true;
    L15:
        if (r12 == false) goto L65;
        r2.invoke(r10);
        com.obric.memorydata.database.entity.i r13 = null;
        List r14 = a.a(f9438a, r10, 0, 2, null);
        RunLog.INSTANCE.debug("EntityIndexHelper", "Split OCR text into chunks: " + r14);
        EmbeddingState r15 = PersonalContextAPI.INSTANCE.getEmbeddingState();
        Iterator r16 = r14.iterator();
    L18:
        if (r16.hasNext() == false) goto L66;
        String r17 = (String) ZeusTransformUtils.preCheckCast(r16.next(), String.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.database.entity.i r18 = r23.convertToTextVectorCopilotEntity(r24, r17);
        if (ZeusTransformUtils.instanceOf(r18, com.obric.memorydata.database.entity.i.class) == true) goto L23;
        r18 = r13;
    L23:
        if (r18 == null) goto L24;
        long r19 = r4.insert((T) r18);
        RunLog.INSTANCE.debug("EntityIndexHelper", "Inserted ocrEntity with ID: " + r19);
        int r20 = b.f9443a[r15.ordinal()];
        if (r20 != r11) goto L28;
        a r21 = f9438a;
        float[] r110 = r21.a(r17, true, true);
        if (r110 == null) goto L62;
        if (r21.a(r4.getTableName(), r19, r110, true) == false) goto L58;
        RunLog.INSTANCE.debug("EntityIndexHelper", "Inserted vector(vlm) data successfully");
    L61:
        r16 = r16;
        r15 = r15;
        r5 = false;
        r11 = 1;
        r13 = null;
        goto L18
    L58:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityIndexHelper", "Failed to insert vector(vlm) data, deleting ocrEntity", null, 4, null);
        r4.delete((T) r18);
        return false;
    L62:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityIndexHelper", "OCR embedding(vlm) failed id: " + r23.getEntityId() + " type: " + r23.getType(), null, 4, null);
        r4.delete((T) r18);
        return false;
    L28:
        if (r20 == 2) goto L45;
        a r22 = f9438a;
        float[] r111 = r22.a(r17, true, true);
        if (r111 == null) goto L44;
        if (r22.a(r4.getTableName(), r19, r111, true) == false) goto L33;
        RunLog.INSTANCE.debug("EntityIndexHelper", "Inserted vector(vlm) data successfully");
        float[] r112 = r22.a(r17, true, false);
        if (r112 == null) goto L42;
        if (r22.a(r4.getTableName(), r19, r112, false) == false) goto L40;
    L51:
        RunLog.INSTANCE.debug("EntityIndexHelper", "Inserted vector(model) data successfully");
        goto L61
    L40:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityIndexHelper", "Failed to insert vector(model) data, deleting ocrEntity", null, 4, null);
        r4.delete((T) r18);
        return false;
    L42:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityIndexHelper", "OCR embedding(model) failed id: " + r23.getEntityId() + " type: " + r23.getType(), null, 4, null);
        r4.delete((T) r18);
        return false;
    L33:
        IRunLog r29 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        Throwable r30 = null;
        int r31 = 4;
        Object r113 = null;
        String r32 = "EntityIndexHelper";
        String r33 = "Failed to insert vector(vlm) data, deleting ocrEntity";
    L34:
        IRunLog.a.b(r29, r32, r33, r30, r31, r113);
        r4.delete((T) r18);
        return false;
    L44:
        r29 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r33 = "OCR embedding(vlm) failed id: " + r23.getEntityId() + " type: " + r23.getType();
        r30 = null;
        r31 = 4;
        r113 = null;
        r32 = "EntityIndexHelper";
        goto L34
    L45:
        a r114 = f9438a;
        float[] r115 = r114.a(r17, true, false);
        if (r115 == null) goto L52;
        if (r114.a(r4.getTableName(), r19, r115, false) == true) goto L51;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityIndexHelper", "Failed to insert vector(model) data, deleting ocrEntity", null, 4, null);
        r4.delete((T) r18);
        return false;
    L52:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityIndexHelper", "OCR embedding(model) failed id: " + r23.getEntityId() + " type: " + r23.getType(), null, 4, null);
        r4.delete((T) r18);
        return false;
    L24:
        r0 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r1 = null;
        r3 = 4;
        r6 = null;
        r7 = "EntityIndexHelper";
        r8 = "Failed to convert entity to TextVectorCopilotEntity";
    L66:
        RunLog.INSTANCE.debug("EntityIndexHelper", "Finished embeddingPhotoOcr for entity: " + r23.getEntityId());
        return true;
    L65:
        RunLog.INSTANCE.debug("EntityIndexHelper", "OCR text is empty");
        goto L66
    L14:
        r12 = false;
        goto L15
    L10:
        r9 = r23.getPackageName();
        goto L11
    }

    private final boolean a(com.obric.memorydata.database.entity.d r23, String r24, Uri r25, boolean r26, boolean r27) {
        RunLog.INSTANCE.debug("EntityIndexHelper", "embeddingPicture id: " + r23.getEntityId() + " type: " + r23.getType() + " column: " + r24);
        long r2 = System.currentTimeMillis();
        com.obric.memorydata.database.entity.i r5 = r23.convertToImageVectorCopilotEntity(r24);
        if (ZeusTransformUtils.instanceOf(r5, com.obric.memorydata.database.entity.i.class) == true) goto L6;
        r5 = null;
    L6:
        boolean r8 = false;
        if (r5 != null) goto L10;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityIndexHelper", "vectorEntity is null id: " + r23.getEntityId() + " type: " + r23.getType(), null, 4, null);
        return false;
    L10:
        EmbeddingState r9 = PersonalContextAPI.INSTANCE.getEmbeddingState();
        IAppEntityVectorCopilotDao<T> r10 = this.c;
        if (r10 == null) goto L57;
        long r13 = r10.insert((T) r5);
        RunLog.INSTANCE.debug("EntityIndexHelper", "entityImageVectorCopilotDao insert " + r13);
        int r6 = b.f9443a[r9.ordinal()];
        if (r6 != 1) goto L15;
        r2 = r2;
        boolean r7 = false;
        if (r27 == false) goto L49;
        float[] r0 = b("", r25, true);
    L50:
        float[] r15 = r0;
        if (r13 <= 0) goto L55;
        if (r15 == null) goto L55;
        boolean r1 = f9438a.a(r10.getTableName(), r13, r15, true);
    L54:
        r8 = r1;
    L58:
        if (r8 == false) goto L61;
        if (r26 == false) goto L61;
        com.obric.memorydata.database.util.b.f9624a.a("image_embedding_perf_event", String.valueOf(r23.getType()), "imageEmbeddingIndexCost", System.currentTimeMillis() - r2);
    L61:
        return r8;
    L55:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityIndexHelper", "ImageVectorCopilot(vlm) failed id: " + r23.getEntityId() + " type: " + r23.getType(), null, 4, null);
    L56:
        r8 = r7;
        goto L58
    L49:
        r0 = a(r23.getPackageName(), r25, true);
        goto L50
    L15:
        if (r6 == 2) goto L37;
        if (r27 == false) goto L18;
        float[] r11 = b("", r25, true);
    L20:
        if (r13 <= 0) goto L23;
        if (r11 == null) goto L23;
        boolean r12 = f9438a.a(r10.getTableName(), r13, r11, true);
    L25:
        if (r27 == false) goto L27;
        float[] r3 = b("", r25, false);
    L28:
        float[] r16 = r3;
        if (r13 <= 0) goto L32;
        if (r16 == null) goto L32;
        boolean r14 = f9438a.a(r10.getTableName(), r13, r16, false);
    L33:
        if (r12 == false) goto L36;
        if (r14 == false) goto L36;
        r8 = true;
    L36:
        r8 = false;
    L32:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityIndexHelper", "ImageVectorCopilot(model) failed id: " + r23.getEntityId() + " type: " + r23.getType(), null, 4, null);
        r14 = false;
        goto L33
    L27:
        r3 = a(r23.getPackageName(), r25, false);
    L23:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityIndexHelper", "ImageVectorCopilot(vlm) failed id: " + r23.getEntityId() + " type: " + r23.getType(), null, 4, null);
        r12 = false;
        goto L25
    L18:
        r11 = a(r23.getPackageName(), r25, true);
        goto L20
    L37:
        r2 = r2;
        r7 = false;
        if (r27 == false) goto L40;
        float[] r4 = b("", r25, false);
    L41:
        float[] r17 = r4;
        if (r13 <= 0) goto L45;
        if (r17 == null) goto L45;
        r1 = f9438a.a(r10.getTableName(), r13, r17, false);
    L45:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityIndexHelper", "ImageVectorCopilot(model) failed id: " + r23.getEntityId() + " type: " + r23.getType(), null, 4, null);
        goto L56
    L40:
        r4 = a(r23.getPackageName(), r25, false);
        goto L41
    L57:
        r2 = r2;
        goto L58
    }

    private final boolean a(com.obric.memorydata.database.entity.j r11, String r12, Function1<? super String, Unit> r13) {
        Function1<? super String, Unit> r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r13, Function1.class, "com.obric.memorydata.plugin");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityIndexHelper", "embeddingVideoFrameOcr id: " + r11.getEntityId() + " type: " + r11.getType() + " column: " + r12, false, 4, null);
        String r14 = r11.g();
        CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == false) goto L13;
        IRunLog r4 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r10 = new StringBuilder().append("embeddingVideoFrameOcr id: ").append(r11.getEntityId());
        String r15 = " fileEntityJson is null";
    L11:
        IRunLog.a.b(r4, "EntityIndexHelper", r10.append(r15).toString(), null, 4, null);
        return false;
    L13:
        FileEntity r16 = com.obric.memorydata.personalcontext.util.f.b(r14);
        long r5 = r11.c();
        if (Intrinsics.areEqual(f9438a.a(r16.getMimeType()), "video") == true) goto L16;
        r4 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r10 = new StringBuilder().append("embeddingVideoFrameOcr id: ").append(r11.getEntityId()).append(" mimeType: ").append(r16.getMimeType());
        r15 = " not supported";
        goto L11
    L16:
        Uri r17 = EntityVideoExtractHelper.INSTANCE.extractFrame(r11.getPackageName(), r16.getContentUrl(), r5);
        if (r17 != null) goto L25;
        r4 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r10 = new StringBuilder().append("embeddingVideoFrameOcr id: ").append(r11.getEntityId());
        r15 = " pic is null";
        goto L11
    L25:
        boolean r18 = a((com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast(r11, com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin"), r12, r17, r12, true, r8);     // Catch: Throwable -> L22
        EntityVideoExtractHelper.INSTANCE.deleteTempPicPath(r17);
        return r18;
    L22:
        th = move-exception;
        EntityVideoExtractHelper.INSTANCE.deleteTempPicPath(r17);
        throw th;
    L5:
        if (r2.length() == 0) goto L8;
        r3 = false;
        goto L9
    }

    private final boolean a(com.obric.memorydata.database.entity.j r17, Function1<? super List<String>, Unit> r18) {
        Function1<? super List<String>, Unit> r0 = (Function1) ZeusTransformUtils.wrapperContextForParams(r18, Function1.class, "com.obric.memorydata.plugin");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityIndexHelper", "buildVideoFrameTag id: " + r17.getEntityId() + " type: " + r17.getType(), false, 4, null);
        String r2 = r17.g();
        CharSequence r3 = (CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L5;
    L8:
        boolean r4 = true;
    L9:
        if (r4 == false) goto L13;
        IRunLog r10 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r1 = new StringBuilder().append("buildVideoFrameTag id: ").append(r17.getEntityId());
        String r5 = " fileEntityJson is null";
    L11:
        IRunLog.a.b(r10, "EntityIndexHelper", r1.append(r5).toString(), null, 4, null);
        return false;
    L13:
        FileEntity r6 = com.obric.memorydata.personalcontext.util.f.b(r2);
        long r7 = r17.c();
        if (Intrinsics.areEqual(f9438a.a(r6.getMimeType()), "video") == true) goto L16;
        r10 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r1 = new StringBuilder().append("buildVideoFrameTag id: ").append(r17.getEntityId()).append(" mimeType: ").append(r6.getMimeType());
        r5 = " not supported";
        goto L11
    L16:
        Uri r8 = EntityVideoExtractHelper.INSTANCE.extractFrame(r17.getPackageName(), r6.getContentUrl(), r7);
        if (r8 != null) goto L25;
        r10 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r1 = new StringBuilder().append("buildVideoFrameTag id: ").append(r17.getEntityId());
        r5 = " pic is null";
        goto L11
    L25:
        boolean r9 = a((com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast(r17, com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin"), r8, true, r0);     // Catch: Throwable -> L22
        EntityVideoExtractHelper.INSTANCE.deleteTempPicPath(r8);
        return r9;
    L22:
        th = move-exception;
        EntityVideoExtractHelper.INSTANCE.deleteTempPicPath(r8);
        throw th;
    L5:
        if (r3.length() == 0) goto L8;
        r4 = false;
        goto L9
    }

    static /* synthetic */ boolean a(t r6, com.obric.memorydata.database.entity.d r7, String r8, Uri r9, boolean r10, boolean r11, int r12, Object r13) {
        if ((r12 & 8) == 0) goto L5;
        r10 = true;
    L5:
        boolean r4 = r10;
        if ((r12 & 16) == 0) goto L9;
        r11 = false;
    L9:
        return r6.a(r7, r8, r9, r4, r11);
    }

    public static /* synthetic */ boolean a(t r0, com.obric.memorydata.database.entity.d r1, String r2, String r3, String r4, int r5, Object r6) {
        if ((r5 & 8) == 0) goto L6;
        r4 = null;
    L6:
        return r0.b(r1, r2, r3, r4);
    }

    private static final float[] a(Uri r2, String r3, boolean r4) {
        return (float[]) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.i.a(null, (Function2) ZeusTransformUtils.preCheckCast(new EntityIndexHelper$pictureToVector$1$1(r2, r3, r4, null), Function2.class, "com.obric.memorydata.plugin"), 1, null), float[].class, "com.obric.memorydata.plugin");
    }

    private final float[] a(final String r2, final Uri r3, final boolean r4) {
        return (float[]) ZeusTransformUtils.preCheckCast(ao.f9372a.a(new $$Lambda$t$1cO6eNA8Wi6Sy0QNuv6BTEo6BZk(r3, r2, r4)), float[].class, "com.obric.memorydata.plugin");
    }

    private final List<String> b(final String r2, final Uri r3) {
        return (List) ZeusTransformUtils.preCheckCast(ao.f9372a.a(new $$Lambda$t$aw80a9tR1jDIw_Hw3_tN4GKrJQ(r2, r3)), List.class, "com.obric.memorydata.plugin");
    }

    private final boolean b(com.obric.memorydata.database.entity.d r21, String r22, Uri r23, String r24, boolean r25, Function1<? super String, Unit> r26) {
        Function1 r2 = (Function1) ZeusTransformUtils.wrapperContextForParams(r26, Function1.class, "com.obric.memorydata.plugin");
        IAppEntityVectorCopilotDao<T> r4 = this.f9439b;
        if (r4 != null) goto L6;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityIndexHelper", "textDao is null", null, 4, null);
        return false;
    L6:
        RunLog.INSTANCE.debug("EntityIndexHelper", "Starting embeddingPhotoCaption for entity: " + r21.getEntityId());
        if (r25 == false) goto L9;
        String r6 = "";
    L10:
        String r0 = a(r6, r23);
        RunLog.INSTANCE.debug("EntityIndexHelper", "Generated caption: " + r0);
        if (r0 != null) goto L15;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityIndexHelper", "Generated caption failed", null, 4, null);
        return false;
    L15:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L17;
        boolean r1 = true;
    L18:
        if (r1 == false) goto L65;
        r2.invoke(r0);
        EmbeddingState r3 = PersonalContextAPI.INSTANCE.getEmbeddingState();
        com.obric.memorydata.database.entity.i r7 = r21.convertToTextVectorCopilotEntity(r22, r0);
        if (ZeusTransformUtils.instanceOf(r7, com.obric.memorydata.database.entity.i.class) == true) goto L23;
        r7 = null;
    L23:
        if (r7 != null) goto L26;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityIndexHelper", "Failed to convert entity to TextVectorCopilotEntity", null, 4, null);
        return false;
    L26:
        long r14 = r4.insert((T) r7);
        RunLog.INSTANCE.debug("EntityIndexHelper", "Inserted textEntity with ID: " + r14);
        int r5 = b.f9443a[r3.ordinal()];
        if (r5 != 1) goto L29;
        a r8 = f9438a;
        float[] r13 = r8.a(r0, true, true);
        if (r13 != null) goto L59;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityIndexHelper", "caption embedding(vlm) failed id: " + r21.getEntityId() + " type: " + r21.getType(), null, 4, null);
        r4.delete((T) r7);
        return false;
    L59:
        if (r8.a(r4.getTableName(), r14, r13, true) == true) goto L62;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityIndexHelper", "Failed to insert vector(vlm) data, deleting textEntity", null, 4, null);
        r4.delete((T) r7);
        return false;
    L62:
        RunLog.INSTANCE.debug("EntityIndexHelper", "Inserted vector(vlm) data successfully");
    L67:
        RunLog.INSTANCE.debug("EntityIndexHelper", "Finished embeddingPhotoCaption for entity: " + r21.getEntityId());
        return true;
    L29:
        if (r5 == 2) goto L47;
        a r9 = f9438a;
        float[] r16 = r9.a(r0, true, true);
        if (r16 != null) goto L33;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityIndexHelper", "caption embedding(vlm) failed id: " + r21.getEntityId() + " type: " + r21.getType(), null, 4, null);
        r4.delete((T) r7);
        return false;
    L33:
        if (r9.a(r4.getTableName(), r14, r16, true) == true) goto L36;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityIndexHelper", "Failed to insert vector(vlm) data, deleting textEntity", null, 4, null);
        r4.delete((T) r7);
        return false;
    L36:
        RunLog.INSTANCE.debug("EntityIndexHelper", "Inserted vector(vlm) data successfully");
        float[] r15 = r9.a(r0, true, false);
        if (r15 != null) goto L39;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityIndexHelper", "caption embedding(model) failed id: " + r21.getEntityId() + " type: " + r21.getType(), null, 4, null);
        r4.delete((T) r7);
        return false;
    L39:
        if (r9.a(r4.getTableName(), r14, r15, false) == true) goto L42;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityIndexHelper", "Failed to insert vector(model) data, deleting textEntity", null, 4, null);
        r4.delete((T) r7);
        return false;
    L42:
        RunLog r10 = RunLog.INSTANCE;
        String r11 = "Inserted vector(model) data successfully";
    L66:
        r10.debug("EntityIndexHelper", r11);
        goto L67
    L47:
        r11 = "Inserted vector(model) data successfully";
        a r12 = f9438a;
        float[] r17 = r12.a(r0, true, false);
        if (r17 != null) goto L50;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityIndexHelper", "caption embedding(model) failed id: " + r21.getEntityId() + " type: " + r21.getType(), null, 4, null);
        r4.delete((T) r7);
        return false;
    L50:
        if (r12.a(r4.getTableName(), r14, r17, false) == true) goto L53;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityIndexHelper", "Failed to insert vector(model) data, deleting textEntity", null, 4, null);
        r4.delete((T) r7);
        return false;
    L53:
        r10 = RunLog.INSTANCE;
        goto L66
    L65:
        r10 = RunLog.INSTANCE;
        r11 = "Caption is empty";
        goto L66
    L17:
        r1 = false;
        goto L18
    L9:
        r6 = r21.getPackageName();
        goto L10
    }

    private final boolean b(com.obric.memorydata.database.entity.j r11, String r12, Function1<? super String, Unit> r13) {
        Function1<? super String, Unit> r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r13, Function1.class, "com.obric.memorydata.plugin");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityIndexHelper", "embeddingVideoFrameCaption id: " + r11.getEntityId() + " type: " + r11.getType() + " column: " + r12, false, 4, null);
        String r14 = r11.g();
        CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == false) goto L13;
        IRunLog r4 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r10 = new StringBuilder().append("embeddingVideoFrameCaption id: ").append(r11.getEntityId());
        String r15 = " fileEntityJson is null";
    L11:
        IRunLog.a.b(r4, "EntityIndexHelper", r10.append(r15).toString(), null, 4, null);
        return false;
    L13:
        FileEntity r16 = com.obric.memorydata.personalcontext.util.f.b(r14);
        long r5 = r11.c();
        if (Intrinsics.areEqual(f9438a.a(r16.getMimeType()), "video") == true) goto L16;
        r4 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r10 = new StringBuilder().append("embeddingVideoFrameCaption id: ").append(r11.getEntityId()).append(" mimeType: ").append(r16.getMimeType());
        r15 = " not supported";
        goto L11
    L16:
        Uri r17 = EntityVideoExtractHelper.INSTANCE.extractFrame(r11.getPackageName(), r16.getContentUrl(), r5);
        if (r17 != null) goto L25;
        r4 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r10 = new StringBuilder().append("embeddingVideoFrameCaption id: ").append(r11.getEntityId());
        r15 = " pic is null";
        goto L11
    L25:
        boolean r18 = b((com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast(r11, com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin"), r12, r17, r12, true, r8);     // Catch: Throwable -> L22
        EntityVideoExtractHelper.INSTANCE.deleteTempPicPath(r17);
        return r18;
    L22:
        th = move-exception;
        EntityVideoExtractHelper.INSTANCE.deleteTempPicPath(r17);
        throw th;
    L5:
        if (r2.length() == 0) goto L8;
        r3 = false;
        goto L9
    }

    public static /* synthetic */ boolean b(t r0, com.obric.memorydata.database.entity.d r1, String r2, String r3, String r4, int r5, Object r6) {
        if ((r5 & 8) == 0) goto L6;
        r4 = null;
    L6:
        return r0.d(r1, r2, r3, r4);
    }

    private final float[] b(final String r2, final Uri r3, final boolean r4) {
        return (float[]) ZeusTransformUtils.preCheckCast(ao.f9372a.a(new $$Lambda$t$holfhiPuyxb7Cl9bU_avm5Hd0(r2, r3, r4)), float[].class, "com.obric.memorydata.plugin");
    }

    private final String c(final String r2, final Uri r3) {
        return (String) ZeusTransformUtils.preCheckCast(ao.f9372a.a(new $$Lambda$t$cXUNE5EX6qpgHNe6X9LU_H3nFwE(r3, r2)), String.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ List c() {
        return m;
    }

    private static final float[] c(String r2, Uri r3, boolean r4) {
        return (float[]) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.i.a(null, (Function2) ZeusTransformUtils.preCheckCast(new EntityIndexHelper$pictureToVectorByCLIP4Clip$1$1(r2, r3, r4, null), Function2.class, "com.obric.memorydata.plugin"), 1, null), float[].class, "com.obric.memorydata.plugin");
    }

    private static final String d(String r2, Uri r3) {
        return (String) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.i.a(null, (Function2) ZeusTransformUtils.preCheckCast(new EntityIndexHelper$pictureToCaption$1$1(r2, r3, null), Function2.class, "com.obric.memorydata.plugin"), 1, null), String.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ ConcurrentHashMap d() {
        return k;
    }

    public static final /* synthetic */ long e() {
        return j;
    }

    private static final List e(String r2, Uri r3) {
        return (List) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.i.a(null, (Function2) ZeusTransformUtils.preCheckCast(new EntityIndexHelper$pictureToTags$1$1(r2, r3, null), Function2.class, "com.obric.memorydata.plugin"), 1, null), List.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ AtomicBoolean f() {
        return l;
    }

    public static /* synthetic */ float[] lambda$1cO6eNA8Wi6Sy0QNuv6BTEo6BZk(Uri r0, String r1, boolean r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ String lambda$ImgoVO8PEay_edMwnw9Q0V3s_RQ(String r0, Uri r1) {
        return d(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$aw80a9tR1jDIw_Hw-3_tN4GKrJQ, reason: not valid java name */
    public static /* synthetic */ List m567lambda$aw80a9tR1jDIw_Hw3_tN4GKrJQ(String r0, Uri r1) {
        return e(r0, r1);
    }

    public static /* synthetic */ String lambda$cXUNE5EX6qpgHNe6X9LU_H3nFwE(Uri r0, String r1) {
        return a(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$holfh--iPuyxb7Cl9bU_avm5Hd0, reason: not valid java name */
    public static /* synthetic */ float[] m568lambda$holfhiPuyxb7Cl9bU_avm5Hd0(String r0, Uri r1, boolean r2) {
        return c(r0, r1, r2);
    }

    public final FullTextSearchSchema a() {
        return this.f;
    }

    public final String a(com.obric.memorydata.database.entity.d r9, String r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r9, "entity");
        Intrinsics.checkNotNullParameter(r10, Params.CONTENT);
        Intrinsics.checkNotNullParameter(r11, "column");
        TaskRequest.Builder r13 = (TaskRequest.Builder) ZeusTransformUtils.preCheckCast(new TaskRequest.Builder("time_extract").setTaskInfoCallback(a.b(f9438a)), TaskRequest.Builder.class, "com.obric.memorydata.plugin");
        JSONObject r0 = new JSONObject();
        r0.put("method", "extractContentTime");
        r0.put(IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, r10);
        r0.put("time_base", r9.getCreateTime());
        TaskResult r14 = ((TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(r13.setInputParam(r0), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin")).execute();
        if (r14.getCode() == 0) goto L6;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityIndexHelper", "insertContentTimeIndex failed, error code: " + r14.getCode() + ", error message: " + r14.getMsg(), null, 4, null);
        return null;
    L6:
        String r15 = r14.getOutput().optString("time_extract_result");
        GsonUtil r16 = GsonUtil.INSTANCE;
        Intrinsics.checkNotNull(r15);
        Object r17 = r16.getGSON().fromJson(r15, ExtractContentTimeResult.class);     // Catch: Exception -> L9
    L11:
        ExtractContentTimeResult r18 = (ExtractContentTimeResult) ZeusTransformUtils.preCheckCast(r17, ExtractContentTimeResult.class, "com.obric.memorydata.plugin");
        if (r18 != null) goto L14;
        return null;
    L14:
        List<ExtractTime> r19 = r18.getTimes();
        if (r19 == null) goto L27;
        Iterator r110 = ((Iterable) ZeusTransformUtils.preCheckCast(r19, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L18:
        if (r110.hasNext() == false) goto L27;
        com.obric.memorydata.database.entity.b r2 = r9.convertToContentTimeEntity(r11, (ExtractTime) ZeusTransformUtils.preCheckCast(r110.next(), ExtractTime.class, "com.obric.memorydata.plugin"));
        if (ZeusTransformUtils.instanceOf(r2, com.obric.memorydata.database.entity.b.class) == true) goto L23;
        r2 = null;
    L23:
        if (r2 == null) goto L18;
        IAppEntityContentTimeDao<C> r3 = this.d;
        if (r3 == null) goto L18;
        r3.insert((C) r2);
    L27:
        RunLog.INSTANCE.debug("EntityIndexHelper", "insertContentTimeIndex success id: " + r9.getEntityId() + " type: " + r9.getType());
        Map<String, ExtractTimeDescPair> r8 = r18.getTimeDescPair();
        if (r8 == null) goto L31;
        String r20 = com.obric.memorydata.utils.u.a(r8);
        if (r20 == null) goto L31;
        return r20;
    L31:
        return "";
    L9:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), GsonUtil.TAG, "json error ：" + e, null, 4, null);
        r17 = null;
        goto L11
    }

    public final String a(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "newValue");
        CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin");
        boolean r0 = false;
        if (r2 != null) goto L5;
    L8:
        boolean r5 = true;
    L9:
        if (r5 == false) goto L20;
        return r4;
    L20:
        new JSONArray(r3);     // Catch: JSONException -> L19
        r0 = true;
    L14:
        if (r0 == false) goto L16;
        JSONArray r6 = new JSONArray(r3);
    L17:
        String r7 = r6.put(r4).toString();
        Intrinsics.checkNotNull(r7);
        return r7;
    L16:
        r6 = new JSONArray();
        r6 = r6.put(r3);
        goto L17
    L5:
        if (r2.length() == 0) goto L8;
        r5 = false;
        goto L9
    }

    public final List<cd> a(com.obric.memorydata.database.entity.d r27, String r28, String r29) {
        Intrinsics.checkNotNullParameter(r27, "entity");
        Intrinsics.checkNotNullParameter(r28, "columnName");
        Intrinsics.checkNotNullParameter(r29, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        if (a(r29, r27) == false) goto L5;
        cd r1 = new cd(0, r27.getId(), r27.getType(), r27.getTimestamp(), r27.getCreateTime(), 0, 0, r28, "long_text", 0, 0, null, false, 0, 0, 32353, null);
    L7:
        return CollectionsKt.listOf(r1);
    L5:
        r1 = new cd(0, r27.getId(), r27.getType(), r27.getTimestamp(), r27.getCreateTime(), 0, 0, r28, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, 0, 0, null, false, 0, 0, 32353, null);
        goto L7
    }

    public final List<cd> a(com.obric.memorydata.database.entity.d r28, String r29, String r30, boolean r31) {
        Intrinsics.checkNotNullParameter(r28, "entity");
        Intrinsics.checkNotNullParameter(r29, "columnName");
        Intrinsics.checkNotNullParameter(r30, "fileString");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r30, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == true) goto L8;
        String r0 = f9438a.a(com.obric.memorydata.personalcontext.util.f.b(r30).getMimeType());     // Catch: JsonParseException -> L22
        if (Intrinsics.areEqual(r0, "image") == false) goto L16;
        return CollectionsKt.listOf(new cd(0, r28.getId(), r28.getType(), r28.getTimestamp(), r28.getCreateTime(), 0, 0, r29, "image_entity", 0, 0, null, false, 0, 0, 32353, null));
    L16:
        if (Intrinsics.areEqual(r0, "video") == false) goto L21;
        if (r31 == true) goto L21;
        return CollectionsKt.listOf(new cd(0, r28.getId(), r28.getType(), r28.getTimestamp(), r28.getCreateTime(), 0, 0, r29, "video_entity", 0, 0, null, false, 0, 0, 32353, null));
    L21:
        return CollectionsKt.emptyList();
    L23:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityIndexHelper", "generateFilePendingTask id: " + r28.getEntityId() + " parseFileEntityFromJson failed", null, 4, null);
        return CollectionsKt.emptyList();
    L8:
        return CollectionsKt.emptyList();
    L5:
        r1 = false;
        goto L6
    }

    public final void a(IAppEntityRawDbDao<W> r3, IAppEntityVectorCopilotDao<T> r4, IAppEntityVectorCopilotDao<T> r5, IAppEntityContentTimeDao<C> r6, boolean r7) {
        IAppEntityRawDbDao<W> r8 = (IAppEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r3, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin");
        IAppEntityVectorCopilotDao<T> r9 = (IAppEntityVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r4, IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin");
        IAppEntityVectorCopilotDao<T> r10 = (IAppEntityVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r5, IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin");
        IAppEntityContentTimeDao<C> r11 = (IAppEntityContentTimeDao) ZeusTransformUtils.wrapperContextForParams(r6, IAppEntityContentTimeDao.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "rawDao");
        this.e = r8;
        this.f9439b = r9;
        this.c = r10;
        this.d = r11;
        this.g = r7;
        if (r7 == false) goto L6;
        this.f = new FullTextSearchSchema(r8.getTableName(), com.obric.memorydata.database.a.a.a(), FullTextSearchSchema.TOKENIZER.O_TOKENIZER_2, false);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(com.obric.memorydata.database.entity.d r25, String r26, long r27) {
        Intrinsics.checkNotNullParameter(r25, "entity");
        Intrinsics.checkNotNullParameter(r26, "column");
        if (ZeusTransformUtils.instanceOf(r25, com.obric.memorydata.database.entity.j.class) == true) goto L6;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityIndexHelper", "generateCLIP4ClipFusionVector, entity is not AbstractVideoFrameEntity", null, 4, null);
        return;
    L6:
        IAppEntityRawDbDao<com.obric.memorydata.database.entity.d> r5 = s.a().getRawDaoByEntityType(((com.obric.memorydata.database.entity.j) ZeusTransformUtils.preCheckCast(r25, com.obric.memorydata.database.entity.j.class, "com.obric.memorydata.plugin")).getType());
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.obric.memorydata.database.dao.AbstractVideoFrameRawDbDao");
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(((AbstractVideoFrameRawDbDao) ZeusTransformUtils.preCheckCast(r5, AbstractVideoFrameRawDbDao.class, "com.obric.memorydata.plugin")).queryAbstractVideoFrameEntity(r27), Iterable.class, "com.obric.memorydata.plugin");
        Collection r7 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r8 = r6.iterator();
    L8:
        if (r8.hasNext() == false) goto L10;
        r7.add(Long.valueOf(((com.obric.memorydata.database.entity.j) ZeusTransformUtils.preCheckCast(r8.next(), com.obric.memorydata.database.entity.j.class, "com.obric.memorydata.plugin")).getId()));
        goto L8
    L10:
        List<Long> r9 = (List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.memorydata.plugin");
        if (r9.isEmpty() == false) goto L14;
        RunLog.INSTANCE.debug("EntityIndexHelper", "VideoFrame may be deleted");
        return;
    L14:
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin");
        Collection r11 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r12 = r10.iterator();
    L15:
        boolean r13 = true;
        if (r12.hasNext() == false) goto L23;
        Object r14 = r12.next();
        if (((Number) ZeusTransformUtils.preCheckCast(r14, Number.class, "com.obric.memorydata.plugin")).longValue() != ((com.obric.memorydata.database.entity.j) ZeusTransformUtils.preCheckCast(r25, com.obric.memorydata.database.entity.j.class, "com.obric.memorydata.plugin")).getId()) goto L21;
        r13 = false;
    L21:
        if (r13 == false) goto L15;
        r11.add(r14);
        goto L15
    L23:
        List<Long> r15 = (List) ZeusTransformUtils.preCheckCast(r11, List.class, "com.obric.memorydata.plugin");
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r15, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L29;
        long r16 = com.obric.memorydata.database.manager.c.f9561a.b(((com.obric.memorydata.database.entity.j) ZeusTransformUtils.preCheckCast(r25, com.obric.memorydata.database.entity.j.class, "com.obric.memorydata.plugin")).getType()).queryByRawDbIdListAndColumnContentSize(r15, "photoEntityDbId", ((com.obric.memorydata.database.entity.j) ZeusTransformUtils.preCheckCast(r25, com.obric.memorydata.database.entity.j.class, "com.obric.memorydata.plugin")).getType());
        RunLog.INSTANCE.debug("EntityIndexHelper", "generateCLIP4ClipFusionVector, pendingSize: " + r16);
        if (r16 <= 0) goto L29;
        RunLog.INSTANCE.debug("EntityIndexHelper", "generateCLIP4ClipFusionVector, pendingSize is not 0, pendingSize: " + r16);
        return;
    L29:
        IAppEntityVectorCopilotDao<com.obric.memorydata.database.entity.i> r17 = s.a().getImageVectorCopilotDao(((com.obric.memorydata.database.entity.j) ZeusTransformUtils.preCheckCast(r25, com.obric.memorydata.database.entity.j.class, "com.obric.memorydata.plugin")).getType());
        if (r17 != null) goto L33;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityIndexHelper", "generateCLIP4ClipFusionVector, imageVectorCopilotDao is null", null, 4, null);
        return;
    L33:
        List<T> r1 = r17.queryByRawDbIdListAndColumnContent(r9, r26);
        if (r1 == null) goto L40;
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin");
        Collection r18 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r3 = r2.iterator();
    L37:
        if (r3.hasNext() == false) goto L39;
        r18.add(Long.valueOf(((com.obric.memorydata.database.entity.i) ZeusTransformUtils.preCheckCast(r3.next(), com.obric.memorydata.database.entity.i.class, "com.obric.memorydata.plugin")).a()));
        goto L37
    L39:
        List r4 = (List) ZeusTransformUtils.preCheckCast(r18, List.class, "com.obric.memorydata.plugin");
    L41:
        Collection r19 = (Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.memorydata.plugin");
        if (r19 != null) goto L44;
    L47:
        boolean r110 = true;
    L48:
        if (r110 == false) goto L51;
        RunLog.INSTANCE.debug("EntityIndexHelper", "generateCLIP4ClipFusionVector, vectorKeyList is empty");
        return;
    L51:
        Ref.ObjectRef r20 = new Ref.ObjectRef();
        EmbeddingState r21 = PersonalContextAPI.INSTANCE.getEmbeddingState();
        Iterator r22 = ((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r111 = 0;
    L53:
        if (r22.hasNext() == false) goto L70;
        long r112 = ((Number) ZeusTransformUtils.preCheckCast(r22.next(), Number.class, "com.obric.memorydata.plugin")).longValue();
        if (r21 == EmbeddingState.USE_VLM) goto L53;
        float[] r23 = PersonalContextAPI.INSTANCE.queryVector(r17.getTableName(), String.valueOf(r112), false);
        if (r23 == null) goto L68;
        float[] r113 = (float[]) ZeusTransformUtils.preCheckCast(r20.element, float[].class, "com.obric.memorydata.plugin");
        T r24 = r23;
        if (r113 == null) goto L67;
        int r114 = Math.min(r113.length, r23.length);
        ArrayList r115 = new ArrayList(r114);
        int r116 = 0;
    L61:
        if (r116 >= r114) goto L63;
        r115.add(Float.valueOf(r113[r116] + r23[r116]));
        r116 = r116 + 1;
        goto L61
    L63:
        float[] r117 = CollectionsKt.toFloatArray((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r115, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin"));
        r24 = r23;
        if (r117 == null) goto L67;
        r24 = r117;
    L67:
        r20.element = r24;
        r111 = r111 + 1;
        goto L53
    L68:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityIndexHelper", "generateCLIP4ClipFusionVector, queryVector is null, id: " + r112, null, 4, null);
        goto L53
    L70:
        if (r111 != 0) goto L73;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityIndexHelper", "generateCLIP4ClipFusionVector, vectorCount(model) is 0", null, 4, null);
        return;
    L73:
        int r0 = ((com.obric.memorydata.database.entity.j) ZeusTransformUtils.preCheckCast(r25, com.obric.memorydata.database.entity.j.class, "com.obric.memorydata.plugin")).h();
        float[] r28 = (float[]) ZeusTransformUtils.preCheckCast(r20.element, float[].class, "com.obric.memorydata.plugin");
        if (r28 == null) goto L113;
        Collection r29 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(r28.length), Collection.class, "com.obric.memorydata.plugin");
        int r30 = r28.length;
        int r118 = 0;
    L76:
        if (r118 >= r30) goto L78;
        r29.add(Float.valueOf(r28[r118] / r111));
        r118 = r118 + 1;
        goto L76
    L78:
        float[] r119 = CollectionsKt.toFloatArray((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r29, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin"));
        if (r119 == null) goto L114;
        IAppEntityRawDbDao<com.obric.memorydata.database.entity.d> r31 = s.a().getRawDaoByEntityType(r0);
        if (r31 == null) goto L83;
        com.obric.memorydata.database.entity.d r32 = (com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast(r31.queryById(r27), com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin");
    L85:
        if (ZeusTransformUtils.instanceOf(r32, com.obric.memorydata.database.entity.g.class) == false) goto L87;
        com.obric.memorydata.database.entity.g r33 = (com.obric.memorydata.database.entity.g) ZeusTransformUtils.preCheckCast(r32, com.obric.memorydata.database.entity.g.class, "com.obric.memorydata.plugin");
    L88:
        if (r33 != null) goto L91;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityIndexHelper", "generateCLIP4ClipFusionVector, rawPhotoEntity is null, id: " + r27, null, 4, null);
        return;
    L91:
        com.obric.memorydata.database.entity.i r34 = r33.convertToImageVectorCopilotEntity("file");
        if (r34 == null) goto L115;
        IAppEntityVectorCopilotDao<com.obric.memorydata.database.entity.i> r35 = s.a().getImageVectorCopilotDao(r0);
        if (r35 == null) goto L116;
        long r36 = r35.insert(r34);
        if (r36 <= 0) goto L98;
        f9438a.a(r35.getTableName(), r36, r119, false);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityIndexHelper", "generateCLIP4ClipFusionVector, insertVectorData(model) success, id: " + r36, false, 4, null);
        return;
    L98:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityIndexHelper", "generateCLIP4ClipFusionVector, insertVectorData(model) failed, id: " + r36, null, 4, null);
        return;
    L116:
        return;
    L115:
        return;
    L87:
        r33 = null;
        goto L88
    L83:
        r32 = null;
        goto L85
    L114:
        return;
    L113:
        return;
    L44:
        if (r19.isEmpty() == true) goto L47;
        r110 = false;
        goto L48
    L40:
        r4 = null;
        goto L41
    }

    public final boolean a(long r7, Map<String, String> r9) {
        Map<String, String> r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "values");
        if (r10.isEmpty() == false) goto L6;
        return true;
    L6:
        FullTextSearchSchema r0 = this.f;
        if (r0 != null) goto L9;
        IRunLog r1 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r8 = new StringBuilder().append("deleteKeywordIndex schema is null id: ").append(r7).append(' ');
        IAppEntityRawDbDao<W> r6 = this.e;
        if (r6 == null) goto L13;
        String r11 = r6.getTableName();
    L14:
        IRunLog.a.b(r1, "EntityIndexHelper", r8.append(r11).toString(), null, 4, null);
        return false;
    L13:
        r11 = null;
        goto L14
    L9:
        return f9438a.a(r0, r7, r10);
    }

    public final boolean a(com.obric.memorydata.database.entity.d r15, String r16, long r17, long r19) {
        Intrinsics.checkNotNullParameter(r15, "entity");
        Intrinsics.checkNotNullParameter(r16, "column");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityIndexHelper", "embeddingVideoFrame id: " + r15.getEntityId() + " type: " + r15.getType() + " column: " + r16, false, 4, null);
        boolean r5 = true;
        if (ZeusTransformUtils.instanceOf(r15, com.obric.memorydata.database.entity.j.class) == true) goto L6;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityIndexHelper", "embeddingVideoFrame id: " + r15.getEntityId() + " type: " + r15.getType() + " not video frame", null, 4, null);
        return true;
    L6:
        String r1 = ((com.obric.memorydata.database.entity.j) ZeusTransformUtils.preCheckCast(r15, com.obric.memorydata.database.entity.j.class, "com.obric.memorydata.plugin")).g();
        CharSequence r4 = (CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L9;
    L12:
        if (r5 == false) goto L17;
        IRunLog r2 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r0 = new StringBuilder().append("embeddingVideoFrame id: ").append(((com.obric.memorydata.database.entity.j) ZeusTransformUtils.preCheckCast(r15, com.obric.memorydata.database.entity.j.class, "com.obric.memorydata.plugin")).getEntityId());
        String r3 = " fileEntityJson is null";
    L14:
        Object r6 = null;
        IRunLog r14 = r2;
        String r18 = "EntityIndexHelper";
        String r110 = r0.append(r3).toString();
        Throwable r111 = null;
        int r112 = 4;
    L15:
        IRunLog.a.b(r14, r18, r110, r111, r112, r6);
        return false;
    L17:
        long r8 = System.currentTimeMillis();
        FileEntity r7 = com.obric.memorydata.personalcontext.util.f.b(r1);
        if (Intrinsics.areEqual(f9438a.a(r7.getMimeType()), "video") == true) goto L20;
        IRunLog r9 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        String r10 = "embeddingVideoFrame id: " + ((com.obric.memorydata.database.entity.j) ZeusTransformUtils.preCheckCast(r15, com.obric.memorydata.database.entity.j.class, "com.obric.memorydata.plugin")).getEntityId() + " mimeType: " + r7.getMimeType() + " not supported";
        r6 = null;
        r14 = r9;
        r18 = "EntityIndexHelper";
        r110 = r10;
        r111 = null;
        r112 = 4;
        goto L15
    L20:
        Uri r11 = EntityVideoExtractHelper.INSTANCE.extractFrame(((com.obric.memorydata.database.entity.j) ZeusTransformUtils.preCheckCast(r15, com.obric.memorydata.database.entity.j.class, "com.obric.memorydata.plugin")).getPackageName(), r7.getContentUrl(), r19);
        if (r11 != null) goto L30;
        r2 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r0 = new StringBuilder().append("embeddingVideoFrame id: ").append(((com.obric.memorydata.database.entity.j) ZeusTransformUtils.preCheckCast(r15, com.obric.memorydata.database.entity.j.class, "com.obric.memorydata.plugin")).getEntityId());
        r3 = " pic is null";
        goto L14
    L30:
        boolean r12 = a(r15, r16, r11, false, true);     // Catch: Throwable -> L27
        EntityVideoExtractHelper.INSTANCE.deleteTempPicPath(r11);
        com.obric.memorydata.database.util.b.f9624a.a("video_frame_embedding_perf_event", String.valueOf(((com.obric.memorydata.database.entity.j) ZeusTransformUtils.preCheckCast(r15, com.obric.memorydata.database.entity.j.class, "com.obric.memorydata.plugin")).getType()), "videoFrameEmbeddingIndexCost", System.currentTimeMillis() - r8);
        return r12;
    L27:
        th = move-exception;
        EntityVideoExtractHelper.INSTANCE.deleteTempPicPath(r11);
        throw th;
    L9:
        if (r4.length() == 0) goto L12;
        r5 = false;
        goto L12
    }

    public final boolean a(com.obric.memorydata.database.entity.d r20, String r21, String r22, String r23, Function1<? super String, Unit> r24) {
        Function1<? super String, Unit> r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r24, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r20, "entity");
        Intrinsics.checkNotNullParameter(r21, "column");
        Intrinsics.checkNotNullParameter(r23, "keywordColumn");
        Intrinsics.checkNotNullParameter(r6, "fillOcr");
        long r9 = System.currentTimeMillis();
        if (ZeusTransformUtils.instanceOf(r20, com.obric.memorydata.database.entity.j.class) == false) goto L8;
        if (a((com.obric.memorydata.database.entity.j) ZeusTransformUtils.preCheckCast(r20, com.obric.memorydata.database.entity.j.class, "com.obric.memorydata.plugin"), r21, r6) == true) goto L21;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityIndexHelper", "embeddingOcr failed id: " + ((com.obric.memorydata.database.entity.j) ZeusTransformUtils.preCheckCast(r20, com.obric.memorydata.database.entity.j.class, "com.obric.memorydata.plugin")).getEntityId() + " type: " + ((com.obric.memorydata.database.entity.j) ZeusTransformUtils.preCheckCast(r20, com.obric.memorydata.database.entity.j.class, "com.obric.memorydata.plugin")).getType(), null, 4, null);
    L21:
        com.obric.memorydata.database.util.b.f9624a.a("ocr_perf_event", String.valueOf(r20.getType()), "ocrIndexCost", System.currentTimeMillis() - r9);
        return true;
    L8:
        if (r22 != null) goto L11;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityIndexHelper", "embeddingOcr failed, json is null, id: " + r20.getEntityId() + " type: " + r20.getType(), null, 4, null);
        return true;
    L11:
        FileEntity r0 = com.obric.memorydata.personalcontext.util.f.c(r22);
        if (r0 != null) goto L15;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityIndexHelper", "embeddingPhotoOcr failed id: " + r20.getEntityId() + " type: " + r20.getType(), null, 4, null);
        Ensure.ensureNotReachHere("embeddingPhotoOcr failed id: " + r20.getEntityId() + " type: " + r20.getType());
        return true;
    L15:
        a r3 = f9438a;
        if (Intrinsics.areEqual(r3.a(r0.getMimeType()), "image") == false) goto L24;
        if (a(r20, r21, r0.getContentUrl(), r23, false, r6) == true) goto L21;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityIndexHelper", "embeddingPhotoOcr failed id: " + r20.getEntityId() + " type: " + r20.getType(), null, 4, null);
        return false;
    L24:
        if (Intrinsics.areEqual(r3.a(r0.getMimeType()), "video") == false) goto L27;
        RunLog.INSTANCE.debug("EntityIndexHelper", "not support video ocr embedding");
        return true;
    L27:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityIndexHelper", "embeddingOcr failed, mimeType: " + r0.getMimeType() + ", id: " + r20.getEntityId() + " type: " + r20.getType(), null, 4, null);
        Ensure.ensureNotReachHere("embeddingOcr failed, mimeType: " + r0.getMimeType() + ", id: " + r20.getEntityId() + " type: " + r20.getType());
        return true;
    }

    public final boolean a(com.obric.memorydata.database.entity.d r17, String r18, Function1<? super List<String>, Unit> r19) {
        Function1<? super List<String>, Unit> r2 = (Function1) ZeusTransformUtils.wrapperContextForParams(r19, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r17, "entity");
        Intrinsics.checkNotNullParameter(r2, "fillTags");
        long r4 = System.currentTimeMillis();
        if (ZeusTransformUtils.instanceOf(r17, com.obric.memorydata.database.entity.j.class) == true) goto L5;
        if (r18 != null) goto L9;
        return true;
    L9:
        FileEntity r6 = com.obric.memorydata.personalcontext.util.f.b(r18);
        String r9 = f9438a.a(r6.getMimeType());
        if (Intrinsics.areEqual(r9, "image") == false) goto L18;
        if (a(r17, r6.getContentUrl(), false, r2) == true) goto L15;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityIndexHelper", "embeddingPhotoCaption failed id: " + r17.getEntityId() + " type: " + r17.getType(), null, 4, null);
        return false;
    L15:
        com.obric.memorydata.database.util.b.f9624a.a("caption_index_perf_event", String.valueOf(r17.getType()), "captionIndexCost", System.currentTimeMillis() - r4);
        return true;
    L18:
        if (Intrinsics.areEqual(r9, "video") == false) goto L21;
        RunLog.INSTANCE.debug("EntityIndexHelper", "not support video tag build");
        return true;
    L21:
        Ensure.ensureNotReachHere("buildPhotoTag, but entity is not image or video");
        if (AppContext.INSTANCE.isLocalTest() == true) goto L25;
        return true;
    L25:
        throw new IllegalArgumentException("buildPhotoTag, but entity is not image or video");
    L5:
        if (a((com.obric.memorydata.database.entity.j) ZeusTransformUtils.preCheckCast(r17, com.obric.memorydata.database.entity.j.class, "com.obric.memorydata.plugin"), r2) == true) goto L15;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityIndexHelper", "buildVideoFrameTag failed id: " + ((com.obric.memorydata.database.entity.j) ZeusTransformUtils.preCheckCast(r17, com.obric.memorydata.database.entity.j.class, "com.obric.memorydata.plugin")).getEntityId() + " type: " + ((com.obric.memorydata.database.entity.j) ZeusTransformUtils.preCheckCast(r17, com.obric.memorydata.database.entity.j.class, "com.obric.memorydata.plugin")).getType(), null, 4, null);
        goto L15
    }

    public final boolean a(com.obric.memorydata.database.entity.e r12, String r13, boolean r14, int r15, String r16, String[] r17) {
        Intrinsics.checkNotNullParameter(r12, "entity");
        Intrinsics.checkNotNullParameter(r13, "fileString");
        Intrinsics.checkNotNullParameter(r16, "fileExtension");
        Intrinsics.checkNotNullParameter(r17, "ignoreExtensionList");
        return ((Boolean) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.i.a((CoroutineContext) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new EntityIndexHelper$processFileIndex$1(r14, r13, r12, r16, r17, r15, null), Function2.class, "com.obric.memorydata.plugin")), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }

    public final boolean a(hb r2, Function1<? super gq, Boolean> r3) {
        Function1 r1 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "entity");
        Intrinsics.checkNotNullParameter(r1, "fillLocation");
        as r4 = at.f9383a.a(r2);
        if (r4.a() == true) goto L7;
        return false;
    L7:
        if (r4.b() != null) goto L9;
        return true;
    L9:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r1.invoke(r4.b()), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }

    public final boolean a(String r4, com.obric.memorydata.database.entity.d r5) {
        Intrinsics.checkNotNullParameter(r4, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        Intrinsics.checkNotNullParameter(r5, "entity");
        if (r5.getType() == (-303)) goto L15;
        if (r5.getType() == (-306)) goto L15;
        if (r5.getType() == 502) goto L15;
        if (r4.length() <= 240) goto L13;
        return true;
    L13:
        return false;
    L15:
        if (r4.length() <= 1500) goto L18;
        return true;
    L18:
        return false;
    }

    public final boolean b() {
        return this.g;
    }

    public final boolean b(long r10, Map<String, String> r12) {
        Map<String, String> r13 = (Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r13, "values");
        if (r13.isEmpty() == false) goto L6;
        return true;
    L6:
        FullTextSearchSchema r0 = this.f;
        String r2 = null;
        if (r0 == null) goto L13;
        boolean r14 = com.obric.memorydata.database.util.d.insert(r0, CollectionsKt.listOf(new CommonTextSearchDocument(r10, r0.a(), f9438a.a(r13))));
        RunLog r1 = RunLog.INSTANCE;
        StringBuilder r3 = new StringBuilder().append("insertKeywordIndex result ").append(r14).append(", ");
        IAppEntityRawDbDao<W> r9 = this.e;
        if (r9 == null) goto L11;
        r2 = r9.getTableName();
    L11:
        r1.debug("EntityIndexHelper", r3.append(r2).append(" id: ").append(r10).toString());
        return r14;
    L13:
        IRunLog r4 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r11 = new StringBuilder().append("insertKeywordIndex schema is null id: ").append(r10).append(' ');
        IAppEntityRawDbDao<W> r15 = this.e;
        if (r15 == null) goto L16;
        r2 = r15.getTableName();
    L16:
        IRunLog.a.b(r4, "EntityIndexHelper", r11.append(r2).toString(), null, 4, null);
        return false;
    }

    public final boolean b(com.obric.memorydata.database.entity.d r23, String r24, String r25, String r26) {
        com.obric.memorydata.database.entity.d r1 = r23;
        String r2 = r24;
        Intrinsics.checkNotNullParameter(r1, "entity");
        Intrinsics.checkNotNullParameter(r2, "column");
        Intrinsics.checkNotNullParameter(r25, EventBody.KEY_VALUE);
        RunLog.INSTANCE.debug("EntityIndexHelper", "embeddingText id: " + r23.getEntityId() + " type: " + r23.getType() + " column: " + r2);
        long r11 = System.currentTimeMillis();
        if (r26 != null) goto L5;
    L8:
        List r3 = a.a(f9438a, r25, 0, 2, null);
    L9:
        EmbeddingState r4 = PersonalContextAPI.INSTANCE.getEmbeddingState();
        Iterator r5 = r3.iterator();
        boolean r6 = true;
    L11:
        if (r5.hasNext() == false) goto L48;
        String r7 = (String) ZeusTransformUtils.preCheckCast(r5.next(), String.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.database.entity.i r8 = r1.convertToTextVectorCopilotEntity(r2, r7);
        if (ZeusTransformUtils.instanceOf(r8, com.obric.memorydata.database.entity.i.class) == true) goto L16;
        r8 = null;
    L16:
        if (r8 == null) goto L46;
        IAppEntityVectorCopilotDao<T> r15 = this.f9439b;
        if (r15 == null) goto L42;
        long r9 = r15.insert((T) r8);
        RunLog.INSTANCE.debug("EntityIndexHelper", "entityVectorCopilotDao insert " + r9);
        int r10 = b.f9443a[r4.ordinal()];
        if (r10 != 1) goto L22;
        a r12 = f9438a;
        float[] r20 = r12.a(r7, true, true);
        if (r20 == null) goto L40;
        boolean r13 = r12.a(r15.getTableName(), r9, r20, true);
    L41:
        r6 = r13;
    L40:
        r13 = false;
        goto L41
    L22:
        if (r10 == 2) goto L34;
        a r14 = f9438a;
        float[] r21 = r14.a(r7, true, true);
        if (r21 == null) goto L26;
        boolean r16 = r14.a(r15.getTableName(), r9, r21, true);
        boolean r17 = false;
    L27:
        float[] r22 = r14.a(r7, true, r17);
        if (r22 == null) goto L30;
        boolean r18 = r14.a(r15.getTableName(), r9, r22, false);
    L31:
        if (r18 == false) goto L40;
        if (r16 == false) goto L40;
        r13 = true;
        goto L41
    L30:
        r18 = false;
        goto L31
    L26:
        r17 = false;
        r16 = false;
        goto L27
    L34:
        a r19 = f9438a;
        float[] r27 = r19.a(r7, true, false);
        if (r27 == null) goto L40;
        r13 = r19.a(r15.getTableName(), r9, r27, false);
    L42:
        if (r6 == false) goto L43;
        r1 = r23;
        r2 = r24;
        goto L11
    L43:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityIndexHelper", "embeddingLongText failed id: " + r23.getEntityId() + " type: " + r23.getType(), null, 4, null);
        return false;
    L46:
        t r0 = (t) ZeusTransformUtils.preCheckCast(this, t.class, "com.obric.memorydata.plugin");
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityIndexHelper", "embeddingLongText convert entity failed id: " + r23.getEntityId() + " type: " + r23.getType(), null, 4, null);
        return false;
    L48:
        RunLog.INSTANCE.debug("EntityIndexHelper", "embeddingLongText success id: " + r23.getEntityId() + " type: " + r23.getType());
        com.obric.memorydata.database.util.b.f9624a.a("text_embedding_perf_event", String.valueOf(r23.getType()), "textEmbeddingIndexCost", System.currentTimeMillis() - r11);
        return true;
    L5:
        if (Intrinsics.areEqual(r26, ChunkType.DEFAULT.toString()) == true) goto L8;
        r3 = a.a(f9438a, r25, 0, r26, 2, null);
        goto L9
    }

    public final boolean b(com.obric.memorydata.database.entity.d r14, String r15, String r16, String r17, Function1<? super String, Unit> r18) {
        Function1<? super String, Unit> r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r18, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r14, "entity");
        Intrinsics.checkNotNullParameter(r15, "column");
        Intrinsics.checkNotNullParameter(r17, "keywordColumn");
        Intrinsics.checkNotNullParameter(r6, "fillCaption");
        long r9 = System.currentTimeMillis();
        if (ZeusTransformUtils.instanceOf(r14, com.obric.memorydata.database.entity.j.class) == false) goto L8;
        if (b((com.obric.memorydata.database.entity.j) ZeusTransformUtils.preCheckCast(r14, com.obric.memorydata.database.entity.j.class, "com.obric.memorydata.plugin"), r15, r6) == true) goto L16;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityIndexHelper", "embeddingVideoFrameCaption failed id: " + ((com.obric.memorydata.database.entity.j) ZeusTransformUtils.preCheckCast(r14, com.obric.memorydata.database.entity.j.class, "com.obric.memorydata.plugin")).getEntityId() + " type: " + ((com.obric.memorydata.database.entity.j) ZeusTransformUtils.preCheckCast(r14, com.obric.memorydata.database.entity.j.class, "com.obric.memorydata.plugin")).getType(), null, 4, null);
    L16:
        com.obric.memorydata.database.util.b.f9624a.a("caption_index_perf_event", String.valueOf(r14.getType()), "captionIndexCost", System.currentTimeMillis() - r9);
        return true;
    L8:
        if (r16 != null) goto L10;
        return true;
    L10:
        FileEntity r0 = com.obric.memorydata.personalcontext.util.f.b(r16);
        String r3 = f9438a.a(r0.getMimeType());
        if (Intrinsics.areEqual(r3, "image") == false) goto L19;
        if (b(r14, r15, r0.getContentUrl(), r17, false, r6) == true) goto L16;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityIndexHelper", "embeddingPhotoCaption failed id: " + r14.getEntityId() + " type: " + r14.getType(), null, 4, null);
        return false;
    L19:
        if (Intrinsics.areEqual(r3, "video") == false) goto L22;
        RunLog.INSTANCE.debug("EntityIndexHelper", "not support video caption embedding");
        return true;
    L22:
        Ensure.ensureNotReachHere("embeddingVideoFileCaption, but entity is not AbstractVideoFrameEntity");
        if (AppContext.INSTANCE.isLocalTest() == true) goto L26;
        return true;
    L26:
        throw new RuntimeException("embeddingVideoFileCaption, but entity is not AbstractVideoFrameEntity");
    }

    public final boolean b(com.obric.memorydata.database.entity.d r18, String r19, String r20, boolean r21) {
        Intrinsics.checkNotNullParameter(r18, "entity");
        Intrinsics.checkNotNullParameter(r19, "column");
        Intrinsics.checkNotNullParameter(r20, "fileEntityJson");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityIndexHelper", "embeddingFileEntity id: " + r18.getEntityId() + " type: " + r18.getType() + " column: " + r19, false, 4, null);
        FileEntity r1 = com.obric.memorydata.personalcontext.util.f.b(r20);
        String r2 = f9438a.a(r1.getMimeType());
        int r3 = r2.hashCode();
        if (r3 != 3556653) goto L5;
        String r13 = " column: ";
        String r11 = " type: ";
        if (r2.equals(IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT) == true) goto L23;
    L22:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityIndexHelper", "mimeType: " + r1.getMimeType() + " not supported", null, 4, null);
        boolean r0 = false;
    L24:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityIndexHelper", "embeddingFileEntity result: " + r0 + " id: " + r18.getEntityId() + r11 + r18.getType() + r13 + r19, false, 4, null);
        return r0;
    L23:
        r0 = a(this, r18, r19, a(r1.getContentUrl()), null, 8, null);
        goto L24
    L5:
        if (r3 == 100313435) goto L17;
        if (r3 == 112202875) goto L10;
    L8:
        r13 = " column: ";
        r11 = " type: ";
        goto L22
    L10:
        if (r2.equals("video") == false) goto L8;
        if (r21 == false) goto L14;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityIndexHelper", "embeddingFileEntity ignore video file entity, id: " + r18.getEntityId() + " type: " + r18.getType(), false, 4, null);
        r0 = true;
    L15:
        r13 = " column: ";
        r11 = " type: ";
        goto L24
    L14:
        r0 = a(r18, r19, r1.getContentUrl());
        goto L15
    L17:
        if (r2.equals("image") == false) goto L8;
        r13 = " column: ";
        r11 = " type: ";
        r0 = a(this, r18, r19, r1.getContentUrl(), false, false, 24, null);
        goto L24
    }

    public final boolean c(com.obric.memorydata.database.entity.d r2, String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "entity");
        Intrinsics.checkNotNullParameter(r3, "column");
        RunLog.INSTANCE.debug("EntityIndexHelper", "embeddingFullContent id: " + r2.getEntityId() + " type: " + r2.getType() + " column: " + r3 + ", lang=" + com.obric.memorydata.utils.ac.f13156a.a());
        TaskRequest.Builder r6 = new TaskRequest.Builder(this.h);
        JSONObject r1 = new JSONObject();
        r1.put("rawDbId", r2.getId());
        r1.put("entityType", r2.getType());
        if (r2.getType() != (-303)) goto L5;
        r1.put("memoryType", ((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r2, RawMemoryEntity.class, "com.obric.memorydata.plugin")).getMemoryType());
    L5:
        r1.put("lang", com.obric.memorydata.utils.ac.f13156a.a());
        if (((TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(r6.setInputParam(r1), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setTaskInfoCallback(a.b(f9438a)), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin")).execute().getCode() != 0) goto L8;
        return true;
    L8:
        return false;
    }

    public final boolean d(com.obric.memorydata.database.entity.d r2, String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "entity");
        Intrinsics.checkNotNullParameter(r3, "column");
        RunLog.INSTANCE.debug("EntityIndexHelper", "embeddingFullContentForMigration type=" + r2.getType() + " column=" + r3 + ", lang=" + com.obric.memorydata.utils.ac.f13156a.a());
        TaskRequest.Builder r6 = new TaskRequest.Builder(this.h);
        JSONObject r1 = new JSONObject();
        r1.put("rawDbId", r2.getId());
        r1.put("entityType", r2.getType());
        if (r2.getType() != (-303)) goto L5;
        r1.put("memoryType", ((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r2, RawMemoryEntity.class, "com.obric.memorydata.plugin")).getMemoryType());
    L5:
        r1.put("lang", com.obric.memorydata.utils.ac.f13156a.a());
        if (((TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(r6.setInputParam(r1), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin")).execute().getCode() != 0) goto L8;
        return true;
    L8:
        return false;
    }
}
