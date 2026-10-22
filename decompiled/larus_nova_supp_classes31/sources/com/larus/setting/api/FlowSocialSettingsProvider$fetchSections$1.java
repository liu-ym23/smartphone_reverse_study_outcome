package com.larus.setting.api;

import androidx.fragment.app.FragmentActivity;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.setting.api.FlowSocialSettingsProvider$fetchSections$1", f = "FlowSocialSettingsProvider.kt", i = {}, l = {23}, m = "invokeSuspend", n = {}, s = {})
public final class FlowSocialSettingsProvider$fetchSections$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FragmentActivity $activity;
    final /* synthetic */ Function1<List<zs9.c>, Unit> $completion;
    Object L$0;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public FlowSocialSettingsProvider$fetchSections$1(Function1<? super List<zs9.c>, Unit> r1, FragmentActivity r2, Continuation<? super FlowSocialSettingsProvider$fetchSections$1> r3) {
        this.$completion = r1;
        this.$activity = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new FlowSocialSettingsProvider$fetchSections$1(this.$completion, this.$activity, r4);
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
        if (r1 != 1) goto L7;
        Function1<List<zs9.c>, Unit> r2 = (Function1) this.L$0;
        ResultKt.throwOnFailure(r5);
    L12:
        List r6 = (List) r5;
        if (r6 != null) goto L15;
        r6 = CollectionsKt.emptyList();
    L15:
        r2.invoke(r6);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        Function1<List<zs9.c>, Unit> r7 = this.$completion;
        SettingService r3 = SettingService.a;
        FragmentActivity r4 = this.$activity;
        this.L$0 = r7;
        this.label = 1;
        Object r8 = r3.d(r4, this);
        if (r8 != r0) goto L11;
        return r0;
    L11:
        r2 = r7;
        r5 = r8;
        goto L12
    }
}
