package com.bytedance.android.ec.core.utils;

import com.bytedance.ai.event.MessageIndication;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u0007J&\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/bytedance/android/ec/core/utils/ECLiveEntranceMonitor;", "", "()V", "TAG", "", "getNullStr", "obj", "trace", "", MessageIndication.MESSAGE_TYPE_MSG, com.bytedance.android.ec.core.event.a.KEY_LUBAN_TAG, "alertLocalTest", "", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECLiveEntranceMonitor {
    public static final ECLiveEntranceMonitor INSTANCE = null;
    public static final String TAG = "ECLiveMonitor";

    private ECLiveEntranceMonitor() {
    }

    @JvmStatic
    public static final String getNullStr(Object r0) {
        if (r0 != null) goto L4;
        return "null";
    L4:
        return "non-null";
    }

    static {
        INSTANCE = new ECLiveEntranceMonitor();
    }

    @JvmStatic
    public static final void trace(String r10, String r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, MessageIndication.MESSAGE_TYPE_MSG);
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L13
        dm.a.b r13 = dm.a.a;     // Catch: Throwable -> L13
        if (r11 == null) goto L7;
        String r14 = "ECLiveMonitor_".concat(r11);     // Catch: Throwable -> L13
        if (r14 == null) goto L7;
    L8:
        dm.a.a(r14).i(r10);     // Catch: Throwable -> L13
        if (r12 == false) goto L11;
        ECExceptionMonitor.c(r10);     // Catch: Throwable -> L13
    L11:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L13
        return;
    L7:
        r14 = TAG;
    L13:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public static /* synthetic */ void trace$default(String r0, String r1, boolean r10, int r11, Object r12) {
        if ((r11 & 2) == 0) goto L6;
        r1 = null;
    L6:
        if ((r11 & 4) == 0) goto L8;
        r10 = false;
    L8:
        trace(r0, r1, r10);
    }
}
