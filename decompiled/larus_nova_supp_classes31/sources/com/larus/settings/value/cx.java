package com.larus.settings.value;

import com.bytedance.news.common.settings.SettingsManager;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final /* synthetic */ class cx implements Function0 {
    public /* synthetic */ cx() {
    }

    public final Object invoke() {
        List<String> r0 = ((INovaSetting) SettingsManager.obtain(INovaSetting.class)).getMinorWhitePage().a();
        if (r0 == null) goto L7;
        List r1 = CollectionsKt.filterNotNull(r0);
        if (r1 == null) goto L7;
        return r1;
    L7:
        return new ArrayList();
    }
}
