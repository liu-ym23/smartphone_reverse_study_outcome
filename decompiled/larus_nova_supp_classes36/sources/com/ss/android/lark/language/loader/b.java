package com.ss.android.lark.language.loader;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.storage.kv.repo.KVRepo;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b extends c {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.android.lark.language.loader.BaseLanguageLoader
    public final LinkedHashMap<Locale, Integer> b() {
        LinkedHashMap<Locale, Integer> r0 = new LinkedHashMap();
        Iterator r1 = ((Map) this.b.getValue()).entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        Map.Entry r2 = (Map.Entry) r1.next();
        List r3 = StringsKt.split$default((CharSequence) r2.getKey(), new String[]{"-"}, false, 0, 6, null);
        if (r3.size() > 1) goto L7;
        r0.put(new Locale((String) ListProtector.get(r3, 0)), r2.getValue());
        goto L4
    L7:
        r0.put(new Locale((String) ListProtector.get(r3, 0), (String) ListProtector.get(r3, 1)), r2.getValue());
        goto L4
    L9:
        return r0;
    }

    public b(KVRepo r2) {
        Intrinsics.checkNotNullParameter(r2, "globalCoreKVRepo");
        super(r2);
    }
}
