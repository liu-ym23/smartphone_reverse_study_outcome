package com.ss.android.lark.keyboard.edittext2.edittors.anchor.widecharurl;

import android.text.Spannable;
import hob.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d extends com.ss.android.lark.keyboard.edittext2.edittors.anchor.urlinline.b {

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.anchor.urlinline.b, fob.f
    public final List<com.ss.android.lark.keyboard.edittext2.utils.b.a> a(Spannable r4) {
        Intrinsics.checkNotNullParameter(r4, "target");
        ArrayList r0 = new ArrayList();
        com.ss.android.lark.keyboard.edittext2.utils.b.e(r4, r0);
        if (r0.size() != 1) goto L6;
        return r0;
    L6:
        return super.a(r4);
    }

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.anchor.urlinline.b, fob.f
    public final /* bridge */ /* synthetic */ hob.b b(com.ss.android.lark.keyboard.edittext2.utils.b.a r1) {
        return d(r1);
    }

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.anchor.urlinline.b
    public final j d(com.ss.android.lark.keyboard.edittext2.utils.b.a r4) {
        Intrinsics.checkNotNullParameter(r4, "parseInfo");
        if (r4.d == false) goto L7;
        j r0 = new j(r4.a);
        Map<String, Object> r5 = r0.c;
        HashMap r6 = (HashMap) r5;
        r6.put("key::use::wide::character:regex", Boolean.TRUE);
        return r0;
    L7:
        return super.d(r4);
    }

    public d(fob.d<j> r2, eob.a r3) {
        Intrinsics.checkNotNullParameter(r2, "strategy");
        Intrinsics.checkNotNullParameter(r3, "editor");
        super(r2, r3);
    }
}
