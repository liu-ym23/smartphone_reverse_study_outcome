package com.ss.android.lark.im.sdk.service;

import com.ss.android.lark.chat.entity.chatter.Chatter;
import io.reactivex.functions.Function;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class n<T, R> implements Function {
    public final /* synthetic */ String a;

    public n(String r1) {
        this.a = r1;
    }

    public final Object apply(Object r2) {
        Map r3 = (Map) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        Chatter r4 = (Chatter) r3.get(this.a);
        if (r4 == null) goto L5;
        return r4;
    L5:
        int r5 = ImSdkChatterServiceImplV2.c;
        throw ImSdkChatterServiceImplV2.a.a("updateMineAvatar pull chatter fail!");
    }
}
