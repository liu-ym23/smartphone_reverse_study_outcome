package com.larus.bmhome.utils;

import com.larus.im.bean.message.Message;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class TrackerUtils {
    public static final /* synthetic */ int a = 0;

    public static final class a extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
        public a(CoroutineExceptionHandler.Key r1) {
            super(r1);
        }

        public final void handleException(CoroutineContext r1, Throwable r2) {
            com.larus.platform.service.g.a.ensureNotReachHere(r2);
        }
    }

    static {
    }

    public static void a(Message r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r7, "data");
        a r1 = new a(CoroutineExceptionHandler.Key);
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(r1)), null, null, new TrackerUtils$trackRdFlowMarkdownParseNodeInfo$1(r7, r8, null), 3, null);
    }
}
