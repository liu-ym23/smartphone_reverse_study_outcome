package com.larus.bmhome.view.menu;

import android.R;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.view.actionbar.custom.c0;
import com.larus.bmhome.view.screenmenu.MenuItemType;
import com.larus.bmhome.view.screenmenu.l0;
import com.larus.bmhome.view.screenmenu.m0;
import com.larus.bmhome.view.screenmenu.widget.MaxWidthLinearLayout;
import com.larus.common_res.common_ui.databinding.LarusCreateMenuItemBtnLayoutBinding;
import com.larus.common_res.common_ui.databinding.LarusCreateMenuItemLayoutBinding;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.utils.e1;
import com.larus.utils.o0;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kt8.b;
import kt8.d;
import kt8.e;
import kt8.g;
import v19.c;
import v19.h;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 A2\u00020\u0001:\u0001AB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u001a\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u0099\u0001\u0010\u001c\u001a\u00020\u00122\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\b\b\u0002\u0010 \u001a\u00020\n2\b\b\u0002\u0010!\u001a\u00020\u00142\b\b\u0002\u0010\"\u001a\u00020\u00142\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010&\u001a\u00020'2\u001e\b\u0002\u0010\u0018\u001a\u0018\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00192\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00170\u0016¢\u0006\u0002\u0010)J\u0018\u0010*\u001a\u00020\u00172\u0006\u0010+\u001a\u00020\n2\b\u0010,\u001a\u0004\u0018\u00010\u001fJ!\u0010-\u001a\u0004\u0018\u00010\n2\b\u0010.\u001a\u0004\u0018\u00010/2\u0006\u00100\u001a\u00020\u0014H\u0002¢\u0006\u0002\u00101J \u00102\u001a\u0002032\u0006\u00104\u001a\u00020\n2\u0006\u00105\u001a\u00020\n2\u0006\u00106\u001a\u000207H\u0002J \u00108\u001a\u00020\u00172\u0006\u00109\u001a\u00020\u00142\u0010\b\u0002\u0010(\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010:J*\u0010;\u001a\u00020\u00172\u0006\u0010+\u001a\u00020\n2\u0006\u0010<\u001a\u00020\u00142\b\b\u0002\u0010=\u001a\u00020\n2\b\b\u0002\u0010>\u001a\u00020\nJ\u000e\u0010?\u001a\u00020\u00172\u0006\u0010@\u001a\u00020\nR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0018\u001a\u0018\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006B"}, d2 = {"Lcom/larus/bmhome/view/menu/CreateMenu;", "Lcom/larus/bmhome/view/screenmenu/widget/MaxWidthLinearLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bindings", "Landroid/util/SparseArray;", "Lcom/larus/common_res/common_ui/databinding/LarusCreateMenuItemLayoutBinding;", "buttonBindings", "Lcom/larus/common_res/common_ui/databinding/LarusCreateMenuItemBtnLayoutBinding;", "maskView", "Landroid/view/View;", "lastIsDarkMode", "", "clickListener", "Lkotlin/Function1;", "", "unEnableListener", "Lkotlin/Function2;", "", "init", "prepare", "items", "", "Lcom/larus/bmhome/view/screenmenu/MenuItem;", "padding", "needMask", "forceDark", "showDividers", "minimumWidth", "maxWidth", "config", "Lcom/larus/bmhome/view/menu/CreateMenu$Companion$MenuItemConfig;", "listener", "(Ljava/util/List;IZZLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/larus/bmhome/view/menu/CreateMenu$Companion$MenuItemConfig;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;)Landroid/view/View;", "updateButtonMenuItem", "id", "menu", "resolveMenuItemColor", "color", "Lcom/larus/bmhome/view/screenmenu/MenuItemColor;", "isDarkMode", "(Lcom/larus/bmhome/view/screenmenu/MenuItemColor;Z)Ljava/lang/Integer;", "buildButtonStateListDrawable", "Landroid/graphics/drawable/StateListDrawable;", "normalColor", "pressedColor", "cornerRadius", "", "setMaskView", "visible", "Lkotlin/Function0;", "setMenuItemLoading", "loading", "loadingDrawableRes", "originalIconRes", "setMiniWidth", "width", "Companion", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreateMenu extends MaxWidthLinearLayout {
    public static final /* synthetic */ int h = 0;
    public final SparseArray<LarusCreateMenuItemLayoutBinding> b;
    public final SparseArray<LarusCreateMenuItemBtnLayoutBinding> c;
    public View d;
    public boolean e;
    public Function1<? super Integer, Unit> f;
    public Function2<? super Integer, ? super String, Unit> g;

    public static final class a {

        /* JADX INFO: renamed from: com.larus.bmhome.view.menu.CreateMenu$a$a, reason: collision with other inner class name */
        public static final class C0051a {
            public final int a;
            public final int b;
            public final int c;
            public final int d;
            public final int e;
            public final int f;
            public final int g;
            public final int h;
            public final int i;
            public final int j;

            public C0051a() {
                this(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1023);
            }

            public final boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if ((r5 instanceof C0051a) == true) goto L8;
                return false;
            L8:
                C0051a r6 = (C0051a) r5;
                if (this.a == r6.a) goto L12;
                return false;
            L12:
                if (this.b == r6.b) goto L15;
                return false;
            L15:
                if (this.c == r6.c) goto L18;
                return false;
            L18:
                if (this.d == r6.d) goto L21;
                return false;
            L21:
                if (this.e == r6.e) goto L24;
                return false;
            L24:
                if (this.f == r6.f) goto L27;
                return false;
            L27:
                if (this.g == r6.g) goto L30;
                return false;
            L30:
                if (this.h == r6.h) goto L33;
                return false;
            L33:
                if (this.i == r6.i) goto L36;
                return false;
            L36:
                if (this.j == r6.j) goto L38;
                return false;
            L38:
                return true;
            }

            public final int hashCode() {
                return (((((((((((((((((this.a * 31) + this.b) * 31) + this.c) * 31) + this.d) * 31) + this.e) * 31) + this.f) * 31) + this.g) * 31) + this.h) * 31) + this.i) * 31) + this.j;
            }

            public final String toString() {
                return "MenuItemConfig(itemPaddingStart=" + this.a + ", itemPaddingEnd=" + this.b + ", itemPaddingTop=" + this.c + ", itemPaddingBottom=" + this.d + ", menuIconSize=" + this.e + ", textIconSize=" + this.f + ", menuTextFontSize=" + this.g + ", menuSubTextFontSize=" + this.h + ", menuTextContainerLeftMargin=" + this.i + ", menuSubTextMaxLines=" + this.j + ')';
            }

            public C0051a(int r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9, int r10) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
                this.d = r4;
                this.e = r5;
                this.f = r6;
                this.g = r7;
                this.h = r8;
                this.i = r9;
                this.j = r10;
            }

            public /* synthetic */ C0051a(int r11, int r12, int r13, int r14, int r15, int r16, int r17, int r18, int r19, int r20, int r21) {
                if ((r21 & 1) == 0) goto L5;
                int r1 = i5.q();
            L7:
                if ((r21 & 2) == 0) goto L9;
                int r2 = i5.q();
            L11:
                if ((r21 & 4) == 0) goto L13;
                int r3 = i5.h();
            L15:
                if ((r21 & 8) == 0) goto L17;
                int r4 = i5.h();
            L19:
                if ((r21 & 16) == 0) goto L21;
                int r5 = i5.q();
            L23:
                if ((r21 & 32) == 0) goto L25;
                int r6 = i5.A();
            L27:
                if ((r21 & 64) == 0) goto L29;
                int r7 = i5.q();
            L31:
                if ((r21 & 128) == 0) goto L33;
                int r8 = i5.k();
            L35:
                if ((r21 & 256) == 0) goto L37;
                int r9 = i5.h();
            L39:
                if ((r21 & 512) == 0) goto L41;
                int r0 = 1;
            L42:
                this(r1, r2, r3, r4, r5, r6, r7, r8, r9, r0);
                return;
            L41:
                r0 = r20;
                goto L42
            L37:
                r9 = r19;
                goto L39
            L33:
                r8 = r18;
                goto L35
            L29:
                r7 = r17;
                goto L31
            L25:
                r6 = r16;
                goto L27
            L21:
                r5 = r15;
                goto L23
            L17:
                r4 = r14;
                goto L19
            L13:
                r3 = r13;
                goto L15
            L9:
                r2 = r12;
                goto L11
            L5:
                r1 = r11;
                goto L7
            }
        }
    }

    static {
    }

    public CreateMenu(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.b = new SparseArray();
        this.c = new SparseArray();
        e(r2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setMiniWidth(int r1) {
        setMinimumWidth(r1);
    }

    public CreateMenu(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.b = new SparseArray();
        this.c = new SparseArray();
        e(r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void e(Context r2, AttributeSet r3) {
        setOrientation(1);
        setBackgroundResource(c.b(2130970627, r2, 2131238879));
        setDividerDrawable(AppCompatResources.getDrawable(r2, c.b(2130970952, r2, 2131240110)));
        setShowDividers(2);
        setMinimumWidth(i5.B());
        setMaxWidth(i5.y0(c.b(2130971356, null, 2131167081)));
        setId(2131392492);
    }

    public final Integer g(m0 r2, boolean r3) {
        Object r0 = null;
        if (r3 == false) goto L6;
        if (r2 == null) goto L8;
        String r4 = r2.a;
    L9:
        if (r4 != null) goto L11;
    L14:
        boolean r5 = true;
    L15:
        if (r5 == false) goto L27;
        return null;
    L27:
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L19
        Object r7 = Result.constructor-impl(Integer.valueOf(Color.parseColor(r4)));     // Catch: Throwable -> L19
    L22:
        if (Result.isFailure-impl(r7) == true) goto L26;
        r0 = r7;
    L26:
        return (Integer) r0;
    L19:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L22
    L11:
        if (r4.length() == 0) goto L14;
        r5 = false;
    L8:
        r4 = null;
        goto L9
    L6:
        if (r2 == null) goto L8;
        r4 = r2.b;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void h(boolean r5, final Function0<Unit> r6) {
        ViewParent r0 = getParent();
        if ((r0 instanceof FrameLayout) == false) goto L5;
        FrameLayout r1 = (FrameLayout) r0;
    L6:
        if (r1 == null) goto L18;
        if (r5 == true) goto L9;
        View r7 = this.d;
        if (r7 == null) goto L21;
        e1.o(r7);
        return;
    L21:
        return;
    L9:
        if (this.d != null) goto L11;
        View r8 = new View(getContext());
        r8.setLayoutParams(new FrameLayout.LayoutParams(getWidth(), getHeight()));
        r8.setBackgroundResource(c.b(2130971607, r8.getContext(), 2131240710));
        r8.setAlpha(0.5f);
        r8.setClickable(true);
        r8.setOnClickListener(new g(r6));
        this.d = r8;
        r1.addView(r8);
    L11:
        View r9 = this.d;
        if (r9 == null) goto L19;
        e1.x(r9);
        return;
    L19:
        return;
    L18:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public CreateMenu(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.b = new SparseArray();
        this.c = new SparseArray();
        e(r2, r3);
    }

    public final StateListDrawable d(int r4, int r5, float r6) {
        GradientDrawable r0 = new GradientDrawable();
        r0.setColor(r4);
        r0.setCornerRadius(r6);
        GradientDrawable r7 = new GradientDrawable();
        r7.setColor(r5);
        r7.setCornerRadius(r6);
        StateListDrawable r8 = new StateListDrawable();
        r8.addState(new int[]{R.attr.state_pressed}, r7);
        r8.addState(new int[0], r0);
        return r8;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [android.view.ViewGroup, androidx.appcompat.widget.LinearLayoutCompat, com.larus.bmhome.view.menu.CreateMenu, com.larus.bmhome.view.screenmenu.widget.MaxWidthLinearLayout] */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [android.view.View, android.view.ViewGroup, android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r0v54 */
    /* JADX WARN: Type inference failed for: r0v58 */
    /* JADX WARN: Type inference failed for: r12v16 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v3, types: [android.view.View, android.view.ViewGroup, com.larus.bmhome.view.menu.CreateMenu] */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r12v7 */
    /* JADX WARN: Type inference failed for: r32v0, types: [android.view.ViewGroup, com.larus.bmhome.view.menu.CreateMenu] */
    /* JADX WARN: Type inference failed for: r4v25, types: [com.larus.bmhome.view.menu.CreateMenu] */
    /* JADX WARN: Type inference failed for: r4v29 */
    /* JADX WARN: Type inference failed for: r4v35 */
    /* JADX WARN: Type inference failed for: r4v4 */
    public static View f(CreateMenu r32, List r33, int r34, boolean r35, Integer r36, Integer r37, a.C0051a r38, c0 r39, Function1 r40, int r41) {
        ?? r0 = r32;
        List r1 = r33;
        if ((r41 & 2) == 0) goto L5;
        int r4 = i5.Q();
    L6:
        int r6 = 0;
        if ((r41 & 8) == 0) goto L9;
        boolean r5 = false;
    L11:
        if ((r41 & 32) == 0) goto L13;
        Integer r7 = null;
    L15:
        if ((r41 & 64) == 0) goto L17;
        Integer r9 = null;
    L19:
        if ((r41 & 128) == 0) goto L21;
        a.C0051a r10 = new a.C0051a(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1023);
    L23:
        if ((r41 & 256) == 0) goto L25;
        final c0 r3 = null;
    L26:
        Intrinsics.checkNotNullParameter(r1, "items");
        Intrinsics.checkNotNullParameter(r10, "config");
        Intrinsics.checkNotNullParameter(r40, "listener");
        r32.removeAllViews();
        r0.b.clear();
        r0.c.clear();
        r0.g = r3;
        r0.f = r40;
        if (r5 == true) goto L32;
        boolean r12 = h.a;
        if (h.b(r32.getContext()) == true) goto L32;
        boolean r13 = false;
    L33:
        r0.e = r13;
        if (r5 == false) goto L36;
        r0.setBackgroundResource(2131238880);
        r0.setDividerDrawable(AppCompatResources.getDrawable(r32.getContext(), 2131240111));
    L36:
        if (r7 == null) goto L38;
        r0.setMinimumWidth(r7.intValue());
    L38:
        if (r9 == null) goto L40;
        r0.setMaxWidth(r9.intValue());
    L40:
        Iterator r8 = r1.iterator();
        ?? r14 = r0;
        final Function1 r15 = r40;
        final c0 r16 = r3;
        int r11 = 0;
        ?? r2 = r0;
    L42:
        if (r8.hasNext() == false) goto L192;
        Object r17 = r8.next();
        int r18 = r11 + 1;
        if (r11 >= 0) goto L46;
        CollectionsKt.throwIndexOverflow();
    L46:
        final l0 r19 = (l0) r17;
        LinearLayout r110 = new LinearLayout(r32.getContext());
        r110.setOrientation(r6);
        Iterator r310 = r8;
        r110.setLayoutParams(new LinearLayoutCompat.LayoutParams(-1, -2));
        int r29 = r4;
        r110.setPadding(r10.a, r10.c, r10.b, r10.d);
        MenuItemType r20 = r19.getType();
        MenuItemType r21 = MenuItemType.BUTTON;
        if (r20 != r21) goto L49;
        int r22 = Math.max(r10.c, r10.d);
        r110.setPadding(r110.getPaddingLeft(), r22, r110.getPaddingRight(), r22);
    L49:
        List r23 = r1;
        if (r23.size() != 1) goto L56;
        Context r24 = r110.getContext();
        if (r5 == false) goto L54;
        int r25 = 2131238931;
    L55:
        Drawable r26 = AppCompatResources.getDrawable(r24, r25);
    L74:
        r110.setBackground(r26);
        r14.addView(r110);
        if (r19.getType() != r21) goto L104;
        LayoutInflater.from(r32.getContext()).inflate(2131561989, r110);
        TextView r27 = (TextView) ViewBindings.findChildViewById(r110, 2131364761);
        if (r27 == null) goto L103;
        LarusCreateMenuItemBtnLayoutBinding r28 = new LarusCreateMenuItemBtnLayoutBinding(r110, r27);
        if (r19.b == 0) goto L81;
        CharSequence r30 = r32.getContext().getText(r19.b);
    L84:
        r27.setText(r30);
        r27.setTextSize(0, r10.g);
        Integer r31 = r14.g(r19.A, r14.e);
        if (r31 == null) goto L91;
        int r42 = r31.intValue();
        Integer r43 = r14.g(r19.C, r14.e);
        if (r43 == null) goto L89;
        r27.setBackground(r14.d(r42, r43.intValue(), r32.getContext().getResources().getDimension(c.b(2130971163, r32.getContext(), 2131166696))));
        goto L91
    L89:
        PorterDuffColorFilter r44 = new PorterDuffColorFilter(r42, PorterDuff.Mode.SRC_IN);
        Drawable r45 = r27.getBackground();
        r45.setColorFilter(r44);
        r27.setBackground(r45);
    L91:
        Integer r46 = r14.g(r19.B, r14.e);
        if (r46 == null) goto L94;
        r27.setTextColor(r46.intValue());
    L94:
        r27.setEnabled(r19.p);
        r27.setOnClickListener(new kt8.a(r19, r15, r16));
        if (r19.p == false) goto L97;
        float r47 = 1.0f;
    L98:
        r27.setAlpha(r47);
        Float r48 = r19.y;
        if (r48 == null) goto L101;
        r27.setAlpha(r48.floatValue());
    L101:
        r14.c.put(r19.a, r28);
        ?? r49 = r2;
    L184:
        r1 = r33;
        r8 = r310;
        r2 = r49;
        r11 = r18;
        r4 = r29;
        r5 = r5;
        r6 = 0;
        r14 = r14;
        goto L42
    L97:
        r47 = 0.5f;
        goto L98
    L81:
        r30 = r19.c;
        if (r30 != null) goto L84;
        r30 = "";
        goto L84
    L103:
        throw new NullPointerException("Missing required view with ID: ".concat(r110.getResources().getResourceName(2131364761)));
    L104:
        r5 = r5;
        LayoutInflater.from(r32.getContext()).inflate(2131561991, r110);
        int r50 = 2131364301;
        SimpleDraweeView r51 = ViewBindings.findChildViewById(r110, 2131364301);
        if (r51 == null) goto L191;
        r50 = 2131364302;
        LinearLayout r52 = (LinearLayout) ViewBindings.findChildViewById(r110, 2131364302);
        if (r52 == null) goto L191;
        r50 = 2131364303;
        AppCompatTextView r53 = ViewBindings.findChildViewById(r110, 2131364303);
        if (r53 == null) goto L191;
        r50 = 2131379912;
        SimpleDraweeView r54 = ViewBindings.findChildViewById(r110, 2131379912);
        if (r54 == null) goto L191;
        r50 = 2131379927;
        AppCompatTextView r55 = ViewBindings.findChildViewById(r110, 2131379927);
        if (r55 == null) goto L191;
        r50 = 2131379929;
        AppCompatTextView r111 = ViewBindings.findChildViewById(r110, 2131379929);
        if (r111 == null) goto L191;
        r50 = 2131379930;
        ConstraintLayout r112 = ViewBindings.findChildViewById(r110, 2131379930);
        if (r112 == null) goto L191;
        r50 = 2131379931;
        SimpleDraweeView r113 = ViewBindings.findChildViewById(r110, 2131379931);
        if (r113 == null) goto L191;
        AppCompatTextView r56 = ViewBindings.findChildViewById(r110, 2131390937);
        if (r56 == null) goto L188;
        FrameLayout r311 = (FrameLayout) ViewBindings.findChildViewById(r110, 2131390938);
        if (r311 == null) goto L187;
        LarusCreateMenuItemLayoutBinding r57 = new LarusCreateMenuItemLayoutBinding(r110, r51, r52, r53, r54, r55, r111, r112, r113, r56, r311);
        if (r19.b == 0) goto L127;
        CharSequence r58 = r32.getContext().getText(r19.b);
    L128:
        r111.setText(r58);
        r111.setTextSize(0, r10.g);
        ViewGroup.LayoutParams r59 = r112.getLayoutParams();
        if (r59 == null) goto L186;
        ViewGroup.MarginLayoutParams r60 = (ViewGroup.MarginLayoutParams) r59;
        r60.setMarginStart(r10.i);
        r112.setLayoutParams(r60);
        if (o0.d(r19.u) == false) goto L137;
        e1.x(r55);
        r55.setText(r19.u);
        r55.setTextSize(0, r10.h);
        r55.setMaxLines(RangesKt.coerceAtLeast(r10.j, 1));
        ViewGroup.LayoutParams r61 = r55.getLayoutParams();
        if (r10.j <= 1) goto L135;
        int r62 = -2;
    L136:
        r61.height = r62;
        r55.setLayoutParams(r61);
    L139:
        if (o0.d(r19.v) == false) goto L145;
        e1.x(r52);
        r53.setText(r19.v);
        if (o0.d(r19.w) == false) goto L143;
        e1.x(r51);
        ImageLoaderKt.v(r57.b, r19.w, "custom_actionbar_icon", null, new b());
    L149:
        Integer r63 = r19.h;
        if (r63 == null) goto L152;
        r54.setImageResource(r63.intValue());
    L152:
        ViewGroup.LayoutParams r64 = r54.getLayoutParams();
        int r65 = r10.e;
        r64.width = r65;
        r64.height = r65;
        if (o0.d(r19.i) == false) goto L155;
        Integer r66 = null;
        ImageLoaderKt.v(r57.c, r19.i, "custom_actionbar_icon", null, new kt8.c());
    L157:
        if (r19.m == null) goto L159;
        e1.x(r113);
        r113.setImageResource(r19.m.intValue());
        ViewGroup.LayoutParams r67 = r113.getLayoutParams();
        int r68 = r10.f;
        r67.width = r68;
        r67.height = r68;
    L160:
        Integer r69 = r19.I;
        if (r69 != null) goto L166;
        Integer r70 = r19.f;
        if (r70 == null) goto L165;
        r69 = Integer.valueOf(ContextCompat.getColor(r32.getContext(), r70.intValue()));
        goto L166
    L165:
        r69 = r66;
    L166:
        if (r69 == null) goto L169;
        int r71 = r69.intValue();
        r111.setTextColor(r71);
        r54.setColorFilter(r71);
        r113.setColorFilter(r71);
    L169:
        if (r19.p == false) goto L171;
        r110.setEnabled(true);
        final Function1 r72 = r40;
        r110.setOnClickListener(new d(r19, r72, r3));
    L177:
        if (r19.p == false) goto L179;
        float r73 = 1.0f;
    L180:
        r110.setAlpha(r73);
        Float r74 = r19.y;
        if (r74 == null) goto L183;
        r110.setAlpha(r74.floatValue());
    L183:
        r49 = r32;
        r49.b.put(r19.a, r57);
        r15 = r72;
        r16 = r3;
        r14 = r49;
        goto L184
    L179:
        r73 = 0.5f;
        goto L180
    L171:
        r72 = r40;
        if (r3 == null) goto L175;
        r110.setOnClickListener(new e(r3, r19));
        goto L177
    L175:
        r110.setEnabled(false);
        goto L177
    L159:
        e1.o(r113);
        goto L160
    L155:
        r66 = null;
        goto L157
    L143:
        e1.o(r51);
        goto L149
    L145:
        if (o0.d(r19.x) == false) goto L147;
        r56.setText(r19.x);
        e1.x(r311);
    L148:
        e1.o(r52);
        goto L149
    L147:
        e1.o(r311);
        goto L148
    L135:
        r62 = i5.A();
        goto L136
    L137:
        e1.o(r55);
        goto L139
    L186:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L127:
        r58 = r19.c;
        goto L128
    L187:
        r50 = 2131390938;
        goto L191
    L188:
        r50 = 2131390937;
    L191:
        throw new NullPointerException("Missing required view with ID: ".concat(r110.getResources().getResourceName(r50)));
    L54:
        r25 = c.b(2130970639, r110.getContext(), 2131238930);
        goto L55
    L56:
        if (r11 != 0) goto L63;
        Context r75 = r110.getContext();
        if (r5 == false) goto L60;
        int r76 = 2131238907;
    L61:
        r26 = AppCompatResources.getDrawable(r75, r76);
        goto L74
    L60:
        r76 = c.b(2130970633, r110.getContext(), 2131238906);
        goto L61
    L63:
        if (r11 != (r23.size() - 1)) goto L69;
        Context r77 = r110.getContext();
        if (r5 == false) goto L67;
        int r78 = 2131238915;
    L68:
        r26 = AppCompatResources.getDrawable(r77, r78);
        goto L74
    L67:
        r78 = c.b(2130970635, r110.getContext(), 2131238914);
        goto L68
    L69:
        Context r79 = r110.getContext();
        if (r5 == false) goto L72;
        int r80 = 2131238923;
    L73:
        r26 = AppCompatResources.getDrawable(r79, r80);
        goto L74
    L72:
        r80 = c.b(2130970637, r110.getContext(), 2131238922);
        goto L73
    L192:
        int r210 = r4;
        ?? r81 = new LinearLayout(r32.getContext());
        r81.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -2));
        r81.addView(r14);
        r81.setBackgroundResource(2131238838);
        r81.setPadding(r210, r210, r210, r210);
        return r81;
    L32:
        r13 = true;
        goto L33
    L25:
        r3 = r39;
        goto L26
    L21:
        r10 = r38;
        goto L23
    L17:
        r9 = r37;
        goto L19
    L13:
        r7 = r36;
        goto L15
    L9:
        r5 = r35;
        goto L11
    L5:
        r4 = r34;
        goto L6
    }
}
