package com.ss.android.lark.create.groupchat.impl.service.interceptor;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.chat.utils.ChatParamUtils;
import com.ss.android.lark.create.groupchat.dto.CreateGroupScene;
import com.ss.android.lark.create.groupchat.impl.service.CreateGroupService;
import com.ss.android.lark.create.groupchat.impl.service.InterceptorKey;
import com.ss.android.lark.create.groupchat.impl.service.InterceptorType;
import com.ss.android.lark.create.groupchat.impl.statistics.CreateGroupExtraParams$TextType;
import com.ss.android.lark.create.groupchat.impl.statistics.CreateGroupHitPointNew;
import com.ss.android.lark.statistics.Statistics;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@InterceptorKey(InterceptorType.HIT_POINT)
public final class f implements com.ss.android.lark.create.groupchat.impl.service.c {
    @Inject
    public f() {
    }

    @Override // com.ss.android.lark.create.groupchat.impl.service.c
    public final boolean a(Context r1, CreateGroupScene r2, ErrorResult r3, Function1<? super Boolean, Unit> r4, Fragment r5, CreateGroupService.c r6) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "scene");
        Intrinsics.checkNotNullParameter(r3, "err");
        CreateGroupExtraParams$TextType r7 = a.b(r2);
        int r8 = CreateGroupHitPointNew.a;
        Intrinsics.checkNotNullParameter(r7, "extraParams");
        Statistics.sendEvent("im_chat_member_toplimit_view", s5c.b.a(ChatParamUtils.e(), r7).toJson());
        return false;
    }
}
