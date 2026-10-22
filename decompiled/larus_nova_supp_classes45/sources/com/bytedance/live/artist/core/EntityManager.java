package com.bytedance.live.artist.core;

import com.bytedance.live.artist.render.EntityState;
import com.bytedance.live.artist.render.RenderEntity;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class EntityManager implements com.bytedance.live.artist.render.a {
    public final com.bytedance.live.artist.utils.a<RenderEntity> a;
    public final Set<RenderEntity> b;
    public final Function0<RenderEntity> c;
    public final b d;

    public final void b() {
        if (this.b.isEmpty() == false) goto L5;
        return;
    L5:
        Iterator<RenderEntity> r0 = this.b.iterator();
    L7:
        if (r0.hasNext() == false) goto L19;
        final RenderEntity r1 = r0.next();
        com.bytedance.live.artist.utils.a<RenderEntity> r2 = this.a;
        Function1<RenderEntity, Unit> r3 = new EntityManager$clearDestroyEntities$1(r1);
        r2.getClass();
        Unit r4 = (Unit) r3.invoke(r1);
        int r5 = r2.b;
        boolean r6 = false;
        int r7 = 0;
    L9:
        if (r7 >= r5) goto L14;
        if (r2.a[r7] == r1) goto L12;
        r7 = r7 + 1;
        goto L9
    L12:
        r6 = true;
    L14:
        if (r6 == true) goto L7;
        int r8 = r2.b;
        Object[] r9 = r2.a;
        if (r8 >= r9.length) goto L7;
        r9[r8] = r1;
        r2.b = r8 + 1;
        goto L7
    L19:
        this.b.clear();
    }

    public EntityManager(b r1) {
        this.d = r1;
        this.a = new com.bytedance.live.artist.utils.a();
        this.b = new LinkedHashSet();
        this.c = new EntityManager$entityCreate$1(this);
    }

    @Override // com.bytedance.live.artist.render.a
    public final void a(RenderEntity r2, EntityState r3) {
        if (r3 != EntityState.WaitDestroy) goto L6;
        this.b.add(r2);
        return;
    }
}
