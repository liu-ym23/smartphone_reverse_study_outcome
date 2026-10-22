package com.obric.miniapp.utils;

import android.graphics.Bitmap;
import androidx.activity.ComponentActivity;
import com.bytedance.ai.model.objects.AIPackage;
import com.bytedance.ai.model.objects.Applet;
import com.bytedance.ai.resource.AppletResourceTool;
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
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.miniapp.utils.MiniAppUtils$updateTaskDescription$1$1", f = "MiniAppUtils.kt", i = {}, l = {280, 282}, m = "invokeSuspend", n = {}, s = {})
public final class MiniAppUtils$updateTaskDescription$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ComponentActivity $activity;
    final /* synthetic */ Applet $applet;
    final /* synthetic */ String $appletLabel;
    final /* synthetic */ String $iconUrl;
    int label;

    public MiniAppUtils$updateTaskDescription$1$1(Applet r1, String r2, ComponentActivity r3, String r4, Continuation<? super MiniAppUtils$updateTaskDescription$1$1> r5) {
        this.$applet = r1;
        this.$iconUrl = r2;
        this.$activity = r3;
        this.$appletLabel = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new MiniAppUtils$updateTaskDescription$1$1(this.$applet, this.$iconUrl, this.$activity, this.$appletLabel, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r8);
    L19:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r8);
    L13:
        Bitmap r9 = (Bitmap) r8;
        if (r9 == null) goto L19;
        ComponentActivity r2 = this.$activity;
        String r3 = this.$appletLabel;
        MainCoroutineDispatcher r4 = Dispatchers.getMain();
        MiniAppUtils$updateTaskDescription$1$1$1$1 r5 = new MiniAppUtils$updateTaskDescription$1$1$1$1(r2, r3, r9, null);
        this.label = 2;
        if (BuildersKt.withContext(r4, r5, this) != r0) goto L19;
        return r0;
    L10:
        ResultKt.throwOnFailure(r8);
        AppletResourceTool r10 = AppletResourceTool.a;
        String r6 = ((AIPackage) this.$applet).x;
        String r7 = this.$iconUrl;
        this.label = 1;
        r10.getClass();
        r8 = AppletResourceTool.r(r6, r7, this);
        if (r8 != r0) goto L13;
        return r0;
    }
}
