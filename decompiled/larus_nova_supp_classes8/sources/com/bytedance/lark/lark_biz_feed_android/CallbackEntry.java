package com.bytedance.lark.lark_biz_feed_android;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/bytedance/lark/lark_biz_feed_android/CallbackEntry;", "", "()V", "Companion", "lark_biz_feed_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class CallbackEntry {
    public static final a Companion = null;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public CallbackEntry() {
    }

    @JvmStatic
    public static final byte[] invoke(long r5, long r7, byte[] r9) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(r9, "params");
        e r0 = e.a;
        u0 r1 = r0.a(r5);
        if (r1 == null) goto L22;
        if (r7 != 0) goto L17;
        monitor-enter(r0);
        Map<Long, u0> r8 = e.c;     // Catch: Throwable -> L14
        if (((u0) ((LinkedHashMap) r8).get(Long.valueOf(r5))) != null) goto L11;
        monitor-exit(r0);
    L25:
        return new byte[0];
    L11:
        u0 r6 = r8.remove(Long.valueOf(r5));     // Catch: Throwable -> L14
        monitor-exit(r0);
    L14:
        th = move-exception;
        throw th;
    L17:
        byte[] r10 = r1.onInvoke(r7, r9);
        if (r10 == null) goto L22;
        return r10;
    L22:
        throw new RuntimeException("No registered callback<InstanceId(" + r5 + ")>");
    }

    @JvmStatic
    public static final void invokeAsync(long r7, long r9, long r11, byte[] r13) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(r13, "params");
        u0 r1 = e.a.a(r9);
        if (r1 == null) goto L5;
        r1.onInvokeAsync(r7, r11, r13);
        Unit r8 = Unit.INSTANCE;
    L6:
        if (r8 == null) goto L9;
        return;
    L9:
        throw new RuntimeException("No registered callback<InstanceId(" + r9 + ")>");
    L5:
        r8 = null;
        goto L6
    }
}
