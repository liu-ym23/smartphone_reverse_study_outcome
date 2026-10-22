package com.privacy.azerothprivacy.alarm.receiver;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import apa.a;
import com.privacy.azerothprivacy.AzerothPrivacy;
import dpa.c;
import dpa.d;
import dpa.g;
import java.text.DateFormat;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;
import roa.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class ColdBootDelayExecutor extends AzerothCustomReceiver {
    public static final /* synthetic */ int a = 0;

    @Override // com.privacy.azerothprivacy.alarm.receiver.AzerothCustomReceiver
    public final long a() {
        return 10000;
    }

    public ColdBootDelayExecutor() {
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r13, Intent r14) {
        a.a("DelayInitiator", "onReceive start");
        c r1 = d.a();
        a.a("EnvReporter", r1.toString());
        if (r1.azerothGlobalSettings.global_function_switch == true) goto L5;
    L35:
        DateFormat r0 = b.a;
        if (d.a().azerothGlobalSettings.global_function_switch == true) goto L38;
    L44:
        Runnable r15 = new roa.a();
        fpa.c.a.execute(r15);
        a.a("DelayInitiator", "onReceive end");
        return;
    L38:
        if (d.a().dailyReportSetting.enabled == false) goto L44;
        String r2 = b.a.format(new Date());
        epa.a.b(r13).getClass();
        if (r2.equals(epa.a.b.getString("DailyReporter.lastReportDate", "")) == false) goto L43;
        a.a("DailyReporter", "have reported today, skip");
        goto L44
    L43:
        a.a("DailyReporter", "report daily...");
        bpa.a.b("daily_user", null, null, null);
        epa.a.b(r13).getClass();
        epa.a.e("DailyReporter.lastReportDate", r2);
        goto L44
    L5:
        if (r1.envReportSetting.enabled == false) goto L35;
        epa.a.b(r13).getClass();
        long r6 = epa.a.c("EnvReporter.lastReportTime");
        int r8 = r1.envReportSetting.min_report_interval;
        if (r8 <= 0) goto L10;
        long r9 = ((long) r8) * 1000;
    L12:
        if ((System.currentTimeMillis() - r6) < r9) goto L35;
        JSONObject r7 = new JSONObject();
        g r10 = r1.envReportSetting;
        if (r10 != null) goto L17;
    L46:
        r7.put("user_id", AzerothPrivacy.getAppInfo().e);     // Catch: JSONException -> L32
        r7.put("settings", r1.toString());     // Catch: JSONException -> L32
    L34:
        bpa.a.b("env", null, null, r7);
        a.a("EnvReporter", "report env...");
        epa.a r3 = epa.a.b(r13);
        long r11 = System.currentTimeMillis();
        r3.getClass();
        epa.a.d("EnvReporter.lastReportTime", r11);
    L32:
        e = move-exception;
        e.printStackTrace();
        goto L34
    L17:
        if (r10.collect_android_id == false) goto L46;
        String r12 = woa.a.a(r13.getContentResolver());     // Catch: Exception -> L21
        if (TextUtils.isEmpty(r12) == false) goto L25;
    L23:
        r12 = "";
    L25:
        if (TextUtils.isEmpty(r12) == true) goto L46;
        r7.put("android_id", r12);     // Catch: JSONException -> L28
    L28:
        e = move-exception;
        e.printStackTrace();
    L21:
        e = move-exception;
        e.printStackTrace();
        goto L23
    L10:
        r9 = 28800000;
        goto L12
    }
}
