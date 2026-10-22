package x5;

import android.app.Application;
import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;
import c6.d;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimCategoryConstants;
import com.ttnet.org.chromium.base.ProcessUtils;
import j6.g;
import w5.c;

/* JADX INFO: loaded from: classes.dex */
public abstract class a extends Service implements WeakHandler.IHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Messenger f13582a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WeakHandler f13583b;

    public a() {
    }

    public void handleMsg(Message r8) {
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent r8) {
        Logger.d("AbsMessengerService", "onBind " + this);
        return this.f13582a.getBinder();
    }

    @Override // android.app.Service
    public void onCreate() {
        Application r8 = getApplication();
        if (c.f12985a == true) goto L36;
        boolean r10 = true;
        c.f12985a = true;
        c.f12986b = r8;
        c.f12989e = k6.a.b(r8);
        sd.a.a(r8);     // Catch: Throwable -> L8
    L9:
        String r11 = c.f12989e;
        if (r11 != null) goto L12;
    L14:
        if (r11 != null) goto L16;
    L18:
        boolean r12 = false;
    L19:
        if (r12 == false) goto L21;
        w5.a r13 = new w5.a();
        r13.f12979a = c.f12987c;
        r8.registerActivityLifecycleCallbacks(r13);
        WsConstants.setOnMessageReceiveListener(null);
    L32:
        Application r14 = c.f12986b;
        if (r12 == false) goto L35;
        d r15 = d.f3362c;
        r15.getClass();
        s5.c.f12034b.submit(new c6.c(r15, r14));
        goto L36
    L35:
        d r16 = d.f3362c;
        s5.c.f12034b.submit(new c6.b(r14));
        goto L36
    L21:
        String r17 = c.f12989e;
        if (r17 != null) goto L24;
    L26:
        r10 = false;
    L27:
        if (r10 == false) goto L32;
        IntentFilter r18 = new IntentFilter();     // Catch: Exception -> L30
        r18.addAction("android.net.conn.CONNECTIVITY_CHANGE");     // Catch: Exception -> L30
        c.f12986b.registerReceiver(new g(), r18);     // Catch: Exception -> L30
    L30:
        e = move-exception;
        e.printStackTrace();
        goto L32
    L24:
        if (r17.endsWith(ProcessUtils.MESSAGE_PROCESS_SUFFIX) == false) goto L26;
    L16:
        if (r11.equals(r8.getPackageName()) == false) goto L18;
        r12 = true;
        goto L19
    L12:
        if (r11.contains(BdimCategoryConstants.SEPARATOR_COLON) == false) goto L14;
    L8:
        Log.d("WsChannel", "没有AppProvider，忽略");
    L36:
        Logger.d("AbsMessengerService", "onCreate " + this);
        this.f13583b = new WeakHandler(this);
        this.f13582a = new Messenger(this.f13583b);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Service
    public final boolean onUnbind(Intent r8) {
        Logger.d("AbsMessengerService", "onUnBind " + this);
        return super.onUnbind(r8);
    }
}
