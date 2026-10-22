package com.larus.dorag.widget;

import android.app.Application;
import android.content.Intent;
import com.larus.common.apphost.AppHost;
import com.larus.dorag.widget.provider.DoraWidget2x2Provider;
import com.larus.dorag.widget.provider.DoraWidget4x2Provider;
import com.larus.dorag.widget.provider.DoraWidgetDiaryProvider;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class f {
    public static String a;
    public static boolean b;
    public static boolean c;
    public static int d;
    public static boolean e;
    public static a f;
    public static c g;
    public static b h;
    public static e i;
    public static d j;

    public f() {
    }

    static {
        a = "";
    }

    public static void a() {
        if (c == false) goto L6;
        FLogger.a.i("DoraWidgetCenter", "screen is off, cancel refresh widget");
        return;
    L6:
        Application r0 = AppHost.a.getApplication();
        Intent r2 = new Intent(r0, DoraWidget4x2Provider.class);
        r2.setAction("com.larus.avlink.impl.ACTION_DORA_WIDGET_4X2_REFRESH");
        r0.sendBroadcast(r2);
        Intent r3 = new Intent(r0, DoraWidget2x2Provider.class);
        r3.setAction("com.larus.avlink.impl.ACTION_DORA_WIDGET_2X2_REFRESH");
        r0.sendBroadcast(r3);
        Intent r4 = new Intent(r0, DoraWidgetDiaryProvider.class);
        r4.setAction("android.appwidget.action.APPWIDGET_UPDATE");
        r0.sendBroadcast(r4);
        FLogger.a.i("DoraWidgetCenter", "send broadcast to refresh widget");
    }
}
