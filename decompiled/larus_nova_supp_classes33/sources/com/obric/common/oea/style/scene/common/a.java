package com.obric.common.oea.style.scene.common;

import fja.d;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public abstract class a {
    public final String a;
    public final List<d> b;
    public final List<d> c;

    public abstract void a();

    public abstract void b();

    public a() {
        this.a = "AbstractModeSwitchAnimComposer";
        this.b = new ArrayList();
        this.c = new ArrayList();
    }
}
