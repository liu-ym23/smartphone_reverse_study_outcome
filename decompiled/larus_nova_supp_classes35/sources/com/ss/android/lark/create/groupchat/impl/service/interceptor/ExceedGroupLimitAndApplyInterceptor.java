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
@InterceptorKey(InterceptorType.EXCEED_GROUP_LIMIT_NEED_APPLY)
public final class ExceedGroupLimitAndApplyInterceptor implements com.ss.android.lark.create.groupchat.impl.service.c {
    public static final /* synthetic */ int a = 0;

    public static final class a {
    }

    static {
    }

    @Inject
    public ExceedGroupLimitAndApplyInterceptor() {
    }

    @Override // com.ss.android.lark.create.groupchat.impl.service.c
    public final boolean a(Context r12, CreateGroupScene r13, ErrorResult r14, Function1<? super Boolean, Unit> r15, Fragment r16, CreateGroupService.c r17) {
        Intrinsics.checkNotNullParameter(r12, "context");
        Intrinsics.checkNotNullParameter(r13, "scene");
        Intrinsics.checkNotNullParameter(r14, "err");
        boolean r4 = false;
        if (r14.getErrorCode() == 7011) goto L8;
        if (r14.getErrorCode() == 7012) goto L8;
        return false;
    L8:
        if (r14.getErrorCode() != 7012) goto L10;
        r4 = true;
    L10:
        BuildersKt.launch$default(com.ss.android.lark.create.groupchat.impl.service.interceptor.a.a(r12), Dispatchers.getMain(), null, new ExceedGroupLimitAndApplyInterceptor$intercept$1(r14, r12, r4, r15, null), 2, null);
        return true;
    }
}
