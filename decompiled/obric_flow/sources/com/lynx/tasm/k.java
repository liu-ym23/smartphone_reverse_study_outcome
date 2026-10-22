package com.lynx.tasm;

import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f10892a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f10893b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public u f10894c;
    public final ArrayList d;
    public final HashMap e;
    public wn.h f;
    public com.bytedance.ies.bullet.base.utils.b g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public dn.a f10895h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public LynxBooleanOption f10896i;

    public k() {
        this.f10896i = LynxBooleanOption.f9962a;
        this.e = new HashMap();
        this.d = new ArrayList();
    }

    public static int a(int r5, int r10, boolean r11) {
        if (r11 == false) goto L6;
        return r5 | r10;
    L6:
        return r5 & (~r10);
    }
}
