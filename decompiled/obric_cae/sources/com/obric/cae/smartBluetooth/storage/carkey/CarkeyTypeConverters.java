package com.obric.cae.smartBluetooth.storage.carkey;

import ha.j;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import oa.a;

/* JADX INFO: loaded from: classes.dex */
public class CarkeyTypeConverters {
    private static final j GSON = null;
    private static final Type STRING_LIST_TYPE = null;

    static {
        GSON = new j();
        STRING_LIST_TYPE = new AnonymousClass1().getType();
    }

    public CarkeyTypeConverters() {
    }

    public static String fromStringList(List<String> r8) {
        if (r8 != null) goto L6;
        return null;
    L6:
        return GSON.j(r8);
    }

    public static List<String> toStringList(String r8) {
        if (r8 == null) goto L11;
        if (r8.isEmpty() == true) goto L11;
        j r10 = GSON;
        Type r11 = STRING_LIST_TYPE;
        r10.getClass();
        List<String> r12 = (List) r10.d(r8, a.get(r11));
        if (r12 == null) goto L9;
        return r12;
    L9:
        return new ArrayList();
    L11:
        return new ArrayList();
    }
}
