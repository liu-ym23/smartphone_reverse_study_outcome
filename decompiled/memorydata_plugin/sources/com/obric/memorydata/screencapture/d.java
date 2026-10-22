package com.obric.memorydata.screencapture;

import android.content.Context;
import android.graphics.Bitmap;
import android.hardware.HardwareBuffer;
import android.os.Build;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import androidx.core.app.NotificationCompat;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.screencapture.accessibility.AccessibilityRuleStatus;
import com.obric.memorydata.screencapture.monitor.e;
import com.obric.memorydata.sdk.screencapture.ScreenData;
import com.obric.memorydata.sdk.screencapture.ScreenEventReaction;
import com.obric.memorydata.sdk.screencapture.TaskOptions;
import com.obric.memorydata.sdk.screencapture.ViewTreeNode;
import com.obric.memorydata.sdk.screencapture.event.AppAccessibilityEvent;
import com.obric.memorydata.sdk.screencapture.event.AppStateEvent;
import com.obric.memorydata.sdk.screencapture.event.InputMethodEvent;
import com.obric.memorydata.sdk.screencapture.event.ScreenEvent;
import com.obric.memorydata.sdk.screencapture.event.ScreenTouchEvent;
import com.obric.memorydata.sdk.screencapture.rule.AppAccessibilityEventRule;
import com.obric.memorydata.sdk.screencapture.rule.ScreenEventRule;
import com.obric.memorydata.sdk.screencapture.rule.ScreenTouchEventRule;
import com.obric.memorydata.sdk.screencapture.rule.ScreenshotOption;
import com.obric.memorydata.sdk.screencapture.rule.ViewTreeOption;
import com.obric.memorydata.utils.af;
import com.obric.memorydata.utils.j;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.bx;
import kotlinx.coroutines.channels.i;
import kotlinx.coroutines.channels.l;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000Å\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\"\n\u0002\b\n*\u0001%\u0018\u0000 `2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001`B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010'\u001a\u00020\t2\u0006\u0010(\u001a\u00020\u00132\u0006\u0010)\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020\u0014J\u000e\u0010+\u001a\u00020\t2\u0006\u0010,\u001a\u00020!J\u0010\u0010-\u001a\u00020\"2\b\u0010.\u001a\u0004\u0018\u00010!J\b\u0010/\u001a\u000200H\u0002J\u0010\u00101\u001a\u0002002\b\u00102\u001a\u0004\u0018\u00010!J\u0014\u00103\u001a\u000200*\u0002042\u0006\u00102\u001a\u00020!H\u0002J\b\u00105\u001a\u00020\tH\u0002J\u0010\u00106\u001a\u00020\t2\u0006\u00107\u001a\u000200H\u0016J2\u00108\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000e2\f\u00109\u001a\b\u0012\u0004\u0012\u00020\u00130:2\u0006\u0010;\u001a\u00020!H\u0082@¢\u0006\u0002\u0010<J\u001e\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020!H\u0086@¢\u0006\u0002\u0010BJ6\u0010C\u001a\u0014\u0012\u0004\u0012\u00020D\u0012\n\u0012\b\u0012\u0004\u0012\u00020F0E0\u000e2\f\u00109\u001a\b\u0012\u0004\u0012\u00020\u00130:2\u0006\u0010G\u001a\u00020HH\u0082@¢\u0006\u0002\u0010IJ\u0010\u0010J\u001a\u00020\t2\u0006\u0010G\u001a\u00020\u000bH\u0016J\u0010\u0010K\u001a\u00020\t2\u0006\u0010L\u001a\u00020MH\u0016J\u0010\u0010N\u001a\u00020\t2\u0006\u0010(\u001a\u00020\u0013H\u0002J\u0018\u0010O\u001a\u00020\t2\u0006\u0010P\u001a\u00020!2\u0006\u00102\u001a\u00020!H\u0016J\u0018\u0010Q\u001a\u00020\t2\u0006\u0010P\u001a\u00020!2\u0006\u00102\u001a\u00020!H\u0016J\b\u0010R\u001a\u00020\tH\u0002J\u0010\u0010S\u001a\u0002002\u0006\u0010G\u001a\u00020HH\u0002J\u0010\u0010T\u001a\u00020\t2\u0006\u0010U\u001a\u00020HH\u0002J\u001e\u0010V\u001a\u0002002\f\u00109\u001a\b\u0012\u0004\u0012\u00020\u00130W2\u0006\u0010G\u001a\u00020HH\u0002J\u0010\u0010X\u001a\u0002002\u0006\u0010G\u001a\u00020HH\u0002J\u001c\u0010Y\u001a\u00020\t2\u0006\u0010G\u001a\u00020H2\n\b\u0002\u0010Z\u001a\u0004\u0018\u00010\u0010H\u0002Jd\u0010[\u001a\u00020\t2\u0006\u0010G\u001a\u00020H2\u0012\u0010\\\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u000e2\b\u0010Z\u001a\u0004\u0018\u00010\u00102\u0014\u0010]\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000e2\u0018\u0010^\u001a\u0014\u0012\u0004\u0012\u00020D\u0012\n\u0012\b\u0012\u0004\u0012\u00020F0E0\u000eH\u0082@¢\u0006\u0002\u0010_R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\f\u001a\u0018\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000e\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\"0 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u00020%X\u0082\u0004¢\u0006\u0004\n\u0002\u0010&¨\u0006a"}, d2 = {"Lcom/obric/memorydata/screencapture/ScreenCaptureController;", "Lcom/obric/memorydata/screencapture/monitor/IInputMethodStateChangeListener;", "Lcom/obric/memorydata/screencapture/monitor/UserInputDetector$ScreenTouchEventListener;", "Lcom/obric/memorydata/screencapture/accessibility/AccessibilityRuleMatchListener;", "Lcom/obric/memorydata/utils/MemoryAppStateListener$AppSwitchListener;", "<init>", "()V", "tapSkipChannel", "Lkotlinx/coroutines/channels/Channel;", "", "pendingEvent", "Lcom/obric/memorydata/sdk/screencapture/event/ScreenTouchEvent;", "cacheScreenshotRef", "Ljava/lang/ref/WeakReference;", "", "Lcom/obric/memorydata/sdk/screencapture/rule/ScreenshotOption;", "", "reactionCallbackMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/obric/memorydata/sdk/screencapture/ScreenEventReaction;", "Lcom/obric/memorydata/sdk/screencapture/IEventReactionCallback;", "userInputDetector", "Lcom/obric/memorydata/screencapture/monitor/UserInputDetector;", "getUserInputDetector", "()Lcom/obric/memorydata/screencapture/monitor/UserInputDetector;", "doubleTapTimeout", "", "delayEventJob", "Lkotlinx/coroutines/Job;", "timeoutMsgId", "Ljava/util/concurrent/atomic/AtomicInteger;", "timeoutReactionMap", "", "", "", "lock", "handler", "com/obric/memorydata/screencapture/ScreenCaptureController$handler$1", "Lcom/obric/memorydata/screencapture/ScreenCaptureController$handler$1;", "register", "reaction", LocationMonitorConst.TIMEOUT, "callback", "unregister", "reactionId", "getScreenEventReactionCount", "sourcePkg", "hasViewTreeRequest", "", "hasViewTreeRequestForPackage", ObricMemoryConstants.KEY_PACKAGE_NAME, "mayTargetPackage", "Lcom/obric/memorydata/sdk/screencapture/rule/ScreenEventRule;", "destroy", "onImeVisibleChanged", "shown", "generateScreenshot", "reactions", "", "targetPkg", "(Ljava/util/Collection;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "captureCurrent", "Lcom/obric/memorydata/sdk/screencapture/ScreenData;", "options", "Lcom/obric/memorydata/sdk/screencapture/TaskOptions;", "targetPackage", "(Lcom/obric/memorydata/sdk/screencapture/TaskOptions;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "generateViewTree", "Lcom/obric/memorydata/sdk/screencapture/rule/ViewTreeOption;", "", "Lcom/obric/memorydata/sdk/screencapture/ViewTreeNode;", "event", "Lcom/obric/memorydata/sdk/screencapture/event/ScreenEvent;", "(Ljava/util/Collection;Lcom/obric/memorydata/sdk/screencapture/event/ScreenEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onScreenTouchEvent", "onAccessibilityRuleMatched", "ruleStatus", "Lcom/obric/memorydata/screencapture/accessibility/AccessibilityRuleStatus;", "onMatched", "onAppOpen", "appName", "onAppClose", "triggerPendingTapEvent", "isPendingEvent", "cancelPendingEventIfNeeded", "newEvent", "needCopyScreenshot", "", "isReuseOtherEvent", "dispatchEvent", "screenshot", "dispatchEventInternal", "relativeReactions", "screenshotOptionMap", "viewTreeMap", "(Lcom/obric/memorydata/sdk/screencapture/event/ScreenEvent;Ljava/util/Map;Ljava/lang/Object;Ljava/util/Map;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "screen_capture_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class d implements com.obric.memorydata.screencapture.accessibility.b, com.obric.memorydata.screencapture.monitor.a, e.b, af.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12797a = null;
    private static volatile d m;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final i<Unit> f12798b;
    private ScreenTouchEvent c;
    private WeakReference<Map<ScreenshotOption, Object>> d;
    private final ConcurrentHashMap<ScreenEventReaction, com.obric.memorydata.sdk.screencapture.d> e;
    private final e f;
    private final long g;
    private bx h;
    private AtomicInteger i;
    private final Map<String, Integer> j;
    private final Object k;
    private final c l;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/screencapture/ScreenCaptureController$Companion;", "", "<init>", "()V", "TAG", "", "instance", "Lcom/obric/memorydata/screencapture/ScreenCaptureController;", "get", "destroy", "", "screen_capture_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final d a() {
            d r0 = d.b();
            if (r0 != null) goto L13;
            monitor-enter(this);
            r0 = d.b();     // Catch: Throwable -> L10
            if (r0 != null) goto L8;
            r0 = new d(null);     // Catch: Throwable -> L10
            a r1 = d.f12797a;     // Catch: Throwable -> L10
            d.a(r0);     // Catch: Throwable -> L10
        L8:
            monitor-exit(this);
        L10:
            th = move-exception;
            throw th;
        L13:
            return r0;
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f12799a = null;

        static {
            int[] r0 = new int[ScreenEvent.EventType.values().length];
            r0[ScreenEvent.EventType.TOUCH.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[ScreenEvent.EventType.APP_STATE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[ScreenEvent.EventType.INPUT_METHOD.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[ScreenEvent.EventType.ACCESSIBILITY.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f12799a = r0;
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/memorydata/screencapture/ScreenCaptureController$handler$1", "Landroid/os/Handler;", "handleMessage", "", NotificationCompat.CATEGORY_MESSAGE, "Landroid/os/Message;", "screen_capture_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f12800a;

        c(d r1, Looper r2) {
            this.f12800a = r1;
            super(r2);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r9) {
            Intrinsics.checkNotNullParameter(r9, NotificationCompat.CATEGORY_MESSAGE);
            super.handleMessage(r9);
            Object r10 = r9.obj;
            Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type kotlin.String");
            String r11 = (String) ZeusTransformUtils.preCheckCast(r10, String.class, "com.obric.memorydata.plugin");
            Set r0 = d.f(this.f12800a).keySet();
            Intrinsics.checkNotNullExpressionValue(r0, "<get-keys>(...)");
            Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        L4:
            if (r1.hasNext() == false) goto L8;
            Object r2 = r1.next();
            if (Intrinsics.areEqual(((ScreenEventReaction) ZeusTransformUtils.preCheckCast(r2, ScreenEventReaction.class, "com.obric.memorydata.plugin")).getId(), r11) == false) goto L4;
        L9:
            ScreenEventReaction r3 = (ScreenEventReaction) ZeusTransformUtils.preCheckCast(r2, ScreenEventReaction.class, "com.obric.memorydata.plugin");
            if (r3 == null) goto L26;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenCaptureController", r3 + " timeout", false, 4, null);
            Object r4 = d.g(this.f12800a);
            d r8 = this.f12800a;
            monitor-enter(r4);
            com.obric.memorydata.sdk.screencapture.d r5 = (com.obric.memorydata.sdk.screencapture.d) ZeusTransformUtils.preCheckCast(d.f(r8).get(r3), com.obric.memorydata.sdk.screencapture.d.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17 DeadObjectException -> L19
            if (r5 == null) goto L21;
            r5.a(301, "rule match timeout");     // Catch: Throwable -> L17 DeadObjectException -> L19
        L21:
            r8.a(r11);     // Catch: Throwable -> L17
            Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L17
            monitor-exit(r4);
            return;
        L17:
            th = move-exception;
            throw th;
        L19:
            e = move-exception;
            e.printStackTrace();     // Catch: Throwable -> L17
            goto L21
        L26:
            return;
        L8:
            r2 = null;
            goto L9
        }
    }

    static {
        f12797a = new a(null);
    }

    private d() {
        this.f12798b = l.a(1, null, null, 6, null);
        this.e = new ConcurrentHashMap();
        this.f = new e();
        this.g = ViewConfiguration.getDoubleTapTimeout();
        this.i = new AtomicInteger(100);
        this.j = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        this.k = new Object();
        this.l = new c(this, Looper.getMainLooper());
    }

    public /* synthetic */ d(DefaultConstructorMarker r1) {
        this();
    }

    public static final /* synthetic */ Object a(d r9, ScreenEvent r10, Map r11, Object r12, Map r13, Map r14, Continuation r15) {
        return r9.a(r10, (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.memorydata.plugin"), r12, (Map) ZeusTransformUtils.wrapperContextForParams(r13, Map.class, "com.obric.memorydata.plugin"), (Map) ZeusTransformUtils.wrapperContextForParams(r14, Map.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r15, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ Object a(d r2, Collection r3, ScreenEvent r4, Continuation r5) {
        return r2.a((Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin"), r4, (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ Object a(d r2, Collection r3, String r4, Continuation r5) {
        return r2.a((Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin"), r4, (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:67:0x0381 -> B:68:0x038c). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:77:0x03e5 -> B:79:0x03ec). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:78:0x03e9 -> B:79:0x03ec). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:80:0x03f0 -> B:81:0x03f4). Please report as a decompilation issue!!! */
    private final Object a(ScreenEvent r24, Map<ScreenEventReaction, ? extends com.obric.memorydata.sdk.screencapture.d> r25, Object r26, Map<ScreenshotOption, ? extends Object> r27, Map<ViewTreeOption, ? extends List<ViewTreeNode>> r28, Continuation<? super Unit> r29) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r25, Map.class, "com.obric.memorydata.plugin");
        Map r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r27, Map.class, "com.obric.memorydata.plugin");
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r28, Map.class, "com.obric.memorydata.plugin");
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r29, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, ScreenCaptureController$dispatchEventInternal$1.class) == false) goto L7;
        ScreenCaptureController$dispatchEventInternal$1 r6 = (ScreenCaptureController$dispatchEventInternal$1) ZeusTransformUtils.preCheckCast(r5, ScreenCaptureController$dispatchEventInternal$1.class, "com.obric.memorydata.plugin");
        if ((r6.label & Integer.MIN_VALUE) == 0) goto L7;
        r6.label -= Integer.MIN_VALUE;
        d r7 = this;
    L8:
        Object r8 = r6.result;
        Object r9 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r10 = r6.label;
        if (r10 == 0) goto L16;
        if (r10 == 1) goto L15;
        if (r10 != 2) goto L14;
        ScreenData r2 = (ScreenData) ZeusTransformUtils.preCheckCast(r6.L$10, ScreenData.class, "com.obric.memorydata.plugin");
        ScreenData r11 = (ScreenData) ZeusTransformUtils.preCheckCast(r6.L$9, ScreenData.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.sdk.screencapture.d r12 = (com.obric.memorydata.sdk.screencapture.d) ZeusTransformUtils.preCheckCast(r6.L$8, com.obric.memorydata.sdk.screencapture.d.class, "com.obric.memorydata.plugin");
        ScreenEventReaction r13 = (ScreenEventReaction) ZeusTransformUtils.preCheckCast(r6.L$7, ScreenEventReaction.class, "com.obric.memorydata.plugin");
        Iterator r14 = (Iterator) ZeusTransformUtils.preCheckCast(r6.L$6, Iterator.class, "com.obric.memorydata.plugin");
        Map r15 = (Map) ZeusTransformUtils.preCheckCast(r6.L$5, Map.class, "com.obric.memorydata.plugin");
        Map r16 = (Map) ZeusTransformUtils.preCheckCast(r6.L$4, Map.class, "com.obric.memorydata.plugin");
        Object r17 = r6.L$3;
        Map r18 = (Map) ZeusTransformUtils.preCheckCast(r6.L$2, Map.class, "com.obric.memorydata.plugin");
        ScreenEvent r19 = (ScreenEvent) ZeusTransformUtils.preCheckCast(r6.L$1, ScreenEvent.class, "com.obric.memorydata.plugin");
        d r0 = (d) ZeusTransformUtils.preCheckCast(r6.L$0, d.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r8);
        Map r110 = r15;
        ScreenData r111 = r2;
    L69:
        if (ZeusTransformUtils.instanceOf(r8, HardwareBuffer.class) == false) goto L71;
        HardwareBuffer r20 = (HardwareBuffer) ZeusTransformUtils.preCheckCast(r8, HardwareBuffer.class, "com.obric.memorydata.plugin");
    L72:
        r111.setHardwareBuffer(r20);
        r1 = r18;
        ScreenEvent r21 = r19;
        com.obric.memorydata.sdk.screencapture.d r112 = r12;
        ScreenEventReaction r113 = r13;
        r4 = r110;
        r7 = r0;
        Object r22 = r17;
        ScreenData r114 = r11;
        r3 = r16;
    L79:
        Map r115 = r1;
        Object r23 = r22;
    L82:
        if (r113.getTaskOptions().getViewTree() == null) goto L91;
        r114.setViewTree((List) ZeusTransformUtils.preCheckCast(r4.get(r113.getTaskOptions().getViewTree()), List.class, "com.obric.memorydata.plugin"));
    L91:
        r112.a(r21, r114);     // Catch: DeadObjectException -> L86
    L88:
        r22 = r23;
        r1 = r115;
    L22:
        if (r14.hasNext() == false) goto L90;
        Map.Entry r116 = (Map.Entry) ZeusTransformUtils.preCheckCast(r14.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r113 = (ScreenEventReaction) ZeusTransformUtils.preCheckCast(r116.getKey(), ScreenEventReaction.class, "com.obric.memorydata.plugin");
        r112 = (com.obric.memorydata.sdk.screencapture.d) ZeusTransformUtils.preCheckCast(r116.getValue(), com.obric.memorydata.sdk.screencapture.d.class, "com.obric.memorydata.plugin");
        r7.a(r113);
        ScreenData r117 = new ScreenData(null, null, null, false, null, 31, null);
        if (r22 != null) goto L26;
        r111 = r117;
        ScreenshotOption r118 = r113.getTaskOptions().getScreenshot();
        if (r118 == null) goto L80;
        Object r119 = r3.get(r118);
        if (r119 != null) goto L41;
        r114 = r111;
        goto L79
    L41:
        if (ZeusTransformUtils.instanceOf(r119, Bitmap.class) == false) goto L59;
        if (((Bitmap) ZeusTransformUtils.preCheckCast(r119, Bitmap.class, "com.obric.memorydata.plugin")).isRecycled() == false) goto L54;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenCaptureController", "screenshot is recycled", null, 4, null);
        com.obric.memorydata.screencapture.accessibility.e r120 = com.obric.memorydata.screencapture.accessibility.e.f12780a;
        String r121 = r21.getPackageName();
        r6.L$0 = r7;
        r6.L$1 = r21;
        r6.L$2 = r1;
        r6.L$3 = r22;
        r6.L$4 = r3;
        r6.L$5 = r4;
        r6.L$6 = r14;
        r6.L$7 = r113;
        r6.L$8 = r112;
        r6.L$9 = r111;
        r6.L$10 = r111;
        r6.label = 1;
        Object r122 = r120.a(r118, r121, r6);
        if (r122 != r9) goto L47;
        return r9;
    L47:
        Object r123 = r22;
        ScreenEvent r124 = r21;
        d r30 = r7;
        r8 = r122;
        ScreenEventReaction r31 = r113;
        Map r125 = r3;
        Map r126 = r4;
        ScreenData r32 = r111;
        com.obric.memorydata.sdk.screencapture.d r33 = r112;
        Map r127 = r1;
        ScreenData r34 = r32;
    L49:
        if (ZeusTransformUtils.instanceOf(r8, Bitmap.class) == false) goto L93;
        r34.setScreenshot((Bitmap) ZeusTransformUtils.preCheckCast(r8, Bitmap.class, "com.obric.memorydata.plugin"));
        r114 = r32;
        r3 = r125;
        r1 = r127;
        r21 = r124;
        r113 = r31;
        r7 = r30;
        r22 = r123;
        Map r210 = r126;
        r112 = r33;
        r4 = r210;
        goto L79
    L93:
        r34.setScreenshot(null);
        r114 = r32;
        r3 = r125;
        r1 = r127;
        r21 = r124;
        r113 = r31;
        r7 = r30;
        r22 = r123;
        Map r211 = r126;
        r112 = r33;
        r4 = r211;
        goto L79
    L54:
        if (r7.a(r1.keySet(), r21) == false) goto L56;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenCaptureController", "copy screenshot for event " + r21, false, 4, null);
        Bitmap r128 = ((Bitmap) ZeusTransformUtils.preCheckCast(r119, Bitmap.class, "com.obric.memorydata.plugin")).copy(((Bitmap) ZeusTransformUtils.preCheckCast(r119, Bitmap.class, "com.obric.memorydata.plugin")).getConfig(), true);
    L57:
        r111.setScreenshot(r128);
        r112 = r112;
        Map r129 = r1;
    L77:
        r114 = r111;
        r1 = r129;
        goto L79
    L56:
        r128 = (Bitmap) ZeusTransformUtils.preCheckCast(r119, Bitmap.class, "com.obric.memorydata.plugin");
        goto L57
    L59:
        if (Build.VERSION.SDK_INT >= 29) goto L61;
    L74:
        r112 = r112;
        r129 = r1;
        if (ZeusTransformUtils.instanceOf(r119, com.obric.memorydata.screencapture.accessibility.e.b.class) == false) goto L77;
        r111.setHeifScreenshotPath(((com.obric.memorydata.screencapture.accessibility.e.b) ZeusTransformUtils.preCheckCast(r119, com.obric.memorydata.screencapture.accessibility.e.b.class, "com.obric.memorydata.plugin")).a());
        r111.setVertical(((com.obric.memorydata.screencapture.accessibility.e.b) ZeusTransformUtils.preCheckCast(r119, com.obric.memorydata.screencapture.accessibility.e.b.class, "com.obric.memorydata.plugin")).b());
        goto L77
    L61:
        if (ZeusTransformUtils.instanceOf(r119, HardwareBuffer.class) == false) goto L74;
        if (((HardwareBuffer) ZeusTransformUtils.preCheckCast(r119, HardwareBuffer.class, "com.obric.memorydata.plugin")).isClosed() == false) goto L73;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenCaptureController", "hardwareBuffer is closed", null, 4, null);
        com.obric.memorydata.screencapture.accessibility.e r130 = com.obric.memorydata.screencapture.accessibility.e.f12780a;
        String r131 = r21.getPackageName();
        r6.L$0 = r7;
        r6.L$1 = r21;
        r6.L$2 = r1;
        r6.L$3 = r22;
        r6.L$4 = r3;
        r6.L$5 = r4;
        r6.L$6 = r14;
        r6.L$7 = r113;
        r6.L$8 = r112;
        r6.L$9 = r111;
        r6.L$10 = r111;
        Map r132 = r1;
        r6.label = 2;
        Object r133 = r130.a(r118, r131, r6);
        if (r133 != r9) goto L67;
        return r9;
    L67:
        r16 = r3;
        r110 = r4;
        r11 = r111;
        r12 = r112;
        r17 = r22;
        r0 = r7;
        r13 = r113;
        r19 = r21;
        r8 = r133;
        r18 = r132;
        goto L69
    L73:
        r112 = r112;
        r129 = r1;
        r111.setHardwareBuffer((HardwareBuffer) ZeusTransformUtils.preCheckCast(r119, HardwareBuffer.class, "com.obric.memorydata.plugin"));
    L80:
        r115 = r1;
        r23 = r22;
        r114 = r111;
        goto L82
    L26:
        if (ZeusTransformUtils.instanceOf(r22, Bitmap.class) == false) goto L28;
        r111 = r117;
        r111.setScreenshot((Bitmap) ZeusTransformUtils.preCheckCast(r22, Bitmap.class, "com.obric.memorydata.plugin"));
        goto L80
    L28:
        r111 = r117;
        if (Build.VERSION.SDK_INT < 29) goto L34;
        if (ZeusTransformUtils.instanceOf(r22, HardwareBuffer.class) == false) goto L34;
        r111.setHardwareBuffer((HardwareBuffer) ZeusTransformUtils.preCheckCast(r22, HardwareBuffer.class, "com.obric.memorydata.plugin"));
    L34:
        if (ZeusTransformUtils.instanceOf(r22, com.obric.memorydata.screencapture.accessibility.e.b.class) == false) goto L80;
        r111.setHeifScreenshotPath(((com.obric.memorydata.screencapture.accessibility.e.b) ZeusTransformUtils.preCheckCast(r22, com.obric.memorydata.screencapture.accessibility.e.b.class, "com.obric.memorydata.plugin")).a());
        r111.setVertical(((com.obric.memorydata.screencapture.accessibility.e.b) ZeusTransformUtils.preCheckCast(r22, com.obric.memorydata.screencapture.accessibility.e.b.class, "com.obric.memorydata.plugin")).b());
        goto L80
    L90:
        return Unit.INSTANCE;
    L86:
        e = move-exception;
        e.printStackTrace();
        goto L88
    L71:
        r20 = null;
        goto L72
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r34 = (ScreenData) ZeusTransformUtils.preCheckCast(r6.L$10, ScreenData.class, "com.obric.memorydata.plugin");
        r32 = (ScreenData) ZeusTransformUtils.preCheckCast(r6.L$9, ScreenData.class, "com.obric.memorydata.plugin");
        r33 = (com.obric.memorydata.sdk.screencapture.d) ZeusTransformUtils.preCheckCast(r6.L$8, com.obric.memorydata.sdk.screencapture.d.class, "com.obric.memorydata.plugin");
        r31 = (ScreenEventReaction) ZeusTransformUtils.preCheckCast(r6.L$7, ScreenEventReaction.class, "com.obric.memorydata.plugin");
        r14 = (Iterator) ZeusTransformUtils.preCheckCast(r6.L$6, Iterator.class, "com.obric.memorydata.plugin");
        r126 = (Map) ZeusTransformUtils.preCheckCast(r6.L$5, Map.class, "com.obric.memorydata.plugin");
        r125 = (Map) ZeusTransformUtils.preCheckCast(r6.L$4, Map.class, "com.obric.memorydata.plugin");
        r123 = r6.L$3;
        r127 = (Map) ZeusTransformUtils.preCheckCast(r6.L$2, Map.class, "com.obric.memorydata.plugin");
        r124 = (ScreenEvent) ZeusTransformUtils.preCheckCast(r6.L$1, ScreenEvent.class, "com.obric.memorydata.plugin");
        r30 = (d) ZeusTransformUtils.preCheckCast(r6.L$0, d.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r8);
        goto L49
    L16:
        ResultKt.throwOnFailure(r8);
        if (r1.isEmpty() == true) goto L19;
        r21 = r24;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenCaptureController", "dispatch event: " + r21, false, 4, null);
        r14 = r1.entrySet().iterator();
        r22 = r26;
        goto L22
    L19:
        return Unit.INSTANCE;
    L7:
        r7 = this;
        r6 = new ScreenCaptureController$dispatchEventInternal$1(r7, r5);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [com.obric.memorydata.screencapture.assist.a] */
    /* JADX WARN: Type inference failed for: r2v28, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v29 */
    /* JADX WARN: Type inference failed for: r2v36 */
    /* JADX WARN: Type inference failed for: r2v41 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x0167 -> B:30:0x016a). Please report as a decompilation issue!!! */
    private final Object a(Collection<ScreenEventReaction> r18, ScreenEvent r19, Continuation<? super Map<ViewTreeOption, ? extends List<ViewTreeNode>>> r20) {
        Collection r0 = (Collection) ZeusTransformUtils.wrapperContextForParams(r18, Collection.class, "com.obric.memorydata.plugin");
        Continuation r2 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r20, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r2, ScreenCaptureController$generateViewTree$1.class) == false) goto L7;
        ScreenCaptureController$generateViewTree$1 r3 = (ScreenCaptureController$generateViewTree$1) ZeusTransformUtils.preCheckCast(r2, ScreenCaptureController$generateViewTree$1.class, "com.obric.memorydata.plugin");
        if ((r3.label & Integer.MIN_VALUE) == 0) goto L7;
        r3.label -= Integer.MIN_VALUE;
    L8:
        Object r4 = r3.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r3.label;
        int r7 = 1;
        if (r6 == 0) goto L14;
        if (r6 != 1) goto L13;
        int r1 = r3.I$1;
        int r8 = r3.I$0;
        Object r9 = r3.L$4;
        Map r10 = (Map) ZeusTransformUtils.preCheckCast(r3.L$3, Map.class, "com.obric.memorydata.plugin");
        Iterator r11 = (Iterator) ZeusTransformUtils.preCheckCast(r3.L$2, Iterator.class, "com.obric.memorydata.plugin");
        LinkedHashMap r12 = (LinkedHashMap) ZeusTransformUtils.preCheckCast(r3.L$1, LinkedHashMap.class, "com.obric.memorydata.plugin");
        ScreenEvent r13 = (ScreenEvent) ZeusTransformUtils.preCheckCast(r3.L$0, ScreenEvent.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r4);
        ?? r14 = r1;
        ScreenEvent r15 = r13;
        Object r16 = r4;
    L30:
        List r17 = (List) ZeusTransformUtils.preCheckCast(r16, List.class, "com.obric.memorydata.plugin");
        if (r17 != null) goto L34;
        r17 = CollectionsKt.emptyList();
    L34:
        if (r17.isEmpty() == false) goto L40;
        RunLog r110 = RunLog.INSTANCE;
        StringBuilder r21 = new StringBuilder().append("viewtree empty pkg=").append(r15.getPackageName()).append(" event=").append(r15.getEventType()).append(" source=assist_structure displayId=").append(r8).append(" visibleOnly=");
        if (r14 == 0) goto L38;
        boolean r22 = true;
    L39:
        r110.debug("ScreenCaptureController", r21.append(r22).toString());
    L41:
        r10.put(r9, r17);
        r3 = r3;
        r7 = 1;
    L26:
        if (r11.hasNext() == false) goto L43;
        r9 = r11.next();
        r10 = (Map) ZeusTransformUtils.preCheckCast(r12, Map.class, "com.obric.memorydata.plugin");
        ?? r23 = (((ViewTreeOption) ZeusTransformUtils.preCheckCast(r9, ViewTreeOption.class, "com.obric.memorydata.plugin")).getIncludeInvisibleNode() ? 1 : 0) ^ r7;
        ?? r111 = com.obric.memorydata.screencapture.assist.a.f12791a;
        r3.L$0 = r15;
        r3.L$1 = r12;
        r3.L$2 = r11;
        r3.L$3 = r10;
        r3.L$4 = r9;
        r3.I$0 = r8;
        r3.I$1 = r23 == true ? 1 : 0;
        r3.label = r7;
        r16 = r111.a(r8, r23, r3);
        r14 = r23;
        if (r16 != r5) goto L30;
        return r5;
    L43:
        return (Map) ZeusTransformUtils.preCheckCast(r12, Map.class, "com.obric.memorydata.plugin");
    L38:
        r22 = false;
        goto L39
    L40:
        RunLog.INSTANCE.debug("ScreenCaptureController", "viewtree captured pkg=" + r15.getPackageName() + " event=" + r15.getEventType() + " source=assist_structure displayId=" + r8 + " nodes=" + r17.size());
        goto L41
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r4);
        Iterable r24 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");
        Collection r25 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r26 = r24.iterator();
    L16:
        if (r26.hasNext() == false) goto L20;
        ViewTreeOption r27 = ((ScreenEventReaction) ZeusTransformUtils.preCheckCast(r26.next(), ScreenEventReaction.class, "com.obric.memorydata.plugin")).getTaskOptions().getViewTree();
        if (r27 == null) goto L16;
        r25.add(r27);
        goto L16
    L20:
        List r28 = CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r25, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
        if (r28.isEmpty() == true) goto L23;
        int r29 = ((WindowManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService(WindowManager.class), WindowManager.class, "com.obric.memorydata.plugin")).getDefaultDisplay().getDisplayId();
        Iterable r30 = (Iterable) ZeusTransformUtils.preCheckCast(r28, Iterable.class, "com.obric.memorydata.plugin");
        LinkedHashMap r31 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r30, 10)), 16));
        r11 = r30.iterator();
        r12 = r31;
        r15 = r19;
        r8 = r29;
        goto L26
    L23:
        return MapsKt.emptyMap();
    L7:
        r3 = new ScreenCaptureController$generateViewTree$1(this, r2);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x011a -> B:27:0x011e). Please report as a decompilation issue!!! */
    private final Object a(Collection<ScreenEventReaction> r9, String r10, Continuation<? super Map<ScreenshotOption, ? extends Object>> r11) {
        Collection r12 = (Collection) ZeusTransformUtils.wrapperContextForParams(r9, Collection.class, "com.obric.memorydata.plugin");
        Continuation r13 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r13, ScreenCaptureController$generateScreenshot$1.class) == false) goto L7;
        ScreenCaptureController$generateScreenshot$1 r0 = (ScreenCaptureController$generateScreenshot$1) ZeusTransformUtils.preCheckCast(r13, ScreenCaptureController$generateScreenshot$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        Object r15 = r0.L$4;
        Map r16 = (Map) ZeusTransformUtils.preCheckCast(r0.L$3, Map.class, "com.obric.memorydata.plugin");
        Iterator r3 = (Iterator) ZeusTransformUtils.preCheckCast(r0.L$2, Iterator.class, "com.obric.memorydata.plugin");
        LinkedHashMap r4 = (LinkedHashMap) ZeusTransformUtils.preCheckCast(r0.L$1, LinkedHashMap.class, "com.obric.memorydata.plugin");
        String r5 = (String) ZeusTransformUtils.preCheckCast(r0.L$0, String.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r8);
    L27:
        r16.put(r15, r8);
        r10 = r5;
    L22:
        if (r3.hasNext() == false) goto L29;
        r15 = r3.next();
        Map r17 = (Map) ZeusTransformUtils.preCheckCast(r4, Map.class, "com.obric.memorydata.plugin");
        ScreenshotOption r6 = (ScreenshotOption) ZeusTransformUtils.preCheckCast(r15, ScreenshotOption.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.screencapture.accessibility.e r7 = com.obric.memorydata.screencapture.accessibility.e.f12780a;
        r0.L$0 = r10;
        r0.L$1 = r4;
        r0.L$2 = r3;
        r0.L$3 = r17;
        r0.L$4 = r15;
        r0.label = 1;
        Object r18 = r7.a(r6, r10, r0);
        if (r18 != r14) goto L26;
        return r14;
    L26:
        String r19 = r10;
        r16 = r17;
        r8 = r18;
        r5 = r19;
        goto L27
    L29:
        return (Map) ZeusTransformUtils.preCheckCast(r4, Map.class, "com.obric.memorydata.plugin");
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        Iterable r20 = (Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.memorydata.plugin");
        Collection r21 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r22 = r20.iterator();
    L16:
        if (r22.hasNext() == false) goto L20;
        ScreenshotOption r23 = ((ScreenEventReaction) ZeusTransformUtils.preCheckCast(r22.next(), ScreenEventReaction.class, "com.obric.memorydata.plugin")).getTaskOptions().getScreenshot();
        if (r23 == null) goto L16;
        r21.add(r23);
        goto L16
    L20:
        Iterable r24 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r21, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin");
        LinkedHashMap r25 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r24, 10)), 16));
        r3 = r24.iterator();
        r4 = r25;
    L7:
        r0 = new ScreenCaptureController$generateScreenshot$1(this, r13);
        goto L8
    }

    public static final /* synthetic */ void a(d r0) {
        m = r0;
    }

    static /* synthetic */ void a(d r0, ScreenEvent r1, Object r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        r0.a(r1, r2);
    }

    public static final /* synthetic */ void a(d r0, ScreenTouchEvent r1) {
        r0.c = r1;
    }

    public static final /* synthetic */ void a(d r0, WeakReference r1) {
        r0.d = r1;
    }

    public static final /* synthetic */ void a(d r2, bx r3) {
        r2.h = (bx) ZeusTransformUtils.wrapperContextForParams(r3, bx.class, "com.obric.memorydata.plugin");
    }

    private final void a(ScreenEventReaction r4) {
        Integer r0 = (Integer) ZeusTransformUtils.preCheckCast(this.j.get(r4.getId()), Integer.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L12;
        int r1 = ((Number) ZeusTransformUtils.preCheckCast(r0, Number.class, "com.obric.memorydata.plugin")).intValue();
        Object r2 = this.k;
        monitor-enter(r2);
        this.l.removeMessages(r1);     // Catch: Throwable -> L9
        a(r4.getId());     // Catch: Throwable -> L9
        Integer r3 = (Integer) ZeusTransformUtils.preCheckCast(this.j.remove(r4.getId()), Integer.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        monitor-exit(r2);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Type inference failed for: r0v47, types: [T, java.util.List] */
    /* JADX WARN: Type inference failed for: r0v5, types: [T, java.util.List] */
    private final void a(ScreenEvent r18, Object r19) {
        Map r0 = (Map) ZeusTransformUtils.preCheckCast(this.e, Map.class, "com.obric.memorydata.plugin");
        Map r6 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Iterator r1 = r0.entrySet().iterator();
    L3:
        boolean r2 = false;
        if (r1.hasNext() == false) goto L15;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(((ScreenEventReaction) ZeusTransformUtils.preCheckCast(r3.getKey(), ScreenEventReaction.class, "com.obric.memorydata.plugin")).getRule(), ScreenTouchEventRule.class) == false) goto L12;
        ScreenEventRule r4 = ((ScreenEventReaction) ZeusTransformUtils.preCheckCast(r3.getKey(), ScreenEventReaction.class, "com.obric.memorydata.plugin")).getRule();
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type com.obric.memorydata.sdk.screencapture.rule.ScreenTouchEventRule");
        if (((ScreenTouchEventRule) ZeusTransformUtils.preCheckCast(r4, ScreenTouchEventRule.class, "com.obric.memorydata.plugin")).hasOption(1) == false) goto L12;
        if (com.obric.memorydata.screencapture.c.f12795a.a() == false) goto L12;
    L13:
        if (r2 == false) goto L3;
        r6.put(r3.getKey(), r3.getValue());
    L12:
        r2 = ((ScreenEventReaction) ZeusTransformUtils.preCheckCast(r3.getKey(), ScreenEventReaction.class, "com.obric.memorydata.plugin")).getRule().isMatch(r18, (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        goto L13
    L15:
        Ref.ObjectRef r5 = new Ref.ObjectRef();
        r5.element = CollectionsKt.emptyList();
        if (ZeusTransformUtils.instanceOf(r18, ScreenTouchEvent.class) == false) goto L39;
        if (((ScreenTouchEvent) ZeusTransformUtils.preCheckCast(r18, ScreenTouchEvent.class, "com.obric.memorydata.plugin")).getAction() != ScreenTouchEvent.TouchAction.SCROLL_START) goto L39;
        Map r7 = (Map) ZeusTransformUtils.preCheckCast(this.e, Map.class, "com.obric.memorydata.plugin");
        Map r8 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Iterator r9 = r7.entrySet().iterator();
    L21:
        if (r9.hasNext() == false) goto L33;
        Map.Entry r10 = (Map.Entry) ZeusTransformUtils.preCheckCast(r9.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        ScreenEventRule r11 = ((ScreenEventReaction) ZeusTransformUtils.preCheckCast(r10.getKey(), ScreenEventReaction.class, "com.obric.memorydata.plugin")).getRule();
        if (ZeusTransformUtils.instanceOf(r11, ScreenTouchEventRule.class) == false) goto L25;
        ScreenTouchEventRule r12 = (ScreenTouchEventRule) ZeusTransformUtils.preCheckCast(r11, ScreenTouchEventRule.class, "com.obric.memorydata.plugin");
    L26:
        if (r12 != null) goto L28;
    L30:
        boolean r13 = false;
    L31:
        if (r13 == false) goto L21;
        r8.put(r10.getKey(), r10.getValue());
        goto L21
    L28:
        if (r12.matchScrollAction(r18.getPackageName(), (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) != true) goto L30;
        r13 = true;
        goto L31
    L25:
        r12 = null;
        goto L26
    L33:
        Collection r14 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(r8.size()), Collection.class, "com.obric.memorydata.plugin");
        Iterator r15 = r8.entrySet().iterator();
    L35:
        if (r15.hasNext() == false) goto L37;
        r14.add((ScreenEventReaction) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r15.next(), Map.Entry.class, "com.obric.memorydata.plugin")).getKey(), ScreenEventReaction.class, "com.obric.memorydata.plugin"));
        goto L35
    L37:
        r5.element = (List) ZeusTransformUtils.preCheckCast(r14, List.class, "com.obric.memorydata.plugin");
    L39:
        if (r6.isEmpty() == false) goto L44;
        if (((List) ZeusTransformUtils.preCheckCast(r5.element, List.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L44;
        return;
    L44:
        if (ZeusTransformUtils.instanceOf(r18, AppAccessibilityEvent.class) == false) goto L47;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenCaptureController", "dispatch event for " + r6.keySet(), false, 4, null);
    L47:
        if (ZeusTransformUtils.instanceOf(r18, ScreenTouchEvent.class) == true) goto L49;
    L51:
        boolean r16 = false;
    L52:
        b(r18);
        bx r17 = kotlinx.coroutines.i.a(j.a(), null, null, (Function2) ZeusTransformUtils.preCheckCast(new ScreenCaptureController$dispatchEvent$job$1(r19, r5, r18, this, r16, r6, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        if (a(r18) == false) goto L67;
        this.h = r17;
        Intrinsics.checkNotNull(r18, "null cannot be cast to non-null type com.obric.memorydata.sdk.screencapture.event.ScreenTouchEvent");
        this.c = (ScreenTouchEvent) ZeusTransformUtils.preCheckCast(r18, ScreenTouchEvent.class, "com.obric.memorydata.plugin");
        return;
    L67:
        return;
    L49:
        if (((ScreenTouchEvent) ZeusTransformUtils.preCheckCast(r18, ScreenTouchEvent.class, "com.obric.memorydata.plugin")).getAction() != ScreenTouchEvent.TouchAction.TAP) goto L51;
        r16 = true;
        goto L52
    }

    public static final /* synthetic */ boolean a(d r0, ScreenEvent r1) {
        return r0.c(r1);
    }

    private static final boolean a(ScreenEventReaction r3, Map.Entry r4) {
        Map.Entry r5 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r4, Map.Entry.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "<destruct>");
        Object r0 = r5.getKey();
        Intrinsics.checkNotNullExpressionValue(r0, "component1(...)");
        ScreenEventReaction r1 = (ScreenEventReaction) ZeusTransformUtils.preCheckCast(r0, ScreenEventReaction.class, "com.obric.memorydata.plugin");
        Object r6 = r5.getValue();
        Intrinsics.checkNotNullExpressionValue(r6, "component2(...)");
        com.obric.memorydata.sdk.screencapture.d r7 = (com.obric.memorydata.sdk.screencapture.d) ZeusTransformUtils.preCheckCast(r6, com.obric.memorydata.sdk.screencapture.d.class, "com.obric.memorydata.plugin");
        return Intrinsics.areEqual(r1.getId(), r3.getId());
    }

    private final boolean a(ScreenEvent r4) {
        if (ZeusTransformUtils.instanceOf(r4, ScreenTouchEvent.class) == true) goto L6;
        return false;
    L6:
        if (((ScreenTouchEvent) ZeusTransformUtils.preCheckCast(r4, ScreenTouchEvent.class, "com.obric.memorydata.plugin")).getAction() != ScreenTouchEvent.TouchAction.TAP) goto L8;
    L9:
        return true;
    L8:
        if (((ScreenTouchEvent) ZeusTransformUtils.preCheckCast(r4, ScreenTouchEvent.class, "com.obric.memorydata.plugin")).getAction() == ScreenTouchEvent.TouchAction.BACK_KEY) goto L9;
        return false;
    }

    private final boolean a(ScreenEventRule r3, String r4) {
        List<String> r2 = r3.getBlackPackages();
        if (r2 != null) goto L5;
    L7:
        boolean r5 = false;
    L8:
        if (r5 == false) goto L10;
        return false;
    L10:
        List<String> r6 = r3.getTargetPackages();
        if (r6 != null) goto L13;
        return true;
    L13:
        if (r6.contains(r4) == false) goto L16;
        return true;
    L16:
        return false;
    L5:
        if (r2.contains(r4) != true) goto L7;
        r5 = true;
        goto L8
    }

    private final boolean a(Set<ScreenEventReaction> r5, ScreenEvent r6) {
        Set r4 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.memorydata.plugin");
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r8 = r7.iterator();
    L4:
        if (r8.hasNext() == false) goto L7;
        r1.add(((ScreenEventReaction) ZeusTransformUtils.preCheckCast(r8.next(), ScreenEventReaction.class, "com.obric.memorydata.plugin")).getSourcePackage());
        goto L4
    L7:
        if (CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).size() <= 1) goto L10;
        return true;
    L10:
        if (ZeusTransformUtils.instanceOf(r6, ScreenTouchEvent.class) == true) goto L12;
    L27:
        return false;
    L12:
        if (((ScreenTouchEvent) ZeusTransformUtils.preCheckCast(r6, ScreenTouchEvent.class, "com.obric.memorydata.plugin")).getAction() != ScreenTouchEvent.TouchAction.SCROLL_START) goto L27;
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r9, Collection.class) == true) goto L16;
    L18:
        Iterator r10 = r9.iterator();
    L20:
        if (r10.hasNext() == false) goto L26;
        ScreenEventRule r11 = ((ScreenEventReaction) ZeusTransformUtils.preCheckCast(r10.next(), ScreenEventReaction.class, "com.obric.memorydata.plugin")).getRule();
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type com.obric.memorydata.sdk.screencapture.rule.ScreenTouchEventRule");
        List<ScreenTouchEvent.TouchAction> r12 = ((ScreenTouchEventRule) ZeusTransformUtils.preCheckCast(r11, ScreenTouchEventRule.class, "com.obric.memorydata.plugin")).getTargetActions();
        if (r12 == null) goto L24;
        boolean r13 = r12.contains(ScreenTouchEvent.TouchAction.SCROLLED);
    L25:
        if (r13 == false) goto L20;
        return true;
    L24:
        r13 = true;
    L26:
        return false;
    L16:
        if (((Collection) ZeusTransformUtils.preCheckCast(r9, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L18;
        goto L18
    }

    private static final boolean a(Function1 r2, Object r3) {
        return ((Boolean) ZeusTransformUtils.preCheckCast(((Function1) ZeusTransformUtils.wrapperContextForParams(r2, Function1.class, "com.obric.memorydata.plugin")).invoke(r3), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }

    public static final /* synthetic */ d b() {
        return m;
    }

    public static final /* synthetic */ WeakReference b(d r0) {
        return r0.d;
    }

    private final void b(ScreenEvent r11) {
        if (ZeusTransformUtils.instanceOf(r11, ScreenTouchEvent.class) == true) goto L5;
    L13:
        boolean r0 = false;
    L15:
        if (ZeusTransformUtils.instanceOf(r11, AppStateEvent.class) == true) goto L17;
    L31:
        if (r0 == false) goto L37;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenCaptureController", "cancel pending event: " + this.c + " for new event " + r11, false, 4, null);
        bx r12 = this.h;
        if (r12 == null) goto L35;
        bx.a.a(r12, null, 1, null);
    L35:
        this.h = null;
        this.c = null;
        return;
    L37:
        return;
    L17:
        if (((AppStateEvent) ZeusTransformUtils.preCheckCast(r11, AppStateEvent.class, "com.obric.memorydata.plugin")).getState() != AppStateEvent.AppState.CLOSE) goto L31;
        ScreenTouchEvent r4 = this.c;
        if (r4 == null) goto L21;
        ScreenTouchEvent.TouchAction r5 = r4.getAction();
    L23:
        if (r5 != ScreenTouchEvent.TouchAction.BACK_KEY) goto L31;
        String r6 = r11.getPackageName();
        ScreenTouchEvent r7 = this.c;
        if (r7 == null) goto L27;
        String r8 = r7.getPackageName();
    L29:
        if (Intrinsics.areEqual(r6, r8) == false) goto L31;
        r0 = true;
        goto L31
    L27:
        r8 = null;
        goto L29
    L21:
        r5 = null;
        goto L23
    L5:
        if (((ScreenTouchEvent) ZeusTransformUtils.preCheckCast(r11, ScreenTouchEvent.class, "com.obric.memorydata.plugin")).getAction() != ScreenTouchEvent.TouchAction.DOUBLE_TAP) goto L13;
        ScreenTouchEvent r1 = this.c;
        if (r1 == null) goto L9;
        ScreenTouchEvent.TouchAction r2 = r1.getAction();
    L11:
        if (r2 != ScreenTouchEvent.TouchAction.TAP) goto L13;
        r0 = true;
        goto L15
    L9:
        r2 = null;
        goto L11
    }

    public static final /* synthetic */ boolean b(d r0, ScreenEvent r1) {
        return r0.a(r1);
    }

    public static final /* synthetic */ long c(d r2) {
        return r2.g;
    }

    private final boolean c() {
        Set<ScreenEventReaction> r5 = this.e.keySet();
        Intrinsics.checkNotNullExpressionValue(r5, "<get-keys>(...)");
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, Collection.class) == true) goto L5;
    L7:
        Iterator r7 = r6.iterator();
    L9:
        if (r7.hasNext() == false) goto L15;
        if (((ScreenEventReaction) ZeusTransformUtils.preCheckCast(r7.next(), ScreenEventReaction.class, "com.obric.memorydata.plugin")).getTaskOptions().getViewTree() == null) goto L13;
        boolean r0 = true;
    L14:
        if (r0 == false) goto L9;
        return true;
    L13:
        r0 = false;
    L15:
        return false;
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L7;
        goto L7
    }

    private final boolean c(ScreenEvent r3) {
        if (ZeusTransformUtils.instanceOf(r3, ScreenTouchEvent.class) == true) goto L5;
    L9:
        return false;
    L5:
        if (((ScreenTouchEvent) ZeusTransformUtils.preCheckCast(r3, ScreenTouchEvent.class, "com.obric.memorydata.plugin")).getAction() != ScreenTouchEvent.TouchAction.SCROLLED) goto L7;
    L8:
        return true;
    L7:
        if (((ScreenTouchEvent) ZeusTransformUtils.preCheckCast(r3, ScreenTouchEvent.class, "com.obric.memorydata.plugin")).getAction() != ScreenTouchEvent.TouchAction.DOUBLE_TAP) goto L9;
        goto L8
    }

    public static final /* synthetic */ ScreenTouchEvent d(d r0) {
        return r0.c;
    }

    private final void d() {
        if (this.h == null) goto L6;
        this.f12798b.mo54trySendJP2dKIU(Unit.INSTANCE);
        return;
    }

    public static final /* synthetic */ i e(d r0) {
        return r0.f12798b;
    }

    public static final /* synthetic */ ConcurrentHashMap f(d r0) {
        return r0.e;
    }

    public static final /* synthetic */ Object g(d r0) {
        return r0.k;
    }

    public static /* synthetic */ boolean lambda$MwwvyA1_XgA2ufiJJ4f_qQVj8No(ScreenEventReaction r0, Map.Entry r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ boolean lambda$fS0N65YL3wj9FaGebWl5B0oZpNs(Function1 r0, Object r1) {
        return a(r0, r1);
    }

    public final e a() {
        return this.f;
    }

    public final Object a(TaskOptions r5, String r6, Continuation<? super ScreenData> r7) {
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r8, ScreenCaptureController$captureCurrent$1.class) == false) goto L7;
        ScreenCaptureController$captureCurrent$1 r0 = (ScreenCaptureController$captureCurrent$1) ZeusTransformUtils.preCheckCast(r8, ScreenCaptureController$captureCurrent$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r4 = r0.result;
        Object r9 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        com.obric.memorydata.screencapture.a r10 = (com.obric.memorydata.screencapture.a) ZeusTransformUtils.preCheckCast(r0.L$1, com.obric.memorydata.screencapture.a.class, "com.obric.memorydata.plugin");
        r6 = (String) ZeusTransformUtils.preCheckCast(r0.L$0, String.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r4);
    L20:
        return r10.a(r4, r6);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r4);
        ScreenshotOption r11 = r5.getScreenshot();
        if (r11 == null) goto L22;
        r10 = com.obric.memorydata.screencapture.a.f12765a;
        com.obric.memorydata.screencapture.accessibility.e r1 = com.obric.memorydata.screencapture.accessibility.e.f12780a;
        r0.L$0 = r6;
        r0.L$1 = r10;
        r0.label = 1;
        r4 = r1.a(r11, r6, r0);
        if (r4 != r9) goto L20;
        return r9;
    L22:
        throw new IllegalStateException(("captureCurrent missing screenshot option for " + r6).toString());
    L7:
        r0 = new ScreenCaptureController$captureCurrent$1(this, r8);
        goto L8
    }

    @Override // com.obric.memorydata.screencapture.accessibility.b
    public void a(AccessibilityRuleStatus r10) {
        Intrinsics.checkNotNullParameter(r10, "ruleStatus");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenCaptureController", "onAccessibilityRuleMatched " + r10.a().getId(), false, 4, null);
        AppAccessibilityEvent r0 = new AppAccessibilityEvent(r10.a());
        r0.setPackageName(r10.a().getPackageName());
        r0.setAppName(af.f13160a.a());
        ScreenEvent r1 = (ScreenEvent) ZeusTransformUtils.preCheckCast(r0, ScreenEvent.class, "com.obric.memorydata.plugin");
        SoftReference<Object> r11 = r10.c();
        if (r11 == null) goto L5;
        Object r12 = r11.get();
    L6:
        a(r1, r12);
        return;
    L5:
        r12 = null;
        goto L6
    }

    public final void a(final ScreenEventReaction r18, long r19, com.obric.memorydata.sdk.screencapture.d r21) {
        com.obric.memorydata.sdk.screencapture.d r4 = (com.obric.memorydata.sdk.screencapture.d) ZeusTransformUtils.wrapperContextForParams(r21, com.obric.memorydata.sdk.screencapture.d.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r18, "reaction");
        Intrinsics.checkNotNullParameter(r4, "callback");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenCaptureController", "register reaction: " + r18.getId() + ", source pkg: " + r18.getSourcePackage(), false, 4, null);
        Set<ScreenEventReaction> r6 = this.e.keySet();
        Intrinsics.checkNotNullExpressionValue(r6, "<get-keys>(...)");
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin");
        boolean r9 = false;
        if (ZeusTransformUtils.instanceOf(r7, Collection.class) == true) goto L5;
    L7:
        Iterator r8 = r7.iterator();
    L9:
        if (r8.hasNext() == false) goto L6;
        if (((ScreenEventReaction) ZeusTransformUtils.preCheckCast(r8.next(), ScreenEventReaction.class, "com.obric.memorydata.plugin")).getRule().getEventType() != r18.getRule().getEventType()) goto L13;
        boolean r10 = true;
    L14:
        if (r10 == false) goto L9;
    L15:
        Set<Map.Entry<ScreenEventReaction, com.obric.memorydata.sdk.screencapture.d>> r11 = this.e.entrySet();
        final Function1 r12 = new $$Lambda$d$MwwvyA1_XgA2ufiJJ4f_qQVj8No(r18);
        boolean r13 = r11.removeIf(new $$Lambda$d$fS0N65YL3wj9FaGebWl5B0oZpNs(r12));
        AppAccessibilityEventRule r14 = null;
        if (r13 == false) goto L27;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenCaptureController", "remove exist reaction: " + r18.getId(), null, 4, null);
        Set<ScreenEventReaction> r15 = this.e.keySet();
        Intrinsics.checkNotNullExpressionValue(r15, "<get-keys>(...)");
        Iterator r16 = ((Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L19:
        if (r16.hasNext() == false) goto L23;
        Object r17 = r16.next();
        if (Intrinsics.areEqual(((ScreenEventReaction) ZeusTransformUtils.preCheckCast(r17, ScreenEventReaction.class, "com.obric.memorydata.plugin")).getId(), r18.getId()) == false) goto L19;
    L25:
        if (((ScreenEventReaction) ZeusTransformUtils.preCheckCast(r17, ScreenEventReaction.class, "com.obric.memorydata.plugin")) == null) goto L27;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenCaptureController", "remove failed", null, 4, null);
        goto L27
    L23:
        r17 = null;
    L27:
        ((Map) ZeusTransformUtils.preCheckCast(this.e, Map.class, "com.obric.memorydata.plugin")).put(r18, r4);
        ScreenEventRule r5 = r18.getRule();
        if (ZeusTransformUtils.instanceOf(r5, AppAccessibilityEventRule.class) == false) goto L30;
        r14 = (AppAccessibilityEventRule) ZeusTransformUtils.preCheckCast(r5, AppAccessibilityEventRule.class, "com.obric.memorydata.plugin");
    L30:
        if (r14 == null) goto L32;
        com.obric.memorydata.screencapture.accessibility.a.f12771a.a(r14);
    L32:
        String r20 = af.f13160a.b();
        if (r18.getTaskOptions().getViewTree() != null) goto L35;
    L37:
        if (r9 == false) goto L53;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenCaptureController", "start monitor event type: " + r18.getRule().getEventType(), false, 4, null);
        int r22 = b.f12799a[r18.getRule().getEventType().ordinal()];
        if (r22 != 1) goto L41;
        this.f.a((e.b) ZeusTransformUtils.preCheckCast(this, e.b.class, "com.obric.memorydata.plugin"));
        goto L53
    L41:
        if (r22 != 2) goto L43;
        af.f13160a.a((af.a) ZeusTransformUtils.preCheckCast(this, af.a.class, "com.obric.memorydata.plugin"));
        goto L53
    L43:
        if (r22 != 3) goto L45;
        com.obric.memorydata.screencapture.monitor.c.f12803a.a((com.obric.memorydata.screencapture.monitor.a) ZeusTransformUtils.preCheckCast(this, com.obric.memorydata.screencapture.monitor.a.class, "com.obric.memorydata.plugin"));
        goto L53
    L45:
        if (r22 != 4) goto L48;
        com.obric.memorydata.screencapture.accessibility.a.f12771a.a((com.obric.memorydata.screencapture.accessibility.b) ZeusTransformUtils.preCheckCast(this, com.obric.memorydata.screencapture.accessibility.b.class, "com.obric.memorydata.plugin"));
        goto L53
    L48:
        throw new NoWhenBranchMatchedException();
    L53:
        if (r19 <= 0) goto L64;
        this.j.put(r18.getId(), Integer.valueOf(this.i.incrementAndGet()));
        Message r23 = Message.obtain();
        Integer r24 = this.j.get(r18.getId());
        Intrinsics.checkNotNull(r24);
        r23.what = ((Number) ZeusTransformUtils.preCheckCast(r24, Number.class, "com.obric.memorydata.plugin")).intValue();
        r23.obj = r18.getId();
        this.l.sendMessageDelayed(r23, r19);
        return;
    L64:
        return;
    L35:
        if (c(r20) == false) goto L37;
        com.obric.memorydata.screencapture.accessibility.a.f12771a.b("register reaction=" + r18.getId() + " package=" + r20);
        goto L37
    L13:
        r10 = false;
    L6:
        r9 = true;
        goto L15
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L7;
        goto L6
    }

    @Override // com.obric.memorydata.screencapture.monitor.e.b
    public void a(ScreenTouchEvent r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        a(this, (ScreenEvent) ZeusTransformUtils.preCheckCast(r3, ScreenEvent.class, "com.obric.memorydata.plugin"), null, 2, null);
    }

    public final void a(String r15) {
        Intrinsics.checkNotNullParameter(r15, "reactionId");
        Iterator r0 = ((Map) ZeusTransformUtils.preCheckCast(this.e, Map.class, "com.obric.memorydata.plugin")).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L41;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(((ScreenEventReaction) ZeusTransformUtils.preCheckCast(r1.getKey(), ScreenEventReaction.class, "com.obric.memorydata.plugin")).getId(), r15) == false) goto L4;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenCaptureController", "unregister reaction: " + r15, false, 4, null);
        ScreenEventRule r2 = ((ScreenEventReaction) ZeusTransformUtils.preCheckCast(r1.getKey(), ScreenEventReaction.class, "com.obric.memorydata.plugin")).getRule();
        if (ZeusTransformUtils.instanceOf(r2, AppAccessibilityEventRule.class) == false) goto L10;
        AppAccessibilityEventRule r3 = (AppAccessibilityEventRule) ZeusTransformUtils.preCheckCast(r2, AppAccessibilityEventRule.class, "com.obric.memorydata.plugin");
    L11:
        if (r3 == null) goto L13;
        com.obric.memorydata.screencapture.accessibility.a.f12771a.a(r3.getId());
    L13:
        r0.remove();
        Set<ScreenEventReaction> r4 = this.e.keySet();
        Intrinsics.checkNotNullExpressionValue(r4, "<get-keys>(...)");
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin");
        boolean r6 = false;
        if (ZeusTransformUtils.instanceOf(r5, Collection.class) == true) goto L16;
    L18:
        Iterator r7 = r5.iterator();
    L20:
        if (r7.hasNext() == false) goto L17;
        if (((ScreenEventReaction) ZeusTransformUtils.preCheckCast(r7.next(), ScreenEventReaction.class, "com.obric.memorydata.plugin")).getRule().getEventType() != r2.getEventType()) goto L24;
        boolean r8 = true;
    L25:
        if (r8 == false) goto L20;
    L26:
        if (r6 == false) goto L4;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenCaptureController", "unregister monitor event type: " + r2.getEventType(), false, 4, null);
        int r9 = b.f12799a[r2.getEventType().ordinal()];
        if (r9 != 1) goto L30;
        this.f.b((e.b) ZeusTransformUtils.preCheckCast(this, e.b.class, "com.obric.memorydata.plugin"));
        goto L4
    L30:
        if (r9 != 2) goto L32;
        af.f13160a.b((af.a) ZeusTransformUtils.preCheckCast(this, af.a.class, "com.obric.memorydata.plugin"));
        goto L4
    L32:
        if (r9 != 3) goto L34;
        com.obric.memorydata.screencapture.monitor.c.f12803a.b((com.obric.memorydata.screencapture.monitor.a) ZeusTransformUtils.preCheckCast(this, com.obric.memorydata.screencapture.monitor.a.class, "com.obric.memorydata.plugin"));
        goto L4
    L34:
        if (r9 != 4) goto L37;
        com.obric.memorydata.screencapture.accessibility.a.f12771a.a(null);
        goto L4
    L37:
        throw new NoWhenBranchMatchedException();
    L24:
        r8 = false;
    L17:
        r6 = true;
        goto L26
    L16:
        if (((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L18;
    L10:
        r3 = null;
        goto L11
    }

    @Override // com.obric.memorydata.utils.af.a
    public void a(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "appName");
        Intrinsics.checkNotNullParameter(r5, ObricMemoryConstants.KEY_PACKAGE_NAME);
        if (c() == true) goto L5;
    L8:
        AppStateEvent r0 = new AppStateEvent(AppStateEvent.AppState.OPEN);
        r0.setAppName(r4);
        r0.setPackageName(r5);
        a(this, (ScreenEvent) ZeusTransformUtils.preCheckCast(r0, ScreenEvent.class, "com.obric.memorydata.plugin"), null, 2, null);
        return;
    L5:
        if (c(r5) == false) goto L7;
        com.obric.memorydata.screencapture.accessibility.a.f12771a.b("appOpen package=" + r5);
        goto L8
    L7:
        com.obric.memorydata.screencapture.accessibility.a.f12771a.c(r5, "appOpen package=" + r5);
        goto L8
    }

    @Override // com.obric.memorydata.screencapture.monitor.a
    public void a(boolean r4) {
        InputMethodEvent r0 = new InputMethodEvent(r4);
        r0.setPackageName(af.f13160a.b());
        r0.setAppName(af.f13160a.a());
        if (r4 == false) goto L11;
        ScreenTouchEvent r5 = this.c;
        if (r5 == null) goto L7;
        ScreenTouchEvent.TouchAction r6 = r5.getAction();
    L9:
        if (r6 != ScreenTouchEvent.TouchAction.TAP) goto L11;
        d();
        goto L11
    L7:
        r6 = null;
    L11:
        a(this, (ScreenEvent) ZeusTransformUtils.preCheckCast(r0, ScreenEvent.class, "com.obric.memorydata.plugin"), null, 2, null);
    }

    public final int b(String r5) {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin");
        int r2 = 0;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return 0;
    L11:
        Set<ScreenEventReaction> r4 = this.e.keySet();
        Intrinsics.checkNotNullExpressionValue(r4, "<get-keys>(...)");
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, Collection.class) == true) goto L14;
    L16:
        Iterator r7 = r6.iterator();
    L18:
        if (r7.hasNext() == false) goto L24;
        if (Intrinsics.areEqual(((ScreenEventReaction) ZeusTransformUtils.preCheckCast(r7.next(), ScreenEventReaction.class, "com.obric.memorydata.plugin")).getSourcePackage(), r5) == false) goto L18;
        r2 = r2 + 1;
        if (r2 >= 0) goto L18;
        CollectionsKt.throwCountOverflow();
    L24:
        return r2;
    L14:
        if (((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L16;
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    @Override // com.obric.memorydata.utils.af.a
    public void b(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "appName");
        Intrinsics.checkNotNullParameter(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);
        AppStateEvent r0 = new AppStateEvent(AppStateEvent.AppState.CLOSE);
        r0.setAppName(r3);
        r0.setPackageName(r4);
        ScreenTouchEvent r5 = this.c;
        if (r5 == null) goto L5;
        ScreenTouchEvent.TouchAction r6 = r5.getAction();
    L7:
        if (r6 != ScreenTouchEvent.TouchAction.TAP) goto L9;
        d();
    L9:
        a(this, (ScreenEvent) ZeusTransformUtils.preCheckCast(r0, ScreenEvent.class, "com.obric.memorydata.plugin"), null, 2, null);
        return;
    L5:
        r6 = null;
        goto L7
    }

    public final boolean c(String r7) {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return false;
    L11:
        Set<ScreenEventReaction> r2 = this.e.keySet();
        Intrinsics.checkNotNullExpressionValue(r2, "<get-keys>(...)");
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, Collection.class) == true) goto L14;
    L16:
        Iterator r4 = r3.iterator();
    L18:
        if (r4.hasNext() == false) goto L26;
        ScreenEventReaction r5 = (ScreenEventReaction) ZeusTransformUtils.preCheckCast(r4.next(), ScreenEventReaction.class, "com.obric.memorydata.plugin");
        if (r5.getTaskOptions().getViewTree() != null) goto L22;
    L24:
        boolean r6 = false;
    L25:
        if (r6 == false) goto L18;
        return true;
    L22:
        if (a(r5.getRule(), r7) == false) goto L24;
        r6 = true;
    L26:
        return false;
    L14:
        if (((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L16;
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r1 = false;
        goto L9
    }
}
