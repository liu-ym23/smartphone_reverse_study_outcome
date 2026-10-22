package com.obric.widget.host.runtime;

import android.content.Context;
import android.net.Uri;
import android.os.Messenger;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import cn.nubia.neopush.commons.Constant;
import com.google.gson.JsonObject;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.widget.host.WidgetPerfReporter;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000ê\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u0080\u00012\u00020\u0001:\u0002\u0080\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0016\u0010#\u001a\b\u0012\u0004\u0012\u0002H$0\"\"\b\b\u0000\u0010$*\u00020\u0001J\u0006\u0010%\u001a\u00020&J\u001e\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(2\b\u0010*\u001a\u0004\u0018\u00010\u0005H\u0086@¢\u0006\u0002\u0010+J\u0014\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00050(H\u0086@¢\u0006\u0002\u0010-J\u0018\u0010.\u001a\u0004\u0018\u00010/2\u0006\u0010*\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u0010+J \u00100\u001a\u0004\u0018\u00010)2\u0006\u0010*\u001a\u00020\u00052\u0006\u00101\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u00102J3\u00103\u001a\u0004\u0018\u0001042\u0006\u0010*\u001a\u00020\u00052\u0006\u00101\u001a\u00020\u00052\n\b\u0002\u00105\u001a\u0004\u0018\u0001062\b\b\u0002\u00107\u001a\u00020\u0005¢\u0006\u0002\u00108J&\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0005J*\u0010=\u001a\u00020:2\u0006\u0010*\u001a\u00020\u00052\u0006\u00101\u001a\u00020\u00052\u0006\u0010;\u001a\u00020<2\n\b\u0002\u0010>\u001a\u0004\u0018\u00010?J\u001e\u0010@\u001a\u00020:2\u0006\u0010*\u001a\u00020\u00052\u0006\u00101\u001a\u00020\u00052\u0006\u0010;\u001a\u00020<J&\u0010A\u001a\u00020:2\u0006\u0010*\u001a\u00020\u00052\u0006\u00101\u001a\u00020\u00052\u0006\u0010;\u001a\u00020<2\u0006\u0010>\u001a\u00020?J&\u0010B\u001a\u00020:2\u0006\u0010;\u001a\u00020<2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0005J \u0010C\u001a\u0004\u0018\u00010D2\u0006\u0010*\u001a\u00020\u00052\u0006\u00101\u001a\u00020\u00052\u0006\u0010;\u001a\u00020<J,\u0010E\u001a\u0004\u0018\u00010\u00052\u0006\u0010*\u001a\u00020\u00052\u0006\u00101\u001a\u00020\u00052\u0006\u0010;\u001a\u00020<2\n\b\u0002\u0010F\u001a\u0004\u0018\u00010\u0005J*\u0010G\u001a\u0004\u0018\u00010H2\u0006\u0010*\u001a\u00020\u00052\f\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00050(2\n\b\u0002\u0010F\u001a\u0004\u0018\u00010\u0005J4\u0010J\u001a\u0004\u0018\u00010\u00052\u0006\u0010*\u001a\u00020\u00052\u0006\u00101\u001a\u00020\u00052\u0006\u0010;\u001a\u00020<2\b\u0010K\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010L\u001a\u00020:J*\u0010M\u001a\u00020N2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010O\u001a\u00020)2\n\b\u0002\u0010;\u001a\u0004\u0018\u00010<H\u0086@¢\u0006\u0002\u0010PJ\"\u0010Q\u001a\u00020:2\b\u0010R\u001a\u0004\u0018\u00010N2\u0006\u0010O\u001a\u00020)2\b\u0010S\u001a\u0004\u0018\u00010\u0005J\u0018\u0010T\u001a\u00020:2\b\u0010R\u001a\u0004\u0018\u00010N2\u0006\u0010U\u001a\u00020:J\u0018\u0010V\u001a\u00020:2\b\u0010R\u001a\u0004\u0018\u00010N2\u0006\u0010W\u001a\u00020:J8\u0010X\u001a\u00020:2\b\u0010R\u001a\u0004\u0018\u00010N2\u0006\u0010O\u001a\u00020)2\u0006\u0010;\u001a\u00020<2\u0006\u0010W\u001a\u00020:2\u0006\u0010Y\u001a\u0002062\u0006\u0010Z\u001a\u00020\u0005J\u0010\u0010[\u001a\u00020:2\b\u0010R\u001a\u0004\u0018\u00010NJ \u0010\\\u001a\u00020:2\b\u0010R\u001a\u0004\u0018\u00010N2\u0006\u0010]\u001a\u00020\u00052\u0006\u0010^\u001a\u00020_J\u0018\u0010`\u001a\u00020:2\b\u0010R\u001a\u0004\u0018\u00010N2\u0006\u0010a\u001a\u00020bJP\u0010c\u001a\u00020:2\b\u0010R\u001a\u0004\u0018\u00010N2\b\u0010*\u001a\u0004\u0018\u00010\u00052\b\u00101\u001a\u0004\u0018\u00010\u00052\u0006\u0010;\u001a\u00020<2\u0006\u0010d\u001a\u00020\u00052\b\u0010e\u001a\u0004\u0018\u00010\u00052\u0006\u0010Y\u001a\u0002062\b\u0010f\u001a\u0004\u0018\u00010\u0005J<\u0010g\u001a\u00020:2\b\u0010R\u001a\u0004\u0018\u00010N2\b\u0010*\u001a\u0004\u0018\u00010\u00052\b\u00101\u001a\u0004\u0018\u00010\u00052\u0006\u0010;\u001a\u00020<2\u0006\u0010Y\u001a\u0002062\u0006\u0010Z\u001a\u00020\u0005JF\u0010h\u001a\u00020:2\b\u0010R\u001a\u0004\u0018\u00010N2\b\u0010*\u001a\u0004\u0018\u00010\u00052\b\u00101\u001a\u0004\u0018\u00010\u00052\u0006\u0010;\u001a\u00020<2\u0006\u0010i\u001a\u00020\u00052\u0006\u0010j\u001a\u0002062\b\u0010k\u001a\u0004\u0018\u00010\u0005J8\u0010l\u001a\u00020m2\b\u0010R\u001a\u0004\u0018\u00010N2\u0006\u0010O\u001a\u00020)2\u0006\u0010;\u001a\u00020<2\u0006\u0010n\u001a\u00020\u00052\u0006\u0010o\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u0010pJ6\u0010q\u001a\u00020r2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010O\u001a\u00020)2\u0006\u0010;\u001a\u00020<2\u0006\u0010n\u001a\u00020\u00052\u0006\u0010o\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u0010sJ\u001e\u0010t\u001a\u00020u2\u0006\u0010O\u001a\u00020)2\u0006\u0010;\u001a\u00020<H\u0086@¢\u0006\u0002\u0010vJ\u0016\u0010w\u001a\u00020&2\u0006\u0010O\u001a\u00020)2\u0006\u0010;\u001a\u00020<J\u0016\u0010x\u001a\u00020y2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010z\u001a\u00020\u0005J\u0010\u0010{\u001a\u00020|2\b\b\u0002\u0010}\u001a\u00020<J\u0006\u0010~\u001a\u00020\u007fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0010\u001a\n \u0011*\u0004\u0018\u00010\u00030\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001d\u001a\u00020\u001e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00010\"X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0081\u0001"}, d2 = {"Lcom/obric/widget/host/runtime/WidgetRuntimeServices;", "", "context", "Landroid/content/Context;", "hostId", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "perfReporter", "Lcom/obric/widget/host/WidgetPerfReporter;", "renderStateStore", "Lcom/obric/widget/host/runtime/WidgetRenderStateStore;", "<init>", "(Landroid/content/Context;Ljava/lang/String;Lkotlinx/coroutines/CoroutineScope;Lcom/obric/widget/host/WidgetPerfReporter;Lcom/obric/widget/host/runtime/WidgetRenderStateStore;)V", "getHostId", "()Ljava/lang/String;", "appContext", "kotlin.jvm.PlatformType", "Landroid/content/Context;", "runtimeClient", "Lcom/obric/widget/host/runtime/WidgetRuntimeClient;", "getRuntimeClient", "()Lcom/obric/widget/host/runtime/WidgetRuntimeClient;", "catalogManager", "Lcom/obric/widget/host/runtime/WidgetCatalogManager;", "rendererEngine", "Lcom/obric/widget/host/runtime/WidgetRendererEngine;", "renderSessionController", "Lcom/obric/widget/host/runtime/WidgetRenderSessionController;", "instanceManager", "Lcom/obric/widget/host/runtime/WidgetInstanceManager;", "getInstanceManager", "()Lcom/obric/widget/host/runtime/WidgetInstanceManager;", "hostViewProvider", "Lcom/obric/widget/host/runtime/WidgetProvider;", "widgetProvider", ExifInterface.GPS_DIRECTION_TRUE, "refreshCatalogSync", "", "getWidgets", "", "Lcom/obric/widget/host/runtime/WidgetDefinitionMetadata;", "appletId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAppletIds", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAppletInfo", "Lcom/obric/widget/host/runtime/WidgetAppletInfo;", "getWidgetInfo", "widgetId", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ensureWidgetAvailable", "Lcom/obric/widget/host/runtime/WidgetAvailability;", "preferredVersion", "", "scene", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)Lcom/obric/widget/host/runtime/WidgetAvailability;", "clearWidgetData", "", "instanceId", "", "dispatchWidgetBind", "messenger", "Landroid/os/Messenger;", "dispatchWidgetUnbind", "registerWidgetMessenger", "unregisterWidgetMessenger", "queryWidgetData", "Lcom/obric/widget/host/runtime/WidgetDataSnapshot;", "updateWidget", "reason", "refreshAffectedByUpdate", "Lcom/obric/widget/host/runtime/WidgetRefreshAffectedResult;", "changedDomains", "sendPayload", "payload", "waitForResult", "createWidget", "Landroid/view/View;", "widget", "(Landroid/content/Context;Lcom/obric/widget/host/runtime/WidgetDefinitionMetadata;Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateWidgetView", "widgetView", "widgetData", "dispatchWidgetThemeChanged", "isNightMode", "dispatchWidgetVisibilityChanged", "isVisible", "dispatchWidgetVisibilityEvent", "timeMillis", "source", "destroyWidgetHost", "sendEventToWidget", "eventName", LynxResourceModule.PARAMS_KEY, "Lcom/google/gson/JsonObject;", "dispatchWidgetDataChanged", "event", "Lcom/obric/widget/host/runtime/WidgetDataChangedEvent;", "dispatchWidgetSystemChanged", "type", "action", "timeZone", "dispatchWidgetForeground", "dispatchWidgetPackageChanged", Constant.APPID, "versionCode", "resourceType", "updateRenderedWidget", "Lcom/obric/widget/host/runtime/WidgetViewUpdateResult;", "renderReason", "logTag", "(Landroid/view/View;Lcom/obric/widget/host/runtime/WidgetDefinitionMetadata;ILjava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createWidgetWithSnapshotPrime", "Lcom/obric/widget/host/runtime/WidgetCreateViewResult;", "(Landroid/content/Context;Lcom/obric/widget/host/runtime/WidgetDefinitionMetadata;ILjava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitPrefetchedPayload", "Lcom/obric/widget/host/runtime/PayloadConsumeResult;", "(Lcom/obric/widget/host/runtime/WidgetDefinitionMetadata;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearPrefetchedPayload", "createRuntimeBindingController", "Lcom/obric/widget/host/runtime/WidgetRuntimeBindingController;", "tag", "createRuntimeBindingSession", "Lcom/obric/widget/host/runtime/WidgetRuntimeBindingSession;", "invalidInstanceId", "createRenderScheduler", "Lcom/obric/widget/host/runtime/WidgetRenderScheduler;", "Companion", "widget-host-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nWidgetRuntimeServices.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WidgetRuntimeServices.kt\ncom/obric/widget/host/runtime/WidgetRuntimeServices\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,425:1\n1#2:426\n*E\n"})
public final class WidgetRuntimeServices {
    public static final Companion Companion = null;
    public static final int INVALID_INSTANCE_ID = -1;
    public static final String REFRESH_REASON_EVENT = "event";
    public static final String REFRESH_REASON_MANUAL = "manual";
    public static final String REFRESH_REASON_ON_ADD = "onAdd";
    public static final String REFRESH_REASON_ON_RESTORE = "onRestore";
    public static final String REFRESH_REASON_PACKAGE_UPDATE = "packageUpdate";
    public static final String REFRESH_REASON_PERIODIC = "periodic";
    public static final String REFRESH_REASON_VISIBILITY_GAIN = "visibilityGain";
    public static final String SCENE_ADD = "add";
    public static final String SCENE_MANUAL = "manual";
    public static final String SCENE_RESTORE = "restore";
    private final Context appContext;
    private final WidgetCatalogManager catalogManager;
    private final String hostId;
    private final WidgetProvider<Object> hostViewProvider;
    private final WidgetInstanceManager instanceManager;
    private final WidgetRenderSessionController renderSessionController;
    private final WidgetRendererEngine rendererEngine;
    private final WidgetRuntimeClient runtimeClient;
    private final CoroutineScope scope;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/obric/widget/host/runtime/WidgetRuntimeServices$Companion;", "", "<init>", "()V", "INVALID_INSTANCE_ID", "", "SCENE_ADD", "", "SCENE_RESTORE", "SCENE_MANUAL", "REFRESH_REASON_ON_ADD", "REFRESH_REASON_ON_RESTORE", "REFRESH_REASON_EVENT", "REFRESH_REASON_VISIBILITY_GAIN", "REFRESH_REASON_MANUAL", "REFRESH_REASON_PERIODIC", "REFRESH_REASON_PACKAGE_UPDATE", "widget-host-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public WidgetRuntimeServices(Context r17, String r18, CoroutineScope r19, WidgetPerfReporter r20, WidgetRenderStateStore r21) {
        Intrinsics.checkNotNullParameter(r17, "context");
        Intrinsics.checkNotNullParameter(r18, "hostId");
        Intrinsics.checkNotNullParameter(r19, "scope");
        Intrinsics.checkNotNullParameter(r20, "perfReporter");
        Intrinsics.checkNotNullParameter(r21, "renderStateStore");
        this.hostId = r18;
        this.scope = r19;
        Context r12 = r17.getApplicationContext();
        this.appContext = r12;
        Uri r5 = null;
        WidgetRuntimeClient r13 = new WidgetRuntimeClient(r12, r18, r20, r5, 8, null);
        this.runtimeClient = r13;
        WidgetCatalogManager r10 = new WidgetCatalogManager(r12, r18, r19, r20, r13);
        r10.init();
        this.catalogManager = r10;
        String r11 = null;
        WidgetRendererEngine r14 = new WidgetRendererEngine(r13, r18, r20, r11, 8, null);
        this.rendererEngine = r14;
        this.renderSessionController = new WidgetRenderSessionController(r13, r14, r18, r20, null, null, 48, null);
        int r15 = 4;
        Function0 r16 = null;
        this.instanceManager = new WidgetInstanceManager(r18, r21, r16, r15, null);
        this.hostViewProvider = new WidgetProvider(r18);
    }

    public static /* synthetic */ boolean clearWidgetData$default(WidgetRuntimeServices r5, int r10, String r11, String r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L9;
        r12 = null;
    L9:
        return r5.clearWidgetData(r10, r11, r12);
    }

    public static /* synthetic */ WidgetRuntimeBindingSession createRuntimeBindingSession$default(WidgetRuntimeServices r5, int r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r10 = -1;
    L6:
        return r5.createRuntimeBindingSession(r10);
    }

    public static /* synthetic */ Object createWidget$default(WidgetRuntimeServices r5, Context r10, WidgetDefinitionMetadata r11, Integer r12, Continuation r13, int r14, Object r15) {
        if ((r14 & 4) == 0) goto L6;
        r12 = null;
    L6:
        return r5.createWidget(r10, r11, r12, r13);
    }

    public static /* synthetic */ boolean dispatchWidgetBind$default(WidgetRuntimeServices r5, String r10, String r11, int r12, Messenger r13, int r14, Object r15) {
        if ((r14 & 8) == 0) goto L6;
        r13 = null;
    L6:
        return r5.dispatchWidgetBind(r10, r11, r12, r13);
    }

    public static /* synthetic */ WidgetAvailability ensureWidgetAvailable$default(WidgetRuntimeServices r5, String r10, String r11, Long r12, String r13, int r14, Object r15) {
        if ((r14 & 4) == 0) goto L6;
        r12 = null;
    L6:
        if ((r14 & 8) == 0) goto L9;
        r13 = "manual";
    L9:
        return r5.ensureWidgetAvailable(r10, r11, r12, r13);
    }

    public static /* synthetic */ WidgetRefreshAffectedResult refreshAffectedByUpdate$default(WidgetRuntimeServices r5, String r10, List r11, String r12, int r13, Object r14) {
        if ((r13 & 4) == 0) goto L6;
        r12 = null;
    L6:
        return r5.refreshAffectedByUpdate(r10, r11, r12);
    }

    public static /* synthetic */ String sendPayload$default(WidgetRuntimeServices r10, String r11, String r12, int r13, String r14, boolean r15, int r16, Object r17) {
        if ((r16 & 16) == 0) goto L6;
        r15 = false;
    L6:
        return r10.sendPayload(r11, r12, r13, r14, r15);
    }

    public static /* synthetic */ boolean unregisterWidgetMessenger$default(WidgetRuntimeServices r5, int r10, String r11, String r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L9;
        r12 = null;
    L9:
        return r5.unregisterWidgetMessenger(r10, r11, r12);
    }

    public static /* synthetic */ String updateWidget$default(WidgetRuntimeServices r5, String r10, String r11, int r12, String r13, int r14, Object r15) {
        if ((r14 & 8) == 0) goto L6;
        r13 = null;
    L6:
        return r5.updateWidget(r10, r11, r12, r13);
    }

    public final Object awaitPrefetchedPayload(WidgetDefinitionMetadata r5, int r10, Continuation<? super PayloadConsumeResult> r11) {
        return this.renderSessionController.awaitPrefetchedPayload(r5, r10, r11);
    }

    public final void clearPrefetchedPayload(WidgetDefinitionMetadata r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "widget");
        this.renderSessionController.clearPrefetchedPayload(r5, r10);
    }

    public final boolean clearWidgetData(int r5, String r10, String r11) {
        return this.runtimeClient.clearWidgetData(r5, r10, r11);
    }

    public final WidgetRenderScheduler createRenderScheduler() {
        return new WidgetRenderScheduler();
    }

    public final WidgetRuntimeBindingController createRuntimeBindingController(CoroutineScope r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "scope");
        Intrinsics.checkNotNullParameter(r10, "tag");
        return new WidgetRuntimeBindingController(this.runtimeClient, r5, r10);
    }

    public final WidgetRuntimeBindingSession createRuntimeBindingSession(int r5) {
        return new WidgetRuntimeBindingSession(r5);
    }

    public final Object createWidget(Context r5, WidgetDefinitionMetadata r10, Integer r11, Continuation<? super View> r12) {
        return this.renderSessionController.createWidget(r5, r10, r11, r12);
    }

    public final Object createWidgetWithSnapshotPrime(Context r10, WidgetDefinitionMetadata r11, int r12, String r13, String r14, Continuation<? super WidgetCreateViewResult> r15) {
        return this.renderSessionController.createWidgetWithSnapshotPrime(r10, r11, r12, r13, r14, r15);
    }

    public final boolean destroyWidgetHost(View r5) {
        return this.renderSessionController.destroyWidgetHost(r5);
    }

    public final boolean dispatchWidgetBind(String r5, String r10, int r11, Messenger r12) {
        Intrinsics.checkNotNullParameter(r5, "appletId");
        Intrinsics.checkNotNullParameter(r10, "widgetId");
        return this.runtimeClient.dispatchWidgetBind(r5, r10, r11, r12);
    }

    public final boolean dispatchWidgetDataChanged(View r5, WidgetDataChangedEvent r10) {
        Intrinsics.checkNotNullParameter(r10, "event");
        return this.renderSessionController.dispatchWidgetDataChanged(r5, r10);
    }

    public final boolean dispatchWidgetForeground(View r10, String r11, String r12, int r13, long r14, String r16) {
        Intrinsics.checkNotNullParameter(r16, "source");
        return this.renderSessionController.dispatchWidgetForeground(r10, r11, r12, r13, r14, r16);
    }

    public final boolean dispatchWidgetPackageChanged(View r11, String r12, String r13, int r14, String r15, long r16, String r18) {
        Intrinsics.checkNotNullParameter(r15, Constant.APPID);
        return this.renderSessionController.dispatchWidgetPackageChanged(r11, r12, r13, r14, r15, r16, r18);
    }

    public final boolean dispatchWidgetSystemChanged(View r12, String r13, String r14, int r15, String r16, String r17, long r18, String r20) {
        Intrinsics.checkNotNullParameter(r16, "type");
        return this.renderSessionController.dispatchWidgetSystemChanged(r12, r13, r14, r15, r16, r17, r18, r20);
    }

    public final boolean dispatchWidgetThemeChanged(View r5, boolean r10) {
        return this.renderSessionController.dispatchWidgetThemeChanged(r5, r10);
    }

    public final boolean dispatchWidgetUnbind(String r5, String r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "appletId");
        Intrinsics.checkNotNullParameter(r10, "widgetId");
        return this.runtimeClient.dispatchWidgetUnbind(r5, r10, r11);
    }

    public final boolean dispatchWidgetVisibilityChanged(View r5, boolean r10) {
        return this.renderSessionController.dispatchWidgetVisibilityChanged(r5, r10);
    }

    public final boolean dispatchWidgetVisibilityEvent(View r10, WidgetDefinitionMetadata r11, int r12, boolean r13, long r14, String r16) {
        Intrinsics.checkNotNullParameter(r11, "widget");
        Intrinsics.checkNotNullParameter(r16, "source");
        return this.renderSessionController.dispatchWidgetVisibilityEvent(r10, r11, r12, r13, r14, r16);
    }

    public final WidgetAvailability ensureWidgetAvailable(String r5, String r10, Long r11, String r12) {
        Intrinsics.checkNotNullParameter(r5, "appletId");
        Intrinsics.checkNotNullParameter(r10, "widgetId");
        Intrinsics.checkNotNullParameter(r12, "scene");
        return this.runtimeClient.ensureWidgetAvailable(r5, r10, r11, r12);
    }

    public final Object getAppletIds(Continuation<? super List<String>> r5) {
        return this.catalogManager.getAppletIds(r5);
    }

    public final Object getAppletInfo(String r5, Continuation<? super WidgetAppletInfo> r10) {
        return this.catalogManager.getAppletInfo(r5, r10);
    }

    public final String getHostId() {
        return this.hostId;
    }

    public final WidgetInstanceManager getInstanceManager() {
        return this.instanceManager;
    }

    public final WidgetRuntimeClient getRuntimeClient() {
        return this.runtimeClient;
    }

    public final Object getWidgetInfo(String r5, String r10, Continuation<? super WidgetDefinitionMetadata> r11) {
        return this.catalogManager.getWidgetInfo(r5, r10, r11);
    }

    public final Object getWidgets(String r5, Continuation<? super List<WidgetDefinitionMetadata>> r10) {
        return this.catalogManager.getWidgets(r5, r10);
    }

    public final WidgetDataSnapshot queryWidgetData(String r5, String r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "appletId");
        Intrinsics.checkNotNullParameter(r10, "widgetId");
        return this.runtimeClient.queryWidgetData(r5, r10, r11);
    }

    public final WidgetRefreshAffectedResult refreshAffectedByUpdate(String r5, List<String> r10, String r11) {
        Intrinsics.checkNotNullParameter(r5, "appletId");
        Intrinsics.checkNotNullParameter(r10, "changedDomains");
        return this.runtimeClient.refreshAffectedByUpdate(r5, r10, r11);
    }

    public final void refreshCatalogSync() {
        this.catalogManager.refreshCatalogSync();
    }

    public final boolean registerWidgetMessenger(String r5, String r10, int r11, Messenger r12) {
        Intrinsics.checkNotNullParameter(r5, "appletId");
        Intrinsics.checkNotNullParameter(r10, "widgetId");
        Intrinsics.checkNotNullParameter(r12, "messenger");
        return this.runtimeClient.registerWidgetMessenger(r5, r10, r11, r12);
    }

    public final boolean sendEventToWidget(View r5, String r10, JsonObject r11) {
        Intrinsics.checkNotNullParameter(r10, "eventName");
        Intrinsics.checkNotNullParameter(r11, LynxResourceModule.PARAMS_KEY);
        return this.renderSessionController.sendEventToWidget(r5, r10, r11);
    }

    public final String sendPayload(String r10, String r11, int r12, String r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r10, "appletId");
        Intrinsics.checkNotNullParameter(r11, "widgetId");
        return this.runtimeClient.sendPayload(r10, r11, r12, r13, r14);
    }

    public final boolean unregisterWidgetMessenger(int r5, String r10, String r11) {
        return this.runtimeClient.unregisterWidgetMessenger(r5, r10, r11);
    }

    public final Object updateRenderedWidget(View r10, WidgetDefinitionMetadata r11, int r12, String r13, String r14, Continuation<? super WidgetViewUpdateResult> r15) {
        return this.renderSessionController.updateRenderedWidget(r10, r11, r12, r13, r14, r15);
    }

    public final String updateWidget(String r5, String r10, int r11, String r12) {
        Intrinsics.checkNotNullParameter(r5, "appletId");
        Intrinsics.checkNotNullParameter(r10, "widgetId");
        return this.runtimeClient.updateWidget(r5, r10, r11, r12);
    }

    public final boolean updateWidgetView(View r5, WidgetDefinitionMetadata r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "widget");
        return this.renderSessionController.updateWidgetView(r5, r10, r11);
    }

    public final <T> WidgetProvider<T> widgetProvider() {
        WidgetProvider<T> r5 = (WidgetProvider<T>) this.hostViewProvider;
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.obric.widget.host.runtime.WidgetProvider<T of com.obric.widget.host.runtime.WidgetRuntimeServices.widgetProvider>");
        return r5;
    }

    public /* synthetic */ WidgetRuntimeServices(Context r10, String r11, CoroutineScope r12, WidgetPerfReporter r13, WidgetRenderStateStore r14, int r15, DefaultConstructorMarker r16) {
        if ((r15 & 8) == 0) goto L5;
        r13 = WidgetPerfReporter.Companion.getNO_OP();
    L5:
        WidgetPerfReporter r5 = r13;
        if ((r15 & 16) == 0) goto L8;
        r14 = new SharedPreferencesWidgetRenderStateStore(r10.getApplicationContext(), null, 2, null);
    L8:
        this(r10, r11, r12, r5, r14);
    }
}
