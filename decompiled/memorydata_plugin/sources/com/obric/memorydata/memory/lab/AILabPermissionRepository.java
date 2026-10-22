package com.obric.memorydata.memory.lab;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.BuildConfig;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.settings.AppSettingsManager;
import com.obric.memorydata.middleware.api.store.IStore;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.obric.memorydata.utils.u;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.ae;
import kotlinx.coroutines.flow.ar;
import kotlinx.coroutines.flow.at;
import kotlinx.coroutines.flow.k;
import okhttp3.HttpUrl;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0004¹\u0001º\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020?J\u0010\u0010@\u001a\u0002062\b\u0010A\u001a\u0004\u0018\u00010BJ\f\u0010C\u001a\u00020D*\u00020DH\u0002J\u0016\u0010E\u001a\u00020=2\u0006\u0010>\u001a\u00020?2\u0006\u0010A\u001a\u00020BJ\u000e\u0010F\u001a\u00020B2\u0006\u0010>\u001a\u00020?J\u0018\u0010G\u001a\u00020\"2\u0006\u0010H\u001a\u00020\u00052\b\b\u0002\u0010I\u001a\u000206J\u0017\u0010J\u001a\u00020\u00052\b\u0010A\u001a\u0004\u0018\u00010BH\u0000¢\u0006\u0002\bKJ\u0015\u0010L\u001a\u00020\u00052\u0006\u0010I\u001a\u000206H\u0000¢\u0006\u0002\bMJ\u0010\u0010N\u001a\u00020=2\u0006\u0010>\u001a\u00020?H\u0002J\u0010\u0010O\u001a\u00020\u00072\b\u0010A\u001a\u0004\u0018\u00010BJ\u0014\u0010P\u001a\u0004\u0018\u00010Q2\b\u0010A\u001a\u0004\u0018\u00010BH\u0002J\u0010\u0010R\u001a\u00020\u00072\b\u0010A\u001a\u0004\u0018\u00010BJ\u0010\u0010S\u001a\u00020\"2\b\u0010A\u001a\u0004\u0018\u00010BJ \u0010T\u001a\u00020\"2\b\u0010A\u001a\u0004\u0018\u00010B2\u0006\u0010U\u001a\u00020\u00052\u0006\u0010V\u001a\u00020\u0005J\"\u0010W\u001a\u00020\"2\b\u0010A\u001a\u0004\u0018\u00010B2\u0006\u0010U\u001a\u00020\u00052\u0006\u0010V\u001a\u00020\u0005H\u0002J \u0010X\u001a\u00020\"2\b\u0010A\u001a\u0004\u0018\u00010B2\u0006\u0010U\u001a\u00020\u00052\u0006\u0010V\u001a\u00020\u0005J\u0015\u0010Y\u001a\u00020\u00072\u0006\u0010Z\u001a\u00020\"H\u0000¢\u0006\u0002\b[J\u0015\u0010\\\u001a\u00020\u00072\u0006\u0010]\u001a\u00020\"H\u0000¢\u0006\u0002\b^J\u0017\u0010_\u001a\u00020\u00072\b\u0010`\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0002\baJ\u0017\u0010b\u001a\u00020\u00072\b\u0010c\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0002\bdJ\u0017\u0010e\u001a\u00020\u00072\b\b\u0002\u0010I\u001a\u000206H\u0000¢\u0006\u0002\bfJ\u0017\u0010g\u001a\u00020\u00072\b\b\u0002\u0010I\u001a\u000206H\u0000¢\u0006\u0002\bhJ[\u0010i\u001a\u00020\u00072\b\b\u0002\u0010I\u001a\u0002062\b\b\u0002\u0010j\u001a\u00020\u00052\b\b\u0002\u0010k\u001a\u00020\u00052\u000e\b\u0002\u0010l\u001a\b\u0012\u0004\u0012\u00020\u00050 2\u000e\b\u0002\u0010m\u001a\b\u0012\u0004\u0012\u00020\u00050 2\u000e\b\u0002\u0010n\u001a\b\u0012\u0004\u0012\u00020\u00050 H\u0000¢\u0006\u0002\boJ\u0017\u0010p\u001a\u00020\u00072\b\b\u0002\u0010I\u001a\u000206H\u0000¢\u0006\u0002\bqJ\u0010\u0010r\u001a\u00020\u00072\b\b\u0002\u0010I\u001a\u000206J-\u0010s\u001a\u00020\u00072\u0006\u0010I\u001a\u0002062\u0006\u0010t\u001a\u00020u2\u0006\u0010v\u001a\u00020u2\u0006\u0010w\u001a\u00020uH\u0000¢\u0006\u0002\bxJ%\u0010y\u001a\b\u0012\u0004\u0012\u00020\u00050 2\b\u0010z\u001a\u0004\u0018\u0001062\u0006\u0010{\u001a\u000206H\u0000¢\u0006\u0002\b|J\u000e\u0010}\u001a\u00020=2\u0006\u0010~\u001a\u00020uJ\u0006\u0010\u007f\u001a\u00020uJ\u0007\u0010\u0080\u0001\u001a\u00020=J\u000f\u0010\u0081\u0001\u001a\u00020=2\u0006\u0010V\u001a\u00020\u0005J\u000f\u0010\u0082\u0001\u001a\u00020\u00072\u0006\u0010V\u001a\u00020\u0005J\u000f\u0010\u0083\u0001\u001a\u00020=2\u0006\u0010V\u001a\u00020\u0005J\u0007\u0010\u0084\u0001\u001a\u00020=J<\u0010\u0085\u0001\u001a\b\u0012\u0004\u0012\u00020\u00050 2\r\u0010\u0086\u0001\u001a\b\u0012\u0004\u0012\u00020\u00050 2\u0016\b\u0002\u0010\u0087\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\u0088\u0001H\u0000¢\u0006\u0003\b\u0089\u0001J\u0019\u0010\u008a\u0001\u001a\u00020\u00072\b\u0010A\u001a\u0004\u0018\u00010B2\u0006\u0010V\u001a\u00020\u0005J\u001c\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u008c\u00012\u0006\u0010>\u001a\u00020?2\b\u0010`\u001a\u0004\u0018\u00010\u0005J\u001b\u0010\u008d\u0001\u001a\u0004\u0018\u00010B2\u0006\u0010>\u001a\u00020?2\b\u0010`\u001a\u0004\u0018\u00010\u0005J\u000f\u0010\u008e\u0001\u001a\u00020=2\u0006\u0010A\u001a\u00020BJ\u0007\u0010\u008f\u0001\u001a\u00020=J'\u0010\u0090\u0001\u001a\u00020=2\u0006\u0010A\u001a\u00020B2\u0006\u0010U\u001a\u00020\u00052\u0006\u0010V\u001a\u00020\u00052\u0006\u00107\u001a\u00020\"J\u0007\u0010\u0091\u0001\u001a\u00020BJ<\u0010\u0092\u0001\u001a\u00020B2\u0007\u0010\u0093\u0001\u001a\u00020\"2\u0007\u0010\u0094\u0001\u001a\u00020\"2\u0007\u0010\u0095\u0001\u001a\u00020\"2\u0007\u0010\u0096\u0001\u001a\u00020\"2\u0007\u0010\u0097\u0001\u001a\u00020\"H\u0000¢\u0006\u0003\b\u0098\u0001J\u001b\u0010\u0099\u0001\u001a\u00020D2\b\u0010A\u001a\u0004\u0018\u00010B2\u0006\u0010V\u001a\u00020\u0005H\u0002J\u0017\u0010\u009a\u0001\u001a\b\u0012\u0004\u0012\u00020D0 2\u0006\u0010I\u001a\u000206H\u0002J\u000b\u0010\u009b\u0001\u001a\u0004\u0018\u00010\u0005H\u0002J\u000b\u0010\u009c\u0001\u001a\u0004\u0018\u00010\u0005H\u0002J\u0012\u0010\u009d\u0001\u001a\u00030\u009e\u00012\u0006\u0010>\u001a\u00020?H\u0002J\u000f\u0010\u009f\u0001\u001a\b\u0012\u0004\u0012\u00020\u00050 H\u0002J\u000f\u0010 \u0001\u001a\b\u0012\u0004\u0012\u00020\u00050 H\u0002J\u0012\u0010¡\u0001\u001a\u00030\u009e\u00012\u0006\u0010>\u001a\u00020?H\u0002J\u0013\u0010¢\u0001\u001a\u0004\u0018\u00010B2\u0006\u0010>\u001a\u00020?H\u0002J\u000f\u0010£\u0001\u001a\u00020=2\u0006\u0010>\u001a\u00020?J\u000f\u0010¤\u0001\u001a\u00020=2\u0006\u0010>\u001a\u00020?J\u0011\u0010¥\u0001\u001a\u00020B2\u0006\u0010Z\u001a\u00020\"H\u0002J\u0019\u0010¦\u0001\u001a\u00020\u00052\u0006\u0010`\u001a\u00020\u00052\u0006\u0010c\u001a\u00020\u0005H\u0002J\u0011\u0010§\u0001\u001a\u00020\u00052\u0006\u0010`\u001a\u00020\u0005H\u0002J\u000f\u0010¨\u0001\u001a\u00020\u0005H\u0000¢\u0006\u0003\b©\u0001J\u000f\u0010ª\u0001\u001a\u00020\u0005H\u0000¢\u0006\u0003\b«\u0001J\u0017\u0010¬\u0001\u001a\u00020\u00052\u0006\u0010V\u001a\u00020\u0005H\u0000¢\u0006\u0003\b\u00ad\u0001J'\u0010®\u0001\u001a\u0004\u0018\u00010B2\u0006\u0010>\u001a\u00020?2\b\u0010`\u001a\u0004\u0018\u00010\u00052\b\u0010c\u001a\u0004\u0018\u00010\u0005H\u0002J\u001d\u0010¯\u0001\u001a\u0004\u0018\u00010B2\b\u0010°\u0001\u001a\u00030\u009e\u00012\u0006\u0010H\u001a\u00020\u0005H\u0002J0\u0010±\u0001\u001a\u0004\u0018\u00010B2\u0012\u0010²\u0001\u001a\r\u0012\u0004\u0012\u00020\u0005\u0012\u0002\b\u00030³\u00012\t\u0010´\u0001\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0003\bµ\u0001J\u000b\u0010¶\u0001\u001a\u0004\u0018\u00010BH\u0002J\u0012\u0010·\u0001\u001a\u00030¸\u00012\u0006\u0010H\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u00020\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00050 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\"X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\"X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\"X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\"X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\"X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\"X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\"X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\"X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\"X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\"X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\"X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\"X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\"X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\"X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\"X\u0086T¢\u0006\u0002\n\u0000R\u0014\u00102\u001a\b\u0012\u0004\u0012\u00020\u000503X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00104\u001a\b\u0012\u0004\u0012\u00020605X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u00107\u001a\b\u0012\u0004\u0012\u00020608¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u000e\u0010;\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006»\u0001"}, d2 = {"Lcom/obric/memorydata/memory/lab/AILabPermissionRepository;", "", "<init>", "()V", "TAG", "", "DEBUG_AI_LAB", "", "V3_SP_NAME", "V3_SP_KEY_PREFIX", "V4_STORE_KEY", "UNLOCK_LAST_GET_PERMISSION_TIME_STORE_KEY", "APPROVAL_NOTIFICATION_PENDING_STORE_KEY_PREFIX", "PROVIDER_SP_NAME", "AUTHORITY", "KEY_PERMISSIONS", "KEY_PKG_LAB", "KEY_VISIBLE", "KEY_STATUS", "KEY_FLAG", "KEY_COMPONENT", "memoryStore", "Lcom/obric/memorydata/middleware/api/store/IStore;", "getMemoryStore", "()Lcom/obric/memorydata/middleware/api/store/IStore;", "KEY_MEMORY_PACKAGE_NAME", "KEY_SCREEN_MEMORY", "KEY_VOICE_MEMORY", "KEY_AUTO_MEMORY", "KEY_AI_PROACTIVE_AGENT", "KEY_AI_LAB_STATUS", "PROVIDER_STATUS_KEYS", "", "PROVIDER_STATUS_DISABLED", "", "PROVIDER_STATUS_ENABLED", "STATUS_NEED_APPLY", "STATUS_WAIT_FOR_APPROVAL", "STATUS_APPROVED", "STATUS_REJECTED", "STATUS_INVALID", "STATUS_CLOSED", "STATUS_INIT", "STATUS_REVIEW", "STATUS_REJECT", "STATUS_BLACKLIST", "STATUS_WHITELIST", "REQUEST_TYPE_APPLY", "REQUEST_TYPE_WITHDRAW", "REQUEST_TYPE_CLOSE", "MEMORY_PERMISSION_KEYS", "", "_permissionState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/obric/memorydata/memory/lab/AILabPermissionState;", "permissionState", "Lkotlinx/coroutines/flow/StateFlow;", "getPermissionState", "()Lkotlinx/coroutines/flow/StateFlow;", "initialized", "initIfNeeded", "", "context", "Landroid/content/Context;", "buildState", "permissionData", "Lorg/json/JSONObject;", "checkDebug", "Lcom/obric/memorydata/memory/lab/AILabPermissionItemState;", "publishPermissionData", "publishDefaultPermissionData", "getProviderStatus", "key", "state", "buildPermissionDataSummary", "buildPermissionDataSummary$memory_obricRelease", "buildStateSummary", "buildStateSummary$memory_obricRelease", "notifyProviderStatuses", "isV4PermissionData", "getPermissionSchema", "Lcom/obric/memorydata/memory/lab/AILabPermissionRepository$PermissionSchema;", "isAILabVisible", "getAILabProviderStatus", "getPermissionStatus", ObricMemoryConstants.KEY_PACKAGE_NAME, "permissionName", "getPermissionFlag", "getPermissionProviderStatus", "isProviderStatusEnabled", "providerStatus", "isProviderStatusEnabled$memory_obricRelease", "isVisibleFlagEnabled", "flag", "isVisibleFlagEnabled$memory_obricRelease", "isValidUid", "uid", "isValidUid$memory_obricRelease", "isValidDid", "did", "isValidDid$memory_obricRelease", "isScreenMemoryProviderEnabled", "isScreenMemoryProviderEnabled$memory_obricRelease", "isVoiceMemoryProviderEnabled", "isVoiceMemoryProviderEnabled$memory_obricRelease", "isAutoMemoryEffectiveEnabled", "serverDeviceId", "userId", "settingsEnableDids", "storeEnableDids", "storeEnableUids", "isAutoMemoryEffectiveEnabled$memory_obricRelease", "hasWaitingPermission", "hasWaitingPermission$memory_obricRelease", "hasAnyApprovedPermission", "shouldRefreshWaitingPermission", "lastGetPermissionTimeMs", "", "nowMs", "intervalMs", "shouldRefreshWaitingPermission$memory_obricRelease", "approvedPermissionKeysFromWaiting", "previousState", "currentState", "approvedPermissionKeysFromWaiting$memory_obricRelease", "saveUnlockLastGetPermissionTime", "timestampMs", "getUnlockLastGetPermissionTime", "clearUnlockLastGetPermissionTime", "markApprovalNotificationPending", "isApprovalNotificationPending", "clearApprovalNotificationPending", "clearAllApprovalNotificationPending", "filterApprovalNotificationsByPendingRequest", "permissionNames", "hasPendingRequest", "Lkotlin/Function1;", "filterApprovalNotificationsByPendingRequest$memory_obricRelease", "isPermissionItemVisible", "getBestCachedPermission", "Lcom/obric/memorydata/memory/lab/AILabPermissionRepository$CachedPermission;", "getCachedPermission", "saveV4PermissionToStore", "removeV4PermissionFromStore", "updateV4CachedPermissionStatus", "buildDefaultV4PermissionData", "buildLegacyProviderSnapshotPermissionData", "labStatus", "screenMemoryStatus", "voiceMemoryStatus", "autoMemoryStatus", "aiProactiveAgentStatus", "buildLegacyProviderSnapshotPermissionData$memory_obricRelease", "buildItemState", "getMemoryPermissionItems", "getCurrentCacheUid", "getCurrentCacheDid", "getV3SharedPreferences", "Landroid/content/SharedPreferences;", "getAutoMemoryProEnableDid", "getAutoMemoryProEnableUid", "getProviderSharedPreferences", "getLegacyProviderSnapshotPermissionData", "clearLegacyProviderSnapshot", "clearV3PermissionCache", "buildLegacyProviderSnapshotItem", "generateV3CacheKey", "generateV3CacheKeyPrefix", "generateV4StoreKey", "generateV4StoreKey$memory_obricRelease", "generateUnlockLastGetPermissionTimeStoreKey", "generateUnlockLastGetPermissionTimeStoreKey$memory_obricRelease", "generateApprovalNotificationPendingStoreKey", "generateApprovalNotificationPendingStoreKey$memory_obricRelease", "getV3CachedPermission", "getV3CachedPermissionByKey", "sharedPreferences", "selectV3PermissionCacheJson", "entries", "", "preferredUid", "selectV3PermissionCacheJson$memory_obricRelease", "getV4CachedPermission", "buildProviderUri", "Landroid/net/Uri;", "PermissionSchema", "CachedPermission", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AILabPermissionRepository {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AILabPermissionRepository f10236a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final List<String> f10237b = null;
    private static final Set<String> c = null;
    private static final ae<com.obric.memorydata.memory.lab.d> d = null;
    private static final ar<com.obric.memorydata.memory.lab.d> e = null;
    private static volatile boolean f;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/memory/lab/AILabPermissionRepository$PermissionSchema;", "", "<init>", "(Ljava/lang/String;I)V", "V3", "V4", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final enum PermissionSchema extends Enum<PermissionSchema> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ PermissionSchema[] $VALUES = null;
        public static final PermissionSchema V3 = null;
        public static final PermissionSchema V4 = null;

        private static final /* synthetic */ PermissionSchema[] $values() {
            return new PermissionSchema[]{V3, V4};
        }

        static {
            V3 = new PermissionSchema("V3", 0);
            V4 = new PermissionSchema("V4", 1);
            PermissionSchema[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
        }

        private PermissionSchema(String r1, int r2) {
            super(r1, r2);
        }

        public static EnumEntries<PermissionSchema> getEntries() {
            return $ENTRIES;
        }

        public static PermissionSchema valueOf(String r2) {
            return (PermissionSchema) ZeusTransformUtils.preCheckCast(Enum.valueOf(PermissionSchema.class, r2), PermissionSchema.class, "com.obric.memorydata.plugin");
        }

        public static PermissionSchema[] values() {
            return (PermissionSchema[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), PermissionSchema[].class, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/memory/lab/AILabPermissionRepository$CachedPermission;", "", "data", "Lorg/json/JSONObject;", "schema", "Lcom/obric/memorydata/memory/lab/AILabPermissionRepository$PermissionSchema;", "<init>", "(Lorg/json/JSONObject;Lcom/obric/memorydata/memory/lab/AILabPermissionRepository$PermissionSchema;)V", "getData", "()Lorg/json/JSONObject;", "getSchema", "()Lcom/obric/memorydata/memory/lab/AILabPermissionRepository$PermissionSchema;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final JSONObject f10238a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final PermissionSchema f10239b;

        public a(JSONObject r2, PermissionSchema r3) {
            Intrinsics.checkNotNullParameter(r2, "data");
            Intrinsics.checkNotNullParameter(r3, "schema");
            this.f10238a = r2;
            this.f10239b = r3;
        }

        public final JSONObject a() {
            return this.f10238a;
        }

        public final PermissionSchema b() {
            return this.f10239b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f10238a, r6.f10238a) == true) goto L12;
            return false;
        L12:
            if (this.f10239b == r6.f10239b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f10238a.hashCode() * 31) + this.f10239b.hashCode();
        }

        public String toString() {
            return "CachedPermission(data=" + this.f10238a + ", schema=" + this.f10239b + ')';
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f10240a = null;

        static {
            int[] r0 = new int[PermissionSchema.values().length];
            r0[PermissionSchema.V4.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[PermissionSchema.V3.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f10240a = r0;
        }
    }

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001¨\u0006\u0003¸\u0006\u0000"}, d2 = {"com/obric/memorydata/utils/GsonExtKt$toListObj$1", "Lcom/google/gson/reflect/TypeToken;", "", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c extends TypeToken<List<? extends String>> {
        public c() {
        }
    }

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001¨\u0006\u0003¸\u0006\u0000"}, d2 = {"com/obric/memorydata/utils/GsonExtKt$toListObj$1", "Lcom/google/gson/reflect/TypeToken;", "", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class d extends TypeToken<List<? extends String>> {
        public d() {
        }
    }

    static {
        AILabPermissionRepository r0 = new AILabPermissionRepository();
        f10236a = r0;
        f10237b = CollectionsKt.listOf(new String[]{"ai_lab_status", "screen_memory", "voice_memory", "auto_memory", "ai_proactive_agent"});
        c = SetsKt.setOf(new String[]{"screen_memory", "voice_memory", "auto_memory", "ai_proactive_agent"});
        ae<com.obric.memorydata.memory.lab.d> r1 = at.a(r0.a(null));
        d = r1;
        e = k.a(r1);
    }

    private AILabPermissionRepository() {
    }

    public static /* synthetic */ int a(AILabPermissionRepository r0, String r1, com.obric.memorydata.memory.lab.d r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = (com.obric.memorydata.memory.lab.d) ZeusTransformUtils.preCheckCast(e.c(), com.obric.memorydata.memory.lab.d.class, "com.obric.memorydata.plugin");
    L6:
        return r0.a(r1, r2);
    }

    private static final int a(String r5, String r6, String r7) {
        boolean r3 = false;
        if (r5 == null) goto L7;
        Intrinsics.checkNotNull(r6);
        if (StringsKt.startsWith$default(r6, r5, false, 2, null) == false) goto L7;
        boolean r4 = true;
    L8:
        if (r5 == null) goto L12;
        Intrinsics.checkNotNull(r7);
        if (StringsKt.startsWith$default(r7, r5, false, 2, null) == false) goto L12;
        r3 = true;
    L12:
        if (r4 == false) goto L15;
        if (r3 == true) goto L15;
        return -1;
    L15:
        if (r4 == true) goto L18;
        if (r3 == false) goto L18;
        return 1;
    L18:
        Intrinsics.checkNotNull(r7);
        return r6.compareTo(r7);
    L7:
        r4 = false;
        goto L8
    }

    private static final int a(Function2 r2, Object r3, Object r4) {
        return ((Number) ZeusTransformUtils.preCheckCast(((Function2) ZeusTransformUtils.wrapperContextForParams(r2, Function2.class, "com.obric.memorydata.plugin")).invoke(r3, r4), Number.class, "com.obric.memorydata.plugin")).intValue();
    }

    private final com.obric.memorydata.memory.lab.c a(com.obric.memorydata.memory.lab.c r1) {
        AppContext.INSTANCE.isDebug();
        return r1;
    }

    private final String a(String r2, String r3) {
        return "permission_" + r2 + '_' + r3;
    }

    public static /* synthetic */ List a(AILabPermissionRepository r1, List r2, Function1 r3, int r4, Object r5) {
        List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        Function1<? super String, Boolean> r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L6;
        r7 = (Function1) ZeusTransformUtils.preCheckCast(new AILabPermissionRepository$filterApprovalNotificationsByPendingRequest$1(r1), Function1.class, "com.obric.memorydata.plugin");
    L6:
        return r1.a(r6, r7);
    }

    private final JSONObject a(Context r7, String r8, String r9) {
        SharedPreferences r10 = f((Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin"));
        if (r8 == null) goto L8;
        if (r9 == null) goto L8;
        JSONObject r11 = a(r10, a(r8, r9));
        if (r11 == null) goto L8;
        return r11;
    L8:
        Map<String, ?> r12 = r10.getAll();
        Intrinsics.checkNotNullExpressionValue(r12, "getAll(...)");
        JSONObject r6 = a(r12, r8);
        if (r6 == null) goto L15;
        IRunLog r0 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r13 = new StringBuilder().append("V3 permission cache fallback hit preferredUidReady=");
        if (r8 == null) goto L13;
        boolean r14 = true;
    L14:
        IRunLog.a.a(r0, "AILabPermissionRepository", r13.append(r14).toString(), false, 4, null);
        return r6;
    L13:
        r14 = false;
        goto L14
    L15:
        return null;
    }

    private final JSONObject a(SharedPreferences r7, String r8) {
        String r6 = ((SharedPreferences) ZeusTransformUtils.wrapperContextForParams(r7, SharedPreferences.class, "com.obric.memorydata.plugin")).getString(r8, null);     // Catch: JSONException -> L11
        if (r6 == null) goto L16;
        JSONObject r9 = new JSONObject(r6);     // Catch: JSONException -> L11
        if (f10236a.g(r9) != PermissionSchema.V3) goto L8;
        boolean r10 = true;
    L9:
        if (r10 == true) goto L18;
        return null;
    L18:
        return r9;
    L8:
        r10 = false;
        goto L9
    L16:
        return null;
    L11:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AILabPermissionRepository", "Read V3 permission cache failed: " + e.getMessage(), null, 4, null);
        return null;
    }

    public static /* synthetic */ boolean a(AILabPermissionRepository r0, com.obric.memorydata.memory.lab.d r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = (com.obric.memorydata.memory.lab.d) ZeusTransformUtils.preCheckCast(e.c(), com.obric.memorydata.memory.lab.d.class, "com.obric.memorydata.plugin");
    L6:
        return r0.b(r1);
    }

    public static /* synthetic */ boolean a(AILabPermissionRepository r7, com.obric.memorydata.memory.lab.d r8, String r9, String r10, List r11, List r12, List r13, int r14, Object r15) {
        List<String> r16 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        List<String> r17 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
        List<String> r18 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.memorydata.plugin");
        if ((r14 & 1) == 0) goto L5;
        r8 = (com.obric.memorydata.memory.lab.d) ZeusTransformUtils.preCheckCast(e.c(), com.obric.memorydata.memory.lab.d.class, "com.obric.memorydata.plugin");
    L5:
        com.obric.memorydata.memory.lab.d r1 = r8;
        if ((r14 & 2) == 0) goto L8;
        r9 = AppContext.INSTANCE.getServerDeviceId();
    L8:
        String r2 = r9;
        if ((r14 & 4) == 0) goto L11;
        r10 = AppContext.INSTANCE.getUserId();
    L11:
        String r3 = r10;
        if ((r14 & 8) == 0) goto L14;
        r16 = AppSettingsManager.INSTANCE.getRecommendSettings().getAutoMemoryEnableDid();
    L14:
        List<String> r4 = r16;
        if ((r14 & 16) == 0) goto L17;
        r17 = r7.l();
    L17:
        List<String> r5 = r17;
        if ((r14 & 32) == 0) goto L21;
        r18 = r7.m();
    L21:
        return r7.a(r1, r2, r3, r4, r5, r18);
    }

    private final com.obric.memorydata.memory.lab.c b(JSONObject r9, String r10) {
        return new com.obric.memorydata.memory.lab.c(r10, a(r9, BuildConfig.LIBRARY_PACKAGE_NAME, r10), c(r9, BuildConfig.LIBRARY_PACKAGE_NAME, r10), a(r9, r10), b(r9, BuildConfig.LIBRARY_PACKAGE_NAME, r10));
    }

    public static /* synthetic */ boolean b(AILabPermissionRepository r0, com.obric.memorydata.memory.lab.d r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = (com.obric.memorydata.memory.lab.d) ZeusTransformUtils.preCheckCast(e.c(), com.obric.memorydata.memory.lab.d.class, "com.obric.memorydata.plugin");
    L6:
        return r0.c(r1);
    }

    private final int c(JSONObject r4, String r5, String r6) {
        PermissionSchema r3 = g(r4);
        if (r3 != null) goto L5;
        int r7 = -1;
    L7:
        if (r7 == (-1)) goto L33;
        if (r7 != 1) goto L10;
        if (r4 == null) goto L33;
        JSONObject r8 = r4.optJSONObject("permissions");
        if (r8 == null) goto L33;
        JSONObject r9 = r8.optJSONObject(r5);
        if (r9 == null) goto L33;
        JSONObject r10 = r9.optJSONObject(r6);
        if (r10 == null) goto L33;
        return r10.optInt("flag", 0);
    L10:
        if (r7 != 2) goto L23;
        if (r4 == null) goto L19;
        JSONObject r11 = r4.optJSONObject("component");
        if (r11 == null) goto L19;
        JSONObject r12 = r11.optJSONObject(r5);
        if (r12 == null) goto L19;
        if (r12.has(r6) != true) goto L19;
        boolean r13 = true;
    L20:
        if (r13 == false) goto L33;
        return 1;
    L19:
        r13 = false;
        goto L20
    L23:
        throw new NoWhenBranchMatchedException();
    L33:
        return 0;
    L5:
        r7 = b.f10240a[r3.ordinal()];
        goto L7
    }

    private final JSONObject c(int r3) {
        int r2 = 0;
        int r0 = 1;
        if (r3 == 1) goto L6;
        r0 = 0;
    L6:
        JSONObject r4 = new JSONObject();
        if (r0 == 0) goto L9;
        r2 = 2;
    L9:
        r4.put("status", r2);
        r4.put("flag", r0);
        return r4;
    }

    private final void e(Context r7) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(f10237b, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r8.hasNext() == false) goto L6;
        ZeusProviderTransform.notifyChange(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver(), f10236a.h((String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.memorydata.plugin")), null, "com.obric.memorydata.plugin");
        goto L4
    L6:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AILabPermissionRepository", "notifyProviderStatuses keys=" + f10237b, false, 4, null);
    }

    private final SharedPreferences f(Context r2) {
        SharedPreferences r1 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSharedPreferences("ai_lab_permissions", 0);
        Intrinsics.checkNotNullExpressionValue(r1, "getSharedPreferences(...)");
        return r1;
    }

    private final List<com.obric.memorydata.memory.lab.c> f(com.obric.memorydata.memory.lab.d r3) {
        return CollectionsKt.listOf(new com.obric.memorydata.memory.lab.c[]{r3.d(), r3.e(), r3.f(), r3.g()});
    }

    private final SharedPreferences g(Context r2) {
        SharedPreferences r1 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSharedPreferences("AILabStatusPrefs", 0);
        Intrinsics.checkNotNullExpressionValue(r1, "getSharedPreferences(...)");
        return r1;
    }

    private final PermissionSchema g(JSONObject r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        if (c(r2) == false) goto L9;
        return PermissionSchema.V4;
    L9:
        if (r2.has("status") == true) goto L13;
        if (r2.has("component") == true) goto L13;
        return null;
    L13:
        return PermissionSchema.V3;
    }

    private final String g(String r2) {
        return "permission_" + r2 + '_';
    }

    private final Uri h(String r2) {
        Uri r1 = Uri.parse("content://com.obric.memorydata.memory.ailabprovider/" + r2);
        Intrinsics.checkNotNullExpressionValue(r1, "parse(...)");
        return r1;
    }

    private final JSONObject h(Context r12) {
        SharedPreferences r13 = g((Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.memorydata.plugin"));
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(f10237b, Iterable.class, "com.obric.memorydata.plugin");
        boolean r3 = true;
        if (ZeusTransformUtils.instanceOf(r0, Collection.class) == true) goto L5;
    L7:
        Iterator r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L13;
        if (r13.contains((String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin")) == false) goto L9;
        r3 = false;
    L13:
        if (r3 == false) goto L17;
        return null;
    L17:
        return a(r13.getInt("ai_lab_status", 0), r13.getInt("screen_memory", 0), r13.getInt("voice_memory", 0), r13.getInt("auto_memory", 0), r13.getInt("ai_proactive_agent", 0));
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L7;
        goto L7
    }

    private final IStore i() {
        return IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null);
    }

    private static final Unit i(String r1) {
        Intrinsics.checkNotNullParameter(r1, "<unused var>");
        return Unit.INSTANCE;
    }

    private final String j() {
        if (AppContext.INSTANCE.isLogin() == false) goto L8;
        String r0 = AppContext.INSTANCE.getUserId();
        if (a(r0) == true) goto L7;
        return null;
    L7:
        return r0;
    L8:
        return null;
    }

    private final String k() {
        String r0 = AppContext.INSTANCE.getOsDeviceId($$Lambda$AILabPermissionRepository$kkilBUsKeyu4BMTYsUS6OT6PaIw.INSTANCE);
        if (r0 == null) goto L8;
        if (b(r0) == false) goto L8;
        return r0;
    L8:
        return null;
    }

    private final List<String> l() {
        String r9 = i().getString("recommend_settings_auto_memory_pro_enable_did", HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        List<String> r2 = null;
        r2 = (List) ZeusTransformUtils.preCheckCast(u.a().fromJson(r9, new c().getType()), List.class, "com.obric.memorydata.plugin");     // Catch: JsonParseException -> L5 JsonSyntaxException -> L7
    L10:
        if (r2 == null) goto L12;
        return r2;
    L12:
        return CollectionsKt.emptyList();
    L7:
        e = e;
        IRunLog r3 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r1 = new StringBuilder();
    L9:
        IRunLog.a.b(r3, "GsonExt", r1.append("toListObj error : ").append(e).toString(), null, 4, null);
    L5:
        e = e;
        r3 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r1 = new StringBuilder();
        goto L9
    }

    public static /* synthetic */ int lambda$bTkuGI_hg3JfIqngg3ueNOoAdKU(String r0, String r1, String r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ Unit lambda$kkilBUsKeyu4BMTYsUS6OT6PaIw(String r0) {
        return i(r0);
    }

    /* JADX INFO: renamed from: lambda$rqewDNeIhz-5ojyPc9IEGhDM43c, reason: not valid java name */
    public static /* synthetic */ int m728lambda$rqewDNeIhz5ojyPc9IEGhDM43c(Function2 r0, Object r1, Object r2) {
        return a(r0, r1, r2);
    }

    private final List<String> m() {
        String r9 = i().getString("recommend_settings_auto_memory_pro_enable_uid", HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        List<String> r2 = null;
        r2 = (List) ZeusTransformUtils.preCheckCast(u.a().fromJson(r9, new d().getType()), List.class, "com.obric.memorydata.plugin");     // Catch: JsonParseException -> L5 JsonSyntaxException -> L7
    L10:
        if (r2 == null) goto L12;
        return r2;
    L12:
        return CollectionsKt.emptyList();
    L7:
        e = e;
        IRunLog r3 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r1 = new StringBuilder();
    L9:
        IRunLog.a.b(r3, "GsonExt", r1.append("toListObj error : ").append(e).toString(), null, 4, null);
    L5:
        e = e;
        r3 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r1 = new StringBuilder();
        goto L9
    }

    private final JSONObject n() {
        String r2 = i().getString(g(), "");     // Catch: JSONException -> L9
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L6;
        return null;
    L6:
        JSONObject r3 = new JSONObject(r2);     // Catch: JSONException -> L9
        if (c(r3) == true) goto L15;
        return null;
    L15:
        return r3;
    L9:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AILabPermissionRepository", "Read V4 permission cache failed: " + e.getMessage(), null, 4, null);
        return null;
    }

    public final int a(String r2, com.obric.memorydata.memory.lab.d r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "state");
        switch(r2.hashCode()) {
            case -1425020527: goto L24;
            case -33328734: goto L20;
            case 11238574: goto L16;
            case 901473115: goto L10;
            case 1347676212: goto L6;
            default: goto L31;
        };
    L31:
        return 0;
    L6:
        if (r2.equals("screen_memory") == false) goto L32;
        com.obric.memorydata.memory.lab.c r1 = r3.d();
    L28:
        return r1.e();
    L32:
        return 0;
    L10:
        if (r2.equals("ai_lab_status") == true) goto L13;
        return 0;
    L13:
        if (r3.c() == false) goto L29;
        return 1;
    L29:
        return 0;
    L16:
        if (r2.equals("voice_memory") == false) goto L34;
        r1 = r3.e();
        goto L28
    L34:
        return 0;
    L20:
        if (r2.equals("ai_proactive_agent") == false) goto L35;
        r1 = r3.g();
        goto L28
    L35:
        return 0;
    L24:
        if (r2.equals("auto_memory") == false) goto L36;
        r1 = r3.f();
        goto L28
    L36:
        return 0;
    }

    public final int a(JSONObject r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r5, "permissionName");
        PermissionSchema r2 = g(r3);
        if (r2 != null) goto L5;
        int r6 = -1;
    L7:
        if (r6 != (-1)) goto L9;
        return 0;
    L9:
        if (r6 != 1) goto L11;
        if (r3 == null) goto L34;
        JSONObject r7 = r3.optJSONObject("permissions");
        if (r7 == null) goto L35;
        JSONObject r8 = r7.optJSONObject(r4);
        if (r8 == null) goto L36;
        JSONObject r9 = r8.optJSONObject(r5);
        if (r9 != null) goto L28;
        return 0;
    L28:
        return r9.optInt("status", 0);
    L36:
        return 0;
    L35:
        return 0;
    L34:
        return 0;
    L11:
        if (r6 != 2) goto L19;
        if (r3 == null) goto L30;
        JSONObject r10 = r3.optJSONObject("component");
        if (r10 == null) goto L31;
        JSONObject r11 = r10.optJSONObject(r4);
        if (r11 != null) goto L33;
        return 0;
    L33:
        return r11.optInt(r5, 0);
    L31:
        return 0;
    L30:
        return 0;
    L19:
        throw new NoWhenBranchMatchedException();
    L5:
        r6 = b.f10240a[r2.ordinal()];
        goto L7
    }

    public final a a(Context r3, String r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "context");
        JSONObject r0 = n();
        if (r0 == null) goto L7;
        return new a(r0, PermissionSchema.V4);
    L7:
        if (r4 != null) goto L9;
    L11:
        r4 = null;
    L12:
        JSONObject r2 = a(r5, r4, k());
        if (r2 != null) goto L15;
        return null;
    L15:
        return new a(r2, PermissionSchema.V3);
    L9:
        if (a(r4) == false) goto L11;
        goto L11
    }

    public final com.obric.memorydata.memory.lab.d a(JSONObject r10) {
        return new com.obric.memorydata.memory.lab.d(g(r10), r10, d(r10), a(b(r10, "screen_memory")), a(b(r10, "voice_memory")), a(b(r10, "auto_memory")), a(b(r10, "ai_proactive_agent")));
    }

    public final String a(com.obric.memorydata.memory.lab.d r4) {
        Intrinsics.checkNotNullParameter(r4, "state");
        StringBuilder r3 = new StringBuilder();
        r3.append("schema=").append(r4.a()).append(", labVisible=").append(r4.c()).append(", screen=").append(r4.d().b()).append('/').append(r4.d().c()).append('/').append(r4.d().e()).append(", voice=").append(r4.e().b()).append('/').append(r4.e().c()).append('/').append(r4.e().e()).append(", auto=").append(r4.f().b()).append('/').append(r4.f().c()).append('/').append(r4.f().e()).append(", aiProactive=");
        r3.append(r4.g().b()).append('/').append(r4.g().c()).append('/').append(r4.g().e());
        return r3.toString();
    }

    public final List<String> a(com.obric.memorydata.memory.lab.d r9, com.obric.memorydata.memory.lab.d r10) {
        Intrinsics.checkNotNullParameter(r10, "currentState");
        if (r9 == null) goto L5;
        JSONObject r0 = r9.b();
    L6:
        if (r0 == null) goto L38;
        if (r10.b() == null) goto L38;
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(f(r9), Iterable.class, "com.obric.memorydata.plugin");
        Map r2 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r11, 10)), 16)), Map.class, "com.obric.memorydata.plugin");
        Iterator r12 = r11.iterator();
    L12:
        if (r12.hasNext() == false) goto L14;
        Object r3 = r12.next();
        r2.put(((com.obric.memorydata.memory.lab.c) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.memory.lab.c.class, "com.obric.memorydata.plugin")).a(), r3);
        goto L12
    L14:
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(f(r10), Iterable.class, "com.obric.memorydata.plugin");
        Collection r13 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r14 = r8.iterator();
    L16:
        if (r14.hasNext() == false) goto L31;
        Object r15 = r14.next();
        com.obric.memorydata.memory.lab.c r4 = (com.obric.memorydata.memory.lab.c) ZeusTransformUtils.preCheckCast(r15, com.obric.memorydata.memory.lab.c.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.memory.lab.c r5 = (com.obric.memorydata.memory.lab.c) ZeusTransformUtils.preCheckCast(r2.get(r4.a()), com.obric.memorydata.memory.lab.c.class, "com.obric.memorydata.plugin");
        boolean r6 = true;
        if (r4.d() == false) goto L28;
        if (r5 != null) goto L21;
    L23:
        boolean r7 = false;
    L24:
        if (r7 == false) goto L28;
        if (r4.b() != 2) goto L28;
    L29:
        if (r6 == false) goto L16;
        r13.add(r15);
        goto L16
    L21:
        if (r5.b() != 1) goto L23;
        r7 = true;
    L28:
        r6 = false;
        goto L29
    L31:
        Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r13, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r17 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r16, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r18 = r16.iterator();
    L33:
        if (r18.hasNext() == false) goto L36;
        r17.add(((com.obric.memorydata.memory.lab.c) ZeusTransformUtils.preCheckCast(r18.next(), com.obric.memorydata.memory.lab.c.class, "com.obric.memorydata.plugin")).a());
        goto L33
    L36:
        return (List) ZeusTransformUtils.preCheckCast(r17, List.class, "com.obric.memorydata.plugin");
    L38:
        return CollectionsKt.emptyList();
    L5:
        r0 = null;
        goto L6
    }

    public final List<String> a(List<String> r12, Function1<? super String, Boolean> r13) {
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
        Function1 r14 = (Function1) ZeusTransformUtils.wrapperContextForParams(r13, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "permissionNames");
        Intrinsics.checkNotNullParameter(r14, "hasPendingRequest");
        Iterable r15 = (Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin");
        Collection r16 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r17 = r15.iterator();
    L4:
        if (r17.hasNext() == false) goto L11;
        Object r1 = r17.next();
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1, String.class, "com.obric.memorydata.plugin");
        boolean r3 = ((Boolean) ZeusTransformUtils.preCheckCast(r14.invoke(r2), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        if (r3 == true) goto L8;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AILabPermissionRepository", "skip approval notification because " + ("local apply record missing permissionName=" + r2), false, 4, null);
    L8:
        if (r3 == false) goto L4;
        r16.add(r1);
        goto L4
    L11:
        return (List) ZeusTransformUtils.preCheckCast(r16, List.class, "com.obric.memorydata.plugin");
    }

    public final ar<com.obric.memorydata.memory.lab.d> a() {
        return e;
    }

    public final JSONObject a(int r5, int r6, int r7, int r8, int r9) {
        JSONObject r4 = new JSONObject();
        JSONObject r0 = new JSONObject();
        JSONObject r1 = new JSONObject();
        AILabPermissionRepository r2 = f10236a;
        r1.put("visible", r2.c(r5));
        Unit r10 = Unit.INSTANCE;
        r0.put("PKG_LAB", r1);
        JSONObject r11 = new JSONObject();
        r11.put("screen_memory", r2.c(r6));
        r11.put("voice_memory", r2.c(r7));
        r11.put("auto_memory", r2.c(r8));
        r11.put("ai_proactive_agent", r2.c(r9));
        Unit r12 = Unit.INSTANCE;
        r0.put(BuildConfig.LIBRARY_PACKAGE_NAME, r11);
        Unit r13 = Unit.INSTANCE;
        r4.put("permissions", r0);
        return r4;
    }

    public final JSONObject a(Map<String, ?> r9, String r10) {
        Map r11 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "entries");
        if (r10 != null) goto L5;
    L10:
        final String r8 = null;
    L11:
        Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast(r11.keySet(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r13 = r12.iterator();
    L13:
        if (r13.hasNext() == false) goto L17;
        Object r3 = r13.next();
        if (StringsKt.startsWith$default((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"), "permission_", false, 2, null) == false) goto L13;
        r2.add(r3);
        goto L13
    L17:
        Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        final Function2 r4 = new $$Lambda$AILabPermissionRepository$bTkuGI_hg3JfIqngg3ueNOoAdKU(r8);
        Iterator r15 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.sortedWith(r14, new $$Lambda$AILabPermissionRepository$rqewDNeIhz5ojyPc9IEGhDM43c(r4)), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L19:
        if (r15.hasNext() == false) goto L30;
        Object r16 = r11.get((String) ZeusTransformUtils.preCheckCast(r15.next(), String.class, "com.obric.memorydata.plugin"));
        if (ZeusTransformUtils.instanceOf(r16, String.class) == false) goto L23;
        String r17 = (String) ZeusTransformUtils.preCheckCast(r16, String.class, "com.obric.memorydata.plugin");
    L24:
        if (r17 == null) goto L19;
        JSONObject r5 = new JSONObject(r17);     // Catch: JSONException -> L31
        if (f10236a.g(r5) != PermissionSchema.V3) goto L19;
        return r5;
    L23:
        r17 = null;
        goto L24
    L30:
        return null;
    L5:
        if (a(r10) == true) goto L8;
        r10 = null;
    L8:
        if (r10 == null) goto L10;
        r8 = g(r10);
        goto L11
    }

    public final void a(long r2) {
        i().save(h(), r2);
    }

    public final void a(Context r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r12, "context");
        if (f == false) goto L5;
        return;
    L5:
        monitor-enter(this);
    L23:
        th = move-exception;
        throw th;
    L7:
        if (f == false) goto L10;
        monitor-exit(this);
        return;
    L10:
        Context r13 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r12.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L23
        AILabPermissionRepository r0 = f10236a;     // Catch: Throwable -> L23
        String r1 = r0.j();     // Catch: Throwable -> L23
        Intrinsics.checkNotNull(r13);     // Catch: Throwable -> L23
        a r2 = r0.a(r13, r1);     // Catch: Throwable -> L23
        if (r2 == null) goto L14;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AILabPermissionRepository", "init cache hit uid=" + r1 + " schema=" + r2.b(), false, 4, null);     // Catch: Throwable -> L23
        JSONObject r3 = r2.a();     // Catch: Throwable -> L23
    L13:
        r0.a(r13, r3);     // Catch: Throwable -> L23
    L20:
        f = true;     // Catch: Throwable -> L23
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L23
        monitor-exit(this);
        return;
    L14:
        if (r1 != null) goto L19;
        r3 = r0.h(r13);     // Catch: Throwable -> L23
        if (r3 == null) goto L18;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AILabPermissionRepository", "init legacy provider snapshot fallback " + r0.b(r3), false, 4, null);     // Catch: Throwable -> L23
        goto L13
    L18:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AILabPermissionRepository", "init cache miss: account not ready and legacy provider snapshot empty", false, 4, null);     // Catch: Throwable -> L23
        goto L20
    L19:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AILabPermissionRepository", "init cache miss uid=" + r1, false, 4, null);     // Catch: Throwable -> L23
        goto L20
    }

    public final void a(Context r9, JSONObject r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r10, "permissionData");
        com.obric.memorydata.memory.lab.d r12 = a(r10);
        d.b(r12);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AILabPermissionRepository", "publishPermissionState " + a(r12), false, 4, null);
        Context r13 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r11.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r13, "getApplicationContext(...)");
        e(r13);
    }

    public final void a(JSONObject r2, String r3, String r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "permissionData");
        Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r4, "permissionName");
        JSONObject r0 = r2.optJSONObject("permissions");
        if (r0 != null) goto L5;
        r0 = new JSONObject();
        r2.put("permissions", r0);
    L5:
        JSONObject r1 = r0.optJSONObject(r3);
        if (r1 != null) goto L8;
        r1 = new JSONObject();
        r0.put(r3, r1);
    L8:
        JSONObject r6 = r1.optJSONObject(r4);
        if (r6 != null) goto L11;
        r6 = new JSONObject();
        r6.put("flag", 1);
        r1.put(r4, r6);
    L11:
        r6.put("status", r5);
    }

    public final boolean a(int r1) {
        if (r1 == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean a(com.obric.memorydata.memory.lab.d r3, long r4, long r6, long r8) {
        Intrinsics.checkNotNullParameter(r3, "state");
        if (d(r3) == true) goto L6;
        return false;
    L6:
        if (r4 > 0) goto L8;
    L9:
        return true;
    L8:
        if ((r6 - r4) > r8) goto L9;
        return false;
    }

    public final boolean a(com.obric.memorydata.memory.lab.d r3, String r4, String r5, List<String> r6, List<String> r7, List<String> r8) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "state");
        Intrinsics.checkNotNullParameter(r4, "serverDeviceId");
        Intrinsics.checkNotNullParameter(r5, "userId");
        Intrinsics.checkNotNullParameter(r9, "settingsEnableDids");
        Intrinsics.checkNotNullParameter(r10, "storeEnableDids");
        Intrinsics.checkNotNullParameter(r11, "storeEnableUids");
        if (a(r3.f().e()) == false) goto L5;
    L12:
        return true;
    L5:
        if (r9.contains(r4) == true) goto L12;
        if (r10.contains(r4) == true) goto L12;
        if (r11.contains(r5) == true) goto L12;
        return false;
    }

    public final boolean a(String r3) {
        if (r3 == null) goto L5;
        String r4 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin")).toString();
    L6:
        CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L9;
    L12:
        boolean r5 = true;
    L13:
        if (r5 == false) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(r4, "0") == false) goto L17;
        return false;
    L17:
        return true;
    L9:
        if (r2.length() == 0) goto L12;
        r5 = false;
        goto L13
    L5:
        r4 = null;
        goto L6
    }

    public final boolean a(JSONObject r6, String r7) {
        Intrinsics.checkNotNullParameter(r7, "permissionName");
        PermissionSchema r0 = g(r6);
        if (r0 != null) goto L5;
        int r1 = -1;
    L7:
        if (r1 == (-1)) goto L24;
        if (r1 == 1) goto L19;
        if (r1 != 2) goto L17;
        if (Intrinsics.areEqual(r7, "screen_memory") == true) goto L26;
        if (d(r6) == true) goto L26;
        return false;
    L26:
        return true;
    L17:
        throw new NoWhenBranchMatchedException();
    L19:
        if (d(r6) == true) goto L21;
        return false;
    L21:
        if (b(c(r6, BuildConfig.LIBRARY_PACKAGE_NAME, r7)) == true) goto L26;
        return false;
    L24:
        return Intrinsics.areEqual(r7, "screen_memory");
    L5:
        r1 = b.f10240a[r0.ordinal()];
        goto L7
    }

    public final int b(JSONObject r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r4, "permissionName");
        if (a(r2, r3, r4) != 2) goto L5;
        return 1;
    L5:
        return 0;
    }

    public final long b() {
        return i().getLong(h(), 0);
    }

    public final String b(JSONObject r1) {
        return a(a(r1));
    }

    public final JSONObject b(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        JSONObject r2 = f();
        f10236a.a(r4, r2);
        return r2;
    }

    public final JSONObject b(Context r3, String r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "context");
        a r2 = a(r5, r4);
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.a();
    }

    public final boolean b(int r1) {
        if ((r1 & 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean b(com.obric.memorydata.memory.lab.d r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
        return a(r2.d().e());
    }

    public final boolean b(String r2) {
        CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L5;
    L8:
        boolean r3 = true;
    L10:
        return !r3;
    L5:
        if (StringsKt.isBlank(r1) == true) goto L8;
        r3 = false;
        goto L10
    }

    public final void c() {
        i().remove(new String[]{h()});
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AILabPermissionRepository", "clear unlock last get permission time", false, 4, null);
    }

    public final void c(Context r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "context");
        SharedPreferences.Editor r6 = g(r8).edit();
        r6.clear();
        r6.apply();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AILabPermissionRepository", "clear legacy provider snapshot", false, 4, null);
    }

    public final void c(String r7) {
        Intrinsics.checkNotNullParameter(r7, "permissionName");
        i().save(f(r7), true);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AILabPermissionRepository", "mark approval notification pending permissionName=" + r7, false, 4, null);
    }

    public final boolean c(com.obric.memorydata.memory.lab.d r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
        return a(r2.e().e());
    }

    public final boolean c(JSONObject r5) {
        if (r5 == null) goto L20;
        JSONObject r6 = r5.optJSONObject("permissions");
        if (r6 == null) goto L24;
        JSONObject r1 = r6.optJSONObject("PKG_LAB");
        if (r1 == null) goto L21;
        JSONObject r2 = r1.optJSONObject("visible");
        if (r2 != null) goto L12;
        return false;
    L12:
        if (r2.has("flag") == true) goto L15;
        return false;
    L15:
        if (b(r2.optInt("flag", 0)) == true) goto L17;
    L18:
        return true;
    L17:
        if (r6.optJSONObject(BuildConfig.LIBRARY_PACKAGE_NAME) != null) goto L18;
        return false;
    L21:
        return false;
    L24:
        return false;
    L20:
        return false;
    }

    public final void d() {
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(c, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        e((String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.memorydata.plugin"));
        goto L4
    }

    public final void d(Context r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "context");
        SharedPreferences.Editor r6 = f(r8).edit();
        r6.clear();
        r6.apply();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AILabPermissionRepository", "clear V3 permission cache", false, 4, null);
    }

    public final boolean d(com.obric.memorydata.memory.lab.d r5) {
        Intrinsics.checkNotNullParameter(r5, "state");
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(f(r5), Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, Collection.class) == true) goto L5;
    L7:
        Iterator r6 = r4.iterator();
    L9:
        if (r6.hasNext() == false) goto L17;
        com.obric.memorydata.memory.lab.c r7 = (com.obric.memorydata.memory.lab.c) ZeusTransformUtils.preCheckCast(r6.next(), com.obric.memorydata.memory.lab.c.class, "com.obric.memorydata.plugin");
        if (r7.d() == true) goto L13;
    L15:
        boolean r8 = false;
    L16:
        if (r8 == false) goto L9;
        return true;
    L13:
        if (r7.b() != 1) goto L15;
        r8 = true;
    L17:
        return false;
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L7;
        goto L7
    }

    public final boolean d(String r2) {
        Intrinsics.checkNotNullParameter(r2, "permissionName");
        return i().getBoolean(f(r2), false);
    }

    public final boolean d(JSONObject r1) {
        if (e(r1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final int e(JSONObject r5) {
        PermissionSchema r0 = g(r5);
        if (r0 != null) goto L5;
        int r1 = -1;
    L7:
        if (r1 == (-1)) goto L33;
        if (r1 != 1) goto L10;
        if (r5 == null) goto L28;
        JSONObject r6 = r5.optJSONObject("permissions");
        if (r6 == null) goto L28;
        JSONObject r7 = r6.optJSONObject("PKG_LAB");
        if (r7 == null) goto L28;
        JSONObject r8 = r7.optJSONObject("visible");
        if (r8 == null) goto L28;
        int r9 = r8.optInt("flag", 0);
    L30:
        if (b(r9) == false) goto L33;
        return 1;
    L28:
        r9 = 0;
        goto L30
    L10:
        if (r1 != 2) goto L19;
        if (r5 != null) goto L13;
    L15:
        boolean r4 = false;
    L16:
        if (r4 == false) goto L33;
        return 1;
    L13:
        if (r5.optInt("status", 4) != 5) goto L15;
        r4 = true;
        goto L16
    L19:
        throw new NoWhenBranchMatchedException();
    L33:
        return 0;
    L5:
        r1 = b.f10240a[r0.ordinal()];
        goto L7
    }

    public final void e() {
        i().remove(new String[]{g()});
    }

    public final void e(String r7) {
        Intrinsics.checkNotNullParameter(r7, "permissionName");
        i().remove(new String[]{f(r7)});
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AILabPermissionRepository", "clear approval notification pending permissionName=" + r7, false, 4, null);
    }

    public final boolean e(com.obric.memorydata.memory.lab.d r5) {
        Intrinsics.checkNotNullParameter(r5, "state");
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(f(r5), Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, Collection.class) == true) goto L5;
    L7:
        Iterator r6 = r4.iterator();
    L9:
        if (r6.hasNext() == false) goto L15;
        if (((com.obric.memorydata.memory.lab.c) ZeusTransformUtils.preCheckCast(r6.next(), com.obric.memorydata.memory.lab.c.class, "com.obric.memorydata.plugin")).b() != 2) goto L13;
        boolean r7 = true;
    L14:
        if (r7 == false) goto L9;
        return true;
    L13:
        r7 = false;
    L15:
        return false;
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L7;
        goto L7
    }

    public final String f(String r2) {
        Intrinsics.checkNotNullParameter(r2, "permissionName");
        return "ai_lab_approval_notification_pending_" + r2;
    }

    public final JSONObject f() {
        JSONObject r7 = new JSONObject();
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(c, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.memorydata.plugin");
        JSONObject r6 = new JSONObject();
        r6.put("status", 0);
        r6.put("flag", 0);
        Unit r3 = Unit.INSTANCE;
        r7.put(r1, r6);
        goto L4
    L6:
        JSONObject r2 = new JSONObject();
        JSONObject r4 = new JSONObject();
        JSONObject r5 = new JSONObject();
        JSONObject r8 = new JSONObject();
        r8.put("status", 0);
        r8.put("flag", 0);
        Unit r9 = Unit.INSTANCE;
        r5.put("visible", r8);
        Unit r10 = Unit.INSTANCE;
        r4.put("PKG_LAB", r5);
        r4.put(BuildConfig.LIBRARY_PACKAGE_NAME, r7);
        Unit r11 = Unit.INSTANCE;
        r2.put("permissions", r4);
        return r2;
    }

    public final void f(JSONObject r3) {
        Intrinsics.checkNotNullParameter(r3, "permissionData");
        IStore r0 = i();
        String r2 = g();
        String r4 = r3.toString();
        Intrinsics.checkNotNullExpressionValue(r4, "toString(...)");
        r0.save(r2, r4);
    }

    public final String g() {
        return "ai_lab_permission_v4";
    }

    public final String h() {
        return "ai_lab_unlock_last_get_permission_time";
    }
}
