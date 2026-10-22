package com.bytedance.common.wschannel;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: loaded from: classes.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f2134a = "com.bytedance.common.wschannel.l";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile l f2135b;
    private static a d;
    private final WsChannelMultiProcessSharedProvider.b c;

    public interface a {
        Map<String, String> a(String r1, Map<String, List<String>> r2);

        Map<String, String> a(Map<String, String> r1);
    }

    static {
    }

    private l(Context r3) {
        this.c = WsChannelMultiProcessSharedProvider.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin")).getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
    }

    public static l a(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (f2135b != null) goto L15;
        monitor-enter(l.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f2135b != null) goto L9;
        f2135b = new l(r3);     // Catch: Throwable -> L11
    L9:
        monitor-exit(l.class);     // Catch: Throwable -> L11
    L15:
        return f2135b;
    }

    public static a b() {
        return d;
    }

    public void a(String r2) {
        this.c.a().a(WsConstants.KEY_WS_APPS, r2).b();
    }

    public void a(boolean r2) {
        this.c.a().a(WsConstants.KEY_ENABLE_OFFLINE_DETECT, r2).b();
    }

    public boolean a() {
        return this.c.a(WsConstants.KEY_ENABLE_OFFLINE_DETECT, false);
    }

    public boolean c() {
        return this.c.a(WsConstants.KEY_FRONTIER_ENABLED, true);
    }

    public String d() {
        return this.c.a(WsConstants.KEY_WS_APPS, "");
    }

    public boolean e() {
        return this.c.a(WsConstants.KEY_OK_IMPL_ENABLE, true);
    }

    public long f() {
        return this.c.a(WsConstants.KEY_IO_LIMIT, WsConstants.DEFAULT_IO_LIMIT);
    }

    public long g() {
        return this.c.a(WsConstants.KEY_RETRY_SEND_MSG_DELAY, 0);
    }

    public boolean h() {
        return this.c.a(WsConstants.KEY_ENABLE_REPORT_APP_STATE, false);
    }

    public ArrayList<Integer> i() {
        ArrayList<Integer> r0 = new ArrayList();
        String r3 = this.c.a(WsConstants.KEY_AUTO_CONNECT_DISABLED, "");
        if (TextUtils.isEmpty(r3) == false) goto L16;
        return r0;
    L16:
        JSONArray r1 = new JSONArray(r3);     // Catch: JSONException -> L13
        int r4 = 0;
    L7:
        if (r4 >= r1.length()) goto L10;
        r0.add(Integer.valueOf(r1.getInt(r4)));     // Catch: JSONException -> L13
        r4 = r4 + 1;     // Catch: JSONException -> L13
        goto L7
    L10:
        if (Logger.debug() == false) goto L15;
        Logger.d(f2134a, "getAutoConnectDisabledChannelIds: " + r0);     // Catch: JSONException -> L13
    L15:
        return r0;
    L13:
        e = move-exception;
        Logger.e(f2134a, e.getMessage());
        goto L15
    }
}
