package com.ss.android.lark.contact.customized.common.repository;

import com.bytedance.lark.pb.contact.v2.GetContactsScene;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.ttvideoengine.utils.Error;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
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
import mtb.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.contact.customized.common.repository.ContactOpenRepository$getContactList$1", f = "ContactOpenRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ContactOpenRepository$getContactList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IGetDataCallback<List<d>> $callback;
    final /* synthetic */ GetContactsScene $pbScene;
    final /* synthetic */ boolean $preferLocal;
    int label;
    final /* synthetic */ a this$0;

    public ContactOpenRepository$getContactList$1(boolean r1, a r2, GetContactsScene r3, IGetDataCallback<List<d>> r4, Continuation<? super ContactOpenRepository$getContactList$1> r5) {
        this.$preferLocal = r1;
        this.this$0 = r2;
        this.$pbScene = r3;
        this.$callback = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new ContactOpenRepository$getContactList$1(this.$preferLocal, this.this$0, this.$pbScene, this.$callback, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L62;
        ResultKt.throwOnFailure(r6);
        boolean r1 = true;
        if (this.$preferLocal == false) goto L32;
        Pair r7 = a.c(this.this$0, true, this.$pbScene);
        Collection r3 = (Collection) r7.getFirst();
        if (r3 != null) goto L9;
    L12:
        boolean r4 = true;
    L13:
        if (r4 == true) goto L16;
        this.$callback.onSuccess(r7.getFirst());
        return Unit.INSTANCE;
    L16:
        ErrorResult r8 = (ErrorResult) r7.getSecond();
        if (r8 != null) goto L19;
        r8 = null;
    L19:
        Pair r5 = a.c(this.this$0, false, this.$pbScene);
        Collection r9 = (Collection) r5.getFirst();
        if (r9 != null) goto L22;
    L25:
        if (r1 == true) goto L28;
        this.$callback.onSuccess(r5.getFirst());
        return Unit.INSTANCE;
    L28:
        ErrorResult r2 = (ErrorResult) r5.getSecond();
        if (r2 == null) goto L56;
    L31:
        r8 = r2;
    L56:
        IGetDataCallback<List<d>> r10 = this.$callback;
        if (r8 != null) goto L59;
        Exception r11 = new Exception("unknown error");
        ErrorResult r12 = new ErrorResult(0);
        ErrorResult.access$002(r12, -1);
        ErrorResult.access$102(r12, Error.ParameterNull);
        ErrorResult.access$202(r12, 0);
        ErrorResult.access$302(r12, r11);
        ErrorResult.access$402(r12, BuildConfig.FLAVOR);
        ErrorResult.access$502(r12, BuildConfig.FLAVOR);
        ErrorResult.access$602(r12, BuildConfig.FLAVOR);
        ErrorResult.access$702(r12, BuildConfig.FLAVOR);
        ErrorResult.access$802(r12, 0);
        ErrorResult.access$902(r12, null);
        ErrorResult.access$1002(r12, null);
        ErrorResult.access$1102(r12, null);
        r8 = r12;
    L59:
        r10.onError(r8);
        return Unit.INSTANCE;
    L22:
        if (r9.isEmpty() == true) goto L25;
        r1 = false;
        goto L25
    L9:
        if (r3.isEmpty() == true) goto L12;
        r4 = false;
        goto L13
    L32:
        Pair r13 = a.c(this.this$0, false, this.$pbScene);
        Collection r14 = (Collection) r13.getFirst();
        if (r14 != null) goto L35;
    L38:
        boolean r15 = true;
    L39:
        if (r15 == true) goto L42;
        this.$callback.onSuccess(r13.getFirst());
        return Unit.INSTANCE;
    L42:
        r8 = (ErrorResult) r13.getSecond();
        if (r8 != null) goto L45;
        r8 = null;
    L45:
        Pair r16 = a.c(this.this$0, true, this.$pbScene);
        Collection r17 = (Collection) r16.getFirst();
        if (r17 != null) goto L48;
    L51:
        if (r1 == true) goto L54;
        this.$callback.onSuccess(r16.getFirst());
        return Unit.INSTANCE;
    L54:
        r2 = (ErrorResult) r16.getSecond();
        if (r2 != null) goto L31;
    L48:
        if (r17.isEmpty() == true) goto L51;
        r1 = false;
        goto L51
    L35:
        if (r14.isEmpty() == true) goto L38;
        r15 = false;
        goto L39
    L62:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
