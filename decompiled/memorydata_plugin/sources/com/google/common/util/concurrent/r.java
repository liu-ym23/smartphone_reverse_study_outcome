package com.google.common.util.concurrent;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes2.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f4869a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ReentrantLock f4870b;
    private a c;

    public static abstract class a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final r f4871b;
        final Condition c;
        int d;

        public a(r r4) {
            this.d = 0;
            this.f4871b = (r) ZeusTransformUtils.preCheckCast(com.google.common.base.n.a(r4, CommonConsts.LOG_REPORT_TYPE_DEFAULT), r.class, "com.obric.memorydata.plugin");
            this.c = r.a(r4).newCondition();
        }
    }

    public r() {
        this(false);
    }

    public r(boolean r2) {
        this.c = null;
        this.f4869a = r2;
        this.f4870b = new ReentrantLock(r2);
    }

    static /* synthetic */ ReentrantLock a(r r0) {
        return r0.f4870b;
    }
}
