package com.ss.android.lark.flow.chat.creategroup.data;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.flow.chat.creategroup.data.FlowGroupCreateContactRepository$getContactList$1", f = "FlowGroupCreateContactRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class FlowGroupCreateContactRepository$getContactList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IGetDataCallback<List<a>> $callback;
    final /* synthetic */ Long $chatId;
    final /* synthetic */ boolean $preferLocal;
    int label;

    public FlowGroupCreateContactRepository$getContactList$1(boolean r1, Long r2, IGetDataCallback<List<a>> r3, Continuation<? super FlowGroupCreateContactRepository$getContactList$1> r4) {
        this.$preferLocal = r1;
        this.$chatId = r2;
        this.$callback = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new FlowGroupCreateContactRepository$getContactList$1(this.$preferLocal, this.$chatId, this.$callback, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L63;
        ResultKt.throwOnFailure(r6);
        boolean r0 = true;
        if (this.$preferLocal == false) goto L31;
        int r7 = d.a;
        Pair r8 = d.a(true, this.$chatId);
        Collection r3 = (Collection) r8.getFirst();
        if (r3 != null) goto L9;
    L12:
        boolean r4 = true;
    L13:
        if (r4 == true) goto L16;
        this.$callback.onSuccess(r8.getFirst());
        return Unit.INSTANCE;
    L16:
        ErrorResult r9 = (ErrorResult) r8.getSecond();
        if (r9 != null) goto L19;
        r9 = null;
    L19:
        Pair r5 = d.a(false, this.$chatId);
        Collection r10 = (Collection) r5.getFirst();
        if (r10 != null) goto L22;
    L25:
        if (r0 == true) goto L28;
        this.$callback.onSuccess(r5.getFirst());
        return Unit.INSTANCE;
    L28:
        ErrorResult r1 = (ErrorResult) r5.getSecond();
        if (r1 == null) goto L57;
    L56:
        r9 = r1;
    L57:
        IGetDataCallback<List<a>> r2 = this.$callback;
        if (r9 != null) goto L60;
        Exception r11 = new Exception("unknown error");
        ErrorResult r12 = new ErrorResult(0);
        ErrorResult.access$002(r12, -1);
        ErrorResult.access$102(r12, -9999);
        ErrorResult.access$202(r12, 0);
        ErrorResult.access$302(r12, r11);
        ErrorResult.access$402(r12, "");
        ErrorResult.access$502(r12, "");
        ErrorResult.access$602(r12, "");
        ErrorResult.access$702(r12, "");
        ErrorResult.access$802(r12, 0);
        ErrorResult.access$902(r12, null);
        ErrorResult.access$1002(r12, null);
        ErrorResult.access$1102(r12, null);
        r9 = r12;
    L60:
        r2.onError(r9);
        return Unit.INSTANCE;
    L22:
        if (r10.isEmpty() == true) goto L25;
        r0 = false;
        goto L25
    L9:
        if (r3.isEmpty() == true) goto L12;
        r4 = false;
        goto L13
    L31:
        int r13 = d.a;
        Pair r14 = d.a(false, this.$chatId);
        Collection r15 = (Collection) r14.getFirst();
        if (r15 != null) goto L34;
    L37:
        boolean r16 = true;
    L38:
        if (r16 == true) goto L41;
        this.$callback.onSuccess(r14.getFirst());
        return Unit.INSTANCE;
    L41:
        r9 = (ErrorResult) r14.getSecond();
        if (r9 != null) goto L44;
        r9 = null;
    L44:
        Pair r17 = d.a(true, this.$chatId);
        Collection r18 = (Collection) r17.getFirst();
        if (r18 != null) goto L47;
    L50:
        if (r0 == true) goto L53;
        this.$callback.onSuccess(r17.getFirst());
        return Unit.INSTANCE;
    L53:
        r1 = (ErrorResult) r17.getSecond();
        if (r1 != null) goto L56;
    L47:
        if (r18.isEmpty() == true) goto L50;
        r0 = false;
        goto L50
    L34:
        if (r15.isEmpty() == true) goto L37;
        r16 = false;
        goto L38
    L63:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
