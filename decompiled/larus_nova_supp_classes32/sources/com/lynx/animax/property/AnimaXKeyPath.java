package com.lynx.animax.property;

import com.lynx.animax.base.bridge.JavaOnlyArray;
import com.lynx.animax.util.AnimaXLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class AnimaXKeyPath {
    public final JavaOnlyArray a;

    public final List<String> a() {
        ArrayList r0 = new ArrayList();
        Iterator<Object> r1 = this.a.iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        Object r2 = r1.next();
        if ((r2 instanceof String) == false) goto L4;
        r0.add((String) r2);
        goto L4
    L8:
        return r0;
    }

    public final String toString() {
        return "KeyPath{keys=" + a().toString() + "}";
    }

    public JavaOnlyArray getKeys() {
        return this.a;
    }

    public AnimaXKeyPath(String... r5) {
        this.a = new JavaOnlyArray();
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L12;
        String r2 = r5[r1];
        if (r2 != null) goto L7;
    L10:
        AnimaXLog.b("AnimaXKeyPath", "AnimaXKeyPath received a null or empty key, which will be ignored.");
    L11:
        r1 = r1 + 1;
        goto L3
    L7:
        if (r2.isEmpty() == true) goto L10;
        this.a.pushString(r2);
        goto L11
    }

    public AnimaXKeyPath(JavaOnlyArray r1) {
        this.a = r1;
    }
}
