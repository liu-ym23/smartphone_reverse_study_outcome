package androidx.media;

import androidx.annotation.RestrictTo;
import androidx.versionedparcelable.VersionedParcel;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class AudioAttributesImplBaseParcelizer {
    public AudioAttributesImplBaseParcelizer() {
    }

    public static AudioAttributesImplBase read(VersionedParcel r5) {
        AudioAttributesImplBase r10 = new AudioAttributesImplBase();
        r10.mUsage = r5.readInt(r10.mUsage, 1);
        r10.mContentType = r5.readInt(r10.mContentType, 2);
        r10.mFlags = r5.readInt(r10.mFlags, 3);
        r10.mLegacyStream = r5.readInt(r10.mLegacyStream, 4);
        return r10;
    }

    public static void write(AudioAttributesImplBase r5, VersionedParcel r10) {
        r10.setSerializationFlags(false, false);
        r10.writeInt(r5.mUsage, 1);
        r10.writeInt(r5.mContentType, 2);
        r10.writeInt(r5.mFlags, 3);
        r10.writeInt(r5.mLegacyStream, 4);
    }
}
