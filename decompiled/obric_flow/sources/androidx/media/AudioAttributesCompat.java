package androidx.media;

import ai.j0;
import android.media.AudioAttributes;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.versionedparcelable.VersionedParcelable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public class AudioAttributesCompat implements VersionedParcelable {
    static final String AUDIO_ATTRIBUTES_CONTENT_TYPE = "androidx.media.audio_attrs.CONTENT_TYPE";
    static final String AUDIO_ATTRIBUTES_FLAGS = "androidx.media.audio_attrs.FLAGS";
    static final String AUDIO_ATTRIBUTES_FRAMEWORKS = "androidx.media.audio_attrs.FRAMEWORKS";
    static final String AUDIO_ATTRIBUTES_LEGACY_STREAM_TYPE = "androidx.media.audio_attrs.LEGACY_STREAM_TYPE";
    static final String AUDIO_ATTRIBUTES_USAGE = "androidx.media.audio_attrs.USAGE";
    public static final int CONTENT_TYPE_MOVIE = 3;
    public static final int CONTENT_TYPE_MUSIC = 2;
    public static final int CONTENT_TYPE_SONIFICATION = 4;
    public static final int CONTENT_TYPE_SPEECH = 1;
    public static final int CONTENT_TYPE_UNKNOWN = 0;
    static final int FLAG_ALL = 1023;
    static final int FLAG_ALL_PUBLIC = 273;
    public static final int FLAG_AUDIBILITY_ENFORCED = 1;
    static final int FLAG_BEACON = 8;
    static final int FLAG_BYPASS_INTERRUPTION_POLICY = 64;
    static final int FLAG_BYPASS_MUTE = 128;
    static final int FLAG_DEEP_BUFFER = 512;
    public static final int FLAG_HW_AV_SYNC = 16;
    static final int FLAG_HW_HOTWORD = 32;
    static final int FLAG_LOW_LATENCY = 256;
    static final int FLAG_SCO = 4;
    static final int FLAG_SECURE = 2;
    static final int INVALID_STREAM_TYPE = -1;
    private static final int[] SDK_USAGES = null;
    private static final int SUPPRESSIBLE_CALL = 2;
    private static final int SUPPRESSIBLE_NOTIFICATION = 1;
    private static final SparseIntArray SUPPRESSIBLE_USAGES = null;
    private static final String TAG = "AudioAttributesCompat";
    public static final int USAGE_ALARM = 4;
    public static final int USAGE_ASSISTANCE_ACCESSIBILITY = 11;
    public static final int USAGE_ASSISTANCE_NAVIGATION_GUIDANCE = 12;
    public static final int USAGE_ASSISTANCE_SONIFICATION = 13;
    public static final int USAGE_ASSISTANT = 16;
    public static final int USAGE_GAME = 14;
    public static final int USAGE_MEDIA = 1;
    public static final int USAGE_NOTIFICATION = 5;
    public static final int USAGE_NOTIFICATION_COMMUNICATION_DELAYED = 9;
    public static final int USAGE_NOTIFICATION_COMMUNICATION_INSTANT = 8;
    public static final int USAGE_NOTIFICATION_COMMUNICATION_REQUEST = 7;
    public static final int USAGE_NOTIFICATION_EVENT = 10;
    public static final int USAGE_NOTIFICATION_RINGTONE = 6;
    public static final int USAGE_UNKNOWN = 0;
    private static final int USAGE_VIRTUAL_SOURCE = 15;
    public static final int USAGE_VOICE_COMMUNICATION = 2;
    public static final int USAGE_VOICE_COMMUNICATION_SIGNALLING = 3;
    static boolean sForceLegacyBehavior;
    AudioAttributesImpl mImpl;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface AttributeContentType {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface AttributeUsage {
    }

    public static abstract class AudioManagerHidden {
        public static final int STREAM_ACCESSIBILITY = 10;
        public static final int STREAM_BLUETOOTH_SCO = 6;
        public static final int STREAM_SYSTEM_ENFORCED = 7;
        public static final int STREAM_TTS = 9;

        private AudioManagerHidden() {
        }
    }

    public static class Builder {
        private int mContentType;
        private int mFlags;
        private int mLegacyStream;
        private int mUsage;

        public Builder() {
            this.mUsage = 0;
            this.mContentType = 0;
            this.mFlags = 0;
            this.mLegacyStream = -1;
        }

        public AudioAttributesCompat build() {
            if (AudioAttributesCompat.sForceLegacyBehavior == true) goto L8;
            AudioAttributes.Builder r5 = new AudioAttributes.Builder().setContentType(this.mContentType).setFlags(this.mFlags).setUsage(this.mUsage);
            int r10 = this.mLegacyStream;
            if (r10 == (-1)) goto L7;
            r5.setLegacyStreamType(r10);
        L7:
            AudioAttributesImpl r11 = new AudioAttributesImplApi21(r5.build(), this.mLegacyStream);
        L10:
            return new AudioAttributesCompat(r11);
        L8:
            r11 = new AudioAttributesImplBase(this.mContentType, this.mFlags, this.mUsage, this.mLegacyStream);
            goto L10
        }

        public Builder setContentType(int r5) {
            if (r5 != 0) goto L4;
        L12:
            this.mContentType = r5;
        L13:
            return this;
        L4:
            if (r5 == 1) goto L12;
            if (r5 == 2) goto L12;
            if (r5 == 3) goto L12;
            if (r5 == 4) goto L12;
            this.mUsage = 0;
            goto L13
        }

        public Builder setFlags(int r5) {
            this.mFlags = (r5 & AudioAttributesCompat.FLAG_ALL) | this.mFlags;
            return this;
        }

        public Builder setInternalLegacyStreamType(int r5) {
            switch(r5) {
                case 0: goto L15;
                case 1: goto L14;
                case 2: goto L13;
                case 3: goto L12;
                case 4: goto L11;
                case 5: goto L10;
                case 6: goto L9;
                case 7: goto L8;
                case 8: goto L7;
                case 9: goto L6;
                case 10: goto L5;
                default: goto L4;
            };
        L4:
            Log.e(AudioAttributesCompat.TAG, "Invalid stream type " + r5 + " for AudioAttributesCompat");
        L16:
            this.mUsage = AudioAttributesCompat.usageForStreamType(r5);
            return this;
        L5:
            this.mContentType = 1;
            goto L16
        L6:
            this.mContentType = 4;
            goto L16
        L7:
            this.mContentType = 4;
            goto L16
        L8:
            this.mFlags = 1 | this.mFlags;
            goto L14
        L9:
            this.mContentType = 1;
            this.mFlags |= 4;
            goto L16
        L10:
            this.mContentType = 4;
            goto L16
        L11:
            this.mContentType = 4;
            goto L16
        L12:
            this.mContentType = 2;
            goto L16
        L13:
            this.mContentType = 4;
        L14:
            this.mContentType = 4;
            goto L16
        L15:
            this.mContentType = 1;
            goto L16
        }

        public Builder setLegacyStreamType(int r5) {
            if (r5 == 10) goto L7;
            this.mLegacyStream = r5;
            return setInternalLegacyStreamType(r5);
        L7:
            throw new IllegalArgumentException("STREAM_ACCESSIBILITY is not a legacy stream type that was used for audio playback");
        }

        public Builder setUsage(int r5) {
            switch(r5) {
                case 0: goto L8;
                case 1: goto L8;
                case 2: goto L8;
                case 3: goto L8;
                case 4: goto L8;
                case 5: goto L8;
                case 6: goto L8;
                case 7: goto L8;
                case 8: goto L8;
                case 9: goto L8;
                case 10: goto L8;
                case 11: goto L8;
                case 12: goto L8;
                case 13: goto L8;
                case 14: goto L8;
                case 15: goto L8;
                case 16: goto L5;
                default: goto L3;
            };
        L3:
            this.mUsage = 0;
        L9:
            return this;
        L8:
            this.mUsage = r5;
            goto L9
        L5:
            if (AudioAttributesCompat.sForceLegacyBehavior == true) goto L7;
            this.mUsage = r5;
            goto L9
        L7:
            this.mUsage = 12;
            goto L9
        }

        public Builder(AudioAttributesCompat r5) {
            this.mUsage = 0;
            this.mContentType = 0;
            this.mFlags = 0;
            this.mLegacyStream = -1;
            this.mUsage = r5.getUsage();
            this.mContentType = r5.getContentType();
            this.mFlags = r5.getFlags();
            this.mLegacyStream = r5.getRawLegacyStreamType();
        }
    }

    static {
        SparseIntArray r5 = new SparseIntArray();
        SUPPRESSIBLE_USAGES = r5;
        r5.put(5, 1);
        r5.put(6, 2);
        r5.put(7, 2);
        r5.put(8, 1);
        r5.put(9, 1);
        r5.put(10, 1);
        SDK_USAGES = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 16};
    }

    public AudioAttributesCompat() {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static AudioAttributesCompat fromBundle(Bundle r5) {
        AudioAttributesImpl r10 = AudioAttributesImplApi21.fromBundle(r5);
        if (r10 != null) goto L6;
        return null;
    L6:
        return new AudioAttributesCompat(r10);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static void setForceLegacyBehavior(boolean r5) {
        sForceLegacyBehavior = r5;
    }

    public static int toVolumeStreamType(boolean r5, AudioAttributesCompat r10) {
        return toVolumeStreamType(r5, r10.getFlags(), r10.getUsage());
    }

    public static int usageForStreamType(int r5) {
        switch(r5) {
            case 0: goto L21;
            case 1: goto L19;
            case 2: goto L17;
            case 3: goto L15;
            case 4: goto L13;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L19;
            case 8: goto L8;
            case 9: goto L4;
            case 10: goto L6;
            default: goto L4;
        };
    L4:
        return 0;
    L6:
        return 11;
    L8:
        return 3;
    L10:
        return 2;
    L11:
        return 5;
    L13:
        return 4;
    L15:
        return 1;
    L17:
        return 6;
    L19:
        return 13;
    L21:
        return 2;
    }

    public static String usageToString(int r5) {
        switch(r5) {
            case 0: goto L35;
            case 1: goto L33;
            case 2: goto L31;
            case 3: goto L29;
            case 4: goto L27;
            case 5: goto L25;
            case 6: goto L23;
            case 7: goto L21;
            case 8: goto L19;
            case 9: goto L17;
            case 10: goto L15;
            case 11: goto L13;
            case 12: goto L11;
            case 13: goto L9;
            case 14: goto L7;
            case 15: goto L4;
            case 16: goto L5;
            default: goto L4;
        };
    L5:
        return "USAGE_ASSISTANT";
    L7:
        return "USAGE_GAME";
    L9:
        return "USAGE_ASSISTANCE_SONIFICATION";
    L11:
        return "USAGE_ASSISTANCE_NAVIGATION_GUIDANCE";
    L13:
        return "USAGE_ASSISTANCE_ACCESSIBILITY";
    L15:
        return "USAGE_NOTIFICATION_EVENT";
    L17:
        return "USAGE_NOTIFICATION_COMMUNICATION_DELAYED";
    L19:
        return "USAGE_NOTIFICATION_COMMUNICATION_INSTANT";
    L21:
        return "USAGE_NOTIFICATION_COMMUNICATION_REQUEST";
    L23:
        return "USAGE_NOTIFICATION_RINGTONE";
    L25:
        return "USAGE_NOTIFICATION";
    L27:
        return "USAGE_ALARM";
    L29:
        return "USAGE_VOICE_COMMUNICATION_SIGNALLING";
    L31:
        return "USAGE_VOICE_COMMUNICATION";
    L33:
        return "USAGE_MEDIA";
    L35:
        return "USAGE_UNKNOWN";
    L4:
        return j0.g(r5, "unknown usage ");
    }

    @Nullable
    public static AudioAttributesCompat wrap(@NonNull Object r5) {
        if (sForceLegacyBehavior == true) goto L6;
        AudioAttributesImplApi21 r10 = new AudioAttributesImplApi21((AudioAttributes) r5);
        AudioAttributesCompat r11 = new AudioAttributesCompat();
        r11.mImpl = r10;
        return r11;
    L6:
        return null;
    }

    public boolean equals(Object r5) {
        if ((r5 instanceof AudioAttributesCompat) == true) goto L5;
        return false;
    L5:
        AudioAttributesCompat r10 = (AudioAttributesCompat) r5;
        AudioAttributesImpl r11 = this.mImpl;
        if (r11 != null) goto L12;
        if (r10.mImpl != null) goto L13;
        return true;
    L13:
        return false;
    L12:
        return r11.equals(r10.mImpl);
    }

    public int getContentType() {
        return this.mImpl.getContentType();
    }

    public int getFlags() {
        return this.mImpl.getFlags();
    }

    public int getLegacyStreamType() {
        return this.mImpl.getLegacyStreamType();
    }

    public int getRawLegacyStreamType() {
        return this.mImpl.getRawLegacyStreamType();
    }

    public int getUsage() {
        return this.mImpl.getUsage();
    }

    public int getVolumeControlStream() {
        return this.mImpl.getVolumeControlStream();
    }

    public int hashCode() {
        return this.mImpl.hashCode();
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Bundle toBundle() {
        return this.mImpl.toBundle();
    }

    public String toString() {
        return this.mImpl.toString();
    }

    @Nullable
    public Object unwrap() {
        return this.mImpl.getAudioAttributes();
    }

    public AudioAttributesCompat(AudioAttributesImpl r5) {
        this.mImpl = r5;
    }

    public static int toVolumeStreamType(boolean r5, int r10, int r11) {
        if ((r10 & 1) != 1) goto L9;
        if (r5 == true) goto L36;
        return 7;
    L36:
        return 1;
    L9:
        if ((r10 & 4) != 4) goto L15;
        if (r5 == true) goto L37;
        return 6;
    L37:
        return 0;
    L15:
        switch(r11) {
            case 0: goto L33;
            case 1: goto L32;
            case 2: goto L38;
            case 3: goto L28;
            case 4: goto L27;
            case 5: goto L25;
            case 6: goto L23;
            case 7: goto L25;
            case 8: goto L25;
            case 9: goto L25;
            case 10: goto L25;
            case 11: goto L21;
            case 12: goto L32;
            case 13: goto L20;
            case 14: goto L32;
            case 15: goto L16;
            case 16: goto L32;
            default: goto L16;
        };
    L16:
        if (r5 == true) goto L19;
        return 3;
    L19:
        throw new IllegalArgumentException(j0.h(r11, "Unknown usage value ", " in audio attributes"));
    L20:
        return 1;
    L21:
        return 10;
    L23:
        return 2;
    L25:
        return 5;
    L27:
        return 4;
    L28:
        if (r5 == true) goto L39;
        return 8;
    L39:
        return 0;
    L32:
        return 3;
    L33:
        if (r5 == false) goto L40;
        return Integer.MIN_VALUE;
    L40:
        return 3;
    L38:
        return 0;
    }
}
