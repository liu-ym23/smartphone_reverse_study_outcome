package com.bytedance.android.livesdk.event;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a0 {
    public final List<l> a;
    public final List<l> b;

    public static final class a<T> implements Comparator {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(Object r1, Object r2) {
            return Intrinsics.compare(((l) r1).getStart(), ((l) r2).getStart());
        }
    }

    public final String a() {
        JSONArray r0 = new JSONArray();
        ArrayList r1 = new ArrayList();
        List<l> r2 = this.a;
        if (r2 == null) goto L5;
        r1.addAll(r2);
    L5:
        List<l> r3 = this.b;
        if (r3 == null) goto L8;
        r1.addAll(r3);
    L8:
        Collections.sort(r1, a.a);
        Iterator r4 = r1.iterator();
    L10:
        if (r4.hasNext() == false) goto L13;
        l r5 = (l) r4.next();
        JSONObject r6 = new JSONObject();
        r6.put("type", r5.getType());
        r6.put("value", r5.getValue());
        r6.put("start", r5.getStart());
        r6.put("length", r5.getLength());
        r0.put(r6);
        goto L10
    L13:
        if (r0.length() != 0) goto L17;
        return null;
    L17:
        return r0.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a0(List<? extends l> r1, List<? extends l> r2) {
        this.a = r1;
        this.b = r2;
    }
}
