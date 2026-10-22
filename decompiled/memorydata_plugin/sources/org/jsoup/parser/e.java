package org.jsoup.parser;

import java.io.StringReader;
import java.util.List;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.j;

/* JADX INFO: loaded from: classes7.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private i f18290a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ParseErrorList f18291b;
    private d c;
    private boolean d;

    public e(i r2) {
        this.d = false;
        this.f18290a = r2;
        this.c = r2.a();
        this.f18291b = ParseErrorList.noTracking();
    }

    public static Document a(String r2, String r3) {
        b r0 = new b();
        return r0.b(new StringReader(r2), r3, new e(r0));
    }

    public static e f() {
        return new e(new b());
    }

    public List<j> a(String r2, Element r3, String r4) {
        return this.f18290a.a(r2, r3, r4, this);
    }

    public i a() {
        return this.f18290a;
    }

    public boolean a(String r1) {
        return a().n(r1);
    }

    public boolean b() {
        if (this.f18291b.getMaxSize() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public ParseErrorList c() {
        return this.f18291b;
    }

    public boolean d() {
        return this.d;
    }

    public d e() {
        return this.c;
    }
}
