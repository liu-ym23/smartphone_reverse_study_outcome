package com.larus.asr.session;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class l implements com.larus.asr.session.component.b {
    public final /* synthetic */ com.larus.asr.session.component.f0 a;
    public final /* synthetic */ ComponentAsrSession b;

    @Override // com.larus.asr.session.component.b
    public final void a(byte[] r3) {
        if (this.a.a() == true) goto L5;
        return;
    L5:
        Iterator<T> r0 = this.b.d().iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        ((com.larus.asr.session.component.o0) r0.next()).a(r3);
        goto L7
    }

    @Override // com.larus.asr.session.component.b
    public final void b(String r7) {
        Intrinsics.checkNotNullParameter(r7, "result");
        if (this.a.a() == true) goto L5;
        return;
    L5:
        ComponentAsrSession r0 = this.b;
        com.larus.asr.session.component.f0 r1 = this.a;
        f2a.c r2 = r0.e.b("asrGlobalStream invoke");
        LinkedHashMap r3 = new LinkedHashMap();
        f2a.f r4 = new f2a.f("is_empty_asr_result");
        if (r7.length() != 0) goto L8;
        boolean r5 = true;
    L9:
        r3.put(r4, String.valueOf(r5));
        r3.put(new f2a.f("is_cancel"), String.valueOf(r1.c()));
        f2a.f r6 = f2a.f.d;
        String r8 = g2a.d.b(r7);
        String r9 = "";
        if (r8 != null) goto L12;
        r8 = "";
    L12:
        r3.put(r6, r8);
        f2a.f r10 = f2a.f.c;
        String r11 = r1.m;
        if (r11 == null) goto L16;
        r9 = r11;
    L16:
        r3.put(r10, r9);
        r2.d(r3);
        List r12 = CollectionsKt.listOf(r1.b().d.a);
        f2a.g r13 = r2.c;
        r13.b = r12;
        r13.d = "asrGlobalStream";
        r2.c.e = r1.b().d.b;
        f2a.c.c(r2, null, 15);
        ComponentAsrSession r14 = this.b;
        com.larus.asr.session.component.f0 r15 = this.a;
        r14.getClass();
        com.larus.asr.session.component.a0 r16 = new com.larus.asr.session.component.a0(r15, new j(r14));
        Iterator<T> r17 = this.b.d().iterator();
    L18:
        if (r17.hasNext() == false) goto L20;
        ((com.larus.asr.session.component.o0) r17.next()).h(r16, r7);
        goto L18
    L20:
        return;
    L8:
        r5 = false;
        goto L9
    }

    @Override // com.larus.asr.session.component.b
    public final void d(com.larus.audio.b r7) {
        Intrinsics.checkNotNullParameter(r7, "result");
        if (this.a.a() == true) goto L5;
        return;
    L5:
        ComponentAsrSession r0 = this.b;
        com.larus.asr.session.component.f0 r1 = this.a;
        f2a.c r2 = r0.e.b("asrGlobalSuccess invoke");
        LinkedHashMap r3 = new LinkedHashMap();
        f2a.f r4 = new f2a.f("is_empty_asr_result");
        if (r7.b.length() != 0) goto L8;
        boolean r5 = true;
    L9:
        r3.put(r4, String.valueOf(r5));
        r3.put(new f2a.f("audio_duration"), String.valueOf(r7.c));
        r3.put(new f2a.f("is_cancel"), String.valueOf(r1.c()));
        f2a.f r6 = f2a.f.d;
        String r8 = g2a.d.b(r7.b);
        if (r8 != null) goto L12;
        r8 = "";
    L12:
        r3.put(r6, r8);
        r3.put(f2a.f.c, r7.a);
        r2.d(r3);
        r2.c.d = "asrGlobalSuccess";
        r2.c.b = CollectionsKt.listOf(r1.b().d.a);
        r2.c.e = r1.b().d.b;
        f2a.c.c(r2, null, 15);
        ComponentAsrSession r9 = this.b;
        com.larus.asr.session.component.f0 r10 = this.a;
        r9.getClass();
        com.larus.asr.session.component.a0 r11 = new com.larus.asr.session.component.a0(r10, new j(r9));
        Iterator<T> r12 = this.b.d().iterator();
    L14:
        if (r12.hasNext() == false) goto L16;
        ((com.larus.asr.session.component.o0) r12.next()).l(r11, r7);
        goto L14
    L16:
        return;
    L8:
        r5 = false;
        goto L9
    }

    public l(com.larus.asr.session.component.f0 r1, ComponentAsrSession r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // com.larus.asr.session.component.b
    public final void c(String r11, String r12, long r13, int r15) {
        Intrinsics.checkNotNullParameter(r11, "taskId");
        Intrinsics.checkNotNullParameter(r12, "path");
        if (this.a.a() == true) goto L5;
        return;
    L5:
        this.b.j(this.a, r11, r12, r15);
        ComponentAsrSession r0 = this.b;
        com.larus.asr.session.component.f0 r1 = this.a;
        f2a.c r2 = r0.e.b("asrGlobalFail invoke");
        LinkedHashMap r3 = new LinkedHashMap();
        r3.put(new f2a.f("error_code"), String.valueOf(r15));
        r3.put(new f2a.f("duration"), String.valueOf(r13));
        r3.put(f2a.f.c, r11);
        r2.d(r3);
        r2.c.d = "asrGlobalFail";
        r2.c.b = CollectionsKt.listOf(r1.b().d.a);
        r2.c.e = r1.b().d.b;
        f2a.c.c(r2, null, 15);
        ComponentAsrSession r4 = this.b;
        com.larus.asr.session.component.f0 r5 = this.a;
        r4.getClass();
        com.larus.asr.session.component.a0 r9 = new com.larus.asr.session.component.a0(r5, new j(r4));
        Iterator<T> r6 = this.b.d().iterator();
    L7:
        if (r6.hasNext() == false) goto L9;
        ((com.larus.asr.session.component.o0) r6.next()).f(r9, r11, r12, r13, r15);
        goto L7
    }
}
