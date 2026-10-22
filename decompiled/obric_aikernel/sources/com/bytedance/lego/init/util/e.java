package com.bytedance.lego.init.util;

import com.bytedance.lego.init.InitScheduler;
import com.bytedance.lego.init.config.ProcessMatchMode;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import m3.g;

/* JADX INFO: loaded from: classes.dex */
public final class e {
    public static final boolean a(g r10) {
        Intrinsics.checkParameterIsNotNull(r10, "receiver$0");
        if (r10.f11034l.contains("all") == false) goto L5;
        return true;
    L5:
        List<String> r11 = r10.f11034l;
        InitScheduler r12 = InitScheduler.INSTANCE;
        if (r11.contains(r12.getConfig$initscheduler_release().getProcessName()) == false) goto L9;
        return true;
    L9:
        if (r12.getConfig$initscheduler_release().isMainProcess() == false) goto L13;
        return r10.f11034l.contains("main");
    L13:
        if (r10.f11034l.contains("nonmain") == false) goto L15;
        return true;
    L15:
        ProcessMatchMode r13 = r12.getProcessMatchMode$initscheduler_release();
        int r14 = d.f2122a[r13.ordinal()];
        if (r14 != 1) goto L18;
        List<String> r15 = r10.f11034l;
        Intrinsics.checkExpressionValueIsNotNull(r15, "runInProcess");
        Iterator<T> r16 = r15.iterator();
    L28:
        if (r16.hasNext() == false) goto L41;
        String r17 = (String) r16.next();
        String r18 = InitScheduler.INSTANCE.getConfig$initscheduler_release().getProcessName();
        Intrinsics.checkExpressionValueIsNotNull(r17, "it");
        if (StringsKt.endsWith(r18, r17, true) == false) goto L28;
        return true;
    L41:
        return false;
    L18:
        if (r14 != 2) goto L32;
        List<String> r19 = r10.f11034l;
        Intrinsics.checkExpressionValueIsNotNull(r19, "runInProcess");
        Iterator<T> r20 = r19.iterator();
    L22:
        if (r20.hasNext() == false) goto L40;
        String r21 = (String) r20.next();
        String r22 = InitScheduler.INSTANCE.getConfig$initscheduler_release().getProcessName();
        Intrinsics.checkExpressionValueIsNotNull(r21, "it");
        if (StringsKt.contains(r22, r21, true) == false) goto L22;
        return true;
    L40:
        return false;
    L32:
        return false;
    }

    public static final boolean b(g r10) {
        Intrinsics.checkParameterIsNotNull(r10, "receiver$0");
        return Intrinsics.areEqual("init_shceduler_internal_task", r10.f11030h);
    }
}
