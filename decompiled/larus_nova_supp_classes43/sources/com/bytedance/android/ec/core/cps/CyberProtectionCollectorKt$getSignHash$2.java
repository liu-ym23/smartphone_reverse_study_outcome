package com.bytedance.android.ec.core.cps;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Build;
import com.bytedance.common.utility.DigestUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.ec.core.cps.CyberProtectionCollectorKt$getSignHash$2", f = "CyberProtectionCollector.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class CyberProtectionCollectorKt$getSignHash$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    int label;

    public CyberProtectionCollectorKt$getSignHash$2(Continuation r10) {
        super(2, r10);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r10) {
        Intrinsics.checkNotNullParameter(r10, "completion");
        return new CyberProtectionCollectorKt$getSignHash$2(r10);
    }

    public final Object invoke(Object r1, Object r10) {
        return create(r1, (Continuation) r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L36;
        ResultKt.throwOnFailure(r10);
        Context r11 = b.m();
        byte[] r0 = null;
        if (r11 == null) goto L37;
        PackageManager r1 = r11.getPackageManager();
        PackageInfo r12 = r1.getPackageInfo(r11.getPackageName(), 64);
        if (r12 == null) goto L15;
        Signature[] r13 = r12.signatures;
        if (r13 == null) goto L15;
        Signature r14 = (Signature) ArraysKt.firstOrNull(r13);
        if (r14 == null) goto L15;
        byte[] r15 = r14.toByteArray();
        if (r15 == null) goto L15;
        String r16 = DigestUtils.md5Hex(r15);
    L16:
        if (r16 != null) goto L18;
    L21:
        boolean r17 = true;
    L22:
        if (r17 == false) goto L34;
        if (Build.VERSION.SDK_INT < 28) goto L34;
        SigningInfo r18 = r1.getPackageInfo(r11.getPackageName(), 134217728).signingInfo;
        if (r18 == null) goto L38;
        Signature[] r19 = r18.getApkContentsSigners();
        if (r19 == null) goto L38;
        Signature r20 = (Signature) ArraysKt.firstOrNull(r19);
        if (r20 == null) goto L38;
        r0 = r20.toByteArray();
    L38:
        return DigestUtils.md5Hex(r0);
    L34:
        return r16;
    L18:
        if (StringsKt.isBlank(r16) == true) goto L21;
        r17 = false;
    L15:
        r16 = null;
        goto L16
    L37:
        return null;
    L36:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
