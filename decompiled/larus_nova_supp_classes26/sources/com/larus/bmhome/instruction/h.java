package com.larus.bmhome.instruction;

import java.util.Map;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public interface h extends m1a.a {

    public static final class a {
        public static /* synthetic */ void a(h r1, com.larus.bmhome.actionbar.model.z0 r2, int r3, Function0 r4, int r5) {
            if ((r5 & 16) == 0) goto L5;
            r4 = null;
        L5:
            r1.h50(r2, r3, null, r4);
        }
    }

    f EI();

    com.larus.bmhome.actionbar.model.z0 Kp(String r1);

    String S20();

    void h50(com.larus.bmhome.actionbar.model.z0 r1, int r2, aq8.e r3, Function0 r4);

    void nT(String r1);

    void qz(Map<String, String> r1, String r2);

    void updateConversationId(String r1, String r2);
}
