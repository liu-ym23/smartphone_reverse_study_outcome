package com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.excelpermission;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.SendHttpRequest;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.ExcelMessagePermissionBlock$generatePermChangeDialog$1$onItemClick$1;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.ExcelMessagePermissionBlock$hasChangePermission$2$1;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.sdk.SdkSender;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import okhttp3.FormBody;
import okhttp3.Request;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ExcelPermissionNetService {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(ExcelPermissionNetService$larkHttp$2.INSTANCE);
    }

    public static String a(String r3) {
        String r4 = "https://" + jcb.b.c().a("file") + "/api/file/permission/" + r3;
        Log.i("ExcelPermissionNetService", "excel change permission request url: " + r4);
        return r4;
    }

    public static String b(String r3) {
        String r4 = "https://" + jcb.b.c().a("file") + "/api/file/ability/" + r3;
        Log.i("ExcelPermissionNetService", "excel get permission request url: " + r4);
        return r4;
    }

    public static void c(String r5, int r6, final String r7, boolean r8, final ExcelMessagePermissionBlock$generatePermChangeDialog$1$onItemClick$1 r9) {
        Intrinsics.checkNotNullParameter(r5, "fileId");
        Intrinsics.checkNotNullParameter(r7, "userId");
        Intrinsics.checkNotNullParameter(r9, "callback");
        if (r8 == false) goto L5;
        String r0 = "new";
    L6:
        Log.i("ExcelPermissionNetService", "changeFilePermission request mode: ".concat(r0));
        boolean r1 = false;
        if (r8 == false) goto L21;
        Request r10 = new Request.Builder().url(a(r5)).header("Content-Type", "application/x-www-form-urlencoded").post(new FormBody.Builder().add("permission", String.valueOf(r6)).build()).build();
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L16
        if (r7.length() <= 0) goto L12;
        r1 = true;
    L12:
        if (r1 == false) goto L15;
        com.larksuite.framework.http.v2.internal.main.b r12 = ((com.larksuite.framework.http.v2.b) a.getValue()).a(new ExcelPermissionNetService$changePermissionWithLarkHttp$1$2(r7));     // Catch: Throwable -> L16
        Intrinsics.checkNotNull(r10);     // Catch: Throwable -> L16
        com.larksuite.framework.http.v2.c.c.a(r12, r10).enqueue(new a(r9));     // Catch: Throwable -> L16
        Object r13 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L16
    L18:
        Throwable r14 = Result.exceptionOrNull-impl(r13);
        if (r14 == null) goto L24;
        Log.e("ExcelPermissionNetService", "changeFilePermission failed, error: " + r14);
        return;
    L24:
        return;
    L15:
        throw new IllegalStateException("userId is empty".toString());     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L18
    L21:
        SendHttpRequest.Builder r16 = new SendHttpRequest.Builder().url(a(r5)).method(SendHttpRequest.Method.POST).headers(MapsKt.mapOf(new Pair[]{TuplesKt.to("Content-Type", "application/x-www-form-urlencoded"), TuplesKt.to("Cookie", "session=" + ChatCoreModule.a().getPassportDependency().Fc())}));
        ByteString.Companion.getClass();
        SdkSender.asynSendRequestNonWrap(Command.SEND_HTTP, r16.body(ByteString.a.b("permission=" + r6)), new ExcelPermissionNetService$changePermissionWithSdkSender$1(r9), b.a);
        return;
    L5:
        r0 = "legacy";
        goto L6
    }

    public static Object d(String r2, final String r3, boolean r4, ExcelMessagePermissionBlock$hasChangePermission$2$1.AnonymousClass1 r5, Continuation r6) {
        if (r4 == false) goto L5;
        String r0 = "new";
    L6:
        Log.i("ExcelPermissionNetService", "getFileAbility request mode: ".concat(r0));
        if (r4 == false) goto L24;
        Request r7 = new Request.Builder().url(b(r2)).get().build();
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L17
        if (r3.length() <= 0) goto L12;
        boolean r9 = true;
    L13:
        if (r9 == false) goto L16;
        com.larksuite.framework.http.v2.internal.main.b r10 = ((com.larksuite.framework.http.v2.b) a.getValue()).a(new ExcelPermissionNetService$getPermissionWithLarkHttp$1$2(r3));     // Catch: Throwable -> L17
        Intrinsics.checkNotNull(r7);     // Catch: Throwable -> L17
        com.larksuite.framework.http.v2.c.c.a(r10, r7).enqueue(new c(r5));     // Catch: Throwable -> L17
        Object r11 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L17
    L19:
        Throwable r12 = Result.exceptionOrNull-impl(r11);
        if (r12 == null) goto L23;
        Log.e("ExcelPermissionNetService", "getFileAbility failed, error: " + r12);
    L23:
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("userId is empty".toString());     // Catch: Throwable -> L17
    L12:
        r9 = false;
    L17:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L19
    L24:
        Object r14 = BuildersKt.withContext(Dispatchers.getIO(), new ExcelPermissionNetService$getPermissionWithSdkSender$2(r2, r5, null), r6);
        if (r14 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L29;
        r14 = Unit.INSTANCE;
    L29:
        if (r14 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L32;
        return r14;
    L32:
        return Unit.INSTANCE;
    L5:
        r0 = "legacy";
        goto L6
    }
}
