package androidx.media;

import android.media.AudioAttributes;
import androidx.annotation.RestrictTo;
import androidx.versionedparcelable.VersionedParcel;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class AudioAttributesImplApi21Parcelizer {
    public AudioAttributesImplApi21Parcelizer() {
    }

    public static AudioAttributesImplApi21 read(VersionedParcel r10) {
        AudioAttributesImplApi21 r11 = new AudioAttributesImplApi21();
        r11.mAudioAttributes = (AudioAttributes) r10.readParcelable(r11.mAudioAttributes, 1);
        r11.mLegacyStreamType = r10.readInt(r11.mLegacyStreamType, 2);
        return r11;
    }

    public static void write(AudioAttributesImplApi21 r10, VersionedParcel r11) {
        r11.setSerializationFlags(false, false);
        r11.writeParcelable(r10.mAudioAttributes, 1);
        r11.writeInt(r10.mLegacyStreamType, 2);
    }
}
