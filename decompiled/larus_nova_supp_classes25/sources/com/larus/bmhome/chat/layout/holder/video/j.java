package com.larus.bmhome.chat.layout.holder.video;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.larus.bmhome.chat.layout.holder.video.bean.AiGenVideoContentData;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class j {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static AiGenVideoContentData a(String r3) {
        AiGenVideoContentData.Companion.getClass();
        if (r3 != null) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L17;
    L15:
        return null;
    L17:
        return (AiGenVideoContentData) GsonProtectorUtils.fromJson(new Gson(), r3, AiGenVideoContentData.class);
    L13:
        e = move-exception;
        FLogger.a.e("VideoGenerateMessageUtil", g2a.d.d(r3) + ' ' + e.getMessage(), e);
        goto L15
    L5:
        if (r3.length() == 0) goto L8;
        r0 = false;
        goto L9
    }
}
