package com.larus.dora.impl.device.settings.sound;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import com.larus.bmhome.social.utils.RepeatOnLifecycleKt;
import com.larus.bmhome.view.item.ItemGroup;
import com.larus.bmhome.view.item.ItemGroupTitle;
import com.larus.dora.api.annotation.CurrentIdleState;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.databinding.LarusDoraPageSoundSettingsBinding;
import com.larus.utils.e1;
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
@DebugMetadata(c = "com.larus.dora.impl.device.settings.sound.SoundSettingsFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$4", f = "SoundSettingsFragment.kt", i = {}, l = {29}, m = "invokeSuspend", n = {}, s = {})
public final class SoundSettingsFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isGDevice$inlined;
    final /* synthetic */ Lifecycle.State $minActiveState;
    final /* synthetic */ Fragment $this_launchAndRepeatWithViewLifecycle;
    int label;
    final /* synthetic */ SoundSettingsFragment this$0;

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.sound.SoundSettingsFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$4$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "com/larus/dora/impl/util/DoraExtKt$launchAndRepeatWithViewLifecycle$1$1"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.sound.SoundSettingsFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$4$1", f = "SoundSettingsFragment.kt", i = {}, l = {CurrentIdleState.FOCUS, 43}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $isGDevice$inlined;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ SoundSettingsFragment this$0;

        public AnonymousClass1(Continuation r1, SoundSettingsFragment r2, boolean r3) {
            this.this$0 = r2;
            this.$isGDevice$inlined = r3;
            super(2, r1);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            AnonymousClass1 r0 = new AnonymousClass1(r5, this.this$0, this.$isGDevice$inlined);
            r0.L$0 = r4;
            return r0;
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
            if (r1 != 2) goto L7;
            ResultKt.throwOnFailure(r5);
        L43:
            throw new KotlinNothingValueException();
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r5);
        L14:
            if (((Boolean) r5).booleanValue() == false) goto L44;
            LarusDoraPageSoundSettingsBinding r6 = this.this$0.f;
            if (r6 == null) goto L20;
            ItemGroupTitle r7 = r6.p;
            if (r7 == null) goto L20;
            e1.x(r7);
        L20:
            LarusDoraPageSoundSettingsBinding r8 = this.this$0.f;
            if (r8 == null) goto L25;
            AppCompatTextView r9 = r8.k;
            if (r9 == null) goto L25;
            e1.x(r9);
        L25:
            SoundSettingsFragment r10 = this.this$0;
            LarusDoraPageSoundSettingsBinding r2 = r10.f;
            if (r2 == null) goto L34;
            AppCompatTextView r3 = r2.k;
            if (r3 == null) goto L34;
            if (this.$isGDevice$inlined == false) goto L32;
            int r4 = 2131902696;
        L33:
            r3.setText(r10.getString(r4));
            goto L34
        L32:
            r4 = 2131904019;
        L34:
            LarusDoraPageSoundSettingsBinding r11 = this.this$0.f;
            if (r11 == null) goto L39;
            ItemGroup r12 = r11.j;
            if (r12 == null) goto L39;
            e1.x(r12);
        L39:
            i1<m> r13 = this.this$0.Y90().getSpeakerVolStateFlow();
            SoundSettingsFragment.d r14 = new SoundSettingsFragment.d(this.this$0);
            this.label = 2;
            if (r13.collect(r14, this) != r0) goto L43;
            return r0;
        L44:
            LarusDoraPageSoundSettingsBinding r15 = this.this$0.f;
            if (r15 == null) goto L49;
            ItemGroupTitle r16 = r15.p;
            if (r16 == null) goto L49;
            e1.o(r16);
        L49:
            LarusDoraPageSoundSettingsBinding r17 = this.this$0.f;
            if (r17 == null) goto L54;
            ItemGroup r18 = r17.j;
            if (r18 == null) goto L54;
            e1.o(r18);
        L54:
            LarusDoraPageSoundSettingsBinding r20 = this.this$0.f;
            if (r20 == null) goto L60;
            AppCompatTextView r21 = r20.k;
            if (r21 == null) goto L60;
            e1.o(r21);
        L60:
            return Unit.INSTANCE;
        L10:
            ResultKt.throwOnFailure(r5);
            CoroutineScope r22 = (CoroutineScope) this.L$0;
            kj4.a r23 = kj4.a.g();
            this.label = 1;
            r5 = DoraAdapterExtKt.v(r23);
            if (r5 != r0) goto L14;
            return r0;
        }
    }

    public SoundSettingsFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$4(Fragment r1, Lifecycle.State r2, Continuation r3, SoundSettingsFragment r4, boolean r5) {
        this.$this_launchAndRepeatWithViewLifecycle = r1;
        this.$minActiveState = r2;
        this.this$0 = r4;
        this.$isGDevice$inlined = r5;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new SoundSettingsFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$4(this.$this_launchAndRepeatWithViewLifecycle, this.$minActiveState, r8, this.this$0, this.$isGDevice$inlined);
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
        AnonymousClass1 r3 = new AnonymousClass1(null, this.this$0, this.$isGDevice$inlined);
        this.label = 1;
        if (RepeatOnLifecycleKt.a(r9, r2, r3, this) != r0) goto L12;
        return r0;
    }
}
