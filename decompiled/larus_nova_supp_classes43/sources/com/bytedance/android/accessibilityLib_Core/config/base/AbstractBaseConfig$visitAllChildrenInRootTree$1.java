package com.bytedance.android.accessibilityLib_Core.config.base;

import android.content.Context;
import com.bytedance.android.accessibilityLib_Core.config.bean.a;
import com.bytedance.android.accessibilityLib_Core.config.bean.b;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/accessibilityLib_Core/config/bean/b;", "it", "", "invoke", "(Lcom/bytedance/android/accessibilityLib_Core/config/bean/b;)V", "<anonymous>"}, k = 3, mv = {1, 4, 1})
final class AbstractBaseConfig$visitAllChildrenInRootTree$1 extends Lambda implements Function1<b, Unit> {
    final /* synthetic */ Function1 $action;

    public AbstractBaseConfig$visitAllChildrenInRootTree$1(Function1 r1) {
        this.$action = r1;
        super(1);
    }

    public final void invoke(b r10) {
        StringBuilder r0 = new StringBuilder("visit child node : config name ");
        a r1 = r10.a;
        String r11 = null;
        if (r1 == null) goto L5;
        IBaseConfig r12 = r1.a;
    L6:
        if (r12 == null) goto L8;
        r11 = r12.name();
    L8:
        r0.append(r11);
        if (r0.toString() == null) goto L11;
        Context r13 = com.bytedance.android.accessibilityLib_Core.helper.a.a;
    L11:
        this.$action.invoke(r10);
        return;
    L5:
        r12 = null;
        goto L6
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((b) r1);
        return Unit.INSTANCE;
    }
}
