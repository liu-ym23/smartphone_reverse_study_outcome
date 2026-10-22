package com.bytedance.ies.bullet.core;

import com.bytedance.ies.bullet.ui.common.BulletCardView;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f5288b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f5289a;

    static {
        f5288b = new d();
    }

    public d() {
        this.f5289a = new LinkedHashMap();
    }

    public final void a(String r5, BulletCardView r10) {
        Intrinsics.checkNotNullParameter(r10, "bulletContainer");
        LinkedHashMap r11 = this.f5289a;
        Map r12 = (Map) r11.get(r5);
        if (r12 == null) goto L5;
        com.bytedance.ies.bullet.core.container.e r13 = (com.bytedance.ies.bullet.core.container.e) r12.remove(String.valueOf(r10.hashCode()));
    L5:
        Iterator r14 = r11.entrySet().iterator();
    L7:
        if (r14.hasNext() == false) goto L9;
        ((Map) ((Map.Entry) r14.next()).getValue()).remove(String.valueOf(r10.hashCode()));
        goto L7
    }
}
