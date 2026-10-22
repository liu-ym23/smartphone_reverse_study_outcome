package com.obric.miniapp.view;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.google.gson.JsonObject;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Metadata;
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
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.miniapp.view.MiniAppBaseActivity$showUpdateDialog$2$builder$1$onClick$1", f = "MiniAppBaseActivity.kt", i = {0}, l = {650}, m = "invokeSuspend", n = {"context"}, s = {"L$0"})
public final class MiniAppBaseActivity$showUpdateDialog$2$builder$1$onClick$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DialogInterface $dialog;
    final /* synthetic */ Intent $originalIntent;
    Object L$0;
    int label;
    final /* synthetic */ MiniAppBaseActivity this$0;

    public MiniAppBaseActivity$showUpdateDialog$2$builder$1$onClick$1(MiniAppBaseActivity r1, DialogInterface r2, Intent r3, Continuation<? super MiniAppBaseActivity$showUpdateDialog$2$builder$1$onClick$1> r4) {
        this.this$0 = r1;
        this.$dialog = r2;
        this.$originalIntent = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new MiniAppBaseActivity$showUpdateDialog$2$builder$1$onClick$1(this.this$0, this.$dialog, this.$originalIntent, r5);
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
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        Context r2 = (Context) this.L$0;
        ResultKt.throwOnFailure(r8);
    L19:
        AppletRuntimeManager r9 = AppletRuntimeManager.INSTANCE;
        String r3 = this.this$0.j;
        r9.getClass();
        Intrinsics.checkNotNullParameter(r3, "appletId");
        AppletRuntimeManager.j().d(r3);
        Set<String> r10 = this.$originalIntent.getCategories();
        if (r10 == null) goto L22;
        Boxing.boxBoolean(r10.remove("android.intent.category.LAUNCHER"));
    L22:
        this.$originalIntent.addFlags(268435456);
        r2.startActivity(this.$originalIntent);
    L24:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        if (this.this$0.isDestroyed() == true) goto L24;
        if (this.this$0.isFinishing() == true) goto L24;
        Context r11 = this.this$0.getApplicationContext();
        Lazy r4 = l3.d.a;
        JsonObject r5 = new JsonObject();
        MiniAppBaseActivity r6 = this.this$0;
        r5.addProperty("value", Boxing.boxBoolean(true));
        r5.addProperty("appletId", r6.P1());
        Unit r7 = Unit.INSTANCE;
        l3.d.c(new l3.a("applet.restart", r5, 4));
        DialogInterface r12 = this.$dialog;
        if (r12 == null) goto L15;
        r12.dismiss();
    L15:
        this.this$0.finish();
        this.L$0 = r11;
        this.label = 1;
        if (DelayKt.delay(500, this) != r0) goto L18;
        return r0;
    L18:
        r2 = r11;
        goto L19
    }
}
