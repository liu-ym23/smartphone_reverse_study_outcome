package androidx.core.app;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v4.app.c;
import androidx.annotation.DeprecatedSinceApi;

/* JADX INFO: loaded from: classes.dex */
public abstract class NotificationCompatSideChannelService extends Service {

    public class NotificationSideChannelStub extends android.support.v4.app.b {
        final /* synthetic */ NotificationCompatSideChannelService this$0;

        public NotificationSideChannelStub(NotificationCompatSideChannelService r5) {
            this.this$0 = r5;
            attachInterface(this, c.f1);
        }

        @Override // android.support.v4.app.c
        public void cancel(String r5, int r10, String r11) throws RemoteException {
            this.this$0.checkPermission(Binder.getCallingUid(), r5);
            long r12 = Binder.clearCallingIdentity();
            this.this$0.cancel(r5, r10, r11);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(r12);
            return;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(r12);
            throw th;
        }

        @Override // android.support.v4.app.c
        public void cancelAll(String r5) {
            this.this$0.checkPermission(Binder.getCallingUid(), r5);
            long r10 = Binder.clearCallingIdentity();
            this.this$0.cancelAll(r5);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(r10);
            return;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(r10);
            throw th;
        }

        @Override // android.support.v4.app.c
        public void notify(String r5, int r10, String r11, Notification r12) throws RemoteException {
            this.this$0.checkPermission(Binder.getCallingUid(), r5);
            long r13 = Binder.clearCallingIdentity();
            this.this$0.notify(r5, r10, r11, r12);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(r13);
            return;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(r13);
            throw th;
        }
    }

    public NotificationCompatSideChannelService() {
    }

    public abstract void cancel(String r5, int r10, String r11);

    public abstract void cancelAll(String r5);

    public void checkPermission(int r5, String r10) {
        String[] r11 = getPackageManager().getPackagesForUid(r5);
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L9;
        if (r11[r13].equals(r10) == true) goto L6;
        r13 = r13 + 1;
        goto L3
    L6:
        return;
    L9:
        throw new SecurityException("NotificationSideChannelService: Uid " + r5 + " is not authorized for package " + r10);
    }

    public abstract void notify(String r5, int r10, String r11, Notification r12);

    @Override // android.app.Service
    @DeprecatedSinceApi(api = 19, message = "SDKs past 19 have no need for side channeling.")
    public IBinder onBind(Intent r5) {
        r5.getAction().equals(NotificationManagerCompat.ACTION_BIND_SIDE_CHANNEL);
        return null;
    }
}
