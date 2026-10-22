package com.ss.android.lark.forseti.chain;

import com.ss.android.lark.forseti.node.ForsetiNode;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class r {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static com.ss.android.lark.forseti.global.d a(ForsetiChainFragment r5) {
        Intrinsics.checkNotNullParameter(r5, "originForsetiStructure");
        final ArrayList r0 = new ArrayList();
        final Ref.ObjectRef r1 = new Ref.ObjectRef();
        Function1<ForsetiNode, Unit> r2 = new ForsetiChainStructureTransformer$transformToForsetiStructure$1(r0, r1);
        ForsetiNode r4 = null;
        ForsetiChainHelper r6 = null;
        if (r5.V90(r5.k) == false) goto L9;
        ForsetiChainHelper r7 = r5.j;
        if (r7 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("chainHelper");
    L8:
        r4 = r6.g.e;
        goto L9
    L7:
        r6 = r7;
    L9:
        if (r4 == null) goto L12;
        r2.invoke(r4);
        r4 = r4.e;
        goto L9
    L12:
        return new com.ss.android.lark.forseti.global.d(CollectionsKt.toList(r0), (yua.c) r1.element);
    }
}
