package com.ss.android.lark.officesdk.permission.impl;

import com.bytedance.supervisor.token.Token;
import com.ss.android.lark.officesdk.permission.api.IPermissionRequester;
import com.ss.android.lark.utils.g0;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class InnerPermissionRequester implements g0 {
    public final IPermissionRequester a;

    public static final class a {
    }

    static {
    }

    @Inject
    public InnerPermissionRequester(IPermissionRequester r2) {
        Intrinsics.checkNotNullParameter(r2, "delegate");
        this.a = r2;
    }

    public void requestPermissions(Token r2, String[] r3, final Function1<? super g0.a, Unit> r4) {
        Intrinsics.checkNotNullParameter(r3, "permissions");
        Intrinsics.checkNotNullParameter(r4, "callback");
        this.a.requestPermissions(ArraysKt.toList(r3), new AnonymousClass1(r4));
    }
}
