package com.bytedance.android.live.browser.service;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u0002H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "", "", "ch", "invoke"}, k = 3, mv = {1, 4, 3})
final class AnnieLiveResourceServiceImpl$getRedirectImgUrl$1 extends Lambda implements Function1<String, Pair<? extends String, ? extends Integer>> {
    final /* synthetic */ String $url;

    public AnnieLiveResourceServiceImpl$getRedirectImgUrl$1(String r1) {
        this.$url = r1;
        super(1);
    }

    public final Pair<String, Integer> invoke(String r8) {
        Intrinsics.checkNotNullParameter(r8, "ch");
        Integer r0 = Integer.valueOf(StringsKt.indexOf$default(this.$url, r8, 0, false, 6, null));
        if (r0.intValue() <= (-1)) goto L5;
        boolean r1 = true;
    L7:
        if (r1 == true) goto L10;
        r0 = null;
    L10:
        if (r0 != null) goto L12;
        return null;
    L12:
        return new Pair(r8, Integer.valueOf(r0.intValue()));
    L5:
        r1 = false;
        goto L7
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((String) r1);
    }
}
