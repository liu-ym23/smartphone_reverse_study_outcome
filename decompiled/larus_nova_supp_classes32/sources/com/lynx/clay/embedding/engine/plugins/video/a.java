package com.lynx.clay.embedding.engine.plugins.video;

import android.content.Context;
import android.view.Surface;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public interface a {

    /* JADX INFO: renamed from: com.lynx.clay.embedding.engine.plugins.video.a$a, reason: collision with other inner class name */
    public interface InterfaceC0040a {
        void onBufferingChange(int r1);

        void onCanPlay();

        void onEnded();

        void onError(int r1, String r2, String r3);

        void onFirstFrame();

        void onPause();

        void onPlay();

        void onPlaying();

        void onPrepared(int r1);

        void onVideoInfos(String r1, long r2);

        void onVideoSizeChanged(int r1, int r2);

        void onWaiting();
    }

    void a();

    void b(boolean r1);

    void c();

    View createView(Context r1);

    void d();

    void dispose();

    void e();

    void enterBackground();

    void enterForeground();

    void f(boolean r1);

    void g();

    int getDuration();

    int getPosition();

    void h(int r1);

    void i(String r1);

    void j(boolean r1);

    void pause();

    void play();

    void seekTo(int r1);

    void setLoop(boolean r1);

    void setMuted(boolean r1);

    void setSpeed(float r1);

    void setSrc(String r1);

    void setSurface(Surface r1);

    void setVolume(double r1);

    void stop();
}
