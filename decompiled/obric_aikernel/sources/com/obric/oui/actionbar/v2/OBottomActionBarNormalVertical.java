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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0014B\u001d\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0006\u0010\u0003\u001a\u00020\u0002J\u0014\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u0006\u0010\t\u001a\u00020\u0002J\u000e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0002J\u000e\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0005¨\u0006\u0015"}, d2 = {"Lcom/obric/oui/actionbar/v2/OBottomActionBarNormalVertical;", "Landroid/widget/FrameLayout;", "", "getButtonCount", "", "Landroid/view/View;", "buttons", "", "setButtons", "getMaxButtonCount", "maxCount", "setMaxButtonCount", "headerView", "setHeaderView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "a", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class OBottomActionBarNormalVertical extends FrameLayout {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ODivider f6172c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private LinearLayout f6173g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private FrameLayout f6174h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f6175i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f6176j;

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
    public OBottomActionBarNormalVertical(Context r10) {
        this(r10, null, 2, 0 == true ? 1 : 0);
    }

    @JvmOverloads
    public OBottomActionBarNormalVertical(Context r10, AttributeSet r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11);
        Resources r12 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r12, "Resources.getSystem()");
        this.f6175i = MathKt.roundToInt(TypedValue.applyDimension(1, 12, r12.getDisplayMetrics()));
        this.f6176j = 3;
        View.inflate(r10, h.o_widget_bottom_action_bar_v2_normal_vertical, this);
        ODivider r13 = new ODivider(r10, null, 0, 6, null);
        this.f6172c = r13;
        Resources r14 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r14, "Resources.getSystem()");
        addView(r13, new FrameLayout.LayoutParams(-1, MathKt.roundToInt(TypedValue.applyDimension(1, (float) 0.6d, r14.getDisplayMetrics()))));
        View r15 = findViewById(f.action_bar_vertical_container);
        Intrinsics.checkNotNullExpressionValue(r15, "findViewById(R.id.action_bar_vertical_container)");
        this.f6173g = (LinearLayout) r15;
        View r16 = findViewById(f.action_bar_header_container);
        Intrinsics.checkNotNullExpressionValue(r16, "findViewById(R.id.action_bar_header_container)");
        this.f6174h = (FrameLayout) r16;
        setClipChildren(false);
        setClipToPadding(false);
    }

    public /* synthetic */ OBottomActionBarNormalVertical(Context r10, AttributeSet r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = null;
    L5:
        this(r10, r11);
    }

    public final void a(View r10) {
        Intrinsics.checkNotNullParameter(r10, "button");
        if (this.f6173g.getChildCount() < this.f6176j) goto L6;
        b.j("OBottomActionBarNormalVertical", "Maximum number of buttons reached: " + this.f6176j);
        return;
    L6:
        ViewGroup.LayoutParams r11 = r10.getLayoutParams();
        if (r11 == null) goto L9;
        LinearLayout.LayoutParams r12 = new LinearLayout.LayoutParams(r11.width, r11.height);
    L10:
        LinearLayout r13 = this.f6173g;
        if (r13.getChildCount() <= 0) goto L13;
        r12.topMargin = this.f6175i;
    L13:
        Unit r14 = Unit.INSTANCE;
        r13.addView(r10, r12);
        return;
    L9:
        r12 = new LinearLayout.LayoutParams(-1, -2);
        goto L10
    }

    public final int getButtonCount() {
        return this.f6173g.getChildCount();
    }

    public final int getMaxButtonCount() {
        return this.f6176j;
    }

    public final void setButtons(List<? extends View> r10) {
        Intrinsics.checkNotNullParameter(r10, "buttons");
        this.f6173g.removeAllViews();
        Iterator<T> r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        a((View) r11.next());
        goto L4
    }

    public final void setHeaderView(View r10) {
        Intrinsics.checkNotNullParameter(r10, "headerView");
        this.f6174h.removeAllViews();
        this.f6174h.addView(r10);
    }

    public final void setMaxButtonCount(int r10) {
        if (this.f6173g.getChildCount() <= r10) goto L6;
        b.b("OBottomActionBarNormalVertical", "Cannot set max button count to less than current button count");
        return;
    L6:
        if (r10 <= 0) goto L8;
        this.f6176j = r10;
        return;
    L8:
        b.b("OBottomActionBarNormalVertical", "Max button count must be greater than 0");
    }
}
