package com.bytedance.android.monitorV2.listener;

import com.bytedance.android.monitorV2.event.HybridEvent$EventPhase;
import com.bytedance.android.monitorV2.m;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import mn.h;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3609a;

    public /* synthetic */ a(int r5) {
        this.f3609a = r5;
    }

    @Override // com.bytedance.android.monitorV2.listener.f
    public final void a(com.bytedance.android.monitorV2.event.d r10) {
        switch(this.f3609a) {
            case 0: goto L19;
            default: goto L4;
        };
    L4:
        Intrinsics.checkNotNullParameter(r10, "event");
        r10.d.f18728b = HybridEvent$EventPhase.f3539c;
        Iterator r11 = u4.e.f22249a.iterator();
    L6:
        if (r11.hasNext() == false) goto L12;
        ((f) r11.next()).a(r10);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        h.g("default_handle", th);
        goto L6
    L12:
        Iterator r12 = u4.e.f22250b.iterator();
    L14:
        if (r12.hasNext() == false) goto L18;
        b r5 = (b) r12.next();
        com.bytedance.android.monitorV2.event.c r13 = new com.bytedance.android.monitorV2.event.c(r10.f3557a, r10.d, r10.a().toString(), k5.h.e(r10));     // Catch: Throwable -> L21
        r5.getClass();     // Catch: Throwable -> L21
        Intrinsics.checkNotNullParameter(r13, "eventInfo");     // Catch: Throwable -> L21
        r5.a(r13, "event_unsampled");     // Catch: Throwable -> L21
        goto L14
    L18:
        return;
    L19:
        Intrinsics.checkNotNullParameter(r10, "event");
        m.b(r10);
        d5.b.c("EventDebugTools", r10.a() + " - " + r10.f3557a + " onEventSampled");
    }

    @Override // com.bytedance.android.monitorV2.listener.f
    public final void b(com.bytedance.android.monitorV2.event.d r10) {
        switch(this.f3609a) {
            case 0: goto L19;
            default: goto L4;
        };
    L4:
        Intrinsics.checkNotNullParameter(r10, "event");
        r10.d.f18728b = HybridEvent$EventPhase.e;
        Iterator r11 = u4.e.f22249a.iterator();
    L6:
        if (r11.hasNext() == false) goto L12;
        ((f) r11.next()).b(r10);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        h.g("default_handle", th);
        goto L6
    L12:
        Iterator r12 = u4.e.f22250b.iterator();
    L14:
        if (r12.hasNext() == false) goto L18;
        b r5 = (b) r12.next();
        com.bytedance.android.monitorV2.event.c r13 = new com.bytedance.android.monitorV2.event.c(r10.f3557a, r10.d, r10.a().toString(), k5.h.e(r10));     // Catch: Throwable -> L21
        r5.getClass();     // Catch: Throwable -> L21
        Intrinsics.checkNotNullParameter(r13, "eventInfo");     // Catch: Throwable -> L21
        goto L14
    L18:
        return;
    L19:
        Intrinsics.checkNotNullParameter(r10, "event");
        d5.b.c("EventDebugTools", r10.a() + " - " + r10.f3557a + " onEventUpdated");
    }

    @Override // com.bytedance.android.monitorV2.listener.f
    public final void c(com.bytedance.android.monitorV2.event.d r10) {
        switch(this.f3609a) {
            case 0: goto L19;
            default: goto L4;
        };
    L4:
        Intrinsics.checkNotNullParameter(r10, "event");
        r10.d.f18728b = HybridEvent$EventPhase.f3537a;
        Iterator r11 = u4.e.f22249a.iterator();
    L6:
        if (r11.hasNext() == false) goto L12;
        ((f) r11.next()).c(r10);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        h.g("default_handle", th);
        goto L6
    L12:
        Iterator r12 = u4.e.f22250b.iterator();
    L14:
        if (r12.hasNext() == false) goto L18;
        b r5 = (b) r12.next();
        com.bytedance.android.monitorV2.event.c r13 = new com.bytedance.android.monitorV2.event.c(r10.f3557a, r10.d, r10.a().toString(), k5.h.e(r10));     // Catch: Throwable -> L21
        r5.getClass();     // Catch: Throwable -> L21
        Intrinsics.checkNotNullParameter(r13, "eventInfo");     // Catch: Throwable -> L21
        r5.a(r13, "event_create");     // Catch: Throwable -> L21
        goto L14
    L18:
        return;
    L19:
        Intrinsics.checkNotNullParameter(r10, "event");
        m.b(r10);
        d5.b.c("EventDebugTools", r10.a() + " - " + r10.f3557a + " onEventCreate");
    }

    @Override // com.bytedance.android.monitorV2.listener.f
    public final void d(com.bytedance.android.monitorV2.event.d r10) {
        switch(this.f3609a) {
            case 0: goto L19;
            default: goto L4;
        };
    L4:
        Intrinsics.checkNotNullParameter(r10, "event");
        r10.d.f18728b = HybridEvent$EventPhase.f3538b;
        Iterator r11 = u4.e.f22249a.iterator();
    L6:
        if (r11.hasNext() == false) goto L12;
        ((f) r11.next()).d(r10);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        h.g("default_handle", th);
        goto L6
    L12:
        Iterator r12 = u4.e.f22250b.iterator();
    L14:
        if (r12.hasNext() == false) goto L18;
        b r5 = (b) r12.next();
        com.bytedance.android.monitorV2.event.c r13 = new com.bytedance.android.monitorV2.event.c(r10.f3557a, r10.d, r10.a().toString(), k5.h.e(r10));     // Catch: Throwable -> L21
        r5.getClass();     // Catch: Throwable -> L21
        Intrinsics.checkNotNullParameter(r13, "eventInfo");     // Catch: Throwable -> L21
        r5.a(r13, "event_terminated");     // Catch: Throwable -> L21
        goto L14
    L18:
        return;
    L19:
        Intrinsics.checkNotNullParameter(r10, "event");
        m.b(r10);
        d5.b.c("EventDebugTools", r10.a() + " - " + r10.f3557a + " onEventTerminated eventPhase: + " + ((HybridEvent$EventPhase) r10.d.f18728b));
    }

    @Override // com.bytedance.android.monitorV2.listener.f
    public final void e(com.bytedance.android.monitorV2.event.d r10) {
        switch(this.f3609a) {
            case 0: goto L19;
            default: goto L4;
        };
    L4:
        Intrinsics.checkNotNullParameter(r10, "event");
        r10.d.f18728b = HybridEvent$EventPhase.d;
        Iterator r11 = u4.e.f22249a.iterator();
    L6:
        if (r11.hasNext() == false) goto L12;
        ((f) r11.next()).e(r10);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        h.g("default_handle", th);
        goto L6
    L12:
        Iterator r12 = u4.e.f22250b.iterator();
    L14:
        if (r12.hasNext() == false) goto L18;
        b r5 = (b) r12.next();
        com.bytedance.android.monitorV2.event.c r13 = new com.bytedance.android.monitorV2.event.c(r10.f3557a, r10.d, r10.a().toString(), k5.h.e(r10));     // Catch: Throwable -> L21
        r5.getClass();     // Catch: Throwable -> L21
        Intrinsics.checkNotNullParameter(r13, "eventInfo");     // Catch: Throwable -> L21
        r5.a(r13, "event_uploaded");     // Catch: Throwable -> L21
        goto L14
    L18:
        return;
    L19:
        Intrinsics.checkNotNullParameter(r10, "event");
        m.b(r10);
        d5.b.c("EventDebugTools", r10.a() + " - " + r10.f3557a + " onEventUploaded");
    }
}
