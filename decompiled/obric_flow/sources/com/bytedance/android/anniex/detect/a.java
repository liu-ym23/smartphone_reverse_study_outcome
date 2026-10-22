package com.bytedance.android.anniex.detect;

import com.bytedance.ies.bullet.base.settings.c;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import xc.e;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f3206a = null;

    static {
        new AnnieXBlankDetectorManager$lastViewHashCodes$1();
        new AnnieXBlankDetectorManager$urlLruCache$1();
        ConcurrentHashMap r5 = yc.a.f23246a;
        Intrinsics.checkNotNullParameter(e.class, "cls");
        e r10 = (e) yc.a.a(e.class, "default_bid");
        if (r10 == null) goto L5;
        c r11 = (c) r10.a(c.class);
    L5:
        f3206a = LazyKt.lazy(AnnieXBlankDetectorManager$blankDetectorConfig$2.f3205a);
    }
}
