package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.TypedValue;
import com.obric.cae.R;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class l0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final PorterDuff.Mode f1208f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static l0 f1209g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f1210h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakHashMap<Context, n.i<ColorStateList>> f1211a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WeakHashMap<Context, n.e<WeakReference<Drawable.ConstantState>>> f1212b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TypedValue f1213c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f1214d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b f1215e;

    public static class a extends n.f<Integer, PorterDuffColorFilter> {
        public a() {
            super(6);
        }
    }

    public interface b {
    }

    static {
        f1208f = PorterDuff.Mode.SRC_IN;
        f1210h = new a();
    }

    public l0() {
        this.f1212b = new WeakHashMap(0);
    }

    public static synchronized l0 c() {
        monitor-enter(l0.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f1209g != null) goto L7;
        f1209g = new l0();     // Catch: Throwable -> L10
    L7:
        l0 r8 = f1209g;     // Catch: Throwable -> L10
        monitor-exit(l0.class);
        return r8;
    }

    public static synchronized PorterDuffColorFilter g(int r8, PorterDuff.Mode r10) {
        monitor-enter(l0.class);
        a r11 = f1210h;     // Catch: Throwable -> L9
        r11.getClass();     // Catch: Throwable -> L9
        int r12 = (r8 + 31) * 31;     // Catch: Throwable -> L9
        PorterDuffColorFilter r13 = r11.a(Integer.valueOf(r10.hashCode() + r12));     // Catch: Throwable -> L9
        if (r13 != null) goto L7;
        r13 = new PorterDuffColorFilter(r8, r10);     // Catch: Throwable -> L9
        r11.getClass();     // Catch: Throwable -> L9
        PorterDuffColorFilter r14 = r11.b(Integer.valueOf(r10.hashCode() + r12), r13);     // Catch: Throwable -> L9
    L7:
        monitor-exit(l0.class);
        return r13;
    L9:
        th = move-exception;
        throw th;
    }

    public final synchronized void a(Context r8, long r10, Drawable r11) {
        monitor-enter(this);
        Drawable.ConstantState r12 = r11.getConstantState();     // Catch: Throwable -> L13
        if (r12 == null) goto L11;
        n.e<WeakReference<Drawable.ConstantState>> r13 = this.f1212b.get(r8);     // Catch: Throwable -> L13
        if (r13 != null) goto L8;
        r13 = new n.e();     // Catch: Throwable -> L13
        this.f1212b.put(r8, r13);     // Catch: Throwable -> L13
    L8:
        r13.g(r10, new WeakReference(r12));     // Catch: Throwable -> L13
        monitor-exit(this);
        return;
    L11:
        monitor-exit(this);
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public final Drawable b(Context r8, int r10) {
        if (this.f1213c != null) goto L5;
        this.f1213c = new TypedValue();
    L5:
        TypedValue r11 = this.f1213c;
        r8.getResources().getValue(r10, r11, true);
        long r12 = (((long) r11.assetCookie) << 32) | ((long) r11.data);
        Drawable r13 = d(r8, r12);
        if (r13 == null) goto L9;
        return r13;
    L9:
        if (this.f1215e != null) goto L12;
    L24:
        LayerDrawable r14 = null;
    L25:
        if (r14 == null) goto L27;
        r14.setChangingConfigurations(r11.changingConfigurations);
        a(r8, r12, r14);
    L27:
        return r14;
    L12:
        if (r10 != R.drawable.abc_cab_background_top_material) goto L15;
        r14 = new LayerDrawable(new Drawable[]{e(r8, R.drawable.abc_cab_background_internal_bg), e(r8, R.drawable.abc_cab_background_top_mtrl_alpha)});
        goto L25
    L15:
        if (r10 != R.drawable.abc_ratingbar_material) goto L18;
        int r15 = R.dimen.abc_star_big;
    L23:
        r14 = j.a.c(this, r8, r15);
        goto L25
    L18:
        if (r10 != R.drawable.abc_ratingbar_indicator_material) goto L21;
        r15 = R.dimen.abc_star_medium;
        goto L23
    L21:
        if (r10 != R.drawable.abc_ratingbar_small_material) goto L24;
        r15 = R.dimen.abc_star_small;
        goto L23
    }

    public final synchronized Drawable d(Context r8, long r10) {
        monitor-enter(this);
        n.e<WeakReference<Drawable.ConstantState>> r11 = this.f1212b.get(r8);     // Catch: Throwable -> L22
        if (r11 != null) goto L8;
        monitor-exit(this);
        return null;
    L8:
        WeakReference r12 = (WeakReference) r11.e(r10, null);     // Catch: Throwable -> L22
        if (r12 == null) goto L20;
        Drawable.ConstantState r13 = (Drawable.ConstantState) r12.get();     // Catch: Throwable -> L22
        if (r13 == null) goto L15;
        Drawable r14 = r13.newDrawable(r8.getResources());     // Catch: Throwable -> L22
        monitor-exit(this);
        return r14;
    L15:
        int r15 = defpackage.c.t(r11.f9372b, r11.f9374n, r10);     // Catch: Throwable -> L22
        if (r15 < 0) goto L20;
        Object[] r16 = r11.f9373m;     // Catch: Throwable -> L22
        Object r17 = r16[r15];     // Catch: Throwable -> L22
        Object r18 = n.e.f9370o;     // Catch: Throwable -> L22
        if (r17 == r18) goto L20;
        r16[r15] = r18;     // Catch: Throwable -> L22
        r11.f9371a = true;     // Catch: Throwable -> L22
    L20:
        monitor-exit(this);
        return null;
    L22:
        th = move-exception;
        throw th;
    }

    public final synchronized Drawable e(Context r8, int r10) {
        monitor-enter(this);
        Drawable r11 = f(r8, false, r10);     // Catch: Throwable -> L7
        monitor-exit(this);
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    public final synchronized Drawable f(Context r12, boolean r13, int r14) {
        monitor-enter(this);
        boolean r8 = false;
        if (this.f1214d == true) goto L16;
        this.f1214d = true;     // Catch: Throwable -> L30
        Drawable r10 = e(r12, R.drawable.abc_vector_test);     // Catch: Throwable -> L30
        if (r10 != null) goto L9;
    L56:
        this.f1214d = false;     // Catch: Throwable -> L30
        throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");     // Catch: Throwable -> L30
    L9:
        if ((r10 instanceof g1.g) == false) goto L11;
    L14:
        boolean r11 = true;
    L15:
        if (r11 == false) goto L56;
    L11:
        if ("android.graphics.drawable.VectorDrawable".equals(r10.getClass().getName()) == true) goto L14;
        r11 = false;
    L16:
        Drawable r15 = b(r12, r14);     // Catch: Throwable -> L30
        if (r15 != null) goto L19;
        Object r16 = androidx.core.content.a.f1674a;     // Catch: Throwable -> L30
        r15 = androidx.core.content.a.b.b(r12, r14);     // Catch: Throwable -> L30
    L19:
        if (r15 == null) goto L52;
        ColorStateList r17 = h(r12, r14);     // Catch: Throwable -> L30
        PorterDuff.Mode r18 = null;
        if (r17 == null) goto L34;
        Rect r19 = d0.f1115a;     // Catch: Throwable -> L30
        Drawable r110 = r15.mutate();     // Catch: Throwable -> L30
        b0.a.b.h(r110, r17);     // Catch: Throwable -> L30
        if (this.f1215e != null) goto L26;
    L28:
        if (r18 == null) goto L32;
        b0.a.b.i(r110, r18);     // Catch: Throwable -> L30
    L32:
        r15 = r110;
        goto L52
    L26:
        if (r14 != R.drawable.abc_switch_thumb_material) goto L28;
        r18 = PorterDuff.Mode.MULTIPLY;     // Catch: Throwable -> L30
        goto L28
    L34:
        if (this.f1215e == null) goto L49;
        if (r14 != R.drawable.abc_seekbar_track_material) goto L39;
        LayerDrawable r20 = (LayerDrawable) r15;     // Catch: Throwable -> L30
        Drawable r21 = r20.findDrawableByLayerId(android.R.id.background);     // Catch: Throwable -> L30
        int r22 = q0.c(r12, R.attr.colorControlNormal);     // Catch: Throwable -> L30
        PorterDuff.Mode r111 = j.f1191b;     // Catch: Throwable -> L30
        j.a.e(r21, r22, r111);     // Catch: Throwable -> L30
        j.a.e(r20.findDrawableByLayerId(android.R.id.secondaryProgress), q0.c(r12, R.attr.colorControlNormal), r111);     // Catch: Throwable -> L30
        j.a.e(r20.findDrawableByLayerId(android.R.id.progress), q0.c(r12, R.attr.colorControlActivated), r111);     // Catch: Throwable -> L30
    L45:
        r8 = true;
    L46:
        if (r8 == false) goto L49;
    L39:
        if (r14 != R.drawable.abc_ratingbar_material) goto L41;
    L44:
        LayerDrawable r23 = (LayerDrawable) r15;     // Catch: Throwable -> L30
        Drawable r24 = r23.findDrawableByLayerId(android.R.id.background);     // Catch: Throwable -> L30
        int r25 = q0.b(r12, R.attr.colorControlNormal);     // Catch: Throwable -> L30
        PorterDuff.Mode r26 = j.f1191b;     // Catch: Throwable -> L30
        j.a.e(r24, r25, r26);     // Catch: Throwable -> L30
        j.a.e(r23.findDrawableByLayerId(android.R.id.secondaryProgress), q0.c(r12, R.attr.colorControlActivated), r26);     // Catch: Throwable -> L30
        j.a.e(r23.findDrawableByLayerId(android.R.id.progress), q0.c(r12, R.attr.colorControlActivated), r26);     // Catch: Throwable -> L30
        goto L45
    L41:
        if (r14 == R.drawable.abc_ratingbar_indicator_material) goto L44;
        if (r14 != R.drawable.abc_ratingbar_small_material) goto L46;
    L49:
        if (i(r12, r14, r15) == true) goto L52;
        if (r13 == false) goto L52;
        r15 = null;
    L52:
        if (r15 == null) goto L54;
        Rect r112 = d0.f1115a;     // Catch: Throwable -> L30
    L54:
        monitor-exit(this);
        return r15;
    L30:
        th = move-exception;
        throw th;
    }

    public final synchronized ColorStateList h(Context r8, int r10) {
        monitor-enter(this);
        WeakHashMap<Context, n.i<ColorStateList>> r11 = this.f1211a;     // Catch: Throwable -> L8
        ColorStateList r12 = null;
        if (r11 == null) goto L10;
        n.i<ColorStateList> r13 = r11.get(r8);     // Catch: Throwable -> L8
        if (r13 == null) goto L10;
        ColorStateList r14 = (ColorStateList) r13.c(r10, null);     // Catch: Throwable -> L8
    L11:
        if (r14 != null) goto L25;
        b r15 = this.f1215e;     // Catch: Throwable -> L8
        if (r15 == null) goto L16;
        r12 = ((j.a) r15).d(r8, r10);     // Catch: Throwable -> L8
    L16:
        if (r12 != null) goto L18;
    L24:
        r14 = r12;
        goto L25
    L18:
        if (this.f1211a != null) goto L20;
        this.f1211a = new WeakHashMap();     // Catch: Throwable -> L8
    L20:
        n.i<ColorStateList> r16 = this.f1211a.get(r8);     // Catch: Throwable -> L8
        if (r16 != null) goto L23;
        r16 = new n.i();     // Catch: Throwable -> L8
        this.f1211a.put(r8, r16);     // Catch: Throwable -> L8
    L23:
        r16.a(r10, r12);     // Catch: Throwable -> L8
    L25:
        monitor-exit(this);
        return r14;
    L10:
        r14 = null;
    L8:
        th = move-exception;
        throw th;
    }

    public final boolean i(Context r8, int r10, Drawable r11) {
        b r12 = this.f1215e;
        if (r12 == null) goto L31;
        j.a r13 = (j.a) r12;
        PorterDuff.Mode r14 = j.f1191b;
        if (j.a.a(r10, r13.f1194a) == false) goto L8;
        int r15 = R.attr.colorControlNormal;
    L19:
        int r16 = r15;
        boolean r17 = true;
    L21:
        PorterDuff.Mode r18 = r14;
        int r19 = r16;
        int r20 = -1;
    L22:
        if (r17 == false) goto L27;
        Rect r21 = d0.f1115a;
        Drawable r22 = r11.mutate();
        r22.setColorFilter(j.c(q0.c(r8, r19), r18));
        if (r20 == (-1)) goto L26;
        r22.setAlpha(r20);
    L26:
        boolean r23 = true;
    L28:
        if (r23 == true) goto L30;
        return false;
    L30:
        return true;
    L27:
        r23 = false;
        goto L28
    L8:
        if (j.a.a(r10, r13.f1196c) == false) goto L11;
        r15 = R.attr.colorControlActivated;
        goto L19
    L11:
        if (j.a.a(r10, r13.f1197d) == false) goto L14;
        r14 = PorterDuff.Mode.MULTIPLY;
    L18:
        r15 = android.R.attr.colorBackground;
        goto L19
    L14:
        if (r10 != R.drawable.abc_list_divider_mtrl_alpha) goto L17;
        r18 = r14;
        r19 = 16842800;
        r20 = Math.round(40.8f);
        r17 = true;
        goto L22
    L17:
        if (r10 == R.drawable.abc_dialog_material_background) goto L18;
        r17 = false;
        r16 = 0;
        goto L21
    L31:
        return false;
    }
}
