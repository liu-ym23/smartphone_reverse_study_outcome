package androidx.work;

import android.app.Notification;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public final class ForegroundInfo {
    private final int mForegroundServiceType;
    private final Notification mNotification;
    private final int mNotificationId;

    public ForegroundInfo(int r10, @NonNull Notification r11) {
        this(r10, r11, 0);
    }

    public ForegroundInfo(int r10, @NonNull Notification r11, int r12) {
        this.mNotificationId = r10;
        this.mNotification = r11;
        this.mForegroundServiceType = r12;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if (r10 != null) goto L8;
    L18:
        return false;
    L8:
        if (ForegroundInfo.class != r10.getClass()) goto L18;
        ForegroundInfo r11 = (ForegroundInfo) r10;
        if (this.mNotificationId == r11.mNotificationId) goto L14;
        return false;
    L14:
        if (this.mForegroundServiceType == r11.mForegroundServiceType) goto L17;
        return false;
    L17:
        return this.mNotification.equals(r11.mNotification);
    }

    public int getForegroundServiceType() {
        return this.mForegroundServiceType;
    }

    @NonNull
    public Notification getNotification() {
        return this.mNotification;
    }

    public int getNotificationId() {
        return this.mNotificationId;
    }

    public int hashCode() {
        return (((this.mNotificationId * 31) + this.mForegroundServiceType) * 31) + this.mNotification.hashCode();
    }

    public String toString() {
        return "ForegroundInfo{mNotificationId=" + this.mNotificationId + ", mForegroundServiceType=" + this.mForegroundServiceType + ", mNotification=" + this.mNotification + '}';
    }
}
