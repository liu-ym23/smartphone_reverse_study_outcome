package com.bytedance.android.livesdk.interactivity.utils;

import com.bytedance.bdlocation.BuildConfig;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d<T> implements Consumer {
    public static final d a = null;

    static {
        a = new d();
    }

    public d() {
    }

    public final void accept(Object r4) {
        Long r5 = (Long) r4;
        StringBuilder r6 = new StringBuilder("messageCnt=");
        e r0 = e.f;
        r6.append(e.a);
        r6.append(" danmakuCnt=");
        r6.append(e.b);
        r6.append(' ');
        r0.getClass();
        Function0<String> r1 = e.d;
        String r2 = BuildConfig.FLAVOR;
        if (r1 == null) goto L6;
        String r3 = (String) r1.invoke();
        if (r3 == null) goto L6;
    L7:
        r6.append(r3);
        r6.append(' ');
        Function0<String> r7 = e.e;
        if (r7 == null) goto L13;
        String r8 = (String) r7.invoke();
        if (r8 == null) goto L13;
        r2 = r8;
    L13:
        r6.append(r2);
        o22.b.a(r6.toString());
        e.a = 0;
        e.b = 0;
        return;
    L6:
        r3 = BuildConfig.FLAVOR;
        goto L7
    }
}
