package androidx.core.app;

import android.app.Notification;
import android.os.Binder;
import android.support.v4.app.INotificationSideChannel;

/* JADX INFO: loaded from: classes.dex */
class NotificationCompatSideChannelService$NotificationSideChannelStub extends INotificationSideChannel.Stub {
    @Override // android.support.v4.app.INotificationSideChannel
    public final void D2(String r8, int r10, String r11, Notification r12) {
        Binder.getCallingUid();
        throw null;
    }

    @Override // android.support.v4.app.INotificationSideChannel
    public final void E1(String r8) {
        Binder.getCallingUid();
        throw null;
    }

    @Override // android.support.v4.app.INotificationSideChannel
    public final void Y(int r8, String r10, String r11) {
        Binder.getCallingUid();
        throw null;
    }
}
