package com.obric.assistant.settings;

import com.bytedance.keva.Keva;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.t1;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class h {
    public static final h a = null;
    public static final AtomicBoolean b = null;
    public static final Lazy c = null;
    public static final b d = null;

    public static final class a {
        public final boolean a;
        public final boolean b;
        public final String c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r1 = 1231;
            if (this.a == false) goto L5;
            int r0 = 1231;
        L6:
            int r2 = r0 * 31;
            if (this.b == true) goto L11;
            r1 = 1237;
        L11:
            return ((r2 + r1) * 31) + this.c.hashCode();
        L5:
            r0 = 1237;
            goto L6
        }

        public final String toString() {
            return "EntryEnabledState(enabled=" + this.a + ", resolved=" + this.b + ", source=" + this.c + ')';
        }

        public a(boolean r2, boolean r3, String r4) {
            Intrinsics.checkNotNullParameter(r4, "source");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public static final class b implements com.obric.assistant.m {
        public b() {
        }

        public final void a(String r5) {
            if (r5 != null) goto L4;
        L7:
            h.a.getClass();
            com.larus.utils.t0.a(new g());
            return;
        L4:
            if (Intrinsics.areEqual(r5, "obric_feature_cocreation_review_support") == true) goto L7;
            if (StringsKt.contains$default(r5, "obric_feature_cocreation_review_support", false, 2, null) == true) goto L7;
        }
    }

    public h() {
    }

    static {
        a = new h();
        b = new AtomicBoolean(false);
        c = LazyKt.lazy(new f());
        d = new b();
    }

    public static a a() {
        if (b.compareAndSet(false, true) == false) goto L6;
        t1.a.B0(d);
    L6:
        JsonObject r0 = t1.a.getObricCloudConfig("obric_feature_cocreation_review_support");
        Object r4 = null;
        if (r0 == null) goto L19;
        JsonElement r3 = r0.get("obric_feature_cocreation_review_support");
        if (r3 == null) goto L19;
        if (r3.isJsonObject() == true) goto L14;
        r3 = null;
    L14:
        if (r3 == null) goto L16;
        JsonObject r5 = r3.getAsJsonObject();
    L17:
        if (r5 == null) goto L19;
        r0 = r5;
        goto L19
    L16:
        r5 = null;
    L19:
        if (r0 == null) goto L35;
        JsonElement r6 = r0.get("enable");
        if (r6 == null) goto L35;
        if (r6.isJsonPrimitive() == true) goto L26;
        r6 = null;
    L26:
        if (r6 == null) goto L35;
        JsonPrimitive r7 = r6.getAsJsonPrimitive();
        if (r7 == null) goto L35;
        if (r7.isBoolean() == true) goto L33;
        r7 = null;
    L33:
        if (r7 == null) goto L35;
        Boolean r8 = Boolean.valueOf(r7.getAsBoolean());
    L37:
        if (r8 == null) goto L83;
        boolean r1 = r8.booleanValue();
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L41
        ((Keva) c.getValue()).storeBoolean("cached_enabled", r1);     // Catch: Throwable -> L41
        Object r2 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L41
    L43:
        Throwable r10 = Result.exceptionOrNull-impl(r2);
        if (r10 == null) goto L46;
        FLogger.a.w("CocreationReviewEntryGate", "updateCachedEnabled failed: " + r10.getMessage(), r10);
    L46:
        FLogger.a.d("CocreationReviewEntryGate", "isEnabled: enabled=" + r8 + ", resolved=true, source=config, config=" + r0);
        return new a(r8.booleanValue(), true, "config");
    L41:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L43
    L83:
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L54
        Lazy r13 = c;     // Catch: Throwable -> L54
        if (((Keva) r13.getValue()).contains("cached_enabled") == true) goto L51;
        Boolean r14 = null;
    L52:
        Object r15 = Result.constructor-impl(r14);     // Catch: Throwable -> L54
    L56:
        Throwable r16 = Result.exceptionOrNull-impl(r15);
        if (r16 == null) goto L60;
        FLogger.a.w("CocreationReviewEntryGate", "readCachedEnabled failed: " + r16.getMessage(), r16);
    L60:
        if (Result.isFailure-impl(r15) == true) goto L63;
        r4 = r15;
    L63:
        Boolean r17 = (Boolean) r4;
        String r18 = "null";
        if (r17 == null) goto L73;
        FLogger r19 = FLogger.a;
        StringBuilder r20 = new StringBuilder("isEnabled: enabled=");
        r20.append(r17);
        r20.append(", resolved=true, source=keva, config=");
        if (r0 == null) goto L71;
        String r21 = r0.toString();
        if (r21 == null) goto L71;
        r18 = r21;
    L71:
        r20.append(r18);
        r19.i("CocreationReviewEntryGate", r20.toString());
        return new a(r17.booleanValue(), true, "keva");
    L73:
        FLogger r22 = FLogger.a;
        if (r0 == null) goto L79;
        String r23 = r0.toString();
        if (r23 == null) goto L79;
        r18 = r23;
    L79:
        r22.i("CocreationReviewEntryGate", "isEnabled: enabled=false, resolved=false, source=unknown, config=".concat(r18));
        return new a(false, false, "unknown");
    L51:
        r14 = Boolean.valueOf(((Keva) r13.getValue()).getBoolean("cached_enabled", false));     // Catch: Throwable -> L54
    L54:
        th = move-exception;
        Result.Companion r24 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
    L35:
        r8 = null;
        goto L37
    }
}
