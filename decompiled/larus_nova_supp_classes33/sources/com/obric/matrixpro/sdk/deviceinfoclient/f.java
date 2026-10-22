package com.obric.matrixpro.sdk.deviceinfoclient;

import android.content.Context;
import android.database.Cursor;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class f extends Handler {
    public f(Looper r1) {
        super(r1);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message r9) {
        Intrinsics.checkNotNullParameter(r9, "msg");
        if (r9.what != 1) goto L48;
        Object r10 = r9.obj;
        if (r10 == null) goto L47;
        a.b r11 = (a.b) r10;
        a r1 = a.e;
        Context r2 = r11.getContext();
        a.InterfaceC0042a r12 = r11.b;
        r1.getClass();
        Cursor r3 = a.a(r2.getContentResolver(), UriProtector.parse("content://com.bytedance.securityserver.deviceInfoProvider/get_osdid"));     // Catch: Exception -> L41
        if (r3 == null) goto L36;
        Cursor r4 = r3;     // Catch: Exception -> L41
        Cursor r5 = r4;     // Catch: Throwable -> L31
        if (r5.moveToFirst() == true) goto L18;
        Handler r6 = a.c;     // Catch: Throwable -> L31
        if (r6 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mainHandler");     // Catch: Throwable -> L31
    L15:
        r6.post(new c(r12));     // Catch: Throwable -> L31
        CloseableKt.closeFinally(r4, null);     // Catch: Exception -> L41
        return;
    L18:
        int r7 = r5.getColumnIndex("osdid");     // Catch: Throwable -> L31
        int r8 = r5.getColumnIndex("error");     // Catch: Throwable -> L31
        if (r8 < 0) goto L21;
        String r13 = r5.getString(r8);     // Catch: Throwable -> L31
    L22:
        if (r7 < 0) goto L24;
        String r14 = r5.getString(r7);     // Catch: Throwable -> L31
    L25:
        Handler r15 = a.c;     // Catch: Throwable -> L31
        if (r15 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("mainHandler");     // Catch: Throwable -> L31
    L28:
        r15.post(new d(r13, r14, r12));     // Catch: Throwable -> L31
        CloseableKt.closeFinally(r4, null);     // Catch: Exception -> L41
        return;
    L24:
        r14 = null;
        goto L25
    L21:
        r13 = null;
    L31:
        th = move-exception;
        throw th;     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        CloseableKt.closeFinally(r4, th);     // Catch: Exception -> L41
        throw th;     // Catch: Exception -> L41
    L36:
        Handler r16 = a.c;     // Catch: Exception -> L41
        if (r16 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("mainHandler");     // Catch: Exception -> L41
    L39:
        r16.post(new b(r12));     // Catch: Exception -> L41
        return;
    L41:
        e = move-exception;
        int r17 = g.a;
        Intrinsics.checkNotNullParameter("OsDidClient", "tag");
        Intrinsics.checkNotNullParameter("查询OSDID异常", "msg");
        Handler r0 = a.c;
        if (r0 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("mainHandler");
    L45:
        r0.post(new e(r12, e));
        return;
    L47:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.matrixpro.sdk.deviceinfoclient.DeviceInfoGetter.OsDidRequest");
    }
}
