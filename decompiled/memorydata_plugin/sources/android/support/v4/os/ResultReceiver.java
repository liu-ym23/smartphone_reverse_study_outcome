package android.support.v4.os;

import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public class ResultReceiver implements Parcelable {
    public static final Parcelable.Creator<ResultReceiver> CREATOR = null;
    final Handler mHandler;
    final boolean mLocal;
    android.support.v4.os.a mReceiver;

    class a extends android.support.v4.os.a.AbstractBinderC0015a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ResultReceiver f76b;

        a(ResultReceiver r1) {
            this.f76b = r1;
        }

        @Override // android.support.v4.os.a
        public void a(int r3, Bundle r4) {
            if (this.f76b.mHandler == null) goto L5;
            this.f76b.mHandler.post(new b(this.f76b, r3, r4));
            return;
        L5:
            this.f76b.onReceiveResult(r3, r4);
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f77a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Bundle f78b;
        final /* synthetic */ ResultReceiver c;

        b(ResultReceiver r1, int r2, Bundle r3) {
            this.c = r1;
            this.f77a = r2;
            this.f78b = r3;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.c.onReceiveResult(this.f77a, this.f78b);
        }
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public ResultReceiver(Handler r2) {
        this.mLocal = true;
        this.mHandler = r2;
    }

    ResultReceiver(Parcel r2) {
        this.mLocal = false;
        this.mHandler = null;
        this.mReceiver = android.support.v4.os.a.AbstractBinderC0015a.a(r2.readStrongBinder());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void onReceiveResult(int r1, Bundle r2) {
    }

    public void send(int r3, Bundle r4) {
        if (this.mLocal == false) goto L9;
        Handler r0 = this.mHandler;
        if (r0 == null) goto L7;
        r0.post(new b(this, r3, r4));
        return;
    L7:
        onReceiveResult(r3, r4);
        return;
    L9:
        android.support.v4.os.a r2 = this.mReceiver;
        if (r2 == null) goto L17;
        r2.a(r3, r4);     // Catch: RemoteException -> L13
        return;
    L18:
        return;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.mReceiver != null) goto L6;
        this.mReceiver = new a(this);     // Catch: Throwable -> L9
    L6:
        r1.writeStrongBinder(this.mReceiver.asBinder());     // Catch: Throwable -> L9
        monitor-exit(this);     // Catch: Throwable -> L9
    }
}
