package com.lynx.tasm.behavior.ui.scroll;

import androidx.annotation.Keep;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public class BehaviorGenerator {
    public BehaviorGenerator() {
    }

    public static List<com.lynx.tasm.behavior.a> getBehaviors() {
        ArrayList r5 = new ArrayList();
        r5.add(new com.ivy.ivykit.plugin.impl.render.a("scroll-view-new-arch", false, false, false, 28));
        r5.add(new com.ivy.ivykit.plugin.impl.render.a("swiper", false, true, false, 29));
        return r5;
    }
}
