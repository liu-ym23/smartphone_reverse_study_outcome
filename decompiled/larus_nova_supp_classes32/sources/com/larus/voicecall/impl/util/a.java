package com.larus.voicecall.impl.util;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.Context;
import android.view.accessibility.AccessibilityManager;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a {
    public static final boolean a(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L21
        Object r9 = r8.getSystemService("accessibility");     // Catch: Throwable -> L21
        if ((r9 instanceof AccessibilityManager) == false) goto L6;
        AccessibilityManager r10 = (AccessibilityManager) r9;     // Catch: Throwable -> L21
    L7:
        if (r10 != null) goto L11;
        FLogger.a.e("AccessibilityHelper", " isTalkBackEnabled accessibilityManager is null");     // Catch: Throwable -> L21
        return false;
    L11:
        if (r10.isEnabled() == true) goto L14;
        FLogger.a.e("AccessibilityHelper", " isTalkBackEnabled accessibilityManager not enabled");     // Catch: Throwable -> L21
        return false;
    L14:
        List<AccessibilityServiceInfo> r11 = r10.getEnabledAccessibilityServiceList(1);     // Catch: Throwable -> L21
        Iterator<AccessibilityServiceInfo> r3 = r11.iterator();     // Catch: Throwable -> L21
    L16:
        if (r3.hasNext() == false) goto L18;
        String r4 = r3.next().getResolveInfo().serviceInfo.name;     // Catch: Throwable -> L21
        FLogger.a.i("AccessibilityHelper", " isTalkBackEnabled not found TalkBack. service=" + r4);     // Catch: Throwable -> L21
        goto L16
    L18:
        Intrinsics.checkNotNull(r11);     // Catch: Throwable -> L21
        return !r11.isEmpty();
    L6:
        r10 = null;
    L21:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        Throwable r12 = Result.exceptionOrNull-impl(Result.constructor-impl(ResultKt.createFailure(th)));
        if (r12 == null) goto L26;
        FLogger.a.e("AccessibilityHelper", " isTalkBackEnabled error", r12);
    L26:
        FLogger.a.i("AccessibilityHelper", " isTalkBackEnabled finally return false");
        return false;
    }
}
