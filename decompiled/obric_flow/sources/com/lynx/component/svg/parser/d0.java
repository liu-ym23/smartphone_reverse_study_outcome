package com.lynx.component.svg.parser;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d0 extends f0 implements e0 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ArrayList f9800h;

    public d0() {
        this.f9800h = new ArrayList();
    }

    @Override // com.lynx.component.svg.parser.e0
    public final void a(g0 r5) {
        this.f9800h.add(r5);
    }

    @Override // com.lynx.component.svg.parser.e0
    public final List getChildren() {
        return this.f9800h;
    }
}
