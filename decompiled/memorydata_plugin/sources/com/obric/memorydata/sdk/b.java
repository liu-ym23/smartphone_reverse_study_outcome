package com.obric.memorydata.sdk;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Parcelable;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.crash.entity.EventBody;
import com.obric.aikernel.sdk.autotest.AutoTestConstant;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.intent.Empty;
import com.obric.capabilitykit.common.intent.IntentParams;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.common.intent.PCAppFcEntitySearchParams;
import com.obric.capabilitykit.common.intent.PCCommonGlobalSearchParams;
import com.obric.capabilitykit.common.intent.PCGlobalSearchParams;
import com.obric.capabilitykit.common.intent.PCIntentGlobalSearchParams;
import com.obric.capabilitykit.common.intent.PCPersonalContextFetchParams;
import com.obric.capabilitykit.common.intent.PCPersonalContextSearchParams;
import com.obric.capabilitykit.common.intent.PCSearchAppEntityParams;
import com.obric.capabilitykit.common.intent.RCSearchParams;
import com.obric.capabilitykit.entity.memory.MemoryServiceChecker;
import com.obric.capabilitykit.entity.memory.MemoryServiceStatus;
import com.obric.memorydata.database.entity.ChatMessage;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.obric.memorydata.sdk.entity.search.oauto.OAutoSearchResult;
import com.obric.memorydata.sdk.entity.search.userprofile.UserProfileMemoryResult;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000È\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b8\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010A\u001a\b\u0012\u0004\u0012\u00020C0B2\u0006\u0010D\u001a\u00020EJ\u0014\u0010F\u001a\b\u0012\u0004\u0012\u00020C0B2\u0006\u0010D\u001a\u00020EJ\u0014\u0010G\u001a\b\u0012\u0004\u0012\u00020C0B2\u0006\u0010D\u001a\u00020EJ\u0014\u0010H\u001a\b\u0012\u0004\u0012\u00020C0B2\u0006\u0010D\u001a\u00020EJ$\u0010I\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020K0J0B2\u0006\u0010D\u001a\u00020E2\b\b\u0002\u0010L\u001a\u00020MJ\"\u0010N\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020K0J0B2\u0006\u0010D\u001a\u00020E2\u0006\u0010L\u001a\u00020MJ\u001c\u0010O\u001a\b\u0012\u0004\u0012\u00020\u00050B2\u0006\u0010D\u001a\u00020E2\u0006\u0010L\u001a\u00020MJ&\u0010P\u001a\b\u0012\u0004\u0012\u00020Q0B2\u0006\u0010D\u001a\u00020E2\u0006\u0010R\u001a\u00020\u00052\b\b\u0002\u0010S\u001a\u00020\u0005J\"\u0010T\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020V0U0B2\u0006\u0010W\u001a\u00020X2\u0006\u0010Y\u001a\u00020ZJ\"\u0010[\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020V0U0B2\u0006\u0010W\u001a\u00020\\2\u0006\u0010Y\u001a\u00020ZJ\"\u0010]\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020V0U0B2\u0006\u0010W\u001a\u00020^2\u0006\u0010Y\u001a\u00020ZJ\"\u0010_\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020V0U0B2\u0006\u0010W\u001a\u00020`2\u0006\u0010Y\u001a\u00020ZJ\"\u0010a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020V0U0B2\u0006\u0010W\u001a\u00020b2\u0006\u0010Y\u001a\u00020ZJ\"\u0010c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020V0U0B2\u0006\u0010W\u001a\u00020d2\u0006\u0010Y\u001a\u00020ZJ\"\u0010e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020V0U0B2\u0006\u0010f\u001a\u00020\u00052\u0006\u0010D\u001a\u00020EJ\"\u0010g\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020V0U0B2\u0006\u0010W\u001a\u00020h2\u0006\u0010Y\u001a\u00020ZJ\u001c\u0010i\u001a\b\u0012\u0004\u0012\u00020j0B2\u0006\u0010W\u001a\u00020k2\u0006\u0010D\u001a\u00020EJ\u001c\u0010l\u001a\b\u0012\u0004\u0012\u00020m0B2\u0006\u0010D\u001a\u00020E2\u0006\u0010n\u001a\u00020\u0005J\u001c\u0010o\u001a\b\u0012\u0004\u0012\u00020\u00050B2\u0006\u0010D\u001a\u00020E2\u0006\u0010p\u001a\u00020\u0005J\u001c\u0010q\u001a\b\u0012\u0004\u0012\u00020\u00050B2\u0006\u0010D\u001a\u00020E2\u0006\u0010p\u001a\u00020\u0005J$\u0010r\u001a\b\u0012\u0004\u0012\u00020C0B2\u0006\u0010D\u001a\u00020E2\u0006\u0010s\u001a\u00020\u00052\u0006\u0010t\u001a\u00020\u0005J\"\u0010u\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020V0U0B2\u0006\u0010W\u001a\u00020v2\u0006\u0010Y\u001a\u00020ZJ&\u0010w\u001a\b\u0012\u0004\u0012\u00020\u00050B2\u0006\u0010D\u001a\u00020E2\u0010\b\u0002\u0010x\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010JJr\u0010y\u001a\b\u0012\u0004\u0012\u00020\u00050B2\u0006\u0010D\u001a\u00020E2\u0006\u0010z\u001a\u00020M2\u0006\u0010{\u001a\u00020\u00052\u0006\u0010|\u001a\u00020}2\u0006\u0010~\u001a\u00020\u00052\n\b\u0002\u0010\u007f\u001a\u0004\u0018\u00010\u00052\u000b\b\u0002\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u00052\u000b\b\u0002\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u00052\u000b\b\u0002\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u00052\t\b\u0002\u0010\u0083\u0001\u001a\u00020MJ(\u0010\u0084\u0001\u001a\b\u0012\u0004\u0012\u00020\u00050B2\u0006\u0010D\u001a\u00020E2\u0007\u0010\u0085\u0001\u001a\u00020\u00052\b\u0010\u0086\u0001\u001a\u00030\u0087\u0001J8\u0010\u0088\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u0089\u00010J0B2\u0006\u0010D\u001a\u00020E2\u001a\u0010\u008a\u0001\u001a\u0015\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050J0\u008b\u0001J/\u0010\u008c\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u0089\u00010J0B2\u0006\u0010D\u001a\u00020E2\u0007\u0010\u008d\u0001\u001a\u00020M2\b\b\u0002\u0010L\u001a\u00020MJ/\u0010\u008e\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020V0U0B2\u0007\u0010\u008f\u0001\u001a\u00020\u00052\u0007\u0010W\u001a\u00030\u0090\u00012\u0006\u0010Y\u001a\u00020ZH\u0002J6\u0010\u0091\u0001\u001a\t\u0012\u0005\u0012\u0003H\u0092\u00010B\"\u0005\b\u0000\u0010\u0092\u00012\u0006\u0010D\u001a\u00020E2\u0007\u0010\u008f\u0001\u001a\u00020\u00052\f\b\u0002\u0010\u0093\u0001\u001a\u0005\u0018\u00010\u0094\u0001H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0018\u0010=\u001a\n ?*\u0004\u0018\u00010>0>X\u0082\u0004¢\u0006\u0004\n\u0002\u0010@¨\u0006\u0095\u0001"}, d2 = {"Lcom/obric/memorydata/sdk/MemoryAPI;", "", "<init>", "()V", "KEY_MEMORY_RESPONSE", "", "METHOD_NOTIFY_USER_AGREE_PRIVACY", "METHOD_TERMINATE_SERVICE", "METHOD_CHECK_DEPENDENCY_PERMISSION", "KEY_PC_SEARCH_INTENT", "KEY_QU_RESULT_JSON", "KEY_QUERY", "KEY_IS_FINISHED", "KEY_MEMORY_INTENT_EXECUTOR_PARAMS", "KEY_O_AUTO_GLOBAL_SEARCH_EXECUTOR_PARAMS", "NEW_KEY_O_AUTO_GLOBAL_SEARCH_EXECUTOR_PARAMS", "METHOD_PC_SEARCH_APP_ENTITY_INTENT", "METHOD_PC_APP_FC_ENTITY_SEARCH_INTENT", "METHOD_PC_GLOBAL_SEARCH_INTENT", "METHOD_GET_COMPLEX_RECOMMEND_QUERY", "METHOD_QUERY_USER_KEYWORD", "METHOD_PC_COMMON_GLOBAL_SEARCH_INTENT", "METHOD_PC_PERSONAL_CONTEXT_FETCH_INTENT", "METHOD_PC_PERSONAL_CONTEXT_SEARCH_INTENT", "METHOD_PC_INTENT_GLOBAL_SEARCH_INTENT", "METHOD_O_AUTO_GLOBAL_SEARCH_INTENT", "METHOD_RC_SEARCH_INTENT", "METHOD_RC_SEARCH_STATE_WHEN_START_QUERY", "METHOD_NOTIFY_EVALUATION_QUERY_FINISHED", "METHOD_GET_APP_ENTITY_LIST_BY_ENTITY_TYPE_AND_ENTITY_ID_LIST", "METHOD_GET_APP_ENTITY_BY_ENTITY_TYPE", "KEY_ENTITY_TYPE", "KEY_LIMIT", "METHOD_RECEIVE_NOTIFICATION_DATA", "KEY_RC_SEARCH_STATE_FEATURE_NAME_LIST", "KEY_QUESTION_ID", "METHOD_PRELOAD_ASSISTANT_SEARCH_MODEL", "METHOD_CANCEL_USE_ASSISTANT_SEARCH_MODEL", "METHOD_QUERY_USER_PROFILE_MEMORY", "KEY_QUERY_USER_PROFILE_KEY", "METHOD_QUERY_USER_INSIGHT_AND_PREFERENCE", "METHOD_QUERY_REAL_TIME_AWARENESS_DATA", "KEY_PARAM", "METHOD_NOTIFY_DOUBAO_GLASSES_STATE", "KEY_DOUBAO_GLASSES_STATE_KEY", "KEY_DOUBAO_GLASSES_STATE_VALUE", "DOUBAO_GLASSES_STATE_KEY_CONNECTED_STATE", "DOUBAO_GLASSES_STATE_KEY_PHYSICAL_CONNECTION_STATE", "DOUBAO_GLASSES_CONNECTED_STATE_CONNECTED", "DOUBAO_GLASSES_CONNECTED_STATE_DISCONNECTED", "KEY_NOTIFICATION_ID", "KEY_PKG", "KEY_POST_TIME", "KEY_APP_NAME", "KEY_TITLE", "KEY_SUB_TITLE", "KEY_CONTENT", "KEY_CHANNEL", "KEY_FLAGS", "METHOD_GET_MEMORY_SYNTHESIS_RECOMMEND_QUERY", "TAG", "MEMORY_URI", "Landroid/net/Uri;", "kotlin.jvm.PlatformType", "Landroid/net/Uri;", "notifyUserAgreePrivacy", "Lcom/obric/memorydata/sdk/MemoryResponse;", "Ljava/lang/Void;", "context", "Landroid/content/Context;", "terminateService", "preloadAssistantSearchModels", "cancelUseAssistantSearchModels", "getMemorySynthesisRecommendQuery", "", "Lcom/obric/memorydata/sdk/entity/RecommendComplexQuery;", "limit", "", "getComplexRecommendQuery", "queryUserKeyword", "checkDependencyPermissionForSearchIntent", "Lcom/obric/memorydata/sdk/service/PermissionCheckResult;", "pcSearchIntent", "quResultJson", "executeSearchAppEntityIntent", "Lcom/obric/capabilitykit/common/intent/IntentResult;", "Lcom/obric/capabilitykit/common/intent/Empty;", TrackerImpl.PARAMS, "Lcom/obric/capabilitykit/common/intent/PCSearchAppEntityParams;", "dispatchContext", "Lcom/obric/capabilitykit/common/DispatchContext;", "executeAppFuncEntitySearchIntent", "Lcom/obric/capabilitykit/common/intent/PCAppFcEntitySearchParams;", "executeGlobalSearchIntent", "Lcom/obric/capabilitykit/common/intent/PCGlobalSearchParams;", "executeCommonGlobalSearchIntent", "Lcom/obric/capabilitykit/common/intent/PCCommonGlobalSearchParams;", "executePersonalContextSearchIntent", "Lcom/obric/capabilitykit/common/intent/PCPersonalContextSearchParams;", "executePersonalContextFetchIntent", "Lcom/obric/capabilitykit/common/intent/PCPersonalContextFetchParams;", "donateOAutoSession", "sessionJson", "executeIntentGlobalSearchIntent", "Lcom/obric/capabilitykit/common/intent/PCIntentGlobalSearchParams;", "executeOAutoGlobalSearchIntent", "Lcom/obric/memorydata/sdk/entity/search/oauto/OAutoSearchResult;", "Lorg/json/JSONObject;", "queryUserProfileMemory", "Lcom/obric/memorydata/sdk/entity/search/userprofile/UserProfileMemoryResult;", "profileKey", "queryUserInsightAndPreference", AutoTestConstant.PARAM, "queryRealtimeAwarenessData", "notifyDoubaoGlassesState", "key", EventBody.KEY_VALUE, "executeRCSearchIntent", "Lcom/obric/capabilitykit/common/intent/RCSearchParams;", "executeRCSearchStateWhenStartQuery", "featureName", "receiveNotificationData", "notificationId", "pkg", "postTime", "", "appName", "title", "subTitle", Params.CONTENT, "channel", "flags", "notifyEvaluationQueryFinished", ChatMessage.TYPE_QUERY, "isFinished", "", "getAppEntityListByEntityTypeAndEntityIdList", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "entityMap", "", "getAppEntityByEntityType", "entityType", "executeMemoryIntentExecutor", "method", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "innerCall", ExifInterface.GPS_DIRECTION_TRUE, "args", "Landroid/os/Bundle;", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f12829a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Uri f12830b = null;

    static {
        f12829a = new b();
        f12830b = Uri.parse("content://com.obric.memorydata.personalcontext.EntityProvider");
    }

    private b() {
    }

    private final <T> MemoryResponse<T> a(Context r10, String r11, Bundle r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        if (MemoryServiceChecker.INSTANCE.checkEntityProviderAvailable(r13) != MemoryServiceStatus.AVAILABLE) goto L5;
        ContentProviderClient r14 = r13.getContentResolver().acquireUnstableContentProviderClient(f12830b);     // Catch: Exception -> L28
        if (r14 == null) goto L9;
        Bundle r0 = null;
        r0 = r14.call(r11, null, r12);     // Catch: Throwable -> L14 Exception -> L16 DeadObjectException -> L18
    L12:
        r14.close();     // Catch: Exception -> L28
        if (r0 == null) goto L37;
        r0.setClassLoader(b.class.getClassLoader());     // Catch: Exception -> L28
        MemoryResponse<T> r15 = (MemoryResponse) ZeusTransformUtils.preCheckCast(r0.getParcelable("memory_response"), MemoryResponse.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L28
        if (r15 == null) goto L36;
        return r15;
    L36:
        return new MemoryResponse(400, "internal error", null, 4, null);
    L37:
        return new MemoryResponse(400, "internal error", null, 4, null);
    L14:
        th = move-exception;
        r14.close();     // Catch: Exception -> L28
        throw th;     // Catch: Exception -> L28
    L18:
        e = move-exception;
        Log.e("MemoryAPI", ExceptionsKt.stackTraceToString((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin")));     // Catch: Throwable -> L14
    L16:
        e = move-exception;
        Log.e("MemoryAPI", ExceptionsKt.stackTraceToString((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin")));     // Catch: Throwable -> L14
        goto L12
    L9:
        return new MemoryResponse(404, "provider client unavailable", null, 4, null);
    L28:
        e = move-exception;
        Log.e("MemoryAPI", ExceptionsKt.stackTraceToString((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin")));
        return new MemoryResponse(404, e.getMessage(), null, 4, null);
    L5:
        return new MemoryResponse(407, "Memory service component disabled", null, 4, null);
    }

    private final MemoryResponse<IntentResult<Empty>> a(String r5, IntentParams r6, DispatchContext r7) {
        IntentParams r8 = (IntentParams) ZeusTransformUtils.wrapperContextForParams(r6, IntentParams.class, "com.obric.memorydata.plugin");
        Bundle r0 = new Bundle();
        r0.putParcelable("memoryIntentExecutorParams", (Parcelable) ZeusTransformUtils.preCheckCast(r8, Parcelable.class, "com.obric.memorydata.plugin"));
        Long r9 = r7.getQuestionId();
        if (r9 == null) goto L6;
        r0.putLong("questionId", ((Number) ZeusTransformUtils.preCheckCast(r9, Number.class, "com.obric.memorydata.plugin")).longValue());
    L6:
        return a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r7.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r5, r0);
    }

    public final MemoryResponse<String> a(Context r3, int r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "context");
        Bundle r0 = new Bundle();
        r0.putInt("limit", r4);
        return a(r5, "queryUserKeyword", r0);
    }

    public final MemoryResponse<UserProfileMemoryResult> a(Context r3, String r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r4, "profileKey");
        Bundle r1 = new Bundle();
        r1.putString("profileKey", r4);
        return a(r5, "queryUserProfileMemory", r1);
    }

    public final MemoryResponse<IntentResult<Empty>> a(PCAppFcEntitySearchParams r3, DispatchContext r4) {
        Intrinsics.checkNotNullParameter(r3, TrackerImpl.PARAMS);
        Intrinsics.checkNotNullParameter(r4, "dispatchContext");
        return a("pcAppFcEntitySearchIntent", (IntentParams) ZeusTransformUtils.preCheckCast(r3, IntentParams.class, "com.obric.memorydata.plugin"), r4);
    }

    public final MemoryResponse<IntentResult<Empty>> a(PCCommonGlobalSearchParams r3, DispatchContext r4) {
        Intrinsics.checkNotNullParameter(r3, TrackerImpl.PARAMS);
        Intrinsics.checkNotNullParameter(r4, "dispatchContext");
        return a("pcCommonGlobalSearchIntent", (IntentParams) ZeusTransformUtils.preCheckCast(r3, IntentParams.class, "com.obric.memorydata.plugin"), r4);
    }

    public final MemoryResponse<IntentResult<Empty>> a(PCGlobalSearchParams r3, DispatchContext r4) {
        Intrinsics.checkNotNullParameter(r3, TrackerImpl.PARAMS);
        Intrinsics.checkNotNullParameter(r4, "dispatchContext");
        return a("pcGlobalSearchIntent", (IntentParams) ZeusTransformUtils.preCheckCast(r3, IntentParams.class, "com.obric.memorydata.plugin"), r4);
    }

    public final MemoryResponse<IntentResult<Empty>> a(PCIntentGlobalSearchParams r3, DispatchContext r4) {
        Intrinsics.checkNotNullParameter(r3, TrackerImpl.PARAMS);
        Intrinsics.checkNotNullParameter(r4, "dispatchContext");
        return a("pcIntentGlobalSearchIntent", (IntentParams) ZeusTransformUtils.preCheckCast(r3, IntentParams.class, "com.obric.memorydata.plugin"), r4);
    }

    public final MemoryResponse<IntentResult<Empty>> a(PCPersonalContextFetchParams r3, DispatchContext r4) {
        Intrinsics.checkNotNullParameter(r3, TrackerImpl.PARAMS);
        Intrinsics.checkNotNullParameter(r4, "dispatchContext");
        return a("pcPersonalContextFetchIntent", (IntentParams) ZeusTransformUtils.preCheckCast(r3, IntentParams.class, "com.obric.memorydata.plugin"), r4);
    }

    public final MemoryResponse<IntentResult<Empty>> a(PCPersonalContextSearchParams r3, DispatchContext r4) {
        Intrinsics.checkNotNullParameter(r3, TrackerImpl.PARAMS);
        Intrinsics.checkNotNullParameter(r4, "dispatchContext");
        return a("pcPersonalContextSearchIntent", (IntentParams) ZeusTransformUtils.preCheckCast(r3, IntentParams.class, "com.obric.memorydata.plugin"), r4);
    }

    public final MemoryResponse<IntentResult<Empty>> a(PCSearchAppEntityParams r3, DispatchContext r4) {
        Intrinsics.checkNotNullParameter(r3, TrackerImpl.PARAMS);
        Intrinsics.checkNotNullParameter(r4, "dispatchContext");
        return a("pcSearchAppEntityIntent", (IntentParams) ZeusTransformUtils.preCheckCast(r3, IntentParams.class, "com.obric.memorydata.plugin"), r4);
    }

    public final MemoryResponse<IntentResult<Empty>> a(RCSearchParams r3, DispatchContext r4) {
        Intrinsics.checkNotNullParameter(r3, TrackerImpl.PARAMS);
        Intrinsics.checkNotNullParameter(r4, "dispatchContext");
        return a("rcGlobalSearchIntent", (IntentParams) ZeusTransformUtils.preCheckCast(r3, IntentParams.class, "com.obric.memorydata.plugin"), r4);
    }

    public final MemoryResponse<OAutoSearchResult> a(JSONObject r3, Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, TrackerImpl.PARAMS);
        Intrinsics.checkNotNullParameter(r5, "context");
        Bundle r0 = new Bundle();
        r0.putString("oAutoGlobalSearchExecutorParams", r3.toString());
        return a(r5, "oAutoGlobalSearchIntent", r0);
    }
}
