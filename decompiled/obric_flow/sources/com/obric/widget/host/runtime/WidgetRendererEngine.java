package com.obric.widget.host.runtime;

import android.content.Context;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import cn.nubia.neopush.commons.Constant;
import com.bytedance.ai.ex.widget.WidgetRenderService;
import com.bytedance.ai.ex.widget.WidgetSDK;
import com.bytedance.ai.ex.widget.WidgetView;
import com.bytedance.ai.model.objects.WidgetInfo;
import com.bytedance.ai.widget.models.OAppletWrap;
import com.google.gson.JsonObject;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.feature.miniapp.widget.MiniAppWidgetManagerWrapper;
import com.obric.widget.host.WidgetInstanceKey;
import com.obric.widget.host.WidgetPerfEvent;
import com.obric.widget.host.WidgetPerfReporter;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
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
import kotlinx.coroutines.h0;
import kotlinx.coroutines.j0;
import kotlinx.coroutines.z;
import w0.m;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 @2\u00020\u0001:\u0001@B+\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nJc\u0010\u0018\u001a\u00020\u00172\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u00102\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00102\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ8\u0010\"\u001a\u00020!2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001d2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001f2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0086@¢\u0006\u0004\b\"\u0010#JX\u0010(\u001a\u00020'2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001d2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001f2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010%\u001a\u00020\u00042\b\b\u0002\u0010&\u001a\u00020\u001a2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0086@¢\u0006\u0004\b(\u0010)J)\u0010,\u001a\u00020\u001a2\b\u0010*\u001a\u0004\u0018\u00010!2\u0006\u0010\u001e\u001a\u00020\u001d2\b\u0010+\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b,\u0010-J\u001f\u0010/\u001a\u00020\u001a2\b\u0010*\u001a\u0004\u0018\u00010!2\u0006\u0010.\u001a\u00020\u001a¢\u0006\u0004\b/\u00100J\u001f\u00102\u001a\u00020\u001a2\b\u0010*\u001a\u0004\u0018\u00010!2\u0006\u00101\u001a\u00020\u001a¢\u0006\u0004\b2\u00100J\u0017\u00103\u001a\u00020\u001a2\b\u0010*\u001a\u0004\u0018\u00010!¢\u0006\u0004\b3\u00104J'\u00108\u001a\u00020\u001a2\b\u0010*\u001a\u0004\u0018\u00010!2\u0006\u00105\u001a\u00020\u00042\u0006\u00107\u001a\u000206¢\u0006\u0004\b8\u00109R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010:R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010;R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010<R\u0014\u0010\b\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010;R\u0014\u0010>\u001a\u00020=8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010?¨\u0006A"}, d2 = {"Lcom/obric/widget/host/runtime/WidgetRendererEngine;", "", "Lcom/obric/widget/host/runtime/WidgetRuntimeClient;", "runtimeClient", "", "hostId", "Lcom/obric/widget/host/WidgetPerfReporter;", "perfReporter", "messageIdPrefix", "<init>", "(Lcom/obric/widget/host/runtime/WidgetRuntimeClient;Ljava/lang/String;Lcom/obric/widget/host/WidgetPerfReporter;Ljava/lang/String;)V", "Lcom/bytedance/ai/model/objects/WidgetInfo;", "widgetInfo", "Landroid/content/Context;", "context", "messageId", "", "environmentConfig", "viewContext", "Lcom/bytedance/ai/widget/models/OAppletWrap;", "appletWrap", "Lw0/m;", "widgetLifeObserver", "Lcom/bytedance/ai/ex/widget/WidgetView;", "createWidgetViewAndBindAsync", "(Lcom/bytedance/ai/model/objects/WidgetInfo;Landroid/content/Context;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Lcom/bytedance/ai/widget/models/OAppletWrap;Lw0/m;)Lcom/bytedance/ai/ex/widget/WidgetView;", "", "isDarkMode", "(Landroid/content/Context;)Z", "Lcom/obric/widget/host/runtime/WidgetDefinitionMetadata;", "widget", "", "instanceId", "Landroid/view/View;", "createWidget", "(Landroid/content/Context;Lcom/obric/widget/host/runtime/WidgetDefinitionMetadata;Ljava/lang/Integer;Lw0/m;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "initialWidgetData", "initialDataSource", "skipInternalQuery", "Lcom/obric/widget/host/runtime/WidgetRendererCreateResult;", "createWidgetDetailed", "(Landroid/content/Context;Lcom/obric/widget/host/runtime/WidgetDefinitionMetadata;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;ZLw0/m;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "widgetView", "widgetData", "updateWidgetView", "(Landroid/view/View;Lcom/obric/widget/host/runtime/WidgetDefinitionMetadata;Ljava/lang/String;)Z", "isNightMode", "dispatchWidgetThemeChanged", "(Landroid/view/View;Z)Z", "isVisible", "dispatchWidgetVisibilityChanged", "destroyWidgetHost", "(Landroid/view/View;)Z", "eventName", "Lcom/google/gson/JsonObject;", LynxResourceModule.PARAMS_KEY, "sendEventToWidget", "(Landroid/view/View;Ljava/lang/String;Lcom/google/gson/JsonObject;)Z", "Lcom/obric/widget/host/runtime/WidgetRuntimeClient;", "Ljava/lang/String;", "Lcom/obric/widget/host/WidgetPerfReporter;", "Lkotlinx/coroutines/CoroutineScope;", "asyncBindScope", "Lkotlinx/coroutines/CoroutineScope;", "Companion", "widget-host-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nWidgetRendererEngine.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WidgetRendererEngine.kt\ncom/obric/widget/host/runtime/WidgetRendererEngine\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,313:1\n1#2:314\n*E\n"})
public final class WidgetRendererEngine {
    private static final String APP_THEME_DARK = "dark";
    private static final String APP_THEME_LIGHT = "light";
    public static final Companion Companion = null;
    private static final String DESKTOP_WIDGET_MESSAGE_ID_PREFIX = "launcher_widget";
    private static final String OWIDGET_LYNX_GROUP_PREFIX = "owidget";
    public static final String REFRESH_REASON_EVENT = "event";
    public static final String REFRESH_REASON_MANUAL = "manual";
    public static final String REFRESH_REASON_ON_ADD = "onAdd";
    public static final String REFRESH_REASON_ON_RESTORE = "onRestore";
    public static final String REFRESH_REASON_PACKAGE_UPDATE = "packageUpdate";
    public static final String REFRESH_REASON_PERIODIC = "periodic";
    public static final String REFRESH_REASON_VISIBILITY_GAIN = "visibilityGain";
    private static final String TAG = "OWidgetRendererEngine";
    private final CoroutineScope asyncBindScope;
    private final String hostId;
    private final String messageIdPrefix;
    private final WidgetPerfReporter perfReporter;
    private final WidgetRuntimeClient runtimeClient;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J;\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\u001d\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0005H\u0000¢\u0006\u0002\b\u001cJ\u001d\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0005H\u0000¢\u0006\u0002\b\u001eJ=\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050 2\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\"2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010#\u001a\u00020\u0005H\u0000¢\u0006\u0004\b$\u0010%R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/obric/widget/host/runtime/WidgetRendererEngine$Companion;", "", "<init>", "()V", "TAG", "", "DESKTOP_WIDGET_MESSAGE_ID_PREFIX", "OWIDGET_LYNX_GROUP_PREFIX", "APP_THEME_DARK", "APP_THEME_LIGHT", "REFRESH_REASON_ON_ADD", "REFRESH_REASON_ON_RESTORE", "REFRESH_REASON_EVENT", "REFRESH_REASON_VISIBILITY_GAIN", "REFRESH_REASON_MANUAL", "REFRESH_REASON_PERIODIC", "REFRESH_REASON_PACKAGE_UPDATE", "buildStableMessageId", "prefix", "hostId", "appletId", "widgetId", "instanceId", "", "buildStableMessageId$widget_host_sdk_release", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Ljava/lang/String;", "buildOWidgetAppletWrap", "Lcom/bytedance/ai/widget/models/OAppletWrap;", "buildOWidgetAppletWrap$widget_host_sdk_release", "buildOWidgetLynxGroupName", "buildOWidgetLynxGroupName$widget_host_sdk_release", "buildInitialViewContext", "", "widget", "Lcom/obric/widget/host/runtime/WidgetDefinitionMetadata;", "appTheme", "buildInitialViewContext$widget_host_sdk_release", "(Ljava/lang/String;Lcom/obric/widget/host/runtime/WidgetDefinitionMetadata;Ljava/lang/Integer;Ljava/lang/String;)Ljava/util/Map;", "widget-host-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nWidgetRendererEngine.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WidgetRendererEngine.kt\ncom/obric/widget/host/runtime/WidgetRendererEngine$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,313:1\n1#2:314\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public final Map<String, String> buildInitialViewContext$widget_host_sdk_release(String r5, WidgetDefinitionMetadata r10, Integer r11, String r12) {
            Intrinsics.checkNotNullParameter(r5, "hostId");
            Intrinsics.checkNotNullParameter(r10, "widget");
            Intrinsics.checkNotNullParameter(r12, "appTheme");
            Map r13 = MapsKt.createMapBuilder();
            r13.put("renderScene", WidgetRendererEngine.OWIDGET_LYNX_GROUP_PREFIX);
            r13.put("appTheme", r12);
            r13.put("hostId", r5);
            r13.put("appletId", r10.getAppletId());
            r13.put("widgetId", r10.getWidgetId());
            r13.put("rawHostId", r5);
            r13.put("rawAppletId", r10.getAppletId());
            r13.put("rawWidgetId", r10.getWidgetId());
            if (r11 == null) goto L5;
            String r14 = (String) r13.put("instanceId", String.valueOf(r11.intValue()));
        L5:
            if (r11 == null) goto L8;
            r13.put("rawInstanceId", String.valueOf(r11.intValue()));
        L8:
            return MapsKt.build(r13);
        }

        public final OAppletWrap buildOWidgetAppletWrap$widget_host_sdk_release(String r5, String r10) {
            Intrinsics.checkNotNullParameter(r5, "hostId");
            Intrinsics.checkNotNullParameter(r10, "appletId");
            return new OAppletWrap(buildOWidgetLynxGroupName$widget_host_sdk_release(r5, r10), false);
        }

        public final String buildOWidgetLynxGroupName$widget_host_sdk_release(String r5, String r10) {
            return androidx.constraintlayout.motion.widget.a.t(androidx.constraintlayout.motion.widget.a.D(r5, "hostId", r10, "appletId", "owidget:"), r5, ":", r10);
        }

        public final String buildStableMessageId$widget_host_sdk_release(String r5, String r10, String r11, String r12, Integer r13) {
            Intrinsics.checkNotNullParameter(r5, "prefix");
            Intrinsics.checkNotNullParameter(r10, "hostId");
            Intrinsics.checkNotNullParameter(r11, "appletId");
            Intrinsics.checkNotNullParameter(r12, "widgetId");
            if (r13 == null) goto L5;
            int r14 = r13.intValue();
            StringBuilder r15 = androidx.room.jarjarred.org.antlr.runtime.a.y(r5, ":", r10, ":", r11);
            r15.append(":");
            r15.append(r12);
            r15.append(":");
            r15.append(r14);
            return r15.toString();
        L5:
            return null;
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: com.obric.widget.host.runtime.WidgetRendererEngine$createWidget$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.widget.host.runtime.WidgetRendererEngine", f = "WidgetRendererEngine.kt", i = {}, l = {48}, m = "createWidget", n = {}, s = {})
    public static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ WidgetRendererEngine this$0;

        public AnonymousClass1(WidgetRendererEngine r5, Continuation<? super AnonymousClass1> r10) {
            this.this$0 = r5;
            super(r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            this.result = r10;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.createWidget(null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.obric.widget.host.runtime.WidgetRendererEngine$createWidgetDetailed$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.widget.host.runtime.WidgetRendererEngine", f = "WidgetRendererEngine.kt", i = {0, 0, 0, 0, 0, 0, 0, 0}, l = {69}, m = "createWidgetDetailed", n = {"this", "context", "widget", "instanceId", "initialWidgetData", "widgetLifeObserver", "createStartElapsed", "internalQueryStartElapsed"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "J$0", "J$1"})
    public static final class C02061 extends ContinuationImpl {
        long J$0;
        long J$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ WidgetRendererEngine this$0;

        public C02061(WidgetRendererEngine r5, Continuation<? super C02061> r10) {
            this.this$0 = r5;
            super(r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            this.result = r10;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.createWidgetDetailed(null, null, null, null, null, false, null, this);
        }
    }

    /* JADX INFO: renamed from: com.obric.widget.host.runtime.WidgetRendererEngine$createWidgetViewAndBindAsync$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.widget.host.runtime.WidgetRendererEngine$createWidgetViewAndBindAsync$1", f = "WidgetRendererEngine.kt", i = {}, l = {Constant.SDK_VERSION}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02071 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ OAppletWrap $appletWrap;
        final /* synthetic */ String $messageId;
        final /* synthetic */ WidgetInfo $widgetInfo;
        final /* synthetic */ m $widgetLifeObserver;
        final /* synthetic */ WidgetView $widgetView;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ WidgetRendererEngine this$0;

        public C02071(WidgetView r5, WidgetInfo r10, String r11, m r12, OAppletWrap r13, WidgetRendererEngine r14, Continuation<? super C02071> r15) {
            this.$widgetView = r5;
            this.$widgetInfo = r10;
            this.$messageId = r11;
            this.$widgetLifeObserver = r12;
            this.$appletWrap = r13;
            this.this$0 = r14;
            super(2, r15);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            C02071 r12 = new C02071(this.$widgetView, this.$widgetInfo, this.$messageId, this.$widgetLifeObserver, this.$appletWrap, this.this$0, r11);
            r12.L$0 = r10;
            return r12;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
            return invoke2(r5, r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r11) {
            Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r10 = this.label;
            if (r10 == 0) goto L11;
            if (r10 != 1) goto L10;
            ResultKt.throwOnFailure(r11);     // Catch: Throwable -> L7
        L15:
            Object r12 = Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L7
        L18:
            m r13 = this.$widgetLifeObserver;
            WidgetRendererEngine r14 = this.this$0;
            WidgetInfo r15 = this.$widgetInfo;
            String r16 = this.$messageId;
            Throwable r17 = Result.m127exceptionOrNullimpl(r12);
            if (r17 == null) goto L24;
            if (r13 == null) goto L22;
            r13.onPageError();
        L22:
            String r18 = WidgetRendererEngine.access$getHostId$p(r14);
            String r19 = r15.getAppletId();
            String r20 = r15.getWidgetId();
            Log.e(WidgetRendererEngine.TAG, androidx.constraintlayout.motion.widget.a.t(androidx.constraintlayout.motion.widget.a.y("bind widget view failed: hostId=", r18, ", appletId=", r19, ", widgetId="), r20, ", messageId=", r16), r17);
        L24:
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            ResultKt.throwOnFailure(r11);
            CoroutineScope r110 = (CoroutineScope) this.L$0;
            WidgetView r21 = this.$widgetView;
            WidgetInfo r22 = this.$widgetInfo;
            String r23 = this.$messageId;
            m r24 = this.$widgetLifeObserver;
            OAppletWrap r25 = this.$appletWrap;
            Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L7
            this.label = 1;     // Catch: Throwable -> L7
            if (r21.bindData(r22, r21, r23, r24, r25, this) != r5) goto L15;
            return r5;
        L7:
            th = move-exception;
            Result.Companion r26 = Result.Companion;
            r12 = Result.m124constructorimpl(ResultKt.createFailure(th));
            goto L18
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r5, Continuation<? super Unit> r10) {
            return ((C02071) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public WidgetRendererEngine(WidgetRuntimeClient r5, String r10, WidgetPerfReporter r11, String r12) {
        Intrinsics.checkNotNullParameter(r5, "runtimeClient");
        Intrinsics.checkNotNullParameter(r10, "hostId");
        Intrinsics.checkNotNullParameter(r11, "perfReporter");
        Intrinsics.checkNotNullParameter(r12, "messageIdPrefix");
        this.runtimeClient = r5;
        this.hostId = r10;
        this.perfReporter = r11;
        this.messageIdPrefix = r12;
        this.asyncBindScope = h0.a(CoroutineContext.Element.DefaultImpls.plus(j0.b(), Dispatchers.getMain().getImmediate()));
    }

    public static /* synthetic */ void a(WidgetView r5, String r10) {
        createWidgetDetailed$lambda$4(r5, r10);
    }

    public static final /* synthetic */ String access$getHostId$p(WidgetRendererEngine r5) {
        return r5.hostId;
    }

    public static final /* synthetic */ WidgetRuntimeClient access$getRuntimeClient$p(WidgetRendererEngine r5) {
        return r5.runtimeClient;
    }

    public static /* synthetic */ Object createWidget$default(WidgetRendererEngine r10, Context r11, WidgetDefinitionMetadata r12, Integer r13, m r14, Continuation r15, int r16, Object r17) {
        if ((r16 & 4) == 0) goto L5;
        Integer r5 = null;
    L7:
        if ((r16 & 8) == 0) goto L9;
        m r18 = null;
    L11:
        return r10.createWidget(r11, r12, r5, r18, r15);
    L9:
        r18 = r14;
        goto L11
    L5:
        r5 = r13;
        goto L7
    }

    public static /* synthetic */ Object createWidgetDetailed$default(WidgetRendererEngine r11, Context r12, WidgetDefinitionMetadata r13, Integer r14, String r15, String r16, boolean r17, m r18, Continuation r19, int r20, Object r21) {
        if ((r20 & 4) == 0) goto L5;
        Integer r5 = null;
    L7:
        if ((r20 & 8) == 0) goto L9;
        String r10 = null;
    L11:
        if ((r20 & 16) == 0) goto L13;
        String r22 = "none";
    L15:
        if ((r20 & 32) == 0) goto L17;
        boolean r23 = true;
    L19:
        if ((r20 & 64) == 0) goto L21;
        m r24 = null;
    L23:
        return r11.createWidgetDetailed(r12, r13, r5, r10, r22, r23, r24, r19);
    L21:
        r24 = r18;
        goto L23
    L17:
        r23 = r17;
        goto L19
    L13:
        r22 = r16;
        goto L15
    L9:
        r10 = r15;
        goto L11
    L5:
        r5 = r14;
        goto L7
    }

    private static final void createWidgetDetailed$lambda$4(WidgetView r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "$widgetView");
        Intrinsics.checkNotNullParameter(r10, "$appTheme");
        WidgetSDK.INSTANCE.notifyWidgetThemeChanged(r5, Intrinsics.areEqual(r10, "dark"));
    }

    private final WidgetView createWidgetViewAndBindAsync(WidgetInfo r12, Context r13, String r14, Map<Object, ? extends Object> r15, Map<String, String> r16, OAppletWrap r17, m r18) {
        WidgetView r10 = new WidgetView(r13);
        r10.setEnvironmentConfig(MapsKt.toMutableMap(r15));
        r10.setViewContext(MapsKt.toMutableMap(r16));
        BuildersKt.launch$default(this.asyncBindScope, null, null, new C02071(r10, r12, r14, r18, r17, this, null), 3, null);
        return r10;
    }

    private final boolean isDarkMode(Context r5) {
        if ((r5.getResources().getConfiguration().uiMode & 48) != 32) goto L5;
        return true;
    L5:
        return false;
    }

    public final Object createWidget(Context r14, WidgetDefinitionMetadata r15, Integer r16, m r17, Continuation<? super View> r18) {
        if ((r18 instanceof AnonymousClass1) == false) goto L8;
        AnonymousClass1 r5 = (AnonymousClass1) r18;
        int r10 = r5.label;
        if ((r10 & Integer.MIN_VALUE) == 0) goto L8;
        r5.label = r10 - Integer.MIN_VALUE;
    L7:
        AnonymousClass1 r11 = r5;
        Object r12 = r11.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r19 = r11.label;
        if (r19 == 0) goto L15;
        if (r19 != 1) goto L14;
        ResultKt.throwOnFailure(r12);
    L19:
        return ((WidgetRendererCreateResult) r12).getView();
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r12);
        r11.label = 1;
        r12 = createWidgetDetailed$default(this, r14, r15, r16, null, null, false, r17, r11, 56, null);
        if (r12 != r13) goto L19;
        return r13;
    L8:
        r5 = new AnonymousClass1(this, r18);
        goto L7
    }

    public final Object createWidgetDetailed(Context r42, WidgetDefinitionMetadata r43, Integer r44, String r45, String r46, boolean r47, m r48, Continuation<? super WidgetRendererCreateResult> r49) {
        WidgetRendererEngine r5 = this;
        if ((r49 instanceof C02061) == false) goto L7;
        C02061 r10 = (C02061) r49;
        int r11 = r10.label;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
        r10.label = r11 - Integer.MIN_VALUE;
    L8:
        Object r12 = r10.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r14 = r10.label;
        if (r14 == 0) goto L14;
        if (r14 != 1) goto L13;
        long r15 = r10.J$1;
        long r16 = r10.J$0;
        m r17 = (m) r10.L$5;
        String r18 = (String) r10.L$4;
        Integer r19 = (Integer) r10.L$3;
        WidgetDefinitionMetadata r110 = (WidgetDefinitionMetadata) r10.L$2;
        Context r111 = (Context) r10.L$1;
        WidgetRendererEngine r20 = (WidgetRendererEngine) r10.L$0;
        ResultKt.throwOnFailure(r12);
        m r112 = r17;
        Object r21 = r12;
        long r22 = r16;
        long r23 = r15;
        r5 = r20;
    L25:
        WidgetDataSnapshot r24 = (WidgetDataSnapshot) r21;
    L27:
        long r113 = SystemClock.elapsedRealtime() - r23;
        if (r18 != null) goto L30;
    L36:
        if (r24 == null) goto L42;
        r18 = r24.getWidgetData();
        if (r18 == null) goto L42;
        if (StringsKt.isBlank(r18) == true) goto L42;
    L35:
        String r25 = r18;
    L43:
        long r26 = SystemClock.elapsedRealtime();
        Companion r27 = Companion;
        String r28 = r27.buildStableMessageId$widget_host_sdk_release(r5.messageIdPrefix, r5.hostId, r110.getAppletId(), r110.getWidgetId(), r19);
        Context r114 = MiniAppWidgetManagerWrapper.INSTANCE.createOWidgetRenderContext(r111);
        if (r5.isDarkMode(r114) == false) goto L46;
        String r115 = "dark";
    L47:
        Map<String, String> r29 = r27.buildInitialViewContext$widget_host_sdk_release(r5.hostId, r110, r19, r115);
        String r116 = r115;
        OAppletWrap r30 = r27.buildOWidgetAppletWrap$widget_host_sdk_release(r5.hostId, r110.getAppletId());
        String r31 = r5.hostId;
        String r117 = r110.getAppletId();
        WidgetDataSnapshot r34 = r24;
        String r32 = r110.getWidgetId();
        long r35 = r22;
        String r33 = r30.getGroupName();
        int r36 = r111.getResources().getConfiguration().densityDpi;
        m r410 = r112;
        int r118 = r114.getResources().getConfiguration().densityDpi;
        float r119 = r111.getResources().getConfiguration().fontScale;
        float r37 = r114.getResources().getConfiguration().fontScale;
        WidgetRendererEngine r38 = r5;
        WidgetDefinitionMetadata r39 = r110;
        StringBuilder r40 = androidx.constraintlayout.motion.widget.a.y("createWidget: hostId=", r31, ", appletId=", r117, ", widgetId=");
        r40.append(r32);
        r40.append(", instanceId=");
        r40.append(r19);
        r40.append(", messageId=");
        androidx.constraintlayout.motion.widget.a.C(r40, r28, ", lynxGroup=", r33, ", sourceDensityDpi=");
        androidx.room.jarjarred.org.antlr.runtime.a.C(r40, r36, ", renderDensityDpi=", r118, ", sourceFontScale=");
        r40.append(r119);
        r40.append(", renderFontScale=");
        r40.append(r37);
        r40.append(", viewContext=");
        r40.append(r29);
        Log.d(TAG, r40.toString());
        long r41 = SystemClock.elapsedRealtime() - r26;
        long r50 = SystemClock.elapsedRealtime();
        WidgetView r51 = r38.createWidgetViewAndBindAsync(new WidgetInfo(r39.getAppletId(), r39.getWidgetId(), r25, null, null, null, null, null, null, null, null, 2040, null), r114, r28, MapsKt.mapOf(TuplesKt.to(WidgetView.ENV_DESTROY_ON_DETACH, Boxing.boxBoolean(false))), r29, r30, r410);
        long r210 = SystemClock.elapsedRealtime() - r50;
        long r52 = SystemClock.elapsedRealtime();
        long r53 = SystemClock.elapsedRealtime() - r35;
        WidgetPerfReporter r54 = r38.perfReporter;
        String r120 = r38.hostId;
        if (r19 == null) goto L50;
        WidgetInstanceKey r211 = new WidgetInstanceKey(r39.getAppletId(), r39.getWidgetId(), String.valueOf(r19.intValue()), r38.hostId);
    L51:
        Pair r55 = TuplesKt.to("appletId", r39.getAppletId());
        Pair r121 = TuplesKt.to("widgetId", r39.getWidgetId());
        Pair r122 = TuplesKt.to("instanceId", r19);
        Pair r123 = TuplesKt.to("internalQueryMs", Boxing.boxLong(r113));
        Pair r124 = TuplesKt.to("setupMs", Boxing.boxLong(r41));
        Pair r56 = TuplesKt.to("sdkCreateMs", Boxing.boxLong(r210));
        Pair r57 = TuplesKt.to("createCallMs", Boxing.boxLong(r53));
        if (r34 == null) goto L54;
        String r58 = r34.getWidgetData();
    L55:
        if (r58 != null) goto L57;
    L60:
        boolean r125 = true;
    L61:
        r54.report(new WidgetPerfEvent("widget_renderer_create_breakdown", r120, r211, 0, MapsKt.mapOf(new Pair[]{r55, r121, r122, r123, r124, r56, r57, TuplesKt.to("hasSnapshotPayload", Boxing.boxBoolean(!r125))}), 8, null));
        r51.post(new com.obric.feature.miniapp.widget.a(r51, r116, 1));
        return new WidgetRendererCreateResult(r51, r113, r41, r210, SystemClock.elapsedRealtime() - r52, SystemClock.elapsedRealtime() - r35);
    L57:
        if (StringsKt.isBlank(r58) == true) goto L60;
        r125 = false;
        goto L61
    L54:
        r58 = null;
        goto L55
    L50:
        r211 = null;
        goto L51
    L46:
        r115 = "light";
    L42:
        r25 = null;
        goto L43
    L30:
        if (StringsKt.isBlank(r18) == false) goto L33;
        r18 = null;
    L33:
        if (r18 != null) goto L35;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r12);
        long r126 = SystemClock.elapsedRealtime();
        long r127 = SystemClock.elapsedRealtime();
        if (r44 == null) goto L26;
        int r59 = r44.intValue();
        if (r47 == true) goto L26;
        if (r45 != null) goto L20;
    L21:
        z r60 = Dispatchers.getIO();
        WidgetRendererEngine$createWidgetDetailed$snapshot$1$1 r128 = new WidgetRendererEngine$createWidgetDetailed$snapshot$1$1(r5, r43, r59, null);
        r10.L$0 = r5;
        r10.L$1 = r42;
        r10.L$2 = r43;
        r10.L$3 = r44;
        r10.L$4 = r45;
        r112 = r48;
        r10.L$5 = r112;
        r10.J$0 = r126;
        r10.J$1 = r127;
        r10.label = 1;
        r21 = BuildersKt.withContext(r60, r128, r10);
        if (r21 != r13) goto L24;
        return r13;
    L24:
        r18 = r45;
        r110 = r43;
        r19 = r44;
        r23 = r127;
        r111 = r42;
        r22 = r126;
        goto L25
    L20:
        if (StringsKt.isBlank(r45) == true) goto L21;
    L26:
        r112 = r48;
        r18 = r45;
        r24 = null;
        r110 = r43;
        r19 = r44;
        r23 = r127;
        r111 = r42;
        r22 = r126;
    L7:
        r10 = new C02061(r5, r49);
        goto L8
    }

    public final boolean destroyWidgetHost(View r5) {
        if ((r5 instanceof WidgetView) == false) goto L5;
        WidgetView r10 = (WidgetView) r5;
    L6:
        if (r10 != null) goto L10;
        return false;
    L10:
        return r10.destroyHostIfNeeded();
    L5:
        r10 = null;
        goto L6
    }

    public final boolean dispatchWidgetThemeChanged(View r5, boolean r10) {
        if ((r5 instanceof WidgetView) == false) goto L5;
        WidgetView r11 = (WidgetView) r5;
    L6:
        if (r11 != null) goto L9;
        return false;
    L9:
        WidgetSDK.INSTANCE.notifyWidgetThemeChanged(r11, r10);
        return true;
    L5:
        r11 = null;
        goto L6
    }

    public final boolean dispatchWidgetVisibilityChanged(View r5, boolean r10) {
        if ((r5 instanceof WidgetView) == false) goto L5;
        WidgetView r11 = (WidgetView) r5;
    L6:
        if (r11 != null) goto L9;
        return false;
    L9:
        if (r10 == false) goto L11;
        WidgetRenderService.INSTANCE.onHostShow(r11);
        return true;
    L11:
        WidgetRenderService.INSTANCE.onHostHide(r11);
        return true;
    L5:
        r11 = null;
        goto L6
    }

    public final boolean sendEventToWidget(View r5, String r10, JsonObject r11) {
        Intrinsics.checkNotNullParameter(r10, "eventName");
        Intrinsics.checkNotNullParameter(r11, LynxResourceModule.PARAMS_KEY);
        if ((r5 instanceof WidgetView) == false) goto L5;
        WidgetView r12 = (WidgetView) r5;
    L6:
        if (r12 != null) goto L10;
        return false;
    L10:
        return r12.onMessageToAIBridge(r10, r11);
    L5:
        r12 = null;
        goto L6
    }

    public final boolean updateWidgetView(View r19, WidgetDefinitionMetadata r20, String r21) {
        Intrinsics.checkNotNullParameter(r20, "widget");
        if ((r19 instanceof WidgetView) == false) goto L5;
        WidgetView r5 = (WidgetView) r19;
    L6:
        if (r5 != null) goto L9;
        return false;
    L9:
        String r10 = r20.getAppletId();
        String r11 = r20.getWidgetId();
        if (r21 != null) goto L12;
    L14:
        String r12 = null;
    L16:
        return r5.updateWidgetData(new WidgetInfo(r10, r11, r12, null, null, null, null, null, null, null, null, 2040, null));
    L12:
        if (StringsKt.isBlank(r21) == true) goto L14;
        r12 = r21;
        goto L16
    L5:
        r5 = null;
        goto L6
    }

    public /* synthetic */ WidgetRendererEngine(WidgetRuntimeClient r5, String r10, WidgetPerfReporter r11, String r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 4) == 0) goto L6;
        r11 = WidgetPerfReporter.Companion.getNO_OP();
    L6:
        if ((r13 & 8) == 0) goto L8;
        r12 = DESKTOP_WIDGET_MESSAGE_ID_PREFIX;
    L8:
        this(r5, r10, r11, r12);
    }
}
