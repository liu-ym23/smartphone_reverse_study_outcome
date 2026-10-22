package com.ss.android.lark.chat.utils;

import com.ss.android.lark.chat.api.service.ITranslateService;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class UrlTranslateUtils {
    public final ITranslateService a;
    public final com.ss.android.lark.translate.service.impl.a b;

    public static final class a {
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(final f5b.b r5) {
        Intrinsics.checkNotNullParameter(r5, "messageInfo");
        HashMap r0 = new HashMap();
        r0.put(r5.getId(), r5);
        HashMap r1 = new HashMap();
        HashMap r2 = new HashMap();
        h0.g(r0, r5.getTranslateInfo().getLanguage(), r1, r2);
        this.a.W4(true, r1, r2, new UrlTranslateUtils$loadUrlTranslation$1(r5, this));
    }

    public UrlTranslateUtils(ITranslateService r2, com.ss.android.lark.translate.service.impl.a r3) {
        Intrinsics.checkNotNullParameter(r2, "translateService");
        Intrinsics.checkNotNullParameter(r3, "translatePush");
        this.a = r2;
        this.b = r3;
    }
}
