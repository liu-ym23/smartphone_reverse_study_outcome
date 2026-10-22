package com.bytedance.android.ec.core.opt.ab;

import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.services.apm.api.EnsureManager;
import com.google.gson.Gson;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Add missing generic type declarations: [Config] */
/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002*\u00020\u0003H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "Config", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.ec.core.opt.ab.LazyOptHostSettings$getSettingsValue$2", f = "LazyHostSettings.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class LazyOptHostSettings$getSettingsValue$2<Config> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Config>, Object> {
    final /* synthetic */ Object $value;
    int label;
    final /* synthetic */ LazyOptHostSettings this$0;

    public LazyOptHostSettings$getSettingsValue$2(LazyOptHostSettings r1, Object r10, Continuation r11) {
        this.this$0 = r1;
        this.$value = r10;
        super(2, r11);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        Intrinsics.checkNotNullParameter(r11, "completion");
        return new LazyOptHostSettings$getSettingsValue$2(this.this$0, this.$value, r11);
    }

    public final Object invoke(Object r1, Object r10) {
        return create(r1, (Continuation) r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L11;
        ResultKt.throwOnFailure(r10);
        LazyOptHostSettings r11 = this.this$0;
        Object r0 = this.$value;
        AtomicBoolean r1 = LazyOptHostSettings.j;
        r11.getClass();
        Gson r12 = u0.c();     // Catch: Throwable -> L7
        return r12.fromJson(r12.toJson(r0), r11.f.getClass());
    L7:
        th = move-exception;
        EnsureManager.ensureNotReachHere(th);
        return r11.f;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
