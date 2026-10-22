package com.lynx.tasm.ui.image;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static b f11024c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set f11025a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f11026b;

    public b() {
        this.f11026b = new a(this);
        this.f11025a = Collections.newSetFromMap(new ConcurrentHashMap());
    }
}
