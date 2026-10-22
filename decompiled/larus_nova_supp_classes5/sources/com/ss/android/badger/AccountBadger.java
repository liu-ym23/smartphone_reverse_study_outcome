package com.ss.android.badger;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.badger.Badger;
import com.bytedance.badger.network.z;
import com.bytedance.sdk.account.impl.j;
import com.ss.android.account.k;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.json.JSONObject;
import wqa.f;
import wqa.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class AccountBadger implements ta7.c {
    public static final /* synthetic */ KProperty[] a = null;
    public static j b;
    public static final AtomicBoolean c = null;
    public static final AtomicBoolean d = null;
    public static final Lazy e = null;
    public static final AccountBadger f = null;

    public static final class AccountBadgerInitParams implements com.bytedance.badger.a {
        public static final AccountBadgerInitParams a = null;

        public AccountBadgerInitParams() {
        }

        static {
            a = new AccountBadgerInitParams();
        }

        public final int getAppId() {
            f r0 = k.b;
            if (r0 != null) goto L7;
            return -1;
        L7:
            return r0.appId();
        }

        public final z64.a getExtraParams() {
            long r3 = k.k;
            AccountBadger.f.getClass();
            Lazy r0 = AccountBadger.e;
            KProperty r5 = AccountBadger.a[0];
            SharedPreferences r1 = (SharedPreferences) r0.getValue();
            long r6 = 0;
            if (r1 == null) goto L6;
            r6 = r1.getLong("last_login_time", 0);
        L6:
            return new z64.a(0, r3, r6);
        }

        public final com.ss.android.badger.a getLogger() {
            return new com.ss.android.badger.a();
        }

        public final b getNetRequestInterface() {
            return new b();
        }

        public final Pair<String, String> getRequestTagHeader() {
            wqa.c r0 = k.d;
            if (r0 == null) goto L5;
            i r1 = r0.getRequestTagHeader(true);
        L6:
            if (r1 != null) goto L8;
            return null;
        L8:
            return new Pair(r1.a, r1.b);
        L5:
            r1 = null;
            goto L6
        }

        public Context getContext() {
            return k.c();
        }

        public final Function0<z> a() {
            return AccountBadger$AccountBadgerInitParams$getPublicIpAddressListGetter$1.INSTANCE;
        }

        public final Function0<Boolean> b() {
            return AccountBadger$AccountBadgerInitParams$getIsAppInForegroundGetter$1.INSTANCE;
        }

        public final Function0<String> c() {
            return AccountBadger$AccountBadgerInitParams$getDeviceIdGetter$1.INSTANCE;
        }

        public final Function0<Boolean> d() {
            return AccountBadger$AccountBadgerInitParams$getIsLoginGetter$1.INSTANCE;
        }
    }

    public static final class a implements com.ss.android.token.i.a {
        public a() {
        }

        @Override // com.ss.android.token.i.a
        public final void a(com.ss.android.token.j r1, com.ss.android.token.j r2) {
            Badger.INSTANCE.setServerTS(r1.a);
        }
    }

    static {
        a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(AccountBadger.class), "sp", "getSp()Landroid/content/SharedPreferences;"))};
        f = new AccountBadger();
        c = new AtomicBoolean(false);
        d = new AtomicBoolean(false);
        e = LazyKt.lazy(AccountBadger$sp$2.INSTANCE);
    }

    public AccountBadger() {
    }

    @JvmStatic
    public static final void a() {
        com.bytedance.sdk.account.settings.common.a.a();
        if (com.bytedance.sdk.account.settings.common.a.H == true) goto L5;
        return;
    L5:
        AccountBadger r1 = f;
        monitor-enter(r1);
        f r2 = k.b;     // Catch: Throwable -> L13
        JSONObject r3 = null;
        if (r2 == null) goto L10;
        Context r4 = r2.getApplicationContext();     // Catch: Throwable -> L13
    L11:
        if (r4 == null) goto L15;
        r3 = com.bytedance.sdk.account.impl.z.a(r4).getAccountSettingsConfig();     // Catch: Throwable -> L13
    L15:
        if (r3 == null) goto L17;
        JSONObject r5 = r3.optJSONObject("badger_config");     // Catch: Throwable -> L13
        tb7.a.d("AccountBadger", "onAccountSettingsUpdate, settings changed: " + r5);     // Catch: Throwable -> L13
        Badger.INSTANCE.updateConfig(r5);     // Catch: Throwable -> L13
    L17:
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L13
        monitor-exit(r1);
        return;
    L10:
        r4 = null;
    L13:
        th = move-exception;
        throw th;
    }

    public static void b() {
        tb7.a.a("AccountBadger", "onSdkInit");
        final Context r1 = k.d().getApplicationContext();
        if (r1 != null) goto L6;
        tb7.a.b("AccountBadger", "onSdkInitReal, context is null");
        return;
    L6:
        j r2 = j.m(r1);
        if (r2 == null) goto L9;
        r2.d(f);
        b = r2;
    L9:
        a();
        tb7.a.a("AccountBadger", "init badger start");
        com.ss.android.token.i.a(new a());
        Badger r0 = Badger.INSTANCE;
        r0.init(AccountBadgerInitParams.a);
        r0.setServerTSV2Provider(new AccountBadger$onSdkInitReal$3(r1));     // Catch: Exception -> L12
        return;
    }

    public final void M(ta7.b r4) {
        com.bytedance.sdk.account.settings.common.a.a();
        if (com.bytedance.sdk.account.settings.common.a.H == true) goto L5;
        return;
    L5:
        int r0 = r4.a;
        if (r0 == 0) goto L16;
        if (r0 != 1) goto L26;
        j r5 = b;
        if (r5 != null) goto L13;
        return;
    L13:
        if (r5.isLogin() == true) goto L22;
        tb7.a.d("AccountBadger", "onLogout");
        Badger.INSTANCE.invalidateRecord();
        return;
    L22:
        return;
    L26:
        return;
    L16:
        if (r4.d == false) goto L24;
        Lazy r6 = e;
        KProperty r1 = a[0];
        SharedPreferences r7 = (SharedPreferences) r6.getValue();
        if (r7 == null) goto L25;
        r7.edit().putLong("last_login_time", System.currentTimeMillis()).apply();
        return;
    L25:
        return;
    }
}
