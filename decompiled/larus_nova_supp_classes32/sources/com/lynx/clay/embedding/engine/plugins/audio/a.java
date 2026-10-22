package com.lynx.clay.embedding.engine.plugins.audio;

import c5a.c;
import com.lynx.clay.embedding.engine.loader.ResourceLoaderImpl;
import com.lynx.clay.embedding.engine.plugins.audio.soundpool.GenericSoundPool;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a implements AudioPlayer.a {
    public final AudioPlayer a;
    public GenericSoundPool b;
    public final AtomicBoolean c;
    public int d;
    public int e;
    public boolean f;
    public boolean g;
    public float h;

    /* JADX INFO: renamed from: com.lynx.clay.embedding.engine.plugins.audio.a$a, reason: collision with other inner class name */
    public class C0036a implements GenericSoundPool.b {
        public final /* synthetic */ a a;

        public C0036a(a r1) {
            this.a = r1;
        }

        public final void a(int r3, boolean r4) {
            if (r4 == false) goto L8;
            a r5 = this.a;
            r5.d = r3;
            AudioPlayer r6 = r5.a;
            r6.onPrepared(r6.getCurrentSrcID());
            a r7 = this.a;
            if (r7.f == false) goto L6;
        L7:
            this.a.h();
        L9:
            this.a.c.set(false);
            return;
        L6:
            if (r7.a.isAutoplay() == false) goto L9;
        L8:
            AudioPlayer r8 = this.a.a;
            r8.onError(-1, "load error", r8.getCurrentSrcID());
            goto L9
        }
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.AudioPlayer.a
    public final void a(int r1) {
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.AudioPlayer.a
    public final int b() {
        return 0;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.AudioPlayer.a
    public final int d() {
        return 0;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.AudioPlayer.a
    public final void dispose() {
        c.d(6, "AudioPlayerSPImpl", "dispose");
        GenericSoundPool r0 = this.b;
        if (r0 == null) goto L6;
        r0.release();
        this.b = null;
        return;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.AudioPlayer.a
    public final void e() {
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.AudioPlayer.a
    public final void f() {
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.AudioPlayer.a
    public final int getCurrentTime() {
        return 0;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.AudioPlayer.a
    public final int getDuration() {
        return 0;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.AudioPlayer.a
    public final int getPlaybackState() {
        return 0;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.AudioPlayer.a
    public final void pause() {
        c.d(5, "AudioPlayerSPImpl", "pause");
        int r2 = this.e;
        if (r2 != 0) goto L5;
        c.d(5, "AudioPlayerSPImpl", "nothing to pause");
        return;
    L5:
        this.b.pause(r2);
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.AudioPlayer.a
    public final void prepare() {
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.AudioPlayer.a
    public final void resume() {
        c.d(6, "AudioPlayerSPImpl", "resume");
        GenericSoundPool r0 = this.b;
        if (r0 == null) goto L6;
        r0.resume(this.e);
        return;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.AudioPlayer.a
    public final void setInterval(int r1) {
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.AudioPlayer.a
    public final void setVid(String r1) {
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.AudioPlayer.a
    public final void stop() {
        c.d(5, "AudioPlayerSPImpl", "stop");
        int r2 = this.e;
        if (r2 != 0) goto L5;
        c.d(5, "AudioPlayerSPImpl", "nothing to stop");
        return;
    L5:
        this.b.stop(r2);
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.AudioPlayer.a
    public final void enterBackground() {
        if (this.g == false) goto L5;
        return;
    L5:
        c.d(6, "AudioPlayerSPImpl", "enterBackground");
        GenericSoundPool r0 = this.b;
        if (r0 == null) goto L8;
        r0.f();
    L8:
        this.g = true;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.AudioPlayer.a
    public final void enterForeground() {
        if (this.g == true) goto L5;
        return;
    L5:
        c.d(6, "AudioPlayerSPImpl", "enterForeground");
        GenericSoundPool r0 = this.b;
        if (r0 == null) goto L8;
        r0.a();
    L8:
        this.g = false;
    }

    public final void h() {
        if (this.a.isMute() == false) goto L5;
        float r0 = 0.0f;
    L7:
        if (this.a.isLoop() == false) goto L9;
        int r1 = -1;
    L10:
        int r2 = this.b.d(this.d, r0, r0, r1);
        this.e = r2;
        if (r2 != 0) goto L14;
        c.d(6, "AudioPlayerSPImpl", "play sound failed");
        return;
    L14:
        return;
    L9:
        r1 = 0;
        goto L10
    L5:
        r0 = this.h;
        goto L7
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.AudioPlayer.a
    public final void play() {
        if (this.b != null) goto L5;
        return;
    L5:
        if (this.a == null) goto L20;
        c.d(6, "AudioPlayerSPImpl", "play " + this.e);
        int r0 = this.e;
        if (r0 == 0) goto L11;
        this.b.stop(r0);
    L11:
        if (this.d == 0) goto L14;
        h();
        return;
    L14:
        if (this.c.get() == false) goto L19;
        this.f = true;
        return;
    L19:
        return;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.AudioPlayer.a
    public final void c(boolean r3) {
        int r0 = this.e;
        if (r0 == 0) goto L11;
        GenericSoundPool r1 = this.b;
        if (r1 == null) goto L12;
        if (r3 == false) goto L8;
        float r4 = 0.0f;
    L9:
        r1.e(r0, r4, r4);
        return;
    L8:
        r4 = this.h;
        goto L9
    L12:
        return;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.AudioPlayer.a
    public final void setLoop(boolean r4) {
        c.d(6, "AudioPlayerSPImpl", "setLoop");
        int r0 = this.e;
        if (r0 == 0) goto L10;
        GenericSoundPool r1 = this.b;
        if (r4 == false) goto L7;
        int r5 = -1;
    L8:
        r1.c(r0, r5);
        return;
    L7:
        r5 = 0;
        goto L8
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.AudioPlayer.a
    public final void setSrc(String r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        if (r4.isEmpty() == false) goto L7;
        return;
    L7:
        if (this.b == null) goto L20;
        AudioPlayer r0 = this.a;
        if (r0 != null) goto L12;
        return;
    L12:
        if (r0.isRemoteUrl(r4) == true) goto L14;
        ThreadMethodProxy.start(new PthreadThreadV2(new h5a.b(this, r4), "AudioPlayerSPImpl"));
        return;
    L14:
        if (this.a == null) goto L24;
        ResourceLoaderImpl.create().loadAsFile(r4, new h5a.a(this), false);
        return;
    L24:
        return;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.AudioPlayer.a
    public final void setVolume(float r3) {
        this.h = r3;
        if (this.b == null) goto L13;
        AudioPlayer r0 = this.a;
        if (r0 != null) goto L8;
        return;
    L8:
        if (this.e != 0) goto L10;
        return;
    L10:
        if (r0.isMute() == true) goto L15;
        this.b.e(this.e, r3, r3);
        return;
    L15:
        return;
    }

    public a(AudioPlayer r4, String r5) {
        byte r1 = 0;
        this.c = new AtomicBoolean(false);
        this.d = 0;
        this.e = 0;
        this.f = false;
        this.g = false;
        this.h = 1.0f;
        this.a = r4;
        int r0 = r5.hashCode();
        if (r0 == (-238594573)) goto L11;
        if (r0 == 109413500) goto L8;
    L13:
        r1 = -1;
    L14:
        if (r1 == 0) goto L16;
        this.b = GenericSoundPool.Types.SYSTEM.create(r4.getFlutterView().getContext().getApplicationContext());
    L17:
        this.b.b(new C0036a(this));
        return;
    L16:
        this.b = GenericSoundPool.Types.COMPACT.create(r4.getFlutterView().getContext().getApplicationContext());
        goto L17
    L8:
        if (r5.equals("short") == false) goto L13;
        r1 = 1;
        goto L14
    L11:
        if (r5.equals("short-compat") == false) goto L13;
        goto L13
    }

    public static void g(a r2, String r3) {
        if (r2.b != null) goto L5;
        return;
    L5:
        if (r2.a == null) goto L14;
        r2.c.set(true);
        r2.b.load(r3);     // Catch: Exception -> L10
        return;
    L15:
        return;
    }
}
