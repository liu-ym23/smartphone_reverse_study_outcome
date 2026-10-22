package com.bytedance.lynx.media;

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
        boolean r12 = false;
        boolean r11 = true;
        r5.add(new com.bytedance.ai.applet.components.view.b("x-video-engine", r12, r11, r12, 10));
        r5.add(new com.bytedance.ai.applet.components.view.b("x-audio-ng", r12, r11, r12, 11));
        return r5;
    }
}
