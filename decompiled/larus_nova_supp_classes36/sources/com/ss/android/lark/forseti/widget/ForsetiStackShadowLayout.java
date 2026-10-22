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
import com.larksuite.component.universe_design.shadow.UDShadowLayout;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0014J0\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001cH\u0014J\u000e\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u00020\u0010R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/ss/android/lark/forseti/widget/ForsetiStackShadowLayout;", "Lcom/larksuite/component/universe_design/shadow/UDShadowLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "roundRectPath", "Landroid/graphics/Path;", "rectPath", "pathPaint", "Landroid/graphics/Paint;", "roundCorner", "", "isHalfDisplay", "", "drawChild", "canvas", "Landroid/graphics/Canvas;", "child", "Landroid/view/View;", "drawingTime", "", "onLayout", "", "changed", "l", "", "t", "r", "b", "setIsHalfDisplay", "isHalf", "forseti_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class ForsetiStackShadowLayout extends UDShadowLayout {
    public final Path h;
    public final Path i;
    public final Paint j;
    public final float k;
    public boolean l;

    public static final class a implements OnApplyWindowInsetsListener {
        public final /* synthetic */ ForsetiStackShadowLayout a;

        public a(ForsetiStackShadowLayout r1) {
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
            r0.setPadding(r0.getPaddingLeft(), r10.top, r0.getPaddingRight(), r10.bottom);
            View r1 = this.a.getChildAt(1);
            if (r1 == null) goto L8;
            int r2 = Math.max(0, this.a.getMeasuredHeight() - (MathKt.roundToInt(r1.getY()) + r1.getMeasuredHeight()));
        L9:
            Log.i("ForsetiStackShadowLayout", "this.measuredHeight = " + this.a.getMeasuredHeight() + ", theOnlyChild.y = " + r1.getY() + ", theOnlyChild.measuredHeight = " + r1.getMeasuredHeight());
            Insets r3 = r8.getInsets(WindowInsetsCompat.Type.ime());
            WindowInsetsCompat r11 = new WindowInsetsCompat.Builder(r8).setInsets(WindowInsetsCompat.Type.systemBars(), Insets.of(r10.left, 0, r10.right, 0)).setInsets(WindowInsetsCompat.Type.ime(), Insets.of(0, 0, 0, r3.bottom - r2)).build();
            Log.i("ForsetiStackShadowLayout", "onApplyWindowInsets imeInsets = " + r3 + ", childToBottom = " + r2);
            return r11;
        L8:
            r2 = 0;
            goto L9
        }
    }

    public ForsetiStackShadowLayout(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public final void setIsHalfDisplay(boolean r1) {
        this.l = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ForsetiStackShadowLayout(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4);
        this.h = new Path();
        this.i = new Path();
        Paint r5 = new Paint();
        r5.setStyle(Paint.Style.FILL);
        r5.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.j = r5;
        this.k = f.a(r3, 16.0f);
        ViewCompat.setOnApplyWindowInsetsListener(this, new a(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean drawChild(Canvas r8, View r9, long r10) {
        Intrinsics.checkNotNullParameter(r8, "canvas");
        Intrinsics.checkNotNullParameter(r9, "child");
        if (getShadowSize() != UDShadowLayout.Size.NONE) goto L7;
        if (this.l == true) goto L7;
    L11:
        return super/*android.view.ViewGroup*/.drawChild(r8, r9, r10);
    L7:
        if (Intrinsics.areEqual(r9, getChildAt(1)) == false) goto L11;
        Path r0 = this.i;
        int r1 = r8.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null);
        boolean r11 = super/*android.view.ViewGroup*/.drawChild(r8, r9, r10);
        r8.drawPath(r0, this.j);
        r8.restoreToCount(r1);
        return r11;
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
        return;
    L9:
        this.h.reset();
        Path r0 = this.h;
        float r1 = r14.getLeft();
        float r2 = r14.getTop();
        float r3 = r14.getRight();
        float r4 = r14.getBottom();
        float r6 = this.k;
        r0.addRoundRect(r1, r2, r3, r4, r6, r6, Path.Direction.CW);
        this.i.reset();
        float r15 = 1;
        this.i.addRect(-1.0f, -1.0f, r15 + getWidth(), r15 + getHeight(), Path.Direction.CW);
        this.i.op(this.h, Path.Op.DIFFERENCE);
    }
}
