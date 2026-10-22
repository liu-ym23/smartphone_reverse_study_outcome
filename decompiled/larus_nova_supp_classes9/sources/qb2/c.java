package qb2;

import android.text.SpannableString;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.livesdk.interactivity.service.richcontent.LiveRichContentEngine;
import com.bytedance.live.richcontent.engine.SpanRendClient;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c {
    public static final g a = null;

    static {
        a = new g(0, true, 1.0f);
    }

    public static ak6.a a(a5 r4, e r5) {
        Intrinsics.checkNotNullParameter(r4, "text");
        Intrinsics.checkNotNullParameter(r5, "callBack");
        g r0 = a;
        return LiveRichContentEngine.a().a().c(mb2.d.a(r4, null, 1.0f), r0, new b(r5));
    }

    public static SpannableString c(tb2.d r3, f r4) {
        Intrinsics.checkNotNullParameter(r3, "renderText");
        if (r4 == null) goto L6;
        g r5 = r4.b;
        if (r5 == null) goto L6;
    L7:
        SpanRendClient r0 = LiveRichContentEngine.a().a();
        int r1 = mb2.c.a;
        return r0.e(mb2.c.c(r3, r5.i, "normal"), r5).a;
    L6:
        r5 = a;
        goto L7
    }

    public static void b(tb2.d r1, e r2, f r3, int r4) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
    L5:
        Intrinsics.checkNotNullParameter(r1, "renderText");
        Intrinsics.checkNotNullParameter(r2, "callBack");
        if (r3 == null) goto L9;
        g r5 = r3.b;
        if (r5 == null) goto L9;
    L10:
        int r6 = mb2.c.a;
        ek6.e r7 = mb2.c.c(r1, r5.i, "normal");
        LiveRichContentEngine.a().a().c(r7, r5, new b(r2));
        return;
    L9:
        r5 = a;
        goto L10
    }
}
