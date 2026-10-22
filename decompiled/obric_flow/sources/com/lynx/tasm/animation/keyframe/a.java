package com.lynx.tasm.animation.keyframe;

import android.text.TextUtils;
import com.lynx.tasm.behavior.ui.LynxUI;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakReference f10081a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public tm.b[] f10082b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public HashMap f10083c;

    public a(LynxUI r5) {
        this.f10081a = new WeakReference(r5);
        this.f10083c = new HashMap();
    }

    public final void a() {
        if (this.f10082b != null) goto L5;
        return;
    L5:
        if (((LynxUI) this.f10081a.get()).getHeight() == 0) goto L7;
    L9:
        HashMap r5 = new HashMap();
        tm.b[] r10 = this.f10082b;
        int r11 = r10.length;
        int r12 = 0;
        int r13 = 0;
    L10:
        if (r13 >= r11) goto L25;
        tm.b r14 = r10[r13];
        if (r14 == null) goto L24;
        if (TextUtils.isEmpty(r14.f22140a) == true) goto L24;
        HashMap r15 = this.f10083c;
        if (r15 == null) goto L19;
        g r16 = (g) r15.get(r14.f22140a);
    L20:
        if (r16 != null) goto L22;
        r16 = new g(((LynxUI) this.f10081a.get()).getView(), (LynxUI) this.f10081a.get());
    L23:
        r5.put(r14.f22140a, r16);
        goto L24
    L22:
        this.f10083c.remove(r14.f22140a);
        goto L23
    L19:
        r16 = null;
    L24:
        r13 = r13 + 1;
        goto L10
    L25:
        HashMap r17 = this.f10083c;
        if (r17 == null) goto L31;
        Iterator r18 = r17.values().iterator();
    L29:
        if (r18.hasNext() == false) goto L31;
        ((g) r18.next()).f();
    L31:
        tm.b[] r19 = this.f10082b;
        int r20 = r19.length;
    L32:
        if (r12 >= r20) goto L40;
        tm.b r21 = r19[r12];
        if (r21 == null) goto L39;
        if (TextUtils.isEmpty(r21.f22140a) == true) goto L39;
        ((g) r5.get(r21.f22140a)).c(r21);
    L39:
        r12 = r12 + 1;
        goto L32
    L40:
        this.f10083c = r5;
        return;
    L7:
        if (((LynxUI) this.f10081a.get()).getWidth() != 0) goto L9;
    }

    public final void b(String r5, Object r10) {
        HashMap r11 = this.f10083c;
        if (r11 == null) goto L16;
        Iterator r12 = r11.values().iterator();
    L7:
        if (r12.hasNext() == false) goto L24;
        g r13 = (g) r12.next();
        boolean r14 = r13.d.containsKey(r5);
        HashMap r15 = r13.d;
        if (r14 == false) goto L12;
        r15.put(r5, r10);
    L12:
        if (r5.equals("BackgroundColor") == false) goto L7;
        if (r15.containsKey("Color") == false) goto L7;
        r15.put("Color", r10);
        goto L7
    L24:
        return;
    }
}
