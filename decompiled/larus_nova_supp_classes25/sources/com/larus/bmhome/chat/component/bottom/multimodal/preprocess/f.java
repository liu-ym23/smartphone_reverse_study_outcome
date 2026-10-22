package com.larus.bmhome.chat.component.bottom.multimodal.preprocess;

import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class f {
    public static final float a(float r3, ns8.b r4) {
        boolean r0 = false;
        if (r4 != null) goto L5;
    L7:
        if (r0 == true) goto L9;
    L15:
        return r3;
    L9:
        if (r3 >= 1.0f) goto L15;
        FLogger r1 = FLogger.a;
        if (r1.isDebug() == false) goto L14;
        r1.i("BaseProcessor", "[图片清晰度策略][处理配置] 跳过降采样=是，线上缩放比例=" + r3 + "，生效缩放比例=1.0，编解码参数沿用线上");
    L14:
        return 1.0f;
    L5:
        if (r4.g != true) goto L7;
        r0 = true;
        goto L7
    }
}
