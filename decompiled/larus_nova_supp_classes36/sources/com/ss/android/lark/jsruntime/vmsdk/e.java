package com.ss.android.lark.jsruntime.vmsdk;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.bytedance.ee.bear.jsbridge.Message;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import com.ss.android.lark.officesdk.utils.ReflectUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e extends tb5.a {
    public final String a;
    public final Map<String, tb5.i<?>> b;
    public final tb5.f.b c;

    public static final class a {
        public static void a(String r5, tb5.i r6, m r7) {
            Intrinsics.checkNotNullParameter(r5, "data");
            Intrinsics.checkNotNullParameter(r6, "handler");
            Class r0 = ReflectUtils.a(r6);
            if (r0 != null) goto L5;
            r0 = ReflectUtils.b(r6);
        L5:
            Object r1 = null;
            if (r0 != null) goto L17;
            r6.handle(null, r7);
            return;
        L17:
        L13:
            th = move-exception;
            com.ss.android.lark.officesdk.utils.di.j.b("Bridge", "handleJSMsg PARSE_DATA_ERR  data： " + r5 + "    clazz： " + r0 + "  e: " + th);
        L15:
            r6.handle(r1, r7);
            return;
        L9:
            if (Intrinsics.areEqual(r0, String.class) == false) goto L11;
            Object r8 = r5;
        L12:
            r1 = r8;
            goto L15
        L11:
            r8 = JSON.parseObject(r5, r0);     // Catch: Throwable -> L13
            goto L12
        }
    }

    static {
    }

    public e(tb5.f.b r3) {
        this.a = "JSRuntimeBridge#" + Integer.toHexString(hashCode());
        this.b = new ConcurrentHashMap();
        this.c = r3;
    }

    public final void c(Message r5) {
        m r1 = a(r5.a);     // Catch: Throwable -> L11
        String r2 = r5.e;     // Catch: Throwable -> L11
        if (TextUtils.isEmpty(r2) == false) goto L6;
        com.ss.android.lark.officesdk.utils.di.j.b(this.a, "handlerName is empty");     // Catch: Throwable -> L11
        tb5.i r3 = null;
    L7:
        if (r3 == null) goto L9;
        a.a(r5.d, r3, r1);     // Catch: Throwable -> L11
        return;
    L9:
        com.ss.android.lark.officesdk.utils.di.j.f(this.a, "dispatchMsgFromJS " + r5.e);     // Catch: Throwable -> L11
        return;
    L6:
        r3 = (tb5.i) ((ConcurrentHashMap) this.b).get(r2);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        String r0 = this.a;
        String r6 = th.getMessage();
        if (r6 != null) goto L15;
        r6 = "";
    L15:
        com.ss.android.lark.officesdk.utils.di.j.b(r0, r6);
    }

    public final void prompt(String r8) {
        Intrinsics.checkNotNullParameter(r8, INotificationHitPoint.NoticeType.MESSAGE);
        Message r1 = Message.c(r8);     // Catch: Throwable -> L10
        if (r8.length() <= 2097152) goto L7;
        com.ss.android.lark.officesdk.utils.di.j.b("ReportCrashUtils_" + this.a, r8.length() + "  " + r1.e);     // Catch: Throwable -> L10
    L7:
        if (TextUtils.isEmpty(r1.b) == false) goto L18;
        c(r1);     // Catch: Throwable -> L10
        return;
    L18:
        return;
    L10:
        th = move-exception;
        String r0 = this.a;
        String r9 = th.getMessage();
        if (r9 != null) goto L14;
        r9 = "";
    L14:
        com.ss.android.lark.officesdk.utils.di.j.b(r0, r9);
    }

    public final void b(String r8, String r9) {
        Intrinsics.checkNotNullParameter(r8, "callbackId");
        Intrinsics.checkNotNullParameter(r9, "data");
        if (this.c == null) goto L32;
        String r10 = StringsKt.trimIndent("\n                LarkWebViewJavaScriptBridge.nativeCallBack({\n                callbackID: '" + r8 + "',\n                callbackType: 'success',\n                data: " + r9 + "\n                });\n                ");
        tb5.f.b r11 = this.c;
        int r0 = r10.length() - 1;
        int r3 = 0;
        boolean r4 = false;
    L5:
        if (r3 > r0) goto L20;
        if (r4 == true) goto L8;
        int r5 = r3;
    L10:
        if (Intrinsics.compare(r10.charAt(r5), 32) > 0) goto L12;
        boolean r6 = true;
    L13:
        if (r4 == false) goto L14;
        if (r6 == false) goto L20;
        r0 = r0 - 1;
        goto L5
    L14:
        if (r6 == false) goto L15;
        r3 = r3 + 1;
        goto L5
    L15:
        r4 = true;
        goto L5
    L12:
        r6 = false;
        goto L13
    L8:
        r5 = r0;
    L20:
        r11.b(r10.subSequence(r3, r0 + 1).toString());
        return;
    }
}
