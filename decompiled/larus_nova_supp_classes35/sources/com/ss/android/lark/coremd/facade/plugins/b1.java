package com.ss.android.lark.coremd.facade.plugins;

import android.content.Context;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.coremd.base.theme.HeadingThemeData;
import com.ss.android.lark.coremd.base.theme.ListThemeData;
import kotlin.jvm.internal.Intrinsics;
import v7b.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b1<T extends v7b.s> implements com.ss.android.lark.coremd.base.parse.q {
    public final /* synthetic */ f1 a;

    public b1(f1 r1) {
        this.a = r1;
    }

    @Override // com.ss.android.lark.coremd.base.parse.q
    public final Object a(com.ss.android.lark.coremd.impl.parse.i r9) {
        Intrinsics.checkNotNullParameter(r9, "it");
        T r0 = r9.d;
        v7b.a r1 = (v7b.a) ((v7b.q) r0).d;
        if ((r1 instanceof v7b.u) == false) goto L9;
        f1 r2 = this.a;
        v7b.u r3 = (v7b.u) r1;
        v7b.q r4 = (v7b.q) r0;
        Context r5 = r9.getContext();
        com.ss.android.lark.coremd.base.parse.j r10 = r9.getTheme();
        r2.getClass();
        int r6 = com.ss.android.lark.coremd.utils.d.b(r3, r4);
        com.ss.android.lark.coremd.base.parse.k.a r7 = com.ss.android.lark.coremd.base.parse.k.b;
        HeadingThemeData r8 = r7.e(r10);
        ListThemeData r11 = r7.c(r10);
        int r12 = com.ss.android.lark.coremd.utils.d.a(r3);
        int r13 = com.ss.android.lark.coremd.utils.a.a;
        int r14 = com.ss.android.lark.coremd.utils.a.a(r5, r11.h(), r12);
        int r15 = r2.f(r4);
        float r16 = UIUtils.sp2px(r5, r11.j());
        if (r15 <= 0) goto L7;
        r16 = r16 * ((Number) ListProtector.get(r8.h(), r15 - 1)).floatValue();
    L7:
        y9b.b r17 = new y9b.b();
        r17.f(r12);
        r17.h(r6);
        r17.a.j = r16;
        r17.a.g = UIUtils.getColor(r5, r11.i());
        r17.a.e = com.ss.android.lark.coremd.utils.a.c(r5, r17, r11.k());
        r17.a.c = com.ss.android.lark.coremd.utils.a.b(r5, r17) + r14;
        r17.a.d = com.ss.android.lark.coremd.utils.a.d(r17);
        return r17;
    L9:
        if ((r1 instanceof v7b.c) == false) goto L14;
        f1 r18 = this.a;
        Context r19 = r9.getContext();
        com.ss.android.lark.coremd.base.parse.j r20 = r9.getTheme();
        r18.getClass();
        int r21 = com.ss.android.lark.coremd.utils.d.a((v7b.c) r1);
        com.ss.android.lark.coremd.base.parse.k.a r22 = com.ss.android.lark.coremd.base.parse.k.b;
        ListThemeData r23 = r22.c(r20);
        int r24 = com.ss.android.lark.coremd.utils.a.a;
        int r25 = com.ss.android.lark.coremd.utils.a.a(r19, r23.h(), r21);
        float r26 = UIUtils.sp2px(r19, r23.j());
        int r27 = r18.f((v7b.q) r0);
        HeadingThemeData r28 = r22.e(r20);
        if (r27 <= 0) goto L13;
        r26 = r26 * ((Number) ListProtector.get(r28.h(), r27 - 1)).floatValue();
    L13:
        y9b.c r29 = new y9b.c();
        r29.f(r21);
        r29.a.j = r26;
        r29.a.g = UIUtils.getColor(r19, r23.i());
        r29.a.e = com.ss.android.lark.coremd.utils.a.c(r19, r29, r23.k());
        r29.a.c = com.ss.android.lark.coremd.utils.a.b(r19, r29) + r25;
        r29.a.d = com.ss.android.lark.coremd.utils.a.d(r29);
        return r29;
    L14:
        return null;
    }
}
