package f1;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class c implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bytedance.applog.c f8789a;

    public c(com.bytedance.applog.c r10) {
        this.f8789a = r10;
        a(i.b().a(r10.getAppId()).d(1).g(Thread.currentThread().getName()).e("Console logger debug is:" + r10.b0()).b());
    }

    @Override // f1.h
    public void a(i r10) {
        if (this.f8789a.b0() == true) goto L5;
        return;
    L5:
        int r11 = r10.e();
        if (r11 != 0) goto L8;
        Log.v("AppLog", r10.r());
        return;
    L8:
        if (r11 != 2) goto L10;
        Log.i("AppLog", r10.r());
        return;
    L10:
        if (r11 != 3) goto L12;
        Log.w("AppLog", r10.r(), r10.h());
        return;
    L12:
        if (r11 != 4) goto L14;
    L16:
        Log.e("AppLog", r10.r(), r10.h());
        return;
    L14:
        if (r11 == 5) goto L16;
        Log.d("AppLog", r10.r());
    }
}
