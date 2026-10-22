package androidx.core.app;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.provider.Settings;
import android.support.v4.app.INotificationSideChannel;
import android.util.Log;
import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimCategoryConstants;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class n {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f1634c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f1635d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static HashSet f1636e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Object f1637f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static c f1638g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f1639a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final NotificationManager f1640b;

    public static class a implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f1641a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f1642b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f1643c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Notification f1644d;

        public a(String r8, Notification r10) {
            this.f1641a = r8;
            this.f1642b = 1;
            this.f1643c = null;
            this.f1644d = r10;
        }

        @Override // androidx.core.app.n.d
        public final void a(INotificationSideChannel r8) {
            String r10 = this.f1643c;
            Notification r11 = this.f1644d;
            r8.D2(this.f1641a, this.f1642b, r10, r11);
        }

        public final String toString() {
            StringBuilder r8 = new StringBuilder("NotifyTask[packageName:");
            r8.append(this.f1641a);
            r8.append(", id:");
            r8.append(this.f1642b);
            r8.append(", tag:");
            return android.aimedia.a.i(r8, this.f1643c, "]");
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ComponentName f1645a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final IBinder f1646b;

        public b(ComponentName r8, IBinder r10) {
            this.f1645a = r8;
            this.f1646b = r10;
        }
    }

    public static class c implements Handler.Callback, ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f1647a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Handler f1648b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final HashMap f1649m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public HashSet f1650n;

        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final ComponentName f1651a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public boolean f1652b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public INotificationSideChannel f1653c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final ArrayDeque<d> f1654d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public int f1655e;

            public a(ComponentName r8) {
                this.f1652b = false;
                this.f1654d = new ArrayDeque();
                this.f1655e = 0;
                this.f1651a = r8;
            }
        }

        public c(Context r8) {
            this.f1649m = new HashMap();
            this.f1650n = new HashSet();
            this.f1647a = r8;
            HandlerThread r10 = new HandlerThread("NotificationManagerCompat");
            r10.start();
            this.f1648b = new Handler(r10.getLooper(), this);
        }

        public final void a(a r8) {
            boolean r10 = Log.isLoggable("NotifManCompat", 3);
            ComponentName r11 = r8.f1651a;
            ArrayDeque<d> r12 = r8.f1654d;
            if (r10 == false) goto L6;
            Log.d("NotifManCompat", "Processing component " + r11 + ", " + r12.size() + " queued tasks");
        L6:
            if (r12.isEmpty() == false) goto L9;
            return;
        L9:
            if (r8.f1652b == false) goto L11;
            boolean r13 = true;
        L16:
            if (r13 == true) goto L18;
        L37:
            b(r8);
            return;
        L18:
            if (r8.f1653c == null) goto L37;
        L20:
            d r14 = r12.peek();
            if (r14 == null) goto L34;
            if (Log.isLoggable("NotifManCompat", 3) == false) goto L26;
            Log.d("NotifManCompat", "Sending task " + r14);     // Catch: RemoteException -> L28 DeadObjectException -> L30
        L26:
            r14.a(r8.f1653c);     // Catch: RemoteException -> L28 DeadObjectException -> L30
            r12.remove();     // Catch: RemoteException -> L28 DeadObjectException -> L30
            goto L20
        L28:
            e = move-exception;
            Log.w("NotifManCompat", "RemoteException communicating with " + r11, e);
        L31:
            if (Log.isLoggable("NotifManCompat", 3) == false) goto L34;
            Log.d("NotifManCompat", "Remote service has died: " + r11);
        L34:
            if (r12.isEmpty() == true) goto L44;
            b(r8);
            return;
        L44:
            return;
        L11:
            Intent r15 = new Intent("android.support.BIND_NOTIFICATION_SIDE_CHANNEL").setComponent(r11);
            Context r16 = this.f1647a;
            boolean r17 = r16.bindService(r15, this, 33);
            r8.f1652b = r17;
            if (r17 == false) goto L14;
            r8.f1655e = 0;
        L15:
            r13 = r8.f1652b;
            goto L16
        L14:
            Log.w("NotifManCompat", "Unable to bind to listener " + r11);
            r16.unbindService(this);
            goto L15
        }

        public final void b(a r8) {
            Handler r10 = this.f1648b;
            ComponentName r11 = r8.f1651a;
            if (r10.hasMessages(3, r11) == false) goto L5;
            return;
        L5:
            int r12 = r8.f1655e + 1;
            r8.f1655e = r12;
            if (r12 <= 6) goto L9;
            StringBuilder r13 = new StringBuilder("Giving up on delivering ");
            ArrayDeque<d> r14 = r8.f1654d;
            r13.append(r14.size());
            r13.append(" tasks to ");
            r13.append(r11);
            r13.append(" after ");
            r13.append(r8.f1655e);
            r13.append(" retries");
            Log.w("NotifManCompat", r13.toString());
            r14.clear();
            return;
        L9:
            int r15 = (1 << (r12 - 1)) * 1000;
            if (Log.isLoggable("NotifManCompat", 3) == false) goto L12;
            Log.d("NotifManCompat", "Scheduling retry for " + r15 + " ms");
        L12:
            r10.sendMessageDelayed(r10.obtainMessage(3, r11), r15);
        }

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message r12) {
            int r8 = r12.what;
            if (r8 == 0) goto L24;
            if (r8 != 1) goto L6;
            b r13 = (b) r12.obj;
            ComponentName r10 = r13.f1645a;
            IBinder r14 = r13.f1646b;
            a r11 = (a) this.f1649m.get(r10);
            if (r11 == null) goto L23;
            r11.f1653c = INotificationSideChannel.Stub.H2(r14);
            r11.f1655e = 0;
            a(r11);
        L23:
            return true;
        L6:
            if (r8 == 2) goto L13;
            if (r8 == 3) goto L9;
            return false;
        L9:
            a r15 = (a) this.f1649m.get((ComponentName) r12.obj);
            if (r15 == null) goto L12;
            a(r15);
        L12:
            return true;
        L13:
            a r16 = (a) this.f1649m.get((ComponentName) r12.obj);
            if (r16 != null) goto L16;
        L19:
            return true;
        L16:
            if (r16.f1652b == false) goto L18;
            this.f1647a.unbindService(this);
            r16.f1652b = false;
        L18:
            r16.f1653c = null;
            goto L19
        L24:
            d r17 = (d) r12.obj;
            String r18 = Settings.Secure.getString(this.f1647a.getContentResolver(), "enabled_notification_listeners");
            Object r19 = n.f1634c;
            monitor-enter(r19);
            if (r18 != null) goto L81;
        L38:
            HashSet r20 = n.f1636e;     // Catch: Throwable -> L36
            monitor-exit(r19);     // Catch: Throwable -> L36
            if (r20.equals(this.f1650n) == true) goto L74;
            this.f1650n = r20;
            List<ResolveInfo> r21 = this.f1647a.getPackageManager().queryIntentServices(new Intent().setAction("android.support.BIND_NOTIFICATION_SIDE_CHANNEL"), 0);
            HashSet r22 = new HashSet();
            Iterator<ResolveInfo> r23 = r21.iterator();
        L45:
            if (r23.hasNext() == false) goto L53;
            ResolveInfo r24 = r23.next();
            if (r20.contains(r24.serviceInfo.packageName) == false) goto L45;
            ServiceInfo r25 = r24.serviceInfo;
            ComponentName r26 = new ComponentName(r25.packageName, r25.name);
            if (r24.serviceInfo.permission != null) goto L51;
            r22.add(r26);
            goto L45
        L51:
            Log.w("NotifManCompat", "Permission present on component " + r26 + ", not adding listener record.");
            goto L45
        L53:
            Iterator r27 = r22.iterator();
        L55:
            if (r27.hasNext() == false) goto L62;
            ComponentName r28 = (ComponentName) r27.next();
            if (this.f1649m.containsKey(r28) == true) goto L55;
            if (Log.isLoggable("NotifManCompat", 3) == false) goto L61;
            Log.d("NotifManCompat", "Adding listener record for " + r28);
        L61:
            this.f1649m.put(r28, new a(r28));
            goto L55
        L62:
            Iterator r29 = this.f1649m.entrySet().iterator();
        L64:
            if (r29.hasNext() == false) goto L74;
            Map.Entry r30 = (Map.Entry) r29.next();
            if (r22.contains(r30.getKey()) == true) goto L64;
            if (Log.isLoggable("NotifManCompat", 3) == false) goto L70;
            Log.d("NotifManCompat", "Removing listener record for " + r30.getKey());
        L70:
            a r31 = (a) r30.getValue();
            if (r31.f1652b == false) goto L73;
            this.f1647a.unbindService(this);
            r31.f1652b = false;
        L73:
            r31.f1653c = null;
            r29.remove();
        L74:
            Iterator r32 = this.f1649m.values().iterator();
        L76:
            if (r32.hasNext() == false) goto L78;
            a r33 = (a) r32.next();
            r33.f1654d.add(r17);
            a(r33);
            goto L76
        L78:
            return true;
        L36:
            th = move-exception;
            throw th;
        L81:
            if (r18.equals(n.f1635d) == true) goto L38;
            String[] r34 = r18.split(BdimCategoryConstants.SEPARATOR_COLON, -1);     // Catch: Throwable -> L36
            HashSet r35 = new HashSet(r34.length);     // Catch: Throwable -> L36
            int r36 = r34.length;     // Catch: Throwable -> L36
            int r37 = 0;
        L30:
            if (r37 >= r36) goto L35;
            ComponentName r110 = ComponentName.unflattenFromString(r34[r37]);     // Catch: Throwable -> L36
            if (r110 == null) goto L34;
            r35.add(r110.getPackageName());     // Catch: Throwable -> L36
        L34:
            r37 = r37 + 1;     // Catch: Throwable -> L36
            goto L30
        L35:
            n.f1636e = r35;     // Catch: Throwable -> L36
            n.f1635d = r18;     // Catch: Throwable -> L36
            goto L38
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName r8, IBinder r10) {
            if (Log.isLoggable("NotifManCompat", 3) == false) goto L5;
            Log.d("NotifManCompat", "Connected to service " + r8);
        L5:
            this.f1648b.obtainMessage(1, new b(r8, r10)).sendToTarget();
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName r8) {
            if (Log.isLoggable("NotifManCompat", 3) == false) goto L5;
            Log.d("NotifManCompat", "Disconnected from service " + r8);
        L5:
            this.f1648b.obtainMessage(2, r8).sendToTarget();
        }
    }

    public interface d {
        void a(INotificationSideChannel r8);
    }

    static {
        f1634c = new Object();
        f1636e = new HashSet();
        f1637f = new Object();
    }

    public n(Context r8) {
        this.f1639a = r8;
        this.f1640b = (NotificationManager) r8.getSystemService("notification");
    }
}
