package com.bytedance.android.livesdk.ktvapi.config;

import android.graphics.Paint;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class ScrollLyricConfigV2 extends com.bytedance.android.livesdk.ktvapi.config.a {
    public static final int t = 0;
    public Integer f;
    public Integer g;
    public Integer h;
    public int i;
    public final NextLiveData<Float> j;
    public final ArrayList<WeakReference<Function1<Integer, Unit>>> k;
    public int l;
    public int m;
    public final NextLiveData<Integer> n;
    public boolean o;
    public boolean p;
    public boolean q;
    public boolean r;
    public boolean s;

    public static final class a {
    }

    static {
        t = (int) UtilityKotlinExtentionsKt.h(350);
    }

    public final void a() {
        float r1 = 23;
        this.b.setTextSize(UtilityKotlinExtentionsKt.m(r1));
        this.c.setTextSize(UtilityKotlinExtentionsKt.m(r1));
        this.d.setTextSize(UtilityKotlinExtentionsKt.m(17));
    }

    public ScrollLyricConfigV2() {
        this.j = new NextLiveData();
        this.k = new ArrayList();
        this.l = 7;
        this.n = new NextLiveData();
        this.p = true;
        this.r = true;
        this.s = true;
        AnonymousClass1 r1 = AnonymousClass1.INSTANCE;
        Intrinsics.checkNotNullParameter(r1, "func");
        r1.invoke(this.c);
        this.a = t / this.l;
        AnonymousClass2 r2 = AnonymousClass2.INSTANCE;
        Intrinsics.checkNotNullParameter(r2, "func");
        r2.invoke(this.b);
        Paint r3 = this.d;
        r3.setTextSize(UtilityKotlinExtentionsKt.h(17));
        r3.setStrokeWidth(1.0f);
        r3.setAntiAlias(true);
        r3.setLetterSpacing(0.05f);
        r3.setTextAlign(Paint.Align.CENTER);
        r3.setColor(ColorProtector.parseColor("#C9ffffff"));
    }

    public final void b(int r4) {
        this.i = r4;
        Iterator<T> r0 = this.k.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Function1 r1 = (Function1) ((WeakReference) r0.next()).get();
        if (r1 == null) goto L4;
        Unit r2 = (Unit) r1.invoke(Integer.valueOf(r4));
        goto L4
    }
}
