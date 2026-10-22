package kotlinx.coroutines.channels;

import com.bytedance.ai.ex.widget.model.MiniAppWidgetAvailability;
import com.bytedance.keva.KevaImpl;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes3.dex */
public abstract class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o f18797a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f18798b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f18799c = 0;
    public static final g8.g d = null;
    public static final g8.g e = null;
    public static final g8.g f = null;
    public static final g8.g g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final g8.g f18800h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final g8.g f18801i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final g8.g f18802j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final g8.g f18803k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final g8.g f18804l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final g8.g f18805m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final g8.g f18806n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final g8.g f18807o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final g8.g f18808p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final g8.g f18809q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final g8.g f18810r = null;
    public static final g8.g s = null;

    static {
        f18797a = new o(-1, null, null, 0);
        f18798b = kotlinx.coroutines.internal.f.j("kotlinx.coroutines.bufferedChannel.segmentSize", 32, 0, 0, 12);
        f18799c = kotlinx.coroutines.internal.f.j("kotlinx.coroutines.bufferedChannel.expandBufferCompletionWaitIterations", KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD, 0, 0, 12);
        d = new g8.g("BUFFERED", 10);
        e = new g8.g("SHOULD_BUFFER", 10);
        f = new g8.g("S_RESUMING_BY_RCV", 10);
        g = new g8.g("RESUMING_BY_EB", 10);
        f18800h = new g8.g("POISONED", 10);
        f18801i = new g8.g("DONE_RCV", 10);
        f18802j = new g8.g("INTERRUPTED_SEND", 10);
        f18803k = new g8.g("INTERRUPTED_RCV", 10);
        f18804l = new g8.g("CHANNEL_CLOSED", 10);
        f18805m = new g8.g("SUSPEND", 10);
        f18806n = new g8.g("SUSPEND_NO_WAITER", 10);
        f18807o = new g8.g(MiniAppWidgetAvailability.INSTALL_STATE_FAILED, 10);
        f18808p = new g8.g("NO_RECEIVE_RESULT", 10);
        f18809q = new g8.g("CLOSE_HANDLER_CLOSED", 10);
        f18810r = new g8.g("CLOSE_HANDLER_INVOKED", 10);
        s = new g8.g("NO_CLOSE_CAUSE", 10);
    }

    public static final boolean a(kotlinx.coroutines.j r5, Object r10, Function3 r11) {
        g8.g r12 = r5.c(r10, r11);
        if (r12 == null) goto L5;
        r5.s(r12);
        return true;
    L5:
        return false;
    }
}
