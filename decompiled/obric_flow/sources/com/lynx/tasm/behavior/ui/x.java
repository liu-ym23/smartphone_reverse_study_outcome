package com.lynx.tasm.behavior.ui;

import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMap;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference f10775a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f10776b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f10777c;
    public final int d;
    public final ReadableMap e;
    public final String f;
    public final JavaOnlyMap g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final JavaOnlyMap f10778h;

    public x(LynxBaseUI r5, String r10, JavaOnlyMap r11) {
        this.f10775a = new WeakReference(r5);
        if (r5.getExposureID() != null) goto L5;
        this.f10776b = "";
    L7:
        if (r5.getExposureScene() != null) goto L9;
        this.f10777c = "";
    L10:
        this.d = r5.getSign();
        this.e = r5.getDataset();
        if (r10 != null) goto L14;
        r10 = "";
    L14:
        this.f = r10;
        this.g = new JavaOnlyMap();
        this.f10778h = r11;
        return;
    L9:
        this.f10777c = r5.getExposureScene();
        goto L10
    L5:
        this.f10776b = r5.getExposureID();
        goto L7
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L19:
        return false;
    L8:
        if (x.class != r5.getClass()) goto L19;
        x r10 = (x) r5;
        if (this.d != r10.d) goto L19;
        if (this.f10777c.equals(r10.f10777c) == false) goto L19;
        if (this.f10776b.equals(r10.f10776b) == false) goto L19;
        if (this.f.equals(r10.f) == false) goto L19;
        return true;
    }

    public final int hashCode() {
        LynxBaseUI r5 = (LynxBaseUI) this.f10775a.get();
        if (r5 != null) goto L5;
        return 0;
    L5:
        return r5.hashCode();
    }
}
