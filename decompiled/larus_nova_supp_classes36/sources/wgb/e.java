package wgb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.viewbinding.ViewBindings;
import com.larksuite.component.universe_design.shadow.UDShadowLayout;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.flow.chat.databinding.LayoutFlowMessageTipBinding;
import com.ss.android.lark.utils.UIHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e extends FrameLayout {
    public static final int b = 0;
    public LayoutFlowMessageTipBinding a;

    public static final class a {
    }

    public final void a() {
        setVisibility(0);
        LayoutFlowMessageTipBinding r1 = this.a;
        LayoutFlowMessageTipBinding r2 = null;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r1 = null;
    L5:
        r1.c.setVisibility(8);
        LayoutFlowMessageTipBinding r3 = this.a;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L9:
        r2.f.setVisibility(0);
        return;
    L8:
        r2 = r3;
        goto L9
    }

    static {
        b = UIHelper.dp2px(268.0f) - UIHelper.dp2px(92.0f);
    }

    public e(Context r11) {
        Intrinsics.checkNotNullParameter(r11, "context");
        super(r11);
        View r12 = LayoutInflater.from(getContext()).inflate(2131563323, this, false);
        addView(r12);
        int r0 = 2131363244;
        ImageView r4 = (ImageView) ViewBindings.findChildViewById(r12, 2131363244);
        if (r4 == null) goto L21;
        r0 = 2131363791;
        if (((ImageView) ViewBindings.findChildViewById(r12, 2131363791)) == null) goto L21;
        r0 = 2131363792;
        UDShadowLayout r5 = ViewBindings.findChildViewById(r12, 2131363792);
        if (r5 == null) goto L21;
        r0 = 2131372861;
        FrameLayout r6 = (FrameLayout) ViewBindings.findChildViewById(r12, 2131372861);
        if (r6 == null) goto L21;
        r0 = 2131378977;
        ProgressBar r7 = (ProgressBar) ViewBindings.findChildViewById(r12, 2131378977);
        if (r7 == null) goto L21;
        r0 = 2131380747;
        if (ViewBindings.findChildViewById(r12, 2131380747) == null) goto L21;
        r0 = 2131380749;
        UDShadowLayout r8 = ViewBindings.findChildViewById(r12, 2131380749);
        if (r8 == null) goto L21;
        r0 = 2131390946;
        TextView r1 = (TextView) ViewBindings.findChildViewById(r12, 2131390946);
        if (r1 == null) goto L21;
        this.a = new LayoutFlowMessageTipBinding((LinearLayout) r12, r4, r5, r6, r7, r8, r1);
        r1.setMaxWidth(b);
        return;
    L21:
        throw new NullPointerException("Missing required view with ID: ".concat(r12.getResources().getResourceName(r0)));
    }

    public final void setArrowDirection(boolean r3) {
        if (r3 == false) goto L4;
        int r4 = 2131235448;
    L5:
        LayoutFlowMessageTipBinding r0 = this.a;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L8:
        r0.b.setImageDrawable(UIUtils.getDrawable(getContext(), r4));
        return;
    L4:
        r4 = 2131235445;
        goto L5
    }

    public final void setLoadingState(boolean r5) {
        LayoutFlowMessageTipBinding r2 = null;
        if (r5 == false) goto L12;
        LayoutFlowMessageTipBinding r6 = this.a;
        if (r6 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r6 = null;
    L7:
        r6.b.setVisibility(8);
        LayoutFlowMessageTipBinding r7 = this.a;
        if (r7 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L11:
        r2.e.setVisibility(0);
        return;
    L10:
        r2 = r7;
        goto L11
    L12:
        LayoutFlowMessageTipBinding r8 = this.a;
        if (r8 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r8 = null;
    L15:
        r8.b.setVisibility(0);
        LayoutFlowMessageTipBinding r9 = this.a;
        if (r9 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L19:
        r2.e.setVisibility(8);
        return;
    L18:
        r2 = r9;
        goto L19
    }
}
