package org.commonmark.node;

import uvc.b;
import uvc.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class Text extends b {
    public String h;

    @Override // uvc.b
    public final String f() {
        return "literal=" + this.h;
    }

    public Text() {
    }

    public Text(String r1) {
        this.h = r1;
    }

    @Override // uvc.b
    public final void a(c r1) {
        r1.l(this);
    }
}
