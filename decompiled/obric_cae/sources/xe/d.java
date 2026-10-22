package xe;

import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f13897a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f13898b;

    public d(String r8, boolean r10) {
        this.f13897a = r8;
        this.f13898b = r10;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable r8) {
        Thread r10 = new Thread(r8, this.f13897a);
        r10.setDaemon(this.f13898b);
        return r10;
    }
}
