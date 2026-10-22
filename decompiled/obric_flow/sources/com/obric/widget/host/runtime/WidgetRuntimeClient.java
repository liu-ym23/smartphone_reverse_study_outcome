package com.obric.widget.host.runtime;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Looper;
import android.os.Messenger;
import android.util.Log;
import com.obric.widget.host.WidgetPerfEvent;
import com.obric.widget.host.WidgetPerfReporter;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0006\u0018\u0000 Q2\u00020\u0001:\u0001QB+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ3\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0005¢\u0006\u0002\u0010\u0016J&\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005J*\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u001a2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001dJ\u001e\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u001aJ&\u0010\u001f\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001dJ&\u0010 \u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005J \u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u001aJ\u0016\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$2\b\b\u0002\u0010&\u001a\u00020\u001aJ,\u0010'\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u001a2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0005J*\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010\u0011\u001a\u00020\u00052\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00050$2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0005J4\u0010,\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010-\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010.\u001a\u00020\u0018Jk\u0010/\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u001a2\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u00105J\u001a\u00106\u001a\u0004\u0018\u0001072\u0006\u00108\u001a\u00020\u00052\u0006\u00109\u001a\u000207H\u0002J\u001a\u0010:\u001a\u0004\u0018\u0001072\u0006\u00108\u001a\u00020\u00052\u0006\u00109\u001a\u000207H\u0002J\u0010\u0010;\u001a\u00020\u00102\u0006\u0010<\u001a\u00020\u0005H\u0002J\u0010\u0010=\u001a\u00020\"2\u0006\u0010<\u001a\u00020\u0005H\u0002J\u0016\u0010>\u001a\b\u0012\u0004\u0012\u00020%0$2\u0006\u0010<\u001a\u00020\u0005H\u0002J\u0010\u0010?\u001a\u00020%2\u0006\u0010@\u001a\u00020AH\u0002J\u001a\u0010B\u001a\n\u0012\u0004\u0012\u00020C\u0018\u00010$2\b\u0010D\u001a\u0004\u0018\u00010EH\u0002J\u0014\u0010F\u001a\u00020G*\u00020H2\u0006\u0010I\u001a\u00020\u0014H\u0002J;\u0010J\u001a\u00020G2\u0006\u00108\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010K\u001a\u00020LH\u0002¢\u0006\u0002\u0010MJ(\u0010N\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u00108\u001a\u00020\u0005H\u0002J\u0010\u0010O\u001a\u00020\u00052\u0006\u00109\u001a\u000207H\u0002J+\u0010O\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002¢\u0006\u0002\u0010PR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\f\u001a\n \r*\u0004\u0018\u00010\u00030\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000e¨\u0006R"}, d2 = {"Lcom/obric/widget/host/runtime/WidgetRuntimeClient;", "", "context", "Landroid/content/Context;", "hostId", "", "perfReporter", "Lcom/obric/widget/host/WidgetPerfReporter;", "providerUri", "Landroid/net/Uri;", "<init>", "(Landroid/content/Context;Ljava/lang/String;Lcom/obric/widget/host/WidgetPerfReporter;Landroid/net/Uri;)V", "appContext", "kotlin.jvm.PlatformType", "Landroid/content/Context;", "ensureWidgetAvailable", "Lcom/obric/widget/host/runtime/WidgetAvailability;", "appletId", "widgetId", "preferredVersion", "", "scene", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)Lcom/obric/widget/host/runtime/WidgetAvailability;", "clearWidgetData", "", "instanceId", "", "dispatchWidgetBind", "messenger", "Landroid/os/Messenger;", "dispatchWidgetUnbind", "registerWidgetMessenger", "unregisterWidgetMessenger", "queryWidgetData", "Lcom/obric/widget/host/runtime/WidgetDataSnapshot;", "queryMiniAppInfos", "", "Lcom/obric/widget/host/runtime/WidgetAppletInfo;", "flags", "updateWidget", "reason", "refreshAffectedByUpdate", "Lcom/obric/widget/host/runtime/WidgetRefreshAffectedResult;", "changedDomains", "sendPayload", "payload", "waitForResult", "notifyWidgetDataChanged", "widgetData", "schemaVersion", "dataVersion", "updatedAt", "state", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)Z", "callProvider", "Landroid/os/Bundle;", "method", "extras", "callProviderDirectly", "parseAvailability", "raw", "parseDataSnapshot", "parseAppletInfoList", "parseAppletInfo", "json", "Lorg/json/JSONObject;", "parseWidgetList", "Lcom/obric/widget/host/runtime/WidgetDefinitionMetadata;", "array", "Lorg/json/JSONArray;", "setDetectNotRespondingCompat", "", "Landroid/content/ContentProviderClient;", "timeoutMs", "reportRpcFailure", "error", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Throwable;)V", "isValidBinding", "identityForLog", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Ljava/lang/String;", "Companion", "widget-host-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nWidgetRuntimeClient.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WidgetRuntimeClient.kt\ncom/obric/widget/host/runtime/WidgetRuntimeClient\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,732:1\n1#2:733\n1310#3,2:734\n*S KotlinDebug\n*F\n+ 1 WidgetRuntimeClient.kt\ncom/obric/widget/host/runtime/WidgetRuntimeClient\n*L\n542#1:734,2\n*E\n"})
public final class WidgetRuntimeClient {
    public static final String ARG_APPLET_ID = "appletId";
    public static final String ARG_CHANGED_DOMAINS = "changedDomains";
    public static final String ARG_DATA_VERSION = "dataVersion";
    public static final String ARG_FLAGS = "flags";
    public static final String ARG_HOST_ID = "hostId";
    public static final String ARG_INSTANCE_ID = "instanceId";
    public static final String ARG_MESSENGER = "messenger";
    public static final String ARG_PAYLOAD = "payload";
    public static final String ARG_PREFERRED_VERSION = "preferredVersion";
    public static final String ARG_REASON = "reason";
    public static final String ARG_SCENE = "scene";
    public static final String ARG_SCHEMA_VERSION = "schemaVersion";
    public static final String ARG_STATE = "state";
    public static final String ARG_UPDATED_AT = "updatedAt";
    public static final String ARG_UPDATED_WIDGET_IDS = "updatedWidgetIds";
    public static final String ARG_WAIT_FOR_RESULT = "waitForResult";
    public static final String ARG_WIDGET_DATA = "widgetData";
    public static final String ARG_WIDGET_ID = "widgetId";
    public static final Companion Companion = null;
    private static final String DEFAULT_REMOTE_URI = "content://com.obric.appletapp.SystemAppletProvider";
    private static final int INVALID_INSTANCE_ID = -1;
    private static final Set<String> METHODS_REQUIRING_HOST_ID = null;
    public static final String METHOD_CLEAR_WIDGET_DATA = "clearWidgetData";
    public static final String METHOD_DISPATCH_WIDGET_BIND = "dispatchWidgetBind";
    public static final String METHOD_DISPATCH_WIDGET_UNBIND = "dispatchWidgetUnbind";
    public static final String METHOD_ENSURE_WIDGET_AVAILABLE = "ensureWidgetAvailable";
    public static final String METHOD_NOTIFY_WIDGET_DATA_CHANGED = "notifyWidgetDataChanged";
    public static final String METHOD_QUERY_MINI_APP_INFOS = "queryMiniAppInfos";
    public static final String METHOD_QUERY_WIDGET_DATA = "queryWidgetData";
    public static final String METHOD_REFRESH_AFFECTED_BY_UPDATE = "refreshAffectedByUpdate";
    public static final String METHOD_REGISTER_WIDGET_MESSENGER = "registerWidgetMessenger";
    public static final String METHOD_SEND_PAYLOAD = "sendPayload";
    public static final String METHOD_UNREGISTER_WIDGET_MESSENGER = "unregisterWidgetMessenger";
    public static final String METHOD_UPDATE_WIDGET = "updateWidget";
    private static final long PROVIDER_ANR_TIMEOUT_MS = 15000;
    public static final int QUERY_MINI_APP_INFOS_FLAG_INCLUDE_UNINSTALLED = 1;
    public static final int QUERY_MINI_APP_INFOS_FLAG_WIDGETS = 2;
    public static final String SCENE_ADD = "add";
    public static final String SCENE_MANUAL = "manual";
    public static final String SCENE_RESTORE = "restore";
    private static final String TAG = "OWidgetRuntimeClient";
    private static final Object providerCallLock = null;
    private final Context appContext;
    private final String hostId;
    private final WidgetPerfReporter perfReporter;
    private final Uri providerUri;

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\"\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u00103\u001a\u000204*\u0002052\u0006\u00106\u001a\u00020\u00052\u0006\u00107\u001a\u00020\u0005H\u0000¢\u0006\u0002\b8J)\u00109\u001a\u0004\u0018\u00010:2\u0006\u00106\u001a\u00020\u00052\u0006\u0010;\u001a\u00020\u00052\b\u0010<\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0002\b=J\u0015\u0010>\u001a\u00020?2\u0006\u00106\u001a\u00020\u0005H\u0000¢\u0006\u0002\b@J\u0019\u0010A\u001a\u000204*\u0002052\u0006\u00107\u001a\u00020\u0005H\u0000¢\u0006\u0002\bBR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00050.X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u000e\u00101\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000¨\u0006C"}, d2 = {"Lcom/obric/widget/host/runtime/WidgetRuntimeClient$Companion;", "", "<init>", "()V", "TAG", "", "DEFAULT_REMOTE_URI", "PROVIDER_ANR_TIMEOUT_MS", "", "providerCallLock", "INVALID_INSTANCE_ID", "", "SCENE_ADD", "SCENE_RESTORE", "SCENE_MANUAL", "ARG_APPLET_ID", "ARG_FLAGS", "ARG_WIDGET_ID", "ARG_INSTANCE_ID", "ARG_HOST_ID", "ARG_MESSENGER", "ARG_PAYLOAD", "ARG_WAIT_FOR_RESULT", "ARG_WIDGET_DATA", "ARG_PREFERRED_VERSION", "ARG_SCHEMA_VERSION", "ARG_DATA_VERSION", "ARG_UPDATED_AT", "ARG_STATE", "ARG_REASON", "ARG_SCENE", "ARG_CHANGED_DOMAINS", "ARG_UPDATED_WIDGET_IDS", "METHOD_QUERY_MINI_APP_INFOS", "METHOD_ENSURE_WIDGET_AVAILABLE", "METHOD_QUERY_WIDGET_DATA", "METHOD_NOTIFY_WIDGET_DATA_CHANGED", "METHOD_CLEAR_WIDGET_DATA", "METHOD_REGISTER_WIDGET_MESSENGER", "METHOD_UNREGISTER_WIDGET_MESSENGER", "METHOD_DISPATCH_WIDGET_BIND", "METHOD_DISPATCH_WIDGET_UNBIND", "METHOD_UPDATE_WIDGET", "METHOD_REFRESH_AFFECTED_BY_UPDATE", "METHOD_SEND_PAYLOAD", "METHODS_REQUIRING_HOST_ID", "", "getMETHODS_REQUIRING_HOST_ID$widget_host_sdk_release", "()Ljava/util/Set;", "QUERY_MINI_APP_INFOS_FLAG_INCLUDE_UNINSTALLED", "QUERY_MINI_APP_INFOS_FLAG_WIDGETS", "ensureRequiredHostIdentity", "", "Landroid/os/Bundle;", "method", "hostId", "ensureRequiredHostIdentity$widget_host_sdk_release", "hostIdentityForProviderCall", "Lcom/obric/widget/host/runtime/WidgetRuntimeIdentity;", "fallbackHostId", "extrasHostId", "hostIdentityForProviderCall$widget_host_sdk_release", "shouldSerializeProviderCall", "", "shouldSerializeProviderCall$widget_host_sdk_release", "putHostIdentity", "putHostIdentity$widget_host_sdk_release", "widget-host-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public final void ensureRequiredHostIdentity$widget_host_sdk_release(Bundle r5, String r10, String r11) {
            Intrinsics.checkNotNullParameter(r5, "<this>");
            Intrinsics.checkNotNullParameter(r10, "method");
            Intrinsics.checkNotNullParameter(r11, "hostId");
            WidgetRuntimeIdentity r12 = hostIdentityForProviderCall$widget_host_sdk_release(r10, r11, r5.getString("hostId"));
            if (r12 != null) goto L5;
            return;
        L5:
            r5.putString("hostId", r12.getHostId());
        }

        public final Set<String> getMETHODS_REQUIRING_HOST_ID$widget_host_sdk_release() {
            return WidgetRuntimeClient.access$getMETHODS_REQUIRING_HOST_ID$cp();
        }

        public final WidgetRuntimeIdentity hostIdentityForProviderCall$widget_host_sdk_release(String r5, String r10, String r11) {
            Intrinsics.checkNotNullParameter(r5, "method");
            Intrinsics.checkNotNullParameter(r10, "fallbackHostId");
            if (getMETHODS_REQUIRING_HOST_ID$widget_host_sdk_release().contains(r5) == true) goto L6;
            return null;
        L6:
            if (r11 == null) goto L13;
            if (StringsKt.isBlank(r11) == true) goto L13;
            return WidgetRuntimeIdentity.Companion.normalize(r11);
        L13:
            return WidgetRuntimeIdentity.Companion.normalize(r10);
        }

        public final void putHostIdentity$widget_host_sdk_release(Bundle r5, String r10) {
            Intrinsics.checkNotNullParameter(r5, "<this>");
            Intrinsics.checkNotNullParameter(r10, "hostId");
            r5.putString("hostId", WidgetRuntimeIdentity.Companion.normalize(r10).getHostId());
        }

        public final boolean shouldSerializeProviderCall$widget_host_sdk_release(String r5) {
            Intrinsics.checkNotNullParameter(r5, "method");
            return !Intrinsics.areEqual(r5, "queryWidgetData");
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
        providerCallLock = new Object();
        METHODS_REQUIRING_HOST_ID = SetsKt.setOf(new String[]{"ensureWidgetAvailable", "queryWidgetData", "notifyWidgetDataChanged", "clearWidgetData", "registerWidgetMessenger", "unregisterWidgetMessenger", "dispatchWidgetBind", "dispatchWidgetUnbind", "updateWidget", "refreshAffectedByUpdate", "sendPayload"});
    }

    public WidgetRuntimeClient(Context r5, String r10, WidgetPerfReporter r11, Uri r12) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r10, "hostId");
        Intrinsics.checkNotNullParameter(r11, "perfReporter");
        Intrinsics.checkNotNullParameter(r12, "providerUri");
        this.hostId = r10;
        this.perfReporter = r11;
        this.providerUri = r12;
        this.appContext = r5.getApplicationContext();
    }

    public static final /* synthetic */ Set access$getMETHODS_REQUIRING_HOST_ID$cp() {
        return METHODS_REQUIRING_HOST_ID;
    }

    private final Bundle callProvider(String r10, Bundle r11) {
        Companion r5 = Companion;
        r5.ensureRequiredHostIdentity$widget_host_sdk_release(r11, r10, this.hostId);
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L11;
        Log.w(TAG, "callProvider skipped on main thread: method=" + r10 + ", " + identityForLog(r11));
        String r12 = r11.getString("appletId");
        String r13 = r11.getString("widgetId");
        if (r11.containsKey("instanceId") == false) goto L7;
        Integer r14 = Integer.valueOf(r11.getInt("instanceId"));
    L8:
        reportRpcFailure(r10, r12, r13, r14, new IllegalStateException("callProvider on main thread"));
        return null;
    L7:
        r14 = null;
        goto L8
    L11:
        if (r5.shouldSerializeProviderCall$widget_host_sdk_release(r10) == false) goto L21;
        Object r15 = providerCallLock;
        monitor-enter(r15);
        Bundle r16 = callProviderDirectly(r10, r11);     // Catch: Throwable -> L17
        monitor-exit(r15);
        return r16;
    L17:
        th = move-exception;
        throw th;
    L21:
        return callProviderDirectly(r10, r11);
    }

    /* JADX WARN: Not initialized variable reg: 7, insn: 0x0036: MOVE (r6 I:??[OBJECT, ARRAY]) = (r7 I:??[OBJECT, ARRAY]), block:B:7:0x0036 */
    private final Bundle callProviderDirectly(String r11, Bundle r12) {
        ContentProviderClient r10 = null;
        Bundle r13 = null;
        r13 = null;
        r13 = null;
        r13 = null;
        r13 = null;
        ContentProviderClient r14 = this.appContext.getContentResolver().acquireUnstableContentProviderClient(this.providerUri);     // Catch: Throwable -> L15 Exception -> L17 DeadObjectException -> L19
        if (r14 != null) goto L12;
        Log.w(TAG, "callProvider: provider not available, method=" + r11 + ", " + identityForLog(r12));     // Catch: Throwable -> L6 Exception -> L8 DeadObjectException -> L10
    L13:
        if (r14 == null) goto L27;
    L14:
        r14.release();
    L27:
        return r13;
    L12:
        setDetectNotRespondingCompat(r14, PROVIDER_ANR_TIMEOUT_MS);     // Catch: Throwable -> L6 Exception -> L8 DeadObjectException -> L10
        Log.d(TAG, "callProvider: method=" + r11 + ", " + identityForLog(r12));     // Catch: Throwable -> L6 Exception -> L8 DeadObjectException -> L10
        r13 = r14.call(r11, null, r12);     // Catch: Throwable -> L6 Exception -> L8 DeadObjectException -> L10
    L10:
        e = e;
    L24:
        Log.w(TAG, "callProvider: provider died, method=" + r11 + ", " + identityForLog(r12), e);     // Catch: Throwable -> L6
        if (r14 == null) goto L27;
    L8:
        e = e;
    L21:
        Log.w(TAG, "callProvider: failed, method=" + r11 + ", " + identityForLog(r12), e);     // Catch: Throwable -> L6
        if (r14 == null) goto L27;
    L6:
        th = th;
        r10 = r7;
    L28:
        if (r10 == null) goto L30;
        r10.release();
    L30:
        throw th;
    L19:
        e = e;
        r14 = null;
    L17:
        e = e;
        r14 = null;
    L15:
        th = th;
        goto L28
    }

    public static /* synthetic */ boolean clearWidgetData$default(WidgetRuntimeClient r5, int r10, String r11, String r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L9;
        r12 = null;
    L9:
        return r5.clearWidgetData(r10, r11, r12);
    }

    public static /* synthetic */ boolean dispatchWidgetBind$default(WidgetRuntimeClient r5, String r10, String r11, int r12, Messenger r13, int r14, Object r15) {
        if ((r14 & 8) == 0) goto L6;
        r13 = null;
    L6:
        return r5.dispatchWidgetBind(r10, r11, r12, r13);
    }

    public static /* synthetic */ WidgetAvailability ensureWidgetAvailable$default(WidgetRuntimeClient r5, String r10, String r11, Long r12, String r13, int r14, Object r15) {
        if ((r14 & 4) == 0) goto L6;
        r12 = null;
    L6:
        if ((r14 & 8) == 0) goto L9;
        r13 = "manual";
    L9:
        return r5.ensureWidgetAvailable(r10, r11, r12, r13);
    }

    private final String identityForLog(Bundle r5) {
        String r10 = r5.getString("appletId");
        String r11 = r5.getString("widgetId");
        if (r5.containsKey("instanceId") == false) goto L5;
        Integer r12 = Integer.valueOf(r5.getInt("instanceId"));
    L7:
        return identityForLog(r10, r11, r12);
    L5:
        r12 = null;
        goto L7
    }

    private final boolean isValidBinding(String r5, String r10, int r11, String r12) {
        if (StringsKt.isBlank(r5) == false) goto L5;
    L11:
        StringBuilder r13 = androidx.room.jarjarred.org.antlr.runtime.a.y(r12, " skipped: host=", this.hostId, ", appletId=", r5);
        r13.append(", widgetId=");
        r13.append(r10);
        r13.append(", instanceId=");
        r13.append(r11);
        Log.w(TAG, r13.toString());
        return false;
    L5:
        if (StringsKt.isBlank(r10) == true) goto L11;
        if (r11 == (-1)) goto L11;
        return true;
    }

    public static /* synthetic */ boolean notifyWidgetDataChanged$default(WidgetRuntimeClient r13, String r14, String r15, int r16, String r17, Integer r18, Long r19, Long r20, String r21, String r22, int r23, Object r24) {
        if ((r23 & 8) == 0) goto L5;
        String r10 = null;
    L7:
        if ((r23 & 16) == 0) goto L9;
        Integer r11 = null;
    L11:
        if ((r23 & 32) == 0) goto L13;
        Long r12 = null;
    L15:
        if ((r23 & 64) == 0) goto L17;
        Long r110 = null;
    L19:
        if ((r23 & 128) == 0) goto L21;
        String r111 = null;
    L23:
        if ((r23 & 256) == 0) goto L25;
        String r112 = null;
    L27:
        return r13.notifyWidgetDataChanged(r14, r15, r16, r10, r11, r12, r110, r111, r112);
    L25:
        r112 = r22;
        goto L27
    L21:
        r111 = r21;
        goto L23
    L17:
        r110 = r20;
        goto L19
    L13:
        r12 = r19;
        goto L15
    L9:
        r11 = r18;
        goto L11
    L5:
        r10 = r17;
        goto L7
    }

    private final WidgetAppletInfo parseAppletInfo(JSONObject r15) {
        String r5 = r15.optString("appletId");
        long r10 = r15.optLong("versionCode", 0);
        String r11 = r15.optString("label");
        Intrinsics.checkNotNull(r11);
        if (StringsKt.isBlank(r11) == false) goto L6;
        r11 = null;
    L6:
        int r12 = r15.optInt("labelRes", 0);
        String r13 = r15.optString("iconUri");
        Intrinsics.checkNotNull(r13);
        if (StringsKt.isBlank(r13) == true) goto L9;
        String r14 = r13;
    L10:
        int r16 = r15.optInt("iconRes", 0);
        boolean r17 = r15.optBoolean("system", false);
        if (r15.has("installed") == true) goto L13;
    L15:
        Boolean r18 = null;
    L16:
        String r19 = r15.optString("launchInfo");
        Intrinsics.checkNotNull(r19);
        if (StringsKt.isBlank(r19) == true) goto L19;
        String r110 = r19;
    L20:
        String r20 = r15.optString("aboutUrl");
        Intrinsics.checkNotNull(r20);
        if (StringsKt.isBlank(r20) == true) goto L23;
        String r111 = r20;
    L25:
        return new WidgetAppletInfo(r5, r10, r11, r12, r14, r16, r17, r18, r110, r111, parseWidgetList(r15.optJSONArray("widgets")));
    L23:
        r111 = null;
        goto L25
    L19:
        r110 = null;
        goto L20
    L13:
        if (r15.isNull("installed") == true) goto L15;
        r18 = Boolean.valueOf(r15.optBoolean("installed"));
        goto L16
    L9:
        r14 = null;
        goto L10
    }

    private final List<WidgetAppletInfo> parseAppletInfoList(String r5) {
        JSONArray r10 = new JSONArray(r5);
        List r11 = CollectionsKt.createListBuilder();
        int r12 = r10.length();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L10;
        JSONObject r14 = r10.optJSONObject(r13);
        if (r14 == null) goto L8;
        r11.add(parseAppletInfo(r14));
    L8:
        r13 = r13 + 1;
        goto L3
    L10:
        return CollectionsKt.build(r11);
    }

    private final WidgetAvailability parseAvailability(String r19) {
        JSONObject r5 = new JSONObject(r19);
        String r10 = r5.optString("appletId");
        Intrinsics.checkNotNull(r10);
        String r11 = null;
        if (StringsKt.isBlank(r10) == true) goto L5;
        String r12 = r10;
    L6:
        String r13 = r5.optString("widgetId");
        Intrinsics.checkNotNull(r13);
        if (StringsKt.isBlank(r13) == true) goto L9;
        String r14 = r13;
    L10:
        String r15 = r5.optString("scene");
        Intrinsics.checkNotNull(r15);
        if (StringsKt.isBlank(r15) == true) goto L13;
        String r16 = r15;
    L14:
        boolean r17 = r5.optBoolean("ready", false);
        String r18 = r5.optString("installState");
        Intrinsics.checkNotNull(r18);
        if (StringsKt.isBlank(r18) == true) goto L17;
        String r20 = r18;
    L18:
        long r110 = r5.optLong("resolvedVersion", 0);
        String r21 = r5.optString("preloadToken");
        Intrinsics.checkNotNull(r21);
        if (StringsKt.isBlank(r21) == false) goto L22;
        r21 = null;
    L22:
        String r22 = r5.optString("errorCode");
        Intrinsics.checkNotNull(r22);
        if (StringsKt.isBlank(r22) == true) goto L25;
        String r111 = r22;
    L26:
        String r23 = r5.optString("errorMessage");
        Intrinsics.checkNotNull(r23);
        if (StringsKt.isBlank(r23) == true) goto L30;
        r11 = r23;
    L30:
        return new WidgetAvailability(r12, r14, r16, r17, r20, r110, r21, r111, r11, r5.optBoolean("retryable", false), r5.optLong("checkedAt", 0));
    L25:
        r111 = null;
        goto L26
    L17:
        r20 = null;
        goto L18
    L13:
        r16 = null;
        goto L14
    L9:
        r14 = null;
        goto L10
    L5:
        r12 = null;
        goto L6
    }

    private final WidgetDataSnapshot parseDataSnapshot(String r15) {
        JSONObject r14 = new JSONObject(r15);
        String r5 = r14.optString("appletId");
        String r10 = r14.optString("widgetId");
        int r11 = r14.optInt("instanceId", -1);
        String r16 = r14.optString("widgetData");
        Intrinsics.checkNotNull(r16);
        String r12 = null;
        if (StringsKt.isBlank(r16) == false) goto L6;
        r16 = null;
    L6:
        String r13 = r14.optString("hostId");
        Intrinsics.checkNotNull(r13);
        if (StringsKt.isBlank(r13) == false) goto L10;
        r13 = null;
    L10:
        if (r13 != null) goto L12;
        r13 = "launcher";
    L12:
        String r17 = r13;
        int r18 = r14.optInt("schemaVersion", 1);
        long r19 = r14.optLong("dataVersion", 0);
        long r110 = r14.optLong("updatedAt", 0);
        String r111 = r14.optString("state");
        Intrinsics.checkNotNull(r111);
        if (StringsKt.isBlank(r111) == true) goto L15;
        r12 = r111;
    L15:
        if (r12 != null) goto L17;
        String r112 = "content";
    L19:
        return new WidgetDataSnapshot(r5, r10, r11, r16, r17, r18, r19, r110, r112);
    L17:
        r112 = r12;
        goto L19
    }

    private final List<WidgetDefinitionMetadata> parseWidgetList(JSONArray r18) {
        if (r18 != null) goto L5;
        return null;
    L5:
        List r5 = CollectionsKt.createListBuilder();
        int r10 = r18.length();
        int r11 = 0;
    L6:
        if (r11 >= r10) goto L17;
        JSONObject r12 = r18.optJSONObject(r11);
        if (r12 == null) goto L15;
        String r13 = r12.optString("appletId");
        String r14 = r12.optString("widgetId");
        String r15 = r12.optString("previewUri");
        Intrinsics.checkNotNull(r15);
        if (StringsKt.isBlank(r15) == true) goto L13;
        String r16 = r15;
    L14:
        r5.add(new WidgetDefinitionMetadata(r13, r14, r16, r12.optInt("previewRes", 0), r12.optInt("spanX", 0), r12.optInt("spanY", 0), r12.optInt("minSpanX", 0), r12.optInt("minSpanY", 0)));
        goto L15
    L13:
        r16 = null;
    L15:
        r11 = r11 + 1;
        goto L6
    L17:
        return CollectionsKt.build(r5);
    }

    public static /* synthetic */ List queryMiniAppInfos$default(WidgetRuntimeClient r5, int r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r10 = 2;
    L6:
        return r5.queryMiniAppInfos(r10);
    }

    public static /* synthetic */ WidgetRefreshAffectedResult refreshAffectedByUpdate$default(WidgetRuntimeClient r5, String r10, List r11, String r12, int r13, Object r14) {
        if ((r13 & 4) == 0) goto L6;
        r12 = null;
    L6:
        return r5.refreshAffectedByUpdate(r10, r11, r12);
    }

    private final void reportRpcFailure(String r13, String r14, String r15, Integer r16, Throwable r17) {
        if (this.perfReporter.isEnabled() == true) goto L5;
        return;
    L5:
        this.perfReporter.report(new WidgetPerfEvent("widget_runtime_rpc_failure", this.hostId, null, 0, MapsKt.mapOf(new Pair[]{TuplesKt.to("method", r13), TuplesKt.to("appletId", r14), TuplesKt.to("widgetId", r15), TuplesKt.to("instanceId", r16), TuplesKt.to("error", r17.getClass().getSimpleName()), TuplesKt.to("message", r17.getMessage())}), 12, null));
    }

    public static /* synthetic */ String sendPayload$default(WidgetRuntimeClient r10, String r11, String r12, int r13, String r14, boolean r15, int r16, Object r17) {
        if ((r16 & 16) == 0) goto L6;
        r15 = false;
    L6:
        return r10.sendPayload(r11, r12, r13, r14, r15);
    }

    private final void setDetectNotRespondingCompat(ContentProviderClient r10, long r11) {
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L13
        Method[] r12 = r10.getClass().getMethods();     // Catch: Throwable -> L13
        int r13 = r12.length;     // Catch: Throwable -> L13
        int r14 = 0;
    L4:
        Object r15 = null;
        if (r14 >= r13) goto L16;
        Method r16 = r12[r14];     // Catch: Throwable -> L13
        if (Intrinsics.areEqual(r16.getName(), "setDetectNotResponding") == false) goto L15;
        if (r16.getParameterTypes().length != 1) goto L15;
        if (Intrinsics.areEqual(r16.getParameterTypes()[0], Long.TYPE) == false) goto L15;
    L17:
        if (r16 == null) goto L19;
        r15 = r16.invoke(r10, new Object[]{Long.valueOf(r11)});     // Catch: Throwable -> L13
    L19:
        Object r17 = Result.m124constructorimpl(r15);     // Catch: Throwable -> L13
    L22:
        Throwable r18 = Result.m127exceptionOrNullimpl(r17);
        if (r18 == null) goto L33;
        Log.d(TAG, "setDetectNotResponding unavailable, host=" + this.hostId, r18);
        return;
    L33:
        return;
    L15:
        r14 = r14 + 1;     // Catch: Throwable -> L13
        goto L4
    L16:
        r16 = null;
    L13:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r17 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L22
    }

    public static /* synthetic */ boolean unregisterWidgetMessenger$default(WidgetRuntimeClient r5, int r10, String r11, String r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L9;
        r12 = null;
    L9:
        return r5.unregisterWidgetMessenger(r10, r11, r12);
    }

    public static /* synthetic */ String updateWidget$default(WidgetRuntimeClient r5, String r10, String r11, int r12, String r13, int r14, Object r15) {
        if ((r14 & 8) == 0) goto L6;
        r13 = null;
    L6:
        return r5.updateWidget(r10, r11, r12, r13);
    }

    public final boolean clearWidgetData(int r10, String r11, String r12) {
        boolean r5 = false;
        if (r10 != (-1)) goto L27;
        Log.w(TAG, "clearWidgetData skipped: invalid instanceId=" + r10);
        return false;
    L27:
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L9
        Bundle r14 = new Bundle();     // Catch: Throwable -> L9
        r14.putInt("instanceId", r10);     // Catch: Throwable -> L9
        if (r11 == null) goto L11;
        r14.putString("appletId", r11);     // Catch: Throwable -> L9
    L11:
        if (r12 == null) goto L13;
        r14.putString("widgetId", r12);     // Catch: Throwable -> L9
    L13:
        Companion.putHostIdentity$widget_host_sdk_release(r14, this.hostId);     // Catch: Throwable -> L9
        Bundle r15 = callProvider("clearWidgetData", r14);     // Catch: Throwable -> L9
        if (r15 == null) goto L16;
        r5 = r15.getBoolean("clearWidgetData", false);     // Catch: Throwable -> L9
    L16:
        Object r16 = Result.m124constructorimpl(Boolean.valueOf(r5));     // Catch: Throwable -> L9
    L19:
        Throwable r17 = Result.m127exceptionOrNullimpl(r16);
        if (r17 == null) goto L22;
        Log.w(TAG, "clearWidgetData failed: " + identityForLog(r11, r12, Integer.valueOf(r10)), r17);
        reportRpcFailure("clearWidgetData", r11, r12, Integer.valueOf(r10), r17);
    L22:
        Boolean r18 = Boolean.FALSE;
        if (Result.m130isFailureimpl(r16) == false) goto L26;
        r16 = r18;
    L26:
        return ((Boolean) r16).booleanValue();
    L9:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r16 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L19
    }

    public final boolean dispatchWidgetBind(String r10, String r11, int r12, Messenger r13) {
        Intrinsics.checkNotNullParameter(r10, "appletId");
        Intrinsics.checkNotNullParameter(r11, "widgetId");
        if (isValidBinding(r10, r11, r12, "dispatchWidgetBind") == true) goto L5;
        return false;
    L5:
        Bundle r5 = new Bundle();
        r5.putString("appletId", r10);
        r5.putString("widgetId", r11);
        r5.putInt("instanceId", r12);
        Companion.putHostIdentity$widget_host_sdk_release(r5, this.hostId);
        if (r13 == null) goto L9;
        r5.putParcelable("messenger", r13);
    L9:
        if (callProvider("dispatchWidgetBind", r5) == null) goto L12;
        return true;
    L12:
        return false;
    }

    public final boolean dispatchWidgetUnbind(String r10, String r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "appletId");
        Intrinsics.checkNotNullParameter(r11, "widgetId");
        if (isValidBinding(r10, r11, r12, "dispatchWidgetUnbind") == true) goto L5;
        return false;
    L5:
        Bundle r5 = new Bundle();
        r5.putString("appletId", r10);
        r5.putString("widgetId", r11);
        r5.putInt("instanceId", r12);
        Companion.putHostIdentity$widget_host_sdk_release(r5, this.hostId);
        if (callProvider("dispatchWidgetUnbind", r5) == null) goto L9;
        return true;
    L9:
        return false;
    }

    public final WidgetAvailability ensureWidgetAvailable(String r13, String r14, Long r15, String r16) {
        Intrinsics.checkNotNullParameter(r13, "appletId");
        Intrinsics.checkNotNullParameter(r14, "widgetId");
        Intrinsics.checkNotNullParameter(r16, "scene");
        Object r10 = null;
        if (StringsKt.isBlank(r13) == false) goto L5;
    L30:
        Log.w(TAG, "ensureWidgetAvailable skipped: missing appletId/widgetId");
        return null;
    L5:
        if (StringsKt.isBlank(r14) == true) goto L30;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L10
        Bundle r12 = new Bundle();     // Catch: Throwable -> L10
        r12.putString("appletId", r13);     // Catch: Throwable -> L10
        r12.putString("widgetId", r14);     // Catch: Throwable -> L10
        Companion.putHostIdentity$widget_host_sdk_release(r12, this.hostId);     // Catch: Throwable -> L10
        if (r15 == null) goto L12;
        r12.putLong("preferredVersion", r15.longValue());     // Catch: Throwable -> L10
    L12:
        r12.putString("scene", r16);     // Catch: Throwable -> L10
        Bundle r5 = callProvider("ensureWidgetAvailable", r12);     // Catch: Throwable -> L10
        if (r5 == null) goto L17;
        String r17 = r5.getString("ensureWidgetAvailable");     // Catch: Throwable -> L10
        if (r17 == null) goto L17;
        WidgetAvailability r18 = parseAvailability(r17);     // Catch: Throwable -> L10
    L18:
        Object r19 = Result.m124constructorimpl(r18);     // Catch: Throwable -> L10
    L21:
        Throwable r20 = Result.m127exceptionOrNullimpl(r19);
        if (r20 == null) goto L25;
        Log.w(TAG, androidx.constraintlayout.motion.widget.a.t(androidx.constraintlayout.motion.widget.a.y("ensureWidgetAvailable failed: host=", this.hostId, ", appletId=", r13, ", widgetId="), r14, ", scene=", r16), r20);
        reportRpcFailure("ensureWidgetAvailable", r13, r14, null, r20);
    L25:
        if (Result.m130isFailureimpl(r19) == true) goto L29;
        r10 = r19;
    L29:
        return (WidgetAvailability) r10;
    L17:
        r18 = null;
    L10:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r19 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L21
    }

    public final boolean notifyWidgetDataChanged(String r10, String r11, int r12, String r13, Integer r14, Long r15, Long r16, String r17, String r18) {
        Intrinsics.checkNotNullParameter(r10, "appletId");
        Intrinsics.checkNotNullParameter(r11, "widgetId");
        if (isValidBinding(r10, r11, r12, "notifyWidgetDataChanged") == true) goto L5;
        return false;
    L5:
        Bundle r5 = new Bundle();
        r5.putString("appletId", r10);
        r5.putString("widgetId", r11);
        r5.putInt("instanceId", r12);
        Companion.putHostIdentity$widget_host_sdk_release(r5, this.hostId);
        if (r13 == null) goto L8;
        r5.putString("widgetData", r13);
    L8:
        if (r14 == null) goto L10;
        r5.putInt("schemaVersion", r14.intValue());
    L10:
        if (r15 == null) goto L12;
        r5.putLong("dataVersion", r15.longValue());
    L12:
        if (r16 == null) goto L14;
        r5.putLong("updatedAt", r16.longValue());
    L14:
        if (r17 == null) goto L16;
        r5.putString("state", r17);
    L16:
        if (r18 == null) goto L18;
        r5.putString("reason", r18);
    L18:
        Bundle r19 = callProvider("notifyWidgetDataChanged", r5);
        if (r19 != null) goto L21;
        return false;
    L21:
        return r19.getBoolean("notifyWidgetDataChanged", false);
    }

    public final List<WidgetAppletInfo> queryMiniAppInfos(int r5) {
        Bundle r10 = new Bundle();
        r10.putInt("flags", r5);
        Bundle r11 = callProvider("queryMiniAppInfos", r10);
        if (r11 == null) goto L10;
        String r12 = r11.getString("queryMiniAppInfos");
        if (r12 == null) goto L10;
        List<WidgetAppletInfo> r13 = parseAppletInfoList(r12);
        if (r13 == null) goto L10;
        return r13;
    L10:
        return CollectionsKt.emptyList();
    }

    public final WidgetDataSnapshot queryWidgetData(String r10, String r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "appletId");
        Intrinsics.checkNotNullParameter(r11, "widgetId");
        Object r5 = null;
        if (isValidBinding(r10, r11, r12, "queryWidgetData") == true) goto L5;
        return null;
    L5:
        Bundle r13 = new Bundle();
        r13.putString("appletId", r10);
        r13.putString("widgetId", r11);
        r13.putInt("instanceId", r12);
        Companion.putHostIdentity$widget_host_sdk_release(r13, this.hostId);
        Bundle r14 = callProvider("queryWidgetData", r13);
        if (r14 == null) goto L30;
        String r15 = r14.getString("queryWidgetData");
        if (r15 != null) goto L10;
        return null;
    L10:
        if (StringsKt.isBlank(r15) == false) goto L12;
    L13:
        r15 = null;
    L14:
        if (r15 == null) goto L32;
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L17
        Object r17 = Result.m124constructorimpl(parseDataSnapshot(r15));     // Catch: Throwable -> L17
    L19:
        Throwable r18 = Result.m127exceptionOrNullimpl(r17);
        if (r18 == null) goto L23;
        Log.w(TAG, "queryWidgetData parse failed: " + identityForLog(r10, r11, Integer.valueOf(r12)), r18);
    L23:
        if (Result.m130isFailureimpl(r17) == true) goto L27;
        r5 = r17;
    L27:
        return (WidgetDataSnapshot) r5;
    L17:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r17 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L19
    L32:
        return null;
    L12:
        if (Intrinsics.areEqual(r15, "null") == false) goto L14;
    L30:
        return null;
    }

    public final WidgetRefreshAffectedResult refreshAffectedByUpdate(String r5, List<String> r10, String r11) {
        Intrinsics.checkNotNullParameter(r5, "appletId");
        Intrinsics.checkNotNullParameter(r10, "changedDomains");
        WidgetRefreshAffectedResult r12 = null;
        if (StringsKt.isBlank(r5) == false) goto L5;
    L17:
        Log.w(TAG, "refreshAffectedByUpdate skipped: appletId=" + r5 + ", changedDomains=" + r10);
        return null;
    L5:
        if (r10.isEmpty() == true) goto L17;
        Bundle r13 = new Bundle();
        r13.putString("appletId", r5);
        r13.putStringArrayList("changedDomains", new ArrayList(r10));
        Companion.putHostIdentity$widget_host_sdk_release(r13, this.hostId);
        if (r11 == null) goto L10;
        r13.putString("reason", r11);
    L10:
        Bundle r14 = callProvider("refreshAffectedByUpdate", r13);
        if (r14 == null) goto L16;
        int r15 = r14.getInt("refreshAffectedByUpdate", 0);
        List r16 = r14.getStringArrayList("updatedWidgetIds");
        if (r16 != null) goto L15;
        r16 = CollectionsKt.emptyList();
    L15:
        r12 = new WidgetRefreshAffectedResult(r15, r16);
    L16:
        return r12;
    }

    public final boolean registerWidgetMessenger(String r10, String r11, int r12, Messenger r13) {
        Intrinsics.checkNotNullParameter(r10, "appletId");
        Intrinsics.checkNotNullParameter(r11, "widgetId");
        Intrinsics.checkNotNullParameter(r13, "messenger");
        if (isValidBinding(r10, r11, r12, "registerWidgetMessenger") == true) goto L5;
        return false;
    L5:
        Bundle r5 = new Bundle();
        r5.putString("appletId", r10);
        r5.putString("widgetId", r11);
        r5.putInt("instanceId", r12);
        Companion.putHostIdentity$widget_host_sdk_release(r5, this.hostId);
        r5.putParcelable("messenger", r13);
        Bundle r14 = callProvider("registerWidgetMessenger", r5);
        if (r14 != null) goto L8;
        return false;
    L8:
        return r14.getBoolean("registerWidgetMessenger", false);
    }

    public final String sendPayload(String r10, String r11, int r12, String r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r10, "appletId");
        Intrinsics.checkNotNullParameter(r11, "widgetId");
        if (isValidBinding(r10, r11, r12, "sendPayload") == true) goto L5;
        return null;
    L5:
        Bundle r5 = new Bundle();
        r5.putString("appletId", r10);
        r5.putString("widgetId", r11);
        r5.putInt("instanceId", r12);
        Companion.putHostIdentity$widget_host_sdk_release(r5, this.hostId);
        r5.putString("payload", r13);
        if (r14 == false) goto L8;
        r5.putBoolean("waitForResult", true);
    L8:
        Bundle r15 = callProvider("sendPayload", r5);
        if (r15 != null) goto L11;
        return null;
    L11:
        return r15.getString("sendPayload");
    }

    public final boolean unregisterWidgetMessenger(int r5, String r10, String r11) {
        if (r5 != (-1)) goto L6;
        Log.w(TAG, "unregisterWidgetMessenger skipped: invalid instanceId=" + r5);
        return false;
    L6:
        Bundle r12 = new Bundle();
        r12.putInt("instanceId", r5);
        if (r10 == null) goto L9;
        r12.putString("appletId", r10);
    L9:
        if (r11 == null) goto L11;
        r12.putString("widgetId", r11);
    L11:
        Companion.putHostIdentity$widget_host_sdk_release(r12, this.hostId);
        Bundle r13 = callProvider("unregisterWidgetMessenger", r12);
        if (r13 != null) goto L14;
        return false;
    L14:
        return r13.getBoolean("unregisterWidgetMessenger", false);
    }

    public final String updateWidget(String r10, String r11, int r12, String r13) {
        Intrinsics.checkNotNullParameter(r10, "appletId");
        Intrinsics.checkNotNullParameter(r11, "widgetId");
        if (isValidBinding(r10, r11, r12, "updateWidget") == true) goto L5;
        return null;
    L5:
        Bundle r5 = new Bundle();
        r5.putString("appletId", r10);
        r5.putString("widgetId", r11);
        r5.putInt("instanceId", r12);
        Companion.putHostIdentity$widget_host_sdk_release(r5, this.hostId);
        if (r13 == null) goto L8;
        r5.putString("reason", r13);
    L8:
        Bundle r14 = callProvider("updateWidget", r5);
        if (r14 != null) goto L11;
        return null;
    L11:
        return r14.getString("updateWidget");
    }

    public /* synthetic */ WidgetRuntimeClient(Context r5, String r10, WidgetPerfReporter r11, Uri r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 4) == 0) goto L6;
        r11 = WidgetPerfReporter.Companion.getNO_OP();
    L6:
        if ((r13 & 8) == 0) goto L8;
        r12 = Uri.parse(DEFAULT_REMOTE_URI);
    L8:
        this(r5, r10, r11, r12);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v2 */
    private final String identityForLog(String r5, String r10, Integer r11) {
        String r12 = this.hostId;
        if (r5 != null) goto L5;
        r5 = "";
    L5:
        if (r10 != null) goto L7;
        r10 = "";
    L7:
        if (r11 != 0) goto L9;
        r11 = "";
    L9:
        ?? r13 = androidx.constraintlayout.motion.widget.a.y("hostId=", r12, ", appletId=", r5, ", widgetId=");
        r13.append(r10);
        r13.append(", instanceId=");
        r13.append(r11);
        return r13.toString();
    }
}
