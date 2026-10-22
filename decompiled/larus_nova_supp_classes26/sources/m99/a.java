package m99;

import com.google.gson.reflect.TypeToken;
import com.larus.extension.summary_card.api.model.SummaryCardMessageContent;
import com.larus.flow.video.bean.CommonVideoModel;
import com.larus.im.bean.message.Message;
import com.larus.im.internal.delegate.c0;
import com.larus.platform.uimodel.MediaEntity;
import com.larus.platform.uimodel.MediaEntityContainer;
import com.larus.utils.o0;
import java.util.ArrayList;
import java.util.Map;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import zd9.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {

    /* JADX INFO: renamed from: m99.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0000"}, d2 = {"com/larus/im/internal/core/util/GsonHolder$fromJson$1$1", "Lcom/google/gson/reflect/TypeToken;", "runtime_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class C0118a extends TypeToken<SummaryCardMessageContent> {
        public C0118a() {
        }
    }

    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0000"}, d2 = {"com/larus/im/internal/core/util/GsonHolder$fromJson$1$1", "Lcom/google/gson/reflect/TypeToken;", "runtime_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b extends TypeToken<SummaryCardMessageContent> {
        public b() {
        }
    }

    public static final String a(Message r7) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Object r3 = null;
        if (f(r7) == false) goto L43;
        Map r2 = r7.getExt();
        if (r2 == null) goto L46;
        String r4 = (String) r2.get("feed_video_summary");
        if (r4 == null) goto L46;
        return r4;
    L46:
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L33
        h r6 = h.a;     // Catch: Throwable -> L33
        String r8 = r7.getContent();     // Catch: Throwable -> L33
        if (r8 != null) goto L11;
    L14:
        boolean r9 = true;
    L15:
        if (r9 == false) goto L44;
    L16:
        Object r10 = null;
    L27:
        SummaryCardMessageContent r11 = (SummaryCardMessageContent) r10;     // Catch: Throwable -> L33
        if (r11 == null) goto L30;
        String r12 = r11.getContent();     // Catch: Throwable -> L33
    L31:
        Object r13 = Result.constructor-impl(r12);     // Catch: Throwable -> L33
    L36:
        if (Result.isFailure-impl(r13) == true) goto L39;
        r3 = r13;
    L39:
        String r14 = (String) r3;
        if (r14 != null) goto L49;
        return "";
    L49:
        return r14;
    L30:
        r12 = null;
        goto L31
    L44:
        r6.getClass();     // Catch: Throwable -> L19
        r10 = Result.constructor-impl(h.b.fromJson(r8, new C0118a().getType()));     // Catch: Throwable -> L19
    L21:
        Throwable r15 = Result.exceptionOrNull-impl(r10);     // Catch: Throwable -> L33
        if (r15 == null) goto L25;
        c0 r16 = c0.b;     // Catch: Throwable -> L33
        StringBuilder r17 = new StringBuilder("fromJson failed, stack: ");     // Catch: Throwable -> L33
        Intrinsics.checkNotNullParameter(r15, "<this>");     // Catch: Throwable -> L33
        r17.append(ExceptionsKt.stackTraceToString(r15));     // Catch: Throwable -> L33
        r16.e("GsonHolder", r17.toString());     // Catch: Throwable -> L33
    L25:
        if (Result.isFailure-impl(r10) == false) goto L27;
    L19:
        th = move-exception;
        Result.Companion r18 = Result.Companion;     // Catch: Throwable -> L33
        r10 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L33
        goto L21
    L11:
        if (StringsKt.isBlank(r8) == true) goto L14;
        r9 = false;
    L33:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L36
    L43:
        return null;
    }

    public static final String b(Message r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        if (f(r3) == false) goto L19;
        Map r0 = r3.getExt();
        if (r0 == null) goto L7;
        String r1 = (String) r0.get("feed_video_summary_item_id");
    L8:
        if (r1 != null) goto L17;
        CommonVideoModel.a r2 = CommonVideoModel.Companion;
        String r4 = r3.getContent();
        r2.getClass();
        MediaEntityContainer r5 = CommonVideoModel.a.a(r4);
        if (r5 == null) goto L24;
        ArrayList r6 = r5.getVideo_list();
        if (r6 == null) goto L25;
        MediaEntity r7 = (MediaEntity) CollectionsKt.getOrNull(r6, 0);
        if (r7 != null) goto L27;
        return null;
    L27:
        return r7.getItem_id();
    L25:
        return null;
    L24:
        return null;
    L17:
        return r1;
    L7:
        r1 = null;
        goto L8
    L19:
        if (e(r3) == false) goto L28;
        Map r8 = r3.getBusinessExt();
        if (r8 != null) goto L23;
        return null;
    L23:
        return (String) r8.get("feed_video_summary_item_id");
    L28:
        return null;
    }

    public static final String c(Message r7) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Object r3 = null;
        if (f(r7) == false) goto L45;
        Map r2 = r7.getExt();
        if (r2 == null) goto L46;
        String r4 = (String) r2.get("feed_video_summary_source");
        if (r4 == null) goto L46;
        return r4;
    L46:
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L35
        h r6 = h.a;     // Catch: Throwable -> L35
        String r8 = r7.getContent();     // Catch: Throwable -> L35
        if (r8 != null) goto L11;
    L14:
        boolean r9 = true;
    L15:
        if (r9 == false) goto L48;
    L26:
        Object r10 = null;
    L27:
        SummaryCardMessageContent r11 = (SummaryCardMessageContent) r10;     // Catch: Throwable -> L35
        if (r11 == null) goto L32;
        Integer r12 = r11.getSource();     // Catch: Throwable -> L35
        if (r12 == null) goto L32;
        String r13 = r12.toString();     // Catch: Throwable -> L35
    L33:
        Object r14 = Result.constructor-impl(r13);     // Catch: Throwable -> L35
    L38:
        if (Result.isFailure-impl(r14) == true) goto L41;
        r3 = r14;
    L41:
        String r15 = (String) r3;
        if (r15 != null) goto L51;
        return "";
    L51:
        return r15;
    L32:
        r13 = null;
        goto L33
    L48:
        r6.getClass();     // Catch: Throwable -> L19
        r10 = Result.constructor-impl(h.b.fromJson(r8, new b().getType()));     // Catch: Throwable -> L19
    L21:
        Throwable r16 = Result.exceptionOrNull-impl(r10);     // Catch: Throwable -> L35
        if (r16 == null) goto L25;
        c0 r17 = c0.b;     // Catch: Throwable -> L35
        StringBuilder r18 = new StringBuilder("fromJson failed, stack: ");     // Catch: Throwable -> L35
        Intrinsics.checkNotNullParameter(r16, "<this>");     // Catch: Throwable -> L35
        r18.append(ExceptionsKt.stackTraceToString(r16));     // Catch: Throwable -> L35
        r17.e("GsonHolder", r18.toString());     // Catch: Throwable -> L35
    L25:
        if (Result.isFailure-impl(r10) == false) goto L27;
    L19:
        th = move-exception;
        Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L35
        r10 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L35
        goto L21
    L11:
        if (StringsKt.isBlank(r8) == true) goto L14;
        r9 = false;
    L35:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L38
    L45:
        return null;
    }

    public static final boolean d(Message r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (f(r1) == true) goto L5;
        return false;
    L5:
        if (o0.d(r1.getMessageId()) == false) goto L7;
        return true;
    L7:
        Map r2 = r1.getExt();
        if (r2 == null) goto L10;
        String r3 = (String) r2.get("feed_summary_expand");
    L12:
        return Intrinsics.areEqual(r3, "1");
    L10:
        r3 = null;
        goto L12
    }

    public static final boolean e(Message r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r5.getContentType() != 2) goto L13;
        String r6 = r5.getLocalMessageId();
        if (r6 != null) goto L7;
    L9:
        boolean r7 = false;
    L10:
        if (r7 == false) goto L14;
        return true;
    L14:
        return false;
    L7:
        if (StringsKt.contains$default(r6, "-aweme", false, 2, null) != true) goto L9;
        r7 = true;
        goto L10
    L13:
        return false;
    }

    public static final boolean f(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (r2.getContentType() == 800) goto L5;
        return false;
    L5:
        if (Intrinsics.areEqual(r2.getBizContentType(), "video_summary") == false) goto L10;
        return true;
    L10:
        return false;
    }
}
