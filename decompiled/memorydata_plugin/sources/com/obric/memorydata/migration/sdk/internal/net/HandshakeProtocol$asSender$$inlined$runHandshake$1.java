package com.obric.memorydata.migration.sdk.internal.net;

import android.util.Base64;
import androidx.exifinterface.media.ExifInterface;
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
@DebugMetadata(c = "com.obric.memorydata.migration.sdk.internal.net.HandshakeProtocol$asSender$$inlined$runHandshake$1", f = "LanConnector.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class HandshakeProtocol$asSender$$inlined$runHandshake$1 extends SuspendLambda implements Function2<al, Continuation<? super z<? extends byte[]>>, Object> {
    final /* synthetic */ String $expectedPairingCode$inlined;
    final /* synthetic */ String $expectedProtocolVersion$inlined;
    final /* synthetic */ String $role;
    final /* synthetic */ String $senderUidHash$inlined;
    final /* synthetic */ Socket $socket;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ HandshakeProtocol this$0;
    final /* synthetic */ HandshakeProtocol this$0$inline_fun;

    public HandshakeProtocol$asSender$$inlined$runHandshake$1(String r3, Socket r4, HandshakeProtocol r5, Continuation r6, HandshakeProtocol r7, String r8, String r9, String r10) {
        Continuation r11 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        this.$role = r3;
        this.$socket = r4;
        this.this$0$inline_fun = r5;
        this.this$0 = r7;
        this.$expectedProtocolVersion$inlined = r8;
        this.$expectedPairingCode$inlined = r9;
        this.$senderUidHash$inlined = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r12, Continuation<?> r13) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r13, Continuation.class, "com.obric.memorydata.plugin");
        HandshakeProtocol$asSender$$inlined$runHandshake$1 r14 = new HandshakeProtocol$asSender$$inlined$runHandshake$1(this.$role, this.$socket, this.this$0$inline_fun, r6, this.this$0, this.$expectedProtocolVersion$inlined, this.$expectedPairingCode$inlined, this.$senderUidHash$inlined);
        r14.L$0 = r12;
        return (Continuation) ZeusTransformUtils.preCheckCast(r14, Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super z<? extends byte[]>> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super z<? extends byte[]>> r4) {
        return ((HandshakeProtocol$asSender$$inlined$runHandshake$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), HandshakeProtocol$asSender$$inlined$runHandshake$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r25) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L74;
        ResultKt.throwOnFailure(r25);
        al r0 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
        long r5 = System.currentTimeMillis();
        t.f11981a.a("v1 handshake: " + this.$role + " begin, timeoutMs=15000");
        Socket r1 = this.$socket;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L7
        Object r2 = Result.m1421constructorimpl(Boxing.boxInt(r1.getSoTimeout()));     // Catch: Throwable -> L7
    L10:
        if (Result.m1427isFailureimpl(r2) == false) goto L12;
        r2 = null;
    L12:
        Integer r4 = (Integer) ZeusTransformUtils.preCheckCast(r2, Integer.class, "com.obric.memorydata.plugin");
        Socket r6 = this.$socket;
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L15
        r6.setSoTimeout(15000);     // Catch: Throwable -> L15
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L15
    L17:
        Socket r7 = this.$socket;
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L40
        DataInputStream r10 = new DataInputStream(r7.getInputStream());     // Catch: Throwable -> L40
        DataOutputStream r11 = new DataOutputStream(r7.getOutputStream());     // Catch: Throwable -> L40
        HandshakeProtocol.Hello r12 = (HandshakeProtocol.Hello) ZeusTransformUtils.preCheckCast(HandshakeProtocol.a(this.this$0).fromJson(HandshakeProtocol.a(this.this$0, r10), HandshakeProtocol.Hello.class), HandshakeProtocol.Hello.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L40
        t.f11981a.a("v1 handshake: sender hello received, protocol=" + r12.getProtocolVersion());     // Catch: Throwable -> L40
        if (Intrinsics.areEqual(r12.getProtocolVersion(), this.$expectedProtocolVersion$inlined) == true) goto L23;
        o r13 = new o(MigrationErrorCode.OTHER, "协议版本不兼容", null, 4, null);     // Catch: Throwable -> L40
        HandshakeProtocol r14 = this.this$0;     // Catch: Throwable -> L40
        String r15 = HandshakeProtocol.a(r14).toJson(new HandshakeProtocol.Ack(false, r13.a().name(), r13.b(), null, null, 24, null));     // Catch: Throwable -> L40
        Intrinsics.checkNotNullExpressionValue(r15, "toJson(...)");     // Catch: Throwable -> L40
        HandshakeProtocol.a(r14, r11, r15);     // Catch: Throwable -> L40
        Object r16 = ZeusTransformUtils.preCheckCast(new z.a(r13), z.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L40
    L22:
        z r17 = (z) r16;     // Catch: Throwable -> L40
        long r22 = r5;
    L35:
        Object r18 = Result.m1421constructorimpl(r17);     // Catch: Throwable -> L36
    L43:
        HandshakeProtocol r19 = this.this$0$inline_fun;
        Throwable r20 = Result.m1424exceptionOrNullimpl(r18);
        if (r20 != null) goto L47;
    L57:
        z r21 = (z) ZeusTransformUtils.preCheckCast(r18, z.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L65;
        Socket r23 = this.$socket;
        Result.Companion r24 = Result.Companion;     // Catch: Throwable -> L62
        r23.setSoTimeout(r4.intValue());     // Catch: Throwable -> L62
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L62
    L62:
        th = move-exception;
        Result.Companion r26 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
    L65:
        if (ZeusTransformUtils.instanceOf(r21, z.b.class) == false) goto L68;
        t.f11981a.a("v1 handshake: " + this.$role + " success, costMs=" + (System.currentTimeMillis() - r22));
    L70:
        return r21;
    L68:
        if (ZeusTransformUtils.instanceOf(r21, z.a.class) == false) goto L72;
        t.f11981a.a("v1 handshake: " + this.$role + " failed, code=" + ((z.a) ZeusTransformUtils.preCheckCast(r21, z.a.class, "com.obric.memorydata.plugin")).a().a() + ", costMs=" + (System.currentTimeMillis() - r22), ((z.a) ZeusTransformUtils.preCheckCast(r21, z.a.class, "com.obric.memorydata.plugin")).a().c());
        goto L70
    L72:
        throw new NoWhenBranchMatchedException();
    L47:
        if (ZeusTransformUtils.instanceOf(r20, SocketTimeoutException.class) == false) goto L50;
    L48:
        MigrationErrorCode r27 = MigrationErrorCode.CONNECT_FAILED;
    L53:
        if (HandshakeProtocol$runHandshake$2.a.f11943a[r27.ordinal()] != 1) goto L55;
        StringBuilder r28 = new StringBuilder();
        String r29 = "连接断开: ";
    L56:
        r18 = (z) ZeusTransformUtils.preCheckCast(new z.a(new o(r27, r28.append(r29).append(r20.getMessage()).toString(), r20)), z.class, "com.obric.memorydata.plugin");
        goto L57
    L55:
        r28 = new StringBuilder();
        r29 = "握手失败: ";
        goto L56
    L50:
        if (HandshakeProtocol.a(r19, r20) == false) goto L48;
        r27 = MigrationErrorCode.DISCONNECTED;
        goto L53
    L23:
        byte[] r110 = HandshakeProtocol.a(this.this$0, r12.getReceiverNonceBase64(), "握手失败: 缺少 receiverNonce");     // Catch: Throwable -> L40
        byte[] r30 = HandshakeProtocol.b(this.this$0, r12.getPairingProofBase64(), "握手失败: 缺少 pairingProof");     // Catch: Throwable -> L40
        b r111 = b.f11954a;     // Catch: Throwable -> L40
        byte[] r112 = this.$expectedPairingCode$inlined.getBytes(Charsets.UTF_8);     // Catch: Throwable -> L40
        Intrinsics.checkNotNullExpressionValue(r112, "getBytes(...)");     // Catch: Throwable -> L40
        if (b.f11954a.b(r111.a(r112, r110), r30) == true) goto L26;
        o r31 = new o(MigrationErrorCode.CONNECT_FAILED, "配对码不一致", null, 4, null);     // Catch: Throwable -> L40
        HandshakeProtocol r32 = this.this$0;     // Catch: Throwable -> L40
        String r33 = HandshakeProtocol.a(r32).toJson(new HandshakeProtocol.Ack(false, r31.a().name(), r31.b(), null, null, 24, null));     // Catch: Throwable -> L40
        Intrinsics.checkNotNullExpressionValue(r33, "toJson(...)");     // Catch: Throwable -> L40
        HandshakeProtocol.a(r32, r11, r33);     // Catch: Throwable -> L40
        r16 = ZeusTransformUtils.preCheckCast(new z.a(r31), z.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L40
        goto L22
    L26:
        t.f11981a.a("v1 handshake: sender pairing proof confirmed");     // Catch: Throwable -> L40
        byte[] r34 = b.f11954a.a(32);     // Catch: Throwable -> L40
        b r113 = b.f11954a;     // Catch: Throwable -> L40
        byte[] r114 = this.$expectedPairingCode$inlined.getBytes(Charsets.UTF_8);     // Catch: Throwable -> L40
        Intrinsics.checkNotNullExpressionValue(r114, "getBytes(...)");     // Catch: Throwable -> L40
        byte[] r35 = r113.a(r114, r34);     // Catch: Throwable -> L40
        HandshakeProtocol r115 = this.this$0;     // Catch: Throwable -> L40
        r22 = r5;
        String r36 = HandshakeProtocol.a(r115).toJson(new HandshakeProtocol.Ack(true, null, null, Base64.encodeToString(r34, 2), Base64.encodeToString(r35, 2), 6, null));     // Catch: Throwable -> L36
        Intrinsics.checkNotNullExpressionValue(r36, "toJson(...)");     // Catch: Throwable -> L36
        HandshakeProtocol.a(r115, r11, r36);     // Catch: Throwable -> L36
        t.f11981a.a("v1 handshake: sender ack sent, start jpake");     // Catch: Throwable -> L36
        z<byte[]> r37 = com.obric.memorydata.migration.sdk.internal.security.a.f11953a.a(com.obric.memorydata.migration.sdk.internal.security.a.f11953a.a(this.$expectedPairingCode$inlined, this.$senderUidHash$inlined, r110, r34), (Function1) ZeusTransformUtils.preCheckCast(new HandshakeProtocol.e(this.this$0, r11), Function1.class, "com.obric.memorydata.plugin"), (Function0) ZeusTransformUtils.preCheckCast(new HandshakeProtocol.d(this.this$0, r10), Function0.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L36
        if (ZeusTransformUtils.instanceOf(r37, z.b.class) == false) goto L33;
        Object r38 = ZeusTransformUtils.preCheckCast(new z.b(((z.b) ZeusTransformUtils.preCheckCast(r37, z.b.class, "com.obric.memorydata.plugin")).a()), z.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L36
    L31:
        r17 = (z) r38;     // Catch: Throwable -> L36
        goto L35
    L33:
        if (ZeusTransformUtils.instanceOf(r37, z.a.class) == false) goto L39;
        r38 = ZeusTransformUtils.preCheckCast(new z.a(((z.a) ZeusTransformUtils.preCheckCast(r37, z.a.class, "com.obric.memorydata.plugin")).a()), z.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L36
        goto L31
    L39:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L36
    L36:
        th = th;
    L42:
        Result.Companion r39 = Result.Companion;
        r18 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L40:
        th = th;
        r22 = r5;
    L15:
        th = move-exception;
        Result.Companion r40 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
    L7:
        th = move-exception;
        Result.Companion r41 = Result.Companion;
        r2 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L10
    L74:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
