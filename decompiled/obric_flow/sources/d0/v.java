package d0;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class v implements com.bumptech.glide.load.data.e, com.bumptech.glide.load.data.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f16571a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r0.d f16572b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f16573c;
    public Priority d;
    public com.bumptech.glide.load.data.d e;
    public List f;
    public boolean g;

    public v(ArrayList r5, r0.d r10) {
        this.f16572b = r10;
        if (r5.isEmpty() == true) goto L7;
        this.f16571a = r5;
        this.f16573c = 0;
        return;
    L7:
        throw new IllegalArgumentException("Must not be empty.");
    }

    @Override // com.bumptech.glide.load.data.d
    public final void a(Exception r5) {
        List r10 = this.f;
        io.reactivex.internal.observers.h.h(r10, "Argument must not be null");
        r10.add(r5);
        g();
    }

    @Override // com.bumptech.glide.load.data.e
    public final void b() {
        List r5 = this.f;
        if (r5 == null) goto L5;
        this.f16572b.release(r5);
    L5:
        this.f = null;
        Iterator r10 = this.f16571a.iterator();
    L7:
        if (r10.hasNext() == false) goto L9;
        ((com.bumptech.glide.load.data.e) r10.next()).b();
        goto L7
    }

    @Override // com.bumptech.glide.load.data.e
    public final Class c() {
        return ((com.bumptech.glide.load.data.e) this.f16571a.get(0)).c();
    }

    @Override // com.bumptech.glide.load.data.e
    public final void cancel() {
        this.g = true;
        Iterator r5 = this.f16571a.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        ((com.bumptech.glide.load.data.e) r5.next()).cancel();
        goto L4
    }

    @Override // com.bumptech.glide.load.data.e
    public final DataSource d() {
        return ((com.bumptech.glide.load.data.e) this.f16571a.get(0)).d();
    }

    @Override // com.bumptech.glide.load.data.e
    public final void e(Priority r5, com.bumptech.glide.load.data.d r10) {
        this.d = r5;
        this.e = r10;
        this.f = (List) this.f16572b.acquire();
        ((com.bumptech.glide.load.data.e) this.f16571a.get(this.f16573c)).e(r5, this);
        if (this.g == false) goto L6;
        cancel();
        return;
    }

    @Override // com.bumptech.glide.load.data.d
    public final void f(Object r5) {
        if (r5 == null) goto L4;
        this.e.f(r5);
        return;
    L4:
        g();
    }

    public final void g() {
        if (this.g == false) goto L6;
        return;
    L6:
        if (this.f16573c >= (this.f16571a.size() - 1)) goto L8;
        this.f16573c++;
        e(this.d, this.e);
        return;
    L8:
        io.reactivex.internal.observers.h.g(this.f);
        this.e.a(new GlideException("Fetch failed", new ArrayList(this.f)));
    }
}
