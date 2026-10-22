package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class o0 extends com.bytedance.android.livesdk.user.h<Boolean> {
    public final /* synthetic */ m0 a;
    public final /* synthetic */ ArrayList b;
    public final /* synthetic */ Ref.ObjectRef c;
    public final /* synthetic */ long d;

    public final void onSuccess(Object r8) {
        ((Boolean) r8).booleanValue();
        ArrayList r9 = this.b;
        if (r9 == null) goto L5;
        r9.remove((sz1.a) this.c.element);
    L5:
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.f r10 = this.a.d;
        long r0 = this.d;
        sz1.a r2 = (sz1.a) this.c.element;
        r10.getClass();
        Intrinsics.checkNotNullParameter(r2, "targetCard");
        if (r10.a.get(String.valueOf(r0)) == null) goto L35;
        ArrayList<sz1.a> r11 = r10.a.get(String.valueOf(r0));
        if (r11 == null) goto L10;
        int r1 = r11.size();
    L11:
        int r3 = 0;
    L13:
        if (r3 >= r1) goto L22;
        if (r11 == null) goto L16;
        sz1.a r5 = (sz1.a) ListProtector.get(r11, r3);
    L17:
        if (r5 == null) goto L21;
        if (gz1.b.c(r5, r2) != true) goto L21;
    L23:
        if (r3 == (-1)) goto L28;
        if (r11 == null) goto L26;
        sz1.a r4 = (sz1.a) ListProtector.remove(r11, r3);
    L26:
        if (r11 == null) goto L36;
        ListProtector.add(r11, 0, r2);
        return;
    L36:
        return;
    L28:
        if (r11 == null) goto L38;
        r11.add(r2);
        return;
    L38:
        return;
    L21:
        r3 = r3 + 1;
        goto L13
    L16:
        r5 = null;
        goto L17
    L22:
        r3 = -1;
        goto L23
    L10:
        r1 = 0;
        goto L11
    }

    public o0(m0 r1, ArrayList r2, Ref.ObjectRef r3, long r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
