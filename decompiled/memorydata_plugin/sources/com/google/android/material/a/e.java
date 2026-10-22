package com.google.android.material.a;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Property;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class e extends Property<Drawable, Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Property<Drawable, Integer> f3745a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final WeakHashMap<Drawable, Integer> f3746b;

    static {
        f3745a = new e();
    }

    private e() {
        super(Integer.class, "drawableAlphaCompat");
        this.f3746b = new WeakHashMap();
    }

    public Integer a(Drawable r3) {
        if (Build.VERSION.SDK_INT < 19) goto L7;
        return Integer.valueOf(r3.getAlpha());
    L7:
        if (this.f3746b.containsKey(r3) == false) goto L11;
        return (Integer) ZeusTransformUtils.preCheckCast(this.f3746b.get(r3), Integer.class, "com.obric.memorydata.plugin");
    L11:
        return 255;
    }

    public void a(Drawable r3, Integer r4) {
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        this.f3746b.put(r3, r4);
    L5:
        r3.setAlpha(r4.intValue());
    }

    @Override // android.util.Property
    public /* synthetic */ Integer get(Drawable r3) {
        return a((Drawable) ZeusTransformUtils.preCheckCast(r3, Drawable.class, "com.obric.memorydata.plugin"));
    }

    @Override // android.util.Property
    public /* synthetic */ void set(Drawable r3, Integer r4) {
        a((Drawable) ZeusTransformUtils.preCheckCast(r3, Drawable.class, "com.obric.memorydata.plugin"), (Integer) ZeusTransformUtils.preCheckCast(r4, Integer.class, "com.obric.memorydata.plugin"));
    }
}
