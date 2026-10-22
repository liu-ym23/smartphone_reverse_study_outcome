package com.larus.uaigc.service;

import com.larus.bmhome.chat.layout.holder.image.bean.ImageShareClickMethod;
import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class w implements ky9.b {
    public static final w a = null;

    static {
        a = new w();
    }

    public w() {
    }

    @Override // ky9.b
    public final void a(ImageShareClickMethod r1, df8.a r2, String r3, JSONObject r4) {
        Intrinsics.checkNotNullParameter(r1, "clickMethod");
        Intrinsics.checkNotNullParameter(r2, "imageItemInfo");
    }

    @Override // ky9.b
    public final void b(ImageShareClickMethod r1, df8.a r2, String r3, Integer r4, String r5, String r6, String r7, String r8) {
        Intrinsics.checkNotNullParameter(r1, "clickMethod");
        Intrinsics.checkNotNullParameter(r2, "imageItemInfo");
    }

    @Override // ky9.b
    public final com.larus.bmhome.share.panel.h c(ImageShareClickMethod r1, df8.a r2, Integer r3, JSONObject r4, Message r5) {
        Intrinsics.checkNotNullParameter(r1, "clickMethod");
        Intrinsics.checkNotNullParameter(r2, "imageItemInfo");
        return null;
    }
}
