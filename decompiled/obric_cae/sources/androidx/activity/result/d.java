package androidx.activity.result;

import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class d extends b<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f519a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b.a f520b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ e f521c;

    public d(e r8, String r10, b.a r11) {
        this.f521c = r8;
        this.f519a = r10;
        this.f520b = r11;
    }

    @Override // androidx.activity.result.b
    public final void a(Object r8) {
        e r10 = this.f521c;
        HashMap r11 = r10.f523b;
        String r12 = this.f519a;
        Integer r13 = (Integer) r11.get(r12);
        b.a r14 = this.f520b;
        if (r13 == null) goto L11;
        r10.f525d.add(r12);
        r10.b(r13.intValue(), r14, r8);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        r10.f525d.remove(r12);
        throw e;
    L11:
        throw new IllegalStateException("Attempting to launch an unregistered ActivityResultLauncher with contract " + r14 + " and input " + r8 + ". You must ensure the ActivityResultLauncher is registered before calling launch().");
    }

    public final void b() {
        this.f521c.f(this.f519a);
    }
}
