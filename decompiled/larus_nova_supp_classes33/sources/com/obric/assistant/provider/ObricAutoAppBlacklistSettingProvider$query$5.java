package com.obric.assistant.provider;

import android.database.Cursor;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", "Landroid/database/Cursor;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.provider.ObricAutoAppBlacklistSettingProvider$query$5", f = "ObricAutoAppBlacklistSettingProvider.kt", i = {}, l = {124}, m = "invokeSuspend", n = {}, s = {})
public final class ObricAutoAppBlacklistSettingProvider$query$5 extends SuspendLambda implements Function1<Continuation<? super Cursor>, Object> {
    int label;
    final /* synthetic */ ObricAutoAppBlacklistSettingProvider this$0;

    public ObricAutoAppBlacklistSettingProvider$query$5(ObricAutoAppBlacklistSettingProvider r1, Continuation<? super ObricAutoAppBlacklistSettingProvider$query$5> r2) {
        this.this$0 = r1;
        super(1, r2);
    }

    public final Continuation<Unit> create(Continuation<?> r3) {
        return new ObricAutoAppBlacklistSettingProvider$query$5(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super Cursor> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L11:
        return r4;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        ObricAutoAppBlacklistSettingProvider r5 = this.this$0;
        this.label = 1;
        List r2 = ObricAutoAppBlacklistSettingProvider.b;
        r5.getClass();
        r4 = BuildersKt.withContext(Dispatchers.getIO(), new ObricAutoAppBlacklistSettingProvider$queryA17MergedBlacklist$2(null), this);
        if (r4 != r0) goto L11;
        return r0;
    }
}
