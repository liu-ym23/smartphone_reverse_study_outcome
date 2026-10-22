package com.lynx.component.svg;

import androidx.annotation.Keep;
import com.lynx.serval.svg.SVGRenderEngine;
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
        r5.add(new lm.a(SVGRenderEngine.SVG, false, true, false, 0));
        r5.add(new lm.a("x-svg", false, true, false, 1));
        return r5;
    }
}
