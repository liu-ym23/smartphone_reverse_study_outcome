package com.bytedance.applog.collector;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.applog.n.i;
import org.threeten.bp.chrono.HijrahDate;

/* JADX INFO: loaded from: classes.dex */
public class c implements Handler.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bytedance.applog.b f1553a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Handler f1554b;
    private boolean c;
    private int d;
    private final int e;
    private boolean f;

    public c(com.bytedance.applog.b r3, Looper r4) {
        this.c = true;
        this.d = 0;
        this.e = HijrahDate.MAX_VALUE_OF_ERA;
        this.f = false;
        this.f1553a = r3;
        this.f1554b = new Handler(r4, this);
    }

    private void a() {
        this.f1553a.aA().c("App back to frontend...", new Object[0]);
        if (this.f1553a.f() != null) goto L5;
        return;
    L5:
        if (this.f1553a.f().Q() == false) goto L9;
        this.f1553a.c();
        return;
    }

    private void b() {
        this.f1553a.aA().c("App first to frontend...", new Object[0]);
    }

    private void c() {
        this.f1553a.aA().c("App enter to background...", new Object[0]);
        if (this.f1553a.f() == null) goto L8;
        if (this.f1553a.f().P() == false) goto L8;
        this.f1553a.g();
    L8:
        if (this.f1553a.f() != null) goto L10;
    L12:
        this.f1553a.ab().b();
        return;
    L10:
        if (this.f1553a.f().Q() == false) goto L12;
        this.f1553a.d();
        goto L12
    }

    public void a(i r5) {
        if (r5.v <= 0) goto L5;
        this.f1554b.sendEmptyMessageDelayed(HijrahDate.MAX_VALUE_OF_ERA, 500);
        this.d = Math.max(0, this.d - 1);
        return;
    L5:
        this.f1554b.removeMessages(HijrahDate.MAX_VALUE_OF_ERA);
        this.d++;
        if (this.c == false) goto L9;
        this.c = false;
        b();
    L9:
        if (this.f == false) goto L13;
        this.f = false;
        a();
        return;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message r2) {
        if (r2.what != 9999) goto L7;
        this.f = true;
        c();
        return false;
    L7:
        return false;
    }
}
