package com.obric.oui.infopanel.content;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.obric.oui.common.util.k;
import com.obric.oui.oswitch.OSwitch;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import u8.e;
import u8.f;
import u8.h;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/obric/oui/infopanel/content/OInfoPanelContentSwitchView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/obric/oui/oswitch/OSwitch;", "oSwitch", "Lcom/obric/oui/oswitch/OSwitch;", "getOSwitch", "()Lcom/obric/oui/oswitch/OSwitch;", "Landroid/widget/TextView;", "tvTitle", "Landroid/widget/TextView;", "getTvTitle", "()Landroid/widget/TextView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class OInfoPanelContentSwitchView extends ConstraintLayout {
    private final OSwitch oSwitch;
    private final TextView tvTitle;

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public OInfoPanelContentSwitchView(Context r10) {
        this(r10, null, 2, 0 == true ? 1 : 0);
    }

    @JvmOverloads
    public OInfoPanelContentSwitchView(Context r10, AttributeSet r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11);
        ViewGroup.inflate(r10, h.o_info_panel_content_switch_view, this);
        ViewGroup.MarginLayoutParams r12 = new ViewGroup.MarginLayoutParams(-1, -2);
        float r13 = 16;
        Resources r14 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r14, "Resources.getSystem()");
        int r15 = MathKt.roundToInt(TypedValue.applyDimension(1, r13, r14.getDisplayMetrics()));
        Resources r16 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r16, "Resources.getSystem()");
        r12.setMargins(0, r15, 0, MathKt.roundToInt(TypedValue.applyDimension(1, 12, r16.getDisplayMetrics())));
        Unit r17 = Unit.INSTANCE;
        setLayoutParams(r12);
        setBackgroundResource(e.o_info_panel_content_switch_view_bg);
        Resources r18 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r18, "Resources.getSystem()");
        int r19 = MathKt.roundToInt(TypedValue.applyDimension(1, r13, r18.getDisplayMetrics()));
        setPadding(r19, r19, r19, r19);
        View r20 = findViewById(f.tv_title);
        Intrinsics.checkNotNullExpressionValue(r20, "findViewById(R.id.tv_title)");
        this.tvTitle = (TextView) r20;
        View r21 = findViewById(f.o_switch);
        Intrinsics.checkNotNullExpressionValue(r21, "findViewById(R.id.o_switch)");
        OSwitch r22 = (OSwitch) r21;
        this.oSwitch = r22;
        Resources r23 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r23, "Resources.getSystem()");
        k.a(r22, MathKt.roundToInt(TypedValue.applyDimension(1, 44, r23.getDisplayMetrics())));
    }

    public /* synthetic */ OInfoPanelContentSwitchView(Context r10, AttributeSet r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = null;
    L5:
        this(r10, r11);
    }

    public final OSwitch getOSwitch() {
        return this.oSwitch;
    }

    public final TextView getTvTitle() {
        return this.tvTitle;
    }
}
