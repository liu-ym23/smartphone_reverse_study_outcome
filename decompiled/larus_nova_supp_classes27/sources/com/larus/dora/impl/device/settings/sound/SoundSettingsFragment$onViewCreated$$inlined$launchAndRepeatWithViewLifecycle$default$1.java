package com.larus.dora.impl.device.settings.sound;

import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import com.larus.bmhome.social.utils.RepeatOnLifecycleKt;
import com.larus.bmhome.view.item.ItemGroup;
import com.larus.bmhome.view.item.ItemGroupTitle;
import com.larus.bmhome.view.item.ItemTextToggle;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.databinding.LarusDoraPageSoundSettingsBinding;
import com.larus.utils.e1;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "com/larus/dora/impl/util/DoraExtKt$launchAndRepeatWithViewLifecycle$1"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.device.settings.sound.SoundSettingsFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$1", f = "SoundSettingsFragment.kt", i = {}, l = {29}, m = "invokeSuspend", n = {}, s = {})
public final class SoundSettingsFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isGDevice$inlined;
    final /* synthetic */ Lifecycle.State $minActiveState;
    final /* synthetic */ Fragment $this_launchAndRepeatWithViewLifecycle;
    int label;
    final /* synthetic */ SoundSettingsFragment this$0;

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.sound.SoundSettingsFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "com/larus/dora/impl/util/DoraExtKt$launchAndRepeatWithViewLifecycle$1$1"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.sound.SoundSettingsFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$1$1", f = "SoundSettingsFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
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

        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L76;
            ResultKt.throwOnFailure(r3);
            CoroutineScope r4 = (CoroutineScope) this.L$0;
            if (DoraAdapterExtKt.y(kj4.a.g()) == false) goto L48;
            LarusDoraPageSoundSettingsBinding r5 = this.this$0.f;
            if (r5 == null) goto L11;
            ItemGroupTitle r6 = r5.f;
            if (r6 == null) goto L11;
            e1.x(r6);
        L11:
            LarusDoraPageSoundSettingsBinding r7 = this.this$0.f;
            if (r7 == null) goto L16;
            ItemTextToggle r8 = r7.h;
            if (r8 == null) goto L16;
            e1.x(r8);
        L16:
            LarusDoraPageSoundSettingsBinding r9 = this.this$0.f;
            if (r9 == null) goto L21;
            ItemGroup r10 = r9.g;
            if (r10 == null) goto L21;
            e1.x(r10);
        L21:
            LarusDoraPageSoundSettingsBinding r11 = this.this$0.f;
            if (r11 == null) goto L26;
            AppCompatTextView r12 = r11.b;
            if (r12 == null) goto L26;
            e1.x(r12);
        L26:
            LarusDoraPageSoundSettingsBinding r13 = this.this$0.f;
            if (r13 == null) goto L32;
            View r14 = r13.d;
            if (r14 == null) goto L32;
            e1.o(r14);
        L32:
            if (this.$isGDevice$inlined == false) goto L38;
            SoundSettingsFragment r15 = this.this$0;
            LarusDoraPageSoundSettingsBinding r0 = r15.f;
            if (r0 == null) goto L43;
            AppCompatTextView r1 = r0.b;
            if (r1 == null) goto L43;
            r1.setText(r15.getString(2131904093));
        L43:
            LarusDoraPageSoundSettingsBinding r16 = this.this$0.f;
            if (r16 == null) goto L74;
            LinearLayout r17 = r16.e;
            if (r17 == null) goto L74;
            e1.o(r17);
        L74:
            return Unit.INSTANCE;
        L38:
            SoundSettingsFragment r18 = this.this$0;
            LarusDoraPageSoundSettingsBinding r2 = r18.f;
            if (r2 == null) goto L43;
            AppCompatTextView r20 = r2.b;
            if (r20 == null) goto L43;
            r20.setText(r18.getString(2131904013));
            goto L43
        L48:
            LarusDoraPageSoundSettingsBinding r21 = this.this$0.f;
            if (r21 == null) goto L53;
            ItemGroupTitle r22 = r21.f;
            if (r22 == null) goto L53;
            e1.o(r22);
        L53:
            LarusDoraPageSoundSettingsBinding r23 = this.this$0.f;
            if (r23 == null) goto L58;
            ItemTextToggle r24 = r23.h;
            if (r24 == null) goto L58;
            e1.o(r24);
        L58:
            LarusDoraPageSoundSettingsBinding r25 = this.this$0.f;
            if (r25 == null) goto L63;
            ItemGroup r26 = r25.g;
            if (r26 == null) goto L63;
            e1.o(r26);
        L63:
            LarusDoraPageSoundSettingsBinding r27 = this.this$0.f;
            if (r27 == null) goto L68;
            AppCompatTextView r28 = r27.b;
            if (r28 == null) goto L68;
            e1.o(r28);
        L68:
            LarusDoraPageSoundSettingsBinding r30 = this.this$0.f;
            if (r30 == null) goto L74;
            View r31 = r30.d;
            if (r31 == null) goto L74;
            e1.o(r31);
            goto L74
        L76:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public SoundSettingsFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$1(Fragment r1, Lifecycle.State r2, Continuation r3, SoundSettingsFragment r4, boolean r5) {
        this.$this_launchAndRepeatWithViewLifecycle = r1;
        this.$minActiveState = r2;
        this.this$0 = r4;
        this.$isGDevice$inlined = r5;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new SoundSettingsFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$1(this.$this_launchAndRepeatWithViewLifecycle, this.$minActiveState, r8, this.this$0, this.$isGDevice$inlined);
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
