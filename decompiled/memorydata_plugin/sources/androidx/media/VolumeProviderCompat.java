package androidx.media;

import android.os.Build;
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

        public abstract void onVolumeChanged(VolumeProviderCompat r1);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ControlType {
    }

    public VolumeProviderCompat(int r1, int r2, int r3) {
        this.mControlType = r1;
        this.mMaxVolume = r2;
        this.mCurrentVolume = r3;
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

    public void onAdjustVolume(int r1) {
    }

    public void onSetVolumeTo(int r1) {
    }

    public void setCallback(Callback r1) {
        this.mCallback = r1;
    }

    public final void setCurrentVolume(int r4) {
        this.mCurrentVolume = r4;
        Object r0 = getVolumeProvider();
        if (r0 != null) goto L5;
    L7:
        Callback r5 = this.mCallback;
        if (r5 == null) goto L11;
        r5.onVolumeChanged(this);
        return;
    L11:
        return;
    L5:
        if (Build.VERSION.SDK_INT < 21) goto L7;
        VolumeProviderCompatApi21.setCurrentVolume(r0, r4);
        goto L7
    }
}
