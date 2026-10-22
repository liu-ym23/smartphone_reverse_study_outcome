package io.noties.markwon.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public class a extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Drawable.Callback f16390a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected int f16391b;
    protected boolean c;
    protected boolean d;
    protected boolean e;
    protected boolean f;
    private final String g;
    private final b h;
    private final h i;
    private final i j;
    private Drawable k;
    private float l;
    private boolean m;

    /* JADX INFO: renamed from: io.noties.markwon.a.a$a, reason: collision with other inner class name */
    private class C0856a implements Drawable.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f16392a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Drawable.Callback f16393b;

        C0856a(a r3, Drawable.Callback r4) {
            Drawable.Callback r5 = (Drawable.Callback) ZeusTransformUtils.wrapperContextForParams(r4, Drawable.Callback.class, "com.obric.memorydata.plugin");
            this.f16392a = r3;
            this.f16393b = r5;
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable r1) {
            this.f16393b.invalidateDrawable(this.f16392a);
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable r2, Runnable r3, long r4) {
            Runnable r5 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
            this.f16393b.scheduleDrawable(this.f16392a, r5, r4);
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable r2, Runnable r3) {
            Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
            this.f16393b.unscheduleDrawable(this.f16392a, r4);
        }
    }

    public a(String r2, b r3, i r4, h r5) {
        this.m = false;
        this.d = false;
        this.e = false;
        this.f = false;
        this.g = r2;
        this.h = r3;
        this.j = r4;
        this.i = r5;
    }

    private static Rect b(Drawable r2) {
        if (r2 == null) goto L10;
        Rect r0 = r2.getBounds();
        if (r0.isEmpty() == true) goto L6;
        return r0;
    L6:
        Rect r3 = f.a(r2);
        if (r3.isEmpty() == true) goto L10;
        return r3;
    L10:
        return new Rect(0, 0, 1, 1);
    }

    public void a(int r1, float r2) {
        this.f16391b = r1;
        this.l = r2;
        if (this.c == false) goto L6;
        k();
        return;
    }

    public void a(Drawable.Callback r4) {
        Drawable.Callback r5 = (Drawable.Callback) ZeusTransformUtils.wrapperContextForParams(r4, Drawable.Callback.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L5;
        C0856a r2 = null;
    L6:
        this.f16390a = r2;
        super.setCallback(r5);
        if (this.f16390a == null) goto L30;
        Drawable r6 = this.k;
        if (r6 == null) goto L14;
        if (r6.getCallback() != null) goto L14;
        this.k.setCallback(this.f16390a);
    L14:
        if (this.f == false) goto L16;
    L20:
        boolean r7 = false;
    L21:
        Drawable r0 = this.k;
        if (r0 == null) goto L28;
        r0.setCallback(this.f16390a);
        if (ZeusTransformUtils.instanceOf(this.k, Animatable.class) == false) goto L28;
        if (this.m == false) goto L28;
        ((Animatable) ZeusTransformUtils.preCheckCast(this.k, Animatable.class, "com.obric.memorydata.plugin")).start();
    L28:
        if (r7 == false) goto L39;
        this.h.a(this);
        return;
    L39:
        return;
    L16:
        if (this.k != null) goto L18;
    L19:
        r7 = true;
        goto L21
    L18:
        if (this.d == false) goto L20;
    L30:
        Drawable r8 = this.k;
        if (r8 == null) goto L37;
        r8.setCallback(null);
        if (ZeusTransformUtils.instanceOf(this.k, Animatable.class) == false) goto L37;
        Animatable r9 = (Animatable) ZeusTransformUtils.preCheckCast(this.k, Animatable.class, "com.obric.memorydata.plugin");
        boolean r1 = r9.isRunning();
        this.m = r1;
        if (r1 == false) goto L37;
        r9.stop();
    L37:
        this.h.b(this);
        return;
    L5:
        r2 = new C0856a(this, r5);
        goto L6
    }

    public void a(Drawable r5) {
        Drawable r0 = this.k;
        if (r0 == null) goto L5;
        r0.setCallback(null);
    L5:
        this.d = true;
        Rect r1 = r5.getBounds();
        if (r1.isEmpty() == false) goto L12;
        Rect r2 = f.a(r5);
        if (r2.isEmpty() == false) goto L10;
        r5.setBounds(0, 0, 1, 1);
    L11:
        setBounds(r5.getBounds());
        setResult(r5);
    L13:
        this.d = true;
        return;
    L10:
        r5.setBounds(r2);
        goto L11
    L12:
        this.k = r5;
        r5.setCallback(this.f16390a);
        setBounds(r1);
        this.c = false;
        goto L13
    }

    public void a(boolean r1) {
        this.f = r1;
    }

    public String b() {
        return this.g;
    }

    public h c() {
        return this.i;
    }

    public int d() {
        return this.f16391b;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r2) {
        if (g() == false) goto L6;
        this.k.draw(r2);
        return;
    }

    public float e() {
        return this.l;
    }

    public Drawable f() {
        return this.k;
    }

    public boolean g() {
        if (this.k == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (g() == true) goto L7;
        return 1;
    L7:
        return this.k.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (g() == true) goto L7;
        return 1;
    L7:
        return this.k.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        if (g() == true) goto L7;
        return -2;
    L7:
        return this.k.getOpacity();
    }

    public boolean h() {
        if (getCallback() == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean i() {
        return this.f;
    }

    public void j() {
        Drawable r0 = this.h.c(this);
        if (r0 == null) goto L8;
        a(r0);
        if (ZeusTransformUtils.instanceOf(r0, Animatable.class) == false) goto L9;
        ((Animatable) ZeusTransformUtils.preCheckCast(r0, Animatable.class, "com.obric.memorydata.plugin")).start();
        return;
    L9:
        return;
    }

    public void k() {
        if (this.f16391b != 0) goto L7;
        this.c = true;
        Rect r0 = b(this.k);
    L5:
        setBounds(r0);
        return;
    L7:
        this.c = false;
        r0 = l();
        this.k.setBounds(r0);
        this.k.setCallback(this.f16390a);
        goto L5
    }

    public Rect l() {
        return this.j.a(this);
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect r1) {
        super.onBoundsChange(r1);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r1) {
        Drawable r0 = this.k;
        if (r0 == null) goto L6;
        r0.setAlpha(r1);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r1) {
    }

    public void setResult(Drawable r5) {
        if (this.f == true) goto L5;
    L7:
        this.m = false;
        Drawable r1 = this.k;
        if (r1 == null) goto L14;
        r1.setCallback(null);
        if (ZeusTransformUtils.instanceOf(this.k, Animatable.class) == false) goto L14;
        Animatable r2 = (Animatable) ZeusTransformUtils.preCheckCast(this.k, Animatable.class, "com.obric.memorydata.plugin");
        if (r2.isRunning() == false) goto L14;
        r2.stop();
    L14:
        this.k = r5;
        k();
        this.e = false;
        this.d = false;
        return;
    L5:
        if (this.d == true) goto L7;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean r2, boolean r3) {
        Drawable r0 = this.k;
        if (r0 == null) goto L6;
        r0.setVisible(r2, r3);
    L6:
        return super.setVisible(r2, r3);
    }

    public String toString() {
        return "AsyncDrawable{destination='" + this.g + "', imageSize=" + this.i + ", result=" + this.k + ", canvasWidth=" + this.f16391b + ", textSize=" + this.l + ", waitingForDimensions=" + this.c + '}';
    }
}
