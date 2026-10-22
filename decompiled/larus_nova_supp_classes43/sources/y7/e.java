package y7;

import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.debug.ui.DialogItem;
import java.util.LinkedList;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e implements d {
    public e() {
    }

    @Override // y7.d
    public final String getTitle() {
        return "LYNX";
    }

    @Override // y7.d
    public final List<DialogItem> a() {
        LinkedList r0 = new LinkedList();
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L5
        Object r11 = Result.constructor-impl(((r9.c) Annie.getService$default(r9.c.class, null, 2, null)).A());     // Catch: Throwable -> L5
    L8:
        if (Result.isFailure-impl(r11) == false) goto L10;
        r11 = null;
    L10:
        String r12 = (String) r11;
        String r13 = "-";
        if (r12 != null) goto L13;
        r12 = "-";
    L13:
        r0.add(new DialogItem("Lynx Version", r12, null, 4));
    L20:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        Object r1 = Result.constructor-impl(ResultKt.createFailure(th));
    L23:
        if (Result.isFailure-impl(r1) == false) goto L25;
        r1 = null;
    L25:
        String r15 = (String) r1;
        if (r15 == null) goto L29;
        r13 = r15;
    L29:
        r0.add(new DialogItem("Lynx JS引擎", r13, null, 4));
        return r0;
    L15:
        if (((r9.c) Annie.getService$default(r9.c.class, null, 2, null)).R() == false) goto L17;
        String r16 = "v8";
    L18:
        r1 = Result.constructor-impl(r16);     // Catch: Throwable -> L20
        goto L23
    L17:
        r16 = "QuickJS";
    L5:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }
}
