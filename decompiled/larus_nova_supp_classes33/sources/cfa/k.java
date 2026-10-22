package cfa;

import com.obric.assistant.interaction.api.window.animation.WindowAnimationType;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class k {
    public static final WindowAnimationType a(String r4) {
        Object r0 = null;
        if (r4 == null) goto L5;
        String r5 = StringsKt.trim(r4).toString();
    L6:
        if (r5 != null) goto L8;
        r5 = "";
    L8:
        Iterator r1 = WindowAnimationType.getEntries().iterator();
    L10:
        if (r1.hasNext() == false) goto L14;
        Object r2 = r1.next();
        if (Intrinsics.areEqual(((WindowAnimationType) r2).getSerializedValue(), r5) == false) goto L10;
        r0 = r2;
    L14:
        WindowAnimationType r3 = (WindowAnimationType) r0;
        if (r3 == null) goto L17;
        return r3;
    L17:
        return WindowAnimationType.None;
    L5:
        r5 = null;
        goto L6
    }
}
