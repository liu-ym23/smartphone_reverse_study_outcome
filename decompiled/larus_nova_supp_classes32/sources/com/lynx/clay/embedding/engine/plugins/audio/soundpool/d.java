package com.lynx.clay.embedding.engine.plugins.audio.soundpool;

import android.media.SoundPool;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class d implements GenericSoundPool {
    public SoundPool a;
    public GenericSoundPool.b b;

    @Override // com.lynx.clay.embedding.engine.plugins.audio.soundpool.GenericSoundPool
    public final void a() {
        this.a.autoResume();
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.soundpool.GenericSoundPool
    public final void f() {
        this.a.autoPause();
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.soundpool.GenericSoundPool
    public final void release() {
        this.a.setOnLoadCompleteListener(null);
        this.a.release();
        this.a = null;
    }

    public d() {
        SoundPool r0 = new SoundPool(1, 3, 0);
        this.a = r0;
        r0.setOnLoadCompleteListener(new c(this));
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.soundpool.GenericSoundPool
    public final void b(com.lynx.clay.embedding.engine.plugins.audio.a.C0036a r1) {
        this.b = r1;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.soundpool.GenericSoundPool
    public final int load(String r3) {
        return this.a.load(r3, 1);
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.soundpool.GenericSoundPool
    public final void pause(int r2) {
        this.a.pause(r2);
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.soundpool.GenericSoundPool
    public final void resume(int r2) {
        this.a.resume(r2);
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.soundpool.GenericSoundPool
    public final void stop(int r2) {
        this.a.stop(r2);
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.soundpool.GenericSoundPool
    public final void c(int r2, int r3) {
        this.a.setLoop(r2, r3);
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.soundpool.GenericSoundPool
    public final void e(int r2, float r3, float r4) {
        this.a.setVolume(r2, r3, r4);
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.soundpool.GenericSoundPool
    public final int d(int r8, float r9, float r10, int r11) {
        return this.a.play(r8, r9, r10, 1, r11, 1.0f);
    }
}
