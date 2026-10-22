package gz8;

import com.larus.bmhome.actionbar.model.ModelItemIdentity;
import com.larus.bmhome.actionbar.model.ReplyOption;
import com.larus.bmhome.actionbar.model.a2;
import com.larus.bmhome.actionbar.model.b2;
import com.larus.bmhome.actionbar.model.u1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class j implements k {
    public final a2 a;

    public j(a2 r1) {
        this.a = r1;
    }

    @Override // gz8.k
    public final ReplyOption a(int r6, ReplyOption r7) {
        boolean r0 = true;
        List<b2> r8 = b(r6, true);
        Integer r1 = null;
        if (r7 == null) goto L19;
        ArrayList r2 = (ArrayList) r8;
        if (r2.isEmpty() == true) goto L13;
        Iterator r3 = r2.iterator();
    L9:
        if (r3.hasNext() == false) goto L13;
        if (c.b((b2) r3.next(), r7.getModel()) == false) goto L9;
    L14:
        if (r0 == true) goto L17;
        r7 = null;
    L17:
        if (r7 == null) goto L19;
        return r7;
    L13:
        r0 = false;
    L19:
        b2 r9 = (b2) CollectionsKt.firstOrNull(r8);
        if (r9 == null) goto L32;
        ModelItemIdentity r10 = r9.b();
        if (r10 == null) goto L32;
        String r4 = r9.s;
        if (r4 != null) goto L27;
        r4 = "";
    L27:
        u1 r11 = r9.t;
        if (r11 == null) goto L31;
        r1 = r11.b;
    L31:
        return new ReplyOption(r10, r4, r1);
    L32:
        return null;
    }

    @Override // gz8.k
    public final List<b2> b(int r7, boolean r8) {
        a2 r0 = this.a;
        if (r0 == null) goto L5;
        List r1 = r0.a;
    L6:
        if (r1 != null) goto L8;
        r1 = CollectionsKt.emptyList();
    L8:
        ArrayList r2 = new ArrayList();
        Iterator r3 = r1.iterator();
    L10:
        if (r3.hasNext() == false) goto L28;
        Object r4 = r3.next();
        b2 r5 = (b2) r4;
        Integer r6 = r5.l;
        if (r6 != null) goto L15;
    L25:
        boolean r9 = false;
    L26:
        if (r9 == false) goto L10;
        r2.add(r4);
        goto L10
    L15:
        if (r6.intValue() != r7) goto L25;
        ModelItemIdentity r10 = r5.b();
        if (r10 == null) goto L19;
        String r11 = r10.getKey();
    L20:
        if (r11 == null) goto L25;
        if (r8 == true) goto L23;
    L24:
        r9 = true;
        goto L26
    L23:
        if (c.a(r5) == false) goto L25;
    L19:
        r11 = null;
        goto L20
    L28:
        return r2;
    L5:
        r1 = null;
        goto L6
    }

    @Override // gz8.k
    public final boolean c(ReplyOption r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "option");
        ArrayList r6 = (ArrayList) b(r5, false);
        if (r6.isEmpty() == true) goto L15;
        Iterator r7 = r6.iterator();
    L7:
        if (r7.hasNext() == false) goto L16;
        if (c.b((b2) r7.next(), r4.getModel()) == false) goto L7;
        return true;
    L16:
        return false;
    L15:
        return false;
    }
}
