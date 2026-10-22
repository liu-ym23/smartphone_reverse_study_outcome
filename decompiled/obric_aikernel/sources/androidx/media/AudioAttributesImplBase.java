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

    AudioAttributesImplBase() {
        this.mUsage = 0;
        this.mContentType = 0;
        this.mFlags = 0;
        this.mLegacyStream = -1;
    }

    AudioAttributesImplBase(int r10, int r11, int r12, int r13) {
        this.mUsage = 0;
        this.mContentType = 0;
        this.mFlags = 0;
        this.mLegacyStream = -1;
        this.mContentType = r10;
        this.mFlags = r11;
        this.mUsage = r12;
        this.mLegacyStream = r13;
    }

    public static AudioAttributesImpl fromBundle(Bundle r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        int r11 = r10.getInt("androidx.media.audio_attrs.USAGE", 0);
        return new AudioAttributesImplBase(r10.getInt("androidx.media.audio_attrs.CONTENT_TYPE", 0), r10.getInt("androidx.media.audio_attrs.FLAGS", 0), r11, r10.getInt("androidx.media.audio_attrs.LEGACY_STREAM_TYPE", -1));
    }

    public boolean equals(Object r10) {
        if ((r10 instanceof AudioAttributesImplBase) == true) goto L5;
        return false;
    L5:
        AudioAttributesImplBase r11 = (AudioAttributesImplBase) r10;
        if (this.mContentType == r11.getContentType()) goto L8;
        return false;
    L8:
        if (this.mFlags == r11.getFlags()) goto L10;
        return false;
    L10:
        if (this.mUsage == r11.getUsage()) goto L12;
        return false;
    L12:
        if (this.mLegacyStream != r11.mLegacyStream) goto L18;
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
        int r10 = this.mFlags;
        int r11 = getLegacyStreamType();
        if (r11 != 6) goto L6;
        r10 = r10 | 4;
    L9:
        return r10 & 273;
    L6:
        if (r11 != 7) goto L9;
        r10 = r10 | 1;
        goto L9
    }

    @Override // androidx.media.AudioAttributesImpl
    public int getLegacyStreamType() {
        int r10 = this.mLegacyStream;
        if (r10 == (-1)) goto L6;
        return r10;
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
        Bundle r10 = new Bundle();
        r10.putInt("androidx.media.audio_attrs.USAGE", this.mUsage);
        r10.putInt("androidx.media.audio_attrs.CONTENT_TYPE", this.mContentType);
        r10.putInt("androidx.media.audio_attrs.FLAGS", this.mFlags);
        int r11 = this.mLegacyStream;
        if (r11 == (-1)) goto L5;
        r10.putInt("androidx.media.audio_attrs.LEGACY_STREAM_TYPE", r11);
    L5:
        return r10;
    }

    public String toString() {
        StringBuilder r10 = new StringBuilder("AudioAttributesCompat:");
        if (this.mLegacyStream == (-1)) goto L5;
        r10.append(" stream=");
        r10.append(this.mLegacyStream);
        r10.append(" derived");
    L5:
        r10.append(" usage=");
        r10.append(AudioAttributesCompat.usageToString(this.mUsage));
        r10.append(" content=");
        r10.append(this.mContentType);
        r10.append(" flags=0x");
        r10.append(Integer.toHexString(this.mFlags).toUpperCase());
        return r10.toString();
    }
}
