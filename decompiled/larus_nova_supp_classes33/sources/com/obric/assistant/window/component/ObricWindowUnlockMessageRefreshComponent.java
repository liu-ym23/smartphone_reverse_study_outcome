package com.obric.assistant.window.component;

import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.api.IKeyguardState;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import com.obric.cae.libs.useraware.ParamPacker;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0016\u001a\u00020\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0014H\u0016J\u0010\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u0014H\u0002R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\n\u001a\u0004\u0018\u00010\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\rR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/obric/assistant/window/component/ObricWindowUnlockMessageRefreshComponent;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "<init>", "()V", "chatListAbility", "Lcom/larus/bmhome/chat/component/list/IChatListComponentAbility;", "getChatListAbility", "()Lcom/larus/bmhome/chat/component/list/IChatListComponentAbility;", "chatListAbility$delegate", "Lkotlin/Lazy;", "keyguardState", "Lcom/obric/assistant/interaction/api/IKeyguardState;", "getKeyguardState", "()Lcom/obric/assistant/interaction/api/IKeyguardState;", "keyguardState$delegate", "deviceLockPollingJob", "Lkotlinx/coroutines/Job;", "waitingForDeviceUnlock", "", "onCreate", "", "onStart", "onStop", "onDestroy", "stopDeviceLockPolling", WindowEvent.Params.REASON, "", "refreshMessagesAfterUnlock", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricWindowUnlockMessageRefreshComponent extends ComponentFeature {
    public static final /* synthetic */ int l = 0;
    public final Lazy h;
    public final Lazy i;
    public Job j;
    public boolean k;

    public static final class a {
    }

    public static final class b implements Function0<u7> {
        public final /* synthetic */ AttachReceiver a;

        public b(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(u7.class));
        }
    }

    /* JADX INFO: renamed from: com.obric.assistant.window.component.ObricWindowUnlockMessageRefreshComponent$onStart$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.window.component.ObricWindowUnlockMessageRefreshComponent$onStart$1", f = "ObricWindowUnlockMessageRefreshComponent.kt", i = {0}, l = {ParamPacker.TOTAL_LENGTH}, m = "invokeSuspend", n = {"index"}, s = {"I$2"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ IKeyguardState $state;
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ ObricWindowUnlockMessageRefreshComponent this$0;

        public AnonymousClass1(IKeyguardState r1, ObricWindowUnlockMessageRefreshComponent r2, Continuation<? super AnonymousClass1> r3) {
            this.$state = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.$state, this.this$0, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0052 -> B:14:0x0057). Please report as a decompilation issue!!! */
        public final Object invokeSuspend(Object r14) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            int r2 = this.I$2;
            int r5 = this.I$1;
            int r6 = this.I$0;
            ObricWindowUnlockMessageRefreshComponent r7 = (ObricWindowUnlockMessageRefreshComponent) this.L$1;
            IKeyguardState r8 = (IKeyguardState) this.L$0;
            ResultKt.throwOnFailure(r14);
            String r15 = "ObricWindowUnlockMessageRefreshComponent";
            IKeyguardState r9 = r8;
            ObricWindowUnlockMessageRefreshComponent r10 = r7;
            int r11 = r6;
            AnonymousClass1 r12 = this;
        L15:
            if (r9.isDeviceLocked() == true) goto L21;
            r10.k = false;
            FLogger r3 = FLogger.a;
            r3.i(r15, "device unlocked, stop polling");
            r3.i("ObricWindowUnlockMessageRefreshComponent", "refreshMessagesAfterUnlock");
            u7 r16 = (u7) r10.h.getValue();
            if (r16 == null) goto L20;
            r16.C90();
        L20:
            return Unit.INSTANCE;
        L21:
            FLogger.a.i(r15, "device is still locked, pollingCount=" + (r2 + 1) + "/2");
            r2 = r5 + 1;
            AnonymousClass1 r13 = r12;
            int r17 = r11;
            ObricWindowUnlockMessageRefreshComponent r18 = r10;
            IKeyguardState r19 = r9;
        L9:
            if (r2 >= r17) goto L22;
            r13.L$0 = r19;
            r13.L$1 = r18;
            r13.I$0 = r17;
            r13.I$1 = r2;
            r13.I$2 = r2;
            r13.label = 1;
            if (DelayKt.delay(500, r13) != r0) goto L13;
            return r0;
        L13:
            r9 = r19;
            r10 = r18;
            r11 = r17;
            r12 = r13;
            r5 = r2;
            goto L15
        L22:
            FLogger.a.i(r15, "device is still locked after max polling count, stop polling");
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r14);
            r13 = this;
            r19 = this.$state;
            r18 = this.this$0;
            r15 = "ObricWindowUnlockMessageRefreshComponent";
            r2 = 0;
            r17 = 2;
            goto L9
        }
    }

    static {
    }

    public final void onCreate() {
        FLogger.a.i("ObricWindowUnlockMessageRefreshComponent", "onCreate");
    }

    public final void onDestroy() {
        FLogger.a.i("ObricWindowUnlockMessageRefreshComponent", "onDestroy");
        F2("onDestroy");
        this.k = false;
    }

    public final void onStart() {
        Job r0 = this.j;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L9:
        if (r1 == false) goto L12;
        FLogger.a.i("ObricWindowUnlockMessageRefreshComponent", "onStart ignored, device lock polling is active");
        return;
    L12:
        IKeyguardState r2 = (IKeyguardState) this.i.getValue();
        if (r2 != null) goto L17;
        FLogger.a.w("ObricWindowUnlockMessageRefreshComponent", "onStart ignored, IKeyguardState service is null");
        return;
    L17:
        if (r2.isDeviceLocked() == false) goto L19;
        this.k = true;
        FLogger.a.i("ObricWindowUnlockMessageRefreshComponent", "startDeviceLockPolling");
        this.j = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AnonymousClass1(r2, this, null), 3, null);
        return;
    L19:
        if (this.k == false) goto L23;
        this.k = false;
        FLogger r3 = FLogger.a;
        r3.i("ObricWindowUnlockMessageRefreshComponent", "device unlocked while stopped, refresh after start");
        r3.i("ObricWindowUnlockMessageRefreshComponent", "refreshMessagesAfterUnlock");
        u7 r4 = (u7) this.h.getValue();
        if (r4 == null) goto L27;
        r4.C90();
        return;
    L27:
        return;
    L23:
        FLogger.a.i("ObricWindowUnlockMessageRefreshComponent", "onStart ignored, device is unlocked");
        return;
    L5:
        if (r0.isActive() != true) goto L7;
        r1 = true;
        goto L9
    }

    public final void onStop() {
        FLogger.a.i("ObricWindowUnlockMessageRefreshComponent", "onStop");
        F2("onStop");
    }

    public ObricWindowUnlockMessageRefreshComponent() {
        this.h = LazyKt.lazy(new b(this));
        this.i = LazyKt.lazy(new p());
    }

    public final void F2(String r4) {
        Job r0 = this.j;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L10;
        FLogger.a.i("ObricWindowUnlockMessageRefreshComponent", "stopDeviceLockPolling, reason=".concat(r4));
    L10:
        Job r5 = this.j;
        if (r5 == null) goto L13;
        Job.DefaultImpls.cancel$default(r5, null, 1, null);
    L13:
        this.j = null;
        return;
    L5:
        if (r0.isActive() != true) goto L7;
        r1 = true;
        goto L8
    }
}
