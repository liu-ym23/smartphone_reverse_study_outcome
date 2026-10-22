package com.bytedance.android.live.revlink.impl.multianchor.dynamic.context;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class w<T> implements Observer {
    public final /* synthetic */ e0 a;

    public w(e0 r1) {
        this.a = r1;
    }

    public final void onChanged(Object r4) {
        JSONObject r0 = new JSONObject();
        b03.a r1 = b03.a.a;
        r0.put("screen_width", Float.valueOf(b03.c.c(s1.y())));
        r0.put("screen_height", Float.valueOf(b03.c.c(s1.w())));
        r0.put("screen_type", !Intrinsics.areEqual((Boolean) r4, Boolean.TRUE) ? 1 : 0);
        r0.put("is_fold_full", FoldScreenUtils.f() ? 1 : 0);
        this.a.f.setValue(r0);
    }
}
