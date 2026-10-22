package com.bytedance.android.ec.core.utils;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.ai.event.MessageIndication;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.facebook.common.executors.HandlerExecutorServiceImpl;
import java.lang.reflect.Field;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class OptCardUtil {
    public static final boolean a = false;
    public static final Handler b = null;
    public static final a c = null;
    public static final Lazy d = null;
    public static boolean e;

    public static final class a extends HandlerExecutorServiceImpl {
        public a(Handler r1) {
            super(r1);
        }

        public final void execute(Runnable r10) {
            if (r10 != null) goto L4;
            return;
        L4:
            if (isHandlerThread() == false) goto L6;
            r10.run();
            return;
        L6:
            boolean r0 = OptCardUtil.a;
            OptCardUtil.b.postAtFrontOfQueue(r10);
        }
    }

    static {
        a = ECAppInfoService.e.isLocalTest();
        Handler r0 = new Handler(Looper.getMainLooper());
        b = r0;
        c = new a(r0);
        d = LazyKt.lazy(OptCardUtil$fieldUIExecutor$2.INSTANCE);
    }

    public static void a(Object r10) {
        Intrinsics.checkNotNullParameter(r10, "controller");
        Lazy r1 = d;     // Catch: Exception -> L6
        Field r11 = (Field) r1.getValue();     // Catch: Exception -> L6
        if (r11 == null) goto L9;
        r11.set(r10, c);     // Catch: Exception -> L6
    L9:
        if (((Field) r1.getValue()) == null) goto L11;
        b("image", "change executor success");     // Catch: Exception -> L6
        return;
    L11:
        b("image", "change executor fail: field is null");     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        b("image", "change executor fail " + e);
    }

    @JvmStatic
    public static final void b(String r1, String r10) {
        Intrinsics.checkNotNullParameter(r10, MessageIndication.MESSAGE_TYPE_MSG);
        if (a == false) goto L10;
        dm.a.b r0 = dm.a.a;
        if (r1 != null) goto L7;
        String r11 = "ec-opt-card";
    L8:
        dm.a.a(r11).i(r10);
        return;
    L7:
        r11 = "ec-opt-card_".concat(r1);
        goto L8
    }
}
