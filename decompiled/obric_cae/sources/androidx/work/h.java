package androidx.work;

import android.app.Notification;

/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2832a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f2833b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Notification f2834c;

    public h(int r8, int r10, Notification r11) {
        this.f2832a = r8;
        this.f2834c = r11;
        this.f2833b = r10;
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if (r8 != null) goto L8;
    L18:
        return false;
    L8:
        if (h.class != r8.getClass()) goto L18;
        h r10 = (h) r8;
        if (this.f2832a == r10.f2832a) goto L14;
        return false;
    L14:
        if (this.f2833b == r10.f2833b) goto L17;
        return false;
    L17:
        return this.f2834c.equals(r10.f2834c);
    }

    public final int hashCode() {
        int r8 = ((this.f2832a * 31) + this.f2833b) * 31;
        return this.f2834c.hashCode() + r8;
    }

    public final String toString() {
        return "ForegroundInfo{mNotificationId=" + this.f2832a + ", mForegroundServiceType=" + this.f2833b + ", mNotification=" + this.f2834c + '}';
    }
}
