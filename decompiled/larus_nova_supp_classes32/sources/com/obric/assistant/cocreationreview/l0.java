package com.obric.assistant.cocreationreview;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public interface l0 {

    public static final class a {
        public static void a(com.obric.assistant.cocreationreview.a r1, Vote r2, j1 r3, k1 r4) {
            Intrinsics.checkNotNullParameter(r1, "record");
            Intrinsics.checkNotNullParameter(r2, "vote");
            Intrinsics.checkNotNullParameter(r3, "defaultAction");
            Intrinsics.checkNotNullParameter(r4, "showDetailAction");
            r3.invoke();
        }
    }

    e5 a(Context r1);

    l5 b();

    w5 c(j5 r1, com.obric.assistant.cocreationreview.a r2, a5 r3, boolean r4, b r5);

    String d(com.obric.assistant.cocreationreview.a r1);

    ModuleKey e();

    void f(com.obric.assistant.cocreationreview.a r1, Vote r2, j1 r3, k1 r4);
}
