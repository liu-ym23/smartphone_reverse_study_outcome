package c6;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.model.SocketState;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class a extends Service implements WeakHandler.IHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakHandler f3352a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Messenger f3353b;

    /* JADX INFO: renamed from: c6.a$a, reason: collision with other inner class name */
    public class RunnableC0040a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Intent f3354a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f3355b;

        public RunnableC0040a(a r8, Intent r10) {
            this.f3355b = r8;
            this.f3354a = r10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a.a(this.f3355b, this.f3354a);
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Intent f3356a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f3357b;

        public b(a r8, Intent r10) {
            this.f3357b = r8;
            this.f3356a = r10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a.a(this.f3357b, this.f3356a);
        }
    }

    public a() {
        this.f3352a = new WeakHandler(this);
    }

    public static void a(a r8, Intent r10) {
        r8.getClass();
        if (r10 == null) goto L45;
        String r11 = r10.getAction();     // Catch: Throwable -> L30
        if (WsConstants.RECEIVE_CONNECTION_ACTION.equals(r11) == false) goto L14;
        r10.setExtrasClassLoader(SocketState.class.getClassLoader());     // Catch: Throwable -> L30
        SocketState r12 = (SocketState) r10.getParcelableExtra(WsConstants.KEY_CONNECTION);     // Catch: Throwable -> L30
        e(r12.f3887n, r12.f3885b);     // Catch: Throwable -> L11
        WsConstants.getListener(r12.f3887n);     // Catch: Throwable -> L11
    L33:
        if (Logger.debug() == false) goto L44;
        Logger.d("AbsWsClientService", "count = " + r10.getIntExtra(WsConstants.MSG_COUNT, -1));
        return;
    L44:
        return;
    L11:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L30
        goto L33
    L14:
        if (WsConstants.SYNC_CONNECT_STATE.equals(r11) == false) goto L23;
        Logger.d("AbsWsClientService", "sync socket state");     // Catch: Throwable -> L30
        r10.setExtrasClassLoader(SocketState.class.getClassLoader());     // Catch: Throwable -> L30
        ArrayList r13 = r10.getParcelableArrayListExtra(WsConstants.KEY_CONNECTION);     // Catch: Throwable -> L30
        if (r13 == null) goto L33;
        Iterator r14 = r13.iterator();     // Catch: Throwable -> L30
    L19:
        if (r14.hasNext() == false) goto L33;
        SocketState r15 = (SocketState) r14.next();     // Catch: Throwable -> L30
        if (r15 == null) goto L19;
        e(r15.f3887n, r15.f3885b);     // Catch: Throwable -> L30
        goto L19
    L23:
        r10.setExtrasClassLoader(WsChannelMsg.class.getClassLoader());     // Catch: Throwable -> L30
        if (WsConstants.RECEIVE_PAYLOAD_ACTION.equals(r11) == false) goto L27;
        WsChannelMsg r16 = (WsChannelMsg) r10.getParcelableExtra(WsConstants.KEY_PAYLOAD);     // Catch: Throwable -> L30
        Message r17 = new Message();     // Catch: Throwable -> L30
        r17.what = 40;     // Catch: Throwable -> L30
        r17.getData().putParcelable(WsConstants.KEY_PAYLOAD, r16);     // Catch: Throwable -> L30
        r8.b(r17);     // Catch: Throwable -> L30
        goto L33
    L27:
        if (WsConstants.SEND_PAYLOAD_ACTION.equals(r11) == false) goto L33;
        String r18 = r10.getStringExtra(WsConstants.KEY_PAYLOAD_MD5);     // Catch: Throwable -> L30
        boolean r19 = r10.getBooleanExtra(WsConstants.KEY_SEND_RESULT, true);     // Catch: Throwable -> L30
        Message r20 = new Message();     // Catch: Throwable -> L30
        r20.what = 41;     // Catch: Throwable -> L30
        r20.getData().putString(WsConstants.KEY_PAYLOAD_MD5, r18);     // Catch: Throwable -> L30
        r20.getData().putBoolean(WsConstants.KEY_SEND_RESULT, r19);     // Catch: Throwable -> L30
        r8.b(r20);     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        th.printStackTrace();
        goto L33
    }

    public static void e(int r8, int r10) {
        e6.b r11 = e6.b.f7127b;
        if (r10 == 0) goto L18;
        if (r10 != 1) goto L9;
        r11 = e6.b.f7128m;
        goto L18
    L9:
        if (r10 != 2) goto L12;
        r11 = e6.b.f7129n;
        goto L18
    L12:
        if (r10 != 3) goto L15;
        r11 = e6.b.f7130o;
        goto L18
    L15:
        if (r10 != 4) goto L18;
        r11 = e6.b.f7131p;
    L18:
        if (Logger.debug() == false) goto L20;
        Logger.d("AbsWsClientService", "state = " + r10 + " connectionState = " + r11);
    L20:
        WsConstants.setConnectionState(r8, r11);
    }

    public final void b(Message r8) {
        r8.getData().setClassLoader(WsChannelMsg.class.getClassLoader());     // Catch: Throwable -> L19
        int r10 = r8.what;     // Catch: Throwable -> L19
        if (r10 != 40) goto L13;
        Parcelable r11 = r8.getData().getParcelable(WsConstants.KEY_PAYLOAD);     // Catch: Throwable -> L19
        if ((r11 instanceof WsChannelMsg) == false) goto L23;
        WsChannelMsg r12 = (WsChannelMsg) r11;     // Catch: Throwable -> L19
        if (Logger.debug() == false) goto L11;
        Logger.d("AbsWsClientService", "get wsChannelMsg = " + r12.toString());     // Catch: Throwable -> L19
    L11:
        c(r12);     // Catch: Throwable -> L19
        return;
    L23:
        return;
    L13:
        if (r10 != 41) goto L25;
        String r13 = r8.getData().getString(WsConstants.KEY_PAYLOAD_MD5);     // Catch: Throwable -> L19
        boolean r14 = r8.getData().getBoolean(WsConstants.KEY_SEND_RESULT);     // Catch: Throwable -> L19
        if (Logger.debug() == false) goto L17;
        Logger.d("AbsWsClientService", "get payloadMd5 = " + r13 + " sendResult = " + r14);     // Catch: Throwable -> L19
    L17:
        d();     // Catch: Throwable -> L19
        return;
    L25:
        return;
    L19:
        th = move-exception;
        th.printStackTrace();
    }

    public void c(WsChannelMsg r8) {
    }

    public void d() {
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public final void handleMsg(Message r8) {
        if (r8 == null) goto L16;
    L11:
        e = move-exception;
        e.printStackTrace();
        return;
    L5:
        if (r8.what != 10123) goto L17;
        Intent r10 = (Intent) r8.getData().getParcelable(WsConstants.DATA_INTENT);     // Catch: Exception -> L11
        Logger.d("AbsWsClientService", "handleMsg = " + r10);     // Catch: Exception -> L11
        if (r10 == null) goto L18;
        sd.b r11 = sd.b.a();     // Catch: Exception -> L11
        r11.f12111a.post(new b(this, r10));     // Catch: Exception -> L11
        return;
    L18:
        return;
    L17:
        return;
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent r8) {
        return this.f3353b.getBinder();
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        this.f3353b = new Messenger(this.f3352a);
    }

    @Override // android.app.Service
    public final void onDestroy() {
        super.onDestroy();
        if (Logger.debug() == false) goto L6;
        Logger.d("AbsWsClientService", "onDestroy");
        return;
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent r8, int r10, int r11) {
        if (Logger.debug() == false) goto L9;
        StringBuilder r12 = new StringBuilder("onStartCommand intent = ");
        if (r8 == null) goto L7;
        String r13 = r8.toString();
    L8:
        r12.append(r13);
        Logger.d("AbsWsClientService", r12.toString());
        goto L9
    L7:
        r13 = "null";
    L9:
        sd.b r14 = sd.b.a();
        RunnableC0040a r15 = new RunnableC0040a(this, r8);
        r14.f12111a.post(r15);
        return 2;
    }
}
