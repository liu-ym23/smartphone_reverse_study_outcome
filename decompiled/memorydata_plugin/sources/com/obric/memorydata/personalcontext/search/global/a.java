package com.obric.memorydata.personalcontext.search.global;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import androidx.media.MediaBrowserServiceCompat;
import com.bytedance.apm6.consumer.slardar.Constants;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.capabilitykit.entity.app.PhotoEntity;
import com.obric.capabilitykit.entity.app.ProactiveMemoryEntity;
import com.obric.capabilitykit.entity.app.VideoFrame;
import com.obric.capabilitykit.entity.enums.AssetTypeEnum;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.obric.capabilitykit.entity.search.InAppSearchEntityParam;
import com.obric.capabilitykit.entity.search.InAppSearchRequest;
import com.obric.capabilitykit.entity.search.SearchScoreParam;
import com.obric.memorydata.BuildConfig;
import com.obric.memorydata.constants.AppInfo;
import com.obric.memorydata.database.dao.IAppEntityRawDbDao;
import com.obric.memorydata.database.entity.ChatMessage;
import com.obric.memorydata.database.entity.EpisodicMemoryEntity;
import com.obric.memorydata.database.entity.ct;
import com.obric.memorydata.database.index.EntityIndexEngine;
import com.obric.memorydata.database.index.s;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.database.model.EntitySearchRecordInfo;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.obric.memorydata.middleware.impl.image.ImageUploadEntity;
import com.obric.memorydata.middleware.impl.image.ImageXBizType;
import com.obric.memorydata.model.BaseResponse;
import com.obric.memorydata.personalcontext.index.EntityVideoExtractHelper;
import com.obric.memorydata.personalcontext.log.EvaluationResult;
import com.obric.memorydata.personalcontext.q;
import com.obric.memorydata.personalcontext.search.entity.SearchResultEntry;
import com.obric.memorydata.personalcontext.search.entity.SearchType;
import com.obric.memorydata.personalcontext.search.kg.KGPOEntity;
import com.obric.memorydata.personalcontext.search.kg.KGSourceEntity;
import com.obric.memorydata.personalcontext.search.kg.KGSourceIndex;
import com.obric.memorydata.personalcontext.search.kg.KnowledgeGraphResponse;
import com.obric.memorydata.personalcontext.util.EmbeddingState;
import com.obric.memorydata.sdk.entity.global.GlobalAssistantSearchDomainResult;
import com.obric.memorydata.sdk.entity.global.GlobalAssistantSearchEntityResult;
import com.obric.memorydata.sdk.entity.global.GlobalAssistantSearchKgResult;
import com.obric.memorydata.sdk.entity.global.GlobalAssistantSearchMemoryResult;
import com.obric.memorydata.sdk.entity.global.GlobalAssistantSearchResponse;
import com.obric.memorydata.sdk.entity.global.GlobalSearchDomain;
import com.obric.memorydata.sdk.entity.global.ProactiveRecommendationSearchResult;
import com.obric.memorydata.sdk.entity.search.AssistantQuResult;
import com.obric.memorydata.sdk.entity.search.BertQUAction;
import com.obric.memorydata.sdk.entity.search.GlobalQUResult;
import com.obric.memorydata.sdk.entity.search.QuAction;
import com.obric.memorydata.sdk.entity.search.RewriteQuery;
import com.obric.memorydata.task.AbsTaskRequest;
import com.obric.memorydata.task.impl.TaskInfo;
import com.obric.memorydata.task.impl.TaskRequest;
import com.obric.memorydata.task.scheduler.impl.ExistingTaskPolicy;
import com.obric.memorydata.utils.GsonUtil;
import com.obric.memorydata.utils.ab;
import com.obric.memorydata.utils.threadpool.ThreadPoolContainer;
import com.obric.memorydata.utils.u;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ba;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000ä\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0016\b&\u0018\u0000 \u0094\u00012\u00020\u0001:\u0002\u0094\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010B\u001a\u00020)H¤@¢\u0006\u0002\u0010CJ\u0010\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020\u001dH\u0002J\u000e\u0010G\u001a\u00020+H\u0086@¢\u0006\u0002\u0010CJ\u000e\u0010H\u001a\u00020+H\u0086@¢\u0006\u0002\u0010CJ\u0016\u0010I\u001a\b\u0012\u0004\u0012\u00020'0&2\u0006\u0010(\u001a\u00020)H\u0002J\u000e\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00070KH\u0016J\b\u0010L\u001a\u00020MH\u0016JJ\u0010N\u001a\u0004\u0018\u00010O2\u0006\u0010P\u001a\u00020'2\u0006\u0010Q\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\b\u0010R\u001a\u0004\u0018\u00010\u00072\u001c\b\u0002\u0010S\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010U0TH\u0002J\b\u0010V\u001a\u00020:H\u0016JJ\u0010W\u001a\u0004\u0018\u00010O2\u0006\u0010P\u001a\u00020'2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\b\u0010R\u001a\u0004\u0018\u00010\u00072\u001c\b\u0002\u0010S\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010U0TH\u0002J\b\u0010X\u001a\u00020\u0007H\u0002J \u0010Y\u001a\u00020U2\u0006\u0010P\u001a\u00020'2\u0006\u0010Z\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010[\u001a\u00020E2\u0006\u0010\\\u001a\u00020]2\u0006\u0010Z\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0002J\b\u0010^\u001a\u00020:H\u0002J\u0010\u0010_\u001a\u00020E2\u0006\u0010`\u001a\u00020\u0007H\u0002J\u0010\u0010a\u001a\u00020U2\u0006\u0010Z\u001a\u00020\u0003H\u0002J\b\u0010b\u001a\u00020+H\u0002JV\u0010c\u001a&\u0012\n\u0012\b\u0012\u0004\u0012\u00020.0&\u0012\n\u0012\b\u0012\u0004\u0012\u00020.0&\u0012\n\u0012\b\u0012\u0004\u0012\u00020.0&0d2\f\u0010e\u001a\b\u0012\u0004\u0012\u00020.0&2\f\u0010f\u001a\b\u0012\u0004\u0012\u00020.0&2\f\u0010g\u001a\b\u0012\u0004\u0012\u00020.0&H\u0002J\u001c\u0010h\u001a\b\u0012\u0004\u0012\u00020i0&2\f\u0010j\u001a\b\u0012\u0004\u0012\u00020.0&H\u0004J\u0018\u0010k\u001a\u00020:2\u0006\u0010l\u001a\u00020m2\u0006\u0010n\u001a\u00020.H\u0002J8\u0010o\u001a\u00020E2\u0006\u0010\u0006\u001a\u00020\u00072\u0018\u0010p\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020m0q0&2\f\u0010f\u001a\b\u0012\u0004\u0012\u00020r0&H\u0002J0\u0010s\u001a\b\u0012\u0004\u0012\u00020t0\u000f2\u0018\u0010p\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020m0q0&2\u0006\u0010u\u001a\u00020MH\u0002J$\u0010v\u001a\b\u0012\u0004\u0012\u00020t0&2\f\u0010f\u001a\b\u0012\u0004\u0012\u00020r0&2\u0006\u0010u\u001a\u00020MH\u0002J$\u0010w\u001a\u00020E2\f\u0010x\u001a\b\u0012\u0004\u0012\u00020.0&2\f\u0010y\u001a\b\u0012\u0004\u0012\u00020.0&H\u0002J\u001c\u0010z\u001a\b\u0012\u0004\u0012\u00020m0&2\f\u0010{\u001a\b\u0012\u0004\u0012\u0002050&H\u0002J&\u0010|\u001a\u00020E2\f\u0010}\u001a\b\u0012\u0004\u0012\u00020m0\u000f2\u000e\u0010~\u001a\n\u0012\u0004\u0012\u00020\u007f\u0018\u00010&H\u0002J\u001c\u0010\u0080\u0001\u001a\b\u0012\u0004\u0012\u00020.0\u000f2\r\u0010\u0081\u0001\u001a\b\u0012\u0004\u0012\u00020.0&J\u001c\u0010\u0082\u0001\u001a\b\u0012\u0004\u0012\u00020.0\u000f2\r\u0010\u0081\u0001\u001a\b\u0012\u0004\u0012\u00020.0&J$\u0010\u0083\u0001\u001a\u00020E2\u0007\u0010\u0084\u0001\u001a\u00020M2\u0007\u0010\u0085\u0001\u001a\u00020\u00072\u0007\u0010\u0086\u0001\u001a\u00020\u0007H\u0002J\u001f\u0010\u0087\u0001\u001a\u00020E2\u0006\u0010Z\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\\\u001a\u00020]J\u0012\u0010\u0088\u0001\u001a\u00020E2\u0007\u0010\u0089\u0001\u001a\u00020\u0003H\u0002J\u0018\u0010\u008a\u0001\u001a\u00020E2\r\u0010\u008b\u0001\u001a\b\u0012\u0004\u0012\u00020'0&H\u0002J\u001e\u0010\u008c\u0001\u001a\b\u0012\u0004\u0012\u00020'0&2\r\u0010\u008d\u0001\u001a\b\u0012\u0004\u0012\u00020'0&H\u0002J \u0010\u008e\u0001\u001a\u00020E2\u0006\u0010Q\u001a\u00020\u00072\r\u0010\u008f\u0001\u001a\b\u0012\u0004\u0012\u00020.0&H\u0002J\u001e\u0010\u0090\u0001\u001a\b\u0012\u0004\u0012\u00020'0&2\r\u0010\u0091\u0001\u001a\b\u0012\u0004\u0012\u00020'0&H\u0002J<\u0010\u0092\u0001\u001a\b\u0012\u0004\u0012\u00020.0&2\f\u0010f\u001a\b\u0012\u0004\u0012\u00020.0&2\f\u0010e\u001a\b\u0012\u0004\u0012\u00020.0&2\u000f\b\u0002\u0010\u0093\u0001\u001a\b\u0012\u0004\u0012\u00020M0KH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001dX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020\u001dX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010!R\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010,\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020.0\u000f0-X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010/\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020.0\u000f0-X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00100\u001a\b\u0012\u0004\u0012\u00020.0&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00101\u001a\b\u0012\u0004\u0012\u00020.0&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00102\u001a\b\u0012\u0004\u0012\u0002030\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00104\u001a\b\u0012\u0004\u0012\u0002050\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00106\u001a\b\u0012\u0004\u0012\u0002070\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00108\u001a\b\u0012\u0004\u0012\u0002070\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020:X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010;\u001a\u0004\u0018\u00010<X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010=\u001a\u0004\u0018\u00010\u0007X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010A¨\u0006\u0095\u0001"}, d2 = {"Lcom/obric/memorydata/personalcontext/search/global/AbstractGlobalAssistantSearchSession;", "", "startTime", "", "bundle", "Landroid/os/Bundle;", "queryId", "", "userQuery", "entitySearchRecordInfo", "Lcom/obric/memorydata/database/model/EntitySearchRecordInfo;", "inputType", "<init>", "(JLandroid/os/Bundle;Ljava/lang/String;Ljava/lang/String;Lcom/obric/memorydata/database/model/EntitySearchRecordInfo;Ljava/lang/String;)V", "kgRelationSpoList", "", "getKgRelationSpoList", "()Ljava/util/List;", "kgRelationObjectList", "getKgRelationObjectList", "kgNameList", "getKgNameList", "quResultStringBuilder", "Ljava/lang/StringBuffer;", "getQuResultStringBuilder", "()Ljava/lang/StringBuffer;", "setQuResultStringBuilder", "(Ljava/lang/StringBuffer;)V", "searchCountDownLatch", "Ljava/util/concurrent/CountDownLatch;", "getSearchCountDownLatch", "()Ljava/util/concurrent/CountDownLatch;", "setSearchCountDownLatch", "(Ljava/util/concurrent/CountDownLatch;)V", "quAndKgCountDownLatch", "getQuAndKgCountDownLatch", "setQuAndKgCountDownLatch", "filterQueryRewrite", "", "Lcom/obric/memorydata/sdk/entity/search/RewriteQuery;", "quResult", "Lcom/obric/memorydata/sdk/entity/search/GlobalQUResult;", ChatMessage.TYPE_RESPONSE, "Lcom/obric/memorydata/sdk/entity/global/GlobalAssistantSearchResponse;", "noneSemanticAllResultEntries", "", "Lcom/obric/memorydata/personalcontext/search/entity/SearchResultEntry;", "semanticAllResultEntries", "memorySearchResultEntry", "proactiveRecommendationSearchResultEntry", "domainList", "Lcom/obric/memorydata/sdk/entity/global/GlobalSearchDomain;", "kgSourceIndexList", "Lcom/obric/memorydata/personalcontext/search/kg/KGSourceIndex;", "taskExecuteCostList", "", "kgTaskExecuteCostList", "kgSwitchOn", "", "kgResponse", "Lcom/obric/memorydata/personalcontext/search/kg/KnowledgeGraphResponse;", "scheduleTimeDescriptionMapJson", "getScheduleTimeDescriptionMapJson", "()Ljava/lang/String;", "setScheduleTimeDescriptionMapJson", "(Ljava/lang/String;)V", "getQuUnderStandingResult", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "executeQueryUnderStanding", "", "countDownLatch", "executeSearchWithoutHandleResults", "executeSearch", "buildFinalQueryRewrites", "getSwitchStatusOffDomains", "", "getSpecificLimitCount", "", "createDomainSearchTask", "Lcom/obric/memorydata/task/AbsTaskRequest;", "rewriteQuery", "taskName", "slotResult", "callBack", "Lkotlin/Function2;", "Lcom/obric/memorydata/task/scheduler/OnTaskInfoCallBack;", "useInputRawQuery", "createMemorySearchTask", "getSearchControlPrams", "createTaskCallback", "taskStartTime", "processTaskResult", "taskInfo", "Lcom/obric/memorydata/task/impl/TaskInfo;", "isMatchKnowledgeGraphAdditionTask", "executeKgSearchTask", ChatMessage.TYPE_QUERY, "createKgTaskCallback", "handleSearchResults", "distributeTruncatedResultsByQuantity", "Lkotlin/Triple;", "appEntityList", "memoryEntityList", "proactiveRecommendationResultList", "loadProactiveMemoryEntityBySearchResultEntries", "Lcom/obric/capabilitykit/entity/app/ProactiveMemoryEntity;", "searchResultEntries", "isPhotoSearchWithHighScore", "appEntity", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "searchEntry", "uploadImageIfNeed", "appEntityPairList", "Lkotlin/Pair;", "Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "collectImageUploadEntities", "Lcom/obric/memorydata/middleware/impl/image/ImageUploadEntity;", "limit", "collectMemoryImageUploadEntities", "handleSearchInfoIfInEvaluateMode", "finalAppEntitySearchResultEntry", "finalMemorySearchResultEntry", "getKGEntityFromSourceData", "indexList", "fillAppEntitiesByKGIndexSource", "kgEntityList", "kgSourceEntityList", "Lcom/obric/memorydata/personalcontext/search/kg/KGSourceEntity;", "getNoneSemanticResultList", "result", "getSemanticResultList", "handleGlobalAssistantError", "code", "message", "originQuery", "reportInAppSearchCostData", "reportGlobalSearchPerfCost", "handleResultTimeStart", "printDomainDebugInfo", Constants.KEY_LIST, "mergeMemoryRewriteQueries", "queries", "printSearchResultEntry", "searchResults", "convertToQuQueryList", "originalQueries", "filterMemorySearchResultEntriesByAppEntities", "deduplicateEntityTypes", "Companion", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class a {
    private static final Set<String> B = null;
    private static final Set<String> C = null;
    private static final Set<String> D = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0660a f12318a = null;
    private String A;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CountDownLatch f12319b;
    public CountDownLatch c;
    private final long d;
    private final Bundle e;
    private final String f;
    private final String g;
    private final EntitySearchRecordInfo h;
    private final String i;
    private final List<String> j;
    private final List<String> k;
    private final List<String> l;
    private StringBuffer m;
    private List<RewriteQuery> n;
    private GlobalQUResult o;
    private final GlobalAssistantSearchResponse p;
    private final Map<String, List<SearchResultEntry>> q;
    private final Map<String, List<SearchResultEntry>> r;
    private List<SearchResultEntry> s;
    private List<SearchResultEntry> t;
    private final List<GlobalSearchDomain> u;
    private final List<KGSourceIndex> v;
    private final List<Double> w;
    private final List<Double> x;
    private final boolean y;
    private KnowledgeGraphResponse z;

    /* JADX INFO: renamed from: com.obric.memorydata.personalcontext.search.global.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/obric/memorydata/personalcontext/search/global/AbstractGlobalAssistantSearchSession$Companion;", "", "<init>", "()V", "TAG", "", "KEY_KNOWLEDGE_GRAPH_SPO", "KEY_USE_KNOWLEDGE_GRAPH", "KEY_SEARCH_TYPE", "GLOBAL_SEARCH_TYPE", "DOMAINS_WITHOUT_SLOT_RESULT", "", "DOMAINS_WITH_DEFAULT_SLOT_RESULT", "EXCLUDED_MEMORY_DOMAINS", "getEXCLUDED_MEMORY_DOMAINS", "()Ljava/util/Set;", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C0660a {
        private C0660a() {
        }

        public /* synthetic */ C0660a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f12320a = null;

        static {
            int[] r0 = new int[AssetTypeEnum.values().length];
            r0[AssetTypeEnum.PHOTO.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[AssetTypeEnum.VIDEO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f12320a = r0;
        }
    }

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001¨\u0006\u0003¸\u0006\u0000"}, d2 = {"com/obric/memorydata/utils/GsonExtKt$toListObj$1", "Lcom/google/gson/reflect/TypeToken;", "", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c extends TypeToken<List<? extends BertQUAction>> {
        public c() {
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    static final class d implements Function2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f12321a = null;

        static {
            f12321a = new d();
        }

        d() {
        }

        public final Void a(long r1, EntitySearchRecordInfo r3) {
            Intrinsics.checkNotNullParameter(r3, "<unused var>");
            return null;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(Object r5, Object r6) {
            return a(((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.memorydata.plugin")).longValue(), (EntitySearchRecordInfo) ZeusTransformUtils.preCheckCast(r6, EntitySearchRecordInfo.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/memorydata/personalcontext/search/global/AbstractGlobalAssistantSearchSession$createKgTaskCallback$1", "Lcom/obric/memorydata/task/scheduler/OnTaskInfoCallBack;", "onChanged", "", "taskInfo", "Lcom/obric/memorydata/task/impl/TaskInfo;", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class e implements com.obric.memorydata.task.scheduler.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f12322a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f12323b;

        e(a r1, long r2) {
            this.f12322a = r1;
            this.f12323b = r2;
        }

        @Override // com.obric.memorydata.task.scheduler.c
        public void a(TaskInfo r12) {
            Intrinsics.checkNotNullParameter(r12, "taskInfo");
            if (r12.c().isFinished() == true) goto L6;
            return;
        L6:
            if (r12.c() == TaskInfo.State.SUCCEEDED) goto L10;
            IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "GlobalAssistantSearchSession", "Search task execution failed, taskResult msg:" + r12.e().getMsg() + ", taskResult code:" + r12.e().getCode() + '.', null, 4, null);
        L8:
            this.f12322a.f().countDown();
            return;
        L10:
            String r13 = r12.e().getOutput().toString();
            Intrinsics.checkNotNullExpressionValue(r13, "toString(...)");
            a r0 = this.f12322a;
            List<String> r1 = null;
            Object r14 = u.a().fromJson(r13, KnowledgeGraphResponse.class);     // Catch: Exception -> L13
        L15:
            a.a(r0, (KnowledgeGraphResponse) ZeusTransformUtils.preCheckCast(r14, KnowledgeGraphResponse.class, "com.obric.memorydata.plugin"));
            if (a.a(this.f12322a) == null) goto L57;
            RunLog r15 = RunLog.INSTANCE;
            StringBuilder r2 = new StringBuilder().append("KGResponse relation_spo: ");
            KnowledgeGraphResponse r3 = a.a(this.f12322a);
            if (r3 == null) goto L22;
            List<String> r4 = r3.getRelation_spo();
            if (r4 == null) goto L22;
            Integer r5 = Integer.valueOf(r4.size());
        L23:
            StringBuilder r6 = r2.append(r5).append(" spo_objects ");
            KnowledgeGraphResponse r7 = a.a(this.f12322a);
            if (r7 == null) goto L28;
            List<String> r8 = r7.getSpo_objects();
            if (r8 == null) goto L28;
            Integer r9 = Integer.valueOf(r8.size());
        L29:
            StringBuilder r10 = r6.append(r9).append(" , nameList: ");
            KnowledgeGraphResponse r11 = a.a(this.f12322a);
            if (r11 == null) goto L34;
            List<String> r16 = r11.getNameList();
            if (r16 == null) goto L34;
            Integer r17 = Integer.valueOf(r16.size());
        L35:
            r15.debug("GlobalAssistantSearchSession", r10.append(r17).toString());
            List<String> r18 = this.f12322a.a();
            KnowledgeGraphResponse r19 = a.a(this.f12322a);
            if (r19 == null) goto L38;
            List<String> r20 = r19.getRelation_spo();
        L39:
            if (r20 != null) goto L41;
            r20 = CollectionsKt.emptyList();
        L41:
            r18.addAll((Collection) ZeusTransformUtils.preCheckCast(r20, Collection.class, "com.obric.memorydata.plugin"));
            List<String> r110 = this.f12322a.b();
            KnowledgeGraphResponse r21 = a.a(this.f12322a);
            if (r21 == null) goto L44;
            List<String> r22 = r21.getSpo_objects();
        L45:
            if (r22 != null) goto L47;
            r22 = CollectionsKt.emptyList();
        L47:
            r110.addAll((Collection) ZeusTransformUtils.preCheckCast(r22, Collection.class, "com.obric.memorydata.plugin"));
            List<String> r111 = this.f12322a.c();
            KnowledgeGraphResponse r23 = a.a(this.f12322a);
            if (r23 == null) goto L50;
            r1 = r23.getNameList();
        L50:
            if (r1 != null) goto L52;
            r1 = CollectionsKt.emptyList();
        L52:
            r111.addAll((Collection) ZeusTransformUtils.preCheckCast(r1, Collection.class, "com.obric.memorydata.plugin"));
            KnowledgeGraphResponse r112 = a.a(this.f12322a);
            if (r112 == null) goto L57;
            KGSourceIndex r113 = r112.getSourceIndex();
            if (r113 == null) goto L57;
            a.c(this.f12322a).add(r113);
            goto L57
        L44:
            r22 = null;
            goto L45
        L38:
            r20 = null;
        L34:
            r17 = null;
        L28:
            r9 = null;
        L22:
            r5 = null;
        L57:
            a.b(this.f12322a).add(Double.valueOf(System.currentTimeMillis() - this.f12323b));
        L13:
            e = move-exception;
            IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "GsonExt", "convert content: " + r13 + " toObj error : " + e, null, 4, null);
            r14 = null;
            goto L15
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/memorydata/personalcontext/search/global/AbstractGlobalAssistantSearchSession$createTaskCallback$1", "Lcom/obric/memorydata/task/scheduler/OnTaskInfoCallBack;", "onChanged", "", "taskInfo", "Lcom/obric/memorydata/task/impl/TaskInfo;", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class f implements com.obric.memorydata.task.scheduler.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ EntitySearchRecordInfo f12324a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f12325b;
        final /* synthetic */ long c;

        f(EntitySearchRecordInfo r1, a r2, long r3) {
            this.f12324a = r1;
            this.f12325b = r2;
            this.c = r3;
        }

        @Override // com.obric.memorydata.task.scheduler.c
        public void a(TaskInfo r5) {
            Intrinsics.checkNotNullParameter(r5, "taskInfo");
            if (Intrinsics.areEqual(r5.b(), "queryAndDownloadFinish") == false) goto L6;
            this.f12324a.setRealPackageStartTime(r5.d().optLong("task_execute"));
        L6:
            if (Intrinsics.areEqual(r5.b(), "queryAndDownloadStart") == false) goto L9;
            this.f12324a.setRealPackageQueryStartTime(r5.d().optLong("task_execute"));
        L9:
            if (r5.e().getCode() != 0) goto L11;
        L16:
            this.f12325b.d().append(r5.e().getOutput().optString("query_understanding_results").toString());
            a.a(this.f12325b, r5, this.c, this.f12324a);
            this.f12325b.e().countDown();
            return;
        L11:
            if (r5.c() == TaskInfo.State.SUCCEEDED) goto L16;
            if (r5.c() != TaskInfo.State.FAILED) goto L18;
            RunLog.INSTANCE.debug("GlobalAssistantSearchSession", "Search task execution failed, taskResult msg:" + r5.e().getMsg() + ", taskResult code:" + r5.e().getCode() + '.');
            this.f12325b.e().countDown();
            return;
        }
    }

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001¨\u0006\u0003¸\u0006\u0000"}, d2 = {"com/obric/memorydata/utils/GsonExtKt$toListObj$1", "Lcom/google/gson/reflect/TypeToken;", "", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class g extends TypeToken<List<? extends BertQUAction>> {
        public g() {
        }
    }

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001¨\u0006\u0003¸\u0006\u0000"}, d2 = {"com/obric/memorydata/utils/GsonExtKt$toListObj$1", "Lcom/google/gson/reflect/TypeToken;", "", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class h extends TypeToken<List<? extends SearchResultEntry>> {
        public h() {
        }
    }

    static {
        f12318a = new C0660a(null);
        B = SetsKt.setOf("Photo");
        C = SetsKt.setOf("RecMemory");
        D = SetsKt.setOf("RecMemory");
    }

    public a(long r17, Bundle r19, String r20, String r21, EntitySearchRecordInfo r22, String r23) {
        Intrinsics.checkNotNullParameter(r19, "bundle");
        Intrinsics.checkNotNullParameter(r20, "queryId");
        Intrinsics.checkNotNullParameter(r21, "userQuery");
        Intrinsics.checkNotNullParameter(r23, "inputType");
        this.d = r17;
        this.e = r19;
        this.f = r20;
        this.g = r21;
        this.h = r22;
        this.i = r23;
        this.j = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        this.k = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        this.l = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        this.m = new StringBuffer();
        this.p = new GlobalAssistantSearchResponse(0, "", null, null, null, null, null, null, 252, null);
        this.q = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        this.r = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        this.s = CollectionsKt.emptyList();
        this.t = CollectionsKt.emptyList();
        this.u = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        this.v = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        this.w = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        this.x = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        boolean r3 = true;
        if (r19.getBoolean("is_personal_context_kg_switch_on", true) == true) goto L5;
    L7:
        r3 = false;
    L8:
        this.y = r3;
        return;
    L5:
        if (AppContext.INSTANCE.isObricFlavor() == false) goto L7;
        goto L7
    }

    public /* synthetic */ a(long r10, Bundle r12, String r13, String r14, EntitySearchRecordInfo r15, String r16, int r17, DefaultConstructorMarker r18) {
        if ((r17 & 16) == 0) goto L5;
        EntitySearchRecordInfo r7 = null;
    L7:
        if ((r17 & 32) == 0) goto L9;
        String r8 = "";
    L10:
        this(r10, r12, r13, r14, r7, r8);
        return;
    L9:
        r8 = r16;
        goto L10
    L5:
        r7 = r15;
        goto L7
    }

    public static final /* synthetic */ KnowledgeGraphResponse a(a r0) {
        return r0.z;
    }

    static /* synthetic */ AbsTaskRequest a(a r6, RewriteQuery r7, String r8, String r9, String r10, Function2 r11, int r12, Object r13) {
        Function2<? super Long, ? super EntitySearchRecordInfo, ? extends com.obric.memorydata.task.scheduler.c> r14 = (Function2) ZeusTransformUtils.wrapperContextForParams(r11, Function2.class, "com.obric.memorydata.plugin");
        if (r13 != null) goto L10;
        if ((r12 & 16) == 0) goto L8;
        r14 = (Function2) ZeusTransformUtils.preCheckCast(d.f12321a, Function2.class, "com.obric.memorydata.plugin");
    L8:
        return r6.a(r7, r8, r9, r10, r14);
    L10:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createDomainSearchTask");
    }

    private final AbsTaskRequest a(RewriteQuery r17, EntitySearchRecordInfo r18, String r19, String r20, Function2<? super Long, ? super EntitySearchRecordInfo, ? extends com.obric.memorydata.task.scheduler.c> r21) {
        Function2 r4 = (Function2) ZeusTransformUtils.wrapperContextForParams(r21, Function2.class, "com.obric.memorydata.plugin");
        long r6 = System.currentTimeMillis();
        JSONArray r8 = new JSONArray();
        if (Intrinsics.areEqual(r17.getDomain(), "All") == false) goto L8;
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(com.obric.memorydata.personalcontext.search.d.f12308a.c(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L6:
        if (r9.hasNext() == false) goto L14;
        r8.put((String) ZeusTransformUtils.preCheckCast(r9.next(), String.class, "com.obric.memorydata.plugin"));
    L14:
        JSONArray r10 = new JSONArray();
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(com.obric.memorydata.personalcontext.search.a.f12274a.b(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L16:
        if (r11.hasNext() == false) goto L18;
        r10.put(((Number) ZeusTransformUtils.preCheckCast(r11.next(), Number.class, "com.obric.memorydata.plugin")).intValue());
        goto L16
    L18:
        boolean r12 = true;
        TaskRequest.Builder r13 = (TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(new TaskRequest.Builder("memory_search").setExistingTaskPolicy(ExistingTaskPolicy.CANCEL_EXISTING), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setExecuteImmediately(true), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setForegroundCallerPkg(AppInfo.OAssistant.getPackageName()), TaskRequest.Builder.class, "com.obric.memorydata.plugin");
        JSONObject r14 = new JSONObject();
        JSONObject r15 = new JSONObject();
        r15.put(ChatMessage.TYPE_QUERY, r17.getQuery());
        r15.put("memory_domain", r8);
        r15.put("raw_query", r19);
        r15.put("raw_query", r19);
        r15.put("switch_off_types", r10);
        CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast(r20, CharSequence.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L21;
    L24:
        boolean r3 = true;
    L25:
        if (r3 == true) goto L27;
        r15.put("query_understanding_results", r20);
    L27:
        Unit r5 = Unit.INSTANCE;
        r14.put("query_params", r15);
        JSONObject r7 = new JSONObject();
        int r16 = i();
        if (r16 > 0) goto L31;
        r16 = 50;
    L31:
        r7.put("limit", r16);
        r7.put("embedding_type", com.obric.memorydata.personalcontext.util.c.f12363a.c());
        Unit r22 = Unit.INSTANCE;
        r14.put("search_control_params", r7.toString());
        KnowledgeGraphResponse r23 = this.z;
        if (r23 == null) goto L34;
        List<KGPOEntity> r24 = r23.getPo_list();
    L35:
        Collection r25 = (Collection) ZeusTransformUtils.preCheckCast(r24, Collection.class, "com.obric.memorydata.plugin");
        if (r25 != null) goto L38;
    L41:
        if (r12 == true) goto L43;
        r14.put("knowledge_graph_spo", u.a(r24));
    L43:
        r14.put("is_evaluating", com.obric.memorydata.personalcontext.log.a.f12229a.b());
        TaskRequest.Builder r26 = (TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(r13.setInputParam(r14), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setPriority(10), TaskRequest.Builder.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.task.scheduler.c r27 = (com.obric.memorydata.task.scheduler.c) ZeusTransformUtils.preCheckCast(r4.invoke(Long.valueOf(r6), r18), com.obric.memorydata.task.scheduler.c.class, "com.obric.memorydata.plugin");
        if (r27 != null) goto L47;
        r27 = a(r17, r6, r18);
    L47:
        return (AbsTaskRequest) ZeusTransformUtils.preCheckCast((TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(r26.setTaskInfoCallback(r27), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin"), AbsTaskRequest.class, "com.obric.memorydata.plugin");
    L38:
        if (r25.isEmpty() == true) goto L41;
        r12 = false;
        goto L41
    L34:
        r24 = null;
        goto L35
    L21:
        if (r2.length() == 0) goto L24;
        r3 = false;
        goto L25
    L8:
        Set<String> r28 = r17.getSubDomain();
        if (r28 == null) goto L14;
        Iterator r29 = ((Iterable) ZeusTransformUtils.preCheckCast(r28, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L12:
        if (r29.hasNext() == false) goto L14;
        r8.put((String) ZeusTransformUtils.preCheckCast(r29.next(), String.class, "com.obric.memorydata.plugin"));
        goto L12
    }

    private final AbsTaskRequest a(RewriteQuery r68, String r69, String r70, String r71, Function2<? super Long, ? super EntitySearchRecordInfo, ? extends com.obric.memorydata.task.scheduler.c> r72) {
        Function2<? super Long, ? super EntitySearchRecordInfo, ? extends com.obric.memorydata.task.scheduler.c> r5 = (Function2) ZeusTransformUtils.wrapperContextForParams(r72, Function2.class, "com.obric.memorydata.plugin");
        EntitySearchRecordInfo r2 = new EntitySearchRecordInfo(null, AppInfo.OAssistant.getPackageName(), "global_search_" + r68.getDomain(), 0, null, 0, 0, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, false, null, -7, null);
        this.u.add(new GlobalSearchDomain(r68.getDomain()));
        if (Intrinsics.areEqual(r69, "memory_search") == true) goto L5;
        int r4 = i();
        String r7 = r68.getQuery();
        if (r4 > 0) goto L10;
        r4 = 50;
    L10:
        InAppSearchRequest r14 = new InAppSearchRequest(r7, r4, false, false, 0, 28, null);
        String r6 = (String) ZeusTransformUtils.preCheckCast(com.obric.memorydata.personalcontext.search.d.f12308a.f().get(r68.getDomain()), String.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L13;
        r6 = "";
    L13:
        r14.setPackageName(r6);
        r14.setPresetQUResult(r71);
        r14.setInteractionType(this.i);
        JsonObject r8 = ab.a(u.a(r14));
        if (j() == false) goto L16;
        String r9 = r70;
    L17:
        r8.addProperty("raw_query", r9);
        long r10 = System.currentTimeMillis();
        boolean r11 = true;
        TaskRequest.Builder r1 = (TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(new TaskRequest.Builder(r69).setExistingTaskPolicy(ExistingTaskPolicy.CANCEL_EXISTING), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setExecuteImmediately(true), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setForegroundCallerPkg(AppInfo.OAssistant.getPackageName()), TaskRequest.Builder.class, "com.obric.memorydata.plugin");
        JSONObject r12 = new JSONObject();
        r12.put("search_params", u.a(r8));
        r12.put("search_type", SearchType.IN_APP.getValue());
        r12.put("search_control_params", k());
        r12.put("use_knowledge_graph", this.y);
        KnowledgeGraphResponse r13 = this.z;
        if (r13 == null) goto L20;
        List<KGPOEntity> r15 = r13.getPo_list();
    L21:
        Collection r16 = (Collection) ZeusTransformUtils.preCheckCast(r15, Collection.class, "com.obric.memorydata.plugin");
        if (r16 != null) goto L24;
    L27:
        if (r11 == true) goto L29;
        r12.put("knowledge_graph_spo", u.a(r15));
    L29:
        TaskRequest.Builder r3 = (TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(r1.setInputParam(r12), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setPriority(10), TaskRequest.Builder.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.task.scheduler.c r17 = (com.obric.memorydata.task.scheduler.c) ZeusTransformUtils.preCheckCast(r5.invoke(Long.valueOf(r10), r2), com.obric.memorydata.task.scheduler.c.class, "com.obric.memorydata.plugin");
        if (r17 != null) goto L33;
        r17 = a(r68, r10, r2);
    L33:
        return (AbsTaskRequest) ZeusTransformUtils.preCheckCast((TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(r3.setTaskInfoCallback(r17), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin"), AbsTaskRequest.class, "com.obric.memorydata.plugin");
    L24:
        if (r16.isEmpty() == true) goto L27;
        r11 = false;
        goto L27
    L20:
        r15 = null;
        goto L21
    L16:
        r9 = r68.getQuery();
        goto L17
    L5:
        return a(r68, r2, r70, r71, r5);
    }

    private final com.obric.memorydata.task.scheduler.c a(long r2) {
        return (com.obric.memorydata.task.scheduler.c) ZeusTransformUtils.preCheckCast(new e(this, r2), com.obric.memorydata.task.scheduler.c.class, "com.obric.memorydata.plugin");
    }

    private static final CharSequence a(SearchResultEntry r3) {
        Intrinsics.checkNotNullParameter(r3, "entry");
        return (CharSequence) ZeusTransformUtils.preCheckCast("type: " + r3.getType() + ", id: " + r3.getId(), CharSequence.class, "com.obric.memorydata.plugin");
    }

    static /* synthetic */ List a(a r2, List r3, List r4, Set r5, int r6, Object r7) {
        List<SearchResultEntry> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        List<SearchResultEntry> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Set<Integer> r10 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L10;
        if ((r6 & 4) == 0) goto L8;
        r10 = SetsKt.setOf(401);
    L8:
        return r2.a(r8, r9, r10);
    L10:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: filterMemorySearchResultEntriesByAppEntities");
    }

    private final List<RewriteQuery> a(GlobalQUResult r25) {
        List<RewriteQuery> r0 = r25.getQuery_rewrite();
        if (r0 == null) goto L177;
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r2 = r1.iterator();
    L6:
        if (r2.hasNext() == false) goto L24;
        RewriteQuery r5 = (RewriteQuery) ZeusTransformUtils.preCheckCast(r2.next(), RewriteQuery.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r5.getDomain(), "All") == false) goto L20;
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(com.obric.memorydata.personalcontext.search.d.f12308a.b(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r15 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r16 = r7.iterator();
    L11:
        if (r16.hasNext() == false) goto L18;
        String r8 = (String) ZeusTransformUtils.preCheckCast(r16.next(), String.class, "com.obric.memorydata.plugin");
        if (com.obric.memorydata.personalcontext.f.f12179a.a(r8) == false) goto L15;
        RewriteQuery r9 = RewriteQuery.copy$default(r5, r8, null, null, null, 14, null);
    L16:
        if (r9 == null) goto L11;
        r15.add(r9);
        goto L11
    L15:
        r9 = null;
        goto L16
    L18:
        List r6 = CollectionsKt.plus((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r15, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin"), RewriteQuery.copy$default(r5, "Memory", null, r5.getType(), SetsKt.setOf("All"), 2, null));
    L23:
        CollectionsKt.addAll(r4, (Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin"));
        goto L6
    L20:
        if (com.obric.memorydata.personalcontext.search.d.f12308a.c().contains(r5.getDomain()) == false) goto L22;
        r5 = RewriteQuery.copy$default(r5, "Memory", null, r5.getType(), SetsKt.setOf(r5.getDomain()), 2, null);
    L22:
        r6 = CollectionsKt.listOf(r5);
        goto L23
    L24:
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r10 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r11 = r3.iterator();
    L26:
        if (r11.hasNext() == false) goto L33;
        Object r12 = r11.next();
        if (com.obric.memorydata.personalcontext.search.d.f12308a.d().get(((RewriteQuery) ZeusTransformUtils.preCheckCast(r12, RewriteQuery.class, "com.obric.memorydata.plugin")).getDomain()) == null) goto L30;
        boolean r13 = true;
    L31:
        if (r13 == false) goto L26;
        r10.add(r12);
        goto L26
    L30:
        r13 = false;
        goto L31
    L33:
        List r14 = (List) ZeusTransformUtils.preCheckCast(r10, List.class, "com.obric.memorydata.plugin");
        String r17 = r25.getSlot_result();
        if (r17 != null) goto L179;
    L115:
        List r18 = CollectionsKt.emptyList();
    L116:
        Iterable r19 = (Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.memorydata.plugin");
        Collection r20 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r21 = r19.iterator();
    L118:
        if (r21.hasNext() == false) goto L122;
        Object r22 = r21.next();
        if (B.contains(((RewriteQuery) ZeusTransformUtils.preCheckCast(r22, RewriteQuery.class, "com.obric.memorydata.plugin")).getDomain()) == false) goto L118;
        r20.add(r22);
        goto L118
    L122:
        Iterable r23 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r20, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Map r24 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r23, 10)), 16)), Map.class, "com.obric.memorydata.plugin");
        Iterator r26 = r23.iterator();
    L124:
        if (r26.hasNext() == false) goto L126;
        Object r27 = r26.next();
        r24.put(((RewriteQuery) ZeusTransformUtils.preCheckCast(r27, RewriteQuery.class, "com.obric.memorydata.plugin")).getDomain(), r27);
        goto L124
    L126:
        Iterable r28 = (Iterable) ZeusTransformUtils.preCheckCast(C, Iterable.class, "com.obric.memorydata.plugin");
        Collection r29 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r30 = r28.iterator();
    L128:
        if (r30.hasNext() == false) goto L143;
        Object r31 = r30.next();
        String r32 = (String) ZeusTransformUtils.preCheckCast(r31, String.class, "com.obric.memorydata.plugin");
        Iterable r33 = (Iterable) ZeusTransformUtils.preCheckCast(r18, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r33, Collection.class) == true) goto L132;
    L134:
        Iterator r34 = r33.iterator();
    L136:
        if (r34.hasNext() == false) goto L133;
        if (Intrinsics.areEqual(((RewriteQuery) ZeusTransformUtils.preCheckCast(r34.next(), RewriteQuery.class, "com.obric.memorydata.plugin")).getDomain(), r32) == false) goto L136;
        boolean r35 = true;
    L141:
        if ((!r35) == false) goto L128;
        r29.add(r31);
    L133:
        r35 = false;
        goto L141
    L132:
        if (((Collection) ZeusTransformUtils.preCheckCast(r33, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L134;
    L143:
        Iterable r36 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r29, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r37 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r36, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r38 = r36.iterator();
    L145:
        if (r38.hasNext() == false) goto L147;
        r37.add(new RewriteQuery((String) ZeusTransformUtils.preCheckCast(r38.next(), String.class, "com.obric.memorydata.plugin"), this.g, null, null, 12, null));
        goto L145
    L147:
        List r39 = (List) ZeusTransformUtils.preCheckCast(r37, List.class, "com.obric.memorydata.plugin");
        Collection r40 = (Collection) ZeusTransformUtils.preCheckCast(r18, Collection.class, "com.obric.memorydata.plugin");
        Map r41 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Iterator r42 = r24.entrySet().iterator();
    L149:
        if (r42.hasNext() == false) goto L164;
        Map.Entry r43 = (Map.Entry) ZeusTransformUtils.preCheckCast(r42.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r44 = (String) ZeusTransformUtils.preCheckCast(r43.getKey(), String.class, "com.obric.memorydata.plugin");
        Iterable r110 = (Iterable) ZeusTransformUtils.preCheckCast(r18, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r110, Collection.class) == true) goto L153;
    L155:
        Iterator r111 = r110.iterator();
    L157:
        if (r111.hasNext() == false) goto L154;
        if (Intrinsics.areEqual(((RewriteQuery) ZeusTransformUtils.preCheckCast(r111.next(), RewriteQuery.class, "com.obric.memorydata.plugin")).getDomain(), r44) == false) goto L157;
        boolean r45 = true;
    L162:
        if ((!r45) == false) goto L149;
        r41.put(r43.getKey(), r43.getValue());
    L154:
        r45 = false;
        goto L162
    L153:
        if (((Collection) ZeusTransformUtils.preCheckCast(r110, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L155;
    L164:
        List r46 = CollectionsKt.plus((Collection) ZeusTransformUtils.preCheckCast(CollectionsKt.plus(r40, (Iterable) ZeusTransformUtils.preCheckCast(r41.values(), Iterable.class, "com.obric.memorydata.plugin")), Collection.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(r39, Iterable.class, "com.obric.memorydata.plugin"));
        Set<String> r47 = h();
        Iterable r48 = (Iterable) ZeusTransformUtils.preCheckCast(r46, Iterable.class, "com.obric.memorydata.plugin");
        Collection r49 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r50 = r48.iterator();
    L166:
        if (r50.hasNext() == false) goto L176;
        Object r51 = r50.next();
        RewriteQuery r52 = (RewriteQuery) ZeusTransformUtils.preCheckCast(r51, RewriteQuery.class, "com.obric.memorydata.plugin");
        if (r47.contains(r52.getDomain()) == false) goto L170;
    L172:
        boolean r53 = false;
    L173:
        if (r53 == false) goto L166;
        r49.add(r51);
        goto L166
    L170:
        if (com.obric.memorydata.personalcontext.f.f12179a.a(r52.getDomain()) == false) goto L172;
        r53 = true;
        goto L173
    L176:
        return f((List) ZeusTransformUtils.preCheckCast(r49, List.class, "com.obric.memorydata.plugin"));
    L179:
        List r54 = (List) ZeusTransformUtils.preCheckCast(u.a().fromJson(r17, new c().getType()), List.class, "com.obric.memorydata.plugin");     // Catch: JsonParseException -> L37 JsonSyntaxException -> L39
    L42:
        if (r54 == null) goto L115;
        Iterable r55 = (Iterable) ZeusTransformUtils.preCheckCast(r54, Iterable.class, "com.obric.memorydata.plugin");
        Map r56 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Iterator r57 = r55.iterator();
    L44:
        String r112 = "Memory";
        if (r57.hasNext() == false) goto L66;
        Object r58 = r57.next();
        BertQUAction r113 = (BertQUAction) ZeusTransformUtils.preCheckCast(r58, BertQUAction.class, "com.obric.memorydata.plugin");
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r113.getActionName(), CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("Memory", CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == false) goto L61;
        Iterable r114 = (Iterable) ZeusTransformUtils.preCheckCast(D, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r114, Collection.class) == true) goto L51;
    L53:
        Iterator r115 = r114.iterator();
    L55:
        if (r115.hasNext() == false) goto L52;
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r113.getActionName(), CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r115.next(), String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == false) goto L55;
        boolean r59 = true;
    L59:
        if (r59 == true) goto L61;
    L62:
        Object r60 = r56.get(r112);
        if (r60 != null) goto L65;
        r60 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        r56.put(r112, r60);
    L65:
        ((List) ZeusTransformUtils.preCheckCast(r60, List.class, "com.obric.memorydata.plugin")).add(r58);
    L52:
        r59 = false;
        goto L59
    L51:
        if (((Collection) ZeusTransformUtils.preCheckCast(r114, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L53;
    L61:
        r112 = StringsKt.removePrefix(r113.getActionName(), (CharSequence) ZeusTransformUtils.preCheckCast("Search", CharSequence.class, "com.obric.memorydata.plugin"));
        goto L62
    L66:
        Collection r61 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r62 = r56.entrySet().iterator();
    L68:
        if (r62.hasNext() == false) goto L105;
        Map.Entry r63 = (Map.Entry) ZeusTransformUtils.preCheckCast(r62.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r64 = (String) ZeusTransformUtils.preCheckCast(r63.getKey(), String.class, "com.obric.memorydata.plugin");
        List r65 = (List) ZeusTransformUtils.preCheckCast(r63.getValue(), List.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r64, "Memory") == false) goto L93;
        Iterable r66 = (Iterable) ZeusTransformUtils.preCheckCast(r65, Iterable.class, "com.obric.memorydata.plugin");
        Collection r67 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r66, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r68 = r66.iterator();
    L73:
        if (r68.hasNext() == false) goto L75;
        r67.add(StringsKt.removePrefix(((BertQUAction) ZeusTransformUtils.preCheckCast(r68.next(), BertQUAction.class, "com.obric.memorydata.plugin")).getActionName(), (CharSequence) ZeusTransformUtils.preCheckCast("Search", CharSequence.class, "com.obric.memorydata.plugin")));
        goto L73
    L75:
        Iterable r69 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r67, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r70 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r71 = r69.iterator();
    L77:
        if (r71.hasNext() == false) goto L81;
        Object r116 = r71.next();
        if (D.contains((String) ZeusTransformUtils.preCheckCast(r116, String.class, "com.obric.memorydata.plugin")) == true) goto L77;
        r70.add(r116);
        goto L77
    L81:
        Set r72 = CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r70, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
        BertQUAction r73 = (BertQUAction) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(r65), BertQUAction.class, "com.obric.memorydata.plugin");
        if (r73 == null) goto L85;
        String r74 = r73.getQuery();
        if (r74 == null) goto L85;
    L86:
        List<RewriteQuery> r75 = r25.getQuery_rewrite();
        if (r75 == null) goto L91;
        RewriteQuery r76 = (RewriteQuery) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(r75), RewriteQuery.class, "com.obric.memorydata.plugin");
        if (r76 == null) goto L91;
        String r77 = r76.getType();
    L92:
        List r78 = CollectionsKt.listOf(new RewriteQuery("Memory", r74, r77, r72));
    L104:
        CollectionsKt.addAll(r61, (Iterable) ZeusTransformUtils.preCheckCast(r78, Iterable.class, "com.obric.memorydata.plugin"));
    L91:
        r77 = null;
    L85:
        r74 = r25.getOrigin_query();
        goto L86
    L93:
        Iterable r79 = (Iterable) ZeusTransformUtils.preCheckCast(r65, Iterable.class, "com.obric.memorydata.plugin");
        Collection r80 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r79, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r81 = r79.iterator();
    L95:
        if (r81.hasNext() == false) goto L103;
        String r117 = ((BertQUAction) ZeusTransformUtils.preCheckCast(r81.next(), BertQUAction.class, "com.obric.memorydata.plugin")).getQuery();
        List<RewriteQuery> r118 = r25.getQuery_rewrite();
        if (r118 == null) goto L101;
        RewriteQuery r119 = (RewriteQuery) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(r118), RewriteQuery.class, "com.obric.memorydata.plugin");
        if (r119 == null) goto L101;
        String r210 = r119.getType();
    L102:
        r80.add(new RewriteQuery(r64, r117, r210, null, 8, null));
    L101:
        r210 = null;
        goto L102
    L103:
        r78 = (List) ZeusTransformUtils.preCheckCast(r80, List.class, "com.obric.memorydata.plugin");
        goto L104
    L105:
        Iterable r82 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r61, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r83 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r84 = r82.iterator();
    L107:
        if (r84.hasNext() == false) goto L114;
        Object r85 = r84.next();
        if (com.obric.memorydata.personalcontext.search.d.f12308a.d().get(((RewriteQuery) ZeusTransformUtils.preCheckCast(r85, RewriteQuery.class, "com.obric.memorydata.plugin")).getDomain()) == null) goto L111;
        boolean r86 = true;
    L112:
        if (r86 == false) goto L107;
        r83.add(r85);
        goto L107
    L111:
        r86 = false;
        goto L112
    L114:
        r18 = (List) ZeusTransformUtils.preCheckCast(r83, List.class, "com.obric.memorydata.plugin");
        goto L116
    L39:
        e = e;
        IRunLog r120 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r87 = new StringBuilder();
    L41:
        IRunLog.a.b(r120, "GsonExt", r87.append("toListObj error : ").append(e).toString(), null, 4, null);
        r54 = null;
    L37:
        e = e;
        r120 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r87 = new StringBuilder();
        goto L41
    L177:
        ((a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin")).a(1002, "error: Search request params is null", r25.getOrigin_query());
        return CollectionsKt.emptyList();
    }

    private final List<ImageUploadEntity> a(List<? extends Pair<SearchResultEntry, ? extends AppEntity>> r32, int r33) {
        a r0 = this;
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r32, List.class, "com.obric.memorydata.plugin");
        List<ImageUploadEntity> r3 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        List<RewriteQuery> r4 = r0.n;
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("filterQueryRewrite");
        r4 = null;
    L5:
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin");
        Collection r6 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r7 = r5.iterator();
    L6:
        boolean r8 = false;
        int r9 = 1;
        if (r7.hasNext() == false) goto L17;
        Object r10 = r7.next();
        RewriteQuery r11 = (RewriteQuery) ZeusTransformUtils.preCheckCast(r10, RewriteQuery.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r11.getDomain(), "RecMemory") == false) goto L11;
    L15:
        if (r8 == false) goto L6;
        r6.add(r10);
        goto L6
    L11:
        if (Intrinsics.areEqual(r11.getDomain(), "AuditoryRecording") == true) goto L15;
        if (Intrinsics.areEqual(r11.getDomain(), "Album") == true) goto L15;
        r8 = true;
        goto L15
    L17:
        List r12 = (List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.memorydata.plugin");
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r12, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == true) goto L20;
    L24:
        boolean r13 = false;
    L25:
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r14 = 0;
    L27:
        if (r2.hasNext() == false) goto L174;
        Pair r15 = (Pair) ZeusTransformUtils.preCheckCast(r2.next(), Pair.class, "com.obric.memorydata.plugin");
        SearchResultEntry r16 = (SearchResultEntry) ZeusTransformUtils.preCheckCast(r15.component1(), SearchResultEntry.class, "com.obric.memorydata.plugin");
        AppEntity r17 = (AppEntity) ZeusTransformUtils.preCheckCast(r15.component2(), AppEntity.class, "com.obric.memorydata.plugin");
        if (r17.getType() != 301) goto L35;
        if (r14 >= r33) goto L35;
        if (r13 == false) goto L34;
    L37:
        Intrinsics.checkNotNull(r17, "null cannot be cast to non-null type com.obric.capabilitykit.entity.app.PhotoEntity");
        PhotoEntity r18 = (PhotoEntity) ZeusTransformUtils.preCheckCast(r17, PhotoEntity.class, "com.obric.memorydata.plugin");
        int r19 = b.f12320a[r18.getAssetType().ordinal()];
        if (r19 != r9) goto L40;
        Iterator r110 = r2;
        int r21 = r18.getType();
        String r22 = r18.getId();
        String r20 = r18.getFile().getContentUrl().toString();
        Intrinsics.checkNotNullExpressionValue(r20, "toString(...)");
        ImageUploadEntity r23 = new ImageUploadEntity(r21, r22, r20, r17.get_packageName(), true, null, 32, null);
    L170:
        r3.add(r23);
    L171:
        r14 = r14 + 1;
    L173:
        r0 = this;
        r2 = r110;
        r9 = 1;
        goto L27
    L40:
        if (r19 != 2) goto L168;
        Iterable r111 = (Iterable) ZeusTransformUtils.preCheckCast(r16.getInAppSearchParams(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r24 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r112 = r111.iterator();
    L43:
        if (r112.hasNext() == false) goto L53;
        Object r113 = r112.next();
        InAppSearchEntityParam r25 = (InAppSearchEntityParam) ZeusTransformUtils.preCheckCast(r113, InAppSearchEntityParam.class, "com.obric.memorydata.plugin");
        if (r25.isSemantic() == true) goto L47;
    L49:
        boolean r26 = false;
    L50:
        if (r26 == false) goto L43;
        r24.add(r113);
        goto L43
    L47:
        if (Intrinsics.areEqual(r25.getField(), "PhotoEntity_VideoFrame_file") == false) goto L49;
        r26 = true;
        goto L50
    L53:
        Iterator r27 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r24, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        if (r27.hasNext() == true) goto L56;
        r110 = r2;
        Object r28 = null;
    L74:
        InAppSearchEntityParam r29 = (InAppSearchEntityParam) ZeusTransformUtils.preCheckCast(r28, InAppSearchEntityParam.class, "com.obric.memorydata.plugin");
        if (r29 == null) goto L79;
        String r30 = r29.getFieldArrayUniqueKey();
        if (r30 == null) goto L79;
        long r31 = Long.parseLong(r30);
    L81:
        if (r31 >= 0) goto L101;
        Iterator r34 = ((Iterable) ZeusTransformUtils.preCheckCast(r16.getInAppSearchParams(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L84:
        if (r34.hasNext() == false) goto L93;
        Object r114 = r34.next();
        InAppSearchEntityParam r115 = (InAppSearchEntityParam) ZeusTransformUtils.preCheckCast(r114, InAppSearchEntityParam.class, "com.obric.memorydata.plugin");
        if (r115.isSemantic() == false) goto L88;
    L90:
        boolean r35 = false;
    L91:
        if (r35 == false) goto L84;
    L94:
        InAppSearchEntityParam r36 = (InAppSearchEntityParam) ZeusTransformUtils.preCheckCast(r114, InAppSearchEntityParam.class, "com.obric.memorydata.plugin");
        if (r36 == null) goto L101;
        String r37 = r36.getFieldArrayUniqueKey();
        if (r37 == null) goto L99;
        r31 = Long.parseLong(r37);
        goto L101
    L99:
        r31 = -1;
        goto L101
    L88:
        if (Intrinsics.areEqual(r115.getField(), "PhotoEntity_VideoFrame_MetaTag_tagName") == false) goto L90;
        r35 = true;
        goto L91
    L93:
        r114 = null;
    L101:
        if (r31 >= 0) goto L140;
        Iterable r38 = (Iterable) ZeusTransformUtils.preCheckCast(r16.getInAppSearchParams(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r39 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r40 = r38.iterator();
    L104:
        if (r40.hasNext() == false) goto L113;
        Object r41 = r40.next();
        InAppSearchEntityParam r116 = (InAppSearchEntityParam) ZeusTransformUtils.preCheckCast(r41, InAppSearchEntityParam.class, "com.obric.memorydata.plugin");
        if (r116.isSemantic() == true) goto L108;
    L110:
        boolean r117 = false;
    L111:
        if (r117 == false) goto L104;
        r39.add(r41);
        goto L104
    L108:
        if (Intrinsics.areEqual(r116.getField(), "PhotoEntity_VideoFrame_caption") == false) goto L110;
        r117 = true;
        goto L111
    L113:
        Iterator r42 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r39, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        if (r42.hasNext() == true) goto L116;
        long r210 = r31;
        Object r43 = null;
    L132:
        InAppSearchEntityParam r44 = (InAppSearchEntityParam) ZeusTransformUtils.preCheckCast(r43, InAppSearchEntityParam.class, "com.obric.memorydata.plugin");
        if (r44 == null) goto L141;
        String r45 = r44.getFieldArrayUniqueKey();
        if (r45 == null) goto L137;
        long r46 = Long.parseLong(r45);
    L138:
        long r47 = r46;
    L143:
        if (r47 < 0) goto L173;
        List<VideoFrame> r48 = r18.getSearchFrames();
        if (r48 == null) goto L157;
        Iterator r49 = ((Iterable) ZeusTransformUtils.preCheckCast(r48, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L148:
        if (r49.hasNext() == false) goto L155;
        Object r50 = r49.next();
        if (((VideoFrame) ZeusTransformUtils.preCheckCast(r50, VideoFrame.class, "com.obric.memorydata.plugin")).getFrameTime() != r47) goto L152;
        boolean r51 = true;
    L153:
        if (r51 == false) goto L148;
    L156:
        VideoFrame r52 = (VideoFrame) ZeusTransformUtils.preCheckCast(r50, VideoFrame.class, "com.obric.memorydata.plugin");
    L158:
        if (r52 == null) goto L173;
        EntityVideoExtractHelper r53 = EntityVideoExtractHelper.INSTANCE;
        String r54 = r17.get_packageName();
        Uri r55 = Uri.parse(r18.getFile().getContentUrl().toString());
        Intrinsics.checkNotNullExpressionValue(r55, "parse(...)");
        Uri r56 = r53.extractFrame(r54, r55, r52.getFrameTime());
        if (r56 == null) goto L171;
        String r57 = r56.getLastPathSegment();
        if (r57 == null) goto L171;
        URI r58 = new URI("file", null, new File(new File(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getFilesDir(), Environment.DIRECTORY_PICTURES) + "/ImageIndexTemp", r57).getAbsolutePath(), null);
        int r211 = r18.getType();
        String r212 = r18.getId();
        String r59 = r58.toString();
        Intrinsics.checkNotNullExpressionValue(r59, "toString(...)");
        r23 = new ImageUploadEntity(r211, r212, r59, BuildConfig.LIBRARY_PACKAGE_NAME, true, null, 32, null);
        goto L170
    L152:
        r51 = false;
        goto L153
    L155:
        r50 = null;
        goto L156
    L157:
        r52 = null;
        goto L158
    L137:
        r46 = -1;
    L141:
        r47 = r210;
        goto L143
    L116:
        r43 = r42.next();
        if (r42.hasNext() == true) goto L119;
        r210 = r31;
        goto L132
    L119:
        SearchScoreParam r60 = ((InAppSearchEntityParam) ZeusTransformUtils.preCheckCast(r43, InAppSearchEntityParam.class, "com.obric.memorydata.plugin")).getScore();
        if (r60 == null) goto L122;
        double r61 = r60.getValue();
    L123:
        Object r118 = r42.next();
        SearchScoreParam r119 = ((InAppSearchEntityParam) ZeusTransformUtils.preCheckCast(r118, InAppSearchEntityParam.class, "com.obric.memorydata.plugin")).getScore();
        if (r119 == null) goto L126;
        long r213 = r31;
        double r62 = r119.getValue();
        r210 = r213;
    L128:
        if (Double.compare(r61, r62) >= 0) goto L131;
        r61 = r62;
        r43 = r118;
    L131:
        if (r42.hasNext() == false) goto L132;
        r31 = r210;
        goto L123
    L126:
        r210 = r31;
        r62 = 0.0d;
        goto L128
    L122:
        r61 = 0.0d;
        goto L123
    L140:
        r210 = r31;
    L79:
        r31 = -1;
        goto L81
    L56:
        r28 = r27.next();
        if (r27.hasNext() == true) goto L59;
        r110 = r2;
        goto L74
    L59:
        SearchScoreParam r63 = ((InAppSearchEntityParam) ZeusTransformUtils.preCheckCast(r28, InAppSearchEntityParam.class, "com.obric.memorydata.plugin")).getScore();
        if (r63 == null) goto L62;
        double r120 = r63.getValue();
    L63:
        r110 = r2;
        double r64 = r120;
    L64:
        Object r121 = r27.next();
        SearchScoreParam r122 = ((InAppSearchEntityParam) ZeusTransformUtils.preCheckCast(r121, InAppSearchEntityParam.class, "com.obric.memorydata.plugin")).getScore();
        if (r122 == null) goto L67;
        double r65 = r122.getValue();
    L69:
        if (Double.compare(r64, r65) >= 0) goto L71;
        r64 = r65;
        r28 = r121;
    L73:
        if (r27.hasNext() == false) goto L74;
        r110 = r110;
        goto L64
    L71:
        r28 = r28;
        goto L73
    L67:
        r65 = 0.0d;
        goto L69
    L62:
        r120 = 0.0d;
        goto L63
    L168:
        throw new NoWhenBranchMatchedException();
    L34:
        if (r0.a(r17, r16) == true) goto L37;
    L35:
        r110 = r2;
        goto L173
    L174:
        return r3;
    L20:
        if (r12.size() != 1) goto L24;
        if (Intrinsics.areEqual(((RewriteQuery) ZeusTransformUtils.preCheckCast(r12.get(0), RewriteQuery.class, "com.obric.memorydata.plugin")).getDomain(), "Photo") == false) goto L24;
        r13 = true;
        goto L25
    }

    private final List<SearchResultEntry> a(List<SearchResultEntry> r9, List<SearchResultEntry> r10, Set<Integer> r11) {
        List<SearchResultEntry> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        List r12 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        Set r13 = (Set) ZeusTransformUtils.wrapperContextForParams(r11, Set.class, "com.obric.memorydata.plugin");
        if (r8.isEmpty() == false) goto L5;
        return r8;
    L5:
        if (r12.isEmpty() == true) goto L51;
        Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.memorydata.plugin");
        Collection r15 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r16 = r14.iterator();
    L9:
        if (r16.hasNext() == false) goto L11;
        SearchResultEntry r1 = (SearchResultEntry) ZeusTransformUtils.preCheckCast(r16.next(), SearchResultEntry.class, "com.obric.memorydata.plugin");
        r15.add(TuplesKt.to(Long.valueOf(r1.getId()), Integer.valueOf(r1.getType())));
        goto L9
    L11:
        Set r17 = CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r15, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
        Iterable r18 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin");
        Collection r19 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r20 = r18.iterator();
    L13:
        if (r20.hasNext() == false) goto L38;
        Object r2 = r20.next();
        List<ct> r3 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getMemoryMapTableDao().queryByMemoryRawDbId(((SearchResultEntry) ZeusTransformUtils.preCheckCast(r2, SearchResultEntry.class, "com.obric.memorydata.plugin")).getId());
        boolean r4 = false;
        if (r3.isEmpty() == false) goto L17;
    L16:
        r4 = true;
    L35:
        if (r4 == false) goto L13;
        r19.add(r2);
        goto L13
    L17:
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, Collection.class) == true) goto L20;
    L22:
        Iterator r6 = r5.iterator();
    L24:
        if (r6.hasNext() == false) goto L21;
        ct r7 = (ct) ZeusTransformUtils.preCheckCast(r6.next(), ct.class, "com.obric.memorydata.plugin");
        if (r13.contains(Integer.valueOf(r7.b())) == true) goto L28;
    L30:
        boolean r21 = false;
    L31:
        if (r21 == false) goto L24;
        boolean r22 = true;
    L33:
        if (r22 == true) goto L35;
    L28:
        if (r17.contains(TuplesKt.to(Long.valueOf(r7.c()), Integer.valueOf(r7.b()))) == false) goto L30;
        r21 = true;
    L21:
        r22 = false;
        goto L33
    L20:
        if (((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L22;
    L38:
        return (List) ZeusTransformUtils.preCheckCast(r19, List.class, "com.obric.memorydata.plugin");
    L51:
        return r8;
    }

    private final Triple<List<SearchResultEntry>, List<SearchResultEntry>, List<SearchResultEntry>> a(List<SearchResultEntry> r9, List<SearchResultEntry> r10, List<SearchResultEntry> r11) {
        List r12 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        List r13 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        List r14 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        int r8 = i();
        if (r8 > 0) goto L7;
        r8 = 50;
    L7:
        if (((r12.size() + r13.size()) + r14.size()) > r8) goto L10;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "GlobalAssistantSearchSession", "total result count is matched", false, 4, null);
        return new Triple(r12, r13, r14);
    L10:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "GlobalAssistantSearchSession", "total result count is not matched", false, 4, null);
        int r0 = r8 / 3;
        int r2 = r8 % 3;
        int r3 = 0;
        if (r2 < 1) goto L13;
        int r5 = 1;
    L14:
        int r6 = Math.min(r5 + r0, r12.size());
        if (r2 < 2) goto L17;
        r3 = 1;
    L17:
        int r4 = Math.min(r3 + r0, r13.size());
        int r1 = Math.min(r0, r14.size());
        int r15 = r8 - ((r6 + r4) + r1);
        if (r15 > 0) goto L20;
    L22:
        if (r15 > 0) goto L24;
    L26:
        if (r15 <= 0) goto L31;
        if (r1 >= r14.size()) goto L31;
        r1 = r1 + Math.min(r15, r14.size() - r1);
    L31:
        return new Triple(CollectionsKt.take((Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.memorydata.plugin"), r6), CollectionsKt.take((Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.memorydata.plugin"), r4), CollectionsKt.take((Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.memorydata.plugin"), r1));
    L24:
        if (r4 >= r13.size()) goto L26;
        int r7 = Math.min(r15, r13.size() - r4);
        r15 = r15 - r7;
        r4 = r4 + r7;
        goto L26
    L20:
        if (r6 >= r12.size()) goto L22;
        int r16 = Math.min(r15, r12.size() - r6);
        r15 = r15 - r16;
        r6 = r6 + r16;
        goto L22
    L13:
        r5 = 0;
        goto L14
    }

    private final void a(int r7, String r8, String r9) {
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "GlobalAssistantSearchSession", r8, null, 4, null);
        GlobalAssistantSearchResponse r6 = this.p;
        r6.setCode(r7);
        r6.setMessage(r8);
    }

    public static final /* synthetic */ void a(a r0, KnowledgeGraphResponse r1) {
        r0.z = r1;
    }

    public static final /* synthetic */ void a(a r0, GlobalQUResult r1) {
        r0.o = r1;
    }

    public static final /* synthetic */ void a(a r0, TaskInfo r1, long r2, EntitySearchRecordInfo r4) {
        r0.a(r1, r2, r4);
    }

    private final void a(TaskInfo r12, long r13, EntitySearchRecordInfo r15) {
        List<SearchResultEntry> r3 = null;
        r3 = (List) ZeusTransformUtils.preCheckCast(u.a().fromJson(r12.e().getOutput().optString(MediaBrowserServiceCompat.KEY_SEARCH_RESULTS).toString(), new h().getType()), List.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L5 JsonParseException -> L7 JsonSyntaxException -> L10
    L12:
        if (r3 != null) goto L14;
        r3 = CollectionsKt.emptyList();     // Catch: Exception -> L5
    L14:
        a(r12.b(), r3);
        if (r3.isEmpty() == false) goto L19;
        a(r13, r15, r12);
        return;
    L19:
        if (Intrinsics.areEqual(r12.b(), "memory_search") == false) goto L22;
        this.s = r3;
    L47:
        a(r13, r15, r12);
        return;
    L22:
        if (Intrinsics.areEqual(r12.b(), "recommend_memory_search") == false) goto L24;
        this.t = r3;
        goto L47
    L24:
        List<SearchResultEntry> r0 = b(r3);
        List<SearchResultEntry> r2 = c(r3);
        if (Intrinsics.areEqual(r12.b(), "in_app_search_schedule") == false) goto L28;
        this.A = r12.e().getOutput().optString("entry_descriptions");
    L28:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L38;
        String r4 = (String) ZeusTransformUtils.preCheckCast(com.obric.memorydata.personalcontext.search.d.f12308a.e().get(r12.b()), String.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L38;
        if (this.q.get(r4) != null) goto L34;
        this.q.put(r4, (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin"));
    L34:
        List r5 = (List) ZeusTransformUtils.preCheckCast(this.q.get(r4), List.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L38;
        r5.addAll((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin"));
    L38:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r2, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L47;
        String r1 = (String) ZeusTransformUtils.preCheckCast(com.obric.memorydata.personalcontext.search.d.f12308a.e().get(r12.b()), String.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L47;
        if (this.r.get(r1) != null) goto L44;
        this.r.put(r1, (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin"));
    L44:
        List r6 = (List) ZeusTransformUtils.preCheckCast(this.r.get(r1), List.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L47;
        r6.addAll((Collection) ZeusTransformUtils.preCheckCast(r2, Collection.class, "com.obric.memorydata.plugin"));
        goto L47
    L5:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "GlobalAssistantSearchSession", "Error parsing search results: " + e.getMessage(), null, 4, null);
        a(r13, r15, r12);
        return;
    L10:
        e = move-exception;
        IRunLog r7 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L5
        String r8 = "GsonExt";
        String r9 = "toListObj error : " + e;     // Catch: Exception -> L5
    L9:
        IRunLog.a.b(r7, r8, r9, null, 4, null);     // Catch: Exception -> L5
    L7:
        e = move-exception;
        r7 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L5
        r8 = "GsonExt";
        r9 = "toListObj error : " + e;     // Catch: Exception -> L5
        goto L9
    }

    private final void a(String r12, List<SearchResultEntry> r13) {
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.memorydata.plugin");
        if (AppContext.INSTANCE.isDebug() == false) goto L5;
        RunLog.INSTANCE.debug("GlobalAssistantSearchSession", r12 + " search result entry: " + r11);
        return;
    L5:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "GlobalAssistantSearchSession", r12 + " search result entry: " + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("; ", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, $$Lambda$a$3ITepXuLeuAxPJZavH1Nfdd8Ay0.INSTANCE, 30, null), false, 4, null);
    }

    private final void a(final String r3, List<? extends Pair<SearchResultEntry, ? extends AppEntity>> r4, List<? extends MemoryEntity> r5) {
        List<? extends Pair<SearchResultEntry, ? extends AppEntity>> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        List<? extends MemoryEntity> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        final List<ImageUploadEntity> r8 = a(r6, 4);
        r8.addAll((Collection) ZeusTransformUtils.preCheckCast(b(r7, 4), Collection.class, "com.obric.memorydata.plugin"));
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r8, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L6;
        this.p.addExtra("hasPhotoHighSemantic", true);
        ThreadPoolContainer.Companion.getInstance().execute(new $$Lambda$a$eAec30p6AtXgyOzIAgn32hPag(r3, r8));
        return;
    }

    private final void a(List<SearchResultEntry> r11, List<SearchResultEntry> r12) {
        List r13 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        List r14 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
        if (com.obric.memorydata.personalcontext.log.a.f12229a.b() == true) goto L5;
        return;
    L5:
        RunLog.INSTANCE.debug("GlobalAssistantSearchSession", "handleSearchInfo InEvaluateMode");
        EvaluationResult r0 = com.obric.memorydata.personalcontext.log.a.f12229a.a();
        if (r0 == null) goto L23;
        r0.setType("searchGlobal");
        GlobalAssistantSearchEntityResult r3 = this.p.getEntityResult();
        if (r3 == null) goto L18;
        List<AppEntity> r4 = r3.getEntityList();
        if (r4 == null) goto L18;
        Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.memorydata.plugin");
        GlobalAssistantSearchMemoryResult r6 = this.p.getMemoryResult();
        if (r6 == null) goto L16;
        List<MemoryEntity> r7 = r6.getEntityList();
        if (r7 == null) goto L16;
    L17:
        List<? extends AppEntity> r8 = CollectionsKt.plus(r5, (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin"));
    L19:
        r0.addResultEntitiesList(r8);
        r0.addKGResultEntityList(d(this.v));
        r0.addQueryTimeCost(this.h);
        r0.addResultList(CollectionsKt.plus((Collection) ZeusTransformUtils.preCheckCast(r13, Collection.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.memorydata.plugin")));
        StringBuilder r9 = new StringBuilder().append('\n');
        GlobalQUResult r10 = this.o;
        if (r10 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("quResult");
        r10 = null;
    L22:
        r0.setQuResult(new AssistantQuResult(CollectionsKt.listOf(new QuAction(0, r9.append(r10.getQuery_rewrite()).append('\n').append(this.m).toString(), null, 0, 8, null))));
        this.m = new StringBuffer();
    L16:
        r7 = CollectionsKt.emptyList();
    L18:
        r8 = null;
    L23:
        boolean r15 = true;
        com.obric.memorydata.personalcontext.log.a.f12229a.a(true);
        if (com.obric.memorydata.personalcontext.log.a.f12229a.c() == false) goto L26;
    L30:
        String r16 = IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).getString("personal_context_search_control_params");
        long r17 = 1000;
        long r18 = System.currentTimeMillis() / r17;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r16, CharSequence.class, "com.obric.memorydata.plugin")).length() == 0) goto L34;
        r15 = false;
    L34:
        if (r15 == true) goto L42;
        String r19 = new JSONObject(r16).optString("changeDateTimeStamp", "");
        Intrinsics.checkNotNull(r19);
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r19, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L42;
        Long r110 = StringsKt.toLongOrNull(r19);
        if (r110 == null) goto L42;
        r18 = r110.longValue() / r17;
    L42:
        this.p.addExtra("phoneTimestamp", Long.valueOf(r18));
        return;
    L26:
        if (com.obric.memorydata.personalcontext.log.a.f12229a.f() == true) goto L30;
        if (com.obric.memorydata.personalcontext.log.a.f12229a.e() == true) goto L30;
        GlobalAssistantSearchResponse r111 = this.p;
        r111.setCode(0);
        r111.setMessage("evaluate data sets");
        r111.setEntityResult(new GlobalAssistantSearchEntityResult(CollectionsKt.emptyList(), 0, 2, null));
        r111.setKgResult(new GlobalAssistantSearchKgResult(CollectionsKt.emptyList()));
        r111.setMemoryResult(new GlobalAssistantSearchMemoryResult(CollectionsKt.emptyList()));
    }

    private final boolean a(AppEntity r10, SearchResultEntry r11) {
        if (ZeusTransformUtils.instanceOf(r10, PhotoEntity.class) == true) goto L6;
        return false;
    L6:
        if (com.obric.memorydata.personalcontext.util.c.f12363a.b() != EmbeddingState.USE_VLM) goto L8;
        boolean r9 = true;
    L10:
        if (r9 == false) goto L12;
        Double r12 = com.obric.memorydata.personalcontext.search.c.f12306a.a().getSecond();
    L13:
        double r3 = ((Number) ZeusTransformUtils.preCheckCast(r12, Number.class, "com.obric.memorydata.plugin")).doubleValue();
        Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast(r11.getInAppSearchParams(), Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r13, Collection.class) == true) goto L16;
    L18:
        Iterator r14 = r13.iterator();
    L20:
        if (r14.hasNext() == false) goto L59;
        InAppSearchEntityParam r15 = (InAppSearchEntityParam) ZeusTransformUtils.preCheckCast(r14.next(), InAppSearchEntityParam.class, "com.obric.memorydata.plugin");
        int r5 = b.f12320a[((PhotoEntity) ZeusTransformUtils.preCheckCast(r10, PhotoEntity.class, "com.obric.memorydata.plugin")).getAssetType().ordinal()];
        if (r5 == 1) goto L39;
        if (r5 == 2) goto L27;
    L25:
        boolean r16 = false;
    L50:
        if (r16 == false) goto L20;
        return true;
    L27:
        if (r15.isSemantic() == false) goto L25;
        if (Intrinsics.areEqual(r15.getField(), "PhotoEntity_VideoFrame_file") == false) goto L25;
        SearchScoreParam r17 = r15.getScore();
        if (r17 != null) goto L33;
    L35:
        boolean r18 = false;
    L36:
        if (r18 == false) goto L25;
    L49:
        r16 = true;
        goto L50
    L33:
        if (r17.getValue() <= 0.39d) goto L35;
        r18 = true;
        goto L36
    L39:
        if (r15.isSemantic() == false) goto L25;
        if (Intrinsics.areEqual(r15.getField(), "PhotoEntity_file") == false) goto L25;
        SearchScoreParam r19 = r15.getScore();
        if (r19 != null) goto L45;
    L47:
        boolean r110 = false;
    L48:
        if (r110 == false) goto L25;
    L45:
        if (r19.getValue() <= r3) goto L47;
        r110 = true;
        goto L48
    L59:
        return false;
    L16:
        if (((Collection) ZeusTransformUtils.preCheckCast(r13, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L18;
        return false;
    L12:
        r12 = com.obric.memorydata.personalcontext.search.c.f12306a.a().getFirst();
        goto L13
    L8:
        r9 = false;
        goto L10
    }

    public static final /* synthetic */ List b(a r0) {
        return r0.x;
    }

    private final List<ImageUploadEntity> b(List<? extends MemoryEntity> r20, int r21) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r20, List.class, "com.obric.memorydata.plugin");
        List<ImageUploadEntity> r2 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin");
        boolean r4 = true;
        int r5 = 0;
        if (r3 != null) goto L5;
    L8:
        boolean r6 = true;
    L9:
        if (r6 == false) goto L11;
        return r2;
    L11:
        List<RewriteQuery> r7 = this.n;
        if (r7 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("filterQueryRewrite");
        r7 = null;
    L14:
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r8, Collection.class) == true) goto L17;
    L19:
        Iterator r9 = r8.iterator();
    L21:
        if (r9.hasNext() == false) goto L18;
        RewriteQuery r10 = (RewriteQuery) ZeusTransformUtils.preCheckCast(r9.next(), RewriteQuery.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r10.getDomain(), "Memory") == true) goto L25;
    L27:
        boolean r11 = false;
    L28:
        if (r11 == false) goto L21;
    L29:
        if (r4 == false) goto L43;
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L32:
        if (r1.hasNext() == false) goto L43;
        MemoryEntity r12 = (MemoryEntity) ZeusTransformUtils.preCheckCast(r1.next(), MemoryEntity.class, "com.obric.memorydata.plugin");
        if (r5 >= r21) goto L32;
        FileEntity r13 = r12.getScreenshot();
        if (r13 == null) goto L32;
        Uri r14 = r13.getContentUrl();
        if (r14 == null) goto L32;
        String r15 = r14.getLastPathSegment();
        if (r15 == null) goto L32;
        URI r16 = new URI("file", null, new File(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getFilesDir() + "/MemoryImage", r15).getAbsolutePath(), null);
        int r17 = r12.getType();
        String r18 = r12.getId();
        String r19 = r16.toString();
        Intrinsics.checkNotNullExpressionValue(r19, "toString(...)");
        r2.add(new ImageUploadEntity(r17, r18, r19, BuildConfig.LIBRARY_PACKAGE_NAME, false, null, 32, null));
        r5 = r5 + 1;
    L43:
        return r2;
    L25:
        if (Intrinsics.areEqual(r10.getSubDomain(), SetsKt.setOf("MemoryMark")) == false) goto L27;
        r11 = true;
    L18:
        r4 = false;
        goto L29
    L17:
        if (((Collection) ZeusTransformUtils.preCheckCast(r8, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L19;
    L5:
        if (r3.isEmpty() == true) goto L8;
        r6 = false;
        goto L9
    }

    private final void b(long r5) {
        EntitySearchRecordInfo r0 = this.h;
        if (r0 == null) goto L5;
        r0.setStageResultHandleCost(System.currentTimeMillis() - r5);
    L5:
        EntitySearchRecordInfo r6 = this.h;
        if (r6 == null) goto L8;
        r6.setQueryTotalCost(System.currentTimeMillis() - r6.getStartTime());
    L8:
        com.obric.memorydata.database.util.b.f9624a.a(this.h);
    }

    private final void b(String r5) {
        JSONObject r0 = new JSONObject();
        r0.put("inputQuery", r5);
        ((TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(new TaskRequest.Builder("personal_context_kg_retrieval").setInputParam(r0), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setExecuteImmediately(true), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setForegroundCallerPkg(AppInfo.OAssistant.getPackageName()), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setTaskInfoCallback(a(System.currentTimeMillis())), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin")).enqueue();
    }

    private static final void b(String r2, List r3) {
        List<ImageUploadEntity> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.middleware.impl.image.a.f11712a.a(r2, r4, ImageXBizType.DOUBAO);
    }

    private final void b(List<AppEntity> r6, List<KGSourceEntity> r7) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        EntityIndexEngine r9 = s.a();
        if (r8 == null) goto L14;
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L6:
        if (r10.hasNext() == false) goto L24;
        KGSourceEntity r1 = (KGSourceEntity) ZeusTransformUtils.preCheckCast(r10.next(), KGSourceEntity.class, "com.obric.memorydata.plugin");
        IAppEntityRawDbDao<com.obric.memorydata.database.entity.d> r2 = r9.getRawDaoByEntityType(r1.getEntityType());
        if (r2 == null) goto L6;
        com.obric.memorydata.database.entity.d r3 = (com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast(r2.queryById(r1.getId()), com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L6;
        AppEntity r4 = com.obric.memorydata.personalcontext.poison.g.f12254a.a(r3, r2);
        if (r4 == null) goto L6;
        r5.add(r4);
        goto L6
    L24:
        return;
    }

    public static final /* synthetic */ List c(a r0) {
        return r0.v;
    }

    private final void c(CountDownLatch r10) {
        kotlinx.coroutines.i.a(am.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin")), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AbstractGlobalAssistantSearchSession$executeQueryUnderStanding$1(this, r10, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    private final List<AppEntity> d(List<KGSourceIndex> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        List<AppEntity> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        b(r0, ((KGSourceIndex) ZeusTransformUtils.preCheckCast(r7.next(), KGSourceIndex.class, "com.obric.memorydata.plugin")).getRelation());
        goto L4
    L6:
        return r0;
    }

    private final void e(List<RewriteQuery> r5) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        JSONObject r6 = new JSONObject();
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r7.hasNext() == false) goto L9;
        RewriteQuery r1 = (RewriteQuery) ZeusTransformUtils.preCheckCast(r7.next(), RewriteQuery.class, "com.obric.memorydata.plugin");
        StringBuilder r2 = new StringBuilder().append(r1.getDomain());
        Object r3 = r1.getSubDomain();
        if (r3 != null) goto L8;
        r3 = "";
    L8:
        r6.put(r2.append(r3).toString(), r1.getQuery());
        goto L4
    L9:
        RunLog.INSTANCE.debug("GlobalAssistantSearchSession", "query domain info: " + r6);
    }

    private final List<RewriteQuery> f(List<RewriteQuery> r13) {
        List r12 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.memorydata.plugin");
        Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.memorydata.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r15 = r14.iterator();
    L4:
        if (r15.hasNext() == false) goto L8;
        Object r2 = r15.next();
        if (Intrinsics.areEqual(((RewriteQuery) ZeusTransformUtils.preCheckCast(r2, RewriteQuery.class, "com.obric.memorydata.plugin")).getDomain(), "Memory") == false) goto L4;
        r1.add(r2);
        goto L4
    L8:
        Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Map r3 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Iterator r17 = r16.iterator();
    L10:
        if (r17.hasNext() == false) goto L15;
        Object r4 = r17.next();
        String r5 = ((RewriteQuery) ZeusTransformUtils.preCheckCast(r4, RewriteQuery.class, "com.obric.memorydata.plugin")).getQuery();
        Object r6 = r3.get(r5);
        if (r6 != null) goto L14;
        r6 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        r3.put(r5, r6);
    L14:
        ((List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.memorydata.plugin")).add(r4);
        goto L10
    L15:
        Collection r18 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(r3.size()), Collection.class, "com.obric.memorydata.plugin");
        Iterator r7 = r3.entrySet().iterator();
    L17:
        if (r7.hasNext() == false) goto L26;
        Map.Entry r8 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r9 = (String) ZeusTransformUtils.preCheckCast(r8.getKey(), String.class, "com.obric.memorydata.plugin");
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r8.getValue(), List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r11 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r19 = r10.iterator();
    L20:
        if (r19.hasNext() == false) goto L25;
        Set<String> r20 = ((RewriteQuery) ZeusTransformUtils.preCheckCast(r19.next(), RewriteQuery.class, "com.obric.memorydata.plugin")).getSubDomain();
        if (r20 != null) goto L24;
        r20 = SetsKt.emptySet();
    L24:
        CollectionsKt.addAll(r11, (Iterable) ZeusTransformUtils.preCheckCast(r20, Iterable.class, "com.obric.memorydata.plugin"));
        goto L20
    L25:
        r18.add(new RewriteQuery("Memory", r9, null, CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r11, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")), 4, null));
        goto L17
    L26:
        List r110 = (List) ZeusTransformUtils.preCheckCast(r18, List.class, "com.obric.memorydata.plugin");
        Iterable r111 = (Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.memorydata.plugin");
        Collection r21 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r112 = r111.iterator();
    L28:
        if (r112.hasNext() == false) goto L33;
        Object r22 = r112.next();
        if ((!Intrinsics.areEqual(((RewriteQuery) ZeusTransformUtils.preCheckCast(r22, RewriteQuery.class, "com.obric.memorydata.plugin")).getDomain(), "Memory")) == false) goto L28;
        r21.add(r22);
        goto L28
    L33:
        return CollectionsKt.plus((Collection) ZeusTransformUtils.preCheckCast(r110, Collection.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r21, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
    }

    private final String k() {
        JSONObject r2 = new JSONObject();
        r2.put("performRanking", false);
        r2.put("search_type", "global_search");
        r2.put("embedding_type", com.obric.memorydata.personalcontext.util.c.f12363a.c());
        String r3 = r2.toString();
        Intrinsics.checkNotNullExpressionValue(r3, "toString(...)");
        return r3;
    }

    private final GlobalAssistantSearchResponse l() {
        long r7 = System.currentTimeMillis();
        List<SearchResultEntry> r10 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        if (this.q.isEmpty() == true) goto L5;
    L13:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "GlobalAssistantSearchSession", "noneSemanticAllResultEntries: " + u.a(this.q), null, 4, null);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "GlobalAssistantSearchSession", "semanticAllResultEntries: " + u.a(this.r), null, 4, null);
        r10.addAll((Collection) ZeusTransformUtils.preCheckCast(com.obric.memorydata.personalcontext.search.c.a(com.obric.memorydata.personalcontext.search.c.f12306a, this.q, this.r, 0, 4, null), Collection.class, "com.obric.memorydata.plugin"));
        Triple<List<SearchResultEntry>, List<SearchResultEntry>, List<SearchResultEntry>> r0 = a(r10, a(this, this.s, r10, null, 4, null), this.t);
        List r1 = (List) ZeusTransformUtils.preCheckCast(r0.component1(), List.class, "com.obric.memorydata.plugin");
        List r2 = (List) ZeusTransformUtils.preCheckCast(r0.component2(), List.class, "com.obric.memorydata.plugin");
        List<SearchResultEntry> r3 = (List) ZeusTransformUtils.preCheckCast(r0.component3(), List.class, "com.obric.memorydata.plugin");
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin");
        Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r6 = r4.iterator();
    L14:
        boolean r12 = true;
        if (r6.hasNext() == false) goto L22;
        Object r8 = r6.next();
        if (((SearchResultEntry) ZeusTransformUtils.preCheckCast(r8, SearchResultEntry.class, "com.obric.memorydata.plugin")).getType() == 1501) goto L20;
        r12 = false;
    L20:
        if (r12 == false) goto L14;
        r5.add(r8);
        goto L14
    L22:
        List r9 = (List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.memorydata.plugin");
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin");
        Collection r13 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r14 = r11.iterator();
    L24:
        if (r14.hasNext() == false) goto L31;
        Object r15 = r14.next();
        if (((SearchResultEntry) ZeusTransformUtils.preCheckCast(r15, SearchResultEntry.class, "com.obric.memorydata.plugin")).getType() != 1501) goto L28;
        boolean r16 = true;
    L29:
        if (r16 == true) goto L24;
        r13.add(r15);
        goto L24
    L28:
        r16 = false;
        goto L29
    L31:
        List<SearchResultEntry> r17 = (List) ZeusTransformUtils.preCheckCast(r13, List.class, "com.obric.memorydata.plugin");
        List<SearchResultEntry> r18 = CollectionsKt.plus((Collection) ZeusTransformUtils.preCheckCast(r1, Collection.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin"));
        List<Pair<SearchResultEntry, AppEntity>> r19 = com.obric.memorydata.personalcontext.search.g.INSTANCE.loadAppEntityPairBySearchResultEntries(r18, this.A);
        Iterable r20 = (Iterable) ZeusTransformUtils.preCheckCast(r19, Iterable.class, "com.obric.memorydata.plugin");
        Collection r21 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r20, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r22 = r20.iterator();
    L33:
        if (r22.hasNext() == false) goto L35;
        r21.add((AppEntity) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(r22.next(), Pair.class, "com.obric.memorydata.plugin")).getSecond(), AppEntity.class, "com.obric.memorydata.plugin"));
        goto L33
    L35:
        List r23 = (List) ZeusTransformUtils.preCheckCast(r21, List.class, "com.obric.memorydata.plugin");
        List<MemoryEntity> r24 = com.obric.memorydata.personalcontext.search.g.INSTANCE.loadMemoryEntityBySearchResultEntry(r17);
        List<ProactiveMemoryEntity> r25 = a(r3);
        GlobalQUResult r110 = null;
        if (r23.isEmpty() == true) goto L38;
    L46:
        a(this.f, r19, r24);
        this.p.setEntityResult(new GlobalAssistantSearchEntityResult(r23, 0, 2, null));
        this.p.setKgResult(new GlobalAssistantSearchKgResult(this.j));
        this.p.setDomainResult(new GlobalAssistantSearchDomainResult(this.u));
        this.p.setProactiveRecommendationResult(new ProactiveRecommendationSearchResult(CollectionsKt.emptyList(), r25));
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r24, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L49;
        this.p.setMemoryResult(new GlobalAssistantSearchMemoryResult(r24));
    L49:
        a(r18, r17);
        b(r7);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "GlobalAssistantSearchSession", "global assistant search response: " + u.a(this.p), null, 4, null);
    L12:
        return this.p;
    L38:
        if (r24.isEmpty() == false) goto L46;
        if (r25.isEmpty() == false) goto L46;
        String r26 = "Fail to load app entities by search result entries: " + CollectionsKt.plus((Collection) ZeusTransformUtils.preCheckCast(CollectionsKt.plus((Collection) ZeusTransformUtils.preCheckCast(r10, Collection.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(this.s, Iterable.class, "com.obric.memorydata.plugin")), Collection.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(this.t, Iterable.class, "com.obric.memorydata.plugin"));
        GlobalQUResult r27 = this.o;
        if (r27 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("quResult");
    L45:
        a(1006, r26, r110.getOrigin_query());
        goto L12
    L44:
        r110 = r27;
        goto L45
    L5:
        if (this.r.isEmpty() == false) goto L13;
        if (this.s.isEmpty() == false) goto L13;
        if (this.t.isEmpty() == false) goto L13;
        a((List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin"), (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin"));
        goto L12
    }

    public static /* synthetic */ CharSequence lambda$3ITepXuLeuAxPJZavH1Nfdd8Ay0(SearchResultEntry r0) {
        return a(r0);
    }

    /* JADX INFO: renamed from: lambda$eAec30p6-AtXgyOzIAgn-32hPag, reason: not valid java name */
    public static /* synthetic */ void m1095lambda$eAec30p6AtXgyOzIAgn32hPag(String r0, List r1) {
        b(r0, r1);
    }

    public com.obric.memorydata.task.scheduler.c a(RewriteQuery r2, long r3, EntitySearchRecordInfo r5) {
        Intrinsics.checkNotNullParameter(r2, "rewriteQuery");
        Intrinsics.checkNotNullParameter(r5, "entitySearchRecordInfo");
        return (com.obric.memorydata.task.scheduler.c) ZeusTransformUtils.preCheckCast(new f(r5, this, r3), com.obric.memorydata.task.scheduler.c.class, "com.obric.memorydata.plugin");
    }

    public abstract Object a(Continuation<? super GlobalQUResult> r1);

    public final List<String> a() {
        return this.j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final List<ProactiveMemoryEntity> a(List<SearchResultEntry> r6) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "searchResultEntries");
        List<ProactiveMemoryEntity> r7 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r8.hasNext() == false) goto L17;
        SearchResultEntry r1 = (SearchResultEntry) ZeusTransformUtils.preCheckCast(r8.next(), SearchResultEntry.class, "com.obric.memorydata.plugin");
        IAppEntityRawDbDao<com.obric.memorydata.database.entity.d> r2 = s.a().getRawDaoByEntityType(r1.getType());
        if (r2 == null) goto L4;
        com.obric.memorydata.database.entity.d r3 = (com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast(r2.queryById(r1.getId()), com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L4;
        if (ZeusTransformUtils.instanceOf(r3, EpisodicMemoryEntity.class) == false) goto L4;
        AppEntity r4 = com.obric.memorydata.personalcontext.poison.g.f12254a.a(r3, r2);
        if (r4 == null) goto L4;
        if (ZeusTransformUtils.instanceOf(r4, ProactiveMemoryEntity.class) == false) goto L4;
        r7.add(r4);
        goto L4
    L17:
        return r7;
    }

    public final void a(long r16, EntitySearchRecordInfo r18, TaskInfo r19) {
        Intrinsics.checkNotNullParameter(r18, "entitySearchRecordInfo");
        Intrinsics.checkNotNullParameter(r19, "taskInfo");
        long r5 = System.currentTimeMillis();
        double r9 = r5 - r16;
        this.w.add(Double.valueOf(r9));
        com.obric.memorydata.personalcontext.search.g.trackSearchPerfInfo$default(com.obric.memorydata.personalcontext.search.g.INSTANCE, r18, r16, r5, r9, r19.e(), false, 32, null);
    }

    public final void a(String r1) {
        this.A = r1;
    }

    public final void a(CountDownLatch r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.f12319b = r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:89:0x0351 -> B:90:0x035b). Please report as a decompilation issue!!! */
    public final Object b(Continuation<? super GlobalAssistantSearchResponse> r34) {
        a r0 = this;
        Continuation r3 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r34, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, AbstractGlobalAssistantSearchSession$executeSearchWithoutHandleResults$1.class) == false) goto L7;
        AbstractGlobalAssistantSearchSession$executeSearchWithoutHandleResults$1 r5 = (AbstractGlobalAssistantSearchSession$executeSearchWithoutHandleResults$1) ZeusTransformUtils.preCheckCast(r3, AbstractGlobalAssistantSearchSession$executeSearchWithoutHandleResults$1.class, "com.obric.memorydata.plugin");
        if ((r5.label & Integer.MIN_VALUE) == 0) goto L7;
        r5.label -= Integer.MIN_VALUE;
    L8:
        Object r4 = r5.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r5.label;
        if (r6 == 0) goto L16;
        if (r6 == 1) goto L15;
        if (r6 != 2) goto L14;
        long r1 = r5.J$1;
        long r7 = r5.J$0;
        String r8 = (String) ZeusTransformUtils.preCheckCast(r5.L$6, String.class, "com.obric.memorydata.plugin");
        RewriteQuery r11 = (RewriteQuery) ZeusTransformUtils.preCheckCast(r5.L$5, RewriteQuery.class, "com.obric.memorydata.plugin");
        Iterator r12 = (Iterator) ZeusTransformUtils.preCheckCast(r5.L$4, Iterator.class, "com.obric.memorydata.plugin");
        Map r9 = (Map) ZeusTransformUtils.preCheckCast(r5.L$3, Map.class, "com.obric.memorydata.plugin");
        ArrayList r10 = (ArrayList) ZeusTransformUtils.preCheckCast(r5.L$2, ArrayList.class, "com.obric.memorydata.plugin");
        List<? extends AbsTaskRequest> r2 = (List) ZeusTransformUtils.preCheckCast(r5.L$1, List.class, "com.obric.memorydata.plugin");
        a r14 = (a) ZeusTransformUtils.preCheckCast(r5.L$0, a.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r4);
        AbstractGlobalAssistantSearchSession$executeSearchWithoutHandleResults$1 r15 = r5;
        long r22 = r7;
        String r16 = r8;
        RewriteQuery r17 = r11;
        Iterator r18 = r12;
        Object r19 = r13;
        long r25 = r1;
        Map r110 = r9;
        ArrayList r111 = r10;
    L91:
        if (((BaseResponse) ZeusTransformUtils.preCheckCast(r4, BaseResponse.class, "com.obric.memorydata.plugin")).getCode() == 0) goto L95;
        RewriteQuery r20 = r17;
    L155:
        String r21 = "error: model is not ready: " + r20.getDomain();
        GlobalQUResult r23 = r14.o;
        if (r23 != null) goto L158;
        Intrinsics.throwUninitializedPropertyAccessException("quResult");
        r23 = null;
    L158:
        r14.a(1005, r21, r23.getOrigin_query());
        return r14.p;
    L95:
        if (B.contains(r17.getDomain()) == false) goto L97;
        AbstractGlobalAssistantSearchSession$executeSearchWithoutHandleResults$1 r33 = r15;
        String r24 = null;
        String r112 = null;
        char r113 = 2;
    L150:
        r111.add(Boxing.boxLong(System.currentTimeMillis() - r25));
        ArrayList r26 = r111;
        AbsTaskRequest r27 = a(r14, r17, r16, r14.g, r24, null, 16, null);
        if (r27 == null) goto L153;
        r2.add(r27);
    L153:
        r15 = r33;
        Object r114 = r19;
        Iterator r115 = r18;
        ArrayList r116 = r26;
        Map r28 = r110;
        long r117 = r22;
    L83:
        if (r115.hasNext() == false) goto L160;
        r20 = (RewriteQuery) ZeusTransformUtils.preCheckCast(r115.next(), RewriteQuery.class, "com.obric.memorydata.plugin");
        long r29 = System.currentTimeMillis();
        String r30 = (String) ZeusTransformUtils.preCheckCast(com.obric.memorydata.personalcontext.search.d.f12308a.d().get(r20.getDomain()), String.class, "com.obric.memorydata.plugin");
        if (r30 == null) goto L155;
        com.obric.memorydata.aikernelcore.h r31 = com.obric.memorydata.aikernelcore.h.f8481a;
        r15.L$0 = r14;
        r15.L$1 = r2;
        r15.L$2 = r116;
        r15.L$3 = r28;
        r15.L$4 = r115;
        r15.L$5 = r20;
        r15.L$6 = r30;
        r15.J$0 = r117;
        r15.J$1 = r29;
        Map r210 = r28;
        r15.label = 2;
        r25 = r29;
        Object r211 = r114;
        r18 = r115;
        Object r32 = com.obric.memorydata.aikernelcore.h.a(r31, r30, false, null, r15, 6, null);
        if (r32 != r211) goto L89;
        return r211;
    L89:
        r16 = r30;
        r4 = r32;
        r22 = r117;
        r111 = r116;
        r110 = r210;
        r19 = r211;
        r17 = r20;
        goto L91
    L160:
        RunLog.INSTANCE.debug("GlobalAssistantSearchSession", "check model costSum: " + CollectionsKt.sumOfLong((Iterable) ZeusTransformUtils.preCheckCast(r116, Iterable.class, "com.obric.memorydata.plugin")));
        new com.obric.memorydata.task.b.a().a(r2).a((com.obric.memorydata.task.impl.g) ZeusTransformUtils.preCheckCast(new com.obric.memorydata.task.impl.f(10), com.obric.memorydata.task.impl.g.class, "com.obric.memorydata.plugin")).a().b();
        r14.e().await(10, TimeUnit.SECONDS);     // Catch: InterruptedException -> L163
    L165:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r14.x, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L169;
        double r35 = CollectionsKt.maxOrThrow((Iterable) ZeusTransformUtils.preCheckCast(r14.x, Iterable.class, "com.obric.memorydata.plugin"));
        EntitySearchRecordInfo r36 = r14.h;
        if (r36 == null) goto L169;
        r36.setKgQueryCost(r35);
    L169:
        EntitySearchRecordInfo r37 = r14.h;
        if (r37 == null) goto L173;
        r37.setStageTaskExecuteCost(System.currentTimeMillis() - r117);
    L173:
        return r14.p;
    L163:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "GlobalAssistantSearchSession", "search task wait timeout", null, 4, null);
        goto L165
    L97:
        String r38 = "Memory";
        if (Intrinsics.areEqual(r17.getDomain(), "Memory") == false) goto L137;
        if (r110 == null) goto L124;
        Collection r39 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r40 = r110.entrySet().iterator();
    L102:
        if (r40.hasNext() == false) goto L123;
        Map.Entry r41 = (Map.Entry) ZeusTransformUtils.preCheckCast(r40.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r118 = (String) ZeusTransformUtils.preCheckCast(r41.getKey(), String.class, "com.obric.memorydata.plugin");
        List r42 = (List) ZeusTransformUtils.preCheckCast(r41.getValue(), List.class, "com.obric.memorydata.plugin");
        AbstractGlobalAssistantSearchSession$executeSearchWithoutHandleResults$1 r310 = r15;
        String r119 = r38;
        Iterator r212 = r40;
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r118, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(r38, CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == false) goto L121;
        Iterable r43 = (Iterable) ZeusTransformUtils.preCheckCast(D, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r43, Collection.class) == true) goto L108;
    L110:
        Iterator r44 = r43.iterator();
    L112:
        if (r44.hasNext() == false) goto L117;
        String r311 = r118;
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r118, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r44.next(), String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == true) goto L115;
        r118 = r311;
        goto L112
    L115:
        boolean r45 = true;
    L118:
        if (r45 == true) goto L121;
        List r46 = r42;
    L122:
        CollectionsKt.addAll(r39, (Iterable) ZeusTransformUtils.preCheckCast(r46, Iterable.class, "com.obric.memorydata.plugin"));
        r15 = r310;
        r38 = r119;
        r40 = r212;
        goto L102
    L117:
        r45 = false;
        goto L118
    L108:
        if (((Collection) ZeusTransformUtils.preCheckCast(r43, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L110;
        r45 = false;
    L121:
        r46 = CollectionsKt.emptyList();
        goto L122
    L123:
        r33 = r15;
        r112 = null;
        r113 = 2;
        List r47 = (List) ZeusTransformUtils.preCheckCast(r39, List.class, "com.obric.memorydata.plugin");
    L125:
        if (r47 != null) goto L128;
        r47 = CollectionsKt.emptyList();
    L128:
        if (r47.isEmpty() == false) goto L130;
        RunLog.INSTANCE.debug("GlobalAssistantSearchSession", "No Memory-related slot results found");
    L130:
        boolean r48 = !((Collection) ZeusTransformUtils.preCheckCast(r47, Collection.class, "com.obric.memorydata.plugin")).isEmpty();
        Object r49 = r47;
        if (r48 == true) goto L134;
        r49 = r112;
    L134:
        if (r49 == null) goto L136;
        String r50 = GsonUtil.INSTANCE.toJson(r49);
    L149:
        r24 = r50;
        goto L150
    L136:
        r24 = r112;
        goto L150
    L124:
        r33 = r15;
        r112 = null;
        r113 = 2;
        r47 = null;
        goto L125
    L137:
        r33 = r15;
        r112 = null;
        r113 = 2;
        String r51 = (String) ZeusTransformUtils.preCheckCast(q.f12255a.j().get(r17.getDomain()), String.class, "com.obric.memorydata.plugin");
        if (r51 == null) goto L146;
        if (r110 == null) goto L141;
        List r52 = (List) ZeusTransformUtils.preCheckCast(r110.get(r51), List.class, "com.obric.memorydata.plugin");
    L142:
        if (r52 == null) goto L146;
        BertQUAction r53 = (BertQUAction) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(r52), BertQUAction.class, "com.obric.memorydata.plugin");
        if (r53 == null) goto L146;
        r50 = u.a(r53);
    L147:
        if (r50 != null) goto L149;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "GlobalAssistantSearchSession", "No slot result found for domain " + r17.getDomain() + ", will proceed without slot result", null, 4, null);
        goto L149
    L141:
        r52 = null;
    L146:
        r50 = null;
        goto L147
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r0 = (a) ZeusTransformUtils.preCheckCast(r5.L$0, a.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r4);
        Object r54 = r4;
        long r55 = 10;
        List<RewriteQuery> r120 = null;
    L26:
        if (((BaseResponse) ZeusTransformUtils.preCheckCast(r54, BaseResponse.class, "com.obric.memorydata.plugin")).getCode() == 0) goto L29;
        r0.a(1005, "error: kg model is not ready: personal_context_kg_retrieval", r0.g);
        return r0.p;
    L29:
        r0.b(r0.g);
    L31:
        a r56 = r0;
        r56.f().await(r55, TimeUnit.SECONDS);     // Catch: InterruptedException -> L34
    L35:
        EntitySearchRecordInfo r57 = r56.h;
        if (r57 == null) goto L38;
        r57.setStageQueryUnderstandingCost(System.currentTimeMillis() - r56.d);
    L38:
        long r58 = System.currentTimeMillis();
        GlobalQUResult r59 = r56.o;
        if (r59 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("quResult");
        r59 = r120;
    L41:
        List<RewriteQuery> r60 = r56.a(r59);
        r56.n = r60;
        if (r60 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("filterQueryRewrite");
        r60 = r120;
    L44:
        r56.e(r60);
        List<RewriteQuery> r61 = r56.n;
        if (r61 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("filterQueryRewrite");
        r61 = r120;
    L48:
        if (r61.isEmpty() == false) goto L51;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "GlobalAssistantSearchSession", "global assistant search filterQueryRewrite is empty, because no permission!", null, 4, null);
        r56.p.setMessage("assistant no search permission");
        return r56.p;
    L51:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "GlobalAssistantSearchSession", "global assistant search kgSwitchOn: " + r56.y, false, 4, null);
        List<RewriteQuery> r121 = r56.n;
        if (r121 != null) goto L54;
        Intrinsics.throwUninitializedPropertyAccessException("filterQueryRewrite");
        r121 = r120;
    L54:
        r56.a(new CountDownLatch(r121.size()));
        EntitySearchRecordInfo r62 = r56.h;
        if (r62 == null) goto L57;
        r62.setStageSearchParamPrepareCost(System.currentTimeMillis() - r58);
    L57:
        long r63 = System.currentTimeMillis();
        List<? extends AbsTaskRequest> r122 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        ArrayList r123 = new ArrayList();
        GlobalQUResult r64 = r56.o;
        GlobalQUResult r65 = r64;
        if (r64 != null) goto L60;
        Intrinsics.throwUninitializedPropertyAccessException("quResult");
        r65 = r120;
    L60:
        String r66 = r65.getSlot_result();
        if (r66 != null) goto L178;
    L77:
        Map r67 = null;
    L78:
        List<RewriteQuery> r68 = r56.n;
        if (r68 != null) goto L81;
        Intrinsics.throwUninitializedPropertyAccessException("filterQueryRewrite");
        r68 = null;
    L81:
        r28 = r67;
        r15 = r5;
        r14 = r56;
        r116 = r123;
        r115 = ((Iterable) ZeusTransformUtils.preCheckCast(r68, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        r2 = r122;
        r114 = r13;
        r117 = r63;
        goto L83
    L178:
        List<RewriteQuery> r69 = (List) ZeusTransformUtils.preCheckCast(u.a().fromJson(r66, new g().getType()), List.class, "com.obric.memorydata.plugin");     // Catch: JsonParseException -> L64 JsonSyntaxException -> L66
    L69:
        if (r69 == null) goto L77;
        Iterable r70 = (Iterable) ZeusTransformUtils.preCheckCast(r69, Iterable.class, "com.obric.memorydata.plugin");
        r67 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Iterator r71 = r70.iterator();
    L72:
        if (r71.hasNext() == false) goto L78;
        Object r72 = r71.next();
        String r73 = ((BertQUAction) ZeusTransformUtils.preCheckCast(r72, BertQUAction.class, "com.obric.memorydata.plugin")).getActionName();
        Object r124 = r67.get(r73);
        if (r124 != null) goto L76;
        r124 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        r67.put(r73, r124);
    L76:
        ((List) ZeusTransformUtils.preCheckCast(r124, List.class, "com.obric.memorydata.plugin")).add(r72);
        goto L72
    L66:
        e = e;
        IRunLog r213 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r74 = new StringBuilder();
    L68:
        IRunLog.a.b(r213, "GsonExt", r74.append("toListObj error : ").append(e).toString(), null, 4, null);
        r69 = r120;
    L64:
        e = e;
        r213 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r74 = new StringBuilder();
    L34:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "GlobalAssistantSearchSession", "qu or kg wait timeout", null, 4, null);
        goto L35
    L16:
        ResultKt.throwOnFailure(r4);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "GlobalAssistantSearchSession", "global assistant start search", false, 4, null);
        if (r0.y == false) goto L19;
        CountDownLatch r75 = new CountDownLatch(2);
    L20:
        r0.b(r75);
        r0.c(f());
        if (r0.y == false) goto L30;
        com.obric.memorydata.aikernelcore.h r76 = com.obric.memorydata.aikernelcore.h.f8481a;
        r5.L$0 = r0;
        r5.label = 1;
        r120 = null;
        r55 = 10;
        r54 = com.obric.memorydata.aikernelcore.h.a(r76, "personal_context_kg_retrieval", false, null, r5, 6, null);
        if (r54 != r13) goto L26;
        return r13;
    L30:
        r55 = 10;
        r120 = null;
        goto L31
    L19:
        r75 = new CountDownLatch(1);
    L7:
        r5 = new AbstractGlobalAssistantSearchSession$executeSearchWithoutHandleResults$1(r0, r3);
        goto L8
    }

    public final List<String> b() {
        return this.k;
    }

    public final List<SearchResultEntry> b(List<SearchResultEntry> r9) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "result");
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin");
        Collection r11 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L40;
        Object r1 = r12.next();
        SearchResultEntry r2 = (SearchResultEntry) ZeusTransformUtils.preCheckCast(r1, SearchResultEntry.class, "com.obric.memorydata.plugin");
        boolean r4 = true;
        if (r2.getInAppSearchParams().isEmpty() == true) goto L37;
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(r2.getInAppSearchParams(), Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, Collection.class) == true) goto L11;
    L13:
        Iterator r5 = r3.iterator();
    L15:
        if (r5.hasNext() == false) goto L12;
        if (((InAppSearchEntityParam) ZeusTransformUtils.preCheckCast(r5.next(), InAppSearchEntityParam.class, "com.obric.memorydata.plugin")).isSemantic() == false) goto L15;
        boolean r6 = true;
    L19:
        if (r6 == false) goto L37;
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(r2.getInAppSearchParams(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r13 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r14 = r7.iterator();
    L23:
        if (r14.hasNext() == false) goto L27;
        Object r15 = r14.next();
        if ((!((InAppSearchEntityParam) ZeusTransformUtils.preCheckCast(r15, InAppSearchEntityParam.class, "com.obric.memorydata.plugin")).isSemantic()) == false) goto L23;
        r13.add(r15);
        goto L23
    L27:
        Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r13, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r16, Collection.class) == true) goto L30;
    L32:
        Iterator r17 = r16.iterator();
    L34:
        if (r17.hasNext() == false) goto L31;
        if ((!com.obric.memorydata.personalcontext.search.c.f12306a.b().contains(((InAppSearchEntityParam) ZeusTransformUtils.preCheckCast(r17.next(), InAppSearchEntityParam.class, "com.obric.memorydata.plugin")).getField())) == false) goto L34;
    L31:
        r4 = false;
        goto L37
    L30:
        if (((Collection) ZeusTransformUtils.preCheckCast(r16, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L32;
    L12:
        r6 = false;
        goto L19
    L11:
        if (((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L13;
    L37:
        if (r4 == false) goto L4;
        r11.add(r1);
        goto L4
    L40:
        return CollectionsKt.toMutableList((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r11, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin"));
    }

    public final void b(CountDownLatch r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.c = r2;
    }

    public final Object c(Continuation<? super GlobalAssistantSearchResponse> r6) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r7, AbstractGlobalAssistantSearchSession$executeSearch$1.class) == false) goto L7;
        AbstractGlobalAssistantSearchSession$executeSearch$1 r0 = (AbstractGlobalAssistantSearchSession$executeSearch$1) ZeusTransformUtils.preCheckCast(r7, AbstractGlobalAssistantSearchSession$executeSearch$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        a this = (a) ZeusTransformUtils.preCheckCast(r0.L$0, a.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r8);
    L18:
        return this.l();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        r0.L$0 = this;
        r0.label = 1;
        if (b(r0) != r2) goto L18;
        return r2;
    L7:
        r0 = new AbstractGlobalAssistantSearchSession$executeSearch$1(this, r7);
        goto L8
    }

    public final List<String> c() {
        return this.l;
    }

    public final List<SearchResultEntry> c(List<SearchResultEntry> r9) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "result");
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin");
        Collection r11 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L32;
        Object r1 = r12.next();
        SearchResultEntry r2 = (SearchResultEntry) ZeusTransformUtils.preCheckCast(r1, SearchResultEntry.class, "com.obric.memorydata.plugin");
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(r2.getInAppSearchParams(), Iterable.class, "com.obric.memorydata.plugin");
        boolean r5 = true;
        if (ZeusTransformUtils.instanceOf(r3, Collection.class) == true) goto L8;
    L10:
        Iterator r4 = r3.iterator();
    L12:
        if (r4.hasNext() == false) goto L9;
        if (((InAppSearchEntityParam) ZeusTransformUtils.preCheckCast(r4.next(), InAppSearchEntityParam.class, "com.obric.memorydata.plugin")).isSemantic() == false) goto L12;
        boolean r6 = true;
    L16:
        if (r6 == false) goto L28;
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(r2.getInAppSearchParams(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r13 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r14 = r7.iterator();
    L19:
        if (r14.hasNext() == false) goto L23;
        Object r15 = r14.next();
        if ((!((InAppSearchEntityParam) ZeusTransformUtils.preCheckCast(r15, InAppSearchEntityParam.class, "com.obric.memorydata.plugin")).isSemantic()) == false) goto L19;
        r13.add(r15);
        goto L19
    L23:
        Iterator r16 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r13, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L25:
        if (r16.hasNext() == false) goto L29;
        if (com.obric.memorydata.personalcontext.search.c.f12306a.b().contains(((InAppSearchEntityParam) ZeusTransformUtils.preCheckCast(r16.next(), InAppSearchEntityParam.class, "com.obric.memorydata.plugin")).getField()) == true) goto L25;
    L29:
        if (r5 == false) goto L4;
        r11.add(r1);
    L28:
        r5 = false;
    L9:
        r6 = false;
        goto L16
    L8:
        if (((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L10;
    L32:
        return CollectionsKt.toMutableList((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r11, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin"));
    }

    public final StringBuffer d() {
        return this.m;
    }

    public final CountDownLatch e() {
        CountDownLatch r0 = this.f12319b;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("searchCountDownLatch");
        return null;
    }

    public final CountDownLatch f() {
        CountDownLatch r0 = this.c;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("quAndKgCountDownLatch");
        return null;
    }

    public final String g() {
        return this.A;
    }

    public Set<String> h() {
        return SetsKt.emptySet();
    }

    public int i() {
        return -1;
    }

    public boolean j() {
        return true;
    }
}
