package com.bytedance.ai.applet.app.view;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.ai.model.objects.Applet;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 G2\u00020\u0001:\u0002GHB\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010(\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\tJ\u0014\u0010)\u001a\u00020\f2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\f0\u000bJ\u0014\u0010+\u001a\u00020\f2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\f0\u000bJ\u0006\u0010,\u001a\u00020\fJ\u0006\u0010-\u001a\u00020.J\u0006\u0010/\u001a\u00020'J\u0006\u00100\u001a\u00020'J\u0006\u00101\u001a\u00020\fJ\u0010\u00102\u001a\u00020\f2\b\b\u0002\u00103\u001a\u000204J\u0012\u00105\u001a\u00020\f2\b\u00106\u001a\u0004\u0018\u000107H\u0014J\b\u00108\u001a\u00020\fH\u0014J\u0010\u00109\u001a\u0002042\u0006\u0010:\u001a\u00020;H\u0016J\u0010\u0010<\u001a\u00020\f2\u0006\u0010=\u001a\u00020>H\u0014J\u0018\u0010?\u001a\u00020\f2\u0006\u0010=\u001a\u00020>2\u0006\u0010@\u001a\u00020\u001fH\u0002J\u001a\u0010A\u001a\u0004\u0018\u00010%2\u0006\u0010B\u001a\u00020\u001f2\u0006\u0010C\u001a\u00020\u001fH\u0002J\u0012\u0010D\u001a\u00020\f2\b\u0010E\u001a\u0004\u0018\u00010%H\u0002J\u0010\u0010F\u001a\u00020\f2\u0006\u0010E\u001a\u00020%H\u0002R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006I"}, d2 = {"Lcom/bytedance/ai/applet/app/view/AppletAppActionBar;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "applet", "Lcom/bytedance/ai/model/objects/Applet;", "onCloseListener", "Lkotlin/Function0;", "", "onOpenListener", "contentView", "Landroid/view/View;", "btnMiniMenu", "btnMiniClose", "ivMiniMenu", "Landroid/widget/ImageView;", "ivMiniClose", "shadowPaint", "Landroid/graphics/Paint;", "shadowClearPaint", "fillPaint", "strokePaint", "bgRect", "Landroid/graphics/RectF;", "shadowLayerRect", "expandedTouchRect", "shadowPaddingPx", "", "shadowRadiusPx", "cornerRadiusPx", "strokeWidthPx", "expandedTouchInsetPx", "activeTouchTarget", "Lcom/bytedance/ai/applet/app/view/AppletAppActionBar$TouchTarget;", "appliedNightMode", "", "setApplet", "setOnCloseListener", "listener", "setOnOpenListener", "release", "getContentViewLocationInWindow", "", "getContentViewWidth", "getContentViewHeight", "initBackground", "refreshTheme", "force", "", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onAttachedToWindow", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "drawOuterShadow", "radius", "findExpandedTouchTarget", "x", "y", "updatePressedState", "target", "performExpandedTouchClick", "Companion", "TouchTarget", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppletAppActionBar extends FrameLayout {
    public static final /* synthetic */ int v = 0;
    public Function0<Unit> a;
    public Function0<Unit> b;
    public final View c;
    public final View d;
    public final View e;
    public final ImageView f;
    public final ImageView g;
    public final Paint h;
    public final Paint i;
    public final Paint j;
    public final Paint k;
    public final RectF l;
    public final RectF m;
    public final RectF n;
    public float o;
    public float p;
    public float q;
    public float r;
    public float s;
    public TouchTarget t;
    public int u;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ai/applet/app/view/AppletAppActionBar$TouchTarget;", "", "<init>", "(Ljava/lang/String;I)V", "MENU", "CLOSE", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum TouchTarget extends Enum<TouchTarget> {
        public static final TouchTarget CLOSE = null;
        public static final TouchTarget MENU = null;
        public static final /* synthetic */ TouchTarget[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<TouchTarget> getEntries() {
            return b;
        }

        static {
            TouchTarget r0 = new TouchTarget("MENU", 0);
            MENU = r0;
            TouchTarget r1 = new TouchTarget("CLOSE", 1);
            CLOSE = r1;
            TouchTarget[] r10 = {r0, r1};
            a = r10;
            b = EnumEntriesKt.enumEntries(r10);
        }

        public static TouchTarget[] values() {
            return (TouchTarget[]) a.clone();
        }

        public static TouchTarget valueOf(String r1) {
            return (TouchTarget) r27.a.a(TouchTarget.class, r1);
        }

        public TouchTarget(String r1, int r10) {
            super(r1, r10);
        }
    }

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[TouchTarget.values().length];
            r0[TouchTarget.MENU.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[TouchTarget.CLOSE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
    }

    public final int[] getContentViewLocationInWindow() {
        int[] r0 = new int[2];
        this.c.getLocationInWindow(r0);
        return r0;
    }

    public final void setApplet(Applet r10) {
        Intrinsics.checkNotNullParameter(r10, "applet");
    }

    public final int getContentViewHeight() {
        return this.c.getHeight();
    }

    public final int getContentViewWidth() {
        return this.c.getWidth();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        a(false);
    }

    public AppletAppActionBar(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        this(r10, null);
    }

    public final void a(boolean r10) {
        int r0 = getResources().getConfiguration().uiMode & 48;     // Catch: Exception -> L9
        if (r10 == false) goto L5;
    L7:
        this.u = r0;     // Catch: Exception -> L9
        int r11 = t2.a.c(getContext(), 2130968820, 2131100389);     // Catch: Exception -> L9
        int r1 = t2.a.c(getContext(), 2130968824, 2131100401);     // Catch: Exception -> L9
        int r12 = t2.a.c(getContext(), 2130968823, 2131100398);     // Catch: Exception -> L9
        int r13 = t2.a.c(getContext(), 2130968821, 2131103681);     // Catch: Exception -> L9
        int r14 = t2.a.c(getContext(), 2130968822, 2131100392);     // Catch: Exception -> L9
        this.h.setStyle(Paint.Style.FILL);     // Catch: Exception -> L9
        this.h.setColor(r12);     // Catch: Exception -> L9
        this.h.setShadowLayer(this.p, 0.0f, 0.0f, r12);     // Catch: Exception -> L9
        this.j.setStyle(Paint.Style.FILL);     // Catch: Exception -> L9
        this.j.setColor(r11);     // Catch: Exception -> L9
        this.k.setStyle(Paint.Style.STROKE);     // Catch: Exception -> L9
        this.k.setColor(r1);     // Catch: Exception -> L9
        this.k.setStrokeWidth(this.r);     // Catch: Exception -> L9
        ColorStateList r15 = new ColorStateList(new int[][]{new int[]{R.attr.state_pressed}, new int[0]}, new int[]{r14, r13});     // Catch: Exception -> L9
        this.f.setImageTintList(r15);     // Catch: Exception -> L9
        this.g.setImageTintList(r15);     // Catch: Exception -> L9
        this.f.setImageResource(2131231714);     // Catch: Exception -> L9
        this.g.setImageResource(2131231711);     // Catch: Exception -> L9
        invalidate();     // Catch: Exception -> L9
        return;
    L5:
        if (r0 != this.u) goto L7;
        return;
    L9:
        e = move-exception;
        com.bytedance.ai.utils.g.a.e("AppletAppActionBar", "refreshTheme error", e);
    }

    public final void b(TouchTarget r10) {
        View r0 = this.d;
        boolean r11 = true;
        if (r10 != TouchTarget.MENU) goto L5;
        boolean r1 = true;
    L6:
        r0.setPressed(r1);
        View r12 = this.e;
        if (r10 == TouchTarget.CLOSE) goto L10;
        r11 = false;
    L10:
        r12.setPressed(r11);
        return;
    L5:
        r1 = false;
        goto L6
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r10) {
        Intrinsics.checkNotNullParameter(r10, "canvas");
        a(false);
        if (getWidth() > 0) goto L5;
    L13:
        super.dispatchDraw(r10);
        return;
    L5:
        if (getHeight() <= 0) goto L13;
        if (this.o <= 0.0f) goto L13;
        if (this.c.getWidth() <= 0) goto L13;
        if (this.c.getHeight() <= 0) goto L13;
        float r0 = this.r / 2.0f;
        this.l.set(this.c.getLeft() + r0, this.c.getTop() + r0, this.c.getRight() - r0, this.c.getBottom() - r0);
        float r1 = Math.min(this.q, Math.min(this.l.width(), this.l.height()) / 2.0f);
        float r11 = this.p + this.r;
        this.m.set(this.l);
        float r12 = -r11;
        this.m.inset(r12, r12);
        int r13 = r10.saveLayer(this.m, null);
        r10.drawRoundRect(this.l, r1, r1, this.h);
        r10.drawRoundRect(this.l, r1, r1, this.i);
        r10.restoreToCount(r13);
        r10.drawRoundRect(this.l, r1, r1, this.j);
        r10.drawRoundRect(this.l, r1, r1, this.k);
        goto L13
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r14) {
        Intrinsics.checkNotNullParameter(r14, "event");
        float r0 = r14.getX();
        float r1 = r14.getY();
        TouchTarget r10 = null;
        if (this.c.getWidth() > 0) goto L5;
    L41:
        TouchTarget r11 = null;
    L42:
        int r12 = r14.getActionMasked();
        if (r12 != 0) goto L45;
        if (r11 == null) goto L81;
        this.t = r11;
        b(r11);
        ViewParent r15 = getParent();
        if (r15 == null) goto L79;
        r15.requestDisallowInterceptTouchEvent(true);
    L79:
        return true;
    L81:
        return super.dispatchTouchEvent(r14);
    L45:
        if (r12 == 1) goto L60;
        if (r12 != 2) goto L48;
        TouchTarget r13 = this.t;
        if (r13 == null) goto L81;
        if (r11 != r13) goto L58;
        r10 = r13;
    L58:
        b(r10);
        return true;
    L48:
        if (r12 != 3) goto L81;
        if (this.t == null) goto L81;
        this.t = null;
        b(null);
        return true;
    L60:
        TouchTarget r16 = this.t;
        if (r16 == null) goto L81;
        if (r11 == r16) goto L65;
        r16 = null;
    L65:
        this.t = null;
        b(null);
        if (r16 == null) goto L74;
        int r17 = b.a[r16.ordinal()];
        if (r17 == 1) goto L73;
        if (r17 != 2) goto L72;
        this.e.performClick();
        goto L74
    L72:
        throw new NoWhenBranchMatchedException();
    L73:
        this.d.performClick();
    L74:
        return true;
    L5:
        if (this.c.getHeight() <= 0) goto L41;
        this.n.set(this.c.getLeft() - this.s, this.c.getTop() - this.s, this.c.getRight() + this.s, this.c.getBottom() + this.s);
        if (this.n.contains(r0, r1) == false) goto L41;
        float r18 = (this.c.getLeft() + this.d.getLeft()) - this.s;
        float r19 = (this.c.getTop() + this.d.getTop()) - this.s;
        float r20 = (this.c.getLeft() + this.d.getRight()) + this.s;
        float r21 = (this.c.getTop() + this.d.getBottom()) + this.s;
        float r22 = (this.c.getLeft() + this.e.getLeft()) - this.s;
        float r23 = (this.c.getTop() + this.e.getTop()) - this.s;
        float r110 = (this.c.getLeft() + this.e.getRight()) + this.s;
        float r111 = (this.c.getTop() + this.e.getBottom()) + this.s;
        boolean r112 = false;
        if (r0 >= r18) goto L13;
    L19:
        boolean r24 = false;
    L21:
        if (r0 >= r22) goto L23;
    L29:
        if (r24 == false) goto L32;
        if (r112 == true) goto L32;
        r11 = TouchTarget.MENU;
    L32:
        if (r112 == false) goto L35;
        if (r24 == true) goto L35;
        r11 = TouchTarget.CLOSE;
    L35:
        if (r24 == false) goto L41;
        if (r112 == false) goto L41;
        float r25 = r0 - ((this.c.getLeft() + this.d.getLeft()) + (this.d.getWidth() / 2.0f));
        float r26 = r0 - ((this.c.getLeft() + this.e.getLeft()) + (this.e.getWidth() / 2.0f));
        if ((r25 * r25) > (r26 * r26)) goto L40;
        r11 = TouchTarget.MENU;
        goto L42
    L40:
        r11 = TouchTarget.CLOSE;
        goto L42
    L23:
        if (r0 > r110) goto L29;
        if (r1 < r23) goto L29;
        if (r1 > r111) goto L29;
        r112 = true;
        goto L29
    L13:
        if (r0 > r20) goto L19;
        if (r1 < r19) goto L19;
        if (r1 > r21) goto L19;
        r24 = true;
        goto L21
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r1) {
        super.onConfigurationChanged(r1);
        a(false);
    }

    public final void setOnCloseListener(Function0<Unit> r10) {
        Intrinsics.checkNotNullParameter(r10, "listener");
        this.a = r10;
    }

    public final void setOnOpenListener(Function0<Unit> r10) {
        Intrinsics.checkNotNullParameter(r10, "listener");
        this.b = r10;
    }

    public AppletAppActionBar(Context r10, AttributeSet r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11);
        this.h = new Paint(1);
        Paint r12 = new Paint(1);
        r12.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.i = r12;
        this.j = new Paint(1);
        this.k = new Paint(1);
        this.l = new RectF();
        this.m = new RectF();
        this.n = new RectF();
        LayoutInflater.from(r10).inflate(2131558712, this, true);
        View r13 = findViewById(2131362055);
        this.c = r13;
        View r14 = findViewById(2131364763);
        this.d = r14;
        View r1 = findViewById(2131364762);
        this.e = r1;
        this.f = (ImageView) findViewById(2131376413);
        this.g = (ImageView) findViewById(2131376412);
        r14.setOnClickListener(new i(this));
        r1.setOnClickListener(new j(this));
        setWillNotDraw(false);     // Catch: Exception -> L8
        setLayerType(1, null);     // Catch: Exception -> L8
        this.o = n2.a.b(12);     // Catch: Exception -> L8
        this.p = n2.a.b(12);     // Catch: Exception -> L8
        this.q = n2.a.b(18);     // Catch: Exception -> L8
        this.r = n2.a.b(Double.valueOf(0.5d));     // Catch: Exception -> L8
        this.s = n2.a.b(4);     // Catch: Exception -> L8
        ViewGroup.LayoutParams r15 = r13.getLayoutParams();     // Catch: Exception -> L8
        if ((r15 instanceof FrameLayout.LayoutParams) == false) goto L6;
        ((FrameLayout.LayoutParams) r15).gravity = 17;     // Catch: Exception -> L8
        int r16 = (int) this.o;     // Catch: Exception -> L8
        ((FrameLayout.LayoutParams) r15).leftMargin = r16;     // Catch: Exception -> L8
        ((FrameLayout.LayoutParams) r15).topMargin = r16;     // Catch: Exception -> L8
        ((FrameLayout.LayoutParams) r15).rightMargin = r16;     // Catch: Exception -> L8
        ((FrameLayout.LayoutParams) r15).bottomMargin = r16;     // Catch: Exception -> L8
        r13.setLayoutParams(r15);     // Catch: Exception -> L8
    L6:
        a(true);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        com.bytedance.ai.utils.g.a.e("AppletAppActionBar", "initBackground error", e);
    }
}
