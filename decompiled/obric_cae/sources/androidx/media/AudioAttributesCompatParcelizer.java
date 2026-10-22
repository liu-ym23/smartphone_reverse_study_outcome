package androidx.media;

import h1.a;

/* JADX INFO: loaded from: classes.dex */
public final class AudioAttributesCompatParcelizer {
    public AudioAttributesCompatParcelizer() {
    }

    public static AudioAttributesCompat read(a r8) {
        AudioAttributesCompat r10 = new AudioAttributesCompat();
        Object r11 = r10.f2208a;
        if (r8.h(1) == false) goto L6;
        r11 = r8.m();
    L6:
        r10.f2208a = (AudioAttributesImpl) r11;
        return r10;
    }

    public static void write(AudioAttributesCompat r8, a r10) {
        r10.getClass();
        AudioAttributesImpl r11 = r8.f2208a;
        r10.n(1);
        r10.v(r11);
    }
}
