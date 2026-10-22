package com.bytedance.forest.postprocessor;

import com.bytedance.forest.model.ResourceFrom;
import com.bytedance.forest.model.w;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4548a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f4549b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f4550c;
    public final Map d;
    public final ResourceFrom e;
    public final ResourceFrom f;
    public boolean g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f4551h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final w f4552i;

    public f(w r5) {
        this.f4552i = r5;
        r5.f4441q.getScene();
        this.f4548a = r5.f4441q.getUrl();
        r5.f4441q.getUri$forest_release();
        this.f4549b = r5.f4441q.getOriginUrl();
        r5.f4441q.getOriginUri();
        r5.f4441q.getGeckoModel();
        this.f4550c = r5.f4441q.isPreload();
        this.d = r5.f;
        this.e = r5.f4444u;
        this.f = r5.f4445v;
        this.f4551h = LazyKt.lazy(new ProcessableData$dataStream$2(this));
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L4;
        return true;
    L4:
        if ((r5 instanceof f) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f4552i, ((f) r5).f4552i) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        w r5 = this.f4552i;
        if (r5 != null) goto L5;
        return 0;
    L5:
        return r5.hashCode();
    }

    public final String toString() {
        return "ProcessableData(response=" + this.f4552i + ")";
    }
}
