package com.bytedance.android.livesdk.interactivity.api.emoji;

import am3.g;
import am3.h;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@IgnoreProtoFieldCheck
@ProtoMessage("webcast.api.interaction.FusionEmojiResponse.ResponseData")
public final class c extends a {
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object, py.k] */
    public c(g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L9;
        if (r2 != 1) goto L7;
        this.emoji = vh7.f.a(r5, k.class);
        goto L3
    L7:
        h.e(r5);
        goto L3
    L9:
        r5.d(r0);
    }
}
