package com.larus.voicecall.impl.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.audio.AudioServiceDelegate;
import com.larus.audio.call.mgr.MajorState;
import com.larus.audio.call.tracer.IRealtimeCallTracer;
import com.larus.av_call.databinding.LarusFragmentInstantCallBaseBinding;
import com.larus.common.apphost.AppHost;
import com.larus.home.impl.sdk.s;
import com.larus.im.FlowRuntime;
import com.larus.im.service.audio.AudioSessionType;
import com.larus.im.service.audio.z0;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.service.z2;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.ui.arch.component.internal.attach.Attachable;
import com.larus.ui.arch.component.internal.attach.FragmentAttachExtKt;
import com.larus.ui.arch.component.internal.control.ComponentStateController;
import com.larus.ui.arch.modulizer.di.ContainerFilter;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.impl.util.RealtimeCallUtil;
import com.larus.voicecall.impl.util.q0;
import com.lynx.jsbridge.LynxAccessibilityModule;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.xelement.webview.LynxUIWebView;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.spi.interact.ObricInteractDelegate;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import g88.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000Æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 e2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001eB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u000102H\u0016J\b\u00103\u001a\u000200H\u0002J\b\u00104\u001a\u000200H\u0002J\b\u00105\u001a\u000200H\u0002J\b\u00106\u001a\u000200H\u0002J\u0006\u00107\u001a\u000200J\"\u00108\u001a\u0002002\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020:2\b\u0010<\u001a\u0004\u0018\u00010=H\u0016J$\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020A2\b\u0010B\u001a\u0004\u0018\u00010C2\b\u00101\u001a\u0004\u0018\u000102H\u0016J\u001a\u0010D\u001a\u0002002\u0006\u0010E\u001a\u00020?2\b\u00101\u001a\u0004\u0018\u000102H\u0016J\b\u0010N\u001a\u000200H\u0002J\u0018\u0010O\u001a\u0002002\u0006\u0010P\u001a\u00020L2\u0006\u0010Q\u001a\u00020:H\u0002J\u0010\u0010R\u001a\u0002002\u0006\u0010S\u001a\u00020TH\u0016J\u0010\u0010U\u001a\u0002002\u0006\u0010V\u001a\u00020WH\u0016J\b\u0010X\u001a\u000200H\u0016J\u001a\u0010Y\u001a\u0002002\u0006\u0010V\u001a\u00020Z2\b\u0010[\u001a\u0004\u0018\u00010\\H\u0016J\b\u0010]\u001a\u000200H\u0016J\b\u0010^\u001a\u000200H\u0016J\b\u0010_\u001a\u000200H\u0002J\b\u0010`\u001a\u000200H\u0016J\u000e\u0010a\u001a\b\u0012\u0004\u0012\u00020c0bH\u0002J\b\u0010d\u001a\u000200H\u0016R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u000b\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001d\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u000b\u001a\u0004\b\u001f\u0010 R\u001b\u0010\"\u001a\u00020#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u000b\u001a\u0004\b$\u0010%R\u001b\u0010'\u001a\u00020(8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010\u000b\u001a\u0004\b)\u0010*R\u000e\u0010,\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010F\u001a\u0004\u0018\u00010GX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010H\u001a\u0004\u0018\u00010GX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010J\u001a\u000e\u0012\u0004\u0012\u00020L\u0012\u0004\u0012\u00020:0KX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010M\u001a\u000e\u0012\u0004\u0012\u00020L\u0012\u0004\u0012\u00020:0KX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006f"}, d2 = {"Lcom/larus/voicecall/impl/ui/RealtimeCallFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/larus/common/apphost/lifecycle/ActivityStackManager$OnAppBackGroundListener;", "Lcom/larus/audio/call/ILinkCallback;", "<init>", "()V", "binding", "Lcom/larus/av_call/databinding/LarusFragmentInstantCallBaseBinding;", "getBinding", "()Lcom/larus/av_call/databinding/LarusFragmentInstantCallBaseBinding;", "binding$delegate", "Lkotlin/Lazy;", "argumentData", "Lcom/larus/voicecall/impl/bean/RealtimeArgumentData;", "getArgumentData", "()Lcom/larus/voicecall/impl/bean/RealtimeArgumentData;", "argumentData$delegate", "runtimeData", "Lcom/larus/voicecall/impl/bean/RealtimeRuntimeData;", "getRuntimeData", "()Lcom/larus/voicecall/impl/bean/RealtimeRuntimeData;", "runtimeData$delegate", "hasPreloadedRTCTokenOnFirstResume", NameKeys.UnloadStrategy_No_Strategy, "viewStateManager", "Lcom/larus/voicecall/impl/realtime/RealtimeCallViewStateManager;", "getViewStateManager", "()Lcom/larus/voicecall/impl/realtime/RealtimeCallViewStateManager;", "viewStateManager$delegate", "realtimeDialogManager", "Lcom/larus/voicecall/impl/component/dialog/RealtimeDialogManager;", "getRealtimeDialogManager", "()Lcom/larus/voicecall/impl/component/dialog/RealtimeDialogManager;", "realtimeDialogManager$delegate", "callService", "Lcom/larus/voicecall/impl/RealtimeCallService;", "getCallService", "()Lcom/larus/voicecall/impl/RealtimeCallService;", "callService$delegate", "tracer", "Lcom/larus/audio/call/tracer/IRealtimeCallTracer;", "getTracer", "()Lcom/larus/audio/call/tracer/IRealtimeCallTracer;", "tracer$delegate", "hasReportedABTestEvents", "realtimeCallContainer", "Lcom/larus/ui/arch/component/external/api/receiver/Container;", "onCreate", NameKeys.UnloadStrategy_No_Strategy, "savedInstanceState", "Landroid/os/Bundle;", "reportABTestEvents", "setVui", "checkAVKitInit", "bindData", "attachComponent", "onActivityResult", "requestCode", NameKeys.UnloadStrategy_No_Strategy, "resultCode", LynxResourceModule.DATA_KEY, "Landroid/content/Intent;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "stateCollectJob", "Lkotlinx/coroutines/Job;", "controlStateCollectJob", "lastControlPaused", "lastDuplexLogState", "Lkotlin/Pair;", "Lcom/larus/audio/call/mgr/MajorState;", "lastSerialLogState", "listenOnCallStateChange", "dispatchUIStateChange", "majorState", "state", "onConnectionStateChanged", "status", "Lcom/larus/im/internal/audio/context/SessionState;", "onReceiveEvent", "event", "Lcom/larus/im/service/audio/MediaSessionListener$Event;", "onAppBackground", "otherEvent", NameKeys.UnloadStrategy_No_Strategy, LynxAccessibilityModule.MSG_CONTENT, NameKeys.UnloadStrategy_No_Strategy, "onAppForeground", "onResume", "preloadRTCTokenOnFirstResume", "onAllActivityDestroyed", "getRealtimeComponents", NameKeys.UnloadStrategy_No_Strategy, "Lcom/larus/av_call/component/IRealtimeComponentExt;", "onDestroy", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class RealtimeCallFragment extends Fragment implements f09.a.b, com.larus.audio.call.k {
    public static final /* synthetic */ int r = 0;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public boolean g;
    public final Lazy h;
    public final Lazy i;
    public final Lazy j;
    public final Lazy k;
    public boolean l;
    public Job m;
    public Job n;
    public boolean o;
    public Pair<? extends MajorState, Integer> p;
    public Pair<? extends MajorState, Integer> q;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.larus.voicecall.impl.ui.RealtimeCallFragment$onDestroy$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.voicecall.impl.ui.RealtimeCallFragment$onDestroy$1", f = "RealtimeCallFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> r2) {
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return new AnonymousClass1(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L12;
            ResultKt.throwOnFailure(r2);
            IFlowSdkDepend r3 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
            if (r3 == null) goto L10;
            s r4 = r3.s0();
            if (r4 == null) goto L10;
            r4.j();
        L10:
            return Unit.INSTANCE;
        L12:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
    }

    public final void onAllActivityDestroyed() {
    }

    public final e3a.a T90() {
        return (e3a.a) this.e.getValue();
    }

    public final com.larus.voicecall.impl.RealtimeCallService U90() {
        return (com.larus.voicecall.impl.RealtimeCallService) this.j.getValue();
    }

    public final List<r> V90() {
        ArrayList r0 = new ArrayList();
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L16
        Intrinsics.checkNotNullParameter(this, "<this>");     // Catch: Throwable -> L16
        Attachable.a r2 = Attachable.Companion;     // Catch: Throwable -> L16
        FragmentActivity r3 = requireActivity();     // Catch: Throwable -> L16
        r2.getClass();     // Catch: Throwable -> L16
        ComponentStateController r4 = Attachable.a.a(r3).getComponentStateController$component_release(this);     // Catch: Throwable -> L16
        if (r4 == null) goto L7;
        Iterable r5 = r4.d;     // Catch: Throwable -> L16
        if (r5 == null) goto L7;
    L8:
        Iterator r6 = r5.iterator();     // Catch: Throwable -> L16
    L10:
        if (r6.hasNext() == false) goto L14;
        ComponentFeature r7 = (ComponentFeature) r6.next();     // Catch: Throwable -> L16
        if ((r7 instanceof r) == false) goto L10;
        r0.add(r7);     // Catch: Throwable -> L16
        goto L10
    L14:
        Object r8 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L16
    L18:
        Throwable r9 = Result.exceptionOrNull-impl(r8);
        if (r9 == null) goto L22;
        FLogger.a.e("RealtimeCallFragment", "error:" + r9);
    L22:
        return r0;
    L7:
        r5 = new ArrayList();     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L18
    }

    public final e3a.b W90() {
        return (e3a.b) this.f.getValue();
    }

    public final IRealtimeCallTracer X90() {
        return (IRealtimeCallTracer) this.k.getValue();
    }

    public final void onResume() {
        FLogger r0 = FLogger.a;
        r0.d("jyt_test", "onResume, start");
        X90().j0(true);
        super.onResume();
        if (this.g == false) goto L5;
    L8:
        X90().j0(false);
        r0.d("jyt_test", "onResume, end");
        return;
    L5:
        if (((h88.b) W90()).e != AudioSessionType.RTC) goto L8;
        this.g = true;
        AudioServiceDelegate.a.getAudioConfig().r("first_vc_view_did_appear");
        goto L8
    }

    public RealtimeCallFragment() {
        this.d = LazyKt.lazy(new e(this));
        this.e = LazyKt.lazy(new f(this));
        this.f = LazyKt.lazy(new g(this));
        this.h = LazyKt.lazy(new h(this));
        this.i = LazyKt.lazy(new i());
        this.j = LazyKt.lazy(new j(this));
        this.k = LazyKt.lazy(new k(this));
        MajorState.c r0 = MajorState.c.c;
        this.p = TuplesKt.to(r0, -1);
        this.q = TuplesKt.to(r0, -1);
    }

    public final void onAppBackground() {
        Iterator<T> r0 = V90().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((r) r0.next()).onAppBackground();
        goto L4
    }

    public final void onAppForeground() {
        Iterator<T> r0 = V90().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((r) r0.next()).onAppForeground();
        goto L4
    }

    public final void onDestroy() {
        FragmentActivity r0 = getActivity();
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L10;
    L16:
        super.onDestroy();
        FLogger.a.d("RealtimeCallFragment", "onDestroy, runtimeData:" + W90() + ",callParam:" + W90().a());
        if (((h88.a) T90()).k0 == false) goto L21;
        RealtimeCallUtil.a.getClass();
        if (RealtimeCallUtil.u() == false) goto L21;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AnonymousClass1(null), 3, null);
    L21:
        AppHost.a.a().c(this);
        return;
    L10:
        if (this.l == true) goto L16;
        this.l = true;
        int r3 = i38.a.a;
        z2 r2 = z2.a;
        Iterator r4 = CollectionsKt.listOf(new Pair[]{TuplesKt.to("voice_call_ab_sdk_test_uid", FlowRuntime.b().g().f("voice_call_ab_sdk_test_uid", LynxUIWebView.DEFAULT, true)), TuplesKt.to("voice_call_ab_sdk_test_did", FlowRuntime.b().g().f("voice_call_ab_sdk_test_did", LynxUIWebView.DEFAULT, true)), TuplesKt.to("voice_call_ab_test_uid", r2.getVoiceCallAbTestUid()), TuplesKt.to("voice_call_ab_test_did", r2.getVoiceCallAbTestDid()), TuplesKt.to("voice_call_ab_server_test_uid", r2.getVoiceCallAbServerTestUid()), TuplesKt.to("voice_call_ab_server_test_did", r2.getVoiceCallAbServerTestDid())}).iterator();
    L14:
        if (r4.hasNext() == false) goto L16;
        Pair r5 = (Pair) r4.next();
        com.larus.platform.service.o.a.reportEvent((String) r5.component1(), new JSONObject().put("event_value", (String) r5.component2()));
        goto L14
    L5:
        if (r0.isChangingConfigurations() != true) goto L7;
        r1 = true;
        goto L8
    }

    public final void D9(z0.a r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        Iterator<T> r0 = V90().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((r) r0.next()).D9(r3);
        goto L4
    }

    public final void I6(jd9.c r3) {
        Intrinsics.checkNotNullParameter(r3, "status");
        Iterator<T> r0 = V90().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((r) r0.next()).I6(r3);
        goto L4
    }

    public final void onCreate(Bundle r8) {
        if (((h88.a) T90()).k0 == false) goto L8;
        q0.a();
        if (com.larus.audio.call.f.c.c() == true) goto L7;
        FLogger.a.e(NameKeys.UnloadStrategy_No_Strategy, "[checkAVKitInit] FlowAVKit not init, init now!");
        com.larus.audio.call.f.e(AppHost.a.getApplication(), new com.larus.voicecall.impl.i());
        goto L8
    L7:
        com.larus.audio.call.f.g();
    L8:
        super.onCreate(r8);
        FLogger.a.i("jyt_test", "onCreate: start");
        X90().q(true, ((h88.a) T90()).a);
        s1a.a.g(this).n(T90(), e3a.a.class);
        s1a.a.g(this).n(W90(), e3a.b.class);
        s1a.a.g(this).n(U90(), com.larus.voicecall.impl.RealtimeCallService.class);
        s1a.a.g(this).n((w3a.k) this.h.getValue(), w3a.k.class);
        s1a.a.g(this).n((h3a.c) this.i.getValue(), h3a.c.class);
        k1a.b.a(this, new l(this));
        FragmentAttachExtKt.b(this, ContainerFilter.REALTIME_CALL);
        Iterator r9 = ((ArrayList) V90()).iterator();
    L10:
        if (r9.hasNext() == false) goto L13;
        ((r) r9.next()).A0();
        goto L10
    L13:
        if (((h88.a) T90()).k0 == false) goto L17;
        RealtimeCallUtil.a.getClass();
        if (RealtimeCallUtil.u() == false) goto L17;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new RealtimeCallFragment$setVui$1(null), 3, null);
    L17:
        AppHost.a.a().j(this);
        X90().q(false, ((h88.a) T90()).a);
        FLogger.a.i("jyt_test", "onCreate: end");
    }

    public final void onViewCreated(View r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r11, "view");
        super.onViewCreated(r11, r12);
        X90().D(true);
        if (com.larus.audio.call.f.f() == false) goto L11;
        FLogger.a.i("RealtimeCallFragment", "[CALL] listenOnCallStateChange invoked, prev=" + this.m);
        Job r13 = this.m;
        if (r13 == null) goto L7;
        Job.DefaultImpls.cancel$default(r13, null, 1, null);
    L7:
        Job r14 = this.n;
        if (r14 == null) goto L10;
        Job.DefaultImpls.cancel$default(r14, null, 1, null);
    L10:
        this.o = false;
        this.n = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new RealtimeCallFragment$listenOnCallStateChange$1(this, null), 3, null);
        this.m = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new RealtimeCallFragment$listenOnCallStateChange$2(this, null), 3, null);
    L12:
        X90().D(false);
        return;
    L11:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new RealtimeCallFragment$listenOnCallStateChange$3(this, null), 3, null);
        goto L12
    }

    public final void z2(String r3, Object r4) {
        Intrinsics.checkNotNullParameter(r3, "event");
        Iterator<T> r0 = V90().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((r) r0.next()).z2(r3, r4);
        goto L4
    }

    public static final void S90(RealtimeCallFragment r7, MajorState r8, int r9) {
        int r0 = ((h88.b) r7.W90()).k;
        MajorState r1 = ((h88.b) r7.W90()).l;
        if (r0 == r9) goto L5;
    L9:
        e3a.b r2 = r7.W90();
        r2.getClass();
        if (r9 == 14) goto L13;
        if (r9 == 15) goto L13;
        ((h88.b) r2).k = r9;
    L13:
        e3a.b r3 = r7.W90();
        r3.getClass();
        Intrinsics.checkNotNullParameter(r8, "<set-?>");
        ((h88.b) r3).l = r8;
        if (com.larus.audio.call.f.f() == false) goto L16;
    L26:
        Iterator r10 = ((ArrayList) r7.V90()).iterator();
    L28:
        if (r10.hasNext() == false) goto L32;
        ((r) r10.next()).o1(r1, r0, r8, r9);
        goto L28
    L32:
        return;
    L16:
        if (r9 != 7) goto L18;
        ((h88.b) r7.W90()).n = true;
        goto L26
    L18:
        if (r9 == 8) goto L24;
        if (r9 == 14) goto L23;
        if (r9 != 15) goto L26;
        ((h88.b) r7.W90()).m = false;
        ObricInteractDelegate.b.updateMuteStatus(false);
        goto L26
    L23:
        ((h88.b) r7.W90()).m = true;
        ObricInteractDelegate.b.updateMuteStatus(true);
        goto L26
    L24:
        ((h88.b) r7.W90()).n = false;
        goto L26
    L5:
        if (r9 == 3) goto L9;
        if (Intrinsics.areEqual(r1, r8) == false) goto L9;
    }

    public final void onActivityResult(int r3, int r4, Intent r5) {
        super.onActivityResult(r3, r4, r5);
        Iterator<T> r0 = V90().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((r) r0.next()).onActivityResult(r3, r4, r5);
        goto L4
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        super.onCreateView(r2, r3, r4);
        X90().f0(true);
        ConstraintLayout r5 = ((LarusFragmentInstantCallBaseBinding) this.d.getValue()).a;
        w3a.k r6 = (w3a.k) this.h.getValue();
        LarusFragmentInstantCallBaseBinding r7 = (LarusFragmentInstantCallBaseBinding) this.d.getValue();
        r6.getClass();
        Intrinsics.checkNotNullParameter(r7, "binding");
        r6.c = r7;
        X90().f0(false);
        return r5;
    }
}
