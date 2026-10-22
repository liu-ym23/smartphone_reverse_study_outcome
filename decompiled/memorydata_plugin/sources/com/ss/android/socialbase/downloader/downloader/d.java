package com.ss.android.socialbase.downloader.downloader;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes6.dex */
public class d extends PluginBroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f15409a = "d";

    static {
    }

    public d() {
    }

    private void a(Context r7, final String r8) {
        final Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        if (b.I() == true) goto L5;
        return;
    L5:
        long r2 = 2000;
        long r0 = com.ss.android.socialbase.downloader.g.a.c().a("delay_refresh_unsuccess_task_ms", 2000);
        if (r0 <= 0) goto L9;
        r2 = r0;
    L9:
        b.a(new AnonymousClass2(this, r9, r8), r2, TimeUnit.MILLISECONDS);
    }

    private void b(Context r3, final String r4) {
        final Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        b.a(new AnonymousClass3(this, r5, r4));
    }

    public void onReceive(Context r4, Intent r5) {
        final Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L29;
        if (r5 == null) goto L33;
        String r7 = r5.getAction();
        if (TextUtils.isEmpty(r7) == false) goto L10;
        return;
    L10:
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L13;
        com.ss.android.socialbase.downloader.e.a.a(f15409a, "onReceive", "Action:" + r7);
    L13:
        if (r7.equals("android.net.conn.CONNECTIVITY_CHANGE") == false) goto L16;
        a(r6, r7);
        return;
    L16:
        if (r7.equals("android.intent.action.MEDIA_UNMOUNTED") == false) goto L18;
    L27:
        b(r6, r7);
        return;
    L18:
        if (r7.equals("android.intent.action.MEDIA_REMOVED") == true) goto L27;
        if (r7.equals("android.intent.action.MEDIA_BAD_REMOVAL") == true) goto L27;
        if (r7.equals("android.intent.action.MEDIA_EJECT") == true) goto L27;
        if (r7.equals("android.intent.action.MEDIA_MOUNTED") == false) goto L31;
        b.a(new AnonymousClass1(this, r6));
        return;
    L31:
        return;
    L33:
        return;
    }
}
