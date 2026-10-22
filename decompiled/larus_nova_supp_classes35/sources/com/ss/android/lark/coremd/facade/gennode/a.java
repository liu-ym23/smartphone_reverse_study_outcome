package com.ss.android.lark.coremd.facade.gennode;

import com.ss.android.lark.coremd.base.buildnode.NodeDisplayType;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import v7b.a0;
import v7b.c;
import v7b.e0;
import v7b.f;
import v7b.g;
import v7b.i;
import v7b.l;
import v7b.q;
import v7b.s;
import v7b.u;
import v7b.v;
import v7b.z;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a implements u9b.b {
    public static final Set<Class<? extends s>> d = null;
    public static final Set<Class<? extends s>> e = null;
    public static final Set<Class<? extends s>> f = null;
    public final Set<Class<? extends s>> a;
    public final Set<Class<? extends s>> b;
    public final Set<Class<? extends s>> c;

    /* JADX INFO: renamed from: com.ss.android.lark.coremd.facade.gennode.a$a, reason: collision with other inner class name */
    public static final class C0180a {
    }

    static {
        d = SetsKt.setOf(new Class[]{q.class, v.class, v7b.b.class, u.class, c.class, i.class});
        e = SetsKt.setOf(new Class[]{f.class, a0.class, e0.class, z.class});
        f = SetsKt.setOf(new Class[]{g.class, l.class});
    }

    public a(int r4) {
        Set<Class<? extends s>> r5 = d;
        Set<Class<? extends s>> r0 = e;
        Set<Class<? extends s>> r1 = f;
        Intrinsics.checkNotNullParameter(r5, "blockType");
        Intrinsics.checkNotNullParameter(r0, "inlineBlockType");
        Intrinsics.checkNotNullParameter(r1, "nonContainerBlock");
        this.a = r5;
        this.b = r0;
        this.c = r1;
    }

    @Override // u9b.b
    public final NodeDisplayType a(s r2) {
        Intrinsics.checkNotNullParameter(r2, "node");
        Class<?> r3 = r2.getClass();
        if (this.a.contains(r3) == false) goto L6;
        return NodeDisplayType.Block;
    L6:
        if (this.b.contains(r3) == false) goto L9;
        return NodeDisplayType.InlineBlock;
    L9:
        if (this.c.contains(r3) == false) goto L12;
        return NodeDisplayType.NonContainerBlock;
    L12:
        return NodeDisplayType.Inline;
    }
}
