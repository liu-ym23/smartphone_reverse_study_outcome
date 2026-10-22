package androidx.media;

import androidx.versionedparcelable.VersionedParcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public final class AudioAttributesCompatParcelizer {
    public AudioAttributesCompatParcelizer() {
    }

    public static AudioAttributesCompat read(VersionedParcel r3) {
        AudioAttributesCompat r0 = new AudioAttributesCompat();
        r0.mImpl = (AudioAttributesImpl) ZeusTransformUtils.preCheckCast(r3.readVersionedParcelable(r0.mImpl, 1), AudioAttributesImpl.class, "com.obric.memorydata.plugin");
        return r0;
    }

    public static void write(AudioAttributesCompat r1, VersionedParcel r2) {
        r2.setSerializationFlags(false, false);
        r2.writeVersionedParcelable(r1.mImpl, 1);
    }
}
