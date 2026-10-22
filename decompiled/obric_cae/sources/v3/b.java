package v3;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import c4.m;
import i4.f;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class b implements Handler.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r3.c f12711a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f12712b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f12713m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f12714n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f12715o;

    public b(r3.c r8, Looper r10) {
        this.f12713m = true;
        this.f12714n = 0;
        this.f12715o = false;
        this.f12711a = r8;
        this.f12712b = new Handler(r10, this);
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message r8) {
        if (r8.what != 9999) goto L14;
        this.f12715o = true;
        r3.c r10 = this.f12711a;
        r10.H.e("App enter to background...", new Object[0]);
        if (r10.e() == null) goto L8;
        r10.e().getClass();
    L8:
        if (r10.e() == null) goto L10;
        r10.e().getClass();
    L10:
        f r11 = r10.f11417y;
        if (r11.f8219r == null) goto L14;
        List<String> r12 = f.f8209w;
        m.u().l(8, r12, "monitor flush...", new Object[0]);
        r11.f8219r.removeMessages(1);
        r11.f8219r.sendEmptyMessageDelayed(1, 500);
    L14:
        return false;
    }
}
