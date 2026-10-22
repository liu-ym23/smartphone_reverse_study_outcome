package com.bytedance.sdk.xbridge.cn.protocol;

import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.exception.IllegalInputParamException;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d {
    public abstract g a();

    public abstract Object b(int r5, String r10);

    public final Object c(bj.a r5, int r10, String r11) {
        Intrinsics.checkNotNullParameter(r5, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(r11, "message");
        r5.f938k = r10;
        Intrinsics.checkNotNullParameter(r11, "<set-?>");
        r5.f939l = r11;
        r5.f940m = false;
        return b(r10, r11);
    }

    public final void d(bj.a r11, Object r12, IDLXBridgeMethod r13, cj.d r14, e r15) {
        Intrinsics.checkNotNullParameter(r11, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(r13, "bridge");
        Intrinsics.checkNotNullParameter(r14, "bridgeContext");
        Intrinsics.checkNotNullParameter(r15, "callback");
        ja.d r5 = new ja.d(r11, r15, this, r13);     // Catch: Throwable -> L10 IllegalInputParamException -> L12
        jk.a r10 = new jk.a(r11, r15, this, r13, r14);     // Catch: Throwable -> L10 IllegalInputParamException -> L12
        if (r13.getCompatibility().f7469a == false) goto L21;
        LinkedHashMap r16 = a().a(r12);     // Catch: Throwable -> L10 IllegalInputParamException -> L12
        if (Intrinsics.areEqual(r16.get("__test_register"), 1) == false) goto L15;
        r15.c(c(r11, 0, "bridge已注册"));     // Catch: Throwable -> L10 IllegalInputParamException -> L12
        return;
    L15:
        if (Intrinsics.areEqual(r11.d, "webcast") == false) goto L18;
        r13.realHandle(r14, r16, r10);     // Catch: Throwable -> L10 IllegalInputParamException -> L12
        return;
    L18:
        r13.realHandle(r14, r16, r5);     // Catch: Throwable -> L10 IllegalInputParamException -> L12
        return;
    L21:
        if (Intrinsics.areEqual(r11.d, "webcast") == false) goto L23;
        Map<String, ? extends Object> r17 = a().b(r13.getClass(), r12, r11.d);     // Catch: Throwable -> L10 IllegalInputParamException -> L12
    L24:
        if (r17 != null) goto L28;
        r15.c(c(r11, -10, "XBridge IDL 数据转换失败"));     // Catch: Throwable -> L10 IllegalInputParamException -> L12
        return;
    L28:
        if (Intrinsics.areEqual(r17.get("__test_register"), 1) == false) goto L32;
        r15.c(c(r11, 0, "bridge已注册"));     // Catch: Throwable -> L10 IllegalInputParamException -> L12
        return;
    L32:
        if (Intrinsics.areEqual(r11.d, "webcast") == false) goto L35;
        r13.realHandle(r14, r17, r10);     // Catch: Throwable -> L10 IllegalInputParamException -> L12
        return;
    L35:
        r13.realHandle(r14, r17, r5);     // Catch: Throwable -> L10 IllegalInputParamException -> L12
        return;
    L23:
        r17 = a().c(r13.getClass(), r12);     // Catch: Throwable -> L10 IllegalInputParamException -> L12
    L12:
        e = move-exception;
        Object r18 = c(r11, -3, e.toString());
        Intrinsics.checkNotNull(r18);
        r15.c(r18);
        return;
    L10:
        th = move-exception;
        Object r19 = c(r11, -11, th.toString());
        Intrinsics.checkNotNull(r19);
        r15.c(r19);
    }
}
