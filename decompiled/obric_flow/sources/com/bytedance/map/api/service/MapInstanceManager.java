package com.bytedance.map.api.service;

import android.content.Context;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.map.api.IMapService;

/* JADX INFO: loaded from: classes2.dex */
public class MapInstanceManager implements LifecycleObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f6938a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IMapService f6939b;

    public MapInstanceManager(Context r5) {
        this.f6938a = r5;
        a();
    }

    public final void a() {
        Object r5 = this.f6938a;
        if (r5 != null) goto L6;
        return;
    L6:
        if ((r5 instanceof LifecycleOwner) == false) goto L9;
        ((LifecycleOwner) r5).getLifecycle().addObserver(this);
        return;
    }

    public static IMapService a(String r5) {
        Object r10 = Class.forName(r5).newInstance();     // Catch: Throwable -> L6
        if ((r10 instanceof IMapService) == false) goto L12;
        return (IMapService) r10;
    L12:
        return null;
    L6:
        th = move-exception;
        th.printStackTrace();
        return null;
    }
}
