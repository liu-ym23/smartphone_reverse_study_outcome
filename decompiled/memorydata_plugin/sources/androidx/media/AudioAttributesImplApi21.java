package androidx.media;

import android.media.AudioAttributes;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
class AudioAttributesImplApi21 implements AudioAttributesImpl {
    private static final String TAG = "AudioAttributesCompat21";
    static Method sAudioAttributesToLegacyStreamType;
    AudioAttributes mAudioAttributes;
    int mLegacyStreamType;

    AudioAttributesImplApi21() {
        this.mLegacyStreamType = -1;
    }

    AudioAttributesImplApi21(AudioAttributes r2) {
        this(r2, -1);
    }

    AudioAttributesImplApi21(AudioAttributes r2, int r3) {
        this.mLegacyStreamType = -1;
        this.mAudioAttributes = r2;
        this.mLegacyStreamType = r3;
    }

    public static AudioAttributesImpl fromBundle(Bundle r4) {
        if (r4 != null) goto L5;
        return null;
    L5:
        AudioAttributes r1 = (AudioAttributes) ZeusTransformUtils.preCheckCast(r4.getParcelable("androidx.media.audio_attrs.FRAMEWORKS"), AudioAttributes.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L9;
        return null;
    L9:
        return new AudioAttributesImplApi21(r1, r4.getInt("androidx.media.audio_attrs.LEGACY_STREAM_TYPE", -1));
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

    public boolean equals(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, AudioAttributesImplApi21.class) == true) goto L6;
        return false;
    L6:
        AudioAttributesImplApi21 r4 = (AudioAttributesImplApi21) ZeusTransformUtils.preCheckCast(r3, AudioAttributesImplApi21.class, "com.obric.memorydata.plugin");
        return this.mAudioAttributes.equals(r4.mAudioAttributes);
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
        int r0 = this.mLegacyStreamType;
        if (r0 == (-1)) goto L5;
        return r0;
    L5:
        Method r1 = getAudioAttributesToLegacyStreamTypeMethod();
        if (r1 != null) goto L15;
        Log.w(TAG, "No AudioAttributes#toLegacyStreamType() on API: " + Build.VERSION.SDK_INT);
        return -1;
    L15:
        return ((Integer) ZeusTransformUtils.preCheckCast(r1.invoke(null, new Object[]{this.mAudioAttributes}), Integer.class, "com.obric.memorydata.plugin")).intValue();
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
    public Bundle toBundle() {
        Bundle r0 = new Bundle();
        r0.putParcelable("androidx.media.audio_attrs.FRAMEWORKS", this.mAudioAttributes);
        int r3 = this.mLegacyStreamType;
        if (r3 == (-1)) goto L5;
        r0.putInt("androidx.media.audio_attrs.LEGACY_STREAM_TYPE", r3);
    L5:
        return r0;
    }

    public String toString() {
        return "AudioAttributesCompat: audioattributes=" + this.mAudioAttributes;
    }
}
