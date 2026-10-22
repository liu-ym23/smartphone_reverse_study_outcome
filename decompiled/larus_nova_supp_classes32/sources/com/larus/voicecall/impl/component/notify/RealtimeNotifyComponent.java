package com.larus.voicecall.impl.component.notify;

import android.app.KeyguardManager;
import android.graphics.Bitmap;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.common.utility.NetworkUtils;
import com.larus.audio.call.mgr.MajorState;
import com.larus.av_call.component.RealtimeComponent;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.impl.l;
import com.larus.voicecall.impl.util.RealtimeCallUtil;
import com.larus.voicecall.impl.utils.j;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.ability.interaction.IRealtimeCallBridgeAbility;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 @2\u00020\u00012\u00020\u0002:\u0001@B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010*\u001a\u00020+H\u0016J\b\u0010,\u001a\u00020+H\u0016J\b\u0010-\u001a\u00020+H\u0016J\b\u0010.\u001a\u00020+H\u0016J\u0010\u0010/\u001a\u00020+2\u0006\u00100\u001a\u000201H\u0016J\b\u00102\u001a\u00020+H\u0002J\b\u00103\u001a\u00020+H\u0002J(\u00104\u001a\u00020+2\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u0002062\u0006\u0010:\u001a\u000208H\u0016J\u0010\u0010;\u001a\u00020+2\u0006\u0010<\u001a\u00020=H\u0002J\u0010\u0010>\u001a\u0004\u0018\u00010(H\u0082@¢\u0006\u0002\u0010?R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0010\u001a\u0004\u0018\u00010\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\n\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\u001a\u001a\u0004\u0018\u00010\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\n\u001a\u0004\b\u001c\u0010\u001dR\u001d\u0010\u001f\u001a\u0004\u0018\u00010 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\n\u001a\u0004\b!\u0010\"R\u0012\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0004\n\u0002\u0010&R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006A"}, d2 = {"Lcom/larus/voicecall/impl/component/notify/RealtimeNotifyComponent;", "Lcom/larus/av_call/component/RealtimeComponent;", "Lcom/larus/voicecall/impl/component/notify/IRealtimeNotifyAbility;", "<init>", "()V", "argumentData", "Lcom/larus/voicecall/impl/bean/RealtimeArgumentData;", "getArgumentData", "()Lcom/larus/voicecall/impl/bean/RealtimeArgumentData;", "argumentData$delegate", "Lkotlin/Lazy;", "runtimeData", "Lcom/larus/voicecall/impl/bean/RealtimeRuntimeData;", "getRuntimeData", "()Lcom/larus/voicecall/impl/bean/RealtimeRuntimeData;", "runtimeData$delegate", "windowAbility", "Lcom/larus/voicecall/impl/component/window/IRealtimeWindowAbility;", "getWindowAbility", "()Lcom/larus/voicecall/impl/component/window/IRealtimeWindowAbility;", "windowAbility$delegate", "coreAbility", "Lcom/larus/voicecall/impl/component/core/IRealtimeCoreAbility;", "getCoreAbility", "()Lcom/larus/voicecall/impl/component/core/IRealtimeCoreAbility;", "coreAbility$delegate", "traceAbility", "Lcom/larus/voicecall/impl/component/trace/IRealtimeTraceAbility;", "getTraceAbility", "()Lcom/larus/voicecall/impl/component/trace/IRealtimeTraceAbility;", "traceAbility$delegate", "realtimeCallBridgeAbility", "Lcom/obric/assistant/ability/interaction/IRealtimeCallBridgeAbility;", "getRealtimeCallBridgeAbility", "()Lcom/obric/assistant/ability/interaction/IRealtimeCallBridgeAbility;", "realtimeCallBridgeAbility$delegate", "isScreenLocked", NameKeys.UnloadStrategy_No_Strategy, "Ljava/lang/Boolean;", "avatarBitmap", "Landroid/graphics/Bitmap;", "hasLoadRoundAvatarBitmap", "onAppBackground", NameKeys.UnloadStrategy_No_Strategy, "onAppForeground", "onAttach", "onVContextReady", "onViewCreated", "view", "Landroid/view/View;", "observeNotificationAction", "observerRealtimeCallAction", "onUpdateUIState", "currentMajorState", "Lcom/larus/audio/call/mgr/MajorState;", "currentState", NameKeys.UnloadStrategy_No_Strategy, "newMajorState", "newState", "refreshCallNotification", "reason", NameKeys.UnloadStrategy_No_Strategy, "getRoundAvatarBitmap", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RealtimeNotifyComponent extends RealtimeComponent implements com.larus.voicecall.impl.component.notify.a {
    public static final /* synthetic */ int w = 0;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public final Lazy q;
    public final Lazy r;
    public final Lazy s;
    public Boolean t;
    public Bitmap u;
    public boolean v;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.larus.voicecall.impl.component.notify.RealtimeNotifyComponent$onAppBackground$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.voicecall.impl.component.notify.RealtimeNotifyComponent$onAppBackground$1", f = "RealtimeNotifyComponent.kt", i = {}, l = {80}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ RealtimeNotifyComponent this$0;

        public AnonymousClass1(RealtimeNotifyComponent r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r6);
        L11:
            RealtimeNotifyComponent r7 = this.this$0;
            FragmentActivity r2 = s1a.a.c(r7).getActivity();
            Boolean r3 = null;
            if (r2 == null) goto L14;
            Object r4 = r2.getSystemService("keyguard");
        L16:
            if ((r4 instanceof KeyguardManager) == false) goto L18;
            KeyguardManager r5 = (KeyguardManager) r4;
        L19:
            if (r5 == null) goto L21;
            r3 = Boxing.boxBoolean(r5.isKeyguardLocked());
        L21:
            r7.t = r3;
            n3a.a r8 = (n3a.a) this.this$0.r.getValue();
            if (r8 == null) goto L25;
            r8.zb(Intrinsics.areEqual(this.this$0.t, Boxing.boxBoolean(true)));
        L25:
            return Unit.INSTANCE;
        L18:
            r5 = null;
            goto L19
        L14:
            r4 = null;
            goto L16
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            this.label = 1;
            if (DelayKt.delay(500, this) != r0) goto L11;
            return r0;
        }
    }

    static {
    }

    public final void A0() {
        e3a.a r0 = (e3a.a) this.n.getValue();
        p3();
        com.larus.voicecall.impl.component.window.b r1 = (com.larus.voicecall.impl.component.window.b) this.p.getValue();
        m3();
        n3a.a r2 = (n3a.a) this.r.getValue();
    }

    public final com.larus.voicecall.impl.component.core.a m3() {
        return (com.larus.voicecall.impl.component.core.a) this.q.getValue();
    }

    public final void onAppBackground() {
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new AnonymousClass1(this, null), 3, null);
    }

    public final void onAppForeground() {
        this.t = Boolean.FALSE;
    }

    public final e3a.b p3() {
        return (e3a.b) this.o.getValue();
    }

    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, com.larus.voicecall.impl.component.notify.a.class);
    }

    public RealtimeNotifyComponent() {
        this.n = LazyKt.lazy(new b(this));
        this.o = LazyKt.lazy(new c(this));
        this.p = LazyKt.lazy(new d(this));
        this.q = LazyKt.lazy(new e(this));
        this.r = LazyKt.lazy(new f(this));
        this.s = LazyKt.lazy(new g(this));
    }

    public final void onViewCreated(View r4) {
        Intrinsics.checkNotNullParameter(r4, "view");
        com.larus.voicecall.impl.notification.d.a.getClass();
        FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1 r2 = new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(com.larus.voicecall.impl.notification.d.b, new RealtimeNotifyComponent$observeNotificationAction$1(this, null));
        Intrinsics.checkNotNullParameter(this, "<this>");
        kotlinx.coroutines.flow.e.x(r2, LifecycleOwnerKt.getLifecycleScope(com.larus.ui.arch.component.internal.attach.a.b(this, this)));
        IRealtimeCallBridgeAbility r0 = (IRealtimeCallBridgeAbility) this.s.getValue();
        if (r0 == null) goto L8;
        MutableSharedFlow<Integer> r1 = r0.fS();
        if (r1 == null) goto L9;
        FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1 r3 = new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r1, new RealtimeNotifyComponent$observerRealtimeCallAction$1(this, null));
        Intrinsics.checkNotNullParameter(this, "<this>");
        kotlinx.coroutines.flow.e.x(r3, LifecycleOwnerKt.getLifecycleScope(com.larus.ui.arch.component.internal.attach.a.b(this, this)));
        return;
    L9:
        return;
    }

    public static final Object h3(RealtimeNotifyComponent r5, Continuation r6) {
        r5.getClass();
        if ((r6 instanceof RealtimeNotifyComponent$getRoundAvatarBitmap$1) == false) goto L7;
        RealtimeNotifyComponent$getRoundAvatarBitmap$1 r0 = (RealtimeNotifyComponent$getRoundAvatarBitmap$1) r6;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L15;
        if (r3 != 1) goto L14;
        ResultKt.throwOnFailure(r7);     // Catch: Throwable -> L41
    L33:
        Bitmap r8 = (Bitmap) r7;     // Catch: Throwable -> L41
        if (r8 != null) goto L36;
    L43:
        r8 = null;
    L44:
        Object r9 = Result.constructor-impl(r8);     // Catch: Throwable -> L41
    L47:
        Object r4 = r9;
        if (Result.isFailure-impl(r4) == true) goto L50;
        return r4;
    L50:
        return null;
    L36:
        if ((!r8.isRecycled()) == true) goto L39;
        r8 = null;
    L39:
        if (r8 == null) goto L43;
        int r10 = j.a;     // Catch: Throwable -> L41
        j.b(r8);     // Catch: Throwable -> L41
        r5.u = r8;     // Catch: Throwable -> L41
        goto L44
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r7);
        Bitmap r11 = r5.u;
        if (r11 == null) goto L24;
        if (r11.isRecycled() != true) goto L20;
        boolean r12 = true;
    L21:
        if (r12 == true) goto L24;
        return r5.u;
    L20:
        r12 = false;
    L24:
        if (r5.v == false) goto L27;
        FLogger.a.e("RealtimeNotifyComponent", "getRoundAvatarBitmap failed, cause load failed before");
        goto L50
    L27:
        if (NetworkUtils.isNetworkAvailable(AppHost.a.getApplication()) == true) goto L29;
        FLogger.a.e("RealtimeNotifyComponent", "getRoundAvatarBitmap failed, cause network not available");
        goto L50
    L29:
        r5.v = true;
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L41
        CoroutineDispatcher r14 = Dispatchers.getIO();     // Catch: Throwable -> L41
        RealtimeNotifyComponent$getRoundAvatarBitmap$2$1 r15 = new RealtimeNotifyComponent$getRoundAvatarBitmap$2$1(r5, null);     // Catch: Throwable -> L41
        r0.label = 1;     // Catch: Throwable -> L41
        r7 = BuildersKt.withContext(r14, r15, r0);     // Catch: Throwable -> L41
        if (r7 != r2) goto L33;
        return r2;
    L41:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r0 = new RealtimeNotifyComponent$getRoundAvatarBitmap$1(r5, r6);
        goto L8
    }

    public final void o1(MajorState r7, int r8, MajorState r9, int r10) {
        Intrinsics.checkNotNullParameter(r7, "currentMajorState");
        Intrinsics.checkNotNullParameter(r9, "newMajorState");
        FLogger.a.i("RealtimeNotifyComponent", "new state: " + r10 + " current:" + r8);
        if (r10 != 9) goto L5;
    L13:
        if (r10 != 9) goto L17;
        RealtimeCallUtil.a.getClass();
        if (RealtimeCallUtil.l != null) goto L17;
        return;
    L17:
        String r11 = "call_state_" + r10;
        if (((h88.b) p3()).k == 6) goto L28;
        Pair<Boolean, Boolean> r12 = l.i;
        Intrinsics.checkNotNullParameter(this, "<this>");
        if (l.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this).requireContext()) == false) goto L30;
        Intrinsics.checkNotNullParameter(this, "<this>");
        if (com.larus.ui.arch.component.internal.attach.a.b(this, this).getView() == null) goto L31;
        Intrinsics.checkNotNullParameter(this, "<this>");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(com.larus.ui.arch.component.internal.attach.a.b(this, this).getViewLifecycleOwner()), null, null, new RealtimeNotifyComponent$refreshCallNotification$1(this, r11, null), 3, null);
        return;
    L31:
        return;
    L30:
        return;
    L28:
        return;
    L5:
        if (r10 == 18) goto L13;
        if (r10 == 14) goto L13;
        if (r10 == 15) goto L13;
        switch(r10) {
            case 1: goto L13;
            case 2: goto L13;
            case 3: goto L13;
            case 4: goto L13;
            case 5: goto L13;
            case 6: goto L12;
            case 7: goto L13;
            default: goto L29;
        };
    L12:
        com.larus.voicecall.impl.notification.d.a.getClass();
        com.larus.voicecall.impl.notification.d.d("call_net_error");
        return;
    }
}
