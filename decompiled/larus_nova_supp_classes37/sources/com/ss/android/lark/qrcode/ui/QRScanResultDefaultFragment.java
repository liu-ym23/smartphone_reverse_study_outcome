package com.ss.android.lark.qrcode.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.ss.android.lark.base.fragment.BaseForsetiFragment;
import com.ss.android.lark.forsetiutils.ForsetiFGHelpers;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\u0010"}, d2 = {"Lcom/ss/android/lark/qrcode/ui/QRScanResultDefaultFragment;", "Lcom/ss/android/lark/base/fragment/BaseForsetiFragment;", "<init>", "()V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "Companion", "qrcode_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class QRScanResultDefaultFragment extends BaseForsetiFragment {

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ QRScanResultDefaultFragment a;

        public b(QRScanResultDefaultFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            if (ForsetiFGHelpers.d() == false) goto L5;
            com.ss.android.lark.ui.component_container.a.d(this.a, null);
            return;
        L5:
            this.a.S90();
        }
    }

    static {
    }

    public QRScanResultDefaultFragment() {
    }

    public final void onViewCreated(View r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        super/*com.ss.android.lark.base.fragment.BaseFragment*/.onViewCreated(r3, r4);
        String r5 = requireArguments().getString("KEY_SCAN_RESULT");
        r3.findViewById(2131388807).setLeftClickListener(new b(this));
        ((TextView) r3.findViewById(2131383516)).setText(r5);
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131558507, r3, false);
    }
}
