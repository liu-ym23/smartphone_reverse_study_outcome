package cw8;

import android.view.ViewGroup;
import com.larus.business.debug.base.register.EntranceGroup;
import com.larus.business.debug.base.register.EntrancePage;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import zv8.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a extends b implements aw8.d {
    public final ViewGroup i;
    public final List<EntranceGroup> j;

    @Override // cw8.b
    public final void c() {
        super.c();
        List<Map<EntranceGroup, LinkedList<e>>> r0 = aw8.c.a;
        Intrinsics.checkNotNullParameter(this, "listener");
        ArrayList r1 = (ArrayList) aw8.c.b;
        if (r1.contains(this) == true) goto L7;
        r1.add(this);
        return;
    }

    @Override // cw8.b
    public final void d() {
        super.d();
        List<Map<EntranceGroup, LinkedList<e>>> r0 = aw8.c.a;
        Intrinsics.checkNotNullParameter(this, "listener");
        ArrayList r1 = (ArrayList) aw8.c.b;
        if (r1.contains(this) == false) goto L6;
        r1.remove(this);
        return;
    }

    @Override // aw8.d
    public final void a(boolean r1) {
        if (r1 == false) goto L5;
        this.g.y2();
        return;
    }

    public a(EntrancePage r2, ViewGroup r3, List<EntranceGroup> r4) {
        Intrinsics.checkNotNullParameter(r2, "page");
        Intrinsics.checkNotNullParameter(r3, "containerView");
        Intrinsics.checkNotNullParameter(r4, "entranceList");
        super(r2, r3, r4);
        this.i = r3;
        this.j = r4;
    }
}
