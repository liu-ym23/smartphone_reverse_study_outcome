package com.larus.uaigc.helper;

import android.net.Uri;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.chat.bean.ProcessFileResultCode;
import com.larus.bmhome.utils.ImFileUtil;
import com.larus.common.apphost.AppHost;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.helper.CreationImageUploadPolicy$reusePreprocessResult$1", f = "CreationImageUploadPolicy.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class CreationImageUploadPolicy$reusePreprocessResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ns8.a $compressConfig;
    final /* synthetic */ ic8.n0 $processResult;
    final /* synthetic */ CreationImageUploadPolicy.b $reusablePreprocessResult;
    final /* synthetic */ Uri $uri;
    int label;

    public CreationImageUploadPolicy$reusePreprocessResult$1(CreationImageUploadPolicy.b r1, Uri r2, ns8.a r3, ic8.n0 r4, Continuation<? super CreationImageUploadPolicy$reusePreprocessResult$1> r5) {
        this.$reusablePreprocessResult = r1;
        this.$uri = r2;
        this.$compressConfig = r3;
        this.$processResult = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new CreationImageUploadPolicy$reusePreprocessResult$1(this.$reusablePreprocessResult, this.$uri, this.$compressConfig, this.$processResult, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L53;
        ResultKt.throwOnFailure(r14);
        CreationImageUploadPolicy.b r15 = this.$reusablePreprocessResult;
        String r0 = "";
        String r1 = null;
        if (r15 == null) goto L24;
        m r2 = m.a;
        Uri r3 = this.$uri;
        Long r4 = Boxing.boxLong(r15.b);
        ns8.a r16 = this.$compressConfig;
        if (r16 == null) goto L9;
        Integer r17 = Boxing.boxInt(r16.hashCode());
    L10:
        String r5 = String.valueOf(r17);
        String r6 = this.$reusablePreprocessResult.c;
        ic8.n0 r18 = this.$processResult;
        ic8.m0 r7 = r18.a;
        if (r7 == null) goto L13;
        String r8 = r7.e;
    L14:
        if (r8 == null) goto L17;
        r0 = r8;
    L17:
        if (r7 == null) goto L19;
        String r9 = r7.d;
    L20:
        ProcessFileResultCode r19 = r18.b;
        if (r19 == null) goto L23;
        r1 = r19.getValue();
    L23:
        r2.g(r3, r4, r5, r6, r0, r9, r1);
    L51:
        return Unit.INSTANCE;
    L19:
        r9 = null;
        goto L20
    L13:
        r8 = null;
        goto L14
    L9:
        r17 = null;
        goto L10
    L24:
        String r110 = vqc.d.d(AppHost.a.getApplication(), this.$uri);
        if (r110 == null) goto L27;
        PolarisFileWrapper r10 = new PolarisFileWrapper(r110);
        long r11 = r10.length();
        ImFileUtil.a.getClass();
        String r111 = ImFileUtil.g(r10);
        if (r111 != null) goto L31;
        String r12 = "";
    L32:
        m r13 = m.a;
        Uri r20 = this.$uri;
        Long r21 = Boxing.boxLong(r11);
        ns8.a r112 = this.$compressConfig;
        if (r112 == null) goto L35;
        Integer r113 = Boxing.boxInt(r112.hashCode());
    L36:
        String r22 = String.valueOf(r113);
        ic8.n0 r114 = this.$processResult;
        ic8.m0 r23 = r114.a;
        if (r23 == null) goto L39;
        String r24 = r23.e;
    L40:
        if (r24 != null) goto L42;
        String r115 = "";
    L43:
        if (r23 == null) goto L45;
        String r116 = r23.d;
    L46:
        ProcessFileResultCode r117 = r114.b;
        if (r117 == null) goto L49;
        r1 = r117.getValue();
    L49:
        r13.g(r20, r21, r22, r12, r115, r116, r1);
        goto L51
    L45:
        r116 = null;
        goto L46
    L42:
        r115 = r24;
        goto L43
    L39:
        r24 = null;
        goto L40
    L35:
        r113 = null;
        goto L36
    L31:
        r12 = r111;
        goto L32
    L27:
        return Unit.INSTANCE;
    L53:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
