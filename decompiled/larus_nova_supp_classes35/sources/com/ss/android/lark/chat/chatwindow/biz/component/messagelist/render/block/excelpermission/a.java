package com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.excelpermission;

import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.ExcelMessagePermissionBlock$generatePermChangeDialog$1$onItemClick$1;
import com.ss.android.lark.log.Log;
import java.io.IOException;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a implements Callback {
    public final /* synthetic */ IGetFilePermission a;

    public a(ExcelMessagePermissionBlock$generatePermChangeDialog$1$onItemClick$1 r1) {
        this.a = r1;
    }

    public final void onFailure(Call r2, IOException r3) {
        Intrinsics.checkNotNullParameter(r2, "call");
        Intrinsics.checkNotNullParameter(r3, "e");
        Log.e("ExcelPermissionNetService", "changeFilePermission failed, error: " + r3);
    }

    public final void onResponse(Call r5, Response r6) {
        Intrinsics.checkNotNullParameter(r5, "call");
        Intrinsics.checkNotNullParameter(r6, "response");
        IGetFilePermission r7 = this.a;
        int r1 = r6.code();     // Catch: Throwable -> L9
        Log.i("ExcelPermissionNetService", "changeFilePermission success, http status code: " + r1);     // Catch: Throwable -> L9
        if (r1 != 200) goto L6;
        r7.onSuccess();     // Catch: Throwable -> L9
    L6:
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L9
        CloseableKt.closeFinally(r6, null);
        return;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        CloseableKt.closeFinally(r6, th);
        throw th;
    }
}
