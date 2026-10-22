package com.bytedance.ies.xelement.nested.scrollview;

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
        boolean r12 = false;
        boolean r11 = true;
        r5.add(new lm.a("x-nested-scroll-view", r12, r11, r12, 9));
        r5.add(new lm.a("nested-scroll-view", r12, r11, r12, 10));
        return r5;
    }
}
