package com.larus.commercecredit.impl.utils;

import android.util.LruCache;
import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class CommerceCreditMobHelper {
    public static final LruCache<String, Boolean> a = null;

    static {
        a = new LruCache(10);
    }

    public static void a(Message r7) {
        Intrinsics.checkNotNullParameter(r7, "message");
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new CommerceCreditMobHelper$mobCommerceCreditReceiveStream$1(r7, null), 3, null);
    }
}
