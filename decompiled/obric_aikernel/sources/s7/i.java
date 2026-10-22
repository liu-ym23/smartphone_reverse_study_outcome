package s7;

import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

/* JADX INFO: loaded from: classes2.dex */
public interface i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12731a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f12732a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final long f12733b = 0;

        static {
            f12732a = new a();
            Duration.Companion r10 = Duration.Companion;
            f12733b = Duration.m1430toLongimpl(DurationKt.toDuration(5, DurationUnit.MINUTES), DurationUnit.MILLISECONDS);
        }

        private a() {
        }

        public final long a() {
            return f12733b;
        }
    }

    static {
        f12731a = a.f12732a;
    }

    int a();

    long b();

    long c();

    long d();

    boolean e();

    long f();
}
