package com.larus.bmhome.chat.service.action;

import android.view.View;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.taskskill.service.IProjectListDataSource;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.service.action.MoveToProjectConversationActionHandler$showProjectMenu$4$1", f = "MoveToProjectConversationActionHandler.kt", i = {}, l = {574}, m = "invokeSuspend", n = {}, s = {})
final class MoveToProjectConversationActionHandler$showProjectMenu$4$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ View $anchor;
    final /* synthetic */ IProjectListDataSource $dataSource;
    final /* synthetic */ Ref.BooleanRef $isLoadingMore;
    final /* synthetic */ Function2<com.larus.bmhome.taskskill.service.i, Boolean, Unit> $submitSnapshot;
    int label;
    final /* synthetic */ z this$0;

    public MoveToProjectConversationActionHandler$showProjectMenu$4$1(IProjectListDataSource r1, Ref.BooleanRef r2, Function2<? super com.larus.bmhome.taskskill.service.i, ? super Boolean, Unit> r3, View r4, z r5, Continuation<? super MoveToProjectConversationActionHandler$showProjectMenu$4$1> r6) {
        this.$dataSource = r1;
        this.$isLoadingMore = r2;
        this.$submitSnapshot = r3;
        this.$anchor = r4;
        this.this$0 = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new MoveToProjectConversationActionHandler$showProjectMenu$4$1(this.$dataSource, this.$isLoadingMore, this.$submitSnapshot, this.$anchor, this.this$0, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
        Object r7 = ((Result) r6).unbox-impl();
    L11:
        Ref.BooleanRef r2 = this.$isLoadingMore;
        Function2<com.larus.bmhome.taskskill.service.i, Boolean, Unit> r3 = this.$submitSnapshot;
        if (Result.isSuccess-impl(r7) == false) goto L14;
        r2.element = false;
        r3.invoke((com.larus.bmhome.taskskill.service.i) r7, Boxing.boxBoolean(false));
    L14:
        Ref.BooleanRef r4 = this.$isLoadingMore;
        View r5 = this.$anchor;
        z r8 = this.this$0;
        Throwable r9 = Result.exceptionOrNull-impl(r7);
        if (r9 == null) goto L20;
        r4.element = false;
        FLogger.a.e("MoveToProjectActionHandler", "load shared project list failed", r9);
        if (r5.isAttachedToWindow() == false) goto L20;
        int r10 = z.c;
        r8.getClass();
        z.b(r5);
    L20:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        IProjectListDataSource r11 = this.$dataSource;
        this.label = 1;
        r7 = r11.d(this);
        if (r7 != r0) goto L11;
        return r0;
    }
}
