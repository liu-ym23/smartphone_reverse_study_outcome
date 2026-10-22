package android.support.v4.os;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
public class ResultReceiver implements Parcelable {
    public static final Parcelable.Creator<ResultReceiver> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IResultReceiver f434a;

    public class MyResultReceiver extends IResultReceiver.Stub {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ResultReceiver f435b;

        public MyResultReceiver(ResultReceiver r8) {
            this.f435b = r8;
        }

        public final void send(int r8, Bundle r10) {
            ResultReceiver r11 = this.f435b;
            r11.getClass();
            r11.t(r8, r10);
        }
    }

    public class a implements Parcelable.Creator<ResultReceiver> {
        @Override // android.os.Parcelable.Creator
        public final ResultReceiver createFromParcel(Parcel r8) {
            return new ResultReceiver(r8);
        }

        @Override // android.os.Parcelable.Creator
        public final ResultReceiver[] newArray(int r8) {
            return new ResultReceiver[r8];
        }
    }

    static {
        CREATOR = new a();
    }

    public ResultReceiver(Parcel r8) {
        IBinder r10 = r8.readStrongBinder();
        int r11 = IResultReceiver.Stub.f432a;
        if (r10 != null) goto L5;
        IResultReceiver r12 = null;
    L11:
        this.f434a = r12;
        return;
    L5:
        IInterface r13 = r10.queryLocalInterface("android.support.v4.os.IResultReceiver");
        if (r13 != null) goto L8;
    L10:
        r12 = new IResultReceiver.Stub.Proxy(r10);
        goto L11
    L8:
        if ((r13 instanceof IResultReceiver) == false) goto L10;
        r12 = (IResultReceiver) r13;
        goto L11
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public void t(int r8, Bundle r10) {
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r8, int r10) {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.f434a != null) goto L6;
        this.f434a = new MyResultReceiver(this);     // Catch: Throwable -> L9
    L6:
        r8.writeStrongBinder(this.f434a.asBinder());     // Catch: Throwable -> L9
        monitor-exit(this);     // Catch: Throwable -> L9
    }
}
