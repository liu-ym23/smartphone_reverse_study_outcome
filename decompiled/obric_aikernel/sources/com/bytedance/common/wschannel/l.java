package com.bytedance.common.wschannel;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bytedance.common.utility.Logger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: loaded from: classes.dex */
public class l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f1327b = "com.bytedance.common.wschannel.l";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SuppressLint({"CI_StaticFieldLeak"})
    private static volatile l f1328c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static a f1329d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WsChannelMultiProcessSharedProvider.c f1330a;

    public interface a {
        Map<String, String> a(String r10, Map<String, List<String>> r11);

        Map<String, String> b(Map<String, String> r10);
    }

    static {
    }

    private l(@NonNull Context r10) {
        this.f1330a = WsChannelMultiProcessSharedProvider.k(r10.getApplicationContext());
    }

    public static a b() {
        return f1329d;
    }

    public static l f(Context r10) {
        if (f1328c != null) goto L15;
        monitor-enter(l.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f1328c != null) goto L9;
        f1328c = new l(r10);     // Catch: Throwable -> L11
    L9:
        monitor-exit(l.class);     // Catch: Throwable -> L11
    L15:
        return f1328c;
    }

    public ArrayList<Integer> a() {
        ArrayList<Integer> r10 = new ArrayList();
        String r11 = this.f1330a.d(WsConstants.KEY_AUTO_CONNECT_DISABLED, "");
        if (TextUtils.isEmpty(r11) == false) goto L16;
        return r10;
    L16:
        JSONArray r12 = new JSONArray(r11);     // Catch: JSONException -> L13
        int r13 = 0;
    L7:
        if (r13 >= r12.length()) goto L10;
        r10.add(Integer.valueOf(r12.getInt(r13)));     // Catch: JSONException -> L13
        r13 = r13 + 1;     // Catch: JSONException -> L13
        goto L7
    L10:
        if (Logger.debug() == false) goto L15;
        Logger.d(f1327b, "getAutoConnectDisabledChannelIds: " + r10);     // Catch: JSONException -> L13
    L15:
        return r10;
    L13:
        e = move-exception;
        Logger.e(f1327b, e.getMessage());
        goto L15
    }

    public long c() {
        return this.f1330a.c(WsConstants.KEY_RETRY_SEND_MSG_DELAY, 0);
    }

    public long d() {
        return this.f1330a.c(WsConstants.KEY_IO_LIMIT, WsConstants.DEFAULT_IO_LIMIT);
    }

    public String e() {
        return this.f1330a.d(WsConstants.KEY_WS_APPS, "");
    }

    public boolean g() {
        return this.f1330a.b(WsConstants.KEY_FRONTIER_ENABLED, true);
    }

    public boolean h() {
        return this.f1330a.b(WsConstants.KEY_ENABLE_OFFLINE_DETECT, false);
    }

    public boolean i() {
        return this.f1330a.b(WsConstants.KEY_OK_IMPL_ENABLE, true);
    }

    public boolean j() {
        return this.f1330a.b(WsConstants.KEY_ENABLE_REPORT_APP_STATE, false);
    }

    public void k(boolean r10) {
        this.f1330a.a().c(WsConstants.KEY_ENABLE_OFFLINE_DETECT, r10).b();
    }

    public void l(String r10) {
        this.f1330a.a().d(WsConstants.KEY_WS_APPS, r10).b();
    }
}
