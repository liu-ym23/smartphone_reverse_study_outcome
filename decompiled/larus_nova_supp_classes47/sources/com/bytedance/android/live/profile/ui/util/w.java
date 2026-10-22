package com.bytedance.android.live.profile.ui.util;

import android.content.Context;
import com.bytedance.ies.utility.SharedPrefHelper;
import java.util.TimeZone;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class w {
    public static final a a = null;

    public static final class a {
        public a() {
        }

        public static boolean a(Context r6, String r7) {
            Intrinsics.checkNotNullParameter(r7, "spKey");
            long r0 = System.currentTimeMillis();
            long r1 = r0 - ((((long) TimeZone.getDefault().getRawOffset()) + r0) % 86400000);
            if (SharedPrefHelper.b(r6).i(r7, -1) >= r1) goto L5;
            return true;
        L5:
            return false;
        }
    }

    static {
        a = new a();
    }
}
