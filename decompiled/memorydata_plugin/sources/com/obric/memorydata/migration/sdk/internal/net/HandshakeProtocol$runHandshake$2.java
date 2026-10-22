package com.obric.memorydata.migration.sdk.internal.net;

import androidx.exifinterface.media.ExifInterface;
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
import kotlin.NoWhenBranchMatchedException;
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
@DebugMetadata(c = "com.obric.memorydata.migration.sdk.internal.net.HandshakeProtocol$runHandshake$2", f = "LanConnector.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class HandshakeProtocol$runHandshake$2<T> extends SuspendLambda implements Function2<al, Continuation<? super z<? extends T>>, Object> {
    final /* synthetic */ Function2<DataInputStream, DataOutputStream, z<T>> $block;
    final /* synthetic */ String $role;
    final /* synthetic */ Socket $socket;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ HandshakeProtocol this$0;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11943a = null;

        static {
            int[] r0 = new int[MigrationErrorCode.values().length];
            r0[MigrationErrorCode.DISCONNECTED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            f11943a = r0;
        }
    }

    public HandshakeProtocol$runHandshake$2(String r3, Socket r4, Function2<? super DataInputStream, ? super DataOutputStream, ? extends z<? extends T>> r5, HandshakeProtocol r6, Continuation<? super HandshakeProtocol$runHandshake$2> r7) {
        Function2<DataInputStream, DataOutputStream, z<T>> r8 = (Function2) ZeusTransformUtils.wrapperContextForParams(r5, Function2.class, "com.obric.memorydata.plugin");
        Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        this.$role = r3;
        this.$socket = r4;
        this.$block = r8;
        this.this$0 = r6;
        super(2, r9);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
        HandshakeProtocol$runHandshake$2 r11 = new HandshakeProtocol$runHandshake$2(this.$role, this.$socket, this.$block, this.this$0, r7);
        r11.L$0 = r9;
        return (Continuation) ZeusTransformUtils.preCheckCast(r11, Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Object r4) {
        return invoke((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public final Object invoke(al r3, Continuation<? super z<? extends T>> r4) {
        return ((HandshakeProtocol$runHandshake$2) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), HandshakeProtocol$runHandshake$2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L53;
        ResultKt.throwOnFailure(r10);
        al r11 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
        long r2 = System.currentTimeMillis();
        t.f11981a.a("v1 handshake: " + this.$role + " begin, timeoutMs=15000");
        Socket r12 = this.$socket;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L7
        Object r13 = Result.m1421constructorimpl(Boxing.boxInt(r12.getSoTimeout()));     // Catch: Throwable -> L7
    L10:
        if (Result.m1427isFailureimpl(r13) == false) goto L12;
        r13 = null;
    L12:
        Integer r14 = (Integer) ZeusTransformUtils.preCheckCast(r13, Integer.class, "com.obric.memorydata.plugin");
        Socket r1 = this.$socket;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L15
        r1.setSoTimeout(15000);     // Catch: Throwable -> L15
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L15
    L17:
        Function2<DataInputStream, DataOutputStream, z<T>> r3 = this.$block;
        Socket r6 = this.$socket;
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L20
        Object r4 = Result.m1421constructorimpl((z) ZeusTransformUtils.preCheckCast(r3.invoke(new DataInputStream(r6.getInputStream()), new DataOutputStream(r6.getOutputStream())), z.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L20
    L22:
        HandshakeProtocol r8 = this.this$0;
        Throwable r9 = Result.m1424exceptionOrNullimpl(r4);
        if (r9 != null) goto L26;
    L36:
        z r15 = (z) ZeusTransformUtils.preCheckCast(r4, z.class, "com.obric.memorydata.plugin");
        if (r14 == null) goto L44;
        Socket r16 = this.$socket;
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L41
        r16.setSoTimeout(r14.intValue());     // Catch: Throwable -> L41
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L41
    L41:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
    L44:
        if (ZeusTransformUtils.instanceOf(r15, z.b.class) == false) goto L47;
        t.f11981a.a("v1 handshake: " + this.$role + " success, costMs=" + (System.currentTimeMillis() - r2));
    L49:
        return r15;
    L47:
        if (ZeusTransformUtils.instanceOf(r15, z.a.class) == false) goto L51;
        t.f11981a.a("v1 handshake: " + this.$role + " failed, code=" + ((z.a) ZeusTransformUtils.preCheckCast(r15, z.a.class, "com.obric.memorydata.plugin")).a().a() + ", costMs=" + (System.currentTimeMillis() - r2), ((z.a) ZeusTransformUtils.preCheckCast(r15, z.a.class, "com.obric.memorydata.plugin")).a().c());
        goto L49
    L51:
        throw new NoWhenBranchMatchedException();
    L26:
        if (ZeusTransformUtils.instanceOf(r9, SocketTimeoutException.class) == false) goto L29;
    L27:
        MigrationErrorCode r19 = MigrationErrorCode.CONNECT_FAILED;
    L32:
        if (a.f11943a[r19.ordinal()] != 1) goto L34;
        StringBuilder r20 = new StringBuilder();
        String r21 = "连接断开: ";
    L35:
        r4 = (z) ZeusTransformUtils.preCheckCast(new z.a(new o(r19, r20.append(r21).append(r9.getMessage()).toString(), r9)), z.class, "com.obric.memorydata.plugin");
        goto L36
    L34:
        r20 = new StringBuilder();
        r21 = "握手失败: ";
        goto L35
    L29:
        if (HandshakeProtocol.a(r8, r9) == false) goto L27;
        r19 = MigrationErrorCode.DISCONNECTED;
    L20:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        r4 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L15:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
    L7:
        th = move-exception;
        Result.Companion r24 = Result.Companion;
        r13 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L10
    L53:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    public final Object invokeSuspend$$forInline(Object r11) {
        al r12 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
        long r2 = System.currentTimeMillis();
        t.f11981a.a("v1 handshake: " + this.$role + " begin, timeoutMs=15000");
        Socket r0 = this.$socket;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L5
        al r5 = (al) ZeusTransformUtils.preCheckCast(r12, al.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
        Object r1 = Result.m1421constructorimpl(Integer.valueOf(r0.getSoTimeout()));     // Catch: Throwable -> L5
    L8:
        if (Result.m1427isFailureimpl(r1) == false) goto L10;
        r1 = null;
    L10:
        Integer r3 = (Integer) ZeusTransformUtils.preCheckCast(r1, Integer.class, "com.obric.memorydata.plugin");
        Socket r6 = this.$socket;
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L13
        al r8 = (al) ZeusTransformUtils.preCheckCast(r12, al.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
        r6.setSoTimeout(15000);     // Catch: Throwable -> L13
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L13
    L15:
        Function2<DataInputStream, DataOutputStream, z<T>> r9 = this.$block;
        Socket r10 = this.$socket;
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L18
        al r14 = (al) ZeusTransformUtils.preCheckCast(r12, al.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L18
        Object r15 = Result.m1421constructorimpl((z) ZeusTransformUtils.preCheckCast(r9.invoke(new DataInputStream(r10.getInputStream()), new DataOutputStream(r10.getOutputStream())), z.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L18
    L20:
        HandshakeProtocol r16 = this.this$0;
        Throwable r17 = Result.m1424exceptionOrNullimpl(r15);
        if (r17 == null) goto L34;
        Throwable r18 = (Throwable) ZeusTransformUtils.preCheckCast(r17, Throwable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r18, SocketTimeoutException.class) == false) goto L27;
    L25:
        MigrationErrorCode r19 = MigrationErrorCode.CONNECT_FAILED;
    L30:
        if (a.f11943a[r19.ordinal()] != 1) goto L32;
        StringBuilder r20 = new StringBuilder();
        String r21 = "连接断开: ";
    L33:
        r15 = (z) ZeusTransformUtils.preCheckCast(new z.a(new o(r19, r20.append(r21).append(r18.getMessage()).toString(), r18)), z.class, "com.obric.memorydata.plugin");
        goto L34
    L32:
        r20 = new StringBuilder();
        r21 = "握手失败: ";
        goto L33
    L27:
        if (HandshakeProtocol.a(r16, r18) == false) goto L25;
        r19 = MigrationErrorCode.DISCONNECTED;
    L34:
        z r22 = (z) ZeusTransformUtils.preCheckCast(r15, z.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L42;
        Socket r23 = this.$socket;
        Result.Companion r24 = Result.Companion;     // Catch: Throwable -> L39
        al r110 = (al) ZeusTransformUtils.preCheckCast(r12, al.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L39
        r23.setSoTimeout(r3.intValue());     // Catch: Throwable -> L39
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        Result.Companion r25 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
    L42:
        if (ZeusTransformUtils.instanceOf(r22, z.b.class) == false) goto L45;
        t.f11981a.a("v1 handshake: " + this.$role + " success, costMs=" + (System.currentTimeMillis() - r2));
    L47:
        return r22;
    L45:
        if (ZeusTransformUtils.instanceOf(r22, z.a.class) == false) goto L49;
        t.f11981a.a("v1 handshake: " + this.$role + " failed, code=" + ((z.a) ZeusTransformUtils.preCheckCast(r22, z.a.class, "com.obric.memorydata.plugin")).a().a() + ", costMs=" + (System.currentTimeMillis() - r2), ((z.a) ZeusTransformUtils.preCheckCast(r22, z.a.class, "com.obric.memorydata.plugin")).a().c());
        goto L47
    L49:
        throw new NoWhenBranchMatchedException();
    L18:
        th = move-exception;
        Result.Companion r26 = Result.Companion;
        r15 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L13:
        th = move-exception;
        Result.Companion r27 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
    L5:
        th = move-exception;
        Result.Companion r28 = Result.Companion;
        r1 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L8
    }
}
