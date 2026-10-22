package si0;

import android.view.ViewGroup;
import com.bytedance.android.live.broadcastgame.api.xplay.f;
import hg6.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public interface b {

    public static final class a {
        public final boolean a;
        public final ViewGroup b;
        public final ViewGroup c;
        public final ViewGroup d;
        public final g e;

        public a(boolean r1, ViewGroup r2, ViewGroup r3, ViewGroup r4, g r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }
    }

    void a(ViewGroup r1);

    void b(boolean r1);

    void c(a r1, f r2);

    void d();

    void onCreate();

    void onDestroy();
}
