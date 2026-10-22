package androidx.media;

import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public abstract class VolumeProviderCompat {
    public static final int VOLUME_CONTROL_ABSOLUTE = 2;
    public static final int VOLUME_CONTROL_FIXED = 0;
    public static final int VOLUME_CONTROL_RELATIVE = 1;
    private Callback mCallback;
    private final int mControlType;
    private int mCurrentVolume;
    private final int mMaxVolume;
    private Object mVolumeProviderObj;

    public static abstract class Callback {
        public Callback() {
        }

        public abstract void onVolumeChanged(VolumeProviderCompat r5);
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface ControlType {
    }

    public VolumeProviderCompat(int r5, int r10, int r11) {
        this.mControlType = r5;
        this.mMaxVolume = r10;
        this.mCurrentVolume = r11;
    }

    public final int getCurrentVolume() {
        return this.mCurrentVolume;
    }

    public final int getMaxVolume() {
        return this.mMaxVolume;
    }

    public final int getVolumeControl() {
        return this.mControlType;
    }

    public Object getVolumeProvider() {
        if (this.mVolumeProviderObj != null) goto L6;
        this.mVolumeProviderObj = VolumeProviderCompatApi21.createVolumeProvider(this.mControlType, this.mMaxVolume, this.mCurrentVolume, new AnonymousClass1(this));
    L6:
        return this.mVolumeProviderObj;
    }

    public void onAdjustVolume(int r5) {
    }

    public void onSetVolumeTo(int r5) {
    }

    public void setCallback(Callback r5) {
        this.mCallback = r5;
    }

    public final void setCurrentVolume(int r5) {
        this.mCurrentVolume = r5;
        Object r10 = getVolumeProvider();
        if (r10 == null) goto L5;
        VolumeProviderCompatApi21.setCurrentVolume(r10, r5);
    L5:
        Callback r11 = this.mCallback;
        if (r11 == null) goto L9;
        r11.onVolumeChanged(this);
        return;
    }
}
