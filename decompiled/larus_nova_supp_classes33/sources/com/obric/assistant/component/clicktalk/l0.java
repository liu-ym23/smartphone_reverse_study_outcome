package com.obric.assistant.component.clicktalk;

import com.larus.bmhome.chat.model.repo.ISettingRepoService;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class l0 {
    public static final Lazy a = null;
    public static final Lazy b = null;

    static {
        a = LazyKt.lazy(new j0());
        b = LazyKt.lazy(new k0());
    }

    public static ISettingRepoService a() {
        return (ISettingRepoService) a.getValue();
    }
}
