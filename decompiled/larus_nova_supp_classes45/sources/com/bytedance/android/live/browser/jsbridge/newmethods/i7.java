package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.content.Context;
import androidx.core.content.ContextCompat;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class i7 {
    public static final /* synthetic */ int b = 0;
    public final Context a;

    public static final class a {
    }

    static {
    }

    public final boolean a() {
        if (ContextCompat.checkSelfPermission(this.a, "android.permission.WRITE_CALENDAR") != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final Context getContext() {
        return this.a;
    }

    public i7(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
        com.bytedance.timon.calendar.c.b(r2);
    }
}
