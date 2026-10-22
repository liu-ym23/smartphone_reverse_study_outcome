package qs9;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.larus.platform.spi.IAIChatService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static List b(Intent r8) {
        Intrinsics.checkNotNullParameter(r8, "<this>");
        Object r0 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L43
        ArrayList r2 = new ArrayList();     // Catch: Throwable -> L43
        String r3 = r8.getAction();     // Catch: Throwable -> L43
        if (ArraysKt.contains(new String[]{"android.intent.action.SEND", "android.intent.action.SEND_MULTIPLE"}, r3) == false) goto L17;
        Bundle r4 = r8.getExtras();     // Catch: Throwable -> L43
        if (r4 == null) goto L9;
        Object r5 = r4.get("android.intent.extra.STREAM");     // Catch: Throwable -> L43
    L11:
        if ((r5 instanceof Uri) == false) goto L13;
        r2.add(r5);     // Catch: Throwable -> L43
    L41:
        Object r6 = Result.constructor-impl(r2);     // Catch: Throwable -> L43
    L45:
        Throwable r7 = Result.exceptionOrNull-impl(r6);
        if (r7 != null) goto L48;
        r0 = r6;
    L49:
        List r9 = (List) r0;
        FLogger.a.i("ReceiveIntentServiceHelper", "parseUris, action:" + r8.getAction() + ",type:" + r8.getType() + ",uris:" + r9);
        return r9;
    L48:
        FLogger.a.e("ReceiveIntentServiceHelper", "parseUris failed:" + r7);
        goto L49
    L13:
        ArrayList r10 = r8.getParcelableArrayListExtra("android.intent.extra.STREAM");     // Catch: Throwable -> L43
        if (r10 == null) goto L41;
        r2.addAll(r10);     // Catch: Throwable -> L43
        goto L41
    L9:
        r5 = null;
        goto L11
    L17:
        if (Intrinsics.areEqual(r3, "android.intent.action.VIEW") == false) goto L41;
        Uri r11 = r8.getData();     // Catch: Throwable -> L43
        if (r11 == null) goto L41;
        String r12 = r8.getType();     // Catch: Throwable -> L43
        boolean r13 = true;
        if (r12 != null) goto L23;
    L25:
        boolean r14 = false;
    L26:
        if (r14 == true) goto L36;
        String r15 = r8.getType();     // Catch: Throwable -> L43
        if (r15 != null) goto L30;
    L32:
        boolean r16 = false;
    L33:
        if (r16 == true) goto L36;
        r13 = false;
        goto L36
    L30:
        if (StringsKt.startsWith$default(r15, "application/", false, 2, null) != true) goto L32;
        r16 = true;
    L36:
        if (r13 == true) goto L39;
        r11 = null;
    L39:
        if (r11 == null) goto L41;
        r2.add(r11);     // Catch: Throwable -> L43
        goto L41
    L23:
        if (StringsKt.startsWith$default(r12, "image/", false, 2, null) != true) goto L25;
        r14 = true;
    L43:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L45
    }

    public static void a(Context r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "bundle");
        IAIChatService r0 = (IAIChatService) ServiceManager.get().getService(IAIChatService.class);
        if (r0 == null) goto L6;
        r0.M7(r2, r3);
        return;
    }
}
