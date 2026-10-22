package com.obric.oui.popover.v2;

import android.view.View;
import com.obric.oui.popover.FakeAnchorView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "it", "", "invoke", "(Landroid/view/View;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class OPopover$clearFakeAnchorViewIfNecessary$1 extends Lambda implements Function1<View, Boolean> {
    public static final OPopover$clearFakeAnchorViewIfNecessary$1 INSTANCE = null;

    static {
        INSTANCE = new OPopover$clearFakeAnchorViewIfNecessary$1();
    }

    OPopover$clearFakeAnchorViewIfNecessary$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(View r10) {
        return Boolean.valueOf(invoke2(r10));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(View r10) {
        Intrinsics.checkNotNullParameter(r10, "it");
        return r10 instanceof FakeAnchorView;
    }
}
