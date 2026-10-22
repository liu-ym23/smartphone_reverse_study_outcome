package com.ss.android.lark.officesdk.runtime;

import com.ss.android.lark.officesdk.api.init.IOfficeSDKRuntime;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
final class OfficeSDKCoreRuntime$runOnUI$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function1<IOfficeSDKRuntime, Unit> $block;
    final /* synthetic */ OfficeSDKCoreRuntime this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public OfficeSDKCoreRuntime$runOnUI$1(Function1<? super IOfficeSDKRuntime, Unit> r1, OfficeSDKCoreRuntime r2) {
        this.$block = r1;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m560invoke() {
        this.$block.invoke(null);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m560invoke();
        return Unit.INSTANCE;
    }
}
