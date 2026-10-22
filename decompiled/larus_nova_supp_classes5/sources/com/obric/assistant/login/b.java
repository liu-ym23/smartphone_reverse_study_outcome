package com.obric.assistant.login;

import com.larus.account.base.api.IMultiAccountService;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.onelogin.c0;
import com.obric.assistant.onelogin.u;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class b implements t {
    public b() {
    }

    public final boolean a(ObricLoginType r2) {
        Intrinsics.checkNotNullParameter(r2, EffectConfiguration.KEY_TYPE);
        if (r2 != ObricLoginType.LARK_ENTERPRISE) goto L5;
        return true;
    L5:
        return false;
    }

    public final void b(String r11) {
        Intrinsics.checkNotNullParameter(r11, "businessScene");
        u.d.getClass();
        u r0 = u.e;
        g r1 = u.a.b();
        if (r0.b.a == true) goto L6;
        FLogger.a.i("ObricLoginConsistencyStrategy", "EnterpriseAccountConsistencyStrategy assistant no login, ignore consistency check");
        return;
    L6:
        List r2 = IMultiAccountService.a.g();
        ArrayList r3 = new ArrayList();
        Iterator r4 = r2.iterator();
    L7:
        boolean r5 = true;
        if (r4.hasNext() == false) goto L23;
        q38.b r6 = (q38.b) r4.next();
        u.d.getClass();
        String r7 = r6.g();
        a r8 = null;
        if (r7 != null) goto L12;
    L21:
        if (r8 == null) goto L7;
        r3.add(r8);
        goto L7
    L12:
        if (r7.length() > 0) goto L15;
        r5 = false;
    L15:
        if (r5 == true) goto L18;
        r7 = null;
    L18:
        if (r7 == null) goto L21;
        r8 = new a(r6.d(), r7, r6.l());
        goto L21
    L23:
        ArrayList r9 = new ArrayList();
        Iterator r10 = r3.iterator();
    L25:
        if (r10.hasNext() == false) goto L34;
        Object r12 = r10.next();
        a r13 = (a) r12;
        if (r13.a == true) goto L29;
    L31:
        boolean r14 = false;
    L32:
        if (r14 == false) goto L25;
        r9.add(r12);
        goto L25
    L29:
        if (r13.c == true) goto L31;
        r14 = true;
        goto L32
    L34:
        HashSet r15 = new HashSet();
        ArrayList r16 = new ArrayList();
        Iterator r17 = r9.iterator();
    L36:
        if (r17.hasNext() == false) goto L40;
        Object r18 = r17.next();
        if (r15.add(((a) r18).b) == false) goto L36;
        r16.add(r18);
        goto L36
    L40:
        String r19 = r1.b;
        if (r19 != null) goto L43;
    L46:
        boolean r20 = true;
    L47:
        if (r20 == false) goto L49;
    L61:
        if (r5 == true) goto L64;
        FLogger.a.i("ObricLoginConsistencyStrategy", "EnterpriseAccountConsistencyStrategy account same, no need recover");
        return;
    L64:
        FLogger.a.i("ObricLoginConsistencyStrategy", "EnterpriseAccountConsistencyStrategy account inconsistent, logout assistant");
        c0.b(false, r11, new u());
        return;
    L49:
        if (r16.isEmpty() == true) goto L57;
        Iterator r21 = r16.iterator();
    L53:
        if (r21.hasNext() == false) goto L57;
        if (Intrinsics.areEqual(((a) r21.next()).b, r1.b) == false) goto L53;
        boolean r22 = false;
    L58:
        if (r22 == true) goto L61;
        r5 = false;
    L57:
        r22 = true;
        goto L58
    L43:
        if (r19.length() == 0) goto L46;
        r20 = false;
        goto L47
    }
}
