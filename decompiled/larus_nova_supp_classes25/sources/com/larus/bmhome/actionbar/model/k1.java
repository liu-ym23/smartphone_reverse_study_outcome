package com.larus.bmhome.actionbar.model;

import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public interface k1 {

    public static final class a {
        public static /* synthetic */ String a(k1 r1, String r2, int r3) {
            if ((r3 & 1) == 0) goto L6;
            r2 = null;
        L6:
            return r1.c(r2, null);
        }
    }

    String a();

    List<String> b(List<String> r1);

    String c(String r1, List<String> r2);
}
