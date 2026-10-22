package x4;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public final class n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ThreadLocal<Boolean> f13532a;

    public n0() {
        new AtomicBoolean(false);
        this.f13532a = new ThreadLocal();
    }

    public final void a(boolean r8) {
        ThreadLocal<Boolean> r10 = this.f13532a;
        if (r8 == false) goto L5;
        r10.set(Boolean.valueOf(r8));
        return;
    L5:
        r10.remove();
        int r11 = r.f13543a;
    }
}
