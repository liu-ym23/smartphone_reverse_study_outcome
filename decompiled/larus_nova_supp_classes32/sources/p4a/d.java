package p4a;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack;
import com.lynx.animax.audio.AudioPlayer;
import com.lynx.animax.util.AnimaXLog;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class d implements AudioTrack.OnPlaybackPositionUpdateListener {
    public final int a;
    public final int b;
    public final ByteBuffer c;
    public e d;
    public int e;
    public final AudioTrack f;

    @Override // android.media.AudioTrack.OnPlaybackPositionUpdateListener
    public final void onMarkerReached(AudioTrack r1) {
    }

    public d(c r14) {
        this.e = 0;
        int r0 = r14.c;
        int r1 = r14.b;
        int r2 = 4;
        if (r1 != 1) goto L5;
        int r5 = 4;
    L8:
        int r6 = r14.e;
        if (r6 != 3) goto L11;
        r2 = 1;
    L14:
        int r3 = r1 * r2;
        this.b = r3;
        int r15 = Math.min(((int) Math.ceil(((double) r0) / 30.0d)) * 2, (int) ((((long) r14.c) * r14.d) / 1000000.0d));
        int r4 = Math.max(r15, (AudioTrack.getMinBufferSize(r0, r5, r6) / r3) + 1) * r3;
        this.a = r4;
        this.c = ByteBuffer.allocate(r4);
        AudioTrack r7 = new AudioTrack(new AudioAttributes.Builder().setUsage(1).setContentType(2).build(), new AudioFormat.Builder().setEncoding(r6).setSampleRate(r0).setChannelMask(r5).build(), r4, 1, 0);
        this.f = r7;
        if (r7.getState() == 0) goto L19;
        AnimaXLog.b("AudioRenderer", "AudioTrack initialization success. sampleRate=" + r0 + ", channelConfig=" + r5 + ", encoding=" + r6 + ", bufferSize=" + r4);
        r7.setPositionNotificationPeriod(r15 / 2);
        r7.setPlaybackPositionUpdateListener(this);
        return;
    L19:
        throw new IllegalStateException("AudioTrack initialization failed. sampleRate=" + r0 + ", channelConfig=" + r5 + ", encoding=" + r6 + ", bufferSize=" + r4);
    L11:
        if (r6 == 4) goto L14;
        r2 = 2;
        goto L14
    L5:
        if (r1 != 2) goto L7;
        r5 = 12;
        goto L8
    L7:
        r5 = 1;
        goto L8
    }

    @Override // android.media.AudioTrack.OnPlaybackPositionUpdateListener
    public final void onPeriodicNotification(AudioTrack r10) {
        if (this.d != null) goto L5;
        return;
    L5:
        long r2 = ((long) this.a) - (((long) this.e) - ((((long) this.f.getPlaybackHeadPosition()) & 4294967295L) * ((long) this.b)));
        int r11 = (int) r2;
        if (r2 != r11) goto L19;
        this.c.clear();
        this.c.limit(r11);
        e r0 = this.d;
        long r1 = this.e;
        ByteBuffer r3 = this.c;
        AudioPlayer r4 = (AudioPlayer) r0;
        long r5 = ((long) r4.e) + r1;
        int r6 = r4.d;
        long r7 = r5 % ((long) r6);
        int r8 = (int) r7;
        if (r7 != r8) goto L17;
        int r9 = r11 + r8;
        int r12 = Math.min(r6, r9);
        r4.c.position(r8);
        r4.c.limit(r12);
        r3.put(r4.c);
        int r13 = r4.d;
        if (r13 >= r9) goto L12;
        r4.c.position(0);
        r4.c.limit(r9 % r13);
        r3.put(r4.c);
    L12:
        r4.c.position(0);
        r4.c.limit(r4.d);
        this.c.flip();
        int r14 = this.f.write(this.c, r11, 1);
        if (r14 <= 0) goto L20;
        this.e += r14;
        return;
    L20:
        return;
    L17:
        throw new ArithmeticException();
    L19:
        throw new ArithmeticException();
    }
}
