package com.obric.oui.filterpanel;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.lynx.tasm.utils.a;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.oui.button.OButton;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0010\u0010\u000fJ\u0013\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/obric/oui/filterpanel/OFilterPanelView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "count", "", "setMaxSelectCount", "(I)V", "Lcom/obric/oui/button/OButton;", "getResetBtn", "()Lcom/obric/oui/button/OButton;", "getConfirmBtn", "", "Lcom/obric/oui/filterpanel/OFilterGroupView;", "getFilterGroupViewSet", "()Ljava/util/Set;", "Landroid/widget/LinearLayout;", "getFilterGroupContainer", "()Landroid/widget/LinearLayout;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OFilterPanelView extends ConstraintLayout {
    public final LinearLayout g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final OButton f13222h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final OButton f13223i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final LinkedHashSet f13224j;

    @JvmOverloads
    public OFilterPanelView(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, null);
    }

    public final OButton getConfirmBtn() {
        return this.f13223i;
    }

    public final LinearLayout getFilterGroupContainer() {
        return this.g;
    }

    public final Set<OFilterGroupView> getFilterGroupViewSet() {
        return this.f13224j;
    }

    public final OButton getResetBtn() {
        return this.f13222h;
    }

    public final void setMaxSelectCount(int r5) {
    }

    @JvmOverloads
    public OFilterPanelView(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10);
        this.f13224j = new LinkedHashSet();
        View.inflate(r5, R$layout.o_layout_filter_panel_view, this);
        setLayoutParams(new ViewGroup.LayoutParams(-1, a.B(400, this)));
        this.g = (LinearLayout) findViewById(R$id.filter_group_container);
        LinearLayout r11 = (LinearLayout) findViewById(R$id.btn_container);
        this.f13222h = (OButton) findViewById(R$id.btn_reset);
        this.f13223i = (OButton) findViewById(R$id.btn_confirm);
    }
}
