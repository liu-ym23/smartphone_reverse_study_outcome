package com.larus.bmhome.chat.layout.holder.image;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.platform.kmp.chat.TemplateInfo;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class r implements Function1 {
    public final /* synthetic */ BaseImageBox a;

    public /* synthetic */ r(BaseImageBox r1) {
        this.a = r1;
    }

    public final Object invoke(Object r4) {
        BaseImageBox r0 = this.a;
        int r5 = ((Integer) r4).intValue();
        List<TemplateInfo.TemplateInfo> r1 = r0.v;
        if (r1 != null) goto L5;
        return null;
    L5:
        if (r1.size() <= r5) goto L7;
        TemplateInfo.TemplateInfo r6 = (TemplateInfo.TemplateInfo) ListProtector.get(r1, r5);
    L8:
        if (r6 != null) goto L11;
        return null;
    L11:
        return r6;
    L7:
        r6 = null;
        goto L8
    }
}
