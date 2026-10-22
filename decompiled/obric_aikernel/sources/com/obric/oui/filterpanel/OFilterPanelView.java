package com.obric.oui.filterpanel;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.oui.button.OButton;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import u8.f;
import u8.h;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010!\u001a\u00020 \u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\"¢\u0006\u0004\b$\u0010%J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\nJ\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\bJ\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0011\u001a\u00020\u000fJ\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u0012J\u0006\u0010\u0015\u001a\u00020\u0014R\u0016\u0010\u0016\u001a\u00020\u00148\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0018R\u0016\u0010\u0019\u001a\u00020\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001b\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u00148\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u0017R\u0016\u0010\u001d\u001a\u00020\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001aR\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00020\u00128\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006&"}, d2 = {"Lcom/obric/oui/filterpanel/OFilterPanelView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/obric/oui/filterpanel/OFilterGroupView;", "view", "", "addFilterGroup", "Lcom/obric/oui/filterpanel/OFilterGroupView$b;", "config", "", "filterStyle", "", "isAlwaysLight", "setFilterStyle", CommonConsts.COUNT_TYPE, "setMaxSelectCount", "Lcom/obric/oui/button/OButton;", "getResetBtn", "getConfirmBtn", "", "getFilterGroupViewSet", "Landroid/widget/LinearLayout;", "getFilterGroupContainer", "btnContainer", "Landroid/widget/LinearLayout;", "I", "btnReset", "Lcom/obric/oui/button/OButton;", "maxSelectCount", "filterGroupContainer", "btnConfirm", "filterGroupViewList", "Ljava/util/Set;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class OFilterPanelView extends ConstraintLayout {
    private final OButton btnConfirm;
    private final LinearLayout btnContainer;
    private final OButton btnReset;
    private final LinearLayout filterGroupContainer;
    private final Set<OFilterGroupView> filterGroupViewList;
    private int filterStyle;
    private int maxSelectCount;

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public OFilterPanelView(Context r10) {
        this(r10, null, 2, 0 == true ? 1 : 0);
    }

    @JvmOverloads
    public OFilterPanelView(Context r10, AttributeSet r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11);
        this.filterGroupViewList = new LinkedHashSet();
        this.maxSelectCount = 1;
        ViewGroup.inflate(r10, h.o_layout_filter_panel_view, this);
        Resources r12 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r12, "Resources.getSystem()");
        setLayoutParams(new ViewGroup.LayoutParams(-1, MathKt.roundToInt(TypedValue.applyDimension(1, 400, r12.getDisplayMetrics()))));
        View r13 = findViewById(f.filter_group_container);
        Intrinsics.checkNotNullExpressionValue(r13, "findViewById(R.id.filter_group_container)");
        this.filterGroupContainer = (LinearLayout) r13;
        View r14 = findViewById(f.btn_container);
        Intrinsics.checkNotNullExpressionValue(r14, "findViewById(R.id.btn_container)");
        this.btnContainer = (LinearLayout) r14;
        View r15 = findViewById(f.btn_reset);
        Intrinsics.checkNotNullExpressionValue(r15, "findViewById(R.id.btn_reset)");
        this.btnReset = (OButton) r15;
        View r16 = findViewById(f.btn_confirm);
        Intrinsics.checkNotNullExpressionValue(r16, "findViewById(R.id.btn_confirm)");
        this.btnConfirm = (OButton) r16;
    }

    public /* synthetic */ OFilterPanelView(Context r10, AttributeSet r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = null;
    L5:
        this(r10, r11);
    }

    public static /* synthetic */ void setFilterStyle$default(OFilterPanelView r10, int r11, boolean r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L5;
        r12 = true;
    L5:
        r10.setFilterStyle(r11, r12);
    }

    public final OFilterGroupView addFilterGroup(OFilterGroupView.b r10) {
        Intrinsics.checkNotNullParameter(r10, "config");
        Context r11 = getContext();
        Intrinsics.checkNotNullExpressionValue(r11, "context");
        new OFilterGroupView(r11, null, 2, null);
        throw null;
    }

    public final void addFilterGroup(OFilterGroupView r10) {
        Intrinsics.checkNotNullParameter(r10, "view");
        this.filterGroupContainer.addView(r10);
        this.filterGroupViewList.add(r10);
    }

    public final OButton getConfirmBtn() {
        return this.btnConfirm;
    }

    public final LinearLayout getFilterGroupContainer() {
        return this.filterGroupContainer;
    }

    public final Set<OFilterGroupView> getFilterGroupViewSet() {
        return this.filterGroupViewList;
    }

    public final OButton getResetBtn() {
        return this.btnReset;
    }

    public final void setFilterStyle(int r10, boolean r11) {
        this.filterStyle = r10;
        Iterator<T> r12 = this.filterGroupViewList.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        ((OFilterGroupView) r12.next()).setFilterStyle(r10, r11);
        goto L4
    }

    public final void setMaxSelectCount(int r10) {
        this.maxSelectCount = r10;
    }
}
