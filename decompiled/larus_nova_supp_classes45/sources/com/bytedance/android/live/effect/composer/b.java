package com.bytedance.android.live.effect.composer;

import com.bytedance.android.livesdkapi.depend.model.Sticker;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b {
    public final Map<String, List<Sticker>> a;

    public b(final String r2) {
        Intrinsics.checkNotNullParameter(r2, "dbName");
        Intrinsics.checkNotNullParameter(r2, "dbName");
        LazyKt.lazy(new LiveComposerNodeListCache$composerSQLiteHelper$2(r2));
        new ArrayList();
        new ArrayList();
        this.a = new HashMap();
    }
}
