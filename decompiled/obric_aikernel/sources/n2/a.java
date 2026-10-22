package n2;

import com.bytedance.frameworks.baselib.network.dispatcher.IRequest;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements IRequest, Runnable, Comparable<IRequest> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final AtomicBoolean f11179c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected int f11180g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected int f11181h;

    public a() {
        new AtomicBoolean(false);
        this.f11179c = new AtomicBoolean(false);
        this.f11180g = 0;
    }

    public int c() {
        return this.f11180g;
    }

    public boolean d() {
        return this.f11179c.get();
    }

    public boolean e() {
        return false;
    }

    @Deprecated
    public boolean f() {
        return false;
    }

    public a g(int r10) {
        this.f11181h = r10;
        return this;
    }
}
