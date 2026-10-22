package android.support.v4.os;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ResultReceiver implements Parcelable {
    public static final Parcelable.Creator<ResultReceiver> CREATOR = null;
    final Handler mHandler;
    final boolean mLocal;
    android.support.v4.os.a mReceiver;

    class a implements Parcelable.Creator<ResultReceiver> {
        a() {
        }

        public ResultReceiver a(Parcel r10) {
            return new ResultReceiver(r10);
        }

        public ResultReceiver[] b(int r10) {
            return new ResultReceiver[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ResultReceiver createFromParcel(Parcel r10) {
            return a(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ResultReceiver[] newArray(int r10) {
            return b(r10);
        }
    }

    class b extends android.support.v4.os.a.AbstractBinderC0013a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ResultReceiver f207c;

        b(ResultReceiver r10) {
            this.f207c = r10;
        }

        @Override // android.support.v4.os.a
        public void n2(int r10, Bundle r11) {
            ResultReceiver r12 = this.f207c;
            Handler r13 = r12.mHandler;
            if (r13 == null) goto L5;
            r13.post(new c(r12, r10, r11));
            return;
        L5:
            r12.onReceiveResult(r10, r11);
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int f208c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final Bundle f209g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ ResultReceiver f210h;

        c(ResultReceiver r10, int r11, Bundle r12) {
            this.f210h = r10;
            this.f208c = r11;
            this.f209g = r12;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f210h.onReceiveResult(this.f208c, this.f209g);
        }
    }

    static {
        CREATOR = new a();
    }

    public ResultReceiver(Handler r10) {
        this.mLocal = true;
        this.mHandler = r10;
    }

    ResultReceiver(Parcel r10) {
        this.mLocal = false;
        this.mHandler = null;
        this.mReceiver = android.support.v4.os.a.AbstractBinderC0013a.U0(r10.readStrongBinder());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    protected void onReceiveResult(int r10, Bundle r11) {
    }

    public void send(int r10, Bundle r11) {
        if (this.mLocal == false) goto L9;
        Handler r12 = this.mHandler;
        if (r12 == null) goto L7;
        r12.post(new c(this, r10, r11));
        return;
    L7:
        onReceiveResult(r10, r11);
        return;
    L9:
        android.support.v4.os.a r13 = this.mReceiver;
        if (r13 == null) goto L17;
        r13.n2(r10, r11);     // Catch: RemoteException -> L13
        return;
    L18:
        return;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel r10, int r11) {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.mReceiver != null) goto L6;
        this.mReceiver = new b(this);     // Catch: Throwable -> L9
    L6:
        r10.writeStrongBinder(this.mReceiver.asBinder());     // Catch: Throwable -> L9
        monitor-exit(this);     // Catch: Throwable -> L9
    }
}
