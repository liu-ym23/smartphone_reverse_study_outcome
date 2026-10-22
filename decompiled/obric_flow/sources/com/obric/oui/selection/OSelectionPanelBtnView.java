package com.obric.oui.selection;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.oui.button.OButton;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated(message = "This class has been deprecated. ")
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0017\u0010\r\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\u0016\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/obric/oui/selection/OSelectionPanelBtnView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Lcom/obric/oui/button/OButton;", "g", "Lcom/obric/oui/button/OButton;", "getBtnNegative", "()Lcom/obric/oui/button/OButton;", "btnNegative", "h", "getBtnPositive", "btnPositive", "Landroid/view/View;", "i", "Landroid/view/View;", "getHorizontal_space", "()Landroid/view/View;", "horizontal_space", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OSelectionPanelBtnView extends ConstraintLayout {
    public final OButton g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final OButton f14382h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final View f14383i;

    @JvmOverloads
    public OSelectionPanelBtnView(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, null);
    }

    public final OButton getBtnNegative() {
        return this.g;
    }

    public final OButton getBtnPositive() {
        return this.f14382h;
    }

    public final View getHorizontal_space() {
        return this.f14383i;
    }

    @JvmOverloads
    public OSelectionPanelBtnView(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10);
        View.inflate(r5, R$layout.o_widget_selection_panel_btns, this);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.g = (OButton) findViewById(R$id.btn_negative);
        this.f14382h = (OButton) findViewById(R$id.btn_positive);
        this.f14383i = findViewById(R$id.horizontal_space);
    }
}
