package com.facebook.drawee.controller;

import android.graphics.drawable.Animatable;
import android.util.Log;
import com.facebook.fresco.ui.common.OnDrawControllerListener;
import com.facebook.imagepipeline.image.ImageInfo;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class ForwardingControllerListener<INFO> extends BaseControllerListener<INFO> implements OnDrawControllerListener<INFO> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f7805b;

    public ForwardingControllerListener() {
        this.f7805b = new ArrayList(2);
    }

    public final synchronized void a(ControllerListener r5) {
        monitor-enter(this);
        this.f7805b.add(r5);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener
    public final void b(String r10, ImageInfo r11, Animatable r12) {
        int r5 = this.f7805b.size();
        int r13 = 0;
    L3:
        if (r13 >= r5) goto L17;
        ControllerListener r14 = (ControllerListener) this.f7805b.get(r13);     // Catch: Exception -> L8
        if (r14 == null) goto L13;
        r14.a(r10, r11, r12);     // Catch: Exception -> L8
    L13:
        r13 = r13 + 1;
    L8:
        e = move-exception;
        monitor-enter(this);
        Log.e("FdingControllerListener", "InternalListener exception in onFinalImageSet", e);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener
    public final void c(String r10, ImageInfo r11, Animatable r12) {
        int r5 = this.f7805b.size();
        int r13 = 0;
    L3:
        if (r13 >= r5) goto L17;
        ControllerListener r14 = (ControllerListener) this.f7805b.get(r13);     // Catch: Exception -> L8
        if ((r14 instanceof BaseControllerListener) == false) goto L13;
        ((BaseControllerListener) r14).c(r10, r11, r12);     // Catch: Exception -> L8
    L13:
        r13 = r13 + 1;
    L8:
        e = move-exception;
        monitor-enter(this);
        Log.e("FdingControllerListener", "InternalListener exception in onIntermediateImageSet", e);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    public final synchronized void d() {
        monitor-enter(this);
        this.f7805b.clear();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized void a(String r5, Exception r10) {
        monitor-enter(this);
        Log.e("FdingControllerListener", r5, r10);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final synchronized void a(String r5, Object r10) {
        monitor-enter(this);
        int r11 = this.f7805b.size();     // Catch: Throwable -> L10
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L15;
        ControllerListener r13 = (ControllerListener) this.f7805b.get(r12);     // Catch: Throwable -> L10 Exception -> L12
        if (r13 == null) goto L14;
        r13.a(r5, r10);     // Catch: Throwable -> L10 Exception -> L12
    L14:
        r12 = r12 + 1;
    L12:
        e = move-exception;
        a("InternalListener exception in onSubmit", e);     // Catch: Throwable -> L10
        goto L14
    L15:
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final synchronized void a(String r5, ImageInfo r10, Animatable r11) {
        monitor-enter(this);
        int r12 = this.f7805b.size();     // Catch: Throwable -> L10
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L15;
        ControllerListener r14 = (ControllerListener) this.f7805b.get(r13);     // Catch: Throwable -> L10 Exception -> L12
        if (r14 == null) goto L14;
        r14.a(r5, r10, r11);     // Catch: Throwable -> L10 Exception -> L12
    L14:
        r13 = r13 + 1;
    L12:
        e = move-exception;
        a("InternalListener exception in onFinalImageSet", e);     // Catch: Throwable -> L10
        goto L14
    L15:
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final synchronized void b(String r5, Throwable r10) {
        monitor-enter(this);
        int r11 = this.f7805b.size();     // Catch: Throwable -> L10
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L15;
        ControllerListener r13 = (ControllerListener) this.f7805b.get(r12);     // Catch: Throwable -> L10 Exception -> L12
        if (r13 == null) goto L14;
        r13.b(r5, r10);     // Catch: Throwable -> L10 Exception -> L12
    L14:
        r12 = r12 + 1;
    L12:
        e = move-exception;
        a("InternalListener exception in onFailure", e);     // Catch: Throwable -> L10
        goto L14
    L15:
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener
    public final synchronized void c() {
        monitor-enter(this);
        int r5 = this.f7805b.size();     // Catch: Throwable -> L8
        int r10 = 0;
    L5:
        if (r10 >= r5) goto L13;
        ControllerListener r11 = (ControllerListener) this.f7805b.get(r10);     // Catch: Throwable -> L8 Exception -> L10
    L12:
        r10 = r10 + 1;
    L10:
        e = move-exception;
        a("InternalListener exception in onRelease", e);     // Catch: Throwable -> L8
        goto L12
    L13:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener
    public final void a() {
        int r5 = this.f7805b.size();
        int r10 = 0;
    L3:
        if (r10 >= r5) goto L15;
        ControllerListener r11 = (ControllerListener) this.f7805b.get(r10);     // Catch: Exception -> L6
    L11:
        r10 = r10 + 1;
    L6:
        e = move-exception;
        monitor-enter(this);
        Log.e("FdingControllerListener", "InternalListener exception in onFinalImageSet", e);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener
    public final synchronized void b() {
        monitor-enter(this);
        int r5 = this.f7805b.size();     // Catch: Throwable -> L8
        int r10 = 0;
    L5:
        if (r10 >= r5) goto L13;
        ControllerListener r11 = (ControllerListener) this.f7805b.get(r10);     // Catch: Throwable -> L8 Exception -> L10
    L12:
        r10 = r10 + 1;
    L10:
        e = move-exception;
        a("InternalListener exception in onFailure", e);     // Catch: Throwable -> L8
        goto L12
    L13:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void a(String r10, ImageInfo r11) {
        int r5 = this.f7805b.size();
        int r12 = 0;
    L3:
        if (r12 >= r5) goto L17;
        ControllerListener r13 = (ControllerListener) this.f7805b.get(r12);     // Catch: Exception -> L8
        if (r13 == null) goto L13;
        r13.a(r10, r11);     // Catch: Exception -> L8
    L13:
        r12 = r12 + 1;
    L8:
        e = move-exception;
        monitor-enter(this);
        Log.e("FdingControllerListener", "InternalListener exception in onIntermediateImageSet", e);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void a(String r10, Throwable r11) {
        int r5 = this.f7805b.size();
        int r12 = 0;
    L3:
        if (r12 >= r5) goto L17;
        ControllerListener r13 = (ControllerListener) this.f7805b.get(r12);     // Catch: Exception -> L8
        if (r13 == null) goto L13;
        r13.a(r10, r11);     // Catch: Exception -> L8
    L13:
        r12 = r12 + 1;
    L8:
        e = move-exception;
        monitor-enter(this);
        Log.e("FdingControllerListener", "InternalListener exception in onIntermediateImageFailed", e);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final synchronized void a(String r5) {
        monitor-enter(this);
        int r10 = this.f7805b.size();     // Catch: Throwable -> L10
        int r11 = 0;
    L5:
        if (r11 >= r10) goto L15;
        ControllerListener r12 = (ControllerListener) this.f7805b.get(r11);     // Catch: Throwable -> L10 Exception -> L12
        if (r12 == null) goto L14;
        r12.a(r5);     // Catch: Throwable -> L10 Exception -> L12
    L14:
        r11 = r11 + 1;
    L12:
        e = move-exception;
        a("InternalListener exception in onRelease", e);     // Catch: Throwable -> L10
        goto L14
    L15:
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }
}
