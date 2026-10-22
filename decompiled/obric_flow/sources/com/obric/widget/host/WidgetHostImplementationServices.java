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
import com.obric.widget.host.runtime.WidgetViewUpdateResult;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000Â\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007\"\b\b\u0000\u0010\b*\u00020\u0001H&J\b\u0010\t\u001a\u00020\nH&J\u001e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003H¦@¢\u0006\u0002\u0010\u000fJ\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\fH¦@¢\u0006\u0002\u0010\u0011J\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u000e\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\u000fJ \u0010\u0014\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\u0016J5\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u0003H&¢\u0006\u0002\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u001fH&J\u0018\u0010 \u001a\u00020\n2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H&J\u0010\u0010%\u001a\u00020\n2\u0006\u0010!\u001a\u00020\"H&J\u0010\u0010&\u001a\u00020\n2\u0006\u0010!\u001a\u00020\"H&J\u0018\u0010'\u001a\u00020(2\u0006\u0010!\u001a\u00020\"2\u0006\u0010)\u001a\u00020(H&J\u0010\u0010*\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001fH&J\u001a\u0010+\u001a\u00020(2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010,\u001a\u0004\u0018\u00010\u0003H&J \u0010-\u001a\u00020\n2\u0006\u0010!\u001a\u00020\"2\u0006\u0010.\u001a\u00020(2\u0006\u0010/\u001a\u00020\u001aH&J\u0010\u00100\u001a\u00020(2\u0006\u0010\u001e\u001a\u00020\u001fH&J\u0018\u00101\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u00102\u001a\u00020\u0003H&J\u0017\u00103\u001a\u0004\u0018\u00010\u001f2\u0006\u00104\u001a\u00020\u001fH&¢\u0006\u0002\u00105J\u0012\u00106\u001a\u0004\u0018\u0001072\u0006\u0010\u001e\u001a\u00020\u001fH&J\u001a\u00108\u001a\u00020\n2\u0006\u0010!\u001a\u00020\"2\b\u0010,\u001a\u0004\u0018\u00010\u0003H&J\b\u00109\u001a\u00020\u0003H&J(\u0010:\u001a\u00020(2\u0006\u0010;\u001a\u00020\u001f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003H&J,\u0010<\u001a\u00020(2\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010;\u001a\u00020\u001f2\n\b\u0002\u0010=\u001a\u0004\u0018\u00010>H&J \u0010?\u001a\u00020(2\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010;\u001a\u00020\u001fH&J(\u0010@\u001a\u00020(2\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010;\u001a\u00020\u001f2\u0006\u0010=\u001a\u00020>H&J(\u0010A\u001a\u00020(2\u0006\u0010;\u001a\u00020\u001f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003H&J.\u0010B\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010;\u001a\u00020\u001f2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0003H&J6\u0010C\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010;\u001a\u00020\u001f2\b\u0010D\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010E\u001a\u00020(H&J*\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020\r2\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u001fH¦@¢\u0006\u0002\u0010KJ$\u0010L\u001a\u00020(2\b\u0010M\u001a\u0004\u0018\u00010G2\u0006\u0010J\u001a\u00020\r2\b\u0010N\u001a\u0004\u0018\u00010\u0003H&J\u001a\u0010O\u001a\u00020(2\b\u0010M\u001a\u0004\u0018\u00010G2\u0006\u0010P\u001a\u00020(H&J\u001a\u0010Q\u001a\u00020(2\b\u0010M\u001a\u0004\u0018\u00010G2\u0006\u0010)\u001a\u00020(H&J\u0012\u0010R\u001a\u00020(2\b\u0010M\u001a\u0004\u0018\u00010GH&J\"\u0010S\u001a\u00020(2\b\u0010M\u001a\u0004\u0018\u00010G2\u0006\u0010T\u001a\u00020\u00032\u0006\u0010U\u001a\u00020VH&J\u001a\u0010W\u001a\u00020(2\b\u0010M\u001a\u0004\u0018\u00010G2\u0006\u0010X\u001a\u00020YH&JR\u0010Z\u001a\u00020(2\b\u0010M\u001a\u0004\u0018\u00010G2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u00032\u0006\u0010;\u001a\u00020\u001f2\u0006\u0010[\u001a\u00020\u00032\b\u0010\\\u001a\u0004\u0018\u00010\u00032\u0006\u0010]\u001a\u00020\u001a2\b\u0010^\u001a\u0004\u0018\u00010\u0003H&J>\u0010_\u001a\u00020(2\b\u0010M\u001a\u0004\u0018\u00010G2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u00032\u0006\u0010;\u001a\u00020\u001f2\u0006\u0010]\u001a\u00020\u001a2\u0006\u0010`\u001a\u00020\u0003H&JH\u0010a\u001a\u00020(2\b\u0010M\u001a\u0004\u0018\u00010G2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u00032\u0006\u0010;\u001a\u00020\u001f2\u0006\u0010b\u001a\u00020\u00032\u0006\u0010c\u001a\u00020\u001a2\b\u0010d\u001a\u0004\u0018\u00010\u0003H&J8\u0010e\u001a\u00020f2\b\u0010M\u001a\u0004\u0018\u00010G2\u0006\u0010J\u001a\u00020\r2\u0006\u0010;\u001a\u00020\u001f2\u0006\u0010g\u001a\u00020\u00032\u0006\u0010h\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010iJ6\u0010j\u001a\u00020k2\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020\r2\u0006\u0010;\u001a\u00020\u001f2\u0006\u0010g\u001a\u00020\u00032\u0006\u0010h\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010lJ\u001e\u0010m\u001a\u00020n2\u0006\u0010J\u001a\u00020\r2\u0006\u0010;\u001a\u00020\u001fH¦@¢\u0006\u0002\u0010oJ\u0018\u0010p\u001a\u00020\n2\u0006\u0010J\u001a\u00020\r2\u0006\u0010;\u001a\u00020\u001fH&J\u0018\u0010q\u001a\u00020r2\u0006\u0010s\u001a\u00020t2\u0006\u0010u\u001a\u00020\u0003H&J\u0012\u0010v\u001a\u00020w2\b\b\u0002\u0010x\u001a\u00020\u001fH&J\b\u0010y\u001a\u00020zH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006{"}, d2 = {"Lcom/obric/widget/host/WidgetHostImplementationServices;", "", "hostId", "", "getHostId", "()Ljava/lang/String;", "widgetProvider", "Lcom/obric/widget/host/runtime/WidgetProvider;", ExifInterface.GPS_DIRECTION_TRUE, "refreshCatalogSync", "", "getWidgets", "", "Lcom/obric/widget/host/runtime/WidgetDefinitionMetadata;", "appletId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAppletIds", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAppletInfo", "Lcom/obric/widget/host/runtime/WidgetAppletInfo;", "getWidgetInfo", "widgetId", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ensureWidgetAvailable", "Lcom/obric/widget/host/runtime/WidgetAvailability;", "preferredVersion", "", "scene", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)Lcom/obric/widget/host/runtime/WidgetAvailability;", "describeRecord", "hostWidgetInstanceId", "", "bindInstance", "snapshot", "Lcom/obric/widget/host/runtime/WidgetInstanceSnapshot;", "bindReason", "Lcom/obric/widget/host/runtime/WidgetBindReason;", "onViewAttached", "onViewDetached", "onViewVisibilityChanged", "", "isVisible", "currentDirtyVersion", "markDirty", "reason", "onRenderCompleted", "success", "renderedDirtyVersion", "isDestroyed", "resolvePreferredRefreshReason", "fallbackReason", "findHostWidgetInstanceIdByAppWidgetId", "appWidgetId", "(I)Ljava/lang/Integer;", "peekRecord", "Lcom/obric/widget/host/runtime/WidgetInstanceRecord;", "onInstanceRemoved", "dumpInstanceState", "clearWidgetData", "instanceId", "dispatchWidgetBind", "messenger", "Landroid/os/Messenger;", "dispatchWidgetUnbind", "registerWidgetMessenger", "unregisterWidgetMessenger", "updateWidget", "sendPayload", "payload", "waitForResult", "createWidget", "Landroid/view/View;", "context", "Landroid/content/Context;", "widget", "(Landroid/content/Context;Lcom/obric/widget/host/runtime/WidgetDefinitionMetadata;Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateWidgetView", "widgetView", "widgetData", "dispatchWidgetThemeChanged", "isNightMode", "dispatchWidgetVisibilityChanged", "destroyWidgetHost", "sendEventToWidget", "eventName", LynxResourceModule.PARAMS_KEY, "Lcom/google/gson/JsonObject;", "dispatchWidgetDataChanged", "event", "Lcom/obric/widget/host/runtime/WidgetDataChangedEvent;", "dispatchWidgetSystemChanged", "type", "action", "timeMillis", "timeZone", "dispatchWidgetForeground", "source", "dispatchWidgetPackageChanged", Constant.APPID, "versionCode", "resourceType", "updateRenderedWidget", "Lcom/obric/widget/host/runtime/WidgetViewUpdateResult;", "renderReason", "logTag", "(Landroid/view/View;Lcom/obric/widget/host/runtime/WidgetDefinitionMetadata;ILjava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createWidgetWithSnapshotPrime", "Lcom/obric/widget/host/runtime/WidgetCreateViewResult;", "(Landroid/content/Context;Lcom/obric/widget/host/runtime/WidgetDefinitionMetadata;ILjava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitPrefetchedPayload", "Lcom/obric/widget/host/runtime/PayloadConsumeResult;", "(Lcom/obric/widget/host/runtime/WidgetDefinitionMetadata;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearPrefetchedPayload", "createRuntimeBindingController", "Lcom/obric/widget/host/runtime/WidgetRuntimeBindingController;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "tag", "createRuntimeBindingSession", "Lcom/obric/widget/host/runtime/WidgetRuntimeBindingSession;", "invalidInstanceId", "createRenderScheduler", "Lcom/obric/widget/host/runtime/WidgetRenderScheduler;", "widget-host-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@WidgetHostImplementationApi
public interface WidgetHostImplementationServices {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ boolean clearWidgetData$default(WidgetHostImplementationServices r5, int r10, String r11, String r12, int r13, Object r14) {
            if (r14 != null) goto L12;
            if ((r13 & 2) == 0) goto L7;
            r11 = null;
        L7:
            if ((r13 & 4) == 0) goto L10;
            r12 = null;
        L10:
            return r5.clearWidgetData(r10, r11, r12);
        L12:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: clearWidgetData");
        }

        public static /* synthetic */ WidgetRuntimeBindingSession createRuntimeBindingSession$default(WidgetHostImplementationServices r5, int r10, int r11, Object r12) {
            if (r12 != null) goto L9;
            if ((r11 & 1) == 0) goto L7;
            r10 = -1;
        L7:
            return r5.createRuntimeBindingSession(r10);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createRuntimeBindingSession");
        }

        public static /* synthetic */ Object createWidget$default(WidgetHostImplementationServices r5, Context r10, WidgetDefinitionMetadata r11, Integer r12, Continuation r13, int r14, Object r15) {
            if (r15 != null) goto L9;
            if ((r14 & 4) == 0) goto L7;
            r12 = null;
        L7:
            return r5.createWidget(r10, r11, r12, r13);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createWidget");
        }

        public static /* synthetic */ boolean dispatchWidgetBind$default(WidgetHostImplementationServices r5, String r10, String r11, int r12, Messenger r13, int r14, Object r15) {
            if (r15 != null) goto L9;
            if ((r14 & 8) == 0) goto L7;
            r13 = null;
        L7:
            return r5.dispatchWidgetBind(r10, r11, r12, r13);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: dispatchWidgetBind");
        }

        public static /* synthetic */ WidgetAvailability ensureWidgetAvailable$default(WidgetHostImplementationServices r5, String r10, String r11, Long r12, String r13, int r14, Object r15) {
            if (r15 != null) goto L12;
            if ((r14 & 4) == 0) goto L7;
            r12 = null;
        L7:
            if ((r14 & 8) == 0) goto L10;
            r13 = "manual";
        L10:
            return r5.ensureWidgetAvailable(r10, r11, r12, r13);
        L12:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: ensureWidgetAvailable");
        }

        public static /* synthetic */ String sendPayload$default(WidgetHostImplementationServices r10, String r11, String r12, int r13, String r14, boolean r15, int r16, Object r17) {
            if (r17 != null) goto L9;
            if ((r16 & 16) == 0) goto L7;
            r15 = false;
        L7:
            return r10.sendPayload(r11, r12, r13, r14, r15);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendPayload");
        }

        public static /* synthetic */ boolean unregisterWidgetMessenger$default(WidgetHostImplementationServices r5, int r10, String r11, String r12, int r13, Object r14) {
            if (r14 != null) goto L12;
            if ((r13 & 2) == 0) goto L7;
            r11 = null;
        L7:
            if ((r13 & 4) == 0) goto L10;
            r12 = null;
        L10:
            return r5.unregisterWidgetMessenger(r10, r11, r12);
        L12:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: unregisterWidgetMessenger");
        }

        public static /* synthetic */ String updateWidget$default(WidgetHostImplementationServices r5, String r10, String r11, int r12, String r13, int r14, Object r15) {
            if (r15 != null) goto L9;
            if ((r14 & 8) == 0) goto L7;
            r13 = null;
        L7:
            return r5.updateWidget(r10, r11, r12, r13);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateWidget");
        }
    }

    Object awaitPrefetchedPayload(WidgetDefinitionMetadata r5, int r10, Continuation<? super PayloadConsumeResult> r11);

    void bindInstance(WidgetInstanceSnapshot r5, WidgetBindReason r10);

    void clearPrefetchedPayload(WidgetDefinitionMetadata r5, int r10);

    boolean clearWidgetData(int r5, String r10, String r11);

    WidgetRenderScheduler createRenderScheduler();

    WidgetRuntimeBindingController createRuntimeBindingController(CoroutineScope r5, String r10);

    WidgetRuntimeBindingSession createRuntimeBindingSession(int r5);

    Object createWidget(Context r5, WidgetDefinitionMetadata r10, Integer r11, Continuation<? super View> r12);

    Object createWidgetWithSnapshotPrime(Context r5, WidgetDefinitionMetadata r10, int r11, String r12, String r13, Continuation<? super WidgetCreateViewResult> r14);

    long currentDirtyVersion(int r5);

    String describeRecord(int r5);

    boolean destroyWidgetHost(View r5);

    boolean dispatchWidgetBind(String r5, String r10, int r11, Messenger r12);

    boolean dispatchWidgetDataChanged(View r5, WidgetDataChangedEvent r10);

    boolean dispatchWidgetForeground(View r5, String r10, String r11, int r12, long r13, String r14);

    boolean dispatchWidgetPackageChanged(View r5, String r10, String r11, int r12, String r13, long r14, String r15);

    boolean dispatchWidgetSystemChanged(View r5, String r10, String r11, int r12, String r13, String r14, long r15, String r16);

    boolean dispatchWidgetThemeChanged(View r5, boolean r10);

    boolean dispatchWidgetUnbind(String r5, String r10, int r11);

    boolean dispatchWidgetVisibilityChanged(View r5, boolean r10);

    String dumpInstanceState();

    WidgetAvailability ensureWidgetAvailable(String r5, String r10, Long r11, String r12);

    Integer findHostWidgetInstanceIdByAppWidgetId(int r5);

    Object getAppletIds(Continuation<? super List<String>> r5);

    Object getAppletInfo(String r5, Continuation<? super WidgetAppletInfo> r10);

    String getHostId();

    Object getWidgetInfo(String r5, String r10, Continuation<? super WidgetDefinitionMetadata> r11);

    Object getWidgets(String r5, Continuation<? super List<WidgetDefinitionMetadata>> r10);

    boolean isDestroyed(int r5);

    boolean markDirty(int r5, String r10);

    void onInstanceRemoved(WidgetInstanceSnapshot r5, String r10);

    void onRenderCompleted(WidgetInstanceSnapshot r5, boolean r10, long r11);

    void onViewAttached(WidgetInstanceSnapshot r5);

    void onViewDetached(WidgetInstanceSnapshot r5);

    boolean onViewVisibilityChanged(WidgetInstanceSnapshot r5, boolean r10);

    WidgetInstanceRecord peekRecord(int r5);

    void refreshCatalogSync();

    boolean registerWidgetMessenger(String r5, String r10, int r11, Messenger r12);

    String resolvePreferredRefreshReason(int r5, String r10);

    boolean sendEventToWidget(View r5, String r10, JsonObject r11);

    String sendPayload(String r5, String r10, int r11, String r12, boolean r13);

    boolean unregisterWidgetMessenger(int r5, String r10, String r11);

    Object updateRenderedWidget(View r5, WidgetDefinitionMetadata r10, int r11, String r12, String r13, Continuation<? super WidgetViewUpdateResult> r14);

    String updateWidget(String r5, String r10, int r11, String r12);

    boolean updateWidgetView(View r5, WidgetDefinitionMetadata r10, String r11);

    <T> WidgetProvider<T> widgetProvider();
}
