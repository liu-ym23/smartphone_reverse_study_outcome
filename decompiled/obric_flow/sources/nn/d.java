package nn;

import com.lynx.tasm.core.resource.LynxResourceLoader;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f20276a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f20277b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f20278c;
    public final /* synthetic */ LynxResourceLoader d;

    public d(int r5, long r10, LynxResourceLoader r11, String r12) {
        this.d = r11;
        this.f20276a = r10;
        this.f20277b = r12;
        this.f20278c = r5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String r5 = this.f20277b;
        int r10 = this.f20278c;
        this.d.b(r10, r5, this.f20276a);
    }
}
