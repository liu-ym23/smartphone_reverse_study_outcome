package com.ss.android.lark.picker.doubao.assembly;

import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.picker.doubao.DoubaoPicker;
import com.ss.android.lark.picker.doubao.IDoubaoPickerApi;
import com.ss.android.lark.picker.doubao.IDoubaoPickerController;
import com.ss.android.lark.picker.doubao.entity.DoubaoPickerConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/picker/doubao/assembly/DoubaoPickerWrapper;", "Lcom/ss/android/lark/picker/doubao/IDoubaoPickerApi;", "config", "Lcom/ss/android/lark/picker/doubao/entity/DoubaoPickerConfig;", "<init>", "(Lcom/ss/android/lark/picker/doubao/entity/DoubaoPickerConfig;)V", "getConfig", "()Lcom/ss/android/lark/picker/doubao/entity/DoubaoPickerConfig;", "attach", "Lcom/ss/android/lark/picker/doubao/IDoubaoPickerController;", "activity", "Landroidx/fragment/app/FragmentActivity;", "rootView", "Landroid/view/ViewGroup;", "picker-doubao-assembly_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class DoubaoPickerWrapper implements IDoubaoPickerApi {
    private final DoubaoPickerConfig config;

    public final DoubaoPickerConfig getConfig() {
        return this.config;
    }

    public DoubaoPickerWrapper(DoubaoPickerConfig r2) {
        Intrinsics.checkNotNullParameter(r2, "config");
        this.config = r2;
    }

    @Override // com.ss.android.lark.picker.doubao.IDoubaoPickerApi
    public IDoubaoPickerController attach(FragmentActivity r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "activity");
        Intrinsics.checkNotNullParameter(r5, "rootView");
        AttributeSet r1 = null;
        final DoubaoPicker r0 = new DoubaoPicker(r4, r1, 2, r1);
        r0.init(r4, this.config);
        r0.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        r5.addView(r0);
        return new AnonymousClass1(r0);
    }
}
