package com.larus.camera.impl.result;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.share.panel.ShareType;
import f06.d;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.result.CameraResultFirstFlow$canReadUri$2", f = "CameraResultFirstFlow.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class CameraResultFirstFlow$canReadUri$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ Uri $uri;
    private /* synthetic */ Object L$0;
    int label;

    public CameraResultFirstFlow$canReadUri$2(Uri r1, Context r2, Continuation<? super CameraResultFirstFlow$canReadUri$2> r3) {
        this.$uri = r1;
        this.$context = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        CameraResultFirstFlow$canReadUri$2 r0 = new CameraResultFirstFlow$canReadUri$2(this.$uri, this.$context, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L38;
        ResultKt.throwOnFailure(r5);
        CoroutineScope r6 = (CoroutineScope) this.L$0;
        String r7 = this.$uri.getScheme();
        if (r7 == null) goto L34;
        int r0 = r7.hashCode();
        boolean r1 = false;
        boolean r3 = true;
        if (r0 == 3143036) goto L27;
        if (r0 != 951530617) goto L36;
        if (r7.equals("content") == false) goto L36;
        Context r8 = this.$context;
        Uri r2 = this.$uri;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L20
        ParcelFileDescriptor r9 = a(r8.getContentResolver(), r2);     // Catch: Throwable -> L20
        if (r9 == null) goto L17;
        CloseableKt.closeFinally(r9, null);     // Catch: Throwable -> L20
    L18:
        Object r10 = Result.constructor-impl(Boxing.boxBoolean(r3));     // Catch: Throwable -> L20
    L22:
        Boolean r11 = Boxing.boxBoolean(false);
        if (Result.isFailure-impl(r10) == false) goto L25;
        r10 = r11;
    L25:
        r1 = ((Boolean) r10).booleanValue();
        goto L36
    L17:
        r3 = false;
    L20:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
    L36:
        return Boxing.boxBoolean(r1);
    L27:
        if (r7.equals(ShareType.FILE) == false) goto L36;
        String r13 = this.$uri.getPath();
        if (r13 == null) goto L36;
        if (new PolarisFileWrapper(r13).canRead() != true) goto L36;
        r1 = true;
        goto L36
    L34:
        r1 = new PolarisFileWrapper(this.$uri.toString()).canRead();
        goto L36
    L38:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    public static ParcelFileDescriptor a(ContentResolver r20, Uri r21) {
        ArrayList r1 = new ArrayList();
        Object[] r2 = {r21, "r"};
        f06.b r13 = new f06.b();
        g06.a r3 = (g06.a) ApiHookConfig.b.get(240020);
        if (r3 == null) goto L5;
        f06.a[] r4 = r3.i;
    L6:
        f06.a[] r10 = r4;
        int r9 = r10.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r10[r8];
        int r17 = r8;
        int r18 = r9;
        f06.a[] r19 = r10;
        d r5 = r7.preInvoke(240020, "android/content/ContentResolver", "openFileDescriptor", r20, r2, "android.os.ParcelFileDescriptor", r13);     // Catch: Exception -> L22
        if (r5.a == true) goto L17;
        r1.add(r7);     // Catch: Exception -> L22
    L17:
        if (r5.a == false) goto L21;
        return (ParcelFileDescriptor) r5.b;
    L21:
        return ContentResolverWrapper.openFileDescriptor(r20, r21, "r");
    L14:
        r8 = r17 + 1;
        r9 = r18;
        r10 = r19;
        goto L8
    L15:
        r5 = new d(false, null);
        goto L17
    L5:
        r4 = ApiHookConfig.d;
        goto L6
    }
}
