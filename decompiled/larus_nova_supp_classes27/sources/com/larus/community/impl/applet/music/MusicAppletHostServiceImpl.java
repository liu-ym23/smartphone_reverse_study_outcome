package com.larus.community.impl.applet.music;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import com.bytedance.ai.applet.app.AppletAppActivity;
import com.bytedance.ai.applet.app.AppletApplication;
import com.bytedance.ai.applet.services.AppletAppManagerService;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.router.SmartRouter;
import com.larus.common.apphost.AppHost;
import com.larus.uaigc.applet.IMusicAppletHostService;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0007H\u0016¨\u0006\u0011"}, d2 = {"Lcom/larus/community/impl/applet/music/MusicAppletHostServiceImpl;", "Lcom/larus/uaigc/applet/IMusicAppletHostService;", "<init>", "()V", "registerAppletApplication", "", "open", "", "arguments", "Landroid/os/Bundle;", "page", "", "routeMode", "navigateBack", "delta", "", "canNavigateBack", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MusicAppletHostServiceImpl implements IMusicAppletHostService {
    public MusicAppletHostServiceImpl() {
    }

    public final boolean b() {
        a.a.getClass();
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L16
        AppletAppManagerService.INSTANCE.getClass();     // Catch: Throwable -> L16
        AppletApplication r2 = AppletAppManagerService.a("db_2c90E66");     // Catch: Throwable -> L16
        if (r2 == null) goto L6;
        AppletAppActivity r3 = r2.d;     // Catch: Throwable -> L16
    L7:
        int r4 = 0;
        boolean r5 = false;
        if (r3 != null) goto L10;
        FLogger.a.e("MusicAppletNavigator", "navigate back failed, music applet activity is null");     // Catch: Throwable -> L16
    L14:
        Object r6 = Result.constructor-impl(Boolean.valueOf(r5));     // Catch: Throwable -> L16
    L18:
        Throwable r7 = Result.exceptionOrNull-impl(r6);
        if (r7 == null) goto L23;
        FLogger.a.e("MusicAppletNavigator", "navigate back in music applet failed", r7);
        r6 = Boolean.FALSE;
    L23:
        return ((Boolean) r6).booleanValue();
    L10:
        int r8 = RangesKt.coerceAtLeast(1, 1);     // Catch: Throwable -> L16
    L11:
        if (r4 >= r8) goto L13;
        r2.h().d().m(1);     // Catch: Throwable -> L16
        r4 = r4 + 1;     // Catch: Throwable -> L16
        goto L11
    L13:
        r5 = true;
        goto L14
    L6:
        r3 = null;
    L16:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L18
    }

    public final boolean c() {
        a.a.getClass();
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L15
        AppletAppManagerService.INSTANCE.getClass();     // Catch: Throwable -> L15
        AppletApplication r1 = AppletAppManagerService.a("db_2c90E66");     // Catch: Throwable -> L15
        if (r1 == null) goto L6;
        AppletAppActivity r2 = r1.d;     // Catch: Throwable -> L15
    L7:
        if (r2 == null) goto L12;
        Object r3 = r1.h().d().f();     // Catch: Throwable -> L15
        ResultKt.throwOnFailure(r3);     // Catch: Throwable -> L15
        boolean r4 = true;
        if (((List) r3).size() <= 1) goto L12;
    L13:
        Object r5 = Result.constructor-impl(Boolean.valueOf(r4));     // Catch: Throwable -> L15
    L17:
        Throwable r6 = Result.exceptionOrNull-impl(r5);
        if (r6 == null) goto L22;
        FLogger.a.e("MusicAppletNavigator", "query music applet page stack failed", r6);
        r5 = Boolean.FALSE;
    L22:
        return ((Boolean) r5).booleanValue();
    L12:
        r4 = false;
        goto L13
    L6:
        r2 = null;
    L15:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L17
    }

    public final void a() {
        h29.a.a();
    }

    public final boolean d(Bundle r7, String r8, String r9) {
        Intrinsics.checkNotNullParameter(r7, "arguments");
        Intrinsics.checkNotNullParameter(r8, "page");
        Intrinsics.checkNotNullParameter(r9, "routeMode");
        a.a.getClass();
        Intrinsics.checkNotNullParameter(r7, "arguments");
        Intrinsics.checkNotNullParameter(r8, "page");
        Intrinsics.checkNotNullParameter(r9, "routeMode");
        Activity r1 = AppHost.a.a().getCurrentActivity();
        if (r1 != null) goto L5;
        FLogger.a.e("MusicAppletNavigator", "open music applet failed, current activity is null, page=" + r8);
        return false;
    L5:
        Bundle r3 = new Bundle(r7);
        r3.putString("path", r8);
        Bundle r4 = MusicGenerationAppletApplication.p;
        Intrinsics.checkNotNullParameter(r3, "arguments");
        MusicGenerationAppletApplication.p = new Bundle(r3);
        h29.a.a();
        Uri.Builder r10 = UriProtector.parse("sslocal://doubao_apps").buildUpon().appendQueryParameter("app_id", "db_2c90E66").appendQueryParameter("path", r8).appendQueryParameter("route_mode", r9);
        String r11 = r3.getString("data_key");
        if (r11 == null) goto L8;
        r10.appendQueryParameter("data_key", r11);
    L8:
        String r12 = r10.build().toString();
        FLogger.a.i("MusicAppletNavigator", "open music applet url=" + r12);
        SmartRouter.buildRoute(r1, r12).d();
        return true;
    }
}
