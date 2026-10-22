package com.larus.bmhome.bot;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.common_res.common_ui.databinding.LarusShareButtonCenterLayoutBinding;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public /* synthetic */ class CommonSettingFragment$shareBtnCenterViewStub$2$1 extends FunctionReferenceImpl implements Function1<View, LarusShareButtonCenterLayoutBinding> {
    public static final CommonSettingFragment$shareBtnCenterViewStub$2$1 INSTANCE = null;

    static {
        INSTANCE = new CommonSettingFragment$shareBtnCenterViewStub$2$1();
    }

    public CommonSettingFragment$shareBtnCenterViewStub$2$1() {
        super(1, LarusShareButtonCenterLayoutBinding.class, "bind", "bind(Landroid/view/View;)Lcom/larus/common_res/common_ui/databinding/LarusShareButtonCenterLayoutBinding;", 0);
    }

    public final LarusShareButtonCenterLayoutBinding invoke(View r4) {
        Intrinsics.checkNotNullParameter(r4, "p0");
        FrameLayout r0 = (FrameLayout) r4;
        TextView r2 = (TextView) ViewBindings.findChildViewById(r4, 2131386063);
        if (r2 == null) goto L7;
        return new LarusShareButtonCenterLayoutBinding(r0, r0, r2);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(2131386063)));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((View) r1);
    }
}
