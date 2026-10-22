package kr9;

import com.google.gson.Gson;
import com.larus.im.bean.message.Message;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a {
    public static final List<Message> a(List<String> r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        ArrayList r0 = new ArrayList();
        Iterator<T> r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L24;
        String r1 = (String) r5.next();
        if (r1 != null) goto L8;
    L11:
        boolean r2 = true;
    L12:
        if (r2 == true) goto L4;
        Gson r3 = new Gson();
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L16
        Object r7 = Result.constructor-impl((Message) r3.fromJson(r1, Message.class));     // Catch: Throwable -> L16
    L19:
        if (Result.isFailure-impl(r7) == false) goto L21;
        r7 = null;
    L21:
        Message r8 = (Message) r7;
        if (r8 == null) goto L4;
        r0.add(r8);
    L16:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L19
    L8:
        if (r1.length() == 0) goto L11;
        r2 = false;
        goto L12
    L24:
        CollectionsKt.reverse(r0);
        return r0;
    }
}
