package com.obric.eventkit.eventstaskmanager;

import android.os.Parcel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class TimerTaskKt {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(TimerTaskKt$gson$2.INSTANCE);
    }

    public static final String a(Parcel r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        String r2 = r1.readString();
        if (r2 != null) goto L6;
        return "";
    L6:
        return r2;
    }
}
