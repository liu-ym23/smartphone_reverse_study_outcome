package com.bytedance.android.annie.service.prefetch;

import android.content.Context;
import com.bytedance.android.annie.Annie;
import com.bytedance.geckox.utils.ResLoadUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class AbsAnnieGeckoResLoader implements n {
    public static boolean b;
    public final Lazy a;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.annie.service.prefetch.n
    public abstract /* synthetic */ Context getContext();

    public AbsAnnieGeckoResLoader() {
        this.a = LazyKt.lazy(new AbsAnnieGeckoResLoader$resourceLoader$2(this));
    }

    @Override // com.bytedance.android.annie.service.prefetch.n
    public final InputStream a(String r13, String r14) {
        Intrinsics.checkNotNullParameter(r13, "relativePath");
        Intrinsics.checkNotNullParameter(r14, "channel");
        PolarisFileWrapper r1 = null;
        if (b == true) goto L17;
        b r0 = (b) this;
        String r10 = r0.d;
        if (r10 != null) goto L7;
    L10:
        boolean r11 = true;
    L11:
        if (r11 == true) goto L17;
        LinkedHashMap r12 = new LinkedHashMap();
        List<String> r15 = ((com.bytedance.android.annie.service.resource.f) Annie.getService$default(com.bytedance.android.annie.service.resource.f.class, null, 2, null)).r();
        ArrayList r16 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r15, 10));
        Iterator<T> r17 = r15.iterator();
    L14:
        if (r17.hasNext() == false) goto L16;
        String r18 = (String) r17.next();
        r12.put(r18, CollectionsKt.listOf(new String[]{"prefetch." + r18 + ".json", "protobuf/definitions_v2.json", "protobuf/definitions.json", "protobuf/shrink_config.json", "latch.json"}));
        r16.add(Unit.INSTANCE);
        goto L14
    L16:
        com.bytedance.geckox.b r19 = com.bytedance.geckox.b.a.a;
        ((ConcurrentHashMap) com.bytedance.iesgurd.core.f.a).put(r0.d, r12);
        b = true;
        goto L17
    L7:
        if (r10.length() == 0) goto L10;
        r11 = false;
    L17:
        b r20 = (b) this;
        String r21 = r20.e;
        if (r21 == null) goto L21;
        r1 = new PolarisFileWrapper(r21);
    L21:
        return ResLoadUtils.getPrefetchDataForPath(r1, r20.d, r14, r13);
    }
}
