package com.obric.oui.sheet.v2;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.obric.oui.button.OButton;
import com.obric.oui.c.i;
import com.obric.oui.common.util.h;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0018JG\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u00182\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u001c2\b\b\u0002\u0010!\u001a\u00020\u00182\b\u0010\"\u001a\u0004\u0018\u00010\u001f¢\u0006\u0002\u0010#JB\u0010\u0019\u001a\u00020\u001a2\b\u0010$\u001a\u0004\u0018\u00010%2\b\b\u0002\u0010\u001d\u001a\u00020\u00182\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010&\u001a\u0004\u0018\u00010%2\b\b\u0002\u0010!\u001a\u00020\u00182\b\u0010\"\u001a\u0004\u0018\u00010\u001fR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006'"}, d2 = {"Lcom/obric/oui/sheet/v2/OSheetFooterBtnContainer;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "btnNegative", "Lcom/obric/oui/button/OButton;", "getBtnNegative", "()Lcom/obric/oui/button/OButton;", "setBtnNegative", "(Lcom/obric/oui/button/OButton;)V", "btnPositive", "getBtnPositive", "setBtnPositive", "horizontal_space", "Landroid/view/View;", "getHorizontal_space", "()Landroid/view/View;", "setHorizontal_space", "(Landroid/view/View;)V", "createButton", "isPrimary", "", "setButtons", "", "negativeBtnTextResId", "", "negativeIsPrimary", "negativeActionEvent", "Landroid/view/View$OnClickListener;", "positiveBtnTextResId", "positiveIsPrimary", "positiveActionEvent", "(Ljava/lang/Integer;ZLandroid/view/View$OnClickListener;Ljava/lang/Integer;ZLandroid/view/View$OnClickListener;)V", "negativeBtnText", "", "positiveBtnText", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OSheetFooterBtnContainer extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private OButton f14477a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private OButton f14478b;
    private View c;

    /* JADX WARN: Multi-variable type inference failed */
    public OSheetFooterBtnContainer(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        this(r4, null, 2, 0 == true ? 1 : 0);
    }

    public OSheetFooterBtnContainer(Context r5, AttributeSet r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r6, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "context");
        super(r7, r8);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(0);
        int r9 = ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.oui_p_container_large_1, "dimen", "oui_p_container_large_1"));
        setPadding(r9, h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 8), r9, 0);
    }

    public /* synthetic */ OSheetFooterBtnContainer(Context r2, AttributeSet r3, int r4, DefaultConstructorMarker r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L5;
        r7 = null;
    L5:
        this(r6, r7);
    }

    public final OButton a(boolean r5) {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (r5 == false) goto L5;
        int r6 = R.layout.oui_widget_panel_primary_btn;
        String r3 = "oui_widget_panel_primary_btn";
    L6:
        View r4 = LinearLayout.inflate(r0, ZeusTransformUtils.mapRes(r6, "layout", r3), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.memorydata.plugin"));
        Objects.requireNonNull(r4, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup r7 = (ViewGroup) ZeusTransformUtils.preCheckCast(r4, ViewGroup.class, "com.obric.memorydata.plugin");
        View r8 = r7.getChildAt(r7.getChildCount() - 1);
        Objects.requireNonNull(r8, "null cannot be cast to non-null type com.obric.oui.button.OButton");
        return (OButton) ZeusTransformUtils.preCheckCast(r8, OButton.class, "com.obric.memorydata.plugin");
    L5:
        r6 = R.layout.oui_widget_panel_netural_btn;
        r3 = "oui_widget_panel_netural_btn";
        goto L6
    }

    public final void a(Integer r10, boolean r11, View.OnClickListener r12, Integer r13, boolean r14, View.OnClickListener r15) {
        View.OnClickListener r5 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r12, View.OnClickListener.class, "com.obric.memorydata.plugin");
        View.OnClickListener r8 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r15, View.OnClickListener.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L5;
        String r3 = ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getString(r10.intValue());
    L6:
        if (r13 == null) goto L8;
        String r6 = ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getString(r13.intValue());
    L9:
        a(r3, r11, r5, r6, r14, r8);
        return;
    L8:
        r6 = null;
        goto L9
    L5:
        r3 = null;
        goto L6
    }

    public final void a(String r6, boolean r7, View.OnClickListener r8, String r9, boolean r10, View.OnClickListener r11) {
        View.OnClickListener r12 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r8, View.OnClickListener.class, "com.obric.memorydata.plugin");
        View.OnClickListener r13 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r11, View.OnClickListener.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L5;
        char r14 = 0;
    L18:
        if (r14 <= 0) goto L27;
        View r15 = new View((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        this.c = r15;
        addView(r15);
        View r16 = this.c;
        if (r16 == null) goto L23;
        i.a(r16, h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 12));
    L23:
        View r17 = this.c;
        if (r17 == null) goto L27;
        i.b(r17, h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 1));
    L27:
        if (r9 == null) goto L42;
        setBtnPositive(a(r10));
        OButton r18 = getBtnPositive();
        if (r18 == null) goto L33;
        r18.setId(ZeusTransformUtils.mapRes(R.id.btn_positive, OaidModel.KEY_ID, "btn_positive"));
    L33:
        OButton r19 = getBtnPositive();
        if (r19 == null) goto L37;
        r19.setOnClickListener(r13);
    L37:
        OButton r5 = getBtnPositive();
        if (r5 == null) goto L43;
        r5.setText((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin"));
        return;
    L43:
        return;
    L42:
        return;
    L5:
        setBtnNegative(a(r7));
        OButton r20 = getBtnNegative();
        if (r20 == null) goto L9;
        r20.setId(ZeusTransformUtils.mapRes(R.id.btn_negative, OaidModel.KEY_ID, "btn_negative"));
    L9:
        OButton r21 = getBtnNegative();
        if (r21 == null) goto L13;
        r21.setOnClickListener(r12);
    L13:
        OButton r22 = getBtnNegative();
        if (r22 == null) goto L17;
        r22.setText((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin"));
    L17:
        r14 = 1;
        goto L18
    }

    public final OButton getBtnNegative() {
        return this.f14477a;
    }

    public final OButton getBtnPositive() {
        return this.f14478b;
    }

    public final View getHorizontal_space() {
        return this.c;
    }

    public final void setBtnNegative(OButton r1) {
        this.f14477a = r1;
    }

    public final void setBtnPositive(OButton r1) {
        this.f14478b = r1;
    }

    public final void setHorizontal_space(View r1) {
        this.c = r1;
    }
}
