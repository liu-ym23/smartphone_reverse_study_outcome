package com.bytedance.ies.xelement.viewpager.childitem;

import androidx.annotation.Keep;
import com.lynx.tasm.behavior.a;
import java.util.ArrayList;
import java.util.List;
import ye.b;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public class BehaviorGenerator {
    public BehaviorGenerator() {
    }

    public static List<a> getBehaviors() {
        ArrayList r5 = new ArrayList();
        r5.add(new lm.a("x-viewpager-item-pro", false, true, false, 23));
        r5.add(new lm.a("x-viewpager-item", false, true, false, 26));
        r5.add(new lm.a("x-viewpager-item-ng", false, true, false, 27));
        r5.add(new lm.a("x-foldview-ng", false, true, false, 28));
        r5.add(new lm.a("x-foldview-slot-ng", false, true, false, 29));
        r5.add(new b("x-foldview", false, true, false, 0));
        r5.add(new b("x-foldview-pro", false, true, false, 1));
        r5.add(new b("x-foldview-toolbar", false, true, false, 2));
        r5.add(new b("x-foldview-toolbar-pro", false, true, false, 3));
        r5.add(new lm.a("x-foldview-toolbar-ng", false, true, false, 13));
        r5.add(new lm.a("x-viewpager", false, true, false, 14));
        r5.add(new lm.a("x-viewpager-pro", false, true, false, 15));
        r5.add(new lm.a("x-foldview-header", false, true, false, 16));
        r5.add(new lm.a("x-foldview-header-pro", false, true, false, 17));
        r5.add(new lm.a("x-foldview-header-ng", false, true, false, 18));
        r5.add(new lm.a("x-tabbar-item", false, true, false, 19));
        r5.add(new lm.a("x-tabbar-item-pro", false, true, false, 20));
        r5.add(new lm.a("x-foldview-slot-drag-ng", false, true, false, 21));
        r5.add(new lm.a("x-viewpager-ng", false, true, false, 22));
        r5.add(new lm.a("x-tabbar", false, true, false, 24));
        r5.add(new lm.a("x-tabbar-pro", false, true, false, 25));
        return r5;
    }
}
