package okio;

import com.bytedance.crash.dumper.Scraps;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nTimeout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Timeout.kt\nokio/Timeout\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,316:1\n1#2:317\n*E\n"})
public class g0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @JvmField
    public static final g0 f12214d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f12215a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f12216b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f12217c;

    public static final class a extends g0 {
        a() {
        }

        @Override // okio.g0
        public g0 d(long r10) {
            return this;
        }

        @Override // okio.g0
        public void f() {
        }

        @Override // okio.g0
        public g0 g(long r10, TimeUnit r11) {
            Intrinsics.checkNotNullParameter(r11, Scraps.INNER_UNIT);
            return this;
        }
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        new b(null);
        f12214d = new a();
    }

    public g0() {
    }

    public g0 a() {
        this.f12215a = false;
        return this;
    }

    public g0 b() {
        this.f12217c = 0;
        return this;
    }

    public long c() {
        if (this.f12215a == false) goto L7;
        return this.f12216b;
    L7:
        throw new IllegalStateException("No deadline".toString());
    }

    public g0 d(long r10) {
        this.f12215a = true;
        this.f12216b = r10;
        return this;
    }

    public boolean e() {
        return this.f12215a;
    }

    public void f() {
        if (Thread.currentThread().isInterrupted() == true) goto L13;
        if (this.f12215a == true) goto L7;
        return;
    L7:
        if ((this.f12216b - System.nanoTime()) <= 0) goto L10;
        return;
    L10:
        throw new InterruptedIOException("deadline reached");
    L13:
        throw new InterruptedIOException("interrupted");
    }

    public g0 g(long r10, TimeUnit r11) {
        Intrinsics.checkNotNullParameter(r11, Scraps.INNER_UNIT);
        if (r10 < 0) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L10;
        this.f12217c = r11.toNanos(r10);
        return this;
    L10:
        throw new IllegalArgumentException(("timeout < 0: " + r10).toString());
    L5:
        r12 = false;
        goto L6
    }

    public long h() {
        return this.f12217c;
    }
}
