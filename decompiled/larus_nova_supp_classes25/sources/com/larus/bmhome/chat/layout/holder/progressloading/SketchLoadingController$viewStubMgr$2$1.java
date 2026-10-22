package com.larus.bmhome.chat.layout.holder.progressloading;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.chat.common.databinding.LarusSketchProgressLoadingBinding;
import com.lynx.lottieadapter.LottieAdapterView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public /* synthetic */ class SketchLoadingController$viewStubMgr$2$1 extends FunctionReferenceImpl implements Function1<View, LarusSketchProgressLoadingBinding> {
    public static final SketchLoadingController$viewStubMgr$2$1 INSTANCE = null;

    static {
        INSTANCE = new SketchLoadingController$viewStubMgr$2$1();
    }

    public SketchLoadingController$viewStubMgr$2$1() {
        super(1, LarusSketchProgressLoadingBinding.class, "bind", "bind(Landroid/view/View;)Lcom/larus/chat/common/databinding/LarusSketchProgressLoadingBinding;", 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final LarusSketchProgressLoadingBinding invoke(View r9) {
        Intrinsics.checkNotNullParameter(r9, "p0");
        int r0 = 2131367812;
        if (((LinearLayout) ViewBindings.findChildViewById(r9, 2131367812)) == null) goto L15;
        r0 = 2131368849;
        TextView r4 = (TextView) ViewBindings.findChildViewById(r9, 2131368849);
        if (r4 == null) goto L15;
        r0 = 2131373629;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r9, 2131373629);
        if (r5 == null) goto L15;
        r0 = 2131378999;
        ImageWebpLoadingBgView r6 = (ImageWebpLoadingBgView) ViewBindings.findChildViewById(r9, 2131378999);
        if (r6 == null) goto L15;
        r0 = 2131383320;
        LottieAdapterView r7 = ViewBindings.findChildViewById(r9, 2131383320);
        if (r7 == null) goto L15;
        return new LarusSketchProgressLoadingBinding((RadiusCardView) r9, r4, r5, r6, r7);
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r9.getResources().getResourceName(r0)));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((View) r1);
    }
}
