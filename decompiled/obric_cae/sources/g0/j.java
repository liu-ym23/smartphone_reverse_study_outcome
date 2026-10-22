package g0;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class j implements i0.a<k.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f7519a;

    public j(String r8) {
        this.f7519a = r8;
    }

    @Override // i0.a
    public final void accept(k.a r8) {
        k.a r10 = r8;
        Object r11 = k.f7522c;
        monitor-enter(r11);
        n.h<String, ArrayList<i0.a<k.a>>> r12 = k.f7523d;     // Catch: Throwable -> L15
        ArrayList<i0.a<k.a>> r13 = r12.getOrDefault(this.f7519a, null);     // Catch: Throwable -> L15
        if (r13 != null) goto L8;
        monitor-exit(r11);     // Catch: Throwable -> L15
        return;
    L8:
        r12.remove(this.f7519a);     // Catch: Throwable -> L15
        monitor-exit(r11);     // Catch: Throwable -> L15
        int r14 = 0;
    L12:
        if (r14 >= r13.size()) goto L20;
        r13.get(r14).accept(r10);
        r14 = r14 + 1;
        goto L12
    L20:
        return;
    L15:
        th = move-exception;
        throw th;
    }
}
