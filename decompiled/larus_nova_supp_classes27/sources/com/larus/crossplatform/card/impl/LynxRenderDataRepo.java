package com.larus.crossplatform.card.impl;

import com.larus.common.apphost.AppHost;
import com.larus.utils.cache.DiskCache;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import kotlin.ExceptionsKt;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ExecutorsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LynxRenderDataRepo {
    public static final CoroutineScope a = null;
    public static final DiskCache b = null;

    public static final class a extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
        public a(CoroutineExceptionHandler.Key r1) {
            super(r1);
        }

        public final void handleException(CoroutineContext r4, Throwable r5) {
            String r6 = ExceptionsKt.stackTraceToString(r5);
            FLogger r0 = FLogger.a;
            CoroutineScope r1 = LynxRenderDataRepo.a;
            r0.e("LynxRenderDataRepo", "exception=" + r6);
            if (AppHost.a.isTestChannel() == true) goto L5;
            return;
        L5:
            throw r5;
        }
    }

    public LynxRenderDataRepo() {
    }

    static {
        a r1 = new a(CoroutineExceptionHandler.Key);
        a = CoroutineScopeKt.CoroutineScope(ExecutorsKt.from(PThreadExecutorsUtils.newSingleThreadExecutor(new f())).plus(r1));
        b = new DiskCache("plugin-data-ivy");
    }

    public static void a(String r7) {
        Intrinsics.checkNotNullParameter(r7, "key");
        BuildersKt.launch$default(a, Dispatchers.getIO(), null, new LynxRenderDataRepo$deletePluginViewCacheData$1(r7, null, null), 2, null);
    }

    public static void c(String r7, Function1 r8) {
        Intrinsics.checkNotNullParameter(r7, "key");
        Intrinsics.checkNotNullParameter(r8, "callback");
        BuildersKt.launch$default(a, Dispatchers.getIO(), null, new LynxRenderDataRepo$readPluginViewCacheData$1(r7, r8, null), 2, null);
    }

    public static void d(String r7, String r8) {
        Intrinsics.checkNotNullParameter(r7, "key");
        Intrinsics.checkNotNullParameter(r8, "data");
        BuildersKt.launch$default(a, Dispatchers.getIO(), null, new LynxRenderDataRepo$savePluginViewCacheData$1(r7, r8, null), 2, null);
    }

    public static void b(String r11, String r12, Function2 r13) {
        Intrinsics.checkNotNullParameter(r11, "dataUrl");
        Intrinsics.checkNotNullParameter(r12, "messageId");
        Intrinsics.checkNotNullParameter(r13, "c");
        Ref.LongRef r4 = new Ref.LongRef();
        BuildersKt.launch$default(a, Dispatchers.getIO(), null, new LynxRenderDataRepo$loadLynxData$1(r11, r12, r4, r13, null), 2, null);
    }
}
