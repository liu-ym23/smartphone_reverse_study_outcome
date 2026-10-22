package com.obric.framework.inputmethod.api;

import android.app.ITopActivityAssistDataReceiver;
import android.app.assist.AssistStructure;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\n"}, d2 = {"com/obric/framework/inputmethod/api/ObricInjectTextResponseCallback$stub$2$1", "Landroid/app/ITopActivityAssistDataReceiver$Stub;", "onResultData", "", "requestId", "", "resultData", "Landroid/os/Bundle;", "onScreenshotData", "screenshotData", "product-platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricInjectTextResponseCallback$stub$2$1 extends ITopActivityAssistDataReceiver.Stub {
    final /* synthetic */ b this$0;

    public void onScreenshotData(int r1, Bundle r2) {
    }

    public ObricInjectTextResponseCallback$stub$2$1(b r1) {
    }

    public void onResultData(int r4, Bundle r5) {
        c.a.getClass();
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L9
        if (r5 == null) goto L6;
        Object r1 = r5.get("obric.inject_text.type");     // Catch: Throwable -> L9
    L7:
        Object r2 = Result.constructor-impl(r1);     // Catch: Throwable -> L9
    L12:
        if (Result.isFailure-impl(r2) == false) goto L15;
        r2 = null;
    L15:
        if ((r2 instanceof Integer) == false) goto L17;
        Integer r3 = (Integer) r2;
    L18:
        boolean r6 = true;
        if (r3 == null) goto L29;
        int r7 = r3.intValue();
        if (r7 == 0) goto L28;
        if (r7 != 1) goto L24;
        ObricInjectTextResponseType r8 = ObricInjectTextResponseType.ABNORMAL;
    L30:
        c.a.getClass();
        Intrinsics.checkNotNullParameter(r8, "type");
        if (r8 == ObricInjectTextResponseType.NORMAL) goto L35;
        if (r8 == ObricInjectTextResponseType.ABNORMAL) goto L35;
        throw null;
    L35:
        if (r5 != null) goto L37;
    L39:
        r6 = false;
    L40:
        if (r6 == false) goto L62;
    L50:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        Object r10 = Result.constructor-impl(ResultKt.createFailure(th));
    L53:
        if (Result.isFailure-impl(r10) == false) goto L55;
        r10 = null;
    L55:
        AssistStructure r11 = (AssistStructure) r10;
        throw null;
    L42:
        if (Build.VERSION.SDK_INT < 33) goto L44;
        AssistStructure r12 = (AssistStructure) r5.getParcelable("obric.inject_text.view_tree", AssistStructure.class);     // Catch: Throwable -> L50
    L48:
        r10 = Result.constructor-impl(r12);     // Catch: Throwable -> L50
        goto L53
    L44:
        Parcelable r13 = r5.getParcelable("obric.inject_text.view_tree");     // Catch: Throwable -> L50
        if ((r13 instanceof AssistStructure) == false) goto L47;
        r12 = (AssistStructure) r13;     // Catch: Throwable -> L50
        goto L48
    L47:
        r12 = null;
        goto L48
    L62:
        throw null;
    L37:
        if (r5.containsKey("obric.inject_text.view_tree") != true) goto L39;
    L24:
        if (r7 == 2) goto L26;
        r8 = ObricInjectTextResponseType.UNKNOWN;
        goto L30
    L26:
        r8 = ObricInjectTextResponseType.SECURE;
        goto L30
    L28:
        r8 = ObricInjectTextResponseType.NORMAL;
        goto L30
    L29:
        r8 = ObricInjectTextResponseType.UNKNOWN;
        goto L30
    L17:
        r3 = null;
        goto L18
    L6:
        r1 = null;
    L9:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    }
}
