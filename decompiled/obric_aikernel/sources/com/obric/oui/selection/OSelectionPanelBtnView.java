package com.obric.oui.selection;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.obric.oui.button.OButton;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import u8.f;
import u8.h;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated(message = "This class has been deprecated. Please use OSelectionPanelBtnViewV2 instead. ")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\f\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/obric/oui/selection/OSelectionPanelBtnView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/view/View;", "horizontal_space", "Landroid/view/View;", "getHorizontal_space", "()Landroid/view/View;", "Lcom/obric/oui/button/OButton;", "btnNegative", "Lcom/obric/oui/button/OButton;", "getBtnNegative", "()Lcom/obric/oui/button/OButton;", "btnPositive", "getBtnPositive", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class OSelectionPanelBtnView extends ConstraintLayout {
    private final OButton btnNegative;
    private final OButton btnPositive;
    private final View horizontal_space;

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public OSelectionPanelBtnView(Context r10) {
        this(r10, null, 2, 0 == true ? 1 : 0);
    }

    @JvmOverloads
    public OSelectionPanelBtnView(Context r10, AttributeSet r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11);
        ViewGroup.inflate(r10, h.o_widget_selection_panel_btns, this);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        View r12 = findViewById(f.btn_negative);
        Intrinsics.checkNotNullExpressionValue(r12, "findViewById(R.id.btn_negative)");
        this.btnNegative = (OButton) r12;
        View r13 = findViewById(f.btn_positive);
        Intrinsics.checkNotNullExpressionValue(r13, "findViewById(R.id.btn_positive)");
        this.btnPositive = (OButton) r13;
        View r14 = findViewById(f.horizontal_space);
        Intrinsics.checkNotNullExpressionValue(r14, "findViewById(R.id.horizontal_space)");
        this.horizontal_space = r14;
    }

    public /* synthetic */ OSelectionPanelBtnView(Context r10, AttributeSet r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = null;
    L5:
        this(r10, r11);
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
