package androidx.media;

import android.os.Build;
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

        public abstract void onVolumeChanged(VolumeProviderCompat r10);
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface ControlType {
    }

    public VolumeProviderCompat(int r10, int r11, int r12) {
        this.mControlType = r10;
        this.mMaxVolume = r11;
        this.mCurrentVolume = r12;
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
        if (this.mVolumeProviderObj != null) goto L8;
        if (Build.VERSION.SDK_INT < 21) goto L8;
        this.mVolumeProviderObj = VolumeProviderCompatApi21.createVolumeProvider(this.mControlType, this.mMaxVolume, this.mCurrentVolume, new AnonymousClass1(this));
    L8:
        return this.mVolumeProviderObj;
    }

    public void onAdjustVolume(int r10) {
    }

    public void onSetVolumeTo(int r10) {
    }

    public void setCallback(Callback r10) {
        this.mCallback = r10;
    }

    public final void setCurrentVolume(int r10) {
        this.mCurrentVolume = r10;
        Object r11 = getVolumeProvider();
        if (r11 != null) goto L5;
    L7:
        Callback r12 = this.mCallback;
        if (r12 == null) goto L11;
        r12.onVolumeChanged(this);
        return;
    L11:
        return;
    L5:
        if (Build.VERSION.SDK_INT < 21) goto L7;
        VolumeProviderCompatApi21.setCurrentVolume(r11, r10);
        goto L7
    }
}
