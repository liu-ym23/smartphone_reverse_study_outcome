package com.larus.community.impl.applet;

import android.app.Activity;
import android.content.ContextWrapper;
import android.content.Intent;
import android.net.Uri;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class a implements Function0 {
    public final /* synthetic */ Function0 a;

    public /* synthetic */ a(Function0 r1) {
        this.a = r1;
    }

    public final Object invoke() {
        Function0 r0 = this.a;
        AICreationAppletNavigator.a.getClass();
        List r1 = AICreationAppletNavigator.g();
        Activity r2 = AICreationAppletNavigator.e();
        if (r2 != null) goto L5;
        boolean r3 = false;
    L27:
        FLogger.a.i("AICreationAppletNavigator", "launchRememberedAICreationHome result=" + r3 + " stackSize=" + r1.size());
        if (r3 == true) goto L31;
        AICreationAppletNavigator.a.getClass();
        AICreationAppletNavigator.a(false);
    L31:
        return Boolean.valueOf(r3);
    L5:
        AppHost.Companion r5 = AppHost.a;
        ContextWrapper r6 = r5.a().getCurrentActivity();
        if (r6 != null) goto L32;
        r6 = r5.getApplication();
    L32:
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L17
        Intent r8 = new Intent(r6, r2.getClass());     // Catch: Throwable -> L17
        Intent r4 = r2.getIntent();     // Catch: Throwable -> L17
        if (r4 == null) goto L11;
        Uri r9 = r4.getData();     // Catch: Throwable -> L17
    L12:
        Intent r10 = r8.setData(r9).addFlags(537001984);     // Catch: Throwable -> L17
        if ((r6 instanceof Activity) == true) goto L15;
        r10.addFlags(268435456);     // Catch: Throwable -> L17
    L15:
        r6.startActivity(r10);     // Catch: Throwable -> L17
        Object r11 = Result.constructor-impl(Boolean.TRUE);     // Catch: Throwable -> L17
    L19:
        Throwable r12 = Result.exceptionOrNull-impl(r11);
        if (r12 == null) goto L26;
        FLogger.a.e("AICreationAppletNavigator", "bringActiveAICreationAppletToFront failed", r12);
        if (r0 == null) goto L25;
        r0.invoke();
    L25:
        r11 = Boolean.FALSE;
    L26:
        r3 = ((Boolean) r11).booleanValue();
        goto L27
    L11:
        r9 = null;
    L17:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L19
    }
}
