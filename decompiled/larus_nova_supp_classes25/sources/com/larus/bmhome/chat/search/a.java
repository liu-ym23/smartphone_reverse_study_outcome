package com.larus.bmhome.chat.search;

import androidx.collection.LruCache;
import com.larus.bmhome.chat.layout.item.SearchListBox;
import com.larus.im.bean.message.Message;
import com.larus.im.internal.delegate.c0;
import com.larus.utils.logger.FLogger;
import ic8.b0;
import java.util.Map;
import kotlin.ExceptionsKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import oi8.c;
import oi8.e;
import oi8.g;
import oi8.k;
import zd9.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.search.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0072a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[CardType.values().length];
            r0[CardType.Video.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r0[CardType.Image.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r0[CardType.MixedMedia.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[CardType.Unknown.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r0[CardType.Text.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            a = r0;
        }
    }

    static {
    }

    public static SearchBoxStyle a(Message r9) {
        Intrinsics.checkNotNullParameter(r9, "data");
        LruCache<String, k> r0 = SearchListBox.E;
        String r1 = r9.getMessageId();
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        k r2 = SearchListBox.a.a(r1, r9.getContent());
        String r3 = r9.getContent();
        boolean r4 = true;
        if (r3 != null) goto L8;
    L11:
        boolean r5 = true;
    L13:
        if (r5 == true) goto L47;
        String r6 = r9.getContent();
        if (r6 != null) goto L18;
    L20:
        boolean r7 = false;
    L21:
        if (r7 == false) goto L47;
        h r8 = h.a;     // Catch: Throwable -> L42
        String r10 = r9.getContent();     // Catch: Throwable -> L42
        if (r10 != null) goto L25;
    L28:
        if (r4 == false) goto L67;
    L39:
        Object r11 = null;
    L40:
        b0 r12 = (b0) r11;     // Catch: Throwable -> L42
    L48:
        if (r12 == null) goto L50;
        Integer r13 = r12.b();
    L51:
        if (r13 != null) goto L53;
    L60:
        if (r2 == null) goto L64;
        b r14 = r2.e();
        if (r14 == null) goto L64;
        c r15 = r14.b();
    L66:
        return b(r15, null);
    L64:
        r15 = null;
        goto L66
    L53:
        if (r12.a() == null) goto L60;
        if (r2 == null) goto L56;
        r2.f(new b(0));
    L56:
        if (r2 == null) goto L60;
        b r16 = r2.e();
        if (r16 == null) goto L60;
        r16.g(new c(r12.b(), r12.a(), 12));
        goto L60
    L50:
        r13 = null;
        goto L51
    L67:
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L32
        r8.getClass();     // Catch: Throwable -> L32
        r11 = Result.constructor-impl(h.b.fromJson(r10, new g().getType()));     // Catch: Throwable -> L32
    L34:
        Throwable r18 = Result.exceptionOrNull-impl(r11);     // Catch: Throwable -> L42
        if (r18 == null) goto L38;
        c0 r19 = c0.b;     // Catch: Throwable -> L42
        StringBuilder r20 = new StringBuilder("fromJson failed, stack: ");     // Catch: Throwable -> L42
        Intrinsics.checkNotNullParameter(r18, "<this>");     // Catch: Throwable -> L42
        r20.append(ExceptionsKt.stackTraceToString(r18));     // Catch: Throwable -> L42
        r19.e("GsonHolder", r20.toString());     // Catch: Throwable -> L42
    L38:
        if (Result.isFailure-impl(r11) == false) goto L40;
    L32:
        th = move-exception;
        Result.Companion r21 = Result.Companion;     // Catch: Throwable -> L42
        r11 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L42
        goto L34
    L25:
        if (StringsKt.isBlank(r10) == true) goto L28;
        r4 = false;
    L42:
        FLogger r22 = FLogger.a;
        StringBuilder r23 = new StringBuilder("parse abversion struct err! contentLength:");
        String r24 = r9.getContent();
        if (r24 == null) goto L45;
        Integer r25 = Integer.valueOf(r24.length());
    L46:
        r23.append(r25);
        r22.e("SearchListBox", r23.toString());
        goto L47
    L45:
        r25 = null;
        goto L46
    L18:
        if (StringsKt.contains$default(r6, "ABVersion", false, 2, null) != true) goto L20;
        r7 = true;
    L47:
        r12 = null;
        goto L48
    L8:
        if (r3.length() == 0) goto L11;
        r5 = false;
        goto L13
    }

    public static boolean d(Message r1) {
        if (r1 == null) goto L6;
        Map r2 = r1.getExt();
        if (r2 == null) goto L6;
        String r3 = (String) r2.get("has_ugc_card");
    L8:
        return Intrinsics.areEqual(r3, "true");
    L6:
        r3 = null;
        goto L8
    }

    public static boolean e(Message r1) {
        if (r1 == null) goto L6;
        Map r2 = r1.getExt();
        if (r2 == null) goto L6;
        String r3 = (String) r2.get("video_as_ref");
    L8:
        return Intrinsics.areEqual(r3, "1");
    L6:
        r3 = null;
        goto L8
    }

    public static SearchBoxStyle b(c r4, Message r5) {
        if (r4 == null) goto L4;
        e r0 = r4.c();
    L5:
        SearchBoxStyle r6 = c(r0, r5);
        if (r6 == null) goto L8;
        return r6;
    L8:
        if (r4 == null) goto L12;
        Integer r7 = r4.a();
        if (r7 == null) goto L12;
        int r8 = r7.intValue();
    L14:
        if (r4 == null) goto L18;
        Integer r9 = r4.b();
        if (r9 == null) goto L18;
        int r10 = r9.intValue();
    L19:
        if (r8 != 1) goto L24;
        if (r10 != 1) goto L24;
        return SearchBoxStyle.singleRowTiny;
    L24:
        if (r8 != 1) goto L29;
        if (r10 != 3) goto L29;
        return SearchBoxStyle.singleRowNormal;
    L29:
        if (r8 != 2) goto L33;
        if (r10 != 1) goto L33;
        return SearchBoxStyle.singleRowTiny;
    L33:
        if (r8 != 3) goto L38;
        if (r10 != 2) goto L38;
        return SearchBoxStyle.singleRowNormal;
    L38:
        if (r8 != 4) goto L42;
        if (r10 != 1) goto L42;
        return SearchBoxStyle.singleRowTiny;
    L42:
        if (r8 != 4) goto L47;
        if (r10 != 3) goto L47;
        return SearchBoxStyle.singleRowNormal;
    L47:
        if (r8 != 5) goto L51;
        if (r10 != 1) goto L51;
        return SearchBoxStyle.singleRowTiny;
    L51:
        if (r8 != 5) goto L56;
        if (r10 != 2) goto L56;
        return SearchBoxStyle.singleRowTiny;
    L56:
        return SearchBoxStyle.singleRowNormal;
    L18:
        r10 = 1;
    L12:
        r8 = 0;
        goto L14
    L4:
        r0 = null;
        goto L5
    }

    public static SearchBoxStyle c(e r2, Message r3) {
        if (r2 == null) goto L31;
        CardType.a r0 = CardType.Companion;
        Integer r4 = r2.a();
        if (r4 == null) goto L6;
        int r5 = r4.intValue();
    L7:
        r0.getClass();
        CardType r6 = CardType.a.a(r5);
        if (r6 != null) goto L10;
        int r7 = -1;
    L11:
        if (r7 == (-1)) goto L31;
        if (r7 == 1) goto L28;
        if (r7 == 2) goto L34;
        if (r7 == 3) goto L33;
        if (r7 == 4) goto L31;
        if (r7 == 5) goto L31;
        throw new NoWhenBranchMatchedException();
    L33:
        return SearchBoxStyle.doubleColumnMixedMedia;
    L34:
        return SearchBoxStyle.doubleColumnImage;
    L28:
        if (e(r3) == false) goto L36;
        return SearchBoxStyle.singleRowVideoNew;
    L36:
        return SearchBoxStyle.doubleColumnVideo;
    L10:
        r7 = C0072a.a[r6.ordinal()];
        goto L11
    L6:
        r5 = 0;
    L31:
        return null;
    }
}
