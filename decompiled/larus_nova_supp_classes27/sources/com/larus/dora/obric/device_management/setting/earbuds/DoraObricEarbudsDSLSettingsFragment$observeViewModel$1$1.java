package com.larus.dora.obric.device_management.setting.earbuds;

import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function4;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00050\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "Lkotlin/Triple;", "", "Lcom/larus/dora/impl/dynamic/dsl/DslCard;", "Lcom/larus/dora/impl/dynamic/entity/CardContext;", "Lcom/larus/dora/impl/dynamic/event/DeviceConnectionState;", "cards", "cardContext", "connectionState"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.obric.device_management.setting.earbuds.DoraObricEarbudsDSLSettingsFragment$observeViewModel$1$1", f = "DoraObricEarbudsDSLSettingsFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DoraObricEarbudsDSLSettingsFragment$observeViewModel$1$1 extends SuspendLambda implements Function4<List<? extends c59.i>, d59.b, e59.b, Continuation<? super Triple<? extends List<? extends c59.i>, ? extends d59.b, ? extends e59.b>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    /* synthetic */ Object L$2;
    int label;

    public DoraObricEarbudsDSLSettingsFragment$observeViewModel$1$1(Continuation<? super DoraObricEarbudsDSLSettingsFragment$observeViewModel$1$1> r2) {
        super(4, r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3, Object r4) {
        return invoke((List) r1, (d59.b) r2, (e59.b) r3, (Continuation) r4);
    }

    public final Object invoke(List<c59.i> r2, d59.b r3, e59.b r4, Continuation<? super Triple<? extends List<c59.i>, d59.b, ? extends e59.b>> r5) {
        DoraObricEarbudsDSLSettingsFragment$observeViewModel$1$1 r0 = new DoraObricEarbudsDSLSettingsFragment$observeViewModel$1$1(r5);
        r0.L$0 = r2;
        r0.L$1 = r3;
        r0.L$2 = r4;
        return r0.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r4);
        return new Triple((List) this.L$0, (d59.b) this.L$1, (e59.b) this.L$2);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
