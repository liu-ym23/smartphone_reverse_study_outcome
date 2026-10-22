package com.bytedance.android.accessibilityLib_Core.config.remote.step;

import android.content.Context;
import com.bytedance.android.accessibilityLib_Core.config.base.IBaseConfig;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/bytedance/android/accessibilityLib_Core/config/base/IBaseConfig;", "invoke"}, k = 3, mv = {1, 4, 1})
final class ApplyStep$collectConfig$1 extends Lambda implements Function1<IBaseConfig, Unit> {
    final /* synthetic */ ApplyStep this$0;

    public ApplyStep$collectConfig$1(ApplyStep r1) {
        this.this$0 = r1;
        super(1);
    }

    public final void invoke(IBaseConfig r10) {
        StringBuilder r0 = new StringBuilder("ApplyStep >>> configName = ");
        if (r10 == null) goto L5;
        String r1 = r10.name();
    L6:
        r0.append(r1);
        if (r0.toString() == null) goto L9;
        Context r11 = com.bytedance.android.accessibilityLib_Core.helper.a.a;
    L9:
        if (r10 == null) goto L12;
        ((ArrayList) this.this$0.b).add(r10);
        return;
    L12:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((IBaseConfig) r1);
        return Unit.INSTANCE;
    }
}
