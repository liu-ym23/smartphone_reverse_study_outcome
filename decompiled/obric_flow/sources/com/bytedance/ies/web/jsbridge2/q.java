package com.bytedance.ies.web.jsbridge2;

import android.os.SystemClock;
import java.util.Date;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class q implements ce.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArraySet f6305a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u f6306b;

    public q(u r5, CopyOnWriteArraySet r10) {
        this.f6305a = r10;
        this.f6306b = r5;
    }

    @Override // ce.c
    public final void a(ce.d r5, JSONObject r10) {
        if (this.f6305a.contains(r5.f1180c) == false) goto L6;
        r10.put("code", "-1");
        return;
    L6:
        r5.f1183j = false;
        k r11 = new k();
        r11.f6286c = r5.f1180c;
        r11.f6285b = r5.f1178a;
        r11.d = r5.d.toString();
        r11.e = r5.f1179b;
        r11.f6284a = String.valueOf(r5.e);
        r11.f = r5.f;
        r11.g = r5.g;
        r11.f6287h = r5.f1181h;
        l r12 = new l(r11);
        u r13 = this.f6306b;
        if (r13.d == true) goto L10;
        t r14 = new t();
        r14.f6308b = r14.f.format(new Date());
        r14.d = SystemClock.elapsedRealtime();
        r14.f6309c = System.currentTimeMillis();
        r14.f6307a = "label_pre_call_origin_url";
        TimeLineEvent r15 = new TimeLineEvent(r14, null);
        r13.f6312b.post(new b(r13, r12, r15, 1));
    L10:
        r5.toString();
    }
}
