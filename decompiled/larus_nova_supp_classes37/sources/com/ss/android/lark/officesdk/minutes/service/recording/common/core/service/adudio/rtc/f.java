package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.rtc;

import com.ss.android.lark.storage.kv.repo.KVRepo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class f {
    public final KVRepo a;
    public volatile MmRtcInitInfo b;
    public volatile boolean c;

    public static final class a {
    }

    static {
    }

    public f(KVRepo r2) {
        Intrinsics.checkNotNullParameter(r2, "kvRepo");
        this.a = r2;
    }
}
