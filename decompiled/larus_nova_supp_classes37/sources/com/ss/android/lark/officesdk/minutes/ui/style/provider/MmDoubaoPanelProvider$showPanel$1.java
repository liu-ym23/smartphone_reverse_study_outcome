package com.ss.android.lark.officesdk.minutes.ui.style.provider;

import androidx.fragment.app.DialogFragment;
import com.ss.android.lark.officesdk.minutes.ui.foundation.dialog.MmPanelFragmentArgs;
import com.ss.android.lark.officesdk.minutes.ui.record.dialog.MmDoubaoContentDialogFragment;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public /* synthetic */ class MmDoubaoPanelProvider$showPanel$1 extends FunctionReferenceImpl implements Function2<String, rub.d, DialogFragment> {
    public MmDoubaoPanelProvider$showPanel$1(Object r8) {
        super(2, r8, MmDoubaoPanelProvider.class, "createPanelFragment", "createPanelFragment(Ljava/lang/String;Lcom/ss/android/lark/officesdk/minutes/api/recording/common/depend/ui/entity/MmPanelConfig;)Landroidx/fragment/app/DialogFragment;", 0);
    }

    public final DialogFragment invoke(String r9, rub.d r10) {
        Intrinsics.checkNotNullParameter(r9, "p0");
        Intrinsics.checkNotNullParameter(r10, "p1");
        ((MmDoubaoPanelProvider) ((CallableReference) this).receiver).getClass();
        MmDoubaoContentDialogFragment r0 = new MmDoubaoContentDialogFragment();
        MmPanelFragmentArgs.Companion.getClass();
        Intrinsics.checkNotNullParameter(r10, "config");
        Intrinsics.checkNotNullParameter(r9, "registryTag");
        r0.setArguments(new MmPanelFragmentArgs(r9, r10.h, r10.i, r10.e, r10.l).toBundle(r10.d));
        r0.setCancelable(r10.e);
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((String) r1, (rub.d) r2);
    }
}
