package com.ss.android.lark.conditional.access.nopermission.manager;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.FieldNamingStrategy;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Locale;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class l implements FieldNamingStrategy {
    public static final l a = null;

    static {
        a = new l();
    }

    public l() {
    }

    public final String translateName(Field r8) {
        List r9 = StringsKt.split$default(r8.getName(), new String[]{"_"}, false, 0, 6, null);
        StringBuilder r0 = new StringBuilder((String) ListProtector.get(r9, 0));
        if (r9.size() <= 1) goto L8;
        int r2 = r9.size();
        int r4 = 1;
    L5:
        if (r4 >= r2) goto L8;
        r0.append(((String) ListProtector.get(r9, r4)).substring(0, 1).toUpperCase(Locale.getDefault()));
        r0.append(((String) ListProtector.get(r9, r4)).substring(1));
        r4 = r4 + 1;
    L8:
        return r0.toString();
    }
}
