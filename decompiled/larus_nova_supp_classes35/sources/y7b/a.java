package y7b;

import com.ss.android.lark.commonmark.internal.n;
import com.ss.android.lark.commonmark.internal.r;
import java.util.ArrayList;
import v7b.x;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public abstract class a implements d {
    public a() {
    }

    @Override // y7b.d
    public boolean b() {
        return this instanceof r;
    }

    @Override // y7b.d
    public void c() {
    }

    @Override // y7b.d
    public void d(n r1) {
    }

    @Override // y7b.d
    public void e(w7b.f r1) {
    }

    @Override // y7b.d
    public boolean g(v7b.a r1) {
        return this instanceof com.ss.android.lark.commonmark.internal.c;
    }

    @Override // y7b.d
    public boolean isContainer() {
        return this instanceof com.ss.android.lark.commonmark.internal.c;
    }

    @Override // y7b.d
    public void f(x r3) {
        v7b.a r0 = a();
        if (r0.i != null) goto L5;
        r0.i = new ArrayList();
    L5:
        ((ArrayList) r0.i).add(r3);
    }
}
