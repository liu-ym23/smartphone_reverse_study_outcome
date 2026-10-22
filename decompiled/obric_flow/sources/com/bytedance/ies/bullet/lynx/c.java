package com.bytedance.ies.bullet.lynx;

import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.TemplateData;
import com.lynx.tasm.t;
import com.lynx.tasm.u;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f5618a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public u f5619b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f5620c;
    public ln.b d;
    public TemplateData e;
    public boolean f;
    public String g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f5621h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f5622i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public TemplateBundle f5623j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f5624k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ArrayList f5625l;

    public c() {
        this.f5625l = new ArrayList();
    }

    public static u a(String[] r10) {
        Boolean r11 = Boolean.FALSE;
        if (Intrinsics.areEqual(r11, Boolean.TRUE) == false) goto L7;
        t r5 = new t();
        r5.f10963c = "";
        r5.d = "";
        r5.e = r10;
        r5.f10962b = false;
        r5.f = r11;
        return new u(r5);
    L7:
        return new u("", "", r10, false, false, r11, false);
    }
}
