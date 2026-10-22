package hq9;

import com.google.gson.Gson;
import com.larus.im.bean.message.Message;
import com.larus.platform.model.CollectionDetail;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class k0 {
    public static final Message a(CollectionDetail r49) {
        Intrinsics.checkNotNullParameter(r49, "<this>");
        Gson r2 = new Gson();
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L5
        Object r0 = Result.constructor-impl((Message) r2.fromJson(r49.getSnapshot(), Message.class));     // Catch: Throwable -> L5
    L8:
        if (Result.isFailure-impl(r0) == false) goto L10;
        r0 = null;
    L10:
        Message r4 = (Message) r0;
        if (r4 == null) goto L26;
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Map r1 = r4.getExt();
        if (r1 == null) goto L19;
        String r5 = (String) r1.get("before_content_type");
        if (r5 == null) goto L19;
        Integer r6 = StringsKt.toIntOrNull(r5);
        if (r6 == null) goto L19;
        int r11 = r6.intValue();
    L20:
        if (r11 <= 0) goto L23;
        return Message.copy$default(r4, null, null, null, 0, 0, null, r11, true, null, null, null, null, null, null, null, null, 0, 0, false, null, null, null, null, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -193, 31, null);
    L23:
        return r4;
    L19:
        r11 = 0;
        goto L20
    L26:
        return null;
    L5:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r0 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }
}
