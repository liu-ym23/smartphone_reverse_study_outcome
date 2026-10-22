package com.ss.android.lark.passportc.convention;

import android.content.Intent;
import android.os.Bundle;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.entity.UserState;
import f0c.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Singleton
public final class c implements a {
    public final j a;

    @Override // com.ss.android.lark.passportc.convention.a
    public final UserSession b() {
        UserSession r0 = this.a.b();
        if (r0 == null) goto L5;
        return r0;
    L5:
        return ContainerConstsKt.a();
    }

    @Inject
    public c(j r2) {
        Intrinsics.checkNotNullParameter(r2, "passport");
        this.a = r2;
    }

    @Override // com.ss.android.lark.passportc.convention.a
    public final void a(Intent r2) {
        Intrinsics.checkNotNullParameter(r2, "intent");
        UserSession r0 = this.a.b();
        if (r0 != null) goto L5;
        r0 = ContainerConstsKt.a();
    L5:
        PassportcConvention.g(r2, r0);
    }

    @Override // com.ss.android.lark.passportc.convention.a
    public final UserSession c(String r6) {
        Intrinsics.checkNotNullParameter(r6, "userId");
        List<f0c.b> r0 = this.a.a();
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L3:
        String r3 = null;
        if (r2.hasNext() == false) goto L13;
        Object r4 = r2.next();
        g r5 = ((f0c.b) r4).a();
        if (r5 == null) goto L11;
        UserSession r7 = r5.b;
        if (r7 == null) goto L11;
        r3 = r7.b;
    L11:
        if (Intrinsics.areEqual(r3, r6) == false) goto L3;
        r1.add(r4);
        goto L3
    L13:
        Iterator r8 = r1.iterator();
    L15:
        if (r8.hasNext() == false) goto L22;
        Object r9 = r8.next();
        if (((f0c.b) r9).b.a != UserState.ONLINE) goto L19;
        boolean r10 = true;
    L20:
        if (r10 == false) goto L15;
    L23:
        f0c.b r11 = (f0c.b) r9;
        if (r11 != null) goto L26;
        r11 = (f0c.b) CollectionsKt.firstOrNull(r1);
    L26:
        if (r11 == null) goto L41;
        g r12 = r11.a();
        if (r12 != null) goto L30;
        return null;
    L30:
        return r12.b;
    L41:
        return null;
    L19:
        r10 = false;
        goto L20
    L22:
        r9 = null;
        goto L23
    }

    @Override // com.ss.android.lark.passportc.convention.a
    public final void d(Bundle r2) {
        Intrinsics.checkNotNullParameter(r2, "bundle");
        UserSession r0 = this.a.b();
        if (r0 != null) goto L5;
        r0 = ContainerConstsKt.a();
    L5:
        PassportcConvention.h(r2, r0);
    }
}
