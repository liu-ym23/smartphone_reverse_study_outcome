package com.larus.camera.impl.result;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import androidx.fragment.app.FragmentActivity;
import com.larus.camera.api.params.CameraResultOutOpenParams;
import com.larus.common.apphost.AppHost;
import com.larus.platform.api.g3;
import com.larus.platform.service.k2;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.result.CameraResultFirstFlow$start$1", f = "CameraResultFirstFlow.kt", i = {}, l = {97}, m = "invokeSuspend", n = {}, s = {})
public final class CameraResultFirstFlow$start$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ Uri $imageUri;
    final /* synthetic */ CameraResultOutOpenParams $params;
    int label;

    public CameraResultFirstFlow$start$1(Context r1, Uri r2, CameraResultOutOpenParams r3, Continuation<? super CameraResultFirstFlow$start$1> r4) {
        this.$context = r1;
        this.$imageUri = r2;
        this.$params = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new CameraResultFirstFlow$start$1(this.$context, this.$imageUri, this.$params, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        FragmentActivity r2 = null;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r12);
    L12:
        if (((Boolean) r12).booleanValue() == false) goto L14;
        CameraResultFirstFlow r13 = CameraResultFirstFlow.a;
        Context r3 = this.$context;
        CameraResultOutOpenParams r4 = this.$params;
        r13.getClass();
        Boxing.boxBoolean(CameraResultFirstFlow.j(r3, r4));
    L26:
        return Unit.INSTANCE;
    L14:
        CameraResultFirstFlow r14 = CameraResultFirstFlow.a;
        final Context r5 = this.$context;
        final CameraResultOutOpenParams r6 = this.$params;
        final Uri r7 = this.$imageUri;
        r14.getClass();
        if ((r5 instanceof FragmentActivity) == false) goto L17;
        FragmentActivity r15 = (FragmentActivity) r5;
    L18:
        if (r15 != null) goto L23;
        Activity r16 = AppHost.a.a().getCurrentActivity();
        if ((r16 instanceof FragmentActivity) == false) goto L22;
        r2 = (FragmentActivity) r16;
    L22:
        FragmentActivity r8 = r2;
    L24:
        k2 r17 = k2.a;
        g3.a.a(null, r8, false, null, true, new b(r5, r7, r6), 13);
        goto L26
    L23:
        r8 = r15;
        goto L24
    L17:
        r15 = null;
        goto L18
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r12);
        CameraResultFirstFlow r18 = CameraResultFirstFlow.a;
        Context r9 = this.$context;
        Uri r10 = this.$imageUri;
        this.label = 1;
        r18.getClass();
        r12 = BuildersKt.withContext(Dispatchers.getIO(), new CameraResultFirstFlow$canReadUri$2(r10, r9, null), this);
        if (r12 != r0) goto L12;
        return r0;
    }
}
