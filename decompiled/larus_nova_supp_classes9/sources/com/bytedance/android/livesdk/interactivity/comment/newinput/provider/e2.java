package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdk.interactivity.service.richcontent.LiveRichContentEngine;
import com.bytedance.live.richcontent.engine.SpanRendClient;
import io.reactivex.functions.Function;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e2<T, R> implements Function {
    public static final e2 a = null;

    static {
        a = new e2();
    }

    public e2() {
    }

    public final Object apply(Object r8) {
        com.bytedance.android.live.network.response.e r9 = (com.bytedance.android.live.network.response.e) r8;
        Intrinsics.checkNotNullParameter(r9, "response");
        c32.c r0 = (c32.c) ((ExtraResponse) r9).data;
        if (r0 == null) goto L12;
        List<c32.d> r1 = r0.results;
        if (r1 == null) goto L12;
        Iterator<T> r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L12;
        c32.d r3 = (c32.d) r2.next();
        a5 r4 = r3.associationDisplayText;
        if (r4 == null) goto L8;
        com.bytedance.android.livesdk.interactivity.service.textrender.core.f.a.getClass();
        com.bytedance.android.livesdk.interactivity.service.textrender.core.x r5 = com.bytedance.android.livesdk.interactivity.service.textrender.core.r.b;
        Intrinsics.checkNotNullParameter(r4, "text");
        tb2.d r6 = com.bytedance.android.livesdk.interactivity.service.textrender.core.r.a(r4, null);
        qb2.g r7 = new qb2.g(false, 0.0f, 5);
        Intrinsics.checkNotNullParameter(r6, "renderText");
        SpanRendClient r10 = LiveRichContentEngine.a().a();
        int r11 = mb2.c.a;
        r3.a = r10.e(mb2.c.c(r6, r7.i, "normal"), r7).a;
    L12:
        return r9;
    }
}
