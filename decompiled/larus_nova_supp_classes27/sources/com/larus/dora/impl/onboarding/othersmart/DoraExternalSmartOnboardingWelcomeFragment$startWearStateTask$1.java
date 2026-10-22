package com.larus.dora.impl.onboarding.othersmart;

import android.bluetooth.BluetoothAdapter;
import com.bytedance.dora.device.DoraDevice;
import com.larus.dora.impl.core.DoraAdapterExtKt;
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
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.onboarding.othersmart.DoraExternalSmartOnboardingWelcomeFragment$startWearStateTask$1", f = "DoraExternalSmartOnboardingWelcomeFragment.kt", i = {}, l = {154, 156}, m = "invokeSuspend", n = {}, s = {})
final class DoraExternalSmartOnboardingWelcomeFragment$startWearStateTask$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BluetoothAdapter $defaultAdapter;
    int label;
    final /* synthetic */ DoraExternalSmartOnboardingWelcomeFragment this$0;

    public DoraExternalSmartOnboardingWelcomeFragment$startWearStateTask$1(DoraExternalSmartOnboardingWelcomeFragment r1, BluetoothAdapter r2, Continuation<? super DoraExternalSmartOnboardingWelcomeFragment$startWearStateTask$1> r3) {
        this.this$0 = r1;
        this.$defaultAdapter = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DoraExternalSmartOnboardingWelcomeFragment$startWearStateTask$1(this.this$0, this.$defaultAdapter, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x00aa -> B:11:0x0021). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 == 2) goto L10;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r10);
        DoraExternalSmartOnboardingWelcomeFragment$startWearStateTask$1 r11 = this;
    L30:
        r11.label = 2;
        if (DelayKt.delay(1000, r11) == r0) goto L32;
    L11:
        DoraExternalSmartOnboardingWelcomeFragment r2 = r11.this$0;
        if (r2.p == false) goto L34;
        if (r2.ca0().isBackgroundMusicPlaying() == true) goto L34;
        g49.d.d("ExternalSmartOnboardingWelcome", "Task execute : playBackgroundMusicIfNeeded");
        DoraDevice r3 = DoraAdapterExtKt.h(kj4.a.g());
        if (r3 == null) goto L30;
        if (pk4.a.f(r11.$defaultAdapter.getRemoteDevice(r3.mac)) == false) goto L30;
        DoraExternalSmartOnboardingWelcomeFragment r4 = r11.this$0;
        r11.label = 1;
        r4.getClass();
        int[] r5 = kj4.a.g().C();
        g49.d.d("ExternalSmartOnboardingWelcome", "budsWearState[0]=" + r5[0] + " ,budsWearState[1]= " + r5[1]);
        if (r5[0] == 1) goto L22;
    L27:
        Object r6 = Unit.INSTANCE;
    L28:
        if (r6 != r0) goto L30;
        return r0;
    L22:
        if (r5[1] != 1) goto L27;
        r6 = BuildersKt.withContext(Dispatchers.getMain(), new DoraExternalSmartOnboardingWelcomeFragment$playBackgroundMusicIfNeeded$2(r4, null), r11);
        if (r6 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L28;
        r6 = Unit.INSTANCE;
    L34:
        return Unit.INSTANCE;
    L32:
        return r0;
    L10:
        ResultKt.throwOnFailure(r10);
        r11 = this;
        goto L11
    }
}
