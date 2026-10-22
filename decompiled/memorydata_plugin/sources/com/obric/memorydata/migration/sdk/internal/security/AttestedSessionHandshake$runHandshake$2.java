package com.obric.memorydata.migration.sdk.internal.security;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.crypto.e2eetrans.CryptoException;
import com.obric.memorydata.migration.sdk.MigrationErrorCode;
import com.obric.memorydata.migration.sdk.o;
import com.obric.memorydata.migration.sdk.t;
import com.obric.memorydata.migration.sdk.z;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/obric/memorydata/migration/sdk/MigrationResult;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.migration.sdk.internal.security.AttestedSessionHandshake$runHandshake$2", f = "AttestedSessionHandshake.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AttestedSessionHandshake$runHandshake$2<T> extends SuspendLambda implements Function2<al, Continuation<? super z<? extends T>>, Object> {
    final /* synthetic */ Function2<DataInputStream, DataOutputStream, z<T>> $block;
    final /* synthetic */ String $role;
    final /* synthetic */ Socket $socket;
    private /* synthetic */ Object L$0;
    int label;

    public AttestedSessionHandshake$runHandshake$2(Function2<? super DataInputStream, ? super DataOutputStream, ? extends z<? extends T>> r3, Socket r4, String r5, Continuation<? super AttestedSessionHandshake$runHandshake$2> r6) {
        Function2<DataInputStream, DataOutputStream, z<T>> r7 = (Function2) ZeusTransformUtils.wrapperContextForParams(r3, Function2.class, "com.obric.memorydata.plugin");
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        this.$block = r7;
        this.$socket = r4;
        this.$role = r5;
        super(2, r8);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        AttestedSessionHandshake$runHandshake$2 r0 = new AttestedSessionHandshake$runHandshake$2(this.$block, this.$socket, this.$role, r7);
        r0.L$0 = r5;
        return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Object r4) {
        return invoke((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public final Object invoke(al r3, Continuation<? super z<? extends T>> r4) {
        return ((AttestedSessionHandshake$runHandshake$2) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AttestedSessionHandshake$runHandshake$2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r11) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L66;
        ResultKt.throwOnFailure(r11);
        al r12 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
        long r2 = System.currentTimeMillis();
        Socket r13 = this.$socket;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L7
        Object r14 = Result.m1421constructorimpl(Boxing.boxInt(r13.getSoTimeout()));     // Catch: Throwable -> L7
    L9:
        AttestedSessionHandshake.StageException r4 = null;
        if (Result.m1427isFailureimpl(r14) == false) goto L12;
        r14 = null;
    L12:
        Integer r15 = (Integer) ZeusTransformUtils.preCheckCast(r14, Integer.class, "com.obric.memorydata.plugin");
        Socket r1 = this.$socket;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L15
        r1.setSoTimeout(LocationInfoConst.HALF_MINUTES);     // Catch: Throwable -> L15
        Object r3 = Unit.INSTANCE;     // Catch: Throwable -> L15
        Result.m1421constructorimpl(r3);     // Catch: Throwable -> L15
    L67:
        r3 = (z) ZeusTransformUtils.preCheckCast(this.$block.invoke(new DataInputStream(this.$socket.getInputStream()), new DataOutputStream(this.$socket.getOutputStream())), z.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L24
        if (r15 == null) goto L56;
        Socket r10 = this.$socket;
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L22
        r10.setSoTimeout(r15.intValue());     // Catch: Throwable -> L22
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L22
    L56:
        return r3;
    L24:
        th = th;
    L57:
        th = move-exception;
        if (r15 == null) goto L64;
        Socket r16 = this.$socket;
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L62
        r16.setSoTimeout(r15.intValue());     // Catch: Throwable -> L62
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L62
    L62:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
    L64:
        throw th;
    L26:
        if (ZeusTransformUtils.instanceOf(th, AttestedSessionHandshake.StageException.class) == false) goto L28;
        AttestedSessionHandshake.StageException r8 = (AttestedSessionHandshake.StageException) ZeusTransformUtils.preCheckCast(th, AttestedSessionHandshake.StageException.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L57
    L29:
        if (r8 == null) goto L32;
        String r9 = r8.getStage();     // Catch: Throwable -> L57
        if (r9 == null) goto L32;
    L34:
        if (ZeusTransformUtils.instanceOf(th, AttestedSessionHandshake.StageException.class) == false) goto L36;
        r4 = (AttestedSessionHandshake.StageException) ZeusTransformUtils.preCheckCast(th, AttestedSessionHandshake.StageException.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L57
    L36:
        if (r4 == null) goto L41;
        Throwable r18 = r4.getCause();     // Catch: Throwable -> L57
        if (r18 == null) goto L41;
        th = r18;
    L41:
        CryptoException r19 = AttestedSessionHandshake.a(AttestedSessionHandshake.f11950a, th);     // Catch: Throwable -> L57
        if (r19 == null) goto L47;
        CryptoException.Code r20 = r19.code;     // Catch: Throwable -> L57
        if (r20 == null) goto L47;
        String r21 = r20.name();     // Catch: Throwable -> L57
        if (r21 == null) goto L47;
    L49:
        if (ZeusTransformUtils.instanceOf(th, SocketTimeoutException.class) == false) goto L51;
        String r22 = "安全握手超时";
    L52:
        t.f11981a.a("v2 handshake: " + this.$role + " failed, stage=" + r9 + ", sdkCode=" + r21 + ", costMs=" + (System.currentTimeMillis() - r2), th);     // Catch: Throwable -> L57
        r3 = (z) ZeusTransformUtils.preCheckCast(new z.a(new o(MigrationErrorCode.CONNECT_FAILED, r22, th)), z.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L57
        if (r15 == null) goto L56;
        Socket r110 = this.$socket;
        Result.Companion r23 = Result.Companion;     // Catch: Throwable -> L22
        r110.setSoTimeout(r15.intValue());     // Catch: Throwable -> L22
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L22
        goto L56
    L51:
        r22 = "安全握手失败: " + th.getMessage();     // Catch: Throwable -> L57
    L47:
        r21 = "none";
    L32:
        r9 = "open_socket_stream";
        goto L34
    L28:
        r8 = null;
    L22:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
    L15:
        th = move-exception;
        Result.Companion r24 = Result.Companion;
        r3 = ResultKt.createFailure(th);
        Result.m1421constructorimpl(r3);
    L7:
        th = move-exception;
        Result.Companion r25 = Result.Companion;
        r14 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L9
    L66:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    public final Object invokeSuspend$$forInline(Object r12) {
        al r13 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
        long r2 = System.currentTimeMillis();
        Socket r0 = this.$socket;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L5
        al r5 = (al) ZeusTransformUtils.preCheckCast(r13, al.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
        Object r1 = Result.m1421constructorimpl(Integer.valueOf(r0.getSoTimeout()));     // Catch: Throwable -> L5
    L7:
        AttestedSessionHandshake.StageException r6 = null;
        if (Result.m1427isFailureimpl(r1) == false) goto L10;
        r1 = null;
    L10:
        Integer r3 = (Integer) ZeusTransformUtils.preCheckCast(r1, Integer.class, "com.obric.memorydata.plugin");
        Socket r7 = this.$socket;
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L13
        al r9 = (al) ZeusTransformUtils.preCheckCast(r13, al.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
        r7.setSoTimeout(LocationInfoConst.HALF_MINUTES);     // Catch: Throwable -> L13
        Object r10 = Unit.INSTANCE;     // Catch: Throwable -> L13
        Result.m1421constructorimpl(r10);     // Catch: Throwable -> L13
    L66:
        r10 = (z) ZeusTransformUtils.preCheckCast(this.$block.invoke(new DataInputStream(this.$socket.getInputStream()), new DataOutputStream(this.$socket.getOutputStream())), z.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22
        if (r3 == null) goto L55;
        Socket r11 = this.$socket;
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L20
        al r15 = (al) ZeusTransformUtils.preCheckCast(r13, al.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
        r11.setSoTimeout(r3.intValue());     // Catch: Throwable -> L20
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L20
    L55:
        return r10;
    L22:
        th = th;
    L56:
        th = move-exception;
        if (r3 == null) goto L63;
        Socket r16 = this.$socket;
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L61
        al r18 = (al) ZeusTransformUtils.preCheckCast(r13, al.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L61
        r16.setSoTimeout(r3.intValue());     // Catch: Throwable -> L61
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L61
    L61:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
    L63:
        throw th;
    L24:
        if (ZeusTransformUtils.instanceOf(th, AttestedSessionHandshake.StageException.class) == false) goto L26;
        AttestedSessionHandshake.StageException r20 = (AttestedSessionHandshake.StageException) ZeusTransformUtils.preCheckCast(th, AttestedSessionHandshake.StageException.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L56
    L27:
        if (r20 == null) goto L31;
        String r21 = r20.getStage();     // Catch: Throwable -> L56
        if (r21 == null) goto L31;
    L33:
        if (ZeusTransformUtils.instanceOf(th, AttestedSessionHandshake.StageException.class) == false) goto L35;
        r6 = (AttestedSessionHandshake.StageException) ZeusTransformUtils.preCheckCast(th, AttestedSessionHandshake.StageException.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L56
    L35:
        if (r6 == null) goto L39;
        Throwable r22 = r6.getCause();     // Catch: Throwable -> L56
        if (r22 == null) goto L39;
        th = r22;
    L39:
        CryptoException r23 = AttestedSessionHandshake.a(AttestedSessionHandshake.f11950a, th);     // Catch: Throwable -> L56
        if (r23 == null) goto L46;
        CryptoException.Code r24 = r23.code;     // Catch: Throwable -> L56
        if (r24 == null) goto L46;
        String r25 = r24.name();     // Catch: Throwable -> L56
        if (r25 == null) goto L46;
    L48:
        if (ZeusTransformUtils.instanceOf(th, SocketTimeoutException.class) == false) goto L50;
        String r26 = "安全握手超时";
    L51:
        t.f11981a.a("v2 handshake: " + this.$role + " failed, stage=" + r21 + ", sdkCode=" + r25 + ", costMs=" + (System.currentTimeMillis() - r2), th);     // Catch: Throwable -> L56
        r10 = (z) ZeusTransformUtils.preCheckCast(new z.a(new o(MigrationErrorCode.CONNECT_FAILED, r26, th)), z.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L56
        if (r3 == null) goto L55;
        Socket r110 = this.$socket;
        Result.Companion r27 = Result.Companion;     // Catch: Throwable -> L20
        al r111 = (al) ZeusTransformUtils.preCheckCast(r13, al.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
        r110.setSoTimeout(r3.intValue());     // Catch: Throwable -> L20
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L20
        goto L55
    L50:
        r26 = "安全握手失败: " + th.getMessage();     // Catch: Throwable -> L56
    L46:
        r25 = "none";
    L31:
        r21 = "open_socket_stream";
        goto L33
    L26:
        r20 = null;
    L20:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
    L13:
        th = move-exception;
        Result.Companion r28 = Result.Companion;
        r10 = ResultKt.createFailure(th);
        Result.m1421constructorimpl(r10);
    L5:
        th = move-exception;
        Result.Companion r29 = Result.Companion;
        r1 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L7
    }
}
