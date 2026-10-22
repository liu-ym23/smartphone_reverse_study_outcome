package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.util.Arrays;
import java.util.HashMap;
import s.j;

/* JADX INFO: loaded from: classes.dex */
public abstract class c extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int[] f1430a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1431b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Context f1432m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public j f1433n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f1434o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f1435p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public View[] f1436q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final HashMap<Integer, String> f1437r;

    public c(Context r8) {
        super(r8);
        this.f1430a = new int[32];
        this.f1436q = null;
        this.f1437r = new HashMap();
        this.f1432m = r8;
        i(null);
    }

    public final void c(String r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        if (r8.length() == 0) goto L44;
        Context r10 = this.f1432m;
        if (r10 != null) goto L9;
        return;
    L9:
        String r11 = r8.trim();
        if ((getParent() instanceof ConstraintLayout) == false) goto L12;
        ConstraintLayout r12 = (ConstraintLayout) getParent();
    L14:
        if (isInEditMode() == false) goto L27;
        if (r12 == null) goto L27;
        if ((r11 instanceof String) == false) goto L23;
        HashMap<String, Integer> r13 = r12.f1355w;
        if (r13 == null) goto L23;
        if (r13.containsKey(r11) == false) goto L23;
        Integer r14 = r12.f1355w.get(r11);
    L25:
        if ((r14 instanceof Integer) == false) goto L27;
        int r15 = r14.intValue();
    L28:
        if (r15 != 0) goto L31;
        if (r12 == null) goto L31;
        r15 = h(r12, r11);
    L31:
        if (r15 == 0) goto L40;
    L33:
        if (r15 != 0) goto L35;
        r15 = r10.getResources().getIdentifier(r11, "id", r10.getPackageName());
    L35:
        if (r15 == 0) goto L37;
        this.f1437r.put(Integer.valueOf(r15), r11);
        d(r15);
        return;
    L37:
        Log.w("ConstraintHelper", "Could not find id of \"" + r11 + "\"");
        return;
    L40:
        r15 = v.c.class.getField(r11).getInt(null);     // Catch: Exception -> L39
    L23:
        r14 = null;
    L27:
        r15 = 0;
        goto L28
    L12:
        r12 = null;
        goto L14
    }

    public final void d(int r8) {
        if (r8 != getId()) goto L5;
        return;
    L5:
        int r10 = this.f1431b + 1;
        int[] r11 = this.f1430a;
        if (r10 <= r11.length) goto L8;
        this.f1430a = Arrays.copyOf(r11, r11.length * 2);
    L8:
        int[] r12 = this.f1430a;
        int r13 = this.f1431b;
        r12[r13] = r8;
        this.f1431b = r13 + 1;
    }

    public final void e(String r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        if (r8.length() != 0) goto L7;
        return;
    L7:
        if (this.f1432m != null) goto L9;
        return;
    L9:
        String r10 = r8.trim();
        if ((getParent() instanceof ConstraintLayout) == false) goto L12;
        ConstraintLayout r11 = (ConstraintLayout) getParent();
    L14:
        if (r11 != null) goto L17;
        Log.w("ConstraintHelper", "Parent not a ConstraintLayout");
        return;
    L17:
        int r12 = r11.getChildCount();
        int r13 = 0;
    L18:
        if (r13 >= r12) goto L35;
        View r14 = r11.getChildAt(r13);
        ViewGroup.LayoutParams r15 = r14.getLayoutParams();
        if ((r15 instanceof ConstraintLayout.a) == false) goto L27;
        if (r10.equals(((ConstraintLayout.a) r15).Y) == false) goto L27;
        if (r14.getId() != (-1)) goto L26;
        Log.w("ConstraintHelper", "to use ConstraintTag view " + r14.getClass().getSimpleName() + " must have an ID");
        goto L27
    L26:
        d(r14.getId());
    L27:
        r13 = r13 + 1;
        goto L18
    L35:
        return;
    L12:
        r11 = null;
        goto L14
    }

    public final void f(ConstraintLayout r8) {
        int r10 = getVisibility();
        float r11 = getElevation();
        int r12 = 0;
    L4:
        if (r12 >= this.f1431b) goto L11;
        int r13 = this.f1430a[r12];
        View r14 = r8.f1343a.get(r13);
        if (r14 == null) goto L10;
        r14.setVisibility(r10);
        if (r11 <= 0.0f) goto L10;
        r14.setTranslationZ(r14.getTranslationZ() + r11);
    L10:
        r12 = r12 + 1;
        goto L4
    }

    public void g(ConstraintLayout r8) {
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.f1430a, this.f1431b);
    }

    public final int h(ConstraintLayout r8, String r10) {
        if (r10 == null) goto L21;
        if (r8 == null) goto L21;
        Resources r11 = this.f1432m.getResources();
        if (r11 != null) goto L9;
        return 0;
    L9:
        int r12 = r8.getChildCount();
        int r13 = 0;
    L10:
        if (r13 >= r12) goto L21;
        View r14 = r8.getChildAt(r13);
        if (r14.getId() == (-1)) goto L20;
        String r15 = r11.getResourceEntryName(r14.getId());     // Catch: Resources.NotFoundException -> L15
    L17:
        if (r10.equals(r15) == false) goto L20;
        return r14.getId();
    L15:
        r15 = null;
    L20:
        r13 = r13 + 1;
    L21:
        return 0;
    }

    public void i(AttributeSet r8) {
        if (r8 == null) goto L18;
        TypedArray r10 = getContext().obtainStyledAttributes(r8, v.d.f12656b);
        int r11 = r10.getIndexCount();
        int r12 = 0;
    L4:
        if (r12 >= r11) goto L12;
        int r13 = r10.getIndex(r12);
        if (r13 != 35) goto L9;
        String r14 = r10.getString(r13);
        this.f1434o = r14;
        setIds(r14);
    L11:
        r12 = r12 + 1;
        goto L4
    L9:
        if (r13 != 36) goto L11;
        String r15 = r10.getString(r13);
        this.f1435p = r15;
        setReferenceTags(r15);
        goto L11
    L12:
        r10.recycle();
        return;
    }

    public void j(s.e r8, boolean r10) {
    }

    public final void k() {
        if (this.f1433n != null) goto L5;
        return;
    L5:
        ViewGroup.LayoutParams r8 = getLayoutParams();
        if ((r8 instanceof ConstraintLayout.a) == false) goto L9;
        j r10 = this.f1433n;
        ((ConstraintLayout.a) r8).f1390q0 = r10;
        return;
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String r8 = this.f1434o;
        if (r8 == null) goto L5;
        setIds(r8);
    L5:
        String r10 = this.f1435p;
        if (r10 == null) goto L9;
        setReferenceTags(r10);
        return;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r8) {
    }

    @Override // android.view.View
    public void onMeasure(int r8, int r10) {
        setMeasuredDimension(0, 0);
    }

    public void setIds(String r8) {
        this.f1434o = r8;
        if (r8 != null) goto L5;
        return;
    L5:
        int r10 = 0;
        this.f1431b = 0;
    L6:
        int r11 = r8.indexOf(44, r10);
        if (r11 == (-1)) goto L8;
        c(r8.substring(r10, r11));
        r10 = r11 + 1;
        goto L6
    L8:
        c(r8.substring(r10));
    }

    public void setReferenceTags(String r8) {
        this.f1435p = r8;
        if (r8 != null) goto L5;
        return;
    L5:
        int r10 = 0;
        this.f1431b = 0;
    L6:
        int r11 = r8.indexOf(44, r10);
        if (r11 == (-1)) goto L8;
        e(r8.substring(r10, r11));
        r10 = r11 + 1;
        goto L6
    L8:
        e(r8.substring(r10));
    }

    public void setReferencedIds(int[] r8) {
        this.f1434o = null;
        int r10 = 0;
        this.f1431b = 0;
    L4:
        if (r10 >= r8.length) goto L6;
        d(r8[r10]);
        r10 = r10 + 1;
        goto L4
    }

    @Override // android.view.View
    public final void setTag(int r8, Object r10) {
        super.setTag(r8, r10);
        if (r10 == null) goto L5;
        return;
    L5:
        if (this.f1434o != null) goto L9;
        d(r8);
        return;
    }

    public c(Context r8, AttributeSet r10) {
        super(r8, r10);
        this.f1430a = new int[32];
        this.f1436q = null;
        this.f1437r = new HashMap();
        this.f1432m = r8;
        i(r10);
    }
}
