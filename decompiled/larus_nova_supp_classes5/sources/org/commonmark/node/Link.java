package org.commonmark.node;

import uvc.b;
import uvc.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class Link extends b {
    public String h;
    public String i;

    @Override // uvc.b
    public final String f() {
        return "destination=" + this.h + ", title=" + this.i;
    }

    public Link() {
    }

    @Override // uvc.b
    public final void a(c r1) {
        r1.D(this);
    }

    public Link(String r1, String r2) {
        this.h = r1;
        this.i = r2;
    }
}
