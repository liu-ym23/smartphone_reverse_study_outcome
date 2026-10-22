package com.obric.memorydata.migration.sdk.internal.net;

import android.content.Context;
import com.obric.memorydata.migration.sdk.MigrationErrorCode;
import com.obric.memorydata.migration.sdk.MigrationSecurityProtocol;
import com.obric.memorydata.migration.sdk.QrPayload;
import com.obric.memorydata.migration.sdk.d;
import com.obric.memorydata.migration.sdk.e;
import com.obric.memorydata.migration.sdk.internal.security.AttestedSessionHandshake;
import com.obric.memorydata.migration.sdk.o;
import com.obric.memorydata.migration.sdk.t;
import com.obric.memorydata.migration.sdk.z;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.Socket;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/obric/memorydata/migration/sdk/MigrationResult;", "Lcom/obric/memorydata/migration/sdk/Connection;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.migration.sdk.internal.net.LanConnector$connect$2", f = "LanConnector.kt", i = {0, 0, 0, 0, 1, 1, 1, 1}, l = {194, 210}, m = "invokeSuspend", n = {"$this$invokeSuspend_u24lambda_u242", "securityProtocol", "socket", "handshakeStartMs", "$this$invokeSuspend_u24lambda_u242", "securityProtocol", "socket", "handshakeStartMs"}, s = {"L$0", "L$1", "L$2", "J$0", "L$0", "L$1", "L$2", "J$0"})
final class LanConnector$connect$2 extends SuspendLambda implements Function2<al, Continuation<? super z<? extends e>>, Object> {
    final /* synthetic */ String $accountId;
    final /* synthetic */ d $request;
    long J$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ com.obric.memorydata.migration.sdk.internal.net.a this$0;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11944a = null;

        static {
            int[] r0 = new int[MigrationSecurityProtocol.values().length];
            r0[MigrationSecurityProtocol.LEGACY_V1.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[MigrationSecurityProtocol.ATTESTED_V2.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f11944a = r0;
        }
    }

    LanConnector$connect$2(d r3, com.obric.memorydata.migration.sdk.internal.net.a r4, String r5, Continuation<? super LanConnector$connect$2> r6) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        this.$request = r3;
        this.this$0 = r4;
        this.$accountId = r5;
        super(2, r7);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        LanConnector$connect$2 r0 = new LanConnector$connect$2(this.$request, this.this$0, this.$accountId, r7);
        r0.L$0 = r5;
        return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super z<? extends e>> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super z<? extends e>> r4) {
        return ((LanConnector$connect$2) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), LanConnector$connect$2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r20) {
        Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L14;
        if (r1 == 1) goto L11;
        if (r1 != 2) goto L10;
        long r2 = this.J$0;
        Socket r3 = (Socket) ZeusTransformUtils.preCheckCast(this.L$2, Socket.class, "com.obric.memorydata.plugin");
        MigrationSecurityProtocol r4 = (MigrationSecurityProtocol) ZeusTransformUtils.preCheckCast(this.L$1, MigrationSecurityProtocol.class, "com.obric.memorydata.plugin");
        al r0 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r20);     // Catch: Throwable -> L88
        Object r5 = r20;
    L31:
        z r6 = (z) ZeusTransformUtils.preCheckCast(r5, z.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L88
        if (ZeusTransformUtils.instanceOf(r6, z.b.class) == false) goto L36;
        Object r8 = ZeusTransformUtils.preCheckCast(new z.b(new e.a(r3, ((AttestedSessionHandshake.a) ZeusTransformUtils.preCheckCast(((z.b) ZeusTransformUtils.preCheckCast(r6, z.b.class, "com.obric.memorydata.plugin")).a(), AttestedSessionHandshake.a.class, "com.obric.memorydata.plugin")).b(), MigrationSecurityProtocol.ATTESTED_V2, ((AttestedSessionHandshake.a) ZeusTransformUtils.preCheckCast(((z.b) ZeusTransformUtils.preCheckCast(r6, z.b.class, "com.obric.memorydata.plugin")).a(), AttestedSessionHandshake.a.class, "com.obric.memorydata.plugin")).a())), z.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L88
    L34:
        r6 = (z) r8;     // Catch: Throwable -> L88
    L66:
        long r14 = r2;
        Socket r11 = r3;
        MigrationSecurityProtocol r10 = r4;
    L67:
        z r9 = r6;
        if (ZeusTransformUtils.instanceOf(r9, z.b.class) == false) goto L75;
        t.f11981a.a("lan: receiver handshake success, protocol=" + r10.getWireVersion() + ", costMs=" + (System.currentTimeMillis() - r14));     // Catch: Throwable -> L88
    L82:
        z r12 = r9;
    L83:
        Object r13 = Result.m1421constructorimpl(r12);     // Catch: Throwable -> L88
    L90:
        Throwable r15 = Result.m1424exceptionOrNullimpl(r13);
        if (r15 == null) goto L98;
        t.f11981a.a("lan: connect failed", r15);
        return (z) ZeusTransformUtils.preCheckCast(new z.a(new o(MigrationErrorCode.CONNECT_FAILED, "连接失败: " + r15.getMessage(), r15)), z.class, "com.obric.memorydata.plugin");
    L98:
        return r13;
    L75:
        if (ZeusTransformUtils.instanceOf(r9, z.a.class) == false) goto L85;
        t.f11981a.a("lan: receiver handshake failed, protocol=" + r10.getWireVersion() + ", code=" + ((z.a) ZeusTransformUtils.preCheckCast(r9, z.a.class, "com.obric.memorydata.plugin")).a().a() + ", costMs=" + (System.currentTimeMillis() - r14), ((z.a) ZeusTransformUtils.preCheckCast(r9, z.a.class, "com.obric.memorydata.plugin")).a().c());     // Catch: Throwable -> L88
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L79
        r11.close();     // Catch: Throwable -> L79
        Object r17 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L79
    L81:
        Result.m1420boximpl(r17);     // Catch: Throwable -> L88
        goto L82
    L79:
        th = move-exception;
        Result.Companion r18 = Result.Companion;     // Catch: Throwable -> L88
        r17 = Result.m1421constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L88
        goto L81
    L85:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L88
    L36:
        if (ZeusTransformUtils.instanceOf(r6, z.a.class) == true) goto L66;
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L88
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        r2 = this.J$0;
        r3 = (Socket) ZeusTransformUtils.preCheckCast(this.L$2, Socket.class, "com.obric.memorydata.plugin");
        r4 = (MigrationSecurityProtocol) ZeusTransformUtils.preCheckCast(this.L$1, MigrationSecurityProtocol.class, "com.obric.memorydata.plugin");
        al r19 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r20);     // Catch: Throwable -> L88
        Object r21 = r20;
    L61:
        r6 = (z) ZeusTransformUtils.preCheckCast(r21, z.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L88
        if (ZeusTransformUtils.instanceOf(r6, z.b.class) == false) goto L65;
        r8 = ZeusTransformUtils.preCheckCast(new z.b(new e.a(r3, (byte[]) ZeusTransformUtils.preCheckCast(((z.b) ZeusTransformUtils.preCheckCast(r6, z.b.class, "com.obric.memorydata.plugin")).a(), byte[].class, "com.obric.memorydata.plugin"), MigrationSecurityProtocol.LEGACY_V1, null, 8, null)), z.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L88
        goto L34
    L65:
        if (ZeusTransformUtils.instanceOf(r6, z.a.class) == true) goto L66;
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L88
    L14:
        ResultKt.throwOnFailure(r20);
        al r22 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
        d r23 = this.$request;
        com.obric.memorydata.migration.sdk.internal.net.a r24 = this.this$0;
        String r25 = this.$accountId;
        Result.Companion r110 = Result.Companion;     // Catch: Throwable -> L88
        QrPayload r26 = r23.a();     // Catch: Throwable -> L88
        r10 = MigrationSecurityProtocol.Companion.a(r26.getProtocolVersion());     // Catch: Throwable -> L88
        if (r10 != null) goto L18;
        r12 = (z) ZeusTransformUtils.preCheckCast(new z.a(new o(MigrationErrorCode.CONNECT_FAILED, "迁移协议版本不兼容", null, 4, null)), z.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L88
        goto L83
    L18:
        List<String> r111 = r26.getEndpoints();     // Catch: Throwable -> L88
        if (r111 != null) goto L21;
        r111 = CollectionsKt.emptyList();     // Catch: Throwable -> L88
    L21:
        int r112 = r26.getServerPort();     // Catch: Throwable -> L88
        String r113 = r26.getPairingCode();     // Catch: Throwable -> L88
        String r114 = r26.getSenderUidHash();     // Catch: Throwable -> L88
        long r115 = System.currentTimeMillis();     // Catch: Throwable -> L88
        t.f11981a.a("lan: receiver connect begin, protocol=" + r10.getWireVersion() + ", endpointCount=" + r111.size() + ", port=" + r112);     // Catch: Throwable -> L88
        r11 = com.obric.memorydata.migration.sdk.internal.net.a.a(r24, r111, r112, 1200);     // Catch: Throwable -> L88
        if (r11 == null) goto L87;
        t.f11981a.a("lan: receiver tcp connected, protocol=" + r10.getWireVersion() + ", costMs=" + (System.currentTimeMillis() - r115) + ", start handshake");     // Catch: Throwable -> L88
        r14 = System.currentTimeMillis();     // Catch: Throwable -> L88
        int r27 = a.f11944a[r10.ordinal()];     // Catch: Throwable -> L88
        if (r27 != 1) goto L26;
        CharSequence r28 = (CharSequence) ZeusTransformUtils.preCheckCast(r113, CharSequence.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L88
        boolean r29 = false;
        if (r28 != null) goto L45;
    L48:
        boolean r30 = true;
    L49:
        if (r30 == true) goto L70;
        CharSequence r31 = (CharSequence) ZeusTransformUtils.preCheckCast(r114, CharSequence.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L88
        if (r31 != null) goto L53;
    L54:
        r29 = true;
    L55:
        if (r29 == true) goto L70;
        HandshakeProtocol r32 = com.obric.memorydata.migration.sdk.internal.net.a.c(r24);     // Catch: Throwable -> L88
        this.L$0 = r22;     // Catch: Throwable -> L88
        this.L$1 = r10;     // Catch: Throwable -> L88
        this.L$2 = r11;     // Catch: Throwable -> L88
        this.J$0 = r14;     // Catch: Throwable -> L88
        this.label = 1;     // Catch: Throwable -> L88
        r21 = r32.a(r11, r113, "1", r114, this);     // Catch: Throwable -> L88
        if (r21 != r7) goto L60;
        return r7;
    L60:
        r4 = r10;
        r3 = r11;
        r2 = r14;
        goto L61
    L53:
        if (StringsKt.isBlank(r31) == false) goto L55;
    L70:
        r6 = (z) ZeusTransformUtils.preCheckCast(new z.a(new o(MigrationErrorCode.CONNECT_FAILED, "二维码无效", null, 4, null)), z.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L88
        goto L67
    L45:
        if (StringsKt.isBlank(r28) == true) goto L48;
        r30 = false;
        goto L49
    L26:
        if (r27 != 2) goto L41;
        AttestedSessionHandshake r33 = AttestedSessionHandshake.f11950a;     // Catch: Throwable -> L88
        Context r34 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.obric.memorydata.migration.sdk.internal.net.a.d(r24), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L88
        Intrinsics.checkNotNullExpressionValue(r34, "access$getAppContext$p(...)");     // Catch: Throwable -> L88
        this.L$0 = r22;     // Catch: Throwable -> L88
        this.L$1 = r10;     // Catch: Throwable -> L88
        this.L$2 = r11;     // Catch: Throwable -> L88
        this.J$0 = r14;     // Catch: Throwable -> L88
        this.label = 2;     // Catch: Throwable -> L88
        r5 = r33.b(r34, r11, r25, this);     // Catch: Throwable -> L88
        if (r5 != r7) goto L30;
        return r7;
    L30:
        r4 = r10;
        r3 = r11;
        r2 = r14;
        goto L31
    L41:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L88
    L87:
        throw new IllegalStateException("connect failed".toString());     // Catch: Throwable -> L88
    L88:
        th = move-exception;
        Result.Companion r35 = Result.Companion;
        r13 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L90
    }
}
