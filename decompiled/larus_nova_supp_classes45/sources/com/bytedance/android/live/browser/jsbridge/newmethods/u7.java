package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class u7<T, R> implements Function {
    public final /* synthetic */ Function0 a;

    public u7(Function0 r1) {
        this.a = r1;
    }

    public final Object apply(Object r6) {
        int[] r7 = (int[]) r6;
        Intrinsics.checkNotNullParameter(r7, "result");
        int r0 = r7.length;
        int r2 = 0;
    L3:
        boolean r3 = true;
        if (r2 >= r0) goto L12;
        if (r7[r2] == 0) goto L9;
        r3 = false;
    L9:
        if (r3 == false) goto L10;
        r2 = r2 + 1;
        goto L3
    L10:
        r3 = false;
    L12:
        if (r3 == true) goto L18;
        ALogger.i("CalendarManager", "no permission to add calendar event");
        com.bytedance.android.live.core.utils.f2.b(2131915434, 0);
        com.bytedance.android.livesdk.sharedpref.e<Boolean> r8 = j40.f4.B;
        Boolean r1 = Boolean.TRUE;
        r8.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r8, r1);
        return Single.error(new Exception("user denied calendar permission"));
    L18:
        return (Single) this.a.invoke();
    }
}
