package io.noties.markwon.html.tag;

import android.text.style.UnderlineSpan;
import java.util.Arrays;
import java.util.Collection;
import lsc.y;
import tsc.a0;
import tsc.v;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class n extends a0 {
    @Override // tsc.a0
    public final Collection<String> c() {
        return Arrays.asList(new String[]{"u", "ins"});
    }

    public n() {
    }

    @Override // tsc.a0
    public void a(lsc.m r2, v r3, tsc.l r4) {
        if (r4.isBlock() == false) goto L5;
        a0.d(r2, r3, r4.a());
    L5:
        y.f(r2.builder(), new UnderlineSpan(), r4.start(), r4.end());
    }
}
