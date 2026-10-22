package mc;

import java.util.List;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.http2.ErrorCode;

/* JADX INFO: loaded from: classes3.dex */
public interface f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @JvmField
    public static final f f11150a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f11151a = null;

        /* JADX INFO: renamed from: mc.f$a$a, reason: collision with other inner class name */
        private static final class C0244a implements f {
            public C0244a() {
            }

            @Override // mc.f
            public boolean a(int r10, List<mc.a> r11) {
                Intrinsics.checkNotNullParameter(r11, "requestHeaders");
                return true;
            }

            @Override // mc.f
            public boolean b(int r10, List<mc.a> r11, boolean r12) {
                Intrinsics.checkNotNullParameter(r11, "responseHeaders");
                return true;
            }

            @Override // mc.f
            public void c(int r10, ErrorCode r11) {
                Intrinsics.checkNotNullParameter(r11, "errorCode");
            }

            @Override // mc.f
            public boolean d(int r10, okio.f r11, int r12, boolean r13) {
                Intrinsics.checkNotNullParameter(r11, "source");
                r11.skip(r12);
                return true;
            }
        }

        static {
            f11151a = new a();
        }

        private a() {
        }
    }

    static {
        a r10 = a.f11151a;
        f11150a = new a.C0244a();
    }

    boolean a(int r10, List<mc.a> r11);

    boolean b(int r10, List<mc.a> r11, boolean r12);

    void c(int r10, ErrorCode r11);

    boolean d(int r10, okio.f r11, int r12, boolean r13);
}
