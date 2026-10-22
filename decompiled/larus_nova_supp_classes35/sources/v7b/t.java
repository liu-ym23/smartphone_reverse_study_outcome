package v7b;

import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class t implements Iterator<s> {
    public s a;
    public final s b;

    @Override // java.util.Iterator
    public final boolean hasNext() {
        s r0 = this.a;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0 == this.b) goto L7;
        return true;
    }

    @Override // java.util.Iterator
    public final s next() {
        s r0 = this.a;
        this.a = r0.h;
        return r0;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("remove");
    }

    public t(s r1, s r2) {
        this.a = r1;
        this.b = r2;
    }
}
