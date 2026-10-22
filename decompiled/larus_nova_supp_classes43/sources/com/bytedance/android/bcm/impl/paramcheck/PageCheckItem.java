package com.bytedance.android.bcm.impl.paramcheck;

import com.bytedance.android.bcm.api.model.BcmParams;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class PageCheckItem implements c {
    public final String a;
    public final Lazy b;
    public final String c;
    public final String d;
    public final String e;

    @Override // com.bytedance.android.bcm.impl.paramcheck.c
    public final BcmParams b() {
        return (BcmParams) this.b.getValue();
    }

    @Override // com.bytedance.android.bcm.impl.paramcheck.c
    public final String getBtm() {
        return this.a;
    }

    @Override // com.bytedance.android.bcm.impl.paramcheck.c
    public final void a(com.bytedance.android.bcm.impl.paramcheck.checker.b r10) {
        int r0 = com.bytedance.android.bcm.impl.monitor.b.a;
        com.bytedance.android.bcm.impl.monitor.b.c(3015, r10, this.c, null, this.d, this.e, 200);
    }

    public PageCheckItem(String r10, String r11, String r12, final Map<String, ? extends BcmParams> r13) {
        this.c = r10;
        this.d = r11;
        this.e = r12;
        this.a = StringsKt.replace$default(r10, ".c0.d0", "", false, 4, null);
        this.b = LazyKt.lazy(new PageCheckItem$bcmParams$2(r13));
    }
}
