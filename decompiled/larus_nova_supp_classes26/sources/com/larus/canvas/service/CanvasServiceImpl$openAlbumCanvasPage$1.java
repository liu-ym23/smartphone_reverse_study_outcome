package com.larus.canvas.service;

import android.app.Activity;
import android.net.Uri;
import androidx.fragment.app.FragmentActivity;
import com.larus.common.apphost.AppHost;
import com.larus.platform.api.g3;
import com.larus.platform.service.k2;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.canvas.service.CanvasServiceImpl$openAlbumCanvasPage$1", f = "CanvasServiceImpl.kt", i = {}, l = {59}, m = "invokeSuspend", n = {}, s = {})
public final class CanvasServiceImpl$openAlbumCanvasPage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Integer $displayId;
    final /* synthetic */ Uri $imageUri;
    final /* synthetic */ String $localUri;
    int label;
    final /* synthetic */ CanvasServiceImpl this$0;

    public CanvasServiceImpl$openAlbumCanvasPage$1(CanvasServiceImpl r1, Uri r2, String r3, Integer r4, Continuation<? super CanvasServiceImpl$openAlbumCanvasPage$1> r5) {
        this.this$0 = r1;
        this.$imageUri = r2;
        this.$localUri = r3;
        this.$displayId = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new CanvasServiceImpl$openAlbumCanvasPage$1(this.this$0, this.$imageUri, this.$localUri, this.$displayId, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        FragmentActivity r2 = null;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r13);
    L12:
        if (((Boolean) r13).booleanValue() == false) goto L14;
        CanvasServiceImpl r14 = this.this$0;
        String r3 = this.$localUri;
        Integer r4 = this.$displayId;
        int r5 = CanvasServiceImpl.c;
        r14.getClass();
        CanvasServiceImpl.g(r3, r4);
    L19:
        return Unit.INSTANCE;
    L14:
        final CanvasServiceImpl r15 = this.this$0;
        final String r6 = this.$localUri;
        final Uri r7 = this.$imageUri;
        Intrinsics.checkNotNull(r7);
        final Integer r8 = this.$displayId;
        int r9 = CanvasServiceImpl.c;
        r15.getClass();
        k2 r10 = k2.a;
        Activity r11 = AppHost.a.a().getCurrentActivity();
        if ((r11 instanceof FragmentActivity) == false) goto L17;
        r2 = (FragmentActivity) r11;
    L17:
        g3.a.a(null, r2, false, null, true, new a(r15, r7, r6, r8), 13);
        goto L19
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r13);
        CanvasServiceImpl r16 = this.this$0;
        Uri r12 = this.$imageUri;
        Intrinsics.checkNotNull(r12);
        this.label = 1;
        int r17 = CanvasServiceImpl.c;
        r16.getClass();
        r13 = BuildersKt.withContext(Dispatchers.getIO(), new CanvasServiceImpl$canReadUri$2(r12, null), this);
        if (r13 != r0) goto L12;
        return r0;
    }
}
