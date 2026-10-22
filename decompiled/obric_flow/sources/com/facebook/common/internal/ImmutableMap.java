package com.facebook.common.internal;

import com.facebook.infer.annotation.Nullsafe;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@Nullsafe(Nullsafe.Mode.STRICT)
public class ImmutableMap<K, V> extends HashMap<K, V> {
    public ImmutableMap(HashMap r5) {
        super(r5);
    }

    public static Map a(String r5, String r10) {
        HashMap r11 = new HashMap(1);
        r11.put(r5, r10);
        return Collections.unmodifiableMap(r11);
    }

    public static Map a(String r5, String r10, String r11, String r12) {
        HashMap r13 = new HashMap(2);
        r13.put(r5, r10);
        r13.put(r11, r12);
        return Collections.unmodifiableMap(r13);
    }
}
