package com.bytedance.android.ec.core.imagex;

import android.util.LruCache;
import com.bytedance.android.ec.core.imagex.ab.EditUrlCacheMemoryFixExperiment;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class EditUrlCache {
    public static final Lazy a = null;
    public static final Lazy b = null;

    public EditUrlCache() {
    }

    static {
        final EditUrlCache r0 = new EditUrlCache();
        LazyThreadSafetyMode r1 = LazyThreadSafetyMode.SYNCHRONIZED;
        a = LazyKt.lazy(r1, EditUrlCache$editUrlCache$2.INSTANCE);
        b = LazyKt.lazy(r1, new EditUrlCache$boundedEditUrlCache$2(r0));
    }

    public static LruCache a() {
        if (((Boolean) EditUrlCacheMemoryFixExperiment.a.getValue()).booleanValue() == false) goto L6;
        return (EditUrlCache$boundedEditUrlCache$2.a) b.getValue();
    L6:
        return (LruCache) a.getValue();
    }

    public static void b(String r10, List r11, com.bytedance.android.shopping.api.image.r r12) {
        Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE);
        if (r10 != null) goto L5;
        return;
    L5:
        ImageExperiments.G.getClass();
        if (((Boolean) ImageExperiments.e.getValue()).booleanValue() == true) goto L8;
        return;
    L8:
        a().put(r10, new Pair(r11, r12));
    }
}
