package ffa;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.obric_action.h;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class a {
    public final Set<String> a;

    /* JADX INFO: renamed from: ffa.a$a, reason: collision with other inner class name */
    public static final class C0054a {
    }

    static {
    }

    public a(Set<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "supportedHosts");
        this.a = r2;
    }

    public final b a(Uri r11, String r12) {
        Intrinsics.checkNotNullParameter(r11, "uri");
        String r0 = r11.getScheme();
        boolean r2 = false;
        if (Intrinsics.areEqual(r0, "obric_action") == false) goto L5;
    L8:
        boolean r1 = true;
    L10:
        if (r1 == true) goto L14;
        FLogger.a.w("ObricActionIntentResolver", "schema " + r0 + " not support!");
        return new b(null, h.a.a(h.d, "schema " + r0 + " not support", 2), 1);
    L14:
        if (r11.isHierarchical() == true) goto L17;
        FLogger.a.w("ObricActionIntentResolver", "uri is not hierarchical!");
        return new b(null, h.a.a(h.d, "uri is not hierarchical", 2), 1);
    L17:
        String r3 = r11.getHost();
        String r4 = "";
        if (r3 != null) goto L21;
        r3 = "";
    L21:
        if (this.a.contains(r3) == true) goto L24;
        FLogger.a.w("ObricActionIntentResolver", "host " + r3 + " not support!");
        return new b(null, h.a.a(h.d, "host " + r3 + " not support", 2), 1);
    L24:
        String r5 = UriProtector.getQueryParameter(r11, "key");
        if (r5 != null) goto L27;
    L30:
        boolean r6 = true;
    L31:
        if (r6 == false) goto L34;
        FLogger.a.w("ObricActionIntentResolver", "key is empty!");
        return new b(null, h.a.a(h.d, "key is empty", 2), 1);
    L34:
        if (r12 != null) goto L36;
    L39:
        boolean r7 = true;
    L40:
        if (r7 == false) goto L44;
        FLogger.a.w("ObricActionIntentResolver", "expectKey is empty!");
        return new b(null, h.a.a(h.d, "expectKey is empty", 2), 1);
    L44:
        if (StringsKt.equals(r5, r12, true) == true) goto L69;
        FLogger.a.w("ObricActionIntentResolver", "key " + r5 + " not match expectKey " + r12);
        return new b(null, h.a.a(h.d, "key not match expectKey", 2), 1);
    L69:
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L52
        String r14 = UriProtector.getQueryParameter(r11, "data");     // Catch: Throwable -> L52
        if (r14 != null) goto L50;
        r14 = "";
    L50:
        Object r15 = Result.constructor-impl(new b(new efa.a(r3, r14), null, 2));     // Catch: Throwable -> L52
    L54:
        Throwable r16 = Result.exceptionOrNull-impl(r15);
        if (r16 == null) goto L68;
        FLogger.a.w("ObricActionIntentResolver", "parse obric action uri failed. " + r16.getMessage(), r16);
        h.a r17 = h.d;
        String r18 = r16.getMessage();
        if (r18 == null) goto L62;
        r4 = r18;
    L62:
        if (r4.length() != 0) goto L64;
        r2 = true;
    L64:
        if (r2 == false) goto L66;
        r4 = "parse obric action uri failed";
    L66:
        r15 = new b(null, h.a.a(r17, r4, 2), 1);
    L68:
        return (b) r15;
    L52:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L54
    L36:
        if (r12.length() == 0) goto L39;
        r7 = false;
        goto L40
    L27:
        if (r5.length() == 0) goto L30;
        r6 = false;
        goto L31
    L5:
        if (Intrinsics.areEqual(r0, "obric_intent") == true) goto L8;
        r1 = false;
        goto L10
    }
}
