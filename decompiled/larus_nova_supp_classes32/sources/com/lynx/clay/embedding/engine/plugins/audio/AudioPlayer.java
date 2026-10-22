package com.lynx.clay.embedding.engine.plugins.audio;

import c5a.c;
import com.lynx.clay.embedding.android.FlutterView;
import com.lynx.clay.embedding.engine.plugins.ClayPluginContext;
import com.lynx.xelement.webview.LynxUIWebView;
import com.obric.aivoice.core.data.NameKeys;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class AudioPlayer {
    private static final String TAG = "AudioPlayer";
    private boolean autoPrepare;
    private boolean autoplay;
    private final ClayPluginContext factory;
    private a impl;
    private int interval;
    private boolean loop;
    private boolean mute;
    private long nativePtr;
    private String playUrl;
    private String srcId;
    private String type;
    private String vid;
    private float volume;

    public interface a {
        void a(int r1);

        int b();

        void c(boolean r1);

        int d();

        void dispose();

        void e();

        void enterBackground();

        void enterForeground();

        void f();

        int getCurrentTime();

        int getDuration();

        int getPlaybackState();

        void pause();

        void play();

        void prepare();

        void resume();

        void setInterval(int r1);

        void setLoop(boolean r1);

        void setSrc(String r1);

        void setVid(String r1);

        void setVolume(float r1);

        void stop();
    }

    private static native void nativeOnError(long r0, int r2, String r3, String r4);

    private static native void nativeOnFinished(long r0, String r2);

    private static native void nativeOnLoadingStateChanged(long r0, int r2, String r3, String r4);

    private static native void nativeOnPlaybackStateChanged(long r0, int r2, String r3, String r4);

    private static native void nativeOnPrepared(long r0, String r2);

    private static native void nativeOnSeek(long r0, String r2);

    private static native void nativeOnTimeUpdate(long r0, int r2, String r3);

    private void createPlayerImpl() {
        a r0 = this.impl;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        String r1 = this.type;
        switch(r1.hashCode()) {
            case -238594573: goto L18;
            case 102970646: goto L15;
            case 109413500: goto L12;
            case 1544803905: goto L9;
            default: goto L20;
        };
    L20:
        byte r2 = -1;
    L21:
        if (r2 == 0) goto L30;
        if (r2 == 1) goto L30;
        if (r5a.a.a(this.factory.a.getContext()) == true) goto L38;
    L29:
        this.impl = new com.lynx.clay.embedding.engine.plugins.audio.a(this, "short-compat");
    L31:
        c.d(6, TAG, "AudioPlayer created, type = " + this.type);
        this.impl.e();
        this.impl.f();
        this.impl.setLoop(this.loop);
        this.impl.setInterval(this.interval);
        this.impl.c(this.mute);
        this.impl.setVolume(this.volume);
        String r3 = this.vid;
        if (r3 != null) goto L34;
    L36:
        this.impl.setSrc(this.playUrl);
        return;
    L34:
        if (r3.isEmpty() == true) goto L36;
        this.impl.setVid(this.vid);
        return;
    L38:
        this.impl = new b(this, this.type);     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        th.printStackTrace();
    L30:
        this.impl = new com.lynx.clay.embedding.engine.plugins.audio.a(this, this.type);
        goto L31
    L9:
        if (r1.equals(LynxUIWebView.DEFAULT) == false) goto L20;
        r2 = 3;
        goto L21
    L12:
        if (r1.equals("short") == false) goto L20;
        r2 = 0;
        goto L21
    L15:
        if (r1.equals("light") == false) goto L20;
        r2 = 2;
        goto L21
    L18:
        if (r1.equals("short-compat") == false) goto L20;
        r2 = 1;
        goto L21
    }

    public int getCacheTime() {
        a r0 = this.impl;
        if (r0 != null) goto L5;
        return 0;
    L5:
        return r0.d();
    }

    public int getCurrentTime() {
        a r0 = this.impl;
        if (r0 != null) goto L5;
        return 0;
    L5:
        return r0.getCurrentTime();
    }

    public int getDuration() {
        a r0 = this.impl;
        if (r0 != null) goto L5;
        return 0;
    L5:
        return r0.getDuration();
    }

    public FlutterView getFlutterView() {
        return this.factory.a;
    }

    public int getPlayBitrate() {
        a r0 = this.impl;
        if (r0 != null) goto L5;
        return 0;
    L5:
        return r0.b();
    }

    public int getPlaybackState() {
        a r0 = this.impl;
        if (r0 != null) goto L5;
        return 0;
    L5:
        return r0.getPlaybackState();
    }

    public void onDestroy() {
        a r0 = this.impl;
        if (r0 == null) goto L5;
        r0.dispose();
        this.impl = null;
    L5:
        this.nativePtr = 0;
    }

    public void onEnterBackground() {
        a r0 = this.impl;
        if (r0 == null) goto L6;
        r0.enterBackground();
        return;
    }

    public void onEnterForeground() {
        a r0 = this.impl;
        if (r0 == null) goto L6;
        r0.enterForeground();
        return;
    }

    public void pause() {
        a r0 = this.impl;
        if (r0 == null) goto L6;
        r0.pause();
        return;
    }

    public void play() {
        a r0 = this.impl;
        if (r0 == null) goto L6;
        r0.play();
        return;
    }

    public void prepare() {
        a r0 = this.impl;
        if (r0 == null) goto L6;
        r0.prepare();
        return;
    }

    public void resume() {
        a r0 = this.impl;
        if (r0 == null) goto L6;
        r0.resume();
        return;
    }

    public void stop() {
        a r0 = this.impl;
        if (r0 == null) goto L6;
        r0.stop();
        return;
    }

    public String getCurrentSrcID() {
        return this.srcId;
    }

    public int getInterval() {
        return this.interval;
    }

    public String getPlayUrl() {
        return this.playUrl;
    }

    public float getVolume() {
        return this.volume;
    }

    public boolean isAutoplay() {
        return this.autoplay;
    }

    public boolean isLoop() {
        return this.loop;
    }

    public boolean isMute() {
        return this.mute;
    }

    public AudioPlayer(ClayPluginContext r3) {
        this.autoplay = false;
        this.autoPrepare = false;
        this.loop = false;
        this.interval = 500;
        this.type = LynxUIWebView.DEFAULT;
        this.mute = false;
        this.volume = 1.0f;
        this.nativePtr = 0;
        this.factory = r3;
    }

    public static AudioPlayer Create(ClayPluginContext r1) {
        return new AudioPlayer(r1);
    }

    private void setNativePtr(long r1) {
        this.nativePtr = r1;
    }

    public boolean isRemoteUrl(String r2) {
        if (r2.startsWith("http://") == false) goto L5;
    L8:
        return true;
    L5:
        if (r2.startsWith("https://") == true) goto L8;
        return false;
    }

    public void mute(boolean r2) {
        if (this.mute != r2) goto L5;
        return;
    L5:
        this.mute = r2;
        a r0 = this.impl;
        if (r0 == null) goto L9;
        r0.c(r2);
        return;
    }

    public void onFinished(String r3) {
        nativeOnFinished(this.nativePtr, r3);
    }

    public void onPrepared(String r3) {
        nativeOnPrepared(this.nativePtr, r3);
    }

    public void onSeek(String r3) {
        nativeOnSeek(this.nativePtr, r3);
    }

    public void seek(int r2) {
        a r0 = this.impl;
        if (r0 == null) goto L6;
        r0.a(r2);
        return;
    }

    public void setAutoPrepare(boolean r2) {
        if (this.autoPrepare != r2) goto L5;
        return;
    L5:
        this.autoPrepare = r2;
        a r3 = this.impl;
        if (r3 == null) goto L9;
        r3.e();
        return;
    }

    public void setAutoplay(boolean r2) {
        if (this.autoplay != r2) goto L5;
        return;
    L5:
        this.autoplay = r2;
        a r3 = this.impl;
        if (r3 == null) goto L9;
        r3.f();
        return;
    }

    public void setInterval(int r2) {
        if (this.interval != r2) goto L5;
        return;
    L5:
        this.interval = r2;
        a r0 = this.impl;
        if (r0 == null) goto L9;
        r0.setInterval(r2);
        return;
    }

    public void setLoop(boolean r2) {
        if (this.loop != r2) goto L5;
        return;
    L5:
        this.loop = r2;
        a r0 = this.impl;
        if (r0 == null) goto L9;
        r0.setLoop(r2);
        return;
    }

    public void setPlayerType(String r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (r2.isEmpty() == false) goto L6;
        return;
    L6:
        if (r2.equals(this.type) == true) goto L20;
        this.type = r2;
        if (this.playUrl != null) goto L14;
        String r3 = this.vid;
        if (r3 != null) goto L13;
        return;
    L13:
        if (r3.isEmpty() == false) goto L14;
        return;
    L14:
        createPlayerImpl();
        return;
    }

    public void setSrc(String r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.isEmpty() == false) goto L7;
        return;
    L7:
        if (r5.startsWith("{") == true) goto L34;
        String r0 = r5;
    L14:
        if (r5 != null) goto L16;
        return;
    L16:
        if (r5.isEmpty() == false) goto L18;
        return;
    L18:
        if (r5.equals(this.playUrl) == true) goto L41;
        if (r0 != null) goto L22;
    L23:
        r0 = r5;
    L24:
        this.srcId = r0;
        this.playUrl = r5;
        String r1 = this.vid;
        if (r1 != null) goto L27;
    L29:
        a r2 = this.impl;
        if (r2 == null) goto L32;
        r2.setSrc(r5);
        return;
    L32:
        createPlayerImpl();
        return;
    L27:
        if (r1.isEmpty() == true) goto L29;
        return;
    L22:
        if (r0.isEmpty() == false) goto L24;
    L41:
        return;
    L34:
        JSONObject r3 = new JSONObject(r5);     // Catch: Exception -> L10
        String r6 = r3.optString("id", null);     // Catch: Exception -> L10
        String r4 = r3.optString("play_url", null);     // Catch: Exception -> L10
        r0 = r6;
        r5 = r4;
    L10:
        e = move-exception;
        c.d(6, TAG, "AudioPlayer.setSrc failed");
        e.printStackTrace();
    }

    public void setVid(String r2) {
        if (r2 != null) goto L4;
    L14:
        String r3 = this.vid;
        if (r3 != null) goto L17;
        return;
    L17:
        if (r3.isEmpty() == true) goto L32;
        this.vid = null;
        this.srcId = NameKeys.UnloadStrategy_No_Strategy;
        a r0 = this.impl;
        if (r0 == null) goto L29;
        r0.setVid(null);
        String r4 = this.playUrl;
        if (r4 != null) goto L24;
        return;
    L24:
        if (r4.isEmpty() == true) goto L31;
        this.impl.setSrc(this.playUrl);
        return;
    L31:
        return;
    L29:
        return;
    L32:
        return;
    L4:
        if (r2.isEmpty() == true) goto L14;
        if (r2.equals(this.vid) == false) goto L9;
        return;
    L9:
        this.vid = r2;
        this.srcId = r2;
        a r1 = this.impl;
        if (r1 == null) goto L12;
        r1.setVid(r2);
        return;
    L12:
        createPlayerImpl();
    }

    public void setVolume(float r2) {
        if (this.volume != r2) goto L5;
        return;
    L5:
        this.volume = r2;
        a r0 = this.impl;
        if (r0 == null) goto L9;
        r0.setVolume(r2);
        return;
    }

    public void onTimeUpdate(int r3, String r4) {
        nativeOnTimeUpdate(this.nativePtr, r3, r4);
    }

    public void onError(int r3, String r4, String r5) {
        nativeOnError(this.nativePtr, r3, r4, r5);
    }

    public void onLoadingStateChanged(int r3, String r4, String r5) {
        nativeOnLoadingStateChanged(this.nativePtr, r3, r4, r5);
    }

    public void onPlaybackStateChanged(int r3, String r4, String r5) {
        nativeOnPlaybackStateChanged(this.nativePtr, r3, r4, r5);
    }
}
