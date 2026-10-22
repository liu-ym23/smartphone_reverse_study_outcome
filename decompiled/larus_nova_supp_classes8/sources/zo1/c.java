package zo1;

import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.container.ListActionEnum;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class c<T> {
    public final ArrayList<T> a;
    public final ArrayList<g<T>> b;

    public final String a() {
        StringBuilder r0 = new StringBuilder("[");
        Iterator<T> r1 = this.a.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r0.append(String.valueOf(r1.next()));
        r0.append(", ");
        goto L4
    L6:
        r0.append("]");
        return r0.toString();
    }

    public c(ArrayList<T> r2, ArrayList<g<T>> r3) {
        Intrinsics.checkNotNullParameter(r2, "dataList");
        Intrinsics.checkNotNullParameter(r3, "listObserver");
        this.a = r2;
        this.b = r3;
    }

    public final boolean b(T r6, ListActionEnum r7) {
        Intrinsics.checkNotNullParameter(r7, "action");
        ArrayList<T> r0 = this.a;
        int r1 = b.a[r7.ordinal()];
        if (r1 != 1) goto L5;
        r0.remove(r6);
        r0.add(r6);
    L14:
        boolean r2 = true;
    L15:
        if (r2 == false) goto L21;
        Iterator<T> r3 = this.b.iterator();
    L18:
        if (r3.hasNext() == false) goto L20;
        ((g) r3.next()).e(r6, r7);
        goto L18
    L20:
        return true;
    L21:
        return false;
    L5:
        if (r1 != 2) goto L7;
        r2 = r0.remove(r6);
        goto L15
    L7:
        if (r1 == 3) goto L10;
    L8:
        r2 = false;
        goto L15
    L10:
        if (r0.remove(r6) == false) goto L8;
        r0.add(r6);
        goto L14
    }
}
