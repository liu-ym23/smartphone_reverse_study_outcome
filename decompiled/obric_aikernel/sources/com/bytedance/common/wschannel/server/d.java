package com.bytedance.common.wschannel.server;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.reflect.Reflect;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import com.bytedance.ttnet.TTNetInit;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile e f1410a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Context f1411b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile boolean f1412c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final AtomicBoolean f1413d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static CountDownLatch f1414e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static b f1415f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static Object f1416g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String f1417h = null;

    static class a extends g2.e {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b(new e(d.c()));
            d.a().o();
        }
    }

    public interface b {
        void a(String r10, JSONObject r11);
    }

    static {
        f1413d = new AtomicBoolean(false);
        f1414e = new CountDownLatch(1);
        f1417h = d.class.getSimpleName();
    }

    public d() {
    }

    static /* synthetic */ e a() {
        return f1410a;
    }

    static /* synthetic */ e b(e r10) {
        f1410a = r10;
        return r10;
    }

    static /* synthetic */ Context c() {
        return f1411b;
    }

    @Nullable
    private static Map<String, String> d(List<WsChannelMsg.MsgHeader> r10) {
        if (r10 != null) goto L4;
        return null;
    L4:
        if (r10.isEmpty() == true) goto L24;
        HashMap r11 = new HashMap();
        Iterator<WsChannelMsg.MsgHeader> r12 = r10.iterator();
    L8:
        if (r12.hasNext() == false) goto L14;
        WsChannelMsg.MsgHeader r13 = r12.next();
        if (TextUtils.isEmpty(r13.getKey()) == true) goto L8;
        if (TextUtils.isEmpty(r13.getValue()) == true) goto L8;
        r11.put(r13.getKey(), r13.getValue());
        goto L8
    L14:
        return r11;
    L24:
        return null;
    }

    @Nullable
    private static String[] e(Map<String, String> r10) {
        if (r10.containsKey("x_frontier_is_ack") == true) goto L5;
    L15:
        return null;
    L5:
        if (r10.containsKey("x_frontier_ack_msgid") == false) goto L15;
        if (r10.get("x_frontier_is_ack").equals(NetConst.ENCRYPT_VERISON_CODE) == true) goto L11;
        return null;
    L11:
        if (TextUtils.isEmpty(r10.get("x_frontier_ack_msgid")) == false) goto L14;
        return null;
    L14:
        return r10.get("x_frontier_ack_msgid").split(",");
    }

    private static void f() {
        if (f1416g == null) goto L12;
        return;
    L12:
        String r10 = TTNetInit.DOMAIN_HTTPDNS_KEY;     // Catch: Throwable -> L9
        f1416g = TTNetInit.class.newInstance();     // Catch: Throwable -> L9
        if (Logger.debug() == false) goto L14;
        Logger.d(f1417h, "Get TTNetInit instance success.");     // Catch: Throwable -> L9
        return;
    L14:
        return;
    L9:
        th = move-exception;
        Logger.e(f1417h, "Get TTNetInit instance failed.");
        th.printStackTrace();
    }

    private static boolean g(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L6;
        return false;
    L6:
        if (r10.equals("x_frontier_qos") == false) goto L8;
    L15:
        return true;
    L8:
        if (r10.equals(WsConstants.KEY_FRONTIER_MSGID) == true) goto L15;
        if (r10.equals("x_frontier_ttl") == true) goto L15;
        if (r10.equals("x_frontier_ack_msgid") == true) goto L15;
        if (r10.equals("x_frontier_is_ack") == true) goto L15;
        return false;
    }

    private static boolean h(Map<String, String> r10) {
        if (r10.containsKey("x_frontier_qos") == true) goto L5;
    L31:
        return false;
    L5:
        if (r10.containsKey("x_frontier_qos_ack") == false) goto L31;
        if (r10.containsKey("x_frontier_is_ack") == false) goto L31;
        if (r10.containsKey("x_frontier_ack_msgid") == false) goto L31;
        if (r10.get("x_frontier_qos") == null) goto L31;
        if (r10.get("x_frontier_qos").equals("2") == false) goto L31;
        if (r10.get("x_frontier_qos_ack") == null) goto L31;
        if (r10.get("x_frontier_qos_ack").equals(NetConst.ENCRYPT_VERISON_CODE) == false) goto L31;
        if (r10.get("x_frontier_is_ack") == null) goto L31;
        if (r10.get("x_frontier_is_ack").equals(NetConst.ENCRYPT_VERISON_CODE) == false) goto L31;
        if (TextUtils.isEmpty(r10.get("x_frontier_ack_msgid")) == false) goto L29;
        return false;
    L29:
        return true;
    }

    private static boolean i(Map<String, String> r10) {
        if (r10.containsKey("x_frontier_qos") == true) goto L5;
    L26:
        return false;
    L5:
        if (r10.containsKey(WsConstants.KEY_FRONTIER_MSGID) == false) goto L26;
        if (r10.containsKey("x_frontier_ttl") == false) goto L26;
        if (r10.get("x_frontier_qos") == null) goto L26;
        if (r10.get("x_frontier_qos").equals("2") == false) goto L26;
        String r11 = r10.get(WsConstants.KEY_FRONTIER_MSGID);
        if (TextUtils.isEmpty(r11) == true) goto L26;
        if (r11.getBytes("UTF-8").length != 32) goto L26;
        if (Long.valueOf(r10.get("x_frontier_ttl")).longValue() > 0) goto L24;
        return false;
    L24:
        return true;
    }

    private static void j(WsChannelMsg r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.getMsgHeaders() == null) goto L20;
        Iterator<WsChannelMsg.MsgHeader> r11 = r10.getMsgHeaders().iterator();
        if (r11 != null) goto L10;
        return;
    L10:
        if (r11.hasNext() == false) goto L21;
        if (g(r11.next().getKey()) == false) goto L10;
        r11.remove();
        goto L10
    L21:
        return;
    }

    public static void k(JSONObject r10) {
        b r11 = f1415f;
        if (r11 == null) goto L10;
        r11.a("frontier_qos2", r10);
    L10:
        Object r12 = f1416g;     // Catch: Throwable -> L9
        if (r12 == null) goto L12;
        Reflect.on(r12).call("monitorLogSend", new Class[]{String.class, JSONObject.class}, new Object[]{"frontier_qos2", r10});     // Catch: Throwable -> L9
        return;
    L12:
        return;
    }

    static void l() {
        f1413d.set(true);
        f1414e.countDown();
    }

    public static boolean m(WsChannelMsg r10) {
        if (f1412c == true) goto L35;
        return false;
    L35:
        Map<String, String> r11 = d(r10.getMsgHeaders());     // Catch: Throwable -> L32
        if (r11 != null) goto L8;
    L31:
        return false;
    L8:
        if (r11.isEmpty() == true) goto L31;
        boolean r12 = h(r11);     // Catch: Throwable -> L32
        boolean r13 = i(r11);     // Catch: Throwable -> L32
        if (r12 == true) goto L14;
        if (r13 == true) goto L14;
        return false;
    L14:
        AtomicBoolean r14 = f1413d;     // Catch: Throwable -> L32
        if (r14.get() == true) goto L18;
        f();     // Catch: Throwable -> L32
        g2.d.d().e(new a());     // Catch: Throwable -> L32
        n();     // Catch: Throwable -> L32
    L18:
        if (r14.get() == true) goto L21;
        return false;
    L21:
        if (f1410a != null) goto L24;
        return false;
    L24:
        if (Logger.debug() == false) goto L26;
        Logger.d(f1417h, "origin wschannel msg:" + r10.toString());     // Catch: Throwable -> L32
    L26:
        if (r12 == false) goto L29;
        f1410a.i(r11.get("x_frontier_ack_msgid").split(","));     // Catch: Throwable -> L32
        return true;
    L29:
        f1410a.i(e(r11));     // Catch: Throwable -> L32
        j(r10);     // Catch: Throwable -> L32
        return f1410a.B(r11.get(WsConstants.KEY_FRONTIER_MSGID), Long.valueOf(r11.get("x_frontier_ttl")).longValue());
    L32:
        th = move-exception;
        th.printStackTrace();
        return false;
    }

    private static void n() {
        if (f1413d.get() == true) goto L11;
        f1414e.await(WsConstants.EXIT_DELAY_TIME, TimeUnit.MILLISECONDS);     // Catch: Exception -> L8
        if (f1414e.getCount() != 1) goto L12;
        f1414e.countDown();     // Catch: Exception -> L8
        return;
    L12:
        return;
    L13:
        return;
    }
}
