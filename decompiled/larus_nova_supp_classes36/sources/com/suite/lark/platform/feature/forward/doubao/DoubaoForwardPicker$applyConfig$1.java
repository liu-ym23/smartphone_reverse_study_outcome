package com.suite.lark.platform.feature.forward.doubao;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.picker.base.widget.SearchResultAdapter;
import com.ss.android.lark.picker.doubao.LarkPicker;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
public /* synthetic */ class DoubaoForwardPicker$applyConfig$1 extends FunctionReferenceImpl implements Function1<SearchResultAdapter, Unit> {
    public DoubaoForwardPicker$applyConfig$1(Object r8) {
        super(1, r8, LarkPicker.class, "attachSearchResultAdapter", "attachSearchResultAdapter(Lcom/ss/android/lark/picker/base/widget/SearchResultAdapter;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((SearchResultAdapter) r1);
        return Unit.INSTANCE;
    }

    public final void invoke(SearchResultAdapter r2) {
        ((LarkPicker) ((CallableReference) this).receiver).attachSearchResultAdapter(r2);
    }
}
