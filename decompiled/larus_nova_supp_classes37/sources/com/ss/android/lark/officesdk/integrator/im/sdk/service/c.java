package com.ss.android.lark.officesdk.integrator.im.sdk.service;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.DevEnvUtil;
import com.ss.android.lark.appreciablelib.AppreciableKit;
import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.appreciablelib.ErrorLevel;
import com.ss.android.lark.appreciablelib.ErrorParams;
import com.ss.android.lark.appreciablelib.ErrorType;
import com.ss.android.lark.appreciablelib.Event;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.biz.im.api.bundle.ChatType;
import com.ss.android.lark.biz.im.api.bundle.SourceType;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import e0c.k;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class c implements okb.d {

    public static final class a implements x1b.c {
        public a() {
        }

        public final void c() {
            vtb.c.a("key_doc", SourceType.PROFILE);
        }

        public final void g() {
            vtb.c.a r0 = (vtb.c.a) ((ConcurrentHashMap) vtb.c.a).get("key_chatwindow");
            if (r0 == null) goto L6;
            r0.x = System.currentTimeMillis();
            Log.d("PerfEnterChatMonitor", "endRenderMessage");
            int r1 = vtb.a.a;
            PerfLog.end("load_net_data", "");
        L6:
            fsb.f.b().e();
        }

        public final void i() {
            vtb.c.a r0 = (vtb.c.a) ((ConcurrentHashMap) vtb.c.a).get("key_chatwindow");
            if (r0 != null) goto L6;
            return;
        L6:
            if (r0.v == false) goto L8;
            r0.w = System.currentTimeMillis();
            r0.v = false;
            r0.u = SystemClock.elapsedRealtime() - r0.u;
            Log.d("PerfEnterChatMonitor", "messageWaitCost=" + r0.u);
        L8:
            Log.d("PerfEnterChatMonitor", "beginRenderMessage");
            int r1 = vtb.a.a;
            PerfLog.start("load_net_data", "");
        }

        public final void k() {
            vtb.c.a r0 = (vtb.c.a) ((ConcurrentHashMap) vtb.c.a).get("key_chatwindow");
            if (r0 == null) goto L7;
            r0.d = Long.valueOf(System.currentTimeMillis());
            Log.d("PerfEnterChatMonitor", "endRender");
            return;
        }

        public final void m() {
            vtb.c.a r0 = (vtb.c.a) ((ConcurrentHashMap) vtb.c.a).get("key_chatwindow");
            if (r0 == null) goto L7;
            r0.f = Long.valueOf(System.currentTimeMillis());
            Log.d("PerfEnterChatMonitor", "endLoadData");
            int r1 = vtb.a.a;
            PerfLog.end("load_local_data", "");
            return;
        }

        public final void n() {
            vtb.c.a r0 = (vtb.c.a) ((ConcurrentHashMap) vtb.c.a).get("key_chatwindow");
            if (r0 != null) goto L6;
            return;
        L6:
            if (r0.t <= 0) goto L8;
            r0.t = SystemClock.elapsedRealtime() - r0.t;
            Log.d("PerfEnterChatMonitor", "messageDelayCost=" + r0.t);
            int r1 = vtb.a.a;
            PerfLog.end("message_data_delay_cost", "");
        L8:
            r0.v = true;
            Log.d("PerfEnterChatMonitor", "markReadyRenderMessage");
        }

        public final void q() {
            vtb.c.a r0 = (vtb.c.a) ((ConcurrentHashMap) vtb.c.a).get("key_chatwindow");
            if (r0 == null) goto L7;
            Log.d("PerfEnterChatMonitor", "activityStop");
            r0.n = true;
            return;
        }

        public final void r() {
            vtb.c.a r0 = (vtb.c.a) ((ConcurrentHashMap) vtb.c.a).get("key_chatwindow");
            if (r0 == null) goto L6;
            r0.c = Long.valueOf(System.currentTimeMillis());
            Log.d("PerfEnterChatMonitor", "beginRender");
        L6:
            fsb.f.b().g();
        }

        public final void s() {
            vtb.c.a r0 = (vtb.c.a) ((ConcurrentHashMap) vtb.c.a).get("key_chatwindow");
            if (r0 == null) goto L7;
            r0.h = Long.valueOf(System.currentTimeMillis());
            Log.d("PerfEnterChatMonitor", "endLoadNetData");
            int r1 = vtb.a.a;
            PerfLog.end("load_net_data", "");
            return;
        }

        public final void t() {
            vtb.c.a("key_doc", SourceType.CARD);
        }

        public final void a(String r6) {
            Intrinsics.checkNotNullParameter(r6, "chatSourceType");
            ((zyb.e) k.a(LarkContext.getApplication(), zyb.e.class)).a();
            SourceType.Companion.getClass();
            SourceType[] r0 = SourceType.values();
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L8;
            SourceType r3 = r0[r2];
            if (TextUtils.equals(r3.value, r6) == true) goto L9;
            r2 = r2 + 1;
        L9:
            vtb.c.a("key_chatwindow", r3);
            return;
        L8:
            r3 = SourceType.UNKNOWN;
            goto L9
        }

        public final void d(boolean r8) {
            vtb.c.a r0 = (vtb.c.a) ((ConcurrentHashMap) vtb.c.a).get("key_chatwindow");
            if (r0 != null) goto L6;
            return;
        L6:
            if (r8 == false) goto L8;
            r0.k = Long.valueOf(SystemClock.elapsedRealtime());
            int r3 = vtb.a.a;
            PerfLog.start("init_view", "");
        L9:
            Log.d("PerfEnterChatMonitor", "initView:" + r8 + "/" + r0.k);
            return;
        L8:
            r0.k = Long.valueOf(SystemClock.elapsedRealtime() - r0.k.longValue());
            int r4 = vtb.a.a;
            PerfLog.end("init_view", "");
            goto L9
        }

        public final void h(boolean r8) {
            vtb.c.a r0 = (vtb.c.a) ((ConcurrentHashMap) vtb.c.a).get("key_chatwindow");
            if (r0 != null) goto L6;
            return;
        L6:
            if (r8 == false) goto L8;
            r0.i = Long.valueOf(SystemClock.elapsedRealtime());
            int r3 = vtb.a.a;
            PerfLog.start("get_chat_launcher_info", "");
        L9:
            Log.d("PerfEnterChatMonitor", "getLauncherInfo:" + r8 + "/" + r0.i);
            return;
        L8:
            r0.i = Long.valueOf(SystemClock.elapsedRealtime() - r0.i.longValue());
            int r4 = vtb.a.a;
            PerfLog.end("get_chat_launcher_info", "");
            goto L9
        }

        public final void j(boolean r6) {
            vtb.c.a r0 = (vtb.c.a) ((ConcurrentHashMap) vtb.c.a).get("key_chatwindow");
            if (r0 == null) goto L10;
            if (r6 == false) goto L7;
            r0.l = Long.valueOf(SystemClock.elapsedRealtime());
        L8:
            Log.d("PerfEnterChatMonitor", "loadMessageFromNet:" + r6 + "/" + r0.l);
            return;
        L7:
            r0.l = Long.valueOf(SystemClock.elapsedRealtime() - r0.l.longValue());
            goto L8
        }

        public final void l(boolean r8) {
            vtb.c.a r0 = (vtb.c.a) ((ConcurrentHashMap) vtb.c.a).get("key_chatwindow");
            if (r0 != null) goto L6;
            return;
        L6:
            if (r8 == false) goto L8;
            r0.j = Long.valueOf(SystemClock.elapsedRealtime());
            int r3 = vtb.a.a;
            PerfLog.start("open_chat_activity", "");
        L9:
            Log.d("PerfEnterChatMonitor", "openChatActivity:" + r8 + "/" + r0.j);
            return;
        L8:
            r0.j = Long.valueOf(SystemClock.elapsedRealtime() - r0.j.longValue());
            int r4 = vtb.a.a;
            PerfLog.end("open_chat_activity", "");
            goto L9
        }

        public final void p(String r4) {
            Intrinsics.checkNotNullParameter(r4, "chatId");
            vtb.c.a r0 = (vtb.c.a) ((ConcurrentHashMap) vtb.c.a).get("key_chatwindow");
            if (r0 == null) goto L7;
            r0.p = r4;
            r0.e = Long.valueOf(System.currentTimeMillis());
            Log.d("PerfEnterChatMonitor", "beginLoadData");
            int r5 = vtb.a.a;
            PerfLog.start("load_local_data", "");
            return;
        }

        public final void o(String r4, String r5) {
            Intrinsics.checkNotNullParameter(r4, "chatId");
            Intrinsics.checkNotNullParameter(r5, "contextId");
            vtb.c.a r0 = (vtb.c.a) ((ConcurrentHashMap) vtb.c.a).get("key_chatwindow");
            if (r0 == null) goto L7;
            r0.p = r4;
            r0.o = r5;
            r0.g = Long.valueOf(System.currentTimeMillis());
            Log.d("PerfEnterChatMonitor", "beginLoadNetData: " + r5);
            int r6 = vtb.a.a;
            PerfLog.start("load_net_data", "");
            return;
        }

        public final void b(long r3, long r5, List r7) {
            Intrinsics.checkNotNullParameter(r7, "netCosts");
            vtb.c.a r0 = (vtb.c.a) ((ConcurrentHashMap) vtb.c.a).get("key_chatwindow");
            if (r0 == null) goto L7;
            r0.q = r3;
            r0.s = r5;
            r0.r = r7;
            Log.d("PerfEnterChatMonitor", "recordCost");
            return;
        }

        public final void e(String r20, boolean r21, ErrorResult r22) {
            Intrinsics.checkNotNullParameter(r20, "chatSourceType");
            Intrinsics.checkNotNullParameter(r22, "errorResult");
            ChatType.Companion.getClass();
            ChatType r0 = ChatType.a.a(r20);
            ConcurrentHashMap r1 = (ConcurrentHashMap) vtb.c.a;
            vtb.c.a r4 = (vtb.c.a) r1.get("key_chatwindow");
            if (r0 == null) goto L11;
            if (r4 == null) goto L12;
            r1.remove("key_chatwindow");
            Long r2 = Long.valueOf(System.currentTimeMillis());
            r4.b = r2;
            r4.G = r0;
            r4.E = r21;
            r4.B = Long.valueOf(r2.longValue() - r4.a.longValue());
            Log.i("PerfEnterChatMonitor", "end: key_chatwindow/" + r0);
            AppreciableKit r3 = AppreciableKit.getInstance();
            Biz r6 = Biz.Messenger;
            Scene r7 = Scene.Chat;
            Event r8 = Event.enter_chat;
            ErrorType r9 = ErrorType.Network;
            ErrorLevel r10 = ErrorLevel.Fatal;
            int r11 = r22.getErrorCode();
            String r14 = r22.getDisplayMsg();
            Boolean r15 = Boolean.TRUE;
            HashMap r5 = new HashMap();
            String r12 = r4.o;
            if (r12 != null) goto L9;
            r12 = "";
        L9:
            r5.put("context_id", r12);
            r3.error(new ErrorParams(r6, r7, r8, r9, r10, r11, null, "chatwindow", r14, r15, r5, r4.b(), r4.a()));
            return;
        L12:
            return;
        }

        public final void f(Context r11, String r12, boolean r13, int r14, boolean r15) {
            Intrinsics.checkNotNullParameter(r11, "context");
            Intrinsics.checkNotNullParameter(r12, "chatSourceType");
            ((zyb.e) k.a(LarkContext.getApplication(), zyb.e.class)).a();
            ChatType.Companion.getClass();
            ChatType r16 = ChatType.a.a(r12);
            ConcurrentHashMap r0 = (ConcurrentHashMap) vtb.c.a;
            vtb.c.a r2 = (vtb.c.a) r0.get("key_chatwindow");
            if (r16 == null) goto L67;
            if (r2 == null) goto L70;
            r0.remove("key_chatwindow");
            Long r1 = Long.valueOf(System.currentTimeMillis());
            r2.b = r1;
            r2.G = r16;
            r2.E = r13;
            r2.D = r14;
            r2.m = r15;
            r2.B = Long.valueOf(r1.longValue() - r2.a.longValue());
            if (DevEnvUtil.isDebugMode(r11) == false) goto L10;
            Log.e("PerfEnterChatMonitor", "not upload in debug mode");
            return;
        L10:
            if (r2.B.longValue() > 0) goto L12;
        L30:
            boolean r17 = false;
        L31:
            if (r17 == true) goto L33;
            Log.e("PerfEnterChatMonitor", "report data is invalid");
            return;
        L33:
            AppreciableKit r18 = AppreciableKit.getInstance();
            String r19 = r2.y;
            if (r19 != null) goto L36;
            r19 = "";
        L36:
            HashMap r5 = new HashMap();
            r5.put("sdk_cost", Long.valueOf(r2.q));
            r5.put("client_data_cost", Long.valueOf(r2.s));
            r5.put("client_render_cost", Long.valueOf(r2.x - r2.w));
            r5.put("first_render", 0L);
            HashMap r6 = new HashMap();
            String r3 = r2.o;
            if (r3 != null) goto L39;
            r3 = "";
        L39:
            r6.put("context_id", r3);
            r18.end(r19, r5, r6, r2.b(), r2.a());
            int r110 = vtb.a.a;
            PerfLog.end("open_chat", "");
            Log.i("PerfEnterChatMonitor", "end: key_chatwindow/" + r16);
            Map<Integer, Long> r111 = r2.z;
            if (r111 == null) goto L55;
            if (((HashMap) r111).size() == 0) goto L55;
            Iterator r112 = ((HashMap) r2.z).entrySet().iterator();     // Catch: JSONException -> L52
        L46:
            if (r112.hasNext() == false) goto L55;
            Map.Entry r113 = (Map.Entry) r112.next();     // Catch: JSONException -> L52
            if (((Integer) r113.getKey()).intValue() < 8) goto L46;
            JSONObject r114 = new JSONObject();     // Catch: JSONException -> L52
            r114.put("message_type", r113.getKey());     // Catch: JSONException -> L52
            r114.put("message_bind_cost", r113.getValue());     // Catch: JSONException -> L52
            Statistics.sendEvent("android_chat_bind_time", r114);     // Catch: JSONException -> L52
        L52:
            e = move-exception;
            e.printStackTrace();
        L55:
            if (TextUtils.equals("key_chatwindow", "key_chatwindow") == false) goto L57;
            CoreThreadPool.getDefault().getCachedThreadPool().execute(new vtb.b(r2));
            Log.i("PerfEnterChatMonitor", "perfLoadChat = " + r2);
        L57:
            idb.f.a().isCurrentEnable("openplatform.universal_card.enter_chat_monitor");
            return;
        L12:
            if (r2.B.longValue() > 60000) goto L30;
            if (r2.c.longValue() > r2.d.longValue()) goto L30;
            if (r2.e.longValue() > r2.f.longValue()) goto L30;
            if (r2.g.longValue() > r2.h.longValue()) goto L30;
            if (r2.w > r2.x) goto L30;
            if (r2.n == true) goto L30;
            r17 = true;
            goto L31
        L70:
            return;
        }
    }

    public c() {
    }

    public final x1b.c a() {
        return new a();
    }
}
