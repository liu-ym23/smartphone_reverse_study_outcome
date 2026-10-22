package com.obric.assistant.task.skill;

import com.larus.bmhome.actionbar.model.ModelItemIdentity;
import com.larus.bmhome.actionbar.model.ReplyOption;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class n {
    public static final boolean a(ModelItemIdentity r2) {
        AtomicBoolean r0 = m.a;
        String r1 = null;
        if (r2 == null) goto L5;
        Integer r3 = Integer.valueOf(r2.getDeprecatedItemId());
    L7:
        if (m.j(r3) == true) goto L14;
        if (r2 == null) goto L11;
        r1 = r2.getKey();
    L11:
        if (m.k(r1) == true) goto L14;
        return false;
    L14:
        return true;
    L5:
        r3 = null;
        goto L7
    }

    public static final boolean b(ReplyOption r2) {
        if (r2 != null) goto L5;
        return false;
    L5:
        AtomicBoolean r1 = m.a;
        if (m.k(r2.getModeId()) == false) goto L8;
    L9:
        return true;
    L8:
        if (a(r2.getModel()) == true) goto L9;
        return false;
    }
}
