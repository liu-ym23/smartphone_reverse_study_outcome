package com.obric.memorydata.utils;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0018\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/utils/ContextAwarenessEntryGate;", "", "<init>", "()V", "isForcedMissing", "", "hasEntry", "shortOSVersion", "", "osReleaseDate", "", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f13248a = null;

    static {
        f13248a = new l();
    }

    private l() {
    }

    public final boolean a() {
        return k.a();
    }

    public final boolean a(String r1, int r2) {
        if (a() == false) goto L5;
    L7:
        return false;
    L5:
        if (m.f13249a.a(r1, r2) == false) goto L7;
        return true;
    }
}
