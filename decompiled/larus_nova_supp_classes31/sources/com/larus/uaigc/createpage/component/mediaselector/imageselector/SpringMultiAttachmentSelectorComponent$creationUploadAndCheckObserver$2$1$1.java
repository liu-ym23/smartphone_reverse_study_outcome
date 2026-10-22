package com.larus.uaigc.createpage.component.mediaselector.imageselector;

import com.larus.uaigc.bean.createpage.component.mediacontainer.UIStatus;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.mediaselector.imageselector.SpringMultiAttachmentSelectorComponent$creationUploadAndCheckObserver$2$1$1", f = "SpringMultiAttachmentSelectorComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class SpringMultiAttachmentSelectorComponent$creationUploadAndCheckObserver$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ry9.k $multiStatus;
    int label;
    final /* synthetic */ SpringMultiAttachmentSelectorComponent this$0;

    public SpringMultiAttachmentSelectorComponent$creationUploadAndCheckObserver$2$1$1(ry9.k r1, SpringMultiAttachmentSelectorComponent r2, Continuation<? super SpringMultiAttachmentSelectorComponent$creationUploadAndCheckObserver$2$1$1> r3) {
        this.$multiStatus = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new SpringMultiAttachmentSelectorComponent$creationUploadAndCheckObserver$2$1$1(this.$multiStatus, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L25;
        ResultKt.throwOnFailure(r11);
        ry9.k r12 = this.$multiStatus;
        ry9.j r0 = r12.b;
        String r13 = r12.a;
        if ((r0 instanceof ry9.j.g) == false) goto L8;
        this.this$0.A.setValue(new ry9.f(r13, 80, null, UIStatus.STATUS_REFRESH_PROGRESS, 4));
    L8:
        if ((r0 instanceof ry9.j.h) == false) goto L11;
        this.this$0.A.setValue(new ry9.f(r13, this.$multiStatus.c, null, UIStatus.STATUS_REFRESH_PROGRESS, 4));
    L11:
        if ((r0 instanceof ry9.j.f) == false) goto L14;
        this.this$0.A.setValue(new ry9.f(r13, 0, null, UIStatus.STATUS_UPLOAD_FAIL, 6));
    L14:
        if ((r0 instanceof ry9.j.e) == false) goto L17;
        this.this$0.A.setValue(new ry9.f(r13, 0, null, UIStatus.STATUS_PARSE_FAILED, 6));
    L17:
        if ((r0 instanceof ry9.j.d) == false) goto L20;
        this.this$0.A.setValue(new ry9.f(r13, 0, null, UIStatus.STATUS_INSPECT_FAILED, 6));
    L20:
        if ((r0 instanceof ry9.j.c) == false) goto L23;
        this.this$0.A.setValue(new ry9.f(r13, 0, null, UIStatus.STATUS_FINISH, 6));
    L23:
        return Unit.INSTANCE;
    L25:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
