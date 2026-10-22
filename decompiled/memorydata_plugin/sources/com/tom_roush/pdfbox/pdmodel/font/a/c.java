package com.tom_roush.pdfbox.pdmodel.font.a;

import androidx.recyclerview.widget.ItemTouchHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public abstract class c implements com.tom_roush.pdfbox.pdmodel.common.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final Map<Integer, String> f16215a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final Map<String, Integer> f16216b;

    public c() {
        this.f16215a = new HashMap(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION);
        this.f16216b = new HashMap(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION);
    }

    public static c a(com.tom_roush.pdfbox.a.i r1) {
        if (com.tom_roush.pdfbox.a.i.hB.equals(r1) == false) goto L7;
        return h.c;
    L7:
        if (com.tom_roush.pdfbox.a.i.je.equals(r1) == false) goto L11;
        return k.c;
    L11:
        if (com.tom_roush.pdfbox.a.i.eN.equals(r1) == false) goto L15;
        return g.d;
    L15:
        if (com.tom_roush.pdfbox.a.i.eM.equals(r1) == true) goto L17;
        return null;
    L17:
        return e.c;
    }

    public String a(int r2) {
        String r1 = (String) ZeusTransformUtils.preCheckCast(this.f16215a.get(Integer.valueOf(r2)), String.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L5;
        return r1;
    L5:
        return ".notdef";
    }

    public void a(int r3, String r4) {
        this.f16215a.put(Integer.valueOf(r3), r4);
        if (this.f16216b.containsKey(r4) == true) goto L6;
        this.f16216b.put(r4, Integer.valueOf(r3));
        return;
    }

    public boolean a(String r1) {
        return this.f16216b.containsKey(r1);
    }

    public void b(int r5, String r6) {
        String r0 = (String) ZeusTransformUtils.preCheckCast(this.f16215a.get(Integer.valueOf(r5)), String.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L9;
        Integer r1 = (Integer) ZeusTransformUtils.preCheckCast(this.f16216b.get(r0), Integer.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L9;
        if (r1.intValue() != r5) goto L9;
        this.f16216b.remove(r0);
    L9:
        this.f16216b.put(r6, Integer.valueOf(r5));
        this.f16215a.put(Integer.valueOf(r5), r6);
    }

    public Map<Integer, String> c() {
        return Collections.unmodifiableMap(this.f16215a);
    }

    public Map<String, Integer> d() {
        return Collections.unmodifiableMap(this.f16216b);
    }
}
