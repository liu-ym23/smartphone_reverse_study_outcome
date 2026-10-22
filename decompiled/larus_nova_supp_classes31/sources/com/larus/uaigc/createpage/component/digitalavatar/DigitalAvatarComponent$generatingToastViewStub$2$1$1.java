package com.larus.uaigc.createpage.component.digitalavatar;

import android.view.View;
import android.widget.TextView;
import androidx.viewbinding.ViewBindings;
import com.larus.common_ui.widget.roundlayout.RoundLinearLayout;
import com.larus.uaigc.impl.databinding.LarusLayoutAvatarGeneratingToastBinding;
import com.lynx.lottieadapter.LottieAdapterView;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public /* synthetic */ class DigitalAvatarComponent$generatingToastViewStub$2$1$1 extends FunctionReferenceImpl implements Function1<View, LarusLayoutAvatarGeneratingToastBinding> {
    public static final DigitalAvatarComponent$generatingToastViewStub$2$1$1 INSTANCE = null;

    static {
        INSTANCE = new DigitalAvatarComponent$generatingToastViewStub$2$1$1();
    }

    public DigitalAvatarComponent$generatingToastViewStub$2$1$1() {
        super(1, LarusLayoutAvatarGeneratingToastBinding.class, "bind", "bind(Landroid/view/View;)Lcom/larus/uaigc/impl/databinding/LarusLayoutAvatarGeneratingToastBinding;", 0);
    }

    public final LarusLayoutAvatarGeneratingToastBinding invoke(View r3) {
        Intrinsics.checkNotNullParameter(r3, "p0");
        int r0 = 2131367794;
        if (((TextView) ViewBindings.findChildViewById(r3, 2131367794)) == null) goto L9;
        r0 = 2131379040;
        LottieAdapterView r1 = ViewBindings.findChildViewById(r3, 2131379040);
        if (r1 == null) goto L9;
        return new LarusLayoutAvatarGeneratingToastBinding((RoundLinearLayout) r3, r1);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r0)));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((View) r1);
    }
}
