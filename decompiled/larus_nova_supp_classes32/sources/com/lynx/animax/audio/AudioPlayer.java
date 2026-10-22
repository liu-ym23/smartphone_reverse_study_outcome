package com.lynx.animax.audio;

import android.media.AudioTrack;
import fna.g;
import gna.a;
import java.nio.ByteBuffer;
import p4a.c;
import p4a.d;
import p4a.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class AudioPlayer implements e {
    public final d a;
    public final c b;
    public final ByteBuffer c;
    public final int d;
    public int e;

    public double getAudioTime() {
        long r0 = this.e;
        d r2 = this.a;
        long r1 = r0 + ((((long) r2.f.getPlaybackHeadPosition()) & 4294967295L) * ((long) r2.b));
        int r3 = this.d;
        return (((r1 % ((long) r3)) / ((double) r3)) * this.b.d) / 1000.0d;
    }

    public double getDuration() {
        return this.b.d / 1000.0d;
    }

    public void pause() {
        AudioTrack r0 = this.a.f;
        if (g.d() == true) goto L5;
        r0.pause();
        return;
    L5:
        r0.pause();
        a.a(r0.hashCode());
    }

    public void play() {
        d r0 = this.a;
        r0.onPeriodicNotification(r0.f);
        AudioTrack r1 = r0.f;
        if (g.d() == true) goto L5;
        r1.play();
        return;
    L5:
        r1.play();
        a.c(r1.hashCode());
    }

    public void seekToProgress(double r4) {
        d r0 = this.a;
        AudioTrack r1 = r0.f;
        if (g.d() == true) goto L5;
        r1.pause();
    L6:
        r0.f.flush();
        r0.e = 0;
        d r2 = this.a;
        int r5 = (int) (r4 * ((double) this.d));
        int r6 = r2.b;
        this.e = (r5 / r6) * r6;
        return;
    L5:
        r1.pause();
        a.a(r1.hashCode());
        goto L6
    }

    public AudioPlayer(c r2, ByteBuffer r3) {
        this.e = 0;
        this.b = r2;
        this.c = r3;
        this.d = r3.capacity();
        d r4 = new d(r2);
        this.a = r4;
        r4.d = this;
    }
}
