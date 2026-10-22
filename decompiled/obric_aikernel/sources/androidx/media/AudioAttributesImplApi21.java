package androidx.media;

import android.annotation.TargetApi;
import android.media.AudioAttributes;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
@TargetApi(21)
class AudioAttributesImplApi21 implements AudioAttributesImpl {
    private static final String TAG = "AudioAttributesCompat21";
    static Method sAudioAttributesToLegacyStreamType;
    AudioAttributes mAudioAttributes;
    int mLegacyStreamType;

    AudioAttributesImplApi21() {
        this.mLegacyStreamType = -1;
    }

    AudioAttributesImplApi21(AudioAttributes r10) {
        this(r10, -1);
    }

    AudioAttributesImplApi21(AudioAttributes r10, int r11) {
        this.mLegacyStreamType = -1;
        this.mAudioAttributes = r10;
        this.mLegacyStreamType = r11;
    }

    public static AudioAttributesImpl fromBundle(Bundle r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        AudioAttributes r11 = (AudioAttributes) r10.getParcelable("androidx.media.audio_attrs.FRAMEWORKS");
        if (r11 != null) goto L9;
        return null;
    L9:
        return new AudioAttributesImplApi21(r11, r10.getInt("androidx.media.audio_attrs.LEGACY_STREAM_TYPE", -1));
    }

    static Method getAudioAttributesToLegacyStreamTypeMethod() {
    L7:
        return null;
    L3:
        if (sAudioAttributesToLegacyStreamType != null) goto L6;
        sAudioAttributesToLegacyStreamType = AudioAttributes.class.getMethod("toLegacyStreamType", new Class[]{AudioAttributes.class});     // Catch: NoSuchMethodException -> L7
    L6:
        return sAudioAttributesToLegacyStreamType;
    }

    public boolean equals(Object r10) {
        if ((r10 instanceof AudioAttributesImplApi21) == true) goto L7;
        return false;
    L7:
        return this.mAudioAttributes.equals(((AudioAttributesImplApi21) r10).mAudioAttributes);
    }

    @Override // androidx.media.AudioAttributesImpl
    public Object getAudioAttributes() {
        return this.mAudioAttributes;
    }

    @Override // androidx.media.AudioAttributesImpl
    public int getContentType() {
        return this.mAudioAttributes.getContentType();
    }

    @Override // androidx.media.AudioAttributesImpl
    public int getFlags() {
        return this.mAudioAttributes.getFlags();
    }

    @Override // androidx.media.AudioAttributesImpl
    public int getLegacyStreamType() {
        int r10 = this.mLegacyStreamType;
        if (r10 == (-1)) goto L5;
        return r10;
    L5:
        Method r11 = getAudioAttributesToLegacyStreamTypeMethod();
        if (r11 != null) goto L15;
        Log.w(TAG, "No AudioAttributes#toLegacyStreamType() on API: " + Build.VERSION.SDK_INT);
        return -1;
    L15:
        return ((Integer) r11.invoke(null, new Object[]{this.mAudioAttributes})).intValue();
    L12:
        e = move-exception;
        Log.w(TAG, "getLegacyStreamType() failed on API: " + Build.VERSION.SDK_INT, e);
        return -1;
    }

    @Override // androidx.media.AudioAttributesImpl
    public int getRawLegacyStreamType() {
        return this.mLegacyStreamType;
    }

    @Override // androidx.media.AudioAttributesImpl
    public int getUsage() {
        return this.mAudioAttributes.getUsage();
    }

    @Override // androidx.media.AudioAttributesImpl
    public int getVolumeControlStream() {
        if (Build.VERSION.SDK_INT < 26) goto L7;
        return this.mAudioAttributes.getVolumeControlStream();
    L7:
        return AudioAttributesCompat.toVolumeStreamType(true, getFlags(), getUsage());
    }

    public int hashCode() {
        return this.mAudioAttributes.hashCode();
    }

    @Override // androidx.media.AudioAttributesImpl
    @NonNull
    public Bundle toBundle() {
        Bundle r10 = new Bundle();
        r10.putParcelable("androidx.media.audio_attrs.FRAMEWORKS", this.mAudioAttributes);
        int r11 = this.mLegacyStreamType;
        if (r11 == (-1)) goto L5;
        r10.putInt("androidx.media.audio_attrs.LEGACY_STREAM_TYPE", r11);
    L5:
        return r10;
    }

    public String toString() {
        return "AudioAttributesCompat: audioattributes=" + this.mAudioAttributes;
    }
}
