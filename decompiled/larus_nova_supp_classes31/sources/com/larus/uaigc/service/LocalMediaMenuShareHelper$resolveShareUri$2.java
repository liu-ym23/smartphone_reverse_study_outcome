package com.larus.uaigc.service;

import android.content.Context;
import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/net/Uri;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.service.LocalMediaMenuShareHelper$resolveShareUri$2", f = "LocalMediaMenuShareHelper.kt", i = {}, l = {76}, m = "invokeSuspend", n = {}, s = {})
final class LocalMediaMenuShareHelper$resolveShareUri$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Uri>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ boolean $preferPublicDownload;
    final /* synthetic */ String $rawSource;
    int label;

    public LocalMediaMenuShareHelper$resolveShareUri$2(String r1, Context r2, boolean r3, Continuation<? super LocalMediaMenuShareHelper$resolveShareUri$2> r4) {
        this.$rawSource = r1;
        this.$context = r2;
        this.$preferPublicDownload = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new LocalMediaMenuShareHelper$resolveShareUri$2(this.$rawSource, this.$context, this.$preferPublicDownload, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Uri> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r8);
    L30:
        return r8;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        u r9 = u.a;
        String r2 = this.$rawSource;
        r9.getClass();
        if (r2 != null) goto L11;
    L24:
        Uri r3 = null;
    L25:
        if (r3 != null) goto L27;
        return null;
    L27:
        Context r4 = this.$context;
        boolean r5 = this.$preferPublicDownload;
        this.label = 1;
        r8 = u.a(r9, r4, r3, r5, this);
        if (r8 != r0) goto L30;
        return r0;
    L11:
        if ((!StringsKt.isBlank(r2)) == true) goto L14;
        r2 = null;
    L14:
        if (r2 == null) goto L24;
        if (StringsKt.startsWith$default(r2, "/", false, 2, null) == false) goto L20;
        r3 = Uri.fromFile(new PolarisFileWrapper(r2));
        goto L25
    L20:
        if (StringsKt.startsWith$default(r2, "file://", false, 2, null) == false) goto L22;
    L23:
        r3 = UriProtector.parse(r2);
        goto L25
    L22:
        if (StringsKt.startsWith$default(r2, "content://", false, 2, null) == false) goto L24;
        goto L23
    }
}
