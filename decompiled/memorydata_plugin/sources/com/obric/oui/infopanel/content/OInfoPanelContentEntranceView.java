package com.obric.oui.infopanel.content;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.obric.memorydata.plugin.R;
import com.obric.oui.common.util.h;
import com.obric.oui.common.util.o;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\r\u001a\u00020\u000eH\u0014J\u000e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0014R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/obric/oui/infopanel/content/OInfoPanelContentEntranceView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "entranceContainer", "Landroid/view/ViewGroup;", "ivJump", "Landroid/widget/ImageView;", "tvEntrance", "Landroid/widget/TextView;", "onAttachedToWindow", "", "onClick", "listener", "Landroid/view/View$OnClickListener;", "setEntranceText", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OInfoPanelContentEntranceView extends ConstraintLayout {
    private final ViewGroup entranceContainer;
    private final ImageView ivJump;
    private final TextView tvEntrance;

    /* JADX WARN: Multi-variable type inference failed */
    public OInfoPanelContentEntranceView(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        this(r4, null, 2, 0 == true ? 1 : 0);
    }

    public OInfoPanelContentEntranceView(Context r4, AttributeSet r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "context");
        super(r6, r7);
        ConstraintLayout.inflate(r6, ZeusTransformUtils.mapRes(R.layout.o_info_panel_content_entrance_view, "layout", "o_info_panel_content_entrance_view"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.memorydata.plugin"));
        ViewGroup.MarginLayoutParams r8 = new ViewGroup.MarginLayoutParams(-1, -2);
        r8.setMargins(0, h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 8), 0, h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 12));
        setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r8, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        View r9 = findViewById(ZeusTransformUtils.mapRes(R.id.tv_title, OaidModel.KEY_ID, "tv_title"));
        Intrinsics.checkNotNullExpressionValue(r9, "findViewById(R.id.tv_title)");
        this.tvEntrance = (TextView) ZeusTransformUtils.preCheckCast(r9, TextView.class, "com.obric.memorydata.plugin");
        View r10 = findViewById(ZeusTransformUtils.mapRes(R.id.iv_arrow, OaidModel.KEY_ID, "iv_arrow"));
        Intrinsics.checkNotNullExpressionValue(r10, "findViewById(R.id.iv_arrow)");
        this.ivJump = (ImageView) ZeusTransformUtils.preCheckCast(r10, ImageView.class, "com.obric.memorydata.plugin");
        View r11 = findViewById(ZeusTransformUtils.mapRes(R.id.entrance_container, OaidModel.KEY_ID, "entrance_container"));
        Intrinsics.checkNotNullExpressionValue(r11, "findViewById(R.id.entrance_container)");
        this.entranceContainer = (ViewGroup) ZeusTransformUtils.preCheckCast(r11, ViewGroup.class, "com.obric.memorydata.plugin");
    }

    public /* synthetic */ OInfoPanelContentEntranceView(Context r2, AttributeSet r3, int r4, DefaultConstructorMarker r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L5;
        r7 = null;
    L5:
        this(r6, r7);
    }

    public static /* synthetic */ void lambda$s9JNiBKgUHBCRYrwYKA70RgyFxk(OInfoPanelContentEntranceView r0) {
        m1317onAttachedToWindow$lambda1(r0);
    }

    /* JADX INFO: renamed from: onAttachedToWindow$lambda-1, reason: not valid java name */
    private static final void m1317onAttachedToWindow$lambda1(OInfoPanelContentEntranceView r6) {
        Intrinsics.checkNotNullParameter(r6, "this$0");
        o.a((View) ZeusTransformUtils.preCheckCast(r6, View.class, "com.obric.memorydata.plugin"), r6.entranceContainer.getWidth(), h.a((View) ZeusTransformUtils.preCheckCast(r6, View.class, "com.obric.memorydata.plugin"), 44), true);
        o.a((View) ZeusTransformUtils.preCheckCast(r6.entranceContainer, View.class, "com.obric.memorydata.plugin"), r6.entranceContainer.getWidth(), h.a((View) ZeusTransformUtils.preCheckCast(r6, View.class, "com.obric.memorydata.plugin"), 44), true);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        post(new $$Lambda$OInfoPanelContentEntranceView$s9JNiBKgUHBCRYrwYKA70RgyFxk(this));
    }

    public final void onClick(View.OnClickListener r3) {
        View.OnClickListener r4 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnClickListener.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "listener");
        this.entranceContainer.setOnClickListener(r4);
    }

    public final void setEntranceText(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        this.tvEntrance.setText(r4);
    }
}
