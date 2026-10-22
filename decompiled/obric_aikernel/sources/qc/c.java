package qc;

import java.security.cert.Certificate;
import java.util.List;
import javax.net.ssl.X509TrustManager;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.platform.h;

/* JADX INFO: loaded from: classes3.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12505a = null;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final c a(X509TrustManager r10) {
            Intrinsics.checkNotNullParameter(r10, "trustManager");
            return h.f11979a.g().c(r10);
        }
    }

    static {
        f12505a = new a(null);
    }

    public c() {
    }

    public abstract List<Certificate> a(List<? extends Certificate> r10, String r11);
}
