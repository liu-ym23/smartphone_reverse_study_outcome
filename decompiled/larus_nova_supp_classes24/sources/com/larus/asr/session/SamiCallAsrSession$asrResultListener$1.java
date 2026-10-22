package com.larus.asr.session;

import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class SamiCallAsrSession$asrResultListener$1 {
    public final /* synthetic */ SamiCallAsrSession a;

    public SamiCallAsrSession$asrResultListener$1(SamiCallAsrSession r1) {
        this.a = r1;
    }

    /* JADX WARN: Type inference failed for: r4v0, types: [com.larus.asr.session.r2, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.larus.asr.session.s2, java.lang.Object] */
    public final void a(final pf9.a r15) {
        Intrinsics.checkNotNullParameter(r15, "result");
        FLogger r0 = FLogger.a;
        r0.i("SamiCallAsrSession", "onAsrResult..--------- START ----------");
        r0.i("SamiCallAsrSession", "onAsrResult taskId: " + r15.c + " text: " + g2a.d.b(r15.a));
        StringBuilder r2 = new StringBuilder("onAsrResult dump extra ");
        Map r3 = r15.d;
        ?? r4 = new r2();
        List r5 = (List) this.a.y.getValue();
        ?? r6 = new s2();
        Intrinsics.checkNotNullParameter(r4, "print");
        Intrinsics.checkNotNullParameter(r5, "excludes");
        Intrinsics.checkNotNullParameter(r6, "securityPrint");
        if (r3 != null) goto L5;
    L8:
        boolean r7 = true;
    L9:
        if (r7 == false) goto L11;
        r4.invoke("[EMPTY]");
    L18:
        r2.append(Unit.INSTANCE);
        r0.i("SamiCallAsrSession", r2.toString());
        String r1 = r15.c;
        if (r1 != null) goto L21;
        r1 = "";
    L21:
        final String r8 = r1;
        final SamiCallAsrSession r9 = this.a;
        Function2 r10 = new t2(r15, r9, r8);
        maa.e r11 = (maa.e) r9.d.invoke();
        if (r11 == null) goto L25;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new SamiCallAsrSession$asrResultListener$1$onAsrResult$3$1(r11, r8, r15, this.a, r10, null), 3, null);
        return;
    L25:
        FLogger.a.i("SamiCallAsrSession", "onAsrResult..---------- END ----------");
        return;
    L11:
        Iterator r12 = r3.entrySet().iterator();
    L13:
        if (r12.hasNext() == false) goto L18;
        Map.Entry r13 = (Map.Entry) r12.next();
        String r14 = (String) r13.getKey();
        String r16 = (String) r13.getValue();
        if (r5.contains(r14) == false) goto L16;
        r4.invoke(r14 + " is in excludes -> " + ((String) r6.invoke(r16)));
        goto L13
    L16:
        r4.invoke(r14 + " -> " + r16);
        goto L13
    L5:
        if (r3.isEmpty() == true) goto L8;
        r7 = false;
        goto L9
    }
}
