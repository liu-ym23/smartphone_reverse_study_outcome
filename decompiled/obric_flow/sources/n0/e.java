package n0;

import android.util.Log;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class e implements ViewTreeObserver.OnPreDrawListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference f20191a;

    public e(f r5) {
        this.f20191a = new WeakReference(r5);
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        if (Log.isLoggable("ViewTarget", 2) == false) goto L5;
        Log.v("ViewTarget", "OnGlobalLayoutListener called attachStateListener=" + this);
    L5:
        f r10 = (f) this.f20191a.get();
        if (r10 == null) goto L33;
        ArrayList r5 = r10.f20193b;
        if (r5.isEmpty() == true) goto L36;
        ImageView r11 = r10.f20192a;
        int r12 = r11.getPaddingRight() + r11.getPaddingLeft();
        ViewGroup.LayoutParams r13 = r11.getLayoutParams();
        int r14 = 0;
        if (r13 == null) goto L13;
        int r15 = r13.width;
    L14:
        int r16 = r10.a(r11.getWidth(), r15, r12);
        int r17 = r11.getPaddingBottom() + r11.getPaddingTop();
        ViewGroup.LayoutParams r18 = r11.getLayoutParams();
        if (r18 == null) goto L17;
        r14 = r18.height;
    L17:
        int r19 = r10.a(r11.getHeight(), r14, r17);
        if (r16 > 0) goto L20;
        if (r16 == Integer.MIN_VALUE) goto L20;
        return true;
    L20:
        if (r19 > 0) goto L22;
        if (r19 == Integer.MIN_VALUE) goto L22;
        return true;
    L22:
        Iterator r20 = new ArrayList(r5).iterator();
    L24:
        if (r20.hasNext() == false) goto L26;
        ((com.bumptech.glide.request.d) ((c) r20.next())).l(r16, r19);
        goto L24
    L26:
        ViewTreeObserver r21 = r11.getViewTreeObserver();
        if (r21.isAlive() == false) goto L29;
        r21.removeOnPreDrawListener(r10.f20194c);
    L29:
        r10.f20194c = null;
        r5.clear();
        return true;
    L13:
        r15 = 0;
        goto L14
    L36:
        return true;
    L33:
        return true;
    }
}
