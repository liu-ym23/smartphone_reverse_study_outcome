package com.bytedance.awemeopen.infra.base.player;

import android.graphics.Bitmap;
import android.view.Surface;
import android.widget.FrameLayout;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public interface g {
    void a(Surface r1);

    boolean b();

    void c(Surface r1, j r2);

    void d(float r1);

    void e(j r1);

    void f(m r1);

    String g();

    long getCurrentPosition();

    long getDuration();

    float getPlaySpeed();

    PlayState getPlayState();

    String getPlayerType();

    long getWatchDuration();

    Bitmap h(long r1);

    void i(FrameLayout r1);

    boolean isPlaying();

    void j(List<j> r1, boolean r2, String r3);

    void k(k r1);

    void pause();

    void release();

    void resume();

    void seekTo(long r1);

    void setIsMute(boolean r1);
}
