package com.ss.android.lark.flow.feed.utils;

import com.ss.android.lark.log.Log;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final void a(String r3) {
        Intrinsics.checkNotNullParameter("FeedSidebarAdapter", "tag");
        Intrinsics.checkNotNullParameter(r3, "msg");
        Log.d("FeedSidebarAdapter", "[FlowFeedLog] " + r3);
    }

    @JvmStatic
    public static final void b(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, "msg");
        Log.e(r2, "[FlowFeedLog] " + r3);
    }

    @JvmStatic
    public static final void d(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, "msg");
        Log.i(r2, "[FlowFeedLog] " + r3);
    }

    @JvmStatic
    public static final void e(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, "msg");
        Log.w(r2, "[FlowFeedLog] " + r3);
    }

    @JvmStatic
    public static final void c(String r1, String r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r1, "tag");
        Intrinsics.checkNotNullParameter(r2, "msg");
        Log.e(r1, "[FlowFeedLog] ".concat(r2), r3);
    }
}
