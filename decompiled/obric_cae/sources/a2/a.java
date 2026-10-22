package a2;

import android.os.Looper;
import androidx.appcompat.app.r;
import androidx.room.k;
import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.thread.AppExecutors;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AppExecutors f27a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList f28b;

    public a(AppExecutors r8) {
        this.f28b = new CopyOnWriteArrayList();
        this.f27a = r8;
    }

    public final void a(BDLocation r8) {
        Logger.i("ByteLocationListenerWrapper: handleLocationChanged() is executed.");
        Iterator r10 = this.f28b.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        ((z1.c) r10.next()).onLocationChanged(r8);
        goto L4
    }

    public final void b(BDLocationException r8) {
        Logger.i("ByteLocationListenerWrapper: handleLocationFailed()!");
        Iterator r10 = this.f28b.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        ((z1.c) r10.next()).onError(r8);
        goto L4
    }

    public final void c(BDLocation r8) {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) goto L5;
        boolean r10 = true;
    L6:
        if (r10 == false) goto L8;
        a(r8);
        return;
    L8:
        this.f27a.mainThread().execute(new r(4, this, r8));
        return;
    L5:
        r10 = false;
        goto L6
    }

    public final void d(BDLocationException r8) {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) goto L5;
        boolean r10 = true;
    L6:
        if (r10 == false) goto L8;
        b(r8);
        return;
    L8:
        this.f27a.mainThread().execute(new k(5, this, r8));
        return;
    L5:
        r10 = false;
        goto L6
    }
}
