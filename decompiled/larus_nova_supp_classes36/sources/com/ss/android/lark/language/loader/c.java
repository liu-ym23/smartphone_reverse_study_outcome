package com.ss.android.lark.language.loader;

import com.ss.android.lark.storage.kv.repo.KVRepo;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class c extends BaseLanguageLoader {
    @Override // com.ss.android.lark.language.loader.BaseLanguageLoader
    public final Map<String, Integer> a() {
        return MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("zh-HK", 2131891862), TuplesKt.to("zh-TW", 2131891864)});
    }

    public c(KVRepo r2) {
        Intrinsics.checkNotNullParameter(r2, "globalCoreKVRepo");
        super(r2);
    }
}
