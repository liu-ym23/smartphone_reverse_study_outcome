package com.obric.widget.host.runtime;

import android.content.Context;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import cn.nubia.neopush.commons.Constant;
import com.bytedance.ai.api.model.view.WidgetEvent;
import com.google.gson.JsonObject;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.widget.host.WidgetInstanceKey;
import com.obric.widget.host.WidgetPerfEvent;
import com.obric.widget.host.WidgetPerfReporter;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.e2;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.j0;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.r;
import kotlinx.coroutines.s;
import kotlinx.coroutines.z;
import w0.m;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 |2\u00020\u0001:\u0002}|BA\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0015\u0010\u0016J+\u0010\u0018\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0018\u0010\u0019J3\u0010\u001d\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u001a\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ2\u0010\"\u001a\u00020!2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010 \u001a\u00020\u0006H\u0086@¢\u0006\u0004\b\"\u0010#J2\u0010%\u001a\u00020$2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010 \u001a\u00020\u0006H\u0086@¢\u0006\u0004\b%\u0010#J<\u0010)\u001a\u00020(2\b\u0010'\u001a\u0004\u0018\u00010&2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010 \u001a\u00020\u0006H\u0086@¢\u0006\u0004\b)\u0010*J:\u0010.\u001a\u00020-2\u0006\u0010,\u001a\u00020+2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010 \u001a\u00020\u0006H\u0086@¢\u0006\u0004\b.\u0010/J \u00101\u001a\u0002002\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0086@¢\u0006\u0004\b1\u00102J\u001d\u00104\u001a\u0002032\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b4\u00105J,\u00106\u001a\u00020&2\u0006\u0010,\u001a\u00020+2\u0006\u0010\u0011\u001a\u00020\u00102\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0086@¢\u0006\u0004\b6\u00107J)\u00109\u001a\u00020\u001b2\b\u0010'\u001a\u0004\u0018\u00010&2\u0006\u0010\u0011\u001a\u00020\u00102\b\u00108\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b9\u0010:J\u001f\u0010<\u001a\u00020\u001b2\b\u0010'\u001a\u0004\u0018\u00010&2\u0006\u0010;\u001a\u00020\u001b¢\u0006\u0004\b<\u0010=J\u001f\u0010?\u001a\u00020\u001b2\b\u0010'\u001a\u0004\u0018\u00010&2\u0006\u0010>\u001a\u00020\u001b¢\u0006\u0004\b?\u0010=J?\u0010C\u001a\u00020\u001b2\b\u0010'\u001a\u0004\u0018\u00010&2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010>\u001a\u00020\u001b2\u0006\u0010A\u001a\u00020@2\u0006\u0010B\u001a\u00020\u0006¢\u0006\u0004\bC\u0010DJ\u0017\u0010E\u001a\u00020\u001b2\b\u0010'\u001a\u0004\u0018\u00010&¢\u0006\u0004\bE\u0010FJ'\u0010J\u001a\u00020\u001b2\b\u0010'\u001a\u0004\u0018\u00010&2\u0006\u0010G\u001a\u00020\u00062\u0006\u0010I\u001a\u00020H¢\u0006\u0004\bJ\u0010KJ\u001f\u0010N\u001a\u00020\u001b2\b\u0010'\u001a\u0004\u0018\u00010&2\u0006\u0010M\u001a\u00020L¢\u0006\u0004\bN\u0010OJW\u0010U\u001a\u00020\u001b2\b\u0010'\u001a\u0004\u0018\u00010&2\b\u0010P\u001a\u0004\u0018\u00010\u00062\b\u0010Q\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010R\u001a\u00020\u00062\b\u0010S\u001a\u0004\u0018\u00010\u00062\u0006\u0010A\u001a\u00020@2\b\u0010T\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\bU\u0010VJC\u0010W\u001a\u00020\u001b2\b\u0010'\u001a\u0004\u0018\u00010&2\b\u0010P\u001a\u0004\u0018\u00010\u00062\b\u0010Q\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010A\u001a\u00020@2\u0006\u0010B\u001a\u00020\u0006¢\u0006\u0004\bW\u0010XJM\u0010\\\u001a\u00020\u001b2\b\u0010'\u001a\u0004\u0018\u00010&2\b\u0010P\u001a\u0004\u0018\u00010\u00062\b\u0010Q\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010Y\u001a\u00020\u00062\u0006\u0010Z\u001a\u00020@2\b\u0010[\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\\\u0010]J#\u0010a\u001a\u00020\u001b2\b\u0010^\u001a\u0004\u0018\u00010\u00062\b\u0010`\u001a\u0004\u0018\u00010_H\u0002¢\u0006\u0004\ba\u0010bJ\u0015\u0010c\u001a\u00020\u001b*\u0004\u0018\u00010&H\u0002¢\u0006\u0004\bc\u0010FJ@\u0010f\u001a\u00020\u001b2\f\u0010e\u001a\b\u0012\u0004\u0012\u00020\u00060d2\u0006\u0010 \u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u001f\u001a\u00020\u0006H\u0082@¢\u0006\u0004\bf\u0010gJ)\u0010j\u001a\u00020\u001b2\b\u0010'\u001a\u0004\u0018\u00010&2\u0006\u0010h\u001a\u00020\u00062\u0006\u0010i\u001a\u00020HH\u0002¢\u0006\u0004\bj\u0010KJ?\u0010n\u001a\u0002032\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010k\u001a\u00020-2\u0006\u0010l\u001a\u00020@2\u0006\u0010m\u001a\u00020@H\u0002¢\u0006\u0004\bn\u0010oJ7\u0010q\u001a\u0002032\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010k\u001a\u00020(2\u0006\u0010p\u001a\u00020@H\u0002¢\u0006\u0004\bq\u0010rJ\u001b\u0010t\u001a\u00020s*\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\bt\u0010uR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010vR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010wR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010xR\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010yR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010zR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010{¨\u0006~"}, d2 = {"Lcom/obric/widget/host/runtime/WidgetRenderSessionController;", "", "Lcom/obric/widget/host/runtime/WidgetRuntimeClient;", "runtimeClient", "Lcom/obric/widget/host/runtime/WidgetRendererEngine;", "rendererEngine", "", "hostId", "Lcom/obric/widget/host/WidgetPerfReporter;", "perfReporter", "Lcom/obric/widget/host/runtime/WidgetPayloadPrefetchCoordinator;", "payloadCoordinator", "Lkotlinx/coroutines/CoroutineScope;", "prefetchScope", "<init>", "(Lcom/obric/widget/host/runtime/WidgetRuntimeClient;Lcom/obric/widget/host/runtime/WidgetRendererEngine;Ljava/lang/String;Lcom/obric/widget/host/WidgetPerfReporter;Lcom/obric/widget/host/runtime/WidgetPayloadPrefetchCoordinator;Lkotlinx/coroutines/CoroutineScope;)V", "Lcom/obric/widget/host/runtime/WidgetDefinitionMetadata;", "widget", "", "instanceId", "Lcom/obric/widget/host/runtime/WidgetDataSnapshot;", "queryWidgetData", "(Lcom/obric/widget/host/runtime/WidgetDefinitionMetadata;I)Lcom/obric/widget/host/runtime/WidgetDataSnapshot;", "reason", "updateWidget", "(Lcom/obric/widget/host/runtime/WidgetDefinitionMetadata;ILjava/lang/String;)Ljava/lang/String;", "payload", "", "waitForResult", "sendPayload", "(Lcom/obric/widget/host/runtime/WidgetDefinitionMetadata;ILjava/lang/String;Z)Ljava/lang/String;", "renderReason", "logTag", "Lcom/obric/widget/host/runtime/WidgetSnapshotQueryResult;", "queryWidgetSnapshot", "(Lcom/obric/widget/host/runtime/WidgetDefinitionMetadata;ILjava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/obric/widget/host/runtime/WidgetRemoteUpdateResult;", "requestLatestWidgetPayload", "Landroid/view/View;", "widgetView", "Lcom/obric/widget/host/runtime/WidgetViewUpdateResult;", "updateRenderedWidget", "(Landroid/view/View;Lcom/obric/widget/host/runtime/WidgetDefinitionMetadata;ILjava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroid/content/Context;", "context", "Lcom/obric/widget/host/runtime/WidgetCreateViewResult;", "createWidgetWithSnapshotPrime", "(Landroid/content/Context;Lcom/obric/widget/host/runtime/WidgetDefinitionMetadata;ILjava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/obric/widget/host/runtime/PayloadConsumeResult;", "awaitPrefetchedPayload", "(Lcom/obric/widget/host/runtime/WidgetDefinitionMetadata;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "clearPrefetchedPayload", "(Lcom/obric/widget/host/runtime/WidgetDefinitionMetadata;I)V", "createWidget", "(Landroid/content/Context;Lcom/obric/widget/host/runtime/WidgetDefinitionMetadata;Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "widgetData", "updateWidgetView", "(Landroid/view/View;Lcom/obric/widget/host/runtime/WidgetDefinitionMetadata;Ljava/lang/String;)Z", "isNightMode", "dispatchWidgetThemeChanged", "(Landroid/view/View;Z)Z", "isVisible", "dispatchWidgetVisibilityChanged", "", "timeMillis", "source", "dispatchWidgetVisibilityEvent", "(Landroid/view/View;Lcom/obric/widget/host/runtime/WidgetDefinitionMetadata;IZJLjava/lang/String;)Z", "destroyWidgetHost", "(Landroid/view/View;)Z", "eventName", "Lcom/google/gson/JsonObject;", LynxResourceModule.PARAMS_KEY, "sendEventToWidget", "(Landroid/view/View;Ljava/lang/String;Lcom/google/gson/JsonObject;)Z", "Lcom/obric/widget/host/runtime/WidgetDataChangedEvent;", "event", "dispatchWidgetDataChanged", "(Landroid/view/View;Lcom/obric/widget/host/runtime/WidgetDataChangedEvent;)Z", "appletId", "widgetId", "type", "action", "timeZone", "dispatchWidgetSystemChanged", "(Landroid/view/View;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;JLjava/lang/String;)Z", "dispatchWidgetForeground", "(Landroid/view/View;Ljava/lang/String;Ljava/lang/String;IJLjava/lang/String;)Z", Constant.APPID, "versionCode", "resourceType", "dispatchWidgetPackageChanged", "(Landroid/view/View;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;JLjava/lang/String;)Z", "initialPayload", "Lcom/obric/widget/host/runtime/PrefetchedWidgetPayload;", "prefetched", "shouldConsumePayload", "(Ljava/lang/String;Lcom/obric/widget/host/runtime/PrefetchedWidgetPayload;)Z", "isNullOrBlankLike", "Lkotlinx/coroutines/r;", "ready", "awaitPageReady", "(Lkotlinx/coroutines/r;Ljava/lang/String;Lcom/obric/widget/host/runtime/WidgetDefinitionMetadata;Ljava/lang/Integer;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "eventId", "data", "dispatchRuntimeEvent", "result", "preMainMs", "createWallMs", "reportCreateBreakdown", "(Lcom/obric/widget/host/runtime/WidgetDefinitionMetadata;ILjava/lang/String;Lcom/obric/widget/host/runtime/WidgetCreateViewResult;JJ)V", "refreshWallMs", "reportUpdateBreakdown", "(Lcom/obric/widget/host/runtime/WidgetDefinitionMetadata;ILjava/lang/String;Lcom/obric/widget/host/runtime/WidgetViewUpdateResult;J)V", "Lcom/obric/widget/host/WidgetInstanceKey;", STGroup.DICT_KEY, "(Lcom/obric/widget/host/runtime/WidgetDefinitionMetadata;I)Lcom/obric/widget/host/WidgetInstanceKey;", "Lcom/obric/widget/host/runtime/WidgetRuntimeClient;", "Lcom/obric/widget/host/runtime/WidgetRendererEngine;", "Ljava/lang/String;", "Lcom/obric/widget/host/WidgetPerfReporter;", "Lcom/obric/widget/host/runtime/WidgetPayloadPrefetchCoordinator;", "Lkotlinx/coroutines/CoroutineScope;", "Companion", "WidgetLifeObserver", "widget-host-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nWidgetRenderSessionController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WidgetRenderSessionController.kt\ncom/obric/widget/host/runtime/WidgetRenderSessionController\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,836:1\n1#2:837\n*E\n"})
public final class WidgetRenderSessionController {
    public static final Companion Companion = null;
    private static final String EVENT_NAME_SEND_EVENT = "obric.sendEvent";
    private static final String EVENT_WIDGET_DATA_CHANGED = "obric.widget.dataChanged";
    private static final String EVENT_WIDGET_FOREGROUND = "obric.widget.onForeground";
    private static final String EVENT_WIDGET_ON_HIDE = "obric.widget.onHide";
    private static final String EVENT_WIDGET_ON_SHOW = "obric.widget.onShow";
    private static final String EVENT_WIDGET_PACKAGE_CHANGED = "obric.widget.packageChanged";
    private static final String EVENT_WIDGET_SYSTEM_CHANGED = "obric.widget.systemChanged";
    private static final String PAGE_READY_SOURCE_DESTROY = "destroy";
    private static final String PAGE_READY_SOURCE_ERROR = "pageError";
    private static final String PAGE_READY_SOURCE_FINISH = "pageFinish";
    private static final long PAGE_READY_TIMEOUT_MS = 5000;
    private static final String TAG = "OWidgetRenderSession";
    private static final String UNKNOWN_HOST_ID = "unknown";
    private final String hostId;
    private final WidgetPayloadPrefetchCoordinator payloadCoordinator;
    private final WidgetPerfReporter perfReporter;
    private final CoroutineScope prefetchScope;
    private final WidgetRendererEngine rendererEngine;
    private final WidgetRuntimeClient runtimeClient;

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0017H\u0000¢\u0006\u0002\b\u0018JA\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u0005H\u0000¢\u0006\u0002\b JA\u0010!\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u0005H\u0000¢\u0006\u0002\b\"JK\u0010#\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u00072\b\u0010&\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0002\b'JU\u0010(\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010)\u001a\u00020\u00052\b\u0010*\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001e\u001a\u00020\u00072\b\u0010+\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0002\b,J\u0010\u0010-\u001a\u00020\u00052\u0006\u0010.\u001a\u00020/H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/obric/widget/host/runtime/WidgetRenderSessionController$Companion;", "", "<init>", "()V", "TAG", "", "PAGE_READY_TIMEOUT_MS", "", "PAGE_READY_SOURCE_FINISH", "PAGE_READY_SOURCE_ERROR", "PAGE_READY_SOURCE_DESTROY", "UNKNOWN_HOST_ID", "EVENT_NAME_SEND_EVENT", "EVENT_WIDGET_DATA_CHANGED", "EVENT_WIDGET_SYSTEM_CHANGED", "EVENT_WIDGET_ON_SHOW", "EVENT_WIDGET_ON_HIDE", "EVENT_WIDGET_FOREGROUND", "EVENT_WIDGET_PACKAGE_CHANGED", "buildDataChangedEventPayload", "Lcom/google/gson/JsonObject;", "hostId", "event", "Lcom/obric/widget/host/runtime/WidgetDataChangedEvent;", "buildDataChangedEventPayload$widget_host_sdk_release", "buildForegroundEventPayload", "appletId", "widgetId", "instanceId", "", "timeMillis", "source", "buildForegroundEventPayload$widget_host_sdk_release", "buildVisibilityEventPayload", "buildVisibilityEventPayload$widget_host_sdk_release", "buildPackageChangedEventPayload", Constant.APPID, "versionCode", "resourceType", "buildPackageChangedEventPayload$widget_host_sdk_release", "buildSystemChangedEventPayload", "type", "action", "timeZone", "buildSystemChangedEventPayload$widget_host_sdk_release", "visibilityEventId", "isVisible", "", "widget-host-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nWidgetRenderSessionController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WidgetRenderSessionController.kt\ncom/obric/widget/host/runtime/WidgetRenderSessionController$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,836:1\n1#2:837\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public static final /* synthetic */ String access$visibilityEventId(Companion r5, boolean r10) {
            return r5.visibilityEventId(r10);
        }

        private final String visibilityEventId(boolean r5) {
            if (r5 == false) goto L4;
            return WidgetRenderSessionController.EVENT_WIDGET_ON_SHOW;
        L4:
            return WidgetRenderSessionController.EVENT_WIDGET_ON_HIDE;
        }

        public final JsonObject buildDataChangedEventPayload$widget_host_sdk_release(String r5, WidgetDataChangedEvent r10) {
            Intrinsics.checkNotNullParameter(r5, "hostId");
            Intrinsics.checkNotNullParameter(r10, "event");
            JsonObject r11 = new JsonObject();
            r11.addProperty("appletId", r10.getAppletId());
            r11.addProperty("widgetId", r10.getWidgetId());
            r11.addProperty("instanceId", Integer.valueOf(r10.getInstanceId()));
            String r12 = r10.getHostId();
            if (StringsKt.isBlank(r12) == true) goto L6;
            r5 = r12;
        L6:
            r11.addProperty("hostId", r5);
            r11.addProperty("widgetData", r10.getWidgetData());
            r11.addProperty("reason", r10.getReason());
            Long r13 = r10.getDataVersion();
            if (r13 == null) goto L9;
            r11.addProperty("dataVersion", Long.valueOf(r13.longValue()));
        L9:
            Long r14 = r10.getUpdatedAt();
            if (r14 == null) goto L12;
            r11.addProperty("updatedAt", Long.valueOf(r14.longValue()));
        L12:
            String r15 = r10.getState();
            if (r15 == null) goto L15;
            r11.addProperty("state", r15);
        L15:
            return r11;
        }

        public final JsonObject buildForegroundEventPayload$widget_host_sdk_release(String r5, String r10, String r11, int r12, long r13, String r14) {
            Intrinsics.checkNotNullParameter(r5, "hostId");
            Intrinsics.checkNotNullParameter(r14, "source");
            JsonObject r15 = new JsonObject();
            r15.addProperty("timeMillis", Long.valueOf(r13));
            r15.addProperty("source", r14);
            r15.addProperty("appletId", r10);
            r15.addProperty("widgetId", r11);
            r15.addProperty("instanceId", Integer.valueOf(r12));
            r15.addProperty("hostId", r5);
            return r15;
        }

        public final JsonObject buildPackageChangedEventPayload$widget_host_sdk_release(String r5, String r10, String r11, int r12, String r13, long r14, String r15) {
            Intrinsics.checkNotNullParameter(r5, "hostId");
            Intrinsics.checkNotNullParameter(r13, Constant.APPID);
            JsonObject r16 = new JsonObject();
            r16.addProperty("appletId", r10);
            r16.addProperty("widgetId", r11);
            r16.addProperty("instanceId", Integer.valueOf(r12));
            r16.addProperty("hostId", r5);
            r16.addProperty(Constant.APPID, r13);
            r16.addProperty("versionCode", Long.valueOf(r14));
            r16.addProperty("resourceType", r15);
            return r16;
        }

        public final JsonObject buildSystemChangedEventPayload$widget_host_sdk_release(String r5, String r10, String r11, int r12, String r13, String r14, long r15, String r16) {
            Intrinsics.checkNotNullParameter(r5, "hostId");
            Intrinsics.checkNotNullParameter(r13, "type");
            JsonObject r17 = new JsonObject();
            r17.addProperty("appletId", r10);
            r17.addProperty("widgetId", r11);
            r17.addProperty("instanceId", Integer.valueOf(r12));
            r17.addProperty("hostId", r5);
            r17.addProperty("type", r13);
            r17.addProperty("action", r14);
            r17.addProperty("timeMillis", Long.valueOf(r15));
            r17.addProperty("timeZone", r16);
            return r17;
        }

        public final JsonObject buildVisibilityEventPayload$widget_host_sdk_release(String r5, String r10, String r11, int r12, long r13, String r14) {
            Intrinsics.checkNotNullParameter(r5, "hostId");
            Intrinsics.checkNotNullParameter(r14, "source");
            JsonObject r15 = new JsonObject();
            r15.addProperty("timeMillis", Long.valueOf(r13));
            r15.addProperty("source", r14);
            r15.addProperty("appletId", r10);
            r15.addProperty("widgetId", r11);
            r15.addProperty("instanceId", Integer.valueOf(r12));
            r15.addProperty("hostId", r5);
            return r15;
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\tJ\u000f\u0010\u000b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\tJ\u000f\u0010\f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\f\u0010\tJ\u000f\u0010\r\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\r\u0010\tJ\u0017\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/obric/widget/host/runtime/WidgetRenderSessionController$WidgetLifeObserver;", "Lw0/m;", "Lkotlinx/coroutines/r;", "", "ready", "<init>", "(Lkotlinx/coroutines/r;)V", "", "onStart", "()V", "onPageStart", "onPageFinish", "onPageError", "onDestroy", "Lcom/bytedance/ai/api/model/view/WidgetEvent;", "event", "onEvent", "(Lcom/bytedance/ai/api/model/view/WidgetEvent;)V", "Lkotlinx/coroutines/r;", "widget-host-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class WidgetLifeObserver implements m {
        private final r ready;

        public WidgetLifeObserver(r r5) {
            Intrinsics.checkNotNullParameter(r5, "ready");
            this.ready = r5;
        }

        @Override // w0.m
        public void onDestroy() {
            ((s) this.ready).N(WidgetRenderSessionController.PAGE_READY_SOURCE_DESTROY);
        }

        @Override // w0.m
        public void onEvent(WidgetEvent r5) {
            Intrinsics.checkNotNullParameter(r5, "event");
        }

        @Override // w0.m
        public void onPageError() {
            ((s) this.ready).N(WidgetRenderSessionController.PAGE_READY_SOURCE_ERROR);
        }

        @Override // w0.m
        public void onPageFinish() {
            ((s) this.ready).N(WidgetRenderSessionController.PAGE_READY_SOURCE_FINISH);
        }

        @Override // w0.m
        public void onPageStart() {
        }

        @Override // w0.m
        public void onStart() {
        }
    }

    /* JADX INFO: renamed from: com.obric.widget.host.runtime.WidgetRenderSessionController$awaitPageReady$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.widget.host.runtime.WidgetRenderSessionController", f = "WidgetRenderSessionController.kt", i = {0, 0, 0, 0}, l = {471}, m = "awaitPageReady", n = {"logTag", "widget", "instanceId", "renderReason"}, s = {"L$0", "L$1", "L$2", "L$3"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ WidgetRenderSessionController this$0;

        public AnonymousClass1(WidgetRenderSessionController r5, Continuation<? super AnonymousClass1> r10) {
            this.this$0 = r5;
            super(r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            this.result = r10;
            this.label |= Integer.MIN_VALUE;
            return WidgetRenderSessionController.access$awaitPageReady(this.this$0, null, null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.obric.widget.host.runtime.WidgetRenderSessionController$createWidget$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.widget.host.runtime.WidgetRenderSessionController", f = "WidgetRenderSessionController.kt", i = {0, 0, 0, 0, 1}, l = {448, 454}, m = "createWidget", n = {"this", "widget", "instanceId", "pageReady", "result"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0"})
    public static final class C02011 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ WidgetRenderSessionController this$0;

        public C02011(WidgetRenderSessionController r5, Continuation<? super C02011> r10) {
            this.this$0 = r5;
            super(r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            this.result = r5;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.createWidget(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.obric.widget.host.runtime.WidgetRenderSessionController$createWidgetWithSnapshotPrime$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.widget.host.runtime.WidgetRenderSessionController", f = "WidgetRenderSessionController.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6}, l = {256, 289, 309, 336, 352, 360, 367}, m = "createWidgetWithSnapshotPrime", n = {"this", "context", "widget", "renderReason", "logTag", "pageReady", "widgetLifeObserver", "instanceId", "createWallStartElapsed", "this", "context", "widget", "renderReason", "logTag", "pageReady", "widgetLifeObserver", "snapshotResult", "payloadKey", "initialPayload", "initialPayloadSource", "instanceId", "createWallStartElapsed", "this", "widget", "renderReason", "logTag", "pageReady", "snapshotResult", "payloadKey", "initialPayload", "prefetchDeferred", "instanceId", "createWallStartElapsed", "preMainMs", "createViewStartElapsed", "this", "widget", "renderReason", "logTag", "snapshotResult", "payloadKey", "initialPayload", "prefetchDeferred", "rendererCreateResult", "instanceId", "createWallStartElapsed", "preMainMs", "createViewStartElapsed", "this", "widget", "renderReason", "snapshotResult", "payloadKey", "initialPayload", "prefetchDeferred", "rendererCreateResult", "instanceId", "createWallStartElapsed", "preMainMs", "createViewStartElapsed", "pageReadySucceeded", "this", "widget", "renderReason", "snapshotResult", "payloadKey", "initialPayload", "prefetchDeferred", "rendererCreateResult", "effectiveView", "instanceId", "createWallStartElapsed", "preMainMs", "createViewStartElapsed", "pageReadySucceeded", "inlineConsumeApplied", "this", "widget", "renderReason", "snapshotResult", "payloadKey", "prefetchDeferred", "rendererCreateResult", "effectiveView", "instanceId", "createWallStartElapsed", "preMainMs", "createViewStartElapsed", "pageReadySucceeded"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "J$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "I$0", "J$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "I$0", "J$0", "J$1", "J$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "I$0", "J$0", "J$1", "J$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "I$0", "J$0", "J$1", "J$2", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "I$0", "J$0", "J$1", "J$2", "I$1", "I$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "I$0", "J$0", "J$1", "J$2", "I$1"})
    public static final class C02021 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        long J$0;
        long J$1;
        long J$2;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ WidgetRenderSessionController this$0;

        public C02021(WidgetRenderSessionController r5, Continuation<? super C02021> r10) {
            this.this$0 = r5;
            super(r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            this.result = r10;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.createWidgetWithSnapshotPrime(null, null, 0, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.obric.widget.host.runtime.WidgetRenderSessionController$createWidgetWithSnapshotPrime$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.widget.host.runtime.WidgetRenderSessionController$createWidgetWithSnapshotPrime$2", f = "WidgetRenderSessionController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        final /* synthetic */ View $failedView;
        int label;
        final /* synthetic */ WidgetRenderSessionController this$0;

        public AnonymousClass2(WidgetRenderSessionController r5, View r10, Continuation<? super AnonymousClass2> r11) {
            this.this$0 = r5;
            this.$failedView = r10;
            super(2, r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
            return new AnonymousClass2(this.this$0, this.$failedView, r10);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo2invoke(CoroutineScope r5, Continuation<? super Boolean> r10) {
            return invoke2(r5, r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r5);
            return Boxing.boxBoolean(WidgetRenderSessionController.access$getRendererEngine$p(this.this$0).destroyWidgetHost(this.$failedView));
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r5, Continuation<? super Boolean> r10) {
            return ((AnonymousClass2) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.obric.widget.host.runtime.WidgetRenderSessionController$queryWidgetSnapshot$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.widget.host.runtime.WidgetRenderSessionController", f = "WidgetRenderSessionController.kt", i = {0, 0, 0, 0}, l = {114}, m = "queryWidgetSnapshot", n = {"renderReason", "logTag", "instanceId", "queryStartElapsed"}, s = {"L$0", "L$1", "I$0", "J$0"})
    public static final class C02031 extends ContinuationImpl {
        int I$0;
        long J$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ WidgetRenderSessionController this$0;

        public C02031(WidgetRenderSessionController r5, Continuation<? super C02031> r10) {
            this.this$0 = r5;
            super(r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            this.result = r10;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.queryWidgetSnapshot(null, 0, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.obric.widget.host.runtime.WidgetRenderSessionController$requestLatestWidgetPayload$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.widget.host.runtime.WidgetRenderSessionController", f = "WidgetRenderSessionController.kt", i = {0}, l = {153}, m = "requestLatestWidgetPayload", n = {"updateStartElapsed"}, s = {"J$0"})
    public static final class C02041 extends ContinuationImpl {
        long J$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ WidgetRenderSessionController this$0;

        public C02041(WidgetRenderSessionController r5, Continuation<? super C02041> r10) {
            this.this$0 = r5;
            super(r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            this.result = r10;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.requestLatestWidgetPayload(null, 0, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.obric.widget.host.runtime.WidgetRenderSessionController$updateRenderedWidget$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.widget.host.runtime.WidgetRenderSessionController", f = "WidgetRenderSessionController.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1}, l = {183, 213}, m = "updateRenderedWidget", n = {"this", "widgetView", "widget", "renderReason", "logTag", "instanceId", "refreshStartElapsed", "this", "widget", "renderReason", "remoteUpdateResult", "payload", "instanceId", "refreshStartElapsed", "updateStartElapsed"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "J$0", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "J$0", "J$1"})
    public static final class C02051 extends ContinuationImpl {
        int I$0;
        long J$0;
        long J$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ WidgetRenderSessionController this$0;

        public C02051(WidgetRenderSessionController r5, Continuation<? super C02051> r10) {
            this.this$0 = r5;
            super(r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            this.result = r10;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.updateRenderedWidget(null, null, 0, null, null, this);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public WidgetRenderSessionController(WidgetRuntimeClient r5, WidgetRendererEngine r10, String r11, WidgetPerfReporter r12, WidgetPayloadPrefetchCoordinator r13, CoroutineScope r14) {
        Intrinsics.checkNotNullParameter(r5, "runtimeClient");
        Intrinsics.checkNotNullParameter(r10, "rendererEngine");
        Intrinsics.checkNotNullParameter(r11, "hostId");
        Intrinsics.checkNotNullParameter(r12, "perfReporter");
        Intrinsics.checkNotNullParameter(r13, "payloadCoordinator");
        Intrinsics.checkNotNullParameter(r14, "prefetchScope");
        this.runtimeClient = r5;
        this.rendererEngine = r10;
        this.hostId = r11;
        this.perfReporter = r12;
        this.payloadCoordinator = r13;
        this.prefetchScope = r14;
    }

    public static final /* synthetic */ Object access$awaitPageReady(WidgetRenderSessionController r5, r r10, String r11, WidgetDefinitionMetadata r12, Integer r13, String r14, Continuation r15) {
        return r5.awaitPageReady(r10, r11, r12, r13, r14, r15);
    }

    public static final /* synthetic */ WidgetRendererEngine access$getRendererEngine$p(WidgetRenderSessionController r5) {
        return r5.rendererEngine;
    }

    private final Object awaitPageReady(r r10, String r11, WidgetDefinitionMetadata r12, Integer r13, String r14, Continuation<? super Boolean> r15) {
        if ((r15 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r5 = (AnonymousClass1) r15;
        int r16 = r5.label;
        if ((r16 & Integer.MIN_VALUE) == 0) goto L7;
        r5.label = r16 - Integer.MIN_VALUE;
    L8:
        Object r17 = r5.result;
        Object r18 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r19 = r5.label;
        if (r19 == 0) goto L14;
        if (r19 != 1) goto L13;
        r14 = (String) r5.L$3;
        r13 = (Integer) r5.L$2;
        r12 = (WidgetDefinitionMetadata) r5.L$1;
        r11 = (String) r5.L$0;
        ResultKt.throwOnFailure(r17);
    L17:
        String r20 = (String) r17;
        if (r20 != null) goto L22;
        StringBuilder r21 = androidx.constraintlayout.motion.widget.a.y("wait widget first page ready timeout: appletId=", r12.getAppletId(), ", widgetId=", r12.getWidgetId(), ", instance=");
        r21.append(r13);
        r21.append(", reason=");
        r21.append(r14);
        r21.append(", timeoutMs=5000");
        Log.w(r11, r21.toString());
        return Boxing.boxBoolean(false);
    L22:
        if (Intrinsics.areEqual(r20, PAGE_READY_SOURCE_FINISH) == true) goto L26;
        String r22 = r12.getAppletId();
        String r23 = r12.getWidgetId();
        StringBuilder r24 = androidx.constraintlayout.motion.widget.a.y("widget first page is not ready: source=", r20, ", appletId=", r22, ", widgetId=");
        r24.append(r23);
        r24.append(", instance=");
        r24.append(r13);
        r24.append(", reason=");
        r24.append(r14);
        Log.w(r11, r24.toString());
        return Boxing.boxBoolean(false);
    L26:
        return Boxing.boxBoolean(true);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r17);
        WidgetRenderSessionController$awaitPageReady$source$1 r25 = new WidgetRenderSessionController$awaitPageReady$source$1(r10, null);
        r5.L$0 = r11;
        r5.L$1 = r12;
        r5.L$2 = r13;
        r5.L$3 = r14;
        r5.label = 1;
        r17 = e2.b(PAGE_READY_TIMEOUT_MS, r25, r5);
        if (r17 != r18) goto L17;
        return r18;
    L7:
        r5 = new AnonymousClass1(this, r15);
        goto L8
    }

    public static /* synthetic */ Object createWidget$default(WidgetRenderSessionController r5, Context r10, WidgetDefinitionMetadata r11, Integer r12, Continuation r13, int r14, Object r15) {
        if ((r14 & 4) == 0) goto L6;
        r12 = null;
    L6:
        return r5.createWidget(r10, r11, r12, r13);
    }

    public static /* synthetic */ Object createWidgetWithSnapshotPrime$default(WidgetRenderSessionController r10, Context r11, WidgetDefinitionMetadata r12, int r13, String r14, String r15, Continuation r16, int r17, Object r18) {
        if ((r17 & 16) == 0) goto L6;
        r15 = TAG;
    L6:
        return r10.createWidgetWithSnapshotPrime(r11, r12, r13, r14, r15, r16);
    }

    private final boolean dispatchRuntimeEvent(View r5, String r10, JsonObject r11) {
        JsonObject r12 = new JsonObject();
        r12.addProperty("eventId", r10);
        r12.add("data", r11);
        Unit r13 = Unit.INSTANCE;
        return sendEventToWidget(r5, EVENT_NAME_SEND_EVENT, r12);
    }

    private final boolean isNullOrBlankLike(View r5) {
        if (r5 != null) goto L4;
        return true;
    L4:
        return false;
    }

    private final WidgetInstanceKey key(WidgetDefinitionMetadata r5, int r10) {
        return new WidgetInstanceKey(r5.getAppletId(), r5.getWidgetId(), String.valueOf(r10), this.hostId);
    }

    public static /* synthetic */ Object queryWidgetSnapshot$default(WidgetRenderSessionController r10, WidgetDefinitionMetadata r11, int r12, String r13, String r14, Continuation r15, int r16, Object r17) {
        if ((r16 & 8) == 0) goto L6;
        r14 = TAG;
    L6:
        return r10.queryWidgetSnapshot(r11, r12, r13, r14, r15);
    }

    private final void reportCreateBreakdown(WidgetDefinitionMetadata r21, int r22, String r23, WidgetCreateViewResult r24, long r25, long r27) {
        WidgetPerfReporter r5 = this.perfReporter;
        String r10 = this.hostId;
        WidgetInstanceKey r11 = key(r21, r22);
        Pair r12 = TuplesKt.to("appletId", r21.getAppletId());
        Pair r13 = TuplesKt.to("widgetId", r21.getWidgetId());
        Pair r14 = TuplesKt.to("instanceId", Integer.valueOf(r22));
        Pair r15 = TuplesKt.to("reason", r23);
        Pair r16 = TuplesKt.to("createWallMs", Long.valueOf(r27));
        Pair r17 = TuplesKt.to("preMainMs", Long.valueOf(r25));
        Pair r18 = TuplesKt.to("remoteUpdateMs", Long.valueOf(r24.getPrimeUpdateDurationMs()));
        Pair r19 = TuplesKt.to("mainDispatchMs", Long.valueOf(r24.getCreateDurationMs()));
        Pair r110 = TuplesKt.to("createCallMs", Long.valueOf(r24.getCreateDurationMs()));
        Pair r111 = TuplesKt.to("internalQueryMs", Long.valueOf(r24.getSnapshotResult().getQueryDurationMs()));
        Pair r112 = TuplesKt.to("sdkCreateMs", null);
        Pair r113 = TuplesKt.to("applyMs", 0L);
        Pair r114 = TuplesKt.to("primePayloadLength", Integer.valueOf(r24.getPrimePayloadLength()));
        if (r24.getView() == null) goto L5;
        boolean r20 = true;
    L6:
        r5.report(new WidgetPerfEvent("widget_render_create_breakdown", r10, r11, 0, MapsKt.mapOf(new Pair[]{r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112, r113, r114, TuplesKt.to("hasView", Boolean.valueOf(r20))}), 8, null));
        return;
    L5:
        r20 = false;
        goto L6
    }

    private final void reportUpdateBreakdown(WidgetDefinitionMetadata r23, int r24, String r25, WidgetViewUpdateResult r26, long r27) {
        this.perfReporter.report(new WidgetPerfEvent("widget_render_update_breakdown", this.hostId, key(r23, r24), 0, MapsKt.mapOf(new Pair[]{TuplesKt.to("appletId", r23.getAppletId()), TuplesKt.to("widgetId", r23.getWidgetId()), TuplesKt.to("instanceId", Integer.valueOf(r24)), TuplesKt.to("reason", r25), TuplesKt.to("refreshWallMs", Long.valueOf(r27)), TuplesKt.to("remoteUpdateMs", Long.valueOf(r26.getRemoteUpdateDurationMs())), TuplesKt.to("applyMs", Long.valueOf(r26.getViewUpdateDurationMs())), TuplesKt.to("payloadLength", Integer.valueOf(r26.getPayloadLength())), TuplesKt.to("handled", Boolean.valueOf(r26.getHandled())), TuplesKt.to("success", Boolean.valueOf(r26.getSuccess()))}), 8, null));
    }

    public static /* synthetic */ Object requestLatestWidgetPayload$default(WidgetRenderSessionController r10, WidgetDefinitionMetadata r11, int r12, String r13, String r14, Continuation r15, int r16, Object r17) {
        if ((r16 & 8) == 0) goto L6;
        r14 = TAG;
    L6:
        return r10.requestLatestWidgetPayload(r11, r12, r13, r14, r15);
    }

    public static /* synthetic */ String sendPayload$default(WidgetRenderSessionController r5, WidgetDefinitionMetadata r10, int r11, String r12, boolean r13, int r14, Object r15) {
        if ((r14 & 8) == 0) goto L6;
        r13 = false;
    L6:
        return r5.sendPayload(r10, r11, r12, r13);
    }

    private final boolean shouldConsumePayload(String r5, PrefetchedWidgetPayload r10) {
        if (r10 == null) goto L19;
        String r11 = r10.getPayload();
        if (r11 != null) goto L6;
        return false;
    L6:
        if (StringsKt.isBlank(r11) == false) goto L9;
        r11 = null;
    L9:
        if (r11 != null) goto L12;
        return false;
    L12:
        if (r5 != null) goto L14;
    L18:
        return true;
    L14:
        if (StringsKt.isBlank(r5) == true) goto L18;
        return !Intrinsics.areEqual(r11, r5);
    L19:
        return false;
    }

    public static /* synthetic */ Object updateRenderedWidget$default(WidgetRenderSessionController r10, View r11, WidgetDefinitionMetadata r12, int r13, String r14, String r15, Continuation r16, int r17, Object r18) {
        if ((r17 & 16) == 0) goto L6;
        r15 = TAG;
    L6:
        return r10.updateRenderedWidget(r11, r12, r13, r14, r15, r16);
    }

    public static /* synthetic */ String updateWidget$default(WidgetRenderSessionController r5, WidgetDefinitionMetadata r10, int r11, String r12, int r13, Object r14) {
        if ((r13 & 4) == 0) goto L6;
        r12 = null;
    L6:
        return r5.updateWidget(r10, r11, r12);
    }

    public final Object awaitPrefetchedPayload(WidgetDefinitionMetadata r5, int r10, Continuation<? super PayloadConsumeResult> r11) {
        return this.payloadCoordinator.await(new WidgetPayloadCacheKey(this.hostId, r5.getAppletId(), r5.getWidgetId(), r10), r11);
    }

    public final void clearPrefetchedPayload(WidgetDefinitionMetadata r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "widget");
        this.payloadCoordinator.clear(new WidgetPayloadCacheKey(this.hostId, r5.getAppletId(), r5.getWidgetId(), r10));
    }

    public final Object createWidget(Context r10, WidgetDefinitionMetadata r11, Integer r12, Continuation<? super View> r13) {
        if ((r13 instanceof C02011) == false) goto L8;
        C02011 r5 = (C02011) r13;
        int r14 = r5.label;
        if ((r14 & Integer.MIN_VALUE) == 0) goto L8;
        r5.label = r14 - Integer.MIN_VALUE;
    L7:
        C02011 r15 = r5;
        Object r16 = r15.result;
        Object r17 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r18 = r15.label;
        if (r18 == 0) goto L17;
        if (r18 == 1) goto L16;
        if (r18 != 2) goto L15;
        View r19 = (View) r15.L$0;
        ResultKt.throwOnFailure(r16);
        return r19;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        r r20 = (r) r15.L$3;
        Integer r110 = (Integer) r15.L$2;
        WidgetDefinitionMetadata r111 = (WidgetDefinitionMetadata) r15.L$1;
        WidgetRenderSessionController r112 = (WidgetRenderSessionController) r15.L$0;
        ResultKt.throwOnFailure(r16);
        r r21 = r20;
        WidgetRenderSessionController r22 = r112;
        WidgetDefinitionMetadata r23 = r111;
        Integer r24 = r110;
    L21:
        View r25 = (View) r16;
        r15.L$0 = r25;
        r15.L$1 = null;
        r15.L$2 = null;
        r15.L$3 = null;
        r15.label = 2;
        if (r22.awaitPageReady(r21, TAG, r23, r24, "createWidget", r15) != r17) goto L25;
        return r17;
    L25:
        return r25;
    L17:
        ResultKt.throwOnFailure(r16);
        s r113 = j0.a();
        WidgetRendererEngine r26 = this.rendererEngine;
        WidgetLifeObserver r27 = new WidgetLifeObserver(r113);
        r15.L$0 = this;
        r15.L$1 = r11;
        r15.L$2 = r12;
        r15.L$3 = r113;
        r15.label = 1;
        Object r114 = r26.createWidget(r10, r11, r12, r27, r15);
        if (r114 != r17) goto L20;
        return r17;
    L20:
        r22 = this;
        r23 = r11;
        r24 = r12;
        r21 = r113;
        r16 = r114;
    L8:
        r5 = new C02011(this, r13);
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v43 */
    /* JADX WARN: Type inference failed for: r0v47 */
    /* JADX WARN: Type inference failed for: r16v13 */
    /* JADX WARN: Type inference failed for: r16v16 */
    /* JADX WARN: Type inference failed for: r16v19 */
    /* JADX WARN: Type inference failed for: r2v35 */
    /* JADX WARN: Type inference failed for: r2v40 */
    /* JADX WARN: Type inference failed for: r2v48 */
    /* JADX WARN: Type inference failed for: r4v26 */
    /* JADX WARN: Type inference failed for: r4v31 */
    /* JADX WARN: Type inference failed for: r4v34 */
    /* JADX WARN: Type inference failed for: r54v10 */
    /* JADX WARN: Type inference failed for: r54v12 */
    /* JADX WARN: Type inference failed for: r54v21 */
    /* JADX WARN: Type inference failed for: r54v9 */
    public final Object createWidgetWithSnapshotPrime(Context r55, WidgetDefinitionMetadata r56, int r57, String r58, String r59, Continuation<? super WidgetCreateViewResult> r60) {
        if ((r60 instanceof C02021) == false) goto L8;
        C02021 r5 = (C02021) r60;
        int r10 = r5.label;
        if ((r10 & Integer.MIN_VALUE) == 0) goto L8;
        r5.label = r10 - Integer.MIN_VALUE;
    L7:
        C02021 r11 = r5;
        Object r12 = r11.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(r11.label) {
            case 0: goto L20;
            case 1: goto L19;
            case 2: goto L18;
            case 3: goto L17;
            case 4: goto L16;
            case 5: goto L15;
            case 6: goto L14;
            case 7: goto L13;
            default: goto L12;
        };
    L13:
        int r14 = r11.I$1;
        long r15 = r11.J$2;
        long r16 = r11.J$1;
        long r17 = r11.J$0;
        int r18 = r11.I$0;
        View r19 = (View) r11.L$7;
        WidgetRendererCreateResult r110 = (WidgetRendererCreateResult) r11.L$6;
        m0 r20 = (m0) r11.L$5;
        WidgetPayloadCacheKey r21 = (WidgetPayloadCacheKey) r11.L$4;
        WidgetSnapshotQueryResult r111 = (WidgetSnapshotQueryResult) r11.L$3;
        String r112 = (String) r11.L$2;
        WidgetDefinitionMetadata r22 = (WidgetDefinitionMetadata) r11.L$1;
        WidgetRenderSessionController r113 = (WidgetRenderSessionController) r11.L$0;
        ResultKt.throwOnFailure(r12);
        long r114 = r15;
        boolean r115 = true;
        WidgetDefinitionMetadata r23 = r22;
        int r24 = r14;
    L139:
        long r116 = r17;
        View r32 = r19;
        WidgetSnapshotQueryResult r33 = r111;
        int r25 = r24;
        WidgetDefinitionMetadata r26 = r23;
        long r27 = r16;
        long r28 = r114;
        ?? r29 = ((Boolean) r12).booleanValue();
        WidgetRenderSessionController r30 = r113;
    L141:
        PrefetchedWidgetPayload r31 = r30.payloadCoordinator.peek(r21);
        if (r31 == null) goto L146;
        String r117 = r31.getPayload();
        if (r117 == null) goto L146;
        int r34 = r117.length();
    L147:
        if (r31 == null) goto L150;
        long r118 = r31.getRequestDurationMs();
    L149:
        long r35 = r118;
        if (r29 != 0) goto L155;
        if (r20 != null) goto L154;
        if (r25 != 0) goto L155;
    L154:
        boolean r37 = r115;
    L156:
        if (r110 == null) goto L158;
        long r38 = r110.getInternalQueryDurationMs();
    L159:
        if (r110 == null) goto L161;
        long r40 = r110.getSetupDurationMs();
    L162:
        if (r110 == null) goto L164;
        long r42 = r110.getSdkCreateDurationMs();
    L165:
        if (r110 == null) goto L167;
        long r44 = r110.getPostCreateDurationMs();
    L168:
        if (r110 == null) goto L170;
        long r46 = r110.getCreateDurationMs();
    L171:
        WidgetCreateViewResult r119 = new WidgetCreateViewResult(r32, r33, r34, r35, r37, r38, r40, r42, r44, r46);
        r30.reportCreateBreakdown(r26, r18, r112, r119, r27, SystemClock.elapsedRealtime() - r116);
        return r119;
    L170:
        r46 = SystemClock.elapsedRealtime() - r28;
        goto L171
    L167:
        r44 = 0;
        goto L168
    L164:
        r42 = 0;
        goto L165
    L161:
        r40 = 0;
        goto L162
    L158:
        r38 = 0;
    L155:
        r37 = false;
        goto L156
    L150:
        r118 = -1;
    L146:
        r34 = 0;
        goto L147
    L14:
        int r36 = r11.I$2;
        int r39 = r11.I$1;
        long r41 = r11.J$2;
        long r43 = r11.J$1;
        long r45 = r11.J$0;
        int r47 = r11.I$0;
        View r120 = (View) r11.L$8;
        WidgetRendererCreateResult r121 = (WidgetRendererCreateResult) r11.L$7;
        m0 r122 = (m0) r11.L$6;
        String r123 = (String) r11.L$5;
        WidgetPayloadCacheKey r48 = (WidgetPayloadCacheKey) r11.L$4;
        WidgetSnapshotQueryResult r49 = (WidgetSnapshotQueryResult) r11.L$3;
        String r50 = (String) r11.L$2;
        WidgetDefinitionMetadata r51 = (WidgetDefinitionMetadata) r11.L$1;
        WidgetRenderSessionController r52 = (WidgetRenderSessionController) r11.L$0;
        ResultKt.throwOnFailure(r12);
        long r124 = r41;
        WidgetRendererCreateResult r210 = r121;
        m0 r211 = r122;
        String r212 = r123;
        r115 = true;
        int r53 = r36;
        String r54 = r50;
        WidgetDefinitionMetadata r125 = r51;
        long r126 = r45;
        View r61 = r120;
        int r62 = r39;
        Object r63 = r12;
        Object r64 = r13;
        long r127 = r43;
        WidgetPayloadCacheKey r65 = r48;
        WidgetSnapshotQueryResult r66 = r49;
    L115:
        int r510 = r53;
        WidgetRendererCreateResult r67 = r210;
        m0 r410 = r211;
        Object r213 = r64;
        View r68 = r61;
        String r69 = r212;
        long r214 = r124;
        ?? r128 = r62;
        String r70 = r54;
        int r71 = r47;
        r21 = r65;
        PayloadConsumeResult r72 = (PayloadConsumeResult) r63;
        WidgetSnapshotQueryResult r73 = r66;
        m0 r74 = r410;
        WidgetDefinitionMetadata r411 = r125;
        WidgetRenderSessionController r129 = r52;
        WidgetDefinitionMetadata r75 = r411;
    L120:
        if (r72 == null) goto L128;
        PrefetchedWidgetPayload r130 = r72.getPayload();
        if (r130 == null) goto L128;
        String r131 = r130.getPayload();
        if (r131 == null) goto L128;
        if (StringsKt.isBlank(r131) == true) goto L128;
    L129:
        if (r68 == null) goto L140;
        if (r72 == null) goto L132;
        PrefetchedWidgetPayload r76 = r72.getPayload();
    L134:
        if (r129.shouldConsumePayload(r69, r76) == false) goto L140;
        MainCoroutineDispatcher r77 = Dispatchers.getMain().getImmediate();
        WidgetRenderSessionController$createWidgetWithSnapshotPrime$updated$1 r78 = new WidgetRenderSessionController$createWidgetWithSnapshotPrime$updated$1(r129, r68, r75, r131, null);
        r11.L$0 = r129;
        r11.L$1 = r75;
        r11.L$2 = r70;
        r11.L$3 = r73;
        r11.L$4 = r21;
        r11.L$5 = r74;
        r11.L$6 = r67;
        r11.L$7 = r68;
        View r511 = r68;
        r11.L$8 = null;
        r11.I$0 = r71;
        r11.J$0 = r126;
        r11.J$1 = r127;
        WidgetDefinitionMetadata r512 = r75;
        long r79 = r214;
        r11.J$2 = r79;
        r114 = r79;
        ?? r80 = r128;
        r11.I$1 = r80 == true ? 1 : 0;
        r11.label = 7;
        Object r81 = BuildersKt.withContext(r77, r78, r11);
        Object r82 = r213;
        if (r81 != r82) goto L138;
        return r82;
    L138:
        r20 = r74;
        r113 = r129;
        r110 = r67;
        long r412 = r127;
        r19 = r511;
        r18 = r71;
        r16 = r412;
        WidgetSnapshotQueryResult r513 = r73;
        r23 = r512;
        r24 = r80 == true ? 1 : 0;
        r12 = r81;
        long r514 = r126;
        r111 = r513;
        r112 = r70;
        r17 = r514;
        goto L139
    L132:
        r76 = null;
    L140:
        View r515 = r68;
        ?? r83 = r128;
        r32 = r515;
        r26 = r75;
        r33 = r73;
        r20 = r74;
        r27 = r127;
        r116 = r126;
        r18 = r71;
        r112 = r70;
        r29 = r510;
        r25 = r83 == true ? 1 : 0;
        r30 = r129;
        r110 = r67;
        r28 = r214;
    L128:
        r131 = null;
        goto L129
    L15:
        int r84 = r11.I$1;
        long r85 = r11.J$2;
        long r86 = r11.J$1;
        long r87 = r11.J$0;
        int r88 = r11.I$0;
        WidgetRendererCreateResult r89 = (WidgetRendererCreateResult) r11.L$7;
        m0 r132 = (m0) r11.L$6;
        String r133 = (String) r11.L$5;
        WidgetPayloadCacheKey r134 = (WidgetPayloadCacheKey) r11.L$4;
        WidgetSnapshotQueryResult r135 = (WidgetSnapshotQueryResult) r11.L$3;
        String r90 = (String) r11.L$2;
        WidgetDefinitionMetadata r91 = (WidgetDefinitionMetadata) r11.L$1;
        WidgetRenderSessionController r92 = (WidgetRenderSessionController) r11.L$0;
        ResultKt.throwOnFailure(r12);
        r124 = r85;
        long r215 = r86;
        r65 = r134;
        r115 = true;
        r54 = r90;
        WidgetRenderSessionController r93 = r92;
        m0 r136 = r132;
        int r94 = r84;
        r125 = r91;
        Object r95 = r13;
        long r137 = r87;
        r66 = r135;
    L99:
        Object r216 = r95;
        int r96 = r88;
        r67 = r89;
        r69 = r133;
        m0 r97 = r136;
        r126 = r137;
        r127 = r215;
        WidgetRenderSessionController r413 = r93;
        ?? r98 = r94;
        WidgetRenderSessionController r99 = r413;
    L101:
        if (r67 == null) goto L103;
        View r100 = r67.getView();
    L104:
        if (r98 != 0) goto L108;
        r100 = null;
    L108:
        if (r99.isNullOrBlankLike(r100) == true) goto L118;
        ?? r516 = r98;
        if (r99.shouldConsumePayload(r69, r99.payloadCoordinator.peek(r65)) == false) goto L116;
        WidgetPayloadPrefetchCoordinator r101 = r99.payloadCoordinator;
        r11.L$0 = r99;
        r11.L$1 = r125;
        r11.L$2 = r54;
        r11.L$3 = r66;
        r11.L$4 = r65;
        r11.L$5 = r69;
        r11.L$6 = r97;
        r11.L$7 = r67;
        r11.L$8 = r100;
        r11.I$0 = r96;
        r11.J$0 = r126;
        r11.J$1 = r127;
        int r217 = r96;
        WidgetRenderSessionController r218 = r99;
        r11.J$2 = r124;
        r11.I$1 = r516 == true ? 1 : 0;
        r11.I$2 = 0;
        r11.label = 6;
        r63 = r101.awaitIfReady(r65, 0, r11);
        r64 = r216;
        if (r63 != r64) goto L114;
        return r64;
    L114:
        r211 = r97;
        r52 = r218;
        r62 = r516 == true ? 1 : 0;
        r210 = r67;
        r53 = 0;
        r212 = r69;
        r61 = r100;
        r47 = r217;
        goto L115
    L116:
        ?? r517 = r516;
    L119:
        r213 = r216;
        r73 = r66;
        r74 = r97;
        r68 = r100;
        r75 = r125;
        r129 = r99;
        r70 = r54;
        r21 = r65;
        r71 = r96;
        r72 = null;
        r214 = r124;
        r128 = r517;
        r510 = 0;
        goto L120
    L118:
        r517 = r98;
        goto L119
    L103:
        r100 = null;
        goto L104
    L16:
        long r102 = r11.J$2;
        long r103 = r11.J$1;
        long r104 = r11.J$0;
        int r105 = r11.I$0;
        WidgetRendererCreateResult r106 = (WidgetRendererCreateResult) r11.L$8;
        m0 r107 = (m0) r11.L$7;
        String r138 = (String) r11.L$6;
        WidgetPayloadCacheKey r139 = (WidgetPayloadCacheKey) r11.L$5;
        WidgetSnapshotQueryResult r140 = (WidgetSnapshotQueryResult) r11.L$4;
        String r108 = (String) r11.L$3;
        String r109 = (String) r11.L$2;
        WidgetDefinitionMetadata r141 = (WidgetDefinitionMetadata) r11.L$1;
        WidgetRenderSessionController r142 = (WidgetRenderSessionController) r11.L$0;
        ResultKt.throwOnFailure(r12);
        long r219 = r103;
        WidgetRendererCreateResult r143 = r106;
        Object r144 = r13;
        String r220 = ", instance=";
        WidgetSnapshotQueryResult r145 = r140;
        r115 = true;
        r125 = r141;
        r54 = r109;
        int r146 = r105;
        r93 = r142;
        long r147 = r104;
        long r148 = r102;
        String r149 = r108;
    L88:
        Object r221 = r144;
        String r150 = r138;
        String r151 = r149;
        boolean r152 = ((Boolean) r12).booleanValue();
        int r153 = r146;
        WidgetPayloadCacheKey r414 = r139;
        r136 = r107;
        r89 = r143;
        r124 = r148;
        r66 = r145;
        r65 = r414;
        r137 = r147;
        long r154 = r219;
    L90:
        if (r89 == null) goto L92;
        View r222 = r89.getView();
    L93:
        if (r222 == null) goto L100;
        if (r152 == true) goto L100;
        boolean r518 = r152;
        r215 = r154;
        Log.w(r151, "destroy widget view because first page is not ready: reason=" + r54 + r220 + r153);
        View r155 = r89.getView();
        MainCoroutineDispatcher r156 = Dispatchers.getMain().getImmediate();
        AnonymousClass2 r157 = new AnonymousClass2(r93, r155, null);
        r11.L$0 = r93;
        r11.L$1 = r125;
        r11.L$2 = r54;
        r11.L$3 = r66;
        r11.L$4 = r65;
        r11.L$5 = r150;
        r11.L$6 = r136;
        r11.L$7 = r89;
        r11.L$8 = null;
        r11.I$0 = r153;
        r11.J$0 = r137;
        int r158 = r153;
        r11.J$1 = r215;
        r11.J$2 = r124;
        r11.I$1 = r518 ? 1 : 0;
        r11.label = 5;
        Object r159 = BuildersKt.withContext(r156, r157, r11);
        r95 = r221;
        if (r159 != r95) goto L98;
        return r95;
    L98:
        r94 = r518 ? 1 : 0;
        r88 = r158;
        r133 = r150;
    L100:
        int r160 = r153;
        boolean r161 = r152;
        long r223 = r154;
        r99 = r93;
        r69 = r150;
        r216 = r221;
        r67 = r89;
        r97 = r136;
        r98 = r161;
        r96 = r160;
        r126 = r137;
        r127 = r223;
        goto L101
    L92:
        r222 = null;
        goto L93
    L17:
        long r162 = r11.J$2;
        long r163 = r11.J$1;
        long r164 = r11.J$0;
        int r165 = r11.I$0;
        m0 r166 = (m0) r11.L$8;
        String r167 = (String) r11.L$7;
        WidgetPayloadCacheKey r168 = (WidgetPayloadCacheKey) r11.L$6;
        WidgetSnapshotQueryResult r169 = (WidgetSnapshotQueryResult) r11.L$5;
        r r170 = (r) r11.L$4;
        String r171 = (String) r11.L$3;
        String r172 = (String) r11.L$2;
        WidgetDefinitionMetadata r173 = (WidgetDefinitionMetadata) r11.L$1;
        WidgetRenderSessionController r174 = (WidgetRenderSessionController) r11.L$0;
        ResultKt.throwOnFailure(r12);
        long r175 = r162;
        r221 = r13;
        r220 = ", instance=";
        r r224 = r170;
        r115 = true;
        r125 = r173;
        r146 = r165;
        m0 r176 = r166;
        r147 = r164;
        long r177 = r163;
        r54 = r172;
        WidgetSnapshotQueryResult r178 = r169;
        r139 = r168;
        r138 = r167;
        String r179 = r171;
    L79:
        WidgetRendererCreateResult r180 = (WidgetRendererCreateResult) r12;
        if (r180 == null) goto L82;
        View r181 = r180.getView();
    L83:
        if (r181 == null) goto L89;
        Integer r182 = Boxing.boxInt(r146);
        r11.L$0 = r174;
        r11.L$1 = r125;
        r11.L$2 = r54;
        r11.L$3 = r179;
        r11.L$4 = r178;
        r11.L$5 = r139;
        r11.L$6 = r138;
        r11.L$7 = r176;
        r11.L$8 = r180;
        r11.I$0 = r146;
        r11.J$0 = r147;
        r11.J$1 = r177;
        r219 = r177;
        r148 = r175;
        r11.J$2 = r148;
        r143 = r180;
        r11.label = 4;
        r12 = r174.awaitPageReady(r224, r179, r125, r182, r54, r11);
        r144 = r221;
        if (r12 != r144) goto L87;
        return r144;
    L87:
        WidgetSnapshotQueryResult r415 = r178;
        r93 = r174;
        r149 = r179;
        r107 = r176;
        r145 = r415;
        goto L88
    L89:
        long r225 = r177;
        r153 = r146;
        r150 = r138;
        r151 = r179;
        r89 = r180;
        r124 = r175;
        r65 = r139;
        r66 = r178;
        r136 = r176;
        r93 = r174;
        r137 = r147;
        r154 = r225;
        r152 = false;
        goto L90
    L82:
        r181 = null;
        goto L83
    L18:
        long r183 = r11.J$0;
        int r184 = r11.I$0;
        String r185 = (String) r11.L$10;
        String r186 = (String) r11.L$9;
        WidgetPayloadCacheKey r187 = (WidgetPayloadCacheKey) r11.L$8;
        WidgetSnapshotQueryResult r188 = (WidgetSnapshotQueryResult) r11.L$7;
        WidgetLifeObserver r189 = (WidgetLifeObserver) r11.L$6;
        r r190 = (r) r11.L$5;
        String r191 = (String) r11.L$4;
        String r192 = (String) r11.L$3;
        r125 = (WidgetDefinitionMetadata) r11.L$2;
        Context r193 = (Context) r11.L$1;
        WidgetRenderSessionController r194 = (WidgetRenderSessionController) r11.L$0;
        ResultKt.throwOnFailure(r12);
        long r226 = r183;
        int r227 = r184;
        Object r195 = r13;
        r220 = ", instance=";
        r115 = true;
    L74:
        String r310 = r185;
        String r196 = r186;
        WidgetSnapshotQueryResult r197 = r188;
        WidgetLifeObserver r311 = r189;
        r r198 = r190;
        r179 = r191;
        r147 = r226;
        WidgetRenderSessionController r199 = r194;
        m0 r200 = (m0) ((Pair) r12).component1();
        int r201 = r227;
        String r416 = r192;
        Context r1100 = r193;
        String r202 = r416;
    L75:
        m0 r1101 = r200;
        Object r228 = r195;
        long r203 = SystemClock.elapsedRealtime() - r147;
        long r204 = SystemClock.elapsedRealtime();
        CalendarWidgetLocaleRestoreRenderGate r229 = CalendarWidgetLocaleRestoreRenderGate.INSTANCE;
        String r230 = r125.getAppletId();
        WidgetRenderSessionController$createWidgetWithSnapshotPrime$rendererCreateResult$1 r231 = new WidgetRenderSessionController$createWidgetWithSnapshotPrime$rendererCreateResult$1(r199, r1100, r125, r201, r196, r310, r311, r179, r202, null);
        r11.L$0 = r199;
        r11.L$1 = r125;
        r11.L$2 = r202;
        r11.L$3 = r179;
        r11.L$4 = r198;
        r11.L$5 = r197;
        r11.L$6 = r187;
        r11.L$7 = r196;
        r11.L$8 = r1101;
        WidgetSnapshotQueryResult r232 = r197;
        r11.L$9 = null;
        r11.L$10 = null;
        r11.I$0 = r201;
        r11.J$0 = r147;
        r224 = r198;
        r11.J$1 = r203;
        r11.J$2 = r204;
        int r610 = r201;
        r11.label = 3;
        r12 = r229.runIfNeeded(r1100, r230, r202, r231, r11);
        if (r12 != r228) goto L78;
        return r228;
    L78:
        r175 = r204;
        r221 = r228;
        r178 = r232;
        r139 = r187;
        r177 = r203;
        r54 = r202;
        r174 = r199;
        r138 = r196;
        r176 = r1101;
        r146 = r610;
        goto L79
    L19:
        long r205 = r11.J$0;
        int r206 = r11.I$0;
        WidgetLifeObserver r207 = (WidgetLifeObserver) r11.L$6;
        r198 = (r) r11.L$5;
        String r208 = (String) r11.L$4;
        String r209 = (String) r11.L$3;
        WidgetDefinitionMetadata r233 = (WidgetDefinitionMetadata) r11.L$2;
        Context r234 = (Context) r11.L$1;
        r199 = (WidgetRenderSessionController) r11.L$0;
        ResultKt.throwOnFailure(r12);
        r125 = r233;
        r1100 = r234;
        r115 = true;
        r179 = r208;
        WidgetLifeObserver r235 = r207;
        Object r236 = r12;
        r201 = r206;
        r202 = r209;
        long r237 = r205;
    L24:
        r197 = (WidgetSnapshotQueryResult) r236;
        if (r197.getErrorWithoutPayload() == false) goto L27;
        Log.w(r179, "snapshot is error without payload, continue render and wait async payload: reason=" + r202 + ", instance=" + r201);
    L27:
        r220 = ", instance=";
        WidgetPayloadCacheKey r238 = new WidgetPayloadCacheKey(r199.hostId, r125.getAppletId(), r125.getWidgetId(), r201);
        PrefetchedWidgetPayload r239 = r199.payloadCoordinator.peek(r238);
        WidgetDataSnapshot r1102 = r197.getSnapshot();
        if (r1102 == null) goto L34;
        String r1103 = r1102.getWidgetData();
        if (r1103 == null) goto L34;
        if (StringsKt.isBlank(r1103) == true) goto L34;
    L35:
        if (r239 == null) goto L43;
        r196 = r239.getPayload();
        if (r196 == null) goto L43;
        if (StringsKt.isBlank(r196) == false) goto L42;
        r196 = null;
    L42:
        if (r196 == null) goto L43;
    L44:
        if (r239 == null) goto L46;
        String r240 = r239.getPayload();
    L47:
        if (r240 != null) goto L49;
    L53:
        if (r1103 != null) goto L55;
    L58:
        String r241 = "none";
    L52:
        long r242 = r237;
        String r243 = r241;
        if (r1103 != null) goto L61;
    L62:
        if (r239 == null) goto L64;
        String r244 = r239.getPayload();
    L65:
        if (r244 != null) goto L67;
    L70:
        WidgetPayloadPrefetchCoordinator r245 = r199.payloadCoordinator;
        CoroutineScope r246 = r199.prefetchScope;
        WidgetRenderSessionController$createWidgetWithSnapshotPrime$prefetchDeferred$1 r1104 = new WidgetRenderSessionController$createWidgetWithSnapshotPrime$prefetchDeferred$1(r199, r125, r201, r202, r179, null);
        r11.L$0 = r199;
        r11.L$1 = r1100;
        r11.L$2 = r125;
        r11.L$3 = r202;
        r11.L$4 = r179;
        r11.L$5 = r198;
        r11.L$6 = r235;
        r11.L$7 = r197;
        r11.L$8 = r238;
        r11.L$9 = r196;
        r11.L$10 = r243;
        r11.I$0 = r201;
        WidgetLifeObserver r247 = r235;
        r11.J$0 = r242;
        r227 = r201;
        r11.label = 2;
        r r248 = r198;
        r226 = r242;
        String r249 = r179;
        Object r250 = WidgetPayloadPrefetchCoordinator.getOrStartPrefetch$default(r245, r246, r238, r1104, null, r11, 8, null);
        r195 = r13;
        if (r250 != r195) goto L73;
        return r195;
    L73:
        r189 = r247;
        r186 = r196;
        r185 = r243;
        r187 = r238;
        r188 = r197;
        r190 = r248;
        WidgetRenderSessionController r417 = r199;
        r191 = r249;
        r12 = r250;
        r194 = r417;
        Context r418 = r1100;
        r192 = r202;
        r193 = r418;
        goto L74
    L67:
        if (StringsKt.isBlank(r244) == true) goto L70;
    L69:
        r200 = r199.payloadCoordinator.getInFlightOrNull(r238);
        r311 = r235;
        r310 = r243;
        r147 = r242;
        r187 = r238;
        r195 = r13;
        goto L75
    L64:
        r244 = null;
        goto L65
    L61:
        if (StringsKt.isBlank(r1103) == false) goto L69;
    L55:
        if (StringsKt.isBlank(r1103) == true) goto L58;
        r241 = "snapshot";
        goto L52
    L49:
        if (StringsKt.isBlank(r240) == true) goto L53;
        r241 = "cache";
        goto L52
    L46:
        r240 = null;
    L43:
        r196 = r1103;
    L34:
        r1103 = null;
        goto L35
    L20:
        ResultKt.throwOnFailure(r12);
        r237 = SystemClock.elapsedRealtime();
        s r251 = j0.a();
        WidgetLifeObserver r1105 = new WidgetLifeObserver(r251);
        r11.L$0 = this;
        r1100 = r55;
        r11.L$1 = r1100;
        r125 = r56;
        r11.L$2 = r125;
        r11.L$3 = r58;
        r11.L$4 = r59;
        r11.L$5 = r251;
        r11.L$6 = r1105;
        r11.I$0 = r57;
        r11.J$0 = r237;
        r11.label = 1;
        r115 = true;
        Object r252 = queryWidgetSnapshot(r56, r57, r58, r59, r11);
        if (r252 != r13) goto L23;
        return r13;
    L23:
        r202 = r58;
        r236 = r252;
        r198 = r251;
        r201 = r57;
        r179 = r59;
        r199 = this;
        r235 = r1105;
        goto L24
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        r5 = new C02021(this, r60);
        goto L7
    }

    public final boolean destroyWidgetHost(View r5) {
        return this.rendererEngine.destroyWidgetHost(r5);
    }

    public final boolean dispatchWidgetDataChanged(View r5, WidgetDataChangedEvent r10) {
        Intrinsics.checkNotNullParameter(r10, "event");
        return dispatchRuntimeEvent(r5, EVENT_WIDGET_DATA_CHANGED, Companion.buildDataChangedEventPayload$widget_host_sdk_release(this.hostId, r10));
    }

    public final boolean dispatchWidgetForeground(View r11, String r12, String r13, int r14, long r15, String r17) {
        Intrinsics.checkNotNullParameter(r17, "source");
        return dispatchRuntimeEvent(r11, EVENT_WIDGET_FOREGROUND, Companion.buildForegroundEventPayload$widget_host_sdk_release(this.hostId, r12, r13, r14, r15, r17));
    }

    public final boolean dispatchWidgetPackageChanged(View r12, String r13, String r14, int r15, String r16, long r17, String r19) {
        Intrinsics.checkNotNullParameter(r16, Constant.APPID);
        return dispatchRuntimeEvent(r12, EVENT_WIDGET_PACKAGE_CHANGED, Companion.buildPackageChangedEventPayload$widget_host_sdk_release(this.hostId, r13, r14, r15, r16, r17, r19));
    }

    public final boolean dispatchWidgetSystemChanged(View r13, String r14, String r15, int r16, String r17, String r18, long r19, String r21) {
        Intrinsics.checkNotNullParameter(r17, "type");
        return dispatchRuntimeEvent(r13, EVENT_WIDGET_SYSTEM_CHANGED, Companion.buildSystemChangedEventPayload$widget_host_sdk_release(this.hostId, r14, r15, r16, r17, r18, r19, r21));
    }

    public final boolean dispatchWidgetThemeChanged(View r5, boolean r10) {
        return this.rendererEngine.dispatchWidgetThemeChanged(r5, r10);
    }

    public final boolean dispatchWidgetVisibilityChanged(View r5, boolean r10) {
        return this.rendererEngine.dispatchWidgetVisibilityChanged(r5, r10);
    }

    public final boolean dispatchWidgetVisibilityEvent(View r12, WidgetDefinitionMetadata r13, int r14, boolean r15, long r16, String r18) {
        Intrinsics.checkNotNullParameter(r13, "widget");
        Intrinsics.checkNotNullParameter(r18, "source");
        Companion r5 = Companion;
        return dispatchRuntimeEvent(r12, Companion.access$visibilityEventId(r5, r15), r5.buildVisibilityEventPayload$widget_host_sdk_release(this.hostId, r13.getAppletId(), r13.getWidgetId(), r14, r16, r18));
    }

    public final WidgetDataSnapshot queryWidgetData(WidgetDefinitionMetadata r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "widget");
        return this.runtimeClient.queryWidgetData(r5.getAppletId(), r5.getWidgetId(), r10);
    }

    public final Object queryWidgetSnapshot(WidgetDefinitionMetadata r15, int r16, String r17, String r18, Continuation<? super WidgetSnapshotQueryResult> r19) {
        if ((r19 instanceof C02031) == false) goto L7;
        C02031 r5 = (C02031) r19;
        int r10 = r5.label;
        if ((r10 & Integer.MIN_VALUE) == 0) goto L7;
        r5.label = r10 - Integer.MIN_VALUE;
    L8:
        Object r11 = r5.result;
        Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r13 = r5.label;
        boolean r14 = true;
        if (r13 == 0) goto L14;
        if (r13 != 1) goto L13;
        long r20 = r5.J$0;
        int r21 = r5.I$0;
        String r22 = (String) r5.L$1;
        String r23 = (String) r5.L$0;
        ResultKt.throwOnFailure(r11);
        long r110 = r20;
        String r24 = r22;
    L18:
        WidgetDataSnapshot r25 = (WidgetDataSnapshot) r11;
        long r26 = SystemClock.elapsedRealtime() - r110;
        if (r25 == null) goto L21;
        String r27 = r25.getState();
    L23:
        if (Intrinsics.areEqual(r27, "error") == false) goto L29;
        String r28 = r25.getWidgetData();
        if (r28 != null) goto L27;
    L30:
        if (r14 == false) goto L33;
        Log.w(r24, "skip render for error snapshot without payload: reason=" + r23 + ", instance=" + r21);
    L33:
        return new WidgetSnapshotQueryResult(r25, r26, r14);
    L27:
        if (StringsKt.isBlank(r28) == true) goto L30;
    L29:
        r14 = false;
        goto L30
    L21:
        r27 = null;
        goto L23
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r11);
        r110 = SystemClock.elapsedRealtime();
        z r29 = Dispatchers.getIO();
        WidgetRenderSessionController$queryWidgetSnapshot$snapshot$1 r111 = new WidgetRenderSessionController$queryWidgetSnapshot$snapshot$1(this, r15, r16, r18, r17, null);
        r5.L$0 = r17;
        r24 = r18;
        r5.L$1 = r24;
        r21 = r16;
        r5.I$0 = r21;
        r5.J$0 = r110;
        r5.label = 1;
        r11 = BuildersKt.withContext(r29, r111, r5);
        if (r11 != r12) goto L17;
        return r12;
    L17:
        r23 = r17;
    L7:
        r5 = new C02031(this, r19);
        goto L8
    }

    public final Object requestLatestWidgetPayload(WidgetDefinitionMetadata r15, int r16, String r17, String r18, Continuation<? super WidgetRemoteUpdateResult> r19) {
        if ((r19 instanceof C02041) == false) goto L7;
        C02041 r5 = (C02041) r19;
        int r10 = r5.label;
        if ((r10 & Integer.MIN_VALUE) == 0) goto L7;
        r5.label = r10 - Integer.MIN_VALUE;
    L8:
        Object r11 = r5.result;
        Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r13 = r5.label;
        if (r13 == 0) goto L14;
        if (r13 != 1) goto L13;
        long r14 = r5.J$0;
        ResultKt.throwOnFailure(r11);
    L19:
        return new WidgetRemoteUpdateResult((String) r11, SystemClock.elapsedRealtime() - r14);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r11);
        long r110 = SystemClock.elapsedRealtime();
        z r20 = Dispatchers.getIO();
        WidgetRenderSessionController$requestLatestWidgetPayload$payload$1 r111 = new WidgetRenderSessionController$requestLatestWidgetPayload$payload$1(this, r15, r16, r17, r18, null);
        r5.J$0 = r110;
        r5.label = 1;
        r11 = BuildersKt.withContext(r20, r111, r5);
        if (r11 != r12) goto L17;
        return r12;
    L17:
        r14 = r110;
    L7:
        r5 = new C02041(this, r19);
        goto L8
    }

    public final boolean sendEventToWidget(View r5, String r10, JsonObject r11) {
        Intrinsics.checkNotNullParameter(r10, "eventName");
        Intrinsics.checkNotNullParameter(r11, LynxResourceModule.PARAMS_KEY);
        return this.rendererEngine.sendEventToWidget(r5, r10, r11);
    }

    public final String sendPayload(WidgetDefinitionMetadata r10, int r11, String r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r10, "widget");
        return this.runtimeClient.sendPayload(r10.getAppletId(), r10.getWidgetId(), r11, r12, r13);
    }

    public final Object updateRenderedWidget(View r26, WidgetDefinitionMetadata r27, int r28, String r29, String r30, Continuation<? super WidgetViewUpdateResult> r31) {
        if ((r31 instanceof C02051) == false) goto L8;
        C02051 r5 = (C02051) r31;
        int r10 = r5.label;
        if ((r10 & Integer.MIN_VALUE) == 0) goto L8;
        r5.label = r10 - Integer.MIN_VALUE;
    L7:
        C02051 r11 = r5;
        Object r12 = r11.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r14 = r11.label;
        if (r14 == 0) goto L17;
        if (r14 == 1) goto L16;
        if (r14 != 2) goto L15;
        long r15 = r11.J$1;
        long r16 = r11.J$0;
        int r17 = r11.I$0;
        String r18 = (String) r11.L$4;
        WidgetRemoteUpdateResult r19 = (WidgetRemoteUpdateResult) r11.L$3;
        String r20 = (String) r11.L$2;
        WidgetDefinitionMetadata r110 = (WidgetDefinitionMetadata) r11.L$1;
        WidgetRenderSessionController r21 = (WidgetRenderSessionController) r11.L$0;
        ResultKt.throwOnFailure(r12);
        WidgetRenderSessionController r111 = r21;
    L34:
        boolean r112 = ((Boolean) r12).booleanValue();
        WidgetViewUpdateResult r22 = new WidgetViewUpdateResult(r112, r112, r18.length(), r19.getUpdateDurationMs(), SystemClock.elapsedRealtime() - r15);
        r111.reportUpdateBreakdown(r110, r17, r20, r22, SystemClock.elapsedRealtime() - r16);
        return r22;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        long r23 = r11.J$0;
        int r24 = r11.I$0;
        String r25 = (String) r11.L$4;
        String r32 = (String) r11.L$3;
        WidgetDefinitionMetadata r33 = (WidgetDefinitionMetadata) r11.L$2;
        View r113 = (View) r11.L$1;
        r111 = (WidgetRenderSessionController) r11.L$0;
        ResultKt.throwOnFailure(r12);
        View r114 = r113;
    L21:
        WidgetRemoteUpdateResult r34 = (WidgetRemoteUpdateResult) r12;
        String r115 = r34.getPayload();
        if (r115 != null) goto L24;
    L26:
        r115 = null;
    L27:
        if (r115 != null) goto L30;
        Log.w(r25, "skip in-place widget update because remote payload is empty: reason=" + r32 + ", instance=" + r24);
        WidgetViewUpdateResult r35 = new WidgetViewUpdateResult(false, false, 0, r34.getUpdateDurationMs(), 0);
        r111.reportUpdateBreakdown(r33, r24, r32, r35, SystemClock.elapsedRealtime() - r23);
        return r35;
    L30:
        long r116 = SystemClock.elapsedRealtime();
        MainCoroutineDispatcher r117 = Dispatchers.getMain().getImmediate();
        WidgetRenderSessionController$updateRenderedWidget$updated$1 r36 = new WidgetRenderSessionController$updateRenderedWidget$updated$1(r111, r114, r33, r115, r25, r32, r24, null);
        r11.L$0 = r111;
        r11.L$1 = r33;
        r11.L$2 = r32;
        r11.L$3 = r34;
        r11.L$4 = r115;
        r11.I$0 = r24;
        r11.J$0 = r23;
        r11.J$1 = r116;
        r11.label = 2;
        Object r37 = BuildersKt.withContext(r117, r36, r11);
        if (r37 != r13) goto L33;
        return r13;
    L33:
        r19 = r34;
        r12 = r37;
        r20 = r32;
        r17 = r24;
        r16 = r23;
        r15 = r116;
        String r210 = r115;
        r110 = r33;
        r18 = r210;
        goto L34
    L24:
        if (StringsKt.isBlank(r115) == true) goto L26;
    L17:
        ResultKt.throwOnFailure(r12);
        long r118 = SystemClock.elapsedRealtime();
        r11.L$0 = this;
        r11.L$1 = r26;
        r11.L$2 = r27;
        r11.L$3 = r29;
        r11.L$4 = r30;
        r11.I$0 = r28;
        r11.J$0 = r118;
        r11.label = 1;
        r12 = requestLatestWidgetPayload(r27, r28, r29, r30, r11);
        if (r12 != r13) goto L20;
        return r13;
    L20:
        r24 = r28;
        r23 = r118;
        r32 = r29;
        r25 = r30;
        r111 = this;
        r114 = r26;
        r33 = r27;
    L8:
        r5 = new C02051(this, r31);
        goto L7
    }

    public final String updateWidget(WidgetDefinitionMetadata r5, int r10, String r11) {
        Intrinsics.checkNotNullParameter(r5, "widget");
        return this.runtimeClient.updateWidget(r5.getAppletId(), r5.getWidgetId(), r10, r11);
    }

    public final boolean updateWidgetView(View r5, WidgetDefinitionMetadata r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "widget");
        return this.rendererEngine.updateWidgetView(r5, r10, r11);
    }

    public WidgetRenderSessionController(WidgetRuntimeClient r10, WidgetRendererEngine r11, String r12, WidgetPerfReporter r13, WidgetPayloadPrefetchCoordinator r14, CoroutineScope r15, int r16, DefaultConstructorMarker r17) {
        if ((r16 & 2) == 0) goto L5;
        String r5 = "unknown";
        WidgetRendererEngine r18 = new WidgetRendererEngine(r10, r5, null, null, 12, null);
    L7:
        if ((r16 & 4) == 0) goto L9;
        String r19 = "unknown";
    L11:
        if ((r16 & 8) == 0) goto L13;
        WidgetPerfReporter r20 = WidgetPerfReporter.Companion.getNO_OP();
    L15:
        if ((r16 & 16) == 0) goto L17;
        WidgetPayloadPrefetchCoordinator r21 = new WidgetPayloadPrefetchCoordinator();
    L19:
        if ((r16 & 32) == 0) goto L21;
        CoroutineScope r22 = h0.a(CoroutineContext.Element.DefaultImpls.plus(j0.b(), Dispatchers.getIO()));
    L22:
        this(r10, r18, r19, r20, r21, r22);
        return;
    L21:
        r22 = r15;
        goto L22
    L17:
        r21 = r14;
        goto L19
    L13:
        r20 = r13;
        goto L15
    L9:
        r19 = r12;
        goto L11
    L5:
        r18 = r11;
        goto L7
    }
}
