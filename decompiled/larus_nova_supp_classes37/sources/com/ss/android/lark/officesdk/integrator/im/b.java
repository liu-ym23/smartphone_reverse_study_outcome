package com.ss.android.lark.officesdk.integrator.im;

import android.content.Context;
import com.ss.android.lark.usersetting.service.timeformat.TimeFormatSetting;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b {
    public b() {
    }

    public final void b(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
    }

    public final boolean a() {
        if (com.ss.android.lark.usersetting.service.e.a.a.f().getTimeFormat() != TimeFormatSetting.TimeFormat.TWELVE_HOUR) goto L5;
        return true;
    L5:
        return false;
    }
}
