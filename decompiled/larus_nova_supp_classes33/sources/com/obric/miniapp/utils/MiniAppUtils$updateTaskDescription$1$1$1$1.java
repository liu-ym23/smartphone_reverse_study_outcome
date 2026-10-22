package com.obric.miniapp.utils;

import android.app.ActivityManager;
import android.graphics.Bitmap;
import androidx.activity.ComponentActivity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.miniapp.utils.MiniAppUtils$updateTaskDescription$1$1$1$1", f = "MiniAppUtils.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MiniAppUtils$updateTaskDescription$1$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ComponentActivity $activity;
    final /* synthetic */ String $appletLabel;
    final /* synthetic */ Bitmap $bitmap;
    int label;

    public MiniAppUtils$updateTaskDescription$1$1$1$1(ComponentActivity r1, String r2, Bitmap r3, Continuation<? super MiniAppUtils$updateTaskDescription$1$1$1$1> r4) {
        this.$activity = r1;
        this.$appletLabel = r2;
        this.$bitmap = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new MiniAppUtils$updateTaskDescription$1$1$1$1(this.$activity, this.$appletLabel, this.$bitmap, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L12;
        ResultKt.throwOnFailure(r4);
        if (this.$activity.isDestroyed() == true) goto L10;
        if (this.$activity.isFinishing() == true) goto L10;
        ActivityManager.TaskDescription r5 = new ActivityManager.TaskDescription(this.$appletLabel, this.$bitmap, 0);
        this.$activity.setTaskDescription(r5);
    L10:
        return Unit.INSTANCE;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
