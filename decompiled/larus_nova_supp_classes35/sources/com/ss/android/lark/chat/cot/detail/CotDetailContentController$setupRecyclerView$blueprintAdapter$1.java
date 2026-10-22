package com.ss.android.lark.chat.cot.detail;

import com.ss.android.lark.chat.cot.detail.blueprint.CotDetailBlueprintAdapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class CotDetailContentController$setupRecyclerView$blueprintAdapter$1 extends FunctionReferenceImpl implements Function1<String, Unit> {
    public CotDetailContentController$setupRecyclerView$blueprintAdapter$1(Object r8) {
        super(1, r8, c.class, "toggleToolCallGroup", "toggleToolCallGroup(Ljava/lang/String;)V", 0);
    }

    public final void invoke(String r6) {
        Intrinsics.checkNotNullParameter(r6, "p0");
        c r0 = (c) ((CallableReference) this).receiver;
        if (r0.c == false) goto L13;
        q r1 = r0.p;
        if (r1 == null) goto L14;
        j r2 = r0.a;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r6, "groupId");
        boolean r3 = !r2.b(r6);
        int r4 = j.b;
        String r7 = r6 + "#group";
        Intrinsics.checkNotNullParameter(r7, "key");
        r2.a.put(r7, Boolean.valueOf(r3));
        r0.r = false;
        CotDetailBlueprintAdapter r8 = r0.j;
        if (r8 == null) goto L12;
        int r5 = p.a;
        List r9 = p.a(r1.b, r0.a);
        i r10 = new i(r0);
        Intrinsics.checkNotNullParameter(r9, "list");
        r8.c.submitList(r9, r10);
        return;
    L12:
        return;
    L14:
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((String) r1);
        return Unit.INSTANCE;
    }
}
