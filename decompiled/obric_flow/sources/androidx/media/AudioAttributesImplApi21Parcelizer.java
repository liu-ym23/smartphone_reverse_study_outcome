package androidx.media;

import android.media.AudioAttributes;
import androidx.annotation.RestrictTo;
import androidx.versionedparcelable.VersionedParcel;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class AudioAttributesImplApi21Parcelizer {
    public AudioAttributesImplApi21Parcelizer() {
    }

    public static AudioAttributesImplApi21 read(VersionedParcel r5) {
        AudioAttributesImplApi21 r10 = new AudioAttributesImplApi21();
        r10.mAudioAttributes = (AudioAttributes) r5.readParcelable(r10.mAudioAttributes, 1);
        r10.mLegacyStreamType = r5.readInt(r10.mLegacyStreamType, 2);
        return r10;
    }

    public static void write(AudioAttributesImplApi21 r5, VersionedParcel r10) {
        r10.setSerializationFlags(false, false);
        r10.writeParcelable(r5.mAudioAttributes, 1);
        r10.writeInt(r5.mLegacyStreamType, 2);
    }
}
