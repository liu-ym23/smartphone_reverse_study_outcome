package com.larus.bmhome.view.actionbar.deepresearch;

import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.bmhome.instruction.g;
import com.larus.utils.logger.FLogger;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import tx9.p0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b {
    public static final b a = null;
    public static final Lazy b = null;
    public static z0 c;
    public static g d;
    public static y e;

    public b() {
    }

    static {
        a = new b();
        b = LazyKt.lazy(new a());
    }

    public static Map c() {
        return (Map) b.getValue();
    }

    public static boolean d() {
        if (c != null) goto L5;
        return false;
    L5:
        y r0 = e;
        if (r0 == null) goto L8;
        String r1 = r0.Y1();
    L9:
        if (r1 != null) goto L11;
        return false;
    L11:
        c r2 = (c) c().get(r1);
        if (r2 != null) goto L14;
        return false;
    L14:
        if (r2.b != true) goto L18;
        return true;
    L18:
        return false;
    L8:
        r1 = null;
        goto L9
    }

    public static void a(String r3) {
        b r0 = a;
        monitor-enter(r0);
        if (r3 != null) goto L23;
    L8:
        y r1 = e;     // Catch: Throwable -> L20
        if (r1 == null) goto L11;
        String r2 = r1.Y1();     // Catch: Throwable -> L20
    L13:
        if (Intrinsics.areEqual(r3, r2) == true) goto L17;
        FLogger.a.i("DeepResearchBarManager", "clearItemAndVContext, cvsId not the same");     // Catch: Throwable -> L20
        monitor-exit(r0);
        return;
    L17:
        c = null;     // Catch: Throwable -> L20
        d = null;     // Catch: Throwable -> L20
        e = null;     // Catch: Throwable -> L20
        monitor-exit(r0);
        return;
    L11:
        r2 = null;
        goto L13
    L23:
        c r4 = (c) c().get(r3);     // Catch: Throwable -> L20
        if (r4 == null) goto L8;
        p0.a(r4.a, "user_end");     // Catch: Throwable -> L20
        c r5 = (c) c().remove(r3);     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;
    }

    public static void b(Map r10) {
        if (r10 != null) goto L4;
        r10 = new LinkedHashMap();
    L4:
        y r0 = e;
        if (r0 == null) goto L7;
        String r1 = r0.Y1();
    L8:
        if (r1 != null) goto L11;
        return;
    L11:
        if (d() == false) goto L18;
        r10.put("deep_research_phase", "more_context");
        c r2 = (c) c().get(r1);
        if (r2 == null) goto L15;
        String r3 = r2.a;
    L16:
        if (r3 == null) goto L19;
        r10.put("deep_research_id", r3);
    L19:
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new DeepResearchBarManager$getDeepResearchParamsToSend$2(null), 3, null);
        return;
    L15:
        r3 = null;
        goto L16
    L18:
        r10.put("deep_research_phase", "topic");
        goto L19
    L7:
        r1 = null;
        goto L8
    }

    public static void e(String r7, String r8) {
        if (c != null) goto L5;
        return;
    L5:
        c r0 = (c) c().get(r7);
        if (r0 == null) goto L10;
        if (r8 == null) goto L10;
        FLogger.a.i("DeepResearchBarManager", "quitDeepSearch, deepResearchId[" + r0.a + "], cvsId[" + r7 + "], reason[" + r8 + ']');
        p0.a(r0.a, r8);
    L10:
        c().remove(r7);
        y r1 = e;
        if (r1 == null) goto L13;
        String r2 = r1.Y1();
    L15:
        if (Intrinsics.areEqual(r2, r7) == false) goto L20;
        FLogger.a.i("DeepResearchBarManager", "quitDeepSearch, closeInstructionEditor, cvsId[" + r7 + "], reason[" + r8 + ']');
        g r9 = d;
        if (r9 == null) goto L21;
        r9.A1();
        return;
    L21:
        return;
    L20:
        return;
    L13:
        r2 = null;
        goto L15
    }

    public static void f(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "cvsId");
        Intrinsics.checkNotNullParameter(r5, "sourceMsgId");
        if (c().containsKey(r4) == true) goto L7;
        FLogger.a.i("DeepResearchBarManager", "registerDeepResearchInfoIfAbsent, cvsId[" + r4 + "], sourceMsgId[" + r5 + "], isInExplain[false]");
        c().put(r4, new c(r5, r4, false));
        return;
    }
}
