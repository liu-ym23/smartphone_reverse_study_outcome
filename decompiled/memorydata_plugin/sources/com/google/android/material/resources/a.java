package com.google.android.material.resources;

import android.graphics.Typeface;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Typeface f4024a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final InterfaceC0186a f4025b;
    private boolean c;

    /* JADX INFO: renamed from: com.google.android.material.resources.a$a, reason: collision with other inner class name */
    public interface InterfaceC0186a {
        void a(Typeface r1);
    }

    public a(InterfaceC0186a r3, Typeface r4) {
        InterfaceC0186a r5 = (InterfaceC0186a) ZeusTransformUtils.wrapperContextForParams(r3, InterfaceC0186a.class, "com.obric.memorydata.plugin");
        this.f4024a = r4;
        this.f4025b = r5;
    }

    private void a(Typeface r2) {
        if (this.c == true) goto L6;
        this.f4025b.a(r2);
        return;
    }

    public void a() {
        this.c = true;
    }

    @Override // com.google.android.material.resources.f
    public void a(int r1) {
        a(this.f4024a);
    }

    @Override // com.google.android.material.resources.f
    public void a(Typeface r1, boolean r2) {
        a(r1);
    }
}
