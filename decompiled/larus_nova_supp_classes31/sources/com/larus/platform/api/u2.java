package com.larus.platform.api;

import android.content.Context;
import android.view.View;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public interface u2 {

    public static final class a {
        public static /* synthetic */ e4 a(Context r2, String r3, String r4, int r5) {
            com.larus.platform.service.c1 r0 = com.larus.platform.service.c1.a;
            if ((r5 & 4) == 0) goto L6;
            r4 = null;
        L6:
            return r0.g(r2, r3, r4, null);
        }
    }

    List<Object> a();

    String b(String r1, String r2, boolean r3);

    View c(Context r1, String r2, com.larus.bmhome.chat.layout.widget.handler.h r3);

    boolean d();

    void e(String r1, String r2, com.larus.bmhome.chat.layout.item.u4 r3);

    void f();

    e4 g(Context r1, String r2, String r3, f4 r4);
}
