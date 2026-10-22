package com.obric.widget.host;

import android.content.Context;
import android.os.Messenger;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import cn.nubia.neopush.commons.Constant;
import com.google.gson.JsonObject;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.widget.host.runtime.PayloadConsumeResult;
import com.obric.widget.host.runtime.WidgetAppletInfo;
import com.obric.widget.host.runtime.WidgetAvailability;
import com.obric.widget.host.runtime.WidgetBindReason;
import com.obric.widget.host.runtime.WidgetCreateViewResult;
import com.obric.widget.host.runtime.WidgetDataChangedEvent;
import com.obric.widget.host.runtime.WidgetDefinitionMetadata;
import com.obric.widget.host.runtime.WidgetInstanceRecord;
import com.obric.widget.host.runtime.WidgetInstanceSnapshot;
import com.obric.widget.host.runtime.WidgetProvider;
import com.obric.widget.host.runtime.WidgetRenderScheduler;
import com.obric.widget.host.runtime.WidgetRuntimeBindingController;
import com.obric.widget.host.runtime.WidgetRuntimeBindingSession;
import com.obric.widget.host.runtime.WidgetRuntimeServices;
import com.obric.widget.host.runtime.WidgetViewUpdateResult;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000Î\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\f0\u000b\"\b\b\u0000\u0010\f*\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u001e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0007H\u0096@¢\u0006\u0002\u0010\u0014J\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u0011H\u0096@¢\u0006\u0002\u0010\u0016J\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0013\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010\u0014J \u0010\u0019\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010\u001bJ1\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00072\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020\u0007H\u0016¢\u0006\u0002\u0010!J\u0010\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020$H\u0016J\u0018\u0010%\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0016J\u0010\u0010*\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020'H\u0016J\u0010\u0010+\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020'H\u0016J\u0018\u0010,\u001a\u00020-2\u0006\u0010&\u001a\u00020'2\u0006\u0010.\u001a\u00020-H\u0016J\u0010\u0010/\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020$H\u0016J\u001a\u00100\u001a\u00020-2\u0006\u0010#\u001a\u00020$2\b\u00101\u001a\u0004\u0018\u00010\u0007H\u0016J \u00102\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020'2\u0006\u00103\u001a\u00020-2\u0006\u00104\u001a\u00020\u001fH\u0016J\u0010\u00105\u001a\u00020-2\u0006\u0010#\u001a\u00020$H\u0016J\u0018\u00106\u001a\u00020\u00072\u0006\u0010#\u001a\u00020$2\u0006\u00107\u001a\u00020\u0007H\u0016J\u0017\u00108\u001a\u0004\u0018\u00010$2\u0006\u00109\u001a\u00020$H\u0016¢\u0006\u0002\u0010:J\u0012\u0010;\u001a\u0004\u0018\u00010<2\u0006\u0010#\u001a\u00020$H\u0016J\u001a\u0010=\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020'2\b\u00101\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010>\u001a\u00020\u0007H\u0016J$\u0010?\u001a\u00020-2\u0006\u0010@\u001a\u00020$2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u0007H\u0016J*\u0010A\u001a\u00020-2\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010@\u001a\u00020$2\b\u0010B\u001a\u0004\u0018\u00010CH\u0016J \u0010D\u001a\u00020-2\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010@\u001a\u00020$H\u0016J(\u0010E\u001a\u00020-2\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010@\u001a\u00020$2\u0006\u0010B\u001a\u00020CH\u0016J$\u0010F\u001a\u00020-2\u0006\u0010@\u001a\u00020$2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u0007H\u0016J,\u0010G\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010@\u001a\u00020$2\b\u00101\u001a\u0004\u0018\u00010\u0007H\u0016J4\u0010H\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010@\u001a\u00020$2\b\u0010I\u001a\u0004\u0018\u00010\u00072\u0006\u0010J\u001a\u00020-H\u0016J(\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020\u00122\b\u0010@\u001a\u0004\u0018\u00010$H\u0096@¢\u0006\u0002\u0010PJ$\u0010Q\u001a\u00020-2\b\u0010R\u001a\u0004\u0018\u00010L2\u0006\u0010O\u001a\u00020\u00122\b\u0010S\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010T\u001a\u00020-2\b\u0010R\u001a\u0004\u0018\u00010L2\u0006\u0010U\u001a\u00020-H\u0016J\u001a\u0010V\u001a\u00020-2\b\u0010R\u001a\u0004\u0018\u00010L2\u0006\u0010.\u001a\u00020-H\u0016J\u0012\u0010W\u001a\u00020-2\b\u0010R\u001a\u0004\u0018\u00010LH\u0016J\"\u0010X\u001a\u00020-2\b\u0010R\u001a\u0004\u0018\u00010L2\u0006\u0010Y\u001a\u00020\u00072\u0006\u0010Z\u001a\u00020[H\u0016J\u001a\u0010\\\u001a\u00020-2\b\u0010R\u001a\u0004\u0018\u00010L2\u0006\u0010]\u001a\u00020^H\u0016JR\u0010_\u001a\u00020-2\b\u0010R\u001a\u0004\u0018\u00010L2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u00072\u0006\u0010@\u001a\u00020$2\u0006\u0010`\u001a\u00020\u00072\b\u0010a\u001a\u0004\u0018\u00010\u00072\u0006\u0010b\u001a\u00020\u001f2\b\u0010c\u001a\u0004\u0018\u00010\u0007H\u0016J>\u0010d\u001a\u00020-2\b\u0010R\u001a\u0004\u0018\u00010L2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u00072\u0006\u0010@\u001a\u00020$2\u0006\u0010b\u001a\u00020\u001f2\u0006\u0010e\u001a\u00020\u0007H\u0016JH\u0010f\u001a\u00020-2\b\u0010R\u001a\u0004\u0018\u00010L2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u00072\u0006\u0010@\u001a\u00020$2\u0006\u0010g\u001a\u00020\u00072\u0006\u0010h\u001a\u00020\u001f2\b\u0010i\u001a\u0004\u0018\u00010\u0007H\u0016J8\u0010j\u001a\u00020k2\b\u0010R\u001a\u0004\u0018\u00010L2\u0006\u0010O\u001a\u00020\u00122\u0006\u0010@\u001a\u00020$2\u0006\u0010l\u001a\u00020\u00072\u0006\u0010m\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010nJ6\u0010o\u001a\u00020p2\u0006\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020\u00122\u0006\u0010@\u001a\u00020$2\u0006\u0010l\u001a\u00020\u00072\u0006\u0010m\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010qJ\u001e\u0010r\u001a\u00020s2\u0006\u0010O\u001a\u00020\u00122\u0006\u0010@\u001a\u00020$H\u0096@¢\u0006\u0002\u0010tJ\u0018\u0010u\u001a\u00020\u000f2\u0006\u0010O\u001a\u00020\u00122\u0006\u0010@\u001a\u00020$H\u0016J\u0018\u0010v\u001a\u00020w2\u0006\u0010x\u001a\u00020y2\u0006\u0010z\u001a\u00020\u0007H\u0016J\u0010\u0010{\u001a\u00020|2\u0006\u0010}\u001a\u00020$H\u0016J\b\u0010~\u001a\u00020\u007fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u0080\u0001"}, d2 = {"Lcom/obric/widget/host/DefaultWidgetHostImplementationServices;", "Lcom/obric/widget/host/WidgetHostImplementationServices;", "services", "Lcom/obric/widget/host/runtime/WidgetRuntimeServices;", "<init>", "(Lcom/obric/widget/host/runtime/WidgetRuntimeServices;)V", "hostId", "", "getHostId", "()Ljava/lang/String;", "widgetProvider", "Lcom/obric/widget/host/runtime/WidgetProvider;", ExifInterface.GPS_DIRECTION_TRUE, "", "refreshCatalogSync", "", "getWidgets", "", "Lcom/obric/widget/host/runtime/WidgetDefinitionMetadata;", "appletId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAppletIds", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAppletInfo", "Lcom/obric/widget/host/runtime/WidgetAppletInfo;", "getWidgetInfo", "widgetId", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ensureWidgetAvailable", "Lcom/obric/widget/host/runtime/WidgetAvailability;", "preferredVersion", "", "scene", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)Lcom/obric/widget/host/runtime/WidgetAvailability;", "describeRecord", "hostWidgetInstanceId", "", "bindInstance", "snapshot", "Lcom/obric/widget/host/runtime/WidgetInstanceSnapshot;", "bindReason", "Lcom/obric/widget/host/runtime/WidgetBindReason;", "onViewAttached", "onViewDetached", "onViewVisibilityChanged", "", "isVisible", "currentDirtyVersion", "markDirty", "reason", "onRenderCompleted", "success", "renderedDirtyVersion", "isDestroyed", "resolvePreferredRefreshReason", "fallbackReason", "findHostWidgetInstanceIdByAppWidgetId", "appWidgetId", "(I)Ljava/lang/Integer;", "peekRecord", "Lcom/obric/widget/host/runtime/WidgetInstanceRecord;", "onInstanceRemoved", "dumpInstanceState", "clearWidgetData", "instanceId", "dispatchWidgetBind", "messenger", "Landroid/os/Messenger;", "dispatchWidgetUnbind", "registerWidgetMessenger", "unregisterWidgetMessenger", "updateWidget", "sendPayload", "payload", "waitForResult", "createWidget", "Landroid/view/View;", "context", "Landroid/content/Context;", "widget", "(Landroid/content/Context;Lcom/obric/widget/host/runtime/WidgetDefinitionMetadata;Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateWidgetView", "widgetView", "widgetData", "dispatchWidgetThemeChanged", "isNightMode", "dispatchWidgetVisibilityChanged", "destroyWidgetHost", "sendEventToWidget", "eventName", LynxResourceModule.PARAMS_KEY, "Lcom/google/gson/JsonObject;", "dispatchWidgetDataChanged", "event", "Lcom/obric/widget/host/runtime/WidgetDataChangedEvent;", "dispatchWidgetSystemChanged", "type", "action", "timeMillis", "timeZone", "dispatchWidgetForeground", "source", "dispatchWidgetPackageChanged", Constant.APPID, "versionCode", "resourceType", "updateRenderedWidget", "Lcom/obric/widget/host/runtime/WidgetViewUpdateResult;", "renderReason", "logTag", "(Landroid/view/View;Lcom/obric/widget/host/runtime/WidgetDefinitionMetadata;ILjava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createWidgetWithSnapshotPrime", "Lcom/obric/widget/host/runtime/WidgetCreateViewResult;", "(Landroid/content/Context;Lcom/obric/widget/host/runtime/WidgetDefinitionMetadata;ILjava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitPrefetchedPayload", "Lcom/obric/widget/host/runtime/PayloadConsumeResult;", "(Lcom/obric/widget/host/runtime/WidgetDefinitionMetadata;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearPrefetchedPayload", "createRuntimeBindingController", "Lcom/obric/widget/host/runtime/WidgetRuntimeBindingController;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "tag", "createRuntimeBindingSession", "Lcom/obric/widget/host/runtime/WidgetRuntimeBindingSession;", "invalidInstanceId", "createRenderScheduler", "Lcom/obric/widget/host/runtime/WidgetRenderScheduler;", "widget-host-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DefaultWidgetHostImplementationServices implements WidgetHostImplementationServices {
    private final WidgetRuntimeServices services;

    public DefaultWidgetHostImplementationServices(WidgetRuntimeServices r5) {
        Intrinsics.checkNotNullParameter(r5, "services");
        this.services = r5;
    }

    @Override // com.obric.widget.host.WidgetHostImplementationServices
    public Object awaitPrefetchedPayload(WidgetDefinitionMetadata r5, int r10, Continuation<? super PayloadConsumeResult> r11) {
        return this.services.awaitPrefetchedPayload(r5, r10, r11);
    }

    @Override // com.obric.widget.host.WidgetHostImplementationServices
    public void bindInstance(WidgetInstanceSnapshot r5, WidgetBindReason r10) {
        Intrinsics.checkNotNullParameter(r5, "snapshot");
        Intrinsics.checkNotNullParameter(r10, "bindReason");
        this.services.getInstanceManager().bindInstance(r5, r10);
    }

    @Override // com.obric.widget.host.WidgetHostImplementationServices
    public void clearPrefetchedPayload(WidgetDefinitionMetadata r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "widget");
        this.services.clearPrefetchedPayload(r5, r10);
    }

    @Override // com.obric.widget.host.WidgetHostImplementationServices
    public boolean clearWidgetData(int r5, String r10, String r11) {
        return this.services.clearWidgetData(r5, r10, r11);
    }

    @Override // com.obric.widget.host.WidgetHostImplementationServices
    public WidgetRenderScheduler createRenderScheduler() {
        return this.services.createRenderScheduler();
    }

    @Override // com.obric.widget.host.WidgetHostImplementationServices
    public WidgetRuntimeBindingController createRuntimeBindingController(CoroutineScope r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "scope");
        Intrinsics.checkNotNullParameter(r10, "tag");
        return this.services.createRuntimeBindingController(r5, r10);
    }

    @Override // com.obric.widget.host.WidgetHostImplementationServices
    public WidgetRuntimeBindingSession createRuntimeBindingSession(int r5) {
        return this.services.createRuntimeBindingSession(r5);
    }

    @Override // com.obric.widget.host.WidgetHostImplementationServices
    public Object createWidget(Context r5, WidgetDefinitionMetadata r10, Integer r11, Continuation<? super View> r12) {
        return this.services.createWidget(r5, r10, r11, r12);
    }

    @Override // com.obric.widget.host.WidgetHostImplementationServices
    public Object createWidgetWithSnapshotPrime(Context r10, WidgetDefinitionMetadata r11, int r12, String r13, String r14, Continuation<? super WidgetCreateViewResult> r15) {
        return this.services.createWidgetWithSnapshotPrime(r10, r11, r12, r13, r14, r15);
    }

    @Override // com.obric.widget.host.WidgetHostImplementationServices
    public long currentDirtyVersion(int r5) {
        return this.services.getInstanceManager().currentDirtyVersion(r5);
    }

    @Override // com.obric.widget.host.WidgetHostImplementationServices
    public String describeRecord(int r5) {
        return this.services.getInstanceManager().describeRecord(r5);
    }

    @Override // com.obric.widget.host.WidgetHostImplementationServices
    public boolean destroyWidgetHost(View r5) {
        return this.services.destroyWidgetHost(r5);
    }

    @Override // com.obric.widget.host.WidgetHostImplementationServices
    public boolean dispatchWidgetBind(String r5, String r10, int r11, Messenger r12) {
        Intrinsics.checkNotNullParameter(r5, "appletId");
        Intrinsics.checkNotNullParameter(r10, "widgetId");
        return this.services.dispatchWidgetBind(r5, r10, r11, r12);
    }

    @Override // com.obric.widget.host.WidgetHostImplementationServices
    public boolean dispatchWidgetDataChanged(View r5, WidgetDataChangedEvent r10) {
        Intrinsics.checkNotNullParameter(r10, "event");
        return this.services.dispatchWidgetDataChanged(r5, r10);
    }

    @Override // com.obric.widget.host.WidgetHostImplementationServices
    public boolean dispatchWidgetForeground(View r10, String r11, String r12, int r13, long r14, String r16) {
        Intrinsics.checkNotNullParameter(r16, "source");
        return this.services.dispatchWidgetForeground(r10, r11, r12, r13, r14, r16);
    }

    @Override // com.obric.widget.host.WidgetHostImplementationServices
    public boolean dispatchWidgetPackageChanged(View r11, String r12, String r13, int r14, String r15, long r16, String r18) {
        Intrinsics.checkNotNullParameter(r15, Constant.APPID);
        return this.services.dispatchWidgetPackageChanged(r11, r12, r13, r14, r15, r16, r18);
    }

    @Override // com.obric.widget.host.WidgetHostImplementationServices
    public boolean dispatchWidgetSystemChanged(View r12, String r13, String r14, int r15, String r16, String r17, long r18, String r20) {
        Intrinsics.checkNotNullParameter(r16, "type");
        return this.services.dispatchWidgetSystemChanged(r12, r13, r14, r15, r16, r17, r18, r20);
    }

    @Override // com.obric.widget.host.WidgetHostImplementationServices
    public boolean dispatchWidgetThemeChanged(View r5, boolean r10) {
        return this.services.dispatchWidgetThemeChanged(r5, r10);
    }

    @Override // com.obric.widget.host.WidgetHostImplementationServices
    public boolean dispatchWidgetUnbind(String r5, String r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "appletId");
        Intrinsics.checkNotNullParameter(r10, "widgetId");
        return this.services.dispatchWidgetUnbind(r5, r10, r11);
    }

    @Override // com.obric.widget.host.WidgetHostImplementationServices
    public boolean dispatchWidgetVisibilityChanged(View r5, boolean r10) {
        return this.services.dispatchWidgetVisibilityChanged(r5, r10);
    }

    @Override // com.obric.widget.host.WidgetHostImplementationServices
    public String dumpInstanceState() {
        return this.services.getInstanceManager().dumpState();
    }

    @Override // com.obric.widget.host.WidgetHostImplementationServices
    public WidgetAvailability ensureWidgetAvailable(String r5, String r10, Long r11, String r12) {
        Intrinsics.checkNotNullParameter(r5, "appletId");
        Intrinsics.checkNotNullParameter(r10, "widgetId");
        Intrinsics.checkNotNullParameter(r12, "scene");
        return this.services.ensureWidgetAvailable(r5, r10, r11, r12);
    }

    @Override // com.obric.widget.host.WidgetHostImplementationServices
    public Integer findHostWidgetInstanceIdByAppWidgetId(int r5) {
        return this.services.getInstanceManager().findHostWidgetInstanceIdByAppWidgetId(r5);
    }

    @Override // com.obric.widget.host.WidgetHostImplementationServices
    public Object getAppletIds(Continuation<? super List<String>> r5) {
        return this.services.getAppletIds(r5);
    }

    @Override // com.obric.widget.host.WidgetHostImplementationServices
    public Object getAppletInfo(String r5, Continuation<? super WidgetAppletInfo> r10) {
        return this.services.getAppletInfo(r5, r10);
    }

    @Override // com.obric.widget.host.WidgetHostImplementationServices
    public String getHostId() {
        return this.services.getHostId();
    }

    @Override // com.obric.widget.host.WidgetHostImplementationServices
    public Object getWidgetInfo(String r5, String r10, Continuation<? super WidgetDefinitionMetadata> r11) {
        return this.services.getWidgetInfo(r5, r10, r11);
    }

    @Override // com.obric.widget.host.WidgetHostImplementationServices
    public Object getWidgets(String r5, Continuation<? super List<WidgetDefinitionMetadata>> r10) {
        return this.services.getWidgets(r5, r10);
    }

    @Override // com.obric.widget.host.WidgetHostImplementationServices
    public boolean isDestroyed(int r5) {
        return this.services.getInstanceManager().isDestroyed(r5);
    }

    @Override // com.obric.widget.host.WidgetHostImplementationServices
    public boolean markDirty(int r5, String r10) {
        return this.services.getInstanceManager().markDirty(r5, r10);
    }

    @Override // com.obric.widget.host.WidgetHostImplementationServices
    public void onInstanceRemoved(WidgetInstanceSnapshot r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "snapshot");
        this.services.getInstanceManager().onInstanceRemoved(r5.getHostWidgetInstanceId(), r10);
    }

    @Override // com.obric.widget.host.WidgetHostImplementationServices
    public void onRenderCompleted(WidgetInstanceSnapshot r5, boolean r10, long r11) {
        Intrinsics.checkNotNullParameter(r5, "snapshot");
        this.services.getInstanceManager().onRenderCompleted(r5, r10, r11);
    }

    @Override // com.obric.widget.host.WidgetHostImplementationServices
    public void onViewAttached(WidgetInstanceSnapshot r5) {
        Intrinsics.checkNotNullParameter(r5, "snapshot");
        this.services.getInstanceManager().onViewAttached(r5);
    }

    @Override // com.obric.widget.host.WidgetHostImplementationServices
    public void onViewDetached(WidgetInstanceSnapshot r5) {
        Intrinsics.checkNotNullParameter(r5, "snapshot");
        this.services.getInstanceManager().onViewDetached(r5);
    }

    @Override // com.obric.widget.host.WidgetHostImplementationServices
    public boolean onViewVisibilityChanged(WidgetInstanceSnapshot r5, boolean r10) {
        Intrinsics.checkNotNullParameter(r5, "snapshot");
        return this.services.getInstanceManager().onViewVisibilityChanged(r5, r10);
    }

    @Override // com.obric.widget.host.WidgetHostImplementationServices
    public WidgetInstanceRecord peekRecord(int r5) {
        return this.services.getInstanceManager().peekRecord(r5);
    }

    @Override // com.obric.widget.host.WidgetHostImplementationServices
    public void refreshCatalogSync() {
        this.services.refreshCatalogSync();
    }

    @Override // com.obric.widget.host.WidgetHostImplementationServices
    public boolean registerWidgetMessenger(String r5, String r10, int r11, Messenger r12) {
        Intrinsics.checkNotNullParameter(r5, "appletId");
        Intrinsics.checkNotNullParameter(r10, "widgetId");
        Intrinsics.checkNotNullParameter(r12, "messenger");
        return this.services.registerWidgetMessenger(r5, r10, r11, r12);
    }

    @Override // com.obric.widget.host.WidgetHostImplementationServices
    public String resolvePreferredRefreshReason(int r5, String r10) {
        Intrinsics.checkNotNullParameter(r10, "fallbackReason");
        return this.services.getInstanceManager().resolvePreferredRefreshReason(r5, r10);
    }

    @Override // com.obric.widget.host.WidgetHostImplementationServices
    public boolean sendEventToWidget(View r5, String r10, JsonObject r11) {
        Intrinsics.checkNotNullParameter(r10, "eventName");
        Intrinsics.checkNotNullParameter(r11, LynxResourceModule.PARAMS_KEY);
        return this.services.sendEventToWidget(r5, r10, r11);
    }

    @Override // com.obric.widget.host.WidgetHostImplementationServices
    public String sendPayload(String r10, String r11, int r12, String r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r10, "appletId");
        Intrinsics.checkNotNullParameter(r11, "widgetId");
        return this.services.sendPayload(r10, r11, r12, r13, r14);
    }

    @Override // com.obric.widget.host.WidgetHostImplementationServices
    public boolean unregisterWidgetMessenger(int r5, String r10, String r11) {
        return this.services.unregisterWidgetMessenger(r5, r10, r11);
    }

    @Override // com.obric.widget.host.WidgetHostImplementationServices
    public Object updateRenderedWidget(View r10, WidgetDefinitionMetadata r11, int r12, String r13, String r14, Continuation<? super WidgetViewUpdateResult> r15) {
        return this.services.updateRenderedWidget(r10, r11, r12, r13, r14, r15);
    }

    @Override // com.obric.widget.host.WidgetHostImplementationServices
    public String updateWidget(String r5, String r10, int r11, String r12) {
        Intrinsics.checkNotNullParameter(r5, "appletId");
        Intrinsics.checkNotNullParameter(r10, "widgetId");
        return this.services.updateWidget(r5, r10, r11, r12);
    }

    @Override // com.obric.widget.host.WidgetHostImplementationServices
    public boolean updateWidgetView(View r5, WidgetDefinitionMetadata r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "widget");
        return this.services.updateWidgetView(r5, r10, r11);
    }

    @Override // com.obric.widget.host.WidgetHostImplementationServices
    public <T> WidgetProvider<T> widgetProvider() {
        return this.services.widgetProvider();
    }
}
