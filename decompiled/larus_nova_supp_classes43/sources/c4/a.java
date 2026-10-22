package c4;

import android.content.Context;
import android.util.Base64;
import com.byted.cast.sink.api.IServerListener;
import com.bytedance.ai.applet.app.foundation.w;
import com.bytedance.ai.bridge.service.IHostStyleUIDepend;
import com.bytedance.ai.event.MessageIndication;
import com.bytedance.frameworks.baselib.network.http.cronet.websocket.IMessageReceiveListener;
import d3.a0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.chromium.wschannel.WsClient;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements w {
    public static final /* synthetic */ int d = 0;
    public final AtomicLong a;
    public final Object b;
    public final Map<c, Map<Long, e>> c;

    /* JADX INFO: renamed from: c4.a$a, reason: collision with other inner class name */
    public static final class C0008a {
    }

    public static final class b {
        public final Long a;
        public final String b;
        public final f3.a c;

        public b() {
            this(null, null, null, 7);
        }

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof b) == true) goto L8;
            return false;
        L8:
            b r11 = (b) r10;
            if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r11.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r11.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final String toString() {
            return "ConnectResult(socketTaskId=" + this.a + ", errorMessage=" + this.b + ", errNo=" + this.c + ')';
        }

        public final int hashCode() {
            Long r0 = this.a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r10 = 0;
        L6:
            int r11 = r10 * 31;
            String r12 = this.b;
            if (r12 != null) goto L9;
            int r13 = 0;
        L10:
            int r14 = (r11 + r13) * 31;
            f3.a r15 = this.c;
            if (r15 == null) goto L15;
            r1 = r15.a;
        L15:
            return r14 + r1;
        L9:
            r13 = r12.hashCode();
            goto L10
        L5:
            r10 = r0.hashCode();
            goto L6
        }

        public b(Long r10, String r11, f3.a r12, int r13) {
            if ((r13 & 1) == 0) goto L6;
            r10 = null;
        L6:
            if ((r13 & 2) == 0) goto L9;
            r11 = null;
        L9:
            if ((r13 & 4) == 0) goto L11;
            r12 = null;
        L11:
            this.a = r10;
            this.b = r11;
            this.c = r12;
        }
    }

    public static final class c {
        public static final /* synthetic */ int c = 0;
        public final String a;
        public final String b;

        /* JADX INFO: renamed from: c4.a$c$a, reason: collision with other inner class name */
        public static final class C0009a {
            public static c a(e3.d r10) {
                Intrinsics.checkNotNullParameter(r10, "bridgeContext");
                a0 r11 = r10.getContainerContext();
                if (r11 != null) goto L6;
                return null;
            L6:
                Intrinsics.checkNotNullParameter(r11, "containerContext");
                String r1 = r11.getAppletId();
                if (r1 != null) goto L10;
                r1 = "";
            L10:
                return new c(r1, r11.getContainerId());
            }
        }

        static {
        }

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof c) == true) goto L8;
            return false;
        L8:
            c r11 = (c) r10;
            if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r11.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "OwnerKey(appletId=" + this.a + ", containerId=" + this.b + ')';
        }

        public c(String r10, String r11) {
            Intrinsics.checkNotNullParameter(r10, "appletId");
            Intrinsics.checkNotNullParameter(r11, "containerId");
            this.a = r10;
            this.b = r11;
        }
    }

    public static final class d {
        public final String a;
        public final f3.a b;

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof d) == true) goto L8;
            return false;
        L8:
            d r11 = (d) r10;
            if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r11.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final String toString() {
            return "SocketOperationError(message=" + this.a + ", errNo=" + this.b + ')';
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.a;
        }

        public d(String r10, f3.a r11) {
            Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_MSG);
            Intrinsics.checkNotNullParameter(r11, "errNo");
            this.a = r10;
            this.b = r11;
        }
    }

    public final class e implements IMessageReceiveListener {
        public final long a;
        public final c b;
        public final e3.d c;
        public final WsClient d;
        public volatile boolean e;
        public final /* synthetic */ a f;

        public final void onFeedBackLog(String r1) {
        }

        public final d a(int r11, String r12) {
            if (this.e == false) goto L5;
            return null;
        L5:
            this.e = true;
            Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L8
            this.d.stopConnection();     // Catch: Throwable -> L8
            Object r13 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L8
        L10:
            Throwable r14 = Result.exceptionOrNull-impl(r13);
            if (r14 == null) goto L17;
            String r15 = r14.getMessage();
            if (r15 != null) goto L16;
            r15 = "Failed to close WebSocket";
        L16:
            return new d(r15, f3.a.y);
        L17:
            a r16 = this.f;
            e3.d r17 = this.c;
            long r18 = this.a;
            Pair[] r19 = new Pair[3];
            r19[0] = TuplesKt.to("code", Integer.valueOf(r11));
            if (r12 != null) goto L20;
            String r20 = "";
        L21:
            r19[1] = TuplesKt.to("reason", r20);
            if (r12 != null) goto L24;
            r12 = "";
        L24:
            r19[2] = TuplesKt.to("errMsg", r12);
            a.c(r16, r17, r18, "closed", MapsKt.mapOf(r19));
            return null;
        L20:
            r20 = r12;
        L8:
            th = move-exception;
            Result.Companion r21 = Result.Companion;
            r13 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L10
        }

        public final void b(String r10, Map<String, ? extends Object> r11) {
            if (this.e == false) goto L5;
            return;
        L5:
            this.e = true;
            a.c(this.f, this.c, this.a, r10, r11);
            a r12 = this.f;
            long r0 = this.a;
            Object r13 = r12.b;
            monitor-enter(r13);
            r12.i(r0, this.b, this);     // Catch: Throwable -> L10
            monitor-exit(r13);
            return;
        L10:
            th = move-exception;
            throw th;
        }

        public final void onMessage(byte[] r14, int r15) {
            if (this.e == true) goto L11;
            if (r14 != null) goto L7;
            return;
        L7:
            if (r15 != 1) goto L9;
            a.b(this.f, this.c, this.a, new String(r14, Charsets.UTF_8), "string");
            return;
        L9:
            a.b(this.f, this.c, this.a, Base64.encodeToString(r14, 2), "base64");
            return;
        }

        public final d c(byte[] r10, int r11, String r12) {
            if (this.e == false) goto L21;
            a r13 = this.f;
            int r14 = a.d;
            r13.getClass();
            return new d("The socketTaskId doesn't exist", f3.a.q);
        L21:
            Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L8
            Object r15 = Result.constructor-impl(Boolean.valueOf(this.d.sendMessage(r10, r11)));     // Catch: Throwable -> L8
        L10:
            Throwable r16 = Result.exceptionOrNull-impl(r15);
            if (r16 == null) goto L13;
            String r17 = r16.getMessage();
            if (r17 != null) goto L20;
            r17 = "Failed to send WebSocket ".concat(r12);
        L20:
            return new d(r17, f3.a.y);
        L13:
            if (((Boolean) r15).booleanValue() == false) goto L24;
            return null;
        L24:
            return new d("Failed to send WebSocket ".concat(r12), f3.a.y);
        L8:
            th = move-exception;
            Result.Companion r18 = Result.Companion;
            r15 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L10
        }

        public final void onConnection(int r10, String r11, JSONObject r12) {
            if (this.e == false) goto L5;
            return;
        L5:
            if (r12 == null) goto L7;
            r10 = r12.optInt("state", r10);
        L7:
            if (r12 == null) goto L9;
            String r13 = r12.optString(IHostStyleUIDepend.TOAST_TYPE_ERROR);
        L11:
            if (r13 != null) goto L13;
            r13 = "";
        L13:
            boolean r14 = false;
            if (r13.length() <= 0) goto L16;
            boolean r0 = true;
        L18:
            if (r0 == true) goto L26;
            if (r10 == 2) goto L26;
            if (r10 != 3) goto L24;
            b("closed", MapsKt.mapOf(new Pair[]{TuplesKt.to("code", Integer.valueOf(IServerListener.WHAT_BYTELINK_SINK_ERROR)), TuplesKt.to("reason", ""), TuplesKt.to("errMsg", "")}));
            return;
        L24:
            if (r10 != 4) goto L42;
            a.c(this.f, this.c, this.a, "connected", MapsKt.mapOf(TuplesKt.to("header", MapsKt.emptyMap())));
            return;
        L42:
            return;
        L26:
            Pair[] r15 = new Pair[3];
            if (r13.length() != 0) goto L29;
            boolean r16 = true;
        L31:
            if (r16 == false) goto L33;
            String r17 = "WebSocket connection failed";
        L34:
            r15[0] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_MSG, r17);
            if (r13.length() != 0) goto L37;
            r14 = true;
        L37:
            if (r14 == false) goto L39;
            r13 = "WebSocket connection failed";
        L39:
            r15[1] = TuplesKt.to("errMsg", r13);
            r15[2] = TuplesKt.to("code", -1);
            b(MessageIndication.STATUS_FAILED, MapsKt.mapOf(r15));
            return;
        L33:
            r17 = r13;
            goto L34
        L29:
            r16 = false;
            goto L31
        L16:
            r0 = false;
            goto L18
        L9:
            r13 = null;
            goto L11
        }

        public e(a r10, long r11, c r12, e3.d r13) {
            Intrinsics.checkNotNullParameter(r12, "ownerKey");
            Intrinsics.checkNotNullParameter(r13, "bridgeContext");
            this.f = r10;
            this.a = r11;
            this.b = r12;
            this.c = r13;
            this.d = new WsClient(this);
        }
    }

    static {
    }

    @Override // com.bytedance.ai.applet.app.foundation.w
    public final void d() {
    }

    @Override // com.bytedance.ai.applet.app.foundation.w
    public final void onDestroy() {
    }

    public a() {
        this.a = new AtomicLong(0);
        this.b = new Object();
        this.c = new LinkedHashMap();
    }

    @Override // com.bytedance.ai.applet.app.foundation.w
    public final void a(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
    }

    public final void f(e3.a r10) {
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        int r0 = c.c;
        c r11 = c.C0009a.a(r10);
        if (r11 != null) goto L5;
        return;
    L5:
        Object r1 = this.b;
        monitor-enter(r1);
        Map<Long, e> r12 = this.c.remove(r11);     // Catch: Throwable -> L20
        if (r12 == null) goto L13;
        Collection<e> r13 = r12.values();     // Catch: Throwable -> L20
        if (r13 == null) goto L13;
        List r14 = CollectionsKt.toList(r13);     // Catch: Throwable -> L20
        if (r14 == null) goto L13;
    L14:
        monitor-exit(r1);
        Iterator r15 = r14.iterator();
    L17:
        if (r15.hasNext() == false) goto L19;
        ((e) r15.next()).a(IServerListener.WHAT_BYTELINK_SINK_ERROR, null);
        goto L17
    L19:
        return;
    L13:
        r14 = CollectionsKt.emptyList();     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.ai.applet.app.foundation.w
    public final void g(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
    }

    @Override // com.bytedance.ai.applet.app.foundation.w
    public final void h(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
    }

    public static Map e(Map r13, List r14) {
        LinkedHashMap r0 = new LinkedHashMap();
        if (r13 != null) goto L5;
        r13 = MapsKt.emptyMap();
    L5:
        Iterator r15 = r13.entrySet().iterator();
    L7:
        if (r15.hasNext() == false) goto L16;
        Map.Entry r1 = (Map.Entry) r15.next();
        String r10 = (String) r1.getKey();
        String r11 = (String) r1.getValue();
        String r12 = StringsKt.trim(r10).toString();
        if ((!StringsKt.isBlank(r12)) == false) goto L7;
        if (StringsKt.equals(r12, "referer", true) == true) goto L7;
        if (StringsKt.equals(r12, "Sec-WebSocket-Protocol", true) == true) goto L7;
        if (r11 == null) goto L7;
        r0.put(r12, r11);
        goto L7
    L16:
        if (r14 != null) goto L18;
        r14 = CollectionsKt.emptyList();
    L18:
        List r16 = r14;
        ArrayList r17 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r16, 10));
        Iterator r18 = r16.iterator();
    L20:
        if (r18.hasNext() == false) goto L22;
        r17.add(StringsKt.trim((String) r18.next()).toString());
        goto L20
    L22:
        ArrayList r19 = new ArrayList();
        Iterator r110 = r17.iterator();
    L24:
        if (r110.hasNext() == false) goto L28;
        Object r111 = r110.next();
        if ((!StringsKt.isBlank((String) r111)) == false) goto L24;
        r19.add(r111);
        goto L24
    L28:
        String r112 = CollectionsKt.joinToString$default(r19, ",", null, null, 0, null, null, 62, null);
        if ((!StringsKt.isBlank(r112)) == false) goto L31;
        r0.put("Sec-WebSocket-Protocol", r112);
    L31:
        return r0;
    }

    public final e j(e3.d r10, long r11) {
        int r0 = c.c;
        c r12 = c.C0009a.a(r10);
        e r1 = null;
        if (r12 != null) goto L5;
        return null;
    L5:
        Object r13 = this.b;
        monitor-enter(r13);
        Map r14 = (Map) ((LinkedHashMap) this.c).get(r12);     // Catch: Throwable -> L16
        if (r14 == null) goto L14;
        e r15 = (e) r14.get(Long.valueOf(r11));     // Catch: Throwable -> L16
        if (r15 == null) goto L14;
        Intrinsics.checkNotNullParameter(r12, "ownerKey");     // Catch: Throwable -> L16
        if (Intrinsics.areEqual(r15.b, r12) == false) goto L14;
        r1 = r15;
    L14:
        monitor-exit(r13);
        return r1;
    L16:
        th = move-exception;
        throw th;
    }

    public final e i(long r10, c r11, e r12) {
        Map r0 = (Map) ((LinkedHashMap) this.c).get(r11);
        if (r0 != null) goto L5;
        return null;
    L5:
        e r13 = (e) r0.get(Long.valueOf(r10));
        if (r13 != null) goto L8;
        return null;
    L8:
        Intrinsics.checkNotNullParameter(r11, "ownerKey");
        if (Intrinsics.areEqual(r13.b, r11) == true) goto L11;
        return null;
    L11:
        if (r12 == null) goto L14;
        if (r13 == r12) goto L14;
        return null;
    L14:
        r0.remove(Long.valueOf(r10));
        if (r0.isEmpty() == false) goto L17;
        this.c.remove(r11);
    L17:
        return r13;
    }

    public static final void b(a r10, e3.d r11, long r12, String r13, String r14) {
        r10.getClass();
        Lazy r15 = com.bytedance.ai.applet.base.gson.e.a;
        r11.a("socketDataReceived", com.bytedance.ai.applet.base.gson.e.d(MapsKt.mapOf(new Pair[]{TuplesKt.to("socketTaskId", Long.valueOf(r12)), TuplesKt.to("socketTaskID", String.valueOf(r12)), TuplesKt.to("data", r13), TuplesKt.to("dataType", r14), TuplesKt.to("protocolType", "websocket"), TuplesKt.to("socketType", "tradition")})));
    }

    public static final void c(a r1, e3.d r10, long r11, String r12, Map r13) {
        r1.getClass();
        Lazy r14 = com.bytedance.ai.applet.base.gson.e.a;
        Map r15 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_STATUS, r12), TuplesKt.to("socketTaskId", Long.valueOf(r11)), TuplesKt.to("socketTaskID", String.valueOf(r11)), TuplesKt.to("protocolType", "websocket"), TuplesKt.to("socketType", "tradition")});
        r15.putAll(r13);
        Unit r16 = Unit.INSTANCE;
        r10.a("socketStatusChanged", com.bytedance.ai.applet.base.gson.e.d(r15));
    }
}
