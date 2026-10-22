package com.ss.android.lark.larkconfig.userconfig;

import android.text.TextUtils;
import com.bytedance.i18n.claymore.ClaymoreServiceLoader;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.GetAppConfigRequest;
import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
import com.bytedance.lark.pb.settings.v1.GetUniversalUserSettingRequest;
import com.ss.android.lark.larkconfig.universal.UniversalUserSettingService$getAllUniversalUserSetting$1;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.sdk.SdkSender;
import com.ss.android.lark.storage.LarkKVStorage;
import com.suite.lark.component.protocol.Biz;
import java.lang.ref.Reference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e {
    public final Object a;
    public final Object b;
    public volatile tpb.a c;
    public final Map<tpb.b, Object> d;
    public volatile String e;
    public final c f;
    public final AtomicBoolean g;
    public boolean h;
    public boolean i;

    public static class a {
        public static final e a = null;

        static {
            a = new e();
        }
    }

    public final tpb.a a() {
        if (TextUtils.equals(((upb.a) ClaymoreServiceLoader.loadFirst(upb.a.class)).getUserId(), this.e) == true) goto L5;
        return null;
    L5:
        return this.c;
    }

    public final void b() {
        Log.i("AppUserConfigService", "init called");
        com.ss.android.lark.larkconfig.userconfig.a r0 = com.ss.android.lark.larkconfig.userconfig.a.C0169a.a;
        com.ss.android.lark.larkconfig.userconfig.a.C0169a.a = new com.ss.android.lark.larkconfig.userconfig.a();
    L4:
        if (r0.b.isEmpty() == true) goto L10;
        if (((f.b) ((LinkedBlockingQueue) r0.b).poll()) == null) goto L4;
        ((ConcurrentHashMap) r0.a).get(null);
        throw null;
    L10:
        Object r1 = this.b;
        monitor-enter(r1);
    L20:
        th = move-exception;
        throw th;
    L13:
        if (this.h == true) goto L18;
        opb.e.a.a.e();     // Catch: Throwable -> L20
        com.ss.android.lark.larkconfig.universal.e r2 = com.ss.android.lark.larkconfig.universal.e.a;     // Catch: Throwable -> L20
        GetUniversalUserSettingRequest.Builder r3 = new GetUniversalUserSettingRequest.Builder().need_all_keys(Boolean.TRUE).strategy(SyncDataStrategy.FORCE_SERVER);     // Catch: Throwable -> L20
        SdkSender.asynSendRequestNonWrap(Command.GET_UNIVERSAL_USER_SETTING, r3, new UniversalUserSettingService$getAllUniversalUserSetting$1(), com.ss.android.lark.larkconfig.universal.b.a);     // Catch: Throwable -> L20
        c();     // Catch: Throwable -> L20
        if (this.i == true) goto L17;
        ((upb.a) ClaymoreServiceLoader.loadFirst(upb.a.class)).registerAccountChangeListener(this.f);     // Catch: Throwable -> L20
        this.i = true;     // Catch: Throwable -> L20
    L17:
        this.h = true;     // Catch: Throwable -> L20
    L18:
        monitor-exit(r1);     // Catch: Throwable -> L20
    }

    public final void c() {
        if (this.g.get() == true) goto L15;
        Object r0 = this.a;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L8:
        if (a() != null) goto L14;
        String r1 = ((upb.a) ClaymoreServiceLoader.loadFirst(upb.a.class)).getUserId();     // Catch: Throwable -> L12
        this.c = (tpb.a) LarkKVStorage.j(Biz.Core, true).getJSONObject(String.format("%s_%s", new Object[]{r1, "key_app_config_v1"}), tpb.a.class);     // Catch: Throwable -> L12
        if (this.c == null) goto L14;
        this.e = r1;     // Catch: Throwable -> L12
        Log.i("AppUserConfigService", "loaded app config from local");     // Catch: Throwable -> L12
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L12
    L15:
        final String r2 = ((upb.a) ClaymoreServiceLoader.loadFirst(upb.a.class)).getUserId();
        GetAppConfigRequest.Builder r3 = new GetAppConfigRequest.Builder();
        r3.force_remote(Boolean.TRUE);
        SdkSender.asynSendRequestNonWrap(Command.GET_APP_CONFIG, r3, new AppUserConfigService$1(this), new b(this, r2));
    }

    public final void d() {
        Object r0 = this.b;
        monitor-enter(r0);
        opb.e.a.a.getClass();     // Catch: Throwable -> L16
        com.ss.android.lark.appsetting.api.service.d.a.a.getClass();     // Catch: Throwable -> L16
        com.ss.android.lark.appsetting.api.e r1 = com.ss.android.lark.appsetting.api.e.a.a;     // Catch: Throwable -> L16
        if (r1.b == null) goto L7;
        r1.b.clear();     // Catch: Throwable -> L16
    L7:
        Map r2 = r1.c;     // Catch: Throwable -> L16
        if (r2 == null) goto L10;
        ((HashMap) r2).clear();     // Catch: Throwable -> L16
    L10:
        Reference r3 = r1.a;     // Catch: Throwable -> L16
        if (r3 == null) goto L13;
        r3.clear();     // Catch: Throwable -> L16
    L13:
        this.h = false;     // Catch: Throwable -> L16
        this.c = null;     // Catch: Throwable -> L16
        this.e = null;     // Catch: Throwable -> L16
        this.g.set(false);     // Catch: Throwable -> L16
        monitor-exit(r0);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        throw th;
    }

    public e() {
        this.a = new Object();
        this.b = new Object();
        this.d = new ConcurrentHashMap();
        this.g = new AtomicBoolean(false);
        this.h = false;
        this.i = false;
        this.f = new c(this);
    }
}
