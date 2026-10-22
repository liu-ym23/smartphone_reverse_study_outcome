package com.ctc.wstx.shaded.msv_core.reader.trex.ng.comp;

import com.ctc.wstx.shaded.msv_core.grammar.relaxng.RELAXNGGrammar;
import org.xml.sax.Locator;

/* JADX INFO: loaded from: classes2.dex */
abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final b f3629a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final RELAXNGGrammar f3630b;

    public abstract void a(boolean r1);

    public void a(Locator[] r2, String r3) {
        a(r2, r3, null);
    }

    public void a(Locator[] r2, String r3, Object[] r4) {
        a(false);
        this.f3629a.a(r3, r4, r2);
    }
}
