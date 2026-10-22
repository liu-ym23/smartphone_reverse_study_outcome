package androidx.media;

import androidx.annotation.RestrictTo;
import androidx.versionedparcelable.VersionedParcel;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class AudioAttributesCompatParcelizer {
    public AudioAttributesCompatParcelizer() {
    }

    public static AudioAttributesCompat read(VersionedParcel r5) {
        AudioAttributesCompat r10 = new AudioAttributesCompat();
        r10.mImpl = (AudioAttributesImpl) r5.readVersionedParcelable(r10.mImpl, 1);
        return r10;
    }

    public static void write(AudioAttributesCompat r5, VersionedParcel r10) {
        r10.setSerializationFlags(false, false);
        r10.writeVersionedParcelable(r5.mImpl, 1);
    }
}
