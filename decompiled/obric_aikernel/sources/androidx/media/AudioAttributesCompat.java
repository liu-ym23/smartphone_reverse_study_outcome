package androidx.media;

import android.media.AudioAttributes;
import android.os.Build;
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

    static abstract class AudioManagerHidden {
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

        public Builder(AudioAttributesCompat r10) {
            this.mUsage = 0;
            this.mContentType = 0;
            this.mFlags = 0;
            this.mLegacyStream = -1;
            this.mUsage = r10.getUsage();
            this.mContentType = r10.getContentType();
            this.mFlags = r10.getFlags();
            this.mLegacyStream = r10.getRawLegacyStreamType();
        }

        public AudioAttributesCompat build() {
            if (AudioAttributesCompat.sForceLegacyBehavior == false) goto L5;
        L10:
            AudioAttributesImpl r10 = new AudioAttributesImplBase(this.mContentType, this.mFlags, this.mUsage, this.mLegacyStream);
        L12:
            return new AudioAttributesCompat(r10);
        L5:
            if (Build.VERSION.SDK_INT < 21) goto L10;
            AudioAttributes.Builder r11 = new AudioAttributes.Builder().setContentType(this.mContentType).setFlags(this.mFlags).setUsage(this.mUsage);
            int r12 = this.mLegacyStream;
            if (r12 == (-1)) goto L9;
            r11.setLegacyStreamType(r12);
        L9:
            r10 = new AudioAttributesImplApi21(r11.build(), this.mLegacyStream);
            goto L12
        }

        public Builder setContentType(int r10) {
            if (r10 != 0) goto L4;
        L12:
            this.mContentType = r10;
        L13:
            return this;
        L4:
            if (r10 == 1) goto L12;
            if (r10 == 2) goto L12;
            if (r10 == 3) goto L12;
            if (r10 == 4) goto L12;
            this.mUsage = 0;
            goto L13
        }

        public Builder setFlags(int r10) {
            this.mFlags = (r10 & AudioAttributesCompat.FLAG_ALL) | this.mFlags;
            return this;
        }

        Builder setInternalLegacyStreamType(int r10) {
            int r11 = 1;
            switch(r10) {
                case 0: goto L9;
                case 1: goto L8;
                case 2: goto L8;
                case 3: goto L7;
                case 4: goto L8;
                case 5: goto L8;
                case 6: goto L6;
                case 7: goto L5;
                case 8: goto L8;
                case 9: goto L8;
                case 10: goto L9;
                default: goto L4;
            };
        L4:
            Log.e(AudioAttributesCompat.TAG, "Invalid stream type " + r10 + " for AudioAttributesCompat");
        L10:
            this.mUsage = AudioAttributesCompat.usageForStreamType(r10);
            return this;
        L5:
            this.mFlags = 1 | this.mFlags;
            goto L8
        L6:
            this.mContentType = 1;
            this.mFlags |= 4;
            goto L10
        L7:
            r11 = 2;
        L8:
            this.mContentType = 4;
        L9:
            this.mContentType = r11;
            goto L10
        }

        public Builder setLegacyStreamType(int r10) {
            if (r10 == 10) goto L9;
            this.mLegacyStream = r10;
            if (Build.VERSION.SDK_INT >= 21) goto L7;
            return this;
        L7:
            return setInternalLegacyStreamType(r10);
        L9:
            throw new IllegalArgumentException("STREAM_ACCESSIBILITY is not a legacy stream type that was used for audio playback");
        }

        public Builder setUsage(int r10) {
            switch(r10) {
                case 0: goto L10;
                case 1: goto L10;
                case 2: goto L10;
                case 3: goto L10;
                case 4: goto L10;
                case 5: goto L10;
                case 6: goto L10;
                case 7: goto L10;
                case 8: goto L10;
                case 9: goto L10;
                case 10: goto L10;
                case 11: goto L10;
                case 12: goto L10;
                case 13: goto L10;
                case 14: goto L10;
                case 15: goto L10;
                case 16: goto L5;
                default: goto L3;
            };
        L3:
            r10 = 0;
        L10:
            this.mUsage = r10;
            return this;
        L5:
            if (AudioAttributesCompat.sForceLegacyBehavior == false) goto L7;
        L9:
            r10 = 12;
            goto L10
        L7:
            if (Build.VERSION.SDK_INT <= 25) goto L9;
            goto L9
        }
    }

    static {
        SparseIntArray r10 = new SparseIntArray();
        SUPPRESSIBLE_USAGES = r10;
        r10.put(5, 1);
        r10.put(6, 2);
        r10.put(7, 2);
        r10.put(8, 1);
        r10.put(9, 1);
        r10.put(10, 1);
        SDK_USAGES = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 16};
    }

    AudioAttributesCompat() {
    }

    AudioAttributesCompat(AudioAttributesImpl r10) {
        this.mImpl = r10;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static AudioAttributesCompat fromBundle(Bundle r10) {
        if (Build.VERSION.SDK_INT < 21) goto L5;
        AudioAttributesImpl r11 = AudioAttributesImplApi21.fromBundle(r10);
    L6:
        if (r11 != null) goto L9;
        return null;
    L9:
        return new AudioAttributesCompat(r11);
    L5:
        r11 = AudioAttributesImplBase.fromBundle(r10);
        goto L6
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static void setForceLegacyBehavior(boolean r10) {
        sForceLegacyBehavior = r10;
    }

    static int toVolumeStreamType(boolean r10, int r11, int r12) {
        if ((r11 & 1) != 1) goto L9;
        if (r10 == true) goto L36;
        return 7;
    L36:
        return 1;
    L9:
        if ((r11 & 4) != 4) goto L15;
        if (r10 == true) goto L37;
        return 6;
    L37:
        return 0;
    L15:
        switch(r12) {
            case 0: goto L31;
            case 1: goto L30;
            case 2: goto L38;
            case 3: goto L26;
            case 4: goto L25;
            case 5: goto L23;
            case 6: goto L21;
            case 7: goto L23;
            case 8: goto L23;
            case 9: goto L23;
            case 10: goto L23;
            case 11: goto L19;
            case 12: goto L30;
            case 13: goto L18;
            case 14: goto L30;
            case 15: goto L16;
            case 16: goto L30;
            default: goto L16;
        };
    L16:
        if (r10 == true) goto L35;
        return 3;
    L35:
        throw new IllegalArgumentException("Unknown usage value " + r12 + " in audio attributes");
    L18:
        return 1;
    L19:
        return 10;
    L21:
        return 2;
    L23:
        return 5;
    L25:
        return 4;
    L26:
        if (r10 == true) goto L39;
        return 8;
    L39:
        return 0;
    L30:
        return 3;
    L31:
        if (r10 == false) goto L40;
        return Integer.MIN_VALUE;
    L40:
        return 3;
    L38:
        return 0;
    }

    static int toVolumeStreamType(boolean r10, AudioAttributesCompat r11) {
        return toVolumeStreamType(r10, r11.getFlags(), r11.getUsage());
    }

    static int usageForStreamType(int r10) {
        switch(r10) {
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

    static String usageToString(int r10) {
        switch(r10) {
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
        return "unknown usage " + r10;
    }

    @Nullable
    public static AudioAttributesCompat wrap(@NonNull Object r10) {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return null;
    L5:
        if (sForceLegacyBehavior == true) goto L10;
        AudioAttributesImplApi21 r11 = new AudioAttributesImplApi21((AudioAttributes) r10);
        AudioAttributesCompat r12 = new AudioAttributesCompat();
        r12.mImpl = r11;
        return r12;
    L10:
        return null;
    }

    public boolean equals(Object r10) {
        if ((r10 instanceof AudioAttributesCompat) == true) goto L5;
        return false;
    L5:
        AudioAttributesCompat r11 = (AudioAttributesCompat) r10;
        AudioAttributesImpl r12 = this.mImpl;
        if (r12 != null) goto L12;
        if (r11.mImpl != null) goto L13;
        return true;
    L13:
        return false;
    L12:
        return r12.equals(r11.mImpl);
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

    int getRawLegacyStreamType() {
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
}
