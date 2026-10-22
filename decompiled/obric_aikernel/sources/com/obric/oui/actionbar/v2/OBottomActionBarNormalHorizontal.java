package com.obric.oui.actionbar.v2;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.obric.oui.divider.ODivider;
import ea.b;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import u8.f;
import u8.h;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0014B\u001d\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0006\u0010\u0003\u001a\u00020\u0002J\u0014\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u0006\u0010\t\u001a\u00020\u0002J\u000e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0002J\u000e\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0005¨\u0006\u0015"}, d2 = {"Lcom/obric/oui/actionbar/v2/OBottomActionBarNormalHorizontal;", "Landroid/widget/FrameLayout;", "", "getButtonCount", "", "Landroid/view/View;", "buttons", "", "setButtons", "getMaxButtonCount", "maxCount", "setMaxButtonCount", "headerView", "setHeaderView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "a", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class OBottomActionBarNormalHorizontal extends FrameLayout {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ODivider f6167c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private LinearLayout f6168g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private FrameLayout f6169h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f6170i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f6171j;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        new a(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public OBottomActionBarNormalHorizontal(Context r10) {
        this(r10, null, 2, 0 == true ? 1 : 0);
    }

    @JvmOverloads
    public OBottomActionBarNormalHorizontal(Context r10, AttributeSet r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11);
        Resources r12 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r12, "Resources.getSystem()");
        this.f6170i = MathKt.roundToInt(TypedValue.applyDimension(1, 12, r12.getDisplayMetrics()));
        this.f6171j = 2;
        View.inflate(r10, h.o_widget_bottom_action_bar_v2_normal_horizontal, this);
        ODivider r13 = new ODivider(r10, null, 0, 6, null);
        this.f6167c = r13;
        Resources r14 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r14, "Resources.getSystem()");
        addView(r13, new FrameLayout.LayoutParams(-1, MathKt.roundToInt(TypedValue.applyDimension(1, (float) 0.6d, r14.getDisplayMetrics()))));
        View r15 = findViewById(f.action_bar_horizontal_container);
        Intrinsics.checkNotNullExpressionValue(r15, "findViewById(R.id.action_bar_horizontal_container)");
        this.f6168g = (LinearLayout) r15;
        View r16 = findViewById(f.action_bar_header_container);
        Intrinsics.checkNotNullExpressionValue(r16, "findViewById(R.id.action_bar_header_container)");
        this.f6169h = (FrameLayout) r16;
        setClipChildren(false);
        setClipToPadding(false);
    }

    public /* synthetic */ OBottomActionBarNormalHorizontal(Context r10, AttributeSet r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = null;
    L5:
        this(r10, r11);
    }

    private final void a(View r10, boolean r11) {
        ViewGroup.LayoutParams r12 = r10.getLayoutParams();
        if (r12 == null) goto L5;
        LinearLayout.LayoutParams r13 = new LinearLayout.LayoutParams(r12.width, r12.height);
    L6:
        if (r11 == false) goto L8;
        r13.width = -1;
    L9:
        LinearLayout r14 = this.f6168g;
        if (r14.getChildCount() <= 0) goto L12;
        r13.leftMargin = this.f6170i;
    L12:
        Unit r15 = Unit.INSTANCE;
        r14.addView(r10, r13);
        return;
    L8:
        r13.width = 0;
        r13.weight = 1.0f;
        goto L9
    L5:
        r13 = new LinearLayout.LayoutParams(-1, -2);
        goto L6
    }

    public final int getButtonCount() {
        return this.f6168g.getChildCount();
    }

    public final int getMaxButtonCount() {
        return this.f6171j;
    }

    public final void setButtons(List<? extends View> r10) {
        Intrinsics.checkNotNullParameter(r10, "buttons");
        if (r10.size() <= this.f6171j) goto L6;
        b.j("OBottomActionBarNormalHorizontal", "Cannot set more than " + this.f6171j + " buttons");
        return;
    L6:
        this.f6168g.removeAllViews();
        Iterator<T> r11 = r10.iterator();
    L8:
        if (r11.hasNext() == false) goto L14;
        View r12 = (View) r11.next();
        boolean r13 = true;
        if (r10.size() == 1) goto L13;
        r13 = false;
    L13:
        a(r12, r13);
        goto L8
    }

    public final void setHeaderView(View r10) {
        Intrinsics.checkNotNullParameter(r10, "headerView");
        this.f6169h.removeAllViews();
        this.f6169h.addView(r10);
    }

    public final void setMaxButtonCount(int r10) {
        if (this.f6168g.getChildCount() <= r10) goto L6;
        b.b("OBottomActionBarNormalHorizontal", "Cannot set max button count to less than current button count");
        return;
    L6:
        if (r10 <= 0) goto L8;
        this.f6171j = r10;
        return;
    L8:
        b.b("OBottomActionBarNormalHorizontal", "Max button count must be greater than 0");
    }
}
