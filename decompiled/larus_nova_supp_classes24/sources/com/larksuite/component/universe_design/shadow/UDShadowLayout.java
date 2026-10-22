package com.larksuite.component.universe_design.shadow;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.larksuite.component.universe_design.dimension.UDDimension;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0017\u0018\u00002\u00020\u0001:\u0004PQRSB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bB+\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\rJ\u0010\u00103\u001a\u0002042\b\b\u0001\u00105\u001a\u00020\nJ\u0018\u00106\u001a\u0002042\u0006\u00107\u001a\u00020\n2\u0006\u00108\u001a\u00020\nH\u0014J0\u00109\u001a\u0002042\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\n2\u0006\u0010=\u001a\u00020\n2\u0006\u0010>\u001a\u00020\n2\u0006\u0010?\u001a\u00020\nH\u0014J\u0012\u0010@\u001a\u0002042\b\u0010A\u001a\u0004\u0018\u00010BH\u0016J\u001a\u0010@\u001a\u0002042\b\u0010A\u001a\u0004\u0018\u00010B2\u0006\u0010C\u001a\u00020\nH\u0016J\u001c\u0010@\u001a\u0002042\b\u0010A\u001a\u0004\u0018\u00010B2\b\u0010D\u001a\u0004\u0018\u00010EH\u0016J$\u0010@\u001a\u0002042\b\u0010A\u001a\u0004\u0018\u00010B2\u0006\u0010C\u001a\u00020\n2\b\u0010D\u001a\u0004\u0018\u00010EH\u0016J\"\u0010@\u001a\u0002042\b\u0010A\u001a\u0004\u0018\u00010B2\u0006\u0010F\u001a\u00020\n2\u0006\u0010G\u001a\u00020\nH\u0016J\u0012\u0010H\u001a\u00020I2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020EH\u0014J\b\u0010K\u001a\u00020IH\u0014J\u001a\u0010L\u001a\u0002042\b\u0010M\u001a\u0004\u0018\u00010B2\u0006\u0010C\u001a\u00020\nH\u0002J\"\u0010N\u001a\u0002042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0002J\b\u0010O\u001a\u000204H\u0002R$\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\u0015@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR&\u0010\u001b\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n8\u0006@FX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010!\u001a\u00020 2\u0006\u0010\u000e\u001a\u00020 @FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001b\u0010&\u001a\u00020'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b(\u0010)R\u000e\u0010,\u001a\u00020-X\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010.\u001a\u00060/R\u00020\u00008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b2\u0010+\u001a\u0004\b0\u00101¨\u0006T"}, d2 = {"Lcom/larksuite/component/universe_design/shadow/UDShadowLayout;", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "value", "Lcom/larksuite/component/universe_design/shadow/UDShadowLayout$Size;", "shadowSize", "getShadowSize", "()Lcom/larksuite/component/universe_design/shadow/UDShadowLayout$Size;", "setShadowSize", "(Lcom/larksuite/component/universe_design/shadow/UDShadowLayout$Size;)V", "Lcom/larksuite/component/universe_design/shadow/UDShadowLayout$Direction;", "shadowDirection", "getShadowDirection", "()Lcom/larksuite/component/universe_design/shadow/UDShadowLayout$Direction;", "setShadowDirection", "(Lcom/larksuite/component/universe_design/shadow/UDShadowLayout$Direction;)V", "shadowColor", "getShadowColor", "()I", "setShadowColor", "(I)V", "Lcom/larksuite/component/universe_design/dimension/UDDimension;", "shadowRadius", "getShadowRadius", "()Lcom/larksuite/component/universe_design/dimension/UDDimension;", "setShadowRadius", "(Lcom/larksuite/component/universe_design/dimension/UDDimension;)V", "shadowPaint", "Landroid/graphics/Paint;", "getShadowPaint", "()Landroid/graphics/Paint;", "shadowPaint$delegate", "Lkotlin/Lazy;", "shadowRect", "Landroid/graphics/RectF;", "shadowView", "Lcom/larksuite/component/universe_design/shadow/UDShadowLayout$UDShadowView;", "getShadowView", "()Lcom/larksuite/component/universe_design/shadow/UDShadowLayout$UDShadowView;", "shadowView$delegate", "applyStyle", "", "styleId", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onLayout", "changed", "", "l", "t", "r", "b", "addView", "child", "Landroid/view/View;", "index", "params", "Landroid/view/ViewGroup$LayoutParams;", "width", "height", "generateLayoutParams", "Lcom/larksuite/component/universe_design/shadow/UDShadowLayout$LayoutParams;", "lp", "generateDefaultLayoutParams", "checkChildrenCountBeforeAddView", "view", "applyAttrs", "setUpPaint", "LayoutParams", "Size", "Direction", "UDShadowView", "universe-ui-shadow_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public class UDShadowLayout extends ViewGroup {
    public Size a;
    public Direction b;
    public int c;
    public UDDimension d;
    public final Lazy e;
    public final RectF f;
    public final Lazy g;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0004\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/larksuite/component/universe_design/shadow/UDShadowLayout$Direction;", "", "x", "", "y", "<init>", "(Ljava/lang/String;III)V", "getX$universe_ui_shadow_release", "()I", "getY$universe_ui_shadow_release", "NONE", "UP", "DOWN", "LEFT", "RIGHT", "universe-ui-shadow_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum Direction extends Enum<Direction> {
        public static final Direction DOWN = null;
        public static final Direction LEFT = null;
        public static final Direction NONE = null;
        public static final Direction RIGHT = null;
        public static final Direction UP = null;
        public static final /* synthetic */ Direction[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int x;
        private final int y;

        public static EnumEntries<Direction> getEntries() {
            return b;
        }

        static {
            Direction r0 = new Direction("NONE", 0, 0, 0);
            NONE = r0;
            Direction r1 = new Direction("UP", 1, 0, -1);
            UP = r1;
            Direction r3 = new Direction("DOWN", 2, 0, 1);
            DOWN = r3;
            Direction r6 = new Direction("LEFT", 3, -1, 0);
            LEFT = r6;
            Direction r5 = new Direction("RIGHT", 4, 1, 0);
            RIGHT = r5;
            Direction[] r8 = {r0, r1, r3, r6, r5};
            a = r8;
            b = EnumEntriesKt.enumEntries(r8);
        }

        public static Direction[] values() {
            return (Direction[]) a.clone();
        }

        public final int getX$universe_ui_shadow_release() {
            return this.x;
        }

        public final int getY$universe_ui_shadow_release() {
            return this.y;
        }

        public static Direction valueOf(String r1) {
            return (Direction) r27.a.a(Direction.class, r1);
        }

        public Direction(String r1, int r2, int r3, int r4) {
            super(r1, r2);
            this.x = r3;
            this.y = r4;
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\f\b\u0007\u0018\u0000 +2\u00020\u0001:\u0001+B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0019\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\u000bB\u0011\b\u0016\u0012\u0006\u0010\f\u001a\u00020\u0001¢\u0006\u0004\b\u0006\u0010\rB\u0011\b\u0016\u0012\u0006\u0010\f\u001a\u00020\u000e¢\u0006\u0004\b\u0006\u0010\u000fJ\u001a\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J(\u0010\"\u001a\u00020 2\u0006\u0010#\u001a\u00020\t2\u0006\u0010$\u001a\u00020\t2\u0006\u0010%\u001a\u00020\t2\u0006\u0010&\u001a\u00020\tH\u0016J\u0010\u0010'\u001a\u00020 2\u0006\u0010(\u001a\u00020\tH\u0016J\u0010\u0010)\u001a\u00020 2\u0006\u0010*\u001a\u00020\tH\u0016R\u001a\u0010\u0010\u001a\u00020\u0011X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0011X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u001a\u0010\u0019\u001a\u00020\u0011X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\u001a\u0010\u001c\u001a\u00020\u0011X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0013\"\u0004\b\u001e\u0010\u0015¨\u0006,"}, d2 = {"Lcom/larksuite/component/universe_design/shadow/UDShadowLayout$LayoutParams;", "Landroid/view/ViewGroup$MarginLayoutParams;", "c", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "width", "", "height", "(II)V", "source", "(Landroid/view/ViewGroup$MarginLayoutParams;)V", "Landroid/view/ViewGroup$LayoutParams;", "(Landroid/view/ViewGroup$LayoutParams;)V", "hasLeftMarginSet", "", "getHasLeftMarginSet$universe_ui_shadow_release", "()Z", "setHasLeftMarginSet$universe_ui_shadow_release", "(Z)V", "hasTopMarginSet", "getHasTopMarginSet$universe_ui_shadow_release", "setHasTopMarginSet$universe_ui_shadow_release", "hasRightMarginSet", "getHasRightMarginSet$universe_ui_shadow_release", "setHasRightMarginSet$universe_ui_shadow_release", "hasBottomMarginSet", "getHasBottomMarginSet$universe_ui_shadow_release", "setHasBottomMarginSet$universe_ui_shadow_release", "applyAttrs", "", "context", "setMargins", "left", "top", "right", "bottom", "setMarginStart", "start", "setMarginEnd", "end", "Companion", "universe-ui-shadow_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class LayoutParams extends ViewGroup.MarginLayoutParams {
        public boolean a;
        public boolean b;
        public boolean c;
        public boolean d;

        public static final class a {
        }

        static {
        }

        public LayoutParams(ViewGroup.LayoutParams r2) {
            Intrinsics.checkNotNullParameter(r2, "source");
            super(r2);
        }

        @Override // android.view.ViewGroup.MarginLayoutParams
        public final void setMarginEnd(int r2) {
            super.setMarginEnd(r2);
            if (getLayoutDirection() != 0) goto L5;
            this.c = true;
            return;
        L5:
            this.a = true;
        }

        @Override // android.view.ViewGroup.MarginLayoutParams
        public final void setMarginStart(int r2) {
            super.setMarginStart(r2);
            if (getLayoutDirection() != 0) goto L5;
            this.a = true;
            return;
        L5:
            this.c = true;
        }

        public LayoutParams(Context r4, AttributeSet r5) {
            Intrinsics.checkNotNullParameter(r4, "c");
            super(r4, r5);
            TypedArray r6 = r4.obtainStyledAttributes(r5, new int[]{R.attr.layout_margin, R.attr.layout_marginLeft, R.attr.layout_marginTop, R.attr.layout_marginRight, R.attr.layout_marginBottom, R.attr.layout_marginStart, R.attr.layout_marginEnd, R.attr.layout_marginHorizontal, R.attr.layout_marginVertical});
            if (r6.getDimensionPixelSize(0, -1) < 0) goto L5;
            this.b = true;
            this.a = true;
            this.c = true;
            this.d = true;
        L32:
            r6.recycle();
            return;
        L5:
            int r7 = r6.getDimensionPixelSize(7, -1);
            int r2 = r6.getDimensionPixelSize(8, -1);
            if (r7 < 0) goto L9;
            this.a = true;
            this.c = true;
        L14:
            if (r2 < 0) goto L17;
            this.b = true;
            this.d = true;
            goto L32
        L17:
            if (r6.getDimensionPixelSize(2, -1) < 0) goto L20;
            this.b = true;
        L20:
            if (r6.getDimensionPixelSize(4, -1) < 0) goto L22;
            this.d = true;
        L22:
            int r8 = r6.getDimensionPixelSize(5, -1);
            int r0 = r6.getDimensionPixelSize(6, -1);
            if (getLayoutDirection() != 0) goto L28;
            if (r8 < 0) goto L26;
            this.a = true;
        L26:
            if (r0 < 0) goto L32;
            this.c = true;
            goto L32
        L28:
            if (r8 < 0) goto L30;
            this.c = true;
        L30:
            if (r0 < 0) goto L32;
            this.a = true;
            goto L32
        L9:
            if (r6.getDimensionPixelSize(1, -1) < 0) goto L12;
            this.a = true;
        L12:
            if (r6.getDimensionPixelSize(3, -1) < 0) goto L14;
            this.c = true;
            goto L14
        }

        public LayoutParams(int r1, int r2) {
            super(r1, r2);
        }

        @Override // android.view.ViewGroup.MarginLayoutParams
        public final void setMargins(int r1, int r2, int r3, int r4) {
            super.setMargins(r1, r2, r3, r4);
            this.b = true;
            this.a = true;
            this.c = true;
            this.d = true;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0004\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/larksuite/component/universe_design/shadow/UDShadowLayout$Size;", "", "blur", "Lcom/larksuite/component/universe_design/dimension/UDDimension;", "offset", "<init>", "(Ljava/lang/String;ILcom/larksuite/component/universe_design/dimension/UDDimension;Lcom/larksuite/component/universe_design/dimension/UDDimension;)V", "getBlur$universe_ui_shadow_release", "()Lcom/larksuite/component/universe_design/dimension/UDDimension;", "getOffset$universe_ui_shadow_release", "NONE", "S1", "S2", "S3", "S4", "S5", "S", "M", "L", "universe-ui-shadow_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum Size extends Enum<Size> {

        @Deprecated(message = "pleace replace with S4", replaceWith = @ReplaceWith(expression = "S4", imports = {}))
        public static final Size L = null;

        @Deprecated(message = "pleace replace with S3", replaceWith = @ReplaceWith(expression = "S3", imports = {}))
        public static final Size M = null;
        public static final Size NONE = null;

        @Deprecated(message = "pleace replace with S2", replaceWith = @ReplaceWith(expression = "S2", imports = {}))
        public static final Size S = null;
        public static final Size S1 = null;
        public static final Size S2 = null;
        public static final Size S3 = null;
        public static final Size S4 = null;
        public static final Size S5 = null;
        public static final /* synthetic */ Size[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final UDDimension blur;
        private final UDDimension offset;

        public static EnumEntries<Size> getEntries() {
            return b;
        }

        static {
            Size r0 = new Size("NONE", 0, new UDDimension.Dp(0), new UDDimension.Dp(0));
            NONE = r0;
            Size r1 = new Size("S1", 1, new UDDimension.Dp(4), new UDDimension.Dp(2));
            S1 = r1;
            Size r3 = new Size("S2", 2, new UDDimension.Dp(6), new UDDimension.Dp(2));
            S2 = r3;
            Size r5 = new Size("S3", 3, new UDDimension.Dp(8), new UDDimension.Dp(4));
            S3 = r5;
            Size r9 = new Size("S4", 4, new UDDimension.Dp(16), new UDDimension.Dp(6));
            S4 = r9;
            Size r11 = new Size("S5", 5, new UDDimension.Dp(36), new UDDimension.Dp(8));
            S5 = r11;
            Size r13 = new Size("S", 6, new UDDimension.Dp(6), new UDDimension.Dp(2));
            S = r13;
            Size r8 = new Size("M", 7, new UDDimension.Dp(8), new UDDimension.Dp(4));
            M = r8;
            Size r4 = new Size("L", 8, new UDDimension.Dp(16), new UDDimension.Dp(6));
            L = r4;
            Size[] r12 = {r0, r1, r3, r5, r9, r11, r13, r8, r4};
            a = r12;
            b = EnumEntriesKt.enumEntries(r12);
        }

        public static Size[] values() {
            return (Size[]) a.clone();
        }

        public final UDDimension getBlur$universe_ui_shadow_release() {
            return this.blur;
        }

        public final UDDimension getOffset$universe_ui_shadow_release() {
            return this.offset;
        }

        public static Size valueOf(String r1) {
            return (Size) r27.a.a(Size.class, r1);
        }

        public Size(String r1, int r2, UDDimension.Dp r3, UDDimension.Dp r4) {
            super(r1, r2);
            this.blur = r3;
            this.offset = r4;
        }
    }

    public final class a extends View {
        public final /* synthetic */ UDShadowLayout a;

        @Override // android.view.View
        public final void onDraw(Canvas r4) {
            Intrinsics.checkNotNullParameter(r4, "canvas");
            if (this.a.getChildAt(1) == null) goto L5;
            UDShadowLayout r0 = this.a;
            float r1 = r0.getShadowRadius().toPixels(getContext());
            r4.drawRoundRect(r0.f, r1, r1, UDShadowLayout.a(r0));
        L5:
            super.onDraw(r4);
        }

        public a(UDShadowLayout r2, Context r3) {
            Intrinsics.checkNotNullParameter(r3, "context");
            this.a = r2;
            super(r3);
            if (Build.VERSION.SDK_INT >= 28) goto L6;
            setLayerType(1, null);
            return;
        }
    }

    private final Paint getShadowPaint() {
        return (Paint) this.e.getValue();
    }

    private final a getShadowView() {
        return (a) this.g.getValue();
    }

    public final void e() {
        float r0 = this.a.getBlur$universe_ui_shadow_release().toPixels(getContext());
        float r1 = this.a.getOffset$universe_ui_shadow_release().toPixels(getContext());
        getShadowPaint().setShadowLayer(r0, this.b.getX$universe_ui_shadow_release() * r1, r1 * this.b.getY$universe_ui_shadow_release(), this.c);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    public final int getShadowColor() {
        return this.c;
    }

    public final Direction getShadowDirection() {
        return this.b;
    }

    public final UDDimension getShadowRadius() {
        return this.d;
    }

    public final Size getShadowSize() {
        return this.a;
    }

    public UDShadowLayout(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public static final /* synthetic */ Paint a(UDShadowLayout r0) {
        return r0.getShadowPaint();
    }

    @Override // android.view.ViewGroup
    public final void addView(View r2) {
        d(r2, getChildCount());
        super.addView(r2);
    }

    public final void c(int r3) {
        b(null, 0, r3);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r2) {
        Intrinsics.checkNotNullParameter(r2, "lp");
        return new LayoutParams(r2);
    }

    public final void setShadowColor(int r2) {
        if (r2 == this.c) goto L6;
        this.c = r2;
        e();
        invalidate();
        return;
    }

    public final void setShadowDirection(Direction r2) {
        Intrinsics.checkNotNullParameter(r2, "value");
        if (r2 == this.b) goto L6;
        this.b = r2;
        e();
        requestLayout();
        return;
    }

    public final void setShadowRadius(UDDimension r2) {
        Intrinsics.checkNotNullParameter(r2, "value");
        this.d = r2;
        invalidate();
    }

    public final void setShadowSize(Size r2) {
        Intrinsics.checkNotNullParameter(r2, "value");
        if (r2 == this.a) goto L6;
        this.a = r2;
        e();
        requestLayout();
        return;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet r3) {
        return new LayoutParams(getContext(), r3);
    }

    public UDShadowLayout(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void addView(View r2, ViewGroup.LayoutParams r3) {
        d(r2, getChildCount());
        super.addView(r2, r3);
    }

    public final void d(View r5, int r6) {
        boolean r2 = true;
        if (getChildCount() >= 2) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L18;
        if (r6 != 0) goto L13;
        if (r6 == 0) goto L10;
    L12:
        r2 = false;
        goto L13
    L10:
        if ((r5 instanceof a) == false) goto L12;
    L13:
        if (r2 == false) goto L16;
        return;
    L16:
        throw new IllegalArgumentException("Must not add view at 0 in UDShadowLayout!".toString());
    L18:
        throw new IllegalArgumentException("UDShadowLayout can host only one direct child".toString());
    L5:
        r0 = false;
        goto L6
    }

    @Override // android.view.View
    public final void onMeasure(int r11, int r12) {
        super.onMeasure(r11, r12);
        View r0 = getChildAt(1);
        if (r0 == null) goto L21;
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.larksuite.component.universe_design.shadow.UDShadowLayout.LayoutParams");
        LayoutParams r7 = (LayoutParams) r1;
        float r2 = this.a.getBlur$universe_ui_shadow_release().toPixels(getContext());
        float r3 = this.a.getOffset$universe_ui_shadow_release().toPixels(getContext());
        int r4 = 0;
        if (r7.b == false) goto L7;
        int r5 = 0;
    L8:
        int r6 = r5 + 0;
        if (r7.d == false) goto L11;
        int r8 = 0;
    L12:
        int r9 = r6 + r8;
        if (r7.a == false) goto L15;
        int r10 = 0;
    L16:
        int r13 = r10 + 0;
        if (r7.c == true) goto L20;
        r4 = Math.max(0, (int) (r2 + (r3 * this.b.getX$universe_ui_shadow_release())));
    L20:
        int r14 = r13 + r4;
        measureChildWithMargins(r0, r11, r14, r12, r9);
        setMeasuredDimension(((((r0.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) r7).leftMargin) + ((ViewGroup.MarginLayoutParams) r7).rightMargin) + getPaddingLeft()) + getPaddingRight()) + r14, ((((r0.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) r7).topMargin) + ((ViewGroup.MarginLayoutParams) r7).bottomMargin) + getPaddingTop()) + getPaddingBottom()) + r9);
        goto L21
    L15:
        r10 = Math.max(0, (int) (r2 - (this.b.getX$universe_ui_shadow_release() * r3)));
        goto L16
    L11:
        r8 = Math.max(0, (int) ((this.b.getY$universe_ui_shadow_release() * r3) + r2));
        goto L12
    L7:
        r5 = Math.max(0, (int) (r2 - (this.b.getY$universe_ui_shadow_release() * r3)));
    L21:
        getShadowView().measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
    }

    @Override // android.view.ViewGroup
    public final void addView(View r1, int r2) {
        d(r1, r2);
        super.addView(r1, r2);
    }

    public UDShadowLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, r4, 2131953869);
    }

    @Override // android.view.ViewGroup
    public final void addView(View r2, int r3, int r4) {
        d(r2, getChildCount());
        super.addView(r2, r3, r4);
    }

    public final void b(AttributeSet r3, int r4, int r5) {
        TypedArray r6 = getContext().obtainStyledAttributes(r3, new int[]{2130974941, 2130974942, 2130974943, 2130974944}, r4, r5);
        int r7 = r6.getInt(3, this.a.ordinal());
        setShadowSize(Size.values()[r7]);
        int r8 = r6.getInt(1, this.b.ordinal());
        setShadowDirection(Direction.values()[r8]);
        setShadowColor(r6.getColor(0, this.c));
        setShadowRadius(new UDDimension.a(r6.getDimensionPixelSize(2, (int) this.d.toPixels(getContext()))));
        r6.recycle();
    }

    @Override // android.view.ViewGroup
    public final void addView(View r1, int r2, ViewGroup.LayoutParams r3) {
        d(r1, r2);
        super.addView(r1, r2, r3);
    }

    public UDShadowLayout(Context r4, AttributeSet r5, int r6, int r7) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5, r6, r7);
        this.a = Size.NONE;
        this.b = Direction.NONE;
        this.d = new UDDimension.Dp(0);
        this.e = LazyKt.lazy(UDShadowLayout$shadowPaint$2.INSTANCE);
        this.f = new RectF();
        this.g = LazyKt.lazy(new UDShadowLayout$shadowView$2(this));
        addView(getShadowView(), 0, new LayoutParams(-1, -1));
        e();
        b(r5, r6, r7);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r3, int r4, int r5, int r6, int r7) {
        View r8 = getChildAt(0);
        r8.layout(0, 0, r8.getMeasuredWidth(), r8.getMeasuredHeight());
        View r9 = getChildAt(1);
        if (r9 == null) goto L14;
        ViewGroup.LayoutParams r10 = r9.getLayoutParams();
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type com.larksuite.component.universe_design.shadow.UDShadowLayout.LayoutParams");
        LayoutParams r11 = (LayoutParams) r10;
        float r12 = this.a.getBlur$universe_ui_shadow_release().toPixels(getContext());
        float r13 = this.a.getOffset$universe_ui_shadow_release().toPixels(getContext());
        if (r11.b == false) goto L7;
        int r0 = getPaddingTop();
        int r1 = ((ViewGroup.MarginLayoutParams) r11).topMargin;
    L8:
        int r2 = r0 + r1;
        if (r11.a == false) goto L11;
        int r14 = getPaddingLeft() + ((ViewGroup.MarginLayoutParams) r11).leftMargin;
    L12:
        r9.layout(r14, r2, r9.getMeasuredWidth() + r14, r9.getMeasuredHeight() + r2);
        float r15 = r14;
        float r16 = r2;
        this.f.set(r15, r16, r9.getMeasuredWidth() + r15, r9.getMeasuredHeight() + r16);
        return;
    L11:
        r14 = Math.max(0, (int) (r12 - (r13 * this.b.getX$universe_ui_shadow_release()))) + getPaddingLeft();
        goto L12
    L7:
        r0 = getPaddingTop();
        r1 = Math.max(0, (int) (r12 - (this.b.getY$universe_ui_shadow_release() * r13)));
        goto L8
    }
}
