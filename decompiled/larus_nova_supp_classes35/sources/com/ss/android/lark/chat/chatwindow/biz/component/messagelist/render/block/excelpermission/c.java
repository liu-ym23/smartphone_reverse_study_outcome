package com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.excelpermission;

import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.ExcelMessagePermissionBlock$hasChangePermission$2$1;
import com.ss.android.lark.log.Log;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.IOException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c implements Callback {
    public final /* synthetic */ IGetFilePermission a;

    public c(ExcelMessagePermissionBlock$hasChangePermission$2$1.AnonymousClass1 r1) {
        this.a = r1;
    }

    public final void onFailure(Call r2, IOException r3) {
        Intrinsics.checkNotNullParameter(r2, "call");
        Intrinsics.checkNotNullParameter(r3, "e");
        Log.e("ExcelPermissionNetService", "getFileAbility failed, error: " + r3);
    }

    public final void onResponse(Call r5, Response r6) {
        Intrinsics.checkNotNullParameter(r5, "call");
        Intrinsics.checkNotNullParameter(r6, "response");
        IGetFilePermission r7 = this.a;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L21
        int r3 = r6.code();     // Catch: Throwable -> L16
        Log.i("ExcelPermissionNetService", "getFileAbility success, http status code: " + r3);     // Catch: Throwable -> L16
        if (r3 != 200) goto L13;
        ResponseBody r4 = r6.body();     // Catch: Throwable -> L16
        if (r4 == null) goto L9;
        String r8 = r4.string();     // Catch: Throwable -> L16
    L10:
        if (r8 != null) goto L12;
        r8 = BuildConfig.FLAVOR;
    L12:
        r7.onSuccess(new JSONObject(r8));     // Catch: Throwable -> L16
        goto L13
    L9:
        r8 = null;
    L13:
        Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L16
        CloseableKt.closeFinally(r6, null);     // Catch: Throwable -> L21
        Object r10 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L21
    L23:
        Throwable r11 = Result.exceptionOrNull-impl(r10);
        if (r11 == null) goto L32;
        Log.e("ExcelPermissionNetService", "getFileAbility failed, error: " + r11);
        return;
    L32:
        return;
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        CloseableKt.closeFinally(r6, th);     // Catch: Throwable -> L21
        throw th;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L23
    }
}
