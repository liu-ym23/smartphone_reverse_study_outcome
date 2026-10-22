package com.ss.android.lark.create.groupchat.impl.service.interceptor;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.create.groupchat.dto.CreateGroupScene;
import com.ss.android.lark.create.groupchat.impl.service.CreateGroupService;
import com.ss.android.lark.create.groupchat.impl.service.InterceptorKey;
import com.ss.android.lark.create.groupchat.impl.service.InterceptorType;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@InterceptorKey(InterceptorType.DLP)
public final class b implements com.ss.android.lark.create.groupchat.impl.service.c {
    @Inject
    public b() {
    }

    @Override // com.ss.android.lark.create.groupchat.impl.service.c
    public final boolean a(Context r1, CreateGroupScene r2, ErrorResult r3, Function1<? super Boolean, Unit> r4, Fragment r5, CreateGroupService.c r6) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "scene");
        Intrinsics.checkNotNullParameter(r3, "err");
        int r7 = iab.a.c;
        hab.a r8 = iab.a.C0236a.a().b;
        if (r8 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("auditDependency");
        r8 = null;
    L7:
        return r8.d(r3.getCode(), r3.getExtra());
    }
}
