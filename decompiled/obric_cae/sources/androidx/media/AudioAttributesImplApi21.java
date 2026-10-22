package androidx.media;

import android.annotation.TargetApi;
import android.media.AudioAttributes;

/* JADX INFO: loaded from: classes.dex */
@TargetApi(21)
class AudioAttributesImplApi21 implements AudioAttributesImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AudioAttributes f2209a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2210b;

    public AudioAttributesImplApi21() {
        this.f2210b = -1;
    }

    public final boolean equals(Object r8) {
        if ((r8 instanceof AudioAttributesImplApi21) == true) goto L7;
        return false;
    L7:
        return this.f2209a.equals(((AudioAttributesImplApi21) r8).f2209a);
    }

    public final int hashCode() {
        return this.f2209a.hashCode();
    }

    public final String toString() {
        return "AudioAttributesCompat: audioattributes=" + this.f2209a;
    }
}
