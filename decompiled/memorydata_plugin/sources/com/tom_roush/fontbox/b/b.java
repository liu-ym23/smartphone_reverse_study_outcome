package com.tom_roush.fontbox.b;

import androidx.recyclerview.widget.ItemTouchHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f15902a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<Integer, Integer> f15903b;
    private final Map<Integer, Integer> c;
    private final Map<String, Integer> d;
    private final Map<Integer, Integer> e;
    private final Map<Integer, String> f;

    b(boolean r3) {
        this.f15903b = new HashMap(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION);
        this.c = new HashMap(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION);
        this.d = new HashMap(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION);
        this.e = new HashMap();
        this.f = new HashMap(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION);
        this.f15902a = r3;
    }

    int a(int r2) {
        if (this.f15902a == true) goto L11;
        Integer r1 = (Integer) ZeusTransformUtils.preCheckCast(this.c.get(Integer.valueOf(r2)), Integer.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L9;
        return 0;
    L9:
        return r1.intValue();
    L11:
        throw new IllegalStateException("Not a Type 1-equivalent font");
    }

    int a(String r2) {
        if (this.f15902a == true) goto L11;
        Integer r1 = (Integer) ZeusTransformUtils.preCheckCast(this.d.get(r2), Integer.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L9;
        return 0;
    L9:
        return r1.intValue();
    L11:
        throw new IllegalStateException("Not a Type 1-equivalent font");
    }

    public void a(int r4, int r5) {
        if (this.f15902a == false) goto L7;
        this.f15903b.put(Integer.valueOf(r5), Integer.valueOf(r4));
        this.e.put(Integer.valueOf(r4), Integer.valueOf(r5));
        return;
    L7:
        throw new IllegalStateException("Not a CIDFont");
    }

    public void a(int r4, int r5, String r6) {
        if (this.f15902a == true) goto L7;
        this.f15903b.put(Integer.valueOf(r5), Integer.valueOf(r4));
        this.c.put(Integer.valueOf(r4), Integer.valueOf(r5));
        this.d.put(r6, Integer.valueOf(r5));
        this.f.put(Integer.valueOf(r4), r6);
        return;
    L7:
        throw new IllegalStateException("Not a Type 1-equivalent font");
    }

    public boolean a() {
        return this.f15902a;
    }

    int b(int r2) {
        if (this.f15902a == true) goto L11;
        Integer r1 = (Integer) ZeusTransformUtils.preCheckCast(this.f15903b.get(Integer.valueOf(r2)), Integer.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L9;
        return 0;
    L9:
        return r1.intValue();
    L11:
        throw new IllegalStateException("Not a Type 1-equivalent font");
    }

    public int c(int r2) {
        if (this.f15902a == false) goto L11;
        Integer r1 = (Integer) ZeusTransformUtils.preCheckCast(this.f15903b.get(Integer.valueOf(r2)), Integer.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L9;
        return 0;
    L9:
        return r1.intValue();
    L11:
        throw new IllegalStateException("Not a CIDFont");
    }
}
