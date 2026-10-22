package androidx.media;

import android.os.Bundle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
class AudioAttributesImplBase implements AudioAttributesImpl {
    int mContentType;
    int mFlags;
    int mLegacyStream;
    int mUsage;

    AudioAttributesImplBase() {
        this.mUsage = 0;
        this.mContentType = 0;
        this.mFlags = 0;
        this.mLegacyStream = -1;
    }

    AudioAttributesImplBase(int r2, int r3, int r4, int r5) {
        this.mUsage = 0;
        this.mContentType = 0;
        this.mFlags = 0;
        this.mLegacyStream = -1;
        this.mContentType = r2;
        this.mFlags = r3;
        this.mUsage = r4;
        this.mLegacyStream = r5;
    }

    public static AudioAttributesImpl fromBundle(Bundle r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        int r0 = r5.getInt("androidx.media.audio_attrs.USAGE", 0);
        return new AudioAttributesImplBase(r5.getInt("androidx.media.audio_attrs.CONTENT_TYPE", 0), r5.getInt("androidx.media.audio_attrs.FLAGS", 0), r0, r5.getInt("androidx.media.audio_attrs.LEGACY_STREAM_TYPE", -1));
    }

    public boolean equals(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, AudioAttributesImplBase.class) == true) goto L5;
        return false;
    L5:
        AudioAttributesImplBase r5 = (AudioAttributesImplBase) ZeusTransformUtils.preCheckCast(r4, AudioAttributesImplBase.class, "com.obric.memorydata.plugin");
        if (this.mContentType == r5.getContentType()) goto L8;
        return false;
    L8:
        if (this.mFlags == r5.getFlags()) goto L10;
        return false;
    L10:
        if (this.mUsage == r5.getUsage()) goto L12;
        return false;
    L12:
        if (this.mLegacyStream != r5.mLegacyStream) goto L18;
        return true;
    L18:
        return false;
    }

    @Override // androidx.media.AudioAttributesImpl
    public Object getAudioAttributes() {
        return null;
    }

    @Override // androidx.media.AudioAttributesImpl
    public int getContentType() {
        return this.mContentType;
    }

    @Override // androidx.media.AudioAttributesImpl
    public int getFlags() {
        int r0 = this.mFlags;
        int r2 = getLegacyStreamType();
        if (r2 != 6) goto L6;
        r0 = r0 | 4;
    L9:
        return r0 & 273;
    L6:
        if (r2 != 7) goto L9;
        r0 = r0 | 1;
        goto L9
    }

    @Override // androidx.media.AudioAttributesImpl
    public int getLegacyStreamType() {
        int r0 = this.mLegacyStream;
        if (r0 == (-1)) goto L6;
        return r0;
    L6:
        return AudioAttributesCompat.toVolumeStreamType(false, this.mFlags, this.mUsage);
    }

    @Override // androidx.media.AudioAttributesImpl
    public int getRawLegacyStreamType() {
        return this.mLegacyStream;
    }

    @Override // androidx.media.AudioAttributesImpl
    public int getUsage() {
        return this.mUsage;
    }

    @Override // androidx.media.AudioAttributesImpl
    public int getVolumeControlStream() {
        return AudioAttributesCompat.toVolumeStreamType(true, this.mFlags, this.mUsage);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.mContentType), Integer.valueOf(this.mFlags), Integer.valueOf(this.mUsage), Integer.valueOf(this.mLegacyStream)});
    }

    @Override // androidx.media.AudioAttributesImpl
    public Bundle toBundle() {
        Bundle r0 = new Bundle();
        r0.putInt("androidx.media.audio_attrs.USAGE", this.mUsage);
        r0.putInt("androidx.media.audio_attrs.CONTENT_TYPE", this.mContentType);
        r0.putInt("androidx.media.audio_attrs.FLAGS", this.mFlags);
        int r3 = this.mLegacyStream;
        if (r3 == (-1)) goto L5;
        r0.putInt("androidx.media.audio_attrs.LEGACY_STREAM_TYPE", r3);
    L5:
        return r0;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("AudioAttributesCompat:");
        if (this.mLegacyStream == (-1)) goto L5;
        r0.append(" stream=").append(this.mLegacyStream);
        r0.append(" derived");
    L5:
        r0.append(" usage=").append(AudioAttributesCompat.usageToString(this.mUsage)).append(" content=").append(this.mContentType).append(" flags=0x").append(Integer.toHexString(this.mFlags).toUpperCase());
        return r0.toString();
    }
}
