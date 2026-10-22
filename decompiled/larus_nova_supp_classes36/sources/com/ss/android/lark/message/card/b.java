package com.ss.android.lark.message.card;

import com.bytedance.i18n.claymore.ClaymoreServiceLoader;
import com.ss.android.lark.message.card.style.MessageCardStyleProvider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b {
    public static volatile MessageCardStyleProvider a;

    public static hrb.a a() {
        return (hrb.a) ClaymoreServiceLoader.loadFirst(hrb.a.class);
    }

    public b() {
    }
}
