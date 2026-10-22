package com.bytedance.ies.xelement.banner;

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
        r5.add(new lm.a("x-swiper", false, true, false, 6));
        r5.add(new lm.a("swiper-item", false, true, false, 7));
        r5.add(new lm.a("x-swiper-item", false, true, false, 8));
        return r5;
    }
}
