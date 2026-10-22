package com.obric.memorydata.migration.sdk.internal.net;

import android.util.Base64;
import androidx.exifinterface.media.ExifInterface;
import com.google.gson.Gson;
import com.obric.memorydata.migration.sdk.MigrationErrorCode;
import com.obric.memorydata.migration.sdk.internal.security.b;
import com.obric.memorydata.migration.sdk.o;
import com.obric.memorydata.migration.sdk.t;
import com.obric.memorydata.migration.sdk.z;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\n¨\u0006\u0004"}, d2 = {"<anonymous>", "Lcom/obric/memorydata/migration/sdk/MigrationResult;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;", "com/obric/memorydata/migration/sdk/internal/net/HandshakeProtocol$runHandshake$2"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.migration.sdk.internal.net.HandshakeProtocol$asReceiver$$inlined$runHandshake$1", f = "LanConnector.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class HandshakeProtocol$asReceiver$$inlined$runHandshake$1 extends SuspendLambda implements Function2<al, Continuation<? super z<? extends byte[]>>, Object> {
    final /* synthetic */ String $pairingCode$inlined;
    final /* synthetic */ String $protocolVersion$inlined;
    final /* synthetic */ String $role;
    final /* synthetic */ String $senderUidHash$inlined;
    final /* synthetic */ Socket $socket;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ HandshakeProtocol this$0;
    final /* synthetic */ HandshakeProtocol this$0$inline_fun;

    public HandshakeProtocol$asReceiver$$inlined$runHandshake$1(String r3, Socket r4, HandshakeProtocol r5, Continuation r6, String r7, HandshakeProtocol r8, String r9, String r10) {
        Continuation r11 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        this.$role = r3;
        this.$socket = r4;
        this.this$0$inline_fun = r5;
        this.$pairingCode$inlined = r7;
        this.this$0 = r8;
        this.$protocolVersion$inlined = r9;
        this.$senderUidHash$inlined = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r12, Continuation<?> r13) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r13, Continuation.class, "com.obric.memorydata.plugin");
        HandshakeProtocol$asReceiver$$inlined$runHandshake$1 r14 = new HandshakeProtocol$asReceiver$$inlined$runHandshake$1(this.$role, this.$socket, this.this$0$inline_fun, r6, this.$pairingCode$inlined, this.this$0, this.$protocolVersion$inlined, this.$senderUidHash$inlined);
        r14.L$0 = r12;
        return (Continuation) ZeusTransformUtils.preCheckCast(r14, Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super z<? extends byte[]>> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super z<? extends byte[]>> r4) {
        return ((HandshakeProtocol$asReceiver$$inlined$runHandshake$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), HandshakeProtocol$asReceiver$$inlined$runHandshake$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r19) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L76;
        ResultKt.throwOnFailure(r19);
        al r0 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
        long r6 = System.currentTimeMillis();
        t.f11981a.a("v1 handshake: " + this.$role + " begin, timeoutMs=15000");
        Socket r1 = this.$socket;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L7
        Object r2 = Result.m1421constructorimpl(Boxing.boxInt(r1.getSoTimeout()));     // Catch: Throwable -> L7
    L10:
        if (Result.m1427isFailureimpl(r2) == false) goto L12;
        r2 = null;
    L12:
        Integer r5 = (Integer) ZeusTransformUtils.preCheckCast(r2, Integer.class, "com.obric.memorydata.plugin");
        Socket r3 = this.$socket;
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L15
        r3.setSoTimeout(15000);     // Catch: Throwable -> L15
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L15
    L17:
        Socket r7 = this.$socket;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L42
        DataInputStream r11 = new DataInputStream(r7.getInputStream());     // Catch: Throwable -> L42
        DataOutputStream r12 = new DataOutputStream(r7.getOutputStream());     // Catch: Throwable -> L42
        byte[] r8 = b.f11954a.a(32);     // Catch: Throwable -> L42
        b r13 = b.f11954a;     // Catch: Throwable -> L42
        byte[] r14 = this.$pairingCode$inlined.getBytes(Charsets.UTF_8);     // Catch: Throwable -> L42
        Intrinsics.checkNotNullExpressionValue(r14, "getBytes(...)");     // Catch: Throwable -> L42
        byte[] r15 = r13.a(r14, r8);     // Catch: Throwable -> L42
        HandshakeProtocol r16 = this.this$0;     // Catch: Throwable -> L42
        Gson r17 = HandshakeProtocol.a(r16);     // Catch: Throwable -> L42
        String r18 = this.$protocolVersion$inlined;     // Catch: Throwable -> L42
        long r110 = r6;
        String r20 = Base64.encodeToString(r8, 2);     // Catch: Throwable -> L40
        Intrinsics.checkNotNullExpressionValue(r20, "encodeToString(...)");     // Catch: Throwable -> L40
        String r21 = Base64.encodeToString(r15, 2);     // Catch: Throwable -> L40
        Intrinsics.checkNotNullExpressionValue(r21, "encodeToString(...)");     // Catch: Throwable -> L40
        String r22 = r17.toJson(new HandshakeProtocol.Hello(r18, r20, r21));     // Catch: Throwable -> L40
        Intrinsics.checkNotNullExpressionValue(r22, "toJson(...)");     // Catch: Throwable -> L40
        HandshakeProtocol.a(r16, r12, r22);     // Catch: Throwable -> L40
        t.f11981a.a("v1 handshake: receiver hello sent, protocol=" + this.$protocolVersion$inlined);     // Catch: Throwable -> L40
        HandshakeProtocol.Ack r23 = (HandshakeProtocol.Ack) ZeusTransformUtils.preCheckCast(HandshakeProtocol.a(this.this$0).fromJson(HandshakeProtocol.a(this.this$0, r11), HandshakeProtocol.Ack.class), HandshakeProtocol.Ack.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L40
        HandshakeProtocol r24 = this.this$0;     // Catch: Throwable -> L40
        Intrinsics.checkNotNull(r23);     // Catch: Throwable -> L40
        z r25 = HandshakeProtocol.a(r24, r23);     // Catch: Throwable -> L40
        if (ZeusTransformUtils.instanceOf(r25, z.a.class) == false) goto L25;
        Object r26 = ZeusTransformUtils.preCheckCast(new z.a(((z.a) ZeusTransformUtils.preCheckCast(r25, z.a.class, "com.obric.memorydata.plugin")).a()), z.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L40
    L35:
        Object r27 = Result.m1421constructorimpl((z) r26);     // Catch: Throwable -> L40
    L45:
        HandshakeProtocol r28 = this.this$0$inline_fun;
        Throwable r29 = Result.m1424exceptionOrNullimpl(r27);
        if (r29 != null) goto L49;
    L59:
        z r30 = (z) ZeusTransformUtils.preCheckCast(r27, z.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L67;
        Socket r31 = this.$socket;
        Result.Companion r32 = Result.Companion;     // Catch: Throwable -> L64
        r31.setSoTimeout(r5.intValue());     // Catch: Throwable -> L64
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L64
    L64:
        th = move-exception;
        Result.Companion r33 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
    L67:
        if (ZeusTransformUtils.instanceOf(r30, z.b.class) == false) goto L70;
        t.f11981a.a("v1 handshake: " + this.$role + " success, costMs=" + (System.currentTimeMillis() - r110));
    L72:
        return r30;
    L70:
        if (ZeusTransformUtils.instanceOf(r30, z.a.class) == false) goto L74;
        t.f11981a.a("v1 handshake: " + this.$role + " failed, code=" + ((z.a) ZeusTransformUtils.preCheckCast(r30, z.a.class, "com.obric.memorydata.plugin")).a().a() + ", costMs=" + (System.currentTimeMillis() - r110), ((z.a) ZeusTransformUtils.preCheckCast(r30, z.a.class, "com.obric.memorydata.plugin")).a().c());
        goto L72
    L74:
        throw new NoWhenBranchMatchedException();
    L49:
        if (ZeusTransformUtils.instanceOf(r29, SocketTimeoutException.class) == false) goto L52;
    L50:
        MigrationErrorCode r34 = MigrationErrorCode.CONNECT_FAILED;
    L55:
        if (HandshakeProtocol$runHandshake$2.a.f11943a[r34.ordinal()] != 1) goto L57;
        StringBuilder r35 = new StringBuilder();
        String r36 = "连接断开: ";
    L58:
        r27 = (z) ZeusTransformUtils.preCheckCast(new z.a(new o(r34, r35.append(r36).append(r29.getMessage()).toString(), r29)), z.class, "com.obric.memorydata.plugin");
        goto L59
    L57:
        r35 = new StringBuilder();
        r36 = "握手失败: ";
        goto L58
    L52:
        if (HandshakeProtocol.a(r28, r29) == false) goto L50;
        r34 = MigrationErrorCode.DISCONNECTED;
        goto L55
    L25:
        if (ZeusTransformUtils.instanceOf(r25, z.b.class) == false) goto L39;
        t.f11981a.a("v1 handshake: receiver ack accepted");     // Catch: Throwable -> L40
        byte[] r37 = HandshakeProtocol.a(this.this$0, r23.getSenderNonceBase64(), "握手失败: 缺少 senderNonce");     // Catch: Throwable -> L40
        byte[] r38 = HandshakeProtocol.b(this.this$0, r23.getPairingProofBase64(), "握手失败: 缺少 pairingProof");     // Catch: Throwable -> L40
        b r39 = b.f11954a;     // Catch: Throwable -> L40
        byte[] r111 = this.$pairingCode$inlined.getBytes(Charsets.UTF_8);     // Catch: Throwable -> L40
        Intrinsics.checkNotNullExpressionValue(r111, "getBytes(...)");     // Catch: Throwable -> L40
        if (b.f11954a.b(r39.a(r111, r37), r38) == true) goto L29;
        r26 = ZeusTransformUtils.preCheckCast(new z.a(new o(MigrationErrorCode.CONNECT_FAILED, "配对码不一致", null, 4, null)), z.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L40
        goto L35
    L29:
        t.f11981a.a("v1 handshake: receiver pairing proof confirmed, start jpake");     // Catch: Throwable -> L40
        z<byte[]> r40 = com.obric.memorydata.migration.sdk.internal.security.a.f11953a.b(com.obric.memorydata.migration.sdk.internal.security.a.f11953a.a(this.$pairingCode$inlined, this.$senderUidHash$inlined, r8, r37), (Function1) ZeusTransformUtils.preCheckCast(new HandshakeProtocol.c(this.this$0, r12), Function1.class, "com.obric.memorydata.plugin"), (Function0) ZeusTransformUtils.preCheckCast(new HandshakeProtocol.b(this.this$0, r11), Function0.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L40
        if (ZeusTransformUtils.instanceOf(r40, z.b.class) == false) goto L33;
        r26 = ZeusTransformUtils.preCheckCast(new z.b(((z.b) ZeusTransformUtils.preCheckCast(r40, z.b.class, "com.obric.memorydata.plugin")).a()), z.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L40
        goto L35
    L33:
        if (ZeusTransformUtils.instanceOf(r40, z.a.class) == false) goto L37;
        r26 = ZeusTransformUtils.preCheckCast(new z.a(((z.a) ZeusTransformUtils.preCheckCast(r40, z.a.class, "com.obric.memorydata.plugin")).a()), z.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L40
        goto L35
    L37:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L40
    L39:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L40
    L40:
        th = th;
    L44:
        Result.Companion r41 = Result.Companion;
        r27 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L42:
        th = th;
        r110 = r6;
    L15:
        th = move-exception;
        Result.Companion r42 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
    L7:
        th = move-exception;
        Result.Companion r43 = Result.Companion;
        r2 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L10
    L76:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
