package a3;

import b3.n;
import b3.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class a implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f63a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f64b;

    public /* synthetic */ a(String r5, int r10) {
        this.f63a = r10;
        this.f64b = r5;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch(this.f63a) {
            case 0: goto L26;
            case 1: goto L24;
            case 2: goto L12;
            default: goto L4;
        };
    L4:
        boolean r5 = Intrinsics.areEqual("applet_widget_timeline_full", "applet_widget_timeline_full");
        String r10 = this.f64b;
        if (r5 == false) goto L8;
        p r11 = b3.h.f841a;
        r11.getClass();
        Intrinsics.checkNotNullParameter(r10, "traceId");
        Intrinsics.checkNotNullParameter(r10, "traceId");
        r11.f849c.remove(r10);
        r11.d.remove(r10);
        r11.e.remove(r10);
        r11.f847a.remove(r10);
        r11.f848b.remove(r10);
        r11.g.remove(r10);
    L11:
        return Unit.INSTANCE;
    L8:
        if (Intrinsics.areEqual("applet_widget_timeline_full", "applet_page_timeline_full") == false) goto L11;
        n r12 = b3.h.f842b;
        r12.getClass();
        Intrinsics.checkNotNullParameter(r10, "traceId");
        r12.f849c.remove(r10);
        r12.d.remove(r10);
        r12.e.remove(r10);
        goto L11
    L12:
        LinkedHashMap r13 = i.f84b;
        Set r14 = r13.keySet();
        ArrayList r15 = new ArrayList();
        Iterator r16 = r14.iterator();
    L14:
        if (r16.hasNext() == false) goto L18;
        Object r17 = r16.next();
        if (StringsKt.P((String) r17, this.f64b) == false) goto L14;
        r15.add(r17);
        goto L14
    L18:
        Iterator r18 = r15.iterator();
    L20:
        if (r18.hasNext() == false) goto L23;
        r13.remove((String) r18.next());
        goto L20
    L23:
        return Unit.INSTANCE;
    L24:
        LinkedHashMap r19 = i.f84b;
        cl.a.b(this.f64b, r19).g = true;
        return Unit.INSTANCE;
    L26:
        i.f84b.remove(this.f64b);
        return Unit.INSTANCE;
    }
}
