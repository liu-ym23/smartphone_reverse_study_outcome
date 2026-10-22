package com.bytedance.lynx.map.ng;

import androidx.annotation.Keep;
import com.lynx.tasm.behavior.a;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public class BehaviorGenerator {
    public BehaviorGenerator() {
    }

    public static List<a> getBehaviors() {
        ArrayList r5 = new ArrayList();
        String r10 = "x-map-marker-ng";
        boolean r12 = false;
        r5.add(new lm.a(r10, r12, true, r12, 2));
        r5.add(new lm.a("x-map-ng", r12, r12, r12, 3));
        return r5;
    }
}
