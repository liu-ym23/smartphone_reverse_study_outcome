package com.bytedance.android.live.search.impl.search;

import com.bytedance.android.live.profile.monitor.DataType;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "keyword");
        Intrinsics.checkNotNullParameter(r3, "source");
        HashMap r0 = new HashMap();
        r0.put("words_content", r2);
        r0.put("word_position", DataType.FALSE);
        r0.put("search_position", "live_square");
        r0.put("word_source", r3);
        r0.put("group_id", "");
        r0.put("impr_id", "");
        com.bytedance.android.livesdk.log.u.l().e("trending_words_show", r0, new Object[0]);
    }
}
