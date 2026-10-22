package com.bytedance.ies.xelement.input;

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
        r5.add(new com.bytedance.ai.applet.components.view.b("input", false, false, false, 2));
        r5.add(new com.bytedance.ai.applet.components.view.b("x-textarea", false, false, true, 3));
        r5.add(new com.bytedance.ai.applet.components.view.b("x-input", false, false, true, 4));
        return r5;
    }
}
