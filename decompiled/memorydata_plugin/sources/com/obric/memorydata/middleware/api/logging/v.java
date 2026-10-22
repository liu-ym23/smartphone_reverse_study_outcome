package com.obric.memorydata.middleware.api.logging;

import com.bytedance.crash.entity.EventBody;
import com.bytedance.security.dbcipher.utils.CipherConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/middleware/api/logging/TraceKind;", "", "<init>", "()V", "MAIN", "", CipherConst.LEVEL_ERROR, "isSupported", "", EventBody.KEY_VALUE, "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v f11637a = null;

    static {
        f11637a = new v();
    }

    private v() {
    }

    public final boolean a(String r1) {
        Intrinsics.checkNotNullParameter(r1, EventBody.KEY_VALUE);
        if (Intrinsics.areEqual(r1, "main_trace") == false) goto L5;
    L8:
        return true;
    L5:
        if (Intrinsics.areEqual(r1, "error_trace") == true) goto L8;
        return false;
    }
}
