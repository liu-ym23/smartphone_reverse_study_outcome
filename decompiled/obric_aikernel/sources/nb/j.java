package nb;

import com.ss.android.socialbase.downloader.network.NetworkQuality;
import qb.q;

/* JADX INFO: loaded from: classes2.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private q f11328a;

    static /* synthetic */ class a {
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final j f11329a = null;

        static {
            f11329a = new j(null);
        }
    }

    public interface c {
        void a(NetworkQuality r10);
    }

    private j() {
        this.f11328a = (q) qb.k.a(q.class);
    }

    /* synthetic */ j(a r10) {
        this();
    }

    public static j b() {
        return b.f11329a;
    }

    public void a(long r10, long r11) {
        this.f11328a.a(r10, r11);
    }
}
