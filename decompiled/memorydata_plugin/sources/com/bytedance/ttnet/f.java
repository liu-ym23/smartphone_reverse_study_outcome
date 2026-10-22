package com.bytedance.ttnet;

import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.util.k;
import com.bytedance.retrofit2.PriorityLevel;
import com.bytedance.retrofit2.SsHttpCall;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class f implements SsHttpCall.IRequestFlagHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile f f3285a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<a> f3286b;
    private final AtomicBoolean c;

    static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f3287a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f3288b;
        final List<String> c;
        final List<String> d;

        a(int r3, int r4, List<String> r5, List<String> r6) {
            List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
            List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
            ArrayList r0 = new ArrayList();
            this.c = r0;
            ArrayList r1 = new ArrayList();
            this.d = r1;
            this.f3287a = r3;
            this.f3288b = r4;
            r0.addAll(r7);
            r1.addAll(r8);
        }
    }

    public f() {
        this.f3286b = new CopyOnWriteArrayList();
        this.c = new AtomicBoolean(false);
    }

    public static f a() {
        if (f3285a != null) goto L15;
        monitor-enter(f.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f3285a != null) goto L9;
        f3285a = new f();     // Catch: Throwable -> L11
        SsHttpCall.setRequestFlagHandler(f3285a);     // Catch: Throwable -> L11
    L9:
        monitor-exit(f.class);     // Catch: Throwable -> L11
    L15:
        return f3285a;
    }

    public void a(JSONObject r14) {
        JSONArray r1 = r14.optJSONArray("request_flag_control");
        if (r1 != null) goto L5;
        return;
    L5:
        this.c.set(false);
        this.f3286b.clear();
        ArrayList r2 = new ArrayList();     // Catch: JSONException -> L38
        int r4 = 0;
    L8:
        if (r4 >= r1.length()) goto L33;
        JSONObject r5 = r1.getJSONObject(r4);     // Catch: JSONException -> L38
        int r6 = r5.optInt("cronet_flags");     // Catch: JSONException -> L38
        int r7 = r5.optInt("ttnet_flags");     // Catch: JSONException -> L38
        JSONArray r8 = r5.optJSONArray("prefix_group");     // Catch: JSONException -> L38
        JSONArray r9 = r5.optJSONArray("host_group");     // Catch: JSONException -> L38
        ArrayList r10 = new ArrayList();     // Catch: JSONException -> L38
        if (r8 == null) goto L16;
        int r11 = 0;
    L14:
        if (r11 >= r8.length()) goto L16;
        r10.add(r8.optString(r11, ""));     // Catch: JSONException -> L38
        r11 = r11 + 1;     // Catch: JSONException -> L38
    L16:
        ArrayList r12 = new ArrayList();     // Catch: JSONException -> L38
        if (r9 == null) goto L22;
        int r13 = 0;
    L20:
        if (r13 >= r9.length()) goto L22;
        r12.add(r9.optString(r13, ""));     // Catch: JSONException -> L38
        r13 = r13 + 1;     // Catch: JSONException -> L38
    L22:
        if (r6 > 0) goto L25;
        if (r7 > 0) goto L25;
    L31:
        r4 = r4 + 1;     // Catch: JSONException -> L38
    L25:
        if (r10.isEmpty() == true) goto L31;
        if (r12.isEmpty() == true) goto L31;
        r2.add(new a(r6, r7, r12, r10));     // Catch: JSONException -> L38
        if (Logger.debug() == false) goto L31;
        Logger.d("TNCRequestFlagHandler", "paths: " + r10);     // Catch: JSONException -> L38
        Logger.d("TNCRequestFlagHandler", "hosts: " + r12);     // Catch: JSONException -> L38
        Logger.d("TNCRequestFlagHandler", "flag: " + r6);     // Catch: JSONException -> L38
        Logger.d("TNCRequestFlagHandler", "type flag: " + r7);     // Catch: JSONException -> L38
        goto L31
    L33:
        if (r14.optInt("req_flag_ctl_enabled") > 0) goto L35;
        return;
    L35:
        if (r2.size() <= 0) goto L50;
        this.f3286b.addAll(r2);     // Catch: JSONException -> L38
        this.c.set(true);     // Catch: JSONException -> L38
        return;
    L50:
        return;
    }

    @Override // com.bytedance.retrofit2.SsHttpCall.IRequestFlagHandler
    public int getPriorityInContext(Request r2) {
        if (ZeusTransformUtils.instanceOf(r2.getExtraInfo(), com.bytedance.frameworks.baselib.network.http.c.class) == true) goto L5;
        return PriorityLevel.INVALID;
    L5:
        return ((com.bytedance.frameworks.baselib.network.http.c) ZeusTransformUtils.preCheckCast(r2.getExtraInfo(), com.bytedance.frameworks.baselib.network.http.c.class, "com.obric.memorydata.plugin")).D;
    }

    @Override // com.bytedance.retrofit2.SsHttpCall.IRequestFlagHandler
    public Request handleFlag(Request r8) {
        if (r8 != null) goto L5;
        return r8;
    L5:
        if (ZeusTransformUtils.instanceOf(r8.getExtraInfo(), com.bytedance.frameworks.baselib.network.http.c.class) == false) goto L12;
        int r0 = ((com.bytedance.frameworks.baselib.network.http.c) ZeusTransformUtils.preCheckCast(r8.getExtraInfo(), com.bytedance.frameworks.baselib.network.http.c.class, "com.obric.memorydata.plugin")).E;
        if (Logger.debug() == false) goto L9;
        Logger.d("TNCRequestFlagHandler", "handleFlag commonParamLevelInCtx: " + r0);
    L9:
        if (r0 <= 0) goto L12;
        r8.setCommonParamLevel(Math.max(r8.getCommonParamLevel(), r0));
    L12:
        if (this.c.get() == true) goto L14;
        return r8;
    L14:
        Iterator<a> r7 = this.f3286b.iterator();
    L15:
        boolean r2 = true;
        if (r7.hasNext() == false) goto L47;
        a r1 = (a) ZeusTransformUtils.preCheckCast(r7.next(), a.class, "com.obric.memorydata.plugin");
        Iterator<String> r4 = r1.c.iterator();
    L19:
        if (r4.hasNext() == false) goto L23;
        if (k.a(r8.getHost(), (String) ZeusTransformUtils.preCheckCast(r4.next(), String.class, "com.obric.memorydata.plugin")) == false) goto L19;
        boolean r5 = true;
    L24:
        if (r5 == false) goto L15;
        List<String> r6 = r1.d;
        if (r6 == null) goto L15;
        Iterator<String> r9 = r6.iterator();
    L31:
        if (r9.hasNext() == false) goto L37;
        String r10 = (String) ZeusTransformUtils.preCheckCast(r9.next(), String.class, "com.obric.memorydata.plugin");
        if (r8.getPath() == null) goto L31;
        if (r8.getPath().startsWith(r10) == false) goto L31;
    L38:
        if (r2 == false) goto L15;
        if (r8.getExtraInfo() != null) goto L44;
        Request.Builder r11 = r8.newBuilder();
        r11.setExtraInfo(new com.bytedance.ttnet.b.d());
        r8 = r11.build();
    L44:
        if (ZeusTransformUtils.instanceOf(r8.getExtraInfo(), com.bytedance.frameworks.baselib.network.http.c.class) == false) goto L15;
        com.bytedance.frameworks.baselib.network.http.c r3 = (com.bytedance.frameworks.baselib.network.http.c) ZeusTransformUtils.preCheckCast(r8.getExtraInfo(), com.bytedance.frameworks.baselib.network.http.c.class, "com.obric.memorydata.plugin");
        r3.r |= r1.f3287a;
        r3.m = r1.f3288b | r3.m;
        Request.Builder r12 = r8.newBuilder();
        r12.setExtraInfo(r3);
        r8 = r12.build();
        goto L15
    L37:
        r2 = false;
        goto L38
    L23:
        r5 = false;
        goto L24
    L47:
        if (ZeusTransformUtils.instanceOf(r8.getExtraInfo(), com.bytedance.frameworks.baselib.network.http.c.class) == false) goto L85;
        com.bytedance.frameworks.baselib.network.http.c r13 = (com.bytedance.frameworks.baselib.network.http.c) ZeusTransformUtils.preCheckCast(r8.getExtraInfo(), com.bytedance.frameworks.baselib.network.http.c.class, "com.obric.memorydata.plugin");
        if ((r13.m & 2048) <= 0) goto L51;
        boolean r14 = true;
    L53:
        if ((r13.m & 4096) > 0) goto L56;
        r2 = false;
    L56:
        if (r14 == true) goto L58;
        if (r2 == true) goto L58;
        return r8;
    L58:
        Request.Builder r15 = r8.newBuilder();
        ArrayList r16 = new ArrayList();
        r16.addAll(r8.getHeaders());
        if (r14 == false) goto L61;
        r16.add(new Header(Request.KEY_BYPASS_TTNET_FEATURES, "1"));
    L61:
        if (r2 == false) goto L63;
        r16.add(new Header(Request.KEY_BYPASS_DISPATCH, "1"));
    L63:
        r15.headers(r16);
        return r15.build();
    L51:
        r14 = false;
        goto L53
    L85:
        return r8;
    }

    @Override // com.bytedance.retrofit2.SsHttpCall.IRequestFlagHandler
    public boolean shouldBypassInterceptor(Request r3) {
        if (ZeusTransformUtils.instanceOf(r3.getExtraInfo(), com.bytedance.frameworks.baselib.network.http.c.class) == false) goto L10;
        com.bytedance.frameworks.baselib.network.http.c r2 = (com.bytedance.frameworks.baselib.network.http.c) ZeusTransformUtils.preCheckCast(r3.getExtraInfo(), com.bytedance.frameworks.baselib.network.http.c.class, "com.obric.memorydata.plugin");
        if ((r2.m & 1024) <= 0) goto L7;
    L8:
        return true;
    L7:
        if ((r2.m & 2048) > 0) goto L8;
        return false;
    L10:
        return false;
    }

    @Override // com.bytedance.retrofit2.SsHttpCall.IRequestFlagHandler
    public boolean shouldUseCustomInterceptor(Request r3) {
        if (ZeusTransformUtils.instanceOf(r3.getExtraInfo(), com.bytedance.frameworks.baselib.network.http.c.class) == true) goto L5;
        return false;
    L5:
        if ((((com.bytedance.frameworks.baselib.network.http.c) ZeusTransformUtils.preCheckCast(r3.getExtraInfo(), com.bytedance.frameworks.baselib.network.http.c.class, "com.obric.memorydata.plugin")).m & 8192) <= 0) goto L9;
        return true;
    L9:
        return false;
    }
}
