package t52;

import android.content.Context;
import com.bytedance.android.livesdkapi.depend.model.broadcast.IBroadcastStream;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public interface a {

    /* JADX INFO: renamed from: t52.a$a, reason: collision with other inner class name */
    public static class C0282a {
        public final String a;

        public C0282a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "info");
            this.a = r2;
        }
    }

    public interface b {
        void a(C0282a r1);

        void b(C0282a r1);

        void c(C0282a r1);
    }

    C0282a getPlaying();

    boolean isPlaying();

    void playAudioByPath(Context r1, C0282a r2);

    void playAudioByUrl(Context r1, C0282a r2);

    void register(b r1);

    void setLiveStream(IBroadcastStream r1);

    void stopAudio();

    void unregister(b r1);
}
