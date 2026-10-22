package com.obric.matrix.platform.sdk.ones.internal.config;

import android.app.KeyguardManager;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import androidx.room.util.CursorUtil;
import com.obric.matrix.proto.SdkAllConfig;
import com.obric.matrix.proto.SdkSendCmdConfig;
import io.reactivex.Observable;
import io.reactivex.disposables.b;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import z8.c;

/* JADX INFO: loaded from: classes2.dex */
public final class SdkConfigManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SdkConfigManager f5883a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f5884b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static SdkAllConfig f5885c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Lazy f5886d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static b f5887e;

    static {
        f5883a = new SdkConfigManager();
        f5886d = LazyKt.lazy(SdkConfigManager$keyguardManager$2.INSTANCE);
    }

    private SdkConfigManager() {
    }

    public static /* synthetic */ void a(Long r10) {
        e(r10);
    }

    private final KeyguardManager b() {
        return (KeyguardManager) f5886d.getValue();
    }

    private final void d() {
        b r10 = f5887e;
        if (r10 == null) goto L5;
        r10.dispose();
    L5:
        SdkAllConfig r11 = f5885c;
        if (r11 == null) goto L10;
        SdkSendCmdConfig r12 = r11.sdkSendCmdConfig;
        if (r12 == null) goto L10;
        Integer r13 = r12.pollingInterval;
    L11:
        if (r13 != null) goto L13;
    L15:
        int r14 = 30;
    L16:
        e9.b.b("SdkConfigManager", "startPolling, realInterval: " + r14 + ", interval: " + r13, null, 4, null);
        long r15 = (long) r14;
        f5887e = Observable.b(r15, r15, TimeUnit.MINUTES).g(ec.a.b()).d(a.f5888c);
        return;
    L13:
        if (r13.intValue() <= 0) goto L15;
        r14 = r13.intValue();
    L10:
        r13 = null;
        goto L11
    }

    private static final void e(Long r10) {
        SdkConfigManager r11 = f5883a;
        KeyguardManager r12 = r11.b();
        if (r12 != null) goto L5;
        Unit r13 = null;
    L10:
        if (r13 != null) goto L13;
        e9.b.k("SdkConfigManager", "keyguardManager 为空，无法判断锁屏状态，跳过本次更新", null, 4, null);
        return;
    L13:
        return;
    L5:
        if (r12.isKeyguardLocked() == true) goto L7;
        r11.f();
        com.obric.matrix.platform.sdk.ones.internal.tunnel.b.f5893a.f();
    L8:
        r13 = Unit.INSTANCE;
        goto L10
    L7:
        e9.b.b("SdkConfigManager", "设备处于锁屏状态，跳过本次配置更新", null, 4, null);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void f() {
        CursorUtil.AnonymousClass2 r10 = 0;
        e9.b.b("SdkConfigManager", "updateConfigByProvider", null, 4, null);
        Context r11 = c.f13804a.e();     // Catch: Throwable -> L23 Exception -> L25
        Intrinsics.checkNotNull(r11);     // Catch: Throwable -> L23 Exception -> L25
        ContentResolver r12 = r11.getContentResolver();     // Catch: Throwable -> L23 Exception -> L25
        e9.b.b("SdkConfigManager", "Uri content://com.obric.matrix.sdk.settings.provider/get_settings_config", null, 4, null);     // Catch: Throwable -> L23 Exception -> L25
        Cursor r13 = r12.query(Uri.parse("content://com.obric.matrix.sdk.settings.provider/get_settings_config"), null, null, null);     // Catch: Throwable -> L23 Exception -> L25
        if (r13 != null) goto L8;
        e9.b.b("SdkConfigManager", "get sdk config items is null", null, 4, null);     // Catch: Exception -> L21 Throwable -> L34
        return;
    L8:
        if (r13.moveToNext() == false) goto L20;
        int r14 = r13.getColumnIndex("all_config_str");     // Catch: Exception -> L21 Throwable -> L34
        if (r14 < 0) goto L12;
        e9.b.b("SdkConfigManager", "get all config str = " + r13.getString(r14), null, 4, null);     // Catch: Exception -> L21 Throwable -> L34
    L12:
        int r15 = r13.getColumnIndex("sdk_all_config");     // Catch: Exception -> L21 Throwable -> L34
        if (r15 < 0) goto L8;
        byte[] r16 = r13.getBlob(r15);     // Catch: Exception -> L21 Throwable -> L34
        if (r16 == null) goto L18;
        e9.b.b("SdkConfigManager", "SdkAllConfigBytes != null ", null, 4, null);     // Catch: Exception -> L21 Throwable -> L34
        f5885c = SdkAllConfig.ADAPTER.decode(r16);     // Catch: Exception -> L21 Throwable -> L34
        String r17 = "sdk all config: " + f5885c;     // Catch: Exception -> L21 Throwable -> L34
    L17:
        e9.b.b("SdkConfigManager", r17, null, 4, null);     // Catch: Exception -> L21 Throwable -> L34
        goto L8
    L18:
        r17 = "SdkAllConfigBytes == null ";
    L20:
        r13.close();
    L31:
        if (f5884b == true) goto L47;
        f5884b = true;
        d();
        return;
    L47:
        return;
    L21:
        Exception e10 = e;
    L27:
        e9.b.c("SdkConfigManager", "get settings config error ", e10);     // Catch: Throwable -> L34
        if (r13 == null) goto L31;
    L34:
        th = th;
        r10 = "updateConfigByProvider";
    L36:
        if (r10 == 0) goto L38;
        r10.close();
    L38:
        throw th;
    L25:
        e = move-exception;
        e10 = e;
        r13 = null;
    L23:
        th = th;
        goto L36
    }

    public final SdkAllConfig c() {
        SdkAllConfig r10 = f5885c;
        if (r10 == null) goto L5;
        return r10;
    L5:
        f();
        return f5885c;
    }
}
