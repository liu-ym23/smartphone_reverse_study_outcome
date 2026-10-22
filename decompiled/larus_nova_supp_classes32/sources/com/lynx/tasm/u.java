package com.lynx.tasm;

import com.lynx.tasm.base.LLog;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class u {
    public final Map<TemplateBundle, LinkedList<LynxEngine>> a;

    public class a implements TemplateBundle.a {
        public final /* synthetic */ LinkedList a;
        public final /* synthetic */ TemplateBundle b;
        public final /* synthetic */ u c;

        public a(u r1, LinkedList r2, TemplateBundle r3) {
            this.c = r1;
            this.a = r2;
            this.b = r3;
        }
    }

    public static class b {
        public static final u a = null;

        static {
            a = new u();
        }
    }

    public u() {
        this.a = new HashMap();
    }

    public final synchronized LinkedList<LynxEngine> a(TemplateBundle r3) {
        monitor-enter(this);
        if (r3 != null) goto L7;
        LinkedList<LynxEngine> r4 = new LinkedList();     // Catch: Throwable -> L12
        monitor-exit(this);
        return r4;
    L7:
        LinkedList<LynxEngine> r0 = (LinkedList) ((HashMap) this.a).get(r3);     // Catch: Throwable -> L12
        if (r0 != null) goto L10;
        r0 = new LinkedList();     // Catch: Throwable -> L12
        ((HashMap) this.a).put(r3, r0);     // Catch: Throwable -> L12
        r3.f = new a(this, r0, r3);     // Catch: Throwable -> L12
    L10:
        monitor-exit(this);
        return r0;
    L12:
        th = move-exception;
        throw th;
    }

    public void delete(LynxEngine r6) {
        TemplateBundle r0 = r6.c;
        if (r0 != null) goto L5;
        return;
    L5:
        LinkedList<LynxEngine> r1 = a(r0);
        LLog.i("LynxEnginePool", "deleteEngine EngineQueue Cache: " + r1 + ", bundle:" + r0);
        monitor-enter(this);
        r1.remove(r6);     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }
}
