package com.ss.android.lark.forseti.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import cib.f;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.shadow.UDShadowLayout;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 +2\u00020\u0001:\u0001+B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J \u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0014J0\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020%2\u0006\u0010(\u001a\u00020%H\u0014J\u0010\u0010)\u001a\u00020\"2\b\u0010*\u001a\u0004\u0018\u00010\u0018R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/ss/android/lark/forseti/widget/ForsetiPopoverShadowLayout;", "Lcom/larksuite/component/universe_design/shadow/UDShadowLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "roundRectPath", "Landroid/graphics/Path;", "rectPath", "trianglePath", "modifiedTrianglePath", "getModifiedTrianglePath", "()Landroid/graphics/Path;", "modifiedTrianglePath$delegate", "Lkotlin/Lazy;", "pathPaint", "Landroid/graphics/Paint;", "roundCorner", "", "debugPaint", "bgPaint", "popoverPosition", "Lcom/ss/android/lark/forseti/widget/bean/PopoverPosition;", "drawChild", "", "canvas", "Landroid/graphics/Canvas;", "child", "Landroid/view/View;", "drawingTime", "", "onLayout", "", "changed", "l", "", "t", "r", "b", "setPopoverPosition", "position", "Companion", "forseti_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class ForsetiPopoverShadowLayout extends UDShadowLayout {
    public final Path h;
    public final Path i;
    public final Path j;
    public final Lazy k;
    public final Paint l;
    public final float m;

    public static final class a implements OnApplyWindowInsetsListener {
        public final /* synthetic */ ForsetiPopoverShadowLayout a;

        public a(ForsetiPopoverShadowLayout r1) {
            this.a = r1;
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
        public final WindowInsetsCompat onApplyWindowInsets(View r7, WindowInsetsCompat r8) {
            Intrinsics.checkNotNullParameter(r7, "<unused var>");
            Intrinsics.checkNotNullParameter(r8, "insets");
            if (this.a.getShadowSize() != UDShadowLayout.Size.NONE) goto L5;
            UDShadowLayout r9 = this.a;
            r9.setPadding(r9.getPaddingLeft(), 0, r9.getPaddingRight(), 0);
            return new WindowInsetsCompat.Builder(r8).build();
        L5:
            Insets r10 = r8.getInsets(WindowInsetsCompat.Type.systemBars());
            UDShadowLayout r0 = this.a;
            int r2 = r10.top;
            int r3 = r10.bottom;
            r0.setPadding(r0.getPaddingLeft(), r2, r0.getPaddingRight(), r3);
            View r1 = this.a.getChildAt(1);
            if (r1 == null) goto L8;
            int r4 = Math.max(0, this.a.getMeasuredHeight() - (MathKt.roundToInt(r1.getY()) + r1.getMeasuredHeight()));
        L9:
            StringBuilder r5 = new StringBuilder("this.measuredHeight = ");
            r5.append(this.a.getMeasuredHeight());
            r5.append(", theOnlyChild.y = ");
            if (r1 == null) goto L12;
            Object r6 = Float.valueOf(r1.getY());
        L13:
            r5.append(r6);
            r5.append(", theOnlyChild.measuredHeight = ");
            if (r1 == null) goto L16;
            int r11 = r1.getMeasuredHeight();
        L17:
            r5.append(r11);
            Log.i("ForsetiPopoverShadowLayout", r5.toString());
            Insets r12 = r8.getInsets(WindowInsetsCompat.Type.ime());
            return new WindowInsetsCompat.Builder(r8).setInsets(WindowInsetsCompat.Type.systemBars(), Insets.of(r10.left, 0, r10.right, 0)).setInsets(WindowInsetsCompat.Type.ime(), Insets.of(0, 0, 0, r12.bottom - r4)).build();
        L16:
            r11 = 0;
            goto L17
        L12:
            r6 = 0;
            goto L13
        L8:
            r4 = 0;
            goto L9
        }
    }

    public static final class b {
    }

    static {
    }

    public final void setPopoverPosition(dib.a r1) {
    }

    private final Path getModifiedTrianglePath() {
        return (Path) this.k.getValue();
    }

    public ForsetiPopoverShadowLayout(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ForsetiPopoverShadowLayout(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4);
        this.h = new Path();
        this.i = new Path();
        this.j = new Path();
        this.k = LazyKt.lazy(ForsetiPopoverShadowLayout$modifiedTrianglePath$2.INSTANCE);
        Paint r5 = new Paint();
        r5.setStyle(Paint.Style.FILL);
        r5.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.l = r5;
        this.m = f.a(r3, 10.0f);
        Paint r6 = new Paint();
        r6.setColor(UDColorUtils.getColor(r3, 2131101113));
        r6.setStyle(Paint.Style.FILL);
        Paint r7 = new Paint();
        r7.setColor(UDColorUtils.getColor(r3, 2131100545));
        r7.setStyle(Paint.Style.FILL);
        ViewCompat.setOnApplyWindowInsetsListener(this, new a(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean drawChild(Canvas r8, View r9, long r10) {
        Intrinsics.checkNotNullParameter(r8, "canvas");
        Intrinsics.checkNotNullParameter(r9, "child");
        if (getShadowSize() == UDShadowLayout.Size.NONE) goto L9;
        if (Intrinsics.areEqual(r9, getChildAt(1)) == false) goto L9;
        Path r0 = this.i;
        int r1 = r8.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null);
        boolean r11 = super/*android.view.ViewGroup*/.drawChild(r8, r9, r10);
        r8.drawPath(r0, this.l);
        r8.restoreToCount(r1);
        return r11;
    L9:
        return super/*android.view.ViewGroup*/.drawChild(r8, r9, r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onLayout(boolean r9, int r10, int r11, int r12, int r13) {
        super.onLayout(r9, r10, r11, r12, r13);
        if (r9 == true) goto L5;
        return;
    L5:
        View r14 = getChildAt(1);
        if (r14 != null) goto L9;
        this.h.reset();
        this.i.reset();
        this.j.reset();
        getModifiedTrianglePath().reset();
        return;
    L9:
        this.h.reset();
        Path r0 = this.h;
        float r1 = r14.getLeft();
        float r2 = r14.getTop();
        float r3 = r14.getRight();
        float r4 = r14.getBottom();
        float r6 = this.m;
        r0.addRoundRect(r1, r2, r3, r4, r6, r6, Path.Direction.CW);
        this.i.reset();
        float r15 = 1;
        this.i.addRect(-1.0f, -1.0f, r15 + getWidth(), r15 + getHeight(), Path.Direction.CW);
        this.i.op(this.h, Path.Op.DIFFERENCE);
    }
}
