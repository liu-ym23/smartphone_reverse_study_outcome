package com.larksuite.arch.jack;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/larksuite/arch/jack/ViewModelNotCreatedException;", "Ljava/lang/IllegalStateException;", "Lkotlin/IllegalStateException;", "msg", "", "<init>", "(Ljava/lang/String;)V", "jack_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class ViewModelNotCreatedException extends IllegalStateException {
    public ViewModelNotCreatedException(String r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
        super(r2);
    }
}
