package com.ctc.wstx.d;

import com.bytedance.apm6.hub.config.internal.SlardarSettingsConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.text.MessageFormat;

/* JADX INFO: loaded from: classes2.dex */
public final class aa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final aa f3458a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final aa f3459b = null;
    final int c;
    private String d;
    private a e;

    static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final String f3460a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final boolean f3461b;
        final javax.xml.stream.a c;

        a(String r3, javax.xml.stream.a r4, boolean r5) {
            javax.xml.stream.a r6 = (javax.xml.stream.a) ZeusTransformUtils.wrapperContextForParams(r4, javax.xml.stream.a.class, "com.obric.memorydata.plugin");
            this.f3460a = r3;
            this.f3461b = r5;
            this.c = r6;
        }

        public void a(org.codehaus.stax2.validation.b r5, org.codehaus.stax2.validation.g r6) {
            org.codehaus.stax2.validation.b r7 = (org.codehaus.stax2.validation.b) ZeusTransformUtils.wrapperContextForParams(r5, org.codehaus.stax2.validation.b.class, "com.obric.memorydata.plugin");
            String r0 = com.ctc.wstx.b.a.S;
            Object[] r1 = new Object[2];
            if (this.f3461b == false) goto L5;
            String r2 = "parsed";
        L6:
            r1[0] = r2;
            r1[1] = this.f3460a;
            String r3 = MessageFormat.format(r0, r1);
            org.codehaus.stax2.validation.e r4 = new org.codehaus.stax2.validation.e(this.c, r3, 3);
            r4.a(r6);
            r7.a(r4);
            return;
        L5:
            r2 = SlardarSettingsConstants.SETTING_GENERAL;
            goto L6
        }
    }

    static {
        f3458a = new aa(2);
        f3459b = new aa(3);
    }

    private aa(int r2) {
        this.d = null;
        this.e = null;
        this.c = r2;
    }

    public static aa a() {
        return f3458a;
    }

    private void a(String r3, javax.xml.stream.a r4, boolean r5) {
        javax.xml.stream.a r6 = (javax.xml.stream.a) ZeusTransformUtils.wrapperContextForParams(r4, javax.xml.stream.a.class, "com.obric.memorydata.plugin");
        if (this.e != null) goto L6;
        this.e = new a(r3, r6, r5);
        return;
    }

    public static aa b() {
        return f3459b;
    }

    public static aa c() {
        return new aa(4);
    }

    public static aa d() {
        return new aa(1);
    }

    public void a(String r1) {
        this.d = r1;
    }

    public void a(String r3, javax.xml.stream.a r4) {
        a(r3, (javax.xml.stream.a) ZeusTransformUtils.wrapperContextForParams(r4, javax.xml.stream.a.class, "com.obric.memorydata.plugin"), true);
    }

    public void a(org.codehaus.stax2.validation.b r3, org.codehaus.stax2.validation.g r4) {
        org.codehaus.stax2.validation.b r5 = (org.codehaus.stax2.validation.b) ZeusTransformUtils.wrapperContextForParams(r3, org.codehaus.stax2.validation.b.class, "com.obric.memorydata.plugin");
        this.e.a(r5, r4);
    }

    public void b(String r3, javax.xml.stream.a r4) {
        a(r3, (javax.xml.stream.a) ZeusTransformUtils.wrapperContextForParams(r4, javax.xml.stream.a.class, "com.obric.memorydata.plugin"), false);
    }

    public String e() {
        return this.d;
    }

    public String f() {
        if (this.e == null) goto L7;
        return null;
    L7:
        return this.d;
    }

    public boolean g() {
        if (this != f3459b) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean h() {
        if (this.c != 4) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean i() {
        int r2 = this.c;
        if (r2 != 1) goto L5;
        return true;
    L5:
        if (r2 == 4) goto L10;
        return false;
    L10:
        return true;
    }

    public boolean j() {
        if (this == f3458a) goto L5;
        return true;
    L5:
        return false;
    }
}
