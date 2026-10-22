package c6;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.server.WsChannelService;
import java.lang.ref.WeakReference;
import java.util.concurrent.LinkedBlockingDeque;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final d f3362c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static WeakReference<Context> f3363d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Messenger f3364a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedBlockingDeque<b> f3365b;

    public class a implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f3366a;

        public a(d r8) {
            this.f3366a = r8;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName r8, IBinder r10) {
            if (r8 == null) goto L15;
            if (r10 != null) goto L6;
            return;
        L6:
            if (Logger.debug() == false) goto L13;
            Logger.d("WsChannelSdk", "onServiceConnected name = " + r8.toString());
        L13:
            Messenger r11 = new Messenger(r10);     // Catch: Throwable -> L10
            d r12 = this.f3366a;     // Catch: Throwable -> L10
            r12.f3364a = r11;     // Catch: Throwable -> L10
            d.a(r12, r8);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            th.printStackTrace();
            return;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName r8) {
            if (r8 != null) goto L5;
            return;
        L5:
            if (Logger.debug() == false) goto L14;
            Logger.d("WsChannelSdk", "onServiceDisconnected name = " + r8.toString());
        L14:
            d r10 = this.f3366a;     // Catch: Throwable -> L11
            r10.f3364a = null;     // Catch: Throwable -> L11
            r10.f3365b.clear();     // Catch: Throwable -> L11
            d r11 = this.f3366a;     // Catch: Throwable -> L11
            monitor-enter(r11);     // Catch: Throwable -> L11
            monitor-exit(r11);     // Catch: Throwable -> L11
            return;
        L11:
            th = move-exception;
            th.printStackTrace();
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f3367a;

        public b() {
        }
    }

    static {
        f3362c = new d();
    }

    public d() {
        this.f3365b = new LinkedBlockingDeque();
    }

    public static void a(d r8, ComponentName r10) {
        monitor-enter(r8);
    L22:
        th = move-exception;
        throw th;
    L4:
        if (r8.f3364a != null) goto L6;
        r8.b(r10);     // Catch: Throwable -> L22
    L20:
        monitor-exit(r8);
        return;
    L6:
        if (r10 == null) goto L20;
    L8:
        LinkedBlockingDeque<b> r11 = r8.f3365b;     // Catch: Throwable -> L22
        if (r11.peek() == null) goto L20;
        b r12 = r11.poll();     // Catch: Throwable -> L25
        if (r12 == null) goto L20;
        Message r13 = new Message();     // Catch: Throwable -> L25
        r13.what = r12.f3367a;     // Catch: Throwable -> L25
        r13.getData().putParcelable(null, null);     // Catch: Throwable -> L25
        r8.d(r10, r13);     // Catch: Throwable -> L17 DeadObjectException -> L19
    L19:
        r8.f3364a = null;     // Catch: Throwable -> L25
        r11.offerFirst(r12);     // Catch: Throwable -> L25
    L17:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L25
        goto L8
    }

    public static void c(Application r8, int r10) {
        if (r8 == null) goto L25;
        if (r10 > 0) goto L5;
        return;
    L5:
        if (r10 > 3) goto L27;
        WeakReference<Context> r11 = f3363d;
        if (r11 != null) goto L10;
    L11:
        f3363d = new WeakReference(r8.getApplicationContext());
    L13:
        if (Logger.debug() == false) goto L16;
        Logger.d("WsChannelSdk", "sendAppState appState = " + r10);
    L16:
        if (com.bytedance.common.wschannel.a.a(r8).f3869a.a(WsConstants.KEY_FRONTIER_ENABLED, true) == true) goto L23;
        return;
    L23:
        ComponentName r12 = new ComponentName(r8, WsChannelService.class);     // Catch: Throwable -> L20
        Intent r13 = new Intent(WsConstants.APP_STATE_ACTION);     // Catch: Throwable -> L20
        r13.setComponent(r12);     // Catch: Throwable -> L20
        r13.putExtra(WsConstants.KEY_APP_STATE, r10);     // Catch: Throwable -> L20
        r8.startService(r13);     // Catch: Throwable -> L20
        return;
    L20:
        th = move-exception;
        th.printStackTrace();
        return;
    L10:
        if (r11.get() != null) goto L13;
    L27:
        return;
    }

    public final void b(ComponentName r8) {
        WeakReference<Context> r10 = f3363d;
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.get() == null) goto L20;
        Context r11 = r10.get();
        if (Logger.debug() == false) goto L10;
        Logger.d("WsChannelSdk", "doBindService");
    L10:
        if (r8 != null) goto L17;
        return;
    L17:
        Intent r12 = new Intent();     // Catch: Throwable -> L14
        r12.setComponent(r8);     // Catch: Throwable -> L14
        r11.bindService(r12, new a(this), 1);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        th.printStackTrace();
        return;
    }

    public final void d(ComponentName r8, Message r10) {
        if (r8 != null) goto L5;
        return;
    L5:
        if (Logger.debug() == false) goto L7;
        Logger.d("WsChannelSdk", "sendMsg msg = " + r10.toString() + " , + what = " + r10.what);
    L7:
        Messenger r11 = this.f3364a;
        if (r11 != null) goto L10;
        return;
    L10:
        r11.send(r10);
    }
}
