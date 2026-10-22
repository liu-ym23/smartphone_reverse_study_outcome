package com.obric.oui.segmentedtab;

import android.content.Context;
import android.util.AttributeSet;
import he.i;
import l6.a;
import qc.c;
import zc.b;

/* JADX INFO: loaded from: classes2.dex */
public final class OSegmentTabView extends c {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static int f6528p;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f6529n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f6530o;

    public OSegmentTabView(Context r8, AttributeSet r10) {
        i.f(r8, "context");
        super(r8, r10, 0);
        StringBuilder r11 = new StringBuilder("OSegmentTabView_");
        int r12 = f6528p;
        f6528p = r12 + 1;
        r11.append(r12);
        this.f6529n = r11.toString();
    }

    @Override // qc.c
    public final boolean a() {
        return true;
    }

    @Override // qc.c
    public final void b(String r8, float r10) {
        b.a(this.f6529n, "onTouchAnimUpdate, scene: " + r8 + ", animFraction: " + r10);
        int r11 = r8.hashCode();
        if (r11 != (-1965932727)) goto L5;
        String r12 = "release_anim";
    L9:
        r8.equals(r12);
    L10:
        a.x((int) ((1 - (r10 * 0.5f)) * this.f6530o), 255);
        i.j("iconView");
        throw null;
    L5:
        if (r11 != 1870923917) goto L10;
        r12 = "press_anim";
        goto L9
    }

    public final void setOriginIconAlpha(int r8) {
        this.f6530o = r8;
    }
}
