package com.ss.android.lark.contact.base.contact_mobile_invite.invite;

import com.ss.android.lark.contact.base.statistics.InvHitPoint;
import com.ss.android.lark.utils.ApiUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c<T> implements ApiUtils.a {
    public static final c<T> a = null;

    static {
        a = new c();
    }

    public c() {
    }

    public final void consume(Object r1) {
        Boolean r2 = (Boolean) r1;
        Intrinsics.checkNotNull(r2);
        InvHitPoint.d(r2.booleanValue());
    }
}
