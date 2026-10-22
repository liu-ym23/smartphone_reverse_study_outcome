package vq1;

import com.bytedance.android.livesdkapi.depend.model.live.episode.EnterVideoResult;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface b {

    public interface a {
        void a(int r1, String r2, String r3, String r4);

        void b(EnterVideoResult r1);

        void c(EnterVideoResult r1);
    }

    void start();

    void stop();
}
