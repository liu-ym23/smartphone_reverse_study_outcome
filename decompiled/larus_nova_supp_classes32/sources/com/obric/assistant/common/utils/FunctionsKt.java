package com.obric.assistant.common.utils;

import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class FunctionsKt {
    public static final CoroutineScope a = null;

    static {
        a = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
    }

    public static final void a(Function0<Unit> r7) {
        Intrinsics.checkNotNullParameter(r7, "action");
        BuildersKt.launch$default(a, null, null, new FunctionsKt$asyncSafeCall$1(r7, null), 3, null);
    }

    public static final String b(String r8) {
        if (r8 != null) goto L17;
        FLogger.a.w("functions", "md5: input is null");
        return NameKeys.UnloadStrategy_No_Strategy;
    L17:
        byte[] r9 = MessageDigest.getInstance("MD5").digest(r8.getBytes(StandardCharsets.UTF_8));     // Catch: NoSuchAlgorithmException -> L14
        StringBuilder r2 = new StringBuilder(r9.length * 2);     // Catch: NoSuchAlgorithmException -> L14
        int r3 = r9.length;     // Catch: NoSuchAlgorithmException -> L14
        int r4 = 0;
    L7:
        if (r4 >= r3) goto L12;
        String r5 = Integer.toHexString(r9[r4] & 255);     // Catch: NoSuchAlgorithmException -> L14
        if (r5.length() != 1) goto L11;
        r2.append('0');     // Catch: NoSuchAlgorithmException -> L14
    L11:
        r2.append(r5);     // Catch: NoSuchAlgorithmException -> L14
        r4 = r4 + 1;     // Catch: NoSuchAlgorithmException -> L14
        goto L7
    L12:
        return r2.toString().toLowerCase();
    L14:
        e = move-exception;
        FLogger.a.e("functions", "md5: MD5 algorithm not found", e);
        return NameKeys.UnloadStrategy_No_Strategy;
    }
}
