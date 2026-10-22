package androidx.media;

import androidx.annotation.RestrictTo;
import androidx.versionedparcelable.VersionedParcel;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class AudioAttributesCompatParcelizer {
    public AudioAttributesCompatParcelizer() {
    }

    public static AudioAttributesCompat read(VersionedParcel r10) {
        AudioAttributesCompat r11 = new AudioAttributesCompat();
        r11.mImpl = (AudioAttributesImpl) r10.readVersionedParcelable(r11.mImpl, 1);
        return r11;
    }

    public static void write(AudioAttributesCompat r10, VersionedParcel r11) {
        r11.setSerializationFlags(false, false);
        r11.writeVersionedParcelable(r10.mImpl, 1);
    }
}
