package com.larus.chat.gallery.impl;

import android.content.Context;
import com.larus.bmhome.bigimg.ImageSave;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class e {
    public static final Lazy a = null;

    public e() {
    }

    static {
        a = LazyKt.lazy(new a());
    }

    public static void a(final Context r18, final String r19, String r20, boolean r21, String r22, final JSONObject r23, Function1 r24, int r25) {
        if ((r25 & 8) == 0) goto L5;
        boolean r0 = false;
    L7:
        if ((r25 & 16) == 0) goto L9;
        final String r1 = "detail_click";
    L11:
        if ((r25 & 64) == 0) goto L13;
        Function1 r7 = null;
    L14:
        if (r0 == false) goto L16;
        ImageSave.z(ImageSave.a, r20, null, null, null, false, true, null, new b(r18, r19, r1, r23), 94);
        return;
    L16:
        ImageSave.x(ImageSave.a, r20, null, null, r7, false, 54);
        return;
    L13:
        r7 = r24;
        goto L14
    L9:
        r1 = r22;
        goto L11
    L5:
        r0 = r21;
        goto L7
    }
}
