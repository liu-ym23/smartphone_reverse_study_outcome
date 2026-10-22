package com.obric.oui.popover.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.obric.oui.common.util.h;
import com.obric.oui.popover.PopoverLinearLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\n¨\u0006\u0012"}, d2 = {"Lcom/obric/oui/popover/view/GuidePopoverView;", "Lcom/obric/oui/popover/PopoverLinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "tvGuide", "Landroid/widget/TextView;", "getTvGuide", "()Landroid/widget/TextView;", "tvStatus", "getTvStatus", "setGuideText", "", "charSequence", "", "setStatusText", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GuidePopoverView extends PopoverLinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TextView f14373a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TextView f14374b;

    /* JADX WARN: Multi-variable type inference failed */
    public GuidePopoverView(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        this(r4, null, 2, 0 == true ? 1 : 0);
    }

    public GuidePopoverView(Context r4, AttributeSet r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "context");
        super(r6, r7);
        LinearLayout.inflate(r6, ZeusTransformUtils.mapRes(R.layout.o_popover_guide_view, "layout", "o_popover_guide_view"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.memorydata.plugin"));
        setOrientation(0);
        int r8 = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 12);
        setPadding(r8, r8, r8, r8);
        setBackground(ContextCompat.getDrawable(r6, ZeusTransformUtils.mapRes(R.drawable.o_popover_view_bg, "drawable", "o_popover_view_bg")));
        View r9 = findViewById(ZeusTransformUtils.mapRes(R.id.tv_status_text, OaidModel.KEY_ID, "tv_status_text"));
        Intrinsics.checkNotNullExpressionValue(r9, "findViewById(R.id.tv_status_text)");
        this.f14373a = (TextView) ZeusTransformUtils.preCheckCast(r9, TextView.class, "com.obric.memorydata.plugin");
        View r10 = findViewById(ZeusTransformUtils.mapRes(R.id.tv_guide_text, OaidModel.KEY_ID, "tv_guide_text"));
        Intrinsics.checkNotNullExpressionValue(r10, "findViewById(R.id.tv_guide_text)");
        this.f14374b = (TextView) ZeusTransformUtils.preCheckCast(r10, TextView.class, "com.obric.memorydata.plugin");
    }

    public /* synthetic */ GuidePopoverView(Context r2, AttributeSet r3, int r4, DefaultConstructorMarker r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L5;
        r7 = null;
    L5:
        this(r6, r7);
    }

    public final TextView getTvGuide() {
        return this.f14374b;
    }

    public final TextView getTvStatus() {
        return this.f14373a;
    }

    public final void setGuideText(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "charSequence");
        this.f14374b.setText(r4);
    }

    public final void setStatusText(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "charSequence");
        this.f14373a.setText(r4);
    }
}
