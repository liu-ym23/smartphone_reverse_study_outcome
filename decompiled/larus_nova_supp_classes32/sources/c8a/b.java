package c8a;

import b8a.m;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.tasm.eventreport.LynxEventReporter;
import com.lynx.tasm.s1;
import com.miui.easygo.constant.EasyGoDbTable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b {
    public long a;
    public long b;
    public final ArrayList<Long> c;
    public long d;
    public boolean e;
    public boolean f;
    public int g;
    public WeakReference<y7a.a> h;

    public final y7a.a b() {
        WeakReference<y7a.a> r0 = this.h;
        if (r0 != null) goto L5;
        y7a.a r1 = null;
    L7:
        if ((r1 instanceof s1) == true) goto L9;
    L11:
        return r1;
    L9:
        if ((!((s1) r1).a.isEmpty()) == true) goto L11;
        return null;
    L5:
        r1 = r0.get();
        goto L7
    }

    public final void d() {
        if (this.f == true) goto L13;
        final long r4 = this.a;
        if (r4 < 0) goto L14;
        final long r6 = this.b;
        if (r6 < r4) goto L15;
        final long r2 = this.d;
        if (r2 < r6) goto L16;
        this.f = true;
        LynxEventReporter.onEvent("lynxsdk_performance_entry_pipeline", this.g, new a(r2, r4, r6));
        return;
    L16:
        return;
    L15:
        return;
    L14:
        return;
    }

    public b() {
        this.a = -1;
        this.b = -1;
        this.c = new ArrayList();
        this.d = -1;
        this.e = false;
        this.f = false;
        this.g = -1;
    }

    public final void a(y7a.a r6) {
        if (this.e == false) goto L5;
        return;
    L5:
        long r0 = this.a;
        if (r0 >= 0) goto L8;
        return;
    L8:
        if (this.d < r0) goto L16;
        this.e = true;
        if (r6 != null) goto L13;
        return;
    L13:
        JavaOnlyMap r1 = new JavaOnlyMap();
        r1.put("entryType", "pipeline");
        r1.put(EasyGoDbTable.Server.NAME, "loadBundle");
        r1.put("loadBundleStart", Double.valueOf(this.a / 1000.0d));
        r1.put("paintEnd", Double.valueOf(this.d / 1000.0d));
        r6.onPerformanceEvent(m.e(r1));
        return;
    }

    public final void c(String r7, long r8) {
        r7.getClass();
        byte r2 = -1;
        switch(r7.hashCode()) {
            case -1930716102: goto L18;
            case -337217869: goto L14;
            case 831051791: goto L10;
            case 925946781: goto L6;
            default: goto L21;
        };
    L21:
        switch(r2) {
            case 0: goto L33;
            case 1: goto L32;
            case 2: goto L31;
            case 3: goto L23;
            default: goto L39;
        };
    L23:
        this.d = r8;
        y7a.a r9 = b();
        a(r9);
        if (r9 != null) goto L26;
        this.c.clear();
    L30:
        d();
        return;
    L26:
        ArrayList r10 = new ArrayList(this.c);
        this.c.clear();
        Iterator r11 = r10.iterator();
    L28:
        if (r11.hasNext() == false) goto L30;
        Long r12 = (Long) r11.next();
        JavaOnlyMap r0 = new JavaOnlyMap();
        r0.put("entryType", "pipeline");
        r0.put(EasyGoDbTable.Server.NAME, "updateTriggeredByNative");
        r0.put("pipelineStart", Double.valueOf(r12.longValue() / 1000.0d));
        r0.put("paintEnd", Double.valueOf(this.d / 1000.0d));
        r9.onPerformanceEvent(m.e(r0));
        goto L28
    L31:
        this.c.add(Long.valueOf(r8));
        return;
    L32:
        this.b = r8;
        a(b());
        d();
        return;
    L33:
        this.a = r8;
        return;
    L39:
        return;
    L6:
        if (r7.equals("paintEnd") == false) goto L21;
        r2 = 3;
        goto L21
    L10:
        if (r7.equals("updateDataStart") == false) goto L21;
        r2 = 2;
        goto L21
    L14:
        if (r7.equals("loadBundleEnd") == false) goto L21;
        r2 = 1;
        goto L21
    L18:
        if (r7.equals("loadBundleStart") == false) goto L21;
        r2 = 0;
        goto L21
    }
}
