package on;

import com.lynx.tasm.event.LynxEvent$LynxEventType;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f20779a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f20780b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LynxEvent$LynxEventType f20781c;
    public wm.a d;
    public long e;
    public long f;

    public c(int r5, String r10, LynxEvent$LynxEventType r11) {
        this.d = null;
        this.e = 0;
        this.f = 0;
        this.f20779a = r5;
        this.f20780b = r10;
        this.f20781c = r11;
        this.e = System.currentTimeMillis();
    }
}
