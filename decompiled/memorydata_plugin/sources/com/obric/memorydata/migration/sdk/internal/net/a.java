package com.obric.memorydata.migration.sdk.internal.net;

import android.content.Context;
import com.google.gson.Gson;
import com.obric.capabilitykit.common.Ext;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.obric.memorydata.migration.sdk.MigrationErrorCode;
import com.obric.memorydata.migration.sdk.MigrationSecurityProtocol;
import com.obric.memorydata.migration.sdk.d;
import com.obric.memorydata.migration.sdk.e;
import com.obric.memorydata.migration.sdk.f;
import com.obric.memorydata.migration.sdk.internal.security.AttestedSessionHandshake;
import com.obric.memorydata.migration.sdk.o;
import com.obric.memorydata.migration.sdk.t;
import com.obric.memorydata.migration.sdk.z;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0086@¢\u0006\u0002\u0010\u0010J\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\f2\u0006\u0010\u0013\u001a\u00020\rH\u0086@¢\u0006\u0002\u0010\u0014J,\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\f2\u0006\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0019H\u0086@¢\u0006\u0002\u0010\u001aJ$\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00160\f2\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0019H\u0086@¢\u0006\u0002\u0010\u001cJ\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00190\u001eJ\u000e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00190\u001eH\u0002J(\u0010 \u001a\u0004\u0018\u00010\u00122\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00190\u001e2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020#H\u0002J\b\u0010%\u001a\u00020\u0019H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\b\u001a\n \t*\u0004\u0018\u00010\u00030\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\n¨\u0006&"}, d2 = {"Lcom/obric/memorydata/migration/sdk/internal/net/LanConnector;", "", "context", "Landroid/content/Context;", "handshake", "Lcom/obric/memorydata/migration/sdk/internal/net/HandshakeProtocol;", "<init>", "(Landroid/content/Context;Lcom/obric/memorydata/migration/sdk/internal/net/HandshakeProtocol;)V", "appContext", "kotlin.jvm.PlatformType", "Landroid/content/Context;", "createRequest", "Lcom/obric/memorydata/migration/sdk/MigrationResult;", "Lcom/obric/memorydata/migration/sdk/ConnectRequest;", TrackerImpl.PARAMS, "Lcom/obric/memorydata/migration/sdk/CreateRequestParams;", "(Lcom/obric/memorydata/migration/sdk/CreateRequestParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "acceptTcp", "Ljava/net/Socket;", Ext.KEY_REQUEST, "(Lcom/obric/memorydata/migration/sdk/ConnectRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handshakeAsSender", "Lcom/obric/memorydata/migration/sdk/Connection;", "socket", "accountId", "", "(Ljava/net/Socket;Lcom/obric/memorydata/migration/sdk/ConnectRequest;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "connect", "(Lcom/obric/memorydata/migration/sdk/ConnectRequest;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "collectEndpointsSnapshot", "", "collectEndpoints", "connectByEndpoints", "endpoints", "port", "", "connectTimeoutMs", "securePairingCode", "migration_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final HandshakeProtocol f11945a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f11946b;

    /* JADX INFO: renamed from: com.obric.memorydata.migration.sdk.internal.net.a$a, reason: collision with other inner class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class C0648a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11947a = null;

        static {
            int[] r0 = new int[MigrationSecurityProtocol.values().length];
            r0[MigrationSecurityProtocol.LEGACY_V1.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[MigrationSecurityProtocol.ATTESTED_V2.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f11947a = r0;
        }
    }

    public a(Context r3, HandshakeProtocol r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r4, "handshake");
        this.f11945a = r4;
        this.f11946b = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ a(Context r2, HandshakeProtocol r3, int r4, DefaultConstructorMarker r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L5;
        Gson r7 = null;
        r3 = new HandshakeProtocol(r7, 1, 0 == true ? 1 : 0);
    L5:
        this(r6, r3);
    }

    public static final /* synthetic */ Socket a(a r2, List r3, int r4, int r5) {
        return r2.a((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4, r5);
    }

    private final Socket a(List<String> r18, int r19, int r20) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r18, List.class, "com.obric.memorydata.plugin");
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r0 = 0;
    L4:
        if (r7.hasNext() == false) goto L39;
        Object r8 = r7.next();
        int r11 = r0 + 1;
        if (r0 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        String r9 = (String) ZeusTransformUtils.preCheckCast(r8, String.class, "com.obric.memorydata.plugin");
        Socket r12 = new Socket();
        long r13 = System.currentTimeMillis();
        t.f11981a.a("lan: connect attempt, index=" + r11 + '/' + r6.size() + ", endpoint=" + r9 + ", port=" + r19 + ", timeoutMs=" + r20);
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L11
        a r2 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        r12.connect((SocketAddress) ZeusTransformUtils.preCheckCast(new InetSocketAddress(r9, r19), SocketAddress.class, "com.obric.memorydata.plugin"), r20);     // Catch: Throwable -> L11
        Object r3 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L14:
        if (Result.m1428isSuccessimpl(r3) == true) goto L15;
        Throwable r4 = Result.m1424exceptionOrNullimpl(r3);
        t r10 = t.f11981a;
        Iterator r16 = r7;
        StringBuilder r5 = new StringBuilder().append("lan: connect attempt failed, index=").append(r11).append('/').append(r6.size()).append(", endpoint=").append(r9).append(", costMs=").append(System.currentTimeMillis() - r13).append(", error=");
        if (r4 == null) goto L22;
        Class<?> r14 = r4.getClass();
        if (r14 == null) goto L22;
        String r15 = r14.getSimpleName();
    L23:
        String r17 = "";
        if (r15 != null) goto L26;
        r15 = "";
    L26:
        StringBuilder r21 = r5.append(r15).append(':');
        if (r4 == null) goto L29;
        String r110 = r4.getMessage();
    L30:
        if (r110 == null) goto L33;
        r17 = r110;
    L33:
        r10.a(r21.append(r17).toString());
        Result.Companion r22 = Result.Companion;     // Catch: Throwable -> L36
        a r23 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L36
        r12.close();     // Catch: Throwable -> L36
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L36
    L38:
        r0 = r11;
        r7 = r16;
    L36:
        th = move-exception;
        Result.Companion r24 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L38
    L29:
        r110 = null;
    L22:
        r15 = null;
        goto L23
    L15:
        t.f11981a.a("lan: connect attempt success, index=" + r11 + '/' + r6.size() + ", endpoint=" + r9 + ", costMs=" + (System.currentTimeMillis() - r13));
        return r12;
    L11:
        th = move-exception;
        Result.Companion r25 = Result.Companion;
        r3 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L14
    L39:
        t.a(t.f11981a, "lan: all connect attempts failed, endpointCount=" + r6.size() + ", port=" + r19, null, 2, null);
        return null;
    }

    public static final /* synthetic */ List a(a r0) {
        return r0.b();
    }

    public static final /* synthetic */ String b(a r0) {
        return r0.c();
    }

    private final List<String> b() {
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L37
        a r6 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L37
        Enumeration<NetworkInterface> r7 = NetworkInterface.getNetworkInterfaces();     // Catch: Throwable -> L37
        Intrinsics.checkNotNullExpressionValue(r7, "getNetworkInterfaces(...)");     // Catch: Throwable -> L37
        ArrayList r8 = Collections.list(r7);     // Catch: Throwable -> L37
        Intrinsics.checkNotNullExpressionValue(r8, "list(...)");     // Catch: Throwable -> L37
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L37
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L37
        Iterator r10 = r9.iterator();     // Catch: Throwable -> L37
    L5:
        if (r10.hasNext() == false) goto L7;
        Enumeration<InetAddress> r4 = ((NetworkInterface) ZeusTransformUtils.preCheckCast(r10.next(), NetworkInterface.class, "com.obric.memorydata.plugin")).getInetAddresses();     // Catch: Throwable -> L37
        Intrinsics.checkNotNullExpressionValue(r4, "getInetAddresses(...)");     // Catch: Throwable -> L37
        ArrayList r5 = Collections.list(r4);     // Catch: Throwable -> L37
        Intrinsics.checkNotNullExpressionValue(r5, "list(...)");     // Catch: Throwable -> L37
        CollectionsKt.addAll(r3, (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L37
        goto L5
    L7:
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L37
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L37
        Iterator r12 = r11.iterator();     // Catch: Throwable -> L37
    L9:
        if (r12.hasNext() == false) goto L13;
        Object r13 = r12.next();     // Catch: Throwable -> L37
        if (ZeusTransformUtils.instanceOf(r13, Inet4Address.class) == false) goto L9;
        r0.add(r13);     // Catch: Throwable -> L37
        goto L9
    L13:
        Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L37
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L37
        Iterator r15 = r14.iterator();     // Catch: Throwable -> L37
    L14:
        boolean r16 = true;
        if (r15.hasNext() == false) goto L24;
        Object r17 = r15.next();     // Catch: Throwable -> L37
        Inet4Address r18 = (Inet4Address) ZeusTransformUtils.preCheckCast(r17, Inet4Address.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L37
        if (r18.isLoopbackAddress() == false) goto L19;
    L21:
        r16 = false;
    L22:
        if (r16 == false) goto L14;
        r1.add(r17);     // Catch: Throwable -> L37
        goto L14
    L19:
        if (r18.isLinkLocalAddress() == true) goto L21;
    L24:
        Iterable r19 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L37
        Collection r20 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L37
        Iterator r21 = r19.iterator();     // Catch: Throwable -> L37
    L26:
        if (r21.hasNext() == false) goto L35;
        String r22 = ((Inet4Address) ZeusTransformUtils.preCheckCast(r21.next(), Inet4Address.class, "com.obric.memorydata.plugin")).getHostAddress();     // Catch: Throwable -> L37
        if (r22 != null) goto L30;
    L32:
        r22 = null;
    L33:
        if (r22 == null) goto L26;
        r20.add(r22);     // Catch: Throwable -> L37
        goto L26
    L30:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r22, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L32;
    L35:
        Object r23 = Result.m1421constructorimpl(CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r20, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")));     // Catch: Throwable -> L37
    L39:
        List r24 = CollectionsKt.emptyList();
        if (Result.m1427isFailureimpl(r23) == false) goto L43;
        r23 = r24;
    L43:
        return (List) ZeusTransformUtils.preCheckCast(r23, List.class, "com.obric.memorydata.plugin");
    L37:
        th = move-exception;
        Result.Companion r25 = Result.Companion;
        r23 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L39
    }

    public static final /* synthetic */ HandshakeProtocol c(a r0) {
        return r0.f11945a;
    }

    private final String c() {
        return StringsKt.padStart(String.valueOf(new SecureRandom().nextInt(1000000)), 6, '0');
    }

    public static final /* synthetic */ Context d(a r0) {
        return r0.f11946b;
    }

    public final Object a(d r5, String r6, Continuation<? super z<? extends e>> r7) {
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        return i.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new LanConnector$connect$2(r5, this, r6, null), Function2.class, "com.obric.memorydata.plugin"), r8);
    }

    public final Object a(d r7, Continuation<? super z<? extends Socket>> r8) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
        ServerSocket r9 = r7.b();
        if (r9 != null) goto L7;
        return new z.a(new o(MigrationErrorCode.OTHER, "serverSocket is null", null, 4, null));
    L7:
        return i.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new LanConnector$acceptTcp$2(r7, r9, null), Function2.class, "com.obric.memorydata.plugin"), r6);
    }

    public final Object a(f r5, Continuation<? super z<d>> r6) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        return i.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new LanConnector$createRequest$2(this, r5, null), Function2.class, "com.obric.memorydata.plugin"), r7);
    }

    public final Object a(Socket r22, d r23, String r24, Continuation<? super z<? extends e>> r25) {
        Continuation r1 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r25, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, LanConnector$handshakeAsSender$1.class) == false) goto L7;
        LanConnector$handshakeAsSender$1 r2 = (LanConnector$handshakeAsSender$1) ZeusTransformUtils.preCheckCast(r1, LanConnector$handshakeAsSender$1.class, "com.obric.memorydata.plugin");
        if ((r2.label & Integer.MIN_VALUE) == 0) goto L7;
        r2.label -= Integer.MIN_VALUE;
    L8:
        LanConnector$handshakeAsSender$1 r5 = r2;
        Object r3 = r5.result;
        Object r8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r5.label;
        String r9 = "";
        if (r4 == 0) goto L16;
        if (r4 == 1) goto L15;
        if (r4 != 2) goto L14;
        long r6 = r5.J$0;
        String r0 = (String) ZeusTransformUtils.preCheckCast(r5.L$1, String.class, "com.obric.memorydata.plugin");
        Socket r7 = (Socket) ZeusTransformUtils.preCheckCast(r5.L$0, Socket.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r3);
    L38:
        z r10 = (z) ZeusTransformUtils.preCheckCast(r3, z.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r10, z.b.class) == false) goto L42;
        Object r11 = ZeusTransformUtils.preCheckCast(new z.b(new e.a(r7, ((AttestedSessionHandshake.a) ZeusTransformUtils.preCheckCast(((z.b) ZeusTransformUtils.preCheckCast(r10, z.b.class, "com.obric.memorydata.plugin")).a(), AttestedSessionHandshake.a.class, "com.obric.memorydata.plugin")).b(), MigrationSecurityProtocol.ATTESTED_V2, ((AttestedSessionHandshake.a) ZeusTransformUtils.preCheckCast(((z.b) ZeusTransformUtils.preCheckCast(r10, z.b.class, "com.obric.memorydata.plugin")).a(), AttestedSessionHandshake.a.class, "com.obric.memorydata.plugin")).a())), z.class, "com.obric.memorydata.plugin");
    L70:
        r10 = (z) r11;
    L71:
        String r12 = r0;
        long r13 = r6;
    L81:
        if (ZeusTransformUtils.instanceOf(r10, z.b.class) == false) goto L88;
        t r14 = t.f11981a;
        StringBuilder r15 = new StringBuilder().append("lan: sender handshake success, protocol=");
        if (r12 == null) goto L86;
        r9 = r12;
    L86:
        r14.a(r15.append(r9).append(", costMs=").append(System.currentTimeMillis() - r13).toString());
    L94:
        return r10;
    L88:
        if (ZeusTransformUtils.instanceOf(r10, z.a.class) == false) goto L96;
        t r16 = t.f11981a;
        StringBuilder r17 = new StringBuilder().append("lan: sender handshake failed, protocol=");
        if (r12 == null) goto L93;
        r9 = r12;
    L93:
        r16.a(r17.append(r9).append(", code=").append(((z.a) ZeusTransformUtils.preCheckCast(r10, z.a.class, "com.obric.memorydata.plugin")).a().a()).append(", costMs=").append(System.currentTimeMillis() - r13).toString(), ((z.a) ZeusTransformUtils.preCheckCast(r10, z.a.class, "com.obric.memorydata.plugin")).a().c());
        goto L94
    L96:
        throw new NoWhenBranchMatchedException();
    L42:
        if (ZeusTransformUtils.instanceOf(r10, z.a.class) == true) goto L71;
        throw new NoWhenBranchMatchedException();
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r6 = r5.J$0;
        r0 = (String) ZeusTransformUtils.preCheckCast(r5.L$1, String.class, "com.obric.memorydata.plugin");
        Socket r18 = (Socket) ZeusTransformUtils.preCheckCast(r5.L$0, Socket.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r3);
        Socket r19 = r18;
    L67:
        r10 = (z) ZeusTransformUtils.preCheckCast(r3, z.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r10, z.b.class) == false) goto L73;
        r11 = ZeusTransformUtils.preCheckCast(new z.b(new e.a(r19, (byte[]) ZeusTransformUtils.preCheckCast(((z.b) ZeusTransformUtils.preCheckCast(r10, z.b.class, "com.obric.memorydata.plugin")).a(), byte[].class, "com.obric.memorydata.plugin"), MigrationSecurityProtocol.LEGACY_V1, null, 8, null)), z.class, "com.obric.memorydata.plugin");
        goto L70
    L73:
        if (ZeusTransformUtils.instanceOf(r10, z.a.class) == true) goto L71;
        throw new NoWhenBranchMatchedException();
    L16:
        ResultKt.throwOnFailure(r3);
        String r20 = r23.a().getPairingCode();
        r12 = r23.a().getProtocolVersion();
        String r110 = r23.a().getSenderUidHash();
        MigrationSecurityProtocol r21 = MigrationSecurityProtocol.Companion.a(r12);
        r13 = System.currentTimeMillis();
        t r111 = t.f11981a;
        StringBuilder r26 = new StringBuilder().append("lan: sender handshake begin, protocol=");
        if (r12 != null) goto L19;
        String r112 = "";
    L20:
        StringBuilder r27 = r26.append(r112).append(", security=");
        if (r21 == null) goto L23;
        String r113 = r21.name();
    L24:
        if (r113 != null) goto L26;
        r113 = "";
    L26:
        r111.a(r27.append(r113).toString());
        if (r21 != null) goto L29;
        int r28 = -1;
    L30:
        if (r28 == (-1)) goto L78;
        if (r28 != 1) goto L33;
        CharSequence r29 = (CharSequence) ZeusTransformUtils.preCheckCast(r20, CharSequence.class, "com.obric.memorydata.plugin");
        boolean r30 = false;
        if (r29 != null) goto L51;
    L54:
        boolean r31 = true;
    L55:
        if (r31 == true) goto L77;
        CharSequence r32 = (CharSequence) ZeusTransformUtils.preCheckCast(r110, CharSequence.class, "com.obric.memorydata.plugin");
        if (r32 != null) goto L59;
    L60:
        r30 = true;
    L61:
        if (r30 == true) goto L77;
        HandshakeProtocol r33 = this.f11945a;
        r5.L$0 = r22;
        r5.L$1 = r12;
        r5.J$0 = r13;
        r5.label = 1;
        r3 = r33.b(r22, r20, "1", r110, r5);
        if (r3 != r8) goto L66;
        return r8;
    L66:
        r19 = r22;
        r0 = r12;
        r6 = r13;
        goto L67
    L59:
        if (StringsKt.isBlank(r32) == false) goto L61;
    L77:
        z.a r34 = new z.a(new o(MigrationErrorCode.CONNECT_FAILED, "二维码无效", null, 4, null));
    L79:
        r10 = (z) ZeusTransformUtils.preCheckCast(r34, z.class, "com.obric.memorydata.plugin");
        goto L81
    L51:
        if (StringsKt.isBlank(r29) == true) goto L54;
        r31 = false;
        goto L55
    L33:
        if (r28 != 2) goto L47;
        AttestedSessionHandshake r35 = AttestedSessionHandshake.f11950a;
        Context r36 = this.f11946b;
        Intrinsics.checkNotNullExpressionValue(r36, "appContext");
        r5.L$0 = r22;
        r5.L$1 = r12;
        r5.J$0 = r13;
        r5.label = 2;
        r3 = r35.a(r36, r22, r24, r5);
        if (r3 != r8) goto L37;
        return r8;
    L37:
        r7 = r22;
        r0 = r12;
        r6 = r13;
        goto L38
    L47:
        throw new NoWhenBranchMatchedException();
    L78:
        r34 = new z.a(new o(MigrationErrorCode.CONNECT_FAILED, "迁移协议版本不兼容", null, 4, null));
        goto L79
    L29:
        r28 = C0648a.f11947a[r21.ordinal()];
        goto L30
    L23:
        r113 = null;
        goto L24
    L19:
        r112 = r12;
    L7:
        r2 = new LanConnector$handshakeAsSender$1(this, r1);
        goto L8
    }

    public final List<String> a() {
        return b();
    }
}
