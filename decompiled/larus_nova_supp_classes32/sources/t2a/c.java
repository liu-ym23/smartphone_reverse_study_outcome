package t2a;

import com.bytedance.keva.Keva;
import com.google.gson.Gson;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class c {
    public static final c a = null;
    public static final Lazy b = null;
    public static final Lazy c = null;
    public static volatile s2a.a d;

    public c() {
    }

    static {
        a = new c();
        b = LazyKt.lazy(new a());
        c = LazyKt.lazy(new b());
    }

    public static void a() {
        if (d != null) goto L30;
        Keva r0 = (Keva) b.getValue();
        String r2 = NameKeys.UnloadStrategy_No_Strategy;
        String r1 = r0.getString("key_voice_material_response", NameKeys.UnloadStrategy_No_Strategy);
        if (r1 == null) goto L8;
        r2 = r1;
    L8:
        FLogger r3 = FLogger.a;
        StringBuilder r4 = new StringBuilder("[loadVoiceMaterialResponse]: invoke sync dataStr isNotEmpty(");
        boolean r5 = false;
        if (r2.length() <= 0) goto L11;
        boolean r6 = true;
    L12:
        r4.append(r6);
        r4.append(')');
        r3.i("VoiceMaterialRepo", r4.toString());
        if (r2.length() <= 0) goto L15;
        r5 = true;
    L15:
        if (r5 == false) goto L31;
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L18
        a.getClass();     // Catch: Throwable -> L18
        Object r8 = Result.constructor-impl((s2a.a) ((Gson) c.getValue()).fromJson(r2, s2a.a.class));     // Catch: Throwable -> L18
    L20:
        Throwable r9 = Result.exceptionOrNull-impl(r8);
        if (r9 == null) goto L24;
        FLogger.a.e("VoiceMaterialRepo", "[loadVoiceMaterialResponse] error", r9);
    L24:
        if (Result.isFailure-impl(r8) == false) goto L26;
        r8 = null;
    L26:
        d = (s2a.a) r8;
        return;
    L18:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L20
    L31:
        return;
    L11:
        r6 = false;
        goto L12
    }
}
