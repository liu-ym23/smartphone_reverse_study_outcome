package com.ss.android.lark.keyboard.edittext2.edittors.anchor.urlinline;

import android.text.Spannable;
import fob.f;
import hob.j;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class b extends f<j> {
    @Override // fob.f
    public List<com.ss.android.lark.keyboard.edittext2.utils.b.a> a(Spannable r2) {
        Intrinsics.checkNotNullParameter(r2, "target");
        ArrayList r0 = new ArrayList();
        com.ss.android.lark.keyboard.edittext2.utils.b.a(r2, r0);
        return r0;
    }

    @Override // fob.f
    public /* bridge */ /* synthetic */ hob.b b(com.ss.android.lark.keyboard.edittext2.utils.b.a r1) {
        return d(r1);
    }

    public j d(com.ss.android.lark.keyboard.edittext2.utils.b.a r2) {
        Intrinsics.checkNotNullParameter(r2, "parseInfo");
        return new j(r2.a);
    }

    public b(fob.d<j> r2, eob.a r3) {
        Intrinsics.checkNotNullParameter(r2, "strategy");
        Intrinsics.checkNotNullParameter(r3, "editor");
        super(r2, r3);
    }
}
