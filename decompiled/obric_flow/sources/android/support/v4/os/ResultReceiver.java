package android.support.v4.os;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import androidx.annotation.RestrictTo;
import b.b;
import b.c;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ResultReceiver implements Parcelable {
    public static final Parcelable.Creator<ResultReceiver> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f400a;

    static {
        CREATOR = new a5.b(10);
    }

    public void c(int r5, Bundle r10) {
    }

    public final void d(int r5, Bundle r10) {
        b r11 = this.f400a;
        if (r11 == null) goto L9;
        r11.a(r5, r10);     // Catch: RemoteException -> L6
        return;
    L10:
        return;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r5, int r10) {
        monitor-enter(this);
    L6:
        th = move-exception;
        throw th;
    L4:
        if (this.f400a != null) goto L8;
        this.f400a = new c(this);     // Catch: Throwable -> L6
    L8:
        r5.writeStrongBinder(this.f400a.asBinder());     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
    }
}
