package com.obric.flow.cardlistpage.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import cn.nubia.neopush.commons.Constant;
import com.obric.oui.window.permission.WebViewActivity;
import com.zte.miboard.cards.AppCallbackUtils;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements AppCallbackUtils.AppCallback {
    @Override // com.zte.miboard.cards.AppCallbackUtils.AppCallback
    public final boolean jumpToWebView(Context r5, String r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r10, "url");
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L7
        if (r11 == null) goto L9;
        String r13 = r11.getString(Constant.TITLE);     // Catch: Throwable -> L7
    L10:
        if (r13 != null) goto L12;
        r13 = "";
    L12:
        Intrinsics.checkNotNullParameter(r5, "context");     // Catch: Throwable -> L7
        Intrinsics.checkNotNullParameter(r10, "url");     // Catch: Throwable -> L7
        Intrinsics.checkNotNullParameter(r13, Constant.TITLE);     // Catch: Throwable -> L7
        Intent r14 = new Intent(r5, WebViewActivity.class);     // Catch: Throwable -> L7
        r14.putExtra("extra_url", r10);     // Catch: Throwable -> L7
        r14.putExtra("extra_title", r13);     // Catch: Throwable -> L7
        if ((r5 instanceof Activity) == false) goto L15;
        r5.startActivity(r14);     // Catch: Throwable -> L7
    L16:
        Object r15 = Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L20:
        return Result.m131isSuccessimpl(r15);
    L15:
        r14.setFlags(276824064);     // Catch: Throwable -> L7
        r5.startActivity(r14);     // Catch: Throwable -> L7
        goto L16
    L9:
        r13 = null;
    L7:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r15 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L20
    }

    @Override // com.zte.miboard.cards.AppCallbackUtils.AppCallback
    public final boolean showDownloadAppDialog(Context r10, String r11, Drawable r12, String r13) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "pkgName");
        Intrinsics.checkNotNullParameter(r13, "name");
        if (r11.length() != 0) goto L6;
    L9:
        return false;
    L6:
        if (r13.length() == 0) goto L9;
        if (r12 == null) goto L9;
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "packageName");
        Intrinsics.checkNotNullParameter(r12, "appIcon");
        Intrinsics.checkNotNullParameter(r13, "appName");
        if (r11.length() != 0) goto L14;
        return false;
    L14:
        if (r13.length() == 0) goto L19;
        new Handler(Looper.getMainLooper()).post(new com.bytedance.ai.bridge.method.router.f(1, r10, r11, r12, r13));
        return true;
    L19:
        return false;
    }
}
