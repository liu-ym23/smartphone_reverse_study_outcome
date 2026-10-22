package com.obric.memorydata.migration.sdk.internal.security;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.crypto.e2eetrans.CryptoException;
import com.bytedance.crypto.e2eetrans.CryptoSession;
import com.bytedance.crypto.e2eetrans.CryptoSessionManager;
import com.bytedance.crypto.e2eetrans.IAttestationService;
import com.bytedance.crypto.e2eetrans.KeyManagerAttestationService;
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
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\n¨\u0006\u0004"}, d2 = {"<anonymous>", "Lcom/obric/memorydata/migration/sdk/MigrationResult;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;", "com/obric/memorydata/migration/sdk/internal/security/AttestedSessionHandshake$runHandshake$2"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.migration.sdk.internal.security.AttestedSessionHandshake$asInitiator$$inlined$runHandshake$1", f = "AttestedSessionHandshake.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AttestedSessionHandshake$asInitiator$$inlined$runHandshake$1 extends SuspendLambda implements Function2<al, Continuation<? super z<? extends AttestedSessionHandshake.a>>, Object> {
    final /* synthetic */ String $accountId$inlined;
    final /* synthetic */ Context $context$inlined;
    final /* synthetic */ String $role;
    final /* synthetic */ Socket $socket;
    private /* synthetic */ Object L$0;
    int label;

    public AttestedSessionHandshake$asInitiator$$inlined$runHandshake$1(Socket r3, String r4, Continuation r5, Context r6, String r7) {
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        this.$socket = r3;
        this.$role = r4;
        this.$context$inlined = ZeusTransformUtils.wrapperContext(r9, "com.obric.memorydata.plugin");
        this.$accountId$inlined = r7;
        super(2, r8);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
        AttestedSessionHandshake$asInitiator$$inlined$runHandshake$1 r11 = new AttestedSessionHandshake$asInitiator$$inlined$runHandshake$1(this.$socket, this.$role, r5, this.$context$inlined, this.$accountId$inlined);
        r11.L$0 = r9;
        return (Continuation) ZeusTransformUtils.preCheckCast(r11, Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super z<? extends AttestedSessionHandshake.a>> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super z<? extends AttestedSessionHandshake.a>> r4) {
        return ((AttestedSessionHandshake$asInitiator$$inlined$runHandshake$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AttestedSessionHandshake$asInitiator$$inlined$runHandshake$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r20) {
        Object r3 = "com.obric.memorydata.migration";
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L116;
        ResultKt.throwOnFailure(r20);
        al r0 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
        long r6 = System.currentTimeMillis();
        Socket r1 = this.$socket;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L7
        Object r2 = Result.m1421constructorimpl(Boxing.boxInt(r1.getSoTimeout()));     // Catch: Throwable -> L7
    L10:
        if (Result.m1427isFailureimpl(r2) == false) goto L12;
        r2 = null;
    L12:
        Integer r5 = (Integer) ZeusTransformUtils.preCheckCast(r2, Integer.class, "com.obric.memorydata.plugin");
        Socket r7 = this.$socket;
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L15
        r7.setSoTimeout(LocationInfoConst.HALF_MINUTES);     // Catch: Throwable -> L15
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L15
    L123:
        DataInputStream r8 = new DataInputStream(this.$socket.getInputStream());     // Catch: Throwable -> L72
        DataOutputStream r10 = new DataOutputStream(this.$socket.getOutputStream());     // Catch: Throwable -> L72
        long r11 = System.currentTimeMillis();     // Catch: Throwable -> L72
        String r12 = "create_attestation_service";
        t.f11981a.a("v2 handshake: initiator begin");     // Catch: Throwable -> L72
        KeyManagerAttestationService r13 = AttestedSessionHandshake.a(AttestedSessionHandshake.f11950a, this.$context$inlined, "sender");     // Catch: Throwable -> L63
        t.f11981a.a("v2 handshake: initiator attestation service ready");     // Catch: Throwable -> L61
        r12 = "create_crypto_session";
        CryptoSession r14 = CryptoSessionManager.createInitiatorSession(this.$accountId$inlined, "com.obric.memorydata.migration", (IAttestationService) ZeusTransformUtils.preCheckCast(r13, IAttestationService.class, "com.obric.memorydata.plugin"), 600000);     // Catch: Throwable -> L61
        t.f11981a.a("v2 handshake: initiator crypto session created");     // Catch: Throwable -> L58
        r12 = "send_initiator_auth";
        byte[] r15 = r14.getAuthMessage();     // Catch: Throwable -> L56
        AttestedSessionHandshake r16 = AttestedSessionHandshake.f11950a;     // Catch: Throwable -> L56
        Intrinsics.checkNotNull(r15);     // Catch: Throwable -> L56
        String r17 = "send_initiator_auth";
        AttestedSessionHandshake.a(r16, r10, 1, r15);     // Catch: Throwable -> L53
        KeyManagerAttestationService r18 = r13;
        t.f11981a.a("v2 handshake: initiator auth sent, bytes=" + r15.length);     // Catch: Throwable -> L51
        String r19 = "receive_responder_auth";
        byte[] r110 = AttestedSessionHandshake.a(AttestedSessionHandshake.f11950a, r8, 2);     // Catch: Throwable -> L49
        t.f11981a.a("v2 handshake: responder auth received, bytes=" + r110.length);     // Catch: Throwable -> L51
        r19 = "receive_responder_finish";
        byte[] r21 = AttestedSessionHandshake.a(AttestedSessionHandshake.f11950a, r8, 3);     // Catch: Throwable -> L49
        r17 = "receive_responder_finish";
        t.f11981a.a("v2 handshake: responder finish received, bytes=" + r21.length);     // Catch: Throwable -> L51
        String r22 = "verify_responder_auth";
        byte[] r111 = r14.processAuthMessage(r110);     // Catch: Throwable -> L47
        t.f11981a.a("v2 handshake: responder attestation verified");     // Catch: Throwable -> L47
        r14.confirmHandshake(r21);     // Catch: Throwable -> L47
        t.f11981a.a("v2 handshake: responder finish confirmed");     // Catch: Throwable -> L47
        AttestedSessionHandshake r23 = AttestedSessionHandshake.f11950a;     // Catch: Throwable -> L47
        Intrinsics.checkNotNull(r111);     // Catch: Throwable -> L47
        AttestedSessionHandshake.a(r23, r10, 4, r111);     // Catch: Throwable -> L47
        t.f11981a.a("v2 handshake: initiator finish sent, bytes=" + r111.length);     // Catch: Throwable -> L47
        r22 = "wrap_archive_key";
        byte[] r112 = b.f11954a.a(32);     // Catch: Throwable -> L47
        byte[] r24 = r14.encrypt(r112, "com.obric.memorydata.migration", "nearby_migration_archive_key", 1);     // Catch: Throwable -> L44
        AttestedSessionHandshake r25 = AttestedSessionHandshake.f11950a;     // Catch: Throwable -> L42
        Intrinsics.checkNotNull(r24);     // Catch: Throwable -> L42
        AttestedSessionHandshake.a(r25, r10, 5, r24);     // Catch: Throwable -> L42
        t.f11981a.a("v2 handshake: initiator success, archiveKeyEnvelopeBytes=" + r24.length + ", costMs=" + (System.currentTimeMillis() - r11));     // Catch: Throwable -> L42
        Intrinsics.checkNotNull(r14);     // Catch: Throwable -> L42
        r3 = (z) ZeusTransformUtils.preCheckCast(new z.b(new AttestedSessionHandshake.a(r14, r112)), z.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L72
        if (r5 == null) goto L105;
        Socket r26 = this.$socket;
        Result.Companion r27 = Result.Companion;     // Catch: Throwable -> L40
        r26.setSoTimeout(r5.intValue());     // Catch: Throwable -> L40
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L40
    L105:
        return r3;
    L42:
        th = move-exception;
        r12 = "send_archive_key";
        Throwable r28 = th;
    L46:
        KeyManagerAttestationService r29 = r18;
    L67:
        if (r112 != null) goto L69;
    L70:
        AttestedSessionHandshake.a(AttestedSessionHandshake.f11950a, r14, r29);     // Catch: Throwable -> L72
        throw new AttestedSessionHandshake.StageException(r12, r28);     // Catch: Throwable -> L72
    L69:
        ArraysKt.fill$default(r112, (byte) 0, 0, 0, 6, null);     // Catch: Throwable -> L72
    L44:
        th = move-exception;
        r28 = th;
        r12 = "wrap_archive_key";
    L47:
        th = move-exception;
        r28 = th;
        r12 = r22;
    L60:
        r29 = r18;
    L66:
        r112 = null;
    L49:
        th = th;
        r17 = r19;
    L55:
        r28 = th;
        r12 = r17;
    L51:
        th = th;
    L53:
        th = th;
        r18 = r13;
    L56:
        th = th;
    L59:
        r18 = r13;
        r28 = th;
    L58:
        th = th;
    L61:
        th = move-exception;
        r28 = th;
        r29 = r13;
    L65:
        r14 = null;
    L63:
        th = move-exception;
        r28 = th;
        r29 = null;
    L40:
        th = move-exception;
        Result.Companion r30 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
    L72:
        th = th;
    L106:
        th = move-exception;
        if (r5 == null) goto L146;
        Socket r31 = this.$socket;
        Result.Companion r32 = Result.Companion;     // Catch: Throwable -> L112
        r31.setSoTimeout(r5.intValue());     // Catch: Throwable -> L112
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L112
        throw th;
    L112:
        th = move-exception;
        Result.Companion r33 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        throw th;
    L146:
        throw th;
    L74:
        if (ZeusTransformUtils.instanceOf(th, AttestedSessionHandshake.StageException.class) == false) goto L76;
        AttestedSessionHandshake.StageException r34 = (AttestedSessionHandshake.StageException) ZeusTransformUtils.preCheckCast(th, AttestedSessionHandshake.StageException.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L106
    L77:
        if (r34 == null) goto L80;
        String r35 = r34.getStage();     // Catch: Throwable -> L106
        if (r35 == null) goto L80;
    L82:
        if (ZeusTransformUtils.instanceOf(th, AttestedSessionHandshake.StageException.class) == false) goto L84;
        AttestedSessionHandshake.StageException r36 = (AttestedSessionHandshake.StageException) ZeusTransformUtils.preCheckCast(th, AttestedSessionHandshake.StageException.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L106
    L85:
        if (r36 == null) goto L90;
        Throwable r37 = r36.getCause();     // Catch: Throwable -> L106
        if (r37 == null) goto L90;
        th = r37;
    L90:
        CryptoException r38 = AttestedSessionHandshake.a(AttestedSessionHandshake.f11950a, th);     // Catch: Throwable -> L106
        if (r38 == null) goto L96;
        CryptoException.Code r39 = r38.code;     // Catch: Throwable -> L106
        if (r39 == null) goto L96;
        String r40 = r39.name();     // Catch: Throwable -> L106
        if (r40 == null) goto L96;
    L98:
        if (ZeusTransformUtils.instanceOf(th, SocketTimeoutException.class) == false) goto L100;
        String r41 = "安全握手超时";
    L101:
        t.f11981a.a("v2 handshake: " + this.$role + " failed, stage=" + r35 + ", sdkCode=" + r40 + ", costMs=" + (System.currentTimeMillis() - r6), th);     // Catch: Throwable -> L106
        r3 = (z) ZeusTransformUtils.preCheckCast(new z.a(new o(MigrationErrorCode.CONNECT_FAILED, r41, th)), z.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L106
        if (r5 == null) goto L105;
        Socket r42 = this.$socket;
        Result.Companion r43 = Result.Companion;     // Catch: Throwable -> L40
        r42.setSoTimeout(r5.intValue());     // Catch: Throwable -> L40
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L40
        goto L105
    L100:
        r41 = "安全握手失败: " + th.getMessage();     // Catch: Throwable -> L106
    L96:
        r40 = "none";
        goto L98
    L84:
        r36 = null;
    L80:
        r35 = "open_socket_stream";
        goto L82
    L76:
        r34 = null;
    L15:
        th = move-exception;
        Result.Companion r44 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
    L7:
        th = move-exception;
        Result.Companion r45 = Result.Companion;
        r2 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L10
    L116:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
