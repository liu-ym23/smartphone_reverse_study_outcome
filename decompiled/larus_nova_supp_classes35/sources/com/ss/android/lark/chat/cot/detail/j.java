package com.ss.android.lark.chat.cot.detail;

import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class j {
    public static final /* synthetic */ int b = 0;
    public final HashMap<String, Boolean> a;

    public static final class a {
        public a() {
        }
    }

    static {
        new a();
    }

    public j() {
        this.a = new HashMap();
    }

    public final boolean a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Boolean r3 = this.a.get(r2);
        if (r3 != null) goto L7;
        return false;
    L7:
        return r3.booleanValue();
    }

    public final boolean b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "groupId");
        return a(r2 + "#group");
    }
}
