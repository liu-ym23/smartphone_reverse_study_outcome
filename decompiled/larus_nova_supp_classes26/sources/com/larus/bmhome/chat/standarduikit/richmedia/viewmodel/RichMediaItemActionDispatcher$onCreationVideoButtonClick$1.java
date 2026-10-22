package com.larus.bmhome.chat.standarduikit.richmedia.viewmodel;

import android.view.View;
import com.larus.bmhome.chat.block.base.config.IRichMediaCreationClickService;
import com.larus.bmhome.chat.block.base.config.RichMediaCreationVideoButtonAction;
import com.larus.im.bean.message.CreationItem;
import com.larus.im.bean.message.Message;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.standarduikit.richmedia.viewmodel.RichMediaItemActionDispatcher$onCreationVideoButtonClick$1", f = "RichMediaItemActionDispatcher.kt", i = {}, l = {239}, m = "invokeSuspend", n = {}, s = {})
final class RichMediaItemActionDispatcher$onCreationVideoButtonClick$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ RichMediaCreationVideoButtonAction $action;
    final /* synthetic */ View $anchor;
    final /* synthetic */ CreationItem $creationItem;
    final /* synthetic */ f0 $currentDependency;
    final /* synthetic */ fn8.c $item;
    final /* synthetic */ Function0<Unit> $onCompleted;
    final /* synthetic */ CoroutineScope $scope;
    int label;
    final /* synthetic */ u this$0;

    public RichMediaItemActionDispatcher$onCreationVideoButtonClick$1(RichMediaCreationVideoButtonAction r1, View r2, u r3, CreationItem r4, f0 r5, CoroutineScope r6, Function0<Unit> r7, fn8.c r8, Continuation<? super RichMediaItemActionDispatcher$onCreationVideoButtonClick$1> r9) {
        this.$action = r1;
        this.$anchor = r2;
        this.this$0 = r3;
        this.$creationItem = r4;
        this.$currentDependency = r5;
        this.$scope = r6;
        this.$onCompleted = r7;
        this.$item = r8;
        super(2, r9);
    }

    public final Continuation<Unit> create(Object r11, Continuation<?> r12) {
        return new RichMediaItemActionDispatcher$onCreationVideoButtonClick$1(this.$action, this.$anchor, this.this$0, this.$creationItem, this.$currentDependency, this.$scope, this.$onCompleted, this.$item, r12);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r14);
    L18:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r14);
        IRichMediaCreationClickService.Companion r2 = IRichMediaCreationClickService.a;
        RichMediaCreationVideoButtonAction r15 = this.$action;
        View r3 = this.$anchor;
        u r4 = this.this$0;
        Message r5 = r4.a;
        CreationItem r6 = this.$creationItem;
        int r7 = r4.f(r6);
        f0 r8 = this.this$0.e;
        if (r8 != null) goto L11;
    L13:
        boolean r9 = false;
    L14:
        kc8.q r10 = this.$currentDependency.g();
        CoroutineScope r11 = this.$scope;
        Function0<Unit> r12 = this.$onCompleted;
        JSONObject r13 = this.this$0.p(this.$item);
        this.label = 1;
        if (r2.b(r15, r3, r5, r6, r7, r9, r10, r11, r12, r13, this) != r0) goto L18;
        return r0;
    L11:
        if (r8.l() != true) goto L13;
        r9 = true;
        goto L14
    }
}
