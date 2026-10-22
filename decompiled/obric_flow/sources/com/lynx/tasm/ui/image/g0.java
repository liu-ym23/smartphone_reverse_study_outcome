package com.lynx.tasm.ui.image;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import com.facebook.datasource.AbstractDataSource;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.interfaces.SettableDraweeHierarchy;
import com.facebook.imagepipeline.image.ImageInfo;

/* JADX INFO: loaded from: classes2.dex */
public final class g0 extends BaseDataSubscriber {
    public final /* synthetic */ String d;
    public final /* synthetic */ boolean e;
    public final /* synthetic */ n0 f;

    public g0(n0 r5, String r10, boolean r11) {
        this.f = r5;
        this.d = r10;
        this.e = r11;
    }

    @Override // com.facebook.datasource.BaseDataSubscriber, com.facebook.datasource.DataSubscriber
    public final void c(DataSource r5) {
        AbstractDataSource r10 = (AbstractDataSource) r5;
        boolean r11 = r10.f();
        monitor-enter(r10);
        float r12 = r10.f;     // Catch: Throwable -> L15
        monitor-exit(r10);     // Catch: Throwable -> L15
        n0 r13 = this.f;
        if (r13.e(this.d, r10) == true) goto L10;
        r10.close();
        return;
    L10:
        if (r11 == true) goto L20;
        SettableDraweeHierarchy r14 = r13.f11061l;
        if (r14 == null) goto L21;
        ((GenericDraweeHierarchy) r14).a(r12, false);
        return;
    L21:
        return;
    L20:
        return;
    L15:
        th = move-exception;
        throw th;
    }

    @Override // com.facebook.datasource.BaseDataSubscriber
    public final void d(DataSource r5) {
        n0 r10 = this.f;
        String r11 = this.d;
        AbstractDataSource r12 = (AbstractDataSource) r5;
        monitor-enter(r12);
        Throwable r13 = r12.e;     // Catch: Throwable -> L8
        monitor-exit(r12);     // Catch: Throwable -> L8
        r10.c(r11, r5, r13, true);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.facebook.datasource.BaseDataSubscriber
    public final void e(DataSource r10) {
        AbstractDataSource r11 = (AbstractDataSource) r10;
        boolean r5 = r11.f();
        monitor-enter(r11);
        float r12 = r11.f;     // Catch: Throwable -> L50
        monitor-exit(r11);     // Catch: Throwable -> L50
        Object r13 = r11.getResult();
        if (r13 == null) goto L47;
        n0 r14 = this.f;
        String r15 = this.d;
        boolean r16 = this.e;
        if (r14.e(r15, r11) == true) goto L12;
        r14.f(r13);
        r11.close();
        return;
    L12:
        if (r14.d(r11, r13) == false) goto L62;
        Drawable r17 = r14.g(r13);     // Catch: Exception -> L44
        Object r18 = r14.f11057h;
        r14.f11057h = r13;
        r14.f11058i = r17;
        if (r5 == false) goto L30;
        Animatable r19 = null;
        r14.g = null;     // Catch: Throwable -> L21
        SettableDraweeHierarchy r20 = r14.f11061l;     // Catch: Throwable -> L21
        if (r20 == null) goto L23;
        ((GenericDraweeHierarchy) r20).a(r17, 1.0f, r16);     // Catch: Throwable -> L21
    L23:
        BaseControllerListener r21 = r14.f11060k;     // Catch: Throwable -> L21
        if (r21 != null) goto L26;
        r21 = BaseControllerListener.f7804a;     // Catch: Throwable -> L21
    L26:
        ImageInfo r22 = r14.h(r13);     // Catch: Throwable -> L21
        Object r23 = r14.f11058i;     // Catch: Throwable -> L21
        if ((r23 instanceof Animatable) == false) goto L29;
        r19 = (Animatable) r23;     // Catch: Throwable -> L21
    L29:
        r21.a(r15, r22, r19);     // Catch: Throwable -> L21
    L37:
        if (r18 == null) goto L59;
        if (r18 == r13) goto L60;
        r14.f(r18);
        return;
    L60:
        return;
    L59:
        return;
    L30:
        SettableDraweeHierarchy r24 = r14.f11061l;     // Catch: Throwable -> L21
        if (r24 == null) goto L33;
        ((GenericDraweeHierarchy) r24).a(r17, r12, r16);     // Catch: Throwable -> L21
    L33:
        BaseControllerListener r25 = r14.f11060k;     // Catch: Throwable -> L21
        if (r25 != null) goto L36;
        r25 = BaseControllerListener.f7804a;     // Catch: Throwable -> L21
    L36:
        r25.a(r15, r14.h(r13));     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        if (r18 == null) goto L43;
        if (r18 == r13) goto L43;
        r14.f(r18);
    L43:
        throw th;
    L44:
        e = move-exception;
        r14.f(r13);
        r14.c(r15, r11, e, r5);
        return;
    L62:
        return;
    L47:
        if (r5 == false) goto L63;
        this.f.c(this.d, r11, new NullPointerException(), true);
        return;
    L63:
        return;
    L50:
        th = move-exception;
        throw th;
    }
}
