package com.ss.android.lark.conditional.access.nopermission.manager;

import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.conditional.access.traffic.InternalSecurityAction;
import com.tencent.qqmusic.third.api.contract.Keys;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class SecurityPolicyToastActionManager {
    public static final CompositeDisposable a = null;
    public static com.larksuite.component.universe_design.toast.c b;

    static {
        a = new CompositeDisposable();
    }

    public static void a(final InternalSecurityAction r3) {
        Intrinsics.checkNotNullParameter(r3, Keys.API_PARAM_KEY_ACTION);
        String r0 = r3.getCurrentAction().getParams().get("displayID");
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type kotlin.String");
        LarkAppContext.Companion.getClass();
        com.ss.android.lark.conditional.access.display.g r1 = (com.ss.android.lark.conditional.access.display.g) e0c.k.a(LarkAppContext.access$getInstance$cp().getContext(), com.ss.android.lark.conditional.access.display.g.class);
        t4c.a.b(t4c.a.a(r1.Ld(r0, qqb.a.d())), a, new SecurityPolicyToastActionManager$handleToastAction$1(r3), SecurityPolicyToastActionManager$handleToastAction$2.INSTANCE);
    }
}
