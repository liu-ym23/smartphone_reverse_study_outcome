package com.obric.assistant.settings.provider;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.settings.provider.MemoryDataMigrationSettingProvider$getSettingItems$4", f = "MemoryDataMigrationSettingProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MemoryDataMigrationSettingProvider$getSettingItems$4 extends SuspendLambda implements Function1<Continuation<? super Boolean>, Object> {
    int label;

    public MemoryDataMigrationSettingProvider$getSettingItems$4(Continuation<? super MemoryDataMigrationSettingProvider$getSettingItems$4> r2) {
        super(1, r2);
    }

    public final Continuation<Unit> create(Continuation<?> r2) {
        return new MemoryDataMigrationSettingProvider$getSettingItems$4(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super Boolean> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r2);
        return Boxing.boxBoolean(true);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
