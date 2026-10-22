package com.obric.memorydata.awareness.cae;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/awareness/cae/PoiEventPolicy;", "", "<init>", "()V", "shouldSuppress", "", "locationType", "", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f8599a = null;

    static {
        f8599a = new h();
    }

    private h() {
    }

    public final boolean a(String r1) {
        if (Intrinsics.areEqual(r1, "home") == false) goto L5;
    L8:
        return true;
    L5:
        if (Intrinsics.areEqual(r1, "company") == true) goto L8;
        return false;
    }
}
