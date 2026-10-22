package com.larus.platform.service;

import com.larus.platform.api.j2;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class DoraAudioService {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(new h0());
    }

    public static j2 c() {
        return (j2) a.getValue();
    }

    public static void a() {
        j2 r0 = c();
        if (r0 == null) goto L10;
        Integer r1 = r0.l();
        if (r1 == null) goto L10;
        if (r1.intValue() != 2) goto L10;
        boolean r2 = true;
    L11:
        if (r2 == true) goto L13;
        return;
    L13:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new DoraAudioService$disableVuiForMicOccupy$1(null), 3, null);
        return;
    L10:
        r2 = false;
        goto L11
    }

    public static void b() {
        j2 r0 = c();
        if (r0 == null) goto L10;
        Integer r1 = r0.l();
        if (r1 == null) goto L10;
        if (r1.intValue() != 2) goto L10;
        boolean r2 = true;
    L11:
        if (r2 == true) goto L13;
        return;
    L13:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new DoraAudioService$enableVuiAfterMicRelease$1(null), 3, null);
        return;
    L10:
        r2 = false;
        goto L11
    }
}
