package com.larus.search.impl;

import androidx.fragment.app.Fragment;
import com.larus.platform.service.i2;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class c0 implements com.larus.common_ui.dialog.p0 {
    public final /* synthetic */ Fragment a;
    public final /* synthetic */ String b;
    public final /* synthetic */ a0 c;
    public final /* synthetic */ String d;
    public final /* synthetic */ Function0<Unit> e;
    public final /* synthetic */ Function0<Unit> f;

    public final void confirm() {
        i2 r0 = i2.b;
        Fragment r1 = this.a;
        List r2 = CollectionsKt.listOf(this.b);
        final a0 r3 = this.c;
        final String r4 = this.d;
        final Function0<Unit> r5 = this.e;
        final Function0<Unit> r6 = this.f;
        i2.q(r1, r2, new b0(r3, r4, r5, r6));
    }

    public c0(WebFragment r1, a0 r2, String r3, z r4, y r5) {
        this.a = r1;
        this.b = "android.permission.READ_EXTERNAL_STORAGE";
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.f = r5;
    }
}
