package com.obric.oui.titlebar;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lcom/obric/oui/titlebar/OFloatingTitleBarState$ActionsState;", "actions", "", "Lcom/obric/oui/titlebar/OFloatingTitleBarState$ActionItem;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class OFloatingTitleBar$setSubEndActionEnabled$1 extends Lambda implements Function1<List<? extends a.C0783a>, a.c> {
    final /* synthetic */ OFloatingTitleBar this$0;

    OFloatingTitleBar$setSubEndActionEnabled$1(OFloatingTitleBar r1) {
        this.this$0 = r1;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final a.c invoke2(List<a.C0783a> r8) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "actions");
        return a.c.a(OFloatingTitleBar.a(this.this$0), null, null, r3, null, 11, null);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ a.c invoke(List<? extends a.C0783a> r3) {
        return invoke2((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin"));
    }
}
