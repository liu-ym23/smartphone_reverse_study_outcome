package com.squareup.javapoet;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import javax.lang.model.SourceVersion;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f14948a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedHashMap f14949b;

    public a(e r5) {
        this.f14949b = new LinkedHashMap();
        this.f14948a = r5;
    }

    public final void a(String r5, String r10, Object... r11) {
        i r12 = i.d(r10, r11);
        ((List) this.f14949b.computeIfAbsent(r5, new com.google.android.material.color.utilities.h(3))).add(r12);
    }

    public final b b() {
        Iterator r5 = this.f14949b.keySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L7;
        String r10 = (String) r5.next();
        com.bytedance.android.anniex.base.service.f.s(r10, "name == null", new Object[0]);
        com.bytedance.android.anniex.base.service.f.r(SourceVersion.isName(r10), "not a valid name: %s", new Object[]{r10});
        goto L4
    L7:
        return new b(this);
    }
}
