package com.ss.android.lark.chat.utils;

import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.utils.LarkContext;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b {
    public static void a(Set r6, String r7, String r8, final IGetDataCallback r9) {
        w4b.c r0 = ChatCoreModule.a();
        int r1 = hkb.a.a;
        int r2 = hkb.a.a.a;
        int r3 = com.suite.lark.platform.component.storage.file.dirs.h.c;
        com.suite.lark.platform.component.storage.file.dirs.h r4 = com.suite.lark.platform.component.storage.file.dirs.h.a.a(LarkContext.getApplication());
        r4.c(com.ss.android.lark.im.base.a.b());
        com.suite.lark.platform.component.storage.file.dirs.a r5 = new com.suite.lark.platform.component.storage.file.dirs.a();
        Intrinsics.checkNotNullParameter(r5, "pathProvider");
        com.suite.lark.platform.component.storage.file.dirs.h.b r10 = r4.a(r5);
        r10.c("rust");
        r0.getResource(r6, r10.a().getRealPath(), r7, r8, new AudioMessageHelper$3(r9));
    }
}
