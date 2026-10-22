package com.obric.memorydata.debug;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Process;
import android.provider.Settings;
import androidx.exifinterface.media.ExifInterface;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.crypto.utils.CryptoConst;
import com.bytedance.news.common.service.manager.ext.ServiceManagerExtKt;
import com.google.gson.JsonObject;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.aikernel.sdk.ext.CozeCloudExt;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.aiproactive.api.IProactiveService;
import com.obric.capabilitykit.entity.EntityContentProvider;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.IndexProgress;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.PhotoEntity;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.capabilitykit.entity.search.InAppSearchResult;
import com.obric.memorydata.aikernelcore.WebSocketManager;
import com.obric.memorydata.database.dao.RawObservationDao;
import com.obric.memorydata.database.entity.ChatMessage;
import com.obric.memorydata.database.entity.MemoryKeyInfoEntity;
import com.obric.memorydata.database.entity.RawObservationEntity;
import com.obric.memorydata.database.entity.hb;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.device.DeviceInfoState;
import com.obric.memorydata.middleware.api.device.SelfCollectionSupportType;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.store.IStore;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.obric.memorydata.personalcontext.EntityManager;
import com.obric.memorydata.personalcontext.api.EntityCollectorService;
import com.obric.memorydata.personalcontext.api.IEntityCollectorService;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.obric.memorydata.personalcontext.api.PersonalContextAPI;
import com.obric.memorydata.personalcontext.bridge.AppEntityIndexBridgeAPIImpl;
import com.obric.memorydata.personalcontext.q;
import com.obric.memorydata.personalcontext.util.g;
import com.obric.memorydata.personalcontext.util.h;
import com.obric.memorydata.task.impl.TaskRequest;
import com.obric.memorydata.task.impl.TaskResult;
import com.obric.memorydata.utils.handler.GlobalHandlerUtil;
import com.obric.memorydata.utils.threadpool.ThreadPoolContainer;
import com.obric.memorydata.utils.u;
import com.obric.memorydata.utils.y;
import com.volcengine.zeus.service.PluginService;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.i;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 k2\u00020\u0001:\u0002klB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J@\u0010\r\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u000e0\t2\u0006\u0010\u000f\u001a\u00020\n2\u001a\u0010\u0010\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u000e0\tH\u0002J,\u0010\u0011\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u000e0\t2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\nH\u0002J\"\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0014H\u0016J\u0014\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\nH\u0002J\u001c\u0010 \u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\n2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#H\u0002J\u0014\u0010$\u001a\u00020\u001c2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#H\u0002J\u001c\u0010%\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\n2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#H\u0002J\b\u0010'\u001a\u00020\u001cH\u0002J\b\u0010(\u001a\u00020)H\u0002J\u0018\u0010*\u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\n2\u0006\u0010+\u001a\u00020\nH\u0002J\u0012\u0010,\u001a\u00020\u001c2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002J\"\u0010-\u001a\u00020\u001c2\u0006\u0010.\u001a\u00020)2\u0006\u0010/\u001a\u00020\n2\b\b\u0002\u00100\u001a\u000201H\u0002J\u0012\u00102\u001a\u00020\u001c2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002J \u00103\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\u00104\u001a\u0004\u0018\u0001052\u0006\u0010\u0012\u001a\u00020\nH\u0002J\u0010\u00106\u001a\u0002072\u0006\u0010\u0012\u001a\u00020\nH\u0002J\u0018\u00108\u001a\u00020\u00072\u0006\u00109\u001a\u0002072\u0006\u0010:\u001a\u00020\nH\u0002J\u0010\u0010;\u001a\u00020\n2\u0006\u0010<\u001a\u00020\nH\u0002J\"\u0010=\u001a\u00020\u001c2\u0006\u0010.\u001a\u00020)2\u0006\u0010/\u001a\u00020\n2\b\b\u0002\u00100\u001a\u000201H\u0002J\u0010\u0010>\u001a\u00020\u001c2\u0006\u0010?\u001a\u00020@H\u0002J\"\u0010A\u001a\u00020\u001c2\u0006\u0010B\u001a\u00020\n2\u0006\u0010C\u001a\u00020\n2\b\b\u0002\u0010D\u001a\u00020)H\u0002J\b\u0010E\u001a\u00020)H\u0002J1\u0010F\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010G0\t2\u0006\u0010H\u001a\u00020\n2\u0006\u0010I\u001a\u00020\n2\n\b\u0002\u0010J\u001a\u0004\u0018\u00010)H\u0002¢\u0006\u0002\u0010KJ\u0012\u0010L\u001a\u00020\u001c2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002J\b\u0010M\u001a\u00020\u001cH\u0002J\u0012\u0010N\u001a\u00020\u001c2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002J\u0012\u0010O\u001a\u00020\u001c2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002J\u0012\u0010P\u001a\u00020\u001c2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002J&\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u00140\t2\u0006\u0010R\u001a\u00020\n2\u0006\u0010S\u001a\u00020\n2\u0006\u0010T\u001a\u00020\nH\u0002J\b\u0010U\u001a\u00020VH\u0002J.\u0010W\u001a\u0004\u0018\u0001012\u0006\u0010R\u001a\u00020\n2\b\u0010X\u001a\u0004\u0018\u00010\n2\u0006\u0010&\u001a\u00020\n2\b\b\u0002\u0010Y\u001a\u00020\u0014H\u0002J\u0012\u0010Z\u001a\u0004\u0018\u0001012\u0006\u0010[\u001a\u00020\nH\u0002J\u0018\u0010\\\u001a\u0002012\u0006\u0010]\u001a\u0002012\u0006\u0010&\u001a\u00020\nH\u0002J@\u0010^\u001a\u00020\u001c2\u0006\u0010R\u001a\u00020\n2\u0006\u0010_\u001a\u00020\n2\u0006\u0010.\u001a\u00020)2\u0006\u0010/\u001a\u00020\n2\n\b\u0002\u0010`\u001a\u0004\u0018\u00010a2\n\b\u0002\u0010b\u001a\u0004\u0018\u000101H\u0002J0\u0010c\u001a\u00020\u001c2\u0006\u0010R\u001a\u00020\n2\u0006\u0010_\u001a\u00020\n2\u0006\u0010.\u001a\u00020)2\u0006\u0010/\u001a\u00020\n2\u0006\u0010d\u001a\u000205H\u0002J \u0010e\u001a\u00020\u001c2\u0006\u0010f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010g\u001a\u00020\nH\u0002J\u0018\u0010h\u001a\u00020\u001c2\u0006\u0010i\u001a\u00020\n2\u0006\u0010j\u001a\u00020\nH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000¨\u0006m"}, d2 = {"Lcom/obric/memorydata/debug/ReleaseAdbService;", "Landroid/app/Service;", "<init>", "()V", "lock", "", "REQUEST_TIMEOUT_MS", "", "getListFromSettingsOrDefault", "", "", "key", "defaultList", "processSqlResult", "", "sql", "result", "queryMemoryDebugSql", "dbName", "onStartCommand", "", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "flags", "startId", "onBind", "Landroid/os/IBinder;", "backupFiles", "", "context", "Landroid/content/Context;", "taskId", "notifyAppIndexWrapper", LocationMonitorConst.TAG, "finishRunnable", "Ljava/lang/Runnable;", "indexAllContactSmsEntity", "notifyAppReindex", ObricMemoryConstants.KEY_PACKAGE_NAME, "startDownloadModel", "isAllModelDownloadSuccess", "", "logcatInfo", "info", "seedRawObservationImages", "publishSeedRawObservationImagesResult", "success", "message", "data", "Lorg/json/JSONObject;", "clearMemoryDebugData", "parseClearMemoryDebugTables", "array", "Lorg/json/JSONArray;", "getMemoryDebugTableDb", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "queryTableCount", "db", "table", "quoteSqlIdentifier", MemoryKeyInfoEntity.KEY_IDENTIFIER, "publishClearMemoryDebugDataResult", "publishAiProactiveAdbCommandStatus", "status", "Lcom/obric/memorydata/debug/AiProactiveAdbCommandStatus;", "writeResultToFile", "fileName", Params.CONTENT, "append", "checkDebugSignature", "sendAppSearchRequest", "Lcom/obric/capabilitykit/entity/search/InAppSearchResult;", "appPackage", ChatMessage.TYPE_QUERY, "isUseRanking", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Ljava/util/List;", "setSearchControlParams", "clearSearchControlParams", "setHarnessKv", "clearHarnessKv", "runHarnessCase", "resolveTurnIndices", "traceId", "turnIndicesParam", "compositeMode", "getHarnessTraceBaseDir", "Ljava/io/File;", "loadHarnessCaseInput", "rawInputJson", "turnIndex", "parseHarnessInputJson", "rawJson", "normalizeHarnessTaskInput", AILabCheckPermissionTask.KEY_SOURCE, "publishHarnessCaseResult", "mode", "taskResult", "Lcom/obric/memorydata/task/impl/TaskResult;", "inputParams", "publishCompositeHarnessCaseResult", "turnResults", "restoreHarnessKv", "repoName", "previousValue", "changePhotoAppEntity", "field", EventBody.KEY_VALUE, "Companion", "Response", "app_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ReleaseAdbService extends PluginService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f9856a = null;
    private static final List<String> d = null;
    private static final List<String> e = null;
    private static final List<String> f = null;
    private static final Set<String> g = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f9857b;
    private final long c;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001B)\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/debug/ReleaseAdbService$Response;", "", "isSuccessful", "", "errorMessage", "", "data", "Lcom/google/gson/JsonObject;", "<init>", "(ZLjava/lang/String;Lcom/google/gson/JsonObject;)V", "()Z", "setSuccessful", "(Z)V", "getErrorMessage", "()Ljava/lang/String;", "setErrorMessage", "(Ljava/lang/String;)V", "getData", "()Lcom/google/gson/JsonObject;", "setData", "(Lcom/google/gson/JsonObject;)V", "app_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Response {
        private JsonObject data;
        private String errorMessage;
        private boolean isSuccessful;

        public Response() {
            this(false, null, null, 7, null);
        }

        public Response(boolean r1, String r2, JsonObject r3) {
            this.isSuccessful = r1;
            this.errorMessage = r2;
            this.data = r3;
        }

        public /* synthetic */ Response(boolean r2, String r3, JsonObject r4, int r5, DefaultConstructorMarker r6) {
            if ((r5 & 1) == 0) goto L6;
            r2 = true;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r3 = null;
        L9:
            if ((r5 & 4) == 0) goto L11;
            r4 = null;
        L11:
            this(r2, r3, r4);
        }

        public final JsonObject getData() {
            return this.data;
        }

        public final String getErrorMessage() {
            return this.errorMessage;
        }

        public final boolean isSuccessful() {
            return this.isSuccessful;
        }

        public final void setData(JsonObject r1) {
            this.data = r1;
        }

        public final void setErrorMessage(String r1) {
            this.errorMessage = r1;
        }

        public final void setSuccessful(boolean r1) {
            this.isSuccessful = r1;
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b?\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\"\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0014\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00050EX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00050EX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00050EX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00050IX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006J"}, d2 = {"Lcom/obric/memorydata/debug/ReleaseAdbService$Companion;", "", "<init>", "()V", "TAG", "", "CMD_REINDEX_ALL_DATA", "CMD_SWITCH_ON_INSTANT_ENTITY_INDEX", "CMD_QUERY_INDEX_STATE", "CMD_INDEX_COUNT", "CMD_MEDIA_META_COUNT", "CMD_ALL_MODEL_SUCCESS", "CMD_DOWNLOAD_MODEL", "CMD_START_MEDIA_META_FORCE_SCAN", "CMD_STOP_MEDIA_META_FORCE_SCAN", "CMD_QUERY_ALBUM_INDEX_PROGRESS", "CMD_IMPORT_DB", "CMD_EXPORT_DB", "CMD_DISABLE_ENTITY_SYNC", "CMD_QUERY_ALBUM_PHOTO", "CMD_REINDEX_PHOTO_FIELD", "CMD_SET_SEARCH_CONTROL_PARAMS", "CMD_CLEAR_SEARCH_CONTROL_PARAMS", "CMD_SET_HARNESS_KV", "CMD_CLEAR_HARNESS_KV", "CMD_RUN_HARNESS_CASE", "CMD_TRIGGER_ANR", "CMD_RUN_MEMORY_DB_SQL", "CMD_RUN_MEMORY_DB_SQL_BY_FILE", "CMD_SEED_RAW_OBSERVATION_IMAGES", "CMD_CLEAR_MEMORY_DEBUG_DATA", "CMD_CONNECT_AIKERNEL_WS", "CMD_SET_AI_PROACTIVE_ENABLED", "TASK_MOBILE_MEM_BUILD", "TASK_UNION_MEMORY_BUILD", "TASK_MEMORY_PROCESS", "TASK_RAW_OBSERVATION_SEED", "TASK_RAW_OBSERVATION_IMAGE_UPLOAD", "TASK_SPEAKER_PROFILE_MAPPING", "TASK_MEMORY_BASE_BUILD", "TASK_MEMORY_SCENE_BUILD", "PARAM_CMD", "PARAM_ENABLED", "PARAM_VALUE", "PARAM_DB_NAME", "PARAM_REPO", "PARAM_KEY", "PARAM_MODE", "PARAM_TRACE_ID", "PARAM_PACKAGE_NAME", "PARAM_INPUT_JSON", "PARAM_KEY_PREFIX", "PARAM_TURN_INDICES", "PARAM_COMPOSITE_MODE", "PARAM_FIELD", "PARAM_APPEND", "PARAM_FILE_NAME", "PARAM_SEARCH_BY_CLIP", "PARAM_SEARCH_CAPTION", "PARAM_SEARCH_TAG", "PARAM_SEARCH_OCR", "TAG_CONTACT_SMS", "TAG_PHOTO", "TAG_FILE", "TAG_SCHEDULE", "TAG_ALL_PACKAGE", "KEY_IS_PERSONAL_CONTEXT_EVALUATION_SEARCH_CONTROL_SWITCH_ON", "KEY_EVALUATION_PERSONAL_CONTEXT_SEARCH_CONTROL_PARAMS", "GLOBAL_CLEAR_MEMORY_DEBUG_TABLES", "", "USER_CLEAR_MEMORY_DEBUG_TABLES", "DEFAULT_CLEAR_MEMORY_DEBUG_TABLES", "ALLOWED_CLEAR_MEMORY_DEBUG_TABLES", "", "app_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/obric/memorydata/debug/ReleaseAdbService$onStartCommand$notifyIndexRunnable$1$indexRunnable$1", "Ljava/lang/Runnable;", "run", "", "app_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Integer[] f9858a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ List<String> f9859b;
        final /* synthetic */ ReleaseAdbService c;

        b(Integer[] r3, List<String> r4, ReleaseAdbService r5) {
            List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            ReleaseAdbService r7 = (ReleaseAdbService) ZeusTransformUtils.wrapperContextForParams(r5, ReleaseAdbService.class, "com.obric.memorydata.plugin");
            this.f9858a = r3;
            this.f9859b = r6;
            this.c = r7;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f9858a[0].intValue() < this.f9859b.size()) goto L6;
            ReleaseAdbService.a(this.c, "ReleaseAdbService", "indexAllPackage end");
            return;
        L6:
            String r0 = (String) ZeusTransformUtils.preCheckCast(this.f9859b.get(this.f9858a[0].intValue()), String.class, "com.obric.memorydata.plugin");
            Integer[] r2 = this.f9858a;
            r2[0] = Integer.valueOf(r2[0].intValue() + 1);
            ReleaseAdbService.a(this.c, r0, (Runnable) ZeusTransformUtils.preCheckCast(this, Runnable.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class c<T> implements Comparator {
        public c() {
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            return ComparisonsKt.compareValues((Comparable) ZeusTransformUtils.preCheckCast(((File) ZeusTransformUtils.preCheckCast(r2, File.class, "com.obric.memorydata.plugin")).getName(), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(((File) ZeusTransformUtils.preCheckCast(r3, File.class, "com.obric.memorydata.plugin")).getName(), Comparable.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        f9856a = new a(null);
        List<String> r0 = CollectionsKt.listOf(new String[]{"RawObservation", "MemoryProcessSourceEvent", "MemoryProcessTriggerState", "MemoryProcessOperationRecord", "MemoryProcessOutputEvent"});
        d = r0;
        List<String> r1 = CollectionsKt.listOf(new String[]{"ShortMemory", "UnionSemanticMemory", "UserKeyword", "UnionSemanticTypeSummary", "MemoryProcessUserInsight", "UnionUserInsight", "UnionUserPersona", "PendingContext", "PendingSemantic", "ComplexRecommendQuery", "AssistantChatEntity", "AutoMemoryProEvaluationStats", "AutoMemoryProRawSource", "MemoryBaseScene", "MemoryBaseRequirement"});
        e = r1;
        List<String> r2 = CollectionsKt.plus((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin"));
        f = r2;
        g = CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin"));
    }

    public ReleaseAdbService() {
        this.f9857b = new Object();
        this.c = 30000;
    }

    private final long a(SupportSQLiteDatabase r4, String r5) {
        Closeable r3 = (Closeable) ZeusTransformUtils.preCheckCast(((SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin")).query("SELECT COUNT(*) AS count FROM " + b(r5)), Closeable.class, "com.obric.memorydata.plugin");
        Cursor r6 = (Cursor) ZeusTransformUtils.preCheckCast(r3, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r6.moveToFirst() == true) goto L8;
        CloseableKt.closeFinally(r3, null);
        return 0;
    L8:
        long r7 = r6.getLong(r6.getColumnIndexOrThrow(CommonConsts.COUNT_TYPE));     // Catch: Throwable -> L11
        CloseableKt.closeFinally(r3, null);
        return r7;
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        CloseableKt.closeFinally(r3, th);
        throw th;
    }

    private final SupportSQLiteDatabase a(String r3) {
        if (Intrinsics.areEqual(r3, MemoryDbEngine.ENCRYPT_DB_NAME) == false) goto L7;
        SupportSQLiteOpenHelper r2 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getOpenHelper();
    L9:
        return r2.getWritableDatabase();
    L7:
        if (Intrinsics.areEqual(r3, MemoryDbEngine.USER_LOGIC_DB_NAME) == false) goto L11;
        r2 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getOpenHelper();
        goto L9
    L11:
        throw new IllegalArgumentException("Unsupported dbName '" + r3 + "', expected 'memory_data_database_encrypt.db' or 'memory_data_database_personal.db'");
    }

    static /* synthetic */ List a(ReleaseAdbService r1, String r2, String r3, Boolean r4, int r5, Object r6) {
        ReleaseAdbService r7 = (ReleaseAdbService) ZeusTransformUtils.wrapperContextForParams(r1, ReleaseAdbService.class, "com.obric.memorydata.plugin");
        if ((r5 & 4) == 0) goto L6;
        r4 = null;
    L6:
        return r7.a(r2, r3, r4);
    }

    private final List<Map<String, Object>> a(String r3, String r4) {
        SupportSQLiteDatabase r2 = a(r3);
        return com.obric.memorydata.personalcontext.search.bridge.a.f12279a.a(r2, (SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery(r4), SupportSQLiteQuery.class, "com.obric.memorydata.plugin"));
    }

    private final List<InAppSearchResult> a(String r16, String r17, Boolean r18) {
        List<InAppSearchResult> r0 = (List) ZeusTransformUtils.preCheckCast(new CopyOnWriteArrayList(), List.class, "com.obric.memorydata.plugin");
        List r1 = (List) ZeusTransformUtils.preCheckCast(new CopyOnWriteArrayList(), List.class, "com.obric.memorydata.plugin");
        CountDownLatch r11 = new CountDownLatch(1);
        i.a(am.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin")), null, null, (Function2) ZeusTransformUtils.preCheckCast(new ReleaseAdbService$sendAppSearchRequest$1(r18, r17, r16, r11, r1, r0, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        r11.await(this.c, TimeUnit.MILLISECONDS);
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r1, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == true) goto L6;
        return r0;
    L6:
        throw new IllegalStateException("search error: " + r1);
    }

    private final List<Integer> a(String r10, String r11, String r12) {
        if (StringsKt.equals(r12, "force_single", true) == false) goto L7;
        return CollectionsKt.emptyList();
    L7:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L25;
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin"), new String[]{","}, false, 0, 6, null), Iterable.class, "com.obric.memorydata.plugin");
        Collection r13 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r14 = r9.iterator();
    L10:
        if (r14.hasNext() == false) goto L14;
        Integer r15 = StringsKt.toIntOrNull(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r14.next(), String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin")).toString());
        if (r15 == null) goto L10;
        r13.add(r15);
        goto L10
    L14:
        Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r13, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r17 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r18 = r16.iterator();
    L16:
        if (r18.hasNext() == false) goto L24;
        Object r19 = r18.next();
        if (((Number) ZeusTransformUtils.preCheckCast(r19, Number.class, "com.obric.memorydata.plugin")).intValue() < 0) goto L20;
        boolean r110 = true;
    L21:
        if (r110 == false) goto L16;
        r17.add(r19);
        goto L16
    L20:
        r110 = false;
        goto L21
    L24:
        return (List) ZeusTransformUtils.preCheckCast(r17, List.class, "com.obric.memorydata.plugin");
    L25:
        File r111 = new File(e(), r10 + "/manifest.json");
        if (r111.exists() == false) goto L28;
        JSONArray r20 = new JSONObject(FilesKt.readText$default(r111, null, 1, null)).optJSONArray("turns");     // Catch: Exception -> L53
        if (r20 == null) goto L32;
        Iterable r112 = (Iterable) ZeusTransformUtils.preCheckCast(RangesKt.until(0, r20.length()), Iterable.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L53
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L53
        Iterator r113 = r112.iterator();     // Catch: Exception -> L53
    L35:
        if (r113.hasNext() == false) goto L42;
        JSONObject r4 = r20.optJSONObject(((IntIterator) ZeusTransformUtils.preCheckCast(r113, IntIterator.class, "com.obric.memorydata.plugin")).nextInt());     // Catch: Exception -> L53
        if (r4 == null) goto L39;
        Integer r5 = Integer.valueOf(r4.optInt("turn_index", -1));     // Catch: Exception -> L53
    L40:
        if (r5 == null) goto L35;
        r3.add(r5);     // Catch: Exception -> L53
        goto L35
    L39:
        r5 = null;
        goto L40
    L42:
        Iterable r21 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L53
        Collection r114 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L53
        Iterator r22 = r21.iterator();     // Catch: Exception -> L53
    L44:
        if (r22.hasNext() == false) goto L77;
        Object r115 = r22.next();     // Catch: Exception -> L53
        if (((Number) ZeusTransformUtils.preCheckCast(r115, Number.class, "com.obric.memorydata.plugin")).intValue() < 0) goto L48;
        boolean r6 = true;
    L49:
        if (r6 == false) goto L44;
        r114.add(r115);     // Catch: Exception -> L53
        goto L44
    L48:
        r6 = false;
        goto L49
    L77:
        return CollectionsKt.sorted((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r114, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
    L32:
        return CollectionsKt.emptyList();
    L53:
        e = move-exception;
        RunLog.INSTANCE.error("ReleaseAdbService", "resolveTurnIndices parse manifest error trace_id=" + r10, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return CollectionsKt.emptyList();
    L28:
        return CollectionsKt.emptyList();
    }

    private final List<String> a(String r7, List<String> r8) {
        List<String> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        String r6 = Settings.Global.getString(getContentResolver(), r7);
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin");
        int r2 = 0;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L19;
        return r9;
    L19:
        JSONArray r3 = new JSONArray(r6);     // Catch: Throwable -> L16
        List<String> r4 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        int r5 = r3.length();     // Catch: Throwable -> L16
    L12:
        if (r2 >= r5) goto L22;
        String r10 = r3.getString(r2);     // Catch: Throwable -> L16
        Intrinsics.checkNotNullExpressionValue(r10, "getString(...)");     // Catch: Throwable -> L16
        r4.add(r10);     // Catch: Throwable -> L16
        r2 = r2 + 1;
        goto L12
    L22:
        return r4;
    L16:
        th = move-exception;
        RunLog.INSTANCE.error("ReleaseAdbService", "Parse settings array error, key=" + r7 + ", value=" + r6, th);
        return r9;
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    private final List<String> a(JSONArray r7, String r8) {
        if (r7 == null) goto L20;
        if (r7.length() == 0) goto L20;
        List r6 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        int r9 = r7.length();
        int r2 = 0;
    L7:
        if (r2 >= r9) goto L18;
        String r3 = r7.optString(r2);
        Intrinsics.checkNotNullExpressionValue(r3, "optString(...)");
        String r4 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L11;
        boolean r5 = true;
    L12:
        if (r5 == false) goto L16;
        if (Pattern.matches("[A-Za-z0-9_]+", (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L16;
        r6.add(r4);
    L16:
        r2 = r2 + 1;
        goto L7
    L11:
        r5 = false;
        goto L12
    L18:
        return CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin"));
    L20:
        if (Intrinsics.areEqual(r8, MemoryDbEngine.ENCRYPT_DB_NAME) == false) goto L23;
        return d;
    L23:
        if (Intrinsics.areEqual(r8, MemoryDbEngine.USER_LOGIC_DB_NAME) == false) goto L26;
        return e;
    L26:
        return CollectionsKt.emptyList();
    }

    private static final Unit a(IProactiveService r2, boolean r3) {
        ((IProactiveService) ZeusTransformUtils.wrapperContextForParams(r2, IProactiveService.class, "com.obric.memorydata.plugin")).updateAiProactiveWakeUpEnabled(r3);
        return Unit.INSTANCE;
    }

    private static final Unit a(ReleaseAdbService r7, String r8) {
        ReleaseAdbService r9 = (ReleaseAdbService) ZeusTransformUtils.wrapperContextForParams(r7, ReleaseAdbService.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "dataTag");
        r9.b("ReleaseAdbService", "self index entity start, tag=" + r8);     // Catch: Exception -> L5
        IEntityCollectorService.b.a((IEntityCollectorService) ZeusTransformUtils.preCheckCast(EntityCollectorService.INSTANCE, IEntityCollectorService.class, "com.obric.memorydata.plugin"), r8, false, 2, null);     // Catch: Exception -> L5
        r9.b("ReleaseAdbService", "self index end, tag=" + r8);     // Catch: Exception -> L5
    L8:
        return Unit.INSTANCE;
    L5:
        e = move-exception;
        RunLog.INSTANCE.error("ReleaseAdbService", "self index entity start, tag=" + r8, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        goto L8
    }

    private static final Unit a(com.obric.memorydata.middleware.api.device.a r2, Function1 r3, ReleaseAdbService r4) {
        Function1 r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        ReleaseAdbService r6 = (ReleaseAdbService) ZeusTransformUtils.wrapperContextForParams(r4, ReleaseAdbService.class, "com.obric.memorydata.plugin");
        if (r2.a(101) == false) goto L5;
    L10:
        r5.invoke(IEntityCollectorService.SMS_TAG);
    L12:
        return Unit.INSTANCE;
    L5:
        if (r2.a(202) == true) goto L10;
        if (r2.a(201) == true) goto L10;
        a(r6, null, 1, null);
        goto L12
    }

    private static final Unit a(com.obric.memorydata.middleware.api.device.a r2, Function1 r3, ReleaseAdbService r4, int r5, String r6, String r7) {
        Function1 r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        ReleaseAdbService r9 = (ReleaseAdbService) ZeusTransformUtils.wrapperContextForParams(r4, ReleaseAdbService.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "dataTag");
        Intrinsics.checkNotNullParameter(r7, ObricMemoryConstants.KEY_PACKAGE_NAME);
        if (r2.a(r5) == false) goto L6;
        r8.invoke(r6);
    L12:
        return Unit.INSTANCE;
    L6:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L8;
        boolean r10 = true;
    L9:
        if (r10 == false) goto L12;
        b(r9, r7, null, 2, null);
        goto L12
    L8:
        r10 = false;
        goto L9
    }

    private static final Unit a(Exception r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        RunLog.INSTANCE.error("ReleaseAdbService", "Write result file error", (Throwable) ZeusTransformUtils.preCheckCast(r3, Throwable.class, "com.obric.memorydata.plugin"));
        return Unit.INSTANCE;
    }

    private final JSONObject a(String r10, String r11, String r12, int r13) {
        if (r11 != null) goto L5;
    L12:
        JSONObject r14 = null;
    L13:
        if (r14 == null) goto L15;
        return r14;
    L15:
        File r15 = e();
        List r3 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        if (r13 < 0) goto L18;
        ((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.memorydata.plugin")).add(new File(r15, r10 + "/turns/" + r13 + "/input_args.json"));
    L18:
        ((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.memorydata.plugin")).add(new File(r15, r10 + "/input_args.json"));
        Iterator r16 = ((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L20:
        if (r16.hasNext() == false) goto L24;
        Object r4 = r16.next();
        if (((File) ZeusTransformUtils.preCheckCast(r4, File.class, "com.obric.memorydata.plugin")).exists() == false) goto L20;
    L25:
        File r17 = (File) ZeusTransformUtils.preCheckCast(r4, File.class, "com.obric.memorydata.plugin");
        if (r17 != null) goto L34;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ReleaseAdbService", "loadHarnessCaseInput input file not found, traceId=" + r10 + " turn=" + r13, null, 4, null);
        return null;
    L34:
        return a(new JSONObject(FilesKt.readText$default(r17, null, 1, null)), r12);
    L31:
        e = move-exception;
        RunLog.INSTANCE.error("ReleaseAdbService", "loadHarnessCaseInput parse file error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return null;
    L24:
        r4 = null;
        goto L25
    L5:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L8;
        r11 = null;
    L8:
        if (r11 == null) goto L12;
        String r18 = Uri.decode(r11);
        Intrinsics.checkNotNullExpressionValue(r18, "decode(...)");
        JSONObject r19 = c(r18);
        if (r19 == null) goto L12;
        r14 = a(r19, r12);
        goto L13
    }

    private final JSONObject a(JSONObject r2, String r3) {
        JSONObject r1 = r2.optJSONObject("payload");
        if (r1 == null) goto L6;
        r2 = r1;
    L6:
        JSONObject r4 = r2.optJSONObject("bundle");
        if (r4 == null) goto L11;
        r2 = r4;
    L11:
        switch(r3.hashCode()) {
            case -2056966786: goto L45;
            case -1250932035: goto L42;
            case -953402080: goto L36;
            case -828479496: goto L33;
            case 640084421: goto L27;
            case 645220047: goto L24;
            case 990512167: goto L20;
            case 1086056923: goto L17;
            case 1914106161: goto L14;
            default: goto L49;
        };
    L14:
        if (r3.equals("memory_process") == false) goto L49;
    L55:
        return new JSONObject(r2.toString());
    L17:
        if (r3.equals("raw_observation_seed") == true) goto L55;
    L20:
        if (r3.equals("mobile_mem_build") == false) goto L49;
        JSONObject r5 = new JSONObject();
        r5.putOpt("productType", r2.opt("productType"));
        r5.putOpt("contextJson", r2.opt("contextJson"));
        return r5;
    L24:
        if (r3.equals("raw_observation_image_upload") == true) goto L55;
    L27:
        if (r3.equals("active_memory_build_large") == false) goto L49;
        JSONObject r6 = new JSONObject();
        r6.putOpt("appName", r2.opt("appName"));
        r6.putOpt(ChatMessage.TYPE_QUERY, r2.opt(ChatMessage.TYPE_QUERY));
        r6.putOpt("screenshotPath", r2.opt("screenshotPath"));
        r6.putOpt(IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, r2.opt(IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT));
        r6.putOpt(ObricMemoryConstants.KEY_PACKAGE_NAME, r2.opt(ObricMemoryConstants.KEY_PACKAGE_NAME));
        r6.putOpt("activityName", r2.opt("activityName"));
        r6.putOpt("chatHistory", r2.opt("chatHistory"));
        r6.putOpt("refMemoryEntities", r2.opt("refMemoryEntities"));
        if (r2.has("subIntent") == false) goto L51;
        r6.put("subIntent", r2.opt("subIntent"));
        return r6;
    L51:
        return r6;
    L33:
        if (r3.equals("speaker_profile_mapping") == true) goto L55;
    L36:
        if (r3.equals("union_memory_build") == false) goto L49;
        JSONObject r7 = new JSONObject();
        r7.putOpt(CozeCloudExt.API_KEY_BUSINESS_TYPE, r2.opt(CozeCloudExt.API_KEY_BUSINESS_TYPE));
        r7.putOpt("build_target", r2.opt("build_target"));
        r7.putOpt("build_targets", r2.opt("build_targets"));
        r7.putOpt("entity_content", r2.opt("entity_content"));
        r7.putOpt("session_id", r2.opt("session_id"));
        if (r2.has("retry_count") == false) goto L53;
        r7.put("retry_count", r2.optInt("retry_count"));
        return r7;
    L53:
        return r7;
    L42:
        if (r3.equals("memory_scene_build") == true) goto L55;
    L45:
        if (r3.equals("memory_base_build") == true) goto L55;
    L49:
        return new JSONObject();
    }

    private final void a() {
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(q.f12255a.n(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r7.hasNext() == false) goto L11;
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(i.a(null, (Function2) ZeusTransformUtils.preCheckCast(new ReleaseAdbService$startDownloadModel$1$packageModel$1((String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.memorydata.plugin"), null), Function2.class, "com.obric.memorydata.plugin"), 1, null), List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L7:
        if (r0.hasNext() == false) goto L4;
        com.obric.memorydata.aikernelcore.utils.a.C0428a r4 = (com.obric.memorydata.aikernelcore.utils.a.C0428a) ZeusTransformUtils.preCheckCast(r0.next(), com.obric.memorydata.aikernelcore.utils.a.C0428a.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r4.b(), "NotReady") == false) goto L7;
        i.a(null, (Function2) ZeusTransformUtils.preCheckCast(new ReleaseAdbService$startDownloadModel$1$1$1(r4, null), Function2.class, "com.obric.memorydata.plugin"), 1, null);
        goto L7
    }

    private final void a(Context r3, String r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        File r6 = com.obric.memorydata.debug.a.f9862a.a(r5, com.obric.memorydata.debug.a.f9862a.a(r5));
        if (r6 != null) goto L5;
        return;
    L5:
        JsonObject r0 = new JsonObject();
        r0.addProperty("taskId", r4);
        r0.addProperty("zipPath", r6.getAbsolutePath());
        Settings.Global.putString(getContentResolver(), "root_devices_export_db", r0.toString());
    }

    private final void a(Intent r42) {
        if (c() == true) goto L6;
        a(this, false, "checkDebugSignature failed", null, 4, null);
        return;
    L6:
        if (r42 == null) goto L8;
        String r0 = r42.getStringExtra(EventBody.KEY_VALUE);
    L9:
        String r3 = "";
        if (r0 != null) goto L13;
        r0 = "";
    L13:
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L120;
        a(this, false, "value json is empty", null, 4, null);
        return;
    L120:
        JSONObject r4 = new JSONObject(Uri.decode(r0));     // Catch: Exception -> L110
        File r1 = new File(r4.optString("image_dir"));
        CharSequence r6 = (CharSequence) ZeusTransformUtils.preCheckCast(r4.optString("run_id"), CharSequence.class, "com.obric.memorydata.plugin");
        if (StringsKt.isBlank(r6) == false) goto L21;
        r6 = String.valueOf(System.currentTimeMillis());
    L21:
        String r7 = (String) ZeusTransformUtils.preCheckCast(r6, String.class, "com.obric.memorydata.plugin");
        int r8 = RangesKt.coerceAtLeast(r4.optInt("limit", 50), 1);
        boolean r9 = r4.optBoolean("reset_existing", true);
        CharSequence r10 = (CharSequence) ZeusTransformUtils.preCheckCast(r4.optString("device_id"), CharSequence.class, "com.obric.memorydata.plugin");
        if (StringsKt.isBlank(r10) == false) goto L24;
        r10 = "device_harness";
    L24:
        String r11 = (String) ZeusTransformUtils.preCheckCast(r10, String.class, "com.obric.memorydata.plugin");
        String r15 = Api.KEY_APP_NAME;
        CharSequence r12 = (CharSequence) ZeusTransformUtils.preCheckCast(r4.optString(Api.KEY_APP_NAME), CharSequence.class, "com.obric.memorydata.plugin");
        if (StringsKt.isBlank(r12) == false) goto L27;
        r12 = "AI通讯录";
    L27:
        String r14 = (String) ZeusTransformUtils.preCheckCast(r12, String.class, "com.obric.memorydata.plugin");
        String r13 = "package_name";
        CharSequence r16 = (CharSequence) ZeusTransformUtils.preCheckCast(r4.optString("package_name"), CharSequence.class, "com.obric.memorydata.plugin");
        if (StringsKt.isBlank(r16) == false) goto L30;
        r16 = "com.obric.ai.contacts";
    L30:
        String r17 = (String) ZeusTransformUtils.preCheckCast(r16, String.class, "com.obric.memorydata.plugin");
        String r18 = "source_case";
        String r30 = "toString(...)";
        String r31 = r4.optString("source_case");
        long r19 = r4.optLong("base_timestamp_ms", 0);
        if (r1.isDirectory() == true) goto L34;
        a(this, false, "image_dir is not directory: " + r1.getAbsolutePath(), null, 4, null);
        return;
    L34:
        File[] r5 = r1.listFiles();
        if (r5 == null) goto L67;
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        int r20 = r5.length;
        int r21 = 0;
    L37:
        if (r21 >= r20) goto L64;
        int r22 = r20;
        File r23 = r5[r21];
        if (r23.isFile() == false) goto L59;
        Intrinsics.checkNotNull(r23);
        File[] r24 = r5;
        String r25 = r18;
        String r26 = FilesKt.getExtension(r23).toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(r26, "toLowerCase(...)");
        switch(r26.hashCode()) {
            case 105441: goto L53;
            case 111145: goto L50;
            case 3268712: goto L47;
            case 3645340: goto L44;
            default: goto L56;
        };
    L56:
        boolean r27 = false;
    L57:
        if (r27 == false) goto L60;
        boolean r28 = true;
    L61:
        if (r28 == false) goto L63;
        r2.add(r23);
    L63:
        r21 = r21 + 1;
        r20 = r22;
        r5 = r24;
        r18 = r25;
    L60:
        r28 = false;
        goto L61
    L44:
        if (r26.equals("webp") == false) goto L56;
    L55:
        r27 = true;
        goto L57
    L47:
        if (r26.equals("jpeg") == true) goto L55;
    L50:
        if (r26.equals("png") == true) goto L55;
    L53:
        if (r26.equals("jpg") == true) goto L55;
    L59:
        r24 = r5;
        r25 = r18;
        goto L60
    L64:
        String r29 = r18;
        List r32 = CollectionsKt.sortedWith((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new c(), Comparator.class, "com.obric.memorydata.plugin"));
        if (r32 == null) goto L68;
        List r33 = CollectionsKt.take((Iterable) ZeusTransformUtils.preCheckCast(r32, Iterable.class, "com.obric.memorydata.plugin"), r8);
    L69:
        if (r33 != null) goto L72;
        r33 = CollectionsKt.emptyList();
    L72:
        if (r33.isEmpty() == false) goto L122;
        a(this, false, "no supported image files in: " + r1.getAbsolutePath(), null, 4, null);
        return;
    L122:
        RawObservationDao r34 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getRawObservationDao();     // Catch: Exception -> L103
        if (r9 == false) goto L80;
        int r110 = 0;
        List<RawObservationEntity> r35 = r34.rawQuery((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery("SELECT * FROM RawObservation WHERE meta LIKE ?", new String[]{"%\"harness_run_id\":\"" + r7 + "\"%"}), SupportSQLiteQuery.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L103
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r35, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L81;
        r34.bulkDelete(r35);     // Catch: Exception -> L103
        int r36 = r35.size();     // Catch: Exception -> L103
    L83:
        if (r19 > 0) goto L86;
        r19 = System.currentTimeMillis();     // Catch: Exception -> L103
    L86:
        long r37 = r19;
        Iterable r38 = (Iterable) ZeusTransformUtils.preCheckCast(r33, Iterable.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L103
        Collection r39 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r38, 10)), Collection.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L103
        Iterator r40 = r38.iterator();     // Catch: Exception -> L103
        int r111 = 0;
    L88:
        if (r40.hasNext() == false) goto L93;
        int r310 = r36;
        Object r41 = r40.next();     // Catch: Exception -> L103
        int r311 = r111 + 1;     // Catch: Exception -> L103
        if (r111 >= 0) goto L92;
        CollectionsKt.throwIndexOverflow();     // Catch: Exception -> L103
    L92:
        Iterator r312 = r40;
        File r43 = (File) ZeusTransformUtils.preCheckCast(r41, File.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L103
        File r44 = r1;
        RawObservationDao r313 = r34;
        long r210 = r37 + ((long) r111);     // Catch: Exception -> L103
        Intrinsics.checkNotNull(r11);     // Catch: Exception -> L103
        JSONObject r112 = new JSONObject();     // Catch: Exception -> L103
        r112.put("type", "image");     // Catch: Exception -> L103
        r112.put("screenshot_path", r43.getAbsolutePath());     // Catch: Exception -> L103
        r112.put("image_tos_key", r3);     // Catch: Exception -> L103
        r112.put(r15, r14);     // Catch: Exception -> L103
        r112.put(r13, r17);     // Catch: Exception -> L103
        r112.put("file_name", r43.getName());     // Catch: Exception -> L103
        Unit r45 = Unit.INSTANCE;     // Catch: Exception -> L103
        String r46 = r112.toString();     // Catch: Exception -> L103
        String r47 = r30;
        Intrinsics.checkNotNullExpressionValue(r46, r47);     // Catch: Exception -> L103
        JSONObject r113 = new JSONObject();     // Catch: Exception -> L103
        String r314 = r3;
        r113.put("harness_run_id", r7);     // Catch: Exception -> L103
        long r315 = r37;
        String r48 = r29;
        String r49 = r31;
        r113.put(r48, r49);     // Catch: Exception -> L103
        r31 = r49;
        r113.put("seed_command", "seed_raw_observation_images");     // Catch: Exception -> L103
        r113.put("local_path", r43.getAbsolutePath());     // Catch: Exception -> L103
        Unit r50 = Unit.INSTANCE;     // Catch: Exception -> L103
        String r51 = r113.toString();     // Catch: Exception -> L103
        Intrinsics.checkNotNullExpressionValue(r51, r47);     // Catch: Exception -> L103
        r39.add(new RawObservationEntity(0, r11, "screenshot", r210, r210, r210, r46, r51, RawObservationEntity.STATE_WAIT_MEDIA, null, 0, 0, 3585, null));     // Catch: Exception -> L103
        r1 = r44;
        r29 = r48;
        r17 = r17;
        r3 = r314;
        r36 = r310;
        r111 = r311;
        r40 = r312;
        r37 = r315;
        r13 = r13;
        r14 = r14;
        r15 = r15;
        r30 = r47;
        r34 = r313;
        goto L88
    L93:
        int r316 = r36;
        File r52 = r1;
        List<Long> r53 = r34.insertAll((List) ZeusTransformUtils.preCheckCast(r39, List.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L103
        JSONObject r54 = new JSONObject();     // Catch: Exception -> L103
        r54.put("runId", r7);     // Catch: Exception -> L103
        r54.put("imageDir", r52.getAbsolutePath());     // Catch: Exception -> L103
        r54.put("inserted", r53.size());     // Catch: Exception -> L103
        r54.put("deleted", r316);     // Catch: Exception -> L103
        JSONArray r55 = new JSONArray();     // Catch: Exception -> L103
        Iterator r56 = ((Iterable) ZeusTransformUtils.preCheckCast(r53, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Exception -> L103
    L95:
        if (r56.hasNext() == false) goto L97;
        r55.put(((Number) ZeusTransformUtils.preCheckCast(r56.next(), Number.class, "com.obric.memorydata.plugin")).longValue());     // Catch: Exception -> L103
        goto L95
    L97:
        Unit r57 = Unit.INSTANCE;     // Catch: Exception -> L103
        r54.put("ids", r55);     // Catch: Exception -> L103
        Unit r58 = Unit.INSTANCE;     // Catch: Exception -> L103
        a(true, "success", r54);     // Catch: Exception -> L101
        return;
    L101:
        e = e;
    L105:
        RunLog.INSTANCE.error("ReleaseAdbService", "seedRawObservationImages error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        String r59 = e.getMessage();
        if (r59 != null) goto L108;
        r59 = "seedRawObservationImages exception";
    L108:
        a(this, false, r59, null, 4, null);
        return;
    L81:
        r36 = r110;
        goto L83
    L80:
        r110 = 0;
    L103:
        e = e;
    L68:
        r33 = null;
        goto L69
    L67:
        r29 = "source_case";
    L110:
        e = move-exception;
        a(this, false, "parse value json failed: " + e.getMessage(), null, 4, null);
        return;
    L113:
        e = move-exception;
        a(this, false, "decode value json failed: " + e.getMessage(), null, 4, null);
        return;
    L8:
        r0 = null;
        goto L9
    }

    private static final void a(Intent r17, ReleaseAdbService r18) {
        ReleaseAdbService r1 = (ReleaseAdbService) ZeusTransformUtils.wrapperContextForParams(r18, ReleaseAdbService.class, "com.obric.memorydata.plugin");
        if (r17 == null) goto L5;
        String r2 = r17.getStringExtra(EventBody.KEY_VALUE);
    L6:
        String r8 = r2;
        boolean r3 = true;
        if (r17 == null) goto L9;
        boolean r9 = r17.getBooleanExtra("append", true);
    L10:
        if (r17 == null) goto L13;
        String r0 = r17.getStringExtra("file_name");
        if (r0 == null) goto L13;
    L14:
        String r10 = r0;
        Response r7 = new Response(false, null, null, 7, null);
        CharSequence r4 = (CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L17;
    L20:
        if (r3 == true) goto L26;
        Response r12 = r7;
        List r5 = a(r1, "com.android.gallery3d", r8, null, 4, null);     // Catch: Exception -> L24
        JsonObject r6 = new JsonObject();     // Catch: Exception -> L24
        r6.addProperty(ChatMessage.TYPE_QUERY, r8);     // Catch: Exception -> L24
        r6.add("result", EntityExtKt.getEntityGson().toJsonTree(r5));     // Catch: Exception -> L24
        r12.setData(r6);     // Catch: Exception -> L24
    L28:
        Object r11 = r1.f9857b;
        monitor-enter(r11);
        String r13 = EntityExtKt.getEntityGson().toJson(r12);     // Catch: Throwable -> L33
        Intrinsics.checkNotNullExpressionValue(r13, "toJson(...)");     // Catch: Throwable -> L33
        r1.a(r10, r13, r9);     // Catch: Throwable -> L33
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L33
        monitor-exit(r11);
        return;
    L33:
        th = move-exception;
        throw th;
    L24:
        e = move-exception;
        String r15 = e.getMessage();
    L27:
        r12.setErrorMessage(r15);
        r12.setSuccessful(false);
        goto L28
    L26:
        r12 = r7;
        r15 = "输入的package或query为空";
        goto L27
    L17:
        if (r4.length() == 0) goto L20;
        r3 = false;
    L13:
        r0 = "result.jsonl";
        goto L14
    L9:
        r9 = true;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    private final void a(AiProactiveAdbCommandStatus r4) {
        String r0 = d.a(r4);
        b("ReleaseAdbService", "adb command: {set_ai_proactive_enabled} status=" + r4.getValue());
        Settings.System.putString(getContentResolver(), "set_ai_proactive_enabled", r0);
    }

    private static final void a(ReleaseAdbService r3) {
        ReleaseAdbService r4 = (ReleaseAdbService) ZeusTransformUtils.wrapperContextForParams(r3, ReleaseAdbService.class, "com.obric.memorydata.plugin");
        IndexProgress r0 = com.obric.memorydata.personalcontext.index.a.f12223a.a("com.android.gallery3d", 301);
        r4.b("ReleaseAdbService", "query_album_index_progress_result: " + r0);
        Settings.Global.putString(r4.getContentResolver(), "query_album_index_progress", EntityExtKt.getEntityGson().toJson(r0));
    }

    private static final void a(ReleaseAdbService r10, Intent r11) {
        final ReleaseAdbService r12 = (ReleaseAdbService) ZeusTransformUtils.wrapperContextForParams(r10, ReleaseAdbService.class, "com.obric.memorydata.plugin");
        boolean r3 = false;
        if (r12.c() == true) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ReleaseAdbService", "CMD_RUN_MEMORY_DB_SQL check signature failed", null, 4, null);
        JSONObject r13 = new JSONObject();
        r13.put("isSuccessful", false);
        r13.put("error", "checkDebugSignature failed");
        String r14 = r13.toString();
        Intrinsics.checkNotNullExpressionValue(r14, "toString(...)");
        Settings.Global.putString(r12.getContentResolver(), "run_memory_db_sql", r14);
        return;
    L6:
        JSONObject r1 = null;
        if (r11 == null) goto L9;
        String r15 = r11.getStringExtra(EventBody.KEY_VALUE);
    L10:
        CharSequence r4 = (CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L13;
    L16:
        boolean r5 = true;
    L17:
        if (r5 == true) goto L37;
        String r16 = Uri.decode(r15);     // Catch: IllegalArgumentException -> L29
        Intrinsics.checkNotNullExpressionValue(r16, "decode(...)");     // Catch: IllegalArgumentException -> L29
        r1 = new JSONObject(r16);     // Catch: JSONException -> L32
    L21:
        if (r1 == null) goto L38;
        final String r17 = r1.optString("sql");
        final String r6 = r1.getString("taskId");
        final String r2 = r1.optString("dbName");
        RunLog.INSTANCE.debug("ReleaseAdbService", "run sql " + r17);
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r17, CharSequence.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L25;
    L26:
        r3 = true;
    L27:
        if (r3 == true) goto L39;
        ThreadPoolContainer.Companion.execute(new $$Lambda$ReleaseAdbService$nKiVoAgSUeZgN6z8H5daiuSVZzo(r6, r2, r12, r17));
        return;
    L39:
        return;
    L25:
        if (r0.length() != 0) goto L27;
    L38:
        return;
    L29:
        e = move-exception;
        RunLog.INSTANCE.error("ReleaseAdbService", "run_memory_db_sql decode error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return;
    L37:
        return;
    L13:
        if (r4.length() == 0) goto L16;
        r5 = false;
        goto L17
    L9:
        r15 = null;
        goto L10
    }

    static /* synthetic */ void a(ReleaseAdbService r1, Runnable r2, int r3, Object r4) {
        ReleaseAdbService r5 = (ReleaseAdbService) ZeusTransformUtils.wrapperContextForParams(r1, ReleaseAdbService.class, "com.obric.memorydata.plugin");
        Runnable r6 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.memorydata.plugin");
        if ((r3 & 1) == 0) goto L5;
        r6 = null;
    L5:
        r5.a(r6);
    }

    public static final /* synthetic */ void a(ReleaseAdbService r2, String r3, Runnable r4) {
        ((ReleaseAdbService) ZeusTransformUtils.wrapperContextForParams(r2, ReleaseAdbService.class, "com.obric.memorydata.plugin")).b(r3, (Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.memorydata.plugin"));
    }

    static /* synthetic */ void a(ReleaseAdbService r1, String r2, Runnable r3, int r4, Object r5) {
        ReleaseAdbService r6 = (ReleaseAdbService) ZeusTransformUtils.wrapperContextForParams(r1, ReleaseAdbService.class, "com.obric.memorydata.plugin");
        Runnable r7 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L5;
        r7 = null;
    L5:
        r6.a(r2, r7);
    }

    public static final /* synthetic */ void a(ReleaseAdbService r2, String r3, String r4) {
        ((ReleaseAdbService) ZeusTransformUtils.wrapperContextForParams(r2, ReleaseAdbService.class, "com.obric.memorydata.plugin")).b(r3, r4);
    }

    static /* synthetic */ void a(ReleaseAdbService r7, String r8, String r9, boolean r10, String r11, TaskResult r12, JSONObject r13, int r14, Object r15) {
        ReleaseAdbService r0 = (ReleaseAdbService) ZeusTransformUtils.wrapperContextForParams(r7, ReleaseAdbService.class, "com.obric.memorydata.plugin");
        if ((r14 & 16) == 0) goto L5;
        TaskResult r5 = null;
    L7:
        if ((r14 & 32) == 0) goto L9;
        JSONObject r6 = null;
    L10:
        r0.a(r8, r9, r10, r11, r5, r6);
        return;
    L9:
        r6 = r13;
        goto L10
    L5:
        r5 = r12;
        goto L7
    }

    static /* synthetic */ void a(ReleaseAdbService r1, boolean r2, String r3, JSONObject r4, int r5, Object r6) {
        ReleaseAdbService r7 = (ReleaseAdbService) ZeusTransformUtils.wrapperContextForParams(r1, ReleaseAdbService.class, "com.obric.memorydata.plugin");
        if ((r5 & 4) == 0) goto L5;
        r4 = new JSONObject();
    L5:
        r7.a(r2, r3, r4);
    }

    private final void a(Runnable r6) {
        Runnable r7 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r6, Runnable.class, "com.obric.memorydata.plugin");
        b("ReleaseAdbService", "indexAllContactSmsEntity start");     // Catch: Exception -> L7
        EntityManager.INSTANCE.deleteAll("com.android.contacts");     // Catch: Exception -> L7
        EntityManager.INSTANCE.deleteAll("com.android.mms");     // Catch: Exception -> L7
        EntityManager.INSTANCE.bulkIndexThreadSafely("ReleaseAdbServiceIndexContactSMS", EntityCollectorService.INSTANCE.getAllContactAndSmsData());     // Catch: Exception -> L7
        b("ReleaseAdbService", "indexAllContactSmsEntity end");     // Catch: Exception -> L7
        if (r7 == null) goto L12;
        r7.run();     // Catch: Exception -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        RunLog.INSTANCE.error("ReleaseAdbService", "indexAllContactSmsEntity error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }

    private final void a(final String r3, Runnable r4) {
        final Runnable r5 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.memorydata.plugin");
        ThreadPoolContainer.Companion.execute(new $$Lambda$ReleaseAdbService$HOu2Xv5JusfYs4fwjK2OLIeA0RI(r3, r5, this));
    }

    private static final void a(String r9, Runnable r10, ReleaseAdbService r11) {
        Runnable r12 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r10, Runnable.class, "com.obric.memorydata.plugin");
        final ReleaseAdbService r13 = (ReleaseAdbService) ZeusTransformUtils.wrapperContextForParams(r11, ReleaseAdbService.class, "com.obric.memorydata.plugin");
        final Function1 r0 = new $$Lambda$ReleaseAdbService$NabLqNC_SQgSd8LJL2dIpqxGaMU(r13);
        final com.obric.memorydata.middleware.api.device.a r1 = DeviceInfoState.INSTANCE.getSelfCollectionEntitySupport();
        Function0 r2 = new $$Lambda$ReleaseAdbService$cZmNMmjG_aClrdHhgLTQyeH1NI(r1, r0, r13);
        Function3 r3 = new $$Lambda$ReleaseAdbService$eAP0piWrv7FveskkFdVsxHD1Bg(r1, r0, r13);
        switch(r9.hashCode()) {
            case -1717483643: goto L22;
            case -697920873: goto L18;
            case 3143036: goto L14;
            case 106642994: goto L10;
            case 2133330233: goto L6;
            default: goto L27;
        };
    L27:
        b(r13, r9, null, 2, null);
        return;
    L6:
        if (r9.equals("ContactSms") == false) goto L27;
        r2.invoke();
        return;
    L10:
        if (r9.equals("photo") == false) goto L27;
        r3.invoke(301, IEntityCollectorService.PHOTO_TAG, "com.android.gallery3d");
        return;
    L14:
        if (r9.equals("file") == false) goto L27;
        r0.invoke(IEntityCollectorService.FILE_TAG);
        return;
    L18:
        if (r9.equals("schedule") == false) goto L27;
        r3.invoke(402, IEntityCollectorService.SCHEDULE_TAG, "com.obric.appletapp");
        return;
    L22:
        if (r9.equals("AllPackage") == false) goto L27;
        r2.invoke();
        r0.invoke(IEntityCollectorService.FILE_TAG);
        r3.invoke(301, IEntityCollectorService.PHOTO_TAG, "");
        r3.invoke(402, IEntityCollectorService.SCHEDULE_TAG, "");
        if (r12 == null) goto L33;
        r12.run();
        return;
    }

    private static final void a(String r2, String r3, ReleaseAdbService r4, String r5) {
        ReleaseAdbService r6 = (ReleaseAdbService) ZeusTransformUtils.wrapperContextForParams(r4, ReleaseAdbService.class, "com.obric.memorydata.plugin");
        JSONObject r0 = new JSONObject();
        r0.put("taskId", r2);
        r0.put("dbName", r3);
        Intrinsics.checkNotNull(r3);     // Catch: Exception -> L5
        r0.put("result", u.a(r6.b(r5, r6.a(r3, r5))));     // Catch: Exception -> L5
    L7:
        String r7 = r0.toString();
        Intrinsics.checkNotNullExpressionValue(r7, "toString(...)");
        RunLog.INSTANCE.debug("ReleaseAdbService", "resultJsonString: " + r7);
        Settings.Global.putString(r6.getContentResolver(), "run_memory_db_sql", r7);
        return;
    L5:
        e = move-exception;
        r0.put("error", e.getMessage());
        goto L7
    }

    private final void a(String r4, String r5, boolean r6) {
        File r2 = new File(getFilesDir(), r4);
        if (r2.exists() == true) goto L26;
        r2.createNewFile();
    L26:
        Writer r3 = (Writer) ZeusTransformUtils.preCheckCast(new FileWriter(r2, r6), Writer.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L19
        if (ZeusTransformUtils.instanceOf(r3, BufferedWriter.class) == false) goto L8;
        BufferedWriter r7 = (BufferedWriter) ZeusTransformUtils.preCheckCast(r3, BufferedWriter.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L19
    L9:
        Closeable r8 = (Closeable) ZeusTransformUtils.preCheckCast(r7, Closeable.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L19
        Appendable r9 = ((Appendable) ZeusTransformUtils.preCheckCast((BufferedWriter) ZeusTransformUtils.preCheckCast(r8, BufferedWriter.class, "com.obric.memorydata.plugin"), Appendable.class, "com.obric.memorydata.plugin")).append((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L14
        Intrinsics.checkNotNullExpressionValue(r9, "append(...)");     // Catch: Throwable -> L14
        Intrinsics.checkNotNullExpressionValue(r9.append('\n'), "append(...)");     // Catch: Throwable -> L14
        CloseableKt.closeFinally(r8, null);     // Catch: Exception -> L19
        return;
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        CloseableKt.closeFinally(r8, th);     // Catch: Exception -> L19
        throw th;     // Catch: Exception -> L19
    L8:
        r7 = new BufferedWriter(r3, 8192);     // Catch: Exception -> L19
    L19:
        e = move-exception;
        RunLog.INSTANCE.error("ReleaseAdbService", "writeResultToFile error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }

    private final void a(String r3, String r4, boolean r5, String r6, TaskResult r7, JSONObject r8) {
        JsonObject r0 = new JsonObject();
        r0.addProperty("traceId", r3);
        r0.addProperty("mode", r4);
        r0.addProperty("success", Boolean.valueOf(r5));
        r0.addProperty("message", r6);
        if (r7 == null) goto L5;
        r0.addProperty("code", (Number) ZeusTransformUtils.preCheckCast(Integer.valueOf(r7.getCode()), Number.class, "com.obric.memorydata.plugin"));
        r0.addProperty("taskMessage", r7.getMsg());
        r0.addProperty("output", r7.getOutput().toString());
        r0.addProperty("nextTaskSize", (Number) ZeusTransformUtils.preCheckCast(Integer.valueOf(r7.getNextTaskRequestList().size()), Number.class, "com.obric.memorydata.plugin"));
    L5:
        if (r8 == null) goto L7;
        r0.addProperty("inputParams", r8.toString());
    L7:
        b("ReleaseAdbService", "adb command: {run_harness_case} result: " + r0);
        Settings.Global.putString(getContentResolver(), "run_harness_case", r0.toString());
    }

    private final void a(String r3, String r4, boolean r5, String r6, JSONArray r7) {
        JsonObject r0 = new JsonObject();
        r0.addProperty("traceId", r3);
        r0.addProperty("mode", r4);
        r0.addProperty("composite", true);
        r0.addProperty("success", Boolean.valueOf(r5));
        r0.addProperty("message", r6);
        r0.addProperty("turns", r7.toString());
        b("ReleaseAdbService", "adb command: {run_harness_case} composite result: " + r0);
        Settings.Global.putString(getContentResolver(), "run_harness_case", r0.toString());
    }

    private final void a(boolean r3, String r4, JSONObject r5) {
        JSONObject r0 = new JSONObject();
        r0.put("isSuccessful", r3);
        r0.put("message", r4);
        r0.put("data", r5);
        b("ReleaseAdbService", "adb command: {seed_raw_observation_images} result: " + r0);
        Settings.Global.putString(getContentResolver(), "seed_raw_observation_images", r0.toString());
    }

    private final String b(String r8) {
        return Typography.quote + StringsKt.replace$default(r8, "\"", "\"\"", false, 4, null) + Typography.quote;
    }

    private final List<Map<String, Object>> b(String r38, List<? extends Map<String, ? extends Object>> r39) {
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r39, List.class, "com.obric.memorydata.plugin");
        List<String> r4 = CollectionsKt.listOf(new String[]{"ShortMemory", "UnionSemanticMemory", "RawObservation", "RawContactEntity", "RawCallHistoryEntity", "RawMessageEntity", "RawPhotoEntity", "RawAlbumEntity", "RawNoteEntity", "RawAlarmEntity", "RawFileEntity", "RawRecordingEntity", "RawScheduleEntity", "RawICSProtocolEntity", "RawMetaTagEntity", "RawBrowserBookmarkEntity", "UserKeyword", "MemoryProcessSourceEvent", "MemoryProcessTriggerState", "MemoryProcessOperationRecord", "MemoryProcessOutputEvent", "MemoryProcessUserInsight", "UnionSemanticTypeSummary", "UnionUserInsight", "UnionUserPersona", "PendingContext", "PendingSemantic", "ComplexRecommendQuery", "AssistantChatEntity", "AutoMemoryProEvaluationStats", "AutoMemoryProRawSource", "MemoryBaseScene", "MemoryBaseRequirement"});
        List<String> r5 = CollectionsKt.listOf(new String[]{"fullContent", "contentWithTime", "RawPhotoEntity.location", "RawPhotoEntity.faces", "RawAlbumEntity.cover", "RawAlbumEntity.location", "file"});
        List<String> r6 = a("memory_debug_allowed_tables", r4);
        List<String> r0 = a("memory_debug_column_blacklist", r5);
        String r7 = StringsKt.trimStart((CharSequence) ZeusTransformUtils.preCheckCast(r38, CharSequence.class, "com.obric.memorydata.plugin")).toString().toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(r7, "toUpperCase(...)");
        boolean r8 = false;
        if (StringsKt.startsWith$default(r7, "SELECT", false, 2, null) == false) goto L5;
    L9:
        boolean r11 = true;
        if (StringsKt.startsWith$default(r7, "SELECT", false, 2, null) == false) goto L38;
        Matcher r1 = Pattern.compile("FROM\\s+(?:[a-zA-Z0-9_]+\\.)?[\"`']?([a-zA-Z0-9_]+)[\"`']?", 2).matcher((CharSequence) ZeusTransformUtils.preCheckCast(r38, CharSequence.class, "com.obric.memorydata.plugin"));
        String r12 = "";
        if (r1.find() == false) goto L30;
        String r3 = r1.group(1);
        if (r3 == null) goto L17;
        r12 = r3;
    L17:
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r9, Collection.class) == true) goto L20;
    L22:
        Iterator r10 = r9.iterator();
    L24:
        if (r10.hasNext() == false) goto L21;
        if (StringsKt.equals((String) ZeusTransformUtils.preCheckCast(r10.next(), String.class, "com.obric.memorydata.plugin"), r12, true) == false) goto L24;
        boolean r13 = true;
    L28:
        if (r13 == false) goto L30;
        boolean r14 = true;
    L32:
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("FROM", CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == true) goto L34;
        r14 = true;
    L34:
        if (r14 == true) goto L38;
        throw new Exception("Table '" + r12 + "' not in allowed list");
    L21:
        r13 = false;
        goto L28
    L20:
        if (((Collection) ZeusTransformUtils.preCheckCast(r9, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L22;
    L30:
        r14 = false;
    L38:
        List<Map<String, Object>> r15 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator r16 = r2.iterator();
    L40:
        if (r16.hasNext() == false) goto L66;
        Map r17 = (Map) ZeusTransformUtils.preCheckCast(r16.next(), Map.class, "com.obric.memorydata.plugin");
        Map<String, Object> r18 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Iterator r19 = r17.entrySet().iterator();
    L43:
        if (r19.hasNext() == false) goto L65;
        Map.Entry r110 = (Map.Entry) ZeusTransformUtils.preCheckCast(r19.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r111 = (String) ZeusTransformUtils.preCheckCast(r110.getKey(), String.class, "com.obric.memorydata.plugin");
        Object r112 = r110.getValue();
        Iterator<String> r113 = r0.iterator();
    L46:
        if (r113.hasNext() == false) goto L61;
        String r114 = (String) ZeusTransformUtils.preCheckCast(r113.next(), String.class, "com.obric.memorydata.plugin");
        r0 = r0;
        r16 = r16;
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r114, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(".", CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == true) goto L49;
        boolean r20 = true;
        r8 = false;
        if (StringsKt.equals(r111, r114, true) == true) goto L59;
        r11 = true;
        r0 = r0;
        r16 = r16;
        goto L46
    L59:
        boolean r21 = true;
    L62:
        if (r21 == true) goto L64;
        r18.put(r111, r112);
    L64:
        r11 = r20;
        r0 = r0;
        r16 = r16;
        goto L43
    L49:
        List r22 = StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(r114, CharSequence.class, "com.obric.memorydata.plugin"), new String[]{"."}, false, 0, 6, null);
        String r23 = (String) ZeusTransformUtils.preCheckCast(r22.get(0), String.class, "com.obric.memorydata.plugin");
        if (StringsKt.equals(r111, (String) ZeusTransformUtils.preCheckCast(r22.get(1), String.class, "com.obric.memorydata.plugin"), true) == false) goto L55;
        CharSequence r24 = (CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin");
        String r25 = r23.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(r25, "toUpperCase(...)");
        r8 = false;
        if (StringsKt.contains$default(r24, (CharSequence) ZeusTransformUtils.preCheckCast(r25, CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == true) goto L53;
    L56:
        r11 = true;
        goto L46
    L53:
        r21 = true;
        r20 = true;
        goto L62
    L55:
        r8 = false;
        goto L56
    L61:
        r0 = r0;
        r16 = r16;
        r20 = r11;
        r21 = r8;
        goto L62
    L65:
        r15.add(r18);
        r16 = r16;
        goto L40
    L66:
        return r15;
    L5:
        if (StringsKt.startsWith$default(r7, "PRAGMA", false, 2, null) == true) goto L9;
        throw new Exception("Only SELECT or PRAGMA queries are allowed");
    }

    private static final Unit b(Exception r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        RunLog.INSTANCE.error("ReleaseAdbService", "Delete old result file error", (Throwable) ZeusTransformUtils.preCheckCast(r3, Throwable.class, "com.obric.memorydata.plugin"));
        return Unit.INSTANCE;
    }

    private final void b(Intent r17) {
        if (c() == true) goto L6;
        b(this, false, "checkDebugSignature failed", null, 4, null);
        return;
    L6:
        if (r17 == null) goto L8;
        String r0 = r17.getStringExtra(EventBody.KEY_VALUE);
    L9:
        if (r0 != null) goto L12;
        r0 = "";
    L12:
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L75;
        JSONObject r1 = new JSONObject();
    L17:
        String r4 = r1.optString("dbName");
        Intrinsics.checkNotNull(r4);     // Catch: IllegalArgumentException -> L55
        SupportSQLiteDatabase r5 = a(r4);     // Catch: IllegalArgumentException -> L55
        List<String> r6 = a(r1.optJSONArray("tables"), r4);
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin");
        Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r9 = r7.iterator();
    L21:
        if (r9.hasNext() == false) goto L25;
        Object r10 = r9.next();
        if (g.contains((String) ZeusTransformUtils.preCheckCast(r10, String.class, "com.obric.memorydata.plugin")) == true) goto L21;
        r8.add(r10);
        goto L21
    L25:
        List r11 = (List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.memorydata.plugin");
        boolean r12 = true;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r11, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L29;
        b(this, false, "table not allowed: " + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null), null, 4, null);
        return;
    L29:
        boolean r13 = r1.optBoolean("reset_sequence", true);
        JSONObject r14 = new JSONObject();
        JSONObject r15 = new JSONObject();
        Iterator r16 = ((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L31:
        if (r16.hasNext() == false) goto L47;
        String r18 = (String) ZeusTransformUtils.preCheckCast(r16.next(), String.class, "com.obric.memorydata.plugin");
        long r19 = a(r5, r18);     // Catch: Exception -> L41
        r5.execSQL("DELETE FROM " + b(r18));     // Catch: Exception -> L41
        if (r13 == false) goto L39;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L37
        ReleaseAdbService r3 = (ReleaseAdbService) ZeusTransformUtils.preCheckCast(this, ReleaseAdbService.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L37
        r5.execSQL("DELETE FROM sqlite_sequence WHERE name = ?", new String[]{r18});     // Catch: Throwable -> L37
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        Result.Companion r110 = Result.Companion;     // Catch: Exception -> L41
        Result.m1421constructorimpl(ResultKt.createFailure(th));     // Catch: Exception -> L41
    L39:
        r14.put(r18, r19);     // Catch: Exception -> L41
    L41:
        e = move-exception;
        RunLog.INSTANCE.error("ReleaseAdbService", "clear table " + r18 + " failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        String r20 = e.getMessage();
        if (r20 != null) goto L45;
        r20 = "unknown error";
    L45:
        r15.put(r18, r20);
        goto L31
    L47:
        if (r15.length() == 0) goto L50;
        r12 = false;
    L50:
        if (r12 == false) goto L52;
        String r21 = "success";
    L53:
        JSONObject r22 = new JSONObject();
        r22.put("dbName", r4);
        r22.put("cleared", r14);
        r22.put("errors", r15);
        r22.put("resetSequence", r13);
        Unit r23 = Unit.INSTANCE;
        b(r12, r21, r22);
        return;
    L52:
        r21 = "partial failure";
    L55:
        e = move-exception;
        String r24 = e.getMessage();
        if (r24 != null) goto L59;
        r24 = "invalid dbName";
    L59:
        b(this, false, r24, null, 4, null);
        return;
    L75:
        r1 = new JSONObject(Uri.decode(r0));     // Catch: Exception -> L61
    L61:
        e = move-exception;
        b(this, false, "parse value json failed: " + e.getMessage(), null, 4, null);
        return;
    L64:
        e = move-exception;
        b(this, false, "decode value json failed: " + e.getMessage(), null, 4, null);
        return;
    L8:
        r0 = null;
        goto L9
    }

    private static final void b(Intent r3, ReleaseAdbService r4) {
        ReleaseAdbService r5 = (ReleaseAdbService) ZeusTransformUtils.wrapperContextForParams(r4, ReleaseAdbService.class, "com.obric.memorydata.plugin");
        String r0 = "";
        if (r3 == null) goto L6;
        String r1 = r3.getStringExtra("field");
        if (r1 == null) goto L6;
    L7:
        if (r3 == null) goto L17;
        String r6 = r3.getStringExtra(EventBody.KEY_VALUE);
        if (r6 == null) goto L17;
        r0 = r6;
    L17:
        r5.c(r1, r0);     // Catch: Exception -> L14
        return;
    L14:
        e = move-exception;
        r5.b("ReleaseAdbService", "adb command: {reindex_photo_field} run, error: " + e.getMessage());
        return;
    L6:
        r1 = "";
        goto L7
    }

    private static final void b(ReleaseAdbService r2) {
        ((ReleaseAdbService) ZeusTransformUtils.wrapperContextForParams(r2, ReleaseAdbService.class, "com.obric.memorydata.plugin")).d();
    }

    private static final void b(ReleaseAdbService r9, Intent r10) {
        final ReleaseAdbService r11 = (ReleaseAdbService) ZeusTransformUtils.wrapperContextForParams(r9, ReleaseAdbService.class, "com.obric.memorydata.plugin");
        if (r11.c() == true) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ReleaseAdbService", "CMD_RUN_MEMORY_DB_SQL_BY_FILE check signature failed", null, 4, null);
        y.a($$Lambda$ReleaseAdbService$U0JJgCntbqfRZHhqfTKgKEsJ4uo.INSTANCE, $$Lambda$ReleaseAdbService$2nctLWPtroanVqwlHNeFxEXB7Pg.INSTANCE);
        return;
    L6:
        JSONObject r1 = null;
        if (r10 == null) goto L9;
        String r12 = r10.getStringExtra(EventBody.KEY_VALUE);
    L10:
        CharSequence r3 = (CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin");
        boolean r4 = false;
        if (r3 != null) goto L13;
    L16:
        boolean r5 = true;
    L17:
        if (r5 == true) goto L37;
        String r13 = Uri.decode(r12);     // Catch: IllegalArgumentException -> L29
        Intrinsics.checkNotNullExpressionValue(r13, "decode(...)");     // Catch: IllegalArgumentException -> L29
        r1 = new JSONObject(r13);     // Catch: JSONException -> L32
    L21:
        if (r1 == null) goto L38;
        final String r14 = r1.optString("sql");
        final String r6 = r1.getString("taskId");
        final String r2 = r1.optString("dbName");
        RunLog.INSTANCE.debug("ReleaseAdbService", "run sql by file " + r14);
        y.a($$Lambda$ReleaseAdbService$rkuWq34kgOfD8RLNlg_ORCTbo04.INSTANCE, $$Lambda$ReleaseAdbService$lJnrM0rNOSLLD9xVyNFJqAVvUg.INSTANCE);
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L25;
    L26:
        r4 = true;
    L27:
        if (r4 == true) goto L39;
        ThreadPoolContainer.Companion.execute(new $$Lambda$ReleaseAdbService$u4VT2Cpnl2vjDvw8NUXVdFu_3KM(r6, r2, r11, r14));
        return;
    L39:
        return;
    L25:
        if (r0.length() != 0) goto L27;
    L38:
        return;
    L29:
        e = move-exception;
        RunLog.INSTANCE.error("ReleaseAdbService", "run_memory_db_sql_by_file decode error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return;
    L37:
        return;
    L13:
        if (r3.length() == 0) goto L16;
        r5 = false;
        goto L17
    L9:
        r12 = null;
        goto L10
    }

    private static final void b(ReleaseAdbService r9, String r10, Runnable r11) {
        ReleaseAdbService r12 = (ReleaseAdbService) ZeusTransformUtils.wrapperContextForParams(r9, ReleaseAdbService.class, "com.obric.memorydata.plugin");
        Runnable r13 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r11, Runnable.class, "com.obric.memorydata.plugin");
        r12.b("ReleaseAdbService", "notifyAppIndex start, packageName: " + r10);
        EntityManager.INSTANCE.deleteAll(r10);
        ZeusProviderTransform.call(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver(), h.f12375a.a(r10), EntityContentProvider.d, null, null, "com.obric.memorydata.plugin");     // Catch: Exception -> L5
    L7:
        r12.b("ReleaseAdbService", "notifyAppIndex end, packageName: " + r10);
        if (r13 == null) goto L13;
        r13.run();
        return;
    L13:
        return;
    L5:
        e = move-exception;
        RunLog.INSTANCE.error("ReleaseAdbService", "AdbService notifyAppIndex error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        goto L7
    }

    static /* synthetic */ void b(ReleaseAdbService r1, String r2, Runnable r3, int r4, Object r5) {
        ReleaseAdbService r6 = (ReleaseAdbService) ZeusTransformUtils.wrapperContextForParams(r1, ReleaseAdbService.class, "com.obric.memorydata.plugin");
        Runnable r7 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L5;
        r7 = null;
    L5:
        r6.b(r2, r7);
    }

    static /* synthetic */ void b(ReleaseAdbService r1, boolean r2, String r3, JSONObject r4, int r5, Object r6) {
        ReleaseAdbService r7 = (ReleaseAdbService) ZeusTransformUtils.wrapperContextForParams(r1, ReleaseAdbService.class, "com.obric.memorydata.plugin");
        if ((r5 & 4) == 0) goto L5;
        r4 = new JSONObject();
    L5:
        r7.b(r2, r3, r4);
    }

    private final void b(final String r3, Runnable r4) {
        final Runnable r5 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.memorydata.plugin");
        ThreadPoolContainer.Companion.execute(new $$Lambda$ReleaseAdbService$WPlUfLU68csBBm0jpIa6Dw3i2iM(this, r3, r5));
    }

    private final void b(String r7, String r8) {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), r7, r8, false, 4, null);
    }

    private static final void b(String r2, String r3, ReleaseAdbService r4, String r5) {
        ReleaseAdbService r6 = (ReleaseAdbService) ZeusTransformUtils.wrapperContextForParams(r4, ReleaseAdbService.class, "com.obric.memorydata.plugin");
        JSONObject r0 = new JSONObject();
        r0.put("taskId", r2);
        r0.put("dbName", r3);
        Intrinsics.checkNotNull(r3);     // Catch: Exception -> L5
        r0.put("result", u.a(r6.b(r5, r6.a(r3, r5))));     // Catch: Exception -> L5
    L7:
        final String r7 = r0.toString();
        Intrinsics.checkNotNullExpressionValue(r7, "toString(...)");
        RunLog.INSTANCE.debug("ReleaseAdbService", "resultJsonString: " + r7);
        y.a($$Lambda$ReleaseAdbService$raKSp2aaEpDm7ksHy5FbOlmdBic.INSTANCE, new $$Lambda$ReleaseAdbService$iKEtPhf5n715xpW5DSJvhuNAHHI(r7));
        return;
    L5:
        e = move-exception;
        r0.put("error", e.getMessage());
        goto L7
    }

    private final void b(String r5, String r6, String r7) {
        IStore r4 = IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), r5, 0, 2, null);
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r8 = true;
    L6:
        if (r8 == false) goto L8;
        r4.remove(new String[]{r6});
        return;
    L8:
        r4.save(r6, r7);
        return;
    L5:
        r8 = false;
        goto L6
    }

    private final void b(boolean r3, String r4, JSONObject r5) {
        JSONObject r0 = new JSONObject();
        r0.put("isSuccessful", r3);
        r0.put("message", r4);
        r0.put("data", r5);
        b("ReleaseAdbService", "adb command: {clear_memory_debug_data} result: " + r0);
        Settings.Global.putString(getContentResolver(), "clear_memory_debug_data", r0.toString());
    }

    private final boolean b() {
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(q.f12255a.n(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        boolean r2 = true;
    L4:
        if (r6.hasNext() == false) goto L11;
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(i.a(null, (Function2) ZeusTransformUtils.preCheckCast(new ReleaseAdbService$isAllModelDownloadSuccess$1$packageModel$1((String) ZeusTransformUtils.preCheckCast(r6.next(), String.class, "com.obric.memorydata.plugin"), null), Function2.class, "com.obric.memorydata.plugin"), 1, null), List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L7:
        if (r3.hasNext() == false) goto L4;
        if (Intrinsics.areEqual(((com.obric.memorydata.aikernelcore.utils.a.C0428a) ZeusTransformUtils.preCheckCast(r3.next(), com.obric.memorydata.aikernelcore.utils.a.C0428a.class, "com.obric.memorydata.plugin")).b(), "Ready") == true) goto L7;
        r2 = false;
        goto L7
    L11:
        return r2;
    }

    private static final Unit c(Exception r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        RunLog.INSTANCE.error("ReleaseAdbService", "Write result file error", (Throwable) ZeusTransformUtils.preCheckCast(r3, Throwable.class, "com.obric.memorydata.plugin"));
        return Unit.INSTANCE;
    }

    private final JSONObject c(String r3) {
        return new JSONObject(r3);
    L4:
        e = move-exception;
        RunLog.INSTANCE.error("ReleaseAdbService", "parseHarnessInputJson error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return null;
    }

    private final void c(Intent r9) {
        if (r9 == null) goto L5;
        boolean r1 = r9.getBooleanExtra("searchByClip", true);
    L7:
        if (r9 == null) goto L9;
        boolean r3 = r9.getBooleanExtra("searchCaption", true);
    L11:
        if (r9 == null) goto L13;
        boolean r5 = r9.getBooleanExtra("searchTag", true);
    L15:
        if (r9 == null) goto L17;
        boolean r10 = r9.getBooleanExtra("searchOcr", true);
    L18:
        JsonObject r7 = new JsonObject();
        r7.addProperty("searchByClip", Boolean.valueOf(r1));
        r7.addProperty("searchCaption", Boolean.valueOf(r3));
        r7.addProperty("searchTag", Boolean.valueOf(r5));
        r7.addProperty("searchOcr", Boolean.valueOf(r10));
        IStore r8 = IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null);
        String r6 = r7.toString();
        Intrinsics.checkNotNullExpressionValue(r6, "toString(...)");
        r8.save("personal_context_search_control_params", r6);
        IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).save("is_personal_context_evaluation_search_control_switch_on", true);
        return;
    L17:
        r10 = true;
        goto L18
    L13:
        r5 = true;
        goto L15
    L9:
        r3 = true;
        goto L11
    L5:
        r1 = true;
        goto L7
    }

    private static final void c(Intent r4, ReleaseAdbService r5) {
        ReleaseAdbService r6 = (ReleaseAdbService) ZeusTransformUtils.wrapperContextForParams(r5, ReleaseAdbService.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L5;
        boolean r7 = r4.getBooleanExtra(EventBody.KEY_VALUE, false);
    L6:
        r6.b("ReleaseAdbService", "adb command: {disable_entity_sync} run, isDisableSync: " + r7);
        IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).save("is_disable_sync_entity_data", r7);
        return;
    L5:
        r7 = false;
        goto L6
    }

    private static final void c(ReleaseAdbService r4) {
        ReleaseAdbService r5 = (ReleaseAdbService) ZeusTransformUtils.wrapperContextForParams(r4, ReleaseAdbService.class, "com.obric.memorydata.plugin");
        Integer[] r1 = {0};
        new b(r1, EntityManager.INSTANCE.getSupportDonateEntityApps(), r5).run();
    }

    private static final void c(ReleaseAdbService r2, Intent r3) {
        ((ReleaseAdbService) ZeusTransformUtils.wrapperContextForParams(r2, ReleaseAdbService.class, "com.obric.memorydata.plugin")).a(r3);
    }

    private final void c(String r7, String r8) {
        List<? extends AppEntity> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getPhotoRawDbDao().queryAll(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r1.hasNext() == false) goto L30;
        AppEntity r3 = ((hb) ZeusTransformUtils.preCheckCast(r1.next(), hb.class, "com.obric.memorydata.plugin")).convertToAppEntity();
        if (ZeusTransformUtils.instanceOf(r3, PhotoEntity.class) == false) goto L8;
        PhotoEntity r4 = (PhotoEntity) ZeusTransformUtils.preCheckCast(r3, PhotoEntity.class, "com.obric.memorydata.plugin");
    L9:
        if (r4 == null) goto L4;
        int r5 = r7.hashCode();
        if (r5 == (-699573327)) goto L26;
        if (r5 == 109854) goto L22;
        if (r5 == 552573414) goto L18;
    L27:
        b("ReleaseAdbService", "adb command: {reindex_photo_field} run, warn: 不支持的字段" + r7);
    L29:
        r0.add(r4);
        goto L4
    L18:
        if (r7.equals("caption") == false) goto L27;
        r4.setCaption(r8);
        goto L29
    L22:
        if (r7.equals("ocr") == false) goto L27;
        r4.setOcr(r8);
        goto L29
    L26:
        if (r7.equals("sourceAppName") == false) goto L27;
        r4.setSourceAppName(r8);
        goto L29
    L8:
        r4 = null;
        goto L9
    L30:
        EntityManager.INSTANCE.bulkIndex(r0);
    }

    private final boolean c() {
    L36:
        e = move-exception;
        RunLog.INSTANCE.error("ReleaseAdbService", "checkDebugSignature error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return false;
    L4:
        if (AppContext.INSTANCE.isDebug() == false) goto L6;
    L35:
        return true;
    L6:
        if (AppContext.INSTANCE.isAdminMode() == true) goto L35;
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L36
        PackageInfo r2 = r1.getPackageManager().getPackageInfo(r1.getPackageName(), 134217728);     // Catch: Exception -> L36
        Intrinsics.checkNotNullExpressionValue(r2, "getPackageInfo(...)");     // Catch: Exception -> L36
        SigningInfo r3 = r2.signingInfo;     // Catch: Exception -> L36
        if (r3 != null) goto L12;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ReleaseAdbService", "signingInfo is null", null, 4, null);     // Catch: Exception -> L36
        return false;
    L12:
        Signature[] r4 = r3.getApkContentsSigners();     // Catch: Exception -> L36
        if (r4 != null) goto L15;
    L33:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ReleaseAdbService", "signatures is null or empty", null, 4, null);     // Catch: Exception -> L36
        return false;
    L15:
        if (r4.length != 0) goto L17;
        boolean r5 = true;
    L18:
        if (r5 == true) goto L33;
        Iterator r6 = ArrayIteratorKt.iterator(r4);     // Catch: Exception -> L36
    L22:
        if (r6.hasNext() == false) goto L32;
        byte[] r7 = MessageDigest.getInstance(CryptoConst.ALGORITHM_SHA256).digest(((Signature) ZeusTransformUtils.preCheckCast(r6.next(), Signature.class, "com.obric.memorydata.plugin")).toByteArray());     // Catch: Exception -> L36
        StringBuilder r8 = new StringBuilder();     // Catch: Exception -> L36
        int r9 = r7.length;     // Catch: Exception -> L36
        int r10 = 0;
    L24:
        if (r10 >= r9) goto L30;
        String r11 = Integer.toHexString(r7[r10] & 255);     // Catch: Exception -> L36
        if (r11.length() != 1) goto L28;
        r8.append('0');     // Catch: Exception -> L36
    L28:
        r8.append(r11);     // Catch: Exception -> L36
        r10 = r10 + 1;     // Catch: Exception -> L36
        goto L24
    L30:
        if (Intrinsics.areEqual(r8.toString(), "c8a2e9bccf597c2fb6dc66bee293fc13f2fc47ec77bc6b2b0d52c11f51192ab8") == false) goto L22;
        return true;
    L32:
        return false;
    L17:
        r5 = false;
        goto L18
    }

    private static final Unit d(String r3) {
        FilesKt.writeText$default(new File(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getCacheDir(), "run_memory_db_sql_result.json"), r3, null, 2, null);
        return Unit.INSTANCE;
    }

    private final void d() {
        IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).remove(new String[]{"personal_context_search_control_params"});
        IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).save("is_personal_context_evaluation_search_control_switch_on", false);
    }

    private final void d(Intent r13) {
        boolean r0 = true;
        String r2 = null;
        if (r13 == null) goto L11;
        String r3 = r13.getStringExtra("repo");
        if (r3 == null) goto L11;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L10;
        r3 = null;
    L10:
        if (r3 == null) goto L11;
    L12:
        if (r13 == null) goto L14;
        String r4 = r13.getStringExtra("key");
    L15:
        String r5 = "";
        if (r4 != null) goto L19;
        r4 = "";
    L19:
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L23;
        String r14 = "adb command: {set_harness_kv} run, warn: key is empty";
    L21:
        b("ReleaseAdbService", r14);
        return;
    L23:
        IStore r1 = IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), r3, 0, 2, null);
        if (r13 == null) goto L26;
        Bundle r6 = r13.getExtras();
    L28:
        if (r6 != null) goto L30;
    L32:
        r0 = false;
    L34:
        if (r0 == true) goto L36;
    L39:
        if (r13 == null) goto L41;
        r2 = r13.getStringExtra(EventBody.KEY_VALUE);
    L41:
        if (r2 == null) goto L44;
        r5 = r2;
    L44:
        r1.save(r4, r5);
        StringBuilder r15 = new StringBuilder().append("adb command: {set_harness_kv} run, repo: ").append(r3).append(", key: ").append(r4).append(", value(string): ").append(r5);
    L38:
        r14 = r15.toString();
        goto L21
    L36:
        if (ZeusTransformUtils.instanceOf(r6.get(EventBody.KEY_VALUE), Boolean.class) == false) goto L39;
        boolean r16 = r13.getBooleanExtra(EventBody.KEY_VALUE, false);
        r1.save(r4, r16);
        r15 = new StringBuilder().append("adb command: {set_harness_kv} run, repo: ").append(r3).append(", key: ").append(r4).append(", value(bool): ").append(r16);
        goto L38
    L30:
        if (r6.containsKey(EventBody.KEY_VALUE) != true) goto L32;
    L26:
        r6 = null;
        goto L28
    L14:
        r4 = null;
    L11:
        r3 = UserSettings.REPO_MEMORY_DATA;
        goto L12
    }

    private static final void d(ReleaseAdbService r7) {
        ReleaseAdbService r8 = (ReleaseAdbService) ZeusTransformUtils.wrapperContextForParams(r7, ReleaseAdbService.class, "com.obric.memorydata.plugin");
        r8.b("ReleaseAdbService", "query_index_state start");     // Catch: Exception -> L8
        boolean r6 = false;
        boolean r1 = IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).getBoolean("is_instant_entity_index_switch_on", false);     // Catch: Exception -> L8
        boolean r3 = AppEntityIndexBridgeAPIImpl.INSTANCE.isIndexModelReady();     // Catch: Exception -> L8
        if (DeviceInfoState.INSTANCE.getSelfCollectionEntitySupport().a() == SelfCollectionSupportType.NONE) goto L6;
        r6 = true;
    L6:
        JSONObject r4 = new JSONObject();     // Catch: Exception -> L8
        r4.put("isInstantIndexOn", r1);     // Catch: Exception -> L8
        r4.put("isModelReady", r3);     // Catch: Exception -> L8
        r4.put("isSelfCollection", r6);     // Catch: Exception -> L8
        r8.b("ReleaseAdbService", "query_index_state_result: " + r4);     // Catch: Exception -> L8
        Settings.Global.putString(r8.getContentResolver(), "query_index_state", r4.toString());     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        RunLog.INSTANCE.error("ReleaseAdbService", "CMD_QUERY_POWER_TEST_PREP_STATE error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }

    private static final void d(ReleaseAdbService r2, Intent r3) {
        ((ReleaseAdbService) ZeusTransformUtils.wrapperContextForParams(r2, ReleaseAdbService.class, "com.obric.memorydata.plugin")).b(r3);
    }

    private final File e() {
        return new File(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getExternalFilesDir(null), "harness_traces");
    }

    private final void e(Intent r8) {
        if (r8 == null) goto L11;
        String r3 = r8.getStringExtra("repo");
        if (r3 == null) goto L11;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L10;
        r3 = null;
    L10:
        if (r3 == null) goto L11;
    L12:
        if (r8 == null) goto L14;
        String r9 = r8.getStringExtra("key");
    L15:
        if (r9 != null) goto L18;
        r9 = "";
    L18:
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L22;
        String r10 = "adb command: {clear_harness_kv} run, warn: key is empty";
    L20:
        b("ReleaseAdbService", r10);
        return;
    L22:
        IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), r3, 0, 2, null).remove(new String[]{r9});
        r10 = "adb command: {clear_harness_kv} run, repo: " + r3 + ", key: " + r9;
        goto L20
    L14:
        r9 = null;
    L11:
        r3 = UserSettings.REPO_MEMORY_DATA;
        goto L12
    }

    private static final void e(ReleaseAdbService r5) {
        ReleaseAdbService r6 = (ReleaseAdbService) ZeusTransformUtils.wrapperContextForParams(r5, ReleaseAdbService.class, "com.obric.memorydata.plugin");
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(com.obric.memorydata.database.manager.c.f9561a.a(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r2 = 0;
    L4:
        if (r0.hasNext() == false) goto L6;
        r2 = r2 + com.obric.memorydata.database.manager.c.f9561a.a((String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.memorydata.plugin")).queryUnhandledEntity().size();
        goto L4
    L6:
        r6.b("ReleaseAdbService", "query_index_count_result: " + r2);
        Settings.Global.putString(r6.getContentResolver(), "query_index_count", String.valueOf(r2));
    }

    private static final void e(ReleaseAdbService r2, Intent r3) {
        ((ReleaseAdbService) ZeusTransformUtils.wrapperContextForParams(r2, ReleaseAdbService.class, "com.obric.memorydata.plugin")).c(r3);
    }

    private static final void e(String r1) {
        WebSocketManager.f8445a.a(r1);
    }

    private static final Unit f() {
        File r1 = new File(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getCacheDir(), "run_memory_db_sql_result.json");
        if (r1.exists() == false) goto L5;
        r1.delete();
    L5:
        JSONObject r0 = new JSONObject();
        r0.put("isSuccessful", false);
        r0.put("error", "checkDebugSignature failed");
        String r2 = r0.toString();
        Intrinsics.checkNotNullExpressionValue(r2, "toString(...)");
        FilesKt.writeText$default(r1, r2, null, 2, null);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Not initialized variable reg: 16, insn: 0x05c0: MOVE (r11 I:??[OBJECT, ARRAY]) = (r16 I:??[OBJECT, ARRAY]), block:B:190:0x05be */
    /* JADX WARN: Not initialized variable reg: 26, insn: 0x05c6: MOVE (r2 I:??[OBJECT, ARRAY]) = (r26 I:??[OBJECT, ARRAY]), block:B:190:0x05be */
    /* JADX WARN: Not initialized variable reg: 32, insn: 0x05c8: MOVE (r3 I:??[OBJECT, ARRAY]) = (r32 I:??[OBJECT, ARRAY]), block:B:190:0x05be */
    /* JADX WARN: Not initialized variable reg: 33, insn: 0x05ca: MOVE (r4 I:??[OBJECT, ARRAY]) = (r33 I:??[OBJECT, ARRAY]), block:B:190:0x05be */
    /* JADX WARN: Not initialized variable reg: 34, insn: 0x05cc: MOVE (r6 I:??[OBJECT, ARRAY]) = (r34 I:??[OBJECT, ARRAY]), block:B:190:0x05be */
    /* JADX WARN: Not initialized variable reg: 35, insn: 0x05ce: MOVE (r14 I:??[OBJECT, ARRAY]) = (r35 I:??[OBJECT, ARRAY]), block:B:190:0x05be */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 8 */
    private final void f(Intent r42) {
        if (r42 == null) goto L5;
        String r2 = r42.getStringExtra("package_name");
    L7:
        if (r2 != null) goto L9;
        r2 = "";
    L9:
        if (r42 == null) goto L11;
        String r4 = r42.getStringExtra("trace_id");
    L12:
        if (r4 != null) goto L14;
        String r12 = "";
    L15:
        String r13 = "com.obric.memorydata.plugin";
        if (r42 == null) goto L23;
        String r5 = r42.getStringExtra("mode");
        if (r5 == null) goto L23;
        CharSequence r6 = (CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin");
        if (StringsKt.isBlank(r6) == false) goto L22;
        r6 = "replay";
    L22:
        String r14 = (String) ZeusTransformUtils.preCheckCast(r6, String.class, "com.obric.memorydata.plugin");
    L25:
        if (r42 == null) goto L33;
        String r7 = r42.getStringExtra("repo");
        if (r7 == null) goto L33;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L32;
        r7 = null;
    L32:
        if (r7 == null) goto L33;
    L34:
        String r15 = r7;
        if (r42 == null) goto L43;
        String r8 = r42.getStringExtra("key_prefix");
        if (r8 == null) goto L43;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L42;
        r8 = null;
    L42:
        if (r8 == null) goto L43;
    L44:
        if (r42 == null) goto L46;
        String r9 = r42.getStringExtra("input_json");
    L47:
        if (r42 == null) goto L49;
        String r10 = r42.getStringExtra("turn_indices");
    L50:
        if (r10 != null) goto L52;
        r10 = "";
    L52:
        if (r42 == null) goto L54;
        String r0 = r42.getStringExtra("composite_mode");
    L55:
        if (r0 != null) goto L57;
        r0 = "";
    L57:
        CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin");
        if (StringsKt.isBlank(r1) == false) goto L60;
        r1 = "auto";
    L60:
        String r3 = (String) ZeusTransformUtils.preCheckCast(r1, String.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r2, "active_memory_build_large") == true) goto L81;
        if (Intrinsics.areEqual(r2, "mobile_mem_build") == true) goto L81;
        if (Intrinsics.areEqual(r2, "union_memory_build") == true) goto L81;
        if (Intrinsics.areEqual(r2, "memory_process") == true) goto L81;
        if (Intrinsics.areEqual(r2, "raw_observation_seed") == true) goto L81;
        if (Intrinsics.areEqual(r2, "raw_observation_image_upload") == true) goto L81;
        if (Intrinsics.areEqual(r2, "speaker_profile_mapping") == true) goto L81;
        if (Intrinsics.areEqual(r2, "memory_base_build") == true) goto L81;
        if (Intrinsics.areEqual(r2, "memory_scene_build") == true) goto L81;
        a(this, r12, r14, false, "unsupported package_name: " + r2, null, null, 48, null);
        return;
    L81:
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L84;
        a(this, "", r14, false, "trace_id is empty", null, null, 48, null);
        return;
    L84:
        IStore r11 = IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), r15, 0, 2, null);
        r13 = r8 + "_trace_id";
        String r16 = r8 + "_record_enabled";
        String r17 = r8 + "_replay_enabled";
        String r20 = r2;
        String r18 = r8 + "_composite";
        String r19 = r8 + "_turn_index";
        String r21 = r11.getString(r13, "");
        String r22 = r11.getString(r16, "");
        String r23 = r11.getString(r17, "");
        String r24 = r11.getString(r18, "");
        String r25 = r11.getString(r19, "");
        boolean r26 = StringsKt.equals(r14, "replay", true);     // Catch: Throwable -> L195 Exception -> L197
        List<Integer> r27 = a(r12, r10, r3);     // Catch: Throwable -> L195 Exception -> L197
        if (r27.size() <= 1) goto L250;
    L99:
        boolean r28 = true;
    L100:
        r11.save(r13, r12);     // Catch: Throwable -> L195 Exception -> L197
        if (r26 == true) goto L103;
        boolean r29 = true;
    L104:
        r11.save(r16, String.valueOf(r29));     // Catch: Throwable -> L195 Exception -> L197
        r11.save(r17, String.valueOf(r26));     // Catch: Throwable -> L195 Exception -> L197
        r11.save(r18, String.valueOf(r28));     // Catch: Throwable -> L195 Exception -> L197
    L243:
        if (r28 == false) goto L252;
        String r32 = r18;
        String r34 = r25;
        String r30 = r17;
        String r31 = "ReleaseAdbService";
        String r33 = r20;
        String r210 = r22;
        String r35 = r23;
        String r36 = r24;
        r19 = r19;
        String r211 = r15;
        String r110 = r16;
        r13 = "com.obric.memorydata.plugin";
        r13 = r13;
        r21 = r21;
        b(r31, "adb command: {run_harness_case} composite run, package: " + r33 + ", traceId: " + r12 + ", mode: " + r14 + ", turns=" + r27);     // Catch: Throwable -> L189 Exception -> L191
        JSONArray r37 = new JSONArray();     // Catch: Throwable -> L189 Exception -> L191
        Iterator<Integer> r38 = r27.iterator();     // Catch: Throwable -> L189 Exception -> L191
    L155:
        if (r38.hasNext() == false) goto L174;
        int r39 = ((Number) ZeusTransformUtils.preCheckCast(r38.next(), Number.class, r13)).intValue();     // Catch: Exception -> L171 Throwable -> L189
        r11.save(r19, String.valueOf(r39));     // Catch: Exception -> L171 Throwable -> L189
        JSONObject r40 = a(r12, null, r33, r39);     // Catch: Exception -> L171 Throwable -> L189
        Iterator<Integer> r212 = r38;
        IStore r213 = r11;
        if (r40 == null) goto L160;
        String r214 = r31;
        boolean r215 = false;
        TaskResult r41 = ((TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(new TaskRequest.Builder(r33).setInputParam(r40), TaskRequest.Builder.class, r13)).build(), TaskRequest.class, r13)).execute();     // Catch: Exception -> L181 Throwable -> L189
        String r216 = r33;
        if (r41.getCode() != 0) goto L166;
        boolean r43 = true;
    L167:
        JSONObject r44 = new JSONObject();     // Catch: Exception -> L181 Throwable -> L189
        r44.put("turn_index", r39);     // Catch: Exception -> L181 Throwable -> L189
        r44.put("success", r43);     // Catch: Exception -> L181 Throwable -> L189
        r44.put("code", r41.getCode());     // Catch: Exception -> L181 Throwable -> L189
        r44.put("message", r41.getMsg());     // Catch: Exception -> L181 Throwable -> L189
        r37.put(r44);     // Catch: Exception -> L181 Throwable -> L189
        if (r43 == false) goto L169;
        r38 = r212;
        r11 = r213;
        r31 = r214;
        r33 = r216;
        goto L155
    L169:
        String r45 = "turn=" + r39 + " failed: " + r41.getMsg();     // Catch: Exception -> L181 Throwable -> L189
    L175:
        if (r45 != null) goto L177;
        boolean r46 = true;
    L178:
        if (r45 != null) goto L183;
        String r47 = "composite replay completed: " + r27.size() + " turns";     // Catch: Exception -> L181 Throwable -> L189
    L237:
        a(r12, r14, r46, r47, r37);     // Catch: Exception -> L187 Throwable -> L189
    L186:
        String r48 = r211;
        b(r48, r13, r21);
        b(r48, r110, r210);
        b(r48, r30, r35);
        b(r48, r32, r36);
        b(r48, r19, r34);
        return;
    L187:
        e = e;
    L193:
        r30 = r30;
        String r49 = r110;
        String r50 = r211;
        r22 = r210;
        r18 = r32;
        String r51 = r36;
        r23 = r35;
    L194:
        r25 = r34;
    L225:
        String r217 = r51;
        String r218 = r18;
        RunLog.INSTANCE.error(r214, "runHarnessCase error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, r13));     // Catch: Throwable -> L212
        String r52 = e.getMessage();     // Catch: Throwable -> L212
        if (r52 != null) goto L206;
        r52 = "runHarnessCase exception";
    L206:
        String r53 = r25;
        String r54 = r12;
        String r55 = r14;
        String r111 = r23;
        r17 = r30;
        String r310 = r22;
        String r311 = r49;
        String r312 = r19;
        String r112 = r50;
        String r113 = r21;
        a(this, r54, r55, false, r52, null, null, 48, null);     // Catch: Throwable -> L210
        b(r112, r13, r113);
        b(r112, r311, r310);
        b(r112, r17, r111);
        b(r112, r218, r217);
        b(r112, r312, r53);
        return;
    L210:
        th = th;
        r18 = r218;
        r19 = r312;
        String r56 = r217;
        String r57 = r53;
        String r58 = r310;
        r16 = r311;
    L219:
        b(r112, r13, r113);
        b(r112, r16, r58);
        b(r112, r17, r111);
        b(r112, r18, r56);
        b(r112, r19, r57);
        throw th;
    L212:
        th = th;
        r111 = r23;
        r17 = r30;
        r58 = r22;
        r16 = r49;
        r113 = r21;
        r19 = r19;
        r56 = r217;
        r18 = r218;
        r57 = r25;
        r112 = r50;
    L217:
        th = th;
        r111 = r23;
        r17 = r30;
        r16 = r49;
        r113 = r21;
        r19 = r19;
        r56 = r51;
        r58 = r22;
        r112 = r50;
        r57 = r25;
        goto L219
    L183:
        r47 = r45;
        goto L237
    L177:
        r46 = r215;
        goto L178
    L166:
        r43 = false;
    L181:
        e = e;
    L173:
        r30 = r30;
        r49 = r110;
        r50 = r211;
        r22 = r210;
        r18 = r32;
        r51 = r36;
        r25 = r34;
        r23 = r35;
        goto L225
    L160:
        r45 = "failed to load input for turn=" + r39 + " trace_id=" + r12;     // Catch: Exception -> L171 Throwable -> L189
        JSONObject r59 = new JSONObject();     // Catch: Exception -> L171 Throwable -> L189
        r59.put("turn_index", r39);     // Catch: Exception -> L171 Throwable -> L189
        r59.put("success", false);     // Catch: Exception -> L171 Throwable -> L189
        r59.put("message", r45);     // Catch: Exception -> L171 Throwable -> L189
        r37.put(r59);     // Catch: Exception -> L171 Throwable -> L189
        r215 = false;
        r214 = r31;
    L171:
        e = e;
        r214 = r31;
        goto L173
    L174:
        r214 = r31;
        r215 = false;
        r45 = null;
    L191:
        e = e;
        r214 = r31;
        goto L193
    L252:
        JSONObject r60 = a(r12, r9, r20, -1);     // Catch: Throwable -> L149 Exception -> L151
        if (r60 == null) goto L246;
        r32 = r18;
        r34 = r25;
        r30 = r17;
        r22 = r22;
        r36 = r24;
        r19 = r19;
        r13 = r13;
        String r61 = r15;
        r21 = r21;
        r11.remove(new String[]{r19});     // Catch: Throwable -> L144 Exception -> L146
        b("ReleaseAdbService", "adb command: {run_harness_case} run, package: " + r20 + ", traceId: " + r12 + ", mode: " + r14 + " (single)");     // Catch: Exception -> L141 Throwable -> L144
        TaskResult r114 = ((TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(new TaskRequest.Builder(r20).setInputParam(r60), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin")).execute();     // Catch: Exception -> L139 Throwable -> L144
        if (r114.getCode() != 0) goto L132;
        boolean r62 = true;
    L133:
        r35 = r23;
        r110 = r16;
        r210 = r22;
        r13 = "com.obric.memorydata.plugin";
        r211 = r61;
        r21 = r21;
        a(r12, r14, r62, r114.getMsg(), r114, r60);     // Catch: Exception -> L137 Throwable -> L189
    L137:
        e = e;
        r214 = "ReleaseAdbService";
        goto L173
    L132:
        r62 = false;
    L139:
        e = e;
        r13 = "com.obric.memorydata.plugin";
    L143:
        r214 = "ReleaseAdbService";
    L148:
        r49 = r16;
        r50 = r61;
        r23 = r23;
        r18 = r32;
        r51 = r36;
    L141:
        e = e;
        r13 = "com.obric.memorydata.plugin";
    L144:
        th = th;
        r58 = r22;
        r113 = r21;
        r16 = r16;
        r19 = r19;
        r17 = r30;
        r112 = r61;
        r111 = r23;
        r18 = r32;
        r56 = r36;
        r57 = r34;
    L146:
        e = e;
        r16 = r16;
        r13 = "com.obric.memorydata.plugin";
        r61 = r61;
        r214 = "ReleaseAdbService";
        goto L148
    L246:
        r25 = r25;
        r13 = r13;
        a(this, r12, r14, false, "failed to load case input for trace_id=" + r12, null, null, 48, null);     // Catch: Throwable -> L116 Exception -> L118
        b(r15, r13, r21);
        b(r15, r16, r22);
        b(r15, r17, r23);
        b(r15, r18, r24);
        b(r15, r19, r25);
        return;
    L118:
        e = e;
        r49 = r16;
        r30 = r17;
        r214 = "ReleaseAdbService";
        r50 = r15;
        r13 = "com.obric.memorydata.plugin";
        r21 = r21;
        r22 = r22;
        r23 = r23;
        r51 = r24;
        r18 = r18;
        r19 = r19;
    L116:
        th = th;
        r16 = r16;
        r17 = r17;
        r112 = r15;
        r113 = r21;
        r58 = r22;
        r111 = r23;
        r56 = r24;
        r18 = r18;
        r57 = r25;
        r19 = r19;
        goto L219
    L122:
        e = e;
        r13 = r13;
        r18 = r18;
        r25 = r25;
        r49 = r16;
        r50 = r15;
        r13 = "com.obric.memorydata.plugin";
        r21 = r21;
        r22 = r22;
        r23 = r23;
        r51 = r24;
        r214 = "ReleaseAdbService";
        r19 = r19;
        r30 = r17;
    L120:
        th = th;
        r19 = r19;
        r13 = r13;
        r18 = r18;
        r57 = r25;
        r16 = r16;
        r17 = r17;
        r112 = r15;
        r113 = r21;
        r58 = r22;
        r111 = r23;
        r56 = r24;
        goto L219
    L151:
        e = e;
        r30 = r17;
        r49 = r16;
        r50 = r15;
    L98:
        r51 = r24;
        r214 = "ReleaseAdbService";
    L149:
        th = th;
        r112 = r15;
    L95:
        r113 = r21;
        r111 = r23;
        r56 = r24;
        r57 = r25;
        r18 = r18;
        r58 = r22;
    L189:
        th = th;
        r113 = r13;
        r19 = r17;
        r17 = r16;
        r16 = r15;
        r112 = r20;
        r58 = r26;
        r18 = r32;
        r56 = r33;
        r57 = r34;
        r111 = r35;
        goto L219
    L103:
        r29 = false;
        goto L104
    L250:
    L96:
        e = e;
        r49 = r16;
        r30 = r17;
        r50 = r15;
    L93:
        th = th;
        r112 = r15;
        goto L95
    L88:
        if (r27.size() != 1) goto L92;
        if (((Number) ZeusTransformUtils.preCheckCast(r27.get(0), Number.class, "com.obric.memorydata.plugin")).intValue() < 0) goto L92;
    L92:
        r28 = false;
    L197:
        e = e;
        r49 = r16;
        r13 = "com.obric.memorydata.plugin";
        r30 = r17;
        r50 = r15;
        r23 = r23;
        r18 = r18;
        r19 = r19;
        r13 = r13;
        r21 = r21;
        r22 = r22;
        r51 = r24;
        r214 = "ReleaseAdbService";
        r25 = r25;
    L195:
        th = th;
        r13 = r13;
        r18 = r18;
        r57 = r25;
        r16 = r16;
        r113 = r21;
        r58 = r22;
        r111 = r23;
        r56 = r24;
        r17 = r17;
        r19 = r19;
        r112 = r15;
        goto L219
    L54:
        r0 = null;
        goto L55
    L49:
        r10 = null;
        goto L50
    L46:
        r9 = null;
    L43:
        r8 = "harness_debug";
    L33:
        r7 = UserSettings.REPO_MEMORY_DATA;
    L23:
        r14 = "replay";
        goto L25
    L14:
        r12 = r4;
        goto L15
    L11:
        r4 = null;
        goto L12
    L5:
        r2 = null;
        goto L7
    }

    private static final void f(ReleaseAdbService r3) {
        ReleaseAdbService r4 = (ReleaseAdbService) ZeusTransformUtils.wrapperContextForParams(r3, ReleaseAdbService.class, "com.obric.memorydata.plugin");
        boolean r0 = r4.b();
        r4.b("ReleaseAdbService", "query_all_model_success_result: " + r0);
        Settings.Global.putString(r4.getContentResolver(), "query_all_model_success", String.valueOf(r0));
    }

    private static final void f(ReleaseAdbService r2, Intent r3) {
        ((ReleaseAdbService) ZeusTransformUtils.wrapperContextForParams(r2, ReleaseAdbService.class, "com.obric.memorydata.plugin")).d(r3);
    }

    private static final Unit g() {
        File r1 = new File(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getCacheDir(), "run_memory_db_sql_result.json");
        if (r1.exists() == false) goto L6;
        r1.delete();
    L6:
        return Unit.INSTANCE;
    }

    private static final void g(ReleaseAdbService r3) {
        ReleaseAdbService r4 = (ReleaseAdbService) ZeusTransformUtils.wrapperContextForParams(r3, ReleaseAdbService.class, "com.obric.memorydata.plugin");
        int r0 = g.f12373a.c();
        r4.b("ReleaseAdbService", "query_media_meta_count_result: " + r0);
        Settings.Global.putString(r4.getContentResolver(), "query_media_meta_count", String.valueOf(r0));
    }

    private static final void g(ReleaseAdbService r2, Intent r3) {
        ((ReleaseAdbService) ZeusTransformUtils.wrapperContextForParams(r2, ReleaseAdbService.class, "com.obric.memorydata.plugin")).e(r3);
    }

    private static final void h() {
        g.f12373a.a();
    }

    private static final void h(ReleaseAdbService r2) {
        ((ReleaseAdbService) ZeusTransformUtils.wrapperContextForParams(r2, ReleaseAdbService.class, "com.obric.memorydata.plugin")).a();
    }

    private static final void h(ReleaseAdbService r2, Intent r3) {
        ((ReleaseAdbService) ZeusTransformUtils.wrapperContextForParams(r2, ReleaseAdbService.class, "com.obric.memorydata.plugin")).f(r3);
    }

    private static final void i() {
        g.f12373a.b();
    }

    private static final void i(ReleaseAdbService r6, Intent r7) {
        ReleaseAdbService r8 = (ReleaseAdbService) ZeusTransformUtils.wrapperContextForParams(r6, ReleaseAdbService.class, "com.obric.memorydata.plugin");
        if (r8.c() == true) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ReleaseAdbService", "exportDataJson check signature error", null, 4, null);
        return;
    L6:
        if (r7 == null) goto L8;
        String r9 = r7.getStringExtra(EventBody.KEY_VALUE);
    L9:
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (r9 != null) goto L12;
        r9 = "";
    L12:
        r8.a(r0, r9);
        return;
    L8:
        r9 = null;
        goto L9
    }

    private static final void j() {
        WebSocketManager.f8445a.a();
    }

    private static final void j(ReleaseAdbService r6, Intent r7) {
        ReleaseAdbService r8 = (ReleaseAdbService) ZeusTransformUtils.wrapperContextForParams(r6, ReleaseAdbService.class, "com.obric.memorydata.plugin");
        if (r8.c() == true) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ReleaseAdbService", "importDataJson check signature error", null, 4, null);
        return;
    L6:
        if (r7 == null) goto L8;
        String r9 = r7.getStringExtra(EventBody.KEY_VALUE);
    L9:
        CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin");
        boolean r3 = false;
        if (r1 != null) goto L12;
    L15:
        boolean r2 = true;
    L16:
        if (r2 == false) goto L39;
        return;
    L39:
        String r10 = Uri.decode(r9);     // Catch: IllegalArgumentException -> L34
        Intrinsics.checkNotNullExpressionValue(r10, "decode(...)");     // Catch: IllegalArgumentException -> L34
        JSONObject r4 = new JSONObject(r10);     // Catch: JSONException -> L31
        String r11 = r4.optString("zipPath");
        String r5 = r4.optString("taskId");
        CharSequence r12 = (CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin");
        if (r12 != null) goto L23;
    L24:
        r3 = true;
    L25:
        if (r3 == true) goto L29;
        boolean r13 = com.obric.memorydata.debug.a.f9862a.a(r11);
        JsonObject r14 = new JsonObject();
        r14.addProperty("taskId", r5);
        r14.addProperty("result", Boolean.valueOf(r13));
        Settings.Global.putString(r8.getContentResolver(), "root_devices_import_db", r14.toString());
        if (r13 == false) goto L41;
        GlobalHandlerUtil.Companion.getInstance().postDelay(0, $$Lambda$ReleaseAdbService$p1puFEanE21TvFKvb_xG7fTgq68.INSTANCE);
        return;
    L41:
        return;
    L29:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ReleaseAdbService", "filePath is empty", null, 4, null);
        return;
    L23:
        if (r12.length() != 0) goto L25;
    L31:
        e = move-exception;
        RunLog.INSTANCE.error("ReleaseAdbService", "importDataJson parse error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return;
    L34:
        e = move-exception;
        RunLog.INSTANCE.error("ReleaseAdbService", "importDataJson decode error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return;
    L12:
        if (r1.length() == 0) goto L15;
        r2 = false;
        goto L16
    L8:
        r9 = null;
        goto L9
    }

    private static final void k() {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ReleaseAdbService", "importDatabases success, kill process", false, 4, null);
        Process.killProcess(Process.myPid());
    }

    /* JADX INFO: renamed from: lambda$-j7IIZmckRPvz0QwMvkhDpSXEY0, reason: not valid java name */
    public static /* synthetic */ void m649lambda$j7IIZmckRPvz0QwMvkhDpSXEY0(ReleaseAdbService r0) {
        a(r0);
    }

    public static /* synthetic */ void lambda$0MgziUY8sqHtWIt9emwq_NfClgw(ReleaseAdbService r0) {
        b(r0);
    }

    public static /* synthetic */ void lambda$2l0bc68VpA2M4crlNIZgsw1yGa8(ReleaseAdbService r0, Intent r1) {
        d(r0, r1);
    }

    public static /* synthetic */ Unit lambda$2nctLWPtroanVqwlHNeFxEXB7Pg() {
        return f();
    }

    public static /* synthetic */ Unit lambda$7nON9eI_DSjXumXSskFq6ZH3Xj4(IProactiveService r0, boolean r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ void lambda$9Hw9k19QeVdfuaV88wy5BV_uqJk(ReleaseAdbService r0) {
        h(r0);
    }

    public static /* synthetic */ void lambda$FyNXgFrBY2dzEtlBA3wZaweogcA(ReleaseAdbService r0, Intent r1) {
        c(r0, r1);
    }

    public static /* synthetic */ void lambda$HOu2Xv5JusfYs4fwjK2OLIeA0RI(String r0, Runnable r1, ReleaseAdbService r2) {
        a(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$IN91HeAaMWgUWMJrHwyfgVh6Rfg(Intent r0, ReleaseAdbService r1) {
        b(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$L8N7KTzL5-MUaImHEE9A51pi_Rk, reason: not valid java name */
    public static /* synthetic */ void m650lambda$L8N7KTzL5MUaImHEE9A51pi_Rk(ReleaseAdbService r0, Intent r1) {
        h(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$M-NeuMo-nsoreSEtC96C7TzAqos, reason: not valid java name */
    public static /* synthetic */ void m651lambda$MNeuMonsoreSEtC96C7TzAqos(ReleaseAdbService r0, Intent r1) {
        a(r0, r1);
    }

    public static /* synthetic */ Unit lambda$NabLqNC_SQgSd8LJL2dIpqxGaMU(ReleaseAdbService r0, String r1) {
        return a(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$NfpMOufWCiJxn--NuYQRvlF1Nuo, reason: not valid java name */
    public static /* synthetic */ void m652lambda$NfpMOufWCiJxnNuYQRvlF1Nuo(ReleaseAdbService r0, Intent r1) {
        f(r0, r1);
    }

    public static /* synthetic */ void lambda$PlVrht2xus6WGnhat9BFL8eEfL0() {
        j();
    }

    public static /* synthetic */ void lambda$QUZdUIRTT8ZzRzDAVKCflFNMsjk() {
        i();
    }

    public static /* synthetic */ void lambda$QqDv3nNKh8fdZ6TSM7FFQ7uUBtc(ReleaseAdbService r0, Intent r1) {
        e(r0, r1);
    }

    public static /* synthetic */ Unit lambda$U0JJgCntbqfRZHhqfTKgKEsJ4uo(Exception r0) {
        return a(r0);
    }

    public static /* synthetic */ void lambda$WPlUfLU68csBBm0jpIa6Dw3i2iM(ReleaseAdbService r0, String r1, Runnable r2) {
        b(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$XK8yCA7uWQGWW1eGG8ota82RT8U(ReleaseAdbService r0, Intent r1) {
        j(r0, r1);
    }

    public static /* synthetic */ void lambda$YOW8m7QB0ViMBP7uU5POdKLwOUw(String r0) {
        e(r0);
    }

    public static /* synthetic */ void lambda$_ZQXTpAxiHmNQIq_yiGk5t9CtFw(ReleaseAdbService r0) {
        e(r0);
    }

    /* JADX INFO: renamed from: lambda$b4s-s6SbTBAui9JWwVkHXFCGBxs, reason: not valid java name */
    public static /* synthetic */ void m653lambda$b4ss6SbTBAui9JWwVkHXFCGBxs(ReleaseAdbService r0, Intent r1) {
        b(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$cZmNMmjG_aC-lrdHhgLTQyeH1NI, reason: not valid java name */
    public static /* synthetic */ Unit m654lambda$cZmNMmjG_aClrdHhgLTQyeH1NI(com.obric.memorydata.middleware.api.device.a r0, Function1 r1, ReleaseAdbService r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$cbnzwSkUlalvj8gLHTb7R9j1RCE() {
        h();
    }

    /* JADX INFO: renamed from: lambda$eAP0piWrv7F-veskkFdVsxHD1Bg, reason: not valid java name */
    public static /* synthetic */ Unit m655lambda$eAP0piWrv7FveskkFdVsxHD1Bg(com.obric.memorydata.middleware.api.device.a r0, Function1 r1, ReleaseAdbService r2, int r3, String r4, String r5) {
        return a(r0, r1, r2, r3, r4, r5);
    }

    /* JADX INFO: renamed from: lambda$h8K3vS7uCaGYJSsHiY-3xwMsGNU, reason: not valid java name */
    public static /* synthetic */ void m656lambda$h8K3vS7uCaGYJSsHiY3xwMsGNU(Intent r0, ReleaseAdbService r1) {
        c(r0, r1);
    }

    public static /* synthetic */ Unit lambda$iKEtPhf5n715xpW5DSJvhuNAHHI(String r0) {
        return d(r0);
    }

    public static /* synthetic */ void lambda$ikWcyMXlCMDIFFrKsi7EuP0Tf78(Intent r0, ReleaseAdbService r1) {
        a(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$l-JnrM0rNOSLLD9xVyNFJqAVvUg, reason: not valid java name */
    public static /* synthetic */ Unit m657lambda$lJnrM0rNOSLLD9xVyNFJqAVvUg() {
        return g();
    }

    public static /* synthetic */ void lambda$lUlTj5OEvPzfgIixi6CPAOBusWA(ReleaseAdbService r0) {
        c(r0);
    }

    public static /* synthetic */ void lambda$nKiVoAgSUeZgN6z8H5daiuSVZzo(String r0, String r1, ReleaseAdbService r2, String r3) {
        a(r0, r1, r2, r3);
    }

    public static /* synthetic */ void lambda$p1puFEanE21TvFKvb_xG7fTgq68() {
        k();
    }

    public static /* synthetic */ void lambda$qfGi5h75a_CXeVen4YMX2dS2sSA(ReleaseAdbService r0, Intent r1) {
        i(r0, r1);
    }

    public static /* synthetic */ Unit lambda$raKSp2aaEpDm7ksHy5FbOlmdBic(Exception r0) {
        return c(r0);
    }

    public static /* synthetic */ Unit lambda$rkuWq34kgOfD8RLNlg_ORCTbo04(Exception r0) {
        return b(r0);
    }

    public static /* synthetic */ void lambda$u4VT2Cpnl2vjDvw8NUXVdFu_3KM(String r0, String r1, ReleaseAdbService r2, String r3) {
        b(r0, r1, r2, r3);
    }

    public static /* synthetic */ void lambda$v6XYE6wc8LK0hilLqS8orrfeVJM(ReleaseAdbService r0, Intent r1) {
        g(r0, r1);
    }

    public static /* synthetic */ void lambda$wVJmbvSVyRCLlpC8WBPmU66F15Y(ReleaseAdbService r0) {
        f(r0);
    }

    public static /* synthetic */ void lambda$xSHPxLdTpmvrYcgSm4mgDHRT5r4(ReleaseAdbService r0) {
        d(r0);
    }

    public static /* synthetic */ void lambda$ygmnaLZlpS8j7xMiothwp1Ssk9g(ReleaseAdbService r0) {
        g(r0);
    }

    public IBinder onBind(Intent r1) {
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int onStartCommand(final Intent r10, int r11, int r12) {
        final String r3 = null;
        Function1 r4 = null;
        if (r10 != null) goto L172;
        String r5 = null;
    L7:
        if (Intrinsics.areEqual(r5, "set_ai_proactive_enabled") == false) goto L24;
        Bundle r0 = r10.getExtras();     // Catch: Exception -> L167
        if (r0 == null) goto L11;
        Object r1 = r0.get("enabled");     // Catch: Exception -> L167
    L12:
        String r6 = AppContext.INSTANCE.getChannel();     // Catch: Exception -> L167
        if (d.a(r1, r6) != null) goto L170;
        a(AiProactiveAdbCommandStatus.UNSUPPORTED);     // Catch: Exception -> L167
        return super/*android.app.Service*/.onStartCommand(r10, r11, r12);
    L170:
        final IProactiveService r7 = (IProactiveService) ZeusTransformUtils.preCheckCast(ServiceManagerExtKt.impl(Reflection.getOrCreateKotlinClass(IProactiveService.class)), IProactiveService.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L18
    L19:
        if (r7 == null) goto L21;
        r4 = new $$Lambda$ReleaseAdbService$7nON9eI_DSjXumXSskFq6ZH3Xj4(r7);     // Catch: Exception -> L167
    L21:
        a(d.a(r1, r6, r4));     // Catch: Exception -> L167
        return super/*android.app.Service*/.onStartCommand(r10, r11, r12);
    L18:
        r7 = null;
        goto L19
    L11:
        r1 = null;
        goto L12
    L24:
        if (UserSettings.INSTANCE.hasAgreePrivacy() == true) goto L27;
        b("ReleaseAdbService", "user not agree privacy, return");     // Catch: Exception -> L167
        return super/*android.app.Service*/.onStartCommand(r10, r11, r12);
    L27:
        if (r10 == null) goto L30;
        String r2 = r10.getStringExtra("command");     // Catch: Exception -> L167
        if (r2 == null) goto L30;
    L32:
        boolean r8 = false;
        switch(r2.hashCode()) {
            case -2134175564: goto L162;
            case -1962816272: goto L158;
            case -1907903236: goto L154;
            case -1685435744: goto L150;
            case -1509868845: goto L146;
            case -1296487361: goto L142;
            case -1250819477: goto L138;
            case -1235913235: goto L134;
            case -1184655032: goto L118;
            case -896854825: goto L114;
            case -680631586: goto L110;
            case -589043198: goto L106;
            case -348867934: goto L102;
            case -215075801: goto L98;
            case -173651167: goto L85;
            case 31572723: goto L81;
            case 220292888: goto L77;
            case 266260909: goto L73;
            case 274397011: goto L69;
            case 686672353: goto L65;
            case 907205483: goto L61;
            case 1135987801: goto L57;
            case 1504440045: goto L53;
            case 1766915562: goto L49;
            case 1770757015: goto L45;
            case 1777651916: goto L41;
            case 1859959343: goto L36;
            default: goto L166;
        };
    L36:
        if (r2.equals("start_download_model") == false) goto L166;
        ThreadPoolContainer.Companion r9 = ThreadPoolContainer.Companion;     // Catch: Exception -> L167
        Runnable r13 = new $$Lambda$ReleaseAdbService$9Hw9k19QeVdfuaV88wy5BV_uqJk(this);     // Catch: Exception -> L167
    L39:
        r9.execute(r13);     // Catch: Exception -> L167
        goto L166
    L41:
        if (r2.equals("clear_harness_kv") == false) goto L166;
        r9 = ThreadPoolContainer.Companion;     // Catch: Exception -> L167
        r13 = new $$Lambda$ReleaseAdbService$v6XYE6wc8LK0hilLqS8orrfeVJM(this, r10);     // Catch: Exception -> L167
        goto L39
    L45:
        if (r2.equals("set_harness_kv") == false) goto L166;
        r9 = ThreadPoolContainer.Companion;     // Catch: Exception -> L167
        r13 = new $$Lambda$ReleaseAdbService$NfpMOufWCiJxnNuYQRvlF1Nuo(this, r10);     // Catch: Exception -> L167
        goto L39
    L49:
        if (r2.equals("root_devices_export_db") == false) goto L166;
        r9 = ThreadPoolContainer.Companion;     // Catch: Exception -> L167
        r13 = new $$Lambda$ReleaseAdbService$qfGi5h75a_CXeVen4YMX2dS2sSA(this, r10);     // Catch: Exception -> L167
        goto L39
    L53:
        if (r2.equals("reindex_photo_field") == false) goto L166;
        r9 = ThreadPoolContainer.Companion;     // Catch: Exception -> L167
        r13 = new $$Lambda$ReleaseAdbService$IN91HeAaMWgUWMJrHwyfgVh6Rfg(r10, this);     // Catch: Exception -> L167
        goto L39
    L57:
        if (r2.equals("root_devices_import_db") == false) goto L166;
        r9 = ThreadPoolContainer.Companion;     // Catch: Exception -> L167
        r13 = new $$Lambda$ReleaseAdbService$XK8yCA7uWQGWW1eGG8ota82RT8U(this, r10);     // Catch: Exception -> L167
        goto L39
    L61:
        if (r2.equals("query_album_photo") == false) goto L166;
        r9 = ThreadPoolContainer.Companion;     // Catch: Exception -> L167
        r13 = new $$Lambda$ReleaseAdbService$ikWcyMXlCMDIFFrKsi7EuP0Tf78(r10, this);     // Catch: Exception -> L167
        goto L39
    L65:
        if (r2.equals("query_album_index_progress") == false) goto L166;
        r9 = ThreadPoolContainer.Companion;     // Catch: Exception -> L167
        r13 = new $$Lambda$ReleaseAdbService$j7IIZmckRPvz0QwMvkhDpSXEY0(this);     // Catch: Exception -> L167
        goto L39
    L69:
        if (r2.equals("start_media_meta_force_scan") == false) goto L166;
        r9 = ThreadPoolContainer.Companion;     // Catch: Exception -> L167
        r13 = $$Lambda$ReleaseAdbService$cbnzwSkUlalvj8gLHTb7R9j1RCE.INSTANCE;     // Catch: Exception -> L167
        goto L39
    L73:
        if (r2.equals("clear_search_control_params") == false) goto L166;
        r9 = ThreadPoolContainer.Companion;     // Catch: Exception -> L167
        r13 = new $$Lambda$ReleaseAdbService$0MgziUY8sqHtWIt9emwq_NfClgw(this);     // Catch: Exception -> L167
        goto L39
    L77:
        if (r2.equals("query_all_model_success") == false) goto L166;
        r9 = ThreadPoolContainer.Companion;     // Catch: Exception -> L167
        r13 = new $$Lambda$ReleaseAdbService$wVJmbvSVyRCLlpC8WBPmU66F15Y(this);     // Catch: Exception -> L167
        goto L39
    L81:
        if (r2.equals("stop_media_meta_force_scan") == false) goto L166;
        r9 = ThreadPoolContainer.Companion;     // Catch: Exception -> L167
        r13 = $$Lambda$ReleaseAdbService$QUZdUIRTT8ZzRzDAVKCflFNMsjk.INSTANCE;     // Catch: Exception -> L167
        goto L39
    L85:
        if (r2.equals("connect_aikernel_ws") == false) goto L166;
        if (r10 == null) goto L89;
        r3 = r10.getStringExtra(EventBody.KEY_VALUE);     // Catch: Exception -> L167
    L89:
        b("ReleaseAdbService", "adb command: {connect_aikernel_ws} run, url: " + r3);     // Catch: Exception -> L167
        CharSequence r14 = (CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L167
        if (r14 != null) goto L92;
    L93:
        r8 = true;
    L94:
        if (r8 == true) goto L96;
        ThreadPoolContainer.Companion.execute(new $$Lambda$ReleaseAdbService$YOW8m7QB0ViMBP7uU5POdKLwOUw(r3));     // Catch: Exception -> L167
        goto L166
    L96:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ReleaseAdbService", "adb command: {connect_aikernel_ws} missing url", null, 4, null);     // Catch: Exception -> L167
        goto L166
    L92:
        if (r14.length() != 0) goto L94;
    L98:
        if (r2.equals("query_media_meta_count") == false) goto L166;
        r9 = ThreadPoolContainer.Companion;     // Catch: Exception -> L167
        r13 = new $$Lambda$ReleaseAdbService$ygmnaLZlpS8j7xMiothwp1Ssk9g(this);     // Catch: Exception -> L167
        goto L39
    L102:
        if (r2.equals("clear_memory_debug_data") == false) goto L166;
        r9 = ThreadPoolContainer.Companion;     // Catch: Exception -> L167
        r13 = new $$Lambda$ReleaseAdbService$2l0bc68VpA2M4crlNIZgsw1yGa8(this, r10);     // Catch: Exception -> L167
        goto L39
    L106:
        if (r2.equals("set_search_control_params") == false) goto L166;
        r9 = ThreadPoolContainer.Companion;     // Catch: Exception -> L167
        r13 = new $$Lambda$ReleaseAdbService$QqDv3nNKh8fdZ6TSM7FFQ7uUBtc(this, r10);     // Catch: Exception -> L167
        goto L39
    L110:
        if (r2.equals("trigger_anr") == false) goto L166;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ReleaseAdbService", "trigger anr", null, 4, null);     // Catch: Exception -> L167
        Thread.sleep(25000);     // Catch: Exception -> L167
        goto L166
    L114:
        if (r2.equals("run_memory_db_sql") == false) goto L166;
        r9 = ThreadPoolContainer.Companion;     // Catch: Exception -> L167
        r13 = new $$Lambda$ReleaseAdbService$MNeuMonsoreSEtC96C7TzAqos(this, r10);     // Catch: Exception -> L167
        goto L39
    L118:
        if (r2.equals(EntityContentProvider.d) == false) goto L166;
        Intrinsics.checkNotNull(r10);     // Catch: Exception -> L167
        String r15 = r10.getStringExtra(EventBody.KEY_VALUE);     // Catch: Exception -> L167
        b("ReleaseAdbService", "adb command: {reindex_all_data} run, packageName: " + r15);     // Catch: Exception -> L167
        if (Intrinsics.areEqual(r15, "ContactSms") == false) goto L124;
    L122:
        a(this, r15, null, 2, null);     // Catch: Exception -> L167
        goto L166
    L124:
        if (Intrinsics.areEqual(r15, "AllPackage") == false) goto L126;
        a(r15, new $$Lambda$ReleaseAdbService$lUlTj5OEvPzfgIixi6CPAOBusWA(this));     // Catch: Exception -> L167
        goto L166
    L126:
        CharSequence r16 = (CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L167
        if (r16 != null) goto L129;
    L130:
        r8 = true;
    L131:
        if (r8 == true) goto L166;
    L129:
        if (r16.length() != 0) goto L131;
    L134:
        if (r2.equals("query_index_state") == false) goto L166;
        r9 = ThreadPoolContainer.Companion;     // Catch: Exception -> L167
        r13 = new $$Lambda$ReleaseAdbService$xSHPxLdTpmvrYcgSm4mgDHRT5r4(this);     // Catch: Exception -> L167
        goto L39
    L138:
        if (r2.equals("query_index_count") == false) goto L166;
        r9 = ThreadPoolContainer.Companion;     // Catch: Exception -> L167
        r13 = new $$Lambda$ReleaseAdbService$_ZQXTpAxiHmNQIq_yiGk5t9CtFw(this);     // Catch: Exception -> L167
        goto L39
    L142:
        if (r2.equals("switch_on_instant_index") == false) goto L166;
        Intrinsics.checkNotNull(r10);     // Catch: Exception -> L167
        boolean r17 = r10.getBooleanExtra(EventBody.KEY_VALUE, true);     // Catch: Exception -> L167
        IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).save("is_instant_entity_index_switch_on", r17);     // Catch: Exception -> L167
        PersonalContextAPI.INSTANCE.notifyForceIndexStateChange();     // Catch: Exception -> L167
        b("ReleaseAdbService", "adb command: {switch_on_instant_index} run, on: " + r17);     // Catch: Exception -> L167
        goto L166
    L146:
        if (r2.equals("run_harness_case") == false) goto L166;
        r9 = ThreadPoolContainer.Companion;     // Catch: Exception -> L167
        r13 = new $$Lambda$ReleaseAdbService$L8N7KTzL5MUaImHEE9A51pi_Rk(this, r10);     // Catch: Exception -> L167
        goto L39
    L150:
        if (r2.equals("disable_entity_sync") == false) goto L166;
        r9 = ThreadPoolContainer.Companion;     // Catch: Exception -> L167
        r13 = new $$Lambda$ReleaseAdbService$h8K3vS7uCaGYJSsHiY3xwMsGNU(r10, this);     // Catch: Exception -> L167
        goto L39
    L154:
        if (r2.equals("run_memory_db_sql_by_file") == false) goto L166;
        r9 = ThreadPoolContainer.Companion;     // Catch: Exception -> L167
        r13 = new $$Lambda$ReleaseAdbService$b4ss6SbTBAui9JWwVkHXFCGBxs(this, r10);     // Catch: Exception -> L167
        goto L39
    L158:
        if (r2.equals("seed_raw_observation_images") == false) goto L166;
        r9 = ThreadPoolContainer.Companion;     // Catch: Exception -> L167
        r13 = new $$Lambda$ReleaseAdbService$FyNXgFrBY2dzEtlBA3wZaweogcA(this, r10);     // Catch: Exception -> L167
        goto L39
    L162:
        if (r2.equals("send_aikernel_handshake") == false) goto L166;
        b("ReleaseAdbService", "adb command: {send_aikernel_handshake} run");     // Catch: Exception -> L167
        r9 = ThreadPoolContainer.Companion;     // Catch: Exception -> L167
        r13 = $$Lambda$ReleaseAdbService$PlVrht2xus6WGnhat9BFL8eEfL0.INSTANCE;     // Catch: Exception -> L167
    L166:
        return super/*android.app.Service*/.onStartCommand(r10, r11, r12);
    L30:
        r2 = "";
        goto L32
    L172:
        r5 = r10.getStringExtra("command");     // Catch: Exception -> L167
    L167:
        e = move-exception;
        RunLog.INSTANCE.error("ReleaseAdbService", "ReleaseAdbService error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return super/*android.app.Service*/.onStartCommand(r10, r11, r12);
    }
}
