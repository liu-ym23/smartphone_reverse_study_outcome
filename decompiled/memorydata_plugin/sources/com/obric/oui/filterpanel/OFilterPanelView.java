package com.obric.oui.filterpanel;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.obric.oui.button.OButton;
import com.obric.oui.common.util.h;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000fJ\u000e\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\bJ\u0006\u0010\u0019\u001a\u00020\nJ\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eJ\u0006\u0010\u001b\u001a\u00020\bJ\u0018\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010\u001f\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\u0011R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/obric/oui/filterpanel/OFilterPanelView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "btnConfirm", "Lcom/obric/oui/button/OButton;", "btnContainer", "Landroid/widget/LinearLayout;", "btnReset", "filterGroupContainer", "filterGroupViewList", "", "Lcom/obric/oui/filterpanel/OFilterGroupView;", "filterStyle", "", "maxSelectCount", "addFilterGroup", "", "view", "config", "Lcom/obric/oui/filterpanel/OFilterGroupView$Config;", "getConfirmBtn", "getFilterGroupContainer", "getFilterGroupViewSet", "getResetBtn", "setFilterStyle", "isAlwaysLight", "", "setMaxSelectCount", CommonConsts.COUNT_TYPE, "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OFilterPanelView extends ConstraintLayout {
    private final OButton btnConfirm;
    private final LinearLayout btnContainer;
    private final OButton btnReset;
    private final LinearLayout filterGroupContainer;
    private final Set<OFilterGroupView> filterGroupViewList;
    private int filterStyle;
    private int maxSelectCount;

    /* JADX WARN: Multi-variable type inference failed */
    public OFilterPanelView(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        this(r4, null, 2, 0 == true ? 1 : 0);
    }

    public OFilterPanelView(Context r4, AttributeSet r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "context");
        super(r6, r7);
        this.filterGroupViewList = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        this.maxSelectCount = 1;
        ConstraintLayout.inflate(r6, ZeusTransformUtils.mapRes(R.layout.o_layout_filter_panel_view, "layout", "o_layout_filter_panel_view"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.memorydata.plugin"));
        setLayoutParams(new ViewGroup.LayoutParams(-1, h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 400)));
        View r8 = findViewById(ZeusTransformUtils.mapRes(R.id.filter_group_container, OaidModel.KEY_ID, "filter_group_container"));
        Intrinsics.checkNotNullExpressionValue(r8, "findViewById(R.id.filter_group_container)");
        this.filterGroupContainer = (LinearLayout) ZeusTransformUtils.preCheckCast(r8, LinearLayout.class, "com.obric.memorydata.plugin");
        View r9 = findViewById(ZeusTransformUtils.mapRes(R.id.btn_container, OaidModel.KEY_ID, "btn_container"));
        Intrinsics.checkNotNullExpressionValue(r9, "findViewById(R.id.btn_container)");
        this.btnContainer = (LinearLayout) ZeusTransformUtils.preCheckCast(r9, LinearLayout.class, "com.obric.memorydata.plugin");
        View r10 = findViewById(ZeusTransformUtils.mapRes(R.id.btn_reset, OaidModel.KEY_ID, "btn_reset"));
        Intrinsics.checkNotNullExpressionValue(r10, "findViewById(R.id.btn_reset)");
        this.btnReset = (OButton) ZeusTransformUtils.preCheckCast(r10, OButton.class, "com.obric.memorydata.plugin");
        View r11 = findViewById(ZeusTransformUtils.mapRes(R.id.btn_confirm, OaidModel.KEY_ID, "btn_confirm"));
        Intrinsics.checkNotNullExpressionValue(r11, "findViewById(R.id.btn_confirm)");
        this.btnConfirm = (OButton) ZeusTransformUtils.preCheckCast(r11, OButton.class, "com.obric.memorydata.plugin");
    }

    public /* synthetic */ OFilterPanelView(Context r2, AttributeSet r3, int r4, DefaultConstructorMarker r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L5;
        r7 = null;
    L5:
        this(r6, r7);
    }

    public static /* synthetic */ void setFilterStyle$default(OFilterPanelView r0, int r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = true;
    L5:
        r0.setFilterStyle(r1, r2);
    }

    public final OFilterGroupView addFilterGroup(OFilterGroupView.a r7) {
        Intrinsics.checkNotNullParameter(r7, "config");
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r1, "context");
        OFilterGroupView r0 = new OFilterGroupView(r1, null, 2, null);
        Integer r2 = r7.b();
        if (r2 != null) goto L5;
        int r3 = this.filterStyle;
    L6:
        OFilterGroupView.setFilterStyle$default(r0, r3, false, 2, null);
        r0.setTitle((CharSequence) ZeusTransformUtils.preCheckCast(r7.a(), CharSequence.class, "com.obric.memorydata.plugin"));
        Integer r4 = r7.c();
        if (r4 != null) goto L9;
        int r5 = this.maxSelectCount;
    L10:
        r0.setMaxSelectCount(r5);
        List<String> r6 = r7.f();
        if (r6 != null) goto L13;
        r6 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
    L13:
        r0.setFilterItems(r6, r7.d(), r7.g());
        if (r7.e() == null) goto L16;
        Integer r8 = r7.e();
        Intrinsics.checkNotNull(r8);
        r0.select(r8.intValue());
    L16:
        r0.setEnableClickWhenSelected(r7.h());
        addFilterGroup(r0);
        return r0;
    L9:
        r5 = r4.intValue();
        goto L10
    L5:
        r3 = r2.intValue();
        goto L6
    }

    public final void addFilterGroup(OFilterGroupView r4) {
        Intrinsics.checkNotNullParameter(r4, "view");
        this.filterGroupContainer.addView((View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.memorydata.plugin"));
        this.filterGroupViewList.add(r4);
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

    public final void setFilterStyle(int r4, boolean r5) {
        this.filterStyle = r4;
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(this.filterGroupViewList, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((OFilterGroupView) ZeusTransformUtils.preCheckCast(r3.next(), OFilterGroupView.class, "com.obric.memorydata.plugin")).setFilterStyle(r4, r5);
        goto L4
    }

    public final void setMaxSelectCount(int r1) {
        this.maxSelectCount = r1;
    }
}
