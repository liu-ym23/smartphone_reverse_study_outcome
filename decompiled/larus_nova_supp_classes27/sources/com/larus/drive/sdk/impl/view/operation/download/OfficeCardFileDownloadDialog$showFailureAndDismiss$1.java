package com.larus.drive.sdk.impl.view.operation.download;

import com.larus.nova.NovaApplication;
import gd9.i;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.drive.sdk.impl.view.operation.download.OfficeCardFileDownloadDialog$showFailureAndDismiss$1", f = "OfficeCardFileDownloadDialog.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class OfficeCardFileDownloadDialog$showFailureAndDismiss$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ OfficeCardFileDownloadDialog this$0;

    public OfficeCardFileDownloadDialog$showFailureAndDismiss$1(OfficeCardFileDownloadDialog r1, Continuation<? super OfficeCardFileDownloadDialog$showFailureAndDismiss$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new OfficeCardFileDownloadDialog$showFailureAndDismiss$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L13;
        ResultKt.throwOnFailure(r2);
        OfficeCardFileDownloadDialog r3 = this.this$0;
        if (r3.g == true) goto L10;
        s r0 = s.a;
        NovaApplication r4 = r3.getContext();
        if (r4 != null) goto L9;
        i r5 = com.larus.im.b.a;
        Intrinsics.checkNotNull(r5);
        r4 = r5.getApplication();
    L9:
        r0.getClass();
        s.s(r4, 2131910881);
    L10:
        this.this$0.V90();
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
