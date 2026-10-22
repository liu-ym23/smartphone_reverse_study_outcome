package com.bytedance.android.accessibilityLib_Core.config.base;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/bytedance/android/accessibilityLib_Core/config/base/IBaseConfig;", "invoke", "com/bytedance/android/accessibilityLib_Core/config/base/AbstractBaseConfig$findTargetNodeInTree$1$1"}, k = 3, mv = {1, 4, 1})
final class AbstractBaseConfig$findTargetNodeInTree$$inlined$let$lambda$1 extends Lambda implements Function1<IBaseConfig, Unit> {
    final /* synthetic */ int $id$inlined;
    final /* synthetic */ Ref.ObjectRef $targetNode$inlined;

    public AbstractBaseConfig$findTargetNodeInTree$$inlined$let$lambda$1(int r1, Ref.ObjectRef r10) {
        this.$id$inlined = r1;
        this.$targetNode$inlined = r10;
        super(1);
    }

    public final void invoke(IBaseConfig r10) {
        if (r10 == null) goto L4;
        Integer r0 = r10.getVirtualNode().b;
    L5:
        if (r0 != null) goto L8;
        return;
    L8:
        if (r0.intValue() != this.$id$inlined) goto L11;
        this.$targetNode$inlined.element = r10;
        return;
    L11:
        return;
    L4:
        r0 = null;
        goto L5
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((IBaseConfig) r1);
        return Unit.INSTANCE;
    }
}
