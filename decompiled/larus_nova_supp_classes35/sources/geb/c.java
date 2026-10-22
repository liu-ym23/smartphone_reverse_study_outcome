package geb;

import com.ss.android.lark.log.Log;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c {
    static {
    }

    @JvmStatic
    public static final void a(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, "msg");
        Log.e(r2, "[FlowFeedLog] " + r3);
    }

    @JvmStatic
    public static final void c(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, "msg");
        Log.i(r2, "[FlowFeedLog] " + r3);
    }

    @JvmStatic
    public static final void d(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, "msg");
        Log.w(r2, "[FlowFeedLog] " + r3);
    }

    @JvmStatic
    public static final void b(String r2, String r3, Throwable r4) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, "msg");
        Log.e(r2, "[FlowFeedLog] " + r3, r4);
    }
}
