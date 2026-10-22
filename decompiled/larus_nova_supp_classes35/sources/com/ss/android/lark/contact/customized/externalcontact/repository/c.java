package com.ss.android.lark.contact.customized.externalcontact.repository;

import java.util.List;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c implements com.ss.android.lark.sdk.f.a {
    public static final c a = null;

    static {
        a = new c();
    }

    public c() {
    }

    public final void a() {
        Lazy r0 = OfficeExternalContactRepository.a;
        NewFriendBadgeRepository.a r1 = NewFriendBadgeRepository.b;
        Intrinsics.checkNotNullParameter(r1, "listener");
        com.ss.android.lark.sdk.f.a((List) OfficeExternalContactRepository.a.getValue(), r1, f.a);
    }
}
