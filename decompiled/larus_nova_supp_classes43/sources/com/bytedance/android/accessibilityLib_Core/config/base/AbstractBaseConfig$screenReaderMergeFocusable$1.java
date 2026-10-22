package com.bytedance.android.accessibilityLib_Core.config.base;

import android.content.Context;
import com.bytedance.android.accessibilityLib_Core.config.bean.ViewVirtualNode;
import com.bytedance.android.accessibilityLib_Core.config.remote.dsl.h;
import com.bytedance.android.accessibilityLib_Core.helper.a;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/bytedance/android/accessibilityLib_Core/config/bean/ViewVirtualNode;", "invoke"}, k = 3, mv = {1, 4, 1})
final class AbstractBaseConfig$screenReaderMergeFocusable$1 extends Lambda implements Function1<ViewVirtualNode, Unit> {
    final /* synthetic */ h[] $hideExcludeFocus;
    final /* synthetic */ int $id;
    final /* synthetic */ AbstractBaseConfig this$0;

    public AbstractBaseConfig$screenReaderMergeFocusable$1(AbstractBaseConfig r1, int r10, h[] r11) {
        this.this$0 = r1;
        this.$id = r10;
        this.$hideExcludeFocus = r11;
        super(1);
    }

    public final void invoke(ViewVirtualNode r10) {
        Context r0 = a.a;
        r10.b = Integer.valueOf(this.$id);
        boolean r1 = true;
        r10.n = true;
        h[] r11 = this.$hideExcludeFocus;
        r10.h = r11;
        if (r11 != null) goto L6;
        r1 = false;
    L6:
        r10.n = r1;
        new StringBuilder("config for screen read end，now the virtualNodeInfo = ").append(this.this$0.getVirtualNode());
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((ViewVirtualNode) r1);
        return Unit.INSTANCE;
    }
}
