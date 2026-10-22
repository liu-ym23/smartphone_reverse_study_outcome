package androidx.media;

import h1.a;

/* JADX INFO: loaded from: classes.dex */
public final class AudioAttributesImplBaseParcelizer {
    public AudioAttributesImplBaseParcelizer() {
    }

    public static AudioAttributesImplBase read(a r8) {
        AudioAttributesImplBase r10 = new AudioAttributesImplBase();
        r10.f2211a = r8.j(r10.f2211a, 1);
        r10.f2212b = r8.j(r10.f2212b, 2);
        r10.f2213c = r8.j(r10.f2213c, 3);
        r10.f2214d = r8.j(r10.f2214d, 4);
        return r10;
    }

    public static void write(AudioAttributesImplBase r8, a r10) {
        r10.getClass();
        r10.s(r8.f2211a, 1);
        r10.s(r8.f2212b, 2);
        r10.s(r8.f2213c, 3);
        r10.s(r8.f2214d, 4);
    }
}
