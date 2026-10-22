package androidx.transition;

import android.os.IBinder;

/* JADX INFO: loaded from: classes.dex */
class WindowIdApi14 implements WindowIdImpl {
    private final IBinder mToken;

    WindowIdApi14(IBinder r10) {
        this.mToken = r10;
    }

    public boolean equals(Object r10) {
        if ((r10 instanceof WindowIdApi14) == true) goto L5;
    L7:
        return false;
    L5:
        if (((WindowIdApi14) r10).mToken.equals(this.mToken) == false) goto L7;
        return true;
    }

    public int hashCode() {
        return this.mToken.hashCode();
    }
}
