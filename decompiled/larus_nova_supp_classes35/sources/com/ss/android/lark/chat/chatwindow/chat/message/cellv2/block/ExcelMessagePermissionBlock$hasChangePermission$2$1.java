package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

import com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.excelpermission.ExcelPermissionNetService;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.ExcelMessagePermissionBlock$hasChangePermission$2$1", f = "ExcelMessagePermissionBlock.kt", i = {}, l = {170}, m = "invokeSuspend", n = {}, s = {})
final class ExcelMessagePermissionBlock$hasChangePermission$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ExcelMessagePermissionBlock.a $blockView;
    final /* synthetic */ Continuation<Unit> $continuation;
    final /* synthetic */ y6b.c<?> $item;
    int label;
    final /* synthetic */ ExcelMessagePermissionBlock this$0;

    public ExcelMessagePermissionBlock$hasChangePermission$2$1(ExcelMessagePermissionBlock.a r1, ExcelMessagePermissionBlock r2, y6b.c<?> r3, Continuation<? super Unit> r4, Continuation<? super ExcelMessagePermissionBlock$hasChangePermission$2$1> r5) {
        this.$blockView = r1;
        this.this$0 = r2;
        this.$item = r3;
        this.$continuation = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new ExcelMessagePermissionBlock$hasChangePermission$2$1(this.$blockView, this.this$0, this.$item, this.$continuation, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r4v2, types: [com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.ExcelMessagePermissionBlock$hasChangePermission$2$1$1] */
    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L21:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        Lazy r11 = ExcelPermissionNetService.a;
        Object r12 = this.$blockView.a.getTag(2131372414);
        String r2 = BuildConfig.FLAVOR;
        if (r12 == null) goto L12;
        String r13 = r12.toString();
        if (r13 == null) goto L12;
    L13:
        ExcelMessagePermissionBlock r3 = this.this$0;
        int r4 = ExcelMessagePermissionBlock.p;
        String r5 = com.ss.android.lark.chat.chatwindow.chat.v2.push.w.a(r3.c).getUserId();
        if (r5 == null) goto L17;
        r2 = r5;
    L17:
        boolean r6 = this.this$0.j.isEnable("im.chat.session_governance");
        final ExcelMessagePermissionBlock.a r7 = this.$blockView;
        final ExcelMessagePermissionBlock r8 = this.this$0;
        final y6b.c<?> r9 = this.$item;
        final Continuation<Unit> r14 = this.$continuation;
        ?? r15 = new AnonymousClass1(r7, r8, r9, r14);
        this.label = 1;
        if (ExcelPermissionNetService.d(r13, r2, r6, r15, this) != r0) goto L21;
        return r0;
    L12:
        r13 = BuildConfig.FLAVOR;
        goto L13
    }
}
