package com.obric.oui.selection;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.obric.oui.button.OButton;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated(message = "This class has been deprecated. ")
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/obric/oui/selection/OSelectionPanelBtnView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "btnNegative", "Lcom/obric/oui/button/OButton;", "getBtnNegative", "()Lcom/obric/oui/button/OButton;", "btnPositive", "getBtnPositive", "horizontal_space", "Landroid/view/View;", "getHorizontal_space", "()Landroid/view/View;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OSelectionPanelBtnView extends ConstraintLayout {
    private final OButton btnNegative;
    private final OButton btnPositive;
    private final View horizontal_space;

    /* JADX WARN: Multi-variable type inference failed */
    public OSelectionPanelBtnView(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        this(r4, null, 2, 0 == true ? 1 : 0);
    }

    public OSelectionPanelBtnView(Context r4, AttributeSet r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "context");
        super(r6, r7);
        ConstraintLayout.inflate(r6, ZeusTransformUtils.mapRes(R.layout.o_widget_selection_panel_btns, "layout", "o_widget_selection_panel_btns"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.memorydata.plugin"));
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        View r8 = findViewById(ZeusTransformUtils.mapRes(R.id.btn_negative, OaidModel.KEY_ID, "btn_negative"));
        Intrinsics.checkNotNullExpressionValue(r8, "findViewById(R.id.btn_negative)");
        this.btnNegative = (OButton) ZeusTransformUtils.preCheckCast(r8, OButton.class, "com.obric.memorydata.plugin");
        View r9 = findViewById(ZeusTransformUtils.mapRes(R.id.btn_positive, OaidModel.KEY_ID, "btn_positive"));
        Intrinsics.checkNotNullExpressionValue(r9, "findViewById(R.id.btn_positive)");
        this.btnPositive = (OButton) ZeusTransformUtils.preCheckCast(r9, OButton.class, "com.obric.memorydata.plugin");
        View r10 = findViewById(ZeusTransformUtils.mapRes(R.id.horizontal_space, OaidModel.KEY_ID, "horizontal_space"));
        Intrinsics.checkNotNullExpressionValue(r10, "findViewById(R.id.horizontal_space)");
        this.horizontal_space = r10;
    }

    public /* synthetic */ OSelectionPanelBtnView(Context r2, AttributeSet r3, int r4, DefaultConstructorMarker r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L5;
        r7 = null;
    L5:
        this(r6, r7);
    }

    public final OButton getBtnNegative() {
        return this.btnNegative;
    }

    public final OButton getBtnPositive() {
        return this.btnPositive;
    }

    public final View getHorizontal_space() {
        return this.horizontal_space;
    }
}
