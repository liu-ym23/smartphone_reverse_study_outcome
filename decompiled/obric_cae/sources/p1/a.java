package p1;

import android.content.Intent;
import android.content.IntentFilter;

/* JADX INFO: loaded from: classes.dex */
public final class a extends f<Boolean> {
    @Override // p1.h
    public final Object a() {
        IntentFilter r8 = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        Intent r10 = this.f9923b.registerReceiver(null, r8);
        if (r10 != null) goto L5;
        androidx.work.m.d().b(b.f9916a, "getInitialState - null intent received");
        return Boolean.FALSE;
    L5:
        int r11 = r10.getIntExtra("status", -1);
        if (r11 != 2) goto L8;
    L11:
        boolean r12 = true;
    L13:
        return Boolean.valueOf(r12);
    L8:
        if (r11 == 5) goto L11;
        r12 = false;
        goto L13
    }

    @Override // p1.f
    public final IntentFilter f() {
        return defpackage.a.c("android.os.action.CHARGING", "android.os.action.DISCHARGING");
    }

    @Override // p1.f
    public final void g(Intent r8) {
        he.i.f(r8, "intent");
        String r10 = r8.getAction();
        if (r10 != null) goto L5;
        return;
    L5:
        androidx.work.m.d().a(b.f9916a, "Received ".concat(r10));
        switch(r10.hashCode()) {
            case -1886648615: goto L19;
            case -54942926: goto L16;
            case 948344062: goto L12;
            case 1019184907: goto L9;
            default: goto L24;
        };
    L24:
        return;
    L9:
        if (r10.equals("android.intent.action.ACTION_POWER_CONNECTED") == false) goto L25;
    L14:
        Boolean r11 = Boolean.TRUE;
    L22:
        c(r11);
        return;
    L25:
        return;
    L12:
        if (r10.equals("android.os.action.CHARGING") == true) goto L14;
        return;
    L16:
        if (r10.equals("android.os.action.DISCHARGING") == false) goto L27;
    L21:
        r11 = Boolean.FALSE;
        goto L22
    L27:
        return;
    L19:
        if (r10.equals("android.intent.action.ACTION_POWER_DISCONNECTED") == true) goto L21;
    }
}
