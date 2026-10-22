package com.larus.common_ui.dbx.component;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 Z2\u00020\u0001:\u0004WXYZB'\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tB\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\b\u0010\fJ,\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u0001032\u0006\u00104\u001a\u00020\u001a2\u0010\b\u0002\u00105\u001a\n\u0012\u0004\u0012\u000201\u0018\u000106H\u0007J\u000e\u00107\u001a\u00020\u001f2\u0006\u00104\u001a\u00020\u001aJ\u0018\u00108\u001a\u0002012\u0006\u00109\u001a\u00020\u00072\u0006\u0010:\u001a\u00020\u0007H\u0014J\u0010\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>H\u0016J\b\u0010?\u001a\u000201H\u0002J\b\u0010@\u001a\u000201H\u0002J\b\u0010A\u001a\u000201H\u0002J\b\u0010B\u001a\u000201H\u0002J\u0010\u0010C\u001a\u00020\u00112\u0006\u0010D\u001a\u00020\u0007H\u0002J\b\u0010E\u001a\u000201H\u0002J\b\u0010F\u001a\u000201H\u0002J\u001a\u0010G\u001a\u0004\u0018\u00010\u001f2\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020IH\u0002J\u0010\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020IH\u0002J\u0010\u0010N\u001a\u00020\u00072\u0006\u0010O\u001a\u00020\u001aH\u0002J\f\u0010P\u001a\u00020**\u00020*H\u0002J\b\u0010Q\u001a\u00020RH\u0002J\u0010\u0010S\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u0007H\u0002J\u0010\u0010T\u001a\u00020\u00072\u0006\u0010 \u001a\u00020IH\u0002J\u0012\u0010U\u001a\u00020\u00072\b\b\u0001\u0010V\u001a\u00020\u0007H\u0002R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u0019X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\"\u001a\u0004\u0018\u00010!2\b\u0010 \u001a\u0004\u0018\u00010!@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R(\u0010'\u001a\u0004\u0018\u00010!2\b\u0010 \u001a\u0004\u0018\u00010!@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010$\"\u0004\b)\u0010&R(\u0010+\u001a\u0004\u0018\u00010*2\b\u0010 \u001a\u0004\u0018\u00010*@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/¨\u0006["}, d2 = {"Lcom/larus/common_ui/dbx/component/DbxNavigationBar;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "style", "Lcom/larus/common_ui/dbx/component/DbxNavigationBar$Style;", "(Landroid/content/Context;Lcom/larus/common_ui/dbx/component/DbxNavigationBar$Style;)V", "getStyle", "()Lcom/larus/common_ui/dbx/component/DbxNavigationBar$Style;", "titleContainer", "titleStack", "Landroid/widget/LinearLayout;", "titleRow", "titleView", "Landroid/widget/TextView;", "titleIconView", "Landroid/widget/ImageView;", "subtitleView", "actionControls", "", "Lcom/larus/common_ui/dbx/component/DbxNavigationBar$ActionPosition;", "Lcom/larus/common_ui/dbx/component/DbxNavActionControl;", "leadingActionStack", "trailingActionStack", "overlapTouchTarget", "Landroid/view/View;", "value", "", "title", "getTitle", "()Ljava/lang/CharSequence;", "setTitle", "(Ljava/lang/CharSequence;)V", "subtitle", "getSubtitle", "setSubtitle", "Landroid/graphics/drawable/Drawable;", "titleIcon", "getTitleIcon", "()Landroid/graphics/drawable/Drawable;", "setTitleIcon", "(Landroid/graphics/drawable/Drawable;)V", "setAction", "", "action", "Lcom/larus/common_ui/dbx/component/DbxNavigationBar$Action;", "at", "handler", "Lkotlin/Function0;", "actionControl", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "dispatchTouchEvent", "", "event", "Landroid/view/MotionEvent;", "initialize", "setupTitleArea", "createActionControls", "setupStandardActions", "actionStack", "horizontalGravity", "setupMiniProgramActions", "updateTitleArea", "nearestOverlappingTrailingControl", "x", "", "y", "miniSurfaceBackground", "Landroid/graphics/drawable/GradientDrawable;", "radiusPx", "miniIconSide", "position", "copyForView", "semiboldTypeface", "Landroid/graphics/Typeface;", "dp", "dpF", "color", "attrId", "Style", "ActionPosition", "Action", "Companion", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DbxNavigationBar extends FrameLayout {
    public static final /* synthetic */ int o = 0;
    public final Style a;
    public final FrameLayout b;
    public final LinearLayout c;
    public final LinearLayout d;
    public final TextView e;
    public final ImageView f;
    public final TextView g;
    public Map<ActionPosition, DbxNavActionControl> h;
    public LinearLayout i;
    public LinearLayout j;
    public View k;
    public CharSequence l;
    public CharSequence m;
    public Drawable n;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/common_ui/dbx/component/DbxNavigationBar$ActionPosition;", "", "<init>", "(Ljava/lang/String;I)V", "LEADING_PRIMARY", "LEADING_SECONDARY", "TRAILING_SECONDARY", "TRAILING_PRIMARY", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ActionPosition extends Enum<ActionPosition> {
        public static final ActionPosition LEADING_PRIMARY = null;
        public static final ActionPosition LEADING_SECONDARY = null;
        public static final ActionPosition TRAILING_PRIMARY = null;
        public static final ActionPosition TRAILING_SECONDARY = null;
        public static final /* synthetic */ ActionPosition[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<ActionPosition> getEntries() {
            return b;
        }

        static {
            ActionPosition r0 = new ActionPosition("LEADING_PRIMARY", 0);
            LEADING_PRIMARY = r0;
            ActionPosition r1 = new ActionPosition("LEADING_SECONDARY", 1);
            LEADING_SECONDARY = r1;
            ActionPosition r3 = new ActionPosition("TRAILING_SECONDARY", 2);
            TRAILING_SECONDARY = r3;
            ActionPosition r5 = new ActionPosition("TRAILING_PRIMARY", 3);
            TRAILING_PRIMARY = r5;
            ActionPosition[] r7 = {r0, r1, r3, r5};
            a = r7;
            b = EnumEntriesKt.enumEntries(r7);
        }

        public static ActionPosition[] values() {
            return (ActionPosition[]) a.clone();
        }

        public static ActionPosition valueOf(String r1) {
            return (ActionPosition) r27.a.a(ActionPosition.class, r1);
        }

        public ActionPosition(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/common_ui/dbx/component/DbxNavigationBar$Style;", "", "<init>", "(Ljava/lang/String;I)V", "STANDARD", "MINI_PROGRAM", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Style extends Enum<Style> {
        public static final Style MINI_PROGRAM = null;
        public static final Style STANDARD = null;
        public static final /* synthetic */ Style[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<Style> getEntries() {
            return b;
        }

        static {
            Style r0 = new Style("STANDARD", 0);
            STANDARD = r0;
            Style r1 = new Style("MINI_PROGRAM", 1);
            MINI_PROGRAM = r1;
            Style[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
        }

        public static Style[] values() {
            return (Style[]) a.clone();
        }

        public static Style valueOf(String r1) {
            return (Style) r27.a.a(Style.class, r1);
        }

        public Style(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ActionPosition.values().length];
            r0[ActionPosition.LEADING_PRIMARY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[ActionPosition.LEADING_SECONDARY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[ActionPosition.TRAILING_SECONDARY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[ActionPosition.TRAILING_PRIMARY.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    static {
    }

    public DbxNavigationBar(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public DbxNavigationBar(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public static Typeface d() {
        if (Build.VERSION.SDK_INT < 28) goto L5;
        Typeface r0 = Typeface.create(Typeface.create("sans-serif", 0), 600, false);
        Intrinsics.checkNotNull(r0);
        return r0;
    L5:
        Typeface r1 = Typeface.create("sans-serif-medium", 0);
        Intrinsics.checkNotNull(r1);
        return r1;
    }

    public final void e() {
        CharSequence r0 = this.m;
        boolean r1 = true;
        int r2 = 0;
        if (r0 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        boolean r4 = !r3;
        if (this.n == null) goto L12;
        boolean r5 = true;
    L13:
        this.e.setText(this.l);
        TextView r6 = this.e;
        CharSequence r7 = this.l;
        if (r7 != null) goto L16;
    L19:
        int r8 = 8;
        if (r1 == false) goto L22;
        int r9 = 8;
    L23:
        r6.setVisibility(r9);
        this.e.setTypeface(d());
        TextView r10 = this.e;
        if (r4 == false) goto L26;
        float r11 = 15.0f;
    L27:
        r10.setTextSize(2, r11);
        TextView r12 = this.e;
        if (r5 == false) goto L30;
        int r13 = 14;
    L31:
        r12.setMaxWidth(b(166 - r13));
        ImageView r14 = this.f;
        Drawable r15 = this.n;
        LinearLayout.LayoutParams r16 = null;
        if (r15 == null) goto L40;
        Drawable.ConstantState r17 = r15.getConstantState();
        if (r17 == null) goto L39;
        Drawable r18 = r17.newDrawable(getResources());
        if (r18 == null) goto L39;
        Drawable r20 = r18.mutate();
        if (r20 == null) goto L39;
    L41:
        r14.setImageDrawable(r20);
        ImageView r21 = this.f;
        if (r5 == false) goto L44;
        int r22 = 0;
    L45:
        r21.setVisibility(r22);
        TextView r23 = this.g;
        if (r4 == false) goto L48;
        CharSequence r24 = this.m;
    L49:
        r23.setText(r24);
        TextView r25 = this.g;
        if (r4 == false) goto L52;
        r8 = 0;
    L52:
        r25.setVisibility(r8);
        ViewGroup.LayoutParams r26 = this.g.getLayoutParams();
        if ((r26 instanceof LinearLayout.LayoutParams) == false) goto L55;
        r16 = (LinearLayout.LayoutParams) r26;
    L55:
        if (r16 == null) goto L59;
        if (r4 == false) goto L58;
        r2 = b(2);
    L58:
        r16.topMargin = r2;
        this.g.setLayoutParams(r16);
    L59:
        this.d.requestLayout();
        this.c.requestLayout();
        return;
    L48:
        r24 = null;
        goto L49
    L44:
        r22 = 8;
    L39:
        r20 = r15.mutate();
        goto L41
    L40:
        r20 = null;
        goto L41
    L30:
        r13 = 0;
        goto L31
    L26:
        r11 = 17.0f;
        goto L27
    L22:
        r9 = 0;
        goto L23
    L16:
        if (r7.length() == 0) goto L19;
        r1 = false;
        goto L19
    L12:
        r5 = false;
        goto L13
    L5:
        if (r0.length() == 0) goto L8;
        r3 = false;
        goto L9
    }

    public final Style getStyle() {
        return this.a;
    }

    public final CharSequence getSubtitle() {
        return this.m;
    }

    public final CharSequence getTitle() {
        return this.l;
    }

    public final Drawable getTitleIcon() {
        return this.n;
    }

    public final int a(int r2) {
        return com.larus.common_ui.dbx.theme.a.b(getContext(), r2);
    }

    public final int b(int r3) {
        Resources r0 = getResources();
        return (int) ((r3 * WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density) + 0.5f);
    }

    public final GradientDrawable c(float r3) {
        GradientDrawable r0 = new GradientDrawable();
        r0.setColor(a(2130971099));
        r0.setCornerRadius(r3);
        Resources r4 = getResources();
        r0.setStroke(RangesKt.coerceAtLeast((int) ((WindowDisplayMetricsOverride.apply(r4, r4.getDisplayMetrics()).density * 0.5f) + 0.5f), 1), a(2130971034));
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r13) {
        Intrinsics.checkNotNullParameter(r13, "event");
        if (this.a == Style.MINI_PROGRAM) goto L7;
        return super.dispatchTouchEvent(r13);
    L7:
        if (r13.getActionMasked() != 0) goto L50;
        float r0 = r13.getX();
        float r3 = r13.getY();
        DbxNavActionControl[] r5 = new DbxNavActionControl[2];
        Map<ActionPosition, DbxNavActionControl> r6 = this.h;
        if (r6 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("actionControls");
        r6 = null;
    L11:
        r5[0] = MapsKt.getValue(r6, ActionPosition.TRAILING_SECONDARY);
        Map<ActionPosition, DbxNavActionControl> r7 = this.h;
        if (r7 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("actionControls");
        r7 = null;
    L14:
        r5[1] = MapsKt.getValue(r7, ActionPosition.TRAILING_PRIMARY);
        List r8 = CollectionsKt.listOf(r5);
        ArrayList r9 = new ArrayList();
        Iterator r10 = r8.iterator();
    L16:
        if (r10.hasNext() == false) goto L34;
        Object r11 = r10.next();
        DbxNavActionControl r12 = (DbxNavActionControl) r11;
        if (r12.getVisibility() == 0) goto L20;
    L30:
        boolean r14 = false;
    L31:
        if (r14 == false) goto L16;
        r9.add(r11);
        goto L16
    L20:
        if (r12.isEnabled() == false) goto L30;
        if (r0 < r12.getLeft()) goto L30;
        if (r0 >= r12.getRight()) goto L30;
        if (r3 < r12.getTop()) goto L30;
        if (r3 >= r12.getBottom()) goto L30;
        r14 = true;
        goto L31
    L34:
        if (r9.size() >= 2) goto L36;
        View r15 = null;
    L49:
        this.k = r15;
        goto L50
    L36:
        Iterator r4 = r9.iterator();
        if (r4.hasNext() == true) goto L39;
        Object r16 = null;
    L48:
        r15 = (View) r16;
        goto L49
    L39:
        r16 = r4.next();
        if (r4.hasNext() == false) goto L48;
        DbxNavActionControl r17 = (DbxNavActionControl) r16;
        float r18 = r0 - ((r17.getLeft() + r17.getRight()) / 2.0f);
        float r20 = r3 - ((r17.getTop() + r17.getBottom()) / 2.0f);
        float r21 = (r18 * r18) + (r20 * r20);
    L43:
        Object r22 = r4.next();
        DbxNavActionControl r23 = (DbxNavActionControl) r22;
        float r110 = r0 - ((r23.getLeft() + r23.getRight()) / 2.0f);
        float r24 = r3 - ((r23.getTop() + r23.getBottom()) / 2.0f);
        float r111 = (r110 * r110) + (r24 * r24);
        if (Float.compare(r21, r111) <= 0) goto L47;
        r16 = r22;
        r21 = r111;
    L47:
        if (r4.hasNext() == true) goto L43;
    L50:
        View r1 = this.k;
        if (r1 == null) goto L59;
        MotionEvent r25 = MotionEvent.obtain(r13);
        r25.offsetLocation(-r1.getLeft(), -r1.getTop());
        boolean r2 = r1.dispatchTouchEvent(r25);
        r25.recycle();
        if (r13.getActionMasked() != 1) goto L55;
    L56:
        this.k = null;
    L57:
        return r2;
    L55:
        if (r13.getActionMasked() != 3) goto L57;
    L59:
        return super.dispatchTouchEvent(r13);
    }

    public final void setSubtitle(CharSequence r1) {
        this.m = r1;
        e();
    }

    public final void setTitle(CharSequence r1) {
        this.l = r1;
        e();
    }

    public final void setTitleIcon(Drawable r1) {
        this.n = r1;
        e();
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r5, int r6) {
        int r7 = View.MeasureSpec.getMode(r5);
        if (r7 != Integer.MIN_VALUE) goto L5;
        int r0 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(r5), 1073741824);
    L7:
        if (this.a != Style.STANDARD) goto L19;
        if (r7 == 0) goto L19;
        int r8 = RangesKt.coerceAtLeast(((View.MeasureSpec.getSize(r5) - b(166)) / 2) - b(8), 0);
        LinearLayout r9 = this.i;
        if (r9 != null) goto L12;
    L14:
        LinearLayout r10 = this.j;
        if (r10 == null) goto L19;
        if (r10.getLayoutParams().width == r8) goto L19;
        ViewGroup.LayoutParams r2 = r10.getLayoutParams();
        r2.width = r8;
        r10.setLayoutParams(r2);
        goto L19
    L12:
        if (r9.getLayoutParams().width == r8) goto L14;
        ViewGroup.LayoutParams r3 = r9.getLayoutParams();
        r3.width = r8;
        r9.setLayoutParams(r3);
    L19:
        super.onMeasure(r0, View.MeasureSpec.makeMeasureSpec(b(44), 1073741824));
        return;
    L5:
        r0 = r5;
        goto L7
    }

    /* JADX WARN: Type inference failed for: r15v5, types: [com.larus.common_ui.dbx.component.c] */
    public DbxNavigationBar(Context r18, AttributeSet r110, int r20) {
        Intrinsics.checkNotNullParameter(r18, "context");
        super(r18, r110, r20);
        FrameLayout r1 = new FrameLayout(getContext());
        this.b = r1;
        LinearLayout r2 = new LinearLayout(getContext());
        this.c = r2;
        LinearLayout r3 = new LinearLayout(getContext());
        this.d = r3;
        TextView r4 = new TextView(getContext());
        this.e = r4;
        ImageView r5 = new ImageView(getContext());
        this.f = r5;
        TextView r6 = new TextView(getContext());
        this.g = r6;
        this.a = Style.STANDARD;
        setMinimumHeight(b(44));
        setBackgroundColor(0);
        r4.setGravity(17);
        r4.setMaxLines(1);
        r4.setEllipsize(TextUtils.TruncateAt.END);
        r4.setIncludeFontPadding(false);
        r4.setTypeface(d());
        r4.setTextColor(a(2130971068));
        r5.setScaleType(ImageView.ScaleType.FIT_CENTER);
        r5.setVisibility(8);
        r5.setColorFilter(a(2130971068));
        r6.setGravity(17);
        r6.setMaxLines(1);
        r6.setEllipsize(TextUtils.TruncateAt.END);
        r6.setIncludeFontPadding(false);
        r6.setVisibility(8);
        r6.setTypeface(Typeface.create("sans-serif", 0));
        r6.setTextColor(a(2130971072));
        int r13 = 2;
        r6.setTextSize(2, 11.0f);
        r6.setLetterSpacing(0.02f);
        r6.setMaxWidth(b(166));
        r3.setOrientation(0);
        r3.setGravity(17);
        r3.addView(r4);
        LinearLayout.LayoutParams r7 = new LinearLayout.LayoutParams(b(12), b(12));
        r7.setMarginStart(b(2));
        r7.gravity = 16;
        Unit r15 = Unit.INSTANCE;
        r3.addView(r5, r7);
        r2.setOrientation(1);
        r2.setGravity(17);
        r2.addView(r3);
        LinearLayout.LayoutParams r8 = new LinearLayout.LayoutParams(-2, -2);
        r8.topMargin = b(2);
        r2.addView(r6, r8);
        r1.addView(r2, new FrameLayout.LayoutParams(-2, -2, 17));
        addView(r1, new FrameLayout.LayoutParams(b(166), b(44), 17));
        ActionPosition[] r9 = ActionPosition.values();
        LinkedHashMap r10 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(r9.length), 16));
        int r11 = r9.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L22;
        ActionPosition r14 = r9[r12];
        Context r16 = getContext();
        if (this.a != Style.STANDARD) goto L7;
        DbxNavActionControl.Appearance r17 = DbxNavActionControl.Appearance.STANDARD;
    L8:
        int r111 = b.a[r14.ordinal()];
        if (r111 == 1) goto L20;
        if (r111 != r13) goto L12;
    L19:
        int r112 = 22;
    L21:
        r10.put(r14, new DbxNavActionControl(r16, r17, b(r112), new c(this)));
        r12 = r12 + 1;
        r13 = 2;
        goto L3
    L12:
        if (r111 != 3) goto L14;
        r112 = 24;
        goto L21
    L14:
        if (r111 == 4) goto L19;
        throw new NoWhenBranchMatchedException();
    L20:
        r112 = 18;
        goto L21
    L7:
        r17 = DbxNavActionControl.Appearance.MINI_PROGRAM;
        goto L8
    L22:
        this.h = r10;
        Map<ActionPosition, DbxNavActionControl> r21 = null;
        if (this.a != Style.STANDARD) goto L38;
        LinearLayout r22 = new LinearLayout(getContext());
        r22.setOrientation(0);
        r22.setGravity(8388627);
        r22.setClipChildren(true);
        LinearLayout r23 = new LinearLayout(getContext());
        r23.setOrientation(0);
        r23.setGravity(8388629);
        r23.setClipChildren(true);
        this.i = r22;
        this.j = r23;
        Map<ActionPosition, DbxNavActionControl> r24 = this.h;
        if (r24 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("actionControls");
        r24 = null;
    L27:
        r22.addView((View) MapsKt.getValue(r24, ActionPosition.LEADING_PRIMARY));
        Map<ActionPosition, DbxNavActionControl> r25 = this.h;
        if (r25 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("actionControls");
        r25 = null;
    L30:
        r22.addView((View) MapsKt.getValue(r25, ActionPosition.LEADING_SECONDARY));
        Map<ActionPosition, DbxNavActionControl> r26 = this.h;
        if (r26 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("actionControls");
        r26 = null;
    L33:
        r23.addView((View) MapsKt.getValue(r26, ActionPosition.TRAILING_SECONDARY));
        Map<ActionPosition, DbxNavActionControl> r27 = this.h;
        if (r27 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("actionControls");
    L37:
        r23.addView((View) MapsKt.getValue(r21, ActionPosition.TRAILING_PRIMARY));
        FrameLayout.LayoutParams r28 = new FrameLayout.LayoutParams(-2, b(44), 8388611);
        r28.setMarginStart(b(8));
        Unit r30 = Unit.INSTANCE;
        addView(r22, r28);
        FrameLayout.LayoutParams r31 = new FrameLayout.LayoutParams(-2, b(44), 8388613);
        r31.setMarginEnd(b(8));
        addView(r23, r31);
    L49:
        e();
        return;
    L36:
        r21 = r27;
        goto L37
    L38:
        View r32 = new View(getContext());
        r32.setBackground(c(b(36) / 2.0f));
        View r33 = new View(getContext());
        r33.setBackground(c(b(36) / 2.0f));
        FrameLayout.LayoutParams r34 = new FrameLayout.LayoutParams(b(36), b(36), 8388627);
        r34.setMarginStart(b(12));
        Unit r113 = Unit.INSTANCE;
        addView(r32, r34);
        FrameLayout.LayoutParams r35 = new FrameLayout.LayoutParams(b(80), b(36), 8388629);
        r35.setMarginEnd(b(12));
        addView(r33, r35);
        Map<ActionPosition, DbxNavActionControl> r36 = this.h;
        if (r36 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("actionControls");
        r36 = null;
    L41:
        View r37 = (View) MapsKt.getValue(r36, ActionPosition.LEADING_PRIMARY);
        FrameLayout.LayoutParams r38 = new FrameLayout.LayoutParams(b(44), b(44), 8388627);
        r38.setMarginStart(b(8));
        addView(r37, r38);
        Map<ActionPosition, DbxNavActionControl> r40 = this.h;
        if (r40 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("actionControls");
        r40 = null;
    L44:
        View r41 = (View) MapsKt.getValue(r40, ActionPosition.TRAILING_SECONDARY);
        FrameLayout.LayoutParams r42 = new FrameLayout.LayoutParams(b(44), b(44), 8388629);
        r42.setMarginEnd(b(48));
        addView(r41, r42);
        Map<ActionPosition, DbxNavActionControl> r43 = this.h;
        if (r43 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("actionControls");
    L48:
        View r44 = (View) MapsKt.getValue(r21, ActionPosition.TRAILING_PRIMARY);
        FrameLayout.LayoutParams r45 = new FrameLayout.LayoutParams(b(44), b(44), 8388629);
        r45.setMarginEnd(b(12));
        addView(r44, r45);
        goto L49
    L47:
        r21 = r43;
        goto L48
    }

    public /* synthetic */ DbxNavigationBar(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
