package com.obric.widget.host.internal;

import android.os.SystemClock;
import android.view.View;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import com.obric.widget.host.HostedWidget;
import com.obric.widget.host.WidgetInstanceKey;
import com.obric.widget.host.WidgetPerfEvent;
import com.obric.widget.host.WidgetPerfReporter;
import com.obric.widget.host.runtime.WidgetBindReason;
import com.obric.widget.host.runtime.WidgetDataChangedEvent;
import com.obric.widget.host.runtime.WidgetDefinitionMetadata;
import com.obric.widget.host.runtime.WidgetInstanceSnapshot;
import com.obric.widget.host.runtime.WidgetRuntimeServices;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.z;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0010\b\u0000\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u000e\u0010!\u001a\u00020\u0015H\u0096@¢\u0006\u0002\u0010\"J\u000e\u0010#\u001a\u00020\u0015H\u0096@¢\u0006\u0002\u0010\"J\b\u0010$\u001a\u00020\u0015H\u0016J\b\u0010%\u001a\u00020\u0015H\u0016J\b\u0010&\u001a\u00020\u0015H\u0016J?\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u00032\b\u0010*\u001a\u0004\u0018\u00010\u00032\b\u0010+\u001a\u0004\u0018\u00010,2\b\u0010-\u001a\u0004\u0018\u00010,2\b\u0010.\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0002\u0010/J\u000e\u00100\u001a\u00020\u00152\u0006\u00101\u001a\u00020(J*\u00102\u001a\u00020\u00152\u0006\u00103\u001a\u00020\u00032\b\u00104\u001a\u0004\u0018\u00010\u00032\u0006\u00105\u001a\u00020,2\b\u00106\u001a\u0004\u0018\u00010\u0003J\u0006\u00107\u001a\u00020\u0015J\u0010\u00108\u001a\u00020\u00152\b\u0010*\u001a\u0004\u0018\u00010\u0003J\b\u00109\u001a\u00020\u0015H\u0016J\u0016\u0010:\u001a\u00020\u00152\u0006\u0010*\u001a\u00020\u0003H\u0082@¢\u0006\u0002\u0010;R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lcom/obric/widget/host/internal/DefaultHostedWidget;", "Lcom/obric/widget/host/HostedWidget;", "hostId", "", STGroup.DICT_KEY, "Lcom/obric/widget/host/WidgetInstanceKey;", "view", "Landroid/view/View;", "widgetView", "metadata", "Lcom/obric/widget/host/runtime/WidgetDefinitionMetadata;", "snapshot", "Lcom/obric/widget/host/runtime/WidgetInstanceSnapshot;", "runtimeServices", "Lcom/obric/widget/host/runtime/WidgetRuntimeServices;", "perfReporter", "Lcom/obric/widget/host/WidgetPerfReporter;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "onDestroy", "Lkotlin/Function0;", "", "<init>", "(Ljava/lang/String;Lcom/obric/widget/host/WidgetInstanceKey;Landroid/view/View;Landroid/view/View;Lcom/obric/widget/host/runtime/WidgetDefinitionMetadata;Lcom/obric/widget/host/runtime/WidgetInstanceSnapshot;Lcom/obric/widget/host/runtime/WidgetRuntimeServices;Lcom/obric/widget/host/WidgetPerfReporter;Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function0;)V", "getKey", "()Lcom/obric/widget/host/WidgetInstanceKey;", "getView", "()Landroid/view/View;", "id", "getId", "()Ljava/lang/String;", "destroyed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "refresh", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "restore", "onShow", "onForeground", "onHide", "dispatchDataChanged", "", "widgetData", "reason", "dataVersion", "", "updatedAt", "state", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;)Z", "onThemeChanged", "isNightMode", "onSystemChanged", "type", "action", "timeMillis", "timeZone", "syncVisibility", "markDirty", "destroy", "refreshInternal", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "widget-host-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DefaultHostedWidget implements HostedWidget {
    private final AtomicBoolean destroyed;
    private final String hostId;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final String f14926id;
    private final WidgetInstanceKey key;
    private final WidgetDefinitionMetadata metadata;
    private final Function0<Unit> onDestroy;
    private final WidgetPerfReporter perfReporter;
    private final WidgetRuntimeServices runtimeServices;
    private final CoroutineScope scope;
    private final WidgetInstanceSnapshot snapshot;
    private final View view;
    private final View widgetView;

    /* JADX INFO: renamed from: com.obric.widget.host.internal.DefaultHostedWidget$destroy$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.widget.host.internal.DefaultHostedWidget$destroy$2", f = "DefaultHostedWidget.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ DefaultHostedWidget this$0;

        public AnonymousClass2(DefaultHostedWidget r5, Continuation<? super AnonymousClass2> r10) {
            this.this$0 = r5;
            super(2, r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
            return new AnonymousClass2(this.this$0, r10);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
            return invoke2(r5, r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r5);
            DefaultHostedWidget.access$getRuntimeServices$p(this.this$0).unregisterWidgetMessenger(DefaultHostedWidget.access$getSnapshot$p(this.this$0).getHostWidgetInstanceId(), DefaultHostedWidget.access$getMetadata$p(this.this$0).getAppletId(), DefaultHostedWidget.access$getMetadata$p(this.this$0).getWidgetId());
            DefaultHostedWidget.access$getRuntimeServices$p(this.this$0).dispatchWidgetUnbind(DefaultHostedWidget.access$getMetadata$p(this.this$0).getAppletId(), DefaultHostedWidget.access$getMetadata$p(this.this$0).getWidgetId(), DefaultHostedWidget.access$getSnapshot$p(this.this$0).getHostWidgetInstanceId());
            DefaultHostedWidget.access$getRuntimeServices$p(this.this$0).clearWidgetData(DefaultHostedWidget.access$getSnapshot$p(this.this$0).getHostWidgetInstanceId(), DefaultHostedWidget.access$getMetadata$p(this.this$0).getAppletId(), DefaultHostedWidget.access$getMetadata$p(this.this$0).getWidgetId());
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r5, Continuation<? super Unit> r10) {
            return ((AnonymousClass2) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.obric.widget.host.internal.DefaultHostedWidget$refreshInternal$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.widget.host.internal.DefaultHostedWidget", f = "DefaultHostedWidget.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, l = {216, 231}, m = "refreshInternal", n = {"this", "reason", "refreshStartElapsed", "dirtyVersion", "remoteUpdateStartElapsed", "this", "reason", "widgetData", "refreshStartElapsed", "dirtyVersion", "remoteUpdateMs", "applyStartElapsed"}, s = {"L$0", "L$1", "J$0", "J$1", "J$2", "L$0", "L$1", "L$2", "J$0", "J$1", "J$2", "J$3"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        long J$0;
        long J$1;
        long J$2;
        long J$3;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ DefaultHostedWidget this$0;

        public AnonymousClass1(DefaultHostedWidget r5, Continuation<? super AnonymousClass1> r10) {
            this.this$0 = r5;
            super(r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            this.result = r5;
            this.label |= Integer.MIN_VALUE;
            return DefaultHostedWidget.access$refreshInternal(this.this$0, null, this);
        }
    }

    public DefaultHostedWidget(String r5, WidgetInstanceKey r10, View r11, View r12, WidgetDefinitionMetadata r13, WidgetInstanceSnapshot r14, WidgetRuntimeServices r15, WidgetPerfReporter r16, CoroutineScope r17, Function0<Unit> r18) {
        Intrinsics.checkNotNullParameter(r5, "hostId");
        Intrinsics.checkNotNullParameter(r10, STGroup.DICT_KEY);
        Intrinsics.checkNotNullParameter(r11, "view");
        Intrinsics.checkNotNullParameter(r12, "widgetView");
        Intrinsics.checkNotNullParameter(r13, "metadata");
        Intrinsics.checkNotNullParameter(r14, "snapshot");
        Intrinsics.checkNotNullParameter(r15, "runtimeServices");
        Intrinsics.checkNotNullParameter(r16, "perfReporter");
        Intrinsics.checkNotNullParameter(r17, "scope");
        Intrinsics.checkNotNullParameter(r18, "onDestroy");
        this.hostId = r5;
        this.key = r10;
        this.view = r11;
        this.widgetView = r12;
        this.metadata = r13;
        this.snapshot = r14;
        this.runtimeServices = r15;
        this.perfReporter = r16;
        this.scope = r17;
        this.onDestroy = r18;
        this.f14926id = getKey().getInstanceId();
        this.destroyed = new AtomicBoolean(false);
    }

    public static /* synthetic */ void a(DefaultHostedWidget r5) {
        destroy$lambda$0(r5);
    }

    public static final /* synthetic */ WidgetDefinitionMetadata access$getMetadata$p(DefaultHostedWidget r5) {
        return r5.metadata;
    }

    public static final /* synthetic */ WidgetRuntimeServices access$getRuntimeServices$p(DefaultHostedWidget r5) {
        return r5.runtimeServices;
    }

    public static final /* synthetic */ WidgetInstanceSnapshot access$getSnapshot$p(DefaultHostedWidget r5) {
        return r5.snapshot;
    }

    public static final /* synthetic */ View access$getWidgetView$p(DefaultHostedWidget r5) {
        return r5.widgetView;
    }

    public static final /* synthetic */ Object access$refreshInternal(DefaultHostedWidget r5, String r10, Continuation r11) {
        return r5.refreshInternal(r10, r11);
    }

    private static final void destroy$lambda$0(DefaultHostedWidget r5) {
        Intrinsics.checkNotNullParameter(r5, "this$0");
        r5.runtimeServices.destroyWidgetHost(r5.widgetView);
    }

    private final Object refreshInternal(String r30, Continuation<? super Unit> r31) {
        String r5 = r30;
        if ((r31 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r10 = (AnonymousClass1) r31;
        int r11 = r10.label;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
        r10.label = r11 - Integer.MIN_VALUE;
    L8:
        Object r12 = r10.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r14 = r10.label;
        if (r14 == 0) goto L16;
        if (r14 == 1) goto L15;
        if (r14 != 2) goto L14;
        long r15 = r10.J$3;
        long r16 = r10.J$2;
        long r17 = r10.J$1;
        long r18 = r10.J$0;
        String r19 = (String) r10.L$2;
        String r110 = (String) r10.L$1;
        DefaultHostedWidget r20 = (DefaultHostedWidget) r10.L$0;
        ResultKt.throwOnFailure(r12);
        Object r111 = "reason";
    L28:
        boolean r21 = ((Boolean) r12).booleanValue();
        long r112 = SystemClock.elapsedRealtime() - r15;
        r20.runtimeServices.getInstanceManager().onRenderCompleted(r20.snapshot, r21, r17);
        WidgetPerfReporter r22 = r20.perfReporter;
        String r23 = r20.hostId;
        WidgetInstanceKey r24 = r20.getKey();
        Pair r25 = TuplesKt.to(r111, r110);
        Pair r26 = TuplesKt.to("success", Boxing.boxBoolean(r21));
        if (r19 == null) goto L31;
        int r27 = r19.length();
    L32:
        r22.report(new WidgetPerfEvent("widget_host_refresh_complete", r23, r24, 0, MapsKt.mapOf(new Pair[]{r25, r26, TuplesKt.to("dataLength", Boxing.boxInt(r27)), TuplesKt.to("refreshWallMs", Boxing.boxLong(SystemClock.elapsedRealtime() - r18)), TuplesKt.to("remoteUpdateMs", Boxing.boxLong(r16)), TuplesKt.to("applyMs", Boxing.boxLong(r112))}), 8, null));
        return Unit.INSTANCE;
    L31:
        r27 = 0;
        goto L32
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        long r28 = r10.J$2;
        long r29 = r10.J$1;
        long r113 = r10.J$0;
        String r32 = (String) r10.L$1;
        DefaultHostedWidget r114 = (DefaultHostedWidget) r10.L$0;
        ResultKt.throwOnFailure(r12);
        long r115 = r113;
        long r116 = r29;
        long r33 = r28;
        r5 = r32;
    L24:
        String r34 = (String) r12;
        long r35 = SystemClock.elapsedRealtime() - r33;
        long r36 = SystemClock.elapsedRealtime();
        MainCoroutineDispatcher r117 = Dispatchers.getMain().getImmediate();
        r111 = "reason";
        DefaultHostedWidget$refreshInternal$updated$1 r37 = new DefaultHostedWidget$refreshInternal$updated$1(r114, r34, null);
        r10.L$0 = r114;
        r10.L$1 = r5;
        r10.L$2 = r34;
        r10.J$0 = r115;
        r10.J$1 = r116;
        r10.J$2 = r35;
        r10.J$3 = r36;
        r10.label = 2;
        r12 = BuildersKt.withContext(r117, r37, r10);
        if (r12 != r13) goto L27;
        return r13;
    L27:
        r110 = r5;
        r16 = r35;
        r17 = r116;
        r20 = r114;
        r18 = r115;
        r19 = r34;
        r15 = r36;
        goto L28
    L16:
        ResultKt.throwOnFailure(r12);
        if (this.destroyed.get() == true) goto L19;
        long r118 = SystemClock.elapsedRealtime();
        long r119 = this.runtimeServices.getInstanceManager().currentDirtyVersion(this.snapshot);
        this.perfReporter.report(new WidgetPerfEvent("widget_host_refresh_start", this.hostId, getKey(), 0, MapsKt.mapOf(new Pair[]{TuplesKt.to("reason", r5), TuplesKt.to("dirtyVersion", Boxing.boxLong(r119))}), 8, null));
        r33 = SystemClock.elapsedRealtime();
        z r38 = Dispatchers.getIO();
        DefaultHostedWidget$refreshInternal$widgetData$1 r39 = new DefaultHostedWidget$refreshInternal$widgetData$1(this, r5, null);
        r10.L$0 = this;
        r10.L$1 = r5;
        r10.J$0 = r118;
        r10.J$1 = r119;
        r10.J$2 = r33;
        r10.label = 1;
        r12 = BuildersKt.withContext(r38, r39, r10);
        if (r12 != r13) goto L23;
        return r13;
    L23:
        r115 = r118;
        r116 = r119;
        r114 = this;
        goto L24
    L19:
        return Unit.INSTANCE;
    L7:
        r10 = new AnonymousClass1(this, r31);
        goto L8
    }

    @Override // com.obric.widget.host.HostedWidget
    public void destroy() {
        if (this.destroyed.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        getView().post(new com.obric.oui.lisitem.a(this, 6));
        BuildersKt.launch$default(this.scope, Dispatchers.getIO(), null, new AnonymousClass2(this, null), 2, null);
        this.runtimeServices.getInstanceManager().onInstanceRemoved(this.snapshot, "HostedWidget.destroy");
        this.onDestroy.invoke();
        this.perfReporter.report(new WidgetPerfEvent("widget_host_destroy", this.hostId, getKey(), 0, MapsKt.mapOf(TuplesKt.to("instanceId", Integer.valueOf(this.snapshot.getHostWidgetInstanceId()))), 8, null));
    }

    @Override // com.obric.widget.host.HostedWidget
    public boolean dispatchDataChanged(String r15, String r16, Long r17, Long r18, String r19) {
        if (this.destroyed.get() == false) goto L7;
        return false;
    L7:
        return this.runtimeServices.dispatchWidgetDataChanged(this.widgetView, new WidgetDataChangedEvent(this.metadata.getAppletId(), this.metadata.getWidgetId(), this.snapshot.getHostWidgetInstanceId(), this.hostId, r15, r16, r17, r18, r19));
    }

    @Override // com.obric.widget.host.HostedWidget
    public String getId() {
        return this.f14926id;
    }

    @Override // com.obric.widget.host.HostedWidget
    public WidgetInstanceKey getKey() {
        return this.key;
    }

    @Override // com.obric.widget.host.HostedWidget
    public View getView() {
        return this.view;
    }

    public final void markDirty(String r5) {
        if (this.destroyed.get() == true) goto L6;
        this.runtimeServices.getInstanceManager().markDirty(this.snapshot, r5);
        return;
    }

    @Override // com.obric.widget.host.HostedWidget
    public void onForeground() {
        if (this.destroyed.get() == false) goto L5;
        return;
    L5:
        onShow();
        this.runtimeServices.dispatchWidgetForeground(this.widgetView, this.metadata.getAppletId(), this.metadata.getWidgetId(), this.snapshot.getHostWidgetInstanceId(), System.currentTimeMillis(), "host.onForeground");
    }

    @Override // com.obric.widget.host.HostedWidget
    public void onHide() {
        if (this.destroyed.get() == false) goto L5;
        return;
    L5:
        this.runtimeServices.getInstanceManager().onViewVisibilityChanged(this.snapshot, false);
        this.runtimeServices.dispatchWidgetVisibilityChanged(this.widgetView, false);
        this.runtimeServices.dispatchWidgetVisibilityEvent(this.widgetView, this.metadata, this.snapshot.getHostWidgetInstanceId(), false, System.currentTimeMillis(), "hostedWidget.onHide");
    }

    @Override // com.obric.widget.host.HostedWidget
    public void onShow() {
        if (this.destroyed.get() == false) goto L5;
        return;
    L5:
        boolean r5 = this.runtimeServices.getInstanceManager().onViewVisibilityChanged(this.snapshot, true);
        this.runtimeServices.dispatchWidgetVisibilityChanged(this.widgetView, true);
        this.runtimeServices.dispatchWidgetVisibilityEvent(this.widgetView, this.metadata, this.snapshot.getHostWidgetInstanceId(), true, System.currentTimeMillis(), "hostedWidget.onShow");
        if (r5 == false) goto L9;
        markDirty("visibilityGain");
        return;
    }

    public final void onSystemChanged(String r13, String r14, long r15, String r17) {
        Intrinsics.checkNotNullParameter(r13, "type");
        if (this.destroyed.get() == false) goto L5;
        return;
    L5:
        this.runtimeServices.dispatchWidgetSystemChanged(this.widgetView, this.metadata.getAppletId(), this.metadata.getWidgetId(), this.snapshot.getHostWidgetInstanceId(), r13, r14, r15, r17);
        markDirty("system:" + r13);
    }

    public final void onThemeChanged(boolean r5) {
        if (this.destroyed.get() == true) goto L6;
        this.runtimeServices.dispatchWidgetThemeChanged(this.widgetView, r5);
        return;
    }

    @Override // com.obric.widget.host.HostedWidget
    public Object refresh(Continuation<? super Unit> r5) {
        Object r10 = refreshInternal("manual", r5);
        if (r10 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r10;
    L6:
        return Unit.INSTANCE;
    }

    @Override // com.obric.widget.host.HostedWidget
    public Object restore(Continuation<? super Unit> r5) {
        if (this.destroyed.get() == true) goto L5;
        this.runtimeServices.getInstanceManager().bindInstance(this.snapshot, WidgetBindReason.RESTORE);
        this.runtimeServices.getInstanceManager().onViewAttached(this.snapshot);
        Object r10 = refreshInternal("onRestore", r5);
        if (r10 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
        return r10;
    L10:
        return Unit.INSTANCE;
    L5:
        return Unit.INSTANCE;
    }

    public final void syncVisibility() {
        if (getView().isShown() == false) goto L5;
        onShow();
        return;
    L5:
        onHide();
    }
}
