package com.bytedance.android.annie.websocket;

import android.util.Base64;
import com.bytedance.ai.event.MessageIndication;
import com.bytedance.android.annie.bridge.method.o2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class SocketManager {
    public static final HashMap<String, HashMap<String, ? super com.bytedance.android.annie.websocket.b>> a = null;
    public static final Lazy<SocketManager> b = null;

    public static final class a {
        public static SocketManager a() {
            return (SocketManager) SocketManager.b.getValue();
        }
    }

    public final class b implements j {
        public final String a;
        public final String b;
        public final d c;
        public final /* synthetic */ SocketManager d;

        @Override // com.bytedance.android.annie.websocket.j
        public final void onClosed() {
            String r10 = this.b;
            Intrinsics.checkNotNullParameter("closed", com.bytedance.android.ec.core.event.a.KEY_STATUS);
            Intrinsics.checkNotNullParameter(r10, "socketTaskID");
            this.c.a(new e("closed", r10, "unknow error", null, null));
            SocketManager.a(this.d, this.a, this.b);
        }

        @Override // com.bytedance.android.annie.websocket.j
        public final void onConnected() {
            String r10 = this.b;
            Intrinsics.checkNotNullParameter("connected", com.bytedance.android.ec.core.event.a.KEY_STATUS);
            Intrinsics.checkNotNullParameter(r10, "socketTaskID");
            this.c.a(new e("connected", r10, "unknow error", null, null));
        }

        @Override // com.bytedance.android.annie.websocket.j
        public final void onFailed(String r10) {
            Intrinsics.checkNotNullParameter(r10, "reason");
            String r11 = this.b;
            Intrinsics.checkNotNullParameter(MessageIndication.STATUS_FAILED, com.bytedance.android.ec.core.event.a.KEY_STATUS);
            Intrinsics.checkNotNullParameter(r11, "socketTaskID");
            d r0 = this.c;
            Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_MSG);
            r0.a(new e(MessageIndication.STATUS_FAILED, r11, r10, null, null));
            SocketManager.a(this.d, this.a, this.b);
        }

        @Override // com.bytedance.android.annie.websocket.j
        public final void onMessage(byte[] r10) {
            Intrinsics.checkNotNullParameter(r10, "bytes");
            String r11 = this.b;
            Intrinsics.checkNotNullParameter("onMessaged", com.bytedance.android.ec.core.event.a.KEY_STATUS);
            Intrinsics.checkNotNullParameter(r11, "socketTaskID");
            String r12 = Base64.encodeToString(r10, 0);
            d r13 = this.c;
            Intrinsics.checkNotNullParameter("base64", "dataType");
            r13.a(new e("onMessaged", r11, "unknow error", r12, "base64"));
        }

        @Override // com.bytedance.android.annie.websocket.j
        public final void onMessage(String r10) {
            Intrinsics.checkNotNullParameter(r10, "text");
            String r11 = this.b;
            Intrinsics.checkNotNullParameter("onMessaged", com.bytedance.android.ec.core.event.a.KEY_STATUS);
            Intrinsics.checkNotNullParameter(r11, "socketTaskID");
            d r0 = this.c;
            Intrinsics.checkNotNullParameter("string", "dataType");
            r0.a(new e("onMessaged", r11, "unknow error", r10, "string"));
        }

        public b(SocketManager r10, String r11, String r12, o2 r13) {
            Intrinsics.checkNotNullParameter(r11, "containerID");
            Intrinsics.checkNotNullParameter(r12, "socketTaskID");
            Intrinsics.checkNotNullParameter(r13, "callback");
            this.d = r10;
            this.a = r11;
            this.b = r12;
            this.c = r13;
        }
    }

    public SocketManager() {
    }

    static {
        a = new HashMap();
        b = LazyKt.lazy(SocketManager$Companion$instance$2.INSTANCE);
    }

    public static String b(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "containerID");
        List r12 = c(r10, r11);
        if (r12 == null) goto L9;
        Iterator r13 = ((ArrayList) r12).iterator();
    L6:
        if (r13.hasNext() == false) goto L8;
        ((com.bytedance.android.annie.websocket.b) r13.next()).a();
        goto L6
    L8:
        Unit r14 = Unit.INSTANCE;
    L10:
        if (r14 != null) goto L16;
        if (r11 == null) goto L14;
        return "The socketTaskID doesn't exist";
    L14:
        return "The containerID doesn't exist";
    L16:
        return null;
    L9:
        r14 = null;
        goto L10
    }

    public static List c(String r10, String r11) {
        HashMap<String, HashMap<String, ? super com.bytedance.android.annie.websocket.b>> r0 = a;
        monitor-enter(r0);
        ArrayList r1 = new ArrayList();     // Catch: Throwable -> L26
        if (r11 == null) goto L12;
        HashMap<String, ? super com.bytedance.android.annie.websocket.b> r12 = r0.get(r10);     // Catch: Throwable -> L26
        if (r12 == null) goto L10;
        com.bytedance.android.annie.websocket.b r13 = r12.get(r11);     // Catch: Throwable -> L26
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type com.bytedance.android.annie.websocket.IWebSocketTask");     // Catch: Throwable -> L26
        r1.add(r13);     // Catch: Throwable -> L26
    L24:
        monitor-exit(r0);
        return r1;
    L10:
        monitor-exit(r0);
        return null;
    L12:
        HashMap<String, ? super com.bytedance.android.annie.websocket.b> r14 = r0.get(r10);     // Catch: Throwable -> L26
        if (r14 == null) goto L20;
        Iterator<? super com.bytedance.android.annie.websocket.b> r15 = r14.values().iterator();     // Catch: Throwable -> L26
    L16:
        if (r15.hasNext() == false) goto L18;
        com.bytedance.android.annie.websocket.b r16 = r15.next();     // Catch: Throwable -> L26
        Intrinsics.checkNotNull(r16, "null cannot be cast to non-null type com.bytedance.android.annie.websocket.IWebSocketTask");     // Catch: Throwable -> L26
        r1.add(r16);     // Catch: Throwable -> L26
        goto L16
    L18:
        Unit r17 = Unit.INSTANCE;     // Catch: Throwable -> L26
    L21:
        if (r17 != null) goto L24;
        monitor-exit(r0);
        return null;
    L20:
        r17 = null;
    L26:
        th = move-exception;
        throw th;
    }

    public static final void a(SocketManager r1, String r10, String r11) {
        r1.getClass();
        HashMap<String, HashMap<String, ? super com.bytedance.android.annie.websocket.b>> r12 = a;
        monitor-enter(r12);
        HashMap<String, ? super com.bytedance.android.annie.websocket.b> r0 = r12.get(r10);     // Catch: Throwable -> L18
        if (r0 == null) goto L7;
        r0.remove(r11);     // Catch: Throwable -> L18
    L7:
        HashMap<String, ? super com.bytedance.android.annie.websocket.b> r13 = r12.get(r10);     // Catch: Throwable -> L18
        if (r13 == null) goto L12;
        boolean r14 = true;
        if (r13.isEmpty() != true) goto L12;
    L13:
        if (r14 == false) goto L15;
        r12.remove(r10);     // Catch: Throwable -> L18
    L15:
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L18
        monitor-exit(r12);
        return;
    L12:
        r14 = false;
    L18:
        th = move-exception;
        throw th;
    }
}
