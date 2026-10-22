package androidx.media;

import android.media.AudioAttributes;
import android.os.Parcelable;
import h1.a;

/* JADX INFO: loaded from: classes.dex */
public final class AudioAttributesImplApi21Parcelizer {
    public AudioAttributesImplApi21Parcelizer() {
    }

    public static AudioAttributesImplApi21 read(a r8) {
        AudioAttributesImplApi21 r10 = new AudioAttributesImplApi21();
        Parcelable r11 = r10.f2209a;
        if (r8.h(1) == false) goto L6;
        r11 = r8.k();
    L6:
        r10.f2209a = (AudioAttributes) r11;
        r10.f2210b = r8.j(r10.f2210b, 2);
        return r10;
    }

    public static void write(AudioAttributesImplApi21 r8, a r10) {
        r10.getClass();
        AudioAttributes r11 = r8.f2209a;
        r10.n(1);
        r10.t(r11);
        r10.s(r8.f2210b, 2);
    }
}
