package com.obric.oui.infopanel.content;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.obric.oui.common.util.h;
import com.obric.oui.common.util.o;
import com.obric.oui.oswitch.OSwitch;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/obric/oui/infopanel/content/OInfoPanelContentSwitchView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "oSwitch", "Lcom/obric/oui/oswitch/OSwitch;", "getOSwitch", "()Lcom/obric/oui/oswitch/OSwitch;", "tvTitle", "Landroid/widget/TextView;", "getTvTitle", "()Landroid/widget/TextView;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OInfoPanelContentSwitchView extends ConstraintLayout {
    private final OSwitch oSwitch;
    private final TextView tvTitle;

    /* JADX WARN: Multi-variable type inference failed */
    public OInfoPanelContentSwitchView(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        this(r4, null, 2, 0 == true ? 1 : 0);
    }

    public OInfoPanelContentSwitchView(Context r5, AttributeSet r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r6, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "context");
        super(r7, r8);
        ConstraintLayout.inflate(r7, ZeusTransformUtils.mapRes(R.layout.o_info_panel_content_switch_view, "layout", "o_info_panel_content_switch_view"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.memorydata.plugin"));
        ViewGroup.MarginLayoutParams r9 = new ViewGroup.MarginLayoutParams(-1, -2);
        r9.setMargins(0, h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 16), 0, h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 12));
        setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r9, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        setBackgroundResource(ZeusTransformUtils.mapRes(R.drawable.o_info_panel_content_switch_view_bg, "drawable", "o_info_panel_content_switch_view_bg"));
        int r10 = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 16);
        setPadding(r10, r10, r10, r10);
        View r11 = findViewById(ZeusTransformUtils.mapRes(R.id.tv_title, OaidModel.KEY_ID, "tv_title"));
        Intrinsics.checkNotNullExpressionValue(r11, "findViewById(R.id.tv_title)");
        this.tvTitle = (TextView) ZeusTransformUtils.preCheckCast(r11, TextView.class, "com.obric.memorydata.plugin");
        View r12 = findViewById(ZeusTransformUtils.mapRes(R.id.o_switch, OaidModel.KEY_ID, "o_switch"));
        Intrinsics.checkNotNullExpressionValue(r12, "findViewById(R.id.o_switch)");
        OSwitch r13 = (OSwitch) ZeusTransformUtils.preCheckCast(r12, OSwitch.class, "com.obric.memorydata.plugin");
        this.oSwitch = r13;
        o.a((View) ZeusTransformUtils.preCheckCast(r13, View.class, "com.obric.memorydata.plugin"), h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 44));
    }

    public /* synthetic */ OInfoPanelContentSwitchView(Context r2, AttributeSet r3, int r4, DefaultConstructorMarker r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L5;
        r7 = null;
    L5:
        this(r6, r7);
    }

    public final OSwitch getOSwitch() {
        return this.oSwitch;
    }

    public final TextView getTvTitle() {
        return this.tvTitle;
    }
}
