package com.ss.android.lark.keyboard.edittext2.edittors.anchor.v2;

import android.text.Spannable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class m extends com.ss.android.lark.keyboard.edittext2.edittors.anchor.urlinline.b {
    @Override // com.ss.android.lark.keyboard.edittext2.edittors.anchor.urlinline.b, fob.f
    public final List<com.ss.android.lark.keyboard.edittext2.utils.b.a> a(Spannable r4) {
        Intrinsics.checkNotNullParameter(r4, "target");
        ArrayList r0 = new ArrayList();
        com.ss.android.lark.keyboard.edittext2.utils.b.e(r4, r0);
        if (r0.size() == 1) goto L7;
        ArrayList r1 = new ArrayList();
        com.ss.android.lark.keyboard.edittext2.utils.b.b(r4, r1);
        return r1;
    L7:
        return r0;
    }

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.anchor.urlinline.b, fob.f
    public final /* bridge */ /* synthetic */ hob.b b(com.ss.android.lark.keyboard.edittext2.utils.b.a r1) {
        return d(r1);
    }

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.anchor.urlinline.b
    public final hob.j d(com.ss.android.lark.keyboard.edittext2.utils.b.a r4) {
        Intrinsics.checkNotNullParameter(r4, "parseInfo");
        if (r4.d == false) goto L7;
        hob.j r0 = new hob.j(r4.a);
        Map<String, Object> r5 = r0.c;
        HashMap r6 = (HashMap) r5;
        r6.put("key::use::wide::character:regex", Boolean.TRUE);
        return r0;
    L7:
        return super.d(r4);
    }

    public m(fob.d<hob.j> r2, eob.a r3) {
        Intrinsics.checkNotNullParameter(r2, "strategy");
        Intrinsics.checkNotNullParameter(r3, "editor");
        super(r2, r3);
    }
}
