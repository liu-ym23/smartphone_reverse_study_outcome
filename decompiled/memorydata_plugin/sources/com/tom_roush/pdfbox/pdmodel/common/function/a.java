package com.tom_roush.pdfbox.pdmodel.common.function;

import com.tom_roush.pdfbox.a.b;
import com.tom_roush.pdfbox.a.d;
import com.tom_roush.pdfbox.pdmodel.common.c;
import com.tom_roush.pdfbox.pdmodel.common.i;

/* JADX INFO: loaded from: classes6.dex */
public abstract class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private i f16185a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private d f16186b;

    public abstract int a();

    public d b() {
        i r0 = this.f16185a;
        if (r0 == null) goto L7;
        return r0.a();
    L7:
        return this.f16186b;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.common.c
    public /* synthetic */ b e() {
        return b();
    }

    public String toString() {
        return "FunctionType" + a();
    }
}
