package com.lynx.tasm;

import com.google.android.material.timepicker.TimeModel;
import com.lynx.base.log.LynxLog;

/* JADX INFO: loaded from: classes2.dex */
public class u {
    public static int g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f10964a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f10965b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f10966c;
    public final String[] d;
    public boolean e;
    public final LynxWhiteBoard f;

    public u(String r5, String r10, String[] r11, boolean r12, boolean r13, Boolean r14, boolean r15) {
        this.f10966c = r10;
        this.d = r11;
        if (r14 != null) goto L5;
        this.e = LynxEnv.getBooleanFromExternalEnv(LynxEnvKey.D, false);
    L6:
        if (r15 == false) goto L8;
        this.f = new LynxWhiteBoard();
    L8:
        this.f10964a = r13;
        this.f10965b = r12;
        StringBuilder r16 = com.lynx.tasm.base.a.e("LynxGroup init with name ", r5, ", id: ", r10, ", enableV8: ");
        r16.append(r13);
        r16.append(", canvas:");
        r16.append(r12);
        LynxLog.b(2, "LynxGroup", r16.toString());
        return;
    L5:
        this.e = r14.booleanValue();
        goto L6
    }

    public final void a() {
        LynxWhiteBoard r5 = this.f;
        if (r5 == null) goto L6;
        r5.a();
        return;
    }

    public u(t r10) {
        String r5 = (String) r10.f10963c;
        String r11 = (String) r10.d;
        if (r11 != null) goto L6;
        r11 = String.format(TimeModel.NUMBER_FORMAT, new Object[]{Integer.valueOf(g)});
        g++;
    L6:
        this.f10966c = r11;
        this.d = (String[]) r10.e;
        Boolean r12 = (Boolean) r10.f;
        if (r12 != null) goto L9;
        this.e = LynxEnv.getBooleanFromExternalEnv(LynxEnvKey.D, false);
    L10:
        this.f10964a = false;
        boolean r13 = r10.f10962b;
        this.f10965b = r13;
        StringBuilder r14 = com.lynx.tasm.base.a.e("LynxGroup init with name ", r5, ", id: ", r11, ", enableV8: ");
        r14.append(false);
        r14.append(", canvas:");
        r14.append(r13);
        LynxLog.b(2, "LynxGroup", r14.toString());
        return;
    L9:
        this.e = r12.booleanValue();
        goto L10
    }
}
