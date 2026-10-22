package u68;

import com.larus.audio.call.play.abs.TtsPlayEndType;
import com.larus.audio.call.play.f;
import com.larus.audio.call.play.h;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public interface a {

    /* JADX INFO: renamed from: u68.a$a, reason: collision with other inner class name */
    public static final class C0130a {
        public static /* synthetic */ void a(a r1, boolean r2, String r3, int r4) {
            if ((r4 & 2) == 0) goto L5;
            r2 = false;
        L5:
            r1.k(false, r2, r3);
        }
    }

    public interface b {

        /* JADX INFO: renamed from: u68.a$b$a, reason: collision with other inner class name */
        public static final class C0131a {
            public static /* synthetic */ void a(f r1) {
                r1.f(TtsPlayEndType.NORMAL);
            }
        }

        void a();

        void b(Map<String, String> r1);

        void c();

        void d(h.a r1);

        void e(boolean r1);

        void f(TtsPlayEndType r1);

        void g(byte[] r1);

        void i(byte[] r1);

        void onPaused();

        void onPlayComplete();

        void onResume();
    }

    void a();

    void b();

    void c(boolean r1);

    void d(boolean r1, boolean r2, String r3);

    void e(boolean r1);

    void h();

    void i(b r1);

    boolean isPlaying();

    void j(b r1);

    void k(boolean r1, boolean r2, String r3);

    void pause(String r1);

    void release(boolean r1);

    void resume(String r1);

    void setVolume(float r1);
}
