package com.larus.dora.obric.device_management.device_home;

import com.larus.dora.api.GlassesMode;
import com.larus.dora.api.IDoraService;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeFragment$executeGlassesModeSheetCommand$1$ret$1", f = "DoraObricDeviceHomeFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DoraObricDeviceHomeFragment$executeGlassesModeSheetCommand$1$ret$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {
    final /* synthetic */ x2 $command;
    final /* synthetic */ IDoraService.d $deviceService;
    int label;
    final /* synthetic */ DoraObricDeviceHomeFragment this$0;

    public DoraObricDeviceHomeFragment$executeGlassesModeSheetCommand$1$ret$1(x2 r1, IDoraService.d r2, DoraObricDeviceHomeFragment r3, Continuation<? super DoraObricDeviceHomeFragment$executeGlassesModeSheetCommand$1$ret$1> r4) {
        this.$command = r1;
        this.$deviceService = r2;
        this.this$0 = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new DoraObricDeviceHomeFragment$executeGlassesModeSheetCommand$1$ret$1(this.$command, this.$deviceService, this.this$0, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Integer> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L31;
        ResultKt.throwOnFailure(r3);
        x2 r4 = this.$command;
        if (Intrinsics.areEqual(r4, x2.b.a) == false) goto L11;
        if (this.$deviceService.shutdown() == false) goto L9;
        int r5 = 0;
    L27:
        return Boxing.boxInt(r5);
    L9:
        r5 = -1;
        goto L27
    L11:
        if ((r4 instanceof x2.a) == false) goto L29;
        DoraObricDeviceHomeFragment r6 = this.this$0;
        DoraObricGlassesMode r0 = ((x2.a) this.$command).a;
        int r1 = DoraObricDeviceHomeFragment.R;
        r6.getClass();
        int r7 = DoraObricDeviceHomeFragment.g.a[r0.ordinal()];
        if (r7 != 1) goto L15;
        GlassesMode r8 = GlassesMode.ASSISTANT;
    L23:
        if (r8 != null) goto L25;
        r5 = -5;
        goto L27
    L25:
        r5 = this.$deviceService.b(r8.getValue());
        goto L27
    L15:
        if (r7 != 2) goto L17;
        r8 = GlassesMode.HEADPHONE;
        goto L23
    L17:
        if (r7 != 3) goto L20;
        r8 = null;
        goto L23
    L20:
        throw new NoWhenBranchMatchedException();
    L29:
        throw new NoWhenBranchMatchedException();
    L31:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
