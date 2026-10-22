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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@InterceptorKey(InterceptorType.EXCEED_GROUP_LIMIT)
public final class ExceedGroupLimitInterceptor implements com.ss.android.lark.create.groupchat.impl.service.c {
    @Inject
    public ExceedGroupLimitInterceptor() {
    }

    @Override // com.ss.android.lark.create.groupchat.impl.service.c
    public final boolean a(Context r7, CreateGroupScene r8, ErrorResult r9, Function1<? super Boolean, Unit> r10, Fragment r11, CreateGroupService.c r12) {
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r8, "scene");
        Intrinsics.checkNotNullParameter(r9, "err");
        if (r9.getErrorCode() == 7010) goto L6;
        return false;
    L6:
        BuildersKt.launch$default(a.a(r7), Dispatchers.getMain(), null, new ExceedGroupLimitInterceptor$intercept$1(r9, r7, this, null), 2, null);
        return true;
    }
}
