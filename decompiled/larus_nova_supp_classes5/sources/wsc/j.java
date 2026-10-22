package wsc;

import android.graphics.Rect;
import com.larus.business.markdown.api.extplugin.image.a;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import lsc.h;
import lsc.t;
import lsc.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class j extends s {
    public final Integer a;
    public final int b;
    public final Integer c;
    public final Integer d;
    public final Rect e;
    public final a f;
    public final Map<String, Object> g;

    @Override // lsc.x
    public Object a(h r18, t r19) {
        Intrinsics.checkNotNullParameter(r18, "configuration");
        Intrinsics.checkNotNullParameter(r19, "props");
        String r7 = (String) n.a.b(r19);
        o r9 = (o) n.c.a(r19);
        if (r9 == null) goto L5;
    L8:
        Integer r3 = (Integer) n.d.a(r19);
        if (r3 == null) goto L11;
        int r5 = r3.intValue();
        Integer r4 = (Integer) n.e.a(r19);
        if (r4 == null) goto L15;
        int r6 = r4.intValue();
        Integer r8 = this.c;
        if (r8 == null) goto L25;
        int r12 = r8.intValue();
        Integer r10 = this.d;
        if (r10 == null) goto L21;
        int r13 = r10.intValue();
    L22:
        msc.s r11 = r18.a;
        u r2 = (u) r19;
        ((Boolean) r2.b(n.b, Boolean.FALSE)).booleanValue();
        return new l(r5, r6, r7, r11, r9, this.a, this.b, r12, r13, this.e, this.f, this.g);
    L21:
        r13 = 0;
        goto L22
    L25:
        return Unit.INSTANCE;
    L15:
        return Unit.INSTANCE;
    L11:
        return Unit.INSTANCE;
    L5:
        if (this.e != null) goto L8;
        return Unit.INSTANCE;
    }

    public j(Integer r1, int r2, Integer r3, Integer r4, Rect r5, a r6, Map<String, ? extends Object> r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }
}
