package qja;

import android.view.Surface;
import java.io.IOException;
import oja.e;
import oja.f;
import oja.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public interface c {

    public interface a {
        void onCompletion();
    }

    public interface b {
        void onError();
    }

    /* JADX INFO: renamed from: qja.c$c, reason: collision with other inner class name */
    public interface InterfaceC0068c {
        void onFirstFrame();
    }

    public interface d {
        void onPrepared();
    }

    void a();

    void b() throws Exception;

    void c();

    void d() throws IOException;

    void e(e r1);

    void f(g r1);

    void g(oja.d r1);

    pja.c getVideoInfo() throws Exception;

    void h(f r1);

    void pause();

    void prepareAsync();

    void release();

    void reset();

    void setSurface(Surface r1);

    void start();

    void stop();
}
