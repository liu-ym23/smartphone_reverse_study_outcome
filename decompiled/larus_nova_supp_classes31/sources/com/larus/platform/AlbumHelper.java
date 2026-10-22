package com.larus.platform;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.activity.result.ActivityResultLauncher;
import androidx.fragment.app.Fragment;
import com.larus.home.impl.sdk.d;
import com.larus.platform.api.g3;
import com.larus.platform.model.album.AlbumSelectItem;
import com.larus.platform.model.album.AlbumSettingConfig;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.k2;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import xp9.b;
import xp9.c;
import xp9.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class AlbumHelper {
    public static final Lazy<Handler> e = null;
    public ActivityResultLauncher<String> a;
    public ActivityResultLauncher<String> b;
    public ActivityResultLauncher<Intent> c;
    public ActivityResultLauncher<Intent> d;

    public static final class a {
    }

    public AlbumHelper() {
    }

    static {
        e = LazyKt.lazy(new xp9.a());
    }

    public static /* synthetic */ void c(AlbumHelper r1, Fragment r2, Function1 r3) {
        r1.b(r2, "album_helper", r3);
    }

    public final void b(Fragment r2, String r3, Function1<? super AlbumSelectItem, Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "resultScene");
        Intrinsics.checkNotNullParameter(r4, "onSuccess");
        a(r2, r3, new b(), r4);
    }

    public final void e(Fragment r2, String r3, Function1<? super i, Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "resultScene");
        Intrinsics.checkNotNullParameter(r4, "onSuccess");
        d(r2, r3, null, r4);
    }

    public final void a(final Fragment r9, final String r10, final Function0<Unit> r11, final Function1<? super AlbumSelectItem, Unit> r12) {
        Intrinsics.checkNotNullParameter(r9, "fragment");
        Intrinsics.checkNotNullParameter(r10, "resultScene");
        Intrinsics.checkNotNullParameter(r11, "onSend");
        Intrinsics.checkNotNullParameter(r12, "onSuccess");
        r9.getLifecycle().addObserver(new AlbumHelper$registerResultForAlbum$2(this, r9, r10, r11, r12));
    }

    public final void d(final Fragment r9, final String r10, final Function0<Unit> r11, final Function1<? super i, Unit> r12) {
        Intrinsics.checkNotNullParameter(r9, "fragment");
        Intrinsics.checkNotNullParameter(r10, "resultScene");
        Intrinsics.checkNotNullParameter(r12, "onSuccess");
        r9.getLifecycle().addObserver(new AlbumHelper$registerResultForAlbumMulti$1(this, r9, r10, r11, r12));
    }

    public static void f(final AlbumHelper r20, Fragment r21, final AlbumSettingConfig r22, final Function0 r23, final Function0 r24, final String r25, final String r26, final int r27, final String r28, final String r29, String r30, Boolean r31, Bundle r32, int r33) {
        if ((r33 & 512) == 0) goto L5;
        final String r10 = null;
    L7:
        if ((r33 & 1024) == 0) goto L9;
        final Boolean r11 = null;
    L11:
        if ((r33 & 2048) == 0) goto L13;
        final Bundle r13 = null;
    L14:
        r20.getClass();
        Intrinsics.checkNotNullParameter(r21, "fragment");
        Intrinsics.checkNotNullParameter(r22, "albumConfig");
        Intrinsics.checkNotNullParameter(r23, "onSuccess");
        Intrinsics.checkNotNullParameter(r24, "onFail");
        AccountService r0 = AccountService.a;
        boolean r4 = false;
        if (r0.isLogin().booleanValue() == true) goto L24;
        IFlowSdkDepend r3 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r3 == null) goto L21;
        r3.getAccountService();
        if (d.a.M() != true) goto L21;
        boolean r5 = true;
    L22:
        if (r5 == true) goto L24;
        ((Handler) e.getValue()).post(new xp9.d());
        FLogger.a.i("AlbumHelper", "checkTourist, isLogin:" + r0.isLogin().booleanValue());
        r4 = true;
    L21:
        r5 = false;
    L24:
        if (r4 == false) goto L26;
        r24.invoke();
        return;
    L26:
        FLogger.a.i("AlbumHelper", "takeByAlbum");
        k2 r1 = k2.a;
        g3.a.a(r21, null, false, Boolean.valueOf(r22.getSupportVideo()), false, new c(r25, r26, r27, r28, r29, r22, r10, r11, r20, r13, r23, r24), 22);
        return;
    L13:
        r13 = r32;
        goto L14
    L9:
        r11 = r31;
        goto L11
    L5:
        r10 = r30;
        goto L7
    }
}
