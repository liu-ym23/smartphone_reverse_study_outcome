package com.ss.android.lark.integrator.ccm.dependency.di;

import android.content.Context;
import com.bytedance.ee.bear.doc.resupdate.EChannel;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Singleton
public final class i1 implements com.bytedance.ee.bear.doc.resupdate.g {
    public volatile boolean a;

    public static final class a {
    }

    static {
    }

    @Inject
    public i1() {
    }

    public final void i() {
        this.a = false;
        tt5.a.h("OfficeResourceImpl", "reInit ignored for office host");
    }

    public final boolean j() {
        Intrinsics.checkNotNullParameter("DOC_CHANNEL", "channel");
        return false;
    }

    public final void a() {
        Intrinsics.checkNotNullParameter("DOC_CHANNEL", "channel");
        tt5.a.h("OfficeResourceImpl", "checkUpdate ignored for office host, channel=DOC_CHANNEL");
    }

    public final void g() {
        tt5.a.h("OfficeResourceImpl", "checkResourceIsValid ignored for office host");
    }

    public final com.bytedance.ee.bear.doc.resupdate.e0 getResource() {
        Intrinsics.checkNotNullParameter("DOC_CHANNEL", "channel");
        com.bytedance.ee.bear.doc.resupdate.e0 r0 = new com.bytedance.ee.bear.doc.resupdate.e0();
        r0.c = "DOC_CHANNEL";
        r0.b = "";
        return r0;
    }

    public final boolean hasInit() {
        return this.a;
    }

    public final void b(l35.c r3) {
        Intrinsics.checkNotNullParameter("DOC_CHANNEL", "channel");
        Intrinsics.checkNotNullParameter(r3, "listener");
        tt5.a.h("OfficeResourceImpl", "registerResUpdateListener ignored for office host, channel=DOC_CHANNEL");
    }

    public final void c(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        tt5.a.h("OfficeResourceImpl", "cleanResource ignored for office host");
    }

    public final void h(com.bytedance.ee.bear.doc.resupdate.f0 r3) {
        Intrinsics.checkNotNullParameter(r3, "callback");
        tt5.a.h("OfficeResourceImpl", "downloadFullRes(callback) ignored for office host");
        r3.onFail();
    }

    public final void init(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = true;
        tt5.a.h("OfficeResourceImpl", "init ignored for office host");
    }

    public final void d(EChannel r2, com.bytedance.ee.bear.doc.resupdate.a0 r3) {
        Intrinsics.checkNotNullParameter(r2, "channel");
        Intrinsics.checkNotNullParameter(r3, "listener");
        tt5.a.h("OfficeResourceImpl", "unregisterResUpdateListener ignored for office host, channel=" + r2);
    }

    public final void e(EChannel r2, com.bytedance.ee.bear.doc.resupdate.a0 r3) {
        Intrinsics.checkNotNullParameter(r2, "channel");
        Intrinsics.checkNotNullParameter(r3, "listener");
        tt5.a.h("OfficeResourceImpl", "registerResUpdateListener ignored for office host, channel=" + r2);
    }

    public final void f(Context r2, String r3, com.bytedance.ee.bear.doc.resupdate.f r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "version");
        Intrinsics.checkNotNullParameter(r4, "callback");
        tt5.a.h("OfficeResourceImpl", "downloadSCM ignored for office host, version=" + r3);
        r4.c(new UnsupportedOperationException("IResource is not supported in officesdk"));
    }
}
