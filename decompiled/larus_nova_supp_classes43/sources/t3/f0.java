package t3;

import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.event.MessageIndication;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class f0 {
    public static final <Result extends ResultModel> void a(f3.h<Result> r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, MessageIndication.MESSAGE_TYPE_MSG);
        e0.a.getClass();
        if (r11 != null) goto L5;
        String r0 = "";
    L6:
        String r1 = r0.toLowerCase(Locale.ROOT);
        if (StringsKt.contains$default(r1, "permission denied", false, 2, null) == false) goto L9;
    L61:
        f3.a r12 = f3.a.j;
    L62:
        f3.h.a.a(r10, r11, r12, null, 10);
        return;
    L9:
        if (StringsKt.contains$default(r1, "unauthorized", false, 2, null) == true) goto L61;
        if (StringsKt.contains$default(r1, "invalid", false, 2, null) == false) goto L14;
    L60:
        r12 = f3.a.h;
        goto L62
    L14:
        if (StringsKt.contains$default(r1, "empty", false, 2, null) == true) goto L60;
        if (StringsKt.contains$default(r1, "not support", false, 2, null) == false) goto L19;
    L59:
        r12 = f3.a.g;
        goto L62
    L19:
        if (StringsKt.contains$default(r1, "unsupported", false, 2, null) == true) goto L59;
        if (StringsKt.contains$default(r1, "timeout", false, 2, null) == false) goto L25;
        r12 = f3.a.p;
        goto L62
    L25:
        if (StringsKt.contains$default(r1, "not found", false, 2, null) == false) goto L27;
    L58:
        r12 = f3.a.q;
        goto L62
    L27:
        if (StringsKt.contains$default(r1, "unavailable", false, 2, null) == true) goto L58;
        if (StringsKt.contains$default(r1, "not available", false, 2, null) == true) goto L58;
        if (StringsKt.contains$default(r1, "doesn't exist", false, 2, null) == true) goto L58;
        if (StringsKt.contains$default(r1, "powered off", false, 2, null) == true) goto L58;
        if (StringsKt.contains$default(r1, "disabled", false, 2, null) == true) goto L58;
        if (StringsKt.contains$default(r1, "not initialized", false, 2, null) == true) goto L58;
        if (StringsKt.contains$default(r1, "not started", false, 2, null) == true) goto L58;
        if (StringsKt.contains$default(r1, "not paired", false, 2, null) == true) goto L58;
        if (StringsKt.contains$default(r1, "already", false, 2, null) == false) goto L46;
    L57:
        r12 = f3.a.r;
        goto L62
    L46:
        if (StringsKt.contains$default(r1, "pending", false, 2, null) == true) goto L57;
        if (StringsKt.contains$default(r1, "cancel", false, 2, null) == false) goto L51;
    L56:
        r12 = f3.a.o;
        goto L62
    L51:
        if (StringsKt.contains$default(r1, "closed", false, 2, null) == true) goto L56;
        if (StringsKt.contains$default(r1, "disconnect", false, 2, null) == true) goto L56;
        r12 = f3.a.f;
        goto L62
    L5:
        r0 = r11;
        goto L6
    }
}
