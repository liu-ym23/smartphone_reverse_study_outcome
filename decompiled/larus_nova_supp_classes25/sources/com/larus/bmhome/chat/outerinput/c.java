package com.larus.bmhome.chat.outerinput;

import android.widget.FrameLayout;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public interface c {

    public static final class a {
        public static /* synthetic */ void a(c r1, String r2, FrameLayout r3, com.larus.bmhome.notification.n r4, int r5) {
            if ((r5 & 4) == 0) goto L5;
            boolean r0 = true;
        L7:
            if ((r5 & 8) == 0) goto L9;
            r4 = null;
        L9:
            r1.b(r2, r3, r0, r4);
            return;
        L5:
            r0 = false;
            goto L7
        }
    }

    boolean a();

    void b(String r1, FrameLayout r2, boolean r3, Function1<? super Integer, Unit> r4);

    void c(String r1);
}
