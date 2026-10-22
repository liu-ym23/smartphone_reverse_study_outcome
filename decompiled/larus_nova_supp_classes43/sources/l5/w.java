package l5;

import android.os.Handler;
import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.bridge.protocol.model.ProtocolMessage;
import com.bytedance.ai.monitor.bridge.TraceType;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class w implements j4.a {
    public static final w b = null;
    public static final Map<String, a0> c = null;
    public static final Lazy d = null;
    public static final c0 e = null;
    public static final d0 f = null;
    public static final e0 g = null;
    public static final f0 h = null;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[TraceType.values().length];
            r0[TraceType.FE_CALL_FE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[TraceType.FE_CALL_NATIVE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[TraceType.NATIVE_EVENT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[TraceType.NONE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    public w() {
    }

    static {
        b = new w();
        c = new LinkedHashMap();
        d = LazyKt.lazy(new l5.a());
        e = new c0();
        f = new d0();
        g = new e0();
        h = new f0();
    }

    public static void m(final Function0 r10) {
        Intrinsics.checkNotNullParameter(r10, "runnable");
        ((Handler) d.getValue()).post(new u(r10));
    }

    @Override // j4.a
    public final void a(final String r10) {
        Intrinsics.checkNotNullParameter(r10, "containerId");
        m(new p(r10));
    }

    @Override // j4.a
    public final void c(final String r10) {
        Intrinsics.checkNotNullParameter(r10, "traceId");
        final long r0 = System.currentTimeMillis();
        m(new m(r10, r0));
    }

    @Override // j4.a
    public final void d(final String r10) {
        Intrinsics.checkNotNullParameter(r10, "traceId");
        final long r0 = System.currentTimeMillis();
        m(new r(r10, r0));
    }

    @Override // j4.a
    public final void h(final String r10) {
        Intrinsics.checkNotNullParameter(r10, "traceId");
        final long r0 = System.currentTimeMillis();
        m(new o(r10, r0));
    }

    @Override // j4.a
    public final void j(final String r10) {
        Intrinsics.checkNotNullParameter(r10, "traceId");
        final long r0 = System.currentTimeMillis();
        m(new n(r10, r0));
    }

    @Override // j4.a
    public final void markError(final String r10) {
        Intrinsics.checkNotNullParameter(r10, "traceId");
        m(new l(r10));
    }

    @Override // j4.a
    public final void b(final String r10, final ProtocolMessage r11) {
        Intrinsics.checkNotNullParameter(r10, "traceId");
        Intrinsics.checkNotNullParameter(r11, "callbackMsg");
        final long r0 = System.currentTimeMillis();
        m(new k(r11, r10, r0));
    }

    @Override // j4.a
    public final void e(final String r10, final long r11) {
        Intrinsics.checkNotNullParameter(r10, "traceId");
        m(new j(r11, r10));
    }

    @Override // j4.a
    public final void i(final String r10, final m4.c r11) {
        Intrinsics.checkNotNullParameter(r10, "traceId");
        final long r0 = System.currentTimeMillis();
        m(new s(r10, r0, r11));
    }

    @Override // j4.a
    public final void k(final String r10, final ContainerType r11) {
        Intrinsics.checkNotNullParameter(r10, "traceId");
        Intrinsics.checkNotNullParameter(r11, "containerType");
        final long r0 = System.currentTimeMillis();
        m(new f(r11, r10, r0));
    }

    @Override // j4.a
    public final void l(final String r10, final m4.c r11) {
        Intrinsics.checkNotNullParameter(r10, "traceId");
        final long r0 = System.currentTimeMillis();
        m(new g(r10, r0, r11));
    }

    @Override // j4.a
    public final void f(final String r10, final d3.a0 r11, final String r12) {
        Intrinsics.checkNotNullParameter(r10, "traceId");
        Intrinsics.checkNotNullParameter(r12, "eventName");
        final long r13 = System.currentTimeMillis();
        m(new t(r10, r11, r13, r12));
    }

    @Override // j4.a
    public final void g(final String r10, final long r11, final d3.a0 r12, final String r13, final m4.c r14) {
        Intrinsics.checkNotNullParameter(r10, "traceId");
        Intrinsics.checkNotNullParameter(r13, "callName");
        m(new q(r11, r12, r13, r10, r14));
    }
}
