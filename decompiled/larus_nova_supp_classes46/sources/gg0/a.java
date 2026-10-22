package gg0;

import com.bytedance.android.live.liveinteract.plantform.commonwindow.diffutils.DifferNotFoundException;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public final List<Class<?>> a;
    public final List<b<?>> b;

    public a() {
        this.a = new ArrayList();
        this.b = new ArrayList();
    }

    public final b a(tf0.e r5) {
        Class<?> r0 = r5.getClass();
        int r1 = ((ArrayList) this.a).indexOf(r0);
        if (r1 != (-1)) goto L13;
        r1 = 0;
    L7:
        if (r1 >= ((ArrayList) this.a).size()) goto L12;
        if (((Class) ListProtector.get(this.a, r1)).isAssignableFrom(r0) == true) goto L13;
        r1 = r1 + 1;
        goto L7
    L12:
        r1 = -1;
    L13:
        if (r1 == (-1)) goto L17;
        return (b) ListProtector.get(this.b, r1);
    L17:
        throw new DifferNotFoundException(r5.getClass());
    }

    public final <T extends tf0.e> void b(Class<? extends T> r4, b<T> r5) {
        boolean r0 = false;
    L3:
        int r1 = ((ArrayList) this.a).indexOf(r4);
        if (r1 == (-1)) goto L6;
        ListProtector.remove(this.a, r1);
        ListProtector.remove(this.b, r1);
        r0 = true;
        goto L3
    L6:
        if (r0 == true) goto L8;
    L8:
        ((ArrayList) this.a).add(r4);
        ((ArrayList) this.b).add(r5);
    }
}
