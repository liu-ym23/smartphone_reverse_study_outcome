package com.larus.bmhome.instruction;

import com.larus.bmhome.chat.api.BotApi;
import com.larus.bmhome.chat.model.repo.BotRepo;
import com.larus.bmhome.chat.model.repo.IBotRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.larus.common.apphost.AppHost;
import com.larus.utils.AppLocaleUtils;
import java.util.Locale;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class z1 {
    public static final BotRepo a = null;

    static {
        RepoDispatcher.a.getClass();
        a = RepoDispatcher.g;
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [com.larus.bmhome.instruction.y1, java.lang.Object, kotlin.jvm.functions.Function1] */
    public static void a(String r4, String r5, final Function1 r6) {
        Intrinsics.checkNotNullParameter(r4, "botId");
        Intrinsics.checkNotNullParameter(r5, "conversationId");
        Intrinsics.checkNotNullParameter(r6, "callback");
        if (AppHost.a.isOversea() == false) goto L5;
        AppLocaleUtils.a.getClass();
        Locale r1 = AppLocaleUtils.c();
    L6:
        String r2 = com.larus.utils.b0.a;
        Intrinsics.checkNotNull(r1);
        String r3 = com.larus.utils.b0.c(r1);
        BotRepo r7 = a;
        IBotRepoService.a r8 = new IBotRepoService.a(r3, r4, r5);
        ?? r9 = new y1(r6);
        r7.getClass();
        Intrinsics.checkNotNullParameter(r8, "param");
        Intrinsics.checkNotNullParameter(r9, "callback");
        BotRepo.a().getClass();
        Intrinsics.checkNotNullParameter(r8, "param");
        Intrinsics.checkNotNullParameter(r9, "callback");
        if (Intrinsics.areEqual(BotApi.b.getFirst(), r8.c) == false) goto L11;
        com.larus.network.http.a r10 = (com.larus.network.http.a) BotApi.b.getSecond();
        if (r10 == null) goto L13;
        r9.invoke(r10);
        return;
    L13:
        return;
    L11:
        BotApi.c = r9;
        return;
    L5:
        r1 = Locale.CHINA;
        goto L6
    }
}
