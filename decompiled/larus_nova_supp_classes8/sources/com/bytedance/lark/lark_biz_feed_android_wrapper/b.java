package com.bytedance.lark.lark_biz_feed_android_wrapper;

import com.bytedance.lark.lark_biz_feed_android.i;
import com.bytedance.lark.view_flow_wrapper.h;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface b extends h {
    public static final a u1 = null;

    public static final class a {
        public static final /* synthetic */ a a = null;

        static {
            a = new a();
        }

        public a() {
        }
    }

    /* JADX INFO: renamed from: com.bytedance.lark.lark_biz_feed_android_wrapper.b$b, reason: collision with other inner class name */
    public static final class C0375b extends com.bytedance.lark.view_flow_wrapper.a<b> {
        public C0375b(Function0<? extends b> r2) {
            Intrinsics.checkNotNullParameter(r2, "serviceProvider");
            super(r2);
        }
    }

    static {
        u1 = a.a;
    }

    <T> Object lc(Function1<? super i, ? extends T> r1, Continuation<? super Result<? extends T>> r2);
}
