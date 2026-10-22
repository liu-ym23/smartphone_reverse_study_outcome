package com.larus.dora.impl.device.settings.gesture.options;

import androidx.lifecycle.ViewModel;
import com.larus.dora.impl.device.settings.gesture.GestureSettingsRepository;
import com.larus.dora.impl.model.GestureSettingsKey;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.flow.d1;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\bR#\u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/larus/dora/impl/device/settings/gesture/options/OptionsViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "gestureSettingsStateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "", "Lcom/larus/dora/impl/model/GestureSettingsKey;", "", "getGestureSettingsStateFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "gestureSettingsUpdateFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "", "getGestureSettingsUpdateFlow", "()Lkotlinx/coroutines/flow/SharedFlow;", "updateOption", "", "key", "value", "previousValue", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OptionsViewModel extends ViewModel {
    private final i1<Map<GestureSettingsKey, Byte>> gestureSettingsStateFlow;
    private final d1<Boolean> gestureSettingsUpdateFlow;

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.gesture.options.OptionsViewModel$updateOption$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.gesture.options.OptionsViewModel$updateOption$1", f = "OptionsViewModel.kt", i = {}, l = {19}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ GestureSettingsKey $key;
        final /* synthetic */ byte $previousValue;
        final /* synthetic */ byte $value;
        int label;

        public AnonymousClass1(GestureSettingsKey r1, byte r2, byte r3, Continuation<? super AnonymousClass1> r4) {
            this.$key = r1;
            this.$value = r2;
            this.$previousValue = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new AnonymousClass1(this.$key, this.$value, this.$previousValue, r5);
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
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            GestureSettingsRepository r7 = GestureSettingsRepository.a;
            GestureSettingsKey r2 = this.$key;
            byte r3 = this.$value;
            byte r4 = this.$previousValue;
            this.label = 1;
            if (r7.update(r2, r3, r4, this) != r0) goto L12;
            return r0;
        }
    }

    public OptionsViewModel() {
        GestureSettingsRepository.a.getClass();
        this.gestureSettingsStateFlow = GestureSettingsRepository.h;
        this.gestureSettingsUpdateFlow = GestureSettingsRepository.j;
    }

    public final i1<Map<GestureSettingsKey, Byte>> getGestureSettingsStateFlow() {
        return this.gestureSettingsStateFlow;
    }

    public final d1<Boolean> getGestureSettingsUpdateFlow() {
        return this.gestureSettingsUpdateFlow;
    }

    public final void updateOption(GestureSettingsKey r8, byte r9, byte r10) {
        Intrinsics.checkNotNullParameter(r8, "key");
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new AnonymousClass1(r8, r9, r10, null), 2, null);
    }
}
