package z5;

import com.bytedance.common.utility.collection.WeakHandler;

/* JADX INFO: loaded from: classes.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f14254a;

    public c(b r8) {
        this.f14254a = r8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        b r8 = this.f14254a;
        r8.f14230q = true;
        WeakHandler r10 = r8.f14232s;
        r10.removeMessages(2);
        r10.removeMessages(1);
        r10.removeMessages(3);
        r10.removeMessages(5);
        f5.a r11 = r8.f14226m;
        if (r11 == null) goto L5;
        r11.c();
    L5:
        r10.removeMessages(1);
        r8.p();
    }
}
