package androidx.room;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.qualcomm.qti.qesdk.QesdkUtils;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public final class MultiInstanceInvalidationClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2580a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i f2581b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Executor f2582c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f2583d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f2584e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public i.c f2585f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public IMultiInstanceInvalidationService f2586g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final MultiInstanceInvalidationClient$callback$1 f2587h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final AtomicBoolean f2588i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final b f2589j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final androidx.activity.d f2590k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final androidx.activity.j f2591l;

    public static final class a extends i.c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ MultiInstanceInvalidationClient f2592b;

        public a(MultiInstanceInvalidationClient r8, String[] r10) {
            this.f2592b = r8;
            super(r10);
        }

        @Override // androidx.room.i.c
        public final void a(Set<String> r8) {
            he.i.f(r8, "tables");
            MultiInstanceInvalidationClient r10 = this.f2592b;
            if (r10.f2588i.get() == false) goto L12;
            return;
        L12:
            IMultiInstanceInvalidationService r11 = r10.f2586g;     // Catch: RemoteException -> L9
            if (r11 == null) goto L14;
            r11.b1(r10.f2584e, (String[]) r8.toArray(new String[0]));     // Catch: RemoteException -> L9
            return;
        L14:
            return;
        L9:
            e = move-exception;
            Log.w("ROOM", "Cannot broadcast invalidation", e);
        }
    }

    public static final class b implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MultiInstanceInvalidationClient f2593a;

        public b(MultiInstanceInvalidationClient r8) {
            this.f2593a = r8;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName r8, IBinder r10) {
            he.i.f(r8, QesdkUtils.TAGS.JSON_TAG_NAME);
            he.i.f(r10, "service");
            IMultiInstanceInvalidationService r11 = IMultiInstanceInvalidationService.Stub.H2(r10);
            MultiInstanceInvalidationClient r12 = this.f2593a;
            r12.f2586g = r11;
            r12.f2582c.execute(r12.f2590k);
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName r8) {
            he.i.f(r8, QesdkUtils.TAGS.JSON_TAG_NAME);
            MultiInstanceInvalidationClient r10 = this.f2593a;
            r10.f2582c.execute(r10.f2591l);
            r10.f2586g = null;
        }
    }

    public MultiInstanceInvalidationClient(Context r8, String r10, Intent r11, i r12, Executor r13) {
        he.i.f(r13, "executor");
        this.f2580a = r10;
        this.f2581b = r12;
        this.f2582c = r13;
        Context r14 = r8.getApplicationContext();
        this.f2583d = r14;
        this.f2587h = new MultiInstanceInvalidationClient$callback$1(this);
        this.f2588i = new AtomicBoolean(false);
        b r15 = new b(this);
        this.f2589j = r15;
        this.f2590k = new androidx.activity.d(this, 6);
        this.f2591l = new androidx.activity.j(this, 5);
        this.f2585f = new a(this, (String[]) r12.f2626d.keySet().toArray(new String[0]));
        r14.bindService(r11, r15, 1);
    }
}
