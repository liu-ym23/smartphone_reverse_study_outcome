package com.larus.camera.impl.ui.viewmodel;

import android.app.Application;
import android.net.Uri;
import com.larus.camera.api.params.OutputParam;
import com.larus.common.apphost.AppHost;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.viewmodel.CameraResultViewModel$download$1$uriString$1", f = "CameraResultViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class CameraResultViewModel$download$1$uriString$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    int label;
    final /* synthetic */ CameraResultViewModel this$0;

    public CameraResultViewModel$download$1$uriString$1(CameraResultViewModel r1, Continuation<? super CameraResultViewModel$download$1$uriString$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new CameraResultViewModel$download$1$uriString$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super String> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L15;
        ResultKt.throwOnFailure(r4);
        char r5 = com.larus.utils.r.a;
        Application r6 = AppHost.a.getApplication();
        OutputParam r0 = this.this$0.getCurrentDisplayOutputParam();
        String r1 = null;
        if (r0 == null) goto L7;
        String r2 = r0.getPath();
    L8:
        Uri r7 = com.larus.utils.r.u(r6, r2, true);
        if (r7 == null) goto L11;
        r1 = r7.toString();
    L11:
        if (r1 != null) goto L16;
        return "";
    L16:
        return r1;
    L7:
        r2 = null;
        goto L8
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
