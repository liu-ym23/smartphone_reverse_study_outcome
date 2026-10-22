package com.bytedance.android.anniex.lite.flow.web.task;

import android.app.Application;
import android.util.LruCache;
import com.bytedance.android.anniex.lite.c;
import com.bytedance.android.anniex.web.model.AnnieXWebModel;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.anniex.lite.flow.web.task.AnnieXWebEnginePreloadTask$work$2$2$1$1", f = "AnnieXWebEnginePreloadTask.kt", i = {}, l = {56}, m = "invokeSuspend", n = {}, s = {})
public final class AnnieXWebEnginePreloadTask$work$2$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AnnieXWebModel $_annieWebXModel;
    final /* synthetic */ Application $context;
    final /* synthetic */ com.bytedance.android.anniex.lite.flow.model.a $loadStateModel;
    int label;
    final /* synthetic */ a this$0;

    public AnnieXWebEnginePreloadTask$work$2$2$1$1(Application r1, a r10, AnnieXWebModel r11, com.bytedance.android.anniex.lite.flow.model.a r12, Continuation<? super AnnieXWebEnginePreloadTask$work$2$2$1$1> r13) {
        this.$context = r1;
        this.$_annieWebXModel = r11;
        this.$loadStateModel = r12;
        super(2, r13);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new AnnieXWebEnginePreloadTask$work$2$2$1$1(this.$context, null, this.$_annieWebXModel, this.$loadStateModel, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 != 0) goto L5;
        ResultKt.throwOnFailure(r10);
        LruCache<String, AnnieXWebModel> r11 = c.a;
        Intrinsics.checkNotNull(this.$context, "null cannot be cast to non-null type android.content.Context");
        throw null;
    L5:
        if (r0 != 1) goto L9;
        ResultKt.throwOnFailure(r10);
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
