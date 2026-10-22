package com.ss.android.lark.framework.assembly.featuregating;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import c3c.f;
import com.bytedance.common.utility.NetworkClient;
import com.bytedance.mt.protector.impl.UriProtector;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.http.model.http.HttpHeaders;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passport.signinsdk_api.entity.DeviceId;
import com.ss.android.lark.passportc.api.Scene;
import com.ss.android.lark.passportc.api.h;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.utils.LarkContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;
import javax.inject.Singleton;
import opb.e;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Singleton
public final class FeatureGatingModuleDependency extends c0c.b implements fdb.b {
    public static final /* synthetic */ int f = 0;
    public final j b;
    public final epb.a c;
    public final yzb.b d;
    public final List<hdb.a> e;

    /* JADX INFO: renamed from: com.ss.android.lark.framework.assembly.featuregating.FeatureGatingModuleDependency$1, reason: invalid class name */
    public class AnonymousClass1 implements IGetDataCallback<DeviceId> {
        final /* synthetic */ FeatureGatingModuleDependency this$0;
        final /* synthetic */ String val$apiDomain;
        final /* synthetic */ IGetDataCallback val$callback;
        final /* synthetic */ Map val$header;
        final /* synthetic */ bjb.b val$networkClient;

        public static /* synthetic */ void a(AnonymousClass1 r0, bjb.b r1, String r2, Map r3, IGetDataCallback r4) {
            r0.lambda$onSuccess$0(r1, r2, r3, r4);
        }

        public void onError(ErrorResult r3) {
            Log.i("FeatureGatingModuleDependency", "getDeviceId failed, e: " + r3);
        }

        public void onSuccess(DeviceId r10) {
            Log.i("FeatureGatingModuleDependency", "getDeviceId success");
            FeatureGatingModuleDependency r0 = this.this$0;
            String r11 = r10.getDeviceId();
            int r2 = FeatureGatingModuleDependency.f;
            r0.getClass();
            String r1 = Integer.toString(LarkAppContext.inst().appIdInfo().a);
            HashMap r3 = new HashMap();
            if (r11 == null) goto L5;
            r3.put("device_id", r11);
        L5:
            r3.put("app_id", r1);
            r3.put("tags", "NO_USER_FG");
            FeatureGatingModuleDependency r12 = this.this$0;
            String r4 = this.val$apiDomain;
            r12.getClass();
            if (TextUtils.isEmpty(r4) == false) goto L10;
            String r13 = "";
        L8:
            final String r6 = r13;
            Log.i("FeatureGatingModuleDependency", "api domain: " + this.val$apiDomain + ", settings url: " + r6 + ", queryParams: " + r3);
            if (TextUtils.isEmpty(r6) == false) goto L20;
            return;
        L20:
            if (CollectionUtils.isEmpty(r3) == true) goto L26;
            ExecutorService r14 = CoreThreadPool.getDefault().getFixedThreadPool();
            final bjb.b r5 = this.val$networkClient;
            final Map r7 = this.val$header;
            final IGetDataCallback r8 = this.val$callback;
            r14.execute(new a(this, r5, r6, r7, r8));
            return;
        L26:
            return;
        L10:
            if (r4.startsWith("https://") == true) goto L12;
            r4 = "https://".concat(r4);
        L12:
            Uri.Builder r15 = UriProtector.parse(r4).buildUpon();
            r15.appendPath("/settings/v3/");
            Iterator r9 = r3.entrySet().iterator();
        L14:
            if (r9.hasNext() == false) goto L16;
            Map.Entry r16 = (Map.Entry) r9.next();
            r15.appendQueryParameter((String) r16.getKey(), (String) r16.getValue());
            goto L14
        L16:
            r13 = r15.build().toString();
            goto L8
        }

        public /* bridge */ /* synthetic */ void onError(Object r1) {
            onError((ErrorResult) r1);
        }

        public /* bridge */ /* synthetic */ void onSuccess(Object r1) {
            onSuccess((DeviceId) r1);
        }

        private /* synthetic */ void lambda$onSuccess$0(bjb.b r3, String r4, Map r5, IGetDataCallback r6) {
            r6.onSuccess(FeatureGatingModuleDependency.rf(this.this$0, r3.get(r4, r5, new NetworkClient.ReqContext())));     // Catch: Exception -> L5
            Log.i("FeatureGatingModuleDependency", "request settings success");     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            r6.onError(new ErrorResult(e));
            Log.e("FeatureGatingModuleDependency", "request settings failed, e: " + e);
        }

        public AnonymousClass1(FeatureGatingModuleDependency r1, String r2, bjb.b r3, Map r4, IGetDataCallback r5) {
            this.this$0 = r1;
            this.val$apiDomain = r2;
            this.val$networkClient = r3;
            this.val$header = r4;
            this.val$callback = r5;
        }
    }

    public final void N8() {
        e.a.a.e();
    }

    public final String getUserId() {
        return this.d.c();
    }

    public final int Ue() {
        return ((FeatureGatingUseSettingConfig) SettingManager.getInstance().get(FeatureGatingUseSettingConfig.class)).fgKeyCapacity;
    }

    public final Boolean Y() {
        return Boolean.valueOf(LarkAppContext.inst().buildConfig().isOfficeSDK());
    }

    public Context getContext() {
        return LarkContext.getApplication();
    }

    public final int mc() {
        return ((FeatureGatingUseSettingConfig) SettingManager.getInstance().get(FeatureGatingUseSettingConfig.class)).fgMemoryLimit;
    }

    public final boolean e6(String r3) {
        new i3c.b(f.a());
        int r0 = i3c.b.b;
        if (FeatureGatingModule.getFeatureGatingService().isNoUserFGEnable("lazy_load_fg_barrier_before_login") == true) goto L8;
        Boolean r4 = (Boolean) ((HashMap) i3c.b.c).get(r3);
        if (r4 != null) goto L13;
    L10:
        return false;
    L13:
        return r4.booleanValue();
    L8:
        Boolean r5 = (Boolean) ((HashMap) i3c.b.d).get(r3);
        if (r5 == null) goto L10;
        return r5.booleanValue();
    }

    public final boolean e9(String r3) {
        return Boolean.parseBoolean(SettingManager.getInstance().getSettingConfig(r3, false));
    }

    public final void nf(f0c.b r3) {
        Log.i("FeatureGatingModuleDependency", "onPrepared");
        Scene r4 = r3.b.b;
        if (Scene.FIRST_ONLINE.equals(r4) == false) goto L5;
    L8:
        Iterator r5 = ((ArrayList) this.e).iterator();
    L10:
        if (r5.hasNext() == false) goto L14;
        ((hdb.a) r5.next()).a();
        goto L10
    L14:
        return;
    L5:
        if (Scene.FAST_ONLINE.equals(r4) == true) goto L8;
        if (Scene.SWITCH_ONLINE.equals(r4) == true) goto L8;
    }

    public final void ve(ndb.a r2) {
        ((ArrayList) this.e).add(r2);
    }

    public static Map rf(FeatureGatingModuleDependency r4, String r5) {
        r4.getClass();
        Gson r0 = new Gson();
        HashMap r1 = new HashMap();
        Iterator r6 = ((c) r0.fromJson(r5, c.class)).data.entrySet().iterator();     // Catch: Exception -> L13
    L5:
        if (r6.hasNext() == false) goto L11;
        Map.Entry r2 = (Map.Entry) r6.next();     // Catch: Exception -> L13
        JsonElement r3 = (JsonElement) r2.getValue();     // Catch: Exception -> L13
        if (r3.isJsonPrimitive() == false) goto L5;
        if (r3.getAsJsonPrimitive().isBoolean() == false) goto L5;
        r1.put((String) r2.getKey(), Boolean.valueOf(r3.getAsBoolean()));     // Catch: Exception -> L13
        goto L5
    L11:
        Log.i("FeatureGatingModuleDependency", "getSettingsFGMap success, settingsFGMap: " + r1.toString());     // Catch: Exception -> L13
    L15:
        return r1;
    L13:
        e = move-exception;
        Log.e("FeatureGatingModuleDependency", "getSettingsFGMap failed, e: " + e);
        goto L15
    }

    public final void ic(Context r9, IGetDataCallback<Map<String, Boolean>> r10) {
        bjb.b r3 = new bjb.b(bjb.e.a());
        String r2 = jcb.b.c().a("api");
        HashMap r4 = new HashMap();
        r4.put(HttpHeaders.HEAD_KEY_ACCEPT_ENCODING, "gzip,deflate,br");
        r4.put("X-LS-Caller-Type", "native");
        this.c.getDeviceId(LarkContext.getApplication(), new AnonymousClass1(this, r2, r3, r4, r10));
    }

    public final void sendEvent(String r1, JSONObject r2) {
        Statistics.sendEvent(r1, r2);
    }

    @Inject
    public FeatureGatingModuleDependency(j r2, epb.a r3, yzb.b r4) {
        super(r2);
        this.e = new ArrayList();
        this.b = r2;
        this.c = r3;
        this.d = r4;
        h.a(this);
    }
}
