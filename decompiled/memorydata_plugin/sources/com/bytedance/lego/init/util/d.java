package com.bytedance.lego.init.util;

import android.util.Log;
import com.bytedance.lego.init.InitScheduler;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0007J\u001a\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0007J\u001a\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0007J\u0006\u0010\r\u001a\u00020\u000eJ\u001a\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/bytedance/lego/init/util/InitLogger;", "", "()V", "MAX_LENGTH", "", "TAG", "", "d", "", "classname", "message", "e", "i", "isDebug", "", BaseSwitches.V, "initscheduler_release"}, k = 1, mv = {1, 1, 13})
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f2800a = null;

    static {
        f2800a = new d();
    }

    private d() {
    }

    public static /* synthetic */ void a(d r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L5;
        r1 = "";
    L5:
        r0.a(r1, r2);
    }

    public static /* synthetic */ void b(d r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L5;
        r1 = "";
    L5:
        r0.b(r1, r2);
    }

    public static /* synthetic */ void c(d r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L5;
        r1 = "";
    L5:
        r0.c(r1, r2);
    }

    public final void a(String r9, String r10) {
        Intrinsics.checkParameterIsNotNull(r9, "classname");
        Intrinsics.checkParameterIsNotNull(r10, "message");
        if (InitScheduler.INSTANCE.isDebug$initscheduler_release() == true) goto L5;
        return;
    L5:
        String r8 = r9 + ' ' + r10;
        int r11 = r8.length();
        int r1 = 0;
        int r12 = 3072;
        int r2 = 1;
    L6:
        if (r2 > 100) goto L23;
        if (r11 <= r12) goto L14;
        String r5 = "#inittask#" + r2;
        if (r8 == null) goto L13;
        String r3 = r8.substring(r1, r12);
        Intrinsics.checkExpressionValueIsNotNull(r3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        Log.v(r5, r3);
        r2 = r2 + 1;
        r1 = r12;
        r12 = r12 + 3072;
        goto L6
    L13:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    L14:
        String r13 = "#inittask#" + r2;
        if (r8 == null) goto L18;
        String r14 = r8.substring(r1, r11);
        Intrinsics.checkExpressionValueIsNotNull(r14, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        Log.v(r13, r14);
        return;
    L18:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    public final boolean a() {
        return InitScheduler.INSTANCE.isDebug$initscheduler_release();
    }

    public final void b(String r9, String r10) {
        Intrinsics.checkParameterIsNotNull(r9, "classname");
        Intrinsics.checkParameterIsNotNull(r10, "message");
        if (InitScheduler.INSTANCE.isDebug$initscheduler_release() == true) goto L5;
        return;
    L5:
        String r8 = r9 + ' ' + r10;
        int r11 = r8.length();
        int r1 = 0;
        int r12 = 3072;
        int r2 = 1;
    L6:
        if (r2 > 100) goto L23;
        if (r11 <= r12) goto L14;
        String r5 = "#inittask#" + r2;
        if (r8 == null) goto L13;
        String r3 = r8.substring(r1, r12);
        Intrinsics.checkExpressionValueIsNotNull(r3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        Log.d(r5, r3);
        r2 = r2 + 1;
        r1 = r12;
        r12 = r12 + 3072;
        goto L6
    L13:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    L14:
        String r13 = "#inittask#" + r2;
        if (r8 == null) goto L18;
        String r14 = r8.substring(r1, r11);
        Intrinsics.checkExpressionValueIsNotNull(r14, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        Log.d(r13, r14);
        return;
    L18:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    public final void c(String r1, String r2) {
        Intrinsics.checkParameterIsNotNull(r1, "classname");
        Intrinsics.checkParameterIsNotNull(r2, "message");
        Log.e("#inittask#", r1 + ' ' + r2);
    }
}
