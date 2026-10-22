package c4;

import android.util.Log;
import androidx.lifecycle.s;

/* JADX INFO: loaded from: classes.dex */
public final class d implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r3.c f3330a;

    public d(r3.c r8) {
        this.f3330a = r8;
        i.a r10 = i.f3338i;
        s r11 = new s(3);
        String r12 = r8.f11401i;
        Object r13 = r11.f2194b;
        ((i) r13).f3339a = r12;
        ((i) r13).f3341c = 1;
        ((i) r13).f3340b = Thread.currentThread().getName();
        ((i) r13).f3344f = "Console logger is ready.";
        a((i) r13);
    }

    @Override // c4.h
    public final void a(i r8) {
        if (this.f3330a.i() == true) goto L5;
        return;
    L5:
        int r10 = r8.f3341c;
        if (r10 != 0) goto L8;
        Log.v("AppLog", r8.b());
        return;
    L8:
        if (r10 != 2) goto L10;
        Log.i("AppLog", r8.b());
        return;
    L10:
        if (r10 != 3) goto L12;
        Log.w("AppLog", r8.b(), r8.f3346h);
        return;
    L12:
        if (r10 != 4) goto L14;
    L16:
        Log.e("AppLog", r8.toString(), r8.f3346h);
        return;
    L14:
        if (r10 == 5) goto L16;
        Log.d("AppLog", r8.toString());
    }
}
