package com.lynx.xelement.input;

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
        r5.add(new lm.a("x-textarea-ng", false, false, true, 4));
        r5.add(new lm.a("x-input-ng", false, false, true, 5));
        return r5;
    }
}
