package com.ctc.wstx.util;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.tracker.ActivityLifecycle;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final k f3692a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final String f3693b = null;
    static final String c = null;

    static {
        k r0 = new k(true, 128);
        f3692a = r0;
        f3693b = r0.a("xml");
        c = r0.a("xmlns");
        r0.a(OaidModel.KEY_ID);
        r0.a(ActivityLifecycle.NAME);
        r0.a("xsd");
        r0.a("xsi");
        r0.a("type");
        r0.a("soap");
        r0.a("SOAP-ENC");
        r0.a("SOAP-ENV");
        r0.a("Body");
        r0.a("Envelope");
    }

    public static k a() {
        return f3692a.a();
    }

    public static String b() {
        return f3693b;
    }

    public static String c() {
        return c;
    }
}
