package n0;

import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import com.bumptech.glide.R$id;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class b extends a {
    public static final int e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageView f20188a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f20189b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Animatable f20190c;
    public final /* synthetic */ int d;

    static {
        e = R$id.glide_custom_view_target_tag;
    }

    public b(ImageView r5, int r10) {
        this.d = r10;
        this.f20188a = r5;
        this.f20189b = new f(r5);
    }

    @Override // n0.d
    public final void a(com.bumptech.glide.request.d r5) {
        this.f20189b.f20193b.remove(r5);
    }

    @Override // n0.d
    public final void b(Object r5) {
        j(r5);
        if ((r5 instanceof Animatable) == false) goto L5;
        Animatable r10 = (Animatable) r5;
        this.f20190c = r10;
        r10.start();
        return;
    L5:
        this.f20190c = null;
    }

    @Override // n0.d
    public final void c(com.bumptech.glide.request.d r10) {
        f r5 = this.f20189b;
        ImageView r11 = r5.f20192a;
        int r12 = r11.getPaddingRight() + r11.getPaddingLeft();
        ViewGroup.LayoutParams r13 = r11.getLayoutParams();
        int r14 = 0;
        if (r13 == null) goto L5;
        int r15 = r13.width;
    L6:
        int r16 = r5.a(r11.getWidth(), r15, r12);
        ImageView r17 = r5.f20192a;
        int r18 = r17.getPaddingBottom() + r17.getPaddingTop();
        ViewGroup.LayoutParams r19 = r17.getLayoutParams();
        if (r19 == null) goto L9;
        r14 = r19.height;
    L9:
        int r20 = r5.a(r17.getHeight(), r14, r18);
        if (r16 > 0) goto L12;
        if (r16 == Integer.MIN_VALUE) goto L12;
    L15:
        ArrayList r21 = r5.f20193b;
        if (r21.contains(r10) == true) goto L19;
        r21.add(r10);
    L19:
        if (r5.f20194c != null) goto L23;
        ViewTreeObserver r22 = r17.getViewTreeObserver();
        e r23 = new e(r5);
        r5.f20194c = r23;
        r22.addOnPreDrawListener(r23);
        return;
    L23:
        return;
    L12:
        if (r20 > 0) goto L21;
        if (r20 != Integer.MIN_VALUE) goto L15;
    L21:
        r10.l(r16, r20);
        return;
    L5:
        r15 = 0;
        goto L6
    }

    @Override // n0.d
    public final void d(Drawable r5) {
        j(null);
        this.f20190c = null;
        this.f20188a.setImageDrawable(r5);
    }

    @Override // n0.d
    public final com.bumptech.glide.request.b e() {
        Object r5 = this.f20188a.getTag(e);
        if (r5 != null) goto L5;
        return null;
    L5:
        if ((r5 instanceof com.bumptech.glide.request.b) == false) goto L8;
        return (com.bumptech.glide.request.b) r5;
    L8:
        throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
    }

    @Override // n0.d
    public final void f(Drawable r5) {
        f r10 = this.f20189b;
        ViewTreeObserver r11 = r10.f20192a.getViewTreeObserver();
        if (r11.isAlive() == false) goto L5;
        r11.removeOnPreDrawListener(r10.f20194c);
    L5:
        r10.f20194c = null;
        r10.f20193b.clear();
        Animatable r12 = this.f20190c;
        if (r12 == null) goto L8;
        r12.stop();
    L8:
        j(null);
        this.f20190c = null;
        this.f20188a.setImageDrawable(r5);
    }

    @Override // n0.d
    public final void g(com.bumptech.glide.request.d r5) {
        this.f20188a.setTag(e, r5);
    }

    @Override // n0.d
    public final void h(Drawable r5) {
        j(null);
        this.f20190c = null;
        this.f20188a.setImageDrawable(r5);
    }

    @Override // k0.d
    public final void i() {
        Animatable r5 = this.f20190c;
        if (r5 == null) goto L6;
        r5.stop();
        return;
    }

    public final void j(Object r5) {
        switch(this.d) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        ImageView r10 = this.f20188a;
        r10.setImageDrawable((Drawable) r5);
        return;
    L6:
        ImageView r11 = this.f20188a;
        r11.setImageBitmap((Bitmap) r5);
    }

    @Override // k0.d
    public final void onStart() {
        Animatable r5 = this.f20190c;
        if (r5 == null) goto L6;
        r5.start();
        return;
    }

    public final String toString() {
        return "Target for: " + this.f20188a;
    }
}
