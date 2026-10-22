package nt;

import android.os.Handler;
import android.os.Message;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.TimeUnit;
import mt.w;
import mt.y;
import mt.z;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends z {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f20311b;

    public d(Handler r5) {
        this.f20311b = r5;
    }

    @Override // mt.z
    public final y a() {
        return new c(this.f20311b);
    }

    @Override // mt.z
    public final Disposable d(Runnable r5, long r10, TimeUnit r11) {
        if (r11 == null) goto L6;
        Handler r12 = this.f20311b;
        w r13 = new w(r12, r5);
        r12.sendMessageDelayed(Message.obtain(r12, r13), r11.toMillis(r10));
        return r13;
    L6:
        throw new NullPointerException("unit == null");
    }
}
