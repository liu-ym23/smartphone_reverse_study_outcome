package com.larus.bmhome.chat.map;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import wq9.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class k {
    public static final k a = null;
    public static final String b = null;
    public static double c;
    public static double d;
    public static String e;
    public static boolean f;
    public static boolean g;
    public static boolean h;
    public static final List<Pair<String, Function0<Unit>>> i = null;

    public k() {
    }

    static {
        a = new k();
        b = k.class.getSimpleName();
        e = "";
        i = new ArrayList();
    }

    public static void b(Context r7) {
        if (f == true) goto L13;
        Intent r1 = new Intent("android.intent.action.VIEW", UriProtector.parse("market://details?id=com.autonavi.minimap"));
        if (r1.resolveActivity(r7.getPackageManager()) == null) goto L11;
        r7.startActivity(r1);
        return;
    L11:
        FLogger.a.e(b, "can not find market app:com.autonavi.minimap");
        return;
    L13:
        int r2 = wq9.d.a;     // Catch: URISyntaxException -> L6
        a r3 = wq9.d.a(c, d);     // Catch: URISyntaxException -> L6
        Intent r4 = new Intent();     // Catch: URISyntaxException -> L6
        r4.setAction("android.intent.action.VIEW");     // Catch: URISyntaxException -> L6
        r4.addCategory("android.intent.category.DEFAULT");     // Catch: URISyntaxException -> L6
        r4.setData(UriProtector.parse("androidamap://route?&sourceApplication=Flow&dname=" + e + "&dlat=" + r3.a + "&dlon=" + r3.b + "&dev=1&t=0"));     // Catch: URISyntaxException -> L6
        r7.startActivity(r4);     // Catch: URISyntaxException -> L6
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
    }

    public static boolean c(Context r3, String r4) {
        boolean r1 = true;
        if (r4.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L15;
        return false;
    L15:
        if (r3.getPackageManager().getPackageInfo(r4, 0) != null) goto L13;
        r1 = false;
    L13:
        return r1;
    L17:
        return false;
    L5:
        r0 = false;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(final Context r1, double r2, double r4, String r6, final Function0 r7) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r6, "destination");
        c = r2;
        d = r4;
        e = r6;
        ArrayList r3 = (ArrayList) i;
        r3.clear();
        f = c(r1, "com.autonavi.minimap");
        g = c(r1, "com.tencent.map");
        h = c(r1, "com.baidu.BaiduMap");
        if (f == false) goto L6;
        r3.add(new Pair(r1.getString(2131907253), new g(r1)));
    L6:
        if (g == false) goto L9;
        r3.add(new Pair(r1.getString(2131907255), new h(r1)));
    L9:
        if (h == false) goto L12;
        r3.add(new Pair(r1.getString(2131907254), new i(r1)));
    L12:
        if (r3.isEmpty() == false) goto L18;
        StringBuilder r5 = new StringBuilder();
        r5.append(r1.getString(2131906157));
        if (f == false) goto L16;
        String r8 = "";
    L17:
        r5.append(r8);
        r3.add(new Pair(r5.toString(), new j(r1)));
        goto L18
    L16:
        r8 = r1.getString(2131908172);
    L18:
        String[] r9 = new String[r3.size()];
        int r10 = r3.size();
        int r11 = 0;
    L19:
        if (r11 >= r10) goto L21;
        r9[r11] = ((Pair) ListProtector.get(i, r11)).getFirst();
        r11 = r11 + 1;
        goto L19
    L21:
        AlertDialog r12 = new AlertDialog.Builder(r1).setTitle(r1.getString(2131909187)).setItems(r9, new f(r7)).create();
        if (DialogLancet.shouldBlockDialogShow(r12) == false) goto L28;
        DialogLancet.handleBlockedDialogShow(r12);
        return;
    L28:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L27
    L25:
        DialogLancet.beforeDialogShow(r12);
        r12.show();
        DialogLancet.afterDialogShow(r12);
    }
}
