package com.ss.android.lark.integrator.im.chat.core.dependency;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import w4b.c0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class r implements c0 {
    public static final Map<aqb.g, qpc.d> a = null;

    public class a implements qpc.d {
        public final /* synthetic */ aqb.g a;

        public a(aqb.g r1) {
            this.a = r1;
        }

        @Override // qpc.d
        public final void onPushUploadProgress(String r2, int r3) {
            this.a.onPushUploadProgress(r2, r3);
        }
    }

    public r() {
    }

    public final void c() {
    }

    public final void e() {
    }

    public final void f() {
    }

    public final void h() {
    }

    public final void i() {
    }

    public final void j() {
    }

    public final void k() {
    }

    public final void l() {
    }

    static {
        a = new ConcurrentHashMap();
        new ConcurrentHashMap();
        new ConcurrentHashMap();
    }

    public final void a(com.ss.android.lark.chat.chatwindow.chat.v2.push.f.e r1) {
        nmb.a.a().getCCMDependency().a();
    }

    public final void b(aqb.g r3) {
        a r0 = new a(r3);
        ((ConcurrentHashMap) a).put(r3, r0);
        nmb.a.a().getCoreDependency().o(r0);
    }

    public final void d(aqb.g r3) {
        Map<aqb.g, qpc.d> r0 = a;
        qpc.d r1 = (qpc.d) ((ConcurrentHashMap) r0).get(r3);
        ((ConcurrentHashMap) r0).remove(r3);
        if (r1 == null) goto L6;
        nmb.a.a().getCoreDependency().removePushResourceUploadProgressListener(r1);
        return;
    }

    public final void g(com.ss.android.lark.chat.chatwindow.chat.v2.push.f.e r1) {
        nmb.a.a().getCCMDependency().c();
    }
}
