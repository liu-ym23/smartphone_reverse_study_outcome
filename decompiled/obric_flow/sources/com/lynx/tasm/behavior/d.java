package com.lynx.tasm.behavior;

import android.media.MediaMetadataRetriever;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.bytedance.ai.event.MessageIndication;
import com.lynx.tasm.LynxView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.threeten.bp.LocalTime;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements b, bi.a, com.bumptech.glide.load.resource.bitmap.y, mi.b, c7.f, pt.p, com.bytedance.crash.e, org.threeten.bp.temporal.i, s9.a, gc.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10215a;

    public /* synthetic */ d(int r5) {
        this.f10215a = r5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v5, types: [T, com.bytedance.android.monitorV2.lynx.impl.d] */
    public com.bytedance.android.monitorV2.lynx.impl.d a(LynxView r5, String r10) {
        if (r5 == null) goto L4;
        Ref.ObjectRef r11 = new Ref.ObjectRef();
        com.bytedance.android.monitorV2.lynx.impl.d r12 = (com.bytedance.android.monitorV2.lynx.impl.d) com.bytedance.android.monitorV2.lynx.impl.d.f3685m.get(r5);
        T r13 = r12;
        if (r12 != null) goto L8;
        r13 = (com.bytedance.android.monitorV2.lynx.impl.d) com.bytedance.android.monitorV2.lynx.impl.d.f3686n.get(r5);
    L8:
        r11.element = r13;
        if (r13 != 0) goto L45;
        monitor-enter(this);
    L35:
        th = move-exception;
        throw th;
    L12:
        if (r11.element != 0) goto L40;
        ?? r14 = new com.bytedance.android.monitorV2.lynx.impl.d(r5);     // Catch: Throwable -> L35
        r14.f3690i = r10;     // Catch: Throwable -> L35
        r11.element = r14;     // Catch: Throwable -> L35
        android.support.v4.media.c r15 = fj.a.f16916b;     // Catch: Throwable -> L35
        if (r15 == null) goto L37;
        com.bytedance.android.monitorV2.settings.d r16 = (com.bytedance.android.monitorV2.settings.d) r15.e(com.bytedance.android.monitorV2.settings.d.class);     // Catch: Throwable -> L35
        if (r16 == null) goto L37;
        if (r16.c() != true) goto L37;
        com.bytedance.android.monitorV2.lynx.impl.d r17 = (com.bytedance.android.monitorV2.lynx.impl.d) r11.element;     // Catch: Throwable -> L35
        if (r17 == null) goto L37;
        if (r17.H() == false) goto L37;
        com.bytedance.android.monitorV2.lynx.impl.e r18 = r17.e;     // Catch: Throwable -> L35
        if (r18 == null) goto L27;
        r18.I();     // Catch: Throwable -> L35
    L27:
        r17.e = new com.bytedance.android.monitorV2.lynx.impl.e(r17);     // Catch: Throwable -> L35
        r17.f = true;     // Catch: Throwable -> L35
        LynxView r19 = r17.F();     // Catch: Throwable -> L35
        if (r19 == null) goto L30;
        r19.addOnAttachStateChangeListener(r17);     // Catch: Throwable -> L35
    L30:
        com.bytedance.android.monitorV2.lynx.impl.e r20 = r17.e;     // Catch: Throwable -> L35
        if (r20 == null) goto L37;
        LynxView r21 = r20.F();     // Catch: Throwable -> L35
        if (r21 == null) goto L37;
        j5.b.e(r21, r20);     // Catch: Throwable -> L35
    L37:
        com.bytedance.android.monitorV2.lynx.impl.d.f3686n.put(r5, r11.element);     // Catch: Throwable -> L35
        if (r10 == null) goto L40;
        com.bytedance.android.monitorV2.lynx.impl.d.f3687o.put(r10, r11.element);     // Catch: Throwable -> L35
    L40:
        Unit r22 = Unit.INSTANCE;     // Catch: Throwable -> L35
        monitor-exit(this);
    L45:
        com.bytedance.android.monitorV2.lynx.impl.d r23 = (com.bytedance.android.monitorV2.lynx.impl.d) r11.element;
        if (r23 == null) goto L48;
        return r23;
    L48:
        return (com.bytedance.android.monitorV2.lynx.impl.d) com.bytedance.android.monitorV2.lynx.impl.d.f3684l.getValue();
    L4:
        return (com.bytedance.android.monitorV2.lynx.impl.d) com.bytedance.android.monitorV2.lynx.impl.d.f3684l.getValue();
    }

    @Override // com.bumptech.glide.load.resource.bitmap.y
    public void c(MediaMetadataRetriever r5, Object r10) {
        r5.setDataSource(((ParcelFileDescriptor) r10).getFileDescriptor());
    }

    @Override // com.lynx.tasm.behavior.b
    public List create() {
        ArrayList r15 = new ArrayList();
        boolean r13 = true;
        boolean r14 = false;
        r15.add(new com.ivy.ivykit.plugin.impl.render.a("view", r13, r13, r14, 16));
        r15.add(new com.ivy.ivykit.plugin.impl.render.a(MessageIndication.CONTENT_TYPE_TEXT, r13, r13, r14, 17));
        r15.add(new com.ivy.ivykit.plugin.impl.render.a("raw-text", r14, r13, r14, 18));
        r15.add(new com.ivy.ivykit.plugin.impl.render.a("inline-text", r14, r13, r14, 19));
        r15.add(new com.ivy.ivykit.plugin.impl.render.a("inline-truncation", r14, r13, r14, 20));
        r15.add(new com.ivy.ivykit.plugin.impl.render.a("scroll-view", r14, r13, r14, 21));
        r15.add(new com.ivy.ivykit.plugin.impl.render.a("bounce-view", r14, r13, r14, 22));
        r15.add(new com.ivy.ivykit.plugin.impl.render.a("component", r13, r13, r14, 23));
        r15.add(new com.ivy.ivykit.plugin.impl.render.a("list", r14, r13, r14, 24));
        r15.add(new com.ivy.ivykit.plugin.impl.render.a("list-item", r14, r13, r14, 13));
        r15.add(new com.ivy.ivykit.plugin.impl.render.a("list-container", r14, r13, r14, 14));
        r15.add(new com.ivy.ivykit.plugin.impl.render.a("frame", r14, r13, r14, 15));
        return r15;
    }

    @Override // org.threeten.bp.temporal.i
    public Object d(org.threeten.bp.temporal.d r5) {
        switch(this.f10215a) {
            case 14: goto L7;
            default: goto L5;
        };
    L5:
        return (org.threeten.bp.temporal.j) r5.query(this);
    L7:
        return LocalTime.from(r5);
    }

    @Override // gc.a
    public void e(wc.g r5, ug.d r10) {
        Intrinsics.checkNotNullParameter(r5, "config");
        Intrinsics.checkNotNullParameter(r10, "info");
        Intrinsics.checkNotNullParameter("empty report: RLReportController not register", "msg");
        dc.b.f16633a.c("[ResourceLoader] empty report: RLReportController not register");
    }

    public com.bytedance.ies.argus.aspect.eventCenter.e f() {
        return null;
    }

    public void g(LynxView r5, com.bytedance.android.monitorV2.event.a r10, int r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "event");
        if (r5 != null) goto L5;
        com.bytedance.android.monitorV2.lynx.impl.e r13 = ((com.bytedance.android.monitorV2.lynx.impl.d) com.bytedance.android.monitorV2.lynx.impl.d.f3684l.getValue()).e;
    L6:
        if (r13 == null) goto L11;
        if (r12 != null) goto L9;
        r12 = "";
    L9:
        Intrinsics.checkNotNullParameter(r10, "event");
        Intrinsics.checkNotNullParameter(r12, "message");
        r13.f3699n.t(r10, r11, r12);
        return;
    L11:
        return;
    L5:
        r13 = a(r5, null).e;
        goto L6
    }

    public void h(LynxView r5, com.bytedance.android.monitorV2.event.d r10) {
        Intrinsics.checkNotNullParameter(r10, "event");
        if (r5 != null) goto L5;
        com.bytedance.android.monitorV2.lynx.impl.e r11 = ((com.bytedance.android.monitorV2.lynx.impl.d) com.bytedance.android.monitorV2.lynx.impl.d.f3684l.getValue()).e;
    L6:
        if (r11 == null) goto L9;
        r11.G(r10);
        return;
    L9:
        d5.b.d("LynxViewDataManager", "Failed to get current navigation!", new Throwable());
        return;
    L5:
        r11 = a(r5, null).e;
        goto L6
    }

    @Override // pt.p
    public boolean test(Object r5) {
        return true;
    }

    @Override // mi.b
    public void a(String r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "tag");
        Intrinsics.checkNotNullParameter(r10, "msg");
        Log.i(r5, r10);
    }

    @Override // s9.a
    /* JADX INFO: renamed from: create, reason: collision with other method in class */
    public s9.b mo98create() {
        return new s9.b();
    }
}
