package kotlinx.coroutines.channels;

import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KFunction;
import kotlinx.coroutines.internal.i0;
import kotlinx.coroutines.internal.j0;

/* JADX INFO: loaded from: classes3.dex */
public final class BufferedChannelKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final h<Object> f10292a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @JvmField
    public static final int f10293b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f10294c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @JvmField
    public static final i0 f10295d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final i0 f10296e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final i0 f10297f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final i0 f10298g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final i0 f10299h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final i0 f10300i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final i0 f10301j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final i0 f10302k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final i0 f10303l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final i0 f10304m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final i0 f10305n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final i0 f10306o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final i0 f10307p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final i0 f10308q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final i0 f10309r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final i0 f10310s = null;

    static {
        f10292a = new h(-1, null, null, 0);
        f10293b = j0.g("kotlinx.coroutines.bufferedChannel.segmentSize", 32, 0, 0, 12, null);
        f10294c = j0.g("kotlinx.coroutines.bufferedChannel.expandBufferCompletionWaitIterations", 10000, 0, 0, 12, null);
        f10295d = new i0("BUFFERED");
        f10296e = new i0("SHOULD_BUFFER");
        f10297f = new i0("S_RESUMING_BY_RCV");
        f10298g = new i0("RESUMING_BY_EB");
        f10299h = new i0("POISONED");
        f10300i = new i0("DONE_RCV");
        f10301j = new i0("INTERRUPTED_SEND");
        f10302k = new i0("INTERRUPTED_RCV");
        f10303l = new i0("CHANNEL_CLOSED");
        f10304m = new i0("SUSPEND");
        f10305n = new i0("SUSPEND_NO_WAITER");
        f10306o = new i0("FAILED");
        f10307p = new i0("NO_RECEIVE_RESULT");
        f10308q = new i0("CLOSE_HANDLER_CLOSED");
        f10309r = new i0("CLOSE_HANDLER_INVOKED");
        f10310s = new i0("NO_CLOSE_CAUSE");
    }

    private static final long A(int r10) {
        if (r10 != 0) goto L4;
        return 0;
    L4:
        if (r10 != Integer.MAX_VALUE) goto L9;
        return Long.MAX_VALUE;
    L9:
        return r10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <T> boolean B(kotlinx.coroutines.n<? super T> r10, T r11, Function1<? super Throwable, Unit> r12) {
        Object r13 = r10.k(r11, null, r12);
        if (r13 == null) goto L5;
        r10.N(r13);
        return true;
    L5:
        return false;
    }

    static /* synthetic */ boolean C(kotlinx.coroutines.n r10, Object r11, Function1 r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r12 = null;
    L6:
        return B(r10, r11, r12);
    }

    public static final /* synthetic */ long a(long r10, boolean r11) {
        return v(r10, r11);
    }

    public static final /* synthetic */ long b(long r10, int r11) {
        return w(r10, r11);
    }

    public static final /* synthetic */ h c(long r10, h r11) {
        return x(r10, r11);
    }

    public static final /* synthetic */ i0 d() {
        return f10308q;
    }

    public static final /* synthetic */ i0 e() {
        return f10309r;
    }

    public static final /* synthetic */ i0 f() {
        return f10300i;
    }

    public static final /* synthetic */ int g() {
        return f10294c;
    }

    public static final /* synthetic */ i0 h() {
        return f10306o;
    }

    public static final /* synthetic */ i0 i() {
        return f10302k;
    }

    public static final /* synthetic */ i0 j() {
        return f10301j;
    }

    public static final /* synthetic */ i0 k() {
        return f10296e;
    }

    public static final /* synthetic */ i0 l() {
        return f10310s;
    }

    public static final /* synthetic */ i0 m() {
        return f10307p;
    }

    public static final /* synthetic */ h n() {
        return f10292a;
    }

    public static final /* synthetic */ i0 o() {
        return f10299h;
    }

    public static final /* synthetic */ i0 p() {
        return f10298g;
    }

    public static final /* synthetic */ i0 q() {
        return f10297f;
    }

    public static final /* synthetic */ i0 r() {
        return f10304m;
    }

    public static final /* synthetic */ i0 s() {
        return f10305n;
    }

    public static final /* synthetic */ long t(int r10) {
        return A(r10);
    }

    public static final /* synthetic */ boolean u(kotlinx.coroutines.n r10, Object r11, Function1 r12) {
        return B(r10, r11, r12);
    }

    private static final long v(long r10, boolean r11) {
        if (r11 == false) goto L4;
        long r12 = 4611686018427387904L;
    L6:
        return r12 + r10;
    L4:
        r12 = 0;
        goto L6
    }

    private static final long w(long r10, int r11) {
        return (((long) r11) << 60) + r10;
    }

    private static final <E> h<E> x(long r10, h<E> r11) {
        return new h(r10, r11, r11.u(), 0);
    }

    public static final <E> KFunction<h<E>> y() {
        return BufferedChannelKt$createSegmentFunction$1.INSTANCE;
    }

    public static final i0 z() {
        return f10303l;
    }
}
