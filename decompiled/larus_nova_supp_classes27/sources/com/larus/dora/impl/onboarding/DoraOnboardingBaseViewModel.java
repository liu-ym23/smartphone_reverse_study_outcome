package com.larus.dora.impl.onboarding;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.util.DoraSKU;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000  2\u00020\u0001:\u0001 B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u000fH¦@¢\u0006\u0002\u0010\u0019J \u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00152\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001eH\u0004J\u0010\u0010\u001f\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0015H\u0004R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/larus/dora/impl/onboarding/DoraOnboardingBaseViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "doraOnboardingDevice", "Lcom/larus/dora/impl/onboarding/DoraOnboardingDevice;", "getDoraOnboardingDevice", "()Lcom/larus/dora/impl/onboarding/DoraOnboardingDevice;", "setDoraOnboardingDevice", "(Lcom/larus/dora/impl/onboarding/DoraOnboardingDevice;)V", "sku", "Lcom/larus/dora/impl/util/DoraSKU;", "getSku", "()Lcom/larus/dora/impl/util/DoraSKU;", "mac", "", "getMac", "()Ljava/lang/String;", "vuiModeDispatcher", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "currentVuiMode", "Lcom/larus/dora/impl/onboarding/OnboardingVUIMode;", "isDoraSupportOnboarding", "", "caller", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startVUIMode", "", "mode", "onSuccess", "Lkotlin/Function0;", "stopVUIMode", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class DoraOnboardingBaseViewModel extends ViewModel {
    public static final a Companion = null;
    private static final String TAG = "DoraOnboardingBaseViewM";
    private OnboardingVUIMode currentVuiMode;
    private DoraOnboardingDevice doraOnboardingDevice;
    private final ExecutorCoroutineDispatcher vuiModeDispatcher;

    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.onboarding.DoraOnboardingBaseViewModel$startVUIMode$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.onboarding.DoraOnboardingBaseViewModel$startVUIMode$2", f = "DoraOnboardingBaseViewModel.kt", i = {}, l = {47, 52}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ OnboardingVUIMode $mode;
        final /* synthetic */ Function0<Unit> $onSuccess;
        int label;
        final /* synthetic */ DoraOnboardingBaseViewModel this$0;

        public AnonymousClass2(DoraOnboardingBaseViewModel r1, OnboardingVUIMode r2, Function0<Unit> r3, Continuation<? super AnonymousClass2> r4) {
            this.this$0 = r1;
            this.$mode = r2;
            this.$onSuccess = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new AnonymousClass2(this.this$0, this.$mode, this.$onSuccess, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r7);
        L22:
            boolean r8 = ((Boolean) r7).booleanValue();
            g49.d.d(DoraOnboardingBaseViewModel.TAG, "startVUIMode: " + this.$mode + ", result=" + r8);
            if (r8 == false) goto L26;
            DoraOnboardingBaseViewModel.access$setCurrentVuiMode$p(this.this$0, this.$mode);
            this.$onSuccess.invoke();
        L26:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r7);
        L14:
            if (((Boolean) r7).booleanValue() == false) goto L26;
            if (DoraOnboardingBaseViewModel.access$getCurrentVuiMode$p(this.this$0) != this.$mode) goto L19;
            g49.d.d(DoraOnboardingBaseViewModel.TAG, "startVUIMode: " + this.$mode + ", already in this mode");
            return Unit.INSTANCE;
        L19:
            kj4.a r9 = kj4.a.g();
            int r2 = this.$mode.getValue();
            this.label = 2;
            r7 = DoraAdapterExtKt.N(r9, r2);
            if (r7 != r0) goto L22;
            return r0;
        L10:
            ResultKt.throwOnFailure(r7);
            DoraOnboardingBaseViewModel r10 = this.this$0;
            String r3 = this.$mode.name();
            this.label = 1;
            r7 = r10.isDoraSupportOnboarding(r3, this);
            if (r7 != r0) goto L14;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.onboarding.DoraOnboardingBaseViewModel$stopVUIMode$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.onboarding.DoraOnboardingBaseViewModel$stopVUIMode$1", f = "DoraOnboardingBaseViewModel.kt", i = {}, l = {64, 65}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ OnboardingVUIMode $mode;
        int label;
        final /* synthetic */ DoraOnboardingBaseViewModel this$0;

        public AnonymousClass1(DoraOnboardingBaseViewModel r1, OnboardingVUIMode r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$mode = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.this$0, this.$mode, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r5);
        L18:
            g49.d.d(DoraOnboardingBaseViewModel.TAG, "stopVUIMode: " + this.$mode + ", result=" + ((Boolean) r5).booleanValue());
        L20:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r5);
        L14:
            if (((Boolean) r5).booleanValue() == false) goto L20;
            kj4.a r6 = kj4.a.g();
            int r2 = this.$mode.getValue();
            this.label = 2;
            r5 = DoraAdapterExtKt.O(r6, r2);
            if (r5 != r0) goto L18;
            return r0;
        L10:
            ResultKt.throwOnFailure(r5);
            DoraOnboardingBaseViewModel r7 = this.this$0;
            String r3 = this.$mode.name();
            this.label = 1;
            r5 = r7.isDoraSupportOnboarding(r3, this);
            if (r5 != r0) goto L14;
            return r0;
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ Thread Mo(Runnable r0) {
        return vuiModeDispatcher$lambda$0(r0);
    }

    public static /* synthetic */ Unit yo() {
        return startVUIMode$lambda$1();
    }

    public abstract Object isDoraSupportOnboarding(String r1, Continuation<? super Boolean> r2);

    public final String getMac() {
        DoraOnboardingDevice r0 = this.doraOnboardingDevice;
        if (r0 == null) goto L5;
        String r1 = r0.b;
    L6:
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1;
    L5:
        r1 = null;
        goto L6
    }

    public final DoraSKU getSku() {
        DoraSKU.a r0 = DoraSKU.Companion;
        DoraOnboardingDevice r1 = this.doraOnboardingDevice;
        Integer r2 = null;
        if (r1 == null) goto L5;
        Integer r3 = Integer.valueOf(r1.e);
    L6:
        DoraSKU r4 = DoraSKU.a.b(r0, r3);
        StringBuilder r5 = new StringBuilder("sku=");
        DoraOnboardingDevice r6 = this.doraOnboardingDevice;
        if (r6 == null) goto L9;
        r2 = Integer.valueOf(r6.e);
    L9:
        r5.append(r2);
        r5.append(", doraSKU=");
        r5.append(r4);
        g49.d.d(TAG, r5.toString());
        return r4;
    L5:
        r3 = null;
        goto L6
    }

    public DoraOnboardingBaseViewModel() {
        this.vuiModeDispatcher = ExecutorsKt.from(PThreadExecutorsUtils.newSingleThreadExecutor(new f()));
        g49.d.d(TAG, "init");
    }

    private static final Unit startVUIMode$lambda$1() {
        return Unit.INSTANCE;
    }

    public final DoraOnboardingDevice getDoraOnboardingDevice() {
        return this.doraOnboardingDevice;
    }

    public static final /* synthetic */ OnboardingVUIMode access$getCurrentVuiMode$p(DoraOnboardingBaseViewModel r0) {
        return r0.currentVuiMode;
    }

    private static final Thread vuiModeDispatcher$lambda$0(Runnable r2) {
        return new PthreadThreadV2(r2, "dora_onboarding#VUIMode");
    }

    public final void setDoraOnboardingDevice(DoraOnboardingDevice r1) {
        this.doraOnboardingDevice = r1;
    }

    public final void stopVUIMode(OnboardingVUIMode r8) {
        Intrinsics.checkNotNullParameter(r8, "mode");
        BuildersKt.launch$default(GlobalScope.INSTANCE, this.vuiModeDispatcher, null, new AnonymousClass1(this, r8, null), 2, null);
    }

    public static final /* synthetic */ void access$setCurrentVuiMode$p(DoraOnboardingBaseViewModel r0, OnboardingVUIMode r1) {
        r0.currentVuiMode = r1;
    }

    public final void startVUIMode(OnboardingVUIMode r8, Function0<Unit> r9) {
        Intrinsics.checkNotNullParameter(r8, "mode");
        Intrinsics.checkNotNullParameter(r9, "onSuccess");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), this.vuiModeDispatcher, null, new AnonymousClass2(this, r8, r9, null), 2, null);
    }

    public static /* synthetic */ Object isDoraSupportOnboarding$default(DoraOnboardingBaseViewModel r0, String r1, Continuation r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 1) == 0) goto L7;
        r1 = "";
    L7:
        return r0.isDoraSupportOnboarding(r1, r2);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: isDoraSupportOnboarding");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void startVUIMode$default(DoraOnboardingBaseViewModel r0, OnboardingVUIMode r1, Function0 r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 2) == 0) goto L6;
        r2 = new g();
    L6:
        r0.startVUIMode(r1, r2);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startVUIMode");
    }
}
