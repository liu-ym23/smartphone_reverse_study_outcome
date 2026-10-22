package com.ss.android.lark.commonmark.internal;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import v7b.v;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class l extends y7b.a {
    public final v7b.m a;
    public final List<CharSequence> b;

    public static class a extends y7b.b {
        public a() {
        }

        @Override // y7b.e
        public final d a(y7b.g r4, h.a r5) {
            h r6 = (h) r4;
            if (r6.h >= 4) goto L5;
            return null;
        L5:
            if (r6.i == false) goto L7;
            return null;
        L7:
            if ((r6.h().a() instanceof v) == true) goto L13;
            d r1 = new d(new y7b.d[]{new l()});
            r1.c = r6.d + 4;
            return r1;
        L13:
            return null;
        }
    }

    @Override // y7b.a, y7b.d
    public final void c() {
        int r0 = ((ArrayList) this.b).size() - 1;
    L3:
        int r2 = 0;
        if (r0 < 0) goto L12;
        CharSequence r3 = (CharSequence) ListProtector.get(this.b, r0);
        if (a8b.b.c(r3, 0, r3.length()) != r3.length()) goto L8;
        boolean r4 = true;
    L9:
        if (r4 == false) goto L12;
        r0 = r0 - 1;
        goto L3
    L8:
        r4 = false;
    L12:
        StringBuilder r5 = new StringBuilder();
    L14:
        if (r2 >= (r0 + 1)) goto L16;
        r5.append((CharSequence) ListProtector.get(this.b, r2));
        r2 = r2 + 1;
        goto L14
    L16:
        this.a.getClass();
    }

    public l() {
        this.a = new v7b.m();
        this.b = new ArrayList();
    }

    @Override // y7b.d
    public final v7b.a a() {
        return this.a;
    }

    @Override // y7b.a, y7b.d
    public final void e(w7b.f r2) {
        List<CharSequence> r0 = this.b;
        ArrayList r1 = (ArrayList) r0;
        r1.add(r2.a);
    }

    @Override // y7b.d
    public final y7b.c h(y7b.g r4) {
        h r5 = (h) r4;
        if (r5.h < 4) goto L7;
        return new b(-1, r5.d + 4, false);
    L7:
        if (r5.i == true) goto L9;
        return null;
    L9:
        return y7b.c.a(r5.f);
    }
}
