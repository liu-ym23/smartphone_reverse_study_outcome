package com.larus.bmhome.chat.standarduikit.richmedia.viewmodel;

import android.view.View;
import com.larus.bmhome.chat.block.base.config.IRichMediaCreationClickService;
import com.larus.bmhome.chat.block.base.config.RichMediaCreationImageButtonAction;
import com.larus.im.bean.message.CreationItem;
import com.larus.im.bean.message.Message;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.standarduikit.richmedia.viewmodel.RichMediaItemActionDispatcher$onCreationImageButtonClick$1", f = "RichMediaItemActionDispatcher.kt", i = {}, l = {210}, m = "invokeSuspend", n = {}, s = {})
final class RichMediaItemActionDispatcher$onCreationImageButtonClick$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ RichMediaCreationImageButtonAction $action;
    final /* synthetic */ View $anchor;
    final /* synthetic */ CreationItem $creationItem;
    final /* synthetic */ f0 $currentDependency;
    final /* synthetic */ fn8.c $item;
    final /* synthetic */ Function0<Unit> $onCompleted;
    final /* synthetic */ CoroutineScope $scope;
    int label;
    final /* synthetic */ u this$0;

    public RichMediaItemActionDispatcher$onCreationImageButtonClick$1(RichMediaCreationImageButtonAction r1, View r2, u r3, CreationItem r4, f0 r5, CoroutineScope r6, fn8.c r7, Function0<Unit> r8, Continuation<? super RichMediaItemActionDispatcher$onCreationImageButtonClick$1> r9) {
        this.$action = r1;
        this.$anchor = r2;
        this.this$0 = r3;
        this.$creationItem = r4;
        this.$currentDependency = r5;
        this.$scope = r6;
        this.$item = r7;
        this.$onCompleted = r8;
        super(2, r9);
    }

    public final Continuation<Unit> create(Object r11, Continuation<?> r12) {
        return new RichMediaItemActionDispatcher$onCreationImageButtonClick$1(this.$action, this.$anchor, this.this$0, this.$creationItem, this.$currentDependency, this.$scope, this.$item, this.$onCompleted, r12);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r18) {
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L8;
        if (r0 != 1) goto L7;
        ResultKt.throwOnFailure(r18);
    L17:
        this.$onCompleted.invoke();
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r18);
        IRichMediaCreationClickService.Companion r1 = IRichMediaCreationClickService.a;
        RichMediaCreationImageButtonAction r2 = this.$action;
        View r3 = this.$anchor;
        u r4 = this.this$0;
        Message r5 = r4.a;
        CreationItem r6 = this.$creationItem;
        int r7 = r4.f(r6);
        String r8 = this.$currentDependency.getCurrentPage();
        String r9 = this.$currentDependency.b();
        Boolean r10 = Boxing.boxBoolean(this.this$0.h());
        f0 r11 = this.this$0.e;
        if (r11 != null) goto L11;
    L13:
        boolean r12 = false;
    L14:
        kc8.q r13 = this.$currentDependency.g();
        CoroutineScope r14 = this.$scope;
        JSONObject r16 = this.this$0.p(this.$item);
        this.label = 1;
        if (r1.f(r2, r3, r5, r6, r7, r8, r9, r10, r12, r13, r14, r16, this) != r15) goto L17;
        return r15;
    L11:
        if (r11.l() != true) goto L13;
        r12 = true;
        goto L14
    }
}
