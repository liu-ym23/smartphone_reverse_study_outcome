package p1;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/* JADX INFO: loaded from: classes.dex */
public final class c extends f {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f9917g;

    public c(Context r8, u1.b r10, int r11) {
        this.f9917g = r11;
        if (r11 == 1) goto L6;
        super(r8, r10);
        return;
    L6:
        super(r8, r10);
    }

    @Override // p1.h
    public final /* bridge */ /* synthetic */ Object a() {
        switch(this.f9917g) {
            case 0: goto L6;
            default: goto L8;
        };
    L6:
        return h();
    L8:
        return h();
    }

    @Override // p1.f
    public final IntentFilter f() {
        switch(this.f9917g) {
            case 0: goto L6;
            default: goto L8;
        };
    L6:
        return defpackage.a.c("android.intent.action.BATTERY_OKAY", "android.intent.action.BATTERY_LOW");
    L8:
        return defpackage.a.c("android.intent.action.DEVICE_STORAGE_OK", "android.intent.action.DEVICE_STORAGE_LOW");
    }

    @Override // p1.f
    public final void g(Intent r8) {
        switch(this.f9917g) {
            case 0: goto L5;
            default: goto L25;
        };
    L5:
        he.i.f(r8, "intent");
        if (r8.getAction() == null) goto L46;
        androidx.work.m.d().a(d.f9918a, "Received " + r8.getAction());
        String r10 = r8.getAction();
        if (r10 == null) goto L45;
        int r11 = r10.hashCode();
        if (r11 == (-1980154005)) goto L20;
        if (r11 == 490310653) goto L16;
        return;
    L16:
        if (r10.equals("android.intent.action.BATTERY_LOW") == false) goto L48;
        Boolean r12 = Boolean.FALSE;
    L23:
        c(r12);
        return;
    L48:
        return;
    L20:
        if (r10.equals("android.intent.action.BATTERY_OKAY") == false) goto L49;
        r12 = Boolean.TRUE;
        goto L23
    L49:
        return;
    L45:
        return;
    L46:
        return;
    L25:
        he.i.f(r8, "intent");
        if (r8.getAction() == null) goto L51;
        androidx.work.m.d().a(m.f9932a, "Received " + r8.getAction());
        String r13 = r8.getAction();
        if (r13 == null) goto L50;
        int r14 = r13.hashCode();
        if (r14 == (-1181163412)) goto L40;
        if (r14 == (-730838620)) goto L36;
        return;
    L36:
        if (r13.equals("android.intent.action.DEVICE_STORAGE_OK") == false) goto L53;
        Boolean r15 = Boolean.TRUE;
    L43:
        c(r15);
        return;
    L53:
        return;
    L40:
        if (r13.equals("android.intent.action.DEVICE_STORAGE_LOW") == false) goto L54;
        r15 = Boolean.FALSE;
        goto L43
    L54:
        return;
    L50:
        return;
    }

    public final Boolean h() {
        int r8 = this.f9917g;
        boolean r10 = false;
        Context r11 = this.f9923b;
        switch(r8) {
            case 0: goto L5;
            default: goto L15;
        };
    L5:
        Intent r12 = r11.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (r12 != null) goto L8;
        androidx.work.m.d().b(d.f9918a, "getInitialState - null intent received");
        return Boolean.FALSE;
    L8:
        int r13 = r12.getIntExtra("status", -1);
        float r14 = r12.getIntExtra("level", -1) / r12.getIntExtra("scale", -1);
        if (r13 != 1) goto L11;
    L12:
        r10 = true;
    L14:
        return Boolean.valueOf(r10);
    L11:
        if (r14 <= 0.15f) goto L14;
    L15:
        Intent r15 = r11.registerReceiver(null, f());
        if (r15 != null) goto L18;
    L31:
        r10 = true;
    L33:
        return Boolean.valueOf(r10);
    L18:
        if (r15.getAction() == null) goto L31;
        String r16 = r15.getAction();
        if (r16 == null) goto L33;
        int r17 = r16.hashCode();
        if (r17 != (-1181163412)) goto L25;
        r16.equals("android.intent.action.DEVICE_STORAGE_LOW");
        goto L33
    L25:
        if (r17 != (-730838620)) goto L33;
        if (r16.equals("android.intent.action.DEVICE_STORAGE_OK") == true) goto L31;
        goto L31
    }
}
