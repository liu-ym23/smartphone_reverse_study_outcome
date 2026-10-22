package com.bytedance.forest.preload;

import android.net.Uri;
import com.bytedance.forest.model.Scene;
import com.bytedance.forest.model.w;
import com.facebook.datasource.AbstractDataSource;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.lynx.tasm.ui.image.f0;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public w f4566a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f4567b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile SoftReference f4568c;
    public final String d;
    public final Scene e;
    public final Function0 f;

    public c(String r5, Scene r10, Function0 r11) {
        this.d = r5;
        this.e = r10;
        this.f = r11;
        this.f4567b = new ArrayList();
    }

    public final void a(w r5, Function0 r10) {
        if (r5.f4442r == false) goto L9;
        String r11 = r5.f4443t;
        if (r11 == null) goto L9;
        if (com.lynx.tasm.behavior.utils.d.g(r11) != true) goto L9;
        Uri r12 = new Uri.Builder().scheme("file").authority("").path(r5.f4443t).build();
    L10:
        ImageRequest r13 = ImageRequestBuilder.a(r12).a();
        DataSource r14 = (DataSource) Fresco.a().e().a(r13).get();
        this.f4568c = new SoftReference(r14);
        AbstractDataSource r15 = (AbstractDataSource) r14;
        r15.a(new a(this, r5, r12, r10), b.f4565a);
        return;
    L9:
        r12 = Uri.parse(r5.f4441q.getOriginUrl());
        goto L10
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r5) {
        w r10 = (w) r5;
        f0.n(4, "PreLoader", "preload result:" + r10.f4442r);
        r10.d(null);
        if (this.e == Scene.f) goto L28;
    L11:
        ((PreLoader$preload$delegate$1) this.f).invoke();
        monitor-enter(this);
        this.f4566a = r10;     // Catch: Throwable -> L19
        if (this.f4567b.isEmpty() == true) goto L21;
        Iterator r11 = this.f4567b.iterator();     // Catch: Throwable -> L19
    L17:
        if (r11.hasNext() == false) goto L21;
        ((Function1) r11.next()).invoke(r10);     // Catch: Throwable -> L19
    L21:
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L19
        monitor-exit(this);
        return r12;
    L19:
        th = move-exception;
        throw th;
    L28:
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L6
        a(r10, new CallbackDelegate$invoke$$inlined$runCatching$lambda$1(this));     // Catch: Throwable -> L6
        Object r14 = Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L6
    L8:
        Throwable r15 = Result.m127exceptionOrNullimpl(r14);
        if (r15 == null) goto L11;
        f0.h("PreLoader", 60, "image preload failed by " + r15, false);
    L6:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r14 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L8
    }
}
