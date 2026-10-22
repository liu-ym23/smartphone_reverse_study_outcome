package com.ss.android.lark.integrator.im.feed_shared.dependency;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.bytedance.lark.pb.basic.v1.Chatter;
import com.ss.android.lark.dto.draft.Draft;
import com.ss.android.lark.widget.richtext.RichText;
import java.util.List;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class k implements peb.b.j {
    public k() {
    }

    @Nullable
    public final String a(List<Chatter.ChatterCustomStatus> r1) {
        nmb.a.a().getCoreDependency().m();
        return null;
    }

    public final RichText b(String r2) {
        Draft r3 = (Draft) JSON.parseObject(r2, Draft.class);
        RichText r0 = r3.contentRichText;
        if (r0 == null) goto L6;
        return r0;
    L6:
        if (TextUtils.isEmpty(r3.title) == false) goto L10;
        return r3.postRichText;
    L10:
        return com.ss.android.lark.widget.richtext.c.c(r3.title);
    }
}
