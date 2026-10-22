package cw8;

import android.view.ViewGroup;
import com.larus.business.debug.base.register.EntranceGroup;
import com.larus.business.debug.base.register.EntrancePage;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import zv8.k;
import zv8.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class d extends b implements m {
    public final ViewGroup i;
    public final List<EntranceGroup> j;

    @Override // zv8.m
    public final void b() {
        this.g.y2();
    }

    @Override // cw8.b
    public final void c() {
        super.c();
        k.a.getClass();
        Intrinsics.checkNotNullParameter(this, "listener");
        ArrayList r0 = (ArrayList) k.c;
        if (r0.contains(this) == true) goto L7;
        r0.add(this);
        return;
    }

    @Override // cw8.b
    public final void d() {
        super.d();
        k.a.getClass();
        Intrinsics.checkNotNullParameter(this, "listener");
        ArrayList r0 = (ArrayList) k.c;
        if (r0.contains(this) == false) goto L7;
        r0.remove(this);
        return;
    }

    public d(EntrancePage r2, ViewGroup r3, List<EntranceGroup> r4) {
        Intrinsics.checkNotNullParameter(r2, "page");
        Intrinsics.checkNotNullParameter(r3, "containerView");
        Intrinsics.checkNotNullParameter(r4, "entranceList");
        super(r2, r3, r4);
        this.i = r3;
        this.j = r4;
    }
}
