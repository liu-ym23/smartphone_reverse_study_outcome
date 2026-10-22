package com.bytedance.common.wschannel.server;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;

/* JADX INFO: loaded from: classes.dex */
public class m extends BroadcastReceiver {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f1459d = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private b f1460a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f1461b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private NetworkUtils.NetworkType f1462c;

    class a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Context f1463c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ m f1464g;

        a(m r10, Context r11) {
            this.f1464g = r10;
            this.f1463c = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            m.a(this.f1464g, this.f1463c);
            if (m.b() == true) goto L11;
            return;
        L11:
            if (Logger.debug() == false) goto L8;
            Logger.d("WsChannelReceiver", "ConnectivityReceiver");     // Catch: Exception -> L10
        L8:
            int r10 = NetworkUtils.a(this.f1463c);     // Catch: Exception -> L10
            Message r11 = Message.obtain();     // Catch: Exception -> L10
            r11.what = 3;     // Catch: Exception -> L10
            r11.arg1 = r10;     // Catch: Exception -> L10
            m.c(this.f1464g).handleMsg(r11);     // Catch: Exception -> L10
            return;
        }
    }

    static {
    }

    public m(Context r10, b r11) {
        this.f1461b = true;
        this.f1462c = NetworkUtils.b(r10);
        this.f1460a = r11;
    }

    static /* synthetic */ void a(m r10, Context r11) {
        r10.d(r11);
    }

    static /* synthetic */ boolean b() {
        return f1459d;
    }

    static /* synthetic */ b c(m r10) {
        return r10.f1460a;
    }

    private void d(Context r10) {
        boolean r11 = com.bytedance.common.wschannel.l.f(r10).g();     // Catch: Throwable -> L6
        if (r11 == f1459d) goto L9;
        f1459d = r11;     // Catch: Throwable -> L6
        return;
    L9:
        return;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r10, Intent r11) {
        if (r10 == null) goto L20;
        if (r11 != null) goto L5;
        return;
    L5:
        if (this.f1460a != null) goto L8;
        return;
    L8:
        if (TextUtils.isEmpty(r11.getAction()) == false) goto L11;
        return;
    L11:
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(r11.getAction()) == true) goto L14;
        return;
    L14:
        if (this.f1461b == false) goto L18;
        this.f1461b = false;
        if (NetworkUtils.b(r10) != this.f1462c) goto L18;
        return;
    L18:
        r1.c.b(new a(this, r10));
        return;
    }
}
