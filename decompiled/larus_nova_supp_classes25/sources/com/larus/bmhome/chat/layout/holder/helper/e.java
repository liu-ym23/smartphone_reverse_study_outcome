package com.larus.bmhome.chat.layout.holder.helper;

import com.larus.im.bean.bot.AnswerAction;
import com.larus.im.bean.message.Message;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class e {
    public static final List<ot8.a> b(List<? extends ot8.a> r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (ce8.c.a() == false) goto L27;
        ArrayList r0 = new ArrayList();
        Iterator<T> r6 = r5.iterator();
    L6:
        if (r6.hasNext() == false) goto L21;
        Object r1 = r6.next();
        ot8.a r2 = (ot8.a) r1;
        if (r2.getId() != 2131907405) goto L10;
    L17:
        boolean r3 = true;
    L18:
        if (r3 == false) goto L6;
        r0.add(r1);
        goto L6
    L10:
        if (r2.getId() == 2131907403) goto L17;
        if (r2.getId() == 2131907401) goto L17;
        if (r2.getId() == 2131907407) goto L17;
        r3 = false;
        goto L18
    L21:
        return r0;
    L27:
        return r5;
    }

    public static final List<AnswerAction> a(List<AnswerAction> r4, Message r5) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, "message");
        if (com.larus.im.bean.message.a.d0(r5) == false) goto L31;
        ArrayList r6 = new ArrayList();
        Iterator<T> r7 = r4.iterator();
    L6:
        if (r7.hasNext() == false) goto L25;
        Object r0 = r7.next();
        AnswerAction r1 = (AnswerAction) r0;
        if (Intrinsics.areEqual(r1.getKey(), "copy") == false) goto L10;
    L21:
        boolean r2 = true;
    L22:
        if (r2 == false) goto L6;
        r6.add(r0);
        goto L6
    L10:
        if (Intrinsics.areEqual(r1.getKey(), "select-text") == true) goto L21;
        if (Intrinsics.areEqual(r1.getKey(), "tts") == true) goto L21;
        if (Intrinsics.areEqual(r1.getKey(), "create-conversation") == true) goto L21;
        if (Intrinsics.areEqual(r1.getKey(), "report") == true) goto L21;
        if (Intrinsics.areEqual(r1.getKey(), "delete") == true) goto L21;
        r2 = false;
        goto L22
    L25:
        return r6;
    L31:
        return r4;
    }

    public static final List<AnswerAction> c(List<AnswerAction> r6, Message r7) {
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r7, "message");
        Regex r1 = com.larus.bmhome.chat.bean.d.a;
        Intrinsics.checkNotNullParameter(r7, "<this>");
        if (com.larus.bmhome.chat.bean.d.x(r7).isCrowdTest() == true) goto L5;
    L7:
        boolean r8 = false;
    L8:
        if (r8 == false) goto L27;
        ArrayList r9 = new ArrayList();
        Iterator<T> r10 = r6.iterator();
    L11:
        if (r10.hasNext() == false) goto L21;
        Object r0 = r10.next();
        AnswerAction r3 = (AnswerAction) r0;
        if (Intrinsics.areEqual(r3.getKey(), "create-conversation") == false) goto L15;
    L17:
        boolean r4 = false;
    L18:
        if (r4 == false) goto L11;
        r9.add(r0);
        goto L11
    L15:
        if (Intrinsics.areEqual(r3.getKey(), "quote-reply") == true) goto L17;
        r4 = true;
        goto L18
    L21:
        return r9;
    L27:
        return r6;
    L5:
        if (r7.isNewBlockType() == false) goto L7;
        r8 = true;
        goto L8
    }

    public static final List<AnswerAction> d(List<AnswerAction> r4, Message r5) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, "data");
        if (com.larus.im.bean.message.a.g0(r5) == false) goto L31;
        ArrayList r6 = new ArrayList();
        Iterator<T> r7 = r4.iterator();
    L6:
        if (r7.hasNext() == false) goto L25;
        Object r0 = r7.next();
        AnswerAction r1 = (AnswerAction) r0;
        if (Intrinsics.areEqual(r1.getKey(), "like") == false) goto L10;
    L21:
        boolean r2 = true;
    L22:
        if (r2 == false) goto L6;
        r6.add(r0);
        goto L6
    L10:
        if (Intrinsics.areEqual(r1.getKey(), "dislike") == true) goto L21;
        if (Intrinsics.areEqual(r1.getKey(), "tts") == true) goto L21;
        if (Intrinsics.areEqual(r1.getKey(), "share") == true) goto L21;
        if (Intrinsics.areEqual(r1.getKey(), "report") == true) goto L21;
        if (Intrinsics.areEqual(r1.getKey(), "delete") == true) goto L21;
        r2 = false;
        goto L22
    L25:
        return r6;
    L31:
        return r4;
    }

    public static final List<AnswerAction> e(List<AnswerAction> r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        ArrayList r0 = new ArrayList();
        Iterator<T> r6 = r4.iterator();
    L4:
        if (r6.hasNext() == false) goto L14;
        Object r1 = r6.next();
        AnswerAction r2 = (AnswerAction) r1;
        if (r5 == true) goto L8;
    L11:
        boolean r3 = true;
    L12:
        if (r3 == false) goto L4;
        r0.add(r1);
        goto L4
    L8:
        if (Intrinsics.areEqual(r2.getKey(), "delete") == false) goto L11;
        r3 = false;
        goto L12
    L14:
        return r0;
    }

    public static final List<AnswerAction> f(List<AnswerAction> r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        ArrayList r0 = new ArrayList();
        Iterator<T> r7 = r5.iterator();
    L4:
        if (r7.hasNext() == false) goto L16;
        Object r1 = r7.next();
        AnswerAction r2 = (AnswerAction) r1;
        if (r6 == true) goto L8;
    L13:
        boolean r3 = true;
    L14:
        if (r3 == false) goto L4;
        r0.add(r1);
        goto L4
    L8:
        if (Intrinsics.areEqual(r2.getKey(), "share") == false) goto L10;
    L12:
        r3 = false;
        goto L14
    L10:
        if (Intrinsics.areEqual(r2.getKey(), "delete") == true) goto L12;
    L16:
        return r0;
    }

    public static final List<AnswerAction> g(List<AnswerAction> r4, Message r5) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, "message");
        if (com.larus.bmhome.chat.bean.d.v0(r5) == false) goto L27;
        ArrayList r6 = new ArrayList();
        Iterator<T> r7 = r4.iterator();
    L6:
        if (r7.hasNext() == false) goto L21;
        Object r0 = r7.next();
        AnswerAction r1 = (AnswerAction) r0;
        if (Intrinsics.areEqual(r1.getKey(), "copy") == false) goto L10;
    L17:
        boolean r2 = true;
    L18:
        if (r2 == false) goto L6;
        r6.add(r0);
        goto L6
    L10:
        if (Intrinsics.areEqual(r1.getKey(), "select-text") == true) goto L17;
        if (Intrinsics.areEqual(r1.getKey(), "report") == true) goto L17;
        if (Intrinsics.areEqual(r1.getKey(), "delete") == true) goto L17;
        r2 = false;
        goto L18
    L21:
        return r6;
    L27:
        return r4;
    }

    public static final List<AnswerAction> h(List<AnswerAction> r3, List<String> r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "keys");
        ArrayList r0 = new ArrayList();
        Iterator<T> r5 = r3.iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        Object r1 = r5.next();
        if ((!CollectionsKt.contains(r4, ((AnswerAction) r1).getKey())) == false) goto L4;
        r0.add(r1);
        goto L4
    L8:
        return r0;
    }

    public static final List<AnswerAction> i(List<AnswerAction> r4, Message r5) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, "message");
        if (com.larus.im.bean.message.a.B0(r5) == false) goto L35;
        ArrayList r6 = new ArrayList();
        Iterator<T> r7 = r4.iterator();
    L6:
        if (r7.hasNext() == false) goto L29;
        Object r0 = r7.next();
        AnswerAction r1 = (AnswerAction) r0;
        if (Intrinsics.areEqual(r1.getKey(), "copy") == false) goto L10;
    L25:
        boolean r2 = true;
    L26:
        if (r2 == false) goto L6;
        r6.add(r0);
        goto L6
    L10:
        if (Intrinsics.areEqual(r1.getKey(), "tts") == true) goto L25;
        if (Intrinsics.areEqual(r1.getKey(), "quote-reply") == true) goto L25;
        if (Intrinsics.areEqual(r1.getKey(), "select-text") == true) goto L25;
        if (Intrinsics.areEqual(r1.getKey(), "like") == true) goto L25;
        if (Intrinsics.areEqual(r1.getKey(), "dislike") == true) goto L25;
        if (Intrinsics.areEqual(r1.getKey(), "report") == true) goto L25;
        if (Intrinsics.areEqual(r1.getKey(), "delete") == true) goto L25;
        r2 = false;
        goto L26
    L29:
        return r6;
    L35:
        return r4;
    }
}
