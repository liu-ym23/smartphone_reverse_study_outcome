package com.obric.assistant.task.skill;

import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class d {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean a(String r4) {
        if (r4 != null) goto L5;
        return false;
    L5:
        if (StringsKt.startsWith$default(r4, "obric_phone_operation_skill_", false, 2, null) != true) goto L9;
        return true;
    L9:
        return false;
    }
}
