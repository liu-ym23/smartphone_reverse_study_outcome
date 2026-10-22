package g1;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import z.i;

/* JADX INFO: loaded from: classes.dex */
public final class d extends f implements Animatable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f7549b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Context f7550m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public e f7551n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ArrayList<g1.c> f7552o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final a f7553p;

    public class a implements Drawable.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f7554a;

        public a(d r8) {
            this.f7554a = r8;
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public final void invalidateDrawable(Drawable r8) {
            this.f7554a.invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public final void scheduleDrawable(Drawable r8, Runnable r10, long r11) {
            this.f7554a.scheduleSelf(r10, r11);
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public final void unscheduleDrawable(Drawable r8, Runnable r10) {
            this.f7554a.unscheduleSelf(r10);
        }
    }

    public static class b extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public g f7555a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public AnimatorSet f7556b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ArrayList<Animator> f7557c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public n.b<Animator, String> f7558d;

        public b(a r8) {
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final Drawable newDrawable(Resources r8) {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }
    }

    public static class c extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Drawable.ConstantState f7559a;

        public c(Drawable.ConstantState r8) {
            this.f7559a = r8;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final boolean canApplyTheme() {
            return this.f7559a.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final int getChangingConfigurations() {
            return this.f7559a.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final Drawable newDrawable() {
            d r8 = new d();
            Drawable r10 = this.f7559a.newDrawable();
            r8.f7561a = r10;
            r10.setCallback(r8.f7553p);
            return r8;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final Drawable newDrawable(Resources r8) {
            d r10 = new d();
            Drawable r11 = this.f7559a.newDrawable(r8);
            r10.f7561a = r11;
            r11.setCallback(r10.f7553p);
            return r10;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final Drawable newDrawable(Resources r8, Resources.Theme r10) {
            d r11 = new d();
            Drawable r12 = this.f7559a.newDrawable(r8, r10);
            r11.f7561a = r12;
            r12.setCallback(r11.f7553p);
            return r11;
        }
    }

    public d() {
        this(null);
    }

    @Override // g1.f, android.graphics.drawable.Drawable
    public final void applyTheme(Resources.Theme r8) {
        Drawable r10 = this.f7561a;
        if (r10 == null) goto L6;
        b0.a.b.a(r10, r8);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean canApplyTheme() {
        Drawable r8 = this.f7561a;
        if (r8 != null) goto L5;
        return false;
    L5:
        return b0.a.b.b(r8);
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r8) {
        Drawable r10 = this.f7561a;
        if (r10 == null) goto L6;
        r10.draw(r8);
        return;
    L6:
        b r11 = this.f7549b;
        r11.f7555a.draw(r8);
        if (r11.f7556b.isStarted() == false) goto L10;
        invalidateSelf();
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        Drawable r8 = this.f7561a;
        if (r8 == null) goto L7;
        return b0.a.C0028a.a(r8);
    L7:
        return this.f7549b.f7555a.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getChangingConfigurations() {
        Drawable r8 = this.f7561a;
        if (r8 != null) goto L5;
        int r10 = super.getChangingConfigurations();
        this.f7549b.getClass();
        return 0 | r10;
    L5:
        return r8.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public final ColorFilter getColorFilter() {
        Drawable r8 = this.f7561a;
        if (r8 == null) goto L7;
        return b0.a.b.c(r8);
    L7:
        return this.f7549b.f7555a.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        if (this.f7561a != null) goto L5;
        return null;
    L5:
        return new c(this.f7561a.getConstantState());
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        Drawable r8 = this.f7561a;
        if (r8 == null) goto L7;
        return r8.getIntrinsicHeight();
    L7:
        return this.f7549b.f7555a.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        Drawable r8 = this.f7561a;
        if (r8 == null) goto L7;
        return r8.getIntrinsicWidth();
    L7:
        return this.f7549b.f7555a.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        Drawable r8 = this.f7561a;
        if (r8 == null) goto L7;
        return r8.getOpacity();
    L7:
        return this.f7549b.f7555a.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public final void inflate(Resources r8, XmlPullParser r10, AttributeSet r11) {
        inflate(r8, r10, r11, null);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isAutoMirrored() {
        Drawable r8 = this.f7561a;
        if (r8 == null) goto L7;
        return b0.a.C0028a.d(r8);
    L7:
        return this.f7549b.f7555a.isAutoMirrored();
    }

    @Override // android.graphics.drawable.Animatable
    public final boolean isRunning() {
        Drawable r8 = this.f7561a;
        if (r8 == null) goto L7;
        return ((AnimatedVectorDrawable) r8).isRunning();
    L7:
        return this.f7549b.f7556b.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        Drawable r8 = this.f7561a;
        if (r8 == null) goto L7;
        return r8.isStateful();
    L7:
        return this.f7549b.f7555a.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable mutate() {
        Drawable r8 = this.f7561a;
        if (r8 == null) goto L5;
        r8.mutate();
    L5:
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect r8) {
        Drawable r10 = this.f7561a;
        if (r10 == null) goto L6;
        r10.setBounds(r8);
        return;
    L6:
        this.f7549b.f7555a.setBounds(r8);
    }

    @Override // g1.f, android.graphics.drawable.Drawable
    public final boolean onLevelChange(int r8) {
        Drawable r10 = this.f7561a;
        if (r10 == null) goto L7;
        return r10.setLevel(r8);
    L7:
        return this.f7549b.f7555a.setLevel(r8);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] r8) {
        Drawable r10 = this.f7561a;
        if (r10 == null) goto L7;
        return r10.setState(r8);
    L7:
        return this.f7549b.f7555a.setState(r8);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r8) {
        Drawable r10 = this.f7561a;
        if (r10 == null) goto L6;
        r10.setAlpha(r8);
        return;
    L6:
        this.f7549b.f7555a.setAlpha(r8);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAutoMirrored(boolean r8) {
        Drawable r10 = this.f7561a;
        if (r10 == null) goto L6;
        b0.a.C0028a.e(r10, r8);
        return;
    L6:
        this.f7549b.f7555a.setAutoMirrored(r8);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r8) {
        Drawable r10 = this.f7561a;
        if (r10 == null) goto L6;
        r10.setColorFilter(r8);
        return;
    L6:
        this.f7549b.f7555a.setColorFilter(r8);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTint(int r8) {
        Drawable r10 = this.f7561a;
        if (r10 == null) goto L6;
        b0.a.a(r10, r8);
        return;
    L6:
        this.f7549b.f7555a.setTint(r8);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList r8) {
        Drawable r10 = this.f7561a;
        if (r10 == null) goto L6;
        b0.a.b(r10, r8);
        return;
    L6:
        this.f7549b.f7555a.setTintList(r8);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode r8) {
        Drawable r10 = this.f7561a;
        if (r10 == null) goto L6;
        b0.a.c(r10, r8);
        return;
    L6:
        this.f7549b.f7555a.setTintMode(r8);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean r8, boolean r10) {
        Drawable r11 = this.f7561a;
        if (r11 != null) goto L5;
        this.f7549b.f7555a.setVisible(r8, r10);
        return super.setVisible(r8, r10);
    L5:
        return r11.setVisible(r8, r10);
    }

    @Override // android.graphics.drawable.Animatable
    public final void start() {
        Drawable r8 = this.f7561a;
        if (r8 == null) goto L6;
        ((AnimatedVectorDrawable) r8).start();
        return;
    L6:
        b r10 = this.f7549b;
        if (r10.f7556b.isStarted() == false) goto L9;
        return;
    L9:
        r10.f7556b.start();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public final void stop() {
        Drawable r8 = this.f7561a;
        if (r8 == null) goto L6;
        ((AnimatedVectorDrawable) r8).stop();
        return;
    L6:
        this.f7549b.f7556b.end();
    }

    public d(Context r8) {
        this.f7551n = null;
        this.f7552o = null;
        a r10 = new a(this);
        this.f7553p = r10;
        this.f7550m = r8;
        this.f7549b = new b(r10);
    }

    @Override // android.graphics.drawable.Drawable
    public final void inflate(Resources r10, XmlPullParser r11, AttributeSet r12, Resources.Theme r13) {
        Drawable r8 = this.f7561a;
        if (r8 == null) goto L6;
        b0.a.b.d(r8, r10, r11, r12, r13);
        return;
    L6:
        int r14 = r11.getEventType();
        int r15 = r11.getDepth() + 1;
    L7:
        b r16 = this.f7549b;
        if (r14 == 1) goto L38;
        if (r11.getDepth() >= r15) goto L14;
        if (r14 == 3) goto L38;
    L14:
        if (r14 != 2) goto L36;
        String r17 = r11.getName();
        if ("animated-vector".equals(r17) == false) goto L24;
        TypedArray r18 = i.e(r10, r13, r12, g1.a.f7545e);
        int r19 = r18.getResourceId(0, 0);
        if (r19 == 0) goto L35;
        g r20 = new g();
        ThreadLocal<TypedValue> r21 = z.f.f14146a;
        r20.f7561a = z.f.a.a(r10, r19, r13);
        new g.h(r20.f7561a.getConstantState());
        r20.f7567p = false;
        r20.setCallback(this.f7553p);
        g r22 = r16.f7555a;
        if (r22 == null) goto L22;
        r22.setCallback(null);
    L22:
        r16.f7555a = r20;
    L35:
        r18.recycle();
        goto L36
    L24:
        if ("target".equals(r17) == false) goto L36;
        r18 = r10.obtainAttributes(r12, g1.a.f7546f);
        String r23 = r18.getString(0);
        int r24 = r18.getResourceId(1, 0);
        if (r24 == 0) goto L35;
        Context r25 = this.f7550m;
        if (r25 == null) goto L33;
        Animator r26 = AnimatorInflater.loadAnimator(r25, r24);
        r26.setTarget(r16.f7555a.f7563b.f7615b.f7613o.getOrDefault(r23, null));
        if (r16.f7557c != null) goto L32;
        r16.f7557c = new ArrayList();
        r16.f7558d = new n.b();
    L32:
        r16.f7557c.add(r26);
        r16.f7558d.put(r26, r23);
        goto L35
    L33:
        r18.recycle();
        throw new IllegalStateException("Context can't be null when inflating animators");
    L36:
        r14 = r11.next();
    L38:
        if (r16.f7556b != null) goto L40;
        r16.f7556b = new AnimatorSet();
    L40:
        r16.f7556b.playTogether(r16.f7557c);
    }
}
