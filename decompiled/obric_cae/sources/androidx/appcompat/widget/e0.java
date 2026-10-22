package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.obric.cae.R;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class e0 extends ListView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Rect f1119a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1120b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f1121m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f1122n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f1123o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f1124p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public d f1125q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f1126r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final boolean f1127s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f1128t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public androidx.core.widget.g f1129u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public f f1130v;

    public static class a {
        public static void a(View r8, float r10, float r11) {
            r8.drawableHotspotChanged(r10, r11);
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Method f1131a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Method f1132b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Method f1133c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final boolean f1134d = false;

        static {
            Class r8 = Integer.TYPE;     // Catch: NoSuchMethodException -> L5
            Class r10 = Float.TYPE;     // Catch: NoSuchMethodException -> L5
            Method r11 = AbsListView.class.getDeclaredMethod("positionSelector", new Class[]{r8, View.class, Boolean.TYPE, r10, r10});     // Catch: NoSuchMethodException -> L5
            f1131a = r11;     // Catch: NoSuchMethodException -> L5
            r11.setAccessible(true);     // Catch: NoSuchMethodException -> L5
            Method r12 = AdapterView.class.getDeclaredMethod("setSelectedPositionInt", new Class[]{r8});     // Catch: NoSuchMethodException -> L5
            f1132b = r12;     // Catch: NoSuchMethodException -> L5
            r12.setAccessible(true);     // Catch: NoSuchMethodException -> L5
            Method r13 = AdapterView.class.getDeclaredMethod("setNextSelectedPositionInt", new Class[]{r8});     // Catch: NoSuchMethodException -> L5
            f1133c = r13;     // Catch: NoSuchMethodException -> L5
            r13.setAccessible(true);     // Catch: NoSuchMethodException -> L5
            f1134d = true;     // Catch: NoSuchMethodException -> L5
            return;
        L5:
            e = move-exception;
            e.printStackTrace();
        }
    }

    public static class c {
        public static boolean a(AbsListView r8) {
            return r8.isSelectedChildViewEnabled();
        }

        public static void b(AbsListView r8, boolean r10) {
            r8.setSelectedChildViewEnabled(r10);
        }
    }

    public static class d extends e.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f1135b;

        public d(Drawable r8) {
            super(r8);
            this.f1135b = true;
        }

        @Override // e.a, android.graphics.drawable.Drawable
        public final void draw(Canvas r8) {
            if (this.f1135b == false) goto L6;
            super.draw(r8);
            return;
        }

        @Override // e.a, android.graphics.drawable.Drawable
        public final void setHotspot(float r8, float r10) {
            if (this.f1135b == false) goto L6;
            super.setHotspot(r8, r10);
            return;
        }

        @Override // e.a, android.graphics.drawable.Drawable
        public final void setHotspotBounds(int r8, int r10, int r11, int r12) {
            if (this.f1135b == false) goto L6;
            super.setHotspotBounds(r8, r10, r11, r12);
            return;
        }

        @Override // e.a, android.graphics.drawable.Drawable
        public final boolean setState(int[] r8) {
            if (this.f1135b == true) goto L5;
            return false;
        L5:
            return super.setState(r8);
        }

        @Override // e.a, android.graphics.drawable.Drawable
        public final boolean setVisible(boolean r8, boolean r10) {
            if (this.f1135b == true) goto L5;
            return false;
        L5:
            return super.setVisible(r8, r10);
        }
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Field f1136a = null;

        static {
            Field r8 = null;
            r8 = AbsListView.class.getDeclaredField("mIsChildViewEnabled");     // Catch: NoSuchFieldException -> L5
            r8.setAccessible(true);     // Catch: NoSuchFieldException -> L5
        L7:
            f1136a = r8;
            return;
        L5:
            e = move-exception;
            e.printStackTrace();
            goto L7
        }
    }

    public class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e0 f1137a;

        public f(e0 r8) {
            this.f1137a = r8;
        }

        @Override // java.lang.Runnable
        public final void run() {
            e0 r8 = this.f1137a;
            r8.f1130v = null;
            r8.drawableStateChanged();
        }
    }

    public e0(Context r8, boolean r10) {
        super(r8, null, R.attr.dropDownListViewStyle);
        this.f1119a = new Rect();
        this.f1120b = 0;
        this.f1121m = 0;
        this.f1122n = 0;
        this.f1123o = 0;
        this.f1127s = r10;
        setCacheColorHint(0);
    }

    private void setSelectorEnabled(boolean r8) {
        d r10 = this.f1125q;
        if (r10 == null) goto L6;
        r10.f1135b = r8;
        return;
    }

    public final int a(int r12, int r13) {
        int r8 = getListPaddingTop();
        int r10 = getListPaddingBottom();
        int r11 = getDividerHeight();
        Drawable r14 = getDivider();
        ListAdapter r15 = getAdapter();
        int r16 = r8 + r10;
        if (r15 != null) goto L6;
        return r16;
    L6:
        if (r11 <= 0) goto L9;
        if (r14 == null) goto L9;
    L10:
        int r17 = r15.getCount();
        int r18 = 0;
        int r19 = 0;
        View r20 = null;
    L11:
        if (r18 >= r17) goto L29;
        int r21 = r15.getItemViewType(r18);
        if (r21 == r19) goto L15;
        r20 = null;
        r19 = r21;
    L15:
        r20 = r15.getView(r18, r20, this);
        ViewGroup.LayoutParams r22 = r20.getLayoutParams();
        if (r22 != null) goto L18;
        r22 = generateDefaultLayoutParams();
        r20.setLayoutParams(r22);
    L18:
        int r23 = r22.height;
        if (r23 <= 0) goto L21;
        int r24 = View.MeasureSpec.makeMeasureSpec(r23, 1073741824);
    L22:
        r20.measure(r12, r24);
        r20.forceLayout();
        if (r18 <= 0) goto L25;
        r16 = r16 + r11;
    L25:
        r16 = r16 + r20.getMeasuredHeight();
        if (r16 >= r13) goto L27;
        r18 = r18 + 1;
        goto L11
    L27:
        return r13;
    L21:
        r24 = View.MeasureSpec.makeMeasureSpec(0, 0);
        goto L22
    L29:
        return r16;
    L9:
        r11 = 0;
        goto L10
    }

    public final boolean b(MotionEvent r17, int r18) {
        int r8 = r17.getActionMasked();
        boolean r10 = false;
        if (r8 != 1) goto L5;
        boolean r11 = false;
    L11:
        int r12 = r17.findPointerIndex(r18);
        if (r12 >= 0) goto L14;
    L13:
        r11 = false;
    L76:
        if (r11 == false) goto L78;
        if (r10 == true) goto L78;
    L81:
        if (r11 == true) goto L83;
        androidx.core.widget.g r13 = this.f1129u;
        if (r13 != null) goto L89;
    L92:
        return r11;
    L89:
        if (r13.f1719z == false) goto L91;
        r13.d();
    L91:
        r13.f1719z = false;
        goto L92
    L83:
        if (this.f1129u != null) goto L85;
        this.f1129u = new androidx.core.widget.g(this);
    L85:
        androidx.core.widget.g r14 = this.f1129u;
        boolean r15 = r14.f1719z;
        r14.f1719z = true;
        r14.onTouch(this, r17);
    L78:
        this.f1128t = false;
        setPressed(false);
        drawableStateChanged();
        View r16 = getChildAt(this.f1124p - getFirstVisiblePosition());
        if (r16 == null) goto L81;
        r16.setPressed(false);
        goto L81
    L14:
        int r19 = (int) r17.getX(r12);
        int r20 = (int) r17.getY(r12);
        int r21 = pointToPosition(r19, r20);
        if (r21 != (-1)) goto L17;
        r10 = true;
        goto L76
    L17:
        View r110 = getChildAt(r21 - getFirstVisiblePosition());
        float r22 = r19;
        float r23 = r20;
        this.f1128t = true;
        a.a(this, r22, r23);
        if (isPressed() == true) goto L20;
        setPressed(true);
    L20:
        layoutChildren();
        int r24 = this.f1124p;
        if (r24 == (-1)) goto L28;
        View r25 = getChildAt(r24 - getFirstVisiblePosition());
        if (r25 == null) goto L28;
        if (r25 == r110) goto L28;
        if (r25.isPressed() == false) goto L28;
        r25.setPressed(false);
    L28:
        this.f1124p = r21;
        a.a(r110, r22 - r110.getLeft(), r23 - r110.getTop());
        if (r110.isPressed() == true) goto L31;
        r110.setPressed(true);
    L31:
        Drawable r111 = getSelector();
        if (r111 == null) goto L35;
        if (r21 == (-1)) goto L35;
        boolean r112 = true;
    L36:
        if (r112 == false) goto L38;
        r111.setVisible(false, false);
    L38:
        int r26 = r110.getLeft();
        int r113 = r110.getTop();
        int r114 = r110.getRight();
        int r115 = r110.getBottom();
        Rect r27 = this.f1119a;
        r27.set(r26, r113, r114, r115);
        r27.left -= this.f1120b;
        r27.top -= this.f1121m;
        r27.right += this.f1122n;
        r27.bottom += this.f1123o;
        if (f0.a.a() == false) goto L41;
        boolean r28 = c.a(this);
    L49:
        if (r110.isEnabled() == r28) goto L61;
        boolean r29 = !r28;
        if (f0.a.a() == false) goto L53;
        c.b(this, r29);
    L59:
        if (r21 == (-1)) goto L61;
        refreshDrawableState();
        goto L61
    L53:
        Field r116 = e.f1136a;
        if (r116 == null) goto L59;
        r116.set(this, Boolean.valueOf(r29));     // Catch: IllegalAccessException -> L57
    L57:
        e = move-exception;
        e.printStackTrace();
    L61:
        if (r112 == false) goto L67;
        float r30 = r27.exactCenterX();
        float r31 = r27.exactCenterY();
        if (getVisibility() != 0) goto L65;
        boolean r117 = true;
    L66:
        boolean r118 = false;
        r111.setVisible(r117, false);
        b0.a.b.e(r111, r30, r31);
    L68:
        Drawable r32 = getSelector();
        if (r32 == null) goto L72;
        if (r21 == (-1)) goto L72;
        b0.a.b.e(r32, r22, r23);
    L72:
        setSelectorEnabled(r118);
        refreshDrawableState();
        if (r8 != 1) goto L75;
        performItemClick(r110, r21, getItemIdAtPosition(r21));
    L75:
        r11 = true;
        r10 = false;
        goto L76
    L65:
        r117 = false;
        goto L66
    L67:
        r118 = false;
        goto L68
    L41:
        Field r33 = e.f1136a;
        if (r33 != null) goto L95;
    L47:
        r28 = false;
        goto L49
    L95:
        r28 = r33.getBoolean(this);     // Catch: IllegalAccessException -> L45
    L45:
        e = move-exception;
        e.printStackTrace();
    L35:
        r112 = false;
        goto L36
    L5:
        if (r8 != 2) goto L7;
        r11 = true;
        goto L11
    L7:
        if (r8 == 3) goto L13;
        r11 = true;
        goto L76
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r8) {
        Rect r10 = this.f1119a;
        if (r10.isEmpty() == true) goto L7;
        Drawable r11 = getSelector();
        if (r11 == null) goto L7;
        r11.setBounds(r10);
        r11.draw(r8);
    L7:
        super.dispatchDraw(r8);
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        if (this.f1130v == null) goto L5;
        return;
    L5:
        super.drawableStateChanged();
        setSelectorEnabled(true);
        Drawable r8 = getSelector();
        if (r8 != null) goto L8;
        return;
    L8:
        if (this.f1128t == true) goto L10;
        return;
    L10:
        if (isPressed() == false) goto L15;
        r8.setState(getDrawableState());
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean hasFocus() {
        if (this.f1127s == false) goto L5;
    L8:
        return true;
    L5:
        if (super.hasFocus() == true) goto L8;
        return false;
    }

    @Override // android.view.View
    public final boolean hasWindowFocus() {
        if (this.f1127s == false) goto L5;
    L8:
        return true;
    L5:
        if (super.hasWindowFocus() == true) goto L8;
        return false;
    }

    @Override // android.view.View
    public final boolean isFocused() {
        if (this.f1127s == false) goto L5;
    L8:
        return true;
    L5:
        if (super.isFocused() == true) goto L8;
        return false;
    }

    @Override // android.view.View
    public final boolean isInTouchMode() {
        if (this.f1127s == false) goto L7;
        if (this.f1126r == false) goto L7;
    L8:
        return true;
    L7:
        if (super.isInTouchMode() == true) goto L8;
        return false;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        this.f1130v = null;
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent r10) {
        int r8 = r10.getActionMasked();
        if (r8 == 10) goto L5;
    L7:
        boolean r11 = super.onHoverEvent(r10);
        if (r8 != 9) goto L10;
    L13:
        int r12 = pointToPosition((int) r10.getX(), (int) r10.getY());
        if (r12 != (-1)) goto L16;
    L35:
        return r11;
    L16:
        if (r12 == getSelectedItemPosition()) goto L35;
        View r13 = getChildAt(r12 - getFirstVisiblePosition());
        if (r13.isEnabled() == false) goto L28;
        requestFocus();
        if (b.f1134d == true) goto L36;
        setSelectionFromTop(r12, r13.getTop() - getTop());
        goto L28
    L36:
        b.f1131a.invoke(this, new Object[]{Integer.valueOf(r12), r13, Boolean.FALSE, -1, -1});     // Catch: InvocationTargetException -> L23 IllegalAccessException -> L25
        b.f1132b.invoke(this, new Object[]{Integer.valueOf(r12)});     // Catch: InvocationTargetException -> L23 IllegalAccessException -> L25
        b.f1133c.invoke(this, new Object[]{Integer.valueOf(r12)});     // Catch: InvocationTargetException -> L23 IllegalAccessException -> L25
    L25:
        e = move-exception;
        e.printStackTrace();
    L23:
        e = move-exception;
        e.printStackTrace();
    L28:
        Drawable r14 = getSelector();
        if (r14 == null) goto L35;
        if (this.f1128t == false) goto L35;
        if (isPressed() == false) goto L35;
        r14.setState(getDrawableState());
        goto L35
    L10:
        if (r8 == 7) goto L13;
        setSelection(-1);
        goto L35
    L5:
        if (this.f1130v != null) goto L7;
        f r15 = new f(this);
        this.f1130v = r15;
        post(r15);
        goto L7
    }

    @Override // android.widget.AbsListView, android.view.View
    public final boolean onTouchEvent(MotionEvent r8) {
        if (r8.getAction() != 0) goto L6;
        this.f1124p = pointToPosition((int) r8.getX(), (int) r8.getY());
    L6:
        f r10 = this.f1130v;
        if (r10 == null) goto L10;
        e0 r11 = r10.f1137a;
        r11.f1130v = null;
        r11.removeCallbacks(r10);
    L10:
        return super.onTouchEvent(r8);
    }

    public void setListSelectionHidden(boolean r8) {
        this.f1126r = r8;
    }

    @Override // android.widget.AbsListView
    public void setSelector(Drawable r8) {
        if (r8 == null) goto L4;
        d r10 = new d(r8);
    L5:
        this.f1125q = r10;
        super.setSelector(r10);
        Rect r11 = new Rect();
        if (r8 == null) goto L8;
        r8.getPadding(r11);
    L8:
        this.f1120b = r11.left;
        this.f1121m = r11.top;
        this.f1122n = r11.right;
        this.f1123o = r11.bottom;
        return;
    L4:
        r10 = null;
        goto L5
    }
}
