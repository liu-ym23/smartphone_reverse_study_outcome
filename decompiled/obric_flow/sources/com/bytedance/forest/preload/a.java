package com.bytedance.forest.preload;

import android.net.Uri;
import com.bytedance.forest.model.ResourceFrom;
import com.bytedance.forest.model.w;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.AbstractDataSource;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.lynx.tasm.ui.image.f0;
import java.lang.ref.SoftReference;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends BaseDataSubscriber {
    public final /* synthetic */ c d;
    public final /* synthetic */ w e;
    public final /* synthetic */ Uri f;
    public final /* synthetic */ Function0 g;

    public a(c r5, w r10, Uri r11, Function0 r12) {
        this.d = r5;
        this.e = r10;
        this.f = r11;
        this.g = r12;
    }

    @Override // com.facebook.datasource.BaseDataSubscriber, com.facebook.datasource.DataSubscriber
    public final void a() {
        f0.n(4, "PreLoader", "preload image canceled, src = " + this.d.d + ", redirectTo: " + this.f);
        ((CallbackDelegate$invoke$$inlined$runCatching$lambda$1) this.g).invoke();
    }

    @Override // com.facebook.datasource.BaseDataSubscriber
    public final void d(DataSource r5) {
        f0.n(4, "PreLoader", "preload image failed, src = " + this.d.d + ", redirectTo: " + this.f);
        ((CallbackDelegate$invoke$$inlined$runCatching$lambda$1) this.g).invoke();
    }

    @Override // com.facebook.datasource.BaseDataSubscriber
    public final void e(DataSource r10) {
        if (r10 == null) goto L29;
        boolean r5 = true;
        if (((AbstractDataSource) r10).f() != true) goto L29;
        f0.h("PreLoader", 60, "preDecode bitmap succeed, src = " + this.e.f4441q.getOriginUrl() + ", redirectTo: " + this.f, false);
        CloseableReference r11 = (CloseableReference) r10.getResult();
        if (r11 == null) goto L29;
        monitor-enter(r11);
        Object r12 = r11.f7671b.d();     // Catch: Throwable -> L26
        monitor-exit(r11);     // Catch: Throwable -> L26
        if ((r12 instanceof CloseableBitmap) == false) goto L29;
        this.e.f4435k = new SoftReference(r11);
        if (this.e.f4442r == true) goto L29;
        this.e.f4442r = true;
        w r13 = this.e;
        if (((CloseableBitmap) r11.c()).d == false) goto L17;
    L20:
        r13.f4446w = r5;
        if (((CloseableBitmap) r11.c()).d == false) goto L24;
        w r14 = this.e;
        r14.getClass();
        r14.A = "FrescoMemoryFetcher";
        w r15 = this.e;
        r15.f4444u = ResourceFrom.d;
        r15.f4445v = ResourceFrom.f4340c;
        goto L29
    L24:
        if (((CloseableBitmap) r11.c()).f8170c == false) goto L29;
        w r16 = this.e;
        r16.getClass();
        r16.A = "FrescoCDNFetcher";
        this.e.f4444u = ResourceFrom.f4340c;
        goto L29
    L17:
        if (((CloseableBitmap) r11.c()).f8170c == true) goto L20;
        r5 = false;
    L26:
        th = move-exception;
        throw th;
    L29:
        ((CallbackDelegate$invoke$$inlined$runCatching$lambda$1) this.g).invoke();
    }
}
