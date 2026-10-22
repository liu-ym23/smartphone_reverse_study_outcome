package com.bytedance.lego.init;

import com.bytedance.lego.init.model.ExecutionPeriod;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LinkedHashMap f6751a = null;

    static {
        f6751a = new LinkedHashMap();
    }

    public static void a(ExecutionPeriod r5) {
        List r10 = (List) f6751a.get(r5);
        if (r10 == null) goto L9;
        Iterator r11 = r10.iterator();
        if (r11.hasNext() == true) goto L8;
        return;
    L8:
        throw androidx.constraintlayout.motion.widget.a.g(r11);
    }
}
