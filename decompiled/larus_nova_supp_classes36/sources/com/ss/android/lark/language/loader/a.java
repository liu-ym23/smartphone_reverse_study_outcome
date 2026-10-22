package com.ss.android.lark.language.loader;

import com.ss.android.lark.storage.kv.repo.KVRepo;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a extends BaseLanguageLoader {
    @Override // com.ss.android.lark.language.loader.BaseLanguageLoader
    public final Map<String, Integer> a() {
        return MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("zh-HK", 2131891863), TuplesKt.to("zh-TW", 2131891865)});
    }

    public a(KVRepo r2) {
        Intrinsics.checkNotNullParameter(r2, "globalCoreKvRepo");
        super(r2);
    }
}
