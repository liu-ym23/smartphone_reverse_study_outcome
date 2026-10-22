package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.obric.cae.R;

/* JADX INFO: loaded from: classes.dex */
public abstract class a extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0006a f1088a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f1089b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ActionMenuView f1090m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ActionMenuPresenter f1091n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f1092o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public j0.h0 f1093p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f1094q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f1095r;

    /* JADX INFO: renamed from: androidx.appcompat.widget.a$a, reason: collision with other inner class name */
    public class C0006a implements j0.i0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f1096a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f1097b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ a f1098c;

        public C0006a(a r8) {
            this.f1098c = r8;
            this.f1096a = false;
        }

        @Override // j0.i0
        public final void a(View r8) {
            this.f1096a = true;
        }

        public final void b(j0.h0 r8, int r10) {
            this.f1098c.f1093p = r8;
            this.f1097b = r10;
        }

        @Override // j0.i0
        public final void c() {
            a.a(this.f1098c);
            this.f1096a = false;
        }

        @Override // j0.i0
        public final void d() {
            if (this.f1096a == false) goto L5;
            return;
        L5:
            a r8 = this.f1098c;
            r8.f1093p = null;
            a.b(r8, this.f1097b);
        }
    }

    public a(Context r8, AttributeSet r10) {
        this(r8, r10, 0);
    }

    public static /* synthetic */ void a(a r8) {
        super.setVisibility(0);
    }

    public static /* synthetic */ void b(a r8, int r10) {
        super.setVisibility(r10);
    }

    public static int c(View r8, int r10, int r11) {
        r8.measure(View.MeasureSpec.makeMeasureSpec(r10, Integer.MIN_VALUE), r11);
        return Math.max(0, (r10 - r8.getMeasuredWidth()) - 0);
    }

    public static int d(int r8, int r10, int r11, View r12, boolean r13) {
        int r14 = r12.getMeasuredWidth();
        int r15 = r12.getMeasuredHeight();
        int r16 = ((r11 - r15) / 2) + r10;
        if (r13 == false) goto L5;
        r12.layout(r8 - r14, r16, r8, r15 + r16);
    L6:
        if (r13 == true) goto L8;
        return r14;
    L8:
        return -r14;
    L5:
        r12.layout(r8, r16, r8 + r14, r15 + r16);
        goto L6
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final j0.h0 e(int r8, long r10) {
        j0.h0 r11 = this.f1093p;
        if (r11 == null) goto L6;
        r11.b();
    L6:
        if (r8 == 0) goto L8;
        float r12 = 0.0f;
        j0.h0 r13 = j0.w.a(this);
    L12:
        r13.a(r12);
        r13.c(r10);
        C0006a r14 = this.f1088a;
        r14.b(r13, r8);
        r13.d(r14);
        return r13;
    L8:
        if (getVisibility() == 0) goto L10;
        setAlpha(0.0f);
    L10:
        r12 = 1.0f;
        r13 = j0.w.a(this);
        goto L12
    }

    public int getAnimatedVisibility() {
        if (this.f1093p == null) goto L7;
        return this.f1088a.f1097b;
    L7:
        return getVisibility();
    }

    public int getContentHeight() {
        return this.f1092o;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r8) {
        super.onConfigurationChanged(r8);
        TypedArray r10 = getContext().obtainStyledAttributes(null, c.a.f3215a, R.attr.actionBarStyle, 0);
        setContentHeight(r10.getLayoutDimension(13, 0));
        r10.recycle();
        ActionMenuPresenter r11 = this.f1091n;
        if (r11 == null) goto L8;
        r11.f945z = new g.a(r11.f768b).a();
        androidx.appcompat.view.menu.f r12 = r11.f769m;
        if (r12 == null) goto L9;
        r12.q(true);
        return;
    L9:
        return;
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent r8) {
        int r10 = r8.getActionMasked();
        if (r10 != 9) goto L6;
        this.f1095r = false;
    L6:
        if (this.f1095r == true) goto L12;
        boolean r11 = super.onHoverEvent(r8);
        if (r10 != 9) goto L12;
        if (r11 == true) goto L12;
        this.f1095r = true;
    L12:
        if (r10 != 10) goto L14;
    L15:
        this.f1095r = false;
    L16:
        return true;
    L14:
        if (r10 != 3) goto L16;
        goto L15
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r8) {
        int r10 = r8.getActionMasked();
        if (r10 != 0) goto L6;
        this.f1094q = false;
    L6:
        if (this.f1094q == true) goto L11;
        boolean r11 = super.onTouchEvent(r8);
        if (r10 != 0) goto L11;
        if (r11 == true) goto L11;
        this.f1094q = true;
    L11:
        if (r10 != 1) goto L13;
    L14:
        this.f1094q = false;
    L15:
        return true;
    L13:
        if (r10 != 3) goto L15;
        goto L14
    }

    public void setContentHeight(int r8) {
        this.f1092o = r8;
        requestLayout();
    }

    @Override // android.view.View
    public void setVisibility(int r8) {
        if (r8 == getVisibility()) goto L9;
        j0.h0 r10 = this.f1093p;
        if (r10 == null) goto L7;
        r10.b();
    L7:
        super.setVisibility(r8);
        return;
    }

    public a(Context r8, AttributeSet r10, int r11) {
        super(r8, r10, r11);
        this.f1088a = new C0006a(this);
        TypedValue r12 = new TypedValue();
        if (r8.getTheme().resolveAttribute(R.attr.actionBarPopupTheme, r12, true) == true) goto L5;
    L7:
        this.f1089b = r8;
        return;
    L5:
        if (r12.resourceId == 0) goto L7;
        this.f1089b = new ContextThemeWrapper(r8, r12.resourceId);
    }
}
