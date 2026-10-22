package com.bytedance.android.livesdk.interactivity.zdanmaku.widget;

import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.message.j4;
import com.bytedance.android.live.base.model.message.p0;
import com.bytedance.android.livesdk.event.n;
import com.bytedance.android.livesdk.interactivity.api.entity.p;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.r;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.w;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.x;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import r52.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b {
    public static final tb2.d a(p0 r7, int r8) {
        Intrinsics.checkNotNullParameter(r7, "$this$createDanmakuRenderText");
        tb2.d r0 = new tb2.d();
        if (r7.getSelfFakeRichContent() == null) goto L27;
        j4 r9 = r7.getSelfFakeRichContent();
        if ((r9 instanceof p) == true) goto L7;
        r9 = null;
    L7:
        p r10 = (p) r9;
        if (r10 == null) goto L40;
        String r1 = r10.a;
        Iterator<n> r11 = r10.b.iterator();
        int r2 = 0;
    L11:
        if (r11.hasNext() == false) goto L24;
        n r3 = r11.next();
        if (r3 == null) goto L11;
        float r4 = r8 * r3.i;
        int r5 = r3.d;
        if (r1 == null) goto L22;
        r0.c(com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.f(r1.substring(r2, r5)));
        float r6 = (r3.f.getDrawable().getIntrinsicWidth() / r3.f.getDrawable().getIntrinsicHeight()) * r4;
        if ((r3.f instanceof com.bytedance.android.livesdk.interactivity.api.e) == false) goto L20;
        r6 = (r3.g.getWidth() / r3.g.getHeight()) * r4;
    L20:
        r0.c(com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.b(r3.c, r3.g, (int) r6, (int) r4));
        r2 = r3.d + r3.e;
        goto L11
    L22:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L24:
        if (r2 >= (r1.length() - ((Integer) o.a.getValue()).intValue())) goto L41;
        r0.c(com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.f(r1.substring(r2)));
        return r0;
    L41:
        return r0;
    L40:
        return r0;
    L27:
        if (r7.getRichTextContent() != null) goto L29;
        r0.c(com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.f(r7.getDefaultContent()));
        return r0;
    L29:
        yb2.a r13 = w.a();
        r13.f = true;
        com.bytedance.android.livesdk.interactivity.service.textrender.core.f.a.getClass();
        x r14 = r.b;
        a5 r15 = r7.getRichTextContent();
        if (r15 != null) goto L32;
        return r0;
    L32:
        Intrinsics.checkNotNullParameter(r15, "text");
        return r.a(r15, r13);
    }
}
