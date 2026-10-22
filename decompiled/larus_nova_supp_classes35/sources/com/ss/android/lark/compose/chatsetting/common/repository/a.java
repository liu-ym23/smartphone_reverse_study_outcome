package com.ss.android.lark.compose.chatsetting.common.repository;

import com.lark.kmp.rustclient.api.model.g;
import com.lark.kmp.rustclient.api.model.k;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.c1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public static final Object a(g r1) {
        if ((r1 instanceof k) == false) goto L6;
        Result.Companion r0 = Result.Companion;
        return Result.constructor-impl(((k) r1).b);
    L6:
        if ((r1 instanceof com.lark.kmp.rustclient.api.model.b) == false) goto L10;
        Result.Companion r2 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(((com.lark.kmp.rustclient.api.model.b) r1).b.a()));
    L10:
        throw new NoWhenBranchMatchedException();
    }

    public static final c1 b(ChatSettingRepository r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "chatId");
        return new c1(new ChatSettingRepositoryKt$fetchAndObserveChat$1(r2, r3, null));
    }

    public static final c1 c(ChatSettingRepository r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "chatId");
        Intrinsics.checkNotNullParameter(r4, "userId");
        return new c1(new ChatSettingRepositoryKt$observeQuit$1(r2, r3, r4, null));
    }
}
