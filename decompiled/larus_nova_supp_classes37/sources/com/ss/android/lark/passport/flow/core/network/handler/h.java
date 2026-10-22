package com.ss.android.lark.passport.flow.core.network.handler;

import android.content.Context;
import com.ss.android.lark.passport.signinsdk_api.base.NetworkErrorResult;
import com.ss.android.lark.utils.LarkContext;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class h {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean b(Context r1, NetworkErrorResult r2) {
        if (((yzb.b) LarkContext.spiByDwarf(yzb.b.class)).isLogin() == false) goto L6;
        return a(r1, r2, Boolean.FALSE);
    L6:
        return a(r1, r2, Boolean.TRUE);
    }

    public static boolean a(Context r4, NetworkErrorResult r5, Boolean r6) {
        if (r5 == null) goto L30;
        if (r4 == null) goto L44;
        int r0 = r5.getErrorCode();
        ArrayList r1 = new ArrayList();
        int r2 = f.a;
        ArrayList r3 = new ArrayList();
        r3.add(new d());
        r3.add(b.a);
        r1.addAll(r3);
        if (r6 != null) goto L8;
    L10:
        Iterator r7 = r1.iterator();
    L12:
        if (r7.hasNext() == false) goto L20;
        Integer r8 = c.a((e) r7.next());
        if (r8 == null) goto L12;
        if (r0 != r8.intValue()) goto L12;
        return true;
    L20:
        ArrayList r9 = new ArrayList();
        int r10 = f.a;
        ArrayList r11 = new ArrayList();
        r11.add(new AlertCodeHandler());
        r9.addAll(r11);
        Iterator r12 = r9.iterator();
    L22:
        if (r12.hasNext() == false) goto L45;
        e r13 = (e) r12.next();
        Integer r14 = c.a(r13);
        if (r14 == null) goto L22;
        if (r0 != r14.intValue()) goto L22;
        return r13.a(r4, r5);
    L45:
        return false;
    L8:
        if (r6.booleanValue() == false) goto L10;
        ArrayList r15 = new ArrayList();
        r15.add(new a());
        r1.addAll(r15);
        goto L10
    L44:
        return false;
    L30:
        return false;
    }
}
