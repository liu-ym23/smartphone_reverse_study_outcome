package com.ss.android.lark.passport.base.core.log;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class PassportLog {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/ss/android/lark/passport/base/core/log/PassportLog$LogLevel;", "", "Companion", "passport-base-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface LogLevel {
        public static final a Companion = null;
        public static final int DEBUG = 1;
        public static final int ERROR = 4;
        public static final int FATAL = 5;
        public static final int INFO = 2;
        public static final int VERBOSE = 0;
        public static final int WARN = 3;

        public static final class a {
            public static final /* synthetic */ a a = null;

            static {
                a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.a;
        }
    }

    static {
    }

    @JvmStatic
    public static final void b(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "tag");
        a(r1, r2, 4);
    }

    @JvmStatic
    public static final void d(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "tag");
        a(r1, r2, 2);
    }

    @JvmStatic
    public static final void e(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "tag");
        a(r1, r2, 3);
    }

    public static void a(String r1, String r2, @LogLevel int r3) {
        String r4 = "Passport_".concat(r1);
        String r5 = String.valueOf(r2);
        if (r3 != 0) goto L5;
        Log.v(r4, r5);
        return;
    L5:
        if (r3 != 1) goto L7;
        Log.d(r4, r5);
        return;
    L7:
        if (r3 != 2) goto L9;
        Log.i(r4, r5);
        return;
    L9:
        if (r3 != 3) goto L11;
        Log.w(r4, r5);
        return;
    L11:
        if (r3 == 4) goto L13;
        Log.i(r4, r5);
        return;
    L13:
        Log.e(r4, r5);
    }

    @JvmStatic
    public static final void c(String r1, String r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r1, "tag");
        Log.e("Passport_".concat(r1), r2, r3);
    }
}
