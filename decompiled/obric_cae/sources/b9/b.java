package b9;

import java.util.UUID;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3136a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CountDownLatch f3137b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c f3138c;

    public b(String r8, int r10) {
        this.f3136a = UUID.randomUUID().toString();
        this.f3137b = new CountDownLatch(1);
    }
}
