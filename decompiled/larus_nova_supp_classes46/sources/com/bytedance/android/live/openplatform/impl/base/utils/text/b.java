package com.bytedance.android.live.openplatform.impl.base.utils.text;

import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public interface b {

    public static final class a {
        public static /* synthetic */ void a(c r2, int r3) {
            r2.e(r3, 0, SpannableStringBuilderEnv$space$1.INSTANCE);
        }
    }

    c a(Function1 r1);

    c append(CharSequence r1);

    c b(Object r1, Function1 r2);

    c c(Function1 r1);
}
