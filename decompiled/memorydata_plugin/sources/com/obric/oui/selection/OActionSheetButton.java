package com.obric.oui.selection;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.obric.oui.c.c;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000f\u001a\u00020\u0010H\u0003J\u000e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013J\u0010\u0010\u0014\u001a\u00020\u00102\b\b\u0001\u0010\u0015\u001a\u00020\u0016R \u0010\u0007\u001a\u00020\bX\u0086.¢\u0006\u0014\n\u0000\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/obric/oui/selection/OActionSheetButton;", "Lcom/obric/oui/layout/OUIFrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "tvTitle", "Lcom/obric/oui/text/OTextView;", "getTvTitle$annotations", "()V", "getTvTitle", "()Lcom/obric/oui/text/OTextView;", "setTvTitle", "(Lcom/obric/oui/text/OTextView;)V", CommonConsts.APM_INNER_EVENT_COST_INIT, "", "setText", "str", "", "setTextColor", TypedValues.Custom.S_COLOR, "", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OActionSheetButton extends OUIFrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f14445a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public OTextView f14446b;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/selection/OActionSheetButton$Companion;", "", "()V", "TAG", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f14445a = new a(null);
    }

    public OActionSheetButton(Context r10, AttributeSet r11) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, 0, null, 12, null);
        a();
    }

    private final void a() {
        setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new FrameLayout.LayoutParams(-1, -2), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        ZeusTransformUtils.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")), ZeusTransformUtils.mapRes(R.layout.o_listitem_button, "layout", "o_listitem_button"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        ViewGroup r0 = (ViewGroup) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.ll_root, OaidModel.KEY_ID, "ll_root")), ViewGroup.class, "com.obric.memorydata.plugin");
        c r3 = c.f13403a;
        if (r0 != null) goto L6;
    L4:
        r0 = null;
    L7:
        com.obric.oui.common.style.a r1 = (com.obric.oui.common.style.a) ZeusTransformUtils.preCheckCast(r0, com.obric.oui.common.style.a.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L11;
        r1.setChangeAlphaWhenPress(false);
    L11:
        View r2 = findViewById(ZeusTransformUtils.mapRes(R.id.tv_content_title, OaidModel.KEY_ID, "tv_content_title"));
        Intrinsics.checkNotNullExpressionValue(r2, "findViewById(R.id.tv_content_title)");
        setTvTitle((OTextView) ZeusTransformUtils.preCheckCast(r2, OTextView.class, "com.obric.memorydata.plugin"));
        setRadius((int) ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDimension(ZeusTransformUtils.mapRes(R.dimen.oui_r_l3_rect, "dimen", "oui_r_l3_rect")));
        setChangeAlphaWhenDisable(false);
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r0, com.obric.oui.common.style.a.class) == false) goto L4;
        goto L4
    }

    public static /* synthetic */ void getTvTitle$annotations() {
    }

    public final OTextView getTvTitle() {
        OTextView r0 = this.f14446b;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("tvTitle");
        return null;
    }

    public final void setText(String r3) {
        Intrinsics.checkNotNullParameter(r3, "str");
        getTvTitle().setText((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin"));
    }

    public final void setTextColor(int r1) {
        getTvTitle().setTextColor(r1);
    }

    public final void setTvTitle(OTextView r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.f14446b = r2;
    }
}
