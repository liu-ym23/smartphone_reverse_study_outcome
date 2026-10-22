package com.ivy.ivykit.plugin.impl.render;

import com.lynx.serval.svg.SVGRenderEngine;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map f9523a = null;

    static {
        List r5 = CollectionsKt.listOf(new com.lynx.tasm.behavior.a[]{new com.bytedance.ai.applet.components.view.b("x-text", false, false, false, 22), new a("x-textarea", false, false, false, 3), new a("x-input", false, false, false, 7), new a("x-viewpager-ng", false, false, false, 8), new a("x-viewpager-item-ng", false, false, false, 9), new a("input", false, false, false, 10), new a("canvas", false, false, false, 11), new b("canvas-ng", false, false, false), new a("x-overlay", false, false, false, 12), new com.bytedance.ai.applet.components.view.b("x-scroll-view", false, false, false, 12), new com.bytedance.ai.applet.components.view.b("x-nested-scroll-view", false, false, false, 13), new com.bytedance.ai.applet.components.view.b("x-viewpager", false, false, false, 14), new com.bytedance.ai.applet.components.view.b("x-viewpager-item", false, false, false, 15), new com.bytedance.ai.applet.components.view.b("lola-canvas", false, false, false, 16), new com.bytedance.ai.applet.components.view.b("x-bounce-view", false, false, false, 17), new com.bytedance.ai.applet.components.view.b("x-impression-view", false, false, false, 18), new com.bytedance.ai.applet.components.view.b("x-inline-truncation", false, false, false, 19), new com.bytedance.ai.applet.components.view.b("x-inline-text", false, false, false, 20), new com.bytedance.ai.applet.components.view.b("x-inline-image", false, false, false, 21), new com.bytedance.ai.applet.components.view.b("x-swiper", false, false, false, 23), new com.bytedance.ai.applet.components.view.b("x-swiper-item", false, false, false, 24), new com.bytedance.ai.applet.components.view.b("swiper", false, false, false, 25), new com.bytedance.ai.applet.components.view.b("swiper-item", false, false, false, 26), new com.bytedance.ai.applet.components.view.b(SVGRenderEngine.SVG, false, false, false, 27), new com.bytedance.ai.applet.components.view.b("x-tabbar-pro", false, false, false, 28), new com.bytedance.ai.applet.components.view.b("x-tabbar-item-pro", false, false, false, 29), new a("x-tabbar", false, false, false, 0), new a("x-tabbar-item", false, false, false, 1), new a("textarea", false, false, false, 2), new a("x-map", false, false, false, 4), new a("x-map-ng", false, false, false, 5), new a("animax-view", false, false, false, 6)});
        LinkedHashMap r10 = new LinkedHashMap(androidx.constraintlayout.motion.widget.a.e(r5, 16));
        Iterator r11 = r5.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        Object r12 = r11.next();
        r10.put(((com.lynx.tasm.behavior.a) r12).f10172a, r12);
        goto L4
    L6:
        f9523a = MapsKt.toMutableMap(r10);
    }
}
