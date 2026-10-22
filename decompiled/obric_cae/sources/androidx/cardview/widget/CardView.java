package androidx.cardview.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import m.b;

/* JADX INFO: loaded from: classes.dex */
public class CardView extends FrameLayout {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int[] f1332p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final l6.a f1333q = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f1334a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f1335b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Rect f1336m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Rect f1337n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final a f1338o;

    public class a implements m.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Drawable f1339a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CardView f1340b;

        public a(CardView r8) {
            this.f1340b = r8;
        }

        public final void a(int r8, int r10, int r11, int r12) {
            CardView r13 = this.f1340b;
            r13.f1337n.set(r8, r10, r11, r12);
            Rect r14 = r13.f1336m;
            CardView.c(r13, r8 + r14.left, r10 + r14.top, r11 + r14.right, r12 + r14.bottom);
        }
    }

    static {
        f1332p = new int[]{R.attr.colorBackground};
        f1333q = new l6.a();
    }

    public CardView(Context r8, AttributeSet r10) {
        this(r8, r10, com.obric.cae.R.attr.cardViewStyle);
    }

    public static /* synthetic */ void c(CardView r8, int r10, int r11, int r12, int r13) {
        super.setPadding(r10, r11, r12, r13);
    }

    public ColorStateList getCardBackgroundColor() {
        return ((b) this.f1338o.f1339a).f9239h;
    }

    public float getCardElevation() {
        return this.f1338o.f1340b.getElevation();
    }

    public int getContentPaddingBottom() {
        return this.f1336m.bottom;
    }

    public int getContentPaddingLeft() {
        return this.f1336m.left;
    }

    public int getContentPaddingRight() {
        return this.f1336m.right;
    }

    public int getContentPaddingTop() {
        return this.f1336m.top;
    }

    public float getMaxCardElevation() {
        return ((b) this.f1338o.f1339a).f9236e;
    }

    public boolean getPreventCornerOverlap() {
        return this.f1335b;
    }

    public float getRadius() {
        return ((b) this.f1338o.f1339a).f9232a;
    }

    public boolean getUseCompatPadding() {
        return this.f1334a;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int r8, int r10) {
        super.onMeasure(r8, r10);
    }

    public void setCardBackgroundColor(int r8) {
        ColorStateList r10 = ColorStateList.valueOf(r8);
        b r11 = (b) this.f1338o.f1339a;
        r11.b(r10);
        r11.invalidateSelf();
    }

    public void setCardElevation(float r8) {
        this.f1338o.f1340b.setElevation(r8);
    }

    public void setMaxCardElevation(float r8) {
        f1333q.L0(this.f1338o, r8);
    }

    @Override // android.view.View
    public void setMinimumHeight(int r8) {
        super.setMinimumHeight(r8);
    }

    @Override // android.view.View
    public void setMinimumWidth(int r8) {
        super.setMinimumWidth(r8);
    }

    @Override // android.view.View
    public final void setPadding(int r8, int r10, int r11, int r12) {
    }

    @Override // android.view.View
    public final void setPaddingRelative(int r8, int r10, int r11, int r12) {
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void setPreventCornerOverlap(boolean r8) {
        if (r8 == this.f1335b) goto L6;
        this.f1335b = r8;
        l6.a r10 = f1333q;
        a r11 = this.f1338o;
        r10.L0(r11, ((b) r11.f1339a).f9236e);
        return;
    }

    public void setRadius(float r8) {
        b r10 = (b) this.f1338o.f1339a;
        if (r8 == r10.f9232a) goto L7;
        r10.f9232a = r8;
        r10.c(null);
        r10.invalidateSelf();
        return;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void setUseCompatPadding(boolean r8) {
        if (this.f1334a == r8) goto L6;
        this.f1334a = r8;
        l6.a r10 = f1333q;
        a r11 = this.f1338o;
        r10.L0(r11, ((b) r11.f1339a).f9236e);
        return;
    }

    public CardView(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
        Rect r8 = new Rect();
        this.f1336m = r8;
        this.f1337n = new Rect();
        a r13 = new a(this);
        this.f1338o = r13;
        TypedArray r14 = r10.obtainStyledAttributes(r11, l.a.f9125a, r12, com.obric.cae.R.style.CardView);
        if (r14.hasValue(2) == false) goto L5;
        ColorStateList r15 = r14.getColorStateList(2);
    L10:
        float r16 = r14.getDimension(3, 0.0f);
        float r17 = r14.getDimension(4, 0.0f);
        float r18 = r14.getDimension(5, 0.0f);
        this.f1334a = r14.getBoolean(7, false);
        this.f1335b = r14.getBoolean(6, true);
        int r19 = r14.getDimensionPixelSize(8, 0);
        r8.left = r14.getDimensionPixelSize(10, r19);
        r8.top = r14.getDimensionPixelSize(12, r19);
        r8.right = r14.getDimensionPixelSize(11, r19);
        r8.bottom = r14.getDimensionPixelSize(9, r19);
        if (r17 <= r18) goto L13;
        r18 = r17;
    L13:
        r14.getDimensionPixelSize(0, 0);
        r14.getDimensionPixelSize(1, 0);
        r14.recycle();
        l6.a r20 = f1333q;
        b r21 = new b(r16, r15);
        r13.f1339a = r21;
        setBackgroundDrawable(r21);
        setClipToOutline(true);
        setElevation(r17);
        r20.L0(r13, r18);
        return;
    L5:
        TypedArray r110 = getContext().obtainStyledAttributes(f1332p);
        int r22 = r110.getColor(0, 0);
        r110.recycle();
        float[] r111 = new float[3];
        Color.colorToHSV(r22, r111);
        if (r111[2] <= 0.5f) goto L8;
        Resources r112 = getResources();
        int r113 = com.obric.cae.R.color.cardview_light_background;
    L9:
        r15 = ColorStateList.valueOf(r112.getColor(r113));
        goto L10
    L8:
        r112 = getResources();
        r113 = com.obric.cae.R.color.cardview_dark_background;
        goto L9
    }

    public void setCardBackgroundColor(ColorStateList r8) {
        b r10 = (b) this.f1338o.f1339a;
        r10.b(r8);
        r10.invalidateSelf();
    }
}
