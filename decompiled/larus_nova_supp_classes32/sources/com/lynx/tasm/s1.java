package com.lynx.tasm;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class s1 extends LynxViewClientV2 {
    public final CopyOnWriteArrayList<LynxViewClientV2> a;

    @Override // com.lynx.tasm.LynxViewClientV2
    public final void c() {
        Iterator<LynxViewClientV2> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().c();
        goto L4
    }

    public s1() {
        this.a = new CopyOnWriteArrayList();
    }

    @Override // com.lynx.tasm.LynxViewClientV2
    public final void a(JSONObject r3) {
        Iterator<LynxViewClientV2> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().a(r3);
        goto L4
    }

    @Override // com.lynx.tasm.LynxViewClientV2, y7a.a
    public final void onPerformanceEvent(b8a.l r3) {
        Iterator<LynxViewClientV2> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onPerformanceEvent(r3);
        goto L4
    }

    @Override // com.lynx.tasm.LynxViewClientV2
    public final void b(LynxView r3, LynxViewClientV2.LynxPipelineInfo r4) {
        Iterator<LynxViewClientV2> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().b(r3, r4);
        goto L4
    }
}
