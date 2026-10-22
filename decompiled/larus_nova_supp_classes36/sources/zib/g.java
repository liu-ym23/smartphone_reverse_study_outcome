package zib;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.location_ui.statistics.LocationHitPoint$ResultType;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import z5c.a2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class g implements Runnable {
    public final /* synthetic */ SearchBaseInfo a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ s5c.d c;
    public final /* synthetic */ s5c.d d;
    public final /* synthetic */ boolean e;

    public g(SearchBaseInfo r1, boolean r2, s5c.a r3, s5c.a r4, boolean r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    public final void a() {
        a2 r0 = a2.c;
        int r1 = e.a;
        s5c.a r2 = r0.a(e.a.a(this.a));
        s5c.d.a r3 = s5c.d.o2;
        if (this.b == false) goto L5;
        String r4 = LocationHitPoint$ResultType.SEARCH;
    L6:
        r3.getClass();
        s5c.a r5 = new s5c.a("panel_type", r4);
        com.ss.android.lark.forwardv3.utils.b.d();
        s5c.a r6 = new s5c.a("panel_version", "integration_portrait_display");
        s5c.d r7 = this.c.plus(this.d).plus(r5).plus(r2).plus(r6);
        r7.plus(new s5c.a("is_knowledge_ai_show", String.valueOf(this.e)));
        e.a.c(r7);
        return;
    L5:
        r4 = "recommend";
        goto L6
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
