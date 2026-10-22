package com.bytedance.common.wschannel.server;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.lynx.tasm.ui.image.v;
import e8.f;
import f8.b;
import s8.a;

/* JADX INFO: loaded from: classes2.dex */
public class WsChannelReceiver extends BroadcastReceiver {
    public static boolean d = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f4017a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f4018b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final NetworkUtils$NetworkType f4019c;

    public WsChannelReceiver(Application r5, a r10) {
        this.f4018b = true;
        this.f4019c = b.a(r5);
        this.f4017a = r10;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r5, Intent r10) {
        if (r5 == null) goto L20;
        if (r10 != null) goto L5;
        return;
    L5:
        if (this.f4017a != null) goto L8;
        return;
    L8:
        if (TextUtils.isEmpty(r10.getAction()) == false) goto L11;
        return;
    L11:
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(r10.getAction()) == true) goto L14;
        return;
    L14:
        if (this.f4018b == false) goto L18;
        this.f4018b = false;
        if (b.a(r5) != this.f4019c) goto L18;
        return;
    L18:
        f.b(new v(29, this, r5));
        return;
    }
}
