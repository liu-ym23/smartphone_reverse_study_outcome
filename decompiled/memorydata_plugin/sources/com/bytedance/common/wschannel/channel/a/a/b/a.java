package com.bytedance.common.wschannel.channel.a.a.b;

import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.l;
import com.bytedance.retrofit2.HttpMethodContrants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.ws.RealWebSocket;
import okhttp3.internal.ws.WebSocketProtocol;
import okio.BufferedSink;
import okio.ByteString;
import okio.Okio;

/* JADX INFO: loaded from: classes.dex */
public class a implements com.bytedance.common.wschannel.channel.a.a.b.b, e.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f2031a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final List<Protocol> f2032b = null;
    private com.bytedance.common.wschannel.channel.a.a.b.c c;
    private final Request d;
    private final Random e;
    private final String f;
    private final Runnable g;
    private final ArrayDeque<ByteString> h;
    private final ArrayDeque<Object> i;
    private final long j;
    private Call k;
    private e l;
    private f m;
    private ScheduledExecutorService n;
    private RealWebSocket.Streams o;
    private long p;
    private boolean q;
    private ScheduledFuture<?> r;
    private int s;
    private String t;
    private boolean u;
    private int v;
    private int w;
    private int x;
    private boolean y;

    /* JADX INFO: renamed from: com.bytedance.common.wschannel.channel.a.a.b.a$a, reason: collision with other inner class name */
    final class RunnableC0113a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f2036a;

        RunnableC0113a(a r1) {
            this.f2036a = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f2036a.cancel();
        }
    }

    static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f2037a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final ByteString f2038b;
        final long c;

        b(int r1, ByteString r2, long r3) {
            this.f2037a = r1;
            this.f2038b = r2;
            this.c = r3;
        }
    }

    static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f2039a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final ByteString f2040b;

        c(int r1, ByteString r2) {
            this.f2039a = r1;
            this.f2040b = r2;
        }
    }

    private final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f2041a;

        d(a r1) {
            this.f2041a = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f2041a.d(ByteString.EMPTY);
        }
    }

    static {
        f2032b = Collections.singletonList(Protocol.HTTP_1_1);
    }

    public a(Request r3, long r4, com.bytedance.common.wschannel.channel.a.a.b.c r6, Random r7) {
        this.h = new ArrayDeque();
        this.i = new ArrayDeque();
        this.s = -1;
        if (HttpMethodContrants.GET.equals(r3.method()) == false) goto L7;
        this.d = r3;
        this.c = r6;
        this.e = r7;
        this.j = r4;
        byte[] r5 = new byte[16];
        r7.nextBytes(r5);
        this.f = ByteString.of(r5).base64();
        this.g = new AnonymousClass1(this);
        return;
    L7:
        throw new IllegalArgumentException("Request must be GET: " + r3.method());
    }

    public static a a(Request r7, long r8, com.bytedance.common.wschannel.channel.a.a.b.c r10) {
        return new a(r7, r8, r10, new Random());
    }

    static /* synthetic */ com.bytedance.common.wschannel.channel.a.a.b.c a(a r0) {
        return r0.c;
    }

    private Request a(Request r6) {
        l.a r0 = l.b();
        if (r0 != null) goto L17;
        return r6;
    L17:
        Map<String, String> r1 = r0.a(r6.url().toString(), r6.headers().toMultimap());     // Catch: Exception -> L14
        if (r1 != null) goto L8;
        return r6;
    L8:
        Request.Builder r2 = r6.newBuilder();     // Catch: Exception -> L14
        Iterator<Map.Entry<String, String>> r3 = r1.entrySet().iterator();     // Catch: Exception -> L14
    L10:
        if (r3.hasNext() == false) goto L12;
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r3.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L14
        r2.addHeader((String) ZeusTransformUtils.preCheckCast(r4.getKey(), String.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r4.getValue(), String.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L14
        goto L10
    L12:
        return r2.build();
    L14:
        e = move-exception;
        Logger.w("tryAddOkWsRequestOpaque failed with exception" + e);
        return r6;
    }

    private synchronized boolean a(ByteString r7, int r8) {
        monitor-enter(this);
    L19:
        th = move-exception;
        throw th;
    L4:
        if (this.u == false) goto L6;
    L17:
        monitor-exit(this);
        return false;
    L6:
        if (this.q == true) goto L17;
        if ((this.p + ((long) r7.size())) <= 16777216) goto L13;
        close(1001, null);     // Catch: Throwable -> L19
        monitor-exit(this);
        return false;
    L13:
        this.p += (long) r7.size();     // Catch: Throwable -> L19
        this.i.add(new c(r8, r7));     // Catch: Throwable -> L19
        d();     // Catch: Throwable -> L19
        monitor-exit(this);
        return true;
    }

    private void d() {
        if (f2031a == false) goto L5;
    L9:
        ScheduledExecutorService r0 = this.n;
        if (r0 == null) goto L13;
        r0.execute(this.g);
        return;
    L13:
        return;
    L5:
        if (Thread.holdsLock(this) == true) goto L9;
        throw new AssertionError();
    }

    public void a() {
    L3:
        if (this.s != (-1)) goto L5;
        this.l.a();
        goto L3
    }

    @Override // com.bytedance.common.wschannel.channel.a.a.b.e.a
    public void a(int r4, String r5) {
        if (r4 == (-1)) goto L32;
        monitor-enter(this);
    L28:
        th = move-exception;
        throw th;
    L6:
        if (this.s != (-1)) goto L27;
        this.s = r4;     // Catch: Throwable -> L28
        this.t = r5;     // Catch: Throwable -> L28
        RealWebSocket.Streams r1 = null;
        if (this.q == true) goto L10;
    L15:
        monitor-exit(this);     // Catch: Throwable -> L28
        com.bytedance.common.wschannel.channel.a.a.b.c r0 = this.c;     // Catch: Throwable -> L23
        if (r0 == null) goto L21;
        r0.a(this, r4, r5);     // Catch: Throwable -> L23
        if (r1 == null) goto L21;
        this.c.b(this, r4, r5);     // Catch: Throwable -> L23
    L21:
        Util.closeQuietly(r1);
        return;
    L23:
        th = move-exception;
        Util.closeQuietly(r1);
        throw th;
    L10:
        if (this.i.isEmpty() == false) goto L15;
        RealWebSocket.Streams r2 = this.o;     // Catch: Throwable -> L28
        this.o = null;     // Catch: Throwable -> L28
        ScheduledFuture<?> r3 = this.r;     // Catch: Throwable -> L28
        if (r3 == null) goto L14;
        r3.cancel(false);     // Catch: Throwable -> L28
    L14:
        this.n.shutdown();     // Catch: Throwable -> L28
        r1 = r2;
        goto L15
    L27:
        throw new IllegalStateException("already closed");     // Catch: Throwable -> L28
    L32:
        throw new IllegalArgumentException();
    }

    public void a(Exception r4, Response r5) {
        monitor-enter(this);
    L22:
        th = move-exception;
        throw th;
    L4:
        if (this.u == false) goto L7;
        monitor-exit(this);     // Catch: Throwable -> L22
        return;
    L7:
        this.u = true;     // Catch: Throwable -> L22
        RealWebSocket.Streams r0 = this.o;     // Catch: Throwable -> L22
        this.o = null;     // Catch: Throwable -> L22
        ScheduledFuture<?> r1 = this.r;     // Catch: Throwable -> L22
        if (r1 == null) goto L10;
        r1.cancel(false);     // Catch: Throwable -> L22
    L10:
        ScheduledExecutorService r2 = this.n;     // Catch: Throwable -> L22
        if (r2 == null) goto L13;
        r2.shutdown();     // Catch: Throwable -> L22
    L13:
        monitor-exit(this);     // Catch: Throwable -> L22
        com.bytedance.common.wschannel.channel.a.a.b.c r3 = this.c;     // Catch: Throwable -> L19
        if (r3 == null) goto L17;
        r3.a(this, r4, r5);     // Catch: Throwable -> L19
    L17:
        Util.closeQuietly(r0);
        return;
    L19:
        th = move-exception;
        Util.closeQuietly(r0);
        throw th;
    }

    @Override // com.bytedance.common.wschannel.channel.a.a.b.e.a
    public void a(String r2) {
        com.bytedance.common.wschannel.channel.a.a.b.c r0 = this.c;
        if (r0 == null) goto L6;
        r0.a(this, r2);
        return;
    }

    public void a(String r7, RealWebSocket.Streams r8) {
        monitor-enter(this);
        this.o = r8;     // Catch: Throwable -> L9
        this.m = new f(r8.client, r8.sink, this.e);     // Catch: Throwable -> L9
        this.n = new ScheduledThreadPoolExecutor(1, Util.threadFactory(r7, false));     // Catch: Throwable -> L9
        if (this.i.isEmpty() == true) goto L6;
        d();     // Catch: Throwable -> L9
    L6:
        monitor-exit(this);     // Catch: Throwable -> L9
        this.l = new e(r8.client, r8.source, this, this.j);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public void a(OkHttpClient r4) {
        final Request r0 = a(this.d.newBuilder().header("Upgrade", "websocket").header("Connection", "Upgrade").header("Sec-WebSocket-Key", this.f).header("Sec-WebSocket-Version", "13").build());
        Call r5 = Internal.instance.newWebSocketCall(r4, r0);
        this.k = r5;
        r5.enqueue(new AnonymousClass2(this, r0));
    }

    void a(Response r5) {
        if (r5.code() != 101) goto L18;
        String r0 = r5.header("Connection");
        if ("Upgrade".equalsIgnoreCase(r0) == false) goto L16;
        String r1 = r5.header("Upgrade");
        if ("websocket".equalsIgnoreCase(r1) == false) goto L14;
        String r6 = r5.header("Sec-WebSocket-Accept");
        String r4 = ByteString.encodeUtf8(this.f + WebSocketProtocol.ACCEPT_MAGIC).sha1().base64();
        if (r4.equals(r6) == false) goto L12;
        return;
    L12:
        throw new ProtocolException("Expected 'Sec-WebSocket-Accept' header value '" + r4 + "' but was '" + r6 + "'");
    L14:
        throw new ProtocolException("Expected 'Upgrade' header value 'websocket' but was '" + r1 + "'");
    L16:
        throw new ProtocolException("Expected 'Connection' header value 'Upgrade' but was '" + r0 + "'");
    L18:
        throw new ProtocolException("Expected HTTP 101 response but was '" + r5.code() + " " + r5.message() + "'");
    }

    @Override // com.bytedance.common.wschannel.channel.a.a.b.e.a
    public void a(ByteString r2) {
        com.bytedance.common.wschannel.channel.a.a.b.c r0 = this.c;
        if (r0 == null) goto L6;
        r0.a(this, r2);
        return;
    }

    synchronized boolean a(int r6, String r7, long r8) {
        monitor-enter(this);
        com.bytedance.common.wschannel.channel.a.a.b.d.b(r6);     // Catch: Throwable -> L21
        ByteString r0 = null;
        if (r7 == null) goto L11;
        r0 = ByteString.encodeUtf8(r7);     // Catch: Throwable -> L21
        if (r0.size() <= 123) goto L11;
        throw new IllegalArgumentException("reason.size() > 123: " + r7);     // Catch: Throwable -> L21
    L11:
        if (this.u == true) goto L19;
        if (this.q == true) goto L19;
        this.q = true;     // Catch: Throwable -> L21
        this.i.add(new b(r6, r0, r8));     // Catch: Throwable -> L21
        d();     // Catch: Throwable -> L21
        monitor-exit(this);
        return true;
    L19:
        monitor-exit(this);
        return false;
    L21:
        th = move-exception;
        throw th;
    }

    public void b(int r2, String r3) {
        this.c = null;
        close(r2, r3);     // Catch: Throwable -> L5
        return;
    }

    @Override // com.bytedance.common.wschannel.channel.a.a.b.e.a
    public synchronized void b(ByteString r2) {
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L4:
        if (this.u == false) goto L6;
    L13:
        monitor-exit(this);
        return;
    L6:
        if (this.q == true) goto L8;
    L10:
        this.h.add(r2);     // Catch: Throwable -> L15
        d();     // Catch: Throwable -> L15
        this.w++;     // Catch: Throwable -> L15
        monitor-exit(this);
        return;
    L8:
        if (this.i.isEmpty() == false) goto L10;
        goto L10
    }

    boolean b() {
        monitor-enter(this);
    L48:
        th = move-exception;
        throw th;
    L4:
        if (this.u == false) goto L7;
        monitor-exit(this);     // Catch: Throwable -> L48
        return false;
    L7:
        f r0 = this.m;     // Catch: Throwable -> L48
        ByteString r2 = (ByteString) ZeusTransformUtils.preCheckCast(this.h.poll(), ByteString.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L48
        int r3 = -1;
        Object r4 = null;
        if (r2 != null) goto L20;
        Object r5 = this.i.poll();     // Catch: Throwable -> L48
        if (ZeusTransformUtils.instanceOf(r5, b.class) == false) goto L15;
        int r1 = this.s;     // Catch: Throwable -> L48
        String r6 = this.t;     // Catch: Throwable -> L48
        if (r1 == (-1)) goto L14;
        RealWebSocket.Streams r7 = this.o;     // Catch: Throwable -> L48
        this.o = null;     // Catch: Throwable -> L48
        this.n.shutdown();     // Catch: Throwable -> L48
        r4 = r5;
        r3 = r1;
        RealWebSocket.Streams r8 = r7;
    L21:
        monitor-exit(this);     // Catch: Throwable -> L48
        if (r2 == null) goto L25;
        r0.b(r2);     // Catch: Throwable -> L45
    L41:
        Util.closeQuietly(r8);
        return true;
    L25:
        if (ZeusTransformUtils.instanceOf(r4, c.class) == false) goto L35;
        ByteString r9 = ((c) ZeusTransformUtils.preCheckCast(r4, c.class, "com.obric.memorydata.plugin")).f2040b;     // Catch: Throwable -> L45
        BufferedSink r10 = Okio.buffer(r0.a(((c) ZeusTransformUtils.preCheckCast(r4, c.class, "com.obric.memorydata.plugin")).f2039a, r9.size()));     // Catch: Throwable -> L45
        r10.write(r9);     // Catch: Throwable -> L45
        r10.close();     // Catch: Throwable -> L45
        monitor-enter(this);     // Catch: Throwable -> L45
        this.p -= (long) r9.size();     // Catch: Throwable -> L31
        monitor-exit(this);     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        throw th;     // Catch: Throwable -> L45
    L35:
        if (ZeusTransformUtils.instanceOf(r4, b.class) == false) goto L44;
        b r11 = (b) ZeusTransformUtils.preCheckCast(r4, b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L45
        r0.a(r11.f2037a, r11.f2038b);     // Catch: Throwable -> L45
        if (r8 == null) goto L41;
        com.bytedance.common.wschannel.channel.a.a.b.c r12 = this.c;     // Catch: Throwable -> L45
        if (r12 == null) goto L41;
        r12.b(this, r3, r6);     // Catch: Throwable -> L45
        goto L41
    L44:
        throw new AssertionError();     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        Util.closeQuietly(r8);
        throw th;
    L14:
        this.r = this.n.schedule(new RunnableC0113a(this), ((b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin")).c, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L48
        r3 = r1;
        r8 = null;
    L19:
        r4 = r5;
        goto L21
    L15:
        if (r5 != null) goto L18;
        monitor-exit(this);     // Catch: Throwable -> L48
        return false;
    L18:
        r8 = null;
        r6 = null;
        goto L19
    L20:
        r8 = null;
        r6 = null;
        goto L21
    }

    @Override // com.bytedance.common.wschannel.channel.a.a.b.b
    public void c() {
        ScheduledExecutorService r0 = this.n;
        if (r0 == null) goto L6;
        r0.execute(new d(this));
        return;
    }

    @Override // com.bytedance.common.wschannel.channel.a.a.b.e.a
    public synchronized void c(ByteString r2) {
        monitor-enter(this);
        this.x++;     // Catch: Throwable -> L8
        this.y = false;     // Catch: Throwable -> L8
        com.bytedance.common.wschannel.channel.a.a.b.c r0 = this.c;     // Catch: Throwable -> L8
        if (r0 == null) goto L6;
        r0.b(this, r2);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // okhttp3.WebSocket
    public void cancel() {
        this.k.cancel();
    }

    @Override // okhttp3.WebSocket
    public boolean close(int r3, String r4) {
        return a(r3, r4, 60000);
    }

    void d(ByteString r6) {
        monitor-enter(this);
    L23:
        th = move-exception;
        throw th;
    L4:
        if (this.u == false) goto L7;
        monitor-exit(this);     // Catch: Throwable -> L23
        return;
    L7:
        f r0 = this.m;     // Catch: Throwable -> L23
        if (this.y == false) goto L10;
        int r1 = this.v;     // Catch: Throwable -> L23
    L11:
        this.v++;     // Catch: Throwable -> L23
        this.y = true;     // Catch: Throwable -> L23
        monitor-exit(this);     // Catch: Throwable -> L23
        if (r1 == (-1)) goto L17;
        a(new SocketTimeoutException(WsConstants.PING_NOT_RECEIVE_PONG_MSG), null);
        return;
    L17:
        if (r0 == null) goto L29;
        r0.a(r6);     // Catch: IOException -> L20
        return;
    L20:
        e = move-exception;
        a(e, null);
        return;
    L29:
        return;
    L10:
        r1 = -1;
        goto L11
    }

    @Override // okhttp3.WebSocket
    public synchronized long queueSize() {
        monitor-enter(this);
        long r0 = this.p;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // okhttp3.WebSocket
    public Request request() {
        return this.d;
    }

    @Override // okhttp3.WebSocket
    public boolean send(String r2) {
        Objects.requireNonNull(r2, "text == null");
        return a(ByteString.encodeUtf8(r2), 1);
    }

    @Override // okhttp3.WebSocket
    public boolean send(ByteString r2) {
        Objects.requireNonNull(r2, "bytes == null");
        return a(r2, 2);
    }
}
