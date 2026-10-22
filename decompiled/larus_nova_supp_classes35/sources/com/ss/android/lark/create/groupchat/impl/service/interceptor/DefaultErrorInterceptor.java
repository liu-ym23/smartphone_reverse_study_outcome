package com.ss.android.lark.create.groupchat.impl.service.interceptor;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.create.groupchat.dto.CreateGroupScene;
import com.ss.android.lark.create.groupchat.impl.service.CreateGroupService;
import com.ss.android.lark.create.groupchat.impl.service.InterceptorKey;
import com.ss.android.lark.create.groupchat.impl.service.InterceptorType;
import com.ss.android.lark.utils.UIHelper;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@InterceptorKey(InterceptorType.DEFAULT)
public final class DefaultErrorInterceptor implements com.ss.android.lark.create.groupchat.impl.service.c {
    @Inject
    public DefaultErrorInterceptor() {
    }

    @Override // com.ss.android.lark.create.groupchat.impl.service.c
    public final boolean a(Context r7, CreateGroupScene r8, ErrorResult r9, Function1<? super Boolean, Unit> r10, Fragment r11, CreateGroupService.c r12) {
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r8, "scene");
        Intrinsics.checkNotNullParameter(r9, "err");
        String r13 = r9.getDisplayMsg(UIHelper.getString(2131892057));
        BuildersKt.launch$default(a.a(r7), Dispatchers.getMain(), null, new DefaultErrorInterceptor$intercept$1(r7, r13, null), 2, null);
        return true;
    }
}
