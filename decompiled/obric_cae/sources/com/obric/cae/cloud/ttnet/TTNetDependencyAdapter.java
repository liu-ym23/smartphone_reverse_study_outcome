package com.obric.cae.cloud.ttnet;

import android.content.Context;
import android.text.TextUtils;
import c2.e;
import com.bytedance.ttnet.TTNetInit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;
import vd.b;
import w8.c;

/* JADX INFO: loaded from: classes.dex */
public class TTNetDependencyAdapter implements c {
    private static final String TAG = "TTNetDependencyAdapter";
    private Context mContext;

    public TTNetDependencyAdapter(Context r8) {
        this.mContext = r8;
    }

    public int checkHttpRequestException(Throwable r8, String[] r10) {
        return 0;
    }

    public String executeGet(int r8, String r10) {
        return null;
    }

    public String getApiIHostPrefix() {
        return null;
    }

    @Override // w8.c
    public int getAppId() {
        return AppConstants.APP_ID;
    }

    public String getCdnHostSuffix() {
        return "byteimg.com";
    }

    @Override // w8.c
    public String[] getConfigServers() {
        return new String[]{"tnc3-bjlgy.snssdk.com", "tnc3-alisc1.snssdk.com", "tnc3-aliec2.snssdk.com"};
    }

    @Override // w8.c
    public Context getContext() {
        return this.mContext;
    }

    @Override // w8.c
    public ArrayList<String> getCookieFlushPathList() {
        return null;
    }

    public Map<String, String> getHostReverseMap() {
        return null;
    }

    @Override // w8.c
    public String getHostSuffix() {
        return "snssdk.com";
    }

    @Override // w8.c
    public int getProviderInt(Context r8, String r10, int r11) {
        return 0;
    }

    @Override // w8.c
    public String getProviderString(Context r8, String r10, String r11) {
        return null;
    }

    @Override // w8.c
    public String getShareCookieMainDomain() {
        return null;
    }

    @Override // w8.c
    public Map<String, String> getTTNetServiceDomainMap() {
        HashMap r8 = new HashMap();
        r8.put("httpdns", "dig.bdurl.net");
        r8.put(TTNetInit.DOMAIN_NETLOG_KEY, "crash.snssdk.com");
        r8.put(TTNetInit.DOMAIN_BOE_KEY, ".boe-gateway.byted.org");
        return r8;
    }

    @Override // w8.c
    public boolean isCronetPluginInstalled() {
        return true;
    }

    @Override // w8.c
    public boolean isPrivateApiAccessEnabled() {
        return true;
    }

    @Override // w8.c
    public void mobOnEvent(Context r8, String r10, String r11, JSONObject r12) {
    }

    @Override // w8.c
    public void monitorLogSend(String r8, JSONObject r10) {
        e.b(r8, r10);
    }

    @Override // w8.c
    public void onAppConfigUpdated(Context r8, JSONObject r10) {
    }

    @Override // w8.c
    public void onColdStartFinish() {
    }

    public void onNetConfigUpdate(JSONObject r8, boolean r10) {
    }

    @Override // w8.c
    public void onShareCookieConfigUpdated(String r8) {
        if (TextUtils.isEmpty(r8) == true) goto L25;
        ArrayList r10 = new ArrayList();
        String[] r11 = r8.split(",");
        if (r11.length <= 0) goto L18;
        int r12 = r11.length;
        int r13 = 0;
    L7:
        if (r13 >= r12) goto L18;
        String r14 = r11[r13];
        if (TextUtils.isEmpty(r14) == true) goto L17;
        if (r14.length() > 1) goto L14;
    L16:
        r10.add(r14);
        goto L17
    L14:
        if (r14.startsWith(".") == false) goto L16;
        r14 = r14.substring(1);
    L17:
        r13 = r13 + 1;
    L18:
        Set<String> r15 = b.f12845a;
        if (r15 == null) goto L26;
        r15.addAll(r10);
        return;
    L26:
        return;
    }

    @Override // w8.c
    public void saveMapToProvider(Context r8, Map<String, ?> r10) {
    }
}
