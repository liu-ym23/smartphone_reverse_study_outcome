package ef8;

import com.larus.bmhome.chat.layout.holder.menu.item.MenuActionType;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class c implements a {
    public final List<ot8.a> a;

    public c(List<? extends ot8.a> r2) {
        Intrinsics.checkNotNullParameter(r2, "menuItems");
        this.a = r2;
    }

    @Override // ef8.a
    public final boolean a(int r5) {
        if (this.a.isEmpty() == false) goto L5;
        return false;
    L5:
        List<ot8.a> r0 = this.a;
        if ((r0 instanceof Collection) == true) goto L8;
    L10:
        Iterator<T> r1 = r0.iterator();
    L12:
        if (r1.hasNext() == false) goto L9;
        if (((ot8.a) r1.next()).getId() == r5) goto L16;
        boolean r2 = true;
    L17:
        if (r2 == true) goto L12;
        boolean r6 = false;
    L19:
        if (r6 == false) goto L47;
        List<ot8.a> r7 = this.a;
        if ((r7 instanceof Collection) == true) goto L23;
    L25:
        Iterator<T> r8 = r7.iterator();
    L27:
        if (r8.hasNext() == false) goto L24;
        if (((ot8.a) r8.next()).getId() != MenuActionType.MORE.getType()) goto L31;
        boolean r3 = true;
    L32:
        if (r3 == false) goto L27;
        boolean r9 = true;
    L34:
        if (r9 == false) goto L48;
        return true;
    L48:
        return false;
    L31:
        r3 = false;
    L24:
        r9 = false;
        goto L34
    L23:
        if (r7.isEmpty() == false) goto L25;
    L47:
        return false;
    L16:
        r2 = false;
    L9:
        r6 = true;
        goto L19
    L8:
        if (r0.isEmpty() == false) goto L10;
        goto L9
    }
}
