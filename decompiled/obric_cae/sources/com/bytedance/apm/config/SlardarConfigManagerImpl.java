package com.bytedance.apm.config;

import android.text.TextUtils;
import c2.k;
import com.bytedance.services.slardar.config.IConfigManager;
import j2.d;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import l2.b;
import l2.c;
import l6.a;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class SlardarConfigManagerImpl implements IConfigManager {
    private d mSlardarConfigFetcher;

    public SlardarConfigManagerImpl() {
        this.mSlardarConfigFetcher = new d();
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public void fetchConfig() {
        d r8 = this.mSlardarConfigFetcher;
        boolean r10 = r8.f();
        if (k.e() == true) goto L5;
        return;
    L5:
        if (r8.f8569i <= System.currentTimeMillis()) goto L7;
        r10 = true;
    L7:
        r8.d(r10);
    }

    public void forceUpdateFromRemote(b r8, List<String> r10) {
        d r11 = this.mSlardarConfigFetcher;
        r11.f();
        if (a.e0(r10) == true) goto L5;
        r11.f8566f = new ArrayList(r10);
    L5:
        r11.d(true);
    }

    public JSONObject getConfig() {
        return this.mSlardarConfigFetcher.f8568h;
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public int getConfigInt(String r8, int r10) {
        d r11 = this.mSlardarConfigFetcher;
        r11.getClass();
        if (TextUtils.isEmpty(r8) == true) goto L9;
        JSONObject r12 = r11.f8568h;
        if (r12 != null) goto L8;
        return r10;
    L8:
        return r12.optInt(r8, r10);
    L9:
        return r10;
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public JSONObject getConfigJSON(String r8) {
        d r10 = this.mSlardarConfigFetcher;
        r10.getClass();
        if (TextUtils.isEmpty(r8) == true) goto L9;
        JSONObject r11 = r10.f8568h;
        if (r11 == null) goto L9;
        return r11.optJSONObject(r8);
    L9:
        return new JSONObject();
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public boolean getLogTypeSwitch(String r8) {
        d r10 = this.mSlardarConfigFetcher;
        r10.getClass();
        if (TextUtils.isEmpty(r8) == false) goto L6;
        return false;
    L6:
        if (TextUtils.equals(r8, "block_monitor") == false) goto L9;
        r8 = "caton_monitor";
    L9:
        if (TextUtils.equals(r8, "core_exception_monitor") == false) goto L12;
        return r10.f8562b;
    L12:
        if (r10.f8563c != null) goto L15;
        return false;
    L15:
        if (r10.f8563c.optInt(r8) == 1) goto L17;
        return false;
    L17:
        return true;
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public boolean getMetricTypeSwitch(String r8) {
        d r10 = this.mSlardarConfigFetcher;
        if (r10.f8564d != null) goto L5;
    L10:
        return false;
    L5:
        if (TextUtils.isEmpty(r8) == true) goto L10;
        if (r10.f8564d.optInt(r8) != 1) goto L10;
        return true;
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public boolean getServiceSwitch(String r8) {
        d r10 = this.mSlardarConfigFetcher;
        if (r10.f8565e != null) goto L5;
    L10:
        return false;
    L5:
        if (TextUtils.isEmpty(r8) == true) goto L10;
        if (r10.f8565e.optInt(r8) != 1) goto L10;
        return true;
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public boolean getSwitch(String r8) {
        d r10 = this.mSlardarConfigFetcher;
        r10.getClass();
        if (TextUtils.isEmpty(r8) == true) goto L8;
        JSONObject r11 = r10.f8568h;
        if (r11 == null) goto L8;
        return r11.optBoolean(r8);
    L8:
        return false;
    }

    public void initParams(boolean r8, b r10, List<String> r11) {
        d r12 = this.mSlardarConfigFetcher;
        r12.f8573m = r8;
        r12.f8574n = k.f();
        r12.getClass();
        monitor-enter(r12);
        r12.getClass();     // Catch: Throwable -> L6
        c.a();     // Catch: Throwable -> L6
        throw null;     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public boolean isConfigReady() {
        return this.mSlardarConfigFetcher.f8561a;
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public String queryConfig() {
        d r8 = this.mSlardarConfigFetcher;
        r8.getClass();
        monitor-enter(r8);
        r8.getClass();     // Catch: Throwable -> L6
        boolean r10 = k.f3297a;     // Catch: Throwable -> L6
        c.a();     // Catch: Throwable -> L6
        throw null;     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public void registerConfigListener(v8.a r8) {
        d r10 = this.mSlardarConfigFetcher;
        if (r8 != null) goto L6;
        r10.getClass();
        return;
    L6:
        if (r10.f8576p != null) goto L9;
        r10.f8576p = new CopyOnWriteArrayList();
    L9:
        if (r10.f8576p.contains(r8) == true) goto L12;
        r10.f8576p.add(r8);
    L12:
        if (r10.f8561a == false) goto L16;
        r8.a(r10.f8568h);
        r8.b();
        return;
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public void registerResponseConfigListener(v8.b r8) {
        if (r8 != null) goto L5;
        return;
    L5:
        if (a.f9134c != null) goto L8;
        a.f9134c = new CopyOnWriteArrayList();
    L8:
        if (a.f9134c.contains(r8) == true) goto L11;
        a.f9134c.add(r8);
        return;
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public void unregisterConfigListener(v8.a r8) {
        d r10 = this.mSlardarConfigFetcher;
        if (r8 != null) goto L5;
        r10.getClass();
        return;
    L5:
        CopyOnWriteArrayList r11 = r10.f8576p;
        if (r11 == null) goto L10;
        r11.remove(r8);
        return;
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public void unregisterResponseConfigListener(v8.b r8) {
        if (r8 == null) goto L9;
        CopyOnWriteArrayList r10 = a.f9134c;
        if (r10 == null) goto L8;
        r10.remove(r8);
        return;
    L8:
        return;
    }
}
