package pnb;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.ss.android.lark.jsruntime.vmsdk.j;
import java.lang.ref.WeakReference;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b {
    public volatile HandlerC0312b a;
    public volatile a b;
    public final Set<d> c;
    public WeakReference<e> d;
    public f e;

    public final class a extends Handler {
        public static final /* synthetic */ int b = 0;
        public final /* synthetic */ b a;

        public a(b r1) {
            this.a = r1;
        }

        @Override // android.os.Handler
        public final void handleMessage(Message r4) {
            rnb.c.a("bridge_receive", "ReceiverHandler.handleMessage: 101 " + r4);
            int r0 = r4.what;
            if (r0 != 1) goto L5;
            d r5 = (d) r4.obj;
            if (c.b == false) goto L16;
            rnb.c.a("bridge_receive", "registerDataChangeListener: listener size=" + ((CopyOnWriteArraySet) this.a.c).size());
        L16:
            if (r5 == null) goto L18;
            ((CopyOnWriteArraySet) this.a.c).add(r5);
            return;
        L18:
            rnb.c.d("bridge_receive", "registerDataChangeListener: listener is null");
            return;
        L5:
            if (r0 == 2) goto L7;
            rnb.c.d("bridge_send", "error type:" + r4.what);
            return;
        L7:
            d r6 = (d) r4.obj;
            if (c.b == false) goto L10;
            rnb.c.a("bridge_receive", "unRegisterDataChangeListener: listener size=" + ((CopyOnWriteArraySet) this.a.c).size());
        L10:
            if (r6 == null) goto L12;
            ((CopyOnWriteArraySet) this.a.c).remove(r6);
            return;
        L12:
            rnb.c.d("bridge_receive", "unRegisterDataChangeListener: listener is null");
        }
    }

    /* JADX INFO: renamed from: pnb.b$b, reason: collision with other inner class name */
    public final class HandlerC0312b extends Handler {
        public static final /* synthetic */ int b = 0;
        public final /* synthetic */ b a;

        public HandlerC0312b(b r1) {
            this.a = r1;
        }

        @Override // android.os.Handler
        public final void handleMessage(Message r6) {
            rnb.c.a("bridge_send", "SenderHandler.handleMessage: 89 " + r6);
            int r0 = r6.what;
            if (r0 != 3) goto L5;
            String r7 = (String) r6.obj;
            if (c.a == false) goto L25;
            rnb.c.a("bridge_send", "requestFromNative:  request=" + r7);
        L25:
            if (this.a.d != null) goto L27;
        L34:
            rnb.c.b("bridge_send", "requestFromNative: mNativeToJsBridge is null ");
            return;
        L27:
            if (TextUtils.isEmpty(r7) == true) goto L34;
            e r1 = this.a.d.get();
            if (r1 == null) goto L32;
            rnb.c.a("bridge_send", "BridgeConnector.requestFromNative: string start send " + System.currentTimeMillis());
            r1.a(r7);
            return;
        L32:
            rnb.c.d("bridge_send", "requestFromNative: bridge is null");
            return;
        L5:
            if (r0 == 5) goto L7;
            rnb.c.d("bridge_send", "error type:" + r6.what);
            return;
        L7:
            String r8 = (String) r6.obj;
            if (c.a == false) goto L11;
            rnb.c.a("bridge_send", "requestFromDocs:  request=" + r8);
        L11:
            if (this.a.d != null) goto L13;
        L19:
            rnb.c.b("bridge_send", "requestFromDocs: mNativeToJsBridge is null ");
            return;
        L13:
            if (TextUtils.isEmpty(r8) == true) goto L19;
            e r2 = this.a.d.get();
            if (r2 == null) goto L18;
            rnb.c.a("bridge_send", "BridgeConnector.requestFromDocs: string start send " + System.currentTimeMillis());
            r2.b(r8);
            return;
        L18:
            rnb.c.d("bridge_send", "requestFromDocs: bridge is null");
        }
    }

    public b(j r4) {
        this.c = new CopyOnWriteArraySet();
    L8:
        e = move-exception;
        rnb.c.a.e("bridge_connector", "init: ", e);
        return;
    L4:
        if (c.c == false) goto L6;
        rnb.c.a("bridge_connector", "init: begin");     // Catch: Exception -> L8
    L6:
        this.a = new HandlerC0312b(this);     // Catch: Exception -> L8
        this.b = new a(this);     // Catch: Exception -> L8
        this.e = new f(r4);     // Catch: Exception -> L8
        this.d = new WeakReference(this.e);     // Catch: Exception -> L8
        r4.f(new pnb.a(this));     // Catch: Exception -> L8
    }
}
