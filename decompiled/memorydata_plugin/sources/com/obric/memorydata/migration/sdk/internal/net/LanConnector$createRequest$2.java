package com.obric.memorydata.migration.sdk.internal.net;

import android.util.Base64;
import com.bytedance.crypto.utils.CryptoConst;
import com.obric.memorydata.migration.sdk.MigrationErrorCode;
import com.obric.memorydata.migration.sdk.QrPayload;
import com.obric.memorydata.migration.sdk.d;
import com.obric.memorydata.migration.sdk.f;
import com.obric.memorydata.migration.sdk.internal.security.b;
import com.obric.memorydata.migration.sdk.o;
import com.obric.memorydata.migration.sdk.t;
import com.obric.memorydata.migration.sdk.z;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.ServerSocket;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/obric/memorydata/migration/sdk/MigrationResult;", "Lcom/obric/memorydata/migration/sdk/ConnectRequest;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.migration.sdk.internal.net.LanConnector$createRequest$2", f = "LanConnector.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class LanConnector$createRequest$2 extends SuspendLambda implements Function2<al, Continuation<? super z<? extends d>>, Object> {
    final /* synthetic */ f $params;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ a this$0;

    LanConnector$createRequest$2(a r3, f r4, Continuation<? super LanConnector$createRequest$2> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        this.$params = r4;
        super(2, r6);
    }

    private static final CharSequence invokeSuspend$lambda$2$lambda$1(byte r3) {
        String r4 = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(r3)}, 1));
        Intrinsics.checkNotNullExpressionValue(r4, "format(...)");
        return (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin");
    }

    public static /* synthetic */ CharSequence lambda$i5yXl_qy2nK6kv41YQjyoAzQTQU(byte r0) {
        return invokeSuspend$lambda$2$lambda$1(r0);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        LanConnector$createRequest$2 r0 = new LanConnector$createRequest$2(this.this$0, this.$params, r6);
        r0.L$0 = r4;
        return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super z<? extends d>> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super z<d>> r4) {
        return ((LanConnector$createRequest$2) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), LanConnector$createRequest$2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r26) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L23;
        ResultKt.throwOnFailure(r26);
        al r1 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
        a r2 = this.this$0;
        f r0 = this.$params;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L15
        ServerSocket r4 = new ServerSocket(0);     // Catch: Throwable -> L15
        List r15 = a.a(r2);     // Catch: Throwable -> L15
        byte[] r5 = new byte[16];     // Catch: Throwable -> L15
        new SecureRandom().nextBytes(r5);     // Catch: Throwable -> L15
        MessageDigest r6 = MessageDigest.getInstance(CryptoConst.ALGORITHM_SHA256);     // Catch: Throwable -> L15
        byte[] r7 = r0.a().getBytes(Charsets.UTF_8);     // Catch: Throwable -> L15
        Intrinsics.checkNotNullExpressionValue(r7, "getBytes(...)");     // Catch: Throwable -> L15
        byte[] r8 = r6.digest(ArraysKt.plus(r5, r7));     // Catch: Throwable -> L15
        Intrinsics.checkNotNullExpressionValue(r8, "digest(...)");     // Catch: Throwable -> L15
        String r9 = ArraysKt.joinToString$default(r8, (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, $$Lambda$LanConnector$createRequest$2$i5yXl_qy2nK6kv41YQjyoAzQTQU.INSTANCE, 30, null);     // Catch: Throwable -> L15
        String r10 = r0.c();     // Catch: Throwable -> L15
        String r11 = Base64.encodeToString(r5, 2);     // Catch: Throwable -> L15
        long r12 = r0.b();     // Catch: Throwable -> L15
        int r13 = r4.getLocalPort();     // Catch: Throwable -> L15
        String r14 = a.b(r2);     // Catch: Throwable -> L15
        if (Intrinsics.areEqual(r0.c(), "1") == false) goto L8;
        String r16 = b.f11954a.c();     // Catch: Throwable -> L15
    L9:
        QrPayload r17 = new QrPayload(r10, r9, r11, r12, r13, r14, r16, r0.d(), r15);     // Catch: Throwable -> L15
        t r18 = t.f11981a;     // Catch: Throwable -> L15
        StringBuilder r19 = new StringBuilder().append("lan: request created, protocol=").append(r0.c()).append(", port=").append(r4.getLocalPort()).append(", endpointCount=").append(r15.size()).append(", networkAvailable=");     // Catch: Throwable -> L15
        if (((Collection) ZeusTransformUtils.preCheckCast(r15, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == true) goto L12;
        boolean r20 = true;
    L13:
        r18.a(r19.append(r20).toString());     // Catch: Throwable -> L15
        Object r21 = Result.m1421constructorimpl(new z.b(new d(r17, r4)));     // Catch: Throwable -> L15
    L17:
        Throwable r22 = Result.m1424exceptionOrNullimpl(r21);
        if (r22 == null) goto L26;
        t.f11981a.a("lan: create request failed", r22);
        return (z) ZeusTransformUtils.preCheckCast(new z.a(new o(MigrationErrorCode.OTHER, "创建迁移服务失败: " + r22.getMessage(), r22)), z.class, "com.obric.memorydata.plugin");
    L26:
        return r21;
    L12:
        r20 = false;
        goto L13
    L8:
        r16 = null;
    L15:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        r21 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L17
    L23:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
