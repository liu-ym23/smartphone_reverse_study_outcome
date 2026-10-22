package hp8;

import com.google.gson.reflect.TypeToken;
import com.larus.bmhome.chat.tips.GuidePriority;
import com.larus.im.bean.message.ExpiredInfo;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.NestedFileContent;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.im.internal.delegate.c0;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import lr8.c;
import zd9.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {

    /* JADX INFO: renamed from: hp8.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0000"}, d2 = {"com/larus/im/internal/core/util/GsonHolder$fromJson$1$1", "Lcom/google/gson/reflect/TypeToken;", "runtime_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class C0112a extends TypeToken<NestedFileContent> {
        public C0112a() {
        }
    }

    public static final NestedFileContent a(String r11) {
        boolean r1 = false;
        if (r11 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == true) goto L11;
        h r4 = h.a;     // Catch: Throwable -> L35
        if (r11 != null) goto L15;
    L16:
        r1 = true;
    L17:
        Object r2 = null;
        if (r1 == false) goto L40;
    L31:
        NestedFileContent r5 = (NestedFileContent) r2;     // Catch: Throwable -> L35
        if (r5 != null) goto L42;
        return new NestedFileContent(new ArrayList(), null, false, null, 14, null);
    L42:
        return r5;
    L40:
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L22
        r4.getClass();     // Catch: Throwable -> L22
        Object r12 = Result.constructor-impl(h.b.fromJson(r11, new C0112a().getType()));     // Catch: Throwable -> L22
    L24:
        Throwable r7 = Result.exceptionOrNull-impl(r12);     // Catch: Throwable -> L35
        if (r7 == null) goto L28;
        c0 r8 = c0.b;     // Catch: Throwable -> L35
        StringBuilder r9 = new StringBuilder("fromJson failed, stack: ");     // Catch: Throwable -> L35
        Intrinsics.checkNotNullParameter(r7, "<this>");     // Catch: Throwable -> L35
        r9.append(ExceptionsKt.stackTraceToString(r7));     // Catch: Throwable -> L35
        r8.e("GsonHolder", r9.toString());     // Catch: Throwable -> L35
    L28:
        if (Result.isFailure-impl(r12) == true) goto L31;
        r2 = r12;
        goto L31
    L22:
        th = move-exception;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L35
        r12 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L35
        goto L24
    L15:
        if (StringsKt.isBlank(r11) == false) goto L17;
    L35:
        th = move-exception;
        FLogger.a.e("ChatMessageExt", "convertNestedFileContent error " + th.getMessage());
        return new NestedFileContent(new ArrayList(), null, false, null, 14, null);
    L11:
        return new NestedFileContent(new ArrayList(), null, false, null, 14, null);
    L5:
        if (r11.length() == 0) goto L8;
        r3 = false;
        goto L9
    }

    public static final boolean b(Message r9) {
        if (c(r9) == false) goto L51;
        if (r9 == null) goto L8;
        Map r0 = r9.getExt();
        if (r0 == null) goto L8;
        String r1 = (String) r0.get("dora_e_message_status");
    L10:
        if (Intrinsics.areEqual(r1, "expired") == true) goto L43;
        if (r9 == null) goto L41;
        String r10 = r9.getContent();
        if (r10 == null) goto L41;
        List r11 = a(r10).getEntities();
        if (r11 == null) goto L41;
        List r12 = r11;
        if ((r12 instanceof Collection) == true) goto L19;
    L21:
        Iterator r13 = r12.iterator();
    L23:
        if (r13.hasNext() == false) goto L20;
        UplinkFileEntity r2 = (UplinkFileEntity) r13.next();
        long r3 = System.currentTimeMillis() / ((long) GuidePriority.COMMERCE_CREDIT_PRIORITY);
        ExpiredInfo r4 = r2.getExpiredInfo();
        if (r4 == null) goto L29;
        Long r5 = r4.getExpireTime();
        if (r5 == null) goto L29;
        long r6 = r5.longValue();
    L31:
        if (r6 < 1735660800) goto L32;
        if (r3 < r6) goto L36;
        boolean r7 = true;
    L37:
        if (r7 == false) goto L23;
        boolean r14 = true;
    L39:
        if (r14 != true) goto L41;
        boolean r15 = true;
    L42:
        if (r15 == true) goto L43;
        return false;
    L36:
        r7 = false;
        goto L37
    L32:
        return false;
    L29:
        r6 = Long.MIN_VALUE;
    L20:
        r14 = false;
        goto L39
    L19:
        if (r12.isEmpty() == false) goto L21;
    L41:
        r15 = false;
    L43:
        return true;
    L8:
        r1 = null;
        goto L10
    L51:
        return false;
    }

    public static final boolean c(Message r2) {
        if (d(r2) == true) goto L5;
    L12:
        return false;
    L5:
        if (r2 != null) goto L7;
    L9:
        boolean r3 = false;
    L10:
        if (r3 == false) goto L12;
        return true;
    L7:
        if (c.a(r2) != true) goto L9;
        r3 = true;
        goto L10
    }

    public static final boolean d(Message r1) {
        if (r1 == null) goto L6;
        Map r2 = r1.getExt();
        if (r2 == null) goto L6;
        String r3 = (String) r2.get("dora_vision_ext");
    L7:
        if (r3 == null) goto L10;
        return true;
    L10:
        return false;
    L6:
        r3 = null;
        goto L7
    }
}
