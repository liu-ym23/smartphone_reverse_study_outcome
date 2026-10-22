package com.bytedance.ai.ex.widget.inittasks;

import android.app.Application;
import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Trace;
import android.util.DisplayMetrics;
import com.bytedance.ai.bridge.method.calendar.GetCalendarEventDetailMethod;
import com.bytedance.ai.bridge.method.calendar.GetCalendarObjectsMethod;
import com.bytedance.ai.bridge.method.calendar.GetCalendarsMethod;
import com.bytedance.ai.bridge.method.calendar.SyncCalendarMethod;
import com.bytedance.ai.bridge.method.datamanager.AIStorageGetMethodV2;
import com.bytedance.ai.bridge.method.datamanager.AIStorageRemoveMethodV2;
import com.bytedance.ai.bridge.method.datamanager.AIStorageSetMethodV2;
import com.bytedance.ai.bridge.method.datamanager.AIStorageSubscribeMethodV2;
import com.bytedance.ai.bridge.method.datamanager.AIStorageUnSubscribeMethodV2;
import com.bytedance.ai.bridge.method.event.SubscribeEventMethod;
import com.bytedance.ai.bridge.method.event.UnSubscribeEventMethod;
import com.bytedance.ai.bridge.method.floating.CloseFloatingWindowMethod;
import com.bytedance.ai.bridge.method.floating.DisplayFloatingMaskMethod;
import com.bytedance.ai.bridge.method.floating.SetFloatingWindowVisibleMethod;
import com.bytedance.ai.bridge.method.floatinginput.ClearAppendQueryMethod;
import com.bytedance.ai.bridge.method.floatinginput.ClearContextMethod;
import com.bytedance.ai.bridge.method.floatinginput.GetInputModeMethod;
import com.bytedance.ai.bridge.method.floatinginput.RedirectInputMethod;
import com.bytedance.ai.bridge.method.floatinginput.SetAppendQueryMethod;
import com.bytedance.ai.bridge.method.floatinginput.SetBackGestureEnableMethod;
import com.bytedance.ai.bridge.method.floatinginput.SetChatInputVisibleMethod;
import com.bytedance.ai.bridge.method.floatinginput.SetInputModeMethod;
import com.bytedance.ai.bridge.method.floatinginput.SetMessageIndicationMethod;
import com.bytedance.ai.bridge.method.floatinginput.UpdateBotIdMethod;
import com.bytedance.ai.bridge.method.floatinginput.UpdateInputOffsetMethod;
import com.bytedance.ai.bridge.method.floatinginput.UpdateInputPlaceHolderMethod;
import com.bytedance.ai.bridge.method.floatinginput.UpdateInputTextMethod;
import com.bytedance.ai.bridge.method.hybridmonitor.CustomReportMethod;
import com.bytedance.ai.bridge.method.hybridmonitor.InitConfigMethod;
import com.bytedance.ai.bridge.method.info.GetAppInfoMethod;
import com.bytedance.ai.bridge.method.info.GetDebugInfoMethod;
import com.bytedance.ai.bridge.method.info.GetUserInfoMethod;
import com.bytedance.ai.bridge.method.log.ReportAppLogMethod;
import com.bytedance.ai.bridge.method.log.ReportPerformanceEntriesMethod;
import com.bytedance.ai.bridge.method.login.AgreeAuthMethod;
import com.bytedance.ai.bridge.method.login.GetPrivacySettingMethod;
import com.bytedance.ai.bridge.method.login.LoginMethod;
import com.bytedance.ai.bridge.method.login.PostLoginResultMethod;
import com.bytedance.ai.bridge.method.net.AppletRequestMethod;
import com.bytedance.ai.bridge.method.net.CancelStreamRequestMethod;
import com.bytedance.ai.bridge.method.net.RequestMethod;
import com.bytedance.ai.bridge.method.pasteboard.CopyMethod;
import com.bytedance.ai.bridge.method.payment.GetOrderPaymentMethod;
import com.bytedance.ai.bridge.method.payment.RequestOrderMethod;
import com.bytedance.ai.bridge.method.phoneNum.GetPhoneNumMethod;
import com.bytedance.ai.bridge.method.resource.UpdatePackageMethod;
import com.bytedance.ai.bridge.method.router.CloseMethod;
import com.bytedance.ai.bridge.method.router.CreateTextMethod;
import com.bytedance.ai.bridge.method.router.CreateWidgetMethod;
import com.bytedance.ai.bridge.method.router.OpenAppMethod;
import com.bytedance.ai.bridge.method.router.OpenMethod;
import com.bytedance.ai.bridge.method.router.OpenPageMethod;
import com.bytedance.ai.bridge.method.router.SetAdditionalContextMethod;
import com.bytedance.ai.bridge.method.router.SetEnvContextMethod;
import com.bytedance.ai.bridge.method.sqlite.ExecuteSqliteActionMethod;
import com.bytedance.ai.bridge.method.storage.ClearStorageMethod;
import com.bytedance.ai.bridge.method.storage.GetStorageInfoMethod;
import com.bytedance.ai.bridge.method.storage.GetStorageMethod;
import com.bytedance.ai.bridge.method.storage.RemoveStorageMethod;
import com.bytedance.ai.bridge.method.storage.SetStorageMethod;
import com.bytedance.ai.bridge.method.system.GetLocationMethod;
import com.bytedance.ai.bridge.method.system.OpenMapAppMethod;
import com.bytedance.ai.bridge.method.system.VibrateLongMethod;
import com.bytedance.ai.bridge.method.system.VibrateShortMethod;
import com.bytedance.ai.bridge.method.system.permission.CheckPermissionMethod;
import com.bytedance.ai.bridge.method.system.permission.RequestPermissionMethod;
import com.bytedance.ai.bridge.method.tts.CancelTTSMethod;
import com.bytedance.ai.bridge.method.tts.SetTTSSwitchMethod;
import com.bytedance.ai.bridge.method.tts.StartTTSMethod;
import com.bytedance.ai.bridge.method.ui.AIBridgeSendQueryMessageMethod;
import com.bytedance.ai.bridge.method.ui.HandleContentSizeChangeMethod;
import com.bytedance.ai.bridge.method.ui.HandleWebDrawEndMethod;
import com.bytedance.ai.bridge.method.ui.SendUIContextMethod;
import com.bytedance.ai.bridge.method.ui.ShowModalMethod;
import com.bytedance.ai.bridge.method.ui.ShowToastMethod;
import com.bytedance.ai.ex.widget.LogAdapter;
import com.bytedance.ai.jsb.AISetIsNeedAliveMethod;
import com.bytedance.ai.resource.IAIPackageNetService;
import com.bytedance.ai.resource.j;
import com.bytedance.ai.settings.AISDKSettingConfigManager;
import com.bytedance.ai.uiu.UIUInternalDebugBroadcastReceiver;
import com.bytedance.ai.utils.c;
import com.bytedance.ies.bullet.core.r;
import com.bytedance.mira.plugin.hook.flipped.Flipped;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostLogDependV2;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostNetworkDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostStyleUIDepend;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import com.lynx.tasm.p;
import com.relax.RelaxView;
import com.relax.relaxui.envs.UIRenderRelaxUI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.d2;
import kotlinx.coroutines.flow.e2;
import kotlinx.coroutines.flow.i;
import kotlinx.coroutines.flow.p2;
import kotlinx.coroutines.flow.q2;
import kotlinx.coroutines.h0;
import mn.h;
import q1.f;
import t0.b;
import t0.d;
import t0.e;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J5\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\fH\u0086@¢\u0006\u0004\b\u0011\u0010\u0012J?\u0010\r\u001a\u00020\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\r\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00178\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R$\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u001d\u0010&\u001a\b\u0012\u0004\u0012\u00020\"0%8\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)¨\u0006*"}, d2 = {"Lcom/bytedance/ai/ex/widget/inittasks/AISdkInitializer;", "", "<init>", "()V", "Lu0/a;", "config", "Lul/d;", "source", "Lt0/b;", "ability", "Lt0/d;", "logIMpl", "", "init", "(Lu0/a;Lul/d;Lt0/b;Lt0/d;)V", "injectAIBridgeBaseRuntime", "(Lu0/a;)V", "awaitAISdkInit", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/bytedance/ai/resource/IAIPackageNetService;", "netService", "geckoConfigs", "(Lcom/bytedance/ai/resource/IAIPackageNetService;Lu0/a;Lt0/b;Lt0/d;Lul/d;)V", "", "TAG", "Ljava/lang/String;", "Lt0/e;", "widgetHostLifecycle", "Lt0/e;", "getWidgetHostLifecycle", "()Lt0/e;", "setWidgetHostLifecycle", "(Lt0/e;)V", "Lkotlinx/coroutines/flow/d2;", "", "isInitialized", "Lkotlinx/coroutines/flow/d2;", "Lkotlinx/coroutines/flow/p2;", "initializedFlow", "Lkotlinx/coroutines/flow/p2;", "getInitializedFlow", "()Lkotlinx/coroutines/flow/p2;", "widget-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAISdkInitializer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AISdkInitializer.kt\ncom/bytedance/ai/ex/widget/inittasks/AISdkInitializer\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,145:1\n1#2:146\n*E\n"})
public final class AISdkInitializer {
    public static final AISdkInitializer INSTANCE = null;
    private static final String TAG = "AISdkInitializer";
    private static final p2 initializedFlow = null;
    private static d2 isInitialized;
    private static e widgetHostLifecycle;

    static {
        INSTANCE = new AISdkInitializer();
        q2 r5 = i.b(Boolean.FALSE);
        isInitialized = r5;
        initializedFlow = new e2(r5, null);
    }

    private AISdkInitializer() {
    }

    public static /* synthetic */ void init$default(AISdkInitializer r10, IAIPackageNetService r11, u0.a r12, b r13, d r14, ul.d r15, int r16, Object r17) {
        if ((r16 & 8) == 0) goto L5;
        d r5 = null;
    L7:
        if ((r16 & 16) == 0) goto L9;
        ul.d r18 = null;
    L10:
        r10.init(r11, r12, r13, r5, r18);
        return;
    L9:
        r18 = r15;
        goto L10
    L5:
        r5 = r14;
        goto L7
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [com.bytedance.ai.ex.widget.inittasks.AISdkInitializer$injectAIBridgeBaseRuntime$4$1, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v2, types: [com.bytedance.ai.ex.widget.inittasks.AISdkInitializer$injectAIBridgeBaseRuntime$3$1, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v3, types: [com.bytedance.ai.ex.widget.inittasks.AISdkInitializer$injectAIBridgeBaseRuntime$2$1, java.lang.Object] */
    private final void injectAIBridgeBaseRuntime(final u0.a r5) {
        final IHostContextDepend r10 = h.f20139k;
        if (r10 == null) goto L5;
        com.bytedance.ai.bridge.service.IHostContextDepend r11 = new AISdkInitializer$injectAIBridgeBaseRuntime$1$1(r10, r5);
        Intrinsics.checkNotNullParameter(r11, "hostContextDepend");
        k5.d.f18600a = r11;
    L5:
        final IHostLogDependV2 r12 = h.f20151x;
        if (r12 == null) goto L8;
        ?? r13 = new AISdkInitializer$injectAIBridgeBaseRuntime$2$1(r12);
        Intrinsics.checkNotNullParameter(r13, "hostLogDepend");
        k5.d.f18601b = r13;
    L8:
        final IHostNetworkDepend r14 = h.f20143o;
        if (r14 == null) goto L11;
        ?? r15 = new AISdkInitializer$injectAIBridgeBaseRuntime$3$1(r14);
        Intrinsics.checkNotNullParameter(r15, "hostNetDepend");
        k5.d.f18602c = r15;
    L11:
        final IHostStyleUIDepend r16 = h.f20140l;
        if (r16 == null) goto L15;
        ?? r17 = new AISdkInitializer$injectAIBridgeBaseRuntime$4$1(r16);
        Intrinsics.checkNotNullParameter(r17, "hostStyleUIDepend");
        k5.d.d = r17;
        return;
    }

    public final Object awaitAISdkInit(Continuation<? super Unit> r10) {
        SafeContinuation r11 = new SafeContinuation(IntrinsicsKt.intercepted(r10));
        BuildersKt.launch$default(h0.a(Dispatchers.getDefault()), null, null, new AISdkInitializer$awaitAISdkInit$2$1(r11, null), 3, null);
        Object r12 = r11.getOrThrow();
        if (r12 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        DebugProbesKt.probeCoroutineSuspended(r10);
    L6:
        if (r12 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L9;
        return r12;
    L9:
        return Unit.INSTANCE;
    }

    public final p2 getInitializedFlow() {
        return initializedFlow;
    }

    public final e getWidgetHostLifecycle() {
        return widgetHostLifecycle;
    }

    public final void init(IAIPackageNetService r5, u0.a r10, b r11, d r12, ul.d r13) {
        Intrinsics.checkNotNullParameter(r10, "config");
        Intrinsics.checkNotNullParameter(r11, "ability");
        if (r5 == null) goto L5;
        ConcurrentHashMap r14 = s2.a.f21813a;
        Intrinsics.checkNotNullParameter(IAIPackageNetService.class, "clazz");
        Intrinsics.checkNotNullParameter(r5, "instance");
        s2.a.f21813a.put(IAIPackageNetService.class, r5);
    L5:
        init(r10, r13, r11, r12);
    }

    public final void setWidgetHostLifecycle(e r5) {
        widgetHostLifecycle = r5;
    }

    public static /* synthetic */ void init$default(AISdkInitializer r5, u0.a r10, ul.d r11, b r12, d r13, int r14, Object r15) {
        if ((r14 & 8) == 0) goto L5;
        r13 = null;
    L5:
        r5.init(r10, r11, r12, r13);
    }

    private final void init(u0.a r20, ul.d r21, b r22, d r23) {
        int r5 = 3;
        boolean r10 = false;
        AtomicBoolean r11 = s0.a.f21798a;
        if (r23 != null) goto L5;
        d r12 = LogAdapter.INSTANCE.getAisdkLog();
    L6:
        Intrinsics.checkNotNullParameter(r20, "config");
        Intrinsics.checkNotNullParameter(r22, "ability");
        Intrinsics.checkNotNullParameter(r12, "logIMpl");
        AtomicBoolean r13 = s0.a.f21798a;
        if (r13.get() == true) goto L129;
        Intrinsics.checkNotNullParameter("AISDK", "tag");
        d r14 = c.f2846a;
        if (r14 == null) goto L12;
        r14.i("AISDK", "AISDK init start");
    L12:
        r13.set(true);
        s0.a.f21800c = r20;
        Application r15 = r20.f22194a;
        if (r15 != null) goto L16;
        r15 = null;
    L16:
        if (r15 == null) goto L21;
        Intrinsics.checkNotNullParameter(r15, "app");
        if (p.f10924a != null) goto L20;
        p.f10924a = r15;
        goto L21
    L20:
        Intrinsics.checkNotNullParameter("ContextProvider", "tag");
        Intrinsics.checkNotNullParameter("ContextProvider has already been initialized", "msg");
        a1.a.f43a.e("ContextProvider", "ContextProvider has already been initialized", null);
    L21:
        bd.d r16 = new bd.d(r12);
        Intrinsics.checkNotNullParameter(r16, "log");
        a1.a.f43a = r16;
        com.bytedance.ai.model.p.f2294c = r22;
        c.f2846a = r12;
        Intrinsics.checkNotNullParameter(r20.f22194a, "context");
        Intrinsics.checkNotNullParameter(r20.f22194a, "context");
        r2.b r17 = r2.b.f21643a;
        Application r18 = r20.f22194a;
        Intrinsics.checkNotNullParameter(r18, "context");
        Context r19 = r18.getApplicationContext();
        if ((r19 instanceof Application) == false) goto L24;
        Application r24 = (Application) r19;
    L25:
        if (r24 != null) goto L28;
    L36:
        a3.i r25 = a3.i.f83a;
        Intrinsics.checkNotNullParameter(r25, "impl");
        td.d.f22127b = r25;
        ArrayList r26 = q1.c.f21464a;
        f r27 = f.f21468a;
        Intrinsics.checkNotNullParameter(r27, "handler");
        ArrayList r110 = q1.c.f21464a;
        r110.add(r27);
        q1.e r28 = q1.e.f21466a;
        Intrinsics.checkNotNullParameter(r28, "handler");
        r110.add(r28);
        q1.b r29 = q1.b.f21462a;
        Intrinsics.checkNotNullParameter(r29, "handler");
        r110.add(r29);
        o1.i r30 = o1.i.f20397c;
        r30.b(GetStorageMethod.class);
        r30.b(SetStorageMethod.class);
        r30.b(RemoveStorageMethod.class);
        r30.b(ClearStorageMethod.class);
        r30.b(GetStorageInfoMethod.class);
        r30.b(RequestMethod.class);
        r30.b(SubscribeEventMethod.class);
        r30.b(UnSubscribeEventMethod.class);
        r30.b(OpenPageMethod.class);
        r30.b(DisplayFloatingMaskMethod.class);
        r30.b(SetFloatingWindowVisibleMethod.class);
        r30.b(CloseFloatingWindowMethod.class);
        r30.b(CreateWidgetMethod.class);
        r30.b(CreateTextMethod.class);
        r30.b(ReportAppLogMethod.class);
        r30.b(ReportPerformanceEntriesMethod.class);
        r30.b(AIBridgeSendQueryMessageMethod.class);
        r30.b(SendUIContextMethod.class);
        r30.b(SetAdditionalContextMethod.class);
        r30.b(HandleContentSizeChangeMethod.class);
        r30.b(AppletRequestMethod.class);
        r30.b(CancelStreamRequestMethod.class);
        r30.b(HandleWebDrawEndMethod.class);
        r30.b(ShowToastMethod.class);
        r30.b(GetAppInfoMethod.class);
        r30.b(GetDebugInfoMethod.class);
        r30.b(AIStorageSetMethodV2.class);
        r30.b(AIStorageGetMethodV2.class);
        r30.b(AIStorageRemoveMethodV2.class);
        r30.b(AIStorageSubscribeMethodV2.class);
        r30.b(AIStorageUnSubscribeMethodV2.class);
        r30.b(UpdateBotIdMethod.class);
        r30.b(UpdateInputPlaceHolderMethod.class);
        r30.b(UpdateInputOffsetMethod.class);
        r30.b(ClearContextMethod.class);
        r30.b(SetAppendQueryMethod.class);
        r30.b(ClearAppendQueryMethod.class);
        r30.b(SetMessageIndicationMethod.class);
        r30.b(SetTTSSwitchMethod.class);
        r30.b(SetChatInputVisibleMethod.class);
        r30.b(StartTTSMethod.class);
        r30.b(CancelTTSMethod.class);
        r30.b(SetBackGestureEnableMethod.class);
        r30.b(RedirectInputMethod.class);
        r30.b(UpdateInputTextMethod.class);
        r30.b(SetInputModeMethod.class);
        r30.b(GetInputModeMethod.class);
        r30.b(SetEnvContextMethod.class);
        r30.b(OpenMapAppMethod.class);
        r30.b(UpdatePackageMethod.class);
        r30.b(AISetIsNeedAliveMethod.class);
        r30.b(RequestPermissionMethod.class);
        r30.b(CheckPermissionMethod.class);
        r30.b(CloseMethod.class);
        r30.b(GetUserInfoMethod.class);
        r30.b(GetLocationMethod.class);
        r30.b(VibrateLongMethod.class);
        r30.b(VibrateShortMethod.class);
        r30.b(CopyMethod.class);
        r30.b(OpenMethod.class);
        r30.b(ShowModalMethod.class);
        r30.b(ExecuteSqliteActionMethod.class);
        r30.b(GetCalendarsMethod.class);
        r30.b(GetCalendarObjectsMethod.class);
        r30.b(GetCalendarEventDetailMethod.class);
        r30.b(SyncCalendarMethod.class);
        r30.b(GetPhoneNumMethod.class);
        r30.b(OpenAppMethod.class);
        r30.b(LoginMethod.class);
        r30.b(GetPrivacySettingMethod.class);
        r30.b(AgreeAuthMethod.class);
        r30.b(PostLoginResultMethod.class);
        r30.b(RequestOrderMethod.class);
        r30.b(GetOrderPaymentMethod.class);
        r30.b(InitConfigMethod.class);
        r30.b(CustomReportMethod.class);
        Intrinsics.checkNotNullParameter("ai_bridge", "tag");
        d r31 = c.f2846a;
        if (r31 == null) goto L39;
        r31.i("ai_bridge", "internal method has registered");
    L39:
        Intrinsics.checkNotNullParameter(r20, "config");
        com.bytedance.ai.multiprocess.a r32 = com.bytedance.ai.multiprocess.d.f2406a;
        if (r32 == null) goto L62;
        Intrinsics.checkNotNullParameter(r20, "config");
        Map r33 = u0.b.f22207a;
        Intrinsics.checkNotNullParameter(r20, "<this>");
        u0.c r34 = (u0.c) u0.b.f22207a.get(r20);
        r32.f2400a = r34;
        Intrinsics.checkNotNullParameter(r20, "<this>");
        r32.f2401b = (Function1) u0.b.f22208b.get(r20);
        if (r34 != null) goto L44;
    L46:
        boolean r35 = false;
    L47:
        r32.f2402c = r35;
        r32.d.clear();
        if (r34 == null) goto L52;
        LinkedHashSet r36 = r34.d;
        if (r36 == null) goto L52;
        r32.d.addAll(r36);
    L52:
        if (r34 != null) goto L54;
    L58:
        if (r34 == null) goto L62;
        if (r32.f2402c == true) goto L62;
        LinkedHashMap r37 = com.bytedance.ai.process.i.f2427a;
        LinkedHashMap r38 = r34.f22211c;
        Intrinsics.checkNotNullParameter(r38, "authorizedPackageList");
        com.bytedance.ai.process.i.f2427a.putAll(r38);
        goto L62
    L54:
        if (r34.f22209a == false) goto L56;
    L57:
        com.bytedance.ai.process.d r39 = com.bytedance.ai.process.d.f2415a;
        com.bytedance.ai.process.d.b(r20.f22194a, r34);
        goto L58
    L56:
        if (r34.d.isEmpty() == true) goto L58;
    L44:
        if (r34.f22209a != true) goto L46;
        r35 = true;
    L62:
        AtomicBoolean r40 = s0.c.f21801a;
        Application r41 = r20.f22194a;
        boolean r42 = r20.f22200k;
        Intrinsics.checkNotNullParameter(r41, "application");
        if (s0.c.f21801a.get() == true) goto L119;
        s0.c.f21801a = new AtomicBoolean(true);
        s0.c.f21802b = r42;
        Intrinsics.checkNotNullParameter(r41, "<set-?>");
        s0.c.f21803c = r41;
        a3.f r111 = new a3.f(29);
        Intrinsics.checkNotNullParameter(r111, "task");
        com.bytedance.ai.multiprocess.a r112 = com.bytedance.ai.multiprocess.d.f2406a;
        if (r112 == null) goto L71;
        Intrinsics.checkNotNullParameter(r111, "task");
        Function1 r113 = r112.f2401b;
        if (r113 == null) goto L70;
        r113.invoke(r111);
    L72:
        q2.a r114 = q2.a.f21470a;
        Application r115 = s0.c.a();
        List r116 = CollectionsKt.emptyList();
        r r117 = new r(2);
        Intrinsics.checkNotNullParameter(r115, "application");
        Intrinsics.checkNotNullParameter(r116, "excludedActivitiesClassName");
        q2.a.f = r116;
        Context r118 = r115.getApplicationContext();
        if ((r118 instanceof Application) == false) goto L75;
        Application r119 = (Application) r118;
    L76:
        if (r119 == null) goto L78;
        r119.registerActivityLifecycleCallbacks(r117);
    L78:
        b r120 = com.bytedance.ai.model.p.f2294c;
        if (r120 == null) goto L81;
        r120.registerWidgetHostLifecycle(new s0.b());
    L81:
        b r121 = com.bytedance.ai.model.p.f2294c;
        if (r121 == null) goto L84;
        r121.registerAppBackgroundListener(new com.bytedance.frameworks.baselib.network.http.cronet.b(16));
    L84:
        b r122 = com.bytedance.ai.model.p.f2294c;
        if (r122 == null) goto L87;
        r122.createAppletConversations();
    L87:
        if (r42 == true) goto L94;
        u0.a r43 = s0.a.f21800c;
        if (r43 != null) goto L91;
    L93:
        boolean r123 = false;
    L95:
        j.i(r41, r123, r21);
        Application r44 = s0.c.a();
        if (r44 == null) goto L98;
        Application r124 = r44;
    L99:
        if (r124 == null) goto L106;
        Lazy r45 = com.bytedance.ai.widget.c.f2935a;
        Intrinsics.checkNotNullParameter(r124, "application");
        r124.registerActivityLifecycleCallbacks(new com.bytedance.ai.widget.b());
        if (s0.c.f21802b == false) goto L106;
        if (Build.VERSION.SDK_INT < 34) goto L105;
        UIUInternalDebugBroadcastReceiver r46 = new UIUInternalDebugBroadcastReceiver();
        IntentFilter r125 = new IntentFilter();
        r125.addAction("com.bytedance.applet.TEST_UIU_CONTEXT");
        r125.addAction("com.bytedance.applet.TEST_UIU_OPERATIONS");
        Unit r47 = Unit.INSTANCE;
        r124.registerReceiver(r46, r125, null, null, 2);
        goto L106
    L105:
        UIUInternalDebugBroadcastReceiver r48 = new UIUInternalDebugBroadcastReceiver();
        IntentFilter r49 = new IntentFilter();
        r49.addAction("com.bytedance.applet.TEST_UIU_CONTEXT");
        r49.addAction("com.bytedance.applet.TEST_UIU_OPERATIONS");
        Unit r50 = Unit.INSTANCE;
        r124.registerReceiver(r48, r49);
    L106:
        AtomicBoolean r51 = z2.d.f23373a;
        if (r51.get() == true) goto L119;
        r51.set(true);
        Iterator r52 = z2.d.f23375c.iterator();
    L111:
        if (r52.hasNext() == false) goto L115;
        Runnable r53 = (Runnable) r52.next();
        Handler r54 = z2.d.f23374b;
        if (r54 == null) goto L111;
        r54.post(r53);
        goto L111
    L115:
        z2.d.f23375c.clear();
        Handler r55 = vl.a.f22587a;
        f3.a r56 = new f3.a(5);
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L118;
        new c1.a(r56, r5, r10).run();
        goto L119
    L118:
        vl.a.f22587a.post(new c1.a(r56, r5, r10));
        goto L119
    L98:
        r124 = null;
        goto L99
    L91:
        if (r43.f22201l != true) goto L93;
    L94:
        r123 = true;
        goto L95
    L75:
        r119 = null;
        goto L76
    L70:
        r111.invoke();
        goto L72
    L71:
        r111.invoke();
    L119:
        Trace.beginSection("initLynx");
        Application r57 = r20.f22194a;
        Intrinsics.checkNotNullParameter(r57, "context");
        IIvyAIPackageResourceService.Companion.ensureInitLynx(r57);
        Trace.endSection();
        Trace.beginSection("initRelax");
        Application r58 = r20.f22194a;
        Intrinsics.checkNotNullParameter(r58, "context");
        Flipped.a();
        String r59 = String.valueOf(AISDKSettingConfigManager.INSTANCE.getRELAX_CONFIG().getValue().b());
        String r60 = "ensureInitRelax: ".concat(r59);
        Intrinsics.checkNotNullParameter("AppletRelaxViewApi", "tag");
        d r61 = c.f2846a;
        if (r61 == null) goto L122;
        r61.d("AppletRelaxViewApi", r60);
    L122:
        RelaxView.initGlobal(r58, r59);
        UIRenderRelaxUI.initGlobal(r20.f22194a, null);
        Trace.endSection();
        if (com.bytedance.ai.widget.cache.a.f2980a == false) goto L125;
        com.bytedance.ai.widget.cache.c.a();
    L125:
        Intrinsics.checkNotNullParameter("AISDK", "tag");
        d r62 = c.f2846a;
        if (r62 == null) goto L128;
        r62.i("AISDK", "AISDK init end");
    L128:
        s0.a.f21799b.N(Unit.INSTANCE);
        goto L129
    L28:
        if (r2.b.f21644b.compareAndSet(false, true) == false) goto L36;
        r2.b.d = r24;
        Resources r63 = r24.getResources();
        DisplayMetrics r126 = r63.getDisplayMetrics();
        Configuration r64 = r63.getConfiguration();
        r2.b.e = new r2.a(r64.fontScale, r126.widthPixels, r126.heightPixels, r64.densityDpi, r64.orientation);
        Object r65 = r24.getSystemService("display");
        if ((r65 instanceof DisplayManager) == false) goto L33;
        DisplayManager r66 = (DisplayManager) r65;
    L34:
        if (r66 == null) goto L36;
        r66.registerDisplayListener(r2.b.g, r2.b.f21645c);
        goto L36
    L33:
        r66 = null;
        goto L34
    L24:
        r24 = null;
    L129:
        injectAIBridgeBaseRuntime(r20);
        d2 r67 = isInitialized;
        Boolean r68 = Boolean.TRUE;
        q2 r69 = (q2) r67;
        r69.getClass();
        r69.j(null, r68);
        return;
    L5:
        r12 = r23;
        goto L6
    }
}
