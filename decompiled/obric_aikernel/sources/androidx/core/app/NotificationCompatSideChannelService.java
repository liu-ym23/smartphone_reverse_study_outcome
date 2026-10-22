package androidx.core.app;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;

/* JADX INFO: loaded from: classes.dex */
public abstract class NotificationCompatSideChannelService extends Service {

    private class NotificationSideChannelStub extends android.support.v4.app.a.AbstractBinderC0004a {
        final /* synthetic */ NotificationCompatSideChannelService this$0;

        NotificationSideChannelStub(NotificationCompatSideChannelService r10) {
            this.this$0 = r10;
        }

        @Override // android.support.v4.app.a
        public void cancel(String r10, int r11, String r12) {
            this.this$0.checkPermission(Binder.getCallingUid(), r10);
            long r13 = Binder.clearCallingIdentity();
            this.this$0.cancel(r10, r11, r12);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(r13);
            return;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(r13);
            throw th;
        }

        @Override // android.support.v4.app.a
        public void cancelAll(String r10) {
            this.this$0.checkPermission(Binder.getCallingUid(), r10);
            long r11 = Binder.clearCallingIdentity();
            this.this$0.cancelAll(r10);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(r11);
            return;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(r11);
            throw th;
        }

        @Override // android.support.v4.app.a
        public void notify(String r10, int r11, String r12, Notification r13) {
            this.this$0.checkPermission(Binder.getCallingUid(), r10);
            long r14 = Binder.clearCallingIdentity();
            this.this$0.notify(r10, r11, r12, r13);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(r14);
            return;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(r14);
            throw th;
        }
    }

    public NotificationCompatSideChannelService() {
    }

    public abstract void cancel(String r10, int r11, String r12);

    public abstract void cancelAll(String r10);

    void checkPermission(int r10, String r11) {
        String[] r12 = getPackageManager().getPackagesForUid(r10);
        int r13 = r12.length;
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L9;
        if (r12[r14].equals(r11) == true) goto L6;
        r14 = r14 + 1;
        goto L3
    L6:
        return;
    L9:
        throw new SecurityException("NotificationSideChannelService: Uid " + r10 + " is not authorized for package " + r11);
    }

    public abstract void notify(String r10, int r11, String r12, Notification r13);

    @Override // android.app.Service
    public IBinder onBind(Intent r10) {
        if (r10.getAction().equals(NotificationManagerCompat.ACTION_BIND_SIDE_CHANNEL) == true) goto L5;
        return null;
    L5:
        if (Build.VERSION.SDK_INT <= 19) goto L8;
        return null;
    L8:
        return new NotificationSideChannelStub(this);
    }
}
