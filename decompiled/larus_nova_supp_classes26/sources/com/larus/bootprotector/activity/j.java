package com.larus.bootprotector.activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.widget.LinearLayout;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import com.larus.bootprotector.IBootProtectorBizCallback;
import com.larus.bootprotector.entity.LastException;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.p0;
import com.larus.settings.provider.bootprotector.CrashPortrait;
import com.obric.assistant.spi.bootprotector.ObricBootProtectorSPIServiceDelegate;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class j implements p0 {
    public final /* synthetic */ BootProtectorLandingActivity a;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [android.app.Activity, androidx.appcompat.app.AppCompatActivity, com.larus.bootprotector.activity.BootProtectorLandingActivity, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v25, types: [int] */
    /* JADX WARN: Type inference failed for: r2v33 */
    /* JADX WARN: Type inference failed for: r2v34 */
    public final void confirm() {
        final ?? r0 = this.a;
        int r1 = BootProtectorLandingActivity.b;
        r0.getClass();
        nu8.a.e("BootProtectorLandingAct", "BootProtectorLandingActivity go to download");
        long r2 = SystemClock.elapsedRealtime();
        if ((r2 - r0.a) >= 500) goto L5;
        nu8.a.e("BootProtectorLandingAct", "onDownloadBtnClick ignored by debounce");
        return;
    L5:
        r0.a = r2;
        BootProtectorLandingActivity.A1();
        ((LinearLayout) r0.findViewById(2131378741)).setVisibility(4);
        ObricBootProtectorSPIServiceDelegate r3 = ObricBootProtectorSPIServiceDelegate.b;
        boolean r4 = r3.b();
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L8
        Object r6 = Result.constructor-impl(Boolean.valueOf(r3.f(r0)));     // Catch: Throwable -> L8
    L10:
        Boolean r7 = Boolean.FALSE;
        if (Result.isFailure-impl(r6) == false) goto L13;
        r6 = r7;
    L13:
        boolean r8 = ((Boolean) r6).booleanValue();
        if (r8 == false) goto L16;
        nu8.a.e("BootProtectorLandingAct", "onDownloadBtnClick: handled by host self-upgrade download");
        ?? r9 = r8;
    L42:
        hu8.a.b("bootprotector_click_download", r9);
        int r10 = au8.b.a;
        au8.b.a("bootprotector_click_btn", com.larus.utils.f.c(new Pair[]{TuplesKt.to("click", "download")}));
        Pair[] r11 = new Pair[1];
        if (r9 == 0) goto L45;
        String r12 = "1";
    L46:
        r11[0] = TuplesKt.to("result", r12);
        au8.b.a("bootprotector_download_result", com.larus.utils.f.c(r11));
        if (r9 == 0) goto L49;
        nu8.a.e("BootProtectorLandingAct", "BootProtectorLandingActivity onDownloadBtnClick success");
        r0.F1();
        new Handler(Looper.getMainLooper()).postDelayed(new e(r0), 3500);
        return;
    L49:
        nu8.a.b("BootProtectorLandingAct", "BootProtectorLandingActivity onDownloadBtnClick fail");
        return;
    L45:
        r12 = TriggerSendLoading.NO_LOADING;
        goto L46
    L16:
        if (r4 == false) goto L18;
        nu8.a.e("BootProtectorLandingAct", "onDownloadBtnClick: obric handled, no url this time, skip market fallback");
        r9 = r8;
        goto L42
    L18:
        Lazy r13 = du8.b.a;
        LastException r14 = hu8.e.h();
        int r15 = hu8.e.g();
        if (r14 == null) goto L33;
        if (r15 <= 0) goto L33;
        if (hu8.e.b().getEnableBizCallback() == true) goto L25;
        nu8.a.b("BootProtectorCBDispatcher", "onBootProtectorDownloadBtnClick enableBizCallback is false!");
    L34:
        nu8.a.e("BootProtectorLandingAct", "onDownloadBtnClick: execute default downloading");
        Context r16 = r0.getBaseContext();
        String r17 = AppHost.a.getApplication().getPackageName();
        Uri r18 = UriProtector.parse("market://details?id=" + r17);
        nu8.a.e("BootProtectorLandingAct", "gotoMarket uri = " + r18);
        Intent r19 = new Intent("android.intent.action.VIEW", r18);
        r19.addFlags(268435456);
    L40:
        nu8.a.b("BootProtectorLandingAct", "gotoMarket something error");
    L41:
        r9 = 0;
        goto L42
    L36:
        if (r19.resolveActivity(r16.getPackageManager()) == null) goto L38;
        r16.startActivity(r19);     // Catch: Exception -> L40
        r9 = 1;
        goto L42
    L38:
        nu8.a.b("BootProtectorLandingAct", "can not find market app:" + r17);     // Catch: Exception -> L40
        goto L41
    L25:
        du8.b.d();
        Iterator r20 = du8.b.a(r15, r14).values().iterator();
    L27:
        if (r20.hasNext() == false) goto L34;
        Pair r21 = (Pair) r20.next();
        nu8.a.e("BootProtectorCBDispatcher", "onBootProtectorDownloadBtnClick bizTag: " + ((IBootProtectorBizCallback) r21.getFirst()).getBizTag() + ", crashPortrait: " + r21.getSecond() + ", lastException: " + r14);
        IBootProtectorBizCallback r22 = (IBootProtectorBizCallback) r21.getFirst();     // Catch: Exception -> L31
        CrashPortrait r23 = (CrashPortrait) r21.getSecond();     // Catch: Exception -> L31
        r22.e(r14);     // Catch: Exception -> L31
    L31:
        e = move-exception;
        nu8.a.b("BootProtectorCBDispatcher", "onBootProtectorDownloadBtnClick error: " + e.getMessage());
    L33:
        nu8.a.b("BootProtectorCBDispatcher", "onBootProtectorDownloadBtnClick currentCrashCount " + r15 + ", lastException " + r14 + '!');
    L8:
        th = move-exception;
        Result.Companion r24 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }

    public j(BootProtectorLandingActivity r1) {
        this.a = r1;
    }
}
