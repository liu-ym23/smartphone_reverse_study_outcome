package com.bytedance.android.live.revlink.impl.jsb;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.browser.jsbridge.base.SetTeamTaskRunningResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import java.lang.reflect.Type;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.TypesJVMKt;
import w20.pe;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e0 extends wy0.b<pe, SetTeamTaskRunningResultModel> {
    public final Type a;
    public final com.bytedance.android.live.revlink.impl.global.c b;

    @Override // wy0.b
    public final Type k() {
        return this.a;
    }

    public e0(com.bytedance.android.live.revlink.impl.global.c r1) {
        this.b = r1;
        this.a = TypesJVMKt.getJavaType(Reflection.typeOf(pe.class));
    }

    @Override // wy0.b
    public final void l(vh7.j r2, CallContext r3) {
        pe r4 = (pe) r2;
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r3, "callContext");
        jy0.b.d("SetTeamTaskRunningMethod", "params: " + r4.d6() + ' ' + r4.H0());
        boolean r5 = r4.d6();
        com.bytedance.android.live.revlink.impl.global.c r6 = this.b;
        com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c r0 = null;
        if (r6 == null) goto L5;
        com.bytedance.android.live.revlink.impl.pk.utils.q r7 = r6.getPkUtils();
    L6:
        if (r7 == null) goto L8;
        r0 = r7.g();
    L8:
        if (r0 == null) goto L13;
        MutableLiveData<Boolean> r8 = r0.getPkLynxInfoIsShowing();
        if (r8 == null) goto L14;
        r8.postValue(Boolean.valueOf(r5));
        return;
    L14:
        return;
    L13:
        return;
    L5:
        r7 = null;
        goto L6
    }
}
