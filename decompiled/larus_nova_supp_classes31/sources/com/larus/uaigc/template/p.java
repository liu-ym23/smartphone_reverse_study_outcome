package com.larus.uaigc.template;

import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class p {
    public static final void a(long r6) {
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new ImageTemplateHelperKt$reportCreationRecommendOpCounter$1(r6, null), 2, null);
    }
}
