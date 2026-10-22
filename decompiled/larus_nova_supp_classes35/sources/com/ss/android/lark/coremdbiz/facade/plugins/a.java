package com.ss.android.lark.coremdbiz.facade.plugins;

import com.ss.android.lark.coremdbiz.facade.bizext.theme.LarkAtThemeData;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import v7b.e0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class a implements com.ss.android.lark.coremd.base.parse.g {

    /* JADX INFO: renamed from: com.ss.android.lark.coremdbiz.facade.plugins.a$a, reason: collision with other inner class name */
    public static final class C0189a {
    }

    static {
    }

    public a() {
    }

    @Override // com.ss.android.lark.coremd.base.parse.g
    public void a(com.ss.android.lark.coremd.impl.parse.l.a r3) {
        Intrinsics.checkNotNullParameter(r3, "builder");
        r3.a(eab.a.class, new c());
    }

    @Override // com.ss.android.lark.coremd.base.parse.g
    public final void b(com.ss.android.lark.coremd.impl.parse.g r2) {
        Intrinsics.checkNotNullParameter(r2, "registry");
    }

    @Override // com.ss.android.lark.coremd.base.parse.g
    public void c(com.ss.android.lark.coremd.impl.parse.j.a r3) {
        Intrinsics.checkNotNullParameter(r3, "builder");
        r3.a(eab.a.class, new b(this));
    }

    @Override // com.ss.android.lark.coremd.base.parse.g
    public final void d(com.ss.android.lark.coremd.impl.parse.c r2) {
        Intrinsics.checkNotNullParameter(r2, "registry");
    }

    public static Object e(com.ss.android.lark.coremd.impl.parse.i r13, LarkAtThemeData r14) {
        Intrinsics.checkNotNullParameter(r13, "<this>");
        Intrinsics.checkNotNullParameter(r14, "themeData");
        eab.a r4 = (eab.a) r13.d;
        Ref.BooleanRef r5 = new Ref.BooleanRef();
        Ref.BooleanRef r6 = new Ref.BooleanRef();
        Ref.BooleanRef r7 = new Ref.BooleanRef();
        Ref.BooleanRef r8 = new Ref.BooleanRef();
        v7b.s r0 = r4.d;
    L3:
        boolean r10 = false;
        if (r0 == null) goto L32;
        if (r5.element == false) goto L8;
    L11:
        boolean r1 = true;
    L12:
        r5.element = r1;
        if (r6.element == false) goto L15;
    L18:
        boolean r2 = true;
    L19:
        r6.element = r2;
        if (r7.element == false) goto L22;
    L25:
        boolean r3 = true;
    L26:
        r7.element = r3;
        if (r8.element == false) goto L29;
    L30:
        r10 = true;
    L31:
        r8.element = r10;
        r0 = r0.i();
        goto L3
    L29:
        if ((r0 instanceof v7b.z) == false) goto L31;
    L22:
        if ((r0 instanceof e0) == true) goto L25;
        r3 = false;
        goto L26
    L15:
        if ((r0 instanceof v7b.f) == true) goto L18;
        r2 = false;
        goto L19
    L8:
        if ((r0 instanceof v7b.a0) == true) goto L11;
        r1 = false;
        goto L12
    L32:
        com.ss.android.lark.coremd.impl.parse.m r9 = r13.c();
        return com.ss.android.lark.coremd.ext.b.a(new d(r13, r14, r4, r5, r6, r7, r8, r9), new Object[]{r9});
    }
}
