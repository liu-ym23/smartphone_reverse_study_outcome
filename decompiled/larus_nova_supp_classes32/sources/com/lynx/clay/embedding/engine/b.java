package com.lynx.clay.embedding.engine;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b implements FlutterEngine.a {
    public final /* synthetic */ FlutterEngine a;
    public final /* synthetic */ c b;

    @Override // com.lynx.clay.embedding.engine.FlutterEngine.a
    public final void b() {
    }

    @Override // com.lynx.clay.embedding.engine.FlutterEngine.a
    public final void a() {
        List<FlutterEngine> r0 = this.b.a;
        ArrayList r1 = (ArrayList) r0;
        r1.remove(this.a);
    }

    public b(c r1, FlutterEngine r2) {
        this.b = r1;
        this.a = r2;
    }
}
