package com.larus.dora.obric.device_management.setting.common.sound;

import com.larus.dora.obric.utils.DoraObricToastUtils;
import java.lang.ref.WeakReference;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.IntRange;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.d1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.obric.device_management.setting.common.sound.DoraObricSoundSettingsFragment$setupEarbudsAmbientVolume$1$2", f = "DoraObricSoundSettingsFragment.kt", i = {}, l = {477}, m = "invokeSuspend", n = {}, s = {})
final class DoraObricSoundSettingsFragment$setupEarbudsAmbientVolume$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DoraObricSoundSettingsFragment this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ DoraObricSoundSettingsFragment a;

        public a(DoraObricSoundSettingsFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r1, Continuation r2) {
            if (((Boolean) r1).booleanValue() == true) goto L8;
            WeakReference<com.obric.oui.toast.f> r3 = DoraObricToastUtils.a;
            DoraObricToastUtils.a(this.a.requireContext(), 2131904037);
            DoraObricSoundSettingsFragment r4 = this.a;
            IntRange r5 = DoraObricSoundSettingsFragment.s;
            com.larus.dora.impl.device.settings.sound.l r6 = (com.larus.dora.impl.device.settings.sound.l) r4.ea0().getSoundSettingsStateFlow().getValue();
            if ((r6 instanceof com.larus.dora.impl.device.settings.sound.l.c) == false) goto L8;
            DoraObricSoundSettingsFragment.Y90(this.a, ((com.larus.dora.impl.device.settings.sound.l.c) r6).a);
        L8:
            return Unit.INSTANCE;
        }
    }

    public DoraObricSoundSettingsFragment$setupEarbudsAmbientVolume$1$2(DoraObricSoundSettingsFragment r1, Continuation<? super DoraObricSoundSettingsFragment$setupEarbudsAmbientVolume$1$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DoraObricSoundSettingsFragment$setupEarbudsAmbientVolume$1$2(this.this$0, r3);
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
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L6;
        ResultKt.throwOnFailure(r5);
    L12:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        DoraObricSoundSettingsFragment r6 = this.this$0;
        IntRange r2 = DoraObricSoundSettingsFragment.s;
        d1<Boolean> r7 = r6.ea0().getUpdateAmbientVolumeSharedFlow();
        a r3 = new a(this.this$0);
        this.label = 1;
        if (r7.collect(r3, this) != r0) goto L12;
        return r0;
    }
}
