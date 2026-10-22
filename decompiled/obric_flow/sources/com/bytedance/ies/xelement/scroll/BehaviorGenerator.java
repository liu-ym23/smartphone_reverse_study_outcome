package com.bytedance.ies.xelement.scroll;

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
        r5.add(new lm.a("x-scroll-view", r12, r11, r12, 11));
        r5.add(new lm.a("x-bounce-view", r12, r11, r12, 12));
        return r5;
    }
}
