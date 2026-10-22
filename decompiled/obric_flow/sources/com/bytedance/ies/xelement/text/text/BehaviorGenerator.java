package com.bytedance.ies.xelement.text.text;

import androidx.annotation.Keep;
import com.bytedance.ai.applet.components.view.b;
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
        String r10 = "x-text";
        boolean r14 = false;
        r5.add(new b(r10, r14, true, r14, 6));
        r5.add(new b("x-inline-image", r14, r14, r14, 7));
        r5.add(new b("x-inline-truncation", r14, r14, r14, 8));
        r5.add(new b("x-inline-text", r14, r14, r14, 9));
        return r5;
    }
}
