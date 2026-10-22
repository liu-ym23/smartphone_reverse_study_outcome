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
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\n¨\u0006\u0004"}, d2 = {"<anonymous>", "Lcom/obric/memorydata/migration/sdk/MigrationResult;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;", "com/obric/memorydata/migration/sdk/internal/security/AttestedSessionHandshake$runHandshake$2"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.migration.sdk.internal.security.AttestedSessionHandshake$asResponder$$inlined$runHandshake$1", f = "AttestedSessionHandshake.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AttestedSessionHandshake$asResponder$$inlined$runHandshake$1 extends SuspendLambda implements Function2<al, Continuation<? super z<? extends AttestedSessionHandshake.a>>, Object> {
    final /* synthetic */ String $accountId$inlined;
    final /* synthetic */ Context $context$inlined;
    final /* synthetic */ String $role;
    final /* synthetic */ Socket $socket;
    private /* synthetic */ Object L$0;
    int label;

    public AttestedSessionHandshake$asResponder$$inlined$runHandshake$1(Socket r3, String r4, Continuation r5, Context r6, String r7) {
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
        AttestedSessionHandshake$asResponder$$inlined$runHandshake$1 r11 = new AttestedSessionHandshake$asResponder$$inlined$runHandshake$1(this.$socket, this.$role, r5, this.$context$inlined, this.$accountId$inlined);
        r11.L$0 = r9;
        return (Continuation) ZeusTransformUtils.preCheckCast(r11, Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super z<? extends AttestedSessionHandshake.a>> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super z<? extends AttestedSessionHandshake.a>> r4) {
        return ((AttestedSessionHandshake$asResponder$$inlined$runHandshake$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AttestedSessionHandshake$asResponder$$inlined$runHandshake$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r0v40, types: [T, byte[]] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r22) {
        Class<byte[]> r2 = byte[].class;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L103;
        ResultKt.throwOnFailure(r22);
        al r0 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
        long r5 = System.currentTimeMillis();
        Socket r1 = this.$socket;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L7
        Object r4 = Result.m1421constructorimpl(Boxing.boxInt(r1.getSoTimeout()));     // Catch: Throwable -> L7
    L10:
        if (Result.m1427isFailureimpl(r4) == false) goto L12;
        r4 = null;
    L12:
        Integer r6 = (Integer) ZeusTransformUtils.preCheckCast(r4, Integer.class, "com.obric.memorydata.plugin");
        Socket r7 = this.$socket;
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L15
        r7.setSoTimeout(LocationInfoConst.HALF_MINUTES);     // Catch: Throwable -> L15
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L15
    L107:
        DataInputStream r9 = new DataInputStream(this.$socket.getInputStream());     // Catch: Throwable -> L59
        DataOutputStream r10 = new DataOutputStream(this.$socket.getOutputStream());     // Catch: Throwable -> L59
        long r11 = System.currentTimeMillis();     // Catch: Throwable -> L59
        String r12 = "receive_initiator_auth";
        Ref.ObjectRef r13 = new Ref.ObjectRef();     // Catch: Throwable -> L59
        t.f11981a.a("v2 handshake: responder begin");     // Catch: Throwable -> L59
        byte[] r14 = AttestedSessionHandshake.a(AttestedSessionHandshake.f11950a, r9, 1);     // Catch: Throwable -> L51
        t.f11981a.a("v2 handshake: initiator auth received, bytes=" + r14.length);     // Catch: Throwable -> L51
        r12 = "create_attestation_service";
        KeyManagerAttestationService r15 = AttestedSessionHandshake.a(AttestedSessionHandshake.f11950a, this.$context$inlined, "receiver");     // Catch: Throwable -> L51
        t.f11981a.a("v2 handshake: responder attestation service ready");     // Catch: Throwable -> L49
        r12 = "create_crypto_session";
        CryptoSession r16 = CryptoSessionManager.createResponderSession(this.$accountId$inlined, "com.obric.memorydata.migration", (IAttestationService) ZeusTransformUtils.preCheckCast(r15, IAttestationService.class, "com.obric.memorydata.plugin"), 600000, r14);     // Catch: Throwable -> L49
        t.f11981a.a("v2 handshake: initiator attestation verified, responder crypto session created");     // Catch: Throwable -> L47
        r12 = "send_responder_auth";
        byte[] r17 = r16.getAuthMessage();     // Catch: Throwable -> L47
        AttestedSessionHandshake r18 = AttestedSessionHandshake.f11950a;     // Catch: Throwable -> L47
        Intrinsics.checkNotNull(r17);     // Catch: Throwable -> L45
        AttestedSessionHandshake.a(r18, r10, 2, r17);     // Catch: Throwable -> L45
        r12 = "send_responder_finish";
        byte[] r19 = r16.getFinishMessage();     // Catch: Throwable -> L43
        AttestedSessionHandshake r110 = AttestedSessionHandshake.f11950a;     // Catch: Throwable -> L43
        Intrinsics.checkNotNull(r19);     // Catch: Throwable -> L41
        AttestedSessionHandshake.a(r110, r10, 3, r19);     // Catch: Throwable -> L41
        t.f11981a.a("v2 handshake: responder auth and finish sent, authBytes=" + r17.length + ", finishBytes=" + r19.length);     // Catch: Throwable -> L41
        byte[] r20 = AttestedSessionHandshake.a(AttestedSessionHandshake.f11950a, r9, 4);     // Catch: Throwable -> L45
        t.f11981a.a("v2 handshake: initiator finish received, bytes=" + r20.length);     // Catch: Throwable -> L45
        r16.confirmHandshake(r20);     // Catch: Throwable -> L45
        t.f11981a.a("v2 handshake: initiator finish confirmed");     // Catch: Throwable -> L45
        byte[] r21 = AttestedSessionHandshake.a(AttestedSessionHandshake.f11950a, r9, 5);     // Catch: Throwable -> L45
        t.f11981a.a("v2 handshake: archive key envelope received, bytes=" + r21.length);     // Catch: Throwable -> L45
        boolean r111 = true;
        r13.element = r16.decrypt(r21, "com.obric.memorydata.migration", "nearby_migration_archive_key", 1);     // Catch: Throwable -> L45
        if (((byte[]) ZeusTransformUtils.preCheckCast(r13.element, r2, "com.obric.memorydata.plugin")).length == 32) goto L30;
        r111 = false;
    L30:
        if (r111 == false) goto L40;
        t.f11981a.a("v2 handshake: responder success, costMs=" + (System.currentTimeMillis() - r11));     // Catch: Throwable -> L45
        Intrinsics.checkNotNull(r16);     // Catch: Throwable -> L45
        T r23 = r13.element;     // Catch: Throwable -> L45
        Intrinsics.checkNotNullExpressionValue(r23, "element");     // Catch: Throwable -> L45
        z r24 = (z) ZeusTransformUtils.preCheckCast(new z.b(new AttestedSessionHandshake.a(r16, (byte[]) ZeusTransformUtils.preCheckCast(r23, r2, "com.obric.memorydata.plugin"))), z.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L59
        Object r25 = r24;
        if (r6 == null) goto L92;
        Socket r26 = this.$socket;
        Result.Companion r27 = Result.Companion;     // Catch: Throwable -> L37
        r26.setSoTimeout(r6.intValue());     // Catch: Throwable -> L37
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L37
        r25 = r24;
    L92:
        return r25;
    L40:
        throw new IllegalStateException(("invalid archive key size=" + ((byte[]) ZeusTransformUtils.preCheckCast(r13.element, r2, "com.obric.memorydata.plugin")).length).toString());     // Catch: Throwable -> L45
    L41:
        th = th;
        r15 = r15;
        r12 = "send_responder_finish";
    L54:
        byte[] r112 = (byte[]) ZeusTransformUtils.preCheckCast(r13.element, r2, "com.obric.memorydata.plugin");     // Catch: Throwable -> L59
        if (r112 == null) goto L57;
        ArraysKt.fill$default(r112, (byte) 0, 0, 0, 6, null);     // Catch: Throwable -> L59
    L57:
        AttestedSessionHandshake.a(AttestedSessionHandshake.f11950a, r16, r15);     // Catch: Throwable -> L59
        throw new AttestedSessionHandshake.StageException(r12, th);     // Catch: Throwable -> L59
    L43:
        th = th;
    L46:
        r15 = r15;
    L45:
        th = th;
    L47:
        th = th;
    L49:
        th = th;
    L53:
        r16 = null;
    L51:
        th = th;
        r15 = null;
    L59:
        th = th;
    L93:
        th = move-exception;
        if (r6 == null) goto L124;
        Socket r28 = this.$socket;
        Result.Companion r29 = Result.Companion;     // Catch: Throwable -> L99
        r28.setSoTimeout(r6.intValue());     // Catch: Throwable -> L99
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L99
        throw th;
    L99:
        th = move-exception;
        Result.Companion r30 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        throw th;
    L124:
        throw th;
    L61:
        if (ZeusTransformUtils.instanceOf(th, AttestedSessionHandshake.StageException.class) == false) goto L63;
        AttestedSessionHandshake.StageException r31 = (AttestedSessionHandshake.StageException) ZeusTransformUtils.preCheckCast(th, AttestedSessionHandshake.StageException.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L93
    L64:
        if (r31 == null) goto L67;
        String r32 = r31.getStage();     // Catch: Throwable -> L93
        if (r32 == null) goto L67;
    L69:
        if (ZeusTransformUtils.instanceOf(th, AttestedSessionHandshake.StageException.class) == false) goto L71;
        AttestedSessionHandshake.StageException r33 = (AttestedSessionHandshake.StageException) ZeusTransformUtils.preCheckCast(th, AttestedSessionHandshake.StageException.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L93
    L72:
        if (r33 == null) goto L77;
        Throwable r34 = r33.getCause();     // Catch: Throwable -> L93
        if (r34 == null) goto L77;
        th = r34;
    L77:
        CryptoException r35 = AttestedSessionHandshake.a(AttestedSessionHandshake.f11950a, th);     // Catch: Throwable -> L93
        if (r35 == null) goto L83;
        CryptoException.Code r36 = r35.code;     // Catch: Throwable -> L93
        if (r36 == null) goto L83;
        String r37 = r36.name();     // Catch: Throwable -> L93
        if (r37 == null) goto L83;
    L85:
        if (ZeusTransformUtils.instanceOf(th, SocketTimeoutException.class) == false) goto L87;
        String r38 = "安全握手超时";
    L88:
        t.f11981a.a("v2 handshake: " + this.$role + " failed, stage=" + r32 + ", sdkCode=" + r37 + ", costMs=" + (System.currentTimeMillis() - r5), th);     // Catch: Throwable -> L93
        z r39 = (z) ZeusTransformUtils.preCheckCast(new z.a(new o(MigrationErrorCode.CONNECT_FAILED, r38, th)), z.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L93
        r25 = r39;
        if (r6 == null) goto L92;
        Socket r40 = this.$socket;
        Result.Companion r41 = Result.Companion;     // Catch: Throwable -> L37
        r40.setSoTimeout(r6.intValue());     // Catch: Throwable -> L37
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L37
        r25 = r39;
        goto L92
    L87:
        r38 = "安全握手失败: " + th.getMessage();     // Catch: Throwable -> L93
    L83:
        r37 = "none";
        goto L85
    L71:
        r33 = null;
    L67:
        r32 = "open_socket_stream";
        goto L69
    L63:
        r31 = null;
    L37:
        th = move-exception;
        Result.Companion r42 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        r25 = r2;
    L15:
        th = move-exception;
        Result.Companion r43 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
    L7:
        th = move-exception;
        Result.Companion r44 = Result.Companion;
        r4 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L10
    L103:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
