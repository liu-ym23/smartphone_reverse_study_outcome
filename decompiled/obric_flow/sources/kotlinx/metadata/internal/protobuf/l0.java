package kotlinx.metadata.internal.protobuf;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class l0 implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f19187a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f19188b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Iterator f19189c;
    public final /* synthetic */ g0 d;

    public l0(g0 r5) {
        this.d = r5;
        this.f19187a = -1;
    }

    public final Iterator a() {
        if (this.f19189c != null) goto L6;
        this.f19189c = this.d.f19171c.entrySet().iterator();
    L6:
        return this.f19189c;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if ((this.f19187a + 1) >= this.d.f19170b.size()) goto L5;
        return true;
    L5:
        if (a().hasNext() == true) goto L10;
        return false;
    L10:
        return true;
    }

    @Override // java.util.Iterator
    public final Object next() {
        this.f19188b = true;
        int r5 = this.f19187a + 1;
        this.f19187a = r5;
        g0 r10 = this.d;
        if (r5 >= r10.f19170b.size()) goto L6;
        return (Map.Entry) r10.f19170b.get(this.f19187a);
    L6:
        return (Map.Entry) a().next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (this.f19188b == false) goto L10;
        this.f19188b = false;
        int r5 = g0.f;
        g0 r10 = this.d;
        r10.b();
        if (this.f19187a >= r10.f19170b.size()) goto L7;
        int r11 = this.f19187a;
        this.f19187a = r11 - 1;
        r10.g(r11);
        return;
    L7:
        a().remove();
        return;
    L10:
        throw new IllegalStateException("remove() was called before next()");
    }
}
