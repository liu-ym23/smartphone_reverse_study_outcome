package com.bytedance.lark.lark_biz_feed_android;

import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/bytedance/lark/lark_biz_feed_android/MoltenFfiLibLarkBizFeed;", "", "()V", "Companion", "lark_biz_feed_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class MoltenFfiLibLarkBizFeed {
    public static final Lazy<Long> a = null;
    public static g b;

    public static final class a {
        public static long b() {
            return ((Number) MoltenFfiLibLarkBizFeed.a.getValue()).longValue();
        }

        public static ByteString a(m r2) {
            Intrinsics.checkNotNullParameter(r2, "info");
            g r0 = MoltenFfiLibLarkBizFeed.b;
            if (r0 != null) goto L5;
            return null;
        L5:
            byte[] r3 = r0.a(r2);
            if (r3 != null) goto L8;
            return null;
        L8:
            return ByteString.a.e(ByteString.Companion, r3);
        }

        public static void c(Object r1) {
            if (r1 != null) goto L4;
            return;
        L4:
            g r0 = MoltenFfiLibLarkBizFeed.b;
            if (r0 != null) goto L7;
            return;
        L7:
            r0.onInvokeeEnd(r1);
        }

        public static Object d(ByteString r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            g r1 = MoltenFfiLibLarkBizFeed.b;
            if (r1 != null) goto L9;
            return null;
        L9:
            return r1.onInvokeeStart(r2.toByteArray());
        }
    }

    public MoltenFfiLibLarkBizFeed() {
    }

    @JvmStatic
    public static final native long molten_ffi_init(long r0, Class<?> r2);

    @JvmStatic
    public static final native byte[] molten_ffi_lark_biz_feed_call(long r0, long r2, long r4, byte[] r6);

    @JvmStatic
    public static final native void molten_ffi_lark_biz_feed_free(long r0, long r2, long r4);

    static {
        monitor-enter(s0.class);
        String r1 = System.getProperty("molten_ffi.lark_biz_feed.lib_name");     // Catch: Throwable -> L10
        if (r1 != null) goto L7;
        r1 = "lark";
    L7:
        monitor-exit(s0.class);
        Intrinsics.checkNotNullParameter(r1, "libName");
        FLogger r0 = FLogger.a;
        r0.i("Librarian_loadLib", "loadLibrary start libName -> ".concat(r1));
        com.bytedance.librarian.a.c(r1);
        r0.i("Librarian_loadLib", "loadLibrary success by librarian -> ".concat(r1));
        a = LazyKt.lazy(MoltenFfiLibLarkBizFeed$Companion$runtime$2.INSTANCE);
        return;
    L10:
        th = move-exception;
        throw th;
    }
}
