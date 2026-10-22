package com.obric.memorydata.middleware.api.settings;

import androidx.exifinterface.media.ExifInterface;
import com.google.gson.Gson;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.obric.memorydata.middleware.api.store.b;
import com.obric.memorydata.utils.GsonUtil;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001d\u001a\u00020\u0005J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u001d\u001a\u00020\u0005J \u0010 \u001a\u0004\u0018\u0001H!\"\u0006\b\u0000\u0010!\u0018\u00012\u0006\u0010\u001d\u001a\u00020\u0005H\u0086\b¢\u0006\u0002\u0010\"J&\u0010 \u001a\u0002H!\"\u0006\b\u0000\u0010!\u0018\u00012\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010#\u001a\u0002H!H\u0086\b¢\u0006\u0002\u0010$J\u0016\u0010%\u001a\u00020&2\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u001bJ\u0016\u0010(\u001a\u00020&2\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u001bJ\u0018\u0010)\u001a\u00020&2\u0006\u0010*\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u0005H\u0016J \u0010+\u001a\u0004\u0018\u0001H!\"\u0006\b\u0000\u0010!\u0018\u00012\u0006\u0010,\u001a\u00020\u0005H\u0086\b¢\u0006\u0002\u0010\"R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R \u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001a0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/obric/memorydata/middleware/api/settings/SettingsManager;", "Lcom/obric/memorydata/middleware/api/store/StoreChangeListener;", "<init>", "()V", "TAG", "", GsonUtil.TAG, "Lcom/google/gson/Gson;", "getGSON", "()Lcom/google/gson/Gson;", "GSON$delegate", "Lkotlin/Lazy;", "REPO_SETTINGS", "KEY_PAGE_CONTEXT_SETTINGS", "KEY_ACTION_RECOMMEND_SCENE_RULES", "KEY_SENSORHUB_THRESHOLD_SETTINGS", "KEY_AB_SWITCH_SETTINGS", "KEY_AI_PROACTIVE_DATA_COLLECTION_WHITELIST", "KEY_AI_PROACTIVE_FEEDBACK_SETTINGS", "KEY_MEMORY_FEEDBACK_SETTINGS", "KEY_MAIN_TRACE_REPORT_SETTINGS", "KEY_MEMORY_TASK_BLOCKED_REPORT_SETTINGS", "KEY_BACKGROUND_OS_RESOURCE_OPTIMIZE", "KEY_COMMON_FEATURE_SETTINGS", "listeners", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/obric/memorydata/middleware/api/settings/SettingsChangeListener;", "getSettingsStr", "key", "getJson", "Lorg/json/JSONObject;", "getSettingsObj", ExifInterface.GPS_DIRECTION_TRUE, "(Ljava/lang/String;)Ljava/lang/Object;", "default", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "registerChangeListener", "", "listener", "unregisterChangeListener", "onKeyChanged", "repoName", "fromJson", "json", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SettingsManager implements b {
    private static final Lazy GSON$delegate = null;
    public static final SettingsManager INSTANCE = null;
    public static final String KEY_AB_SWITCH_SETTINGS = "ab_switch_settings";
    public static final String KEY_ACTION_RECOMMEND_SCENE_RULES = "action_recommend_scene_rules";
    public static final String KEY_AI_PROACTIVE_DATA_COLLECTION_WHITELIST = "ai_proactive_data_collection_whitelist";
    public static final String KEY_AI_PROACTIVE_FEEDBACK_SETTINGS = "ai_proactive_feedback_settings";
    public static final String KEY_BACKGROUND_OS_RESOURCE_OPTIMIZE = "enable_background_os_resource_optimize";
    public static final String KEY_COMMON_FEATURE_SETTINGS = "obric_memd_common_feature_settings";
    public static final String KEY_MAIN_TRACE_REPORT_SETTINGS = "main_trace_report_setting";
    public static final String KEY_MEMORY_FEEDBACK_SETTINGS = "obric_memd_memory_feedback_setting";
    public static final String KEY_MEMORY_TASK_BLOCKED_REPORT_SETTINGS = "memory_task_blocked_report_config";
    public static final String KEY_PAGE_CONTEXT_SETTINGS = "deep_capture_settings";
    public static final String KEY_SENSORHUB_THRESHOLD_SETTINGS = "sensorhub_threshold_settings";
    private static final String REPO_SETTINGS = "memory_settings";
    private static final String TAG = "SettingsManager";
    private static final ConcurrentHashMap<String, CopyOnWriteArrayList<SettingsChangeListener>> listeners = null;

    static {
        SettingsManager r0 = new SettingsManager();
        INSTANCE = r0;
        GSON$delegate = LazyKt.lazy($$Lambda$SettingsManager$rCikstAr7Px0IHsTc0rofcptQJo.INSTANCE);
        listeners = new ConcurrentHashMap();
        IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), REPO_SETTINGS, 0, 2, null).registerChangeListener((b) ZeusTransformUtils.preCheckCast(r0, b.class, "com.obric.memorydata.plugin"));
    }

    private SettingsManager() {
    }

    private static final Gson GSON_delegate$lambda$0() {
        return new Gson();
    }

    public static /* synthetic */ Gson lambda$rCikstAr7Px0IHsTc0rofcptQJo() {
        return GSON_delegate$lambda$0();
    }

    public final /* synthetic */ <T> T fromJson(String r7) {
        Intrinsics.checkNotNullParameter(r7, "json");
        Gson r6 = getGSON();     // Catch: Exception -> L5
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);     // Catch: Exception -> L5
        return (T) r6.fromJson(r7, (Class) ZeusTransformUtils.preCheckCast(Object.class, Class.class, "com.obric.memorydata.plugin"));
    L5:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), GsonUtil.TAG, "json error ：" + e, null, 4, null);
        return null;
    }

    public final Gson getGSON() {
        return (Gson) ZeusTransformUtils.preCheckCast(GSON$delegate.getValue(), Gson.class, "com.obric.memorydata.plugin");
    }

    public final JSONObject getJson(String r10) {
        Intrinsics.checkNotNullParameter(r10, "key");
        String r9 = getSettingsStr(r10);
        if (r9 == null) goto L11;
        return new JSONObject(r9);
    L6:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "get invalid json settings for " + r10 + " string: " + r9 + ", " + e, null, 4, null);
        return null;
    L11:
        return null;
    }

    public final /* synthetic */ <T> T getSettingsObj(String r9) {
        Intrinsics.checkNotNullParameter(r9, "key");
        String r10 = getSettingsStr(r9);
        if (r10 != null) goto L10;
        return null;
    L10:
        Gson r8 = getGSON();     // Catch: Exception -> L7
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);     // Catch: Exception -> L7
        return (T) r8.fromJson(r10, (Class) ZeusTransformUtils.preCheckCast(Object.class, Class.class, "com.obric.memorydata.plugin"));
    L7:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), GsonUtil.TAG, "json error ：" + e, null, 4, null);
        return null;
    }

    public final /* synthetic */ <T> T getSettingsObj(String r9, T r10) {
        Intrinsics.checkNotNullParameter(r9, "key");
        String r11 = getSettingsStr(r9);
        Object r1 = null;
        if (r11 != null) goto L13;
    L9:
        if (r1 != null) goto L12;
        return r10;
    L12:
        return (T) r1;
    L13:
        Gson r8 = getGSON();     // Catch: Exception -> L7
        Intrinsics.reifiedOperationMarker(4, "T?");     // Catch: Exception -> L7
        r1 = r8.fromJson(r11, (Class) ZeusTransformUtils.preCheckCast(Object.class, Class.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L7
    L7:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), GsonUtil.TAG, "json error ：" + e, null, 4, null);
        goto L9
    }

    public final String getSettingsStr(String r8) {
        Intrinsics.checkNotNullParameter(r8, "key");
        boolean r2 = false;
        String r7 = IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), REPO_SETTINGS, 0, 2, null).getString(r8, null);
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L5;
        r2 = true;
    L5:
        RunLog r0 = RunLog.INSTANCE;
        if (r2 == false) goto L8;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(r0, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "get valid settings for " + r8, false, 4, null);
    L9:
        return r7;
    L8:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(r0, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "get empty settings for " + r8, null, 4, null);
        goto L9
    }

    @Override // com.obric.memorydata.middleware.api.store.b
    public void onKeyChanged(String r8, String r9) {
        Intrinsics.checkNotNullParameter(r8, "repoName");
        Intrinsics.checkNotNullParameter(r9, "key");
        if (Intrinsics.areEqual(r8, REPO_SETTINGS) == false) goto L10;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "onSettingsChanged " + r9, false, 4, null);
        CopyOnWriteArrayList r7 = (CopyOnWriteArrayList) ZeusTransformUtils.preCheckCast(listeners.get(r9), CopyOnWriteArrayList.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L12;
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L8:
        if (r10.hasNext() == false) goto L13;
        ((SettingsChangeListener) ZeusTransformUtils.preCheckCast(r10.next(), SettingsChangeListener.class, "com.obric.memorydata.plugin")).onSettingsChanged(r9);
        goto L8
    L13:
        return;
    L12:
        return;
    }

    public final void registerChangeListener(String r3, SettingsChangeListener r4) {
        SettingsChangeListener r2 = (SettingsChangeListener) ZeusTransformUtils.wrapperContextForParams(r4, SettingsChangeListener.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "key");
        Intrinsics.checkNotNullParameter(r2, "listener");
        ConcurrentMap r5 = (ConcurrentMap) ZeusTransformUtils.preCheckCast(listeners, ConcurrentMap.class, "com.obric.memorydata.plugin");
        Object r1 = r5.get(r3);
        if (r1 != null) goto L8;
        r1 = new CopyOnWriteArrayList();
        Object r6 = r5.putIfAbsent(r3, r1);
        if (r6 == null) goto L8;
        r1 = r6;
    L8:
        ((CopyOnWriteArrayList) ZeusTransformUtils.preCheckCast(r1, CopyOnWriteArrayList.class, "com.obric.memorydata.plugin")).addIfAbsent(r2);
    }

    public final void unregisterChangeListener(String r2, SettingsChangeListener r3) {
        SettingsChangeListener r1 = (SettingsChangeListener) ZeusTransformUtils.wrapperContextForParams(r3, SettingsChangeListener.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r1, "listener");
        CopyOnWriteArrayList r4 = (CopyOnWriteArrayList) ZeusTransformUtils.preCheckCast(listeners.get(r2), CopyOnWriteArrayList.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L6;
        r4.remove(r1);
        return;
    }
}
