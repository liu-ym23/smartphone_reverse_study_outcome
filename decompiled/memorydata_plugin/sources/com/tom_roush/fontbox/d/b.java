package com.tom_roush.fontbox.d;

import androidx.recyclerview.widget.ItemTouchHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Map<Integer, String> f15961a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected Map<String, Integer> f15962b;

    public b() {
        this.f15961a = new HashMap(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION);
        this.f15962b = new HashMap(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION);
    }

    public String a(int r2) {
        String r1 = (String) ZeusTransformUtils.preCheckCast(this.f15961a.get(Integer.valueOf(r2)), String.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L5;
        return r1;
    L5:
        return ".notdef";
    }

    public void a(int r3, String r4) {
        this.f15961a.put(Integer.valueOf(r3), r4);
        this.f15962b.put(r4, Integer.valueOf(r3));
    }

    public Map<Integer, String> b() {
        return Collections.unmodifiableMap(this.f15961a);
    }
}
