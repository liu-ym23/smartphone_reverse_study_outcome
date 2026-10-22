package com.larus.bmhome.view.actionbar.custom;

import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class x1 implements Function0 {
    public final /* synthetic */ String a;

    public /* synthetic */ x1(String r1) {
        this.a = r1;
    }

    public final Object invoke() {
        String r0 = this.a;
        int r1 = CustomActionBarNormalHolder.v;
        return Integer.valueOf(ColorProtector.parseColor(r0));
    }
}
