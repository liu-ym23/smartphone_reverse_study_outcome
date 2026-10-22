package com.obric.memorydata.utils;

import com.bytedance.crash.entity.EventBody;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/utils/CommonUtils;", "", "<init>", "()V", "isZero", "", EventBody.KEY_VALUE, "", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f13228a = null;

    static {
        f13228a = new i();
    }

    private i() {
    }

    public final boolean a(double r3) {
        if (Math.abs(r3) > 1.0E-4d) goto L5;
        return true;
    L5:
        return false;
    }
}
