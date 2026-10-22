package com.bytedance.geckox.logger;

import android.util.Log;
import com.ss.android.agilelogger.ALog;
import kotlin.Metadata;
import kotlin.TypeCastException;
import oa.b;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/geckox/logger/DefaultLogger;", "Lcom/bytedance/geckox/logger/Logger;", "geckox_noasanRelease"}, k = 1, mv = {1, 4, 0})
public final class DefaultLogger implements Logger {
    public DefaultLogger() {
    }

    public final void a(String r5, Object... r10) {
        if (r10.length != 1) goto L12;
        Object r11 = r10[0];     // Catch: Throwable -> L14
        if ((r11 instanceof String) == false) goto L12;
        if (r11 == null) goto L11;
        ALog.i(r5, (String) r11);     // Catch: Throwable -> L14
        return;
    L11:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.String");     // Catch: Throwable -> L14
    L12:
        ALog.i(r5, b.f20421b.f20423a.toJson(r10));     // Catch: Throwable -> L14
        return;
    L15:
        if (r10.length != 1) goto L22;
        Object r12 = r10[0];
        if ((r12 instanceof String) == false) goto L22;
        if (r12 == null) goto L21;
        Log.d(r5, (String) r12);
        return;
    L21:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
    L22:
        Log.d(r5, b.f20421b.f20423a.toJson(r10));
    }

    public final void a(String r5) {
        ALog.w("gecko-debug-tag", r5);     // Catch: Throwable -> L5
        return;
    L5:
        Log.w("gecko-debug-tag", r5);
    }

    public final void a(String r5, String r10, Throwable r11) {
        ALog.e(r5, r10, r11);     // Catch: Throwable -> L4
        return;
    L4:
        Log.e(r5, r10, r11);
    }
}
