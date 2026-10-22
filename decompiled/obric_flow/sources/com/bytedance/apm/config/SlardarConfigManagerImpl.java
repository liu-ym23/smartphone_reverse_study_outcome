package com.bytedance.apm.config;

import android.content.IntentFilter;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.bytedance.apm.j;
import com.bytedance.services.slardar.config.IConfigManager;
import e6.d;
import e6.e;
import f6.a;
import g6.b;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import jg.i;
import org.json.JSONException;
import org.json.JSONObject;
import td.c;
import wn.f;

/* JADX INFO: loaded from: classes2.dex */
public class SlardarConfigManagerImpl implements IConfigManager {
    private e mSlardarConfigFetcher;

    public SlardarConfigManagerImpl() {
        e r5 = new e();
        r5.f16765b = false;
        ArrayList r10 = a.f16879a;
        r5.g = 1200;
        r5.f16769j = -1;
        r5.f16770k = 60000;
        r5.f16771l = -1;
        r5.f16772m = false;
        this.mSlardarConfigFetcher = r5;
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public void fetchConfig() {
        e r5 = this.mSlardarConfigFetcher;
        boolean r10 = r5.g();
        if (j.d() == true) goto L5;
        return;
    L5:
        if (r5.f16769j <= System.currentTimeMillis()) goto L7;
        r10 = true;
    L7:
        r5.f(r10);
    }

    @WorkerThread
    public void forceUpdateFromRemote(@Nullable b r5, @Nullable List<String> r10) {
        e r11 = this.mSlardarConfigFetcher;
        r11.g();
        if (f.j(r10) == true) goto L5;
        r11.f = new ArrayList(r10);
    L5:
        r11.f(true);
    }

    @Nullable
    public JSONObject getConfig() {
        return this.mSlardarConfigFetcher.f16767h;
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public int getConfigInt(String r5, int r10) {
        e r11 = this.mSlardarConfigFetcher;
        r11.getClass();
        if (TextUtils.isEmpty(r5) == true) goto L9;
        JSONObject r12 = r11.f16767h;
        if (r12 != null) goto L8;
        return r10;
    L8:
        return r12.optInt(r5, r10);
    L9:
        return r10;
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    @Nullable
    public JSONObject getConfigJSON(String r5) {
        e r10 = this.mSlardarConfigFetcher;
        r10.getClass();
        if (TextUtils.isEmpty(r5) == true) goto L9;
        JSONObject r11 = r10.f16767h;
        if (r11 == null) goto L9;
        return r11.optJSONObject(r5);
    L9:
        return new JSONObject();
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public boolean getLogTypeSwitch(String r5) {
        e r10 = this.mSlardarConfigFetcher;
        r10.getClass();
        if (TextUtils.isEmpty(r5) == false) goto L6;
        return false;
    L6:
        if (TextUtils.equals(r5, "block_monitor") == false) goto L9;
        r5 = "caton_monitor";
    L9:
        if (TextUtils.equals(r5, "core_exception_monitor") == false) goto L12;
        return r10.f16765b;
    L12:
        if (r10.f16766c != null) goto L15;
        return false;
    L15:
        if (r10.f16766c.optInt(r5) == 1) goto L17;
        return false;
    L17:
        return true;
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public boolean getMetricTypeSwitch(String r5) {
        e r10 = this.mSlardarConfigFetcher;
        if (r10.d != null) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r5) == false) goto L8;
        return false;
    L8:
        if (r10.d.optInt(r5) == 1) goto L10;
        return false;
    L10:
        return true;
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public boolean getServiceSwitch(String r5) {
        e r10 = this.mSlardarConfigFetcher;
        if (r10.e != null) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r5) == false) goto L8;
        return false;
    L8:
        if (r10.e.optInt(r5) == 1) goto L10;
        return false;
    L10:
        return true;
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public boolean getSwitch(String r5) {
        e r10 = this.mSlardarConfigFetcher;
        r10.getClass();
        if (TextUtils.isEmpty(r5) == true) goto L8;
        JSONObject r11 = r10.f16767h;
        if (r11 == null) goto L8;
        return r11.optBoolean(r5);
    L8:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r7v4, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r7v6, types: [java.util.ArrayList] */
    public void initParams(boolean r10, b r11, List<String> r12) {
        e r13 = this.mSlardarConfigFetcher;
        r13.f16773n = r10;
        r13.f16774o = j.d();
        r13.b();
        if (f.j(r12) == true) goto L17;
        if (f.j(r12) == true) goto L14;
        ?? r14 = new ArrayList(2);     // Catch: MalformedURLException -> L25
        int r5 = r12.size();     // Catch: MalformedURLException -> L25
        int r15 = 0;
    L7:
        if (r15 >= r5) goto L15;
        String r16 = new URL(r12.get(r15)).getHost();     // Catch: MalformedURLException -> L25
        if (TextUtils.isEmpty(r16) == true) goto L13;
        if (r16.indexOf(46) <= 0) goto L13;
        r14.add("https://" + r16 + "/monitor/appmonitor/v5/batch_settings");     // Catch: MalformedURLException -> L25
    L13:
        r15 = r15 + 1;
    L15:
        r13.f = r14;
    L14:
        r14 = Collections.emptyList();
    L17:
        if (r13.f16772m == true) goto L32;
        r13.f16772m = true;
        if (r13.f16774o == false) goto L21;
    L22:
        z6.b.f23409a.a(r13);
    L23:
        new IntentFilter().addAction("com.apm.setting.update.action");
        new d(r13, 0);
        boolean r17 = j.f3887a;
        return;
    L21:
        if (r13.f16773n == false) goto L23;
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public boolean isConfigReady() {
        return this.mSlardarConfigFetcher.f16764a;
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public String queryConfig() {
        this.mSlardarConfigFetcher.b();
        throw null;
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public void registerConfigListener(pj.a r5) {
        e r10 = this.mSlardarConfigFetcher;
        if (r5 != null) goto L6;
        r10.getClass();
        return;
    L6:
        if (r10.f16777r != null) goto L9;
        r10.f16777r = new CopyOnWriteArrayList();
    L9:
        if (r10.f16777r.contains(r5) == true) goto L12;
        r10.f16777r.add(r5);
    L12:
        if (j.f3887a == false) goto L15;
        Log.i("apm_initializing", com.bytedance.android.anniex.base.service.f.o(new String[]{"addConfigListener, mReady=" + r10.f16764a}));
    L15:
        if (r10.f16764a == false) goto L19;
        r5.d(r10.f16767h, r10.f16768i);
        r5.e();
        return;
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public void registerResponseConfigListener(pj.b r5) {
        if (r5 != null) goto L5;
        return;
    L5:
        if (kk.a.f18652c != null) goto L8;
        kk.a.f18652c = new CopyOnWriteArrayList();
    L8:
        if (kk.a.f18652c.contains(r5) == true) goto L11;
        kk.a.f18652c.add(r5);
        return;
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public JSONObject retrieveSettingsParams() {
        this.mSlardarConfigFetcher.getClass();
        throw null;
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public void unregisterConfigListener(pj.a r5) {
        e r10 = this.mSlardarConfigFetcher;
        if (r5 != null) goto L5;
        r10.getClass();
        return;
    L5:
        CopyOnWriteArrayList r11 = r10.f16777r;
        if (r11 == null) goto L10;
        r11.remove(r5);
        return;
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public void unregisterResponseConfigListener(pj.b r5) {
        if (r5 == null) goto L9;
        CopyOnWriteArrayList r10 = kk.a.f18652c;
        if (r10 == null) goto L8;
        r10.remove(r5);
        return;
    L8:
        return;
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public boolean updateWithSpecificAidResult(JSONObject r11) {
        e r10 = this.mSlardarConfigFetcher;
        r10.getClass();
        int r5 = r11.optInt("code", -1);
        if (r5 != (-1)) goto L6;
    L11:
        return false;
    L6:
        if (r5 == 1) goto L88;
        if (r5 != 0) goto L9;
    L12:
        JSONObject r12 = r11.optJSONObject("data");
        if (r12 != null) goto L92;
        r10.b();
        throw null;
    L92:
        JSONObject r13 = r11.optJSONObject("data_to_merge");     // Catch: JSONException -> L18
        if (r13 == null) goto L90;
        c.i(r12, r13);     // Catch: JSONException -> L18
    L90:
        JSONObject r14 = r11.optJSONObject("data_to_delete");     // Catch: JSONException -> L28
        if (r14 == null) goto L34;
        c.g(r12, r14);     // Catch: JSONException -> L28
    L34:
        r10.f16775p = ((long) r11.optInt("last_calculate_timestamp", 0)) * 1000;
        r10.f16776q = ((long) r11.optInt("last_full_calculate_timestamp", 0)) * 1000;
        r10.f16769j = System.currentTimeMillis();
        r10.f16768i = false;
        if (r12.length() == 0) goto L72;
        JSONObject r15 = ug.a.i("general", "slardar_api_settings", r12);
        if (r15 == null) goto L45;
        JSONObject r16 = r15.optJSONObject("fetch_setting");
        if (r16 == null) goto L43;
        r10.g = r16.optLong("fetch_setting_interval", 1200);
    L43:
        if (r10.g >= 600) goto L45;
        r10.g = 600;
    L45:
        JSONObject r17 = r12.optJSONObject("custom_event_settings");
        if (r17 == null) goto L48;
        r10.f16766c = r17.optJSONObject("allow_log_type");
        r10.d = r17.optJSONObject("allow_metric_type");
        r10.e = r17.optJSONObject("allow_service_name");
    L48:
        r10.f16767h = r12;
        if (TextUtils.isEmpty("exception_modules") == true) goto L54;
        JSONObject r18 = r10.f16767h;
        if (r18 == null) goto L54;
        JSONObject r19 = r18.optJSONObject("exception_modules");
    L56:
        if (r19 == null) goto L65;
        JSONObject r110 = r19.optJSONObject("exception");
        if (r110 == null) goto L65;
        if (r110.optInt("enable_upload") != 1) goto L62;
        boolean r111 = true;
    L63:
        r10.f16765b = r111;
        goto L65
    L62:
        r111 = false;
    L65:
        if (r10.e == null) goto L72;
        if (TextUtils.isEmpty("apm_cost") == true) goto L72;
        if (r10.e.optInt("apm_cost") != 1) goto L72;
        i.e = new r6.a(r10);
        i.f = true;
    L54:
        r19 = new JSONObject();
    L72:
        JSONObject r112 = r12.optJSONObject("general");
        if (r112 == null) goto L75;
        r112.optBoolean("enable_salvage_log", true);
    L75:
        JSONObject r20 = ug.a.i("performance_modules", "smooth", r12);
        if (r20 == null) goto L81;
        r20.optInt("block_enable_upload", 0);
        r20.optInt("enable_trace", 0);
        r20.optInt("enable_stack_sampling", 0);
        r20.optLong("atrace_tag", 0);
        JSONObject r113 = ug.a.i("performance_modules", "smooth", r12);
        if (r113 == null) goto L81;
        r113.optInt("block_monitor_mode", 0);
    L81:
        JSONObject r114 = ug.a.i("performance_modules", "start_trace", r12);
        if (r114 == null) goto L85;
        r114.optInt("enable_perf_data_collect", 0);
        r114.optInt("enable_lock_data_collect", 0);
        r114.optInt("enable_long_sleep_data_collect", 0);
    L85:
        throw null;
    L28:
        e = move-exception;
        oo.j.h(e, "SlardarConfigFetcher->updateWithSpecificAidResult 3");
        if (j.f3887a == false) goto L34;
        if (td.b.f22124a == false) goto L34;
        Log.e("SlardarConfigFetcher", "error nested data: dataToDelete");
    L18:
        e = move-exception;
        oo.j.h(e, "SlardarConfigFetcher->updateWithSpecificAidResult 2");
        if (j.f3887a == false) goto L90;
        if (td.b.f22124a == false) goto L90;
        Log.e("SlardarConfigFetcher", "error nested data: dataToMerge");
        goto L90
    L9:
        if (r5 != 2) goto L11;
    L88:
        r10.f16769j = System.currentTimeMillis();
        r10.f16775p = ((long) r11.optInt("last_calculate_timestamp", 0)) * 1000;
        r10.f16776q = ((long) r11.optInt("last_full_calculate_timestamp", 0)) * 1000;
        throw null;
    }
}
