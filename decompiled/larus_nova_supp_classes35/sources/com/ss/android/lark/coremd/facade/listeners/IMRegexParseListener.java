package com.ss.android.lark.coremd.facade.listeners;

import com.ss.android.lark.coremd.facade.bizext.IMContextExtend;
import com.ss.android.lark.coremdbiz.facade.listeners.RegexParseListener;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class IMRegexParseListener extends RegexParseListener {
    public static final Lazy<Boolean> d = null;

    public static final class a {
    }

    @Override // com.ss.android.lark.coremdbiz.facade.listeners.RegexParseListener
    public final boolean e(com.ss.android.lark.coremd.impl.parse.d r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return false;
    }

    static {
        d = LazyKt.lazy(IMRegexParseListener$Companion$sUseNewSystemRecognizePhone$2.INSTANCE);
    }

    @Override // com.ss.android.lark.coremdbiz.facade.listeners.RegexParseListener
    public final boolean j() {
        return ((Boolean) d.getValue()).booleanValue();
    }

    public IMRegexParseListener() {
    }

    @Override // com.ss.android.lark.coremdbiz.facade.listeners.RegexParseListener
    public final boolean h(final com.ss.android.lark.coremd.impl.parse.d r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        return ((Boolean) IMContextExtend.A.b(new IMRegexParseListener$shouldParseLink$isSecretChat$1(r3))).booleanValue();
    }

    @Override // com.ss.android.lark.coremdbiz.facade.listeners.RegexParseListener
    public final boolean i(final com.ss.android.lark.coremd.impl.parse.d r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        IMContextExtend.a r0 = IMContextExtend.A;
        if (((Boolean) r0.b(new IMRegexParseListener$shouldParsePhone$forceParse$1(r4))).booleanValue() == false) goto L5;
        return true;
    L5:
        v9b.a r5 = (v9b.a) r0.b(new IMRegexParseListener$shouldParsePhone$messageData$1(r4));
        int r1 = com.ss.android.lark.chat.chatwindow.chat.model.preload.a.a;
        if (r5.k < 1000) goto L8;
        boolean r6 = true;
    L10:
        return !r6;
    L8:
        r6 = false;
        goto L10
    }
}
