package com.tencent.open.b;

import android.os.Bundle;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public class c implements Serializable {
    public final HashMap<String, String> a;

    public String toString() {
        return "BaseData{time=" + this.a.get("time") + ", name=" + this.a.get("interface_name") + '}';
    }

    public c(Bundle r5) {
        this.a = new HashMap();
        if (r5 == null) goto L8;
        Iterator<String> r0 = r5.keySet().iterator();
    L6:
        if (r0.hasNext() == false) goto L10;
        String r1 = r0.next();
        this.a.put(r1, r5.getString(r1));
        goto L6
    L10:
        return;
    }

    public c(HashMap<String, String> r2) {
        this.a = new HashMap(r2);
    }
}
