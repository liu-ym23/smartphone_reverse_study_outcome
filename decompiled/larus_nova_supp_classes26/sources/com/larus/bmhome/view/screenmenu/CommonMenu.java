package com.larus.bmhome.view.screenmenu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.content.ContextCompat;
import com.larus.bmhome.view.screenmenu.widget.MaxWidthLinearLayout;
import com.larus.bmhome.view.screenmenu.widget.MenuStyle;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u001a\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u000e\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\nJ\u000e\u0010!\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020\nJ\u0010\u0010#\u001a\u00020\u00002\b\u0010$\u001a\u0004\u0018\u00010\u0019J\u0006\u0010%\u001a\u00020\u0000J\u001e\u0010&\u001a\u00020\u00002\u000e\u0010'\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00110\u00102\u0006\u0010(\u001a\u00020\u0012J\u000e\u0010)\u001a\u00020\u00172\u0006\u0010*\u001a\u00020\u0011J*\u0010+\u001a\u00020\u00002\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00110-2\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00170\u0016H\u0007J\u000e\u0010/\u001a\u00020\u00002\u0006\u00100\u001a\u00020\nJ\u0006\u00101\u001a\u00020\u001bJ;\u00102\u001a\u00020\u001b2\n\b\u0002\u00103\u001a\u0004\u0018\u00010\n2\n\b\u0002\u00104\u001a\u0004\u0018\u00010\n2\n\b\u0002\u00105\u001a\u0004\u0018\u00010\n2\n\b\u0002\u00106\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u00107J\u000e\u00108\u001a\u00020\u00172\u0006\u00109\u001a\u00020:J\n\u0010;\u001a\u0004\u0018\u00010\u0019H\u0002J\b\u0010<\u001a\u00020\u0017H\u0002J\b\u0010=\u001a\u00020\u0017H\u0002J\u0013\u0010>\u001a\u0004\u0018\u00010\u001b2\u0006\u0010?\u001a\u00020\nH\u0086\u0002R\u000e\u0010\f\u001a\u00020\rX\u0082D¢\u0006\u0002\n\u0000R\"\u0010\u000e\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00110\u0010\u0012\u0004\u0012\u00020\u00120\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00110\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006@"}, d2 = {"Lcom/larus/bmhome/view/screenmenu/CommonMenu;", "Lcom/larus/bmhome/view/screenmenu/widget/MaxWidthLinearLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "menuHandler", "", "Lkotlin/reflect/KClass;", "Lcom/larus/bmhome/view/screenmenu/abs/IMenuItem;", "Lcom/larus/bmhome/view/screenmenu/abs/IMenuItemHandler;", "menuItems", "", "itemClickListener", "Lkotlin/Function1;", "", "divideItemDrawable", "Landroid/graphics/drawable/Drawable;", "maskView", "Landroid/view/View;", "wrapperPadding", "dividerHorizontalMargin", "init", "contentWidthFixed", "fixedWidth", "setDividerHorizontalMargin", "marginPx", "applyItemDividerDrawable", "drawable", "contentWidthAdaptive", "support", "kClass", "handler", "update", "item", "prepare", "items", "", "listener", "setWrapperPadding", "padding", MenuStyle.MENU_STYLE_WRAP, "wrapWithPadding", "left", "top", "right", "bottom", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Landroid/view/View;", "setMaskView", "visible", "", "ensureDivideDrawable", "addDivider", "tryRemovePreDivider", "get", "id", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommonMenu extends MaxWidthLinearLayout {
    public static final /* synthetic */ int j = 0;
    public final String b;
    public final Map<KClass<? extends ot8.a>, ot8.b> c;
    public final List<ot8.a> d;
    public Function1<? super ot8.a, Unit> e;
    public Drawable f;
    public View g;
    public int h;
    public int i;

    /* JADX WARN: Multi-variable type inference failed */
    public final View i() {
        FrameLayout r0 = new FrameLayout(getContext());
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        r0.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));     // Catch: Throwable -> L5
        r0.addView(this);     // Catch: Throwable -> L5
        r0.setBackgroundResource(2131238838);     // Catch: Throwable -> L5
        int r2 = this.h;     // Catch: Throwable -> L5
        r0.setPadding(r2, r2, r2, r2);     // Catch: Throwable -> L5
        Object r3 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r4 = Result.exceptionOrNull-impl(r3);
        if (r4 == null) goto L10;
        FLogger.a.i(this.b, r4.toString());
    L10:
        return r0;
    L5:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public CommonMenu(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.b = "CommonMenu";
        this.c = new LinkedHashMap();
        this.d = new ArrayList();
        this.e = new f();
        this.h = i5.Q();
        f(r2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void d(int r3) {
        ViewGroup.LayoutParams r0 = getLayoutParams();
        if (r0.width == r3) goto L6;
        r0.width = r3;
        setLayoutParams(r0);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final View e(int r1) {
        return findViewById(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setMaskView(boolean r5) {
        ViewParent r0 = getParent();
        if ((r0 instanceof FrameLayout) == false) goto L5;
        FrameLayout r1 = (FrameLayout) r0;
    L6:
        if (r1 == null) goto L19;
        r1.setClickable(r5);
        if (r5 == true) goto L10;
        View r6 = this.g;
        if (r6 == null) goto L22;
        com.larus.utils.e1.o(r6);
        return;
    L22:
        return;
    L10:
        if (this.g != null) goto L12;
        View r7 = new View(getContext());
        r7.setLayoutParams(new FrameLayout.LayoutParams(getWidth(), getHeight()));
        r7.setBackgroundResource(v19.c.b(2130971607, r7.getContext(), 2131240710));
        r7.setAlpha(0.5f);
        r7.setClickable(true);
        this.g = r7;
        r1.addView(r7);
    L12:
        View r8 = this.g;
        if (r8 == null) goto L20;
        com.larus.utils.e1.x(r8);
        return;
    L20:
        return;
    L19:
        return;
    L5:
        r1 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void update(ot8.a r4) {
        Intrinsics.checkNotNullParameter(r4, "item");
        View r0 = findViewById(r4.getId());
        if (r0 != null) goto L5;
        return;
    L5:
        ot8.b r1 = this.c.get(Reflection.getOrCreateKotlinClass(r4.getClass()));
        if (r1 != null) goto L8;
        return;
    L8:
        Function1<? super ot8.a, Unit> r2 = this.e;
        r1.update(r4, r0);
        r1.b(this, r4, r0, r2);
    }

    public CommonMenu(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.b = "CommonMenu";
        this.c = new LinkedHashMap();
        this.d = new ArrayList();
        this.e = new f();
        this.h = i5.Q();
        f(r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void f(Context r4, AttributeSet r5) {
        setOrientation(1);
        setLayoutParams(new LinearLayoutCompat.LayoutParams(i5.F(), -2));
        setBackgroundResource(v19.c.b(2130970627, r4, 2131238879));
        this.f = ContextCompat.getDrawable(r4, v19.c.b(2130970952, r4, 2131240110));
        h(Reflection.getOrCreateKotlinClass(l0.class), new q0());
        if (com.larus.utils.i.h(r4) == false) goto L6;
        setLayoutDirection(1);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated(message = "remember to use wrap() to be wrapped in a background view")
    public final void g(List r10, Function1 r11) {
        Intrinsics.checkNotNullParameter(r10, "items");
        Intrinsics.checkNotNullParameter(r11, "listener");
        removeAllViews();
        if (Intrinsics.areEqual(this.d, r10) == true) goto L6;
        ((ArrayList) this.d).clear();
        ((ArrayList) this.d).addAll(r10);
    L6:
        if (Intrinsics.areEqual(this.e, r11) == true) goto L8;
        this.e = r11;
    L8:
        int r0 = r10.size();
        Iterator r12 = r10.iterator();
        int r2 = 0;
    L10:
        if (r12.hasNext() == false) goto L53;
        Object r3 = r12.next();
        int r4 = r2 + 1;
        if (r2 >= 0) goto L14;
        CollectionsKt.throwIndexOverflow();
    L14:
        ot8.a r5 = (ot8.a) r3;
        ot8.b r6 = (ot8.b) ((LinkedHashMap) this.c).get(Reflection.getOrCreateKotlinClass(r5.getClass()));
        if (r6 == null) goto L52;
        View r7 = r6.a(this, r2, r0, r5);
        r6.b(this, r5, r7, r11);
        if (r7 == null) goto L52;
        int r8 = r5.getId();
        if (r8 == 0) goto L22;
        r7.setId(r8);
    L22:
        if (r5.a() == false) goto L39;
        int r9 = getChildCount();
        if (r9 <= 0) goto L39;
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L28
        Object r14 = Result.constructor-impl(getChildAt(r9 - 1));     // Catch: Throwable -> L28
    L31:
        if (Result.isFailure-impl(r14) == false) goto L33;
        r14 = null;
    L33:
        View r15 = (View) r14;
        if (r15 == null) goto L39;
        if ((r15 instanceof Divider) == false) goto L39;
        removeView(r15);
    L28:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
    L39:
        addView(r7);
        if (r5.a() == true) goto L52;
        if (r2 == (r0 - 1)) goto L52;
        Drawable r17 = this.f;
        if (r17 != null) goto L46;
        r17 = ContextCompat.getDrawable(getContext(), v19.c.b(2130970952, getContext(), 2131240110));
    L46:
        if (r17 == null) goto L52;
        int r18 = r17.getIntrinsicHeight();
        Divider r19 = new Divider(getContext(), null, 6, 0);
        r19.setBackground(r17);
        LinearLayoutCompat.LayoutParams r20 = new LinearLayoutCompat.LayoutParams(-1, r18);
        int r21 = this.i;
        if (r21 <= 0) goto L51;
        r20.setMargins(r21, 0, r21, 0);
    L51:
        addView(r19, r20);
    L52:
        r2 = r4;
        goto L10
    }

    public final void h(KClass r2, ot8.b r3) {
        Intrinsics.checkNotNullParameter(r2, "kClass");
        Intrinsics.checkNotNullParameter(r3, "handler");
        this.c.put(r2, r3);
        if ((!this.d.isEmpty()) == false) goto L6;
        g(this.d, this.e);
        return;
    }

    public CommonMenu(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.b = "CommonMenu";
        this.c = new LinkedHashMap();
        this.d = new ArrayList();
        this.e = new f();
        this.h = i5.Q();
        f(r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static View j(CommonMenu r2, Integer r3, Integer r4, Integer r5, int r6) {
        if ((r6 & 1) == 0) goto L6;
        r3 = null;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = null;
    L9:
        if ((r6 & 8) == 0) goto L11;
        r5 = null;
    L11:
        FrameLayout r7 = new FrameLayout(r2.getContext());
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L25
        r7.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));     // Catch: Throwable -> L25
        r7.addView(r2);     // Catch: Throwable -> L25
        r7.setBackgroundResource(2131238838);     // Catch: Throwable -> L25
        if (r3 == null) goto L15;
        int r8 = r3.intValue();     // Catch: Throwable -> L25
    L16:
        int r1 = r2.h;     // Catch: Throwable -> L25
        if (r4 == null) goto L19;
        int r9 = r4.intValue();     // Catch: Throwable -> L25
    L20:
        if (r5 == null) goto L22;
        int r10 = r5.intValue();     // Catch: Throwable -> L25
    L23:
        r7.setPadding(r8, r1, r9, r10);     // Catch: Throwable -> L25
        Object r11 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L25
    L27:
        Throwable r12 = Result.exceptionOrNull-impl(r11);
        if (r12 == null) goto L30;
        FLogger.a.i(r2.b, r12.toString());
    L30:
        return r7;
    L22:
        r10 = r2.h;     // Catch: Throwable -> L25
        goto L23
    L19:
        r9 = r1;
        goto L20
    L15:
        r8 = r2.h;     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L27
    }
}
