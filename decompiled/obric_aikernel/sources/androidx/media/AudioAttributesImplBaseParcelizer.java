package androidx.media;

import androidx.annotation.RestrictTo;
import androidx.versionedparcelable.VersionedParcel;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class AudioAttributesImplBaseParcelizer {
    public AudioAttributesImplBaseParcelizer() {
    }

    public static AudioAttributesImplBase read(VersionedParcel r10) {
        AudioAttributesImplBase r11 = new AudioAttributesImplBase();
        r11.mUsage = r10.readInt(r11.mUsage, 1);
        r11.mContentType = r10.readInt(r11.mContentType, 2);
        r11.mFlags = r10.readInt(r11.mFlags, 3);
        r11.mLegacyStream = r10.readInt(r11.mLegacyStream, 4);
        return r11;
    }

    public static void write(AudioAttributesImplBase r10, VersionedParcel r11) {
        r11.setSerializationFlags(false, false);
        r11.writeInt(r10.mUsage, 1);
        r11.writeInt(r10.mContentType, 2);
        r11.writeInt(r10.mFlags, 3);
        r11.writeInt(r10.mLegacyStream, 4);
    }
}
