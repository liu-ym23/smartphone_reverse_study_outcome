package rc8;

import com.google.gson.reflect.TypeToken;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.internal.delegate.c0;
import java.util.Map;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import zd9.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class d {

    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0000"}, d2 = {"com/larus/im/internal/core/util/GsonHolder$fromJson$1$1", "Lcom/google/gson/reflect/TypeToken;", "runtime_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final class a extends TypeToken<e> {
        public a() {
        }
    }

    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0000"}, d2 = {"com/larus/im/internal/core/util/GsonHolder$fromJson$1$1", "Lcom/google/gson/reflect/TypeToken;", "runtime_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final class b extends TypeToken<f> {
        public b() {
        }
    }

    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0000"}, d2 = {"com/larus/im/internal/core/util/GsonHolder$fromJson$1$1", "Lcom/google/gson/reflect/TypeToken;", "runtime_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final class c extends TypeToken<Map<String, ? extends String>> {
        public c() {
        }
    }

    public static final e a(rc8.c r7) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Object r2 = null;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L24
        h r4 = h.a;     // Catch: Throwable -> L24
        String r8 = r7.f;     // Catch: Throwable -> L24
        if (r8 != null) goto L6;
    L9:
        boolean r5 = true;
    L10:
        if (r5 == false) goto L32;
    L11:
        Object r9 = null;
    L22:
        Object r10 = Result.constructor-impl((e) r9);     // Catch: Throwable -> L24
    L27:
        if (Result.isFailure-impl(r10) == true) goto L31;
        r2 = r10;
    L31:
        return (e) r2;
    L32:
        r4.getClass();     // Catch: Throwable -> L14
        r9 = Result.constructor-impl(h.b.fromJson(r8, new a().getType()));     // Catch: Throwable -> L14
    L16:
        Throwable r6 = Result.exceptionOrNull-impl(r9);     // Catch: Throwable -> L24
        if (r6 == null) goto L20;
        c0 r11 = c0.b;     // Catch: Throwable -> L24
        StringBuilder r12 = new StringBuilder("fromJson failed, stack: ");     // Catch: Throwable -> L24
        Intrinsics.checkNotNullParameter(r6, "<this>");     // Catch: Throwable -> L24
        r12.append(ExceptionsKt.stackTraceToString(r6));     // Catch: Throwable -> L24
        r11.e("GsonHolder", r12.toString());     // Catch: Throwable -> L24
    L20:
        if (Result.isFailure-impl(r9) == false) goto L22;
    L14:
        th = move-exception;
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L24
        r9 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L24
        goto L16
    L6:
        if (StringsKt.isBlank(r8) == true) goto L9;
        r5 = false;
    L24:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L27
    }

    public static final f b(String r6) {
        if (r6 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        boolean r1 = true ^ r2;
        Object r3 = null;
        if (r1 == true) goto L13;
        r6 = null;
    L13:
        if (r6 == null) goto L41;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L29
        h r5 = h.a;     // Catch: Throwable -> L29
        if (StringsKt.isBlank(r6) == false) goto L39;
    L16:
        Object r7 = null;
    L27:
        Object r8 = Result.constructor-impl((f) r7);     // Catch: Throwable -> L29
    L32:
        if (Result.isFailure-impl(r8) == true) goto L36;
        r3 = r8;
    L36:
        return (f) r3;
    L39:
        r5.getClass();     // Catch: Throwable -> L19
        r7 = Result.constructor-impl(h.b.fromJson(r6, new b().getType()));     // Catch: Throwable -> L19
    L21:
        Throwable r9 = Result.exceptionOrNull-impl(r7);     // Catch: Throwable -> L29
        if (r9 == null) goto L25;
        c0 r10 = c0.b;     // Catch: Throwable -> L29
        StringBuilder r11 = new StringBuilder("fromJson failed, stack: ");     // Catch: Throwable -> L29
        Intrinsics.checkNotNullParameter(r9, "<this>");     // Catch: Throwable -> L29
        r11.append(ExceptionsKt.stackTraceToString(r9));     // Catch: Throwable -> L29
        r10.e("GsonHolder", r11.toString());     // Catch: Throwable -> L29
    L25:
        if (Result.isFailure-impl(r7) == false) goto L27;
    L19:
        th = move-exception;
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L29
        r7 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L32
    L41:
        return null;
    L5:
        if (StringsKt.isBlank(r6) == true) goto L8;
        r2 = false;
        goto L9
    }

    public static final Map<String, String> c(String r7) {
        if (r7 != null) goto L5;
    L8:
        boolean r2 = true;
    L10:
        if ((!r2) == true) goto L13;
        r7 = null;
    L13:
        if (r7 == null) goto L44;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L29
        h r4 = h.a;     // Catch: Throwable -> L29
        if (StringsKt.isBlank(r7) == false) goto L42;
    L16:
        Object r8 = null;
    L27:
        Object r9 = Result.constructor-impl((Map) r8);     // Catch: Throwable -> L29
    L32:
        if (Result.isFailure-impl(r9) == false) goto L34;
        r9 = null;
    L34:
        Map<String, String> r10 = (Map) r9;
        if (r10 != null) goto L37;
        return null;
    L37:
        if ((!r10.isEmpty()) == true) goto L39;
        return null;
    L39:
        return r10;
    L42:
        r4.getClass();     // Catch: Throwable -> L19
        r8 = Result.constructor-impl(h.b.fromJson(r7, new c().getType()));     // Catch: Throwable -> L19
    L21:
        Throwable r5 = Result.exceptionOrNull-impl(r8);     // Catch: Throwable -> L29
        if (r5 == null) goto L25;
        c0 r6 = c0.b;     // Catch: Throwable -> L29
        StringBuilder r11 = new StringBuilder("fromJson failed, stack: ");     // Catch: Throwable -> L29
        Intrinsics.checkNotNullParameter(r5, "<this>");     // Catch: Throwable -> L29
        r11.append(ExceptionsKt.stackTraceToString(r5));     // Catch: Throwable -> L29
        r6.e("GsonHolder", r11.toString());     // Catch: Throwable -> L29
    L25:
        if (Result.isFailure-impl(r8) == false) goto L27;
    L19:
        th = move-exception;
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L29
        r8 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L32
    L44:
        return null;
    L5:
        if (StringsKt.isBlank(r7) == true) goto L8;
        r2 = false;
        goto L10
    }
}
