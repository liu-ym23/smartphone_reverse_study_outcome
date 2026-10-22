package jh;

import com.bytedance.keva.Keva;
import com.bytedance.pia.core.setting.Settings;
import com.bytedance.pia.core.utils.j;
import com.lynx.tasm.p;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f18343a = null;

    static {
        f18343a = new b();
    }

    @Override // java.lang.Runnable
    public final void run() {
        Keva r10 = c.f18344a;
        c.d = System.currentTimeMillis();
        Lazy r11 = Settings.B;
        if (p.a().m() == true) goto L6;
        return;
    L6:
        if (c.e.get() == false) goto L67;
        long r5 = System.currentTimeMillis();
        Keva r12 = c.f18344a;
        if (r12 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("indexRepo");
        r12 = null;
    L11:
        Iterator<Map.Entry<String, ?>> r13 = r12.getAll().entrySet().iterator();
    L13:
        if (r13.hasNext() == false) goto L68;
        String r14 = r13.next().getKey();
        if (StringsKt.k(r14, "_extraVary") == true) goto L13;
        Keva r15 = c.a(r14);
        if (r15 == null) goto L43;
        Iterator<Map.Entry<String, ?>> r16 = r15.getAll().entrySet().iterator();
    L20:
        if (r16.hasNext() == false) goto L42;
        Map.Entry<String, ?> r17 = r16.next();
        String r18 = r17.getKey();
        Object r19 = r17.getValue();
        if ((r19 instanceof String) == false) goto L24;
        String r20 = (String) r19;
    L25:
        if (r20 == null) goto L41;
        Result.Companion r21 = Result.Companion;     // Catch: Throwable -> L28
        Object r22 = Result.m124constructorimpl((a) c.f18346c.fromJson(r20, a.class));     // Catch: Throwable -> L28
    L31:
        if (Result.m130isFailureimpl(r22) == false) goto L33;
        r22 = null;
    L33:
        a r23 = (a) r22;
        if (r23 == null) goto L40;
        Number r24 = r23.a();
        if (r24 == null) goto L40;
        if (r24.longValue() > r5) goto L20;
        c.j(r15, r18);
        j.y("[PIACacheManager] Remove Stale Cache Success. (URL: " + r18 + ", config = " + r23 + ')', null);
    L40:
        c.j(r15, r18);
    L28:
        th = move-exception;
        Result.Companion r25 = Result.Companion;
        r22 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L31
    L41:
        c.j(r15, r18);
        goto L20
    L24:
        r20 = null;
        goto L25
    L42:
        Unit r26 = Unit.INSTANCE;
    L44:
        if (r26 != null) goto L13;
        c.p(r14);
        goto L13
    L43:
        r26 = null;
        goto L44
    L68:
        return;
    }
}
