package com.larus.dora.obric.device_management.setting.common.sound;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import com.larus.bmhome.social.utils.RepeatOnLifecycleKt;
import com.larus.dora.api.annotation.CurrentIdleState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "com/larus/dora/impl/util/DoraExtKt$launchAndRepeatWithViewLifecycle$1"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.obric.device_management.setting.common.sound.DoraObricSoundSettingsFragment$setupEarbudsAmbientVolume$$inlined$launchAndRepeatWithViewLifecycle$default$1", f = "DoraObricSoundSettingsFragment.kt", i = {}, l = {29}, m = "invokeSuspend", n = {}, s = {})
public final class DoraObricSoundSettingsFragment$setupEarbudsAmbientVolume$$inlined$launchAndRepeatWithViewLifecycle$default$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Lifecycle.State $minActiveState;
    final /* synthetic */ Fragment $this_launchAndRepeatWithViewLifecycle;
    int label;
    final /* synthetic */ DoraObricSoundSettingsFragment this$0;

    /* JADX INFO: renamed from: com.larus.dora.obric.device_management.setting.common.sound.DoraObricSoundSettingsFragment$setupEarbudsAmbientVolume$$inlined$launchAndRepeatWithViewLifecycle$default$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "com/larus/dora/impl/util/DoraExtKt$launchAndRepeatWithViewLifecycle$1$1"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.obric.device_management.setting.common.sound.DoraObricSoundSettingsFragment$setupEarbudsAmbientVolume$$inlined$launchAndRepeatWithViewLifecycle$default$1$1", f = "DoraObricSoundSettingsFragment.kt", i = {0}, l = {CurrentIdleState.FOCUS}, m = "invokeSuspend", n = {"$this$setupEarbudsAmbientVolume_u24lambda_u2430"}, s = {"L$0"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ DoraObricSoundSettingsFragment this$0;

        public AnonymousClass1(Continuation r1, DoraObricSoundSettingsFragment r2) {
            this.this$0 = r2;
            super(2, r1);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            AnonymousClass1 r0 = new AnonymousClass1(r4, this.this$0);
            r0.L$0 = r3;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r9) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            CoroutineScope r2 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(r9);
            CoroutineScope r6 = r2;
        L12:
            boolean r10 = ((Boolean) r9).booleanValue();
            View r3 = this.this$0.g;
            if (r3 == null) goto L18;
            if (r10 == false) goto L16;
            int r4 = 0;
        L17:
            r3.setVisibility(r4);
            goto L18
        L16:
            r4 = 8;
        L18:
            this.this$0.ia0();
            if (r10 == false) goto L23;
            CoroutineScope r5 = r6;
            BuildersKt.launch$default(r5, null, null, new DoraObricSoundSettingsFragment$setupEarbudsAmbientVolume$1$1(this.this$0, null), 3, null);
            BuildersKt.launch$default(r5, null, null, new DoraObricSoundSettingsFragment$setupEarbudsAmbientVolume$1$2(this.this$0, null), 3, null);
        L23:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r9);
            CoroutineScope r11 = (CoroutineScope) this.L$0;
            DoraObricSoundSettingsFragment r7 = this.this$0;
            this.L$0 = r11;
            this.label = 1;
            Object r8 = DoraObricSoundSettingsFragment.W90(r7, this);
            if (r8 != r0) goto L11;
            return r0;
        L11:
            r6 = r11;
            r9 = r8;
            goto L12
        }
    }

    public DoraObricSoundSettingsFragment$setupEarbudsAmbientVolume$$inlined$launchAndRepeatWithViewLifecycle$default$1(Fragment r1, Lifecycle.State r2, Continuation r3, DoraObricSoundSettingsFragment r4) {
        this.$this_launchAndRepeatWithViewLifecycle = r1;
        this.$minActiveState = r2;
        this.this$0 = r4;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new DoraObricSoundSettingsFragment$setupEarbudsAmbientVolume$$inlined$launchAndRepeatWithViewLifecycle$default$1(this.$this_launchAndRepeatWithViewLifecycle, this.$minActiveState, r5, this.this$0);
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
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        Lifecycle r8 = this.$this_launchAndRepeatWithViewLifecycle.getViewLifecycleOwner().getLifecycle();
        Lifecycle.State r2 = this.$minActiveState;
        AnonymousClass1 r3 = new AnonymousClass1(null, this.this$0);
        this.label = 1;
        if (RepeatOnLifecycleKt.a(r8, r2, r3, this) != r0) goto L12;
        return r0;
    }
}
