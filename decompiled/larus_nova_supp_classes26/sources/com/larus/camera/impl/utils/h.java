package com.larus.camera.impl.utils;

import android.animation.Animator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class h {
    public final Set<Animator> a;
    public boolean b;

    public final void a() {
        this.b = false;
        CollectionsKt.removeAll(this.a, new g());
    }

    public h() {
        this.a = new LinkedHashSet();
    }
}
