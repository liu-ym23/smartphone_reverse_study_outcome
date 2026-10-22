package kq1;

import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface a {

    /* JADX INFO: renamed from: kq1.a$a, reason: collision with other inner class name */
    public static final class C0397a {
        public static /* synthetic */ boolean a(a r1, boolean r2, Boolean r3, int r4) {
            if ((r4 & 2) == 0) goto L5;
            Boolean r0 = Boolean.FALSE;
        L7:
            if ((r4 & 4) == 0) goto L10;
            r3 = Boolean.FALSE;
        L10:
            return r1.e(r2, r0, r3);
        L5:
            r0 = null;
            goto L7
        }
    }

    void b();

    void c(Map<String, String> r1, Episode r2);

    d d();

    boolean e(boolean r1, Boolean r2, Boolean r3);

    Map<String, String> f(Episode r1);
}
