package d6;

import com.bytedance.apm.block.trace.MethodCollector;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends jg.a {
    @Override // jg.a
    public final void a() {
        this.f18321a = false;
        MethodCollector.access$300();
    }

    @Override // jg.a
    public final void b(String r5) {
        this.f18321a = true;
        MethodCollector.access$200();
    }

    @Override // jg.a
    public final boolean c() {
        if (MethodCollector.access$000() == null) goto L6;
        MethodCollector.access$000().run();
        MethodCollector.access$002(null);
    L6:
        if (MethodCollector.access$100() >= 1) goto L10;
        return false;
    L10:
        return true;
    }
}
