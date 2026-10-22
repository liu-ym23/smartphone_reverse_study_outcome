package androidx.media;

import android.media.AudioAttributes;
import androidx.versionedparcelable.VersionedParcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public final class AudioAttributesImplApi21Parcelizer {
    public AudioAttributesImplApi21Parcelizer() {
    }

    public static AudioAttributesImplApi21 read(VersionedParcel r4) {
        AudioAttributesImplApi21 r0 = new AudioAttributesImplApi21();
        r0.mAudioAttributes = (AudioAttributes) ZeusTransformUtils.preCheckCast(r4.readParcelable(r0.mAudioAttributes, 1), AudioAttributes.class, "com.obric.memorydata.plugin");
        r0.mLegacyStreamType = r4.readInt(r0.mLegacyStreamType, 2);
        return r0;
    }

    public static void write(AudioAttributesImplApi21 r2, VersionedParcel r3) {
        r3.setSerializationFlags(false, false);
        r3.writeParcelable(r2.mAudioAttributes, 1);
        r3.writeInt(r2.mLegacyStreamType, 2);
    }
}
