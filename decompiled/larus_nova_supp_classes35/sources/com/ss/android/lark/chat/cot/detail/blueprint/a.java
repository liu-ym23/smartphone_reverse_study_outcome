package com.ss.android.lark.chat.cot.detail.blueprint;

import android.content.Context;
import com.ss.android.lark.blueprint.f;
import com.ss.android.lark.chat.cot.detail.j;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static CotDetailBlueprintAdapter a(Context r3, final j r4, final com.ss.android.lark.chat.cot.a r5, final boolean r6, final Function1 r7, final Function0 r8) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "expandStore");
        Intrinsics.checkNotNullParameter(r5, "cotFeatureGate");
        Intrinsics.checkNotNullParameter(r7, "onGroupToggle");
        Intrinsics.checkNotNullParameter(r8, "onToolCallToggle");
        com.ss.android.lark.blueprint.d.a r0 = new com.ss.android.lark.blueprint.d.a(r3);
        c r9 = new c();
        Intrinsics.checkNotNullParameter(r9, "cellMapper");
        Intrinsics.checkNotNullParameter(r9, "<set-?>");
        r0.e = r9;
        com.ss.android.lark.blueprint.e r10 = new com.ss.android.lark.blueprint.e(f.class);
        Intrinsics.checkNotNullParameter(r10, "cellFactory");
        vza.e r2 = r0.b;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r10, "cellFactory");
        r2.a.put(r10.b(), r10);
        r0.b(new d.b(r6));
        r0.a(b.a, new CotDetailBlueprintFactory$createBlueprint$builder$1(r5));
        r0.a(b.c, new CotDetailBlueprintFactory$createBlueprint$builder$2(r4, r5, r6, r8));
        r0.a(b.d, new CotDetailBlueprintFactory$createBlueprint$builder$3(r5));
        r0.a(b.e, new CotDetailBlueprintFactory$createBlueprint$builder$4(r6));
        if (r6 == false) goto L6;
        r0.a(b.b, new CotDetailBlueprintFactory$createBlueprint$1(r7));
    L6:
        return new CotDetailBlueprintAdapter(new com.ss.android.lark.blueprint.d(r0));
    }
}
