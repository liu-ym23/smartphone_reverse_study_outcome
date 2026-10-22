package com.bytedance.android.bcm.impl.paramcheck;

import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.impl.util.BtmFormatUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.text.Regex;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class UnitCheckItem implements c {
    public static final Regex e = null;
    public final Lazy a;
    public final String b;
    public final String c;
    public final String d;

    public static final class a {
    }

    @Override // com.bytedance.android.bcm.impl.paramcheck.c
    public final BcmParams b() {
        return (BcmParams) this.a.getValue();
    }

    static {
        e = new Regex("\\.e.*$");
    }

    @Override // com.bytedance.android.bcm.impl.paramcheck.c
    public final String getBtm() {
        return this.b;
    }

    @Override // com.bytedance.android.bcm.impl.paramcheck.c
    public final void a(com.bytedance.android.bcm.impl.paramcheck.checker.b r10) {
        int r0 = com.bytedance.android.bcm.impl.monitor.b.a;
        String r11 = this.b;
        String r12 = this.c;
        com.bytedance.android.bcm.impl.monitor.b.c(3014, r10, BtmFormatUtils.b(r11), r11, r12, this.d, 192);
    }

    public UnitCheckItem(String r1, String r10, String r11, final BcmParams r12) {
        this.c = r10;
        this.d = r11;
        this.a = LazyKt.lazy(new UnitCheckItem$bcmParams$2(r12));
        this.b = e.replace(r1, "");
    }
}
