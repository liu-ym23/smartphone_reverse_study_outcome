package com.squareup.javapoet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.lang.model.element.TypeParameterElement;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.type.TypeVariable;

/* JADX INFO: loaded from: classes3.dex */
public final class a0 extends x {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final /* synthetic */ int f14950y = 0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final String f14951w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final List f14952x;

    public a0(String r5, List r10) {
        super(null, new ArrayList());
        com.bytedance.android.anniex.base.service.f.s(r5, "name == null", new Object[0]);
        this.f14951w = r5;
        this.f14952x = r10;
        Iterator r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L12;
        x r12 = (x) r11.next();
        if (r12.k() == false) goto L8;
    L10:
        boolean r13 = false;
    L11:
        com.bytedance.android.anniex.base.service.f.r(r13, "invalid bound: %s", new Object[]{r12});
        goto L4
    L8:
        if (r12 == x.d) goto L10;
        r13 = true;
        goto L11
    }

    public static a0 n(TypeParameterElement r5) {
        String r10 = r5.getSimpleName().toString();
        List r11 = r5.getBounds();
        ArrayList r12 = new ArrayList();
        Iterator r13 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        r12.add(x.g((TypeMirror) r13.next()));
        goto L4
    L6:
        ArrayList r14 = new ArrayList(r12);
        r14.remove(x.f15028m);
        return new a0(r10, Collections.unmodifiableList(r14));
    }

    public static a0 o(TypeVariable r5) {
        return n(r5.asElement());
    }

    @Override // com.squareup.javapoet.x
    public final k c(k r5) {
        d(r5);
        r5.e(this.f14951w);
        return r5;
    }
}
