package com.ss.android.lark.create.groupchat.impl.service.interceptor;

import android.content.Context;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.utils.UIUtils;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.create.groupchat.impl.service.interceptor.ExceedGroupLimitAndApplyInterceptor$intercept$1", f = "ExceedGroupLimitAndApplyInterceptor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ExceedGroupLimitAndApplyInterceptor$intercept$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ ErrorResult $err;
    final /* synthetic */ Function1<Boolean, Unit> $interceptAction;
    final /* synthetic */ boolean $isExternal;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public ExceedGroupLimitAndApplyInterceptor$intercept$1(ErrorResult r1, Context r2, boolean r3, Function1<? super Boolean, Unit> r4, Continuation<? super ExceedGroupLimitAndApplyInterceptor$intercept$1> r5) {
        this.$err = r1;
        this.$context = r2;
        this.$isExternal = r3;
        this.$interceptAction = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new ExceedGroupLimitAndApplyInterceptor$intercept$1(this.$err, this.$context, this.$isExternal, this.$interceptAction, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L12;
        ResultKt.throwOnFailure(r6);
        String r7 = this.$err.getDisplayMsg(this.$context.getString(2131890924));
        int r0 = ExceedGroupLimitAndApplyInterceptor.a;
        Context r1 = this.$context;
        Intrinsics.checkNotNull(r7);
        boolean r2 = this.$isExternal;
        Function1<Boolean, Unit> r3 = this.$interceptAction;
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r7, "msg");
        UDDialog r8 = new UDDialogBuilder(r1).title(UIUtils.getString(r1, 2131890927)).message(r7).addActionButton(2131391778, 2131891542, c.a).addActionButton(2131391777, 2131890926, new d(r3, r2)).build();
        if (DialogLancet.shouldBlockDialogShow(r8) == false) goto L14;
        DialogLancet.handleBlockedDialogShow(r8);
    L10:
        return Unit.INSTANCE;
    L14:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L13
    L8:
        DialogLancet.beforeDialogShow(r8);
        r8.show();
        DialogLancet.afterDialogShow(r8);
        goto L10
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
