package com.bytedance.android.live.effect.composer;

import com.bytedance.android.live.effect.api.ILiveEffectComposerManager;
import com.bytedance.android.live.effect.base.setting.LiveEffectSettings;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class n {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final boolean e;
    public final boolean f;
    public long g;
    public final List<Integer> h;
    public final List<p> i;
    public boolean j;
    public String k;
    public ILiveEffectComposerManager.EffectInstanceType l;

    public final String toString() {
        return "LiveComposerNode(panel='" + this.a + "', effectId='" + this.b + "', resourceId='" + this.c + "', path='" + this.d + "', isWithoutFace=" + this.e + ", isHighCost=" + this.f + ", updateTime=" + this.g + ", coexistGroup=" + this.h + ", tagList=" + this.i + ", use=" + this.j + ')';
    }

    public final String a() {
        return this.b;
    }

    public final String b() {
        return this.a;
    }

    public final List<p> c() {
        return this.i;
    }

    public final long d() {
        return this.g;
    }

    public n(n r8) {
        Intrinsics.checkNotNullParameter(r8, "node");
        ArrayList r1 = new ArrayList();
        this.h = r1;
        ArrayList r2 = new ArrayList();
        this.i = r2;
        this.k = "";
        this.l = ILiveEffectComposerManager.EffectInstanceType.DEFAULT;
        this.a = r8.a;
        this.b = r8.b;
        this.c = r8.c;
        this.d = r8.d;
        this.e = r8.e;
        this.f = r8.f;
        this.g = r8.g;
        this.j = r8.j;
        r1.addAll(r8.h);
        List<p> r3 = r8.i;
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator<T> r5 = r3.iterator();
    L4:
        if (r5.hasNext() == false) goto L9;
        p r6 = (p) r5.next();
        if (LiveEffectSettings.LIVE_EFFECT_ENABLE_COMPOSER_TAG_NODE_DEEP_COPY.getValue().booleanValue() == false) goto L8;
        Intrinsics.checkNotNullParameter(r6, "node");
        p r7 = new p(r6.b);
        r7.a = r6.a;
        r6 = r7;
    L8:
        r4.add(r6);
        goto L4
    L9:
        r2.addAll(r4);
        this.l = r8.l;
    }

    public n(String r2, String r3, String r4, String r5, boolean r6, boolean r7, long r8) {
        Intrinsics.checkNotNullParameter(r2, "panel");
        Intrinsics.checkNotNullParameter(r3, "effectId");
        Intrinsics.checkNotNullParameter(r4, "resourceId");
        Intrinsics.checkNotNullParameter(r5, "path");
        this.h = new ArrayList();
        this.i = new ArrayList();
        this.k = "";
        this.l = ILiveEffectComposerManager.EffectInstanceType.DEFAULT;
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
    }
}
