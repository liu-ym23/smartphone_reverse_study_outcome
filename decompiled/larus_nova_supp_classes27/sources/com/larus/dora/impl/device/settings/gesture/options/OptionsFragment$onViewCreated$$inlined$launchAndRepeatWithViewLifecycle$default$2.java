package com.larus.dora.impl.device.settings.gesture.options;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import com.larus.bmhome.social.utils.RepeatOnLifecycleKt;
import com.larus.dora.api.annotation.CurrentIdleState;
import com.larus.dora.impl.model.GestureSettingsKey;
import java.util.List;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "com/larus/dora/impl/util/DoraExtKt$launchAndRepeatWithViewLifecycle$1"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.device.settings.gesture.options.OptionsFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$2", f = "OptionsFragment.kt", i = {}, l = {29}, m = "invokeSuspend", n = {}, s = {})
public final class OptionsFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Lifecycle.State $minActiveState;
    final /* synthetic */ List $optionList$inlined;
    final /* synthetic */ Fragment $this_launchAndRepeatWithViewLifecycle;
    int label;
    final /* synthetic */ OptionsFragment this$0;

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.gesture.options.OptionsFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "com/larus/dora/impl/util/DoraExtKt$launchAndRepeatWithViewLifecycle$1$1"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.gesture.options.OptionsFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$2$1", f = "OptionsFragment.kt", i = {}, l = {CurrentIdleState.FOCUS}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List $optionList$inlined;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ OptionsFragment this$0;

        public AnonymousClass1(Continuation r1, OptionsFragment r2, List r3) {
            this.this$0 = r2;
            this.$optionList$inlined = r3;
            super(2, r1);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            AnonymousClass1 r0 = new AnonymousClass1(r5, this.this$0, this.$optionList$inlined);
            r0.L$0 = r4;
            return r0;
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
            if (r1 != 1) goto L6;
            ResultKt.throwOnFailure(r6);
        L12:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            CoroutineScope r7 = (CoroutineScope) this.L$0;
            OptionsFragment r8 = this.this$0;
            int r2 = OptionsFragment.h;
            i1<Map<GestureSettingsKey, Byte>> r9 = ((OptionsViewModel) r8.g.getValue()).getGestureSettingsStateFlow();
            OptionsFragment.d r3 = new OptionsFragment.d(this.$optionList$inlined, this.this$0);
            this.label = 1;
            if (r9.collect(r3, this) != r0) goto L12;
            return r0;
        }
    }

    public OptionsFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$2(Fragment r1, Lifecycle.State r2, Continuation r3, OptionsFragment r4, List r5) {
        this.$this_launchAndRepeatWithViewLifecycle = r1;
        this.$minActiveState = r2;
        this.this$0 = r4;
        this.$optionList$inlined = r5;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new OptionsFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$2(this.$this_launchAndRepeatWithViewLifecycle, this.$minActiveState, r8, this.this$0, this.$optionList$inlined);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r8);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        Lifecycle r9 = this.$this_launchAndRepeatWithViewLifecycle.getViewLifecycleOwner().getLifecycle();
        Lifecycle.State r2 = this.$minActiveState;
        AnonymousClass1 r3 = new AnonymousClass1(null, this.this$0, this.$optionList$inlined);
        this.label = 1;
        if (RepeatOnLifecycleKt.a(r9, r2, r3, this) != r0) goto L12;
        return r0;
    }
}
