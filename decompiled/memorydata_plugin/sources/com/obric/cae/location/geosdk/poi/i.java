package com.obric.cae.location.geosdk.poi;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Calendar;

/* JADX INFO: loaded from: classes3.dex */
public final class i extends PluginBroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ StarPoiManager f7228a;

    public i(StarPoiManager r1) {
        this.f7228a = r1;
    }

    public final void onReceive(Context r8, Intent r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        if (r9 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r9.getAction()) == true) goto L48;
        String r11 = r9.getAction();
        byte r0 = 0;
        if ("android.intent.action.DATE_CHANGED".equals(r11) == false) goto L10;
    L38:
        StarPoiManager r7 = this.f7228a;
        StarPoiManager r12 = StarPoiManager.f7164a;
        r7.getClass();
        Calendar r13 = Calendar.getInstance();
        long r1 = ((((long) (r13.get(2) + 1)) * 100) + (((long) r13.get(1)) * 10000)) + ((long) r13.get(5));
        if (r1 == r7.as) goto L47;
        r7.as = r1;
        r7.aq = 0;
        r7.ap = 0;
        com.obric.cae.log.a.d("StarLocation-PoiManager", "WakeLock stats reset");
        return;
    L47:
        return;
    L10:
        if ("android.intent.action.TIME_SET".equals(r11) == true) goto L38;
        if ("android.intent.action.TIMEZONE_CHANGED".equals(r11) == true) goto L38;
        StarPoiManager r14 = this.f7228a;
        StarPoiManager r3 = StarPoiManager.f7164a;
        if (r14.m() == true) goto L17;
        return;
    L17:
        r11.getClass();
        r11.hashCode();
        switch(r11.hashCode()) {
            case -1862318830: goto L29;
            case -1682806606: goto L25;
            case 2036629966: goto L21;
            default: goto L19;
        };
    L19:
        r0 = -1;
    L31:
        switch(r0) {
            case 0: goto L35;
            case 1: goto L34;
            case 2: goto L33;
            default: goto L45;
        };
    L33:
        StarPoiManager r15 = this.f7228a;
        int r16 = 8;
    L36:
        r15.d(r16);
        this.f7228a.Z.sendEmptyMessage(r16);
        return;
    L34:
        r15 = this.f7228a;
        r16 = 9;
        goto L36
    L35:
        r15 = this.f7228a;
        r16 = 3;
        goto L36
    L45:
        return;
    L21:
        if (r11.equals("com.obric.cae.action.POI_ALARM_STATIONARY_STEP_CHECK") == false) goto L42;
        r0 = 2;
        goto L31
    L42:
        r0 = -1;
        goto L31
    L25:
        if (r11.equals("com.obric.cae.action.POI_ALARM_STATIONARY_DELAYED_QUERY") == false) goto L43;
        r0 = 1;
        goto L31
    L43:
        r0 = -1;
        goto L31
    L29:
        if (r11.equals("com.obric.cae.action.POI_ALARM_INSIDE_PERIOD") == true) goto L31;
        r0 = -1;
        goto L31
    }
}
