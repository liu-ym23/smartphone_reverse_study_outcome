package com.larus.bmhome.social.page.datasource.event;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.music.applet.MusicAppletPage;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class d {
    public static final AtomicInteger a = null;

    static {
        a = new AtomicInteger(0);
    }

    public static final String a(RefreshTraceSource r3) {
        Intrinsics.checkNotNullParameter(r3, MusicAppletPage.KEY_SOURCE);
        return r3.getTag() + '_' + System.currentTimeMillis() + '_' + a.incrementAndGet();
    }

    public static final long b(String r11) {
        Intrinsics.checkNotNullParameter(r11, "refreshTraceId");
        if (r11.length() != 0) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L9;
        return -1;
    L9:
        List r12 = StringsKt.split$default(r11, new char[]{'_'}, false, 0, 6, null);
        if (r12.size() >= 3) goto L12;
        return -1;
    L12:
        Long r13 = StringsKt.toLongOrNull((String) ListProtector.get(r12, r12.size() - 2));
        if (r13 != null) goto L15;
        return -1;
    L15:
        return r13.longValue();
    L5:
        r0 = false;
        goto L7
    }
}
