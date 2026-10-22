package androidx.media;

import android.os.Bundle;
import androidx.annotation.NonNull;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
class AudioAttributesImplBase implements AudioAttributesImpl {
    int mContentType;
    int mFlags;
    int mLegacyStream;
    int mUsage;

    public AudioAttributesImplBase() {
        this.mUsage = 0;
        this.mContentType = 0;
        this.mFlags = 0;
        this.mLegacyStream = -1;
    }

    public static AudioAttributesImpl fromBundle(Bundle r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        int r10 = r5.getInt("androidx.media.audio_attrs.USAGE", 0);
        return new AudioAttributesImplBase(r5.getInt("androidx.media.audio_attrs.CONTENT_TYPE", 0), r5.getInt("androidx.media.audio_attrs.FLAGS", 0), r10, r5.getInt("androidx.media.audio_attrs.LEGACY_STREAM_TYPE", -1));
    }

    public boolean equals(Object r5) {
        if ((r5 instanceof AudioAttributesImplBase) == true) goto L5;
        return false;
    L5:
        AudioAttributesImplBase r10 = (AudioAttributesImplBase) r5;
        if (this.mContentType == r10.getContentType()) goto L8;
        return false;
    L8:
        if (this.mFlags == r10.getFlags()) goto L10;
        return false;
    L10:
        if (this.mUsage == r10.getUsage()) goto L12;
        return false;
    L12:
        if (this.mLegacyStream != r10.mLegacyStream) goto L18;
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
        int r5 = this.mFlags;
        int r10 = getLegacyStreamType();
        if (r10 != 6) goto L6;
        r5 = r5 | 4;
    L9:
        return r5 & 273;
    L6:
        if (r10 != 7) goto L9;
        r5 = r5 | 1;
        goto L9
    }

    @Override // androidx.media.AudioAttributesImpl
    public int getLegacyStreamType() {
        int r5 = this.mLegacyStream;
        if (r5 == (-1)) goto L6;
        return r5;
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
    @NonNull
    public Bundle toBundle() {
        Bundle r5 = new Bundle();
        r5.putInt("androidx.media.audio_attrs.USAGE", this.mUsage);
        r5.putInt("androidx.media.audio_attrs.CONTENT_TYPE", this.mContentType);
        r5.putInt("androidx.media.audio_attrs.FLAGS", this.mFlags);
        int r10 = this.mLegacyStream;
        if (r10 == (-1)) goto L5;
        r5.putInt("androidx.media.audio_attrs.LEGACY_STREAM_TYPE", r10);
    L5:
        return r5;
    }

    public String toString() {
        StringBuilder r5 = new StringBuilder("AudioAttributesCompat:");
        if (this.mLegacyStream == (-1)) goto L5;
        r5.append(" stream=");
        r5.append(this.mLegacyStream);
        r5.append(" derived");
    L5:
        r5.append(" usage=");
        r5.append(AudioAttributesCompat.usageToString(this.mUsage));
        r5.append(" content=");
        r5.append(this.mContentType);
        r5.append(" flags=0x");
        r5.append(Integer.toHexString(this.mFlags).toUpperCase());
        return r5.toString();
    }

    public AudioAttributesImplBase(int r5, int r10, int r11, int r12) {
        this.mContentType = r5;
        this.mFlags = r10;
        this.mUsage = r11;
        this.mLegacyStream = r12;
    }
}
