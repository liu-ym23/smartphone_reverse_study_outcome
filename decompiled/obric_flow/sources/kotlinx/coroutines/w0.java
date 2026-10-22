package kotlinx.coroutines;

import kotlin.Unit;

/* JADX INFO: loaded from: classes3.dex */
public final class w0 extends y0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final l f19028c;
    public final /* synthetic */ a1 d;

    public w0(a1 r5, long r10, l r11) {
        this.d = r5;
        super(r10);
        this.f19028c = r11;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Unit r5 = Unit.INSTANCE;
        this.f19028c.F(this.d, r5);
    }

    @Override // kotlinx.coroutines.y0
    public final String toString() {
        return super.toString() + this.f19028c;
    }
}
