package com.ss.android.lark.officesdk.runtime;

import com.ss.android.lark.officesdk.api.init.IOfficeSDKRuntime;
import com.ss.android.lark.officesdk.api.init.OfficeSDKInitConfig;
import com.ss.android.lark.officesdk.internal.OfficeSDKProvider;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/ss/android/lark/officesdk/api/init/IOfficeSDKRuntime;", "invoke"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
final class OfficeSDKEmbeddedRuntime$init$1$1 extends Lambda implements Function1<IOfficeSDKRuntime, Unit> {
    final /* synthetic */ OfficeSDKInitConfig $initConfig;
    final /* synthetic */ OfficeSDKCoreRuntime $runtime;

    public OfficeSDKEmbeddedRuntime$init$1$1(OfficeSDKInitConfig r1, OfficeSDKCoreRuntime r2) {
        this.$initConfig = r1;
        super(1);
    }

    public final void invoke(IOfficeSDKRuntime r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        OfficeSDKProvider r4 = OfficeSDKProvider.INSTANCE;
        r4.getInstance().a(this.$initConfig);
        a.a.set(true);
        r4.getInstance().b(null);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((IOfficeSDKRuntime) r1);
        return Unit.INSTANCE;
    }
}
