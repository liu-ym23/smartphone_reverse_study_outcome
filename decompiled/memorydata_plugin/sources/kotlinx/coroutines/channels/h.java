package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.memorydata.database.entity.RawObservationEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KFunction;
import kotlinx.coroutines.internal.aj;
import kotlinx.coroutines.internal.ak;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u0018\u00106\u001a\u00020\u00032\u0006\u00107\u001a\u00020\u00032\u0006\u00108\u001a\u00020.H\u0002\u001a\u0018\u00109\u001a\u00020\u00032\u0006\u00107\u001a\u00020\u00032\u0006\u0010:\u001a\u00020\u000bH\u0002\u001a*\u0010;\u001a\b\u0012\u0004\u0012\u0002H<0\u001a\"\u0004\b\u0000\u0010<2\u0006\u0010=\u001a\u00020\u00032\f\u0010>\u001a\b\u0012\u0004\u0012\u0002H<0\u001aH\u0002\u001a,\u0010?\u001a \u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u0002H<0\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u0002H<0\u001a0@\"\u0004\b\u0000\u0010<H\u0000\u001a\u0010\u0010A\u001a\u00020\u00032\u0006\u0010B\u001a\u00020\u000bH\u0002\u001aL\u0010C\u001a\u00020.\"\u0004\b\u0000\u0010D*\b\u0012\u0004\u0012\u0002HD0E2\u0006\u0010F\u001a\u0002HD2%\b\u0002\u0010G\u001a\u001f\u0012\u0013\u0012\u00110I¢\u0006\f\bJ\u0012\b\bK\u0012\u0004\b\b(L\u0012\u0004\u0012\u00020M\u0018\u00010HH\u0002¢\u0006\u0002\u0010N\"\u0010\u0010\u0000\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u0014\u0010\u0005\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u000e\u0010\b\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0014\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0015\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0016\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0017\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0018\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0016\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u001c\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u001d\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001e\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001f\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010 \u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010!\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\"\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010#\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010$\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010%\u001a\u00020\u000b8\u0000X\u0081\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010&\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010'\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010(\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010)\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0019\u0010*\u001a\u00020\u0003*\u00020\u00038Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,\"\u0019\u0010-\u001a\u00020.*\u00020\u00038Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b/\u00100\"\u0019\u00101\u001a\u00020\u000b*\u00020\u00038Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b2\u00103\"\u0019\u00104\u001a\u00020\u0003*\u00020\u00038Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b5\u0010,¨\u0006O"}, d2 = {"BUFFERED", "Lkotlinx/coroutines/internal/Symbol;", "BUFFER_END_RENDEZVOUS", "", "BUFFER_END_UNLIMITED", "CHANNEL_CLOSED", "getCHANNEL_CLOSED", "()Lkotlinx/coroutines/internal/Symbol;", "CLOSE_HANDLER_CLOSED", "CLOSE_HANDLER_INVOKED", "CLOSE_STATUS_ACTIVE", "", "CLOSE_STATUS_CANCELLATION_STARTED", "CLOSE_STATUS_CANCELLED", "CLOSE_STATUS_CLOSED", "DONE_RCV", "EB_COMPLETED_COUNTER_MASK", "EB_COMPLETED_PAUSE_EXPAND_BUFFERS_BIT", "EXPAND_BUFFER_COMPLETION_WAIT_ITERATIONS", RawObservationEntity.STATE_FAILED, "INTERRUPTED_RCV", "INTERRUPTED_SEND", "IN_BUFFER", "NO_CLOSE_CAUSE", "NO_RECEIVE_RESULT", "NULL_SEGMENT", "Lkotlinx/coroutines/channels/ChannelSegment;", "", "POISONED", "RESULT_BUFFERED", "RESULT_CLOSED", "RESULT_FAILED", "RESULT_RENDEZVOUS", "RESULT_SUSPEND", "RESULT_SUSPEND_NO_WAITER", "RESUMING_BY_EB", "RESUMING_BY_RCV", "SEGMENT_SIZE", "SENDERS_CLOSE_STATUS_SHIFT", "SENDERS_COUNTER_MASK", "SUSPEND", "SUSPEND_NO_WAITER", "ebCompletedCounter", "getEbCompletedCounter", "(J)J", "ebPauseExpandBuffers", "", "getEbPauseExpandBuffers", "(J)Z", "sendersCloseStatus", "getSendersCloseStatus", "(J)I", "sendersCounter", "getSendersCounter", "constructEBCompletedAndPauseFlag", "counter", "pauseEB", "constructSendersAndCloseStatus", "closeStatus", "createSegment", ExifInterface.LONGITUDE_EAST, OaidModel.KEY_ID, "prev", "createSegmentFunction", "Lkotlin/reflect/KFunction2;", "initialBufferEnd", "capacity", "tryResume0", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CancellableContinuation;", EventBody.KEY_VALUE, "onCancellation", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "cause", "", "(Lkotlinx/coroutines/CancellableContinuation;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Z", "kotlinx-coroutines-core"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f17284a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final aj f17285b = null;
    private static final n<Object> c = null;
    private static final int d = 0;
    private static final aj e = null;
    private static final aj f = null;
    private static final aj g = null;
    private static final aj h = null;
    private static final aj i = null;
    private static final aj j = null;
    private static final aj k = null;
    private static final aj l = null;
    private static final aj m = null;
    private static final aj n = null;
    private static final aj o = null;
    private static final aj p = null;
    private static final aj q = null;
    private static final aj r = null;
    private static final aj s = null;

    static {
        c = new n(-1, null, null, 0);
        f17284a = ak.a("kotlinx.coroutines.bufferedChannel.segmentSize", 32, 0, 0, 12, null);
        d = ak.a("kotlinx.coroutines.bufferedChannel.expandBufferCompletionWaitIterations", 10000, 0, 0, 12, null);
        f17285b = new aj("BUFFERED");
        e = new aj("SHOULD_BUFFER");
        f = new aj("S_RESUMING_BY_RCV");
        g = new aj("RESUMING_BY_EB");
        h = new aj("POISONED");
        i = new aj("DONE_RCV");
        j = new aj("INTERRUPTED_SEND");
        k = new aj("INTERRUPTED_RCV");
        l = new aj("CHANNEL_CLOSED");
        m = new aj("SUSPEND");
        n = new aj("SUSPEND_NO_WAITER");
        o = new aj(RawObservationEntity.STATE_FAILED);
        p = new aj("NO_RECEIVE_RESULT");
        q = new aj("CLOSE_HANDLER_CLOSED");
        r = new aj("CLOSE_HANDLER_INVOKED");
        s = new aj("NO_CLOSE_CAUSE");
    }

    public static final /* synthetic */ long a(int r2) {
        return b(r2);
    }

    public static final /* synthetic */ long a(long r0, int r2) {
        return b(r0, r2);
    }

    public static final /* synthetic */ long a(long r0, boolean r2) {
        return b(r0, r2);
    }

    public static final <E> KFunction<n<E>> a() {
        return (KFunction) ZeusTransformUtils.preCheckCast(BufferedChannelKt$createSegmentFunction$1.INSTANCE, KFunction.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ n a(long r0, n r2) {
        return b(r0, r2);
    }

    public static final /* synthetic */ boolean a(kotlinx.coroutines.n r2, Object r3, Function1 r4) {
        return b((kotlinx.coroutines.n) ZeusTransformUtils.wrapperContextForParams(r2, kotlinx.coroutines.n.class, "com.obric.memorydata.plugin"), r3, (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin"));
    }

    static /* synthetic */ boolean a(kotlinx.coroutines.n r1, Object r2, Function1 r3, int r4, Object r5) {
        kotlinx.coroutines.n r6 = (kotlinx.coroutines.n) ZeusTransformUtils.wrapperContextForParams(r1, kotlinx.coroutines.n.class, "com.obric.memorydata.plugin");
        Function1 r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L6;
        r7 = null;
    L6:
        return b(r6, r2, r7);
    }

    private static final long b(int r2) {
        if (r2 != 0) goto L4;
        return 0;
    L4:
        if (r2 != Integer.MAX_VALUE) goto L9;
        return Long.MAX_VALUE;
    L9:
        return r2;
    }

    private static final long b(long r2, int r4) {
        return (((long) r4) << 60) + r2;
    }

    private static final long b(long r2, boolean r4) {
        if (r4 == false) goto L4;
        long r0 = 4611686018427387904L;
    L6:
        return r0 + r2;
    L4:
        r0 = 0;
        goto L6
    }

    private static final <E> n<E> b(long r7, n<E> r9) {
        return new n(r7, r9, r9.a(), 0);
    }

    public static final aj b() {
        return l;
    }

    private static final <T> boolean b(kotlinx.coroutines.n<? super T> r2, T r3, Function1<? super Throwable, Unit> r4) {
        kotlinx.coroutines.n r5 = (kotlinx.coroutines.n) ZeusTransformUtils.wrapperContextForParams(r2, kotlinx.coroutines.n.class, "com.obric.memorydata.plugin");
        Object r6 = r5.a(r3, null, (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin"));
        if (r6 == null) goto L5;
        r5.a(r6);
        return true;
    L5:
        return false;
    }

    public static final /* synthetic */ n c() {
        return c;
    }

    public static final /* synthetic */ aj d() {
        return s;
    }

    public static final /* synthetic */ aj e() {
        return j;
    }

    public static final /* synthetic */ aj f() {
        return i;
    }

    public static final /* synthetic */ aj g() {
        return k;
    }

    public static final /* synthetic */ aj h() {
        return e;
    }

    public static final /* synthetic */ aj i() {
        return h;
    }

    public static final /* synthetic */ aj j() {
        return o;
    }

    public static final /* synthetic */ aj k() {
        return m;
    }

    public static final /* synthetic */ aj l() {
        return n;
    }

    public static final /* synthetic */ aj m() {
        return g;
    }

    public static final /* synthetic */ aj n() {
        return f;
    }

    public static final /* synthetic */ int o() {
        return d;
    }

    public static final /* synthetic */ aj p() {
        return p;
    }

    public static final /* synthetic */ aj q() {
        return q;
    }

    public static final /* synthetic */ aj r() {
        return r;
    }
}
