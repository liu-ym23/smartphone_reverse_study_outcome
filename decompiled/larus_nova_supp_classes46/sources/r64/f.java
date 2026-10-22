package r64;

import android.view.Surface;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public interface f {
    void a(Surface r1);

    void b(List r1, String r2);

    int c();

    void d(float r1);

    float e();

    void f(b r1);

    void g();

    long getCurrentPosition();

    long getDuration();

    String getPlayId();

    void getPlayerType();

    long getWatchDuration();

    boolean h();

    void i(b r1);

    boolean isPlaying();

    void j(com.bytedance.awemeopen.infra.base.player.a r1);

    void pause();

    void release();

    void resume();

    void seekTo(long r1);

    void setIsMute(boolean r1);

    void stop();
}
