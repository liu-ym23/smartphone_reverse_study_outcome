package com.ss.android.lark.inline.ai.creationai;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.inline.ai.api.creationai.SubPanelInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class SubPanelManager {
    public static final /* synthetic */ int d = 0;
    public final vlb.a a;
    public final vlb.b b;
    public final List<Pair<String, g0>> c;

    public static final class a {
    }

    static {
    }

    public static boolean c(SubPanelManager r0) {
        if (((ArrayList) r0.c).size() > 0) goto L5;
        return false;
    L5:
        return true;
    }

    public final void a(String r4) {
        Intrinsics.checkNotNullParameter(r4, "tag");
        Iterator r0 = ((ArrayList) this.c).iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        if (Intrinsics.areEqual(((Pair) r1).getFirst(), r4) == false) goto L4;
    L9:
        Pair r2 = (Pair) r1;
        if (r2 == null) goto L14;
        g0 r5 = (g0) r2.getSecond();
        if (r5 == null) goto L14;
        g0.c(r5, 2);
    L14:
        TypeIntrinsics.asMutableCollection(this.c).remove(r2);
        return;
    L8:
        r1 = null;
        goto L9
    }

    public final void b(boolean r5) {
        if (r5 == false) goto L13;
        if (((ArrayList) this.c).size() != 2) goto L7;
        g0.c((g0) ((Pair) ListProtector.get(this.c, 0)).getSecond(), 2);
        g0.c((g0) ((Pair) ListProtector.get(this.c, 1)).getSecond(), 3);
    L11:
        ((ArrayList) this.c).clear();
        return;
    L7:
        Iterator r6 = ((ArrayList) this.c).iterator();
    L9:
        if (r6.hasNext() == false) goto L11;
        g0.c((g0) ((Pair) r6.next()).getSecond(), 3);
        goto L9
    L13:
        if (((ArrayList) this.c).size() <= 0) goto L23;
        Pair r7 = (Pair) CollectionsKt.lastOrNull(this.c);
        if (r7 == null) goto L19;
        g0 r8 = (g0) r7.getSecond();
        if (r8 == null) goto L19;
        g0.c(r8, 3);
    L19:
        List<Pair<String, g0>> r9 = this.c;
        ListProtector.remove(r9, ((ArrayList) r9).size() - 1);
        return;
    }

    public SubPanelManager(vlb.a r2, vlb.b r3) {
        Intrinsics.checkNotNullParameter(r2, "config");
        Intrinsics.checkNotNullParameter(r3, "callback");
        this.a = r2;
        this.b = r3;
        this.c = new ArrayList();
    }

    public final void d(SubPanelInfo r6, String r7) {
        Intrinsics.checkNotNullParameter(r7, "tag");
        final Ref.ObjectRef r0 = new Ref.ObjectRef();
        Iterator r1 = ((ArrayList) this.c).iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        Object r2 = r1.next();
        if (Intrinsics.areEqual(((Pair) r2).getFirst(), r7) == false) goto L4;
    L9:
        r0.element = r2;
        if (r2 != null) goto L12;
        Pair r3 = new Pair(r7, new g0(this.a, this.b, r7));
        r0.element = r3;
        g0 r4 = (g0) r3.getSecond();
        r4.r = new SubPanelManager$show$1(this, r0);
        ((g0) ((Pair) r0.element).getSecond()).d(r6, Intrinsics.areEqual(r7, "history_panel"));
        List<Pair<String, g0>> r8 = this.c;
        ArrayList r9 = (ArrayList) r8;
        r9.add(r0.element);
        return;
    L12:
        g0 r10 = (g0) ((Pair) r2).getSecond();
        int r5 = g0.t;
        r10.d(r6, false);
        return;
    L8:
        r2 = null;
        goto L9
    }
}
