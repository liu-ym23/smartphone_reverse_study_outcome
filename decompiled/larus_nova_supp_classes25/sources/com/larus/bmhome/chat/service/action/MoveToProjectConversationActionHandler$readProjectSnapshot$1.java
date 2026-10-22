package com.larus.bmhome.chat.service.action;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.taskskill.service.IProjectListDataSource;
import com.larus.utils.logger.FLogger;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.service.action.MoveToProjectConversationActionHandler$readProjectSnapshot$1", f = "MoveToProjectConversationActionHandler.kt", i = {0}, l = {182}, m = "invokeSuspend", n = {"previousItemCount"}, s = {"I$0"})
final class MoveToProjectConversationActionHandler$readProjectSnapshot$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IProjectListDataSource $dataSource;
    final /* synthetic */ Function0<Unit> $onFailure;
    final /* synthetic */ Function1<com.larus.bmhome.taskskill.service.i, Unit> $onSuccess;
    int I$0;
    int label;

    public MoveToProjectConversationActionHandler$readProjectSnapshot$1(IProjectListDataSource r1, Function0<Unit> r2, Function1<? super com.larus.bmhome.taskskill.service.i, Unit> r3, Continuation<? super MoveToProjectConversationActionHandler$readProjectSnapshot$1> r4) {
        this.$dataSource = r1;
        this.$onFailure = r2;
        this.$onSuccess = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new MoveToProjectConversationActionHandler$readProjectSnapshot$1(this.$dataSource, this.$onFailure, this.$onSuccess, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x0087 -> B:38:0x008a). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        int r2 = this.I$0;
        ResultKt.throwOnFailure(r9);
        Object r10 = ((Result) r9).unbox-impl();
        int r3 = r2;
        MoveToProjectConversationActionHandler$readProjectSnapshot$1 r4 = this;
    L38:
        Function0<Unit> r5 = r4.$onFailure;
        Throwable r6 = Result.exceptionOrNull-impl(r10);
        if (r6 != null) goto L46;
        com.larus.bmhome.taskskill.service.i r11 = (com.larus.bmhome.taskskill.service.i) r10;
        if (r11.b == true) goto L43;
    L10:
        if (r11.b == false) goto L48;
        List r7 = r11.a;
        int r8 = 0;
        if ((r7 instanceof Collection) == true) goto L14;
    L16:
        Iterator r12 = r7.iterator();
        int r13 = 0;
    L18:
        if (r12.hasNext() == false) goto L31;
        String r14 = ((com.larus.bmhome.taskskill.service.h) r12.next()).a.projectId;
        if (r14 != null) goto L22;
    L25:
        boolean r15 = true;
    L27:
        if ((!r15) == false) goto L18;
        r13 = r13 + 1;
        if (r13 >= 0) goto L18;
        CollectionsKt.throwCountOverflow();
        goto L18
    L22:
        if (r14.length() == 0) goto L25;
        r15 = false;
        goto L27
    L31:
        r8 = r13;
    L33:
        if (r8 >= 20) goto L48;
        int r16 = r11.a.size();
        IProjectListDataSource r17 = r4.$dataSource;
        r4.I$0 = r16;
        r4.label = 1;
        Object r18 = r17.d(r4);
        if (r18 != r0) goto L37;
        return r0;
    L37:
        r3 = r16;
        r10 = r18;
        goto L38
    L14:
        if (r7.isEmpty() == false) goto L16;
    L48:
        r4.$onSuccess.invoke(r11);
        return Unit.INSTANCE;
    L43:
        if (r11.a.size() > r3) goto L10;
        FLogger.a.w("MoveToProjectActionHandler", "initial shared project list load made no progress");
        r4.$onFailure.invoke();
        return Unit.INSTANCE;
    L46:
        FLogger.a.e("MoveToProjectActionHandler", "load initial shared project list failed", r6);
        r5.invoke();
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r9);
        r11 = this.$dataSource.getList();
        r4 = this;
        goto L10
    }
}
