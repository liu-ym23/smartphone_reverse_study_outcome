package com.bytedance.android.accessibilityLib_Core.config.base;

import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.bytedance.android.accessibilityLib_Core.config.bean.ViewVirtualNode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/bytedance/android/accessibilityLib_Core/config/bean/ViewVirtualNode;", "invoke"}, k = 3, mv = {1, 4, 1})
final class AbstractBaseConfig$setDesc$1 extends Lambda implements Function1<ViewVirtualNode, Unit> {
    final /* synthetic */ String $desc;
    final /* synthetic */ int $id;

    public AbstractBaseConfig$setDesc$1(int r1, String r10) {
        this.$id = r1;
        this.$desc = r10;
        super(1);
    }

    public final void invoke(ViewVirtualNode r10) {
        r10.b = Integer.valueOf(this.$id);
        String r0 = this.$desc;
        ((AccessibilityNodeInfoCompat) r10.d.getValue()).setContentDescription(r0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((ViewVirtualNode) r1);
        return Unit.INSTANCE;
    }
}
