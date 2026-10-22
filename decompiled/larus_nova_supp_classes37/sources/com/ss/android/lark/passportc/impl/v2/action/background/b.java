package com.ss.android.lark.passportc.impl.v2.action.background;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.passportc.api.f;
import com.ss.android.lark.passportc.entity.UserState;
import com.ss.android.lark.passportc.impl.v2.action.h;
import com.ss.android.lark.passportc.impl.v2.entity.UpdateUserContext;
import com.ss.android.lark.passportc.impl.v2.state.UserStateModel;
import com.ss.android.lark.passportc.internal.t;
import com.ss.android.lark.passportc.task.i;
import f0c.d;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b extends h<e0c.a> {
    public final f f;

    @Override // i0c.b
    public final h0c.b a(UpdateUserContext r8, Object r9, Object r10) {
        UserState r11 = (UserState) r9;
        UserState r12 = (UserState) r10;
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r11, "from");
        Intrinsics.checkNotNullParameter(r12, "to");
        User r0 = r8.c;
        if (r8.j != null) goto L33;
        UserStateModel r13 = r8.b;
        String r14 = r0.userId;
        Iterator r15 = ((Iterable) r13.b(OfflineBackgroundAction$isForegroundOnline$1.INSTANCE)).iterator();
    L5:
        boolean r1 = false;
        if (r15.hasNext() == false) goto L17;
        Object r16 = r15.next();
        d r3 = (d) r16;
        if (Intrinsics.areEqual(r3.b, r14) == true) goto L10;
    L14:
        boolean r4 = false;
    L15:
        if (r4 == false) goto L5;
    L18:
        if (r16 == null) goto L21;
        r1 = true;
    L21:
        if (r1 == false) goto L34;
        Log.w("ComponentTask", "background offline transfer skip , targetUser" + r0.userId + " already foreground online");
        j0c.a r17 = i.a;
    L29:
        if (r17.a == false) goto L31;
        int r18 = h0c.b.b;
        return new h0c.b.c(r17);
    L31:
        int r19 = h0c.b.b;
        return new h0c.b.C0143b(r17);
    L34:
        Boolean r20 = (Boolean) this.f.a(r0.userId).blockingFirst();     // Catch: NoSuchElementException -> L25
    L27:
        String r5 = "background offline transfer end result = " + r20 + " , targetUser" + r0.userId + " session is null";
        Log.i("ComponentTask", r5);
        Intrinsics.checkNotNull(r20);
        r17 = new j0c.a(r20.booleanValue(), r5, null, null, 28);
    L25:
        e = move-exception;
        Log.e("ComponentTask", "background offline transfer error makeUserBackgroundOffline error :" + e.getMessage() + ", userId = " + r0.userId);
        r20 = Boolean.FALSE;
        goto L27
    L10:
        if (r3.c.a != UserState.ONLINE) goto L14;
        if (r3.d == false) goto L14;
        r4 = true;
        goto L15
    L17:
        r16 = null;
        goto L18
    L33:
        return super.b(r8, r11, r12);
    }

    public b(f r8, com.ss.android.lark.passportc.impl.v2.action.a r9, l0c.d r10, t r11, l0c.c r12) {
        Intrinsics.checkNotNullParameter(r8, "backgroundUserService");
        Intrinsics.checkNotNullParameter(r9, "backgroundComponentDelegate");
        Intrinsics.checkNotNullParameter(r10, "taskMonitor");
        Intrinsics.checkNotNullParameter(r11, "executors");
        Intrinsics.checkNotNullParameter(r12, "userFlowMonitor");
        super(r9, r10, r11, r12, false);
        this.f = r8;
    }
}
