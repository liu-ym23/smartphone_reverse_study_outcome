package com.obric.oui.popover.menu;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/obric/oui/popover/menu/OPopoverEntranceMenuView$PopoverItem;", "invoke", "(Lcom/obric/oui/popover/menu/OPopoverEntranceMenuView$PopoverItem;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class OPopoverEntranceMenuView$findItemByPosition$1 extends Lambda implements Function1<OPopoverEntranceMenuView.b, Boolean> {
    public static final OPopoverEntranceMenuView$findItemByPosition$1 INSTANCE = null;

    static {
        INSTANCE = new OPopoverEntranceMenuView$findItemByPosition$1();
    }

    OPopoverEntranceMenuView$findItemByPosition$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Boolean invoke2(OPopoverEntranceMenuView.b r1) {
        Intrinsics.checkNotNullParameter(r1, "it");
        if (r1.k() != 0) goto L5;
        boolean r0 = true;
    L7:
        return Boolean.valueOf(r0);
    L5:
        r0 = false;
        goto L7
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Boolean invoke(OPopoverEntranceMenuView.b r3) {
        return invoke2((OPopoverEntranceMenuView.b) ZeusTransformUtils.preCheckCast(r3, OPopoverEntranceMenuView.b.class, "com.obric.memorydata.plugin"));
    }
}
