package com.bytedance.ies.xelement.overlay;

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
        boolean r10 = false;
        r5.add(new com.bytedance.ai.applet.components.view.b("x-overlay", r10, r10, r10, 5));
        return r5;
    }
}
