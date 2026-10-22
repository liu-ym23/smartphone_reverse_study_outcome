package com.lynx.tasm.ui.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.facebook.common.references.CloseableReference;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.eventreport.LynxEventReporter;
import com.lynx.tasm.utils.UIThreadUtils;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b extends a7a.d implements e0.c, Drawable.Callback {
    public final e0 b;
    public Drawable c;
    public boolean d;
    public int e;
    public int f;
    public boolean g;
    public final Context h;
    public WeakReference<LynxBaseUI> i;
    public final String j;
    public int k;
    public int l;

    public class a implements f {
        public final /* synthetic */ b a;

        @Override // com.lynx.tasm.ui.image.f
        public final void a() {
            b r0 = this.a;
            e0 r1 = r0.b;
            if (r1 == null) goto L10;
            int r2 = r0.k;
            if (r2 <= 0) goto L11;
            int r3 = r0.l;
            if (r3 <= 0) goto L12;
            r1.g(r2, r3, 0, 0, 0, 0);
            return;
        L12:
            return;
        L11:
            return;
        }

        public a(b r1) {
            this.a = r1;
        }
    }

    /* JADX INFO: renamed from: com.lynx.tasm.ui.image.b$b, reason: collision with other inner class name */
    public class C0067b extends l {
        public final /* synthetic */ Context a;
        public final /* synthetic */ String b;
        public final /* synthetic */ b c;

        @Override // com.lynx.tasm.ui.image.l
        public final void onImageLoadSuccess(int r4, int r5) {
            b r0 = this.c;
            r0.e = r4;
            r0.f = r5;
            if ((this.a instanceof LynxContext) == false) goto L15;
            WeakReference<LynxBaseUI> r1 = r0.i;
            if (r1 != null) goto L7;
            return;
        L7:
            if (r1.get() == null) goto L19;
            LynxBaseUI r2 = this.c.i.get();
            if (r2.getEvents() != null) goto L12;
            return;
        L12:
            if (r2.getEvents().containsKey("bgload") == false) goto L18;
            m7a.a r3 = new m7a.a(r2.getSign(), "bgload");
            r3.a("height", Integer.valueOf(r5));
            r3.a("width", Integer.valueOf(r4));
            r3.a(LynxEventReporter.PROP_NAME_URL, this.b);
            ((LynxContext) this.a).getEventEmitter().sendCustomEvent(r3);
            return;
        L18:
            return;
        L19:
            return;
        }

        public C0067b(b r1, Context r2, String r3) {
            this.c = r1;
            this.a = r2;
            this.b = r3;
        }

        @Override // com.lynx.tasm.ui.image.l
        public final void onImageLoadFailed(LynxError r4, int r5, int r6) {
            if (r4 == null) goto L17;
            Context r0 = this.a;
            if ((r0 instanceof LynxContext) == false) goto L21;
            ((LynxContext) r0).reportResourceError(this.b, "image", r4);
            WeakReference<LynxBaseUI> r1 = this.c.i;
            if (r1 != null) goto L9;
            return;
        L9:
            if (r1.get() == null) goto L22;
            LynxBaseUI r2 = this.c.i.get();
            if (r2.getEvents() != null) goto L14;
            return;
        L14:
            if (r2.getEvents().containsKey("bgerror") == false) goto L20;
            m7a.a r3 = new m7a.a(r2.getSign(), "bgerror");
            r3.a("errMsg", r4.getSummaryMessage() + ": " + r4.getRootCause());
            r3.a(LynxEventReporter.PROP_NAME_URL, this.b);
            r3.a("lynx_categorized_code", Integer.valueOf(r5));
            r3.a("error_code", Integer.valueOf(r6));
            ((LynxContext) this.a).getEventEmitter().sendCustomEvent(r3);
            return;
        L20:
            return;
        L22:
            return;
        L21:
            return;
        }
    }

    public class c implements Runnable {
        public final /* synthetic */ b a;

        @Override // java.lang.Runnable
        public final void run() {
            this.a.invalidateSelf();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public c(b r1) {
            this.a = r1;
        }
    }

    @Override // a7a.d
    public final boolean c() {
        if (this.c == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // a7a.d
    public final void d() {
        if (this.d == true) goto L5;
        this.b.h();
        this.d = true;
        this.b.i = true;
    L5:
        int r3 = this.k;
        if (r3 <= 0) goto L11;
        int r4 = this.l;
        if (r4 <= 0) goto L12;
        this.b.g(r3, r4, 0, 0, 0, 0);
        return;
    L12:
        return;
    }

    @Override // a7a.d
    public final void e() {
        this.b.i();
        this.d = false;
    }

    @Override // a7a.d
    public final void f() {
        WeakReference<LynxBaseUI> r0 = this.i;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.get() == null) goto L23;
        LynxBaseUI r1 = this.i.get();
        u7a.g.b r2 = u7a.g.b(r1.getEnableLocalCache());
        if (r1.getSkipRedirection() == false) goto L10;
        e0 r3 = this.b;
        String r4 = this.j;
        r3.F.v(r4, false);
    L12:
        if (r1.getDisableDefaultResize() == false) goto L14;
        e0 r5 = this.b;
        ImageResizeMethod r6 = ImageResizeMethod.SCALE;
        h r7 = r5.F;
        r7.r = r6;
        r7.A.markDirty();
    L14:
        e0 r8 = this.b;
        boolean r9 = r2.a;
        h r10 = r8.F;
        r10.t = r9;
        r10.u = r2.b;
        int r11 = this.k;
        if (r11 <= 0) goto L21;
        int r12 = this.l;
        if (r12 <= 0) goto L22;
        r8.g(r11, r12, 0, 0, 0, 0);
        return;
    L22:
        return;
    L21:
        return;
    L10:
        e0 r13 = this.b;
        String r14 = this.j;
        r13.F.z(r14, null, true, false);
        e0 r15 = this.b;
        String r16 = this.j;
        r15.F.v(r16, true);
        goto L12
    }

    @Override // a7a.d
    public final int a() {
        return this.f;
    }

    @Override // a7a.d
    public final int b() {
        return this.e;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r3) {
        if (this.c == null) goto L11;
        e0 r0 = this.b;
        if (r0.U == true) goto L7;
    L9:
        this.c.draw(r3);
        return;
    L7:
        if (r0.f() == false) goto L9;
        return;
    }

    @Override // a7a.d
    public final void h(Bitmap.Config r2) {
        h r0 = this.b.F;
        r0.p = r2;
        r0.A.markDirty();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable r1) {
        UIThreadUtils.runOnUiThreadImmediately(new c(this));
    }

    @Override // a7a.d
    public final void j(LynxBaseUI r2) {
        this.i = new WeakReference(r2);
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect r2) {
        super.onBoundsChange(r2);
        Drawable r0 = this.c;
        if (r0 == null) goto L6;
        r0.setBounds(r2);
        return;
    }

    @Override // com.lynx.tasm.ui.image.e0.c
    public final void onCloseableRefReady(CloseableReference<?> r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        if (r4.isValid() == false) goto L16;
        Object r5 = r4.get();
        if ((r5 instanceof CloseableBitmap) == false) goto L9;
        Bitmap r6 = ((CloseableBitmap) r5).getUnderlyingBitmap();
    L12:
        if (r6 == null) goto L17;
        this.g = true;
        Bitmap r0 = r6.copy(r6.getConfig(), true);
        BitmapDrawable r1 = new BitmapDrawable(this.h.getResources(), r0);
        this.c = r1;
        r1.setBounds(getBounds());
        this.c.setCallback(this);
        this.e = r6.getWidth();
        this.f = r6.getHeight();
        invalidateSelf();
        return;
    L17:
        return;
    L9:
        if ((r5 instanceof Bitmap) == false) goto L11;
        r6 = (Bitmap) r5;
        goto L12
    L11:
        r6 = null;
        goto L12
    }

    @Override // com.lynx.tasm.ui.image.e0.c
    public final void onDrawableReady(Drawable r2) {
        if (this.g == true) goto L18;
        this.c = r2;
        r2.setBounds(getBounds());
        this.c.setCallback(this);
        WeakReference<LynxBaseUI> r3 = this.i;
        if (r3 == null) goto L16;
        LynxBaseUI r4 = r3.get();
        if (r4 == null) goto L16;
        int r5 = r4.getImageRendering();
        if (r5 != 2) goto L13;
        this.c.setFilterBitmap(false);
        goto L16
    L13:
        if (r5 == 1) goto L15;
        if (r5 != 0) goto L16;
    L15:
        this.c.setFilterBitmap(true);
    L16:
        invalidateSelf();
        return;
    }

    public b(Context r9, String r10) {
        Object r0 = null;
        this.c = null;
        this.d = false;
        this.e = 0;
        this.f = 0;
        this.g = false;
        this.h = r9;
        this.j = r10;
        PipelineDraweeControllerBuilder r4 = Fresco.newDraweeControllerBuilder();
        if ((r9 instanceof LynxContext) == false) goto L5;
        r0 = ((LynxContext) r9).getFrescoCallerContext();
    L5:
        e0 r1 = new e0(r9, r4, r0, this, true);
        this.b = r1;
        ImageResizeMethod r2 = ImageResizeMethod.AUTO;
        h r3 = r1.F;
        r3.r = r2;
        r3.A.markDirty();
        r1.F.z = new a(this);
        r1.s = new C0067b(this, r9, r10);
    }

    @Override // a7a.d
    public final void g(int r10, int r11) {
        if (this.d == true) goto L5;
        this.b.h();
        this.d = true;
        this.b.i = true;
    L5:
        this.k = r10;
        this.l = r11;
        this.b.g(r10, r11, 0, 0, 0, 0);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable r1, Runnable r2) {
        UIThreadUtils.removeCallbacks(r2, r1);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable r1, Runnable r2, long r3) {
        UIThreadUtils.runOnUiThreadAtTime(r2, r1, r3);
    }
}
