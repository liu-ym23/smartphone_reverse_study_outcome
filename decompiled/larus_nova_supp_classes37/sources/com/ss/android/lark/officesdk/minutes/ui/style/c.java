package com.ss.android.lark.officesdk.minutes.ui.style;

import android.content.Context;
import android.content.ContextWrapper;
import com.larksuite.framework.utils.DevEnvUtil;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import java.util.ArrayList;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class c {
    public static final MmRecordingUILaunchMode a(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Context r0 = r4;
    L4:
        if ((r0 instanceof ContextWrapper) == false) goto L10;
        if ((r0 instanceof MmUIStyleContextWrapper) == true) goto L8;
        r0 = ((ContextWrapper) r0).getBaseContext();
        goto L4
    L8:
        return ((MmUIStyleContextWrapper) r0).a;
    L10:
        int r1 = bwb.b.a;
        bwb.b.d(MmUiLogScene.STYLE, "findMmUiLaunchMode", "uiLaunchMode not found, context=".concat(r4.getClass().getName()), null);
        b(r4, "findMmUiLaunchMode:notFound");
        return MmRecordingUILaunchMode.UNKNOWN;
    }

    public static void b(Context r22, String r23) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Object r1 = Result.constructor-impl(Boolean.valueOf(DevEnvUtil.isDebugMode(r22)));     // Catch: Throwable -> L4
    L6:
        Boolean r2 = Boolean.FALSE;
        if (Result.isFailure-impl(r1) == false) goto L10;
        r1 = r2;
    L10:
        if (((Boolean) r1).booleanValue() == false) goto L32;
        int r3 = bwb.b.a;
        MmUiLogScene r4 = MmUiLogScene.STYLE;
        StringBuilder r5 = new StringBuilder();
        r5.append("");
        r5.append("contextChain=");
        ArrayList r6 = new ArrayList();
        Context r7 = r22;
    L14:
        if (r7 == null) goto L22;
        r6.add(r7.getClass().getName());
        if ((r7 instanceof ContextWrapper) == false) goto L18;
        ContextWrapper r8 = (ContextWrapper) r7;
    L19:
        if (r8 != null) goto L20;
        r7 = null;
        goto L14
    L20:
        r7 = r8.getBaseContext();
        goto L14
    L18:
        r8 = null;
        goto L19
    L22:
        r5.append(CollectionsKt.joinToString$default(r6, " -> ", null, null, 0, null, null, 62, null));
        r5.append(", callChain=");
        r5.append(CollectionsKt.joinToString$default(CollectionsKt.take(ArraysKt.drop(new Throwable().getStackTrace(), 3), 12), " <- ", null, null, 0, null, MmUIStyleContextWrapperKt$describeCallChain$1.INSTANCE, 30, null));
        bwb.b.g(r4, r23, r5.toString(), null, 8);
        return;
    L32:
        return;
    L4:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L6
    }

    public static final Context c(Context r4, MmRecordingUILaunchMode r5) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        if (r5 != null) goto L6;
        r5 = MmRecordingUILaunchMode.UNKNOWN;
    L6:
        if (r5 != MmRecordingUILaunchMode.UNKNOWN) goto L9;
        int r0 = bwb.b.a;
        bwb.b.d(MmUiLogScene.STYLE, "withMmUiLaunchMode", "uiLaunchMode is UNKNOWN, context=".concat(r4.getClass().getName()), null);
        b(r4, "withMmUiLaunchMode:unknown targetMode=" + r5);
    L9:
        if ((r4 instanceof MmUIStyleContextWrapper) == false) goto L14;
        if (((MmUIStyleContextWrapper) r4).a != r5) goto L14;
        return r4;
    L14:
        return new MmUIStyleContextWrapper(r4, r5);
    }
}
