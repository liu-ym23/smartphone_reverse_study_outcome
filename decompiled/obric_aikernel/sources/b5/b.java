package b5;

import com.bytedance.ttnet.TTNetInit;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import r2.i;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f526a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f527b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f528c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Map<String, String> f529d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private CountDownLatch f530e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private c f531f;

    b(String r10, int r11, Map<String, String> r12) {
        this.f526a = r10;
        this.f527b = r11;
        this.f529d = r12;
        this.f528c = UUID.randomUUID().toString();
        this.f530e = new CountDownLatch(1);
    }

    public void a() {
        this.f530e.await();
    }

    public void b() {
        i.w(TTNetInit.getTTNetDepend().getContext()).d0(this.f526a, this.f527b, this.f528c, this.f529d);
    }

    public c c() {
        return this.f531f;
    }

    public void d() {
        this.f530e.countDown();
    }

    public void e(c r10) {
        this.f531f = r10;
    }

    public String f() {
        return this.f528c;
    }
}
