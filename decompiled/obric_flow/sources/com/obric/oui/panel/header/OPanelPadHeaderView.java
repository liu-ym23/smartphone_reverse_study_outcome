package com.obric.oui.panel.header;

import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.obric.common.oui.R$attr;
import com.obric.common.oui.R$dimen;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.oui.divider.ODivider;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\r\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/obric/oui/panel/header/OPanelPadHeaderView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Landroidx/appcompat/widget/AppCompatImageView;", "getCloseIconView", "()Landroidx/appcompat/widget/AppCompatImageView;", "Landroid/widget/TextView;", "getTitleView", "()Landroid/widget/TextView;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OPanelPadHeaderView extends ConstraintLayout {
    public final AppCompatImageView g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final TextView f14001h;

    @JvmOverloads
    public OPanelPadHeaderView(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, null);
    }

    public final AppCompatImageView getCloseIconView() {
        return this.g;
    }

    public final TextView getTitleView() {
        return this.f14001h;
    }

    @JvmOverloads
    public OPanelPadHeaderView(Context r10, AttributeSet r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11);
        View.inflate(r10, R$layout.o_basic_panel_pad_header, this);
        int r5 = R$attr.oui_PanelDefaultHeaderHeight;
        int r12 = R$dimen.oui_panel_default_header_height;
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r10, "context");
        TypedValue r13 = new TypedValue();
        if (r10.getTheme().resolveAttribute(r5, r13, true) == true) goto L6;
        r13 = null;
    L6:
        if (r13 != null) goto L8;
    L12:
        float r14 = r10.getResources().getDimension(r12);
    L13:
        setLayoutParams(new ViewGroup.LayoutParams(-1, (int) r14));
        setBackgroundColor(0);
        this.g = (AppCompatImageView) findViewById(R$id.iv_close);
        this.f14001h = (TextView) findViewById(R$id.tv_title);
        ImageView r15 = (ImageView) findViewById(R$id.iv_back);
        ODivider r16 = (ODivider) findViewById(R$id.divider);
        return;
    L8:
        if (r13.type != 5) goto L12;
        r14 = r13.getDimension(r10.getResources().getDisplayMetrics());
        goto L13
    }
}
