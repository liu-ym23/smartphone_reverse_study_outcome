package com.bytedance.android.live.core.privacy.av.impl;

import android.os.Handler;
import android.os.Message;
import com.bytedance.android.live.core.privacy.av.api.AudioAndVideoException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f implements Handler.Callback {
    public final /* synthetic */ e a;

    public f(e r1) {
        this.a = r1;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message r17) {
        Intrinsics.checkNotNullParameter(r17, "it");
        Object r3 = null;
        boolean r4 = true;
        if ((r17.obj instanceof e.b) == false) goto L24;
        Iterator r2 = ((CopyOnWriteArrayList) this.a.c).iterator();
    L6:
        if (r2.hasNext() == false) goto L24;
        e.c r5 = (e.c) r2.next();
        if (r5.getType() != r17.what) goto L10;
        r5.h = true;
    L10:
        Object r6 = r17.obj;
        if ((r6 instanceof e.b) == true) goto L13;
        r6 = null;
    L13:
        e.b r7 = (e.b) r6;
        if (r7 == null) goto L16;
        int r8 = r7.a;
    L18:
        if (r5.a == r8) goto L23;
        List r9 = (List) ((ConcurrentHashMap) this.a.b).get(Integer.valueOf(r8));
        if (r9 == null) goto L6;
        if (r9.contains(Integer.valueOf(r5.a)) != true) goto L6;
    L23:
        r5.h = true;
        goto L6
    L16:
        r8 = -1;
    L24:
        Object r11 = r17.obj;
        if ((r11 instanceof e.c) == false) goto L28;
        r3 = r11;
    L28:
        e.c r12 = (e.c) r3;
        if (r12 != null) goto L31;
        return false;
    L31:
        ((CopyOnWriteArrayList) this.a.c).remove(r12);
        int r1 = r17.what;
        String r13 = r12.b;
        String r14 = r12.c;
        com.bytedance.android.live.core.privacy.av.api.a r15 = r12.f;
        Map<String, String> r16 = r12.d;
        com.bytedance.android.live.core.privacy.av.api.b r18 = r12.e;
        String r19 = this.a.d.get(Integer.valueOf(r1));
        if (r19 != null) goto L34;
        r19 = "-";
    L34:
        String r110 = r19;
        if (r12.h == false) goto L38;
        r18.c(r13, r14, r110, r16, r15);
        this.a.g.c(r13, r14, r110, r16, r15);
        return false;
    L38:
        List<String> r21 = this.a.h.c();
        if (r21 != null) goto L41;
    L44:
        if (r1 != 1) goto L46;
        r4 = this.a.f.a(r15.b());
    L56:
        if (r4 == true) goto L58;
        AudioAndVideoException r22 = new AudioAndVideoException(r13 + '-' + r14 + '-' + r110 + " check failed");
        r18.a(r13, r14, r110, r16, r15, r22);
        this.a.g.a(r13, r14, r110, r16, r15, r22);
    L59:
        return false;
    L58:
        r18.d(r13, r14, r110, r16, r15);
        this.a.g.d(r13, r14, r110, r16, r15);
        goto L59
    L46:
        if (r1 != 2) goto L48;
        r4 = this.a.f.b(r15.b());
        goto L56
    L48:
        if (r1 != 3) goto L50;
        r4 = this.a.f.c(r15.b());
        goto L56
    L50:
        if (r1 != 4) goto L56;
        r4 = this.a.f.d(r15.b());
        goto L56
    L41:
        if (r21.contains(r13) != true) goto L44;
        r18.c(r13, r14, r110, r16, r15);
        this.a.g.c(r13, r14, r110, r16, r15);
        return false;
    }
}
